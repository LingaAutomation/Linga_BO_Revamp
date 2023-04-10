package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.Availability_RestrictionTimePage;
import com.Pages.Common_XPaths;
import com.Pages.Payroll_Report_SettingsPage;
import com.Test.LoginTest;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Payroll_Report 
{

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings - Payroll Report");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Payroll_Report_SettingsPage prr;
	
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
		Open_Payroll_Report_Settings_Page(driver);
		Save_Payroll_Report_Settings(driver);
		Add_OverTime_Settings_Daily(driver);

	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Payroll_Report_Settings_Page(WebDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		prr=new Payroll_Report_SettingsPage(driver, test);
		Thread.sleep(5000);
		//Load the Label Printer page
		driver.get(Utility.getProperty("baseURL")+"settings/"+"payroll");

		Thread.sleep(5000);
		//Verify the Payroll Report page loaded or not
		cmp.VerifyCreationScreenPageHeader_Two("Payroll Report");
//		if(cmp.VerifyMainScreenPageHeader(Str);)
//		{
//			test.log(LogStatus.PASS, "Payroll Report Page Loaded Successfully");
//			
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Payroll Report Page Loading Failed");
//			
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Save_Payroll_Report_Settings(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		prr=new Payroll_Report_SettingsPage(driver, test);
		Thread.sleep(2000);
	
		//Enable Allow Over Tip Out
		prr.Enable_Allow_OverTip_Out();
		
		
	//Select Payroll Week Start Day
		prr.Select_Payroll_Week_StartDay();
		
		//Get the Start Day Bef Update
		String StartDay_Bef=prr.Payroll_Week_StartDay().getAttribute("value");
		
		
	
	
		//Select Weekly Default Payroll Process
		prr.Select_Weekly_Default_PayrollProcess();
		
		//Enter Minimum Age
		prr.Setup_Hours_Limit_byAge("0", "0");
		
		//Verify minimum age error msg
		prr.Verify_Minimum_Age_ErrorMessage();
		
		
		//Enter Minimum Age
		prr.Setup_Hours_Limit_byAge("200", "2");
		
		//Verify maximum age limit
		prr.Verify_Age_Limit_ErrorMessage();
		
		
		//Enter Minimum Age
		prr.Setup_Hours_Limit_byAge("20", "8");
	
		
		
						Thread.sleep(1000);
						//Click the Save button
						cmp.Click_Save_ButtonTwo();
						
						Thread.sleep(3000);
						//Verify whether the Payroll Report Saved or not
						if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payroll Report Saved Successfully"))
						{
							test.log(LogStatus.PASS, "Payroll Report Saved Successfully");
							
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
						}
						else
						{
							test.log(LogStatus.FAIL, "Payroll Report Save Failed");
							
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}

						
						Thread.sleep(3000);
						driver.navigate().refresh();
						
						Thread.sleep(5000);
						
						
						//Get the Start Day After Update
						String StartDay_Aft=prr.Payroll_Week_StartDay().getAttribute("value");
					
				//Verify whether the Start Day is Changed or not
						if(StartDay_Aft.equalsIgnoreCase(StartDay_Bef))
						{
							test.log(LogStatus.PASS, "Start Day is not Chnaged after Reopen the page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Start Day is Chnaged after Reopen the page");

						}
						
						//Check whether the Allow Over Tip Out enabled or not
						if(prr.Allow_OverTip_Out_YesBtn().isEnabled())
						{
							test.log(LogStatus.PASS, "Allow Over Tip Out is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Allow Over Tip Out is not Selected");
						}
						
						
	}
		
	
	
	@Test(priority = 5,enabled = false)
	public void Add_OverTime_Settings_Daily(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
	
		cmp=new Common_XPaths(driver, test);
		prr=new Payroll_Report_SettingsPage(driver, test);
		Thread.sleep(2000);
		
		//Select Overtime Settings Tab
		prr.Select_OverTime_SettingsTab();
		
		Thread.sleep(1000);
		//Click Over Time
		prr.Click_OverTime();
		
		//Verify Overtime creation page
		cmp.VerifyCreationScreenPageHeader("New Over Time");
		
		//Click Daily set Overtime
		prr.Click_Daily_SetOverTime();
		
		//Select Same day Effective Date
		prr.Select_SameDay_Effective_Date();
		
		//Enter Overtime One
		prr.Enter_OverTime_One("4", "80");
		
		//Verify whether the Enter valid Percentage displayed or not
		prr.Verify_Valid_Percentage_ErrorMessage();
		
		
		//Enter Overtime One
		prr.Enter_OverTime_One("2", "100");
		
		
		//Enter OverTime Two
		prr.Enter_OverTime_Two("1", "100");
		
		//Verify whether the Enter Valid Hours is Displayed or not
		prr.Verify_Valid_Hours_ErrorMessage();
		
		//Enter OverTime Two
				prr.Enter_OverTime_Two("4", "120");
				
		
		//Enter the Overtime three
				prr.Enter_OverTime_Three("3", "150");
	
				
				//Verify whether the Enter Valid Hours is Displayed or not
				prr.Verify_Valid_Hours_ErrorMessage();
				
				
				//Enter the Overtime three
						prr.Enter_OverTime_Three("4", "150");
			
						
						//Verify whether the Enter Valid Hours is Displayed or not
						prr.Verify_Valid_Hours_ErrorMessage();
						
					
				
				//Enter the Overtime three
				prr.Enter_OverTime_Three("6", "150");
				
				
				Thread.sleep(2000);
				//Click the Save button
				cmp.Click_SaveButton();
	
				
				Thread.sleep(3000);
				//Verify whether the Payroll Report Saved or not 
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("OT Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Over Time Saved Successfully");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Effective date already exists"))
				{
					test.log(LogStatus.INFO, "Effective date already exists");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);

				}
				else
				{
					test.log(LogStatus.FAIL, "Over Time Save Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			
				Thread.sleep(1000);
				//Click the Edit button
				prr.Edit_OverTime();
				Thread.sleep(1000);

				//Verify The field cannot be edited since it has passed the effective date is Displayed or not
				prr.Verify_Effective_CannotBeEdit_ErrorMsg();
				
				Thread.sleep(1000);
//				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				
				cmp.Cursor_MoveToElement(driver.findElement(By.xpath("//div[@class='data-grid']")));
				
				driver.findElement(By.xpath("//div[@class='data-grid']")).click();
				for(int i=1;i<=5;i++)
				{
					Thread.sleep(1000);
					driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
				}
				
				Thread.sleep(2000);
				//Click Over Time
				prr.Click_OverTime();
				Thread.sleep(1000);

			
				//Click Daily set Overtime
				prr.Click_Daily_SetOverTime();
				Thread.sleep(1000);

				//Select Same day Effective Date
				prr.Select_SameDay_Effective_Date();
				Thread.sleep(1000);

				//Enter Overtime One
				prr.Enter_OverTime_One("1", "100");
				Thread.sleep(1000);

				//Enter Overtime Two
				prr.Enter_OverTime_Two("2", "150");
				Thread.sleep(1000);

				//Enter Overtime Three
				prr.Enter_OverTime_Three("3", "200");
				Thread.sleep(1000);

			
				//Click the Save button
				cmp.Click_SaveButton();
				
				Thread.sleep(3000);
				//Verify whether the Payroll Report Saved or not 
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Effective date already exists"))
				{
					test.log(LogStatus.PASS, "Effective date already exists is Displayed");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);

				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("OT Saved Successfully"))
				{

					test.log(LogStatus.FAIL, "Duplicate Over Time Saved");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.INFO, "Over Time Save Failed");
					
				}
				
				Thread.sleep(1000);
//				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
//				
				cmp.Cursor_MoveToElement(driver.findElement(By.xpath("//div[@class='data-grid']")));
				
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@class='data-grid']")).click();
				for(int i=1;i<=5;i++)
				{
					Thread.sleep(1000);
					driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
				}
			
				Thread.sleep(2000);
				//Click Over Time
				prr.Click_OverTime();
				
			
				//Click Daily set Overtime
				prr.Click_Daily_SetOverTime();
				
				//Select Same day Effective Date
				prr.Select_Effective_Date();
				
				//Enter Overtime One
				prr.Enter_OverTime_One("1", "100");
				
				//Enter Overtime Two
				prr.Enter_OverTime_Two("2", "150");
			
				//Enter Overtime Three
				prr.Enter_OverTime_Three("3", "200");
				
				
				//Get the Hour in Weekly
				String Hours_OneBef=prr.Hours_OverTime_OneInputBox().getAttribute("value");
				
				//Get the Percentage in Weekly
				String Percentage_OneBef=prr.Percentage_OverTime_OneInputBox().getAttribute("value");
			
				
				//Click the Save button
				cmp.Click_SaveButton();
				
				Thread.sleep(3000);
				//Verify whether the Payroll Report Saved or not 
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("OT Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Over Time Saved Successfully");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Effective date already exists"))
				{
					test.log(LogStatus.INFO, "Effective date already exists");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);

				}
				else
				{
					test.log(LogStatus.FAIL, "Over Time Save Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				
				//Edit the OverTime
				prr.Edit_OverTime();
				
				try
				{
					if(prr.Daily_Set_OverTime().isDisplayed())
					{
						
				
				
				
				Thread.sleep(2000);
				//Verify Overtime creation page
				cmp.VerifyCreationScreenPageHeader("Update Over Time");
				
				
				//Get the Hour in Weekly
				String Hours_OneAft=prr.Hours_OverTime_OneInputBox().getAttribute("value");
				
				//Get the Percentage in Weekly
				String Percentage_OneAft=prr.Percentage_OverTime_OneInputBox().getAttribute("value");
			
				
				if(Hours_OneAft.equalsIgnoreCase(Hours_OneBef))
				{
					test.log(LogStatus.PASS, "Hours value is not changed after Reopen for Daily Set OverTime");
				}
				else
				{
					test.log(LogStatus.FAIL, "Hours value is changed after Reopen for Daily Set OverTime");
				}
				
				if(Percentage_OneAft.equalsIgnoreCase(Percentage_OneBef))
				{
					test.log(LogStatus.PASS, "Percentage value is not changed after Reopen for Daily Set OverTime");
				}
				else
				{
					test.log(LogStatus.FAIL, "Percentage value is changed after Reopen for Daily Set OverTime");
				}
				
			
			
				Thread.sleep(1500);
				//Click Weekly Set OverTime
				prr.Click_Weekly_SetOverTime();
				
				//Enter OverTime for Weekly
				prr.Enter_Enter_OverTime_Weekly("0", "80");
				
				//Click the Update buton
				cmp.Click_UpdateButton();
				
				
				Thread.sleep(3000);
				//Verify whether the Payroll Report Saved or not 
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("OT Updated Successfully"))
				{
					test.log(LogStatus.FAIL, "Over Time Updated Successfully with Invalid Percentage");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
					
					//Edit the OverTime
					prr.Edit_OverTime();
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enter Valid percentage"))
				{
					test.log(LogStatus.PASS, "Enter Valid percentage is Displayed");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);

				}
				else
				{
					test.log(LogStatus.INFO, "Over Time Update Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Enter OverTime for Weekly
				prr.Enter_Enter_OverTime_Weekly("2", "100");
				
				
				//Get the Hour in Weekly
				String Hours_Bef=prr.Hours_LimitInputBox().getAttribute("value");
				
				//Get the Percentage in Weekly
				String Percentage_Bef=cmp.Percentage_Input().getAttribute("value");
				
				//Click the Update buton
				cmp.Click_UpdateButton();
				
				Thread.sleep(3000);
				//Verify whether the Payroll Report Saved or not 
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("OT Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Over Time Updated Successfully for Weekly");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Over Time Update Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				
				
				
	
		Thread.sleep(2000);
	
//		//Click the Settings Tab
//		prr.Select_SettingsTab();
//		
		driver.navigate().refresh();
		Thread.sleep(5000);
		
		
		//Select Overtime Settings Tab
		prr.Select_OverTime_SettingsTab();
		
		Thread.sleep(2000);
		//Edit OverTime
		prr.Edit_OverTime();
		
		//Check whether the Weekly Set OverTime selected or not
		if(prr.Weekly_Set_OverTime().isEnabled())
		{
			test.log(LogStatus.PASS, "Weekly is Selected for Set Over Time");
		}
		else
		{
			test.log(LogStatus.FAIL, "Weekly is not Selected for Set Over Time");
	
		}
		
		
		//Get the Hour in Weekly
		String Hours_Aft=prr.Hours_LimitInputBox().getAttribute("value");
		
		//Get the Percentage in Weekly
		String Percentage_Aft=cmp.Percentage_Input().getAttribute("value");
	
		
		if(Hours_Aft.equalsIgnoreCase(Hours_Bef))
		{
			test.log(LogStatus.PASS, "Hours value is not changed after Reopen for Weekly Set OverTime");
		}
		else
		{
			test.log(LogStatus.FAIL, "Hours value is changed after Reopen for Weekly Set OverTime");
		}
		
		if(Percentage_Aft.equalsIgnoreCase(Percentage_Bef))
		{
			test.log(LogStatus.PASS, "Percentage value is not changed after Reopen for Weekly Set OverTime");
		}
		else
		{
			test.log(LogStatus.FAIL, "Percentage value is changed after Reopen for Weekly Set OverTime");
		}
		
					
		//Click Daily as Set OverTime
		prr.Click_Daily_SetOverTime();
		
		
		//Click the Update button
		cmp.Click_UpdateButton();
		
						
		Thread.sleep(3000);
		//Verify whether the Payroll Report Saved or not 
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("OT Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Over Time Updated Successfully for Daily");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Over Time Update Failed for Daily");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
						
						
		Thread.sleep(2000);
		//Edit OverTime
		prr.Edit_OverTime();
		
		//Check whether the Daily Set OverTime selected or not
		if(prr.Daily_Set_OverTime().isEnabled())
		{
			test.log(LogStatus.PASS, "Daily is Selected for Set Over Time");
		}
		else
		{
			test.log(LogStatus.FAIL, "Daily is not Selected for Set Over Time");
	
		}			
		
		
		//Click the Cancel button
		cmp.Click_CancelButton();
		
		}
		}
				
		catch(Exception h)
		{
			test.log(LogStatus.INFO, "Over Time unable to Edit");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
				
				Thread.sleep(1000);
//				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				
				cmp.Cursor_MoveToElement(driver.findElement(By.xpath("//div[@class='data-grid']")));
				
				driver.findElement(By.xpath("//div[@class='data-grid']")).click();
				for(int i=1;i<=5;i++)
				{
					Thread.sleep(1000);
					driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
				}
					
				
		//Click the Settings Tab
		prr.Select_SettingsTab();
		
		//Disable Allow OverTip Out
		prr.Disable_Allow_OverTip_Out();
						
		
		Thread.sleep(1000);
		//Click the Save button
		cmp.Click_Save_ButtonTwo();
		
		Thread.sleep(3000);
		//Verify whether the Payroll Report Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payroll Report Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Payroll Report Updated Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payroll Report Update Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

		
	}
	
		
}
