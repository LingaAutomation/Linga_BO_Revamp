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

import com.Pages.ReportsPage;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports_Audit_Log {

	public WebDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Audit Log");

	LoginPage lgpg;

	Utility ut = new Utility();

	String st = "NA";

	Common_XPaths cmp;
	LoginTest a = new LoginTest();
	ReportsPage repts;

	@AfterClass
	public void flushTest() throws Exception {
		Thread.sleep(2000);
		rep.endTest(test);
		rep.flush();
	}

	@AfterMethod
	public void TestFail(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			String scnsht = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

			String s = "data:image/png;base64," + scnsht;

			test.log(LogStatus.FAIL, test.addScreenCapture(s));

		}
	}

	@Test(priority = 1)
	public void Login() throws Exception {

		Thread.sleep(2000);
		// Call the chrome driver
		// System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
		// Open the Chrome window
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().driverVersion("110.0.5481").setup();
		driver = new ChromeDriver(chromeOptions);

		// Wait for 30 seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the Chrome window
		driver.manage().window().maximize();
		Thread.sleep(1000);
		// Launch the URL
		driver.get(Utility.getProperty("appURL"));

		Thread.sleep(10000);
		a.Login(driver, test);
	}

	@Test(priority = 50)
	public void LogOut() throws Exception {
		a.LogOut(driver, test);
	}

	@Test(priority = 2)
	public void Calling() throws Exception {
		Open_Audit_Log_Page(driver);
//		RefreshAndPaginination(driver);
		
		  Audit_Log_Today_PaymentName(driver);
		 // Audit_Log_Yesterday_PaymentName(driver);
		  //Audit_Log_Last_N_Days_PaymentName(driver);
		  //Audit_Log_This_Week_PaymentName(driver);
		  //Audit_Log_Last_Week_PaymentName(driver);
		  Audit_Log_Last_7_Days_PaymentName(driver);
		  Audit_Log_This_Month_PaymentName(driver);
		  Audit_Log_Last_Month_PaymentName(driver);
		  Audit_Log_Last_30_Days_PaymentName(driver);
		  Audit_Log_Specific_Date_PaymentName(driver);
		  Audit_Log_Date_Range_PaymentName(driver);
		 Thread.sleep(1000);
		Audit_Log_Today_PaymentType(driver);
		Audit_Log_Yesterday_PaymentType(driver);
		Audit_Log_Last_N_Days_PaymentType(driver);
		Audit_Log_This_Week_PaymentType(driver);
		Audit_Log_Last_Week_PaymentType(driver);
		Audit_Log_Last_7_Days_PaymentType(driver);
		Audit_Log_This_Month_PaymentType(driver);
		Audit_Log_Last_Month_PaymentType(driver);
		Audit_Log_Last_30_Days_PaymentType(driver);
		Audit_Log_Specific_Date_PaymentType(driver);
		Audit_Log_Date_Range_PaymentType(driver);
	}

	@Test(priority = 3, enabled = false)
	public void Open_Audit_Log_Page(WebDriver driver) throws Exception {

		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		Thread.sleep(5000);
		// Load the Menu Item sales report page
		driver.get(
				Utility.getProperty("baseURL") + Utility.getProperty("store_Id3") + "auditLog");

		Thread.sleep(5000);
		//Verify the Menu Item sales report page loeded or not
		try {
			if(driver.findElement(By.xpath("//h3[contains(.,'Audit Log')]")).isDisplayed()) {
				test.log(LogStatus.PASS, "Audit Log report page is loaded successfully");
			}
		}catch(Exception E) {
			test.log(LogStatus.FAIL, "Audit Log report page is not loaded");
		}

	}

	@Test(priority = 4, enabled = false)
	public void RefreshAndPaginination(WebDriver driver) throws Exception {
		cmp = new Common_XPaths(driver, test);

		// Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();

		// Verify Column Filtration
		cmp.Filter_Columns();
	}

	@Test(priority = 4, enabled = false)
	public void SelectTheSourceAsBO(WebDriver driver) throws Exception {
		Thread.sleep(5000);
		// Click the category label
		driver.findElement(By.xpath("(//span[contains(.,'Source')]/../input)")).click();
		Thread.sleep(500);
		// Select the BO option
		driver.findElement(By.xpath("//select-option[contains(.,'BO')]")).click();

		Thread.sleep(500);
		// Click the Event label
		driver.findElement(By.xpath("(//span[contains(.,'Event')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();

		Thread.sleep(500);
	}

	@Test(priority = 4, enabled = false)
	public void SelectTheSourceAsPOS(WebDriver driver) throws Exception {
		Thread.sleep(5000);
		// Click the category label
		driver.findElement(By.xpath("(//span[contains(.,'Source')]/../input)")).click();
		Thread.sleep(500);
		// Select the POS option
		driver.findElement(By.xpath("//select-option[contains(.,'POS')]")).click();

		Thread.sleep(500);
		// Click the Event label
		driver.findElement(By.xpath("(//span[contains(.,'Filter')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();

		Thread.sleep(500);
		
		Thread.sleep(500);
		// Click the Event label
		driver.findElement(By.xpath("(//span[contains(.,'Check Type')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();

		Thread.sleep(500);
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Today_PaymentName(WebDriver driver) throws Exception {
		test.log(LogStatus.INFO,
				"************************************************** Source as BO(Start) **************************************************");

		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=newExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheSourceAsBO(driver);

		// Select Today
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		
		//Select Today
		repts.Select_Today_TimePeriod();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();
		
		
	
		
		Thread.sleep(40000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Today");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Audit Log Available for Today");

			Thread.sleep(2000);
			
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());
			
			//table/tbody/tr[1]/td[2]
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Yesterday_PaymentName(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select Yesterday
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		//Select Yesterday
		repts.Select_Yesterday_TimePeriod();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Yesterday");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for Yesterday");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());


			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Last_N_Days_PaymentName(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select Last N days
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		//Select Last N days
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Last N Days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for Last N days");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());


			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_This_Week_PaymentName(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select This Week
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		//Select This Week
		repts.Select_This_Week_TimePeriod();
		
		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for This Week");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for This Week");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Last_Week_PaymentName(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select Last Week
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		
		//Select Last Week
		repts.Select_Last_Week_TimePeriod();
		
		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Last Week");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for Last Week");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Last_7_Days_PaymentName(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select Last 7 days
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		//Select Last 7 days
		repts.Select_Last_7_Days_TimePeriod();
		
		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Last 7 days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for Last 7 days");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_This_Month_PaymentName(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select This month
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		//Select This month
		repts.Select_This_Month_TimePeriod();
		
		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for This month");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for This month");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Last_Month_PaymentName(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select Last month
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		//Select Last month
		repts.Select_Last_Month_TimePeriod();
		
		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Last month");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for Last month");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Last_30_Days_PaymentName(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select Last 30 days
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		//Select Last 30 days
		repts.Select_Last_30_Days_TimePeriod();
		
		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Last 30 days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for Last 30 days");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Specific_Date_PaymentName(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		//Select Specific Date
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Specific Date");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for Specific Date");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Date_Range_PaymentName(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		
		//Select Date Range
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));


		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Date Range");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for Date Range");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
		test.log(LogStatus.INFO,
				"************************************************** Source as BO(End) **************************************************");
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Today_PaymentType(WebDriver driver) throws Exception {
		test.log(LogStatus.INFO,
				"************************************************** Source as POS(Start) **************************************************");

		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheSourceAsPOS(driver);

		// Select Today
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		
		//Select Today
		repts.Select_Today_TimePeriod();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Today");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Audit Log Available for Today");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Yesterday_PaymentType(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select Yesterday
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		//Select Yesterday
		repts.Select_Yesterday_TimePeriod();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Yesterday");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for Yesterday");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Last_N_Days_PaymentType(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select Last N days
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		//Select Last N days
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Last N Days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for Last N days");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_This_Week_PaymentType(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select This Week
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		//Select This Week
		repts.Select_This_Week_TimePeriod();
		
		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for This Week");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for This Week");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Last_Week_PaymentType(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select Last Week
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		//Select Last Week
		repts.Select_Last_Week_TimePeriod();
		
		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Last Week");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for Last Week");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Last_7_Days_PaymentType(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select Last 7 days
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		//Select Last 7 days
		repts.Select_Last_7_Days_TimePeriod();
		
		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Last 7 days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for Last 7 days");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_This_Month_PaymentType(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select This month
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		//Select This month
		repts.Select_This_Month_TimePeriod();
		
		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for This month");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for This month");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Last_Month_PaymentType(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select Last month
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		//Select Last month
		repts.Select_Last_Month_TimePeriod();
		
		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Last month");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for Last month");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Last_30_Days_PaymentType(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select Last 30 days
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		
		//Select Last 30 days
		repts.Select_Last_30_Days_TimePeriod();
		
		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Last 30 days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for Last 30 days");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Specific_Date_PaymentType(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		//Select Specific Date
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));


		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Specific Date");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for Specific Date");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Audit_Log_Date_Range_PaymentType(WebDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		
		//Select Date Range
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));


		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (driver.findElement(By.xpath("//td[contains(.,'No audit log for selected time period')]")).getText().equals("No audit log for selected time period")) {
				test.log(LogStatus.INFO, "Audit Log Not Available for Date Range");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Audit Log Available for Date Range");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Action is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText());
			test.log(LogStatus.INFO, "Event date & time is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText());
			test.log(LogStatus.INFO, "Employee is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText());
			test.log(LogStatus.INFO, "Device Type is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText());
			test.log(LogStatus.INFO, "Log is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]//a")).getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
		test.log(LogStatus.INFO,
				"************************************************** Source as POS(End) **************************************************");
	}
}
