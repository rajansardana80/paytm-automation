package Test;

import org.testng.annotations.Test;

import projectData.Constants;
import projectData.Log;

public class CommonMethods {

	

	

	@Test
	public static void openPaytmmall() {

		HomePageTestSuite.driver.get(Constants.applicationUrl);
	
	
		Log.info("Opened www.paytmmall.com.");
		HomePageTestSuite.driver.manage().window().maximize();
		Log.info("Window is maximized");
	}
}
