package com.task.scenariosTest;

import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pomRepository.FlightsPage_Goibibo;
import com.pomRepository.MainPage_Goibibo;
import com.pomRepository.PopularAirlinesPage_Goibibo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibibo_DomesticFlightsTest {

	WebDriver driver=null;
	MainPage_Goibibo mainPage;
	FlightsPage_Goibibo flightsPage;
	PopularAirlinesPage_Goibibo  airlinesPage;
	
	JavascriptExecutor jse;

	String typeOfFlight="Domestic Flights";
	String typeOfDomesticFlight="SpiceJet Airlines";
	String text="SpiceJet Airlines Popular Domestic Routes";

	@BeforeSuite
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://www.goibibo.com/");
	}

	@Test
	public void domesticFlights() {

		mainPage=new MainPage_Goibibo(driver);
		flightsPage=new FlightsPage_Goibibo(driver);
		airlinesPage=new PopularAirlinesPage_Goibibo(driver);
		
		jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)", "");
		mainPage.clickTypeOfFlight(typeOfFlight);
		
		jse.executeScript("window.scrollBy(0,1800)", "");
		flightsPage.clickTypeOfDomesticFlight(typeOfDomesticFlight);

//		airlinesPage.popularAirlinesText();
//
//		Iterator<WebElement> itr1=airlinesPage.fromCityLists().iterator();
//		Iterator<WebElement> itr2=airlinesPage.toCityLists().iterator();
//		Iterator<WebElement> itr3=airlinesPage.priceLists().iterator();
//
//		while(itr1.hasNext() && itr2.hasNext() && itr3.hasNext()) 
//		{
//			String fromCityName=itr1.next().getText();
//			String toCityName=itr2.next().getText();
//			String prices=itr3.next().getText();
//			System.out.println(fromCityName+"  "+toCityName+"  " +prices);
//		}
	}

	@AfterSuite
	public void closeBrowser() {
		//driver.close();
	}
}