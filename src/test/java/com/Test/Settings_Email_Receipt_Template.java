package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import com.Pages.Common_XPaths;
import com.Pages.Settings_Email_Receipt_Template_Page;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Email_Receipt_Template
{
	public WebDriver driver;


	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Email Receipt Template");

	LoginPage lgpg; 
	Utility ut=new Utility();
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Settings_Email_Receipt_Template_Page er;


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
		Navigate_Email_Receipt(driver);
		Thread.sleep(2000);
		Store_Information_Operations_And_Save(driver);
		Thread.sleep(2000);
		Check_Details_Operations_And_Save(driver);
		Thread.sleep(2000);
		Order_Summary_Operations_And_Save(driver);
		Thread.sleep(2000);
		Additional_Details_Operations_And_Save(driver);

	}

	@Test(priority=3,enabled = false)
	public void Navigate_Email_Receipt(WebDriver driver) throws Exception 
	{
		Common_XPaths cmp = new Common_XPaths(driver, test);
		er = new Settings_Email_Receipt_Template_Page(driver, test);
		//String s = Utility.getProperty("baseURL")+Utility.getProperty("store_Id2");
		Thread.sleep(15000);
		//driver.findElement(By.xpath("//div[@class='settings']/button")).click();

		 Thread.sleep(5000);

		//driver.findElement(By.xpath("//span[.='KDS Configuration']")).click();
		//driver.get(s);
		//System.out.println("url "+s);
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"emailReceiptTemplate");
		//er.Navigate_Email_Receipt();
		Thread.sleep(8000);
		er.disabledAllOptions();
		Thread.sleep(2000);

		er.Click_Save();Thread.sleep(2000);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Email Receipt Template Saved Successfully")) 
		{
			test.log(LogStatus.PASS, "Email Receipt Template saved successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Email Receipt Template saving failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(2000);
	}
	@Test(priority=4,enabled = false)
	public void Store_Information_Operations_And_Save(WebDriver driver) throws Exception 
	{
		Common_XPaths cmp = new Common_XPaths(driver, test);
		Utility ut = new Utility();
		er.Clicking_Store_Inform();
		Thread.sleep(2000);
		er.Store_Name();

//		try {
//			
//			
//			if(driver.findElement(By.xpath("//p[.='"+Utility.getProperty("Store1")+" ']")).isDisplayed()) 
//			{
//				test.log(LogStatus.FAIL, "Store Name displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e) 
//		{
//			test.log(LogStatus.PASS, "Store name not displyed in template preview after unselecting store name checkbox and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Store_Name();
//
//		try {
//			if(driver.findElement(By.xpath("//p[.='"+Utility.getProperty("Store1")+" ']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Store Name displayed in Template Preview After Selecting Store Name Checkbox");
//		
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Store Name not displayed in template preview after selecting Store Name Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}

		er.Email();
//		try {
//			if(driver.findElement(By.xpath("//p[.='"+Utility.getProperty("EmailId")+" ']")).isDisplayed()) 
//			{
//				test.log(LogStatus.FAIL, "Email displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Email not displyed in template preview after unselecting Email Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Email();
//		try {
//			if(driver.findElement(By.xpath("//p[.='"+Utility.getProperty("MailId")+" ']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Email displayed in Template Preview After Selecting Email Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch(Exception s)
//		{
//			test.log(LogStatus.FAIL, "Email not displayed in template preview after selecting Email Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}


		er.Address();
//		try {
//			if(driver.findElement(By.xpath("//p[.='"+Utility.getProperty("Street_Name")+" ']")).isDisplayed()) 
//			{
//				test.log(LogStatus.FAIL, "Address displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Address not displyed in template preview after unselecting Address Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Address();
//		try {
//			if(driver.findElement(By.xpath("//p[.='"+Utility.getProperty("Street_Name")+" ']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Address displayed in Template Preview After Selecting Address Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Address not displayed in template preview after selecting Address Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}


		er.Phone_Number();

//		try {
//			if(driver.findElement(By.xpath("//p[.='"+Utility.getProperty("PhoneNum")+" ']")).isDisplayed()) 
//			{
//				test.log(LogStatus.FAIL, "phone number displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Phone number not displyed in template preview after unselecting phone number Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Phone_Number();
//		try {
//			if(driver.findElement(By.xpath("//p[.='"+Utility.getProperty("PhoneNum")+" ']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Phone Number displayed in Template Preview After Selecting Phone Number Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Phone Number not displayed in template preview after selecting Phone Number Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		er.Store_Logo();
//		try {
//			if(driver.findElement(By.xpath("//img[@class='thumbnail-image']")).isDisplayed()) 
//			{
//				test.log(LogStatus.FAIL, "Image displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//				
//				WebElement StoreLogo_Textbox = driver.findElement(By.xpath("//app-input[@name='emailTemplateLogoUrl']/div/div/mat-form-field/div/div/div[4]/input"));
//				StoreLogo_Textbox.clear();
//				StoreLogo_Textbox.sendKeys("www.google.com");
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Image not displyed in template preview after unselecting Store Logo Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			
//			WebElement StoreLogo_Textbox = driver.findElement(By.xpath("//app-input[@name='emailTemplateLogoUrl']/div/div/mat-form-field/div/div/div[4]/input"));
//			StoreLogo_Textbox.clear();
//			StoreLogo_Textbox.sendKeys("www.google.com");
//		}
//		er.Store_Logo();
//		try {
//			if(driver.findElement(By.xpath("//img[@class='thumbnail-image']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Store Logo displayed in Template Preview After Selecting Store Logo Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Store Logo not displayed in template preview after selecting Store Logo Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}

		//er.Text_Color();
		Thread.sleep(2000);
		//er.Background_Color();
		Thread.sleep(2000);

		//saving store information

		er.Click_Save();Thread.sleep(2000);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Email Receipt Template Saved Successfully")) 
		{
			test.log(LogStatus.PASS, "Email Receipt Template saved successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Email Receipt Template saving failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(2000);
//		er.Clicking_Store_Inform();
//		Thread.sleep(2000);
//		for(int i=1;i<=6;i++)
//		{
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
//		}
	}

	@Test(priority=5,enabled = false)
	public void Check_Details_Operations_And_Save(WebDriver driver) throws Exception 
	{
		Common_XPaths cmp = new Common_XPaths(driver, test);
		Utility ut = new Utility();
		er.Click_CheckDetails();
		Thread.sleep(1000);
		er.Click_CheckNo();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Check No: ']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Check number displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Check number not displyed in template preview after unselecting Check number Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_CheckNo();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Check No: ']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Check No displayed in Template Preview After Selecting Check No Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Check No not displayed in template preview after selecting Check No Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		er.Click_TableNo();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Table No: ']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Table number displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Table number not displyed in template preview after unselecting Table number Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_TableNo();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Table No: ']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Table No displayed in Template Preview After Selecting Table No Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Table No not displayed in template preview after selecting Table No Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		er.Click_ServerName();
//		try {
//			if(driver.findElement(By.xpath("//span[.=' Server Name ']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Server Name displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Server Name not displyed in template preview after unselecting ServerName Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_ServerName();
//		try {
//			if(driver.findElement(By.xpath("//span[.=' Server Name ']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Server Name displayed in Template Preview After Selecting Server Name Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Server Name not displayed in template preview after selecting Server Name Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		er.Click_Date_Time();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Date: ']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Date and time displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Date and Time not displyed in template preview after unselecting Date&Time Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_Date_Time();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Date: ']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Date displayed in Template Preview After Selecting Date Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Date not displayed in template preview after selecting Date Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		er.Click_CustomerName();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Customer: ']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Customer Name displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Customer Name not displyed in template preview after unselecting CustomerName Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_CustomerName();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Customer: ']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Customer Name displayed in Template Preview After Selecting Customer Name Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Customer Name not displayed in template preview after selecting Customer Name Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		er.Click_SeatNo();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Seat: ']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Seat Number displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Seat Number not displyed in template preview after unselecting Seat Number Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_SeatNo();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Seat: ']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Seat Number displayed in Template Preview After Selecting Seat Number Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Seat Number not displayed in template preview after selecting Seat Number Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		er.Click_Service_Type();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Service: ']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Service Type displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Service Type not displyed in template preview after unselecting Service Type Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_Service_Type();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Service: ']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Service Type displayed in Template Preview After Selecting Service Type Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Service Type not displayed in template preview after selecting Service Type Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		//Saving Check Details
		er.Click_Save();Thread.sleep(2000);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Email Receipt Template Saved Successfully")) 
		{
			test.log(LogStatus.PASS, "Email Receipt Template saved successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Email Receipt Template saving failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(2000);
		//er.Click_CheckDetails();

	}
	//Performing Operations on Order Summary
	@Test(priority=6,enabled = false)
	public void Order_Summary_Operations_And_Save(WebDriver driver) throws Exception
	{
		Common_XPaths cmp = new Common_XPaths(driver, test);
		Utility ut = new Utility();
		er.Click_OrderSummary();
		er.Click_Order_Summary_Checkbox();
//		try {
//			if(driver.findElement(By.xpath("//h6[.='Order Summary']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Order Summary displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Order Summary not displyed in template preview after unselecting Order Summary Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_Order_Summary_Checkbox();
//		try {
//			if(driver.findElement(By.xpath("//h6[.='Order Summary']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Order summary displayed in Template Preview After Selecting Order Summary Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Order Summary not displayed in template preview after selecting Order Summary Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		er.click_Roll_out_Modifier_Price();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Mod #1']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Modifier displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Modifier rollout with menu item so not displyed in template preview after unselecting Roll out modifier with menu Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.click_Roll_out_Modifier_Price();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Mod #1']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Modifier displayed in Template Preview After Selecting Roll out ModifierPrice Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Roll out ModifierPrice not displayed in template preview after selecting Roll out ModifierPrice Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}

		er.Click_Secondary_Modifier_Name();
//		er.Click_Secondary_Modifier_Name();
//		try {
//			if(driver.findElement(By.xpath("//div[@class='new-template']/../div/div[5]/div/div[5]/div[@class='col-6']/p")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Secondary Modifier name displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Secondary Modifier Name not displyed in template preview after unselecting Secondary Modifier Name Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_Secondary_Modifier_Name();

		er.Click_Exclude_Zero_Modifier();
//		try {
//			if(driver.findElement(By.xpath("//span[.='$00.00']")).isDisplayed()) {
//				test.log(LogStatus.PASS, " Zero Modifier displayed in template preview after unselecting Exclude Zero Price modifier Check box and working fine");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Excluded Zero price Modifier not displayed ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_Exclude_Zero_Modifier();
		er.Click_Discount_Under_MenuItem();
//		try {
//			if(driver.findElement(By.xpath("//p[.='Discount']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, " Discount under menu item displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Discount under menu item not displayed in template preview after unselecting Discount Under Menu Item Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_Discount_Under_MenuItem();
//		try {
//			if(driver.findElement(By.xpath("//p[.='Discount']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Discount displayed in Template Preview After Selecting Discount Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Discount not displayed in template preview after selecting Discount Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		er.Click_Secondary_MenuName();
//		try {
//			if(driver.findElement(By.xpath("//p[.='عنصر القائمة']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, " Secondary Menu Name displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Secondary Menu Name not displayed in template preview after unselecting Secondary Menu Name Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_Secondary_MenuName();
		er.Click_Zero_Price_Menu();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Item Name #1']")).isDisplayed()) {
//				test.log(LogStatus.PASS, " Zero Price Menu displayed in template preview after unselecting Secondary Menu Name Check box and working fine");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Secondary Menu Name not displayed ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
//
//		er.Click_Zero_Price_Menu();
		er.Click_TaxSummary();
//		try {
//			if(driver.findElement(By.xpath("//h6[.='Tax Summary']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Tax Summary displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Tax Summary not displayed in template preview after unselecting Tax Summarys Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_TaxSummary();
//		try {
//			if(driver.findElement(By.xpath("//h6[.='Tax Summary']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Tax Summary displayed in Template Preview After Selecting Tax Summary Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Tax Summary not displayed in template preview after selecting Tax Summary Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		er.Click_CheckTotal();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Check Total']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Check Total displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Check Total not displayed in template preview after unselecting Check Total Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_CheckTotal();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Check Total']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Check Total displayed in Template Preview After Selecting Check Total Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Check Total not displayed in template preview after selecting Check Total Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		er.Click_Tip();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Tip']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Tip amount displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Tip amount not displayed in template preview after unselecting Tip Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_Tip();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Tip']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Tip amount displayed in Template Preview After Selecting Tip  Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Tip Amount not displayed in template preview after selecting Tip Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		er.Click_Tender_Details();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Cash Tendered']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Cash Tender displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Cash Tender not displayed in template preview after unselecting Tender Details Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_Tender_Details();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Cash Tendered']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Tender Details displayed in Template Preview After Selecting Tender Details Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Tender Details not displayed in template preview after selecting Tender Details Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		//Saving Order Summary
		er.Click_Save();Thread.sleep(2000);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Email Receipt Template Saved Successfully")) 
		{
			test.log(LogStatus.PASS, "Email Receipt Template saved successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Email Receipt Template saving failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(2000);
		//er.Click_OrderSummary();
	}
	@Test(priority=7,enabled = false)
	public void Additional_Details_Operations_And_Save(WebDriver driver) throws Exception
	{
		Common_XPaths cmp = new Common_XPaths(driver, test);
		Utility ut = new Utility();
		er.Click_Additional_Details();
		er.Click_Card_Details();
//		try {
//			if(driver.findElement(By.xpath("//h6[.='Card Details']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Card Details displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Card Details not displayed in template preview after unselecting Card Details Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_Card_Details();
//
//	      WebElement l=driver.findElement(By.xpath("//h6[.='Card Details']"));
//	      // Javascript executor
//	      ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", l);
//	      Thread.sleep(800);
//	      
//	      try {
//	  		if(driver.findElement(By.xpath("//h6[.='Card Details']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Card Details displayed in Template Preview After Selecting Card Details Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//	      }
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Card Details not displayed in template preview after selecting Card Details Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		er.Click_Signature();
		//er.Click_Signature();
//		try {
//			if(driver.findElement(By.xpath("//div[@class='new-template']/../div/div[8]/div/div[11]/div/img")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Signature displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Signature not displayed in template preview after unselecting Signature Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_Signature();
//		try {
//			if(driver.findElement(By.xpath("//div[@class='new-template']/../div/div[8]/div/div[11]/div/img")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Signature  displayed in Template Preview After Selecting Signature  Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Signature not displayed in template preview after selecting Signature  Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}

		er.Click_Barcode();
//		try {
//			if(driver.findElement(By.xpath("//app-new-template/div/div[11]/div/img")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "BarCode displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Barcode not displayed in template preview after unselecting Barcode Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_Barcode();
//		try {
//			if(driver.findElement(By.xpath("//app-new-template/div/div[11]/div/img")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Barcode displayed in Template Preview After Selecting Barcode Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Barcode not displayed in template preview after selecting Barcode  Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		er.Click_PoweredBy();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Powered by LINGA']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Powered by Linga displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Powered By linga not displayed in template preview after unselecting powered by linga Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Click_PoweredBy();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Powered by LINGA']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Powered By Linga displayed in Template Preview After Selecting Powered by linga Checkbox");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Powered by Linga not displayed in template preview after selecting Powered by linga Check box ");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		er.Click_Social_Icon();
//		er.Click_Social_Icon();
//		er.Click_Facebook();
//		try {
//			if(driver.findElement(By.xpath("//span[@class='fa-brands fa-square-facebook']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Facebook icon displayed after clicking facebook check box");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "FaceBook Icon not displayed in template preview after selecting Facebook Check box and working fine");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Enter_Facebook_URL();
//		er.Click_Facebook();
//		Thread.sleep(2000);
//		er.Click_Twitter();
//		try {
//			if(driver.findElement(By.xpath("//span[@class='fa-brands fa-square-twitter']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "Twitter icon displayed after clicking twitter check box");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "Twitter Icon not displayed in template preview after selecting Twitter Check box and working fine");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Enter_Twitter_URL();
//		er.Click_Twitter();
//		Thread.sleep(2000);
//		er.Click_LinkedIn();
//		try {
//			if(driver.findElement(By.xpath("//span[@class='fa-brands fa-linkedin']")).isDisplayed()) {
//				test.log(LogStatus.PASS, "LinkedIn icon displayed after clicking LinkedIn check box");
//
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.FAIL, "LinkedIn Icon not displayed in template preview after selecting LinkedIn Check box and working fine");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Enter_LinkedIn_URL();
//		er.Click_LinkedIn();
		Thread.sleep(2000);
		er.Click_Customer_Feedback();
//		try {
//			if(driver.findElement(By.xpath("//h6[.='How was your experience']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Customer Feedback displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Customer Feed back not displayed in template preview after unselecting Customer feedback Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		Thread.sleep(2000);
//		er.Click_Customer_Feedback();
		Thread.sleep(2000);
		er.Special_Note();
//		er.Special_Note();
//		Thread.sleep(2000);
//		er.Clear_Special_Note();
//		Thread.sleep(2000);
//		try {
//			if(driver.findElement(By.xpath("//span[.='Have Great Day! Visit Us Again! Any Suggestions Please Email store@hotmail.com']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Special Note displayed");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "Special note not displayed in template preview after Clearing Special Note Check box and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		er.Enter_Special_Note();
//		try {
//			if(driver.findElement(By.xpath("//span[.='Have Great Day! Visit Us Again! Any Suggestions Please Email store@hotmail.com']")).isDisplayed()) {
//				test.log(LogStatus.FAIL, "Existing note only displaying it's not entering new Special note");
//
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//		}
//
//		catch (Exception e)
//		{
//			test.log(LogStatus.PASS, "It's taking newly entered special note and working fine");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
		//Saving Additional Details
		er.Click_Save();Thread.sleep(2000);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Email Receipt Template Saved Successfully")) 
		{
			test.log(LogStatus.PASS, "Email Receipt Template saved successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Email Receipt Template saving failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(2000);
		er.Click_Additional_Details();

	}



}



