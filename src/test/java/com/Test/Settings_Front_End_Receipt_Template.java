package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import com.Pages.Front_End_Receipt_TemplatePage;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Front_End_Receipt_Template {

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings - Front End Receipt (Receipt Printer Template)");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Front_End_Receipt_TemplatePage fert;
	
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
	//	Disable_All_Front_End_Receipt_Template_Settings(driver);
		Verify_Disabled_and_Enable_All_Front_End_Receipt_Template_Settings(driver);
		Verify_Enabled_All_Front_End_Receipt_Template_Settings(driver);

	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Label_Printer_Page(WebDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		fert=new Front_End_Receipt_TemplatePage(driver, test);
		Thread.sleep(5000);
		//Load the Front End Receipt Template page
		driver.get(Utility.getProperty("baseURL")+"settings/"+"frontEndReceipt");

		Thread.sleep(5000);
		//Verify the Front End Receipt Template page loaded or not
		if(fert.Front_EndReceipt_Header().isDisplayed())
		{
			test.log(LogStatus.PASS, "Front End Receipt Template Page Loaded Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Front End Receipt Template Page Loading Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Disable_All_Front_End_Receipt_Template_Settings(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		fert=new Front_End_Receipt_TemplatePage(driver, test);
		Thread.sleep(2000);
	
		//Open Print_Template screen
		fert.Open_Print_Template_Screen();
		
		Thread.sleep(1000);	
		//Click Small Font Size
		fert.Click_Small_FontSize();
		
		Thread.sleep(1000);
		//Close Print Template
		fert.Close_Print_Template_Screen();
		
		Thread.sleep(1000);
		//Open Store Info Screen
		fert.Open_Store_Info_Screen();
		
		
		Thread.sleep(1000);
		//Un-Select the Store Name Font
		try
		{
		if(fert.Store_Logo_CheckBox_Selected().isDisplayed())
		{
			Thread.sleep(1000);
			fert.Store_Logo_CheckBox().click();
		}
		}
		catch(Exception g)
		{
			
		}
			
				//Un-Select the Email in Store Info Font
				try
				{
				if(fert.Email_StoreInfo_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Email_StoreInfo_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Store Name in Store Info Font
				try
				{
				if(fert.Store_Name_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Store_Name_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Phone Number in Store Info Font
				try
				{
				if(fert.Phone_Number_StoreInfo_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Phone_Number_StoreInfo_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				
				//Un-Select the Address in Store Info Font
				try
				{
				if(fert.Address_StoreInfo_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Address_StoreInfo_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Header Notes in Store Info Font
				try
				{
				if(fert.Header_Notes_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Header_Notes_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				Thread.sleep(1000);
				//Close Store Info Screen
				fert.Close_Store_Info_Screen();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

				
				Thread.sleep(1000);
				//Open Chcek details
				fert.Open_Check_Details_Screen();
				
				Thread.sleep(1000);
				//Un-Select the Check Number in Check Details
				try
				{
				if(fert.Check_Number_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Check_Number_CheckBox().click();
					
					try
					{
						if(fert.Block_1_RadioBtn().isDisplayed())
						{
							test.log(LogStatus.FAIL, "Position is Displayed after Check Number Checkbox unselected");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
					}
					catch(Exception l)
					{
						test.log(LogStatus.PASS, "Position is not Displayed after Check Number Checkbox unselected");

					}
				}
				}
				catch(Exception g)
				{
					
				}
				
				
				//Un-Select the Table Name in Check Details
				try
				{
				if(fert.Table_Name_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Table_Name_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				
				//Un-Select the Seat Number in Check Details
				try
				{
				if(fert.Seat_Number_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Seat_Number_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				
				//Un-Select the Check open server in Check Details
				try
				{
				if(fert.Check_Open_Server_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Check_Open_Server_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				

				//Un-Select the Check Close Server in Check Details
				try
				{
				if(fert.Check_Close_Server_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Check_Close_Server_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				
				//Un-Select the Open date & time in Check Details
				try
				{
				if(fert.Open_Date_Time_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Open_Date_Time_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Close date & time in Check Details
				try
				{
				if(fert.Close_Date_Time_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Close_Date_Time_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Service Type in Check Details
				try
				{
				if(fert.Service_Type_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Service_Type_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Close Check details Screen
				fert.Close_Check_Details_Screen();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				
				Thread.sleep(1000);
				//Open Order Summary screen
				fert.Open_Order_Summary_Screen();
				
				Thread.sleep(1000);
				//Un-Select the Secondary Menu Name in Order Summary
				try
				{
				if(fert.Secondary_MenuName_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Secondary_MenuName_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Roll Out Modifier Price To Menu in Order Summary
				try
				{
				if(fert.RollOut_ModifierPrice_To_Menu_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.RollOut_ModifierPrice_To_Menu_CheckBox().click();
					
					
					try
					{
						if(fert.RollOut_Modifier_To_Menu_CheckBox().isDisplayed())
						{
							test.log(LogStatus.FAIL, "Roll Out Modifier To Menu Check box Displayed when Roll Out Modifier Price To Menu Check box Unselected");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
					}
					catch(Exception k)
					{
						test.log(LogStatus.PASS, "Roll Out Modifier To Menu Check Box not Displayed when Roll Out Modifier Price To Menu Check box Unselected");

					}
				}
				}
				catch(Exception g)
				{
					
				}
				
				
				Thread.sleep(1000);
				//Un-Select the Exclude Zero Price Menu Item in Order Summary
				try
				{
				if(fert.Exclude_ZeroPrice_MenuItem_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Exclude_ZeroPrice_MenuItem_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				
				
				Thread.sleep(1000);
				//Un-Select the Exclude Zero Price Modifier in Order Summary
				try
				{
				if(fert.Exclude_ZeroPrice_Modifier_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Exclude_ZeroPrice_Modifier_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				
				
				Thread.sleep(1000);
				//Un-Select the Tax Total in Order Summary
				try
				{
				if(fert.Tax_Total_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Tax_Total_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				Thread.sleep(1000);
				//Un-Select the Hide Inclusive Tax  in Order Summary
				try
				{
				if(fert.Hide_Inclusive_Tax_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Hide_Inclusive_Tax_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				Thread.sleep(1000);
				//Un-Select the Gratuity in Order Summary
				try
				{
				if(fert.Gratuity_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Gratuity_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				Thread.sleep(1000);
				//Un-Select the Tip in Order Summary
				try
				{
				if(fert.Tip_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Tip_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				Thread.sleep(1000);
				//Un-Select the Cash Discount in Order Summary
				try
				{
				if(fert.Cash_Discount_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Cash_Discount_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				Thread.sleep(1000);
				//Un-Select the Check Total in Order Summary
				try
				{
				if(fert.Check_Total_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Check_Total_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Tender Details in Order Summary
				try
				{
				if(fert.Tender_Details_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Tender_Details_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Show Membership Balance in Order Summary
				try
				{
				if(fert.Show_Membership_Balance_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Show_Membership_Balance_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Loyalty Amount in Order Summary
				try
				{
				if(fert.Loyalty_Amount_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Loyalty_Amount_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Discount under the Menu Item in Order Summary
				try
				{
				if(fert.Discount_Under_MenuItem_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Discount_Under_MenuItem_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				

				//Un-Select the Print Check in Primary & Secondary Languages in Order Summary
				try
				{
				if(fert.Print_Check_inPrimary_SecondaryLanguages_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Print_Check_inPrimary_SecondaryLanguages_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Close the Order Summary Screen
				fert.Close_Order_Summary_Screen();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

				
				Thread.sleep(1000);
				//Open Customer Info Screen
				fert.Open_Customer_Info_Screen();
				
				Thread.sleep(1000);
				//Un-Select the Customer Name in Customer Info
				try
				{
				if(fert.Customer_Name_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Customer_Name_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Address in Customer Info
				try
				{
				if(fert.Address_CustomerInfo_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Address_CustomerInfo_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Phone Number in Customer Info
				try
				{
				if(fert.Phone_Number_CustomerInfo_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Phone_Number_CustomerInfo_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Email in Customer Info
				try
				{
				if(fert.Email_CustomerInfo_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Email_CustomerInfo_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				
				//Un-Select the Customer Notes in Customer Info
				try
				{
				if(fert.Customer_Notes_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Customer_Notes_CheckBox().click();
					
					try
					{
						if(fert.Customer_Notes_TextBox().isDisplayed())
						{
							test.log(LogStatus.FAIL, "Customer Notes Text Box is Displayed when Customer Notes Check Box Unselected");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
					}
					catch(Exception l)
					{
						test.log(LogStatus.PASS, "Customer Notes Text Box is not Displayed when Customer Notes Check Box Unselected");

					}
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Close the Customer Info Screen
				fert.Close_Customer_Info_Screen();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

				Thread.sleep(1000);
				
				//Open the Additional Settings Screen
				fert.Open_Additional_Settings_Screen();
				
				Thread.sleep(1000);
				//Un-Select the Tip Line in Additional Settings
				try
				{
				if(fert.Tip_Line_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Tip_Line_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Signature in Additional Settings
				try
				{
				if(fert.Signature_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Signature_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Show E-Invoice URL in Additional Settings
				try
				{
				if(fert.Show_EInvoice_URL_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Show_EInvoice_URL_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Show E-Invoice QR in Additional Settings
				try
				{
				if(fert.Show_EInvoice_QR_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Show_EInvoice_QR_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Tip Suggestion in Additional Settings
				try
				{
				if(fert.Tip_Suggestion_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Tip_Suggestion_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Special Notes in Additional Settings
				try
				{
				if(fert.Special_Notes_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Special_Notes_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Barcode in Additional Settings
				try
				{
				if(fert.Barcode_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Barcode_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Cut Paper After Each print in Additional Settings
				try
				{
				if(fert.Cut_Paper_After_Each_Print_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Cut_Paper_After_Each_Print_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Show Remaining Balance in Additional Settings
				try
				{
				if(fert.Show_Remaining_Balance_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Show_Remaining_Balance_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				
				//Close the Additional Settings Screen
				fert.Close_Additional_Settings_Screen();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

				Thread.sleep(1000);
				
				//Open the Merchant Copy Screen
				fert.Open_Merchant_Copy_Screen();
				
				Thread.sleep(1000);
				//Un-Select the Print GC Balance in Merchant Copy
				try
				{
				if(fert.Print_GC_Balance_MerchantCopy_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Print_GC_Balance_MerchantCopy_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Print HA Balance in Merchant Copy
				try
				{
				if(fert.Print_HA_Balance_MerchantCopy_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Print_HA_Balance_MerchantCopy_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Print Tab Name in Merchant Copy
				try
				{
				if(fert.Print_Tab_Name_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Print_Tab_Name_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Print Membership Balance in Merchant Copy
				try
				{
				if(fert.Print_Membership_Balance_MerchantCopy_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Print_Membership_Balance_MerchantCopy_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Close the Merchant Copy Screen
				fert.Close_Merchant_Copy_Screen();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

				Thread.sleep(1000);
				//Open the Customer Copy Screen
				fert.Open_Customer_Copy_Screen();
				
				Thread.sleep(1000);
				//Un-Select the Print GC Balance in Customer Copy
				try
				{
				if(fert.Print_GC_Balance_CustomerCopy_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Print_GC_Balance_CustomerCopy_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Print HA Balance in Customer Copy
				try
				{
				if(fert.Print_HA_Balance_CustomerCopy_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Print_HA_Balance_CustomerCopy_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Un-Select the Print Membership Balance in Customer Copy
				try
				{
				if(fert.Print_Membership_Balance_CustomerCopy_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(1000);
					fert.Print_Membership_Balance_CustomerCopy_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				//Close the Customer Copy Screen
				fert.Close_Customer_Copy_Screen();
				
				
				
				Thread.sleep(1000);
				//Click the Update button
				cmp.Click_Update_ButtonTwo();
				
				Thread.sleep(3000);
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Receipt Template Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Front End Receipt Template Saved Successfully After Disable All Checkboxes");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Front End Receipt Template Save Failed After Disabling All Checkboxes");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				Thread.sleep(3000);
				driver.navigate().refresh();
	}
	
	@Test(priority = 5,enabled = false)
	public void Verify_Disabled_and_Enable_All_Front_End_Receipt_Template_Settings(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		fert=new Front_End_Receipt_TemplatePage(driver, test);
		Thread.sleep(2000);
		
		Thread.sleep(5000);
		//Open Print_Template screen
				fert.Open_Print_Template_Screen();
				
		Thread.sleep(1000);
		//Check Whether the Small Font Size
		if(fert.Small_RadioButton_SLD().isDisplayed())
		{
			test.log(LogStatus.PASS, "Small Font Size is Selected");
			
			//Enable Medium Font Size
			fert.Click_Medium_FontSize();
		}
		else
		{
			test.log(LogStatus.FAIL, "Small Font Size is not Selected");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Close Print_Template screen
				fert.Close_Print_Template_Screen();
				
		
		Thread.sleep(1000);
		//Open Store Info Screen
		fert.Open_Store_Info_Screen();
		
		try
		{
		Thread.sleep(1000);
		//Un-Select the Store Name Font
		if(fert.Store_Logo_CheckBox_Selected().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Store Name Check Box not Selected while Reopening the page After Saved");					

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Store Name Check Box not Selected while Reopening the page After Saved");					
			Thread.sleep(1000);
			fert.Store_Logo_CheckBox().click();
			
			Thread.sleep(1000);
			if(fert.Store_Logo_Upload().isDisplayed())
			{
				test.log(LogStatus.PASS, "Store Logo Upload Button Available");
				
				Thread.sleep(1000);
				fert.Store_Logo_Upload().sendKeys(Utility.getProperty("Store_Logo_Path"));
			}
			else
			{
				test.log(LogStatus.FAIL, "Store Logo Upload button Unavailable");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
			
		try
		{
				//Un-Select the Email in Store Info Font
				if(fert.Email_StoreInfo_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Email Check Box in Store Info Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Email Check Box in Store Info not Selected while Reopening the page After Saved");					

			Thread.sleep(1000);
			fert.Email_StoreInfo_CheckBox().click();
		
		}
				
		try
		{
				//Un-Select the Store Name in Store Info Font
				if(fert.Store_Name_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Store Name Check Box in Store Info Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				
				}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Store Name Check Box in Store Info not Selected while Reopening the page After Saved");					

			Thread.sleep(1000);
			fert.Store_Name_CheckBox().click();

		}
				
		try
		{
				//Un-Select the Phone Number in Store Info Font
				if(fert.Phone_Number_StoreInfo_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Store Name Check Box in Store Info Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Phone Number Check Box in Store Info not Selected while Reopening the page After Saved");					

			Thread.sleep(1000);
			fert.Phone_Number_StoreInfo_CheckBox().click();
	
		}
				
				try
				{
				//Un-Select the Address in Store Info Font
				if(fert.Address_StoreInfo_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Store Name Check Box in Store Info Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Address Check Box in Store Info not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					for(int i=1;i<=3;i++) 
					{
						Thread.sleep(500);
						driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
					}
					fert.Address_StoreInfo_CheckBox().click();
		
				}
				
				try
				{
				//Un-Select the Header Notes in Store Info Font
				if(fert.Header_Notes_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Header Notes Check Box in Store Info Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Header Notes Check Box in Store Info not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Header_Notes_CheckBox().click();
					
					if(fert.Header_Notes_TextBox().isDisplayed())
					{
						test.log(LogStatus.PASS, "Header Notes Text Box Displayed");
						
						fert.Enter_Header_Notes("Welcome to Hotel Relax");
					}
	
				}
				
				Thread.sleep(1000);
				//Close Store Info Screen
				fert.Close_Store_Info_Screen();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

				
				Thread.sleep(1000);
				//Open Chcek details
				fert.Open_Check_Details_Screen();
				
				Thread.sleep(1000);
				try
				{
				//Un-Select the Check Number in Check Details
				if(fert.Check_Number_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Check Number Check Box in Check Details Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception k)
				{
					
					test.log(LogStatus.PASS, "Check Number Check Box in Check Details not Selected while Reopening the page After Saved");					

					
					Thread.sleep(1000);
					fert.Check_Number_CheckBox().click();
					
					try
					{
						if(fert.Block_1_RadioBtn().isDisplayed())
						{
							test.log(LogStatus.PASS, "Position is Displayed after Check Number Checkbox unselected");
						
						try
						{
							Thread.sleep(1000);
							//Click the Update button
							cmp.Click_Update_ButtonTwo();
							
							Thread.sleep(3000);
							if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Receipt Template Saved Successfully"))
							{
								test.log(LogStatus.FAIL, "Front End Receipt Template Saved Without Selecting Block");
								ut.FailedCaptureScreenshotAsBASE64(driver, test);
							}
						}
						catch(Exception j)
						{
								test.log(LogStatus.PASS, "Front End Receipt Template Save Failed without Selecting Block");
								
						}
							
						//Click the Block 1
						fert.Block_1_RadioBtn().click();
						
						try
						{
							Thread.sleep(1000);
							//Click the Update button
							cmp.Click_Update_ButtonTwo();
							
							Thread.sleep(3000);
							if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Receipt Template Saved Successfully"))
							{
								test.log(LogStatus.FAIL, "Front End Receipt Template Saved Without Selecting Font Size");
								ut.FailedCaptureScreenshotAsBASE64(driver, test);
							}
						}
						catch(Exception l)
						{
							test.log(LogStatus.PASS, "Front End Receipt Template Saved Without Selecting Font Size");
								
						}
						}
						
						//Click Normal Font Size
						fert.Normal_RadioBtn().click();
						
						
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Position is not Displayed after Check Number Checkbox unselected");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}

				}
				
			
				try
				{
				//Un-Select the Table Name in Check Details
				if(fert.Table_Name_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Check Number Check Box in Check Details Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				
				}
				}
				catch(Exception l)
				{
					test.log(LogStatus.PASS, "Table Name Check Box in Check Details not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					for(int i=1;i<=5;i++) 
					{
						Thread.sleep(500);
						driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
					}
					fert.Table_Name_CheckBox().click();
	
				}
				
				
				//Un-Select the Seat Number in Check Details
				try
				{
				if(fert.Seat_Number_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Seat Number Check Box in Check Details Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Seat Number Check Box in Check Details not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					
					fert.Seat_Number_CheckBox().click();
	
				}
				
				
				//Un-Select the Check open server in Check Details
				try
				{
				if(fert.Check_Open_Server_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Check Number Check Box in Check Details Selected while Reopening the page After Saved");					
		
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Check Open Server Check Box in Check Details not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Check_Open_Server_CheckBox().click();

				}
				

				//Un-Select the Check Close Server in Check Details
				try
				{
				if(fert.Check_Close_Server_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Check Close Server Check Box in Check Details Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					
					test.log(LogStatus.PASS, "Check Close Server Check Box in Check Details not Selected while Reopening the page After Saved");					

					
					Thread.sleep(1000);
					fert.Check_Close_Server_CheckBox().click();

				}
				
				
				//Un-Select the Open date & time in Check Details
				try
				{
				if(fert.Open_Date_Time_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Open Date & Time Check Box in Check Details Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Open Date & Time Check Box in Check Details not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Open_Date_Time_CheckBox().click();

				}
				
				//Un-Select the Close date & time in Check Details
				try
				{
				if(fert.Close_Date_Time_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Close Date & Time Check Box in Check Details Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Close Date & Time Check Box in Check Details not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Close_Date_Time_CheckBox().click();

				}
				
				//Un-Select the Service Type in Check Details
				try
				{
				if(fert.Service_Type_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Check Number Check Box in Check Details Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Servce Type Check Box in Check Details not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Service_Type_CheckBox().click();

				}
				
				//Close Check details Screen
				fert.Close_Check_Details_Screen();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

				Thread.sleep(1000);
				//Open Order Summary screen
				fert.Open_Order_Summary_Screen();
				
				Thread.sleep(1000);
				//Un-Select the Secondary Menu Name in Order Summary
				try
				{
				if(fert.Secondary_MenuName_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Secondary Menu Name Check Box in Check Details Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Secondary Menu Name Check Box in Order Summary not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Secondary_MenuName_CheckBox().click();

				}
				
				//Un-Select the Roll Out Modifier Price To Menu in Order Summary
				try
				{
				if(fert.RollOut_ModifierPrice_To_Menu_CheckBox_Selected().isDisplayed())
				{
					
					test.log(LogStatus.FAIL, "Roll Out Modifier Price to Menu Check Box in Order Summary Selected while Reopening the page After Saved");					

					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Roll Out Modifier Price to Menu Check Box in Order Summary not Selected while Reopening the page After Saved");					

					
					Thread.sleep(1000);
					fert.RollOut_ModifierPrice_To_Menu_CheckBox().click();
					
					
					try
					{
						if(fert.RollOut_Modifier_To_Menu_CheckBox().isDisplayed())
						{
							test.log(LogStatus.PASS, "Roll Out Modifier To Menu Check Box not Displayed when Roll Out Modifier Price To Menu Check box Unselected");
						}
					}
					catch(Exception k)
					{
						test.log(LogStatus.FAIL, "Roll Out Modifier To Menu Check box Displayed when Roll Out Modifier Price To Menu Check box Unselected");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				
				
				Thread.sleep(1000);
				//Un-Select the Exclude Zero Price Menu Item in Order Summary
				try
				{
				if(fert.Exclude_ZeroPrice_MenuItem_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Exclude Zero Price Menu Item Check Box in Order Summary Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Exclude Zero Price Menu Item Check Box in Order Summary not Selected while Reopening the page After Saved");					
                    for(int i=1;i<=6;i++) 
                    {
                    	Thread.sleep(500);
                    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
                    }
					Thread.sleep(1000);
					fert.Exclude_ZeroPrice_MenuItem_CheckBox().click();

				}
				
				
				
				Thread.sleep(1000);
				//Un-Select the Exclude Zero Price Modifier in Order Summary
				try
				{
				if(fert.Exclude_ZeroPrice_Modifier_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Exclude Zero Price Modifier Check Box in Order Summary Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Exclude Zero Price Modifier Check Box in Order Summary not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Exclude_ZeroPrice_Modifier_CheckBox().click();

				}
				
				
				
				Thread.sleep(1000);
				//Un-Select the Tax Total in Order Summary
				try
				{
				if(fert.Tax_Total_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Tax Total Check Box in Order Summary Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					
					test.log(LogStatus.PASS, "Tax Total Check Box in Order Summary not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Tax_Total_CheckBox().click();

				}
				
				Thread.sleep(1000);
				//Un-Select the Hide Inclusive Tax  in Order Summary
				try
				{
				if(fert.Hide_Inclusive_Tax_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Hide Inclusive Tax Check Box in Order Summary Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Hide Inclusive Tax Check Box in Order Summary not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Hide_Inclusive_Tax_CheckBox().click();

				}
				
				Thread.sleep(1000);
				//Un-Select the Gratuity in Order Summary
				try
				{
				if(fert.Gratuity_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Gratuity Check Box in Order Summary Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Gratuity Check Box in Order Summary not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Gratuity_CheckBox().click();

				}
				
				Thread.sleep(1000);
				//Un-Select the Tip in Order Summary
				try
				{
				if(fert.Tip_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Tip Check Box in Order Summary Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Tip Check Box in Order Summary not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Tip_CheckBox().click();
	
				}
				
				Thread.sleep(1000);
				//Un-Select the Cash Discount in Order Summary
				try
				{
				if(fert.Cash_Discount_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Secondary Menu Name Check Box in Order Summary Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Cash Discount Check Box in Order Summary not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Cash_Discount_CheckBox().click();

				}
				
				Thread.sleep(1000);
				//Un-Select the Check Total in Order Summary
				try
				{
				if(fert.Check_Total_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Check Total Check Box in Order Summary Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Check Total Check Box in Order Summary not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Check_Total_CheckBox().click();

				}
				
				//Un-Select the Tender Details in Order Summary
				try
				{
				if(fert.Tender_Details_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Tender Details Check Box in Order Summary Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Tender Details Check Box in Order Summary not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Tender_Details_CheckBox().click();

				}
				
				//Un-Select the Show Membership Balance in Order Summary
				try
				{
				if(fert.Show_Membership_Balance_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Show Membership Balance Check Box in Order Summary Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Show Membership Balance Check Box in Order Summary not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Show_Membership_Balance_CheckBox().click();
	
				}
				
				//Un-Select the Loyalty Amount in Order Summary
				try
				{
				if(fert.Loyalty_Amount_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Loyalty Amount Check Box in Order Summary Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Loyalty Amount Check Box in Order Summary not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Loyalty_Amount_CheckBox().click();
	
				}
				
				//Un-Select the Discount under the Menu Item in Order Summary
				try
				{
				if(fert.Discount_Under_MenuItem_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Discount Under Menu Item Check Box in Order Summary Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Discount Under Menu Item Check Box in Order Summary not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Discount_Under_MenuItem_CheckBox().click();

				}
				

				//Un-Select the Print Check in Primary & Secondary Languages in Order Summary
				try
				{
				if(fert.Print_Check_inPrimary_SecondaryLanguages_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Print Check in Primary & Secondary Language Check Box in Order Summary Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					
					test.log(LogStatus.PASS, "Print Check in Primary & Secondary Language Check Box in Order Summary not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Print_Check_inPrimary_SecondaryLanguages_CheckBox().click();
			
		
				}
				
				//Close the Order Summary Screen
				fert.Close_Order_Summary_Screen();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

				
				Thread.sleep(1000);
				//Open Customer Info Screen
				fert.Open_Customer_Info_Screen();
				
				Thread.sleep(1000);
				//Un-Select the Customer Name in Customer Info
				try
				{
				if(fert.Customer_Name_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Customer Name Check Box in Customer Info Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Customer Name Check Box in Customer Info not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Customer_Name_CheckBox().click();
		
				}
				
				//Un-Select the Address in Customer Info
				try
				{
				if(fert.Address_CustomerInfo_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Address Check Box in Customer Info Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Address Check Box in Customer Info not Selected while Reopening the page After Saved");					
                    for(int i=1;i<=5;i++) 
                    {
                    	Thread.sleep(500);
                    	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
                    }
					Thread.sleep(1000);
					fert.Address_CustomerInfo_CheckBox().click();
		
				}
				
				//Un-Select the Phone Number in Customer Info
				try
				{
				if(fert.Phone_Number_CustomerInfo_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Customer Name Check Box in Customer Info Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Phone Number Check Box in Customer Info not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Phone_Number_CustomerInfo_CheckBox().click();
		 
				}
				
				//Un-Select the Email in Customer Info
				try
				{
				if(fert.Email_CustomerInfo_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Email Check Box in Customer Info Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Email Check Box in Customer Info not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Email_CustomerInfo_CheckBox().click();
	
				}
				
				
				//Un-Select the Customer Notes in Customer Info
				try
				{
				if(fert.Customer_Notes_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Customer Notes Check Box in Customer Info Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Customer Notes Check Box in Customer Info not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Customer_Notes_CheckBox().click();
					
					try
					{
						if(fert.Customer_Notes_TextBox().isDisplayed())
						{
							test.log(LogStatus.PASS, "Customer Notes Text Box Displayed when Customer Notes Check Box Unselected");
					
							fert.Enter_Customer_Notes("Thank You., Visit Again...!");
						
						}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Customer Notes Text Box not Displayed when Customer Notes Check Box Unselected");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
		
				}
				
				//Close the Customer Info Screen
				fert.Close_Customer_Info_Screen();
				
				Thread.sleep(1000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

				
				//Open the Additional Settings Screen
				fert.Open_Additional_Settings_Screen();
				
				Thread.sleep(1000);
				//Un-Select the Tip Line in Additional Settings
				try
				{
				if(fert.Tip_Line_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Tip Line Check Box in Additional Settings Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Tip Line Check Box in Additional Settings not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Tip_Line_CheckBox().click();
			
				}
				
				//Un-Select the Signature in Additional Settings
				try
				{
				if(fert.Signature_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Signature Check Box in Additional Settings Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Signature Check Box in Additional Settings not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Signature_CheckBox().click();
		
				}
				
				//Un-Select the Show E-Invoice URL in Additional Settings
				try
				{
				if(fert.Show_EInvoice_URL_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Show E-Invoice URL Check Box in Additional Settings Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Show E-Invoice URL Check Box in Additional Settings not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Show_EInvoice_URL_CheckBox().click();

				}
				
				//Un-Select the Show E-Invoice QR in Additional Settings
				try
				{
				if(fert.Show_EInvoice_QR_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Tip Line Check Box in Additional Settings Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Show E-Inoice QR Check Box in Additional Settings not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Show_EInvoice_QR_CheckBox().click();
	
				}
				
				//Un-Select the Tip Suggestion in Additional Settings
				try
				{
				if(fert.Tip_Suggestion_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Tip Suggestion Check Box in Additional Settings Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Tip Suggestion Check Box in Additional Settings not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Tip_Suggestion_CheckBox().click();
	
				}
				
				//Un-Select the Special Notes in Additional Settings
				try
				{
				if(fert.Special_Notes_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Tip Line Check Box in Additional Settings Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Special Notes Check Box in Additional Settings not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Special_Notes_CheckBox().click();
		
				}
				
				//Un-Select the Barcode in Additional Settings
				try
				{
				if(fert.Barcode_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Barcode Check Box in Additional Settings Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Barcode Check Box in Additional Settings not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Barcode_CheckBox().click();

				}
				
				//Un-Select the Cut Paper After Each print in Additional Settings
				try
				{
				if(fert.Cut_Paper_After_Each_Print_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Cut Paper After Each Print Check Box in Additional Settings Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Cut Paper After Each Print Check Box in Additional Settings not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Cut_Paper_After_Each_Print_CheckBox().click();
	
				}
				
				//Un-Select the Show Remaining Balance in Additional Settings
				try
				{
				if(fert.Show_Remaining_Balance_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Show Remaining Balance Check Box in Additional Settings Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Show Remaining Balance Check Box in Additional Settings not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Show_Remaining_Balance_CheckBox().click();

				}
				
				
				//Close the Additional Settings Screen
				fert.Close_Additional_Settings_Screen();
				
				Thread.sleep(1000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

				
				//Open the Merchant Copy Screen
				fert.Open_Merchant_Copy_Screen();
				
				Thread.sleep(1000);
				//Un-Select the Print GC Balance in Merchant Copy
				try
				{
				if(fert.Print_GC_Balance_MerchantCopy_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Print GC Balance Check Box in Merchant Copy Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Print GC Balance Check Box in Merchant Copy not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Print_GC_Balance_MerchantCopy_CheckBox().click();
	
				}
				
				//Un-Select the Print HA Balance in Merchant Copy
				try
				{
				if(fert.Print_HA_Balance_MerchantCopy_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Print HA Balance Check Box in Merchant Copy Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Print HA Balance Check Box in Merchant Copy not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Print_HA_Balance_MerchantCopy_CheckBox().click();
		
				}
				
				//Un-Select the Print Tab Name in Merchant Copy
				try
				{
				if(fert.Print_Tab_Name_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Print Tab Name Check Box in Merchant Copy Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Print Tab Name Check Box in Merchant Copy not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Print_Tab_Name_CheckBox().click();
	
				}
				
				//Un-Select the Print Membership Balance in Merchant Copy
				try
				{
				if(fert.Print_Membership_Balance_MerchantCopy_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Print Membership Balance Check Box in Merchant Copy Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Print Membership Balance Check Box in Merchant Copy not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Print_Membership_Balance_MerchantCopy_CheckBox().click();
			
		
				}
				
				//Close the Merchant Copy Screen
				fert.Close_Merchant_Copy_Screen();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

				Thread.sleep(1000);
				//Open the Customer Copy Screen
				fert.Open_Customer_Copy_Screen();
				
				Thread.sleep(1000);
				//Un-Select the Print GC Balance in Customer Copy
				try
				{
				if(fert.Print_GC_Balance_CustomerCopy_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Print GC Balance Check Box in Customer Copy Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Print GC Balance Check Box in Customer Copy not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Print_GC_Balance_CustomerCopy_CheckBox().click();
	
				}
				
				//Un-Select the Print HA Balance in Customer Copy
				try
				{
				if(fert.Print_HA_Balance_CustomerCopy_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Print HA Balance Check Box in Customer Copy Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Print HA Balance Check Box in Customer Copy not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Print_HA_Balance_CustomerCopy_CheckBox().click();
	
				}
				
				//Un-Select the Print Membership Balance in Customer Copy
				try
				{
				if(fert.Print_Membership_Balance_CustomerCopy_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Print Membership Balance Check Box in Customer Copy Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Print Membership Balance Check Box in Customer Copy not Selected while Reopening the page After Saved");					

					Thread.sleep(1000);
					fert.Print_Membership_Balance_CustomerCopy_CheckBox().click();
			
	
				}
				
				//Close the Customer Copy Screen
				fert.Close_Customer_Copy_Screen();
				
				
				Thread.sleep(1000);
				//Click the Update button
				cmp.Click_Update_ButtonTwo();
				
				Thread.sleep(3000);
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Receipt Template Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Front End Receipt Template Saved Successfully After Enabled All Checkboxes");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Front End Receipt Template Save Failed After Enabling All Checkboxes");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				Thread.sleep(3000);
				driver.navigate().refresh();

		
		
		
		
	}
	
	@Test(priority = 6,enabled = false)
	public void Verify_Enabled_All_Front_End_Receipt_Template_Settings(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		fert=new Front_End_Receipt_TemplatePage(driver, test);
		Thread.sleep(2000);
		
		Thread.sleep(5000);
		//Open Print_Template screen
				fert.Open_Print_Template_Screen();
				Thread.sleep(1000);
		
		//Check Whether the Medium Font Size
		if(fert.Medium_RadioBtn_SLD().isDisplayed())
		{
			test.log(LogStatus.PASS, "Medium Font Size is Selected");
			
			//Enable Small Font Size
			fert.Click_Small_FontSize();
		}
		else
		{
			test.log(LogStatus.FAIL, "Medium Font Size is not Selected");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Close Print_Template screen
				fert.Close_Print_Template_Screen();
				
		
		Thread.sleep(1000);
		//Open Store Info Screen
		fert.Open_Store_Info_Screen();
		
		
		Thread.sleep(1000);
		try
		{
		//Un-Select the Store Name Font
		if(fert.Store_Logo_CheckBox_Selected().isDisplayed())
		{
			test.log(LogStatus.PASS, "Store Logo Check Box Selected while Reopening the page After Saved");					
		
			fert.Verify_Store_Logo_inTemplate();
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.FAIL, "Store Logo Check Box not Selected while Reopening the page After Saved");					
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
			
				try 
				{
				//Un-Select the Email in Store Info Font

				if(fert.Email_StoreInfo_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Email Check Box in Store Info Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Email Check Box in Store Info not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				try
				{
				//Un-Select the Store Name in Store Info Font
				if(fert.Store_Name_CheckBox_Selected().isDisplayed())
				{
					
					test.log(LogStatus.PASS, "Store Name Check Box in Store Info Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception j)
				{
					test.log(LogStatus.FAIL, "Store Name Check Box in Store Info not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				try
				{
				//Un-Select the Phone Number in Store Info Font
				if(fert.Phone_Number_StoreInfo_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Phone Number Check Box in Store Info Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Store Name Check Box in Store Info not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				try
				{
				//Un-Select the Address in Store Info Font
				if(fert.Address_StoreInfo_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Address Check Box in Store Info Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Store Name Check Box in Store Info not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				try
				{
				//Un-Select the Header Notes in Store Info Font
				if(fert.Header_Notes_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Header Notes Check Box in Store Info Selected while Reopening the page After Saved");					

					
					if(fert.Header_Notes_TextBox().isDisplayed())
					{
						test.log(LogStatus.PASS, "Header Notes Text Box Displayed");
						
						fert.Enter_Header_Notes("Welcome to Hotel Relax");
					}
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Header Notes Check Box in Store Info not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				Thread.sleep(1000);
				//Close Store Info Screen
				fert.Close_Store_Info_Screen();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

				
				Thread.sleep(1000);
				//Open Chcek details
				fert.Open_Check_Details_Screen();
				
				Thread.sleep(1000);
				try
				{
				//Un-Select the Check Number in Check Details
				if(fert.Check_Number_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Check Number Check Box in Check Details Selected while Reopening the page After Saved");					

									
					try
					{
						if(fert.Block_1_RadioBtn_SLD().isDisplayed())
						{
							test.log(LogStatus.PASS, "Block 1 Position is Selected");
						
						
						
						try
						{
							
							if(fert.Normal_RadioBtn_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Normal Font Size is Selected for Position");
							}
						}
						catch(Exception l)
						{
							test.log(LogStatus.FAIL, "Normal Font Size is not Selected for Position");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);	
						}
						}
						
						//Click the Block 2
						fert.Block_2_RadioBtn().click();
						
						
						
						
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Block 1 Position is not Selected");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Check Number Check Box in Check Details not Selected while Reopening the page After Saved");					
				}
				
			
				try
				{
				//Un-Select the Table Name in Check Details
				if(fert.Table_Name_CheckBox_Selected().isDisplayed())
				{
					
					test.log(LogStatus.PASS, "Table Name Check Box in Check Details Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Check Number Check Box in Check Details not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				//Un-Select the Seat Number in Check Details
				try
				{
				if(fert.Seat_Number_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Seat Number Check Box in Check Details Selected while Reopening the page After Saved");					

				
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Seat Number Check Box in Check Details not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				//Un-Select the Check open server in Check Details
				try
				{
				if(fert.Check_Open_Server_CheckBox_Selected().isDisplayed())
				{
					
					test.log(LogStatus.PASS, "Check Open Server Check Box in Check Details Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Check Number Check Box in Check Details not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				

				//Un-Select the Check Close Server in Check Details
				try
				{
				if(fert.Check_Close_Server_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Check Close Server Check Box in Check Details Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Check Close Server Check Box in Check Details not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				//Un-Select the Open date & time in Check Details
				try
				{
				if(fert.Open_Date_Time_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Open Date & Time Check Box in Check Details Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Open Date & Time Check Box in Check Details not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Close date & time in Check Details
				try
				{
				if(fert.Close_Date_Time_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Close Date & Time Check Box in Check Details Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Close Date & Time Check Box in Check Details not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Service Type in Check Details
				try
				{
				if(fert.Service_Type_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Servce Type Check Box in Check Details Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Check Number Check Box in Check Details not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Close Check details Screen
				fert.Close_Check_Details_Screen();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

				Thread.sleep(1000);
				//Open Order Summary screen
				fert.Open_Order_Summary_Screen();
				
				Thread.sleep(1000);
				//Un-Select the Secondary Menu Name in Order Summary
				try
				{
				if(fert.Secondary_MenuName_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Secondary Menu Name Check Box in Order Summary Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Secondary Menu Name Check Box in Order Summary not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Roll Out Modifier Price To Menu in Order Summary
				try
				{
				if(fert.RollOut_ModifierPrice_To_Menu_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Roll Out Modifier Price to Menu Check Box in Order Summary Selected while Reopening the page After Saved");					

			
					
					
					try
					{
						if(fert.RollOut_Modifier_To_Menu_CheckBox().isDisplayed())
						{
							test.log(LogStatus.PASS, "Roll Out Modifier To Menu Check Box Displayed when Roll Out Modifier Price To Menu Check box Selected");
					
							//Click Roll Out Modifier to Menu
							fert.RollOut_Modifier_To_Menu_CheckBox().click();
							
							try
							{
								if(fert.Exclude_ZeroPrice_Modifier_CheckBox().isDisplayed())
								{
									test.log(LogStatus.FAIL, "Exclude Zero Price Modifier is Displayed when Enabling Roll Out Modifier to Menu Check Box");
									ut.FailedCaptureScreenshotAsBASE64(driver, test);
								}
							}
							catch(Exception p)
							{
								test.log(LogStatus.PASS, "Exclude Zero Price Modifier is not Displayed when Enabling Roll Out Modifier to Menu Check Box");

							}
							
							//Click Roll Out Modifier to Menu
							if(fert.RollOut_Modifier_To_Menu_CheckBox_Selected().isDisplayed())
							{
								fert.RollOut_Modifier_To_Menu_CheckBox().click();
								
								
								try
								{
									if(fert.Exclude_ZeroPrice_Modifier_CheckBox().isDisplayed())
									{
										test.log(LogStatus.FAIL, "Exclude Zero Price Modifier is Displayed when Enabling Roll Out Modifier to Menu Check Box");
									
										ut.FailedCaptureScreenshotAsBASE64(driver, test);
									//Click Exclude Zero Price Modifier
										fert.Exclude_ZeroPrice_MenuItem_CheckBox().click();
									}
								}
								catch(Exception p)
								{
									test.log(LogStatus.PASS, "Exclude Zero Price Modifier is not Displayed when Enabling Roll Out Modifier to Menu Check Box");

								}
								
							}
						}
					}
					catch(Exception k)
					{
						test.log(LogStatus.FAIL, "Roll Out Modifier To Menu Check box not Displayed when Roll Out Modifier Price To Menu Check box Selected");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Roll Out Modifier Price to Menu Check Box in Order Summary not Selected while Reopening the page After Saved");					

				}
				
				
				Thread.sleep(1000);
				//Un-Select the Exclude Zero Price Menu Item in Order Summary
				try
				{
				if(fert.Exclude_ZeroPrice_MenuItem_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Exclude Zero Price Menu Item Check Box in Order Summary Selected while Reopening the page After Saved");					

				
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Exclude Zero Price Menu Item Check Box in Order Summary not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				
				Thread.sleep(1000);
				//Un-Select the Exclude Zero Price Modifier in Order Summary
				try
				{
				if(fert.Exclude_ZeroPrice_Modifier_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Exclude Zero Price Modifier Check Box in Order Summary Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Exclude Zero Price Modifier Check Box in Order Summary not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				
				Thread.sleep(1000);
				//Un-Select the Tax Total in Order Summary
				try
				{
				if(fert.Tax_Total_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Tax Total Check Box in Order Summary Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Tax Total Check Box in Order Summary not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				Thread.sleep(1000);
				//Un-Select the Hide Inclusive Tax  in Order Summary
				try
				{
				if(fert.Hide_Inclusive_Tax_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Hide Inclusive Tax Check Box in Order Summary Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Hide Inclusive Tax Check Box in Order Summary not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				Thread.sleep(1000);
				//Un-Select the Gratuity in Order Summary
				try
				{
				if(fert.Gratuity_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Gratuity Check Box in Order Summary Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Gratuity Check Box in Order Summary not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				Thread.sleep(1000);
				//Un-Select the Tip in Order Summary
				try
				{
				if(fert.Tip_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Tip Check Box in Order Summary Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Tip Check Box in Order Summary not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				Thread.sleep(1000);
				//Un-Select the Cash Discount in Order Summary
				try
				{
				if(fert.Cash_Discount_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Cash Discount Check Box in Order Summary Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Secondary Menu Name Check Box in Order Summary not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
	
				//Un-Select the Check Total in Order Summary
				try
				{
				if(fert.Check_Total_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Check Total Check Box in Order Summary Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Check Total Check Box in Order Summary not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Tender Details in Order Summary
				try
				{
				if(fert.Tender_Details_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Tender Details Check Box in Order Summary Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Tender Details Check Box in Order Summary not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Show Membership Balance in Order Summary
				try
				{
				if(fert.Show_Membership_Balance_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Show Membership Balance Check Box in Order Summary Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Show Membership Balance Check Box in Order Summary not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Loyalty Amount in Order Summary
				try
				{
				if(fert.Loyalty_Amount_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Loyalty Amount Check Box in Order Summary Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Loyalty Amount Check Box in Order Summary not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Discount under the Menu Item in Order Summary
				try
				{
				if(fert.Discount_Under_MenuItem_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Discount Under Menu Item Check Box in Order Summary Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Discount Under Menu Item Check Box in Order Summary not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				

				//Un-Select the Print Check in Primary & Secondary Languages in Order Summary
				try
				{
				if(fert.Print_Check_inPrimary_SecondaryLanguages_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Print Check in Primary & Secondary Language Check Box in Order Summary Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Print Check in Primary & Secondary Language Check Box in Order Summary not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Close the Order Summary Screen
				fert.Close_Order_Summary_Screen();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

				
				Thread.sleep(1000);
				//Open Customer Info Screen
				fert.Open_Customer_Info_Screen();
				
				Thread.sleep(1000);
				//Un-Select the Customer Name in Customer Info
				try
				{
				if(fert.Customer_Name_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Customer Name Check Box in Customer Info Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Customer Name Check Box in Customer Info not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Address in Customer Info
				try
				{
				if(fert.Address_CustomerInfo_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Address Check Box in Customer Info Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Address Check Box in Customer Info not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Phone Number in Customer Info
				try
				{
				if(fert.Phone_Number_CustomerInfo_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Phone Number Check Box in Customer Info Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Customer Name Check Box in Customer Info not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Email in Customer Info
				try
				{
				if(fert.Email_CustomerInfo_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Email Check Box in Customer Info Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Email Check Box in Customer Info not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				//Un-Select the Customer Notes in Customer Info
				try
				{
				if(fert.Customer_Notes_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Customer Notes Check Box in Customer Info Selected while Reopening the page After Saved");					

					
					try
					{
						if(fert.Customer_Notes_TextBox().isDisplayed())
						{
							test.log(LogStatus.PASS, "Customer Notes Text Box Displayed when Customer Notes Check Box Unselected");
					
							fert.Enter_Customer_Notes("Thank You., Visit Again...!");
						
						}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Customer Notes Text Box not Displayed when Customer Notes Check Box Unselected");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Customer Notes Check Box in Customer Info not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Close the Customer Info Screen
				fert.Close_Customer_Info_Screen();
				
				Thread.sleep(1000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

				
				//Open the Additional Settings Screen
				fert.Open_Additional_Settings_Screen();
				
				Thread.sleep(1000);
				//Un-Select the Tip Line in Additional Settings
				try
				{
				if(fert.Tip_Line_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Tip Line Check Box in Additional Settings Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Tip Line Check Box in Additional Settings not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Signature in Additional Settings
				try
				{
				if(fert.Signature_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Signature Check Box in Additional Settings Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Signature Check Box in Additional Settings not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Show E-Invoice URL in Additional Settings
				try
				{
				if(fert.Show_EInvoice_URL_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Show E-Invoice URL Check Box in Additional Settings Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Show E-Invoice URL Check Box in Additional Settings not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Show E-Invoice QR in Additional Settings
				try
				{
				if(fert.Show_EInvoice_QR_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Show E-Inoice QR Check Box in Additional Settings Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Tip Line Check Box in Additional Settings not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Tip Suggestion in Additional Settings
				try
				{
				if(fert.Tip_Suggestion_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Tip Suggestion Check Box in Additional Settings Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Tip Suggestion Check Box in Additional Settings not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Special Notes in Additional Settings
				try
				{
				if(fert.Special_Notes_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Special Notes Check Box in Additional Settings Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Tip Line Check Box in Additional Settings not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Barcode in Additional Settings
				try
				{
				if(fert.Barcode_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Barcode Check Box in Additional Settings Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Barcode Check Box in Additional Settings not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Cut Paper After Each print in Additional Settings
				try
				{
				if(fert.Cut_Paper_After_Each_Print_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Cut Paper After Each Print Check Box in Additional Settings Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Cut Paper After Each Print Check Box in Additional Settings not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Show Remaining Balance in Additional Settings
				try
				{
				if(fert.Show_Remaining_Balance_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Show Remaining Balance Check Box in Additional Settings Selected while Reopening the page After Saved");					

					
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Show Remaining Balance Check Box in Additional Settings not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				//Close the Additional Settings Screen
				fert.Close_Additional_Settings_Screen();
				
				Thread.sleep(1000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

				
				//Open the Merchant Copy Screen
				fert.Open_Merchant_Copy_Screen();
				
				Thread.sleep(1000);
				//Un-Select the Print GC Balance in Merchant Copy
				try
				{
				if(fert.Print_GC_Balance_MerchantCopy_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Print GC Balance Check Box in Merchant Copy Selected while Reopening the page After Saved");					

			
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Print GC Balance Check Box in Merchant Copy not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Print HA Balance in Merchant Copy
				try
				{
				if(fert.Print_HA_Balance_MerchantCopy_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Print HA Balance Check Box in Merchant Copy Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Print HA Balance Check Box in Merchant Copy not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Print Tab Name in Merchant Copy
				try
				{
				if(fert.Print_Tab_Name_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Print Tab Name Check Box in Merchant Copy Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Print Tab Name Check Box in Merchant Copy not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Print Membership Balance in Merchant Copy
				try
				{
				if(fert.Print_Membership_Balance_MerchantCopy_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Print Membership Balance Check Box in Merchant Copy Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Print Membership Balance Check Box in Merchant Copy not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Close the Merchant Copy Screen
				fert.Close_Merchant_Copy_Screen();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

				Thread.sleep(1000);
				//Open the Customer Copy Screen
				fert.Open_Customer_Copy_Screen();
				
				Thread.sleep(1000);
				//Un-Select the Print GC Balance in Customer Copy
				try
				{
				if(fert.Print_GC_Balance_CustomerCopy_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Print GC Balance Check Box in Customer Copy Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Print GC Balance Check Box in Customer Copy not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Print HA Balance in Customer Copy
				try
				{
				if(fert.Print_HA_Balance_CustomerCopy_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Print HA Balance Check Box in Customer Copy Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Print HA Balance Check Box in Customer Copy not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Un-Select the Print Membership Balance in Customer Copy
				try
				{
				if(fert.Print_Membership_Balance_CustomerCopy_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Print Membership Balance Check Box in Customer Copy Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Print Membership Balance Check Box in Customer Copy not Selected while Reopening the page After Saved");					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Close the Customer Copy Screen
				fert.Close_Customer_Copy_Screen();
				
				
				Thread.sleep(1000);
				//Click the Update button
				cmp.Click_Update_ButtonTwo();
				
				Thread.sleep(3000);
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Receipt Template Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Front End Receipt Template Saved Successfully After Enabled All Checkboxes");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Front End Receipt Template Save Failed After Enabling All Checkboxes");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				Thread.sleep(3000);
				driver.navigate().refresh();

				Thread.sleep(8000);
				//Open Print_Template screen
				fert.Open_Print_Template_Screen();
				
				
				Thread.sleep(2000);
				//Check Whether the Small Font Size
				if(fert.Small_RadioButton_SLD().isDisplayed())
				{
					test.log(LogStatus.PASS, "Small Font Size is Selected");
					
					//Enable Small Font Size
					fert.Click_Small_FontSize();
				}
				else
				{
					test.log(LogStatus.FAIL, "Small Font Size is not Selected");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
		
				//Open Print_Template screen
				fert.Close_Print_Template_Screen();
				
	
	}

}
