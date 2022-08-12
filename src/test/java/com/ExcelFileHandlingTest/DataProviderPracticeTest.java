package com.ExcelFileHandlingTest;

import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderPracticeTest {
	
	@Test(dataProvider="loginData")
	public void practiceTest(String username, String password) {
		Reporter.log(username+ "  "+password, true);
	}

	@DataProvider
	public Object[][] loginData(){
		Object[][] data=new Object[3][2];
		
		data[0][0]="admin1";
		data[0][1]="password1";
		
		data[1][0]="admin1";
		data[1][1]="password1";
		
		data[2][0]="admin1";
		data[2][1]="password1";

		return data;
	}
	
}
