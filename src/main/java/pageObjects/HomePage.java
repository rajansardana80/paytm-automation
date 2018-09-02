package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import projectData.Log;


public class HomePage {
//abc
	
	//public static WebDriver  driver;
		//@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/input")
	
	@FindBy(xpath = "//*[@id='app']/div/div[2]/div[2]/div[2]/div[2]/div[2]/input")
	public static WebElement searchbox_xpath;
	
		public static CharSequence searchbox_keys="fossil watch";
		
		//@FindBy(xpath="//*[@id='app']/div/div[2]/div[3]/div[1]/div[1]/div/span")
		                //*[@id="app"]/div/div[2]/div[3]/div[1]/div[1]/div/i
		@FindBy(xpath="//*[@id='app']/div/div[2]/div[3]/div[1]/div[1]/div/i")
		public static WebElement flyout;
		                //*[@id="app"]/div/div[2]/div[3]/div[1]/div[2]/div/a[2]
		@FindBy(partialLinkText="")
		public static WebElement text_in_flyout;
		
		
		public static boolean  verifySearch(WebDriver driver) {
			try {
				WebDriverWait wait = new WebDriverWait(driver, 10);
		        wait.until(ExpectedConditions.visibilityOf((HomePage.searchbox_xpath))).sendKeys(HomePage.searchbox_keys);
		        wait.until(ExpectedConditions.visibilityOf((HomePage.searchbox_xpath))).sendKeys(Keys.ENTER);
		        	
			//HomePage.searchbox_xpath.sendKeys(HomePage.searchbox_keys);
			//Thread.sleep(5000);
		//	HomePage.searchbox_xpath.sendKeys(Keys.ENTER);
			
			}catch (Exception e) {
				Log.error("Error in finding search input box");
				Log.info("Test case failed");
				e.printStackTrace();
				
			}
			
			Log.info("Data send to search input box.");
			Log.info("Test case passed");
			//Log.endTestCase("HomePageTest");
			return true;

		}		
	
		public static boolean  verifyFlyout(WebDriver driver) {
			try {
			/*	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[3]/div[1]/div[1]/div/span"));

	        Actions action = new Actions(driver);
	        Thread.sleep(5000);
	        action.moveToElement(element).moveToElement(driver.findElement(By.linkText("Mobiles & Tablets"))).click().build().perform();
*/	        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	        
	       //WebDriverWait wait = new WebDriverWait(driver, 10);
	        //WebElement ele=wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Mobiles & Tablets")));
	        
				//Thread.sleep(5000); 
				WebDriverWait wait = new WebDriverWait(driver, 10);
		        wait.until(ExpectedConditions.visibilityOf( HomePage.text_in_flyout)).click();
		         
	       // WebElement subElement = driver.findElement(By.partialLinkText("iles"));
	        //HomePage.text_in_flyout.click();
	        //ele.click();
			//	driver.findElement(By.linkText("Mobiles & Tablets")).click();
	        //subElement.click();
				//Thread.sleep(5000);
			/*	                                                   
				WebElement element = driver.findElement(By.xpath("//*[@id=\"app\"]/div/div[2]/div[2]/div[2]/div[3]/div[1]/div/span[2]"));
				 //Used points class to get x and y coordinates of element.
				 Point point = element.getLocation();
				 int xcord = point.getX();
				 System.out.println("Position of the webelement from left side is "+xcord +" pixels");
				 int ycord = point.getY();
				 System.out.println("Position of the webelement from top side is "+ycord +" pixels");
				 // Using Actions class
				                Actions action = new Actions(driver);
				                //clicking on the logo based on x coordinate and y coordinate 
				                //you will be redirecting to the home page of softwaretestingmaterial.com
				                action.moveToElement(element, xcord, ycord).clickAndHold().build().perform();
				               ((JavascriptExecutor)driver).executeScript("window.scrollTo(0,"+element.getLocation().y+")");
				               element.click();
				            //    Thread.sleep(5000);
				            //    WebDriverWait wait = new WebDriverWait(driver, 10);
				    	      //  WebElement ele=waitat.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Mobiles & Tablets")));
				    	     //   ele.click();
				                
				                List<WebElement> ele= driver.findElements(By.xpath("//*[@id='app']/div/div[2]/div[3]/div[1]/div[2]/div/a"));
				                //List<WebElements> a=driver.findElements(by)
				                
				                ele.size();
				                ele.get(1).click();
				               System.out.println("List size is  ::"+ele.size());
				               for(WebElement ele1:ele)
				               {
				            	   ele.get(1).click();
				               }
				                // 	ele.click();
				                	
				               for (WebElement link : ele) {

				            	 //print the links i.e. http://example.com or https://www.example.com
				            	 System.out.println(link.getAttribute("href"));
//link.click();
				            	*/ //print the links text
				            	// System.out.println(link.getText());
				            	/* ele.
				            	 
				               }*/
				            //   ele.indexOf(1).click();
				               Thread.sleep(5000);
	        Log.info("Clicked on Mobiles & Tablets.");
			Log.info("Test case passed");
			Log.endTestCase("HomePageTest");
	        return true;

		}catch (Exception e) {
			Log.error("Error in performing click on Mobiles & Tablets.");
			e.printStackTrace();
		}
			//Log.info("Data send to search input box.");
			Log.info("Test case failed");
			Log.endTestCase("HomePageTest");
			return false;		
}

}
