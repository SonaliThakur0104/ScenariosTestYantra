package com.ActionsPracticeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.GenericLibrary.WebDriverDataUtility;
import com.pomRepository.ActionsClassPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ClickAndHoldTest {
	WebDriver driver=null;
	WebDriverDataUtility webDriverDataUtility;
	ActionsClassPage actionsClassPage;
	
	
	@BeforeSuite
	public void launchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
	}
	
	@Test
	public void signInMouseHover() {
		webDriverDataUtility=new WebDriverDataUtility();
		actionsClassPage=new ActionsClassPage(driver);
		
//		webDriverDataUtility.moveToElement(driver, actionsClassPage.clickAndHoldAlphabet());
//		webDriverDataUtility.clickAndHold(driver);
		
		webDriverDataUtility.clickAndHoldElement(driver, actionsClassPage.clickAndHoldAlphabet(),actionsClassPage.clickAndHoldSecondAlphabet());

}
}