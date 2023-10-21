Feature: Add Items to Cart on SauceDemo

  Scenario: Add items to the shopping cart
    Given the user is logged in on the SauceDemo website for add cart
    When the user adds items to the shopping cart
    Then the cart should contain the added items
