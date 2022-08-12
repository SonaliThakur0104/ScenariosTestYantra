package com.ScrollHandlingTest;

import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.GenericLibrary.ScrollHandlingUtility;
import com.pomRepository.FlipkartPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Flipkart_ScrollHandlingTest {

	WebDriver driver=null;
	ScrollHandlingUtility scrollHandlingUtility;
	FlipkartPage flipkartPage;
	int data=KeyEvent.VK_PAGE_DOWN;
	int data1=KeyEvent.VK_PAGE_UP;
	Keys key1=Keys.CONTROL;
	Keys key2=Keys.END;
	Keys key3=Keys.HOME;
	int x=500;
	int y1=700;
	int y2=-700;

	
	
	@BeforeSuite
	public void launchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.flipkart.com/");
	}
	
	@Test
	public void scrollPageDownAndUp() {
		scrollHandlingUtility=new ScrollHandlingUtility();
		flipkartPage=new FlipkartPage(driver);
	
		flipkartPage.closePopupInFlipkart();
		scrollHandlingUtility.keyBoardActions(data);
		scrollHandlingUtility.keyBoardActions(data);
		scrollHandlingUtility.keyBoardActions(data1);
		scrollHandlingUtility.keyBoardActions(data1);

		scrollHandlingUtility.scrollHandlingUsingActions(driver, key1, key2);
		scrollHandlingUtility.scrollHandlingUsingActions(driver, key1, key3);

		scrollHandlingUtility.scrollingDownUsingPixels(driver,y1);
		scrollHandlingUtility.scrollingDownUsingPixels(driver,y2);

		scrollHandlingUtility.scrollIntoView(driver, flipkartPage.productDetatils());
		scrollHandlingUtility.scrollIntoView(driver, flipkartPage.topProdDetails());

		scrollHandlingUtility.scrollToBottom(driver);
		scrollHandlingUtility.scrollIntoView(driver, flipkartPage.topProdDetails());

}
}