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
import com.Pages.SubCategoriesPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_SubCategories {
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete Sub-Categories");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	Availability_RestrictionTimePage at;
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	CategoriesPage ctp;
	SubCategoriesPage sctp;
	
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
		Open_SubCategories_Page(driver);
     	RefreshAndPaginination(driver);
		Add_SubCategories(driver);
		Edit_and_Close_Cancel_SubCategories(driver);
		Edit_and_Update_SubCategories_DaysOfWeek(driver);
		Edit_and_Update_SubCategories_DaysOfMonth(driver);
		Edit_and_Update_SubCategories_DateRange(driver);
		Edit_and_Update_SubCategories_Specific_Date(driver);
		Edit_and_Update_SubCategories_DateRangeWithTime(driver);
		Delete_and_Active_Inactive_SubCategories(driver);
		Create_DuplicateSubCategory(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_SubCategories_Page(WebDriver driver) throws Exception
	{
		
		ctp=new CategoriesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		sctp=new SubCategoriesPage(driver, test);
		Thread.sleep(5000);
		//Load the Sub-Categories page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"subCategories");

		Thread.sleep(5000);
		//Verify the Sub-Categories page loaSded or not
		cmp.VerifyMainScreenPageHeader("Sub Categories");	
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
	public void Add_SubCategories(WebDriver driver) throws Exception
	{
		ctp=new CategoriesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		sctp=new SubCategoriesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Sub-Category
		sctp.Click_NewSubCategory();
		Thread.sleep(5000);
	
		//Verify the New Sub-Category creation screen opened or not
		cmp.VerifyCreationScreenPageHeader_Two("New Sub Category");
		Thread.sleep(2000);
		
		if(cmp.Save_and_PublishButton().isEnabled())
		{
		//Click the Save button
				cmp.Click_Save_and_PublishButton();
				
				Thread.sleep(3000);
				//Check whether the New Tax Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub-Category saved successfully. Store data publish is starting"))
				{
					test.log(LogStatus.FAIL, "Sub-Category saved successfully for Item Tax (Amount) without Name");
				
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
		
		
		Thread.sleep(1000);
		//Enter the Sub-Category Name
		cmp.EnterName(Utility.getProperty("Sub_Category_Name"));
		
		Thread.sleep(1000);
		//Select Coursing
		ctp.Select_Coursing();
		
		Thread.sleep(1000);
		//Select Category
		sctp.Select_Category();
		
		Thread.sleep(1000);
		//Select Default Service Level
		sctp.Select_DefaultServingSize();
//		ctp.Select_ServingSizeLevel();
		
//		//Select Tare Group
//		ctp.Select_TareGroup();
//		
//		//Enable Inherited Default Tax Settings
//		ctp.Enable_DefaultTaxSettings();
		
		
		Thread.sleep(1000);
		//Select Tax
		ctp.Create_Category_NewTax(Utility.getProperty("Sub_Category_Add_Tax_Name"));
		
		Thread.sleep(2000);
		//Select Taxes
		ctp.Select_Taxes();

		
		//Select Item Service Charge
//		ctp.Select_ItemServiceCharge();
		
		Thread.sleep(1000);
		//Select Always
		at.Click_AlwaysButton();
		
		Thread.sleep(1000);
		//Select Hide In POS
		ctp.Select_HideinPOS();
		
		Thread.sleep(1000);
		//Select Hide in Online Order
		ctp.Select_HideinOnlineOrder();
		
		Thread.sleep(1000);
		//Select Hide in Kiosk
		ctp.Select_HideinKiosk();
		
		Thread.sleep(1000);
		//Select Conversational
		ctp.Select_Conversational();
		
		//Select Kitchen Printer
		ctp.Select_KitchenPrinter();
		
		Thread.sleep(1000);
		//Select Label Printer
		ctp.Select_LabelPrinter();
		
		Thread.sleep(1000);
		//Select Restrict Printer
		ctp.Select_RestrictPrinter();
		
//		//Upload picture
//		cmp.Upload_Picture(Utility.getProperty("Settings_Store_Information_Store_Image_Path"));
	
		Thread.sleep(2000);
		//Click the Save and Publish button
		cmp.Click_Save_and_PublishButton();
		try {
		sctp.Random_color_option();
		
		
		
		Thread.sleep(2000);
		//Click the Save and Publish button
		cmp.Click_Save_and_PublishButton();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		//Check whether the New Category Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub-Category Saved Successfully"))
		{
			test.log(LogStatus.PASS, "New Sub-Category Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Sub-Category Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_SubCategories(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ctp=new CategoriesPage(driver, test);
		sctp=new SubCategoriesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		
		
		Thread.sleep(30000);
		//Search the Sub-Categories to Click Edit and Cancel
		sctp.SearchAndClickEdit(Utility.getProperty("Sub_Category_Name"));
		
		Thread.sleep(1000);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader_Two("Update Sub Category");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_BackspaceButton();
		
		Thread.sleep(1000);
		//Check whether the New Category Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Sub-Category Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub-Category not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_SubCategories_DaysOfWeek(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ctp=new CategoriesPage(driver, test);
		sctp=new SubCategoriesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
	
		
		Thread.sleep(30000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBoxTwo();
	
		
		Thread.sleep(1000);
		//Search and Click Edit button
		sctp.SearchAndClickEdit(Utility.getProperty("Sub_Category_Name"));
		
		
		Thread.sleep(2000);
		//Enter the Name
		cmp.EnterName("");
		
		
		if(cmp.Update_and_PublishButton().isEnabled())
		{
		//Click the Save button
				cmp.Click_Update_and_PublishButton();
				
				Thread.sleep(3000);
				//Check whether the New Tax Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub-Category Updated Successfully"))
				{
					test.log(LogStatus.FAIL, "Sub-Category Updated successfully for Item Tax (Amount) without Name");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
					
					Thread.sleep(2000);
					//Search and Click Edit button
					sctp.SearchAndClickEdit(Utility.getProperty("Sub_Category_Name"));
					
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
		
		
	
		Thread.sleep(2000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Sub_Category_Name")+"1");
		
		Thread.sleep(1000);
		//Select Coursing
		ctp.Select_Coursing();
		
		Thread.sleep(1000);
		//Select Category
		sctp.Select_Category();
		
		Thread.sleep(1000);
		//Deselect Default Serving Size Level
//		sctp.DeSelect_DefaultServingSize();
		
		Thread.sleep(1000);
		//Select the Serving Size Level
//		ctp.Select_ServingSizeLevel();
		
		Thread.sleep(1000);
		//Select Tare Group
		ctp.Select_TareGroup();
		
		
		//Enable Inherited Default Tax Settings
		ctp.Disable_DefaultTaxSettings();
		

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
		
		Thread.sleep(1000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Category Updated or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub-Category Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Sub-Category updated successfully for Days of Week");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Sub-Category updated fail for Days of Week");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_SubCategories_DaysOfMonth(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ctp=new CategoriesPage(driver, test);
		sctp=new SubCategoriesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
	
		Thread.sleep(30000);
		//Search and Click Edit button
		sctp.SearchAndClickEdit(Utility.getProperty("Sub_Category_Name")+"1");
		
		Thread.sleep(2000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Sub_Category_Name"));
		
		Thread.sleep(1000);
		//Select Coursing
		ctp.Select_Coursing();
		
		//Select Category
		sctp.Select_Category();
		
		
		//Select Tare Group
		ctp.Select_TareGroup();
		
		
		//Enable Inherited Default Tax Settings
		ctp.Disable_DefaultTaxSettings();
		
		Thread.sleep(1000);
		//Select Days of month
		at.Select_DaysOfMonth();
		
		Thread.sleep(1000);
		//Select Restriction Time
		at.Enter_RestrictionTime();
			
		Thread.sleep(1000);
		//Select Available Time
		at.Enter_AvailableTime();
				
		Thread.sleep(1000);
		//Disable Hide in Kiosk
		ctp.DeSelect_HideinKiosk();
		
		Thread.sleep(1000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Sub-Category Updated or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub-Category Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Sub-Category updated successfully for Days of Month");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Sub-Category updated fail for Days of Month");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_SubCategories_DateRange(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ctp=new CategoriesPage(driver, test);
		sctp=new SubCategoriesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
	
		Thread.sleep(30000);
		//Search and Click Edit button
		sctp.SearchAndClickEdit(Utility.getProperty("Sub_Category_Name"));
		
		Thread.sleep(2000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Sub_Category_Name"));
		
		Thread.sleep(1000);
		//Select Coursing
		ctp.Select_Coursing();
		
		//Select Category
		sctp.Select_Category();
		
		//Select Tare Group
//		ctp.Select_TareGroup();
		
		
		
		
		//Enable Inherited Default Tax Settings
		ctp.Enable_DefaultTaxSettings();
		
		Thread.sleep(2000);
		//Select Date Range
		at.Select_DateRange();
		
		Thread.sleep(1000);
		//Disable Conversational
		ctp.DeSelect_Conversational();
		
		Thread.sleep(1000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Sub-Category Updated or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub-Category Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Sub-Category updated successfully for Date Range");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Sub-Category updated fail for Date Range");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_SubCategories_Specific_Date(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ctp=new CategoriesPage(driver, test);
		sctp=new SubCategoriesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
	
		Thread.sleep(30000);
		//Search and Click Edit button
		sctp.SearchAndClickEdit(Utility.getProperty("Sub_Category_Name"));
		
		Thread.sleep(2000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Sub_Category_Name"));
	
		Thread.sleep(1000);
		//Select Coursing
		ctp.Select_Coursing();
		
		//Select Category
		sctp.Select_Category();
		
		//Select Tare Group
		ctp.Select_TareGroup();

		//Select Days of Week
		at.Select_SpecificDate();
		
		Thread.sleep(1000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Sub-Category Updated or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub-Category Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Sub-Category updated successfully for Specific Date");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Sub-Category updated fail for Specific Date");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_SubCategories_DateRangeWithTime(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ctp=new CategoriesPage(driver, test);
		sctp=new SubCategoriesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
	
		Thread.sleep(30000);
		//Search and Click Edit button
		sctp.SearchAndClickEdit(Utility.getProperty("Sub_Category_Name"));
		
		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Sub_Category_Name"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);

		
		Thread.sleep(1000);
		//Select Date with Time
		at.Select_DateRangeWithTime();
		
		Thread.sleep(1000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Sub-Category Updated or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub-Category Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Sub-Category updated successfully for Date Range with Time");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Sub-Category updated fail for Date Range with Time");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}

	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_SubCategories(WebDriver driver) throws Exception
	{
		Thread.sleep(1000);
		
		cmp=new Common_XPaths(driver, test);
		ctp=new CategoriesPage(driver, test);
		sctp=new SubCategoriesPage(driver, test);
		
		//Search and Click Delete button
		sctp.SearchAndClickDelete(Utility.getProperty("Sub_Category_Name"));
		
		Thread.sleep(1000);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub-Category Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Sub-Category Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Sub-Category not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		//Search and Click Delete button
		sctp.SearchAndClickDelete(Utility.getProperty("Sub_Category_Name"));
		
		Thread.sleep(1000);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Category Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub-Category Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Sub-Category Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub-Category Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("Sub_Category_Name"));
		
		Thread.sleep(1000);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		try
		{
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub-Category Activated Successfully"))
		{
			test.log(LogStatus.FAIL, "Sub-Category Activated when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Sub-Category not Activated when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		
		//Search and Activate the In activated item
		sctp.SearchAndClickActivate(Utility.getProperty("Sub_Category_Name"));
		
		Thread.sleep(1000);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Category Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub-Category Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Sub-Category activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub-Category activated Failed");
			
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
	public void Create_DuplicateSubCategory(WebDriver driver) throws Exception
	{
		ctp=new CategoriesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		sctp=new SubCategoriesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Sub-Categories button
		sctp.Click_NewSubCategory();
		Thread.sleep(2000);
	
		Thread.sleep(1000);
		//Enter the existing Sub-Category name
		cmp.EnterName(Utility.getProperty("Sub_Category_Name"));
		
		Thread.sleep(1000);
		//Select Coursing
		ctp.Select_Coursing();
		
		Thread.sleep(1000);
		//Select Category
		sctp.Select_Category();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		
		Thread.sleep(1000);
		//Select Serving Size Level
		ctp.Select_ServingSizeLevel();
		
		Thread.sleep(1000);
		//Select Taxes
		ctp.Select_Taxes();
		
	
		Thread.sleep(2000);
		//Click the Save and Publish button
		cmp.Click_Save_and_PublishButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Sub-Category Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Category Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_BackspaceButton();
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub-Category Saved Successfully"))
		{
			test.log(LogStatus.FAIL, "Duplicate Sub Category Saved");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Category Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
}
