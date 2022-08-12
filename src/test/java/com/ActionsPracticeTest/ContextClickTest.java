package com.ActionsPracticeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.GenericLibrary.WebDriverDataUtility;
import com.pomRepository.ActionsClassPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ContextClickTest {
	WebDriver driver=null;
	WebDriverDataUtility webDriverDataUtility;
	ActionsClassPage actionsClassPage;
	
	
	@BeforeSuite
	public void launchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("http://demo.guru99.com/test/simple_context_menu.html");
	}
	
	@Test
	public void contextClick() {
		webDriverDataUtility=new WebDriverDataUtility();
		actionsClassPage=new ActionsClassPage(driver);
		
		// Context Click
//		webDriverDataUtility.moveToElement(driver, actionsClassPage.contextLinkClick());
//		webDriverDataUtility.contextClick(driver);
//		
		webDriverDataUtility.contextClickElement(driver, actionsClassPage.contextLinkClick());
		
		//Click quit
		webDriverDataUtility.moveToElement(driver, actionsClassPage.clickQuitText());
		webDriverDataUtility.click(driver);
		webDriverDataUtility.alertAccept(driver);
		
		//Double click
		webDriverDataUtility.moveToElement(driver, actionsClassPage.doubleLinkClick());
		webDriverDataUtility.doubleClick(driver);
		
		//webDriverDataUtility.doubleClickElement(driver, actionsClassPage.doubleLinkClick());
		webDriverDataUtility.alertAccept(driver);

		

}
}