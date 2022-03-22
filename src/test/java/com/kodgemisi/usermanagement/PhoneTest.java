package com.kodgemisi.usermanagement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;

class PhoneTest {

    @Test
    void invalidPhoneNumber_null() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new Phone(null), "A phone number cannot be null");
    }

    @Test
    void invalidPhoneNumber_empty() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new Phone(""), "A phone number cannot be empty");
    }

    @Test
    void specialPhoneNumbers_accepted() {
        var phone112 = new Phone("112");
        assertEquals("112", phone112.number(), "may not start with `+` if it's `112` or `911`");
        var phone911 = new Phone("911");
        assertEquals("911", phone911.number(), "may not start with `+` if it's `112` or `911`");
    }

    @Test
    void specialPhoneNumbers_unaccepted() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new Phone("111"), "may not start with `+` if it's `112` or `911`");
        assertThrowsExactly(IllegalArgumentException.class, () -> new Phone("999"), "may not start with `+` if it's `112` or `911`");
    }

    @Test
    void plus90PrefixedPhoneNumbers_13Length() {
        var phone_1 = new Phone("+901234567890");
        assertEquals("+901234567890", phone_1.number(), "should be exactly 13-char long when it starts with `+90`");
        var phone_2 = new Phone("+909876543210");
        assertEquals("+909876543210", phone_2.number(), "should be exactly 13-char long when it starts with `+90`");
    }

    @Test
    void plus90PrefixedPhoneNumbers_not13Length() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new Phone("+90"), "should be exactly 13-char long when it starts with `+90`");
        assertThrowsExactly(IllegalArgumentException.class, () -> new Phone("+90123456"), "should be exactly 13-char long when it starts with `+90`");
        assertThrowsExactly(IllegalArgumentException.class, () -> new Phone("+90123456789"), "should be exactly 13-char long when it starts with `+90`");
        assertThrowsExactly(IllegalArgumentException.class, () -> new Phone("+9012345678901"), "should be exactly 13-char long when it starts with `+90`");
        assertThrowsExactly(IllegalArgumentException.class, () -> new Phone("+9012345678901234"), "should be exactly 13-char long when it starts with `+90`");
    }

    @Test
    void plusPrefixedPhoneNumbers_longEnough() {
        var phone_1 = new Phone("+1234");
        assertEquals("+1234", phone_1.number(), "can be at any length otherwise as long as it adheres other requirements");
        var phone_2 = new Phone("+10987654321");
        assertEquals("+10987654321", phone_2.number(), "can be at any length otherwise as long as it adheres other requirements");
        var phone_3 = new Phone("+391234567890");
        assertEquals("+391234567890", phone_3.number(), "can be at any length otherwise as long as it adheres other requirements");
        var phone_4 = new Phone("+9912345678901");
        assertEquals("+9912345678901", phone_4.number(), "can be at any length otherwise as long as it adheres other requirements");
    }

    @Test
    void plusPrefixedPhoneNumbers_notLongEnough() {
        assertThrowsExactly(IllegalArgumentException.class, () -> new Phone("+"), "A phone number should be at least 5-char long when it starts with +");
        assertThrowsExactly(IllegalArgumentException.class, () -> new Phone("+1"), "A phone number should be at least 5-char long when it starts with +");
        assertThrowsExactly(IllegalArgumentException.class, () -> new Phone("+12"), "A phone number should be at least 5-char long when it starts with +");
        assertThrowsExactly(IllegalArgumentException.class, () -> new Phone("+123"), "A phone number should be at least 5-char long when it starts with +");
    }

}