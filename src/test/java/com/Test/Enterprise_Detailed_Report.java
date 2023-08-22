package com.Test;

import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
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

public class Enterprise_Detailed_Report 
{

public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise Reports - Enterprise Detailed Report");
	
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
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver(chrOpt);
		
		System.setProperty("webdriver.chrome.driver","./Automation Driver/chromedriver.exe");
		//Open the Chrome window
		driver = new ChromeDriver();
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
		Open_Enterprise_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Enterprise_Report_Today(driver);
		Enterprise_Report_Yesterday(driver);
		Enterprise_Report_Last_N_Days(driver);
		Enterprise_Report_This_Week(driver);
		Enterprise_Report_Last_Week(driver);
		Enterprise_Report_Last_7_Days(driver);
		Enterprise_Report_This_Month(driver);
		Enterprise_Report_Last_Month(driver);
		Enterprise_Report_Last_30_Days(driver);
		Enterprise_Report_Specific_Date(driver);
		Enterprise_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Enterprise_Report_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+"enterprise/enterpriseReports/saleReports/enterpriseReport");

		Thread.sleep(5000);
		try
		{
		//Verify the Categories page loaded or not
		repts.Verify_ReportHomePage("ENTERPRISE REPORT");
		}
		catch(Exception k)
		{
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
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
	public void Enterprise_Report_Today(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
	
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));

		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
	
			
			Thread.sleep(3000);

		
	}


	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Yesterday(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		//SelectTheCat(driver);

		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));
		
		//Select Yesterday
		repts.Select_Yesterday_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		
	}


	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Last_N_Days(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		//SelectTheCat(driver);
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));
		
		//Select Last N days
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		
	}

	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_This_Week(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		//SelectTheCat(driver);
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));
		
		//Select This Week
		repts.Select_This_Week_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Report Not Available for This Week");
			excel.setreportData("This Week", 2, 26, st);
			excel.setreportData("This Week", 3, 26, st);
			excel.setreportData("This Week", 4, 26, st);
			excel.setreportData("This Week", 7, 26, st);

			excel.setreportData("This Week", 2, 27, st);
			excel.setreportData("This Week", 3, 27, st);
			excel.setreportData("This Week", 4, 27, st);
			excel.setreportData("This Week", 7, 27, st);

			excel.setreportData("This Week", 39, 11, st);
			excel.setreportData("This Week", 40, 11, st);
			excel.setreportData("This Week", 41, 11, st);
			excel.setreportData("This Week", 44, 11, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Enterprise Report Available for This Week");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("This Week", 2, 1).toString().replace(",", "");
			double Expected_NetSaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Net Sales
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String NetSaleAmount=driver.findElement(By.xpath("//tfoot/tr/td[7]/div")).getText().replace(",", "");
			double ActualNetSale_Amount=Double.parseDouble(NetSaleAmount);

			//Export the Net Sales value to Excel
			excel.setreportData("This Week", 2, 26, NetSaleAmount);


			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSaleAmount==ActualNetSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sales for Enterprise Report is equal to Sale Recap Report for This Week");
				excel.setreport_PassedData("This Week", 2, 27, "0.00");
				excel.setreport_PassedData("This Week", 39, 11, NetSaleAmount+"`");
			}
			else
			{
				double diff=Expected_NetSaleAmount-ActualNetSale_Amount;
				test.log(LogStatus.FAIL, "Net Sales for Enterprise Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("This Week", 2, 27,diff_value);
				 excel.setreport_FailedData("This Week", 39, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("This Week", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tfoot/tr/td[6]/div")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("This Week", 3, 26, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Enterprise Report is equal to Sale Recap Report for This Week");
				excel.setreport_PassedData("This Week", 3, 27, "0.00");
				excel.setreport_PassedData("This Week", 40, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Enterprise Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("This Week", 3, 27,diff_value);
				 excel.setreport_FailedData("This Week", 40, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("This Week", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tfoot/tr/td[4]/div")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("This Week", 4, 26, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Enterprise Report is equal to Sale Recap Report for This Week");
				excel.setreport_PassedData("This Week", 4, 27, "0.00");
				excel.setreport_PassedData("This Week", 41, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Enterprise Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("This Week", 4, 27,diff_value);
				 excel.setreport_FailedData("This Week", 41, 11,diff_value);
			}

			//Get the Gross Sales from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("This Week", 7, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sales
			String GrossSale=driver.findElement(By.xpath("//tfoot/tr/td[2]/div")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("This Week", 7, 26, GrossSale);


			//Check whether the Gross Sales value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "Gross Sales for Enterprise Report is equal to Sale Recap Report for This Week");
				excel.setreport_PassedData("This Week", 7, 27, "0.00");
				excel.setreport_PassedData("This Week", 44, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "Gross Sales for Enterprise Report is not equal to Sale Recap Report  for This Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("This Week", 7, 27,diff_value);
				 excel.setreport_FailedData("This Week", 44, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Last_Week(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		//SelectTheCat(driver);
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));
		
		//Select Last Week
		repts.Select_Last_Week_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Report Not Available for Last Week");
			excel.setreportData("Last Week", 2, 26, st);
			excel.setreportData("Last Week", 3, 26, st);
			excel.setreportData("Last Week", 4, 26, st);
			excel.setreportData("Last Week", 7, 26, st);

			excel.setreportData("Last Week", 2, 27, st);
			excel.setreportData("Last Week", 3, 27, st);
			excel.setreportData("Last Week", 4, 27, st);
			excel.setreportData("Last Week", 7, 27, st);

			excel.setreportData("Last Week", 39, 11, st);
			excel.setreportData("Last Week", 40, 11, st);
			excel.setreportData("Last Week", 41, 11, st);
			excel.setreportData("Last Week", 44, 11, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Enterprise Report Available for Last Week");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last Week", 2, 1).toString().replace(",", "");
			double Expected_NetSaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Net Sales
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String NetSaleAmount=driver.findElement(By.xpath("//tfoot/tr/td[7]/div")).getText().replace(",", "");
			double ActualNetSale_Amount=Double.parseDouble(NetSaleAmount);

			//Export the Net Sales value to Excel
			excel.setreportData("Last Week", 2, 26, NetSaleAmount);


			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSaleAmount==ActualNetSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sales for Enterprise Report is equal to Sale Recap Report for Last Week");
				excel.setreport_PassedData("Last Week", 2, 27, "0.00");
				excel.setreport_PassedData("Last Week", 39, 11, NetSaleAmount+"`");
			}
			else
			{
				double diff=Expected_NetSaleAmount-ActualNetSale_Amount;
				test.log(LogStatus.FAIL, "Net Sales for Enterprise Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Last Week", 2, 27,diff_value);
				 excel.setreport_FailedData("Last Week", 39, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last Week", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tfoot/tr/td[6]/div")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last Week", 3, 26, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Enterprise Report is equal to Sale Recap Report for Last Week");
				excel.setreport_PassedData("Last Week", 3, 27, "0.00");
				excel.setreport_PassedData("Last Week", 40, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Enterprise Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Last Week", 3, 27,diff_value);
				 excel.setreport_FailedData("Last Week", 40, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Last Week", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tfoot/tr/td[4]/div")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Last Week", 4, 26, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Enterprise Report is equal to Sale Recap Report for Last Week");
				excel.setreport_PassedData("Last Week", 4, 27, "0.00");
				excel.setreport_PassedData("Last Week", 41, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Enterprise Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Last Week", 4, 27,diff_value);
				 excel.setreport_FailedData("Last Week", 41, 11,diff_value);
			}

			//Get the Gross Sales from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("Last Week", 7, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sales
			String GrossSale=driver.findElement(By.xpath("//tfoot/tr/td[2]/div")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("Last Week", 7, 26, GrossSale);


			//Check whether the Gross Sales value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "Gross Sales for Enterprise Report is equal to Sale Recap Report for Last Week");
				excel.setreport_PassedData("Last Week", 7, 27, "0.00");
				excel.setreport_PassedData("Last Week", 44, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "Gross Sales for Enterprise Report is not equal to Sale Recap Report  for Last Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Last Week", 7, 27,diff_value);
				 excel.setreport_FailedData("Last Week", 44, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Last_7_Days(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		//SelectTheCat(driver);
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));
		
		//Select Last 7 days
		repts.Select_Last_7_Days_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Report Not Available for Last 7 days");
			excel.setreportData("Last 7 days", 2, 26, st);
			excel.setreportData("Last 7 days", 3, 26, st);
			excel.setreportData("Last 7 days", 4, 26, st);
			excel.setreportData("Last 7 days", 7, 26, st);

			excel.setreportData("Last 7 days", 2, 27, st);
			excel.setreportData("Last 7 days", 3, 27, st);
			excel.setreportData("Last 7 days", 4, 27, st);
			excel.setreportData("Last 7 days", 7, 27, st);

			excel.setreportData("Last 7 days", 39, 11, st);
			excel.setreportData("Last 7 days", 40, 11, st);
			excel.setreportData("Last 7 days", 41, 11, st);
			excel.setreportData("Last 7 days", 44, 11, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Enterprise Report Available for Last 7 days");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last 7 days", 2, 1).toString().replace(",", "");
			double Expected_NetSaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Net Sales
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String NetSaleAmount=driver.findElement(By.xpath("//tfoot/tr/td[7]/div")).getText().replace(",", "");
			double ActualNetSale_Amount=Double.parseDouble(NetSaleAmount);

			//Export the Net Sales value to Excel
			excel.setreportData("Last 7 days", 2, 26, NetSaleAmount);


			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSaleAmount==ActualNetSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sales for Enterprise Report is equal to Sale Recap Report for Last 7 days");
				excel.setreport_PassedData("Last 7 days", 2, 27, "0.00");
				excel.setreport_PassedData("Last 7 days", 39, 11, NetSaleAmount+"`");
			}
			else
			{
				double diff=Expected_NetSaleAmount-ActualNetSale_Amount;
				test.log(LogStatus.FAIL, "Net Sales for Enterprise Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Last 7 days", 2, 27,diff_value);
				 excel.setreport_FailedData("Last 7 days", 39, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last 7 days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tfoot/tr/td[6]/div")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last 7 days", 3, 26, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Enterprise Report is equal to Sale Recap Report for Last 7 days");
				excel.setreport_PassedData("Last 7 days", 3, 27, "0.00");
				excel.setreport_PassedData("Last 7 days", 40, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Enterprise Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Last 7 days", 3, 27,diff_value);
				 excel.setreport_FailedData("Last 7 days", 40, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Last 7 days", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tfoot/tr/td[4]/div")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Last 7 days", 4, 26, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Enterprise Report is equal to Sale Recap Report for Last 7 days");
				excel.setreport_PassedData("Last 7 days", 4, 27, "0.00");
				excel.setreport_PassedData("Last 7 days", 41, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Enterprise Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Last 7 days", 4, 27,diff_value);
				 excel.setreport_FailedData("Last 7 days", 41, 11,diff_value);
			}

			//Get the Gross Sales from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("Last 7 days", 7, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sales
			String GrossSale=driver.findElement(By.xpath("//tfoot/tr/td[2]/div")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("Last 7 days", 7, 26, GrossSale);


			//Check whether the Gross Sales value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "Gross Sales for Enterprise Report is equal to Sale Recap Report for Last 7 days");
				excel.setreport_PassedData("Last 7 days", 7, 27, "0.00");
				excel.setreport_PassedData("Last 7 days", 44, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "Gross Sales for Enterprise Report is not equal to Sale Recap Report  for Last 7 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Last 7 days", 7, 27,diff_value);
				 excel.setreport_FailedData("Last 7 days", 44, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}


	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_This_Month(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		//SelectTheCat(driver);
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));
		
		//Select This month
		repts.Select_This_Month_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Report Not Available for This month");
			excel.setreportData("This month", 2, 26, st);
			excel.setreportData("This month", 3, 26, st);
			excel.setreportData("This month", 4, 26, st);
			excel.setreportData("This month", 7, 26, st);

			excel.setreportData("This month", 2, 27, st);
			excel.setreportData("This month", 3, 27, st);
			excel.setreportData("This month", 4, 27, st);
			excel.setreportData("This month", 7, 27, st);

			excel.setreportData("This month", 39, 11, st);
			excel.setreportData("This month", 40, 11, st);
			excel.setreportData("This month", 41, 11, st);
			excel.setreportData("This month", 44, 11, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Enterprise Report Available for This month");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("This month", 2, 1).toString().replace(",", "");
			double Expected_NetSaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Net Sales
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String NetSaleAmount=driver.findElement(By.xpath("//tfoot/tr/td[7]/div")).getText().replace(",", "");
			double ActualNetSale_Amount=Double.parseDouble(NetSaleAmount);

			//Export the Net Sales value to Excel
			excel.setreportData("This month", 2, 26, NetSaleAmount);


			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSaleAmount==ActualNetSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sales for Enterprise Report is equal to Sale Recap Report for This month");
				excel.setreport_PassedData("This month", 2, 27, "0.00");
				excel.setreport_PassedData("This month", 39, 11, NetSaleAmount+"`");
			}
			else
			{
				double diff=Expected_NetSaleAmount-ActualNetSale_Amount;
				test.log(LogStatus.FAIL, "Net Sales for Enterprise Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("This month", 2, 27,diff_value);
				 excel.setreport_FailedData("This month", 39, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("This month", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tfoot/tr/td[6]/div")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("This month", 3, 26, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Enterprise Report is equal to Sale Recap Report for This month");
				excel.setreport_PassedData("This month", 3, 27, "0.00");
				excel.setreport_PassedData("This month", 40, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Enterprise Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("This month", 3, 27,diff_value);
				 excel.setreport_FailedData("This month", 40, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("This month", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tfoot/tr/td[4]/div")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("This month", 4, 26, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Enterprise Report is equal to Sale Recap Report for This month");
				excel.setreport_PassedData("This month", 4, 27, "0.00");
				excel.setreport_PassedData("This month", 41, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Enterprise Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("This month", 4, 27,diff_value);
				 excel.setreport_FailedData("This month", 41, 11,diff_value);
			}

			//Get the Gross Sales from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("This month", 7, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sales
			String GrossSale=driver.findElement(By.xpath("//tfoot/tr/td[2]/div")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("This month", 7, 26, GrossSale);


			//Check whether the Gross Sales value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "Gross Sales for Enterprise Report is equal to Sale Recap Report for This month");
				excel.setreport_PassedData("This month", 7, 27, "0.00");
				excel.setreport_PassedData("This month", 44, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "Gross Sales for Enterprise Report is not equal to Sale Recap Report  for This month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("This month", 7, 27,diff_value);
				 excel.setreport_FailedData("This month", 44, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}


	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Last_Month(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		//SelectTheCat(driver);
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));
		
		//Select Last month
		repts.Select_Last_Month_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Report Not Available for Last month");
			excel.setreportData("Last month", 2, 26, st);
			excel.setreportData("Last month", 3, 26, st);
			excel.setreportData("Last month", 4, 26, st);
			excel.setreportData("Last month", 7, 26, st);

			excel.setreportData("Last month", 2, 27, st);
			excel.setreportData("Last month", 3, 27, st);
			excel.setreportData("Last month", 4, 27, st);
			excel.setreportData("Last month", 7, 27, st);

			excel.setreportData("Last month", 39, 11, st);
			excel.setreportData("Last month", 40, 11, st);
			excel.setreportData("Last month", 41, 11, st);
			excel.setreportData("Last month", 44, 11, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Enterprise Report Available for Last month");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last month", 2, 1).toString().replace(",", "");
			double Expected_NetSaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Net Sales
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String NetSaleAmount=driver.findElement(By.xpath("//tfoot/tr/td[7]/div")).getText().replace(",", "");
			double ActualNetSale_Amount=Double.parseDouble(NetSaleAmount);

			//Export the Net Sales value to Excel
			excel.setreportData("Last month", 2, 26, NetSaleAmount);


			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSaleAmount==ActualNetSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sales for Enterprise Report is equal to Sale Recap Report for Last month");
				excel.setreport_PassedData("Last month", 2, 27, "0.00");
				excel.setreport_PassedData("Last month", 39, 11, NetSaleAmount+"`");
			}
			else
			{
				double diff=Expected_NetSaleAmount-ActualNetSale_Amount;
				test.log(LogStatus.FAIL, "Net Sales for Enterprise Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Last month", 2, 27,diff_value);
				 excel.setreport_FailedData("Last month", 39, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last month", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tfoot/tr/td[6]/div")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last month", 3, 26, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Enterprise Report is equal to Sale Recap Report for Last month");
				excel.setreport_PassedData("Last month", 3, 27, "0.00");
				excel.setreport_PassedData("Last month", 40, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Enterprise Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Last month", 3, 27,diff_value);
				 excel.setreport_FailedData("Last month", 40, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Last month", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tfoot/tr/td[4]/div")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Last month", 4, 26, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Enterprise Report is equal to Sale Recap Report for Last month");
				excel.setreport_PassedData("Last month", 4, 27, "0.00");
				excel.setreport_PassedData("Last month", 41, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Enterprise Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Last month", 4, 27,diff_value);
				 excel.setreport_FailedData("Last month", 41, 11,diff_value);
			}

			//Get the Gross Sales from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("Last month", 7, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sales
			String GrossSale=driver.findElement(By.xpath("//tfoot/tr/td[2]/div")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("Last month", 7, 26, GrossSale);


			//Check whether the Gross Sales value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "Gross Sales for Enterprise Report is equal to Sale Recap Report for Last month");
				excel.setreport_PassedData("Last month", 7, 27, "0.00");
				excel.setreport_PassedData("Last month", 44, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "Gross Sales for Enterprise Report is not equal to Sale Recap Report  for Last month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Last month", 7, 27,diff_value);
				 excel.setreport_FailedData("Last month", 44, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Last_30_Days(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		//SelectTheCat(driver);
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));
		
		//Select Last 30 days
		repts.Select_Last_30_Days_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Report Not Available for Last 30 days");
			excel.setreportData("Last 30 days", 2, 26, st);
			excel.setreportData("Last 30 days", 3, 26, st);
			excel.setreportData("Last 30 days", 4, 26, st);
			excel.setreportData("Last 30 days", 7, 26, st);

			excel.setreportData("Last 30 days", 2, 27, st);
			excel.setreportData("Last 30 days", 3, 27, st);
			excel.setreportData("Last 30 days", 4, 27, st);
			excel.setreportData("Last 30 days", 7, 27, st);

			excel.setreportData("Last 30 days", 39, 11, st);
			excel.setreportData("Last 30 days", 40, 11, st);
			excel.setreportData("Last 30 days", 41, 11, st);
			excel.setreportData("Last 30 days", 44, 11, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Enterprise Report Available for Last 30 days");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last 30 days", 2, 1).toString().replace(",", "");
			double Expected_NetSaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Net Sales
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String NetSaleAmount=driver.findElement(By.xpath("//tfoot/tr/td[7]/div")).getText().replace(",", "");
			double ActualNetSale_Amount=Double.parseDouble(NetSaleAmount);

			//Export the Net Sales value to Excel
			excel.setreportData("Last 30 days", 2, 26, NetSaleAmount);


			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSaleAmount==ActualNetSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sales for Enterprise Report is equal to Sale Recap Report for Last 30 days");
				excel.setreport_PassedData("Last 30 days", 2, 27, "0.00");
				excel.setreport_PassedData("Last 30 days", 39, 11, NetSaleAmount+"`");
			}
			else
			{
				double diff=Expected_NetSaleAmount-ActualNetSale_Amount;
				test.log(LogStatus.FAIL, "Net Sales for Enterprise Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Last 30 days", 2, 27,diff_value);
				 excel.setreport_FailedData("Last 30 days", 39, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last 30 days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tfoot/tr/td[6]/div")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last 30 days", 3, 26, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Enterprise Report is equal to Sale Recap Report for Last 30 days");
				excel.setreport_PassedData("Last 30 days", 3, 27, "0.00");
				excel.setreport_PassedData("Last 30 days", 40, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Enterprise Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Last 30 days", 3, 27,diff_value);
				 excel.setreport_FailedData("Last 30 days", 40, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Last 30 days", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tfoot/tr/td[4]/div")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Last 30 days", 4, 26, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Enterprise Report is equal to Sale Recap Report for Last 30 days");
				excel.setreport_PassedData("Last 30 days", 4, 27, "0.00");
				excel.setreport_PassedData("Last 30 days", 41, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Enterprise Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Last 30 days", 4, 27,diff_value);
				 excel.setreport_FailedData("Last 30 days", 41, 11,diff_value);
			}

			//Get the Gross Sales from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("Last 30 days", 7, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sales
			String GrossSale=driver.findElement(By.xpath("//tfoot/tr/td[2]/div")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("Last 30 days", 7, 26, GrossSale);


			//Check whether the Gross Sales value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "Gross Sales for Enterprise Report is equal to Sale Recap Report for Last 30 days");
				excel.setreport_PassedData("Last 30 days", 7, 27, "0.00");
				excel.setreport_PassedData("Last 30 days", 44, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "Gross Sales for Enterprise Report is not equal to Sale Recap Report  for Last 30 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Last 30 days", 7, 27,diff_value);
				 excel.setreport_FailedData("Last 30 days", 44, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Specific_Date(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		//SelectTheCat(driver);
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));
		
		//Select Specific Date
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Report Not Available for Specific Date");
			excel.setreportData("Specific Date", 2, 26, st);
			excel.setreportData("Specific Date", 3, 26, st);
			excel.setreportData("Specific Date", 4, 26, st);
			excel.setreportData("Specific Date", 7, 26, st);

			excel.setreportData("Specific Date", 2, 27, st);
			excel.setreportData("Specific Date", 3, 27, st);
			excel.setreportData("Specific Date", 4, 27, st);
			excel.setreportData("Specific Date", 7, 27, st);

			excel.setreportData("Specific Date", 39, 11, st);
			excel.setreportData("Specific Date", 40, 11, st);
			excel.setreportData("Specific Date", 41, 11, st);
			excel.setreportData("Specific Date", 44, 11, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Enterprise Report Available for Specific Date");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Specific Date", 2, 1).toString().replace(",", "");
			double Expected_NetSaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Net Sales
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String NetSaleAmount=driver.findElement(By.xpath("//tfoot/tr/td[7]/div")).getText().replace(",", "");
			double ActualNetSale_Amount=Double.parseDouble(NetSaleAmount);

			//Export the Net Sales value to Excel
			excel.setreportData("Specific Date", 2, 26, NetSaleAmount);


			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSaleAmount==ActualNetSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sales for Enterprise Report is equal to Sale Recap Report for Specific Date");
				excel.setreport_PassedData("Specific Date", 2, 27, "0.00");
				excel.setreport_PassedData("Specific Date", 39, 11, NetSaleAmount+"`");
			}
			else
			{
				double diff=Expected_NetSaleAmount-ActualNetSale_Amount;
				test.log(LogStatus.FAIL, "Net Sales for Enterprise Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Specific Date", 2, 27,diff_value);
				 excel.setreport_FailedData("Specific Date", 39, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Specific Date", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tfoot/tr/td[6]/div")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Specific Date", 3, 26, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Enterprise Report is equal to Sale Recap Report for Specific Date");
				excel.setreport_PassedData("Specific Date", 3, 27, "0.00");
				excel.setreport_PassedData("Specific Date", 40, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Enterprise Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Specific Date", 3, 27,diff_value);
				 excel.setreport_FailedData("Specific Date", 40, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Specific Date", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tfoot/tr/td[4]/div")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Specific Date", 4, 26, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Enterprise Report is equal to Sale Recap Report for Specific Date");
				excel.setreport_PassedData("Specific Date", 4, 27, "0.00");
				excel.setreport_PassedData("Specific Date", 41, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Enterprise Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Specific Date", 4, 27,diff_value);
				 excel.setreport_FailedData("Specific Date", 41, 11,diff_value);
			}

			//Get the Gross Sales from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("Specific Date", 7, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sales
			String GrossSale=driver.findElement(By.xpath("//tfoot/tr/td[2]/div")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("Specific Date", 7, 26, GrossSale);


			//Check whether the Gross Sales value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "Gross Sales for Enterprise Report is equal to Sale Recap Report for Specific Date");
				excel.setreport_PassedData("Specific Date", 7, 27, "0.00");
				excel.setreport_PassedData("Specific Date", 44, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "Gross Sales for Enterprise Report is not equal to Sale Recap Report  for Specific Date.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Specific Date", 7, 27,diff_value);
				 excel.setreport_FailedData("Specific Date", 44, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Date_Range(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		//SelectTheCat(driver);
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));
		
		//Select Date Range
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Report Not Available for Date Range");
			excel.setreportData("Date Range", 2, 26, st);
			excel.setreportData("Date Range", 3, 26, st);
			excel.setreportData("Date Range", 4, 26, st);
			excel.setreportData("Date Range", 7, 26, st);

			excel.setreportData("Date Range", 2, 27, st);
			excel.setreportData("Date Range", 3, 27, st);
			excel.setreportData("Date Range", 4, 27, st);
			excel.setreportData("Date Range", 7, 27, st);

			excel.setreportData("Date Range", 39, 11, st);
			excel.setreportData("Date Range", 40, 11, st);
			excel.setreportData("Date Range", 41, 11, st);
			excel.setreportData("Date Range", 44, 11, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{

			test.log(LogStatus.PASS, "Enterprise Report Available for Date Range");

			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Date Range", 2, 1).toString().replace(",", "");
			double Expected_NetSaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Net Sales
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String NetSaleAmount=driver.findElement(By.xpath("//tfoot/tr/td[7]/div")).getText().replace(",", "");
			double ActualNetSale_Amount=Double.parseDouble(NetSaleAmount);

			//Export the Net Sales value to Excel
			excel.setreportData("Date Range", 2, 26, NetSaleAmount);


			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSaleAmount==ActualNetSale_Amount)
			{
				test.log(LogStatus.PASS, "Net Sales for Enterprise Report is equal to Sale Recap Report for Date Range");
				excel.setreport_PassedData("Date Range", 2, 27, "0.00");
				excel.setreport_PassedData("Date Range", 39, 11, NetSaleAmount+"`");
			}
			else
			{
				double diff=Expected_NetSaleAmount-ActualNetSale_Amount;
				test.log(LogStatus.FAIL, "Net Sales for Enterprise Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Date Range", 2, 27,diff_value);
				 excel.setreport_FailedData("Date Range", 39, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Date Range", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tfoot/tr/td[6]/div")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Date Range", 3, 26, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Enterprise Report is equal to Sale Recap Report for Date Range");
				excel.setreport_PassedData("Date Range", 3, 27, "0.00");
				excel.setreport_PassedData("Date Range", 40, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Enterprise Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Date Range", 3, 27,diff_value);
				 excel.setreport_FailedData("Date Range", 40, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Date Range", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tfoot/tr/td[4]/div")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Date Range", 4, 26, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Enterprise Report is equal to Sale Recap Report for Date Range");
				excel.setreport_PassedData("Date Range", 4, 27, "0.00");
				excel.setreport_PassedData("Date Range", 41, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Enterprise Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Date Range", 4, 27,diff_value);
				 excel.setreport_FailedData("Date Range", 41, 11,diff_value);
			}

			//Get the Gross Sales from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("Date Range", 7, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sales
			String GrossSale=driver.findElement(By.xpath("//tfoot/tr/td[2]/div")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("Date Range", 7, 26, GrossSale);


			//Check whether the Gross Sales value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "Gross Sales for Enterprise Report is equal to Sale Recap Report for Date Range");
				excel.setreport_PassedData("Date Range", 7, 27, "0.00");
				excel.setreport_PassedData("Date Range", 44, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "Gross Sales for Enterprise Report is not equal to Sale Recap Report  for Date Range.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Net Sales value to Excel
				 excel.setreport_FailedData("Date Range", 7, 27,diff_value);
				 excel.setreport_FailedData("Date Range", 44, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}
	

}
