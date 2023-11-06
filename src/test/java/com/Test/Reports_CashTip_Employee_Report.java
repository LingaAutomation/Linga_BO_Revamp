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

public class Reports_CashTip_Employee_Report 
{

public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Cash Tip Employee Report");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();

	String st = "0";
	
	
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
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
//		//Open the Chrome window
//		driver = new ChromeDriver();
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
		Open_Modifier_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Modifier_Report_Today(driver);
		Modifier_Report_Yesterday(driver);
		Modifier_Report_Last_N_Days(driver);
		Modifier_Report_This_Week(driver);
		Modifier_Report_Last_Week(driver);
		Modifier_Report_Last_7_Days(driver);
		Modifier_Report_This_Month(driver);
		Modifier_Report_Last_Month(driver);
		Modifier_Report_Last_30_Days(driver);
		Modifier_Report_Specific_Date(driver);
		Modifier_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Modifier_Report_Page(SelfHealingDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Modifier sales report page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"salesReports/modifier");

		Thread.sleep(5000);
		//Verify the Modifier sales report page loeded or not
		repts.Verify_ReportHomePage("MODIFIER");
		
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
		//Click the Modifier label
		driver.findElement(By.xpath("//span[contains(.,'Modifier')]/../input")).click();
		Thread.sleep(500);	
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
	}
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Today(SelfHealingDriver driver) throws Exception
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
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Today");
			excel.setreportData("Today", 1, 10, st);
			excel.setreportData("Today", 2, 10, st);
			excel.setreportData("Today", 3, 10, st);
			excel.setreportData("Today", 4, 10, st);
			excel.setreportData("Today", 5, 10, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report Available for Today");
	
			
			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();
			
			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();
			
			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Today", 1, 1).toString();
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[3]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Today", 1, 10, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Modifier Sale Report is equal to Sale Recap Report for Today");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Modifier Sale Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
			}
			
			//Get the Quantity from Sale Recap Report
			String Expeccted_Qty=excel.getData("Today", 2, 1).toString();
			double Expected_Quantity=Double.parseDouble(Expeccted_Qty);
		
			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[4]/span")).getText().replace(",", "");
			double ActualQuantity=Double.parseDouble(Qty);
			
			//Export Qunatity value to Excel
			excel.setreportData("Today", 2, 10, Qty);
			
			
			//Check whether the Quantity value is Equal or not
			if(Expected_Quantity==ActualQuantity)
			{
				test.log(LogStatus.PASS, "Quantity for Modifier Sale Report is equal to Sale Recap Report for Today");
			}
			else
			{
				double diff=Expected_Quantity-ActualQuantity;
				test.log(LogStatus.FAIL, "Quantity for Modifier Sale Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Today", 3, 1).toString();
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			//Get the Tax
			String Tx=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[5]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Today", 3, 10, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Modifier Sale Report is equal to Sale Recap Report for Today");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Modifier Sale Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
			}
						
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Yesterday(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheCat(driver);
		
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
			test.log(LogStatus.INFO, "Sale Report Not Available for Yesterday");
			excel.setreportData("Yesterday", 1, 10, st);
			excel.setreportData("Yesterday", 2, 10, st);
			excel.setreportData("Yesterday", 3, 10, st);
			excel.setreportData("Yesterday", 4, 10, st);
			excel.setreportData("Yesterday", 5, 10, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report Available for Yesterday");
	
			
			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();
			
			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();
			
			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Yesterday", 1, 1).toString();
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[3]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Yesterday", 1, 10, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Modifier Sale Report is equal to Sale Recap Report for Yesterday");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Modifier Sale Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
			}
			
			//Get the Quantity from Sale Recap Report
			String Expeccted_Qty=excel.getData("Yesterday", 2, 1).toString();
			double Expected_Quantity=Double.parseDouble(Expeccted_Qty);
		
			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[4]/span")).getText().replace(",", "");
			double ActualQuantity=Double.parseDouble(Qty);
			
			//Export Qunatity value to Excel
			excel.setreportData("Yesterday", 2, 10, Qty);
			
			
			//Check whether the Quantity value is Equal or not
			if(Expected_Quantity==ActualQuantity)
			{
				test.log(LogStatus.PASS, "Quantity for Modifier Sale Report is equal to Sale Recap Report for Yesterday");
			}
			else
			{
				double diff=Expected_Quantity-ActualQuantity;
				test.log(LogStatus.FAIL, "Quantity for Modifier Sale Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Yesterday", 3, 1).toString();
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			//Get the Tax
			String Tx=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[5]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Yesterday", 3, 10, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Modifier Sale Report is equal to Sale Recap Report for Yesterday");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Modifier Sale Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
			}
			
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Last_N_Days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheCat(driver);
		
		//Select Today
		repts.Select_Last_N_Days_TimePeriod("10");
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Last N days");
			excel.setreportData("Last N days", 1, 10, st);
			excel.setreportData("Last N days", 2, 10, st);
			excel.setreportData("Last N days", 3, 10, st);
			excel.setreportData("Last N days", 4, 10, st);
			excel.setreportData("Last N days", 5, 10, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report Available for Last N days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();
			
			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();
			
			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last N days", 1, 1).toString();
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[3]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Last N days", 1, 10, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Modifier Sale Report is equal to Sale Recap Report for Last 'N' Days");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Modifier Sale Report is not equal to Sale Recap Report for Last 'N' Days.The value diff is : "+diff);
			}
			
			//Get the Quantity from Sale Recap Report
			String Expeccted_Qty=excel.getData("Last N days", 2, 1).toString();
			double Expected_Quantity=Double.parseDouble(Expeccted_Qty);
			
			
			
			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[4]/span")).getText().replace(",", "");
			double ActualQuantity=Double.parseDouble(Qty);
			
			//Export Qunatity value to Excel
			excel.setreportData("Last N days", 2, 10, Qty);
			
			
			//Check whether the Quantity value is Equal or not
			if(Expected_Quantity==ActualQuantity)
			{
				test.log(LogStatus.PASS, "Quantity for Modifier Sale Report is equal to Sale Recap Report for Last 'N' Days");
			}
			else
			{
				double diff=Expected_Quantity-ActualQuantity;
				test.log(LogStatus.FAIL, "Quantity for Modifier Sale Report is not equal to Sale Recap Report for Last 'N' Days.The value diff is : "+diff);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last N days", 3, 1).toString();
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[5]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last N days", 3, 10, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Modifier Sale Report is equal to Sale Recap Report for Last 'N' Days");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Modifier Sale Report is not equal to Sale Recap Report for Last 'N' Days.The value diff is : "+diff);
			}
			
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}

	
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_This_Week(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheCat(driver);
		
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
			test.log(LogStatus.INFO, "Sale Report Not Available for This Week");
			excel.setreportData("This Week", 1, 10, st);
			excel.setreportData("This Week", 2, 10, st);
			excel.setreportData("This Week", 3, 10, st);
			excel.setreportData("This Week", 4, 10, st);
			excel.setreportData("This Week", 5, 10, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report Available for This Week");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();
			
			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();
			
			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("This Week", 1, 1).toString();
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[3]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("This Week", 1, 10, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Modifier Sale Report is equal to Sale Recap Report for This Week");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Modifier Sale Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
			}
			
			//Get the Quantity from Sale Recap Report
			String Expeccted_Qty=excel.getData("This Week", 2, 1).toString();
			double Expected_Quantity=Double.parseDouble(Expeccted_Qty);
			
			
			
			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[4]/span")).getText().replace(",", "");
			double ActualQuantity=Double.parseDouble(Qty);
			
			//Export Qunatity value to Excel
			excel.setreportData("This Week", 2, 10, Qty);
			
			
			//Check whether the Quantity value is Equal or not
			if(Expected_Quantity==ActualQuantity)
			{
				test.log(LogStatus.PASS, "Quantity for Modifier Sale Report is equal to Sale Recap Report for This Week");
			}
			else
			{
				double diff=Expected_Quantity-ActualQuantity;
				test.log(LogStatus.FAIL, "Quantity for Modifier Sale Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("This Week", 3, 1).toString();
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[5]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("This Week", 3, 10, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Modifier Sale Report is equal to Sale Recap Report for This Week");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Modifier Sale Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Last_Week(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheCat(driver);
		
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
			test.log(LogStatus.INFO, "Sale Report Not Available for Last Week");
			excel.setreportData("Last Week", 1, 10, st);
			excel.setreportData("Last Week", 2, 10, st);
			excel.setreportData("Last Week", 3, 10, st);
			excel.setreportData("Last Week", 4, 10, st);
			excel.setreportData("Last Week", 5, 10, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report Available for Last Week");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();
			
			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();
			
			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last Week", 1, 1).toString();
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[3]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Last Week", 1, 10, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Modifier Sale Report is equal to Sale Recap Report for Last Week");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Modifier Sale Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
			}
			
			//Get the Quantity from Sale Recap Report
			String Expeccted_Qty=excel.getData("Last Week", 2, 1).toString();
			double Expected_Quantity=Double.parseDouble(Expeccted_Qty);
			
			
			
			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[4]/span")).getText().replace(",", "");
			double ActualQuantity=Double.parseDouble(Qty);
			
			//Export Qunatity value to Excel
			excel.setreportData("Last Week", 2, 10, Qty);
			
			
			//Check whether the Quantity value is Equal or not
			if(Expected_Quantity==ActualQuantity)
			{
				test.log(LogStatus.PASS, "Quantity for Modifier Sale Report is equal to Sale Recap Report for Last Week");
			}
			else
			{
				double diff=Expected_Quantity-ActualQuantity;
				test.log(LogStatus.FAIL, "Quantity for Modifier Sale Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last Week", 3, 1).toString();
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[5]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last Week", 3, 10, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Modifier Sale Report is equal to Sale Recap Report for Last Week");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Modifier Sale Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Last_7_Days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheCat(driver);
		
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
			test.log(LogStatus.INFO, "Sale Report Not Available for Last 7 days");
			excel.setreportData("Last 7 days", 1, 10, st);
			excel.setreportData("Last 7 days", 2, 10, st);
			excel.setreportData("Last 7 days", 3, 10, st);
			excel.setreportData("Last 7 days", 4, 10, st);
			excel.setreportData("Last 7 days", 5, 10, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report Available for Last 7 days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();
			
			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();
			
			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last 7 days", 1, 1).toString();
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[3]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Last 7 days", 1, 10, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Modifier Sale Report is equal to Sale Recap Report for Last 7 days");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Modifier Sale Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
			}
			
			//Get the Quantity from Sale Recap Report
			String Expeccted_Qty=excel.getData("Last 7 days", 2, 1).toString();
			double Expected_Quantity=Double.parseDouble(Expeccted_Qty);
			
			
			
			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[4]/span")).getText().replace(",", "");
			double ActualQuantity=Double.parseDouble(Qty);
			
			//Export Qunatity value to Excel
			excel.setreportData("Last 7 days", 2, 10, Qty);
			
			
			//Check whether the Quantity value is Equal or not
			if(Expected_Quantity==ActualQuantity)
			{
				test.log(LogStatus.PASS, "Quantity for Modifier Sale Report is equal to Sale Recap Report for Last 7 days");
			}
			else
			{
				double diff=Expected_Quantity-ActualQuantity;
				test.log(LogStatus.FAIL, "Quantity for Modifier Sale Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last 7 days", 3, 1).toString();
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[5]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last 7 days", 3, 10, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Modifier Sale Report is equal to Sale Recap Report for Last 7 days");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Modifier Sale Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
			}
			
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_This_Month(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheCat(driver);
		
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
			test.log(LogStatus.INFO, "Sale Report Not Available for This month");
			excel.setreportData("This month", 1, 10, st);
			excel.setreportData("This month", 2, 10, st);
			excel.setreportData("This month", 3, 10, st);
			excel.setreportData("This month", 4, 10, st);
			excel.setreportData("This month", 5, 10, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report Available for This month");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();
			
			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();
			
			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("This month", 1, 1).toString();
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[3]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("This month", 1, 10, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Modifier Sale Report is equal to Sale Recap Report for This month");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Modifier Sale Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
			}
			
			//Get the Quantity from Sale Recap Report
			String Expeccted_Qty=excel.getData("This month", 2, 1).toString();
			double Expected_Quantity=Double.parseDouble(Expeccted_Qty);
			
			
			
			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[4]/span")).getText().replace(",", "");
			double ActualQuantity=Double.parseDouble(Qty);
			
			//Export Qunatity value to Excel
			excel.setreportData("This month", 2, 10, Qty);
			
			
			//Check whether the Quantity value is Equal or not
			if(Expected_Quantity==ActualQuantity)
			{
				test.log(LogStatus.PASS, "Quantity for Modifier Sale Report is equal to Sale Recap Report for LThis month");
			}
			else
			{
				double diff=Expected_Quantity-ActualQuantity;
				test.log(LogStatus.FAIL, "Quantity for Modifier Sale Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("This month", 3, 1).toString();
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[5]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("This month", 3, 10, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Modifier Sale Report is equal to Sale Recap Report for This month");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Modifier Sale Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Last_Month(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheCat(driver);
		
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
			test.log(LogStatus.INFO, "Sale Report Not Available for Last month");
			excel.setreportData("Last month", 1, 10, st);
			excel.setreportData("Last month", 2, 10, st);
			excel.setreportData("Last month", 3, 10, st);
			excel.setreportData("Last month", 4, 10, st);
			excel.setreportData("Last month", 5, 10, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report Available for Last month");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();
			
			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();
			
			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last month", 1, 1).toString();
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[3]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Last month", 1, 10, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Modifier Sale Report is equal to Sale Recap Report for Last month");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Modifier Sale Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
			}
			
			//Get the Quantity from Sale Recap Report
			String Expeccted_Qty=excel.getData("Last month", 2, 1).toString();
			double Expected_Quantity=Double.parseDouble(Expeccted_Qty);
			
			
			
			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[4]/span")).getText().replace(",", "");
			double ActualQuantity=Double.parseDouble(Qty);
			
			//Export Qunatity value to Excel
			excel.setreportData("Last month", 2, 10, Qty);
			
			
			//Check whether the Quantity value is Equal or not
			if(Expected_Quantity==ActualQuantity)
			{
				test.log(LogStatus.PASS, "Quantity for Modifier Sale Report is equal to Sale Recap Report for Last month");
			}
			else
			{
				double diff=Expected_Quantity-ActualQuantity;
				test.log(LogStatus.FAIL, "Quantity for Modifier Sale Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last month", 3, 1).toString();
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[5]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last month", 3, 10, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Modifier Sale Report is equal to Sale Recap Report for Last month");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Modifier Sale Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Last_30_Days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheCat(driver);
		
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
			test.log(LogStatus.INFO, "Sale Report Not Available for Last 30 days");
			excel.setreportData("Last 30 days", 1, 10, st);
			excel.setreportData("Last 30 days", 2, 10, st);
			excel.setreportData("Last 30 days", 3, 10, st);
			excel.setreportData("Last 30 days", 4, 10, st);
			excel.setreportData("Last 30 days", 5, 10, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report Available for Last 30 days");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();
			
			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();
			
			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last 30 days", 1, 1).toString();
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[3]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Last 30 days", 1, 10, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Modifier Sale Report is equal to Sale Recap Report for Last 30 days");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Modifier Sale Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
			}
			
			//Get the Quantity from Sale Recap Report
			String Expeccted_Qty=excel.getData("Last 30 days", 2, 1).toString();
			double Expected_Quantity=Double.parseDouble(Expeccted_Qty);
			
			
			
			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[4]/span")).getText().replace(",", "");
			double ActualQuantity=Double.parseDouble(Qty);
			
			//Export Qunatity value to Excel
			excel.setreportData("Last 30 days", 2, 10, Qty);
			
			
			//Check whether the Quantity value is Equal or not
			if(Expected_Quantity==ActualQuantity)
			{
				test.log(LogStatus.PASS, "Quantity for Modifier Sale Report is equal to Sale Recap Report for Last 30 days");
			}
			else
			{
				double diff=Expected_Quantity-ActualQuantity;
				test.log(LogStatus.FAIL, "Quantity for Modifier Sale Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last 30 days", 3, 1).toString();
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[5]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Last 30 days", 3, 10, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Modifier Sale Report is equal to Sale Recap Report for Last 30 days");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Modifier Sale Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Specific_Date(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheCat(driver);
		
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
			test.log(LogStatus.INFO, "Sale Report Not Available for Specific Date");
			excel.setreportData("Specific Date", 1, 10, st);
			excel.setreportData("Specific Date", 2, 10, st);
			excel.setreportData("Specific Date", 3, 10, st);
			excel.setreportData("Specific Date", 4, 10, st);
			excel.setreportData("Specific Date", 5, 10, st);
			
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report Available for Specific Date");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();
			
			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();
			
			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Specific Date", 1, 1).toString();
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[3]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Specific Date", 1, 10, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Modifier Sale Report is equal to Sale Recap Report for Specific Date");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Modifier Sale Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
			}
			
			//Get the Quantity from Sale Recap Report
			String Expeccted_Qty=excel.getData("Specific Date", 2, 1).toString();
			double Expected_Quantity=Double.parseDouble(Expeccted_Qty);
			
			
			
			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[4]/span")).getText().replace(",", "");
			double ActualQuantity=Double.parseDouble(Qty);
			
			//Export Qunatity value to Excel
			excel.setreportData("Specific Date", 2, 10, Qty);
			
			
			//Check whether the Quantity value is Equal or not
			if(Expected_Quantity==ActualQuantity)
			{
				test.log(LogStatus.PASS, "Quantity for Modifier Sale Report is equal to Sale Recap Report for Specific Date");
			}
			else
			{
				double diff=Expected_Quantity-ActualQuantity;
				test.log(LogStatus.FAIL, "Quantity for Modifier Sale Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Specific Date", 3, 1).toString();
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[5]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Specific Date", 3, 10, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Modifier Sale Report is equal to Sale Recap Report for Specific Date");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Modifier Sale Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Date_Range(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheCat(driver);
		
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
			test.log(LogStatus.INFO, "Sale Report Not Available for Date Range");
			System.out.println("Sale Report Not Available for Date Range");
			excel.setreportData("Date Range", 1, 10, st);
			excel.setreportData("Date Range", 2, 10, st);
			excel.setreportData("Date Range", 3, 10, st);
			excel.setreportData("Date Range", 4, 10, st);
			excel.setreportData("Date Range", 5, 10, st);
			
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Sale Report Available for Date Range");
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			Thread.sleep(2000);
			//Verify Donut Chart screen
			//repts.Verify_Donut_Chart_Screen_TopSales();
			
			//Verify Bars Chart Screen
			//repts.Verify_Bars_Chart_Screen_TopSales();
			
			//Verify Sales By Hours
			//repts.Verify_Sales_byHours_Chart_Screen();
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Date Range", 1, 1).toString();
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[3]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Date Range", 1, 10, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Modifier Sale Report is equal to Sale Recap Report for Date Range");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Modifier Sale Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
			}
			
			//Get the Quantity from Sale Recap Report
			String Expeccted_Qty=excel.getData("Date Range", 2, 1).toString();
			double Expected_Quantity=Double.parseDouble(Expeccted_Qty);
			
			
			
			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[4]/span")).getText().replace(",", "");
			double ActualQuantity=Double.parseDouble(Qty);
			
			//Export Qunatity value to Excel
			excel.setreportData("Date Range", 2, 10, Qty);
			
			
			//Check whether the Quantity value is Equal or not
			if(Expected_Quantity==ActualQuantity)
			{
				test.log(LogStatus.PASS, "Quantity for Modifier Sale Report is equal to Sale Recap Report for Date Range");
			}
			else
			{
				double diff=Expected_Quantity-ActualQuantity;
				test.log(LogStatus.FAIL, "Quantity for Modifier Sale Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Date Range", 3, 1).toString();
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			
			//Get the Tax
			String Tx=driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[5]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Date Range", 3, 10, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Modifier Sale Report is equal to Sale Recap Report for Date Range");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Modifier Sale Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
			}
			
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	

}
