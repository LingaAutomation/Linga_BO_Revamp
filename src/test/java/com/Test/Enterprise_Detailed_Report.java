package com.Test;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.Availability_RestrictionTimePage;
import com.Pages.ReportsPage;
import com.Pages.Settings_StoreInformation_Page;
import com.epam.healenium.SelfHealingDriver;
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

public class Enterprise_Detailed_Report 
{

public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise Reports - Enterprise Detailed Report");
	
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
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
//		//Open the Chrome window
//		driver = new ChromeDriver();
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver(chrOpt);
		
//		System.setProperty("webdriver.chrome.driver","./Automation Driver/chromedriver.exe");
//		//Open the Chrome window
//		driver = new ChromeDriver();

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
		
		Thread.sleep(20000);
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
		Open_Enterprise_Detailed_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Enterprise_Detailed_Report_Today(driver);
		Enterprise_Detailed_Report_Yesterday(driver);
		Enterprise_Detailed_Report_Last_N_Days(driver);
		Enterprise_Detailed_Report_This_Week(driver);
		Enterprise_Detailed_Report_Last_Week(driver);
		Enterprise_Detailed_Report_Last_7_Days(driver);
		Enterprise_Detailed_Report_This_Month(driver);
		Enterprise_Detailed_Report_Last_Month(driver);
		Enterprise_Detailed_Report_Last_30_Days(driver);
		Enterprise_Detailed_Report_Specific_Date(driver);
		Enterprise_Detailed_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Enterprise_Detailed_Report_Page(SelfHealingDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+"enterprise/enterpriseReports/saleReports/enterpriseDetailedReport");

		Thread.sleep(5000);
		try
		{
		//Verify the Categories page loaded or not
		repts.Verify_ReportHomePage("ENTERPRISE DETAILED REPORT");
		}
		catch(Exception k)
		{
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Detailed_Report_Today(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
	
		Thread.sleep(3000);
		Thread.sleep(3000);
		repts.Enter_Email_Address("cbcjsbc");
		
		//Verify whether the Enter Valid Email pop up displayed or not
		repts.Verify_Valid_Email();
		
			repts.Enter_Email_Address("03383889");
		
		//Verify whether the Enter Valid Email pop up displayed or not
		repts.Verify_Valid_Email();
		
		repts.Enter_Email_Address("*****%^2@aa");
		
		//Verify whether the Enter Valid Email pop up displayed or not
		repts.Verify_Valid_Email();
		
		repts.Enter_Email_Address(Utility.getProperty("userName"));

		Thread.sleep(1000);
		repts.Click_Export_To_EmailButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 50);
		//Verify whethefr the Enterprise Detailed Reports exported or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enterprise Detailed Report is Requested Successfully"))
		{
			test.log(LogStatus.PASS, "Enterprise Detailed Report is Requested Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Enterprise Detailed Report is Requested Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}


	@Test(priority = 4,enabled = false)
	public void Enterprise_Detailed_Report_Yesterday(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Yesterday
		repts.Select_Yesterday_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(3000);
		repts.Enter_Email_Address(Utility.getProperty("userName"));
		


		Thread.sleep(1000);
		repts.Click_Export_To_EmailButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 50);
		//Verify whethefr the Enterprise Detailed Reports exported or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enterprise Detailed Report is Requested Successfully"))
		{
			test.log(LogStatus.PASS, "Enterprise Detailed Report is Requested Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Enterprise Detailed Report is Requested Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}


	@Test(priority = 4,enabled = false)
	public void Enterprise_Detailed_Report_Last_N_Days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Last N days
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(3000);
		repts.Enter_Email_Address(Utility.getProperty("userName"));
		
		Thread.sleep(1000);
		repts.Click_Export_To_EmailButton();
	
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 50);
		//Verify whethefr the Enterprise Detailed Reports exported or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enterprise Detailed Report is Requested Successfully"))
		{
			test.log(LogStatus.PASS, "Enterprise Detailed Report is Requested Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Enterprise Detailed Report is Requested Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}

	@Test(priority = 4,enabled = false)
	public void Enterprise_Detailed_Report_This_Week(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select This Week
		repts.Select_This_Week_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(3000);
		repts.Enter_Email_Address(Utility.getProperty("userName"));

		Thread.sleep(1000);
		repts.Click_Export_To_EmailButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 50);
		//Verify whethefr the Enterprise Detailed Reports exported or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enterprise Detailed Report is Requested Successfully"))
		{
			test.log(LogStatus.PASS, "Enterprise Detailed Report is Requested Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Enterprise Detailed Report is Requested Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}

	@Test(priority = 4,enabled = false)
	public void Enterprise_Detailed_Report_Last_Week(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Last Week
		repts.Select_Last_Week_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		
		Thread.sleep(3000);
		repts.Enter_Email_Address(Utility.getProperty("userName"));

		Thread.sleep(1000);
		repts.Click_Export_To_EmailButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 50);
		//Verify whethefr the Enterprise Detailed Reports exported or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enterprise Detailed Report is Requested Successfully"))
		{
			test.log(LogStatus.PASS, "Enterprise Detailed Report is Requested Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Enterprise Detailed Report is Requested Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}

	@Test(priority = 4,enabled = false)
	public void Enterprise_Detailed_Report_Last_7_Days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Last 7 days
		repts.Select_Last_7_Days_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(3000);
		repts.Enter_Email_Address(Utility.getProperty("userName"));

		Thread.sleep(1000);
		repts.Click_Export_To_EmailButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 50);
		//Verify whethefr the Enterprise Detailed Reports exported or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enterprise Detailed Report is Requested Successfully"))
		{
			test.log(LogStatus.PASS, "Enterprise Detailed Report is Requested Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Enterprise Detailed Report is Requested Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}


	@Test(priority = 4,enabled = false)
	public void Enterprise_Detailed_Report_This_Month(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select This month
		repts.Select_This_Month_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		
		Thread.sleep(3000);
		repts.Enter_Email_Address(Utility.getProperty("userName"));

		Thread.sleep(1000);
		repts.Click_Export_To_EmailButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 50);
		//Verify whethefr the Enterprise Detailed Reports exported or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enterprise Detailed Report is Requested Successfully"))
		{
			test.log(LogStatus.PASS, "Enterprise Detailed Report is Requested Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Enterprise Detailed Report is Requested Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}


	@Test(priority = 4,enabled = false)
	public void Enterprise_Detailed_Report_Last_Month(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Last month
		repts.Select_Last_Month_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(3000);
		repts.Enter_Email_Address(Utility.getProperty("userName"));

		Thread.sleep(1000);
		repts.Click_Export_To_EmailButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 50);
		//Verify whethefr the Enterprise Detailed Reports exported or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enterprise Detailed Report is Requested Successfully"))
		{
			test.log(LogStatus.PASS, "Enterprise Detailed Report is Requested Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Enterprise Detailed Report is Requested Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}

	@Test(priority = 4,enabled = false)
	public void Enterprise_Detailed_Report_Last_30_Days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Last 30 days
		repts.Select_Last_30_Days_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(3000);
		repts.Enter_Email_Address(Utility.getProperty("userName"));

		Thread.sleep(1000);
		repts.Click_Export_To_EmailButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 50);
		//Verify whethefr the Enterprise Detailed Reports exported or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enterprise Detailed Report is Requested Successfully"))
		{
			test.log(LogStatus.PASS, "Enterprise Detailed Report is Requested Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Enterprise Detailed Report is Requested Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}

	@Test(priority = 4,enabled = false)
	public void Enterprise_Detailed_Report_Specific_Date(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Specific Date
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


	
		Thread.sleep(3000);
		repts.Enter_Email_Address(Utility.getProperty("userName"));

		Thread.sleep(1000);
		repts.Click_Export_To_EmailButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 50);
		//Verify whethefr the Enterprise Detailed Reports exported or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enterprise Detailed Report is Requested Successfully"))
		{
			test.log(LogStatus.PASS, "Enterprise Detailed Report is Requested Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Enterprise Detailed Report is Requested Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}

	@Test(priority = 4,enabled = false)
	public void Enterprise_Detailed_Report_Date_Range(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Date Range
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


			Thread.sleep(3000);
			repts.Enter_Email_Address(Utility.getProperty("userName"));
		

			Thread.sleep(1000);
			repts.Click_Export_To_EmailButton();
			
			cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 50);
			//Verify whethefr the Enterprise Detailed Reports exported or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enterprise Detailed Report is Requested Successfully"))
			{
				test.log(LogStatus.PASS, "Enterprise Detailed Report is Requested Successfully");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Enterprise Detailed Report is Requested Failed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
	}
	

}
