# READ ALL CAREFULLY

## What to do

1. Fork this repo to your own Github account.
2. Complete the tasks, ensure that all tests are passing.
3. Push your working code to your fork (the forked repo in your Github account).
4. Send us the link of your repo.

## The tasks

This application is a user management and filtering application. `App` class has the `main` method. You can run and see how it works.

Currently, there are mistakes and missing features in this application. You are required to complete below tasks:

There are unit tests to ensure correctness of logic of the classes in `src/main/java`. All the unit tests are correct and you should not change any test during your tasks.
Due to current mistakes and missing features in the application, not all unit tests are passing. When you finish the 3 tasks below, all the unit tests are expected to be passing.

**DO NOT CHANGE ANYTHING IN `src/test/java` FOLDER.**

You can add new classes to `src/main/java` and new methods to existing classes. However, do not remove any existing method and do not change **signatures and return types** of existing methods. 

1. There are following business requirements for phone number, please implement them:

A phone number,
  - cannot be null or empty string
  - should start with `+` sign
  - should be at least 5-char long when it starts with `+`
    - `+1234` is 5 char long
  - should be exactly 13-char long when it starts with `+90` (e.g. `+905329998877`) but can be at any length otherwise as long as it adheres other requirements
  - `112` and `911` are special cases and considered valid phone numbers

Any failed business requirement should throw an `java.lang.IllegalArgumentException`.

2. Implement `FilterApiImpl` methods in a way you think appropriate.

3. There's a failing test for `UserService#update`. It's because the implementation of `UserService#update` is faulty. Find the cause and fix it.

Bonus:

* There's a violation of DRY principle in `Email` class, find and fix it.

---

_You are free to use the internet (Google, Stackoverflow etc.) at any time._

**Principles to follow when you code**

* Think of performance, assume you have millions of users in prod.
* Thrive for readability and maintainability, assume this project has a 8-person team and minimum of 5 years of life span.
* Keep the code quality high, respect already established coding conventions and adhere them.
* Change as little as possible.