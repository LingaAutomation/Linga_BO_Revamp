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
import com.epam.healenium.SelfHealingDriver;
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

public class Reports_Tax_Report 
{

public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Tax Report");
	
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
		Open_Tax_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Tax_Report_Verify_Tax_Search(driver);
		Tax_Report_Today(driver);
		Tax_Report_Yesterday(driver);
		Tax_Report_Last_N_Days(driver);
		Tax_Report_This_Week(driver);
		Tax_Report_Last_Week(driver);
		Tax_Report_Last_7_Days(driver);
		Tax_Report_This_Month(driver);
		Tax_Report_Last_Month(driver);
		Tax_Report_Last_30_Days(driver);
		Tax_Report_Specific_Date(driver);
		Tax_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Tax_Report_Page(SelfHealingDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Daily page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"taxReport");

		Thread.sleep(5000);
		//Verify the Categories page loeded or not
		cmp.VerifyMainScreenPageHeader("Tax");
		
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
	public void Tax_Report_Verify_Tax_Search(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Department
		repts.Enable_Tax_Per_ServiceType();
		
	
		Thread.sleep(1000);
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_Tax_FoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.PASS, "No transaction for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.FAIL, "No transaction for selected time period is not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		}
		
		Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
		//Select the Department
		repts.Enable_Tax_Per_ServiceType();
		
		
		
		
				
				Thread.sleep(1000);
				//Select Today
				repts.Select_Last_Month_TimePeriod();
				
				Thread.sleep(1000);
				//Click Apply
				repts.Click_ApplyButton(); 
				
				
				Thread.sleep(5000);
				try
				{
				if(repts.No_Tax_FoundInfoMessage().isDisplayed())
				{
					test.log(LogStatus.INFO, "Tax Reports Not Available for Selected Time Period when Tax Per Service Type Enabled");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception G)
				{
					
					test.log(LogStatus.PASS, "Tax Reports Available for Selected Time Period when Tax Per Service Type Enabled");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			
					String QSR_TaxTotal=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[2]/span")).getText();
					double QSR_Tax_Total=Double.parseDouble(QSR_TaxTotal);
					
					String BarTab_TaxTotal=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[3]/span")).getText();
					double BarTab_Tax_Total=Double.parseDouble(BarTab_TaxTotal);

					String DineIn_TaxTotal=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[4]/span")).getText();
					double DineIn_Tax_Total=Double.parseDouble(DineIn_TaxTotal);

					String ToGo_TaxTotal=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[5]/span")).getText();
					double ToGo_Tax_Total=Double.parseDouble(ToGo_TaxTotal);

					String Delivery_TaxTotal=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[6]/span")).getText();
					double Delivery_Tax_Total=Double.parseDouble(Delivery_TaxTotal);

					String ForHere_TaxTotal=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[7]/span")).getText();
					double ForHere_Tax_Total=Double.parseDouble(ForHere_TaxTotal);

					String Web_TaxTotal=driver.findElement(By.xpath("//div[contains(.,'Total')]/../div[8]/span")).getText();
					double Web_Tax_Total=Double.parseDouble(Web_TaxTotal);

//					test.log(LogStatus.INFO, "Tax Total for "+"QSR : "+QSR_TaxTotal+" BarTab : "+BarTab_TaxTotal+" Dine In : "+DineIn_TaxTotal+" ToGo : "+ToGo_TaxTotal+" Delivery : "+Delivery_TaxTotal+" For Here : "+ForHere_TaxTotal+" Web Order : "+Web_TaxTotal);
					double Actual_TaxTotal=QSR_Tax_Total+BarTab_Tax_Total+DineIn_Tax_Total+ToGo_Tax_Total+Delivery_Tax_Total+ForHere_Tax_Total+Web_Tax_Total;
					
					
					
					//Get the Tax from Sale Recap Report
					String Expeccted_Tx=excel.getData("Last month", 3, 1).toString().replace(",", "");
					double Expected_Tax=Double.parseDouble(Expeccted_Tx);
				
					//Check whether the Tax value is Equal or not
					if(Expected_Tax==Actual_TaxTotal)
					{
						test.log(LogStatus.PASS, "Tax for Tax Report is equal to Sale Recap Report with Tax Per Service Type Enabled");
				
					}
					else
					{
						double diff=Expected_Tax-Actual_TaxTotal;
						test.log(LogStatus.FAIL, "Tax for Tax Report is not equal to Sale Recap Report  with Tax Per Service Type Enabled.The value diff is : "+diff);
				
					}
					
				}
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	}
	
	@Test(priority = 4,enabled = false)
	public void Tax_Report_Today(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		
		
		
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_Tax_FoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Tax Not Available for Today");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Tax Available for Today");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
	
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

		
			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Today", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
	

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Tax Report is equal to Sale Recap Report for Today");
		
			
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Tax Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

		
			}
			
			//Get the Tax Exempt from Sale Recap Report
			String Expeccted_TxExempt=excel.getData("Today", 8, 1).toString().replace(",", "");
			double Expected_TaxExempt=Double.parseDouble(Expeccted_TxExempt);
			
			Thread.sleep(3000);
			//Get Tax Exempt
			String TaxExempt=repts.Tax_Exempt_TaxReport().getText().replace(",", "");
			double Actual_TaxExempt=Double.parseDouble(TaxExempt);

			
			//Check whether the Tax Exempt value is Equal or not
			if(Expected_TaxExempt==Actual_TaxExempt)
			{
				test.log(LogStatus.PASS, "Tax Exempt for Tax Report is equal to Sale Recap Report for Today");
	
			}
			else
			{
				double diff=Expected_TaxExempt-Actual_TaxExempt;
				String diff_value=String.valueOf(diff);
				
				test.log(LogStatus.FAIL, "Tax Exempt for Tax Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
		
			}
			
			
			//Get the Rounding Off from Sale Recap Report
			String Expected_RoundOf=excel.getData("Today", 12, 1).toString().replace(",", "");
			double Expected_RoundingOff=Double.parseDouble(Expected_RoundOf);
		
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_TaxReport().getText().replace(",", "");
			double Actual_RoundOff=Double.parseDouble(RoundOff);
			
		
			
			//Check whether the Rounding Off value is Equal or not
			if(Expected_RoundingOff==Actual_RoundOff)
			{
				test.log(LogStatus.PASS, "Rounding Off for Tax Report is equal to Sale Recap Report for Today");
		
			
			}
			else
			{
				double diff=Expected_RoundingOff-Actual_RoundOff;
				test.log(LogStatus.FAIL, "Rounding Off for Tax Report is not equal to Sale Recap Report  for Today.The value diff is : "+diff);
		

			}
			
			
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Tax_Report_Yesterday(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		
		
		
		//Select Today
		repts.Select_Yesterday_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_Tax_FoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Tax Not Available for Yesterday");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Tax Available for Yesterday");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);

			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

			

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Yesterday", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
	
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Tax Report is equal to Sale Recap Report for Yesterday");
		
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Tax Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
		
			
			}
			
			//Get the Tax Exempt from Sale Recap Report
			String Expeccted_TxExempt=excel.getData("Yesterday", 8, 1).toString().replace(",", "");
			double Expected_TaxExempt=Double.parseDouble(Expeccted_TxExempt);
			
			

			Thread.sleep(3000);
			//Get Tax Exempt
			String TaxExempt=repts.Tax_Exempt_TaxReport().getText().replace(",", "").replace(",", "");
			double Actual_TaxExempt=Double.parseDouble(TaxExempt);
			
			
			//Check whether the Tax Exempt value is Equal or not
			if(Expected_TaxExempt==Actual_TaxExempt)
			{
				test.log(LogStatus.PASS, "Tax Exempt for Tax Report is equal to Sale Recap Report for Yesterday");
		
		
			}
			else
			{
				double diff=Expected_TaxExempt-Actual_TaxExempt;
				test.log(LogStatus.FAIL, "Tax Exempt for Tax Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
		

				
			
			}
			
			//Get the Rounding Off from Sale Recap Report
			String Expected_RoundOf=excel.getData("Yesterday", 12, 1).toString().replace(",", "");
			double Expected_RoundingOff=Double.parseDouble(Expected_RoundOf);
		
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_TaxReport().getText().replace(",", "");
			double Actual_RoundOff=Double.parseDouble(RoundOff);
			
		
			//Check whether the Rounding Off value is Equal or not
			if(Expected_RoundingOff==Actual_RoundOff)
			{
				test.log(LogStatus.PASS, "Rounding Off for Tax Report is equal to Sale Recap Report for Yesterday");
	
			}
			else
			{
				double diff=Expected_RoundingOff-Actual_RoundOff;
				test.log(LogStatus.FAIL, "Rounding Off for Tax Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
		
			
			}
			
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Tax_Report_Last_N_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		
		
		
		//Select Today
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_Tax_FoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Tax Not Available for Last N days");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Tax Available for Last N days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
		
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last N days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
		

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Tax Report is equal to Sale Recap Report for Last 'N' Days");
			
			
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Tax Report is not equal to Sale Recap Report for Last 'N' Days.The value diff is : "+diff);
		
			}
			//Get the Tax Exempt from Sale Recap Report
			String Expeccted_TxExempt=excel.getData("Last N days", 8, 1).toString().replace(",", "");
			double Expected_TaxExempt=Double.parseDouble(Expeccted_TxExempt);
			
			

			Thread.sleep(3000);
			//Get Tax Exempt
			String TaxExempt=repts.Tax_Exempt_TaxReport().getText().replace(",", "");
			double Actual_TaxExempt=Double.parseDouble(TaxExempt);
			
		
			
			//Check whether the Tax Exempt value is Equal or not
			if(Expected_TaxExempt==Actual_TaxExempt)
			{
				test.log(LogStatus.PASS, "Tax Exempt for Tax Report is equal to Sale Recap Report for Last 'N' Days");
		
		
				
			}
			else
			{
				double diff=Expected_TaxExempt-Actual_TaxExempt;
				test.log(LogStatus.FAIL, "Tax Exempt for Tax Report is not equal to Sale Recap Report for Last 'N' Days.The value diff is : "+diff);
	
			}
			

		
			//Get the Rounding Off from Sale Recap Report
			String Expected_RoundOf=excel.getData("Last N days", 12, 1).toString().replace(",", "");
			double Expected_RoundingOff=Double.parseDouble(Expected_RoundOf);
		
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_TaxReport().getText().replace(",", "");
			double Actual_RoundOff=Double.parseDouble(RoundOff);
			
		
			
			//Check whether the Rounding Off value is Equal or not
			if(Expected_RoundingOff==Actual_RoundOff)
			{
				test.log(LogStatus.PASS, "Rounding Off for Tax Report is equal to Sale Recap Report for Last 'N' Days");
		
			}
			else
			{
				double diff=Expected_RoundingOff-Actual_RoundOff;
				test.log(LogStatus.FAIL, "Rounding Off for Tax Report is not equal to Sale Recap Report for Last 'N' Days.The value diff is : "+diff);
		
			
			}
		
			
			Thread.sleep(3000);

		}
	}

	
	
	@Test(priority = 4,enabled = false)
	public void Tax_Report_This_Week(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		
		
		
		//Select Today
		repts.Select_This_Week_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_Tax_FoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Tax Not Available for This Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
			
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Tax Available for This Week");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
	
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
					
			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("This Week", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
	
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Tax Report is equal to Sale Recap Report for This Week");
		
	
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Tax Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
			
			
			}
			
			//Get the Tax Exempt from Sale Recap Report
			String Expeccted_TxExempt=excel.getData("This Week", 8, 1).toString().replace(",", "");
			double Expected_TaxExempt=Double.parseDouble(Expeccted_TxExempt);
			
			

			Thread.sleep(3000);
			//Get Tax Exempt
			String TaxExempt=repts.Tax_Exempt_TaxReport().getText().replace(",", "");
			double Actual_TaxExempt=Double.parseDouble(TaxExempt);
			
			
			//Check whether the Tax Exempt value is Equal or not
			if(Expected_TaxExempt==Actual_TaxExempt)
			{
				test.log(LogStatus.PASS, "Tax Exempt for Tax Report is equal to Sale Recap Report for This Week");
		
			
			}
			else
			{
				double diff=Expected_TaxExempt-Actual_TaxExempt;
				test.log(LogStatus.FAIL, "Tax Exempt for Tax Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
			
			}
			

			
			//Get the Rounding Off from Sale Recap Report
			String Expected_RoundOf=excel.getData("This Week", 12, 1).toString().replace(",", "");
			double Expected_RoundingOff=Double.parseDouble(Expected_RoundOf);
		
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_TaxReport().getText().replace(",", "");
			double Actual_RoundOff=Double.parseDouble(RoundOff);
			
		
			//Check whether the Rounding Off value is Equal or not
			if(Expected_RoundingOff==Actual_RoundOff)
			{
				test.log(LogStatus.PASS, "Rounding Off for Tax Report is equal to Sale Recap Report for This Week");
		

			}
			else
			{
				double diff=Expected_RoundingOff-Actual_RoundOff;
				test.log(LogStatus.FAIL, "Rounding Off for Tax Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
		
			
			
			}
		
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Tax_Report_Last_Week(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		
		
		
		//Select Today
		repts.Select_Last_Week_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_Tax_FoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Tax Not Available for Last Week");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Tax Available for Last Week");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);

			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				
			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last Week", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
		
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Tax Report is equal to Sale Recap Report for Last Week");
		

			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Tax Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
		
			}
			
			//Get the Tax Exempt from Sale Recap Report
			String Expeccted_TxExempt=excel.getData("Last Week", 8, 1).toString().replace(",", "");
			double Expected_TaxExempt=Double.parseDouble(Expeccted_TxExempt);
			
			

			Thread.sleep(3000);
			//Get Tax Exempt
			String TaxExempt=repts.Tax_Exempt_TaxReport().getText().replace(",", "");
			double Actual_TaxExempt=Double.parseDouble(TaxExempt);
		
			
			//Check whether the Tax Exempt value is Equal or not
			if(Expected_TaxExempt==Actual_TaxExempt)
			{
				test.log(LogStatus.PASS, "Tax Exempt for Tax Report is equal to Sale Recap Report for Last Week");
		

			}
			else
			{
				double diff=Expected_TaxExempt-Actual_TaxExempt;
				test.log(LogStatus.FAIL, "Tax Exempt for Tax Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
	
			

			}
			

			//Get the Rounding Off from Sale Recap Report
			String Expected_RoundOf=excel.getData("Last Week", 12, 1).toString().replace(",", "");
			double Expected_RoundingOff=Double.parseDouble(Expected_RoundOf);
		
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_TaxReport().getText().replace(",", "");
			double Actual_RoundOff=Double.parseDouble(RoundOff);
			
			//Check whether the Rounding Off value is Equal or not
			if(Expected_RoundingOff==Actual_RoundOff)
			{
				test.log(LogStatus.PASS, "Rounding Off for Tax Report is equal to Sale Recap Report for Last Week");
		
			}
			else
			{
				double diff=Expected_RoundingOff-Actual_RoundOff;
				test.log(LogStatus.FAIL, "Rounding Off for Tax Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
		
		
			}
			
			
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Tax_Report_Last_7_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		
		
		
		//Select Today
		repts.Select_Last_7_Days_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_Tax_FoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Tax Not Available for Last 7 days");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Tax Available for Last 7 days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
		
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
					
		

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last 7 days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
		

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Tax Report is equal to Sale Recap Report for Last 7 days");
		
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Tax Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
		
		
			}
			
			//Get the Tax Exempt from Sale Recap Report
			String Expeccted_TxExempt=excel.getData("Last 7 days", 8, 1).toString().replace(",", "");
			double Expected_TaxExempt=Double.parseDouble(Expeccted_TxExempt);
			
			

			Thread.sleep(3000);
			//Get Tax Exempt
			String TaxExempt=repts.Tax_Exempt_TaxReport().getText().replace(",", "");
			double Actual_TaxExempt=Double.parseDouble(TaxExempt);
		
			//Check whether the Tax Exempt value is Equal or not
			if(Expected_TaxExempt==Actual_TaxExempt)
			{
				test.log(LogStatus.PASS, "Tax Exempt for Tax Report is equal to Sale Recap Report for Last 7 days");
		
		
			}
			else
			{
				double diff=Expected_TaxExempt-Actual_TaxExempt;
				test.log(LogStatus.FAIL, "Tax Exempt for Tax Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
		
			

			}

			
			//Get the Rounding Off from Sale Recap Report
			String Expected_RoundOf=excel.getData("Last 7 days", 12, 1).toString().replace(",", "");
			double Expected_RoundingOff=Double.parseDouble(Expected_RoundOf);
		
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_TaxReport().getText().replace(",", "");
			double Actual_RoundOff=Double.parseDouble(RoundOff);
			
		
			//Check whether the Rounding Off value is Equal or not
			if(Expected_RoundingOff==Actual_RoundOff)
			{
				test.log(LogStatus.PASS, "Rounding Off for Tax Report is equal to Sale Recap Report for Last 7 days");
		
			}
			else
			{
				double diff=Expected_RoundingOff-Actual_RoundOff;
				test.log(LogStatus.FAIL, "Rounding Off for Tax Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
		
			}
			
		
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Tax_Report_This_Month(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		
		
		
		//Select Today
		repts.Select_This_Month_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_Tax_FoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Tax Not Available for This month");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
	
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Tax Available for This month");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			

			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);


			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("This month", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Tax Report is equal to Sale Recap Report for This month");
		
		
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Tax Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
		
		
			}
			
			//Get the Tax Exempt from Sale Recap Report
			String Expeccted_TxExempt=excel.getData("This month", 8, 1).toString().replace(",", "");
			double Expected_TaxExempt=Double.parseDouble(Expeccted_TxExempt);
			
			

			Thread.sleep(3000);
			//Get Tax Exempt
			String TaxExempt=repts.Tax_Exempt_TaxReport().getText().replace(",", "");
			double Actual_TaxExempt=Double.parseDouble(TaxExempt);
			
			//Check whether the Tax Exempt value is Equal or not
			if(Expected_TaxExempt==Actual_TaxExempt)
			{
				test.log(LogStatus.PASS, "Tax Exempt for Tax Report is equal to Sale Recap Report for This month");
		
			
			}
			else
			{
				double diff=Expected_TaxExempt-Actual_TaxExempt;
				test.log(LogStatus.FAIL, "Tax Exempt for Tax Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
		
			
			}
		
			
			//Get the Rounding Off from Sale Recap Report
			String Expected_RoundOf=excel.getData("This month", 12, 1).toString().replace(",", "");
			double Expected_RoundingOff=Double.parseDouble(Expected_RoundOf);
		
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_TaxReport().getText().replace(",", "");
			double Actual_RoundOff=Double.parseDouble(RoundOff);
		
			
			//Check whether the Rounding Off value is Equal or not
			if(Expected_RoundingOff==Actual_RoundOff)
			{
				test.log(LogStatus.PASS, "Rounding Off for Tax Report is equal to Sale Recap Report for This month");
		
			}
			else
			{
				double diff=Expected_RoundingOff-Actual_RoundOff;
				test.log(LogStatus.FAIL, "Rounding Off for Tax Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
			
			
		
			}
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Tax_Report_Last_Month(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		
		
		
		//Select Today
		repts.Select_Last_Month_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_Tax_FoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Tax Not Available for Last month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Tax Available for Last month");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
	
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

			
		
			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last month", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
		
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Tax Report is equal to Sale Recap Report for Last month");
		
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Tax Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
		
			}
			
			//Get the Tax Exempt from Sale Recap Report
			String Expeccted_TxExempt=excel.getData("Last month", 8, 1).toString().replace(",", "");
			double Expected_TaxExempt=Double.parseDouble(Expeccted_TxExempt);
			
			

			Thread.sleep(3000);
			//Get Tax Exempt
			String TaxExempt=repts.Tax_Exempt_TaxReport().getText().replace(",", "");
			double Actual_TaxExempt=Double.parseDouble(TaxExempt);
			
			
			//Check whether the Tax Exempt value is Equal or not
			if(Expected_TaxExempt==Actual_TaxExempt)
			{
				test.log(LogStatus.PASS, "Tax Exempt for Tax Report is equal to Sale Recap Report for Last month");
			}
			else
			{
				double diff=Expected_TaxExempt-Actual_TaxExempt;
				test.log(LogStatus.FAIL, "Tax Exempt for Tax Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
			
			
			}
			
			//Get the Rounding Off from Sale Recap Report
			String Expected_RoundOf=excel.getData("Last month", 12, 1).toString().replace(",", "");
			double Expected_RoundingOff=Double.parseDouble(Expected_RoundOf);
		
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_TaxReport().getText().replace(",", "");
			double Actual_RoundOff=Double.parseDouble(RoundOff);
			
		
			
			//Check whether the Rounding Off value is Equal or not
			if(Expected_RoundingOff==Actual_RoundOff)
			{
				test.log(LogStatus.PASS, "Rounding Off for Tax Report is equal to Sale Recap Report for Last month");
		
			}
			else
			{
				double diff=Expected_RoundingOff-Actual_RoundOff;
				test.log(LogStatus.FAIL, "Rounding Off for Tax Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
		
			
			}
			
			
			Thread.sleep(3000);

		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Tax_Report_Last_30_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		
		
		
		//Select Today
		repts.Select_Last_30_Days_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_Tax_FoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Tax Not Available for Last 30 days");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Tax Available for Last 30 days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			

			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		
			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last 30 days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
		
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Tax Report is equal to Sale Recap Report for Last 30 days");
		
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Tax Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
		

			}
			
			//Get the Tax Exempt from Sale Recap Report
			String Expeccted_TxExempt=excel.getData("Last 30 days", 8, 1).toString().replace(",", "");
			double Expected_TaxExempt=Double.parseDouble(Expeccted_TxExempt);
			
			

			Thread.sleep(3000);
			//Get Tax Exempt
			String TaxExempt=repts.Tax_Exempt_TaxReport().getText().replace(",", "");
			double Actual_TaxExempt=Double.parseDouble(TaxExempt);
			
			
			//Check whether the Tax Exempt value is Equal or not
			if(Expected_TaxExempt==Actual_TaxExempt)
			{
				test.log(LogStatus.PASS, "Tax Exempt for Tax Report is equal to Sale Recap Report for Last 30 days");
			
			}
			else
			{
				double diff=Expected_TaxExempt-Actual_TaxExempt;
				test.log(LogStatus.FAIL, "Tax Exempt for Tax Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
		
			
			}
			
		

			
			//Get the Rounding Off from Sale Recap Report
			String Expected_RoundOf=excel.getData("Last 30 days", 12, 1).toString().replace(",", "");
			double Expected_RoundingOff=Double.parseDouble(Expected_RoundOf);
		
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_TaxReport().getText().replace(",", "");
			double Actual_RoundOff=Double.parseDouble(RoundOff);
			
			//Check whether the Rounding Off value is Equal or not
			if(Expected_RoundingOff==Actual_RoundOff)
			{
				test.log(LogStatus.PASS, "Rounding Off for Tax Report is equal to Sale Recap Report for Last 30 days");
		
			}
			else
			{
				double diff=Expected_RoundingOff-Actual_RoundOff;
				test.log(LogStatus.FAIL, "Rounding Off for Tax Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
	

			}
			
			
			Thread.sleep(3000);

		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Tax_Report_Specific_Date(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		
		
		
		//Select Today
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_Tax_FoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Tax Not Available for Specific Date");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Tax Available for Specific Date");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
	
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Specific Date", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
		

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Tax Report is equal to Sale Recap Report for Specific Date");
		
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Tax Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
		
			
			}
			
			//Get the Tax Exempt from Sale Recap Report
			String Expeccted_TxExempt=excel.getData("Specific Date", 8, 1).toString().replace(",", "");
			double Expected_TaxExempt=Double.parseDouble(Expeccted_TxExempt);
			
			

			Thread.sleep(3000);
			//Get Tax Exempt
			String TaxExempt=repts.Tax_Exempt_TaxReport().getText().replace(",", "");
			double Actual_TaxExempt=Double.parseDouble(TaxExempt);
			
			//Check whether the Tax Exempt value is Equal or not
			if(Expected_TaxExempt==Actual_TaxExempt)
			{
				test.log(LogStatus.PASS, "Tax Exempt for Tax Report is equal to Sale Recap Report for Specific Date");
		
			}
			else
			{
				double diff=Expected_TaxExempt-Actual_TaxExempt;
				test.log(LogStatus.FAIL, "Tax Exempt for Tax Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
			

			}
			
					
			//Get the Rounding Off from Sale Recap Report
			String Expected_RoundOf=excel.getData("Specific Date", 12, 1).toString().replace(",", "");
			double Expected_RoundingOff=Double.parseDouble(Expected_RoundOf);
		
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_TaxReport().getText().replace(",", "");
			double Actual_RoundOff=Double.parseDouble(RoundOff);
		
			//Check whether the Rounding Off value is Equal or not
			if(Expected_RoundingOff==Actual_RoundOff)
			{
				test.log(LogStatus.PASS, "Rounding Off for Tax Report is equal to Sale Recap Report for Specific Date");
		
			}
			else
			{
				double diff=Expected_RoundingOff-Actual_RoundOff;
				test.log(LogStatus.FAIL, "Rounding Off for Tax Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
			
			
			}
			
		
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Tax_Report_Date_Range(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		//Select the Department
		repts.Select_Department_inReport("All");
		
		
		
		
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_Tax_FoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Tax Not Available for Date Range");
		
		ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Tax Available for Date Range");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);

			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Date Range", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_DailySummaryReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
		
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Tax Report is equal to Sale Recap Report for Date Range");
	
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Tax Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
	

			}
			
		
			//Get the Tax Exempt from Sale Recap Report
			String Expeccted_TxExempt=excel.getData("Date Range", 8, 1).toString().replace(",", "");
			
			double Expected_TaxExempt=Double.parseDouble(Expeccted_TxExempt);
			
			

			Thread.sleep(3000);
			//Get Tax Exempt
			String TaxExempt=repts.Tax_Exempt_TaxReport().getText().replace(",", "");
			double Actual_TaxExempt=Double.parseDouble(TaxExempt);
			
			
			//Check whether the Tax Exempt value is Equal or not
			if(Expected_TaxExempt==Actual_TaxExempt)
			{
				test.log(LogStatus.PASS, "Tax Exempt for Tax Report is equal to Sale Recap Report for Date Range");
	
			}
			else
			{
				double diff=Expected_TaxExempt-Actual_TaxExempt;
				test.log(LogStatus.FAIL, "Tax Exempt for Tax Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
			

			}
			
			//Get the Rounding Off from Sale Recap Report
			String Expected_RoundOf=excel.getData("Date Range", 12, 1).toString().replace(",", "");
			double Expected_RoundingOff=Double.parseDouble(Expected_RoundOf);
		
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_TaxReport().getText().replace(",", "");
			double Actual_RoundOff=Double.parseDouble(RoundOff);
		
			//Check whether the Rounding Off value is Equal or not
			if(Expected_RoundingOff==Actual_RoundOff)
			{
				test.log(LogStatus.PASS, "Rounding Off for Tax Report is equal to Sale Recap Report for Date Range");
		
			}
			else
			{
				double diff=Expected_RoundingOff-Actual_RoundOff;
				test.log(LogStatus.FAIL, "Rounding Off for Tax Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);

			}
			
	
			
			Thread.sleep(3000);

		}
	}
	

}
