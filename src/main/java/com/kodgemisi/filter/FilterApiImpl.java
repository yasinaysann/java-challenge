package com.kodgemisi.filter;

import com.kodgemisi.usermanagement.User;
import com.kodgemisi.usermanagement.UserService;

import java.util.List;

public class FilterApiImpl implements FilterApi {

	private final UserService userService;

	public FilterApiImpl(UserService userService) {
		this.userService = userService;
	}

	@Override
	public List<User> unverifiedUnder18() {
		return userService.list(); //FIXME currently returns all the users unfiltered, you should fix this method
	}

	@Override
	public List<User> verifiedWithTrPrimaryPhone() {
		return userService.list(); //FIXME currently returns all the users unfiltered, you should fix this method
	}
}
