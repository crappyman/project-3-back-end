Feature: Admin login
  Scenario: As an admin, I should be able to log into the application
    Given The admin is on the login page
    When The admin enters username into the login form
    When The admin enters password into the login form
    When The admin clicks on the login button
    Then The admin is redirected to the home page
