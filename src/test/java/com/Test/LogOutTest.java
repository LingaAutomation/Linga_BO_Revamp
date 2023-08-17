package com.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;

public class LogOutTest {
	
	public WebDriver driver;
	public ExtentTest test;
	
	@Test
	public void LogOut() throws Exception
	{
		LoginPage a=new LoginPage(driver, test);
		
		a.Log_Out();
		
//		Thread.sleep(2000);
//		a.VerifyLoginPageHeader();
//		
//		Thread.sleep(1000);
//		driver.close();
		
	}

}
