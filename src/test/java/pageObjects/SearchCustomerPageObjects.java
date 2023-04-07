package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitHelperClass;

public class SearchCustomerPageObjects {

public WebDriver ldriver;
WaitHelperClass waithelper;
Duration timeOut = Duration.ofSeconds(30);
	
	public SearchCustomerPageObjects(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(ldriver, this);
		waithelper = new WaitHelperClass(ldriver);
	}
	
	@FindBy(how = How.ID, using = "SearchEmail")
	WebElement searchTxtEmail;
	
	@FindBy(how = How.ID, using = "SearchFirstName")
	WebElement searchFirstName;
	
	@FindBy(how = How.ID, using = "SearchLastName")
	WebElement searchLastName;
	
	@FindBy(how = How.ID, using = "SearchMonthOfBirth")
	WebElement drpsSearchMonthOfBirth;
	
	@FindBy(how = How.ID, using = "SearchDayOfBirth")
	WebElement drpsSearchDayOfBirth;
	
	@FindBy(how = How.ID, using = "SearchCompany")
	WebElement searchCompany;
	
	@FindBy(how = How.XPATH, using = "//div[@xlass = 'k-multiselect-wrap k-floatwrap']")
	WebElement txtSearchCustomersRoles;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Administrators')]")
	WebElement listItemAdministrators;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Registered')]")
	WebElement listItemRegistered;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Guests')]")
	WebElement listItemGuests;
	
	@FindBy(how = How.XPATH, using = "//li[contains(text(),'Vendors')]")
	WebElement listItemVendors;
	
	@FindBy(how = How.ID, using = "search-customers")
	WebElement btnSearchbutton;
	
	@FindBy(how = How.XPATH, using = "//table[@class='table table-bordered table-hover table-striped dataTable no-footer']")
	WebElement tableGrid;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	@FindBy(how = How.XPATH, using = "//table[@id='customers-grid']//tbody/tr/td")
	List<WebElement> tableColumns;
	
	public void setEmail(String email) {
		waithelper.WaitForElement(ldriver, searchTxtEmail, timeOut);
		searchTxtEmail.clear();
		searchTxtEmail.sendKeys(email);
	}
	
	public void setFirstName(String firstName) {
		waithelper.WaitForElement(ldriver, searchFirstName, timeOut);
		searchFirstName.clear();
		searchFirstName.sendKeys(firstName);
	}
	
	public void setLastName(String lastName) {
		waithelper.WaitForElement(ldriver, searchLastName, timeOut);
		searchLastName.clear();
		searchLastName.sendKeys(lastName);
	}
	
	public void clicksrch() {
		btnSearchbutton.click();
		waithelper.WaitForElement(ldriver, btnSearchbutton, timeOut);
	}
	
	public int getNoOfRows() {
		return(tableRows.size());
	}
	
	public int getNoOfColumns() {
		return(tableColumns.size());
	}
	
	public boolean searchCustomerByEmail(String email) {
		boolean flag= false;
		for(int i=1;i<=getNoOfRows();i++) {
			String emailId= tableGrid.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr["+i+"]/td[2]")).getText();
			System.out.println(emailId);
			
			if(emailId.equals(email)) {
				flag = true;
			}
			
		}
		return flag;
	}
}
