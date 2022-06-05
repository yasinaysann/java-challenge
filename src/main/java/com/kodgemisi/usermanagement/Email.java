package com.kodgemisi.usermanagement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Represents an email and its verification status
 */
public class Email implements CharSequence {

	public final String email;

	public final boolean verified;

	public Email(String email) {
		this(email,false);
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


		if (getEmailMatcher(email)) {
			throw new IllegalArgumentException("Invalid email: '%s'!".formatted(email));
		}
	}

	private static boolean getEmailMatcher(String email) {
		Pattern emailRegex = Pattern.compile("^[(a-zA-Z-0-9-\\\\_\\\\+\\\\.)]+@[(a-z-A-z)]+\\\\.[(a-zA-z)]{2,3}$");
		Matcher emailMatcher = emailRegex.matcher(email);
		return emailMatcher.matches();
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

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Email email1 = (Email) o;

		if (verified != email1.verified) return false;
		return email.equals(email1.email);
	}

	@Override
	public int hashCode() {
		int result = email.hashCode();
		result = 31 * result + (verified ? 1 : 0);
		return result;
	}
}
