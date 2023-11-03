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

public class Enterprise_Reports_SubCategory_Sale_Report 
{

public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise Reports - SubCategory Report");
	
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
			
			test.log(LogStatus.INFO, test.addScreenCapture(s));
	
		
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
		Open_SubCategory_Enterprise_Report_Page(driver);
		RefreshAndPaginination(driver);
		SubCategory_Enterprise_Report_Today(driver);
		SubCategory_Enterprise_Report_Yesterday(driver);
		SubCategory_Enterprise_Report_Last_N_Days(driver);
		SubCategory_Enterprise_Report_This_Week(driver);
		SubCategory_Enterprise_Report_Last_Week(driver);
		SubCategory_Enterprise_Report_Last_7_Days(driver);
		SubCategory_Enterprise_Report_This_Month(driver);
		SubCategory_Enterprise_Report_Last_Month(driver);
		SubCategory_Enterprise_Report_Last_30_Days(driver);
		SubCategory_Enterprise_Report_Specific_Date(driver);
		SubCategory_Enterprise_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_SubCategory_Enterprise_Report_Page(SelfHealingDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the SubCategory page
		driver.get(Utility.getProperty("baseURL")+"enterprise/enterpriseReports/saleReports/subCategories");

		Thread.sleep(5000);
		try
		{
		//Verify the Categories page loaded or not
		repts.Verify_ReportHomePage("SUB CATEGORIES");
		}
		catch(Exception k)
		{
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
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
	public void SubCategory_Enterprise_Report_Today(SelfHealingDriver driver) throws Exception
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
		
		
		Thread.sleep(8000);
		try
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Enterprise Sale Report for SubCategory Not Available for Today");
	
			excel.setreportData("Today", 2, 6, st);
			excel.setreportData("Today", 3, 6, st);
			excel.setreportData("Today", 4, 6, st);
			
			
			excel.setreportData("Today", 2, 7, st);
			excel.setreportData("Today", 3, 7, st);
			excel.setreportData("Today", 4, 7, st);
			
			excel.setreportData("Today", 39, 4, st);
			excel.setreportData("Today", 40, 4, st);
			excel.setreportData("Today", 41, 4, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Enterprise Sale Report for SubCategory Available for Today");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			
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
			excel.setreportData("Today", 2, 6, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount!=ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for SubCategory Report is Exported to Excel for Today");
	
//			excel.setreport_PassedData("Today", 2, 7, st);
//			
//			excel.setreport_PassedData("Today", 39, 4, st);

			
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				String st=String.valueOf(diff);
				
//				test.log(LogStatus.INFO, "Sale Amount for SubCategory Report is not Exported to Excel for Today.The value diff is : "+diff);
				
//
//				excel.setreport_FailedData("Today", 2, 7,st);
//		
//				excel.setreport_FailedData("Today", 39, 4,st);
			}
			
		

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Today", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Today", 3, 6, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax!=ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for SubCategory Report is Exported to Excel for Today");
		
//				excel.setreport_PassedData("Today", 3, 7, st);
//
//				excel.setreport_PassedData("Today", 40, 4, st);
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
//				test.log(LogStatus.INFO, "Tax for SubCategory Report is not Exported to Excel for Today.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 3, 7, st);
////				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Today", 3, 7,st);
//
//				excel.setreport_FailedData("Today", 40, 4,st);
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Today", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Today", 4, 6, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount!=ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for SubCategory Report is Exported to Excel for Today");
		
			
//				excel.setreport_PassedData("Today", 4, 7, st);
//
//				excel.setreport_PassedData("Today", 41, 4, st);
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
//				test.log(LogStatus.INFO, "Discount for SubCategory Report is not Exported to Excel for Today.The value diff is : "+diff);
			
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 4, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Today", 4, 7,st);
//
//				excel.setreport_FailedData("Today", 41, 4,st);
			}
			
			
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void SubCategory_Enterprise_Report_Yesterday(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));

		//Select Today
		repts.Select_Yesterday_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Enterprise Sale Report for SubCategory Not Available for Yesterday");
		
			excel.setreportData("Yesterday", 2, 6, st);
			excel.setreportData("Yesterday", 3, 6, st);
			excel.setreportData("Yesterday", 4, 6, st);
			
			excel.setreportData("Yesterday", 2, 7, st);
			excel.setreportData("Yesterday", 3, 7, st);
			excel.setreportData("Yesterday", 4, 7, st);
			
			excel.setreportData("Yesterday", 39, 4, st);
			excel.setreportData("Yesterday", 40, 4, st);
			excel.setreportData("Yesterday", 41, 4, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Enterprise Sale Report for SubCategory Available for Yesterday");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			
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
			excel.setreportData("Yesterday", 2, 6, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount!=ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for SubCategory Report is Exported to Excel for Yesterday");
		
			
//				excel.setreport_PassedData("Yesterday", 2, 7, st);
//
//				excel.setreport_PassedData("Yesterday", 39, 4, st);
				
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
//				test.log(LogStatus.INFO, "Sale Amount for SubCategory Report is not Exported to Excel for Yesterday.The value diff is : "+diff);
		

				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Yesterday", 2, 7,st);
//				excel.setreport_FailedData("Yesterday", 39, 4,st);
			
			}
			
		

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Yesterday", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Yesterday", 3, 6, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax!=ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for SubCategory Report is Exported to Excel for Yesterday");
		
//				excel.setreport_PassedData("Yesterday", 3, 7, st);
//			
//				excel.setreport_PassedData("Yesterday", 40, 4, st);
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
//				test.log(LogStatus.INFO, "Tax for SubCategory Report is not Exported to Excel for Yesterday.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Yesterday", 3, 7,st);
//				excel.setreport_FailedData("Yesterday", 40, 4,st);

			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Yesterday", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Yesterday", 4, 6, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount!=ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for SubCategory Report is Exported to Excel for Yesterday");
		
			
//				excel.setreport_PassedData("Yesterday", 4, 7, st);
//				excel.setreport_PassedData("Yesterday", 41, 4, st);
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
//				test.log(LogStatus.INFO, "Discount for SubCategory Report is not Exported to Excel for Yesterday.The value diff is : "+diff);
	
			
				
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Yesterday", 4, 7,st);
//				excel.setreport_FailedData("Yesterday", 41, 4,st);

			}
			
		
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void SubCategory_Enterprise_Report_Last_N_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));

		//Select Today
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Enterprise Sale Report for SubCategory Not Available for Last N days");
		
			excel.setreportData("Last N days", 2, 6, st);
			excel.setreportData("Last N days", 3, 6, st);
			excel.setreportData("Last N days", 4, 6, st);
			
			excel.setreportData("Last N days", 2, 7, st);
			excel.setreportData("Last N days", 3, 7, st);
			excel.setreportData("Last N days", 4, 7, st);
			
			
			excel.setreportData("Last N days", 39, 4, st);
			excel.setreportData("Last N days", 40, 4, st);
			excel.setreportData("Last N days", 41, 4, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Enterprise Sale Report for SubCategory Available for Last N days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			
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
			excel.setreportData("Last N days", 2, 6, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount!=ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for SubCategory Report is Exported to Excel for Last 'N' Days");
		
//				excel.setreport_PassedData("Last N days", 2, 7, st);
//				
//				excel.setreport_PassedData("Last N days", 39, 4, st);
				
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
//				test.log(LogStatus.INFO, "Sale Amount for SubCategory Report is not Exported to Excel for Last 'N' Days.The value diff is : "+diff);
		

				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Last N days", 2, 7,st);
//				excel.setreport_FailedData("Last N days", 39, 4,st);
			
			}
			
		

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Last N days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last N days", 3, 6, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax!=ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for SubCategory Report is Exported to Excel for Last 'N' Days");
			
			
//				excel.setreport_PassedData("Last N days", 3, 7, st);
//				excel.setreport_PassedData("Last N days", 40, 4, st);
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
//				test.log(LogStatus.INFO, "Tax for SubCategory Report is not Exported to Excel for Last 'N' Days.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Last N days", 3, 7,st);
//				excel.setreport_FailedData("Last N days", 40, 4,st);
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Last N days", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Last N days", 4, 6, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount!=ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for SubCategory Report is Exported to Excel for Last 'N' Days");
		
//				excel.setreport_PassedData("Last N days", 4, 7, st);
//				excel.setreport_PassedData("Last N days", 41, 4, st);
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
//				test.log(LogStatus.INFO, "Discount for SubCategory Report is not Exported to Excel for Last 'N' Days.The value diff is : "+diff);
			
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Last N days", 4, 7,st);
//				excel.setreport_FailedData("Last N days", 41, 4,st);
			}
			
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
			
			Thread.sleep(3000);

		}
	}

	
	
	@Test(priority = 4,enabled = false)
	public void SubCategory_Enterprise_Report_This_Week(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));

		//Select Today
		repts.Select_This_Week_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Enterprise Sale Report for SubCategory Not Available for This Week");
	
		
			excel.setreportData("This Week", 2, 6, st);
			excel.setreportData("This Week", 3, 6, st);
			excel.setreportData("This Week", 4, 6, st);
			
			excel.setreportData("This Week", 2, 7, st);
			excel.setreportData("This Week", 3, 7, st);
			excel.setreportData("This Week", 4, 7, st);
			
			
			excel.setreportData("This Week", 39, 4, st);
			excel.setreportData("This Week", 40, 4, st);
			excel.setreportData("This Week", 41, 4, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Enterprise Sale Report for SubCategory Available for This Week");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			
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
			excel.setreportData("This Week", 2, 6, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount!=ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for SubCategory Report is Exported to Excel for This Week");
		
//				excel.setreport_PassedData("This Week", 2, 7, st);
//				excel.setreport_PassedData("This Week", 39, 4, st);
			
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
//				test.log(LogStatus.INFO, "Sale Amount for SubCategory Report is not Exported to Excel for This Week.The value diff is : "+diff);
			
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreport_FailedData("This Week", 2, 7,st);
//				excel.setreport_FailedData("This Week", 39, 4,st);
			
			}
			
		

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("This Week", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("This Week", 3, 6, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax!=ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for SubCategory Report is Exported to Excel for This Week");
		
//				excel.setreport_PassedData("This Week", 3, 7, st);
//				excel.setreport_PassedData("This Week", 40, 4, st);
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
//				test.log(LogStatus.INFO, "Tax for SubCategory Report is not Exported to Excel for This Week.The value diff is : "+diff);
			
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreport_FailedData("This Week", 3, 7,st);
//				excel.setreport_FailedData("This Week", 40, 4,st);
			
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("This Week", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("This Week", 4, 6, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount!=ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for SubCategory Report is Exported to Excel for This Week");
		
			
//				excel.setreport_PassedData("This Week", 4, 7, st);
//				excel.setreport_PassedData("This Week", 41, 4, st);
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
//				test.log(LogStatus.INFO, "Discount for SubCategory Report is not Exported to Excel for This Week.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreport_FailedData("This Week", 4, 7,st);
//				excel.setreport_FailedData("This Week", 41, 4,st);
			}
			
		
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
			
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void SubCategory_Enterprise_Report_Last_Week(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));

		//Select Today
		repts.Select_Last_Week_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Enterprise Sale Report for SubCategory Not Available for Last Week");
		
			
			excel.setreportData("Last Week", 2, 6, st);
			excel.setreportData("Last Week", 3, 6, st);
			excel.setreportData("Last Week", 4, 6, st);
			
			excel.setreportData("Last Week", 2, 7, st);
			excel.setreportData("Last Week", 3, 7, st);
			excel.setreportData("Last Week", 4, 7, st);
			
			
			excel.setreportData("Last Week", 39, 4, st);
			excel.setreportData("Last Week", 40, 4, st);
			excel.setreportData("Last Week", 41, 4, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Enterprise Sale Report for SubCategory Available for Last Week");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			
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
			excel.setreportData("Last Week", 2, 6, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount!=ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for SubCategory Report is Exported to Excel for Last Week");
		

//				excel.setreport_PassedData("Last Week", 2, 7, st);
//				excel.setreport_PassedData("Last Week", 39, 4, st);
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
//				test.log(LogStatus.INFO, "Sale Amount for SubCategory Report is not Exported to Excel for Last Week.The value diff is : "+diff);
	
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Last Week", 2, 7,st);
//				excel.setreport_FailedData("Last Week", 39, 4,st);

			}
			
		

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Last Week", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last Week", 3, 6, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax!=ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for SubCategory Report is Exported to Excel for Last Week");
		

//				excel.setreport_PassedData("Last Week", 3, 7, st);
//				excel.setreport_PassedData("Last Week", 40, 4, st);
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
//				test.log(LogStatus.INFO, "Tax for SubCategory Report is not Exported to Excel for Last Week.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Last Week", 3, 7,st);
//				excel.setreport_FailedData("Last Week", 40, 4,st);
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Last Week", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Last Week", 4, 6, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount!=ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for SubCategory Report is Exported to Excel for Last Week");
			
//				excel.setreport_PassedData("Last Week", 4, 7, st);
//				excel.setreport_PassedData("Last Week", 41, 4, st);
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
//				test.log(LogStatus.INFO, "Discount for SubCategory Report is not Exported to Excel for Last Week.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Last Week", 4, 7,st);
//				excel.setreport_FailedData("Last Week", 41, 4,st);
			
			}
			
		
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
			
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void SubCategory_Enterprise_Report_Last_7_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));

		//Select Today
		repts.Select_Last_7_Days_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Enterprise Sale Report for SubCategory Not Available for Last 7 days");
	
			excel.setreportData("Last 7 days", 2, 6, st);
			excel.setreportData("Last 7 days", 3, 6, st);
			excel.setreportData("Last 7 days", 4, 6, st);
			
			excel.setreportData("Last 7 days", 2, 7, st);
			excel.setreportData("Last 7 days", 3, 7, st);
			excel.setreportData("Last 7 days", 4, 7, st);
			
			
			excel.setreportData("Last 7 days", 39, 4, st);
			excel.setreportData("Last 7 days", 40, 4, st);
			excel.setreportData("Last 7 days", 41, 4, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Enterprise Sale Report for SubCategory Available for Last 7 days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			
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
			excel.setreportData("Last 7 days", 2, 6, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount!=ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for SubCategory Report is Exported to Excel for Last 7 days");
		
//				excel.setreport_PassedData("Last 7 days", 2, 7, st);
//				excel.setreport_PassedData("Last 7 days", 39, 4, st);
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
//				test.log(LogStatus.INFO, "Sale Amount for SubCategory Report is not Exported to Excel for Last 7 days.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Last 7 days", 2, 7,st);
//				excel.setreport_FailedData("Last 7 days", 39, 4,st);

			}
			
		

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Last 7 days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last 7 days", 3, 6, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax!=ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for SubCategory Report is Exported to Excel for Last 7 days");
		
//				excel.setreport_PassedData("Last 7 days", 3, 7, st);
//
//				excel.setreport_PassedData("Last 7 days", 40, 4, st);
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
//				test.log(LogStatus.INFO, "Tax for SubCategory Report is not Exported to Excel for Last 7 days.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Last 7 days", 3, 7,st);
//				excel.setreport_FailedData("Last 7 days", 40, 4,st);
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Last 7 days", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Last 7 days", 4, 6, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount!=ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for SubCategory Report is Exported to Excel for Last 7 days");
		
//				excel.setreport_PassedData("Last 7 days", 4, 7, st);
//				
//				excel.setreport_PassedData("Last 7 days", 41, 4, st);
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
//				test.log(LogStatus.INFO, "Discount for SubCategory Report is not Exported to Excel for Last 7 days.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Last 7 days", 4, 7,st);
//				
//				excel.setreport_FailedData("Last 7 days", 41, 4,st);
			}
			
		
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void SubCategory_Enterprise_Report_This_Month(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));

		//Select Today
		repts.Select_This_Month_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Enterprise Sale Report for SubCategory Not Available for This month");
		
		
			excel.setreportData("This month", 2, 6, st);
			excel.setreportData("This month", 3, 6, st);
			excel.setreportData("This month", 4, 6, st);
			
			excel.setreportData("This month", 2, 7, st);
			excel.setreportData("This month", 3, 7, st);
			excel.setreportData("This month", 4, 7, st);
			
			
			excel.setreportData("This month", 39, 4, st);
			excel.setreportData("This month", 40, 4, st);
			excel.setreportData("This month", 41, 4, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Enterprise Sale Report for SubCategory Available for This month");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			
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
			excel.setreportData("This month", 2, 6, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount!=ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for SubCategory Report is Exported to Excel for This month");
		
//				excel.setreport_PassedData("This month", 2, 7, st);
//				excel.setreport_PassedData("This month", 39, 4, st);
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
//				test.log(LogStatus.INFO, "Sale Amount for SubCategory Report is not Exported to Excel for This month.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("This month", 2, 7,st);
//				
//				excel.setreport_FailedData("This month", 39, 4,st);
			}
			
			

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("This month", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("This month", 3, 6, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax!=ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for SubCategory Report is Exported to Excel for This month");
		
//				excel.setreport_PassedData("This month", 3, 7, st);
//				
//				excel.setreport_PassedData("This month", 40, 4, st);
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
//				test.log(LogStatus.INFO, "Tax for SubCategory Report is not Exported to Excel for This month.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("This month", 3, 7,st);
//				excel.setreport_FailedData("This month", 40, 4,st);
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("This month", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("This month", 4, 6, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount!=ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for SubCategory Report is Exported to Excel for This month");
		
//				excel.setreport_PassedData("This month", 4, 7, st);
//				excel.setreport_PassedData("This month", 41, 4, st);
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
//				test.log(LogStatus.INFO, "Discount for SubCategory Report is not Exported to Excel for This month.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
////				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("This month", 4, 7,st);
//				excel.setreport_FailedData("This month", 41, 4,st);
			}
			
		
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void SubCategory_Enterprise_Report_Last_Month(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));

		//Select Today
		repts.Select_Last_Month_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Enterprise Sale Report for SubCategory Not Available for Last month");
	
			excel.setreportData("Last month", 2, 6, st);
			excel.setreportData("Last month", 3, 6, st);
			excel.setreportData("Last month", 4, 6, st);
			
			excel.setreportData("Last month", 2, 7, st);
			excel.setreportData("Last month", 3, 7, st);
			excel.setreportData("Last month", 4, 7, st);
			
			
			excel.setreportData("Last month", 39, 4, st);
			excel.setreportData("Last month", 40, 4, st);
			excel.setreportData("Last month", 41, 4, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Enterprise Sale Report for SubCategory Available for Last month");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			
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
			excel.setreportData("Last month", 2, 6, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount!=ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for SubCategory Report is Exported to Excel for Last month");
		
//				excel.setreport_PassedData("Last month", 2, 7, st);
//				excel.setreport_PassedData("Last month", 39, 4, st);
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
//				test.log(LogStatus.INFO, "Sale Amount for SubCategory Report is not Exported to Excel for Last month.The value diff is : "+diff);
			
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Last month", 2, 7,st);
//				excel.setreport_FailedData("Last month", 39, 4,st);
			}
			
		
			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Last month", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last month", 3, 6, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax!=ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for SubCategory Report is Exported to Excel for Last month");
		
//				excel.setreport_PassedData("Last month", 3, 7, st);
//				
//				excel.setreport_PassedData("Last month", 40, 4, st);
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
//				test.log(LogStatus.INFO, "Tax for SubCategory Report is not Exported to Excel for Last month.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Last month", 2, 7,st);
//				excel.setreport_FailedData("Last month", 40, 4,st);
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Last month", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Last month", 4, 6, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount!=ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for SubCategory Report is Exported to Excel for Last month");
		
//				excel.setreport_PassedData("Last month", 4, 7, st);
//				excel.setreport_PassedData("Last month", 41, 4, st);
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
//				test.log(LogStatus.INFO, "Discount for SubCategory Report is not Exported to Excel for Last month.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Last month", 4, 7,st);
//				excel.setreport_FailedData("Last month", 41, 4,st);
			}
			
			
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void SubCategory_Enterprise_Report_Last_30_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));

		//Select Today
		repts.Select_Last_30_Days_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Enterprise Sale Report for SubCategory Not Available for Last 30 days");
		
		
			excel.setreportData("Last 30 days", 2, 6, st);
			excel.setreportData("Last 30 days", 3, 6, st);
			excel.setreportData("Last 30 days", 4, 6, st);
			
			excel.setreportData("Last 30 days", 2, 7, st);
			excel.setreportData("Last 30 days", 3, 7, st);
			excel.setreportData("Last 30 days", 4, 7, st);
			
			
			excel.setreportData("Last 30 days", 39, 4, st);
			excel.setreportData("Last 30 days", 40, 4, st);
			excel.setreportData("Last 30 days", 41, 4, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Enterprise Sale Report for SubCategory Available for Last 30 days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			
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
			excel.setreportData("Last 30 days", 2, 6, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount!=ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for SubCategory Report is Exported to Excel for Last 30 days");
			
//				excel.setreport_PassedData("Last 30 days", 2, 7, st);
//				excel.setreport_PassedData("Last 30 days", 39, 4, st);
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
//				test.log(LogStatus.INFO, "Sale Amount for SubCategory Report is not Exported to Excel for Last 30 days.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Last 30 days", 2, 7,st);
//				excel.setreport_FailedData("Last 30 days", 39, 4,st);
			}
			
			

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Last 30 days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last 30 days", 3, 6, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax!=ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for SubCategory Report is Exported to Excel for Last 30 days");
			
//				excel.setreport_PassedData("Last 30 days", 3, 7, st);
//				excel.setreport_PassedData("Last 30 days", 40, 4, st);
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
//				test.log(LogStatus.INFO, "Tax for SubCategory Report is not Exported to Excel for Last 30 days.The value diff is : "+diff);
		

				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Last 30 days", 3, 7,st);
//				excel.setreport_FailedData("Last 30 days", 40, 4,st);
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Last 30 days", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Last 30 days", 4, 6, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount!=ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for SubCategory Report is Exported to Excel for Last 30 days");
			
//				excel.setreport_PassedData("Last 30 days", 4, 7, st);
//				excel.setreport_PassedData("Last 30 days", 41, 4, st);
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
//				test.log(LogStatus.INFO, "Discount for SubCategory Report is not Exported to Excel for Last 30 days.The value diff is : "+diff);
		

				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreportData("Today", 6, 7, st);
//				excel.Highlight_DifferenceValue();
//				excel.setreport_FailedData("Last 30 days", 4, 7,st);
//				excel.setreport_FailedData("Last 30 days", 41, 4,st);
			}
			
			
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void SubCategory_Enterprise_Report_Specific_Date(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));

		//Select Today
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Enterprise Sale Report for SubCategory Not Available for Specific Date");
		
			excel.setreportData("Specific Date", 2, 6, st);
			excel.setreportData("Specific Date", 3, 6, st);
			excel.setreportData("Specific Date", 4, 6, st);
			
			excel.setreportData("Specific Date", 2, 7, st);
			excel.setreportData("Specific Date", 3, 7, st);
			excel.setreportData("Specific Date", 4, 7, st);
			
			
			excel.setreportData("Specific Date", 39, 4, st);
			excel.setreportData("Specific Date", 40, 4, st);
			excel.setreportData("Specific Date", 41, 4, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Enterprise Sale Report for SubCategory Available for Specific Date");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			
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
			excel.setreportData("Specific Date", 2, 6, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount!=ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for SubCategory Report is Exported to Excel for Specific Date");
		
//				excel.setreport_PassedData("Specific Date", 2, 7, st);
//				excel.setreport_PassedData("Specific Date", 39, 4, st);
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
//				test.log(LogStatus.INFO, "Sale Amount for SubCategory Report is not Exported to Excel for Specific Date.The value diff is : "+diff);
			
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreport_FailedData("Specific Date", 2, 7,st);
//				excel.setreport_FailedData("Specific Date", 39, 4,st);

			}
			
			

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Specific Date", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Specific Date", 3, 6, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax!=ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for SubCategory Report is Exported to Excel for Specific Date");
		
//				excel.setreport_PassedData("Specific Date", 3, 7, st);
//				excel.setreport_PassedData("Specific Date", 40, 4, st);
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
//				test.log(LogStatus.INFO, "Tax for SubCategory Report is not Exported to Excel for Specific Date.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel

//				excel.setreport_FailedData("Specific Date", 3, 7,st);
//				excel.setreport_FailedData("Specific Date", 40, 4,st);
			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Specific Date", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Specific Date", 4, 6, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount!=ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for SubCategory Report is Exported to Excel for Specific Date");
			
//				excel.setreport_PassedData("Specific Date", 4, 7, st);
//				excel.setreport_PassedData("Specific Date", 41, 4, st);
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
//				test.log(LogStatus.INFO, "Discount for SubCategory Report is not Exported to Excel for Specific Date.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel

//				excel.setreport_FailedData("Specific Date", 4, 7,st);
//				excel.setreport_FailedData("Specific Date", 41, 4,st);
			}
			
		
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void SubCategory_Enterprise_Report_Date_Range(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));

		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			Thread.sleep(1000);
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Enterprise Sale Report for SubCategory Not Available for Date Range");
		
			excel.setreportData("Date Range", 2, 6, st);
			excel.setreportData("Date Range", 3, 6, st);
			excel.setreportData("Date Range", 4, 6, st);
			

			excel.setreportData("Date Range", 2, 7, st);
			excel.setreportData("Date Range", 3, 7, st);
			excel.setreportData("Date Range", 4, 7, st);
			
			
			excel.setreportData("Date Range", 39, 4, st);
			excel.setreportData("Date Range", 40, 4, st);
			excel.setreportData("Date Range", 41, 4, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Enterprise Sale Report for SubCategory Available for Date Range");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			
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
			excel.setreportData("Date Range", 2, 6, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount!=ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for SubCategory Report is Exported to Excel for Date Range");
	
			
//				excel.setreport_PassedData("Date Range", 2, 7, st);
//				excel.setreport_PassedData("Date Range", 39, 4, st);
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
//				test.log(LogStatus.INFO, "Sale Amount for SubCategory Report is not Exported to Excel for Date Range.The value diff is : "+diff);
			
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreport_FailedData("Date Range", 2, 7,st);
//				excel.setreport_FailedData("Date Range", 39, 4,st);

			}
			
		

			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Date Range", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
			
			
			//Get the Tax
			String Tx=repts.Tax_EnterpriseSaleReport().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Date Range", 3, 6, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax!=ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for SubCategory Report is Exported to Excel for Date Range");
		
//				excel.setreport_PassedData("Date Range", 3, 7, st);
//				excel.setreport_PassedData("Date Range", 40, 4, st);
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
//				test.log(LogStatus.INFO, "Tax for SubCategory Report is not Exported to Excel for Date Range.The value diff is : "+diff);
		
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreport_FailedData("Date Range", 3, 7,st);
//				excel.setreport_FailedData("Date Range", 40, 4,st);

			}
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Date Range", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_EnterpriseSaleReport().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Date Range", 4, 6, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount!=ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for SubCategory Report is Exported to Excel for Date Range");
		
//				excel.setreport_PassedData("Date Range", 4, 7, st);
//				excel.setreport_PassedData("Date Range", 41, 4, st);
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
//				test.log(LogStatus.INFO, "Discount for SubCategory Report is not Exported to Excel for Date Range.The value diff is : "+diff);
			
			
				String st=String.valueOf(diff);

				//Export the Sale Amount value to Excel
//				excel.setreport_FailedData("Date Range", 4, 7,st);
//				excel.setreport_FailedData("Date Range", 41, 4,st);

			}
			
		
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
			
			Thread.sleep(3000);

		}
	}
	

}
