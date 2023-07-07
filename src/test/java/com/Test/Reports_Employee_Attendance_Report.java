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
import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExcelDataConfig;
import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports_Employee_Attendance_Report
{
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Employee Attendance Report");
	
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
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Employee_Attendance_Path"));
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
		Open_Employee_Attendance_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Employee_Attendance_Report_Verify_Employee_Attendance_Search(driver);
		Employee_Attendance_Report_Today(driver);
		Employee_Attendance_Report_Yesterday(driver);
		Employee_Attendance_Report_Last_N_Days(driver);
		Employee_Attendance_Report_This_Week(driver);
		Employee_Attendance_Report_Last_Week(driver);
		Employee_Attendance_Report_Last_7_Days(driver);
		Employee_Attendance_Report_This_Month(driver);
		Employee_Attendance_Report_Last_Month(driver);
		Employee_Attendance_Report_Last_30_Days(driver);
		Employee_Attendance_Report_Specific_Date(driver);
		Employee_Attendance_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Employee_Attendance_Report_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Employee Attendance Report Page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"employee/attendance");

		Thread.sleep(5000);
		//Verify the Employee Attendance Report Page loaded or not
		repts.Verify_ReportHomePage("ATTENDANCE");
		
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
	public void Employee_Attendance_Report_Verify_Employee_Attendance_Search(WebDriver driver) throws Exception
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
					test.log(LogStatus.INFO, "Employee Attendance Reports Not Available for Selected Time Period");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception G)
				{
					
					test.log(LogStatus.PASS, "Employee Attendance Reports Available for Selected Time Period");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
					
					repts.Employee_InputBox().click();
					
					String Employee_Attendance_Name=driver.findElement(By.xpath("//select-option[2]")).getText();
					
					repts.Employee_InputBox().click();
					
					//Select Employee 
					repts.Select_Employee(Employee_Attendance_Name);
					
					
					//Select Format
					repts.Select_FormatType("In Time");
					
					//Select Active/Inactive 
					repts.Select_Active_InactiveType("All");
					
					//Select Today
					repts.Select_Last_Month_TimePeriod();
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).getText().equalsIgnoreCase(Employee_Attendance_Name))
					{
						test.log(LogStatus.PASS, "Employee Attendance Reports is Available for Searched Employee Name");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Employee Attendance Reports is Not Available for Searched Employee Name");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					//Select Employee 
					repts.Select_Employee("All");
					
					
					//Select Format
					repts.Select_FormatType("In Hours");
					
					//Select Active/Inactive 
					repts.Select_Active_InactiveType("All");
					
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
						test.log(LogStatus.PASS, "Employee Attendance Reports is Available for Searched Format - In Hours");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Employee Attendance Reports is Not Available for Searched Format - In Hours");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					
					//Select Employee 
					repts.Select_Employee("All");
					
					
					//Select Format
					repts.Select_FormatType("In Time");
					
					//Select Active/Inactive 
					repts.Select_Active_InactiveType("Active");
					
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
						test.log(LogStatus.PASS, "Employee Attendance Reports is Available for Active Status");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Employee Attendance Reports is Not Available for Active Status");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					//Select Employee 
					repts.Select_Employee("All");
					
					
					//Select Format
					repts.Select_FormatType("In Time");
					
					//Select Active/Inactive 
					repts.Select_Active_InactiveType("Inactive");
					
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
						test.log(LogStatus.PASS, "Employee Attendance Reports is Available for Inactive Status");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Employee Attendance Reports is Not Available for Inactive Status");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_Attendance_Report_Today(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		

		
		
		
		//Select Employee 
		repts.Select_Employee("All");
		
		//Select Format
		repts.Select_FormatType("In Time");
		
		//Select Active/Inactive Status
		repts.Select_Active_InactiveType("All");
		
		
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
			test.log(LogStatus.INFO, "Employee Attendance Reports Not Available for Today");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Employee Attendance Reports Available for Today");
			
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
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
			
				
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
			
			
				
				

				
				
				
				Thread.sleep(1000);
				
				
			}
		}
		else
		{
			for(int i=1;i<=1000;i++)
			{
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
	
				
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
							}
		}
			
			
		
		
		
		
	
			
		}
	}

	@Test(priority = 4,enabled = false)
	public void Employee_Attendance_Report_Yesterday(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		

		//Select Employee 
		repts.Select_Employee("All");
		
		//Select Format
		repts.Select_FormatType("In Time");
		
		//Select Active/Inactive Status
		repts.Select_Active_InactiveType("All");
		
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
			test.log(LogStatus.INFO, "Employee Attendance Reports Not Available for Yesterday");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Employee Attendance Reports Available for Yesterday");
			
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
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
		
				
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
				
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
		
				
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
				
				
			}
		}
			
			
		
		
		
	
	
			
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Employee_Attendance_Report_Last_N_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Employee 
		repts.Select_Employee("All");
		
		//Select Format
		repts.Select_FormatType("In Time");
		
		//Select Active/Inactive Status
		repts.Select_Active_InactiveType("All");
		
		
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
			test.log(LogStatus.INFO, "Employee Attendance Reports Not Available for Last 'N' days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Employee Attendance Reports Available for Last 'N' days");
			
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
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
			
				
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
				
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
			
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
				
				
			}
		}
			
			
		
		
		
		
	
			
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Employee_Attendance_Report_This_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Employee 
		repts.Select_Employee("All");
		
		//Select Format
		repts.Select_FormatType("In Time");
		
		//Select Active/Inactive Status
		repts.Select_Active_InactiveType("All");
		
		
		
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
			test.log(LogStatus.INFO, "Employee Attendance Reports Not Available for This Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Employee Attendance Reports Available for This Week");
			
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
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
			
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
			
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
		
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
				
				
			}
		}
			
			
		
		
		
		
	
			
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_Attendance_Report_Last_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		

		//Select Employee 
		repts.Select_Employee("All");
		
		//Select Format
		repts.Select_FormatType("In Time");
		
		//Select Active/Inactive Status
		repts.Select_Active_InactiveType("All");
		
		
		
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
			test.log(LogStatus.INFO, "Employee Attendance Reports Not Available for Last Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Employee Attendance Reports Available for Last Week");
			
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
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
		
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
			
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
				
				
			}
		}
		
		
	
		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Employee_Attendance_Report_Last_7_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Employee 
		repts.Select_Employee("All");
		
		//Select Format
		repts.Select_FormatType("In Time");
		
		//Select Active/Inactive Status
		repts.Select_Active_InactiveType("All");
		
		
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
			test.log(LogStatus.INFO, "Employee Attendance Reports Not Available for Last 7 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Employee Attendance Reports Available for Last 7 Days");
			
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
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
			
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
			
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
			
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
				
				
			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_Attendance_Report_This_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Employee 
		repts.Select_Employee("All");
		
		//Select Format
		repts.Select_FormatType("In Time");
		
		//Select Active/Inactive Status
		repts.Select_Active_InactiveType("All");
		
		
		
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
			test.log(LogStatus.INFO, "Employee Attendance Reports Not Available for This Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Employee Attendance Reports Available for This Month");
			
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
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
			
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
			
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
			
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
			
				
			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_Attendance_Report_Last_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Employee 
		repts.Select_Employee("All");
		
		//Select Format
		repts.Select_FormatType("In Time");
		
		//Select Active/Inactive Status
		repts.Select_Active_InactiveType("All");
		
		
	
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
			test.log(LogStatus.INFO, "Employee Attendance Reports Not Available for Last Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Employee Attendance Reports Available for Last Month");
			
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
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
				
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
				
			
			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_Attendance_Report_Last_30_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Employee 
		repts.Select_Employee("All");
		
		//Select Format
		repts.Select_FormatType("In Time");
		
		//Select Active/Inactive Status
		repts.Select_Active_InactiveType("All");
		
		
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
			test.log(LogStatus.INFO, "Employee Attendance Reports Not Available for Last 30 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Employee Attendance Reports Available for Last 30 Days");
			
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
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
				
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
				
			
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
			
				
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
				
			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_Attendance_Report_Specific_Date(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Employee 
		repts.Select_Employee("All");
		
		//Select Format
		repts.Select_FormatType("In Time");
		
		//Select Active/Inactive Status
		repts.Select_Active_InactiveType("All");
		
		
		
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
			test.log(LogStatus.INFO, "Employee Attendance Reports Not Available for Specific Date");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Employee Attendance Reports Available for Specific Date");
			
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
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
				
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
				
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
				
				
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
				
				
			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_Attendance_Report_Date_Range(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Employee 
		repts.Select_Employee("All");
		
		//Select Format
		repts.Select_FormatType("In Time");
		
		//Select Active/Inactive Status
		repts.Select_Active_InactiveType("All");
		
		
		
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
			test.log(LogStatus.INFO, "Employee Attendance Reports Not Available for Date Range");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Employee Attendance Reports Available for Date Range");
			
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
			
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
			
				
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
			
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Emp_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Emp_ID=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				
				
				String Check_In=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
			
				
				String Check_Out=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				
				String Worked_Hours=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Emp_Role=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				test.log(LogStatus.INFO, "Date is : "+Date+" Employee Name is : "+Emp_Name+" Employee ID is : "+Emp_ID+" Check In Time is : "+Check_In+" Check Out Time is : "+Check_Out+ "This Employee Worked Hours is : "+Worked_Hours+" Job Code is : "+Emp_Role);
				
				
				
				
				
			}
		}
		
		
	
		}
	}
}
