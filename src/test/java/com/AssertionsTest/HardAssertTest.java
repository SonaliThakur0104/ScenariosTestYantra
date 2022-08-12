package com.AssertionsTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.GenericLibrary.WebDriverDataUtility;
import com.pomRepository.FlipkartPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HardAssertTest {
	
	WebDriver driver=null;
	WebDriverDataUtility webDriverDataUtility;
	FlipkartPage flipkartPage;

	
	@BeforeSuite
	public void launchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.flipkart.com/");
	}
	
	@Test
	public void hardAssert() {
		webDriverDataUtility=new WebDriverDataUtility();
		flipkartPage=new FlipkartPage(driver);
		
		flipkartPage.closePopupInFlipkart();
		String actualTitle=driver.getTitle();
		String expectedTitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		
		Assert.assertEquals(expectedTitle, actualTitle);
		System.out.println("Expected Title and Actual Title are same, therefore test case passed");
		
		Assert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle));
		System.out.println("assertTrue() passed");
		
//		Assert.assertFalse(actualTitle.equalsIgnoreCase(expectedTitle));
//		System.out.println("assertFalse() passed");
//		
		String verifyNull=null;
		Assert.assertNull(verifyNull);
		
		Assert.assertNotNull(actualTitle.equalsIgnoreCase(expectedTitle));
		System.out.println("assertNotNull() is passed");
		
		
	}
		
	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
}
