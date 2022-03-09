package com.kodgemisi.usermanagement;

class NoSuchUserException extends RuntimeException {

	public NoSuchUserException(long id) {
		super("No user exists with id '%s'!".formatted(id));
	}
}
