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
import com.Pages.Settings_Fiscal_Page;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Fiscal
{

	public WebDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings - Integration - Fiscal");

	LoginPage lgpg;

	Utility ut = new Utility();

	String Cat;

	Common_XPaths cmp;
	Settings_Fiscal_Page sf;
	
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
			String scnsht = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

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
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().driverVersion("110.0.5481").setup();
		driver = new ChromeDriver(chromeOptions);

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
		Open_ForcedPunchInOut_Page(driver);
		RefreshAndPaginination(driver);
		VerifyTheAddFiscalSettings(driver);
		VerifyTheEditFiscalSettings(driver);
		VerifyTheDeleteFiscalSettings(driver);
	}

	@Test(priority = 3, enabled = false)
	public void Open_ForcedPunchInOut_Page(WebDriver driver) throws Exception {

		cmp = new Common_XPaths(driver, test);

		Thread.sleep(5000);
		// Load the Menu Item sales report page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id2") + "fiscal");

		Thread.sleep(5000);
		//Verify the ForcedPunchInOut page loaded or not
		try {
			if(driver.findElement(By.xpath("//h3[contains(.,'Fiscal')]")).isDisplayed()) {
				test.log(LogStatus.PASS, "Fiscal page is loaded successfully");
			}
		}catch(Exception E) {
			test.log(LogStatus.FAIL, "Fiscal page is not loaded");
		}

	}

	@Test(priority = 4, enabled = false)
	public void RefreshAndPaginination(WebDriver driver) throws Exception {
		cmp = new Common_XPaths(driver, test);

		// Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();

		// Verify Column Filtration
		cmp.Filter_Columns_Table();
	}

	@Test(priority = 4, enabled = false)
	public void VerifyTheAddFiscalSettings(WebDriver driver) throws Exception {
		sf = new Settings_Fiscal_Page(driver, test);

		sf.verifyFiscalPage();
		
		sf.AddFiscal();
		
		Cat = sf.VKN_No;
		//System.out.println(Cat);
		
		Thread.sleep(2000);
		//Check whether the Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Fiscal Settings Saved Successfully."))
		{
			test.log(LogStatus.PASS, "Fiscal Settings Saved Successfully. message is displayed");
		}else {
			test.log(LogStatus.FAIL, "Fiscal Settings Saved Successfully. message is not displayed");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 4, enabled = false)
	public void VerifyTheEditFiscalSettings(WebDriver driver) throws Exception {
		sf = new Settings_Fiscal_Page(driver, test);

		for(int i = 1; i <=10; i++) {driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(Keys.BACK_SPACE);}Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(Cat);Thread.sleep(2000);
		Thread.sleep(2000);
		
		
		sf.EditFiscal();
		
		Thread.sleep(2000);
		//Check whether the Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Fiscal Settings Updated Successfully."))
		{
			test.log(LogStatus.PASS, "Fiscal Settings Updated Successfully. message is displayed");
		}else {
			test.log(LogStatus.FAIL, "Fiscal Settings Updated Successfully. message is not displayed");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 4, enabled = false)
	public void VerifyTheDeleteFiscalSettings(WebDriver driver) throws Exception {
		sf = new Settings_Fiscal_Page(driver, test);
		
		//System.out.println(Cat);
		Cat = Cat.substring(0, Cat.length()-1);
		//System.out.println(Cat);
		Cat = Cat + "1";
		//System.out.println(Cat);

		for(int i = 1; i <=10; i++) {driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(Keys.BACK_SPACE);}Thread.sleep(2000);
		
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(Cat);Thread.sleep(2000);
		Thread.sleep(2000);
		
		
		sf.delete();
		
		Thread.sleep(5000);

		for(int i = 1; i <=10; i++) {driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(Keys.BACK_SPACE);}Thread.sleep(2000);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Search']")).sendKeys(Cat);Thread.sleep(2000);
		Thread.sleep(4000);
		
		if(driver.findElement(By.xpath("//td[contains(.,'Fiscal Settings not found')]")).isDisplayed()) {
			test.log(LogStatus.PASS, "Fiscal Settings not found message is displayed when user search for the recently deleted Fiscal");
		}else {
			test.log(LogStatus.PASS, "Fiscal Settings not found message is not displayed when user search for the recently deleted Fiscal");
		}
		
		Thread.sleep(1000);
		sf.delete_FiscalList();
	}

}



