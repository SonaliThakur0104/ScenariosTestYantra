package com.pomRepository;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage_Goibibo {
	
	
	public MainPage_Goibibo(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//ul[@class='sc-fvxzrP cCkBwj']/li[2]/span[@class='sc-gsNilK dImRia']")
	private WebElement roundTripBtn;
	
	public void clickRoundTrip(WebDriver driver) {
		roundTripBtn.click();
	}
	
	//click From City text
	@FindBy(xpath="//div[@class='sc-bkkeKt gAqCbJ fswFld ']/span[text()='From']")
	private WebElement fromClick;
	
	public void clickFromText() {
		fromClick.click();
	}
	
	// Writing the shortcut and first letter eg "a" of the "FROM CITY" text used in suggestion handling
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement fromShortCityText;
	
	public void enterFromText(String firstLetter) {
		fromShortCityText.sendKeys(firstLetter);;
	}
	
	// Writing the short cut of the "TO CITY" text.
	@FindBy(xpath="//div[@class='sc-cidDSM dOEpbS']/input[@type='text']")
	private WebElement shortToCityText;
		
	//click from city
	@FindBy(xpath="//span[@class='autoCompleteTitle ']")
	private List<WebElement> fromCityLists;
	
	public void clickFromCity(String fromCity ) {
		for(int i=0; i<fromCityLists.size(); i++) {
			if(fromCity.equals(fromCityLists.get(i).getText())) {
				fromCityLists.get(i).click();
				break;
			}
		}
	}
	
	//Click to "TO CITY" text
	
	@FindBy(xpath="//span[@class='autoCompleteTitle ']")
	private List<WebElement> toCityLists;
	
    public void clickToCity(String toCityText) {
    	for(int i=0; i<toCityLists.size(); i++) {
			if(toCityText.equals(toCityLists.get(i).getText())) {
				toCityLists.get(i).click();
				break;
			}
		}
	}
	
	public void fromToClick(WebDriver driver, String message1,String fromCity, String message2, String toCity) {
		fromClick.click();
		fromShortCityText.sendKeys(message1);
		clickFromCity(fromCity);
		//driver.findElement(By.xpath("//span[text()='"+fromCity+"']")).click();
		shortToCityText.sendKeys(message2);
		clickToCity(toCity);
		//driver.findElement(By.xpath("//span[text()='"+toCity+"']")).click();
	}
	
	
	
	// no of adults
	@FindBy(xpath="//div[@class='sc-cZMNgc fLZUIB']/div[1]/div[@class='sc-clIzBv gFdmFA']/span[@class='sc-Galmp clPQEB']/following-sibling::span")
	private WebElement numberOfAdultsClick ;
	
	@FindBy(xpath="//a[@class='sc-dtMgUX daltrV']")
	private WebElement adultsDoneClick ;
	
	public void clickNumberOfAdults(WebDriver driver) {
		numberOfAdultsClick.click();
		adultsDoneClick.click();
	}
	// click on search flight
	@FindBy(xpath="//span[@class='sc-fHeRUh jHgPBA']")
	private WebElement searchFlightsClick ;
	
	public void searchFlights() {
		searchFlightsClick.click();
	}
	
	//any month
	public String[] currentMonthYear(WebDriver driver, int i) {
		return driver.findElement(By.xpath("//div[@class='DayPicker-Months']/div["+i+"]/div[@class='DayPicker-Caption']/div")).getText().split(" ");	
	}
	// First month in calendar
	@FindBy(xpath="//div[@class='DayPicker-Months']/div[1]/descendant::div[@class='DayPicker-Caption']/div")
	private WebElement firstCurrentMonthYear ;

	public String[] firstCurrentMonthYear(WebDriver driver) {
		return firstCurrentMonthYear.getText().split(" ");
	}
	// second month in calendar
	@FindBy(xpath="//div[@class='DayPicker-Months']/div[2]/div[@class='DayPicker-Caption']/div")
	private WebElement secondCurrentMonthYear ;

	public String[] secondCurrentMonthYear(WebDriver driver) {
		return secondCurrentMonthYear.getText().split(" ");
	}
// click next button in calendar
	@FindBy(xpath="//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")
	private WebElement clickNext ;
	
	public void clickingNext() {
		clickNext.click();
	} 
	//book fight date
	public void clickDate(WebDriver driver, String date) {
		driver.findElement(By.xpath("//div[@class='DayPicker-Month' and contains(.,'"+date.split("-")[1]+"')]//p[text()='"+date.split("-")[0]+"']")).click();
	}
	
	// click calendar done
	@FindBy(xpath="//span[@class='fswTrvl__done']")
	private WebElement calendarDoneClick ;
	
	public void clickCalendarDone() {
		calendarDoneClick.click();
	}
	
	//Domestic Flights
	
	@FindBy(xpath="//div[@class='footer-links']/ul[1]/li")
	private List<WebElement> productLists;
	
	public void clickTypeOfFlight(String typeOfFlight) {
		for(int i=0;i<productLists.size(); i++) {
			if(typeOfFlight.equals(productLists.get(i).getText())) {
				productLists.get(i).click();
				break;
			}
		}
		
	}

	//Suggestions in From City when any letter for eg "a" is entered.
	
	@FindBy(xpath="//ul[@id='autoSuggest-list']/li/descendant::span[@class='autoCompleteTitle ']")
	private List<WebElement> cityLists ;
	
	public List<WebElement> cityLists(){
		return cityLists;
	}
	@FindBy(xpath="//ul[@id='autoSuggest-list']/li/descendant::span[@class='autoCompleteSubTitle']")
	private List<WebElement> shortCitiesLists ;
	
	public List<WebElement> shortCitiesLists(){
		return shortCitiesLists;
	}
	@FindBy(xpath="//ul[@id='autoSuggest-list']/li/descendant::p[@class='sc-bBHHxi cTvqKV']")
	private List<WebElement> airportNameLists ;
	
	public List<WebElement> airportNameLists(){
		return airportNameLists;
	}
	@FindBy(xpath="//ul[@id='autoSuggest-list']/li/descendant::span[@class='sc-AjmGg iraeWI']")
	private List<WebElement> inNameLists ;
	
	public List<WebElement> inNameLists(){
		return inNameLists;
	}
		
		
		
		
		
}