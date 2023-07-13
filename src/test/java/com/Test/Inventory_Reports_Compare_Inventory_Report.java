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

public class Inventory_Reports_Compare_Inventory_Report 
{

public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Reports - Compare Inventory");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();

	String SM,st = "NA";
	
	double BeginQua, BeginPri,OnHandQua, OnHandPri;
	
	
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
		Open_Compare_Inventory_Report_Page(driver);
		RefreshAndPaginination(driver);
		Compare_Inventory_Report_Today(driver);
		Compare_Inventory_Report_Yesterday(driver);
		Compare_Inventory_Report_Last_N_Days(driver);
		Compare_Inventory_Report_This_Week(driver);
		Compare_Inventory_Report_Last_Week(driver);
		Compare_Inventory_Report_Last_7_Days(driver);
		Compare_Inventory_Report_This_Month(driver);
		Compare_Inventory_Report_Last_Month(driver);
		Compare_Inventory_Report_Last_30_Days(driver);
		Compare_Inventory_Report_Specific_Date(driver);
		Compare_Inventory_Report_Date_Range(driver);

	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Compare_Inventory_Report_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Menu Item sales report page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"inventoryReports/compareInventory");

		Thread.sleep(5000);
		//Verify the void transactions report page loeded or not
		repts.Verify_ReportHomePage("COMPARE INVENTORY");
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		List<WebElement> menuList=driver.findElements(By.xpath("//tbody/tr"));

		int menuSize=menuList.size();

		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);

		String s = driver.findElement(By.xpath("//tbody/tr["+randomMenu+"]/td[1]")).getText().trim();
		
		SM = s;
		
		//Clear the Search
		driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
		
		//Enter the Search value
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(s);
		
		Thread.sleep(3000);
		
		if(driver.findElement(By.xpath("//tbody/tr[1]/td[1]")).getText().trim().equals(s)) {
			test.log(LogStatus.PASS, "The required item is displayed while searching");
		}else {
			test.log(LogStatus.FAIL, "The required item is not displayed while searching");
		}
		
		
		//Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns_Table1();
	}
	
	@Test(priority = 4,enabled = false)
	public void SelectTheType_ALL(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);	
		//Click the Type
		driver.findElement(By.xpath("(//span[contains(.,'Type')]/../input)")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option/div[contains(.,'ALL')]")).click();
		Thread.sleep(500);
	}
	
	@Test(priority = 4,enabled = false)
	public void SelectTheType_InventoryItem(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);	
		//Click the Type
		driver.findElement(By.xpath("(//span[contains(.,'Type')]/../input)")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option/div[contains(.,'Inventory Item')]")).click();
		Thread.sleep(500);
	}
	
	@Test(priority = 4,enabled = false)
	public void SelectTheType_RetailItem(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);	
		//Click the Type
		driver.findElement(By.xpath("(//span[contains(.,'Type')]/../input)")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option/div[contains(.,'Retail Item')]")).click();
		Thread.sleep(500);
	}
	
	@Test(priority = 4,enabled = false)
	public void SelectTheType_SubRecipe(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);	
		//Click the Type
		driver.findElement(By.xpath("(//span[contains(.,'Type')]/../input)")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option/div[contains(.,'Sub Recipe')]")).click();
		Thread.sleep(500);
	}
	
	public void Search(WebDriver driver) throws Exception
	{
		//Clear the Search
		driver.findElement(By.xpath("//input[@placeholder='Search']")).clear();
		
		//Enter the Search value
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(SM);
		
		Thread.sleep(3000);
		for(int i = 1; i <= 4; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}Thread.sleep(1000);
	}
	
	@Test(priority = 4,enabled = false)
	public void SelectTheType_MenuItem(WebDriver driver) throws Exception
	{
		Thread.sleep(5000);	
		//Click the Type
		driver.findElement(By.xpath("(//span[contains(.,'Type')]/../input)")).click();
		Thread.sleep(500);
		//Select the All option
		driver.findElement(By.xpath("//select-option/div[contains(.,'Menu Item')]")).click();
		Thread.sleep(500);
	}
	
	@Test(priority = 4,enabled = false)
	public void verifyTheValues(WebDriver driver) throws Exception
	{
		//get the value of Usage quantity
		String UQ = driver.findElement(By.xpath("//tbody/tr/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double uq1 = Double.parseDouble(UQ);
		
		//get the value of Ideal Used Quantity
		String IUQ = driver.findElement(By.xpath("//tbody/tr/td[7]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double iuq1 = Double.parseDouble(IUQ);
		
		//get the value of Adjusted/Actual Quantity
		String AQ = driver.findElement(By.xpath("//tbody/tr/td[9]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double aq1 = Double.parseDouble(AQ);
		
		double uq_C = iuq1 + aq1;
		
		if(uq1 == uq_C) {
			test.log(LogStatus.PASS, "The displayed Usage Quantity is Correct with its calculation and the value is : "+uq_C);
		}
		else {
			double diff = uq_C - uq1;
			test.log(LogStatus.INFO, "The displayed Usage Quantity is : "+uq1);
			test.log(LogStatus.INFO, "The displayed Ideal Used Quantity is : "+iuq1);
			test.log(LogStatus.INFO, "The displayed Adjusted/Actual Quantity is : "+aq1);
			test.log(LogStatus.FAIL, "The displayed Usage Quantity is not Correct with its calculation, the difference is : "+diff);
		}
		
		//get the value of Usage price
		String UP = driver.findElement(By.xpath("//tbody/tr/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double up1 = Double.parseDouble(UP);
		
		//get the value of Ideal Used Price
		String IUP = driver.findElement(By.xpath("//tbody/tr/td[8]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double iup1 = Double.parseDouble(IUP);
		
		//get the value of Adjusted/Actual Price
		String AP = driver.findElement(By.xpath("//tbody/tr/td[10]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double ap1 = Double.parseDouble(AP);
		
		double up_C = iup1 - ap1;
		
		if(up1 == up_C) {
			test.log(LogStatus.PASS, "The displayed Usage Price is Correct with its calculation and the value is : "+up_C);
		}
		else {
			double diff = up_C - up1;
			test.log(LogStatus.INFO, "The displayed Usage Price is : "+up1);
			test.log(LogStatus.INFO, "The displayed Ideal Used Price is : "+iup1);
			test.log(LogStatus.INFO, "The displayed Adjusted/Actual Price is : "+ap1);
			test.log(LogStatus.FAIL, "The displayed Usage Price is not Correct with its calculation, the difference is : "+diff);
		}
		
		//get the value of On-hand Quantity
		String OHQ = driver.findElement(By.xpath("//tbody/tr/td[21]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double ohq1 = Double.parseDouble(OHQ);
		
		//get the value of Beginning Quantity
		String BQ = driver.findElement(By.xpath("//tbody/tr/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double bq1 = Double.parseDouble(BQ);
		
		//get the value of Purchase Quantity
		String PQ = driver.findElement(By.xpath("//tbody/tr/td[5]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double pq1 = Double.parseDouble(PQ);
		
		//get the value of Usage Quantity
		String UQA = driver.findElement(By.xpath("//tbody/tr/td[15]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double uqa1 = Double.parseDouble(UQA);
		
		//get the value of Transfer In Quantity
		String TIQ = driver.findElement(By.xpath("//tbody/tr/td[17]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double tiq1 = Double.parseDouble(TIQ);
		
		//get the value of Transfer Out Quantity
		String TOQ = driver.findElement(By.xpath("//tbody/tr/td[19]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double toq1 = Double.parseDouble(TOQ);
		
		double ohq_C = bq1 + pq1 - uqa1 +tiq1 - toq1;
		
		if(ohq1 == ohq_C) {
			test.log(LogStatus.PASS, "The displayed On-Hand Quantity is Correct with its calculation and the value is : "+ohq_C);
		}
		else {
			double diff = ohq_C - ohq1;
			test.log(LogStatus.INFO, "The displayed On-hand Quantity is : "+ohq1);
			test.log(LogStatus.INFO, "The displayed Beginning Quantity is : "+bq1);
			test.log(LogStatus.INFO, "The displayed Purchase Quantity is : "+pq1);
			test.log(LogStatus.INFO, "The displayed Usage Quantity is : "+uq1);
			test.log(LogStatus.INFO, "The displayed Transfer In Quantity is : "+tiq1);
			test.log(LogStatus.INFO, "The displayed Transfer Out Quantity is : "+toq1);
			test.log(LogStatus.FAIL, "The displayed On-Hand Quantity is not Correct with its calculation, the difference is : "+diff);
		}
		
		//get the value of on-hand Price
		String OHP = driver.findElement(By.xpath("//tbody/tr/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double ohp1 = Double.parseDouble(OHP);
		
		//get the value of Beginning Price
		String BP = driver.findElement(By.xpath("//tbody/tr/td[4]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double bp1 = Double.parseDouble(BP);
		
		//get the value of Purchase Price
		String PP = driver.findElement(By.xpath("//tbody/tr/td[6]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double pp1 = Double.parseDouble(PP);
		
		//get the value of Usage Price
		String UPA = driver.findElement(By.xpath("//tbody/tr/td[16]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double upa1 = Double.parseDouble(UPA);
		
		//get the value of Transfer In Price
		String TIP = driver.findElement(By.xpath("//tbody/tr/td[18]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double tip1 = Double.parseDouble(TIP);
		
		//get the value of Transfer Out Price
		String TOP = driver.findElement(By.xpath("//tbody/tr/td[20]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
		
		double top1 = Double.parseDouble(TOP);
		
		double ohp_C = bp1 + pp1 - upa1 +tip1 - top1;
		
		if(ohp1 == ohp_C) {
			test.log(LogStatus.PASS, "The displayed On-Hand Price is Correct with its calculation and the value is : "+ohp_C);
		}
		else {
			double diff = ohp_C - ohp1;
			test.log(LogStatus.INFO, "The displayed On-hand Price is : "+ohp1);
			test.log(LogStatus.INFO, "The displayed Beginning Price is : "+bp1);
			test.log(LogStatus.INFO, "The displayed Purchase Price is : "+pp1);
			test.log(LogStatus.INFO, "The displayed Usage Price is : "+up1);
			test.log(LogStatus.INFO, "The displayed Transfer In Price is : "+tip1);
			test.log(LogStatus.INFO, "The displayed Transfer Out Price is : "+top1);
			test.log(LogStatus.FAIL, "The displayed On-Hand Price is not Correct with its calculation, the difference is : "+diff);
		}
	}
	

	
	@Test(priority = 4,enabled = false)
	public void Compare_Inventory_Report_Today(WebDriver driver) throws Exception
	{
		test.log(LogStatus.INFO, "************************************************** COMPARE INVENTORY(Start) **************************************************");

		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	//	ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		SelectTheType_ALL(driver);
		
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
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Today");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Today *****************************");
			
			Search(driver);
			Thread.sleep(2000);
			//get the value of begin Quantity
			String d = driver.findElement(By.xpath("//tbody/tr/td[3]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
			
			double d1 = Double.parseDouble(d);
			
			test.log(LogStatus.INFO, "The Beginning Quantity of Today is : "+d1);
			
			BeginQua = d1;
			
			//get the value of begin price
			String e = driver.findElement(By.xpath("//tbody/tr/td[4]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
			
			double e1 = Double.parseDouble(e);
			
			test.log(LogStatus.INFO, "The Beginning Price of Today is : "+e1);
			
			BeginPri = e1;
			
			//System.out.println("Beginning quantity111111wwwwww is : "+BeginQua);
			//System.out.println("Beginning Price111111wwwwww is : "+BeginPri);
			
			verifyTheValues(driver);
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Compare_Inventory_Report_Yesterday(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
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
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Yesterday");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Yesterday *****************************");

			Thread.sleep(2000);
			Search(driver);
			Thread.sleep(2000);
			//get the value of on-hand Quantity
			String d = driver.findElement(By.xpath("//tbody/tr/td[21]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
			
			double d1 = Double.parseDouble(d);
			
			test.log(LogStatus.INFO, "The On-Hand Quantity of Yesterday is : "+d1);
			
			
			//get the value of begin price
			String e = driver.findElement(By.xpath("//tbody/tr/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
			
			double e1 = Double.parseDouble(e);
			
			test.log(LogStatus.INFO, "The On-Hand Price of Yesterday is : "+e1);
			
			//System.out.println("Beginning quantity111111 is : "+BeginQua);
			//System.out.println("Beginning Price111111 is : "+BeginPri);
			if(d1 == BeginQua) {
				test.log(LogStatus.PASS, "The displayed On-Hand Quantity(Yesterday) is correct with Beginning Quantity(Today)");
			}
			else {
				double diff = d1 - BeginQua;
				test.log(LogStatus.FAIL, "The displayed On-Hand Quantity(Yesterday) is correct with Beginning Quantity(Today), the difference is : "+diff);
			}
			
			if(e1 == BeginPri) {
				test.log(LogStatus.PASS, "The displayed On-Hand Price(Yesterday) is correct with Beginning Price(Today)");
			}
			else {
				double diff = e1 - BeginPri;
				test.log(LogStatus.FAIL, "The displayed On-Hand Price(Yesterday) is correct with Beginning Price(Today), the difference is : "+diff);
			}
			
			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Compare_Inventory_Report_Last_N_Days(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
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
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Last N Days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Last N days *****************************");

			Search(driver);
			Thread.sleep(2000);
			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	
	
	@Test(priority = 4,enabled = false)
	public void Compare_Inventory_Report_This_Week(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
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
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for This Week");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for This Week *****************************");

			Search(driver);
			Thread.sleep(2000);
			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Compare_Inventory_Report_Last_Week(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
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
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Last Week");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Last Week *****************************");

			Search(driver);
			Thread.sleep(2000);
			
			verifyTheValues(driver);
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Compare_Inventory_Report_Last_7_Days(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
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
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Last 7 days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Last 7 days *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Compare_Inventory_Report_This_Month(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
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
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for This month");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for This month *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Compare_Inventory_Report_Last_Month(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
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
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Last month");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Last month *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Compare_Inventory_Report_Last_30_Days(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
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
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Last 30 days");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Last 30 days *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
		
	@Test(priority = 4,enabled = false)
	public void Compare_Inventory_Report_Specific_Date(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
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
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Specific Date");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Specific Date *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Compare_Inventory_Report_Date_Range(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		//ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
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
				test.log(LogStatus.INFO, "Compare Inventory Report Not Available for Date Range");ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			test.log(LogStatus.PASS, "***************************** Compare Inventory Report Available for Date Range *****************************");

			Search(driver);
			Thread.sleep(2000);

			verifyTheValues(driver);
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}			test.log(LogStatus.INFO, "************************************************** COMPARE INVENTORY(End) **************************************************");
	}

}
