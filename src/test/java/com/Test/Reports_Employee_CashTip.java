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

import com.Pages.ReportsPage;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports_Employee_CashTip 
{

public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Employee Cash Tip");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();

	String st = "NA";
	
	
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
		Open_Employee_CashTip_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Employee_CashTip_Report_Today_All(driver);
		Employee_CashTip_Report_Yesterday_All(driver);
		Employee_CashTip_Report_Last_N_Days_All(driver);
		Employee_CashTip_Report_This_Week_All(driver);
		Employee_CashTip_Report_Last_Week_All(driver);
		Employee_CashTip_Report_Last_7_Days_All(driver);
		Employee_CashTip_Report_This_Month_All(driver);
		Employee_CashTip_Report_Last_Month_All(driver);
		Employee_CashTip_Report_Last_30_Days_All(driver);
		Employee_CashTip_Report_Specific_Date_All(driver);
		Employee_CashTip_Report_Date_Range_All(driver);
		Employee_CashTip_Report_Today_Active(driver);
		Employee_CashTip_Report_Yesterday_Active(driver);
		Employee_CashTip_Report_Last_N_Days_Active(driver);
		Employee_CashTip_Report_This_Week_Active(driver);
		Employee_CashTip_Report_Last_Week_Active(driver);
		Employee_CashTip_Report_Last_7_Days_Active(driver);
		Employee_CashTip_Report_This_Month_Active(driver);
		Employee_CashTip_Report_Last_Month_Active(driver);
		Employee_CashTip_Report_Last_30_Days_Active(driver);
		Employee_CashTip_Report_Specific_Date_Active(driver);
		Employee_CashTip_Report_Date_Range_Active(driver);
		Employee_CashTip_Report_Today_Inactive(driver);
		Employee_CashTip_Report_Yesterday_Inactive(driver);
		Employee_CashTip_Report_Last_N_Days_Inactive(driver);
		Employee_CashTip_Report_This_Week_Inactive(driver);
		Employee_CashTip_Report_Last_Week_Inactive(driver);
		Employee_CashTip_Report_Last_7_Days_Inactive(driver);
		Employee_CashTip_Report_This_Month_Inactive(driver);
		Employee_CashTip_Report_Last_Month_Inactive(driver);
		Employee_CashTip_Report_Last_30_Days_Inactive(driver);
		Employee_CashTip_Report_Specific_Date_Inactive(driver);
		Employee_CashTip_Report_Date_Range_Inactive(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Employee_CashTip_Report_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Menu Item sales report page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"employee/cashtip");

		Thread.sleep(5000);
		//Verify the void transactions report page loeded or not
		repts.Verify_ReportHomePage("CASH TIP");
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
	}
	
	@Test(priority = 4,enabled = false)
	public void SelectTheAllStatus(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);	
		//Click the category label
		driver.findElement(By.xpath("(//span[contains(.,'Employee')]/../input)")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
		Thread.sleep(500);
		//Click the sub category label
		driver.findElement(By.xpath("(//span[contains(.,'Status')]/../input)")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		Thread.sleep(500);
	}
	
	@Test(priority = 4,enabled = false)
	public void SelectTheActiveStatus(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);	
		//Click the category label
		//driver.findElement(By.xpath("(//span[contains(.,'Employee')]/../input)")).click();
		Thread.sleep(500);
		//Select the All option
	//	driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
		Thread.sleep(500);
		//Click the sub category label
		driver.findElement(By.xpath("(//span[contains(.,'Status')]/../input)")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'Active')]")).click();
		Thread.sleep(500);
	}
	
	@Test(priority = 4,enabled = false)
	public void SelectTheInactiveStatus(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);	
		//Click the category label
		//driver.findElement(By.xpath("(//span[contains(.,'Employee')]/../input)")).click();
		//Thread.sleep(500);
		//Select the All option
		//driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
		Thread.sleep(500);
		//Click the sub category label
		driver.findElement(By.xpath("(//span[contains(.,'Status')]/../input)")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'Inactive')]")).click();
		Thread.sleep(500);
	}
	

	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Today_All(WebDriver driver) throws Exception
	{
		test.log(LogStatus.INFO, "************************************************** Tender By Name(Start) **************************************************");

		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	//	ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheAllStatus(driver);
		
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Today");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Void Transaction Report Available for Today");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			//Do pagination to Last
			//repts.Do_Pagination();
			
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Today : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Yesterday_All(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Yesterday");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Yesterday");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();


			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Yesterday : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Last_N_Days_All(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Last N Days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Last N days");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Last N Days : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_This_Week_All(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for This Week");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for This Week");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();


			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - This Week : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Last_Week_All(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Last Week");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Last Week");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Last Week : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Last_7_Days_All(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Last 7 days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Last 7 days");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();


			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Last 7 Days : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_This_Month_All(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for This month");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for This month");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();


			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - This Month : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Last_Month_All(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Last month");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Last month");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Last Month : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Last_30_Days_All(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Last 30 days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Last 30 days");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Last 30 days : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Specific_Date_All(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Specific Date");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Specific Date");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Specific Date : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Date_Range_All(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Date Range");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Date Range");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Date Range : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}			test.log(LogStatus.INFO, "************************************************** Tender By Name(End) **************************************************");
	}

	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Today_Active(WebDriver driver) throws Exception
	{
		test.log(LogStatus.INFO, "************************************************** Tender By Type(Start) **************************************************");

		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	//	ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheActiveStatus(driver);
		
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Today");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Void Transaction Report Available for Today");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			//Do pagination to Last
			//repts.Do_Pagination();
			
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Today : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Yesterday_Active(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Yesterday");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Yesterday");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();


			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Yesterday : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Last_N_Days_Active(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Last N Days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Last N days");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Last N Days : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_This_Week_Active(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for This Week");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for This Week");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();


			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - This Week : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Last_Week_Active(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Last Week");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Last Week");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Last Week : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Last_7_Days_Active(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Last 7 days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Last 7 days");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();


			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Last 7 Days : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_This_Month_Active(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for This month");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for This month");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();


			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - This Month : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Last_Month_Active(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Last month");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Last month");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Last Month : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Last_30_Days_Active(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Last 30 days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Last 30 days");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Last 30 Days : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Specific_Date_Active(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Specific Date");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Specific Date");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Specific Date : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Date_Range_Active(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Date Range");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Date Range");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			//div[contains(@class,'total row')]/div
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Date Range : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}			test.log(LogStatus.INFO, "************************************************** Tender By Type(End) **************************************************");
	}
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Today_Inactive(WebDriver driver) throws Exception
	{
		test.log(LogStatus.INFO, "************************************************** Tender By Type(Start) **************************************************");

		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	//	ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheInactiveStatus(driver);
		
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Today");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Void Transaction Report Available for Today");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			//Do pagination to Last
			//repts.Do_Pagination();
			
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Today : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Yesterday_Inactive(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Yesterday");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Yesterday");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();


			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Yesterday : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Last_N_Days_Inactive(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Last N Days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Last N days");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Last N Days : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_This_Week_Inactive(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for This Week");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for This Week");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();


			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - This Week : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Last_Week_Inactive(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Last Week");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Last Week");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Last Week : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Last_7_Days_Inactive(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Last 7 days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Last 7 days");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();


			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Last 7 Days : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_This_Month_Inactive(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for This month");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for This month");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();


			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - This Month : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Last_Month_Inactive(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Last month");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Last month");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Last Month : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Last_30_Days_Inactive(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Last 30 days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Last 30 days");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Last 30 Days : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Specific_Date_Inactive(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Specific Date");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Specific Date");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Specific Date : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Employee_CashTip_Report_Date_Range_Inactive(WebDriver driver) throws Exception
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
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Void Transaction Report Not Available for Date Range");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Void Transaction Report Available for Date Range");

			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();

			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();

			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			//div[contains(@class,'total row')]/div
			for(int i = 10;i<=colList.size();i++) {
				test.log(LogStatus.INFO, "Total "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+" value is available for the mentioned time period - Date Range : "+driver.findElement(By.xpath("//div[contains(@class,'total row')]/div["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}			test.log(LogStatus.INFO, "************************************************** Tender By Type(End) **************************************************");
	}
}
