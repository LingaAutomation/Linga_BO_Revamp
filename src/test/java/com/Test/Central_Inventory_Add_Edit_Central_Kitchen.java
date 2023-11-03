package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.Common_XPaths;
import com.Pages.DepartmentPage;
import com.Pages.Enterprise_CentralIventoryPage;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.Pages.Settings_StoreInformation_Page;
import com.Pages.UserManagementPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
public class Central_Inventory_Add_Edit_Central_Kitchen
{
	
	public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise Central Inventory - Central Kitchen");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Enterprise_CentralIventoryPage civ;
	
//	ChromeOptions chrOpt=new ChromeOptions();
	
	
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
	
			//Load the Central Kitchen page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"Central Kitchens");

		}
	}
	
	
	@Test(priority = 1,enabled = true)
	public void Login() throws Exception
	{
		
		
		Thread.sleep(2000);
//		//Call the chrome driver
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver(chrOpt);
		
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		
		options.setHeadless(false);
		
		WebDriver delegate=new ChromeDriver();
		
		driver=SelfHealingDriver.create(delegate);
//		System.setProperty("webdriver.chrome.driver","./Automation Driver/chromedriver.exe");
////		//Open the Chrome window
//		driver = new ChromeDriver();
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
	
	@Test(priority = 50,enabled = true)
	public void LogOut() throws Exception
	{
//		LogOutTest a=new LogOutTest();
		a.LogOut(driver, test);
	}
	
	
	@Test(priority=2)
	public void Calling() throws Exception
	{
		Open_Central_Kitchen_Page(driver);
		Verify_Ascending_and_Descending(driver);
		Add_Central_Kitchen(driver);
		Edit_and_Close_Cancel_Central_Kitchen(driver);
		Add_Central_Kitchen_with_Copy_From_Store(driver);
		Edit_and_Update_Central_Kitchen(driver);
		Create_Duplicate_Central_Kitchen(driver);
		Central_Kitchen_Report(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Central_Kitchen_Page(SelfHealingDriver driver) throws Exception
	{
//		((JavascriptExecutor) driver).executeScript("window.focus();");
		civ=new Enterprise_CentralIventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Central Kitchen page
//		a.Navigate_To_Page(Utility.getProperty("store_Id1"), "Central Kitchens");
		driver.get(Utility.getProperty("baseURL")+"enterprise/centralInventory/centralKitchen");
		
		Thread.sleep(5000);
		//Verify the Central Kitchens page loaded or not
		cmp.VerifyMainScreenPageHeader("Central Kitchen");
	}
	
	@Test(priority = 4,enabled = false)
	public void Verify_Ascending_and_Descending(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		civ=new Enterprise_CentralIventoryPage(driver, test);
		
		Thread.sleep(1000);
		//Verify the Ascending Order
		civ.Verify_AscendingOrder_CentralInventory();
		
		Thread.sleep(1000);
		//Verify whether the Descending Order
		civ.Verify_DescendingOrder_CentralInventory();
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Add_Central_Kitchen(SelfHealingDriver driver) throws Exception
	{
		civ=new Enterprise_CentralIventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Central Kitchens
		civ.Click_Add_Central_Kitchen();
		Thread.sleep(2000);
	
		//Verify the New Central Kitchen creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Central Kitchen");
		Thread.sleep(2000);
	
		if(cmp.Save_Button().isEnabled())
		{
			//Click the Save button
			cmp.Click_SaveButton();
		
			Thread.sleep(3000);
			//Check whether the New Central Kitchen Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Central Kitchen Name"))
			{
				test.log(LogStatus.PASS, "Please Enter Central Kitchen Name Alert Displayed");
		
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Please Enter Central Kitchen Name Alert not Displayed");
			
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		else
		{
			test.log(LogStatus.PASS, "Save button not Enabled without Entering Central Kitchen Name");
		}
	
		String NameExcess = "Entering Invalid Name to input"; 
		int ActualSize= NameExcess.length();
		System.out.println(ActualSize);

		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName(NameExcess);
		
		//To get value
		String ActualName=cmp.NameInputBox().getAttribute("value");
		int EnteredSize= ActualName.length();
		System.out.println(EnteredSize);

		if(ActualSize!=EnteredSize)
		{
			test.log(LogStatus.PASS, "Name should not be Exceeded 25 Characters");
		}
		else
		{
			test.log(LogStatus.FAIL, "Name should exceeded the size");
		}
		
		Thread.sleep(1000);
		//Enter the Phone number
		new Settings_StoreInformation_Page(driver, test).Enter_Phone_Number("98765");
		
		Thread.sleep(1000);
		//Verify whether the Error should be displayed while entering Less than the characters
		if(cmp.Error_BelowInputBox().getText().equalsIgnoreCase("Phone Number Should Be 6 To 15 Characters"))
		{
			test.log(LogStatus.PASS, "Phone Number Should Be 6 To 15 Characters Error is Displayed when entering lessthan 6 digits");
		}
		else
		{
			test.log(LogStatus.FAIL, "Phone Number Should Be 6 To 15 Characters Error is not Displayed when entering lessthan 6 digits");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Verify the Phone Number when entering excess numbers 
		cmp.Verify_Enter_Excess_Limit_InputBox(new Settings_StoreInformation_Page(driver, test).PhoneNumber_InputBox(), "987654312345678765",15);
		
		
		Thread.sleep(1000);
		//Enter the Email ID
		new Settings_StoreInformation_Page(driver, test).Enter_Email_Input("shshhsh");
		
		Thread.sleep(1000);
		//Verify whether the Error should be displayed while entering invalid Email Id
		if(cmp.Error_BelowInputBox().getText().equalsIgnoreCase("Enter Valid Email ID"))
		{
			test.log(LogStatus.PASS, "Enter Valid Email ID Error is Displayed when entring Invalid Email ID");
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter Valid Email ID Error is not Displayed when entering Invalid Email ID");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Enter the Zip code
		new Settings_StoreInformation_Page(driver, test).Enter_ZipCode("hdhdv");
		
		Thread.sleep(1000);
		//Verify whether the Error should be displayed while entering invalid Zip Code
		if(cmp.Error_BelowInputBox().getText().equalsIgnoreCase("Enter valid zip code"))
		{
			test.log(LogStatus.PASS, "Enter valid zip code Error is Displayed while entering Alphabetics");
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter valid zip code Error is not Displayed while entering Alphabetics");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
			//Enter the Zip code
				new Settings_StoreInformation_Page(driver, test).Enter_ZipCode("600");
				
				Thread.sleep(1000);
				//Verify whether the Error should be displayed while entering invalid Zip Code
				if(cmp.Error_BelowInputBox().getText().equalsIgnoreCase("Enter valid zip code"))
				{
					test.log(LogStatus.PASS, "Enter valid zip code Error is Displayed when entering Zip code lessthan 4 digits");
				}
				else
				{
					test.log(LogStatus.FAIL, "Enter valid zip code Error is not Displayed lessthan 4 digits");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				Thread.sleep(1000);
				//Verify the Zipcode when entering excess numbers 
				cmp.Verify_Enter_Excess_Limit_InputBox(new Settings_StoreInformation_Page(driver, test).ZipCode_InputBox(), "60000173636366363638",15);
				
		
	
		Thread.sleep(1500);
		//Enter the Central Kitchen Name
		cmp.EnterName(Utility.getProperty("New_Central_Kitchen"));
		
		//Enter the Description
		new DepartmentPage(driver, test).Enter_Description("This Central Inventory-Central Kitchen is : "+Utility.getProperty("New_Central_Kitchen")+ "For Kitchen Use");
		
		//Enter the Email ID
		new Settings_StoreInformation_Page(driver, test).Enter_Email_Input(Utility.getProperty("Central_emailId_Kitchen"));
		
		//Enter the Apartments and street
		new Settings_StoreInformation_Page(driver, test).Enter_Apartment(Utility.getProperty("Settings_Store_Information_Address1"));
		
		//Enter the Phone number
		new Settings_StoreInformation_Page(driver, test).Enter_Phone_Number(Utility.getProperty("Central_phoneNumber_Kitchen"));
		
		//Enter the City
		new Settings_StoreInformation_Page(driver, test).Enter_City(Utility.getProperty("Settings_Store_Information_City"));
		
		//Enter State 
		new Settings_StoreInformation_Page(driver, test).Enter_State(Utility.getProperty("Settings_Store_Information_State"));
		
		//Enter the Zip code
		new Settings_StoreInformation_Page(driver, test).Enter_ZipCode(Utility.getProperty("Settings_Store_Information_Zipcode"));
		
		//Verify whether the Save button Enabled or not without selecting Time Zone 
		if(cmp.Save_Button().isEnabled())
		{
			//Click the Save button
			cmp.Click_SaveButton();
		
			Thread.sleep(3000);
			//Check whether the New Central Kitchen Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Select Time Zone"))
			{
				test.log(LogStatus.PASS, "Please Select Time Zone Alert Displayed");
		
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Please Select Time Zone Alert not Displayed");
			
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		else
		{
			test.log(LogStatus.PASS, "Save button not Enabled without Selecting Time Zone");
		}
	
		//Select Time Zone
		new Settings_StoreInformation_Page(driver, test).Select_TimeZone("Chennai");
		
		
		//Enable the Copy from Existing store
				civ.Enable_Copy_Menu_ExistingStore_Toggle();
				
				
				Thread.sleep(1000);
				if(cmp.Save_Button().isEnabled())
				{
					Thread.sleep(500);
					//Click the Update button
					cmp.Click_UpdateButton();
					
					Thread.sleep(3000);
					//Check whether the New Central Kitchen Saved or not
					if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Kitchen Updated Successfully"))
					{
						test.log(LogStatus.FAIL, "Save button is Enabled without Selecting Store");
					
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				
				}
				else
				{
					test.log(LogStatus.PASS, "Save button is not Enabled without Selecting Store");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				
		Thread.sleep(1000);	
		//Disable Copy from Existing store
		civ.Disable_Copy_Menu_ExistingStore_Toggle();
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Central Kitchen Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Kitchen Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Central Kitchen Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Central Kitchen Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 6,enabled = false)
	public void Edit_and_Close_Cancel_Central_Kitchen(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		civ=new Enterprise_CentralIventoryPage(driver, test);
		
		Thread.sleep(5000);
		//Search and Click Edit button
		civ.Search_and_Edit_CentralInventory(Utility.getProperty("New_Central_Kitchen"));
		
		//Check whether the application displays Update screen or not
		cmp.VerifyCreationScreenPageHeader("Update Central Kitchen");
				
		
		Thread.sleep(1000);
		//Click the Close button
		cmp.Click_CloseButton();
		
		Thread.sleep(1000);
		//Check whether the New Central Kitchen Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Editing Central Kitchen screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Editing Central Kitchen screen not Closed");
		}
		
		
		Thread.sleep(1000);
		//Search the Central Kitchens to Click Edit and Cancel
		civ.Search_and_Edit_CentralInventory(Utility.getProperty("New_Central_Kitchen"));
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Central Kitchen Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Central Kitchen screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Central Kitchen screen not Closed");
		}
		
	}
	
	@Test(priority = 7,enabled = false)
	public void Edit_and_Update_Central_Kitchen(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		civ=new Enterprise_CentralIventoryPage(driver, test);
		
		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
//		cmp.SearchAndVerify_SearchBox();
	
		Thread.sleep(3000);
		//Search and Click Edit button
		civ.Search_and_Edit_CentralInventory(Utility.getProperty("New_Central_Kitchen"));
		
		
		Thread.sleep(1500);
		//Enter the Name
		cmp.EnterName("");
	
		Thread.sleep(1000);
		if(cmp.Update_Button().isEnabled())
		{
			Thread.sleep(500);
			//Click the Update button
			cmp.Click_UpdateButton();
			
			Thread.sleep(3000);
			//Check whether the New Central Kitchen Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Kitchen Updated Successfully"))
			{
				test.log(LogStatus.FAIL, "Central Kitchen Updated without Central Kitchen Name");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				Thread.sleep(3000);
				//Search and Click Edit button
				civ.Search_and_Edit_CentralInventory(Utility.getProperty("New_Central_Kitchen")+"1");
				
			}
		
		}
		else
		{
			test.log(LogStatus.PASS, "Central Kitchen not Updated without Central Kitchen Name");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("New_Central_Kitchen")+"1");
		
		//Enter the Apartments and street
		new Settings_StoreInformation_Page(driver, test).Enter_Apartment(Utility.getProperty("Settings_Store_Information_Address1")+"Near");
	
		
//		Thread.sleep(2000);
//		//Enable the Copy from Existing store
//		civ.Enable_Copy_Menu_ExistingStore_Toggle();
//		
//		
//		Thread.sleep(1000);
//		if(cmp.Update_Button().isEnabled())
//		{
//			Thread.sleep(500);
//			//Click the Update button
//			cmp.Click_UpdateButton();
//			
//			Thread.sleep(3000);
//			//Check whether the New Central Kitchen Saved or not
//			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Kitchen Updated Successfully"))
//			{
//				test.log(LogStatus.FAIL, "Update button is Enabled without Selecting Store");
//			
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//		
//		}
//		else
//		{
//			test.log(LogStatus.PASS, "Update button is not Enabled without Selecting Store");
//			
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		
//		//Select the Store
//		civ.Select_Store();
//	
		
		Thread.sleep(1000);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Central Kitchen Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Kitchen Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Central Kitchen Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Central Kitchen Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 7,enabled = false)
	public void Add_Central_Kitchen_with_Copy_From_Store(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		civ=new Enterprise_CentralIventoryPage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Central Kitchens
		civ.Click_Add_Central_Kitchen();
		Thread.sleep(2000);
	
		//Verify the New Central Kitchen creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Central Kitchen");
		Thread.sleep(2000);
		
		Thread.sleep(500);
		//Enter the Central Kitchen Name
		cmp.EnterName(Utility.getProperty("New_Central_Kitchen")+"a");
		
		//Enter the Description
		new DepartmentPage(driver, test).Enter_Description("This Central Inventory-Central Kitchen (Copy from existing Store) is : "+Utility.getProperty("New_Central_Kitchen")+ "For Kitchen Use");
		
		//Enter the Zip code
		new Settings_StoreInformation_Page(driver, test).Enter_ZipCode(Utility.getProperty("Settings_Store_Information_Zipcode"));
	
		//Select Time Zone
		new Settings_StoreInformation_Page(driver, test).Select_TimeZone("Chennai");
		
		//Enable the Copy from Existing store
		civ.Enable_Copy_Menu_ExistingStore_Toggle();
		
		
		
		Thread.sleep(1000);
		if(cmp.Save_Button().isEnabled())
		{
			Thread.sleep(500);
			//Click the Save button
			cmp.Click_SaveButton();
			
			Thread.sleep(3000);
			//Check whether the New Central Kitchen Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Kitchen Saved Successfully"))
			{
				test.log(LogStatus.FAIL, "Save button is Enabled without Selecting Store");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		
		}
		else
		{
			test.log(LogStatus.PASS, "Save button is not Enabled without Selecting Store");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		//Select the Store
				civ.Select_Store();
			
				
		Thread.sleep(1000);
		//Verify whether the Copy from Existing store Enabled or not
		if(civ.Copy_Menu_ExistingStore_YesToggle().isEnabled())
		{
			test.log(LogStatus.PASS, "Copy from Existing Store Toggle is Enabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Copy from Existing Store Toggle is not Enabled");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Central Kitchen Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Kitchen Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Central Kitchen Saved Successfully Enabled with Copy from Existing Store");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Central Kitchen Saved Failed Enabled with Copy from Existing Store");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		
	}
	
	
	
	@Test(priority = 9,enabled = false)
	public void Create_Duplicate_Central_Kitchen(SelfHealingDriver driver) throws Exception
	{
		civ=new Enterprise_CentralIventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New Central Kitchens button
		civ.Click_Add_Central_Kitchen();
		Thread.sleep(2000);
	
		Thread.sleep(500);
		//Enter the existing Central Kitchen name
		cmp.EnterName(Utility.getProperty("New_Central_Kitchen"));
		
		Thread.sleep(1000);
		//Select Time Zone
		new Settings_StoreInformation_Page(driver, test).Select_TimeZone("Chennai");
				
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Central Kitchen Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Kitchen Name already exist"))
		{
			test.log(LogStatus.PASS, "Central Kitchen Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_CancelButton();
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error(s)"))
		{
			test.log(LogStatus.PASS, "Validation Error(s) pop up displayed");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_CancelButton();
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Central Kitchen Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Duplicate Central Kitchen Saved");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Central Kitchen Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	
	@Test(priority = 9,enabled = false)
	public void Central_Kitchen_Report(SelfHealingDriver driver) throws Exception
	{
		civ=new Enterprise_CentralIventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		new Common_XPaths(driver, test).SearchBox().clear();
		Thread.sleep(1000);
		new Common_XPaths(driver, test).SearchBox().sendKeys(Utility.getProperty("New_Central_Kitchen"));
		
		Thread.sleep(2000);
		//Select the Searched Central Inventory
		driver.findElement(By.xpath("//div[@class='central-warehouse-content']//span[.='"+Utility.getProperty("New_Central_Kitchen")+"']")).click();
		
		Thread.sleep(2000);
		//Verify whether the Total Value on Hand is Displayed or not
		if(driver.findElement(By.xpath("//span[contains(.,'Total Value On Hand')]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Total Value on Hand is available");
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Total Value on Hand is not available");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		if(civ.Low_Stocks_RightArrow.isDisplayed())
		{
			test.log(LogStatus.PASS, "Low Stocks screen Available");
			
			
			//Click the Low Stocks 
			civ.Low_Stocks_RightArrow.click();
			
			Thread.sleep(2000);
			
			try
			{
				if(driver.findElement(By.xpath("//td[contains(.,'Low Stocks not found')]")).isDisplayed())
				{
					test.log(LogStatus.FAIL, "Low Stocks not found");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception k)
			{
				test.log(LogStatus.FAIL, "Low Stocks found");

			//Get the List of available Low Stocks
			List<WebElement> rowList=driver.findElements(By.xpath("//table/tbody/tr"));
			
			int rowSize=rowList.size();
			
			
			
			if(rowSize<=5)
			{
			for(int i=1;i<=rowSize;i++)
			{
				
				test.log(LogStatus.INFO, "Item Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Unit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+ " Minimum Qty : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Available Qty : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText());
			}
			}
			else
			{
				for(int i=1;i<=5;i++)
				{
					
					test.log(LogStatus.INFO, "Item Name : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[1]")).getText()+" Unit : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[2]")).getText()+ " Minimum Qty : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[3]")).getText()+" Available Qty : "+driver.findElement(By.xpath("//table/tbody/tr["+i+"]/td[4]")).getText());
				}
			}
			}
			//Close the Low Stocks screen
			civ.Low_Stocks_DownArrow.click();
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Low Stocks screen not Available");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
}
