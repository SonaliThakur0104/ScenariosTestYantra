package com.ActionsPracticeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.GenericLibrary.WebDriverDataUtility;
import com.pomRepository.ActionsClassPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyUpKeyDown_WithElementGoogleTest {

	WebDriver driver=null;
	WebDriverDataUtility webDriverDataUtility;
	ActionsClassPage actionsClassPage;
	String text="selenium";

	
	@BeforeSuite
	public void launchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.google.com/");
	}
	
	@Test
	public void keyUpKeyDownTest() {
		webDriverDataUtility=new WebDriverDataUtility();
		actionsClassPage=new ActionsClassPage(driver);
		
		webDriverDataUtility.keyDownElementTarget(driver,actionsClassPage.textInGoogle(), text);
		webDriverDataUtility.keyUpElementTarget(driver, actionsClassPage.textInGoogle(), text);
		
		//Sending text in google Search box using sendKeys with elemnt target
		//webDriverDataUtility.sendKeysElementTarget(driver, actionsClassPage.textInGoogle(), text);
}
}
