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
import com.Pages.InventoryCategoryPage;
import com.Pages.Inventory_Sub_Category_Page;
import com.Pages.LoginPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Sub_Category {

	public SelfHealingDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Sub Category");

	LoginPage lgpg;

	Utility ut = new Utility();

	String s = "",Cat;

	Common_XPaths cmp;
	Inventory_Sub_Category_Page invSubCat;
	InventoryCategoryPage icp;
	
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
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().driverVersion("110.0.5481").setup();
		driver = (SelfHealingDriver) new ChromeDriver(chromeOptions);

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
		Open_SubCategory_Page(driver);
		RefreshAndPaginination(driver);
		VerifyTheSubCategory(driver);
		CreateTheSubCategory(driver);
		editTheSubCategory(driver);
		deleteTheSubCategory_CAncel(driver);
		deleteTheSubCategory(driver);
		verifyTheActiveStatus(driver);
		verifyTheSubCAtegoryAvailablity(driver);
	}

	@Test(priority = 3, enabled = false)
	public void Open_SubCategory_Page(SelfHealingDriver driver) throws Exception {

		cmp = new Common_XPaths(driver, test);

		Thread.sleep(5000);
		// Load the Menu Item sales report page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "subCategory");

		Thread.sleep(5000);
		//Verify the subCategory page loaded or not
		try {
			if(driver.findElement(By.xpath("//h3[contains(.,'Sub Category')]")).isDisplayed()) {
				test.log(LogStatus.PASS, "Sub Category page is loaded successfully");
			}
		}catch(Exception E) {
			test.log(LogStatus.FAIL, "Sub Category page is not loaded");
		}

	}

	@Test(priority = 4, enabled = false)
	public void RefreshAndPaginination(SelfHealingDriver driver) throws Exception {
		cmp = new Common_XPaths(driver, test);

		// Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();

		// Verify Column Filtration
		//cmp.Filter_Columns_Table();
	}

	@Test(priority = 4, enabled = false)
	public void VerifyTheSubCategory(SelfHealingDriver driver) throws Exception {
		invSubCat = new Inventory_Sub_Category_Page(driver, test);

		invSubCat.Verify_SubCategory_Page();	
	}
	
	@Test(priority = 4, enabled = false)
	public void CreateTheSubCategory(SelfHealingDriver driver) throws Exception {
		invSubCat = new Inventory_Sub_Category_Page(driver, test);
		
		icp=new InventoryCategoryPage(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"taxInventory");

		Thread.sleep(5000);
		
		if(icp.EnableTax_Yes().isDisplayed()) {
			
			icp.EnableTax_Yes().click();
		}
		
		Thread.sleep(5000);
		// Load the Menu Item sales report page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id5") + "subCategory");

		Thread.sleep(5000);
		

		Thread.sleep(3000);
		//verify the new purchase template page
		invSubCat.VerifyTheNewSubCategoryPage();
		
		s = RandomStringUtils.randomAlphabetic(15);
		Thread.sleep(1000);
		//Enter the name
		invSubCat.enterTheName(s);
		
		//select the category
		invSubCat.select_Category(Cat);
		Cat = invSubCat.Cat1;
		//System.out.println("Caaaaaaaaaaaa : "+Cat);
		
		//enter the code
		invSubCat.EnterTheCode();
		
		Thread.sleep(1000);
		//Enable the override tax
		invSubCat.enableTheOverrideTax();
		
		//select the tax
		invSubCat.select_Tax();
		
		//Enter the description
		invSubCat.EnterTheDescription();
		
		//save the sub category
		invSubCat.saveTheSubCategory();
	}

	@Test(priority = 4, enabled = false)
	public void editTheSubCategory(SelfHealingDriver driver) throws Exception {
		invSubCat = new Inventory_Sub_Category_Page(driver, test);

		Thread.sleep(3000);
		
		//search the purchase template
		invSubCat.SearchTheSubCategory(s);
		
		//Click the edit button
		invSubCat.clickEditButton();
		
		//Edit and update the Sub category
		invSubCat.editTheSubCategory();
	}
	
	@Test(priority = 4, enabled = false)
	public void deleteTheSubCategory_CAncel(SelfHealingDriver driver) throws Exception {
		invSubCat = new Inventory_Sub_Category_Page(driver, test);

		Thread.sleep(3000);
		
		//search the purchase template
		invSubCat.SearchTheSubCategory(s);
		
		//cancel the deletion of the purchase template
		invSubCat.deleteCancel();
	}

	@Test(priority = 5, enabled = false)
	public void deleteTheSubCategory(SelfHealingDriver driver) throws Exception {
		Thread.sleep(3000);
		
		invSubCat = new Inventory_Sub_Category_Page(driver, test);
		
		//delete the purchase template
		invSubCat.delete();
	}
	
	@Test(priority = 5, enabled = false)
	public void verifyTheActiveStatus(SelfHealingDriver driver) throws Exception {
		Thread.sleep(3000);
		
		invSubCat = new Inventory_Sub_Category_Page(driver, test);

		//Click the active button
		invSubCat.clickTheActiveBtn();
		
		Thread.sleep(2000);
		
		//search the purchase template
		invSubCat.SearchTheSubCategory(s);
		
		//verify the availability in inactive page
		invSubCat.verifyTheTemplateAvailability(s);

		//Click the activate and cancel it
		invSubCat.clickActivateBtn();
		
		//activate the inactivated template
		invSubCat.activate();
		
		Thread.sleep(2000);
		
		invSubCat.inActiveBtn();
		
		//search the purchase template
		invSubCat.SearchTheSubCategory(s);
		
		Thread.sleep(2000);
		
		//verify the availability in active page
		invSubCat.verifyTheTemplateAvailabilityInActiveStatus(s);
	}

	public void verifyTheSubCAtegoryAvailablity(SelfHealingDriver driver) throws Exception {
		Thread.sleep(3000);
		
		invSubCat = new Inventory_Sub_Category_Page(driver, test);
		
		//Inventory item
		invSubCat.verifyInTheInventoryItem(s, Cat);
		
		//Sub Recipe
		invSubCat.verifyInTheSubRecipr(s, Cat);
		
		//Menu Item and Retail Item
		invSubCat.verifyProductAndItem_MenuItem(s, Cat);
		
	}
}
