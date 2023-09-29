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
import com.Pages.DepartmentPage;
import com.Pages.Enterprise_CentralIventoryPage;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.Pages.Settings_StoreInformation_Page;
import com.Pages.UserManagementPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
public class Enterprise_Add_Edit_Central_Warehouse
{
	
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise Central Inventory - Central Warehouse");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Enterprise_CentralIventoryPage civ;
	
//	ChromeOptions chrOpt=new ChromeOptions();
	
	
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
	
			//Load the Central Warehouse page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"Central Warehouses");

		}
	}
	
	
	@Test(priority = 1,enabled = true)
	public void Login() throws Exception
	{
		
		
		Thread.sleep(2000);
//		//Call the chrome driver
		ChromeOptions chrOpt=new ChromeOptions();
		chrOpt.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(chrOpt);
		
//		System.setProperty("webdriver.chrome.driver","./Automation Driver/chromedriver.exe");
////		//Open the Chrome window
//		driver = new ChromeDriver();
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
	
	@Test(priority = 50,enabled = true)
	public void LogOut() throws Exception
	{
//		LogOutTest a=new LogOutTest();
		a.LogOut(driver, test);
	}
	
	
	@Test(priority=2)
	public void Calling() throws Exception
	{
		Open_Central_Warehouse_Page(driver);
		RefreshAndPaginination(driver);
		Add_Central_Warehouse(driver);
		Edit_and_Close_Cancel_Central_Warehouse(driver);
		Edit_and_Update_Central_Warehouse(driver);
		Delete_and_Active_Inactive_Central_Warehouse(driver);
		Create_Duplicate_Central_Warehouse(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Central_Warehouse_Page(WebDriver driver) throws Exception
	{
//		((JavascriptExecutor) driver).executeScript("window.focus();");
		civ=new Enterprise_CentralIventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Central Warehouse page
//		a.Navigate_To_Page(Utility.getProperty("store_Id1"), "Central Warehouses");
		driver.get(Utility.getProperty("baseURL")+"enterprise/centralInventory/centralWarehouse");
		
		Thread.sleep(5000);
		//Verify the Central Warehouses page loaded or not
		cmp.VerifyMainScreenPageHeader("Central Warehouse");
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
	public void Add_Central_Warehouse(WebDriver driver) throws Exception
	{
		civ=new Enterprise_CentralIventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Central Warehouses
		civ.Click_Add_Central_Warehouse();
		Thread.sleep(2000);
	
		//Verify the New Central Warehouse creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Central Warehouse");
		Thread.sleep(2000);
	
		if(cmp.Save_Button().isEnabled())
		{
			//Click the Save button
			cmp.Click_SaveButton();
		
			Thread.sleep(3000);
			//Check whether the New Central Warehouse Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Central Warehouse Name"))
			{
				test.log(LogStatus.PASS, "Please Enter Central Warehouse Name Alert Displayed");
		
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Please Enter Central Warehouse Name Alert not Displayed");
			
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		else
		{
			test.log(LogStatus.PASS, "Save button not Enabled without Entering Central Warehouse Name");
		}
	
		String NameExcess = "Entering Invalid Name to input"; 
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
		//Enter the Central Warehouse Name
		cmp.EnterName(Utility.getProperty("New_Central_WareHouse"));
		
		//Enter the Description
		new DepartmentPage(driver, test).Enter_Description("This Central Inventory is : "+Utility.getProperty("New_Central_WareHouse"));
		
		//Enter the Email ID
		new UserManagementPage(driver, test).Enter_EmailID(Utility.getProperty("Central_emailId"));
		
		//Enter the Apartments and street
		new Settings_StoreInformation_Page(driver, test).Enter_Apartment(Utility.getProperty("Settings_Store_Information_Address1"));
		
		//Enter the Phone number
		new Settings_StoreInformation_Page(driver, test).Enter_Phone_Number(Utility.getProperty("Central_phoneNumber"));
		
		//Enter the City
		new Settings_StoreInformation_Page(driver, test).Enter_City(Utility.getProperty("Settings_Store_Information_City"));
		
		//Enter State 
		new Settings_StoreInformation_Page(driver, test).Enter_State(Utility.getProperty("Settings_Store_Information_State"));
		
		//Enter the Zip code
		new Settings_StoreInformation_Page(driver, test).Enter_ZipCode(Utility.getProperty("Settings_Store_Information_Zipcode"));
		
		//Verify whether the Save button Enabled or not without selecting Time Zone 
		if(cmp.Save_Button().isEnabled())
		{
			//Click the Save button
			cmp.Click_SaveButton();
		
			Thread.sleep(3000);
			//Check whether the New Central Warehouse Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Select Time Zone"))
			{
				test.log(LogStatus.PASS, "Please Select Time Zone Alert Displayed");
		
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Please Select Time Zone Alert not Displayed");
			
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		else
		{
			test.log(LogStatus.PASS, "Save button not Enabled without Selecting Time Zone");
		}
	
		//Select Time Zone
		new Settings_StoreInformation_Page(driver, test).Select_TimeZone("Chennai");
		
		
		//Enable the Copy from Existing store
				civ.Enable_Copy_Menu_ExistingStore_Toggle();
				
				
				Thread.sleep(1000);
				if(cmp.Save_Button().isEnabled())
				{
					Thread.sleep(500);
					//Click the Update button
					cmp.Click_UpdateButton();
					
					Thread.sleep(3000);
					//Check whether the New Central Warehouse Saved or not
					if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Warehouse Updated Successfully"))
					{
						test.log(LogStatus.FAIL, "Save button is Enabled without Selecting Store");
					
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				
				}
				else
				{
					test.log(LogStatus.PASS, "Save button is not Enabled without Selecting Store");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				
		Thread.sleep(1000);	
		//Disable Copy from Existing store
		civ.Disable_Copy_Menu_ExistingStore_Toggle();
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Central Warehouse Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Warehouse Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Central Warehouse Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Central Warehouse Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 6,enabled = false)
	public void Edit_and_Close_Cancel_Central_Warehouse(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		civ=new Enterprise_CentralIventoryPage(driver, test);
		
		Thread.sleep(500);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("New_Central_WareHouse"));
		
		//Check whether the application displays Update screen or not
		cmp.VerifyCreationScreenPageHeader("Update Central Warehouse");
				
		
		Thread.sleep(1000);
		//Click the Close button
		cmp.Click_CloseButton();
		
		Thread.sleep(1000);
		//Check whether the New Central Warehouse Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Editing Central Warehouse screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Editing Central Warehouse screen not Closed");
		}
		
		
		Thread.sleep(1000);
		//Search the Central Warehouses to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("New_Central_WareHouse"));
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Central Warehouse Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Central Warehouse screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Central Warehouse screen not Closed");
		}
		
	}
	
	@Test(priority = 7,enabled = false)
	public void Edit_and_Update_Central_Warehouse(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		civ=new Enterprise_CentralIventoryPage(driver, test);
		
		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
	
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("New_Central_WareHouse"));
		
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName("");
	
		Thread.sleep(1000);
		if(cmp.Update_Button().isEnabled())
		{
			Thread.sleep(500);
			//Click the Update button
			cmp.Click_UpdateButton();
			
			Thread.sleep(3000);
			//Check whether the New Central Warehouse Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Warehouse Updated Successfully"))
			{
				test.log(LogStatus.FAIL, "Central Warehouse Updated without Central Warehouse Name");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		
		}
		else
		{
			test.log(LogStatus.PASS, "Central Warehouse not Updated without Central Warehouse Name");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("New_Central_WareHouse"));
		
		
		//Enable the Copy from Existing store
		civ.Enable_Copy_Menu_ExistingStore_Toggle();
		
		
		Thread.sleep(1000);
		if(cmp.Update_Button().isEnabled())
		{
			Thread.sleep(500);
			//Click the Update button
			cmp.Click_UpdateButton();
			
			Thread.sleep(3000);
			//Check whether the New Central Warehouse Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Warehouse Updated Successfully"))
			{
				test.log(LogStatus.FAIL, "Update button is Enabled without Selecting Store");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		
		}
		else
		{
			test.log(LogStatus.PASS, "Update button is not Enabled without Selecting Store");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Select the Store
		civ.Select_Store();
	
		
		Thread.sleep(1000);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Central Warehouse Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Warehouse Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Central Warehouse Updated Successfully Enabled with Copy from Existing Store");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Central Warehouse Updated Failed Enabled with Copy from Existing Store");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 8,enabled = false)
	public void Delete_and_Active_Inactive_Central_Warehouse(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		civ=new Enterprise_CentralIventoryPage(driver, test);
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("New_Central_WareHouse")+"1");
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Warehouse Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Central Warehouse Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Central Warehouse not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("New_Central_WareHouse")+"1");
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Central Warehouse Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Warehouse Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Central Warehouse Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Central Warehouse Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("New_Central_WareHouse")+"1");
				
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
				
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		try
		{
			Thread.sleep(3000);
			//Check whether the New Modifier Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Warehouse Activated Successfully"))
			{
				test.log(LogStatus.FAIL, "Central Warehouse Activated when clicking Cancel button");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception g)
		{
				test.log(LogStatus.PASS, "Central Warehouse not Activated when Clicking Cancel button");
					
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
			
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("New_Central_WareHouse")+"1");
		
		Thread.sleep(500);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Central Warehouse Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Warehouse Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Central Warehouse Activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Central Warehouse Activated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Enable Active Status
		cmp.Click_InactivetoActiveButton();
		
		Thread.sleep(1000);
		//Check whether verify whether the Active page opened or not
		cmp.VerifyActive_InactiveStatus("Active");
	
	}
	
	@Test(priority = 9,enabled = false)
	public void Create_Duplicate_Central_Warehouse(WebDriver driver) throws Exception
	{
		civ=new Enterprise_CentralIventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Central Warehouses button
		civ.Click_Add_Central_Warehouse();
		Thread.sleep(2000);
	
		Thread.sleep(500);
		//Enter the existing Central Warehouse name
		cmp.EnterName(Utility.getProperty("New_Central_WareHouse")+"1");
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Central Warehouse Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Central Warehouse Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_CancelButton();
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error(s)"))
		{
			test.log(LogStatus.PASS, "Validation Error(s) pop up displayed");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_CancelButton();
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Warehouse Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Duplicate Central Warehouse Saved");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Central Warehouse Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
}
