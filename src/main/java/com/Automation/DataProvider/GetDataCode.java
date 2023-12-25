package com.Automation.DataProvider;

import org.testng.annotations.DataProvider;

public class GetDataCode {

	@DataProvider(name="TestingData")
	public static Object[][] getData()
	{
		
		Object[][] arr=ExcelClass.getData("Login");
		return arr;
		
	}
	
}
