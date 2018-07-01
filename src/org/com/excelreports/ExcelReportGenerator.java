package org.com.excelreports;

import org.automationtesting.excelreport.Xl;

public class ExcelReportGenerator {

	public static void main(String[] args) throws Exception {
	
		Xl.generateReport("./","MyOwnExcelReport.xlsx");
	
	}

}
