package com.Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibibo_CalendarHandling {
	public static void main(String[] args) {
		String shortFromCity="BLR";
		String shortToCity="DEL";
		String fromCity="Bengaluru, India";
		String toCity="New Delhi, India";
		String departureDate="20-July-2022";
		String returnDate="23-January-2023";

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

		
		String reqDepartureMonth=departureDate.split("-")[1];
		String reqDepartureYear=departureDate.split("-")[2];
		String reqReturnMonth=returnDate.split("-")[1];
		String reqReturnYear=returnDate.split("-")[2];
		
		String[] currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[1]/descendant::div[@class='DayPicker-Caption']/div")).getText().split(" ");
		String currentMonth=currentMonthYear[0];
		String currentYear=currentMonthYear[1];

		while(!(currentMonth.equals(reqDepartureMonth) && currentYear.equals(reqDepartureYear))) {
			currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[2]/descendant::div[@class='DayPicker-Caption']/div")).getText().split(" ");
			currentMonth=currentMonthYear[0];
			currentYear=currentMonthYear[1];
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[1]/descendant::div[@class='DayPicker-Caption']/div")).getText().split(" ");
			currentMonth=currentMonthYear[0];
			currentYear=currentMonthYear[1];
		}
		driver.findElement(By.xpath("//div[@class='DayPicker-Month' and contains(.,'"+reqDepartureMonth+"')]//p[text()='"+departureDate.split("-")[0]+"']")).click();


		currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[2]/descendant::div[@class='DayPicker-Caption']/div")).getText().split(" ");
		currentMonth=currentMonthYear[0];
		currentYear=currentMonthYear[1];

		while(!(currentMonth.equals(reqReturnMonth) && currentYear.equals(reqReturnYear))) {
			currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[1]/descendant::div[@class='DayPicker-Caption']/div")).getText().split(" ");
			currentMonth=currentMonthYear[0];
			currentYear=currentMonthYear[1];
			while(!(currentMonth.equals(reqReturnMonth) && currentYear.equals(reqReturnYear))) {
			currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[2]/descendant::div[@class='DayPicker-Caption']/div")).getText().split(" ");
			currentMonth=currentMonthYear[0];
			currentYear=currentMonthYear[1];
			driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			currentMonthYear=driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div[1]/descendant::div[@class='DayPicker-Caption']/div")).getText().split(" ");
			currentMonth=currentMonthYear[0];
			currentYear=currentMonthYear[1];
			}
		}
		driver.findElement(By.xpath("//div[@class='DayPicker-Month' and contains(.,'"+reqReturnMonth+"')]//p[text()='"+returnDate.split("-")[0]+"']")).click();

	
		driver.findElement(By.xpath("//span[@class='fswTrvl__done']")).click();
		driver.findElement(By.xpath("//div[@class='sc-cZMNgc fLZUIB']/div[1]/div[@class='sc-clIzBv gFdmFA']/span[@class='sc-Galmp clPQEB']/following-sibling::span")).click();
		driver.findElement(By.xpath("//a[@class='sc-dtMgUX daltrV']")).click();
		driver.findElement(By.xpath("//span[@class='sc-fHeRUh jHgPBA']")).click();
		//driver.close();
	
	}

}
