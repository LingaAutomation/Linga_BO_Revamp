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

import com.Pages.Availability_RestrictionTimePage;
import com.Pages.Common_XPaths;
import com.Pages.CategoriesPage;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_Categories 
{
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete Categories");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	Availability_RestrictionTimePage at;
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	CategoriesPage ctp;
	
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
		
		Thread.sleep(60000);
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
		Open_Categories_Page(driver);
		RefreshAndPaginination(driver);
		Add_Categories(driver);
		Edit_and_Close_Cancel_Categories(driver);
		Edit_and_Update_Categories_DaysOfWeek(driver);
		Edit_and_Update_Categories_DaysOfMonth(driver);
		Edit_and_Update_Categories_DateRange(driver);
		Edit_and_Update_Categories_Specific_Date(driver);
		Edit_and_Update_Categories_DateRangeWithTime(driver);
		Delete_and_Active_Inactive_Categories(driver);
		Create_DuplicateCategory(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Categories_Page(WebDriver driver) throws Exception
	{
		
		ctp=new CategoriesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Category page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"categories");

		Thread.sleep(5000);
		//Verify the Categories page loeded or not
		cmp.VerifyMainScreenPageHeader("Categories");	
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
	public void Add_Categories(WebDriver driver) throws Exception
	{
		ctp=new CategoriesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Categories
		ctp.Click_NewCategory();
		Thread.sleep(2000);
	
		//Verify the New Category creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Category");
		Thread.sleep(2000);
		
		if(cmp.Save_and_PublishButton().isEnabled())
		{
		//Click the Save button
				cmp.Click_Save_and_PublishButton();
				
				Thread.sleep(3000);
				//Check whether the New Tax Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category saved successfully"))
				{
					test.log(LogStatus.FAIL, "Category saved successfully for Item Tax (Amount) without Name");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Name"))
				{
					test.log(LogStatus.PASS, "Please Enter Name Pop up Displayed");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
					
				}
		}
		else
		{
			test.log(LogStatus.PASS, "Save and Publish button not Enabled without Entering Name");
		}
		
		
		//Upload picture
		cmp.Upload_Picture(Utility.getProperty("Settings_Store_Information_Store_Image_Path"));
		
		
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
		
		Thread.sleep(2000);
		//Enter the Category Name
		cmp.EnterName(Utility.getProperty("Category_Name"));
		
		
		
		Thread.sleep(3000);
		//Select Department
		ctp.Select_Department();
		
		for(int i=1;i<=5;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		
		Thread.sleep(3000);
		//Select Coursing
		ctp.Select_Coursing();
		
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		
		Thread.sleep(3000);
		//Select Item Service Level
		ctp.Select_ServingSizeLevel();
		
		for(int i=1;i<=2;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		
		Thread.sleep(1000);
		//Select Roles
		ctp.Select_Roles();
		
		//Select Tare Group
//		ctp.Select_TareGroup();
		
		//Enable Inherited Default Tax Settings
//		ctp.Enable_DefaultTaxSettings();
		
		Thread.sleep(1000);
		//Select Tax
		ctp.Create_Category_NewTax(Utility.getProperty("Category_Add_Tax_Name"));
		Thread.sleep(2000);
		ctp.Select_Taxes();
		
		Thread.sleep(1000);
		//Select Item Service Charge
		ctp.Select_ItemServiceCharge();
		 
		//Select Always
		at.Click_AlwaysButton();
		
		//Select Hide In POS
		ctp.Select_HideinPOS();
		
		//Select Hide in Online Order
		ctp.Select_HideinOnlineOrder();
		
		//Select Hide in Kiosk
		ctp.Select_HideinKiosk();
		
		//Select Conversational
		ctp.Select_Conversational();
		
		//Select Kitchen Printer
		ctp.Select_KitchenPrinter();
		
		//Select Label Printer
		ctp.Select_LabelPrinter();
		
		//Select Restrict Printer
		ctp.Select_RestrictPrinter();
				
				
		Thread.sleep(2000);
		//Click the Save and Publish button
		cmp.Click_Save_and_PublishButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Category Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Saved Successfully. Store data publish is starting"))
		{
			test.log(LogStatus.PASS, "New Category Saved and Published Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Category Save and Publish Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Categories(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ctp=new CategoriesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		
		
		Thread.sleep(60000);
		//Search the Categories to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("Category_Name"));
		
		Thread.sleep(1000);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Category");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_BackspaceButton();
		
		Thread.sleep(1000);
		//Check whether the New Category Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Category Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Category not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Categories_DaysOfWeek(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ctp=new CategoriesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
	
		Thread.sleep(60000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBoxTwo();
	
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Category_Name"));
		
		
		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName("");
		
		
		Thread.sleep(2000);
		if(cmp.Update_and_PublishButton().isEnabled())
		{
		//Click the Save button
				cmp.Click_Update_and_PublishButton();
				
//				Thread.sleep(2000);
				cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
				//Check whether the New Tax Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Saved and Published Successfully"))
				{
					test.log(LogStatus.FAIL, "Category Updated successfully for Item Tax (Amount) without Name");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
					
					Thread.sleep(6000);
					//Search and Click Edit button
					cmp.SearchAndClickEdit(Utility.getProperty("Category_Name"));
					
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Saved and Published Successfully"))
				{
					test.log(LogStatus.FAIL, "Category Updated successfully for Item Tax (Amount) without Name");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
					
					Thread.sleep(6000);
					//Search and Click Edit button
					cmp.SearchAndClickEdit(Utility.getProperty("Category_Name"));
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Name"))
				{
					test.log(LogStatus.PASS, "Please Enter Name Pop up Displayed");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
					
				}
				
					
				}
		
		else
		{
			test.log(LogStatus.PASS, "Save and Publish button not Enabled without Entering Name");
		}
		
		Thread.sleep(3000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Category_Name")+"1");
		
		Thread.sleep(1000);
		//Select Department
		ctp.Select_Department();
		
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		
		Thread.sleep(1000);
		//Select Coursing
		ctp.Select_Coursing();
		
		//Select Roles
		ctp.Select_Roles();
		
		//Select Tare Group
		ctp.Select_TareGroup();
		
		
		//Enable Inherited Default Tax Settings
		ctp.Disable_DefaultTaxSettings();

//		for(int i=1;i<=3;i++)
//		{
			Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		

		//Select Days of Week
		at.Select_DaysOfWeek();
		
		//Select Restriction Time
		at.Enter_RestrictionTime();
		
		//Select Available Time
		at.Enter_AvailableTime();
		
		//Disable Hide in POS
		ctp.DeSelect_HideinPOS();
		
		//Disable Hide In Online Order
		ctp.DeSelect_HideinOnlineOrder();
		
		Thread.sleep(2000);
		if(cmp.Update_and_PublishButton().isEnabled())
		{
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Category Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Updated Successfully. Store data publish is starting"))
		{
			test.log(LogStatus.PASS, "New Category updated and Publish successfully for Days of Week");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Category updated fail for Days of Week");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.FAIL, "Category not updated to Days of Week due to Update button is not Enabled");
		}
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Categories_DaysOfMonth(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ctp=new CategoriesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
	
		Thread.sleep(60000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Category_Name")+"1");
		
		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Category_Name")+"1");
		
		Thread.sleep(1000);
		//Select Department
		ctp.Select_Department();
		
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		
		Thread.sleep(1000);
		//Select Coursing
		ctp.Select_Coursing();
		
		//Select Roles
		ctp.Select_Roles();
		
		//Select Tare Group
		ctp.Select_TareGroup();
		
		
		//Enable Inherited Default Tax Settings
		ctp.Disable_DefaultTaxSettings();
		

		//Select Days of Week
		at.Select_DaysOfMonth();
		
		//Select Restriction Time
		at.Enter_RestrictionTime();
		
		//Select Available Time
		at.Enter_AvailableTime();
		
		//Disable Hide in Kiosk
		ctp.DeSelect_HideinKiosk();
		
		Thread.sleep(1000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Category Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Updated Successfully. Store data publish is starting"))
		{
			test.log(LogStatus.PASS, "New Category updated and Publish successfully for Days of Month");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Category updated fail for Days of Month");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Categories_DateRange(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ctp=new CategoriesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
	
		Thread.sleep(6000);
		
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Category_Name")+"1");
		
		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Category_Name"));
		
		Thread.sleep(1000);
		//Select Department
		ctp.Select_Department();
		
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		
		Thread.sleep(1000);
		//Select Coursing
		ctp.Select_Coursing();
		
		//Select Roles
		ctp.Select_Roles();
		
		//Select Tare Group
		ctp.Select_TareGroup();
		
		
		//Enable Inherited Default Tax Settings
		ctp.Enable_DefaultTaxSettings();
		

		//Select Days of Week
		at.Select_DateRange();
		
		//Disable Conversational
		ctp.DeSelect_Conversational();
		
		Thread.sleep(1000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Category Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Updated Successfully. Store data publish is starting"))
		{
			test.log(LogStatus.PASS, "New Category updated and Publish successfully for Date Range");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Category updated fail for Date Range");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Categories_Specific_Date(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ctp=new CategoriesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
	
		Thread.sleep(6000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Category_Name"));
		
		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Category_Name"));
		
		Thread.sleep(1000);
		//Select Department
		ctp.Select_Department();
		
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		
		Thread.sleep(1000);
		//Select Coursing
		ctp.Select_Coursing();
		
		//Select Roles
		ctp.Select_Roles();
		
		//Select Tare Group
		ctp.Select_TareGroup();

		for(int i=1;i<=3;i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
	
		
		//Select Days of Week
		at.Select_SpecificDate();
		
		Thread.sleep(1000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Category Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Updated Successfully. Store data publish is starting"))
		{
			test.log(LogStatus.PASS, "New Category updated and Publish successfully for Specific Date");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Category updated fail for Specific Date");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Categories_DateRangeWithTime(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ctp=new CategoriesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
	
		Thread.sleep(6000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Category_Name"));
		
		Thread.sleep(2000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Category_Name"));
//
		
//		cmp.Cursor_MoveToElement(at.DateRangeWithTime_Availabilty());
		for(int i=1;i<=6;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
//		
		Thread.sleep(2000);
		//Select Days of Week
		at.Select_DateRangeWithTime();
		
		Thread.sleep(1000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Category Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Updated Successfully. Store data publish is starting"))
		{
			test.log(LogStatus.PASS, "New Category updated and Publish successfully for Date Range with Time");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
//		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error(s)"))
//		{
//			test.log(LogStatus.FAIL, "Validation Error Displayed ");
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			
//			Thread.sleep(1000);
//			cmp.Click_BackspaceButton();
//			
//		}
		else
		{
			test.log(LogStatus.FAIL, "New Category updated fail for Date Range with Time");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}

	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Categories(WebDriver driver) throws Exception
	{
		Thread.sleep(1000);
		
		cmp=new Common_XPaths(driver, test);
		ctp=new CategoriesPage(driver, test);
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Category_Name"));
		
		Thread.sleep(1000);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Category Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Category not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Category_Name"));
		
		Thread.sleep(1000);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Category Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Category Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Category Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("Category_Name"));
		
		Thread.sleep(1000);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		try
		{
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Activated Successfully"))
		{
			test.log(LogStatus.FAIL, "Category Activated when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Category not Activated when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		Thread.holdsLock(1000);
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("Category_Name"));
		
		Thread.sleep(1000);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Category Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Category activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Category activated Failed");
			
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
	public void Create_DuplicateCategory(WebDriver driver) throws Exception
	{
		ctp=new CategoriesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Categories button
		ctp.Click_NewCategory();
		Thread.sleep(2000);
	
		Thread.sleep(1000);
		//Enter the existing Category name
		cmp.EnterName(Utility.getProperty("Category_Name"));
		
		//Enter Department
		ctp.Select_Department();
		
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		
		//Select Coursing
		ctp.Select_Coursing();
		
		//Select Serving Size Level
		ctp.Select_ServingSizeLevel();
	
		Thread.sleep(2000);
		//Click the Save and Publish button
		cmp.Click_Save_and_PublishButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Category Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Category Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_BackspaceButton();
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Saved Successfully. Store data publish is starting"))
		{
			test.log(LogStatus.FAIL, "Duplicate Category Saved");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Category Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
}
