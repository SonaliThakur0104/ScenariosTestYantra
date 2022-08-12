package com.FileHandlingTest;

import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.GenericLibrary.WebDriverDataUtility;
import com.pomRepository.FileHandlingPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class UploadFile_UsingRobotClassTest {
	WebDriver driver=null;
	WebDriverDataUtility webDriverDataUtility;
	FileHandlingPage fileHandlingPage;
	String filePath="C:\\Users\\User\\Desktop\\LoginPage.java";
	int keyCode1=KeyEvent.VK_CONTROL;
	int keyCode2=KeyEvent.VK_V;
	int keyCode3=KeyEvent.VK_ENTER;

	
	@BeforeSuite
	public void launchBrowser() {
	WebDriverManager.chromedriver().setup();
	driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	driver.get("https://www.grammarly.com/plagiarism-checker");
	}
	
	@Test
	public void uploadFileTest() {
		webDriverDataUtility=new WebDriverDataUtility();
		fileHandlingPage=new FileHandlingPage(driver);
		
		// Click the upload file area
		fileHandlingPage.uploadFileInPlagiarismChecker();
		
		//Select the path
		StringSelection path=new StringSelection(filePath);
		
		//Access Clipboard
		Clipboard clipboard=Toolkit.getDefaultToolkit().getSystemClipboard();
		
		//Copy the path in clipboard
		clipboard.setContents(path, null);
		
		//Paste the path
		webDriverDataUtility.keyPressRobotActions(keyCode1);
		webDriverDataUtility.keyPressRobotActions(keyCode2);
		
		webDriverDataUtility.keyReleaseRobotActions(keyCode1);
		webDriverDataUtility.keyReleaseRobotActions(keyCode2);

		webDriverDataUtility.keyPressRobotActions(keyCode3);
		webDriverDataUtility.keyReleaseRobotActions(keyCode3);


	}
	}
