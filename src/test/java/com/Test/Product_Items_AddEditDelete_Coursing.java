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
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_Coursing {
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete Coursing");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	CoursingPage cp;
	
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
		Open_Coursing_Page(driver);
		RefreshAndPaginination_ColumnFilteration(driver);
		Add_Coursing(driver);
		Edit_and_Close_Cancel_Coursing(driver);
		Edit_and_Update_Coursing(driver);
		Delete_and_Active_Inactive_Coursing(driver);
		Create_DuplicateCourse(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Coursing_Page(WebDriver driver) throws Exception
	{
		
		cp=new CoursingPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"coursing");

		Thread.sleep(5000);
		//Verify the Coursing page loeded or not
		cmp.VerifyMainScreenPageHeader("Coursing");	
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination_ColumnFilteration(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		cp=new CoursingPage(driver, test);
		
		//Verify the Pagination and Refresh the page
		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
		
		Thread.sleep(2000);
		//Verify Ascending order for name 
		cp.Verify_AscendingNameSorting();
		Thread.sleep(2000);

		//Verify Decending
		cp.Verify_DescendingNameSorting();
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_Coursing(WebDriver driver) throws Exception
	{
		cp=new CoursingPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Coursing
		cp.ClickNewCoursing();
		Thread.sleep(2000);
	
		//Verify the New Course creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Coursing");
		Thread.sleep(2000);
		
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
		//Enter the Course Name
		cmp.EnterName(Utility.getProperty("ProductsItems_Add_Course_Name"));
		
		//Enter the Priority
				cp.PriorityInputBox().sendKeys(Keys.BACK_SPACE);
				
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enter Valid Priority"))
		{
			test.log(LogStatus.PASS, "Enter Valid Priority Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter Valid Priority Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Clear Prioriry
		cp.PriorityInputBox().clear();
		//Enter the Priority
		cp.PriorityInputBox().sendKeys("0");
		
		//Verify Zero or minus values
		cp.VerifyZeroPriorityAlertMsg();
		
		Thread.sleep(1000);
		//Clear Prioriry
//		cp.PriorityInputBox().clear();
		//Enter the Priority
//		cp.PriorityInputBox().sendKeys("-1");
//		
//		//Verify Zero or minus values
//		cp.VerifyZeroPriorityAlertMsg();
		
		Thread.sleep(1000);
		//Clear Prioriry
		cp.PriorityInputBox().clear();
		//Enter the Priority
		cp.PriorityInputBox().sendKeys("1");
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Course Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Course Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Course Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Coursing(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		cp=new CoursingPage(driver, test);
		
		Thread.sleep(500);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("ProductsItems_Add_Course_Name"));
		
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Coursing");
		
		
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
		cmp.SearchAndClickEdit(Utility.getProperty("ProductsItems_Add_Course_Name"));
		
		
		Thread.sleep(1000);
		//Click the Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Course Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Coursing Screen Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Coursing Screen Cancelled");
		}
		
	}
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Coursing(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		cp=new CoursingPage(driver, test);
	
		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("ProductsItems_Add_Course_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName("");
		
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
			test.log(LogStatus.FAIL, "Course Updated without Coursing Name");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);

			Thread.sleep(1000);
			//Search and Click Edit button
			cmp.SearchAndClickEdit(Utility.getProperty("ProductsItems_Add_Course_Name"));
			
		}	
		else
		{
			test.log(LogStatus.INFO, "Please Enter Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("ProductsItems_Add_Course_Name")+"1");
	
		//Enter the Priority
				cp.PriorityInputBox().sendKeys(Keys.BACK_SPACE);
				
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enter Valid Priority"))
		{
			test.log(LogStatus.PASS, "Enter Valid Priority Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter Valid Priority Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Clear Prioriry
		cp.PriorityInputBox().clear();
		//Enter the Priority
		cp.PriorityInputBox().sendKeys("0");
		
		//Verify Zero or minus values
		cp.VerifyZeroPriorityAlertMsg();
		
		Thread.sleep(1000);
		//Clear Prioriry
//		cp.PriorityInputBox().clear();
		//Enter the Priority
//		cp.PriorityInputBox().sendKeys("-1");
		
		//Verify Zero or minus values
//		cp.VerifyZeroPriorityAlertMsg();
		
		Thread.sleep(1000);
		//Clear Prioriry
		cp.PriorityInputBox().clear();
		//Enter the Priority
		cp.PriorityInputBox().sendKeys("1");
		
		
		Thread.sleep(500);
		Thread.sleep(1000);
		//Clear Prioriry
		cp.PriorityInputBox().clear();
		//Enter the Priority
		cp.EnterPriority("0");
		
//		Thread.sleep(500);
//		//Click the Save button
//		cmp.Click_SaveButton();
		
		//Check whether the Priority Warning displayed or not
		if(cp.PriorityZeroPopUp().isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter Valid Priority Pop up dispayed when Entering Priority 0");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.PASS, "Enter Valid Priority Pop up not dispayed when Entering Priority 0");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(500);
		//Enter the Priority
		cp.EnterPriority("1");
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Course Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Course Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Course Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Coursing(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		cp=new CoursingPage(driver, test);
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("ProductsItems_Add_Course_Name")+"1");
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Course Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Course Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Course not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("ProductsItems_Add_Course_Name")+"1");
		
		//Click Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Course Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Course Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Course Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("ProductsItems_Add_Course_Name")+"1");
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();

				try
				{
				Thread.sleep(3000);
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Course Activated Successfully"))
				{
					test.log(LogStatus.FAIL, "Course Activated when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Course not Activated when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}

		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("ProductsItems_Add_Course_Name")+"1");
		
		//Click Activate button
				cmp.Click_ActivateButton();
				
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Course Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Course activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Course activated Failed");
			
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
		cmp.SearchAndClickEdit(Utility.getProperty("ProductsItems_Add_Course_Name")+"1");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
	}
	
	@Test(priority = 6,enabled = false)
	public void Create_DuplicateCourse(WebDriver driver) throws Exception
	{
		cp=new CoursingPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Coursing button
		cp.ClickNewCoursing();
		Thread.sleep(2000);
	
		Thread.sleep(500);
		//Enter the existing Course name
		cmp.EnterName(Utility.getProperty("ProductsItems_Add_Course_Name")+"1");
		
		Thread.sleep(1000);
		//Enter the Priority
		cp.PriorityInputBox().sendKeys("1");
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Course Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Course Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
}
