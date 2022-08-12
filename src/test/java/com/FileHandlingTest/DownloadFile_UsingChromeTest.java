package com.FileHandlingTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.GenericLibrary.WebDriverDataUtility;
import com.pomRepository.FileHandlingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFile_UsingChromeTest {
		
		WebDriver driver=null;
		WebDriverDataUtility webDriverDataUtility;
		FileHandlingPage fileHandlingPage;
		String text="testing";
		
		
		@BeforeSuite
		public void launchBrowser() {
			
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.automationtesting.in/FileDownload.html");
		}
		
		@Test
		public void downloadFileTest() {
			webDriverDataUtility=new WebDriverDataUtility();
			fileHandlingPage=new FileHandlingPage(driver);
			
			fileHandlingPage.enterTextInDemoAutomation(text);
			fileHandlingPage.generateFileInDemoAutomation();
			fileHandlingPage.clickDownloadInDemoAutomation();
			
			fileHandlingPage.enterTextInPDFDemoAutomation(text);
			fileHandlingPage.generateFileInPDFDemoAutomation();
			fileHandlingPage.clickDownloadInPDFDemoAutomation();

}
}
