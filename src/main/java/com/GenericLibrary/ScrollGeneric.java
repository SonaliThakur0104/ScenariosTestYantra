package com.GenericLibrary;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Coordinates;
import org.openqa.selenium.interactions.Locatable;

public class ScrollGeneric {

		JavascriptExecutor j;
		Actions a;

		/*
		 * This method is used to scroll up,down,End of the page,Home to the page
		 */
		public void scrollPage(Keys data,WebDriver driver)
		{
			//Keys var = Keys.END;
			a = new Actions(driver);
			a.sendKeys(data).build().perform();

		}
		/*
		 * This method is used to scroll up and down by using JS
		 */
		public void scrollPageByJSValue(int x,int y,WebDriver driver)
		{
			j = (JavascriptExecutor)driver;
			j.executeScript("window.scrollBy(" + x + ", " + y + ")");
		}
		/**
		 * This method is used to scroll the page to SpecifiedHeight
		 * @param Height
		 */
		public  void scrollToSpecifiedHeight(String Height,WebDriver driver)
		{
			j = (JavascriptExecutor)driver;
			j.executeScript("window.scrollBy(0,"+Height+")");
		}
		/**
		 * scroll horizantally right side
		 */
		public void scrollHorizantally(WebDriver driver)
		{
			j = (JavascriptExecutor)driver;
			j.executeScript("window.scrollTo(document.body.scrollHeight,0)");
		}
		/**
		 * scroll right to a specified width
		 * @param width
		 */
		public  void scrollToSpecifiedHorizantal(String width,WebDriver driver)
		{
			j = (JavascriptExecutor)driver;
			j.executeScript("window.scrollBy("+width+",0)", "");
		}
		/**
		 * This method is used to scroll to bottom
		 */
		public  void scrollToBottom(WebDriver driver)
		{
			j = (JavascriptExecutor)driver;
			j.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		}
		/**
		 * scroll till the located element
		 * @param element
		 */
		public  void scrollTillElement(WebElement element,WebDriver driver)
		{
			j = (JavascriptExecutor)driver;
			j.executeScript("arguments[0].scrollIntoView(true);", element);	
		}
		/**
		 * scroll by using co-ordinates of the element
		 * @param element
		 * @param driver
		 */
		public  void scrollToCoOrdinates(WebElement element,WebDriver driver)
		{
			j = (JavascriptExecutor)driver;
			Point p = element.getLocation();
			int X = p.getX();
			int Y = p.getY();
			j.executeScript("window.scrollBy(" + X + ", " + Y + ");");
			System.out.println("Text is: " + element.getText());
		}
		/**
		 * scroll to left side
		 * @param driver
		 */
		public void scrollLeft(WebDriver driver) 
		{
			j = (JavascriptExecutor)driver;
			j.executeScript("document.querySelector(scroll).scrollLeft=1000");
		}
		
		
		public void locatableElement(WebElement element)
		{
			Coordinates coordinate = ((Locatable)element).getCoordinates();
			coordinate.onPage(); 
		    coordinate.inViewPort();
		}
		 


	}
