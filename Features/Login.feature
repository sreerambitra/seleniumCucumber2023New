Feature: Login nopcommerce demo webpage

  Scenario: Enter the credentials and Login
    Given User launches Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then Webage title should be "Dashboard / nopCommerce administration"
    When User click on Logout
    Then Webpage title should be "Your store. Login"
    And Close the browser
    
Scenario Outline: Data Driven Tesing
    Given User launches Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters email as "<email>" and password as "<password>"
    And Click on login
    Then Webage title should be "Dashboard / nopCommerce administration"
    When User click on Logout
    Then Webpage title should be "Your store. Login"
    And Close the browser
    
    Examples:
    | email | password |
    | admin@yourstore.com | admin |
    | admin123@yourstore.com | admin123 |
    