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

public class Reports_Sale_Summary_Report 
{
	//WebDriverManager.chromeDriver().setup();
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Sale Summary Report");
	
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
		//WebDriverManager.chromedriver().setup();
		//Open the Chrome window
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
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
		Open_SaleSummary_Report_Page(driver);
//		RefreshAndPaginination(driver);
		SaleSummary_Report_Today(driver);
		SaleSummary_Report_Yesterday(driver);
		SaleSummary_Report_Last_N_Days(driver);
		SaleSummary_Report_This_Week(driver);
		SaleSummary_Report_Last_Week(driver);
		SaleSummary_Report_Last_7_Days(driver);
		SaleSummary_Report_This_Month(driver);
		SaleSummary_Report_Last_Month(driver);
		SaleSummary_Report_Last_30_Days(driver);
		SaleSummary_Report_Specific_Date(driver);
		SaleSummary_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_SaleSummary_Report_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Sale Summarys report page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"salesReports/saleSummary");

		Thread.sleep(5000);
		//Verify the Sale Summarys report page loeded or not
		repts.Verify_ReportHomePage("SALE SUMMARY");
		
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
		//Un check the Split by Serving Level
		try {
			if(driver.findElement(By.xpath("//span[contains(.,'Group By Employee')]/../../../mat-checkbox[contains(@class,'mat-checkbox-checked')]")).isDisplayed()) {
				//Click the checked box
				driver.findElement(By.xpath("//span[contains(.,'Group By Employee')]/../../../mat-checkbox[contains(@class,'mat-checkbox-checked')]")).click();
			}
		}catch(Exception d) {
			
		}
		
		Thread.sleep(5000);	
		//Click the employee label
		driver.findElement(By.xpath("//span[contains(.,'Employee')]/../input")).click();
		Thread.sleep(500);	
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
				
		Thread.sleep(500);
		//Click the service type label
		driver.findElement(By.xpath("//span[contains(.,'Service Type')]/../input")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
		Thread.sleep(500);
		//Click the Floor no label
		driver.findElement(By.xpath("//span[contains(.,'Floor No')]/../input")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
		Thread.sleep(500);
		//Click the table no label
		driver.findElement(By.xpath("//span[contains(.,'Table No')]/../input")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
	}
	
	@Test(priority = 4,enabled = false)
	public void SaleSummary_Report_Today(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		//SelectTheCat(driver);
		
		//Select Today
		//repts.Select_Last_N_Days_TimePeriod("10");
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Today");
			excel.setreportData("Today", 2, 20, st);
			excel.setreportData("Today", 3, 20, st);
			excel.setreportData("Today", 4, 20, st);
			excel.setreportData("Today", 5, 20, st);
			excel.setreportData("Today", 6, 20, st);
			excel.setreportData("Today", 7, 20, st);
			excel.setreportData("Today", 8, 20, st);
			excel.setreportData("Today", 9, 20, st);
			
			excel.setreportData("Today", 2, 21, st);
			excel.setreportData("Today", 3, 21, st);
			excel.setreportData("Today", 4, 21, st);
			excel.setreportData("Today", 5, 21, st);
			excel.setreportData("Today", 6, 21, st);
			excel.setreportData("Today", 7, 21, st);
			excel.setreportData("Today", 8, 21, st);
			excel.setreportData("Today", 9, 21, st);
			
			excel.setreportData("Today", 21, 11, st);
			excel.setreportData("Today", 22, 11, st);
			excel.setreportData("Today", 23, 11, st);
			excel.setreportData("Today", 24, 11, st);
			excel.setreportData("Today", 25, 11, st);
			excel.setreportData("Today", 26, 11, st);
			excel.setreportData("Today", 27, 11, st);
			excel.setreportData("Today", 28, 11, st);
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
			String Expeccted_SaleAmt=excel.getData("Today", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[6])[2]")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Today", 2, 20, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Sale Summary Report is equal to Sale Recap Report for Today");
				excel.setreport_PassedData("Today", 2, 21, "0.00");
				excel.setreport_PassedData("Today", 21, 11, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Sale Summary Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Today", 2, 21,diff_value);
				 excel.setreport_FailedData("Today", 21, 11,diff_value);
			}
			
			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Today", 4, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			//Get the Tax
			String Tx=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[7])[2]")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Today", 4, 20, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Sale Summary Report is equal to Sale Recap Report for Today");
				excel.setreport_PassedData("Today", 4, 21, "0.00");
				excel.setreport_PassedData("Today", 23, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Sale Summary Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Today", 4, 21,diff_value);
				 excel.setreport_FailedData("Today", 23, 11,diff_value);
			}
			
			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Today", 5, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);
			
			//Get the Discount
			String Discnt=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[10])[2]")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Today", 5, 20, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Sale Summary Report is equal to Sale Recap Report for Today");
				excel.setreport_PassedData("Today", 5, 21, "0.00");
				excel.setreport_PassedData("Today", 24, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Sale Summary Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Today", 5, 21,diff_value);
				 excel.setreport_FailedData("Today", 24, 11,diff_value);
			}
			
			//Get the Gross Sale from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("Today", 9, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);
		
			
			//Get the Gross Sale
			String GrossSale=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[11])[2]")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);
			
			//Export the % Percentage of Sale value to Excel
			excel.setreportData("Today", 9, 20, GrossSale);

			
			//Check whether the % of Sale value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "% of Sale for Sale Summary Report is equal to Sale Recap Report for Today");
				excel.setreport_PassedData("Today", 9, 21, "0.00");
				excel.setreport_PassedData("Today", 28, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "% of Sale for Sale Summary Report is not equal to Sale Recap Report  for Today.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Today", 9, 21,diff_value);
				 excel.setreport_FailedData("Today", 28, 11,diff_value);
			}
			
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
			
			Thread.sleep(3000);

		}
	}


	@Test(priority = 4,enabled = false)
	public void SaleSummary_Report_Yesterday(WebDriver driver) throws Exception
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
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Yesterday");
			excel.setreportData("Yesterday", 2, 20, st);
			excel.setreportData("Yesterday", 3, 20, st);
			excel.setreportData("Yesterday", 4, 20, st);
			excel.setreportData("Yesterday", 5, 20, st);
			excel.setreportData("Yesterday", 6, 20, st);
			excel.setreportData("Yesterday", 7, 20, st);
			excel.setreportData("Yesterday", 8, 20, st);
			excel.setreportData("Yesterday", 9, 20, st);

			excel.setreportData("Yesterday", 2, 21, st);
			excel.setreportData("Yesterday", 3, 21, st);
			excel.setreportData("Yesterday", 4, 21, st);
			excel.setreportData("Yesterday", 5, 21, st);
			excel.setreportData("Yesterday", 6, 21, st);
			excel.setreportData("Yesterday", 7, 21, st);
			excel.setreportData("Yesterday", 8, 21, st);
			excel.setreportData("Yesterday", 9, 21, st);

			excel.setreportData("Yesterday", 21, 11, st);
			excel.setreportData("Yesterday", 22, 11, st);
			excel.setreportData("Yesterday", 23, 11, st);
			excel.setreportData("Yesterday", 24, 11, st);
			excel.setreportData("Yesterday", 25, 11, st);
			excel.setreportData("Yesterday", 26, 11, st);
			excel.setreportData("Yesterday", 27, 11, st);
			excel.setreportData("Yesterday", 28, 11, st);
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


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Yesterday", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[6])[2]")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("Yesterday", 2, 20, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Sale Summary Report is equal to Sale Recap Report for Yesterday");
				excel.setreport_PassedData("Yesterday", 2, 21, "0.00");
				excel.setreport_PassedData("Yesterday", 21, 11, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Sale Summary Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Yesterday", 2, 21,diff_value);
				 excel.setreport_FailedData("Yesterday", 21, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Yesterday", 4, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[7])[2]")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Yesterday", 4, 20, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Sale Summary Report is equal to Sale Recap Report for Yesterday");
				excel.setreport_PassedData("Yesterday", 4, 21, "0.00");
				excel.setreport_PassedData("Yesterday", 23, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Sale Summary Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Yesterday", 4, 21,diff_value);
				 excel.setreport_FailedData("Yesterday", 23, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Yesterday", 5, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[10])[2]")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Yesterday", 5, 20, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Sale Summary Report is equal to Sale Recap Report for Yesterday");
				excel.setreport_PassedData("Yesterday", 5, 21, "0.00");
				excel.setreport_PassedData("Yesterday", 24, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Sale Summary Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Yesterday", 5, 21,diff_value);
				 excel.setreport_FailedData("Yesterday", 24, 11,diff_value);
			}

			//Get the Gross Sale from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("Yesterday", 9, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sale
			String GrossSale=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[11])[2]")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("Yesterday", 9, 20, GrossSale);


			//Check whether the % of Sale value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "% of Sale for Sale Summary Report is equal to Sale Recap Report for Yesterday");
				excel.setreport_PassedData("Yesterday", 9, 21, "0.00");
				excel.setreport_PassedData("Yesterday", 28, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "% of Sale for Sale Summary Report is not equal to Sale Recap Report  for Yesterday.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Yesterday", 9, 21,diff_value);
				 excel.setreport_FailedData("Yesterday", 28, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}


	@Test(priority = 4,enabled = false)
	public void SaleSummary_Report_Last_N_Days(WebDriver driver) throws Exception
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
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Last N days");
			excel.setreportData("Last N days", 2, 20, st);
			excel.setreportData("Last N days", 3, 20, st);
			excel.setreportData("Last N days", 4, 20, st);
			excel.setreportData("Last N days", 5, 20, st);
			excel.setreportData("Last N days", 6, 20, st);
			excel.setreportData("Last N days", 7, 20, st);
			excel.setreportData("Last N days", 8, 20, st);
			excel.setreportData("Last N days", 9, 20, st);

			excel.setreportData("Last N days", 2, 21, st);
			excel.setreportData("Last N days", 3, 21, st);
			excel.setreportData("Last N days", 4, 21, st);
			excel.setreportData("Last N days", 5, 21, st);
			excel.setreportData("Last N days", 6, 21, st);
			excel.setreportData("Last N days", 7, 21, st);
			excel.setreportData("Last N days", 8, 21, st);
			excel.setreportData("Last N days", 9, 21, st);

			excel.setreportData("Last N days", 21, 11, st);
			excel.setreportData("Last N days", 22, 11, st);
			excel.setreportData("Last N days", 23, 11, st);
			excel.setreportData("Last N days", 24, 11, st);
			excel.setreportData("Last N days", 25, 11, st);
			excel.setreportData("Last N days", 26, 11, st);
			excel.setreportData("Last N days", 27, 11, st);
			excel.setreportData("Last N days", 28, 11, st);
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


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last N days", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[6])[2]")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("Last N days", 2, 20, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Sale Summary Report is equal to Sale Recap Report for Last N days");
				excel.setreport_PassedData("Last N days", 2, 21, "0.00");
				excel.setreport_PassedData("Last N days", 21, 11, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Sale Summary Report is not equal to Sale Recap Report for Last N days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last N days", 2, 21,diff_value);
				 excel.setreport_FailedData("Last N days", 21, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last N days", 4, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[7])[2]")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last N days", 4, 20, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Sale Summary Report is equal to Sale Recap Report for Last N days");
				excel.setreport_PassedData("Last N days", 4, 21, "0.00");
				excel.setreport_PassedData("Last N days", 23, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Sale Summary Report is not equal to Sale Recap Report for Last N days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last N days", 4, 21,diff_value);
				 excel.setreport_FailedData("Last N days", 23, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Last N days", 5, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[10])[2]")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Last N days", 5, 20, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Sale Summary Report is equal to Sale Recap Report for Last N days");
				excel.setreport_PassedData("Last N days", 5, 21, "0.00");
				excel.setreport_PassedData("Last N days", 24, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Sale Summary Report is not equal to Sale Recap Report for Last N days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last N days", 5, 21,diff_value);
				 excel.setreport_FailedData("Last N days", 24, 11,diff_value);
			}

			//Get the Gross Sale from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("Last N days", 9, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sale
			String GrossSale=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[11])[2]")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("Last N days", 9, 20, GrossSale);


			//Check whether the % of Sale value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "% of Sale for Sale Summary Report is equal to Sale Recap Report for Last N days");
				excel.setreport_PassedData("Last N days", 9, 21, "0.00");
				excel.setreport_PassedData("Last N days", 28, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "% of Sale for Sale Summary Report is not equal to Sale Recap Report  for Last N days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last N days", 9, 21,diff_value);
				 excel.setreport_FailedData("Last N days", 28, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void SaleSummary_Report_This_Week(WebDriver driver) throws Exception
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
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for This Week");
			excel.setreportData("This Week", 2, 20, st);
			excel.setreportData("This Week", 3, 20, st);
			excel.setreportData("This Week", 4, 20, st);
			excel.setreportData("This Week", 5, 20, st);
			excel.setreportData("This Week", 6, 20, st);
			excel.setreportData("This Week", 7, 20, st);
			excel.setreportData("This Week", 8, 20, st);
			excel.setreportData("This Week", 9, 20, st);

			excel.setreportData("This Week", 2, 21, st);
			excel.setreportData("This Week", 3, 21, st);
			excel.setreportData("This Week", 4, 21, st);
			excel.setreportData("This Week", 5, 21, st);
			excel.setreportData("This Week", 6, 21, st);
			excel.setreportData("This Week", 7, 21, st);
			excel.setreportData("This Week", 8, 21, st);
			excel.setreportData("This Week", 9, 21, st);

			excel.setreportData("This Week", 21, 11, st);
			excel.setreportData("This Week", 22, 11, st);
			excel.setreportData("This Week", 23, 11, st);
			excel.setreportData("This Week", 24, 11, st);
			excel.setreportData("This Week", 25, 11, st);
			excel.setreportData("This Week", 26, 11, st);
			excel.setreportData("This Week", 27, 11, st);
			excel.setreportData("This Week", 28, 11, st);
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


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("This Week", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[6])[2]")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("This Week", 2, 20, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Sale Summary Report is equal to Sale Recap Report for This Week");
				excel.setreport_PassedData("This Week", 2, 21, "0.00");
				excel.setreport_PassedData("This Week", 21, 11, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Sale Summary Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("This Week", 2, 21,diff_value);
				 excel.setreport_FailedData("This Week", 21, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("This Week", 4, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[7])[2]")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("This Week", 4, 20, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Sale Summary Report is equal to Sale Recap Report for This Week");
				excel.setreport_PassedData("This Week", 4, 21, "0.00");
				excel.setreport_PassedData("This Week", 23, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Sale Summary Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("This Week", 4, 21,diff_value);
				 excel.setreport_FailedData("This Week", 23, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("This Week", 5, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[10])[2]")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("This Week", 5, 20, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Sale Summary Report is equal to Sale Recap Report for This Week");
				excel.setreport_PassedData("This Week", 5, 21, "0.00");
				excel.setreport_PassedData("This Week", 24, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Sale Summary Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("This Week", 5, 21,diff_value);
				 excel.setreport_FailedData("This Week", 24, 11,diff_value);
			}

			//Get the Gross Sale from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("This Week", 9, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sale
			String GrossSale=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[11])[2]")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("This Week", 9, 20, GrossSale);


			//Check whether the % of Sale value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "% of Sale for Sale Summary Report is equal to Sale Recap Report for This Week");
				excel.setreport_PassedData("This Week", 9, 21, "0.00");
				excel.setreport_PassedData("This Week", 28, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "% of Sale for Sale Summary Report is not equal to Sale Recap Report  for This Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("This Week", 9, 21,diff_value);
				 excel.setreport_FailedData("This Week", 28, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void SaleSummary_Report_Last_Week(WebDriver driver) throws Exception
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
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Last Week");
			excel.setreportData("Last Week", 2, 20, st);
			excel.setreportData("Last Week", 3, 20, st);
			excel.setreportData("Last Week", 4, 20, st);
			excel.setreportData("Last Week", 5, 20, st);
			excel.setreportData("Last Week", 6, 20, st);
			excel.setreportData("Last Week", 7, 20, st);
			excel.setreportData("Last Week", 8, 20, st);
			excel.setreportData("Last Week", 9, 20, st);

			excel.setreportData("Last Week", 2, 21, st);
			excel.setreportData("Last Week", 3, 21, st);
			excel.setreportData("Last Week", 4, 21, st);
			excel.setreportData("Last Week", 5, 21, st);
			excel.setreportData("Last Week", 6, 21, st);
			excel.setreportData("Last Week", 7, 21, st);
			excel.setreportData("Last Week", 8, 21, st);
			excel.setreportData("Last Week", 9, 21, st);

			excel.setreportData("Last Week", 21, 11, st);
			excel.setreportData("Last Week", 22, 11, st);
			excel.setreportData("Last Week", 23, 11, st);
			excel.setreportData("Last Week", 24, 11, st);
			excel.setreportData("Last Week", 25, 11, st);
			excel.setreportData("Last Week", 26, 11, st);
			excel.setreportData("Last Week", 27, 11, st);
			excel.setreportData("Last Week", 28, 11, st);
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


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last Week", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[6])[2]")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("Last Week", 2, 20, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Sale Summary Report is equal to Sale Recap Report for Last Week");
				excel.setreport_PassedData("Last Week", 2, 21, "0.00");
				excel.setreport_PassedData("Last Week", 21, 11, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Sale Summary Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last Week", 2, 21,diff_value);
				 excel.setreport_FailedData("Last Week", 21, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last Week", 4, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[7])[2]")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last Week", 4, 20, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Sale Summary Report is equal to Sale Recap Report for Last Week");
				excel.setreport_PassedData("Last Week", 4, 21, "0.00");
				excel.setreport_PassedData("Last Week", 23, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Sale Summary Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last Week", 4, 21,diff_value);
				 excel.setreport_FailedData("Last Week", 23, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Last Week", 5, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[10])[2]")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Last Week", 5, 20, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Sale Summary Report is equal to Sale Recap Report for Last Week");
				excel.setreport_PassedData("Last Week", 5, 21, "0.00");
				excel.setreport_PassedData("Last Week", 24, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Sale Summary Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last Week", 5, 21,diff_value);
				 excel.setreport_FailedData("Last Week", 24, 11,diff_value);
			}

			//Get the Gross Sale from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("Last Week", 9, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sale
			String GrossSale=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[11])[2]")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("Last Week", 9, 20, GrossSale);


			//Check whether the % of Sale value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "% of Sale for Sale Summary Report is equal to Sale Recap Report for Last Week");
				excel.setreport_PassedData("Last Week", 9, 21, "0.00");
				excel.setreport_PassedData("Last Week", 28, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "% of Sale for Sale Summary Report is not equal to Sale Recap Report  for Last Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last Week", 9, 21,diff_value);
				 excel.setreport_FailedData("Last Week", 28, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void SaleSummary_Report_Last_7_Days(WebDriver driver) throws Exception
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
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Last 7 days");
			excel.setreportData("Last 7 days", 2, 20, st);
			excel.setreportData("Last 7 days", 3, 20, st);
			excel.setreportData("Last 7 days", 4, 20, st);
			excel.setreportData("Last 7 days", 5, 20, st);
			excel.setreportData("Last 7 days", 6, 20, st);
			excel.setreportData("Last 7 days", 7, 20, st);
			excel.setreportData("Last 7 days", 8, 20, st);
			excel.setreportData("Last 7 days", 9, 20, st);

			excel.setreportData("Last 7 days", 2, 21, st);
			excel.setreportData("Last 7 days", 3, 21, st);
			excel.setreportData("Last 7 days", 4, 21, st);
			excel.setreportData("Last 7 days", 5, 21, st);
			excel.setreportData("Last 7 days", 6, 21, st);
			excel.setreportData("Last 7 days", 7, 21, st);
			excel.setreportData("Last 7 days", 8, 21, st);
			excel.setreportData("Last 7 days", 9, 21, st);

			excel.setreportData("Last 7 days", 21, 11, st);
			excel.setreportData("Last 7 days", 22, 11, st);
			excel.setreportData("Last 7 days", 23, 11, st);
			excel.setreportData("Last 7 days", 24, 11, st);
			excel.setreportData("Last 7 days", 25, 11, st);
			excel.setreportData("Last 7 days", 26, 11, st);
			excel.setreportData("Last 7 days", 27, 11, st);
			excel.setreportData("Last 7 days", 28, 11, st);
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


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last 7 days", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[6])[2]")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("Last 7 days", 2, 20, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Sale Summary Report is equal to Sale Recap Report for Last 7 days");
				excel.setreport_PassedData("Last 7 days", 2, 21, "0.00");
				excel.setreport_PassedData("Last 7 days", 21, 11, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Sale Summary Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last 7 days", 2, 21,diff_value);
				 excel.setreport_FailedData("Last 7 days", 21, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last 7 days", 4, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[7])[2]")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last 7 days", 4, 20, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Sale Summary Report is equal to Sale Recap Report for Last 7 days");
				excel.setreport_PassedData("Last 7 days", 4, 21, "0.00");
				excel.setreport_PassedData("Last 7 days", 23, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Sale Summary Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last 7 days", 4, 21,diff_value);
				 excel.setreport_FailedData("Last 7 days", 23, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Last 7 days", 5, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[10])[2]")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Last 7 days", 5, 20, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Sale Summary Report is equal to Sale Recap Report for Last 7 days");
				excel.setreport_PassedData("Last 7 days", 5, 21, "0.00");
				excel.setreport_PassedData("Last 7 days", 24, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Sale Summary Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last 7 days", 5, 21,diff_value);
				 excel.setreport_FailedData("Last 7 days", 24, 11,diff_value);
			}

			//Get the Gross Sale from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("Last 7 days", 9, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sale
			String GrossSale=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[11])[2]")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("Last 7 days", 9, 20, GrossSale);


			//Check whether the % of Sale value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "% of Sale for Sale Summary Report is equal to Sale Recap Report for Last 7 days");
				excel.setreport_PassedData("Last 7 days", 9, 21, "0.00");
				excel.setreport_PassedData("Last 7 days", 28, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "% of Sale for Sale Summary Report is not equal to Sale Recap Report  for Last 7 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last 7 days", 9, 21,diff_value);
				 excel.setreport_FailedData("Last 7 days", 28, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}


	@Test(priority = 4,enabled = false)
	public void SaleSummary_Report_This_Month(WebDriver driver) throws Exception
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
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for This month");
			excel.setreportData("This month", 2, 20, st);
			excel.setreportData("This month", 3, 20, st);
			excel.setreportData("This month", 4, 20, st);
			excel.setreportData("This month", 5, 20, st);
			excel.setreportData("This month", 6, 20, st);
			excel.setreportData("This month", 7, 20, st);
			excel.setreportData("This month", 8, 20, st);
			excel.setreportData("This month", 9, 20, st);

			excel.setreportData("This month", 2, 21, st);
			excel.setreportData("This month", 3, 21, st);
			excel.setreportData("This month", 4, 21, st);
			excel.setreportData("This month", 5, 21, st);
			excel.setreportData("This month", 6, 21, st);
			excel.setreportData("This month", 7, 21, st);
			excel.setreportData("This month", 8, 21, st);
			excel.setreportData("This month", 9, 21, st);

			excel.setreportData("This month", 21, 11, st);
			excel.setreportData("This month", 22, 11, st);
			excel.setreportData("This month", 23, 11, st);
			excel.setreportData("This month", 24, 11, st);
			excel.setreportData("This month", 25, 11, st);
			excel.setreportData("This month", 26, 11, st);
			excel.setreportData("This month", 27, 11, st);
			excel.setreportData("This month", 28, 11, st);
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


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("This month", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[6])[2]")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("This month", 2, 20, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Sale Summary Report is equal to Sale Recap Report for This month");
				excel.setreport_PassedData("This month", 2, 21, "0.00");
				excel.setreport_PassedData("This month", 21, 11, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Sale Summary Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("This month", 2, 21,diff_value);
				 excel.setreport_FailedData("This month", 21, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("This month", 4, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[7])[2]")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("This month", 4, 20, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Sale Summary Report is equal to Sale Recap Report for This month");
				excel.setreport_PassedData("This month", 4, 21, "0.00");
				excel.setreport_PassedData("This month", 23, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Sale Summary Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("This month", 4, 21,diff_value);
				 excel.setreport_FailedData("This month", 23, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("This month", 5, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[10])[2]")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("This month", 5, 20, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Sale Summary Report is equal to Sale Recap Report for This month");
				excel.setreport_PassedData("This month", 5, 21, "0.00");
				excel.setreport_PassedData("This month", 24, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Sale Summary Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("This month", 5, 21,diff_value);
				 excel.setreport_FailedData("This month", 24, 11,diff_value);
			}

			//Get the Gross Sale from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("This month", 9, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sale
			String GrossSale=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[11])[2]")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("This month", 9, 20, GrossSale);


			//Check whether the % of Sale value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "% of Sale for Sale Summary Report is equal to Sale Recap Report for This month");
				excel.setreport_PassedData("This month", 9, 21, "0.00");
				excel.setreport_PassedData("This month", 28, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "% of Sale for Sale Summary Report is not equal to Sale Recap Report  for This month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("This month", 9, 21,diff_value);
				 excel.setreport_FailedData("This month", 28, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}


	@Test(priority = 4,enabled = false)
	public void SaleSummary_Report_Last_Month(WebDriver driver) throws Exception
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
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Last month");
			excel.setreportData("Last month", 2, 20, st);
			excel.setreportData("Last month", 3, 20, st);
			excel.setreportData("Last month", 4, 20, st);
			excel.setreportData("Last month", 5, 20, st);
			excel.setreportData("Last month", 6, 20, st);
			excel.setreportData("Last month", 7, 20, st);
			excel.setreportData("Last month", 8, 20, st);
			excel.setreportData("Last month", 9, 20, st);

			excel.setreportData("Last month", 2, 21, st);
			excel.setreportData("Last month", 3, 21, st);
			excel.setreportData("Last month", 4, 21, st);
			excel.setreportData("Last month", 5, 21, st);
			excel.setreportData("Last month", 6, 21, st);
			excel.setreportData("Last month", 7, 21, st);
			excel.setreportData("Last month", 8, 21, st);
			excel.setreportData("Last month", 9, 21, st);

			excel.setreportData("Last month", 21, 11, st);
			excel.setreportData("Last month", 22, 11, st);
			excel.setreportData("Last month", 23, 11, st);
			excel.setreportData("Last month", 24, 11, st);
			excel.setreportData("Last month", 25, 11, st);
			excel.setreportData("Last month", 26, 11, st);
			excel.setreportData("Last month", 27, 11, st);
			excel.setreportData("Last month", 28, 11, st);
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


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last month", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[6])[2]")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("Last month", 2, 20, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Sale Summary Report is equal to Sale Recap Report for Last month");
				excel.setreport_PassedData("Last month", 2, 21, "0.00");
				excel.setreport_PassedData("Last month", 21, 11, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Sale Summary Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last month", 2, 21,diff_value);
				 excel.setreport_FailedData("Last month", 21, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last month", 4, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[7])[2]")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last month", 4, 20, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Sale Summary Report is equal to Sale Recap Report for Last month");
				excel.setreport_PassedData("Last month", 4, 21, "0.00");
				excel.setreport_PassedData("Last month", 23, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Sale Summary Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last month", 4, 21,diff_value);
				 excel.setreport_FailedData("Last month", 23, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Last month", 5, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[10])[2]")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Last month", 5, 20, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Sale Summary Report is equal to Sale Recap Report for Last month");
				excel.setreport_PassedData("Last month", 5, 21, "0.00");
				excel.setreport_PassedData("Last month", 24, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Sale Summary Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last month", 5, 21,diff_value);
				 excel.setreport_FailedData("Last month", 24, 11,diff_value);
			}

			//Get the Gross Sale from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("Last month", 9, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sale
			String GrossSale=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[11])[2]")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("Last month", 9, 20, GrossSale);


			//Check whether the % of Sale value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "% of Sale for Sale Summary Report is equal to Sale Recap Report for Last month");
				excel.setreport_PassedData("Last month", 9, 21, "0.00");
				excel.setreport_PassedData("Last month", 28, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "% of Sale for Sale Summary Report is not equal to Sale Recap Report  for Last month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last month", 9, 21,diff_value);
				 excel.setreport_FailedData("Last month", 28, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void SaleSummary_Report_Last_30_Days(WebDriver driver) throws Exception
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
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Last 30 days");
			excel.setreportData("Last 30 days", 2, 20, st);
			excel.setreportData("Last 30 days", 3, 20, st);
			excel.setreportData("Last 30 days", 4, 20, st);
			excel.setreportData("Last 30 days", 5, 20, st);
			excel.setreportData("Last 30 days", 6, 20, st);
			excel.setreportData("Last 30 days", 7, 20, st);
			excel.setreportData("Last 30 days", 8, 20, st);
			excel.setreportData("Last 30 days", 9, 20, st);

			excel.setreportData("Last 30 days", 2, 21, st);
			excel.setreportData("Last 30 days", 3, 21, st);
			excel.setreportData("Last 30 days", 4, 21, st);
			excel.setreportData("Last 30 days", 5, 21, st);
			excel.setreportData("Last 30 days", 6, 21, st);
			excel.setreportData("Last 30 days", 7, 21, st);
			excel.setreportData("Last 30 days", 8, 21, st);
			excel.setreportData("Last 30 days", 9, 21, st);

			excel.setreportData("Last 30 days", 21, 11, st);
			excel.setreportData("Last 30 days", 22, 11, st);
			excel.setreportData("Last 30 days", 23, 11, st);
			excel.setreportData("Last 30 days", 24, 11, st);
			excel.setreportData("Last 30 days", 25, 11, st);
			excel.setreportData("Last 30 days", 26, 11, st);
			excel.setreportData("Last 30 days", 27, 11, st);
			excel.setreportData("Last 30 days", 28, 11, st);
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


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Last 30 days", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[6])[2]")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("Last 30 days", 2, 20, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Sale Summary Report is equal to Sale Recap Report for Last 30 days");
				excel.setreport_PassedData("Last 30 days", 2, 21, "0.00");
				excel.setreport_PassedData("Last 30 days", 21, 11, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Sale Summary Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last 30 days", 2, 21,diff_value);
				 excel.setreport_FailedData("Last 30 days", 21, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last 30 days", 4, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[7])[2]")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last 30 days", 4, 20, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Sale Summary Report is equal to Sale Recap Report for Last 30 days");
				excel.setreport_PassedData("Last 30 days", 4, 21, "0.00");
				excel.setreport_PassedData("Last 30 days", 23, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Sale Summary Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last 30 days", 4, 21,diff_value);
				 excel.setreport_FailedData("Last 30 days", 23, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Last 30 days", 5, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[10])[2]")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Last 30 days", 5, 20, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Sale Summary Report is equal to Sale Recap Report for Last 30 days");
				excel.setreport_PassedData("Last 30 days", 5, 21, "0.00");
				excel.setreport_PassedData("Last 30 days", 24, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Sale Summary Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last 30 days", 5, 21,diff_value);
				 excel.setreport_FailedData("Last 30 days", 24, 11,diff_value);
			}

			//Get the Gross Sale from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("Last 30 days", 9, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sale
			String GrossSale=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[11])[2]")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("Last 30 days", 9, 20, GrossSale);


			//Check whether the % of Sale value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "% of Sale for Sale Summary Report is equal to Sale Recap Report for Last 30 days");
				excel.setreport_PassedData("Last 30 days", 9, 21, "0.00");
				excel.setreport_PassedData("Last 30 days", 28, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "% of Sale for Sale Summary Report is not equal to Sale Recap Report  for Last 30 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last 30 days", 9, 21,diff_value);
				 excel.setreport_FailedData("Last 30 days", 28, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void SaleSummary_Report_Specific_Date(WebDriver driver) throws Exception
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
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Specific Date");
			excel.setreportData("Specific Date", 2, 20, st);
			excel.setreportData("Specific Date", 3, 20, st);
			excel.setreportData("Specific Date", 4, 20, st);
			excel.setreportData("Specific Date", 5, 20, st);
			excel.setreportData("Specific Date", 6, 20, st);
			excel.setreportData("Specific Date", 7, 20, st);
			excel.setreportData("Specific Date", 8, 20, st);
			excel.setreportData("Specific Date", 9, 20, st);

			excel.setreportData("Specific Date", 2, 21, st);
			excel.setreportData("Specific Date", 3, 21, st);
			excel.setreportData("Specific Date", 4, 21, st);
			excel.setreportData("Specific Date", 5, 21, st);
			excel.setreportData("Specific Date", 6, 21, st);
			excel.setreportData("Specific Date", 7, 21, st);
			excel.setreportData("Specific Date", 8, 21, st);
			excel.setreportData("Specific Date", 9, 21, st);

			excel.setreportData("Specific Date", 21, 11, st);
			excel.setreportData("Specific Date", 22, 11, st);
			excel.setreportData("Specific Date", 23, 11, st);
			excel.setreportData("Specific Date", 24, 11, st);
			excel.setreportData("Specific Date", 25, 11, st);
			excel.setreportData("Specific Date", 26, 11, st);
			excel.setreportData("Specific Date", 27, 11, st);
			excel.setreportData("Specific Date", 28, 11, st);
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


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Specific Date", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[6])[2]")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("Specific Date", 2, 20, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Sale Summary Report is equal to Sale Recap Report for Specific Date");
				excel.setreport_PassedData("Specific Date", 2, 21, "0.00");
				excel.setreport_PassedData("Specific Date", 21, 11, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Sale Summary Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Specific Date", 2, 21,diff_value);
				 excel.setreport_FailedData("Specific Date", 21, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Specific Date", 4, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[7])[2]")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Specific Date", 4, 20, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Sale Summary Report is equal to Sale Recap Report for Specific Date");
				excel.setreport_PassedData("Specific Date", 4, 21, "0.00");
				excel.setreport_PassedData("Specific Date", 23, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Sale Summary Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Specific Date", 4, 21,diff_value);
				 excel.setreport_FailedData("Specific Date", 23, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Specific Date", 5, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[10])[2]")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Specific Date", 5, 20, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Sale Summary Report is equal to Sale Recap Report for Specific Date");
				excel.setreport_PassedData("Specific Date", 5, 21, "0.00");
				excel.setreport_PassedData("Specific Date", 24, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Sale Summary Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Specific Date", 5, 21,diff_value);
				 excel.setreport_FailedData("Specific Date", 24, 11,diff_value);
			}

			//Get the Gross Sale from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("Specific Date", 9, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sale
			String GrossSale=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[11])[2]")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("Specific Date", 9, 20, GrossSale);


			//Check whether the % of Sale value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "% of Sale for Sale Summary Report is equal to Sale Recap Report for Specific Date");
				excel.setreport_PassedData("Specific Date", 9, 21, "0.00");
				excel.setreport_PassedData("Specific Date", 28, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "% of Sale for Sale Summary Report is not equal to Sale Recap Report  for Specific Date.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Specific Date", 9, 21,diff_value);
				 excel.setreport_FailedData("Specific Date", 28, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}

	@Test(priority = 4,enabled = false)
	public void SaleSummary_Report_Date_Range(WebDriver driver) throws Exception
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
		if(driver.findElement(By.xpath("//span[contains(.,'No sale summary for selected time period')]")).isDisplayed())
		{
			test.log(LogStatus.INFO, "Sale Report Not Available for Date Range");
			excel.setreportData("Date Range", 2, 20, st);
			excel.setreportData("Date Range", 3, 20, st);
			excel.setreportData("Date Range", 4, 20, st);
			excel.setreportData("Date Range", 5, 20, st);
			excel.setreportData("Date Range", 6, 20, st);
			excel.setreportData("Date Range", 7, 20, st);
			excel.setreportData("Date Range", 8, 20, st);
			excel.setreportData("Date Range", 9, 20, st);

			excel.setreportData("Date Range", 2, 21, st);
			excel.setreportData("Date Range", 3, 21, st);
			excel.setreportData("Date Range", 4, 21, st);
			excel.setreportData("Date Range", 5, 21, st);
			excel.setreportData("Date Range", 6, 21, st);
			excel.setreportData("Date Range", 7, 21, st);
			excel.setreportData("Date Range", 8, 21, st);
			excel.setreportData("Date Range", 9, 21, st);

			excel.setreportData("Date Range", 21, 11, st);
			excel.setreportData("Date Range", 22, 11, st);
			excel.setreportData("Date Range", 23, 11, st);
			excel.setreportData("Date Range", 24, 11, st);
			excel.setreportData("Date Range", 25, 11, st);
			excel.setreportData("Date Range", 26, 11, st);
			excel.setreportData("Date Range", 27, 11, st);
			excel.setreportData("Date Range", 28, 11, st);
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


//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			//Get the NEt Sales from Sale Recap Report
			String Expeccted_SaleAmt=excel.getData("Date Range", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
			String SaleAmount=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[6])[2]")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("Date Range", 2, 20, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Sale Summary Report is equal to Sale Recap Report for Date Range");
				excel.setreport_PassedData("Date Range", 2, 21, "0.00");
				excel.setreport_PassedData("Date Range", 21, 11, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Sale Summary Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Date Range", 2, 21,diff_value);
				 excel.setreport_FailedData("Date Range", 21, 11,diff_value);
			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Date Range", 4, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[7])[2]")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Date Range", 4, 20, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Sale Summary Report is equal to Sale Recap Report for Date Range");
				excel.setreport_PassedData("Date Range", 4, 21, "0.00");
				excel.setreport_PassedData("Date Range", 23, 11, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Sale Summary Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Date Range", 4, 21,diff_value);
				 excel.setreport_FailedData("Date Range", 23, 11,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Date Range", 5, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[10])[2]")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Date Range", 5, 20, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Sale Summary Report is equal to Sale Recap Report for Date Range");
				excel.setreport_PassedData("Date Range", 5, 21, "0.00");
				excel.setreport_PassedData("Date Range", 24, 11, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Sale Summary Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Date Range", 5, 21,diff_value);
				 excel.setreport_FailedData("Date Range", 24, 11,diff_value);
			}

			//Get the Gross Sale from Sale Recap Report
			String Expeccted_GrossSale=excel.getData("Date Range", 9, 1).toString().replace(",", "");
			double Expected_GrossSale=Double.parseDouble(Expeccted_GrossSale);


			//Get the Gross Sale
			String GrossSale=driver.findElement(By.xpath("(//div[contains(.,'Total')]/../div[11])[2]")).getText().replace(",", "");
			double ActualGrossSale=Double.parseDouble(GrossSale);

			//Export the % Percentage of Sale value to Excel
			excel.setreportData("Date Range", 9, 20, GrossSale);


			//Check whether the % of Sale value is Equal or not
			if(Expected_GrossSale==ActualGrossSale)
			{
				test.log(LogStatus.PASS, "% of Sale for Sale Summary Report is equal to Sale Recap Report for Date Range");
				excel.setreport_PassedData("Date Range", 9, 21, "0.00");
				excel.setreport_PassedData("Date Range", 28, 11, GrossSale+"`");
			}
			else
			{
				double diff=Expected_GrossSale-ActualGrossSale;
				test.log(LogStatus.FAIL, "% of Sale for Sale Summary Report is not equal to Sale Recap Report  for Date Range.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Date Range", 9, 21,diff_value);
				 excel.setreport_FailedData("Date Range", 28, 11,diff_value);
			}

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Reports"));


			Thread.sleep(3000);

		}
	}

}
