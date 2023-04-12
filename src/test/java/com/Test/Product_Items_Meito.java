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

import com.Pages.Availability_RestrictionTimePage;
import com.Pages.MeitoPage;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_Meito 
{

public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Product and Items - Meito");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	MeitoPage mto;
	
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
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
//		//Open the Chrome window
//		driver = new ChromeDriver();
		
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
		Open_Meito_Page(driver);
		Update_Meito(driver);
		
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Meito_Page(WebDriver driver) throws Exception
	{
		
		mto=new MeitoPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Category page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"meito");

		Thread.sleep(5000);
		//Verify the Meito page loeded or not
		cmp.VerifyMainScreenPageHeader("Meito");	
	}
	

	@Test(priority = 4,enabled = false)
	public void Update_Meito(WebDriver driver) throws Exception
	{
		mto=new MeitoPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		mto.Select_Choose_Menu();
		
		Thread.sleep(1000);
		mto.Click_Update_Template();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Meito Menu item updated successfully"))
		{
			test.log(LogStatus.PASS, "Meito Menu item updated successfully");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Meito Menu item update Failed");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
}
