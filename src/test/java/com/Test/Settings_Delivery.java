package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

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
import com.Pages.Settings_Delivary_Settings_Page;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Delivery {
	public WebDriver driver;
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Delivery Settings");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Settings_Delivary_Settings_Page ds;
	
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
		
		Thread.sleep(10000);
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
		Open_Delivery_Page(driver);
		Delivery_setting_Page(driver);
		//Delivery_Zone_Page(driver);
		//Delivery_PUC_Page(driver);
		Delivery_Driver_Page(driver);
		Delivery_Save(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Delivery_Page(WebDriver driver) throws Exception
	{
		
		ds=new Settings_Delivary_Settings_Page(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		//ds.Click_store();
		//Thread.sleep(5000);
		
		//Load page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"delivery");

		Thread.sleep(5000);
		//Verify the Departments page loaded or not
		cmp.VerifyMainScreenPageHeader("Delivery");
		
		Thread.sleep(5000);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Delivery_setting_Page(WebDriver driver) throws Exception
	{
		Thread.sleep(1000);
		ds.Click_Setting_Delivery();
		Thread.sleep(5000);
	}
	
	@Test(priority = 3,enabled = false)
	public void Delivery_Zone_Page(WebDriver driver) throws Exception
	{
		ds.Click_zone_Delivery();
		Thread.sleep(5000);
		
		ds.Delivery_new();//null value save
		Thread.sleep(5000);
		ds.Click_Edit_zone();
		Thread.sleep(5000);
		ds.Click_Delete();
		Thread.sleep(5000);
		ds.Click_alert_Delete();
		Thread.sleep(5000);
		ds.Click_Active();
		Thread.sleep(5000);
		ds.Click_Inctive();
		Thread.sleep(5000);
		ds.search_zone();
		Thread.sleep(5000);
		cmp.Filter_Columns();
		Thread.sleep(5000);
	
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Delivery_PUC_Page(WebDriver driver) throws Exception
	{
		ds.Click_puc_Delivery();
		Thread.sleep(10000);
	}
	
	@Test(priority = 3,enabled = false)
	public void Delivery_Driver_Page(WebDriver driver) throws Exception
	{
		ds.Click_Driver_Delivery();
		Thread.sleep(5000);
	}
	
	@Test(priority = 3,enabled = false)
	public void Delivery_Save(WebDriver driver) throws Exception
	{
		ds.Click_Save();
		Thread.sleep(5000);
	}
}
