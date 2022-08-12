package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Hotstar_MainPage {

	public WebDriver driver;
	
	public Hotstar_MainPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
//	@FindBy()
//	private 
	
	
}
