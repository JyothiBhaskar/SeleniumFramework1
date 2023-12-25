package com.Automation.DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.testng.Reporter;


public class ConfigReader {
	
	public static String getProperty(String key)
	{
		
		Properties prop=new Properties();
		
		try {
			prop.load(new FileInputStream(new File("C:/Users/hp/Desktop/Java1/AutomationFrameWork/ConfigFolder/ConfigProperty")));
		} catch (FileNotFoundException e) {
			
			Reporter.log("Log Info:Unable to load File" +e.getMessage());
		} catch (IOException e) {
            Reporter.log("Log Info:Unable to config file"+e.getMessage());
		}
		String value=prop.getProperty(key);
		
		return value;
	}

}
