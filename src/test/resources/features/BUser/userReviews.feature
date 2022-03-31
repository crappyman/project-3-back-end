Feature: Add and view user reviews on a product
  Scenario: As a user, I want to be able to add or view comments
    Given The user is on the home page
    When The user clicks on the view details button
    When The user is redirected to the product page
    When The user enters a review title
    When The user clicks on a star rating
    When The user enters a review
    When the user clicks the submit button
    Then the user should see the review at the bottom of the page