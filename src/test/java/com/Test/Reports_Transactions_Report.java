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
import com.epam.healenium.SelfHealingDriver;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports_Transactions_Report {

	public SelfHealingDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Transactions Report");

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
		// Call the chrome driver
		// System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
		// Open the Chrome window
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().driverVersion("110.0.5481").setup();
//		driver = new ChromeDriver(chromeOptions);
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		
		options.setHeadless(false);
		
		WebDriver delegate=new ChromeDriver();
		
		driver=SelfHealingDriver.create(delegate);
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
		Open_Transactions_Report_Page(driver);
//		RefreshAndPaginination(driver);
		
		  Transactions_Report_Today_PaymentName(driver);
		  Transactions_Report_Yesterday_PaymentName(driver);
		  Transactions_Report_Last_N_Days_PaymentName(driver);
		  Transactions_Report_This_Week_PaymentName(driver);
		  Transactions_Report_Last_Week_PaymentName(driver);
		  Transactions_Report_Last_7_Days_PaymentName(driver);
		  Transactions_Report_This_Month_PaymentName(driver);
		  Transactions_Report_Last_Month_PaymentName(driver);
		  Transactions_Report_Last_30_Days_PaymentName(driver);
		  Transactions_Report_Specific_Date_PaymentName(driver);
		  Transactions_Report_Date_Range_PaymentName(driver);
		 Thread.sleep(1000);
		Transactions_Report_Today_PaymentType(driver);
		Transactions_Report_Yesterday_PaymentType(driver);
		Transactions_Report_Last_N_Days_PaymentType(driver);
		Transactions_Report_This_Week_PaymentType(driver);
		Transactions_Report_Last_Week_PaymentType(driver);
		Transactions_Report_Last_7_Days_PaymentType(driver);
		Transactions_Report_This_Month_PaymentType(driver);
		Transactions_Report_Last_Month_PaymentType(driver);
		Transactions_Report_Last_30_Days_PaymentType(driver);
		Transactions_Report_Specific_Date_PaymentType(driver);
		Transactions_Report_Date_Range_PaymentType(driver);
	}

	@Test(priority = 3, enabled = false)
	public void Open_Transactions_Report_Page(SelfHealingDriver driver) throws Exception {

		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		Thread.sleep(5000);
		// Load the Menu Item sales report page
		driver.get(
				Utility.getProperty("baseURL") + Utility.getProperty("store_Id3") + "transactionsReport/transactions");

		Thread.sleep(5000);
		// Verify the transactions report page loeded or not
		repts.Verify_ReportHomePage("TRANSACTIONS");

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
	public void SelectTheTenderName(SelfHealingDriver driver) throws Exception {
		Thread.sleep(5000);
		// Click the category label
		driver.findElement(By.xpath("(//span[contains(.,'Tender Option')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'Name')]")).click();

		Thread.sleep(500);
		// Click the sub category label
		driver.findElement(By.xpath("(//span[contains(.,'Tender Name')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();

		// Click the category label
		driver.findElement(By.xpath("(//span[contains(.,'Sale Close Date')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'Last N days')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//span[contains(.,'Number of Days')]/../input)")).clear();
		driver.findElement(By.xpath("(//span[contains(.,'Number of Days')]/../input)")).sendKeys("100");
		Thread.sleep(500);
	}

	@Test(priority = 4, enabled = false)
	public void SelectTheTenderType(SelfHealingDriver driver) throws Exception {
		Thread.sleep(5000);
		// Click the category label
		driver.findElement(By.xpath("(//span[contains(.,'Tender Option')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'Type')]")).click();

		Thread.sleep(500);
		// Click the sub category label
		driver.findElement(By.xpath("(//span[contains(.,'Tender Type')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();

		// Click the category label
		driver.findElement(By.xpath("(//span[contains(.,'Sale Close Date')]/../input)")).click();
		Thread.sleep(500);
		// Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'Last N days')]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//span[contains(.,'Number of Days')]/../input)")).clear();
		driver.findElement(By.xpath("(//span[contains(.,'Number of Days')]/../input)")).sendKeys("100");
		Thread.sleep(500);
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Today_PaymentName(SelfHealingDriver driver) throws Exception {
		test.log(LogStatus.INFO,
				"************************************************** Tender By Name(Start) **************************************************");

		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheTenderName(driver);

		// Select Today
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Today')]")).click();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Today");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Transaction Report Available for Today");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList = driver
					.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

			for (int i = 10; i <= colList.size(); i++) {
				test.log(LogStatus.INFO, "Total "
						+ driver.findElement(By.xpath(
								"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
								.getText()
						+ " value is available for the mentioned time period - Today : "
						+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Yesterday_PaymentName(SelfHealingDriver driver) throws Exception {
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
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Yesterday')]")).click();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Yesterday");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for Yesterday");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList = driver
					.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

			for (int i = 10; i <= colList.size(); i++) {
				test.log(LogStatus.INFO, "Total "
						+ driver.findElement(By.xpath(
								"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
								.getText()
						+ " value is available for the mentioned time period - Yesterday : "
						+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Last_N_Days_PaymentName(SelfHealingDriver driver) throws Exception {
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
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Last N days')]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//span[contains(.,'Number of Days')]/../input)")).clear();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//span[contains(.,'Number of Days')]/../input)"))
				.sendKeys(Utility.getProperty("NumberOfDays"));

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Last N Days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for Last N days");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList = driver
					.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

			for (int i = 10; i <= colList.size(); i++) {
				test.log(LogStatus.INFO, "Total "
						+ driver.findElement(By.xpath(
								"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
								.getText()
						+ " value is available for the mentioned time period - Last N Days : "
						+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_This_Week_PaymentName(SelfHealingDriver driver) throws Exception {
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
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'This week')]")).click();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for This Week");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for This Week");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList = driver
					.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

			for (int i = 10; i <= colList.size(); i++) {
				test.log(LogStatus.INFO, "Total "
						+ driver.findElement(By.xpath(
								"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
								.getText()
						+ " value is available for the mentioned time period - This Week : "
						+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Last_Week_PaymentName(SelfHealingDriver driver) throws Exception {
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
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Last week')]")).click();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Last Week");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for Last Week");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();
			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			try {
				List<WebElement> colList = driver.findElements(
						By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

				for (int i = 10; i <= colList.size(); i++) {
					test.log(LogStatus.INFO,
							"Total " + driver.findElement(By.xpath(
									"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
									.getText() + " value is available for the mentioned time period - Last Week : "
									+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]"))
											.getText());
				}

				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				Thread.sleep(3000);
			} catch (Exception f) {
				test.log(LogStatus.FAIL, "Total values are not available but some transaction reoprts are available");
			}

		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Last_7_Days_PaymentName(SelfHealingDriver driver) throws Exception {
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
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Last 7 days')]")).click();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Last 7 days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for Last 7 days");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList = driver
					.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

			for (int i = 10; i <= colList.size(); i++) {
				test.log(LogStatus.INFO, "Total "
						+ driver.findElement(By.xpath(
								"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
								.getText()
						+ " value is available for the mentioned time period - Last 7 Days : "
						+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_This_Month_PaymentName(SelfHealingDriver driver) throws Exception {
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
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'This month')]")).click();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for This month");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for This month");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			try {
				List<WebElement> colList = driver.findElements(
						By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

				for (int i = 10; i <= colList.size(); i++) {
					test.log(LogStatus.INFO,
							"Total " + driver.findElement(By.xpath(
									"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
									.getText() + " value is available for the mentioned time period - Last Week : "
									+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]"))
											.getText());
				}

				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				Thread.sleep(3000);
			} catch (Exception f) {
				test.log(LogStatus.FAIL, "Total values are not available but some transaction reoprts are available");
			}

		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Last_Month_PaymentName(SelfHealingDriver driver) throws Exception {
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
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Last month')]")).click();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Last month");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for Last month");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList = driver
					.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

			for (int i = 10; i <= colList.size(); i++) {
				test.log(LogStatus.INFO, "Total "
						+ driver.findElement(By.xpath(
								"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
								.getText()
						+ " value is available for the mentioned time period - Last Month : "
						+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Last_30_Days_PaymentName(SelfHealingDriver driver) throws Exception {
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
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Last 30 days')]")).click();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Last 30 days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for Last 30 days");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList = driver
					.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

			for (int i = 10; i <= colList.size(); i++) {
				test.log(LogStatus.INFO, "Total "
						+ driver.findElement(By.xpath(
								"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
								.getText()
						+ " value is available for the mentioned time period - Last 30 days : "
						+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Specific_Date_PaymentName(SelfHealingDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		String SpecificDate = Utility.getProperty("Report_Specific_Date");
		// Select Specific Date
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Specific date')]")).click();

		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@aria-label='Open calendar']")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).click();
		String year = SpecificDate.substring(6, 10);

		driver.findElement(By.xpath("//div[contains(.,'" + year + "') and contains(@class,'mat-calendar-body-today')]"))
				.click();

		String months = SpecificDate.substring(3, 5);
		String month = repts.selectMonth(months);

		driver.findElement(By.xpath("//div[contains(.,'" + month + "') and contains(@class,'mat-calendar-body')]"))
				.click();

		String days = SpecificDate.substring(0, 2);
		String day = repts.selectDate(days);

		driver.findElement(By.xpath("//div[contains(.,'" + day + "') and contains(@class,'mat-calendar-body')]"))
				.click();

		// Date_inSpecificDateInputBx.clear();
		Thread.sleep(500);
		// Date_inSpecificDateInputBx.sendKeys(SpecificDate);

		// repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Specific Date");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for Specific Date");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList = driver
					.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

			for (int i = 10; i <= colList.size(); i++) {
				test.log(LogStatus.INFO, "Total "
						+ driver.findElement(By.xpath(
								"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
								.getText()
						+ " value is available for the mentioned time period - Specific Date : "
						+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Date_Range_PaymentName(SelfHealingDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select Date Range
		String FromDate = Utility.getProperty("Report_Start_Date");
		String ToDate = Utility.getProperty("Report_End_Date");

		// Select Specific Date
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Date range')]")).click();

		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@aria-label='Open calendar'])[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).click();
		String year = FromDate.substring(6, 10);

		driver.findElement(By.xpath("//div[contains(.,'" + year + "') and contains(@class,'mat-calendar-body-today')]"))
				.click();

		String months = FromDate.substring(3, 5);
		String month = repts.selectMonth(months);

		driver.findElement(By.xpath("//div[contains(.,'" + month + "') and contains(@class,'mat-calendar-body')]"))
				.click();

		String days = FromDate.substring(0, 2);
		String day = repts.selectDate(days);

		driver.findElement(By.xpath("//div[contains(.,'" + day + "') and contains(@class,'mat-calendar-body')]"))
				.click();

		// Date_inSpecificDateInputBx.clear();
		Thread.sleep(500);

		// Start_DateInputBx.sendKeys(FromDate);

		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@aria-label='Open calendar'])[2]")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).click();
		String year1 = ToDate.substring(6, 10);

		driver.findElement(
				By.xpath("//div[contains(.,'" + year1 + "') and contains(@class,'mat-calendar-body-today')]")).click();

		String months1 = ToDate.substring(3, 5);
		String month1 = repts.selectMonth(months1);

		driver.findElement(By.xpath("//div[contains(.,'" + month1 + "') and contains(@class,'mat-calendar-body')]"))
				.click();

		String days1 = ToDate.substring(0, 2);
		String day1 = repts.selectDate(days1);

		driver.findElement(By.xpath("//div[contains(.,'" + day1 + "') and contains(@class,'mat-calendar-body')]"))
				.click();

		Thread.sleep(500);

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Date Range");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for Date Range");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			try {
				List<WebElement> colList = driver.findElements(
						By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

				for (int i = 10; i <= colList.size(); i++) {
					test.log(LogStatus.INFO,
							"Total " + driver.findElement(By.xpath(
									"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
									.getText() + " value is available for the mentioned time period - Last Week : "
									+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]"))
											.getText());
				}

				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				Thread.sleep(3000);
			} catch (Exception f) {
				test.log(LogStatus.FAIL, "Total values are not available but some transaction reoprts are available");
			}
		}
		test.log(LogStatus.INFO,
				"************************************************** Tender By Name(End) **************************************************");
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Today_PaymentType(SelfHealingDriver driver) throws Exception {
		test.log(LogStatus.INFO,
				"************************************************** Tender By Type(Start) **************************************************");

		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheTenderType(driver);

		// Select Today
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Today')]")).click();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Today");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Transaction Report Available for Today");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList = driver
					.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

			for (int i = 10; i <= colList.size(); i++) {
				test.log(LogStatus.INFO, "Total "
						+ driver.findElement(By.xpath(
								"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
								.getText()
						+ " value is available for the mentioned time period - Today : "
						+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Yesterday_PaymentType(SelfHealingDriver driver) throws Exception {
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
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Yesterday')]")).click();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Yesterday");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for Yesterday");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList = driver
					.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

			for (int i = 10; i <= colList.size(); i++) {
				test.log(LogStatus.INFO, "Total "
						+ driver.findElement(By.xpath(
								"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
								.getText()
						+ " value is available for the mentioned time period - Yesterday : "
						+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Last_N_Days_PaymentType(SelfHealingDriver driver) throws Exception {
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
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Last N days')]")).click();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//span[contains(.,'Number of Days')]/../input)")).clear();
		Thread.sleep(1000);

		driver.findElement(By.xpath("(//span[contains(.,'Number of Days')]/../input)"))
				.sendKeys(Utility.getProperty("NumberOfDays"));

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Last N Days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for Last N days");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList = driver
					.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

			for (int i = 10; i <= colList.size(); i++) {
				test.log(LogStatus.INFO, "Total "
						+ driver.findElement(By.xpath(
								"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
								.getText()
						+ " value is available for the mentioned time period - Last N Days : "
						+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_This_Week_PaymentType(SelfHealingDriver driver) throws Exception {
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
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'This week')]")).click();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for This Week");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for This Week");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList = driver
					.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

			for (int i = 10; i <= colList.size(); i++) {
				test.log(LogStatus.INFO, "Total "
						+ driver.findElement(By.xpath(
								"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
								.getText()
						+ " value is available for the mentioned time period - This Week : "
						+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Last_Week_PaymentType(SelfHealingDriver driver) throws Exception {
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
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Last week')]")).click();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Last Week");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for Last Week");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();
			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			try {
				List<WebElement> colList = driver.findElements(
						By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

				for (int i = 10; i <= colList.size(); i++) {
					test.log(LogStatus.INFO,
							"Total " + driver.findElement(By.xpath(
									"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
									.getText() + " value is available for the mentioned time period - Last Week : "
									+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]"))
											.getText());
				}

				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				Thread.sleep(3000);
			} catch (Exception f) {
				test.log(LogStatus.FAIL, "Total values are not available but some transaction reoprts are available");
			}

		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Last_7_Days_PaymentType(SelfHealingDriver driver) throws Exception {
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
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Last 7 days')]")).click();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Last 7 days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for Last 7 days");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList = driver
					.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

			for (int i = 10; i <= colList.size(); i++) {
				test.log(LogStatus.INFO, "Total "
						+ driver.findElement(By.xpath(
								"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
								.getText()
						+ " value is available for the mentioned time period - Last 7 Days : "
						+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_This_Month_PaymentType(SelfHealingDriver driver) throws Exception {
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
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'This month')]")).click();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for This month");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for This month");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			try {
				List<WebElement> colList = driver.findElements(
						By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

				for (int i = 10; i <= colList.size(); i++) {
					test.log(LogStatus.INFO,
							"Total " + driver.findElement(By.xpath(
									"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
									.getText() + " value is available for the mentioned time period - Last Week : "
									+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]"))
											.getText());
				}

				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				Thread.sleep(3000);
			} catch (Exception f) {
				test.log(LogStatus.FAIL, "Total values are not available but some transaction reoprts are available");
			}

		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Last_Month_PaymentType(SelfHealingDriver driver) throws Exception {
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
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Last month')]")).click();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Last month");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for Last month");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList = driver
					.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

			for (int i = 10; i <= colList.size(); i++) {
				test.log(LogStatus.INFO, "Total "
						+ driver.findElement(By.xpath(
								"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
								.getText()
						+ " value is available for the mentioned time period - Last Month : "
						+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Last_30_Days_PaymentType(SelfHealingDriver driver) throws Exception {
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
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Last 30 days')]")).click();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Last 30 days");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for Last 30 days");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList = driver
					.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

			for (int i = 10; i <= colList.size(); i++) {
				test.log(LogStatus.INFO, "Total "
						+ driver.findElement(By.xpath(
								"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
								.getText()
						+ " value is available for the mentioned time period - Last 30 Days : "
						+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Specific_Date_PaymentType(SelfHealingDriver driver) throws Exception {
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
		String SpecificDate = Utility.getProperty("Report_Specific_Date");
		// Select Specific Date
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Specific date')]")).click();

		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(3000);
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[@aria-label='Open calendar']")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).click();
		String year = SpecificDate.substring(6, 10);

		driver.findElement(By.xpath("//div[contains(.,'" + year + "') and contains(@class,'mat-calendar-body-today')]"))
				.click();

		String months = SpecificDate.substring(3, 5);
		String month = repts.selectMonth(months);

		driver.findElement(By.xpath("//div[contains(.,'" + month + "') and contains(@class,'mat-calendar-body')]"))
				.click();

		String days = SpecificDate.substring(0, 2);
		String day = repts.selectDate(days);

		driver.findElement(By.xpath("//div[contains(.,'" + day + "') and contains(@class,'mat-calendar-body')]"))
				.click();

		// Date_inSpecificDateInputBx.clear();
		Thread.sleep(500);
		// Date_inSpecificDateInputBx.sendKeys(SpecificDate);

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Specific Date");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for Specific Date");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList = driver
					.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

			for (int i = 10; i <= colList.size(); i++) {
				test.log(LogStatus.INFO, "Total "
						+ driver.findElement(By.xpath(
								"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
								.getText()
						+ " value is available for the mentioned time period - Specific Date : "
						+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4, enabled = false)
	public void Transactions_Report_Date_Range_PaymentType(SelfHealingDriver driver) throws Exception {
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		// ExcelDataConfig excel=new
		// ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		// SelectTheCat(driver);

		// Select Date Range
		String FromDate = Utility.getProperty("Report_Start_Date");
		String ToDate = Utility.getProperty("Report_End_Date");

		// Select Specific Date
		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		driver.findElement(By.xpath("//label[contains(.,'Transaction Date')]/../../input")).click();
		Thread.sleep(500);

		driver.findElement(By.xpath("//select-option[contains(.,'Date range')]")).click();

		for (int i = 1; i <= 10; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@aria-label='Open calendar'])[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).click();
		String year = FromDate.substring(6, 10);

		driver.findElement(By.xpath("//div[contains(.,'" + year + "') and contains(@class,'mat-calendar-body-today')]"))
				.click();

		String months = FromDate.substring(3, 5);
		String month = repts.selectMonth(months);

		driver.findElement(By.xpath("//div[contains(.,'" + month + "') and contains(@class,'mat-calendar-body')]"))
				.click();

		String days = FromDate.substring(0, 2);
		String day = repts.selectDate(days);

		driver.findElement(By.xpath("//div[contains(.,'" + day + "') and contains(@class,'mat-calendar-body')]"))
				.click();

		// Date_inSpecificDateInputBx.clear();
		Thread.sleep(500);

		// Start_DateInputBx.sendKeys(FromDate);

		Thread.sleep(1000);
		driver.findElement(By.xpath("(//button[@aria-label='Open calendar'])[2]")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).click();
		String year1 = ToDate.substring(6, 10);

		driver.findElement(
				By.xpath("//div[contains(.,'" + year1 + "') and contains(@class,'mat-calendar-body-today')]")).click();

		String months1 = ToDate.substring(3, 5);
		String month1 = repts.selectMonth(months1);

		driver.findElement(By.xpath("//div[contains(.,'" + month1 + "') and contains(@class,'mat-calendar-body')]"))
				.click();

		String days1 = ToDate.substring(0, 2);
		String day1 = repts.selectDate(days1);

		driver.findElement(By.xpath("//div[contains(.,'" + day1 + "') and contains(@class,'mat-calendar-body')]"))
				.click();

		Thread.sleep(500);

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(8000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Transaction Report Not Available for Date Range");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {
			test.log(LogStatus.PASS, "Transaction Report Available for Date Range");

			Thread.sleep(2000);
			// Verify Donut Chart screen
			// repts.Verify_Donut_Chart_Screen_TopSales();

			// Verify Bars Chart Screen
			// repts.Verify_Bars_Chart_Screen_TopSales();

			// Verify Sales By Hours
			// repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			// Do pagination to Last
			// repts.Do_Pagination();

			Thread.sleep(3000);
			// Get Sale Amount
			// List<WebElement>
			// rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			try {
				List<WebElement> colList = driver.findElements(
						By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));

				for (int i = 10; i <= colList.size(); i++) {
					test.log(LogStatus.INFO,
							"Total " + driver.findElement(By.xpath(
									"//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[" + i + "]"))
									.getText() + " value is available for the mentioned time period - Last Week : "
									+ driver.findElement(By.xpath("//div[contains(@class,'total row')]/div[" + i + "]"))
											.getText());
				}

				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				Thread.sleep(3000);
			} catch (Exception f) {
				test.log(LogStatus.FAIL, "Total values are not available but some transaction reoprts are available");
			}
		}
		test.log(LogStatus.INFO,
				"************************************************** Tender By Type(End) **************************************************");
	}
}
