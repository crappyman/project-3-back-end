Feature: View order history as a user
  Scenario: As a user, I want to be able to see my order history
    Given The user is on the home page
    When The user clicks on the orders button
    When The user is redirected to the order history page
    Then The user should see their purchase history