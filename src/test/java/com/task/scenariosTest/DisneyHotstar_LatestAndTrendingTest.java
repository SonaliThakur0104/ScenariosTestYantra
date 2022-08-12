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

public class DisneyHotstar_LatestAndTrendingTest {
	WebDriver driver=null;
	WebDriverWait wait;
	JavascriptExecutor jse;
	String genres="Latest & Trending";


	@BeforeSuite
	public void launchBrowser() {

		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.hotstar.com/in");
	}

	@Test
	public void fetchHomePageMovies() {

		wait= new WebDriverWait(driver,20);
		jse=(JavascriptExecutor)driver;
		List<WebElement> lists=driver.findElements(By.xpath("//a[text()='"+genres+"']/ancestor::div[@class='container']/following-sibling::div/descendant::a/div[@class='details']"));
		List<WebElement> listEle = driver.findElements(By.xpath("//a[text()='"+genres+"']/ancestor::div[@class='container']/following-sibling::div/descendant::a/div[@class='details']//span[@class='content-title ellipsise']"));
		System.out.println(listEle.size());

		Actions act = new Actions(driver);
		for(int i=0; i<listEle.size(); i++) 
		{
			if(i<8) {
			act.moveToElement(lists.get(i)).perform();
			wait.until(ExpectedConditions.visibilityOf(lists.get(i)));
			System.out.println(listEle.get(i).getText());
			System.out.println("done");
			}
			else {
			if(i==listEle.size()/2) {
				driver.findElement(By.xpath("//a[text()='"+genres+"']/ancestor::div[@class='container']/following-sibling::div/i")).click();
			}
			act.moveToElement(lists.get(i)).perform();
			wait.until(ExpectedConditions.visibilityOf(lists.get(i)));
			System.out.println(listEle.get(i).getText());
			System.out.println("done");
			}
		}
	}

	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
}