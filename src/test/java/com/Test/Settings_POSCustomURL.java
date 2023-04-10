package com.Test;

import java.util.List;
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

import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.Pages.POSCustomURL_Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_POSCustomURL {
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("POS Custom URL Settings");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	POSCustomURL_Page pos;
	
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
		Open_POSUrl_Page(driver);
		Verify_PosCustomUrlPath(driver);
		Add_New_customer_url(driver);
		Edit_customer_url(driver);
		Delete_customer_url(driver);
		more_than_ten_customer_url(driver);
		Verify_More_than_ten_customer_url(driver);
		Delete_All_customer_url(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_POSUrl_Page(WebDriver driver) throws Exception
	{
		
		pos=new POSCustomURL_Page(driver, test);
		cmp=new Common_XPaths(driver, test);
		

		Thread.sleep(5000);
		//Load page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"posCustomUrl");

		Thread.sleep(5000);
		//Verify the Departments page loaded or not
		cmp.VerifyMainScreenPageHeader("POS Custom URLs");
		
		Thread.sleep(5000);
	}
	
	@Test(priority = 3,enabled = false)
	public void Verify_PosCustomUrlPath(WebDriver driver) throws Exception
	{
		
		pos=new POSCustomURL_Page(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		String home = pos.Home().getText();
		String Setting = pos.Products_Items().getText();
		String Path1 = pos.path1().getText();
		
		
		
		String total = home+Setting+Path1;
		System.out.println(total);
		
		if(total.equalsIgnoreCase("Home /Settings /POS Custom URLs")) {
			
			test.log(LogStatus.PASS, "POS Custom URLs Path is displayed");
		}
		else {
			test.log(LogStatus.FAIL, "POS Custom URLs Path is not displayed");
		}
	
		
		
		
		
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Add_New_customer_url(WebDriver driver) throws Exception
	{
		
		pos=new POSCustomURL_Page(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Verify the Departments page loaded or not
		cmp.VerifyMainScreenPageHeader("POS Custom URLs");
		
		Thread.sleep(2000);
	    pos.POS_Access_URL_Yes();
		Thread.sleep(2000);
		//pos.Click_URLLink_btn();
	//	Thread.sleep(2000);
		
		pos.Enter_Name(Utility.getProperty("POS_URL_Name"));
		Thread.sleep(2000);
		pos.Enter_Url("www.pos.com");
		Thread.sleep(2000);
		//Upload picture
		cmp.Upload_Picture(Utility.getProperty("Settings_Store_Information_Store_Image_Path"));
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(.,'SAVE')]")).click();
		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("POS custom url Saved Successfully"))
		{
			test.log(LogStatus.PASS, "POS custom url Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "POS custom url Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Edit_customer_url(WebDriver driver) throws Exception
	{
		
		pos=new POSCustomURL_Page(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Verify the Departments page loaded or not
		cmp.VerifyMainScreenPageHeader("POS Custom URLs");
		//Given Due to automation issue
		Thread.sleep(2000);
		try {
			   pos.POS_Access_URL_Yes();
		}
	 catch (Exception e) {
		// TODO: handle exception
	}
		
	    Thread.sleep(2000);
		
        pos.Click_edit_btn();
       
		Thread.sleep(2000);
		pos.Enter_Name(Utility.getProperty("POS_URL_Name")+"1");
		Thread.sleep(2000);
		pos.Enter_Url("www.pos1.com");
		Thread.sleep(2000);
	//	pos.Mouse_hover_Image_Delete();
		//Upload picture
	//	cmp.Upload_Picture(Utility.getProperty("Settings_Store_Information_Store_Image_Path"));
		Thread.sleep(2000);
		pos.Click_Save();
		
		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("POS Custom URL Updated Successfully"))
		{
			test.log(LogStatus.PASS, "POS Custom URL Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "POS Custom URL Update Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		
		
	}
	@Test(priority = 3,enabled = false)
	public void Delete_customer_url(WebDriver driver) throws Exception
	{
		
		pos=new POSCustomURL_Page(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Verify the Departments page loaded or not
		cmp.VerifyMainScreenPageHeader("POS Custom URLs");
		
		Thread.sleep(2000);
		
		pos.Click_delete_btn();
		Thread.sleep(2000);
		pos.Verify_Delete_Cancel();
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		Thread.sleep(2000);
		pos.Click_delete_btn();
		Thread.sleep(2000);
		pos.Verify_Delete_yes();
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		Thread.sleep(2000);
		cmp.VerifyMainScreenPageHeader("POS Custom URLs");
		
		
	}
	
	@Test(priority = 3,enabled = false)
	public void more_than_ten_customer_url(WebDriver driver) throws Exception
	{
		
		pos=new POSCustomURL_Page(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		try {
			   pos.POS_Access_URL_Yes();
		}
	 catch (Exception e) {
		// TODO: handle exception
	}
		
		
		pos.Enter_Name(Utility.getProperty("POS_URL_Name"));
		Thread.sleep(2000);
		pos.Enter_Url("www.pos.com");
		Thread.sleep(2000);
		//Upload picture
		cmp.Upload_Picture(Utility.getProperty("Settings_Store_Information_Store_Image_Path"));
	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[contains(.,'SAVE')]")).click();
		Thread.sleep(2000);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("POS custom url Saved Successfully"))
		{
			test.log(LogStatus.PASS, "POS custom url Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "POS custom url Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(2000);
		
		for(int i=1;i<=9;i++) {
			
			try {
				   pos.POS_Access_URL_Yes();
			}
		 catch (Exception e) {
			// TODO: handle exception
		}
			
			Thread.sleep(2000);
			pos.Click_URLLink_btn();
			Thread.sleep(2000);
			
			pos.Enter_Name(Utility.getProperty("POS_URL_Name")+i);
			Thread.sleep(2000);
			pos.Enter_Url("www.pos"+i+".com");
			Thread.sleep(8000);
			//Upload picture
			pos.Upload_Picture(Utility.getProperty("Settings_Store_Information_Store_Image_Path"));
			Thread.sleep(5000);
			pos.Click_Save();
			
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("POS custom url Saved Successfully"))
			{
				test.log(LogStatus.PASS, "POS custom url Saved Successfully");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "POS custom url Save Failed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
		}
	}
	@Test(priority = 3,enabled = false)
	public void Verify_More_than_ten_customer_url(WebDriver driver) throws Exception
	{
		
		pos=new POSCustomURL_Page(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		try {
			   pos.POS_Access_URL_Yes();
		}
	 catch (Exception e) {
		// TODO: handle exception
	}
		
		for(int i=1;i<=15;i++) {
			
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		}
		pos.Click_URLLink_btn();
		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Maximum 10 URL can be configured"))
		{
			test.log(LogStatus.PASS, "Maximum 10 URL can be configured pop is displayed Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Maximum 10 URL can be configured pop is not displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}




@Test(priority = 3,enabled = false)
public void Delete_All_customer_url(WebDriver driver) throws Exception
{
	
	List<WebElement> urlLIst=driver.findElements(By.xpath("//div[@class='form-card store-hours']/div[4]/div/div[@class='card']/ul/li/div/div[2]/button[1]"));

for(int i=1;i<=urlLIst.size();i++)
{	
	driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[4]/div[1]/div[@class='card']/ul/li/div/div[2]/button[2]")).click();


	Thread.sleep(2000);
	pos.Verify_Delete_yes();
}

}








}