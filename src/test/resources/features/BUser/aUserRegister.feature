Feature: Register account
  Scenario: As a user, I should be able to register a new account
    Given The user is on the login page
    When The user clicks on the register button
    When The user is redirected to the register page
    When The user enters first name into the register form
    When The user enters last name into the register form
    When The user enters username into the register form
    When The user enters email into the register form
    When The user enters password into the register form
    When The user enters address into the register form
    When The user enters phone number into the register form
    When The user scrolls down the page
    When The user clicks on the sign up button
    Then The user is redirected to the login page

