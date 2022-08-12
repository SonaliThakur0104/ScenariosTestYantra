package com.Practice;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import hotstar.ExcelFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DisneyHotstar_Pixar_NonGeneric {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver,20);
		JavascriptExecutor jse=(JavascriptExecutor)driver;

		String filePath="C:\\Users\\User\\eclipse-workspace\\hotstar\\src\\test\\resources\\Book1.xlsx";
		
		ExcelFileUtility.openExcel(filePath);
		//Sheet sheet=wb.getSheet("Sheet1");
		
		driver.get("https://www.hotstar.com/in");

		String genres="Disney+";
		driver.findElement(By.xpath("//div[text()='"+genres+"']")).click();
		String dataIndex="6120";
		driver.findElement(By.xpath("//div[@class='resp-tray-container']/div[@data-index='"+dataIndex+"']")).click();

		String singleElement="Movies";
		driver.findElement(By.xpath("//div[@class='trays']/div/div/descendant::div[@class='container']//a[text()='"+singleElement+"']")).click();

		String lastElement=driver.findElement(By.xpath("//p[text()='Connect with us']")).getText();
		WebElement element=driver.findElement(By.xpath("//a[@class='playstore']"));
		for(int j=0; j<60; j++) {
			try {
				Thread.sleep(2000);
				jse.executeScript("arguments[0].scrollIntoView();", element);
				Thread.sleep(2000);
			}
			catch(Exception e){
				e.getMessage();
			}
			if(lastElement.equals("Connect with us")) {
				Thread.sleep(2000);
			break;
			}

		}
		List<WebElement> lists=driver.findElements(By.xpath("//h2[text()='"+singleElement+"']/parent::div/descendant::a/div[@class='details']"));
		List<WebElement> listEle = driver.findElements(By.xpath("//h2[text()='"+singleElement+"']/parent::div/descendant::a/div[@class='details']/descendant::span[@class='content-title ellipsise']"));
		System.out.println(listEle.size());

		ExcelFileUtility.setMultipleDataIntoExcel("Sheet1", 0, 0, "Genres");
		ExcelFileUtility.setDataIntoExcel("Sheet1", 0, 1, "Movies");

		Actions act = new Actions(driver);
		for(int i=0;i<listEle.size();i++) 
		{
			Thread.sleep(1000);
			act.moveToElement(lists.get(i)).perform();
			wait.until(ExpectedConditions.visibilityOf(lists.get(i)));
		
			System.out.println(listEle.get(i).getText());
//			Row row = sheet.createRow(0);
//			Cell cell1=row.createCell(0);
//			cell1.setCellValue("Genres");

//			Cell cell2=row.createCell(1);
//			cell2.setCellValue("Movies");
			
			ExcelFileUtility.setMultipleDataIntoExcel("Sheet1", i+1, 0, singleElement);

//			Row row1 = sheet.createRow(i+1);
//			Cell cell3=row1.createCell(0);
//			cell3.setCellValue(singleElement);
			
			ExcelFileUtility.setDataIntoExcel("Sheet1", i+1, 1, listEle.get(i).getText());

//			Cell cell4=row1.createCell(1);
//			cell4.setCellValue(listEle.get(i).getText());
			
		}
		ExcelFileUtility.saveDataIntoExcel(filePath);
//		FileOutputStream fos=new FileOutputStream("C:\\Users\\User\\eclipse-workspace\\hotstar\\src\\test\\resources\\Book1.xlsx");
//		wb.write(fos);
//		fos.close();
		driver.close();

	}

}
