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
import com.epam.healenium.SelfHealingDriver;
import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExcelDataConfig;
import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports_Till_Report
{
public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Till Report");
	
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
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Till_Path"));
//		//Open the Chrome window
//		driver = new ChromeDriver();
		
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
		Open_Till_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Till_Report_Verify_Till_Search(driver);
		Till_Report_Today(driver);
		Till_Report_Yesterday(driver);
		Till_Report_Last_N_Days(driver);
		Till_Report_This_Week(driver);
		Till_Report_Last_Week(driver);
		Till_Report_Last_7_Days(driver);
		Till_Report_This_Month(driver);
		Till_Report_Last_Month(driver);
		Till_Report_Last_30_Days(driver);
		Till_Report_Specific_Date(driver);
		Till_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Till_Report_Page(SelfHealingDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Till Report Page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"tillReport/till");

		Thread.sleep(5000);
		//Verify the Till Report Page loaded or not
		repts.Verify_ReportHomePage("TILL");
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(SelfHealingDriver driver) throws Exception
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
	public void Till_Report_Verify_Till_Search(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Employee 
		repts.Select_Employee("All");
	
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.PASS, "No transaction for selected time period is Displayed when Searching Invalid Driver Number");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.FAIL, "No transaction for selected time period is not Displayed when Searching Invalid Driver Number");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		}
		
		Thread.sleep(2000);
	
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
					test.log(LogStatus.INFO, "Till Reports Not Available for Selected Time Period");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception G)
				{
					
					test.log(LogStatus.PASS, "Till Reports Available for Selected Time Period");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
					
					repts.Employee_InputBox().click();
					
					String Emp_Name=driver.findElement(By.xpath("//div[2]/select-option")).getText();
					
					repts.Employee_InputBox().click();
					
					//Select Employee 
					repts.Select_Employee(Emp_Name);
					
					
					//Select GLOBAL/USER 
					repts.Select_Till_Type("All");
					
					//Select Today
					repts.Select_Last_Month_TimePeriod();
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[3]")).getText().equalsIgnoreCase(Emp_Name))
					{
						test.log(LogStatus.PASS, "Till Reports is Available for Searched Employee Name");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Till Reports is Not Available for Searched Employee Name");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					//Select Employee 
					repts.Select_Employee("All");
				
					//Select GLOBAL/USER 
					repts.Select_Till_Type("GLOBAL");
					
					//Select Today
					repts.Select_Last_Month_TimePeriod();
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Till Reports is Available for GLOBAL Status");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Till Reports is Not Available for GLOBAL Status");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					//Select Employee 
					repts.Select_Employee("All");
				
					//Select GLOBAL/USER 
					repts.Select_Till_Type("USER");
					
					//Select Today
					repts.Select_Last_Month_TimePeriod();
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Till Reports is Available for USER Status");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Till Reports is Not Available for USER Status");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				
	}
	
	@Test(priority = 4,enabled = false)
	public void Till_Report_Today(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Employee 
		repts.Select_Employee("All");

		//Select Till Type
		repts.Select_Till_Type("All");

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
			test.log(LogStatus.INFO, "Till Reports Not Available for Today");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Till Reports Available for Today");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
//			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=1000)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
			
	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
			
				Thread.sleep(1000);
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Today");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Today. The Diff is : "+diff);
				}
			}
		}
		else
		{
			for(int i=1;i<=1000;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
	
				String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
		//"Node is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Gratuity Amount : "+Gratuity_Amt);
			
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Today");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Today. The Diff is : "+diff);
				}
			}
		}
		
		}
	}

	@Test(priority = 4,enabled = false)
	public void Till_Report_Yesterday(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Employee 
		repts.Select_Employee("All");

		//Select Till Type
		repts.Select_Till_Type("All");
		
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
			test.log(LogStatus.INFO, "Till Reports Not Available for Yesterday");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Till Reports Available for Yesterday");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		
	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
			
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Yesterday");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Yesterday. The Diff is : "+diff);
				}
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		
	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
			
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Yesterday");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Yesterday. The Diff is : "+diff);
				}
			}
		}
	
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Till_Report_Last_N_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Employee 
		repts.Select_Employee("All");
	
		//Select Till Type
		repts.Select_Till_Type("All");

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
			test.log(LogStatus.INFO, "Till Reports Not Available for Last 'N' days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Till Reports Available for Last 'N' days");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
	
	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
		
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Last N Days");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Last N Days. The Diff is : "+diff);
				}
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();

	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);

				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Last N Days");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Last N Days. The Diff is : "+diff);
				}
			}
		}
	
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Till_Report_This_Week(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Employee 
		repts.Select_Employee("All");

		//Select Till Type
		repts.Select_Till_Type("All");

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
			test.log(LogStatus.INFO, "Till Reports Not Available for This Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Till Reports Available for This Week");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
	
	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
	
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for This Week");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for This Week. The Diff is : "+diff);
				}
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
	
	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
		
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for This Week");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for This Week. The Diff is : "+diff);
				}
			}
		}
			
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Till_Report_Last_Week(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Employee 
		repts.Select_Employee("All");

		//Select Till Type
		repts.Select_Till_Type("All");

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
			test.log(LogStatus.INFO, "Till Reports Not Available for Last Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Till Reports Available for Last Week");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		
	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
		
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Last Week");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Last Week. The Diff is : "+diff);
				}
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
	
	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
	
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Last Week");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Last Week. The Diff is : "+diff);
				}
			}
		}
		
		
	
		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Till_Report_Last_7_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Employee 
		repts.Select_Employee("All");
	
		//Select Till Type
		repts.Select_Till_Type("All");

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
			test.log(LogStatus.INFO, "Till Reports Not Available for Last 7 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Till Reports Available for Last 7 Days");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
	
	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
		
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Last 7 days");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Last 7 days. The Diff is : "+diff);
				}
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
			
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Last 7 days");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Last 7 days. The Diff is : "+diff);
				}
			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Till_Report_This_Month(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Employee 
		repts.Select_Employee("All");

		//Select Till Type
		repts.Select_Till_Type("All");

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
			test.log(LogStatus.INFO, "Till Reports Not Available for This Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Till Reports Available for This Month");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
	
	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
	
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for This Month");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for This Month. The Diff is : "+diff);
				}
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
	
	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);

				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for This Month");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for This Month. The Diff is : "+diff);
				}
			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Till_Report_Last_Month(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Employee 
		repts.Select_Employee("All");

		//Select Till Type
		repts.Select_Till_Type("All");

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
			test.log(LogStatus.INFO, "Till Reports Not Available for Last Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Till Reports Available for Last Month");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
			
String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
	
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Last Month");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Last Month. The Diff is : "+diff);
				}
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		
String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				
				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
	
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Last Month");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Last Month. The Diff is : "+diff);
				}
			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Till_Report_Last_30_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Employee 
		repts.Select_Employee("All");

		//Select Till Type
		repts.Select_Till_Type("All");

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
			test.log(LogStatus.INFO, "Till Reports Not Available for Last 30 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Till Reports Available for Last 30 Days");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		
	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
	
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Last 30 days");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Last 30 days. The Diff is : "+diff);
				}
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();

	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
	
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Last 30 days");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Last 30 days. The Diff is : "+diff);
				}
			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Till_Report_Specific_Date(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Employee 
		repts.Select_Employee("All");

		//Select Till Type
		repts.Select_Till_Type("All");

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
			test.log(LogStatus.INFO, "Till Reports Not Available for Specific Date");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Till Reports Available for Specific Date");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
			
	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
		
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Specific Date");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Specific Date. The Diff is : "+diff);
				}
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
			
	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);

				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Specific Date");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Specific Date. The Diff is : "+diff);
				}
			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Till_Report_Date_Range(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Employee 
		repts.Select_Employee("All");
	
		//Select Till Type
		repts.Select_Till_Type("All");
		
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
			test.log(LogStatus.INFO, "Till Reports Not Available for Date Range");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Till Reports Available for Date Range");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
	
	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
	
				
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Date Range");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Date Range. The Diff is : "+diff);
				}
				
				
				//Click the First node
				
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String User_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();

	String Cash_Expected=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String Over_Shortage=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Date is : "+Date+" User is : "+User_Name+" Cash Expected : "+Cash_Expected+" Amount is : "+Amount+" Over/Shortage is : "+Over_Shortage);
				
				String Total_CashExpect=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_CashExpected=Double.parseDouble(Total_CashExpect);
				
				String Total_Amt=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Total_Amount=Double.parseDouble(Total_Amt);
				
				double Expected_OverShortage=Total_Amount-Total_CashExpected;
				String Expected_Over_Shortage=String.valueOf(Expected_OverShortage);
				
				String Actual_OverShortage=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
				double Actual_Over_Shortage=Double.parseDouble(Actual_OverShortage);
				
				if(Actual_Over_Shortage==Expected_OverShortage)
				{
					test.log(LogStatus.PASS, "Over/Shortage Calculated Correctly for Date Range");
				}
				else
				{
					double diff=Actual_Over_Shortage-Expected_OverShortage;
					
					test.log(LogStatus.FAIL, "Over/Shortage is Calculated Incorrect for Date Range. The Diff is : "+diff);
				}
				
				
				
				
				
			}
		}
		
		
	
		}
	}
}
