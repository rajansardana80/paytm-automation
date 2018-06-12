package Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import projectData.*;
import  org.apache.log4j.xml.DOMConfigurator;

public class CommonMethods {

	

	

	@Test
	public static void openPaytmmall() {

		HomePageTest.driver.get(Constants.applicationUrl);
	
	
		Log.info("Opened www.paytmmall.com.");
		HomePageTest.driver.manage().window().maximize();
		Log.info("Window is maximized");
	}
}
