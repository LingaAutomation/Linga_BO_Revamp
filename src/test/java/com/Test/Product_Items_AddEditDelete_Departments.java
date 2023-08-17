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
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
public class Product_Items_AddEditDelete_Departments
{
	
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete Departments");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	DepartmentPage dpg;
	
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
	
			//Load the Department page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"departments");

		}
	}
	
	
	@Test(priority = 1,enabled = true)
	public void Login() throws Exception
	{
		
		
		Thread.sleep(2000);
//		//Call the chrome driver
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
	
	@Test(priority = 50,enabled = true)
	public void LogOut() throws Exception
	{
//		LogOutTest a=new LogOutTest();
		a.LogOut(driver, test);
	}
	
	
	@Test(priority=2)
	public void Calling() throws Exception
	{
		Open_Departments_Page(driver);
		RefreshAndPaginination(driver);
		Add_Departments(driver);
		Edit_and_Close_Cancel_Departments(driver);
		Edit_and_Update_Departments(driver);
		Delete_and_Active_Inactive_Departments(driver);
		Create_DuplicateDepartment(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Departments_Page(WebDriver driver) throws Exception
	{
//		((JavascriptExecutor) driver).executeScript("window.focus();");
		dpg=new DepartmentPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
//		a.Navigate_To_Page(Utility.getProperty("store_Id1"), "departments");
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"departments");
		
		Thread.sleep(5000);
		//Verify the Departments page loaded or not
		cmp.VerifyMainScreenPageHeader("Departments");
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
	public void Add_Departments(WebDriver driver) throws Exception
	{
		dpg=new DepartmentPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Departments
		dpg.Click_NewDepartment();
		Thread.sleep(2000);
	
		//Verify the New Department creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Department");
		Thread.sleep(2000);
	
		if(cmp.Save_Button().isEnabled())
		{
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Department Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Department Name"))
		{
			test.log(LogStatus.PASS, "Please Enter Department Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Department Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.PASS, "Save button not Enabled without Entering Department Name");
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
		//Enter the Department Name
		dpg.Enter_Department_With_Membership(Utility.getProperty("Product_Items_New_Department_Name"), Utility.getProperty("Product_Items_New_Department_Code"));
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Department Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Department Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Department Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Department Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 6,enabled = false)
	public void Edit_and_Close_Cancel_Departments(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dpg=new DepartmentPage(driver, test);
		
		Thread.sleep(500);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Product_Items_New_Department_Name"));
		
		//Check whether the application displays Update screen or not
				cmp.VerifyCreationScreenPageHeader("Update Department");
				
		
		Thread.sleep(1000);
		//Click the Close button
		cmp.Click_CloseButton();
		
		Thread.sleep(1000);
		//Check whether the New Department Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Editing Department screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Editing Department screen not Closed");
		}
		
		
		Thread.sleep(1000);
		//Search the Departments to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("Product_Items_New_Department_Name"));
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Department Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Department screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Department screen not Closed");
		}
		
	}
	
	@Test(priority = 7,enabled = false)
	public void Edit_and_Update_Departments(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dpg=new DepartmentPage(driver, test);
		
		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
	
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Product_Items_New_Department_Name"));
		
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName("");
	
		
		if(cmp.Update_Button().isEnabled())
		{
			Thread.sleep(500);
			//Click the Update button
			cmp.Click_UpdateButton();
			
			Thread.sleep(3000);
			//Check whether the New Department Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Department Updated Successfully"))
			{
				test.log(LogStatus.FAIL, "Department Updated without Department Name");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		
		}
		else
		{
			test.log(LogStatus.PASS, "Department not Updated without Department Name");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(500);
		//Enter the Name
		dpg.Enter_Department_Without_Membership(ut.getProperty("Product_Items_New_Department_Name")+"1", ut.getProperty("Product_Items_New_Department_Code"));
		

		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Department Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Department Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Department Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Department Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 8,enabled = false)
	public void Delete_and_Active_Inactive_Departments(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		dpg=new DepartmentPage(driver, test);
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Product_Items_New_Department_Name")+"1");
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Department Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Department Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Department not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Product_Items_New_Department_Name")+"1");
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Department Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Department Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Department Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Department Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("Product_Items_New_Department_Name")+"1");
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();

				try
				{
				Thread.sleep(3000);
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Department Activated Successfully"))
				{
					test.log(LogStatus.FAIL, "Department Activated when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Department not Activated when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}

		
		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("Product_Items_New_Department_Name")+"1");
		
		Thread.sleep(500);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Department Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Department Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Department activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Department activated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(500);
		//Enable Active Status
		cmp.Click_InactivetoActiveButton();
				
		Thread.sleep(500);
		//Check whether verify whether the Active page opened or not
		cmp.VerifyActive_InactiveStatus("Active");
		
	
		
	}
	
	@Test(priority = 9,enabled = false)
	public void Create_DuplicateDepartment(WebDriver driver) throws Exception
	{
		dpg=new DepartmentPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Departments button
		dpg.Click_NewDepartment();
		Thread.sleep(2000);
	
		Thread.sleep(500);
		//Enter the existing Department name
		cmp.EnterName(Utility.getProperty("Product_Items_New_Department_Name")+"1");
		
	
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Department Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Department Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_CancelButton();
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error(s)"))
		{
			test.log(LogStatus.PASS, "Validation Error(s) pop up displayed");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_CancelButton();
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Department Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Duplicate Department Saved");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Department Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
}
