package org.com.reusablefunctions;

import java.io.IOException;

import org.com.config.Constants;
import org.com.main.DriverScript;
import org.com.utilities.ExcelUtilities;
import org.com.utilities.OtherUtilities;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;


/**************************************************************************************
 * 
 * 
 * 
 * @author Amuthan Sakthivel
 *@version 1.1
 *****************************************************************************************/
public class Keywords2 extends DriverScript{

	public static void selectpassengerscount()  {
		try{
		OtherUtilities.selectByVisibleText
		(OR.getProperty("drpdwn_passengers"), 
				ExcelUtilities.readExcelData("testdata", rownum, Constants.colnum_passengerscount));
		
		test.log(Status.PASS, "Passengers count of "+
		ExcelUtilities.readExcelData("testdata", rownum, Constants.colnum_passengerscount)+" been selected");
		}
	
		catch(Exception e){
			e.printStackTrace();
		}
		
		catch(Throwable e){
			
		}
	}
	
	public static void selectonewaytrip() throws IOException{
		OtherUtilities.click(OR.getProperty("radiobtn_oneway"));
		
		test.log(Status.PASS, "Oneway mode is selected");
	}
	public static void selectroundtrip() throws IOException{
		OtherUtilities.click(OR.getProperty("radiobtn_roundtrip"));
		test.log(Status.PASS, "Roundtrip mode is selected");
	}

	@Test
	public static void selectfromplace() {
		try{
		OtherUtilities.selectByVisibleText(OR.getProperty("drpdwn_from"), 
				ExcelUtilities.readExcelData("testdata", rownum, Constants.colnum_from));
		test.log(Status.PASS, "From field "+
				ExcelUtilities.readExcelData("testdata", rownum,  Constants.colnum_from)+" has been selected");
		}
		
	catch(Exception e){
		test.fail("Unable to select the From Place");
		test.fail(e.getCause());
	}
	}

}
