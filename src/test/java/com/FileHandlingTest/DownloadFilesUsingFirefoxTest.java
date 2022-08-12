package com.FileHandlingTest;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.GenericLibrary.WebDriverDataUtility;
import com.pomRepository.FileHandlingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DownloadFilesUsingFirefoxTest {
	WebDriver driver=null;
	WebDriverDataUtility webDriverDataUtility;
	FileHandlingPage fileHandlingPage;
	String text="testing";
	
	
	@BeforeSuite
	public void launchBrowser() {
		// Additional Settings for fireFox browser
		FirefoxProfile profile=new FirefoxProfile();
		profile.setPreference("browser.helperApps.neverAsk.saveToDisk", "text/plain,application/pdf");// MIME Type
		profile.setPreference("browser.download.manager.showWhenStarting", false);
		profile.setPreference("pdfjs.disabled", true); //only for PDF file
		
		FirefoxOptions option=new FirefoxOptions();
		option.setProfile(profile);
		
		
	WebDriverManager.firefoxdriver().setup();
	driver=new FirefoxDriver(option);
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
