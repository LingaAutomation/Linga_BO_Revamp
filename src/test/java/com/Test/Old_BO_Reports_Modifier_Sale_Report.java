package com.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.util.SystemOutLogger;
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

public class Old_BO_Reports_Modifier_Sale_Report 
{
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Old BO - Sales Report - Modifier Sale");
	
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
		Open_Modifier_Sales_Page(driver);
		Old_BO_Modifier_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Modifier_Sales_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Daily page
		driver.get(Utility.getProperty("baseURL_Old_BO")+Utility.getProperty("store_Id")+"report/modifierSale");

		Thread.sleep(5000);
		//Check whether the dashboard page refreshed or not
		if(driver.findElement(By.xpath("//li[contains(.,'Modifier Sale')][@ui-sref-active='active']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Modifier Sale Report page opened");
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifier Sale Report page not open");
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Old_BO_Modifier_Report_Date_Range(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports_Comparison"));
		
		//Select Date Range
		repts.Select_Date_Range_TimePeriod_Old_BO(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		
		Thread.sleep(2000);
		//Click Apply
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		
		Thread.sleep(8000);

		if(driver.findElement(By.xpath("//h3[contains(.,'No sale for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Modifier Sale Not Available for Date Range");
		
			excel.setreportData("Sales_Report", 21, 3, st);
			excel.setreportData("Sales_Report", 22, 3, st);
			excel.setreportData("Sales_Report", 23, 3, st);
	
			

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Comparison"));
		}
		else
		{
			
			test.log(LogStatus.PASS, "Sale Report for Modifer Sale Available for Date Range");
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
	
			Thread.sleep(5000);
			//Get Sale Amount
			String SaleAmount=driver.findElement(By.xpath("(//td[contains(.,'Total')]/../td[3])[1]/span")).getAttribute("textContent");
//			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Get the Quantity
			String Qty=driver.findElement(By.xpath("(//td[contains(.,'Total')]/../td[4])[1]/span")).getAttribute("textContent");
//			double ActualQuantity=Double.parseDouble(Qty);
			
			//Get the Tax
			String Tx=driver.findElement(By.xpath("(//td[contains(.,'Total')]/../td[5])[1]/span")).getAttribute("textContent");
//			double ActualTax=Double.parseDouble(Tx);
			System.out.println("Sale"+SaleAmount+ " Qty "+Qty+" Tax "+Tx);
		
			Thread.sleep(2000);
			//Export the Sale Amount value to Excel
			excel.setreportData("Sales_Report", 21, 3, SaleAmount);
			excel.setreportData("Sales_Report", 22, 3, Qty);
			excel.setreportData("Sales_Report", 23, 3, Tx);
	

			Thread.sleep(3000);
			
			Thread.sleep(2000);
			//To Write the Data in Excel sheet
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Comparison"));
		}
		
		
		
	}
}
