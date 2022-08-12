package com.task.scenariosTest;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJet_CalendarHandling {
	public static void main(String[] args) throws InterruptedException {

		String departureDate="10-September-2022";
		String returnDate="20-October-2022";
		String FirstMonth="July";
		String nexttMonth="August ";
		String fromAdd="BLR";
		String toAdd="AGR";

		WebDriverManager.chromedriver().setup();
		ChromeOptions opt=new ChromeOptions();
		opt.addArguments("--disable-notifications");
		WebDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("https://www.spicejet.com");
		
		driver.findElement(By.xpath("//div[@class='css-1dbjc4n r-18u37iz r-1w6e6rj']/div[@data-testid='round-trip-radio-button']/div[@class='css-1dbjc4n r-zso239']")).click();
		driver.findElement(By.xpath("//div[text()='From']/following-sibling::div/input")).sendKeys("BLR");
		driver.findElement(By.xpath("//div[text()='To']/following-sibling::div/input")).sendKeys("DEL");
		
		//calendarHandling
		int reqMonth=LocalDate.parse(departureDate,DateTimeFormatter.ofPattern("dd-MMMM-yyyy")).getMonthValue();
		int reqYear =Integer.parseInt(departureDate.split("-")[2]);
		driver.findElement(By.xpath(""));
		driver.findElement(By.xpath(""));

		
		
		////div[@class='css-1dbjc4n r-150rngu r-18u37iz r-16y2uox r-1wbh5a2 r-lltvgl r-buy8e9 r-1sncvnh']/div[@class='css-1dbjc4n r-18u37iz']/div
		
}
}