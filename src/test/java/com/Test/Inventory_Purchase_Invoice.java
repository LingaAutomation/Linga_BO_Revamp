package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.Pages.BasePage;
import com.Pages.Common_XPaths;
import com.Pages.InventoryPage;
import com.Pages.LoginPage;
import com.Pages.SaleRecapReport_SettingsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Purchase_Invoice 
{
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Purchase Invoice");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	InventoryPage air;
	BasePage bp=new BasePage();
	
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
		Open_Transfer_Request_Page(driver);
		RefreshAndPaginination_ColumnFilteration(driver);
		Verify_Purchase_Invoice_History(driver);
		Verify_Purchase_Invoice_by_PurchaseOrder_Integration(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Transfer_Request_Page(WebDriver driver) throws Exception
	{
		
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"purchases/purchaseInvoices");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Purchase Invoices");	
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination_ColumnFilteration(WebDriver driver) throws Exception
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
	public void Verify_Purchase_Invoice_History(WebDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		cmp.SearchAndVerify_SearchBox();
		
		List<WebElement> purList=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
		
		int purSize=purList.size();
		
		if(purSize<=5)
		{
			
			for(int i=1;i<=purSize;i++)
			{
				//Get the Purchase Invoice
				String PurchaseID=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		
				//Get the Ordered Date
				String Order_Date=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				//Get the Received Date
				String Received_Date=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		
				//Get the Vendor
				String Vendor=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		
				//Get the Status
				String Status=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();
		
				test.log(LogStatus.INFO, "Purchase ID : "+PurchaseID+" Order Date : "+Order_Date+" Received Date : "+Received_Date+" Vendor : "+Vendor+" Purchase Status : "+Status);
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
				//Get the Purchase Invoice
				String PurchaseID=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		
				//Get the Ordered Date
				String Order_Date=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				//Get the Received Date
				String Received_Date=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		
				//Get the Vendor
				String Vendor=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		
				//Get the Status
				String Status=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();
		
				test.log(LogStatus.INFO, "Purchase ID : "+PurchaseID+" Order Date : "+Order_Date+" Received Date : "+Received_Date+" Vendor : "+Vendor+" Purchase Status : "+Status);
			}
		}
		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Verify_Purchase_Invoice_by_PurchaseOrder_Integration(WebDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"purchases/purchaseOrders");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
//		cmp.VerifyMainScreenPageHeader("Purchase Orders");	
		Thread.sleep(5000);
		//Verify the Front End Receipt Template page loaded or not
		if(air.Purchase_OrderHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Inventory - Purchase Order Page Loaded Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Inventory - Purchase Order Page Loading Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(2000);
		//Click the New Purchase Order button
		air.Click_New_Purchase_Order();
		
		//Verify whether the Purchase Order Creation screen openend or not
		cmp.VerifyCreationScreenPageHeader("New Purchase Order");
		
		Thread.sleep(1000);
		//Select the Vendor
		air.Select_Vendor();
		
		//Select the Purchase Order via
		air.Select_Place_Order_Via("Email");
		
		//click the New Inventory Item
		air.Click_Add_Inventory_ItemButtonTwo();
		
		//Select the Inventory Items
		air.Select_Inventory_Items_PurchaseOrder("9");
		
		//Click the Place Order
		air.Click_Place_OrderButton();
		
		new Common_XPaths(driver, test).Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Purchase order saved successfully!."))
		{
			test.log(LogStatus.PASS, "Purchase Order Saved successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Purchase Order Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(2000);
		//Get the Purchase Order ID
		String Purchase_OrderID=driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
		
		Thread.sleep(2000);
		//Search and Receive the Purchase Order ID
		air.Receive_Purchase_Order(Purchase_OrderID);
		
		Thread.sleep(2000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"purchases/purchaseInvoices");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Purchase Invoices");	
				
		Thread.sleep(2000);
		//Search the Purchase ID
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(Purchase_OrderID);
//		cmp.Search(Purchase_OrderID);
		
		try
		{
			if(air.No_Purchase_InvoiceFoundErrorMsg().isDisplayed())
			{
				test.log(LogStatus.FAIL, "Purchase Invoice not Found for Searched Purchase ID "+Purchase_OrderID);
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Purchase Invoice Available for Searched Purchase ID "+Purchase_OrderID);

			List<WebElement> purList=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
			int purSize=purList.size();
		
			for(int i=1;i<=purSize;i++)
			{
			//Get the Purchase Invoice
			String PurchaseID=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
	
			//Get the Ordered Date
			String Order_Date=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
	
			//Get the Received Date
			String Received_Date=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
	
			//Get the Vendor
			String Vendor=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
			//Get the Status
			String Status=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();
	
			test.log(LogStatus.INFO, "Purchase ID : "+PurchaseID+" Order Date : "+Order_Date+" Received Date : "+Received_Date+" Vendor : "+Vendor+" Purchase Status : "+Status);
			}
			
			
			//Click the Edit button
			air.Click_Action_InventoryItem_AdjustInventoryBtn();
			
			Thread.sleep(3000);
			//Verify the Edit Purchase Invoice Screen Opened or not
			cmp.VerifyCreationScreenPageHeader_Two("Edit Purchase Invoice");
			
			Thread.sleep(2000);
			//Enter the Vendor Invoice Number
			air.Enter_Vendor_Invoice_No("INV12544");
			
			//Click the Save button
			cmp.Click_Save_ButtonTwo();
			
		//	Invoice Updated Successfully
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Invoice Updated Successfully"))
			{
				test.log(LogStatus.PASS, "Purchase Invoice Updated Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Purchase Invoice Update Failed");
	
			}
			
			Thread.sleep(2000);
			//Click the Back button
			cmp.Click_BackspaceButton();
		}
	}
}
