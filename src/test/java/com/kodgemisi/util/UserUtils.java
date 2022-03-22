package com.kodgemisi.util;

import com.github.javafaker.Faker;
import com.kodgemisi.usermanagement.*;

import java.time.Instant;
import java.util.Set;

public class UserUtils {

    private static final Faker FAKER_INSTANCE = Faker.instance();

    public static User createNewUser() {
        return new User(null,
                createProfile(),
                FAKER_INSTANCE.random().nextInt(99),
                FAKER_INSTANCE.random().nextBoolean(),
                Role.values()[FAKER_INSTANCE.random().nextInt(Role.values().length)],
                Instant.now());
    }

    public static Profile createProfile() {
        return new Profile(
                FAKER_INSTANCE.internet().url(),
                FAKER_INSTANCE.address().fullAddress(),
                createPhone(),
                createEmail(),
                Set.of(createPhone(), createPhone(), createPhone()),
                Set.of(createEmail(), createEmail(), createEmail()),
                createLanguage());
    }

    public static Phone createPhone() {
        return new Phone(FAKER_INSTANCE.phoneNumber().phoneNumber());
    }

    public static Email createEmail() {
        return new Email(FAKER_INSTANCE.internet().emailAddress());
    }

    public static Language createLanguage() {
        return FAKER_INSTANCE.random().nextBoolean() ? Language.EN : Language.TR;
    }

}
