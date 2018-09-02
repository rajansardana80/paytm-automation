package Test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pageObjects.HomePage;
import projectData.Constants;
import projectData.Log;

public class HomePageTestSuite {
//this is my second commit
	static WebDriver driver;
	WebElement element;
	ExtentReports report;
	ExtentTest logger;
	boolean test_result;
	
	public static long threadID;
	

	@BeforeSuite

	public void beforeSuite() {
		 //long id = Thread.currentThread().getId();
		//System.out.println("Before test-method. Thread id is: " + id);
		report = new ExtentReports("/home/rajansardana/eclipse-workspace/paytm-automation/test-output/TestSuiteExecutionReport.html");
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
		//ExtentReports logger = ExtentReports
		logger=report.startTest("Verify search on homepage");
		long id = Thread.currentThread().getId();
		System.out.println("In test-method. Thread id is: " + id);
		Assert.assertTrue(HomePage.verifySearch(driver), "Verify search is not working.Test Case Fail");
		logger.log(LogStatus.PASS, "Search verified on homepage");
	}
	

	@Test(priority=2)
	public void verifyFlyoutTest() {
		
		logger=report.startTest("Verify flyout on homepage");
		long id = Thread.currentThread().getId();
		System.out.println("In test-method. Thread id is: " + id);
		Assert.assertTrue(HomePage.verifyFlyout(driver), "Verify flyout is not working.Test Case Fail");
		if(HomePage.verifyFlyout(driver))
    logger.log(LogStatus.PASS, "Flyout verified on homepage");
    logger.log(LogStatus.FAIL, "Flyout verified on homepage");
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
			  report.endTest(logger);
			  report.flush();
			    
		  
		 
	}
}
