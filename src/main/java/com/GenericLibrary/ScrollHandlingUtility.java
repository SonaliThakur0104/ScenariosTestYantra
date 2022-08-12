package com.GenericLibrary;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ScrollHandlingUtility {

	Robot robot;
	Actions actions;
	JavascriptExecutor javaScriptExecutor;

	/**
	 * Scroll Handling using "ROBOT Class"
	 * @param data
	 */
	public void keyBoardActions( int data) {
		try {
			robot= new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		robot.keyPress(data);
		robot.keyRelease(data);
	}
	
	/**
	 * Scroll Handling Using Actions Class
	 */
	public void scrollHandlingUsingActions(WebDriver driver,Keys key1, Keys key2) {
		actions=new Actions(driver);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		actions.keyDown(key1).sendKeys(key2).perform();
		
	}

	/**
	 * How to scroll down on a web page in selenium by defining the number of pixels
	 * Using JavascriptExecutor
	 */
	public void scrollingDownUsingPixels(WebDriver driver,int y) {
		javaScriptExecutor=(JavascriptExecutor)driver;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		javaScriptExecutor.executeScript("window.scrollBy(0,"+y+")", "");
	}
	
	/**
	 * How to scroll up on a web page in selenium by defining the number of pixels
	 *Using JavascriptExecutor
	 */
	public void scrollingUpUsingPixels(WebDriver driver,int x) {
		javaScriptExecutor=(JavascriptExecutor)driver;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		javaScriptExecutor.executeScript("window.scrollBy()", "");
	}
	
	
	/**
	 * scroll down to an element in Selenium until it is visible
	 * js.executeScript("arguments[0].scrollIntoView();", Element);
	 */
	
	public void scrollIntoView(WebDriver driver,WebElement element) {
		javaScriptExecutor=(JavascriptExecutor)driver;
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		javaScriptExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		}
	
	/**
	 * How to scroll down to the bottom of the webPage using JavascriptExecutor
	 */
	
	
	public void scrollToBottom(WebDriver driver) {
		javaScriptExecutor=(JavascriptExecutor)driver;

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		javaScriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	
	
	
	
}
