Feature: Checkout Process on SauceDemo

  Scenario: Add items to the cart and complete the checkout
    Given the user is logged in on the SauceDemo website
    When the user adds items to the shopping cart for checkout
    And proceeds to the checkout
    And completes the checkout process
    Then the user should see a confirmation message