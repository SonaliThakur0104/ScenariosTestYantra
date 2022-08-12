package com.ActionsPracticeTest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.GenericLibrary.WebDriverDataUtility;
import com.pomRepository.ActionsClassPage;
import com.pomRepository.FlipkartPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_DragAndDropByTest {
	WebDriver driver=null;
	WebDriverDataUtility webDriverDataUtility;
	ActionsClassPage actionsClassPage;
	FlipkartPage flipkartPage;
	String text="iphone 13";

	
	@BeforeSuite
	public void launchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.flipkart.com/");
	}
	
	@Test
	public void contextClick() {
		webDriverDataUtility=new WebDriverDataUtility();
		actionsClassPage=new ActionsClassPage(driver);
		flipkartPage=new FlipkartPage(driver);
		
		flipkartPage.closePopupInFlipkart();
		flipkartPage.searchTextInFlipkart(text);
		webDriverDataUtility.dragAndDropBy(driver, flipkartPage.sliderStartInFlipkart(), 60, 0);
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		flipkartPage.explicitlyWait(driver);
		webDriverDataUtility.dragAndDropBy(driver, flipkartPage.sliderEndInFlipkart(), -60, 0);

		

}
}