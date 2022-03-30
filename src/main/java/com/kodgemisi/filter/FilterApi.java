package com.kodgemisi.filter;

import com.kodgemisi.usermanagement.User;

import java.util.List;

public interface FilterApi {

	/**
	 * @return returns users which are unverified and under 18 years old
	 */
	List<User> unverifiedUnder18();

	/**
	 * @return returns users which are verified and have TR primary phone number
	 */
	List<User> verifiedWithTrPrimaryPhone();

}
