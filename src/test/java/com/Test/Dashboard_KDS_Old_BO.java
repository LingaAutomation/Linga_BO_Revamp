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

public class Dashboard_KDS_Old_BO {

	public WebDriver driver;
	
	
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
	public void Open_Dashboard_Sales_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Daily page
		driver.get(Utility.getProperty("baseURL_Old_BO")+Utility.getProperty("store_Id")+"kdsDashboard");

		Thread.sleep(5000);
		//Click the Refresh button      
		driver.findElement(By.xpath("//form[@name='dashboardForm']/div/div/button[3]")).click();

		//Check whether the dashboard page refreshed or not
		if(driver.findElement(By.xpath("//a[.='KDS Dashboard']")).getText().equalsIgnoreCase("KDS Dashboard"))
		{
			test.log(LogStatus.PASS, "KDS Dashboard page opened");
		}
		else
		{
			test.log(LogStatus.FAIL, "KDS Dashboard page not open");
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Sales_Date_Range(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports_Comparison"));
		
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
		test.log(LogStatus.PASS, "Dashboard : KDS Report is Displayed for Date Range");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Total Orders Tile Value
		String Total_OrdersTile=driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'TOTAL ORDERS')]/..//span")).getText();
	
		//Average Time per Check Tile Value
		String AvgTime_perCheckTile=driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'AVG TIME PER CHECK')]/..//span")).getText();
				
		//Total Item Count Tile value
		String Total_ItemCountTile=driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'TOTAL ITEM COUNT')]/..//span")).getText();
				
		//Average Time per Item
		String AvgTime_perItemTile=driver.findElement(By.xpath("//div[contains(@class,'panel-heading')][contains(.,'AVG TIME PER ITEM')]/..//span")).getText();
						
		test.log(LogStatus.INFO, "Total Orders Tile : "+Total_OrdersTile);
		test.log(LogStatus.INFO, "Average Time per Check Tile : "+AvgTime_perCheckTile);
		test.log(LogStatus.INFO, "Total Item Count Tile : "+Total_ItemCountTile);
		test.log(LogStatus.INFO, "Average Time per Item Tile : "+AvgTime_perItemTile);
		
		excel.setreportData("Both_BO_Value", 21, 9, Total_OrdersTile);
		excel.setreportData("Both_BO_Value", 22, 9, AvgTime_perCheckTile);
		excel.setreportData("Both_BO_Value", 23, 9, Total_ItemCountTile);
		excel.setreportData("Both_BO_Value", 24, 9, AvgTime_perItemTile);
		
		
		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Comparison"));
		
	}
}
