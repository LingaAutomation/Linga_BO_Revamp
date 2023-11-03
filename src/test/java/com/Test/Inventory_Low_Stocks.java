package com.Test;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
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
import com.Pages.Inventory_Low_Stocks_Page;
import com.Pages.LoginPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Low_Stocks {

	public SelfHealingDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Low Stocks");

	LoginPage lgpg;

	Utility ut = new Utility();

	String s = "",Cat;

	Common_XPaths cmp;
	Inventory_Low_Stocks_Page ls;
	
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
			String scnsht = ((TakesScreenshot) driver.getDelegate()).getScreenshotAs(OutputType.BASE64);

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
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().driverVersion("110.0.5481").setup();
//		driver = new ChromeDriver(chromeOptions);

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		
		options.setHeadless(false);
		
		WebDriver delegate=new ChromeDriver();
		
		driver=SelfHealingDriver.create(delegate);
		
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
		Open_LowStocks_Page(driver);
		VerifyTheLowStocks(driver);
		VerifyInventoryLowStocks(driver);
		VerifySubRecipeLowStocks(driver);
	}

	@Test(priority = 3, enabled = false)
	public void Open_LowStocks_Page(SelfHealingDriver driver) throws Exception {

		cmp = new Common_XPaths(driver, test);

		Thread.sleep(5000);
		// Load the Menu Item sales report page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "lowStocks");

		Thread.sleep(5000);
		//Verify the LowStocks page loaded or not
		try {
			if(driver.findElement(By.xpath("//h3[contains(.,'Low Stocks')]")).isDisplayed()) {
				test.log(LogStatus.PASS, "Low Stocks page is loaded successfully");
			}
		}catch(Exception E) {
			test.log(LogStatus.FAIL, "Low Stocks page is not loaded");
		}

	}



	@Test(priority = 4, enabled = false)
	public void VerifyTheLowStocks(SelfHealingDriver driver) throws Exception {
		ls = new Inventory_Low_Stocks_Page(driver, test);

		ls.Verify_LowStocks_Page();	
	}
	
	@Test(priority = 4, enabled = false)
	public void VerifyInventoryLowStocks(SelfHealingDriver driver) throws Exception {
		ls = new Inventory_Low_Stocks_Page(driver, test);

		Thread.sleep(3000);
		ls.verifyInventory_Purchase_Low_Stocks();
	}

	@Test(priority = 4, enabled = false)
	public void VerifySubRecipeLowStocks(SelfHealingDriver driver) throws Exception {
		ls = new Inventory_Low_Stocks_Page(driver, test);

		Thread.sleep(3000);
		ls.VerifyTheNewSubRecipePage();
		
		ls.verfiySubRecipeAdded();

	}
	

}
