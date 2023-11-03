package com.Test;

import java.util.concurrent.TimeUnit;

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

public class Enterprise_Reports_Department_Sale_Report 
{

public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enprise Reports- Sale - Department Report");
	
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
//		System.setProperty("webdriver.chrome.driver","./Automation Driver/chromedriver.exe");
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
		Open_Enterprise_Report_Department_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Enterprise_Report_Department_Report_Today(driver);
		Enterprise_Report_Department_Report_Yesterday(driver);
		Enterprise_Report_Department_Report_Last_N_Days(driver);
		Enterprise_Report_Department_Report_This_Week(driver);
		Enterprise_Report_Department_Report_Last_Week(driver);
		Enterprise_Report_Department_Report_Last_7_Days(driver);
		Enterprise_Report_Department_Report_This_Month(driver);
		Enterprise_Report_Department_Report_Last_Month(driver);
		Enterprise_Report_Department_Report_Last_30_Days(driver);
		Enterprise_Report_Department_Report_Specific_Date(driver);
		Enterprise_Report_Department_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Enterprise_Report_Department_Report_Page(SelfHealingDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+"enterprise/enterpriseReports/saleReports/departments");

//		//Click the Enterprise reports
//		driver.findElement(By.xpath("//span[contains(.,'Enterprise Reports')]")).click();
//		
//		Thread.sleep(500);
//		
//		//Click the Sale report
//		driver.findElement(By.xpath("//span[contains(.,'Sale Report')]")).click();
//		
//		Thread.sleep(2500);
//		
//		//Click the Department Sale report
//		driver.findElement(By.xpath("//div/a[contains(.,'DEPARTMENTS')]")).click();
		
		Thread.sleep(8000);
		//Verify the Categories page loaded or not
		//repts.Verify_ReportHomePage("DEPARTMENTS");
		try {
			if(driver.findElement(By.xpath("//li/span/a[contains(.,'Departments')]")).isDisplayed()) {
				test.log(LogStatus.PASS, "Enterprise Department page is displayed");
			}
		}catch(Exception s) {
			test.log(LogStatus.FAIL, "Enterprise Department page is not getting loaded");
		}
		
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
	public void Enterprise_Report_Department_Report_Today(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
		//Select the store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));
		
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Department Not Available for Today");
	
			excel.setreportData("Today", 2, 2, st);
			excel.setreportData("Today", 3, 2, st);
			excel.setreportData("Today", 4, 2, st);
			
			
			excel.setreportData("Today", 2, 3, st);
			excel.setreportData("Today", 3, 3, st);
			excel.setreportData("Today", 4, 3, st);
			
			excel.setreportData("Today", 39, 2, st);
			excel.setreportData("Today", 40, 2, st);
			excel.setreportData("Today", 41, 2, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Department Available for Today");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			//Verify Donut Chart screen
			repts.Verify_Donut_Chart_Screen_TopSales();
			
			//Verify Bars Chart Screen
			repts.Verify_Bars_Chart_Screen_TopSales();
			
			//Verify Sales By Hours
			repts.Verify_Sales_byHours_Chart_Screen();
//			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_SaleAmt=excel.getData("Today", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expected_SaleAmt);
			
			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Sale_NetSales_Amount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Today", 2, 2, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Department Report is equal to Sale Recap Report for Today");
	
			excel.setreport_PassedData("Today", 2, 3, "0.00");
			
			excel.setreport_PassedData("Today", 39, 2, SaleAmount+"`");

			
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				String diff_value=String.valueOf(diff);
				
				test.log(LogStatus.FAIL, "Sale Amount for Department Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
				

				excel.setreport_FailedData("Today", 2, 3,diff_value);
		
				excel.setreport_FailedData("Today", 39, 2,diff_value);
			}
			
		

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Today", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Today", 3, 2, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Department Report is equal to Sale Recap Report for Today");
		
				excel.setreport_PassedData("Today", 3, 3, "0.00");

				excel.setreport_PassedData("Today", 40, 2, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Department Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 3, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Today", 3, 3,diff_value);

				excel.setreport_FailedData("Today", 40, 2,diff_value);
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Today", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Today", 4, 2, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Department Report is equal to Sale Recap Report for Today");
		
			
				excel.setreport_PassedData("Today", 4, 3, "0.00");

				excel.setreport_PassedData("Today", 41, 2, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Department Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
			
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 4, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Today", 4, 3,diff_value);

				excel.setreport_FailedData("Today", 41, 2,diff_value);
			}
			
			
			
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Department_Report_Yesterday(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
		
		//Select Today
		repts.Select_Yesterday_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Department Not Available for Yesterday");
		
			excel.setreportData("Yesterday", 2, 2, st);
			excel.setreportData("Yesterday", 3, 2, st);
			excel.setreportData("Yesterday", 4, 2, st);
			
			excel.setreportData("Yesterday", 2, 3, st);
			excel.setreportData("Yesterday", 3, 3, st);
			excel.setreportData("Yesterday", 4, 3, st);
			
			excel.setreportData("Yesterday", 39, 2, st);
			excel.setreportData("Yesterday", 40, 2, st);
			excel.setreportData("Yesterday", 41, 2, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Department Available for Yesterday");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
//			//Verify Donut Chart screen
//			repts.Verify_Donut_Chart_Screen_TopSales();
//			
//			//Verify Bars Chart Screen
//			repts.Verify_Bars_Chart_Screen_TopSales();
//			
//			//Verify Sales By Hours
//			repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_SaleAmt=excel.getData("Yesterday", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expected_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Sale_NetSales_Amount_EnterpriseSaleReport().getText().replace(",", "").replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Yesterday", 2, 2, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Department Report is equal to Sale Recap Report for Yesterday");
		
			
				excel.setreport_PassedData("Yesterday", 2, 3, "0.00");

				excel.setreport_PassedData("Yesterday", 39, 2, SaleAmount+"`");
				
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Department Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
		

				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Yesterday", 2, 3,diff_value);
				excel.setreport_FailedData("Yesterday", 39, 2,diff_value);
			
			}
			
		

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Yesterday", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Yesterday", 3, 2, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Department Report is equal to Sale Recap Report for Yesterday");
		
				excel.setreport_PassedData("Yesterday", 3, 3, "0.00");
			
				excel.setreport_PassedData("Yesterday", 40, 2, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Department Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Yesterday", 3, 3,diff_value);
				excel.setreport_FailedData("Yesterday", 40, 2,diff_value);

			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Yesterday", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Yesterday", 4, 2, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Department Report is equal to Sale Recap Report for Yesterday");
		
			
				excel.setreport_PassedData("Yesterday", 4, 3, "0.00");
				excel.setreport_PassedData("Yesterday", 41, 2, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Department Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
	
			
				
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Yesterday", 4, 3,diff_value);
				excel.setreport_FailedData("Yesterday", 41, 2,diff_value);

			}
			
		
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Department_Report_Last_N_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
		
		//Select Today
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Department Not Available for Last N days");
		
			excel.setreportData("Last N days", 2, 2, st);
			excel.setreportData("Last N days", 3, 2, st);
			excel.setreportData("Last N days", 4, 2, st);
			
			excel.setreportData("Last N days", 2, 3, st);
			excel.setreportData("Last N days", 3, 3, st);
			excel.setreportData("Last N days", 4, 3, st);
			
			
			excel.setreportData("Last N days", 39, 2, st);
			excel.setreportData("Last N days", 40, 2, st);
			excel.setreportData("Last N days", 41, 2, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Department Available for Last N days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
//			//Verify Donut Chart screen
//			repts.Verify_Donut_Chart_Screen_TopSales();
//			
//			//Verify Bars Chart Screen
//			repts.Verify_Bars_Chart_Screen_TopSales();
//			
//			//Verify Sales By Hours
//			repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_SaleAmt=excel.getData("Last N days", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expected_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Sale_NetSales_Amount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Last N days", 2, 2, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Department Report is equal to Sale Recap Report for Last 'N' Days");
		
				excel.setreport_PassedData("Last N days", 2, 3, "0.00");
				
				excel.setreport_PassedData("Last N days", 39, 2, SaleAmount+"`");
				
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Department Report is not equal to Sale Recap Report for Last 'N' Days.The value diff is : "+diff);
		

				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last N days", 2, 3,diff_value);
				excel.setreport_FailedData("Last N days", 39, 2,diff_value);
			
			}
			
			

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Last N days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last N days", 3, 2, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Department Report is equal to Sale Recap Report for Last 'N' Days");
			
			
				excel.setreport_PassedData("Last N days", 3, 3, "0.00");
				excel.setreport_PassedData("Last N days", 40, 2, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Department Report is not equal to Sale Recap Report for Last 'N' Days.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last N days", 3, 3,diff_value);
				excel.setreport_FailedData("Last N days", 40, 2,diff_value);
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Last N days", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Last N days", 4, 2, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Department Report is equal to Sale Recap Report for Last 'N' Days");
		
				excel.setreport_PassedData("Last N days", 4, 3, "0.00");
				excel.setreport_PassedData("Last N days", 41, 2, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Department Report is not equal to Sale Recap Report for Last 'N' Days.The value diff is : "+diff);
			
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last N days", 4, 3,diff_value);
				excel.setreport_FailedData("Last N days", 41, 2,diff_value);
			}
			
		
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
			
			Thread.sleep(3000);

		}
	}

	
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Department_Report_This_Week(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
		
		//Select Today
		repts.Select_This_Week_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Department Not Available for This Week");
	
		
			excel.setreportData("This Week", 2, 2, st);
			excel.setreportData("This Week", 3, 2, st);
			excel.setreportData("This Week", 4, 2, st);
			
			excel.setreportData("This Week", 2, 3, st);
			excel.setreportData("This Week", 3, 3, st);
			excel.setreportData("This Week", 4, 3, st);
			
			
			excel.setreportData("This Week", 39, 2, st);
			excel.setreportData("This Week", 40, 2, st);
			excel.setreportData("This Week", 41, 2, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Department Available for This Week");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			//Verify Donut Chart screen
			repts.Verify_Donut_Chart_Screen_TopSales();
			
			//Verify Bars Chart Screen
			repts.Verify_Bars_Chart_Screen_TopSales();
			
			//Verify Sales By Hours
			repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_SaleAmt=excel.getData("This Week", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expected_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Sale_NetSales_Amount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("This Week", 2, 2, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Department Report is equal to Sale Recap Report for This Week");
		
				excel.setreport_PassedData("This Week", 2, 3, "0.00");
				excel.setreport_PassedData("This Week", 39, 2, SaleAmount+"`");
			
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Department Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
			
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
				excel.setreport_FailedData("This Week", 2, 3,diff_value);
				excel.setreport_FailedData("This Week", 39, 2,diff_value);
			
			}
			
		

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("This Week", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("This Week", 3, 2, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Department Report is equal to Sale Recap Report for This Week");
		
				excel.setreport_PassedData("This Week", 3, 3, "0.00");
				excel.setreport_PassedData("This Week", 40, 2, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Department Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
			
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
				excel.setreport_FailedData("This Week", 3, 3,diff_value);
				excel.setreport_FailedData("This Week", 40, 2,diff_value);
			
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("This Week", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("This Week", 4, 2, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Department Report is equal to Sale Recap Report for This Week");
		
			
				excel.setreport_PassedData("This Week", 4, 3, "0.00");
				excel.setreport_PassedData("This Week", 41, 2, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Department Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
				excel.setreport_FailedData("This Week", 4, 3,diff_value);
				excel.setreport_FailedData("This Week", 41, 2,diff_value);
			}
			
		
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
			
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Department_Report_Last_Week(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
		
		//Select Today
		repts.Select_Last_Week_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Department Not Available for Last Week");
		
			
			excel.setreportData("Last Week", 2, 2, st);
			excel.setreportData("Last Week", 3, 2, st);
			excel.setreportData("Last Week", 4, 2, st);
			
			excel.setreportData("Last Week", 2, 3, st);
			excel.setreportData("Last Week", 3, 3, st);
			excel.setreportData("Last Week", 4, 3, st);
			
			
			excel.setreportData("Last Week", 39, 2, st);
			excel.setreportData("Last Week", 40, 2, st);
			excel.setreportData("Last Week", 41, 2, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Department Available for Last Week");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
//			//Verify Donut Chart screen
//			repts.Verify_Donut_Chart_Screen_TopSales();
//			
//			//Verify Bars Chart Screen
//			repts.Verify_Bars_Chart_Screen_TopSales();
//			
//			//Verify Sales By Hours
//			repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_SaleAmt=excel.getData("Last Week", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expected_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Sale_NetSales_Amount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Last Week", 2, 2, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Department Report is equal to Sale Recap Report for Last Week");
		

				excel.setreport_PassedData("Last Week", 2, 3, "0.00");
				excel.setreport_PassedData("Last Week", 39, 2, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Department Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
	
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last Week", 2, 3,diff_value);
				excel.setreport_FailedData("Last Week", 39, 2,diff_value);

			}
			
		
			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Last Week", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last Week", 3, 2, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Department Report is equal to Sale Recap Report for Last Week");
		

				excel.setreport_PassedData("Last Week", 3, 3, "0.00");
				excel.setreport_PassedData("Last Week", 40, 2, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Department Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last Week", 3, 3,diff_value);
				excel.setreport_FailedData("Last Week", 40, 2,diff_value);
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Last Week", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Last Week", 4, 2, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Department Report is equal to Sale Recap Report for Last Week");
			
				excel.setreport_PassedData("Last Week", 4, 3, "0.00");
				excel.setreport_PassedData("Last Week", 41, 2, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Department Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last Week", 4, 3,diff_value);
				excel.setreport_FailedData("Last Week", 41, 2,diff_value);
			
			}
			
			
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
			
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Department_Report_Last_7_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
		
		//Select Today
		repts.Select_Last_7_Days_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Department Not Available for Last 7 days");
	
			excel.setreportData("Last 7 days", 2, 2, st);
			excel.setreportData("Last 7 days", 3, 2, st);
			excel.setreportData("Last 7 days", 4, 2, st);
			
			excel.setreportData("Last 7 days", 2, 3, st);
			excel.setreportData("Last 7 days", 3, 3, st);
			excel.setreportData("Last 7 days", 4, 3, st);
			
			
			excel.setreportData("Last 7 days", 39, 2, st);
			excel.setreportData("Last 7 days", 40, 2, st);
			excel.setreportData("Last 7 days", 41, 2, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Department Available for Last 7 days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			//Verify Donut Chart screen
			repts.Verify_Donut_Chart_Screen_TopSales();
			
			//Verify Bars Chart Screen
			repts.Verify_Bars_Chart_Screen_TopSales();
			
			//Verify Sales By Hours
			repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_SaleAmt=excel.getData("Last 7 days", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expected_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Sale_NetSales_Amount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Last 7 days", 2, 2, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Department Report is equal to Sale Recap Report for Last 7 days");
		
				excel.setreport_PassedData("Last 7 days", 2, 3, "0.00");
				excel.setreport_PassedData("Last 7 days", 39, 2, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Department Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last 7 days", 2, 3,diff_value);
				excel.setreport_FailedData("Last 7 days", 39, 2,diff_value);

			}
			
		

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Last 7 days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last 7 days", 3, 2, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Department Report is equal to Sale Recap Report for Last 7 days");
		
				excel.setreport_PassedData("Last 7 days", 3, 3, "0.00");

				excel.setreport_PassedData("Last 7 days", 40, 2, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Department Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last 7 days", 3, 3,diff_value);
				excel.setreport_FailedData("Last 7 days", 40, 2,diff_value);
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Last 7 days", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Last 7 days", 4, 2, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Department Report is equal to Sale Recap Report for Last 7 days");
		
				excel.setreport_PassedData("Last 7 days", 4, 3, "0.00");
				
				excel.setreport_PassedData("Last 7 days", 41, 2, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Department Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last 7 days", 4, 3,diff_value);
				
				excel.setreport_FailedData("Last 7 days", 41, 2,diff_value);
			}
			
		
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Department_Report_This_Month(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
		
		//Select Today
		repts.Select_This_Month_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Department Not Available for This month");
		
		
			excel.setreportData("This month", 2, 2, st);
			excel.setreportData("This month", 3, 2, st);
			excel.setreportData("This month", 4, 2, st);
			
			excel.setreportData("This month", 2, 3, st);
			excel.setreportData("This month", 3, 3, st);
			excel.setreportData("This month", 4, 3, st);
			
			
			excel.setreportData("This month", 39, 2, st);
			excel.setreportData("This month", 40, 2, st);
			excel.setreportData("This month", 41, 2, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Department Available for This month");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
//			//Verify Donut Chart screen
//			repts.Verify_Donut_Chart_Screen_TopSales();
//			
//			//Verify Bars Chart Screen
//			repts.Verify_Bars_Chart_Screen_TopSales();
//			
//			//Verify Sales By Hours
//			repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_SaleAmt=excel.getData("This month", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expected_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Sale_NetSales_Amount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("This month", 2, 2, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Department Report is equal to Sale Recap Report for This month");
		
				excel.setreport_PassedData("This month", 2, 3, "0.00");
				excel.setreport_PassedData("This month", 39, 2, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Department Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("This month", 2, 3,diff_value);
				
				excel.setreport_FailedData("This month", 39, 2,diff_value);
			}
			
		

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("This month", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("This month", 3, 2, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Department Report is equal to Sale Recap Report for This month");
		
				excel.setreport_PassedData("This month", 3, 3, "0.00");
				
				excel.setreport_PassedData("This month", 40, 2, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Department Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("This month", 3, 3,diff_value);
				excel.setreport_FailedData("This month", 40, 2,diff_value);
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("This month", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("This month", 4, 2, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Department Report is equal to Sale Recap Report for This month");
		
				excel.setreport_PassedData("This month", 4, 3, "0.00");
				excel.setreport_PassedData("This month", 41, 2, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Department Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("This month", 4, 3,diff_value);
				excel.setreport_FailedData("This month", 41, 2,diff_value);
			}
			
		
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Department_Report_Last_Month(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
		
		//Select Today
		repts.Select_Last_Month_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Department Not Available for Last month");
	
			excel.setreportData("Last month", 2, 2, st);
			excel.setreportData("Last month", 3, 2, st);
			excel.setreportData("Last month", 4, 2, st);
			
			excel.setreportData("Last month", 2, 3, st);
			excel.setreportData("Last month", 3, 3, st);
			excel.setreportData("Last month", 4, 3, st);
			
			
			excel.setreportData("Last month", 39, 2, st);
			excel.setreportData("Last month", 40, 2, st);
			excel.setreportData("Last month", 41, 2, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Department Available for Last month");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
//			//Verify Donut Chart screen
//			repts.Verify_Donut_Chart_Screen_TopSales();
//			
//			//Verify Bars Chart Screen
//			repts.Verify_Bars_Chart_Screen_TopSales();
//			
//			//Verify Sales By Hours
//			repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_SaleAmt=excel.getData("Last month", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expected_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Sale_NetSales_Amount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Last month", 2, 2, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Department Report is equal to Sale Recap Report for Last month");
		
				excel.setreport_PassedData("Last month", 2, 3, "0.00");
				excel.setreport_PassedData("Last month", 39, 2, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Department Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
			
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last month", 2, 3,diff_value);
				excel.setreport_FailedData("Last month", 39, 2,diff_value);
			}
			
		

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Last month", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last month", 3, 2, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Department Report is equal to Sale Recap Report for Last month");
		
				excel.setreport_PassedData("Last month", 3, 3, "0.00");
				
				excel.setreport_PassedData("Last month", 40, 2, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Department Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last month", 2, 3,diff_value);
				excel.setreport_FailedData("Last month", 40, 2,diff_value);
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Last month", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Last month", 4, 2, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Department Report is equal to Sale Recap Report for Last month");
		
				excel.setreport_PassedData("Last month", 4, 3, "0.00");
				excel.setreport_PassedData("Last month", 41, 2, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Department Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last month", 4, 3,diff_value);
				excel.setreport_FailedData("Last month", 41, 2,diff_value);
			}
			
			
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Department_Report_Last_30_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
		
		//Select Today
		repts.Select_Last_30_Days_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Department Not Available for Last 30 days");
		
		
			excel.setreportData("Last 30 days", 2, 2, st);
			excel.setreportData("Last 30 days", 3, 2, st);
			excel.setreportData("Last 30 days", 4, 2, st);
			
			excel.setreportData("Last 30 days", 2, 3, st);
			excel.setreportData("Last 30 days", 3, 3, st);
			excel.setreportData("Last 30 days", 4, 3, st);
			
			
			excel.setreportData("Last 30 days", 39, 2, st);
			excel.setreportData("Last 30 days", 40, 2, st);
			excel.setreportData("Last 30 days", 41, 2, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Department Available for Last 30 days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
//			//Verify Donut Chart screen
//			repts.Verify_Donut_Chart_Screen_TopSales();
//			
//			//Verify Bars Chart Screen
//			repts.Verify_Bars_Chart_Screen_TopSales();
//			
//			//Verify Sales By Hours
//			repts.Verify_Sales_byHours_Chart_Screen();
//			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_SaleAmt=excel.getData("Last 30 days", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expected_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Sale_NetSales_Amount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Last 30 days", 2, 2, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Department Report is equal to Sale Recap Report for Last 30 days");
			
				excel.setreport_PassedData("Last 30 days", 2, 3, "0.00");
				excel.setreport_PassedData("Last 30 days", 39, 2, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Department Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last 30 days", 2, 3,diff_value);
				excel.setreport_FailedData("Last 30 days", 39, 2,diff_value);
			}
			
			

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Last 30 days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last 30 days", 3, 2, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Department Report is equal to Sale Recap Report for Last 30 days");
			
				excel.setreport_PassedData("Last 30 days", 3, 3, "0.00");
				excel.setreport_PassedData("Last 30 days", 40, 2, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Department Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
		

				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last 30 days", 3, 3,diff_value);
				excel.setreport_FailedData("Last 30 days", 40, 2,diff_value);
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Last 30 days", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Last 30 days", 4, 2, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Department Report is equal to Sale Recap Report for Last 30 days");
			
				excel.setreport_PassedData("Last 30 days", 4, 3, "0.00");
				excel.setreport_PassedData("Last 30 days", 41, 2, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Department Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
		

				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 3, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last 30 days", 4, 3,diff_value);
				excel.setreport_FailedData("Last 30 days", 41, 2,diff_value);
			}
			
			
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Department_Report_Specific_Date(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
		//Select Today
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Department Not Available for Specific Date");
		
			excel.setreportData("Specific Date", 2, 2, st);
			excel.setreportData("Specific Date", 3, 2, st);
			excel.setreportData("Specific Date", 4, 2, st);
			
			excel.setreportData("Specific Date", 2, 3, st);
			excel.setreportData("Specific Date", 3, 3, st);
			excel.setreportData("Specific Date", 4, 3, st);
			
			
			excel.setreportData("Specific Date", 39, 2, st);
			excel.setreportData("Specific Date", 40, 2, st);
			excel.setreportData("Specific Date", 41, 2, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Department Available for Specific Date");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			//Verify Donut Chart screen
//			repts.Verify_Donut_Chart_Screen_TopSales();
//			
//			//Verify Bars Chart Screen
//			repts.Verify_Bars_Chart_Screen_TopSales();
//			
//			//Verify Sales By Hours
//			repts.Verify_Sales_byHours_Chart_Screen();
//			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_SaleAmt=excel.getData("Specific Date", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expected_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Sale_NetSales_Amount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Specific Date", 2, 2, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Department Report is equal to Sale Recap Report for Specific Date");
		
				excel.setreport_PassedData("Specific Date", 2, 3, "0.00");
				excel.setreport_PassedData("Specific Date", 39, 2, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Department Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
			
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
				excel.setreport_FailedData("Specific Date", 2, 3,diff_value);
				excel.setreport_FailedData("Specific Date", 39, 2,diff_value);

			}
			
		

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Specific Date", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Specific Date", 3, 2, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Department Report is equal to Sale Recap Report for Specific Date");
		
				excel.setreport_PassedData("Specific Date", 3, 3, "0.00");
				excel.setreport_PassedData("Specific Date", 40, 2, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Department Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel

				excel.setreport_FailedData("Specific Date", 3, 3,diff_value);
				excel.setreport_FailedData("Specific Date", 40, 2,diff_value);
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Specific Date", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Specific Date", 4, 2, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Department Report is equal to Sale Recap Report for Specific Date");
			
				excel.setreport_PassedData("Specific Date", 4, 3, "0.00");
				excel.setreport_PassedData("Specific Date", 41, 2, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Department Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel

				excel.setreport_FailedData("Specific Date", 4, 3,diff_value);
				excel.setreport_FailedData("Specific Date", 41, 2,diff_value);
			}
			
			
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Report_Department_Report_Date_Range(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
		
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Department Not Available for Date Range");
		
			excel.setreportData("Date Range", 2, 2, st);
			excel.setreportData("Date Range", 3, 2, st);
			excel.setreportData("Date Range", 4, 2, st);
			

			excel.setreportData("Date Range", 2, 3, st);
			excel.setreportData("Date Range", 3, 3, st);
			excel.setreportData("Date Range", 4, 3, st);
			
			
			excel.setreportData("Date Range", 39, 2, st);
			excel.setreportData("Date Range", 40, 2, st);
			excel.setreportData("Date Range", 41, 2, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Department Available for Date Range");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
//			//Verify Donut Chart screen
//			repts.Verify_Donut_Chart_Screen_TopSales();
//			
//			//Verify Bars Chart Screen
//			repts.Verify_Bars_Chart_Screen_TopSales();
//			
//			//Verify Sales By Hours
//			repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_SaleAmt=excel.getData("Date Range", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expected_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			String SaleAmount=repts.Sale_NetSales_Amount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Date Range", 2, 2, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Department Report is equal to Sale Recap Report for Date Range");
	
			
				excel.setreport_PassedData("Date Range", 2, 3, "0.00");
				excel.setreport_PassedData("Date Range", 39, 2, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Department Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
			
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
				excel.setreport_FailedData("Date Range", 2, 3,diff_value);
				excel.setreport_FailedData("Date Range", 39, 2,diff_value);

			}
			
		

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Date Range", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Date Range", 3, 2, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Department Report is equal to Sale Recap Report for Date Range");
		
				excel.setreport_PassedData("Date Range", 3, 3, "0.00");
				excel.setreport_PassedData("Date Range", 40, 2, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Department Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
				excel.setreport_FailedData("Date Range", 3, 3,diff_value);
				excel.setreport_FailedData("Date Range", 40, 2,diff_value);

			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Date Range", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Date Range", 4, 2, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Department Report is equal to Sale Recap Report for Date Range");
		
				excel.setreport_PassedData("Date Range", 4, 3, "0.00");
				excel.setreport_PassedData("Date Range", 41, 2, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Department Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
			
			
				String diff_value=String.valueOf(diff);

				//Export the Sale Amount value to Excel
				excel.setreport_FailedData("Date Range", 4, 3,diff_value);
				excel.setreport_FailedData("Date Range", 41, 2,diff_value);

			}
			
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports_Enterprise"));
		
			
			Thread.sleep(3000);

		}
	}
	

}
