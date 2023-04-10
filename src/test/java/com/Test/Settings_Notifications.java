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

import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.Pages.Settings_NotificationsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Notifications
{
	public WebDriver driver;


	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Notifications");

	LoginPage lgpg; 
	Utility ut=new Utility();
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Settings_NotificationsPage np;


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
	@Test(priority = 2,enabled = false)
	public void Calling() throws Exception 
	{
		// Here phone number validation is available but as per requirement it is no need so use Calling1 method

		Open_Notifications_Page(driver);
		Thread.sleep(1000);
		Clicking_Discount_Yes(driver);
		Thread.sleep(1000);
		Clikcing_Discount_Yes_Negative(driver);
		Thread.sleep(1000);
		Clciking_Discount_No(driver);
		Thread.sleep(1000);
		Clicking_Void_Yes(driver);
		Thread.sleep(1000);
		Clikcing_Void_Yes_Negative(driver);
		Thread.sleep(1000);
		Clicking_Void_No(driver);
		Thread.sleep(1000);
		Clicking_CashDrawer_Yes(driver);
		Thread.sleep(1000);
		Clikcing_CashDrawer_Yes_Negative(driver);
		Thread.sleep(1000);
		Clicking_CashDrawer_No(driver);
		Thread.sleep(1000);
		Clicking_TimeClock_Yes(driver);
		Thread.sleep(1000);
		Clikcing_TimeClock_Yes_Negative(driver);
		Thread.sleep(1000);
		Clicking_TimeClock_No(driver);
		Thread.sleep(1000);
		Clicking_KPI_Yes(driver);
		Thread.sleep(1000);
		Clikcing_KPI_Yes_Negative(driver);
		Thread.sleep(1000);
		Clicking_KPI_No(driver);
		Thread.sleep(1000);
		Clicking_EOD_Yes(driver);
		Thread.sleep(1000);
		Clikcing_EOD_Yes_Negative(driver);
		Thread.sleep(1000);
		Clicking_EOD_No(driver);
		Thread.sleep(1000);
		Clicking_WaitList_Yes(driver);
		Thread.sleep(1000);
		Clikcing_WaitList_Negative(driver);
		Thread.sleep(1000);
		Clicking_WaitList_No(driver);
		Thread.sleep(1000);
		Clicking_SRR_Yes(driver);
		Thread.sleep(1000);
		Clikcing_SRR_Negative(driver);
		Thread.sleep(1000);
		Clicking_SRR_No(driver);
		Thread.sleep(1000);
		Clicking_OPP_Yes(driver);
		Thread.sleep(1000);
		Clikcing_OPP_Negative(driver);
		Clicking_OPP_No(driver);
	}
	
	@Test(priority = 2,enabled = true)
	public void Calling1() throws Exception 
	{
		Open_Notifications_Page(driver);
		Clicking_No_Toggle(driver);
	}

	@Test(priority = 3,enabled = false)
	public void Open_Notifications_Page(WebDriver driver) throws Exception
	{
		cmp= new Common_XPaths(driver,test);

		Thread.sleep(8000);
		driver.get(Utility.getProperty("baseURL")+"settings/notification");

		/*
		 * Thread.sleep(6000); np.Navigating_settings(); Thread.sleep(1000);
		 * np.Navigating_Notifications();
		 */
		Thread.sleep(8000);	
	}

	@Test(priority = 4,enabled = false)
	public void Clicking_No_Toggle(WebDriver driver) throws Exception
	{
		cmp= new Common_XPaths(driver,test);
		np= new Settings_NotificationsPage(driver, test);
		
		np.No_Toggle();
		
		np.Save();
		Thread.sleep(3000);
		
		np.Yes_Toggle();
		
		//np.Save();
		Thread.sleep(3000);
	}
	@Test(priority = 4,enabled = false)
	public void Clicking_Discount_Yes(WebDriver driver) throws Exception
	{
		cmp= new Common_XPaths(driver,test);
		np= new Settings_NotificationsPage(driver, test);
		for(int i = 1; i <= 3; i++) {driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);}
		np.Selecting_Discount_Yes();
		Thread.sleep(2000);
		np.Discount_Limit();
		Thread.sleep(3000);
		np.Discount_Clicking_TextBox();
		np.Save();
		Thread.sleep(3000);
		np.Entering_PhoneNo_Discount();
		Thread.sleep(3000);
		np.Discount_Clicking_Email();
		np.Save();
		Thread.sleep(3000);
		np.Entering_Email_Discount();
		np.Save();
		Thread.sleep(3000);
    }
	@Test(priority = 5,enabled = false)
	public void Clikcing_Discount_Yes_Negative(WebDriver driver) throws Exception 
	{
		np.Entering_Empty_number();
		try {
			if(driver.findElement(By.xpath("//button[@disabled='true']/span/span[.='SAVE ']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Save button is disabled when there is empty phone number in Discount");

				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception sd)
		{
			test.log(LogStatus.FAIL, "Save button is enabled when there is empty phone number in Discount");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(2000);
		np.Entering_Invalid_Phoneno_ThreeNum();
		np.Entering_Invalid_Email();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits for discount");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed in Discount");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_Invalid_Phoneno_ThreeNum();
		/*
		 * Thread.sleep(2000); try { if(np.Phone_Empty_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } } catch(Exception s) {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Entering_Invalid_Email1();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID ");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_Invalid_Phoneno_specialChar();
		Thread.sleep(2000);
		/*
		 * if(np.Phone_No_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); } Thread.sleep(2000);
		 */
		np.Entering_Invalid_Email2();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_Invalid_Phoneno_Combination();
		Thread.sleep(2000);
		/*
		 * try { if(np.Phone_No_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS,
		 * "Validation message is displayed while entering the invalid number in Discount"
		 * );
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } } catch(Exception e) {
		 * test.log(LogStatus.FAIL,
		 * "Validation message is not displayed while entering the invalid number in Discount"
		 * );
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); } Thread.sleep(2000);
		 */
		Thread.sleep(2000);
		np.Entering_Invalid_Email3();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); } Thread.sleep(2000);
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_Invalid_PhoneNo();
		Thread.sleep(2000);
		/*
		 * if(np.Phone_No_ErrMsg().getText().equalsIgnoreCase("Enter Valid Phone Number"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number in alphabets");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); } Thread.sleep(2000);
		 */
		np.Entering_Invalid_Email4();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); } Thread.sleep(2000);
		 */
		np.Save_Invalid();
		np.Entering_PhoneNo_Discount();
		Thread.sleep(2000);
		np.Entering_Invalid_Email4();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); } Thread.sleep(2000);
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_Email_Discount();
		Thread.sleep(2000);
		np.Entering_Invalid_Phoneno_Combination();
		Thread.sleep(2000);
		/*
		 * if(np.Phone_No_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); } Thread.sleep(2000);
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_PhoneNo_Discount();
		Thread.sleep(2000);
		np.Entering_Email_Discount();
		Thread.sleep(2000);
		np.Save();
	}
	@Test(priority = 6,enabled = false)
	public void Clciking_Discount_No(WebDriver driver) throws Exception 
	{
		Thread.sleep(2000);
		np.Selecting_Discount_No();
		np.Save();
		Thread.sleep(3000);	

	}
	@Test(priority = 7,enabled = false)
	public void Clicking_Void_Yes(WebDriver driver) throws Exception
	{
		cmp= new Common_XPaths(driver,test);
		np= new Settings_NotificationsPage(driver, test);
		for(int i=1;i<=3;i++) 
		{
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		np.Selecting_Void_Yes();
		Thread.sleep(2000);
		np.Entering_Void_Limit();
		np.Save();
		Thread.sleep(2000);
		np.Void_Clicking_Text();
		Thread.sleep(1000);
		np.Entering_Void_PhoneNo();
		np.Save();
		Thread.sleep(2000);
		np.Void_Clicking_Email();
		Thread.sleep(1000);
		np.Entering_Void_Email();
		np.Save();
		Thread.sleep(2000);
	}
	public void Clikcing_Void_Yes_Negative(WebDriver driver) throws Exception 
	{
		np.Entering_Void_Empty_number();
		try {
			if(driver.findElement(By.xpath("//button[@disabled='true']/span/span[.='SAVE ']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Save button is disabled when there is empty phone number in Void");

				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception sd)
		{
			test.log(LogStatus.FAIL, "Save button is enabled when there is empty phone number in Void");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(2000);
		np.Entering_Void_Invalid_Phoneno_ThreeNum();
		np.Entering_Void_Invalid_Email();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_Void_Invalid_Phoneno_ThreeNum();
		/*
		 * Thread.sleep(2000); if(np.Phone_Empty_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Entering_Void_Invalid_Email1();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID ");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); } Thread.sleep(2000);
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_Void_Invalid_Phoneno_specialChar();
		/*
		 * Thread.sleep(2000); if(np.Phone_No_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Entering_Void_Invalid_Email2();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_Void_Invalid_Phoneno_Combination();
		/*
		 * Thread.sleep(2000); if(np.Phone_No_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		//Thread.sleep(2000);
		Thread.sleep(2000);
		np.Entering_Void_Invalid_Email3();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_Void_Invalid_PhoneNo();
		/*
		 * Thread.sleep(2000);
		 * if(np.Phone_No_ErrMsg().getText().equalsIgnoreCase("Enter Valid Phone Number"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number in alphabets");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Entering_Void_Invalid_Email4();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		np.Entering_Void_PhoneNo();
		Thread.sleep(2000);
		np.Entering_Void_Invalid_Email4();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_Void_Email();
		np.Entering_Void_Invalid_Phoneno_Combination();
		/*
		 * Thread.sleep(2000); if(np.Phone_No_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		np.Entering_Void_PhoneNo();
		Thread.sleep(2000);
		np.Entering_Void_Email();
		Thread.sleep(2000);
		np.Save();
		
	}
	@Test(priority = 8,enabled = false)
	public void Clicking_Void_No(WebDriver driver) throws Exception 
	{
		np.Selecting_Void_No();
		Thread.sleep(1000);
		np.Save();
		
	}
	@Test(priority = 9,enabled = false)
	public void Clicking_CashDrawer_Yes(WebDriver driver) throws Exception 
	{
		for(int i=1;i<=3;i++) 
		{
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		np.Clikcing_CashDrawer_Yes();
		Thread.sleep(2000);
		np.Add_Cash_Drawer_Limit();
		String Value = driver.findElement(By.xpath("//span[.='Max No Cash Drawer Accessed For No Sale']/../../div[3]/div/div/div/app-input/div/div/mat-form-field/div/div/div[4]/input[@class]")).getAttribute("value");
		if(Value.equals("0")) {}else {np.Save();}
		Thread.sleep(2000);
		np.Clicking_CashDrawer_Text();
		np.Save();
		np.Entering_CashDrawer_Phoneno();
		np.Save();
		Thread.sleep(2000);
		np.Clicking_CashDrawer_Email();
		np.Save();
		Thread.sleep(2000);
		np.Entering_CashDrawer_Email();
		np.Save();
		Thread.sleep(2000);
	}
	public void Clikcing_CashDrawer_Yes_Negative(WebDriver driver) throws Exception
	{
		np.Entering_CashDrawer_Empty_number();
		
		try {
			if(driver.findElement(By.xpath("//button[@disabled='true']/span/span[.='SAVE ']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Save button is disabled when there is empty phone number in Cash Drawer");

				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception sd)
		{
			test.log(LogStatus.FAIL, "Save button is enabled when there is empty phone number in Cash Drawer");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(2000);
		np.Entering_CashDrawer_Invalid_Phoneno_ThreeNum();
		np.Entering_CashDrawer_Invalid_Email();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_CashDrawer_Invalid_Phoneno_ThreeNum();
		Thread.sleep(2000);
		/*
		 * if(np.Phone_Empty_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Entering_CashDrawer_Invalid_Email1();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID ");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_CashDrawer_Invalid_Phoneno_specialChar();
		/*
		 * Thread.sleep(2000); if(np.Phone_No_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Entering_CashDrawer_Invalid_Email2();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_CashDrawer_Invalid_Phoneno_Combination();
		/*
		 * Thread.sleep(2000); if(np.Phone_No_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); } Thread.sleep(2000);
		 */
		Thread.sleep(2000);
		np.Entering_CashDrawer_Invalid_Email3();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_CashDrawer_Invalid_PhoneNo();
		/*
		 * Thread.sleep(2000);
		 * if(np.Phone_No_ErrMsg().getText().equalsIgnoreCase("Enter Valid Phone Number"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number in alphabets");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Entering_CashDrawer_Invalid_Email4();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		np.Entering_CashDrawer_Phoneno();
		Thread.sleep(2000);
		np.Entering_CashDrawer_Email();
		Thread.sleep(2000);
		np.Save();
		
	}
	@Test(priority = 10,enabled = false)
	public void Clicking_CashDrawer_No(WebDriver driver) throws Exception 
	{
		np.Clicking_CashDrawer_No();
		Thread.sleep(1000);
		np.Save();
		
	}
	@Test(priority = 11,enabled = false)
	public void Clicking_TimeClock_Yes(WebDriver driver) throws Exception 
	{
		for(int i=1;i<=3;i++) 
		{
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		np.Clicking_TimeClock_Yes();
		Thread.sleep(3000);
		np.Clicking_Timeclock_Text();
		np.Save();
		Thread.sleep(3000);
		np.Entering_TimeClock_Phoneno();
		np.Save();
		Thread.sleep(3000);
		np.Clicking_TimeClock_Email();
		np.Save();
		Thread.sleep(3000);
		np.Entering_TimeClock_Email();
		np.Save();
		Thread.sleep(3000);
		
	}
	public void Clikcing_TimeClock_Yes_Negative(WebDriver driver) throws Exception
	{
		np.Entering_TimeClock_Empty_number();
		try {
			if(driver.findElement(By.xpath("//button[@disabled='true']/span/span[.='SAVE ']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Save button is disabled when there is empty phone number in Time Clock");

				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception sd)
		{
			test.log(LogStatus.FAIL, "Save button is enabled when there is empty phone number in Time Clock");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		np.Entering_TimeClock_Invalid_PhoneNo();
		Thread.sleep(2000);
		np.Save();
		//Thread.sleep(2000);

		Thread.sleep(2000);
		/*
		 * if(np.Phone_No_ErrMsg().getText().equalsIgnoreCase("Enter Valid Phone Number"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number in alphabets");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
//		Thread.sleep(2000);
//		np.Entering_TimeClock_Invalid_Email();
//		Thread.sleep(2000);
//		if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID"))
//		{
//			test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Email adding Failed");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		Thread.sleep(2000);
		//np.Save_Invalid();
		np.Entering_TimeClock_Phoneno();
		Thread.sleep(2000);
		np.Entering_TimeClock_Email();
		Thread.sleep(2000);
		np.Save();
		
		
	}
	@Test(priority = 12,enabled = false)
	public void Clicking_TimeClock_No(WebDriver driver) throws Exception 
	{
		np.Clicking_Timeclock_No();
		np.Save();
		
	}
	@Test(priority = 13,enabled = false)
	public void Clicking_KPI_Yes(WebDriver driver) throws Exception
	{
		for(int i=1;i<=3;i++) 
		{
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		np.Clicking_KPI_Yes();
		Thread.sleep(3000);
		np.Clicking_KPI_Text();
		np.Save();
		Thread.sleep(3000);
		np.Entering_KPI_Phoneno();
		np.Save();
		Thread.sleep(3000);
		np.Clicking_KPI_Email();
		np.Save();
		Thread.sleep(3000);
		np.Entering_KPI_Email();
		np.Save();
		Thread.sleep(3000);
	}
	public void Clikcing_KPI_Yes_Negative(WebDriver driver) throws Exception 
	{
		np.Entering_KPI_Empty_number();
		Thread.sleep(2000);
		try {
			if(driver.findElement(By.xpath("//button[@disabled='true']/span/span[.='SAVE ']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Save button is disabled when there is empty phone number in Daily KPI");

				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception sd)
		{
			test.log(LogStatus.FAIL, "Save button is enabled when there is empty phone number in Daily KPI");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		np.Entering_KPI_Invalid_Phoneno_ThreeNum();
		np.Entering_KPI_Invalid_Email();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); } Thread.sleep(2000);
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_KPI_Invalid_Phoneno_ThreeNum();
		/*
		 * Thread.sleep(2000); if(np.Phone_Empty_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Entering_KPI_Invalid_Email1();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID ");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_KPI_Invalid_Phoneno_specialChar();
		/*
		 * Thread.sleep(2000); if(np.Phone_No_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Entering_KPI_Invalid_Email2();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_KPI_Invalid_Phoneno_Combination();
		Thread.sleep(2000);
		/*
		 * if(np.Phone_No_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); } Thread.sleep(2000);
		 */
		Thread.sleep(2000);
		np.Entering_KPI_Invalid_Email3();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_KPI_Invalid_PhoneNo();
		/*
		 * Thread.sleep(2000);
		 * if(np.Phone_No_ErrMsg().getText().equalsIgnoreCase("Enter Valid Phone Number"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number in alphabets");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Entering_KPI_Invalid_Email4();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		np.Entering_KPI_Phoneno();
		Thread.sleep(2000);
		np.Entering_KPI_Invalid_Email4();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_KPI_Email();
		np.Entering_KPI_Invalid_Phoneno_Combination();
		/*
		 * Thread.sleep(2000); if(np.Phone_No_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_KPI_Phoneno();
		Thread.sleep(2000);
		np.Entering_KPI_Email();
		Thread.sleep(2000);
		np.Save();
	}
	@Test(priority = 14,enabled = false)
	public void Clicking_KPI_No(WebDriver driver) throws Exception 
	{
		np.Clicking_KPI_NO();
		np.Save();
		
	}
	@Test(priority = 15,enabled = false)
	public void Clicking_EOD_Yes(WebDriver driver) throws Exception
	{
		for(int i=1;i<=3;i++) 
		{
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		np.Clicking_EOD_Yes();
		Thread.sleep(3000);
		np.Clicking_EOD_Text();
		np.Save();
		Thread.sleep(3000);
		np.Entering_EOD_Phoneno();
		np.Save();
		Thread.sleep(3000);
		np.Clicking_EOD_Email();
		np.Save();
		Thread.sleep(3000);
		np.Entering_EOD_Email();
		np.Save();
		Thread.sleep(3000);
	}
	public void Clikcing_EOD_Yes_Negative(WebDriver driver) throws Exception 
	{
		np.Entering_EOD_Empty_number();
		try {
			if(driver.findElement(By.xpath("//button[@disabled='true']/span/span[.='SAVE ']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Save button is disabled when there is empty phone number in EOD");

				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception sd)
		{
			test.log(LogStatus.FAIL, "Save button is enabled when there is empty phone number in EOD");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(2000);
		np.Entering_EOD_Invalid_Phoneno_ThreeNum();
		np.Entering_EOD_Invalid_Email();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_EOD_Invalid_Phoneno_ThreeNum();
		/*
		 * Thread.sleep(2000); if(np.Phone_Empty_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Entering_EOD_Invalid_Email1();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID ");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_EOD_Invalid_Phoneno_specialChar();
		/*
		 * Thread.sleep(2000); if(np.Phone_No_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Entering_EOD_Invalid_Email2();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_EOD_Invalid_Phoneno_Combination();
		/*
		 * Thread.sleep(2000); if(np.Phone_No_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); } Thread.sleep(2000);
		 */
		Thread.sleep(2000);
		np.Entering_EOD_Invalid_Email3();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_EOD_Invalid_PhoneNo();
		/*
		 * Thread.sleep(2000);
		 * if(np.Phone_No_ErrMsg().getText().equalsIgnoreCase("Enter Valid Phone Number"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number in alphabets");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Entering_EOD_Invalid_Email4();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		np.Entering_EOD_Phoneno();
		Thread.sleep(2000);
		np.Entering_EOD_Invalid_Email4();
		/*
		 * Thread.sleep(2000);
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_EOD_Email();
		np.Entering_EOD_Invalid_Phoneno_Combination();
		/*
		 * Thread.sleep(2000); if(np.Phone_No_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number, Phone Number should be contain atleast 6 digits"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_EOD_Phoneno();
		Thread.sleep(2000);
		np.Entering_EOD_Email();
		Thread.sleep(2000);
		np.Save();
		
	}
	@Test(priority = 16,enabled = false)
	public void Clicking_EOD_No(WebDriver driver) throws Exception
	{
		np.Clicking_EOD_NO();
		np.Save();
	}
	@Test(priority = 17,enabled = false)
	public void Clicking_WaitList_Yes(WebDriver driver) throws Exception 
	{
		for(int i=1;i<=3;i++) 
		{
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		np.Clicking_WaitList_Yes();
		Thread.sleep(3000);
		np.Entering_WaitList_Text();
		Thread.sleep(1000);
		np.Clicking_WaitList_Text();
		np.Save();
		Thread.sleep(3000);
		np.Entering_WaitList_Phoneno();
		np.Save();
		Thread.sleep(3000);
	}
	public void Clikcing_WaitList_Negative(WebDriver driver) throws Exception 
	{
		np.Entering_WaitList_Empty_number();
		try {
			if(driver.findElement(By.xpath("//button[@disabled='true']/span/span[.='SAVE ']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Save button is disabled when there is empty phone number in Wait List");

				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception sd)
		{
			test.log(LogStatus.FAIL, "Save button is enabled when there is empty phone number in Wait List");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(2000);
		np.Entering_WaitList_Invalid_PhoneNo();
		/*
		 * Thread.sleep(2000);
		 * if(np.Phone_No_ErrMsg().getText().equalsIgnoreCase("Enter Valid Phone Number"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number in alphabets");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Entering_WaitList_Invalid_Phoneno_ThreeNum();
		/*
		 * Thread.sleep(2000); if(np.Phone_Empty_ErrMsg().getText().
		 * equalsIgnoreCase("Enter Valid Phone Number")) { test.log(LogStatus.PASS,
		 * "Added inavalid Phone Number in alphabets");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Entering_WaitList_Invalid_Phoneno_specialChar();
		/*
		 * Thread.sleep(2000);
		 * if(np.Phone_No_ErrMsg().getText().equalsIgnoreCase("Enter Valid Phone Number"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number in alphabets");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		Thread.sleep(2000);
		np.Entering_WaitList_Invalid_Phoneno_Combination();
		/*
		 * Thread.sleep(2000);
		 * if(np.Phone_No_ErrMsg().getText().equalsIgnoreCase("Enter Valid Phone Number"
		 * )) { test.log(LogStatus.PASS, "Added inavalid Phone Number in alphabets");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Phone Number adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Save_Invalid();
		np.Entering_WaitList_Phoneno();
		Thread.sleep(2000);
		np.Save();
		
	}
	@Test(priority = 18,enabled = false)
	public void Clicking_WaitList_No(WebDriver driver) throws Exception 
	{
		np.Clicking_WaitList_No();
		np.Save();
	}
	@Test(priority = 19,enabled = false)
	public void Clicking_SRR_Yes(WebDriver driver) throws Exception 
	{
		for(int i=1;i<=3;i++) 
		{
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		np.Clicking_SRR_Yes();
		Thread.sleep(3000);
		np.Clicking_SRR_Email();
		np.Save();
		Thread.sleep(3000);
		np.Entering_SRR_Email();
		np.Save();
		Thread.sleep(3000);	
	}
	public void Clikcing_SRR_Negative(WebDriver driver) throws Exception 
	{
		Thread.sleep(2000);
		np.Entering_SRR_Invalid_Email();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_SRR_Invalid_Email1();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); } Thread.sleep(2000);
		 */
		np.Entering_SRR_Invalid_Email2();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_SRR_Invalid_Email3();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_SRR_Invalid_Email4();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_SRR_Email();
		Thread.sleep(2000);
		np.Save();
		
	}
	@Test(priority = 20,enabled = false)
	public void Clicking_SRR_No(WebDriver driver) throws Exception 
	{
		np.Clicking_SRR_No();
		np.Save();
	}
	@Test(priority = 21,enabled = false)
	public void Clicking_OPP_Yes(WebDriver driver) throws Exception
	{
		for(int i=1;i<=3;i++) 
		{
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		np.Clicking_OPP_Yes();
		Thread.sleep(3000);
		np.Clicking_OPP_Email();
		np.Save();
		Thread.sleep(3000);
		np.Entering_OPP_Email();
		np.Save();
		Thread.sleep(3000);
		
	}
	public void Clikcing_OPP_Negative(WebDriver driver) throws Exception 
	{
		Thread.sleep(2000);
		np.Entering_OPP_Invalid_Email();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_OPP_Invalid_Email1();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		//Thread.sleep(2000);
		np.Entering_OPP_Invalid_Email2();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_OPP_Invalid_Email3();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_OPP_Invalid_Email4();
		Thread.sleep(2000);
		/*
		 * if(np.Email_Error_Msg().getText().equalsIgnoreCase("Enter Valid Email ID")) {
		 * test.log(LogStatus.PASS, "Added inavalid Email ID in Digits");
		 * 
		 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
		 * test.log(LogStatus.FAIL, "Email adding Failed");
		 * 
		 * ut.FailedCaptureScreenshotAsBASE64(driver, test); }
		 * 
		 * Thread.sleep(2000);
		 */
		np.Save_Invalid();
		Thread.sleep(2000);
		np.Entering_OPP_Email();
		Thread.sleep(2000);
		np.Save();
		
	}
	@Test(priority = 22,enabled = false)
	public void Clicking_OPP_No(WebDriver driver) throws Exception 
	{
		np.Clicking_OPP_No();
		np.Save();
	}
}
