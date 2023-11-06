package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.Settings_Additional_Settings_Page;
import com.epam.healenium.SelfHealingDriver;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Additional 
{
	public SelfHealingDriver driver;


	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Addtional Settings");

	LoginPage lgpg; 
	Utility ut=new Utility();
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Settings_Additional_Settings_Page as;


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
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver(chromeOptions);
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
		Thread.sleep(1000);
		Navigating_Additional_Settings(driver);
		Thread.sleep(2000);
		Enable_And_Save_Additional_Settings(driver);
		Thread.sleep(2000);
		Disable_And_Save_Additional_Settings(driver);
		Thread.sleep(2000);
		Navigating_Back(driver);
	}

	@Test(priority=3,enabled = false)
	public void Navigating_Additional_Settings(SelfHealingDriver driver) throws Exception 
	{
		//Common_XPaths cmp = new Common_XPaths(driver, test);
		//Settings_Additional_Settings_Page as = new Settings_Additional_Settings_Page(driver, test);
		
		Thread.sleep(15000);
		//load the Notifications page
		Thread.sleep(2000);
		driver.get(Utility.getProperty("baseURL")+"settings/"+"additionalSettings");
		Thread.sleep(5000);
//
//		as.Click_Setting();
//		Thread.sleep(1000);
//		as.Click_Additional_Settings();
		Thread.sleep(5000);
		try {
			if(driver.findElement(By.xpath("//h3[contains(.,'Additional Settings')]")).isDisplayed()) {
				test.log(LogStatus.PASS, "Additional Settings page is loaded successfully");
			}
		}catch(Exception E) {
			test.log(LogStatus.FAIL, "Additional Settings page is not loaded");
		}
		
	}
	@Test(priority=4,enabled = false)
	public void Enable_And_Save_Additional_Settings(SelfHealingDriver driver) throws Exception 
	{
		Thread.sleep(8000);
		//Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_Additional_Settings_Page as = new Settings_Additional_Settings_Page(driver, test);
		as.Selecting_Include_Credits_No();
		as.Selecting_Include_Credits_Yes();
		Thread.sleep(2000);
		as.Click_Save();
		as.Selecting_Employee_Tipout_No();
		as.Selecting_Employee_Tipout_Yes();
		Thread.sleep(2000);
		as.Click_Save();
		Thread.sleep(3000);
		as.Selecting_Auto_Close_No();
		as.Selecting_Auto_Close_Yes();
		Thread.sleep(2000);
		as.Click_Save();
		Thread.sleep(3000);
		driver.navigate().refresh();
		
	}
	@Test(priority=5,enabled = false)
	public void Disable_And_Save_Additional_Settings(SelfHealingDriver driver) throws Exception
	{
		//Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_Additional_Settings_Page as = new Settings_Additional_Settings_Page(driver, test);
		as.Selecting_Include_Credits_No();
		Thread.sleep(2000);
		as.Click_Save();
		Thread.sleep(2000);
		as.Selecting_Employee_Tipout_No();
		Thread.sleep(2000);
		as.Click_Save();
		Thread.sleep(3000);
		as.Selecting_Auto_Close_No();
		Thread.sleep(2000);
		as.Click_Save();
		Thread.sleep(3000);
		
		driver.navigate().refresh();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=6,enabled = false)
	public void Navigating_Back(SelfHealingDriver driver) throws Exception 
	{
		//Common_XPaths cmp = new Common_XPaths(driver, test);
		Settings_Additional_Settings_Page as = new Settings_Additional_Settings_Page(driver, test);
		as.Navigating_Back();
		Thread.sleep(2000);
		
	}

}
