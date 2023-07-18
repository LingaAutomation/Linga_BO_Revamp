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
import com.Pages.KitchenPrinterPage;
import com.Test.LoginTest;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Receipt_Printers 
{

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings - Receipt Printers");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	KitchenPrinterPage kppg;
	
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
		//System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
		//Open the Chrome window
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
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
		Open_Receipt_Printer_Page(driver);
//		RefreshAndPaginination(driver);
		Add_Receipt_Printer(driver);
		Edit_and_Close_Cancel_Receipt_Printer(driver);
		Edit_and_Update_Receipt_Printer(driver);
		Create_Duplicate_Receipt_Printer(driver);
		Delete_and_Active_Inactive_Receipt_Printer(driver);
		Update_Receipt_Printer_Settings(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Receipt_Printer_Page(WebDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Receipt Printer page
		driver.get(Utility.getProperty("baseURL")+"settings/"+"receiptPrinters");

		Thread.sleep(5000);
		//Verify the Receipt Printers page loaded or not
		cmp.VerifyMainScreenPageHeader("Receipt Printers");	
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
	public void Add_Receipt_Printer(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);
		Thread.sleep(2000);
		//Click the New Receipt Printers
		kppg.Click_New_ReceiptPrinter();
		Thread.sleep(2000);
	
		//Verify the New Receipt Printer creation screen opened or not 
		cmp.VerifyCreationScreenPageHeader("New Receipt Printer");
		Thread.sleep(5000);
		
		//Enter the IP Address
		kppg.Enter_IPAddress(Utility.getProperty("Receipt_Printer_IP"));
		
		
		//Select the Printer option
		kppg.Select_PrinterModel();
				
		
		
		Thread.sleep(1000);
		//Click the Save button
		cmp.Click_SaveButton();
 
		/*
		 * Thread.sleep(6000); //Check whether the New Kitchen Printer Saved or not
		 * if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Name"
		 * )) { test.log(LogStatus.PASS, "Please Enter Name is Displayed");
		 * 
		 * 
		 * } else { test.log(LogStatus.FAIL, "Please Enter Name is not Displayed");
		 * 
		 * }
		 */

		Thread.sleep(500);
		//Click Cancel button
		cmp.Click_CancelButton();

				Thread.sleep(500);
				//Click New Receipt Printer 
				kppg.Click_New_ReceiptPrinter();
		
						String NameExcess = "Entering Invalid Name to input"; 
						int ActualSize= NameExcess.length();
						System.out.println(ActualSize);
		
						//Enter the Kitchen Printer Name
						cmp.EnterName(NameExcess);
						
						//To get value
						String ActualName=cmp.NameInputBox().getAttribute("value");
						System.out.println("The name : "+ActualName);
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
				//Enter the Kitchen Printer Name
				cmp.EnterName(Utility.getProperty("Receipt_Printer_Name")+"AA");
//				cmp.EnterName(Utility.getProperty("Receipt_Printer_Name")+Keys.BACK_SPACE+"AA");
	
				Thread.sleep(500);

				//Enter the Invalid Ip Address
				kppg.Enter_IPAddress("abcd");
				
				//Check whether the Enter Valid IP Address pop up displayed or not
				kppg.Verify_Invalid_IP_AddressMsg("Enter valid IP address.");
				
				//Enter the Invalid Ip Address
				kppg.Enter_IPAddress("180.1.1");
				
				//Check whether the Enter Valid IP Address pop up displayed or not
				kppg.Verify_Invalid_IP_AddressMsg("Enter valid IP address.");
		
		
				//Enter the IP Address
				kppg.Enter_IPAddress(Utility.getProperty("Receipt_Printer_IP")+"AHH");
				
				//Enable Set as Default
				kppg.Enable_SetasDefault();
				
				Thread.sleep(1000);
				//Click the Save button
				cmp.Click_SaveButton();
		 
		Thread.sleep(1500);
		//Check whether the New Kitchen Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Receipt Printer Saved Successfully"))
		{
			test.log(LogStatus.FAIL, "Kitchen Printer Saved without Selecting Printer Model");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			
			//Click New Receipt Printer
			kppg.Click_New_ReceiptPrinter();
			
		}
		else
		{
			test.log(LogStatus.PASS, "Kitchen Printer not Saved without Selecting Printer Model");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(500);
			//Click Cancel button
			cmp.Click_CancelButton();
		}
		Thread.sleep(6000);
		Thread.sleep(500);
		//Click New Receipt Printer 
		kppg.Click_New_ReceiptPrinter();
		
		Thread.sleep(2000);
		//Enter the Receipt Printer Name
		cmp.EnterName(Utility.getProperty("Receipt_Printer_Name"));
		
		//Enter the IP Address
		kppg.Enter_IPAddress(Utility.getProperty("Receipt_Printer_IP"));
		
		//Select the Printer Model
		kppg.Select_PrinterModel();
		
		//Enable Set as Default
		kppg.Enable_SetasDefault();
		
		Thread.sleep(1000);
		//Click the Save button
		cmp.Click_SaveButton();
 
		Thread.sleep(1500);
		//Check whether the New Kitchen Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Receipt Printer Saved Successfully"))
		{
			test.log(LogStatus.PASS, "New Receipt Printer Saved Successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Receipt Printer Save Failed");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}Thread.sleep(6000);

	
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Receipt_Printer(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);

		
		Thread.sleep(1000);
		//Search the Receipt Printers to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("Receipt_Printer_Name"));
		
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Receipt Printer");
		
		//Verify whether the Set as Default Enabled or not
		if(kppg.SetasDefault().isEnabled())
		{
			test.log(LogStatus.PASS, "Set as Default is Selected");
			
			//Disable Set as Default
			kppg.Disable_SetasDefault();
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Set as Default is not Selected");
		}Thread.sleep(6000);
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Receipt Printer Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Receipt Printer Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Receipt Printer not Cancelled");
		}Thread.sleep(6000);
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Receipt_Printer(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);

		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Receipt_Printer_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Receipt_Printer_Name"));
		
		Thread.sleep(500);
		//Verify whether the Set as Default Enabled or not
				if(kppg.SetasDefault().isEnabled())
				{
					test.log(LogStatus.PASS, "Set as Default is Selected");
					
					//Disable Set as Default
					kppg.Disable_SetasDefault();
					
				}
				else
				{
					test.log(LogStatus.FAIL, "Set as Default is not Selected");
				}
				
				
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(1500);
		//Check whether the New Kitchen Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Receipt Printer Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Receipt Printer Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Receipt Printer updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(6000);

	}
	
	@Test(priority = 6,enabled = false)
	public void Create_Duplicate_Receipt_Printer(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Kitchen Printers
		kppg.Click_New_ReceiptPrinter();
		Thread.sleep(2000);
	
		//Verify the New Kitchen Printer creation screen opened or not 
		cmp.VerifyCreationScreenPageHeader("New Receipt Printer");
		Thread.sleep(2000);
		
		Thread.sleep(1000);
		//Enter the Kitchen Printer Name
		cmp.EnterName(Utility.getProperty("Receipt_Printer_Name"));
		Thread.sleep(500);

		//Enter the IP Address
				kppg.Enter_IPAddress(Utility.getProperty("Receipt_Printer_IP"));
				
		
		//Select the Printer option
		kppg.Select_PrinterModel();
				
		
	
		
 Thread.sleep(1000);
		//Click the Save button
		cmp.Click_SaveButton();

		
		Thread.sleep(2000);
		//Check whether the New Kitchen Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exists"))
		{
			test.log(LogStatus.PASS, "Receipt Printer Name already exists pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Printer Saved Successfully"))
		{
			test.log(LogStatus.FAIL, "Duplicate Receipt Printer Saved when Entering Existing Name");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			//Click New Receipt Printer
			kppg.Click_New_ReceiptPrinter();
		}
		else
		{
			test.log(LogStatus.FAIL, "Receipt Printer Name already exists pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			
		}Thread.sleep(6000);
		
		Thread.sleep(1000);
		//Enter the Kitchen Printer Name
		cmp.EnterName(Utility.getProperty("Receipt_Printer_Name")+"BB");
		Thread.sleep(500);

		//Enter the IP Address
				kppg.Enter_IPAddress(Utility.getProperty("Receipt_Printer_IP"));
				
		
		//Select the Printer option
		kppg.Select_PrinterModel();
				
		
	
		
		Thread.sleep(1000);
		//Click the Save button
		cmp.Click_SaveButton();

		
		Thread.sleep(1500);
		//Check whether the New Kitchen Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("IP address already exists"))
		{
			test.log(LogStatus.PASS, "Receipt Printer IP address already exists pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			//Click the Cancel button
			cmp.Click_CancelButton();
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Printer Saved Successfully"))
		{
			test.log(LogStatus.FAIL, "Duplicate Receipt Printer Saved when Entering Existing IP Address");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}	
		else
		{
			test.log(LogStatus.FAIL, "Receipt Printer IP address already exists pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}Thread.sleep(6000);
	}
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Receipt_Printer(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);

		//Search and Click Delete button
				cmp.SearchAndClickDelete(Utility.getProperty("Receipt_Printer_Name"));
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();
		
				Thread.sleep(1500);
				try
				{
				//Check whether the New Kitchen Printer Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Receipt Printer Deleted Successfully"))
				{
					test.log(LogStatus.FAIL, "Kitchen Printer Deleted when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Kitchen Printer not Deleted when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}Thread.sleep(6000);
				
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Receipt_Printer_Name"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(1500);
		//Check whether the New Kitchen Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Receipt Printer Deleted Successfully"))
		{
			test.log(LogStatus.PASS, "Kitchen Printer Deleted Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen Printer Deletion Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(5000);
	}
	

	@Test(priority = 5,enabled = false)
	public void Update_Receipt_Printer_Settings(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);

		Thread.sleep(5000);
		//Select Settings Kitchen Printer
		kppg.Click_Settings_Tab();
		
		//Enable Auto Print Receipt
		kppg.Enable_AutoPrintReceipt();
		
		//Enable Show CC Receipt Screen
		kppg.Enable_Show_CC_ReceiptScreen();
		
		//Enable Print CC Customer Copy
		kppg.Enable_Print_CC_CustomerCopy();
		
		//Enable Show Digital Receipt Screen
		kppg.Enable_Show_Digital_ReceiptScreen();
		
		/*
		 * //Check whether the Show Digital Receipt in CDS is Displayed or not
		 * if(kppg.Show_Digital_ReceiptinCDS().isDisplayed()) { test.log(LogStatus.PASS,
		 * "Show Digital Receipt in CDS is Displayed when Enabling Show Digital Receipt Screen"
		 * );
		 * 
		 * //Enable Show Digital Receipt in CDS kppg.Enable_Show_Digital_ReceiptinCDS();
		 * } else { test.log(LogStatus.FAIL,
		 * "Show Digital Receipt in CDS is not Displayed when Enabling Show Digital Receipt Screen"
		 * );
		 * 
		 * }
		 */
		
		//Enable Show Signature Pad
		kppg.Enable_Show_SignaturePad();
		
		//Enable Print CC Merchant Copy
		kppg.Enable_Print_CC_MerchantCopy();
				
		//Enable Remove Tip Line
		kppg.Enable_Remove_Tip_Line();
			
		//Enable Enable Itemized Receipt
		kppg.Enable_Enable_Itemized_Receipt();
				
		
		//Click the Update button
		kppg.Click_Update_inPrinters();
		
//		Thread.sleep(2000);
//		//Check whether the Kitchen Printer Settings updated or not
//		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Receipt Printer Updated Successfully"))
//		{
//			test.log(LogStatus.PASS, "Receipt Printers settings Updated Successfully");
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Receipt Printers settings Updated Failed");
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}Thread.sleep(6000);
//		
		Thread.sleep(1000);
		//Select the Printers Tab
		kppg.Click_Printers_Tab();
		Thread.sleep(1000);
		kppg.Click_Settings_Tab();
		
		//Check whether the Seat Ordering Override is Selected or not
		if(kppg.AutoPrintReceipt().isEnabled())
		{
			test.log(LogStatus.PASS, "Auto Print Receipt is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Auto Print Receipt is not Selected");
		}
		
		
		
		//Check whether the Show CC Receipt Screen is Selected or not
		if(kppg.Show_CC_ReceiptScreen().isEnabled())
		{
			test.log(LogStatus.PASS, "Show CC Receipt Screen is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Show CC Receipt Screen is not Selected");
		}
	
		//Disable Show CC Receipt Screen
//		kppg.Disable_Show_CC_ReceiptScreen();
		
		//Check whether the Print CC Customer Copy is Selected or not
		if(kppg.Print_CC_CustomerCopy().isEnabled())
		{
			test.log(LogStatus.PASS, "Print CC Customer Copy is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Print CC Customer Copy is not Selected");
		}
	
		//Disable Print CC Customer Copy
//		kppg.Disable_Print_CC_CustomerCopy();
		
		
		//Check whether the Show Digital Receipt Screen is Selected or not
		if(kppg.Show_Digital_ReceiptScreen().isEnabled())
		{
			test.log(LogStatus.PASS, "Show Digital Receipt Screen is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Show Digital Receipt Screen is not Selected");
		}
		
		//Check whether the Show Digital Receipt in CDS is Selected or not
				if(kppg.Show_Digital_ReceiptScreen().isEnabled())
				{
					test.log(LogStatus.PASS, "Show Digital Receipt in CDS is Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Show Digital Receipt in CDS is not Selected");
				}
	
		//Disable Serving Size in Front of Menu in KOT
		kppg.Disable_Show_Digital_ReceiptScreen();
	
		try
		{
		//Check whether the Show Digital Receipt in CDS is Displayed or not
		if(kppg.Show_Digital_ReceiptinCDS().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Show Digital Receipt in CDS is Displayed after Disabling Show Digital Receipt Screen");
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Show Digital Receipt in CDS is not Displayed after Disabling Show Digital Receipt Screen");
		}
		
		
		//Check whether the Show Signature Pad is Selected or not
		if(kppg.Show_SignaturePad().isEnabled())
		{
			test.log(LogStatus.PASS, "Show Signature Pad is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Show Signature Pad is not Selected");
		}
		
		//Check whether the Print CC Merchant Copy is Selected or not
		if(kppg.Print_CC_MerchantCopy().isEnabled())
		{
			test.log(LogStatus.PASS, "Print CC Merchant Copy is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Print CC Merchant Copy is not Selected");
		}
		
		//Check whether the Remove Tip Line is Selected or not
				if(kppg.Remove_Tip_Line().isEnabled())
				{
					test.log(LogStatus.PASS, "Remove Tip Line is Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Remove Tip Line is not Selected");
				}
				
				//Disable Remove Tip Line
				kppg.Disable_Remove_Tip_Line();
				
				
				//Check whether the Enable Itemized Receipt is Selected or not
				if(kppg.Remove_Tip_Line().isEnabled())
				{
					test.log(LogStatus.PASS, "Enable Itemized Receipt is Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Enable Itemized Receipt is not Selected");
				}
				
				
		Thread.sleep(5000);for(int i = 1;i <=20;i++) {driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);}Thread.sleep(5000);
		//Click the Update button
		kppg.Click_Update_inPrinters();
		
		Thread.sleep(2000);
		//Check whether the Kitchen Printer Settings updated or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Receipt Printer Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Receipt Printers settings Updated Successfully");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Receipt Printers settings Updated Failed");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}Thread.sleep(6000);
		
		
		//Select Printers Tab
		kppg.Click_Printers_Tab();
	}

}
