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
import com.Pages.DashBoardPage;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExcelDataConfig;
import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Dashboard_Sales_Old_BO 
{
	public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Old BO - Dashboard - Sales");
	
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
		driver.get(Utility.getProperty("appURL_Old_BO"));
		
		Thread.sleep(6000);
		a.Login_with_Old_BO(driver, test);
	}
	
	@Test(priority = 50)
	public void LogOut() throws Exception
	{
		a.LogOut_with_Old_BO(driver, test);
	}
	
	
	@Test(priority=2)
	public void Calling() throws Exception
	{
		Open_Dashboard_Sales_Page(driver);
//		Dashboard_Sales_Today(driver);
//		Dashboard_Sales_Yesterday(driver);
//		Dashboard_Sales_Last_N_Days(driver);
//		Dashboard_Sales_This_Week(driver);
//		Dashboard_Sales_Last_Week(driver);
//		Dashboard_Sales_Last_7_Days(driver);
//		Dashboard_Sales_This_Month(driver);
//		Dashboard_Sales_Last_Month(driver);
//		Dashboard_Sales_Last_30_Days(driver);
//		Dashboard_Sales_Specific_Date(driver);
		Dashboard_Sales_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Dashboard_Sales_Page(SelfHealingDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(10000);
		//Load the Daily page
		driver.get(Utility.getProperty("baseURL_Old_BO")+Utility.getProperty("store_Id")+"saleDashboard");

		Thread.sleep(10000);
		//Click the Refresh button      
		driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[3]")).click();

		//Check whether the dashboard page refreshed or not
		if(driver.findElement(By.xpath("//a[.='Sale Dashboard']")).getText().equalsIgnoreCase("Sale Dashboard"))
		{
			test.log(LogStatus.PASS, "Sale Dashboard page opened");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sale Dashboard page not open");
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Sales_Date_Range(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("BO_Comparision"));
		
		//Click the Time Filter button to Select Time Period 
		driver.findElement(By.xpath("(//button[contains(@class,'time-filter dropdown-toggle')])[2]")).click();
		
		Thread.sleep(1000);
		//Select the Date Range Time Period 
		driver.findElement(By.xpath("//li[contains(.,'Date Range')]/a")).click();
	
		//Select Today
		repts.Select_Date_Range_TimePeriod_Old_BO_Dashboard(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		
		Thread.sleep(2000);
		//Click Apply
		driver.findElement(By.xpath("//button[contains(.,'Apply')]")).click();
		
		
		Thread.sleep(50000);
		test.log(LogStatus.PASS, "Dashboard : Sales Report is Displayed for Date Range");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Net Sales Tile Value
		String Net_SalesTile=driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'Net sale')]/..//span")).getText();
		
		//Active Checks Tile Value
		String Active_ChecksTile=driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'ACTIVE CHECK')]/..//span")).getText().replace("$", "");
		
		//Average Check Tile value
		String Avg_CheckTile=driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'AVG CHECK')]/..//span")).getText();
		
		//Average Check Cover
		String Avg_Check_CoverTile=driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'AVG CHECK')]/..//span")).getText();
		
		//Tax Tile Value
		String Tax_Tile=driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'Tax')]/..//span")).getText();
		
		//Transactions Tile Value
		String Transactions_Tile=driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'Transactions')]/..//span")).getText();
			
		//Customers Tile
		String CustomersTile=driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'Customers')]/..//span")).getText();
		
		//Discounts Tile Value
		String Discounts_Tile=driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'Discount')]/..//span")).getText();
			
		//Refunds Tile Value
		String Refunds_Tile=driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'Refunds')]/..//span")).getText().replace("$", "");
		
		//Labor Tile
		String LaborTile=driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'Labor')]/..//span")).getText();

		//COGS Tile Value
		String COGS_Tile=driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'COGS')]/..//span")).getText();
		
		//SPLH Tile
		String SPLH_Tile=driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'SPLH')]/..//span")).getText().replace("$", "");
				
		test.log(LogStatus.INFO, "Net Sales Tile : "+Net_SalesTile);
		test.log(LogStatus.INFO, "Active Checks Tile : "+Active_ChecksTile);
		test.log(LogStatus.INFO, "Average Checks Tile : "+Avg_CheckTile);
		test.log(LogStatus.INFO, "Average Cover Tile : "+Avg_Check_CoverTile);
		test.log(LogStatus.INFO, "Tax Tile : "+Tax_Tile);
		test.log(LogStatus.INFO, "Transactions Tile : "+Transactions_Tile);
		test.log(LogStatus.INFO, "Customers Tile : "+CustomersTile);
		test.log(LogStatus.INFO, "Discounts Tile : "+Discounts_Tile);
		test.log(LogStatus.INFO, "Refunds Tile : "+Refunds_Tile);
		test.log(LogStatus.INFO, "Labor Tile : "+LaborTile);
		test.log(LogStatus.INFO, "COGS Tile : "+COGS_Tile);
		test.log(LogStatus.INFO, "SPLH Tile : "+COGS_Tile);
	
		
		excel.setreportData("Both_BO_Value", 21, 1, Net_SalesTile);
		excel.setreportData("Both_BO_Value", 22, 1, Active_ChecksTile);
		excel.setreportData("Both_BO_Value", 23, 1, Avg_CheckTile);
		excel.setreportData("Both_BO_Value", 24, 1, Avg_Check_CoverTile);
		excel.setreportData("Both_BO_Value", 25, 1, Tax_Tile);
		excel.setreportData("Both_BO_Value", 26, 1, Transactions_Tile);
		excel.setreportData("Both_BO_Value", 27, 1, CustomersTile);
		excel.setreportData("Both_BO_Value", 28, 1, Discounts_Tile);
		excel.setreportData("Both_BO_Value", 29, 1, Refunds_Tile);
		excel.setreportData("Both_BO_Value", 30, 1, LaborTile);
		excel.setreportData("Both_BO_Value", 31, 1, COGS_Tile);
		excel.setreportData("Both_BO_Value", 32, 1, SPLH_Tile);

		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

//		//Verify Net Sales by Hour Graph
//		db.Verify_Net_Sales_By_HourGraph();
//		
//		//Verify Net Sales by Tender Graph
//		db.Verify_Net_Sales_By_TenderGraph();
//		
//		//Verify Sales by Service Type Graph
//		db.Verify_Sale_By_Service_TypeGraph();
		Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		
		//Click the Net Sales Tile
		driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'Net sale')]/..")).click();
		
		Thread.sleep(10000);
		try
		{
			if(driver.findElement(By.xpath("//td[contains(.,'No records found')]")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Net Sales records not available");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception k)
		{
			
			//Get the List of Rows
//			List<WebElement> rows=driver.findElements(By.xpath("//table/thead/../tbody/tr"));
			
//			int rowSize=rows.size();
			
			//Get the Net Sales
			String NetSales_inNetSales=driver.findElement(By.xpath("//td[contains(.,'TOTAL')]/../td[2]")).getText();
			
			//Get the Tax
			String Tax_inNetSales=driver.findElement(By.xpath("//td[contains(.,'TOTAL')]/../td[3]")).getText();
	
			//Get the Discounts
			String Discounts_inNetSales=driver.findElement(By.xpath("//td[contains(.,'TOTAL')]/../td[4]")).getText();

			//Get the Grand Sales
			String GrandSales_inNetSales=driver.findElement(By.xpath("//td[contains(.,'TOTAL')]/../td[5]")).getText();

			//Export the Data to Excel
			excel.setreportData("Inside_Values", 1, 3, NetSales_inNetSales);
			excel.setreportData("Inside_Values", 2, 3, Tax_inNetSales);
			excel.setreportData("Inside_Values", 3, 3, Discounts_inNetSales);
			excel.setreportData("Inside_Values", 4, 3, GrandSales_inNetSales);
			
		
			//Going Page Up
			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);			
		}
		
		
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		
		//Click the Tax Tile
		driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'Tax')]/..")).click();
		
		Thread.sleep(10000);
		try
		{
			if(driver.findElement(By.xpath("//td[contains(.,'No records found')]")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Tax records not available");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception k)
		{
			
			//Get the List of Rows
			List<WebElement> rows=driver.findElements(By.xpath("//table/thead/../tbody/tr"));
			
			int rowSize=rows.size();
			
			//Get the Tax Amount
			String TaxAmount_inTaxTile=driver.findElement(By.xpath("//th[contains(.,'Total')]/../th[4]")).getText();
		
			//Get the Tax Exempt
			String TaxExempt_inTaxTile=driver.findElement(By.xpath("//th[contains(.,'Total')]/../th[5]")).getText();
		
			excel.setreportData("Inside_Values", 5, 3, TaxAmount_inTaxTile);
			excel.setreportData("Inside_Values", 6, 3, TaxExempt_inTaxTile);
			
		}
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		
		//Click the Net Sales Tile
		driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'Transactions')]/..")).click();
		
		Thread.sleep(10000);
		try
		{
			if(driver.findElement(By.xpath("//td[contains(.,'No records found')]")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Transactions records not available");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception k)
		{
			
			//Get the List of Rows
//			List<WebElement> rows=driver.findElements(By.xpath("//table/thead/../tbody/tr"));
			
//			int rowSize=rows.size();
			
			//Get the CC Tip Charge
			String CCTipCharge_inTransactions=driver.findElement(By.xpath("//td[contains(.,'Total')]/../td[8]")).getText();
			
			//Get the Tax
			String ServiceCharge_inTransactions=driver.findElement(By.xpath("//td[contains(.,'Total')]/../td[9]")).getText();
	
			//Get the Discounts
			String Amount_inTransactions=driver.findElement(By.xpath("//td[contains(.,'Total')]/../td[10]")).getText();

			//Get the Grand Sales
			String Tip_inTransactions=driver.findElement(By.xpath("//td[contains(.,'Total')]/../td[11]")).getText();

			//Export the Data to Excel
			excel.setreportData("Inside_Values", 7, 3, CCTipCharge_inTransactions);
			excel.setreportData("Inside_Values", 8, 3, ServiceCharge_inTransactions);
			excel.setreportData("Inside_Values", 9, 3, Amount_inTransactions);
			excel.setreportData("Inside_Values", 10, 3, Tip_inTransactions);
			
		
			//Going Page Up
			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);			
		}
		

	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	Thread.sleep(2000);
	
		//Click the Net Sales Tile
		driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'Discount')]/..")).click();
		
		Thread.sleep(10000);
		try
		{
			if(driver.findElement(By.xpath("//td[contains(.,'No records found')]")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Discount records not available");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception k)
		{
			
			//Get the List of Rows
			List<WebElement> rows=driver.findElements(By.xpath("//div[@ng-if='showDiscount']/table/tbody/tr"));
			
			int rowSize=rows.size();
			
			//Get the Total Discounts
			String TotalDiscounts_inDoscountTile=driver.findElement(By.xpath("//td[contains(.,'Total Discounts')]/../td[2]")).getText();
			
			//Get the Count
			String Count_inDoscountTile=driver.findElement(By.xpath("//td[contains(.,'Total Discounts')]/../td[4]")).getText();
			
			//Get the Average
			String Average_inDoscountTile=driver.findElement(By.xpath("//td[contains(.,'Total Discounts')]/../td[5]")).getText();
		
			//Get the Total Checks
			String TotalChecks_inDiscountTile=driver.findElement(By.xpath("//div[@ng-if='showDiscount']/table/tbody/tr["+rowSize+"]/td[1]")).getText();
			
			//Get the % Checks Discounted
			String PerChecksDiscounted_inDiscountTile=driver.findElement(By.xpath("//div[@ng-if='showDiscount']/table/tbody/tr["+rowSize+"]/td[2]")).getText();
			
			//Get the Gross Sales
			String GrossSales_inDiscountTile=driver.findElement(By.xpath("//div[@ng-if='showDiscount']/table/tbody/tr["+rowSize+"]/td[3]")).getText();
			
			//Get the % Discount of Gross Sales
			String PercDiscountGrossSales_inDiscountTile=driver.findElement(By.xpath("//div[@ng-if='showDiscount']/table/tbody/tr["+rowSize+"]/td[5]")).getText();
			
			//Get the Checks Discounted
			String ChecksDiscounted_inDiscountTile=driver.findElement(By.xpath("//div[@ng-if='showDiscount']/table/tbody/tr["+rowSize+"]/td[6]")).getText();
			
			
			//Export the Data to Excel
			excel.setreportData("Inside_Values", 11, 3, TotalDiscounts_inDoscountTile);
			excel.setreportData("Inside_Values", 12, 3, Count_inDoscountTile);
			excel.setreportData("Inside_Values", 13, 3, Average_inDoscountTile);
			excel.setreportData("Inside_Values", 14, 3, TotalChecks_inDiscountTile);
			excel.setreportData("Inside_Values", 15, 3, PerChecksDiscounted_inDiscountTile);
			excel.setreportData("Inside_Values", 16, 3, GrossSales_inDiscountTile);
			excel.setreportData("Inside_Values", 17, 3, PercDiscountGrossSales_inDiscountTile);
			excel.setreportData("Inside_Values", 18, 3, ChecksDiscounted_inDiscountTile);
			
		}
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		
		//Click the Net Sales Tile
		driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'Refunds')]/..")).click();
		
		Thread.sleep(10000);
		try
		{
			if(driver.findElement(By.xpath("//td[contains(.,'No records found')]")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Refunds records not available");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception k)
		{
			
			//Get the List of Rows
			List<WebElement> rows=driver.findElements(By.xpath("//table/thead/../tbody/tr"));
			
			int rowSize=rows.size();
			
			//Get the Amount
			String Amount_inRefundTile=driver.findElement(By.xpath("//td[contains(.,'Total')]/../td[7]")).getText();
	
			excel.setreportData("Inside_Values", 19, 3, Amount_inRefundTile);

		}
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		
		//Click the Net Sales Tile
		driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'COGS')]/..")).click();
		
		Thread.sleep(10000);
		try
		{
			if(driver.findElement(By.xpath("//td[contains(.,'No records found')]")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "COGS records not available");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception k)
		{
			
			//Get the List of Rows
//			List<WebElement> rows=driver.findElements(By.xpath("//table/thead/../tbody/tr"));
			
//			int rowSize=rows.size();
			
			//Get the CC Tip Charge
			String Cost_inCOGSTile=driver.findElement(By.xpath("(//td[contains(.,'Total')]/../td[2])[2]")).getText().replace("$", "").trim();
		
			excel.setreportData("Inside_Values", 20, 3, Cost_inCOGSTile);

		}
		
		Thread.sleep(2000);
		//To Write the values in Excel sheet
		excel.toWrite(Utility.getProperty("BO_Comparision"));
		

	}
}
