package com.pomRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PopularAirlinesPage_Goibibo {

	public PopularAirlinesPage_Goibibo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	//popular airlines text
	@FindBy(xpath="//div[@class='seo-srp-layoutstyles__RightWrap-sc-11ypfer-3 bzMBFw']/div[2]/h2[@class='common-stylesstyles__Headings-sc-uferee-2 iTlMHC padB5']")
	private WebElement airlinesText;
	
	public void popularAirlinesText() {
		System.out.println(airlinesText.getText());
	}
	
	//From city Texts
	@FindBy(xpath="//div[@class='seo-srp-layoutstyles__RightWrap-sc-11ypfer-3 bzMBFw']/div[2]//div[2]/span[@class='route-cardstyles__Time-sc-1f42gug-3 ezmaUO txtUpper fb padB5']")
	private List<WebElement> fromCityTextsLists;
	
	public List<WebElement> fromCityLists() {
		 return fromCityTextsLists;
	}
	
	// To city Texts
		@FindBy(xpath="//div[@class='seo-srp-layoutstyles__RightWrap-sc-11ypfer-3 bzMBFw']/div[2]//div[4]/span[@class='route-cardstyles__Time-sc-1f42gug-3 ezmaUO txtUpper fb padB5']")
		private List<WebElement> toCityTextsLists;
		
		public List<WebElement> toCityLists() {
			return toCityTextsLists;
//			for(int i=0; i<fromCityTextsLists.size(); i++) {
//				fromCityTextsLists.get(i).getText();
//		}
		}
		
		
		//From city Texts
		@FindBy(xpath="//div[@class='seo-srp-layoutstyles__RightWrap-sc-11ypfer-3 bzMBFw']/div[2]/descendant::div[@class='dF flex1 justifyCenter']/div[@class='route-cardstyles__Price-sc-1f42gug-6 cIpifK dF fb alignItemsCenter']")
		private List<WebElement> priceTextsLists;
		
		public List<WebElement> priceLists() {
			return priceTextsLists;
//		
		}
		
		
	

}
//h2[@class='common-stylesstyles__Headings-sc-uferee-2 iTlMHC padB5']/ancestor::div[@class='seo-srp-layoutstyles__RightWrap-sc-11ypfer-3 bzMBFw']//div[2]/span[@class='route-cardstyles__Time-sc-1f42gug-3 ezmaUO txtUpper fb padB5']

//public String popularAirlinesText(WebDriver driver,String text) {
//	return driver.findElement(By.xpath("//h2[text()='"+text+"']")).getText();
//}
//
//public List<WebElement> fromCity(WebDriver driver,String text) {
//	return driver.findElements(By.xpath("//h2[text()='"+text+"']/parent::div//div[2]/span[@class='route-cardstyles__Time-sc-1f42gug-3 ezmaUO txtUpper fb padB5']"));
//}
//
//public List<WebElement> toCityLists(WebDriver driver,String text) {
//	return driver.findElements(By.xpath("//h2[text()='"+text+"']/parent::div//div[4]/span[@class='route-cardstyles__Time-sc-1f42gug-3 ezmaUO txtUpper fb padB5']"));
//	}
//
//public List<WebElement> priceLists(WebDriver driver,String text) {
//	 return   driver.findElements(By.xpath("//h2[text()='"+text+"']/parent::div//div[5]/div[@class='route-cardstyles__Price-sc-1f42gug-6 cIpifK dF fb alignItemsCenter']"));
//	 }
