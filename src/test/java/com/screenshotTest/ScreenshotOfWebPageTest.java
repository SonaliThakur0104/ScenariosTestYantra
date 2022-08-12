package com.screenshotTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import com.GenericLibrary.WebDriverDataUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotOfWebPageTest {
	WebDriver driver=null;
	WebDriverDataUtility webDriverDataUtility;

	String filePath="./screenshot/google.png";
	
	@BeforeSuite
	public void launchBrowser() {
		
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.google.com/");
	}
	
	@Test
	public void screenShotGooglePageTest() {
		webDriverDataUtility=new WebDriverDataUtility();
		
		//Screenshot of a particular webpage
		webDriverDataUtility.screenShotActions(driver,filePath);

}
}