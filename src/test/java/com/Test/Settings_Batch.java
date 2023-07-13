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

import com.Pages.Settings_Batch_Settings_Page;
import com.Pages.Settings_NotificationsPage;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Batch 
{
	public WebDriver driver;


	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Batch Settings");

	LoginPage lgpg; 
	Utility ut=new Utility();
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Settings_Batch_Settings_Page bs;


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
		Navigating_To_Settings_Batch_Settings_Page(driver);
		Thread.sleep(1000);
		Enable_Auto_Batch_YesToggle(driver);
		Thread.sleep(1000);
		Enable_Auto_Batch_NoToggle(driver);
		Thread.sleep(1000);
		Selecting_Auto_Batch_Submit_Device(driver);
		Thread.sleep(1000);
		Selecting_Batch_Payment_Device(driver);
		Thread.sleep(1000);
		Selecting_Rows_Per_Page(driver);
		Thread.sleep(1000);
		Handiling_Pagination(driver);
		Thread.sleep(1000);
		//Sorting_Columns(driver);
		Thread.sleep(1000);
		//Searching_delete_Node(driver);
	    Thread.sleep(1000);
		Navigating_Back(driver);
		
	}

	@Test(priority = 3,enabled = false)
	public void Navigating_To_Settings_Batch_Settings_Page(WebDriver driver) throws Exception 
	{
    	cmp= new Common_XPaths(driver,test);
   	    bs= new Settings_Batch_Settings_Page(driver, test);

		Thread.sleep(5000);
		//load the Notifications page
		Thread.sleep(2000);
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("Store_Id2"));
   	   bs.Click_Settings();
   	   Thread.sleep(2000);
   	   bs.Click_BatchSettings();
   	   Thread.sleep(2000);
	}
	@Test(priority = 4,enabled = false)
	public void Enable_Auto_Batch_YesToggle(WebDriver driver) throws Exception 
	{
		for(int i=1;i<=3;i++)
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		Thread.sleep(2000);
		bs.Click_Enable_AutoBatch_YesToggle();
		Thread.sleep(2000);
		bs.Save();
		Thread.sleep(5000);
		for(int i=1;i<=3;i++)
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		bs.Click_TimePicker_AM();
		Thread.sleep(2000);
		bs.Save();
		Thread.sleep(5000);
		bs.Click_TimePicker_PM();
		bs.Save();
		Thread.sleep(5000);
		bs.Click_TimePicker_Cancle();
		bs.Save();
		Thread.sleep(5000);
	}
	@Test(priority = 5,enabled = false)
	public void Enable_Auto_Batch_NoToggle(WebDriver driver) throws Exception 
	{
		for(int i=1;i<=3;i++)
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		bs.Click_Enable_AutoBatch_No();
		Thread.sleep(2000);
		bs.Save();
		Thread.sleep(5000);
		
	}
	@Test(priority = 6,enabled = false)
	public void Selecting_Auto_Batch_Submit_Device(WebDriver driver) throws Exception
	{
		bs.Click_Batch_Submit_Device_DropDown();
		Thread.sleep(2000);
		try {
		bs.Clicking_Node1();
		bs.Save();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(3000);

			bs.Click_Batch_Submit_Device_DropDown();
			Thread.sleep(2000);
			bs.Clicking_Node2();
			Thread.sleep(2000);
			bs.Save();
		}catch(Exception d) {
			test.log(LogStatus.INFO, "Node is not available");
		}

		Thread.sleep(3000);
	 }
	@Test(priority = 7,enabled = false)
	public void Selecting_Batch_Payment_Device(WebDriver driver) throws Exception 
	{
		bs.Click_Batch_Payment_Device();
		Thread.sleep(2000);
		bs.clicking_Payment1();
		Thread.sleep(2000);
		bs.Save();
		Thread.sleep(5000);
		driver.navigate().refresh();
		Thread.sleep(5000);
		bs.Click_Batch_Payment_Device();
		Thread.sleep(2000);
		bs.Clicking_Payment2();
		Thread.sleep(2000);
		bs.Save();
		Thread.sleep(5000);
	}
	@Test(priority = 8,enabled = false)
	public void Selecting_Rows_Per_Page(WebDriver driver) throws Exception
	{
		for(int i=1;i<=6;i++)
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(5000);bs.Selecting_Rows_DropDown();
		Thread.sleep(2000);
		bs.Selecting_Rows10();
		bs.Save();
		Thread.sleep(5000);
		bs.Selecting_Rows_DropDown();
		Thread.sleep(2000);
		bs.Selecting_Rows5();
		bs.Save();
		Thread.sleep(4000);
	}
	@Test(priority = 9,enabled = false)
	public void Searching_delete_Node(WebDriver driver) throws Exception 
	{
		for(int i=1;i<=3;i++)
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		bs.Search_and_Delete();
		Thread.sleep(4000);
		
	}
	@Test(priority = 10,enabled = false)
	public void Handiling_Pagination(WebDriver driver) throws Exception
	{
		bs.Pagination();
		Thread.sleep(1000);
		bs.Save();
		Thread.sleep(4000);
	}
	@Test(priority = 11,enabled = false)
	public void Sorting_Columns(WebDriver driver) throws Exception
	{
		for(int i=1;i<=6;i++)
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		bs.Sorting_TicketNo();
		Thread.sleep(3000);
		bs.Sorting_Amount();
		Thread.sleep(3000);
		bs.Sorting_TipAmount();
		Thread.sleep(3000);
		
	}
	@Test(priority = 12,enabled = false)
	public void Navigating_Back(WebDriver driver) throws Exception
	{
		bs.Navigate_Back();
		Thread.sleep(3000);
		
	}

	
}
