package com.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.Common_XPaths;
import com.Pages.CoursingPage;
import com.Pages.LoginPage;
import com.Pages.Royalty_Franchise_Page;
//import com.Pages.Scheduler_Page;
import com.Pages.Settings_StoreInformation_Page;
import com.Pages.UserMangement_Role_Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;

public class Enterprise_Settings_Royalty_Franchise {
	public WebDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise Settings - User Management - Account Users");

	LoginPage lgpg;

	Utility ut = new Utility();

	Common_XPaths cmp;
	LoginTest a = new LoginTest();
	Royalty_Franchise_Page RFP;
	CoursingPage cp;
	Settings_StoreInformation_Page sf;
	UserMangement_Role_Page umr;
//	Scheduler_Page sp;

	String Role;
	String EmailId;
	String Password;
	String PIN;

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
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().driverVersion("110.0.5841").setup();
//		driver=new ChromeDriver(chrOpt);

		System.setProperty("webdriver.chrome.driver", "./Automation Driver/chromedriver.exe");
		// Open the Chrome window
		driver = new ChromeDriver();
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
		Open_Settings_Royalty_Franchise_Page(driver);
		RefreshAndPaginination_ColumnFilteration(driver);
		Search_store_Royalty_Franchise(driver);
		Save_withOut_mandatory_Detail(driver);
		Edit_Name_close_royalty(driver);

	}

	@Test(priority = 3, enabled = false)
	public void Open_Settings_Royalty_Franchise_Page(WebDriver driver) throws Exception {

		cmp = new Common_XPaths(driver, test);

		Thread.sleep(5000);
		// Load the Department page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id7") + "home");

		Thread.sleep(10000);
		// Load the Department page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id2") + "royalty");

		Thread.sleep(5000);
		// Verify the User page loaded or not
		cmp.VerifyMainScreenPageHeader("Royalty/Franchise");
	}

	@Test(priority = 4, enabled = false)
	public void RefreshAndPaginination_ColumnFilteration(WebDriver driver) throws Exception {
		cmp = new Common_XPaths(driver, test);

		Thread.sleep(2000);

		driver.navigate().refresh();
		Thread.sleep(5000);

		if (driver.findElement(By.xpath("//mat-paginator/div")).isDisplayed()) {
			test.log(LogStatus.PASS, "Pagination Available");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);

			List<WebElement> pageList = driver.findElements(By.xpath("//mat-paginator/div/div//button"));

			Thread.sleep(2000);
			for (int i = 2; i < pageList.size(); i++) {
				Thread.sleep(1000);
				driver.findElement(By.xpath("//mat-paginator/div/div//button[" + i + "]")).click();
			}
			Thread.sleep(1000);
			driver.findElement(By.xpath("//mat-paginator/div/div//button[2]")).click();

			test.log(LogStatus.INFO, "Pagination Completed");
		} else {
			test.log(LogStatus.FAIL, "Pagination not available");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}

	@Test(priority = 4, enabled = false)
	public void Search_store_Royalty_Franchise(WebDriver driver) throws Exception {
		cmp = new Common_XPaths(driver, test);

		cmp.SearchAndVerify_SearchBox();
		test.log(LogStatus.INFO, "Search the Store Name with  3 characters");

	}
	
	@Test(priority = 4, enabled = false)
	public void Save_withOut_mandatory_Detail(WebDriver driver) throws Exception {
		cmp = new Common_XPaths(driver, test);
		RFP = new Royalty_Franchise_Page(driver, test);
		
		Thread.sleep(3000);
		List<WebElement> optList1 = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));

		int optionSize1 = optList1.size();

		int randomOpt = ThreadLocalRandom.current().nextInt(1, optionSize1);

		String SearchText = driver.findElement(By.xpath("//table/tbody/tr["+ randomOpt+"]/td[1]/span")).getText();

		Thread.sleep(1000);
		RFP.SearchBox().clear();
		Thread.sleep(2000);

		RFP.SearchBox().sendKeys(SearchText);
		Thread.sleep(2000);
		

		if (driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]//mat-slide-toggle")).isEnabled()) {
			test.log(LogStatus.INFO, "Activate Royalty is Eanabled ");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//table/tbody/tr/td[3]//button")).click();
			Thread.sleep(2000);
			Thread.sleep(5000);
			// Verify the User page loaded or not
			cmp.VerifyCreationScreenPageHeader("Update Royalty/Franchise");

			RFP.Bank_name().clear();
			Thread.sleep(2000);

			String NameExcess = "Entering Invalid Name to input";
			int ActualSize = NameExcess.length();
			System.out.println(ActualSize);

			// Enter the Modifier Name
			RFP.Bank_name().sendKeys(NameExcess);

			// To get value
			String ActualName = cmp.NameInputBox().getAttribute("value");
			int EnteredSize = ActualName.length();
			System.out.println(EnteredSize);

			if (ActualSize != EnteredSize) {
				test.log(LogStatus.PASS, "Name should not be Exceeded 25 Characters");
			} else {
				test.log(LogStatus.FAIL, "Name should exceeded the size");
			}

			RFP.Bank_name().clear();

			Thread.sleep(2000);

			String Bank_name = RandomStringUtils.randomAlphabetic(7);

			RFP.Bank_name().sendKeys(Bank_name);

			Thread.sleep(2000);

			RFP.Routing_name().clear();

			Thread.sleep(2000);

			String Routing_number = RandomStringUtils.randomNumeric(7);

			RFP.Routing_name().sendKeys(Routing_number);

			RFP.Account_number().clear();

			Thread.sleep(2000);

			String Account_number = RandomStringUtils.randomNumeric(7);

			RFP.Account_number().sendKeys(Account_number);

			//RFP.Enter_Set_Presentage("Test", "2340");

			Thread.sleep(10000);
			
			RFP.Bank_name().clear();
			Thread.sleep(10000);
			cmp.Click_UpdateButton();
			
			

			cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
			// Check whether the New Course Saved or not
			if (cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please enter bank name")) {
				test.log(LogStatus.PASS, "Please enter bank name pop up is displayed");

				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			} else {
				test.log(LogStatus.FAIL, "Please enter bank name pop up is not displayed");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
	
			Thread.sleep(1000);
			RFP.SearchBox().clear();
			Thread.sleep(2000);

			RFP.SearchBox().sendKeys(SearchText);
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//table/tbody/tr/td[3]//button")).click();
			Thread.sleep(2000);

			RFP.Bank_name().clear();

			Thread.sleep(2000);

			String Bank_name3 = RandomStringUtils.randomAlphabetic(7);

			RFP.Bank_name().sendKeys(Bank_name3);

			Thread.sleep(2000);

			RFP.Routing_name().clear();

			cmp.Click_UpdateButton();

			cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
			// Check whether the New Course Saved or not
			if (cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please enter the routing number")) {
				test.log(LogStatus.PASS, "Please enter the routing number pop up is displayed");

				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			} else {
				test.log(LogStatus.FAIL, "Please enter the routing number pop up is not displayed");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
			Thread.sleep(3000);

			Thread.sleep(1000);
			RFP.SearchBox().clear();
			Thread.sleep(2000);

			RFP.SearchBox().sendKeys(SearchText);
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//table/tbody/tr/td[3]//button")).click();
			Thread.sleep(2000);
			
			Thread.sleep(2000);

			RFP.Routing_name().clear();

			Thread.sleep(2000);

			String Routing_number2 = RandomStringUtils.randomNumeric(7);

			RFP.Routing_name().sendKeys(Routing_number2);

			Thread.sleep(2000);
			RFP.Account_number().clear();

			Thread.sleep(2000);

			cmp.Click_UpdateButton();

			cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
			// Check whether the New Course Saved or not
			if (cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enter Account Number")) {
				test.log(LogStatus.PASS, "Enter Account Number pop up is displayed");

				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			} else {
				test.log(LogStatus.FAIL, "Enter Account Number pop up is not displayed");

				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
			Thread.sleep(3000);

			Thread.sleep(1000);
			RFP.SearchBox().clear();
			Thread.sleep(2000);

			RFP.SearchBox().sendKeys(SearchText);
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//table/tbody/tr/td[3]//button")).click();
			Thread.sleep(2000);
			Thread.sleep(2000);

			RFP.Account_number().clear();

			Thread.sleep(2000);

			String Account_number3 = RandomStringUtils.randomNumeric(7);

			RFP.Account_number().sendKeys(Account_number3);

			try {
				cmp.Click_UpdateButton();

				cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
				// Check whether the New Course Saved or not
				if (cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Royalty details updated successfully.")) {
					test.log(LogStatus.PASS, "Royalty details updated successfully.");

					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				} else {
					test.log(LogStatus.FAIL, "Royalty details updated Failed");

					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			} catch (Exception e) {
				cmp.Click_SaveButton();

				cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
				// Check whether the New Course Saved or not
				if (cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Royalty details save successfully.")) {
					test.log(LogStatus.PASS, "Royalty details save successfully.");

					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				} else {
					test.log(LogStatus.FAIL, "Royalty details save Failed");

					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}

			}

		} else {
			driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]//mat-slide-toggle")).click();

			Thread.sleep(5000);
			// Verify the User page loaded or not
			cmp.VerifyCreationScreenPageHeader("Update Royalty/Franchise");

			RFP.Bank_name().clear();
			Thread.sleep(2000);

			String NameExcess = "Entering Invalid Name to input";
			int ActualSize = NameExcess.length();
			System.out.println(ActualSize);

			// Enter the Modifier Name
			RFP.Bank_name().sendKeys(NameExcess);

			// To get value
			String ActualName = cmp.NameInputBox().getAttribute("value");
			int EnteredSize = ActualName.length();
			System.out.println(EnteredSize);

			if (ActualSize != EnteredSize) {
				test.log(LogStatus.PASS, "Name should not be Exceeded 25 Characters");
			} else {
				test.log(LogStatus.FAIL, "Name should exceeded the size");
			}

			RFP.Bank_name().clear();

			Thread.sleep(2000);

			String Bank_name = RandomStringUtils.randomAlphabetic(7);

			RFP.Bank_name().sendKeys(Bank_name);

			Thread.sleep(2000);

			RFP.Routing_name().clear();

			Thread.sleep(2000);

			String Routing_number = RandomStringUtils.randomNumeric(7);

			RFP.Routing_name().sendKeys(Routing_number);

			RFP.Account_number().clear();

			Thread.sleep(2000);

			String Account_number = RandomStringUtils.randomNumeric(7);

			RFP.Account_number().sendKeys(Account_number);

			RFP.Enter_Set_Presentage("Test", "2340");

			try {
				cmp.Click_UpdateButton();

				cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
				// Check whether the New Course Saved or not
				if (cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Royalty details updated successfully.")) {
					test.log(LogStatus.PASS, "Royalty details updated successfully.");

					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				} else {
					test.log(LogStatus.FAIL, "Royalty details updated Failed");

					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			} catch (Exception e) {
				cmp.Click_SaveButton();

				cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
				// Check whether the New Course Saved or not
				if (cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Royalty details save successfully.")) {
					test.log(LogStatus.PASS, "Royalty details save successfully.");

					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				} else {
					test.log(LogStatus.FAIL, "Royalty details save Failed");

					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}

			}
		}

	
		
	}
	
	@Test(priority = 4, enabled = false)
	public void Edit_Name_close_royalty(WebDriver driver) throws Exception {
		cmp = new Common_XPaths(driver, test);
		RFP = new Royalty_Franchise_Page(driver, test);

		Thread.sleep(3000);
		List<WebElement> optList1 = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));

		int optionSize1 = optList1.size();

		int randomOpt = ThreadLocalRandom.current().nextInt(1, optionSize1);

		String SearchText = driver.findElement(By.xpath("//table/tbody/tr[" + randomOpt + "]/td[1]")).getText();

		Thread.sleep(1000);
		RFP.SearchBox().clear();
		Thread.sleep(2000);

		RFP.SearchBox().sendKeys(SearchText);
		Thread.sleep(2000);

		if (driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]//mat-slide-toggle")).isEnabled()) {
			test.log(LogStatus.INFO, "Activate Royalty is Eanabled ");
			Thread.sleep(2000);
			driver.findElement(By.xpath("//table/tbody/tr/td[3]//button")).click();
			Thread.sleep(2000);

			Thread.sleep(5000);
			// Verify the User page loaded or not
			cmp.VerifyCreationScreenPageHeader("Update Royalty/Franchise");

			RFP.Bank_name().clear();
			Thread.sleep(2000);
			
			RFP.Bank_name().clear();

			Thread.sleep(2000);

			String Bank_name = RandomStringUtils.randomAlphabetic(7);

			

			String NameExcess = Bank_name;
			int ActualSize = NameExcess.length();
			System.out.println(ActualSize);

			// Enter the Modifier Name
			RFP.Bank_name().sendKeys(NameExcess);

			// To get value
			String ActualName = cmp.NameInputBox().getAttribute("value");
			System.out.println(ActualName);
	
			cmp.Click_CloseButton();
			
			
			Thread.sleep(2000);
			RFP.SearchBox().clear();
			Thread.sleep(2000);

			RFP.SearchBox().sendKeys(SearchText);
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//table/tbody/tr/td[3]//button")).click();
			
			
			String AfterReopen_Name = cmp.NameInputBox().getAttribute("value");
			System.out.println(AfterReopen_Name);
			
			if(ActualName.equalsIgnoreCase(AfterReopen_Name)) {
			
				System.out.println("Name save by clicking on close button");
			}
			else {
				System.out.println("Name not save by clicking on close button");
			}
			
			cmp.Click_CloseButton();
		
		
	}
	}
	
	@Test(priority = 4, enabled = false)
	public void Verify_close_Cancel_royalty(WebDriver driver) throws Exception {
		cmp = new Common_XPaths(driver, test);
		RFP = new Royalty_Franchise_Page(driver, test);
		
		Thread.sleep(3000);
		List<WebElement> optList1 = driver.findElements(By.xpath("//table/tbody/tr/td[1]"));

		int optionSize1 = optList1.size();

		int randomOpt = ThreadLocalRandom.current().nextInt(1, optionSize1);

		String SearchText = driver.findElement(By.xpath("//table/tbody/tr[" + randomOpt + "]/td[1]")).getText();

		Thread.sleep(1000);
		RFP.SearchBox().clear();
		Thread.sleep(2000);

		RFP.SearchBox().sendKeys(SearchText);
		Thread.sleep(2000);

		
		Thread.sleep(1000);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Royalty/Franchise");
		
		
		Thread.sleep(1000);
		//Click the Close button
		cmp.Click_CloseButton();
		
		Thread.sleep(1000);
		//Check whether the New Reason Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Editing Reason screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Editing Reason screen not Closed");
		}
		
		
		Thread.sleep(1000);
		//Search the Reasons to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("TaxExemptReason"));
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		
		Thread.sleep(1000);
		//Check whether the New Reason Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Editing Reason screen Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Editing Reason screen not Cancelled");
		}
	}


	}