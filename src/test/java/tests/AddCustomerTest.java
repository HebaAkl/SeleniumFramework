package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AddCustomerPage;
import pages.HomePage;

public class AddCustomerTest extends TestBase{

	HomePage homePage;
	AddCustomerPage addCustomer;
	
	@Test
	public void userCanAddCustomer()
	{
		homePage    = new HomePage(driver);
		homePage.openAddCustomerPage();

		addCustomer = new AddCustomerPage(driver);
		addCustomer.addNewCustomer("First","Last","test2@test.test","Message","0123456789");
		Assert.assertSame(true, driver.getPageSource().contains("Access Details to Guru99 Telecom"));
	}
}
