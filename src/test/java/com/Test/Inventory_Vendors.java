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

import com.Pages.Common_XPaths;
import com.Pages.CoursingPage;
import com.Pages.InventoryPage;
import com.Pages.LoginPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Vendors {
public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Vendors");
	
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
		ChromeOptions chrOpt=new ChromeOptions();
		chrOpt.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver=(SelfHealingDriver) new ChromeDriver(chrOpt);
		
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
		Open_Vendor_Page(driver);
		RefreshAndPaginination_ColumnFilteration(driver);
		Add_New_Vendor(driver);
		Edit_and_Close_Cancel_Vendor(driver);
		Edit_and_Update_Vendor(driver);
		Delete_and_Active_Inactive_Vendor(driver);
		Create_DuplicateCourse(driver);
		Verify_Vendor_in_PurchaseOrder_Integration(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Vendor_Page(SelfHealingDriver driver) throws Exception
	{
		
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"vendors");

		Thread.sleep(5000);
		//Verify the Vendor page loaded or not
		cmp.VerifyMainScreenPageHeader("Vendors");	
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination_ColumnFilteration(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		//Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
		
		Thread.sleep(2000);
		//Verify Ascending order for name 
//		new CoursingPage(driver, test).Verify_AscendingNameSorting();
		Thread.sleep(2000);

		//Verify Decending
//		new CoursingPage(driver, test).Verify_DescendingNameSorting();
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_New_Vendor(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Vendor
		air.Click_New_Vendor();
		Thread.sleep(2000);
	
		//Verify the New Course creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Vendor");
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
			test.log(LogStatus.INFO, "Save button not Enabled without Entering Vendor Name");
		}
		
		cmp.Verify_Enter_Excess_Limit_Name(air.Name_VendorNameInputBox());
		
		Thread.sleep(500);
		//Enter the Course Name
		air.Enter_Vendor_Name(Utility.getProperty("Inventory_Vendor"));
		
		//Enter the Vendor Phone Number
				air.Enter_VendorPhone_Number("13543");
				
		try
		{
			if(cmp.Error_BelowInputBox().getText().equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"))
			{
				test.log(LogStatus.PASS, "Enter Valid Phone Number, Phone Number should be contain atleast 6 digits Error Alert is Displayed");
			}
		}
		catch(Exception k)
		{
			test.log(LogStatus.PASS, "Enter Valid Phone Number, Phone Number should be contain atleast 6 digits Error Alert is not Displayed");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(500);
		//Enter the Vendor Phone Number
		air.Enter_VendorPhone_Number("135434545");
		
		//Enter the Email
		air.Enter_Vendor_Email("test12@mail.com");
		
		//Enter the Contact Phone name & Phone number
		air.Enter_Vendor_ContactDetails("Jack Sparrow", "0011029777");
		
		//Enter the Address Line
		air.Enter_AddressDetails("32, Radha Nagar Main Road", "Chennai", "Tamilnadu", "600044");
		
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Contact number should contains at least 10 digits"))
		{
			test.log(LogStatus.PASS, "Contact number should contains at least 10 digits is Displayed");
		
		}
		else
		{
			test.log(LogStatus.FAIL, "Contact number should contains at least 10 digits is not Displayed");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(1000);
		//Enter the Vendor Phone Number
		air.Enter_VendorPhone_Number("1354345458");
	
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Vendor Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Vendor Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Vendor Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Vendor(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		Thread.sleep(500);
		//Search and Click Edit button
		air.SearchAndClickEdit(Utility.getProperty("Inventory_Vendor"));
		
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Vendor");
		
		
		Thread.sleep(1000);
		//Click the Close button
		cmp.Click_CloseButton();
		
		Thread.sleep(1000);
		//Check whether the New Course Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Editing Course screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Editing Course screen not Closed");
		}
		
		Thread.sleep(500);
		//Search and Click Edit button
		air.SearchAndClickEdit(Utility.getProperty("Inventory_Vendor"));
		
		
		Thread.sleep(1000);
		//Click the Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Course Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Vendor Screen Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Vendor Screen Cancelled");
		}
		
	}
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Vendor(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
	
		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		//cmp.SearchAndVerify_SearchBox();
		
		Thread.sleep(1000);
		//Search and Click Edit button
		air.SearchAndClickEdit(Utility.getProperty("Inventory_Vendor"));
		
		Thread.sleep(500);
		//Enter the Name
		air.Enter_Vendor_Name("");
		
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
			test.log(LogStatus.FAIL, "Vendor Updated without Vendor Name");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);

			Thread.sleep(1000);
			//Search and Click Edit button
			air.SearchAndClickEdit(Utility.getProperty("Inventory_Vendor"));
			
		}	
		else
		{
			test.log(LogStatus.INFO, "Please Enter Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.INFO, "Update button is not enabled without entering Vendor Name");
		}
		
		Thread.sleep(500);
		//Enter the Name
		air.Enter_Vendor_Name(Utility.getProperty("Inventory_Vendor")+"1");
	
		Thread.sleep(500);
		//Enter the Vendor Phone Number
		air.Enter_VendorPhone_Number("1354345458");
		
		//Enter the Email
		air.Enter_Vendor_Email("test12@mail.com");
		
		//Enter the Contact Phone name & Phone number
		air.Enter_Vendor_ContactDetails("Jack Sparrow", "0110297771");
		
		//Enter the Address Line
		air.Enter_AddressDetails("32, Radha Nagar Main Road", "Chennai", "Tamilnadu", "600044");

		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Vendor updated successfully"))
		{
			test.log(LogStatus.PASS, "Vendor updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Vendor Update Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Vendor(SelfHealingDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		//Search and Click Delete button
		air.SearchAndClickDelete(Utility.getProperty("Inventory_Vendor")+"1");
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to Delete!");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Vendor Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Vendor Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Vendor not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		
		//Search and Click Delete button
		air.SearchAndClickDelete(Utility.getProperty("Inventory_Vendor")+"1");
		
		//Click Delete button
		cmp.Click_DeleteButton_Message("Are you sure you want to Delete!");
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Vendor Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Vendor Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Vendor Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
				air.SearchAndClickActivate(Utility.getProperty("Inventory_Vendor")+"1");
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();

				try
				{
				Thread.sleep(3000);
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Vendor Activated Successfully"))
				{
					test.log(LogStatus.FAIL, "Vendor Activated when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Vendor not Activated when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}

		
		//Search and Activate the In activated item
		air.SearchAndClickActivate(Utility.getProperty("Inventory_Vendor")+"1");
		
		//Click Activate button
				cmp.Click_ActivateButton();
				
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Vendor Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Vendor activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Vendor activated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(500);
		//Enable Active Status
		cmp.Click_InactivetoActiveButton();
				
		Thread.sleep(500);
		//Check whether verify whether the Active page opened or not
		cmp.VerifyActive_InactiveStatus("Active");
		
		Thread.sleep(1000);
		//Search the Vendor to Click Edit and Cancel
		air.SearchAndClickEdit(Utility.getProperty("Inventory_Vendor")+"1");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
	}
	
	@Test(priority = 6,enabled = false)
	public void Create_DuplicateCourse(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Vendor button
		air.Click_New_Vendor();
		Thread.sleep(2000);
	
		Thread.sleep(500);
		//Enter the existing Course name
		air.Enter_Vendor_Name(Utility.getProperty("Inventory_Vendor")+"1");
		
		Thread.sleep(500);
		//Enter the Vendor Phone Number
		air.Enter_VendorPhone_Number("1354345758");
		
		//Enter the Email
		air.Enter_Vendor_Email("test123@mail.com");
		
		//Enter the Contact Phone name & Phone number
		air.Enter_Vendor_ContactDetails("Jack Sparrow", "011029778");
		
		//Enter the Address Line
		air.Enter_AddressDetails("32, Radha Nagar Main Road", "Chennai", "Tamilnadu", "600044");
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Vendor name already exist"))
		{
			test.log(LogStatus.PASS, "Vendor name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(500);
			cmp.Click_CancelButton();
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error(s)"))
		{
			test.log(LogStatus.PASS, "Validation Error(s) pop up displayed");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(500);
			cmp.Click_CancelButton();
		}
		else
		{
			test.log(LogStatus.FAIL, "Vendor name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Verify_Vendor_in_PurchaseOrder_Integration(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
	//Load the Department page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"purchases/purchaseOrders");

			Thread.sleep(5000);
			//Verify the Coursing page loaded or not
//			cmp.VerifyMainScreenPageHeader("Purchase Orders");	
			Thread.sleep(5000);
			//Verify the Front End Receipt Template page loaded or not
			if(air.Purchase_OrderHeader().isDisplayed())
			{
				test.log(LogStatus.PASS, "Inventory - Purchase Order Page Loaded Successfully");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Inventory - Purchase Order Page Loading Failed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(2000);
			//Click the New Purchase Order button
			air.Click_New_Purchase_Order();
			
			Thread.sleep(1000);
			//Verify whether the Purchase Order Creation screen openend or not
			cmp.VerifyCreationScreenPageHeader("New Purchase Order");
			
			String Expected_VendorName=Utility.getProperty("Inventory_Vendor")+"1";
			//Click the Vendor Input Box
			cmp.Click_DropDown_withSearchText(air.Vendor_InputBox(), Expected_VendorName, "Added Vendor Selected");
			
			String VendorName=air.Vendor_InputBox().getAttribute("value");
			
			if(Expected_VendorName.equalsIgnoreCase(VendorName))
			{
				test.log(LogStatus.PASS, "Newly Added Vendor is Displayed in Purchase Order");
			}
			else
			{
				test.log(LogStatus.FAIL, "Newly Added Vendor is not Displayed in Purchase Order");
		
			}
			
			Thread.sleep(2000);
			//Click the Cancel button
			cmp.Click_BackspaceButton();
			
			Thread.sleep(3000);
			//Load the Department page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"vendors");

			Thread.sleep(5000);
			//Verify the Vendor page loaded or not
			cmp.VerifyMainScreenPageHeader("Vendors");
			Thread.sleep(2000);
	}
}
