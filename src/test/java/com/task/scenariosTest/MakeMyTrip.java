package com.task.scenariosTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {
	public static void main(String[] args)
	{
		String departureDate="10-August-2022";
		String returnDate="10-December-2022";
		String fromCity="Bengaluru, India";
		String toCity="New Delhi, India";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		WebDriverWait wait= new WebDriverWait(driver,10);
		JavascriptExecutor jse=(JavascriptExecutor)driver;
		
		driver.get("https://www.makemytrip.com/");
		driver.switchTo().frame("webklipper-publisher-widget-container-notification-frame");
		driver.findElement(By.xpath("//i[@class='wewidgeticon we_close']")).click();
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//li[@data-cy='roundTrip']")).click();
		driver.findElement(By.xpath("//label[@for='fromCity']/span")).click();
		driver.findElement(By.xpath("//input[@placeholder='From']/following-sibling::div//p[text()='"+fromCity+"']")).click();
		driver.findElement(By.xpath("//input[@placeholder='To']/following-sibling::div//p[text()='"+toCity+"']")).click();

		selectDate(driver, "departure", departureDate);
		selectDate(driver,"return", returnDate);

	}
		public static void selectDate(WebDriver driver,String typeOfTrip, String date)
		{
		int i=typeOfTrip.equals("return")? 2 : 1;
		
		int reqMonth=LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MMMM-yyyy")).getMonthValue();
		int reqYear =Integer.parseInt(date.split("-")[2]);
		
		String currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div["+i+"]/div[@class='DayPicker-Caption']/div")).getText();
		int currentMonth=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.MONTH_OF_YEAR);
		int currentYear=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.YEAR);
		
		while(!(currentMonth==reqMonth && currentYear==reqYear)) {
			currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[2]/div[@class='DayPicker-Caption']/div")).getText();
			currentMonth=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.MONTH_OF_YEAR);
			currentYear=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.YEAR);
			
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[1]/div[@class='DayPicker-Caption']/div")).getText();
			currentMonth=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.MONTH_OF_YEAR);
			currentYear=DateTimeFormatter.ofPattern("MMMMyyyy").withLocale(Locale.ENGLISH).parse(currentMonthYear).get(ChronoField.YEAR);
			}
		driver.findElement(By.xpath("//div[@class='DayPicker-Month' and contains(.,'"+date.split("-")[1]+"')]//p[.='"+date.split("-")[0]+"']")).click();
	
}
}