package com.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.Common_XPaths;
import com.Pages.Enterprise_AccountLicense_Settings_Page;
import com.Pages.Enterprise_DeveloperAPI_Key_Page;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Enterprise_Settings_Account_License_Settings 
{
	public WebDriver driver;


	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("EnterPriseSettings-AccountLicense Settings");

	LoginPage lgpg; 
	Enterprise_AccountLicense_Settings_Page ASP;

	Utility ut=new Utility();
    Common_XPaths cmp;
	LoginTest a=new LoginTest();
	ReportsPage repts;
	

	@AfterClass
	public void flushTest() throws Exception
	{
		Thread.sleep(2000);
		rep.endTest(test);
		rep.flush();
	}

	@AfterMethod
	public void TestFail(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String scnsht=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);

			String s="data:image/png;base64,"+scnsht;

			test.log(LogStatus.FAIL, test.addScreenCapture(s));


		}
	}


	@Test(priority = 1)
	public void Login() throws Exception
	{

		Thread.sleep(2000);
		//Call the chrome driver
		//System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
		//Open the Chrome window
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
		//Wait for 30 seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Maximize the Chrome window
		driver.manage().window().maximize();
		Thread.sleep(1000);
		//Launch the URL
		driver.get(Utility.getProperty("appURL"));

		Thread.sleep(30000);
	    a.Login(driver, test);
	}

	@Test(priority = 50)
	public void LogOut() throws Exception
	{

		a.LogOut(driver, test);
		
	}


	@Test(priority=2)
	public void Calling() throws Exception
	{
		Open_Account_License_Settings_Page(driver);
		Enable_Call_Center_Toggle(driver);
		Enabling_WaitList_Toggle(driver);
		Enabling_Customer_Display(driver);
		Enabling_Texting_Toggle(driver);
		Enabling_WebOrder_Toggles(driver);
		Navigating_To_Upgrade(driver);
		Enabling_Virtual_Kiosk_Toggles(driver);
	}

	@Test(priority=3,enabled = false)
	public void Open_Account_License_Settings_Page(WebDriver driver) throws Exception 
	{
		ASP = new Enterprise_AccountLicense_Settings_Page(driver, test);
		cmp = new Common_XPaths(driver, test);
		
		ASP.Click_Enterprise();
		
	    driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"accountLicensesSettings");
		
		Thread.sleep(3000);
		cmp.VerifyMainScreenPageHeader("Account License Settings");
		
	}
	
	public void Enable_Call_Center_Toggle(WebDriver driver) 
	{
		ASP = new Enterprise_AccountLicense_Settings_Page(driver, test);
		cmp = new Common_XPaths(driver, test);
		
		try {
		for(int i=1;i<=10;i++) 
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//th[.='CallCenter']/../../../tbody/tr/td[7]//mat-slide-toggle)["+i+"]")).click();
			ASP.Click_Save();
		}
		}
		catch (Exception e) 
		{
			test.log(LogStatus.INFO,"Call center has a limit it won't allow to enable the toggle Exceed the Max limit");
		}
		
	}
	
	public void Enabling_WaitList_Toggle(WebDriver driver)
	{
		ASP = new Enterprise_AccountLicense_Settings_Page(driver, test);
		cmp = new Common_XPaths(driver, test);
		
		try {
			for(int i=1;i<=10;i++) 
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//th[.='Wait List']/../../../tbody/tr/td[6]//mat-slide-toggle)["+i+"]")).click();
				ASP.Click_Save();
			}
			}
			catch (Exception e) 
			{
				test.log(LogStatus.INFO,"Wait List has a limit it won't allow to enable the toggle Exceed the Max limit");
			}
			
	  }
	
	public void Enabling_Customer_Display(WebDriver driver) throws Exception 
	{
		ASP = new Enterprise_AccountLicense_Settings_Page(driver, test);
		cmp = new Common_XPaths(driver, test);
		
		try {
			for(int i=1;i<=10;i++) 
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//th[.='Customer Display']/../../../tbody/tr/td[4]//mat-slide-toggle)["+i+"]")).click();
				ASP.Click_Save();
			}
			}
			catch (Exception e) 
			{
				test.log(LogStatus.INFO,"Wait List has a limit it won't allow to enable the toggle Exceed the Max limit");
			}
		
	}
	
	public void Enabling_Texting_Toggle(WebDriver driver)
	{
		ASP = new Enterprise_AccountLicense_Settings_Page(driver, test);
		cmp = new Common_XPaths(driver, test);
		
		try {
			for(int i=1;i<=10;i++) 
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//th[.='Texting']/../../../tbody/tr/td[3]//mat-slide-toggle)["+i+"]")).click();
				ASP.Click_Save();
			}
			}
			catch (Exception e) 
			{
				test.log(LogStatus.INFO,"Texting has a limit it won't allow to enable the toggle Exceed the Max limit");
			}
		
	}
	
	public void Enabling_WebOrder_Toggles(WebDriver driver) throws Exception 
	{
		
		ASP = new Enterprise_AccountLicense_Settings_Page(driver, test);
		cmp = new Common_XPaths(driver, test);
		
		try {
			for(int i=1;i<=10;i++) 
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//th[.='Web Order']/../../../tbody/tr/td[2]//mat-slide-toggle)["+i+"]")).click();
				ASP.Click_Save();
			}
			}
			catch (Exception e) 
			{
				test.log(LogStatus.INFO,"Texting has a limit it won't allow to enable the toggle Exceed the Max limit");
			}
		
		Thread.sleep(5000);
	}
	
	public void Navigating_To_Upgrade(WebDriver driver) throws Exception 
	{
		ASP = new Enterprise_AccountLicense_Settings_Page(driver, test);
		cmp = new Common_XPaths(driver, test);
		
		((JavascriptExecutor)driver).executeScript("window.open()");

		ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());

		driver.switchTo().window(tabs.get(1));
		Thread.sleep(8000);
		//Launch the URL
		driver.get(Utility.getProperty("appURL"));
		Thread.sleep(20000);
		driver.navigate().refresh();
		Thread.sleep(20000);
		a.Login(driver, test);
		Thread.sleep(5000);
		ASP.click_Upgrade();
		
		Thread.sleep(30000);
		
		ASP.Managing_Plan();
		Thread.sleep(3000);
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(4000);
		driver.switchTo().window(tabs.get(1));
		Thread.sleep(4000);
		driver.close();
		driver.switchTo().window(tabs.get(0));
		Thread.sleep(4000);
		
	}
	
	public void Enabling_Virtual_Kiosk_Toggles(WebDriver driver) throws Exception 
	{
		
		ASP = new Enterprise_AccountLicense_Settings_Page(driver, test);
		cmp = new Common_XPaths(driver, test);
		
		try {
			for(int i=1;i<=25;i++) 
			{
				Thread.sleep(1000);
				driver.findElement(By.xpath("(//th[.='Virtual Kiosk']/../../../tbody/tr/td[10]//mat-slide-toggle)["+i+"]")).click();
				ASP.Click_Save();
			}
			}
			catch (Exception e) 
			{
				test.log(LogStatus.INFO,"Virtual Kiosk has a limit it won't allow to enable the toggle Exceed the Max limit");
			}
		
		Thread.sleep(5000);
	}

}
