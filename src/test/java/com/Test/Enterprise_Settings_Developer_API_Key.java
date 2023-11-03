package com.Test;

import java.util.ArrayList;
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
import com.Pages.Enterprise_DeveloperAPI_Key_Page;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.Pages.Settings_TipOut_TipSharing_Page;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Enterprise_Settings_Developer_API_Key 
{
	public SelfHealingDriver driver;


	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("EnterPriseSettings-DeveloperAPI Key");

	LoginPage lgpg; 
	Enterprise_DeveloperAPI_Key_Page DA;

	Utility ut=new Utility();
    Common_XPaths cmp;
	LoginTest a=new LoginTest();
	ReportsPage repts;
	

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

		Thread.sleep(30000);
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
		Open_DeveloperAPI_Page(driver);
		Edit_Developer_API_Details(driver);
	}
     

	@Test(priority=3, enabled = false)
	public void Open_DeveloperAPI_Page(SelfHealingDriver driver) throws Exception
	{
		DA = new Enterprise_DeveloperAPI_Key_Page(driver, test);
		cmp = new Common_XPaths(driver, test);
		
		DA.Click_Enterprise();
		Thread.sleep(500);
		
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"developerAPI");
		
		Thread.sleep(3000);
		cmp.VerifyMainScreenPageHeader("Developer API Key");
		
	}
	@Test(priority=4, enabled = false)
	public void Edit_Developer_API_Details(SelfHealingDriver driver) throws Exception
	{
		DA = new Enterprise_DeveloperAPI_Key_Page(driver, test);
		cmp = new Common_XPaths(driver, test);
		
		Thread.sleep(500);
		DA.Click_AutoRenew_NoToggle();
		Thread.sleep(500);
		DA.Click_API_Req_Dropdown();
		Thread.sleep(500);
		DA.Select_API_Value();
		Thread.sleep(500);
		DA.Click_AutoRenew_YesToggle();
		Thread.sleep(500);
		DA.Click_Update();
		Thread.sleep(30000);
		ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("License upgraded successfully. License count will increase very soon, in 5 min")) 
		{
			test.log(LogStatus.PASS,"License Upgraded Successfully");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		}
		else {
			test.log(LogStatus.FAIL,"License not Upgraded Successfully");
		}
		Thread.sleep(5000);
		 driver.switchTo().window(tabs.get(1));
		 Thread.sleep(5000);
		driver.close();
		 driver.switchTo().window(tabs.get(0));
		Thread.sleep(5000);
		
		Thread.sleep(3000);
	}
}
