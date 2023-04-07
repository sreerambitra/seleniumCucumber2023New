package stepDefinitions;

import static org.junit.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pageObjects.AddNewCustomerPageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.SearchCustomerPageObjects;

public class StepsForLogin extends BaseClass {
	
	@Before
	public void setup() throws Exception {
		
		logger=Logger.getLogger("seleniumCucumber2023New");
		PropertyConfigurator.configure("log4j.properties");
		
		//Reading Properties 
		configProp =new Properties();
		FileInputStream configPropFile = new FileInputStream("config.properties"); //Add the config.properties file
		configProp.load(configPropFile);
	
		
		String browser = configProp.getProperty("browser");
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", configProp.getProperty("chromepath"));
			driver = new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", configProp.getProperty("firefoxpath"));
			driver = new FirefoxDriver();
		}
		else if(browser.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", configProp.getProperty("iepath"));
			driver = new InternetExplorerDriver();
		}
		logger.info("***Launching Browser***");
		
	}
		
	@Given("User launches Chrome browser")
	public void user_launches_chrome_browser() {
		lpo = new LoginPageObjects(driver);
	}
	@When("User opens URL {string}")
	public void user_opens_url(String url) throws InterruptedException {
		logger.info("***Entering URLr***");
		driver.get(url);
		driver.manage().window().maximize();
	    Thread.sleep(3000);
	}
	@When("User enters email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		logger.info("***Entering Email***");
		lpo.setUserName(email);
		logger.info("***Entering Password***");
		lpo.setPassword(password);    
	}
	@When("Click on login")
	public void click_on_login() throws InterruptedException {
		logger.info("***Login button is clicked***");
		lpo.clickLogin();
		Thread.sleep(3000);
	}
	@Then("Webage title should be {string}")
	public void webage_title_should_be(String title) throws InterruptedException {
		if(driver.getPageSource().contains("Login was unsuccessful. Please correct the errors and try again.")){
			logger.info("***Login Failed***");
			driver.quit();
			Assert.assertTrue(false);		
		} else {
			logger.info("***Login Passed***");
			Assert.assertEquals(title, driver.getTitle());
		} 
		Thread.sleep(3000);
	}
	@When("User click on Logout")
	public void user_click_on_logout() throws InterruptedException {   
		logger.info("***Logout is Clicked***");
		lpo.clickLogout();
		Thread.sleep(3000);
	}
	@Then("Webpage title should be {string}")
	public void webpage_title_should_be(String title) {
		if(driver.getPageSource().contains("Login was unsuccessful")) {
			logger.info("***Login Failed***");
			driver.close();
			Assert.assertTrue(false);		
		} else {
			logger.info("***Login Passed***");
			Assert.assertEquals(title, driver.getTitle());
		} 
		
	}
	@Then("Close the browser")
	public void close_the_browser() {
		logger.info("***Browser is Closed***");
		driver.quit();
	}
	
	//add customers step definitions
	
	@Then("User can view dashboard")
	public void user_can_view_dashboard() {
		logger.info("***Title is Verified***");
		anc = new AddNewCustomerPageObjects(driver);
		Assert.assertEquals("Dashboard / nopCommerce administration", anc.getTitle());
	    
	}
	@When("User can click on customers menu")
	public void user_can_click_on_customers_menu() {
		logger.info("***Customer Menu is Clicked***");
		anc.clickLnkcustomersMenu();
	    
	}
	@When("Click on customers menu item")
	public void click_on_customers_menu_item() {
		logger.info("***Customer Menu Item is Clicked***");
		anc.CLickLnkcustomers_menuItem();
	    
	}
	@When("Click on Add new button")
	public void click_on_add_new_button() {
		logger.info("***Add New Button is Clicked***");
		anc.clickAddNew();
	    
	}
	@Then("User can view add new customer page")
	public void user_can_view_add_new_customer_page() {
		logger.info("***Customer Page is displayed***");
		Assert.assertEquals("Add a new customer / nopCommerce administration", anc.getTitle());
	}
	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
		String email = randomsrting()+"@gmail.com";
	    anc.setEmail(email);
	    anc.setPassword("abc123");
	    //Customer roles: Registered is default
	    //Customer cannot be in both 'Guests' and 'Registered'
	    //Add the Customers roles to 'Guests' or 'Registered'
	    //anc.setCustomerRoles("Guests");
	    Thread.sleep(3000);
	    
	    anc.setManagerOfVendor("Vendor 2");
	    anc.setGender("Male");
	    anc.setFirstName("Ramesh Kumar");
	    anc.setLasName("Jojo");
	    anc.setDob("10/24/1994"); //DOB format: dd/mm/yyyy
	    anc.setCompanyName("ABC Company");
	    anc.setAdminContent("This is for testing.....");
	}
	@When("Click on save button")
	public void click_on_save_button() throws InterruptedException {
		logger.info("***Save Button is Clicked***");
		anc.clickonSave();
		Thread.sleep(2000);
	    
	}
	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String confirmMsg) {
		logger.info("***Confirmation message is displayed***");
		Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));  
	}
	//steps for search customer by email
	
	@When("Enter customer EmaiId")
	public void enter_customer_emai_id() {
		logger.info("***Customer is Searched by Email***");
		searchCust = new SearchCustomerPageObjects(driver);
		searchCust.setEmail("victoria_victoria@nopCommerce.com");
		
	    
	}
	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
		logger.info("***Customer is Displayed***");
		searchCust.clicksrch();
		Thread.sleep(3000);
	    
	}
	@Then("User should be found with email in the search table")
	public void user_should_be_found_with_email_in_the_search_table() {
		logger.info("***Customer is Displayed in the table***");
	boolean status=searchCust.searchCustomerByEmail("victoria_victoria@nopCommerce.com");
		Assert.assertEquals(true, status);
	    
	}

}
