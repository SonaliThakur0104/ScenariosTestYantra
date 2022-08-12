package com.ScrollHandlingTest;

import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.GenericLibrary.ScrollHandlingUtility;
import com.pomRepository.ScrollActionPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vogue_HorizontalScrollingTest {
	WebDriver driver=null;
	ScrollHandlingUtility scrollHandlingUtility;
	ScrollActionPage scrollActionPage;

	
	@BeforeSuite
	public void launchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.vogue.es/micros/tendencias-moda-anos-80/");
	}
	
	@Test
	public void scrollPageDownAndUp() {
		scrollHandlingUtility=new ScrollHandlingUtility();
		scrollActionPage=new ScrollActionPage(driver);
		
		scrollActionPage.closePopupInVogue();
		scrollHandlingUtility.scrollIntoView(driver, scrollActionPage.elementViewInVogue());
	}

}
