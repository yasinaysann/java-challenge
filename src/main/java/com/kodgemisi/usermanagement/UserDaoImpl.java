package com.kodgemisi.usermanagement;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class UserDaoImpl implements UserDao {

	private final AtomicLong userIdSequence = new AtomicLong(1L);

	private final Map<Long, User> userMap = new ConcurrentHashMap<>();

	@Override
	public User create(User user) {

		if (user == null) {
			throw new IllegalArgumentException("User cannot be null!");
		}

		if (!user.isNew()) {
			throw new IllegalArgumentException("You can create only new users! This user object has an id: '%s'!".formatted(user.getId()));
		}

		final long userId = userIdSequence.getAndIncrement();
		user.setId(userId);

		userMap.put(userId, user);
		return user;
	}

	@Override
	public Optional<User> find(Long id) {

		if (id == null) {
			throw new IllegalArgumentException("Id cannot be null!");
		}

		return Optional.ofNullable(userMap.get(id));
	}

	@Override
	public List<User> findAll() {
		return userMap.values().stream().sorted(Comparator.comparingLong(User::getId)).collect(Collectors.toList());
	}

	@Override
	public User update(User user) {
		if (user == null) {
			throw new IllegalArgumentException("User cannot be null!");
		}

		if (user.isNew()) {
			throw new IllegalArgumentException("You can only update existing users (users with id). This user has no id");
		}
		Optional<User> updateUser = find(user.getId());
		if (updateUser.isPresent()){
			updateUser.get().setAge(user.getAge());
			updateUser.get().setProfile(user.getProfile());
			updateUser.get().setRole(user.getRole());
			updateUser.get().setCreatedAt(user.getCreatedAt());
			if (updateUser.get().isVerified() != user.isVerified()){
				updateUser.get().verify();
			}
		}else {
			throw new IllegalArgumentException("User Not Found");
		}

		return userMap.put(user.getId(), updateUser.get());
	}

	@Override
	public void delete(Long id) {
		throw new UnsupportedOperationException("Not implemented!");
	}

}
