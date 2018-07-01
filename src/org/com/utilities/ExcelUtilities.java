package org.com.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtilities {
	public static File excelfile;
	public static FileInputStream excelinputstream;
	public static XSSFWorkbook workbook;
	public static XSSFSheet worksheet;
	public static XSSFCell cell;
	public static String celldata;
	public static String TCID;
	
	public static String readExcelData(String sheetname,int rownum,int colnum) throws Exception{
		
		
		excelfile= new File("RunManager.xlsx");
		excelinputstream = new FileInputStream(excelfile);
		workbook= new XSSFWorkbook(excelinputstream);
		worksheet = workbook.getSheet(sheetname);
		cell=worksheet.getRow(rownum).getCell(colnum);
		cell.setCellType(Cell.CELL_TYPE_STRING);
		/*if(cell.getCellType()==Cell.CELL_TYPE_NUMERIC){
			cell.setCellType(Cell.CELL_TYPE_STRING);
		}*/
		celldata = cell.getStringCellValue();

		return celldata;
	}
	
	
		
	}

