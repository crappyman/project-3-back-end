Feature: User login
  Scenario: As a user, I should be able to log into the application
    Given The user is on the login page
    When The user enters username into the login form
    When The user enters password into the login form
    When The user clicks on the login button
    Then The user is redirected to the home page
