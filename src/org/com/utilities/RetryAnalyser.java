package org.com.utilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyser implements IRetryAnalyzer{

	static int limit=1;
	static int counter=0;
	
	@Override
	public boolean retry(ITestResult arg0) {
		
		if(counter<limit){
			counter++;
			System.out.println(limit);
			System.out.println(counter);
			
			return true;
		}
			return false;
			
	}

	
	
}
