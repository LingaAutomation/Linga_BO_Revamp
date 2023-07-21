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
import com.Pages.Common_XPaths;

import com.Pages.Inventory_InHouseUnits_Page;
import com.Pages.LoginPage;
import com.Pages.TaxesPage;
import com.Pages.UpchargesPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_InHouseUnits
{
	public WebDriver driver;


	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Inventory_InHouseUnits ");

	LoginPage lgpg; 

	Utility ut=new Utility();

	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Inventory_InHouseUnits_Page IHU;

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
		//System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
		//Open the Chrome window
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
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
		Open_InHouseUnits_Page(driver);
		//RefreshAndPaginination_Column_Filteration(driver);
		Sorting_Name(driver);
		Add_New_InHouse_Unit(driver);
		Add_New_InHouse_Unit_SpecialChar(driver);
		Edit_Cancel_Close_InHouseUnit(driver);
		Edit_And_Update_InHouseUnit(driver);
		InActive_And_activate_InHouseUnit(driver);
		Creating_Duplicate_InHouseUnit(driver);
	
	}

	@Test(priority = 3, enabled = false)
	public void Open_InHouseUnits_Page(WebDriver driver) throws Exception
	{
		cmp = new Common_XPaths(driver, test);
		IHU = new Inventory_InHouseUnits_Page(driver, test);

		Thread.sleep(5000);
		//Load the Upcharge page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"inHouseUnits");

		Thread.sleep(10000);
		//Verify the Open Check Discount page loeded or not
		cmp.VerifyMainScreenPageHeader("In House Units");	


	}

	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination_Column_Filteration(WebDriver driver) throws Exception
	{
		cmp = new Common_XPaths(driver, test);

		cmp.VerifyPagination_and_Refresh_Publish();

		Thread.sleep(1000);

		cmp.Filter_Columns();
	}

	@Test(priority = 5,enabled = false)
	public void Sorting_Name(WebDriver driver) throws Exception 
	{
		IHU = new Inventory_InHouseUnits_Page(driver, test);

		IHU.Sorting_Name();
	}

	@Test(priority = 6,enabled = false)
	public void Add_New_InHouse_Unit(WebDriver driver) throws Exception
	{
		IHU = new Inventory_InHouseUnits_Page(driver, test);
		cmp = new Common_XPaths(driver, test);
		ut = new Utility();

		IHU.Click_NewInHouseUnit();

		cmp.VerifyMainScreenPageHeader(" New In-House Unit ");

		if(cmp.Save_Button().isEnabled()) 
		{
			test.log(LogStatus.FAIL,"By default save button is enabled");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		else 
		{
			test.log(LogStatus.PASS,"Save button is not enabled");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		cmp.Click_CancelButton();

		IHU.Click_NewInHouseUnit();

		Thread.sleep(1000);

		IHU.Enter_Name(Utility.getProperty("InHouseUnitName"));

		IHU.Click_Weight();

		Thread.sleep(1000);

		cmp.Click_SaveButton();

		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Unit saved successfully"))
		{
			test.log(LogStatus.PASS,"InHouseUnit saved Successfully");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		else 
		{
			test.log(LogStatus.FAIL,"InHouseAccount not saved Successfully");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

	}
	
	public void Add_New_InHouse_Unit_SpecialChar(WebDriver driver) throws Exception 
	{
		IHU = new Inventory_InHouseUnits_Page(driver, test);
		cmp = new Common_XPaths(driver, test);
		ut = new Utility();

		IHU.Click_NewInHouseUnit();

		cmp.VerifyMainScreenPageHeader(" New In-House Unit ");
		
		Thread.sleep(1000);

		IHU.Enter_Name(Utility.getProperty("InHouseUnitNameSpecialChar"));

		IHU.Click_Weight();

		Thread.sleep(1000);

		cmp.Click_SaveButton();

		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Unit saved successfully"))
		{
			test.log(LogStatus.PASS,"InHouseUnit saved Successfully for Special Characters");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		else 
		{
			test.log(LogStatus.FAIL,"InHouseAccount not saved Successfully");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}

	@Test(priority = 7,enabled = false)
	public void Edit_Cancel_Close_InHouseUnit(WebDriver driver) throws Exception 
	{
		cmp = new Common_XPaths(driver, test);
		IHU = new Inventory_InHouseUnits_Page(driver, test);

		//cmp.SearchAndVerify_SearchBox();

		Thread.sleep(1000);

		IHU.SearchAndClickEdit(Utility.getProperty("InHouseUnitName"));
		if(cmp.Update_Button().isEnabled()) 
		{
			test.log(LogStatus.FAIL,"Update button enabled by Default");
		}
		else 
		{
			test.log(LogStatus.PASS,"Update button not enabled by Default");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		Thread.sleep(1000);
		cmp.Click_CancelButton();

	}

	@Test(priority = 8,enabled = false)

	public void Edit_And_Update_InHouseUnit(WebDriver driver) throws Exception 
	{
		cmp = new Common_XPaths(driver, test);
		IHU = new Inventory_InHouseUnits_Page(driver, test);

		IHU.SearchAndClickEdit(Utility.getProperty("InHouseUnitName"));
		Thread.sleep(1000);
		IHU.Enter_Name(Utility.getProperty("InHouseUnitName"));
		Thread.sleep(500);
		IHU.Click_Volume();

		cmp.Click_UpdateButton();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Unit Updated Successfully"))
		{
			test.log(LogStatus.PASS,"In house Unit Updated Successfully");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else {
			test.log(LogStatus.FAIL,"In house Unit Updated Successfully");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

		Thread.sleep(500);

		IHU.SearchAndClickEdit(Utility.getProperty("InHouseUnitName"));
		Thread.sleep(1000);
		IHU.Enter_Name(Utility.getProperty("InHouseUnitName"));
		Thread.sleep(500);
		IHU.Add_Conversion_Unit();
		Thread.sleep(500);
		IHU.Enter_Rate();

		IHU.Selecting_Unit();
		Thread.sleep(500);

		cmp.Click_UpdateButton();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Unit Updated Successfully"))
		{
			test.log(LogStatus.PASS,"In house Unit Updated Successfully");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else {
			test.log(LogStatus.FAIL,"In house Unit Updated Successfully");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);

			cmp.Click_CancelButton();
		}


	}

	@Test(priority = 9,enabled = false)
	public void InActive_And_activate_InHouseUnit(WebDriver driver) throws Exception 
	{

		cmp = new Common_XPaths(driver, test);
		IHU = new Inventory_InHouseUnits_Page(driver, test);

		IHU.SearchAndClickDelete(Utility.getProperty("InHouseUnitName"));

		//Cancel the delete
		IHU.Cancel();

		Thread.sleep(1000);

		IHU.SearchAndClickDelete(Utility.getProperty("InHouseUnitName"));

		cmp.Click_DeleteButton();

		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Unit inactivated Successfully"))
		{
			test.log(LogStatus.PASS,"InHouseunit Inactivated Successfully");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(1000);
			cmp.Click_ActivetoInactiveButton();
			Thread.sleep(1000);

			IHU.SearchAndClickActivate(Utility.getProperty("InHouseUnitName"));
			Thread.sleep(500);
			cmp.Click_ActivateButton();
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Unit activated successfully")) 
			{
				test.log(LogStatus.PASS,"InhouseUnit Activated Successfully");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else 
			{
				test.log(LogStatus.FAIL,"InhouseUnit Activated Successfully");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
			Thread.sleep(5000);

		}

		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("This inhouse unit is associated with one of the inventoryitems or subrecipes.Could not Inactivate!.")) 
		{
			test.log(LogStatus.PASS,"Unable to Inactivae Inhouse unit because it's associated with Inventory Item" );
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else {
			test.log(LogStatus.FAIL,"InHouseunit Not Inactivated Successfully");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		
//		cmp.Click_InactivetoActiveButton();
//
//		Thread.sleep(1000);

	}

	@Test(priority = 10,enabled = false)
	public void Creating_Duplicate_InHouseUnit(WebDriver driver) throws Exception 
	{
		IHU = new Inventory_InHouseUnits_Page(driver, test);
		cmp = new Common_XPaths(driver, test);
		ut = new Utility();

		IHU.Click_NewInHouseUnit();

		cmp.VerifyMainScreenPageHeader(" New In-House Unit ");

		Thread.sleep(1000);

		IHU.Enter_Name(Utility.getProperty("InHouseUnitName"));

		IHU.Click_Weight();

		Thread.sleep(1000);

		cmp.Click_SaveButton();
		Thread.sleep(1000);

		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist")) 
		{
			test.log(LogStatus.PASS,"Name already exist popup displayed");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		else {
			test.log(LogStatus.FAIL,"Name already exist popup not displayed");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		cmp.Click_CancelButton();
		Thread.sleep(4000);

	}

}
