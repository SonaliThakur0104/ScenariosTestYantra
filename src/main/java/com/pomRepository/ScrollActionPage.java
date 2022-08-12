package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ScrollActionPage {

public WebDriver driver;
	
	public ScrollActionPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	/**
	 * Vogue Horizontal Scrolling
	 */
	@FindBy(xpath="//div[@class='banner-actions-container']/button[@id='onetrust-accept-btn-handler']")
	private WebElement closeClick;
	
	public void closePopupInVogue() {
		closeClick.click();
	}
	
	/**
	 * Vogue
	 * Scrolling to An element horizontally
	 */
	@FindBy(xpath="//div[@class='gfw-page-wrpr']/section[@id='Section8']//img")
	private WebElement elementView;
	
	public WebElement elementViewInVogue() {
		return elementView;
	}
	
}
