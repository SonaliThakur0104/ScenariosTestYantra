package com.ActionsPracticeTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.GenericLibrary.WebDriverDataUtility;
import com.pomRepository.ActionsClassPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class KeyUPKeyDownTest {
	WebDriver driver=null;
	WebDriverDataUtility webDriverDataUtility;
	ActionsClassPage actionsClassPage;
	String name="Sonali";
	String email="abc@xyz.com";
	String address="Banglore Karnataka";
	String key1="a";
	String key2="c";
	String key3="v";

	
	@BeforeSuite
	public void launchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://demoqa.com/text-box");
	}
	
	@Test
	public void keyUpKeyDownTest() {
		webDriverDataUtility=new WebDriverDataUtility();
		actionsClassPage=new ActionsClassPage(driver);
		
		actionsClassPage.nameText(name);
		actionsClassPage.emailText(email);
		//Enter the current Address
		actionsClassPage.currentAddressText(address);
		//select the current address
		webDriverDataUtility.keyDownAndKeyUp(driver, key1);
		//copy the current address
		webDriverDataUtility.keyDownAndKeyUp(driver, key2);
		//Press the TAB Key to Switch Focus to Permanent Address
		webDriverDataUtility.keyInsideSendKeys(driver);
		//Paste the Address in the Permanent Address field
		webDriverDataUtility.keyDownAndKeyUp(driver, key3);


}
}