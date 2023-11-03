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

public class Dashboard_Online_Ordering_Old_BO 
{
	public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Old BO - Dashboard - Online Ordering");
	
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
		
		Thread.sleep(8000);
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
		Dashboard_Sales_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Dashboard_Sales_Page(SelfHealingDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Daily page
		driver.get(Utility.getProperty("baseURL_Old_BO")+Utility.getProperty("store_Id")+"onlineOrderDashboard");

		Thread.sleep(5000);
		//Click the Refresh button      
		driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[3]")).click();

		//Check whether the dashboard page refreshed or not
		if(driver.findElement(By.xpath("//a[.='Online Ordering Dashboard']")).getText().equalsIgnoreCase("Online Ordering Dashboard"))
		{
			test.log(LogStatus.PASS, "Online Ordering Dashboard page opened");
		}
		else
		{
			test.log(LogStatus.FAIL, "Online Ordering Dashboard page not open");
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
		
		
		Thread.sleep(10000);
		test.log(LogStatus.PASS, "Dashboard : Online Ordering Report is Displayed for Date Range");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Net Sales Tile Value
		String Net_SalesTile=driver.findElement(By.xpath("(//div[contains(@class,'panel-heading')][contains(.,'Net sale')]/..//span)[1]")).getText().replace("$", "");
		
		//Gross Sales Tile Value
		String Gross_SalesTile=driver.findElement(By.xpath("(//div[contains(@class,'panel-heading')][contains(.,'Gross Sales')]/..//span)[1]")).getText().replace("$", "");
		
		//Tax Tile Value
		String Tax_Tile=driver.findElement(By.xpath("(//div[contains(@class,'panel-heading')][contains(.,'Tax')]/..//span)[1]")).getText().replace("$", "");
		
		//Transactions Tile Value
		String Transactions_Tile=driver.findElement(By.xpath("(//div[contains(@class,'panel-heading')][contains(.,'Transactions')]/..//span)[1]")).getText().replace("$", "");
		
		//Discounts Tile Value
		String Discounts_Tile=driver.findElement(By.xpath("(//div[contains(@class,'panel-heading')][contains(.,'Discount')]/..//span)[1]")).getText().replace("$", "");
			
		//Refunds Tile Value
		String Refunds_Tile=driver.findElement(By.xpath("(//div[contains(@class,'panel-heading')][contains(.,'Refunds')]/..//span)[1]")).getText().replace("$", "");
		
		test.log(LogStatus.INFO, "Net Sales Tile : "+Net_SalesTile);
		test.log(LogStatus.INFO, "Gross Sales Tile : "+Gross_SalesTile);
		test.log(LogStatus.INFO, "Tax Tile : "+Tax_Tile);
		test.log(LogStatus.INFO, "Transactions Tile : "+Transactions_Tile);
		test.log(LogStatus.INFO, "Discounts Tile : "+Discounts_Tile);
		test.log(LogStatus.INFO, "Refunds Tile : "+Refunds_Tile);
		
		
		excel.setreportData("Both_BO_Value", 21, 13, Net_SalesTile);
		excel.setreportData("Both_BO_Value", 22, 13, Gross_SalesTile);
		excel.setreportData("Both_BO_Value", 23, 13, Tax_Tile);
		excel.setreportData("Both_BO_Value", 24, 13, Transactions_Tile);
		excel.setreportData("Both_BO_Value", 25, 13, Discounts_Tile);
//		excel.setreportData("Both_BO_Value", 29, 1, Refunds_Tile);

		
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
		
		Thread.sleep(2000);
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
			List<WebElement> rows=driver.findElements(By.xpath("//table/tbody/tr/td[1]/span"));
			
			int rowSize=rows.size();
			
			//Get the Net Sales
			String NetSales_inNetSales=driver.findElement(By.xpath("//td[contains(.,'TOTAL')]/../td[2]")).getText();
			
			//Get the Tax
			String Tax_inNetSales=driver.findElement(By.xpath("//td[contains(.,'TOTAL')]/../td[3]")).getText();
	
			//Get the Discounts
			String Discounts_inNetSales=driver.findElement(By.xpath("//td[contains(.,'TOTAL')]/../td[4]")).getText();

			//Get the Grand Sales
			String GrandSales_inNetSales=driver.findElement(By.xpath("//td[contains(.,'TOTAL')]/../td[5]")).getText();

			//Export the Data to Excel
			excel.setreportData("Inside_Values", 23, 3, NetSales_inNetSales);
			excel.setreportData("Inside_Values", 24, 3, Tax_inNetSales);
			excel.setreportData("Inside_Values", 25, 3, Discounts_inNetSales);
			excel.setreportData("Inside_Values", 26, 3, GrandSales_inNetSales);
			
		
			//Going Page Up
			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);			
		}
		
		Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		
		//Click the Net Sales Tile
		driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'Gross Sales')]/..")).click();
		
		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//td[contains(.,'No records found')]")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "Gross Sales records not available");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception k)
		{
			
			//Get the List of Rows
			List<WebElement> rows=driver.findElements(By.xpath("//table/tbody/tr/td[1]/span"));
			
			int rowSize=rows.size();
			
			//Get the Net Sales
			String NetSales_inNetSales=driver.findElement(By.xpath("//td[contains(.,'TOTAL')]/../td[2]")).getText();
			
			//Get the Tax
			String Tax_inNetSales=driver.findElement(By.xpath("//td[contains(.,'TOTAL')]/../td[3]")).getText();
	
			//Get the Discounts
			String Discounts_inNetSales=driver.findElement(By.xpath("//td[contains(.,'TOTAL')]/../td[4]")).getText();

			//Get the Grand Sales
			String GrandSales_inNetSales=driver.findElement(By.xpath("//td[contains(.,'TOTAL')]/../td[5]")).getText();

			//Export the Data to Excel
			excel.setreportData("Inside_Values", 27, 3, NetSales_inNetSales);
			excel.setreportData("Inside_Values", 28, 3, Tax_inNetSales);
			excel.setreportData("Inside_Values", 29, 3, Discounts_inNetSales);
			excel.setreportData("Inside_Values", 30, 3, GrandSales_inNetSales);
			
		
			//Going Page Up
			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);			
		}
		
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		
		//Click the Tax Tile
		driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'Tax')]/..")).click();
		
		Thread.sleep(8000);
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
			List<WebElement> rows=driver.findElements(By.xpath("//table/tbody/tr/td[1]/span"));
			
			int rowSize=rows.size();
			
			//Get the Tax Amount
			String TaxAmount_inTaxTile=driver.findElement(By.xpath("//th[contains(.,'Total')]/../th[4]")).getText();
		
			//Get the Tax Exempt
			String TaxExempt_inTaxTile=driver.findElement(By.xpath("//th[contains(.,'Total')]/../th[5]")).getText();
		
			excel.setreportData("Inside_Values", 31, 3, TaxAmount_inTaxTile);
			excel.setreportData("Inside_Values", 32, 3, TaxExempt_inTaxTile);
			
		}
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		
		//Click the Net Sales Tile
		driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'Transactions')]/..")).click();
		
		Thread.sleep(8000);
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
			List<WebElement> rows=driver.findElements(By.xpath("//table/tbody/tr/td[1]/span"));
			
			int rowSize=rows.size();
			
			//Get the CC Tip Charge
			String CCTipCharge_inTransactions=driver.findElement(By.xpath("//td[contains(.,'Total')]/../td[8]")).getText();
			
			//Get the Tax
			String ServiceCharge_inTransactions=driver.findElement(By.xpath("//td[contains(.,'Total')]/../td[9]")).getText();
	
			//Get the Discounts
			String Amount_inTransactions=driver.findElement(By.xpath("//td[contains(.,'Total')]/../td[10]")).getText();

			//Get the Grand Sales
			String Tip_inTransactions=driver.findElement(By.xpath("//td[contains(.,'Total')]/../td[11]")).getText();

			//Export the Data to Excel
			excel.setreportData("Inside_Values", 33, 3, CCTipCharge_inTransactions);
			excel.setreportData("Inside_Values", 34, 3, ServiceCharge_inTransactions);
			excel.setreportData("Inside_Values", 35, 3, Amount_inTransactions);
			excel.setreportData("Inside_Values", 36, 3, Tip_inTransactions);
			
		
			//Going Page Up
			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);			
		}
		

	driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	Thread.sleep(2000);
	
		//Click the Net Sales Tile
		driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'Discount')]/..")).click();
		
		Thread.sleep(8000);
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
			List<WebElement> rows=driver.findElements(By.xpath("//th[contains(.,'Total Checks')]/../../tr/td[1]"));
			
			int rowSize=rows.size();
			
			//Get the Total Discounts
			String TotalDiscounts_inDoscountTile=driver.findElement(By.xpath("//td[contains(.,'Total Discounts')]/../td[2]")).getText();
			
			//Get the Count
			String Count_inDoscountTile=driver.findElement(By.xpath("//td[contains(.,'Total Discounts')]/../td[4]")).getText();
			
			//Get the Average
			String Average_inDoscountTile=driver.findElement(By.xpath("//td[contains(.,'Total Discounts')]/../td[5]")).getText();
		
			//Get the Total Checks
			String TotalChecks_inDiscountTile=driver.findElement(By.xpath("(//th[contains(.,'Total Checks')]/../../tr/td[1])["+rowSize+"]")).getText();
			
			//Get the % Checks Discounted
			String PerChecksDiscounted_inDiscountTile=driver.findElement(By.xpath("(//th[contains(.,'Total Checks')]/../../tr/td[2])["+rowSize+"]")).getText();
			
			//Get the Gross Sales
			String GrossSales_inDiscountTile=driver.findElement(By.xpath("(//th[contains(.,'Total Checks')]/../../tr/td[3])["+rowSize+"]")).getText();
			
			//Get the % Discount of Gross Sales
			String PercDiscountGrossSales_inDiscountTile=driver.findElement(By.xpath("(//th[contains(.,'Total Checks')]/../../tr/td[5])["+rowSize+"]")).getText();
			
			//Get the Checks Discounted
			String ChecksDiscounted_inDiscountTile=driver.findElement(By.xpath("(//th[contains(.,'Total Checks')]/../../tr/td[6])["+rowSize+"]")).getText();
			
			
			//Export the Data to Excel
			excel.setreportData("Inside_Values", 37, 3, TotalDiscounts_inDoscountTile);
			excel.setreportData("Inside_Values", 38, 3, Count_inDoscountTile);
			excel.setreportData("Inside_Values", 39, 3, Average_inDoscountTile);
			excel.setreportData("Inside_Values", 40, 3, TotalChecks_inDiscountTile);
			excel.setreportData("Inside_Values", 41, 3, PerChecksDiscounted_inDiscountTile);
			excel.setreportData("Inside_Values", 42, 3, GrossSales_inDiscountTile);
			excel.setreportData("Inside_Values", 43, 3, PercDiscountGrossSales_inDiscountTile);
			excel.setreportData("Inside_Values", 44, 3, ChecksDiscounted_inDiscountTile);
			
		}
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		
//		//Click the Net Sales Tile
//		driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'Refunds')]/..")).click();
//		
//		try
//		{
//			if(driver.findElement(By.xpath("//td[contains(.,'No records found')]")).isDisplayed())
//			{
//				test.log(LogStatus.FAIL, "Refunds records not available");
//				
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch(Exception k)
//		{
//			
//			//Get the List of Rows
//			List<WebElement> rows=driver.findElements(By.xpath("//table/tbody/tr"));
//			
//			int rowSize=rows.size();
//			
//			//Get the Amount
//			String Amount_inRefundTile=driver.findElement(By.xpath("//table/tbody/tr["+rowSize+"]/td[7]")).getText();
//	
//			excel.setreportData("Inside_Values", 19, 3, Amount_inRefundTile);
//
//		}
//		
//		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
//		Thread.sleep(2000);

		
		excel.toWrite(Utility.getProperty("BO_Comparision"));
		

	}
}
