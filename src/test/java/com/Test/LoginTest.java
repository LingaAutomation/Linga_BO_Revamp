package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest 
{
	public WebDriver driver;
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Login Page");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	
	@BeforeTest
	public void Open_and_Login() throws Exception
	{
		Login(driver, test);
	}
//		
//	
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
	
	@AfterTest
	public void LogOut_and_Close() throws Exception
	{
		LogOut(driver, test);
	}
	
	public void LogOut(WebDriver driver,ExtentTest test) throws Exception
	{
		LoginPage a=new LoginPage(driver,test);
		
		a.Log_Out();
		
//		Thread.sleep(2000);
//		a.VerifyLoginPageHeader();
//		
//		Thread.sleep(1000);
//		driver.close();
		
	}
	
	public void Navigate_To_Page(String StoreID,String PageAttribute) throws Exception
	{
		driver.get(Utility.getProperty("baseURL")+StoreID+PageAttribute);

	}
	
	public WebDriver getDriver()
	{
		return driver;
	}

}
