package com.task.scenariosTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pomRepository.BookMyShow_MainPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow_HomePageScrollingTest {
	
		WebDriver driver=null;
		static BookMyShow_MainPage mainPage;
	
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
		public void homePageScroll() {
		mainPage=new BookMyShow_MainPage(driver);
		mainPage.clickPopularCities(popularCities );
		mainPage.clickRightArrow();
		mainPage.clickLeftArrow();
		mainPage.printAllTenMovies();
		//mainPage.printRecommendedMovies(genre);
		mainPage.clickCitiesDropdown(driver);
		mainPage.clickPopularCities(popularCities2);
		mainPage.clickRightArrow();
		mainPage.clickLeftArrow();
		mainPage.printAllTenMovies();
//		mainPage.printRecommendedMovies(genre);
		}
		
		@AfterSuite
		public void CloseBrowser() {
		driver.close();
		}
}
