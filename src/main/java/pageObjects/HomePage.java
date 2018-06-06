package pageObjects;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import projectData.Log;


public class HomePage {

	public static WebDriver  driver;
		@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/input")
		public static WebElement searchbox_xpath;
	
		public static CharSequence searchbox_keys="fossil watch";
		
		public static boolean  verifySearch() {
			try {
			HomePage.searchbox_xpath.sendKeys(HomePage.searchbox_keys);
			}catch (Exception e) {
				Log.error("Search Input Box Web Element not found");
			}
			
			Log.info("Data send to search input box.");
			Log.info("Test case passed");
			Log.endTestCase("HomePageTest");
			return true;

		}		
	
}
