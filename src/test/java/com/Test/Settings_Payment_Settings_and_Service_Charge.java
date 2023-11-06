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
import com.Pages.PaymentSettingsPage;
import com.Test.LoginTest;
import com.epam.healenium.SelfHealingDriver;
import com.Pages.LoginPage;
import com.Pages.PaymentSettingsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.pcap.PcapWriteHandler;

public class Settings_Payment_Settings_and_Service_Charge 
{

	public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings - Payment Settings and Service Charge");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	PaymentSettingsPage pscpg;
	
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
		//System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
		//Open the Chrome window
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver(chromeOptions);
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
		Open_Payment_Settings_Page(driver);
//		RefreshAndPaginination(driver);
		Add_Cash_Discount_Payment_Settings(driver);
		Change_Service_Charge_and_Add_VisaCard_Payment_Settings(driver);
		Edit_Cancel_and_Update_ServiceCharge(driver);
		Edit_and_Change_CardTypes(driver);
		Add_All_Cards_and_ServiceCharge(driver);
		
		Delete_ServiceCharge_Payment_Settings(driver);
		Change_and_Update_Instant_Cash_Reward_Payment_Settings(driver);
		
	
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Payment_Settings_Page(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Payment Method page
		driver.get(Utility.getProperty("baseURL")+"settings/"+"paymentSettings");

		Thread.sleep(5000);
		//Verify the Payment Settings page loaded or not
		//cmp.VerifyMainScreenPageHeader("Payment Settings");	
		if(driver.findElement(By.xpath("//h3[.='Payment Settings']")).getText().trim().equals("Payment Settings"))
		{
			test.log(LogStatus.PASS, "Payment Settings Page Loaded Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Settings Page Loaded Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
		cmp.VerifyPagination_and_Refresh_Publish();
		
//		//Verify Column Filtration
//		cmp.Filter_Columns();
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_Cash_Discount_Payment_Settings(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pscpg=new PaymentSettingsPage(driver, test);
		Thread.sleep(2000);
		
		//Verify whether the Manual Submit For Credit Card is selected Default
		if(pscpg.ManualSubmitForCreditCard().isSelected())
		{
			test.log(LogStatus.PASS, "Manual Submit For Credit Card is Selected Defaultly");
		}
		else
		{
			test.log(LogStatus.FAIL, "Manual Submit For Credit Card is not Selected Defaultly");
		}
		
		//Verify whether the Tokenize The Credit Card is selected Default
		if(pscpg.TokenizeTheCreditCard().isSelected())
		{
			test.log(LogStatus.PASS, "Tokenize The Credit Card is Selected Defaultly");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tokenize The Credit Card is not Selected Defaultly");
		}
		
		//Enable Tokenize for service types
		pscpg.Select_Tokenize_CreditCard();
		
		//Disable Tokenize Credit card
		pscpg.UnSelect_Tokenize_CreditCard();
		
		
		//Click on Cash Discount
		pscpg.Select_Cash_Discount();
		
		
		//Click the Save button
		try
		{
			cmp.Click_SaveButton();
			
			test.log(LogStatus.FAIL, "Allow to Click/Save Payment method without Giving Fee & Cash Discount Name in Cash Discount");
			
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Settings Saved Successfully"))
			{
				test.log(LogStatus.FAIL, "Payment Settings saved without giving Fee Name & Cash Discount Name in Cash Discount");
			}
			else
			{
				
			}

		}
		catch(Exception e)
		{
			test.log(LogStatus.PASS, "Unable to Click/Save Payment method without Giving Fee Name & Cash Discount Name in Cash Discount");
		}
				
						String NameExcess = "Entering Invalid Name to input"; 
						int ActualSize= NameExcess.length();
						System.out.println(ActualSize);
		
						//Enter the Payment Method Name
						pscpg.Enter_FeeName(NameExcess);
						
						//To get value
						String ActualName=cmp.NameInputBox().getAttribute("value");
						int EnteredSize= ActualName.length();
						System.out.println(EnteredSize);
		
						if(ActualSize!=EnteredSize)
						{
							test.log(LogStatus.PASS, "Name should not be Exceeded 25 Characters in Fee Name");
						}
						else
						{
							test.log(LogStatus.FAIL, "Name should exceeded the size in Fee Name");
						}
						
						//Enter the Fee Name 
						pscpg.Enter_FeeName("Cash Discount Fees");
						
						//Click the Save button
						try
						{
							cmp.Click_SaveButton();
							
							test.log(LogStatus.FAIL, "Allow to Click/Save Payment method without Giving Cash Discount Name");
							
							if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Settings Saved Successfully"))
							{
								test.log(LogStatus.FAIL, "Payment Settings saved without giving Fee Name & Cash Discount Name in Cash Discount");
							}
							else
							{
								
							}

						}
						catch(Exception e)
						{
							test.log(LogStatus.PASS, "Unable to Click/Save Payment method without Giving Cash Discount Name");
						}
								
						
						//Enter the Payment Method Name
						pscpg.Enter_CashDiscountName(NameExcess);
						
						//To get value
						String ActualName1=cmp.NameInputBox().getAttribute("value");
						int EnteredSize1= ActualName1.length();
						System.out.println(EnteredSize1);
		
						if(ActualSize!=EnteredSize1)
						{
							test.log(LogStatus.PASS, "Name should not be Exceeded 25 Characters in Cash Discount Name");
						}
						else
						{
							test.log(LogStatus.FAIL, "Name should exceeded the size in Cash Discount Name");
						}
		
				Thread.sleep(1000);
				//Enter the Payment Method Name
				pscpg.Enter_CashDiscountName("End Sale-Discount");
				Thread.sleep(500);
					
				//Enter the Cash Discount Percentage as Negative
				pscpg.Enter_CashDiscountPercentage("-1");
				
				//Enter Cash Discount
				pscpg.Enter_CashDiscountPercentage("10500");
				
				//Verify whether the Enter Valid Percentage pop up displayed or not 
				if(driver.findElement(By.xpath("//button[@disabled='true']/span/span[.='SAVE']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Save button is disabled when Entering above 100 percentage in Cash Discount Percentage");
					//test.log(LogStatus.PASS, "Enter Valid Percentage is Displayed when Entering above 100 percentage in Cash Discount Percentage");
				}
				else
				{
					test.log(LogStatus.FAIL, "Save button is enabled when Entering above 100 percentage in Cash Discount Percentage");
					//test.log(LogStatus.FAIL, "Enter Valid Percentage is not Displayed when Entering above 100 percentage in Cash Discount Percentage");
				}
				
				//Enter the Cash Discount Percentage
				pscpg.Enter_CashDiscountPercentage("1000");

				
		Thread.sleep(5000);
		//Click the Save button
		//cmp.Click_SaveButton();
		driver.findElement(By.xpath("//button[.='SAVE']")).click();
		 
		Thread.sleep(2000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Settings Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Payment Settings Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Settings Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		

	}
		
	@Test(priority = 5,enabled = false)
	public void Change_Service_Charge_and_Add_VisaCard_Payment_Settings(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pscpg=new PaymentSettingsPage(driver, test);
		
		//click the 
		pscpg.Select_Service_Charge();
		
		Thread.sleep(2000);
		//Verify the filter
		cmp.Filter_Columns();
		
		Thread.sleep(1000);
		//Select Service Charge
		pscpg.Enter_Service_ChargeName("Card Service Charge");
		
		//Click New Service Charge
		pscpg.Click_NewServiceCharge();
	
		
		//Verify whether the New Service Charge page opened or not
		cmp.VerifyCreationScreenPageHeader("New Service Charge");
		
		//Click the Save button
		try
		{
			if(driver.findElement(By.xpath("//button[contains(@disabled,'true') and contains(.,'Save')]")).isDisplayed()) {
				test.log(LogStatus.PASS, "Unable to Click/Save Service Charges without Selecting Card Type");
			}
			/*
			 * cmp.Click_SaveButton();
			 * 
			 * if(cmp.ConfirmationAlertMsg().getText().
			 * equalsIgnoreCase("Service Charge Added Successfully")) {
			 * test.log(LogStatus.FAIL,
			 * "Service Charges saved without Selecting Card Type in Service Charge"); }
			 * else {
			 * 
			 * }
			 */

		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Allow to Click/Save Payment method without selecting Card Type");
		}
		
		//Select Visa Card Type
		pscpg.Select_Visa_CardType();
		
		//Enter Service Charge
				pscpg.Enter_ServiceCharge("10500");
				
				//Verify whether the Enter Valid Percentage pop up displayed or not 
				if(pscpg.Valid_PercentageErrorMsg().isDisplayed())
				{
					test.log(LogStatus.PASS, "Enter Valid Percentage is Displayed when Entering above 100 percentage in Service Charge");
				}
				else
				{
					test.log(LogStatus.FAIL, "Enter Valid Percentage is not Displayed when Entering above 100 percentage in Service Charge");
				}
		
		//Enter Service Charge
		pscpg.Enter_ServiceCharge("500");
		
	Thread.sleep(1000);
	//Click the Save button
	cmp.Click_SaveButton();
	
	Thread.sleep(3000);
	try {
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please enter tip Charge."))
		{
			test.log(LogStatus.PASS, "Please enter tip Charge is Displayed");
		
			//ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		

		//Enter Service Charge
				pscpg.Enter_TipCharge("10500");
				
				//Verify whether the Enter Valid Percentage pop up displayed or not 
				if(pscpg.Valid_PercentageErrorMsg().isDisplayed())
				{
					test.log(LogStatus.PASS, "Enter Valid Percentage is Displayed when Entering above 100 percentage in Tip Charge");
				}
				else
				{
					test.log(LogStatus.FAIL, "Enter Valid Percentage is not Displayed when Entering above 100 percentage in Tip Charge");
				}
		
		//Enter the Tip Charge
		pscpg.Enter_TipCharge("500");
		
		//Enter Service Charge
		pscpg.Enter_GratuityCharge("10500");
		
		//Verify whether the Enter Valid Percentage pop up displayed or not 
		if(pscpg.Valid_PercentageErrorMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter Valid Percentage is Displayed when Entering above 100 percentage in Gratuity Charge");
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter Valid Percentage is not Displayed when Entering above 100 percentage in Gratuity Charge");
		}

			//Enter the Gratuity charge
			pscpg.Enter_GratuityCharge("1000");
			
			//Click Save button
			cmp.Click_SaveButton();
			
			Thread.sleep(3000);
			//Check whether the New Service Charges Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charge Added Successfully"))
			{
				test.log(LogStatus.PASS, "Service Charges for Visa Card Saved Successfully");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Card Visa is already Used."))
			{
				test.log(LogStatus.INFO, "Card Visa is already Used.");
				
				//Click Cancel button
				cmp.Click_CancelButton();
				
			}
			else
			{
				test.log(LogStatus.FAIL, "Service Charges for Visa Card Save Failed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
	}
	catch(Exception e)
	{
		test.log(LogStatus.FAIL, "Please enter tip Charge is not Displayed");
		
		//ut.FailedCaptureScreenshotAsBASE64(driver, test);
	}
	

	


	 

	
		
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Edit_Cancel_and_Update_ServiceCharge(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pscpg=new PaymentSettingsPage(driver, test);

		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit("Visa");
		
		//Verify the Update header
		cmp.VerifyCreationScreenPageHeader("Update Service Charge");
		
		//Enter the Service Charge
		pscpg.Enter_ServiceCharge("1000");
		
		//Get the Service Charge 
		String ServiceChargeBefore=pscpg.Service_ChargeInputBox().getAttribute("value");

		//Enter the Tip Charge
		pscpg.Enter_TipCharge("1200");
		
		//Get the Tip Charge
		String TipChargeBefore=pscpg.Tip_ChargeInputBox().getAttribute("value");
		
		//Enter the Gratuity
		pscpg.Enter_GratuityCharge("1500");
		
		//Get the Gratuity
				String GratuityChargeBefore=pscpg.Gratuity_ChargeInputBox().getAttribute("value");

		
		//Click Update button
		cmp.Click_UpdateButton();
		 
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges Updated Fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit("Visa");
		
		//Get the Service Charge 
				String ServiceChargeAfter=pscpg.Service_ChargeInputBox().getAttribute("value");

				if(ServiceChargeBefore.equals(ServiceChargeAfter))
				{
					test.log(LogStatus.PASS, "Service Charge value not changed after Update");
				}
				else
				{
					test.log(LogStatus.FAIL, "Service Charge value changed after Update");

				}
		
		//Get the Tip Charge
		String TipChargeAfter=pscpg.Tip_ChargeInputBox().getAttribute("value");
		
		if(TipChargeBefore.equals(TipChargeAfter))
		{
			test.log(LogStatus.PASS, "Tip Charge value not changed after Update");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Charge value changed after Update");

		}
		
		//Get the Gratuity
		String GratuityChargeAfter=pscpg.Gratuity_ChargeInputBox().getAttribute("value");

		if(GratuityChargeBefore.equals(GratuityChargeAfter))
		{
			test.log(LogStatus.PASS, "Gratuity Charge value not changed after Update");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gratuity Charge value changed after Update");

		}
		
		//Click the Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Modifier Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Service Charge Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charge not Cancelled");
		}
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Change_CardTypes(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pscpg=new PaymentSettingsPage(driver, test);

		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit("Visa");
		
		//Select the Gift Card Payment Type
		if(pscpg.Card_TypeInput().getAttribute("value").equalsIgnoreCase("Visa"))
		{
			test.log(LogStatus.PASS, "Visa Card Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Visa Card Type Not Selected after Update");
		}
		
		Thread.sleep(500);
		//Change the Master Card Type
		pscpg.Select_Master_CardType();
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges updated successfully for Master");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges updated fail for Master");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit("Master");
		
		//Select the Gift Card Payment Type
		if(pscpg.Card_TypeInput().getAttribute("value").equalsIgnoreCase("Master"))
		{
			test.log(LogStatus.PASS, "Master Card Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Master Card Type Not Selected after Update");
		}
		
		Thread.sleep(500);
		//Change the Amex Card Type
		pscpg.Select_Amex_CardType();
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges updated successfully for Amex");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges updated fail for Amex");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit("Amex");
		
		//Select the Gift Card Payment Type
		if(pscpg.Card_TypeInput().getAttribute("value").equalsIgnoreCase("Amex"))
		{
			test.log(LogStatus.PASS, "Amex Card Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Amex Card Type Not Selected after Update");
		}
		
		Thread.sleep(500);
		//Change the Amex Card Type
		pscpg.Select_Diners_CardType();
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges updated successfully for Diners");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges updated fail for Diners");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit("Diners");
		
		//Select the Gift Card Payment Type
		if(pscpg.Card_TypeInput().getAttribute("value").equalsIgnoreCase("Diners"))
		{
			test.log(LogStatus.PASS, "Diners Card Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Diners Card Type Not Selected after Update");
		}
		
		Thread.sleep(500);
		//Change the Amex Card Type
		pscpg.Select_JCB_CardType();
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges updated successfully for JCB");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges updated fail for JCB");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit("JCB");
		
		//Select the Gift Card Payment Type
		if(pscpg.Card_TypeInput().getAttribute("value").equalsIgnoreCase("JCB"))
		{
			test.log(LogStatus.PASS, "JCB Card Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "JCB Card Type Not Selected after Update");
		}
		
		Thread.sleep(500);
		//Change the Amex Card Type
		pscpg.Select_Discover_CardType();
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges updated successfully for Discover");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges updated fail for Discover");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit("Discover");
		
		//Select the Gift Card Payment Type
		if(pscpg.Card_TypeInput().getAttribute("value").equalsIgnoreCase("Discover"))
		{
			test.log(LogStatus.PASS, "Discover Card Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Discover Card Type Not Selected after Update");
		}
		
		Thread.sleep(500);
		//Change the Amex Card Type
		pscpg.Select_ATH_CardType();
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges updated successfully for ATH");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges updated fail for ATH");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit("ATH");
		
		//Select the Gift Card Payment Type
		if(pscpg.Card_TypeInput().getAttribute("value").equalsIgnoreCase("ATH"))
		{
			test.log(LogStatus.PASS, "ATH Card Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "ATH Card Type Not Selected after Update");
		}
		
		Thread.sleep(500);
		//Change the Amex Card Type
		pscpg.Select_Cash_CardType();
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges updated successfully for Cash");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges updated fail for Cash");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit("Cash");
		
		//Select the Gift Card Payment Type
		if(pscpg.Card_TypeInput().getAttribute("value").equalsIgnoreCase("Cash"))
		{
			test.log(LogStatus.PASS, "Cash Card Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Cash Card Type Not Selected after Update");
		}
		
		Thread.sleep(500);
		//Change the Amex Card Type
		pscpg.Select_Unica_CardType();
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges updated successfully for Unica");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges updated fail for Unica");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit("Unica");
		
		//Select the Gift Card Payment Type
		if(pscpg.Card_TypeInput().getAttribute("value").equalsIgnoreCase("Unica"))
		{
			test.log(LogStatus.PASS, "Unica Card Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Unica Card Type Not Selected after Update");
		}
		
		Thread.sleep(500);
		//Change the Amex Card Type
		pscpg.Select_Ebt_CardType();
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges updated successfully for Ebt");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges updated fail for Ebt");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit("Ebt");
		
		//Select the Gift Card Payment Type
		if(pscpg.Card_TypeInput().getAttribute("value").equalsIgnoreCase("Ebt"))
		{
			test.log(LogStatus.PASS, "Ebt Card Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Ebt Card Type Not Selected after Update");
		}
		
		Thread.sleep(500);
		//Change the Amex Card Type
		pscpg.Select_Fondo_CardType();
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges updated successfully for Fondo");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges updated fail for Fondo");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit("Fondo");
		
		//Select the Gift Card Payment Type
		if(pscpg.Card_TypeInput().getAttribute("value").equalsIgnoreCase("Fondo"))
		{
			test.log(LogStatus.PASS, "Fondo Card Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Fondo Card Type Not Selected after Update");
		}
		
		Thread.sleep(500);
		//Change the Amex Card Type
		pscpg.Select_EbtCash_CardType();
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges updated successfully for EbtCash");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges updated fail for EbtCash");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Search and Click Edit buton
		cmp.SearchAndClickEdit("EbtCash");
		
		//Select the Gift Card Payment Type
		if(pscpg.Card_TypeInput().getAttribute("value").equalsIgnoreCase("EbtCash"))
		{
			test.log(LogStatus.PASS, "EbtCash Card Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "EbtCash Card Type Not Selected after Update");
		}
		
		Thread.sleep(500);
		//Change the Amex Card Type
		pscpg.Select_Others_CardType();
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charges Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges updated successfully for Others");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges updated fail for Others");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}		Thread.sleep(5000);
	}
	
	
	
	@Test(priority = 5,enabled = false)
	public void Add_All_Cards_and_ServiceCharge(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pscpg=new PaymentSettingsPage(driver, test);

		
		Thread.sleep(10000);
		//Click New Service Charge
		pscpg.Click_NewServiceCharge();
		
		Thread.sleep(5000);
		//Select Visa
		pscpg.Select_Visa_CardType();
		
		//Enter Service charge
		pscpg.Enter_Service_ChargeName("1000");
		
		//Enter Tip Charge
		pscpg.Enter_TipCharge("800");
		
		//Enter Gratuity Charge
		pscpg.Enter_GratuityCharge("500");
		
		Thread.sleep(500);
		//Click the Save button 
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Service Charges Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charge Added Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges for Visa Card Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Card Visa is already Used."))
		{
			test.log(LogStatus.INFO, "Card Visa is already Used.");
			
			//Click Cancel button
			cmp.Click_CancelButton();
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges for Visa Card Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(8000);
		//Click New Service Charge
		pscpg.Click_NewServiceCharge();
		
		Thread.sleep(2000);
		//Select Master
		pscpg.Select_Master_CardType();
		
		//Enter Service charge
		pscpg.Enter_Service_ChargeName("1000");
		
		//Enter Tip Charge
		pscpg.Enter_TipCharge("800");
		
		//Enter Gratuity Charge
		pscpg.Enter_GratuityCharge("500");
		
		Thread.sleep(500);
		//Click the Save button 
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Service Charges Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charge Added Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges for Master Card Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Card Visa is already Used."))
		{
			test.log(LogStatus.INFO, "Card Master is already Used.");
			
			//Click Cancel button
			cmp.Click_CancelButton();
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges for Master Card Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	
		Thread.sleep(5000);
		//Click New Service Charge
		pscpg.Click_NewServiceCharge();
		Thread.sleep(5000);
		//Select Amex
		pscpg.Select_Amex_CardType();
		
		//Enter Service charge
		pscpg.Enter_Service_ChargeName("1000");
		
		//Enter Tip Charge
		pscpg.Enter_TipCharge("800");
		
		//Enter Gratuity Charge
		pscpg.Enter_GratuityCharge("500");
		
		Thread.sleep(500);
		//Click the Save button 
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Service Charges Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charge Added Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges for Amex Card Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Card Visa is already Used."))
		{
			test.log(LogStatus.INFO, "Card Amex is already Used.");
			
			//Click Cancel button
			cmp.Click_CancelButton();
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges for Amex Card Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	
		
		Thread.sleep(5000);
		//Click New Service Charge
		pscpg.Click_NewServiceCharge();
		Thread.sleep(5000);
		//Select Diners
		pscpg.Select_Diners_CardType();
		
		//Enter Service charge
		pscpg.Enter_Service_ChargeName("1000");
		
		//Enter Tip Charge
		pscpg.Enter_TipCharge("800");
		
		//Enter Gratuity Charge
		pscpg.Enter_GratuityCharge("500");
		
		Thread.sleep(500);
		//Click the Save button 
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Service Charges Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charge Added Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges for Diners Card Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Card Visa is already Used."))
		{
			test.log(LogStatus.INFO, "Card Diners is already Used.");
			
			//Click Cancel button
			cmp.Click_CancelButton();
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges for Diners Card Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	
		Thread.sleep(5000);
		//Click New Service Charge
		pscpg.Click_NewServiceCharge();
		Thread.sleep(5000);
		//Select JCB
		pscpg.Select_Visa_CardType();
		
		//Enter Service charge
		pscpg.Enter_Service_ChargeName("1000");
		
		//Enter Tip Charge
		pscpg.Enter_TipCharge("800");
		
		//Enter Gratuity Charge
		pscpg.Enter_GratuityCharge("500");
		
		Thread.sleep(500);
		//Click the Save button 
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Service Charges Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charge Added Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges for JCB Card Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Card Visa is already Used."))
		{
			test.log(LogStatus.INFO, "Card JCB is already Used.");
			
			//Click Cancel button
			cmp.Click_CancelButton();
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges for JCB Card Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	
		Thread.sleep(5000);
		//Click New Service Charge
		pscpg.Click_NewServiceCharge();
		Thread.sleep(5000);
		//Select Discover
		pscpg.Select_Discover_CardType();
		
		//Enter Service charge
		pscpg.Enter_Service_ChargeName("1000");
		
		//Enter Tip Charge
		pscpg.Enter_TipCharge("800");
		
		//Enter Gratuity Charge
		pscpg.Enter_GratuityCharge("500");
		
		Thread.sleep(500);
		//Click the Save button 
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Service Charges Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charge Added Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges for Discover Card Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Card Visa is already Used."))
		{
			test.log(LogStatus.INFO, "Card Discover is already Used.");
			
			//Click Cancel button
			cmp.Click_CancelButton();
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges for Discover Card Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	
		Thread.sleep(5000);
		//Click New Service Charge
		pscpg.Click_NewServiceCharge();
		Thread.sleep(5000);
		//Select ATH
		pscpg.Select_ATH_CardType();
		
		//Enter Service charge
		pscpg.Enter_Service_ChargeName("1000");
		
		//Enter Tip Charge
		pscpg.Enter_TipCharge("800");
		
		//Enter Gratuity Charge
		pscpg.Enter_GratuityCharge("500");
		
		Thread.sleep(500);
		//Click the Save button 
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Service Charges Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charge Added Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges for ATH Card Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Card Visa is already Used."))
		{
			test.log(LogStatus.INFO, "Card ATH is already Used.");
			
			//Click Cancel button
			cmp.Click_CancelButton();
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges for ATH Card Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	
		Thread.sleep(5000);
		//Click New Service Charge
		pscpg.Click_NewServiceCharge();
		Thread.sleep(5000);
		//Select Cash
		pscpg.Select_Cash_CardType();
		
		//Enter Service charge
		pscpg.Enter_Service_ChargeName("1000");
		
		//Enter Tip Charge
		pscpg.Enter_TipCharge("800");
		
		//Enter Gratuity Charge
		pscpg.Enter_GratuityCharge("500");
		
		Thread.sleep(500);
		//Click the Save button 
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Service Charges Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charge Added Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges for Cash Card Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Card Visa is already Used."))
		{
			test.log(LogStatus.INFO, "Card Cash is already Used.");
			
			//Click Cancel button
			cmp.Click_CancelButton();
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges for Cash Card Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	
		Thread.sleep(5000);
		//Click New Service Charge
		pscpg.Click_NewServiceCharge();
		Thread.sleep(5000);
		//Select Unica
		pscpg.Select_Unica_CardType();
		
		//Enter Service charge
		pscpg.Enter_Service_ChargeName("1000");
		
		//Enter Tip Charge
		pscpg.Enter_TipCharge("800");
		
		//Enter Gratuity Charge
		pscpg.Enter_GratuityCharge("500");
		
		Thread.sleep(500);
		//Click the Save button 
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Service Charges Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charge Added Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges for Unica Card Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Card Visa is already Used."))
		{
			test.log(LogStatus.INFO, "Card Unica is already Used.");
			
			//Click Cancel button
			cmp.Click_CancelButton();
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges for Unica Card Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	
		Thread.sleep(5000);
		//Click New Service Charge
		pscpg.Click_NewServiceCharge();
		Thread.sleep(5000);
		//Select Ebt
		pscpg.Select_Ebt_CardType();
		
		//Enter Service charge
		pscpg.Enter_Service_ChargeName("1000");
		
		//Enter Tip Charge
		pscpg.Enter_TipCharge("800");
		
		//Enter Gratuity Charge
		pscpg.Enter_GratuityCharge("500");
		
		Thread.sleep(500);
		//Click the Save button 
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Service Charges Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charge Added Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges for Ebt Card Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Card Visa is already Used."))
		{
			test.log(LogStatus.INFO, "Card Ebt is already Used.");
			
			//Click Cancel button
			cmp.Click_CancelButton();
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges for Ebt Card Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(5000);
		//Click New Service Charge
		pscpg.Click_NewServiceCharge();
		Thread.sleep(5000);
		//Select Fondo
		pscpg.Select_Fondo_CardType();
		
		//Enter Service charge
		pscpg.Enter_Service_ChargeName("1000");
		
		//Enter Tip Charge
		pscpg.Enter_TipCharge("800");
		
		//Enter Gratuity Charge
		pscpg.Enter_GratuityCharge("500");
		
		Thread.sleep(500);
		//Click the Save button 
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Service Charges Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charge Added Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges for Fondo Card Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Card Visa is already Used."))
		{
			test.log(LogStatus.INFO, "Card Fondo is already Used.");
			
			//Click Cancel button
			cmp.Click_CancelButton();
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges for Fondo Card Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	
		Thread.sleep(5000);
		//Click New Service Charge
		pscpg.Click_NewServiceCharge();
		Thread.sleep(5000);
		//Select EbtCash
		pscpg.Select_EbtCash_CardType();
		
		//Enter Service charge
		pscpg.Enter_Service_ChargeName("1000");
		
		//Enter Tip Charge
		pscpg.Enter_TipCharge("800");
		
		//Enter Gratuity Charge
		pscpg.Enter_GratuityCharge("500");
		
		Thread.sleep(500);
		//Click the Save button 
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Service Charges Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charge Added Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charges for EbtCash Card Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Card Visa is already Used."))
		{
			test.log(LogStatus.INFO, "Card EbtCash is already Used.");
			
			//Click Cancel button
			cmp.Click_CancelButton();
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charges for EbtCash Card Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	
		Thread.sleep(2000);
		/*
		 * //Click New Service Charge pscpg.Click_NewServiceCharge();
		 * Thread.sleep(5000); //Select Others pscpg.Select_Others_CardType();
		 * 
		 * //Enter Service charge pscpg.Enter_Service_ChargeName("1000");
		 * 
		 * //Enter Tip Charge pscpg.Enter_TipCharge("800");
		 * 
		 * //Enter Gratuity Charge pscpg.Enter_GratuityCharge("500");
		 * 
		 * Thread.sleep(500); //Click the Save button cmp.Click_SaveButton();
		 * 
		 * Thread.sleep(3000); //Check whether the New Service Charges Saved or not
		 * if(cmp.ConfirmationAlertMsg().getText().
		 * equalsIgnoreCase("Service Charge Added Successfully")) {
		 * test.log(LogStatus.PASS,
		 * "Service Charges for Others Card Saved Successfully");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else
		 * if(cmp.ConfirmationAlertMsg().getText().
		 * equalsIgnoreCase("Card Visa is already Used.")) { test.log(LogStatus.INFO,
		 * "Card Others is already Used.");
		 * 
		 * //Click Cancel button cmp.Click_CancelButton();
		 * 
		 * } else { test.log(LogStatus.FAIL,
		 * "Service Charges for Others Card Save Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
	
		
		//Click Save button
		//cmp.Click_SaveButton();
		/*
		 * driver.findElement(By.xpath("//button[.='SAVE']")).click();
		 * 
		 * Thread.sleep(3000); //Check whether the New Payment Method Saved or not
		 * if(cmp.ConfirmationAlertMsg().getText().
		 * equalsIgnoreCase("Payment Settings Saved Successfully")) {
		 * test.log(LogStatus.PASS,
		 * "Payment Settings Saved Successfully after Adding All Cards in Service Charges"
		 * );
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL,
		 * "Payment Settings Save Failed after Adding All Cards in Service Charges");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 * 
		 * Thread.sleep(6000);
		 */
	}

	@Test(priority = 5,enabled = false)
	public void Change_and_Update_Instant_Cash_Reward_Payment_Settings(SelfHealingDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		pscpg=new PaymentSettingsPage(driver, test);
		
		//Click Instant Cash Discount
		pscpg.Select_Instant_Cash_Reward();
		
		//Click the Save button
				try
				{
					cmp.Click_SaveButton();
					
					test.log(LogStatus.FAIL, "Allow to Click/Save Payment method without Giving Instant Cash Reward Name");
					
					if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Settings Saved Successfully"))
					{
						test.log(LogStatus.FAIL, "Payment Settings saved without giving Instant Cash Reward Name");
					}
					else
					{
						
					}

				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, "Unable to Click/Save Payment method without Giving Instant Cash Reward Name");
				}
						
								String NameExcess = "Entering Invalid Name to input"; 
								int ActualSize= NameExcess.length();
								System.out.println(ActualSize);
				
								//Enter the Instant Cash Reward Name
								cmp.EnterName(NameExcess);
								
								//To get value
								String ActualName=cmp.NameInputBox().getAttribute("value");
								int EnteredSize= ActualName.length();
								System.out.println(EnteredSize);
				
								if(ActualSize!=EnteredSize)
								{
									test.log(LogStatus.PASS, "Name should not be Exceeded 25 Characters in Fee Name");
								}
								else
								{
									test.log(LogStatus.FAIL, "Name should exceeded the size in Fee Name");
								}
								
								//Enter the Fee Name 
								cmp.EnterName("Instant Cash Reward Offer");

								//Clear Percentage
								pscpg.Enter_InstantCashReward("");
								
								//Click the Save button
								try
								{
									cmp.Click_SaveButton();
									
									test.log(LogStatus.FAIL, "Allow to Click/Save Payment method without Giving Instant Cash Reward Percentage");
									
									if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Settings Saved Successfully"))
									{
										test.log(LogStatus.FAIL, "Payment Settings saved without giving Instant Cash Reward Percentage");
									}
									else
									{
										
									}

								}
								catch(Exception e)
								{
									test.log(LogStatus.PASS, "Unable to Click/Save Payment method without Giving Instant Cash Reward Percentage");
								}
								
								/*
								 * //Enter Cash Discount pscpg.Enter_InstantCashReward("10500");
								 * 
								 * //Verify whether the Enter Valid Percentage pop up displayed or not
								 * if(pscpg.Valid_PercentageErrorMsg().isDisplayed()) { test.log(LogStatus.PASS,
								 * "Enter Valid Percentage is Displayed when Entering above 100 percentage in Instant Cash Reward Percentage"
								 * ); } else { test.log(LogStatus.FAIL,
								 * "Enter Valid Percentage is not Displayed when Entering above 100 percentage in Instant Cash Reward Percentage"
								 * ); }
								 */
								
								//Enter the Instant Cash Reward Percentage
								pscpg.Enter_InstantCashReward("1000");
								
								
								//Clear the Instant Cash Reward name
								cmp.EnterName("");
								
								//Click the Save button
								try
								{
									cmp.Click_SaveButton();
									
									test.log(LogStatus.FAIL, "Allow to Click/Save Payment Settings after entering Reward percentage without Giving Instant Cash Reward Name");
									
									if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Settings Saved Successfully"))
									{
										test.log(LogStatus.FAIL, "Payment Settings saved after entering Reward percentage without giving Instant Cash Reward Percentage");
									}
									else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Name"))
									{
										test.log(LogStatus.PASS, "Please Enter Name Pop up is Displayed");
									}

								}
								catch(Exception e)
								{
									test.log(LogStatus.PASS, "Unable to Click/Save Payment Settings after entering Reward percentage without Giving Instant Cash Reward Percentage");
								}
								
								
								//Enter the Instant Cash Reward Name
								cmp.EnterName("Instant Cash Reward Offer");
								
								//Enter the Percentage
								pscpg.Enter_InstantCashReward("2000");
								
								Thread.sleep(5000);
								//Click the Save button
								//cmp.Click_SaveButton();
								driver.findElement(By.xpath("//button[.='SAVE']")).click();
		
								
								Thread.sleep(3000);
								//Check whether the New Payment Method Saved or not
								if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Settings Saved Successfully"))
								{
									test.log(LogStatus.PASS, "Payment Settings Saved Successfully");
								
									ut.PassedCaptureScreenshotAsBASE64(driver, test);
								}
								else
								{
									test.log(LogStatus.FAIL, "Payment Settings Save Failed");
									
									ut.FailedCaptureScreenshotAsBASE64(driver, test);
								}
								
	}
	
		
	@Test(priority = 5,enabled = false)
	public void Delete_ServiceCharge_Payment_Settings(SelfHealingDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		pscpg=new PaymentSettingsPage(driver, test);
		//Thread.sleep(10000);for(int i = 1;i<=5;i++) {driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);}Thread.sleep(3000);
		//Select Service Charge
		//pscpg.Select_Service_Charge();
		
		//Search and Click Delete button
				cmp.SearchAndClickDelete("Others");
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();
		
				Thread.sleep(3000);
				try
				{
					//Check whether the New Payment Method Saved or not
					if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charge deleted successfully"))
					{
						test.log(LogStatus.FAIL, "Service Charge in Payment Settings Deleted when clicking Cancel button");
					
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Service Charge in Payment Settings not Deleted when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				
		//Search and Click Delete button
		cmp.SearchAndClickDelete("Others");
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Service Charge Removed Successfully"))
		{
			test.log(LogStatus.PASS, "Service Charge in Payment Settings Deleted Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charge in Payment Settings Deletion Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(5000);
		
		try {
			for(int i = 1; i <= 20; i++) {
				if(driver.findElement(By.xpath("//data-grid-row/div/div/div[2]/button")).isDisplayed())
				{
					driver.findElement(By.xpath("//data-grid-row/div/div/div[2]/button")).click();
				
					Thread.sleep(500);
					//Click the Delete button
					cmp.Click_DeleteButton();
				}Thread.sleep(4000);
			}
		}catch(Exception r) {}
		
		try {
			//Click the Save button
			//cmp.Click_SaveButton();
			Thread.sleep(8000);
			driver.findElement(By.xpath("//button[.='SAVE']")).click();
			Thread.sleep(3000);
			//Check whether the New Payment Method Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Settings Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Payment Settings Saved Successfully");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Payment Settings Save Failed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}catch(Exception d) {}
		
		Thread.sleep(1000);
		driver.navigate().refresh();
		
		Thread.sleep(3000);
		//Verify whether the Service Charge Selected after Reloading page or not
		if(pscpg.Service_ChargeTab().isSelected())
		{
			test.log(LogStatus.PASS, "Service Charge is selected after Refreshing/Reopening the after Update");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Charge is not selected after Refreshing/Reopening the after Update");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(3000);
	}

}
