Feature: Reject existing username register
  Scenario: As a system, I should reject a user registering with an existing username
    Given The user is on the login page
    When The user clicks on the register button
    When The user is redirected to the register page
    When The user enters first name into the register form
    When The user enters last name into the register form
    When The user enters an existing username into the register form
    When The user enters email into the register form
    When The user enters password into the register form
    When The user enters address into the register form
    When The user enters phone number into the register form
    When The user scrolls down the page
    When The user clicks on the sign up button
    Then The user should receive an username is already taken error message