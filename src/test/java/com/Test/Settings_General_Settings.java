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

import com.Pages.Common_XPaths;
import com.Pages.Settings_GeneralSetting_page;
import com.Pages.Settings_NotificationsPage;
import com.Pages.LoginPage;
import com.Pages.SortMenuConfigPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_General_Settings 
{
	public WebDriver driver;


	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("General settings");

	LoginPage lgpg; 
	Utility ut=new Utility();
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Settings_GeneralSetting_page gs;


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
		open_general_settings_page(driver);
		modifying_settings(driver);
		updating_settings(driver);
	}

	@Test(priority =3,enabled = false)
	public void open_general_settings_page(WebDriver driver) throws Exception 
	{
		cmp=new Common_XPaths(driver, test);
		gs = new Settings_GeneralSetting_page (driver,test);

		Thread.sleep(8000);
		//load the Notifications page
		Thread.sleep(2000);
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("Store_Id2")+"generalSettings");
		gs.NavigatingSettings();
		Thread.sleep(2000);
		gs.NavigateGeneralSetting();
		Thread.sleep(20000);

		//verify General settings page loaded or not
		Thread.sleep(3000);
		//cmp.VerifyMainScreenPageHeader("General Settings");

	}
	
	@Test(priority = 4,enabled = false) 
	public void modifying_settings(WebDriver driver) throws Exception
	{

		cmp=new Common_XPaths(driver, test);
		gs = new Settings_GeneralSetting_page (driver,test);

		Thread.sleep(5000);


		//Thread.sleep(2000);
		//gs.preferredNetwork();

		Thread.sleep(1000);
		gs.EnablingTipScreen();
		Thread.sleep(1000);
		//gs.update();
		Thread.sleep(1000);
		gs.DisablingTipScreen();
		//gs.update();
		Thread.sleep(1000);
		gs.Disabling_Intranet_Sync();
		//gs.update();
		Thread.sleep(1000);
		gs.Enabling_Intranet_Sync();
		//gs.update();
		Thread.sleep(1000);
		gs.preferredNetwork();
		//gs.update();
		Thread.sleep(1000);
		gs.Enabling_PreAuth();
		//gs.update();
		Thread.sleep(1000);
		gs.Disabling_PreAuth();
		//gs.update();
		Thread.sleep(1000);
		gs.Enable_Extended_PreAuth();
		//gs.update();
		Thread.sleep(1000);
		gs.Disabling_Extended_Pre_Auth();
		//gs.update();
		Thread.sleep(1000);
		gs.Enabling_Giftcard();
		//gs.update();
		Thread.sleep(1000);
		gs.Disabling_Giftcard();
		//gs.update();
		Thread.sleep(1000);
		gs.Enabling_Tipout();
		//gs.update();
		Thread.sleep(1000);
		gs.Disabling_Tipout();
		//gs.update();
		Thread.sleep(1000);
		gs.enabling_Gratuity_Line();
		//gs.update();
		Thread.sleep(1000);
		gs.Disabling_Gratuity_Line();
		//gs.update();
		Thread.sleep(1000);
		gs.Disable_Customer_Nationality();
	//	gs.update();
		Thread.sleep(1000);
		gs.Enabling_TaxExempt();
		//gs.update();
		Thread.sleep(1000);
		gs.Disabling_TaxExempt();
		//gs.update();
		Thread.sleep(1000);
		//gs.Auto_logOff_Time();
		gs.entering_Table_expiration_time();
		//gs.update();
		Thread.sleep(1000);
		gs.Selecting_CustomSplit_Check();
		//gs.update();
		Thread.sleep(1000);
		gs.Selecting_Custom_SplitSeat();
		//gs.update();
		Thread.sleep(1000);
		gs.Enabling_Automatic_Houseaccount();
		//gs.update();
		Thread.sleep(1000);
		gs.Disabling_Automatic_Houseaccount();
		//gs.update();
		Thread.sleep(1000);
		gs.Enabling_AutoCloseDay_Report();
		//gs.update();
		Thread.sleep(1000);
		gs.Disabling_AutoCloseDay_Report();
		//gs.update();
		Thread.sleep(1000);
		gs.Selecting_ClockIn();
		//gs.update();
		Thread.sleep(1000);
		gs.Selecting_FaceId();
		//gs.update();
		Thread.sleep(1000);
		gs.Selecting_Checkowner();
		//gs.update();
		Thread.sleep(1000);
		gs.Selecting_CheckCloser();
		//gs.update();
		Thread.sleep(1000);
		gs.Tip_Settings_Amount();
		//gs.update();
		Thread.sleep(1000);
		gs.Tip_Settings_Per();
		//gs.update();
		Thread.sleep(1000);
		gs.Entering_FloatingTab();
		//gs.update();
		Thread.sleep(1000);
		gs.Hide_SeatNumber_In_KitchenPrinter();
		//gs.update();
		Thread.sleep(1000);
		gs.Hide_PhoneOrder();
		//gs.update();
		Thread.sleep(1000);
		gs.Hide_Togo();
		//gs.update();
		Thread.sleep(1000);
		gs.Hide_Weborder();
		//gs.update();
		Thread.sleep(1000);
		gs.Hide_BarTab();
		//gs.update();
		Thread.sleep(1000);
		gs.Enabling_Memship_AutoRenewal();
		//gs.update();
		Thread.sleep(1000);
		gs.Disabling_Membership_Renewal();
		//gs.update();
		Thread.sleep(1000);
		gs.Enabling_Storelevel_Customer();
		//gs.update();
		Thread.sleep(1000);
		gs.Disabling_Storelevel_Customer();
		//gs.update();
		Thread.sleep(1000);
		gs.Time_Format();
		//gs.update();
		Thread.sleep(1000);
		gs.Date_Format();
		//gs.update();
		Thread.sleep(1000);
		gs.Date_2nd();
		//gs.update();
		Thread.sleep(1000);
		gs.Date_3rd();
		//gs.update();
		Thread.sleep(1000);
		gs.enablingTipScreen();
		//gs.update();
		Thread.sleep(1000);
		gs.Disabling_Tipscreen();
		//gs.update();
		Thread.sleep(1000);
	}
	public void updating_settings(WebDriver driver) throws Exception 
	{
		//updating the data
		gs.update();
//		Thread.sleep(2000);
//		//Check whether settings are Updated  or not
//		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Application Settings Updated successfully"))
//		{
//			test.log(LogStatus.PASS, "General settings updated");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "General settings updation failed");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}	
//	}


	}

}

