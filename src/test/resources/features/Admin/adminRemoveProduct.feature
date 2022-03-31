Feature: Remove Product
  Scenario: As an Administrator, I should be able to remove a product from the store.
    Given the admin is on the home page.
    When the admin clicks the manage store button
    When the admin clicks the display product inventory button
    When the admin clicks the delete product button
    When the admin clicks ok on the are you sure alert
    Then the product is no longer in the table