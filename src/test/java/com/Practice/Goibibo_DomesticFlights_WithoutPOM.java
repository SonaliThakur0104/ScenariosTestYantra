package com.Practice;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.pomRepository.FlightsPage_Goibibo;
import com.pomRepository.MainPage_Goibibo;
import com.pomRepository.PopularAirlinesPage_Goibibo;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Goibibo_DomesticFlights_WithoutPOM {
	public static void main(String[] args) {

		String typeOfFlight="Domestic Flights";
		String typeOfDomesticFlight="SpiceJet Airlines";
		String text="SpiceJet Airlines Popular Domestic Routes";

		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		JavascriptExecutor jse=(JavascriptExecutor)driver;

//		MainPage_Goibibo mainPage=new MainPage_Goibibo(driver);
//		FlightsPage_Goibibo flightsPage=new FlightsPage_Goibibo(driver);
//		PopularAirlinesPage_Goibibo airlinesPage=new PopularAirlinesPage_Goibibo(driver); 
		
		driver.get("https://www.goibibo.com/");
		jse.executeScript("window.scrollBy(0,1250)", "");
		
		driver.findElement(By.xpath("//a[text()='"+typeOfFlight+"']")).click();
		//		mainPage.clickTypeOfFlight(driver, typeOfFlight);

		jse.executeScript("window.scrollBy(0,2800)", "");
		
		driver.findElement(By.xpath("//div[@class='width100 fl faq-padding']/div[8]/div/descendant::ul[1]/li[3]/descendant::a[text()='"+typeOfDomesticFlight+"']")).click();
//		flightsPage.clickTypeOfDomesticFlight(driver, typeOfDomesticFlight);

		System.out.println(driver.findElement(By.xpath("//h2[text()='"+text+"']")).getText());
		//		System.out.println(airlinesPage.popularAirlinesText(driver, text));

		List<WebElement> fromCityLists=driver.findElements(By.xpath("//h2[text()='"+text+"']/parent::div//div[2]/span[@class='route-cardstyles__Time-sc-1f42gug-3 ezmaUO txtUpper fb padB5']"));
		List<WebElement> toCityLists=driver.findElements(By.xpath("//h2[text()='"+text+"']/parent::div//div[4]/span[@class='route-cardstyles__Time-sc-1f42gug-3 ezmaUO txtUpper fb padB5']"));
		List<WebElement> priceLists=driver.findElements(By.xpath("//h2[text()='"+text+"']/parent::div//div[5]/div[@class='route-cardstyles__Price-sc-1f42gug-6 cIpifK dF fb alignItemsCenter']"));

		Iterator<WebElement> itr1=fromCityLists.iterator();
		Iterator<WebElement> itr2=toCityLists.iterator();
		Iterator<WebElement> itr3=priceLists.iterator();

//		Iterator<WebElement> itr1=airlinesPage.fromCityLists(driver, text).iterator();
//		Iterator<WebElement> itr2=airlinesPage.toCityLists(driver, text).iterator();
//		Iterator<WebElement> itr3=airlinesPage.priceLists(driver, text).iterator();

		
		while(itr1.hasNext() && itr2.hasNext() && itr3.hasNext()) 
		{
			String fromCityName=itr1.next().getText();
			String toCityName=itr2.next().getText();
			String prices=itr3.next().getText();
			System.out.println(fromCityName+"  "+toCityName+"  " +prices);
		}
		driver.close();
	}
}