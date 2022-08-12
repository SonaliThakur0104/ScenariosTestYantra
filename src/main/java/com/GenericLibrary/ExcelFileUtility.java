package com.GenericLibrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {

	static public Workbook wb;
	static public Sheet sheet;
	static public Cell cell;

	/**
	 * This method is used to open the excel connection.
	 * @param filePath
	 * @throws IOException
	 */
	public static void openExcel(String filePath) throws  IOException {
		FileInputStream fis=new FileInputStream(filePath);
		wb=WorkbookFactory.create(fis);
	}
	
	/**
	 * This method is used to fetch the data from excel.
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public static String fetchDataFromexcel(String sheetName, int rowNum, int cellNum) {
		String value=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}

	/**
	 * This method is used to fetch the data from excel using DataFormatter Class.
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 */
	public static String fetchAnyTypeofDataFromexcel(String sheetName,int rowNum, int cellNum) 
	{
		Cell cell=wb.getSheet(sheetName).getRow(rowNum).getCell(cellNum);
		DataFormatter formatter=new DataFormatter();
		String data;
        try {
		data=formatter.formatCellValue(cell);
        }
        catch(Exception e){
        	data="";
        }
		return data;
	}
	
	/**
	 * This method is used to get the no of rows in the sheet.
	 * @param sheetName
	 * @return
	 */
	public static int getRowCount(String sheetName) {
		sheet=wb.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println(rowCount);
		return rowCount;
	}
	
	/**
	 * This method is used get the no of cells in the given sheet.
	 * @param sheetName
	 * @param rowNum
	 * @return
	 */
	public static int getcellCount(String sheetName, int rowNum) {
		sheet=wb.getSheet(sheetName);
		int cellCount=sheet.getRow(rowNum).getLastCellNum();
		return cellCount;
	}
	
	
	/**
	 *  This method is used for writing  data into new cell in existing row.
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param message
	 */
	public static void setDataIntoExcel(String sheetName,int rowNum,int cellNum,String message) {
		wb.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(message);

	}

	/**
	 * This method is used to create new Row and set data in new cell.
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @param message
	 */
	public static void setMultipleDataIntoExcel(String sheetName,int rowNum,int cellNum,String message) {
		wb.getSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(message);

	}

	/**
	 * This method is used to save data into Excel.
	 * @param filePath
	 * @throws IOException
	 */
	public static void saveDataIntoExcel(String filePath) throws IOException {
		FileOutputStream fos=new FileOutputStream(filePath);
		wb.write(fos);
		fos.close();
	}

	/**
	 * This method is used to cloise the excel connection.
	 */
   public static void closeExcel() {
	   try {
		wb.close();
	} catch (IOException e) {
		e.printStackTrace();
	}
   }


}
