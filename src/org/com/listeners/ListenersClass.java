package org.com.listeners;

import org.com.utilities.OtherUtilities;
import org.testng.IInvokedMethod;
import org.testng.IInvokedMethodListener;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersClass implements ITestListener,IInvokedMethodListener,ISuiteListener{

	@Override
	public void onFinish(ISuite arg0) {
		//Reporter.log("Ended execution Suite: " + arg0.getName(), true);
		//System.out.println("Ended execution Suite: " + arg0.getName());
	}

	@Override
	public void onStart(ISuite arg0) {
		//Reporter.log("About to begin execution Suite: " + arg0.getName(), true);
		//System.out.println("Ended execution Suite : " + arg0.getName());
	}

	@Override
	public void afterInvocation(IInvokedMethod arg0, ITestResult arg1) {
		Reporter.log( arg0.getTestResult() +" "+ arg1.SUCCESS);
		
	}

	@Override
	public void beforeInvocation(IInvokedMethod arg0, ITestResult arg1) {
		//Reporter.log("Ended execution method : " + arg0.getTestMethod().getMethodName(), true);
		
	}

	@Override
	public void onFinish(ITestContext arg0) {
		
		//System.out.println("Ended execution of Test" + arg0.getName());
		
	}

	@Override
	public void onStart(ITestContext arg0) {
		// TODO Auto-generated method stub
	//	System.out.println("Started execution of Test" + arg0.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestFailure(ITestResult arg0) {
		// TODO Auto-generated method stub
		OtherUtilities.takeScreenshotNow(arg0.getName());
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onTestStart(ITestResult arg0) {
	//Reporter.log("Test Case started :" +arg0.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult arg0) {
		// TODO Auto-generated method stub
		
		/*Reporter.log("Test case  :" + arg0.getStatus());
		if(arg0.getStatus()==1){
			Reporter.log("Test case  :  "+arg0.SUCCESS);
			}
		
		OtherUtilities.takeScreenshotNow(arg0.getName());*/
	}

	
	
}
