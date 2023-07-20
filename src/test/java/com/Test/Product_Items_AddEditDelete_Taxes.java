package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.Common_XPaths;
import com.Pages.TaxesPage;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_Taxes {
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete Taxes");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
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
		
		Thread.sleep(50000);
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
		Open_Taxes_Page(driver);
		RefreshAndPaginination(driver);
		Add_ItemTax_Amount(driver);
		Add_ItemTax_Percentage(driver);
		Add_CheckTax(driver);
		Add_TaxOnItemTax(driver);
		Add_TaxOnCheckTax(driver);
		Edit_and_Close_Cancel_Taxes(driver);
		Edit_and_Update_ItemTax(driver);
		Edit_and_Update_CheckTax(driver);
		Edit_and_Update_Tax_On_Item_Tax(driver);
		Edit_and_Update_Tax_On_Check_Tax(driver);
		Delete_and_Active_Inactive_Taxes(driver);
		Create_Duplicate_Tax(driver);
//		Add_Tax_For_Tax_Per_ServiceType(driver);
//		Edit_and_Update_Tax_Per_ServiceType(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Taxes_Page(WebDriver driver) throws Exception
	{
		
		tp=new TaxesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(8000);
		//Load the Tax page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"taxes");

		Thread.sleep(8000);
		//Verify the Taxes page loaded or not
		cmp.VerifyMainScreenPageHeader("Taxes");	
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
	public void Add_ItemTax_Amount(WebDriver driver) throws Exception
	{
		tp=new TaxesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(8000);
		//Click the New Taxes
		tp.Click_NewTaxButton();
		Thread.sleep(2000);
	
		//Verify the New Tax creation screen opened or not
		cmp.VerifyCreationScreenPageHeader_Two("New Tax");
		Thread.sleep(2000);
		
		if(cmp.Save_and_PublishButton().isEnabled())
		{
		//Click the Save button
				cmp.Click_Save_and_PublishButton();
				
				Thread.sleep(3000);
				//Check whether the New Tax Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Saved Successfully and Store data published successfully"))
				{
					test.log(LogStatus.FAIL, "Tax saved successfully for Item Tax (Amount) without Name");
				
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
		//Enter the Tax name
		tp.Enter_ItemTax_Amount(Utility.getProperty("Item_Tax_Amount_Name"));
		
		//Click the Save button
		cmp.Click_Save_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Tax Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Saved Successfully and Store data published successfully"))
		{
			test.log(LogStatus.PASS, "Tax saved and Published successfully for Item Tax (Amount)");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax saved and Publish Failed for Item Tax(Amount)");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_ItemTax_Percentage(WebDriver driver) throws Exception
	{
		tp=new TaxesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(50000);
		//Click the New Taxes
		tp.Click_NewTaxButton();
		Thread.sleep(2000);
	
		//Verify the New Tax creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Tax");
		Thread.sleep(2000);
		
	
		//Click the Item Tax as Percentage button
		tp.Enter_ItemTax_Percentage(Utility.getProperty("Item_Tax_Name"));
		
		Thread.sleep(500);
		//Enable Inclusive Tax
		tp.Select_InclusiveTax();
		
		//Enable Default Tax
		tp.Select_DefaultTax();
		
		//Enable Quantity Based
		tp.Select_QuantityBasedTax();
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_Save_and_PublishButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Tax Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Saved Successfully and Store data published successfully"))
		{
			test.log(LogStatus.PASS, "Tax Saved and Publish Successfully for Item Tax (Percentage)");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Save and Publish for Item Tax (Percentage) Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	
	@Test(priority = 4,enabled = false)
	public void Add_CheckTax(WebDriver driver) throws Exception
	{
		tp=new TaxesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(50000);
		//Click the New Taxes
		tp.Click_NewTaxButton();
		Thread.sleep(2000);
	
		//Verify the New Tax creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Tax");
		Thread.sleep(2000);
		
	
		//Click the Check Tax as Percentage button
		tp.Enter_CheckTax(Utility.getProperty("Check_Tax_Name"));
		
	
		Thread.sleep(3000);
		//Click the Save button
		cmp.Click_Save_and_PublishButton();
		
		
		Thread.sleep(3000);
//		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(90));
		//Check whether the New Tax Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Saved Successfully and Store data published successfully"))
		{
			test.log(LogStatus.PASS, "Tax Saved and Publish Successfully for Check Tax");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Same check amount tax is already available"))
		{
			test.log(LogStatus.INFO, "Same check amount tax is already available");
			
			Thread.sleep(1000);
			//Click Cancel button
			cmp.Click_BackspaceButton();
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Save and Publish for Check Tax Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_TaxOnItemTax(WebDriver driver) throws Exception
	{
		tp=new TaxesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(50000);
		//Click the New Taxes
		tp.Click_NewTaxButton();
		Thread.sleep(2000);
	
		//Verify the New Tax creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Tax");
		Thread.sleep(2000);
		
	
		//Click the Check Tax as Percentage button
		tp.Enter_TaxOnItemTax(Utility.getProperty("Tax_On_Item_Tax_Name"));
		
	
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_Save_and_PublishButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Tax Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Saved Successfully and Store data published successfully"))
		{
			test.log(LogStatus.PASS, "Tax Saved and Publish Successfully for Tax On Item Tax");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Save and Publish for Check Tax Failed  for Tax On Item Tax");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_TaxOnCheckTax(WebDriver driver) throws Exception
	{
		tp=new TaxesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(50000);
		//Click the New Taxes
		tp.Click_NewTaxButton();
		Thread.sleep(2000);
	
		//Verify the New Tax creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Tax");
		Thread.sleep(2000);
		
	
		//Click the Check Tax as Percentage button
		tp.Enter_TaxOnCheckTax(Utility.getProperty("Tax_On_Check_Tax_Name"));
		
	
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_Save_and_PublishButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Tax Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Saved Successfully and Store data published successfully"))
		{
			test.log(LogStatus.PASS, "Tax Saved and Published Successfully for Tax On Check Tax");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Save and Publish for Check Tax Failed  for Tax On Check Tax");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Taxes(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		tp=new TaxesPage(driver, test);
	
		
		Thread.sleep(50000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Item_Tax_Amount_Name"));
		
		Thread.sleep(2000);
		//Check whether the application displays Update screen or not
		cmp.VerifyCreationScreenPageHeader_Two("Update Tax");
		
		Thread.sleep(2000);
		//Click the Close button
		cmp.Click_BackspaceButton();
			
		Thread.sleep(1000);
		//Check whether the New Tax Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Tax screen Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax screen not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_ItemTax(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		tp=new TaxesPage(driver, test);
		
		Thread.sleep(8000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
	
		Thread.sleep(4000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Item_Tax_Name"));
		
//		if(cmp.Update_and_PublishButton().isEnabled())
//		{
//		//Click the Save button
//				cmp.Click_Update_and_PublishButton();
//				
//				Thread.sleep(3000);
//				//Check whether the New Tax Saved or not
//				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Updated Successfully and Store data published successfully"))
//				{
//					test.log(LogStatus.FAIL, "Tax Updated and Published for Item Tax (Amount) without Name");
//				
//					ut.FailedCaptureScreenshotAsBASE64(driver, test);
//				}
//				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Name"))
//				{
//					test.log(LogStatus.PASS, "Please Enter Name Pop up Displayed");
//					
//					ut.PassedCaptureScreenshotAsBASE64(driver, test);
//					
//				}
//		}
//		else
//		{
//			test.log(LogStatus.PASS, "Update and Publish button not Enabled without Entering Name");
//		}
//		
//		
//		Thread.sleep(4000);
//		//Search and Click Edit button
//		cmp.SearchAndClickEdit(Utility.getProperty("Item_Tax_Name"));
		
		
		Thread.sleep(500);
		//Enter the Name
		tp.Enter_TaxName(Utility.getProperty("Item_Tax_Name")+"1");

		//Disable Quantity Tax
				tp.DeSelect_QuantityBasedTax();
		
		//Disable Inclusive Tax
		tp.DeSelect_InclusiveTax();
		
		//Disable Default Tax
		tp.DeSelect_DefaultTax();
		
		
		
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Tax Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Updated Successfully and Store data published successfully"))
		{
			test.log(LogStatus.PASS, "Tax Updated and Published Successfully for Item Tax");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Updated Failed for Item Tax");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_CheckTax(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		tp=new TaxesPage(driver, test);
		
	try
	{
		Thread.sleep(50000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Check_Tax_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		tp.Enter_TaxName(Utility.getProperty("Check_Tax_Name")+"1");

		//Edit the percentage
	//	tp.Enter_Percentage("2000");
		
		//Change Charge amount
		tp.Enter_AmountBox("20000");
		
		//Disable Apply on Subtotal
		tp.Click_No_ApplyOnSubtotal();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Tax Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Updated Successfully and Store data published successfully"))
		{
			test.log(LogStatus.PASS, "Tax Updated and Published Successfully for Check Tax");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Same check amount tax is already available"))
		{
			test.log(LogStatus.INFO, "Same check amount tax is already available");
			
			Thread.sleep(1000);
			//Click Cancel button
			cmp.Click_BackspaceButton();
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Update and Publish for Check Tax Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	catch(Exception g)
	{
		test.log(LogStatus.INFO, "Check Tax not created due to Check Amount already available");
	}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Tax_On_Item_Tax(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		tp=new TaxesPage(driver, test);
		
	
		Thread.sleep(50000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Tax_On_Item_Tax_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		tp.Enter_TaxName(Utility.getProperty("Tax_On_Item_Tax_Name")+"1");

		//Edit the percentage
	//	tp.Enter_Percentage("2000");
		
		//Change Charge amount
		tp.Enter_Percentage("2000");
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Tax Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Updated Successfully and Store data published successfully"))
		{
			test.log(LogStatus.PASS, "Tax Updated and Published Successfully for Tax On Item Tax");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Updated Failed for Tax On Item Tax");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Tax_On_Check_Tax(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		tp=new TaxesPage(driver, test);
		
	
		Thread.sleep(50000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Tax_On_Check_Tax_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		tp.Enter_TaxName(Utility.getProperty("Tax_On_Check_Tax_Name")+"1");

		//Edit the percentage
	//	tp.Enter_Percentage("2000");
		
		//Change Charge amount
		tp.Enter_Percentage("2000");
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Tax Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Updated Successfully and Store data published successfully"))
		{
			test.log(LogStatus.PASS, "Tax Updated and Published Successfully for Tax On Check Tax");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Updated Failed for Tax On Check Tax");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Taxes(WebDriver driver) throws Exception
	{
		Thread.sleep(10000);
		
		cmp=new Common_XPaths(driver, test);
		tp=new TaxesPage(driver, test);
		
		Thread.sleep(2000);
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Item_Tax_Name")+"1");
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Tax Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Tax not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(8000);
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Item_Tax_Name")+"1");
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Tax Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Tax Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("This tax is attached with some item, so could not inactivate."))
		{
			test.log(LogStatus.INFO, "This tax is attached with some item, so could not inactivate.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("Item_Tax_Name")+"1");
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		try
		{
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Activated Successfully"))
		{
			test.log(LogStatus.FAIL, "Tax Activated when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Tax not Activated when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("Item_Tax_Name")+"1");
		
		Thread.sleep(500);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Tax Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Tax activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(driver.findElement(By.xpath("//span[contains(.,'Taxes not found')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Tax not Found while searching");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax activated Failed");
			
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
	public void Create_Duplicate_Tax(WebDriver driver) throws Exception
	{
		tp=new TaxesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Taxes button
		tp.Click_NewTaxButton();
		Thread.sleep(2000);
	
		Thread.sleep(500);
		//Enter the existing Tax name
		tp.Enter_ItemTax_Percentage(Utility.getProperty("Item_Tax_Name")+"1");
		
	
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_Save_and_PublishButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Tax Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Tax Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(1000);
			cmp.Click_BackspaceButton();
			Thread.sleep(1000);
			
		}  //Check whether the New Tax Saved or not
		 else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error(s)"))
			{
				test.log(LogStatus.PASS, "Validation Error(s) pop up displayed");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				Thread.sleep(1000);
				cmp.Click_BackspaceButton();
				Thread.sleep(1000);
				
			}
		 else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Saved Successfully and Store data published successfully"))
			{
				test.log(LogStatus.FAIL, "Duplicate Tax saved and Published");
			
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		else
		{
			test.log(LogStatus.FAIL, "Tax Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	
	@Test(priority = 6,enabled = false)
	public void Add_Tax_For_Tax_Per_ServiceType(WebDriver driver) throws Exception
	{
		tp=new TaxesPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Tax Per Service Type
		tp.Select_TaxPerServiceType_Tax();
		
		
		Thread.sleep(4000);
		//Click the New Taxes button
		tp.Click_NewTaxButton();
		Thread.sleep(2000);
	
		Thread.sleep(500);
		//Enter the existing Tax name
		cmp.EnterName(Utility.getProperty("Item_Tax_Name")+"SevType");
		
		//Enter the Percentage for All Service Type
		tp.Tax_Per_Service_Type("1000");
	
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_Save_and_PublishButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Tax Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Saved Successfully and Store data published successfully"))
		{
			test.log(LogStatus.PASS, "Tax Saved and Published Successfully for Tax Per Service Type");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Saved Failed for Tax Per Service Type");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Tax_Per_ServiceType(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		tp=new TaxesPage(driver, test);
		
	
		Thread.sleep(10000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Item_Tax_Name")+"SevType");
		
		Thread.sleep(500);
		//Enter the Name
		tp.Enter_TaxName(Utility.getProperty("Item_Tax_Name")+"SevType");

		//Disable Inclusive Tax
		tp.DeSelect_InclusiveTax();
		
		//Disable Default Tax
		tp.DeSelect_DefaultTax();
		
		//Disable Quantity Tax
		tp.DeSelect_QuantityBasedTax();
		
		//Update Tax percentage for All Service Types
		tp.Tax_Per_Service_Type("2000");
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Tax Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Updated Successfully and Store data published successfully"))
		{
			test.log(LogStatus.PASS, "Tax Updated and Published Successfully for Tax Per Service Type");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Updated Failed for Tax Per Service Type");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			cmp.Click_BackspaceButton();
		}
		
		Thread.sleep(50000);
		//Deselect Tax Per Service Type 
		tp.DeSelect_TaxPerServiceType_Tax();
	}
}
