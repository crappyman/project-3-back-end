Feature: The user should be able to add or remove items to cart
  Scenario: As a user, I should be able to add items to my cart that I will later purchase
    Given The user is on the home page
    When The user clicks on the view details button
    When The user is redirected to the product page
    When The user clicks on the + icon
    When The user clicks on go to cart button
    Then The user is redirected to the checkout page

    Scenario: As a user, I should be able to remove items from my cart
      Given The user is on the home page
      When The user clicks on the view details button
      When The user is redirected to the product page
      When The user clicks on the + icon
      When The user clicks on go to cart button
      When The user is redirected to the checkout page
      When The user clicks on the remove button
      Then The item should no longer display in the cart

      Scenario: As a user, I should be able to select an amount of an item to add to my cart
        Given The user is on the home page
        When The user clicks on the view details button
        When The user is redirected to the product page
        When The user clicks on the + icon three times
        When The user clicks on go to cart button
        Then The user is redirected to the checkout page