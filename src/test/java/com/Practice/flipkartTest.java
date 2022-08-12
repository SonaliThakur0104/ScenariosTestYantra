package com.Practice;

import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class flipkartTest {
	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		String product="iphone 13";
		String phoneName="APPLE iPhone 13 (Pink, 128 GB)";

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2doB4z']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(product);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//div[.='"+phoneName+"']")).click();
		
		Set<String> sessionIds=driver.getWindowHandles();
		for(String id: sessionIds) {
			driver.switchTo().window(id);
			if(driver.getTitle().equals("apple-iphone-13-pink-128-gb")) {
				break;
			}
		}
		
		driver.findElement(By.xpath("//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")).click();
		
		WebElement name = driver.findElement(By.xpath("//a[contains(text(),'iPhone 13')]"));
		String pro = name.getText();
		
		Assert.assertEquals(phoneName, pro);
		System.out.println("TC Passed");
		driver.quit();

	}
}
