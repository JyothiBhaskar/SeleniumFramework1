package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Automation.Base.BaseClass;
import com.Automation.DataProvider.GetDataCode;
import com.Automation.pages.LoginPage;

public class LoginTest extends BaseClass{
	
	
	
	@Test(dataProvider="TestingData",dataProviderClass=GetDataCode.class)
	public void ValidLogin(String uname,String pwd)
	{
		LoginPage LP=new LoginPage(driver);
		LP.Loginpage();
		Assert.assertTrue(LP.LoginOptionDisplayed());
		Assert.assertEquals(LP.sociallinks(),5);
		LP.Login(uname, pwd);		
	}

	
	
}
