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

public class Reports_Driver_Report
{
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Driver Report");
	
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
		Open_Driver_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Driver_Report_Verify_Driver_Search(driver);
		Driver_Report_Today(driver);
		Driver_Report_Yesterday(driver);
		Driver_Report_Last_N_Days(driver);
		Driver_Report_This_Week(driver);
		Driver_Report_Last_Week(driver);
		Driver_Report_Last_7_Days(driver);
		Driver_Report_This_Month(driver);
		Driver_Report_Last_Month(driver);
		Driver_Report_Last_30_Days(driver);
		Driver_Report_Specific_Date(driver);
		Driver_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Driver_Report_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Daily page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"driverReport");

		Thread.sleep(5000);
		//Verify the Categories page loeded or not
		cmp.VerifyMainScreenPageHeader("Driver");
		
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
	public void Driver_Report_Verify_Driver_Search(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));

	
		//Select Employee 
		repts.Select_Driver("All");
	
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
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		}
		
		Thread.sleep(2000);
	
				//Select Employee 
				repts.Select_Driver("All");
			
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
					test.log(LogStatus.INFO, "Driver Reports Not Available for Selected Time Period");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception G)
				{
					
					test.log(LogStatus.PASS, "Driver Reports Available for Selected Time Period");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
					
					repts.Employee_InputBox().click();
					
					String Driver_Name=driver.findElement(By.xpath("//select-option[2]")).getText();
					
					repts.Employee_InputBox().click();
					
					//Select Employee 
					repts.Select_Driver(Driver_Name);
					
					//Select Today
					repts.Select_Last_Month_TimePeriod();
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).getText().equalsIgnoreCase(Driver_Name))
					{
						test.log(LogStatus.PASS, "Driver Reports is Available for Searched Driver Number");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Driver Reports is Not Available for Searched Driver Number");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				
	}
	
	@Test(priority = 4,enabled = false)
	public void Driver_Report_Today(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));

		
		
		
		//Select Employee 
		repts.Select_Driver("All");
		
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
			test.log(LogStatus.INFO, "Driver Reports Not Available for Today");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Driver Reports Available for Today");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
//			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size()-1;
			
			
		if(rowSize<=1000)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
			
				
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				String ExpectedAmount=String.valueOf(ExpectedTotal);
				
				double diff=ActualTotal-ExpectedTotal;
				String Diff=String.valueOf(diff);
				
				if(diff==0)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				
				excel.setreport_PassedData("Today", i, 4, Diff);
				}
				else
				{
					
					excel.setreport_FailedData("Today", i, 4, Diff);

					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
			
				excel.setreportData("Today", i, 0, DriverName);
				excel.setreportData("Today", i, 1, Check_No);
				excel.setreportData("Today", i, 2, ActualAmount);
				excel.setreportData("Today", i, 3, ExpectedAmount);
				excel.setreportData("Today", i, 5, Delivery_Charge);
				excel.setreportData("Today", i, 6, Driver_Tip);

				
				
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
		else
		{
			for(int i=1;i<=1000;i++)
			{
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
	
				
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
			
			
		
		
		//To Write all the Data to Excel
		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));
	
			
		}
	}

	@Test(priority = 4,enabled = false)
	public void Driver_Report_Yesterday(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));

		
		
		
		//Select Employee 
		repts.Select_Driver("All");
		
		//Select Today
		repts.Select_Yesterday_TimePeriod();
		
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Driver Reports Not Available for Yesterday");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Driver Reports Available for Yesterday");
			
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
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
		
				
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
		
				
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}	
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
			
			
		
		//To Write all the Data to Excel
		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));
	
	
			
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Driver_Report_Last_N_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));

		
		
		//Select Employee 
		repts.Select_Driver("All");
		
		//Select Today
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Driver Reports Not Available for Last 'N' days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Driver Reports Available for Last 'N' days");
			
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
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
			
				
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
			
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
			
			
		
		
		//To Write all the Data to Excel
		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));
	
			
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Driver_Report_This_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));

		
	
		//Select Employee 
		repts.Select_Driver("All");
		
		//Select Today
		repts.Select_This_Week_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Driver Reports Not Available for This Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Driver Reports Available for This Week");
			
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
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
			
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}		
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
		
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
			
			
		
		
		//To Write all the Data to Excel
		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));
	
			
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Driver_Report_Last_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));
	
		
	
		//Select Employee 
		repts.Select_Driver("All");
		
		//Select Today
		repts.Select_Last_Week_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Driver Reports Not Available for Last Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Driver Reports Available for Last Week");
			
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
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
		
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
			
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
		//To Write all the Data to Excel
		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));
	
		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Driver_Report_Last_7_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));

		
	
		//Select Employee 
		repts.Select_Driver("All");
		
		//Select Today
		repts.Select_Last_7_Days_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Driver Reports Not Available for Last 7 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Driver Reports Available for Last 7 Days");
			
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
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
			
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
			
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
		//To Write all the Data to Excel
		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Driver_Report_This_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));

		
	
		//Select Employee 
		repts.Select_Driver("All");
		
		//Select Today
		repts.Select_This_Month_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Driver Reports Not Available for This Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Driver Reports Available for This Month");
			
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
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
			
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
			
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
		//To Write all the Data to Excel
		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Driver_Report_Last_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));

		
		
		//Select Employee 
		repts.Select_Driver("All");
	
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
			test.log(LogStatus.INFO, "Driver Reports Not Available for Last Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Driver Reports Available for Last Month");
			
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
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
				
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
			}
		}
		//To Write all the Data to Excel
		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Driver_Report_Last_30_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));

		
	
		//Select Employee 
		repts.Select_Driver("All");
		
		//Select Today
		repts.Select_Last_30_Days_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Driver Reports Not Available for Last 30 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Driver Reports Available for Last 30 Days");
			
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
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
				
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
			
				
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
			}
		}
		//To Write all the Data to Excel
		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Driver_Report_Specific_Date(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));

		
		
		//Select Employee 
		repts.Select_Driver("All");
		
		//Select Today
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
			
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Driver Reports Not Available for Specific Date");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Driver Reports Available for Specific Date");
			
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
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
				
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
				
				
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
		//To Write all the Data to Excel
		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Driver_Report_Date_Range(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));

		
	
		//Select Employee 
		repts.Select_Driver("All");
		
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
			
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Driver Reports Not Available for Date Range");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Driver Reports Available for Date Range");
			
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
			
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
			
				
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
				
				//Enter Email Address
				repts.Enter_EmailAddress_DriverReport("abcd");
				
				//Verify Email Id error message
				repts.Verify_Valid_EmailID_ErrorMessage();
				
				
				//Enter Email Address
				repts.Enter_EmailAddress_DriverReport(Utility.getProperty("userName"));
				
				//Click the Send Receipt button
				repts.Click_Send_Receipt_Button();
				
				cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Email receipt sent successfully"))
				{
					test.log(LogStatus.PASS, "Email receipt sent successfully");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Email receipt sent Failed");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
				String DriverName=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
			
				
				String Owed=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Delivery_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();

				String Driver_Tip=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[8]")).getText();

				test.log(LogStatus.INFO, "Driver Name is : "+DriverName+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Owed is : "+Owed+ "Delivery Charge Cost is : "+Delivery_Charge+" Driver Tip is : "+Driver_Tip);
				
				Check.click();
				
				String SubTot=repts.SubTotal_DriverReport();
				double SubTotal=Double.parseDouble(SubTot);
				
				String TaxTot=repts.TaxTotal_DriverReport();
				double TaxTotal=Double.parseDouble(TaxTot);
				
				double ExpectedTotal=SubTotal+TaxTotal;
				
				
				if(ActualTotal==ExpectedTotal)
				{
					test.log(LogStatus.PASS, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount);
				}
				else
				{
					double diff=ActualTotal-ExpectedTotal;
					
					test.log(LogStatus.FAIL, "Expected and ActualAmount is Correct for the Check Number : "+Check_No+" ActualAmount is : "+ActualAmount+" Differenc is : "+diff);
				}
				
				//Enter Email Address
				repts.Enter_EmailAddress_DriverReport("abcd");
				
				//Verify Email Id error message
				repts.Verify_Valid_EmailID_ErrorMessage();
				
				
				//Enter Email Address
				repts.Enter_EmailAddress_DriverReport(Utility.getProperty("userName"));
				
				//Click the Send Receipt button
				repts.Click_Send_Receipt_Button();
				
				cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Email receipt sent successfully"))
				{
					test.log(LogStatus.PASS, "Email receipt sent successfully");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Email receipt sent Failed");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
		//To Write all the Data to Excel
		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Driver_Report"));
	
		}
	}
}
