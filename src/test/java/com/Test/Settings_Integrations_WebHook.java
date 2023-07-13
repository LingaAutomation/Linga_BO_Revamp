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
import com.Pages.Settings_NotificationsPage;
import com.Pages.Settings_Web_Hooks_Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Integrations_WebHook
{
	public WebDriver driver;


	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Web Hooks");

	LoginPage lgpg; 
	Utility ut=new Utility();
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Settings_Web_Hooks_Page wh;


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
	@Test(priority = 2)
	public void Calling() throws Exception 
	{
		Open_Settings_Web_Hooks_Page(driver);
		Thread.sleep(1000);
		Adding_Request_Header(driver);
		Thread.sleep(1000);
		Adding_CloseOrder_Web_Hooks(driver);
		Thread.sleep(1000);
		Clicking_Closeorder_WebHooks_Active(driver);
		Thread.sleep(1000);
		Adding_OpenOrder_Web_Hooks(driver);
		Thread.sleep(1000);
		Clicking_OpenOrder_WebHooks_Active(driver);
		Thread.sleep(1000);
		Adding_Updateorder_Web_Hooks(driver);
		Thread.sleep(1000);
		Clicking_Updateorder_WebHooks_Active(driver);
		Thread.sleep(1000);
		Clicking_Thirdorder_WebHooks_Active(driver);
		
	}

	@Test(priority = 3,enabled = false)
	public void Open_Settings_Web_Hooks_Page(WebDriver driver) throws Exception 
	{
		cmp= new Common_XPaths(driver,test);
   	    wh= new Settings_Web_Hooks_Page(driver, test);
   	 
		Thread.sleep(6000);
		//load the Notifications page
		Thread.sleep(2000);
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("Store_Id2"));
		wh.Navigating_Settings();
		Thread.sleep(1000);
		wh.Navigating_WebHooks();
		Thread.sleep(20000);
	}
	@Test(priority = 4,enabled = false)
	 public void Adding_Request_Header(WebDriver driver) throws Exception
	{
		wh.Entering_Key_value();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store data updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
		Thread.sleep(5000);
		wh.Entering_Infinity_Key_value();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store data updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
		Thread.sleep(5000);
		wh.Entering_alphabets();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store data updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
		Thread.sleep(5000);
		wh.Entering_Alphabets_Num_Key_Value();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store data updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		
		Thread.sleep(5000);
		wh.Entering_Specialchar_Key_value();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store data updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		
		Thread.sleep(5000);
		wh.Entering_SpecialChar_Alpha_Key_Value();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store data updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		Thread.sleep(2000);
	 }
	@Test(priority = 5,enabled = false)
	public void Adding_CloseOrder_Web_Hooks(WebDriver driver) throws Exception 
	{
		wh.Entering_Closeorder_URL();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "User enter the invalid URL but application allows to update the store");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "User enter the invalid URLthat's why application not allows to update the store");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
		
		Thread.sleep(5000);
		wh.Entering_CloseOrder_Numbers();
		Thread.sleep(3000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.FAIL, "User enter the invalid URL but application allows to update the store");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.PASS, "User enter the invalid URLthat's why application not allows to update the store");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		
		Thread.sleep(5000);
		wh.Entering_Closeorder_SpecialChar();
		Thread.sleep(3000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.FAIL, "User enter the invalid URL but application allows to update the store");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.PASS, "User enter the invalid URLthat's why application not allows to update the store");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		
		Thread.sleep(5000);
		wh.Entering_Closeorder_NUM_ALPHA_Spechar();
		Thread.sleep(3000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.FAIL, "User enter the invalid URL but application allows to update the store");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.PASS, "User enter the invalid URLthat's why application not allows to update the store");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		
		Thread.sleep(5000);
		wh.Entering_Closeorder_InvalidURL();
		Thread.sleep(3000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.FAIL, "User enter the invalid URL but application allows to update the store");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.PASS, "User enter the invalid URLthat's why application not allows to update the store");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		Thread.sleep(2000);
	}
	
	@Test(priority = 6,enabled = false)
	public void Clicking_Closeorder_WebHooks_Active(WebDriver driver) throws Exception 
	{
		Thread.sleep(5000);
		wh.Clikcing_Closeorder_WebHooks_Yes();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store data updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		Thread.sleep(5000);
		wh.Clicking_Closeorder_WebHooks_No();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store data updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		Thread.sleep(2000);
	}
	
	@Test(priority = 7,enabled = false)
	public void Adding_OpenOrder_Web_Hooks(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);
		wh.Entering_Openorder_URL();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "User enter the invalid URL but application allows to update the store");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "User enter the invalid URLthat's why application not allows to update the store");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		
		Thread.sleep(5000);
		wh.Entering_Openorder_NUM();
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.FAIL, "User enter the invalid URL but application allows to update the store");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.PASS, "User enter the invalid URLthat's why application not allows to update the store");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		
		Thread.sleep(5000);
		wh.Entering_Openorder_SpecialChar();
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.FAIL, "User enter the invalid URL but application allows to update the store");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.PASS, "User enter the invalid URLthat's why application not allows to update the store");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		
		Thread.sleep(5000);
		wh.Entering_Openorder_NUM_SpecialChar_Alpha();
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.FAIL, "User enter the invalid URL but application allows to update the store");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.PASS, "User enter the invalid URLthat's why application not allows to update the store");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		
		Thread.sleep(5000);
		wh.Entering_Openorder_InvalidURL();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.FAIL, "User enter the invalid URL but application allows to update the store");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.PASS, "User enter the invalid URLthat's why application not allows to update the store");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		Thread.sleep(2000);
		
	}
	
	@Test(priority = 8,enabled = false)
	public void Clicking_OpenOrder_WebHooks_Active(WebDriver driver) throws Exception 
	{
		Thread.sleep(5000);
		wh.Clikcing_Openorder_WebHooks_Yes();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store data updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		Thread.sleep(5000);
		wh.Clicking_Openorder_WebHooks_No();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store data updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		Thread.sleep(2000);
		
	}
	@Test(priority = 9,enabled = false)
	public void Adding_Updateorder_Web_Hooks(WebDriver driver) throws Exception 
	{
		wh.Entering_Updateorder_URL();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "User enter the invalid URL but application allows to update the store");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "User enter the invalid URLthat's why application not allows to update the store");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
		
		Thread.sleep(5000);
		wh.Entering_Updateorder_NUM();
		Thread.sleep(3000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.FAIL, "User enter the invalid URL but application allows to update the store");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.PASS, "User enter the invalid URLthat's why application not allows to update the store");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		
		Thread.sleep(5000);
		wh. Entering_Updateorder_SpecialChar();
		Thread.sleep(3000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.FAIL, "User enter the invalid URL but application allows to update the store");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.PASS, "User enter the invalid URLthat's why application not allows to update the store");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		
		Thread.sleep(5000);
		wh. Entering_Updateorder_NUM_SpecialChar_Alpha();
		Thread.sleep(3000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.FAIL, "User enter the invalid URL but application allows to update the store");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.PASS, "User enter the invalid URLthat's why application not allows to update the store");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		
		Thread.sleep(5000);
		wh.Entering_Updateorder_InvalidURL();
		Thread.sleep(3000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.FAIL, "User enter the invalid URL but application allows to update the store");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.PASS, "User enter the invalid URLthat's why application not allows to update the store");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		
		Thread.sleep(2000);
	}
	@Test(priority = 9,enabled = false)
	public void Clicking_Updateorder_WebHooks_Active(WebDriver driver) throws Exception 
	{
		Thread.sleep(5000);
		wh.Clicking_Updateorder_WebHooks_Yes();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store data updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		Thread.sleep(5000);
		wh.Clicking_Updateorder_WebHooks_No();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store data updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		Thread.sleep(2000);
	}
	@Test(priority = 10,enabled = false)
	public void Clicking_Thirdorder_WebHooks_Active(WebDriver driver) throws Exception 
	{
		Thread.sleep(5000);
		wh.Clicking_Thirdorder_WebHooks_Yes();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store data updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
		Thread.sleep(5000);
		wh.Clicking_Thirdorder_WebHooks_No();
		Thread.sleep(2000);
		wh.Update();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store data updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}
	}

 }

