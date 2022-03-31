Feature: Add Discount
  Scenario: As an Administrator, I should be able to add a discount to the store.
    Given the admin is on the home page.
    When the admin clicks the manage store button
    When the admin clicks the display product inventory button
    When the admin clicks the add discount button
    When the admin enters a product discount percentage
    When the admin enters a discount description
    When the admin clicks the add modal discount button
    Then a popup appears that says "Discounted was added successfully"
