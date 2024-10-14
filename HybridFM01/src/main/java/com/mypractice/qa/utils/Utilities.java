package com.mypractice.qa.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Utilities {

	public static final int IMPLICIT_WAIT_TIME = 20;
	public static final int PAGE_LOAD_TIME = 15;

	public static String genEmailWithTimestamp() {
		Date date = new Date();
		String timestamp = date.toString().replace(" ", "_").replace(":", "_").replace("_", "").replace("IST", "");
		return "m" + timestamp + "@ym.com";
	}

	public static Object[][] getTestDataFromExcel(String sheetName) {
		XSSFWorkbook workbook = null;
		
		File excelFile = new File(System.getProperty("user.dir")+"\\testdata\\DDT_For_LoginPage.xlsx");
		
		try {
		FileInputStream fisExcel = new FileInputStream(excelFile);
		 workbook = new XSSFWorkbook(fisExcel);
		}
		catch(Throwable e) {
			e.printStackTrace();
		}
		
		
		XSSFSheet sheet = workbook.getSheet(sheetName);
		int rows = sheet.getLastRowNum();
		int cols = sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[rows] [cols];
		
		for (int i=0;i<rows; i++) 
		{
		XSSFRow row = sheet.getRow(i+1);

		for (int j=0;j<cols;j++) {

		XSSFCell cell=row.getCell(j);

		CellType cellType = cell.getCellType();
		
		switch(cellType) {
		case STRING:
			data[i][j]= cell.getStringCellValue();
			break;
		case NUMERIC:
			data[i][j]= cell.getNumericCellValue();
			break;
		case BOOLEAN:
			data[i][j]= cell.getBooleanCellValue();
			break;
			
		}
		
		}
		}
		return data;
	}
	
	}
	

