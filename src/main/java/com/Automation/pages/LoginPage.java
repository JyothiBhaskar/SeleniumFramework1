package com.Automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	protected WebDriver driver;
	
	public LoginPage(WebDriver driver)
	
	{
		this.driver=driver;
	}

	private By menu=By.xpath("//div[@class='navbar-menu-links']");
	private By loginlink=By.xpath("//button[normalize-space()='Log in']");
	private By username=By.xpath("//input[@name='email1']");
	private By password=By.xpath("//input[@type='password']");
	private By signin=By.xpath("//button[@type='submit']");
	private By sociallinks=By.xpath("//h2[text()='Connect with us']//following-sibling::div//a");
	private By loginSignInOption=By.xpath("//h2[normalize-space()='Sign In']");
	
public void Loginpage()
{
	driver.findElement(menu).click();
	driver.findElement(loginlink).click();
}

public boolean LoginOptionDisplayed()
{
	return driver.findElement(loginSignInOption).isDisplayed();
}

	public void Login(String uname, String pass)
	{
		driver.findElement(username).sendKeys(uname);
		driver.findElement(password).sendKeys(pass);
		driver.findElement(signin).click();
	}
	
	public int sociallinks()
	{
	
	return driver.findElements(sociallinks).size();}
	
	
}