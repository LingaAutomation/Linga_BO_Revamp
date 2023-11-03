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

public class Enterprise_Reports_Loyalty_Report 
{

	public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise Reports - Loyalty Report");
	
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
//		System.setProperty("webdriver.chrome.driver","./Automation Driver/chromedriver.exe");
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
		Open_Enterprise_Loyalty_Report_Page(driver);
//		RefreshAndPaginination(driver);
//		Verify_Enterprise_Loyalty_Report_Search_by_CustomerName(driver);
		Enterprise_Loyalty_Report_Today(driver);
		Enterprise_Loyalty_Report_Yesterday(driver);
		Enterprise_Loyalty_Report_Last_N_Days(driver);
		Enterprise_Loyalty_Report_This_Week(driver);
		Enterprise_Loyalty_Report_Last_Week(driver);
		Enterprise_Loyalty_Report_Last_7_Days(driver);
		Enterprise_Loyalty_Report_This_Month(driver);
		Enterprise_Loyalty_Report_Last_Month(driver);
		Enterprise_Loyalty_Report_Last_30_Days(driver);
		Enterprise_Loyalty_Report_Specific_Date(driver);
		Enterprise_Loyalty_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Enterprise_Loyalty_Report_Page(SelfHealingDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Menu Item sales report page
		driver.get(Utility.getProperty("baseURL")+"enterprise/enterpriseReports/loyaltyReport");

		Thread.sleep(5000);
		//Verify the Loyalty report page loaded or not
		cmp.VerifyMainScreenPageHeader("Loyalty");
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
	}

	
	@Test(priority = 4,enabled = false)
	public void Verify_Enterprise_Loyalty_Report_Search_by_CustomerName(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Customer
		repts.Customer_TypeInputBx().clear();
		//Enter the Customer
		repts.Customer_TypeInputBx().sendKeys("");
		
		//Select Today
		repts.Select_Last_Month_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Loyalty Report Not Available");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Loyalty Report Available");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			//Do pagination to Last
			//repts.Do_Pagination();
			
			Thread.sleep(3000);
			//Get Rows
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

			int CusListSize=rowList.size();
			
			int randomCustomer=ThreadLocalRandom.current().nextInt(1, CusListSize);
//			
			
			String CustomerName=driver.findElement(By.xpath("//table/tbody/tr["+randomCustomer+"]/td[1]")).getText();
			
			
			//Select Customer
			repts.Customer_TypeInputBx().clear();
			//Enter the Customer
			repts.Customer_TypeInputBx().sendKeys(CustomerName);
			
			//Click the Apply button
			repts.Click_ApplyButton();
			
			Thread.sleep(3000);
			try
			{
				if(repts.No_TransactionFound_InfoMessage().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Loyalty Report Not fetched for Searched Customer Name : "+CustomerName);
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception f)
			{
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				Thread.sleep(1000);
				test.log(LogStatus.PASS, "Loaylty Report fetched for the Searched Customer Name : "+CustomerName);
					test.log(LogStatus.INFO, "Searched Customer is : "+CustomerName+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr[1]/td[7]")).getText());
			
			}
			

			

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Loyalty_Report_Today(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Customer
		repts.Customer_TypeInputBx().clear();
		//Enter the Customer
		repts.Customer_TypeInputBx().sendKeys("");
		
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
				test.log(LogStatus.INFO, "Loyalty Report Not Available for Today");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Loyalty Report Available for Today");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			//Do pagination to Last
			//repts.Do_Pagination();
			
			Thread.sleep(3000);
			//Get Rows
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
			
				}
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Loyalty_Report_Yesterday(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Customer
		repts.Customer_TypeInputBx().clear();
		//Enter the Customer
		repts.Customer_TypeInputBx().sendKeys("");
		
				
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
				test.log(LogStatus.INFO, "Loyalty Report Not Available for Yesterday");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Loyalty Report Available for Yesterday");

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
			//Get Rows
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
			
				}
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Loyalty_Report_Last_N_Days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Customer
		repts.Customer_TypeInputBx().clear();
		//Enter the Customer
		repts.Customer_TypeInputBx().sendKeys("");
		

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
				test.log(LogStatus.INFO, "Loyalty Report Not Available for Last N Days");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Loyalty Report Available for Last N days");

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
			//Get Rows
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
			
				}
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Loyalty_Report_This_Week(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Customer
		repts.Customer_TypeInputBx().clear();
		//Enter the Customer
		repts.Customer_TypeInputBx().sendKeys("");
		

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
				test.log(LogStatus.INFO, "Loyalty Report Not Available for This Week");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Loyalty Report Available for This Week");

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
			//Get Rows
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
			
				}
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Loyalty_Report_Last_Week(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Customer
		repts.Customer_TypeInputBx().clear();
		//Enter the Customer
		repts.Customer_TypeInputBx().sendKeys("");
		

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
				test.log(LogStatus.INFO, "Loyalty Report Not Available for Last Week");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Loyalty Report Available for Last Week");

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
			//Get Rows
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
			
				}
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Loyalty_Report_Last_7_Days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Customer
		repts.Customer_TypeInputBx().clear();
		//Enter the Customer
		repts.Customer_TypeInputBx().sendKeys("");
		

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
				test.log(LogStatus.INFO, "Loyalty Report Not Available for Last 7 days");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Loyalty Report Available for Last 7 days");

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
			//Get Rows
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
			
				}
			}
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Enterprise_Loyalty_Report_This_Month(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Customer
		repts.Customer_TypeInputBx().clear();
		//Enter the Customer
		repts.Customer_TypeInputBx().sendKeys("");
		

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
				test.log(LogStatus.INFO, "Loyalty Report Not Available for This month");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Loyalty Report Available for This month");

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
			//Get Rows
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
			
				}
			}
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Loyalty_Report_Last_Month(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Customer
		repts.Customer_TypeInputBx().clear();
		//Enter the Customer
		repts.Customer_TypeInputBx().sendKeys("");
		

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
				test.log(LogStatus.INFO, "Loyalty Report Not Available for Last month");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Loyalty Report Available for Last month");

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
			//Get Rows
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
			
				}
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Loyalty_Report_Last_30_Days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Customer
		repts.Customer_TypeInputBx().clear();
		//Enter the Customer
		repts.Customer_TypeInputBx().sendKeys("");
		

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
				test.log(LogStatus.INFO, "Loyalty Report Not Available for Last 30 days");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Loyalty Report Available for Last 30 days");

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
			//Get Rows
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

			
			
int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
			
				}
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Enterprise_Loyalty_Report_Specific_Date(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){ Thread.sleep(1000);driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Customer
		repts.Customer_TypeInputBx().clear();
		//Enter the Customer
		repts.Customer_TypeInputBx().sendKeys("");
		
		Thread.sleep(2000);
		//Select Specific Date
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));

		Thread.sleep(2000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Loyalty Report Not Available for Specific Date");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Loyalty Report Available for Specific Date");

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
			//Get Rows
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

			
			
int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
			
				}
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Loyalty_Report_Date_Range(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){ Thread.sleep(1000);driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Customer
		repts.Customer_TypeInputBx().clear();
		//Enter the Customer
		repts.Customer_TypeInputBx().sendKeys("");
				

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
				test.log(LogStatus.INFO, "Loyalty Report Not Available for Date Range");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Loyalty Report Available for Date Range");

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
			//Get Rows
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

			int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Customer Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Last Redemption Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Last Accumulation Date is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Total Loyalty Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Total Redeemed Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText()+" Current Available Points : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[7]")).getText());
			
				}
			}
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}	
	}
}
