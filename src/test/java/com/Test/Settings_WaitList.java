package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import com.Pages.LoginPage;
import com.Pages.Settings_WaitList_Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_WaitList 
{
	public WebDriver driver;


	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Wait List");

	LoginPage lgpg; 
	Utility ut=new Utility();
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Settings_WaitList_Page wl;


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
		Navigate_Settings_WaitList_Page(driver);
		Thread.sleep(2000);
		without_Entering_Min_Max_Seat(driver);
		Thread.sleep(2000);
		Entering_Invalid_Time(driver);
		Thread.sleep(2000);
		Entering_More__MinTime(driver);
		Thread.sleep(2000);
		Entering_Existing_Seat(driver);
		Thread.sleep(2000);
		Cancling_New_WaitList(driver);
		Thread.sleep(2000);
		Creating_New_Wait_List(driver);
		Thread.sleep(2000);
		Searching_Wait_List(driver);
		Thread.sleep(2000);
		Deleting_Wait_List(driver);
		Thread.sleep(2000);
		Handling_Rows_and_Pagination(driver);
		Thread.sleep(2000);
		Sorting_Columns(driver);
		Thread.sleep(2000);
		Navigating_Reasons(driver);
		Thread.sleep(2000);
		Entering_Existing_Reason(driver);
		Thread.sleep(2000);
		Creating_New_Reason(driver);
		Thread.sleep(2000);
		//Capturing_Reason_Error(driver);
		Search_Delete_Reason(driver);
		Thread.sleep(2000);
		Handling_Rows_and_Pagination(driver);
		Thread.sleep(2000);
		Sorting_Reason_Column(driver);

	}

	@Test(priority=2, enabled = false)
	public void Navigate_Settings_WaitList_Page(WebDriver driver) throws Exception
	{
		//Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_WaitList_Page wl = new Settings_WaitList_Page(driver, test);

   	 
		Thread.sleep(8000);
		//load the Notifications page
		Thread.sleep(2000);
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"waitList");
	
		Thread.sleep(1000);
		
	}
	public void Creating_New_Wait_List(WebDriver driver) throws Exception
	{
		Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_WaitList_Page wl = new Settings_WaitList_Page(driver, test);
		Thread.sleep(5000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(5000);
		wl.New_WaitList();
		Thread.sleep(1000);
		wl.WaitList();
		Thread.sleep(1000);
		cmp.Click_SaveButton();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Wait List Added Successfully")) 
		{
			test.log(LogStatus.PASS, "Wait List Saved Successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Wait List saving failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(4000);
		

	}
	public void without_Entering_Min_Max_Seat(WebDriver driver) throws Exception 
	{
		//Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_WaitList_Page wl = new Settings_WaitList_Page(driver, test);
		Utility ut = new Utility();
		wl.New_WaitList();
		Thread.sleep(2000);
		wl.Not_Entering_Min_seat();

		if(wl.Min_Seat_Err().getText().equalsIgnoreCase("Enter more than 0 value")) 
		{
			test.log(LogStatus.PASS, "not entered any Min Seat value");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Added valid Min seat");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(2000);
		wl.Not_Entering_Max_seat();

		if(wl.Min_Seat_Err().getText().equalsIgnoreCase("Enter more than 0 value")) 
		{
			test.log(LogStatus.PASS, "not entered any Max Seat value");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Added valid Max seat");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(2000);
	}
	public void Entering_Invalid_Time(WebDriver driver) throws Exception 
	{
		Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_WaitList_Page wl = new Settings_WaitList_Page(driver, test);
		Utility ut = new Utility();
	
		wl.Entering_Invalid_time();
		Thread.sleep(2000);
		cmp.Click_SaveButton();
		Thread.sleep(2000);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("conflicts among the entered table. please check!.")) 
		{
			test.log(LogStatus.PASS, "Entered invalid time");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "entered valid time");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(4000);
	}
	public void Entering_More__MinTime(WebDriver driver) throws Exception 
	{
		Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_WaitList_Page wl = new Settings_WaitList_Page(driver, test);
		Utility ut = new Utility();
		
		wl.Entering_More_Min_Time();
		Thread.sleep(2000);
		cmp.Click_SaveButton();
		Thread.sleep(2000);
		Thread.sleep(2000);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("conflicts among the entered table. please check!.")) 
		{
			test.log(LogStatus.PASS, "Entered max Seat less than Min seat");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "entered valid seat");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(4000);

	}
	public void Entering_Existing_Seat(WebDriver driver) throws Exception
	{
		Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_WaitList_Page wl = new Settings_WaitList_Page(driver, test);
		Utility ut = new Utility();

		wl.Entering_Duplicate_Seat();
		Thread.sleep(2000);
		cmp.Click_SaveButton();
		Thread.sleep(2000);
		Thread.sleep(2000);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("seat 5 is already occupied.")) 
		{
			test.log(LogStatus.PASS, "Entered lready existing seat");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "entered valid seat");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(4000);

	}
	public void Cancling_New_WaitList(WebDriver driver) throws Exception
	{
		Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_WaitList_Page wl = new Settings_WaitList_Page(driver, test);
		//Utility ut = new Utility();
		wl.WaitList();
		Thread.sleep(2000);
		cmp.Click_CloseButton();
		Thread.sleep(2000);

	}
	public void Searching_Wait_List(WebDriver driver) throws Exception 
	{
		//Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_WaitList_Page wl = new Settings_WaitList_Page(driver, test);
		wl.Search();
		driver.navigate().refresh();
		Thread.sleep(2000);
		
	}
	public void Deleting_Wait_List(WebDriver driver) throws Exception
	{
		Thread.sleep(4000);
		//Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_WaitList_Page wl = new Settings_WaitList_Page(driver, test);
		wl.Delete();
		Thread.sleep(4000);
		
	}
	public void Handling_Rows_and_Pagination(WebDriver driver) throws Exception 
	{
		//Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_WaitList_Page wl = new Settings_WaitList_Page(driver, test);
		//Utility ut = new Utility();
		wl.paginationValidations();
		Thread.sleep(2000);
		
	}
	public void Sorting_Columns(WebDriver driver) throws Exception 
	{
		Common_XPaths cmp = new Common_XPaths(driver, test);
//		Settings_WaitList_Page wl = new Settings_WaitList_Page(driver, test);
//		wl.Sorting_MinSeat();
//		Thread.sleep(2000);
//		wl.Sorting_MaxSeat();
//		Thread.sleep(2000);
//		wl.Sorting_OccupiedTime();
		cmp.Ascending_And_Descending_Order();
		
	}
	
	//navigating Reasons page
	public void Navigating_Reasons(WebDriver driver) throws Exception 
	{

		//Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_WaitList_Page wl = new Settings_WaitList_Page(driver, test);
		wl.clicking_Reason();
		Thread.sleep(4000);
		
	}
	public void Entering_Existing_Reason(WebDriver driver) throws Exception 
	{

		//Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_WaitList_Page wl = new Settings_WaitList_Page(driver, test);
		wl.New_Reason();
		wl.Entering_Existing_Reason();
		Thread.sleep(4000);
		
	}
	public void Capturing_Reason_Error(WebDriver driver) throws Exception
	{
		//Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_WaitList_Page wl = new Settings_WaitList_Page(driver, test);
		wl.Capturing_Reason_Error();
		if(wl.Reason_ErrMsg().getText().equalsIgnoreCase("Please enter waitlist reason")) 
		{
			test.log(LogStatus.PASS, "not entered any Reason");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Entered Reason ");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(4000);
	}
	public void Search_Delete_Reason(WebDriver driver) throws Exception 
	{
		//Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_WaitList_Page wl = new Settings_WaitList_Page(driver, test);
		wl.Search_Delete_Reason();
		Thread.sleep(2000);
		
	}

	public void Creating_New_Reason(WebDriver driver) throws Exception 
	{
		Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_WaitList_Page wl = new Settings_WaitList_Page(driver, test);
		wl.New_Reason();
		wl.Creating_New_Reason();
		Thread.sleep(2000);
		cmp.Click_CloseButton();
		Thread.sleep(2000);
		wl.New_Reason();
		wl.Creating_New_Reason();
		Thread.sleep(2000);
		cmp.Click_SaveButton();
		Thread.sleep(2000);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Wait List Reason Added Successfully")) 
		{
			test.log(LogStatus.PASS, "Wait List Reason Saved Successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Wait List Reason saving failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(4000);
		
	}
	public void Sorting_Reason_Column(WebDriver driver) throws Exception
	{
		Common_XPaths cmp = new Common_XPaths(driver, test);
		//Settings_WaitList_Page wl = new Settings_WaitList_Page(driver, test);
		//wl.Sorting_Reasons();
		cmp.Ascending_And_Descending_Order();
		
	}



}


