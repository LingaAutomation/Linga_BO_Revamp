package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

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

import com.Pages.Common_XPaths;
import com.Pages.ReasonsPage;
import com.Pages.LoginPage;
import com.Pages.ReasonsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_Reasons {
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete Reasons");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	ReasonsPage rp;
	
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
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
//		//Open the Chrome window
//		driver = new ChromeDriver();
		
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
		Open_Reasons_Page(driver);
		RefreshAndPaginination(driver);
		Add_Reasons(driver);
		Edit_and_Close_Cancel_Reasons(driver);
		Edit_and_Update_Reasons(driver);
		Delete_and_Active_Inactive_Reasons(driver);
		Create_DuplicateReason(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Reasons_Page(WebDriver driver) throws Exception
	{
		
		rp=new ReasonsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Reasons page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"reasons");

		Thread.sleep(5000);
		//Verify the Reasons page loeded or not
		cmp.VerifyMainScreenPageHeader("Reasons");	
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
	public void Add_Reasons(WebDriver driver) throws Exception
	{
		rp=new ReasonsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Reasons
		rp.Click_NewReasonButton();
		Thread.sleep(2000);
	
		//Verify the New Reason creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Reason");
		Thread.sleep(2000);
		
		if(cmp.Save_Button().isEnabled())
		{
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Reason Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Reason"))
		{
			test.log(LogStatus.PASS, "Please Enter Reason Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Reason Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.PASS, "Save button not Enabled without Entering Reason Name");
		}
		
		Thread.sleep(1000);
		//Enter the Tax Exempt Reason Name
		rp.Select_TaxExemptReason(Utility.getProperty("TaxExemptReason"));
		
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Reason Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Tax Exempt Reason Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Exempt Reason Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(3000);
		//Click the New Reasons
		rp.Click_NewReasonButton();
		Thread.sleep(2000);
	
		
		Thread.sleep(2000);
		//Enter the Void Reason Name
		rp.Select_VoidReason(Utility.getProperty("VoidReason"));
		
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Reason Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Void Reason Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Void Reason Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		
		Thread.sleep(2000);
		//Click the New Reasons
		rp.Click_NewReasonButton();
		Thread.sleep(2000);
	
		
		Thread.sleep(1000);
		//Enter the Paid In Reason Name
		rp.Select_PaidInReason(Utility.getProperty("PaidInReason"));
		
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Reason Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Paid In Reason Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Paid In Reason Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(2000);
		//Click the New Reasons
		rp.Click_NewReasonButton();
		Thread.sleep(2000);
	
		
		Thread.sleep(1000);
		//Enter the Paid Out Reason Name
		rp.Select_PaidOutReason(Utility.getProperty("PaidOutReason"));
		
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Reason Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Paid Out Reason Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Paid Out Reason Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(2000);
		//Click the New Reasons
		rp.Click_NewReasonButton();
		Thread.sleep(2000);
	
		
		Thread.sleep(1000);
		//Enter the Over/Shortage Reason Name
		rp.Select_OverShortageReason(Utility.getProperty("OverShortageReason"));
		
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Reason Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Over/Shortage Reason Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Over/Shortage Reason Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(2000);
		//Click the New Reasons
		rp.Click_NewReasonButton();
		Thread.sleep(2000);
	
		
		Thread.sleep(1000);
		//Enter the Attach Request Reason Name
		rp.Select_AttachRequestReason(Utility.getProperty("AttachRequestReason"));
		
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Reason Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Attach Request Reason Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Attach Request Reason Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Reasons(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		rp=new ReasonsPage(driver, test);
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("TaxExemptReason"));
		
		Thread.sleep(1000);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Reason");
		
		
		Thread.sleep(1000);
		//Click the Close button
		cmp.Click_CloseButton();
		
		Thread.sleep(1000);
		//Check whether the New Reason Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Editing Reason screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Editing Reason screen not Closed");
		}
		
		
		Thread.sleep(1000);
		//Search the Reasons to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("TaxExemptReason"));
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		
		Thread.sleep(1000);
		//Check whether the New Reason Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Editing Reason screen Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Editing Reason screen not Cancelled");
		}
		
	}
		
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Reasons(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		rp=new ReasonsPage(driver, test);
		
		Thread.sleep(10000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("TaxExemptReason"));
		
		
		Thread.sleep(1000);
		//Enter the Name
		rp.Select_TaxExemptReason("");
		
		if(cmp.Update_Button().isEnabled())
		{
		Thread.sleep(1000);
		//Click the Update button
		cmp.Click_UpdateButton();
			
		Thread.sleep(3000);
		//Check whether the New Reason Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Reason"))
		{
			test.log(LogStatus.PASS, "Please enter Reason pop up Displayed");
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Updated Successfully"))
		{
			test.log(LogStatus.FAIL, "Tax Exempt Reason Updated without entering Reason");
		
			
			Thread.sleep(1000);
			//Search and Click Edit button
			cmp.SearchAndClickEdit(Utility.getProperty("TaxExemptReason"));
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Please enter Reason pop up not Displayed");
			
		}
		}
		else
		{
			test.log(LogStatus.PASS, "Update button not Enabled without Entering Reason Name");
		}
		
		
		Thread.sleep(4000);
		//Enter the Name
		rp.Select_TaxExemptReason(Utility.getProperty("TaxExemptReason")+"1");
		
		//Select void Reason Type
		rp.VoidReasonType().click();
		
		Thread.sleep(1000);
		//Click the Update button
		cmp.Click_UpdateButton();
		


		Thread.sleep(3000);
		//Check whether the New Reason Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Tax Exempt Reason Updated to Void Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Exempt Reason Updated to Void Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(2000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("TaxExemptReason")+"1");
		
		
		Thread.sleep(1000);
		//check whether the void type selected or not
		if(rp.VoidReasonType().isEnabled())
		{
			test.log(LogStatus.PASS, "Void Type selected as Expected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Void Type not Selected");
		}
		Thread.sleep(1000);
		//Select Tax Exempt
		rp.TaxExemptReasonType().click();
		
		Thread.sleep(1000);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		
		

		Thread.sleep(3000);
		//Check whether the New Reason Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Tax Exempt Reason Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Exempt Reason Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(2000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("TaxExemptReason")+"1");
		
		Thread.sleep(1000);
		//check whether the void type selected or not
		if(rp.TaxExemptReasonType().isEnabled())
		{
			test.log(LogStatus.PASS, "Tax Exempt Type selected as Expected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Exempt Type not Selected");
		}
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("VoidReason"));
		
		Thread.sleep(1000);
		//Enter the Name
		rp.Select_VoidReason(Utility.getProperty("VoidReason")+"1");
		
	
		
		
		Thread.sleep(1000);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Reason Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Void Reason Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Void Reason Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		


		

		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("PaidInReason"));
		
		Thread.sleep(1000);
		//Enter the Name
		rp.Select_PaidInReason(Utility.getProperty("PaidInReason")+"1");
		
	
		
		
		Thread.sleep(1000);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Reason Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Paid In Reason Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Paid In Reason Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		

		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("PaidOutReason"));
		
		Thread.sleep(1000);
		//Enter the Name
		rp.Select_PaidOutReason(Utility.getProperty("PaidOutReason")+"1");
		
	
		
		Thread.sleep(1000);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Reason Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Paid Out Reason Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Paid Out Reason Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		

		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("OverShortageReason"));
		
		Thread.sleep(1000);
		//Enter the Name
		rp.Select_OverShortageReason(Utility.getProperty("OverShortageReason")+"1");
		
		
		
		
		Thread.sleep(1000);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Reason Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Over/Shortage Reason Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Over/Shortage Reason Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		

		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("AttachRequestReason"));
		
		Thread.sleep(1000);
		//Enter the Name
		rp.Select_AttachRequestReason(Utility.getProperty("AttachRequestReason")+"1");
		
		
		
		
		Thread.sleep(1000);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
		//Check whether the New Reason Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Reasons Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Attach Request Reason Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Attach Request Reason Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Reasons(WebDriver driver) throws Exception
	{
		Thread.sleep(1000);
		
		cmp=new Common_XPaths(driver, test);
		rp=new ReasonsPage(driver, test);
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("TaxExemptReason")+"1");
		
		Thread.sleep(1000);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Reason Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Reason not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}


		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("TaxExemptReason")+"1");
		
		Thread.sleep(1000);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the Tax Exempt Reason Inactivated or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Tax Exempt Reason Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Exempt Reason Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		
		//Search and Click Delete button
				cmp.SearchAndClickDelete(Utility.getProperty("VoidReason")+"1");
				
				Thread.sleep(1000);
				//Click the Delete button
				cmp.Click_DeleteButton();
				
				Thread.sleep(3000);
				//Check whether the Void Reason Inactivated or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Inactivated Successfully"))
				{
					test.log(LogStatus.PASS, "Void Reason Inactivated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Void Reason Inactivated Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				//Search and Click Delete button
				cmp.SearchAndClickDelete(Utility.getProperty("PaidInReason")+"1");
				
				Thread.sleep(1000);
				//Click the Delete button
				cmp.Click_DeleteButton();
				
				Thread.sleep(3000);
				//Check whether the Paid In Reason Inactivated or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Inactivated Successfully"))
				{
					test.log(LogStatus.PASS, "Paid In Reason Inactivated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Paid In Reason Inactivated Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Search and Click Delete button
				cmp.SearchAndClickDelete(Utility.getProperty("PaidOutReason")+"1");
				
				Thread.sleep(1000);
				//Click the Delete button
				cmp.Click_DeleteButton();
				
				Thread.sleep(3000);
				//Check whether the Paid Out Reason Inactivated or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Inactivated Successfully"))
				{
					test.log(LogStatus.PASS, "Paid Out Reason Inactivated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Paid Out Reason Inactivated Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Search and Click Delete button
				cmp.SearchAndClickDelete(Utility.getProperty("OverShortageReason")+"1");
				
				Thread.sleep(1000);
				//Click the Delete button
				cmp.Click_DeleteButton();
				
				Thread.sleep(3000);
				//Check whether the Over/Shortage Reason Inactivated or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Inactivated Successfully"))
				{
					test.log(LogStatus.PASS, "Over/Shortage Reason Inactivated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Over/Shortage Reason Inactivated Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Search and Click Delete button
				cmp.SearchAndClickDelete(Utility.getProperty("AttachRequestReason")+"1");
				
				Thread.sleep(1000);
				//Click the Delete button
				cmp.Click_DeleteButton();
				
				Thread.sleep(3000);
				//Check whether the Attach Request Reason Inactivated or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Inactivated Successfully"))
				{
					test.log(LogStatus.PASS, "Attach Request Reason Inactivated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Attach Request Reason Inactivated Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
		
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("TaxExemptReason")+"1");
		
		Thread.sleep(1000);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		try
		{
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Activated Successfully"))
		{
			test.log(LogStatus.FAIL, "Reason Activated when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Reason not Activated when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("TaxExemptReason")+"1");
		
		Thread.sleep(1000);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the Tax Exempt Reason activated or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Tax Exempt Reason activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Exempt Reason activated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("VoidReason")+"1");
				
				Thread.sleep(1000);
				//Click the Activate button
				cmp.Click_ActivateButton();
				
				Thread.sleep(3000);
				//Check whether the Void Reason activated or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Activated Successfully"))
				{
					test.log(LogStatus.PASS, "Void Reason activated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Void Reason activated Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("PaidInReason")+"1");
				
				Thread.sleep(1000);
				//Click the Activate button
				cmp.Click_ActivateButton();
				
				Thread.sleep(3000);
				//Check whether the Paid In Reason activated or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Activated Successfully"))
				{
					test.log(LogStatus.PASS, "Paid In Reason activated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Paid In Reason activated Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("PaidOutReason")+"1");
				
				Thread.sleep(1000);
				//Click the Activate button
				cmp.Click_ActivateButton();
				
				Thread.sleep(3000);
				//Check whether the Paid Out Reason activated or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Activated Successfully"))
				{
					test.log(LogStatus.PASS, "Paid Out Reason activated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Paid Out Reason activated Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				
				//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("OverShortageReason")+"1");
				
				Thread.sleep(1000);
				//Click the Activate button
				cmp.Click_ActivateButton();
				
				Thread.sleep(3000);
				//Check whether the Over/Shortage Reason activated or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Activated Successfully"))
				{
					test.log(LogStatus.PASS, "Over/Shortage Reason activated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Over/Shortage Reason activated Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("AttachRequestReason")+"1");
				
				Thread.sleep(1000);
				//Click the Activate button
				cmp.Click_ActivateButton();
				
				Thread.sleep(3000);
				//Check whether the Attach Request Reason activated or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reasons Activated Successfully"))
				{
					test.log(LogStatus.PASS, "Attach Request Reason activated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Attach Request Reason activated Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
		
		
		Thread.sleep(1000);
		//Enable Active Status
		cmp.Click_InactivetoActiveButton();
				
		Thread.sleep(1000);
		//Check whether verify whether the Active page opened or not
		cmp.VerifyActive_InactiveStatus("Active");
		

		
	}
	
	@Test(priority = 6,enabled = false)
	public void Create_DuplicateReason(WebDriver driver) throws Exception
	{
		rp=new ReasonsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Reasons button
		rp.Click_NewReasonButton();
		Thread.sleep(2000);
	
		Thread.sleep(1000);
		//Enter the existing Reason name
		rp.Select_TaxExemptReason(Utility.getProperty("TaxExemptReason")+"1");
		
	
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Reason Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reason already exist"))
		{
			test.log(LogStatus.PASS, "Reason already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_CancelButton();
		}
		else
		{
			test.log(LogStatus.FAIL, "Reason already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
}
