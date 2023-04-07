package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPageObjects {
	public WebDriver ldriver;

	public AddNewCustomerPageObjects(WebDriver rdriver) {
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}

	By lnkcustomers_menu = By.xpath("//a[@href='#']//p[contains(text(),'Customers')]");
	By lnkcustomers_menuItem = By.xpath("//a[@href='/Admin/Customer/List']//p[contains(text(),' Customers')]");

	By addNew_btn = By.xpath("//a[@class = 'btn btn-primary']");

	By txtemail_addNew = By.xpath("//input[@id='Email']");
	By txtPassword_addNew = By.xpath("//input[@type = 'password']");

	By frstName_addNew = By.xpath("//input[@name = 'FirstName']");
	By lasttName_addNew = By.xpath("//input[@name = 'LastName']");

	By customerRoles = By.xpath("//ul[Contains(text(),'SelectedCustomerRoleIds_taglist')]");

	By listItemAdministrators = By.xpath("//li[Contains(text(),'Administrators')]");
	By listItemForumModerators = By.xpath("//li[Contains(text(),'Forum Moderators')]");
	By listItemGuests = By.xpath("//li[Contains(text(),'Guests')]");
	By listItemRegistered = By.xpath("//li[Contains(text(),'Registered')]");
	By listItemVendors = By.xpath("//li[Contains(text(),'Vendors')]");

	By drpmgrVendor = By.xpath("//select[@id = 'VendorId']");
	By genderMale = By.id("Gender_Male");
	By genderFemale = By.id("Gender_Female");

	By txtDOB = By.xpath("//input[@id = 'DateOfBirth']");
	By txtCompany = By.xpath("//input[@id = 'Company']");

	By txtAdminContent = By.xpath("//textarea[@id = 'AdminComment']");
	By btnSave = By.xpath("//button[@name = 'save']");

	public String getTitle() {
		return ldriver.getTitle();
	}

	public void clickLnkcustomersMenu() {
		ldriver.findElement(lnkcustomers_menu).click();
	}

	public void CLickLnkcustomers_menuItem() {
		ldriver.findElement(lnkcustomers_menuItem).click();
	}

	public void clickAddNew() {
		ldriver.findElement(addNew_btn).click();
	}

	public void setEmail(String email) {
		ldriver.findElement(txtemail_addNew).sendKeys(email);
	}

	public void setPassword(String pwd) {
		ldriver.findElement(txtPassword_addNew).sendKeys(pwd);
	}

	// public void setCustomerRoles (String role) throws InterruptedException {
	// if(!role.equals("Vendors")) {
	// ldriver.findElement(By.xpath("//span[@unselectable='on' and
	// text()='Registered']"));
	// }
	// ldriver.findElement(customerRoles).click();

	// WebElement listItem;

	// Thread.sleep(3000);

	// if(role.equals("Administrators")) {
	// listItem =ldriver.findElement(listItemAdministrators);
	// }
	// else if(role.equals("Guests")) {
	// listItem = ldriver.findElement(listItemGuests);
	// }
	// else if(role.equals("Registered")) {
	// listItem = ldriver.findElement(listItemRegistered);
	// }
	// else if(role.equals("Vendors")) {
	// listItem = ldriver.findElement(listItemVendors);
	// }
	// else {
	// listItem = ldriver.findElement(listItemGuests);
	// }
	// listItem.click();
	// this is selenium click action

	// JavascriptExecutor js = (JavascriptExecutor)ldriver;
	// js.executeScript("argument[0].click();", listItem); //this is java script
	// click

	// }
	public void setManagerOfVendor(String value) {
		Select drp = new Select(ldriver.findElement(drpmgrVendor));
		drp.selectByVisibleText(value);
	}

	public void setGender(String gender) {
		if (gender.equals("Male")) {
			ldriver.findElement(genderMale).click();
		} else if (gender.equals("Femail")) {
			ldriver.findElement(genderFemale).click();
		} else {
			ldriver.findElement(genderMale).click(); // default gender
		}

	}

	public void setFirstName(String firstName) {
		ldriver.findElement(frstName_addNew).sendKeys(firstName);
	}

	public void setLasName(String lastName) {
		ldriver.findElement(lasttName_addNew).sendKeys(lastName);
	}

	public void setDob(String dob) {
		ldriver.findElement(txtDOB).sendKeys(dob);
	}

	public void setCompanyName(String comname) {
		ldriver.findElement(txtCompany).sendKeys(comname);
	}

	public void setAdminContent(String admincontnent) {
		ldriver.findElement(txtAdminContent).sendKeys(admincontnent);
	}

	public void clickonSave() {
		ldriver.findElement(btnSave).click();
	}
}
