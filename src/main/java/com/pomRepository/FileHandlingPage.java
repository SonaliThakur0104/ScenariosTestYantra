package com.pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FileHandlingPage {
	
	public WebDriver driver;
	
	public FileHandlingPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	/**
	 * This method is to upload file
	 * https://the-internet.herokuapp.com/upload
	 */
	@FindBy(id="file-upload")
	private WebElement uploadBtn;
	
	public void chooseFileBtn(String filePath) {
		uploadBtn.sendKeys(filePath);
	}
	
	/**
	 * This method is to drag and drop the file which needs to be uploaded
	 * https://the-internet.herokuapp.com/upload
	 */
	@FindBy(id="drag-drop-upload")
	private WebElement dragAndDropFile;
	
	public void dragAndDropFileSpace() {
		dragAndDropFile.click();
	}
	
	
	/**
	 * This method is to drag and drop the file which needs to be uploaded
	 * https://www.grammarly.com/plagiarism-checker
	 */
	@FindBy(xpath="//textarea[contains(@class,'CFUF-el')]")
	private WebElement uploadFileInSpace;
	
	public void uploadFileInPlagiarismChecker() {
		uploadFileInSpace.click();
	}
	
	/**
	 *Enter data in  text given in 
	 *https://demo.automationtesting.in/FileDownload.html
	 */
	@FindBy(id="textbox")
	private WebElement enterText;
	
	public void enterTextInDemoAutomation(String message) {
		enterText.sendKeys(message);
	}
	
	/**Generate Text File
	 *Click on generate file
	 *https://demo.automationtesting.in/FileDownload.html
	 */
	@FindBy(id="createTxt")
	private WebElement generateClick;
	
	public void generateFileInDemoAutomation() {
		generateClick.click();
	}
	
	/**
	 *Click on Download button
	 *https://demo.automationtesting.in/FileDownload.html
	 */
	@FindBy(id="link-to-download")
	private WebElement downloadBtn;
	
	public void clickDownloadInDemoAutomation() {
		downloadBtn.click();
	}
	
	
	/**Enter pdf file
	 *Enter data in  text given in 
	 *https://demo.automationtesting.in/FileDownload.html
	 */
	@FindBy(id="pdfbox")
	private WebElement enterPdfText;
	
	public void enterTextInPDFDemoAutomation(String message) {
		enterPdfText.sendKeys(message);
	}
	
	/**
	 *Click on generate file
	 *https://demo.automationtesting.in/FileDownload.html
	 */
	@FindBy(id="createPdf")
	private WebElement generatePdfClick;
	
	public void generateFileInPDFDemoAutomation() {
		generatePdfClick.click();
	}
	
	/**
	 *Click on Download button
	 *https://demo.automationtesting.in/FileDownload.html
	 */
	@FindBy(id="pdf-link-to-download")
	private WebElement downloadPdfBtn;
	
	public void clickDownloadInPDFDemoAutomation() {
		downloadPdfBtn.click();
	}
	
	
	
	
	
	
}
