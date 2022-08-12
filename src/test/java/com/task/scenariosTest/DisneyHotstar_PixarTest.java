package com.task.scenariosTest;

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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import hotstar.ExcelFileUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DisneyHotstar_PixarTest {
	
	WebDriver driver=null;
	WebDriverWait wait;
	JavascriptExecutor jse;
	String genres="Disney+";
	String filePath="C:\\Users\\User\\eclipse-workspace\\hotstar\\src\\test\\resources\\Book1.xlsx";


	
	
	@BeforeSuite
	public void launchBrowser()  {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		try {
			ExcelFileUtility.openExcel(filePath);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		driver.get("https://www.hotstar.com/in");
		
	}
	
	@Test
	public void fetchPixarMovies() {
		wait= new WebDriverWait(driver,10);
		jse=(JavascriptExecutor)driver;

		driver.findElement(By.xpath("//div[text()='"+genres+"']")).click();
		String dataIndex="1260021092";
		driver.findElement(By.xpath("//div[@class='resp-tray-container']/div[@data-index='"+dataIndex+"']")).click();

		String singleElement="Originals";
		driver.findElement(By.xpath("//div[@class='trays']/div/div/descendant::div[@class='container']//a[text()='"+singleElement+"']")).click();
		
		WebElement element=driver.findElement(By.xpath("//a[@class='playstore']"));
		String lastElement=driver.findElement(By.xpath("//p[text()='Connect with us']")).getText();

		for(int j=0; j<80; j++) {
			try {
				Thread.sleep(1000);
				jse.executeScript("arguments[0].scrollIntoView();", element);
				Thread.sleep(2000);
			}
			catch(Exception e){
				e.getMessage();
			}
			if(lastElement.equals("Connect with us")) {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
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
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			act.moveToElement(lists.get(i)).perform();
			wait.until(ExpectedConditions.visibilityOf(lists.get(i)));
			System.out.println(listEle.get(i).getText());
			ExcelFileUtility.setMultipleDataIntoExcel("Sheet1", i+1, 0, singleElement);
			ExcelFileUtility.setDataIntoExcel("Sheet1", i+1, 1, listEle.get(i).getText());
			

		}
	}
	
	@AfterSuite
	public void closeBrowser() {
		try {
			ExcelFileUtility.saveDataIntoExcel(filePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.close();

	}
}