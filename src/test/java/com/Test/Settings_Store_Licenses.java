package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.Pages.StoreLicensesPage;
import com.Test.LoginTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;

public class Settings_Store_Licenses 
{
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings - Store Licenses");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	StoreLicensesPage slp;
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
		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
		//Open the Chrome window
		driver = new ChromeDriver();
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
		Open_StoreLicenses_Page(driver);
		RefreshAndPaginination(driver);
		Pagination_Rows_Per_Count(driver);
		Revert_Licenses(driver);

		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_StoreLicenses_Page(WebDriver driver) throws Exception
	{
		slp=new StoreLicensesPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		Thread.sleep(8000);
		//Load the Modifier page
		driver.get(Utility.getProperty("baseURL")+"settings/"+"storeLicenses");

		Thread.sleep(5000);
		//Verify the Store Licenses page loeded or not
		cmp.VerifyMainScreenPageHeader("Store Licenses");	
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
	}
	
	@Test(priority = 4,enabled = false)
	public void Pagination_Rows_Per_Count(WebDriver driver) throws Exception
	{
		slp=new StoreLicensesPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		slp.Verify_Rows_PageCount();
	}
	
	@Test(priority = 4,enabled = false)
	public void Revert_Licenses(WebDriver driver) throws Exception
	{
		slp=new StoreLicensesPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//slp.resetKey();
		
		slp.Revert_Licenses1();
	}
}
