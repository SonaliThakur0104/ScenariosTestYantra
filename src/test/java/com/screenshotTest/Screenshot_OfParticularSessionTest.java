package com.screenshotTest;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.GenericLibrary.WebDriverDataUtility;
import com.pomRepository.FlipkartPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Screenshot_OfParticularSessionTest {
	WebDriver driver=null;
	WebDriverDataUtility webDriverDataUtility;
	FlipkartPage flipkartPage;
	String filePath="./screenshot/flipkart.png";
	
	@BeforeSuite
	public void launchBrowser() {
		
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.flipkart.com/");
	}
	
	@Test
	public void screenShotSessionTest() {
		webDriverDataUtility=new WebDriverDataUtility();
		flipkartPage=new FlipkartPage(driver);
		flipkartPage.closePopupInFlipkart();
		
		File src=flipkartPage.prodinOneSessionDetails().getScreenshotAs(OutputType.FILE);
		File trg= new File(filePath);
		try {
			FileUtils.copyFile(src, trg);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
}
}