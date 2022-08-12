package com.task.scenariosTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pomRepository.BookMyShow_MainPage;
import com.pomRepository.BookMyShow_SecondPage_Pune;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow_InsideScrollingTest {

	WebDriver driver=null;
	static BookMyShow_MainPage mainPage;
	static BookMyShow_SecondPage_Pune secondPage;
	String popularCities="Chennai";
	String genre="Recommended Movies";
	String popularCities2="Pune";

	@BeforeSuite
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://in.bookmyshow.com/");
	}


	@Test
	public void insideScrollingq() {
		mainPage=new BookMyShow_MainPage(driver);
		secondPage=new BookMyShow_SecondPage_Pune(driver);

		mainPage.clickPopularCities(popularCities);
		System.out.println(mainPage.singleSectionName(genre));
		mainPage.clickRightArrow();
		mainPage.clickLeftArrow();
		mainPage.printAllTenMovies();
		mainPage.clickCitiesDropdown(driver);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-100)", "");
		mainPage.clickPopularCities(popularCities2);
		secondPage.clickSeeAll();
		System.out.println();
		System.out.println(secondPage.fetchTextfromCity());
		secondPage.getSizeOfAllMoviesInsidePage();
	}

	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}

}
