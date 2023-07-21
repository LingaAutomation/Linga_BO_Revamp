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

public class Settings_Kitchen_Printers 
{

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings - Kitchen Printers");
	
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
		Open_Kitchen_Printer_Page(driver);
		RefreshAndPaginination(driver);
		Add_Kitchen_Printer(driver);
		Edit_and_Close_Cancel_Kitchen_Printer(driver);
		Edit_and_Update_Kitchen_Printer(driver);
		Edit_and_KDS_Update_Kitchen_Printer(driver);
		Edit_and_Driver_Update_Kitchen_Printer(driver);
		Edit_and_Reselect_Printer_Update_Kitchen_Printer(driver);
		Update_Kitchen_Printer_Settings(driver);
		Create_DuplicateKitchen_PrinterGroup(driver);
		Delete_and_Active_Inactive_Kitchen_Printer(driver);

	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Kitchen_Printer_Page(WebDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Kitchen Printer page
		driver.get(Utility.getProperty("baseURL")+"settings/"+"kitchenPrinters");

		Thread.sleep(5000);
		//Verify the Kitchen Printers page loaded or not
		cmp.VerifyMainScreenPageHeader("Kitchen Printers");	
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
		//cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns_Table();
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_Kitchen_Printer(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);
		Thread.sleep(2000);
		//Click the New Kitchen Printers
		kppg.Click_NewKitchenPrinter();
		Thread.sleep(2000);
	
		//Verify the New Kitchen Printer creation screen opened or not 
		cmp.VerifyCreationScreenPageHeader("New Kitchen Printer");
		Thread.sleep(2000);
		
		//Select Printer Type
		kppg.Click_Printer_PrinterType();
		
		//Select the Printer option
		kppg.Select_PrinterModel();
				
		
						String NameExcess = "Entering Invalid Name to input"; 
						int ActualSize= NameExcess.length();
						System.out.println(ActualSize);
		
						//Enter the Kitchen Printer Name
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
				//Enter the Kitchen Printer Name
				cmp.EnterName(Utility.getProperty("Kitchen_Printer_Name"));
				Thread.sleep(500);

				//Enter the Invalid Ip Address
				kppg.Enter_IPAddress("abcd");
				
				//Check whether the Enter Valid IP Address pop up displayed or not
				kppg.Verify_Invalid_IP_AddressMsg("Enter Valid IP Address");
				
				//Enter the Invalid Ip Address
				kppg.Enter_IPAddress("190.1.1");
				
				//Check whether the Enter Valid IP Address pop up displayed or not
				kppg.Verify_Invalid_IP_AddressMsg("Enter Valid IP Address");
		
		
				//Enter the IP Address
				kppg.Enter_IPAddress(Utility.getProperty("Kitchen_Printer_IP"));
				
				//Enable Service Type Restriction
				kppg.Enable_EnableServiceTypeRestriction();
				
				
				//Enable Apply To All Categories
				kppg.Enable_ApplyToAllCategories();
				
				//Enable Apply To All Menu Items
				kppg.Enable_ApplyToAllMenuItems();
				
				
		Thread.sleep(1000);
				//Click the Save button
				cmp.Click_SaveButton();
		 
		Thread.sleep(3000);
		//Check whether the New Kitchen Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Printer Saved Successfully"))
		{
			test.log(LogStatus.PASS, "New Kitchen Printer Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Kitchen Printer Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		

	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Kitchen_Printer(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);

		
		Thread.sleep(1000);
		//Search the Kitchen Printers to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("Kitchen_Printer_Name"));
		
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Kitchen Printer");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Kitchen Printer Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Kitchen Printer Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen Printer not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Kitchen_Printer(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);

		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Kitchen_Printer_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Kitchen_Printer_Name")+"1");
		
		Thread.sleep(500);
		//Enable Alternate Printer
		kppg.Enable_AlternatePrinter();
		
		//Select the Alternate Printer
		kppg.Select_Alternate_Printer();
		
		
		Thread.sleep(500);
		//Click the Update and Publish button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Kitchen Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Printer Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Kitchen Printer updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Kitchen Printer updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		

	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_KDS_Update_Kitchen_Printer(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);

		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Kitchen_Printer_Name")+"1");
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Kitchen_Printer_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Click and Change to KDS
		kppg.Click_KDS_PrinterType();
		
		//Disable Expo Device
		kppg.Disable_ExpoDevice();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Kitchen Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Kitchen Printer Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Kitchen Printer updated successfully for KDS");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("This printer is configured in `Printer Reroute`. Could not change."))
		{
			test.log(LogStatus.INFO, "Kitchen Printer updated fail for This printer is configured in `Printer Reroute`. Could not change.");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(500);
			cmp.Click_CancelButton();
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen Printer updated fail for KDS");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 

		Thread.sleep(3000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Kitchen_Printer_Name"));
		
		Thread.sleep(1500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Kitchen_Printer_Name"));
		
		Thread.sleep(1000);
		//Check whether the KDS Printer is Selected or not
		if(kppg.KDS_KitchenPrinterBtn().isSelected())
		{
			test.log(LogStatus.PASS, "KDS Printer Type Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "KDS Printer Type not selected");
		}
		
		Thread.sleep(500);
		//Enable Expo Device
		kppg.Enable_ExpoDevice();
		
		//Enter the Invalid Ip Address
		kppg.Enter_Expo_Printer_IPAddress("abcd");
		
		try
		{
		//Check whether the Enter Valid IP Address pop up displayed or not
		if(kppg.Invalid_IPAddressErrorMsg().getText().equalsIgnoreCase("Enter Valid IP Address"))
		{
			test.log(LogStatus.PASS, "Enter Valid IP Address Displayed when Entering Alphabtics in Expo Printer IP Address");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Enter Valid IP Address not Displayed when Entering Alphabtics in Expo Printer IP Address");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

		//Enter the Invalid Ip Address
		kppg.Enter_Expo_Printer_IPAddress("190.1.1");
		
		try
		{
		//Check whether the Enter Valid IP Address pop up displayed or not
				if(kppg.Invalid_IPAddressErrorMsg().getText().equalsIgnoreCase("Enter Valid IP Address"))
				{
					test.log(LogStatus.PASS, "Enter Valid IP Address Displayed when Entering Incorrect in Expo Printer IP Address");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
		}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Enter Valid IP Address not Displayed when Entering Incorrect in Expo Printer IP Address");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
		
		
		//Enter the Expo Device IP
				kppg.Enter_Expo_Printer_IPAddress(Utility.getProperty("Kitchen_Printer_IP")+"1");
				
				
		//Enter the Expo Device IP
		kppg.Enter_Expo_Printer_IPAddress(Utility.getProperty("Kitchen_Printer_IP")+"1");
		
		//Enter the Invalid Ip Address
		kppg.Enter_Queue_Device_IPAddress("abcd");
		
		//Check whether the Enter Valid IP Address Expo Device pop up displayed or not
//		kppg.Verify_Invalid_IP_AddressMsg("Enter Valid IP Address");
		try
		{
				if(kppg.Invalid_IPAddressErrorMsg().getText().equalsIgnoreCase("Enter Valid IP Address"))
				{
					test.log(LogStatus.PASS, "Enter Valid IP Address Displayed when Entering Alphabtics in Queue Device IP Address");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
		}
		catch(Exception k)
				{
					test.log(LogStatus.FAIL, "Enter Valid IP Address not Displayed when Entering Alphabtics in Queue Device IP Address");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
		
		
		//Check whether the Enter Valid IP Address pop up displayed or not
//		kppg.Verify_Invalid_IP_AddressMsg("Enter Valid IP Address");
		
		//Enter the Invalid Ip Address
		kppg.Enter_Queue_Device_IPAddress("190.1.1");
		
		//Check whether the Enter Valid IP Address Expo Device pop up displayed or not
//		kppg.Verify_Invalid_IP_AddressMsg("Enter Valid IP Address");
		try
		{
				if(kppg.Invalid_IPAddressErrorMsg().getText().equalsIgnoreCase("Enter Valid IP Address"))
				{
					test.log(LogStatus.PASS, "Enter Valid IP Address Displayed when Entering Incorrect in Queue Device IP Address");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
		}
				catch(Exception lk)
				{
					test.log(LogStatus.FAIL, "Enter Valid IP Address not Displayed when Entering Incorrect in Queue Device IP Address");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
		
		
		//Check whether the Enter Valid IP Address pop up displayed or not
//		kppg.Verify_Invalid_IP_AddressMsg("Enter Valid IP Address");
	
		
		//Enter the Queue Device IP Address
		kppg.Enter_Queue_Device_IPAddress(Utility.getProperty("Kitchen_Printer_IP")+"2");
		
				Thread.sleep(500);
				//Click the Update button
				cmp.Click_UpdateButton();
				
				Thread.sleep(3000);
				//Check whether the New Kitchen Printer Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Kitchen Printer Updated Successfully"))
				{
					test.log(LogStatus.PASS, "Kitchen Printer updated successfully for KDS");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("This printer is configured in `Printer Reroute`. Could not change."))
				{
					test.log(LogStatus.INFO, "Kitchen Printer updated fail for This printer is configured in `Printer Reroute`. Could not change.");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
					
					Thread.sleep(500);
					cmp.Click_CancelButton();
				}
				else
				{
					test.log(LogStatus.FAIL, "Kitchen Printer updated fail for KDS");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				
				}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Driver_Update_Kitchen_Printer(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);

		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Kitchen_Printer_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Kitchen_Printer_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Click and Change to KDS
		kppg.Click_Driver_PrinterType();
		
		//Select Service type Restriction
		kppg.Enable_EnableServiceTypeRestriction();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Kitchen Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Kitchen Printer Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Kitchen Printer updated successfully for Driver");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("This printer is configured in `Printer Reroute`. Could not change."))
		{
			test.log(LogStatus.INFO, "Kitchen Printer updated fail for This printer is configured in `Printer Reroute`. Could not change.");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(500);
			cmp.Click_CancelButton();
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen Printer updated fail for Driver");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
		
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Reselect_Printer_Update_Kitchen_Printer(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);

		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Kitchen_Printer_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Kitchen_Printer_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		Thread.sleep(1000);
		//Check whether the KDS Printer is Selected or not
		if(kppg.Driver_KitchenPrinterBtn().isSelected())
		{
			test.log(LogStatus.PASS, "Printer Type Driver Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Type Driver not selected");
		}
		
		//Click and Change to KDS
		kppg.Click_Printer_PrinterType();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Kitchen Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Kitchen Printer Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Kitchen Printer updated successfully for Printer");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("This printer is configured in `Printer Reroute`. Could not change."))
		{
			test.log(LogStatus.INFO, "Kitchen Printer updated fail for This printer is configured in `Printer Reroute`. Could not change.");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(500);
			cmp.Click_CancelButton();
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen Printer updated fail for Printer");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 

		
		Thread.sleep(3000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Kitchen_Printer_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Kitchen_Printer_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		Thread.sleep(1000);
		//Check whether the KDS Printer is Selected or not
		if(kppg.Printer_KitchenPrinterBtn().isSelected())
		{
			test.log(LogStatus.PASS, "Printer Type Printer Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Type Printer not selected");
		}
		
		//Click the Cancel button
		cmp.Click_CancelButton();
		
	}

	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Kitchen_Printer(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);

		//Search and Click Delete button
				cmp.SearchAndClickDelete(Utility.getProperty("Kitchen_Printer_Name"));
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();
		
				Thread.sleep(3000);
				try
				{
				//Check whether the New Kitchen Printer Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Printer deleted successfully"))
				{
					test.log(LogStatus.FAIL, "Kitchen Printer Deleted when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Kitchen Printer not Deleted when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Kitchen_Printer_Name"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Kitchen Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Printer deleted successfully"))
		{
			test.log(LogStatus.PASS, "Kitchen Printer Deleted Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen Printer Deletion Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	

	@Test(priority = 5,enabled = false)
	public void Update_Kitchen_Printer_Settings(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);

		//Select Settings Kitchen Printer
		kppg.Click_Settings_Tab();
		
		//Enable Seat Ordering Override
		kppg.Enable_SeatOrderingOverride();
		
		//Enable Print Voided Items to the Kitchen
		kppg.Enable_Print_VoidedItemstotheKitchen();
		
		//Enable Print Included Modifier In Kitchen
		kppg.Enable_Print_IncludedModifierInKitchen();
		
		//Enable Print Included Modifier For Alternate Modifier
		kppg.Enable_Print_IncludedModifier_For_AlternateModifier();
		
		//Enable Serving Size in Front of Menu in KOT
		kppg.Enable_ServingSizeinFront_of_MenuinKOT();
		
		//Click the Update button
		kppg.Click_Update_inPrinters();
		
		Thread.sleep(2000);
		//Check whether the Kitchen Printer Settings updated or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Kitchen Printers settings Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Kitchen Printers settings Updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen Printers settings Updated Failed");
		}
		
		Thread.sleep(1000);
		//Select the Printers Tab
		kppg.Click_Printers_Tab();
		Thread.sleep(1000);
		kppg.Click_Settings_Tab();
		
		//Check whether the Seat Ordering Override is Selected or not
		if(kppg.SeatOrderingOverride_YesBtn().isSelected())
		{
			test.log(LogStatus.PASS, "Seat Ordering Override is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Seat Ordering Override is not Selected");
		}
		
		//Disable Seat Ordering Override
		kppg.Disable_SeatOrderingOverride();
		
		
		//Check whether the Print Voided Items to the Kitchen is Selected or not
		if(kppg.Print_VoidedItemstotheKitchen_YesBtn().isSelected())
		{
			test.log(LogStatus.PASS, "Print Voided Items to the Kitchen is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Print Voided Items to the Kitchen is not Selected");
		}
	
		//Disable Print Voided Items to the Kitchen
		kppg.Disable_Print_VoidedItemstotheKitchen();
		
		//Check whether the Print Included Modifier For Alternate Modifier is Selected or not
		if(kppg.Print_IncludedModifier_For_AlternateModifier_YesBtn().isSelected())
		{
			test.log(LogStatus.PASS, "Print Included Modifier For Alternate Modifier is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Print Included Modifier For Alternate Modifier is not Selected");
		}
	
		//Disable Print Voided Items to the Kitchen
		kppg.Disable_Print_IncludedModifier_For_AlternateModifier();
		
		
		//Check whether the Serving Size in Front of Menu in KOT is Selected or not
		if(kppg.ServingSizeinFront_of_MenuinKOT_YesBtn().isSelected())
		{
			test.log(LogStatus.PASS, "Serving Size in Front of Menu in KOT is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Serving Size in Front of Menu in KOT is not Selected");
		}
	
		Thread.sleep(2000);
		//Disable Serving Size in Front of Menu in KOT
		kppg.Disable_ServingSizeinFront_of_MenuinKOT();
		
		Thread.sleep(2000);
		//Click the Update button
		kppg.Click_Update_inPrinters();
		
		Thread.sleep(2000);
		//Check whether the Kitchen Printer Settings updated or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Kitchen Printers settings Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Kitchen Printers settings Updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen Printers settings Updated Failed");
		}
		
		Thread.sleep(1000);
		//Select Printers Tab
		kppg.Click_Printers_Tab();
		Thread.sleep(1000);
	}
	
	@Test(priority = 6,enabled = false)
	public void Create_DuplicateKitchen_PrinterGroup(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Kitchen Printers
		kppg.Click_NewKitchenPrinter();
		Thread.sleep(2000);
	
		//Verify the New Kitchen Printer creation screen opened or not 
		cmp.VerifyCreationScreenPageHeader("New Kitchen Printer");
		Thread.sleep(2000);
			
		//Select Printer Type
		kppg.Click_Printer_PrinterType();
		
		//Select the Printer option
		kppg.Select_PrinterModel();
		
		Thread.sleep(1000);
		//Enter the Kitchen Printer Name
		cmp.EnterName(Utility.getProperty("Kitchen_Printer_Name"));
		Thread.sleep(500);

				
		//Enter the IP Address
		kppg.Enter_IPAddress(Utility.getProperty("Kitchen_Printer_IP"));
		
		//Enable Service Type Restriction
		kppg.Enable_EnableServiceTypeRestriction();
		
		
		//Enable Apply To All Categories
		kppg.Enable_ApplyToAllCategories();
		
		//Enable Apply To All Menu Items
		kppg.Enable_ApplyToAllMenuItems();
		
		
 Thread.sleep(1000);
		//Click the Save button
		cmp.Click_SaveButton();

		
		Thread.sleep(3000);
		//Check whether the New Kitchen Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Kitchen Printer Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			//Click the Cancel button button
			cmp.Click_CancelButton();
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enter valid printer type"))
		{
			test.log(LogStatus.INFO, "Enter valid printer type is Displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen Printer Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_CancelButton();
		}
		
		
	}
	
}
