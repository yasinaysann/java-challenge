TODOs:

1. There are following business requirements for phone number, please implement them:

A phone number,
  - cannot be null or empty string
  - should start with `+` sign
  - may not start with `+` if it's `112` or `911`
  - should be at least 5-char long when it starts with `+`
  - should be exactly 13-char long when it starts with `+90` (e.g. `+905329998877`) but can be at any length otherwise as long as it adheres other requirements

2. Implement `FilterApiImpl` methods

3. There's a failing test for `UserService#update`. Find the cause and fix it.

Bonus:

* There's a violation of DRY principle in `Email` class, find and fix it.