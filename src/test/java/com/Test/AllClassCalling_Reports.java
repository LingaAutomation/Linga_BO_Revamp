package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AllClassCalling_Reports {

	public WebDriver driver;
	

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Retesting Suite for Sale Reports");

	LoginPage lgpg; 

	Utility ut=new Utility();

	Common_XPaths cmp;
	LoginTest a=new LoginTest();
		
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
		
				try
				{
					if(new LoginPage(driver, test).LoginPageHeaderText().isDisplayed())
					{
						test.log(LogStatus.FAIL, "Application Logged Out");
						Login();
					}
				}
				catch(Exception lp) 
				{
					
				}
			}
		}
		
		
		@BeforeTest
		public void Login() throws Exception
		{
			
			
			Thread.sleep(2000);
			//Call the chrome driver
//			System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
//			//Open the Chrome window
//			driver = new ChromeDriver();
			
			System.setProperty("webdriver.chrome.driver","./Automation Driver/chromedriver.exe");
			//Open the Chrome window
			driver = new ChromeDriver();

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
		
		@AfterTest
		public void LogOut() throws Exception
		{
			a.LogOut(driver, test);
		}

		
		@Test(priority = 2,enabled = true)
		public void Reports_Sale_Recap_Report() throws Exception
		{
			Reports_Sale_Recap_Report a=new Reports_Sale_Recap_Report();
			a.Open_Sale_Recap_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Sale_Recap_Report_Today(driver);
			a.Sale_Recap_Report_Yesterday(driver);
			a.Sale_Recap_Report_Last_N_Days(driver);
			a.Sale_Recap_Report_This_Week(driver);
			a.Sale_Recap_Report_Last_Week(driver);
			a.Sale_Recap_Report_Last_7_Days(driver);
			a.Sale_Recap_Report_This_Month(driver);
			a.Sale_Recap_Report_Last_Month(driver);
			a.Sale_Recap_Report_Last_30_Days(driver);
			a.Sale_Recap_Report_Specific_Date(driver);
			a.Sale_Recap_Report_Date_Range(driver);
				
		}
		
		@Test(priority = 3,enabled = true)
		public void Reports_Department_Sale_Report() throws Exception
		{
			Reports_Department_Sale_Report a=new Reports_Department_Sale_Report();
			a.Open_Department_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Department_Report_Today(driver);
			a.Department_Report_Yesterday(driver);
			a.Department_Report_Last_N_Days(driver);
			a.Department_Report_This_Week(driver);
			a.Department_Report_Last_Week(driver);
			a.Department_Report_Last_7_Days(driver);
			a.Department_Report_This_Month(driver);
			a.Department_Report_Last_Month(driver);
			a.Department_Report_Last_30_Days(driver);
			a.Department_Report_Specific_Date(driver);
			a.Department_Report_Date_Range(driver);
			
					
		}
		
		
		@Test(priority = 4,enabled = true)
		public void Reports_Category_Sale_Report() throws Exception
		{
			Reports_Category_Sale_Report a=new Reports_Category_Sale_Report();
			a.Open_Category_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Category_Report_Today(driver);
			a.Category_Report_Yesterday(driver);
			a.Category_Report_Last_N_Days(driver);
			a.Category_Report_This_Week(driver);
			a.Category_Report_Last_Week(driver);
			a.Category_Report_Last_7_Days(driver);
			a.Category_Report_This_Month(driver);
			a.Category_Report_Last_Month(driver);
			a.Category_Report_Last_30_Days(driver);
			a.Category_Report_Specific_Date(driver);
			a.Category_Report_Date_Range(driver);
				
		}
	
		@Test(priority = 5,enabled = true)
		public void Reports_SubCategory_Sale_Report() throws Exception
		{
			Reports_SubCategory_Sale_Report a=new Reports_SubCategory_Sale_Report();
			a.Open_SubCategory_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.SubCategory_Report_Today(driver);
			a.SubCategory_Report_Yesterday(driver);
			a.SubCategory_Report_Last_N_Days(driver);
			a.SubCategory_Report_This_Week(driver);
			a.SubCategory_Report_Last_Week(driver);
			a.SubCategory_Report_Last_7_Days(driver);
			a.SubCategory_Report_This_Month(driver);
			a.SubCategory_Report_Last_Month(driver);
			a.SubCategory_Report_Last_30_Days(driver);
			a.SubCategory_Report_Specific_Date(driver);
			a.SubCategory_Report_Date_Range(driver);
				
		}
		
		@Test(priority = 6,enabled = true)
		public void Reports_MenuItem_Sale_Report() throws Exception
		{
			Reports_MenuItem_Sale_Report a=new Reports_MenuItem_Sale_Report();
			a.Open_MenuItem_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.MenuItem_Report_Today(driver);
			a.MenuItem_Report_Yesterday(driver);
			a.MenuItem_Report_Last_N_Days(driver);
			a.MenuItem_Report_This_Week(driver);
			a.MenuItem_Report_Last_Week(driver);
			a.MenuItem_Report_Last_7_Days(driver);
			a.MenuItem_Report_This_Month(driver);
			a.MenuItem_Report_Last_Month(driver);
			a.MenuItem_Report_Last_30_Days(driver);
			a.MenuItem_Report_Specific_Date(driver);
			a.MenuItem_Report_Date_Range(driver);
				
		}
		
		@Test(priority = 7,enabled = true)
		public void Reports_Modifier_Sale_Report() throws Exception
		{
			Reports_Modifier_Sale_Report a=new Reports_Modifier_Sale_Report();
			a.Open_Modifier_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Modifier_Report_Today(driver);
			a.Modifier_Report_Yesterday(driver);
			a.Modifier_Report_Last_N_Days(driver);
			a.Modifier_Report_This_Week(driver);
			a.Modifier_Report_Last_Week(driver);
			a.Modifier_Report_Last_7_Days(driver);
			a.Modifier_Report_This_Month(driver);
			a.Modifier_Report_Last_Month(driver);
			a.Modifier_Report_Last_30_Days(driver);
			a.Modifier_Report_Specific_Date(driver);
			a.Modifier_Report_Date_Range(driver);
				
		}
		
		@Test(priority = 8,enabled = true)
		public void Reports_Hourly_Sale_Report() throws Exception
		{
			Reports_Hourly_Sale_Report a=new Reports_Hourly_Sale_Report();
			a.Open_Hourly_Sale_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Hourly_Sale_Report_Today(driver);
			a.Hourly_Sale_Report_Yesterday(driver);
			a.Hourly_Sale_Report_Last_N_Days(driver);
			a.Hourly_Sale_Report_This_Week(driver);
			a.Hourly_Sale_Report_Last_Week(driver);
			a.Hourly_Sale_Report_Last_7_Days(driver);
			a.Hourly_Sale_Report_This_Month(driver);
			a.Hourly_Sale_Report_Last_Month(driver);
			a.Hourly_Sale_Report_Last_30_Days(driver);
			a.Hourly_Sale_Report_Specific_Date(driver);
			a.Hourly_Sale_Report_Date_Range(driver);
				
		}
		
		
		@Test(priority = 9,enabled = true)
		public void Reports_Daily_Sale_Report() throws Exception
		{
			Reports_Daily_Sale_Report a=new Reports_Daily_Sale_Report();
			a.Open_Daily_Sale_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Daily_Sale_Report_Today(driver);
			a.Daily_Sale_Report_Yesterday(driver);
			a.Daily_Sale_Report_Last_N_Days(driver);
			a.Daily_Sale_Report_This_Week(driver);
			a.Daily_Sale_Report_Last_Week(driver);
			a.Daily_Sale_Report_Last_7_Days(driver);
			a.Daily_Sale_Report_This_Month(driver);
			a.Daily_Sale_Report_Last_Month(driver);
			a.Daily_Sale_Report_Last_30_Days(driver);
			a.Daily_Sale_Report_Specific_Date(driver);
			a.Daily_Sale_Report_Date_Range(driver);
				
		}
		
		@Test(priority = 10,enabled = true)
		public void Reports_Cashier_Out_Report() throws Exception
		{
			Reports_Cashier_Out_Report a=new Reports_Cashier_Out_Report();
			a.Open_Cashier_Out_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Cashier_Out_Report_Today(driver);
			a.Cashier_Out_Report_Yesterday(driver);
			a.Cashier_Out_Report_Last_N_Days(driver);
			a.Cashier_Out_Report_This_Week(driver);
			a.Cashier_Out_Report_Last_Week(driver);
			a.Cashier_Out_Report_Last_7_Days(driver);
			a.Cashier_Out_Report_This_Month(driver);
			a.Cashier_Out_Report_Last_Month(driver);
			a.Cashier_Out_Report_Last_30_Days(driver);
			a.Cashier_Out_Report_Specific_Date(driver);
			a.Cashier_Out_Report_Date_Range(driver);
				
		}
		
		@Test(priority = 11,enabled = true)
		public void Reports_Weekly_Summary_Sale_Report() throws Exception
		{
			Reports_Weekly_Summary_Sale_Report a=new Reports_Weekly_Summary_Sale_Report();
			a.Open_WeeklySummary_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.WeeklySummary_Report_This_Week(driver);
			a.WeeklySummary_Report_Last_Week(driver);
			a.WeeklySummary_Report_Last_7_Days(driver);
			a.WeeklySummary_Report_Specific_Date(driver);
				
		}
		
		@Test(priority = 12,enabled = true)
		public void Reports_Sale_Summary_Report() throws Exception
		{
			Reports_Sale_Summary_Report a=new Reports_Sale_Summary_Report();
			a.Open_SaleSummary_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.SaleSummary_Report_Today(driver);
			a.SaleSummary_Report_Yesterday(driver);
			a.SaleSummary_Report_Last_N_Days(driver);
			a.SaleSummary_Report_This_Week(driver);
			a.SaleSummary_Report_Last_Week(driver);
			a.SaleSummary_Report_Last_7_Days(driver);
			a.SaleSummary_Report_This_Month(driver);
			a.SaleSummary_Report_Last_Month(driver);
			a.SaleSummary_Report_Last_30_Days(driver);
			a.SaleSummary_Report_Specific_Date(driver);
			a.SaleSummary_Report_Date_Range(driver);
				
		}
		
		@Test(priority = 13,enabled = true)
		public void Reports_Future_Order_Sale_Report() throws Exception
		{
			Reports_Future_Order_Sale_Report a=new Reports_Future_Order_Sale_Report();
			a.Open_FutureOrder_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.FutureOrder_Sale_Report(driver);
				
		}
		
		@Test(priority = 14,enabled = true)
		public void Reports_Sale_Logo_Sale() throws Exception
		{
			Reports_Logo_Sale a=new Reports_Logo_Sale();
			a.Open_Logo_Sale_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Logo_Sale_Report_Verify_Logo_Sale_By_Enable_BusinessDay(driver);
			a.Logo_Sale_Report_Today(driver);
			a.Logo_Sale_Report_Yesterday(driver);
			a.Logo_Sale_Report_Last_N_Days(driver);
			a.Logo_Sale_Report_This_Week(driver);
			a.Logo_Sale_Report_Last_Week(driver);
			a.Logo_Sale_Report_Last_7_Days(driver);
			a.Logo_Sale_Report_This_Month(driver);
			a.Logo_Sale_Report_Last_Month(driver);
			a.Logo_Sale_Report_Last_30_Days(driver);
			a.Logo_Sale_Report_Specific_Date(driver);
			a.Logo_Sale_Report_Date_Range(driver);
				
		}
		
		@Test(priority = 15,enabled = true)
		public void Reports_Sale_Logo_Payment() throws Exception
		{
			Reports_Logo_Payment a=new Reports_Logo_Payment();
			a.Open_Logo_Payment_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Logo_Payment_Report_Verify_Logo_Payment_Verify_PaymentType_BusinessDay(driver);
			a.Logo_Payment_Report_Today(driver);
			a.Logo_Payment_Report_Yesterday(driver);
			a.Logo_Payment_Report_Last_N_Days(driver);
			a.Logo_Payment_Report_This_Week(driver);
			a.Logo_Payment_Report_Last_Week(driver);
			a.Logo_Payment_Report_Last_7_Days(driver);
			a.Logo_Payment_Report_This_Month(driver);
			a.Logo_Payment_Report_Last_Month(driver);
			a.Logo_Payment_Report_Last_30_Days(driver);
			a.Logo_Payment_Report_Specific_Date(driver);
			a.Logo_Payment_Report_Date_Range(driver);
				
		}
		
		@Test(priority = 16,enabled = true)
		public void Reports_Online_Sales_Report() throws Exception
		{
			Reports_Online_Sales_Report a=new Reports_Online_Sales_Report();
			a.Open_OnlineSales_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.OnlineSales_Report_Today(driver);
			a.OnlineSales_Report_Yesterday(driver);
			a.OnlineSales_Report_Last_N_Days(driver);
			a.OnlineSales_Report_This_Week(driver);
			a.OnlineSales_Report_Last_Week(driver);
			a.OnlineSales_Report_Last_7_Days(driver);
			a.OnlineSales_Report_This_Month(driver);
			a.OnlineSales_Report_Last_Month(driver);
			a.OnlineSales_Report_Last_30_Days(driver);
			a.OnlineSales_Report_Specific_Date(driver);
			a.OnlineSales_Report_Date_Range(driver);
				
		}
		
		
		
		@Test(priority = 17,enabled = true)
		public void Reports_Transactions_Report() throws Exception
		{
			Reports_Transactions_Report a=new Reports_Transactions_Report();
			a.Open_Transactions_Report_Page(driver);
//			a.RefreshAndPaginination(driver);	
			a.Transactions_Report_Today_PaymentName(driver);
			a.Transactions_Report_Yesterday_PaymentName(driver);
			a.Transactions_Report_Last_N_Days_PaymentName(driver);
			a.Transactions_Report_This_Week_PaymentName(driver);
			a.Transactions_Report_Last_Week_PaymentName(driver);
			a.Transactions_Report_Last_7_Days_PaymentName(driver);
			a.Transactions_Report_This_Month_PaymentName(driver);
			a.Transactions_Report_Last_Month_PaymentName(driver);
			a.Transactions_Report_Last_30_Days_PaymentName(driver);
			a.Transactions_Report_Specific_Date_PaymentName(driver);
			a.Transactions_Report_Date_Range_PaymentName(driver);
			 Thread.sleep(1000);
			 a.Transactions_Report_Today_PaymentType(driver);
			 a.Transactions_Report_Yesterday_PaymentType(driver);
			 a.Transactions_Report_Last_N_Days_PaymentType(driver);
			 a.Transactions_Report_This_Week_PaymentType(driver);
			 a.Transactions_Report_Last_Week_PaymentType(driver);
			 a.Transactions_Report_Last_7_Days_PaymentType(driver);
			 a.Transactions_Report_This_Month_PaymentType(driver);
			 a.Transactions_Report_Last_Month_PaymentType(driver);
			 a.Transactions_Report_Last_30_Days_PaymentType(driver);
			 a.Transactions_Report_Specific_Date_PaymentType(driver);
			 a.Transactions_Report_Date_Range_PaymentType(driver);
			
		}
		
		
		
		@Test(priority = 18,enabled = true)
		public void Reports_Void_Transactions_Report() throws Exception
		{
			Reports_Void_Transactions_Report a=new Reports_Void_Transactions_Report();
			a.Open_Void_Transactions_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Void_Transactions_Report_Today_PaymentName(driver);
			a.Void_Transactions_Report_Yesterday_PaymentName(driver);
			a.Void_Transactions_Report_Last_N_Days_PaymentName(driver);
			a.Void_Transactions_Report_This_Week_PaymentName(driver);
			a.Void_Transactions_Report_Last_Week_PaymentName(driver);
			a.Void_Transactions_Report_Last_7_Days_PaymentName(driver);
			a.Void_Transactions_Report_This_Month_PaymentName(driver);
			a.Void_Transactions_Report_Last_Month_PaymentName(driver);
			a.Void_Transactions_Report_Last_30_Days_PaymentName(driver);
			a.Void_Transactions_Report_Specific_Date_PaymentName(driver);
			a.Void_Transactions_Report_Date_Range_PaymentName(driver);
			a.Void_Transactions_Report_Today_PaymentType(driver);
			a.Void_Transactions_Report_Yesterday_PaymentType(driver);
			a.Void_Transactions_Report_Last_N_Days_PaymentType(driver);
			a.Void_Transactions_Report_This_Week_PaymentType(driver);
			a.Void_Transactions_Report_Last_Week_PaymentType(driver);
			a.Void_Transactions_Report_Last_7_Days_PaymentType(driver);
			a.Void_Transactions_Report_This_Month_PaymentType(driver);
			a.Void_Transactions_Report_Last_Month_PaymentType(driver);
			a.Void_Transactions_Report_Last_30_Days_PaymentType(driver);
			a.Void_Transactions_Report_Specific_Date_PaymentType(driver);
			a.Void_Transactions_Report_Date_Range_PaymentType(driver);
		}
		
		@Test(priority = 19,enabled = true)
		public void Reports_Gift_Card_Report() throws Exception
		{
		
			Reports_Gift_Card_Report a=new Reports_Gift_Card_Report();
			a.Open_Gift_Card_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Gift_Card_Report_Verify_Card_Search(driver);
			a.Gift_Card_Report_Today(driver);
			a.Gift_Card_Report_Yesterday(driver);
			a.Gift_Card_Report_Last_N_Days(driver);
			a.Gift_Card_Report_This_Week(driver);
			a.Gift_Card_Report_Last_Week(driver);
			a.Gift_Card_Report_Last_7_Days(driver);
			a.Gift_Card_Report_This_Month(driver);
			a.Gift_Card_Report_Last_Month(driver);
			a.Gift_Card_Report_Last_30_Days(driver);
			a.Gift_Card_Report_Specific_Date(driver);
			a.Gift_Card_Report_Date_Range(driver);
		}
		
		@Test(priority = 20,enabled = true)
		public void Reports_GiveX_Report() throws Exception
		{
			Reports_GiveX_Report a=new Reports_GiveX_Report();
			a.Open_GiveX_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.GiveX_Report_Verify_Card_Search(driver);
			a.GiveX_Report_Today(driver);
			a.GiveX_Report_Yesterday(driver);
			a.GiveX_Report_Last_N_Days(driver);
			a.GiveX_Report_This_Week(driver);
			a.GiveX_Report_Last_Week(driver);
			a.GiveX_Report_Last_7_Days(driver);
			a.GiveX_Report_This_Month(driver);
			a.GiveX_Report_Last_Month(driver);
			a.GiveX_Report_Last_30_Days(driver);
			a.GiveX_Report_Specific_Date(driver);
			a.GiveX_Report_Date_Range(driver);
		}
		
		
		@Test(priority = 21,enabled = true)
		public void Reports_Discount_Report() throws Exception
		{
			Reports_Discount_Report a=new Reports_Discount_Report();
			a.Open_Discount_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Discount_Report_Today(driver);
			a.Discount_Report_Yesterday(driver);
			a.Discount_Report_Last_N_Days(driver);
			a.Discount_Report_This_Week(driver);
			a.Discount_Report_Last_Week(driver);
			a.Discount_Report_Last_7_Days(driver);
			a.Discount_Report_This_Month(driver);
			a.Discount_Report_Last_Month(driver);
			a.Discount_Report_Last_30_Days(driver);
			a.Discount_Report_Specific_Date(driver);
			a.Discount_Report_Date_Range(driver);
		}
		
		
		@Test(priority = 22,enabled = false)
		public void Reports_Store_Credit_Report() throws Exception
		{
			// Not Impletemented
		}
		
		
		
		@Test(priority = 23,enabled = true)
		public void Reports_Void_Node_Report() throws Exception
		{
			Reports_Void_Node_Report a=new Reports_Void_Node_Report();
			a.Open_Void_Node_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Void_Node_Report_Verify_Void_Node_Search(driver);
			a.Void_Node_Report_Today(driver);
			a.Void_Node_Report_Yesterday(driver);
			a.Void_Node_Report_Last_N_Days(driver);
			a.Void_Node_Report_This_Week(driver);
			a.Void_Node_Report_Last_Week(driver);
			a.Void_Node_Report_Last_7_Days(driver);
			a.Void_Node_Report_This_Month(driver);
			a.Void_Node_Report_Last_Month(driver);
			a.Void_Node_Report_Last_30_Days(driver);
			a.Void_Node_Report_Specific_Date(driver);
			a.Void_Node_Report_Date_Range(driver);
		}
		
		
		@Test(priority = 24,enabled = true)
		public void Reports_Void_Employee_Report() throws Exception
		{
			Reports_Void_Employee_Report a=new Reports_Void_Employee_Report();
			a.Open_Void_Employee_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Void_Employee_Report_Verify_Void_Employee_Search(driver);
			a.Void_Employee_Report_Today(driver);
			a.Void_Employee_Report_Yesterday(driver);
			a.Void_Employee_Report_Last_N_Days(driver);
			a.Void_Employee_Report_This_Week(driver);
			a.Void_Employee_Report_Last_Week(driver);
			a.Void_Employee_Report_Last_7_Days(driver);
			a.Void_Employee_Report_This_Month(driver);
			a.Void_Employee_Report_Last_Month(driver);
			a.Void_Employee_Report_Last_30_Days(driver);
			a.Void_Employee_Report_Specific_Date(driver);
			a.Void_Employee_Report_Date_Range(driver);
		}
		
		@Test(priority = 25,enabled = true)
		public void Reports_Paid_In_Paid_Out_Report() throws Exception
		{
			Reports_Paid_In_Paid_Out_Report a=new Reports_Paid_In_Paid_Out_Report();
			a.Open_Paid_In_Paid_Out_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Paid_In_Paid_Out_Report_Verify_Paid_In_Paid_Out_Search(driver);
			a.Paid_In_Paid_Out_Report_Today(driver);
			a.Paid_In_Paid_Out_Report_Yesterday(driver);
			a.Paid_In_Paid_Out_Report_Last_N_Days(driver);
			a.Paid_In_Paid_Out_Report_This_Week(driver);
			a.Paid_In_Paid_Out_Report_Last_Week(driver);
			a.Paid_In_Paid_Out_Report_Last_7_Days(driver);
			a.Paid_In_Paid_Out_Report_This_Month(driver);
			a.Paid_In_Paid_Out_Report_Last_Month(driver);
			a.Paid_In_Paid_Out_Report_Last_30_Days(driver);
			a.Paid_In_Paid_Out_Report_Specific_Date(driver);
			a.Paid_In_Paid_Out_Report_Date_Range(driver);
		}
		
		@Test(priority = 26,enabled = true)
		public void Reports_Audit_Log() throws Exception
		{
			Reports_Audit_Log a=new Reports_Audit_Log();
			a.Open_Audit_Log_Page(driver);
//			a.RefreshAndPaginination(driver);
			
			a.Audit_Log_Today_PaymentName(driver);
			a.Audit_Log_Yesterday_PaymentName(driver);
			a.Audit_Log_Last_N_Days_PaymentName(driver);
			a.Audit_Log_This_Week_PaymentName(driver);
			a.Audit_Log_Last_Week_PaymentName(driver);
			a.Audit_Log_Last_7_Days_PaymentName(driver);
			a.Audit_Log_This_Month_PaymentName(driver);
			a.Audit_Log_Last_Month_PaymentName(driver);
			a.Audit_Log_Last_30_Days_PaymentName(driver);
			a.Audit_Log_Specific_Date_PaymentName(driver);
			a.Audit_Log_Date_Range_PaymentName(driver);
			 Thread.sleep(1000);
			 a.Audit_Log_Today_PaymentType(driver);
			 a.Audit_Log_Yesterday_PaymentType(driver);
			 a.Audit_Log_Last_N_Days_PaymentType(driver);
			 a.Audit_Log_This_Week_PaymentType(driver);
			 a.Audit_Log_Last_Week_PaymentType(driver);
			 a.Audit_Log_Last_7_Days_PaymentType(driver);
			a.Audit_Log_This_Month_PaymentType(driver);
			a.Audit_Log_Last_Month_PaymentType(driver);
			a.Audit_Log_Last_30_Days_PaymentType(driver);
			a.Audit_Log_Specific_Date_PaymentType(driver);
			a.Audit_Log_Date_Range_PaymentType(driver);
		}
		
		@Test(priority = 27,enabled = true)
		public void Reports_Employee_Attendance_Report() throws Exception
		{
			Reports_Employee_Attendance_Report a=new Reports_Employee_Attendance_Report();
			a.Open_Employee_Attendance_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Employee_Attendance_Report_Verify_Employee_Attendance_Search(driver);
			a.Employee_Attendance_Report_Today(driver);
			a.Employee_Attendance_Report_Yesterday(driver);
			a.Employee_Attendance_Report_Last_N_Days(driver);
			a.Employee_Attendance_Report_This_Week(driver);
			a.Employee_Attendance_Report_Last_Week(driver);
			a.Employee_Attendance_Report_Last_7_Days(driver);
			a.Employee_Attendance_Report_This_Month(driver);
			a.Employee_Attendance_Report_Last_Month(driver);
			a.Employee_Attendance_Report_Last_30_Days(driver);
			a.Employee_Attendance_Report_Specific_Date(driver);
			a.Employee_Attendance_Report_Date_Range(driver);
		}
		
		@Test(priority = 28,enabled = true)
		public void Reports_Employee_Role_Based_Payroll_Report() throws Exception
		{
			Reports_Employee_Role_Based_Payroll_Report a=new Reports_Employee_Role_Based_Payroll_Report();
			a.Employee_Role_Based_Payroll_Report_Method_Page_Open(driver);
//			a.RefreshAndPaginination(driver);
			a.Employee_Role_Based_Payroll_Report_Verify_Role_Based_Payroll_Search(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Today(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Today(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Yesterday(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Yesterday(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_N_Days(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_N_Days(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_This_Week(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_This_Week(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_Week(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_Week(driver); 
			a.Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_7_days(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_7_days(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_This_Month(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_This_Month(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_Month(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_Month(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_30_days(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_30_days(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Specific_Date(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Specific_Date(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Hours_Date_Range(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range(driver);
			a.Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Hours_Date_Range(driver);
			
		}
		
		@Test(priority = 29,enabled = true)
		public void Reports_Employee_Labor_Report() throws Exception
		{
			Reports_Employee_Labor_Report a=new Reports_Employee_Labor_Report();
			a.Open_Labor_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Labor_Report_Process_As_Daily_Weekly_In_Hours(driver);
			a.Labor_Report_Process_As_Daily_Weekly_In_Time(driver);
			a.Labor_Report_Today_Process_As_Daily(driver);
			a.Labor_Report_Yesterday_Process_As_Daily(driver);
			a.Labor_Report_Last_N_Days_Process_As_Daily(driver);
			a.Labor_Report_This_Week_Process_As_Daily(driver);
			a.Labor_Report_Last_Week_Process_As_Daily(driver);
			a.Labor_Report_Last_7_Days_Process_As_Daily(driver);
			a.Labor_Report_This_Month_Process_As_Daily(driver);
			a.Labor_Report_Last_Month_Process_As_Daily(driver);
			a.Labor_Report_Last_30_Days_Process_As_Daily(driver);
			a.Labor_Report_Specific_Date_Process_As_Daily(driver);
			a.Labor_Report_Date_Range_Process_As_Daily(driver);
			 Thread.sleep(1000);
			 a.Labor_Report_Today_Process_As_Weekly(driver);
			 a.Labor_Report_Yesterday_Process_As_Weekly(driver);
			 a.Labor_Report_Last_N_Days_Process_As_Weekly(driver);
			 a.Labor_Report_This_Week_Process_As_Weekly(driver);
			 a.Labor_Report_Last_Week_Process_As_Weekly(driver);
			 a.Labor_Report_Last_7_Days_Process_As_Weekly(driver);
			a.Labor_Report_This_Month_Process_As_Weekly(driver);
			a.Labor_Report_Last_Month_Process_As_Weekly(driver);
			a.Labor_Report_Last_30_Days_Process_As_Weekly(driver);
			a.Labor_Report_Specific_Date_Process_As_Weekly(driver);
			a.Labor_Report_Date_Range_Process_As_Weekly(driver);
		}
		
		@Test(priority = 30,enabled = true)
		public void Reports_Employee_Labor_By_Job_Code_Report() throws Exception
		{
			Reports_Employee_Labor_By_Job_Code_Report a=new Reports_Employee_Labor_By_Job_Code_Report();
			a.Open_Labor_By_Job_Code_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Labor_By_Job_Code_Report_Process_As_Daily_Weekly_In_Hours(driver);
			a.Labor_By_Job_Code_Report_Process_As_Daily_Weekly_In_Time(driver);
			a.Labor_By_Job_Code_Report_Today_Process_As_Daily(driver);
			a.Labor_By_Job_Code_Report_Yesterday_Process_As_Daily(driver);
			a.Labor_By_Job_Code_Report_Last_N_Days_Process_As_Daily(driver);
			a.Labor_By_Job_Code_Report_This_Week_Process_As_Daily(driver);
			a.Labor_By_Job_Code_Report_Last_Week_Process_As_Daily(driver);
			a.Labor_By_Job_Code_Report_Last_7_Days_Process_As_Daily(driver);
			a.Labor_By_Job_Code_Report_This_Month_Process_As_Daily(driver);
			a.Labor_By_Job_Code_Report_Last_Month_Process_As_Daily(driver);
			a.Labor_By_Job_Code_Report_Last_30_Days_Process_As_Daily(driver);
			a.Labor_By_Job_Code_Report_Specific_Date_Process_As_Daily(driver);
			a.Labor_By_Job_Code_Report_Date_Range_Process_As_Daily(driver);
			 Thread.sleep(1000);
			 a.Labor_By_Job_Code_Report_Today_Process_As_Weekly(driver);
			 a.Labor_By_Job_Code_Report_Yesterday_Process_As_Weekly(driver);
			 a.Labor_By_Job_Code_Report_Last_N_Days_Process_As_Weekly(driver);
			 a.Labor_By_Job_Code_Report_This_Week_Process_As_Weekly(driver);
			 a.Labor_By_Job_Code_Report_Last_Week_Process_As_Weekly(driver);
			 a.Labor_By_Job_Code_Report_Last_7_Days_Process_As_Weekly(driver);
			 a.Labor_By_Job_Code_Report_This_Month_Process_As_Weekly(driver);
			 a.Labor_By_Job_Code_Report_Last_Month_Process_As_Weekly(driver);
			 a.Labor_By_Job_Code_Report_Last_30_Days_Process_As_Weekly(driver);
			 a.Labor_By_Job_Code_Report_Specific_Date_Process_As_Weekly(driver);
			 a.Labor_By_Job_Code_Report_Date_Range_Process_As_Weekly(driver);
		}
		
		@Test(priority = 31,enabled = true)
		public void Reports_Employee_Gratuity_Report() throws Exception
		{
			Reports_Employee_Gratuity_Report a=new Reports_Employee_Gratuity_Report();
			a.Open_Employee_Gratuity_Report_Page(driver);
//						a.RefreshAndPaginination(driver);
			a.Employee_Gratuity_Report_Verify_Employee_Gratuity_Search(driver);
			a.Employee_Gratuity_Report_Today(driver);
			a.Employee_Gratuity_Report_Yesterday(driver);
			a.Employee_Gratuity_Report_Last_N_Days(driver);
			a.Employee_Gratuity_Report_This_Week(driver);
			a.Employee_Gratuity_Report_Last_Week(driver);
			a.Employee_Gratuity_Report_Last_7_Days(driver);
			a.Employee_Gratuity_Report_This_Month(driver);
			a.Employee_Gratuity_Report_Last_Month(driver);
			a.Employee_Gratuity_Report_Last_30_Days(driver);
			a.Employee_Gratuity_Report_Specific_Date(driver);
			a.Employee_Gratuity_Report_Date_Range(driver);
		}
		

		@Test(priority = 32,enabled = true)
		public void Reports_Employee_CashTip() throws Exception
		{
			Reports_Employee_CashTip a=new Reports_Employee_CashTip();
			a.Open_Employee_CashTip_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Employee_CashTip_Report_Today_All(driver);
			a.Employee_CashTip_Report_Yesterday_All(driver);
			a.Employee_CashTip_Report_Last_N_Days_All(driver);
			a.Employee_CashTip_Report_This_Week_All(driver);
			a.Employee_CashTip_Report_Last_Week_All(driver);
			a.Employee_CashTip_Report_Last_7_Days_All(driver);
			a.Employee_CashTip_Report_This_Month_All(driver);
			a.Employee_CashTip_Report_Last_Month_All(driver);
			a.Employee_CashTip_Report_Last_30_Days_All(driver);
			a.Employee_CashTip_Report_Specific_Date_All(driver);
			a.Employee_CashTip_Report_Date_Range_All(driver);
			a.Employee_CashTip_Report_Today_Active(driver);
			a.Employee_CashTip_Report_Yesterday_Active(driver);
			a.Employee_CashTip_Report_Last_N_Days_Active(driver);
			a.Employee_CashTip_Report_This_Week_Active(driver);
			a.Employee_CashTip_Report_Last_Week_Active(driver);
			a.Employee_CashTip_Report_Last_7_Days_Active(driver);
			a.Employee_CashTip_Report_This_Month_Active(driver);
			a.Employee_CashTip_Report_Last_Month_Active(driver);
			a.Employee_CashTip_Report_Last_30_Days_Active(driver);
			a.Employee_CashTip_Report_Specific_Date_Active(driver);
			a.Employee_CashTip_Report_Date_Range_Active(driver);
			a.Employee_CashTip_Report_Today_Inactive(driver);
			a.Employee_CashTip_Report_Yesterday_Inactive(driver);
			a.Employee_CashTip_Report_Last_N_Days_Inactive(driver);
			a.Employee_CashTip_Report_This_Week_Inactive(driver);
			a.Employee_CashTip_Report_Last_Week_Inactive(driver);
			a.Employee_CashTip_Report_Last_7_Days_Inactive(driver);
			a.Employee_CashTip_Report_This_Month_Inactive(driver);
			a.Employee_CashTip_Report_Last_Month_Inactive(driver);
			a.Employee_CashTip_Report_Last_30_Days_Inactive(driver);
			a.Employee_CashTip_Report_Specific_Date_Inactive(driver);
			a.Employee_CashTip_Report_Date_Range_Inactive(driver);

		}
		
		@Test(priority = 36,enabled = true)
		public void Reports_HA_Activity_Report() throws Exception
		{
			Reports_HA_Activity_Report a=new Reports_HA_Activity_Report();
			a.Open_HA_Activity_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.HA_Activity_Report_Verify_Card_Search(driver);
			a.HA_Activity_Report_Today(driver);
			a.HA_Activity_Report_Yesterday(driver);
			a.HA_Activity_Report_Last_N_Days(driver);
			a.HA_Activity_Report_This_Week(driver);
			a.HA_Activity_Report_Last_Week(driver);
			a.HA_Activity_Report_Last_7_Days(driver);
			a.HA_Activity_Report_This_Month(driver);
			a.HA_Activity_Report_Last_Month(driver);
			a.HA_Activity_Report_Last_30_Days(driver);
			a.HA_Activity_Report_Specific_Date(driver);
			a.HA_Activity_Report_Date_Range(driver);
		}
		

		@Test(priority = 37,enabled = true)
		public void Reports_HA_Statement() throws Exception
		{
			Reports_HA_Statement a=new Reports_HA_Statement();
			a.Open_HA_Statement_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.HA_Statement_Today(driver);
			a.HA_Statement_Yesterday(driver);
			a.HA_Statement_Last_N_Days(driver);
			a.HA_Statement_This_Week(driver);
			a.HA_Statement_Last_Week(driver);
			a.HA_Statement_Last_7_Days(driver);
			a.HA_Statement_This_Month(driver);
			a.HA_Statement_Last_Month(driver);
			a.HA_Statement_Last_30_Days(driver);
			a.HA_Statement_Specific_Date(driver);
			a.HA_Statement_Date_Range(driver);
		}
		
		@Test(priority = 38,enabled = true)
		public void Reports_Driver_Report() throws Exception
		{
			Reports_Driver_Report a=new Reports_Driver_Report();
			a.Open_Driver_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Driver_Report_Verify_Driver_Search(driver);
			a.Driver_Report_Today(driver);
			a.Driver_Report_Yesterday(driver);
			a.Driver_Report_Last_N_Days(driver);
			a.Driver_Report_This_Week(driver);
			a.Driver_Report_Last_Week(driver);
			a.Driver_Report_Last_7_Days(driver);
			a.Driver_Report_This_Month(driver);
			a.Driver_Report_Last_Month(driver);
			a.Driver_Report_Last_30_Days(driver);
			a.Driver_Report_Specific_Date(driver);
			a.Driver_Report_Date_Range(driver);
		}
		
		@Test(priority = 39,enabled = true)
		public void Reports_Batch_Report() throws Exception
		{
			Reports_Batch_Report a=new Reports_Batch_Report();
			a.Open_Batch_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Batch_Report_Verify_Batch_Search(driver);
			a.Batch_Report_Today(driver);
			a.Batch_Report_Yesterday(driver);
			a.Batch_Report_Last_N_Days(driver);
			a.Batch_Report_This_Week(driver);
			a.Batch_Report_Last_Week(driver);
			a.Batch_Report_Last_7_Days(driver);
			a.Batch_Report_This_Month(driver);
			a.Batch_Report_Last_Month(driver);
			a.Batch_Report_Last_30_Days(driver);
			a.Batch_Report_Specific_Date(driver);
			a.Batch_Report_Date_Range(driver);
		}
		
		@Test(priority = 40,enabled = true)
		public void Reports_Refund_Report() throws Exception
		{
			Reports_Refund_Report a=new Reports_Refund_Report();
			a.Open_Refund_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Refund_Report_Today_PaymentName(driver);
			a.Refund_Report_Yesterday_PaymentName(driver);
			a.Refund_Report_Last_N_Days_PaymentName(driver);
			a.Refund_Report_This_Week_PaymentName(driver);
			a.Refund_Report_Last_Week_PaymentName(driver);
			a.Refund_Report_Last_7_Days_PaymentName(driver);
			a.Refund_Report_This_Month_PaymentName(driver);
			a.Refund_Report_Last_Month_PaymentName(driver);
			a.Refund_Report_Last_30_Days_PaymentName(driver);
			a.Refund_Report_Specific_Date_PaymentName(driver);
			a.Refund_Report_Date_Range_PaymentName(driver);
			a.Refund_Report_Today_PaymentType(driver);
			a.Refund_Report_Yesterday_PaymentType(driver);
			a.Refund_Report_Last_N_Days_PaymentType(driver);
			a.Refund_Report_This_Week_PaymentType(driver);
			a.Refund_Report_Last_Week_PaymentType(driver);
			a.Refund_Report_Last_7_Days_PaymentType(driver);
			a.Refund_Report_This_Month_PaymentType(driver);
			a.Refund_Report_Last_Month_PaymentType(driver);
			a.Refund_Report_Last_30_Days_PaymentType(driver);
			a.Refund_Report_Specific_Date_PaymentType(driver);
			a.Refund_Report_Date_Range_PaymentType(driver);
		}
		
		@Test(priority = 41,enabled = true)
		public void Reports_Till_Report() throws Exception
		{
			Reports_Till_Report a=new Reports_Till_Report();
			a.Open_Till_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Till_Report_Verify_Till_Search(driver);
			a.Till_Report_Today(driver);
			a.Till_Report_Yesterday(driver);
			a.Till_Report_Last_N_Days(driver);
			a.Till_Report_This_Week(driver);
			a.Till_Report_Last_Week(driver);
			a.Till_Report_Last_7_Days(driver);
			a.Till_Report_This_Month(driver);
			a.Till_Report_Last_Month(driver);
			a.Till_Report_Last_30_Days(driver);
			a.Till_Report_Specific_Date(driver);
			a.Till_Report_Date_Range(driver);
		}
		
		@Test(priority = 42,enabled = true)
		public void Reports_Cash_Transaction_Report() throws Exception
		{
			Reports_Cash_Transaction_Report a=new Reports_Cash_Transaction_Report();
			a.Open_Cash_Transaction_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Cash_Transaction_Report_Verify_Cash_Transaction_Search(driver);
			a.Cash_Transaction_Report_Today(driver);
			a.Cash_Transaction_Report_Yesterday(driver);
			a.Cash_Transaction_Report_Last_N_Days(driver);
			a.Cash_Transaction_Report_This_Week(driver);
			a.Cash_Transaction_Report_Last_Week(driver);
			a.Cash_Transaction_Report_Last_7_Days(driver);
			a.Cash_Transaction_Report_This_Month(driver);
			a.Cash_Transaction_Report_Last_Month(driver);
			a.Cash_Transaction_Report_Last_30_Days(driver);
			a.Cash_Transaction_Report_Specific_Date(driver);
			a.Cash_Transaction_Report_Date_Range(driver);
		}
		
		@Test(priority = 43,enabled = false)
		public void Reports_Comparison_Report() throws Exception
		{
			
		}
		
		@Test(priority = 44,enabled = true)
		public void Reports_Customer_Preference_Report() throws Exception
		{
			Reports_Customer_Preference_Report a=new Reports_Customer_Preference_Report();
			a.Open_Customer_Preference_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Customer_Preference_Report_Today(driver);
			a.Customer_Preference_Report_Yesterday(driver);
			a.Customer_Preference_Report_Last_N_Days(driver);
			a.Customer_Preference_Report_This_Week(driver);
			a.Customer_Preference_Report_Last_Week(driver);
			a.Customer_Preference_Report_Last_7_Days(driver);
			a.Customer_Preference_Report_This_Month(driver);
			a.Customer_Preference_Report_Last_Month(driver);
			a.Customer_Preference_Report_Last_30_Days(driver);
			a.Customer_Preference_Report_Specific_Date(driver);
			a.Customer_Preference_Report_Date_Range(driver);
		}
		
		@Test(priority = 45,enabled = true)
		public void Reports_Daily_Tender_Report() throws Exception
		{
			Reports_Daily_Tender_Report a=new Reports_Daily_Tender_Report();
			a.Open_Daily_Tender_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Daily_Tender_Report_Today(driver);
			a.Daily_Tender_Report_Yesterday(driver);
			a.Daily_Tender_Report_Last_N_Days(driver);
			a.Daily_Tender_Report_This_Week(driver);
			a.Daily_Tender_Report_Last_Week(driver);
			a.Daily_Tender_Report_Last_7_Days(driver);
			a.Daily_Tender_Report_This_Month(driver);
			a.Daily_Tender_Report_Last_Month(driver);
			a.Daily_Tender_Report_Last_30_Days(driver);
			a.Daily_Tender_Report_Specific_Date(driver);
			a.Daily_Tender_Report_Date_Range(driver);
		}
		
		@Test(priority = 46,enabled = true)
		public void Reports_Daily_Summary_Report() throws Exception
		{
			Reports_Daily_Summary_Report a=new Reports_Daily_Summary_Report();
			a.Open_Daily_Summary_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Daily_Summary_Report_Verify_Daily_Summary_Search(driver);
			a.Daily_Summary_Report_Today(driver);
			a.Daily_Summary_Report_Yesterday(driver);
			a.Daily_Summary_Report_Last_N_Days(driver);
			a.Daily_Summary_Report_This_Week(driver);
			a.Daily_Summary_Report_Last_Week(driver);
			a.Daily_Summary_Report_Last_7_Days(driver);
			a.Daily_Summary_Report_This_Month(driver);
			a.Daily_Summary_Report_Last_Month(driver);
			a.Daily_Summary_Report_Last_30_Days(driver);
			a.Daily_Summary_Report_Specific_Date(driver);
			a.Daily_Summary_Report_Date_Range(driver);
		}
		
		@Test(priority = 47,enabled = true)
		public void Reports_Tax_Report() throws Exception
		{
			Reports_Tax_Report a=new Reports_Tax_Report();
			a.Open_Tax_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Tax_Report_Verify_Tax_Search(driver);
			a.Tax_Report_Today(driver);
			a.Tax_Report_Yesterday(driver);
			a.Tax_Report_Last_N_Days(driver);
			a.Tax_Report_This_Week(driver);
			a.Tax_Report_Last_Week(driver);
			a.Tax_Report_Last_7_Days(driver);
			a.Tax_Report_This_Month(driver);
			a.Tax_Report_Last_Month(driver);
			a.Tax_Report_Last_30_Days(driver);
			a.Tax_Report_Specific_Date(driver);
			a.Tax_Report_Date_Range(driver);
		}
		
		@Test(priority = 48,enabled = true)
		public void Reports_Revenue_Center() throws Exception
		{
			Reports_Revenue_Center a=new Reports_Revenue_Center();
			a.Open_Revenue_Center_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Revenue_Center_Report_Verify_Revenue_Center_Search(driver);
			a.Revenue_Center_Report_Today(driver);
			a.Revenue_Center_Report_Yesterday(driver);
			a.Revenue_Center_Report_Last_N_Days(driver);
			a.Revenue_Center_Report_This_Week(driver);
			a.Revenue_Center_Report_Last_Week(driver);
			a.Revenue_Center_Report_Last_7_Days(driver);
			a.Revenue_Center_Report_This_Month(driver);
			a.Revenue_Center_Report_Last_Month(driver);
			a.Revenue_Center_Report_Last_30_Days(driver);
			a.Revenue_Center_Report_Specific_Date(driver);
			a.Revenue_Center_Report_Date_Range(driver);
		}
		
		@Test(priority = 49,enabled = true)
		public void Reports_Account_Balance_Report() throws Exception
		{
			Reports_Account_Balance_Report a=new Reports_Account_Balance_Report();
			a.Open_AccountBalance_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.AccountBalance_Sale_Report(driver);
		}
		
		@Test(priority = 50,enabled = true)
		public void Reports_Membership_Summary_Report() throws Exception
		{
			Reports_Membership_Summary_Report a=new Reports_Membership_Summary_Report();
			a.Open_Membership_Summary_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Membership_Summary_Sale_Report(driver);
		}
		
		@Test(priority = 51,enabled = true)
		public void Reports_Membership_Statement() throws Exception
		{
			Reports_Membership_Statement a=new Reports_Membership_Statement();
			a.Open_Membership_Statement_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Membership_Statement_Report_Verify_Membership_Statement_Search(driver);
			a.Membership_Statement_Report_Today(driver);
			a.Membership_Statement_Report_Yesterday(driver);
			a.Membership_Statement_Report_Last_N_Days(driver);
			a.Membership_Statement_Report_This_Week(driver);
			a.Membership_Statement_Report_Last_Week(driver);
			a.Membership_Statement_Report_Last_7_Days(driver);
			a.Membership_Statement_Report_This_Month(driver);
			a.Membership_Statement_Report_Last_Month(driver);
			a.Membership_Statement_Report_Last_30_Days(driver);
			a.Membership_Statement_Report_Specific_Date(driver);
			a.Membership_Statement_Report_Date_Range(driver);
		}
}
