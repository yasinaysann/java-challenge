package com.kodgemisi.filter;

import com.kodgemisi.usermanagement.User;

import java.util.List;

public interface FilterApi {

	List<User> unverifiedUnder18();

	List<User> verifiedWithTrPrimaryPhone();

}
