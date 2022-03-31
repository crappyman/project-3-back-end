Feature: Reject any invalid credentials when logging in
  Scenario: As a system, I should reject invalid credentials
    Given The user is on the login page
    When The user enters an incorrect username
    When The user enters an incorrect password
    When The user clicks on the login button
    Then The user should receive a bad credentials error message

