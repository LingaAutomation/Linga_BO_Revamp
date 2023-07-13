package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang.RandomStringUtils;
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
import com.Pages.CustomersPage;
import com.Pages.LoginPage;
import com.Pages.UserManagementPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Customers_House_Accounts 
{
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Customers - House Account");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	CustomersPage cus;
	UserManagementPage usm; 
	
	String Customer_Name;
	
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
		Open_House_Account_Page(driver);
		RefreshAndPaginination_ColumnFilteration(driver);
		Add_New_House_Account(driver);
		Edit_and_Close_Cancel_House_Account(driver);
		Edit_and_Update_House_Account_Weekly_Period(driver);
		Edit_and_Update_House_Account_Monthly_Period(driver);
		Edit_and_Update_House_Account_Daily_Period(driver);
		Delete_and_Active_Inactive_House_Account(driver);
		Create_Duplicate_House_Account(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_House_Account_Page(WebDriver driver) throws Exception
	{
		
		cus=new CustomersPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id7")+"houseAccount");

		Thread.sleep(5000);
		//Verify the Customer page loaded or not
		cmp.VerifyMainScreenPageHeader("House Account");	
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination_ColumnFilteration(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		cus=new CustomersPage(driver, test);
		
		//Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
		
		Thread.sleep(2000);
//		//Verify Ascending order for name 
//		new CoursingPage().Verify_AscendingNameSorting();
//		Thread.sleep(2000);
//
//		//Verify Decending
//		cp.Verify_DescendingNameSorting();
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_New_House_Account(WebDriver driver) throws Exception
	{
		cus=new CustomersPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		usm=new UserManagementPage(driver, test);
		
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id7")+"customersInfo");

		Thread.sleep(5000);
		//Verify the Customer page loaded or not
		cmp.VerifyMainScreenPageHeader("Customers");	
		
		String str=RandomStringUtils.randomAlphanumeric(6);
		String CusNAme="Raja"+str;
		this.Customer_Name=CusNAme;
		
		//Click the New Customer
		cus.Click_New_Customer();
		
		Thread.sleep(1000);
		//Enter First name
		usm.Enter_FirstName(CusNAme);
		//Click the New Customer button
		new UserManagementPage(driver, test).Enter_LastName("SRN");
		
		new UserManagementPage(driver, test).Enter_Email_ID(CusNAme+"srn"+"@mail.com");
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_Save_ButtonTwo();
		
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
		//Check whether the New House Account Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Customer Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Customer Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Customer Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(3000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id7")+"houseAccount");

		Thread.sleep(5000);
		//Verify the Customer page loaded or not
		cmp.VerifyMainScreenPageHeader("House Account");	
				
		Thread.sleep(2000);
		//Click the New Customer
		cus.Click_New_House_Account();
		Thread.sleep(2000);
	
		//Verify the New House Account creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New House Account");
		Thread.sleep(2000);
		
		//Enter the Balance
		cus.Enter_Balance("0");
		
		//Enable Period Limit
		cus.Enable_Period_LimitToggle();
		
		//Select Limit Period
		cus.Select_Limit_Period("Daily");
		
		//Enter Limit Amount
		cus.Enter_Limit_Amount("500");
		
		//Enable Allow Credit
		cus.Enable_Allow_CreditToggle();
		
		//Disable Enable Max Limit
		cus.Disable_Max_LimitToggle();
		
		//Enter Max Amount Limit
		cus.Enter_Max_Limit_Amount("50");
		
		//Check whether the limit should be less than max amount error pop up displayed or not
		try
		{
			if(cmp.Error_BelowInputBox().getText().equalsIgnoreCase("Limit should be less than max amount"))
			{
				test.log(LogStatus.PASS, "Limit should be less than max amount is Displayed");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.FAIL, "Limit should be less than max amount is not Displayed");
		}
		
		//Enter Max Amount Limit
		cus.Enter_Max_Limit_Amount("800");
				
		if(cmp.Save_ButtonTwo().isEnabled())
		{
		//Click the Save button
		cmp.Click_Save_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New House Account Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Select Customer"))
		{
			test.log(LogStatus.PASS, "Please Select Customer Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Select Customer Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.INFO, "Save button not Enabled without Entering Customer Name");
		}
		
		//Select Customer
		cus.Select_Customer_withName(CusNAme);
		
		//Enter the Balance
		cus.Enter_Balance("500");
				
		//Enable Period Limit
		cus.Enable_Period_LimitToggle();
				
		//Select Limit Period
		cus.Select_Limit_Period("Daily");
				
		//Enter Limit Amount
		cus.Enter_Limit_Amount("500");
				
		//Enable Allow Credit
		cus.Enable_Allow_CreditToggle();
				
		//Disable Enable Max Limit
		cus.Disable_Max_LimitToggle();
				
		//Enter Max Amount Limit
		cus.Enter_Max_Limit_Amount("800");
				
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_Save_ButtonTwo();
		
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
		//Check whether the New House Account Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("House Account Saved Successfully"))
		{
			test.log(LogStatus.PASS, "House Account Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "House Account Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_House_Account(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		cus=new CustomersPage(driver, test);
		
		Thread.sleep(500);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Customer_Name);
		
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update House Account");
		
		
		Thread.sleep(1000);
		//Click the Close button
		cmp.Click_CloseButton();
		
		Thread.sleep(1000);
		//Check whether the New House Account Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Editing House Account screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Editing House Account screen not Closed");
		}
		
		Thread.sleep(500);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Customer_Name);
		
		
		Thread.sleep(1000);
		//Click the Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New House Account Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "House Account Screen Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "House Account Screen Cancelled");
		}
		
	}
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_House_Account_Weekly_Period(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		cus=new CustomersPage(driver, test);
	
		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Customer_Name);
		
		Thread.sleep(500);
		//Enter the balance
		cus.Enter_Balance("600");
		
		//Check whether the Period Limit enabled or not
		if(cus.Enable_Period_Limit_Yes_Toggle().isEnabled())
		{
			test.log(LogStatus.PASS, "Enable Period Limit Toggle is Enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Enable Period Limit Toggle is not Enable");
		}
		
		//Check whether the Allow Credit enabled or not
		if(cus.Allow_Credit_Yes_Toggle().isEnabled())
		{
			test.log(LogStatus.PASS, "Allow Credit Toggle is Enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Allow Credit Toggle is not Enable");
		}
		
		
		
		//Select Limit Period
				cus.Select_Limit_Period("Weekly");
						
				//Select Day
				cus.Select_Day();
				
				//Enter Limit Amount
				cus.Enter_Limit_Amount("500");
				
				//Enable Max Limit
				cus.Enable_Max_LimitToggle();
				
				//Enter Max Limit
				cus.Enter_Max_Limit_Amount("900");
				
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New House Account Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("House Account Updated Successfully"))
		{
			test.log(LogStatus.PASS, "House Account Updated Successfully (Limit Period - Weekly)");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "House Account Updated Failed (Limit Period - Weekly)");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_House_Account_Monthly_Period(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		cus=new CustomersPage(driver, test);
	
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Customer_Name);
		
		Thread.sleep(500);
		//Enter the balance
		cus.Enter_Balance("600");
		
		//Check whether the Period Limit enabled or not
		if(cus.Enable_Period_Limit_Yes_Toggle().isEnabled())
		{
			test.log(LogStatus.PASS, "Enable Period Limit Toggle is Enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Enable Period Limit Toggle is not Enable");
		}
		
		//Check whether the Allow Credit enabled or not
		if(cus.Allow_Credit_Yes_Toggle().isEnabled())
		{
			test.log(LogStatus.PASS, "Allow Credit Toggle is Enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Allow Credit Toggle is not Enable");
		}
		 
		//Check whether the Allow Credit enabled or not
		if(cus.Enable_Max_Limit_Yes_Toggle().isEnabled())
		{
			test.log(LogStatus.PASS, "Enable Max Limit Toggle is Enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Enable Max Limit Toggle is not Enable");
		}
		
		String Balance=cus.Balance_InputBox().getAttribute("value");
		
		if(Balance.equalsIgnoreCase("600"))
		{
			test.log(LogStatus.PASS, "Balance amount is not Changed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Balance amount is Changed");
		}
		
		
		String period=cus.Limit_Period_InputBox().getAttribute("value");
		
		if(period.equalsIgnoreCase("Weekly"))
		{
			test.log(LogStatus.PASS, "Limited Period is selected as Weekly");
		}
		else
		{
			test.log(LogStatus.FAIL, "Limited Period is not selected as Weekly");
		}
		
		String LimitAmount=cus.Limit_Amount_InputBox().getAttribute("value");
		
		if(LimitAmount.equalsIgnoreCase("500"))
		{
			test.log(LogStatus.PASS, "Limit amount is not Changed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Limit amount is Changed");
		}
		
		String MaxLimitAmount=cus.Max_Amount_Limit_InputBox().getAttribute("value");
		
		if(MaxLimitAmount.equalsIgnoreCase("900"))
		{
			test.log(LogStatus.PASS, "Max Amount Limit is not Changed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Max Amount Limit is Changed");
		}
		
		//Select Limit Period
				cus.Select_Limit_Period("Monthly");
						
				//Select Day
				cus.Select_Day();
				
				//Enter Limit Amount
				cus.Enter_Limit_Amount("500");
				
				//Enable Max Limit
				cus.Enable_Max_LimitToggle();
				
				//Enter Max Limit
				cus.Enter_Max_Limit_Amount("900");
				
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New House Account Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("House Account Updated Successfully"))
		{
			test.log(LogStatus.PASS, "House Account Updated Successfully (Limit Period - Monthly)");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "House Account Updated Failed (Limit Period - Monthly)");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_House_Account_Daily_Period(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		cus=new CustomersPage(driver, test);
	
	
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Customer_Name);
		
		Thread.sleep(500);
		//Enter the balance
		cus.Enter_Balance("700");
		
	
		String period=cus.Limit_Period_InputBox().getAttribute("value");
		
		if(period.equalsIgnoreCase("Weekly"))
		{
			test.log(LogStatus.PASS, "Limited Period is selected as Monthly");
		}
		else
		{
			test.log(LogStatus.FAIL, "Limited Period is not selected as Monthly");
		}
		
		
		//Select Limit Period
				cus.Select_Limit_Period("Daily");
						
				//Select Day
				cus.Select_Day();
				
				//Enter Limit Amount
				cus.Enter_Limit_Amount("800");
				
				//Enable Max Limit
				cus.Enable_Max_LimitToggle();
				
				//Enter Max Limit
				cus.Enter_Max_Limit_Amount("1000");
				
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New House Account Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("House Account Updated Successfully"))
		{
			test.log(LogStatus.PASS, "House Account Updated Successfully (Limit Period - Daily)");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "House Account Updated Failed (Limit Period - Daily)");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Customer_Name);
		
		Thread.sleep(500);
		//Enter the balance
		cus.Enter_Balance("600");
		
	
		String period1=cus.Limit_Period_InputBox().getAttribute("value");
		
		if(period1.equalsIgnoreCase("Daily"))
		{
			test.log(LogStatus.PASS, "Limited Period is selected as Daily");
		}
		else
		{
			test.log(LogStatus.FAIL, "Limited Period is not selected as Daily");
		}
		
		
		//Click Cancel button
		cmp.Click_BackspaceButton();
		
		
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_House_Account(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		cus=new CustomersPage(driver, test);
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Customer_Name);
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("House Account Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "House Account Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "House Account not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Customer_Name);
		
		//Click Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New House Account Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("House Account Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "House Account Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "House Account Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Customer_Name);
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();

				try
				{
				Thread.sleep(3000);
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("House Account Activated Successfully"))
				{
					test.log(LogStatus.FAIL, "House Account Activated when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "House Account not Activated when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}

		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Customer_Name);
		
		//Click Activate button
				cmp.Click_ActivateButton();
				
		
		Thread.sleep(3000);
		//Check whether the New House Account Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("House Account Activated Successfully"))
		{
			test.log(LogStatus.PASS, "House Account activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "House Account activated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(500);
		//Enable Active Status
		cmp.Click_InactivetoActiveButton();
				
		Thread.sleep(500);
		//Check whether verify whether the Active page opened or not
		cmp.VerifyActive_InactiveStatus("Active");
		
		Thread.sleep(1000);
		//Search the Customer to Click Edit and Cancel
		cmp.SearchAndClickEdit(Customer_Name);
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
	}
	
	@Test(priority = 6,enabled = false)
	public void Create_Duplicate_House_Account(WebDriver driver) throws Exception
	{
		cus=new CustomersPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Customer button
		cus.Click_New_House_Account();
		Thread.sleep(2000);
	
		//Select Customer
		cus.Select_Customer_withName(Customer_Name);
		
		//Enter the Balance
		cus.Enter_Balance("500");
				
		//Enable Period Limit
		cus.Enable_Period_LimitToggle();
				
		//Select Limit Period
		cus.Select_Limit_Period("Daily");
				
		//Enter Limit Amount
		cus.Enter_Limit_Amount("500");
				
		//Enable Allow Credit
		cus.Enable_Allow_CreditToggle();
				
		//Disable Enable Max Limit
		cus.Disable_Max_LimitToggle();
				
		//Enter Max Amount Limit
		cus.Enter_Max_Limit_Amount("800");
				
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_Save_ButtonTwo();
		
		
		Thread.sleep(3000);
		//Check whether the New House Account Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Customer already exists"))
		{
			test.log(LogStatus.PASS, "Customer already exists pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error(s)"))
		{
			test.log(LogStatus.PASS, "Validation Error(s) pop up displayed");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Customer already exists pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
}
