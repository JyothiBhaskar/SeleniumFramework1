package com.Automation.Uitlity;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

public class Helper {
	
	//wait(Implicit and Explicit wait)
	//Thread.sleep
	//Highlighter
	//Screenshot
	//Action class click
	//JS Executor click
	//
	
	
	public static void waitmethod(int Timeinseconds)
	{
		try 
		{
			Thread.sleep(Timeinseconds*1000);
		} 
		catch (InterruptedException e) 
		{
			Reporter.log("Log info:Thread interrupted"+e.getMessage(),true);
		}
		
	}
	
	public static void WebDriverwait(WebDriver driver,By locator)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(60));
		WebElement element=wait.until(ExpectedConditions.elementToBeClickable(locator));
		
	}
	

}
