package com.Test;

import java.util.concurrent.TimeUnit;

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

import com.Pages.ReportsPage;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports_HA_Statement 
{
	//WebDriverManager.chromeDriver().setup();
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - HA Statement");
	
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
		//WebDriverManager.chromedriver().setup();
		//Open the Chrome window
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
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
		Open_HA_Statement_Page(driver);
//		RefreshAndPaginination(driver);
		HA_Statement_Today(driver);
		HA_Statement_Yesterday(driver);
		HA_Statement_Last_N_Days(driver);
		HA_Statement_This_Week(driver);
		HA_Statement_Last_Week(driver);
		HA_Statement_Last_7_Days(driver);
		HA_Statement_This_Month(driver);
		HA_Statement_Last_Month(driver);
		HA_Statement_Last_30_Days(driver);
		HA_Statement_Specific_Date(driver);
		HA_Statement_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_HA_Statement_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Sale Summarys report page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"houseAccount/haStatement");

		Thread.sleep(5000);
		//Verify the HA Statement page loeded or not
		repts.Verify_ReportHomePage("HA STATEMENT");
		
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
	public void SelectTheCat(WebDriver driver) throws Exception
	{

		Thread.sleep(5000);	
		//Click the customer label
		driver.findElement(By.xpath("//span[contains(.,'Customer')]/../input")).click();
		Thread.sleep(500);	
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
				

	}
	
	@Test(priority = 4,enabled = false)
	public void HA_Statement_Today(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		SelectTheCat(driver);
		
		//Select Today
		//repts.Select_Last_N_Days_TimePeriod("10");
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No transaction for selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "HA Statement Not Available for Today");
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "HA Statement Available for Today");
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "HA Statement is available and the date is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[1]/span")).getText() +" and the check number is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[2]/span")).getText());
			Thread.sleep(3000);

		}
	}


	@Test(priority = 4,enabled = false)
	public void HA_Statement_Yesterday(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Yesterday
		repts.Select_Yesterday_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No transaction for selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "HA Statement Not Available for Yesterday");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "HA Statement Available for Yesterday");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "HA Statement is available and the date is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[1]/span")).getText() +" and the check number is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[2]/span")).getText());
			Thread.sleep(3000);

		}
	}


	@Test(priority = 4,enabled = false)
	public void HA_Statement_Last_N_Days(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Last N days
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No transaction for selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "HA Statement Not Available for Last N days");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "HA Statement Available for Last N days");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "HA Statement is available and the date is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[1]/span")).getText() +" and the check number is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[2]/span")).getText());
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void HA_Statement_This_Week(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select This Week
		repts.Select_This_Week_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No transaction for selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "HA Statement Not Available for This Week");
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "HA Statement Available for This Week");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "HA Statement is available and the date is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[1]/span")).getText() +" and the check number is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[2]/span")).getText());
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void HA_Statement_Last_Week(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Last Week
		repts.Select_Last_Week_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No transaction for selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "HA Statement Not Available for Last Week");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "HA Statement Available for Last Week");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "HA Statement is available and the date is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[1]/span")).getText() +" and the check number is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[2]/span")).getText());
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void HA_Statement_Last_7_Days(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Last 7 days
		repts.Select_Last_7_Days_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No transaction for selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "HA Statement Not Available for Last 7 days");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "HA Statement Available for Last 7 days");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "HA Statement is available and the date is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[1]/span")).getText() +" and the check number is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[2]/span")).getText());
			Thread.sleep(3000);

		}
	}


	@Test(priority = 4,enabled = false)
	public void HA_Statement_This_Month(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select This month
		repts.Select_This_Month_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No transaction for selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "HA Statement Not Available for This month");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "HA Statement Available for This month");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "HA Statement is available and the date is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[1]/span")).getText() +" and the check number is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[2]/span")).getText());
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void HA_Statement_Last_Month(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select This month
		repts.Select_Last_Month_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No transaction for selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "HA Statement Not Available for Last month");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "HA Statement Available for Last month");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "HA Statement is available and the date is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[1]/span")).getText() +" and the check number is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[2]/span")).getText());
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void HA_Statement_Last_30_Days(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Last 30 days
		repts.Select_Last_30_Days_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No transaction for selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "HA Statement Not Available for Last 30 days");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "HA Statement Available for Last 30 days");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "HA Statement is available and the date is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[1]/span")).getText() +" and the check number is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[2]/span")).getText());
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void HA_Statement_Specific_Date(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Specific Date
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No transaction for selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "HA Statement Not Available for Specific Date");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "HA Statement Available for Specific Date");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "HA Statement is available and the date is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[1]/span")).getText() +" and the check number is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[2]/span")).getText());
			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void HA_Statement_Date_Range(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Date Range
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No transaction for selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "HA Statement Not Available for Date Range");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "HA Statement Available for Date Range");

			Thread.sleep(2000);
			test.log(LogStatus.INFO, "HA Statement is available and the date is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[1]/span")).getText() +" and the check number is : "+driver.findElement(By.xpath("//div[2]/div/data-grid-row/div/div[2]/span")).getText());
			Thread.sleep(3000);

		}
	}

}