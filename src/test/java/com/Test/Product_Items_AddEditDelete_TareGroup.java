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
import com.Pages.TareGroupPage;
import com.Pages.LoginPage;
import com.Pages.TareGroupPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_TareGroup {
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete Tare Group");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	TareGroupPage tgp;
	
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
		Open_TareGroups_Page(driver);
		//RefreshAndPaginination(driver);
		Add_TareGroups(driver);
		Edit_and_Close_Cancel_TareGroups(driver);
		Edit_and_Update_TareGroups(driver);
		Delete_and_Active_Inactive_TareGroups(driver);
		Create_DuplicateTareGroup(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_TareGroups_Page(WebDriver driver) throws Exception
	{
		
		tgp=new TareGroupPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Tare Group page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"tareGroup");

		Thread.sleep(5000);
		//Verify the Tare Groups page loeded or not
		cmp.VerifyMainScreenPageHeader("Tare Group");	
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
	public void Add_TareGroups(WebDriver driver) throws Exception
	{
		tgp=new TareGroupPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Tare Groups
		tgp.Click_NewTareGroup();
		Thread.sleep(2000);
	
		//Verify the New Tare Group creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Tare Group");
		Thread.sleep(2000);
		
		if(cmp.Save_Button().isEnabled())
		{
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Tare Group Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Tare Group Name"))
		{
			test.log(LogStatus.PASS, "Please Enter Tare Group Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Tare Group Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.PASS, "Save button not Enabled without Entering Tare Group Name");
		}
		
		Thread.sleep(500);
		//Enter the Tare Group Name
		tgp.Enter_TareGroupName(Utility.getProperty("TareGroupNameWithWeight"));
		
		Thread.sleep(1000);
		//Enable Set Default Yes
		tgp.Enable_Yes_Default();
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Tare Group Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tare Group Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Tare Group Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tare Group Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_TareGroups(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		tgp=new TareGroupPage(driver, test);
		
		Thread.sleep(500);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("TareGroupNameWithWeight"));
		
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Tare Group");
		
		Thread.sleep(1000);
		//Click the Close button
		cmp.Click_CloseButton();
		
		Thread.sleep(1000);
		//Check whether the New Tare Group Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Editing Tare Group screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Editing Tare Group screen not Closed");
		}
		
		
		Thread.sleep(1000);
		//Search the Tare Groups to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("TareGroupNameWithWeight"));
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Tare Group Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Tare Group screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tare Group screen not Closed");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_TareGroups(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		tgp=new TareGroupPage(driver, test);
		
		Thread.sleep(10000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
	
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("TareGroupNameWithWeight"));
		
		
		Thread.sleep(1000);
		tgp.Enable_Yes_Default();
		
		Thread.sleep(500);
		//Add Sequence/Unit of measures/Name/Weight
		tgp.Add_Weights_All_Values();

		Thread.sleep(500);
		//Click Add Weights
		tgp.Click_AddWeightsButton();
		Thread.sleep(500);
		tgp.Click_AddWeightsButton();
		
		Thread.sleep(500);
        //Click the Update button
        cmp.Click_UpdateButton();

        if(cmp.Update_Button().isEnabled())
        {
        Thread.sleep(3000);
        //Check whether the New Tare Group Saved or not
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tare Group Updated Successfully"))
        {
            test.log(LogStatus.FAIL, "Tare Group Updated Successfully without entering Weights");

            Thread.sleep(1000);
            //Search and Click Edit button
            cmp.SearchAndClickEdit(Utility.getProperty("TareGroupNameWithWeight"));

        }
        else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter name field."))
        {
            test.log(LogStatus.PASS, "Please Enter the name Field displayed while Updating without entering Weights");
        }
        else
        {
            test.log(LogStatus.INFO, "Tare Group not Updated without entering Weights");
        }
        }
        else
        {
        	test.log(LogStatus.PASS, "Update button not Enabled without Entering Weights");	
        }
		
		Thread.sleep(500);
		//Delete the Add Weights
		tgp.Delete_AddWeights();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Tare Group Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tare Group Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Tare Group Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tare Group Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_TareGroups(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		tgp=new TareGroupPage(driver, test);
		
		
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("TareGroupNameWithWeight"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tare Group Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Tare Group Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Tare Group not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}


		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("TareGroupNameWithWeight"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Tare Group Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tare Group Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Tare Group Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tare Group Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");

		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("TareGroupNameWithWeight"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		try
		{
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tare Group Activated Successfully"))
		{
			test.log(LogStatus.FAIL, "Tare Group Activated when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Tare Group not Activated when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("TareGroupNameWithWeight"));
		
		Thread.sleep(500);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Tare Group Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tare Group Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Tare Group activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tare Group activated Failed");
			
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
	public void Create_DuplicateTareGroup(WebDriver driver) throws Exception
	{
		tgp=new TareGroupPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Tare Groups button
		tgp.Click_NewTareGroup();
		Thread.sleep(2000);
	
		Thread.sleep(500);
		//Enter the existing Tare Group name
		cmp.EnterName(Utility.getProperty("TareGroupNameWithWeight"));
		
	
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Tare Group Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error(s)"))
		{
			test.log(LogStatus.PASS, "Validation Error(s) pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Validation Error(s) pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
}
