package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
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

import com.Pages.BasePage;
import com.Pages.Common_XPaths;
import com.Pages.InventoryPage;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Adjust_Inventory_Reasons 
{
	public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Adjust Inventory Reasons");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	InventoryPage air;
	BasePage bp=new BasePage(driver, test);
			
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
//		System.setProperty("webdriver.chrome.driver","./Automation Driver/chromedriver.exe");
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
		Open_Adjust_Inventory_Reason_Page(driver);
		RefreshAndPaginination_ColumnFilteration(driver);
		Add_Adjust_Inventory_Reason(driver);
		Edit_and_Close_Cancel_Adjust_Inventory_Reason(driver);
		Edit_and_Update_Adjust_Inventory_Reason_Type_As_Increase(driver);
		Edit_and_Update_Adjust_Inventory_Reason_Type_As_Decrease(driver);
		Edit_and_Update_Adjust_Inventory_Reason_Type_As_Adjustment(driver);
		Delete_and_Active_Inactive_Adjust_Inventory_Reason(driver);
		Create_Duplicate_Adjust_Inventory_Reason(driver);
		Verify_Integration_Adj_Inv_Reason_In_Adjust_Inventory_and_Adjust_Inventory_Report(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Adjust_Inventory_Reason_Page(SelfHealingDriver driver) throws Exception
	{
		
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"adjustInventoryReasons");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Adjust Inventory Reasons");	
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination_ColumnFilteration(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		//Verify the Pagination and Refresh the page
		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
		
		Thread.sleep(2000);
		//Verify Ascending order for name 
		cmp.Ascending_And_Descending_Order();
		
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_Adjust_Inventory_Reason(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Coursing
		air.Click_New_Adjustment_Reason();
		Thread.sleep(2000);
	
		//Verify the New Course creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Reason");
		Thread.sleep(2000);
		
		if(cmp.Save_Button().isEnabled())
		{
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
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
			test.log(LogStatus.INFO, "Save button not Enabled without Entering Adjust Inventory Reason Name");
		}
		
//		cmp.Enter_Excess_Limit_Name(cmp.NameInputBox());
		
		String NameExcess = "Entering Invalid Name to input & Entering Invalid Name to input"; 
		int ActualSize= NameExcess.length();
		System.out.println(ActualSize);

		//Enter the Modifier Name
		cmp.EnterName(NameExcess);
		
		//To get value
		String ActualName=cmp.NameInputBox().getAttribute("value");
		int EnteredSize= ActualName.length();
		System.out.println(EnteredSize);

		if(ActualSize!=EnteredSize)
		{
			test.log(LogStatus.PASS, "Name should not be Exceeded 25 Characters");
		}
		else
		{
			test.log(LogStatus.FAIL, "Name should exceeded the size");
		}
		
		
		Thread.sleep(500);
		//Enter the Course Name
		cmp.EnterName(Utility.getProperty("New_InventoryReason_Name"));
		
		//Enable the Default
		air.Default_Yes_ToggleBtn().click();
		
		//Click the Adjustment Reason Type
		air.Adjustment_RadioBtn().click();
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reason saved successfully!."))
		{
			test.log(LogStatus.PASS, "Adjust Inventory Reason Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Adjust Inventory Reason Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Adjust_Inventory_Reason(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		Thread.sleep(500);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("New_InventoryReason_Name"));
		
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Edit Adjustment Reason");
		
		
		Thread.sleep(1000);
		//Click the Close button
		cmp.Click_CloseButton();
		
		Thread.sleep(1000);
		//Check whether the New Course Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Editing Adjust Inventory Reason screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Editing Adjust Inventory Reason screen not Closed");
		}
		
		Thread.sleep(500);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("New_InventoryReason_Name"));
		
		
		Thread.sleep(1000);
		//Click the Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Course Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Adjust Inventory Reason Screen Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Adjust Inventory Reason Screen Cancelled");
		}
		
	}
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Adjust_Inventory_Reason_Type_As_Increase(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
	
		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("New_InventoryReason_Name"));
		
		//Check whether the Default Reason Type is Enabled or not
		if(air.Default_Yes_ToggleBtn().isEnabled())
		{
			test.log(LogStatus.PASS, "Default Toggle is Enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Default Toggle is not Enabled");
		}
		
		
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName("");
		
		if(cmp.Update_Button().isEnabled())
		{
		//Click the Save button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Name"))
		{
			test.log(LogStatus.PASS, "Please Enter Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Course Updated Successfully"))
		{
			test.log(LogStatus.FAIL, "Adjust Inventory Reason Updated without Reason Name");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);

			Thread.sleep(1000);
			//Search and Click Edit button
			cmp.SearchAndClickEdit(Utility.getProperty("New_InventoryReason_Name"));
			
		}	
		else
		{
			test.log(LogStatus.INFO, "Please Enter Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.INFO, "Update button is not enabled without entering Adjust Inventory Reason Name");
		}
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("New_InventoryReason_Name")+"1");
	
		//Disable Default
		air.Default_No_ToggleBtn().click();
		
		//Select Reason Type as Increase
		air.Increase_RadioBtn().click();
				
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reason Updated successfully!."))
		{
			test.log(LogStatus.PASS, "Adjust Inventory Reason Updated Successfully for Reason Type - Increase");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Adjust Inventory Reason Updated Failed for Reason Type - Increase");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Adjust_Inventory_Reason_Type_As_Decrease(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
	
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("New_InventoryReason_Name")+"1");
		
		//Check whether the Default Reason Type is Disabled or not
		if(air.Default_No_ToggleBtn().isEnabled())
		{
			test.log(LogStatus.PASS, "Default Toggle is Disabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Default Toggle is not Disabled");
		}

		//Check whether Increase Reason Type is Selected or not
		if(air.Increase_RadioBtn().isSelected())
		{
			test.log(LogStatus.PASS, "Increase Reason Type is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase Reason Type is not Selected");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);

		}
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("New_InventoryReason_Name"));
	
		//Disable Default
		air.Default_No_ToggleBtn().click();
		
		//Select Reason Type as Increase
		air.Decrease_RadioBtn().click();
		
		//Check whether the Wastage Report is Displayed or not
		if(air.Wastage_Report_Yes_ToggleBtn().isDisplayed())
		{
			test.log(LogStatus.PASS, "Wastage Report Toggle is Displayed");
		}
		else
		{
			test.log(LogStatus.PASS, "Wastage Report Toggle is not Displayed");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable Wastage Report
		air.Wastage_Report_Yes_ToggleBtn().click();
		
		
				
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reason Updated successfully!."))
		{
			test.log(LogStatus.PASS, "Adjust Inventory Reason Updated Successfully for Reason Type - Decrease with Wastage Report");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Adjust Inventory Reason Updated Failed for Reason Type - Decrease with Wastage Report");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("New_InventoryReason_Name"));
		

		//Check whether Increase Reason Type is Selected or not
		if(air.Decrease_RadioBtn().isSelected())
		{
			test.log(LogStatus.PASS, "Decrease Reason Type is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease Reason Type is not Selected");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);

		}
		
		//Check whether the Wastage Report Reason Type is Disabled or not
				if(air.Wastage_Report_Yes_ToggleBtn().isEnabled())
				{
					test.log(LogStatus.PASS, "Wastage Report Toggle is Enabled");
				}
				else
				{
					test.log(LogStatus.FAIL, "Wastage Report Toggle is not Enabled");
				}
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("New_InventoryReason_Name"));
	
		//Disable Default
		air.Default_No_ToggleBtn().click();
		
		//Select Reason Type as Increase
		air.Decrease_RadioBtn().click();
		
		
		//Disable Wastage Report
		air.Wastage_Report_No_ToggleBtn().click();
		
		
				
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reason Updated successfully!."))
		{
			test.log(LogStatus.PASS, "Adjust Inventory Reason Updated Successfully for Reason Type - Decrease without Wastage Report");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Adjust Inventory Reason Updated Failed for Reason Type - Decrease without Wastage Report");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Adjust_Inventory_Reason_Type_As_Adjustment(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
	
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("New_InventoryReason_Name"));
		

		//Check whether Decrease Reason Type is Selected or not
		if(air.Adjustment_RadioBtn().isSelected())
		{
			test.log(LogStatus.PASS, "Decrease Reason Type is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease Reason Type is not Selected");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);

		}
		
		//Check whether the Wastage Report Reason Type is Disabled or not
		if(air.Wastage_Report_No_ToggleBtn().isEnabled())
		{
			test.log(LogStatus.PASS, "Wastage Report Toggle is Disabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Wastage Report Toggle is not Disabled");
		}

		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("New_InventoryReason_Name"));
	
		//Disable Default
		air.Default_Yes_ToggleBtn().click();
		
		//Select Reason Type as Adjustment
		air.Adjustment_RadioBtn().click();
				
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reason Updated successfully!."))
		{
			test.log(LogStatus.PASS, "Adjust Inventory Reason Updated Successfully for Reason Type - Adjustment");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Adjust Inventory Reason Updated Failed for Reason Type - Adjustment");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("New_InventoryReason_Name"));
		
		Thread.sleep(1000);
		//Check whether Adjustment Reason Type is Selected or not
		if(air.Adjustment_RadioBtn().isSelected())
		{
			test.log(LogStatus.PASS, "Adjustment Reason Type is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Adjustment Reason Type is not Selected");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);

		}
		
		//Click the Cancel button
		cmp.Click_CancelButton();
	}
	

	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Adjust_Inventory_Reason(SelfHealingDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("New_InventoryReason_Name"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reason Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Adjust Inventory Reason Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Adjust Inventory Reason not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("New_InventoryReason_Name"));
		
		//Click Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reason Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Adjust Inventory Reason Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Adjust Inventory Reason Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("New_InventoryReason_Name"));
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();

				try
				{
				Thread.sleep(3000);
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reason Activated Successfully"))
				{
					test.log(LogStatus.FAIL, "Adjust Inventory Reason Activated when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Adjust Inventory Reason not Activated when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}

		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("New_InventoryReason_Name"));
		
		//Click Activate button
				cmp.Click_ActivateButton();
				
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reason Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Adjust Inventory Reason activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Adjust Inventory Reason activated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(500);
		//Enable Active Status
		cmp.Click_InactivetoActiveButton();
				
		Thread.sleep(500);
		//Check whether verify whether the Active page opened or not
		cmp.VerifyActive_InactiveStatus("Active");
		
		Thread.sleep(1000);
		//Search the coursing to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("New_InventoryReason_Name"));
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
	}
	
	@Test(priority = 6,enabled = false)
	public void Create_Duplicate_Adjust_Inventory_Reason(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Coursing button
		air.Click_New_Adjustment_Reason();
		Thread.sleep(2000);
	
		Thread.sleep(500);
		//Enter the existing Course name
		cmp.EnterName(Utility.getProperty("New_InventoryReason_Name"));
		
		Thread.sleep(1000);
		//De-Select Default Toggle
		air.Default_No_ToggleBtn().click();
		
		//Click Adjustment Reason Type
		air.Adjustment_RadioBtn().click();
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Adjust Inventory Reason Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error(s)"))
		{
			test.log(LogStatus.PASS, "Validation Error(s) pop up displayed");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Reason saved successfully!."))
		{
			test.log(LogStatus.FAIL, "Duplicate Adjust Inventory Reason saved");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Adjust Inventory Reason Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Verify_Integration_Adj_Inv_Reason_In_Adjust_Inventory_and_Adjust_Inventory_Report(SelfHealingDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"adjustInventory");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Adjust Inventory");	
		
		//Select the Inventory Item Tab
		new InventoryPage(driver, test).Select_Inventory_Item_AdjustInventoryTab();
		
		String InvenItem=driver.findElement(By.xpath("//tbody/tr[1]/td[1]/span")).getText();
		
		
				
		//Search any Inventory Item from the list and 
		new Common_XPaths(driver, test).Search(InvenItem);
		
		//Click the Action button
		air.Click_Action_InventoryItem_AdjustInventoryBtn();
		
		//Get the Reason Type
		String ReasonType=air.Reason_Type_Adj_InvInputBox().getAttribute("value");
		
		String Expected_Reason=Utility.getProperty("New_InventoryReason_Name");
		
		System.out.println(Expected_Reason);
		
		//Verify the Default Reason Type is Reflected on the Adjust Inventory Item or not
		if(Expected_Reason.equalsIgnoreCase(ReasonType))
		{
			test.log(LogStatus.PASS, "Adjust Inventory Reason Name is Updated in Adjust Inventory as Reason Type as Expected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Adjust Inventory Reason Name is not Updated in Adjust Inventory as Reason Type as Expected. Actual Reason Type is "+ReasonType+ "But, Expected Reason Type is "+Expected_Reason);

		}
	
		//Get the Actual Inventory Count
		String Act_Count=air.Count_Adj_InvInputBox().getAttribute("value");
		
		//Adjusing Count 
		String Adjusting_count="20";
		
		air.Count_Adj_InvInputBox().clear();
		
		//Adjust the Inventory
		air.Count_Adj_InvInputBox().sendKeys(Adjusting_count);
		
		//Click the Update button
		cmp.Update_Button().click();
		
		
		 cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Stock adjusted successfully"))
		{
			test.log(LogStatus.PASS, "Stock adjusted successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Stock adjusted Failed");
		}
		
		Thread.sleep(5000);
		//Load the Department page
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"inventoryReports/adjustInventory");

				Thread.sleep(5000);
				//Verify the Coursing page loaded or not
				new ReportsPage(driver, test).Verify_ReportHomePage("ADJUST INVENTORY");
			
				//Select Today
				new ReportsPage(driver, test).Select_Today_TimePeriod();
				
				//Click Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				
				//Search the Inventory Item
				new Common_XPaths(driver, test).Search(InvenItem);
				
				String ActualInvItem=driver.findElement(By.xpath("//tbody/tr[2]/td[2]/span")).getText();
				
				String Prev_Count_AdjInvRpt=driver.findElement(By.xpath("//tbody/tr[2]/td[5]/span")).getText();
				
				String Adjusted_Count_AdjInvRpt=driver.findElement(By.xpath("//tbody/tr[2]/td[6]/span")).getText();
	
				if(Adjusting_count.equals(Adjusted_Count_AdjInvRpt))
				{
					test.log(LogStatus.PASS, "Adjusted Inventory Count Reflected in Adjust Inventory Reports Corrcetly");
				}
				else
				{
					test.log(LogStatus.FAIL, "Adjusted Inventory Count Reflected in Adjust Inventory Reports is Incorrcet. Actual Adjusted Count"+Adjusting_count+" Reflected Adjust Invnetory Count in Report is : "+Adjusted_Count_AdjInvRpt);
				}
	}
}
