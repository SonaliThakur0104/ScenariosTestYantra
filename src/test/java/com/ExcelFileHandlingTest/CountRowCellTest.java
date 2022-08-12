package com.ExcelFileHandlingTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CountRowCellTest {
	static String filePath="C:\\Users\\User\\eclipse-workspace\\hotstar\\src\\test\\resources\\StudentDetails.xlsx";
	static String sheetName="Student Details";
		
	public static void main(String[] args) throws IOException {
		    
		//Create an object of FileInputStream class to read excel file
			FileInputStream fis= new FileInputStream(filePath);
			
			//Creating workbook instance that refers to .xls file
			Workbook workbook=WorkbookFactory.create(fis);
			
			//Creating a Sheet object using the sheet Name
			Sheet sheet=workbook.getSheet(sheetName);
			
			//get all rowa in the sheet
			int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
			System.out.println(rowCount);
			
			//iterate over all the row to print the data present in each cell.
			for(int i=0; i<rowCount; i++)
			{
				//get cell count in a row
				int cellCount=sheet.getRow(i).getLastCellNum();
				System.out.println(cellCount);
				
				//iterate over each cell to print it's value
				System.out.println("Row " +i+ " has data: ");
				
				for(int j=0; j<cellCount; j++)
				{
					String value=sheet.getRow(i).getCell(j).toString();
					System.out.print(value+ " ");
				}
				
				System.out.println();		
				
			}

}
}