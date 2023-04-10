package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentTest;

import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest 
{
	

	public void LoginAsInvalidUser(WebDriver driver,ExtentTest test)
	{
		
	}
	
	public void Login(WebDriver driver,ExtentTest test) throws Exception
	{
		Thread.sleep(2000);
		//Call the chrome driver 
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
//		//Open the Chrome window
//		driver = new ChromeDriver();
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver(chrOpt);
//		
//		//Wait for 30 seconds
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		//Maximize the Chrome window
//		driver.manage().window().maximize();
//		Thread.sleep(1000);
//		//Launch the URL
//		driver.get(Utility.getProperty("appURL"));
		LoginPage a=new LoginPage(driver,test);
		Thread.sleep(1000);
		a.VerifyLoginPageHeader();
		
		Thread.sleep(1000);
		a.Login(Utility.getProperty("userName"), Utility.getProperty("password"));
		
	}
	
	public void LogOut(WebDriver driver,ExtentTest test) throws Exception
	{
		LoginPage a=new LoginPage(driver,test);
		
		driver.close();
		
	}
}
