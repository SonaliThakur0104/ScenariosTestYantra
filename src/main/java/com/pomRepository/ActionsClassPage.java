package com.pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ActionsClassPage {
	
	public WebDriver driver;
	
	public ActionsClassPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//Amazon Mouse Hover to Perform Sign in
	@FindBy(xpath="//div[@id='nav-tools']/a[@id='nav-link-accountList']")
	private WebElement signInClick;
	
	public WebElement mouseHoverSignIn() {
		return signInClick;
	}
	
	//demoqa slider
	@FindBy(xpath="//input[@class='range-slider range-slider--primary']")
	private WebElement slider;
	
	public WebElement sliderAction() {
		return slider;
	}
	
	//amazon_click discover your style
	@FindBy(xpath="//div[@id='nav-al-wishlist']/a[4]/span[@class='nav-text']")
	private WebElement clickText;
	
	public WebElement clickText() {
		return clickText;
	}

	/*This method is used in ClickAndHoldTest class
	 * it is used to "B"
	 */ 
	@FindBy(xpath="//ul[@id='sortable']/li[2]")
	private WebElement alphabetClickAndHold;
	
	public WebElement clickAndHoldAlphabet() {
		return alphabetClickAndHold;
	}
	
	/*This method is used in ClickAndHoldTest class
	 * it is used to "D"
	 */ 
	@FindBy(xpath="//ul[@id='sortable']/li[1]")
	private WebElement secondAlphabetClickAndHold;
	
	public WebElement clickAndHoldSecondAlphabet() {
		return secondAlphabetClickAndHold;
	}
	
	/*This method is used in ContextClickTest class
	 * To do right click function
	 */ 
	@FindBy(xpath="//span[@class='context-menu-one btn btn-neutral']")
	private WebElement RightClickLink;
	
	public WebElement contextLinkClick() {
		return RightClickLink;
	}
	
	/*This method is used in ContextClickTest class
	 * To click "QUIT" 
	 */ 
	@FindBy(xpath="//ul[@class='context-menu-list context-menu-root']/li[7]")
	private WebElement quitText;
	
	public WebElement clickQuitText() {
		return quitText;
	}
	
	/*This method is used in ContextClickTest class
	 * To do right click function
	 */ 
	@FindBy(xpath="//button[@ondblclick='myFunction()']")
	private WebElement doubleClickLink;
	
	public WebElement doubleLinkClick() {
		return doubleClickLink;
	}
	
	/*This method is used in DragAndDropTest class
	 * To do dragging function
	 */ 
	@FindBy(xpath="//div[@id='draggable']")
	private WebElement draggingBtn;
	
	public WebElement draggableElement() {
		return draggingBtn;
	}
	
	/*This method is used in DragAndDropTest class
	 * To do dropping function
	 */ 
	@FindBy(xpath="//div[@class='simple-drop-container']/div[@id='droppable']")
	private WebElement droppingBtn;
	
	public WebElement droppableElement() {
		return droppingBtn;
	}
	
	/*This method is used to for "KeyUpAndKeyDownTest" class
	 * This method is for the url: "https://demoqa.com/text-box"
	 * This is used for fetching name
	 */
	
	@FindBy(id="userName")
	private WebElement nameText;
	
	public void nameText(String message) {
		nameText.sendKeys(message);
	}
	
	/*This method is used to for "KeyUpAndKeyDownTest" class
	 * This method is for the url: "https://demoqa.com/text-box"
	 * This is used for fetching email
	 */
	
	@FindBy(id="userEmail")
	private WebElement emailText;
	
	public void emailText(String message) {
		emailText.sendKeys(message);
	}
	
	
	
	/*This method is used to for "KeyUpAndKeyDownTest" class
	 * This method is for the url: "https://demoqa.com/text-box"
	 * This is used for fetching current address
	 */
	
	@FindBy(xpath="//textarea[@id='currentAddress']")
	private WebElement currAddText;
	
	public void currentAddressText(String message) {
		currAddText.sendKeys(message);
	}
	
	/*
	 * This method is used to get the text webElement in GOOGLE
	 */
	@FindBy(xpath="//input[@name='q']")
	private WebElement editText;
	
	public WebElement textInGoogle() {
		return editText;
	}
	
	
	
	
	
	
	
	
}
