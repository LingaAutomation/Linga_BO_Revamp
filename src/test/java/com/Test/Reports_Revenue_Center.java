package com.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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

import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExcelDataConfig;
import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports_Revenue_Center
{
public WebDriver driver;
	 
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Revenue Center Report");
	
	LoginPage lgpg;
	public String st="NA";
	
	Utility ut=new Utility();

	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	ReportsPage repts;
	
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
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Revenue_Center_Path"));
//		//Open the Chrome window
//		driver = new ChromeDriver();
		
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
		Open_Revenue_Center_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Revenue_Center_Report_Verify_Revenue_Center_Search(driver);
		Revenue_Center_Report_Today(driver);
		Revenue_Center_Report_Yesterday(driver);
		Revenue_Center_Report_Last_N_Days(driver);
		Revenue_Center_Report_This_Week(driver);
		Revenue_Center_Report_Last_Week(driver);
		Revenue_Center_Report_Last_7_Days(driver);
		Revenue_Center_Report_This_Month(driver);
		Revenue_Center_Report_Last_Month(driver);
		Revenue_Center_Report_Last_30_Days(driver);
		Revenue_Center_Report_Specific_Date(driver);
		Revenue_Center_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Revenue_Center_Report_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Daily page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"revenueCenterReport");

		Thread.sleep(5000);
		//Verify the Categories page loaded or not
		cmp.VerifyCreationScreenPageHeader("Revenue Center");
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
		
		//Ascending and Descending Sorting
		cmp.Ascending_And_Descending_Order();
	}
	
	@Test(priority = 4,enabled = false)
	public void Revenue_Center_Report_Verify_Revenue_Center_Search(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Revenue_Center_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Revenue_Centers("Select All");

		
		Thread.sleep(1000);
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_Revenue_CenterFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No Revenue Center Records for Selected Time Period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.INFO, "Revenue Center Report for selected time period is Available");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		}
		
		Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
				//Select the Node
				repts.Select_Revenue_Centers("Select All");
				
				
				
				Thread.sleep(1000);
				//Select Today
				repts.Select_Last_N_Days_TimePeriod("500");
				
				Thread.sleep(1000);
				//Click Apply
				repts.Click_ApplyButton(); 
				
				
				Thread.sleep(5000);
				try
				{
				if(repts.No_Revenue_CenterFound_InfoMsg().isDisplayed())
				{
					test.log(LogStatus.INFO, "Revenue Center Report Not Available for Selected Time Period");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception G)
				{
					
					test.log(LogStatus.PASS, "Revenue Center Report Available for Selected Time Period");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

					Thread.sleep(1000);
					repts.Select_Revenue_Centers("Number of Guests");
					
					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("500");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Revenue Center Report is Available for Searched Revenue Center - Number of Guests");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Revenue Center Report is Not Available for Searched Revenue Center - Number of Guests");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
					
					
					Thread.sleep(1000);
					repts.Select_Revenue_Centers("Number of Checks");
					
					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("500");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Revenue Center Report is Available for Searched Revenue Center - Number of Checks");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Revenue Center Report is Not Available for Searched Revenue Center - Number of Checks");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

					Thread.sleep(1000);
					repts.Select_Revenue_Centers("Net sales by Category");
					
					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("500");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Revenue Center Report is Available for Searched Revenue Center - Net Sales by Category");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Revenue Center Report is Not Available for Searched Revenue Center - Net Sales by Category");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

					
					Thread.sleep(1000);
					repts.Select_Revenue_Centers("Net Sales by Shift");
					
					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("500");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Revenue Center Report is Available for Searched Revenue Center - Net Sales by Shift");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Revenue Center Report is Not Available for Searched Revenue Center - Net Sales by Shift");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

					Thread.sleep(1000);
					repts.Select_Revenue_Centers("Net sales for Revenue Center");
					
					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("500");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Revenue Center Report is Available for Searched Revenue Center - Net Sales by Revenue Center");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Revenue Center Report is Not Available for Searched Revenue Center - Net Sales by Revenue Center");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

				}	
	}
	
	@Test(priority = 4,enabled = false)
	public void Revenue_Center_Report_Today(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Revenue_Centers("Select All");

		Thread.sleep(1000);
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_Revenue_CenterFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Revenue Center Report Not Available for Today");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Revenue Center Report Available for Today");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			repts.Verify_No_ofGuests_RevenueCenterTotal();
			
			repts.Verify_No_ofChecks_RevenueCenterTotal();
			
			repts.Verify_NetSales_byCategory_RevenueCenterTotal();
			
			repts.Verify_NetSales_byShift_RevenueCenterTotal();
			
			repts.Verify_NetSales_byRevenue_Center_RevenueCenterTotal();

		}
			
			
		
		
		

	
			
		
	}

	@Test(priority = 4,enabled = false)
	public void Revenue_Center_Report_Yesterday(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Revenue_Center_Report"));

		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Revenue_Centers("Select All");

	

		Thread.sleep(1000);
		//Select Today
		repts.Select_Yesterday_TimePeriod();
		
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_Revenue_CenterFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Revenue Center Report Not Available for Yesterday");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Revenue Center Report Available for Yesterday");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			repts.Verify_No_ofGuests_RevenueCenterTotal();
			
			repts.Verify_No_ofChecks_RevenueCenterTotal();
			
			repts.Verify_NetSales_byCategory_RevenueCenterTotal();
			
			repts.Verify_NetSales_byShift_RevenueCenterTotal();
			
			repts.Verify_NetSales_byRevenue_Center_RevenueCenterTotal();


			
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Revenue_Center_Report_Last_N_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Revenue_Center_Report"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Revenue_Centers("Select All");

		

		Thread.sleep(1000);
		//Select Last N days
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_Revenue_CenterFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Revenue Center Report Not Available for Last 'N' days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Revenue Center Report Available for Last 'N' days");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
	repts.Verify_No_ofGuests_RevenueCenterTotal();
			
			repts.Verify_No_ofChecks_RevenueCenterTotal();
			
			repts.Verify_NetSales_byCategory_RevenueCenterTotal();
			
			repts.Verify_NetSales_byShift_RevenueCenterTotal();
			
			repts.Verify_NetSales_byRevenue_Center_RevenueCenterTotal();

	
			
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Revenue_Center_Report_This_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Revenue_Center_Report"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Revenue_Centers("Select All");

		

		Thread.sleep(1000);
		//Select This Week
		repts.Select_This_Week_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_Revenue_CenterFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Revenue Center Report Not Available for This Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Revenue Center Report Available for This Week");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
	repts.Verify_No_ofGuests_RevenueCenterTotal();
			
			repts.Verify_No_ofChecks_RevenueCenterTotal();
			
			repts.Verify_NetSales_byCategory_RevenueCenterTotal();
			
			repts.Verify_NetSales_byShift_RevenueCenterTotal();
			
			repts.Verify_NetSales_byRevenue_Center_RevenueCenterTotal();

		

	
			
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Revenue_Center_Report_Last_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Revenue_Center_Report"));
	
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Revenue_Centers("Select All");

		
		Thread.sleep(1000);
		//Select Last
		repts.Select_Last_Week_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_Revenue_CenterFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Revenue Center Report Not Available for Last Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Revenue Center Report Available for Last Week");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
	repts.Verify_No_ofGuests_RevenueCenterTotal();
			
			repts.Verify_No_ofChecks_RevenueCenterTotal();
			
			repts.Verify_NetSales_byCategory_RevenueCenterTotal();
			
			repts.Verify_NetSales_byShift_RevenueCenterTotal();
			
			repts.Verify_NetSales_byRevenue_Center_RevenueCenterTotal();

	
		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Revenue_Center_Report_Last_7_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Revenue_Center_Report"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Revenue_Centers("Select All");

		

		Thread.sleep(1000);
		//Select Last 7 days
		repts.Select_Last_7_Days_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_Revenue_CenterFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Revenue Center Report Not Available for Last 7 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Revenue Center Report Available for Last 7 Days");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
	repts.Verify_No_ofGuests_RevenueCenterTotal();
			
			repts.Verify_No_ofChecks_RevenueCenterTotal();
			
			repts.Verify_NetSales_byCategory_RevenueCenterTotal();
			
			repts.Verify_NetSales_byShift_RevenueCenterTotal();
			
			repts.Verify_NetSales_byRevenue_Center_RevenueCenterTotal();


	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Revenue_Center_Report_This_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Revenue_Center_Report"));

		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Revenue_Centers("Select All");

		
		Thread.sleep(1000);
		//Select Today
		repts.Select_This_Month_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_Revenue_CenterFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Revenue Center Report Not Available for This Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Revenue Center Report Available for This Month");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
	repts.Verify_No_ofGuests_RevenueCenterTotal();
			
			repts.Verify_No_ofChecks_RevenueCenterTotal();
			
			repts.Verify_NetSales_byCategory_RevenueCenterTotal();
			
			repts.Verify_NetSales_byShift_RevenueCenterTotal();
			
			repts.Verify_NetSales_byRevenue_Center_RevenueCenterTotal();


	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Revenue_Center_Report_Last_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Revenue_Center_Report"));

		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Revenue_Centers("Select All");

		
		Thread.sleep(1000);
		//Select Today
		repts.Select_Last_Month_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_Revenue_CenterFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Revenue Center Report Not Available for Last Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Revenue Center Report Available for Last Month");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
	repts.Verify_No_ofGuests_RevenueCenterTotal();
			
			repts.Verify_No_ofChecks_RevenueCenterTotal();
			
			repts.Verify_NetSales_byCategory_RevenueCenterTotal();
			
			repts.Verify_NetSales_byShift_RevenueCenterTotal();
			
			repts.Verify_NetSales_byRevenue_Center_RevenueCenterTotal();

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Revenue_Center_Report_Last_30_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Revenue_Center_Report"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);


		Thread.sleep(1000);
		//Select the Node
		repts.Select_Revenue_Centers("Select All");

		
		Thread.sleep(1000);
		//Select Last 30 days
		repts.Select_Last_30_Days_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_Revenue_CenterFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Revenue Center Report Not Available for Last 30 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Revenue Center Report Available for Last 30 Days");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
	repts.Verify_No_ofGuests_RevenueCenterTotal();
			
			repts.Verify_No_ofChecks_RevenueCenterTotal();
			
			repts.Verify_NetSales_byCategory_RevenueCenterTotal();
			
			repts.Verify_NetSales_byShift_RevenueCenterTotal();
			
			repts.Verify_NetSales_byRevenue_Center_RevenueCenterTotal();


		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Revenue_Center_Report_Specific_Date(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Revenue_Center_Report"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Revenue_Centers("Select All");

		

		Thread.sleep(1000);
		//Select Today
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
			
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_Revenue_CenterFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Revenue Center Report Not Available for Specific Date");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Revenue Center Report Available for Specific Date");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
	repts.Verify_No_ofGuests_RevenueCenterTotal();
			
			repts.Verify_No_ofChecks_RevenueCenterTotal();
			
			repts.Verify_NetSales_byCategory_RevenueCenterTotal();
			
			repts.Verify_NetSales_byShift_RevenueCenterTotal();
			
			repts.Verify_NetSales_byRevenue_Center_RevenueCenterTotal();

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Revenue_Center_Report_Date_Range(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		

		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Revenue_Centers("Select All");

	
		Thread.sleep(1000);
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
			
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_Revenue_CenterFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Revenue Center Report Not Available for Date Range");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Revenue Center Report Available for Date Range");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
	repts.Verify_No_ofGuests_RevenueCenterTotal();
			
			repts.Verify_No_ofChecks_RevenueCenterTotal();
			
			repts.Verify_NetSales_byCategory_RevenueCenterTotal();
			
			repts.Verify_NetSales_byShift_RevenueCenterTotal();
			
			repts.Verify_NetSales_byRevenue_Center_RevenueCenterTotal();
		}
	}
}
