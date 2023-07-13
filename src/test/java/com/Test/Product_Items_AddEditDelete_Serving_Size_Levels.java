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

import com.Pages.LoginPage;
import com.Pages.ModifierGroupsPage;
import com.Pages.ModifiersPage;
import com.Pages.ServingSizeLevelsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_Serving_Size_Levels {

	
	
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete Serving Size Levels");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	ServingSizeLevelsPage ssl;
	
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
		Open_Service_Size_Levels_Page(driver);
		RefreshAndPaginination(driver);
		Add_Servinge_Size_Level(driver);
		Edit_and_Close_Cancel_Serving_Size_Level(driver);
		Edit_and_Update_Serving_Size_Level(driver);
		Delete_and_Active_Inactive_Serving_Size_Level(driver);
		Create_DuplicateServing_Size_Level(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Service_Size_Levels_Page(WebDriver driver) throws Exception
	{
		
		ssl=new ServingSizeLevelsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Serving Size Levels page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"servingSizeLevels");

		Thread.sleep(5000);
		//Verify the Serving Size Level page loaded or not
		cmp.VerifyMainScreenPageHeader("Serving Size Levels");	
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
	public void Add_Servinge_Size_Level(WebDriver driver) throws Exception
	{
		ssl=new ServingSizeLevelsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Serving Size Level
		ssl.Click_NewServingSizeLevelButton();
		Thread.sleep(2000);
	
		//Verify the New Serving Size Level creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Serving Size Level");
		Thread.sleep(2000);
		
		if(cmp.Save_Button().isEnabled())
		{
			Thread.sleep(1000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Serving Size Level Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Serving Size Name"))
		{
			test.log(LogStatus.PASS, "Please enter Serving Size Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please enter Serving Size Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.PASS, "Save button not Enabled without Entering Serving Size Level Name");
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
		//Enter the Serving Size Level Name
		cmp.EnterName(Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name"));
		
		Thread.sleep(1000);
		//Enter the Description
		ssl.EnterDescription("Newly SSL is "+Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name"));
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Serving Size Level Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Serving Size Level Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Serving Size Level Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Serving Size Level Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Serving_Size_Level(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ssl=new ServingSizeLevelsPage(driver, test);
		
		
		Thread.sleep(500);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name"));
		
		//Check whether the application displays Update screen or not
				cmp.VerifyCreationScreenPageHeader("Update Serving Size Level");
				
		
		Thread.sleep(1000);
		//Click the Close button
		cmp.Click_CloseButton();
		
		Thread.sleep(1000);
		//Check whether the New Serving Size Level Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Editing Serving Size Level screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Editing Serving Size Level screen not Closed");
		}
		
		
		Thread.sleep(1000);
		//Search the Modifier Groups to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name"));
		
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Serving Size Level");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Modifier Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Serving Size Level Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Serving Size Level not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Serving_Size_Level(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ssl=new ServingSizeLevelsPage(driver, test);
		

		
		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name"));
		
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
		//Check whether the New Serving Size Level Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please enter Serving Size Name"))
		{
			test.log(LogStatus.PASS, "Please enter Serving Size Name Alert Displayed when Updating without Name");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Serving Size Level Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Serving Size Level Updated without Entering Name");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
//			//Click New Seving Size
//			ssl.Click_NewServingSizeLevelButton();
//			
//			Thread.sleep(500);
//			//Enter the Name
//			cmp.EnterName(Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name")+"1");
//			
//			Thread.sleep(500);
//			//Enter the Description
//			ssl.EnterDescription("SSL name Updated as "+Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name")+"1");
//			
//			//Click the Save button
//			cmp.Click_SaveButton();
//			
			Thread.sleep(1000);
			//Search and Click Edit button
			cmp.SearchAndClickEdit(Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name"));
			
//			test.log(LogStatus.INFO, "Serving Size Recreated");
		
		}
		else
		{
			test.log(LogStatus.FAIL, "Please enter Serving Size Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.PASS, "Update button not Enabled without Entering Serving Size Level Name");
		}
		Thread.sleep(2000);
		
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name")+"1");
		
		Thread.sleep(500);
		//Enter the Description
		ssl.EnterDescription("SSL name Updated as "+Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name")+"1");
				
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Serving Size Level Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Serving Size Level Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Serving Size Level Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Serving Size Level Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
//		
//		//Need to Remove
//		cmp.Click_CancelButton();
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Serving_Size_Level(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		ssl=new ServingSizeLevelsPage(driver, test);
		
		Thread.sleep(500);
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name")+"1");
		
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Serving Size Level Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Serving-size Level Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Serving-size Level not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		Thread.sleep(500);
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name")+"1");
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Serving Size Level Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Serving Size Level Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Serving Size Level Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else 
		{
			test.log(LogStatus.FAIL, "Serving Size Level Inactivated Failed");
			
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
		cmp.SearchAndClickActivate(Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name")+"1");
		
		
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
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Serving size Level Activated Successfully"))
		{
			test.log(LogStatus.FAIL, "Serving-size Level Activated when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Serving-size Level not Activated when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name")+"1");
				
		
		Thread.sleep(500);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Serving Size Level Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Serving Size Level Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Serving Size Level activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Serving Size Level activated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(500);
		//Enable Active Status
		cmp.Click_InactivetoActiveButton();
				
		Thread.sleep(500);
		//Check whether verify whether the Active page opened or not
		cmp.VerifyActive_InactiveStatus("Active");
		
		Thread.sleep(1000);
		//Search the Serving Size Level to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name")+"1");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
	}
	
	@Test(priority = 6,enabled = false)
	public void Create_DuplicateServing_Size_Level(WebDriver driver) throws Exception
	{
		ssl=new ServingSizeLevelsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Serving Size Level button
		ssl.Click_NewServingSizeLevelButton();
		Thread.sleep(2000);
	
		Thread.sleep(500);
		//Enter the existing Serving Size Level name
		cmp.EnterName(Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name")+"1");
		
		Thread.sleep(1000);
		//Enter the Description
		ssl.EnterDescription("Adding Duplicate of SSL as "+Utility.getProperty("ProductsItems_Add_ServingSizeLevel_Name")+"1");
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Serving Size Level Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error(s)"))
		{
			test.log(LogStatus.PASS, "Validation Error(s) pop up displayed");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	
}
