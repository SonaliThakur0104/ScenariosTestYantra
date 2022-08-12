package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Wikipedia_iphone12Page {
public WebDriver driver;
	
	public Wikipedia_iphone12Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	
}
