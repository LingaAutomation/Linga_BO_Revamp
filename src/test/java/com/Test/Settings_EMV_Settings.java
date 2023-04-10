package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.Availability_RestrictionTimePage;
import com.Pages.CategoriesPage;
import com.Pages.Common_XPaths;
import com.Pages.EMVSettingsPage;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;

public class Settings_EMV_Settings {
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("EMV Settings");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	EMVSettingsPage emv;
	
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
		Open_EMVSettings_Page(driver);
		RefreshAndPaginination(driver);
		//Row_Select_EMV(driver);
		Add_EMVSettings(driver);    
		Edit_and_Close_Cancel_emv(driver);
		Edit_and_Update_EMV(driver); 
		Delete_EMVSettings(driver);
		Create_DuplicateEMV(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_EMVSettings_Page(WebDriver driver) throws Exception
	{
		
		emv=new EMVSettingsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the  page
		driver.get(Utility.getProperty("baseURL"));

		Thread.sleep(5000);
		
		emv.settings();
		Thread.sleep(5000);
		
		//Verify the Categories page loaded or not
		cmp.VerifyMainScreenPageHeader("Setting");	
		Thread.sleep(5000);
		
		emv.emvset();
		Thread.sleep(5000);
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
	
	@Test(priority = 5,enabled = false)
	public void Add_EMVSettings(WebDriver driver) throws Exception
	{
		emv=new EMVSettingsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New EMV
		emv.Click_NewEMV();
		Thread.sleep(2000);
		cmp.VerifyMainScreenPageHeader("New EMV Setting");
		Thread.sleep(1000);
		
		cmp.EnterName(Utility.getProperty("EMVSettings_Name"));
		Thread.sleep(500);
		
		emv.EnterIP(Utility.getProperty("EMVSettings_IP"));
		Thread.sleep(500);
		
		emv.Select_Type();
		//Thread.sleep(500);
		cmp.Click_SaveButton();
		//cmp.Click_CancelButton();
		//emv.ClickCancel();
		System.out.println("Add_EMVSettings");
	}
	
	@Test(priority = 6,enabled = false)
	public void Edit_and_Close_Cancel_emv(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Search the Categories to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("EMVSettings_Name"));
		
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update EMV Settings");
		
		Thread.sleep(2000);
		//Click Cancel button
		cmp.Click_UpdateButton();
		//cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Category Creation form Closed or not
		
		 if(!cmp.NewCreationScreenHeader().isDisplayed()) 
		 { 
			 test.log(LogStatus.PASS,"EMV Settings Cancelled");
		 } 
		 else 
		 { 
		test.log(LogStatus.FAIL, "EMV Settings not Cancelled");
		 }
		 
		System.out.println("Edit_and_Close_Cancel_emv");
	}
	
	@Test(priority = 6,enabled = false)
	public void Edit_and_Update_EMV(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		emv=new EMVSettingsPage(driver, test);
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("EMVSettings_Name1"));
		
		Thread.sleep(500);
		//emv.Click_Edit();
		//Enter the Name
		cmp.EnterName(Utility.getProperty("EMVSettings_Name1")+"1");
		Thread.sleep(500);
		//cmp.Click_UpdateButton();
		cmp.Click_CancelButton();
		System.out.println("Edit_and_Update_EMV");
	}
	
	@Test(priority = 4,enabled = false)
	public void Row_Select_EMV(WebDriver driver) throws InterruptedException
	{
		emv.rows_per_page();
		Thread.sleep(1000);
	}
	
	@Test(priority = 6,enabled = false)
	public void Delete_EMVSettings(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		emv=new EMVSettingsPage(driver, test);
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("EMVSettings_Name1"));
		
		Thread.sleep(500);
		emv.Click_Delete();
		Thread.sleep(500);
		
		//Click the Delete button
		cmp.Click_DeleteButton();
		emv.Alert_Click_Delete_Cancel();
		Thread.sleep(3000);
		//Check whether the New Category Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("EMV Settings Removed Successfully"))
		{
			test.log(LogStatus.PASS, "EMV Settings Removed Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "EMV Settings Removed Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		System.out.println("Delete_EMVSettings");
	}	
	
	@Test(priority = 6,enabled = false)
	public void Create_DuplicateEMV(WebDriver driver) throws Exception
	{
		emv=new EMVSettingsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New EMV Settings button
		emv.Click_NewEMV();
		Thread.sleep(2000);
	
		Thread.sleep(500);
		//Enter the existing EMV Settings name
		cmp.EnterName(Utility.getProperty("EMVSettings_Name1"));
		
		Thread.sleep(500);
		
		emv.EnterIP(Utility.getProperty("EMVSettings_IP1"));
		Thread.sleep(500);
		
		emv.Select_Type();
		Thread.sleep(500);
		
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New EMV Settings Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "EMV Settings Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "EMV Settings Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		cmp.Click_CloseButton();
	}
}
