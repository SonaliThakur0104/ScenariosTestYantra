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

public class DisneyHotstar_HomePageScrollTest {

	WebDriver driver=null;
	String genres="Movies Recommended For You";
	WebDriverWait wait;
	JavascriptExecutor jse;

	@BeforeSuite
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.hotstar.com/in");
	}

	@Test
	public void homePageScrolling() {
		wait= new WebDriverWait(driver,10);
		jse=(JavascriptExecutor)driver;
		
		int elements=8;
		int iteration=10;
		for(int i=0;i<40;i++) 
		{
			for(int j=1;j<iteration; j++) {
				if(i==(elements*j))
				{
					driver.findElement(By.xpath("//a[text()='"+genres+"']/ancestor::div[@class='container']/following-sibling::div/i[@class='right-arrow']")).click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		for(int k=0;k<40;k++) 
		{
			for(int m=1;m<iteration; m++) {
				if(k==(elements*m))
				{
					driver.findElement(By.xpath("//a[text()='"+genres+"']/ancestor::div[@class='container']/following-sibling::div/i[@class='left-arrow']")).click();
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
		List<WebElement> lists=driver.findElements(By.xpath("//a[text()='"+genres+"']/ancestor::div/following-sibling::div[@class='slider-container']/descendant::a/div[@class='details']"));
		List<WebElement> listEle = driver.findElements(By.xpath("//a[text()='"+genres+"']/ancestor::div/following-sibling::div[@class='slider-container']/descendant::a/div[@class='details']//span[@class='content-title ellipsise']"));
		System.out.println(listEle.size());
		Actions act = new Actions(driver);

		for(int i=0;i<listEle.size();i++) 
		{
			try {

				Thread.sleep(1000);
				act.moveToElement(lists.get(i)).perform();
				Thread.sleep(1000);
				//wait.until(ExpectedConditions.visibilityOf(lists.get(i)));
				System.out.println(listEle.get(i).getText());

				for(int j=1;j<iteration; j++) {
					if(i==elements*j) {
						Thread.sleep(1000);
						WebElement arrowBtn = driver.findElement(By.xpath("//a[text()='"+genres+"']/ancestor::div[@class='container']/following-sibling::div/i"));
						act.click(arrowBtn).perform();
						Thread.sleep(1000);

					}
				}
			}
			catch(Exception e) {
				e.getMessage();
				System.out.println("===Exception Handled===");
			}
		}
	}

	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}

}
