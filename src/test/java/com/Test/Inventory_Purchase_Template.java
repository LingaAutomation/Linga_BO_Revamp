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
import com.Pages.Inventory_Purchase_Template_Page;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Purchase_Template {

	public WebDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Prchase Template");

	LoginPage lgpg;

	Utility ut = new Utility();

	String s = "";

	Common_XPaths cmp;
	Inventory_Purchase_Template_Page imp;
	
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
		Open_PurchaseOrder_Page(driver);
		RefreshAndPaginination(driver);
		VerifyThePurchaseTemplate(driver);
		CreateThePurchaseTemplate(driver);
		editThePurchaseTemplate(driver);
		deleteThePurchaseTemplate_CAncel(driver);
		deleteThePurchaseTemplate(driver);
		verifyTheActiveStatus(driver);
	}

	@Test(priority = 3, enabled = false)
	public void Open_PurchaseOrder_Page(WebDriver driver) throws Exception {

		cmp = new Common_XPaths(driver, test);

		Thread.sleep(5000);
		// Load the Menu Item sales report page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "purchases/purchaseTemplates");

		Thread.sleep(5000);
		//Verify the Menu Item sales report page loeded or not
		try {
			if(driver.findElement(By.xpath("//h3[contains(.,'Purchase Template')]")).isDisplayed()) {
				test.log(LogStatus.PASS, "Purchase Template page is loaded successfully");
			}
		}catch(Exception E) {
			test.log(LogStatus.FAIL, "Purchase Template page is not loaded");
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
	public void VerifyThePurchaseTemplate(WebDriver driver) throws Exception {
		imp = new Inventory_Purchase_Template_Page(driver, test);

		imp.Verify_PurchaseTemplate_Page();		
	}
	
	@Test(priority = 4, enabled = false)
	public void CreateThePurchaseTemplate(WebDriver driver) throws Exception {
		imp = new Inventory_Purchase_Template_Page(driver, test);

		//verify the new purchase template page
		imp.VerifyTheNewPurchaseTemplatePage();
		
		s = RandomStringUtils.randomAlphabetic(15);
		
		//Enter the name
		imp.enterTheName(s);
		
		//select the vendor
		imp.select_Vendor();
		
		//Add the inventory Item
		imp.Add_Inventory_Item();
	}

	@Test(priority = 4, enabled = false)
	public void editThePurchaseTemplate(WebDriver driver) throws Exception {
		imp = new Inventory_Purchase_Template_Page(driver, test);

		//search the purchase template
		imp.SearchThePurchaseTemplate(s);
		
		//Click the edit button
		imp.clickEditButton();
		
		//Edit and update the purchase template
		imp.increaseOrDecreaseTheQuantity();
	}
	
	@Test(priority = 4, enabled = false)
	public void deleteThePurchaseTemplate_CAncel(WebDriver driver) throws Exception {
		imp = new Inventory_Purchase_Template_Page(driver, test);

		//search the purchase template
		imp.SearchThePurchaseTemplate(s);
		
		//cancel the deletion of the purchase template
		imp.deleteCancel();
	}

	@Test(priority = 5, enabled = false)
	public void deleteThePurchaseTemplate(WebDriver driver) throws Exception {
		imp = new Inventory_Purchase_Template_Page(driver, test);
		
		//delete the purchase template
		imp.delete();
	}
	
	@Test(priority = 5, enabled = false)
	public void verifyTheActiveStatus(WebDriver driver) throws Exception {
		imp = new Inventory_Purchase_Template_Page(driver, test);

		//Click the active button
		imp.clickTheActiveBtn();
		
		Thread.sleep(2000);
		
		//search the purchase template
		imp.SearchThePurchaseTemplate(s);
		
		//verify the availability in inactive page
		imp.verifyTheTemplateAvailability(s);

		//Click the activate and cancel it
		imp.clickActivateBtn();
		
		//activate the inactivated template
		imp.activate();
		
		Thread.sleep(2000);
		
		imp.inActiveBtn();
		
		//search the purchase template
		imp.SearchThePurchaseTemplate(s);
		
		Thread.sleep(2000);
		
		//verify the availability in active page
		imp.verifyTheTemplateAvailabilityInActiveStatus(s);
	}

}
