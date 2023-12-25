package com.Automation.BrowseFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;

import com.Automation.DataProvider.ConfigReader;

public class BrowserFactory {
	
	
	public static WebDriver getBrowser(String BrowserName,String appURL)
	{
		WebDriver driver=null;
		
		if(BrowserName.equalsIgnoreCase("Chrome") ||(BrowserName.equalsIgnoreCase("chrome")))
		{
			driver=new ChromeDriver();
		}
		
		else if(BrowserName.equalsIgnoreCase("Firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(BrowserName.equalsIgnoreCase("Edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			Reporter.log("Sorry Currently we do support only Chrome, Firefox and Edge Browsers");
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("pageLoadTimeout"))));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("scriptTimeout"))));
		driver.get(appURL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(ConfigReader.getProperty("implicitWait"))));
		
		return driver;	
	}
	
	public static void closeBrowser(WebDriver driver)
	{
		Reporter.log("Log Info: Closing the Browse");
		driver.quit();
	}
	

}
