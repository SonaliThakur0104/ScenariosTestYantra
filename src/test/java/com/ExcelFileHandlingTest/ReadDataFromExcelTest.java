package com.ExcelFileHandlingTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelTest {
	
	static String filePath="C:\\Users\\User\\eclipse-workspace\\hotstar\\src\\test\\resources\\StudentDetails.xlsx";
	static String sheetName="Student Details";
	static int rowNum=2;
	static int cellNum=5;
	
	public static void main(String[] args) throws IOException {
		    
		//Create an object of FileInputStream class to read excel file
			FileInputStream fis= new FileInputStream(filePath);
			
			//Creating workbook instance that refers to .xls file
			Workbook workbook=WorkbookFactory.create(fis);
			
			//Creating a Sheet object using the sheet Name
			Sheet sheet=workbook.getSheet(sheetName);
			
			//Create a row object to retrieve row at index 1
			Row row= sheet.getRow(rowNum);
			
			//Create a cell object to retreive cell at index 5
			Cell cell=row.getCell(cellNum);
			
			//Get the address in a variable
			String address=cell.getStringCellValue();
			
			//Printing the address
			System.out.println("Address is: " +address);
			
		
	}

}
