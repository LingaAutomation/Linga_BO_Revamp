package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.Availability_RestrictionTimePage;
import com.Pages.CategoriesPage;
import com.Pages.Common_XPaths;
import com.Pages.KitchenPrinterPage;
import com.Pages.ModifiersPage;
import com.Pages.LoginPage;
import com.Pages.ModifiersPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_Modifiers 
{

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete Modifiers");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	ModifiersPage mp;
	KitchenPrinterPage kpp;
	CategoriesPage cp;
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
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
//		//Open the Chrome window
//		driver = new ChromeDriver();
		
		ChromeOptions chrOpt=new ChromeOptions();
		chrOpt.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(chrOpt);
		
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
		Open_Modifiers_Page(driver);
//		RefreshAndPaginination(driver);
//		Add_Modifiers(driver);
//		Edit_and_Close_Cancel_Modifiers(driver);
		Edit_and_Remove_Prefix_Update_Modifiers(driver);
		Edit_and_Remove_ServingSizeLevels_Update_Modifiers(driver);
		Edit_and_Update_Modifiers(driver);
		Delete_and_Active_Inactive_Modifiers(driver);
		Add_Modifiers_BasicDetails(driver);
		Create_DuplicateModifier(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Modifiers_Page(WebDriver driver) throws Exception
	{
		
		mp=new ModifiersPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Modifier page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"modifiers");

		Thread.sleep(5000);
		//Verify the Modifiers page loeded or not
		cmp.VerifyMainScreenPageHeader("Modifiers");	
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_Modifiers(WebDriver driver) throws Exception
	{
		mp=new ModifiersPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		kpp=new KitchenPrinterPage(driver, test);
		cp=new CategoriesPage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Modifiers
		mp.Click_NewModifier();
		Thread.sleep(2000);
	
		//Verify the New Modifier creation screen opened or not 
		cmp.VerifyCreationScreenPageHeader("New Modifier");
		Thread.sleep(3000);
		
		//Click Proceed to Inventory Mapping button
				mp.Click_ProceedToInventoryMappingTab();
				
				Thread.sleep(1000);
				//Click Save and Proceed button
				cmp.Alert_PopupMsg("There is unsaved data. If you proceed to inventory step, you will loose changes Do you want to continue without saving?");
				
				Thread.sleep(1000);
				//Click Proceed without paying
				mp.Click_ProceedWithoutSaving();
				
				if(mp.ProceedToInventoryMappingTab().isSelected())
				{
					test.log(LogStatus.PASS, "Proceed to Inventory Mapping selected when Clicking Proceed Without Saving");
				}
				else
				{
					test.log(LogStatus.FAIL, "Proceed to Inventory Mapping not selected when Clicking Proceed Without Saving");
			
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				if(mp.InfoContent().getText().equalsIgnoreCase("Please add basic details and serving sizes before entering inventory details"))
				{
					test.log(LogStatus.PASS, "Please add basic details and serving sizes before entering inventory details Displayed");
				}
				else
				{
					test.log(LogStatus.FAIL, "Please add basic details and serving sizes before entering inventory details not Displayed");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				Thread.sleep(1000);
				//Click Serving Size and Prefix Tab
				mp.Click_ServingSizePrefixTab();
				
				Thread.sleep(1000);
				//Click Proceed to Inventory Mapping button
						mp.Click_ProceedToInventoryMappingTab();
						
						Thread.sleep(1000);
						//Click Save and Proceed button
						cmp.Alert_PopupMsg("There is unsaved data. If you proceed to inventory step, you will loose changes Do you want to continue without saving?");
						
						Thread.sleep(1000);
						//Click the Save and Proceed button
						mp.Click_SaveAndProceed();
						
						Thread.sleep(3000);
						//Check whether the New Course Saved or not
						if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enter Name"))
						{
							test.log(LogStatus.PASS, "Enter Name Alert Displayed");
						
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
						}
						else
						{
							test.log(LogStatus.FAIL, "Enter Name Alert not Displayed");
							
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						Thread.sleep(1000);
						//Click Basic Details Tab
						mp.Click_BasicDetailsTab();
		
						Thread.sleep(1000);

		//Upload picture
		cmp.Upload_Picture(Utility.getProperty("Settings_Store_Information_Store_Image_Path"));
		
		Thread.sleep(1000);
		//Enter the Modifier Name
		cmp.EnterName(Utility.getProperty("Modifier_Name"));
		
		
		//Click Save and Publish button
				cmp.Click_Save_and_PublishButton();
				
				Thread.sleep(3000);
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Set maximum no of time that modifier can be used."))
				{
					test.log(LogStatus.PASS, "Set maximum no of time that modifier can be used pop up Displayed");
				
				}
				else
				{
					test.log(LogStatus.FAIL, "Set maximum no of time that modifier can be used pop up not Displayed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
		
		Thread.sleep(1500);
		//Enter Secondary name
		mp.Enter_SecondaryName("S1");
		
		//Enter PLU Code
		mp.Enter_PLUCode("A001");
		
		Thread.sleep(500);
		//Enter Maximum No of Times
		mp.Enter_MaximumNoOfTimes("0");
		
		//Check whether the Enter valid maximum number of times displayed or not
		if(mp.Max_TimesErrorMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter valid maximum number of times Displayed when Entering 0");
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter valid maximum number of times not diisplayed when Entering 0");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(500);
		//Enter Maximum No of Times
//		mp.Enter_MaximumNoOfTimes("-1");
//		
//		//Check whether the Enter valid maximum number of times displayed or not
//		if(mp.Max_TimesErrorMsg().isDisplayed())
//		{
//			test.log(LogStatus.PASS, "Enter valid maximum number of times Displayed when Entering Negative values");
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Enter valid maximum number of times not diisplayed when Entering Negative values");
//		}
//		
		
		Thread.sleep(500);
		//Enter Maximum No of Times
		mp.Enter_MaximumNoOfTimes("100");
		
		//Check whether the Enter valid maximum number of times displayed or not
		if(mp.Max_TimesErrorMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter valid maximum number of times Displayed when Entering above 100");
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter valid maximum number of times not diisplayed when Entering above 100");
		}
		
		Thread.sleep(500);
		//Enter Maximum No of Times
		mp.Enter_MaximumNoOfTimes("2");
		
	
		Thread.sleep(12000);
		//Select the Modify with 
		mp.Select_ModifyWith();
		
		Thread.sleep(1000);
		//Create New Tax for Modifiers
		cp.Create_Category_NewTax(Utility.getProperty("Modifier_Tax_Name"));
		
		//Select Show Modifier
		mp.Enable_ShowModifier();
		
		//Select Show Menu Item In Modifier Print
		mp.Enable_ShowMenuItemInModifierPrint();
		
		//Select Show Modifier In Menu Print
		mp.Enable_ShowModifierInMenuPrint();
		
		//Click the New Kitchen Printer
//		kpp.Create_KitchenPrinter(Utility.getProperty("Modifier_Kitchen_Printer_Name"), Utility.getProperty("Modifier_Kitchen_Printer_IP"));
		mp.Select_ModifierKitchenPrinters();		
		
		//Select and Enter Set Prefix
		mp.Enter_Prefix("Add On", "500");
		
		//Enable Serving size price here
		mp.Enable_SetPriceHere();
		

		
		//Select and Enter Serving Size Levels
		mp.Enter_ServingSizeLevel("500");
		
		Thread.sleep(2000);
		cmp.Cursor_MoveToElement(cmp.Save_and_PublishButton());
		Robot rt=new Robot();
		Thread.sleep(1000);
		
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyPress(KeyEvent.VK_UP);
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ENTER);
//		Thread.sleep(1000);
//		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
//		Thread.sleep(1000);
		for(int i=1;i<=20;i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
	
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("windows.scrollBy(0,-3000)");
		cmp.NameInputBox().click();
		Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
//		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);	
		
		//Click the Save and Proceed button
		Thread.sleep(2000);
//				mp.Click_SaveAndProceed();
		cmp.Click_Save_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Saved Successfully"))
		{
			test.log(LogStatus.PASS, "New Modifier Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifier Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(2000);
//		WebDriverWait wt1=new WebDriverWait(driver, Duration.ofSeconds(60));
//		wt1.until(ExpectedConditions.elementToBeClickable(mp.ProceedToInventoryMappingTab()));
		
		//Click Proceed with Inventory mapping
				mp.Click_ProceedToInventoryMappingTab();
				
		
		Thread.sleep(8000);
		//Select and Add Item
		mp.Add_ItemInventoryModiferFirst();
		
		Thread.sleep(1000);
		//Select and Add Item
				mp.Add_ItemInventoryModiferSecond();
				
		for(int i=1;i<=10;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}

		Thread.sleep(2000);
		//Click Save and Publish button
		cmp.Click_Save_and_PublishButton();
		
//		Thread.sleep(3000);
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 60);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Updated Successfully!."))
		{
			test.log(LogStatus.PASS, "New Modifier Saved Successfully with Inventory Details");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifier Save Failed with Inventory Details");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Modifiers(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		mp=new ModifiersPage(driver, test);
		kpp=new KitchenPrinterPage(driver, test);
		
		
		Thread.sleep(10000);
		//Search the Modifiers to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("Modifier_Name"));
		
		Thread.sleep(2000);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Modifier");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_BackspaceButton();
		
		Thread.sleep(1000);
		//Check whether the New Modifier Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Modifier Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifier not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Remove_Prefix_Update_Modifiers(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		mp=new ModifiersPage(driver, test);
		kpp=new KitchenPrinterPage(driver, test);
	
		Thread.sleep(10000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
	
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Modifier_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Modifier_Name")+"1");
		
		Thread.sleep(1000);
		if(mp.Maximum_NoTimesInputBox().getAttribute("value").equalsIgnoreCase("2"))
		{
			test.log(LogStatus.PASS, "Maximum no of Times not changed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Maximum no of Times not changed");

		}
		
		
		Thread.sleep(12000);
		//Select Modify with
		mp.Select_ModifyWith();
		
		Thread.sleep(500);
		//Disable Menu Item in Modifier Print
		mp.Disable_ShowMenuItemInModifierPrint();
		
		//Disable Modifier in Menu item print
		mp.Disable_ShowModifierInMenuPrint();

		//Select Remove Prefix
		mp.Remove_Prefix();

		Thread.sleep(2000);
		cmp.Cursor_MoveToElement(cmp.Update_and_PublishButton());
		Robot rt=new Robot();
		Thread.sleep(1000);
		
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyPress(KeyEvent.VK_UP);
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ENTER);

		for(int i=1;i<=20;i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
	

		cmp.NameInputBox().click();
		Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		
		
		Thread.sleep(500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 60);
//		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Modifier updated successfully after Removing Prefix");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifier updated fail after Removing Prefix");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		

		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Modifier_Name"));
		
		try
		{
		//Check whether the Prefixes Removed or not
		if(mp.PrefixInputColumn().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Prefix Removing Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception l)
		{
			test.log(LogStatus.PASS, "Prefix Removed Successful");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(2000);
		cmp.Cursor_MoveToElement(cmp.Update_and_PublishButton());
//		Robot rt=new Robot();
		Thread.sleep(1000);
		
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyPress(KeyEvent.VK_UP);
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ENTER);

		for(int i=1;i<=20;i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
	

		cmp.NameInputBox().click();
		Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		
		
		Thread.sleep(1000);
		//Click Back button
		cmp.Click_BackspaceButton();
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Remove_ServingSizeLevels_Update_Modifiers(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		mp=new ModifiersPage(driver, test);
		kpp=new KitchenPrinterPage(driver, test);
	
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Modifier_Name")+"1");
		
		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Modifier_Name"));
		
		for(int i=1;i<=4;i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		Thread.sleep(2000);
		//Remove Serving size level
		mp.Remove_ServingSizeLevel();
		
		Thread.sleep(2000);
		cmp.Cursor_MoveToElement(cmp.Update_and_PublishButton());
		Robot rt=new Robot();
		Thread.sleep(1000);
		
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyPress(KeyEvent.VK_UP);
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ENTER);

		for(int i=1;i<=20;i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
	

		cmp.NameInputBox().click();
		Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		
		
		Thread.sleep(500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
//		Thread.sleep(3000);
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 60);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Modifier updated successfully after Removing Serving size level");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifier updated fail after Removing Serving Size level");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Modifier_Name"));
		
		try
		{
		//Check whether the Serving Size Level Removed or not
		if(mp.ServingSizeLevelInputColumn().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Serving Size Level Removing Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception e)
		{
			test.log(LogStatus.PASS, "Serving Size Level Removed Successful");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(2000);
		cmp.Cursor_MoveToElement(cmp.Update_and_PublishButton());
//		Robot rt=new Robot();
		Thread.sleep(1000);
		
		rt.keyPress(KeyEvent.VK_ENTER);
		rt.keyPress(KeyEvent.VK_UP);
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ENTER);

		for(int i=1;i<=20;i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
	

		cmp.NameInputBox().click();
		Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		
		Thread.sleep(1000);
		//Click Back button
		cmp.Click_BackspaceButton();
	
		
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Modifiers(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		mp=new ModifiersPage(driver, test);
		kpp=new KitchenPrinterPage(driver, test);
	
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Modifier_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Modifier_Name"));
		
		Thread.sleep(500);
		//Enable Show menu item in modifier print
		mp.Enable_ShowMenuItemInModifierPrint();
		
		//Enable show modifier in menu item
		mp.Enable_ShowModifierInMenuPrint();
		
		
		Thread.sleep(500);
		//Add Prefix
		mp.Enter_Prefix("Extra", "500");
		
		Thread.sleep(1000);
		//Add Serving Size Level
		mp.Enter_ServingSizeLevel("500");
		
		Thread.sleep(500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
//		Thread.sleep(3000);
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 60);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Modifier updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifier updated Fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Modifiers(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		mp=new ModifiersPage(driver, test);
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Modifier_Name"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Modifier Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifier Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("Modifier_Name"));
		
		Thread.sleep(500);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Modifier activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifier activated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(500);
		//Enable Active Status
		cmp.Click_InactivetoActiveButton();
				
		Thread.sleep(500);
		//Check whether verify whether the Active page opened or not
		cmp.VerifyActive_InactiveStatus("Active");
		
	
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_Modifiers_BasicDetails(WebDriver driver) throws Exception
	{
		mp=new ModifiersPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		kpp=new KitchenPrinterPage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Modifiers
		mp.Click_NewModifier();
		Thread.sleep(2000);
		
		//Upload picture
				cmp.Upload_Picture(Utility.getProperty("Settings_Store_Information_Store_Image_Path"));
				
				Thread.sleep(1000);
				//Enter the Modifier Name
				cmp.EnterName(Utility.getProperty("Modifier_Name")+"A");
				
				Thread.sleep(500);
				//Enter Secondary name
				mp.Enter_SecondaryName("S1");
				
				//Enter PLU Code
				mp.Enter_PLUCode("A001");
				
				Thread.sleep(500);
				//Enter Maximum No of Times
				mp.Enter_MaximumNoOfTimes("2");
				
				//Select Tax
				mp.Select_ModifierTax();
		
				Robot rt=new Robot();
				Thread.sleep(1000);
				
				rt.keyPress(KeyEvent.VK_ENTER);
				rt.keyPress(KeyEvent.VK_UP);
				Thread.sleep(1000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.ENTER);

				for(int i=1;i<=20;i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
				}
			

				cmp.NameInputBox().click();
				Thread.sleep(2000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
				
				
		//Click Save and Publish button
				cmp.Click_Save_and_PublishButton();
				
				cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 60);
//				Thread.sleep(3000);
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Saved Successfully"))
				{
					test.log(LogStatus.PASS, "New Modifier Saved Successfully with Basic Details");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "New Modifier Save Failed with Basic Details");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
	}
	
	@Test(priority = 6,enabled = false)
	public void Create_DuplicateModifier(WebDriver driver) throws Exception
	{
		mp=new ModifiersPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		kpp=new KitchenPrinterPage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Modifiers button
		mp.Click_NewModifier();
		Thread.sleep(2000);
		
		//Upload picture
				cmp.Upload_Picture(Utility.getProperty("Settings_Store_Information_Store_Image_Path"));
				
	
		Thread.sleep(500);
		//Enter the existing Modifier name
		cmp.EnterName(Utility.getProperty("Modifier_Name"));
		
		Thread.sleep(500);
		//Enter Secondary name
		mp.Enter_SecondaryName("S1");
		
		//Enter PLU Code
		mp.Enter_PLUCode("A001");
		
		Thread.sleep(500);
		//Enter Maximum No of Times
		mp.Enter_MaximumNoOfTimes("2");
		
		//Select the Modify with 
		mp.Select_ModifyWith();

		//Select Tax
		mp.Select_ModifierTax();

		Thread.sleep(2000);
		//Click the Save and Publish button
		cmp.Click_Save_and_PublishButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Modifier Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifier Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
}
