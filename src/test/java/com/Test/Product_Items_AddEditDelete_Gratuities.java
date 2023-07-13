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
import com.Pages.GratuitiesPage;
import com.Pages.GratuitiesPage;
import com.Pages.LoginPage;
import com.Pages.GratuitiesPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_Gratuities {
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete Gratuities");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	GratuitiesPage gp;
	
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
		Open_Gratuity_Page(driver);
		RefreshAndPaginination(driver);
		Add_Gratuity(driver);
		Edit_and_Close_Cancel_Gratuity(driver);
		Edit_and_Update_Gratuity(driver);
		Delete_and_Active_Inactive_Gratuity(driver);
		Create_DuplicateTareGroup(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Gratuity_Page(WebDriver driver) throws Exception
	{
		
		gp=new GratuitiesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Gratuity page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"gratuities");

		Thread.sleep(5000);
		//Verify the Gratuity page loaded or not
		cmp.VerifyMainScreenPageHeader("Gratuities");	
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
	public void Add_Gratuity(WebDriver driver) throws Exception
	{
		gp=new GratuitiesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2500);
		//Click the New Gratuity
		gp.Click_NewGratuityButton();
		Thread.sleep(2500);
	
		//Verify the New Gratuity creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Gratuity");
		Thread.sleep(2500);
		
		if(cmp.Save_Button().isEnabled())
		{
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Gratuity Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Valid Gratuity Name"))
		{
			test.log(LogStatus.PASS, "Please Enter Valid Gratuity Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Valid Gratuity Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.PASS, "Save button not Enabled without Entering Gratuity Name");
		}
		
		Thread.sleep(1000);
		//Enter the Gratuity Name
		gp.Enter_GratuityName(Utility.getProperty("GratuityName_Fixed"));
		
		
		gp.Enter_PercentageFixed("0");
		
		
		gp.Verify_Valid_Percentage_ErrorMessage();

		
		if(cmp.Save_Button().isEnabled())
		{
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Gratuity Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Valid Percentage"))
		{
			test.log(LogStatus.PASS, "Please Enter Valid Percentage Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Valid Percentage Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.PASS, "Save button not Enabled without Entering Percentage");
		}
		
		Thread.sleep(2000);
		//Enter the Percentage
		gp.Enter_PercentageFixed("100");
		
			Thread.sleep(1000);
				//Enable Auto Gratuity Seat Count
				gp.Enable_Auto_Gratuity();
				
				gp.Enter_Auto_Gratuity_SeatCount("0");
				
				gp.Verify_Valid_Seat_Count_ErrorMessage();
				
				if(cmp.Save_Button().isEnabled())
				{
				Thread.sleep(1000);
				//Click the Save button
				cmp.Click_SaveButton();
				
				Thread.sleep(3000);
				//Check whether the New Gratuity Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Valid Auto Gratuity Seat Count"))
				{
					test.log(LogStatus.PASS, "Please Enter Valid Auto Gratuity Seat Count Alert Displayed");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Please Enter Valid Auto Gratuity Seat Count Alert not Displayed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				else
				{
					test.log(LogStatus.PASS, "Save button not Enabled without Entering Auto Gratuity Seat Count");
					
				
				}
				
				Thread.sleep(2000);
				//Enter the Fixed Gratuity
				gp.Enter_Fixed_Gratuity(Utility.getProperty("GratuityName_Fixed"));
		
				
				Thread.sleep(2000);
				//Enter the Percentage
				gp.Enter_PercentageFixed("1000");
				
				
				
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Gratuity Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Gratuity Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Gratuity (Fixed) Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Gratuity (Fixed) Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(3000);
		//Click the New Gratuity
		gp.Click_NewGratuityButton();
		Thread.sleep(2500);
	
		Thread.sleep(2000);
		//Enter the Variable Gratuity
		gp.Enter_Variable_Gratuity(Utility.getProperty("GratuityName_Variable"));

		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();


	Thread.sleep(3000);
	//Check whether the New Gratuity Saved or not
	if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Gratuity Saved Successfully"))
	{
		test.log(LogStatus.PASS, "Gratuity (Variable) Saved Successfully");

		ut.PassedCaptureScreenshotAsBASE64(driver, test);
	}
	else
	{
		test.log(LogStatus.FAIL, "Gratuity (Variable) Save Failed");
	
		ut.FailedCaptureScreenshotAsBASE64(driver, test);
	}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Gratuity(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		gp=new GratuitiesPage(driver, test);
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("GratuityName_Fixed"));
		
		Thread.sleep(1000);
		//Click the Close button
		cmp.Click_CloseButton();
		
		Thread.sleep(1000);
		//Check whether the New Gratuity Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Editing Gratuity screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Editing Gratuity screen not Closed");
		}
		
		
		Thread.sleep(1000);
		//Search the Gratuities to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("GratuityName_Variable"));
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Gratuity Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Gratuity screen Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gratuity screen not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Gratuity(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		gp=new GratuitiesPage(driver, test);
		
		Thread.sleep(2000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
	
		
	
		Thread.sleep(2000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("GratuityName_Fixed"));
		
		//Check whether the Auto Gratuity Enabled or not
		if(gp.Auto_Gratuity_Toggle().isEnabled())
		{
			test.log(LogStatus.FAIL, "Auto Gratuity Enabled");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		}
		else
		{
			test.log(LogStatus.PASS, "Auto Gratuity not Enabled");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enter the Percentage
		gp.Enter_PercentageFixed("2000");
		
		Thread.sleep(1000);
		//Enable Auto Gratuity
		gp.Enable_Auto_Gratuity();
		
		Thread.sleep(1000);
		gp.Enter_Auto_Gratuity_SeatCount("12");
		
		Thread.sleep(1000);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Gratuity Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Gratuity Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Gratuity (Fixed-Auto Gratuity) Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Gratuity (Fixed-Auto Gratuity) Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("GratuityName_Fixed"));
		
		//Check whether the Auto Gratuity Enabled or not
		if(gp.Auto_Gratuity_Toggle().isEnabled())
		{
			test.log(LogStatus.PASS, "Auto Gratuity Enabled");
			
		
		}
		else
		{
			test.log(LogStatus.FAIL, "Auto Gratuity not Enabled");
		}
		
		//Check whether the Percentage updated or not
		if(gp.Percentage_InputBox().getAttribute("value").equalsIgnoreCase("20.00%"))
		{
			test.log(LogStatus.PASS, "Percentage not changed after the Update (Fixed)");
		}
		else
		{
			test.log(LogStatus.FAIL, "Percentage changed after the Update (Fixed)");

		}
		
		//Check whether the Auto Gratuity SeaT COUNT updated or not
		if(gp.Auto_Seat_Count_InputBox().getAttribute("value").equalsIgnoreCase("12"))
		{
			test.log(LogStatus.PASS, "Auto Seat Count not changed after the Update (Fixed)");
		}
		else
		{
			test.log(LogStatus.FAIL, "Auto Seat Count not changed after the Update (Fixed)");

		}
		
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		
		
		Thread.sleep(2000);
		//Search and Click Edit button
				cmp.SearchAndClickEdit(Utility.getProperty("GratuityName_Variable"));
				
				
				//Enter Min Percentage 
				gp.Enter_Min_PercentageFixed("1000");
				
				
				//Enter Max Percentage
				gp.Enter_Max_PercentageFixed("4000");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				Thread.sleep(1000);
				gp.Enter_Auto_Gratuity_SeatCount("15");
				
				Thread.sleep(1000);
				//Click the Update button
				cmp.Click_UpdateButton();
				
				Thread.sleep(3000);
				//Check whether the New Gratuity Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Gratuity Updated Successfully"))
				{
					test.log(LogStatus.PASS, "Gratuity (Variable-Auto Gratuity) Updated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Gratuity (Variable-Auto Gratuity) Updated Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				Thread.sleep(3000);
				//Search and Click Edit button
						cmp.SearchAndClickEdit(Utility.getProperty("GratuityName_Variable"));
						
				
				//Check whether the Min Percentage updated or not
				if(gp.Min_Percentage_InputBox().getAttribute("value").equalsIgnoreCase("10.00%"))
				{
					test.log(LogStatus.PASS, "Min Percentage not changed after the Update (Variable)");
				}
				else
				{
					test.log(LogStatus.FAIL, "Min Percentage not changed after the Update (Variable)");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				//Check whether the Max Percentage updated or not
				if(gp.Max_Percentage_InputBox().getAttribute("value").equalsIgnoreCase("4000"))
				{
					test.log(LogStatus.PASS, "Max Percentage not changed after the Update (Variable)");
				}
				else
				{
					test.log(LogStatus.FAIL, "Max Percentage not changed after the Update (Variable)");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				//Check whether the Auto Gratuity SeaT COUNT updated or not
				if(gp.Auto_Seat_Count_InputBox().getAttribute("value").equalsIgnoreCase("15"))
				{
					test.log(LogStatus.PASS, "Auto Seat Count not changed after the Update (Variable)");
				}
				else
				{
					test.log(LogStatus.FAIL, "Auto Seat Count not changed after the Update (Variable)");

				}
				
				Thread.sleep(1000);
				//Click Cancel button
				cmp.Click_CancelButton();
				
	}
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Gratuity(WebDriver driver) throws Exception
	{
		Thread.sleep(1000);
		
		cmp=new Common_XPaths(driver, test);
		gp=new GratuitiesPage(driver, test);
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("GratuityName_Fixed"));
		
		Thread.sleep(1000);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Gratuity Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Gratuity Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Gratuity not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("GratuityName_Fixed"));
		
		Thread.sleep(1000);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Gratuity Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Gratuity Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Gratuity Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Gratuity Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("GratuityName_Fixed"));
				
				Thread.sleep(1000);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();

				try
				{
				Thread.sleep(3000);
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Gratuity Activated Successfully"))
				{
					test.log(LogStatus.FAIL, "Gratuity Activated when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Gratuity not Activated when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}



		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("GratuityName_Fixed"));
		
		Thread.sleep(1000);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Gratuity Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Gratuity Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Gratuity activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Gratuity activated Failed");
			
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
	public void Create_DuplicateTareGroup(WebDriver driver) throws Exception
	{
		gp=new GratuitiesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Gratuities button
		gp.Click_NewGratuityButton();
		Thread.sleep(2000);
	
		Thread.sleep(1000);
		//Enter the existing Gratuity name
		cmp.EnterName(Utility.getProperty("GratuityName_Fixed"));
		
		Thread.sleep(1000);
		//Enter the Percentage
		gp.Enter_PercentageFixed("100");
		
	
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Gratuity Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name Already Exists"))
		{
			test.log(LogStatus.PASS, "Name already exists pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Name already exists pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
}
