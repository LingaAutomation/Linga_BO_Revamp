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

public class Reports_Cashier_Out_Report 
{

public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Cashier Out Report");
	
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
		Open_Cashier_Out_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Cashier_Out_Report_Today(driver);
		Cashier_Out_Report_Yesterday(driver);
		Cashier_Out_Report_Last_N_Days(driver);
		Cashier_Out_Report_This_Week(driver);
		Cashier_Out_Report_Last_Week(driver);
		Cashier_Out_Report_Last_7_Days(driver);
		Cashier_Out_Report_This_Month(driver);
		Cashier_Out_Report_Last_Month(driver);
		Cashier_Out_Report_Last_30_Days(driver);
		Cashier_Out_Report_Specific_Date(driver);
		Cashier_Out_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Cashier_Out_Report_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Daily page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"salesReports/cashier-out");

		Thread.sleep(5000);
		//Verify the Categories page loaded or not
		repts.Verify_ReportHomePage("CASHIER OUT");
		
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
	public void Cashier_Out_Report_Today(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		

	
		
		Thread.sleep(2000);
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(10000);
		try
		{
			
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Cashier Report Not Available for Today");
	
			excel.setreportData("Today", 2, 16, st);
			excel.setreportData("Today", 3, 16, st);
			excel.setreportData("Today", 4, 16, st);
			excel.setreportData("Today", 5, 16, st);
			excel.setreportData("Today", 6, 16, st);
			excel.setreportData("Today", 7, 16, st);
			
			excel.setreportData("Today", 2, 17, st);
			excel.setreportData("Today", 3, 17, st);
			excel.setreportData("Today", 4, 17, st);
			excel.setreportData("Today", 5, 17, st);
			excel.setreportData("Today", 6, 17, st);
			excel.setreportData("Today", 7, 17, st);
			
			excel.setreportData("Today", 39, 8, st);
			excel.setreportData("Today", 40, 8, st);
			excel.setreportData("Today", 41, 8, st);
			excel.setreportData("Today", 42, 8, st);
			excel.setreportData("Today", 43, 8, st);
			excel.setreportData("Today", 44, 8, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Cashier Report Available for Today");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			if(repts.Sales_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Sales Table Field Available");

//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_Net_Sale=excel.getData("Today", 2, 1).toString().replace(",", "");
			double Expected_NetSale=Double.parseDouble(Expected_Net_Sale);
			
			Thread.sleep(3000);
			//Get Net Sales
			String NetSale=repts.Net_Sales_SaleRecap().getText().replace(",", "");
			double ActualNet_Sales=Double.parseDouble(NetSale);
			
			//Export the Net Sales value to Excel
			excel.setreportData("Today", 2, 16, NetSale);

			
			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSale==ActualNet_Sales)
			{
				test.log(LogStatus.PASS, "Net Sales for Cashier Report Report is equal to Sale Recap Report for Today");
	
			excel.setreport_PassedData("Today", 2, 17, "0.00");
			
			excel.setreport_PassedData("Today", 39, 8, NetSale+"`");

			
			}
			else
			{
				double diff=Expected_NetSale-ActualNet_Sales;
				String diff_value=String.valueOf(diff);
				
				test.log(LogStatus.FAIL, "Net Sales for Cashier Report Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
				

				excel.setreport_FailedData("Today", 2, 17,diff_value);
		
				excel.setreport_FailedData("Today", 39, 8,diff_value);
			}
			
			
			//Get the Grand_Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("Today", 5, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
			
			//Get the Grand_Sales
			String GrandSale=repts.Grand_Sales_SaleRecap().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
			//Export Grand_Sales value to Excel
			excel.setreportData("Today", 5, 16, GrandSale);

			//Check whether the Discount value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Cashier Report Report is equal to Sale Recap Report for Today");
		
			
				excel.setreport_PassedData("Today", 5, 17, "0.00");

				excel.setreport_PassedData("Today", 42, 8, GrandSale+"`");
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Cashier Report Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
			
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 5, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Today", 5, 17,diff_value);

				excel.setreport_FailedData("Today", 42, 8,diff_value);
			}
			
			//Get the Gross Receipt from Sale Recap Report
			String Expected_GrossReceipt=excel.getData("Today", 6, 1).toString().replace(",", "");
			double Expected_Gross_Receipt=Double.parseDouble(Expected_GrossReceipt);
		
			
			//Get the Gross Receipt
			String GrossReceipt=repts.Gross_Receipt_SaleRecap().getText().replace(",", "");
			double ActualGross_Receipt=Double.parseDouble(GrossReceipt);
			
			//Export the  Gross Receipt value to Excel
			excel.setreportData("Today", 6, 16, GrossReceipt);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Receipt==ActualGross_Receipt)
			{
				test.log(LogStatus.PASS, "Gross Receipt for Cashier Report Report is equal to Sale Recap Report for Today");
		
				excel.setreport_PassedData("Today", 6, 17, "0.00");

				excel.setreport_PassedData("Today", 43, 8, GrossReceipt+"`");
			}
			else
			{
				double diff=Expected_Gross_Receipt-ActualGross_Receipt;
				test.log(LogStatus.FAIL, "Gross Receipt for Cashier Report Report is not equal to Sale Recap Report  for Today.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Today", 6, 17,diff_value);
				excel.setreport_FailedData("Today", 43, 8,diff_value);
			
			}
			
			
			//Get the Gross Sales from Sale Recap Report
			String Expected_GrossSales=excel.getData("Today", 7, 1).toString().replace(",", "");
			double Expected_Gross_Sales=Double.parseDouble(Expected_GrossSales);
		
			
			//Get the Gross Sales
			String GrossSales=repts.Gross_Sales_SaleRecap().getText().replace(",", "");
			double ActualGross_Sales=Double.parseDouble(GrossSales);
			
			//Export the Gross Sales of Sale value to Excel
			excel.setreportData("Today", 7, 16, GrossSales);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Sales==ActualGross_Sales)
			{
				test.log(LogStatus.PASS, "Gross Sales for Cashier Report Report is equal to Sale Recap Report for Today");
		
				excel.setreport_PassedData("Today", 7, 17, "0.00");

				excel.setreport_PassedData("Today", 44, 8, GrossSales+"`");
			}
			else
			{
				double diff=Expected_Gross_Sales-ActualGross_Sales;
				test.log(LogStatus.FAIL, "Gross Sales for Cashier Report Report is not equal to Sale Recap Report  for Today.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Today", 7, 17,diff_value);
				excel.setreport_FailedData("Today", 44, 8,diff_value);
			
			}
			
			
			
			//Get the Net Void
			String NetVoid=repts.Net_Void_SaleRecap().getText().replace(",", "");
			double ActualNet_Void=Double.parseDouble(NetVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("Today", 9, 16, NetVoid);
			excel.setreportData("Today", 46, 8, NetVoid);
			
			
			
			//Get the Gross Void
			String GrossVoid=repts.Gross_Void_SaleRecap().getText().replace(",", "");
			double ActualGross_Void=Double.parseDouble(GrossVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("Today", 10, 16, GrossVoid);
			excel.setreportData("Today", 47, 8, GrossVoid);
			
			}
			else
			{
				test.log(LogStatus.FAIL, "Sales Table Field not available");
	
			}
			
			try
			{
			if(repts.Taxes_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Taxes Table Field Available");
				
			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Today", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
		
			//Get the Tax
			String Tx=repts.Tax_SaleRecap().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			
			//Export Tax value to Excel
			excel.setreportData("Today", 3, 16, Tx);
			
			
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Cashier Report Report is equal to Sale Recap Report for Today");
		
				excel.setreport_PassedData("Today", 3, 17, "0");

				excel.setreport_PassedData("Today", 40, 8, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Cashier Report Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 3, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Today", 3, 17,diff_value);

				excel.setreport_FailedData("Today", 40, 8,diff_value);
			}
			
			
			
			try
			{
			if(repts.Tax_Exempt_SaleRecap().isDisplayed())
			{
			//Get the Tax Exempted
			String Tx_Exmpted=repts.Tax_Exempt_SaleRecap().getText().replace(",", "");
			double ActualTax_Exempted=Double.parseDouble(Tx_Exmpted);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("Today", 8, 16, Tx_Exmpted);
			excel.setreportData("Today", 45, 8, Tx_Exmpted);
			}
			}
			catch(Exception p)
			{
				test.log(LogStatus.INFO, "Tax Exempted not available");
				
				//Export Tax Exempted value to Excel
				excel.setreportData("Today", 8, 16, st);
				excel.setreportData("Today", 45, 8, st);
			}
			
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_SaleRecap().getText().replace(",", "");
			double ActualRounding_Off=Double.parseDouble(RoundOff);
			
			//Export Tax value to Excel
			excel.setreportData("Today", 12, 16, RoundOff);
			excel.setreportData("Today", 49, 8, RoundOff);
		}
			}
			catch(Exception ll)
		{
			test.log(LogStatus.FAIL, "Taxes Table Field not available");
			
			
			//Export Tax value to Excel
			excel.setreportData("Today", 3, 16, st);
			excel.setreportData("Today", 40, 8, st);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("Today", 8, 16, st);
			excel.setreportData("Today", 45, 8, st);
			
			//Export Tax value to Excel
			excel.setreportData("Today", 12, 16, st);
			excel.setreportData("Today", 49, 8, st);
			
		}
			
			try
			{
				
			if(repts.Discount_SaleRecap().isDisplayed())
			{
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Today", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_SaleRecap().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Today", 4, 16, Discnt);

			//Check whether the Discount value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Cashier Report Report is equal to Sale Recap Report for Today");
		
				excel.setreport_PassedData("Today", 4, 17, "0.00");

				excel.setreport_PassedData("Today", 41, 8, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Cashier Report Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 4, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Today", 4, 17,diff_value);

				excel.setreport_FailedData("Today", 41, 8,diff_value);
			}
			
			
			//Get Discount Tax
			String DiscntTx=repts.Discount_Tax_SaleRecap().getText().replace(",", "");
			double ActualDiscount_Tax=Double.parseDouble(DiscntTx);
			
			//Export Discount Tax value to Excel
			excel.setreportData("Today", 13, 16, DiscntTx);
			excel.setreportData("Today", 50, 8, DiscntTx);
			
		}
		}
		catch(Exception h)
		{
			test.log(LogStatus.FAIL, "Discount Table Field not available");

			
			//Export Discount value to Excel
			excel.setreportData("Today", 4, 16, "0.00");
			excel.setreportData("Today", 41, 8, "0.00");
			
			
			
			
			//Export Discount Tax value to Excel
			excel.setreportData("Today", 13, 16, st);
			excel.setreportData("Today", 50, 8, st);
		}
		
			
		try
		{
			if(repts.Refund_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Refund Table Field Available");
				
				//Get Refund Tax
				String Refund=repts.Refund_SaleRecap().getText().replace(",", "");
				double ActualRefund=Double.parseDouble(Refund);
				
				//Export Discount value to Excel
				excel.setreportData("Today", 11, 16, Refund);
				excel.setreportData("Today", 48, 8, Refund);
			}
		}
		catch(Exception l)
		{
				test.log(LogStatus.FAIL, "Refund Table Field not available");

				//Export Discount value to Excel
				excel.setreportData("Today", 11, 16, st);
				excel.setreportData("Today", 48, 8, st);
		}
			
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Cashier_Out_Report_Yesterday(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		
				
		//Select Today
		repts.Select_Yesterday_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Cashier Report Not Available for Yesterday");
		
			excel.setreportData("Yesterday", 2, 16, st);
			excel.setreportData("Yesterday", 3, 16, st);
			excel.setreportData("Yesterday", 4, 16, st);
			excel.setreportData("Yesterday", 5, 16, st);
			excel.setreportData("Yesterday", 6, 16, st);
			excel.setreportData("Yesterday", 7, 16, st);
			
			excel.setreportData("Yesterday", 2, 17, st);
			excel.setreportData("Yesterday", 3, 17, st);
			excel.setreportData("Yesterday", 4, 17, st);
			excel.setreportData("Yesterday", 5, 17, st);
			excel.setreportData("Yesterday", 6, 17, st);
			excel.setreportData("Yesterday", 7, 17, st);
			
			excel.setreportData("Yesterday", 39, 8, st);
			excel.setreportData("Yesterday", 40, 8, st);
			excel.setreportData("Yesterday", 41, 8, st);
			excel.setreportData("Yesterday", 42, 8, st);
			excel.setreportData("Yesterday", 43, 8, st);
			excel.setreportData("Yesterday", 44, 8, st);
			
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Cashier Report Available for Yesterday");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			if(repts.Sales_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Sales Table Field Available");

//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_Net_Sale=excel.getData("Yesterday", 2, 1).toString().replace(",", "");
			double Expected_NetSale=Double.parseDouble(Expected_Net_Sale);
			
			Thread.sleep(3000);
			//Get Net Sales
			String NetSale=repts.Net_Sales_SaleRecap().getText().replace(",", "");
			double ActualNet_Sales=Double.parseDouble(NetSale);
			
			//Export the Net Sales value to Excel
			excel.setreportData("Yesterday", 2, 16, NetSale);

			
			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSale==ActualNet_Sales)
			{
				test.log(LogStatus.PASS, "Net Sales for Cashier Report Report is equal to Sale Recap Report for Yesterday");
	
			excel.setreport_PassedData("Yesterday", 2, 17, "0.00");
			
			excel.setreport_PassedData("Yesterday", 39, 8, NetSale+"`");

			
			}
			else
			{
				double diff=Expected_NetSale-ActualNet_Sales;
				String diff_value=String.valueOf(diff);
				
				test.log(LogStatus.FAIL, "Net Sales for Cashier Report Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
				

				excel.setreport_FailedData("Yesterday", 2, 17,diff_value);
		
				excel.setreport_FailedData("Yesterday", 39, 8,diff_value);
			}
			
			
			//Get the Grand_Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("Yesterday", 5, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
			
			//Get the Grand_Sales
			String GrandSale=repts.Grand_Sales_SaleRecap().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
			//Export Grand_Sales value to Excel
			excel.setreportData("Yesterday", 5, 16, GrandSale);

			//Check whether the Discount value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Cashier Report Report is equal to Sale Recap Report for Yesterday");
		
			
				excel.setreport_PassedData("Yesterday", 5, 17, "0.00");

				excel.setreport_PassedData("Yesterday", 42, 8, GrandSale+"`");
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Cashier Report Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
			
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 5, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Yesterday", 5, 17,diff_value);

				excel.setreport_FailedData("Yesterday", 42, 8,diff_value);
			}
			
			//Get the Gross Receipt from Sale Recap Report
			String Expected_GrossReceipt=excel.getData("Yesterday", 6, 1).toString().replace(",", "");
			double Expected_Gross_Receipt=Double.parseDouble(Expected_GrossReceipt);
		
			
			//Get the Gross Receipt
			String GrossReceipt=repts.Gross_Receipt_SaleRecap().getText().replace(",", "");
			double ActualGross_Receipt=Double.parseDouble(GrossReceipt);
			
			//Export the  Gross Receipt value to Excel
			excel.setreportData("Yesterday", 6, 16, GrossReceipt);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Receipt==ActualGross_Receipt)
			{
				test.log(LogStatus.PASS, "Gross Receipt for Cashier Report Report is equal to Sale Recap Report for Yesterday");
		
				excel.setreport_PassedData("Yesterday", 6, 17, "0.00");

				excel.setreport_PassedData("Yesterday", 43, 8, GrossReceipt+"`");
			}
			else
			{
				double diff=Expected_Gross_Receipt-ActualGross_Receipt;
				test.log(LogStatus.FAIL, "Gross Receipt for Cashier Report Report is not equal to Sale Recap Report  for Yesterday.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Yesterday", 6, 17,diff_value);
				excel.setreport_FailedData("Yesterday", 43, 8,diff_value);
			
			}
			
			
			//Get the Gross Sales from Sale Recap Report
			String Expected_GrossSales=excel.getData("Yesterday", 7, 1).toString().replace(",", "");
			double Expected_Gross_Sales=Double.parseDouble(Expected_GrossSales);
		
			
			//Get the Gross Sales
			String GrossSales=repts.Gross_Sales_SaleRecap().getText().replace(",", "");
			double ActualGross_Sales=Double.parseDouble(GrossSales);
			
			//Export the Gross Sales of Sale value to Excel
			excel.setreportData("Yesterday", 7, 16, GrossSales);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Sales==ActualGross_Sales)
			{
				test.log(LogStatus.PASS, "Gross Sales for Cashier Report Report is equal to Sale Recap Report for Yesterday");
		
				excel.setreport_PassedData("Yesterday", 7, 17, "0.00");

				excel.setreport_PassedData("Yesterday", 44, 8, GrossSales+"`");
			}
			else
			{
				double diff=Expected_Gross_Sales-ActualGross_Sales;
				test.log(LogStatus.FAIL, "Gross Sales for Cashier Report Report is not equal to Sale Recap Report  for Yesterday.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Yesterday", 7, 17,diff_value);
				excel.setreport_FailedData("Yesterday", 44, 8,diff_value);
			
			}
			
			
			
			//Get the Net Void
			String NetVoid=repts.Net_Void_SaleRecap().getText().replace(",", "");
			double ActualNet_Void=Double.parseDouble(NetVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("Yesterday", 9, 16, NetVoid);
			excel.setreportData("Yesterday", 46, 8, NetVoid);
			
			
			
			//Get the Gross Void
			String GrossVoid=repts.Gross_Void_SaleRecap().getText().replace(",", "");
			double ActualGross_Void=Double.parseDouble(GrossVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("Yesterday", 10, 16, GrossVoid);
			excel.setreportData("Yesterday", 47, 8, GrossVoid);
			
			}
			else
			{
				test.log(LogStatus.FAIL, "Sales Table Field not available");
	
			}

			try
			{
			if(repts.Taxes_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Taxes Table Field Available");
				
			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Yesterday", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
		
			//Get the Tax
			String Tx=repts.Tax_SaleRecap().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Yesterday", 3, 16, Tx);
			
			
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Cashier Report Report is equal to Sale Recap Report for Yesterday");
		
				excel.setreport_PassedData("Yesterday", 3, 17, "0");

				excel.setreport_PassedData("Yesterday", 40, 8, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Cashier Report Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 3, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Yesterday", 3, 17,diff_value);

				excel.setreport_FailedData("Yesterday", 40, 8,diff_value);
			}
			
			
			
			try
			{
			if(repts.Tax_Exempt_SaleRecap().isDisplayed())
			{
			//Get the Tax Exempted
			String Tx_Exmpted=repts.Tax_Exempt_SaleRecap().getText().replace(",", "");
			double ActualTax_Exempted=Double.parseDouble(Tx_Exmpted);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("Yesterday", 8, 16, Tx_Exmpted);
			excel.setreportData("Yesterday", 45, 8, Tx_Exmpted);
			}
			}
			catch(Exception p)
			{
				test.log(LogStatus.INFO, "Tax Exempted not available");
				
				//Export Tax Exempted value to Excel
				excel.setreportData("Yesterday", 8, 16, st);
				excel.setreportData("Yesterday", 45, 8, st);
			}
			
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_SaleRecap().getText().replace(",", "");
			double ActualRounding_Off=Double.parseDouble(RoundOff);
			
			//Export Tax value to Excel
			excel.setreportData("Yesterday", 12, 16, RoundOff);
			excel.setreportData("Yesterday", 49, 8, RoundOff);
		}
			}
			catch(Exception ll)
		{
			test.log(LogStatus.FAIL, "Taxes Table Field not available");
			
			
			//Export Tax value to Excel
			excel.setreportData("Yesterday", 3, 16, st);
			excel.setreportData("Yesterday", 40, 8, st);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("Yesterday", 8, 16, st);
			excel.setreportData("Yesterday", 45, 8, st);
			
			//Export Tax value to Excel
			excel.setreportData("Yesterday", 12, 16, st);
			excel.setreportData("Yesterday", 49, 8, st);
			
		}
			
			try
			{
				
			if(repts.Discount_SaleRecap().isDisplayed())
			{
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Yesterday", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_SaleRecap().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Yesterday", 4, 16, Discnt);

			//Check whether the Discount value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Cashier Report Report is equal to Sale Recap Report for Yesterday");
		
				excel.setreport_PassedData("Yesterday", 4, 17, "0.00");

				excel.setreport_PassedData("Yesterday", 41, 8, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Cashier Report Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 4, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Yesterday", 4, 17,diff_value);

				excel.setreport_FailedData("Yesterday", 41, 8,diff_value);
			}
			
			
			//Get Discount Tax
			String DiscntTx=repts.Discount_Tax_SaleRecap().getText().replace(",", "");
			double ActualDiscount_Tax=Double.parseDouble(DiscntTx);
			
			//Export Discount Tax value to Excel
			excel.setreportData("Yesterday", 13, 16, DiscntTx);
			excel.setreportData("Yesterday", 50, 8, DiscntTx);
			
		}
		}
		catch(Exception h)
		{
			test.log(LogStatus.FAIL, "Discount Table Field not available");

			
			//Export Discount value to Excel
			excel.setreportData("Yesterday", 4, 16, "0.00");
			excel.setreportData("Yesterday", 41, 8, "0.00");
			
			
			
			
			//Export Discount Tax value to Excel
			excel.setreportData("Yesterday", 13, 16, st);
			excel.setreportData("Yesterday", 50, 8, st);
		}
		
			
		try
		{
			if(repts.Refund_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Refund Table Field Available");
				
				//Get Refund Tax
				String Refund=repts.Refund_SaleRecap().getText().replace(",", "");
				double ActualRefund=Double.parseDouble(Refund);
				
				//Export Discount value to Excel
				excel.setreportData("Yesterday", 11, 16, Refund);
				excel.setreportData("Yesterday", 48, 8, Refund);
			}
		}
		catch(Exception l)
		{
				test.log(LogStatus.FAIL, "Refund Table Field not available");

				//Export Discount value to Excel
				excel.setreportData("Yesterday", 11, 16, st);
				excel.setreportData("Yesterday", 48, 8, st);
		}
			

			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Cashier_Out_Report_Last_N_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		
		
				
		//Select Today
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Cashier Report Not Available for Last N days");
		
			excel.setreportData("Last N days", 2, 16, st);
			excel.setreportData("Last N days", 3, 16, st);
			excel.setreportData("Last N days", 4, 16, st);
			excel.setreportData("Last N days", 5, 16, st);
			excel.setreportData("Last N days", 6, 16, st);
			excel.setreportData("Last N days", 7, 16, st);
			
			excel.setreportData("Last N days", 2, 17, st);
			excel.setreportData("Last N days", 3, 17, st);
			excel.setreportData("Last N days", 4, 17, st);
			excel.setreportData("Last N days", 5, 17, st);
			excel.setreportData("Last N days", 6, 17, st);
			excel.setreportData("Last N days", 7, 17, st);
			
			excel.setreportData("Last N days", 39, 8, st);
			excel.setreportData("Last N days", 40, 8, st);
			excel.setreportData("Last N days", 41, 8, st);
			excel.setreportData("Last N days", 42, 8, st);
			excel.setreportData("Last N days", 43, 8, st);
			excel.setreportData("Last N days", 44, 8, st);
			
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Cashier Report Available for Last N days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			if(repts.Sales_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Sales Table Field Available");

//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_Net_Sale=excel.getData("Last N days", 2, 1).toString().replace(",", "");
			double Expected_NetSale=Double.parseDouble(Expected_Net_Sale);
			
			Thread.sleep(3000);
			//Get Net Sales
			String NetSale=repts.Net_Sales_SaleRecap().getText().replace(",", "");
			double ActualNet_Sales=Double.parseDouble(NetSale);
			
			//Export the Net Sales value to Excel
			excel.setreportData("Last N days", 2, 16, NetSale);

			
			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSale==ActualNet_Sales)
			{
				test.log(LogStatus.PASS, "Net Sales for Cashier Report Report is equal to Sale Recap Report for Last N days");
	
			excel.setreport_PassedData("Last N days", 2, 17, "0.00");
			
			excel.setreport_PassedData("Last N days", 39, 8, NetSale+"`");

			
			}
			else
			{
				double diff=Expected_NetSale-ActualNet_Sales;
				String diff_value=String.valueOf(diff);
				
				test.log(LogStatus.FAIL, "Net Sales for Cashier Report Report is not equal to Sale Recap Report for Last N days.The value diff is : "+diff);
				

				excel.setreport_FailedData("Last N days", 2, 17,diff_value);
		
				excel.setreport_FailedData("Last N days", 39, 8,diff_value);
			}
			
			
			//Get the Grand_Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("Last N days", 5, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
			
			//Get the Grand_Sales
			String GrandSale=repts.Grand_Sales_SaleRecap().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
			//Export Grand_Sales value to Excel
			excel.setreportData("Last N days", 5, 16, GrandSale);

			//Check whether the Discount value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Cashier Report Report is equal to Sale Recap Report for Last N days");
		
			
				excel.setreport_PassedData("Last N days", 5, 17, "0.00");

				excel.setreport_PassedData("Last N days", 42, 8, GrandSale+"`");
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Cashier Report Report is not equal to Sale Recap Report for Last N days.The value diff is : "+diff);
			
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 5, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last N days", 5, 17,diff_value);

				excel.setreport_FailedData("Last N days", 42, 8,diff_value);
			}
			
			//Get the Gross Receipt from Sale Recap Report
			String Expected_GrossReceipt=excel.getData("Last N days", 6, 1).toString().replace(",", "");
			double Expected_Gross_Receipt=Double.parseDouble(Expected_GrossReceipt);
		
			
			//Get the Gross Receipt
			String GrossReceipt=repts.Gross_Receipt_SaleRecap().getText().replace(",", "");
			double ActualGross_Receipt=Double.parseDouble(GrossReceipt);
			
			//Export the  Gross Receipt value to Excel
			excel.setreportData("Last N days", 6, 16, GrossReceipt);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Receipt==ActualGross_Receipt)
			{
				test.log(LogStatus.PASS, "Gross Receipt for Cashier Report Report is equal to Sale Recap Report for Last N days");
		
				excel.setreport_PassedData("Last N days", 6, 17, "0.00");

				excel.setreport_PassedData("Last N days", 43, 8, GrossReceipt+"`");
			}
			else
			{
				double diff=Expected_Gross_Receipt-ActualGross_Receipt;
				test.log(LogStatus.FAIL, "Gross Receipt for Cashier Report Report is not equal to Sale Recap Report  for Last N days.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last N days", 6, 17,diff_value);
				excel.setreport_FailedData("Last N days", 43, 8,diff_value);
			
			}
			
			
			//Get the Gross Sales from Sale Recap Report
			String Expected_GrossSales=excel.getData("Last N days", 7, 1).toString().replace(",", "");
			double Expected_Gross_Sales=Double.parseDouble(Expected_GrossSales);
		
			
			//Get the Gross Sales
			String GrossSales=repts.Gross_Sales_SaleRecap().getText().replace(",", "");
			double ActualGross_Sales=Double.parseDouble(GrossSales);
			
			//Export the Gross Sales of Sale value to Excel
			excel.setreportData("Last N days", 7, 16, GrossSales);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Sales==ActualGross_Sales)
			{
				test.log(LogStatus.PASS, "Gross Sales for Cashier Report Report is equal to Sale Recap Report for Last N days");
		
				excel.setreport_PassedData("Last N days", 7, 17, "0.00");

				excel.setreport_PassedData("Last N days", 44, 8, GrossSales+"`");
			}
			else
			{
				double diff=Expected_Gross_Sales-ActualGross_Sales;
				test.log(LogStatus.FAIL, "Gross Sales for Cashier Report Report is not equal to Sale Recap Report  for Last N days.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last N days", 7, 17,diff_value);
				excel.setreport_FailedData("Last N days", 44, 8,diff_value);
			
			}
			
			
			
			//Get the Net Void
			String NetVoid=repts.Net_Void_SaleRecap().getText().replace(",", "");
			double ActualNet_Void=Double.parseDouble(NetVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("Last N days", 9, 16, NetVoid);
			excel.setreportData("Last N days", 46, 8, NetVoid);
			
			
			
			//Get the Gross Void
			String GrossVoid=repts.Gross_Void_SaleRecap().getText().replace(",", "");
			double ActualGross_Void=Double.parseDouble(GrossVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("Last N days", 10, 16, GrossVoid);
			excel.setreportData("Last N days", 47, 8, GrossVoid);
			
			}
			else
			{
				test.log(LogStatus.FAIL, "Sales Table Field not available");
	
			}
			
			try
			{
			if(repts.Taxes_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Taxes Table Field Available");
				
			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Last N days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
		
			//Get the Tax
			String Tx=repts.Tax_SaleRecap().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last N days", 3, 16, Tx);
			
			
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Cashier Report Report is equal to Sale Recap Report for Last N days");
		
				excel.setreport_PassedData("Last N days", 3, 17, "0");

				excel.setreport_PassedData("Last N days", 40, 8, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Cashier Report Report is not equal to Sale Recap Report for Last N days.The value diff is : "+diff);
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 3, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last N days", 3, 17,diff_value);

				excel.setreport_FailedData("Last N days", 40, 8,diff_value);
			}
			
			
			
			try
			{
			if(repts.Tax_Exempt_SaleRecap().isDisplayed())
			{
			//Get the Tax Exempted
			String Tx_Exmpted=repts.Tax_Exempt_SaleRecap().getText().replace(",", "");
			double ActualTax_Exempted=Double.parseDouble(Tx_Exmpted);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("Last N days", 8, 16, Tx_Exmpted);
			excel.setreportData("Last N days", 45, 8, Tx_Exmpted);
			}
			}
			catch(Exception p)
			{
				test.log(LogStatus.INFO, "Tax Exempted not available");
				
				//Export Tax Exempted value to Excel
				excel.setreportData("Last N days", 8, 16, st);
				excel.setreportData("Last N days", 45, 8, st);
			}
			
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_SaleRecap().getText().replace(",", "");
			double ActualRounding_Off=Double.parseDouble(RoundOff);
			
			//Export Tax value to Excel
			excel.setreportData("Last N days", 12, 16, RoundOff);
			excel.setreportData("Last N days", 49, 8, RoundOff);
		}

			}
			catch(Exception ll)
		{
			test.log(LogStatus.FAIL, "Taxes Table Field not available");
			
			
			//Export Tax value to Excel
			excel.setreportData("Last N days", 3, 16, st);
			excel.setreportData("Last N days", 40, 8, st);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("Last N days", 8, 16, st);
			excel.setreportData("Last N days", 45, 8, st);
			
			//Export Tax value to Excel
			excel.setreportData("Last N days", 12, 16, st);
			excel.setreportData("Last N days", 49, 8, st);
			
		}
			
			try
			{
				
			if(repts.Discount_SaleRecap().isDisplayed())
			{
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Last N days", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_SaleRecap().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Last N days", 4, 16, Discnt);

			//Check whether the Discount value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Cashier Report Report is equal to Sale Recap Report for Last N days");
		
				excel.setreport_PassedData("Last N days", 4, 17, "0.00");

				excel.setreport_PassedData("Last N days", 41, 8, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Cashier Report Report is not equal to Sale Recap Report for Last N days.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 4, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last N days", 4, 17,diff_value);

				excel.setreport_FailedData("Last N days", 41, 8,diff_value);
			}
			
			
			//Get Discount Tax
			String DiscntTx=repts.Discount_Tax_SaleRecap().getText().replace(",", "");
			double ActualDiscount_Tax=Double.parseDouble(DiscntTx);
			
			//Export Discount Tax value to Excel
			excel.setreportData("Last N days", 13, 16, DiscntTx);
			excel.setreportData("Last N days", 50, 8, DiscntTx);
			
		}
		}
		catch(Exception h)
		{
			test.log(LogStatus.FAIL, "Discount Table Field not available");

			
			//Export Discount value to Excel
			excel.setreportData("Last N days", 4, 16, "0.00");
			excel.setreportData("Last N days", 41, 8, "0.00");
			
			
			
			
			//Export Discount Tax value to Excel
			excel.setreportData("Last N days", 13, 16, st);
			excel.setreportData("Last N days", 50, 8, st);
		}
		
			
		try
		{
			if(repts.Refund_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Refund Table Field Available");
				
				//Get Refund Tax
				String Refund=repts.Refund_SaleRecap().getText().replace(",", "");
				double ActualRefund=Double.parseDouble(Refund);
				
				//Export Discount value to Excel
				excel.setreportData("Last N days", 11, 16, Refund);
				excel.setreportData("Last N days", 48, 8, Refund);
			}
		}
		catch(Exception l)
		{
				test.log(LogStatus.FAIL, "Refund Table Field not available");

				//Export Discount value to Excel
				excel.setreportData("Last N days", 11, 16, st);
				excel.setreportData("Last N days", 48, 8, st);
		}
			

			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}

	
	
	@Test(priority = 4,enabled = false)
	public void Cashier_Out_Report_This_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));

		
		
		
		
		//Select Today
		repts.Select_This_Week_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Cashier Report Not Available for This Week");
	
		
			excel.setreportData("This Week", 2, 16, st);
			excel.setreportData("This Week", 3, 16, st);
			excel.setreportData("This Week", 4, 16, st);
			excel.setreportData("This Week", 5, 16, st);
			excel.setreportData("This Week", 6, 16, st);
			excel.setreportData("This Week", 7, 16, st);
			
			excel.setreportData("This Week", 2, 17, st);
			excel.setreportData("This Week", 3, 17, st);
			excel.setreportData("This Week", 4, 17, st);
			excel.setreportData("This Week", 5, 17, st);
			excel.setreportData("This Week", 6, 17, st);
			excel.setreportData("This Week", 7, 17, st);
			
			excel.setreportData("This Week", 39, 8, st);
			excel.setreportData("This Week", 40, 8, st);
			excel.setreportData("This Week", 41, 8, st);
			excel.setreportData("This Week", 42, 8, st);
			excel.setreportData("This Week", 43, 8, st);
			excel.setreportData("This Week", 44, 8, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Cashier Report Available for This Week");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			if(repts.Sales_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Sales Table Field Available");

//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_Net_Sale=excel.getData("This Week", 2, 1).toString().replace(",", "");
			double Expected_NetSale=Double.parseDouble(Expected_Net_Sale);
			
			Thread.sleep(3000);
			//Get Net Sales
			String NetSale=repts.Net_Sales_SaleRecap().getText().replace(",", "");
			double ActualNet_Sales=Double.parseDouble(NetSale);
			
			//Export the Net Sales value to Excel
			excel.setreportData("This Week", 2, 16, NetSale);

			
			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSale==ActualNet_Sales)
			{
				test.log(LogStatus.PASS, "Net Sales for Cashier Report Report is equal to Sale Recap Report for This Week");
	
			excel.setreport_PassedData("This Week", 2, 17, "0.00");
			
			excel.setreport_PassedData("This Week", 39, 8, NetSale+"`");

			
			}
			else
			{
				double diff=Expected_NetSale-ActualNet_Sales;
				String diff_value=String.valueOf(diff);
				
				test.log(LogStatus.FAIL, "Net Sales for Cashier Report Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
				

				excel.setreport_FailedData("This Week", 2, 17,diff_value);
		
				excel.setreport_FailedData("This Week", 39, 8,diff_value);
			}
			
			
			//Get the Grand_Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("This Week", 5, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
			
			//Get the Grand_Sales
			String GrandSale=repts.Grand_Sales_SaleRecap().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
			//Export Grand_Sales value to Excel
			excel.setreportData("This Week", 5, 16, GrandSale);

			//Check whether the Discount value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Cashier Report Report is equal to Sale Recap Report for This Week");
		
			
				excel.setreport_PassedData("This Week", 5, 17, "0.00");

				excel.setreport_PassedData("This Week", 42, 8, GrandSale+"`");
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Cashier Report Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
			
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 5, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("This Week", 5, 17,diff_value);

				excel.setreport_FailedData("This Week", 42, 8,diff_value);
			}
			
			//Get the Gross Receipt from Sale Recap Report
			String Expected_GrossReceipt=excel.getData("This Week", 6, 1).toString().replace(",", "");
			double Expected_Gross_Receipt=Double.parseDouble(Expected_GrossReceipt);
		
			
			//Get the Gross Receipt
			String GrossReceipt=repts.Gross_Receipt_SaleRecap().getText().replace(",", "");
			double ActualGross_Receipt=Double.parseDouble(GrossReceipt);
			
			//Export the  Gross Receipt value to Excel
			excel.setreportData("This Week", 6, 16, GrossReceipt);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Receipt==ActualGross_Receipt)
			{
				test.log(LogStatus.PASS, "Gross Receipt for Cashier Report Report is equal to Sale Recap Report for This Week");
		
				excel.setreport_PassedData("This Week", 6, 17, "0.00");

				excel.setreport_PassedData("This Week", 43, 8, GrossReceipt+"`");
			}
			else
			{
				double diff=Expected_Gross_Receipt-ActualGross_Receipt;
				test.log(LogStatus.FAIL, "Gross Receipt for Cashier Report Report is not equal to Sale Recap Report  for This Week.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("This Week", 6, 17,diff_value);
				excel.setreport_FailedData("This Week", 43, 8,diff_value);
			
			}
			
			
			//Get the Gross Sales from Sale Recap Report
			String Expected_GrossSales=excel.getData("This Week", 7, 1).toString().replace(",", "");
			double Expected_Gross_Sales=Double.parseDouble(Expected_GrossSales);
		
			
			//Get the Gross Sales
			String GrossSales=repts.Gross_Sales_SaleRecap().getText().replace(",", "");
			double ActualGross_Sales=Double.parseDouble(GrossSales);
			
			//Export the Gross Sales of Sale value to Excel
			excel.setreportData("This Week", 7, 16, GrossSales);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Sales==ActualGross_Sales)
			{
				test.log(LogStatus.PASS, "Gross Sales for Cashier Report Report is equal to Sale Recap Report for This Week");
		
				excel.setreport_PassedData("This Week", 7, 17, "0.00");

				excel.setreport_PassedData("This Week", 44, 8, GrossSales+"`");
			}
			else
			{
				double diff=Expected_Gross_Sales-ActualGross_Sales;
				test.log(LogStatus.FAIL, "Gross Sales for Cashier Report Report is not equal to Sale Recap Report  for This Week.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("This Week", 7, 17,diff_value);
				excel.setreport_FailedData("This Week", 44, 8,diff_value);
			
			}
			
			
			
			//Get the Net Void
			String NetVoid=repts.Net_Void_SaleRecap().getText().replace(",", "");
			double ActualNet_Void=Double.parseDouble(NetVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("This Week", 9, 16, NetVoid);
			excel.setreportData("This Week", 46, 8, NetVoid);
			
			
			
			//Get the Gross Void
			String GrossVoid=repts.Gross_Void_SaleRecap().getText().replace(",", "");
			double ActualGross_Void=Double.parseDouble(GrossVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("This Week", 10, 16, GrossVoid);
			excel.setreportData("This Week", 47, 8, GrossVoid);
			
			}
			else
			{
				test.log(LogStatus.FAIL, "Sales Table Field not available");
	
			}
			
			try
			{
			if(repts.Taxes_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Taxes Table Field Available");
				
			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("This Week", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
		
			//Get the Tax
			String Tx=repts.Tax_SaleRecap().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("This Week", 3, 16, Tx);
			
			
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Cashier Report Report is equal to Sale Recap Report for This Week");
		
				excel.setreport_PassedData("This Week", 3, 17, "0");

				excel.setreport_PassedData("This Week", 40, 8, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Cashier Report Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 3, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("This Week", 3, 17,diff_value);

				excel.setreport_FailedData("This Week", 40, 8,diff_value);
			}
			
			
			
			try
			{
			if(repts.Tax_Exempt_SaleRecap().isDisplayed())
			{
			//Get the Tax Exempted
			String Tx_Exmpted=repts.Tax_Exempt_SaleRecap().getText().replace(",", "");
			double ActualTax_Exempted=Double.parseDouble(Tx_Exmpted);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("This Week", 8, 16, Tx_Exmpted);
			excel.setreportData("This Week", 45, 8, Tx_Exmpted);
			}
			}
			catch(Exception p)
			{
				test.log(LogStatus.INFO, "Tax Exempted not available");
				
				//Export Tax Exempted value to Excel
				excel.setreportData("This Week", 8, 16, st);
				excel.setreportData("This Week", 45, 8, st);
			}
			
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_SaleRecap().getText().replace(",", "");
			double ActualRounding_Off=Double.parseDouble(RoundOff);
			
			//Export Tax value to Excel
			excel.setreportData("This Week", 12, 16, RoundOff);
			excel.setreportData("This Week", 49, 8, RoundOff);
		}

			}
			catch(Exception ll)
		{
			test.log(LogStatus.FAIL, "Taxes Table Field not available");
			
			
			//Export Tax value to Excel
			excel.setreportData("This Week", 3, 16, st);
			excel.setreportData("This Week", 40, 8, st);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("This Week", 8, 16, st);
			excel.setreportData("This Week", 45, 8, st);
			
			//Export Tax value to Excel
			excel.setreportData("This Week", 12, 16, st);
			excel.setreportData("This Week", 49, 8, st);
			
		}
			
			try
			{
				
			if(repts.Discount_SaleRecap().isDisplayed())
			{
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("This Week", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_SaleRecap().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("This Week", 4, 16, Discnt);

			//Check whether the Discount value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Cashier Report Report is equal to Sale Recap Report for This Week");
		
				excel.setreport_PassedData("This Week", 4, 17, "0.00");

				excel.setreport_PassedData("This Week", 41, 8, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Cashier Report Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 4, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("This Week", 4, 17,diff_value);

				excel.setreport_FailedData("This Week", 41, 8,diff_value);
			}
			
			
			//Get Discount Tax
			String DiscntTx=repts.Discount_Tax_SaleRecap().getText().replace(",", "");
			double ActualDiscount_Tax=Double.parseDouble(DiscntTx);
			
			//Export Discount Tax value to Excel
			excel.setreportData("This Week", 13, 16, DiscntTx);
			excel.setreportData("This Week", 50, 8, DiscntTx);
			
		}
		}
		catch(Exception h)
		{
			test.log(LogStatus.FAIL, "Discount Table Field not available");

			
			//Export Discount value to Excel
			excel.setreportData("This Week", 4, 16, "0.00");
			excel.setreportData("This Week", 41, 8, "0.00");
			
			
			
			
			//Export Discount Tax value to Excel
			excel.setreportData("This Week", 13, 16, st);
			excel.setreportData("This Week", 50, 8, st);
		}
		
			
		try
		{
			if(repts.Refund_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Refund Table Field Available");
				
				//Get Refund Tax
				String Refund=repts.Refund_SaleRecap().getText().replace(",", "");
				double ActualRefund=Double.parseDouble(Refund);
				
				//Export Discount value to Excel
				excel.setreportData("This Week", 11, 16, Refund);
				excel.setreportData("This Week", 48, 8, Refund);
			}
		}
		catch(Exception l)
		{
				test.log(LogStatus.FAIL, "Refund Table Field not available");

				//Export Discount value to Excel
				excel.setreportData("This Week", 11, 16, st);
				excel.setreportData("This Week", 48, 8, st);
		}
			

			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Cashier_Out_Report_Last_Week(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));

		
		
		
		
		//Select Today
		repts.Select_Last_Week_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Cashier Report Not Available for Last Week");
		
			
			excel.setreportData("Last Week", 2, 16, st);
			excel.setreportData("Last Week", 3, 16, st);
			excel.setreportData("Last Week", 4, 16, st);
			excel.setreportData("Last Week", 5, 16, st);
			excel.setreportData("Last Week", 6, 16, st);
			excel.setreportData("Last Week", 7, 16, st);
			
			excel.setreportData("Last Week", 2, 17, st);
			excel.setreportData("Last Week", 3, 17, st);
			excel.setreportData("Last Week", 4, 17, st);
			excel.setreportData("Last Week", 5, 17, st);
			excel.setreportData("Last Week", 6, 17, st);
			excel.setreportData("Last Week", 7, 17, st);
			
			excel.setreportData("Last Week", 39, 8, st);
			excel.setreportData("Last Week", 40, 8, st);
			excel.setreportData("Last Week", 41, 8, st);
			excel.setreportData("Last Week", 42, 8, st);
			excel.setreportData("Last Week", 43, 8, st);
			excel.setreportData("Last Week", 44, 8, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Cashier Report Available for Last Week");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			if(repts.Sales_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Sales Table Field Available");

//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_Net_Sale=excel.getData("Last Week", 2, 1).toString().replace(",", "");
			double Expected_NetSale=Double.parseDouble(Expected_Net_Sale);
			
			Thread.sleep(3000);
			//Get Net Sales
			String NetSale=repts.Net_Sales_SaleRecap().getText().replace(",", "");
			double ActualNet_Sales=Double.parseDouble(NetSale);
			
			//Export the Net Sales value to Excel
			excel.setreportData("Last Week", 2, 16, NetSale);

			
			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSale==ActualNet_Sales)
			{
				test.log(LogStatus.PASS, "Net Sales for Cashier Report Report is equal to Sale Recap Report for Last Week");
	
			excel.setreport_PassedData("Last Week", 2, 17, "0.00");
			
			excel.setreport_PassedData("Last Week", 39, 8, NetSale+"`");

			
			}
			else
			{
				double diff=Expected_NetSale-ActualNet_Sales;
				String diff_value=String.valueOf(diff);
				
				test.log(LogStatus.FAIL, "Net Sales for Cashier Report Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
				

				excel.setreport_FailedData("Last Week", 2, 17,diff_value);
		
				excel.setreport_FailedData("Last Week", 39, 8,diff_value);
			}
			
			
			//Get the Grand_Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("Last Week", 5, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
			
			//Get the Grand_Sales
			String GrandSale=repts.Grand_Sales_SaleRecap().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
			//Export Grand_Sales value to Excel
			excel.setreportData("Last Week", 5, 16, GrandSale);

			//Check whether the Discount value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Cashier Report Report is equal to Sale Recap Report for Last Week");
		
			
				excel.setreport_PassedData("Last Week", 5, 17, "0.00");

				excel.setreport_PassedData("Last Week", 42, 8, GrandSale+"`");
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Cashier Report Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
			
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 5, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last Week", 5, 17,diff_value);

				excel.setreport_FailedData("Last Week", 42, 8,diff_value);
			}
			
			//Get the Gross Receipt from Sale Recap Report
			String Expected_GrossReceipt=excel.getData("Last Week", 6, 1).toString().replace(",", "");
			double Expected_Gross_Receipt=Double.parseDouble(Expected_GrossReceipt);
		
			
			//Get the Gross Receipt
			String GrossReceipt=repts.Gross_Receipt_SaleRecap().getText().replace(",", "");
			double ActualGross_Receipt=Double.parseDouble(GrossReceipt);
			
			//Export the  Gross Receipt value to Excel
			excel.setreportData("Last Week", 6, 16, GrossReceipt);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Receipt==ActualGross_Receipt)
			{
				test.log(LogStatus.PASS, "Gross Receipt for Cashier Report Report is equal to Sale Recap Report for Last Week");
		
				excel.setreport_PassedData("Last Week", 6, 17, "0.00");

				excel.setreport_PassedData("Last Week", 43, 8, GrossReceipt+"`");
			}
			else
			{
				double diff=Expected_Gross_Receipt-ActualGross_Receipt;
				test.log(LogStatus.FAIL, "Gross Receipt for Cashier Report Report is not equal to Sale Recap Report  for Last Week.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last Week", 6, 17,diff_value);
				excel.setreport_FailedData("Last Week", 43, 8,diff_value);
			
			}
			
			
			//Get the Gross Sales from Sale Recap Report
			String Expected_GrossSales=excel.getData("Last Week", 7, 1).toString().replace(",", "");
			double Expected_Gross_Sales=Double.parseDouble(Expected_GrossSales);
		
			
			//Get the Gross Sales
			String GrossSales=repts.Gross_Sales_SaleRecap().getText().replace(",", "");
			double ActualGross_Sales=Double.parseDouble(GrossSales);
			
			//Export the Gross Sales of Sale value to Excel
			excel.setreportData("Last Week", 7, 16, GrossSales);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Sales==ActualGross_Sales)
			{
				test.log(LogStatus.PASS, "Gross Sales for Cashier Report Report is equal to Sale Recap Report for Last Week");
		
				excel.setreport_PassedData("Last Week", 7, 17, "0.00");

				excel.setreport_PassedData("Last Week", 44, 8, GrossSales+"`");
			}
			else
			{
				double diff=Expected_Gross_Sales-ActualGross_Sales;
				test.log(LogStatus.FAIL, "Gross Sales for Cashier Report Report is not equal to Sale Recap Report  for Last Week.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last Week", 7, 17,diff_value);
				excel.setreport_FailedData("Last Week", 44, 8,diff_value);
			
			}
			
			
			
			//Get the Net Void
			String NetVoid=repts.Net_Void_SaleRecap().getText().replace(",", "");
			double ActualNet_Void=Double.parseDouble(NetVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("Last Week", 9, 16, NetVoid);
			excel.setreportData("Last Week", 46, 8, NetVoid);
			
			
			
			//Get the Gross Void
			String GrossVoid=repts.Gross_Void_SaleRecap().getText().replace(",", "");
			double ActualGross_Void=Double.parseDouble(GrossVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("Last Week", 10, 16, GrossVoid);
			excel.setreportData("Last Week", 47, 8, GrossVoid);
			
			}
			else
			{
				test.log(LogStatus.FAIL, "Sales Table Field not available");
	
			}
			
			try
			{
			if(repts.Taxes_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Taxes Table Field Available");
				
			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Last Week", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
		
			//Get the Tax
			String Tx=repts.Tax_SaleRecap().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last Week", 3, 16, Tx);
			
			
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Cashier Report Report is equal to Sale Recap Report for Last Week");
		
				excel.setreport_PassedData("Last Week", 3, 17, "0");

				excel.setreport_PassedData("Last Week", 40, 8, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Cashier Report Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 3, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last Week", 3, 17,diff_value);

				excel.setreport_FailedData("Last Week", 40, 8,diff_value);
			}
			
			
			
			try
			{
			if(repts.Tax_Exempt_SaleRecap().isDisplayed())
			{
			//Get the Tax Exempted
			String Tx_Exmpted=repts.Tax_Exempt_SaleRecap().getText().replace(",", "");
			double ActualTax_Exempted=Double.parseDouble(Tx_Exmpted);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("Last Week", 8, 16, Tx_Exmpted);
			excel.setreportData("Last Week", 45, 8, Tx_Exmpted);
			}
			}
			catch(Exception p)
			{
				test.log(LogStatus.INFO, "Tax Exempted not available");
				
				//Export Tax Exempted value to Excel
				excel.setreportData("Last Week", 8, 16, st);
				excel.setreportData("Last Week", 45, 8, st);
			}
			
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_SaleRecap().getText().replace(",", "");
			double ActualRounding_Off=Double.parseDouble(RoundOff);
			
			//Export Tax value to Excel
			excel.setreportData("Last Week", 12, 16, RoundOff);
			excel.setreportData("Last Week", 49, 8, RoundOff);
		}

			}
			catch(Exception ll)
		{
			test.log(LogStatus.FAIL, "Taxes Table Field not available");
			
			
			//Export Tax value to Excel
			excel.setreportData("Last Week", 3, 16, st);
			excel.setreportData("Last Week", 40, 8, st);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("Last Week", 8, 16, st);
			excel.setreportData("Last Week", 45, 8, st);
			
			//Export Tax value to Excel
			excel.setreportData("Last Week", 12, 16, st);
			excel.setreportData("Last Week", 49, 8, st);
			
		}
			
			try
			{
				
			if(repts.Discount_SaleRecap().isDisplayed())
			{
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Last Week", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_SaleRecap().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Last Week", 4, 16, Discnt);

			//Check whether the Discount value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Cashier Report Report is equal to Sale Recap Report for Last Week");
		
				excel.setreport_PassedData("Last Week", 4, 17, "0.00");

				excel.setreport_PassedData("Last Week", 41, 8, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Cashier Report Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 4, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last Week", 4, 17,diff_value);

				excel.setreport_FailedData("Last Week", 41, 8,diff_value);
			}
			
			
			//Get Discount Tax
			String DiscntTx=repts.Discount_Tax_SaleRecap().getText().replace(",", "");
			double ActualDiscount_Tax=Double.parseDouble(DiscntTx);
			
			//Export Discount Tax value to Excel
			excel.setreportData("Last Week", 13, 16, DiscntTx);
			excel.setreportData("Last Week", 50, 8, DiscntTx);
			
		}
		}
		catch(Exception h)
		{
			test.log(LogStatus.FAIL, "Discount Table Field not available");

			
			//Export Discount value to Excel
			excel.setreportData("Last Week", 4, 16, "0.00");
			excel.setreportData("Last Week", 41, 8, "0.00");
			
			
			
			
			//Export Discount Tax value to Excel
			excel.setreportData("Last Week", 13, 16, st);
			excel.setreportData("Last Week", 50, 8, st);
		}
		
			
		try
		{
			if(repts.Refund_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Refund Table Field Available");
				
				//Get Refund Tax
				String Refund=repts.Refund_SaleRecap().getText().replace(",", "");
				double ActualRefund=Double.parseDouble(Refund);
				
				//Export Discount value to Excel
				excel.setreportData("Last Week", 11, 16, Refund);
				excel.setreportData("Last Week", 48, 8, Refund);
			}
		}
		catch(Exception l)
		{
				test.log(LogStatus.FAIL, "Refund Table Field not available");

				//Export Discount value to Excel
				excel.setreportData("Last Week", 11, 16, st);
				excel.setreportData("Last Week", 48, 8, st);
		}
			

			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Cashier_Out_Report_Last_7_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));

		
		
		
		
		//Select Today
		repts.Select_Last_7_Days_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Cashier Report Not Available for Last 7 days");
	
			excel.setreportData("Last 7 days", 2, 16, st);
			excel.setreportData("Last 7 days", 3, 16, st);
			excel.setreportData("Last 7 days", 4, 16, st);
			excel.setreportData("Last 7 days", 5, 16, st);
			excel.setreportData("Last 7 days", 6, 16, st);
			excel.setreportData("Last 7 days", 7, 16, st);
			
			excel.setreportData("Last 7 days", 2, 17, st);
			excel.setreportData("Last 7 days", 3, 17, st);
			excel.setreportData("Last 7 days", 4, 17, st);
			excel.setreportData("Last 7 days", 5, 17, st);
			excel.setreportData("Last 7 days", 6, 17, st);
			excel.setreportData("Last 7 days", 7, 17, st);
			
			excel.setreportData("Last 7 days", 39, 8, st);
			excel.setreportData("Last 7 days", 40, 8, st);
			excel.setreportData("Last 7 days", 41, 8, st);
			excel.setreportData("Last 7 days", 42, 8, st);
			excel.setreportData("Last 7 days", 43, 8, st);
			excel.setreportData("Last 7 days", 44, 8, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Cashier Report Available for Last 7 days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		
		if(repts.Sales_Table_inSaleRecap().isDisplayed())
		{
			test.log(LogStatus.PASS, "Sales Table Field Available");

//		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		//Get the NEt Sales from Sale Recap Report
		String Expected_Net_Sale=excel.getData("Last 7 days", 2, 1).toString().replace(",", "");
		double Expected_NetSale=Double.parseDouble(Expected_Net_Sale);
		
		Thread.sleep(3000);
		//Get Net Sales
		String NetSale=repts.Net_Sales_SaleRecap().getText().replace(",", "");
		double ActualNet_Sales=Double.parseDouble(NetSale);
		
		//Export the Net Sales value to Excel
		excel.setreportData("Last 7 days", 2, 16, NetSale);

		
		//Check whether the Net Sales value is Equal or not
		if(Expected_NetSale==ActualNet_Sales)
		{
			test.log(LogStatus.PASS, "Net Sales for Cashier Report Report is equal to Sale Recap Report for Last 7 days");

		excel.setreport_PassedData("Last 7 days", 2, 17, "0.00");
		
		excel.setreport_PassedData("Last 7 days", 39, 8, NetSale+"`");

		
		}
		else
		{
			double diff=Expected_NetSale-ActualNet_Sales;
			String diff_value=String.valueOf(diff);
			
			test.log(LogStatus.FAIL, "Net Sales for Cashier Report Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
			

			excel.setreport_FailedData("Last 7 days", 2, 17,diff_value);
	
			excel.setreport_FailedData("Last 7 days", 39, 8,diff_value);
		}
		
		
		//Get the Grand_Sales from Sale Recap Report
		String Expected_GrandSale=excel.getData("Last 7 days", 5, 1).toString().replace(",", "");
		double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
		
		//Get the Grand_Sales
		String GrandSale=repts.Grand_Sales_SaleRecap().getText().replace(",", "");
		double ActualGrand_Sales=Double.parseDouble(GrandSale);
		
		//Export Grand_Sales value to Excel
		excel.setreportData("Last 7 days", 5, 16, GrandSale);

		//Check whether the Discount value is Equal or not
		if(Expected_Grand_Sales==ActualGrand_Sales)
		{
			test.log(LogStatus.PASS, "Grand_Sales for Cashier Report Report is equal to Sale Recap Report for Last 7 days");
	
		
			excel.setreport_PassedData("Last 7 days", 5, 17, "0.00");

			excel.setreport_PassedData("Last 7 days", 42, 8, GrandSale+"`");
		}
		else
		{
			double diff=Expected_Grand_Sales-ActualGrand_Sales;
			test.log(LogStatus.FAIL, "Grand_Sales for Cashier Report Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
		
			String diff_value=String.valueOf(diff);

			//Export the Net Sales value to Excel
//			excel.setreportData("Today", 5, 17, diff_value);
//			excel.Highlight_DifferenceValue();
			excel.setreport_FailedData("Last 7 days", 5, 17,diff_value);

			excel.setreport_FailedData("Last 7 days", 42, 8,diff_value);
		}
		
		//Get the Gross Receipt from Sale Recap Report
		String Expected_GrossReceipt=excel.getData("Last 7 days", 6, 1).toString().replace(",", "");
		double Expected_Gross_Receipt=Double.parseDouble(Expected_GrossReceipt);
	
		
		//Get the Gross Receipt
		String GrossReceipt=repts.Gross_Receipt_SaleRecap().getText().replace(",", "");
		double ActualGross_Receipt=Double.parseDouble(GrossReceipt);
		
		//Export the  Gross Receipt value to Excel
		excel.setreportData("Last 7 days", 6, 16, GrossReceipt);

		
		//Check whether the Gross Receipt value is Equal or not
		if(Expected_Gross_Receipt==ActualGross_Receipt)
		{
			test.log(LogStatus.PASS, "Gross Receipt for Cashier Report Report is equal to Sale Recap Report for Last 7 days");
	
			excel.setreport_PassedData("Last 7 days", 6, 17, "0.00");

			excel.setreport_PassedData("Last 7 days", 43, 8, GrossReceipt+"`");
		}
		else
		{
			double diff=Expected_Gross_Receipt-ActualGross_Receipt;
			test.log(LogStatus.FAIL, "Gross Receipt for Cashier Report Report is not equal to Sale Recap Report  for Last 7 days.The value diff is : "+diff);
	
			String diff_value=String.valueOf(diff);

			//Export the Net Sales value to Excel
//			excel.setreportData("Today", 6, 17, diff_value);
//			excel.Highlight_DifferenceValue();
			excel.setreport_FailedData("Last 7 days", 6, 17,diff_value);
			excel.setreport_FailedData("Last 7 days", 43, 8,diff_value);
		
		}
		
		
		//Get the Gross Sales from Sale Recap Report
		String Expected_GrossSales=excel.getData("Last 7 days", 7, 1).toString().replace(",", "");
		double Expected_Gross_Sales=Double.parseDouble(Expected_GrossSales);
	
		
		//Get the Gross Sales
		String GrossSales=repts.Gross_Sales_SaleRecap().getText().replace(",", "");
		double ActualGross_Sales=Double.parseDouble(GrossSales);
		
		//Export the Gross Sales of Sale value to Excel
		excel.setreportData("Last 7 days", 7, 16, GrossSales);

		
		//Check whether the Gross Receipt value is Equal or not
		if(Expected_Gross_Sales==ActualGross_Sales)
		{
			test.log(LogStatus.PASS, "Gross Sales for Cashier Report Report is equal to Sale Recap Report for Last 7 days");
	
			excel.setreport_PassedData("Last 7 days", 7, 17, "0.00");

			excel.setreport_PassedData("Last 7 days", 44, 8, GrossSales+"`");
		}
		else
		{
			double diff=Expected_Gross_Sales-ActualGross_Sales;
			test.log(LogStatus.FAIL, "Gross Sales for Cashier Report Report is not equal to Sale Recap Report  for Last 7 days.The value diff is : "+diff);
	
			String diff_value=String.valueOf(diff);

			//Export the Net Sales value to Excel
//			excel.setreportData("Today", 6, 17, diff_value);
//			excel.Highlight_DifferenceValue();
			excel.setreport_FailedData("Last 7 days", 7, 17,diff_value);
			excel.setreport_FailedData("Last 7 days", 44, 8,diff_value);
		
		}
		
		
		
		//Get the Net Void
		String NetVoid=repts.Net_Void_SaleRecap().getText().replace(",", "");
		double ActualNet_Void=Double.parseDouble(NetVoid);
		
		//Export the % Grand Sales value to Excel
		excel.setreportData("Last 7 days", 9, 16, NetVoid);
		excel.setreportData("Last 7 days", 46, 8, NetVoid);
		
		
		
		//Get the Gross Void
		String GrossVoid=repts.Gross_Void_SaleRecap().getText().replace(",", "");
		double ActualGross_Void=Double.parseDouble(GrossVoid);
		
		//Export the % Grand Sales value to Excel
		excel.setreportData("Last 7 days", 10, 16, GrossVoid);
		excel.setreportData("Last 7 days", 47, 8, GrossVoid);
		
		}
		else
		{
			test.log(LogStatus.FAIL, "Sales Table Field not available");

		}
		
		try
		{
		if(repts.Taxes_Table_inSaleRecap().isDisplayed())
		{
			test.log(LogStatus.PASS, "Taxes Table Field Available");
			
		//Get the Tax from Sale Recap Report
		String Expected_Tx=excel.getData("Last 7 days", 3, 1).toString().replace(",", "");
		double Expected_Tax=Double.parseDouble(Expected_Tx);
	
		//Get the Tax
		String Tx=repts.Tax_SaleRecap().getText().replace(",", "");
		double ActualTax=Double.parseDouble(Tx);
		
		//Export Tax value to Excel
		excel.setreportData("Last 7 days", 3, 16, Tx);
		
		
		//Check whether the Tax value is Equal or not
		if(Expected_Tax==ActualTax)
		{
			test.log(LogStatus.PASS, "Tax for Cashier Report Report is equal to Sale Recap Report for Last 7 days");
	
			excel.setreport_PassedData("Last 7 days", 3, 17, "0");

			excel.setreport_PassedData("Last 7 days", 40, 8, Tx+"`");
		}
		else
		{
			double diff=Expected_Tax-ActualTax;
			test.log(LogStatus.FAIL, "Tax for Cashier Report Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
			String diff_value=String.valueOf(diff);

			//Export the Net Sales value to Excel
//			excel.setreportData("Today", 3, 17, diff_value);
//			excel.Highlight_DifferenceValue();
			excel.setreport_FailedData("Last 7 days", 3, 17,diff_value);

			excel.setreport_FailedData("Last 7 days", 40, 8,diff_value);
		}
		
		
		
		try
		{
		if(repts.Tax_Exempt_SaleRecap().isDisplayed())
		{
		//Get the Tax Exempted
		String Tx_Exmpted=repts.Tax_Exempt_SaleRecap().getText().replace(",", "");
		double ActualTax_Exempted=Double.parseDouble(Tx_Exmpted);
		
		//Export Tax Exempted value to Excel
		excel.setreportData("Last 7 days", 8, 16, Tx_Exmpted);
		excel.setreportData("Last 7 days", 45, 8, Tx_Exmpted);
		}
		}
		catch(Exception p)
		{
			test.log(LogStatus.INFO, "Tax Exempted not available");
			
			//Export Tax Exempted value to Excel
			excel.setreportData("Last 7 days", 8, 16, st);
			excel.setreportData("Last 7 days", 45, 8, st);
		}
		
		
		//Get the Rounding Off
		String RoundOff=repts.Rounding_Off_SaleRecap().getText().replace(",", "");
		double ActualRounding_Off=Double.parseDouble(RoundOff);
		
		//Export Tax value to Excel
		excel.setreportData("Last 7 days", 12, 16, RoundOff);
		excel.setreportData("Last 7 days", 49, 8, RoundOff);
	}

		}
		catch(Exception ll)
	{
		test.log(LogStatus.FAIL, "Taxes Table Field not available");
		
		
		//Export Tax value to Excel
		excel.setreportData("Last 7 days", 3, 16, st);
		excel.setreportData("Last 7 days", 40, 8, st);
		
		//Export Tax Exempted value to Excel
		excel.setreportData("Last 7 days", 8, 16, st);
		excel.setreportData("Last 7 days", 45, 8, st);
		
		//Export Tax value to Excel
		excel.setreportData("Last 7 days", 12, 16, st);
		excel.setreportData("Last 7 days", 49, 8, st);
		
	}
		
		try
		{
			
		if(repts.Discount_SaleRecap().isDisplayed())
		{
		
		//Get the Discount from Sale Recap Report
		String Expected_Discnt=excel.getData("Last 7 days", 4, 1).toString().replace(",", "");
		double Expected_Discount=Double.parseDouble(Expected_Discnt);
		
		//Get the Discount
		String Discnt=repts.Discount_SaleRecap().getText().replace(",", "");
		double ActualDiscount=Double.parseDouble(Discnt);
		
		//Export Discount value to Excel
		excel.setreportData("Last 7 days", 4, 16, Discnt);

		//Check whether the Discount value is Equal or not
		if(Expected_Discount==ActualDiscount)
		{
			test.log(LogStatus.PASS, "Discount for Cashier Report Report is equal to Sale Recap Report for Last 7 days");
	
			excel.setreport_PassedData("Last 7 days", 4, 17, "0.00");

			excel.setreport_PassedData("Last 7 days", 41, 8, Discnt+"`");
		}
		else
		{
			double diff=Expected_Discount-ActualDiscount;
			test.log(LogStatus.FAIL, "Discount for Cashier Report Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
	
			String diff_value=String.valueOf(diff);

			//Export the Net Sales value to Excel
//			excel.setreportData("Today", 4, 17, diff_value);
//			excel.Highlight_DifferenceValue();
			excel.setreport_FailedData("Last 7 days", 4, 17,diff_value);

			excel.setreport_FailedData("Last 7 days", 41, 8,diff_value);
		}
		
		
		//Get Discount Tax
		String DiscntTx=repts.Discount_Tax_SaleRecap().getText().replace(",", "");
		double ActualDiscount_Tax=Double.parseDouble(DiscntTx);
		
		//Export Discount Tax value to Excel
		excel.setreportData("Last 7 days", 13, 16, DiscntTx);
		excel.setreportData("Last 7 days", 50, 8, DiscntTx);
		
	}
	}
	catch(Exception h)
	{
		test.log(LogStatus.FAIL, "Discount Table Field not available");

		
		//Export Discount value to Excel
		excel.setreportData("Last 7 days", 4, 16, "0.00");
		excel.setreportData("Last 7 days", 41, 8, "0.00");
		
		
		
		
		//Export Discount Tax value to Excel
		excel.setreportData("Last 7 days", 13, 16, st);
		excel.setreportData("Last 7 days", 50, 8, st);
	}
	
		
	try
	{
		if(repts.Refund_Table_inSaleRecap().isDisplayed())
		{
			test.log(LogStatus.PASS, "Refund Table Field Available");
			
			//Get Refund Tax
			String Refund=repts.Refund_SaleRecap().getText().replace(",", "");
			double ActualRefund=Double.parseDouble(Refund);
			
			//Export Discount value to Excel
			excel.setreportData("Last 7 days", 11, 16, Refund);
			excel.setreportData("Last 7 days", 48, 8, Refund);
		}
	}
	catch(Exception l)
	{
			test.log(LogStatus.FAIL, "Refund Table Field not available");

			//Export Discount value to Excel
			excel.setreportData("Last 7 days", 11, 16, st);
			excel.setreportData("Last 7 days", 48, 8, st);
	}
		

			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Cashier_Out_Report_This_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));

		
		
		
		
		//Select Today
		repts.Select_This_Month_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Cashier Report Not Available for This month");
		
		
			excel.setreportData("This month", 2, 16, st);
			excel.setreportData("This month", 3, 16, st);
			excel.setreportData("This month", 4, 16, st);
			excel.setreportData("This month", 5, 16, st);
			excel.setreportData("This month", 6, 16, st);
			excel.setreportData("This month", 7, 16, st);
			
			excel.setreportData("This month", 2, 17, st);
			excel.setreportData("This month", 3, 17, st);
			excel.setreportData("This month", 4, 17, st);
			excel.setreportData("This month", 5, 17, st);
			excel.setreportData("This month", 6, 17, st);
			excel.setreportData("This month", 7, 17, st);
			
			excel.setreportData("This month", 39, 8, st);
			excel.setreportData("This month", 40, 8, st);
			excel.setreportData("This month", 41, 8, st);
			excel.setreportData("This month", 42, 8, st);
			excel.setreportData("This month", 43, 8, st);
			excel.setreportData("This month", 44, 8, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Cashier Report Available for This month");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			if(repts.Sales_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Sales Table Field Available");

//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_Net_Sale=excel.getData("This month", 2, 1).toString().replace(",", "");
			double Expected_NetSale=Double.parseDouble(Expected_Net_Sale);
			
			Thread.sleep(3000);
			//Get Net Sales
			String NetSale=repts.Net_Sales_SaleRecap().getText().replace(",", "");
			double ActualNet_Sales=Double.parseDouble(NetSale);
			
			//Export the Net Sales value to Excel
			excel.setreportData("This month", 2, 16, NetSale);

			
			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSale==ActualNet_Sales)
			{
				test.log(LogStatus.PASS, "Net Sales for Cashier Report Report is equal to Sale Recap Report for This month");
	
			excel.setreport_PassedData("This month", 2, 17, "0.00");
			
			excel.setreport_PassedData("This month", 39, 8, NetSale+"`");

			
			}
			else
			{
				double diff=Expected_NetSale-ActualNet_Sales;
				String diff_value=String.valueOf(diff);
				
				test.log(LogStatus.FAIL, "Net Sales for Cashier Report Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
				

				excel.setreport_FailedData("This month", 2, 17,diff_value);
		
				excel.setreport_FailedData("This month", 39, 8,diff_value);
			}
			
			
			//Get the Grand_Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("This month", 5, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
			
			//Get the Grand_Sales
			String GrandSale=repts.Grand_Sales_SaleRecap().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
			//Export Grand_Sales value to Excel
			excel.setreportData("This month", 5, 16, GrandSale);

			//Check whether the Discount value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Cashier Report Report is equal to Sale Recap Report for This month");
		
			
				excel.setreport_PassedData("This month", 5, 17, "0.00");

				excel.setreport_PassedData("This month", 42, 8, GrandSale+"`");
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Cashier Report Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
			
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 5, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("This month", 5, 17,diff_value);

				excel.setreport_FailedData("This month", 42, 8,diff_value);
			}
			
			//Get the Gross Receipt from Sale Recap Report
			String Expected_GrossReceipt=excel.getData("This month", 6, 1).toString().replace(",", "");
			double Expected_Gross_Receipt=Double.parseDouble(Expected_GrossReceipt);
		
			
			//Get the Gross Receipt
			String GrossReceipt=repts.Gross_Receipt_SaleRecap().getText().replace(",", "");
			double ActualGross_Receipt=Double.parseDouble(GrossReceipt);
			
			//Export the  Gross Receipt value to Excel
			excel.setreportData("This month", 6, 16, GrossReceipt);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Receipt==ActualGross_Receipt)
			{
				test.log(LogStatus.PASS, "Gross Receipt for Cashier Report Report is equal to Sale Recap Report for This month");
		
				excel.setreport_PassedData("This month", 6, 17, "0.00");

				excel.setreport_PassedData("This month", 43, 8, GrossReceipt+"`");
			}
			else
			{
				double diff=Expected_Gross_Receipt-ActualGross_Receipt;
				test.log(LogStatus.FAIL, "Gross Receipt for Cashier Report Report is not equal to Sale Recap Report  for This month.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("This month", 6, 17,diff_value);
				excel.setreport_FailedData("This month", 43, 8,diff_value);
			
			}
			
			
			//Get the Gross Sales from Sale Recap Report
			String Expected_GrossSales=excel.getData("This month", 7, 1).toString().replace(",", "");
			double Expected_Gross_Sales=Double.parseDouble(Expected_GrossSales);
		
			
			//Get the Gross Sales
			String GrossSales=repts.Gross_Sales_SaleRecap().getText().replace(",", "");
			double ActualGross_Sales=Double.parseDouble(GrossSales);
			
			//Export the Gross Sales of Sale value to Excel
			excel.setreportData("This month", 7, 16, GrossSales);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Sales==ActualGross_Sales)
			{
				test.log(LogStatus.PASS, "Gross Sales for Cashier Report Report is equal to Sale Recap Report for This month");
		
				excel.setreport_PassedData("This month", 7, 17, "0.00");

				excel.setreport_PassedData("This month", 44, 8, GrossSales+"`");
			}
			else
			{
				double diff=Expected_Gross_Sales-ActualGross_Sales;
				test.log(LogStatus.FAIL, "Gross Sales for Cashier Report Report is not equal to Sale Recap Report  for This month.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("This month", 7, 17,diff_value);
				excel.setreport_FailedData("This month", 44, 8,diff_value);
			
			}
			
			
			
			//Get the Net Void
			String NetVoid=repts.Net_Void_SaleRecap().getText().replace(",", "");
			double ActualNet_Void=Double.parseDouble(NetVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("This month", 9, 16, NetVoid);
			excel.setreportData("This month", 46, 8, NetVoid);
			
			
			
			//Get the Gross Void
			String GrossVoid=repts.Gross_Void_SaleRecap().getText().replace(",", "");
			double ActualGross_Void=Double.parseDouble(GrossVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("This month", 10, 16, GrossVoid);
			excel.setreportData("This month", 47, 8, GrossVoid);
			
			}
			else
			{
				test.log(LogStatus.FAIL, "Sales Table Field not available");
	
			}
			
			try
			{
			if(repts.Taxes_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Taxes Table Field Available");
				
			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("This month", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
		
			//Get the Tax
			String Tx=repts.Tax_SaleRecap().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("This month", 3, 16, Tx);
			
			
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Cashier Report Report is equal to Sale Recap Report for This month");
		
				excel.setreport_PassedData("This month", 3, 17, "0");

				excel.setreport_PassedData("This month", 40, 8, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Cashier Report Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 3, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("This month", 3, 17,diff_value);

				excel.setreport_FailedData("This month", 40, 8,diff_value);
			}
			
			
			
			try
			{
			if(repts.Tax_Exempt_SaleRecap().isDisplayed())
			{
			//Get the Tax Exempted
			String Tx_Exmpted=repts.Tax_Exempt_SaleRecap().getText().replace(",", "");
			double ActualTax_Exempted=Double.parseDouble(Tx_Exmpted);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("This month", 8, 16, Tx_Exmpted);
			excel.setreportData("This month", 45, 8, Tx_Exmpted);
			}
			}
			catch(Exception p)
			{
				test.log(LogStatus.INFO, "Tax Exempted not available");
				
				//Export Tax Exempted value to Excel
				excel.setreportData("This month", 8, 16, st);
				excel.setreportData("This month", 45, 8, st);
			}
			
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_SaleRecap().getText().replace(",", "");
			double ActualRounding_Off=Double.parseDouble(RoundOff);
			
			//Export Tax value to Excel
			excel.setreportData("This month", 12, 16, RoundOff);
			excel.setreportData("This month", 49, 8, RoundOff);
		}

			}
			catch(Exception ll)
		{
			test.log(LogStatus.FAIL, "Taxes Table Field not available");
			
			
			//Export Tax value to Excel
			excel.setreportData("This month", 3, 16, st);
			excel.setreportData("This month", 40, 8, st);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("This month", 8, 16, st);
			excel.setreportData("This month", 45, 8, st);
			
			//Export Tax value to Excel
			excel.setreportData("This month", 12, 16, st);
			excel.setreportData("This month", 49, 8, st);
			
		}
			
			try
			{
				
			if(repts.Discount_SaleRecap().isDisplayed())
			{
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("This month", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_SaleRecap().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("This month", 4, 16, Discnt);

			//Check whether the Discount value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Cashier Report Report is equal to Sale Recap Report for This month");
		
				excel.setreport_PassedData("This month", 4, 17, "0.00");

				excel.setreport_PassedData("This month", 41, 8, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Cashier Report Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Today", 4, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("This month", 4, 17,diff_value);

				excel.setreport_FailedData("This month", 41, 8,diff_value);
			}
			
			
			//Get Discount Tax
			String DiscntTx=repts.Discount_Tax_SaleRecap().getText().replace(",", "");
			double ActualDiscount_Tax=Double.parseDouble(DiscntTx);
			
			//Export Discount Tax value to Excel
			excel.setreportData("This month", 13, 16, DiscntTx);
			excel.setreportData("This month", 50, 8, DiscntTx);
			
		}
		}
		catch(Exception h)
		{
			test.log(LogStatus.FAIL, "Discount Table Field not available");

			
			//Export Discount value to Excel
			excel.setreportData("This month", 4, 16, "0.00");
			excel.setreportData("This month", 41, 8, "0.00");
			
			
			
			
			//Export Discount Tax value to Excel
			excel.setreportData("This month", 13, 16, st);
			excel.setreportData("This month", 50, 8, st);
		}
		
			
		try
		{
			if(repts.Refund_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Refund Table Field Available");
				
				//Get Refund Tax
				String Refund=repts.Refund_SaleRecap().getText().replace(",", "");
				double ActualRefund=Double.parseDouble(Refund);
				
				//Export Discount value to Excel
				excel.setreportData("This month", 11, 16, Refund);
				excel.setreportData("This month", 48, 8, Refund);
			}
		}
		catch(Exception l)
		{
				test.log(LogStatus.FAIL, "Refund Table Field not available");

				//Export Discount value to Excel
				excel.setreportData("This month", 11, 16, st);
				excel.setreportData("This month", 48, 8, st);
		}
			

			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Cashier_Out_Report_Last_Month(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));

		
		
		
		
		//Select Today
		repts.Select_Last_Month_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Cashier Report Not Available for Last month");
	
			excel.setreportData("Last month", 2, 16, st);
			excel.setreportData("Last month", 3, 16, st);
			excel.setreportData("Last month", 4, 16, st);
			excel.setreportData("Last month", 5, 16, st);
			excel.setreportData("Last month", 6, 16, st);
			excel.setreportData("Last month", 7, 16, st);
			
			excel.setreportData("Last month", 2, 17, st);
			excel.setreportData("Last month", 3, 17, st);
			excel.setreportData("Last month", 4, 17, st);
			excel.setreportData("Last month", 5, 17, st);
			excel.setreportData("Last month", 6, 17, st);
			excel.setreportData("Last month", 7, 17, st);
			
			excel.setreportData("Last month", 39, 8, st);
			excel.setreportData("Last month", 40, 8, st);
			excel.setreportData("Last month", 41, 8, st);
			excel.setreportData("Last month", 42, 8, st);
			excel.setreportData("Last month", 43, 8, st);
			excel.setreportData("Last month", 44, 8, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Cashier Report Available for Last month");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			if(repts.Sales_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Sales Table Field Available");

//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_Net_Sale=excel.getData("Last month", 2, 1).toString().replace(",", "");
			double Expected_NetSale=Double.parseDouble(Expected_Net_Sale);
			
			Thread.sleep(3000);
			//Get Net Sales
			String NetSale=repts.Net_Sales_SaleRecap().getText().replace(",", "");
			double ActualNet_Sales=Double.parseDouble(NetSale);
			
			//Export the Net Sales value to Excel
			excel.setreportData("Last month", 2, 16, NetSale);

			
			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSale==ActualNet_Sales)
			{
				test.log(LogStatus.PASS, "Net Sales for Cashier Report Report is equal to Sale Recap Report for Last month");
	
			excel.setreport_PassedData("Last month", 2, 17, "0.00");
			
			excel.setreport_PassedData("Last month", 39, 8, NetSale+"`");

			
			}
			else
			{
				double diff=Expected_NetSale-ActualNet_Sales;
				String diff_value=String.valueOf(diff);
				
				test.log(LogStatus.FAIL, "Net Sales for Cashier Report Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
				

				excel.setreport_FailedData("Last month", 2, 17,diff_value);
		
				excel.setreport_FailedData("Last month", 39, 8,diff_value);
			}
			
			
			//Get the Grand_Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("Last month", 5, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
			
			//Get the Grand_Sales
			String GrandSale=repts.Grand_Sales_SaleRecap().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
			//Export Grand_Sales value to Excel
			excel.setreportData("Last month", 5, 16, GrandSale);

			//Check whether the Discount value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Cashier Report Report is equal to Sale Recap Report for Last month");
		
			
				excel.setreport_PassedData("Last month", 5, 17, "0.00");

				excel.setreport_PassedData("Last month", 42, 8, GrandSale+"`");
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Cashier Report Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
			
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Last month", 5, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last month", 5, 17,diff_value);

				excel.setreport_FailedData("Last month", 42, 8,diff_value);
			}
			
			//Get the Gross Receipt from Sale Recap Report
			String Expected_GrossReceipt=excel.getData("Last month", 6, 1).toString().replace(",", "");
			double Expected_Gross_Receipt=Double.parseDouble(Expected_GrossReceipt);
		
			
			//Get the Gross Receipt
			String GrossReceipt=repts.Gross_Receipt_SaleRecap().getText().replace(",", "");
			double ActualGross_Receipt=Double.parseDouble(GrossReceipt);
			
			//Export the  Gross Receipt value to Excel
			excel.setreportData("Last month", 6, 16, GrossReceipt);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Receipt==ActualGross_Receipt)
			{
				test.log(LogStatus.PASS, "Gross Receipt for Cashier Report Report is equal to Sale Recap Report for Last month");
		
				excel.setreport_PassedData("Last month", 6, 17, "0.00");

				excel.setreport_PassedData("Last month", 43, 8, GrossReceipt+"`");
			}
			else
			{
				double diff=Expected_Gross_Receipt-ActualGross_Receipt;
				test.log(LogStatus.FAIL, "Gross Receipt for Cashier Report Report is not equal to Sale Recap Report  for Last month.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Last month", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last month", 6, 17,diff_value);
				excel.setreport_FailedData("Last month", 43, 8,diff_value);
			
			}
			
			
			//Get the Gross Sales from Sale Recap Report
			String Expected_GrossSales=excel.getData("Last month", 7, 1).toString().replace(",", "");
			double Expected_Gross_Sales=Double.parseDouble(Expected_GrossSales);
		
			
			//Get the Gross Sales
			String GrossSales=repts.Gross_Sales_SaleRecap().getText().replace(",", "");
			double ActualGross_Sales=Double.parseDouble(GrossSales);
			
			//Export the Gross Sales of Sale value to Excel
			excel.setreportData("Last month", 7, 16, GrossSales);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Sales==ActualGross_Sales)
			{
				test.log(LogStatus.PASS, "Gross Sales for Cashier Report Report is equal to Sale Recap Report for Last month");
		
				excel.setreport_PassedData("Last month", 7, 17, "0.00");

				excel.setreport_PassedData("Last month", 44, 8, GrossSales+"`");
			}
			else
			{
				double diff=Expected_Gross_Sales-ActualGross_Sales;
				test.log(LogStatus.FAIL, "Gross Sales for Cashier Report Report is not equal to Sale Recap Report  for Last month.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Last month", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last month", 7, 17,diff_value);
				excel.setreport_FailedData("Last month", 44, 8,diff_value);
			
			}
			
			
			
			//Get the Net Void
			String NetVoid=repts.Net_Void_SaleRecap().getText().replace(",", "");
			double ActualNet_Void=Double.parseDouble(NetVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("Last month", 9, 16, NetVoid);
			excel.setreportData("Last month", 46, 8, NetVoid);
			
			
			
			//Get the Gross Void
			String GrossVoid=repts.Gross_Void_SaleRecap().getText().replace(",", "");
			double ActualGross_Void=Double.parseDouble(GrossVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("Last month", 10, 16, GrossVoid);
			excel.setreportData("Last month", 47, 8, GrossVoid);
			
			}
			else
			{
				test.log(LogStatus.FAIL, "Sales Table Field not available");
	
			}
			
			try
			{
			if(repts.Taxes_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Taxes Table Field Available");
				
			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Last month", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
		
			//Get the Tax
			String Tx=repts.Tax_SaleRecap().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last month", 3, 16, Tx);
			
			
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Cashier Report Report is equal to Sale Recap Report for Last month");
		
				excel.setreport_PassedData("Last month", 3, 17, "0");

				excel.setreport_PassedData("Last month", 40, 8, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Cashier Report Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Last month", 3, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last month", 3, 17,diff_value);

				excel.setreport_FailedData("Last month", 40, 8,diff_value);
			}
			
			
			
			try
			{
			if(repts.Tax_Exempt_SaleRecap().isDisplayed())
			{
			//Get the Tax Exempted
			String Tx_Exmpted=repts.Tax_Exempt_SaleRecap().getText().replace(",", "");
			double ActualTax_Exempted=Double.parseDouble(Tx_Exmpted);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("Last month", 8, 16, Tx_Exmpted);
			excel.setreportData("Last month", 45, 8, Tx_Exmpted);
			}
			}
			catch(Exception p)
			{
				test.log(LogStatus.INFO, "Tax Exempted not available");
				
				//Export Tax Exempted value to Excel
				excel.setreportData("Last month", 8, 16, st);
				excel.setreportData("Last month", 45, 8, st);
			}
			
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_SaleRecap().getText().replace(",", "");
			double ActualRounding_Off=Double.parseDouble(RoundOff);
			
			//Export Tax value to Excel
			excel.setreportData("Last month", 12, 16, RoundOff);
			excel.setreportData("Last month", 49, 8, RoundOff);
		}

			}
			catch(Exception ll)
		{
			test.log(LogStatus.FAIL, "Taxes Table Field not available");
			
			
			//Export Tax value to Excel
			excel.setreportData("Last month", 3, 16, st);
			excel.setreportData("Last month", 40, 8, st);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("Last month", 8, 16, st);
			excel.setreportData("Last month", 45, 8, st);
			
			//Export Tax value to Excel
			excel.setreportData("Last month", 12, 16, st);
			excel.setreportData("Last month", 49, 8, st);
			
		}
			
			try
			{
				
			if(repts.Discount_SaleRecap().isDisplayed())
			{
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Last month", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_SaleRecap().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Last month", 4, 16, Discnt);

			//Check whether the Discount value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Cashier Report Report is equal to Sale Recap Report for Last month");
		
				excel.setreport_PassedData("Last month", 4, 17, "0.00");

				excel.setreport_PassedData("Last month", 41, 8, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Cashier Report Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Last month", 4, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last month", 4, 17,diff_value);

				excel.setreport_FailedData("Last month", 41, 8,diff_value);
			}
			
			
			//Get Discount Tax
			String DiscntTx=repts.Discount_Tax_SaleRecap().getText().replace(",", "");
			double ActualDiscount_Tax=Double.parseDouble(DiscntTx);
			
			//Export Discount Tax value to Excel
			excel.setreportData("Last month", 13, 16, DiscntTx);
			excel.setreportData("Last month", 50, 8, DiscntTx);
			
		}
		}
		catch(Exception h)
		{
			test.log(LogStatus.FAIL, "Discount Table Field not available");

			
			//Export Discount value to Excel
			excel.setreportData("Last month", 4, 16, "0.00");
			excel.setreportData("Last month", 41, 8, "0.00");
			
			
			
			
			//Export Discount Tax value to Excel
			excel.setreportData("Last month", 13, 16, st);
			excel.setreportData("Last month", 50, 8, st);
		}
		
			
		try
		{
			if(repts.Refund_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Refund Table Field Available");
				
				//Get Refund Tax
				String Refund=repts.Refund_SaleRecap().getText().replace(",", "");
				double ActualRefund=Double.parseDouble(Refund);
				
				//Export Discount value to Excel
				excel.setreportData("Last month", 11, 16, Refund);
				excel.setreportData("Last month", 48, 8, Refund);
			}
		}
		catch(Exception l)
		{
				test.log(LogStatus.FAIL, "Refund Table Field not available");

				//Export Discount value to Excel
				excel.setreportData("Last month", 11, 16, st);
				excel.setreportData("Last month", 48, 8, st);
		}
			


			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Cashier_Out_Report_Last_30_Days(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		

		
		
		
		//Select Today
		repts.Select_Last_30_Days_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Cashier Report Not Available for Last 30 days");
		
		
			excel.setreportData("Last 30 days", 2, 16, st);
			excel.setreportData("Last 30 days", 3, 16, st);
			excel.setreportData("Last 30 days", 4, 16, st);
			excel.setreportData("Last 30 days", 5, 16, st);
			excel.setreportData("Last 30 days", 6, 16, st);
			excel.setreportData("Last 30 days", 7, 16, st);
			
			excel.setreportData("Last 30 days", 2, 17, st);
			excel.setreportData("Last 30 days", 3, 17, st);
			excel.setreportData("Last 30 days", 4, 17, st);
			excel.setreportData("Last 30 days", 5, 17, st);
			excel.setreportData("Last 30 days", 6, 17, st);
			excel.setreportData("Last 30 days", 7, 17, st);
			
			excel.setreportData("Last 30 days", 39, 8, st);
			excel.setreportData("Last 30 days", 40, 8, st);
			excel.setreportData("Last 30 days", 41, 8, st);
			excel.setreportData("Last 30 days", 42, 8, st);
			excel.setreportData("Last 30 days", 43, 8, st);
			excel.setreportData("Last 30 days", 44, 8, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Cashier Report Available for Last 30 days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			if(repts.Sales_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Sales Table Field Available");

//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_Net_Sale=excel.getData("Last 30 days", 2, 1).toString().replace(",", "");
			double Expected_NetSale=Double.parseDouble(Expected_Net_Sale);
			
			Thread.sleep(3000);
			//Get Net Sales
			String NetSale=repts.Net_Sales_SaleRecap().getText().replace(",", "");
			double ActualNet_Sales=Double.parseDouble(NetSale);
			
			//Export the Net Sales value to Excel
			excel.setreportData("Last 30 days", 2, 16, NetSale);

			
			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSale==ActualNet_Sales)
			{
				test.log(LogStatus.PASS, "Net Sales for Cashier Report Report is equal to Sale Recap Report for Last 30 days");
	
			excel.setreport_PassedData("Last 30 days", 2, 17, "0.00");
			
			excel.setreport_PassedData("Last 30 days", 39, 8, NetSale+"`");

			
			}
			else
			{
				double diff=Expected_NetSale-ActualNet_Sales;
				String diff_value=String.valueOf(diff);
				
				test.log(LogStatus.FAIL, "Net Sales for Cashier Report Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
				

				excel.setreport_FailedData("Last 30 days", 2, 17,diff_value);
		
				excel.setreport_FailedData("Last 30 days", 39, 8,diff_value);
			}
			
			
			//Get the Grand_Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("Last 30 days", 5, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
			
			//Get the Grand_Sales
			String GrandSale=repts.Grand_Sales_SaleRecap().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
			//Export Grand_Sales value to Excel
			excel.setreportData("Last 30 days", 5, 16, GrandSale);

			//Check whether the Discount value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Cashier Report Report is equal to Sale Recap Report for Last 30 days");
		
			
				excel.setreport_PassedData("Last 30 days", 5, 17, "0.00");

				excel.setreport_PassedData("Last 30 days", 42, 8, GrandSale+"`");
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Cashier Report Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
			
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Last 30 days", 5, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last 30 days", 5, 17,diff_value);

				excel.setreport_FailedData("Last 30 days", 42, 8,diff_value);
			}
			
			//Get the Gross Receipt from Sale Recap Report
			String Expected_GrossReceipt=excel.getData("Last 30 days", 6, 1).toString().replace(",", "");
			double Expected_Gross_Receipt=Double.parseDouble(Expected_GrossReceipt);
		
			
			//Get the Gross Receipt
			String GrossReceipt=repts.Gross_Receipt_SaleRecap().getText().replace(",", "");
			double ActualGross_Receipt=Double.parseDouble(GrossReceipt);
			
			//Export the  Gross Receipt value to Excel
			excel.setreportData("Last 30 days", 6, 16, GrossReceipt);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Receipt==ActualGross_Receipt)
			{
				test.log(LogStatus.PASS, "Gross Receipt for Cashier Report Report is equal to Sale Recap Report for Last 30 days");
		
				excel.setreport_PassedData("Last 30 days", 6, 17, "0.00");

				excel.setreport_PassedData("Last 30 days", 43, 8, GrossReceipt+"`");
			}
			else
			{
				double diff=Expected_Gross_Receipt-ActualGross_Receipt;
				test.log(LogStatus.FAIL, "Gross Receipt for Cashier Report Report is not equal to Sale Recap Report  for Last 30 days.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Last 30 days", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last 30 days", 6, 17,diff_value);
				excel.setreport_FailedData("Last 30 days", 43, 8,diff_value);
			
			}
			
			
			//Get the Gross Sales from Sale Recap Report
			String Expected_GrossSales=excel.getData("Last 30 days", 7, 1).toString().replace(",", "");
			double Expected_Gross_Sales=Double.parseDouble(Expected_GrossSales);
		
			
			//Get the Gross Sales
			String GrossSales=repts.Gross_Sales_SaleRecap().getText().replace(",", "");
			double ActualGross_Sales=Double.parseDouble(GrossSales);
			
			//Export the Gross Sales of Sale value to Excel
			excel.setreportData("Last 30 days", 7, 16, GrossSales);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Sales==ActualGross_Sales)
			{
				test.log(LogStatus.PASS, "Gross Sales for Cashier Report Report is equal to Sale Recap Report for Last 30 days");
		
				excel.setreport_PassedData("Last 30 days", 7, 17, "0.00");

				excel.setreport_PassedData("Last 30 days", 44, 8, GrossSales+"`");
			}
			else
			{
				double diff=Expected_Gross_Sales-ActualGross_Sales;
				test.log(LogStatus.FAIL, "Gross Sales for Cashier Report Report is not equal to Sale Recap Report  for Last 30 days.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Last 30 days", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last 30 days", 7, 17,diff_value);
				excel.setreport_FailedData("Last 30 days", 44, 8,diff_value);
			
			}
			
			
			
			//Get the Net Void
			String NetVoid=repts.Net_Void_SaleRecap().getText().replace(",", "");
			double ActualNet_Void=Double.parseDouble(NetVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("Last 30 days", 9, 16, NetVoid);
			excel.setreportData("Last 30 days", 46, 8, NetVoid);
			
			
			
			//Get the Gross Void
			String GrossVoid=repts.Gross_Void_SaleRecap().getText().replace(",", "");
			double ActualGross_Void=Double.parseDouble(GrossVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("Last 30 days", 10, 16, GrossVoid);
			excel.setreportData("Last 30 days", 47, 8, GrossVoid);
			
			}
			else
			{
				test.log(LogStatus.FAIL, "Sales Table Field not available");
	
			}
			
			try
			{
			if(repts.Taxes_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Taxes Table Field Available");
				
			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Last 30 days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
		
			//Get the Tax
			String Tx=repts.Tax_SaleRecap().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last 30 days", 3, 16, Tx);
			
			
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Cashier Report Report is equal to Sale Recap Report for Last 30 days");
		
				excel.setreport_PassedData("Last 30 days", 3, 17, "0");

				excel.setreport_PassedData("Last 30 days", 40, 8, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Cashier Report Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Last 30 days", 3, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last 30 days", 3, 17,diff_value);

				excel.setreport_FailedData("Last 30 days", 40, 8,diff_value);
			}
			
			
			
			try
			{
			if(repts.Tax_Exempt_SaleRecap().isDisplayed())
			{
			//Get the Tax Exempted
			String Tx_Exmpted=repts.Tax_Exempt_SaleRecap().getText().replace(",", "");
			double ActualTax_Exempted=Double.parseDouble(Tx_Exmpted);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("Last 30 days", 8, 16, Tx_Exmpted);
			excel.setreportData("Last 30 days", 45, 8, Tx_Exmpted);
			}
			}
			catch(Exception p)
			{
				test.log(LogStatus.INFO, "Tax Exempted not available");
				
				//Export Tax Exempted value to Excel
				excel.setreportData("Last 30 days", 8, 16, st);
				excel.setreportData("Last 30 days", 45, 8, st);
			}
			
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_SaleRecap().getText().replace(",", "");
			double ActualRounding_Off=Double.parseDouble(RoundOff);
			
			//Export Tax value to Excel
			excel.setreportData("Last 30 days", 12, 16, RoundOff);
			excel.setreportData("Last 30 days", 49, 8, RoundOff);
		}

			}
			catch(Exception ll)
		{
			test.log(LogStatus.FAIL, "Taxes Table Field not available");
			
			
			//Export Tax value to Excel
			excel.setreportData("Last 30 days", 3, 16, st);
			excel.setreportData("Last 30 days", 40, 8, st);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("Last 30 days", 8, 16, st);
			excel.setreportData("Last 30 days", 45, 8, st);
			
			//Export Tax value to Excel
			excel.setreportData("Last 30 days", 12, 16, st);
			excel.setreportData("Last 30 days", 49, 8, st);
			
		}
			
			try
			{
				
			if(repts.Discount_SaleRecap().isDisplayed())
			{
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Last 30 days", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_SaleRecap().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Last 30 days", 4, 16, Discnt);

			//Check whether the Discount value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Cashier Report Report is equal to Sale Recap Report for Last 30 days");
		
				excel.setreport_PassedData("Last 30 days", 4, 17, "0.00");

				excel.setreport_PassedData("Last 30 days", 41, 8, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Cashier Report Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Last 30 days", 4, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Last 30 days", 4, 17,diff_value);

				excel.setreport_FailedData("Last 30 days", 41, 8,diff_value);
			}
			
			
			//Get Discount Tax
			String DiscntTx=repts.Discount_Tax_SaleRecap().getText().replace(",", "");
			double ActualDiscount_Tax=Double.parseDouble(DiscntTx);
			
			//Export Discount Tax value to Excel
			excel.setreportData("Last 30 days", 13, 16, DiscntTx);
			excel.setreportData("Last 30 days", 50, 8, DiscntTx);
			
		}
		}
		catch(Exception h)
		{
			test.log(LogStatus.FAIL, "Discount Table Field not available");

			
			//Export Discount value to Excel
			excel.setreportData("Last 30 days", 4, 16, "0.00");
			excel.setreportData("Last 30 days", 41, 8, "0.00");
			
			
			
			
			//Export Discount Tax value to Excel
			excel.setreportData("Last 30 days", 13, 16, st);
			excel.setreportData("Last 30 days", 50, 8, st);
		}
		
			
		try
		{
			if(repts.Refund_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Refund Table Field Available");
				
				//Get Refund Tax
				String Refund=repts.Refund_SaleRecap().getText().replace(",", "");
				double ActualRefund=Double.parseDouble(Refund);
				
				//Export Discount value to Excel
				excel.setreportData("Last 30 days", 11, 16, Refund);
				excel.setreportData("Last 30 days", 48, 8, Refund);
			}
		}
		catch(Exception l)
		{
				test.log(LogStatus.FAIL, "Refund Table Field not available");

				//Export Discount value to Excel
				excel.setreportData("Last 30 days", 11, 16, st);
				excel.setreportData("Last 30 days", 48, 8, st);
		}
			


			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Cashier_Out_Report_Specific_Date(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		

		
		
		
		//Select Today
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Cashier Report Not Available for Specific Date");
		
			excel.setreportData("Specific Date", 2, 16, st);
			excel.setreportData("Specific Date", 3, 16, st);
			excel.setreportData("Specific Date", 4, 16, st);
			excel.setreportData("Specific Date", 5, 16, st);
			excel.setreportData("Specific Date", 6, 16, st);
			excel.setreportData("Specific Date", 7, 16, st);
			
			excel.setreportData("Specific Date", 2, 17, st);
			excel.setreportData("Specific Date", 3, 17, st);
			excel.setreportData("Specific Date", 4, 17, st);
			excel.setreportData("Specific Date", 5, 17, st);
			excel.setreportData("Specific Date", 6, 17, st);
			excel.setreportData("Specific Date", 7, 17, st);
			
			excel.setreportData("Specific Date", 39, 8, st);
			excel.setreportData("Specific Date", 40, 8, st);
			excel.setreportData("Specific Date", 41, 8, st);
			excel.setreportData("Specific Date", 42, 8, st);
			excel.setreportData("Specific Date", 43, 8, st);
			excel.setreportData("Specific Date", 44, 8, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Cashier Report Available for Specific Date");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			if(repts.Sales_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Sales Table Field Available");

//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_Net_Sale=excel.getData("Specific Date", 2, 1).toString().replace(",", "");
			double Expected_NetSale=Double.parseDouble(Expected_Net_Sale);
			
			Thread.sleep(3000);
			//Get Net Sales
			String NetSale=repts.Net_Sales_SaleRecap().getText().replace(",", "");
			double ActualNet_Sales=Double.parseDouble(NetSale);
			
			//Export the Net Sales value to Excel
			excel.setreportData("Specific Date", 2, 16, NetSale);

			
			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSale==ActualNet_Sales)
			{
				test.log(LogStatus.PASS, "Net Sales for Cashier Report Report is equal to Sale Recap Report for Specific Date");
	
			excel.setreport_PassedData("Specific Date", 2, 17, "0.00");
			
			excel.setreport_PassedData("Specific Date", 39, 8, NetSale+"`");

			
			}
			else
			{
				double diff=Expected_NetSale-ActualNet_Sales;
				String diff_value=String.valueOf(diff);
				
				test.log(LogStatus.FAIL, "Net Sales for Cashier Report Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
				

				excel.setreport_FailedData("Specific Date", 2, 17,diff_value);
		
				excel.setreport_FailedData("Specific Date", 39, 8,diff_value);
			}
			
			
			//Get the Grand_Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("Specific Date", 5, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
			
			//Get the Grand_Sales
			String GrandSale=repts.Grand_Sales_SaleRecap().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
			//Export Grand_Sales value to Excel
			excel.setreportData("Specific Date", 5, 16, GrandSale);

			//Check whether the Discount value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Cashier Report Report is equal to Sale Recap Report for Specific Date");
		
			
				excel.setreport_PassedData("Specific Date", 5, 17, "0.00");

				excel.setreport_PassedData("Specific Date", 42, 8, GrandSale+"`");
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Cashier Report Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
			
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Specific Date", 5, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Specific Date", 5, 17,diff_value);

				excel.setreport_FailedData("Specific Date", 42, 8,diff_value);
			}
			
			//Get the Gross Receipt from Sale Recap Report
			String Expected_GrossReceipt=excel.getData("Specific Date", 6, 1).toString().replace(",", "");
			double Expected_Gross_Receipt=Double.parseDouble(Expected_GrossReceipt);
		
			
			//Get the Gross Receipt
			String GrossReceipt=repts.Gross_Receipt_SaleRecap().getText().replace(",", "");
			double ActualGross_Receipt=Double.parseDouble(GrossReceipt);
			
			//Export the  Gross Receipt value to Excel
			excel.setreportData("Specific Date", 6, 16, GrossReceipt);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Receipt==ActualGross_Receipt)
			{
				test.log(LogStatus.PASS, "Gross Receipt for Cashier Report Report is equal to Sale Recap Report for Specific Date");
		
				excel.setreport_PassedData("Specific Date", 6, 17, "0.00");

				excel.setreport_PassedData("Specific Date", 43, 8, GrossReceipt+"`");
			}
			else
			{
				double diff=Expected_Gross_Receipt-ActualGross_Receipt;
				test.log(LogStatus.FAIL, "Gross Receipt for Cashier Report Report is not equal to Sale Recap Report  for Specific Date.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Specific Date", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Specific Date", 6, 17,diff_value);
				excel.setreport_FailedData("Specific Date", 43, 8,diff_value);
			
			}
			
			
			//Get the Gross Sales from Sale Recap Report
			String Expected_GrossSales=excel.getData("Specific Date", 7, 1).toString().replace(",", "");
			double Expected_Gross_Sales=Double.parseDouble(Expected_GrossSales);
		
			
			//Get the Gross Sales
			String GrossSales=repts.Gross_Sales_SaleRecap().getText().replace(",", "");
			double ActualGross_Sales=Double.parseDouble(GrossSales);
			
			//Export the Gross Sales of Sale value to Excel
			excel.setreportData("Specific Date", 7, 16, GrossSales);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Sales==ActualGross_Sales)
			{
				test.log(LogStatus.PASS, "Gross Sales for Cashier Report Report is equal to Sale Recap Report for Specific Date");
		
				excel.setreport_PassedData("Specific Date", 7, 17, "0.00");

				excel.setreport_PassedData("Specific Date", 44, 8, GrossSales+"`");
			}
			else
			{
				double diff=Expected_Gross_Sales-ActualGross_Sales;
				test.log(LogStatus.FAIL, "Gross Sales for Cashier Report Report is not equal to Sale Recap Report  for Specific Date.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Specific Date", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Specific Date", 7, 17,diff_value);
				excel.setreport_FailedData("Specific Date", 44, 8,diff_value);
			
			}
			
			
			
			//Get the Net Void
			String NetVoid=repts.Net_Void_SaleRecap().getText().replace(",", "");
			double ActualNet_Void=Double.parseDouble(NetVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("Specific Date", 9, 16, NetVoid);
			excel.setreportData("Specific Date", 46, 8, NetVoid);
			
			
			
			//Get the Gross Void
			String GrossVoid=repts.Gross_Void_SaleRecap().getText().replace(",", "");
			double ActualGross_Void=Double.parseDouble(GrossVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("Specific Date", 10, 16, GrossVoid);
			excel.setreportData("Specific Date", 47, 8, GrossVoid);
			
			}
			else
			{
				test.log(LogStatus.FAIL, "Sales Table Field not available");
	
			}
			
			try
			{
			if(repts.Taxes_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Taxes Table Field Available");
				
			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Specific Date", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
		
			//Get the Tax
			String Tx=repts.Tax_SaleRecap().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Specific Date", 3, 16, Tx);
			
			
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Cashier Report Report is equal to Sale Recap Report for Specific Date");
		
				excel.setreport_PassedData("Specific Date", 3, 17, "0");

				excel.setreport_PassedData("Specific Date", 40, 8, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Cashier Report Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Specific Date", 3, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Specific Date", 3, 17,diff_value);

				excel.setreport_FailedData("Specific Date", 40, 8,diff_value);
			}
			
			
			
			try
			{
			if(repts.Tax_Exempt_SaleRecap().isDisplayed())
			{
			//Get the Tax Exempted
			String Tx_Exmpted=repts.Tax_Exempt_SaleRecap().getText().replace(",", "");
			double ActualTax_Exempted=Double.parseDouble(Tx_Exmpted);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("Specific Date", 8, 16, Tx_Exmpted);
			excel.setreportData("Specific Date", 45, 8, Tx_Exmpted);
			}
			}
			catch(Exception p)
			{
				test.log(LogStatus.INFO, "Tax Exempted not available");
				
				//Export Tax Exempted value to Excel
				excel.setreportData("Specific Date", 8, 16, st);
				excel.setreportData("Specific Date", 45, 8, st);
			}
			
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_SaleRecap().getText().replace(",", "");
			double ActualRounding_Off=Double.parseDouble(RoundOff);
			
			//Export Tax value to Excel
			excel.setreportData("Specific Date", 12, 16, RoundOff);
			excel.setreportData("Specific Date", 49, 8, RoundOff);
		}

			}
			catch(Exception ll)
		{
			test.log(LogStatus.FAIL, "Taxes Table Field not available");
			
			
			//Export Tax value to Excel
			excel.setreportData("Specific Date", 3, 16, st);
			excel.setreportData("Specific Date", 40, 8, st);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("Specific Date", 8, 16, st);
			excel.setreportData("Specific Date", 45, 8, st);
			
			//Export Tax value to Excel
			excel.setreportData("Specific Date", 12, 16, st);
			excel.setreportData("Specific Date", 49, 8, st);
			
		}
			
			try
			{
				
			if(repts.Discount_SaleRecap().isDisplayed())
			{
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Specific Date", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_SaleRecap().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Specific Date", 4, 16, Discnt);

			//Check whether the Discount value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Cashier Report Report is equal to Sale Recap Report for Specific Date");
		
				excel.setreport_PassedData("Specific Date", 4, 17, "0.00");

				excel.setreport_PassedData("Specific Date", 41, 8, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Cashier Report Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Specific Date", 4, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Specific Date", 4, 17,diff_value);

				excel.setreport_FailedData("Specific Date", 41, 8,diff_value);
			}
			
			
			//Get Discount Tax
			String DiscntTx=repts.Discount_Tax_SaleRecap().getText().replace(",", "");
			double ActualDiscount_Tax=Double.parseDouble(DiscntTx);
			
			//Export Discount Tax value to Excel
			excel.setreportData("Specific Date", 13, 16, DiscntTx);
			excel.setreportData("Specific Date", 50, 8, DiscntTx);
			
		}
		}
		catch(Exception h)
		{
			test.log(LogStatus.FAIL, "Discount Table Field not available");

			
			//Export Discount value to Excel
			excel.setreportData("Specific Date", 4, 16, "0.00");
			excel.setreportData("Specific Date", 41, 8, "0.00");
			
			
			
			
			//Export Discount Tax value to Excel
			excel.setreportData("Specific Date", 13, 16, st);
			excel.setreportData("Specific Date", 50, 8, st);
		}
		
			
		try
		{
			if(repts.Refund_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Refund Table Field Available");
				
				//Get Refund Tax
				String Refund=repts.Refund_SaleRecap().getText().replace(",", "");
				double ActualRefund=Double.parseDouble(Refund);
				
				//Export Discount value to Excel
				excel.setreportData("Specific Date", 11, 16, Refund);
				excel.setreportData("Specific Date", 48, 8, Refund);
			}
		}
		catch(Exception l)
		{
				test.log(LogStatus.FAIL, "Refund Table Field not available");

				//Export Discount value to Excel
				excel.setreportData("Specific Date", 11, 16, st);
				excel.setreportData("Specific Date", 48, 8, st);
		}
			


			
			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Cashier_Out_Report_Date_Range(WebDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		

		
		
		
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report for Cashier Report Not Available for Date Range");
		
			excel.setreportData("Date Range", 2, 16, st);
			excel.setreportData("Date Range", 3, 16, st);
			excel.setreportData("Date Range", 4, 16, st);
			excel.setreportData("Date Range", 5, 16, st);
			excel.setreportData("Date Range", 6, 16, st);
			excel.setreportData("Date Range", 7, 16, st);

			excel.setreportData("Date Range", 2, 17, st);
			excel.setreportData("Date Range", 3, 17, st);
			excel.setreportData("Date Range", 4, 17, st);
			excel.setreportData("Date Range", 5, 17, st);
			excel.setreportData("Date Range", 6, 17, st);
			excel.setreportData("Date Range", 7, 17, st);
			
			excel.setreportData("Date Range", 39, 8, st);
			excel.setreportData("Date Range", 40, 8, st);
			excel.setreportData("Date Range", 41, 8, st);
			excel.setreportData("Date Range", 42, 8, st);
			excel.setreportData("Date Range", 43, 8, st);
			excel.setreportData("Date Range", 44, 8, st);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report for Cashier Report Available for Date Range");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			if(repts.Sales_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Sales Table Field Available");

//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expected_Net_Sale=excel.getData("Date Range", 2, 1).toString().replace(",", "");
			double Expected_NetSale=Double.parseDouble(Expected_Net_Sale);
			
			Thread.sleep(3000);
			//Get Net Sales
			String NetSale=repts.Net_Sales_SaleRecap().getText().replace(",", "");
			double ActualNet_Sales=Double.parseDouble(NetSale);
			
			//Export the Net Sales value to Excel
			excel.setreportData("Date Range", 2, 16, NetSale);

			
			//Check whether the Net Sales value is Equal or not
			if(Expected_NetSale==ActualNet_Sales)
			{
				test.log(LogStatus.PASS, "Net Sales for Cashier Report Report is equal to Sale Recap Report for Date Range");
	
			excel.setreport_PassedData("Date Range", 2, 17, "0.00");
			
			excel.setreport_PassedData("Date Range", 39, 8, NetSale+"`");

			
			}
			else
			{
				double diff=Expected_NetSale-ActualNet_Sales;
				String diff_value=String.valueOf(diff);
				
				test.log(LogStatus.FAIL, "Net Sales for Cashier Report Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
				

				excel.setreport_FailedData("Date Range", 2, 17,diff_value);
		
				excel.setreport_FailedData("Date Range", 39, 8,diff_value);
			}
			
			
			//Get the Grand_Sales from Sale Recap Report
			String Expected_GrandSale=excel.getData("Date Range", 5, 1).toString().replace(",", "");
			double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
			
			//Get the Grand_Sales
			String GrandSale=repts.Grand_Sales_SaleRecap().getText().replace(",", "");
			double ActualGrand_Sales=Double.parseDouble(GrandSale);
			
			//Export Grand_Sales value to Excel
			excel.setreportData("Date Range", 5, 16, GrandSale);

			//Check whether the Discount value is Equal or not
			if(Expected_Grand_Sales==ActualGrand_Sales)
			{
				test.log(LogStatus.PASS, "Grand_Sales for Cashier Report Report is equal to Sale Recap Report for Date Range");
		
			
				excel.setreport_PassedData("Date Range", 5, 17, "0.00");

				excel.setreport_PassedData("Date Range", 42, 8, GrandSale+"`");
			}
			else
			{
				double diff=Expected_Grand_Sales-ActualGrand_Sales;
				test.log(LogStatus.FAIL, "Grand_Sales for Cashier Report Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
			
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Date Range", 5, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Date Range", 5, 17,diff_value);

				excel.setreport_FailedData("Date Range", 42, 8,diff_value);
			}
			
			//Get the Gross Receipt from Sale Recap Report
			String Expected_GrossReceipt=excel.getData("Date Range", 6, 1).toString().replace(",", "");
			double Expected_Gross_Receipt=Double.parseDouble(Expected_GrossReceipt);
		
			
			//Get the Gross Receipt
			String GrossReceipt=repts.Gross_Receipt_SaleRecap().getText().replace(",", "");
			double ActualGross_Receipt=Double.parseDouble(GrossReceipt);
			
			//Export the  Gross Receipt value to Excel
			excel.setreportData("Date Range", 6, 16, GrossReceipt);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Receipt==ActualGross_Receipt)
			{
				test.log(LogStatus.PASS, "Gross Receipt for Cashier Report Report is equal to Sale Recap Report for Date Range");
		
				excel.setreport_PassedData("Date Range", 6, 17, "0.00");

				excel.setreport_PassedData("Date Range", 43, 8, GrossReceipt+"`");
			}
			else
			{
				double diff=Expected_Gross_Receipt-ActualGross_Receipt;
				test.log(LogStatus.FAIL, "Gross Receipt for Cashier Report Report is not equal to Sale Recap Report  for Date Range.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Date Range", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Date Range", 6, 17,diff_value);
				excel.setreport_FailedData("Date Range", 43, 8,diff_value);
			
			}
			
			
			//Get the Gross Sales from Sale Recap Report
			String Expected_GrossSales=excel.getData("Date Range", 7, 1).toString().replace(",", "");
			double Expected_Gross_Sales=Double.parseDouble(Expected_GrossSales);
		
			
			//Get the Gross Sales
			String GrossSales=repts.Gross_Sales_SaleRecap().getText().replace(",", "");
			double ActualGross_Sales=Double.parseDouble(GrossSales);
			
			//Export the Gross Sales of Sale value to Excel
			excel.setreportData("Date Range", 7, 16, GrossSales);

			
			//Check whether the Gross Receipt value is Equal or not
			if(Expected_Gross_Sales==ActualGross_Sales)
			{
				test.log(LogStatus.PASS, "Gross Sales for Cashier Report Report is equal to Sale Recap Report for Date Range");
		
				excel.setreport_PassedData("Date Range", 7, 17, "0.00");

				excel.setreport_PassedData("Date Range", 44, 8, GrossSales+"`");
			}
			else
			{
				double diff=Expected_Gross_Sales-ActualGross_Sales;
				test.log(LogStatus.FAIL, "Gross Sales for Cashier Report Report is not equal to Sale Recap Report  for Date Range.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Date Range", 6, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Date Range", 7, 17,diff_value);
				excel.setreport_FailedData("Date Range", 44, 8,diff_value);
			
			}
			
			
			
			//Get the Net Void
			String NetVoid=repts.Net_Void_SaleRecap().getText().replace(",", "");
			double ActualNet_Void=Double.parseDouble(NetVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("Date Range", 9, 16, NetVoid);
			excel.setreportData("Date Range", 46, 8, NetVoid);
			
			
			
			//Get the Gross Void
			String GrossVoid=repts.Gross_Void_SaleRecap().getText().replace(",", "");
			double ActualGross_Void=Double.parseDouble(GrossVoid);
			
			//Export the % Grand Sales value to Excel
			excel.setreportData("Date Range", 10, 16, GrossVoid);
			excel.setreportData("Date Range", 47, 8, GrossVoid);
			
			}
			else
			{
				test.log(LogStatus.FAIL, "Sales Table Field not available");
	
			}
			
			try
			{
			if(repts.Taxes_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Taxes Table Field Available");
				
			//Get the Tax from Sale Recap Report
			String Expected_Tx=excel.getData("Date Range", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expected_Tx);
		
			//Get the Tax
			String Tx=repts.Tax_SaleRecap().getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Date Range", 3, 16, Tx);
			
			
			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Cashier Report Report is equal to Sale Recap Report for Date Range");
		
				excel.setreport_PassedData("Date Range", 3, 17, "0");

				excel.setreport_PassedData("Date Range", 40, 8, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Cashier Report Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Date Range", 3, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Date Range", 3, 17,diff_value);

				excel.setreport_FailedData("Date Range", 40, 8,diff_value);
			}
			
			
			
			try
			{
			if(repts.Tax_Exempt_SaleRecap().isDisplayed())
			{
			//Get the Tax Exempted
			String Tx_Exmpted=repts.Tax_Exempt_SaleRecap().getText().replace(",", "");
			double ActualTax_Exempted=Double.parseDouble(Tx_Exmpted);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("Date Range", 8, 16, Tx_Exmpted);
			excel.setreportData("Date Range", 45, 8, Tx_Exmpted);
			}
			}
			catch(Exception p)
			{
				test.log(LogStatus.INFO, "Tax Exempted not available");
				
				//Export Tax Exempted value to Excel
				excel.setreportData("Date Range", 8, 16, st);
				excel.setreportData("Date Range", 45, 8, st);
			}
			
			
			//Get the Rounding Off
			String RoundOff=repts.Rounding_Off_SaleRecap().getText().replace(",", "");
			double ActualRounding_Off=Double.parseDouble(RoundOff);
			
			//Export Tax value to Excel
			excel.setreportData("Date Range", 12, 16, RoundOff);
			excel.setreportData("Date Range", 49, 8, RoundOff);
		}

			}
			catch(Exception ll)
		{
			test.log(LogStatus.FAIL, "Taxes Table Field not available");
			
			
			//Export Tax value to Excel
			excel.setreportData("Date Range", 3, 16, st);
			excel.setreportData("Date Range", 40, 8, st);
			
			//Export Tax Exempted value to Excel
			excel.setreportData("Date Range", 8, 16, st);
			excel.setreportData("Date Range", 45, 8, st);
			
			//Export Tax value to Excel
			excel.setreportData("Date Range", 12, 16, st);
			excel.setreportData("Date Range", 49, 8, st);
			
		}
			
			try
			{
				
			if(repts.Discount_SaleRecap().isDisplayed())
			{
			
			//Get the Discount from Sale Recap Report
			String Expected_Discnt=excel.getData("Date Range", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expected_Discnt);
			
			//Get the Discount
			String Discnt=repts.Discount_SaleRecap().getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Date Range", 4, 16, Discnt);

			//Check whether the Discount value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Cashier Report Report is equal to Sale Recap Report for Date Range");
		
				excel.setreport_PassedData("Date Range", 4, 17, "0.00");

				excel.setreport_PassedData("Date Range", 41, 8, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Cashier Report Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
		
				String diff_value=String.valueOf(diff);

				//Export the Net Sales value to Excel
//				excel.setreportData("Date Range", 4, 17, diff_value);
//				excel.Highlight_DifferenceValue();
				excel.setreport_FailedData("Date Range", 4, 17,diff_value);

				excel.setreport_FailedData("Date Range", 41, 8,diff_value);
			}
			
			
			//Get Discount Tax
			String DiscntTx=repts.Discount_Tax_SaleRecap().getText().replace(",", "");
			double ActualDiscount_Tax=Double.parseDouble(DiscntTx);
			
			//Export Discount Tax value to Excel
			excel.setreportData("Date Range", 13, 16, DiscntTx);
			excel.setreportData("Date Range", 50, 8, DiscntTx);
			
		}
		}
		catch(Exception h)
		{
			test.log(LogStatus.FAIL, "Discount Table Field not available");

			
			//Export Discount value to Excel
			excel.setreportData("Date Range", 4, 16, "0.00");
			excel.setreportData("Date Range", 41, 8, "0.00");
			
			
			
			
			//Export Discount Tax value to Excel
			excel.setreportData("Date Range", 13, 16, st);
			excel.setreportData("Date Range", 50, 8, st);
		}
		
			
		try
		{
			if(repts.Refund_Table_inSaleRecap().isDisplayed())
			{
				test.log(LogStatus.PASS, "Refund Table Field Available");
				
				//Get Refund Tax
				String Refund=repts.Refund_SaleRecap().getText().replace(",", "");
				double ActualRefund=Double.parseDouble(Refund);
				
				//Export Discount value to Excel
				excel.setreportData("Date Range", 11, 16, Refund);
				excel.setreportData("Date Range", 48, 8, Refund);
			}
		}
		catch(Exception l)
		{
				test.log(LogStatus.FAIL, "Refund Table Field not available");

				//Export Discount value to Excel
				excel.setreportData("Date Range", 11, 16, st);
				excel.setreportData("Date Range", 48, 8, st);
		}


						

			
			//To Write all the Data to Excel
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	

}
