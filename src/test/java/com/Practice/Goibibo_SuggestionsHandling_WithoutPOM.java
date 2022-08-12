package com.Practice;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pomRepository.MainPage_Goibibo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibibo_SuggestionsHandling_WithoutPOM {
	public static void main(String[] args) {
	
		String firstLetter="j";
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		//		MainPage_Goibibo mainPage=new MainPage_Goibibo(driver);

		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//ul[@class='sc-fvxzrP cCkBwj']/li[2]/span[@class='sc-gsNilK dImRia']")).click();
//		mainPage.clickRoundTrip(driver);

		driver.findElement(By.xpath("//div[@class='sc-bkkeKt gAqCbJ fswFld ']/span[text()='From']")).click();
		//		mainPage.clickFromText();
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys(firstLetter);
		//		mainPage.enterFromText(firstLetter);

		List<WebElement> cityLists=driver.findElements(By.xpath("//ul[@id='autoSuggest-list']/li/descendant::span[@class='autoCompleteTitle ']"));
		List<WebElement> shortCitiesLists=driver.findElements(By.xpath("//ul[@id='autoSuggest-list']/li/descendant::span[@class='autoCompleteSubTitle']"));
		List<WebElement> airportNameLists=driver.findElements(By.xpath("//ul[@id='autoSuggest-list']/li/descendant::p[@class='sc-bBHHxi cTvqKV']"));
		List<WebElement> inNameLists=driver.findElements(By.xpath("//ul[@id='autoSuggest-list']/li/descendant::span[@class='sc-AjmGg iraeWI']"));

		System.out.println("The cities starts with " +firstLetter+ " are as follows: ");
        System.out.println();
		
        Iterator<WebElement> itr1=cityLists.iterator();
		Iterator<WebElement> itr2=shortCitiesLists.iterator();
		Iterator<WebElement> itr3=airportNameLists.iterator();
		Iterator<WebElement> itr4=inNameLists.iterator();
		
//		Iterator<WebElement> itr1=mainPage.cityLists().iterator();
//		Iterator<WebElement> itr2=mainPage.shortCitiesLists().iterator();
//		Iterator<WebElement> itr3=mainPage.airportNameLists().iterator();
//		Iterator<WebElement> itr4=mainPage.inNameLists().iterator();
		
		while(itr1.hasNext() && itr2.hasNext() && itr3.hasNext() && itr4.hasNext()) 
		{
			String cityName=itr1.next().getText();
			String shortCityName=itr2.next().getText();
			String airportName=itr3.next().getText();
			String inName=itr4.next().getText();

			System.out.println(cityName+" "+shortCityName+ " "+inName);
			System.out.println(airportName);
		}
       driver.close();
}
}