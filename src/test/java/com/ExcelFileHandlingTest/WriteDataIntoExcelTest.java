package com.ExcelFileHandlingTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WriteDataIntoExcelTest {

	static String filePath="C:\\Users\\User\\eclipse-workspace\\hotstar\\src\\test\\resources\\StudentDetails.xlsx";
	static String sheetName="Student Details";

	public static void main(String[] args) throws IOException {

		FileInputStream fis=new FileInputStream(filePath);
		Workbook workbook=WorkbookFactory.create(fis);
		Sheet sheet=workbook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum()-sheet.getFirstRowNum();

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/automation-practice-form");

		//Identify the WebElements for the student registration form
		WebElement firstName=driver.findElement(By.id("firstName"));
		WebElement lastName=driver.findElement(By.id("lastName"));
		WebElement email=driver.findElement(By.id("userEmail"));
		WebElement gender=driver.findElement(By.id("gender-radio-2"));
		WebElement phoneNumber=driver.findElement(By.id("userNumber"));
		WebElement address=driver.findElement(By.id("currentAddress"));
		WebElement submitBtn=driver.findElement(By.id("submit"));


		firstName.sendKeys(sheet.getRow(1).getCell(0).getStringCellValue());
		lastName.sendKeys(sheet.getRow(1).getCell(1).getStringCellValue());
		email.sendKeys(sheet.getRow(1).getCell(2).getStringCellValue());
		phoneNumber.sendKeys(sheet.getRow(1).getCell(4).toString());
		address.sendKeys(sheet.getRow(1).getCell(5).getStringCellValue());
	
		//create a new cell in the row at index 6
		sheet.getRow(0).createCell(6).setCellValue("Comment");
		sheet.getRow(1).createCell(6).setCellValue("Pass");
		sheet.getRow(2).createCell(6).setCellValue("Pass");
		
		//Creating a  new third row with new cell values.
		sheet.createRow(3).createCell(0).setCellValue("Dikshya");
		sheet.getRow(3).createCell(1).setCellValue("Thakur");
		sheet.getRow(3).createCell(2).setCellValue("fgh@xcv.com");
		sheet.getRow(3).createCell(3).setCellValue("Female");
		sheet.getRow(3).createCell(4).setCellValue("7777777777");
		sheet.getRow(3).createCell(5).setCellValue("pqrst, Madhya Pradesh");
		sheet.getRow(3).createCell(6).setCellValue("Fail");

		
		// Write the data back in the Excel file
		FileOutputStream fos=new FileOutputStream(filePath);
		workbook.write(fos);
		workbook.close();
		driver.close();
		
	}

}
