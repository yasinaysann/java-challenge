package com.kodgemisi.usermanagement;

public class Language {

	public static final Language TR = new Language("Turkish", "Türkçe", "tr");

	public static final Language EN = new Language("English", "English", "en");

	private final String name;

	private final String nativeName;

	private final String code;

	public Language(String name, String nativeName, String code) {
		this.name = name;
		this.nativeName = nativeName;
		this.code = code;
	}

	@Override
	public String toString() {
		return code;
	}
}
