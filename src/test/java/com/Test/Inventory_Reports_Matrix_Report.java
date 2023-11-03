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
import com.epam.healenium.SelfHealingDriver;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Reports_Matrix_Report 
{

public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
ExtentTest test = rep.startTest("Inventory - Reports - Matrix Report");
	
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
		//System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
		//Open the Chrome window
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().driverVersion("110.0.5481").setup();
//		driver = new ChromeDriver(chromeOptions);

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
		Open_Matrix_Report_Page(driver);
		RefreshAndPaginination(driver);
		Matrix_Report_Today(driver);
		Matrix_Report_Yesterday(driver);
		Matrix_Report_Last_N_Days(driver);
		Matrix_Report_This_Week(driver);
		Matrix_Report_Last_Week(driver);
		Matrix_Report_Last_7_Days(driver);
		Matrix_Report_This_Month(driver);
		Matrix_Report_Last_Month(driver);
		Matrix_Report_Last_30_Days(driver);
		Matrix_Report_Specific_Date(driver);
		Matrix_Report_Date_Range(driver);

	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Matrix_Report_Page(SelfHealingDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Menu Item sales report page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"inventoryReports/matrixReport");

		Thread.sleep(5000);
		driver.findElement(By.xpath("//button[contains(@class,'pagination-after')]")).click();
		Thread.sleep(1000);
		//Verify the void transactions report page loeded or not
		repts.Verify_ReportHomePage("MATRIX REPORT");
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		try {
			List<WebElement> menuList=driver.findElements(By.xpath("//div/div[contains(@class,'content-container')]"));

			int menuSize=menuList.size();

			int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);

			String s = driver.findElement(By.xpath("//div/div[contains(@class,'content-container')]/../../div["+randomMenu+"]/div/data-grid-row/div/div[1]/span")).getText().trim();
			
			SM = s;
			
			//Clear the Search
			driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
			
			//Enter the Search value
			driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(s);
			
			Thread.sleep(3000);
			
			if(driver.findElement(By.xpath("//div/div[contains(@class,'content-container')]/data-grid-row/div/div[1]/span")).getText().trim().equals(s)) {
				test.log(LogStatus.PASS, "The required item is displayed while searching");
			}else {
				test.log(LogStatus.FAIL, "The required item is not displayed while searching");
			}
		}catch(Exception f) {}
		
		
		//Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
	}
	
	@Test(priority = 4,enabled = false)
	public void SelectTheType_ALL(SelfHealingDriver driver) throws Exception
	{
		Thread.sleep(5000);	
		//Click the Type
		driver.findElement(By.xpath("(//span[contains(.,'Level')]/../input)")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option/div[contains(.,'ALL')]")).click();
		Thread.sleep(500);
	}
	

	public void Search(SelfHealingDriver driver) throws Exception
	{
		List<WebElement> menuList=driver.findElements(By.xpath("//div/div[contains(@class,'content-container')]"));
		String s;
		int menuSize=menuList.size();
		if(menuList.size() == 1) {
			 s = driver.findElement(By.xpath("//div/div[contains(@class,'content-container')]/../../div[1]/div/data-grid-row/div/div[1]/span")).getText().trim();
		}
		else {
			int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);

			 s = driver.findElement(By.xpath("//div/div[contains(@class,'content-container')]/../../div["+randomMenu+"]/div/data-grid-row/div/div[1]/span")).getText().trim();

		}
		
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
	public void verifyTheValues(SelfHealingDriver driver) throws Exception
	{
		//get the value of Cost Per Unit
		String CPU = driver.findElement(By.xpath("//div[@class='content-container']/data-grid-row/div/div[5]/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double cpu1 = Double.parseDouble(CPU);
		
		//get the value of Total Cost
		String TC = driver.findElement(By.xpath("//div[@class='content-container']/data-grid-row/div/div[8]/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double tc1 = Double.parseDouble(TC);
		
		//get the value of Sold Quantity
		String SQ = driver.findElement(By.xpath("//div[@class='content-container']/data-grid-row/div/div[3]/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double sq1 = Double.parseDouble(SQ);
		
		double CPU_C = tc1 / sq1;

		if(cpu1 == CPU_C) {
			test.log(LogStatus.PASS, "The displayed Cost Per Unit is Correct with its calculation and the value is : "+cpu1);
		}
		else {
			double diff = CPU_C - cpu1;
			test.log(LogStatus.INFO, "The displayed Usage Quantity is : "+cpu1);
			test.log(LogStatus.INFO, "The displayed Ideal Used Quantity is : "+tc1);
			test.log(LogStatus.INFO, "The displayed Adjusted/Actual Quantity is : "+sq1);
			test.log(LogStatus.FAIL, "The displayed Usage Quantity is not Correct with its calculation, the difference is : "+diff);
		}
		
		
		//  Profit = (selling price - discount - inclusive tax- total cost) /sold quantity
		//  Total revenue = selling price - discount - inclusive tax
		//  Total profit = selling price - discount - inclusive tax- total cost.
		
		// In matrix report we don't have the inclusive tax and Discount. Due to that we are unable to calculate Profit, Total Revenue and Total Profit
		
	}
	

	
	@Test(priority = 4,enabled = false)
	public void Matrix_Report_Today(SelfHealingDriver driver) throws Exception
	{
		test.log(LogStatus.INFO, "************************************************** COMPARE INVENTORY(Start) **************************************************");

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
			if(driver.findElement(By.xpath("//span[contains(.,'Matrix Report not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Today");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Today *****************************");
			
			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Matrix_Report_Yesterday(SelfHealingDriver driver) throws Exception
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
			if(driver.findElement(By.xpath("//span[contains(.,'Matrix Report not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Yesterday");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Yesterday *****************************");

			Thread.sleep(2000);
			Search(driver);
			Thread.sleep(2000);
			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Matrix_Report_Last_N_Days(SelfHealingDriver driver) throws Exception
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
			if(driver.findElement(By.xpath("//span[contains(.,'Matrix Report not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Last N Days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Last N days *****************************");

			Search(driver);
			Thread.sleep(2000);
			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	
	
	@Test(priority = 4,enabled = false)
	public void Matrix_Report_This_Week(SelfHealingDriver driver) throws Exception
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
			if(driver.findElement(By.xpath("//span[contains(.,'Matrix Report not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for This Week");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for This Week *****************************");

			Search(driver);
			Thread.sleep(2000);
			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Matrix_Report_Last_Week(SelfHealingDriver driver) throws Exception
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
			if(driver.findElement(By.xpath("//span[contains(.,'Matrix Report not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Last Week");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Last Week *****************************");

			Search(driver);
			Thread.sleep(2000);
			
			verifyTheValues(driver);
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Matrix_Report_Last_7_Days(SelfHealingDriver driver) throws Exception
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
			if(driver.findElement(By.xpath("//span[contains(.,'Matrix Report not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Last 7 days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Last 7 days *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Matrix_Report_This_Month(SelfHealingDriver driver) throws Exception
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
			if(driver.findElement(By.xpath("//span[contains(.,'Matrix Report not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for This month");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for This month *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Matrix_Report_Last_Month(SelfHealingDriver driver) throws Exception
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
			if(driver.findElement(By.xpath("//span[contains(.,'Matrix Report not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Last month");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Last month *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Matrix_Report_Last_30_Days(SelfHealingDriver driver) throws Exception
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
			if(driver.findElement(By.xpath("//span[contains(.,'Matrix Report not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Last 30 days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Last 30 days *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Matrix_Report_Specific_Date(SelfHealingDriver driver) throws Exception
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
			if(driver.findElement(By.xpath("//span[contains(.,'Matrix Report not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Specific Date");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Specific Date *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Matrix_Report_Date_Range(SelfHealingDriver driver) throws Exception
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
			if(driver.findElement(By.xpath("//span[contains(.,'Matrix Report not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Date Range");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Date Range *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}			test.log(LogStatus.INFO, "************************************************** COMPARE INVENTORY(End) **************************************************");
	}

}
