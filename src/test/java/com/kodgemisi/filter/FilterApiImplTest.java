package com.kodgemisi.filter;

import com.kodgemisi.usermanagement.*;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class FilterApiImplTest {

    @Test
    void unverifiedUnder18() {

        final var userDao = new UserDaoImpl();

        var leonardo = new User(
                null,
                new Profile(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/LEONARDO.JPG/330px-LEONARDO.JPG",
                        "Florence, Italy",
                        new Phone("+902125443614"),
                        new Email("gbacon@verizon.net"),
                        Set.of(new Phone("+763422380839")),
                        Set.of(new Email("psichel@verizon.net")),
                        Language.TR
                ),
                18,
                true,
                Role.ADMIN,
                Instant.now()
        );

        userDao.create(leonardo);

        var raffaello = new User(
                null,
                new Profile(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Raffaello_Sanzio.jpg/330px-Raffaello_Sanzio.jpg",
                        "Urbino, Italy",
                        new Phone("+192242558213"),
                        new Email("arnold@sbcglobal.net"),
                        Set.of(new Phone("+233224582360")),
                        Set.of(new Email("preneel@me.com")),
                        Language.EN
                ),
                18,
                false,
                Role.USER,
                Instant.now()
        );

        userDao.create(raffaello);

        var michelangelo = new User(
                null,
                new Profile(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Miguel_%C3%81ngel%2C_por_Daniele_da_Volterra_%28detalle%29.jpg/330px-Miguel_%C3%81ngel%2C_por_Daniele_da_Volterra_%28detalle%29.jpg",
                        "Tuscany, Italy",
                        new Phone("+952324632733"),
                        new Email("maneesh@att.net"),
                        Set.of(new Phone("+903124406247")),
                        Set.of(new Email("drewf@hotmail.com")),
                        Language.EN
                ),
                23,
                true,
                Role.ANONYMOUS,
                Instant.now()
        );

        userDao.create(michelangelo);

        var donatello = new User(
                null,
                new Profile(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Uffizi_Donatello.jpg/300px-Uffizi_Donatello.jpg",
                        "Florence, Italy",
                        new Phone("+902323732567"),
                        new Email("ijackson@mac.com"),
                        Set.of(new Phone("+773322481010")),
                        Set.of(new Email("josem@aol.com")),
                        Language.TR
                ),
                25,
                false,
                Role.USER,
                Instant.now()
        );

        userDao.create(donatello);

        var faraday = new User(
                null,
                new Profile(
                        "https://upload.wikimedia.org/wikipedia/commons/1/19/Michael_Faraday._Photograph_by_Maull_%26_Polyblank._Wellcome_V0026348.jpg",
                        "Newington Butts, England",
                        new Phone("+905616115132"),
                        new Email("bthomas77@mobisb.site"),
                        Set.of(new Phone("+12509062309")),
                        Set.of(new Email("drmarc@authorizes.me")),
                        Language.EN
                ),
                9,
                true,
                Role.OBSERVER,
                Instant.now()
        );

        userDao.create(faraday);

        var maxwell = new User(
                null,
                new Profile(
                        "https://upload.wikimedia.org/wikipedia/commons/5/57/James_Clerk_Maxwell.png",
                        "Edinburgh, Scotland",
                        new Phone("+905108837548"),
                        new Email("mailforreg2011@supox.site"),
                        Set.of(new Phone("+14037293654")),
                        Set.of(new Email("danielaussilva@onlinecmail.com")),
                        Language.TR
                ),
                11,
                false,
                Role.USER,
                Instant.now()
        );

        userDao.create(maxwell);

        final var userService = new UserService(userDao);
        final var filterApi = new FilterApiImpl(userService);

        var resultList = filterApi.unverifiedUnder18();

        assertTrue(resultList.contains(maxwell));
        assertFalse(resultList.contains(leonardo));
        assertFalse(resultList.contains(raffaello));
        assertFalse(resultList.contains(michelangelo));
        assertFalse(resultList.contains(donatello));
        assertFalse(resultList.contains(faraday));

    }

    @Test
    void verifiedWithTrPrimaryPhone() {

        final var userDao = new UserDaoImpl();

        var leonardo = new User(
                null,
                new Profile(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/c/c3/LEONARDO.JPG/330px-LEONARDO.JPG",
                        "Florence, Italy",
                        new Phone("+902125443614"),
                        new Email("gbacon@verizon.net"),
                        Set.of(new Phone("+763422380839")),
                        Set.of(new Email("psichel@verizon.net")),
                        Language.TR
                ),
                18,
                true,
                Role.ADMIN,
                Instant.now()
        );

        userDao.create(leonardo);

        var raffaello = new User(
                null,
                new Profile(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/f/f6/Raffaello_Sanzio.jpg/330px-Raffaello_Sanzio.jpg",
                        "Urbino, Italy",
                        new Phone("+192242558213"),
                        new Email("arnold@sbcglobal.net"),
                        Set.of(new Phone("+233224582360")),
                        Set.of(new Email("preneel@me.com")),
                        Language.EN
                ),
                18,
                false,
                Role.USER,
                Instant.now()
        );

        userDao.create(raffaello);

        var michelangelo = new User(
                null,
                new Profile(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/5/5e/Miguel_%C3%81ngel%2C_por_Daniele_da_Volterra_%28detalle%29.jpg/330px-Miguel_%C3%81ngel%2C_por_Daniele_da_Volterra_%28detalle%29.jpg",
                        "Tuscany, Italy",
                        new Phone("+952324632733"),
                        new Email("maneesh@att.net"),
                        Set.of(new Phone("+903124406247")),
                        Set.of(new Email("drewf@hotmail.com")),
                        Language.EN
                ),
                23,
                true,
                Role.ANONYMOUS,
                Instant.now()
        );

        userDao.create(michelangelo);

        var donatello = new User(
                null,
                new Profile(
                        "https://upload.wikimedia.org/wikipedia/commons/thumb/6/65/Uffizi_Donatello.jpg/300px-Uffizi_Donatello.jpg",
                        "Florence, Italy",
                        new Phone("+902323732567"),
                        new Email("ijackson@mac.com"),
                        Set.of(new Phone("+773322481010")),
                        Set.of(new Email("josem@aol.com")),
                        Language.TR
                ),
                25,
                false,
                Role.USER,
                Instant.now()
        );

        userDao.create(donatello);

        var faraday = new User(
                null,
                new Profile(
                        "https://upload.wikimedia.org/wikipedia/commons/1/19/Michael_Faraday._Photograph_by_Maull_%26_Polyblank._Wellcome_V0026348.jpg",
                        "Newington Butts, England",
                        new Phone("+905616115132"),
                        new Email("bthomas77@mobisb.site"),
                        Set.of(new Phone("+12509062309")),
                        Set.of(new Email("drmarc@authorizes.me")),
                        Language.EN
                ),
                9,
                true,
                Role.OBSERVER,
                Instant.now()
        );

        userDao.create(faraday);

        var maxwell = new User(
                null,
                new Profile(
                        "https://upload.wikimedia.org/wikipedia/commons/5/57/James_Clerk_Maxwell.png",
                        "Edinburgh, Scotland",
                        new Phone("+905108837548"),
                        new Email("mailforreg2011@supox.site"),
                        Set.of(new Phone("+14037293654")),
                        Set.of(new Email("danielaussilva@onlinecmail.com")),
                        Language.TR
                ),
                11,
                false,
                Role.USER,
                Instant.now()
        );

        userDao.create(maxwell);
        final var userService = new UserService(userDao);
        final var filterApi = new FilterApiImpl(userService);

        var resultList = filterApi.verifiedWithTrPrimaryPhone();

        assertTrue(resultList.contains(leonardo));
        assertTrue(resultList.contains(faraday));
        assertFalse(resultList.contains(raffaello));
        assertFalse(resultList.contains(michelangelo));
        assertFalse(resultList.contains(donatello));
        assertFalse(resultList.contains(maxwell));

    }

}