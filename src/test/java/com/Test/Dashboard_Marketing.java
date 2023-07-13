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

public class Dashboard_Marketing 
{

public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Dashboard - Marketing");
	
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
		Open_Dashboard_Marketing_Page(driver);
		Dashboard_Marketing_Today(driver);
		Dashboard_Marketing_Yesterday(driver);
		Dashboard_Marketing_Last_N_Days(driver);
		Dashboard_Marketing_This_Week(driver);
		Dashboard_Marketing_Last_Week(driver);
		Dashboard_Marketing_Last_7_Days(driver);
		Dashboard_Marketing_This_Month(driver);
		Dashboard_Marketing_Last_Month(driver);
		Dashboard_Marketing_Last_30_Days(driver);
		Dashboard_Marketing_Specific_Date(driver);
		Dashboard_Marketing_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Dashboard_Marketing_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Daily page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id4")+"marketing");

		Thread.sleep(5000);
		//Verify the Categories page loaded or not
		repts.Verify_ReportHomePage("MARKETING");
		
	}
	

	@Test(priority = 4,enabled = false)
	public void Dashboard_Marketing_Today(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Today_TimePeriod();
		
		
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(8000);
		
		test.log(LogStatus.PASS, "Dashboard : Marketing Report is Displayed for Today");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Campaign Sent Value
		String Campaign_SentTile=db.Campaign_Sent_TileValue().getText();
		
		//Scheduled Value
		String Scheduled_Tile=db.Scheduled_TileValue().getText();
				
		//Drafted Value
		String Drafted_Tile=db.Drafted_TileValue().getText();
		
		//Total Visits Value
		String Total_Visits_Tile=db.Total_Visits_TileValue().getText();
			
		//Visit Conversion Rate Value
		String Visit_Conversion_Rate_Tile=db.Visit_Conversion_Rate_TileValue().getText();
		
		
		
		
		
		test.log(LogStatus.INFO, "Campaign Sent Tile : "+Campaign_SentTile);
		test.log(LogStatus.INFO, "Scheduled Sent Tile : "+Scheduled_Tile);
		test.log(LogStatus.INFO, "Drafted Sent Tile : "+Drafted_Tile);
		test.log(LogStatus.INFO, "Total Visits Tile : "+Total_Visits_Tile);
		test.log(LogStatus.INFO, "Visit Conversion Rate Tile : "+Visit_Conversion_Rate_Tile);

		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		
		db.Verify_Campaign_Reach("Today");
		db.Verify_Top_Campaings();
			
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Marketing_Yesterday(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Yesterday_TimePeriod();
		
		
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		
		test.log(LogStatus.PASS, "Dashboard : Marketing Report is Displayed for Yesterday");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Campaign Sent Value
				String Campaign_SentTile=db.Campaign_Sent_TileValue().getText();
				
				//Scheduled Value
				String Scheduled_Tile=db.Scheduled_TileValue().getText();
						
				//Drafted Value
				String Drafted_Tile=db.Drafted_TileValue().getText();
				
				//Total Visits Value
				String Total_Visits_Tile=db.Total_Visits_TileValue().getText();
					
				//Visit Conversion Rate Value
				String Visit_Conversion_Rate_Tile=db.Visit_Conversion_Rate_TileValue().getText();
				
				
				
				
				
				test.log(LogStatus.INFO, "Campaign Sent Tile : "+Campaign_SentTile);
				test.log(LogStatus.INFO, "Scheduled Sent Tile : "+Scheduled_Tile);
				test.log(LogStatus.INFO, "Drafted Sent Tile : "+Drafted_Tile);
				test.log(LogStatus.INFO, "Total Visits Tile : "+Total_Visits_Tile);
				test.log(LogStatus.INFO, "Visit Conversion Rate Tile : "+Visit_Conversion_Rate_Tile);

				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

				db.Verify_Campaign_Reach("Yesterday");
				db.Verify_Top_Campaings();
			

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	}
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Marketing_Last_N_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));
		
		
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "Dashboard : Marketing Report is Displayed for Last N days");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Campaign Sent Value
				String Campaign_SentTile=db.Campaign_Sent_TileValue().getText();
				
				//Scheduled Value
				String Scheduled_Tile=db.Scheduled_TileValue().getText();
						
				//Drafted Value
				String Drafted_Tile=db.Drafted_TileValue().getText();
				
				//Total Visits Value
				String Total_Visits_Tile=db.Total_Visits_TileValue().getText();
					
				//Visit Conversion Rate Value
				String Visit_Conversion_Rate_Tile=db.Visit_Conversion_Rate_TileValue().getText();
				
				
				
				
				
				test.log(LogStatus.INFO, "Campaign Sent Tile : "+Campaign_SentTile);
				test.log(LogStatus.INFO, "Scheduled Sent Tile : "+Scheduled_Tile);
				test.log(LogStatus.INFO, "Drafted Sent Tile : "+Drafted_Tile);
				test.log(LogStatus.INFO, "Total Visits Tile : "+Total_Visits_Tile);
				test.log(LogStatus.INFO, "Visit Conversion Rate Tile : "+Visit_Conversion_Rate_Tile);

				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
				db.Verify_Campaign_Reach("Last 'N' Days");
				db.Verify_Top_Campaings();
			
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			
	
	}

	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Marketing_This_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_This_Week_TimePeriod();
		
		
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "Dashboard : Marketing Report is Displayed for This Week");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Campaign Sent Value
				String Campaign_SentTile=db.Campaign_Sent_TileValue().getText();
				
				//Scheduled Value
				String Scheduled_Tile=db.Scheduled_TileValue().getText();
						
				//Drafted Value
				String Drafted_Tile=db.Drafted_TileValue().getText();
				
				//Total Visits Value
				String Total_Visits_Tile=db.Total_Visits_TileValue().getText();
					
				//Visit Conversion Rate Value
				String Visit_Conversion_Rate_Tile=db.Visit_Conversion_Rate_TileValue().getText();
				
				
				
				
				
				test.log(LogStatus.INFO, "Campaign Sent Tile : "+Campaign_SentTile);
				test.log(LogStatus.INFO, "Scheduled Sent Tile : "+Scheduled_Tile);
				test.log(LogStatus.INFO, "Drafted Sent Tile : "+Drafted_Tile);
				test.log(LogStatus.INFO, "Total Visits Tile : "+Total_Visits_Tile);
				test.log(LogStatus.INFO, "Visit Conversion Rate Tile : "+Visit_Conversion_Rate_Tile);

				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
	
				db.Verify_Campaign_Reach("This Week");
				db.Verify_Top_Campaings();
			
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Marketing_Last_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Last_Week_TimePeriod();
		
		
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "Dashboard : Marketing Report is Displayed for Last Week");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Campaign Sent Value
				String Campaign_SentTile=db.Campaign_Sent_TileValue().getText();
				
				//Scheduled Value
				String Scheduled_Tile=db.Scheduled_TileValue().getText();
						
				//Drafted Value
				String Drafted_Tile=db.Drafted_TileValue().getText();
				
				//Total Visits Value
				String Total_Visits_Tile=db.Total_Visits_TileValue().getText();
					
				//Visit Conversion Rate Value
				String Visit_Conversion_Rate_Tile=db.Visit_Conversion_Rate_TileValue().getText();
				
				
				
				
				
				test.log(LogStatus.INFO, "Campaign Sent Tile : "+Campaign_SentTile);
				test.log(LogStatus.INFO, "Scheduled Sent Tile : "+Scheduled_Tile);
				test.log(LogStatus.INFO, "Drafted Sent Tile : "+Drafted_Tile);
				test.log(LogStatus.INFO, "Total Visits Tile : "+Total_Visits_Tile);
				test.log(LogStatus.INFO, "Visit Conversion Rate Tile : "+Visit_Conversion_Rate_Tile);

				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
				
				db.Verify_Campaign_Reach("Last Week");
				db.Verify_Top_Campaings();
			
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	}
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Marketing_Last_7_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Last_7_Days_TimePeriod();
		
		
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "Dashboard : Marketing Report is Displayed for Last 7 days");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Campaign Sent Value
				String Campaign_SentTile=db.Campaign_Sent_TileValue().getText();
				
				//Scheduled Value
				String Scheduled_Tile=db.Scheduled_TileValue().getText();
						
				//Drafted Value
				String Drafted_Tile=db.Drafted_TileValue().getText();
				
				//Total Visits Value
				String Total_Visits_Tile=db.Total_Visits_TileValue().getText();
					
				//Visit Conversion Rate Value
				String Visit_Conversion_Rate_Tile=db.Visit_Conversion_Rate_TileValue().getText();
				
				
				
				
				test.log(LogStatus.INFO, "Campaign Sent Tile : "+Campaign_SentTile);
				test.log(LogStatus.INFO, "Scheduled Sent Tile : "+Scheduled_Tile);
				test.log(LogStatus.INFO, "Drafted Sent Tile : "+Drafted_Tile);
				test.log(LogStatus.INFO, "Total Visits Tile : "+Total_Visits_Tile);
				test.log(LogStatus.INFO, "Visit Conversion Rate Tile : "+Visit_Conversion_Rate_Tile);

				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

				db.Verify_Campaign_Reach("Last 7 Days");
				db.Verify_Top_Campaings();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	}
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Marketing_This_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_This_Month_TimePeriod();
		
		
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "Dashboard : Marketing Report is Displayed for This month");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Campaign Sent Value
				String Campaign_SentTile=db.Campaign_Sent_TileValue().getText();
				
				//Scheduled Value
				String Scheduled_Tile=db.Scheduled_TileValue().getText();
						
				//Drafted Value
				String Drafted_Tile=db.Drafted_TileValue().getText();
				
				//Total Visits Value
				String Total_Visits_Tile=db.Total_Visits_TileValue().getText();
					
				//Visit Conversion Rate Value
				String Visit_Conversion_Rate_Tile=db.Visit_Conversion_Rate_TileValue().getText();
				
				test.log(LogStatus.INFO, "Campaign Sent Tile : "+Campaign_SentTile);
				test.log(LogStatus.INFO, "Scheduled Sent Tile : "+Scheduled_Tile);
				test.log(LogStatus.INFO, "Drafted Sent Tile : "+Drafted_Tile);
				test.log(LogStatus.INFO, "Total Visits Tile : "+Total_Visits_Tile);
				test.log(LogStatus.INFO, "Visit Conversion Rate Tile : "+Visit_Conversion_Rate_Tile);

				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

				db.Verify_Campaign_Reach("This month");
				db.Verify_Top_Campaings();
			
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	}
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Marketing_Last_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Last_Month_TimePeriod();
		
		
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "Dashboard : Marketing Report is Displayed for Last month");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Campaign Sent Value
				String Campaign_SentTile=db.Campaign_Sent_TileValue().getText();
				
				//Scheduled Value
				String Scheduled_Tile=db.Scheduled_TileValue().getText();
						
				//Drafted Value
				String Drafted_Tile=db.Drafted_TileValue().getText();
				
				//Total Visits Value
				String Total_Visits_Tile=db.Total_Visits_TileValue().getText();
					
				//Visit Conversion Rate Value
				String Visit_Conversion_Rate_Tile=db.Visit_Conversion_Rate_TileValue().getText();
				
				
				
				
				
				test.log(LogStatus.INFO, "Campaign Sent Tile : "+Campaign_SentTile);
				test.log(LogStatus.INFO, "Scheduled Sent Tile : "+Scheduled_Tile);
				test.log(LogStatus.INFO, "Drafted Sent Tile : "+Drafted_Tile);
				test.log(LogStatus.INFO, "Total Visits Tile : "+Total_Visits_Tile);
				test.log(LogStatus.INFO, "Visit Conversion Rate Tile : "+Visit_Conversion_Rate_Tile);

				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

				db.Verify_Campaign_Reach("Last month");
				db.Verify_Top_Campaings();
	
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Marketing_Last_30_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Last_30_Days_TimePeriod();
		
		
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "Dashboard : Marketing Report is Displayed for Last 30 days");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Campaign Sent Value
				String Campaign_SentTile=db.Campaign_Sent_TileValue().getText();
				
				//Scheduled Value
				String Scheduled_Tile=db.Scheduled_TileValue().getText();
						
				//Drafted Value
				String Drafted_Tile=db.Drafted_TileValue().getText();
				
				//Total Visits Value
				String Total_Visits_Tile=db.Total_Visits_TileValue().getText();
					
				//Visit Conversion Rate Value
				String Visit_Conversion_Rate_Tile=db.Visit_Conversion_Rate_TileValue().getText();
				
				
				
				
				
				test.log(LogStatus.INFO, "Campaign Sent Tile : "+Campaign_SentTile);
				test.log(LogStatus.INFO, "Scheduled Sent Tile : "+Scheduled_Tile);
				test.log(LogStatus.INFO, "Drafted Sent Tile : "+Drafted_Tile);
				test.log(LogStatus.INFO, "Total Visits Tile : "+Total_Visits_Tile);
				test.log(LogStatus.INFO, "Visit Conversion Rate Tile : "+Visit_Conversion_Rate_Tile);
		
				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

				db.Verify_Campaign_Reach("Last 30 days");
				db.Verify_Top_Campaings();
	
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Marketing_Specific_Date(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
		
		
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "Dashboard : Marketing Report is Displayed for Specific Date");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Campaign Sent Value
				String Campaign_SentTile=db.Campaign_Sent_TileValue().getText();
				
				//Scheduled Value
				String Scheduled_Tile=db.Scheduled_TileValue().getText();
						
				//Drafted Value
				String Drafted_Tile=db.Drafted_TileValue().getText();
				
				//Total Visits Value
				String Total_Visits_Tile=db.Total_Visits_TileValue().getText();
					
				//Visit Conversion Rate Value
				String Visit_Conversion_Rate_Tile=db.Visit_Conversion_Rate_TileValue().getText();
				
				
				
				
				test.log(LogStatus.INFO, "Campaign Sent Tile : "+Campaign_SentTile);
				test.log(LogStatus.INFO, "Scheduled Sent Tile : "+Scheduled_Tile);
				test.log(LogStatus.INFO, "Drafted Sent Tile : "+Drafted_Tile);
				test.log(LogStatus.INFO, "Total Visits Tile : "+Total_Visits_Tile);
				test.log(LogStatus.INFO, "Visit Conversion Rate Tile : "+Visit_Conversion_Rate_Tile);

				
				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
				
				db.Verify_Campaign_Reach("Specific Date");
				db.Verify_Top_Campaings();
			
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_Marketing_Date_Range(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		db=new DashBoardPage(driver, test);

		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		
		
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "Dashboard : Marketing Report is Displayed for Date Range");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Campaign Sent Value
				String Campaign_SentTile=db.Campaign_Sent_TileValue().getText();
				
				//Scheduled Value
				String Scheduled_Tile=db.Scheduled_TileValue().getText();
						
				//Drafted Value
				String Drafted_Tile=db.Drafted_TileValue().getText();
				
				//Total Visits Value
				String Total_Visits_Tile=db.Total_Visits_TileValue().getText();
					
				//Visit Conversion Rate Value
				String Visit_Conversion_Rate_Tile=db.Visit_Conversion_Rate_TileValue().getText();
				
				
				
				
				test.log(LogStatus.INFO, "Campaign Sent Tile : "+Campaign_SentTile);
				test.log(LogStatus.INFO, "Scheduled Sent Tile : "+Scheduled_Tile);
				test.log(LogStatus.INFO, "Drafted Sent Tile : "+Drafted_Tile);
				test.log(LogStatus.INFO, "Total Visits Tile : "+Total_Visits_Tile);
				test.log(LogStatus.INFO, "Visit Conversion Rate Tile : "+Visit_Conversion_Rate_Tile);

					
				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

				db.Verify_Campaign_Reach("Date Range");
				db.Verify_Top_Campaings();
		
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);


	}
	

}
