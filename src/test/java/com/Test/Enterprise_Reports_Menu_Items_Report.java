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

public class Enterprise_Reports_Menu_Items_Report 
{

public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise Reports - Menu Item Sale Report");
	
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

//		System.setProperty("webdriver.chrome.driver","./Automation Driver/chromedriver.exe");
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
		Open_Enterprise_MenuItem_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Enterprise_MenuItem_Report_Today(driver);
		Enterprise_MenuItem_Report_Yesterday(driver);
		Enterprise_MenuItem_Report_Last_N_Days(driver);
		Enterprise_MenuItem_Report_This_Week(driver);
		Enterprise_MenuItem_Report_Last_Week(driver);
		Enterprise_MenuItem_Report_Last_7_Days(driver);
		Enterprise_MenuItem_Report_This_Month(driver);
		Enterprise_MenuItem_Report_Last_Month(driver);
		Enterprise_MenuItem_Report_Last_30_Days(driver);
		Enterprise_MenuItem_Report_Specific_Date(driver);
		Enterprise_MenuItem_Report_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Enterprise_MenuItem_Report_Page(SelfHealingDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Menu Item sales report page
		driver.get(Utility.getProperty("baseURL")+"enterprise/enterpriseReports/saleReports/menuItems");

		Thread.sleep(5000);
		try
		{
		//Verify the Menu Item sales report page loeded or not
		repts.Verify_ReportHomePage("MENU ITEMS");
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
	public void SelectTheCat(SelfHealingDriver driver) throws Exception
	{
		Thread.sleep(5000);	
		//Click the department label
		driver.findElement(By.xpath("//span[contains(.,'Department')]/../input")).click();
		Thread.sleep(500);	
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
				
		Thread.sleep(500);
		//Click the category label
		driver.findElement(By.xpath("(//span[contains(.,'Category')]/../input)[1]")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
		Thread.sleep(500);
		//Click the sub category label
		driver.findElement(By.xpath("(//span[contains(.,'Sub Category')]/../input)[1]")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
		Thread.sleep(500);
		//Click the menu item label
		driver.findElement(By.xpath("//span[contains(.,'Menu Item')]/../input")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
		Thread.sleep(500);
		//Click the serving size label
		driver.findElement(By.xpath("//span[contains(.,'Serving Size')]/../input")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
		Thread.sleep(500);
		//Click the price level label
		driver.findElement(By.xpath("//span[contains(.,'Price Level')]/../input")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'Default')]")).click();
		
		Thread.sleep(500);
		//Click the employee label
		driver.findElement(By.xpath("//span[contains(.,'Employee')]/../input")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
		//Un check the Split by Serving Level
		try {
			if(driver.findElement(By.xpath("//span[contains(.,'Split By')]/../../../mat-checkbox[contains(@class,'mat-checkbox-checked')]")).isDisplayed()) {
				//Click the checked box
				driver.findElement(By.xpath("//span[contains(.,'Split By')]/../../../mat-checkbox[contains(@class,'mat-checkbox-checked')]")).click();
			}
		}catch(Exception d) {
			
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_MenuItem_Report_Today(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		//SelectTheCat(driver);
		
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
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Sale Report Not Available for Today");
			excel.setreportData("Today", 2, 8, st);
			excel.setreportData("Today", 3, 8, st);
			excel.setreportData("Today", 4, 8, st);
			excel.setreportData("Today", 5, 8, st);
			excel.setreportData("Today", 6, 8, st);
			excel.setreportData("Today", 7, 8, st);
			excel.setreportData("Today", 8, 8, st);
			excel.setreportData("Today", 9, 8, st);
			excel.setreportData("Today", 10, 8, st);
			excel.setreportData("Today", 11, 8, st);
			excel.setreportData("Today", 12, 8, st);
			excel.setreportData("Today", 13, 8, st);
			
			excel.setreportData("Today", 2, 9, st);
			excel.setreportData("Today", 3, 9, st);
			excel.setreportData("Today", 4, 9, st);
			excel.setreportData("Today", 5, 9, st);
			excel.setreportData("Today", 6, 9, st);
			excel.setreportData("Today", 7, 9, st);
			excel.setreportData("Today", 8, 9, st);
			excel.setreportData("Today", 9, 9, st);
			excel.setreportData("Today", 10, 9, st);
			excel.setreportData("Today", 11, 9, st);
			excel.setreportData("Today", 12, 9, st);
			excel.setreportData("Today", 13, 9, st);
			
			excel.setreportData("Today", 39, 5, st);
			excel.setreportData("Today", 40, 5, st);
			excel.setreportData("Today", 41, 5, st);
			excel.setreportData("Today", 42, 5, st);
			excel.setreportData("Today", 43, 5, st);
			excel.setreportData("Today", 44, 5, st);
			excel.setreportData("Today", 45, 5, st);
			excel.setreportData("Today", 46, 5, st);
			excel.setreportData("Today", 47, 5, st);
			excel.setreportData("Today", 48, 5, st);
			excel.setreportData("Today", 49, 5, st);
			excel.setreportData("Today", 50, 5, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Enterprise Sale Report Available for Today");
	
			
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
			String Expeccted_SaleAmt=excel.getData("Today", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
			
			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);
			
			//Export the Sale Amount value to Excel
			excel.setreportData("Today", 2, 8, SaleAmount);

			
			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Menu Item Sale Report is equal to Sale Recap Report for Today");
				excel.setreport_PassedData("Today", 2, 9, "0.00");
				excel.setreport_PassedData("Today", 39, 5, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Menu Item Sale Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Today", 2, 9,diff_value);
				 excel.setreport_FailedData("Today", 39, 5,diff_value);
			}
			
			//Get the Quantity from Sale Recap Report
			//String Expeccted_Qty=excel.getData("Today", 3, 1).toString().replace(",", "");
			//double Expected_Quantity=Double.parseDouble(Expeccted_Qty);
		
			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[6]/span")).getText().replace(",", "");
			//double ActualQuantity=Double.parseDouble(Qty);
			
			//Export Qunatity value to Excel
			//excel.setreportData("Today", 3, 8, Qty);
			
			
			//Check whether the Quantity value is Equal or not
//			if(Expected_Quantity==ActualQuantity)
//			{
				test.log(LogStatus.INFO, "Quantity for Menu Item Sale Report is displayed for Today and the value is : "+Qty);
//				excel.setreport_PassedData("Today", 3, 9, "0");
//				excel.setreport_PassedData("Today", 22, 5, Qty+"`");
//			}
//			else
//			{
//				double diff=Expected_Quantity-ActualQuantity;
//				test.log(LogStatus.FAIL, "Quantity for Menu Item Sale Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
//				 String diff_value=String.valueOf(diff);
//				 //Export the Sale Amount value to Excel
//				 excel.setreport_FailedData("Today", 3, 9,diff_value);
//				 excel.setreport_FailedData("Today", 22, 5,diff_value);
//			}

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Today", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);
			
			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[7]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);
			
			//Export Tax value to Excel
			excel.setreportData("Today", 3, 8, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Menu Item Sale Report is equal to Sale Recap Report for Today");
				excel.setreport_PassedData("Today", 3, 9, "0.00");
				excel.setreport_PassedData("Today", 40, 5, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Menu Item Sale Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Today", 3, 9,diff_value);
				 excel.setreport_FailedData("Today", 40, 5,diff_value);
			}
			
			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Today", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);
			
			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[8]/span")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);
			
			//Export Discount value to Excel
			excel.setreportData("Today", 4, 8, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Menu Item Sale Report is equal to Sale Recap Report for Today");
				excel.setreport_PassedData("Today", 4, 9, "0.00");
				excel.setreport_PassedData("Today", 41, 5, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Menu Item Sale Report is not equal to Sale Recap Report for Today.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Today", 4, 9,diff_value);
				 excel.setreport_FailedData("Today", 41, 5,diff_value);
			}
			
			//Get the % Sale from Sale Recap Report
//			String Expeccted_PerSale=excel.getData("Today", 6, 1).toString().replace(",", "");
//			double Expected_Percentage_ofSale=Double.parseDouble(Expeccted_PerSale);
//		
//			
//			//Get the Percentage of Sale
			String PerSale=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[9]/span")).getText().replace(",", "");
//			double ActualPercentage_ofSale=Double.parseDouble(PerSale);
//			
//			//Export the % Percentage of Sale value to Excel
//			excel.setreportData("Today", 6, 8, PerSale);
//
//			
//			//Check whether the % of Sale value is Equal or not
//			if(Expected_Percentage_ofSale==ActualPercentage_ofSale)
//			{
				test.log(LogStatus.PASS, "% of Sale for Menu Item Sale Report is displayed for Today and the value is : "+PerSale);
//				excel.setreport_PassedData("Today", 6, 9, "0.00");
//				excel.setreport_PassedData("Today", 25, 5, PerSale+"`");
//			}
//			else
//			{
//				double diff=Expected_Percentage_ofSale-ActualPercentage_ofSale;
//				test.log(LogStatus.FAIL, "% of Sale for Menu Item Sale Report is not equal to Sale Recap Report  for Today.The value diff is : "+diff);
//				 String diff_value=String.valueOf(diff);
//				 //Export the Sale Amount value to Excel
//				 excel.setreport_FailedData("Today", 6, 9,diff_value);
//				 excel.setreport_FailedData("Today", 25, 5,diff_value);
//			}
			
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		
			
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_MenuItem_Report_Yesterday(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		////SelectTheCat(driver);
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));

		//Select Yesterday
		repts.Select_Yesterday_TimePeriod();

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Sale Report Not Available for Yesterday");
			excel.setreportData("Yesterday", 2, 8, st);
			excel.setreportData("Yesterday", 3, 8, st);
			excel.setreportData("Yesterday", 4, 8, st);
			excel.setreportData("Yesterday", 5, 8, st);
			excel.setreportData("Yesterday", 6, 8, st);
			excel.setreportData("Yesterday", 7, 8, st);
			excel.setreportData("Yesterday", 8, 8, st);
			excel.setreportData("Yesterday", 9, 8, st);
			excel.setreportData("Yesterday", 10, 8, st);
			excel.setreportData("Yesterday", 11, 8, st);
			excel.setreportData("Yesterday", 12, 8, st);
			excel.setreportData("Yesterday", 13, 8, st);

			excel.setreportData("Yesterday", 2, 9, st);
			excel.setreportData("Yesterday", 3, 9, st);
			excel.setreportData("Yesterday", 4, 9, st);
			excel.setreportData("Yesterday", 5, 9, st);
			excel.setreportData("Yesterday", 6, 9, st);
			excel.setreportData("Yesterday", 7, 9, st);
			excel.setreportData("Yesterday", 8, 9, st);
			excel.setreportData("Yesterday", 9, 9, st);
			excel.setreportData("Yesterday", 10, 9, st);
			excel.setreportData("Yesterday", 11, 9, st);
			excel.setreportData("Yesterday", 12, 9, st);
			excel.setreportData("Yesterday", 13, 9, st);

			excel.setreportData("Yesterday", 39, 5, st);
			excel.setreportData("Yesterday", 40, 5, st);
			excel.setreportData("Yesterday", 41, 5, st);
			excel.setreportData("Yesterday", 42, 5, st);
			excel.setreportData("Yesterday", 43, 5, st);
			excel.setreportData("Yesterday", 44, 5, st);
			excel.setreportData("Yesterday", 45, 5, st);
			excel.setreportData("Yesterday", 46, 5, st);
			excel.setreportData("Yesterday", 47, 5, st);
			excel.setreportData("Yesterday", 48, 5, st);
			excel.setreportData("Yesterday", 49, 5, st);
			excel.setreportData("Yesterday", 50, 5, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Enterprise Sale Report Available for Yesterday");

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
			String Expeccted_SaleAmt=excel.getData("Yesterday", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("Yesterday", 2, 8, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Menu Item Sale Report is equal to Sale Recap Report for Yesterday");
				excel.setreport_PassedData("Yesterday", 2, 9, "0.00");
				excel.setreport_PassedData("Yesterday", 39, 5, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Menu Item Sale Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Yesterday", 2, 9,diff_value);
				 excel.setreport_FailedData("Yesterday", 39, 5,diff_value);
			}

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[6]/span")).getText().replace(",", "");
				test.log(LogStatus.INFO, "Quantity for Menu Item Sale Report is displayed for Yesterday and the value is : "+Qty);

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Yesterday", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[7]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Yesterday", 3, 8, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Menu Item Sale Report is equal to Sale Recap Report for Yesterday");
				excel.setreport_PassedData("Yesterday", 3, 9, "0.00");
				excel.setreport_PassedData("Yesterday", 40, 5, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Menu Item Sale Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Yesterday", 3, 9,diff_value);
				 excel.setreport_FailedData("Yesterday", 40, 5,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Yesterday", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[8]/span")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Yesterday", 4, 8, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Menu Item Sale Report is equal to Sale Recap Report for Yesterday");
				excel.setreport_PassedData("Yesterday", 4, 9, "0.00");
				excel.setreport_PassedData("Yesterday", 41, 5, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Menu Item Sale Report is not equal to Sale Recap Report for Yesterday.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Yesterday", 4, 9,diff_value);
				 excel.setreport_FailedData("Yesterday", 41, 5,diff_value);
			}

			//Get the Percentage of Sale
			String PerSale=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[9]/span")).getText().replace(",", "");
				test.log(LogStatus.PASS, "% of Sale for Menu Item Sale Report is displayed for Yesterday and the value is : "+PerSale);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Enterprise_MenuItem_Report_Last_N_Days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		////SelectTheCat(driver);
		
		//Filter the Store and Select Store
		repts.Select_Stores_In_Enterprise_Report(Utility.getProperty("Store1"));

		//Select Last N days
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();


		Thread.sleep(8000);
		try
		{
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Sale Report Not Available for Last N days");
			excel.setreportData("Last N days", 2, 8, st);
			excel.setreportData("Last N days", 3, 8, st);
			excel.setreportData("Last N days", 4, 8, st);
			excel.setreportData("Last N days", 5, 8, st);
			excel.setreportData("Last N days", 6, 8, st);
			excel.setreportData("Last N days", 7, 8, st);
			excel.setreportData("Last N days", 8, 8, st);
			excel.setreportData("Last N days", 9, 8, st);
			excel.setreportData("Last N days", 10, 8, st);
			excel.setreportData("Last N days", 11, 8, st);
			excel.setreportData("Last N days", 12, 8, st);
			excel.setreportData("Last N days", 13, 8, st);

			excel.setreportData("Last N days", 2, 9, st);
			excel.setreportData("Last N days", 3, 9, st);
			excel.setreportData("Last N days", 4, 9, st);
			excel.setreportData("Last N days", 5, 9, st);
			excel.setreportData("Last N days", 6, 9, st);
			excel.setreportData("Last N days", 7, 9, st);
			excel.setreportData("Last N days", 8, 9, st);
			excel.setreportData("Last N days", 9, 9, st);
			excel.setreportData("Last N days", 10, 9, st);
			excel.setreportData("Last N days", 11, 9, st);
			excel.setreportData("Last N days", 12, 9, st);
			excel.setreportData("Last N days", 13, 9, st);

			excel.setreportData("Last N days", 39, 5, st);
			excel.setreportData("Last N days", 40, 5, st);
			excel.setreportData("Last N days", 41, 5, st);
			excel.setreportData("Last N days", 42, 5, st);
			excel.setreportData("Last N days", 43, 5, st);
			excel.setreportData("Last N days", 44, 5, st);
			excel.setreportData("Last N days", 45, 5, st);
			excel.setreportData("Last N days", 46, 5, st);
			excel.setreportData("Last N days", 47, 5, st);
			excel.setreportData("Last N days", 48, 5, st);
			excel.setreportData("Last N days", 49, 5, st);
			excel.setreportData("Last N days", 50, 5, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Enterprise Sale Report Available for Last N days");

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
			String Expeccted_SaleAmt=excel.getData("Last N days", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("Last N days", 2, 8, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Menu Item Sale Report is equal to Sale Recap Report for Last N days");
				excel.setreport_PassedData("Last N days", 2, 9, "0.00");
				excel.setreport_PassedData("Last N days", 39, 5, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Menu Item Sale Report is not equal to Sale Recap Report for Last N days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last N days", 2, 9,diff_value);
				 excel.setreport_FailedData("Last N days", 39, 5,diff_value);
			}

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[6]/span")).getText().replace(",", "");
				test.log(LogStatus.INFO, "Quantity for Menu Item Sale Report is displayed for Last N days and the value is : "+Qty);

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last N days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[7]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last N days", 3, 8, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Menu Item Sale Report is equal to Sale Recap Report for Last N days");
				excel.setreport_PassedData("Last N days", 3, 9, "0.00");
				excel.setreport_PassedData("Last N days", 40, 5, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Menu Item Sale Report is not equal to Sale Recap Report for Last N days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last N days", 3, 9,diff_value);
				 excel.setreport_FailedData("Last N days", 40, 5,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Last N days", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[8]/span")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Last N days", 4, 8, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Menu Item Sale Report is equal to Sale Recap Report for Last N days");
				excel.setreport_PassedData("Last N days", 4, 9, "0.00");
				excel.setreport_PassedData("Last N days", 41, 5, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Menu Item Sale Report is not equal to Sale Recap Report for Last N days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last N days", 4, 9,diff_value);
				 excel.setreport_FailedData("Last N days", 41, 5,diff_value);
			}

			//Get the Percentage of Sale
			String PerSale=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[9]/span")).getText().replace(",", "");
				test.log(LogStatus.PASS, "% of Sale for Menu Item Sale Report is displayed for Last N days and the value is : "+PerSale);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}

	
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_MenuItem_Report_This_Week(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		////SelectTheCat(driver);
		
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
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Sale Report Not Available for This Week");
			excel.setreportData("This Week", 2, 8, st);
			excel.setreportData("This Week", 3, 8, st);
			excel.setreportData("This Week", 4, 8, st);
			excel.setreportData("This Week", 5, 8, st);
			excel.setreportData("This Week", 6, 8, st);
			excel.setreportData("This Week", 7, 8, st);
			excel.setreportData("This Week", 8, 8, st);
			excel.setreportData("This Week", 9, 8, st);
			excel.setreportData("This Week", 10, 8, st);
			excel.setreportData("This Week", 11, 8, st);
			excel.setreportData("This Week", 12, 8, st);
			excel.setreportData("This Week", 13, 8, st);

			excel.setreportData("This Week", 2, 9, st);
			excel.setreportData("This Week", 3, 9, st);
			excel.setreportData("This Week", 4, 9, st);
			excel.setreportData("This Week", 5, 9, st);
			excel.setreportData("This Week", 6, 9, st);
			excel.setreportData("This Week", 7, 9, st);
			excel.setreportData("This Week", 8, 9, st);
			excel.setreportData("This Week", 9, 9, st);
			excel.setreportData("This Week", 10, 9, st);
			excel.setreportData("This Week", 11, 9, st);
			excel.setreportData("This Week", 12, 9, st);
			excel.setreportData("This Week", 13, 9, st);

			excel.setreportData("This Week", 39, 5, st);
			excel.setreportData("This Week", 40, 5, st);
			excel.setreportData("This Week", 41, 5, st);
			excel.setreportData("This Week", 42, 5, st);
			excel.setreportData("This Week", 43, 5, st);
			excel.setreportData("This Week", 44, 5, st);
			excel.setreportData("This Week", 45, 5, st);
			excel.setreportData("This Week", 46, 5, st);
			excel.setreportData("This Week", 47, 5, st);
			excel.setreportData("This Week", 48, 5, st);
			excel.setreportData("This Week", 49, 5, st);
			excel.setreportData("This Week", 50, 5, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Enterprise Sale Report Available for This Week");

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
			String Expeccted_SaleAmt=excel.getData("This Week", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("This Week", 2, 8, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Menu Item Sale Report is equal to Sale Recap Report for This Week");
				excel.setreport_PassedData("This Week", 2, 9, "0.00");
				excel.setreport_PassedData("This Week", 39, 5, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Menu Item Sale Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("This Week", 2, 9,diff_value);
				 excel.setreport_FailedData("This Week", 39, 5,diff_value);
			}

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[6]/span")).getText().replace(",", "");
				test.log(LogStatus.INFO, "Quantity for Menu Item Sale Report is displayed for This Week and the value is : "+Qty);

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("This Week", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[7]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("This Week", 3, 8, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Menu Item Sale Report is equal to Sale Recap Report for This Week");
				excel.setreport_PassedData("This Week", 3, 9, "0.00");
				excel.setreport_PassedData("This Week", 40, 5, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Menu Item Sale Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("This Week", 3, 9,diff_value);
				 excel.setreport_FailedData("This Week", 40, 5,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("This Week", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[8]/span")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("This Week", 4, 8, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Menu Item Sale Report is equal to Sale Recap Report for This Week");
				excel.setreport_PassedData("This Week", 4, 9, "0.00");
				excel.setreport_PassedData("This Week", 41, 5, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Menu Item Sale Report is not equal to Sale Recap Report for This Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("This Week", 4, 9,diff_value);
				 excel.setreport_FailedData("This Week", 41, 5,diff_value);
			}

			//Get the Percentage of Sale
			String PerSale=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[9]/span")).getText().replace(",", "");
				test.log(LogStatus.PASS, "% of Sale for Menu Item Sale Report is displayed for This Week and the value is : "+PerSale);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_MenuItem_Report_Last_Week(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		////SelectTheCat(driver);
		
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
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Sale Report Not Available for Last Week");
			excel.setreportData("Last Week", 2, 8, st);
			excel.setreportData("Last Week", 3, 8, st);
			excel.setreportData("Last Week", 4, 8, st);
			excel.setreportData("Last Week", 5, 8, st);
			excel.setreportData("Last Week", 6, 8, st);
			excel.setreportData("Last Week", 7, 8, st);
			excel.setreportData("Last Week", 8, 8, st);
			excel.setreportData("Last Week", 9, 8, st);
			excel.setreportData("Last Week", 10, 8, st);
			excel.setreportData("Last Week", 11, 8, st);
			excel.setreportData("Last Week", 12, 8, st);
			excel.setreportData("Last Week", 13, 8, st);

			excel.setreportData("Last Week", 2, 9, st);
			excel.setreportData("Last Week", 3, 9, st);
			excel.setreportData("Last Week", 4, 9, st);
			excel.setreportData("Last Week", 5, 9, st);
			excel.setreportData("Last Week", 6, 9, st);
			excel.setreportData("Last Week", 7, 9, st);
			excel.setreportData("Last Week", 8, 9, st);
			excel.setreportData("Last Week", 9, 9, st);
			excel.setreportData("Last Week", 10, 9, st);
			excel.setreportData("Last Week", 11, 9, st);
			excel.setreportData("Last Week", 12, 9, st);
			excel.setreportData("Last Week", 13, 9, st);

			excel.setreportData("Last Week", 39, 5, st);
			excel.setreportData("Last Week", 40, 5, st);
			excel.setreportData("Last Week", 41, 5, st);
			excel.setreportData("Last Week", 42, 5, st);
			excel.setreportData("Last Week", 43, 5, st);
			excel.setreportData("Last Week", 44, 5, st);
			excel.setreportData("Last Week", 45, 5, st);
			excel.setreportData("Last Week", 46, 5, st);
			excel.setreportData("Last Week", 47, 5, st);
			excel.setreportData("Last Week", 48, 5, st);
			excel.setreportData("Last Week", 49, 5, st);
			excel.setreportData("Last Week", 50, 5, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Enterprise Sale Report Available for Last Week");

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
			String Expeccted_SaleAmt=excel.getData("Last Week", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("Last Week", 2, 8, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Menu Item Sale Report is equal to Sale Recap Report for Last Week");
				excel.setreport_PassedData("Last Week", 2, 9, "0.00");
				excel.setreport_PassedData("Last Week", 39, 5, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Menu Item Sale Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last Week", 2, 9,diff_value);
				 excel.setreport_FailedData("Last Week", 39, 5,diff_value);
			}

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[6]/span")).getText().replace(",", "");
				test.log(LogStatus.INFO, "Quantity for Menu Item Sale Report is displayed for Last Week and the value is : "+Qty);

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last Week", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[7]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last Week", 3, 8, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Menu Item Sale Report is equal to Sale Recap Report for Last Week");
				excel.setreport_PassedData("Last Week", 3, 9, "0.00");
				excel.setreport_PassedData("Last Week", 40, 5, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Menu Item Sale Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last Week", 3, 9,diff_value);
				 excel.setreport_FailedData("Last Week", 40, 5,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Last Week", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[8]/span")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Last Week", 4, 8, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Menu Item Sale Report is equal to Sale Recap Report for Last Week");
				excel.setreport_PassedData("Last Week", 4, 9, "0.00");
				excel.setreport_PassedData("Last Week", 41, 5, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Menu Item Sale Report is not equal to Sale Recap Report for Last Week.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last Week", 4, 9,diff_value);
				 excel.setreport_FailedData("Last Week", 41, 5,diff_value);
			}

			//Get the Percentage of Sale
			String PerSale=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[9]/span")).getText().replace(",", "");
				test.log(LogStatus.PASS, "% of Sale for Menu Item Sale Report is displayed for Last Week and the value is : "+PerSale);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_MenuItem_Report_Last_7_Days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		////SelectTheCat(driver);
		
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
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Sale Report Not Available for Last 7 days");
			excel.setreportData("Last 7 days", 2, 8, st);
			excel.setreportData("Last 7 days", 3, 8, st);
			excel.setreportData("Last 7 days", 4, 8, st);
			excel.setreportData("Last 7 days", 5, 8, st);
			excel.setreportData("Last 7 days", 6, 8, st);
			excel.setreportData("Last 7 days", 7, 8, st);
			excel.setreportData("Last 7 days", 8, 8, st);
			excel.setreportData("Last 7 days", 9, 8, st);
			excel.setreportData("Last 7 days", 10, 8, st);
			excel.setreportData("Last 7 days", 11, 8, st);
			excel.setreportData("Last 7 days", 12, 8, st);
			excel.setreportData("Last 7 days", 13, 8, st);

			excel.setreportData("Last 7 days", 2, 9, st);
			excel.setreportData("Last 7 days", 3, 9, st);
			excel.setreportData("Last 7 days", 4, 9, st);
			excel.setreportData("Last 7 days", 5, 9, st);
			excel.setreportData("Last 7 days", 6, 9, st);
			excel.setreportData("Last 7 days", 7, 9, st);
			excel.setreportData("Last 7 days", 8, 9, st);
			excel.setreportData("Last 7 days", 9, 9, st);
			excel.setreportData("Last 7 days", 10, 9, st);
			excel.setreportData("Last 7 days", 11, 9, st);
			excel.setreportData("Last 7 days", 12, 9, st);
			excel.setreportData("Last 7 days", 13, 9, st);

			excel.setreportData("Last 7 days", 39, 5, st);
			excel.setreportData("Last 7 days", 40, 5, st);
			excel.setreportData("Last 7 days", 41, 5, st);
			excel.setreportData("Last 7 days", 42, 5, st);
			excel.setreportData("Last 7 days", 43, 5, st);
			excel.setreportData("Last 7 days", 44, 5, st);
			excel.setreportData("Last 7 days", 45, 5, st);
			excel.setreportData("Last 7 days", 46, 5, st);
			excel.setreportData("Last 7 days", 47, 5, st);
			excel.setreportData("Last 7 days", 48, 5, st);
			excel.setreportData("Last 7 days", 49, 5, st);
			excel.setreportData("Last 7 days", 50, 5, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Enterprise Sale Report Available for Last 7 days");

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
			String Expeccted_SaleAmt=excel.getData("Last 7 days", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("Last 7 days", 2, 8, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Menu Item Sale Report is equal to Sale Recap Report for Last 7 days");
				excel.setreport_PassedData("Last 7 days", 2, 9, "0.00");
				excel.setreport_PassedData("Last 7 days", 39, 5, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Menu Item Sale Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last 7 days", 2, 9,diff_value);
				 excel.setreport_FailedData("Last 7 days", 39, 5,diff_value);
			}

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[6]/span")).getText().replace(",", "");
				test.log(LogStatus.INFO, "Quantity for Menu Item Sale Report is displayed for Last 7 days and the value is : "+Qty);

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last 7 days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[7]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last 7 days", 3, 8, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Menu Item Sale Report is equal to Sale Recap Report for Last 7 days");
				excel.setreport_PassedData("Last 7 days", 3, 9, "0.00");
				excel.setreport_PassedData("Last 7 days", 40, 5, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Menu Item Sale Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last 7 days", 3, 9,diff_value);
				 excel.setreport_FailedData("Last 7 days", 40, 5,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Last 7 days", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[8]/span")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Last 7 days", 4, 8, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Menu Item Sale Report is equal to Sale Recap Report for Last 7 days");
				excel.setreport_PassedData("Last 7 days", 4, 9, "0.00");
				excel.setreport_PassedData("Last 7 days", 41, 5, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Menu Item Sale Report is not equal to Sale Recap Report for Last 7 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last 7 days", 4, 9,diff_value);
				 excel.setreport_FailedData("Last 7 days", 41, 5,diff_value);
			}

			//Get the Percentage of Sale
			String PerSale=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[9]/span")).getText().replace(",", "");
				test.log(LogStatus.PASS, "% of Sale for Menu Item Sale Report is displayed for Last 7 days and the value is : "+PerSale);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Enterprise_MenuItem_Report_This_Month(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		////SelectTheCat(driver);
		
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
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Sale Report Not Available for This month");
			excel.setreportData("This month", 2, 8, st);
			excel.setreportData("This month", 3, 8, st);
			excel.setreportData("This month", 4, 8, st);
			excel.setreportData("This month", 5, 8, st);
			excel.setreportData("This month", 6, 8, st);
			excel.setreportData("This month", 7, 8, st);
			excel.setreportData("This month", 8, 8, st);
			excel.setreportData("This month", 9, 8, st);
			excel.setreportData("This month", 10, 8, st);
			excel.setreportData("This month", 11, 8, st);
			excel.setreportData("This month", 12, 8, st);
			excel.setreportData("This month", 13, 8, st);

			excel.setreportData("This month", 2, 9, st);
			excel.setreportData("This month", 3, 9, st);
			excel.setreportData("This month", 4, 9, st);
			excel.setreportData("This month", 5, 9, st);
			excel.setreportData("This month", 6, 9, st);
			excel.setreportData("This month", 7, 9, st);
			excel.setreportData("This month", 8, 9, st);
			excel.setreportData("This month", 9, 9, st);
			excel.setreportData("This month", 10, 9, st);
			excel.setreportData("This month", 11, 9, st);
			excel.setreportData("This month", 12, 9, st);
			excel.setreportData("This month", 13, 9, st);

			excel.setreportData("This month", 39, 5, st);
			excel.setreportData("This month", 40, 5, st);
			excel.setreportData("This month", 41, 5, st);
			excel.setreportData("This month", 42, 5, st);
			excel.setreportData("This month", 43, 5, st);
			excel.setreportData("This month", 44, 5, st);
			excel.setreportData("This month", 45, 5, st);
			excel.setreportData("This month", 46, 5, st);
			excel.setreportData("This month", 47, 5, st);
			excel.setreportData("This month", 48, 5, st);
			excel.setreportData("This month", 49, 5, st);
			excel.setreportData("This month", 50, 5, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Enterprise Sale Report Available for This month");

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
			String Expeccted_SaleAmt=excel.getData("This month", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("This month", 2, 8, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Menu Item Sale Report is equal to Sale Recap Report for This month");
				excel.setreport_PassedData("This month", 2, 9, "0.00");
				excel.setreport_PassedData("This month", 39, 5, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Menu Item Sale Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("This month", 2, 9,diff_value);
				 excel.setreport_FailedData("This month", 39, 5,diff_value);
			}

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[6]/span")).getText().replace(",", "");
				test.log(LogStatus.INFO, "Quantity for Menu Item Sale Report is displayed for This month and the value is : "+Qty);

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("This month", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[7]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("This month", 3, 8, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Menu Item Sale Report is equal to Sale Recap Report for This month");
				excel.setreport_PassedData("This month", 3, 9, "0.00");
				excel.setreport_PassedData("This month", 40, 5, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Menu Item Sale Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("This month", 3, 9,diff_value);
				 excel.setreport_FailedData("This month", 40, 5,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("This month", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[8]/span")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("This month", 4, 8, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Menu Item Sale Report is equal to Sale Recap Report for This month");
				excel.setreport_PassedData("This month", 4, 9, "0.00");
				excel.setreport_PassedData("This month", 41, 5, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Menu Item Sale Report is not equal to Sale Recap Report for This month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("This month", 4, 9,diff_value);
				 excel.setreport_FailedData("This month", 41, 5,diff_value);
			}

			//Get the Percentage of Sale
			String PerSale=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[9]/span")).getText().replace(",", "");
				test.log(LogStatus.PASS, "% of Sale for Menu Item Sale Report is displayed for This month and the value is : "+PerSale);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_MenuItem_Report_Last_Month(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		////SelectTheCat(driver);
		
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
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Sale Report Not Available for Last month");
			excel.setreportData("Last month", 2, 8, st);
			excel.setreportData("Last month", 3, 8, st);
			excel.setreportData("Last month", 4, 8, st);
			excel.setreportData("Last month", 5, 8, st);
			excel.setreportData("Last month", 6, 8, st);
			excel.setreportData("Last month", 7, 8, st);
			excel.setreportData("Last month", 8, 8, st);
			excel.setreportData("Last month", 9, 8, st);
			excel.setreportData("Last month", 10, 8, st);
			excel.setreportData("Last month", 11, 8, st);
			excel.setreportData("Last month", 12, 8, st);
			excel.setreportData("Last month", 13, 8, st);

			excel.setreportData("Last month", 2, 9, st);
			excel.setreportData("Last month", 3, 9, st);
			excel.setreportData("Last month", 4, 9, st);
			excel.setreportData("Last month", 5, 9, st);
			excel.setreportData("Last month", 6, 9, st);
			excel.setreportData("Last month", 7, 9, st);
			excel.setreportData("Last month", 8, 9, st);
			excel.setreportData("Last month", 9, 9, st);
			excel.setreportData("Last month", 10, 9, st);
			excel.setreportData("Last month", 11, 9, st);
			excel.setreportData("Last month", 12, 9, st);
			excel.setreportData("Last month", 13, 9, st);

			excel.setreportData("Last month", 39, 5, st);
			excel.setreportData("Last month", 40, 5, st);
			excel.setreportData("Last month", 41, 5, st);
			excel.setreportData("Last month", 42, 5, st);
			excel.setreportData("Last month", 43, 5, st);
			excel.setreportData("Last month", 44, 5, st);
			excel.setreportData("Last month", 45, 5, st);
			excel.setreportData("Last month", 46, 5, st);
			excel.setreportData("Last month", 47, 5, st);
			excel.setreportData("Last month", 48, 5, st);
			excel.setreportData("Last month", 49, 5, st);
			excel.setreportData("Last month", 50, 5, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Enterprise Sale Report Available for Last month");

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
			String Expeccted_SaleAmt=excel.getData("Last month", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("Last month", 2, 8, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Menu Item Sale Report is equal to Sale Recap Report for Last month");
				excel.setreport_PassedData("Last month", 2, 9, "0.00");
				excel.setreport_PassedData("Last month", 39, 5, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Menu Item Sale Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last month", 2, 9,diff_value);
				 excel.setreport_FailedData("Last month", 39, 5,diff_value);
			}

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[6]/span")).getText().replace(",", "");
				test.log(LogStatus.INFO, "Quantity for Menu Item Sale Report is displayed for Last month and the value is : "+Qty);

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last month", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[7]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last month", 3, 8, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Menu Item Sale Report is equal to Sale Recap Report for Last month");
				excel.setreport_PassedData("Last month", 3, 9, "0.00");
				excel.setreport_PassedData("Last month", 40, 5, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Menu Item Sale Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last month", 3, 9,diff_value);
				 excel.setreport_FailedData("Last month", 40, 5,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Last month", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[8]/span")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Last month", 4, 8, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Menu Item Sale Report is equal to Sale Recap Report for Last month");
				excel.setreport_PassedData("Last month", 4, 9, "0.00");
				excel.setreport_PassedData("Last month", 41, 5, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Menu Item Sale Report is not equal to Sale Recap Report for Last month.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last month", 4, 9,diff_value);
				 excel.setreport_FailedData("Last month", 41, 5,diff_value);
			}

			//Get the Percentage of Sale
			String PerSale=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[9]/span")).getText().replace(",", "");
				test.log(LogStatus.PASS, "% of Sale for Menu Item Sale Report is displayed for Last month and the value is : "+PerSale);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_MenuItem_Report_Last_30_Days(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		////SelectTheCat(driver);
		
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
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Sale Report Not Available for Last 30 days");
			excel.setreportData("Last 30 days", 2, 8, st);
			excel.setreportData("Last 30 days", 3, 8, st);
			excel.setreportData("Last 30 days", 4, 8, st);
			excel.setreportData("Last 30 days", 5, 8, st);
			excel.setreportData("Last 30 days", 6, 8, st);
			excel.setreportData("Last 30 days", 7, 8, st);
			excel.setreportData("Last 30 days", 8, 8, st);
			excel.setreportData("Last 30 days", 9, 8, st);
			excel.setreportData("Last 30 days", 10, 8, st);
			excel.setreportData("Last 30 days", 11, 8, st);
			excel.setreportData("Last 30 days", 12, 8, st);
			excel.setreportData("Last 30 days", 13, 8, st);

			excel.setreportData("Last 30 days", 2, 9, st);
			excel.setreportData("Last 30 days", 3, 9, st);
			excel.setreportData("Last 30 days", 4, 9, st);
			excel.setreportData("Last 30 days", 5, 9, st);
			excel.setreportData("Last 30 days", 6, 9, st);
			excel.setreportData("Last 30 days", 7, 9, st);
			excel.setreportData("Last 30 days", 8, 9, st);
			excel.setreportData("Last 30 days", 9, 9, st);
			excel.setreportData("Last 30 days", 10, 9, st);
			excel.setreportData("Last 30 days", 11, 9, st);
			excel.setreportData("Last 30 days", 12, 9, st);
			excel.setreportData("Last 30 days", 13, 9, st);

			excel.setreportData("Last 30 days", 39, 5, st);
			excel.setreportData("Last 30 days", 40, 5, st);
			excel.setreportData("Last 30 days", 41, 5, st);
			excel.setreportData("Last 30 days", 42, 5, st);
			excel.setreportData("Last 30 days", 43, 5, st);
			excel.setreportData("Last 30 days", 44, 5, st);
			excel.setreportData("Last 30 days", 45, 5, st);
			excel.setreportData("Last 30 days", 46, 5, st);
			excel.setreportData("Last 30 days", 47, 5, st);
			excel.setreportData("Last 30 days", 48, 5, st);
			excel.setreportData("Last 30 days", 49, 5, st);
			excel.setreportData("Last 30 days", 50, 5, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Enterprise Sale Report Available for Last 30 days");

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
			String Expeccted_SaleAmt=excel.getData("Last 30 days", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("Last 30 days", 2, 8, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Menu Item Sale Report is equal to Sale Recap Report for Last 30 days");
				excel.setreport_PassedData("Last 30 days", 2, 9, "0.00");
				excel.setreport_PassedData("Last 30 days", 39, 5, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Menu Item Sale Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last 30 days", 2, 9,diff_value);
				 excel.setreport_FailedData("Last 30 days", 39, 5,diff_value);
			}

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[6]/span")).getText().replace(",", "");
				test.log(LogStatus.INFO, "Quantity for Menu Item Sale Report is displayed for Last 30 days and the value is : "+Qty);

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Last 30 days", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[7]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Last 30 days", 3, 8, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Menu Item Sale Report is equal to Sale Recap Report for Last 30 days");
				excel.setreport_PassedData("Last 30 days", 3, 9, "0.00");
				excel.setreport_PassedData("Last 30 days", 40, 5, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Menu Item Sale Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last 30 days", 3, 9,diff_value);
				 excel.setreport_FailedData("Last 30 days", 40, 5,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Last 30 days", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[8]/span")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Last 30 days", 4, 8, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Menu Item Sale Report is equal to Sale Recap Report for Last 30 days");
				excel.setreport_PassedData("Last 30 days", 4, 9, "0.00");
				excel.setreport_PassedData("Last 30 days", 41, 5, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Menu Item Sale Report is not equal to Sale Recap Report for Last 30 days.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Last 30 days", 4, 9,diff_value);
				 excel.setreport_FailedData("Last 30 days", 41, 5,diff_value);
			}

			//Get the Percentage of Sale
			String PerSale=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[9]/span")).getText().replace(",", "");
				test.log(LogStatus.PASS, "% of Sale for Menu Item Sale Report is displayed for Last 30 days and the value is : "+PerSale);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Enterprise_MenuItem_Report_Specific_Date(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		////SelectTheCat(driver);
		
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
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Sale Report Not Available for Specific Date");
			excel.setreportData("Specific Date", 2, 8, st);
			excel.setreportData("Specific Date", 3, 8, st);
			excel.setreportData("Specific Date", 4, 8, st);
			excel.setreportData("Specific Date", 5, 8, st);
			excel.setreportData("Specific Date", 6, 8, st);
			excel.setreportData("Specific Date", 7, 8, st);
			excel.setreportData("Specific Date", 8, 8, st);
			excel.setreportData("Specific Date", 9, 8, st);
			excel.setreportData("Specific Date", 10, 8, st);
			excel.setreportData("Specific Date", 11, 8, st);
			excel.setreportData("Specific Date", 12, 8, st);
			excel.setreportData("Specific Date", 13, 8, st);

			excel.setreportData("Specific Date", 2, 9, st);
			excel.setreportData("Specific Date", 3, 9, st);
			excel.setreportData("Specific Date", 4, 9, st);
			excel.setreportData("Specific Date", 5, 9, st);
			excel.setreportData("Specific Date", 6, 9, st);
			excel.setreportData("Specific Date", 7, 9, st);
			excel.setreportData("Specific Date", 8, 9, st);
			excel.setreportData("Specific Date", 9, 9, st);
			excel.setreportData("Specific Date", 10, 9, st);
			excel.setreportData("Specific Date", 11, 9, st);
			excel.setreportData("Specific Date", 12, 9, st);
			excel.setreportData("Specific Date", 13, 9, st);

			excel.setreportData("Specific Date", 39, 5, st);
			excel.setreportData("Specific Date", 40, 5, st);
			excel.setreportData("Specific Date", 41, 5, st);
			excel.setreportData("Specific Date", 42, 5, st);
			excel.setreportData("Specific Date", 43, 5, st);
			excel.setreportData("Specific Date", 44, 5, st);
			excel.setreportData("Specific Date", 45, 5, st);
			excel.setreportData("Specific Date", 46, 5, st);
			excel.setreportData("Specific Date", 47, 5, st);
			excel.setreportData("Specific Date", 48, 5, st);
			excel.setreportData("Specific Date", 49, 5, st);
			excel.setreportData("Specific Date", 50, 5, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Enterprise Sale Report Available for Specific Date");

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
			String Expeccted_SaleAmt=excel.getData("Specific Date", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("Specific Date", 2, 8, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Menu Item Sale Report is equal to Sale Recap Report for Specific Date");
				excel.setreport_PassedData("Specific Date", 2, 9, "0.00");
				excel.setreport_PassedData("Specific Date", 39, 5, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Menu Item Sale Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Specific Date", 2, 9,diff_value);
				 excel.setreport_FailedData("Specific Date", 39, 5,diff_value);
			}

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[6]/span")).getText().replace(",", "");
				test.log(LogStatus.INFO, "Quantity for Menu Item Sale Report is displayed for Specific Date and the value is : "+Qty);

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Specific Date", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[7]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Specific Date", 3, 8, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Menu Item Sale Report is equal to Sale Recap Report for Specific Date");
				excel.setreport_PassedData("Specific Date", 3, 9, "0.00");
				excel.setreport_PassedData("Specific Date", 40, 5, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Menu Item Sale Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Specific Date", 3, 9,diff_value);
				 excel.setreport_FailedData("Specific Date", 40, 5,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Specific Date", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[8]/span")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Specific Date", 4, 8, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Menu Item Sale Report is equal to Sale Recap Report for Specific Date");
				excel.setreport_PassedData("Specific Date", 4, 9, "0.00");
				excel.setreport_PassedData("Specific Date", 41, 5, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Menu Item Sale Report is not equal to Sale Recap Report for Specific Date.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Specific Date", 4, 9,diff_value);
				 excel.setreport_FailedData("Specific Date", 41, 5,diff_value);
			}

			//Get the Percentage of Sale
			String PerSale=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[9]/span")).getText().replace(",", "");
				test.log(LogStatus.PASS, "% of Sale for Menu Item Sale Report is displayed for Specific Date and the value is : "+PerSale);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Enterprise_MenuItem_Report_Date_Range(SelfHealingDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		////SelectTheCat(driver);
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
		if(repts.No_SaleFound_InfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Enterprise Sale Report Not Available for Date Range");
			excel.setreportData("Date Range", 2, 8, st);
			excel.setreportData("Date Range", 3, 8, st);
			excel.setreportData("Date Range", 4, 8, st);
			excel.setreportData("Date Range", 5, 8, st);
			excel.setreportData("Date Range", 6, 8, st);
			excel.setreportData("Date Range", 7, 8, st);
			excel.setreportData("Date Range", 8, 8, st);
			excel.setreportData("Date Range", 9, 8, st);
			excel.setreportData("Date Range", 10, 8, st);
			excel.setreportData("Date Range", 11, 8, st);
			excel.setreportData("Date Range", 12, 8, st);
			excel.setreportData("Date Range", 13, 8, st);

			excel.setreportData("Date Range", 2, 9, st);
			excel.setreportData("Date Range", 3, 9, st);
			excel.setreportData("Date Range", 4, 9, st);
			excel.setreportData("Date Range", 5, 9, st);
			excel.setreportData("Date Range", 6, 9, st);
			excel.setreportData("Date Range", 7, 9, st);
			excel.setreportData("Date Range", 8, 9, st);
			excel.setreportData("Date Range", 9, 9, st);
			excel.setreportData("Date Range", 10, 9, st);
			excel.setreportData("Date Range", 11, 9, st);
			excel.setreportData("Date Range", 12, 9, st);
			excel.setreportData("Date Range", 13, 9, st);

			excel.setreportData("Date Range", 39, 5, st);
			excel.setreportData("Date Range", 40, 5, st);
			excel.setreportData("Date Range", 41, 5, st);
			excel.setreportData("Date Range", 42, 5, st);
			excel.setreportData("Date Range", 43, 5, st);
			excel.setreportData("Date Range", 44, 5, st);
			excel.setreportData("Date Range", 45, 5, st);
			excel.setreportData("Date Range", 46, 5, st);
			excel.setreportData("Date Range", 47, 5, st);
			excel.setreportData("Date Range", 48, 5, st);
			excel.setreportData("Date Range", 49, 5, st);
			excel.setreportData("Date Range", 50, 5, st);
			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));
		}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "Enterprise Sale Report Available for Date Range");

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
			String Expeccted_SaleAmt=excel.getData("Date Range", 2, 1).toString().replace(",", "");
			double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);

			Thread.sleep(3000);
			//Get Sale Amount
			List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
			String SaleAmount=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span")).getText().replace(",", "");
			double ActualSale_Amount=Double.parseDouble(SaleAmount);

			//Export the Sale Amount value to Excel
			excel.setreportData("Date Range", 2, 8, SaleAmount);


			//Check whether the Sale Amount value is Equal or not
			if(Expected_SaleAmount==ActualSale_Amount)
			{
				test.log(LogStatus.PASS, "Sale Amount for Menu Item Sale Report is equal to Sale Recap Report for Date Range");
				excel.setreport_PassedData("Date Range", 2, 9, "0.00");
				excel.setreport_PassedData("Date Range", 39, 5, SaleAmount+"`");
			}
			else
			{
				double diff=Expected_SaleAmount-ActualSale_Amount;
				test.log(LogStatus.FAIL, "Sale Amount for Menu Item Sale Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Date Range", 2, 9,diff_value);
				 excel.setreport_FailedData("Date Range", 39, 5,diff_value);
			}

			//Get the Quantity
			String Qty=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[6]/span")).getText().replace(",", "");
				test.log(LogStatus.INFO, "Quantity for Menu Item Sale Report is displayed for Date Range and the value is : "+Qty);

			//Get the Tax from Sale Recap Report
			String Expeccted_Tx=excel.getData("Date Range", 3, 1).toString().replace(",", "");
			double Expected_Tax=Double.parseDouble(Expeccted_Tx);

			//Get the Tax
			String Tx=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[7]/span")).getText().replace(",", "");
			double ActualTax=Double.parseDouble(Tx);

			//Export Tax value to Excel
			excel.setreportData("Date Range", 3, 8, Tx);

			//Check whether the Tax value is Equal or not
			if(Expected_Tax==ActualTax)
			{
				test.log(LogStatus.PASS, "Tax for Menu Item Sale Report is equal to Sale Recap Report for Date Range");
				excel.setreport_PassedData("Date Range", 3, 9, "0.00");
				excel.setreport_PassedData("Date Range", 40, 5, Tx+"`");
			}
			else
			{
				double diff=Expected_Tax-ActualTax;
				test.log(LogStatus.FAIL, "Tax for Menu Item Sale Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Date Range", 3, 9,diff_value);
				 excel.setreport_FailedData("Date Range", 40, 5,diff_value);
			}

			//Get the Discount from Sale Recap Report
			String Expeccted_Discnt=excel.getData("Date Range", 4, 1).toString().replace(",", "");
			double Expected_Discount=Double.parseDouble(Expeccted_Discnt);

			//Get the Discount
			String Discnt=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[8]/span")).getText().replace(",", "");
			double ActualDiscount=Double.parseDouble(Discnt);

			//Export Discount value to Excel
			excel.setreportData("Date Range", 4, 8, Discnt);

			//Check whether the Tax value is Equal or not
			if(Expected_Discount==ActualDiscount)
			{
				test.log(LogStatus.PASS, "Discount for Menu Item Sale Report is equal to Sale Recap Report for Date Range");
				excel.setreport_PassedData("Date Range", 4, 9, "0.00");
				excel.setreport_PassedData("Date Range", 41, 5, Discnt+"`");
			}
			else
			{
				double diff=Expected_Discount-ActualDiscount;
				test.log(LogStatus.FAIL, "Discount for Menu Item Sale Report is not equal to Sale Recap Report for Date Range.The value diff is : "+diff);
				 String diff_value=String.valueOf(diff);
				 //Export the Sale Amount value to Excel
				 excel.setreport_FailedData("Date Range", 4, 9,diff_value);
				 excel.setreport_FailedData("Date Range", 41, 5,diff_value);
			}

			//Get the Percentage of Sale
			String PerSale=driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[9]/span")).getText().replace(",", "");
				test.log(LogStatus.PASS, "% of Sale for Menu Item Sale Report is displayed for Date Range and the value is : "+PerSale);

			excel.toWrite(Utility.getProperty("Excel_Sheet_Path_Enterprise_Report"));


			Thread.sleep(3000);

		}
	}
}
