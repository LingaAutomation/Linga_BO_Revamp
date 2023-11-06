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

public class Old_BO_Reports_Sale_Summary_Report 
{
public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Old BO - Sales Report - Sale Summary");
	
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
		Open_SaleSummary_Sales_Page(driver);
		Old_BO_SaleSummary_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_SaleSummary_Sales_Page(SelfHealingDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Sale Summary page
		driver.get(Utility.getProperty("baseURL_Old_BO")+Utility.getProperty("store_Id")+"report/saleSummary");

		Thread.sleep(5000);
		//Check whether the dashboard page refreshed or not
		if(driver.findElement(By.xpath("//li[contains(.,'Sale Summary')][@ui-sref-active='active']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Sale Summary Report page opened");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sale Summary Report page not open");
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Old_BO_SaleSummary_Report_Date_Range(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("BO_Comparision"));
		
		//Select Date Range
		repts.Select_Date_Range_TimePeriod_Old_BO(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		
		Thread.sleep(2000);
		//Click Apply
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		Thread.sleep(8000);
//		try
//		{
		if(driver.findElement(By.xpath("//h3[contains(.,'No sale for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Sale Summary Not Available for Date Range");
		
			excel.setreportData("Sales_Report", 67, 3, st);
			excel.setreportData("Sales_Report", 68, 3, st);
			excel.setreportData("Sales_Report", 69, 3, st);
			excel.setreportData("Sales_Report", 70, 3, st);
			excel.setreportData("Sales_Report", 71, 3, st);
			excel.setreportData("Sales_Report", 72, 3, st);
			

			excel.toWrite(Utility.getProperty("BO_Comparision"));
		}
//		}
//		catch(Exception G)
		else
		{
			
			test.log(LogStatus.PASS, "Sale Report for Sale Summary Available for Date Range");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//List of rows
//			List<WebElement> rows=driver.findElements(By.xpath(""));
			

			Thread.sleep(3000);
			//Get Sale Amount
			String NetSale=driver.findElement(By.xpath("(//td[contains(.,'Total')]/../td[6])[1]")).getText().trim();
//			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Get the Quantity
			String Tx=driver.findElement(By.xpath("(//td[contains(.,'Total')]/../td[7])[1]")).getText().trim();
//			double ActualQuantity=Double.parseDouble(Qty);
			
			//Get the Incl Tax
			String IncTx=driver.findElement(By.xpath("(//td[contains(.,'Total')]/../td[8])[1]")).getText().trim();
//			double ActualTax=Double.parseDouble(Tx);
			
			//Get the CC Tip Charge
			String CC_TipChar=driver.findElement(By.xpath("(//td[contains(.,'Total')]/../td[9])[1]")).getText().trim();
//			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Get the Discount
			String Discnt=driver.findElement(By.xpath("(//td[contains(.,'Total')]/../td[10])[1]")).getText().trim();
//			double ActualTax=Double.parseDouble(Tx);
			
			//Get the Gross Receipt
			String GrossReceipt=driver.findElement(By.xpath("(//td[contains(.,'Total')]/../td[11])[1]")).getText().trim();
//			double ActualDiscount=Double.parseDouble(Discnt);
			
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Sales_Report", 67, 3, NetSale);
			excel.setreportData("Sales_Report", 68, 3, Tx);
			excel.setreportData("Sales_Report", 69, 3, IncTx);
			excel.setreportData("Sales_Report", 70, 3, CC_TipChar);
			excel.setreportData("Sales_Report", 71, 3, Discnt);
			excel.setreportData("Sales_Report", 72, 3, GrossReceipt);

			

			
			
			Thread.sleep(3000);
		}
		
		//To Write the Data in Excel sheet
		excel.toWrite(Utility.getProperty("BO_Comparision"));
		
	}
}
