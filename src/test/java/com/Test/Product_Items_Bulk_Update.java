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

import com.Pages.BulkUpdate_Page;
import com.Pages.BulkUpdate_Page;
import com.Pages.Common_XPaths;
import com.Pages.CutAndModifyPage;
import com.Pages.LoginPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_Bulk_Update {
	
	public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Product/Items - Bulk_Update");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	BulkUpdate_Page bup;
	
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
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
//		//Open the Chrome window
//		driver = new ChromeDriver();
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver(chrOpt);
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
		Open_Bulk_Update_Page(driver);
		Verify_single_MenuItem_Update_Page(driver);
		Verify_BulkUpdate_MenuItem_Update_Page(driver);
		Verify_BulkUpdate_Page(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Bulk_Update_Page(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		bup=new BulkUpdate_Page(driver, test);
		
		Thread.sleep(5000);
		//Load the bulk Menu Updates page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"bulkMenuUpdate");

		Thread.sleep(5000);
		//Verify the Cut and modify page loaded or not
		cmp.VerifyMainScreenPageHeader("Bulk Update");	
	}
	
	@Test(priority = 4,enabled = false)
	public void Verify_single_MenuItem_Update_Page(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		bup=new BulkUpdate_Page(driver, test);
		
		Thread.sleep(5000);
		
		bup.Increase_single_Menu_Item();

	}
	
	@Test(priority = 4,enabled = false)
	public void Verify_BulkUpdate_MenuItem_Update_Page(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		bup=new BulkUpdate_Page(driver, test);
		
		Thread.sleep(5000);
		
		bup.Bulk_update_menu_Item();
		Thread.sleep(5000);
		bup.decrease_by_amount();
		Thread.sleep(5000);
		bup.decrease_by_percentage();
		Thread.sleep(5000);
		bup.Increase_by_amount();
		Thread.sleep(5000);
        bup.Increase_by_percentage();
	}
	@Test(priority = 4,enabled = false)
	public void Verify_Coursing_columnoptionAndSetting_button (SelfHealingDriver driver) throws Exception
	{
		
	
		cmp=new Common_XPaths(driver, test);
		
		cmp.Filter_Columns();
	
		if(cmp.Setting().isDisplayed()) {
			test.log(LogStatus.PASS, "Setting button is displayed sucessfully");
		}
		else {
			test.log(LogStatus.FAIL, "Setting button is not displayed sucessfully");
		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Verify_BulkUpdate_Page(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		bup=new BulkUpdate_Page(driver, test);
		
		Thread.sleep(5000);
		bup.Bulk_update();
		
	}
}
