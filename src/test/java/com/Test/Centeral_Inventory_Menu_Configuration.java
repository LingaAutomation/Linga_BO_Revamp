package com.Test;

import java.util.concurrent.TimeUnit;

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
import com.Pages.Enterprise_CentralIventoryPage;
import com.Pages.InventoryPage;
import com.Pages.LoginPage;
import com.epam.healenium.SelfHealingDriver;
import com.mongodb.internal.connection.Time;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Centeral_Inventory_Menu_Configuration {

	public SelfHealingDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Central Inventory - Menu Configuration");

	LoginPage lgpg;
	public String st = "NA";

	Utility ut = new Utility();

	Common_XPaths cmp;
	LoginTest a = new LoginTest();
	Enterprise_CentralIventoryPage civ;
	InventoryPage air;

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
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().driverVersion("110.0.5841").setup();
//		driver=new ChromeDriver(chrOpt);

//		System.setProperty("webdriver.chrome.driver", "./Automation Driver/chromedriver.exe");
//		// Open the Chrome window
//		driver = new ChromeDriver();
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
		Open_Menu_configuration_Page_In_CentralInventory(driver);
		verify_Menu_Configuration_withOut_data(driver);
		verify_Menu_Configuration_Store_to_store(driver);
		verify_Menu_Configuration_Store_to_Centeral_WareHouse(driver);
		verify_Menu_Configuration_Store_to_Central_Kitchen(driver);
		verify_Menu_Configuration_Store_to_store_withSameStore_Name(driver);
		verify_Menu_Configuration_Central_WareHouse_to_Central_WareHouse(driver);
		verify_Menu_Configuration_Central_WareHouse_to_Central_Kitchen(driver);
		verify_Menu_Configuration_Central_WareHouse_to_Store(driver);
		verify_Menu_Configuration_Central_Kitchen_to_Central_Kitchen(driver);
		verify_Menu_Configuration_Central_Kitchen_to_Central_WareHouse(driver);
		verify_Menu_Configuration_Central_Kitchen_to_Store(driver);
		verify_Menu_Configuration_Type_Search_3_Character(driver);
	}

	@Test(priority = 3, enabled = false)
	public void Open_Menu_configuration_Page_In_CentralInventory(SelfHealingDriver driver) throws Exception {

		civ = new Enterprise_CentralIventoryPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		Thread.sleep(5000);
		// Load the Department page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id7") + "home");

		Thread.sleep(10000);
		// Load the Department page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id7") + "centralInventory/menu");

		Thread.sleep(5000);
		// Verify the Gift Cards page loeded or not
		cmp.VerifyMainScreenPageHeader("Menu Configuration");

	}

	@Test(priority = 3, enabled = false)
	public void verify_Menu_Configuration_withOut_data(SelfHealingDriver driver) throws Exception {

		civ = new Enterprise_CentralIventoryPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		civ.Select_Pull_type_store();

		civ.Select_Push_type_store();

		if (civ.PULL_MENU_CONFIGURATION_Button_disabled().isDisplayed()) {

			test.log(LogStatus.PASS, "With out Select Data in Pull/Push Menu Configuration button is disabled ");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		} else {
			test.log(LogStatus.FAIL, "With out Select Data in Pull/Push Menu Configuration button is enabled");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}

	@Test(priority = 3, enabled = false)
	public void verify_Menu_Configuration_Store_to_Centeral_WareHouse(SelfHealingDriver driver) throws Exception {

		civ = new Enterprise_CentralIventoryPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		civ.Select_Pull_type_store();
		civ.Select_Source_Store();
		civ.Select_Push_type_Central_WareHouse();
		civ.Select_Destination_Store();

		civ.PULL_MENU_CONFIGURATION_Button().click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Internal Server Error")) {
			test.log(LogStatus.PASS, "Menu Configuration in Centeral Inventory is SucessFull");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		} else {
			test.log(LogStatus.FAIL, "Menu Configuration in Centeral Inventory is not SucessFull");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}

	@Test(priority = 3, enabled = false)
	public void verify_Menu_Configuration_Store_to_Central_Kitchen(SelfHealingDriver driver) throws Exception {

		civ = new Enterprise_CentralIventoryPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		civ.Select_Pull_type_store();
		civ.Select_Source_Store();
		civ.Select_Push_type_Central_Kitchen();
		civ.Select_Destination_Store();

		civ.PULL_MENU_CONFIGURATION_Button().click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Internal Server Error")) {
			test.log(LogStatus.PASS, "Menu Configuration in Centeral Inventory is SucessFull");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		} else {
			test.log(LogStatus.FAIL, "Menu Configuration in Centeral Inventory is not SucessFull");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}

	@Test(priority = 3, enabled = false)
	public void verify_Menu_Configuration_Store_to_store(SelfHealingDriver driver) throws Exception {

		civ = new Enterprise_CentralIventoryPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		civ.Select_Pull_type_store();
		civ.Select_Source_Store();
		civ.Select_Push_type_store();
		civ.Select_Destination_Store();

		civ.PULL_MENU_CONFIGURATION_Button().click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Internal Server Error")) {
			test.log(LogStatus.PASS, "Menu Configuration in Centeral Inventory is SucessFull");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		} else {
			test.log(LogStatus.FAIL, "Menu Configuration in Centeral Inventory is not SucessFull");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}

	@Test(priority = 3, enabled = false)
	public void verify_Menu_Configuration_Store_to_store_withSameStore_Name(SelfHealingDriver driver) throws Exception {

		civ = new Enterprise_CentralIventoryPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		civ.Select_Pull_type_store();
		civ.Select_Source_Store();
		civ.Select_Push_type_store();

		Thread.sleep(3000);

		String Pull = civ.PULL_Data_From_Store_input().getAttribute("value");
		System.out.println(Pull);

		Thread.sleep(3000);
		civ.PUSH_Data_TO_Store_input().click();
		Thread.sleep(3000);

		Thread.sleep(1000);
		civ.SearchBox_DropDown().clear();
		Thread.sleep(1000);
		civ.SearchBox_DropDown().sendKeys(Pull);
		Thread.sleep(5000);
		civ.First_Option_inDropDown().click();
		Thread.sleep(5000);

		if (civ.Select_different_store().isDisplayed()) {

			test.log(LogStatus.PASS, "For Same Store it show the message " + civ.Select_different_store().getText());

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		} else {
			test.log(LogStatus.FAIL, "For Same Store error message not displayed ");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

		if (civ.PULL_MENU_CONFIGURATION_Button_disabled().isDisplayed()) {

			test.log(LogStatus.PASS, "With out Select Data in Pull/Push Menu Configuration button is disabled ");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		} else {
			test.log(LogStatus.FAIL, "With out Select Data in Pull/Push Menu Configuration button is enabled");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}

	@Test(priority = 3, enabled = false)
	public void verify_Menu_Configuration_Central_WareHouse_to_Central_WareHouse(SelfHealingDriver driver) throws Exception {

		civ = new Enterprise_CentralIventoryPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		civ.Select_Pull_type_Central_WareHouse();
		civ.Select_Source_Store();
		civ.Select_Push_type_Central_WareHouse();
		civ.Select_Destination_Store();

		civ.PULL_MENU_CONFIGURATION_Button().click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Internal Server Error")) {
			test.log(LogStatus.PASS, "Menu Configuration in Centeral Inventory is SucessFull");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		} else {
			test.log(LogStatus.FAIL, "Menu Configuration in Centeral Inventory is not SucessFull");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}

	@Test(priority = 3, enabled = false)
	public void verify_Menu_Configuration_Central_WareHouse_to_Central_Kitchen(SelfHealingDriver driver) throws Exception {

		civ = new Enterprise_CentralIventoryPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		civ.Select_Pull_type_Central_WareHouse();
		civ.Select_Source_Store();
		civ.Select_Push_type_Central_Kitchen();
		civ.Select_Destination_Store();

		civ.PULL_MENU_CONFIGURATION_Button().click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Internal Server Error")) {
			test.log(LogStatus.PASS, "Menu Configuration in Centeral Inventory is SucessFull");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		} else {
			test.log(LogStatus.FAIL, "Menu Configuration in Centeral Inventory is not SucessFull");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}

	@Test(priority = 3, enabled = false)
	public void verify_Menu_Configuration_Central_WareHouse_to_Store(SelfHealingDriver driver) throws Exception {

		civ = new Enterprise_CentralIventoryPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		civ.Select_Pull_type_Central_WareHouse();
		civ.Select_Source_Store();
		civ.Select_Push_type_store();
		civ.Select_Destination_Store();

		civ.PULL_MENU_CONFIGURATION_Button().click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Internal Server Error")) {
			test.log(LogStatus.PASS, "Menu Configuration in Centeral Inventory is SucessFull");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		} else {
			test.log(LogStatus.FAIL, "Menu Configuration in Centeral Inventory is not SucessFull");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}

	@Test(priority = 3, enabled = false)
	public void verify_Menu_Configuration_Central_Kitchen_to_Central_Kitchen(SelfHealingDriver driver) throws Exception {

		civ = new Enterprise_CentralIventoryPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		civ.Select_Pull_type_Central_Kitchen();
		civ.Select_Source_Store();
		civ.Select_Push_type_Central_Kitchen();
		civ.Select_Destination_Store();

		civ.PULL_MENU_CONFIGURATION_Button().click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Internal Server Error")) {
			test.log(LogStatus.PASS, "Menu Configuration in Centeral Inventory is SucessFull");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		} else {
			test.log(LogStatus.FAIL, "Menu Configuration in Centeral Inventory is not SucessFull");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}

	@Test(priority = 3, enabled = false)
	public void verify_Menu_Configuration_Central_Kitchen_to_Central_WareHouse(SelfHealingDriver driver) throws Exception {

		civ = new Enterprise_CentralIventoryPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		civ.Select_Pull_type_Central_Kitchen();
		civ.Select_Source_Store();
		civ.Select_Push_type_Central_WareHouse();
		civ.Select_Destination_Store();

		civ.PULL_MENU_CONFIGURATION_Button().click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Internal Server Error")) {
			test.log(LogStatus.PASS, "Menu Configuration in Centeral Inventory is SucessFull");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		} else {
			test.log(LogStatus.FAIL, "Menu Configuration in Centeral Inventory is not SucessFull");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}

	@Test(priority = 3, enabled = false)
	public void verify_Menu_Configuration_Central_Kitchen_to_Store(SelfHealingDriver driver) throws Exception {

		civ = new Enterprise_CentralIventoryPage(driver, test);
		cmp = new Common_XPaths(driver, test);

		civ.Select_Pull_type_Central_Kitchen();
		civ.Select_Source_Store();
		civ.Select_Push_type_store();
		civ.Select_Destination_Store();

		civ.PULL_MENU_CONFIGURATION_Button().click();

		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		if (cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Internal Server Error")) {
			test.log(LogStatus.PASS, "Menu Configuration in Centeral Inventory is SucessFull");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		} else {
			test.log(LogStatus.FAIL, "Menu Configuration in Centeral Inventory is not SucessFull");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}
	
	
	@Test(priority = 3, enabled = false)
	public void verify_Menu_Configuration_Type_Search_3_Character(SelfHealingDriver driver) throws Exception {

		civ = new Enterprise_CentralIventoryPage(driver, test);
		cmp = new Common_XPaths(driver, test);
		
		civ.PULL_Data_From_type_input().click();
		Thread.sleep(2000);
		
		String data = driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div[1]/select-option/div")).getText().substring(0, 3);
		String data1 = data.substring(0, 2);
		civ.SearchBox_DropDown().clear();
		civ.SearchBox_DropDown().sendKeys(data1);
		
		String data2 = data.substring(0, 3);
		civ.SearchBox_DropDown().clear();
		civ.SearchBox_DropDown().sendKeys(data2);
		
		Thread.sleep(5000);
		civ.First_Option_inDropDown().click();
		Thread.sleep(5000);
		civ.PULL_Data_From_Store_input().click();
		Thread.sleep(5000);
		
	Thread.sleep(2000);
		
		String ata = driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div[1]/select-option/div")).getText().substring(0, 3);
		String ata1 = ata.substring(0, 2);
		civ.SearchBox_DropDown().clear();
		civ.SearchBox_DropDown().sendKeys(ata1);
		
		String ata2 = ata.substring(0, 3);
		civ.SearchBox_DropDown().clear();
		civ.SearchBox_DropDown().sendKeys(ata2);
		
		
		
		
	}
}
