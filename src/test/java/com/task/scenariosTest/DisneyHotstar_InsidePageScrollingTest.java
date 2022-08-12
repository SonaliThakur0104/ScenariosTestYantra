package com.task.scenariosTest;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

import io.github.bonigarcia.wdm.WebDriverManager;

public class DisneyHotstar_InsidePageScrollingTest {

	WebDriver driver=null;
	String genres="Popular Movies";

	
	@BeforeSuite
	public void launchBrowser() {
	WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.hotstar.com/in");
	}
	
	
	@Test
	public void insideScrolling() {
		WebDriverWait wait= new WebDriverWait(driver,20);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
        driver.findElement(By.xpath("//a[text()='"+genres+"']")).click();

		WebElement element=driver.findElement(By.xpath("//a[@class='playstore']"));
		

		List<WebElement> lists=driver.findElements(By.xpath("//h2[text()='"+genres+"']/parent::div/descendant::a/div[@class='details']"));
		List<WebElement> listEle = driver.findElements(By.xpath("//h2[text()='"+genres+"']/parent::div/descendant::a/div[@class='details']/descendant::span[@class='content-title ellipsise']"));
		
		for(int j=0; j<80; j++) {
			try {
				jse.executeScript("arguments[0].scrollIntoView();", element);
				Thread.sleep(2000);
			}
			catch(Exception e){
				e.getMessage();
			}
		}
		System.out.println(listEle.size());

		Actions act = new Actions(driver);
		for(int i=0;i<listEle.size();i++) 
		{
			act.moveToElement(lists.get(i)).perform();
			wait.until(ExpectedConditions.visibilityOf(lists.get(i)));
			System.out.println(listEle.get(i).getText());
		}
	}
	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
	}