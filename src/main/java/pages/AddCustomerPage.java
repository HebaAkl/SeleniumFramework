package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddCustomerPage extends PageBase {

	public AddCustomerPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(xpath="//*[@for=\"done\"]")
	WebElement backgroundCheck;
	
	@FindBy(id="fname")
	WebElement firstName;
	
	@FindBy(id="lname")
	WebElement lastName;
	
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(name="addr")
	WebElement message;
	
	@FindBy(id="telephoneno")
	WebElement telephoneno;

	@FindBy(name="submit")
	WebElement submit;
	
	public void addNewCustomer(String fName, String lName, 
							   String userEmail, String msg, 
							   String phone)
	{
    	backgroundCheck.click();
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(userEmail);
		message.sendKeys(msg);
		telephoneno.sendKeys(phone);
		submit.click();
	}

}
