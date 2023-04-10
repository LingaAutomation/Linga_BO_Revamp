package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.testng.Assert.expectThrows;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.Availability_RestrictionTimePage;
import com.Pages.Common_XPaths;
import com.Pages.DisplayGroupsPage;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_DisplayGroups {
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete Display Groups");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	Availability_RestrictionTimePage at;
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	DisplayGroupsPage dgp;
	
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
		Open_DisplayGroups_Page(driver);
//		RefreshAndPaginination(driver);
//		Add_DisplayGroups(driver);
//		Edit_and_Close_Cancel_DisplayGroups(driver);
		Edit_and_Update_DisplayGroups_DaysOfWeek(driver);
		Edit_and_Update_DisplayGroups_DaysOfMonth_AtoZ_Sorting(driver);
		Edit_and_Update_DisplayGroups_DateRange_ZtoA_Sorting(driver);
		Edit_and_Update_DisplayGroups_Specific_Date_Custom_Sorting(driver);
		Edit_Delete_MenuItems_and_Update_DisplayGroups_DateRangeWithTime(driver);
		Delete_and_Active_Inactive_DisplayGroups(driver);
		Create_DuplicateDisplayGroup(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_DisplayGroups_Page(WebDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		dgp=new DisplayGroupsPage(driver, test);
		Thread.sleep(5000);
		//Load the Display Group page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"displayGroup");

		Thread.sleep(5000);
		//Verify the Display Groups page loaSded or not
		cmp.VerifyMainScreenPageHeader("Display Groups");	
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_DisplayGroups(WebDriver driver) throws Exception
	{
		dgp=new DisplayGroupsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		Thread.sleep(2000);
		//Click the New Display Groups
		dgp.Click_NewDisplayGroup();
		Thread.sleep(5000);
	
		//Verify the New Display Group creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Display Group");
		Thread.sleep(2000);
		
		//Upload picture
		cmp.Upload_Picture(Utility.getProperty("DisplayGroupImage"));
		
		Thread.sleep(1000);
		//Enter the Display Group Name
		cmp.EnterName(Utility.getProperty("DisplayGroupName"));
		try
		{
		//Select Menu Item
		Thread.sleep(2000);
		for(int i=1;i<=2;i++)
		{
			Thread.sleep(2000);
			dgp.Select_MenuItemsDisplayGroup();
		}
		}
		catch(Exception g)
		{
			
		}
//		dgp.Select_MenuItemsDisplayGroup();	
		
		Thread.sleep(1000);
		//Select Always
		at.Click_AlwaysButton();
				
		Thread.sleep(2000);
		//Click the Save and Publish button
		cmp.Click_Save_and_PublishButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Display Group Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Display Group Saved Successfully"))
		{
			test.log(LogStatus.PASS, "New Display Group Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_DisplayGroups(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dgp=new DisplayGroupsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);


		Thread.sleep(30000);
		//Search the Display Groups to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("DisplayGroupName"));
		
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Display Group");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_BackspaceButton();
		
		Thread.sleep(1000);
		//Check whether the New Display Group Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Display Group Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Display Group not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_DisplayGroups_DaysOfWeek(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dgp=new DisplayGroupsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(2000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBoxTwo();
	
		Thread.sleep(3000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("DisplayGroupName"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("DisplayGroupName")+"1");
		
		Thread.sleep(500);
		//Select Menu Item
		dgp.Select_MenuItemsDisplayGroup();	

		//Select Days of Week
		at.Select_DaysOfWeek();
		
		
		
		Thread.sleep(1000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(10000);
		
		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(300));
		//Check whether the New Display Group Updated or not
		if(wt.until(ExpectedConditions.visibilityOf(cmp.ConfirmationAlertMsg())).getText().equalsIgnoreCase("Display Group Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Display Group updated successfully for Days of Week");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group updated fail for Days of Week");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_DisplayGroups_DaysOfMonth_AtoZ_Sorting(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dgp=new DisplayGroupsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);

	
		
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("DisplayGroupName")+"1");
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("DisplayGroupName"));
		
		//Select Menu Item
		dgp.Select_MenuItemsDisplayGroup();

		//Sorting A-Z
		dgp.Select_AtoZSorting();
		
		
		//Select Days of Week
		at.Select_DaysOfMonth();
		
		
		Thread.sleep(500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Display Group Updated or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Display Group Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Display Group updated successfully for Days of Month");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group updated fail for Days of Month");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_DisplayGroups_DateRange_ZtoA_Sorting(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dgp=new DisplayGroupsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);

	
		
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("DisplayGroupName"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("DisplayGroupName"));
		
		//Select Menu Item
		dgp.Select_MenuItemsDisplayGroup();


		//Sorting Z-A
		dgp.Select_ZtoASorting();
		
		
		//Select Days of Week
		at.Select_DateRange();
		
		Thread.sleep(500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Display Group Updated or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Display Group Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Display Group updated successfully for Date Range");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group updated fail for Date Range");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_DisplayGroups_Specific_Date_Custom_Sorting(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dgp=new DisplayGroupsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);

	
		
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("DisplayGroupName"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("DisplayGroupName"));
	
		Thread.sleep(500);
		//Select Menu Items
		dgp.Select_MenuItemsDisplayGroup();

		//Sorting Custom
		dgp.Select_CustomSorting();
		
		//Select Days of Week
		at.Select_SpecificDate();
		
		Thread.sleep(500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Display Group Updated or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Display Group Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Display Group updated successfully for Specific Date");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group updated fail for Specific Date");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_Delete_MenuItems_and_Update_DisplayGroups_DateRangeWithTime(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dgp=new DisplayGroupsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);

	
		
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("DisplayGroupName"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("DisplayGroupName"));

		//Delete the Menu Items from menu items
		dgp.Delete_MenuItems();
		
		
		//Select Days of Week
		at.Select_DateRangeWithTime();
		
		Thread.sleep(500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Display Group Updated or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Display Group Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Display Group updated successfully for Date Range with Time");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Display Group updated fail for Date Range with Time");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}

//	@Test(priority = 5,enabled = false)
//	public void Sorting_and_DeleteMenuItems(WebDriver driver) throws Exception
//	{
//		Thread.sleep(500);
//		cmp=new Common_XPaths(driver, test);
//		dgp=new DisplayGroupsPage(driver, test);
//		
//		Thread.sleep(1000);
//		//Search and Click Edit button
//		cmp.SearchAndClickEdit(Utility.getProperty("DisplayGroupName"));
//	
//		
//		//Sorting A-Z
//		dgp.Select_AtoZSorting();
//		
//		//Sorting Z-A
//		dgp.Select_ZotASorting();
//		
//		//Sorting Custom
//		dgp.Select_CustomSorting();
//		
//		
//		//Delete the Menu Items from menu items
//		dgp.Delete_MenuItems();
//				
//		Thread.sleep(500);
//		//Click the Update and Publish button
//		cmp.Click_Update_and_PublishButton();
//		
//		Thread.sleep(3000);
//		//Check whether the New Display Group Saved or not
//		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Display Group Updated Successfully"))
//		{
//			test.log(LogStatus.PASS, "Sorting in Display Group updated successfully");
//		
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Sorting in Display Group updated fail");
//			
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
//		
//	}
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_DisplayGroups(WebDriver driver) throws Exception
	{
		
		
		cmp=new Common_XPaths(driver, test);
		dgp=new DisplayGroupsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		
		
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("DisplayGroupName"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Display Group Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Display Group Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Display Group not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		

		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("DisplayGroupName"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Display Group Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Display Group Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Display Group Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Display Group Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("DisplayGroupName"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		try
		{
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Display Group Activated Successfully"))
		{
			test.log(LogStatus.FAIL, "Display Group Activated when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Display Group not Activated when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}



		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("DisplayGroupName"));
		
		Thread.sleep(500);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Display Group Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Display Group Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Display Group activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Display Group activated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(500);
		//Enable Active Status
		cmp.Click_InactivetoActiveButton();
				
		Thread.sleep(500);
		//Check whether verify whether the Active page opened or not
		cmp.VerifyActive_InactiveStatus("Active");
		
	
		
	}
	
	@Test(priority = 6,enabled = false)
	public void Create_DuplicateDisplayGroup(WebDriver driver) throws Exception
	{
		dgp=new DisplayGroupsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(2000);
		//Click the New Display Group button
		dgp.Click_NewDisplayGroup();
		Thread.sleep(2000);
	
		//Verify the New Display Group creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Display Group");
		Thread.sleep(2000);
				
		//Upload picture
		cmp.Upload_Picture(Utility.getProperty("DisplayGroupImage"));
		
		Thread.sleep(500);
		//Enter the existing Display Group name
		cmp.EnterName(Utility.getProperty("DisplayGroupName"));
		
		//Select Menu Item
		dgp.Select_MenuItemsDisplayGroup();
	
		Thread.sleep(2000);
		//Click the Save and Publish button
		cmp.Click_Save_and_PublishButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Display Group Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
}
