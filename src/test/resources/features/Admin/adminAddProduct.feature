Feature: Add Product
  Scenario: As an Administrator, I should be able to remove a product from the store.
    Given the admin is on the home page.
    When the admin clicks the manage store button
    When the admin clicks the add product button
    When the admin enters a product name
    When the admin enters a product category
    When the admin enters a product cost
    When the admin enters a product quantity
    When the admin selects an image file
    When the admin enters a product description
    When the admin clicks the modal add product button
    Then a new product is added to the end of the table