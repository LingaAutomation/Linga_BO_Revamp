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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExcelDataConfig;
import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Old_BO_Reports_Sales_SaleRecap_Report 
{
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Old BO - Sales Report - Sale Recap");
	
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
		Open_SaleRecap_Sales_Page(driver);
		Old_BO_SaleRecap_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_SaleRecap_Sales_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the OnlineSales page
		driver.get(Utility.getProperty("baseURL_Old_BO")+Utility.getProperty("store_Id")+"report/saleRecap");

		Thread.sleep(5000);
		//Check whether the dashboard page refreshed or not
		if(driver.findElement(By.xpath("//li[contains(.,'Sale Recap')][@ui-sref-active='active']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Sale Recap Report page opened");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sale Recap Report page not open");
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Old_BO_SaleRecap_Report_Date_Range(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("BO_Comparision"));
		
		//Click the Sale Recap Type
		driver.findElement(By.xpath("//label[contains(.,'Sale recap Type')]/../div/a")).click();
		
		
		Thread.sleep(1000);
		//Select Time Period
		driver.findElement(By.xpath("//ul/li[contains(.,'Time Period')]")).click();
		
		//Select Date Range
		repts.Select_Date_Range_TimePeriod_Old_BO(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		
		Thread.sleep(2000);
		//Click Apply
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//h3[contains(.,'No sale for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for SaleRecap Not Available for Date Range");
		
			excel.setreportData("Sales_Report", 34, 3, st);
			excel.setreportData("Sales_Report", 35, 3, st);
			excel.setreportData("Sales_Report", 36, 3, st);
			excel.setreportData("Sales_Report", 37, 3, st);
			excel.setreportData("Sales_Report", 38, 3, st);
			excel.setreportData("Sales_Report", 39, 3, st);
			excel.setreportData("Sales_Report", 40, 3, st);
			excel.setreportData("Sales_Report", 41, 3, st);
			excel.setreportData("Sales_Report", 42, 3, st);
			excel.setreportData("Sales_Report", 43, 3, st);
			excel.setreportData("Sales_Report", 44, 3, st);
			excel.setreportData("Sales_Report", 45, 3, st);
			
			
			excel.toWrite(Utility.getProperty("BO_Comparision"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for SaleRecap Available for Date Range");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//List of rows
//			List<WebElement> rows=driver.findElements(By.xpath(""));
			

			Thread.sleep(3000);
			//Get Sale Amount
			String NetSales=driver.findElement(By.xpath("//b[.='SALES']/../../../div[contains(.,'Net Sales')][1]/div[2]")).getText().trim();
//			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Get the Tax
			String Tax=driver.findElement(By.xpath("//b[.='TAXES']/../../../div[contains(.,'Total Tax Collected')]/div[4]")).getText().trim();
//			double ActualTax=Double.parseDouble(Tx);
			
			//Get the Discount
			String Discount=driver.findElement(By.xpath("//b[contains(.,'DISCOUNT')]/../../../div[contains(.,'Total')]/div[2]")).getText().trim();
//			double ActualQuantity=Double.parseDouble(Qty);
			
	
			//Get the Grand Sales
			String GrandSales=driver.findElement(By.xpath("//b[.='SALES']/../../../div[contains(.,'Grand Sales')]/div[2]")).getText().trim();
//			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Get the Gross Receipt
			String GrossReceipt=driver.findElement(By.xpath("//b[.='SALES']/../../../div[contains(.,'Gross Receipt')]/div[2]")).getText().trim();
//			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Get the Gross Sales
			String GrossSales=driver.findElement(By.xpath("//b[.='SALES']/../../../div[contains(.,'Gross Sales')]/div[2]")).getText().trim();
//			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Get Tax Exempt
			String TaxExempt=driver.findElement(By.xpath("//b[.='TAXES']/../../../div[contains(.,'Total Tax Collected')]/div[5]")).getText().trim();
//			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Get the Net Void
			String NetVoid=driver.findElement(By.xpath("//b[.='SALES']/../../../div[contains(.,'Net Void')]/div[2]")).getText().trim();
//			double ActualTax=Double.parseDouble(Tx);
			
			//Get the Gross Void
			String GrossVoid=driver.findElement(By.xpath("//b[.='SALES']/../../../div[contains(.,'Gross Void')]/div[2]")).getText().trim();
//			double ActualQuantity=Double.parseDouble(Qty);
			
	
			try
			{
				if(driver.findElement(By.xpath("//b[contains(.,'REFUND')]/../../../div[contains(.,'Total')]/div[2]")).isDisplayed())
				{
					//Get the Refund
					String Refund=driver.findElement(By.xpath("//b[contains(.,'REFUND')]/../../../div[contains(.,'Total')]/div[2]")).getText().trim();
//					double ActualDiscount=Double.parseDouble(Discnt);
					
					excel.setreportData("Sales_Report", 43, 3, Refund);
				}
			}
			catch(Exception k)
			{
				test.log(LogStatus.FAIL, "Refund not available");
				excel.setreportData("Sales_Report", 43, 3, st);
				
			}
	
			
			//Get the Tax Roundoff
			String TaxRoundoff=driver.findElement(By.xpath("//b[.='TAXES']/../../../div[contains(.,'Rounding Off')]/div[4]")).getText().trim();
//			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Get the Discount Tax
			String DiscountTax=driver.findElement(By.xpath("(//b[contains(.,'DISCOUNT')]/../../../div[contains(.,'Discount Tax')]/div[2])[1]")).getText().trim();
//			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Sales_Report", 34, 3, NetSales);
			excel.setreportData("Sales_Report", 35, 3, Tax);
			excel.setreportData("Sales_Report", 36, 3, Discount);
			excel.setreportData("Sales_Report", 37, 3, GrandSales);
			excel.setreportData("Sales_Report", 38, 3, GrossReceipt);
			excel.setreportData("Sales_Report", 39, 3, GrossSales);
			excel.setreportData("Sales_Report", 40, 3, TaxExempt);
			excel.setreportData("Sales_Report", 41, 3, NetVoid);
			excel.setreportData("Sales_Report", 42, 3, GrossVoid);
			excel.setreportData("Sales_Report", 44, 3, TaxRoundoff);
			excel.setreportData("Sales_Report", 45, 3, DiscountTax);
			

			
			
			Thread.sleep(3000);
		}
		
		//To Write the Data in Excel sheet
		excel.toWrite(Utility.getProperty("BO_Comparision"));
		
	}
}
