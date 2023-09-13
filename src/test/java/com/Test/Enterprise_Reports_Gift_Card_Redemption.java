package com.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
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

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Enterprise_Reports_Gift_Card_Redemption 
{

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise Reports - Gift Card Redemption Report");
	
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
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().driverVersion("110.0.5481").setup();
//		driver = new ChromeDriver(chromeOptions);
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
		Open_Enterprise_Gift_Card_Redemption_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Verify_Enterprise_Gift_Card_Redemption_Report_Search_by_GiftCardNumber(driver);
		Enterprise_Gift_Card_Redemption_Report_Today(driver);
		Enterprise_Gift_Card_Redemption_Report_Yesterday(driver);
		Enterprise_Gift_Card_Redemption_Report_Last_N_Days(driver);
		Enterprise_Gift_Card_Redemption_Report_This_Week(driver);
		Enterprise_Gift_Card_Redemption_Report_Last_Week(driver);
		Enterprise_Gift_Card_Redemption_Report_Last_7_Days(driver);
		Enterprise_Gift_Card_Redemption_Report_This_Month(driver);
		Enterprise_Gift_Card_Redemption_Report_Last_Month(driver);
		Enterprise_Gift_Card_Redemption_Report_Last_30_Days(driver);
		Enterprise_Gift_Card_Redemption_Report_Specific_Date(driver);
		Enterprise_Gift_Card_Redemption_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Enterprise_Gift_Card_Redemption_Report_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Menu Item sales report page
		driver.get(Utility.getProperty("baseURL")+"enterprise/enterpriseReports/giftCard/redemption");

		Thread.sleep(5000);
		//Verify the Loyalty report page loaded or not
//		cmp.VerifyMainScreenPageHeader("Gift Card");
		
		try
		{
			//Verify the Menu Item sales report page loaded or not
			repts.Verify_ReportHomePage("REDEMPTION");
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
	public void Verify_Enterprise_Gift_Card_Redemption_Report_Search_by_GiftCardNumber(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select stores
		repts.Store_Selection_in_DropDown_EnterpriseReport("All");
		
		Thread.sleep(1000);
		//Search Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		Thread.sleep(1000);
		//Select the Active Type
		repts.Select_Activity_Type("All");
		
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
				test.log(LogStatus.INFO, "Gift Card Redemption Report Not Available");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Gift Card Redemption Report Available");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			//Do pagination to Last
			//repts.Do_Pagination();
			
			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

			int GiftCardListSize=rowList.size();
			
			int randomGiftCard=ThreadLocalRandom.current().nextInt(1, GiftCardListSize);
//			
			
			String GiftCardNo=driver.findElement(By.xpath("//table/tbody/tr["+randomGiftCard+"]/td[1]")).getText();
			
			Thread.sleep(1000);
			//Select Customer
			repts.Enter_GiftCard_Number(GiftCardNo);
			
			Thread.sleep(1000);
			//Select the Active Type
			repts.Select_Activity_Type("All");
			
			Thread.sleep(1000);
			//Click the Apply button
			repts.Click_ApplyButton();
			
			Thread.sleep(3000);
			try
			{
				if(repts.No_TransactionFound_InfoMessage().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Gift Card Redemption Report Not fetched for Searched GiftCard Number : "+GiftCardNo);
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception f)
			{
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				Thread.sleep(1000);
				test.log(LogStatus.PASS, "Gift Card Redemption Report fetched for the Searched GiftCard Number : "+GiftCardNo);
					test.log(LogStatus.INFO, "Searched GiftCard Number is : "+GiftCardNo+" Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());
			
			}
			

			Thread.sleep(1000);
			//Select stores
			repts.Store_Selection_in_DropDown_EnterpriseReport("All");
			
			Thread.sleep(1000);
			//Search Gift Card Number
			repts.Enter_GiftCard_Number("");
			
			Thread.sleep(1000);
			//Select the Active Type
			repts.Select_Activity_Type("Store");

			Thread.sleep(1000);
			//Click the Apply button
			repts.Click_ApplyButton();
			
			Thread.sleep(3000);
			try
			{
				if(repts.No_TransactionFound_InfoMessage().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Gift Card Redemption Report is not available for the Active Type - Store");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception f)
			{
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				Thread.sleep(1000);
				test.log(LogStatus.PASS, "Gift Card Redemption Report available for the Active Type - Store");
			
			}
			
			
			Thread.sleep(1000);
			//Select stores
			repts.Store_Selection_in_DropDown_EnterpriseReport("All");
			
			Thread.sleep(1000);
			//Search Gift Card Number
			repts.Enter_GiftCard_Number("");
			
			Thread.sleep(1000);
			//Select the Active Type
			repts.Select_Activity_Type("Online");

			Thread.sleep(1000);
			//Click the Apply button
			repts.Click_ApplyButton();
			
			Thread.sleep(3000);
			try
			{
				if(repts.No_TransactionFound_InfoMessage().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Gift Card Redemption Report is not available for the Active Type - Online");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception f)
			{
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				Thread.sleep(1000);
				test.log(LogStatus.PASS, "Gift Card Redemption Report available for the Active Type - Online");
			
			}
			
			
			Thread.sleep(1000);
			//Select stores
			repts.Store_Selection_in_DropDown_EnterpriseReport("All");
			
			Thread.sleep(1000);
			//Search Gift Card Number
			repts.Enter_GiftCard_Number("");
			
			Thread.sleep(1000);
			//Select the Active Type
			repts.Select_Activity_Type("All");
			
			if(driver.findElement(By.xpath("//mat-checkbox[contains(.,'Group by Store')]")).isEnabled())
			{
				
			}
			else
			{
			//Select Group by Store
			driver.findElement(By.xpath("//mat-checkbox[contains(.,'Group by Store')]")).click();
			}
			
			Thread.sleep(1000);
			//Click the Apply button
			repts.Click_ApplyButton();
			
			Thread.sleep(3000);
			try
			{
				if(repts.No_TransactionFound_InfoMessage().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Gift Card Redemption Report is not available after Enabled Group by Store");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception f)
			{
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				Thread.sleep(1000);
				test.log(LogStatus.PASS, "Gift Card Redemption Report available after Enabled Group by Store");
			
				test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

			}
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Gift_Card_Redemption_Report_Today(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select stores
		repts.Store_Selection_in_DropDown_EnterpriseReport(Utility.getProperty("Store1"));
		
		Thread.sleep(1000);
		//Search Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		Thread.sleep(1000);
		//Select the Active Type
		repts.Select_Activity_Type("All");
		
		
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
				test.log(LogStatus.INFO, "Gift Card Redemption Report Not Available for Today");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Gift Card Redemption Report Available for Today");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			//Do pagination to Last
			//repts.Do_Pagination();
			
			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
				
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
			
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());
					
				}
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Gift_Card_Redemption_Report_Yesterday(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select stores
		repts.Store_Selection_in_DropDown_EnterpriseReport(Utility.getProperty("Store1"));
		
		Thread.sleep(1000);
		//Search Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		Thread.sleep(1000);
		//Select the Active Type
		repts.Select_Activity_Type("All");
				
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
				test.log(LogStatus.INFO, "Gift Card Redemption Report Not Available for Yesterday");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Gift Card Redemption Report Available for Yesterday");

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
			//repts.Do_Pagination();


			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Gift_Card_Redemption_Report_Last_N_Days(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select stores
		repts.Store_Selection_in_DropDown_EnterpriseReport(Utility.getProperty("Store1"));
		
		Thread.sleep(1000);
		//Search Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		Thread.sleep(1000);
		//Select the Active Type
		repts.Select_Activity_Type("All");
		

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
				test.log(LogStatus.INFO, "Gift Card Redemption Report Not Available for Last N Days");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Gift Card Redemption Report Available for Last N days");

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
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Gift_Card_Redemption_Report_This_Week(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select stores
		repts.Store_Selection_in_DropDown_EnterpriseReport(Utility.getProperty("Store1"));
		
		Thread.sleep(1000);
		//Search Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		Thread.sleep(1000);
		//Select the Active Type
		repts.Select_Activity_Type("All");
		

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
				test.log(LogStatus.INFO, "Gift Card Redemption Report Not Available for This Week");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Gift Card Redemption Report Available for This Week");

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
			//repts.Do_Pagination();


			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
				
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Gift_Card_Redemption_Report_Last_Week(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select stores
		repts.Store_Selection_in_DropDown_EnterpriseReport(Utility.getProperty("Store1"));
		
		Thread.sleep(1000);
		//Search Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		Thread.sleep(1000);
		//Select the Active Type
		repts.Select_Activity_Type("All");

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
				test.log(LogStatus.INFO, "Gift Card Redemption Report Not Available for Last Week");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Gift Card Redemption Report Available for Last Week");

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
			//repts.Do_Pagination();
			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Gift_Card_Redemption_Report_Last_7_Days(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select stores
		repts.Store_Selection_in_DropDown_EnterpriseReport(Utility.getProperty("Store1"));
		
		Thread.sleep(1000);
		//Search Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		Thread.sleep(1000);
		//Select the Active Type
		repts.Select_Activity_Type("All");
		

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
				test.log(LogStatus.INFO, "Gift Card Redemption Report Not Available for Last 7 days");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Gift Card Redemption Report Available for Last 7 days");

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
			//repts.Do_Pagination();


			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Enterprise_Gift_Card_Redemption_Report_This_Month(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select stores
		repts.Store_Selection_in_DropDown_EnterpriseReport(Utility.getProperty("Store1"));
		
		Thread.sleep(1000);
		//Search Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		Thread.sleep(1000);
		//Select the Active Type
		repts.Select_Activity_Type("All");

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
				test.log(LogStatus.INFO, "Gift Card Redemption Report Not Available for This month");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Gift Card Redemption Report Available for This month");

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
			//repts.Do_Pagination();


			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Gift_Card_Redemption_Report_Last_Month(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select stores
		repts.Store_Selection_in_DropDown_EnterpriseReport(Utility.getProperty("Store1"));
		
		Thread.sleep(1000);
		//Search Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		Thread.sleep(1000);
		//Select the Active Type
		repts.Select_Activity_Type("All");

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
				test.log(LogStatus.INFO, "Gift Card Redemption Report Not Available for Last month");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Gift Card Redemption Report Available for Last month");

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
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Gift_Card_Redemption_Report_Last_30_Days(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select stores
		repts.Store_Selection_in_DropDown_EnterpriseReport(Utility.getProperty("Store1"));
		
		Thread.sleep(1000);
		//Search Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		Thread.sleep(1000);
		//Select the Active Type
		repts.Select_Activity_Type("All");
		

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
				test.log(LogStatus.INFO, "Gift Card Redemption Report Not Available for Last 30 days");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Gift Card Redemption Report Available for Last 30 days");

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
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

			
			
			int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Enterprise_Gift_Card_Redemption_Report_Specific_Date(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){ Thread.sleep(1000);driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select stores
		repts.Store_Selection_in_DropDown_EnterpriseReport(Utility.getProperty("Store1"));
		
		Thread.sleep(1000);
		//Search Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		Thread.sleep(1000);
		//Select the Active Type
		repts.Select_Activity_Type("All");
		
		Thread.sleep(2000);
		//Select Specific Date
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));

		Thread.sleep(2000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Gift Card Redemption Report Not Available for Specific Date");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Gift Card Redemption Report Available for Specific Date");

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
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

			
			
int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_Gift_Card_Redemption_Report_Date_Range(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){ Thread.sleep(1000);driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Select stores
		repts.Store_Selection_in_DropDown_EnterpriseReport(Utility.getProperty("Store1"));
		
		Thread.sleep(1000);
		//Search Gift Card Number
		repts.Enter_GiftCard_Number("");
		
		Thread.sleep(1000);
		//Select the Active Type
		repts.Select_Activity_Type("All");
				

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
				test.log(LogStatus.INFO, "Gift Card Redemption Report Not Available for Date Range");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Gift Card Redemption Report Available for Date Range");

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
			//repts.Do_Pagination();

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));

			int rowSize=rowList.size();
			
			
			if(rowSize<=5)
			{
			
				for(int i = 1;i<=rowSize;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}
			else
			{
				for(int i = 1;i<=5;i++) 
				{
					test.log(LogStatus.INFO, "Gift Card Number: "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Issuing Store is : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+" Debit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Credit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText()+" Redemption Store : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[5]")).getText()+" Store Level : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[6]")).getText());
					test.log(LogStatus.INFO, "Total Debit is : "+driver.findElement(By.xpath("//tfoot/tr/td[3]")).getText()+" Total Credit is : "+driver.findElement(By.xpath("//tfoot/tr/td[4]")).getText());

				}
			}
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}	
	}
}
