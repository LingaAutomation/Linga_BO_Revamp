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

import com.Pages.Common_XPaths;
import com.Pages.Enterprse_Settings_Theme_Page;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Enterprise_Settings_Theme {
	
	
	public SelfHealingDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise Setting - Theme");

	LoginPage lgpg;

	Utility ut = new Utility();

	String st = "NA";

	Common_XPaths cmp;
	Enterprse_Settings_Theme_Page EST;
	ReportsPage rp;
	
	LoginTest a = new LoginTest();

	@AfterClass
	public void flushTest() throws Exception {
		Thread.sleep(2000);
		rep.endTest(test);
		rep.flush();
	}

	@AfterMethod
	public void TestFail(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			String scnsht = ((TakesScreenshot) driver.getDelegate()).getScreenshotAs(OutputType.BASE64);

			String s = "data:image/png;base64," + scnsht;

			test.log(LogStatus.FAIL, test.addScreenCapture(s));

		}
	}

	@Test(priority = 1)
	public void Login() throws Exception {

		Thread.sleep(2000);
		// Call the chrome driver
		// System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
		// Open the Chrome window
		/*
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().driverVersion("110.0.5481").setup();
		driver = new ChromeDriver(chromeOptions);
		*/

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		
		options.setHeadless(false);
		
		WebDriver delegate=new ChromeDriver();
		
		driver=SelfHealingDriver.create(delegate);
		
//		System.setProperty("webdriver.chrome.driver", "./Automation Driver/chromedriver.exe");
//		// Open the Chrome window
//		driver = new ChromeDriver();
		// Wait for 30 seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the Chrome window
		driver.manage().window().maximize();
		Thread.sleep(1000);
		// Launch the URL
		driver.get(Utility.getProperty("appURL"));

		Thread.sleep(10000);
		a.Login(driver, test);
	}

	@Test(priority = 50)
	public void LogOut() throws Exception {
		a.LogOut(driver, test);
	}

	@Test(priority = 2)
	public void Calling() throws Exception {
		Open_Theme_Page(driver);
	}
	
	
	@Test(priority = 3, enabled = false)
	public void Open_Theme_Page(SelfHealingDriver driver) throws Exception {

		cmp = new Common_XPaths(driver, test);
		EST = new Enterprse_Settings_Theme_Page(driver, test);
		

		Thread.sleep(5000);
		// Load the Menu Item sales report page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id4") + "summary");

		Thread.sleep(5000);
		
		EST.Theme_button();
		
		if(EST.Verify_Choose_your_theme_color().isDisplayed()) {
			
			test.log(LogStatus.PASS, "theme page is displayed ");
		}

		else {
			test.log(LogStatus.FAIL, "theme page is not displayed ");
		}

		
		EST.Select_random_Colour();
		
		if(EST.Verify_Choose_Your_theme().isDisplayed()) {
			
			test.log(LogStatus.PASS, "Choose theme header is displayed ");
		}

		else {
			test.log(LogStatus.FAIL, "Choose theme header is not displayed ");
		}
		
		EST.Select_Light_theme();
		
		EST.Select_Dark_theme();
		
		
		
		
		
	}
	
	

}
