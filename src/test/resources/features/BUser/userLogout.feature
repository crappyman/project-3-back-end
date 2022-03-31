Feature: User logout
  Scenario: As a user, I should be able to log out of the application
    Given The user is on the home page
    When The user clicks on the logout button
    Then The user is redirected to the login page