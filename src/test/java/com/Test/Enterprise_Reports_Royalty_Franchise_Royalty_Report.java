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
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Enterprise_Reports_Royalty_Franchise_Royalty_Report {

	public SelfHealingDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise Reports - Royalty/Franchise - Royalty Report");

	LoginPage lgpg;
	public String st = "NA";

	Utility ut = new Utility();

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
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().driverVersion("110.0.5841").setup();
//		driver=new ChromeDriver(chrOpt);

//		System.setProperty("webdriver.chrome.driver", "./Automation Driver/chromedriver.exe");
//		// Open the Chrome window
//		driver = new ChromeDriver();

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
		Open_Enterprise_Settings_Royalty_Franchise_Report_Page(driver);
		//RefreshAndPaginination(driver);
		
		Royalty_report_Selected_Store_Selected_Discount_N_Number_of_time_Period(driver);
		Royalty_report_Selected_Group_Selected_Discount_N_Number_of_time_Period(driver);
		Royalty_report_Selected_State_Selected_Discount_N_Number_of_time_Period(driver);
		Royalty_report_Selected_City_Selected_Discount_N_Number_of_time_Period(driver);
		Royalty_report_Selected_ZipCode_Selected_Discount_N_Number_of_time_Period(driver);
		Royalty_report_Selected_Store_Selected_Discount_Today_time_Period(driver);
		Royalty_report_Selected_Store_Selected_Discount_Yesterday_time_Period(driver);
		Royalty_report_Selected_Store_Selected_Discount_ThisWeek_time_Period(driver);
		Royalty_report_Selected_Store_Selected_Discount_Last_Seaven_Days_time_Period(driver);
		Royalty_report_Selected_Store_Selected_Discount_LastWeek_time_Period(driver);
		Royalty_report_Selected_Store_Selected_Discount_ThisMonth_time_Period(driver);
		Royalty_report_Selected_Store_Selected_Discount_LastMonth_time_Period(driver);
		Royalty_report_Selected_Store_Selected_Discount_Last_thirtyDays_time_Period(driver);
		
		Royalty_report_Selected_Store_Selected_Discount_SpecificDate_time_Period(driver);
		Royalty_report_Selected_Store_Selected_Discount_Date_Ranage_time_Period(driver);
		
		

	}

	@Test(priority = 3, enabled = false)
	public void Open_Enterprise_Settings_Royalty_Franchise_Report_Page(SelfHealingDriver driver) throws Exception {

		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		Thread.sleep(5000);
		// Load the Department page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id7") + "home");

		Thread.sleep(10000);
		// Load the Department page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id7")
				+ "enterpriseReports/royaltyFranchiseReports/royalty");

		Thread.sleep(5000);
		// Verify the Categories page loaded or not
		repts.Verify_ReportHomePage("ROYALTY");

	}

	@Test(priority = 4, enabled = false)
	public void RefreshAndPaginination(SelfHealingDriver driver) throws Exception {
		cmp = new Common_XPaths(driver, test);

		// Verify the Pagination and Refresh the page
		cmp.VerifyPagination_and_Refresh_Publish();

		// Verify Column Filtration
		cmp.Filter_Columns();

		// Ascending and Descending Sorting
		cmp.Ascending_And_Descending_Order();
	}

	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Store_Selected_Discount_N_Number_of_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Store");

		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_Last_N_Days_TimePeriod("200");

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();

					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	
	
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Group_Selected_Discount_N_Number_of_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Group");
		
		
	    repts.Select_All_Group_in_DropDown_EnterpriseReport();

		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_Last_N_Days_TimePeriod("200");

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_State_Selected_Discount_N_Number_of_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("State");
		
		
	    repts.Select_All_State_in_DropDown_EnterpriseReport();

		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_Last_N_Days_TimePeriod("200");

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();

					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_City_Selected_Discount_N_Number_of_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("City");
		
		
	    repts.Select_All_City_in_DropDown_EnterpriseReport();

		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_Last_N_Days_TimePeriod("200");

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_ZipCode_Selected_Discount_N_Number_of_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("ZipCode");
		
		
	    repts.Select_All_ZiP_Code_in_DropDown_EnterpriseReport();

		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_Last_N_Days_TimePeriod("200");

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Store_Selected_Discount_Today_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Store");

		
		


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_Today_TimePeriod();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}

	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Store_Selected_Discount_Yesterday_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Store");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_Yesterday_TimePeriod();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}

	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Store_Selected_Discount_ThisWeek_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Store");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_This_Week_TimePeriod();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Store_Selected_Discount_Last_Seaven_Days_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Store");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_Last_7_Days_TimePeriod();
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Store_Selected_Discount_LastWeek_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Store");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_Last_Week_TimePeriod();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Store_Selected_Discount_ThisMonth_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Store");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_This_Month_TimePeriod();
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(2000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Store_Selected_Discount_LastMonth_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Store");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_Last_Month_TimePeriod();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	
	
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Store_Selected_Discount_Last_thirtyDays_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Store");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_Last_30_Days_TimePeriod();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	
	
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Store_Selected_Discount_SpecificDate_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Store");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		//Select Today
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Store_Selected_Discount_Date_Ranage_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Store");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();


		Thread.sleep(1000);
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
			
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Group_Selected_Discount_Today_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Group");

		
		


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_Today_TimePeriod();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}

	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Group_Selected_Discount_Yesterday_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
	         repts.Select_Store("Group");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_Yesterday_TimePeriod();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}

	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Group_Selected_Discount_ThisWeek_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Group");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_This_Week_TimePeriod();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Group_Selected_Discount_Last_Seaven_Days_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Group");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_Last_7_Days_TimePeriod();
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Group_Selected_Discount_LastWeek_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Group");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_Last_Week_TimePeriod();

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Group_Selected_Discount_ThisMonth_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Group");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_This_Month_TimePeriod();
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(2000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Group_Selected_Discount_LastMonth_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Group");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_Last_Month_TimePeriod();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	
	
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Group_Selected_Discount_Last_thirtyDays_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
			repts.Select_Store("Group");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		// Select Today
		repts.Select_Last_30_Days_TimePeriod();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	
	
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Group_Selected_Discount_SpecificDate_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
			repts.Select_Store("Group");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();

		Thread.sleep(1000);
		//Select Today
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	@Test(priority = 4, enabled = false)
	public void Royalty_report_Selected_Group_Selected_Discount_Date_Ranage_time_Period(SelfHealingDriver driver)
			throws Exception {
		repts = new ReportsPage(driver, test);
		cmp = new Common_XPaths(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Membership_Statement_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Select the Node
		repts.Select_Store("Group");


		//repts.Store_Selection_in_DropDown_EnterpriseReport();

		//repts.Selected_Discounts();


		Thread.sleep(1000);
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
			
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		// Click Apply
		repts.Click_ApplyButton();

		Thread.sleep(5000);
		try {
			if (repts.No_TransactionFound_InfoMessage().isDisplayed()) {
				test.log(LogStatus.INFO, "Royalty Report Not Available for Selected Time Period");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		} catch (Exception G) {

			test.log(LogStatus.PASS, "Royalty Report Available for Selected Time Period");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

			List<WebElement> rowList = driver.findElements(By.xpath("//section/table/tbody/tr"));

			int rowSize = rowList.size();

			if (rowSize <= 5) {
				for (int i = 1; i <= rowSize; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			} else {
				for (int i = 1; i <= 5; i++) {

					String StoreName = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[1]/span"))
							.getText();

					String Business_Date = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[2]/span")).getText();

					String Net_Sales = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span"))
							.getText();

					String Chargeable_Discount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[3]/span")).getText();

					String Loyalty_Redemption = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[4]/span")).getText();

					String Royalty_Subjected_Amount = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[5]/span")).getText();

					String Gift_Card_Sold = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[6]/span")).getText();

					String Gift_Card_Redeemed = driver
							.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[7]/span")).getText();

					String Royalty_Fee = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[8]/span"))
							.getText();

					String Total_Due = driver.findElement(By.xpath("//section/table/tbody/tr["+ i +"]/td[9]/span"))
							.getText();


					test.log(LogStatus.INFO, "StoreName is : " + StoreName + " Business_Date No is: " + Business_Date
							+ " Net_Sales is : " + Net_Sales + " Chargeable_Discount is : " + Chargeable_Discount
							+ " Loyalty_Redemption is : " + Loyalty_Redemption + " Royalty_Subjected_Amount is : "
							+ Royalty_Subjected_Amount + " Gift_Card_Sold : " + Gift_Card_Sold
							+ " Gift_Card_Redeemed is : " + Gift_Card_Redeemed + "Royalty_Fee is : " + Royalty_Fee
							+ "Total_Due is : " + Total_Due);

				}
			}

		}
	}
	

}
