Feature: User Account information
  Scenario: As a user, I want to be able to view my account information
    Given The user is on the home page
    When The user clicks on the profile button
    When The user is redirected to the profile page
    Then The user should see their account information