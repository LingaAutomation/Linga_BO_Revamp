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
import com.Pages.SaleRecapReport_SettingsPage;
import com.Pages.SaleRecapReport_SettingsPage;
import com.Test.LoginTest;
import com.epam.healenium.SelfHealingDriver;
import com.Pages.LoginPage;
import com.Pages.SaleRecapReport_SettingsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.netty.handler.pcap.PcapWriteHandler;

public class Settings_Sale_Recap_Report 
{

	public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings - Sale Recap Report");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	SaleRecapReport_SettingsPage srrp;
	
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
//		driver=new ChromeDriver(chrOpt);
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
		Open_Sales_Recap_Report_Page(driver);
		Disable_And_Update_Sales_Recap_Report(driver);
		Enable_And_Update_Category_LevelType_Sales_Recap_Report(driver);
		Enable_And_Update_SubCategory_LevelType_Sales_Recap_Report(driver);
		Enable_And_Update_MenuItems_LevelType_Sales_Recap_Report(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Sales_Recap_Report_Page(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Payment Method page
		driver.get(Utility.getProperty("baseURL")+"settings/"+"salesRecapReport");

		Thread.sleep(5000);
		//Verify the Sales Recap Report page loaded or not
		cmp.VerifyMainScreenPageHeader("Sales Recap Report");	
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Disable_And_Update_Sales_Recap_Report(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		srrp=new SaleRecapReport_SettingsPage(driver, test);
		Thread.sleep(2000);
		
		//Disable Guest/Checks
		srrp.Disable_GuestChecks();
		
		//Disable Cover
		srrp.Disable_Cover();
		
		//Check whether the Level Type Displayed or not
		try
		{
		if(srrp.Category_LevelType().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Level Type Displayed");
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Level Type is not Displayed");
		}

		//Disable Grand Sales
		srrp.Disable_Grand_Sales();
		
		//Disable Gross Receipt
		srrp.Disable_Gross_Receipt();
		
		//Disable Gross Void
		srrp.Disable_Gross_Void();
		
		//Disable Net Void
				srrp.Disable_Net_Void();
				
				//Disable CC Split Up
				srrp.Disable_CC_SplitUp();
				
				//Disable Other Payments Split Up
				srrp.Disable_OtherPayments_SplitUp();
				
				//Select System Defined
				srrp.Click_SystemDefined();
				
				//Disable Tax Split Up
				srrp.Disable_Tax_SplitUp();
				try
				{
				//Check whether the Tax with Net Sales Displayed or not
				if(srrp.Taxwith_NetSales_YesBtn().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Tax with Net sales Displayed");
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Tax with Net sales is not Displayed");
				}
				
				//Disable Tax Exempt
				srrp.Disable_Tax_Exempt();
				
				//Disable Opening Balance
				srrp.Disable_OpeningBalance();
				
				//Disable Paid In/Out
				srrp.Disable_PaidIn_Out();
				
				//Disable Cash Drop in Summary
				srrp.Disable_Cash_Drop();
				
				//Disable Cash Expected in Summary
				srrp.Disable_Cash_Expected_Summary();
				
				//Disable Over / Shortage
				srrp.Disable_Over_Shortage_Summary();
				
				//Disable Cash Expected in Formula Defintion
				srrp.Disable_Cash_Expected_FormulaDef();
				
				try
				{
				//Check whether the Add Displayed or not
				if(srrp.Cash_Expected_AddInputBox().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Adding Cash Expected Selection Displayed");
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Adding Cash Expected Selection is not Displayed");
		
				}
				
				//Disable Overage/Shortage in Formula Defintion
				srrp.Disable_Over_Shortage_Summary_FormulaDef();
				
				try
				{
				//Check whether the Add Displayed or not
				if(srrp.Overage_Shortage_AddInputBox().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Adding Overage/Shortage Selection Displayed");
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Adding Overage/Shortage Selection is not Displayed");
		
				}
				
				//Disable Department Summary
				srrp.Disable_Department_Summary();
				
				//Disable Category Summary
				srrp.Disable_Category_Summary();
				
				//Disable Hourly Summary
				srrp.Disable_Hourly_Summary();
				
				//Disable Include Credits in Daily Summary Report
				srrp.Disable_IncludeCredits_in_DailySummaryReport();
				
		Thread.sleep(1000);
		//Click the Update button
		srrp.Click_UpdateButtonSettings();
		 
		Thread.sleep(3000);
		//Check whether the New Payment Method Updated or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sale Recap Report Settings Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Sale Recap Report Settings Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Sales Recap Report Settings Update Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		

	}
		
	@Test(priority = 5,enabled = false)
	public void Enable_And_Update_Category_LevelType_Sales_Recap_Report(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		srrp=new SaleRecapReport_SettingsPage(driver, test);
		
		driver.navigate().refresh();
		Thread.sleep(5000);
		
		//Check whether the Guest/Checks Enabled or not
		if(!srrp.Guest_Checks_YesBtn().isSelected())
		{
			test.log(LogStatus.PASS, "Guest/Checks is not Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Guest/Checks is Selected");
		}
		Thread.sleep(1000);
		//Enable Guest/Checks
		srrp.Enable_GuestChecks();
		
		Thread.sleep(1000);
		//Check whether the Cover Enabled or not
		if(!srrp.Cover_YesBtn().isSelected())
		{
			test.log(LogStatus.PASS, "Cover is not Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Cover is Selected");
		}
		
		//Enable Cover
		srrp.Enable_Cover();
		
		for(int i=1;i<=5;i++)
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		Thread.sleep(1000);
		//Select Level Type Catgory
		srrp.Click_SubCategory_LevelType();
//		try
//		{
//			Thread.sleep(1000);
//			//Click the Update button
//			srrp.Click_UpdateButtonSettings();
//			 
//			Thread.sleep(3000);
//			//Check whether the New Payment Method Updated or not
//			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sale Recap Report Settings Updated Successfully"))
//			{
//				test.log(LogStatus.FAIL, "Sale Recap Report Settings Updated without Selecting Level Type Items");
//			
////				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		
//		}
//		catch(Exception g)
//		{
//		
//				test.log(LogStatus.FAIL, "Sales Recap Report Settings Update Failed without Selecting Level Type Items");
//				
////				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			
//		}
//		try
//		{
//		if(srrp.UpdateBtnIn_SaleRecapSettings().isEnabled())
//		{
//			test.log(LogStatus.FAIL, "Update button Enabled without Selecting Level Type Items");		
//
//		}
//		}
//		catch(Exception p)
//		{
//			test.log(LogStatus.PASS, "Update button not Enabled without Selecting Level Type Items");
//
//		}
		
		Thread.sleep(1000);
		srrp.Click_Category_LevelType();
		
		Thread.sleep(20000);
		//Select the Categories
		srrp.Select_Category_LevelTypeItems();
		
		//Check whether the Grand Sales Enabled or not
				if(!srrp.Grand_Sales_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Grand Sales is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Grand Sales is Selected");
				}
		
		//Enable Grand Sales
		srrp.Enable_Grand_Sales();
		
		//Check whether the Gross Receipt Enabled or not
		if(!srrp.Gross_Receipt_YesBtn().isSelected())
		{
			test.log(LogStatus.PASS, "Gross Receipt is not Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gross Receipt is Selected");
		}

		
		//Enable Gross Receipt
		srrp.Enable_Gross_Receipt();
		
		//Check whether the Gross Void Enabled or not
		if(!srrp.Gross_Void_YesBtn().isSelected())
		{
			test.log(LogStatus.PASS, "Gross Void is not Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gross Void is Selected");
		}

		
		//Enable Gross Void
		srrp.Enable_Gross_Void();
		
		//Check whether the Net Void Enabled or not
				if(!srrp.Net_Void_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Net Void is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Net Void is Selected");
				}

				
				//Enable Net Void
				srrp.Enable_Net_Void();
				
				
				//Check whether the CC Split Up Enabled or not
				if(!srrp.CC_SplitUp_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "CC Split Up is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "CC Split Up is Selected");
				}

				
				//Enable CC Split Up
				srrp.Enable_CC_SplitUp();
				
				//Check whether the Other Payments Split Up Enabled or not
				if(!srrp.OtherPayments_SplitUp_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Other Payments Split Up is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Other Payments Split Up is Selected");
				}

				
				//Enable Other Payments Split Up
				srrp.Enable_OtherPayments_SplitUp();
				
				//Check whether the System Defined selected or not
				if(srrp.SystemDefined_PaymentName().isEnabled())
				{
					test.log(LogStatus.PASS, "System Defined is Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "System Defined is not Selected");
				}
				
				//Select User Defined
				srrp.Click_UserDefined();
				
				//Check whether the Tax Split Up Enabled or not
				if(!srrp.Tax_SplitUp_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Tax Split Up is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Tax Split Up is Selected");
				}

				
				//Enable Tax Split Up
				srrp.Enable_Tax_SplitUp();
				
				
				//Check whether the Tax with Net Sales Displayed or not
				if(srrp.Taxwith_NetSales_YesBtn().isDisplayed())
				{
					test.log(LogStatus.PASS, "Tax with Net sales Displayed");
					
					//Disable Tax with Net Sales
					srrp.Disable_Taxwith_NetSales();
				}
				else
				{
					test.log(LogStatus.PASS, "Tax with Net sales is not Displayed");
				}
				
				
				//Check whether the Tax Exempt Enabled or not
				if(!srrp.Tax_Exempt_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Tax Exempt is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Tax Exempt is Selected");
				}

				
				//Enable Tax Exempt
				srrp.Enable_Tax_Exempt();
				
								
				
				//Check whether the Opening Balance Enabled or not
				if(!srrp.OpeningBalance_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Opening Balance is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Opening Balance is Selected");
				}

				
				//Enable Opening Balance
				srrp.Enable_OpeningBalance();
				
				
				//Check whether the Paid In/Out Enabled or not
				if(!srrp.PaidIn_Out_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Paid In/Out is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Paid In/Out is Selected");
				}

				
				//Enable Cash Drop
				srrp.Enable_PaidIn_Out();
				
				//Check whether the Cash Drop Enabled or not
				if(!srrp.Cash_Drop_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Cash Drop is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Cash Drop is Selected");
				}

				
				//Enable Cash Drop
				srrp.Enable_Cash_Drop();
				try {
				
				//Check whether the Cash Expected in Summary Enabled or not
				if(!srrp.Cash_Expected_Summary_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Cash Expected in Summary is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Cash Expected in Summary is Selected");
				}

				
				//Enable Cash Expected in Summary
				srrp.Enable_Cash_Expected_Summary();
				
				//Check whether the Over / Shortage in Summary Enabled or not
				if(!srrp.Over_Shortage_Summary_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Over / Shortage in Summary is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Over / Shortage in Summary is Selected");
				}

				
				//Enable Over / Shortage in Summary
				srrp.Enable_Over_Shortage_Summary();
				
				
				//Check whether the Over / Shortage in Summary Enabled or not
				if(!srrp.Over_Shortage_Summary_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Over / Shortage in Summary is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Over / Shortage in Summary is Selected");
				}

				
				//Enable Over / Shortage in Summary
				srrp.Enable_Over_Shortage_Summary();
				
				//Check whether the Cash Expected in Formula Definition Enabled or not
				if(!srrp.Cash_Expected_FormulaDef_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Cash Expected in Formula Definition is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Cash Expected in Formula Defintion is Selected");
				}

				
				//Enable Cash Expected in Formula Defintion
				srrp.Enable_Cash_Expected_FormulaDef();
				
				//Check whether the Cash Expected Items screen displayed or not
				if(srrp.Cash_Expected_AddInputBox().isDisplayed())
				{
					test.log(LogStatus.PASS, "Adding screen is opened for Cash Expected in Formula Definition");
				}
				else
				{
					test.log(LogStatus.FAIL, "Adding screen is not open for Cash Expected in Formula Definition");
				}
				
				for(int i=1;i<=6;i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}
				
				//Select the Add in Cash Expected
				srrp.Add_CashExpected_FormulaDefintion();
				
				//Check whether the Overage/Shortage in Formula Definition Enabled or not
				if(!srrp.Over_Shortage_Summary_FormulaDef_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Overage/Shortage in Formula Definition is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Overage/Shortage in Formula Defintion is Selected");
				}

				
				//Enable Overage/Shortage in Formula Defintion
				srrp.Enable_Over_Shortage_Summary_FormulaDef();
				
				//Check whether the Overage/Shortage Items screen displayed or not
				if(srrp.Overage_Shortage_AddInputBox().isDisplayed())
				{
					test.log(LogStatus.PASS, "Adding screen is opened for Overage/Shortage in Formula Definition");
				}
				else
				{
					test.log(LogStatus.FAIL, "Adding screen is not open for Overage/Shortage in Formula Definition");
				}
				
				for(int i=1;i<=8;i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}
				
				Thread.sleep(2000);
				//Select the Add in Cash Expected
				srrp.Add_Over_Shortage_FormulaDefintion();
				
				
				//Check whether the Department Summary Enabled or not
				if(!srrp.Department_Summary_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Department Summary is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Department Summary is Selected");
				}

				
				//Enable Department Summary
				srrp.Enable_Department_Summary();
				
				//Check whether the Category Summary Enabled or not
				if(!srrp.Category_Summary_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Category Summary is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Category Summary is Selected");
				}

				
				//Enable Hourly Summary
				srrp.Enable_Category_Summary();
				
				//Check whether the Hourly Summary Enabled or not
				if(!srrp.Hourly_Summary_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Hourly Summary is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Hourly Summary is Selected");
				}

				
				//Enable Hourly Summary
				srrp.Enable_Hourly_Summary();
				
				//Check whether the Include Credits in Daily Summary Report Enabled or not
				if(!srrp.IncludeCredits_in_DailySummaryReport_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Include Credits in Daily Summary Report is not Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Include Credits in Daily Summary Report is Selected");
				}
				}
				catch (Exception e) {
					// TODO: handle exception
				}

				
				//Enable Include Credits in Daily Summary Report
				srrp.Enable_IncludeCredits_in_DailySummaryReport();
				
				Thread.sleep(1000);
				//Click the Update button
				srrp.Click_UpdateButtonSettings();
				 
				Thread.sleep(3000);
				//Check whether the New Payment Method Updated or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sale Recap Report Settings Updated Successfully"))
				{
					test.log(LogStatus.PASS, "Sale Recap Report Settings Updated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Sales Recap Report Settings Update Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Enable_And_Update_SubCategory_LevelType_Sales_Recap_Report(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		srrp=new SaleRecapReport_SettingsPage(driver, test);

		driver.navigate().refresh();
		Thread.sleep(5000);
		
		//Check whether the Guest/Checks Enabled or not
		if(srrp.Guest_Checks_YesBtn().isSelected())
		{
			test.log(LogStatus.PASS, "Guest/Checks is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Guest/Checks is not Selected");
		}
		
		//Check whether the Cover Enabled or not
				if(srrp.Cover_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Cover is Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Cover is not Selected");
				}
				
				//Check whether the Category Selected or not
				if(srrp.Category_LevelType().isEnabled())
				{
					test.log(LogStatus.PASS, "Category is Selected in Level Type");
				}
				else
				{
					test.log(LogStatus.FAIL, "Category is not Selected in Level Type");
				}
				
				for(int i=1;i<=3;i++)
				{
					Thread.sleep(1000);
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}
				
				Thread.sleep(2000);
				//Select Level Type Catgory
				srrp.Click_SubCategory_LevelType();
				
				Thread.sleep(20000);
				//Select the Categories
				srrp.Select_SubCategory_LevelTypeItems();
				
				//Check whether the Grand Sales Enabled or not
						if(srrp.Grand_Sales_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Grand Sales is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Grand Sales is not Selected");
						}
				
				
				
				//Check whether the Gross Receipt Enabled or not
				if(srrp.Gross_Receipt_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Gross Receipt is Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Gross Receipt is not Selected");
				}

				
				//Check whether the Gross Void Enabled or not
				if(srrp.Gross_Void_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Gross Void is Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Gross Void is not Selected");
				}

	
				
				//Check whether the Net Void Enabled or not
						if(srrp.Net_Void_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Net Void is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Net Void is not Selected");
						}

										
						//Check whether the CC Split Up Enabled or not
						if(srrp.CC_SplitUp_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "CC Split Up is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "CC Split Up is not Selected");
						}


						//Check whether the Other Payments Split Up Enabled or not
						if(srrp.OtherPayments_SplitUp_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Other Payments Split Up is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Other Payments Split Up is not Selected");
						}

		
						//Check whether the System Defined selected or not
						if(srrp.UserDefined_PaymentName().isEnabled())
						{
							test.log(LogStatus.PASS, "User Defined is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "User Defined is not Selected");
						}
						
						
						
						//Check whether the Tax Split Up Enabled or not
						if(srrp.Tax_SplitUp_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Tax Split Up is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Tax Split Up is not Selected");
						}

						//Check whether the Tax with Net Sales Displayed or not
						if(srrp.Taxwith_NetSales_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Tax with Net sales Displayed");
							
							//Enable Tax with Net Sales
							srrp.Enable_Taxwith_NetSales();
						}
						else
						{
							test.log(LogStatus.PASS, "Tax with Net sales is not Displayed");
						}
						
						
						
						//Check whether the Tax Exempt Enabled or not
						if(srrp.Tax_Exempt_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Tax Exempt is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Tax Exempt is not Selected");
						}

	
						
						//Check whether the Opening Balance Enabled or not
						if(srrp.OpeningBalance_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Opening Balance is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Opening Balance is not Selected");
						}

						
						//Check whether the Paid In/Out Enabled or not
						if(srrp.PaidIn_Out_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Paid In/Out is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Paid In/Out is not Selected");
						}

	
						//Check whether the Cash Drop Enabled or not
						if(srrp.Cash_Drop_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Cash Drop is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Cash Drop is not Selected");
						}


						//Check whether the Cash Expected in Summary Enabled or not
						if(!srrp.Cash_Expected_Summary_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Cash Expected in Summary is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Cash Expected in Summary is not Selected");
						}


						
						//Check whether the Over / Shortage in Summary Enabled or not
						if(srrp.Over_Shortage_Summary_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Over / Shortage in Summary is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Over / Shortage in Summary is not Selected");
						}

			
						//Check whether the Over / Shortage in Summary Enabled or not
						if(srrp.Over_Shortage_Summary_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Over / Shortage in Summary is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Over / Shortage in Summary is not Selected");
						}


						//Check whether the Cash Expected in Formula Definition Enabled or not
						if(srrp.Cash_Expected_FormulaDef_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Cash Expected in Formula Definition is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Cash Expected in Formula Defintion is not Selected");
						}


						try {
						//Check whether the Cash Expected Items screen displayed or not
						if(srrp.Cash_Expected_AddInputBox().isDisplayed())
						{
							test.log(LogStatus.PASS, "Adding screen is opened for Cash Expected in Formula Definition");
						}
						else
						{
							test.log(LogStatus.FAIL, "Adding screen is not open for Cash Expected in Formula Definition");
						}
						
						//Select the Add in Cash Expected
						srrp.Add_CashExpected_FormulaDefintion();
						
						//Check whether the Overage/Shortage in Formula Definition Enabled or not
						if(srrp.Over_Shortage_Summary_FormulaDef_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Overage/Shortage in Formula Definition is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Overage/Shortage in Formula Defintion is not Selected");
						}

						
						//Check whether the Overage/Shortage Items screen displayed or not
						if(srrp.Overage_Shortage_AddInputBox().isDisplayed())
						{
							test.log(LogStatus.PASS, "Adding screen is opened for Overage/Shortage in Formula Definition");
						}
						else
						{
							test.log(LogStatus.FAIL, "Adding screen is not open for Overage/Shortage in Formula Definition");
						}
						
						//Select the Add in Cash Expected
						srrp.Add_Over_Shortage_FormulaDefintion();
						
						
						//Check whether the Department Summary Enabled or not
						if(srrp.Department_Summary_YesBtn().isEnabled())
						{
							test.log(LogStatus.PASS, "Department Summary is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Department Summary is not Selected");
						}

						
					
						//Check whether the Category Summary Enabled or not
						if(srrp.Category_Summary_YesBtn().isEnabled())
						{
							test.log(LogStatus.PASS, "Category Summary is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Category Summary is not Selected");
						}

				
						//Check whether the Hourly Summary Enabled or not
						if(srrp.Hourly_Summary_YesBtn().isEnabled())
						{
							test.log(LogStatus.PASS, "Hourly Summary is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Hourly Summary is not Selected");
						}

		
						//Check whether the Include Credits in Daily Summary Report Enabled or not
						if(srrp.IncludeCredits_in_DailySummaryReport_YesBtn().isEnabled())
						{
							test.log(LogStatus.PASS, "Include Credits in Daily Summary Report is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Include Credits in Daily Summary Report is not Selected");
						}
						}
						catch (Exception e) {
							// TODO: handle exception
						}

						
				
						Thread.sleep(1000);
						//Click the Update button
						srrp.Click_UpdateButtonSettings();
						 
						Thread.sleep(3000);
						//Check whether the New Payment Method Updated or not
						if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sale Recap Report Settings Updated Successfully"))
						{
							test.log(LogStatus.PASS, "Sale Recap Report Settings Updated Successfully for Sub-Catgeory Level Type");
						
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
						}
						else
						{
							test.log(LogStatus.FAIL, "Sales Recap Report Settings Update Failed for Sub-Catgeory Level Type");
							
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Enable_And_Update_MenuItems_LevelType_Sales_Recap_Report(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		srrp=new SaleRecapReport_SettingsPage(driver, test);

		driver.navigate().refresh();
		Thread.sleep(5000);
		
		//Check whether the Guest/Checks Enabled or not
		if(srrp.Guest_Checks_YesBtn().isSelected())
		{
			test.log(LogStatus.PASS, "Guest/Checks is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Guest/Checks is not Selected");
		}
		
		//Check whether the Cover Enabled or not
				if(srrp.Cover_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Cover is Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Cover is not Selected");
				}
				
				//Check whether the Category Selected or not
				if(srrp.SubCategory_LevelType().isEnabled())
				{
					test.log(LogStatus.PASS, "Sub-Category is Selected in Level Type");
				}
				else
				{
					test.log(LogStatus.FAIL, "Sub-Category is not Selected in Level Type");
				}
				
				Thread.sleep(1000);
				for(int i=1;i<=5;i++)
				{
					Thread.sleep(1000);
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}
				
				Thread.sleep(2000);
				//Select Level Type Menu Items
				srrp.Click_MenuItems_LevelType();
				
				
				Thread.sleep(20000);
				//Select the Menu Items
				srrp.Select_MenuItems_LevelTypeItems();
				
				Thread.sleep(1000);
				//Check whether the Grand Sales Enabled or not
						if(srrp.Grand_Sales_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Grand Sales is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Grand Sales is not Selected");
						}
				
				
				
				//Check whether the Gross Receipt Enabled or not
				if(srrp.Gross_Receipt_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Gross Receipt is Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Gross Receipt is not Selected");
				}

				
				//Check whether the Gross Void Enabled or not
				if(srrp.Gross_Void_YesBtn().isSelected())
				{
					test.log(LogStatus.PASS, "Gross Void is Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Gross Void is not Selected");
				}

	
				
				//Check whether the Net Void Enabled or not
						if(srrp.Net_Void_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Net Void is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Net Void is not Selected");
						}

										
						//Check whether the CC Split Up Enabled or not
						if(srrp.CC_SplitUp_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "CC Split Up is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "CC Split Up is not Selected");
						}


						//Check whether the Other Payments Split Up Enabled or not
						if(srrp.OtherPayments_SplitUp_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Other Payments Split Up is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Other Payments Split Up is not Selected");
						}

		
						//Check whether the User Defined selected or not
						if(srrp.UserDefined_PaymentName().isEnabled())
						{
							test.log(LogStatus.PASS, "User Defined is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "User Defined is not Selected");
						}
						
						
						
						//Check whether the Tax Split Up Enabled or not
						if(srrp.Tax_SplitUp_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Tax Split Up is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Tax Split Up is not Selected");
						}

						//Check whether the Tax with Net Sales Selected or not
						if(srrp.Taxwith_NetSales_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Tax with Net sales is Selected");
						}
						else
						{
							test.log(LogStatus.PASS, "Tax with Net sales is not Selected");
						}
					
						
						//Check whether the Tax Exempt Enabled or not
						if(srrp.Tax_Exempt_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Tax Exempt is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Tax Exempt is not Selected");
						}

	
						
						//Check whether the Opening Balance Enabled or not
						if(srrp.OpeningBalance_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Opening Balance is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Opening Balance is not Selected");
						}

						
						//Check whether the Paid In/Out Enabled or not
						if(srrp.PaidIn_Out_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Paid In/Out is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Paid In/Out is not Selected");
						}

	
						//Check whether the Cash Drop Enabled or not
						if(srrp.Cash_Drop_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Cash Drop is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Cash Drop is not Selected");
						}


						//Check whether the Cash Expected in Summary Enabled or not
						if(!srrp.Cash_Expected_Summary_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Cash Expected in Summary is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Cash Expected in Summary is not Selected");
						}


						
						//Check whether the Over / Shortage in Summary Enabled or not
						if(srrp.Over_Shortage_Summary_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Over / Shortage in Summary is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Over / Shortage in Summary is not Selected");
						}

			
						//Check whether the Over / Shortage in Summary Enabled or not
						if(srrp.Over_Shortage_Summary_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Over / Shortage in Summary is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Over / Shortage in Summary is not Selected");
						}


						//Check whether the Cash Expected in Formula Definition Enabled or not
						if(srrp.Cash_Expected_FormulaDef_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Cash Expected in Formula Definition is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Cash Expected in Formula Defintion is not Selected");
						}


						
						//Check whether the Cash Expected Items screen displayed or not
						if(srrp.Cash_Expected_AddInputBox().isDisplayed())
						{
							test.log(LogStatus.PASS, "Adding screen is opened for Cash Expected in Formula Definition");
						}
						else
						{
							test.log(LogStatus.FAIL, "Adding screen is not open for Cash Expected in Formula Definition");
						}
						
//						//Select the Add in Cash Expected
//						srrp.Add_CashExpected_FormulaDefintion();
//						
						//Check whether the Overage/Shortage in Formula Definition Enabled or not
						if(srrp.Over_Shortage_Summary_FormulaDef_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Overage/Shortage in Formula Definition is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Overage/Shortage in Formula Defintion is not Selected");
						}

				         try {
						//Check whether the Overage/Shortage Items screen displayed or not
						if(srrp.Overage_Shortage_AddInputBox().isDisplayed())
						{
							test.log(LogStatus.PASS, "Adding screen is opened for Overage/Shortage in Formula Definition");
						}
						else
						{
							test.log(LogStatus.FAIL, "Adding screen is not open for Overage/Shortage in Formula Definition");
						}
						
//						//Select the Add in Cash Expected
//						srrp.Add_Over_Shortage_FormulaDefintion();
//						
						
						//Check whether the Department Summary Enabled or not
						if(srrp.Department_Summary_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Department Summary is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Department Summary is not Selected");
						}

						
					
						//Check whether the Category Summary Enabled or not
						if(srrp.Category_Summary_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Category Summary is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Category Summary is not Selected");
						}

				
						//Check whether the Hourly Summary Enabled or not
						if(srrp.Hourly_Summary_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Hourly Summary is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Hourly Summary is not Selected");
						}

		
						//Check whether the Include Credits in Daily Summary Report Enabled or not
						if(srrp.IncludeCredits_in_DailySummaryReport_YesBtn().isSelected())
						{
							test.log(LogStatus.PASS, "Include Credits in Daily Summary Report is Selected");
						}
						else
						{
							test.log(LogStatus.FAIL, "Include Credits in Daily Summary Report is not Selected");
						}
				         }
				         catch (Exception e) {
							// TODO: handle exception
						}

						
				
						Thread.sleep(1000);
						//Click the Update button
						srrp.Click_UpdateButtonSettings();
						 
						Thread.sleep(3000);
						//Check whether the New Payment Method Updated or not
						if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sale Recap Report Settings Updated Successfully"))
						{
							test.log(LogStatus.PASS, "Sale Recap Report Settings Updated Successfully for Menu Items");
						
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
						}
						else
						{
							test.log(LogStatus.FAIL, "Sales Recap Report Settings Update Failed for Menu Items");
							
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						Thread.sleep(3000);
						//Check whether the Category Selected or not
						if(srrp.MenuItems_LevelType().isEnabled())
						{
							test.log(LogStatus.PASS, "Menu Items is Selected in Level Type");
						}
						else
						{
							test.log(LogStatus.FAIL, "Menu Items is not Selected in Level Type");
						}
						
						//Select Level Type Category
						srrp.Click_Category_LevelType();
						
						//Select the Menu Items
						srrp.Select_Category_LevelTypeItems();
						

						Thread.sleep(1000);
						//Click the Update button
						srrp.Click_UpdateButtonSettings();
						 
						Thread.sleep(3000);
						//Check whether the New Payment Method Updated or not
						if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sale Recap Report Settings Updated Successfully"))
						{
							test.log(LogStatus.PASS, "Sale Recap Report Settings Updated Successfully for Category");
						
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
						}
						else
						{
							test.log(LogStatus.FAIL, "Sales Recap Report Settings Update Failed for Category");
							
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
	}

	
	
}
