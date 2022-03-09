package com.kodgemisi.usermanagement;

import java.util.List;
import java.util.Optional;

public interface UserDao {

	User create(User user);

	Optional<User> find(Long id);

	List<User> findAll();

	User update(User user);

	void delete(Long id);

}
