package com.task.scenariosTest;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.pomRepository.Wikipedia_iphone12Page;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WikipediaTest {

	WebDriver driver=null;
	Wikipedia_iphone12Page wikipediaPage;


	@BeforeSuite
	public void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://en.wikipedia.org/wiki/IPhone_12");
	}


	@Test
	public void fetchPragraph() {
		wikipediaPage=new Wikipedia_iphone12Page(driver);
		String start="range";
		String ends="virtually";
		String firstPara=driver.findElement(By.xpath("//h1[@id='firstHeading']/following-sibling::div/div[@id='mw-content-text']/div[@class='mw-parser-output']/p[2]")).getText();

		String[] paraArr=firstPara.split(" ");

		int count=1;
		for(int i=1; i<=paraArr.length; i++) {
			if(paraArr[i].equals(start)) 
			{
				break;
			}
			else 
			{
				count++;
			}
			
		}
		for(int j=count; j<=paraArr.length; j++)
		{
			if(paraArr[j].equals(ends)) {
				break;
			}
			else {
				System.out.print(paraArr[j]+" ");
			}
		}

	}




	@AfterSuite
	public void closeBrowser() {
		driver.close();
	}
}

















