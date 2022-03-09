package com.kodgemisi.usermanagement;

/**
 * Represents an email and its verification status
 */
public class Email implements CharSequence {

	public final String email;

	public final boolean verified;

	public Email(String email) {

		validate(email);

		this.email = email;
		this.verified = false;
	}

	public Email(String email, boolean verified) {

		validate(email);

		this.email = email;
		this.verified = verified;
	}

	private static void validate(String email) {
		if (email == null) {
			throw new IllegalArgumentException("Email cannot be null!");
		}

		if (email.isBlank()) {
			throw new IllegalArgumentException("Email cannot be blank!");
		}

		final int atSignIndex = email.indexOf("@");
		if (atSignIndex == 0 || atSignIndex > email.length() - 4) {
			throw new IllegalArgumentException("Invalid email: '%s'!".formatted(email));
		}
	}

	@Override
	public int length() {
		return email.length();
	}

	@Override
	public char charAt(int index) {
		return email.charAt(index);
	}

	@Override
	public CharSequence subSequence(int start, int end) {
		return email.subSequence(start, end);
	}

	@Override
	public String toString() {
		return email;
	}
}
