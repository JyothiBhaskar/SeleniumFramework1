package com.Automation.BrowseFactory;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Reporter;

import com.Automation.DataProvider.ConfigReader;

public class BrowserFactory {
	
		
		public static WebDriver driver;
		
		public static WebDriver getDriver() {
			
			return driver;
		}
		

		public static WebDriver getBrowser(String browserName,String appURL) {
			
			if (browserName.equalsIgnoreCase("Chrome") || browserName.equalsIgnoreCase("Google Chrome")) 
			{
				
				ChromeOptions options=new ChromeOptions();
				DesiredCapabilities capabilities=new DesiredCapabilities();
				capabilities.setCapability("browserName", "chrome");
				capabilities.setCapability("browserVersion", "120.0");
				capabilities.setCapability("platformName", "linux");
				
				//if (ConfigReader.getProperty("headless").equalsIgnoreCase("true")) 
				//{
					//options.addArguments("--headless=new");
					
					//Reporter.log("LOG:INFO - Running Test In Headless Mode",true);

				//}
				
				try {
					driver=new RemoteWebDriver(new URL("http://13.200.253.50:4444/"),options);
				} catch (MalformedURLException e) {
					Reporter.log("Log:Info - Couldn't connect to seleniumGrid"+e.getMessage());
				}
				//driver=new ChromeDriver();

			}
			else if (browserName.equalsIgnoreCase("Firefox") || browserName.equalsIgnoreCase("Mozila Firefox")) 
			{
				driver=new FirefoxDriver();
			}
			else if(browserName.equalsIgnoreCase("Edge") || browserName.equalsIgnoreCase("Microsoft Edge"))
			{
				EdgeOptions edgeOptions=new EdgeOptions();
				edgeOptions.addArguments("--guest");
				
				driver=new EdgeDriver(edgeOptions);
			}
			else if (browserName.equalsIgnoreCase("Safari")) {
				driver=new SafariDriver();
			}
			else {
				Reporter.log("LOG:INFO - Sorry currently we do support Chrome, Firefox, Edge and Safari Browser");
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
			driver.quit();
		
		}

}
