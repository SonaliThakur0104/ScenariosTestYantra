package com.ActionsPracticeTest;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.GenericLibrary.ScrollGeneric;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScrollingTest {
	
		ScrollGeneric scrollGeneric=new ScrollGeneric();

		@Test
		public void scrollPage() throws InterruptedException
		{
			WebDriverManager.chromedriver().setup();
			ChromeOptions crm=new ChromeOptions();
			crm.addArguments("--disable-notifications");
			WebDriver driver=new ChromeDriver(crm);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
			driver.manage().window().maximize();
			driver.get("https://hindi.news18.com/");
			Thread.sleep(4000);
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(2000));
			//wait.until(ExpectedConditions.visibilityOf(ele));
//			scrollGeneric.scrollPage(Keys.TAB, driver);
//			Thread.sleep(2000);
//			scrollGeneric.scrollPage(Keys.ENTER, driver);
			WebElement ele = driver.findElement(By.xpath("//a[@class='jsx-3141597514' and text()='देश']"));
			scrollGeneric.locatableElement(ele);
			Thread.sleep(2000);
			String text = ele.getText();
			Reporter.log(text, true);

	}
	}

