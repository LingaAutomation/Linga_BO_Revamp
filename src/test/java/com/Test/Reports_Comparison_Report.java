package com.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports_Comparison_Report 
{
	public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Comparison Report");
	
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
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		
		options.setHeadless(false);
		
		WebDriver delegate=new ChromeDriver();
		
		driver=SelfHealingDriver.create(delegate);
//		System.setProperty("webdriver.chrome.driver","./Automation Driver/chromedriver.exe");
//		//Open the Chrome window
//		driver = new ChromeDriver();
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver(chrOpt);
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
		Open_Comparison_Report_Page(driver);
//		RefreshAndPaginination(driver);
//		Comparison_Sale_Report_Comp1_Today_Comp2_Yesterday(driver);
//		Comparison_Sale_Report_Comp1_Today_Comp2_Last_N_Days(driver);
//		Comparison_Sale_Report_Comp1_Today_Comp2_This_Week(driver);
//		Comparison_Sale_Report_Comp1_Today_Comp2_Last_Week(driver);
//		Comparison_Sale_Report_Comp1_Today_Comp2_Last_7_Days(driver);
//		Comparison_Sale_Report_Comp1_Today_Comp2_This_Month(driver);
//		Comparison_Sale_Report_Comp1_Today_Comp2_Last_Month(driver);
//		Comparison_Sale_Report_Comp1_Today_Comp2_Last_30_days(driver);
//		Comparison_Sale_Report_Comp1_Today_Comp2_Specific_Date(driver);
//		Comparison_Sale_Report_Comp1_Today_Comp2_Date_Range(driver);
//		Comparison_Sale_Report_Comp1_SpecificDate_Comp2_SpecificDate(driver);
//		Comparison_Sale_Report_Comp1_DateRange_Comp2_DateRange(driver);
		Comparison_Sale_Report_Comp1_SpecificDate_Comp2_SpecificDate_Comp3_SpecificDate(driver);
		Comparison_Sale_Report_Comp1_DateRange_Comp2_DateRange_Comp3_DateRange(driver);
		Comparison_Sale_Report_Comp1_SpecificDate_Comp2_SpecificDate_Comp3_SpecificDate_Comp4_SpecificDate(driver);
		Comparison_Sale_Report_Comp1_DateRange_Comp2_DateRange_Comp3_DateRange_Comp4_DateRange(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Comparison_Report_Page(SelfHealingDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(10000);
		//Load the Sale Summarys report page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"comparison-report");

		Thread.sleep(5000);
		//Verify the Sale account balance report page loeded or not
		cmp.VerifyMainScreenPageHeader("Comparison Report");
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
	public void Comparison_Sale_Report_Comp1_Today_Comp2_Yesterday(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Compare Time 1
		repts.Select_CompareTime1();
		
		//Select Compare Time 1 Time Period as Today
		repts.Select_Time_Period_asPerOption("Today");
		
		//Select Compare Time 2
		repts.Select_CompareTime2();
				
		//Select Compare Time 2 Time Period as Today
		repts.Select_Time_Period_asPerOption("Yesterday");
		
		//Click the Compare Time 
		for(int i=1;i<=2;i++)
		{
			repts.Click_Compare_Time();
		}
				
		Thread.sleep(1000);
		//Click the Delete button
		for(int i=1;i<=2;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//div[@class='comparison-report-container']/div/div/div/div//button)[1]")).click();
		}
		
		Thread.sleep(1000);
		//Click the Apply button
		repts.Click_ApplyButton();
		
		Thread.sleep(5000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Comparison Report Not Available for Compare Time 1 (Today) & Compare Time 2 (Yesterday) ");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Comparison Report Available for Compare Time 1 (Today) & Compare Time 2 (Yesterday) ");

			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
		List<WebElement> rowList=driver.findElements(By.xpath("//table/tr"));
		
//		List<WebElement> headList=driver.findElements(By.xpath("//table/tr[1]/th"));
		
		//List<WebElement> colList=driver.findElements(By.xpath("//table/tr[2]/td"));
		
		test.log(LogStatus.INFO, "Compare Time 1 "+"     -vs-     "+" Compare Time 2");
		
		for(int i=1;i<=rowList.size();i++)
		{
			
				if(i==1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
				
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/th[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/th[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[3]")).getText());
//					}
				}
				else if(i>1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
					
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/td[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/td[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[3]")).getText());
//					}
				}
			
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Comparison_Sale_Report_Comp1_Today_Comp2_Last_N_Days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Compare Time 1
		repts.Select_CompareTime1();
		
		//Select Compare Time 1 Time Period as Today
		repts.Select_Time_Period_asPerOption("Today");
		
		//Select Compare Time 2
		repts.Select_CompareTime2();
				
		//Select Compare Time 2 Time Period as Today
		repts.Select_Time_Period_asPerOption("Last N days");
				
		//Click the Apply button
		repts.Click_ApplyButton();
		
		Thread.sleep(5000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Comparison Report Not Available for Compare Time 1 (Today) & Compare Time 2 (Last N days)");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Comparison Report Available for Compare Time 1 (Today) & Compare Time 2 (Last N days) ");

			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
		List<WebElement> rowList=driver.findElements(By.xpath("//table/tr"));
		
//		List<WebElement> headList=driver.findElements(By.xpath("//table/tr[1]/th"));
		
		//List<WebElement> colList=driver.findElements(By.xpath("//table/tr[2]/td"));
		
		test.log(LogStatus.INFO, "Compare Time 1 "+"     -vs-     "+" Compare Time 2");
		
		for(int i=1;i<=rowList.size();i++)
		{
			
				if(i==1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
				
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/th[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/th[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[3]")).getText());
//					}
				}
				else if(i>1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
					
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/td[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/td[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[3]")).getText());
//					}
				}
			
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Comparison_Sale_Report_Comp1_Today_Comp2_This_Week(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Compare Time 1
		repts.Select_CompareTime1();
		
		//Select Compare Time 1 Time Period as Today
		repts.Select_Time_Period_asPerOption("Today");
		
		//Select Compare Time 2
		repts.Select_CompareTime2();
				
		//Select Compare Time 2 Time Period as Today
		repts.Select_Time_Period_asPerOption("This week");
				
		//Click the Apply button
		repts.Click_ApplyButton();
		
		Thread.sleep(5000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Comparison Report Not Available for Compare Time 1 (Today) & Compare Time 2 (This week)");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Comparison Report Available for Compare Time 1 (Today) & Compare Time 2 (This week) ");

			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
		List<WebElement> rowList=driver.findElements(By.xpath("//table/tr"));
		
//		List<WebElement> headList=driver.findElements(By.xpath("//table/tr[1]/th"));
		
		//List<WebElement> colList=driver.findElements(By.xpath("//table/tr[2]/td"));
		
		test.log(LogStatus.INFO, "Compare Time 1 "+"     -vs-     "+" Compare Time 2");
		
		for(int i=1;i<=rowList.size();i++)
		{
			
				if(i==1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
				
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/th[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/th[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[3]")).getText());
//					}
				}
				else if(i>1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
					
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/td[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/td[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[3]")).getText());
//					}
				}
			
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Comparison_Sale_Report_Comp1_Today_Comp2_Last_Week(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Compare Time 1
		repts.Select_CompareTime1();
		
		//Select Compare Time 1 Time Period as Today
		repts.Select_Time_Period_asPerOption("Today");
		
		//Select Compare Time 2
		repts.Select_CompareTime2();
				
		//Select Compare Time 2 Time Period as Today
		repts.Select_Time_Period_asPerOption("Last week");
				
		//Click the Apply button
		repts.Click_ApplyButton();
		
		Thread.sleep(5000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Comparison Report Not Available for Compare Time 1 (Today) & Compare Time 2 (Last week)");
			
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Comparison Report Available for Compare Time 1 (Today) & Compare Time 2 (Last week) ");

			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
		List<WebElement> rowList=driver.findElements(By.xpath("//table/tr"));
		
//		List<WebElement> headList=driver.findElements(By.xpath("//table/tr[1]/th"));
		
		//List<WebElement> colList=driver.findElements(By.xpath("//table/tr[2]/td"));
		
		test.log(LogStatus.INFO, "Compare Time 1 "+"     -vs-     "+" Compare Time 2");
		
		for(int i=1;i<=rowList.size();i++)
		{
			
				if(i==1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
				
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/th[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/th[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[3]")).getText());
//					}
				}
				else if(i>1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
					
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/td[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/td[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[3]")).getText());
//					}
				}
			
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Comparison_Sale_Report_Comp1_Today_Comp2_Last_7_Days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Compare Time 1
		repts.Select_CompareTime1();
		
		//Select Compare Time 1 Time Period as Today
		repts.Select_Time_Period_asPerOption("Today");
		
		//Select Compare Time 2
		repts.Select_CompareTime2();
				
		//Select Compare Time 2 Time Period as Today
		repts.Select_Time_Period_asPerOption("Last 7 days");
				
		//Click the Apply button
		repts.Click_ApplyButton();
		
		Thread.sleep(5000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Comparison Report Not Available for Compare Time 1 (Today) & Compare Time 2 (Last 7 days)");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Comparison Report Available for Compare Time 1 (Today) & Compare Time 2 (Last 7 days) ");

			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
		List<WebElement> rowList=driver.findElements(By.xpath("//table/tr"));
		
//		List<WebElement> headList=driver.findElements(By.xpath("//table/tr[1]/th"));
		
		//List<WebElement> colList=driver.findElements(By.xpath("//table/tr[2]/td"));
		
		test.log(LogStatus.INFO, "Compare Time 1 "+"     -vs-     "+" Compare Time 2");
		
		for(int i=1;i<=rowList.size();i++)
		{
			
				if(i==1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
				
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/th[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/th[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[3]")).getText());
//					}
				}
				else if(i>1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
					
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/td[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/td[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[3]")).getText());
//					}
				}
			
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		
		}
		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Comparison_Sale_Report_Comp1_Today_Comp2_This_Month(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Compare Time 1
		repts.Select_CompareTime1();
		
		//Select Compare Time 1 Time Period as Today
		repts.Select_Time_Period_asPerOption("Today");
		
		//Select Compare Time 2
		repts.Select_CompareTime2();
				
		//Select Compare Time 2 Time Period as Today
		repts.Select_Time_Period_asPerOption("This month");
				
		//Click the Apply button
		repts.Click_ApplyButton();
		
		Thread.sleep(5000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Comparison Report Not Available for Compare Time 1 (Today) & Compare Time 2 (This month)");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Comparison Report Available for Compare Time 1 (Today) & Compare Time 2 (This month) ");

			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
		List<WebElement> rowList=driver.findElements(By.xpath("//table/tr"));
		
//		List<WebElement> headList=driver.findElements(By.xpath("//table/tr[1]/th"));
		
		//List<WebElement> colList=driver.findElements(By.xpath("//table/tr[2]/td"));
		
		test.log(LogStatus.INFO, "Compare Time 1 "+"     -vs-     "+" Compare Time 2");
		
		for(int i=1;i<=rowList.size();i++)
		{
			
				if(i==1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
				
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/th[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/th[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[3]")).getText());
//					}
				}
				else if(i>1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
					
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/td[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/td[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[3]")).getText());
//					}
				}
			
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		
		}
		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Comparison_Sale_Report_Comp1_Today_Comp2_Last_Month(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Compare Time 1
		repts.Select_CompareTime1();
		
		//Select Compare Time 1 Time Period as Today
		repts.Select_Time_Period_asPerOption("Today");
		
		//Select Compare Time 2
		repts.Select_CompareTime2();
				
		//Select Compare Time 2 Time Period as Today
		repts.Select_Time_Period_asPerOption("Last month");
				
		//Click the Apply button
		repts.Click_ApplyButton();
		
		Thread.sleep(5000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Comparison Report Not Available for Compare Time 1 (Today) & Compare Time 2 (Last month)");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Comparison Report Available for Compare Time 1 (Today) & Compare Time 2 (Last month) ");

			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
		List<WebElement> rowList=driver.findElements(By.xpath("//table/tr"));
		
//		List<WebElement> headList=driver.findElements(By.xpath("//table/tr[1]/th"));
		
		//List<WebElement> colList=driver.findElements(By.xpath("//table/tr[2]/td"));
		
		test.log(LogStatus.INFO, "Compare Time 1 "+"     -vs-     "+" Compare Time 2");
		
		for(int i=1;i<=rowList.size();i++)
		{
			
				if(i==1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
				
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/th[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/th[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[3]")).getText());
//					}
				}
				else if(i>1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
					
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/td[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/td[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[3]")).getText());
//					}
				}
			
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Comparison_Sale_Report_Comp1_Today_Comp2_Last_30_days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Compare Time 1
		repts.Select_CompareTime1();
		
		//Select Compare Time 1 Time Period as Today
		repts.Select_Time_Period_asPerOption("Today");
		
		//Select Compare Time 2
		repts.Select_CompareTime2();
				
		//Select Compare Time 2 Time Period as Today
		repts.Select_Time_Period_asPerOption("Last 30 days");
				
		//Click the Apply button
		repts.Click_ApplyButton();
		
		Thread.sleep(5000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Comparison Report Not Available for Compare Time 1 (Today) & Compare Time 2 (Last 30 days)");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Comparison Report Available for Compare Time 1 (Today) & Compare Time 2 (Last 30 days) ");

			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
		List<WebElement> rowList=driver.findElements(By.xpath("//table/tr"));
		
//		List<WebElement> headList=driver.findElements(By.xpath("//table/tr[1]/th"));
		
		//List<WebElement> colList=driver.findElements(By.xpath("//table/tr[2]/td"));
		
		test.log(LogStatus.INFO, "Compare Time 1 "+"     -vs-     "+" Compare Time 2");
		
		for(int i=1;i<=rowList.size();i++)
		{
			
				if(i==1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
				
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/th[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/th[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[3]")).getText());
//					}
				}
				else if(i>1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
					
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/td[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/td[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[3]")).getText());
//					}
				}
			
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Comparison_Sale_Report_Comp1_Today_Comp2_Specific_Date(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Compare Time 1
		repts.Select_CompareTime1();
		
		//Select Compare Time 1 Time Period as Today
		repts.Select_Time_Period_asPerOption("Today");
		
		//Select Compare Time 2
		repts.Select_CompareTime2();
				
		//Select Compare Time 2 Time Period as Today
		repts.Select_Time_Period_asPerOption("Specific date");
				
		//Click the Apply button
		repts.Click_ApplyButton();
		
		Thread.sleep(5000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Comparison Report Not Available for Compare Time 1 (Today) & Compare Time 2 (Specific Date)");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Comparison Report Available for Compare Time 1 (Today) & Compare Time 2 (Specific Date) ");

			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
		List<WebElement> rowList=driver.findElements(By.xpath("//table/tr"));
		
//		List<WebElement> headList=driver.findElements(By.xpath("//table/tr[1]/th"));
		
		//List<WebElement> colList=driver.findElements(By.xpath("//table/tr[2]/td"));
		
		test.log(LogStatus.INFO, "Compare Time 1 "+"     -vs-     "+" Compare Time 2");
		
		for(int i=1;i<=rowList.size();i++)
		{
			
				if(i==1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
				
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/th[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/th[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[3]")).getText());
//					}
				}
				else if(i>1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
					
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/td[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/td[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[3]")).getText());
//					}
				}
			
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Comparison_Sale_Report_Comp1_Today_Comp2_Date_Range(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Compare Time 1
		repts.Select_CompareTime1();
		
		//Select Compare Time 1 Time Period as Today
		repts.Select_Time_Period_asPerOption("Today");
		
		//Select Compare Time 2
		repts.Select_CompareTime2();
				
		//Select Compare Time 2 Time Period as Today
		repts.Select_Time_Period_asPerOption("Date range");
				
		//Click the Apply button
		repts.Click_ApplyButton();
		
		Thread.sleep(5000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Comparison Report Not Available for Compare Time 1 (Today) & Compare Time 2 (Date Range)");
		
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Comparison Report Available for Compare Time 1 (Today) & Compare Time 2 (Date Range) ");

			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
		List<WebElement> rowList=driver.findElements(By.xpath("//table/tr"));
		
//		List<WebElement> headList=driver.findElements(By.xpath("//table/tr[1]/th"));
		
		//List<WebElement> colList=driver.findElements(By.xpath("//table/tr[2]/td"));
		
		test.log(LogStatus.INFO, "Compare Time 1 "+"     -vs-     "+" Compare Time 2");
		
			for(int i=1;i<=rowList.size();i++)
			{
			
				if(i==1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
				
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/th[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/th[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[3]")).getText());
//					}
				}
				else if(i>1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
					
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/td[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/td[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[3]")).getText());
//					}
				}
			
			
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}
		
		
		}
		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Comparison_Sale_Report_Comp1_SpecificDate_Comp2_SpecificDate(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Compare Time 1
		repts.Select_CompareTime1();
		
		//Select Compare Time 1 Time Period as Today
		repts.Select_Specific_Date_withoutTimePeriod(Utility.getProperty("Report_Specific_Date"),1);
		
		
		//Select Compare Time 2
		repts.Select_CompareTime2();
				
		//Select Compare Time 2 Time Period as Today
		repts.Select_Specific_Date_withoutTimePeriod("25/09/2023",2);
				
		//Click the Apply button
		repts.Click_ApplyButton();
		
		Thread.sleep(5000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Comparison Report Not Available for Compare Time 1 (Specific Date) & Compare Time 2 (Specific Date)");
		
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Comparison Report Available for Compare Time 1 (Specific Date) & Compare Time 2 (Specific Date) ");

			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
		List<WebElement> rowList=driver.findElements(By.xpath("//table/tr"));
		
//		List<WebElement> headList=driver.findElements(By.xpath("//table/tr[1]/th"));
		
		//List<WebElement> colList=driver.findElements(By.xpath("//table/tr[2]/td"));
		
		test.log(LogStatus.INFO, "Compare Time 1 "+"     -vs-     "+" Compare Time 2");
		
			for(int i=1;i<=rowList.size();i++)
			{
			
				if(i==1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
				
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/th[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/th[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[3]")).getText());
//					}
				}
				else if(i>1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
					
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/td[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/td[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[3]")).getText());
//					}
				}
			
			
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}
		
		
		}
		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Comparison_Sale_Report_Comp1_DateRange_Comp2_DateRange(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Compare Time 1
		repts.Select_CompareTime1();
		
		//Select Compare Time 1 Time Period as Today
		repts.Select_Date_Range_withoutTimePeriod(Utility.getProperty("Report_Start_Date"),Utility.getProperty("Report_End_Date"),1);
		
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		Thread.sleep(1000);
		//Select Compare Time 2
		repts.Select_CompareTime2();
				
		//Select Compare Time 2 Time Period as Today
		repts.Select_Date_Range_withoutTimePeriod("01/08/2023","30/08/2023",2);
				
		//Click the Apply button
		repts.Click_ApplyButton();
		
		Thread.sleep(5000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Comparison Report Not Available for Compare Time 1 (Date Range) & Compare Time 2 (Date Range)");
		
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Comparison Report Available for Compare Time 1 (Date Range) & Compare Time 2 (Date Range) ");

			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
		List<WebElement> rowList=driver.findElements(By.xpath("//table/tr"));
		
//		List<WebElement> headList=driver.findElements(By.xpath("//table/tr[1]/th"));
		
		//List<WebElement> colList=driver.findElements(By.xpath("//table/tr[2]/td"));
		
		test.log(LogStatus.INFO, "Compare Time 1 "+"     -vs-     "+" Compare Time 2");
		
			for(int i=1;i<=rowList.size();i++)
			{
			
				if(i==1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
				
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/th[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/th[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[3]")).getText());
//					}
				}
				else if(i>1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
					
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/td[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/td[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[3]")).getText());
//					}
				}
			
			
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}
		
		
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Comparison_Sale_Report_Comp1_SpecificDate_Comp2_SpecificDate_Comp3_SpecificDate(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Compare Time 1
		repts.Select_CompareTime1();
		
		//Select Compare Time 1 Time Period as Today
		repts.Select_Specific_Date_withoutTimePeriod("20/09/2023",1);
		
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		Thread.sleep(1000);
		//Select Compare Time 2
		repts.Select_CompareTime2();
				
		//Select Compare Time 2 Time Period as Today
		repts.Select_Specific_Date_withoutTimePeriod("23/09/2023",2);
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		Thread.sleep(1000);
		
		//Click the Compare Time button
		repts.Click_Compare_Time();
		
		
		//Select Compare Time 3
		repts.Select_CompareTime3();
						
		//Select Compare Time 3 Time Period as Today
		repts.Select_Specific_Date_withoutTimePeriod("25/09/2023",3);
					
				
		//Click the Apply button
		repts.Click_ApplyButton();
		
		Thread.sleep(5000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Comparison Report Not Available for Compare Time 1 (Specific Date), Compare Time 2 (Specific Date) & Compare Time 3 (Specific Date)");
		
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Comparison Report Available for Compare Time 1 (Specific Date), Compare Time 2 (Specific Date) & Compare Time 3 (Specific Date)");

			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
		List<WebElement> rowList=driver.findElements(By.xpath("//table/tr"));
		
//		List<WebElement> headList=driver.findElements(By.xpath("//table/tr[1]/th"));
		
		//List<WebElement> colList=driver.findElements(By.xpath("//table/tr[2]/td"));
		
		test.log(LogStatus.INFO, "Compare Time 1 "+"     -vs-     "+" Compare Time 2");
		
			for(int i=1;i<=rowList.size();i++)
			{
			
				if(i==1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
				
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/th[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/th[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[3]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[4]")).getText());
//					}
				}
				else if(i>1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
					
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/td[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/td[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[3]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[4]")).getText());
//					}
				}
			
			
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}
		
		
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Comparison_Sale_Report_Comp1_DateRange_Comp2_DateRange_Comp3_DateRange(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Compare Time 1
		repts.Select_CompareTime1();
		
		//Select Compare Time 1 Time Period as Today
		repts.Select_Date_Range_withoutTimePeriod("01/06/2023","30/06/2023",1);
		
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		Thread.sleep(1000);
		
		//Select Compare Time 2
		repts.Select_CompareTime2();
				
		//Select Compare Time 2 Time Period as Today
		repts.Select_Date_Range_withoutTimePeriod("01/07/2023","30/07/2023",2);
		
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		Thread.sleep(1000);
		
		//Select Compare Time 3
		repts.Select_CompareTime3();
				
		//Select Compare Time 3 Time Period as Today
		repts.Select_Date_Range_withoutTimePeriod("01/08/2023","30/08/2023",3);
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
	       
//        je.executeScript("arguments[0].scrollIntoView(true);",repts.ApplyButton());
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).click();
		for(int i=1;i<=5;i++)
		{
			
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		Thread.sleep(1000);
		}
		Thread.sleep(1000);
		//Click the Apply button
		repts.Click_ApplyButton();
		
		Thread.sleep(5000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Comparison Report Not Available for Compare Time 1 (Date Range), Compare Time 2 (Date Range) & Compare Time 3 (Date Range)");
		
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Comparison Report Available for Compare Time 1 (Date Range), Compare Time 2 (Date Range) & Compare Time 3 (Date Range) ");

			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
		List<WebElement> rowList=driver.findElements(By.xpath("//table/tr"));
		
//		List<WebElement> headList=driver.findElements(By.xpath("//table/tr[1]/th"));
		
		//List<WebElement> colList=driver.findElements(By.xpath("//table/tr[2]/td"));
		
		test.log(LogStatus.INFO, "Compare Time 1 "+"     -vs-     "+" Compare Time 2");
		
			for(int i=1;i<=rowList.size();i++)
			{
			
				if(i==1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
				
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/th[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/th[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[3]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[4]")).getText());
//					}
				}
				else if(i>1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
					
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/td[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/td[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[3]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[4]")).getText());
//					}
				}
			
			
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}
		
		
		}
		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Comparison_Sale_Report_Comp1_SpecificDate_Comp2_SpecificDate_Comp3_SpecificDate_Comp4_SpecificDate(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Compare Time 1
		repts.Select_CompareTime1();
		
		//Select Compare Time 1 Time Period as Today
		repts.Select_Specific_Date_withoutTimePeriod("20/09/2023",1);
		
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		Thread.sleep(1000);
		//Select Compare Time 2
		repts.Select_CompareTime2();
				
		//Select Compare Time 2 Time Period as Today
		repts.Select_Specific_Date_withoutTimePeriod("23/09/2023",2);
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		Thread.sleep(1000);
		//Click the Compare Time button
		repts.Click_Compare_Time();
		
		//Select Compare Time 3
		repts.Select_CompareTime3();
						
		//Select Compare Time 3 Time Period as Today
		repts.Select_Specific_Date_withoutTimePeriod("25/09/2023",3);
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		Thread.sleep(1000);
		//Select Compare Time 4
		repts.Select_CompareTime4();
						
		//Select Compare Time 3 Time Period as Today
		repts.Select_Specific_Date_withoutTimePeriod("26/09/2023",4);
					
					
		//Click the Apply button
		repts.Click_ApplyButton();
		
		Thread.sleep(5000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Comparison Report Not Available for Compare Time 1 (Specific Date), Compare Time 2 (Specific Date), Compare Time 3 (Specific Date) & Compare Time 4 (Specific Date)");
		
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Comparison Report Available for Compare Time 1 (Specific Date), Compare Time 2 (Specific Date), Compare Time 3 (Specific Date) & Compare Time 4 (Specific Date)");

			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
		List<WebElement> rowList=driver.findElements(By.xpath("//table/tr"));
		
//		List<WebElement> headList=driver.findElements(By.xpath("//table/tr[1]/th"));
		
		//List<WebElement> colList=driver.findElements(By.xpath("//table/tr[2]/td"));
		
		test.log(LogStatus.INFO, "Compare Time 1 "+"     -vs-     "+" Compare Time 2");
		
			for(int i=1;i<=rowList.size();i++)
			{
			
				if(i==1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
				
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/th[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/th[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[3]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[4]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[5]")).getText());
//					}
				}
				else if(i>1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
					
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/td[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/td[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[3]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[4]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[5]")).getText());
//					}
				}
			
			
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}
		
		
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Comparison_Sale_Report_Comp1_DateRange_Comp2_DateRange_Comp3_DateRange_Comp4_DateRange(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select Compare Time 1
		repts.Select_CompareTime1();
		
		//Select Compare Time 1 Time Period as Today
		repts.Select_Date_Range_withoutTimePeriod("01/05/2023","30/05/2023",1);
		
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		Thread.sleep(1000);
		//Select Compare Time 2
		repts.Select_CompareTime2();
				
		//Select Compare Time 2 Time Period as Today
		repts.Select_Date_Range_withoutTimePeriod("01/06/2023","30/06/2023",2);
		
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		Thread.sleep(1000);
		//Select Compare Time 3
		repts.Select_CompareTime3();
				
		//Select Compare Time 3 Time Period as Today
		repts.Select_Date_Range_withoutTimePeriod("01/07/2023","30/07/2023",3);
		
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		Thread.sleep(1000);
		//Select Compare Time 4
		repts.Select_CompareTime4();
				
		//Select Compare Time 4 Time Period as Today
		repts.Select_Date_Range_withoutTimePeriod("01/08/2023","30/08/2023",4);
	
				
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		Thread.sleep(1000);
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(1000);
		
		//Click the Apply button
		repts.Click_ApplyButton();
		
		Thread.sleep(5000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Comparison Report Not Available for Compare Time 1 (Date Range), Compare Time 2 (Date Range), Compare Time 3 (Date Range) & Compare Time 4 (Date Range)");
		
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Comparison Report Available for Compare Time 1 (Date Range), Compare Time 2 (Date Range), Compare Time 3 (Date Range) & Compare Time 4 (Date Range) ");

			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
		List<WebElement> rowList=driver.findElements(By.xpath("//table/tr"));
		
//		List<WebElement> headList=driver.findElements(By.xpath("//table/tr[1]/th"));
		
		//List<WebElement> colList=driver.findElements(By.xpath("//table/tr[2]/td"));
		
		test.log(LogStatus.INFO, "Compare Time 1 "+"     -vs-     "+" Compare Time 2");
		
			for(int i=1;i<=rowList.size();i++)
			{
			
				if(i==1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
				
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/th[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/th[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[3]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[4]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/th[5]")).getText());
//					}
				}
				else if(i>1)
				{
//					for(int j=1;j<=colList.size();j++)
//					{
					
						test.log(LogStatus.INFO, driver.findElement(By.xpath("//table/tr["+i+"]/td[1]")).getText()+" : "+driver.findElement(By.xpath("//table/tr["+i+"]/td[2]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[3]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[4]")).getText()+"     -vs-     "+ driver.findElement(By.xpath("//table/tr["+i+"]/td[5]")).getText());
//					}
				}
			
			
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}
		
		
		}
		
	}
}
