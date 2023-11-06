package com.Test;

import java.util.concurrent.TimeUnit;

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

import com.Pages.ReportsPage;
import com.epam.healenium.SelfHealingDriver;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports_Employee_Labor_By_Job_Code_Report {

	public SelfHealingDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Employee - Labor By Job Code Report");

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
			String scnsht = ((TakesScreenshot) driver.getDelegate()).getScreenshotAs(OutputType.BASE64);

			String s = "data:image/png;base64," + scnsht;

			test.log(LogStatus.FAIL, test.addScreenCapture(s));

		}
	}

	@Test(priority = 1)
	public void Login() throws Exception {

		Thread.sleep(2000);
		//Call the chrome driver
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Employee_Gratuity_Path"));
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
	public void LogOut() throws Exception {
		a.LogOut(driver, test);
	}

	@Test(priority = 2)
	public void Calling() throws Exception {
		Open_Labor_By_Job_Code_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Labor_By_Job_Code_Report_Process_As_Daily_Weekly_In_Hours(driver);
		Labor_By_Job_Code_Report_Process_As_Daily_Weekly_In_Time(driver);
		  Labor_By_Job_Code_Report_Today_Process_As_Daily(driver);
		  Labor_By_Job_Code_Report_Yesterday_Process_As_Daily(driver);
		  Labor_By_Job_Code_Report_Last_N_Days_Process_As_Daily(driver);
		  Labor_By_Job_Code_Report_This_Week_Process_As_Daily(driver);
		  Labor_By_Job_Code_Report_Last_Week_Process_As_Daily(driver);
		  Labor_By_Job_Code_Report_Last_7_Days_Process_As_Daily(driver);
		  Labor_By_Job_Code_Report_This_Month_Process_As_Daily(driver);
		  Labor_By_Job_Code_Report_Last_Month_Process_As_Daily(driver);
		  Labor_By_Job_Code_Report_Last_30_Days_Process_As_Daily(driver);
		  Labor_By_Job_Code_Report_Specific_Date_Process_As_Daily(driver);
		  Labor_By_Job_Code_Report_Date_Range_Process_As_Daily(driver);
		 Thread.sleep(1000);
		Labor_By_Job_Code_Report_Today_Process_As_Weekly(driver);
		Labor_By_Job_Code_Report_Yesterday_Process_As_Weekly(driver);
		Labor_By_Job_Code_Report_Last_N_Days_Process_As_Weekly(driver);
		Labor_By_Job_Code_Report_This_Week_Process_As_Weekly(driver);
		Labor_By_Job_Code_Report_Last_Week_Process_As_Weekly(driver);
		Labor_By_Job_Code_Report_Last_7_Days_Process_As_Weekly(driver);
		Labor_By_Job_Code_Report_This_Month_Process_As_Weekly(driver);
		Labor_By_Job_Code_Report_Last_Month_Process_As_Weekly(driver);
		Labor_By_Job_Code_Report_Last_30_Days_Process_As_Weekly(driver);
		Labor_By_Job_Code_Report_Specific_Date_Process_As_Weekly(driver);
		Labor_By_Job_Code_Report_Date_Range_Process_As_Weekly(driver);
	}

	@Test(priority = 3, enabled = false)
	public void Open_Labor_By_Job_Code_Report_Page(SelfHealingDriver driver) throws Exception {

		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		Thread.sleep(5000);
		// Load the Menu Item sales report page
		driver.get(
				Utility.getProperty("baseURL") + Utility.getProperty("store_Id3") + "employee/laborByJobCode");

		Thread.sleep(5000);
		// Verify the Labor By Job Code Report page loeded or not
		repts.Verify_ReportHomePage("LABOR");

	}

	@Test(priority = 4, enabled = false)
	public void RefreshAndPaginination(SelfHealingDriver driver) throws Exception {
		cmp = new Common_XPaths(driver, test);

		// Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();

		// Verify Column Filtration
		cmp.Filter_Columns();
	}

	@Test(priority = 4, enabled = false)
	public void Select_Daily_As_Process(SelfHealingDriver driver) throws Exception {
		Thread.sleep(5000);
		// Click the employee label
		driver.findElement(By.xpath("(//span[contains(.,'Employee')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();

		Thread.sleep(500);
		// Click the sub process label
		driver.findElement(By.xpath("(//span[contains(.,'Process')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'Daily')]")).click();
		
		Thread.sleep(500);
		// Click the format label
		driver.findElement(By.xpath("(//span[contains(.,'Format')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'In Hours')]")).click();

		Thread.sleep(500);
		// Click the active/inactive label
		driver.findElement(By.xpath("(//span[contains(.,'Active/Inactive')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
		Thread.sleep(500);
		// Click the shift status label
		driver.findElement(By.xpath("(//span[contains(.,'Role')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
		Thread.sleep(500);
	}
	
	@Test(priority = 4, enabled = false)
	public void Select_Weekly_As_Process(SelfHealingDriver driver) throws Exception {
		Thread.sleep(5000);
		// Click the employee label
		driver.findElement(By.xpath("(//span[contains(.,'Employee')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();

		Thread.sleep(500);
		// Click the sub process label
		driver.findElement(By.xpath("(//span[contains(.,'Process')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'Weekly')]")).click();
		
		Thread.sleep(500);
		// Click the format label
		driver.findElement(By.xpath("(//span[contains(.,'Format')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'In Hours')]")).click();

		Thread.sleep(500);
		// Click the active/inactive label
		driver.findElement(By.xpath("(//span[contains(.,'Active/Inactive')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
		Thread.sleep(500);
		// Click the shift status label
		driver.findElement(By.xpath("(//span[contains(.,'Role')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
		Thread.sleep(500);
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Process_As_Daily_Weekly_In_Hours(SelfHealingDriver driver) throws Exception {
		test.log(LogStatus.INFO,
				"************************************************** Process as Daily/Weekly - In Hours(Start) **************************************************");
		

		Thread.sleep(5000);
		// Click the employee label
		driver.findElement(By.xpath("(//span[contains(.,'Employee')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();

		Thread.sleep(500);
		// Click the sub process label
		driver.findElement(By.xpath("(//span[contains(.,'Process')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'Daily/Weekly')]")).click();
		
		Thread.sleep(500);
		// Click the format label
		driver.findElement(By.xpath("(//span[contains(.,'Format')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'In Hours')]")).click();

		Thread.sleep(500);
		// Click the active/inactive label
		driver.findElement(By.xpath("(//span[contains(.,'Active/Inactive')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
		Thread.sleep(500);
		// Click the shift status label
		driver.findElement(By.xpath("(//span[contains(.,'Role')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		

		Thread.sleep(500);
	
		//Select Last N days
//		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));
		
		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();Thread.sleep(8000);
		
		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for the mentioned date(Active/Inactive is All)");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for the mentioned date(Active/Inactive is All)");
		
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Netsales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[3]")).getText());
			test.log(LogStatus.INFO, "Hours Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[4]")).getText());
			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[5]")).getText());
			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[6]")).getText());
			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[7]")).getText());
			Thread.sleep(3000);
		}
		
		
		Thread.sleep(500);
		// Click the active/inactive label
		driver.findElement(By.xpath("(//span[contains(.,'Active/Inactive')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'Active')]")).click();
		
		Thread.sleep(500);
		// Click the shift status label
		driver.findElement(By.xpath("(//span[contains(.,'Role')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		

		Thread.sleep(500);
	
		//Select Last N days
//		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));
		
		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();Thread.sleep(8000);
		
		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for the mentioned date(Active/Inactive is Active)");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for the mentioned date(Active/Inactive is Active)");
		
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Netsales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[3]")).getText());
			test.log(LogStatus.INFO, "Hours Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[4]")).getText());
			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[5]")).getText());
			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[6]")).getText());
			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[7]")).getText());
			Thread.sleep(3000);
		}
		
		
		
		Thread.sleep(500);
		// Click the active/inactive label
		driver.findElement(By.xpath("(//span[contains(.,'Active/Inactive')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'Inactive')]")).click();
		
		Thread.sleep(500);
		// Click the shift status label
		driver.findElement(By.xpath("(//span[contains(.,'Role')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		

		Thread.sleep(500);
	
		//Select Last N days
//		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));
		
		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();Thread.sleep(8000);
		
		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for the mentioned date(Active/Inactive is Inactive)");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for the mentioned date(Active/Inactive is Inactive)");
		
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Netsales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[3]")).getText());
			test.log(LogStatus.INFO, "Hours Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[4]")).getText());
			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[5]")).getText());
			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[6]")).getText());
			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[7]")).getText());
			Thread.sleep(3000);
		}
				
		test.log(LogStatus.INFO,
				"************************************************** Process as Daily/Weekly - In Hours(End) **************************************************");

	}
	
	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Process_As_Daily_Weekly_In_Time(SelfHealingDriver driver) throws Exception {
			test.log(LogStatus.INFO,
			"************************************************** Process as Daily/Weekly - In Time(Start) **************************************************");


			Thread.sleep(5000);
			// Click the employee label
			driver.findElement(By.xpath("(//span[contains(.,'Employee')]/../input)")).click();
			Thread.sleep(500);
			// Select the All option
			driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();

			Thread.sleep(500);
			// Click the sub process label
			driver.findElement(By.xpath("(//span[contains(.,'Process')]/../input)")).click();
			Thread.sleep(500);
			// Select the All option
			driver.findElement(By.xpath("//select-option[contains(.,'Daily/Weekly')]")).click();

			Thread.sleep(500);
			// Click the format label
			driver.findElement(By.xpath("(//span[contains(.,'Format')]/../input)")).click();
			Thread.sleep(500);
			// Select the All option
			driver.findElement(By.xpath("//select-option[contains(.,'In Time')]")).click();

			Thread.sleep(500);
			// Click the active/inactive label
			driver.findElement(By.xpath("(//span[contains(.,'Active/Inactive')]/../input)")).click();
			Thread.sleep(500);
			// Select the All option
			driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();

			Thread.sleep(500);
			// Click the shift status label
			driver.findElement(By.xpath("(//span[contains(.,'Role')]/../input)")).click();
			Thread.sleep(500);
			// Select the All option
			driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();


			Thread.sleep(500);

			//Select Last N days
//			repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));
			Thread.sleep(1000);
			// Click Apply
			repts.Click_ApplyButton();Thread.sleep(8000);

			Thread.sleep(8000);
			try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
			test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for the mentioned date(Active/Inactive is All)");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			} catch (Exception G) {

			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for the mentioned date(Active/Inactive is All)");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Netsales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[3]")).getText());
			test.log(LogStatus.INFO, "Hours Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[4]")).getText());
			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[5]")).getText());
			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[6]")).getText());
			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[7]")).getText());
			Thread.sleep(3000);
			}


			Thread.sleep(500);
			// Click the active/inactive label
			driver.findElement(By.xpath("(//span[contains(.,'Active/Inactive')]/../input)")).click();
			Thread.sleep(500);
			// Select the All option
			driver.findElement(By.xpath("//select-option[contains(.,'Active')]")).click();

			Thread.sleep(500);
			// Click the shift status label
			driver.findElement(By.xpath("(//span[contains(.,'Role')]/../input)")).click();
			Thread.sleep(500);
			// Select the All option
			driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();

			Thread.sleep(500);

			//Select Last N days
//			repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));

			Thread.sleep(1000);
			// Click Apply
			repts.Click_ApplyButton();Thread.sleep(8000);
			
			Thread.sleep(8000);
			try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
			test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for the mentioned date(Active/Inactive is Active)");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			} catch (Exception G) {

			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for the mentioned date(Active/Inactive is Active)");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Netsales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[3]")).getText());
			test.log(LogStatus.INFO, "Hours Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[4]")).getText());
			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[5]")).getText());
			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[6]")).getText());
			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[7]")).getText());
			Thread.sleep(3000);
			}



			Thread.sleep(500);
			// Click the active/inactive label
			driver.findElement(By.xpath("(//span[contains(.,'Active/Inactive')]/../input)")).click();
			Thread.sleep(500);
			// Select the All option
			driver.findElement(By.xpath("//select-option[contains(.,'Inactive')]")).click();

			Thread.sleep(500);
			// Click the shift status label
			driver.findElement(By.xpath("(//span[contains(.,'Role')]/../input)")).click();
			Thread.sleep(500);
			// Select the All option
			driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();

			Thread.sleep(500);

			//Select Last N days
//			repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));
			Thread.sleep(1000);
			// Click Apply
			repts.Click_ApplyButton();Thread.sleep(8000);

			Thread.sleep(8000);
			try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
			test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for the mentioned date(Active/Inactive is Inactive)");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			} catch (Exception G) {

			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for the mentioned date(Active/Inactive is Inactive)");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Netsales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[3]")).getText());
			test.log(LogStatus.INFO, "Hours Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[4]")).getText());
			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[5]")).getText());
			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[6]")).getText());
			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,'Summary')]/../../div[7]")).getText());
			Thread.sleep(3000);
			}

			test.log(LogStatus.INFO,
			"************************************************** Process as Daily/Weekly - In Time(End) **************************************************");

			}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Today_Process_As_Daily(SelfHealingDriver driver) throws Exception {
		test.log(LogStatus.INFO,
				"************************************************** Process as Daily(Start) **************************************************");

		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		Select_Daily_As_Process(driver);

		// Select Today
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		
		repts.Select_Today_TimePeriod();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Today");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Today");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Yesterday_Process_As_Daily(SelfHealingDriver driver) throws Exception {
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
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Yesterday");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Yesterday");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Last_N_Days_Process_As_Daily(SelfHealingDriver driver) throws Exception {
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
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(18000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Last N Days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Last N days");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_This_Week_Process_As_Daily(SelfHealingDriver driver) throws Exception {
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
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for This Week");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for This Week");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Last_Week_Process_As_Daily(SelfHealingDriver driver) throws Exception {
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
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Last Week");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Last Week");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Last_7_Days_Process_As_Daily(SelfHealingDriver driver) throws Exception {
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
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Last 7 days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Last 7 days");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_This_Month_Process_As_Daily(SelfHealingDriver driver) throws Exception {
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
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for This month");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for This month");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Last_Month_Process_As_Daily(SelfHealingDriver driver) throws Exception {
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
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Last month");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Last month");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Last_30_Days_Process_As_Daily(SelfHealingDriver driver) throws Exception {
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
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Last 30 days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Last 30 days");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Specific_Date_Process_As_Daily(SelfHealingDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select Specific Date
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		//Select Specific Date
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Specific Date");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Specific Date");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Date_Range_Process_As_Daily(SelfHealingDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);


		// Select Specific Date
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		//Select Date Range
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));


		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Date Range");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Date Range");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);
		}
		test.log(LogStatus.INFO,
				"************************************************** Process as Daily(End) **************************************************");
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Today_Process_As_Weekly(SelfHealingDriver driver) throws Exception {
		test.log(LogStatus.INFO,
				"************************************************** Process as Weekly(Start) **************************************************");

		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		Select_Weekly_As_Process(driver);

		// Select Today
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		repts.Select_Today_TimePeriod();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Today");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Today");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Yesterday_Process_As_Weekly(SelfHealingDriver driver) throws Exception {
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
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Yesterday");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Yesterday");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Last_N_Days_Process_As_Weekly(SelfHealingDriver driver) throws Exception {
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
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(18000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Last N Days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Last N days");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_This_Week_Process_As_Weekly(SelfHealingDriver driver) throws Exception {
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
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for This Week");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for This Week");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Last_Week_Process_As_Weekly(SelfHealingDriver driver) throws Exception {
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
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Last Week");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Last Week");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Last_7_Days_Process_As_Weekly(SelfHealingDriver driver) throws Exception {
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
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Last 7 days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Last 7 days");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_This_Month_Process_As_Weekly(SelfHealingDriver driver) throws Exception {
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
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for This month");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for This month");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Last_Month_Process_As_Weekly(SelfHealingDriver driver) throws Exception {
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
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Last month");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Last month");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Last_30_Days_Process_As_Weekly(SelfHealingDriver driver) throws Exception {
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
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Last 30 days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Last 30 days");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Specific_Date_Process_As_Weekly(SelfHealingDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select Specific Date
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		//Select Specific Date
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Specific Date");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Specific Date");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Labor_By_Job_Code_Report_Date_Range_Process_As_Weekly(SelfHealingDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select Specific Date
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}

		//Select Date Range
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();Thread.sleep(8000);

		Thread.sleep(8000);
		try {
			Thread.sleep(8000); if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Employee - Labor By Job Code Report Not Available for Date Range");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Employee - Labor By Job Code Report Available for Date Range");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Total Paid : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
			test.log(LogStatus.INFO, "% of Total Payroll : "+driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[2]")).getText());
//			test.log(LogStatus.INFO, "Labour Amount : Total "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[4]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[5]")).getText());
//			test.log(LogStatus.INFO, "% of Net Sales Total : "+driver.findElement(By.xpath("//span[contains(.,' Total Labor ')]/../../td[6]")).getText());
			Thread.sleep(3000);
		}
		test.log(LogStatus.INFO,
				"************************************************** Process as Weekly(End) **************************************************");
	}
}
