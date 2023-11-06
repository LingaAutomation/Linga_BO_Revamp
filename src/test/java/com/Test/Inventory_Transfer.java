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

import com.Pages.BasePage;
import com.Pages.Common_XPaths;
import com.Pages.InventoryPage;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Transfer 
{
public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Transfer Request & Transfer Logs");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	InventoryPage air;
	BasePage bp=new BasePage(driver, test);
	
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
			String scnsht=((TakesScreenshot)driver.getDelegate()).getScreenshotAs(OutputType.BASE64);
			
			String s="data:image/png;base64,"+scnsht;
			
			test.log(LogStatus.FAIL, test.addScreenCapture(s));
	
		
		}
	}
	
	
	@Test(priority = 1)
	public void Login() throws Exception
	{
		
		
		Thread.sleep(2000);
		//Call the chrome driver
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
//		driver=(SelfHealingDriver) new ChromeDriver(chrOpt);
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		
		options.setHeadless(false);
		
		WebDriver delegate=new ChromeDriver();
		
		driver=SelfHealingDriver.create(delegate);
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
		Open_Transfer_Request_Page(driver);
//		RefreshAndPaginination_ColumnFilteration(driver);
		/*
		Create_Transfer_Request(driver);
		Cancel_Transfer_Request(driver);
		Verify_Transfer_Request_Requested_Store(driver);
		Verify_Transferred_Items_in_Request_Status(driver);
		
		Verify_Transferred_Items_in_Ttansfer_Logs_Received_Today(driver);
    	Verify_Transferred_Items_in_Ttansfer_Logs_Transferred_Today(driver);
		Verify_Transferred_Items_in_Ttansfer_Logs_Received_Yesterday(driver);
		Verify_Transferred_Items_in_Ttansfer_Logs_Received_Last_N_Days(driver);
		Verify_Transferred_Items_in_Ttansfer_Logs_Received_This_week(driver);
		Verify_Transferred_Items_in_Ttansfer_Logs_Received_Last_week(driver);
		Verify_Transferred_Items_in_Ttansfer_Logs_Received_Last_7_days(driver);
		Verify_Transferred_Items_in_Ttansfer_Logs_Received_This_month(driver);
		Verify_Transferred_Items_in_Ttansfer_Logs_Received_Last_month(driver);
		Verify_Transferred_Items_in_Ttansfer_Logs_Received_Last_30_days(driver);
		*/
		Verify_Transferred_Items_in_Ttansfer_Logs_Received_Specific_Date(driver);
		Verify_Transferred_Items_in_Ttansfer_Logs_Received_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Transfer_Request_Page(SelfHealingDriver driver) throws Exception
	{
		
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"transfer");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Transfer Requests");	
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination_ColumnFilteration(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		//Verify the Pagination and Refresh the page
		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
		
		Thread.sleep(2000);
		//Verify Ascending order for name 
		cmp.Ascending_And_Descending_Order();
		
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Create_Transfer_Request(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Transfer Request
		air.Click_New_Transfer_Request();
		Thread.sleep(2000);
	
		//Verify the New Course creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Transfer Request");
		Thread.sleep(2000);
		
		if(air.RequestButton().isEnabled())
		{
		//Click the Request button
		air.Click_RequestButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Transfer request created successfully!."))
		{
			test.log(LogStatus.FAIL, "Transfer request created without Selecting Source Store");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.PASS, "Request button not Enabled without Selecting Source Store");
		}
		
	
		//Select the Source store
		air.Select_Source(ut.getProperty("Store"));
		
		if(air.RequestButton().isEnabled())
		{
		//Click the Request button
		air.Click_RequestButton();
		
		if(cmp.ConfirmationAlertMsg().getText().contentEquals("Please add invetory items to be transferred"))
		{
			Thread.sleep(3000);
			test.log(LogStatus.FAIL, "Please add invetory items to be transferred Error Pop UP Displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Request button Enabled without Adding Inventory Item");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.PASS, "Request button not Enabled without Adding Inventory Item");
		}
		
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
		
		//Click New Transfer Request
		air.Click_New_Transfer_Request();
		
		//Select the Source
		air.Select_Source(Utility.getProperty("Store"));
		
		//click the Add Inventory Items
		air.Click_Add_Inventory_ItemButtonTwo();
		
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
		
		new Common_XPaths(driver, test).Select_Store_in_AutoSelect(Utility.getProperty("Store"));
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"transfer");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Transfer Requests");
		
		driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr[1]/td[5]/div/div[2]/button")).click();
		Thread.sleep(5000);
		cmp.VerifyCreationScreenPageHeader("Approve Transfer Request");
		Thread.sleep(5000);
		//Approve the Transfer Items
		air.Approve_Transfer_Request("3");
		
		
		Thread.sleep(2000);
		//Click the Request Cancel button for Second Request 
		driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr[2]/td[5]/div/div[1]/button")).click();
		
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
		
	new Common_XPaths(driver, test).Select_Store_in_AutoSelect(Utility.getProperty("Store1"));
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"transfer");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Transfer Requests");
		
		
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr[1]/td[3]/span")).getText().equalsIgnoreCase("REQUEST PROCESSED"))
		{
			test.log(LogStatus.PASS, "Request Status Updated Successfully as REQUEST PROCESSED");
		}
		else if(driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr[1]/td[3]/span")).getText().equalsIgnoreCase("REQUEST DECLINED"))
		{
			test.log(LogStatus.INFO, "Request Status Updated as REQUEST DECLINED due to Inventory Items Unavailable");
	
		
		}
		else if(driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr[1]/td[3]/span")).getText().equalsIgnoreCase("REQUEST SENT"))
		{
			test.log(LogStatus.INFO, "Request Status Updated as REQUEST SENT due to Transfer Request Not Accepted");
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Request Status Not Updated Failed as REQUEST PROCESSED");

		}
	
		
		if(driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr[2]/td[3]/span")).getText().equalsIgnoreCase("REQUEST DECLINED"))
		{
			test.log(LogStatus.PASS, "Request Status Updated Successfully as REQUEST DECLINED");
		}
		else
		{
			test.log(LogStatus.FAIL, "Request Status Not Updated Failed as REQUEST DECLINED");

		}
	}
	
	public void Verify_Transferred_Items_in_Ttansfer_Logs_Received_Today(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		Thread.sleep(3000);
		//Navigate to Transfer Logs
		air.Select_Transfer_LogsTab();
		
		Thread.sleep(3000);
		//Select Type 
		air.Select_Type("ALL");

//		air.Select_Type("INVENTORY ITEM");
		
		Thread.sleep(3000);
		//Select Transfer Status
		air.Select_Transfer_Status("Received");
		
		Thread.sleep(3000);
		//Select Today Time Period
		new ReportsPage(driver, test).Select_Today_TimePeriod();
		
		Thread.sleep(3000);
		//Click the Apply button
		new ReportsPage(driver, test).Click_ApplyButton();
		
		Thread.sleep(2000);
		try
		{
			if(air.No_TransferLogsErrorMsg().isDisplayed())
			{
				test.log(LogStatus.FAIL, "No Transfer Logs Found for Today (Received)");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.PASS, "Transfer Logs Available for Today (Received)");
			
			
			for(int i=1;i<=2;i++)
			{
				String Source_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[1]/span")).getText();

				String Destination_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[2]/span")).getText();

				String ItemName=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[3]/span")).getText();

				String Received_Qty=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[6]/span")).getText();

				test.log(LogStatus.INFO, i+" Requested Source Store : "+Source_Store+" Destination Store : "+Destination_Store+" Required Item Name : "+ItemName+" Received Quantity : "+Received_Qty);
			}
		}
		
	}
	
	
	public void Verify_Transferred_Items_in_Ttansfer_Logs_Transferred_Today(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		Thread.sleep(3000);
		//Navigate to Transfer Logs
		air.Select_Transfer_LogsTab();
		Thread.sleep(3000);
		//Select Type 
		air.Select_Type("ALL");

//		air.Select_Type("INVENTORY ITEM");
		
		Thread.sleep(3000);
		//Select Transfer Status
		air.Select_Transfer_Status("Transferred");
		Thread.sleep(3000);
		//Select Today Time Period
		new ReportsPage(driver, test).Select_Today_TimePeriod();
		Thread.sleep(3000);
		//Click the Apply button
		new ReportsPage(driver, test).Click_ApplyButton();
		
		Thread.sleep(2000);
		try
		{
			if(air.No_TransferLogsErrorMsg().isDisplayed())
			{
				test.log(LogStatus.FAIL, "No Transfer Logs Found for Today (Transferred)");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.PASS, "Transfer Logs Available for Today (Transferred) ");
			
			
			for(int i=1;i<=2;i++)
			{
				String Source_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[1]/span")).getText();

				String Destination_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[2]/span")).getText();

				String ItemName=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[3]/span")).getText();

				String Transferred_Qty=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[6]/span")).getText();

				test.log(LogStatus.INFO, i+" Source Store : "+Source_Store+" Requested Destination Store : "+Destination_Store+" Required Item Name : "+ItemName+" Transferred Quantity : "+Transferred_Qty);
			}
		}
		
	}
	
	public void Verify_Transferred_Items_in_Ttansfer_Logs_Received_Yesterday(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		Thread.sleep(3000);
		//Navigate to Transfer Logs
		air.Select_Transfer_LogsTab();
		Thread.sleep(3000);
		//Select Type 
		air.Select_Type("ALL");

//		air.Select_Type("INVENTORY ITEM");
		
		Thread.sleep(3000);
		//Select Transfer Status
		air.Select_Transfer_Status("Received");
		Thread.sleep(3000);
		//Select Today Time Period
		new ReportsPage(driver, test).Select_Yesterday_TimePeriod();
		
		//Click the Apply button
		new ReportsPage(driver, test).Click_ApplyButton();
		
		Thread.sleep(2000);
		try
		{
			if(air.No_TransferLogsErrorMsg().isDisplayed())
			{
				test.log(LogStatus.FAIL, "No Transfer Logs Found for Yesterday");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.PASS, "Transfer Logs Available for Yesterday");
			
			
			for(int i=1;i<=2;i++)
			{
				String Source_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[1]/span")).getText();

				String Destination_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[2]/span")).getText();

				String ItemName=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[3]/span")).getText();

				String Received_Qty=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[6]/span")).getText();

				test.log(LogStatus.INFO, i+" Requested Source Store : "+Source_Store+" Destination Store : "+Destination_Store+" Required Item Name : "+ItemName+" Received Quantity : "+Received_Qty);
			}
		}
		
	}
	
	public void Verify_Transferred_Items_in_Ttansfer_Logs_Received_Last_N_Days(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		Thread.sleep(3000);
		//Navigate to Transfer Logs
		air.Select_Transfer_LogsTab();
		Thread.sleep(3000);
		//Select Type 
		air.Select_Type("ALL");
		Thread.sleep(3000);
//		air.Select_Type("INVENTORY ITEM");
		Thread.sleep(3000);
		
		//Select Transfer Status
		air.Select_Transfer_Status("Received");
		Thread.sleep(3000);
		//Select Today Time Period
		new ReportsPage(driver, test).Select_Last_N_Days_TimePeriod("10");
		Thread.sleep(3000);
		//Click the Apply button
		new ReportsPage(driver, test).Click_ApplyButton();
		
		Thread.sleep(2000);
		try
		{
			if(air.No_TransferLogsErrorMsg().isDisplayed())
			{
				test.log(LogStatus.FAIL, "No Transfer Logs Found for Last 'N' days");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.PASS, "Transfer Logs Available for Last 'N' days");
			
			
			for(int i=1;i<=2;i++)
			{
				String Source_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[1]/span")).getText();

				String Destination_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[2]/span")).getText();

				String ItemName=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[3]/span")).getText();

				String Received_Qty=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[6]/span")).getText();

				test.log(LogStatus.INFO, i+" Requested Source Store : "+Source_Store+" Destination Store : "+Destination_Store+" Required Item Name : "+ItemName+" Received Quantity : "+Received_Qty);
			}
		}
		
	}
	
	public void Verify_Transferred_Items_in_Ttansfer_Logs_Received_This_week(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		Thread.sleep(3000);
		//Navigate to Transfer Logs
		air.Select_Transfer_LogsTab();
		Thread.sleep(3000);
		//Select Type 
		air.Select_Type("ALL");
		Thread.sleep(3000);
//		air.Select_Type("INVENTORY ITEM");
		
		
		//Select Transfer Status
		air.Select_Transfer_Status("Received");
		Thread.sleep(3000);
		//Select Today Time Period
		new ReportsPage(driver, test).Select_This_Week_TimePeriod();
		Thread.sleep(3000);
		//Click the Apply button
		new ReportsPage(driver, test).Click_ApplyButton();
		Thread.sleep(3000);
		Thread.sleep(2000);
		try
		{
			if(air.No_TransferLogsErrorMsg().isDisplayed())
			{
				test.log(LogStatus.FAIL, "No Transfer Logs Found for This Week");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.PASS, "Transfer Logs Available for This Week");
			
			
			for(int i=1;i<=2;i++)
			{
				String Source_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[1]/span")).getText();

				String Destination_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[2]/span")).getText();

				String ItemName=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[3]/span")).getText();

				String Received_Qty=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[6]/span")).getText();

				test.log(LogStatus.INFO, i+" Requested Source Store : "+Source_Store+" Destination Store : "+Destination_Store+" Required Item Name : "+ItemName+" Received Quantity : "+Received_Qty);
			}
		}
		
	}
	
	public void Verify_Transferred_Items_in_Ttansfer_Logs_Received_Last_week(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		Thread.sleep(3000);
		//Navigate to Transfer Logs
		air.Select_Transfer_LogsTab();
		Thread.sleep(3000);
		//Select Type 
		air.Select_Type("ALL");
		Thread.sleep(3000);
//		air.Select_Type("INVENTORY ITEM");
		
		
		//Select Transfer Status
		air.Select_Transfer_Status("Received");
		Thread.sleep(3000);
		//Select Today Time Period
		new ReportsPage(driver, test).Select_Last_Week_TimePeriod();
		Thread.sleep(3000);
		//Click the Apply button
		new ReportsPage(driver, test).Click_ApplyButton();
		Thread.sleep(3000);
		Thread.sleep(2000);
		try
		{
			if(air.No_TransferLogsErrorMsg().isDisplayed())
			{
				test.log(LogStatus.FAIL, "No Transfer Logs Found for Last Week");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.PASS, "Transfer Logs Available for Last Week");
			
			
			for(int i=1;i<=2;i++)
			{
				String Source_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[1]/span")).getText();

				String Destination_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[2]/span")).getText();

				String ItemName=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[3]/span")).getText();

				String Received_Qty=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[6]/span")).getText();

				test.log(LogStatus.INFO, i+" Requested Source Store : "+Source_Store+" Destination Store : "+Destination_Store+" Required Item Name : "+ItemName+" Received Quantity : "+Received_Qty);
			}
		}
		
	}
	
	
	public void Verify_Transferred_Items_in_Ttansfer_Logs_Received_Last_7_days(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		Thread.sleep(3000);
		//Navigate to Transfer Logs
		air.Select_Transfer_LogsTab();
		Thread.sleep(3000);
		//Select Type 
		air.Select_Type("ALL");
		Thread.sleep(3000);
//		air.Select_Type("INVENTORY ITEM");
		
		
		//Select Transfer Status
		air.Select_Transfer_Status("Received");
		Thread.sleep(3000);
		//Select Today Time Period
		new ReportsPage(driver, test).Select_Last_7_Days_TimePeriod();
		Thread.sleep(3000);
		//Click the Apply button
		new ReportsPage(driver, test).Click_ApplyButton();
		
		Thread.sleep(2000);
		try
		{
			if(air.No_TransferLogsErrorMsg().isDisplayed())
			{
				test.log(LogStatus.FAIL, "No Transfer Logs Found for Last 7 days");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.PASS, "Transfer Logs Available for Last 7 days");
			
			
			for(int i=1;i<=2;i++)
			{
				String Source_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[1]/span")).getText();

				String Destination_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[2]/span")).getText();

				String ItemName=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[3]/span")).getText();

				String Received_Qty=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[6]/span")).getText();

				test.log(LogStatus.INFO, i+" Requested Source Store : "+Source_Store+" Destination Store : "+Destination_Store+" Required Item Name : "+ItemName+" Received Quantity : "+Received_Qty);
			}
		}
		
	}
	
	
	public void Verify_Transferred_Items_in_Ttansfer_Logs_Received_This_month(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		Thread.sleep(3000);
		//Navigate to Transfer Logs
		air.Select_Transfer_LogsTab();
		Thread.sleep(3000);
		//Select Type 
		air.Select_Type("ALL");
		Thread.sleep(3000);
//		air.Select_Type("INVENTORY ITEM");
		
		
		//Select Transfer Status
		air.Select_Transfer_Status("Received");
		Thread.sleep(3000);
		//Select Today Time Period
		new ReportsPage(driver, test).Select_This_Month_TimePeriod();
		Thread.sleep(3000);
		//Click the Apply button
		new ReportsPage(driver, test).Click_ApplyButton();
		
		Thread.sleep(2000);
		try
		{
			if(air.No_TransferLogsErrorMsg().isDisplayed())
			{
				test.log(LogStatus.FAIL, "No Transfer Logs Found for This Month");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.PASS, "Transfer Logs Available for This month");
			
			
			for(int i=1;i<=2;i++)
			{
				String Source_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[1]/span")).getText();

				String Destination_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[2]/span")).getText();

				String ItemName=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[3]/span")).getText();

				String Received_Qty=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[6]/span")).getText();

				test.log(LogStatus.INFO, i+" Requested Source Store : "+Source_Store+" Destination Store : "+Destination_Store+" Required Item Name : "+ItemName+" Received Quantity : "+Received_Qty);
			}
		}
		
	}
	
	public void Verify_Transferred_Items_in_Ttansfer_Logs_Received_Last_month(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		Thread.sleep(3000);
		//Navigate to Transfer Logs
		air.Select_Transfer_LogsTab();
		Thread.sleep(3000);
		//Select Type 
		air.Select_Type("ALL");

//		air.Select_Type("INVENTORY ITEM");
		Thread.sleep(3000);
		
		//Select Transfer Status
		air.Select_Transfer_Status("Received");
		Thread.sleep(3000);
		//Select Today Time Period
		new ReportsPage(driver, test).Select_Today_TimePeriod();
		Thread.sleep(3000);
		//Click the Apply button
		new ReportsPage(driver, test).Click_ApplyButton();
		
		Thread.sleep(2000);
		try
		{
			if(air.No_TransferLogsErrorMsg().isDisplayed())
			{
				test.log(LogStatus.FAIL, "No Transfer Logs Found for Last month");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.PASS, "Transfer Logs Available for Last month");
			
			
			for(int i=1;i<=2;i++)
			{
				String Source_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[1]/span")).getText();

				String Destination_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[2]/span")).getText();

				String ItemName=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[3]/span")).getText();

				String Received_Qty=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[6]/span")).getText();

				test.log(LogStatus.INFO, i+" Requested Source Store : "+Source_Store+" Destination Store : "+Destination_Store+" Required Item Name : "+ItemName+" Received Quantity : "+Received_Qty);
			}
		}
		
	}
	
	
	public void Verify_Transferred_Items_in_Ttansfer_Logs_Received_Last_30_days(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		Thread.sleep(3000);
		//Navigate to Transfer Logs
		air.Select_Transfer_LogsTab();
		Thread.sleep(3000);
		//Select Type 
		air.Select_Type("ALL");

//		air.Select_Type("INVENTORY ITEM");
		Thread.sleep(3000);
		
		//Select Transfer Status
		air.Select_Transfer_Status("Received");
		Thread.sleep(3000);
		//Select Today Time Period
		new ReportsPage(driver, test).Select_Last_30_Days_TimePeriod();
		Thread.sleep(3000);
		//Click the Apply button
		new ReportsPage(driver, test).Click_ApplyButton();
		
		Thread.sleep(2000);
		try
		{
			if(air.No_TransferLogsErrorMsg().isDisplayed())
			{
				test.log(LogStatus.FAIL, "No Transfer Logs Found for Last 30 days");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.PASS, "Transfer Logs Available for Last 30 days");
			
			
			for(int i=1;i<=2;i++)
			{
				String Source_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[1]/span")).getText();

				String Destination_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[2]/span")).getText();

				String ItemName=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[3]/span")).getText();

				String Received_Qty=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[6]/span")).getText();

				test.log(LogStatus.INFO, i+" Requested Source Store : "+Source_Store+" Destination Store : "+Destination_Store+" Required Item Name : "+ItemName+" Received Quantity : "+Received_Qty);
			}
		}
		
	}
	
	public void Verify_Transferred_Items_in_Ttansfer_Logs_Received_Specific_Date(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		Thread.sleep(3000);
		//Navigate to Transfer Logs
		air.Select_Transfer_LogsTab();
		Thread.sleep(3000);
		//Select Type 
		air.Select_Type("ALL");
		Thread.sleep(3000);
//		air.Select_Type("INVENTORY ITEM");
		
		
		//Select Transfer Status
		air.Select_Transfer_Status("Received");
		Thread.sleep(3000);
		//Select Today Time Period
		new ReportsPage(driver, test).Select_Specific_Date_TimePeriod(Utility.getProperty("Specific_Date"));
		Thread.sleep(3000);
		//Click the Apply button
		new ReportsPage(driver, test).Click_ApplyButton();
		
		Thread.sleep(2000);
		try
		{
			if(air.No_TransferLogsErrorMsg().isDisplayed())
			{
				test.log(LogStatus.FAIL, "No Transfer Logs Found for Specific Date");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.PASS, "Transfer Logs Available for Specific Date");
			
			
			for(int i=1;i<=2;i++)
			{
				String Source_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[1]/span")).getText();

				String Destination_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[2]/span")).getText();

				String ItemName=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[3]/span")).getText();

				String Received_Qty=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[6]/span")).getText();

				test.log(LogStatus.INFO, i+" Requested Source Store : "+Source_Store+" Destination Store : "+Destination_Store+" Required Item Name : "+ItemName+" Received Quantity : "+Received_Qty);
			}
		}
		
	}
	
	public void Verify_Transferred_Items_in_Ttansfer_Logs_Received_Date_Range(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		Thread.sleep(3000);
		//Navigate to Transfer Logs
		air.Select_Transfer_LogsTab();
		Thread.sleep(3000);
		//Select Type 
		air.Select_Type("ALL");
		Thread.sleep(3000);
//		air.Select_Type("INVENTORY ITEM");
		
		
		//Select Transfer Status
		air.Select_Transfer_Status("Received");
		Thread.sleep(3000);
		//Select Today Time Period
		new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Start_Date"), Utility.getProperty("End_Date"));
		Thread.sleep(3000);
		//Click the Apply button
		new ReportsPage(driver, test).Click_ApplyButton();
		
		Thread.sleep(2000);
		try
		{
			if(air.No_TransferLogsErrorMsg().isDisplayed())
			{
				test.log(LogStatus.FAIL, "No Transfer Logs Found for Date Range");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.PASS, "Transfer Logs Available for Date Range");
			
			
			for(int i=1;i<=2;i++)
			{
				String Source_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[1]/span")).getText();

				String Destination_Store=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[2]/span")).getText();

				String ItemName=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[3]/span")).getText();

				String Received_Qty=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr["+i+"]/td[6]/span")).getText();

				test.log(LogStatus.INFO, i+" Requested Source Store : "+Source_Store+" Destination Store : "+Destination_Store+" Required Item Name : "+ItemName+" Received Quantity : "+Received_Qty);
			}
		}
		
	}
	
}
