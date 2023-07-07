package com.Test;

import java.time.Duration;

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
import com.Pages.Settings_TipOut_TipSharing_Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_TipOut_TipSharing {
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Tip Out & Tip Sharing");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp=new Common_XPaths(driver, test);
	LoginTest a=new LoginTest();
	
	Settings_TipOut_TipSharing_Page PR;
		
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

		ChromeOptions chrOpt=new ChromeOptions();
		chrOpt.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(chrOpt);
	
		//Wait for 30 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
		Thread.sleep(10000);
		Open_TipOutTipSharing_Page(driver);
		/*
		 * VerifyTheField_Options(driver); VerifyTheStyleOptions(driver);
		 * VerifyThe_SMS_Order_Notifications(driver);
		 */
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_TipOutTipSharing_Page(WebDriver driver) throws Exception
	{
		PR = new Settings_TipOut_TipSharing_Page(driver, test);
		//Thread.sleep(5000);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"tipoutTipsharing");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(15000);
		
		PR.TipOutPage();
		
		PR.TipOut();
		
		PR.paginationValidation();		
		
		PR.search();
		
		PR.delete();
		
		PR.TipSharing();
	}
	
	/*
	 * @Test(priority = 3,enabled = false) public void
	 * VerifyTheField_Options(WebDriver driver) throws Exception { kds=new
	 * Settings_KDS_Configuration_Page(driver, test);
	 * 
	 * Thread.sleep(1000); kds.verifyTheFieldOptions();
	 * 
	 * Thread.sleep(3000); //Click the update button
	 * driver.findElement(By.xpath("//button[.=' UPDATE ']")).click();
	 * 
	 * Thread.sleep(1500);
	 * if(driver.findElement(By.xpath("//div[contains(@class,'message')]/span")).
	 * getText().equalsIgnoreCase("KDS Configuration saved successfully")) {
	 * test.log(LogStatus.PASS,
	 * "KDS Configuration saved successfully message displayed successfully message is displayed when used do the changes in Field options"
	 * ); } else { test.log(LogStatus.FAIL,
	 * "KDS Configuration saved successfully message displayed successfully message is not displayed when used do the changes in Field options"
	 * ); }
	 * 
	 * }
	 * 
	 * 
	 * @Test(priority = 3,enabled = false) public void
	 * VerifyTheStyleOptions(WebDriver driver) throws Exception { kds=new
	 * Settings_KDS_Configuration_Page(driver, test);
	 * 
	 * Thread.sleep(1000); kds.verifyTheStyleOptions();
	 * 
	 * Thread.sleep(3000); //Click the update button
	 * driver.findElement(By.xpath("//button[.=' UPDATE ']")).click();
	 * 
	 * Thread.sleep(1500);
	 * if(driver.findElement(By.xpath("//div[contains(@class,'message')]/span")).
	 * getText().equalsIgnoreCase("KDS Configuration saved successfully")) {
	 * test.log(LogStatus.PASS,
	 * "KDS Configuration saved successfully message displayed successfully message is displayed when used do the changes in Field options"
	 * ); } else { test.log(LogStatus.FAIL,
	 * "KDS Configuration saved successfully message displayed successfully message is not displayed when used do the changes in Field options"
	 * ); }
	 * 
	 * }
	 * 
	 * @Test(priority = 3,enabled = false) public void
	 * VerifyThe_SMS_Order_Notifications(WebDriver driver) throws Exception {
	 * kds=new Settings_KDS_Configuration_Page(driver, test);
	 * 
	 * Thread.sleep(1000); kds.verifyTheSMSOrderNotifications();
	 * 
	 * Thread.sleep(3000); //Click the update button
	 * driver.findElement(By.xpath("//button[.=' UPDATE ']")).click();
	 * 
	 * Thread.sleep(1500);
	 * if(driver.findElement(By.xpath("//div[contains(@class,'message')]/span")).
	 * getText().equalsIgnoreCase("KDS Configuration saved successfully")) {
	 * test.log(LogStatus.PASS,
	 * "KDS Configuration saved successfully message displayed successfully message is displayed when used do the changes in Field options"
	 * ); } else { test.log(LogStatus.FAIL,
	 * "KDS Configuration saved successfully message displayed successfully message is not displayed when used do the changes in Field options"
	 * ); }
	 * 
	 * }
	 */
	
}