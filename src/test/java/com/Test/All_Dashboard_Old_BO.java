package com.Test;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
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
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class All_Dashboard_Old_BO 
{
	public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Old BO - Dashboard & Sales Report");
	
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
	
	
	@BeforeAll
	public void Login() throws Exception
	{

		Thread.sleep(2000);
		//Call the chrome driver
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
//		//Open the Chrome window
//		driver = new ChromeDriver();
		
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
	
	@BeforeAll
	public void LogOut() throws Exception
	{
		a.LogOut_with_Old_BO(driver, test);
	}
	

	@Test(priority = 2,enabled = true)
	public void Dashboard_Customers_Old_BO() throws Exception
	{
		Dashboard_Customers_Old_BO a=new Dashboard_Customers_Old_BO();
		a.Open_Dashboard_Sales_Page(driver);
		a.Dashboard_Customers_Date_Range(driver);
			
	}
	
	@Test(priority = 3,enabled = true)
	public void Dashboard_Employees_Old_BO() throws Exception
	{
		Dashboard_Employees_Old_BO a=new Dashboard_Employees_Old_BO();
		a.Open_Dashboard_Sales_Page(driver);
		a.Dashboard_Employees_Date_Range(driver);
	}
	
	
	@Test(priority = 4,enabled = true)
	public void Dashboard_Inventory_Old_BO() throws Exception
	{
		Dashboard_Inventory_Old_BO a=new Dashboard_Inventory_Old_BO();
		a.Open_Dashboard_Sales_Page(driver);
		a.Dashboard_Inventory_Date_Range(driver);
	}

	@Test(priority = 5,enabled = true)
	public void Dashboard_KDS_Old_BO() throws Exception
	{
		Dashboard_KDS_Old_BO a=new Dashboard_KDS_Old_BO();
		a.Open_Dashboard_Sales_Page(driver);
		a.Dashboard_Sales_Date_Range(driver);
	}
	
	@Test(priority = 6,enabled = true)
	public void Dashboard_Online_Ordering_Old_BO() throws Exception
	{
		Dashboard_Online_Ordering_Old_BO a=new Dashboard_Online_Ordering_Old_BO();
		a.Open_Dashboard_Sales_Page(driver);
		a.Dashboard_Sales_Date_Range(driver);
	}
	
	@Test(priority = 7,enabled = true)
	public void Dashboard_Sales_Old_BO3() throws Exception
	{
		Dashboard_Sales_Old_BO a=new Dashboard_Sales_Old_BO();
		a.Open_Dashboard_Sales_Page(driver);
		a.Dashboard_Sales_Date_Range(driver);
	}
	
	@Test(priority = 8,enabled = true)
	public void Old_BO_Category_Report_Date_Range1() throws Exception
	{
		Old_BO_Reports_Category_Sale_Report a=new Old_BO_Reports_Category_Sale_Report();
		a.Open_Category_Sales_Page(driver);
		a.Old_BO_Category_Report_Date_Range(driver);
	}
	
	
	@Test(priority = 9,enabled = true)
	public void Old_BO_Reports_Sale_Summary_Report() throws Exception
	{
		Old_BO_Reports_Sale_Summary_Report a=new Old_BO_Reports_Sale_Summary_Report();
		a.Open_SaleSummary_Sales_Page(driver);
		a.Old_BO_SaleSummary_Report_Date_Range(driver);
	}
	
	@Test(priority = 10,enabled = true)
	public void Old_BO_Reports_Online_Sales_Report() throws Exception
	{
		Old_BO_Reports_Online_Sales_Report a=new Old_BO_Reports_Online_Sales_Report();
		a.Open_OnlineSales_Sales_Page(driver);
		a.Old_BO_OnlineSales_Report_Date_Range(driver);
	}
	
	@Test(priority = 11,enabled = true)
	public void Old_BO_Reports_Modifier_Sale_Report() throws Exception
	{
		Old_BO_Reports_Modifier_Sale_Report a=new Old_BO_Reports_Modifier_Sale_Report();
		a.Open_Modifier_Sales_Page(driver);
		a.Old_BO_Modifier_Report_Date_Range(driver);
	}
	
	@Test(priority = 12,enabled = true)
	public void Old_BO_Reports_MenuItem_Sale_Report() throws Exception
	{
		Old_BO_Reports_MenuItem_Sale_Report a=new Old_BO_Reports_MenuItem_Sale_Report();
		a.Open_MenuItem_Sales_Page(driver);
		a.Old_BO_MenuItem_Report_Date_Range(driver);
	}
	
	@Test(priority = 13,enabled = true)
	public void Old_BO_Reports_Hourly_Sale_Report() throws Exception
	{
		Old_BO_Reports_Hourly_Sale_Report a=new Old_BO_Reports_Hourly_Sale_Report();
		a.Open_Hourly_Sales_Page(driver);
		a.Old_BO_Hourly_Report_Date_Range(driver);
	}
	
	@Test(priority = 14,enabled = true)
	public void Old_BO_Reports_Department_Sale_Report() throws Exception
	{
		Old_BO_Reports_Department_Sale_Report a=new Old_BO_Reports_Department_Sale_Report();
		a.Open_Dashboard_Sales_Page(driver);
		a.Old_BO_Department_Report_Date_Range(driver);
	}
	
	@Test(priority = 15,enabled = true)
	public void Old_BO_Reports_Daily_Sale_Report() throws Exception
	{
		Old_BO_Reports_Daily_Sale_Report a=new Old_BO_Reports_Daily_Sale_Report();
		a.Open_Daily_Sales_Page(driver);
		a.Old_BO_Daily_Report_Date_Range(driver);
	}
	
	@Test(priority = 16,enabled = true)
	public void Old_BO_Reports_Sales_CashierOut_Report() throws Exception
	{
		Old_BO_Reports_Sales_CashierOut_Report a=new Old_BO_Reports_Sales_CashierOut_Report();
		a.Open_SaleRecap_Sales_Page(driver);
		a.Old_BO_SaleRecap_Report_Date_Range(driver);
	}
	
	
	@Test(priority = 17,enabled = true)
	public void Old_BO_Reports_Sales_SaleRecap_Report() throws Exception
	{
		Old_BO_Reports_Sales_SaleRecap_Report a=new Old_BO_Reports_Sales_SaleRecap_Report();
		a.Open_SaleRecap_Sales_Page(driver);
		a.Old_BO_SaleRecap_Report_Date_Range(driver);
	}
	
	
	
	@Test(priority = 18,enabled = true)
	public void Old_BO_Reports_Sales_Weekly_Summary_Report() throws Exception
	{
		Old_BO_Reports_Sales_Weekly_Summary_Report a=new Old_BO_Reports_Sales_Weekly_Summary_Report();
		a.Open_WeeklySummary_Sales_Page(driver);
		a.Old_BO_WeeklySummary_Report_Last_Week(driver);
	}
	
	@Test(priority = 19,enabled = true)
	public void Old_BO_Reports_SubCategory_Sale_Report() throws Exception
	{
		Old_BO_Reports_SubCategory_Sale_Report a=new Old_BO_Reports_SubCategory_Sale_Report();
		a.Open_SubCategory_Sales_Page(driver);
		a.Old_BO_SubCategory_Report_Date_Range(driver);
		
	}
	
}
