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
import com.Pages.Common_XPaths;
import com.Pages.DashBoardPage;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExcelDataConfig;
import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dashboard_Sales 
{

public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Dashboard - Sales");
	
	LoginPage lgpg;
	public String st="NA";
	
	Utility ut=new Utility();

	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	ReportsPage repts;
	DashBoardPage db;
	
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
		Open_Dashboard_Sales_Page(driver);
		Dashboard_Sales_Today(driver);
		Dashboard_Sales_Yesterday(driver);
		Dashboard_Sales_Last_N_Days(driver);
		Dashboard_Sales_This_Week(driver);
		Dashboard_Sales_Last_Week(driver);
		Dashboard_Sales_Last_7_Days(driver);
		Dashboard_Sales_This_Month(driver);
		Dashboard_Sales_Last_Month(driver);
		Dashboard_Sales_Last_30_Days(driver);
		Dashboard_Sales_Specific_Date(driver);
		Dashboard_Sales_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Dashboard_Sales_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Daily page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id4")+"sales");

		Thread.sleep(5000);
		//Verify the Categories page loeded or not
		repts.Verify_ReportHomePage("SALES");
		
	}
	

	@Test(priority = 4,enabled = false)
	public void Dashboard_Sales_Today(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(10000);
		
		test.log(LogStatus.PASS, "Dashboard : Sales Report is Displayed for Today");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Net Sales Tile Value
		String Net_SalesTile=db.Net_Sales_TileValue().getText();
		
		//Active Checks Tile Value
		String Active_ChecksTile=db.Active_Checks_TileValue().getText();
				
		//Tax Tile Value
		String Tax_Tile=db.Tax_TileValue().getText();
		
		//Transactions Tile Value
		String Transactions_Tile=db.Transactions_TileValue().getText();
			
		//Discounts Tile Value
		String Discounts_Tile=db.Discounts_TileValue().getText();
			
		//Refunds Tile Value
		String Refunds_Tile=db.Refunds_TileValue().getText();
		
		//COGS Tile Value
		String COGS_Tile=db.COGS_TileValue().getText();
				
		test.log(LogStatus.INFO, "Net Sales Tile : "+Net_SalesTile);
		test.log(LogStatus.INFO, "Active Checks Tile : "+Active_ChecksTile);
		test.log(LogStatus.INFO, "Tax Tile : "+Tax_Tile);
		test.log(LogStatus.INFO, "Transactions Tile : "+Transactions_Tile);
		test.log(LogStatus.INFO, "Discounts Tile : "+Discounts_Tile);
		test.log(LogStatus.INFO, "Refunds Tile : "+Refunds_Tile);
		test.log(LogStatus.INFO, "COGS Tile : "+COGS_Tile);


		
		//Click the Net Sales Tile 
		db.Click_Net_SalesTile();
		
		Thread.sleep(1000);
		//Get the Net Sales today
		String Net_Sales=db.Net_Sales_DashboardSales().getText();
		
		//Get the Tax today
		String Tax=db.Tax_DashboardSales().getText();
		
		//Get the Discounts today
		String Discounts=db.Discount_DashboardSales().getText();
		
		//Get the Grand Sales today
		String Grand_Sales=db.Grand_Sales_DashboardSales().getText();
		
		test.log(LogStatus.PASS, "Net Sales Opened for Today");
		test.log(LogStatus.INFO, "Total Net Sales in Net Sales Table : "+Net_Sales);
		test.log(LogStatus.INFO, "Total Tax in Net Sales Table : "+Tax);
		test.log(LogStatus.INFO, "Total Discounts in Net Sales Table : "+Discounts);
		test.log(LogStatus.INFO, "Total Grand Sales in Net Sales Table : "+Grand_Sales);

		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

		//Verify Net Sales by Hour Graph
		db.Verify_Net_Sales_By_HourGraph();
		
		//Verify Net Sales by Tender Graph
		db.Verify_Net_Sales_By_TenderGraph();
		
		//Verify Sales by Service Type Graph
		db.Verify_Sale_By_Service_TypeGraph();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Sales_Yesterday(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Yesterday_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(10000);
		
		test.log(LogStatus.PASS, "Dashboard : Sales Report is Displayed for Yesterday");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Net Sales Tile Value
		String Net_SalesTile=db.Net_Sales_TileValue().getText();
		
		//Active Checks Tile Value
		String Active_ChecksTile=db.Active_Checks_TileValue().getText();
				
		//Tax Tile Value
		String Tax_Tile=db.Tax_TileValue().getText();
		
		//Transactions Tile Value
		String Transactions_Tile=db.Transactions_TileValue().getText();
			
		//Discounts Tile Value
		String Discounts_Tile=db.Discounts_TileValue().getText();
			
		//Refunds Tile Value
		String Refunds_Tile=db.Refunds_TileValue().getText();
		
		//COGS Tile Value
		String COGS_Tile=db.COGS_TileValue().getText();
				
		test.log(LogStatus.INFO, "Net Sales Tile : "+Net_SalesTile);
		test.log(LogStatus.INFO, "Active Checks Tile : "+Active_ChecksTile);
		test.log(LogStatus.INFO, "Tax Tile : "+Tax_Tile);
		test.log(LogStatus.INFO, "Transactions Tile : "+Transactions_Tile);
		test.log(LogStatus.INFO, "Discounts Tile : "+Discounts_Tile);
		test.log(LogStatus.INFO, "Refunds Tile : "+Refunds_Tile);
		test.log(LogStatus.INFO, "COGS Tile : "+COGS_Tile);


		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

		//Verify Net Sales by Hour Graph
		db.Verify_Net_Sales_By_HourGraph();
		
		//Verify Net Sales by Tender Graph
		db.Verify_Net_Sales_By_TenderGraph();
		
		//Verify Sales by Service Type Graph
		db.Verify_Sale_By_Service_TypeGraph();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
//				excel.setreport_FailedData("Yesterday", 42, 7,diff_value);
			
		//Verify Net Sales Tile
		db.Verify_Net_Sales_InDashboard_Sales("Yesterday");
			
		//Verify Active Checks Tile
		db.Verify_Active_Checks_inDashboard_Sales();
		
		//Verify Tax tile
		db.Verify_Tax_inDashboard_Sales();
		
		//Verify Transactions Tile
		db.Verify_Transactions_inDashboard_Sales();
		
		//Verify Discounts Tile 
		db.Verify_Discounts_inDashboard_Sales();
		
		//Verify Refunds Tile
		db.Verify_Refunds_inDashboard_Sales();
		
		//Verify COGS Tile 
		db.Verify_COGS_inDashboard_Sales();
			Thread.sleep(3000);

		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Sales_Last_N_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(10000);
		test.log(LogStatus.PASS, "Dashboard : Sales Report is Displayed for Last N days");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Net Sales Tile Value
		String Net_SalesTile=db.Net_Sales_TileValue().getText();
		
		//Active Checks Tile Value
		String Active_ChecksTile=db.Active_Checks_TileValue().getText();
				
		//Tax Tile Value
		String Tax_Tile=db.Tax_TileValue().getText();
		
		//Transactions Tile Value
		String Transactions_Tile=db.Transactions_TileValue().getText();
			
		//Discounts Tile Value
		String Discounts_Tile=db.Discounts_TileValue().getText();
			
		//Refunds Tile Value
		String Refunds_Tile=db.Refunds_TileValue().getText();
		
		//COGS Tile Value
		String COGS_Tile=db.COGS_TileValue().getText();
				
		test.log(LogStatus.INFO, "Net Sales Tile : "+Net_SalesTile);
		test.log(LogStatus.INFO, "Active Checks Tile : "+Active_ChecksTile);
		test.log(LogStatus.INFO, "Tax Tile : "+Tax_Tile);
		test.log(LogStatus.INFO, "Transactions Tile : "+Transactions_Tile);
		test.log(LogStatus.INFO, "Discounts Tile : "+Discounts_Tile);
		test.log(LogStatus.INFO, "Refunds Tile : "+Refunds_Tile);
		test.log(LogStatus.INFO, "COGS Tile : "+COGS_Tile);


		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

		//Verify Net Sales by Hour Graph
		db.Verify_Net_Sales_By_HourGraph();
		
		//Verify Net Sales by Tender Graph
		db.Verify_Net_Sales_By_TenderGraph();
		
		//Verify Sales by Service Type Graph
		db.Verify_Sale_By_Service_TypeGraph();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
//				excel.setreport_FailedData("Yesterday", 42, 7,diff_value);
			
		//Verify Net Sales Tile
		db.Verify_Net_Sales_InDashboard_Sales("Last N days");
			
		//Verify Active Checks Tile
		db.Verify_Active_Checks_inDashboard_Sales();
		
		//Verify Tax tile
		db.Verify_Tax_inDashboard_Sales();
		
		//Verify Transactions Tile
		db.Verify_Transactions_inDashboard_Sales();
		
		//Verify Discounts Tile 
		db.Verify_Discounts_inDashboard_Sales();
		
		//Verify Refunds Tile
		db.Verify_Refunds_inDashboard_Sales();
		
		//Verify COGS Tile 
		db.Verify_COGS_inDashboard_Sales();
	
	}

	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Sales_This_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_This_Week_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(10000);
		test.log(LogStatus.PASS, "Dashboard : Sales Report is Displayed for This Week");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Net Sales Tile Value
		String Net_SalesTile=db.Net_Sales_TileValue().getText();
		
		//Active Checks Tile Value
		String Active_ChecksTile=db.Active_Checks_TileValue().getText();
				
		//Tax Tile Value
		String Tax_Tile=db.Tax_TileValue().getText();
		
		//Transactions Tile Value
		String Transactions_Tile=db.Transactions_TileValue().getText();
			
		//Discounts Tile Value
		String Discounts_Tile=db.Discounts_TileValue().getText();
			
		//Refunds Tile Value
		String Refunds_Tile=db.Refunds_TileValue().getText();
		
		//COGS Tile Value
		String COGS_Tile=db.COGS_TileValue().getText();
				
		test.log(LogStatus.INFO, "Net Sales Tile : "+Net_SalesTile);
		test.log(LogStatus.INFO, "Active Checks Tile : "+Active_ChecksTile);
		test.log(LogStatus.INFO, "Tax Tile : "+Tax_Tile);
		test.log(LogStatus.INFO, "Transactions Tile : "+Transactions_Tile);
		test.log(LogStatus.INFO, "Discounts Tile : "+Discounts_Tile);
		test.log(LogStatus.INFO, "Refunds Tile : "+Refunds_Tile);
		test.log(LogStatus.INFO, "COGS Tile : "+COGS_Tile);


		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

		//Verify Net Sales by Hour Graph
		db.Verify_Net_Sales_By_HourGraph();
		
		//Verify Net Sales by Tender Graph
		db.Verify_Net_Sales_By_TenderGraph();
		
		//Verify Sales by Service Type Graph
		db.Verify_Sale_By_Service_TypeGraph();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
//				excel.setreport_FailedData("Yesterday", 42, 7,diff_value);
			
		//Verify Net Sales Tile
		db.Verify_Net_Sales_InDashboard_Sales("This Week");
			
		//Verify Active Checks Tile
		db.Verify_Active_Checks_inDashboard_Sales();
		
		//Verify Tax tile
		db.Verify_Tax_inDashboard_Sales();
		
		//Verify Transactions Tile
		db.Verify_Transactions_inDashboard_Sales();
		
		//Verify Discounts Tile 
		db.Verify_Discounts_inDashboard_Sales();
		
		//Verify Refunds Tile
		db.Verify_Refunds_inDashboard_Sales();
		
		//Verify COGS Tile 
		db.Verify_COGS_inDashboard_Sales();
	
	}
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Sales_Last_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Last_Week_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(10000);
		test.log(LogStatus.PASS, "Dashboard : Sales Report is Displayed for Last Week");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Net Sales Tile Value
		String Net_SalesTile=db.Net_Sales_TileValue().getText();
		
		//Active Checks Tile Value
		String Active_ChecksTile=db.Active_Checks_TileValue().getText();
				
		//Tax Tile Value
		String Tax_Tile=db.Tax_TileValue().getText();
		
		//Transactions Tile Value
		String Transactions_Tile=db.Transactions_TileValue().getText();
			
		//Discounts Tile Value
		String Discounts_Tile=db.Discounts_TileValue().getText();
			
		//Refunds Tile Value
		String Refunds_Tile=db.Refunds_TileValue().getText();
		
		//COGS Tile Value
		String COGS_Tile=db.COGS_TileValue().getText();
				
		test.log(LogStatus.INFO, "Net Sales Tile : "+Net_SalesTile);
		test.log(LogStatus.INFO, "Active Checks Tile : "+Active_ChecksTile);
		test.log(LogStatus.INFO, "Tax Tile : "+Tax_Tile);
		test.log(LogStatus.INFO, "Transactions Tile : "+Transactions_Tile);
		test.log(LogStatus.INFO, "Discounts Tile : "+Discounts_Tile);
		test.log(LogStatus.INFO, "Refunds Tile : "+Refunds_Tile);
		test.log(LogStatus.INFO, "COGS Tile : "+COGS_Tile);


		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

		//Verify Net Sales by Hour Graph
		db.Verify_Net_Sales_By_HourGraph();
		
		//Verify Net Sales by Tender Graph
		db.Verify_Net_Sales_By_TenderGraph();
		
		//Verify Sales by Service Type Graph
		db.Verify_Sale_By_Service_TypeGraph();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
//				excel.setreport_FailedData("Yesterday", 42, 7,diff_value);
			
		//Verify Net Sales Tile
		db.Verify_Net_Sales_InDashboard_Sales("Last Week");
			
		//Verify Active Checks Tile
		db.Verify_Active_Checks_inDashboard_Sales();
		
		//Verify Tax tile
		db.Verify_Tax_inDashboard_Sales();
		
		//Verify Transactions Tile
		db.Verify_Transactions_inDashboard_Sales();
		
		//Verify Discounts Tile 
		db.Verify_Discounts_inDashboard_Sales();
		
		//Verify Refunds Tile
		db.Verify_Refunds_inDashboard_Sales();
		
		//Verify COGS Tile 
		db.Verify_COGS_inDashboard_Sales();
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Sales_Last_7_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Last_7_Days_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(10000);
		test.log(LogStatus.PASS, "Dashboard : Sales Report is Displayed for Last 7 days");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Net Sales Tile Value
		String Net_SalesTile=db.Net_Sales_TileValue().getText();
		
		//Active Checks Tile Value
		String Active_ChecksTile=db.Active_Checks_TileValue().getText();
				
		//Tax Tile Value
		String Tax_Tile=db.Tax_TileValue().getText();
		
		//Transactions Tile Value
		String Transactions_Tile=db.Transactions_TileValue().getText();
			
		//Discounts Tile Value
		String Discounts_Tile=db.Discounts_TileValue().getText();
			
		//Refunds Tile Value
		String Refunds_Tile=db.Refunds_TileValue().getText();
		
		//COGS Tile Value
		String COGS_Tile=db.COGS_TileValue().getText();
				
		test.log(LogStatus.INFO, "Net Sales Tile : "+Net_SalesTile);
		test.log(LogStatus.INFO, "Active Checks Tile : "+Active_ChecksTile);
		test.log(LogStatus.INFO, "Tax Tile : "+Tax_Tile);
		test.log(LogStatus.INFO, "Transactions Tile : "+Transactions_Tile);
		test.log(LogStatus.INFO, "Discounts Tile : "+Discounts_Tile);
		test.log(LogStatus.INFO, "Refunds Tile : "+Refunds_Tile);
		test.log(LogStatus.INFO, "COGS Tile : "+COGS_Tile);


		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

		//Verify Net Sales by Hour Graph
		db.Verify_Net_Sales_By_HourGraph();
		
		//Verify Net Sales by Tender Graph
		db.Verify_Net_Sales_By_TenderGraph();
		
		//Verify Sales by Service Type Graph
		db.Verify_Sale_By_Service_TypeGraph();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
//				excel.setreport_FailedData("Yesterday", 42, 7,diff_value);
			
		//Verify Net Sales Tile
		db.Verify_Net_Sales_InDashboard_Sales("Last 7 days");
			
		//Verify Active Checks Tile
		db.Verify_Active_Checks_inDashboard_Sales();
		
		//Verify Tax tile
		db.Verify_Tax_inDashboard_Sales();
		
		//Verify Transactions Tile
		db.Verify_Transactions_inDashboard_Sales();
		
		//Verify Discounts Tile 
		db.Verify_Discounts_inDashboard_Sales();
		
		//Verify Refunds Tile
		db.Verify_Refunds_inDashboard_Sales();
		
		//Verify COGS Tile 
		db.Verify_COGS_inDashboard_Sales();
		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Sales_This_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_This_Month_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(10000);
		test.log(LogStatus.PASS, "Dashboard : Sales Report is Displayed for This month");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Net Sales Tile Value
		String Net_SalesTile=db.Net_Sales_TileValue().getText();
		
		//Active Checks Tile Value
		String Active_ChecksTile=db.Active_Checks_TileValue().getText();
				
		//Tax Tile Value
		String Tax_Tile=db.Tax_TileValue().getText();
		
		//Transactions Tile Value
		String Transactions_Tile=db.Transactions_TileValue().getText();
			
		//Discounts Tile Value
		String Discounts_Tile=db.Discounts_TileValue().getText();
			
		//Refunds Tile Value
		String Refunds_Tile=db.Refunds_TileValue().getText();
		
		//COGS Tile Value
		String COGS_Tile=db.COGS_TileValue().getText();
				
		test.log(LogStatus.INFO, "Net Sales Tile : "+Net_SalesTile);
		test.log(LogStatus.INFO, "Active Checks Tile : "+Active_ChecksTile);
		test.log(LogStatus.INFO, "Tax Tile : "+Tax_Tile);
		test.log(LogStatus.INFO, "Transactions Tile : "+Transactions_Tile);
		test.log(LogStatus.INFO, "Discounts Tile : "+Discounts_Tile);
		test.log(LogStatus.INFO, "Refunds Tile : "+Refunds_Tile);
		test.log(LogStatus.INFO, "COGS Tile : "+COGS_Tile);


		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

		//Verify Net Sales by Hour Graph
		db.Verify_Net_Sales_By_HourGraph();
		
		//Verify Net Sales by Tender Graph
		db.Verify_Net_Sales_By_TenderGraph();
		
		//Verify Sales by Service Type Graph
		db.Verify_Sale_By_Service_TypeGraph();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
//				excel.setreport_FailedData("Yesterday", 42, 7,diff_value);
			
		//Verify Net Sales Tile
		db.Verify_Net_Sales_InDashboard_Sales("This month");
			
		//Verify Active Checks Tile
		db.Verify_Active_Checks_inDashboard_Sales();
		
		//Verify Tax tile
		db.Verify_Tax_inDashboard_Sales();
		
		//Verify Transactions Tile
		db.Verify_Transactions_inDashboard_Sales();
		
		//Verify Discounts Tile 
		db.Verify_Discounts_inDashboard_Sales();
		
		//Verify Refunds Tile
		db.Verify_Refunds_inDashboard_Sales();
		
		//Verify COGS Tile 
		db.Verify_COGS_inDashboard_Sales();
				
		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Sales_Last_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Last_Month_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(10000);
		test.log(LogStatus.PASS, "Dashboard : Sales Report is Displayed for Last month");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Net Sales Tile Value
		String Net_SalesTile=db.Net_Sales_TileValue().getText();
		
		//Active Checks Tile Value
		String Active_ChecksTile=db.Active_Checks_TileValue().getText();
				
		//Tax Tile Value
		String Tax_Tile=db.Tax_TileValue().getText();
		
		//Transactions Tile Value
		String Transactions_Tile=db.Transactions_TileValue().getText();
			
		//Discounts Tile Value
		String Discounts_Tile=db.Discounts_TileValue().getText();
			
		//Refunds Tile Value
		String Refunds_Tile=db.Refunds_TileValue().getText();
		
		//COGS Tile Value
		String COGS_Tile=db.COGS_TileValue().getText();
				
		test.log(LogStatus.INFO, "Net Sales Tile : "+Net_SalesTile);
		test.log(LogStatus.INFO, "Active Checks Tile : "+Active_ChecksTile);
		test.log(LogStatus.INFO, "Tax Tile : "+Tax_Tile);
		test.log(LogStatus.INFO, "Transactions Tile : "+Transactions_Tile);
		test.log(LogStatus.INFO, "Discounts Tile : "+Discounts_Tile);
		test.log(LogStatus.INFO, "Refunds Tile : "+Refunds_Tile);
		test.log(LogStatus.INFO, "COGS Tile : "+COGS_Tile);


		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

		//Verify Net Sales by Hour Graph
		db.Verify_Net_Sales_By_HourGraph();
		
		//Verify Net Sales by Tender Graph
		db.Verify_Net_Sales_By_TenderGraph();
		
		//Verify Sales by Service Type Graph
		db.Verify_Sale_By_Service_TypeGraph();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
//				excel.setreport_FailedData("Yesterday", 42, 7,diff_value);
			
		//Verify Net Sales Tile
		db.Verify_Net_Sales_InDashboard_Sales("Last month");
			
		//Verify Active Checks Tile
		db.Verify_Active_Checks_inDashboard_Sales();
		
		//Verify Tax tile
		db.Verify_Tax_inDashboard_Sales();
		
		//Verify Transactions Tile
		db.Verify_Transactions_inDashboard_Sales();
		
		//Verify Discounts Tile 
		db.Verify_Discounts_inDashboard_Sales();
		
		//Verify Refunds Tile
		db.Verify_Refunds_inDashboard_Sales();
		
		//Verify COGS Tile 
		db.Verify_COGS_inDashboard_Sales();
		
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Sales_Last_30_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Last_30_Days_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(10000);
		test.log(LogStatus.PASS, "Dashboard : Sales Report is Displayed for Last 30 days");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Net Sales Tile Value
		String Net_SalesTile=db.Net_Sales_TileValue().getText();
		
		//Active Checks Tile Value
		String Active_ChecksTile=db.Active_Checks_TileValue().getText();
				
		//Tax Tile Value
		String Tax_Tile=db.Tax_TileValue().getText();
		
		//Transactions Tile Value
		String Transactions_Tile=db.Transactions_TileValue().getText();
			
		//Discounts Tile Value
		String Discounts_Tile=db.Discounts_TileValue().getText();
			
		//Refunds Tile Value
		String Refunds_Tile=db.Refunds_TileValue().getText();
		
		//COGS Tile Value
		String COGS_Tile=db.COGS_TileValue().getText();
				
		test.log(LogStatus.INFO, "Net Sales Tile : "+Net_SalesTile);
		test.log(LogStatus.INFO, "Active Checks Tile : "+Active_ChecksTile);
		test.log(LogStatus.INFO, "Tax Tile : "+Tax_Tile);
		test.log(LogStatus.INFO, "Transactions Tile : "+Transactions_Tile);
		test.log(LogStatus.INFO, "Discounts Tile : "+Discounts_Tile);
		test.log(LogStatus.INFO, "Refunds Tile : "+Refunds_Tile);
		test.log(LogStatus.INFO, "COGS Tile : "+COGS_Tile);


		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

		//Verify Net Sales by Hour Graph
		db.Verify_Net_Sales_By_HourGraph();
		
		//Verify Net Sales by Tender Graph
		db.Verify_Net_Sales_By_TenderGraph();
		
		//Verify Sales by Service Type Graph
		db.Verify_Sale_By_Service_TypeGraph();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
//				excel.setreport_FailedData("Yesterday", 42, 7,diff_value);
			
		//Verify Net Sales Tile
		db.Verify_Net_Sales_InDashboard_Sales("Last 30 days");
			
		//Verify Active Checks Tile
		db.Verify_Active_Checks_inDashboard_Sales();
		
		//Verify Tax tile
		db.Verify_Tax_inDashboard_Sales();
		
		//Verify Transactions Tile
		db.Verify_Transactions_inDashboard_Sales();
		
		//Verify Discounts Tile 
		db.Verify_Discounts_inDashboard_Sales();
		
		//Verify Refunds Tile
		db.Verify_Refunds_inDashboard_Sales();
		
		//Verify COGS Tile 
		db.Verify_COGS_inDashboard_Sales();
	
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Sales_Specific_Date(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(10000);
		test.log(LogStatus.PASS, "Dashboard : Sales Report is Displayed for Specific Date");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Net Sales Tile Value
		String Net_SalesTile=db.Net_Sales_TileValue().getText();
		
		//Active Checks Tile Value
		String Active_ChecksTile=db.Active_Checks_TileValue().getText();
				
		//Tax Tile Value
		String Tax_Tile=db.Tax_TileValue().getText();
		
		//Transactions Tile Value
		String Transactions_Tile=db.Transactions_TileValue().getText();
			
		//Discounts Tile Value
		String Discounts_Tile=db.Discounts_TileValue().getText();
			
		//Refunds Tile Value
		String Refunds_Tile=db.Refunds_TileValue().getText();
		
		//COGS Tile Value
		String COGS_Tile=db.COGS_TileValue().getText();
				
		test.log(LogStatus.INFO, "Net Sales Tile : "+Net_SalesTile);
		test.log(LogStatus.INFO, "Active Checks Tile : "+Active_ChecksTile);
		test.log(LogStatus.INFO, "Tax Tile : "+Tax_Tile);
		test.log(LogStatus.INFO, "Transactions Tile : "+Transactions_Tile);
		test.log(LogStatus.INFO, "Discounts Tile : "+Discounts_Tile);
		test.log(LogStatus.INFO, "Refunds Tile : "+Refunds_Tile);
		test.log(LogStatus.INFO, "COGS Tile : "+COGS_Tile);


		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

		//Verify Net Sales by Hour Graph
		db.Verify_Net_Sales_By_HourGraph();
		
		//Verify Net Sales by Tender Graph
		db.Verify_Net_Sales_By_TenderGraph();
		
		//Verify Sales by Service Type Graph
		db.Verify_Sale_By_Service_TypeGraph();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
//				excel.setreport_FailedData("Yesterday", 42, 7,diff_value);
			
		//Verify Net Sales Tile
		db.Verify_Net_Sales_InDashboard_Sales("Specific Date");
			
		//Verify Active Checks Tile
		db.Verify_Active_Checks_inDashboard_Sales();
		
		//Verify Tax tile
		db.Verify_Tax_inDashboard_Sales();
		
		//Verify Transactions Tile
		db.Verify_Transactions_inDashboard_Sales();
		
		//Verify Discounts Tile 
		db.Verify_Discounts_inDashboard_Sales();
		
		//Verify Refunds Tile
		db.Verify_Refunds_inDashboard_Sales();
		
		//Verify COGS Tile 
		db.Verify_COGS_inDashboard_Sales();
	
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Sales_Date_Range(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(10000);
		test.log(LogStatus.PASS, "Dashboard : Sales Report is Displayed for Date Range");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Net Sales Tile Value
		String Net_SalesTile=db.Net_Sales_TileValue().getText();
		
		//Active Checks Tile Value
		String Active_ChecksTile=db.Active_Checks_TileValue().getText();
				
		//Tax Tile Value
		String Tax_Tile=db.Tax_TileValue().getText();
		
		//Transactions Tile Value
		String Transactions_Tile=db.Transactions_TileValue().getText();
			
		//Discounts Tile Value
		String Discounts_Tile=db.Discounts_TileValue().getText();
			
		//Refunds Tile Value
		String Refunds_Tile=db.Refunds_TileValue().getText();
		
		//COGS Tile Value
		String COGS_Tile=db.COGS_TileValue().getText();
				
		test.log(LogStatus.INFO, "Net Sales Tile : "+Net_SalesTile);
		test.log(LogStatus.INFO, "Active Checks Tile : "+Active_ChecksTile);
		test.log(LogStatus.INFO, "Tax Tile : "+Tax_Tile);
		test.log(LogStatus.INFO, "Transactions Tile : "+Transactions_Tile);
		test.log(LogStatus.INFO, "Discounts Tile : "+Discounts_Tile);
		test.log(LogStatus.INFO, "Refunds Tile : "+Refunds_Tile);
		test.log(LogStatus.INFO, "COGS Tile : "+COGS_Tile);


		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

		//Verify Net Sales by Hour Graph
		db.Verify_Net_Sales_By_HourGraph();
		
		//Verify Net Sales by Tender Graph
		db.Verify_Net_Sales_By_TenderGraph();
		
		//Verify Sales by Service Type Graph
		db.Verify_Sale_By_Service_TypeGraph();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
//				excel.setreport_FailedData("Yesterday", 42, 7,diff_value);
			
		//Verify Net Sales Tile
		db.Verify_Net_Sales_InDashboard_Sales("Date Range");
			
		//Verify Active Checks Tile
		db.Verify_Active_Checks_inDashboard_Sales();
		
		//Verify Tax tile
		db.Verify_Tax_inDashboard_Sales();
		
		//Verify Transactions Tile
		db.Verify_Transactions_inDashboard_Sales();
		
		//Verify Discounts Tile 
		db.Verify_Discounts_inDashboard_Sales();
		
		//Verify Refunds Tile
		db.Verify_Refunds_inDashboard_Sales();
		
		//Verify COGS Tile 
		db.Verify_COGS_inDashboard_Sales();


	}
	

}
