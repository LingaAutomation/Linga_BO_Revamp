package com.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
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

import com.Pages.ReportsPage;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Reports_Master_Stock_Report 
{

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Reports - Master Stock");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();

	String SM,st = "NA";
	
	double BeginQua, BeginPri,OnHandQua, OnHandPri;
	
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	ReportsPage repts;
	
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
		//System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
		//Open the Chrome window
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().driverVersion("110.0.5481").setup();
		driver = new ChromeDriver(chromeOptions);
		
		//Wait for 30 seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Maximize the Chrome window
		driver.manage().window().maximize();
		Thread.sleep(1000);
		//Launch the URL
		driver.get(Utility.getProperty("appURL"));
		
		Thread.sleep(10000);
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
		Open_Master_Stock_Report_Page(driver);
		RefreshAndPaginination(driver);
		Master_Stock_Report_Today(driver);
		Master_Stock_Report_Yesterday(driver);
		Master_Stock_Report_Last_N_Days(driver);
		Master_Stock_Report_This_Week(driver);
		Master_Stock_Report_Last_Week(driver);
		Master_Stock_Report_Last_7_Days(driver);
		Master_Stock_Report_This_Month(driver);
		Master_Stock_Report_Last_Month(driver);
		Master_Stock_Report_Last_30_Days(driver);
		Master_Stock_Report_Specific_Date(driver);
		Master_Stock_Report_Date_Range(driver);

	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Master_Stock_Report_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Menu Item sales report page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"inventoryReports/masterStockReport");

		Thread.sleep(5000);
		//Verify the void transactions report page loeded or not
		repts.Verify_ReportHomePage("MASTER STOCK");
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No master stock record for the selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Master Stock Report Not Available for Today");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			List<WebElement> menuList=driver.findElements(By.xpath("//tbody/tr"));

			int menuSize=menuList.size();

			int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);

			String s = driver.findElement(By.xpath("//tbody/tr["+randomMenu+"]/td[9]")).getText().trim();
			
			SM = s;
			
			//Clear the Search
			driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
			
			//Enter the Search value
			driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(s);
			
			Thread.sleep(3000);
			
			if(driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText().trim().equals(s)) {
				test.log(LogStatus.PASS, "The required item is displayed while searching");
			}else {
				test.log(LogStatus.FAIL, "The required item is not displayed while searching");
			}
			
			//Verify the Pagination and Refresh the page
			//			cmp.VerifyPagination_and_Refresh_Publish();
			
			//Verify Column Filtration
			cmp.Filter_Columns_Table1();

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void SelectTheType_ALL(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);	
		//Click the Type
		driver.findElement(By.xpath("(//span[contains(.,'Type')]/../input)")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option/div[contains(.,'ALL')]")).click();
		Thread.sleep(500);
	}
	
	@Test(priority = 4,enabled = false)
	public void SelectTheType_InventoryItem(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);	
		//Click the Type
		driver.findElement(By.xpath("(//span[contains(.,'Type')]/../input)")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option/div[contains(.,'Inventory Item')]")).click();
		Thread.sleep(500);
	}
	
	@Test(priority = 4,enabled = false)
	public void SelectTheType_RetailItem(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);	
		//Click the Type
		driver.findElement(By.xpath("(//span[contains(.,'Type')]/../input)")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option/div[contains(.,'Retail Item')]")).click();
		Thread.sleep(500);
	}
	
	public void Search(WebDriver driver) throws Exception
	{
		List<WebElement> menuList=driver.findElements(By.xpath("//tbody/tr"));

		int menuSize=menuList.size();

		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);

		String s = driver.findElement(By.xpath("//tbody/tr["+randomMenu+"]/td[9]")).getText().trim();
		
		SM = s;
		
		//Clear the Search
		driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
		
		//Enter the Search value
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(SM);
		
		Thread.sleep(3000);
		for(int i = 1; i <= 4; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}Thread.sleep(1000);
	}
	

	@Test(priority = 4,enabled = false)
	public void verifyTheValues(WebDriver driver) throws Exception
	{
		//get the value of total
		String UQ = driver.findElement(By.xpath("//tbody/tr/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double uq1 = Double.parseDouble(UQ);
		
		//get the value of Quantity
		String IUQ = driver.findElement(By.xpath("//tbody/tr/td[12]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double iuq1 = Double.parseDouble(IUQ);
		
		//get the value of price per unit
		String AQ = driver.findElement(By.xpath("//tbody/tr/td[13]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double aq1 = Double.parseDouble(AQ);
		
		double uq_C = iuq1 * aq1;
		
		if(uq1 == uq_C) {
			test.log(LogStatus.PASS, "The displayed Usage Quantity is Correct with its calculation and the value is : "+uq_C);
		}
		else {
			double diff = uq_C - uq1;
			test.log(LogStatus.INFO, "The displayed Total is : "+uq1);
			test.log(LogStatus.INFO, "The displayed Quantity is : "+iuq1);
			test.log(LogStatus.INFO, "The displayed Price Per Unit is : "+aq1);
			test.log(LogStatus.FAIL, "The displayed Total is not Correct with its calculation, the difference is : "+diff);
		}
	}
	

	
	@Test(priority = 4,enabled = false)
	public void Master_Stock_Report_Today(WebDriver driver) throws Exception
	{
		test.log(LogStatus.INFO, "************************************************** Master Stock(Start) **************************************************");

		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	//	ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheType_ALL(driver);
		
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No master stock record for the selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Master Stock Report Not Available for Today");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "***************************** Master Stock Report Available for Today *****************************");
			
			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Master_Stock_Report_Yesterday(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select Yesterday
		repts.Select_Yesterday_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No master stock record for the selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Master Stock Report Not Available for Yesterday");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Master Stock Report Available for Yesterday *****************************");

			Thread.sleep(2000);
			Search(driver);
			Thread.sleep(2000);			
			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Master_Stock_Report_Last_N_Days(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select Last N days
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No master stock record for the selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Master Stock Report Not Available for Last N Days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Master Stock Report Available for Last N days *****************************");

			Search(driver);
			Thread.sleep(2000);
			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	
	
	@Test(priority = 4,enabled = false)
	public void Master_Stock_Report_This_Week(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select This Week
		repts.Select_This_Week_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No master stock record for the selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Master Stock Report Not Available for This Week");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Master Stock Report Available for This Week *****************************");

			Search(driver);
			Thread.sleep(2000);
			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Master_Stock_Report_Last_Week(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select Last Week
		repts.Select_Last_Week_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No master stock record for the selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Master Stock Report Not Available for Last Week");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Master Stock Report Available for Last Week *****************************");

			Search(driver);
			Thread.sleep(2000);
			
			verifyTheValues(driver);
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Master_Stock_Report_Last_7_Days(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select Last 7 days
		repts.Select_Last_7_Days_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No master stock record for the selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Master Stock Report Not Available for Last 7 days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Master Stock Report Available for Last 7 days *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Master_Stock_Report_This_Month(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select This month
		repts.Select_This_Month_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No master stock record for the selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Master Stock Report Not Available for This month");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Master Stock Report Available for This month *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Master_Stock_Report_Last_Month(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select Last month
		repts.Select_Last_Month_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No master stock record for the selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Master Stock Report Not Available for Last month");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Master Stock Report Available for Last month *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Master_Stock_Report_Last_30_Days(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select Last 30 days
		repts.Select_Last_30_Days_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No master stock record for the selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Master Stock Report Not Available for Last 30 days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Master Stock Report Available for Last 30 days *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Master_Stock_Report_Specific_Date(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select Specific Date
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No master stock record for the selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Master Stock Report Not Available for Specific Date");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Master Stock Report Available for Specific Date *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Master_Stock_Report_Date_Range(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select Date Range
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No master stock record for the selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Master Stock Report Not Available for Date Range");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Master Stock Report Available for Date Range *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}			test.log(LogStatus.INFO, "************************************************** Master Stock(End) **************************************************");
	}

}
