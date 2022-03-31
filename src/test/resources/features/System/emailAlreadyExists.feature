Feature: Reject existing email register
  Scenario: As a system, I should reject a user registering with an existing email
    Given The user is on the login page
    When The user clicks on the register button
    When The user is redirected to the register page
    When The user enters first name into the register form
    When The user enters last name into the register form
    When The user enters a username into the register form
    When The user enters an existing email into the register form
    When The user enters password into the register form
    When The user enters address into the register form
    When The user enters phone number into the register form
    When The user scrolls down the page
    When The user clicks on the sign up button
    Then The user should receive an email is already taken error message