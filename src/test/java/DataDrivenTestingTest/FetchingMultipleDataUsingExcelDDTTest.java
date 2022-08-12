package DataDrivenTestingTest;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.GenericLibrary.ExcelFileUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FetchingMultipleDataUsingExcelDDTTest {
	WebDriver driver;
	ExcelFileUtility excelFileUtilty;
	String filePath="C:\\Users\\User\\eclipse-workspace\\hotstar\\src\\test\\resources\\DataProviderDDT.xlsx";
	String sheetName="Sheet1";
	int rowNum=1;
	
	@BeforeSuite
	//By using Data Provider
	public void setup() {
		WebDriverManager.chromedriver().setup();
	    driver=new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	    driver.get("https://admin-demo.nopcommerce.com/login");
	}
	
	@Test(dataProvider="LoginData")
	    //This loginTest will execute multiple times with multiple set of datas.
	public void loginTest(String user, String pwd, String exp)
	{
		WebElement txtEmail=driver.findElement(By.id("Email"));
		txtEmail.clear();
		txtEmail.sendKeys(user);
		WebElement txtPassword=driver.findElement(By.id("Password"));
		txtPassword.clear();
		txtPassword.sendKeys(pwd);
		driver.findElement(By.xpath("//button[@class='button-1 login-button']")).click();
		String expectedResult="Dashboard / nopCommerce administration";
		String actualResult=driver.getTitle();
		System.out.println(actualResult);
		
		if(exp.equals("valid")){
				if(expectedResult.equals(actualResult)) {
					driver.findElement(By.linkText("Logout")).click();
					Assert.assertTrue(true);
				}
		}
		else {
			Assert.assertTrue(false);
		}
		
		if(exp.equals("invalid")) {
			if(expectedResult.equals(actualResult)) {
				driver.findElement(By.linkText("Logout")).click();
				Assert.assertTrue(false);
			}
			else {
				Assert.assertTrue(true);
			}
		}
	}

	@DataProvider(name="LoginData")
	    //This method will read the data from 3rd party files like excel,notepad
		//we will see how this method is going to provide the data int other methods
	public Object[][] getData() throws  IOException 
	{
//		Object[][] loginData={
//                {"admin@yourstore.com","admin","valid"},
//                {"admin@yourstore.com","adm","invalid"},
//                {"adm@yourstore.com","admin","invalid"},
//                {"admin@yourstore.com","adm","invalid"}
//              };
		excelFileUtilty=new ExcelFileUtility();
		excelFileUtilty.openExcel(filePath);
		int totalRows=excelFileUtilty.getRowCount(sheetName);
		int totalCells=excelFileUtilty.getcellCount(sheetName, rowNum);
		
		Object[][] loginData=new Object[totalRows][totalCells];
		
		for(int i=1; i<=totalRows; i++) {
			for(int j=0; j<totalCells; j++) {
				loginData[i-1][j]=excelFileUtilty.fetchAnyTypeofDataFromexcel(sheetName, i, j);           //[0][0]
			}
		}
		return loginData;
	}

	@AfterSuite
	void closeBrowser() {
		excelFileUtilty.closeExcel();
		driver.close();
	}

}
