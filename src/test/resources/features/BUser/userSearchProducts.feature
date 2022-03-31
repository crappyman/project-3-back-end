Feature: User should be able to search products
  Scenario Outline: As a user, I should be able to search the product list to better find the item(s) I am interested in
    Given The user is on the home page
    When The user clicks on the search bar
    When The user enters a "<value>" into the search bar
    When The user clicks the enter key
    Then The user should see the product list for the specified item(s)

    Examples:
    |value|
    | iPhone 13 Pro|
    |iMac Desktop/Monitor|
    |Xbox|
