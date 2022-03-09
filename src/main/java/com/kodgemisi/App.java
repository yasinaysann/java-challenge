package com.kodgemisi;

import com.kodgemisi.usermanagement.UserDao;
import com.kodgemisi.usermanagement.UserDaoImpl;

public class App {

	public static void main(String[] args) {
		final UserDao userDao = new UserDaoImpl();

		System.out.println("Generating users...");
		UserGenerator.generate(userDao);
		System.out.println("Generating users: DONE.");
		System.out.println("Listing first 100 users:");
		userDao.findAll().stream().limit(100).forEach(System.out::println);
	}
}
