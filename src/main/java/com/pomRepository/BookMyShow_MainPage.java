package com.pomRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookMyShow_MainPage {

	public WebDriver driver;

	public BookMyShow_MainPage(WebDriver driver) {
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
		
		
		
		//Click right arrow
		@FindBy(xpath="//div[@class='sc-7o7nez-0 kdBsqY']/ancestor::div[@class='sc-133848s-3 cWbeuJ']/following-sibling::div/descendant::div[@class='sc-133848s-1 sc-lnhrs7-4 sc-lnhrs7-6 giKFEa']/div")
		private List<WebElement> rightArrowClk;
		
		public void clickRightArrow() {
			for(int i=0; i<rightArrowClk.size(); i++) {
				if(i==0)
				{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					rightArrowClk.get(0).click();
					break;
				}
			}
		}
	
		//Click left arrow=====================
		@FindBy(xpath="//div[@class='sc-7o7nez-0 kdBsqY']/ancestor::div[@class='sc-133848s-3 cWbeuJ']/following-sibling::div/descendant::div[@class='sc-lnhrs7-7 faepMR']")
		private List<WebElement> leftArrowClk;
		
		public void clickLeftArrow() {
			for(int i=0; i<leftArrowClk.size(); i++) {
				if(i==0)
				{
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					leftArrowClk.get(0).click();
					break;
				}
			}
		}
		

		//All Ten Movies

		@FindBy(xpath="//div[@class='sc-7o7nez-0 kdBsqY']/ancestor::div[@class='sc-133848s-3 cWbeuJ']/following-sibling::div/descendant::div[@class='sc-dv5ht7-0 eQcIov']/div[@class='sc-133848s-3 cWbeuJ']/descendant::div[@class='sc-7o7nez-0 ksSobQ']")
		private List<WebElement> allTenMoviesLists;
		
		//div[text()='Recommended Movies']/ancestor::div[@class='sc-133848s-3 cWbeuJ']/following-sibling::div/descendant::div[@class='sc-dv5ht7-0 eQcIov']/div[@class='sc-133848s-3 cWbeuJ']/descendant::div[@class='sc-7o7nez-0 ksSobQ']=====//25.07.22

		public void printAllTenMovies() {
			System.out.println(allTenMoviesLists.size());
			for(int i=0; i<allTenMoviesLists.size(); i++) {
				if(i<5) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(allTenMoviesLists.get(i).getText());
				}

				else
				{
					if(i==allTenMoviesLists.size()/2) 
					{
						clickRightArrow();
					}
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					System.out.println(allTenMoviesLists.get(i).getText());
					}
			}
		}

// Click on one of the popular cities from  the dropdown in the main page
		@FindBy(xpath="//span[@class='sc-LKuAh kxVdmj ellipsis']")
		private WebElement citiesDropdown ;


		public void clickCitiesDropdown(WebDriver driver) {
			citiesDropdown.click();
		}


//	all 84 movies xpath
//div[@class='sc-133848s-2 sc-291x3n-1 eQCApE']/ancestor::div[@class='sc-133848s-3 cWbeuJ']/following-sibling::div/descendant::div[@class='sc-7o7nez-0 ksSobQ']
}
