package utility;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class TestNGListener implements ITestListener{

	public void onTestStart(ITestResult result) {
		System.out.println("Test case started and Test case details are :: "+result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test case success and Test case details are :: "+result.getName());		
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test case failed and Test case details are :: "+result.getName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test case skipped and Test case details are :: "+result.getName());
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	
	

}
