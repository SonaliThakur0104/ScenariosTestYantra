package com.Practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pomRepository.MainPage_Goibibo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibibo_CalendarHandling_WithoutPOM_Generic {
	public static void main(String[] args) {
		String shortFromCity="BLR";
		String shortToCity="DEL";
		String fromCity="Bengaluru, India";
		String toCity="New Delhi, India";
		
		String departureDate="20-August-2022";
		String returnDate="15-August-2023";
		String calendarStartingDate="19-July-2022";		
		String calendarEndingDate="02-August-2023";

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//ul[@class='sc-fvxzrP cCkBwj']/li[2]/span[@class='sc-gsNilK dImRia']")).click();
		driver.findElement(By.xpath("//div[@class='sc-bkkeKt gAqCbJ fswFld ']/span[text()='From']")).click();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(shortFromCity);
		driver.findElement(By.xpath("//span[text()='"+fromCity+"']")).click();
		driver.findElement(By.xpath("//div[@class='sc-cidDSM dOEpbS']/input[@type='text']")).sendKeys(shortToCity);
		driver.findElement(By.xpath("//span[text()='"+toCity+"']")).click();

		selectDate(driver, "departure", departureDate,calendarStartingDate);
		selectDate(driver,"return", returnDate,calendarEndingDate );

		driver.findElement(By.xpath("//span[@class='fswTrvl__done']")).click();

		driver.findElement(By.xpath("//div[@class='sc-cZMNgc fLZUIB']/div[1]/div[@class='sc-clIzBv gFdmFA']/span[@class='sc-Galmp clPQEB']/following-sibling::span")).click();
		driver.findElement(By.xpath("//a[@class='sc-dtMgUX daltrV']")).click();

	driver.findElement(By.xpath("//span[@class='sc-fHeRUh jHgPBA']")).click();

	driver.close();
////ul[@class='sc-kEmuub glNRrF']/li/descendant::span[@class='sc-bbkauy jMIuks']

	}

	public static void selectDate(WebDriver driver,String typeOfTrip, String date,String calendarDate)
	{
		int i=typeOfTrip.equals("return")? 2 : 1;

		String reqMonth=date.split("-")[1];
		String reqYear=date.split("-")[2];
		
		int reqDD =Integer.parseInt(date.split("-")[0]);
		int reqMM=LocalDate.parse(date,DateTimeFormatter.ofPattern("dd-MMMM-yyyy")).getMonthValue();
		int reqYY =Integer.parseInt(date.split("-")[2]);
		int calendarDD =Integer.parseInt(calendarDate.split("-")[0]);
		int calendarMM=LocalDate.parse(calendarDate,DateTimeFormatter.ofPattern("dd-MMMM-yyyy")).getMonthValue();
		int calendarYY =Integer.parseInt(calendarDate.split("-")[2]);
		
		
		String[] currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div["+i+"]/div[@class='DayPicker-Caption']/div")).getText().split(" ");
		String currentMonth=currentMonthYear[0];
		String currentYear=currentMonthYear[1];

		while(!(currentMonth.equals(reqMonth) && currentYear.equals(reqYear))) {
			currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[1]/div[@class='DayPicker-Caption']/div")).getText().split(" ");

			currentMonth=currentMonthYear[0];
			currentYear=currentMonthYear[1];
			
			if((reqDD<calendarDD &&  reqMM==calendarMM && reqYY==calendarYY) || (reqDD>calendarDD &&  reqMM==calendarMM && reqYY==calendarYY)) {
				System.out.println("Date is disabled.");
				break;
			
			}
			while(!(currentMonth.equals(reqMonth) && currentYear.equals(reqYear))) {
			currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[2]/div[@class='DayPicker-Caption']/div")).getText().split(" ");
			currentMonth=currentMonthYear[0];
			currentYear=currentMonthYear[1];
			
			
			
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();

			currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[1]/div[@class='DayPicker-Caption']/div")).getText().split(" ");
			currentMonth=currentMonthYear[0];
			currentYear=currentMonthYear[1];
			}
		
		}
		driver.findElement(By.xpath("//div[@class='DayPicker-Month' and contains(.,'"+date.split("-")[1]+"')]//p[text()='"+date.split("-")[0]+"']")).click();
		
		
	}
	
}


