package org.com.reusablefunctions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.com.config.Constants;
import org.com.main.DriverScript;
import org.com.utilities.ExcelUtilities;
import org.com.utilities.OtherUtilities;
import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.Status;

@Listeners(org.com.listeners.ListenersClass.class)
public class Keywords extends DriverScript{



	public static void login() throws IOException{
		
		OtherUtilities.sendKeys(OR.getProperty("txtbox_username"), "tutorial");
		test.log(Status.PASS, "Username entered in the fields");
		OtherUtilities.sendKeys(OR.getProperty("txtbox_password"), "tutorial");
		test.log(Status.PASS, "Password entered in the fields");
		test.addScreenCaptureFromPath(OtherUtilities.takeScreenshotNow());
		OtherUtilities.click(OR.getProperty("btn_signin"));
		test.log(Status.PASS, "Sign in button clicked");
		
	}

	public static void loadURL(){
		
		driver.get(Constants.URL);
		test.log(Status.PASS, "URL Loaded Successully");

	}
	
	
	
	
	
	
}
