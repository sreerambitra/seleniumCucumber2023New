Feature: Add Customer

 Background: Below is the common steps for each scenario
		Given User launches Chrome browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User enters email as "admin@yourstore.com" and password as "admin"
    And Click on login
    Then User can view dashboard
    When User can click on customers menu
    And Click on customers menu item

  Scenario: Add New Customer
    And Click on Add new button
    Then User can view add new customer page
    When User enter customer info
    And Click on save button
    Then User can view confirmation message "The new customer has been added successfully"
    And Close the browser

	Scenario: Search Customer by EmailID
    And Enter customer EmaiId
    When Click on search button
    Then User should be found with email in the search table
    And Close the browser
    