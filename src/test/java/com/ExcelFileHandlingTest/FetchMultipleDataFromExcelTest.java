package com.ExcelFileHandlingTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchMultipleDataFromExcelTest {
	static String filePath="C:\\Users\\User\\eclipse-workspace\\hotstar\\src\\test\\resources\\MultipleDataHandling.xlsx";
	static String sheetName="Multiple_Data";
	
	
	public static void main(String[] args) throws IOException {
		    
		//Create an object of FileInputStream class to read excel file
			FileInputStream fis= new FileInputStream(filePath);
			
			//Creating workbook instance that refers to .xls file
			Workbook workbook=WorkbookFactory.create(fis);
			
			//Creating a Sheet object using the sheet Name
			Sheet sheet=workbook.getSheet(sheetName);
			
			int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
			System.out.println(rowCount);
			
			//Create a loop over all the rows of excel file to read it
			for(int i=1; i<=rowCount; i++)
			{
				int cellCount=sheet.getRow(i).getLastCellNum();
			
				//Create a loop to print cell values in a row
				for(int j=0; j<cellCount; j++)
				{
					System.out.print(sheet.getRow(i).getCell(j).getStringCellValue()+" ");
				}
				System.out.println();
			}
	}
}
