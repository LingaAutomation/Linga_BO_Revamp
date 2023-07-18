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

public class Reports_Modifier_Sale_Report 
{

public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Modifier Sale Report");
	
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
	public void Open_Modifier_Report_Page(WebDriver driver) throws Exception
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
	public void RefreshAndPaginination(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
	}
	
	@Test(priority = 4,enabled = false)
	public void SelectTheCat(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);	
		//Click the Modifier label
		driver.findElement(By.xpath("//span[contains(.,'Modifier')]/../input")).click();
		Thread.sleep(500);	
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
	}
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Today(WebDriver driver) throws Exception
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
			excel.setreportData("Today", 2, 10, st);
			excel.setreportData("Today", 3, 10, st);
			excel.setreportData("Today", 4, 10, st);
			excel.setreportData("Today", 5, 10, st);
			excel.setreportData("Today", 6, 10, st);
			excel.setreportData("Today", 7, 10, st);
			excel.setreportData("Today", 8, 10, st);
			excel.setreportData("Today", 9, 10, st);
			excel.setreportData("Today", 10, 10, st);
			excel.setreportData("Today", 11, 10, st);
			excel.setreportData("Today", 12, 10, st);
			excel.setreportData("Today", 13, 10, st);

			excel.setreportData("Today", 2, 11, st);
			excel.setreportData("Today", 3, 11, st);
			excel.setreportData("Today", 4, 11, st);
			excel.setreportData("Today", 5, 11, st);
			excel.setreportData("Today", 6, 11, st);
			excel.setreportData("Today", 7, 11, st);
			excel.setreportData("Today", 8, 11, st);
			excel.setreportData("Today", 9, 11, st);
			excel.setreportData("Today", 10, 11, st);
			excel.setreportData("Today", 11, 11, st);
			excel.setreportData("Today", 12, 11, st);
			excel.setreportData("Today", 13, 11, st);

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
			
			
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			/*
			 * String Expeccted_SaleAmt=excel.getData("Today", 2,
			 * 1).toString().replaceAll(",", ""); double
			 * Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			 */
			
			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[3]/span")).getText().replace(",", "");
			//double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Today", 2, 10, SaleAmount);
			test.log(LogStatus.INFO,"Sale Amount for Modifier Sale Report is displayed for Today and the value is : "+SaleAmount);
			//excel.setreport_PassedData("Today", 21, 6, SaleAmount+"`");
			//excel.setreport_PassedData("Today", 21, 6, SaleAmount+"`");
			
			/*
			 * //Check whether the Sale Amount value is Equal or not
			 * if(Expected_SaleAmount==ActualSale_Amount) { test.log(LogStatus.PASS,
			 * "Sale Amount for Modifier Sale Report is equal to Sale Recap Report for Today"
			 * ); excel.setreport_PassedData("Today", 2, 11, "0.00");
			 * excel.setreport_PassedData("Today", 21, 6, SaleAmount+"`"); } else { double
			 * diff=Expected_SaleAmount-ActualSale_Amount; test.log(LogStatus.FAIL,
			 * "Sale Amount for Modifier Sale Report is not equal to Sale Recap Report for Today.The value diff is : "
			 * +diff); String diff_value=String.valueOf(diff); //Export the Sale Amount
			 * value to Excel excel.setreport_FailedData("Today", 2, 11,diff_value);
			 * excel.setreport_FailedData("Today", 21, 6,diff_value); }
			 * 
			 * //Get the Quantity from Sale Recap Report String
			 * Expeccted_Qty=excel.getData("Today", 3, 1).replaceAll(",", ""); double
			 * Expected_Quantity=Double.parseDouble(Expeccted_Qty);
			 */
		
			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[4]/span")).getText().replace(",", "");
			test.log(LogStatus.INFO,"Quantity for Modifier Sale Report is displayed for Today and the value is : "+Qty);
			//double ActualQuantity=Double.parseDouble(Qty);
			
			//Export Qunatity value to Excel
			//excel.setreportData("Today", 3, 10, Qty);excel.setreport_PassedData("Today", 22, 6, Qty+"`");
			//excel.setreport_PassedData("Today", 22, 6, Qty+"`");
			
			/*
			 * //Check whether the Quantity value is Equal or not
			 * if(Expected_Quantity==ActualQuantity) { test.log(LogStatus.PASS,
			 * "Quantity for Modifier Sale Report is equal to Sale Recap Report for Today");
			 * excel.setreport_PassedData("Today", 3, 11, "0");
			 * excel.setreport_PassedData("Today", 22, 6, Qty+"`"); } else { double
			 * diff=Expected_Quantity-ActualQuantity; test.log(LogStatus.FAIL,
			 * "Quantity for Modifier Sale Report is not equal to Sale Recap Report for Today.The value diff is : "
			 * +diff); String diff_value=String.valueOf(diff); //Export the Sale Amount
			 * value to Excel excel.setreport_FailedData("Today", 3, 11,diff_value);
			 * excel.setreport_FailedData("Today", 22, 6,diff_value); }
			 * 
			 * //Get the Tax from Sale Recap Report String
			 * Expeccted_Tx=excel.getData("Today", 4, 1).replaceAll(",", ""); double
			 * Expected_Tax=Double.parseDouble(Expeccted_Tx);
			 */
			
			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			//double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Today", 3, 10, Tx);
			test.log(LogStatus.INFO,"Tax for Modifier Sale Report is displayed for Today and the value is : "+Tx);
			//excel.setreport_PassedData("Today", 23, 6, Tx+"`");
			//excel.setreport_PassedData("Today", 23, 6, Tx+"`");

			/*
			 * //Check whether the Tax value is Equal or not if(Expected_Tax==ActualTax) {
			 * test.log(LogStatus.PASS,
			 * "Tax for Modifier Sale Report is equal to Sale Recap Report for Today");
			 * excel.setreport_PassedData("Today", 4, 11, "0.00");
			 * excel.setreport_PassedData("Today", 23, 6, Tx+"`"); } else { double
			 * diff=Expected_Tax-ActualTax; test.log(LogStatus.FAIL,
			 * "Tax for Modifier Sale Report is not equal to Sale Recap Report for Today.The value diff is : "
			 * +diff); String diff_value=String.valueOf(diff); //Export the Sale Amount
			 * value to Excel excel.setreport_FailedData("Today", 4, 11,diff_value);
			 * excel.setreport_FailedData("Today", 23, 6,diff_value); }
			 */
						
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Yesterday(WebDriver driver) throws Exception
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
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Yesterday");
			excel.setreportData("Yesterday", 2, 10, st);
			excel.setreportData("Yesterday", 3, 10, st);
			excel.setreportData("Yesterday", 4, 10, st);
			excel.setreportData("Yesterday", 5, 10, st);
			excel.setreportData("Yesterday", 6, 10, st);
			excel.setreportData("Yesterday", 7, 10, st);
			excel.setreportData("Yesterday", 8, 10, st);
			excel.setreportData("Yesterday", 9, 10, st);
			excel.setreportData("Yesterday", 10, 10, st);
			excel.setreportData("Yesterday", 11, 10, st);
			excel.setreportData("Yesterday", 12, 10, st);
			excel.setreportData("Yesterday", 13, 10, st);

			excel.setreportData("Yesterday", 2, 11, st);
			excel.setreportData("Yesterday", 3, 11, st);
			excel.setreportData("Yesterday", 4, 11, st);
			excel.setreportData("Yesterday", 5, 11, st);
			excel.setreportData("Yesterday", 6, 11, st);
			excel.setreportData("Yesterday", 7, 11, st);
			excel.setreportData("Yesterday", 8, 11, st);
			excel.setreportData("Yesterday", 9, 11, st);
			excel.setreportData("Yesterday", 10, 11, st);
			excel.setreportData("Yesterday", 11, 11, st);
			excel.setreportData("Yesterday", 12, 11, st);
			excel.setreportData("Yesterday", 13, 11, st);

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

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[3]/span")).getText().replace(",", "");

			//Export the Sale Amount value to Excel
			excel.setreportData("Yesterday", 2, 10, SaleAmount);
			test.log(LogStatus.INFO,"Sale Amount for Modifier Sale Report is displayed for Yesterday and the value is : "+SaleAmount);

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[4]/span")).getText().replace(",", "");
			test.log(LogStatus.INFO,"Quantity for Modifier Sale Report is displayed for Yesterday and the value is : "+Qty);
			//double ActualQuantity=Double.parseDouble(Qty);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			//double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Yesterday", 3, 10, Tx);
			test.log(LogStatus.INFO,"Tax for Modifier Sale Report is displayed for Yesterday and the value is : "+Tx);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Last_N_Days(WebDriver driver) throws Exception
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
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Last N days");
			excel.setreportData("Last N days", 2, 10, st);
			excel.setreportData("Last N days", 3, 10, st);
			excel.setreportData("Last N days", 4, 10, st);
			excel.setreportData("Last N days", 5, 10, st);
			excel.setreportData("Last N days", 6, 10, st);
			excel.setreportData("Last N days", 7, 10, st);
			excel.setreportData("Last N days", 8, 10, st);
			excel.setreportData("Last N days", 9, 10, st);
			excel.setreportData("Last N days", 10, 10, st);
			excel.setreportData("Last N days", 11, 10, st);
			excel.setreportData("Last N days", 12, 10, st);
			excel.setreportData("Last N days", 13, 10, st);

			excel.setreportData("Last N days", 2, 11, st);
			excel.setreportData("Last N days", 3, 11, st);
			excel.setreportData("Last N days", 4, 11, st);
			excel.setreportData("Last N days", 5, 11, st);
			excel.setreportData("Last N days", 6, 11, st);
			excel.setreportData("Last N days", 7, 11, st);
			excel.setreportData("Last N days", 8, 11, st);
			excel.setreportData("Last N days", 9, 11, st);
			excel.setreportData("Last N days", 10, 11, st);
			excel.setreportData("Last N days", 11, 11, st);
			excel.setreportData("Last N days", 12, 11, st);
			excel.setreportData("Last N days", 13, 11, st);

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

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[3]/span")).getText().replace(",", "");

			//Export the Sale Amount value to Excel
			excel.setreportData("Last N days", 2, 10, SaleAmount);
			test.log(LogStatus.INFO,"Sale Amount for Modifier Sale Report is displayed for Last N days and the value is : "+SaleAmount);

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[4]/span")).getText().replace(",", "");
			test.log(LogStatus.INFO,"Quantity for Modifier Sale Report is displayed for Last N days and the value is : "+Qty);
			//double ActualQuantity=Double.parseDouble(Qty);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			//double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last N days", 3, 10, Tx);
			test.log(LogStatus.INFO,"Tax for Modifier Sale Report is displayed for Last N days and the value is : "+Tx);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void Modifier_Report_This_Week(WebDriver driver) throws Exception
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
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for This Week");
			excel.setreportData("This Week", 2, 10, st);
			excel.setreportData("This Week", 3, 10, st);
			excel.setreportData("This Week", 4, 10, st);
			excel.setreportData("This Week", 5, 10, st);
			excel.setreportData("This Week", 6, 10, st);
			excel.setreportData("This Week", 7, 10, st);
			excel.setreportData("This Week", 8, 10, st);
			excel.setreportData("This Week", 9, 10, st);
			excel.setreportData("This Week", 10, 10, st);
			excel.setreportData("This Week", 11, 10, st);
			excel.setreportData("This Week", 12, 10, st);
			excel.setreportData("This Week", 13, 10, st);

			excel.setreportData("This Week", 2, 11, st);
			excel.setreportData("This Week", 3, 11, st);
			excel.setreportData("This Week", 4, 11, st);
			excel.setreportData("This Week", 5, 11, st);
			excel.setreportData("This Week", 6, 11, st);
			excel.setreportData("This Week", 7, 11, st);
			excel.setreportData("This Week", 8, 11, st);
			excel.setreportData("This Week", 9, 11, st);
			excel.setreportData("This Week", 10, 11, st);
			excel.setreportData("This Week", 11, 11, st);
			excel.setreportData("This Week", 12, 11, st);
			excel.setreportData("This Week", 13, 11, st);

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

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[3]/span")).getText().replace(",", "");

			//Export the Sale Amount value to Excel
			excel.setreportData("This Week", 2, 10, SaleAmount);
			test.log(LogStatus.INFO,"Sale Amount for Modifier Sale Report is displayed for This Week and the value is : "+SaleAmount);

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[4]/span")).getText().replace(",", "");
			test.log(LogStatus.INFO,"Quantity for Modifier Sale Report is displayed for This Week and the value is : "+Qty);
			//double ActualQuantity=Double.parseDouble(Qty);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			//double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("This Week", 3, 10, Tx);
			test.log(LogStatus.INFO,"Tax for Modifier Sale Report is displayed for This Week and the value is : "+Tx);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Last_Week(WebDriver driver) throws Exception
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
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Last Week");
			excel.setreportData("Last Week", 2, 10, st);
			excel.setreportData("Last Week", 3, 10, st);
			excel.setreportData("Last Week", 4, 10, st);
			excel.setreportData("Last Week", 5, 10, st);
			excel.setreportData("Last Week", 6, 10, st);
			excel.setreportData("Last Week", 7, 10, st);
			excel.setreportData("Last Week", 8, 10, st);
			excel.setreportData("Last Week", 9, 10, st);
			excel.setreportData("Last Week", 10, 10, st);
			excel.setreportData("Last Week", 11, 10, st);
			excel.setreportData("Last Week", 12, 10, st);
			excel.setreportData("Last Week", 13, 10, st);

			excel.setreportData("Last Week", 2, 11, st);
			excel.setreportData("Last Week", 3, 11, st);
			excel.setreportData("Last Week", 4, 11, st);
			excel.setreportData("Last Week", 5, 11, st);
			excel.setreportData("Last Week", 6, 11, st);
			excel.setreportData("Last Week", 7, 11, st);
			excel.setreportData("Last Week", 8, 11, st);
			excel.setreportData("Last Week", 9, 11, st);
			excel.setreportData("Last Week", 10, 11, st);
			excel.setreportData("Last Week", 11, 11, st);
			excel.setreportData("Last Week", 12, 11, st);
			excel.setreportData("Last Week", 13, 11, st);

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

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[3]/span")).getText().replace(",", "");

			//Export the Sale Amount value to Excel
			excel.setreportData("Last Week", 2, 10, SaleAmount);
			test.log(LogStatus.INFO,"Sale Amount for Modifier Sale Report is displayed for Last Week and the value is : "+SaleAmount);

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[4]/span")).getText().replace(",", "");
			test.log(LogStatus.INFO,"Quantity for Modifier Sale Report is displayed for Last Week and the value is : "+Qty);
			//double ActualQuantity=Double.parseDouble(Qty);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			//double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last Week", 3, 10, Tx);
			test.log(LogStatus.INFO,"Tax for Modifier Sale Report is displayed for Last Week and the value is : "+Tx);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Last_7_Days(WebDriver driver) throws Exception
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
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Last 7 days");
			excel.setreportData("Last 7 days", 2, 10, st);
			excel.setreportData("Last 7 days", 3, 10, st);
			excel.setreportData("Last 7 days", 4, 10, st);
			excel.setreportData("Last 7 days", 5, 10, st);
			excel.setreportData("Last 7 days", 6, 10, st);
			excel.setreportData("Last 7 days", 7, 10, st);
			excel.setreportData("Last 7 days", 8, 10, st);
			excel.setreportData("Last 7 days", 9, 10, st);
			excel.setreportData("Last 7 days", 10, 10, st);
			excel.setreportData("Last 7 days", 11, 10, st);
			excel.setreportData("Last 7 days", 12, 10, st);
			excel.setreportData("Last 7 days", 13, 10, st);

			excel.setreportData("Last 7 days", 2, 11, st);
			excel.setreportData("Last 7 days", 3, 11, st);
			excel.setreportData("Last 7 days", 4, 11, st);
			excel.setreportData("Last 7 days", 5, 11, st);
			excel.setreportData("Last 7 days", 6, 11, st);
			excel.setreportData("Last 7 days", 7, 11, st);
			excel.setreportData("Last 7 days", 8, 11, st);
			excel.setreportData("Last 7 days", 9, 11, st);
			excel.setreportData("Last 7 days", 10, 11, st);
			excel.setreportData("Last 7 days", 11, 11, st);
			excel.setreportData("Last 7 days", 12, 11, st);
			excel.setreportData("Last 7 days", 13, 11, st);

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

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[3]/span")).getText().replace(",", "");

			//Export the Sale Amount value to Excel
			excel.setreportData("Last 7 days", 2, 10, SaleAmount);
			test.log(LogStatus.INFO,"Sale Amount for Modifier Sale Report is displayed for Last 7 days and the value is : "+SaleAmount);

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[4]/span")).getText().replace(",", "");
			test.log(LogStatus.INFO,"Quantity for Modifier Sale Report is displayed for Last 7 days and the value is : "+Qty);
			//double ActualQuantity=Double.parseDouble(Qty);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			//double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last 7 days", 3, 10, Tx);
			test.log(LogStatus.INFO,"Tax for Modifier Sale Report is displayed for Last 7 days and the value is : "+Tx);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_This_Month(WebDriver driver) throws Exception
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
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for This month");
			excel.setreportData("This month", 2, 10, st);
			excel.setreportData("This month", 3, 10, st);
			excel.setreportData("This month", 4, 10, st);
			excel.setreportData("This month", 5, 10, st);
			excel.setreportData("This month", 6, 10, st);
			excel.setreportData("This month", 7, 10, st);
			excel.setreportData("This month", 8, 10, st);
			excel.setreportData("This month", 9, 10, st);
			excel.setreportData("This month", 10, 10, st);
			excel.setreportData("This month", 11, 10, st);
			excel.setreportData("This month", 12, 10, st);
			excel.setreportData("This month", 13, 10, st);

			excel.setreportData("This month", 2, 11, st);
			excel.setreportData("This month", 3, 11, st);
			excel.setreportData("This month", 4, 11, st);
			excel.setreportData("This month", 5, 11, st);
			excel.setreportData("This month", 6, 11, st);
			excel.setreportData("This month", 7, 11, st);
			excel.setreportData("This month", 8, 11, st);
			excel.setreportData("This month", 9, 11, st);
			excel.setreportData("This month", 10, 11, st);
			excel.setreportData("This month", 11, 11, st);
			excel.setreportData("This month", 12, 11, st);
			excel.setreportData("This month", 13, 11, st);

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

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[3]/span")).getText().replace(",", "");

			//Export the Sale Amount value to Excel
			excel.setreportData("This month", 2, 10, SaleAmount);
			test.log(LogStatus.INFO,"Sale Amount for Modifier Sale Report is displayed for This month and the value is : "+SaleAmount);

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[4]/span")).getText().replace(",", "");
			test.log(LogStatus.INFO,"Quantity for Modifier Sale Report is displayed for This month and the value is : "+Qty);
			//double ActualQuantity=Double.parseDouble(Qty);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			//double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("This month", 3, 10, Tx);
			test.log(LogStatus.INFO,"Tax for Modifier Sale Report is displayed for This month and the value is : "+Tx);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Last_Month(WebDriver driver) throws Exception
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
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Last month");
			excel.setreportData("Last month", 2, 10, st);
			excel.setreportData("Last month", 3, 10, st);
			excel.setreportData("Last month", 4, 10, st);
			excel.setreportData("Last month", 5, 10, st);
			excel.setreportData("Last month", 6, 10, st);
			excel.setreportData("Last month", 7, 10, st);
			excel.setreportData("Last month", 8, 10, st);
			excel.setreportData("Last month", 9, 10, st);
			excel.setreportData("Last month", 10, 10, st);
			excel.setreportData("Last month", 11, 10, st);
			excel.setreportData("Last month", 12, 10, st);
			excel.setreportData("Last month", 13, 10, st);

			excel.setreportData("Last month", 2, 11, st);
			excel.setreportData("Last month", 3, 11, st);
			excel.setreportData("Last month", 4, 11, st);
			excel.setreportData("Last month", 5, 11, st);
			excel.setreportData("Last month", 6, 11, st);
			excel.setreportData("Last month", 7, 11, st);
			excel.setreportData("Last month", 8, 11, st);
			excel.setreportData("Last month", 9, 11, st);
			excel.setreportData("Last month", 10, 11, st);
			excel.setreportData("Last month", 11, 11, st);
			excel.setreportData("Last month", 12, 11, st);
			excel.setreportData("Last month", 13, 11, st);

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

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[3]/span")).getText().replace(",", "");

			//Export the Sale Amount value to Excel
			excel.setreportData("Last month", 2, 10, SaleAmount);
			test.log(LogStatus.INFO,"Sale Amount for Modifier Sale Report is displayed for Last month and the value is : "+SaleAmount);

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[4]/span")).getText().replace(",", "");
			test.log(LogStatus.INFO,"Quantity for Modifier Sale Report is displayed for Last month and the value is : "+Qty);
			//double ActualQuantity=Double.parseDouble(Qty);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			//double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last month", 3, 10, Tx);
			test.log(LogStatus.INFO,"Tax for Modifier Sale Report is displayed for Last month and the value is : "+Tx);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Last_30_Days(WebDriver driver) throws Exception
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
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Last 30 days");
			excel.setreportData("Last 30 days", 2, 10, st);
			excel.setreportData("Last 30 days", 3, 10, st);
			excel.setreportData("Last 30 days", 4, 10, st);
			excel.setreportData("Last 30 days", 5, 10, st);
			excel.setreportData("Last 30 days", 6, 10, st);
			excel.setreportData("Last 30 days", 7, 10, st);
			excel.setreportData("Last 30 days", 8, 10, st);
			excel.setreportData("Last 30 days", 9, 10, st);
			excel.setreportData("Last 30 days", 10, 10, st);
			excel.setreportData("Last 30 days", 11, 10, st);
			excel.setreportData("Last 30 days", 12, 10, st);
			excel.setreportData("Last 30 days", 13, 10, st);

			excel.setreportData("Last 30 days", 2, 11, st);
			excel.setreportData("Last 30 days", 3, 11, st);
			excel.setreportData("Last 30 days", 4, 11, st);
			excel.setreportData("Last 30 days", 5, 11, st);
			excel.setreportData("Last 30 days", 6, 11, st);
			excel.setreportData("Last 30 days", 7, 11, st);
			excel.setreportData("Last 30 days", 8, 11, st);
			excel.setreportData("Last 30 days", 9, 11, st);
			excel.setreportData("Last 30 days", 10, 11, st);
			excel.setreportData("Last 30 days", 11, 11, st);
			excel.setreportData("Last 30 days", 12, 11, st);
			excel.setreportData("Last 30 days", 13, 11, st);

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

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[3]/span")).getText().replace(",", "");

			//Export the Sale Amount value to Excel
			excel.setreportData("Last 30 days", 2, 10, SaleAmount);
			test.log(LogStatus.INFO,"Sale Amount for Modifier Sale Report is displayed for Last 30 days and the value is : "+SaleAmount);

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[4]/span")).getText().replace(",", "");
			test.log(LogStatus.INFO,"Quantity for Modifier Sale Report is displayed for Last 30 days and the value is : "+Qty);
			//double ActualQuantity=Double.parseDouble(Qty);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			//double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last 30 days", 3, 10, Tx);
			test.log(LogStatus.INFO,"Tax for Modifier Sale Report is displayed for Last 30 days and the value is : "+Tx);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Specific_Date(WebDriver driver) throws Exception
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
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Specific Date");
			excel.setreportData("Specific Date", 2, 10, st);
			excel.setreportData("Specific Date", 3, 10, st);
			excel.setreportData("Specific Date", 4, 10, st);
			excel.setreportData("Specific Date", 5, 10, st);
			excel.setreportData("Specific Date", 6, 10, st);
			excel.setreportData("Specific Date", 7, 10, st);
			excel.setreportData("Specific Date", 8, 10, st);
			excel.setreportData("Specific Date", 9, 10, st);
			excel.setreportData("Specific Date", 10, 10, st);
			excel.setreportData("Specific Date", 11, 10, st);
			excel.setreportData("Specific Date", 12, 10, st);
			excel.setreportData("Specific Date", 13, 10, st);

			excel.setreportData("Specific Date", 2, 11, st);
			excel.setreportData("Specific Date", 3, 11, st);
			excel.setreportData("Specific Date", 4, 11, st);
			excel.setreportData("Specific Date", 5, 11, st);
			excel.setreportData("Specific Date", 6, 11, st);
			excel.setreportData("Specific Date", 7, 11, st);
			excel.setreportData("Specific Date", 8, 11, st);
			excel.setreportData("Specific Date", 9, 11, st);
			excel.setreportData("Specific Date", 10, 11, st);
			excel.setreportData("Specific Date", 11, 11, st);
			excel.setreportData("Specific Date", 12, 11, st);
			excel.setreportData("Specific Date", 13, 11, st);

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

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[3]/span")).getText().replace(",", "");

			//Export the Sale Amount value to Excel
			excel.setreportData("Specific Date", 2, 10, SaleAmount);
			test.log(LogStatus.INFO,"Sale Amount for Modifier Sale Report is displayed for Specific Date and the value is : "+SaleAmount);

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[4]/span")).getText().replace(",", "");
			test.log(LogStatus.INFO,"Quantity for Modifier Sale Report is displayed for Specific Date and the value is : "+Qty);
			//double ActualQuantity=Double.parseDouble(Qty);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			//double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Specific Date", 3, 10, Tx);
			test.log(LogStatus.INFO,"Tax for Modifier Sale Report is displayed for Specific Date and the value is : "+Tx);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Modifier_Report_Date_Range(WebDriver driver) throws Exception
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
		if(repts.No_TransactionFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Date Range");
			excel.setreportData("Date Range", 2, 10, st);
			excel.setreportData("Date Range", 3, 10, st);
			excel.setreportData("Date Range", 4, 10, st);
			excel.setreportData("Date Range", 5, 10, st);
			excel.setreportData("Date Range", 6, 10, st);
			excel.setreportData("Date Range", 7, 10, st);
			excel.setreportData("Date Range", 8, 10, st);
			excel.setreportData("Date Range", 9, 10, st);
			excel.setreportData("Date Range", 10, 10, st);
			excel.setreportData("Date Range", 11, 10, st);
			excel.setreportData("Date Range", 12, 10, st);
			excel.setreportData("Date Range", 13, 10, st);

			excel.setreportData("Date Range", 2, 11, st);
			excel.setreportData("Date Range", 3, 11, st);
			excel.setreportData("Date Range", 4, 11, st);
			excel.setreportData("Date Range", 5, 11, st);
			excel.setreportData("Date Range", 6, 11, st);
			excel.setreportData("Date Range", 7, 11, st);
			excel.setreportData("Date Range", 8, 11, st);
			excel.setreportData("Date Range", 9, 11, st);
			excel.setreportData("Date Range", 10, 11, st);
			excel.setreportData("Date Range", 11, 11, st);
			excel.setreportData("Date Range", 12, 11, st);
			excel.setreportData("Date Range", 13, 11, st);

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

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[3]/span")).getText().replace(",", "");

			//Export the Sale Amount value to Excel
			excel.setreportData("Date Range", 2, 10, SaleAmount);
			test.log(LogStatus.INFO,"Sale Amount for Modifier Sale Report is displayed for Date Range and the value is : "+SaleAmount);

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[4]/span")).getText().replace(",", "");
			test.log(LogStatus.INFO,"Quantity for Modifier Sale Report is displayed for Date Range and the value is : "+Qty);
			//double ActualQuantity=Double.parseDouble(Qty);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			//double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Date Range", 3, 10, Tx);
			test.log(LogStatus.INFO,"Tax for Modifier Sale Report is displayed for Date Range and the value is : "+Tx);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}
}
