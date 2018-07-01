package org.com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.com.main.DriverScript;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class OtherUtilities extends DriverScript {
	public static TakesScreenshot ts ;


	public static void click(String objectname) throws IOException{

		waitForElementToBeClickable(objectname);
		highlightElement(objectname);
		driver.findElement(By.xpath(objectname)).click();
		test.addScreenCaptureFromPath(takeScreenshotNow());
	}

	public static void sendKeys(String objectname,String value) throws IOException{
		waitForElementToBeClickable(objectname);
		highlightElement(objectname);
		driver.findElement(By.xpath(objectname)).sendKeys(value);
		test.addScreenCaptureFromPath(takeScreenshotNow());
	}

	public static void waitForElementToBeClickable(String objectname)
	{
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(objectname))); 
	}

	public static void selectByVisibleText(String objectname,String text) throws IOException{
		highlightElement(objectname);
		Select drpdwn = new Select(driver.findElement(By.xpath(objectname)));
		drpdwn.selectByVisibleText(text);
		test.addScreenCaptureFromPath(takeScreenshotNow());
	}

	public static String takeScreenshotNow() { 
		DateFormat dateformat;
		String sdateformat = null;
		try{
			ts = (TakesScreenshot)driver;
			Date date=new Date();
			dateformat = new SimpleDateFormat("yyyy MM dd HH_mm_ss_SSS");
			sdateformat = dateformat.format(date);
			File source = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(source, new File("./Screenshots/"+sdateformat+"/image.png"));

		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return "./Screenshots/"+sdateformat+"/image.png";
	}
	public static void takeScreenshotNow1() { 
		DateFormat dateformat;
		String sdateformat = null;
		try{
			ts = (TakesScreenshot)driver;
			Date date=new Date();
			dateformat = new SimpleDateFormat("yyyy MM dd HH_mm_ss_SSS");
			sdateformat = dateformat.format(date);
			File source = ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(source, new File("./Screenshots/"+sdateformat+"/image.png"));

		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}

	}
	public static void takeScreenshotNow(String testcasename) {
		try{
			ts = (TakesScreenshot)driver;
			Date date=new Date();
			DateFormat dateformat = new SimpleDateFormat("yyyy_MM_dd HH_mm_ss");
			String sdateformat = dateformat.format(date);
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./Screenshots/"+sdateformat+"/"+testcasename+"/image.png"));
		}
		catch(IOException e){
			e.printStackTrace();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

	public static void highlightElement(String objectname){

		JavascriptExecutor js=(JavascriptExecutor)driver; 
		WebElement element = driver.findElement(By.xpath(objectname));

		js.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element );

		try 
		{
			Thread.sleep(500);
		} 
		catch (InterruptedException e) {

			System.out.println(e.getMessage());
		} 

		js.executeScript("arguments[0].setAttribute('style','border: solid 2px white');", element); 

	}

	public static void createAlert(String message)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver; 
		js.executeScript("alert('"+message+"')");
	}
	
	public static void clickByJs(String objectname){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath(objectname)));
	}
	
	public static void scrollDownByJs(String objectname){
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollntoView(true)",driver.findElement(By.xpath(objectname)));
	}
}


