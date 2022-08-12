package com.task.scenariosTest;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pomRepository.MainPage_Goibibo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibibo_SuggestionsHandlingTest {

	WebDriver driver=null;
	MainPage_Goibibo mainPage;
	String firstLetter="j";

	@BeforeSuite
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.goibibo.com/");
	}

	@Test
	public void suggestionHandling() {
		mainPage=new MainPage_Goibibo(driver);
		mainPage.clickRoundTrip(driver);

		mainPage.clickFromText();
		mainPage.enterFromText(firstLetter);

		System.out.println("The cities starts with " +firstLetter+ " are as follows: ");
		System.out.println();
		Iterator<WebElement> itr1=mainPage.cityLists().iterator();
		Iterator<WebElement> itr2=mainPage.shortCitiesLists().iterator();
		Iterator<WebElement> itr3=mainPage.airportNameLists().iterator();
		Iterator<WebElement> itr4=mainPage.inNameLists().iterator();

		while(itr1.hasNext() && itr2.hasNext() && itr3.hasNext() && itr4.hasNext()) 
		{
			String cityName=itr1.next().getText();
			String shortCityName=itr2.next().getText();
			String airportName=itr3.next().getText();
			String inName=itr4.next().getText();

			System.out.println(cityName+" "+shortCityName+ " "+inName);
			System.out.println(airportName);
		}
	}

	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
}