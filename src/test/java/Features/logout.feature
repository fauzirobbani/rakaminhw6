Feature: Logout from SauceDemo

  Scenario: User logs out from SauceDemo
    Given the user is logged in on the SauceDemo website for logout
    When the user logs out
    Then the user should be redirected to the login page