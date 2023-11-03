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
import com.epam.healenium.SelfHealingDriver;
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

public class Dashboard_KDS 
{

public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Dashboard - KDS");
	
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
		Open_Dashboard_KDS_Page(driver);
		Dashboard_KDS_Today(driver);
		Dashboard_KDS_Yesterday(driver);
		Dashboard_KDS_Last_N_Days(driver);
		Dashboard_KDS_This_Week(driver);
		Dashboard_KDS_Last_Week(driver);
		Dashboard_KDS_Last_7_Days(driver);
		Dashboard_KDS_This_Month(driver);
		Dashboard_KDS_Last_Month(driver);
		Dashboard_KDS_Last_30_Days(driver);
		Dashboard_KDS_Specific_Date(driver);
		Dashboard_KDS_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Dashboard_KDS_Page(SelfHealingDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Daily page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id4")+"kitchenKDS");

		Thread.sleep(5000);
		//Verify the Categories page loaded or not
		repts.Verify_ReportHomePage("KDS");
		
	}
	

	@Test(priority = 4,enabled = false)
	public void Dashboard_KDS_Today(SelfHealingDriver driver) throws Exception
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
		
		test.log(LogStatus.PASS, "Dashboard : KDS Report is Displayed for Today");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Total Orders value
		String Total_Orders=db.Total_Orders_TileValue().getText();
		
		//Avg Time Per Check value
		String AvgTime_PerCheck=db.Avg_Time_PerCheck_TileValue().getText();
				
		//Total Item Count value
		String Total_ItemCount=db.Total_Item_Count_TileValue().getText();
		
		//Avg Time Per Item value
		String AvgTime_PerItem=db.Avg_Time_PerItem_TileValue().getText();
			
		
		test.log(LogStatus.INFO, "Total Orders Tile : "+Total_Orders);
		test.log(LogStatus.INFO, "Avg. Time Per Check Tile : "+AvgTime_PerCheck);
		test.log(LogStatus.INFO, "Total Item Count Tile : "+Total_ItemCount);
		test.log(LogStatus.INFO, "Avg. Time Per Item Tile : "+AvgTime_PerItem);
		

		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		
		db.Verify_Total_Orders("Today");
		db.Verify_Average_Time_perCheck();
		db.Verify_Total_Item_Count();
		db.Verify_Average_Time_perItem();
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_KDS_Yesterday(SelfHealingDriver driver) throws Exception
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
		
		test.log(LogStatus.PASS, "Dashboard : KDS Report is Displayed for Yesterday");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Total Orders value
				String Total_Orders=db.Total_Orders_TileValue().getText();
				
				//Avg Time Per Check value
				String AvgTime_PerCheck=db.Avg_Time_PerCheck_TileValue().getText();
						
				//Total Item Count value
				String Total_ItemCount=db.Total_Item_Count_TileValue().getText();
				
				//Avg Time Per Item value
				String AvgTime_PerItem=db.Avg_Time_PerItem_TileValue().getText();
					
		
				test.log(LogStatus.INFO, "Total Orders Tile : "+Total_Orders);
				test.log(LogStatus.INFO, "Avg. Time Per Check Tile : "+AvgTime_PerCheck);
				test.log(LogStatus.INFO, "Total Item Count Tile : "+Total_ItemCount);
				test.log(LogStatus.INFO, "Avg. Time Per Item Tile : "+AvgTime_PerItem);
				

				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

				db.Verify_Total_Orders("Yesterday");
				db.Verify_Average_Time_perCheck();
				db.Verify_Total_Item_Count();
				db.Verify_Average_Time_perItem();

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	}
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_KDS_Last_N_Days(SelfHealingDriver driver) throws Exception
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
		test.log(LogStatus.PASS, "Dashboard : KDS Report is Displayed for Last N days");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Total Orders value
				String Total_Orders=db.Total_Orders_TileValue().getText();
				
				//Avg Time Per Check value
				String AvgTime_PerCheck=db.Avg_Time_PerCheck_TileValue().getText();
						
				//Total Item Count value
				String Total_ItemCount=db.Total_Item_Count_TileValue().getText();
				
				//Avg Time Per Item value
				String AvgTime_PerItem=db.Avg_Time_PerItem_TileValue().getText();
					
				
				test.log(LogStatus.INFO, "Total Orders Tile : "+Total_Orders);
				test.log(LogStatus.INFO, "Avg. Time Per Check Tile : "+AvgTime_PerCheck);
				test.log(LogStatus.INFO, "Total Item Count Tile : "+Total_ItemCount);
				test.log(LogStatus.INFO, "Avg. Time Per Item Tile : "+AvgTime_PerItem);
				

				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
				db.Verify_Total_Orders("Last 'N' Days");
				db.Verify_Average_Time_perCheck();
				db.Verify_Total_Item_Count();
				db.Verify_Average_Time_perItem();
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			
	
	}

	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_KDS_This_Week(SelfHealingDriver driver) throws Exception
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
		test.log(LogStatus.PASS, "Dashboard : KDS Report is Displayed for This Week");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Total Orders value
				String Total_Orders=db.Total_Orders_TileValue().getText();
				
				//Avg Time Per Check value
				String AvgTime_PerCheck=db.Avg_Time_PerCheck_TileValue().getText();
						
				//Total Item Count value
				String Total_ItemCount=db.Total_Item_Count_TileValue().getText();
				
				//Avg Time Per Item value
				String AvgTime_PerItem=db.Avg_Time_PerItem_TileValue().getText();
				
				test.log(LogStatus.INFO, "Total Orders Tile : "+Total_Orders);
				test.log(LogStatus.INFO, "Avg. Time Per Check Tile : "+AvgTime_PerCheck);
				test.log(LogStatus.INFO, "Total Item Count Tile : "+Total_ItemCount);
				test.log(LogStatus.INFO, "Avg. Time Per Item Tile : "+AvgTime_PerItem);
				

				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
	
				db.Verify_Total_Orders("This Week");
				db.Verify_Average_Time_perCheck();
				db.Verify_Total_Item_Count();
				db.Verify_Average_Time_perItem();
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_KDS_Last_Week(SelfHealingDriver driver) throws Exception
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
		test.log(LogStatus.PASS, "Dashboard : KDS Report is Displayed for Last Week");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Total Orders value
				String Total_Orders=db.Total_Orders_TileValue().getText();
				
				//Avg Time Per Check value
				String AvgTime_PerCheck=db.Avg_Time_PerCheck_TileValue().getText();
						
				//Total Item Count value
				String Total_ItemCount=db.Total_Item_Count_TileValue().getText();
				
				//Avg Time Per Item value
				String AvgTime_PerItem=db.Avg_Time_PerItem_TileValue().getText();
					
			
				test.log(LogStatus.INFO, "Total Orders Tile : "+Total_Orders);
				test.log(LogStatus.INFO, "Avg. Time Per Check Tile : "+AvgTime_PerCheck);
				test.log(LogStatus.INFO, "Total Item Count Tile : "+Total_ItemCount);
				test.log(LogStatus.INFO, "Avg. Time Per Item Tile : "+AvgTime_PerItem);
				

				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
				
				db.Verify_Total_Orders("Last Week");
				db.Verify_Average_Time_perCheck();
				db.Verify_Total_Item_Count();
				db.Verify_Average_Time_perItem();
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	}
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_KDS_Last_7_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		//Select Today
		repts.Select_Last_7_Days_TimePeriod();
		
		
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		test.log(LogStatus.PASS, "Dashboard : KDS Report is Displayed for Last 7 days");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Total Orders value
				String Total_Orders=db.Total_Orders_TileValue().getText();
				
				//Avg Time Per Check value
				String AvgTime_PerCheck=db.Avg_Time_PerCheck_TileValue().getText();
						
				//Total Item Count value
				String Total_ItemCount=db.Total_Item_Count_TileValue().getText();
				
				//Avg Time Per Item value
				String AvgTime_PerItem=db.Avg_Time_PerItem_TileValue().getText();
				
				test.log(LogStatus.INFO, "Total Orders Tile : "+Total_Orders);
				test.log(LogStatus.INFO, "Avg. Time Per Check Tile : "+AvgTime_PerCheck);
				test.log(LogStatus.INFO, "Total Item Count Tile : "+Total_ItemCount);
				test.log(LogStatus.INFO, "Avg. Time Per Item Tile : "+AvgTime_PerItem);
				

				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

				db.Verify_Total_Orders("Last 7 Days");
				db.Verify_Average_Time_perCheck();
				db.Verify_Total_Item_Count();
				db.Verify_Average_Time_perItem();
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	}
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_KDS_This_Month(SelfHealingDriver driver) throws Exception
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
		test.log(LogStatus.PASS, "Dashboard : KDS Report is Displayed for This month");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Total Orders value
				String Total_Orders=db.Total_Orders_TileValue().getText();
				
				//Avg Time Per Check value
				String AvgTime_PerCheck=db.Avg_Time_PerCheck_TileValue().getText();
						
				//Total Item Count value
				String Total_ItemCount=db.Total_Item_Count_TileValue().getText();
				
				//Avg Time Per Item value
				String AvgTime_PerItem=db.Avg_Time_PerItem_TileValue().getText();
					
				
				
				
				test.log(LogStatus.INFO, "Total Orders Tile : "+Total_Orders);
				test.log(LogStatus.INFO, "Avg. Time Per Check Tile : "+AvgTime_PerCheck);
				test.log(LogStatus.INFO, "Total Item Count Tile : "+Total_ItemCount);
				test.log(LogStatus.INFO, "Avg. Time Per Item Tile : "+AvgTime_PerItem);
				

				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

				db.Verify_Total_Orders("This month");
				db.Verify_Average_Time_perCheck();
				db.Verify_Total_Item_Count();
				db.Verify_Average_Time_perItem();
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	}
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_KDS_Last_Month(SelfHealingDriver driver) throws Exception
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
		test.log(LogStatus.PASS, "Dashboard : KDS Report is Displayed for Last month");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Total Orders value
				String Total_Orders=db.Total_Orders_TileValue().getText();
				
				//Avg Time Per Check value
				String AvgTime_PerCheck=db.Avg_Time_PerCheck_TileValue().getText();
						
				//Total Item Count value
				String Total_ItemCount=db.Total_Item_Count_TileValue().getText();
				
				//Avg Time Per Item value
				String AvgTime_PerItem=db.Avg_Time_PerItem_TileValue().getText();
				
				
				test.log(LogStatus.INFO, "Total Orders Tile : "+Total_Orders);
				test.log(LogStatus.INFO, "Avg. Time Per Check Tile : "+AvgTime_PerCheck);
				test.log(LogStatus.INFO, "Total Item Count Tile : "+Total_ItemCount);
				test.log(LogStatus.INFO, "Avg. Time Per Item Tile : "+AvgTime_PerItem);
				

				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

				db.Verify_Total_Orders("Last month");
				db.Verify_Average_Time_perCheck();
				db.Verify_Total_Item_Count();
				db.Verify_Average_Time_perItem();
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_KDS_Last_30_Days(SelfHealingDriver driver) throws Exception
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
		test.log(LogStatus.PASS, "Dashboard : KDS Report is Displayed for Last 30 days");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Total Orders value
				String Total_Orders=db.Total_Orders_TileValue().getText();
				
				//Avg Time Per Check value
				String AvgTime_PerCheck=db.Avg_Time_PerCheck_TileValue().getText();
						
				//Total Item Count value
				String Total_ItemCount=db.Total_Item_Count_TileValue().getText();
				
				//Avg Time Per Item value
				String AvgTime_PerItem=db.Avg_Time_PerItem_TileValue().getText();
					
				test.log(LogStatus.INFO, "Total Orders Tile : "+Total_Orders);
				test.log(LogStatus.INFO, "Avg. Time Per Check Tile : "+AvgTime_PerCheck);
				test.log(LogStatus.INFO, "Total Item Count Tile : "+Total_ItemCount);
				test.log(LogStatus.INFO, "Avg. Time Per Item Tile : "+AvgTime_PerItem);
				
		
				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

				db.Verify_Total_Orders("Last 30 days");
				db.Verify_Average_Time_perCheck();
				db.Verify_Total_Item_Count();
				db.Verify_Average_Time_perItem();
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_KDS_Specific_Date(SelfHealingDriver driver) throws Exception
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
		test.log(LogStatus.PASS, "Dashboard : KDS Report is Displayed for Specific Date");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Total Orders value
				String Total_Orders=db.Total_Orders_TileValue().getText();
				
				//Avg Time Per Check value
				String AvgTime_PerCheck=db.Avg_Time_PerCheck_TileValue().getText();
						
				//Total Item Count value
				String Total_ItemCount=db.Total_Item_Count_TileValue().getText();
				
				//Avg Time Per Item value
				String AvgTime_PerItem=db.Avg_Time_PerItem_TileValue().getText();
				
				
				test.log(LogStatus.INFO, "Total Orders Tile : "+Total_Orders);
				test.log(LogStatus.INFO, "Avg. Time Per Check Tile : "+AvgTime_PerCheck);
				test.log(LogStatus.INFO, "Total Item Count Tile : "+Total_ItemCount);
				test.log(LogStatus.INFO, "Avg. Time Per Item Tile : "+AvgTime_PerItem);
				

				
				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
				
				db.Verify_Total_Orders("Specific Date");
				db.Verify_Average_Time_perCheck();
				db.Verify_Total_Item_Count();
				db.Verify_Average_Time_perItem();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Dashboard_KDS_Date_Range(SelfHealingDriver driver) throws Exception
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
		test.log(LogStatus.PASS, "Dashboard : KDS Report is Displayed for Date Range");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		//Total Orders value
				String Total_Orders=db.Total_Orders_TileValue().getText();
				
				//Avg Time Per Check value
				String AvgTime_PerCheck=db.Avg_Time_PerCheck_TileValue().getText();
						
				//Total Item Count value
				String Total_ItemCount=db.Total_Item_Count_TileValue().getText();
				
				//Avg Time Per Item value
				String AvgTime_PerItem=db.Avg_Time_PerItem_TileValue().getText();
					
				test.log(LogStatus.INFO, "Total Orders Tile : "+Total_Orders);
				test.log(LogStatus.INFO, "Avg. Time Per Check Tile : "+AvgTime_PerCheck);
				test.log(LogStatus.INFO, "Total Item Count Tile : "+Total_ItemCount);
				test.log(LogStatus.INFO, "Avg. Time Per Item Tile : "+AvgTime_PerItem);
				

					
				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);

				db.Verify_Total_Orders("Date Range");
				db.Verify_Average_Time_perCheck();
				db.Verify_Total_Item_Count();
				db.Verify_Average_Time_perItem();
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);


	}
	

}
