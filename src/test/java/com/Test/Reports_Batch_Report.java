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

import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.epam.healenium.SelfHealingDriver;
import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExcelDataConfig;
import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports_Batch_Report
{
public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Batch Report");
	
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
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Batch_Path"));
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
		Open_Batch_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Batch_Report_Verify_Batch_Search(driver);
		Batch_Report_Today(driver);
		Batch_Report_Yesterday(driver);
		Batch_Report_Last_N_Days(driver);
		Batch_Report_This_Week(driver);
		Batch_Report_Last_Week(driver);
		Batch_Report_Last_7_Days(driver);
		Batch_Report_This_Month(driver);
		Batch_Report_Last_Month(driver);
		Batch_Report_Last_30_Days(driver);
		Batch_Report_Specific_Date(driver);
		Batch_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Batch_Report_Page(SelfHealingDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Daily page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"batchReport");

		Thread.sleep(5000);
		//Verify the Categories page loeded or not
		cmp.VerifyMainScreenPageHeader("Batch");
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(SelfHealingDriver driver) throws Exception
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
	public void Batch_Report_Verify_Batch_Search(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("Select All");

		Thread.sleep(1000);
		//Select Employee 
		repts.Select_Employee("Select All");

		Thread.sleep(1000);
		//Select the Batch Type
		repts.Select_Batch_Type("All");

		Thread.sleep(1000);
		//Select Business Type
		repts.Select_Date_Type("Business Date");

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
	
				//Select the Node
				repts.Select_Node("Select All");
				
				Thread.sleep(1000);
				//Select Employee 
				repts.Select_Employee("Select All");
			
				Thread.sleep(1000);
				//Select the Batch Type
				repts.Select_Batch_Type("All");
				
				Thread.sleep(1000);
				//Select Business Type
				repts.Select_Date_Type("Business Date");
				
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
					test.log(LogStatus.INFO, "Batch Reports Not Available for Selected Time Period");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception G)
				{
					
					test.log(LogStatus.PASS, "Batch Reports Available for Selected Time Period");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

					Thread.sleep(1000);
					repts.Node_InputBox().click();
					
					List<WebElement> nodeList=driver.findElements(By.xpath("//select-option"));
					int randomNode=ThreadLocalRandom.current().nextInt(2, nodeList.size());

					
					String Node=driver.findElement(By.xpath("//select-option["+randomNode+"]")).getText();
					
					Thread.sleep(1000);
					repts.Node_InputBox().click();
					
					Thread.sleep(1000);
					//Select Node
					repts.Select_Node(Node);
					
					Thread.sleep(1000);
					//Select Employee 
					repts.Select_Employee("Select All");
					
					Thread.sleep(1000);
					//Select the Batch Type
					repts.Select_Batch_Type("All");

					Thread.sleep(1000);
					//Select Business Type
					repts.Select_Date_Type("Business Date");

					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_Month_TimePeriod();
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).getText().equalsIgnoreCase(Node))
					{
						test.log(LogStatus.PASS, "Batch Reports is Available for Searched Node");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Batch Reports is Not Available for Searched Node");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

					Thread.sleep(1000);
					//Select Nodes
					repts.Select_Node("Select All");

					Thread.sleep(1000);
					//Select Employee
					repts.Employee_InputBox().click();
					
					String Employee=driver.findElement(By.xpath("//select-option[2]")).getText();

					Thread.sleep(1000);
					repts.Employee_InputBox().click();

					Thread.sleep(1000);
					//Select Employee 
					repts.Select_Employee(Employee);

					Thread.sleep(1000);
					//Select the Batch Type
					repts.Select_Batch_Type("All");

					Thread.sleep(1000);
					//Select Business Type
					repts.Select_Date_Type("Business Date");

					Thread.sleep(1000);
					//Select Today
					repts.Select_Last_Month_TimePeriod();
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).getText().equalsIgnoreCase(Employee))
					{
						test.log(LogStatus.PASS, "Batch Reports is Available for Searched Employee");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Batch Reports is Not Available for Searched Employee");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

				Thread.sleep(1000);
				//Select Nodes
				repts.Select_Node("Select All");

				Thread.sleep(1000);
				//Select Employee 
				repts.Select_Employee("Select All");

				Thread.sleep(1000);
				//Select Manual Batch Type
				repts.Select_Batch_Type("Manual");

				Thread.sleep(1000);
				//Select Date Type
				repts.Select_Date_Type("Business Date");

				Thread.sleep(1000);
				//Select Today
				repts.Select_Last_Month_TimePeriod();
				
				Thread.sleep(1000);
				//Click Apply
				repts.Click_ApplyButton(); 
			
				Thread.sleep(3000);
				try
				{
				if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).isDisplayed())
				{
					
					test.log(LogStatus.PASS, "Batch Reports is Available for Manual Batch");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
					
				}
				}
				catch(Exception l)
				{
					test.log(LogStatus.INFO, "Batch Reports is Not Available for Manual Batch");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

				Thread.sleep(1000);
				//Select Nodes
				repts.Select_Node("Select All");

				Thread.sleep(1000);
				//Select Employee 
				repts.Select_Employee("Select All");

				Thread.sleep(1000);
				//Select Manual Batch Type
				repts.Select_Batch_Type("Auto Batch");

				Thread.sleep(1000);
				//Select Date Type
				repts.Select_Date_Type("Business Date");

				Thread.sleep(1000);
				//Select Today
				repts.Select_Last_Month_TimePeriod();
				
				Thread.sleep(1000);
				//Click Apply
				repts.Click_ApplyButton(); 
			
				Thread.sleep(3000);
				try
				{
				if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).isDisplayed())
				{
					
					test.log(LogStatus.PASS, "Batch Reports is Available for Auto Batch");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception l)
				{
					test.log(LogStatus.INFO, "Batch Reports is Not Available for Auto Batch");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
	
				driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

				Thread.sleep(1000);
				//Select Nodes
				repts.Select_Node("Select All");

				Thread.sleep(1000);
				//Select Employee 
				repts.Select_Employee("Select All");

				Thread.sleep(1000);
				//Select Manual Batch Type
				repts.Select_Batch_Type("All");

				Thread.sleep(1000);
				//Select Date Type
				repts.Select_Date_Type("Batch Settled Date");

				Thread.sleep(1000);
				//Select Today
				repts.Select_Last_Month_TimePeriod();
				
				Thread.sleep(1000);
				//Click Apply
				repts.Click_ApplyButton(); 
			
				Thread.sleep(3000);
				try
				{
				if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Batch Reports is Available for Batch Settled Date");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
					
				}
				}
				catch(Exception l)
				{
				
					test.log(LogStatus.INFO, "Batch Reports is Not Available for Batch Settled Date");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
	
	}
	
	@Test(priority = 4,enabled = false)
	public void Batch_Report_Today(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("Select All");

		Thread.sleep(1000);	
		//Select Employee
		repts.Select_Employee("Select All");

		Thread.sleep(1000);
		//Select the Batch Type
		repts.Select_Batch_Type("All");

		Thread.sleep(1000);	
		//Select Business Type
		repts.Select_Date_Type("Business Date");
				

		Thread.sleep(1000);
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
			test.log(LogStatus.INFO, "Batch Reports Not Available for Today");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Batch Reports Available for Today");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
			
				
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
			
//				excel.setreportData("Today", i, 0, DriverName);
//				excel.setreportData("Today", i, 1, Check_No);
//				excel.setreportData("Today", i, 2, ActualAmount);
//				excel.setreportData("Today", i, 3, ExpectedAmount);
//				excel.setreportData("Today", i, 5, Delivery_Charge);
//				excel.setreportData("Today", i, 6, Batch_Tip);

				
				
				
				Thread.sleep(1000);
				//Click the Back button
				repts.Click_Back_Button();
			}
		}
		else
		{
			for(int i=1;i<=1000;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
	
				
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
//		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));
	
			
		}
	}

	@Test(priority = 4,enabled = false)
	public void Batch_Report_Yesterday(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));

		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("Select All");

		Thread.sleep(1000);	
		//Select Employee
		repts.Select_Employee("Select All");

		Thread.sleep(1000);
		//Select the Batch Type
		repts.Select_Batch_Type("All");

		Thread.sleep(1000);
		//Select Business Type
		repts.Select_Date_Type("Business Date");
				

		Thread.sleep(1000);
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
			test.log(LogStatus.INFO, "Batch Reports Not Available for Yesterday");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Batch Reports Available for Yesterday");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
		
				
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
		
				
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
//		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));
	
	
			
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Batch_Report_Last_N_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("Select All");

		Thread.sleep(1000);
		//Select Employee
		repts.Select_Employee("Select All");

		Thread.sleep(1000);
		//Select the Batch Type
		repts.Select_Batch_Type("All");

		Thread.sleep(1000);
		//Select Business Type
		repts.Select_Date_Type("Business Date");
				

		Thread.sleep(1000);
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
			test.log(LogStatus.INFO, "Batch Reports Not Available for Last 'N' days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Batch Reports Available for Last 'N' days");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
			
				
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
			
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
//		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));
	
			
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Batch_Report_This_Week(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("Select All");

		Thread.sleep(1000);
		//Select Employee
		repts.Select_Employee("Select All");

		Thread.sleep(1000);
		//Select the Batch Type
		repts.Select_Batch_Type("All");

		Thread.sleep(1000);
		//Select Business Type
		repts.Select_Date_Type("Business Date");
				

		Thread.sleep(1000);
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
			test.log(LogStatus.INFO, "Batch Reports Not Available for This Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Batch Reports Available for This Week");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
			
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
		
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
//		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));
	
			
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Batch_Report_Last_Week(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));
	
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("Select All");

		Thread.sleep(1000);
		//Select Employee
		repts.Select_Employee("Select All");

		Thread.sleep(1000);
		//Select the Batch Type
		repts.Select_Batch_Type("All");

		Thread.sleep(1000);
		//Select Business Type
		repts.Select_Date_Type("Business Date");
				

		Thread.sleep(1000);
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
			test.log(LogStatus.INFO, "Batch Reports Not Available for Last Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Batch Reports Available for Last Week");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
		
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
			
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
//		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));
	
		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Batch_Report_Last_7_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("Select All");

		Thread.sleep(1000);
		//Select Employee
		repts.Select_Employee("Select All");

		Thread.sleep(1000);
		//Select the Batch Type
		repts.Select_Batch_Type("All");

		Thread.sleep(1000);
		//Select Business Type
		repts.Select_Date_Type("Business Date");
				

		Thread.sleep(1000);
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
			test.log(LogStatus.INFO, "Batch Reports Not Available for Last 7 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Batch Reports Available for Last 7 Days");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
			
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
			
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
//		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Batch_Report_This_Month(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));

		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("Select All");

		Thread.sleep(1000);
		//Select Employee
		repts.Select_Employee("Select All");

		Thread.sleep(1000);
		//Select the Batch Type
		repts.Select_Batch_Type("All");

		Thread.sleep(1000);
		//Select Business Type
		repts.Select_Date_Type("Business Date");
				

		Thread.sleep(1000);
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
			test.log(LogStatus.INFO, "Batch Reports Not Available for This Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Batch Reports Available for This Month");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
			
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
			
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
//		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Batch_Report_Last_Month(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));

		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("Select All");

		Thread.sleep(1000);
		//Select Employee
		repts.Select_Employee("Select All");

		Thread.sleep(1000);
		//Select the Batch Type
		repts.Select_Batch_Type("All");

		Thread.sleep(1000);
		//Select Business Type
		repts.Select_Date_Type("Business Date");

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
			test.log(LogStatus.INFO, "Batch Reports Not Available for Last Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Batch Reports Available for Last Month");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
				
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
				
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
//		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Batch_Report_Last_30_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);


		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("Select All");

		Thread.sleep(1000);
		//Select Employee
		repts.Select_Employee("Select All");

		Thread.sleep(1000);
		//Select the Batch Type
		repts.Select_Batch_Type("All");

		Thread.sleep(1000);
		//Select Business Type
		repts.Select_Date_Type("Business Date");
				

		Thread.sleep(1000);
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
			test.log(LogStatus.INFO, "Batch Reports Not Available for Last 30 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Batch Reports Available for Last 30 Days");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
				
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
			
				
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
//		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Batch_Report_Specific_Date(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("Select All");

		Thread.sleep(1000);
		//Select Employee
		repts.Select_Employee("Select All");

		Thread.sleep(1000);
		//Select the Batch Type
		repts.Select_Batch_Type("All");

		Thread.sleep(1000);
		//Select Business Type
		repts.Select_Date_Type("Business Date");
				

		Thread.sleep(1000);
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
			test.log(LogStatus.INFO, "Batch Reports Not Available for Specific Date");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Batch Reports Available for Specific Date");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
				
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
				
				
				
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
//		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Batch_Report_Date_Range(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));

		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("Select All");

		Thread.sleep(1000);
		//Select Employee
		repts.Select_Employee("Select All");

		Thread.sleep(1000);
		//Select the Batch Type
		repts.Select_Batch_Type("All");

		Thread.sleep(1000);
		//Select Business Type
		repts.Select_Date_Type("Business Date");
				

		Thread.sleep(1000);
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
			test.log(LogStatus.INFO, "Batch Reports Not Available for Date Range");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Batch Reports Available for Date Range");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
			
				
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[10]")).getText();
				
				String Busi_date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]//a"));
				
				String Check_No=Check.getText();
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				double ActualTotal=Double.parseDouble(ActualAmount);
			
				
				String BatchType=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();
				
				String Service_Charge=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();

				String Tip_Amount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Business Date is : "+Busi_date+" Check No is: "+Check_No+" Amount is : "+ActualAmount+" Batch Type is : "+BatchType+ "Service Charge Cost is : "+Service_Charge+" Tip Amount is : "+Tip_Amount);
				
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
//		excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Batch_Report"));
	
		}
	}
}
