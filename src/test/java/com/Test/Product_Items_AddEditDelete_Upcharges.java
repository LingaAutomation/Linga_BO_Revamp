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
import com.Pages.UpchargesPage;
import com.Pages.LoginPage;
import com.Pages.TaxesPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_Upcharges {
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete Upcharges");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	Availability_RestrictionTimePage at;
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	UpchargesPage ucp;
	TaxesPage tp;
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
//		//Call the chrome driver
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
		
		Thread.sleep(35000);
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
		Open_Upcharges_Page(driver);
		RefreshAndPaginination(driver);
		Add_Upcharges(driver);
		Edit_and_Close_Cancel_Upcharges(driver);
		Edit_and_Update_Upcharges_Percentage(driver);
		Edit_and_Update_SubCategory_Upcharges(driver);
		Edit_and_Update_MenuItem_Upcharges(driver);
		Edit_and_Update_Upcharges_DaysOfWeek(driver);
		Edit_and_Update_Upcharges_DaysOfMonth(driver);
		Edit_and_Update_Upcharges_DateRange(driver);
		Edit_and_Update_Upcharges_Specific_Date(driver);
		Edit_and_Update_Upcharges_DateRangeWithTime(driver);
		Delete_and_Active_Inactive_Upcharges(driver);
		Create_DuplicateUpcharge(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Upcharges_Page(WebDriver driver) throws Exception
	{
		
		ucp=new UpchargesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Upcharge page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"upCharges");

		Thread.sleep(5000);
		//Verify the Upcharges page loeded or not
		cmp.VerifyMainScreenPageHeader("UpCharges");	
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
	public void Add_Upcharges(WebDriver driver) throws Exception
	{
		ucp=new UpchargesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		tp=new TaxesPage(driver, test);
		
		
		Thread.sleep(2000);
		//Click the New Upcharges
		ucp.Click_NewUpcharge();
		Thread.sleep(35000);
	
		//Verify the New Upcharge creation screen opened or not
		cmp.VerifyCreationScreenPageHeader_Two("New Upcharge");
		Thread.sleep(5000);
		
		if(cmp.Save_and_PublishButton().isEnabled())
		{
		//Click Save and Publish button
		cmp.Click_Save_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Department Saved or not
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
			test.log(LogStatus.INFO, "Save and Publish button not Enabled without Entering Upcharge Name");
		}
		
		Thread.sleep(1000);
		//Enter the Upcharge Name
		cmp.EnterName(Utility.getProperty("UpChargeName"));
		
		if(cmp.Save_and_PublishButton().isEnabled())
		{
		Thread.sleep(1000);
		//Click Save and Publish button
		cmp.Click_Save_and_PublishButton();
				
				Thread.sleep(3000);
				//Check whether the New Department Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter The Amount"))
				{
					test.log(LogStatus.PASS, "Please Enter The Amount Alert Displayed");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Please Enter The Amount Alert not Displayed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
		
		}
		else
		{
			test.log(LogStatus.INFO, "Save and Publish button is not Enabled without Entering Amount");
		}
				Thread.sleep(1000);
		//Click the percentage
		ucp.Click_Percentage_inUpcharge();
		Thread.sleep(1000);

		if(cmp.Save_and_PublishButton().isEnabled())
		{
		//Click Save and Publish button
		cmp.Click_Save_and_PublishButton();
				
				Thread.sleep(3000);
				//Check whether the New Department Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter The Percentage"))
				{
					test.log(LogStatus.PASS, "Please Enter The Percentage Alert Displayed");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Please Enter The Percentage Alert not Displayed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
		}
		else
		{
			test.log(LogStatus.INFO, "Save and Publish button is not Enabled without Entering Percentage");
		}
				Thread.sleep(500);
				//Select Upcharge Type as Amount
				ucp.Click_Amount_inUpcharge();
				Thread.sleep(500);

				//Enter the Amount values
				tp.Enter_AmountBox("1000");
				Thread.sleep(500);

				if(cmp.Save_and_PublishButton().isEnabled())
				{
				//Click Save and Publish button
				cmp.Click_Save_and_PublishButton();
				Thread.sleep(500);
		
						Thread.sleep(3000);
						//Check whether the New Department Saved or not
						if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Select Categories"))
						{
							test.log(LogStatus.PASS, "Please Select Categories Alert Displayed");
						
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
						}
						else
						{
							test.log(LogStatus.FAIL, "Please Select Categories Alert not Displayed");
							
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
				}
				else
				{
					test.log(LogStatus.INFO, "Save and Publish button is not Enabled without Selecting Categories");
				}
						
						
						for(int i=1;i<=5;i++)
						{
							Thread.sleep(1000);
							driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
						}
						
						Thread.sleep(500);
		//Click and Select Category Level
		ucp.Select_CategoryType();
		Thread.sleep(500);

		//Select Always
		at.Click_AlwaysButton();
		Thread.sleep(500);
	
		//Select Hide In POS
		ucp.Enable_RestrictPOSVisiblity();
				
				
		Thread.sleep(2000);
		//Click the Save and Publish button
		cmp.Click_Save_and_PublishButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Upcharge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Saved Successfully"))
		{
			test.log(LogStatus.PASS, "New Upcharge Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Upcharge Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Upcharges(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ucp=new UpchargesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		
		
		Thread.sleep(10000);
		//Search the Upcharges to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("UpChargeName"));
		
		Thread.sleep(35000);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader_Two("Update Upcharge");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_BackspaceButton();
		
		Thread.sleep(1000);
		//Check whether the New Upcharge Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Upcharge Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Upcharge not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Upcharges_Percentage(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ucp=new UpchargesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		tp=new TaxesPage(driver, test);

		Thread.sleep(10000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
	
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("UpChargeName"));
		
		Thread.sleep(35000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("UpChargeName")+"1");
		
		Thread.sleep(500);
		//Select Upcharge type as percentage
		ucp.Click_Percentage_inUpcharge();
		Thread.sleep(500);

		//Enter percentage
//		tp.Enter_Percentage("1000"); Remove it
		tp.Enter_AmountBox("10000");
		Thread.sleep(500);
	
		//Enable Include Additional modifeirs toggle
		ucp.Enable_IncludeAdditionalModifiers();
		
		Thread.sleep(500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Upcharge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Upcharge updated successfully for Percentage");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Upcharge updated fail for Percentage");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_SubCategory_Upcharges(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ucp=new UpchargesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		tp=new TaxesPage(driver, test);

		Thread.sleep(35000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("UpChargeName")+"1");
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("UpChargeName"));
		
		Thread.sleep(500);
		//Select Upcharge type as percentage
		ucp.Click_Percentage_inUpcharge();
		Thread.sleep(500);

		//Enter percentage
//		tp.Enter_Percentage("2000");  -Remove it
		tp.Enter_AmountBox("20000");
		Thread.sleep(500);

		//Enable Include Additional modifeirs toggle
		ucp.Enable_IncludeAdditionalModifiers();
		Thread.sleep(500);

		for(int i=1;i<=5;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		Thread.sleep(1000);
		//Select Sub Category level
		ucp.Select_SubCategoryType();
		
		Thread.sleep(500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Upcharge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Upcharge updated successfully to Sub Category");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Upcharge updated fail to Sub Category");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_MenuItem_Upcharges(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ucp=new UpchargesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		tp=new TaxesPage(driver, test);

		Thread.sleep(10000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("UpChargeName"));
		
		Thread.sleep(3000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("UpChargeName")+"1");
		
		Thread.sleep(1000);
		//Select Upcharge type as percentage
		ucp.Click_Percentage_inUpcharge();
		Thread.sleep(500);

		//Enter percentage
//		tp.Enter_Percentage("2000"); Remove it
		tp.Enter_AmountBox("20000");
		Thread.sleep(500);

		//Enable Include Additional modifeirs toggle
		ucp.Enable_IncludeAdditionalModifiers();
		Thread.sleep(2000);

		for(int i=1;i<=5;i++)
		{
			Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}

		Thread.sleep(2000);
		//Select Sub Category level
		ucp.Select_MenuItemType();
		Thread.sleep(1500);

		Thread.sleep(1500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Upcharge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Upcharge updated successfully to Menu Item");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Upcharge updated fail to Menu Item");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Upcharges_DaysOfWeek(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ucp=new UpchargesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		tp=new TaxesPage(driver, test);

		Thread.sleep(10000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("UpChargeName")+"1");
		
		Thread.sleep(5000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("UpChargeName"));
		
		Thread.sleep(500);
		//Update percentage
//		tp.Enter_Percentage("3000"); Remove it
		tp.Enter_AmountBox("30000");
		
		//Disable Include Additional modifiers
		ucp.Disable_IncludeAdditionalModifiers();
		Thread.sleep(1000);

		for(int i=1;i<3;i++)
		{
			Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		Thread.sleep(2000);
		//Select Category
		ucp.Select_CategoryType();
		Thread.sleep(1000);

		//Select Days of Week
		at.Select_DaysOfWeek();
		Thread.sleep(1000);

		//Select Restriction Time
		at.Enter_RestrictionTime();
		Thread.sleep(1500);

		//Select Available Time
//		at.Enter_AvailableTime();
		Thread.sleep(1500);

		//Disable Hide in POS
		ucp.Disable_RestrictPOSVisiblity();
		
		Thread.sleep(2000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Upcharge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Upcharge updated successfully for Days of Week");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Upcharge updated fail for Days of Week");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Upcharges_DaysOfMonth(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ucp=new UpchargesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		tp=new TaxesPage(driver, test);

		Thread.sleep(35000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("UpChargeName"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("UpChargeName"));
		
		Thread.sleep(500);
		//Select Days of month
		at.Select_DaysOfMonth();
		Thread.sleep(500);

		//Select Restriction Time
		at.Enter_RestrictionTime();
		Thread.sleep(500);

		//Select Available Time
//		at.Enter_AvailableTime();
		
		Thread.sleep(500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Upcharge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Upcharge updated successfully for Days of Month");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Upcharge updated fail for Days of Month");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Upcharges_DateRange(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ucp=new UpchargesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		tp=new TaxesPage(driver, test);

		Thread.sleep(10000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("UpChargeName"));
		
		Thread.sleep(35000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("UpChargeName"));
		Thread.sleep(500);

		//Select Days of Week
		at.Select_DateRange();
		
		Thread.sleep(500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Upcharge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Upcharge updated successfully for Date Range");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Upcharge updated fail for Date Range");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Upcharges_Specific_Date(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ucp=new UpchargesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		tp=new TaxesPage(driver, test);

		Thread.sleep(10000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("UpChargeName"));
		
		Thread.sleep(35000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("UpChargeName"));
		Thread.sleep(500);

		for(int i=1;i<=7;i++)
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);
		}
	

		Thread.sleep(1000);
		//Select Days of Week
		at.Select_SpecificDate();
		
		Thread.sleep(2000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Upcharge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Upcharge updated successfully for Specific Date");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Upcharge updated fail for Specific Date");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Upcharges_DateRangeWithTime(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ucp=new UpchargesPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		tp=new TaxesPage(driver, test);

		Thread.sleep(10000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("UpChargeName"));
		
		Thread.sleep(35000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("UpChargeName"));
		Thread.sleep(1000);

		//Select Days of Week
		at.Select_DateRangeWithTime();
		
		Thread.sleep(500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Upcharge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Upcharge updated successfully for Date Range with Time");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Select start time"))
		{
			test.log(LogStatus.FAIL, "Select start time displays even when Start Time is already selected");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_BackspaceButton();
		
		}
		else
		{
			test.log(LogStatus.FAIL, "New Upcharge updated fail for Date Range with Time");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}

	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Upcharges(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		ucp=new UpchargesPage(driver, test);
		Thread.sleep(10000);
		//Search and Click Delete button
				cmp.SearchAndClickDelete(Utility.getProperty("UpChargeName"));
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();

				Thread.sleep(3000);
				try
				{
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Upcharge Inactivated Successfully"))
				{
					test.log(LogStatus.FAIL, "Upcharge Deleted when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Upcharge not Deleted when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("UpChargeName"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Upcharge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Upcharge Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Upcharge Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Upcharge Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("UpChargeName"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		try
		{
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Upcharge Activated Successfully"))
		{
			test.log(LogStatus.FAIL, "Upcharge Activated when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Upcharge not Activated when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}



		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("UpChargeName"));
		
		Thread.sleep(500);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Upcharge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Upcharge Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Upcharge activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Upcharge activated Failed");
			
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
	public void Create_DuplicateUpcharge(WebDriver driver) throws Exception
	{
		ucp=new UpchargesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		tp=new TaxesPage(driver, test);

		Thread.sleep(10000);
		//Click the New Upcharges button
		ucp.Click_NewUpcharge();
		Thread.sleep(2000);
	
		Thread.sleep(500);
		//Enter the existing Upcharge name
		cmp.EnterName(Utility.getProperty("UpChargeName"));
		
		//Enter Department
		tp.Enter_AmountBox("5000");
		

		for(int i=1;i<=5;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		//Select Coursing
		ucp.Select_CategoryType();
	
		Thread.sleep(2000);
		//Click the Save and Publish button
		cmp.Click_Save_and_PublishButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Upcharge Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Upcharge Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Upcharge Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
}
