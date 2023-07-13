package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
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
import com.Pages.Delivary_SettingsPage;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Delivery_Settings {
	public WebDriver driver;
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings - Delivery Settings");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Delivary_SettingsPage ds;
	
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
		Open_Delivery_Page(driver);
		Delivery_setting_Page(driver);
		Add_Delivery_Zone(driver);
		Edit_and_Update_Delivery_Zone(driver);
		Delete_Delivery_Zone(driver);
//		Delivery_Zone_Page(driver);
		Delivery_PUC_Page(driver);
		Delivery_Driver_Page(driver);
		Delivery_Save(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Delivery_Page(WebDriver driver) throws Exception
	{
		
		ds=new Delivary_SettingsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		//ds.Click_store();
		//Thread.sleep(5000);
		
		//Load page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"delivery");
//		driver.findElement(By.xpath("//div[@class='settings']/button")).click();
//		
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//input[@data-placeholder='Search Settings']")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//input[@data-placeholder='Search Settings']")).sendKeys("Delivery");
//		
//		driver.findElement(By.xpath("//span[.='Delivery']")).click();
		
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
		cmp=new Common_XPaths(driver, test);
//		ds.Click_zone_Delivery();
//		Thread.sleep(5000);
//		
//		ds.Delivery_new();//null value save
//		Thread.sleep(5000);
//		ds.Click_Edit_zone();
//		Thread.sleep(5000);
//		ds.Click_Delete();
//		Thread.sleep(5000);
//		ds.Click_alert_Delete();
//		Thread.sleep(5000);
//		ds.Click_Active();
//		Thread.sleep(5000);
//		ds.Click_Inctive();
//		Thread.sleep(5000);
//		ds.search_zone();
//		Thread.sleep(5000);
//		cmp.Filter_Columns();
//		Thread.sleep(5000);
	
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Add_Delivery_Zone(WebDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		ds=new Delivary_SettingsPage(driver, test);
		
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		//Click the Delivery Zone Tab
		ds.Click_Delivery_ZoneTab();
		
//		cmp.VerifyCreationScreenPageHeader("");

		Thread.sleep(1000);

		//Click the Delivery Zone
				ds.Click_Add_Delivery_Zone();
				
				//Verify whether the Delivery Zone Page opened or not
				cmp.VerifyCreationScreenPageHeader("New Delivery Zone");
				
				if(cmp.Save_Button().isEnabled())
				{
				//Click the Save button
				cmp.Click_SaveButton();
				
				//Check whether the Delivery Zone Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Delivery Zone Saved Successfully"))
				{
					test.log(LogStatus.FAIL, "Delivery Zone Saved without Entering Name");
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Name"))
				{
					test.log(LogStatus.PASS, "Please Enter the Name pop up is Displayed");
				}
				else
				{
					test.log(LogStatus.FAIL, "Please Enter the Name Pop up not displayed");
					
//					try
//					{
//						ds.Click_Add_Delivery_Zone();
//					}
//					catch(Exception l) {}
				}
				}
				else
				{
					test.log(LogStatus.INFO, "Save button not enabled without Enter Delivery Zone Name");
				}
				
				
				//Enter the Name
//				cmp.EnterName(Utility.getProperty("New_Store_State")+RandomStringUtils.randomNumeric(2));
				cmp.EnterName(Utility.getProperty("New_Store_State")+"1");

				
				if(cmp.Save_Button().isEnabled())
				{
				//Click the Save button
				cmp.Click_SaveButton();
				
				//Check whether the Delivery Zone Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Delivery Zone Saved Successfully"))
				{
					test.log(LogStatus.FAIL, "Delivery Zone Saved without Entering Valid Delivery Charge");
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Invalid delivery charge"))
				{
					test.log(LogStatus.PASS, "Invalid delivery charge pop up is Displayed");
				}
				else
				{
					test.log(LogStatus.FAIL, "Invalid delivery charge Pop up not displayed");
					
					
				}
				//Need to Remove
//				try
//				{
//					ds.Click_Add_Delivery_Zone();
//				}
//				catch(Exception l) {}
				}
				else
				{
					test.log(LogStatus.INFO, "Save button not Enabled without Entering Delivery Cost");
				}
	
				Thread.sleep(2000);
				//Enter the Name
				cmp.EnterName(Utility.getProperty("New_Store_State")+"1");
				
				
				//Enter the Delivery Charge Cost
				ds.Enter_Delivery_Charge_Cost("2000");
				
				if(cmp.Save_Button().isEnabled())
				{
				//Click the Save button
				cmp.Click_SaveButton();
				
				try
				{
				//Check whether the Delivery Zone Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Delivery Zone Saved Successfully"))
				{
					test.log(LogStatus.FAIL, "Delivery Zone Saved without Entering Expected Delivery Time");
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Invalid delivery Time"))
				{
					test.log(LogStatus.PASS, "Invalid delivery Time pop up is Displayed");
				}
				}
				catch(Exception j)
				{
					test.log(LogStatus.FAIL, "Invalid delivery Time Pop up not displayed");
					
				
				}
	
				//Need to Remove
//				try
//				{
//					ds.Click_Add_Delivery_Zone();
//				}
//				catch(Exception l) {}
				}
				else
				{
					test.log(LogStatus.INFO, "Save button not Enabled without Entering Expected Delivery Time");
				}
				
				Thread.sleep(2000);
				//Enter the Name
				cmp.EnterName(Utility.getProperty("New_Store_State")+"1");
				
				
				//Enter the Delivery Charge Cost
				ds.Enter_Delivery_Charge_Cost("2000");
				
			
				//Enter the Expected Delivery Time
				ds.Enter_Expected_Delivery_Time("10");
				
				
				//Click the Satellite
//				ds.Satellite_inEditMapButton().click();
				
				//Click the Save button
				cmp.Click_SaveButton();
				
				//Check whether the Delivery Zone Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Delivery Zone Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Delivery Zone Saved Successfully");
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Draw Your Delivery Zone On the Map"))
				{
					test.log(LogStatus.INFO, "Draw Your Delivery Zone On the Map is Displayed");
					
					ds.Draw_DeliveryZone_onMap();
					
					Thread.sleep(2000);
					//Click the Save button
					cmp.Click_SaveButton();
					
					Thread.sleep(2000);
					//Check whether the Delivery Zone Saved or not
					if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Delivery Zone Saved Successfully"))
					{
						test.log(LogStatus.PASS, "Delivery Zone Saved Successfully");
					}
					else
					{
						test.log(LogStatus.FAIL, "Delivery Zone Save Failed");
	
					}
				}
				else
				{
					test.log(LogStatus.FAIL, "Delivery Zone Save Failed");
				}
				
	}
	
	
	@Test(priority = 3,enabled = false)
	public void Edit_and_Update_Delivery_Zone(WebDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		ds=new Delivary_SettingsPage(driver, test);
		
		Thread.sleep(1000);
		ds.Click_Delivery_ZoneTab();
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

		Thread.sleep(1000);
		//Verify Filter Column
		cmp.Filter_Columns();
		
		cmp.SearchBox().click();
		
		Thread.sleep(3000);
		//Click the Delivery Zone
				cmp.SearchAndClickEdit(Utility.getProperty("New_Store_State")+"1");
				
				Thread.sleep(2000);
				//Verify whether the Delivery Zone Page opened or not
				cmp.VerifyCreationScreenPageHeader("Update Delivery Zone");
			
				Thread.sleep(1000);
				cmp.EnterName("");

				if(cmp.Update_Button().isEnabled())
				{
				//Click the Save button
				cmp.Click_UpdateButton();
				
				//Check whether the Delivery Zone Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Delivery Zone Updated Successfully"))
				{
					test.log(LogStatus.FAIL, "Delivery Zone Updated without Entering Name");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//					driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);

					Thread.sleep(3000);
					//Click the Delivery Zone
							cmp.SearchAndClickEdit(Utility.getProperty("New_Store_State")+"1");
							
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Invalid delivery zone"))
				{
					test.log(LogStatus.PASS, "Invalid delivery zone pop up is Displayed");
				}
				else
				{
					test.log(LogStatus.FAIL, "Invalid delivery zone Pop up not displayed");
					
//					try
//					{
//						ds.Click_Add_Delivery_Zone();
//					}
//					catch(Exception l) {}
				}
				}
				else
				{
					test.log(LogStatus.INFO, "Update button not Enabled without Entering Delivery Zone Name");
				}
				
				//Enter the Name
//				cmp.EnterName(Utility.getProperty("New_Store_State")+RandomStringUtils.randomNumeric(2));
				cmp.EnterName(Utility.getProperty("New_Store_State")+"1");

				//Enter Delivery Charge cost
				ds.Enter_Delivery_Charge_Cost("");
				
				if(cmp.Update_Button().isEnabled())
				{
				//Click the Update button
				cmp.Click_UpdateButton();
				
				//Check whether the Delivery Zone Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Delivery Zone Updated Successfully"))
				{
					test.log(LogStatus.FAIL, "Delivery Zone Updated without Entering Valid Delivery Charge");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
//					driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
					Thread.sleep(3000);
					//Click the Delivery Zone
							cmp.SearchAndClickEdit(Utility.getProperty("New_Store_State")+"1");
							
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Invalid delivery charge"))
				{
					test.log(LogStatus.PASS, "Invalid delivery charge pop up is Displayed");
				}
				else
				{
					test.log(LogStatus.FAIL, "Invalid delivery charge Pop up not displayed");
					
				
				}
				}
				else
				{
					test.log(LogStatus.INFO, "Update button not Enabled without Entering Delivery Cost");
				}
	
				//Enter the Name
				cmp.EnterName(Utility.getProperty("New_Store_State")+"1");
				
				
				//Enter the Delivery Charge Cost
				ds.Enter_Delivery_Charge_Cost("2000");
				
				//Enter the Expected Delivery Time
				ds.Enter_Expected_Delivery_Time("");
				
				if(cmp.Update_Button().isEnabled())
				{
				//Click the Update button
				cmp.Click_UpdateButton();
				
				//Check whether the Delivery Zone Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Delivery Zone Updated Successfully"))
				{
					test.log(LogStatus.FAIL, "Delivery Zone Updated without Entering Expected Delivery Time");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
					Thread.sleep(3000);
					//Click the Delivery Zone
							cmp.SearchAndClickEdit(Utility.getProperty("New_Store_State")+"1");
							
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Invalid delivery Time"))
				{
					test.log(LogStatus.PASS, "Invalid delivery Time pop up is Displayed");
				}
				else
				{
					test.log(LogStatus.FAIL, "Invalid delivery Time Pop up not displayed");
					
//					try
//					{
//						ds.Click_Add_Delivery_Zone();
//					}
//					catch(Exception l) {}
				}
				}
				else
				{
					test.log(LogStatus.INFO, "Update button not Enabled without Entering Expected Delivery Time");
				}
	
				
				
				
				
				//Enter the Name
				cmp.EnterName(Utility.getProperty("New_Store_State")+"2");
				
				
				//Enter the Delivery Charge Cost
				ds.Enter_Delivery_Charge_Cost("2000");
				
			
				//Enter the Expected Delivery Time
				ds.Enter_Expected_Delivery_Time("10");
				
				Thread.sleep(1000);
				//Click the Update button
				cmp.Click_UpdateButton();
				
				Thread.sleep(2000);
				//Check whether the Delivery Zone Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Delivery Zone Updated Successfully"))
				{
					test.log(LogStatus.PASS, "Delivery Zone Updated Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Delivery Zone Update Failed");
				}
				
				
				Thread.sleep(2000);
	}
	

	@Test(priority = 3,enabled = false)
	public void Delete_Delivery_Zone(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ds=new Delivary_SettingsPage(driver, test);
		
		ds.Click_Delivery_ZoneTab();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("New_Store_State")+"2");
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		
		
		try
		{
		if(driver.findElement(By.xpath("//div[.='"+Utility.getProperty("New_Store_State")+"2"+"']/../div/div[2]/button")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Delivery Zone not Inactivated when Click Cancel button");
		}
		}
		catch(Exception p)
		{
			test.log(LogStatus.FAIL, "Delivery Zone Inactivated when Click Cancel button");
		}
		
//Search and Click Delete button
cmp.SearchAndClickDelete(Utility.getProperty("New_Store_State")+"2");

Thread.sleep(500);
//Click the Delete button
cmp.Click_DeleteButton();


//Enable the Inactive Status
cmp.Click_ActivetoInactiveButton();

//Check whether the Inactive screen opened or not
cmp.VerifyActive_InactiveStatus("Inactive");

//Search and Activate the In activated item
cmp.SearchAndClickActivate(Utility.getProperty("New_Store_State")+"2");

Thread.sleep(500);
//Click the Delete button
cmp.Alert_PopupMsg("Are you sure you want to activate this item?");

//Click the Cancel button
cmp.Click_CancelButtonInAlert();

try
{
if(driver.findElement(By.xpath("//div[.='"+Utility.getProperty("New_Store_State")+"2"+"']/../div/div/button")).isDisplayed())
{
	test.log(LogStatus.PASS, "Delivery Zone not Activated when Click Cancel button");
}
}
catch(Exception p)
{
	test.log(LogStatus.FAIL, "Delivery Zone Activated when Click Cancel button");
}




//Search and Activate the In activated item
cmp.SearchAndClickActivate(Utility.getProperty("New_Store_State")+"2");

Thread.sleep(500);
//Click the Activate button
cmp.Click_ActivateButton();


Thread.sleep(500);
//Enable Active Status
cmp.Click_InactivetoActiveButton();
		
Thread.sleep(500);
//Check whether verify whether the Active page opened or not
cmp.VerifyActive_InactiveStatus("Active");




		
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
