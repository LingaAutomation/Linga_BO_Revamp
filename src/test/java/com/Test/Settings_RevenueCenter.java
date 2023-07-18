package com.Test;

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
import com.Pages.LoginPage;
import com.Pages.Settings_RevenueCenter_Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_RevenueCenter 
{
	public WebDriver driver;


	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Revenue Center");

	LoginPage lgpg; 
	Utility ut=new Utility();
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Settings_RevenueCenter_Page RC;


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
		
		ChromeOptions chrOpt=new ChromeOptions();
		chrOpt.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(chrOpt);
		
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
	    Navigating_RevenueCenter(driver);
	    Thread.sleep(2000);
	    New_Revenue_WithoutName(driver);
	    Thread.sleep(2000);
	    New_Revenue_WithoutNode(driver);
	    Thread.sleep(2000);
	    Cancling_New_Revenue(driver);
	    Thread.sleep(2000);
	   // Entering_Name25(driver);
	    Thread.sleep(2000);
	    Entering_Duplicate_Name(driver);
	    Thread.sleep(2000);
	    //Entering_Specialchar_Name(driver);
	    Search_And_Delete(driver);
	    Thread.sleep(2000);
	    Creating_NewRevenue(driver);
	    Thread.sleep(3000);
	    Search_And_Edit(driver);
	    Thread.sleep(2000);
	    Handling_pagination(driver);
	    Thread.sleep(2000);
	    Sorting_Column(driver);
	}

	@Test(priority=3,enabled = false)
	public void Navigating_RevenueCenter(WebDriver driver) throws Exception
	{
		Settings_RevenueCenter_Page RC = new Settings_RevenueCenter_Page(driver, test);
		//Common_XPaths cmp = new Common_XPaths(driver, test);
   	 
		Thread.sleep(8000);
		//load the Notifications page
		Thread.sleep(2000);
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("Store_Id2")+"revenueCenter");
		Thread.sleep(2000);
		RC.Navigating_Settings();
		Thread.sleep(4000);
		RC.Clicking_RevenueCenter();
		Thread.sleep(8000);
		
	}
	@Test(priority=4,enabled = false)
	public void Creating_NewRevenue(WebDriver driver) throws Exception
	{
		Settings_RevenueCenter_Page RC = new Settings_RevenueCenter_Page(driver, test);
		Common_XPaths cmp = new Common_XPaths(driver, test);
		RC.Clicking_NewRevenue();
		Thread.sleep(3000);
		RC.Entering_Name_Node();
		Thread.sleep(3000);
		RC.Save();
		Thread.sleep(2000);
		 if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Revenue Center Saved Successfully"))
	 		{
	 			test.log(LogStatus.PASS, "Revenue Center saved successfully");

	 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
	 		}
	 		else
	 		{
	 			test.log(LogStatus.FAIL, "Revenue center Saving failed");

	 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
	 		}	
		}
	@Test(priority=5,enabled = false)
	public void New_Revenue_WithoutName(WebDriver driver) throws Exception 
	{
		Settings_RevenueCenter_Page RC = new Settings_RevenueCenter_Page(driver, test);
		Common_XPaths cmp = new Common_XPaths(driver, test);
		RC.Clicking_NewRevenue();
		Thread.sleep(3000);
		RC.Entering_Node_Only();
		Thread.sleep(3000);
		RC.Save();
		Thread.sleep(2000);
		 if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Valid Revenue Center Name"))
	 		{
	 			test.log(LogStatus.PASS, "Revenue Center Saving Failed because not entered revenue name");

	 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
	 		}
	 		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error(s)"))
	 		{
	 			test.log(LogStatus.INFO, "Validation Error(s) is Displayed When Saving without Entering Revenue Name");

	 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
	 		}
	 		else
	 		{
	 			test.log(LogStatus.FAIL, "Revenue center Saved");

	 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
	 		}	
		 Thread.sleep(3000);
		 cmp.Click_CloseButton();
		}
	@Test(priority=6,enabled = false)
	public void New_Revenue_WithoutNode(WebDriver driver) throws Exception
	{
		Settings_RevenueCenter_Page RC = new Settings_RevenueCenter_Page(driver, test);
		Common_XPaths cmp = new Common_XPaths(driver, test);
		RC.Clicking_NewRevenue();
		Thread.sleep(1000);
		RC.Entering_Name_Only();
		Thread.sleep(3000);
		RC.Save();
		Thread.sleep(2000);
		 if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Select Revenue Center Nodes"))
	 		{
	 			test.log(LogStatus.PASS, "Revenue Center Saving Failed because not Selected any node");

	 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
	 		}
	 		else
	 		{
	 			test.log(LogStatus.FAIL, "Revenue center Saved");

	 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
	 		}	
		 Thread.sleep(3000);
		 cmp.Click_CloseButton();
		
	}
	@Test(priority=7,enabled = false)
	public void Cancling_New_Revenue(WebDriver driver) throws Exception 
	{
		Settings_RevenueCenter_Page RC = new Settings_RevenueCenter_Page(driver, test);
		Common_XPaths cmp = new Common_XPaths(driver, test);
		RC.Clicking_NewRevenue();
		Thread.sleep(1000);
		RC.Clicking_Canlce();
		Thread.sleep(2000);
		cmp.Click_CloseButton();
	}
	@Test(priority=8,enabled = false)
	public void Entering_Name25(WebDriver driver) throws Exception 
	{
		Settings_RevenueCenter_Page RC = new Settings_RevenueCenter_Page(driver, test);
		Common_XPaths cmp = new Common_XPaths(driver, test);
		RC.Clicking_NewRevenue();
		Thread.sleep(1000);
		RC.Name25_Node();
		Thread.sleep(3000);
		RC.Save();
		Thread.sleep(2000);
		 if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Revenue Center Saved Successfully"))
	 		{
	 			test.log(LogStatus.PASS, "Revenue Center saved successfully");

	 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
	 		}
	 		else
	 		{
	 			test.log(LogStatus.FAIL, "Revenue center Saving failed");

	 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
	 		}	
		 Thread.sleep(3000);
	}
	
	@Test(priority=9,enabled = false)
	public void Entering_Duplicate_Name(WebDriver driver) throws Exception
	{
		Settings_RevenueCenter_Page RC = new Settings_RevenueCenter_Page(driver, test);
		Common_XPaths cmp = new Common_XPaths(driver, test);
		RC.Clicking_NewRevenue();
		Thread.sleep(1000);
		RC.Entering_Duplicate();
		Thread.sleep(2000);
		RC.Save();
		Thread.sleep(2000);
		 if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Revenue Center Name already exist"))
	 		{
	 			test.log(LogStatus.PASS, "Revenue Center Saving Failed because Entered already existing name");

	 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
	 		}
	 		else
	 		{
	 			test.log(LogStatus.FAIL, "Revenue center Saved");

	 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
	 		}	
		 Thread.sleep(8000);
		 cmp.Click_CloseButton();
		}
	@Test(priority=10,enabled = false)
	public void Entering_Specialchar_Name(WebDriver driver) throws Exception 
	{
		Settings_RevenueCenter_Page RC = new Settings_RevenueCenter_Page(driver, test);
		Common_XPaths cmp = new Common_XPaths(driver, test);
		RC.Clicking_NewRevenue();
		Thread.sleep(1000);
		RC.Special_Character();
		Thread.sleep(3000);
		RC.Save();
		Thread.sleep(2000);
		 if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Revenue Center Saved Successfully"))
	 		{
	 			test.log(LogStatus.PASS, "Revenue Center saved successfully");

	 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
	 		}
	 		else
	 		{
	 			test.log(LogStatus.FAIL, "Revenue center Saving failed");

	 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
	 		}	
		
	}
	@Test(priority=11,enabled = false)
	public void Search_And_Delete(WebDriver driver) throws Exception
	{
		Settings_RevenueCenter_Page RC = new Settings_RevenueCenter_Page(driver, test);
		//Common_XPaths cmp = new Common_XPaths(driver, test);
		Thread.sleep(3000);
		RC.Search_Delete();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=12,enabled = false)
	public void Handling_pagination(WebDriver driver) throws Exception
	{
		Settings_RevenueCenter_Page RC = new Settings_RevenueCenter_Page(driver, test);
		//Common_XPaths cmp = new Common_XPaths(driver, test);
		Thread.sleep(3000);
		RC.Pagination();
		
	}
	@Test(priority=13,enabled = false)
	public void Search_And_Edit(WebDriver driver) throws Exception
	{
		Settings_RevenueCenter_Page RC = new Settings_RevenueCenter_Page(driver, test);
		Common_XPaths cmp = new Common_XPaths(driver, test);
		Thread.sleep(3000);
		RC.search_Edit();
		Thread.sleep(2000);
		cmp.Click_UpdateButton();
		Thread.sleep(2000);
		 if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Revenue Center Updated Successfully"))
	 		{
	 			test.log(LogStatus.PASS, "Revenue Center updated successfully");

	 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
	 		}
	 		else
	 		{
	 			test.log(LogStatus.FAIL, "Revenue center updation failed");

	 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
	 		}	
		 RC.Clear_search();
		}
	@Test(priority=14,enabled = false)
	public void Sorting_Column(WebDriver driver) throws Exception
	{
		Settings_RevenueCenter_Page RC = new Settings_RevenueCenter_Page(driver, test);
		//Common_XPaths cmp = new Common_XPaths(driver, test);
		Thread.sleep(3000);
		RC.Sorting_Name();
		Thread.sleep(3000);
		RC.Verify_DescendingNameSorting();
		Thread.sleep(3000);
		RC.Sorting_Node();
		
	}

}
