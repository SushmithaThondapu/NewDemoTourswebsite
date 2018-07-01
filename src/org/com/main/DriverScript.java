/***************************************************************************
 * Amuthan Sakthivel
 * CopyRight Cognizant Technological Solutions
 * This software is confidential and should be used used after accepting our terms and conditions
 ****************************************************************************/


package org.com.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.com.reusablefunctions.Keywords;
import org.com.reusablefunctions.Keywords2;
import org.com.utilities.ExcelUtilities;
import org.com.utilities.OtherUtilities;
import org.com.config.*;
import org.openqa.selenium.By;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Options;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;



/*********************************************************************************************************
 * Class Description: DriverScript is the main class which controls the whole execution of this project.
 * Created on 		: 9th July 2017
 * Last Modified On : Nil
 * @author 			:	Amuthan Sakthivel
 * @version			: 1.0  
 ******************************************************************************************************/

@Listeners(org.com.listeners.ListenersClass.class)
public class DriverScript {
	public static ChromeOptions options;
	public static WebDriver driver;
	public static DesiredCapabilities capability;
	public static File propertyfile;
	public static Method[] method,method2;
	public static FileInputStream inputstream;
	public static Keywords keywords;
	public static Keywords2 keywords2;
	public static Properties OR;
	public static WebDriverWait wait;
	public static String skeyword;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	public static int rownum;

	@Test(priority=1,retryAnalyzer = org.com.utilities.RetryAnalyser.class)
	public void testcase1() throws Exception{
		rownum=1;
		test = extent.createTest("Book a flight from NewYork to London");
		for(int i=1;i<6;i++)		//***forloop 'A' starts
		{

			keywords= new Keywords();
			method=keywords.getClass().getDeclaredMethods();
			keywords2= new Keywords2();
			method2= keywords2.getClass().getDeclaredMethods();

			skeyword=ExcelUtilities.readExcelData("teststeps", i, Constants.colnum_actions);


			for(int j=0;j<method.length;j++)		//***forloop 'B' starts
			{
				if(skeyword.equalsIgnoreCase(method[j].getName()))
				{
					method[j].invoke(null);
				}
			}//forloop 'B' ends here

			for(int k=0;k<method2.length;k++)		//***forloop 'C' starts
			{
				if(skeyword.equalsIgnoreCase(method2[k].getName()))
				{
					method2[k].invoke(null);
				}
			}//forloop 'C' ends here

		}//forloop 'A' ends here
	}


	@Test(priority=2,retryAnalyzer = org.com.utilities.RetryAnalyser.class)
	public void testcase2() throws Exception{

		System.out.println("this is test case 2");
		test=extent.createTest("Test Case 2");
		rownum=2;
		for(int i=6;i<12;i++)		//***forloop 'A' starts
		{

			keywords= new Keywords();
			method=keywords.getClass().getDeclaredMethods();
			keywords2= new Keywords2();
			method2= keywords2.getClass().getDeclaredMethods();
			skeyword=ExcelUtilities.readExcelData("teststeps", i, Constants.colnum_actions);

			for(int j=0;j<method.length;j++)		//***forloop 'B' starts
			{
				if(skeyword.equalsIgnoreCase(method[j].getName()))
				{
					method[j].invoke(null);
				}
			}//forloop 'B' ends here

			for(int k=0;k<method2.length;k++)		//***forloop 'C' starts
			{
				if(skeyword.equalsIgnoreCase(method2[k].getName()))
				{
					method2[k].invoke(null);
				}
			}//forloop 'C' ends here

		}//forloop 'A' ends here
	}

	@Test(priority=3,retryAnalyzer = org.com.utilities.RetryAnalyser.class)
	public static void testcase3(){
		test= extent.createTest("Test case 3 ");
		throw new SkipException("Skipped Intensionally");


	}


	@Parameters({"browser"})
	@BeforeMethod
	public void setup(String browser)
	{
		String browsername= browser.toLowerCase();

		switch(browsername){

		case "chrome":

			capability=new 	DesiredCapabilities();
			options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			capability.setCapability(ChromeOptions.CAPABILITY, options);
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=	new ChromeDriver(capability);
			break;

		case "firefox":
			capability = new DesiredCapabilities();
			capability.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR,UnexpectedAlertBehaviour.ACCEPT);
			capability.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			FirefoxOptions options1 = new FirefoxOptions();
			options1.setBinary("C://Program Files (x86)//Mozilla Firefox//firefox.exe");	
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver(capability);
			break;
			
		case "ie":
			capability = new DesiredCapabilities();
			capability.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver=new InternetExplorerDriver(capability);
			break;

		default :	
			options=new ChromeOptions();
			options.addArguments("--disable-notifications");
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver=	new ChromeDriver(options);
			break;

		}	
		
		driver.manage().window().maximize();
		setexplicitwait();
		loadpropertyfiles();
		
	}


	public static void loadpropertyfiles()
	{
		try
		{
			propertyfile= new File("pageobjects.properties");

			inputstream = new FileInputStream(propertyfile);
			OR = new Properties(System.getProperties());
			OR.load(inputstream);

		}
		catch(FileNotFoundException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}


	public static void setexplicitwait()
	{
		wait=new WebDriverWait(driver,10);
	}

	@AfterMethod
	public static void teardown(ITestResult result) throws IOException{

		if(result.getStatus()==ITestResult.SUCCESS){

			test.log(Status.PASS, MarkupHelper.createLabel("Test case "+ result.getName()+ "passed", ExtentColor.GREEN));
			test.addScreenCaptureFromPath(OtherUtilities.takeScreenshotNow());

		}
		else if(result.getStatus()==ITestResult.FAILURE){


			test.log(Status.FAIL, MarkupHelper.createLabel("Test case "+ result.getName()+ " failed", ExtentColor.RED));
			test.log(Status.FAIL, result.getThrowable());
			test.addScreenCaptureFromPath(OtherUtilities.takeScreenshotNow());
		}
		else {
			test.log(Status.SKIP, MarkupHelper.createLabel("Test case "+ result.getName()+ " skipped", ExtentColor.YELLOW));
			test.log(Status.SKIP, result.getName()+" is skipped");
		}

		if(driver!=null)
		{
			driver.close();
		}
	}

		@AfterSuite
	public static void closeReports(){
		extent.flush();
	}

	@BeforeSuite
	public static void initializeReports(){
		htmlreporter = new ExtentHtmlReporter("MyOwnHtmlReport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlreporter);
		extent.setSystemInfo("OS", "Windows");
		extent.setSystemInfo("Author", "Amuthan Sakthivel");
		extent.setSystemInfo("Environment", "UAT");

		htmlreporter.config().setDocumentTitle("Automation Status");
		htmlreporter.config().setReportName("New Demo Tours Testing");
		htmlreporter.config().setTheme(Theme.DARK);

	}

}
