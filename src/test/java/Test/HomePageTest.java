package Test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import projectData.Constants;
import projectData.Log;

public class HomePageTest {

	static WebDriver driver;
	WebElement element;
	

	@BeforeMethod

	public void beforeMethod() {
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("HomePageTest");
		System.setProperty("webdriver.chrome.driver", Constants.driverPath);
Log.info("Chrome Driver path is set.");
		driver = new ChromeDriver();
Log.info("Chrome Driver instance created.");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Implicit Wait for 10 sec.");
       CommonMethods.openPaytm();
     
		PageFactory.initElements(driver, HomePage.class);

	Log.info("PageFactory.initElements method is called.");
	}

	@Test
	public void verifySearch() {
		
		Assert.assertTrue(HomePage.verifySearch(), "Verify search is not working.Test Case Fail");

	}
	
	@AfterMethod
	public void afterMethod()
	{
		
			 
			  driver.quit();
		 
		  
		 
	}
}
