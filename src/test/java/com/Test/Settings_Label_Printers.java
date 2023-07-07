package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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

public class Settings_Label_Printers 
{

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings - Label Printers");
	
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
		Open_Label_Printer_Page(driver);
		RefreshAndPaginination(driver);
		Add_Kitchen_Label_Label_Printer(driver);
		Edit_and_Close_Cancel_Label_Printer(driver);
		Edit_and_Update_Label_Printer(driver);
		Edit_and_Box_Level_Update_Label_Printer(driver);
		Edit_and_Reselect_Printer_Update_Label_Printer(driver);
		Create_Duplicate_Label_Printer(driver);
		Delete_and_Active_Inactive_Label_Printer(driver);

	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Label_Printer_Page(WebDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Label Printer page
		driver.get(Utility.getProperty("baseURL")+"settings/"+"labelPrinters");

		Thread.sleep(5000);
		//Verify the Label Printers page loaded or not
		cmp.VerifyMainScreenPageHeader("Label Printers");	
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
	public void Add_Kitchen_Label_Label_Printer(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);
		Thread.sleep(2000);
		//Click the New Label Printers
		kppg.Click_New_LabelPrinter();
		Thread.sleep(2000);
	
		//Verify the New Label Printer creation screen opened or not 
		cmp.VerifyCreationScreenPageHeader("New Label Printer");
		Thread.sleep(2000);
		
//		//Check whether the Save button 
//		if(cmp.Save_Button().isEnabled())
//		{
//			test.log(LogStatus.FAIL, "Save button Enables without Entering Mandatory Fields");
//		}
//		else
//		{
//			test.log(LogStatus.PASS, "Save button not Enables without Entering Mandatory Fields");
//
//		}
		
		//Select Kitchen Label Printer Type
		kppg.Click_KitchenLabel_PrinterType();
		
		//Select the Printer option
		kppg.Select_PrinterModel();
				
		
						String NameExcess = "Entering Invalid Name to input"; 
						int ActualSize= NameExcess.length();
						System.out.println(ActualSize);
		
						//Enter the Label Printer Name
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
				//Enter the Label Printer Name
				cmp.EnterName(Utility.getProperty("Label_Printer_Name"));
				Thread.sleep(500);

				//Enter the Invalid Ip Address
				kppg.Enter_IPAddress("abcd");
				
				Thread.sleep(1000);
				//Check whether the Enter Valid IP Address pop up displayed or not
				kppg.Verify_Invalid_IP_AddressMsg("Enter Valid IP Address");
				
				Thread.sleep(1000);
				//Enter the Invalid Ip Address
				kppg.Enter_IPAddress("190.1.1"); 
				
				Thread.sleep(1000);
				//Check whether the Enter Valid IP Address pop up displayed or not
				kppg.Verify_Invalid_IP_AddressMsg("Enter Valid IP Address");
		
				Thread.sleep(1000);
				//Enter the IP Address
				kppg.Enter_IPAddress(Utility.getProperty("Label_Printer_IP"));
				
				Thread.sleep(1000);
				//Enable Service Type Restriction
				kppg.Enable_EnableServiceTypeRestriction();
				
				Thread.sleep(1000);
				//Enable Apply To All Categories
				kppg.Enable_ApplyToAllCategories();
				
				Thread.sleep(1000);
				//Enable Apply To All Menu Items
				kppg.Enable_ApplyToAllMenuItems();
				
				
				Thread.sleep(1000);
				//Click the Save button
				cmp.Click_SaveButton();
		 
		Thread.sleep(3000);
		//Check whether the New Label Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Label Printer Saved Successfully"))
		{
			test.log(LogStatus.PASS, "New Label Printer Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Label Printer Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		

	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Label_Printer(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);

		
		Thread.sleep(1000);
		//Search the Label Printers to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("Label_Printer_Name"));
		
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Label Printer");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Label Printer Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Label Printer Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Label Printer not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Label_Printer(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);

		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Label_Printer_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Label_Printer_Name")+"1");
		
		Thread.sleep(500);
		//Enable Alternate Printer
		kppg.Enable_AlternatePrinter();
		
		//Select the Alternate Printer
		kppg.Select_Alternate_Printer();
		
		
		Thread.sleep(500);
		//Click the Update and Publish button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Label Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Label Printer Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Label Printer updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Label Printer updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		

	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Box_Level_Update_Label_Printer(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);

		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Label_Printer_Name")+"1");
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Label_Printer_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);
		
		//Get the Printer model before changing printer type
		String PrinterModel_Bef=kppg.Printer_ModelInputBox().getAttribute("value");
		
		//Get the Alternate Printer model before changing printer type
				String Alternate_PrinterModel_Bef=kppg.Alternate_PrinterInputBox().getAttribute("value");
				

		//Click and Change to KDS
		kppg.Click_BoxLabel_PrinterType();
		
		//Get the Printer model After changing printer type
				String PrinterModel_Aft=kppg.Printer_ModelInputBox().getAttribute("value");
				
				//Get the Alternate Printer model After changing printer type
				String Alternate_PrinterModel_Aft=kppg.Alternate_PrinterInputBox().getAttribute("value");
			
		//Check whether the Printer model changed or not while changing Printer Type		
		if(PrinterModel_Bef.equals(PrinterModel_Aft))
		{
			test.log(LogStatus.PASS, "Printer Model not Changing After changed Printer Type");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Model Changing After changed Printer Type");
		}
		
		//Check whether the Alternate Printer model changed or not while changing Printer Type		
				if(Alternate_PrinterModel_Bef.equals(Alternate_PrinterModel_Aft))
				{
					test.log(LogStatus.PASS, "Alternate Printer not Changing After changed Printer Type");
				}
				else
				{
					test.log(LogStatus.FAIL, "Alternate Printer Changing After changed Printer Type");
				}
					
				
				
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Label Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Label Printer Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Label Printer updated successfully for Box Level");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("This printer is configured in `Printer Reroute`. Could not change."))
		{
			test.log(LogStatus.INFO, "Label Printer updated fail for This printer is configured in `Printer Reroute`. Could not change.");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(500);
			cmp.Click_CancelButton();
		}
		else
		{
			test.log(LogStatus.FAIL, "Label Printer updated fail for Box Level");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 

		Thread.sleep(3000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Label_Printer_Name"));
		
		Thread.sleep(1500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Label_Printer_Name"));
		
		Thread.sleep(1000);
		//Check whether the KDS Printer is Selected or not
		if(kppg.Box_LabelBtn().isEnabled())
		{
			test.log(LogStatus.PASS, "Box Label Printer Type Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Box Label Printer Type not selected");
		}
		
		//Click Cancel button
		cmp.Click_CancelButton();
	
				
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Reselect_Printer_Update_Label_Printer(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);

		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Label_Printer_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Label_Printer_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		Thread.sleep(1000);		
		//Click and Change to KDS
		kppg.Click_KitchenLabel_PrinterType();
		
		Thread.sleep(1500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Label Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Label Printer Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Label Printer updated successfully for Kitchen Label");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("This printer is configured in `Printer Reroute`. Could not change."))
		{
			test.log(LogStatus.INFO, "Label Printer updated fail for This printer is configured in `Printer Reroute`. Could not change.");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(500);
			cmp.Click_CancelButton();
		}
		else
		{
			test.log(LogStatus.FAIL, "Label Printer updated fail for Kitchen Label");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 

		
		Thread.sleep(3000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Label_Printer_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Label_Printer_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		Thread.sleep(1000);
		//Check whether the KDS Printer is Selected or not
		if(kppg.Kitchen_LabelBtn().isEnabled())
		{
			test.log(LogStatus.PASS, "Printer Type Printer Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Type Printer not selected");
		}
		
		Thread.sleep(1000);
		//Click the Cancel button
		cmp.Click_CancelButton();
		Thread.sleep(1000);
		
	}

	@Test(priority = 6,enabled = false)
	public void Create_Duplicate_Label_Printer(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Label Printers
		kppg.Click_New_LabelPrinter();
		Thread.sleep(2000);
	
		//Verify the New Label Printer creation screen opened or not 
		cmp.VerifyCreationScreenPageHeader("New Label Printer");
		Thread.sleep(2000);
			
		//Select Printer Type
		kppg.Click_KitchenLabel_PrinterType();
		
		//Select the Printer option
		kppg.Select_PrinterModel();
		
		Thread.sleep(1000);
		//Enter the Label Printer Name
		cmp.EnterName(Utility.getProperty("Label_Printer_Name"));
		Thread.sleep(500);

				
		//Enter the IP Address
		kppg.Enter_IPAddress(Utility.getProperty("Label_Printer_IP"));
		
		//Enable Service Type Restriction
		kppg.Enable_EnableServiceTypeRestriction();
		
		
		//Enable Apply To All Categories
		kppg.Enable_ApplyToAllCategories();
		
		//Enable Apply To All Menu Items
		kppg.Enable_ApplyToAllMenuItems();
		
		
 Thread.sleep(1000);
		//Click the Save button
		cmp.Click_SaveButton();

		
		Thread.sleep(2000);
		//Check whether the New Kitchen Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Label Printer Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Label Printer Saved Successfully"))
		{
			test.log(LogStatus.FAIL, "Duplicate Label Printer Saved when Entering Existing Name");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			//Click New Label Printer
			kppg.Click_New_LabelPrinter();
		}
		else
		{
			test.log(LogStatus.FAIL, "Label Printer Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			
		}
		
		Robot rt=new Robot();
		rt.keyPress(KeyEvent.VK_UP);
		rt.keyPress(KeyEvent.VK_UP);

		Thread.sleep(4000);
		//Select the Printer option
		kppg.Select_PrinterModel();
		
		
		Thread.sleep(1000);
		//Enter the Kitchen Printer Name
		cmp.EnterName(Utility.getProperty("Label_Printer_Name")+"BB");
		Thread.sleep(500);

		//Enter the IP Address
				kppg.Enter_IPAddress(Utility.getProperty("Label_Printer_IP"));
				
		
			
		
	
		
 Thread.sleep(1000);
		//Click the Save button
		cmp.Click_SaveButton();

		
		Thread.sleep(3000);
		//Check whether the New Kitchen Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("IP address already exists"))
		{
			test.log(LogStatus.PASS, "Label Printer IP address already exists pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			//Click the Cancel button
			cmp.Click_CancelButton();
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Label Printer Saved Successfully"))
		{
			test.log(LogStatus.FAIL, "Duplicate Label Printer Saved when Entering Existing IP Address");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}	
		else
		{
			test.log(LogStatus.FAIL, "Label Printer IP address already exists pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}
	
	
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Label_Printer(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		kppg=new KitchenPrinterPage(driver, test);

		//Search and Click Delete button
				cmp.SearchAndClickDelete(Utility.getProperty("Label_Printer_Name"));
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();
		
				Thread.sleep(3000);
				try
				{
				//Check whether the New Label Printer Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Printer deleted successfully"))
				{
					test.log(LogStatus.FAIL, "Label Printer Deleted when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Label Printer not Deleted when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Label_Printer_Name"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Label Printer Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Printer deleted successfully"))
		{
			test.log(LogStatus.PASS, "Label Printer Deleted Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Label Printer Deletion Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	

		
	
}
