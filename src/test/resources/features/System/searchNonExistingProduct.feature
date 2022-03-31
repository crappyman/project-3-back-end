Feature: Searching for a product that is not there
  Scenario Outline: As a system, I should return nothing if the user enters a non-existing product
    Given The user is on the home page
    When The user enters a "<string>" into the search bar
    When The user clicks the enter key
    Then The user should see nothing in the product list

    Examples:
    |string|
    |    fdjaofjdoasfdf897da  |
    |    solace  |
