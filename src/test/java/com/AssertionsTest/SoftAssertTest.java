package com.AssertionsTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.GenericLibrary.WebDriverDataUtility;
import com.pomRepository.FlipkartPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SoftAssertTest {
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
		SoftAssert softAssert= new SoftAssert();

		flipkartPage.closePopupInFlipkart();
		
		String actualTitle=driver.getTitle();
		String expectedTitle="Online Shopping Site for Mobiles, Electronics, Furniture, Grocery, Lifestyle, Books & More. Best Offers!";
		
		//Verify assertEquals():
		softAssert.assertEquals(actualTitle, expectedTitle);
		System.out.println("assertEquals() is passed");
		
		//Verify assertNotequals()
		softAssert.assertNotEquals(actualTitle, "Online Shopping Site for Mobiles, Electronics,");
		System.out.println("assertNotEquals() is passed");
		
		softAssert.assertNotEquals(actualTitle, expectedTitle); //here exception is there
		System.out.println("assertNotEquals1() is passed"); //because of soft assert it is executing next line
		
		//Verify softAssert.assertNull();
		softAssert.assertNull(actualTitle);
		System.out.println("Null Failed"); // exception
		softAssert.assertNull(null, "Passed");
		System.out.println("Assert null passed");
		
		// Verify softAssert.assertNotNull():
		softAssert.assertNotNull(expectedTitle);	
		System.out.println("softAsset.assertNotNull passed");
		
		// Verify softAssert.assertTrue()
		softAssert.assertTrue(actualTitle.equalsIgnoreCase(expectedTitle));
		System.out.println("softAssert.assertTrue() passed");
	
		//verify softAssert.assertFalse()
		softAssert.assertFalse(actualTitle.equalsIgnoreCase("Online Shopping Site for Mobiles, Electronics,"));
		System.out.println("softAssert.assertFalse() passed");
		
		//verfy softAssert.assertAll()
		softAssert.assertAll();
	}
	
	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
}