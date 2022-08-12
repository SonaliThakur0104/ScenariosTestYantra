package com.pomRepository;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookMyShow_SecondPage_Pune {

	public WebDriver driver;

	public BookMyShow_SecondPage_Pune(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	//See All Link
	@FindBy(xpath="//div[@class='sc-7o7nez-0 kdBsqY']/ancestor::div[@class='sc-133848s-2 sc-291x3n-0 lmknRz']/descendant::div[@class='sc-7o7nez-0 gUjRuq']")
	private WebElement clickSeeAllLink; 

	public void clickSeeAll() {
		clickSeeAllLink.click();
	}

	//Getting the header text in the page after inside popular city
	@FindBy(xpath="//h1[@class='sc-b1h692-7 ehnRRh']")
	private WebElement fetchText;

	public String fetchTextfromCity() {
		return fetchText.getText();
	}

	//Last element inside the sections of popular cities which is used for scrolling down and finding the element
	@FindBy(xpath="//a[@class='sc-fYxtnH cxuOug']")
	private WebElement lastElementText;

	public WebElement lastElementVisisbleInsidePage() {
		return lastElementText;
	}

	// method for scrolling down till last element

	public void scrollTillLastElement() {

		//WebElement lastEle=lastElementVisisbleInsidePage();

		for(int j=0; j<8; j++) {
			try {
				JavascriptExecutor jse=(JavascriptExecutor)driver;
				jse.executeScript("window.scrollBy(0,700)", "");
				Thread.sleep(1000);
			} 
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
		}

	}

	//fetch all movies inside the second page
	@FindBy(xpath="//div[@class='sc-b1h692-8 jDRzfo']/descendant::div[@class='sc-133848s-3 sc-133848s-5 gqBECX']/descendant::div[@class='sc-1ljcxl3-0 iUuHNJ']/descendant::div[@class='sc-7o7nez-0 bJKnib']")
	private List<WebElement> allMoviesLists;

	public List<WebElement> moviesInsideSecondPage(){
		return allMoviesLists;
	}

	public void getSizeOfAllMoviesInsidePage() {
		List<WebElement> moviesLists=moviesInsideSecondPage();
		scrollTillLastElement();
		System.out.println(moviesLists.size());

		for(int i=0; i<moviesLists.size(); i++) 
		{
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(moviesLists.get(i).getText());
		}

	}



}
