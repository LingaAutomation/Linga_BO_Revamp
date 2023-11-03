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
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AllClassCalling_Enterprise_Reports 
{
public SelfHealingDriver driver;
	

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Retesting Suite for Enterprise Reports");

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
				String scnsht=((TakesScreenshot)driver.getDelegate()).getScreenshotAs(OutputType.BASE64);
				
				String s="data:image/png;base64,"+scnsht;
				
				test.log(LogStatus.FAIL, test.addScreenCapture(s));
				
				Thread.sleep(1000);
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
//			
//			System.setProperty("webdriver.chrome.driver","./Automation Driver/chromedriver.exe");
//			//Open the Chrome window
//			driver = new ChromeDriver();

//			ChromeOptions chrOpt=new ChromeOptions();
//			chrOpt.addArguments("--remote-allow-origins=*");
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver(chrOpt);
			
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
		
		@AfterTest
		public void LogOut() throws Exception
		{
			a.LogOut(driver, test);
		}

		@Test(priority = 2,enabled = true)
		public void Enterprise_Reports() throws Exception
		{
			Enterprise_Reports a=new Enterprise_Reports();
			a.Open_Enterprise_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Enterprise_Report_Today(driver);
			a.Enterprise_Report_Yesterday(driver);
			a.Enterprise_Report_Last_N_Days(driver);
			a.Enterprise_Report_This_Week(driver);
			a.Enterprise_Report_Last_Week(driver);
			a.Enterprise_Report_Last_7_Days(driver);
			a.Enterprise_Report_This_Month(driver);
			a.Enterprise_Report_Last_Month(driver);
			a.Enterprise_Report_Last_30_Days(driver);
			a.Enterprise_Report_Specific_Date(driver);
			a.Enterprise_Report_Date_Range(driver);
		}
		
		@Test(priority = 3,enabled = true)
		public void Enterprise_Reports_Sale_Recap_Report() throws Exception
		{
			Enterprise_Reports_Sale_Recap_Report a=new Enterprise_Reports_Sale_Recap_Report();
			a.Open_Enterprise_Sale_Recap_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Enterprise_Sale_Recap_Report_Today(driver);
			a.Enterprise_Sale_Recap_Report_Yesterday(driver);
			a.Enterprise_Sale_Recap_Report_Last_N_Days(driver);
			a.Enterprise_Sale_Recap_Report_This_Week(driver);
			a.Enterprise_Sale_Recap_Report_Last_Week(driver);
			a.Enterprise_Sale_Recap_Report_Last_7_Days(driver);
			a.Enterprise_Sale_Recap_Report_This_Month(driver);
			a.Enterprise_Sale_Recap_Report_Last_Month(driver);
			a.Enterprise_Sale_Recap_Report_Last_30_Days(driver);
			a.Enterprise_Sale_Recap_Report_Specific_Date(driver);
			a.Enterprise_Sale_Recap_Report_Date_Range(driver);
				
		}
		
		@Test(priority = 4,enabled = true)
		public void Enterprise_Reports_Department_Sale_Report() throws Exception
		{
			Enterprise_Reports_Department_Sale_Report a=new Enterprise_Reports_Department_Sale_Report();
			a.Open_Enterprise_Report_Department_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Enterprise_Report_Department_Report_Today(driver);
			a.Enterprise_Report_Department_Report_Yesterday(driver);
			a.Enterprise_Report_Department_Report_Last_N_Days(driver);
			a.Enterprise_Report_Department_Report_This_Week(driver);
			a.Enterprise_Report_Department_Report_Last_Week(driver);
			a.Enterprise_Report_Department_Report_Last_7_Days(driver);
			a.Enterprise_Report_Department_Report_This_Month(driver);
			a.Enterprise_Report_Department_Report_Last_Month(driver);
			a.Enterprise_Report_Department_Report_Last_30_Days(driver);
			a.Enterprise_Report_Department_Report_Specific_Date(driver);
			a.Enterprise_Report_Department_Report_Date_Range(driver);
		}
		
		
		@Test(priority = 5,enabled = true)
		public void Enterprise_Reports_Category_Sale_Report() throws Exception
		{
			Enterprise_Reports_Category_Sale_Report a=new Enterprise_Reports_Category_Sale_Report();
			a.Open_Enterprise_Report_Category_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Enterprise_Report_Category_Report_Today(driver);
			a.Enterprise_Report_Category_Report_Yesterday(driver);
			a.Enterprise_Report_Category_Report_Last_N_Days(driver);
			a.Enterprise_Report_Category_Report_This_Week(driver);
			a.Enterprise_Report_Category_Report_Last_Week(driver);
			a.Enterprise_Report_Category_Report_Last_7_Days(driver);
			a.Enterprise_Report_Category_Report_This_Month(driver);
			a.Enterprise_Report_Category_Report_Last_Month(driver);
			a.Enterprise_Report_Category_Report_Last_30_Days(driver);
			a.Enterprise_Report_Category_Report_Specific_Date(driver);
			a.Enterprise_Report_Category_Report_Date_Range(driver);
				
		}
	
		@Test(priority = 6,enabled = true)
		public void Enterprise_Reports_SubCategory_Sale_Report() throws Exception
		{
			Enterprise_Reports_SubCategory_Sale_Report a=new Enterprise_Reports_SubCategory_Sale_Report();
			a.Open_SubCategory_Enterprise_Report_Page(driver);
			//a.RefreshAndPaginination(driver);
			a.SubCategory_Enterprise_Report_Today(driver);
			a.SubCategory_Enterprise_Report_Yesterday(driver);
			a.SubCategory_Enterprise_Report_Last_N_Days(driver);
			a.SubCategory_Enterprise_Report_This_Week(driver);
			a.SubCategory_Enterprise_Report_Last_Week(driver);
			a.SubCategory_Enterprise_Report_Last_7_Days(driver);
			a.SubCategory_Enterprise_Report_This_Month(driver);
			a.SubCategory_Enterprise_Report_Last_Month(driver);
			a.SubCategory_Enterprise_Report_Last_30_Days(driver);
			a.SubCategory_Enterprise_Report_Specific_Date(driver);
			a.SubCategory_Enterprise_Report_Date_Range(driver);
		}
		
		@Test(priority = 7,enabled = true)
		public void Enterprise_Reports_Menu_Items_Report() throws Exception
		{
			Enterprise_Reports_Menu_Items_Report a=new Enterprise_Reports_Menu_Items_Report();
			a.Open_Enterprise_MenuItem_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Enterprise_MenuItem_Report_Today(driver);
			a.Enterprise_MenuItem_Report_Yesterday(driver);
			a.Enterprise_MenuItem_Report_Last_N_Days(driver);
			a.Enterprise_MenuItem_Report_This_Week(driver);
			a.Enterprise_MenuItem_Report_Last_Week(driver);
			a.Enterprise_MenuItem_Report_Last_7_Days(driver);
			a.Enterprise_MenuItem_Report_This_Month(driver);
			a.Enterprise_MenuItem_Report_Last_Month(driver);
			a.Enterprise_MenuItem_Report_Last_30_Days(driver);
			a.Enterprise_MenuItem_Report_Specific_Date(driver);
			a.Enterprise_MenuItem_Report_Date_Range(driver);
				
		}
		
		@Test(priority = 8,enabled = true)
		public void Enterprise_Reports_Modifier_Sale_Report() throws Exception
		{
			Enterprise_Reports_Modifier_Sale_Report a=new Enterprise_Reports_Modifier_Sale_Report();
			a.Open_Enterprise_Report_Modifier_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Enterprise_Report_Modifier_Report_Today(driver);
			a.Enterprise_Report_Modifier_Report_Yesterday(driver);
			a.Enterprise_Report_Modifier_Report_Last_N_Days(driver);
			a.Enterprise_Report_Modifier_Report_This_Week(driver);
			a.Enterprise_Report_Modifier_Report_Last_Week(driver);
			a.Enterprise_Report_Modifier_Report_Last_7_Days(driver);
			a.Enterprise_Report_Modifier_Report_This_Month(driver);
			a.Enterprise_Report_Modifier_Report_Last_Month(driver);
			a.Enterprise_Report_Modifier_Report_Last_30_Days(driver);
			a.Enterprise_Report_Modifier_Report_Specific_Date(driver);
			a.Enterprise_Report_Modifier_Report_Date_Range(driver);
				
		}
		
		@Test(priority = 9,enabled = true)
		public void Enterprise_Reports_Hourly_Sale_Report() throws Exception
		{
			Enterprise_Reports_Hourly_Sale_Report a=new Enterprise_Reports_Hourly_Sale_Report();
			a.Open_Enterprise_Hourly_Sale_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Enterprise_Hourly_Sale_Report_Today(driver);
			a.Enterprise_Hourly_Sale_Report_Yesterday(driver);
			a.Enterprise_Hourly_Sale_Report_Last_N_Days(driver);
			a.Enterprise_Hourly_Sale_Report_This_Week(driver);
			a.Enterprise_Hourly_Sale_Report_Last_Week(driver);
			a.Enterprise_Hourly_Sale_Report_Last_7_Days(driver);
			a.Enterprise_Hourly_Sale_Report_This_Month(driver);
			a.Enterprise_Hourly_Sale_Report_Last_Month(driver);
			a.Enterprise_Hourly_Sale_Report_Last_30_Days(driver);
			a.Enterprise_Hourly_Sale_Report_Specific_Date(driver);
			a.Enterprise_Hourly_Sale_Report_Date_Range(driver);
		}
		
		
		@Test(priority = 10,enabled = true)
		public void Enterprise_Reports_Daily_Sale_Report() throws Exception
		{
			Enterprise_Reports_Daily_Sale_Report a=new Enterprise_Reports_Daily_Sale_Report();
			a.Open_Enterprise_Daily_Sale_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Enterprise_Daily_Sale_Report_Today(driver);
			a.Enterprise_Daily_Sale_Report_Yesterday(driver);
			a.Enterprise_Daily_Sale_Report_Last_N_Days(driver);
			a.Enterprise_Daily_Sale_Report_This_Week(driver);
			a.Enterprise_Daily_Sale_Report_Last_Week(driver);
			a.Enterprise_Daily_Sale_Report_Last_7_Days(driver);
			a.Enterprise_Daily_Sale_Report_This_Month(driver);
			a.Enterprise_Daily_Sale_Report_Last_Month(driver);
			a.Enterprise_Daily_Sale_Report_Last_30_Days(driver);
			a.Enterprise_Daily_Sale_Report_Specific_Date(driver);
			a.Enterprise_Daily_Sale_Report_Date_Range(driver);
		}
		
		@Test(priority = 11,enabled = true)
		public void Enterprise_Reports_Cashier_Out_Report() throws Exception
		{
			Enterprise_Reports_Cashier_Out_Report a=new Enterprise_Reports_Cashier_Out_Report();
			a.Open_Enterprise_Cashier_Out_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Enterprise_Cashier_Out_Report_Today(driver);
			a.Enterprise_Cashier_Out_Report_Yesterday(driver);
			a.Enterprise_Cashier_Out_Report_Last_N_Days(driver);
			a.Enterprise_Cashier_Out_Report_This_Week(driver);
			a.Enterprise_Cashier_Out_Report_Last_Week(driver);
			a.Enterprise_Cashier_Out_Report_Last_7_Days(driver);
			a.Enterprise_Cashier_Out_Report_This_Month(driver);
			a.Enterprise_Cashier_Out_Report_Last_Month(driver);
			a.Enterprise_Cashier_Out_Report_Last_30_Days(driver);
			a.Enterprise_Cashier_Out_Report_Specific_Date(driver);
			a.Enterprise_Cashier_Out_Report_Date_Range(driver);
		}
		
		@Test(priority = 12,enabled = true)
		public void Enterprise_Reports_Weekly_Summary_Report() throws Exception
		{
			Enterprise_Reports_Weekly_Summary_Report a=new Enterprise_Reports_Weekly_Summary_Report();
			a.Open_Enterprise_Weekly_Summary_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Enterprise_Weekly_Summary_Report_This_Week(driver);
			a.Enterprise_Weekly_Summary_Report_Last_Week(driver);
			a.Enterprise_Weekly_Summary_Report_Last_7_Days(driver);

				
		}
		
		@Test(priority = 13,enabled = true)
		public void Enterprise_Reports_Sale_Summary_Report() throws Exception
		{
			Enterprise_Reports_Sale_Summary_Report a=new Enterprise_Reports_Sale_Summary_Report();
			a.Open_Enterprise_Sale_Summary_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Enterprise_Sale_Summary_Report_Today(driver);
			a.Enterprise_Sale_Summary_Report_Yesterday(driver);
			a.Enterprise_Sale_Summary_Report_Last_N_Days(driver);
			a.Enterprise_Sale_Summary_Report_This_Week(driver);
			a.Enterprise_Sale_Summary_Report_Last_Week(driver);
			a.Enterprise_Sale_Summary_Report_Last_7_Days(driver);
			a.Enterprise_Sale_Summary_Report_This_Month(driver);
			a.Enterprise_Sale_Summary_Report_Last_Month(driver);
			a.Enterprise_Sale_Summary_Report_Last_30_Days(driver);
			a.Enterprise_Sale_Summary_Report_Specific_Date(driver);
			a.Enterprise_Sale_Summary_Report_Date_Range(driver);
		}
		
		@Test(priority = 14,enabled = true)
		public void Enterprise_Detailed_Report() throws Exception
		{
			Enterprise_Detailed_Report a=new Enterprise_Detailed_Report();
			a.Open_Enterprise_Detailed_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Enterprise_Detailed_Report_Today(driver);
			a.Enterprise_Detailed_Report_Yesterday(driver);
			a.Enterprise_Detailed_Report_Last_N_Days(driver);
			a.Enterprise_Detailed_Report_This_Week(driver);
			a.Enterprise_Detailed_Report_Last_Week(driver);
			a.Enterprise_Detailed_Report_Last_7_Days(driver);
			a.Enterprise_Detailed_Report_This_Month(driver);
			a.Enterprise_Detailed_Report_Last_Month(driver);
			a.Enterprise_Detailed_Report_Last_30_Days(driver);
			a.Enterprise_Detailed_Report_Specific_Date(driver);
			a.Enterprise_Detailed_Report_Date_Range(driver);
		}
		
		
		
		@Test(priority = 15,enabled = true)
		public void Enterprise_Reports_Online_Sales_Report() throws Exception
		{
			Enterprise_Reports_Online_Sales_Report a=new Enterprise_Reports_Online_Sales_Report();
			a.Open_Enterprise_Online_Sales_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Enterprise_Online_Sales_Report_Today(driver);
			a.Enterprise_Online_Sales_Report_Yesterday(driver);
			a.Enterprise_Online_Sales_Report_Last_N_Days(driver);
			a.Enterprise_Online_Sales_Report_This_Week(driver);
			a.Enterprise_Online_Sales_Report_Last_Week(driver);
			a.Enterprise_Online_Sales_Report_Last_7_Days(driver);
			a.Enterprise_Online_Sales_Report_This_Month(driver);
			a.Enterprise_Online_Sales_Report_Last_Month(driver);
			a.Enterprise_Online_Sales_Report_Last_30_Days(driver);
			a.Enterprise_Online_Sales_Report_Specific_Date(driver);
			a.Enterprise_Online_Sales_Report_Date_Range(driver);
		}
		
		@Test(priority = 16,enabled = true)
		public void Enterprise_Reports_Employee_Role_Based_Payroll_Report() throws Exception
		{
			Enterprise_Reports_Employee_Role_Based_Payroll_Report a=new Enterprise_Reports_Employee_Role_Based_Payroll_Report();
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_Page_Open(driver);
//			a.RefreshAndPaginination(driver);
//			a.Enterprise_Employee_Role_Based_Payroll_Report_Verify_Role_Based_Payroll_Search(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Today(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Today(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Yesterday(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Yesterday(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_N_Days(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_N_Days(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_This_Week(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_This_Week(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_Week(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_Week(driver); 
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_7_days(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_7_days(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_This_Month(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_This_Month(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_Month(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_Month(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_30_days(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_30_days(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Specific_Date(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Specific_Date(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Hours_Date_Range(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range(driver);
			a.Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Hours_Date_Range(driver);

		}
		
		@Test(priority = 17,enabled = true)
		public void Enterprise_Reports_HA_Activity_Report() throws Exception
		{
			Enterprise_Reports_HA_Activity_Report a=new Enterprise_Reports_HA_Activity_Report();
			a.Open_Enterprise_Reports_HA_Activity_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Enterprise_Reports_HA_Activity_Report_Verify_Card_Search(driver);
			a.Enterprise_Reports_HA_Activity_Report_Today(driver);
			a.Enterprise_Reports_HA_Activity_Report_Yesterday(driver);
			a.Enterprise_Reports_HA_Activity_Report_Last_N_Days(driver);
			a.Enterprise_Reports_HA_Activity_Report_This_Week(driver);
			a.Enterprise_Reports_HA_Activity_Report_Last_Week(driver);
			a.Enterprise_Reports_HA_Activity_Report_Last_7_Days(driver);
			a.Enterprise_Reports_HA_Activity_Report_This_Month(driver);
			a.Enterprise_Reports_HA_Activity_Report_Last_Month(driver);
			a.Enterprise_Reports_HA_Activity_Report_Last_30_Days(driver);
			a.Enterprise_Reports_HA_Activity_Report_Specific_Date(driver);
			a.Enterprise_Reports_HA_Activity_Report_Date_Range(driver);
		}
		
		
		@Test(priority = 18,enabled = true)
		public void Enterprise_Reports_HA_Statement() throws Exception
		{
			Enterprise_Reports_HA_Statement a=new Enterprise_Reports_HA_Statement();
			a.Open_Enterprise_Reports_HA_Statement_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Enterprise_Reports_HA_Statement_Today(driver);
			a.Enterprise_Reports_HA_Statement_Yesterday(driver);
			a.Enterprise_Reports_HA_Statement_Last_N_Days(driver);
			a.Enterprise_Reports_HA_Statement_This_Week(driver);
			a.Enterprise_Reports_HA_Statement_Last_Week(driver);
			a.Enterprise_Reports_HA_Statement_Last_7_Days(driver);
			a.Enterprise_Reports_HA_Statement_This_Month(driver);
			a.Enterprise_Reports_HA_Statement_Last_Month(driver);
			a.Enterprise_Reports_HA_Statement_Last_30_Days(driver);
			a.Enterprise_Reports_HA_Statement_Specific_Date(driver);
			a.Enterprise_Reports_HA_Statement_Date_Range(driver);
		}
		
		@Test(priority = 19,enabled = true)
		public void Enterprise_Reports_Gift_Card_Redemption() throws Exception
		{
			Enterprise_Reports_Gift_Card_Redemption a=new Enterprise_Reports_Gift_Card_Redemption();
			a.Open_Enterprise_Gift_Card_Redemption_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.Verify_Enterprise_Gift_Card_Redemption_Report_Search_by_GiftCardNumber(driver);
			a.Enterprise_Gift_Card_Redemption_Report_Today(driver);
			a.Enterprise_Gift_Card_Redemption_Report_Yesterday(driver);
			a.Enterprise_Gift_Card_Redemption_Report_Last_N_Days(driver);
			a.Enterprise_Gift_Card_Redemption_Report_This_Week(driver);
			a.Enterprise_Gift_Card_Redemption_Report_Last_Week(driver);
			a.Enterprise_Gift_Card_Redemption_Report_Last_7_Days(driver);
			a.Enterprise_Gift_Card_Redemption_Report_This_Month(driver);
			a.Enterprise_Gift_Card_Redemption_Report_Last_Month(driver);
			a.Enterprise_Gift_Card_Redemption_Report_Last_30_Days(driver);
			a.Enterprise_Gift_Card_Redemption_Report_Specific_Date(driver);
			a.Enterprise_Gift_Card_Redemption_Report_Date_Range(driver);
		}
		
		@Test(priority = 20,enabled = true)
		public void Enterprise_Reports_Royalty_Franchies_Royalty_Report() throws Exception
		{
			Enterprise_Reports_Royalty_Franchise_Royalty_Report a=new Enterprise_Reports_Royalty_Franchise_Royalty_Report();
			a.Open_Enterprise_Settings_Royalty_Franchise_Report_Page(driver);
			//a.RefreshAndPaginination(driver);
			a.Royalty_report_Selected_Store_Selected_Discount_N_Number_of_time_Period(driver);
			a.Royalty_report_Selected_Group_Selected_Discount_N_Number_of_time_Period(driver);
			a.Royalty_report_Selected_State_Selected_Discount_N_Number_of_time_Period(driver);
			a.Royalty_report_Selected_City_Selected_Discount_N_Number_of_time_Period(driver);
			a.Royalty_report_Selected_ZipCode_Selected_Discount_N_Number_of_time_Period(driver);
			a.Royalty_report_Selected_Store_Selected_Discount_Today_time_Period(driver);
			a.Royalty_report_Selected_Store_Selected_Discount_Yesterday_time_Period(driver);
			a.Royalty_report_Selected_Store_Selected_Discount_ThisWeek_time_Period(driver);
			a.Royalty_report_Selected_Store_Selected_Discount_Last_Seaven_Days_time_Period(driver);
			a.Royalty_report_Selected_Store_Selected_Discount_LastWeek_time_Period(driver);
			a.Royalty_report_Selected_Store_Selected_Discount_ThisMonth_time_Period(driver);
			a.Royalty_report_Selected_Store_Selected_Discount_LastMonth_time_Period(driver);
			a.Royalty_report_Selected_Store_Selected_Discount_Last_thirtyDays_time_Period(driver);
			a.Royalty_report_Selected_Store_Selected_Discount_SpecificDate_time_Period(driver);
			a.Royalty_report_Selected_Store_Selected_Discount_Date_Ranage_time_Period(driver);
		}
		
		@Test(priority = 21,enabled = true)
		public void Enterprise_Reports_Royalty_Franchies_ACH_Report() throws Exception
		{
			Enterprise_Reports_Royalty_Franchies_ACH_Report a=new Enterprise_Reports_Royalty_Franchies_ACH_Report();
			a.Open_Enterprise_Settings_Royalty_Franchise_Report_Page(driver);
			//a.RefreshAndPaginination(driver);
			a.ACH_report_Selected_Store_Selected_Discount_PPD_CreditCard_N_Number_of_time_Period(driver);
			a.ACH_report_Selected_Store_Selected_Discount_CCD_DebitCard_N_Number_of_time_Period(driver);
			a.ACH_report_Selected_Store_Selected_Discount_PPD_DebitCard_N_Number_of_time_Period(driver);
			a.ACH_report_Selected_Store_Selected_Discount_CCD_CreditCard_N_Number_of_time_Period(driver);
			a.ACH_report_Selected_Store_Selected_Discount_PPD_Both_N_Number_of_time_Period(driver);
			a.ACH_report_Selected_Store_Selected_Discount_CCD_Both_N_Number_of_time_Period(driver);
			a.ACH_report_Selected_Store_Selected_Discount_Today_time_Period(driver);
			a.ACH_report_Selected_Store_Selected_Discount_Yesterday_time_Period(driver);
			a.ACH_report_Selected_Store_Selected_Discount_This_Week_TimePeriod(driver);
			a.ACH_report_Selected_Store_Selected_Discount_Last_Week_TimePeriod(driver);
			a.ACH_report_Selected_Store_Selected_Discount_Last_7_Days_TimePeriod(driver);
			a.ACH_report_Selected_Store_Selected_Discount_This_Month_TimePeriod(driver);
			a.ACH_report_Selected_Store_Selected_Discount_Last_Month_TimePeriod(driver);
			a.ACH_report_Selected_Store_Selected_Discount_Last_30_Days_TimePeriod(driver);
			a.ACH_report_Selected_Store_Selected_Discount_Specific_Date_TimePeriod(driver);
			a.ACH_report_Selected_Store_Selected_Discount_Date_Range_TimePeriod(driver);
		}
		
		@Test(priority = 22,enabled = true)
		public void Enterprise_Reports_Loyalty_Report() throws Exception
		{
			Enterprise_Reports_Loyalty_Report a=new Enterprise_Reports_Loyalty_Report();
			a.Open_Enterprise_Loyalty_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
//			a.Verify_Enterprise_Loyalty_Report_Search_by_CustomerName(driver);
			a.Enterprise_Loyalty_Report_Today(driver);
			a.Enterprise_Loyalty_Report_Yesterday(driver);
			a.Enterprise_Loyalty_Report_Last_N_Days(driver);
			a.Enterprise_Loyalty_Report_This_Week(driver);
			a.Enterprise_Loyalty_Report_Last_Week(driver);
			a.Enterprise_Loyalty_Report_Last_7_Days(driver);
			a.Enterprise_Loyalty_Report_This_Month(driver);
			a.Enterprise_Loyalty_Report_Last_Month(driver);
			a.Enterprise_Loyalty_Report_Last_30_Days(driver);
			a.Enterprise_Loyalty_Report_Specific_Date(driver);
			a.Enterprise_Loyalty_Report_Date_Range(driver);
		}
}
