package stepDefinitions;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import pageObjects.AddNewCustomerPageObjects;
import pageObjects.LoginPageObjects;
import pageObjects.SearchCustomerPageObjects;

public class BaseClass {
	public WebDriver driver;
	public LoginPageObjects lpo;
	public AddNewCustomerPageObjects anc;
	public SearchCustomerPageObjects searchCust;
	public Logger logger;
	public Properties configProp;
	
	//creates random string for unique email id
	public static String randomsrting() {
		String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		return (generatedString1);
	}

}
