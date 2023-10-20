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

public class Dashboard_Inventory_Old_BO 
{
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Old BO - Dashboard - Inventory");
	
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
		Open_Dashboard_Sales_Page(driver);
		Dashboard_Inventory_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Dashboard_Sales_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Daily page
		driver.get(Utility.getProperty("baseURL_Old_BO")+Utility.getProperty("store_Id")+"inventoryDashboard");

		Thread.sleep(5000);
		//Click the Refresh button      
		driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[3]")).click();

		//Check whether the dashboard page refreshed or not
		if(driver.findElement(By.xpath("//a[.='Inventory Dashboard']")).getText().equalsIgnoreCase("Inventory Dashboard"))
		{
			test.log(LogStatus.PASS, "Inventory Dashboard page opened");
		}
		else
		{
			test.log(LogStatus.FAIL, "Inventory Dashboard page not open");
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Inventory_Date_Range(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports_Comparison"));
		
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
		test.log(LogStatus.PASS, "Dashboard : Inventory Report is Displayed for Date Range");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		try
		{
			if(!driver.findElement(By.xpath("//span[contains(.,'COGS BY CATEGORY')]")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "COGS BY CATEGORY is not available");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception k)
		{
			//Get the list of COGS by Category
			List<WebElement> rows=driver.findElements(By.xpath("//tr[contains(@ng-class,'cogByCategory.isTotal')]/td[2]"));
			int rowSize=rows.size();
			
			
			//Get the Sales 
			String Sales_inCOGS=driver.findElement(By.xpath("//tr[contains(@ng-class,'cogByCategory.isTotal')]["+rowSize+"]/td[2]")).getText();
	
			//Get the Cost 
			String Cost_inCOGS=driver.findElement(By.xpath("//tr[contains(@ng-class,'cogByCategory.isTotal')]["+rowSize+"]/td[2]")).getText();
	
			//Get the Margin 
			String Margin_inCOGS=driver.findElement(By.xpath("//tr[contains(@ng-class,'cogByCategory.isTotal')]["+rowSize+"]/td[4]")).getText();
	
			test.log(LogStatus.INFO, "Sales in COGS by Category : "+Sales_inCOGS);
			test.log(LogStatus.INFO, "Cost in COGS by Category : "+Cost_inCOGS);
			test.log(LogStatus.INFO, "Margin in COGS by Category : "+Margin_inCOGS);
		}
		
		
		try
		{
			if(!driver.findElement(By.xpath("//span[contains(.,'TOTAL STOCK PURCHASE')]")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "TOTAL STOCK PURCHASE is not available");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception k)
		{
			
			//Get the Cost 
			String Purchase_Cost=driver.findElement(By.xpath("//td[contains(.,'PURCHASE COST')]//span[1]")).getText();
	
			//Get the Margin 
			String Avail_Cost=driver.findElement(By.xpath("//td[contains(.,'AVAIL COST')]//span[2]")).getText();
	
			test.log(LogStatus.INFO, "Sales in COGS by Category : "+Purchase_Cost);
			test.log(LogStatus.INFO, "Cost in COGS by Category : "+Avail_Cost);
		}
	
//		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Comparison"));
		

	}
}
