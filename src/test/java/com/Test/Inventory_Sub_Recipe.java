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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Sub_Recipe 
{
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Sub Recipe");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	InventoryPage air;
	BasePage bp=new BasePage();
	
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
		Open_Sub_Recipe_Page(driver);
//		RefreshAndPaginination_ColumnFilteration(driver);
		Add_Sub_Recipe_By_Inventory_Item(driver);
		Edit_and_Close_Cancel_Sub_Recipe(driver);
		Edit_and_Update_Sub_Recipe_by_Adding_SubRecipe(driver);
		Edit_and_Update_Sub_Recipe_by_Adding_Manual_Entry(driver);
		Edit_and_Update_Sub_Recipe_by_Adding_Inventory_and_SubRecipe(driver);
		Edit_and_Update_Sub_Recipe_by_Adding_Inventory_and_Manual_Entry(driver);
		Edit_and_Update_Sub_Recipe_by_Adding_SubRecipe_and_Manual_Entry(driver);
		Edit_and_Update_Sub_Recipe_by_Adding_InventoryItem_SubRecipe_and_Manual_Entry(driver);
		Delete_and_Active_Inactive_Sub_Recipe(driver);
		Create_Duplicate_Sub_Recipe(driver);
		Verify_Integration_Inv_SubRecipe_In_Adjust_Inventory_and_Adjust_Inventory_Report(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Sub_Recipe_Page(WebDriver driver) throws Exception
	{
		
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"subRecipe");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Sub Recipe");	
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination_ColumnFilteration(WebDriver driver) throws Exception
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
	public void Add_Sub_Recipe_By_Inventory_Item(WebDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Coursing
		air.Click_New_SubRecipe();
		Thread.sleep(2000);
	
		//Verify the New Course creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Sub Recipe");
		Thread.sleep(2000);
		
		if(cmp.Save_ButtonTwo().isEnabled())
		{
		//Click the Save button
		cmp.Click_Save_ButtonTwo();
		
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
			test.log(LogStatus.INFO, "Save button not Enabled without Entering Sub Recipe Name");
		}
		
		//Verify whether the Entering Name character limits in Input
		cmp.Verify_Enter_Excess_Limit_Name(cmp.NameInputBox());
		
		
		
		
		Thread.sleep(500);
		//Enter the Course Name
		cmp.EnterName(Utility.getProperty("Inventory_SubRecipe_Name"));
		
		if(cmp.Save_ButtonTwo().isEnabled())
		{
		//Click the Save button
		cmp.Click_Save_ButtonTwo();
		
		Thread.sleep(3000);
		test.log(LogStatus.FAIL, "Save button Enabled without Selecting Inventory Item");
		}
		else
		{
			test.log(LogStatus.PASS, "Save button not Enabled without Selecting Inventory Item");
		}
		
		//Select the Inventory Item
		air.Select_Inventory_Item();
		
		//Enable Calculate COGS on Cost Price
		air.Calculate_COGS_onCost_Price_YesToggle().click();
		
		//Enter Preparation Notes
		air.Enter_Preparation_Notes("Preparing SubRecipe is "+ut.getProperty("Inventory_SubRecipe_Name"));
		
		//Enter the Quantity
		air.Enter_Quantity("100");
		
		if(cmp.Save_ButtonTwo().isEnabled())
		{
		//Click the Save button
		cmp.Click_Save_ButtonTwo();
		
		Thread.sleep(3000);
		test.log(LogStatus.FAIL, "Save button Enabled without Entering Quanity");
		}
		else
		{
			test.log(LogStatus.PASS, "Save button not Enabled without Entering Quantity");
		}
		
		//Enter the Yield %
		air.Enter_Yield_Percentage("105.00");
		
		//Verify the Enter Yield Should Not Be Greater Than 100 Warning Pop up displayed or not
		air.Verify_Yield_Warning_Above_100Percentage();
		
		//Enter the Yield %
		air.Enter_Yield_Percentage("50.00");
				
		//Enter the Price Per Unit
		air.Enter_Price_Per_Unit("10");
		
		//Create the New Storage
//		air.Create_New_Storage(ut.getProperty("Inventory_SubRecipe_Primary_Storage_Name"), "Primary Storage Saved");
		air.Select_Primary_Storage();
		
		//Add the Recipe Units
		air.Add_Receipe_Units("10");
		
		//Add the Inventory Item
		air.Click_Add_InventoryItem();
		
		if(cmp.Save_ButtonTwo().isEnabled())
		{
		//Click the Save button
		cmp.Click_Save_ButtonTwo();
		
		Thread.sleep(3000);
		test.log(LogStatus.FAIL, "Save button Enabled without Selecting Inventory/SubRecipes/Manual Entry Items");
		}
		else
		{
			test.log(LogStatus.PASS, "Save button not Enabled without Selecting Inventory/SubRecipes/Manual Entry Items");
		}
		
		//Select and Add the Inventory Items
		air.Add_Inventory_Items_inSubRecipe("10");
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_Save_ButtonTwo();
		
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub Recipe saved successfully!."))
		{
			test.log(LogStatus.PASS, "Sub Recipe Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Recipe Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Sub_Recipe(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		Thread.sleep(500);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_SubRecipe_Name"));
		
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Sub Recipe");
		
		
		Thread.sleep(1000);
		//Click the Close button
		cmp.Click_CloseButton();
		
		Thread.sleep(1000);
		//Check whether the New Course Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Update Sub Recipe screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Update Sub Recipe screen not Closed");
		}
		
		Thread.sleep(500);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_SubRecipe_Name"));
		
		
		Thread.sleep(1000);
		//Click the Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Course Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Sub Recipe Screen Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Recipe Reason Screen Cancelled");
		}
		
	}
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Sub_Recipe_by_Adding_SubRecipe(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
	
		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_SubRecipe_Name"));
		
		//Check whether the Default Reason Type is Enabled or not
		if(air.Calculate_COGS_onCost_Price_YesToggle().isEnabled())
		{
			test.log(LogStatus.PASS, "Calculate COGS on Cost Price Toggle is Enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Calculate COGS on Cost Price Toggle is not Enabled");
		}
		
		
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName("");
		
		if(cmp.Update_Button().isEnabled())
		{
		//Click the Save button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Name"))
		{
			test.log(LogStatus.PASS, "Please Enter Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Course Updated Successfully"))
		{
			test.log(LogStatus.FAIL, "Sub Recipe Updated without Name");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);

			Thread.sleep(1000);
			//Search and Click Edit button
			cmp.SearchAndClickEdit(Utility.getProperty("Inventory_SubRecipe_Name"));
			
		}	
		else
		{
			test.log(LogStatus.INFO, "Please Enter Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.INFO, "Update button is not enabled without entering Sub Recipe Name");
		}
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Inventory_SubRecipe_Name")+"1");
	
		//Disable COGS
		air.Calculate_COGS_onCost_Price_NoToggle().click();
		
		
		//Yield Percentage
		air.Enter_Yield_Percentage("100.00");
		
		//Select the Recipe Units
		air.Add_Receipe_Units("50");
		
		//Delete the Inventory Items
		air.Delete_Inventory_Items_inSubRecipe(1);
		
		//Click the Add Sub Recipe
		air.Click_Add_SubRecipe();
		
		//Select the Sub Recipe
		air.Add_SubRecipes_inSubRecipe("40");
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub Recipe Updated successfully!."))
		{
			test.log(LogStatus.PASS, "Sub Recipe Updated Successfully with Sub-Recipe");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Recipe Updated Failed for Reason with Sub-Recipe");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Sub_Recipe_by_Adding_Manual_Entry(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
	
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_SubRecipe_Name")+"1");
		
		//Check whether the Default Reason Type is Disabled or not
		if(air.Calculate_COGS_onCost_Price_NoToggle().isEnabled())
		{
			test.log(LogStatus.PASS, "Calculate COGS on Cost Price Toggle is Disabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Calculate COGS on Cost Price Toggle is not Disabled");
		}

		
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Inventory_SubRecipe_Name"));
		
		//Change the Price Per unit
		air.Enter_Price_Per_Unit("55.00");
		
		//Delete the Sub Recipe
		air.Delete_Sub_Recipes_inSubRecipe(1);
		
		//Click the Add Manual Entry
		air.Click_Add_ManualEntry();
		
		//Select and Enter the Manual Entry values
		air.Add_Manual_Entry_inSubRecipe("Oil", "10", "30");
		
				
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub Recipe Updated successfully!."))
		{
			test.log(LogStatus.PASS, "Sub Recipe Updated Successfully with Manual Entry");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Recipe Updated Failed with Manual Entry");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Sub_Recipe_by_Adding_Inventory_and_SubRecipe(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
	
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_SubRecipe_Name"));
		
		//Check whether the Default Reason Type is Disabled or not
		if(air.Calculate_COGS_onCost_Price_NoToggle().isEnabled())
		{
			test.log(LogStatus.PASS, "Calculate COGS on Cost Price Toggle is Disabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Calculate COGS on Cost Price Toggle is not Disabled");
		}

		
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Inventory_SubRecipe_Name"));
		
		//Change the Price Per unit
		air.Enter_Price_Per_Unit("60.00");
		
		//Delete the Manual Entry
		air.Delete_Manual_Entry_inSubRecipe(1);
		
		//Click the Add Inventory Item
		air.Click_Add_InventoryItem();
		
		//Select the Inventory Item
		air.Add_Inventory_Items_inSubRecipe("10");
		
		//Click the Add Sub-Recipe
		air.Click_Add_SubRecipe();
		
		//Select the Add Sub-Recipes
		air.Add_SubRecipes_inSubRecipe("15");
		
				
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub Recipe Updated successfully!."))
		{
			test.log(LogStatus.PASS, "Sub Recipe Updated Successfully with Inventory Item and Sub-Recipe");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Recipe Updated Failed with Inventory Item and Sub-Recipe");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Sub_Recipe_by_Adding_Inventory_and_Manual_Entry(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
	
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_SubRecipe_Name"));
		

		
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Inventory_SubRecipe_Name"));
		
		//Change the Price Per unit
		air.Enter_Price_Per_Unit("60.00");
		
		//Delete the Sub Recipe
		air.Delete_Sub_Recipes_inSubRecipe(1);
		
		//Click the Add Inventory Item
		air.Click_Add_InventoryItem();
		
		//Select the Inventory Item
		air.Add_Inventory_Items_inSubRecipe("10");
		
		//Click the Add Manual Entry
		air.Click_Add_ManualEntry();
		
		//Select and Enter the Manual Entry values
		air.Add_Manual_Entry_inSubRecipe("Oil", "20.00", "35");
			
				
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub Recipe Updated successfully!."))
		{
			test.log(LogStatus.PASS, "Sub Recipe Updated Successfully with Inventory Item and Manual Entry");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Recipe Updated Failed with Inventory Item and Manual Entry");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Sub_Recipe_by_Adding_SubRecipe_and_Manual_Entry(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
	
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_SubRecipe_Name"));
	
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Inventory_SubRecipe_Name"));
		
		//Change the Price Per unit
		air.Enter_Price_Per_Unit("60.00");
		
		//Delete the Inventory Item
		air.Delete_Inventory_Items_inSubRecipe(1);
		
		//Click the Add Sub Recipe
		air.Click_Add_SubRecipe();
		
		//Select the Inventory Item
		air.Add_SubRecipes_inSubRecipe("20");
		
		//Click the Add Manual Entry
		air.Click_Add_ManualEntry();
		
		//Select and Enter the Manual Entry values
		air.Add_Manual_Entry_inSubRecipe("Oil", "20.00", "38");
			
				
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub Recipe Updated successfully!."))
		{
			test.log(LogStatus.PASS, "Sub Recipe Updated Successfully with Adding Sub-Recipe and Manual Entry");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Recipe Updated Failed with Adding Sub-Recipe and Manual Entry");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}
	
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Sub_Recipe_by_Adding_InventoryItem_SubRecipe_and_Manual_Entry(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
	
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_SubRecipe_Name"));
	
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Inventory_SubRecipe_Name"));
		
		//Change the Price Per unit
		air.Enter_Price_Per_Unit("65.00");
		
		//Delete the Sub Recipe
		air.Delete_Sub_Recipes_inSubRecipe(1);
		
		//Delete the Manual Entry
		air.Delete_Manual_Entry_inSubRecipe(1);
		
		//Click the Add Inventory Item
		air.Click_Add_InventoryItem();
				
		//Select the Inventory Item
		air.Add_Inventory_Items_inSubRecipe("45");
				
		//Click the Add Sub Recipe
		air.Click_Add_SubRecipe();
		
		//Select the Inventory Item
		air.Add_SubRecipes_inSubRecipe("25");
		
		//Click the Add Manual Entry
		air.Click_Add_ManualEntry();
		
		//Select and Enter the Manual Entry values
		air.Add_Manual_Entry_inSubRecipe("Palm Oil", "30.00", "40");
			
				
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub Recipe Updated successfully!."))
		{
			test.log(LogStatus.PASS, "Sub Recipe Updated Successfully with Adding Inventory Item, Sub-Recipe and Manual Entry");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Recipe Updated Failed with Adding Inventory Item, Sub-Recipe and Manual Entry");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}
	
	
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Sub_Recipe(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Inventory_SubRecipe_Name"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub Recipe Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Sub Recipe Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Sub Recipe not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Inventory_SubRecipe_Name"));
		
		//Click Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub Recipe Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Sub Recipe Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Recipe Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("Inventory_SubRecipe_Name"));
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();

				try
				{
				Thread.sleep(3000);
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub Recipe Activated Successfully"))
				{
					test.log(LogStatus.FAIL, "Sub Recipe Activated when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Sub Recipe not Activated when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}

		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("Inventory_SubRecipe_Name"));
		
		//Click Activate button
				cmp.Click_ActivateButton();
				
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub Recipe Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Sub Recipe activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Recipe activated Failed");
			
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
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_SubRecipe_Name"));
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
	}
	
	@Test(priority = 6,enabled = false)
	public void Create_Duplicate_Sub_Recipe(WebDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Sub Recipe
		air.Click_New_SubRecipe();
		Thread.sleep(2000);
	
		Thread.sleep(500);
		//Enter the existing Course name
		cmp.EnterName(Utility.getProperty("Inventory_SubRecipe_Name"));
		
		Thread.sleep(1000);
		//De-Select Default Toggle
		air.Default_No_ToggleBtn().click();
		
		//Click Adjustment Reason Type
		air.Adjustment_RadioBtn().click();
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_Save_ButtonTwo();
		
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Sub Recipe Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error(s)"))
		{
			test.log(LogStatus.PASS, "Validation Error(s) pop up displayed");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub Recipe saved successfully!."))
		{
			test.log(LogStatus.FAIL, "Duplicate Sub Recipe saved");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Recipe Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 5,enabled = false)
	public void Verify_Integration_Inv_SubRecipe_In_Adjust_Inventory_and_Adjust_Inventory_Report(WebDriver driver) throws Exception
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
		new InventoryPage(driver, test).Select_Sub_Recipe_AdjustInventoryTab();
		
		String Expected_SubRecipe=ut.getProperty("Inventory_SubRecipe_Name");
		
		
				
		//Search any Inventory Item from the list and 
		new Common_XPaths(driver, test).Search(Expected_SubRecipe);
		
		Thread.sleep(3000);
		String Actual_SubRecipe=driver.findElement(By.xpath("//div[contains(@id,'cdk-drop-list')]/div[1]/div/data-grid-row/div/div[1]")).getText();

		
		//Verify the SubRecipe is Reflected on the Adjust Inventory or not
		if(Expected_SubRecipe.equalsIgnoreCase(Actual_SubRecipe))
		{
			test.log(LogStatus.PASS, "Sub-Recipe is Updated in Adjust Inventory as Expected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub-Recipe is not Updated in Adjust Inventory as Expected");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	
	}
}
