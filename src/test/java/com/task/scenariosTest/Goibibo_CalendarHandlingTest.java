package com.task.scenariosTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pomRepository.MainPage_Goibibo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibibo_CalendarHandlingTest {
	static MainPage_Goibibo mainPage;
	public static void main(String[] args) {
		String shortFromCity="BLR";
		String shortToCity="DEL";
		String fromCity="Bengaluru, India";
		String toCity="New Delhi, India";
		String departureDate="20-October-2022";
		String returnDate="23-July-2023";

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		mainPage=new MainPage_Goibibo(driver);

		driver.get("https://www.goibibo.com/");
		mainPage.clickRoundTrip(driver);
		mainPage.fromToClick(driver, shortFromCity, fromCity,shortToCity,toCity);

		selectDate(driver, "departure", departureDate);
		selectDate(driver,"return", returnDate);

		mainPage.clickCalendarDone();
		mainPage.clickNumberOfAdults(driver);
		mainPage.searchFlights();
		//driver.close();
		}

	public static void selectDate(WebDriver driver,String typeOfTrip, String date)
	{
		mainPage=new MainPage_Goibibo(driver);

		int i=typeOfTrip.equals("return")? 2 : 1;

		String reqMonth=date.split("-")[1];
		String reqYear=date.split("-")[2];

		String[] currentMonthYear=mainPage.currentMonthYear(driver, i);
		String currentMonth=currentMonthYear[0];
		String currentYear=currentMonthYear[1];

		while(!(currentMonth.equals(reqMonth) && currentYear.equals(reqYear)))
		{
			currentMonthYear=mainPage.firstCurrentMonthYear(driver);
			currentMonth=currentMonthYear[0];
			currentYear=currentMonthYear[1];
			while(!(currentMonth.equals(reqMonth) && currentYear.equals(reqYear)))
			{
				currentMonthYear=mainPage.secondCurrentMonthYear(driver);
				currentMonth=currentMonthYear[0];
				currentYear=currentMonthYear[1];

				mainPage.clickingNext();

				currentMonthYear=mainPage.firstCurrentMonthYear(driver);
				currentMonth=currentMonthYear[0];
				currentYear=currentMonthYear[1];
			}
		}
		mainPage.clickDate(driver, date);

	}
}


