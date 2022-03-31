Feature: The user should be able to purchase items on sale
  Scenario: As a user, I should be able to see and purchase items that are on sale for a lower price.
    Given The user is on the home page
    When The user clicks on the discounted items button
    When The user clicks on the view details button
    When The user clicks on the + icon
    When The user clicks on go to cart button
    When The user is redirected to the checkout page
    When The user clicks on the proceed to checkout button
    Then The user is redirected to the confirmation page
