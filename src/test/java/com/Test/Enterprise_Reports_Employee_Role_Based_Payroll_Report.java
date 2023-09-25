package com.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.google.inject.Key;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Enterprise_Reports_Employee_Role_Based_Payroll_Report 
{

	public WebDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise Reports - Employee - Role Based Payroll Report");
	
	LoginPage lgpg;
	public String st="NA";
	
	Utility ut=new Utility();

	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	ReportsPage repts;
	double CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip,OverAll_Tip,Over_All_Pay,OverAll_Tip_Dly,Over_All_Pay_Dly,OverAll_Tip_Wly,Over_All_Pay_Wly,Tip_Shared_Dly,Tip_Shared_Wly;
	float unknownValue = 00;
	String Child_tab, parent_tab;
	ArrayList<String> Alltabs;

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
	

@Test(priority=1)
public void Login() throws Exception
{
//	Thread.sleep(2000);
//	ChromeOptions chrOpt=new ChromeOptions();
//	chrOpt.addArguments("--remote-allow-origins=*");
//	WebDriverManager.chromedriver().setup();
//	driver=new ChromeDriver(chrOpt);
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
	
@Test(priority=500)
public void Logout() throws Exception
{	
	a.LogOut(driver, test);
}
	
@Test(priority = 100)
public void Calling() throws Exception
{
	Thread.sleep(1000);
	try
	{
		Thread.sleep(1000);System.out.println("Minimize Chat Icon");
	driver.findElement(By.id("zsiq_minimize")).click();
	}
	catch(Exception e)
	{
	System.out.println("Minimize Chat Icon Missing");
	}
	//ViewDashBoardReports a = new ViewDashBoardReports(); 
	Thread.sleep(1000);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_Page_Open(driver);
//	RefreshAndPaginination(driver);
//	Enterprise_Employee_Role_Based_Payroll_Report_Verify_Role_Based_Payroll_Search(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Today(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Today(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Yesterday(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Yesterday(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_N_Days(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_N_Days(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_This_Week(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_This_Week(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_Week(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_Week(driver); 
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_7_days(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_7_days(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_This_Month(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_This_Month(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_Month(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_Month(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_30_days(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_30_days(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Specific_Date(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Specific_Date(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Hours_Date_Range(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range(driver);
	Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Hours_Date_Range(driver);
	
	
	Thread.sleep(1500);
}

@Test(priority=50,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_Page_Open(WebDriver driver) throws Exception
{
	
	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(5000);
	//Load the Employee Attendance Report Page
	//Load the Menu Item sales report page
			driver.get(Utility.getProperty("baseURL")+"enterprise/enterpriseReports/employee/payrollReport");

			Thread.sleep(5000);
			//Verify the Loyalty report page loaded or not
//			cmp.VerifyMainScreenPageHeader("Gift Card");
			
			try
			{
				//Verify the Menu Item sales report page loaded or not
				repts.Verify_ReportHomePage("ENTERPRISE PAYROLL REPORT");
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
		//	cmp.VerifyPagination_and_Refresh_Publish();
	
		//Verify Column Filtration
		cmp.Filter_Columns();
	
		//Ascending and Descending Sorting
		cmp.Ascending_And_Descending_Order();
	}

	@Test(priority=5,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Verify_Role_Based_Payroll_Search(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
		Thread.sleep(1000);
		//Select stores
		repts.Select_Store_inEmployeeRoleBased_EnterpriseReport("Select All");
		
		
		//Select Employee
		repts.Select_Employee("All");
		
		Thread.sleep(1000);
		//Select the Process
		repts.Select_Process("Daily");

		//Select Format
		repts.Select_FormatType("In Time");

		//Select Status
		repts.Select_Status("All");
	
		Thread.sleep(1000);
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(10000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.PASS, "No Enterprise Employee Role Based Payroll Report available for Selected Time Period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.INFO, "Enterprise Employee Role Based Payroll Report for selected time period is Available");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		}
		
		Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
		//Select Employee
		repts.Select_Employee("All");
		
		Thread.sleep(1000);
		//Select the Process
		repts.Select_Process("Daily");

		//Select Format
		repts.Select_FormatType("In Time");

		//Select Status
		repts.Select_Status("All");
	
				Thread.sleep(1000);
				//Select Today
				repts.Select_Last_N_Days_TimePeriod("10");
				
				Thread.sleep(1000);
				//Click Apply
				repts.Click_ApplyButton(); 
				
				
				Thread.sleep(10000);
				try
				{
				if(repts.No_TransactionFound_InfoMessage().isDisplayed())
				{
					test.log(LogStatus.INFO, "Employee - Role Based Payroll Report Not Available for Selected Time Period");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception G)
				{
					
					test.log(LogStatus.PASS, "Employee - Role Based Payroll Report Available for Selected Time Period");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
					Thread.sleep(15000);
					//Select stores
					repts.Select_Store_inEmployeeRoleBased_EnterpriseReport("Select All");
					
					
					Thread.sleep(1000);
					//Select Employee
					repts.Select_Employee("All");
					
					Thread.sleep(1000);
					//Select the Process
					repts.Select_Process("Daily");

					//Select Format
					repts.Select_FormatType("In Time");

					//Select Status
					repts.Select_Status("Active");
				
					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("10");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(15000);
					try
					{
					if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Employee - Role Based Payroll Report is Available for Searched Format -In Time & Status - Active (Daily)");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Employee - Role Based Payroll Report is Not Available for Searched Format -In Time & Status - Active (Daily)");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
					Thread.sleep(1000);
					//Select stores
					repts.Select_Store_inEmployeeRoleBased_EnterpriseReport("Select All");
					
					
					Thread.sleep(1000);
					//Select Employee
					repts.Select_Employee("All");
					
					Thread.sleep(1000);
					//Select the Process
					repts.Select_Process("Daily");

					//Select Format
					repts.Select_FormatType("In Time");

					//Select Status
					repts.Select_Status("Inactive");
				
					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("10");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(10000);
					try
					{
					if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Role Based Payroll Report is Available for Searched Format -In Time & Status - Inactive (Daily)");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Role Based Payroll Report is Not Available for Searched Format -In Time & Status - Inactive (Daily)");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
					Thread.sleep(1000);
					//Select stores
					repts.Select_Store_inEmployeeRoleBased_EnterpriseReport("Select All");
					
					
					
					Thread.sleep(1000);
					//Select Employee
					repts.Select_Employee("All");
					
					Thread.sleep(1000);
					//Select the Process
					repts.Select_Process("Daily");

					//Select Format
					repts.Select_FormatType("In Hours");

					//Select Status
					repts.Select_Status("Active");
					
					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("10");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(10000);
					try
					{
					if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Role Based Payroll Report is Available for Searched Format -In Hours & Status - Active (Daily)");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Role Based Payroll Report is Not Available for Searched Format -In Hours & Status - Active (Daily)");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
					Thread.sleep(1000);
					//Select stores
					repts.Select_Store_inEmployeeRoleBased_EnterpriseReport("Select All");
					
					
					Thread.sleep(1000);
					//Select Employee
					repts.Select_Employee("All");
					
					Thread.sleep(1000);
					//Select the Process
					repts.Select_Process("Daily");

					//Select Format
					repts.Select_FormatType("In Hours");

					//Select Status
					repts.Select_Status("Inactive");
					
					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("10");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(10000);
					try
					{
					if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Role Based Payroll Report is Available for Searched Format -In Hours & Status - InActive (Daily)");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Role Based Payroll Report is Not Available for Searched Format -In Hours & Status - InActive (Daily)");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
				
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

					Thread.sleep(1000);
					//Select stores
					repts.Select_Store_inEmployeeRoleBased_EnterpriseReport("Select All");
					
					
					Thread.sleep(1000);
					//Select Employee
					repts.Select_Employee("All");
					
					Thread.sleep(1000);
					//Select the Process
					repts.Select_Process("Weekly");

					//Select Format
					repts.Select_FormatType("In Time");

					//Select Status
					repts.Select_Status("Active");
				
					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("10");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(10000);
					try
					{
					if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Employee - Role Based Payroll Report is Available for Searched Format -In Time & Status - Active (Weekly)");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Employee - Role Based Payroll Report is Not Available for Searched Format -In Time & Status - Active (Weekly)");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
					Thread.sleep(1000);
					//Select stores
					repts.Select_Store_inEmployeeRoleBased_EnterpriseReport("Select All");
					
					
					Thread.sleep(1000);
					//Select Employee
					repts.Select_Employee("All");
					
					Thread.sleep(1000);
					//Select the Process
					repts.Select_Process("Weekly");

					//Select Format
					repts.Select_FormatType("In Time");

					//Select Status
					repts.Select_Status("Inactive");
				
					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("10");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(10000);
					try
					{
					if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Role Based Payroll Report is Available for Searched Format -In Time & Status - Inactive (Weekly)");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Role Based Payroll Report is Not Available for Searched Format -In Time & Status - Inactive (Weekly)");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
					Thread.sleep(1000);
					//Select stores
					repts.Select_Store_inEmployeeRoleBased_EnterpriseReport("Select All");
					
					
					
					Thread.sleep(1000);
					//Select Employee
					repts.Select_Employee("All");
					
					Thread.sleep(1000);
					//Select the Process
					repts.Select_Process("Weekly");

					//Select Format
					repts.Select_FormatType("In Hours");

					//Select Status
					repts.Select_Status("Active");
					
					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("10");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(10000);
					try
					{
					if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Role Based Payroll Report is Available for Searched Format -In Hours & Status - Active (Weekly)");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Role Based Payroll Report is Not Available for Searched Format -In Hours & Status - Active (Weekly)");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
					Thread.sleep(1000);
					//Select stores
					repts.Select_Store_inEmployeeRoleBased_EnterpriseReport("Select All");
					
					
					Thread.sleep(1000);
					//Select Employee
					repts.Select_Employee("All");
					
					Thread.sleep(1000);
					//Select the Process
					repts.Select_Process("Weekly");

					//Select Format
					repts.Select_FormatType("In Hours");

					//Select Status
					repts.Select_Status("Inactive");
					
					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("10");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(10000);
					try
					{
					if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Role Based Payroll Report is Available for Searched Format -In Hours & Status - InActive (Weekly)");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Role Based Payroll Report is Not Available for Searched Format -In Hours & Status - InActive (Weekly)");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					Thread.sleep(1000);
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
					Thread.sleep(1000);
					//Select stores
					repts.Select_Store_inEmployeeRoleBased_EnterpriseReport("Select All");
					
					
					Thread.sleep(1000);
					//Select Employee
					repts.Select_Employee("All");
					
					Thread.sleep(1000);
					//Select the Process
					repts.Select_Process("Daily");

					//Select Format
					repts.Select_FormatType("In Time");

					//Select Status
					repts.Select_Status("All");
					
					//Select Role
					repts.Select_Role("Manager");
					
					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("10");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(10000);
					try
					{
					if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Role Based Payroll Report is Available for Searched Role  (Daily)");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Role Based Payroll Report is Not Available for Searched Role (Daily)");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					Thread.sleep(1000);
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
					Thread.sleep(1000);
					//Select stores
					repts.Select_Store_inEmployeeRoleBased_EnterpriseReport("Select All");
					
					
					Thread.sleep(1000);
					//Select Employee
					repts.Select_Employee("All");
					
					Thread.sleep(1000);
					//Select the Process
					repts.Select_Process("Weekly");

					//Select Format
					repts.Select_FormatType("In Time");

					//Select Status
					repts.Select_Status("All");
					
					//Select Role
					repts.Select_Role("Manager");
					
					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_N_Days_TimePeriod("10");
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(10000);
					try
					{
					if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).isDisplayed())
					{
						test.log(LogStatus.PASS, "Role Based Payroll Report is Available for Searched Role  (Weekly)");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Role Based Payroll Report is Not Available for Searched Role (Weekly)");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
	}
	
	
	@Test(priority=52,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Today(WebDriver driver) throws Exception
	{
		double CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip,OverAll_Tip;

	 	
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		Thread.sleep(2000);
	//Select stores
	repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	

				
	Thread.sleep(2000);
	//Select the Employee option
	repts.Select_Employee("All");
	Thread.sleep(1000);

	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
  	
	//Select the Today
	repts.Select_Today_TimePeriod();
	
	//Select the Format
	repts.Select_FormatType("In Time");

	//Select the Format
	repts.Select_Status("All");

	//Select the Role
	repts.Select_Role("All");

	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(40000);
	   
	
//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date (Daily -Today)");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date (Daily -Today)");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily - Today) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily - Today) *******");

	
	repts.Select_LastPage_Pagination_InReport();
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}


	}
	
	@Test(priority=53,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Today(WebDriver driver) throws Exception
	{

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
		
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Weekly
	repts.Select_Process("Weekly");   
	
	//Select the Date Range
	repts.Select_Today_TimePeriod();
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");


	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date (Weekly -Today)");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date (Weekly -Today)");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time((Weekly -Today)) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time((Weekly -Today)) *******");

	
	repts.Select_LastPage_Pagination_InReport();
	
	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	
	
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily Today : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily Today : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in Today  : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-Today)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-Today). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily Today : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in Today  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-Today)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-Today). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily Today : "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in Today  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily Today : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in Today  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily Today : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in Today  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily Today : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in Today  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (Today)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily Today : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in Today  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily Today : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in Today  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (Today)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily Today : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in Today  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
	//Get Total Tips
	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily Today : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in Today  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily Today : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in Today  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily Today : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in Today  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily Today : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in Today  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (Today)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (Today). Diff is : "+diff);
	}
	
}
	
	


	}
	
	@Test(priority=54,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Yesterday(WebDriver driver) throws Exception
	{
	double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;

	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily	
	repts.Select_Process("Daily");   
	
	//Select the Yesterday
	repts.Select_Yesterday_TimePeriod();
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");

	//Select the Role
	repts.Select_Role("All");

	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date (Daily -Yesterday)");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date (Daily -Yesterday)");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time((Daily -Yesterday)) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time((Daily -Yesterday)) *******");

	repts.Select_LastPage_Pagination_InReport();

	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}

	
	}
	
	@Test(priority=55,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Yesterday(WebDriver driver) throws Exception
	{


	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");

	Thread.sleep(1000);
	//Select the Process as Weekly	
	repts.Select_Process("Weekly");   

	//Select Yesterday
	repts.Select_Yesterday_TimePeriod();
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");

	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	
	
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily Yesterday : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily Yesterday : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in Yesterday  : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-Yesterday)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-Yesterday). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily Yesterday : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in Yesterday  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-Yesterday)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-Yesterday). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily Yesterday : "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in Yesterday  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily Yesterday : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in Yesterday  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily Yesterday : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in Yesterday  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily Yesterday : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in Yesterday  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (Yesterday)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily Yesterday : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in Yesterday  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily Yesterday : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in Yesterday  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily Yesterday : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in Yesterday  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
	//Get Total Tips
	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily Yesterday : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in Yesterday  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily Yesterday : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in Yesterday  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily Yesterday : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in Yesterday  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily Yesterday : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in Yesterday  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (Yesterday)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (Yesterday). Diff is : "+diff);
	}
	
}
	
	
	

	}

	
	@Test(priority=56,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_N_Days(WebDriver driver) throws Exception
	{
		double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;

	 	
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
	//Select the Date Range
	repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");

	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(60000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;*/

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}


	}
	
	@Test(priority=57,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_N_Days(WebDriver driver) throws Exception
	{

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");

	Thread.sleep(1000);
	//Select the Process as Weekly
	repts.Select_Process("Weekly");   
	
 	//Select the Last N Days
	repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	Thread.sleep(1000);
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily Last N days : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily Last N days : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in Last N days  : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-Last N days)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-Last N days). Diff is : "+diff);
	}
	 
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily Last N days : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in Last N days  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-Last N days)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-Last N days). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily Last N days : "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in Last N days  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily Last N days : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in Last N days  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily Last N days : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in Last N days  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily Last N days : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in Last N days  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (Last N days)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily Last N days : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in Last N days  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily Last N days : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in Last N days  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (Last N days)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily Last N days : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in Last N days  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}
	
	//Get Total Tips
/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily Last N days : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in Last N days  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}*/
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily Last N days : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in Last N days  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily Last N days : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in Last N days  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Tip Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Tip Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily Last N days : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in Last N days  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (Last N days)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (Last N days). Diff is : "+diff);
	}
	
}


	
	}
	
	
	@Test(priority=58,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_This_Week(WebDriver driver) throws Exception
	{
	double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;

	 	
	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
	//Select the Date Range
	repts.Select_This_Week_TimePeriod();

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");

	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;*/

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}



	}
	
	@Test(priority=59,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_This_Week(WebDriver driver) throws Exception
	{

		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		
		//Select stores
		//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
		
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Weekly
	repts.Select_Process("Weekly");   
	
  	//Select the Date Range
	repts.Select_This_Week_TimePeriod();

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	//Get Reg Pay
	System.out.println("Reg Pay values from Daily This Week : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily This Week : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in This Week  : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-This Week)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-This Week). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily This Week : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in This Week  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-This Week)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-This Week). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily This Week : "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in This Week  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily This Week : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in This Week  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily This Week : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in This Week  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily This Week : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in This Week  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (This Week)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily This Week : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in This Week  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily This Week : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in This Week  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (This Week)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily This Week : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in This Week  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}
	
	//Get Total Tips
	/*String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily This Week : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in This Week  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}*/
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily This Week : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in This Week  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily This Week : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in This Week  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily This Week : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in This Week  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (This Week)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (This Week). Diff is : "+diff);
	}
	
}
	

	}

	@Test(priority=60,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_Week(WebDriver driver) throws Exception
	{
	double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;

	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
	//Select the Date Range
	repts.Select_Last_Week_TimePeriod();
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");

	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;*/

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}


	}
	
	@Test(priority=61,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_Week(WebDriver driver) throws Exception
	{


	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Weekly	
	repts.Select_Process("Weekly");   
	
 	//Select the Date Range
	repts.Select_Last_Week_TimePeriod();

	//Select the Format
	repts.Select_FormatType("In Time");

	//Select the Format
	repts.Select_Status("All");

	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	
	
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily Last Week : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily Last Week : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in Last Week  : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-Last Week)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-Last Week). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily Last Week : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in Last Week  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-Last Week)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-Last Week). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily Last Week : "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in Last Week  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily Last Week : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in Last Week  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily Last Week : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in Last Week  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily Last Week : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in Last Week  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (Last Week)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily Last Week : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in Last Week  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily Last Week : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in Last Week  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (Last Week)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily Last Week : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in Last Week  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}
	
	//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily Last Week : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in Last Week  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}*/
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily Last Week : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in Last Week  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily Last Week : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in Last Week  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily Last Week : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in Last Week  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (Last Week)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (Last Week). Diff is : "+diff);
	}
	
}

	}

	@Test(priority=62,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_7_days(WebDriver driver) throws Exception
	{
	double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;

	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");

	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
  	//Select the Last 7 days
	repts.Select_Last_7_Days_TimePeriod();
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;*/

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}


	}
	
	@Test(priority=63,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_7_days(WebDriver driver) throws Exception
	{


	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Weekly	
	repts.Select_Process("Weekly");   
	
	//Select the Last 7days
	repts.Select_Last_7_Days_TimePeriod();

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	
	
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily Last 7 days : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily Last 7 days : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in Last 7 days  : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-Last 7 days)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-Last 7 days). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily Last 7 days : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in Last 7 days  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-Last 7 days)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-Last 7 days). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily Last 7 days : "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in Last 7 days  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily Last 7 days : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in Last 7 days  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily Last 7 days : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in Last 7 days  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily Last 7 days : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in Last 7 days  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (Last 7 days)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily Last 7 days : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in Last 7 days  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily Last 7 days : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in Last 7 days  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily Last 7 days : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in Last 7 days  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}
	
	//Get Total Tips
	/*String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily Last 7 days : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in Last 7 days  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}*/
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily Last 7 days : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in Last 7 days  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily Last 7 days : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in Last 7 days  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily Last 7 days : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in Last 7 days  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (Last 7 days)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (Last 7 days). Diff is : "+diff);
	}
	
}	
	
	

	}

	
	@Test(priority=64,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_This_Month(WebDriver driver) throws Exception
	{
	double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;
	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	

	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily	
	repts.Select_Process("Daily");   
	
  	//Select the Date Range
	repts.Select_This_Month_TimePeriod();
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;*/

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}


	}
	
	@Test(priority=65,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_This_Month(WebDriver driver) throws Exception
	{


	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Weekly	
	repts.Select_Process("Weekly");   
	
  	//Select the This Month
	repts.Select_This_Month_TimePeriod();

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	
	
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily This Month : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily This Month : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in This Month : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-This Month)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-This Month). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily This Month : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in This Month  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-This Month)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-This Month). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily This Month: "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in This Month  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily This Month : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in This Month  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily This Month : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in This Month  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily This Month : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in This Month  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (This Month)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily This Month : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in This Month  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily This Month : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in This Month  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (This Month)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily This Month : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in This Month  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}
	
	//Get Total Tips
	/*String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily This Month : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in This Month  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}*/
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily This Month : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in This Month  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily This Month : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in This Month  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily This Month : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in This Month  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (This Month)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (This Month). Diff is : "+diff);
	}
	
}	
	
	

	}

	@Test(priority=66,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_Month(WebDriver driver) throws Exception
	{
	double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;

	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");

	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
	//Select the Last Month	
	repts.Select_Last_Month_TimePeriod();
		
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Actual Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;*/

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}


	}
	
	@Test(priority=67,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_Month(WebDriver driver) throws Exception
	{


	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Weekly
	repts.Select_Process("Weekly");   
	
	//Select the Last Month
	repts.Select_Last_Month_TimePeriod();

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	
	
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily Last Month : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily Last Month : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in Last Month : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-Last Month)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-Last Month). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily Last Month : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in Last Month  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-Last Month)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-Last Month). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily Last Month: "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in Last Month  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily Last Month : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in Last Month  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily Last Month : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in Last Month  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily Last Month : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in Last Month  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (Last Month)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily Last Month : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in Last Month  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily Last Month : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in Last Month  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (Last Month)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily Last Month : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in Last Month  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}
	
	//Get Total Tips
	/*String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily Last Month : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in Last Month  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}*/
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily Last Month : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in Last Month  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily Last Month : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in Last Month  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily Last Month : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in Last Month  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (Last Month)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (Last Month). Diff is : "+diff);
	}
	
}	
	
	

	}
	
	
	@Test(priority=68,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Last_30_days(WebDriver driver) throws Exception
	{
	double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;

	 	
	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
  //Select the Last 30 days
	repts.Select_Last_30_Days_TimePeriod();
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	

	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;*/

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
}


	}
	
	@Test(priority=69,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Last_30_days(WebDriver driver) throws Exception
	{


	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Weekly
	repts.Select_Process("Weekly");   
	
 	//Select the Date Range
	repts.Select_Last_30_Days_TimePeriod();

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");

	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	
	
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily Last 30 days : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily Last 30 days : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in Last 30 days : "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly-Last 30 days)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly-Last 30 days). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily Last 30 days : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in Last 30 days  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly-Last 30 days)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-Last 30 days). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily Last 30 days: "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly in Last 30 days  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily Last 30 days : "+CC_Tip);

	System.out.println("CC Tip values for Weekly in Last 30 days  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily Last 30 days : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly in Last 30 days  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily Last 30 days : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly in Last 30 days  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (Last 30 days)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily Last 30 days : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly in Last 30 days  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily Last 30 days : "+Other_Tip);

	System.out.println("Other Tip values for Weekly in Last 30 days  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily Last 30 days : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly in Last 30 days  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}
	
	//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily Last 30 days : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly in Last 30 days  : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}*/
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily Last 30 days : "+Net_Sales);

	System.out.println("Net Sales values for Weekly in Last 30 days  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily Last 30 days : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly in Last 30 days  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily Last 30 days : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly in Last 30 days  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}
	
}	
	
	

	}


	
	@Test(priority=70,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_Specific_Date(WebDriver driver) throws Exception
	{
	double OverAll_Tip,CC_Tip,Reg_Pay,OT_Pay,TTL_Pay,Tip_Charge,Gratuity_Pay,Emp_CCTip,Other_Tip,Declared_CashTip,Total_Tip,Net_Sales,Expected_Tip;

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	Thread.sleep(1000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
 	//Select the Specific date
	repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(1000);
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	

	

	
	
	//Get Reg Pay
	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	Reg_Pay=Double.parseDouble(TotalRegPay);
	
	this.Reg_Pay=Reg_Pay;
	
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	OT_Pay=Double.parseDouble(TotalOTPay);
	this.OT_Pay=OT_Pay;


	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	TTL_Pay=Double.parseDouble(TotalPay);
	this.TTL_Pay=TTL_Pay;

	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	CC_Tip=Double.parseDouble(ccTip);
	
	this.CC_Tip=CC_Tip;

	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	Tip_Charge=Double.parseDouble(Tipcharge);
	this.Tip_Charge=Tip_Charge;
	
	

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	Gratuity_Pay=Double.parseDouble(gratuity);
	this.Gratuity_Pay=Gratuity_Pay;
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	Emp_CCTip=Double.parseDouble(Emp_cc_tip);
	this.Emp_CCTip=Emp_CCTip;

	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	Other_Tip=Double.parseDouble(otherTips);
	this.Other_Tip=Other_Tip;
	
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	Declared_CashTip=Double.parseDouble(declaredCashTip);
	this.Declared_CashTip=Declared_CashTip;
	
	
	//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	Total_Tip=Double.parseDouble(ttltip);
	this.Total_Tip=Total_Tip;*/

	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	Net_Sales=Double.parseDouble(netSales);
	this.Net_Sales=Net_Sales;
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	Expected_Tip=Double.parseDouble(expectedTip);
	this.Expected_Tip=Expected_Tip;
	
	//Get Over All Tip
	String overTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overTip);	
	test.log(LogStatus.INFO, "Total Over All Tip Tip is : "+overTip);
	OverAll_Tip=Double.parseDouble(overTip);
	this.OverAll_Tip=OverAll_Tip;
	
	Thread.sleep(1000);
	//To Get Employee List
	List<WebElement> empList=driver.findElements(By.xpath("//tr[@style='background-color:']/td[@data-title-text='Role']/div"));
	
	for(WebElement empEach:empList)
	{
	Thread.sleep(2000);
	if(empEach!=null)
	{
test.log(LogStatus.PASS, "Role Name Available");

Thread.sleep(1500);
String EmpName=empEach.getText();
//String str=EmpName.substring(1, EmpName.length()-1);

try
{
String empRollinSummary=driver.findElement(By.xpath("//td[contains(.,'"+EmpName+" - Summary')]/../td[@data-title-text='Role ID']/div")).getText();

if(empRollinSummary!=null)
{
	test.log(LogStatus.PASS, "Role ID Displayed in Summary. Displayed Role Name : "+empRollinSummary+" Role ID is : "+empRollinSummary);
}
}
catch(Exception lk)
{
	test.log(LogStatus.FAIL, "Role ID not Displayed in Summary");
}

	}
	else
	{
test.log(LogStatus.FAIL, "Role Name not available");
	}
	
	
	
	}
	
	
	
	
}


	}
	
	@Test(priority=71,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_Specific_Date(WebDriver driver) throws Exception
	{


	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	
	Thread.sleep(2000);
	//Select the Employee option
	repts.Select_Employee("All");
	
	Thread.sleep(1000);
	//Select the Process as Weekly
	repts.Select_Process("Weekly");   
	
    //Select the Specific date
	repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));

	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");

	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

	
	
	
	//Get Reg Pay
	System.out.println("Reg Pay values from Daily - Specific Date : "+Reg_Pay);

	String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPay);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
	String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Axtaul Reg Pay :"+TotalRegPay);
	double RegPay=Double.parseDouble(TotalRegPay);
	System.out.println("Reg Pay values from Daily - Specific Date : "+Reg_Pay);

	System.out.println("Regular Pay values for Weekly in - Specific Date: "+RegPay);

	if(Reg_Pay==RegPay)
	{
	test.log(LogStatus.PASS, "Reg Pay Values is Correct for (Daily to Weekly- Specific Date)");
	}
	else
	{
	double diff=Reg_Pay-RegPay;
	test.log(LogStatus.FAIL, "Reg Pay Values is Incorrect for (Daily to Weekly- Specific Date). Diff is : "+diff);
	}
	
	//Get OT Pay
	String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPay);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
	String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPay=Double.parseDouble(TotalOTPay);

	System.out.println("OT Pay values from Daily - Specific Date : "+OT_Pay);

	System.out.println("OT Pay values for Weekly in - Specific Date  : "+OTPay);

	
	if(OT_Pay==OTPay)
	{
	test.log(LogStatus.PASS, "OT Pay Values is Correct for (Daily to Weekly- Specific Date)");
	}
	else
	{
	double diff=OT_Pay-OTPay;
	test.log(LogStatus.FAIL, "OT Pay Values is InCorrect for Weekly (Daily to Weekly-- Specific Date). Diff is : "+diff);
	}
	

	//Get TTL Pay
	String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPay);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
	String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double TTLPay=Double.parseDouble(TotalPay);
	
	System.out.println("Reg Pay values from Daily- Specific Date: "+TTL_Pay);

	System.out.println("Regular Pay values for Weekly - Specific Date  : "+TTLPay);

	
	if(TTL_Pay==TTLPay)
	{
	test.log(LogStatus.PASS, "TTL Pay Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=TTL_Pay-TTLPay;
	test.log(LogStatus.FAIL, "TTL Pay Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}
	
	//Get CC Tip
	String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTip);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
	double CCTip=Double.parseDouble(ccTip);
	
	System.out.println("CC Tip values from Daily - Specific Date : "+CC_Tip);

	System.out.println("CC Tip values for Weekly - Specific Date  : "+CCTip);


	if(CC_Tip==CCTip)
	{
	test.log(LogStatus.PASS, "CC Tip Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=CC_Tip-CCTip;
	test.log(LogStatus.FAIL, "CC Tip Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}
	
	//Get Tip Charge Tip
	String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+Tipcharge);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
	double TipCharge=Double.parseDouble(Tipcharge);
	
	
	System.out.println("Tip Charge values from Daily - Specific Date : "+Tip_Charge);

	System.out.println("Tip Charge values for Weekly - Specific Date  : "+TipCharge);

	
	if(Tip_Charge==TipCharge)
	{
	test.log(LogStatus.PASS, "Tip Charge Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=Tip_Charge-TipCharge;
	test.log(LogStatus.FAIL, "Tip Charge Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}

	//Get Gratuity
	String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuity);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
	double GratuityPay=Double.parseDouble(gratuity);
	
	
	System.out.println("Gratuity values from Daily - Specific Date : "+Gratuity_Pay);

	System.out.println("Gratuity values for Weekly - Specific Date  : "+GratuityPay);

	
	if(Gratuity_Pay==GratuityPay)
	{
	test.log(LogStatus.PASS, "Gratuity Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=Gratuity_Pay-GratuityPay;
	test.log(LogStatus.FAIL, "Gratuity Values is InCorrect for Weekly (- Specific Date)");
	}
	
	//Get Emp CC Tip
	String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
	double EmpCCTip=Double.parseDouble(Emp_cc_tip);

	System.out.println("Emp CC Tip values from Daily - Specific Date : "+Emp_CCTip);

	System.out.println("Emp CC Tip values for Weekly - Specific Date  : "+EmpCCTip);

	
	if(Emp_CCTip==EmpCCTip)
	{
	test.log(LogStatus.PASS, "Emp CC Tip Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=Emp_CCTip-EmpCCTip;
	test.log(LogStatus.FAIL, "Emp CC Tip Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}
	
	//Get Other Tip
	String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTips);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
	double OtherTip=Double.parseDouble(otherTips);
	
	
	System.out.println("Other Tip values from Daily - Specific Date : "+Other_Tip);

	System.out.println("Other Tip values for Weekly - Specific Date  : "+OtherTip);

	
	if(Other_Tip==OtherTip)
	{
	test.log(LogStatus.PASS, "Other Tips Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	
	double diff=Other_Tip-OtherTip;
	test.log(LogStatus.FAIL, "Other Tips Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}
	
	//Get Declared Cash Tip
	String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
	double DeclaredCashTip=Double.parseDouble(declaredCashTip);
	
	System.out.println("Declared Cash Tip values from Daily - Specific Date : "+Declared_CashTip);

	System.out.println("Declared Cash Tip values for Weekly - Specific Date  : "+DeclaredCashTip);

	
	
	if(Declared_CashTip==DeclaredCashTip)
	{
	test.log(LogStatus.PASS, "Declared Cash Tip Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=Declared_CashTip-DeclaredCashTip;
	test.log(LogStatus.FAIL, "Declared Cash Tip Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}
	
	//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltip);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
	double TotalTip=Double.parseDouble(ttltip);

	System.out.println("TTL Tip values from Daily - Specific Date : "+Total_Tip);

	System.out.println("TTL Tip values for Weekly - Specific Date : "+TotalTip);

	
	if(Total_Tip==TotalTip)
	{
	test.log(LogStatus.PASS, "Total Tip Values is Correct for Weekly (Last 30 days)");
	}
	else
	{
	double diff=Total_Tip-TotalTip;
	test.log(LogStatus.FAIL, "Total Tip Values is InCorrect for Weekly (Last 30 days). Diff is : "+diff);
	}*/
	
	//Get Net Sales
	String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSales);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
	double NetSales=Double.parseDouble(netSales);
	
	
	System.out.println("Net Sales values from Daily - Specific Date : "+Net_Sales);

	System.out.println("Net Sales values for Weekly - Specific Date  : "+NetSales);

	
	if(Net_Sales==NetSales)
	{
	test.log(LogStatus.PASS, "Net Sale Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=Net_Sales-NetSales;
	test.log(LogStatus.FAIL, "Net Sale Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}
	
	//Get Expected Tip
	String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTip);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
	double ExpectedTip=Double.parseDouble(expectedTip);
	
	System.out.println("Expected Tip values from Daily - Specific Date : "+Expected_Tip);

	System.out.println("Expected Tip values for Weekly - Specific Date  : "+ExpectedTip);

	
	if(Expected_Tip==ExpectedTip)
	{
	test.log(LogStatus.PASS, "Expected Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=Expected_Tip-ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}
	
	
	//Get Over All Tip
	String overAllTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+overAllTip);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+overAllTip);
	double OverAllTip=Double.parseDouble(overAllTip);
	
	System.out.println("Over All Tip values from Daily - Specific Date : "+OverAll_Tip);

	System.out.println("Over All Tip values for Weekly - Specific Date  : "+OverAllTip);

	
	if(OverAll_Tip==OverAllTip)
	{
	test.log(LogStatus.PASS, "Over All Tip Values is Correct for Weekly (- Specific Date)");
	}
	else
	{
	double diff=OverAll_Tip-OverAllTip;
	test.log(LogStatus.FAIL, "Over All Tip Values is InCorrect for Weekly (- Specific Date). Diff is : "+diff);
	}
	
}	
	
	
	
	
	//To Get Employee List
	List<WebElement> empList=driver.findElements(By.xpath("//tr[@style='background-color:']/td[@data-title-text='Role']/div"));
	
	for(WebElement empEach:empList)
	{
	if(empEach!=null)
	{
test.log(LogStatus.PASS, "Role Name Available");

String EmpName=empEach.getText();
//String str=EmpName.substring(1, EmpName.length()-1);

String empRollinSummary=driver.findElement(By.xpath("//td[contains(.,'"+EmpName+" - Summary')]/../td[@data-title-text='Role ID']/div")).getText();

if(empRollinSummary!=null)
{
	test.log(LogStatus.PASS, "Role ID Displayed in Summary. Displayed Role Name : "+empRollinSummary+" Role ID is : "+empRollinSummary);
}
else
{
	test.log(LogStatus.FAIL, "Role ID not Displayed in Summary");
}

	}
	else
	{
test.log(LogStatus.FAIL, "Role Name not available");
	}
	
	
	
	}
	
	
	

	}
	
	
	@Test(priority=72,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range(WebDriver driver) throws Exception
	{

	double OverAll_Tip_Dly,Over_All_Pay_Dly,Tip_Shared_Dly,Expected_Tip_Dly;

	 	
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	

	test.log(LogStatus.INFO, "Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range Starts");
	
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	Thread.sleep(2000);
	//Select the Employee option
	repts.Select_Employee("QA Test");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
  	
	//Select the Date Range
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");

	//Select the Role
	repts.Select_Role("All");
	
	//Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	   
	
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
	
	}

	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Daily) *******");
	
	repts.Select_LastPage_Pagination_InReport();

	
	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	Thread.sleep(2000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	Thread.sleep(1000);
	//Get Per Rate value
	/*String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Per Rate is : "+perRate);
	
	test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
	
	//Get Reg Hours
	String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total Reg Hours is : "+regHours);
	
	test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
	*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();
	
	System.out.println("Total OT Hours is : "+otHours);
	
	test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/

	
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	//Get OT Hours
	/*	String otHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[8]")).getText();

System.out.println("Total OT Hours is : "+otHours);

test.log(LogStatus.INFO, "Total OT Hours is : "+otHours);*/
	//Get Total Hours
	/*String hours = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	
	System.out.println("Total Hours is : "+hours);
	
	test.log(LogStatus.INFO, "Total Hours is : "+hours);*/
	
	WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
	JavascriptExecutor js1=(JavascriptExecutor)driver;
	js1.executeScript("arguments[0].scrollIntoView(true);", ele);
	
	Thread.sleep(1000);
	//Get Reg Pay
	String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPayDt);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
	String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Actual Reg Pay :"+TotalRegPayDt);
	double RegPayDt=Double.parseDouble(TotalRegPayDt);
	 
	
	//Get OT Pay
	String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPayDt);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
	String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPayDt=Double.parseDouble(TotalOTPayDt);
	
	
	//To Get Expected Total Pay
	double Expected_TTTLPayDt=RegPayDt+OTPayDt;
	

	//Get TTL Pay
	String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPayDt);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
	String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);
	
	
	if(Expected_TTTLPayDt==Actual_TTLPayDt)
	{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
	}
	else
	{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
	}
	
	//Get CC Tip
	String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTipDt);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
	double CC_TipDt=Double.parseDouble(ccTipDt);
	 
	
	//Get Tip Charge Tip
	String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+TipchargeDt);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
	double Tip_ChargeDt=Double.parseDouble(TipchargeDt);
	
	//To Calculate Actual Employee Tip 
	double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;
	
	
	//Get Gratuity
	String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuityDt);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
	double GratuityDt=Double.parseDouble(gratuityDt);
	
	
	//Get Online Tips
	String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
	test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
	double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);
	
	//Get Driver Compensation
	String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total DRV Comp is : "+driverCompDt);	
	test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
	double Driver_Comp_Dt=Double.parseDouble(driverCompDt);
	
	
	//Get Emp CC Tip
	String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
	double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);
	
	//Check whether the Exmployee Tip is Equal or not
	if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
	{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
	}
	else
	{	
	double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
	}
	
	//Get Other Tip
	String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Other Tip is : "+otherTipsDt);	
	test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
	double Other_TipsDt=Double.parseDouble(otherTipsDt);
	
	
	
	//Get Declared Cash Tip
	String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
	double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);
	
	
	
	//Get Total Tips
	/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltipDt);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
	double Actual_TTLTipDt=Double.parseDouble(ttltipDt);
	
	//To Calculate Expected Total Tip
	double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;
	
	
	//Check whether the Total Tip and Actual Tip is Equal or not
	if(Expected_TTLTipDt==Actual_TTLTipDt)
	{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
	}
	else
	{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
	}*/
	
	//Get Net Sales
	String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSalesDt);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
	double NetSalesDt=Double.parseDouble(netSalesDt);
	
	//Get Expected Tip
	String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTipDt);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
	double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
	this.Expected_Tip=Actual_ExpectedTipDt;
	
	//To Get the Cash Tip Percentage
	String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
	double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);
	
	//Get the No of Employees
//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
//	int Emp_Count=empList.size();
	
	if(Cash_Tip_PercentageDt!=0.00)
	{
	//To Calculate Expected Cash Tip
	double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

	BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_Cash_TipDt=dd.doubleValue();
	
//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
	System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);

	
	//To Calculate No Cash Tip
	double No_Cash_TipDt=CC_TipDt+Other_TipsDt;
	
 
	//To Get Actual_Cash_Tip
	double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
//	Expected_Tip=Expected_Tip/Emp_Count;
	BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_TipDt=dd1.doubleValue();
	System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);
	
	
	
	if(Expected_TipDt==Actual_ExpectedTipDt)
	{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
	}
	else
	{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
	}
	}
	else
	{
	if(Actual_ExpectedTipDt==0.00)
	{
test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
	}
	
	
	

	
//	//To Get Tip Out Percentage
//	String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//	double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//	
//	//To Calculate Tip Out Contribution
//	double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//	
//	BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//	Expected_Tip_Out_ContDt=dd3.doubleValue();
//	
	//To Get Actual Tip Out Contribution from Report
	String Actual_TipOutConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[17]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
//	System.out.println("Total Tip Out Cont is : "+Actual_TipOutConDt);	
	test.log(LogStatus.INFO, "Total Tip Out Cont is : "+Actual_TipOutConDt);
	double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_TipOutConDt);
	System.out.println("Total Tip Out Cont is : "+Actual_Tip_Out_ContDt);	
	
	
//	//Check whether the Tip Out Contribution is Calculated or not
//	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//	{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//	}
//	else
//	{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//	}
//	
	
	//To Get Actual Tip Out Share from the Report
	String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[27]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Out Shared Tip is : "+Actual_Tip_Out_ShareDt);
	double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
	 
	
	//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
	}
	else
	{
	double Tip_Shared_Diff=Expected_Tip_Out_ContDt-Actual_Tip_Out_SharedDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
	}*/
	
	
	//To get Tip Adj from the Report
	String Actual_TipAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Adjust is : "+Actual_TipAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Adjusted Tip is : "+Actual_TipAdj_Dt);
	double Actual_Tip_Adj_Dt=Double.parseDouble(Actual_TipAdj_Dt);
	
	
	//To get Tip Adj from the Report
	String Actual_TipOutAdj_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'Tip Out Adj')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Out Adjust is : "+Actual_TipOutAdj_Dt);	
	test.log(LogStatus.INFO, "Total Tip Out Adjusted Tip is : "+Actual_TipOutAdj_Dt);
	double Actual_Tip_Out_Adj_Dt=Double.parseDouble(Actual_TipOutAdj_Dt);
	
	
	
	//To Get Actual Tip Shared from the Report
	String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[25]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
	double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
	this.Tip_Shared_Dly=Actual_Tip_SharedDt;
	
	
	double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+DeclaredCashTipDt+GratuityDt+Driver_Comp_Dt+OLO_Pkup_TipDt;
	System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);
	
	
	//Check whether the Actual and Expected Tip shared is Equal or not
	if(Expected_Tip_Shared==Actual_Tip_SharedDt)
	{
	test.log(LogStatus.PASS, "Tip Shared (Daily - In Time) Calculated successfully");
	}
	else
	{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Daily - In Time)  The Value Diffrence is : "+Tip_Difference);
	}
	
	
	//To calculate Over All Tip
	double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
	System.out.println("Over All Tip Before : "+OverAllTip);
	double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt;//+Actual_Tip_Out_Adj_Dt;
	
	
	
	//To Get Over All Tip from the Report
	String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
	OverAll_Tip_Dly=Double.parseDouble(Actual_OverAllTip_Dt);
	this.OverAll_Tip_Dly=OverAll_Tip_Dly;
	
	//Check whether the Actual and Expected Over all Tip is correct or not
	if(Expected_Over_All_Tip==OverAll_Tip_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Dly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	
	
	//To Calculate Over all Pay
	double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Dly;
	
	//To Get Actual Ovar All Pay
	String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[36]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
	test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
	Over_All_Pay_Dly=Double.parseDouble(Actual_OverAllPay_Dt);
	this.Over_All_Pay_Dly=Over_All_Pay_Dly;
	
	//Check whether the Actual and Expected Over all Pay is correct or not	
	if(Expected_OverPay==Over_All_Pay_Dly) 
	{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Daily - In Time)");
	}
	else
	{
	double diff=Expected_OverPay-Over_All_Pay_Dly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Daily - In Time). Diff is : "+diff);
	}
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s1="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s1));
	
	ArrayList<String> obtainedList = new ArrayList<String>(); 
	List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
	for(int i = 1; i <= elementList.size(); i++)
	{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z First : "+name[0]);
	obtainedList.add(name[0]);
	}
	ArrayList<String> sortedList = new ArrayList<String>();
	for(String s:obtainedList)
	{
	sortedList.add(s);
	}
	Collections.sort(sortedList);
	
	for(int i = 0; i < elementList.size(); i++)
	{	
	if(sortedList.equals(obtainedList))
	{

	}else
	{
test.log(LogStatus.FAIL, "Name sort is not working  for A-Z First Name");
	}
	}
}
Thread.sleep(1000);
driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

test.log(LogStatus.INFO, "Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Time_Date_Range End");
Thread.sleep(1000);


	}
	@Test(priority=73,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Hours_Date_Range(WebDriver driver) throws Exception
	{

	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);

	test.log(LogStatus.INFO, "Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Hours_Date_Range Starts");
	Thread.sleep(3000);
/*	JavascriptExecutor js=(JavascriptExecutor)driver;
	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));

	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
Thread.sleep(2000);
//Select the Employee option
	repts.Select_Employee("QA Test");
	
	Thread.sleep(1000);
	//Select the Process as Daily
	repts.Select_Process("Daily");   
	
	  	
	//Select the Date Range
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
//Select the Format
repts.Select_FormatType("In Hours");

//Select the Format
repts.Select_Status("All");

//Select the Role
repts.Select_Role("All");

//Click Apply
repts.Click_ApplyButton(); 
Thread.sleep(30000);
   
	//Check weather the report is available for the selected time period
	if(repts.No_TransactionFound_InfoMessage().isDisplayed())
	{
test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");
	
String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s));
	}
	else
	{
	
	test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Hours and Daily) is available for Specific Date");
	
	System.out.println("******* The Below is Employee Payroll Report for In Hours(Daily) *******");
	
	test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Daily) *******");
	
	repts.Select_LastPage_Pagination_InReport();

	List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
	Thread.sleep(1000);
//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);
	
	WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
	JavascriptExecutor js1=(JavascriptExecutor)driver;
	js1.executeScript("arguments[0].scrollIntoView(true);", ele);
	
	Thread.sleep(1000);
/*	//Get Per Rate value
	String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();
	
	System.out.println("Total Per Rate is : "+perRate);
	
	test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);
	
	//Get Reg Hours
	String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();
	
	System.out.println("Total Reg Hours is : "+regHours);
	
	test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
	*/	
	//Get Reg Pay
	String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
	System.out.println("Total Reg Pay is : "+regPayDt);
	test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
	String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double RegPayDt=Double.parseDouble(TotalRegPayDt);

	
	//Get OT Pay
	String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
	System.out.println("Total OT Pay is : "+otPayDt);	
	test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
	String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double OTPayDt=Double.parseDouble(TotalOTPayDt);
	
	
	//To Get Expected Total Pay
	double Expected_TTTLPayDt=RegPayDt+OTPayDt;
	

	//Get TTL Pay
	String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
	System.out.println("Total TTL Pay is : "+ttlPayDt);
	test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
	String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);
	
	
	if(Expected_TTTLPayDt==Actual_TTLPayDt)
	{
test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
	}
	else
	{
double Different=Expected_TTTLPayDt-Actual_TTLPayDt;

test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);

System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
	}
	
	//Get CC Tip
	String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total CC Tip is : "+ccTipDt);
	test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
	double CC_TipDt=Double.parseDouble(ccTipDt);
	 
	
	//Get Tip Charge Tip
	String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tip Charge is : "+TipchargeDt);	
	test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
	double Tip_ChargeDt=Double.parseDouble(TipchargeDt);
	
	//To Calculate Actual Employee Tip 
	double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;
	
	
	//Get Gratuity
	String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Gratuity is : "+gratuityDt);	
	test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
	double GratuityDt=Double.parseDouble(gratuityDt);
	
	//Get Emp CC Tip
	String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
	test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
	double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);
	
	//Check whether the Exmployee Tip is Equal or not
	if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
	{
test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
	}
	else
	{	
double diffrence_Emp_CC_TipDt=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_TipDt);
	}
	
	//Get Other Tip
	String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Other Tip is : "+otherTipsDt);	
	test.log(LogStatus.INFO, "Total Other Tip is : "+otherTipsDt);
	double Other_TipsDt=Double.parseDouble(otherTipsDt);
	
	
	
	//Get Declared Cash Tip
	String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
	test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
	double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);
	
	
	
	//Get Total Tips
/*	String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
	System.out.println("Total Tips is : "+ttltipDt);	
	test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
	double Actual_TTLTipDt=Double.parseDouble(ttltipDt);
	
	//To Calculate Expected Total Tip
	double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;
	
	//Check whether the Total Tip and Actual Tip is Equal or not
	if(Expected_TTLTipDt==Actual_TTLTipDt)
	{
test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
	}
	else
	{
double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
	}*/
	
	//Get Net Sales
	String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
	System.out.println("Total Net Sales is : "+netSalesDt);	
	test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
	double NetSalesDt=Double.parseDouble(netSalesDt);
	
	//Get Expected Tip
	String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+expectedTipDt);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
	double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
	
	
	//To Get the Cash Tip Percentage
/*	String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
	double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);
	
	//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

	//To Calculate Expected Cash Tip
	 double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
//	Expected_Cash_Tip=Expected_Cash_Tip/Emp_Count;
	
	System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);

	//To Calculate No Cash Tip
	double No_Cash_TipDt=CC_TipDt+Other_TipsDt;
	
	
	
	//To Get Actual_Cash_Tip
	double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
	System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);
	
	BigDecimal dd=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);
	
	Expected_TipDt=dd.doubleValue();*/
	
	if(Expected_Tip==Actual_ExpectedTipDt)
	{
test.log(LogStatus.PASS, "Expected Tip Calculated successfully");
	}
	else
	{
double ExpectedTip_Difference=Expected_Tip-Actual_ExpectedTipDt;
test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
	}
	
	
	//To Get Tip Out Percentage
//	String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//	double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//	
//	//To Calculate Tip Out Contribution
//	double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//	
//	BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//	Expected_Tip_Out_ContDt=dd3.doubleValue();
//	
	//To Get Actual Tip Out Contribution from Report
	String Actual_Tip_Out_ConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[17]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Out Cont is : "+Actual_Tip_Out_ConDt);	
	test.log(LogStatus.INFO, "Total Out Cont is : "+Actual_Tip_Out_ConDt);
	double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_Tip_Out_ConDt);
	
	
//	//Check whether the Tip Out Contribution is Calculated or not
//	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//	{
//test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//	}
//	else
//	{
//double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//	}
//	
	
	//To Get Actual Tip Out Share from the Report
	String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[27]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Expected Tip is : "+Actual_Tip_Out_ShareDt);	
	test.log(LogStatus.INFO, "Total Expected Tip is : "+Actual_Tip_Out_ShareDt);
	double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);
	
	//To Get Actual Tip Shared from the Report
	String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[25]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
	test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
	double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
	
	//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	if(Tip_Shared_Dly==Actual_Tip_SharedDt)
	{
test.log(LogStatus.PASS, "Tip Shared is Correct for both In Time to In Hours (Date Range - Daily)");
	}
	else
	{
double Tip_Shared_Diff=Tip_Shared_Dly-Actual_Tip_SharedDt;
test.log(LogStatus.FAIL, "Tip Shared is InCorrect for both In Time to In Hours (Date Range - Daily). The Values Difference is : "+Tip_Shared_Diff);
	}
	
	
	
	
	//To Get Over All Tip from the Report
	String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
	test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
	double Actual_OverAll_Tip=Double.parseDouble(Actual_OverAllTip_Dt);
	
	if(OverAll_Tip_Dly==Actual_OverAll_Tip) 
	{
test.log(LogStatus.PASS, "Over All Tip Calculated correctly for In Time to In Hours (Date Range - Daily)");
	}
	else
	{
double diff=OverAll_Tip_Dly-Actual_OverAll_Tip;
test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly for In Time to In Hours (Date Range - Daily). Diff is : "+diff);
	}
	
	
	//To Get Actual Ovar All Pay
	String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[36]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
	System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
	test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
	double Actual_Over_All_Pay=Double.parseDouble(Actual_OverAllPay_Dt);
	
	//Check whether the Actual and Expected Over all Pay is correct or not	
	if(Over_All_Pay_Dly==Actual_Over_All_Pay) 
	{
test.log(LogStatus.PASS, "Over All Pay Calculated correctly for In Time to In Hours (Date Range - Daily)");
	}
	else
	{
double diff=Over_All_Pay_Dly-Actual_Over_All_Pay;
test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly for In Time to In Hours (Date Range - Daily). Diff is : "+diff);
	}
	
	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s2="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s2));
	
	ArrayList<String> obtainedList = new ArrayList<String>(); 
	List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
	for(int i = 1; i <= elementList.size(); i++)
	{
String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();

String[] name = namess.split(" ");
//System.out.println("TEST Z-A FIRST : "+name[0]);
obtainedList.add(name[0]);
	}
	ArrayList<String> sortedList = new ArrayList<String>();
	for(String s:obtainedList)
	{
sortedList.add(s);
	}
	Collections.reverse(sortedList);
	
	for(int i = 0; i < elementList.size(); i++)
	{	
if(sortedList.equals(obtainedList))
{
	
}else
{
	test.log(LogStatus.FAIL, "Name sort is not working  for Z-A First Name");
}
	}
	
	/*	ArrayList<String> obtainedList = new ArrayList<>(); 
	List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
	for(WebElement we:elementList){
	   obtainedList.add(we.getText());
	}
	ArrayList<String> sortedList = new ArrayList<>();   
	for(String s:obtainedList){ 
	sortedList.add(s);
	}
	Collections.sort(sortedList);
	Assert.assertTrue(sortedList.equals(obtainedList));*/
	}	
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	Thread.sleep(1000); 
	
	test.log(LogStatus.INFO, "Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyDailyReport_In_Hours_Date_Range End");

	}
	
	
	@Test(priority=74,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range(WebDriver driver) throws Exception
	{
	double OverAll_Tip_Wly,Over_All_Pay_Wly,Tip_Shared_Wly,Expected_Tip_Wly;
	
	   
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(2000);
	
	test.log(LogStatus.INFO, "Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range Starts");
	//Top of the page
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	Thread.sleep(5000);
	//Select the Employee option
	repts.Select_Employee("QA Test");
	
	//Select the Process as Weekly
	repts.Select_Process("Weekly");

 	//Select the Date Range
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	//Select the Format
	repts.Select_FormatType("In Time");
	
	//Select the Format
	repts.Select_Status("All");
	
	//Select the Role
	repts.Select_Role("All");
	
	Thread.sleep(2000);
	//Enable or Disable the show summary only options
	repts.Enable_Show_Summary_Only();
	
	
	Thread.sleep(1000);
	 //Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	
	
//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
}
else
{

test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Hours and Weekly) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Hours(Weekly) *******");

repts.Select_LastPage_Pagination_InReport();

List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));

Thread.sleep(1000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);
Thread.sleep(1000);
//Get Summary

	/*	String Summary = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
System.out.println("Total Summary is : "+Summary);
	
test.log(LogStatus.INFO, "Total Summary is : "+Summary);
//Get Per Rate value
String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/
//Get Reg Pay
String regPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
System.out.println("Total Reg Pay is : "+regPayDt);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPayDt);
String TotalRegPayDt=regPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double RegPayDt=Double.parseDouble(TotalRegPayDt);
	

//Get OT Pay
String otPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
System.out.println("Total OT Pay is : "+otPayDt);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPayDt);	
String TotalOTPayDt=otPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPayDt=Double.parseDouble(TotalOTPayDt);


//To Get Expected Total Pay
double Expected_TTTLPayDt=RegPayDt+OTPayDt;


//Get TTL Pay
String ttlPayDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
System.out.println("Total TTL Pay is : "+ttlPayDt);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPayDt);
String TotalPayDt=ttlPayDt.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPayDt=Double.parseDouble(TotalPayDt);


if(Expected_TTTLPayDt==Actual_TTLPayDt)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPayDt-Actual_TTLPayDt;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTipDt);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTipDt);
double CC_TipDt=Double.parseDouble(ccTipDt);
 

//Get Tip Charge Tip
String TipchargeDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+TipchargeDt);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+TipchargeDt);
double Tip_ChargeDt=Double.parseDouble(TipchargeDt);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_TipDt=CC_TipDt-Tip_ChargeDt;


//Get Gratuity
String gratuityDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuityDt);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuityDt);
double GratuityDt=Double.parseDouble(gratuityDt);

//Get Emp CC Tip
String Emp_cc_tipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tipDt);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tipDt);
double Actual_Emp_CC_TipDt=Double.parseDouble(Emp_cc_tipDt);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_TipDt==Actual_Emp_CC_TipDt)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_Tip=Expected_Emp_CC_TipDt-Actual_Emp_CC_TipDt;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_Tip);
}

//Get Other Tip
String otherTipsDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTipsDt);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTipsDt);
double Other_TipsDt=Double.parseDouble(otherTipsDt);



//Get Declared Cash Tip
String declaredCashTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTipDt);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTipDt);	
double DeclaredCashTipDt=Double.parseDouble(declaredCashTipDt);



//Get Total Tips
/*String ttltipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltipDt);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltipDt);
double Actual_TTLTipDt=Double.parseDouble(ttltipDt);

//To Calculate Expected Total Tip
double Expected_TTLTipDt=CC_TipDt+GratuityDt+Other_TipsDt+DeclaredCashTipDt;

//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTipDt==Actual_TTLTipDt)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTipDt-Actual_TTLTipDt;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSalesDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSalesDt);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSalesDt);	
double NetSalesDt=Double.parseDouble(netSalesDt);
 
//Get Expected Tip
String expectedTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTipDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTipDt);
double Actual_ExpectedTipDt=Double.parseDouble(expectedTipDt);
this.Expected_Tip=Actual_ExpectedTipDt;

//To Get the Cash Tip Percentage
String Cash_Tip_PerDt=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_PercentageDt=Double.parseDouble(Cash_Tip_PerDt);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

if(Cash_Tip_PercentageDt!=0.00)
{
//To Calculate Expected Cash Tip
double Expected_Cash_TipDt =NetSalesDt*Cash_Tip_PercentageDt/100;
	//	double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/Emp_Count;

BigDecimal dd=new BigDecimal(Expected_Cash_TipDt).setScale(2, RoundingMode.CEILING);

Expected_Cash_TipDt=dd.doubleValue();

	//	double Expected_Expected_Cash_Tip=Expected_Cash_Tip/100;
System.out.println("Expected Cash Tip is : "+Expected_Cash_TipDt);


//To Calculate No Cash Tip
double No_Cash_TipDt=CC_TipDt+Other_TipsDt;

	 
//To Get Actual_Cash_Tip
double Expected_TipDt=Expected_Cash_TipDt-No_Cash_TipDt;
	//	Expected_Tip=Expected_Tip/Emp_Count;
BigDecimal dd1=new BigDecimal(Expected_TipDt).setScale(2, RoundingMode.CEILING);

Expected_TipDt=dd1.doubleValue();
System.out.println("Expected value of Expected Tip is : "+Expected_TipDt);



if(Expected_TipDt==Actual_ExpectedTipDt)
{
	test.log(LogStatus.PASS, "Expected Tip (Daily - In Time) Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}
}
else
{
	if(Actual_ExpectedTipDt==0.00)
	{
	test.log(LogStatus.PASS, "Expected Tip (Cash Tip % is 0.00) (Daily - In Time) Calculated successfully");
	}
	else
	{
	//	double ExpectedTip_Difference=Expected_TipDt-Actual_ExpectedTipDt;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect (Cash Tip % is 0.00). The Value Diffrence is : "+Actual_ExpectedTipDt);
	}
}
	

//To Get Tip Out Percentage
//String Tip_Out_PerDt=Utility.getReportPropertyUser("Tip_Out_Percentage");
//double TipOut_PercentageDt=Double.parseDouble(Tip_Out_PerDt);
//
////To Calculate Tip Out Contribution
//double Expected_Tip_Out_ContDt=NetSalesDt*TipOut_PercentageDt/100;
//
//BigDecimal dd3=new BigDecimal(Expected_Tip_Out_ContDt).setScale(2, RoundingMode.CEILING);
//Expected_Tip_Out_ContDt=dd3.doubleValue();
//
//To Get Actual Tip Out Contribution from Report
String Actual_Tip_Out_ConDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[17]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Out Cont is : "+Actual_Tip_Out_ConDt);	
test.log(LogStatus.INFO, "Total Out Cont is : "+Actual_Tip_Out_ConDt);
double Actual_Tip_Out_ContDt=Double.parseDouble(Actual_Tip_Out_ConDt);


//Check whether the Tip Out Contribution is Calculated or not
//if(Expected_Tip_Out_ContDt==Actual_Tip_Out_ContDt)
//{
//	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
//}
//else
//{
//	double TipOut_ContDiff=Expected_Tip_Out_ContDt-Actual_Tip_Out_ContDt;
//	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
//}
//

//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[27]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+Actual_Tip_Out_ShareDt);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+Actual_Tip_Out_ShareDt);
double Actual_Tip_Out_SharedDt=Double.parseDouble(Actual_Tip_Out_ShareDt);


//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_ContDt==Actual_Tip_Out_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Actual_Tip_Out_SharedDt-Expected_Tip_Out_ContDt;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/

//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[25]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);
this.Tip_Shared_Wly=Actual_Tip_SharedDt;

//Get Online Tips
String OLOPkupTipDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'OLO Pkup Tip')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total OLO Pkup Tip is : "+OLOPkupTipDt);	
test.log(LogStatus.INFO, "Total OLO Pkup Tip is : "+OLOPkupTipDt);
double OLO_Pkup_TipDt=Double.parseDouble(OLOPkupTipDt);

//Get Driver Compensation
String driverCompDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'DRV Comp')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total DRV Comp is : "+driverCompDt);	
test.log(LogStatus.INFO, "Total DRV Comp is : "+driverCompDt);
double Driver_Comp_Dt=Double.parseDouble(driverCompDt);


double Expected_Tip_Shared=CC_TipDt-Tip_ChargeDt-Actual_Tip_Out_ContDt+DeclaredCashTipDt+GratuityDt+Driver_Comp_Dt+OLO_Pkup_TipDt;
System.out.println("Expected Tip shared values is : "+Expected_Tip_Shared);


//Check whether the Actual and Expected Tip shared is Equal or not
if(Expected_Tip_Shared==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared (Weekly - In Time) Calculated successfully");
}
else
{
	double Tip_Difference=Expected_Tip_Shared-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared Value Incorrect. (Weekly - In Time)  The Value Diffrence is : "+Tip_Difference);
}


//To calculate Over All Tip
double OverAllTip=Actual_Emp_CC_TipDt-Actual_Tip_Out_ContDt;
System.out.println("Over All Tip Before : "+OverAllTip);
double Expected_Over_All_Tip=Expected_Tip_Shared+Actual_Tip_Out_SharedDt;//+Actual_Tip_Out_Adj_Dt;



//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
OverAll_Tip_Wly=Double.parseDouble(Actual_OverAllTip_Dt);
this.OverAll_Tip_Wly=OverAll_Tip_Wly;

//Check whether the Actual and Expected Over all Tip is correct or not
if(Expected_Over_All_Tip==OverAll_Tip_Wly) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_Over_All_Tip-OverAll_Tip_Wly;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}



//To Calculate Over all Pay
double Expected_OverPay=Actual_TTLPayDt+OverAll_Tip_Wly;

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[36]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
Over_All_Pay_Wly=Double.parseDouble(Actual_OverAllPay_Dt);
this.Over_All_Pay_Wly=Over_All_Pay_Wly;

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Expected_OverPay==Over_All_Pay_Wly) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly (Date Range - Weekly - In Time)");
}
else
{
	double diff=Expected_OverPay-Over_All_Pay_Wly;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly (Date Range - Weekly - In Time). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST A-Z LAST : "+name[1]);
	obtainedList.add(name[1]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.sort(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working for A-Z Last Name");
	}
}

	
	}
	Thread.sleep(1000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	Thread.sleep(1000);	
	test.log(LogStatus.INFO, "Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Time_Date_Range End");
	

	}
	@Test(priority=75,enabled=false)
	public void Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Hours_Date_Range(WebDriver driver) throws Exception
	{
	   
	repts=new ReportsPage(driver, test);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(5000);
	test.log(LogStatus.INFO, "Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Hours_Date_Range Starts");
	//Top of the page
	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	/*	WebElement ele1=driver.findElement(By.xpath(excel.getData(3, 2413, 1)));
	JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);", ele1);*/
	Thread.sleep(1000);
	//Select stores
	//repts.Select_Store_inEmployeeRoleBased_EnterpriseReport(Utility.getProperty("Store1"));
	
	//Select the Employee option
	repts.Select_Employee("QA Test");
	
	//Select the Process as Weekly
	repts.Select_Process("Weekly");
 
	for(int i = 1; i <= 4; i++)
	{
		Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(3000);
	}
	
	Thread.sleep(1000);
  	
	//Select the Date Range
	repts.Select_Date_Range_TimePeriod(Utility.getProperty("Payroll_Date_Range_From"), Utility.getProperty("Payroll_Date_Range_To"));
	
	//Select the Format
	repts.Select_FormatType("In Hours");
	
	//Select the Format
	repts.Select_Status("All");
	
	//Select the Role
	repts.Select_Role("All");

	Thread.sleep(1000);
	 //Click Apply
	repts.Click_ApplyButton(); 
	Thread.sleep(30000);
	
	   	//Check weather the report is available for the selected time period
if(repts.No_TransactionFound_InfoMessage().isDisplayed())
{
	test.log(LogStatus.FAIL, "Enterprise Reports - Employee Payroll Report is not available for Specific Date");

	String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
	String s="data:image/png;base64,"+scnShot;
	test.log(LogStatus.INFO,test.addScreenCapture(s));
}
else
{

test.log(LogStatus.PASS, "Enterprise Reports - Employee Payroll Report(In Time and Weekly) is available for Specific Date");

System.out.println("******* The Below is Employee Payroll Report for In Time(Weekly) *******");

test.log(LogStatus.INFO, "******* The Below is Employee Payroll Report for In Time(Weekly) *******");

Thread.sleep(1000);
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.END);

repts.Select_LastPage_Pagination_InReport();

Thread.sleep(1000);
List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr"));
//Get Summary

/*String Summary = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[4]")).getText();
System.out.println("Total Summary is : "+Summary);
	
test.log(LogStatus.INFO, "Total Summary is : "+Summary);

//Get Per Rate value
String perRate = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[5]")).getText();

System.out.println("Total Per Rate is : "+perRate);

test.log(LogStatus.INFO, "Total Per Rate is : "+perRate);

//Get Reg Hours
String regHours = driver.findElement(By.xpath("//table[@class='table table-bordered ng-table-responsive table-condensed ng-scope ng-table']/tbody/tr["+rows.size()+"]/td[6]")).getText();

System.out.println("Total Reg Hours is : "+regHours);

test.log(LogStatus.INFO, "Total Reg Hours is : "+regHours);
*/

WebElement ele=driver.findElement(By.xpath("//tr["+rows.size()+"]/td"));
JavascriptExecutor js1=(JavascriptExecutor)driver;
js1.executeScript("arguments[0].scrollIntoView(true);", ele);

//Get Reg Pay
String regPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[9]")).getText();
System.out.println("Total Reg Pay is : "+regPay);
test.log(LogStatus.INFO, "Total Reg Pay is : "+regPay);
String TotalRegPay=regPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double RegPay=Double.parseDouble(TotalRegPay);
	

//Get OT Pay
String otPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[11]")).getText();
System.out.println("Total OT Pay is : "+otPay);	
test.log(LogStatus.INFO, "Total OT Pay is : "+otPay);	
String TotalOTPay=otPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double OTPay=Double.parseDouble(TotalOTPay);


//To Get Expected Total Pay
double Expected_TTTLPay=RegPay+OTPay;


//Get TTL Pay
String ttlPay = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[13]")).getText();	
System.out.println("Total TTL Pay is : "+ttlPay);
test.log(LogStatus.INFO, "Total TTL Pay is : "+ttlPay);
String TotalPay=ttlPay.replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
double Actual_TTLPay=Double.parseDouble(TotalPay);


if(Expected_TTTLPay==Actual_TTLPay)
{
	test.log(LogStatus.PASS, "Total pay (Weekly - In Hours) is Calculated successfully");
}
else
{
	double Different=Expected_TTTLPay-Actual_TTLPay;
	
	test.log(LogStatus.FAIL, "Actual and Expected Total pay (Weekly - In Hours) is diffrent. The Diffrence is : "+Different);
	
	System.out.println("Actual and Expected Total pay is diffrent.(Weekly - In Hours) The Diffrence is : "+Different);
}

//Get CC Tip
String ccTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[14]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total CC Tip is : "+ccTip);
test.log(LogStatus.INFO, "Total CC Tip is : "+ccTip);
double CC_Tip=Double.parseDouble(ccTip);
 

//Get Tip Charge Tip
String Tipcharge = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tip Charge is : "+Tipcharge);	
test.log(LogStatus.INFO, "Total Tip Charge is : "+Tipcharge);
double Tip_Charge=Double.parseDouble(Tipcharge);

//To Calculate Actual Employee Tip 
double Expected_Emp_CC_Tip=CC_Tip-Tip_Charge;


//Get Gratuity
String gratuity = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Gratuity is : "+gratuity);	
test.log(LogStatus.INFO, "Total Gratuity is : "+gratuity);
double Gratuity=Double.parseDouble(gratuity);

//Get Emp CC Tip
String Emp_cc_tip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Emp CC Tips is : "+Emp_cc_tip);
test.log(LogStatus.INFO, "Total Emp CC Tips is : "+Emp_cc_tip);
double Actual_Emp_CC_Tip=Double.parseDouble(Emp_cc_tip);

//Check whether the Exmployee Tip is Equal or not
if(Expected_Emp_CC_Tip==Actual_Emp_CC_Tip)
{
	test.log(LogStatus.PASS, "Employee CC Tip Charge Calculated correctly");
}
else
{	
	double diffrence_Emp_CC_Tip=Expected_Emp_CC_Tip-Actual_Emp_CC_Tip;
	test.log(LogStatus.FAIL, "Employee CC Tip Calculated Wrongly. The Value diffrence is : "+diffrence_Emp_CC_Tip);
}

//Get Other Tip
String otherTips = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Other Tip is : "+otherTips);	
test.log(LogStatus.INFO, "Other Tip is : "+otherTips);
double Other_Tips=Double.parseDouble(otherTips);



//Get Declared Cash Tip
String declaredCashTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Declared Cash Tip is : "+declaredCashTip);	
test.log(LogStatus.INFO, "Total Declared Cash Tip is : "+declaredCashTip);	
double DeclaredCashTip=Double.parseDouble(declaredCashTip);



//Get Total Tips
	/*	String ttltip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[contains(@data-title-text,'TTL Tips')]/div")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();
System.out.println("Total Tips is : "+ttltip);	
test.log(LogStatus.INFO, "Total Tips is : "+ttltip);
double Actual_TTLTip=Double.parseDouble(ttltip);

//To Calculate Expected Total Tip
double Expected_TTLTip=CC_Tip+Gratuity+Other_Tips+DeclaredCashTip;


//Check whether the Total Tip and Actual Tip is Equal or not
if(Expected_TTLTip==Actual_TTLTip)
{
	test.log(LogStatus.PASS, "Expected and Actual Total Tip value is Correct");
}
else
{
	double TotalTip_Diff=Expected_TTLTip-Actual_TTLTip;
	test.log(LogStatus.FAIL, "Expected and Actual Total Tip value is InCorrect. The Value diffrence is :"+TotalTip_Diff);
}*/

//Get Net Sales
String netSales = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[23]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();	
System.out.println("Total Net Sales is : "+netSales);	
test.log(LogStatus.INFO, "Total Net Sales is : "+netSales);	
double NetSales=Double.parseDouble(netSales);

//Get Expected Tip
String expectedTip = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[24]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip is : "+expectedTip);	
test.log(LogStatus.INFO, "Total Expected Tip is : "+expectedTip);
double Actual_ExpectedTip=Double.parseDouble(expectedTip);


//To Get the Cash Tip Percentage
	/*	String Cash_Tip_Per=Utility.getReportPropertyUser("Cash_Tip_Percentage");
double Cash_Tip_Percentage=Double.parseDouble(Cash_Tip_Per);

//Get the No of Employees
	//	List<WebElement> empList=driver.findElements(By.xpath("//td/div[contains(.,'Total')]"));
	//	int Emp_Count=empList.size();

//To Calculate Expected Cash Tip
double Expected_Cash_Tip =(NetSales*Cash_Tip_Percentage)/100;
	//	Expected_Cash_Tip=Expected_Cash_Tip/Emp_Count;

System.out.println("Expected Cash Tip is : "+Expected_Cash_Tip);

//To Calculate No Cash Tip
double No_Cash_Tip=CC_Tip+Other_Tips;
 


//To Get Actual_Cash_Tip
double Expected_Tip=Expected_Cash_Tip-No_Cash_Tip;
System.out.println("Expected value of Expected Tip is : "+Expected_Tip);

BigDecimal dd=new BigDecimal(Expected_Tip).setScale(2, RoundingMode.CEILING);

Expected_Tip=dd.doubleValue(); 
	//	Expected_Tip=Expected_Tip/Emp_Count;*/

if(Expected_Tip==Actual_ExpectedTip)
{
	test.log(LogStatus.PASS, "Expected Tip Calculated successfully");
}
else
{
	double ExpectedTip_Difference=Expected_Tip-Actual_ExpectedTip;
	test.log(LogStatus.FAIL, "Expected Tip Value Incorrect. The Value Diffrence is : "+ExpectedTip_Difference);
}


//To Get Tip Out Percentage
String Tip_Out_Per=Utility.getReportPropertyUser("Tip_Out_Percentage");
double TipOut_Percentage=Double.parseDouble(Tip_Out_Per);

//To Calculate Tip Out Contribution
double Expected_Tip_Out_Cont=NetSales*TipOut_Percentage/100;

BigDecimal dd3=new BigDecimal(Expected_Tip_Out_Cont).setScale(2, RoundingMode.CEILING);
Expected_Tip_Out_Cont=dd3.doubleValue();

//To Get Actual Tip Out Contribution from Report
String Actual_Tip_Out_Con = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[17]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip Out Contribution is : "+Actual_Tip_Out_Con);	
test.log(LogStatus.INFO, "Total Expected Tip Out Contribution is : "+Actual_Tip_Out_Con);
double Actual_Tip_Out_Cont=Double.parseDouble(Actual_Tip_Out_Con);


//Check whether the Tip Out Contribution is Calculated or not
if(Expected_Tip_Out_Cont==Actual_Tip_Out_Cont)
{
	test.log(LogStatus.PASS, "Tip Out Contribution Calculated Correctly");
}
else
{
	double TipOut_ContDiff=Expected_Tip_Out_Cont-Actual_Tip_Out_Cont;
	test.log(LogStatus.FAIL, "Tip Out Contribution Calculated Incorrectly. The Diffrence is : "+TipOut_ContDiff);
}


//To Get Actual Tip Out Share from the Report
String Actual_Tip_Out_Share = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[27]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Expected Tip Out Share is : "+Actual_Tip_Out_Share);	
test.log(LogStatus.INFO, "Total Expected Tip Out Share is : "+Actual_Tip_Out_Share);
double Actual_Tip_Out_Shared=Double.parseDouble(Actual_Tip_Out_Share);


//To check whether the Tip Out Contribution and Tip Shared are Equal or not
	/*	if(Expected_Tip_Out_Cont==Actual_Tip_Out_Shared)
{
	test.log(LogStatus.PASS, "Tip Out Contribution and Tip Shared is Correct");
}
else
{
	double Tip_Shared_Diff=Actual_Tip_Out_Shared-Expected_Tip_Out_Cont;
	test.log(LogStatus.FAIL, "Tip Out Contribution and Tip Shared is InCorrect. The Values Difference is : "+Tip_Shared_Diff);
}*/


//To Get Actual Tip Shared from the Report
String Actual_Tip_ShareDt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[25]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Tip Shared Tip is : "+Actual_Tip_ShareDt);	
test.log(LogStatus.INFO, "Total Tip Shared Tip is : "+Actual_Tip_ShareDt);
double Actual_Tip_SharedDt=Double.parseDouble(Actual_Tip_ShareDt);

//To check whether the Tip Out Contribution and Tip Shared are Equal or not
if(Tip_Shared_Wly==Actual_Tip_SharedDt)
{
	test.log(LogStatus.PASS, "Tip Shared is Correct for both In Time to In Hours (Date Range - Weekly)");
}
else
{
	double Tip_Shared_Diff=Tip_Shared_Wly-Actual_Tip_SharedDt;
	test.log(LogStatus.FAIL, "Tip Shared is InCorrect for both In Time to In Hours (Date Range - Weekly). The Values Difference is : "+Tip_Shared_Diff);
}

//To Get Over All Tip from the Report
String Actual_OverAllTip_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[35]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Tip is : "+Actual_OverAllTip_Dt);	
test.log(LogStatus.INFO, "Total Over All Tip is : "+Actual_OverAllTip_Dt);
double Actual_OverAll_Tip=Double.parseDouble(Actual_OverAllTip_Dt);

if(OverAll_Tip_Wly==Actual_OverAll_Tip) 
{
	test.log(LogStatus.PASS, "Over All Tip Calculated correctly for In Time to In Hours (Date Range - Weekly)");
}
else
{
	double diff=OverAll_Tip_Wly-Actual_OverAll_Tip;
	test.log(LogStatus.FAIL, "Over All Tip Calculated Incorrectly for In Time to In Hours (Date Range - Weekly). Diff is : "+diff);
}

//To Get Actual Ovar All Pay
String Actual_OverAllPay_Dt = driver.findElement(By.xpath("//tr["+rows.size()+"]/td[36]")).getText().replaceAll("[a-zA-Z $ ₹ £ , :]", "");//.substring(1).toString();;	
System.out.println("Total Over All Pay is : "+Actual_OverAllPay_Dt);	
test.log(LogStatus.INFO, "Total Over All Pay is : "+Actual_OverAllPay_Dt);
double Actual_Over_All_Pay=Double.parseDouble(Actual_OverAllPay_Dt);

//Check whether the Actual and Expected Over all Pay is correct or not	
if(Over_All_Pay_Wly==Actual_Over_All_Pay) 
{
	test.log(LogStatus.PASS, "Over All Pay Calculated correctly for In Time to In Hours (Date Range - Weekly)");
}
else
{
	double diff=Over_All_Pay_Wly-Actual_Over_All_Pay;
	test.log(LogStatus.FAIL, "Over All Pay Calculated Incorrectly for In Time to In Hours (Date Range - Weekly). Diff is : "+diff);
}

String scnShot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);
String s1="data:image/png;base64,"+scnShot;
test.log(LogStatus.INFO,test.addScreenCapture(s1));

ArrayList<String> obtainedList = new ArrayList<String>(); 
List<WebElement> elementList= driver.findElements(By.xpath("//td[contains(.,'*')]"));
for(int i = 1; i <= elementList.size(); i++)
{
	String namess = driver.findElement(By.xpath("//td[contains(.,'*')]")).getText();
	
	String[] name = namess.split(" ");
	//System.out.println("TEST Z-A LAST : "+name[1]);
	obtainedList.add(name[1]);
}
ArrayList<String> sortedList = new ArrayList<String>();
for(String s:obtainedList)
{
	sortedList.add(s);
}
Collections.reverse(sortedList);

for(int i = 0; i < elementList.size(); i++)
{	
	if(sortedList.equals(obtainedList))
	{
	
	}else
	{
	test.log(LogStatus.FAIL, "Name sort is not working for Z-A Last Name");
	}
}
	}
test.log(LogStatus.INFO, "Enterprise_Employee_Role_Based_Payroll_Report_Method_verifyWeeklyReport_In_Hours_Date_Range End");
}
	
}
