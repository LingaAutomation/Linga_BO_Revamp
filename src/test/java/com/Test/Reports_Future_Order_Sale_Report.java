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

import com.Pages.ReportsPage;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExcelDataConfig;
import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports_Future_Order_Sale_Report 
{
	
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Future Order Sale Report");
	
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
		//Open the Chrome window
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().driverVersion("110.0.5481").setup();
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
		Open_FutureOrder_Report_Page(driver);
//		RefreshAndPaginination(driver);
		FutureOrder_Sale_Report(driver);

	}
	
	@Test(priority = 3,enabled = false)
	public void Open_FutureOrder_Report_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(10000);
		//Load the Sale Summarys report page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"salesReports/future-orders");

		Thread.sleep(5000);
		//Verify the Sale Summarys report page loeded or not
		repts.Verify_ReportHomePage("FUTURE ORDER");
		
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
	public void FutureOrder_Sale_Report(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);
		
		//Enter the Check number
		//driver.findElement(By.xpath("//label[contains(.,'Check Number')]/../../input")).clear();
		//driver.findElement(By.xpath("//label[contains(.,'Check Number')]/../../input")).sendKeys(Utility.getProperty("FutureOrderCheckNum"));
		
		//Select the order date
		driver.findElement(By.xpath("//label[contains(.,'Order Date')]/../../..//mat-datepicker-toggle/button")).click();
		
		String FromDate = Utility.getProperty("FutureOrderDate");
				
				driver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).click();
				String year = FromDate.substring(6,10);
		
				driver.findElement(By.xpath("//div[contains(.,'"+year+"') and contains(@class,'mat-calendar-body-today')]")).click();
						
				String months = FromDate.substring(3,5);
				String month = repts.selectMonth(months);
				
				driver.findElement(By.xpath("//div[contains(.,'"+month+"') and contains(@class,'mat-calendar-body')]")).click();
				
				String days = FromDate.substring(0,2);
				String day = repts.selectDate(days);
				
				driver.findElement(By.xpath("//div[contains(.,'"+day+"') and contains(@class,'mat-calendar-body')]")).click();
				
				//Date_inSpecificDateInputBx.clear();
				Thread.sleep(500);
				
				
				
				//Start_DateInputBx.sendKeys(FromDate);
				
				Thread.sleep(1000);
				//select the delivery
				driver.findElement(By.xpath("//label[contains(.,'Delivery Date')]/../../..//mat-datepicker-toggle/button")).click();

				Thread.sleep(500);
				String ToDate = Utility.getProperty("FutureOrderDeliveryDate");
				
				driver.findElement(By.xpath("//button[@aria-label='Choose month and year']")).click();	
				String year1 = ToDate.substring(6,10);
				
				driver.findElement(By.xpath("//div[contains(.,'"+year1+"') and contains(@class,'mat-calendar-body-today')]")).click();
						
				String months1 = ToDate.substring(3,5);
				String month1 = repts.selectMonth(months1);
				
				driver.findElement(By.xpath("//div[contains(.,'"+month1+"') and contains(@class,'mat-calendar-body')]")).click();
				
				String days1 = ToDate.substring(0,2);
				String day1 = repts.selectDate(days1);
				
				driver.findElement(By.xpath("//div[contains(.,'"+day1+"') and contains(@class,'mat-calendar-body')]")).click();

				Thread.sleep(500);
		

		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Today");
			excel.setreportData("Today", 2, 22, st);
			excel.setreportData("Today", 3, 22, st);
			excel.setreportData("Today", 4, 22, st);
			excel.setreportData("Today", 5, 22, st);
			excel.setreportData("Today", 6, 22, st);
			excel.setreportData("Today", 7, 22, st);
			excel.setreportData("Today", 8, 22, st);
			excel.setreportData("Today", 9, 22, st);
			excel.setreportData("Today", 10, 22, st);
			excel.setreportData("Today", 11, 22, st);
			excel.setreportData("Today", 12, 22, st);
			excel.setreportData("Today", 13, 22, st);
			
			excel.setreportData("Today", 2, 23, st);
			excel.setreportData("Today", 3, 23, st);
			excel.setreportData("Today", 4, 23, st);
			excel.setreportData("Today", 5, 23, st);
			excel.setreportData("Today", 6, 23, st);
			excel.setreportData("Today", 7, 23, st);
			excel.setreportData("Today", 8, 23, st);
			excel.setreportData("Today", 9, 23, st);
			excel.setreportData("Today", 10, 23, st);
			excel.setreportData("Today", 11, 23, st);
			excel.setreportData("Today", 12, 23, st);
			excel.setreportData("Today", 13, 23, st);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			List<WebElement> rowList=driver.findElements(By.xpath("//div/div/div/data-grid-row/div/div[2]/span"));
			
			double paidAmt = 0;
			for(int i = 1; i <= rowList.size();i++) {
				String s = driver.findElement(By.xpath("//div/div["+i+"]/div/data-grid-row/div/div[2]/span")).getText().replaceAll(",", "").replaceAll(" ", "");
				double s1 = Double.parseDouble(s);
				paidAmt = paidAmt + s1;
			}
			String d = String.valueOf(paidAmt);
			excel.setreportData("Today", 2, 22, d);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total paid value is : "+paidAmt);		
		}
	}

}
