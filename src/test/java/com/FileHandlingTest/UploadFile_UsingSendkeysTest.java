package com.FileHandlingTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.GenericLibrary.WebDriverDataUtility;
import com.pomRepository.FileHandlingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile_UsingSendkeysTest {
	WebDriver driver=null;
	FileHandlingPage fileHandlingPage;
	String filePath="C:\\Users\\User\\Desktop\\LoginPage.java";

	
	@BeforeSuite
	public void launchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://the-internet.herokuapp.com/upload");
	}
	
	@Test
	public void uploadFileTest() {
		fileHandlingPage=new FileHandlingPage(driver);
		fileHandlingPage.chooseFileBtn(filePath);
		}
}
