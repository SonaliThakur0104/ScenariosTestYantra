package com.pomRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FlightsPage_Goibibo {

	@FindBy(xpath="//div[@class='width100 fl faq-padding']/div/descendant::div/ul/li")
	private List<WebElement> listFlightNames;

	public FlightsPage_Goibibo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//SpiceJet Airlines
	//			public void clickTypeOfDomesticFlight(WebDriver driver, String typeOfDomesticFlight) {
	//				driver.findElement(By.xpath("//div[@class='width100 fl faq-padding']/div[8]/div/descendant::ul[1]/li[3]/descendant::a[text()='"+typeOfDomesticFlight+"']")).click();
	//				}

	public void clickTypeOfDomesticFlight(String typeOfDomesticFlight) {

		for (int i = 0; i < listFlightNames.size(); i++) {
			if(typeOfDomesticFlight.equals(listFlightNames.get(i).getText()))
			{
				listFlightNames.get(i).click();
				break;
			}

		}

	}

}
