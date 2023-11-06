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
import com.epam.healenium.SelfHealingDriver;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExcelDataConfig;
import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports_Online_Sales_Report 
{

public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Online Sale Report");
	
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
		Open_OnlineSales_Report_Page(driver);
//		RefreshAndPaginination(driver);
		OnlineSales_Report_Today(driver);
		OnlineSales_Report_Yesterday(driver);
		OnlineSales_Report_Last_N_Days(driver);
		OnlineSales_Report_This_Week(driver);
		OnlineSales_Report_Last_Week(driver);
		OnlineSales_Report_Last_7_Days(driver);
		OnlineSales_Report_This_Month(driver);
		OnlineSales_Report_Last_Month(driver);
		OnlineSales_Report_Last_30_Days(driver);
		OnlineSales_Report_Specific_Date(driver);
		OnlineSales_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_OnlineSales_Report_Page(SelfHealingDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Menu Item sales report page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"salesReports/online-sales");

		Thread.sleep(5000);
		//Verify the Menu Item sales report page loeded or not
		repts.Verify_ReportHomePage("ONLINE SALES");
		
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
	public void SelectTheCat(SelfHealingDriver driver) throws Exception
	{
		Thread.sleep(5000);	
		//Click the source label
		driver.findElement(By.xpath("//span[contains(.,'Source')]/../input")).click();
		Thread.sleep(500);	
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
				
		Thread.sleep(500);
		//Click the Order Type label
		driver.findElement(By.xpath("(//span[contains(.,'Order Type')]/../input)[1]")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
		Thread.sleep(500);
		//Click the sub category label
		driver.findElement(By.xpath("(//span[contains(.,'Payment Type')]/../input)[1]")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
	}
	
	@Test(priority = 4,enabled = false)
	public void OnlineSales_Report_Today(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheCat(driver);
		
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[.='No Online Sales for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Today");
			excel.setreportData("Today", 2, 24, st);
			excel.setreportData("Today", 3, 24, st);
			excel.setreportData("Today", 4, 24, st);
			excel.setreportData("Today", 5, 24, st);
			excel.setreportData("Today", 6, 24, st);
			excel.setreportData("Today", 7, 24, st);
			excel.setreportData("Today", 8, 24, st);
			excel.setreportData("Today", 9, 24, st);
			excel.setreportData("Today", 10, 24, st);
			excel.setreportData("Today", 11, 24, st);
			excel.setreportData("Today", 12, 24, st);
			excel.setreportData("Today", 13, 24, st);
			
			excel.setreportData("Today", 2, 25, st);
			excel.setreportData("Today", 3, 25, st);
			excel.setreportData("Today", 4, 25, st);
			excel.setreportData("Today", 5, 25, st);
			excel.setreportData("Today", 6, 25, st);
			excel.setreportData("Today", 7, 25, st);
			excel.setreportData("Today", 8, 25, st);
			excel.setreportData("Today", 9, 25, st);
			excel.setreportData("Today", 10, 25, st);
			excel.setreportData("Today", 11, 25, st);
			excel.setreportData("Today", 12, 25, st);
			excel.setreportData("Today", 13, 25, st);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report Available for Today");
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			double sumNetSales = 0;
			double sumDiscount = 0;
			double sumTax = 0;
			double sumGrossReceipt = 0;
			
			for(int i = 1; i <= rowList.size();i++) {
				String NetSales=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[9]/span")).getText().replace(",", "");
				double NetSales_Amount=Double.parseDouble(NetSales);

				String Discount=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[10]/span")).getText().replace(",", "");
				double Discount_Amount=Double.parseDouble(Discount);
				
				String Tax=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[11]/span")).getText().replace(",", "");
				double Tax_Amount=Double.parseDouble(Tax);
				
				String GrossReceipt=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[14]/span")).getText().replace(",", "");
				double GrossReceipt_Amount=Double.parseDouble(GrossReceipt);
				
				sumNetSales = sumNetSales + NetSales_Amount;
				sumDiscount = sumDiscount + Discount_Amount;
				sumTax = sumTax + Tax_Amount;
				sumGrossReceipt = sumGrossReceipt + GrossReceipt_Amount;
			}
			
			String d = String.valueOf(sumNetSales);
			excel.setreportData("Today", 2, 24, d);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Online Sales report Available for the mentioned date totally "+rowList.size()+" orders available and the total Netsale value is : "+sumNetSales);		

			String d1 = String.valueOf(sumDiscount);
			excel.setreportData("Today", 4, 24, d1);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Discount value is : "+sumDiscount);		

			String d2 = String.valueOf(sumTax);
			excel.setreportData("Today", 3, 24, d2);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Tax value is : "+sumTax);		

			String d3 = String.valueOf(sumGrossReceipt);
			excel.setreportData("Today", 6, 24, d3);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Gross Recipt value is : "+sumGrossReceipt);		

				
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void OnlineSales_Report_Yesterday(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select Yesterday
		repts.Select_Yesterday_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[.='No Online Sales for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Yesterday");
			excel.setreportData("Yesterday", 2, 24, st);
			excel.setreportData("Yesterday", 3, 24, st);
			excel.setreportData("Yesterday", 4, 24, st);
			excel.setreportData("Yesterday", 5, 24, st);
			excel.setreportData("Yesterday", 6, 24, st);
			excel.setreportData("Yesterday", 7, 24, st);
			excel.setreportData("Yesterday", 8, 24, st);
			excel.setreportData("Yesterday", 9, 24, st);
			excel.setreportData("Yesterday", 10, 24, st);
			excel.setreportData("Yesterday", 11, 24, st);
			excel.setreportData("Yesterday", 12, 24, st);
			excel.setreportData("Yesterday", 13, 24, st);

			excel.setreportData("Yesterday", 2, 25, st);
			excel.setreportData("Yesterday", 3, 25, st);
			excel.setreportData("Yesterday", 4, 25, st);
			excel.setreportData("Yesterday", 5, 25, st);
			excel.setreportData("Yesterday", 6, 25, st);
			excel.setreportData("Yesterday", 7, 25, st);
			excel.setreportData("Yesterday", 8, 25, st);
			excel.setreportData("Yesterday", 9, 25, st);
			excel.setreportData("Yesterday", 10, 25, st);
			excel.setreportData("Yesterday", 11, 25, st);
			excel.setreportData("Yesterday", 12, 25, st);
			excel.setreportData("Yesterday", 13, 25, st);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Sale Report Available for Yesterday");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();

			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			double sumNetSales = 0;
			double sumDiscount = 0;
			double sumTax = 0;
			double sumGrossReceipt = 0;

			for(int i = 1; i <= rowList.size();i++) {
				String NetSales=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[9]/span")).getText().replace(",", "");
				double NetSales_Amount=Double.parseDouble(NetSales);

				String Discount=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[10]/span")).getText().replace(",", "");
				double Discount_Amount=Double.parseDouble(Discount);

				String Tax=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[11]/span")).getText().replace(",", "");
				double Tax_Amount=Double.parseDouble(Tax);

				String GrossReceipt=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[14]/span")).getText().replace(",", "");
				double GrossReceipt_Amount=Double.parseDouble(GrossReceipt);

				sumNetSales = sumNetSales + NetSales_Amount;
				sumDiscount = sumDiscount + Discount_Amount;
				sumTax = sumTax + Tax_Amount;
				sumGrossReceipt = sumGrossReceipt + GrossReceipt_Amount;
			}

			String d = String.valueOf(sumNetSales);
			excel.setreportData("Yesterday", 2, 24, d);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Online Sales report Available for the mentioned date totally "+rowList.size()+" orders available and the total Netsale value is : "+sumNetSales);

			String d1 = String.valueOf(sumDiscount);
			excel.setreportData("Yesterday", 4, 24, d1);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Discount value is : "+sumDiscount);

			String d2 = String.valueOf(sumTax);
			excel.setreportData("Yesterday", 3, 24, d2);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Tax value is : "+sumTax);

			String d3 = String.valueOf(sumGrossReceipt);
			excel.setreportData("Yesterday", 6, 24, d3);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Gross Recipt value is : "+sumGrossReceipt);


			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}

	
	@Test(priority = 4,enabled = false)
	public void OnlineSales_Report_Last_N_Days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select Last N days
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[.='No Online Sales for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Last N days");
			excel.setreportData("Last N days", 2, 24, st);
			excel.setreportData("Last N days", 3, 24, st);
			excel.setreportData("Last N days", 4, 24, st);
			excel.setreportData("Last N days", 5, 24, st);
			excel.setreportData("Last N days", 6, 24, st);
			excel.setreportData("Last N days", 7, 24, st);
			excel.setreportData("Last N days", 8, 24, st);
			excel.setreportData("Last N days", 9, 24, st);
			excel.setreportData("Last N days", 10, 24, st);
			excel.setreportData("Last N days", 11, 24, st);
			excel.setreportData("Last N days", 12, 24, st);
			excel.setreportData("Last N days", 13, 24, st);

			excel.setreportData("Last N days", 2, 25, st);
			excel.setreportData("Last N days", 3, 25, st);
			excel.setreportData("Last N days", 4, 25, st);
			excel.setreportData("Last N days", 5, 25, st);
			excel.setreportData("Last N days", 6, 25, st);
			excel.setreportData("Last N days", 7, 25, st);
			excel.setreportData("Last N days", 8, 25, st);
			excel.setreportData("Last N days", 9, 25, st);
			excel.setreportData("Last N days", 10, 25, st);
			excel.setreportData("Last N days", 11, 25, st);
			excel.setreportData("Last N days", 12, 25, st);
			excel.setreportData("Last N days", 13, 25, st);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Sale Report Available for Last N days");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();

			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			double sumNetSales = 0;
			double sumDiscount = 0;
			double sumTax = 0;
			double sumGrossReceipt = 0;

			for(int i = 1; i <= rowList.size();i++) {
				String NetSales=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[9]/span")).getText().replace(",", "");
				double NetSales_Amount=Double.parseDouble(NetSales);

				String Discount=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[10]/span")).getText().replace(",", "");
				double Discount_Amount=Double.parseDouble(Discount);

				String Tax=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[11]/span")).getText().replace(",", "");
				double Tax_Amount=Double.parseDouble(Tax);

				String GrossReceipt=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[14]/span")).getText().replace(",", "");
				double GrossReceipt_Amount=Double.parseDouble(GrossReceipt);

				sumNetSales = sumNetSales + NetSales_Amount;
				sumDiscount = sumDiscount + Discount_Amount;
				sumTax = sumTax + Tax_Amount;
				sumGrossReceipt = sumGrossReceipt + GrossReceipt_Amount;
			}

			String d = String.valueOf(sumNetSales);
			excel.setreportData("Last N days", 2, 24, d);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Online Sales report Available for the mentioned date totally "+rowList.size()+" orders available and the total Netsale value is : "+sumNetSales);

			String d1 = String.valueOf(sumDiscount);
			excel.setreportData("Last N days", 4, 24, d1);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Discount value is : "+sumDiscount);

			String d2 = String.valueOf(sumTax);
			excel.setreportData("Last N days", 3, 24, d2);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Tax value is : "+sumTax);

			String d3 = String.valueOf(sumGrossReceipt);
			excel.setreportData("Last N days", 6, 24, d3);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Gross Recipt value is : "+sumGrossReceipt);


			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void OnlineSales_Report_This_Week(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select This Week
		repts.Select_This_Week_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[.='No Online Sales for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for This Week");
			excel.setreportData("This Week", 2, 24, st);
			excel.setreportData("This Week", 3, 24, st);
			excel.setreportData("This Week", 4, 24, st);
			excel.setreportData("This Week", 5, 24, st);
			excel.setreportData("This Week", 6, 24, st);
			excel.setreportData("This Week", 7, 24, st);
			excel.setreportData("This Week", 8, 24, st);
			excel.setreportData("This Week", 9, 24, st);
			excel.setreportData("This Week", 10, 24, st);
			excel.setreportData("This Week", 11, 24, st);
			excel.setreportData("This Week", 12, 24, st);
			excel.setreportData("This Week", 13, 24, st);

			excel.setreportData("This Week", 2, 25, st);
			excel.setreportData("This Week", 3, 25, st);
			excel.setreportData("This Week", 4, 25, st);
			excel.setreportData("This Week", 5, 25, st);
			excel.setreportData("This Week", 6, 25, st);
			excel.setreportData("This Week", 7, 25, st);
			excel.setreportData("This Week", 8, 25, st);
			excel.setreportData("This Week", 9, 25, st);
			excel.setreportData("This Week", 10, 25, st);
			excel.setreportData("This Week", 11, 25, st);
			excel.setreportData("This Week", 12, 25, st);
			excel.setreportData("This Week", 13, 25, st);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Sale Report Available for This Week");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();

			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			double sumNetSales = 0;
			double sumDiscount = 0;
			double sumTax = 0;
			double sumGrossReceipt = 0;

			for(int i = 1; i <= rowList.size();i++) {
				String NetSales=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[9]/span")).getText().replace(",", "");
				double NetSales_Amount=Double.parseDouble(NetSales);

				String Discount=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[10]/span")).getText().replace(",", "");
				double Discount_Amount=Double.parseDouble(Discount);

				String Tax=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[11]/span")).getText().replace(",", "");
				double Tax_Amount=Double.parseDouble(Tax);

				String GrossReceipt=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[14]/span")).getText().replace(",", "");
				double GrossReceipt_Amount=Double.parseDouble(GrossReceipt);

				sumNetSales = sumNetSales + NetSales_Amount;
				sumDiscount = sumDiscount + Discount_Amount;
				sumTax = sumTax + Tax_Amount;
				sumGrossReceipt = sumGrossReceipt + GrossReceipt_Amount;
			}

			String d = String.valueOf(sumNetSales);
			excel.setreportData("This Week", 2, 24, d);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Online Sales report Available for the mentioned date totally "+rowList.size()+" orders available and the total Netsale value is : "+sumNetSales);

			String d1 = String.valueOf(sumDiscount);
			excel.setreportData("This Week", 4, 24, d1);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Discount value is : "+sumDiscount);

			String d2 = String.valueOf(sumTax);
			excel.setreportData("This Week", 3, 24, d2);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Tax value is : "+sumTax);

			String d3 = String.valueOf(sumGrossReceipt);
			excel.setreportData("This Week", 6, 24, d3);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Gross Recipt value is : "+sumGrossReceipt);


			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void OnlineSales_Report_Last_Week(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select Last Week
		repts.Select_Last_Week_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[.='No Online Sales for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Last Week");
			excel.setreportData("Last Week", 2, 24, st);
			excel.setreportData("Last Week", 3, 24, st);
			excel.setreportData("Last Week", 4, 24, st);
			excel.setreportData("Last Week", 5, 24, st);
			excel.setreportData("Last Week", 6, 24, st);
			excel.setreportData("Last Week", 7, 24, st);
			excel.setreportData("Last Week", 8, 24, st);
			excel.setreportData("Last Week", 9, 24, st);
			excel.setreportData("Last Week", 10, 24, st);
			excel.setreportData("Last Week", 11, 24, st);
			excel.setreportData("Last Week", 12, 24, st);
			excel.setreportData("Last Week", 13, 24, st);

			excel.setreportData("Last Week", 2, 25, st);
			excel.setreportData("Last Week", 3, 25, st);
			excel.setreportData("Last Week", 4, 25, st);
			excel.setreportData("Last Week", 5, 25, st);
			excel.setreportData("Last Week", 6, 25, st);
			excel.setreportData("Last Week", 7, 25, st);
			excel.setreportData("Last Week", 8, 25, st);
			excel.setreportData("Last Week", 9, 25, st);
			excel.setreportData("Last Week", 10, 25, st);
			excel.setreportData("Last Week", 11, 25, st);
			excel.setreportData("Last Week", 12, 25, st);
			excel.setreportData("Last Week", 13, 25, st);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Sale Report Available for Last Week");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();

			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			double sumNetSales = 0;
			double sumDiscount = 0;
			double sumTax = 0;
			double sumGrossReceipt = 0;

			for(int i = 1; i <= rowList.size();i++) {
				String NetSales=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[9]/span")).getText().replace(",", "");
				double NetSales_Amount=Double.parseDouble(NetSales);

				String Discount=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[10]/span")).getText().replace(",", "");
				double Discount_Amount=Double.parseDouble(Discount);

				String Tax=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[11]/span")).getText().replace(",", "");
				double Tax_Amount=Double.parseDouble(Tax);

				String GrossReceipt=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[14]/span")).getText().replace(",", "");
				double GrossReceipt_Amount=Double.parseDouble(GrossReceipt);

				sumNetSales = sumNetSales + NetSales_Amount;
				sumDiscount = sumDiscount + Discount_Amount;
				sumTax = sumTax + Tax_Amount;
				sumGrossReceipt = sumGrossReceipt + GrossReceipt_Amount;
			}

			String d = String.valueOf(sumNetSales);
			excel.setreportData("Last Week", 2, 24, d);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Online Sales report Available for the mentioned date totally "+rowList.size()+" orders available and the total Netsale value is : "+sumNetSales);

			String d1 = String.valueOf(sumDiscount);
			excel.setreportData("Last Week", 4, 24, d1);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Discount value is : "+sumDiscount);

			String d2 = String.valueOf(sumTax);
			excel.setreportData("Last Week", 3, 24, d2);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Tax value is : "+sumTax);

			String d3 = String.valueOf(sumGrossReceipt);
			excel.setreportData("Last Week", 6, 24, d3);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Gross Recipt value is : "+sumGrossReceipt);


			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void OnlineSales_Report_Last_7_Days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select Last 7 days
		repts.Select_Last_7_Days_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[.='No Online Sales for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Last 7 days");
			excel.setreportData("Last 7 days", 2, 24, st);
			excel.setreportData("Last 7 days", 3, 24, st);
			excel.setreportData("Last 7 days", 4, 24, st);
			excel.setreportData("Last 7 days", 5, 24, st);
			excel.setreportData("Last 7 days", 6, 24, st);
			excel.setreportData("Last 7 days", 7, 24, st);
			excel.setreportData("Last 7 days", 8, 24, st);
			excel.setreportData("Last 7 days", 9, 24, st);
			excel.setreportData("Last 7 days", 10, 24, st);
			excel.setreportData("Last 7 days", 11, 24, st);
			excel.setreportData("Last 7 days", 12, 24, st);
			excel.setreportData("Last 7 days", 13, 24, st);

			excel.setreportData("Last 7 days", 2, 25, st);
			excel.setreportData("Last 7 days", 3, 25, st);
			excel.setreportData("Last 7 days", 4, 25, st);
			excel.setreportData("Last 7 days", 5, 25, st);
			excel.setreportData("Last 7 days", 6, 25, st);
			excel.setreportData("Last 7 days", 7, 25, st);
			excel.setreportData("Last 7 days", 8, 25, st);
			excel.setreportData("Last 7 days", 9, 25, st);
			excel.setreportData("Last 7 days", 10, 25, st);
			excel.setreportData("Last 7 days", 11, 25, st);
			excel.setreportData("Last 7 days", 12, 25, st);
			excel.setreportData("Last 7 days", 13, 25, st);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Sale Report Available for Last 7 days");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();

			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			double sumNetSales = 0;
			double sumDiscount = 0;
			double sumTax = 0;
			double sumGrossReceipt = 0;

			for(int i = 1; i <= rowList.size();i++) {
				String NetSales=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[9]/span")).getText().replace(",", "");
				double NetSales_Amount=Double.parseDouble(NetSales);

				String Discount=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[10]/span")).getText().replace(",", "");
				double Discount_Amount=Double.parseDouble(Discount);

				String Tax=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[11]/span")).getText().replace(",", "");
				double Tax_Amount=Double.parseDouble(Tax);

				String GrossReceipt=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[14]/span")).getText().replace(",", "");
				double GrossReceipt_Amount=Double.parseDouble(GrossReceipt);

				sumNetSales = sumNetSales + NetSales_Amount;
				sumDiscount = sumDiscount + Discount_Amount;
				sumTax = sumTax + Tax_Amount;
				sumGrossReceipt = sumGrossReceipt + GrossReceipt_Amount;
			}

			String d = String.valueOf(sumNetSales);
			excel.setreportData("Last 7 days", 2, 24, d);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Online Sales report Available for the mentioned date totally "+rowList.size()+" orders available and the total Netsale value is : "+sumNetSales);

			String d1 = String.valueOf(sumDiscount);
			excel.setreportData("Last 7 days", 4, 24, d1);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Discount value is : "+sumDiscount);

			String d2 = String.valueOf(sumTax);
			excel.setreportData("Last 7 days", 3, 24, d2);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Tax value is : "+sumTax);

			String d3 = String.valueOf(sumGrossReceipt);
			excel.setreportData("Last 7 days", 6, 24, d3);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Gross Recipt value is : "+sumGrossReceipt);


			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void OnlineSales_Report_This_Month(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select This month
		repts.Select_This_Month_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[.='No Online Sales for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for This month");
			excel.setreportData("This month", 2, 24, st);
			excel.setreportData("This month", 3, 24, st);
			excel.setreportData("This month", 4, 24, st);
			excel.setreportData("This month", 5, 24, st);
			excel.setreportData("This month", 6, 24, st);
			excel.setreportData("This month", 7, 24, st);
			excel.setreportData("This month", 8, 24, st);
			excel.setreportData("This month", 9, 24, st);
			excel.setreportData("This month", 10, 24, st);
			excel.setreportData("This month", 11, 24, st);
			excel.setreportData("This month", 12, 24, st);
			excel.setreportData("This month", 13, 24, st);

			excel.setreportData("This month", 2, 25, st);
			excel.setreportData("This month", 3, 25, st);
			excel.setreportData("This month", 4, 25, st);
			excel.setreportData("This month", 5, 25, st);
			excel.setreportData("This month", 6, 25, st);
			excel.setreportData("This month", 7, 25, st);
			excel.setreportData("This month", 8, 25, st);
			excel.setreportData("This month", 9, 25, st);
			excel.setreportData("This month", 10, 25, st);
			excel.setreportData("This month", 11, 25, st);
			excel.setreportData("This month", 12, 25, st);
			excel.setreportData("This month", 13, 25, st);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Sale Report Available for This month");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();

			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			double sumNetSales = 0;
			double sumDiscount = 0;
			double sumTax = 0;
			double sumGrossReceipt = 0;

			for(int i = 1; i <= rowList.size();i++) {
				String NetSales=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[9]/span")).getText().replace(",", "");
				double NetSales_Amount=Double.parseDouble(NetSales);

				String Discount=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[10]/span")).getText().replace(",", "");
				double Discount_Amount=Double.parseDouble(Discount);

				String Tax=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[11]/span")).getText().replace(",", "");
				double Tax_Amount=Double.parseDouble(Tax);

				String GrossReceipt=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[14]/span")).getText().replace(",", "");
				double GrossReceipt_Amount=Double.parseDouble(GrossReceipt);

				sumNetSales = sumNetSales + NetSales_Amount;
				sumDiscount = sumDiscount + Discount_Amount;
				sumTax = sumTax + Tax_Amount;
				sumGrossReceipt = sumGrossReceipt + GrossReceipt_Amount;
			}

			String d = String.valueOf(sumNetSales);
			excel.setreportData("This month", 2, 24, d);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Online Sales report Available for the mentioned date totally "+rowList.size()+" orders available and the total Netsale value is : "+sumNetSales);

			String d1 = String.valueOf(sumDiscount);
			excel.setreportData("This month", 4, 24, d1);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Discount value is : "+sumDiscount);

			String d2 = String.valueOf(sumTax);
			excel.setreportData("This month", 3, 24, d2);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Tax value is : "+sumTax);

			String d3 = String.valueOf(sumGrossReceipt);
			excel.setreportData("This month", 6, 24, d3);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Gross Recipt value is : "+sumGrossReceipt);


			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void OnlineSales_Report_Last_Month(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select Last month
		repts.Select_Last_Month_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[.='No Online Sales for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Last month");
			excel.setreportData("Last month", 2, 24, st);
			excel.setreportData("Last month", 3, 24, st);
			excel.setreportData("Last month", 4, 24, st);
			excel.setreportData("Last month", 5, 24, st);
			excel.setreportData("Last month", 6, 24, st);
			excel.setreportData("Last month", 7, 24, st);
			excel.setreportData("Last month", 8, 24, st);
			excel.setreportData("Last month", 9, 24, st);
			excel.setreportData("Last month", 10, 24, st);
			excel.setreportData("Last month", 11, 24, st);
			excel.setreportData("Last month", 12, 24, st);
			excel.setreportData("Last month", 13, 24, st);

			excel.setreportData("Last month", 2, 25, st);
			excel.setreportData("Last month", 3, 25, st);
			excel.setreportData("Last month", 4, 25, st);
			excel.setreportData("Last month", 5, 25, st);
			excel.setreportData("Last month", 6, 25, st);
			excel.setreportData("Last month", 7, 25, st);
			excel.setreportData("Last month", 8, 25, st);
			excel.setreportData("Last month", 9, 25, st);
			excel.setreportData("Last month", 10, 25, st);
			excel.setreportData("Last month", 11, 25, st);
			excel.setreportData("Last month", 12, 25, st);
			excel.setreportData("Last month", 13, 25, st);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Sale Report Available for Last month");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();

			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			double sumNetSales = 0;
			double sumDiscount = 0;
			double sumTax = 0;
			double sumGrossReceipt = 0;

			for(int i = 1; i <= rowList.size();i++) {
				String NetSales=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[9]/span")).getText().replace(",", "");
				double NetSales_Amount=Double.parseDouble(NetSales);

				String Discount=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[10]/span")).getText().replace(",", "");
				double Discount_Amount=Double.parseDouble(Discount);

				String Tax=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[11]/span")).getText().replace(",", "");
				double Tax_Amount=Double.parseDouble(Tax);

				String GrossReceipt=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[14]/span")).getText().replace(",", "");
				double GrossReceipt_Amount=Double.parseDouble(GrossReceipt);

				sumNetSales = sumNetSales + NetSales_Amount;
				sumDiscount = sumDiscount + Discount_Amount;
				sumTax = sumTax + Tax_Amount;
				sumGrossReceipt = sumGrossReceipt + GrossReceipt_Amount;
			}

			String d = String.valueOf(sumNetSales);
			excel.setreportData("Last month", 2, 24, d);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Online Sales report Available for the mentioned date totally "+rowList.size()+" orders available and the total Netsale value is : "+sumNetSales);

			String d1 = String.valueOf(sumDiscount);
			excel.setreportData("Last month", 4, 24, d1);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Discount value is : "+sumDiscount);

			String d2 = String.valueOf(sumTax);
			excel.setreportData("Last month", 3, 24, d2);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Tax value is : "+sumTax);

			String d3 = String.valueOf(sumGrossReceipt);
			excel.setreportData("Last month", 6, 24, d3);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Gross Recipt value is : "+sumGrossReceipt);


			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void OnlineSales_Report_Last_30_Days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select Last 30 days
		repts.Select_Last_30_Days_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[.='No Online Sales for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Last 30 days");
			excel.setreportData("Last 30 days", 2, 24, st);
			excel.setreportData("Last 30 days", 3, 24, st);
			excel.setreportData("Last 30 days", 4, 24, st);
			excel.setreportData("Last 30 days", 5, 24, st);
			excel.setreportData("Last 30 days", 6, 24, st);
			excel.setreportData("Last 30 days", 7, 24, st);
			excel.setreportData("Last 30 days", 8, 24, st);
			excel.setreportData("Last 30 days", 9, 24, st);
			excel.setreportData("Last 30 days", 10, 24, st);
			excel.setreportData("Last 30 days", 11, 24, st);
			excel.setreportData("Last 30 days", 12, 24, st);
			excel.setreportData("Last 30 days", 13, 24, st);

			excel.setreportData("Last 30 days", 2, 25, st);
			excel.setreportData("Last 30 days", 3, 25, st);
			excel.setreportData("Last 30 days", 4, 25, st);
			excel.setreportData("Last 30 days", 5, 25, st);
			excel.setreportData("Last 30 days", 6, 25, st);
			excel.setreportData("Last 30 days", 7, 25, st);
			excel.setreportData("Last 30 days", 8, 25, st);
			excel.setreportData("Last 30 days", 9, 25, st);
			excel.setreportData("Last 30 days", 10, 25, st);
			excel.setreportData("Last 30 days", 11, 25, st);
			excel.setreportData("Last 30 days", 12, 25, st);
			excel.setreportData("Last 30 days", 13, 25, st);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Sale Report Available for Last 30 days");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();

			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			double sumNetSales = 0;
			double sumDiscount = 0;
			double sumTax = 0;
			double sumGrossReceipt = 0;

			for(int i = 1; i <= rowList.size();i++) {
				String NetSales=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[9]/span")).getText().replace(",", "");
				double NetSales_Amount=Double.parseDouble(NetSales);

				String Discount=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[10]/span")).getText().replace(",", "");
				double Discount_Amount=Double.parseDouble(Discount);

				String Tax=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[11]/span")).getText().replace(",", "");
				double Tax_Amount=Double.parseDouble(Tax);

				String GrossReceipt=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[14]/span")).getText().replace(",", "");
				double GrossReceipt_Amount=Double.parseDouble(GrossReceipt);

				sumNetSales = sumNetSales + NetSales_Amount;
				sumDiscount = sumDiscount + Discount_Amount;
				sumTax = sumTax + Tax_Amount;
				sumGrossReceipt = sumGrossReceipt + GrossReceipt_Amount;
			}

			String d = String.valueOf(sumNetSales);
			excel.setreportData("Last 30 days", 2, 24, d);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Online Sales report Available for the mentioned date totally "+rowList.size()+" orders available and the total Netsale value is : "+sumNetSales);

			String d1 = String.valueOf(sumDiscount);
			excel.setreportData("Last 30 days", 4, 24, d1);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Discount value is : "+sumDiscount);

			String d2 = String.valueOf(sumTax);
			excel.setreportData("Last 30 days", 3, 24, d2);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Tax value is : "+sumTax);

			String d3 = String.valueOf(sumGrossReceipt);
			excel.setreportData("Last 30 days", 6, 24, d3);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Gross Recipt value is : "+sumGrossReceipt);


			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void OnlineSales_Report_Specific_Date(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select Specific Date
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[.='No Online Sales for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Specific Date");
			excel.setreportData("Specific Date", 2, 24, st);
			excel.setreportData("Specific Date", 3, 24, st);
			excel.setreportData("Specific Date", 4, 24, st);
			excel.setreportData("Specific Date", 5, 24, st);
			excel.setreportData("Specific Date", 6, 24, st);
			excel.setreportData("Specific Date", 7, 24, st);
			excel.setreportData("Specific Date", 8, 24, st);
			excel.setreportData("Specific Date", 9, 24, st);
			excel.setreportData("Specific Date", 10, 24, st);
			excel.setreportData("Specific Date", 11, 24, st);
			excel.setreportData("Specific Date", 12, 24, st);
			excel.setreportData("Specific Date", 13, 24, st);

			excel.setreportData("Specific Date", 2, 25, st);
			excel.setreportData("Specific Date", 3, 25, st);
			excel.setreportData("Specific Date", 4, 25, st);
			excel.setreportData("Specific Date", 5, 25, st);
			excel.setreportData("Specific Date", 6, 25, st);
			excel.setreportData("Specific Date", 7, 25, st);
			excel.setreportData("Specific Date", 8, 25, st);
			excel.setreportData("Specific Date", 9, 25, st);
			excel.setreportData("Specific Date", 10, 25, st);
			excel.setreportData("Specific Date", 11, 25, st);
			excel.setreportData("Specific Date", 12, 25, st);
			excel.setreportData("Specific Date", 13, 25, st);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Sale Report Available for Specific Date");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();

			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			double sumNetSales = 0;
			double sumDiscount = 0;
			double sumTax = 0;
			double sumGrossReceipt = 0;

			for(int i = 1; i <= rowList.size();i++) {
				String NetSales=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[9]/span")).getText().replace(",", "");
				double NetSales_Amount=Double.parseDouble(NetSales);

				String Discount=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[10]/span")).getText().replace(",", "");
				double Discount_Amount=Double.parseDouble(Discount);

				String Tax=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[11]/span")).getText().replace(",", "");
				double Tax_Amount=Double.parseDouble(Tax);

				String GrossReceipt=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[14]/span")).getText().replace(",", "");
				double GrossReceipt_Amount=Double.parseDouble(GrossReceipt);

				sumNetSales = sumNetSales + NetSales_Amount;
				sumDiscount = sumDiscount + Discount_Amount;
				sumTax = sumTax + Tax_Amount;
				sumGrossReceipt = sumGrossReceipt + GrossReceipt_Amount;
			}

			String d = String.valueOf(sumNetSales);
			excel.setreportData("Specific Date", 2, 24, d);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Online Sales report Available for the mentioned date totally "+rowList.size()+" orders available and the total Netsale value is : "+sumNetSales);

			String d1 = String.valueOf(sumDiscount);
			excel.setreportData("Specific Date", 4, 24, d1);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Discount value is : "+sumDiscount);

			String d2 = String.valueOf(sumTax);
			excel.setreportData("Specific Date", 3, 24, d2);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Tax value is : "+sumTax);

			String d3 = String.valueOf(sumGrossReceipt);
			excel.setreportData("Specific Date", 6, 24, d3);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Gross Recipt value is : "+sumGrossReceipt);


			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void OnlineSales_Report_Date_Range(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);

		//Select Date Range
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[.='No Online Sales for selected time period']")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Date Range");
			excel.setreportData("Date Range", 2, 24, st);
			excel.setreportData("Date Range", 3, 24, st);
			excel.setreportData("Date Range", 4, 24, st);
			excel.setreportData("Date Range", 5, 24, st);
			excel.setreportData("Date Range", 6, 24, st);
			excel.setreportData("Date Range", 7, 24, st);
			excel.setreportData("Date Range", 8, 24, st);
			excel.setreportData("Date Range", 9, 24, st);
			excel.setreportData("Date Range", 10, 24, st);
			excel.setreportData("Date Range", 11, 24, st);
			excel.setreportData("Date Range", 12, 24, st);
			excel.setreportData("Date Range", 13, 24, st);

			excel.setreportData("Date Range", 2, 25, st);
			excel.setreportData("Date Range", 3, 25, st);
			excel.setreportData("Date Range", 4, 25, st);
			excel.setreportData("Date Range", 5, 25, st);
			excel.setreportData("Date Range", 6, 25, st);
			excel.setreportData("Date Range", 7, 25, st);
			excel.setreportData("Date Range", 8, 25, st);
			excel.setreportData("Date Range", 9, 25, st);
			excel.setreportData("Date Range", 10, 25, st);
			excel.setreportData("Date Range", 11, 25, st);
			excel.setreportData("Date Range", 12, 25, st);
			excel.setreportData("Date Range", 13, 25, st);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Sale Report Available for Date Range");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();

			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			double sumNetSales = 0;
			double sumDiscount = 0;
			double sumTax = 0;
			double sumGrossReceipt = 0;

			for(int i = 1; i <= rowList.size();i++) {
				String NetSales=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[9]/span")).getText().replace(",", "");
				double NetSales_Amount=Double.parseDouble(NetSales);

				String Discount=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[10]/span")).getText().replace(",", "");
				double Discount_Amount=Double.parseDouble(Discount);

				String Tax=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[11]/span")).getText().replace(",", "");
				double Tax_Amount=Double.parseDouble(Tax);

				String GrossReceipt=driver.findElement(By.xpath("//data-grid/div/div/div["+i+"]/div[@class='content-container']/data-grid-row/div/div[14]/span")).getText().replace(",", "");
				double GrossReceipt_Amount=Double.parseDouble(GrossReceipt);

				sumNetSales = sumNetSales + NetSales_Amount;
				sumDiscount = sumDiscount + Discount_Amount;
				sumTax = sumTax + Tax_Amount;
				sumGrossReceipt = sumGrossReceipt + GrossReceipt_Amount;
			}

			String d = String.valueOf(sumNetSales);
			excel.setreportData("Date Range", 2, 24, d);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Online Sales report Available for the mentioned date totally "+rowList.size()+" orders available and the total Netsale value is : "+sumNetSales);

			String d1 = String.valueOf(sumDiscount);
			excel.setreportData("Date Range", 4, 24, d1);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Discount value is : "+sumDiscount);

			String d2 = String.valueOf(sumTax);
			excel.setreportData("Date Range", 3, 24, d2);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Tax value is : "+sumTax);

			String d3 = String.valueOf(sumGrossReceipt);
			excel.setreportData("Date Range", 6, 24, d3);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
			test.log(LogStatus.INFO, "Future Order Sale report Available for the mentioned date totally "+rowList.size()+" orders available and the total Gross Recipt value is : "+sumGrossReceipt);


			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}
	
}
