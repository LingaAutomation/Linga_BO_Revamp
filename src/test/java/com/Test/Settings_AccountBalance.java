package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import com.Pages.Settings_AccountBalance_Page;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_AccountBalance {
	public WebDriver driver;
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Account Balance Settings");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Settings_AccountBalance_Page ab;
	
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
		Open_AcontBal_Page(driver);
		Edit_Details(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_AcontBal_Page(WebDriver driver) throws Exception
	{
		
		ab=new Settings_AccountBalance_Page(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		Thread.sleep(5000);
		//Load the Label Printer page
		driver.get(Utility.getProperty("baseURL")+"settings/"+"accountBalance");
		Thread.sleep(5000);
		
		//Verify the Account Balance page loaded or not
		cmp.VerifyMainScreenPageHeader("Account Balance");
	}
	@Test(priority = 3,enabled = false)
	public void Edit_Details(WebDriver driver) throws Exception
	{
		ab.Edit_PaidOut();
		Thread.sleep(3000);
		
		ab.Edit_CCTip();
		Thread.sleep(3000);
		
		ab.Edit_Refund();
		Thread.sleep(3000);
		
		ab.Edit_deposite();
		Thread.sleep(3000);
		
		ab.Edit_ovr_shortage();
		Thread.sleep(3000);
		
		ab.Edit_sales_opn_itm();
		Thread.sleep(3000);
		
		ab.Edit_combo_dis();
		Thread.sleep(3000);
		
		ab.Edit_comp_dis();
		Thread.sleep(3000);
		
		ab.Edit_delevry_charge();
		Thread.sleep(3000);
		
		ab.Edit_HA_GC();
		Thread.sleep(3000);
		
		ab.Edit_Drivr_tip();
		Thread.sleep(3000);
		
		ab.Edit_gratiuty_tip();
		Thread.sleep(3000);
	   
		ab.Edit_promo_dis();
		Thread.sleep(3000);
		
		ab.Edit_donation_dis();
		Thread.sleep(3000);
		
		ab.Edit_loyality_dis();
		Thread.sleep(3000);
		
	}
}
