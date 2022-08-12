package com.pomRepository;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlipkartPage {
	
	public WebDriver driver;
	
	public FlipkartPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/*This method is used to close the popup in flipkart
	 * it comes when the flipkart page is loaded
	 */

	@FindBy(xpath="//button[contains(@class,'doB4z')]")
	private WebElement closeOpt;
	
	public void closePopupInFlipkart() {
	 closeOpt.click();
	}
	
	/*This method is used to click the search textbox
	 */

	@FindBy(xpath="//input[@name='q']")
	private WebElement searchText;
	
	public void searchTextInFlipkart(String text) {
		searchText.sendKeys(text, Keys.ENTER);
	}
	
	/*This method is used to  select the element which is the slider-start.
	 */
	@FindBy(xpath="//div[contains(@class,'DFQy')]/div[contains(@class,'FdLqY')]")
	private WebElement sliderstartRadioBtn;
	
	public WebElement sliderStartInFlipkart() {
		 return sliderstartRadioBtn;
	}
	
	/*This method is used to  select the element which is the slider-end.
	 */
	@FindBy(xpath="//div[contains(@class,'WC_zGJ')]/div[contains(@class,'FdLqY')]")
	private WebElement sliderEndRadioBtn;
	
	public WebElement sliderEndInFlipkart() {
		 return sliderEndRadioBtn;
	}

	/* Fetch "clear all" text
	 * 
	 */
	
	@FindBy(xpath="//div[@class='_2id1nE']")
	private WebElement clearText;
	
	public WebElement clearTextInFlipkart() {
		return clearText;
	}
	public void explicitlyWait(WebDriver driver) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='_2id1nE']")));
	}
	
	/**
	 * Going for "Utility Lights" in between the flipKart page
	 */
	@FindBy(xpath="//div[@class='_6t1WkM _3HqJxg']/div[6]//descendant::div[@class='_37K3-p']/div[4]/descendant::div[@class='_3LU4EM']")
	private WebElement productDetails;
	
	public WebElement productDetatils() {
		return productDetails;
	}
	
	/**
	 * Going for "beauty,toys & More" in top of  the flipKart page
	 */
	@FindBy(xpath="//div[@class='_37M3Pb']/div[9]/descendant::div[@class='_1psGvi SLyWEo']/descendant::div[@class='xtXmba']")
	private WebElement topProdDetails;
	
	public WebElement topProdDetails() {
		return topProdDetails;
	}
	
	
	/**
	 * Taking WebPage session for screenshot
	 */
	@FindBy(xpath="//div[@class='_6t1WkM _3HqJxg']/div[@class='_1YokD2 _2GoDe3']/descendant::div[@class='_2hKRMr _2CfYpZ']")
	private WebElement session;
	
	public WebElement prodinOneSessionDetails() {
		return session;

	}

	/**
	 * Taking WebElement for screenshot
	 */
	@FindBy(xpath="//div[@class='_37M3Pb']/div[2]")
	private WebElement element;
	
	public WebElement webElementScreenshotDetails() {
		return element;

	}
	
}
