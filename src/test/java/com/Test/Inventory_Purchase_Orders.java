package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.Common_XPaths;
import com.Pages.Inventory_Purchase_Order_Page;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Purchase_Orders {

	public WebDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Purchase Order");

	LoginPage lgpg;

	Utility ut = new Utility();

	String st = "NA";

	Common_XPaths cmp;
	Inventory_Purchase_Order_Page ipo;
	ReportsPage rp;
	
	LoginTest a = new LoginTest();

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
		Open_PurchaseOrder_Page(driver);
		RefreshAndPaginination(driver);
		AddPartialOrder(driver);
		//verifyTheStatus_And_Options(driver);
	}

	@Test(priority = 3, enabled = false)
	public void Open_PurchaseOrder_Page(WebDriver driver) throws Exception {

		cmp = new Common_XPaths(driver, test);

		Thread.sleep(5000);
		// Load the Menu Item sales report page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "purchases/purchaseOrders");

		Thread.sleep(5000);
		//Verify the Menu Item sales report page loeded or not
		try {
			if(driver.findElement(By.xpath("//h3[contains(.,'Purchase Orders')]")).isDisplayed()) {
				test.log(LogStatus.PASS, "Purchase Orders page is loaded successfully");
			}
		}catch(Exception E) {
			test.log(LogStatus.FAIL, "Purchase Orders page is not loaded");
		}

	}

	@Test(priority = 4, enabled = false)
	public void RefreshAndPaginination(WebDriver driver) throws Exception {
		cmp = new Common_XPaths(driver, test);

		// Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();

		// Verify Column Filtration
		cmp.Filter_Columns_Table();
	}

	@Test(priority = 4, enabled = false)	
	public void AddPartialOrder(WebDriver driver) throws Exception {
		
		ipo = new Inventory_Purchase_Order_Page(driver, test);
		
		//Click the Purchase order
		ipo.Click_New_Purchase_Order_Btn();
		
		Thread.sleep(3000);
		
		ipo.verify_New_Purchase_Order_Screen();
		
		ipo.select_Vendor();
		
		ipo.select_Calendar();
		
		ipo.select_The_Email();
		
		ipo.Add_Inventory_Item();
	}
	
	@Test(priority = 4, enabled = false)	
	public void verifyTheStatus_And_Options(WebDriver driver) throws Exception {
		
		ipo = new Inventory_Purchase_Order_Page(driver, test);
		
		ipo.verify_The_Status();
		
		ipo.verifyThe_Placed_Status_Options();
		
		ipo.verifyThe_Partially_Received_Status_Options();
		
		ipo.verifyThe_Received_Status_Options();
		
		ipo.verifyThe_Cancelled_Status_Options();
	}
	
	@Test(priority = 4, enabled = false)	
	public void verify_Today(WebDriver driver) throws Exception {
		rp = new ReportsPage(driver, test);
		
		rp.Select_Today_TimePeriod();
		
		//Click the Apply button
		driver.findElement(By.xpath("//button[contains(.,'Apply')]")).click();Thread.sleep(1500);
		
		try {
			if (driver.findElement(By.xpath("//span[.='No Purchase Orders Found']")).isDisplayed()) {
				test.log(LogStatus.INFO, "Data not available for Today");
			}
		} catch (Exception d) {
			test.log(LogStatus.INFO, "Data available for Today");
		}
	}
	
	@Test(priority = 4, enabled = false)	
	public void verify_Yesterday(WebDriver driver) throws Exception {
		rp = new ReportsPage(driver, test);
		
		rp.Select_Yesterday_TimePeriod();
		
		//Click the Apply button
		driver.findElement(By.xpath("//button[contains(.,'Apply')]")).click();Thread.sleep(1500);
		
		try {
			if (driver.findElement(By.xpath("//span[.='No Purchase Orders Found']")).isDisplayed()) {
				test.log(LogStatus.INFO, "Data not available for Yesterday");
			}
		} catch (Exception d) {
			test.log(LogStatus.INFO, "Data available for Yesterday");
		}
	}
	
	@Test(priority = 4, enabled = false)	
	public void verify_LastNDays(WebDriver driver) throws Exception {
		rp = new ReportsPage(driver, test);
		
		rp.Select_Last_N_Days_TimePeriod("1000");
		
		//Click the Apply button
		driver.findElement(By.xpath("//button[contains(.,'Apply')]")).click();Thread.sleep(1500);
		
		try {
			if (driver.findElement(By.xpath("//span[.='No Purchase Orders Found']")).isDisplayed()) {
				test.log(LogStatus.INFO, "Data not available for Last N Days");
			}
		} catch (Exception d) {
			test.log(LogStatus.INFO, "Data available for Last N days");
		}
	}
	
	@Test(priority = 4, enabled = false)	
	public void verify_ThisWeek(WebDriver driver) throws Exception {
		rp = new ReportsPage(driver, test);
		
		rp.Select_This_Week_TimePeriod();
		
		//Click the Apply button
		driver.findElement(By.xpath("//button[contains(.,'Apply')]")).click();Thread.sleep(1500);
		
		try {
			if (driver.findElement(By.xpath("//span[.='No Purchase Orders Found']")).isDisplayed()) {
				test.log(LogStatus.INFO, "Data not available for This Week");
			}
		} catch (Exception d) {
			test.log(LogStatus.INFO, "Data available for This Week");
		}
	}
	
	@Test(priority = 4, enabled = false)	
	public void verify_LastWeek(WebDriver driver) throws Exception {
		rp = new ReportsPage(driver, test);
		
		rp.Select_Last_Week_TimePeriod();
		
		//Click the Apply button
		driver.findElement(By.xpath("//button[contains(.,'Apply')]")).click();Thread.sleep(1500);
		
		try {
			if (driver.findElement(By.xpath("//span[.='No Purchase Orders Found']")).isDisplayed()) {
				test.log(LogStatus.INFO, "Data not available for Last Week");
			}
		} catch (Exception d) {
			test.log(LogStatus.INFO, "Data available for Last Week");
		}
	}
	
	@Test(priority = 4, enabled = false)	
	public void verify_Last7Days(WebDriver driver) throws Exception {
		rp = new ReportsPage(driver, test);
		
		rp.Select_Last_7_Days_TimePeriod();
		
		//Click the Apply button
		driver.findElement(By.xpath("//button[contains(.,'Apply')]")).click();Thread.sleep(1500);
		
		try {
			if (driver.findElement(By.xpath("//span[.='No Purchase Orders Found']")).isDisplayed()) {
				test.log(LogStatus.INFO, "Data not available for Last 7 Days");
			}																																																													
		} catch (Exception d) {
			test.log(LogStatus.INFO, "Data available for Last 7 Days");
		}
	}
	
	@Test(priority = 4, enabled = false)	
	public void verify_ThisMonth(WebDriver driver) throws Exception {
		rp = new ReportsPage(driver, test);
		
		rp.Select_This_Month_TimePeriod();
		
		//Click the Apply button
		driver.findElement(By.xpath("//button[contains(.,'Apply')]")).click();Thread.sleep(1500);
		
		
		try {
			if (driver.findElement(By.xpath("//span[.='No Purchase Orders Found']")).isDisplayed()) {
				test.log(LogStatus.INFO, "Data not available for This Month");
			}
		} catch (Exception d) {
			test.log(LogStatus.INFO, "Data available for This month");
		}
	}
	
	
	@Test(priority = 4, enabled = false)	
	public void verify_LastMonth(WebDriver driver) throws Exception {
		rp = new ReportsPage(driver, test);
		
		rp.Select_Last_Month_TimePeriod();
		
		//Click the Apply button
		driver.findElement(By.xpath("//button[contains(.,'Apply')]")).click();Thread.sleep(1500);
		
		
		try {
			if (driver.findElement(By.xpath("//span[.='No Purchase Orders Found']")).isDisplayed()) {
				test.log(LogStatus.INFO, "Data not available for Last Month");
			}
		} catch (Exception d) {
			test.log(LogStatus.INFO, "Data available for Last Month");
		}
	}
	
	@Test(priority = 4, enabled = false)	
	public void verify_Last30Days(WebDriver driver) throws Exception {
		rp = new ReportsPage(driver, test);
		
		rp.Select_Last_30_Days_TimePeriod();
		
		//Click the Apply button
		driver.findElement(By.xpath("//button[contains(.,'Apply')]")).click();Thread.sleep(1500);
		
		
		try {
			if (driver.findElement(By.xpath("//span[.='No Purchase Orders Found']")).isDisplayed()) {
				test.log(LogStatus.INFO, "Data not available for Last 30 Days");
			}
		} catch (Exception d) {
			test.log(LogStatus.INFO, "Data available for Last 30 Days");
		}
	}
	
	@Test(priority = 4, enabled = false)	
	public void verify_SpecificDate(WebDriver driver) throws Exception {
		rp = new ReportsPage(driver, test);
		
		rp.Select_Specific_Date_TimePeriod("25-10-2023");
		
		//Click the Apply button
		driver.findElement(By.xpath("//button[contains(.,'Apply')]")).click();Thread.sleep(1500);
		
		
		try {
			if (driver.findElement(By.xpath("//span[.='No Purchase Orders Found']")).isDisplayed()) {
				test.log(LogStatus.INFO, "Data not available for Specific Date");
			}
		} catch (Exception d) {
			test.log(LogStatus.INFO, "Data available for Specific Date");
		}
	}
	
	@Test(priority = 4, enabled = false)	
	public void verify_DateRange(WebDriver driver) throws Exception {
		rp = new ReportsPage(driver, test);
		
		rp.Select_Date_Range_TimePeriod("01-01-2023", "01-06-2023");
	
		//Click the Apply button
		driver.findElement(By.xpath("//button[contains(.,'Apply')]")).click();Thread.sleep(1500);
		
		try {
			if (driver.findElement(By.xpath("//span[.='No Purchase Orders Found']")).isDisplayed()) {
				test.log(LogStatus.INFO, "Data not available for Date Range");
			}
		} catch (Exception d) {
			test.log(LogStatus.INFO, "Data available for Date Range");
		}
	}
	
}
