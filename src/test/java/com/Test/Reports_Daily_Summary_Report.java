package com.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
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

import com.Pages.Availability_RestrictionTimePage;
import com.Pages.ReportsPage;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExcelDataConfig;
import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports_Daily_Summary_Report 
{

public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Daily Summary Report");
	
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
		Thread.sleep(1000);
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
		Open_Daily_Summary_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Daily_Summary_Report_Verify_Daily_Summary_Search(driver);
		Daily_Summary_Report_Today(driver);
		Daily_Summary_Report_Yesterday(driver);
		Daily_Summary_Report_Last_N_Days(driver);
		Daily_Summary_Report_This_Week(driver);
		Daily_Summary_Report_Last_Week(driver);
		Daily_Summary_Report_Last_7_Days(driver);
		Daily_Summary_Report_This_Month(driver);
		Daily_Summary_Report_Last_Month(driver);
		Daily_Summary_Report_Last_30_Days(driver);
		Daily_Summary_Report_Specific_Date(driver);
		Daily_Summary_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Daily_Summary_Report_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Daily page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"dailySummaryReport");

		Thread.sleep(5000);
		//Verify the Categories page loeded or not
		cmp.VerifyMainScreenPageHeader("Daily Summary");
		
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
	public void Daily_Summary_Report_Verify_Daily_Summary_Search(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Daily Summary_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Department
		repts.Select_Department_inReport("All");
		
		//Select the Tax 
		repts.Select_Tax_inReport("All");
		
		Thread.sleep(1000);
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.PASS, "No transaction for selected time period is Displayed when Searching Invalid Driver Number");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.FAIL, "No transaction for selected time period is not Displayed when Searching Invalid Driver Number");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		}
		
		Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
		//Select the Department
		repts.Select_Department_inReport("All");
		
		//Select the Tax 
		repts.Select_Tax_inReport("All");
		
				
				Thread.sleep(1000);
				//Select Today
				repts.Select_Last_Month_TimePeriod();
				
				Thread.sleep(1000);
				//Click Apply
				repts.Click_ApplyButton(); 
				
				
				Thread.sleep(5000);
				try
				{
				if(repts.No_TransactionFound_InfoMessage().isDisplayed())
				{
					test.log(LogStatus.INFO, "Daily Summary Reports Not Available for Selected Time Period");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception G)
				{
					
					test.log(LogStatus.PASS, "Daily Summary Reports Available for Selected Time Period");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

//					Thread.sleep(1000);
//					repts.Department_ReportInputBox().click();
//					
//					List<WebElement> nodeList=driver.findElements(By.xpath("//select-option"));
//					int randomDepartment=ThreadLocalRandom.current().nextInt(2, nodeList.size());
//
//					
//					String Department=driver.findElement(By.xpath("//select-option["+randomDepartment+"]")).getText();
//					
					Thread.sleep(1000);
					//Select Department
					repts.Department_ReportInputBox().click();
					
					Thread.sleep(1000);
					String Department=driver.findElement(By.xpath("//div[2]/select-option")).getText();

					Thread.sleep(1000);
					repts.Department_ReportInputBox().click();

					
					//Select the Department
					repts.Select_Department_inReport(Department);
					
					//Select the Tax 
					repts.Select_Tax_inReport("All");
					

					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_Month_TimePeriod();
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).getText().equalsIgnoreCase(Department))
					{
						test.log(LogStatus.PASS, "Daily Summary Reports is Available for Searched Department");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Daily Summary Reports is Not Available for Searched Department");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

					Thread.sleep(1000);
					//Select the Department
					repts.Select_Department_inReport("All");
					
					
					Thread.sleep(1000);
					//Select Tax
					repts.Tax_ReportInputBox().click();
					
					String Tax=driver.findElement(By.xpath("//div[2]/select-option")).getText();

					Thread.sleep(1000);
					repts.Tax_ReportInputBox().click();

					Thread.sleep(1000);
					//Select Tax 
					repts.Select_Tax_inReport(Tax);

					
					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_Month_TimePeriod();
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).getText().equalsIgnoreCase(Tax))
					{
						test.log(LogStatus.PASS, "Daily Summary Reports is Available for Searched Tax");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Daily Summary Reports is Not Available for Searched Tax");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	}
	
	@Test(priority = 4,enabled = false)
	public void Daily_Summary_Report_Today(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		//Select the Tax 
		repts.Select_Tax_inReport("All");
		
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
			test.log(LogStatus.INFO, "Sale Report for Daily Summary Not Available for Today");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Daily Summary Available for Today");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
	
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Today", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Net_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sale Amount for Daily Summary Report is equal to Sale Recap Report for Today");
	
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				String diff_value=String.valueOf(diff);
				
				test.log(LogStatus.FAIL, "Net Sale Amount for Daily Summary Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
		
			}
			
		
			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Today", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
	

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Daily Summary Report is equal to Sale Recap Report for Today");
		
			
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Daily Summary Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

		
			}
			
		
			
			//Get the Grand Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("Today", 7, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
		
			
			//Get the Grand Sales
			String GrandSale=repts.Grand_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
		
			
			//Check whether the Grand_Sales value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Daily Summary Report is equal to Sale Recap Report for Today");
		
			
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Daily Summary Report is not equal to Sale Recap Report  for Today.The value diff is : "+diff);
		

			}
			
			
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Daily_Summary_Report_Yesterday(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		//Select the Tax 
		repts.Select_Tax_inReport("All");
		
		//Select Today
		repts.Select_Yesterday_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Daily Summary Not Available for Yesterday");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Daily Summary Available for Yesterday");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);

			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Yesterday", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Net_Sale_DailySummaryReport().getText().replace(",", "").replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sale Amount for Daily Summary Report is equal to Sale Recap Report for Yesterday");
		
		
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Net Sale Amount for Daily Summary Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
		

				
			
			}
			
			

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Yesterday", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
	
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Daily Summary Report is equal to Sale Recap Report for Yesterday");
		
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Daily Summary Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
		
			
			}
			
		
			//Get the Grand Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("Yesterday", 7, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
		
			
			//Get the Grand Sales
			String GrandSale=repts.Grand_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
		
			//Check whether the Grand_Sales value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Daily Summary Report is equal to Sale Recap Report for Yesterday");
	
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Daily Summary Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
		
			
			}
			
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Daily_Summary_Report_Last_N_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		//Select the Tax 
		repts.Select_Tax_inReport("All");
		
		//Select Today
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Daily Summary Not Available for Last N days");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Daily Summary Available for Last N days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
		
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last N days", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Net_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
		
			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sale Amount for Daily Summary Report is equal to Sale Recap Report for Last 'N' Days");
		
		
				
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Net Sale Amount for Daily Summary Report is not equal to Sale Recap Report for Last 'N' Days.The value diff is : "+diff);
	
			}
			
		

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last N days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
		

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Daily Summary Report is equal to Sale Recap Report for Last 'N' Days");
			
			
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Daily Summary Report is not equal to Sale Recap Report for Last 'N' Days.The value diff is : "+diff);
		
			}
			
		
			//Get the Grand Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("Last N days", 7, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
		
			
			//Get the Grand Sales
			String GrandSale=repts.Grand_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
		
			
			//Check whether the Grand_Sales value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Daily Summary Report is equal to Sale Recap Report for Last 'N' Days");
		
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Daily Summary Report is not equal to Sale Recap Report for Last 'N' Days.The value diff is : "+diff);
		
			
			}
		
			
			Thread.sleep(3000);

		}
	}

	
	
	@Test(priority = 4,enabled = false)
	public void Daily_Summary_Report_This_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		//Select the Tax 
		repts.Select_Tax_inReport("All");
		
		//Select Today
		repts.Select_This_Week_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Daily Summary Not Available for This Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
			
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Daily Summary Available for This Week");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
	
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("This Week", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Net_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sale Amount for Daily Summary Report is equal to Sale Recap Report for This Week");
		
			
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Net Sale Amount for Daily Summary Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
			
			}
			
		
			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("This Week", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
	
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Daily Summary Report is equal to Sale Recap Report for This Week");
		
	
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Daily Summary Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
			
			
			}
			
		
			
			//Get the Grand Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("This Week", 7, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
		
			
			//Get the Grand Sales
			String GrandSale=repts.Grand_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
		
			//Check whether the Grand_Sales value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Daily Summary Report is equal to Sale Recap Report for This Week");
		

			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Daily Summary Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
		
			
			
			}
		
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Daily_Summary_Report_Last_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		//Select the Tax 
		repts.Select_Tax_inReport("All");
		
		//Select Today
		repts.Select_Last_Week_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Daily Summary Not Available for Last Week");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Daily Summary Available for Last Week");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);

			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last Week", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Net_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
		
			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sale Amount for Daily Summary Report is equal to Sale Recap Report for Last Week");
		

			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Net Sale Amount for Daily Summary Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
	
			

			}
			
		
			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last Week", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
		
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Daily Summary Report is equal to Sale Recap Report for Last Week");
		

			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Daily Summary Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
		
			}
			
		
			//Get the Grand Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("Last Week", 7, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
		
			
			//Get the Grand Sales
			String GrandSale=repts.Grand_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
			//Check whether the Grand_Sales value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Daily Summary Report is equal to Sale Recap Report for Last Week");
		
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Daily Summary Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
		
		
			}
			
			
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Daily_Summary_Report_Last_7_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		//Select the Tax 
		repts.Select_Tax_inReport("All");
		
		//Select Today
		repts.Select_Last_7_Days_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Daily Summary Not Available for Last 7 days");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Daily Summary Available for Last 7 days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
		
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last 7 days", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Net_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
		
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sale Amount for Daily Summary Report is equal to Sale Recap Report for Last 7 days");
		
		
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Net Sale Amount for Daily Summary Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
		
			

			}
			
		

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last 7 days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
		

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Daily Summary Report is equal to Sale Recap Report for Last 7 days");
		
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Daily Summary Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
		
		
			}
			
	
			
			//Get the Grand Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("Last 7 days", 7, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
		
			
			//Get the Grand Sales
			String GrandSale=repts.Grand_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
		
			//Check whether the Grand_Sales value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Daily Summary Report is equal to Sale Recap Report for Last 7 days");
		
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Daily Summary Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
		
			}
			
		
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Daily_Summary_Report_This_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		//Select the Tax 
		repts.Select_Tax_inReport("All");
		
		//Select Today
		repts.Select_This_Month_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Daily Summary Not Available for This month");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
	
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Daily Summary Available for This month");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			

			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("This month", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Net_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sale Amount for Daily Summary Report is equal to Sale Recap Report for This month");
		
			
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Net Sale Amount for Daily Summary Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
		
			
			}
		

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("This month", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Daily Summary Report is equal to Sale Recap Report for This month");
		
		
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Daily Summary Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
		
		
			}
			
		
			
			//Get the Grand Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("This month", 7, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
		
			
			//Get the Grand Sales
			String GrandSale=repts.Grand_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
		
			
			//Check whether the Grand_Sales value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Daily Summary Report is equal to Sale Recap Report for This month");
		
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Daily Summary Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
			
			
		
			}
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Daily_Summary_Report_Last_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		//Select the Tax 
		repts.Select_Tax_inReport("All");
		
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
			test.log(LogStatus.INFO, "Sale Report for Daily Summary Not Available for Last month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Daily Summary Available for Last month");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
	
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last month", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Net_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sale Amount for Daily Summary Report is equal to Sale Recap Report for Last month");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Net Sale Amount for Daily Summary Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
			
			
			}
			
		
			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last month", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
		
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Daily Summary Report is equal to Sale Recap Report for Last month");
		
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Daily Summary Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
		
			}
			
		
			
			//Get the Grand Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("Last month", 7, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
		
			
			//Get the Grand Sales
			String GrandSale=repts.Grand_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
		
			
			//Check whether the Grand_Sales value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Daily Summary Report is equal to Sale Recap Report for Last month");
		
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Daily Summary Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
		
			
			}
			
			
			Thread.sleep(3000);

		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Daily_Summary_Report_Last_30_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		//Select the Tax 
		repts.Select_Tax_inReport("All");
		
		//Select Today
		repts.Select_Last_30_Days_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Daily Summary Not Available for Last 30 days");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Daily Summary Available for Last 30 days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			

			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last 30 days", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Net_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sale Amount for Daily Summary Report is equal to Sale Recap Report for Last 30 days");
			
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Net Sale Amount for Daily Summary Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
		
			
			}
			
		

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last 30 days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
		
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Daily Summary Report is equal to Sale Recap Report for Last 30 days");
		
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Daily Summary Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
		

			}
			
	
			
			//Get the Grand Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("Last 30 days", 7, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
		
			
			//Get the Grand Sales
			String GrandSale=repts.Grand_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
			//Check whether the Grand_Sales value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Daily Summary Report is equal to Sale Recap Report for Last 30 days");
		
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Daily Summary Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
	

			}
			
			
			Thread.sleep(3000);

		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Daily_Summary_Report_Specific_Date(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		//Select the Tax 
		repts.Select_Tax_inReport("All");
		
		//Select Today
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Daily Summary Not Available for Specific Date");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Daily Summary Available for Specific Date");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
	
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Specific Date", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Net_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sale Amount for Daily Summary Report is equal to Sale Recap Report for Specific Date");
		
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Net Sale Amount for Daily Summary Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
			

			}
			
		

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Specific Date", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
		

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Daily Summary Report is equal to Sale Recap Report for Specific Date");
		
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Daily Summary Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
		
			
			}
				
			//Get the Grand Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("Specific Date", 7, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
		
			
			//Get the Grand Sales
			String GrandSale=repts.Grand_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
		
			//Check whether the Grand_Sales value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Daily Summary Report is equal to Sale Recap Report for Specific Date");
		
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Daily Summary Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
			
			
			}
			
		
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Daily_Summary_Report_Date_Range(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		//Select the Tax 
		repts.Select_Tax_inReport("All");
		
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Daily Summary Not Available for Date Range");
		
		ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Daily Summary Available for Date Range");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);

			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Date Range", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Net_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sale Amount for Daily Summary Report is equal to Sale Recap Report for Date Range");
	
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Net Sale Amount for Daily Summary Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
			

			}
			
		

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Date Range", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
		
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Daily Summary Report is equal to Sale Recap Report for Date Range");
	
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Daily Summary Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
	

			}
			
		
			
			//Get the Grand Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("Date Range", 7, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
		
			
			//Get the Grand Sales
			String GrandSale=repts.Grand_Sale_DailySummaryReport().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
		
			//Check whether the Grand_Sales value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Daily Summary Report is equal to Sale Recap Report for Date Range");
		
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Daily Summary Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);

			}
			
	
			
			Thread.sleep(3000);

		}
	}
	

}
