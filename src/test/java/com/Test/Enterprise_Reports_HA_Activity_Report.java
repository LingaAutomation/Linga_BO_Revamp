package com.Test;

import java.util.List;
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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExcelDataConfig;
import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Enterprise_Reports_HA_Activity_Report
{
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise Reports - House Account - HA Activity Report");
	
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
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
//		//Open the Chrome window
//		driver = new ChromeDriver();
		
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver(chrOpt);
		
		System.setProperty("webdriver.chrome.driver","./Automation Driver/chromedriver.exe");
		//Open the Chrome window
		driver = new ChromeDriver();
		
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
		Open_Enterprise_Reports_HA_Activity_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Enterprise_Reports_HA_Activity_Report_Verify_Card_Search(driver);
		Enterprise_Reports_HA_Activity_Report_Today(driver);
		Enterprise_Reports_HA_Activity_Report_Yesterday(driver);
		Enterprise_Reports_HA_Activity_Report_Last_N_Days(driver);
		Enterprise_Reports_HA_Activity_Report_This_Week(driver);
		Enterprise_Reports_HA_Activity_Report_Last_Week(driver);
		Enterprise_Reports_HA_Activity_Report_Last_7_Days(driver);
		Enterprise_Reports_HA_Activity_Report_This_Month(driver);
		Enterprise_Reports_HA_Activity_Report_Last_Month(driver);
		Enterprise_Reports_HA_Activity_Report_Last_30_Days(driver);
		Enterprise_Reports_HA_Activity_Report_Specific_Date(driver);
		Enterprise_Reports_HA_Activity_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Enterprise_Reports_HA_Activity_Report_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the HA Activity page
				driver.get(Utility.getProperty("baseURL")+"enterprise/enterpriseReports/houseAccount/haActivity");

				Thread.sleep(5000);
				try
				{
				//Verify the HA Activity page loaded or not
				repts.Verify_ReportHomePage("HA ACTIVITY");
				}
				catch(Exception k)
				{
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
		
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
	public void Enterprise_Reports_HA_Activity_Report_Verify_Card_Search(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Enter Gift Card Number
		repts.Enter_GiftCard_Number("9865488876534567654345");
		
		//Select Activity Type 
		repts.Select_Activity_Type("All");
		
		//Select Employee 
		repts.Select_Employee("All");
	
		//Select Today
		repts.Select_Last_Month_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.PASS, "No transaction for selected time period is Displayed when Searching Invalid Gift Card Number");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.FAIL, "No transaction for selected time period is not Displayed when Searching Invalid Gift Card Number");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		}
		
		Thread.sleep(2000);
		//Enter Gift Card Number
				repts.Enter_GiftCard_Number("");
				
				//Select Activity Type 
				repts.Select_Activity_Type("All");
				
				//Select Employee 
				repts.Select_Employee("All");
			
				//Select Today
				repts.Select_Last_Month_TimePeriod();
				
				Thread.sleep(1000);
				//Click Apply
				repts.Click_ApplyButton(); 
				
				
				Thread.sleep(5000);
				try
				{
				if(repts.No_TransactionFound_InfoMessage().isDisplayed())
				{
					test.log(LogStatus.INFO, "HA Activity - Enterprise Reports Not Available for Selected Time Period");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception G)
				{
					
					test.log(LogStatus.PASS, "HA Activity - Enterprise Reports Available for Selected Time Period");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
					
					String GiftCard_Number=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[3]")).getText();
					
					//Enter Gift Card Number
					repts.Enter_GiftCard_Number(GiftCard_Number);
					
					//Select Activity Type 
					repts.Select_Activity_Type("All");
					
					//Select Employee 
					repts.Select_Employee("All");
				
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("100");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).getText().equalsIgnoreCase(GiftCard_Number))
					{
						test.log(LogStatus.PASS, "HA Activity - Enterprise Reports is Available for Searched Card Number");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "HA Activity - Enterprise Reports is Not Available for Searched Card Number");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					
					//Enter Gift Card Number
					repts.Enter_GiftCard_Number("");
					
					//Select Activity Type 
					repts.Select_Activity_Type("All");
					
					repts.Employee_InputBox().click();
					
					String Employee_Name=driver.findElement(By.xpath("//div[2]/select-option")).getText();
					
					repts.Employee_InputBox().click();
					
					//Select Employee 
					repts.Select_Employee(Employee_Name);
					
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("100");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[5]")).getText().equalsIgnoreCase(Employee_Name))
					{
						test.log(LogStatus.PASS, "HA Activity - Enterprise Reports is Available for Searched Employee");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "HA Activity - Enterprise Reports is Not Available for Searched Employee");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					
					
					//Enter Gift Card Number
					repts.Enter_GiftCard_Number("");
					
					//Select Activity Type 
					repts.Select_Activity_Type("Issued");
				
					//Select Employee 
					repts.Select_Employee("All");
					
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("100");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[6]")).getText().equalsIgnoreCase("Issued"))
					{
						test.log(LogStatus.PASS, "HA Activity - Enterprise Reports is Available for Searched Activity Type - Issued");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "HA Activity - Enterprise Reports is Not Available for Searched Activity type - Issued");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					
					
					//Enter Gift Card Number
					repts.Enter_GiftCard_Number("");
					
					//Select Activity Type 
					repts.Select_Activity_Type("Redeemed");
				
					//Select Employee 
					repts.Select_Employee("All");
					
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("100");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[6]")).getText().equalsIgnoreCase("Redeemed"))
					{
						test.log(LogStatus.PASS, "HA Activity - Enterprise Reports is Available for Searched Activity Type - Redeemed");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "HA Activity - Enterprise Reports is Not Available for Searched Activity type - Redeemed");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					//Enter Gift Card Number
					repts.Enter_GiftCard_Number("");
					
					//Select Activity Type 
					repts.Select_Activity_Type("Void");
				
					//Select Employee 
					repts.Select_Employee("All");
					
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("100");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[6]")).getText().equalsIgnoreCase("Void"))
					{
						test.log(LogStatus.PASS, "HA Activity - Enterprise Reports is Available for Searched Activity Type - Void");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "HA Activity - Enterprise Reports is Not Available for Searched Activity type - Void");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					//Enter Gift Card Number
					repts.Enter_GiftCard_Number("");
					
					//Select Activity Type 
					repts.Select_Activity_Type("Recharges");
				
					//Select Employee 
					repts.Select_Employee("All");
					
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("100");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[6]")).getText().equalsIgnoreCase("Recharges"))
					{
						test.log(LogStatus.PASS, "HA Activity - Enterprise Reports is Available for Searched Activity Type - Recharges");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "HA Activity - Enterprise Reports is Not Available for Searched Activity type - Recharges");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					//Enter Gift Card Number
					repts.Enter_GiftCard_Number("");
					
					//Select Activity Type 
					repts.Select_Activity_Type("Refund");
				
					//Select Employee 
					repts.Select_Employee("All");
					
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("100");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[6]")).getText().equalsIgnoreCase("Refund"))
					{
						test.log(LogStatus.PASS, "HA Activity - Enterprise Reports is Available for Searched Activity Type - Refund");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "HA Activity - Enterprise Reports is Not Available for Searched Activity type - Refund");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					
					//Enter Gift Card Number
					repts.Enter_GiftCard_Number("");
					
					//Select Activity Type 
					repts.Select_Activity_Type("Adjustment");
				
					//Select Employee 
					repts.Select_Employee("All");
					
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("100");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[6]")).getText().equalsIgnoreCase("Adjustment"))
					{
						test.log(LogStatus.PASS, "HA Activity - Enterprise Reports is Available for Searched Activity Type - Adjustment");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "HA Activity - Enterprise Reports is Not Available for Searched Activity type - Adjustment");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Reports_HA_Activity_Report_Today(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		
		//Enter Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		//Select Activity Type 
		repts.Select_Activity_Type("All");
		
		//Select Employee 
		repts.Select_Employee("All");
	
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "HA Activity - Enterprise Reports Not Available for Today");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "HA Activity - Enterprise Reports Available for Today");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
//			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}
			
			
		
		
	
			
		}
	}

	@Test(priority = 4,enabled = false)
	public void Enterprise_Reports_HA_Activity_Report_Yesterday(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		
		//Enter Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		//Select Activity Type 
		repts.Select_Activity_Type("All");
		
		//Select Employee 
		repts.Select_Employee("All");

		//Select Today
		repts.Select_Yesterday_TimePeriod();
		
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "HA Activity - Enterprise Reports Not Available for Yesterday");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "HA Activity - Enterprise Reports Available for Yesterday");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}
			
			
		
		
	
			
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Reports_HA_Activity_Report_Last_N_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		
		//Enter Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		//Select Activity Type 
		repts.Select_Activity_Type("All");
		
		//Select Employee 
		repts.Select_Employee("All");

		//Select Today
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "HA Activity - Enterprise Reports Not Available for Last 'N' days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "HA Activity - Enterprise Reports Available for Last 'N' days");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}
			
			
		
		
	
			
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Reports_HA_Activity_Report_This_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		
		//Enter Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		//Select Activity Type 
		repts.Select_Activity_Type("All");
		
		//Select Employee 
		repts.Select_Employee("All");

		//Select Today
		repts.Select_This_Week_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "HA Activity - Enterprise Reports Not Available for This Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "HA Activity - Enterprise Reports Available for This Week");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}
			
			
		
		
	
			
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Reports_HA_Activity_Report_Last_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		
		//Enter Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		//Select Activity Type 
		repts.Select_Activity_Type("All");
		
		//Select Employee 
		repts.Select_Employee("All");

		//Select Today
		repts.Select_Last_Week_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "HA Activity - Enterprise Reports Not Available for Last Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "HA Activity - Enterprise Reports Available for Last Week");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Reports_HA_Activity_Report_Last_7_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		
		//Enter Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		//Select Activity Type 
		repts.Select_Activity_Type("All");
		
		//Select Employee 
		repts.Select_Employee("All");

		//Select Today
		repts.Select_Last_7_Days_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "HA Activity - Enterprise Reports Not Available for Last 7 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "HA Activity - Enterprise Reports Available for Last 7 Days");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Reports_HA_Activity_Report_This_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		
		//Enter Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		//Select Activity Type 
		repts.Select_Activity_Type("All");
		
		//Select Employee 
		repts.Select_Employee("All");

		//Select Today
		repts.Select_This_Month_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "HA Activity - Enterprise Reports Not Available for This Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "HA Activity - Enterprise Reports Available for This Month");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Reports_HA_Activity_Report_Last_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		
		//Enter Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		//Select Activity Type 
		repts.Select_Activity_Type("All");
		
		//Select Employee 
		repts.Select_Employee("All");

		//Select Today
		repts.Select_Last_Month_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "HA Activity - Enterprise Reports Not Available for Last Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "HA Activity - Enterprise Reports Available for Last Month");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Reports_HA_Activity_Report_Last_30_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		
		//Enter Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		//Select Activity Type 
		repts.Select_Activity_Type("All");
		
		//Select Employee 
		repts.Select_Employee("All");

		//Select Today
		repts.Select_Last_30_Days_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "HA Activity - Enterprise Reports Not Available for Last 30 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "HA Activity - Enterprise Reports Available for Last 30 Days");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Reports_HA_Activity_Report_Specific_Date(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		
		//Enter Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		//Select Activity Type 
		repts.Select_Activity_Type("All");
		
		//Select Employee 
		repts.Select_Employee("All");

		//Select Today
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
			
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "HA Activity - Enterprise Reports Not Available for Specific Date");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "HA Activity - Enterprise Reports Available for Specific Date");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Reports_HA_Activity_Report_Date_Range(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		
		//Enter Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		//Select Activity Type 
		repts.Select_Activity_Type("All");
		
		//Select Employee 
		repts.Select_Employee("All");

		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
			
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "HA Activity - Enterprise Reports Not Available for Date Range");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "HA Activity - Enterprise Reports Available for Date Range");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				
//				
				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText();
				
				String Card_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText();
				
				String 	Check_No=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText();

				
				String Activity_Type=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText();
				

				
				String Amount=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText();
				
				
				String Balance=driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[8]")).getText();
				
				test.log(LogStatus.INFO, "Card No is : "+Card_No+" Date is : "+Date+" Check No is : "+Check_No+" Activity Type is : "+Activity_Type+" Amount is : "+Amount+" Balance is : "+Balance);
				
			}
		}

		}
	}
}
