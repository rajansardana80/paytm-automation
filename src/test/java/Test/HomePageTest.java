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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import projectData.Constants;
import projectData.Log;

public class HomePageTest {
//this is my second commit
	static WebDriver driver;
	WebElement element;
	
	public static long threadID;
	

	@BeforeSuite

	public void beforeSuite() {
		 //long id = Thread.currentThread().getId();
		//System.out.println("Before test-method. Thread id is: " + id);
		
		ThreadGroup rootGroup = Thread.currentThread( ).getThreadGroup( );
		   System.out.println("Current active threads in beforeSuite are : "+ rootGroup.activeCount());
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase("HomePageTest");
		System.setProperty("webdriver.chrome.driver", Constants.driverPath);
Log.info("Chrome Driver path is set.");
		driver = new ChromeDriver();
Log.info("Chrome Driver instance created.");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Log.info("Implicit Wait for 10 sec.");
       CommonMethods.openPaytmmall();
     
		PageFactory.initElements(driver, HomePage.class);

	Log.info("PageFactory.initElements method is called.");
	}

	@Test(priority=1)
	public void verifySearchTest() {
		long id = Thread.currentThread().getId();
		System.out.println("In test-method. Thread id is: " + id);
		Assert.assertTrue(HomePage.verifySearch(driver), "Verify search is not working.Test Case Fail");

	}
	

	@Test(priority=2)
	public void verifyFlyoutTest() {
		long id = Thread.currentThread().getId();
		System.out.println("In test-method. Thread id is: " + id);
		Assert.assertTrue(HomePage.verifyFlyout(driver), "Verify flyout is not working.Test Case Fail");

	}
	
	@AfterSuite
	public void afterSuite()
	{
		//long id = Thread.currentThread().getId();
		//System.out.println("After test-method. Thread id is: " + id);
		ThreadGroup rootGroup = Thread.currentThread( ).getThreadGroup( );
		   System.out.println("Current active threads in afterSuite are : "+ rootGroup.activeCount());
			 
			  driver.quit();
			  Log.info("Chrome Driver instance quit"); 
		  
		 
	}
}
