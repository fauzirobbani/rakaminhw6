Feature: User Login on SauceDemo

  Scenario: Valid login
    Given the user is on the SauceDemo login page
    When the user enters a valid username and password
    And clicks the login button
    Then the user should be logged in

  Scenario: Invalid login
    Given the user is on the SauceDemo login page
    When the user enters an invalid username or password
    And clicks the login button
    Then the user should see an error message