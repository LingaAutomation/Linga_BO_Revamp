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
import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExcelDataConfig;
import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports_Void_Node_Report
{
public WebDriver driver;
	 
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Void - Node Report");
	
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
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Void_Node_Path"));
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
		Open_Void_Node_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Void_Node_Report_Verify_Void_Node_Search(driver);
		Void_Node_Report_Today(driver);
		Void_Node_Report_Yesterday(driver);
		Void_Node_Report_Last_N_Days(driver);
		Void_Node_Report_This_Week(driver);
		Void_Node_Report_Last_Week(driver);
		Void_Node_Report_Last_7_Days(driver);
		Void_Node_Report_This_Month(driver);
		Void_Node_Report_Last_Month(driver);
		Void_Node_Report_Last_30_Days(driver);
		Void_Node_Report_Specific_Date(driver);
		Void_Node_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Void_Node_Report_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Daily page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"voidReport/node");

		Thread.sleep(5000);
		//Verify the Categories page loaded or not
		repts.Verify_ReportHomePage("NODE");
		
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
	public void Void_Node_Report_Verify_Void_Node_Search(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Void_Node_Report"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("All");

		
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
			test.log(LogStatus.PASS, "No transaction for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.INFO, "Void-Node Report available for selected time period is not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		}
		
		Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
	
				//Select the Node
				repts.Select_Node("All");
				
				
				
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
					test.log(LogStatus.INFO, "Void - Nodes Not Available for Selected Time Period");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception G)
				{
					
					test.log(LogStatus.PASS, "Void - Nodes Available for Selected Time Period");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

					Thread.sleep(1000);
//					repts.Node_InputBox().click();
//					
//					List<WebElement> nodeList=driver.findElements(By.xpath("//div/select-option"));
//					int randomNode=ThreadLocalRandom.current().nextInt(2, nodeList.size());
//
//					
//					String Node=driver.findElement(By.xpath("//div["+randomNode+"]/select-option")).getText();
//					
//					Thread.sleep(1000);
//					repts.Node_InputBox().click();
					
					String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[1]")).getText();
					
					Thread.sleep(1000);
					//Select Node
					repts.Select_Node(Node);
					
					
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
						test.log(LogStatus.PASS, "Void - Nodes is Available for Searched Node");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Void - Nodes is Not Available for Searched Node");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

				}	
	}
	
	@Test(priority = 4,enabled = false)
	public void Void_Node_Report_Today(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("All");

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
			test.log(LogStatus.INFO, "Void - Nodes Not Available for Today");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Void - Nodes Available for Today");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
			
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
		
			}
		}
		else
		{
			for(int i=1;i<=1000;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
			
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
			
				
			}
		}
			
			
		
		
		

	
			
		}
	}

	@Test(priority = 4,enabled = false)
	public void Void_Node_Report_Yesterday(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Void_Node_Report"));

		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("All");

	

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
			test.log(LogStatus.INFO, "Void - Nodes Not Available for Yesterday");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Void - Nodes Available for Yesterday");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
		
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
		
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				Check.click();
				
				
			}
		}
			
			

			
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Void_Node_Report_Last_N_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Void_Node_Report"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("All");

		

		Thread.sleep(1000);
		//Select Last N days
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Void - Nodes Not Available for Last 'N' days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Void - Nodes Available for Last 'N' days");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
			
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
			
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				
			}
		}
			
			
		
		
		

	
			
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Void_Node_Report_This_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Void_Node_Report"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("All");

		

		Thread.sleep(1000);
		//Select This Week
		repts.Select_This_Week_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Void - Nodes Not Available for This Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Void - Nodes Available for This Week");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
			
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
		
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				
			}
		}
			
			
		
		
		

	
			
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Void_Node_Report_Last_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Void_Node_Report"));
	
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("All");

		
		Thread.sleep(1000);
		//Select Last
		repts.Select_Last_Week_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Void - Nodes Not Available for Last Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Void - Nodes Available for Last Week");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
		
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
			
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				
			}
		}
		

	
		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Void_Node_Report_Last_7_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Void_Node_Report"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("All");

		

		Thread.sleep(1000);
		//Select Last 7 days
		repts.Select_Last_7_Days_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Void - Nodes Not Available for Last 7 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Void - Nodes Available for Last 7 Days");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
			
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
			
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				
			}
		}
		

	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Void_Node_Report_This_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Void_Node_Report"));

		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("All");

		
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
			test.log(LogStatus.INFO, "Void - Nodes Not Available for This Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Void - Nodes Available for This Month");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
			
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
			
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				
			}
		}
		

	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Void_Node_Report_Last_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Void_Node_Report"));

		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("All");

		
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
			test.log(LogStatus.INFO, "Void - Nodes Not Available for Last Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Void - Nodes Available for Last Month");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				
				
			}
		}
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Void_Node_Report_Last_30_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Void_Node_Report"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);


		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("All");

		
		Thread.sleep(1000);
		//Select Last 30 days
		repts.Select_Last_30_Days_TimePeriod();
				
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Void - Nodes Not Available for Last 30 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Void - Nodes Available for Last 30 Days");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
			
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				
			}
		}

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Void_Node_Report_Specific_Date(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Void_Node_Report"));

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("All");

		

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
			test.log(LogStatus.INFO, "Void - Nodes Not Available for Specific Date");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Void - Nodes Available for Specific Date");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				
				
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				
			}
		}
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Void_Node_Report_Date_Range(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		

		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		//Select the Node
		repts.Select_Node("All");

	
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
			test.log(LogStatus.INFO, "Void - Nodes Not Available for Date Range");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Void - Nodes Available for Date Range");
			
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
			
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
			
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				Check.click();
				
			
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
				String Node=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
				String Date=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
				
				WebElement Check=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]//a"));
				
				String Check_No=Check.getText();
				
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
			
				
				String ActualAmount=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
				
				String Void_Reason=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[9]")).getText();

				String Void_By=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[11]")).getText();

				test.log(LogStatus.INFO, "Node is : "+Node+" Check No is: "+Check_No+" Business Date is : "+Date+" Item Name is : "+Item_Name+" Amount is : "+ActualAmount+" Void Reason is : "+Void_Reason+" Void By : "+Void_By);
				
				Check.click();
				
				
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

		}
	}
}
