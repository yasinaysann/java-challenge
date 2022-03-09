package com.kodgemisi.usermanagement;

import java.util.List;
import java.util.Optional;

public interface UserApi {

	User create(User user);

	User get(Long id);

	Optional<User> find(Long id);

	List<User> list();

	User update(User user);

	void delete(Long id);

	User verify(Long id);

}
