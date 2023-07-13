package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
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
import com.Pages.CoursingPage;
import com.Pages.LoginPage;
import com.Pages.ModifierGroupsPage;
import com.Pages.ModifiersPage;
import com.Pages.ServingSizeLevelsPage;
import com.Pages.InventoryPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Storage_Locations {

	
	
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Storage Locations");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	InventoryPage air;
	
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
		Open_Inventory_Storage_Locations_Page(driver);
		RefreshAndPaginination(driver);
		Add_Inventory_Storage_Location(driver);
		Edit_and_Close_Cancel_Storage_Location(driver);
		Edit_and_Update_Storage_Location(driver);
		Delete_and_Active_Inactive_Storage_Location(driver);
		Create_Duplicate_Storage_Location(driver);
		Verify_Added_Storage_Location_in_InvetoryItem_Integration(driver);
		Verify_Added_Storage_Location_in_SubRecipe_Integration(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Inventory_Storage_Locations_Page(WebDriver driver) throws Exception
	{
		
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Storage Locations page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"storageLocations");

		Thread.sleep(5000);
		//Verify the Storage Location page loaded or not
		cmp.VerifyMainScreenPageHeader("Storage Locations");	
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
		
		//Verify Ascending
		cmp.Ascending_And_Descending_Order();
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_Inventory_Storage_Location(WebDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Storage Location
		air.Click_New_Storage_Location();
		Thread.sleep(2000);
	
		//Verify the New Storage Location creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Storage Location");
		Thread.sleep(2000);
		
		if(cmp.Save_Button().isEnabled())
		{
			Thread.sleep(1000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Storage Location Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Storage Location Name"))
		{
			test.log(LogStatus.PASS, "Please enter Storage Location Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please enter Storage Location Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.PASS, "Save button not Enabled without Entering Storage Location Name");
		}
		
		//Verify whether the Storage Location name field accepts the 25 maximum character
		new Common_XPaths(driver, test).Verify_Enter_Excess_Limit_Name(cmp.NameInputBox());
		
		Thread.sleep(500);
		//Enter the Storage Location Name
		cmp.EnterName(Utility.getProperty("Inventory_Storage_Locations"));
		
		Thread.sleep(1000);
		//Enter the Description
		new ServingSizeLevelsPage(driver, test).EnterDescription("Newly Added Storage Location is "+Utility.getProperty("Inventory_Storage_Locations"));
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Storage Location Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Storage Location Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Storage Location Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Storage Location Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Storage_Location(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		
		Thread.sleep(500);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_Storage_Locations"));
		
		//Check whether the application displays Update screen or not
				cmp.VerifyCreationScreenPageHeader("Update Storage Location");
				
		
		Thread.sleep(1000);
		//Click the Close button
		cmp.Click_CloseButton();
		
		Thread.sleep(1000);
		//Check whether the New Storage Location Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Editing Storage Location screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Editing Storage Location screen not Closed");
		}
		
		
		Thread.sleep(1000);
		//Search the Modifier Groups to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_Storage_Locations"));
		
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Storage Location");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Modifier Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Storage Location Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Storage Location not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Storage_Location(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		

		
		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_Storage_Locations"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName("");
		
		Thread.sleep(500);
		if(cmp.Update_Button().isEnabled())
		{
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Storage Location Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please enter Storage Location Name"))
		{
			test.log(LogStatus.PASS, "Please enter Storage Location Name Alert Displayed when Updating without Name");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Storage Location Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Storage Location Updated without Entering Name");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
//			//Click New Seving Size
//			air.Click_New_Storage_Location();
//			
//			Thread.sleep(500);
//			//Enter the Name
//			cmp.EnterName(Utility.getProperty("Inventory_Storage_Locations")+"1");
//			
//			Thread.sleep(500);
//			//Enter the Description
//			new ServingSizeLevelsPage(driver, test).EnterDescription("air name Updated as "+Utility.getProperty("Inventory_Storage_Locations")+"1");
//			
//			//Click the Save button
//			cmp.Click_SaveButton();
//			
			Thread.sleep(1000);
			//Search and Click Edit button
			cmp.SearchAndClickEdit(Utility.getProperty("Inventory_Storage_Locations"));
			
//			test.log(LogStatus.INFO, "Storage Location Recreated");
		
		}
		else
		{
			test.log(LogStatus.FAIL, "Please enter Storage Location Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.PASS, "Update button not Enabled without Entering Storage Location Name");
		}
		Thread.sleep(2000);
		
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Inventory_Storage_Locations")+"1");
		
		Thread.sleep(500);
		//Enter the Description
		new ServingSizeLevelsPage(driver, test).EnterDescription("Storage Location Updated as "+Utility.getProperty("Inventory_Storage_Locations")+"1");
				
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Storage Location Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Storage Location Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Storage Location Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Storage Location Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}


	}
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Storage_Location(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		Thread.sleep(500);
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Inventory_Storage_Locations")+"1");
		
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Storage Location Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Storage Location Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Storage Location not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		Thread.sleep(500);
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Inventory_Storage_Locations")+"1");
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Storage Location Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Storage Location Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Storage Location Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else 
		{
			test.log(LogStatus.FAIL, "Storage Location Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(2000);
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		Thread.sleep(1000);

		Thread.sleep(500);
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		Thread.sleep(3000);

		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("Inventory_Storage_Locations")+"1");
		
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
		
		Thread.sleep(1000);
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		try
		{
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Storage Location Activated Successfully"))
		{
			test.log(LogStatus.FAIL, "Storage Location Activated when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Storage Location not Activated when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("Inventory_Storage_Locations")+"1");
				
		
		Thread.sleep(500);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Storage Location Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Storage Location Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Storage Location activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Storage Location activated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(500);
		//Enable Active Status
		cmp.Click_InactivetoActiveButton();
				
		Thread.sleep(500);
		//Check whether verify whether the Active page opened or not
		cmp.VerifyActive_InactiveStatus("Active");
		
		Thread.sleep(1000);
		//Search the Storage Location to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_Storage_Locations")+"1");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
	}
	
	@Test(priority = 6,enabled = false)
	public void Create_Duplicate_Storage_Location(WebDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Storage Location button
		air.Click_New_Storage_Location();
		Thread.sleep(2000);
	
		Thread.sleep(500);
		//Enter the existing Storage Location name
		cmp.EnterName(Utility.getProperty("Inventory_Storage_Locations")+"1");
		
		Thread.sleep(1000);
		//Enter the Description
		new ServingSizeLevelsPage(driver, test).EnterDescription("Adding Duplicate of air as "+Utility.getProperty("Inventory_Storage_Locations")+"1");
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Storage Location Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Storage location name already exist"))
		{
			test.log(LogStatus.PASS, "Storage location name already exist pop up is displayed");
		
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
			test.log(LogStatus.FAIL, "Storage location name already exist pop up is not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_CancelButton();
		}
	}
	
	@Test(priority = 6,enabled = false)
	public void Verify_Added_Storage_Location_in_InvetoryItem_Integration(WebDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		test.log(LogStatus.INFO, "Navigating to Verify the Added Storage Location in Inventory Item Module - Integration");
		//Navigating to Inventory Item
		Thread.sleep(3000);
		//Load the Inventory SubRecipe page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"inventoryItem");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Inventory Item");	
		
		Thread.sleep(2000);
		//Click the New Inventory Item button
		air.Click_New_Inventory_Item();
		
		Thread.sleep(1000);
		//Verify whether the Purchase Order Creation screen openend or not
		cmp.VerifyCreationScreenPageHeader("New Inventory Item");
		
		String Expected_StorageName=Utility.getProperty("Inventory_Storage_Locations")+"1";
		//Click the Vendor Input Box
		cmp.Click_DropDown_withSearchText(air.Primary_StorageInputBox(), Expected_StorageName, "Added Storage Loaction Selected in Inventory Item");
		
		String StorageNameInvItem=air.Primary_StorageInputBox().getAttribute("value");
		
		if(Expected_StorageName.equalsIgnoreCase(StorageNameInvItem))
		{
			test.log(LogStatus.PASS, "Newly Added Storage Location is Displayed in Inventory Item");
		}
		else
		{
			test.log(LogStatus.FAIL, "Newly Added Storage Location is not Displayed in Inventory Item");
	
		}
		
		Thread.sleep(2000);
		//Click the Cancel button
		cmp.Click_BackspaceButton();
		

	}
	
	@Test(priority = 6,enabled = false)
	public void Verify_Added_Storage_Location_in_SubRecipe_Integration(WebDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Navigating to SubRecipe
		test.log(LogStatus.INFO, "Navigating to Verify the Added Storage Location in Sub-Recipe Module - Integration");

		Thread.sleep(3000);
		//Load the Inventory SubRecipe page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"subRecipe");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Sub Recipe");	
		
		Thread.sleep(2000);
		//Click the New Inventory Item button
		air.Click_New_SubRecipe();
		
		Thread.sleep(1000);
		//Verify whether the Purchase Order Creation screen openend or not
		cmp.VerifyCreationScreenPageHeader("New Sub Recipe");
		
		String Expected_StorageName=Utility.getProperty("Inventory_Storage_Locations")+"1";

		//Click the Vendor Input Box
		cmp.Click_DropDown_withSearchText(air.Primary_StorageInputBox(), Expected_StorageName, "Added Storage Loaction Selected in Sub-Recipe");
		
		String StorageNameSubReci=air.Primary_StorageInputBox().getAttribute("value");
		
		if(Expected_StorageName.equalsIgnoreCase(StorageNameSubReci))
		{
			test.log(LogStatus.PASS, "Newly Added Storage Location is Displayed in Sub-Recipe");
		}
		else
		{
			test.log(LogStatus.FAIL, "Newly Added Storage Location is not Displayed in Sub-Recipe");
	
		}
		
		Thread.sleep(2000);
		//Click the Cancel button
		cmp.Click_BackspaceButton();
		
		Thread.sleep(2000);
		//Load the Storage Locations page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"storageLocations");

		Thread.sleep(5000);
		//Verify the Storage Location page loaded or not
		cmp.VerifyMainScreenPageHeader("Storage Locations");
		Thread.sleep(2000);
	}
}
