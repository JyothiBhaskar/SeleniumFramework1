package com.Automation.Base;

import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.Automation.BrowseFactory.BrowserFactory;
import com.Automation.DataProvider.ConfigReader;

public class BaseClass {
	
	public WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		Reporter.log("Log Info: Setting upthe Browser", true);
		driver= BrowserFactory.getBrowser(ConfigReader.getProperty("browser"), ConfigReader.getProperty("appURL"));
		Reporter.log("LOG:INFO- Browser And Application Is Up And Running", true);
		
	}
	
	@AfterClass
	public void tearup()
	{
     Reporter.log("LOG:INFO- Running After Class- Closing Browser", true);
     BrowserFactory.closeBrowser(driver);
		
		Reporter.log("LOG:INFO- Browser Closed", true);
}
}