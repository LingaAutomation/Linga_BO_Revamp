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
import com.Pages.ItemServiceChargePage;
import com.Pages.LoginPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_Item_Service_Charge {
public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete Item Service Charge");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	ItemServiceChargePage isc;
	
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
			String scnsht=((TakesScreenshot)driver.getDelegate()).getScreenshotAs(OutputType.BASE64);
			
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
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		
		options.setHeadless(false);
		
		WebDriver delegate=new ChromeDriver();
		
		driver=SelfHealingDriver.create(delegate);
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver(chrOpt);
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
		Open_Item_Service_Charge_Page(driver);
//		RefreshAndPaginination(driver);
//		Add_Item_Service_Charge(driver);
		Edit_and_Close_Cancel_Item_Service_Charge(driver);
		Edit_and_Update_Item_Service_Charge(driver);
		Delete_and_Active_Inactive_Item_Service_Charge(driver);
		Create_Duplicate_Item_Service_Charge(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Item_Service_Charge_Page(SelfHealingDriver driver) throws Exception
	{
		
		isc=new ItemServiceChargePage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Item Service Charge page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"itemServiceCharge");

		Thread.sleep(5000);
		//Verify the Item Service Charge page loeded or not
		cmp.VerifyMainScreenPageHeader("Item Service Charge");	
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();
		
		Thread.sleep(10000);
		//Verify Column Filtration
		cmp.Filter_Columns();
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_Item_Service_Charge(SelfHealingDriver driver) throws Exception
	{
		isc=new ItemServiceChargePage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Item Service Charge
		isc.Click_NewItemServiceChargeButton();
		Thread.sleep(2000);
	
		//Verify the New Item Service Charge creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Item Service Charge");
		Thread.sleep(2000);
		
		if(cmp.Save_Button().isEnabled())
		{
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Item Service Charge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Name"))
		{
			test.log(LogStatus.PASS, "Please Enter Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.PASS, "Save button not Enabled without Entering Item Serving Charge name");
		}
		
		Thread.sleep(1000);
		//Enter Item Service charge name
		isc.Enter_Item_Service_Charge_Name(Utility.getProperty("Item_Service_Charge_Name")+"BB");
		
//		if(cmp.Save_Button().isEnabled())
//		{
//		//Click the Save button
//		cmp.Click_SaveButton();
//		
//		Thread.sleep(3000);
//		//Check whether the New Item Service Charge Saved or not
//		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Percentage"))
//		{
//			test.log(LogStatus.PASS, "Please Enter Percentage Alert Displayed");
//		
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Please Enter Percentage Alert not Displayed");
//			
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
//		}
//		else
//		{
//			test.log(LogStatus.PASS, "Save button not Enabled without Entering Item Serving Charge Percentage");
//		}
		
		Thread.sleep(2000);
		//Enter Item Service charge name
		isc.Enter_Item_Service_Charge_Name(Utility.getProperty("Item_Service_Charge_Name"));
		
		Thread.sleep(500);
		//Enter the Percentage
		isc.Enter_Item_Service_Charge_Percentage("5000");
		
//		//Click the Save button
//		cmp.Click_SaveButton();
//		
//		Thread.sleep(3000);
//		//Check whether the New Item Service Charge Saved or not
//		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Taxes"))
//		{
//			test.log(LogStatus.PASS, "Please Enter Taxes Alert Displayed");
//		
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Item Service Charge Saved Successfully")) 
//		{
//			test.log(LogStatus.FAIL, "Item Service Charge Saved without selecting Taxes");
//			
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			
//			Thread.sleep(3000);
//			isc.Click_NewItemServiceChargeButton();
//			Thread.sleep(1000);
//		}
//		else
//		{
//			test.log(LogStatus.INFO, "Please Enter Taxes Alert not Displayed");
//		}
//		
//		Thread.sleep(1000);
//		if(isc.New_ItemServiceChargeButton().isDisplayed())
//		{
//			Thread.sleep(2000);
//			isc.Click_NewItemServiceChargeButton();
//			
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
//		else
//		{
//			
//		}
//		
//		Thread.sleep(1000);
//		//Enter the Item Service Charge 
//		isc.Enter_Item_Service_Charge(Utility.getProperty("Item_Service_Charge_Name"));
		
		Thread.sleep(500);
		//Enter the Taxes
//		isc.SelectAll_Tax();
//		isc.Select_Random_Tax();
			
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 50);
		//Check whether the New Item Service Charge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Item Service Charge Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Item Service Charge Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Service Charge Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Item_Service_Charge(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		isc=new ItemServiceChargePage(driver, test);
		
		cmp.Wait_ForElementVisibility(cmp.SearchBox(), 150);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Item_Service_Charge_Name"));
		
		Thread.sleep(2000);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Item Service Charge");
		
		Thread.sleep(2000);
		//Click the Close button
		cmp.Click_CloseButton();
		
		Thread.sleep(1000);
		//Check whether the New Item Service Charge Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Editing Item Service Charge screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Editing Item Service Charge screen not Closed");
		}
		
		
		Thread.sleep(2000);
		//Search the Item Service Charge to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("Item_Service_Charge_Name"));
		
		Thread.sleep(2000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Item Service Charge Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Item Service Charge screen Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Service Charge screen not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Item_Service_Charge(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		isc=new ItemServiceChargePage(driver, test);
		
		cmp.Wait_ForElementVisibility(cmp.SearchBox(), 150);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
	
		Thread.sleep(2000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Item_Service_Charge_Name"));
		
		
	
		Thread.sleep(2000);
		//Enter the Name
		isc.Enter_Item_Service_Charge_Name("");
		
		if(cmp.Update_Button().isEnabled())
		{
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		
		
	
		Thread.sleep(2000);
		//Check whether the New Reason Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Name"))
		{
			test.log(LogStatus.PASS, "Please enter Name pop up Displayed");
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Item Service Charge Updated Successfully"))
		{
			test.log(LogStatus.FAIL, "Item Service Charge Updated without entering Name");
		
			
			Thread.sleep(5000);
			//Search and Click Edit button
			cmp.SearchAndClickEdit(Utility.getProperty("Item_Service_Charge_Name"));
		
			Thread.sleep(2000);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please enter Reason pop up not Displayed");
			
		}
		}
		else
		{
			test.log(LogStatus.PASS, "Update button not Enabled without Entering Item Serving Charge name");
		}
		
		
		Thread.sleep(3000);
		//Enter the Name
		isc.Enter_Item_Service_Charge_Name(Utility.getProperty("Item_Service_Charge_Name")+"1");

		
		
		
//		Thread.sleep(500);
//		//Enter the Percentage
//		isc.Enter_Item_Service_Charge_Percentage("");
//		
//		if(cmp.Update_Button().isEnabled())
//		{
//		Thread.sleep(500);
//		//Click the Update button
//		cmp.Click_UpdateButton();
//		
//		
//		
//	
//		Thread.sleep(3000);
//		//Check whether the New Reason Saved or not
//		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Percentage"))
//		{
//			test.log(LogStatus.PASS, "Please Enter Percentage pop up Displayed");
//		}
//		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Item Service Charge Updated Successfully"))
//		{
//			test.log(LogStatus.FAIL, "Item Service Charge Updated without entering Percentage");
//		
//			
//			Thread.sleep(3000);
//			//Search and Click Edit button
//			cmp.SearchAndClickEdit(Utility.getProperty("Item_Service_Charge_Name")+"1");
//		
//			
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Please Enter Percentage pop up not Displayed");
//			
//		}
//		}
//		else
//		{
//			test.log(LogStatus.PASS, "Update button not Enabled without Entering Item Serving Charge Percentage");
//		}
//		
		Thread.sleep(3000);
		//Enter the Name
		isc.Enter_Item_Service_Charge_Name(Utility.getProperty("Item_Service_Charge_Name")+"1");

		
		Thread.sleep(500);
		//Enter the Percentage
		isc.Enter_Item_Service_Charge_Percentage("2000");
		
		
		Thread.sleep(500);
		//Select All Taxes
		isc.Select_Random_Tax();
		
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Item Service Charge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Item Service Charge Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Item Service Charge Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Service Charge Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		
		Thread.sleep(8000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Item_Service_Charge_Name")+"1");
	
		
		Thread.sleep(3000);
		//Enter the Name
		isc.Enter_Item_Service_Charge_Name(Utility.getProperty("Item_Service_Charge_Name")+"1");

		
		Thread.sleep(1000);
		//Clear Taxes
		isc.Close_Taxes_ItemServiceCharge();
		
		Thread.sleep(1000);
		//Click Tax input box
		isc.Taxes_Input_ItemServiceCharge().click();
		
		Thread.sleep(1000);
		//Select Any taxes
		isc.Select_Random_Tax();
		
		Thread.sleep(1000);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Item Service Charge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Item Service Charge Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Item Service Charge Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Service Charge Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Item_Service_Charge(SelfHealingDriver driver) throws Exception
	{
		Thread.sleep(1500);
		
		cmp=new Common_XPaths(driver, test);
		isc=new ItemServiceChargePage(driver, test);
		
		cmp.Wait_ForElementVisibility(cmp.SearchBox(), 150);
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Item_Service_Charge_Name")+"1");
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Item Service Charge Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Item Service Charge Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Item Service Charge not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}



		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Item_Service_Charge_Name")+"1");
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Item Service Charge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Item Service Charge Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Item Service Charge Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Service Charge Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(8000);
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("Item_Service_Charge_Name")+"1");
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();

				try
				{
				Thread.sleep(3000);
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Item Service Charge Activated Successfully"))
				{
					test.log(LogStatus.FAIL, "Item Service Charge Activated when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Item Service Charge not Activated when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}


		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("Item_Service_Charge_Name")+"1");
		
		Thread.sleep(500);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Item Service Charge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Item Service Charge Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Item Service Charge activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Service Charge activated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(8000);
		//Enable Active Status
		cmp.Click_InactivetoActiveButton();
				
		Thread.sleep(500);
		//Check whether verify whether the Active page opened or not
		cmp.VerifyActive_InactiveStatus("Active");
		
	
		
	}
	
	@Test(priority = 6,enabled = false)
	public void Create_Duplicate_Item_Service_Charge(SelfHealingDriver driver) throws Exception
	{
		isc=new ItemServiceChargePage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Item Service Charge button
		isc.Click_NewItemServiceChargeButton();
		Thread.sleep(2000);
	
		Thread.sleep(500);
		//Enter the existing Item Service Charge name
		cmp.EnterName(Utility.getProperty("Item_Service_Charge_Name")+"1");
		
	
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Item Service Charge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Item Service Charge Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_CancelButton();
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error(s)"))
		{
			test.log(LogStatus.PASS, "Validation Error(s) pop up displayed");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_CancelButton();
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Service Charge Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
}
