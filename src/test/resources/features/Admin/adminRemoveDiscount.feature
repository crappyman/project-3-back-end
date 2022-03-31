Feature: Remove Discount
  Scenario: As an Administrator, I should be able to remove a discount from the store.
    Given the admin is on the home page.
    When the admin clicks the manage store button
    When the admin clicks the display product discounts button
    When the admin clicks the delete button
    When the admin clicks the delete discount button
    When the admin clicks ok on the are you sure alert
    Then the discount is removed from the discount list