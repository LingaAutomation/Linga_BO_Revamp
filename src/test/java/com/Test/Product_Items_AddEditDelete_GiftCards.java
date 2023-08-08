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
import com.Pages.GiftCardsPage;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_GiftCards {
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete Gift Cards");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	GiftCardsPage gcp;
	
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
		Open_GiftCards_Page(driver);
		RefreshAndPaginination(driver);
		Add_GiftCards(driver);
		Edit_and_Close_Cancel_GiftCards(driver);
		Edit_and_Update_GiftCards(driver);
		Recharge_GiftCards(driver);
		Delete_and_Active_Inactive_GiftCards(driver);
		Create_DuplicateGiftCard(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_GiftCards_Page(WebDriver driver) throws Exception
	{
		
		gcp=new GiftCardsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Gift Card page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"giftCard");

		Thread.sleep(5000);
		//Verify the Gift Cards page loeded or not
		cmp.VerifyMainScreenPageHeader("Gift Cards");	
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
	public void Add_GiftCards(WebDriver driver) throws Exception
	{
		gcp=new GiftCardsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Gift Cards
		gcp.Click_NewGiftCard();
		Thread.sleep(2000);
	
		//Verify the New Gift Card creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Gift Card");
		Thread.sleep(2000);
		
		if(cmp.Save_Button().isEnabled())
		{
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Gift Card Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter GiftCard Number"))
		{
			test.log(LogStatus.PASS, "Please Enter Gift Card Number Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Gift Card Number Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.PASS, "Save button not Enabled without Entering Gift Card Number");
		}
		
		Thread.sleep(500);
		//Enter the Gift Card Name
		gcp.Enter_GiftCardNumber(Utility.getProperty("GiftCard_Number"));
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Gift Card Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Gift Card Balance"))
		{
			test.log(LogStatus.PASS, "Please Enter Gift Card Balance Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Gift Card Balance Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(2000);
		//Enter the Gift Card Name
		gcp.Enter_GiftCardNumber(Utility.getProperty("GiftCard_Number"));
		
		Thread.sleep(1000);
		gcp.Enter_GiftCardBalance("500");
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Gift Card Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Select Payment Methods"))
		{
			test.log(LogStatus.PASS, "Please Select Payment Methods Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Select Payment Methods Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(500);
		//Enter the Gift Card Name
		gcp.Select_GiftCard_Cash(Utility.getProperty("GiftCard_Number"));
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Gift Card Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Gift Card Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Gift Card Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift Card Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_GiftCards(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		gcp=new GiftCardsPage(driver, test);
		
		Thread.sleep(500);
//		//Search and Click Edit button
//		gcp.Click_Edit_GiftCardButton(Utility.getProperty("GiftCard_Number"));
//		
//		Thread.sleep(1000);
//		//Click the Close button
//		cmp.Click_CloseButton();
//		
//		Thread.sleep(1000);
//		//Check whether the New Gift Card Creation form Closed or not
//		if(!cmp.NewCreationScreenHeader().isDisplayed())
//		{
//			test.log(LogStatus.PASS, "Editing Gift Card screen Closed");
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Editing Gift Card screen not Closed");
//		}
//		
		
		Thread.sleep(2000);
		//Search the Gift Cards to Click Edit and Cancel
		gcp.Click_Edit_GiftCardButton(Utility.getProperty("GiftCard_Number"));
		
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Gift Card");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Gift Card Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Gift Card screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift Card screen not Closed");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_GiftCards(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		gcp=new GiftCardsPage(driver, test);
		

		Thread.sleep(10000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
	
		Thread.sleep(1000);
		//Search and Click Edit button
		gcp.Click_Edit_GiftCardButton(Utility.getProperty("GiftCard_Number"));
		
		Thread.sleep(500);
		//Select Gift card as Card Type
		gcp.Select_VisaCard(Utility.getProperty("GiftCard_Number")+"S");
		
		if(cmp.Update_Button().isEnabled())
		{
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Gift Card Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Valid Gift Card Number"))
		{
			test.log(LogStatus.PASS, "Please Enter Valid GiftCard Number Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Valid Gift Card Number not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	else
	{
		test.log(LogStatus.PASS, "Update button not Enabled without Entering Gift Card Number");
	}
		
		Thread.sleep(1000);
		//Select Gift card as Card Type
		gcp.Select_VisaCard(Utility.getProperty("GiftCard_Number"));
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Gift Card Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Gift Card Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Gift Card (Card Type) Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift Card (Card Type) Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		gcp.Click_Edit_GiftCardButton(Utility.getProperty("GiftCard_Number"));
		
		Thread.sleep(500);
		//Select Gift card as Card Type
		gcp.Select_GiftCard_Discount(Utility.getProperty("GiftCard_Number"));

		
		Thread.sleep(1500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Gift Card Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Gift Card Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Gift Card (100% Discount) Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift Card (100% Discount) Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Recharge_GiftCards(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		gcp=new GiftCardsPage(driver, test);
		
		gcp.Click_Recharge_GiftCardButton(Utility.getProperty("GiftCard_Number"));
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Gift Card Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Gift card Amount credited successfully"))
		{
			test.log(LogStatus.PASS, "Gift card Amount Recharged successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift card Amount Recharge Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_GiftCards(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		gcp=new GiftCardsPage(driver, test);
		
		Thread.sleep(2000);
		//Search and Click Delete button
		gcp.Click_Delete_GiftCardButton(Utility.getProperty("GiftCard_Number"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Gift Card Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Gift Card Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Gift Card not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		
		//Search and Click Delete button
		gcp.Click_Delete_GiftCardButton(Utility.getProperty("GiftCard_Number"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Gift Card Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Gift Card Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Gift Card Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift Card Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		
		//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("GiftCard_Number"));
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();

				try
				{
				Thread.sleep(3000);
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Gift Card Activated Successfully"))
				{
					test.log(LogStatus.FAIL, "Gift Card Activated when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Gift Card not Activated when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}

		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("GiftCard_Number"));
		
		Thread.sleep(500);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Gift Card Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Gift Card Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Gift Card activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift Card activated Failed");
			
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
	public void Create_DuplicateGiftCard(WebDriver driver) throws Exception
	{
		gcp=new GiftCardsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Gift Cards button
		gcp.Click_NewGiftCard();
		Thread.sleep(2000);
	
		Thread.sleep(500);
		//Enter the existing Gift Card name
		gcp.Select_GiftCard_Cash(Utility.getProperty("GiftCard_Number"));
		
	
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Gift Card Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Gift Card Number Already Exists"))
		{
			test.log(LogStatus.PASS, "Gift Card number already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_CancelButton();
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error(s)"))
		{
			test.log(LogStatus.PASS, "Validation Error(s) pop up displayed while adding Duplicate Gift Card");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_CancelButton();
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift Card number already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
}
