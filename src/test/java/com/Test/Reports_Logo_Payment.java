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

import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExcelDataConfig;
import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports_Logo_Payment
{
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Sale - Logo Payment Report");
	
	LoginPage lgpg;
	public String st="NA";
	
	Utility ut=new Utility();

	
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
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Logo_Payment_Path"));
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
		Open_Logo_Payment_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Logo_Payment_Report_Verify_Logo_Payment_Verify_PaymentType_BusinessDay(driver);
		Logo_Payment_Report_Today(driver);
		Logo_Payment_Report_Yesterday(driver);
		Logo_Payment_Report_Last_N_Days(driver);
		Logo_Payment_Report_This_Week(driver);
		Logo_Payment_Report_Last_Week(driver);
		Logo_Payment_Report_Last_7_Days(driver);
		Logo_Payment_Report_This_Month(driver);
		Logo_Payment_Report_Last_Month(driver);
		Logo_Payment_Report_Last_30_Days(driver);
		Logo_Payment_Report_Specific_Date(driver);
		Logo_Payment_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Logo_Payment_Report_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Logo Payment Report Page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"salesReports/logoPayment");

		Thread.sleep(5000);
		//Verify the Logo Payment Report Page loaded or not
		repts.Verify_ReportHomePage("LOGO PAYMENT");
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
		
		//Ascending and Descending Sorting
		cmp.Ascending_And_Descending_Order();
	}
	
	@Test(priority = 4,enabled = false)
	public void Logo_Payment_Report_Verify_Logo_Payment_Verify_PaymentType_BusinessDay(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Payment Type
		repts.Select_Payment_Type("All");
		
		//Enable/Disable Business Day
		repts.Disable_Business_Day();
	
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_LogoPaymentFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No Logo Payment for selected time period is Displayed when Searching Invalid Driver Number");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.FAIL, "No Logo Payment for selected time period is not Displayed when Searching Invalid Driver Number");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		}
		
		Thread.sleep(2000);

		//Select Payment Type
				repts.Select_Payment_Type("Cash");
				
						//Enable/Disable Business Day
						repts.Disable_Business_Day();
					
						//Select Today
						repts.Select_Last_N_Days_TimePeriod("200");
						
						Thread.sleep(1000);
						//Click Apply
						repts.Click_ApplyButton(); 
						
						
						Thread.sleep(5000);
						try
						{
						if(repts.No_LogoPaymentFound_InfoMsg().isDisplayed())
						{
							test.log(LogStatus.INFO, "Logo Payment Reports Not Available for Searched Payment Type - Cash");
							
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						}
						catch(Exception G)
						{
							
							test.log(LogStatus.PASS, "Logo Payment Reports Available for Searched Payment Type - Cash");
							
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
						}
						
						
						//Select Payment Type
						repts.Select_Payment_Type("Credit Card");
						
								//Enable/Disable Business Day
								repts.Disable_Business_Day();
							
								//Select Today
								repts.Select_Last_N_Days_TimePeriod("200");
								
								Thread.sleep(1000);
								//Click Apply
								repts.Click_ApplyButton(); 
								
								
								Thread.sleep(5000);
								try
								{
								if(repts.No_LogoPaymentFound_InfoMsg().isDisplayed())
								{
									test.log(LogStatus.INFO, "Logo Payment Reports Not Available for Searched Payment Type - Credit Card");
									
									ut.FailedCaptureScreenshotAsBASE64(driver, test);
								}
								}
								catch(Exception G)
								{
									
									test.log(LogStatus.PASS, "Logo Payment Reports Available for Searched Payment Type - Credit Card");
									
									ut.PassedCaptureScreenshotAsBASE64(driver, test);
						
								}
		
		//Select Payment Type
		repts.Select_Payment_Type("All");
		
				//Enable/Disable Business Day
				repts.Enable_Business_Day();
			
				//Select Today
				repts.Select_Last_N_Days_TimePeriod("200");
				
				Thread.sleep(1000);
				//Click Apply
				repts.Click_ApplyButton(); 
				
				
				Thread.sleep(5000);
				try
				{
				if(repts.No_LogoPaymentFound_InfoMsg().isDisplayed())
				{
					test.log(LogStatus.INFO, "Logo Payment Reports Not Available for when Enabling Business Day");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception G)
				{
					
					test.log(LogStatus.PASS, "Logo Payment Reports Available for  when Enabling Business Day");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
				}
				
	}
	
	@Test(priority = 4,enabled = false)
	public void Logo_Payment_Report_Today(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Payment Type
		repts.Select_Payment_Type("All");
				
		//Enable/Disable Business Day
		repts.Disable_Business_Day();

		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_LogoPaymentFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Logo Payment Reports Not Available for Today");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Logo Payment Reports Available for Today");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
//			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
			

				Thread.sleep(1000);
			
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
	
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
		
				}
		}
		
		}
	}

	@Test(priority = 4,enabled = false)
	public void Logo_Payment_Report_Yesterday(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Payment Type
		repts.Select_Payment_Type("All");

		//Enable/Disable Business Day
		repts.Disable_Business_Day();

		//Select Today
		repts.Select_Yesterday_TimePeriod();
			
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_LogoPaymentFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Logo Payment Reports Not Available for Yesterday");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Logo Payment Reports Available for Yesterday");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
			
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
			
			}
		}
	
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Logo_Payment_Report_Last_N_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Payment Type
		repts.Select_Payment_Type("All");

		//Enable/Disable Business Day
		repts.Disable_Business_Day();
	
		//Select Today
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 

		Thread.sleep(5000);
		try
		{
		if(repts.No_LogoPaymentFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Logo Payment Reports Not Available for Last 'N' days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Logo Payment Reports Available for Last 'N' days");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
	
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
		
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);

			}
		}
	
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Logo_Payment_Report_This_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Payment Type
		repts.Select_Payment_Type("All");

		//Enable/Disable Business Day
		repts.Disable_Business_Day();

		//Select Today
		repts.Select_This_Week_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 

		Thread.sleep(5000);
		try
		{
		if(repts.No_LogoPaymentFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Logo Payment Reports Not Available for This Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Logo Payment Reports Available for This Week");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
	
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
	
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
	
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
		
			}
		}
			
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Logo_Payment_Report_Last_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Payment Type
		repts.Select_Payment_Type("All");

		//Enable/Disable Business Day
		repts.Disable_Business_Day();

		//Select Today
		repts.Select_Last_Week_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_LogoPaymentFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Logo Payment Reports Not Available for Last Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Logo Payment Reports Available for Last Week");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
		
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
	
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
	
			}
		}
		
		
	
		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Logo_Payment_Report_Last_7_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Payment Type
		repts.Select_Payment_Type("All");

		//Enable/Disable Business Day
		repts.Disable_Business_Day();
	
		//Select Today
		repts.Select_Last_7_Days_TimePeriod();
	
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_LogoPaymentFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Logo Payment Reports Not Available for Last 7 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Logo Payment Reports Available for Last 7 Days");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
	
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
		
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
			
			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Logo_Payment_Report_This_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		//Select Payment Type
		repts.Select_Payment_Type("All");

		//Enable/Disable Business Day
		repts.Disable_Business_Day();

		//Select Today
		repts.Select_This_Month_TimePeriod();
	
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_LogoPaymentFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Logo Payment Reports Not Available for This Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Logo Payment Reports Available for This Month");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
	
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
	
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
	
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);

			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Logo_Payment_Report_Last_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Payment Type
		repts.Select_Payment_Type("All");

		//Enable/Disable Business Day
		repts.Disable_Business_Day();

		//Select Today
		repts.Select_Last_Month_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_LogoPaymentFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Logo Payment Reports Not Available for Last Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Logo Payment Reports Available for Last Month");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
	
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
	
			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Logo_Payment_Report_Last_30_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Payment Type
		repts.Select_Payment_Type("All");

		//Enable/Disable Business Day
		repts.Disable_Business_Day();

		//Select Today
		repts.Select_Last_30_Days_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_LogoPaymentFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Logo Payment Reports Not Available for Last 30 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Logo Payment Reports Available for Last 30 Days");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
	
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();

				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
	
			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Logo_Payment_Report_Specific_Date(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Payment Type
		repts.Select_Payment_Type("All");

		//Enable/Disable Business Day
		repts.Disable_Business_Day();

		//Select Today
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
			
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_LogoPaymentFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Logo Payment Reports Not Available for Specific Date");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Logo Payment Reports Available for Specific Date");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
		
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);

			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Logo_Payment_Report_Date_Range(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		//Select Payment Type
		repts.Select_Payment_Type("All");

		//Enable/Disable Business Day
		repts.Disable_Business_Day();
	
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
			
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_LogoPaymentFound_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.INFO, "Logo Payment Reports Not Available for Date Range");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Logo Payment Reports Available for Date Range");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
	
				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
	
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
				String Check_No=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Trans_Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();

				String PaymentType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				
				test.log(LogStatus.INFO, "Check No : "+Check_No+" Ttansaction Date is : "+Trans_Date+" Amount : "+Amount+" Payment Type for this Check is : "+PaymentType);
	
			}
		}
		
		
	
		}
	}
}
