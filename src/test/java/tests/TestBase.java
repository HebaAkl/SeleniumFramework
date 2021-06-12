package tests;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import utilities.Helper;

public class TestBase {

	public static WebDriver driver;
	
	@BeforeSuite
	@Parameters({"browser"})
	public void startDriver(@Optional("chrome") String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.out.println("hereee");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
			System.out.println("hereee2");
			driver = new ChromeDriver();
			System.out.println("hereee3");

		}
		else if (browser.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecho.driver", System.getProperty("user.dir") + "/drivers/geckodriver");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("chrome-headless"))
		{
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless");
			options.addArguments("--window-size=1920,1080");
			driver = new ChromeDriver(options);
		}
		else
		{
			System.out.println("Driver has a problem");
		}
		driver.manage().window().maximize();
		driver.navigate().to("http://demo.guru99.com/telecom/index.html");
	}
	
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}
	
	@AfterMethod
	public void screenshotOnFailure(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE)
		{
			Helper.captureScreenshot(driver, result.getName());
		}
	}
	
}
