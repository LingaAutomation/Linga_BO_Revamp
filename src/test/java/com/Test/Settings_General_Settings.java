package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.Common_XPaths;
import com.Pages.GeneralSetting_page;
import com.Pages.LoginPage;
import com.Pages.SortMenuConfigPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;

public class Settings_General_Settings 
{
	public WebDriver driver;


	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("General settings");

	LoginPage lgpg; 
	Utility ut=new Utility();
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	GeneralSetting_page gs;


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
		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
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
		open_general_settings_page(driver);
		modifying_settings(driver);
		updating_settings(driver);
	}

	@Test(priority =3,enabled = false)
	public void open_general_settings_page(WebDriver driver) throws Exception 
	{
		cmp=new Common_XPaths(driver, test);
		gs = new GeneralSetting_page (driver,test);

		Thread.sleep(5000);
		//Load the General settingspage
		driver.get(Utility.getProperty("baseURL"));
		gs.NavigatingSettings();
		gs.NavigateGeneralSetting();
		Thread.sleep(5000);

		//verify General settings page loaded or not
		Thread.sleep(3000);
		//cmp.VerifyMainScreenPageHeader("General Settings");

	}
	
	@Test(priority = 4,enabled = false) 
	public void modifying_settings(WebDriver driver) throws Exception
	{

		cmp=new Common_XPaths(driver, test);
		gs = new GeneralSetting_page (driver,test);

		Thread.sleep(5000);


		//Thread.sleep(2000);
		//gs.preferredNetwork();

		Thread.sleep(1000);
		gs.EnablingTipScreen();
		//gs.Enabling_Intranet_Sync();
		//gs.preferredNetwork();
		gs.Enabling_PreAuth();
		gs.Enable_Extended_PreAuth();
		gs.Enabling_Giftcard();
		gs.Enabling_Tipout();
		gs.enabling_Gratuity_Line();
		gs.Disable_Customer_Nationality();
		gs.Enabling_TaxExempt();
		gs.Auto_logOff_Time();
		gs.entering_Table_expiration_time();
		gs.Selecting_CustomSplit();
		gs.Enabling_Automatic_Houseaccount();
		gs.Enabling_AutoCloseDay_Report();
		gs.Selecting_ClockIn();
		Thread.sleep(1000);
		gs.Selecting_Checkowner();
		gs.Tip_Settings();
		gs.Entering_FloatingTab();
		gs.Hide_SeatNumber_In_KitchenPrinter();
		gs.Enabling_Memship_AutoRenewal();
		gs.Enabling_Storelevel_Customer();
		gs.Time_Format();
		gs.Date_Format();
		gs.enablingTipScreen();
	}
	public void updating_settings(WebDriver driver) throws Exception 
	{
		//updating the data
		gs.update();
		Thread.sleep(2000);
		//Check whether settings are Updated  or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Application Settings Updated successfully"))
		{
			test.log(LogStatus.PASS, "General settings updated");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "General settings updation failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}	
	}




}

