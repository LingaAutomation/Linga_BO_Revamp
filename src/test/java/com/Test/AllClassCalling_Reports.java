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
		
		@Test(priority = 11,enabled = false)
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
		
		@Test(priority = 13,enabled = false)
		public void Reports_Future_Order_Sale_Report() throws Exception
		{
			Reports_Future_Order_Sale_Report a=new Reports_Future_Order_Sale_Report();
			a.Open_FutureOrder_Report_Page(driver);
//			a.RefreshAndPaginination(driver);
			a.FutureOrder_Sale_Report(driver);
				
		}
		
		@Test(priority = 14,enabled = false)
		public void Reports_Logo_Sale_Sale_Report() throws Exception
		{
			// Logo Sale
				
		}
		
		@Test(priority = 15,enabled = false)
		public void Reports_Logo_Payment_Sale_Report() throws Exception
		{
			// Logo Payment
				
		}
		
		@Test(priority = 16,enabled = false)
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
}
