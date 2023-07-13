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

public class Reports_Customer_Preference_Report 
{
	//WebDriverManager.chromeDriver().setup();
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Customer Preference Report");
	
	
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
		Open_Customer_Preference_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Customer_Preference_Report_Today(driver);
		Customer_Preference_Report_Yesterday(driver);
		Customer_Preference_Report_Last_N_Days(driver);
		Customer_Preference_Report_This_Week(driver);
		Customer_Preference_Report_Last_Week(driver);
		Customer_Preference_Report_Last_7_Days(driver);
		Customer_Preference_Report_This_Month(driver);
		Customer_Preference_Report_Last_Month(driver);
		Customer_Preference_Report_Last_30_Days(driver);
		Customer_Preference_Report_Specific_Date(driver);
		Customer_Preference_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Customer_Preference_Report_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Customer Preference Summarys report page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"customerPreference");

		Thread.sleep(5000);
		try {
			if(driver.findElement(By.xpath("//h3[contains(.,'Customer Preference')]")).isDisplayed()) {
				test.log(LogStatus.PASS, "Customer Preference report page is loaded successfully");
			}
		}catch(Exception E) {
			test.log(LogStatus.FAIL, "Customer Preference report page is not loaded");
		}
		
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
		//Click the employee label
		driver.findElement(By.xpath("//span[contains(.,'Employee')]/../input")).click();
		Thread.sleep(500);	
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
				
		Thread.sleep(500);
		//Click the Include Settings label
		driver.findElement(By.xpath("//span[contains(.,'Include Settings')]/../input")).click();
		Thread.sleep(500);
		//Select the All option
		try {
			if(driver.findElement(By.xpath("//div[contains(.,'Select All')]/mat-checkbox[contains(@class,'mat-checkbox-checked')]")).isDisplayed())
			{	
			}
		}catch(Exception e) {
			driver.findElement(By.xpath("//div[contains(.,'Select All')]/mat-checkbox")).click();
		}
		
		driver.findElement(By.xpath("//span[contains(.,'Include Settings')]/../input")).click();
		

		Thread.sleep(500);
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Customer_Preference_Report_Today(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		SelectTheCat(driver);

		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No transaction for selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Customer Preference Report Not Available for Today");
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Customer Preference Report Available for Today");
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Sold quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[2]")).getText());
			test.log(LogStatus.INFO, "Void quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[3]")).getText());
			test.log(LogStatus.INFO, "Total quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[4]")).getText());
			test.log(LogStatus.INFO, "Group% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[5]")).getText());
			test.log(LogStatus.INFO, "Total% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[6]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[7]")).getText());
			test.log(LogStatus.INFO, "Total amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[8]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[9]")).getText());
			test.log(LogStatus.INFO, "Group% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[10]")).getText());
			test.log(LogStatus.INFO, "Total% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[11]")).getText());
			Thread.sleep(3000);

		}
	}


	@Test(priority = 4,enabled = false)
	public void Customer_Preference_Report_Yesterday(WebDriver driver) throws Exception
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
				test.log(LogStatus.INFO, "Customer Preference Report Not Available for Yesterday");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Customer Preference Report Available for Yesterday");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Sold quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[2]")).getText());
			test.log(LogStatus.INFO, "Void quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[3]")).getText());
			test.log(LogStatus.INFO, "Total quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[4]")).getText());
			test.log(LogStatus.INFO, "Group% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[5]")).getText());
			test.log(LogStatus.INFO, "Total% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[6]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[7]")).getText());
			test.log(LogStatus.INFO, "Total amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[8]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[9]")).getText());
			test.log(LogStatus.INFO, "Group% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[10]")).getText());
			test.log(LogStatus.INFO, "Total% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[11]")).getText());
			Thread.sleep(3000);
		}
	}


	@Test(priority = 4,enabled = false)
	public void Customer_Preference_Report_Last_N_Days(WebDriver driver) throws Exception
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
				test.log(LogStatus.INFO, "Customer Preference Report Not Available for Last N days");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Customer Preference Report Available for Last N days");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Sold quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[2]")).getText());
			test.log(LogStatus.INFO, "Void quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[3]")).getText());
			test.log(LogStatus.INFO, "Total quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[4]")).getText());
			test.log(LogStatus.INFO, "Group% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[5]")).getText());
			test.log(LogStatus.INFO, "Total% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[6]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[7]")).getText());
			test.log(LogStatus.INFO, "Total amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[8]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[9]")).getText());
			test.log(LogStatus.INFO, "Group% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[10]")).getText());
			test.log(LogStatus.INFO, "Total% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[11]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4,enabled = false)
	public void Customer_Preference_Report_This_Week(WebDriver driver) throws Exception
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
				test.log(LogStatus.INFO, "Customer Preference Report Not Available for This Week");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Customer Preference Report Available for This Week");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Sold quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[2]")).getText());
			test.log(LogStatus.INFO, "Void quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[3]")).getText());
			test.log(LogStatus.INFO, "Total quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[4]")).getText());
			test.log(LogStatus.INFO, "Group% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[5]")).getText());
			test.log(LogStatus.INFO, "Total% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[6]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[7]")).getText());
			test.log(LogStatus.INFO, "Total amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[8]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[9]")).getText());
			test.log(LogStatus.INFO, "Group% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[10]")).getText());
			test.log(LogStatus.INFO, "Total% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[11]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4,enabled = false)
	public void Customer_Preference_Report_Last_Week(WebDriver driver) throws Exception
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
				test.log(LogStatus.INFO, "Customer Preference Report Not Available for Last Week");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Customer Preference Report Available for Last Week");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Sold quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[2]")).getText());
			test.log(LogStatus.INFO, "Void quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[3]")).getText());
			test.log(LogStatus.INFO, "Total quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[4]")).getText());
			test.log(LogStatus.INFO, "Group% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[5]")).getText());
			test.log(LogStatus.INFO, "Total% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[6]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[7]")).getText());
			test.log(LogStatus.INFO, "Total amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[8]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[9]")).getText());
			test.log(LogStatus.INFO, "Group% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[10]")).getText());
			test.log(LogStatus.INFO, "Total% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[11]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4,enabled = false)
	public void Customer_Preference_Report_Last_7_Days(WebDriver driver) throws Exception
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
				test.log(LogStatus.INFO, "Customer Preference Report Not Available for Last 7 days");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Customer Preference Report Available for Last 7 days");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Sold quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[2]")).getText());
			test.log(LogStatus.INFO, "Void quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[3]")).getText());
			test.log(LogStatus.INFO, "Total quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[4]")).getText());
			test.log(LogStatus.INFO, "Group% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[5]")).getText());
			test.log(LogStatus.INFO, "Total% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[6]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[7]")).getText());
			test.log(LogStatus.INFO, "Total amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[8]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[9]")).getText());
			test.log(LogStatus.INFO, "Group% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[10]")).getText());
			test.log(LogStatus.INFO, "Total% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[11]")).getText());
			Thread.sleep(3000);
		}
	}


	@Test(priority = 4,enabled = false)
	public void Customer_Preference_Report_This_Month(WebDriver driver) throws Exception
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
				test.log(LogStatus.INFO, "Customer Preference Report Not Available for This month");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Customer Preference Report Available for This month");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Sold quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[2]")).getText());
			test.log(LogStatus.INFO, "Void quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[3]")).getText());
			test.log(LogStatus.INFO, "Total quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[4]")).getText());
			test.log(LogStatus.INFO, "Group% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[5]")).getText());
			test.log(LogStatus.INFO, "Total% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[6]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[7]")).getText());
			test.log(LogStatus.INFO, "Total amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[8]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[9]")).getText());
			test.log(LogStatus.INFO, "Group% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[10]")).getText());
			test.log(LogStatus.INFO, "Total% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[11]")).getText());
			Thread.sleep(3000);
		}
	}


	@Test(priority = 4,enabled = false)
	public void Customer_Preference_Report_Last_Month(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Last month
		repts.Select_Last_Month_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'No transaction for selected time period')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Customer Preference Report Not Available for Last month");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Customer Preference Report Available for Last month");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Sold quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[2]")).getText());
			test.log(LogStatus.INFO, "Void quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[3]")).getText());
			test.log(LogStatus.INFO, "Total quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[4]")).getText());
			test.log(LogStatus.INFO, "Group% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[5]")).getText());
			test.log(LogStatus.INFO, "Total% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[6]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[7]")).getText());
			test.log(LogStatus.INFO, "Total amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[8]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[9]")).getText());
			test.log(LogStatus.INFO, "Group% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[10]")).getText());
			test.log(LogStatus.INFO, "Total% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[11]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4,enabled = false)
	public void Customer_Preference_Report_Last_30_Days(WebDriver driver) throws Exception
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
				test.log(LogStatus.INFO, "Customer Preference Report Not Available for Last 30 days");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Customer Preference Report Available for Last 30 days");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Sold quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[2]")).getText());
			test.log(LogStatus.INFO, "Void quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[3]")).getText());
			test.log(LogStatus.INFO, "Total quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[4]")).getText());
			test.log(LogStatus.INFO, "Group% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[5]")).getText());
			test.log(LogStatus.INFO, "Total% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[6]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[7]")).getText());
			test.log(LogStatus.INFO, "Total amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[8]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[9]")).getText());
			test.log(LogStatus.INFO, "Group% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[10]")).getText());
			test.log(LogStatus.INFO, "Total% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[11]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4,enabled = false)
	public void Customer_Preference_Report_Specific_Date(WebDriver driver) throws Exception
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
				test.log(LogStatus.INFO, "Customer Preference Report Not Available for Specific Date");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Customer Preference Report Available for Specific Date");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Sold quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[2]")).getText());
			test.log(LogStatus.INFO, "Void quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[3]")).getText());
			test.log(LogStatus.INFO, "Total quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[4]")).getText());
			test.log(LogStatus.INFO, "Group% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[5]")).getText());
			test.log(LogStatus.INFO, "Total% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[6]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[7]")).getText());
			test.log(LogStatus.INFO, "Total amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[8]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[9]")).getText());
			test.log(LogStatus.INFO, "Group% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[10]")).getText());
			test.log(LogStatus.INFO, "Total% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[11]")).getText());
			Thread.sleep(3000);
		}
	}

	@Test(priority = 4,enabled = false)
	public void Customer_Preference_Report_Date_Range(WebDriver driver) throws Exception
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
				test.log(LogStatus.INFO, "Customer Preference Report Not Available for Date Range");
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Customer Preference Report Available for Date Range");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			test.log(LogStatus.INFO, "Sold quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[2]")).getText());
			test.log(LogStatus.INFO, "Void quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[3]")).getText());
			test.log(LogStatus.INFO, "Total quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[4]")).getText());
			test.log(LogStatus.INFO, "Group% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[5]")).getText());
			test.log(LogStatus.INFO, "Total% quantity : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[6]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[7]")).getText());
			test.log(LogStatus.INFO, "Total amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[8]")).getText());
			test.log(LogStatus.INFO, "Sold amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[9]")).getText());
			test.log(LogStatus.INFO, "Group% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[10]")).getText());
			test.log(LogStatus.INFO, "Total% amount : "+driver.findElement(By.xpath("//td[contains(.,'Grand Total')]/../td[11]")).getText());
			Thread.sleep(3000);
		}
	}

}
