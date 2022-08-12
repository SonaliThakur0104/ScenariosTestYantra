package com.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pomRepository.BookMyShow_MainPage;
import com.pomRepository.BookMyShow_SecondPage_Pune;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BookMyShow_InsideScrolling {
	
	static BookMyShow_MainPage mainPage;

	public static void main(String[] args) {
		String popularCities="Chennai";
		String genre="Recommended Movies";
		String popularCities2="Pune";
		//String lastElement="Contact today!";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		mainPage=new BookMyShow_MainPage(driver);
		BookMyShow_SecondPage_Pune secondPage=new BookMyShow_SecondPage_Pune(driver);
		
		driver.get("https://in.bookmyshow.com/");
		mainPage.clickPopularCities(popularCities);
		mainPage.clickRightArrow();
		mainPage.clickLeftArrow();
		mainPage.printAllTenMovies();
		//mainPage.printRecommendedMovies();
		mainPage.clickCitiesDropdown(driver);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,-100)", "");
		mainPage.clickPopularCities(popularCities2);
		secondPage.clickSeeAll();
		System.out.println();
		System.out.println(secondPage.fetchTextfromCity());
		secondPage.getSizeOfAllMoviesInsidePage();
		driver.close();
}
}