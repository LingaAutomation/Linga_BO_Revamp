package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.Common_XPaths;
import com.Pages.InventoryPage;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.epam.healenium.SelfHealingDriver;
import com.Pages.Enterprise_CentralIventoryPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Central_Inventory_Transfer_Request {
	
	public SelfHealingDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Central Inventory - Transfer_Request");

	LoginPage lgpg;
	public String st = "NA";

	Utility ut = new Utility();

	Common_XPaths cmp;
	LoginTest a = new LoginTest();
	Enterprise_CentralIventoryPage civ;
	InventoryPage air;
	@AfterClass
	public void flushTest() throws Exception {
		Thread.sleep(2000);
		rep.endTest(test);
		rep.flush();
	}

	@AfterMethod
	public void TestFail(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			String scnsht = ((TakesScreenshot) driver.getDelegate()).getScreenshotAs(OutputType.BASE64);

			String s = "data:image/png;base64," + scnsht;

			test.log(LogStatus.FAIL, test.addScreenCapture(s));

		}
	}

	@Test(priority = 1)
	public void Login() throws Exception {

		Thread.sleep(2000);
		// Call the chrome driver
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().driverVersion("110.0.5841").setup();
//		driver=new ChromeDriver(chrOpt);

//		System.setProperty("webdriver.chrome.driver", "./Automation Driver/chromedriver.exe");
//		// Open the Chrome window
//		driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		
		options.setHeadless(false);
		
		WebDriver delegate=new ChromeDriver();
		
		driver=SelfHealingDriver.create(delegate);
		// Wait for 30 seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the Chrome window
		driver.manage().window().maximize();
		Thread.sleep(1000);
		// Launch the URL
		driver.get(Utility.getProperty("appURL"));

		Thread.sleep(10000);
		a.Login(driver, test);
	}

	@Test(priority = 50)
	public void LogOut() throws Exception {
		a.LogOut(driver, test);
	}

	@Test(priority = 2)
	public void Calling() throws Exception {
		Open_Enterprise_Settings_Royalty_Franchise_Report_Page(driver);
		//RefreshAndPaginination(driver);
		New_request_SameName_Both_SourceAndDestination(driver);
		New_request_DifferentName_Both_SourceAndDestination(driver);
		Cancel_Transfer_Request(driver);
		Verify_Transfer_Request_Requested_Store(driver);
		Verify_Transferred_Items_in_Request_Status(driver);
		
	
		

	}

	@Test(priority = 3, enabled = false)
	public void Open_Enterprise_Settings_Royalty_Franchise_Report_Page(SelfHealingDriver driver) throws Exception {

		civ = new Enterprise_CentralIventoryPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		Thread.sleep(5000);
		// Load the Department page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id7") + "home");

		Thread.sleep(10000);
		// Load the Department page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id7")
				+ "centralInventory/transfer");

		Thread.sleep(5000);
		//Verify the Gift Cards page loeded or not
		cmp.VerifyMainScreenPageHeader("Transfer Requests");

	}

	@Test(priority = 4, enabled = false)
	public void RefreshAndPaginination(SelfHealingDriver driver) throws Exception {
		cmp = new Common_XPaths(driver, test);

		// Verify the Pagination and Refresh the page
		cmp.VerifyPagination_and_Refresh_Publish();

		// Verify Column Filtration
		cmp.Filter_Columns();

		// Ascending and Descending Sorting
		cmp.Ascending_And_Descending_Order();
	}
	
	@Test(priority = 4, enabled = false)
	public void New_request_SameName_Both_SourceAndDestination(SelfHealingDriver driver)
			throws Exception {
	    civ = new Enterprise_CentralIventoryPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		Thread.sleep(2000);
		civ.New_Transfer_Request().click();
		Thread.sleep(2000);
		
		cmp.VerifyCreationScreenPageHeader("New Transfer Request");
		
		
		if(civ.Request_Disabled_Btn().isEnabled())
		{
		//Click the Save button
		civ.Request_Btn().click();
		
		Thread.sleep(3000);
		//Check whether the New Gift Card Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Store"))
		{
			test.log(LogStatus.PASS, "Please Enter store Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter store Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.PASS, "Request button not Enabled without Entering Source and Destination");
		}
		
		Thread.sleep(1000);
		
		civ.Select_Source_Store();
		
		Thread.sleep(1000);
	   String tes = civ.Source_input_btn().getAttribute("value");
	   
	   System.out.println(tes);
	   Thread.sleep(2000);
	   civ.select_Destination_store(tes);
	   
	   if(driver.findElement(By.xpath("//mat-hint[contains(.,'Please, Select different store')]")).isDisplayed()) {
		   
		   test.log(LogStatus.PASS, "Please, Select different store error msg is displayed");
	   }
	   else {
		   test.log(LogStatus.FAIL, "Please, Select different store error msg is not displayed");
	   }
	   
	   Thread.sleep(1000);
	   
		//Click the Add Inventory Item button
		air.Click_Add_Inventory_ItemButtonTwo();
		
		if(air.RequestButton().isEnabled())
		{
		//Click the Request button
		air.Click_RequestButton();
		
		if(cmp.ConfirmationAlertMsg().getText().contentEquals("Please add invetory items to be transferred"))
		{
			Thread.sleep(3000);
			test.log(LogStatus.FAIL, "Please add invetory items to be transferred Error Pop UP Displayed when Click Request without Selecting Inventory Items");
		}
		else
		{
			test.log(LogStatus.FAIL, "Request button Enabled without Selecting Inventory Items");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.PASS, "Request button not Enabled without Selecting Inventory Items");
		}
		
		//Select the Inventory Items
		air.Add_Inventory_Items_TransferRequest("5");
		
		Thread.sleep(2000);
		//Click the Request button
		air.Click_RequestButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please, Select different store"))
		{
			test.log(LogStatus.PASS, "Please, Select different store pop up is displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please, Select different store pop up is not displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Click the Cancel button
		cmp.Click_CancelButton();
		


}
	@Test(priority = 4, enabled = false)
	public void New_request_DifferentName_Both_SourceAndDestination(SelfHealingDriver driver)
			throws Exception {
	    civ = new Enterprise_CentralIventoryPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		
	    civ = new Enterprise_CentralIventoryPage(driver, test);
			cmp = new Common_XPaths(driver, test);
			air=new InventoryPage(driver, test);
			Thread.sleep(2000);
			civ.New_Transfer_Request().click();
			Thread.sleep(2000);
			
			cmp.VerifyCreationScreenPageHeader("New Transfer Request");
			
			
			if(civ.Request_Disabled_Btn().isEnabled())
			{
			//Click the Save button
			civ.Request_Btn().click();
			
			Thread.sleep(3000);
			//Check whether the New Gift Card Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Store"))
			{
				test.log(LogStatus.PASS, "Please Enter store Alert Displayed");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Please Enter store Alert not Displayed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			}
			else
			{
				test.log(LogStatus.PASS, "Request button not Enabled without Entering Source and Destination");
			}
			
			Thread.sleep(1000);
			
			civ.Select_Source_Store();
			Thread.sleep(1000);
			civ.Select_Destination_Store();
			Thread.sleep(1000);
			
			//Click the Add Inventory Item button
			air.Click_Add_Inventory_ItemButtonTwo();
			
			if(air.RequestButton().isEnabled())
			{
			//Click the Request button
			air.Click_RequestButton();
			
			if(cmp.ConfirmationAlertMsg().getText().contentEquals("Please add invetory items to be transferred"))
			{
				Thread.sleep(3000);
				test.log(LogStatus.FAIL, "Please add invetory items to be transferred Error Pop UP Displayed when Click Request without Selecting Inventory Items");
			}
			else
			{
				test.log(LogStatus.FAIL, "Request button Enabled without Selecting Inventory Items");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			}
			else
			{
				test.log(LogStatus.PASS, "Request button not Enabled without Selecting Inventory Items");
			}
			
			//Select the Inventory Items
			air.Add_Inventory_Items_TransferRequest("5");
			
			Thread.sleep(2000);
			//Click the Request button
			air.Click_RequestButton();
			
			
			Thread.sleep(3000);
			//Check whether the New Course Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Transfer request created successfully!."))
			{
				test.log(LogStatus.PASS, "Transfer request created successfully");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Transfer request create Failed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}

}
	
	
@Test(priority = 5,enabled = false)
public void Cancel_Transfer_Request(SelfHealingDriver driver) throws Exception
{
	cmp=new Common_XPaths(driver, test);
	air=new InventoryPage(driver, test);
	
	Thread.sleep(500);
	//Click the New Transfer
	air.Click_New_Transfer_Request();
	
	Thread.sleep(500);
	//Check whether the Update screen opened or not
	cmp.VerifyCreationScreenPageHeader("New Transfer Request");
	
	Thread.sleep(1000);
	//Click the Cancel button
	cmp.Click_CancelButton();
	
	Thread.sleep(1000);
	//Check whether the New Course Creation form Closed or not
	if(!cmp.NewCreationScreenHeader().isDisplayed())
	{
		test.log(LogStatus.PASS, "Transfer Request Screen Cancelled");
	}
	else
	{
		test.log(LogStatus.FAIL, "Transfer Request Reason Screen Cancelled");
	}
	
}


@Test(priority = 5,enabled = false)
public void Verify_Transfer_Request_Requested_Store(SelfHealingDriver driver) throws Exception
{
	cmp=new Common_XPaths(driver, test);
	air=new InventoryPage(driver, test);
	

	


	Thread.sleep(5000);
	//Verify the Coursing page loaded or not
	cmp.VerifyMainScreenPageHeader("Transfer Requests");
	
	driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr[1]/td[6]/div/div[2]/button")).click();
	Thread.sleep(5000);
	cmp.VerifyCreationScreenPageHeader("Approve Transfer Request");
	Thread.sleep(5000);
	try {
	//Approve the Transfer Items
	air.Approve_Transfer_Request("3");
	}
	catch (Exception e) {
		Thread.sleep(1000);
		
		if(civ.Request_Disabled_Btn().isDisplayed()) {
			test.log(LogStatus.FAIL, "Transfer Request button is not Enabled");
			Thread.sleep(1000);
			//Click the Cancel button
			cmp.Click_CancelButton();
			
		}	
	}
	
	Thread.sleep(2000);
	//Click the Request Cancel button for Second Request 
	driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr[1]/td[6]/div/div[1]/button")).click();
	
	Thread.sleep(5000);
	//Verify the Transfer Request Declined or not
	if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("You have declined the transfer request."))
	{
		test.log(LogStatus.PASS, "Requested Transfer Items Request got Declined");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
	}
	else
	{
		test.log(LogStatus.FAIL, "Requested Transfer Items Request not Declined");
		ut.FailedCaptureScreenshotAsBASE64(driver, test);
	}
	
}


public void Verify_Transferred_Items_in_Request_Status(SelfHealingDriver driver) throws Exception
{
	cmp=new Common_XPaths(driver, test);
	air=new InventoryPage(driver, test);
	


	Thread.sleep(5000);
	//Verify the Coursing page loaded or not
	cmp.VerifyMainScreenPageHeader("Transfer Requests");
	
	
	Thread.sleep(2000);
	if(driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr[1]/td[2]/span")).getText().equalsIgnoreCase("REQUEST PROCESSED"))
	{
		test.log(LogStatus.PASS, "Request Status Updated Successfully as REQUEST PROCESSED");
	}
	else if(driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr[1]/td[2]/span")).getText().equalsIgnoreCase("REQUEST DECLINED"))
	{
		test.log(LogStatus.INFO, "Request Status Updated as REQUEST DECLINED due to Inventory Items Unavailable");

	
	}
	else if(driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr[1]/td[2]/span")).getText().equalsIgnoreCase("REQUEST SENT"))
	{
		test.log(LogStatus.INFO, "Request Status Updated as REQUEST SENT due to Transfer Request Not Accepted");
		
	}
	else
	{
		test.log(LogStatus.FAIL, "Request Status Not Updated Failed as REQUEST PROCESSED");

	}

	
	if(driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr[1]/td[2]/span")).getText().equalsIgnoreCase("REQUEST DECLINED"))
	{
		test.log(LogStatus.PASS, "Request Status Updated Successfully as REQUEST DECLINED");
	}
	else
	{
		test.log(LogStatus.FAIL, "Request Status Not Updated Failed as REQUEST DECLINED");

	}
}
}