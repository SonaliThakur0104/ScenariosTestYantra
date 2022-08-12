package com.pomRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookMyShow_MainPracticePage {

	public WebDriver driver;

	public BookMyShow_MainPracticePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}


	// Select popular Cities

	@FindBy(xpath="//ul[@class='sc-ghsgMZ eXcGRS']/li/descendant::span[@class='sc-dznXNo imttdp']")
	private List<WebElement> popularCitiesList;

	public void clickPopularCities(String popularCity) {

		for (int i = 0; i < popularCitiesList.size(); i++) {
			if(popularCity.equals(popularCitiesList.get(i).getText()))
			{
				popularCitiesList.get(i).click();
				break;
			}
		}
	}

	// Fetch one of the Sections List method(recommended Movies)
	@FindBy(xpath="//div[@class='sc-7o7nez-0 kdBsqY']")
	private List<WebElement> sectionNamesInPage;
	
	public String singleSectionName(String section) {
		for(int i=0; i<sectionNamesInPage.size(); i++) {
			if(section.equals(sectionNamesInPage.get(i).getText())) {
				sectionNamesInPage.get(i).getText();
				return section;
			}
		}
		return null;
	}
	
	
	
//	//Click right arrow
//	
//	@FindBy(xpath="//div[@class='sc-7o7nez-0 kdBsqY']/ancestor::div[@class='sc-133848s-3 cWbeuJ']/following-sibling::div/descendant::div[@class='sc-133848s-1 sc-lnhrs7-4 sc-lnhrs7-6 giKFEa']/div")
//	private List<WebElement> rightArrowClk;
//	
//	public void clickRightArrow(String genre) {
//		for(int i=0; i<rightArrowClk.size(); i++) {
//			if(genre.equals(rightArrowClk.get(i).getText()))
//			{
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				rightArrowClk.get(i).click();
//			}
//		}
//	}
//	
//	
//	//Click left arrow(Original)
//	@FindBy(xpath="//div[@class='sc-7o7nez-0 kdBsqY']/ancestor::div[@class='sc-133848s-3 cWbeuJ']/following-sibling::div/descendant::div[@class='sc-133848s-1 sc-lnhrs7-4 sc-lnhrs7-5 hWQycI']/div")
//	private WebElement leftArrowClk;
//	
//	
//	public void clickLeftArrow() {
//		
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//				leftArrowClk.click();
//			
//	}
	
	
	//click right arrow

	public void clickRightArrow(String genre) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[text()='"+genre+"']/ancestor::div[@class='sc-133848s-3 cWbeuJ']/following-sibling::div/descendant::div[@class='sc-lnhrs7-7 faepMR']")).click();

	}

	//Click left arrow
	public void clickLeftArrow(String genre) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//div[text()='"+genre+"']/ancestor::div[@class='sc-133848s-3 cWbeuJ']/following-sibling::div/descendant::div[@class='sc-133848s-1 sc-lnhrs7-4 sc-lnhrs7-5 hWQycI']/div")).click();

	}

	//All Ten Movies
	public List<WebElement> clickAllMovies(String genre) {
		return driver.findElements(By.xpath("//div[text()='"+genre+"']/ancestor::div[@class='sc-133848s-3 cWbeuJ']/following-sibling::div/descendant::div[@class='sc-lnhrs7-2 eQezya']/descendant::div[@class='sc-dv5ht7-0 eQcIov']/div[@class='sc-133848s-3 cWbeuJ']/descendant::div[@class='sc-7o7nez-0 ksSobQ']"));
	}
	
//	@FindBy(xpath="//div[@class='sc-7o7nez-0 kdBsqY']/ancestor::div[@class='sc-133848s-3 cWbeuJ']/following-sibling::div/descendant::div[@class='sc-lnhrs7-2 eQezya']/descendant::div[@class='sc-dv5ht7-0 eQcIov']/div[@class='sc-133848s-3 cWbeuJ']/descendant::div[@class='sc-7o7nez-0 ksSobQ']")
//	private List<WebElement> allSectionLists;
	
//	public List<WebElement> clickAllMovies(String genre){
//		for(int i=0; i<allSectionLists.size(); i++) {
//			if(genre.equals(allSectionLists.get(i).getText())) {
//				allSectionLists.get(i).getText();
//			}
//		}
//		return allSectionLists ;
//		
//	}
	

	public void printRecommendedMovies(String genre) 
	{

		List<WebElement> allMoviesLists = clickAllMovies(genre);
		System.out.println(allMoviesLists.size());


		for(int i=0; i<allMoviesLists.size(); i++) 
		{
			if(i<5) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(allMoviesLists.get(i).getText());
			}

			else
			{
				if(i==allMoviesLists.size()/2) 
				{
					clickRightArrow(genre);
				}


				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(allMoviesLists.get(i).getText());//0

			}
		}
	}

	@FindBy(xpath="//span[@class='sc-LKuAh kxVdmj ellipsis']")
	private WebElement citiesDropdown ;


	public void clickCitiesDropdown(WebDriver driver) {
		citiesDropdown.click();
	}


}
