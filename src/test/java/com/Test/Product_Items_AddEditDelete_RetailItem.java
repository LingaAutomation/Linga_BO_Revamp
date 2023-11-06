package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
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
import com.Pages.ProductItems_Menu_RetailPage;
import com.epam.healenium.SelfHealingDriver;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_RetailItem {
public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete - Product/Item - Retail Items");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	Availability_RestrictionTimePage at;
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	ProductItems_Menu_RetailPage pmt;
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
		
		Thread.sleep(50000);
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
		Open_ProductItem_RetailItem_Page(driver);
//		RefreshAndPaginination(driver);
//		Add_ProductItem_RetailItem_Always_ProductType_StandardItem(driver);
//		Edit_and_Close_Cancel_ProductItem_RetailItem(driver);
		Edit_and_Update_ProductItem_RetailItem_DaysOfWeek_SubCategory_LevelType(driver);
		Edit_and_Update_ProductItem_RetailItem_DaysOfMonth_ProductType_Item_withVariants(driver);
		Edit_and_Update_ProductItem_RetailItem_DateRange_ProductType_CompositeItem(driver);
		Edit_and_Update_ProductItem_RetailItem_Specific_Date(driver);
		Edit_and_Update_ProductItem_RetailItem_DateRangeWithTime(driver);
		Delete_and_Active_Inactive_ProductItem_RetailItem(driver);
		Create_Duplicate_RetailItem(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_ProductItem_RetailItem_Page(SelfHealingDriver driver) throws Exception
	{
		
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Menu Item page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"productItems");

		Thread.sleep(5000);
		//Verify the ProductItem_RetailItem_ page loeded or not
		cmp.VerifyMainScreenPageHeader("Product/Items");	
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_ProductItem_RetailItem_Always_ProductType_StandardItem(SelfHealingDriver driver) throws Exception
	{
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		cp=new CategoriesPage(driver, test);
		
		Thread.sleep(2000);
		//Click the New ProductItem_RetailItem_
		pmt.Click_New_RetailItem();
		Thread.sleep(2000);
	
		//Verify the New Menu Item creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Retail Item");
		Thread.sleep(2000);
		
		if(cmp.Save_ButtonTwo().isEnabled())
		{
		//Click the Save button
				cmp.Click_Save_ButtonTwo();
				
				Thread.sleep(3000);
				//Check whether the New Tax Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Retail Item saved successfully"))
				{
					test.log(LogStatus.FAIL, "Retail Item saved successfully for Item Tax (Amount) without Name");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Name"))
				{
					test.log(LogStatus.PASS, "Please Enter Name Pop up Displayed");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
					
				}
		}
		else
		{
			test.log(LogStatus.PASS, "Save and Publish button not Enabled without Entering Name");
		}
		
		
		//Upload picture
		cmp.Upload_Picture(Utility.getProperty("Settings_Store_Information_Store_Image_Path"));
		
		
		String NameExcess = "Entering Invalid Name to input"; 
		int ActualSize= NameExcess.length();
		System.out.println(ActualSize);

		//Enter the Modifier Name
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
		
		//Upload Image
		cmp.Upload_Picture(Utility.getProperty("DisplayGroupImage1"));
		
		Thread.sleep(2000);
		//Enter the Menu Item Name
		cmp.EnterName(Utility.getProperty("Product_Retail_Items_Name"));
		
		//Enter the Secondary name
		pmt.Enter_Secondary_Name(Utility.getProperty("Product_Retail_Items_SecName"));
		
		
		//Select the Level
		pmt.Click_Category_LevelTypeOption_RetailItem();
		
		//Select the Category
		pmt.Select_Category_LevelType();
	
		
			Thread.sleep(1000);
		pmt.Create_RetailItem_NewTax(Utility.getProperty("Product_Retail_Items_TaxName"));
		Thread.sleep(2000);
		//Select Taxes
//		cp.Select_Taxes();
		
		Thread.sleep(2000);
		//Select Product Type
		pmt.Click_Standard_Item_ProductType();
		
		//Enter the Product Type
		pmt.Select_Standard_Time_ProductType(Utility.getProperty("Product_Retail_Items_SKUcode"), "2500", "10");
		
		
		//Enable Hide In POS
		pmt.Enable_Hide_In_POS();
		
		Thread.sleep(1000);
		//Enable Hide in kiosk
		pmt.Enable_Hide_In_Kiosk();
		
		//Enable EBT Menu Item
//		pmt.Enable_EBT_Menu_Item();
		
		//Enable Hide In Online Order
		pmt.Enable_Hide_In_Online_Order();
		
		
		//Select Always
		at.Click_AlwaysButton();
		
		for(int i=1;i<=10;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		
		Thread.sleep(1000);
		//Click the Inventory Details tab
		pmt.Click_Inventory_DetailsTab();
		
		Thread.sleep(8000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		
		Thread.sleep(1000);
		//Select Category Level
		pmt.Click_Category_LevelTypeOption_RetailItem();
		
		Thread.sleep(2000);
		//Select Category
		pmt.Select_Category_RetailInventoryLevelType();
		
		Thread.sleep(2000);
		//Select Inventory Unit
		pmt.Select_Inventory_Unit_RetailItem();
		
		Thread.sleep(1000);
		//Select Vendor
		pmt.Select_Vendor_RetailItem();
		
		Thread.sleep(1000);
		//Enter the Brand
		pmt.Enter_Brand_RetailItem("Parle");
		
		Thread.sleep(1000);
		//Enter Par Level
		pmt.Enter_Par_Level_RetailItem("4");
		
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}

		Thread.sleep(1000);
		//Enable Calculate COGS On Cost Price
		pmt.Enable_Calculate_COGS_onCostPrice();
		
		Thread.sleep(1000);
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		Thread.sleep(1000);
		//Select Primary Storage
		pmt.Select_Primary_Storage_RetailItem();
		
		//Select Secondary Storage
		pmt.Select_Secondary_Storage_RetailItem();
		
		Thread.sleep(2000);
		//Click the Save and Publish button
		cmp.Click_Save_ButtonTwo();
		
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Retail Item saved successfully"))
		{
			test.log(LogStatus.PASS, "Retail Item Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Retail Item Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_ProductItem_RetailItem(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		cp=new CategoriesPage(driver, test);
		
		Thread.sleep(50000);
		//Search the ProductItem_RetailItem_ to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("Product_Retail_Items_Name"));
		
		Thread.sleep(1000);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Retail Item");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_BackspaceButton();
		
		Thread.sleep(1000);
		//Check whether the New Menu Item Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Retail Item Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Retail Item not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_ProductItem_RetailItem_DaysOfWeek_SubCategory_LevelType(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
	cp=new CategoriesPage(driver, test);
	
		Thread.sleep(50000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBoxTwo();
	
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Product_Retail_Items_Name"));
		
		
		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName("");
		
		
		Thread.sleep(2000);
		if(cmp.Update_ButtonTwo().isEnabled())
		{
		//Click the Save button
				cmp.Click_Update_ButtonTwo();
				
				Thread.sleep(3000);
				//Check whether the New Tax Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Retail Item Updated successfully"))
				{
					test.log(LogStatus.FAIL, "Retail Item Updated successfully for Item Tax (Amount) without Name");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
					
					Thread.sleep(50000);
					//Search and Click Edit button
					cmp.SearchAndClickEdit(Utility.getProperty("Product_Retail_Items_Name"));
					
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Name"))
				{
					test.log(LogStatus.PASS, "Please Enter Name Pop up Displayed");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
					
				}
		}
		else
		{
			test.log(LogStatus.PASS, "Save and Publish button not Enabled without Entering Name");
		}
		
		Thread.sleep(2000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Product_Retail_Items_Name")+"1");
		
		//Check Whether the Category Level Type Selected or not 
		if(pmt.Standard_Item_ProductType().isEnabled())
		{
			test.log(LogStatus.PASS, "Standard Item Product Type Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Standard Item Product Type not Selected");
		}
		
		
		
		
		
		
		//Check Whether the Hide In Kiosk Selected or not 
		if(pmt.Hide_In_Kiosk_Yes().isEnabled())
		{
			test.log(LogStatus.PASS, "Hide In Kiosk Yes Toggle is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Hide In Kiosk Yes Toggle is not Selected");
		}
		
		//Check Whether the EBT Menu Itemy Selected or not 
//		if(pmt.EBT_Menu_Item_Yes().isEnabled())
//		{
//			test.log(LogStatus.PASS, "EBT Menu Item Yes Toggle is Selected");
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "EBT Menu Item Yes Toggle is not Selected");
//		}
		
		//Check Whether the Hide In POS Selected or not 
		if(pmt.Hide_In_POS_Yes().isEnabled())
		{
			test.log(LogStatus.PASS, "Hide In POS Yes Toggle is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Hide In POS Yes Toggle is not Selected");
		}
		
		//Check Whether the Hide In Online Order Selected or not 
		if(pmt.Hide_In_Online_Order_Yes_Retail().isEnabled())
		{
			test.log(LogStatus.PASS, "Hide In Online Order Yes Toggle is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Hide In Online Order Yes Toggle is not Selected");
		}
		
		Thread.sleep(2000);
		//Enter standard Item,
		pmt.Select_Standard_Time_ProductType(Utility.getProperty("Product_Retail_Items_SKUcode"), "1000", "2");
		
		
		Thread.sleep(1000);
		if(cmp.Update_ButtonTwo().isEnabled())
		{
			
			Thread.sleep(1000);
			//Click the Update and Publish button
			cmp.Click_Update_ButtonTwo();
		
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Retail Item Updated successfully"))
		{
			test.log(LogStatus.FAIL, "Retail Item Updated successfully without Entering Supply Price");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			
			Thread.sleep(3000);
			//Search and Click Edit button
			cmp.SearchAndClickEdit(Utility.getProperty("Product_Retail_Items_Name"));
			
		}
//		else
//		{
//			test.log(LogStatus.PASS, "Retail Item Update failed without Entering ");
//			
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		}
		else
		{
			test.log(LogStatus.PASS, "Update button not Enabled without Entering Supply Price");
		}
		
		
		//Enter standard Item,
				pmt.Select_Standard_Time_ProductType(Utility.getProperty("Product_Retail_Items_SKUcode"), "2500", "");
				
				
				
				if(cmp.Update_ButtonTwo().isEnabled())
				{
					
					Thread.sleep(1000);
					//Click the Update and Publish button
					cmp.Click_Update_ButtonTwo();
				
				
				Thread.sleep(3000);
				//Check whether the New Menu Item Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Retail Item Updated successfully"))
				{
					test.log(LogStatus.FAIL, "Retail Item Updated successfully without Entering Markup Percentage");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
					
					
					Thread.sleep(3000);
					//Search and Click Edit button
					cmp.SearchAndClickEdit(Utility.getProperty("Product_Retail_Items_Name"));
					
				}
//				else
//				{
//					test.log(LogStatus.PASS, "Retail Item Update failed without Entering ");
//					
//					ut.FailedCaptureScreenshotAsBASE64(driver, test);
//				}
				}
				else
				{
					test.log(LogStatus.PASS, "Update button not Enabled without Entering Markup Percentage");
				}
				
		Thread.sleep(1000);
		//Select SubCategory Level Type
		pmt.Click_SubCategory_LevelTypeOption_RetailItem();
		
		Thread.sleep(5000);
		//Select Category
		pmt.Select_Category_LevelType();
		
		Thread.sleep(4000);
		//Select Sub Category Level Type
		pmt.Select_SubCategory_LevelType();
		
		
	Thread.sleep(1000);
		//Disable Hide in kiosk
		pmt.Disable_Hide_In_Kiosk();
		
		//Disable EBT Menu Item
		pmt.Disable_EBT_Menu_Item();
		
		//Disable Hide In POS
		pmt.Disable_Hide_In_POS();
		
		//Disable Hide In Online Order
		pmt.Disable_Hide_In_Online_Order();
		
	
		//Select Days of Week
		at.Select_DaysOfWeek();
		
		//Select Restriction Time
		at.Enter_RestrictionTime();
		
		//Select Available Time
		at.Enter_AvailableTime();
		
		
		//Select Inventory Details
		pmt.Click_Inventory_DetailsTab();
		
		Thread.sleep(2000);
		//Check Whether the Category Level Type Selected or not 
		if(pmt.Calculate_COGS_onCostPrice_Yes().isEnabled())
		{
			test.log(LogStatus.PASS, "Calculate COGS On Cost Price is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Calculate COGS On Cost Price is not Selected");
		}
		
		
		//Select Category Level
				pmt.Click_Category_LevelTypeOption_RetailItem();
				
				//Select Category
				pmt.Select_Category_LevelType();
				
				//Select Inventory Unit
				pmt.Select_Inventory_Unit_RetailItem();
				
				//Select Vendor
				pmt.Select_Vendor_RetailItem();
				
				//Enter the Brand
				pmt.Enter_Brand_RetailItem("Parle");
				
				//Enter Par Level
				pmt.Enter_Par_Level_RetailItem("4");
				
				Thread.sleep(2000);
				cmp.Cursor_MoveToElement(cmp.Update_and_PublishButton());
				Robot rt=new Robot();
				Thread.sleep(1000);
				
				rt.keyPress(KeyEvent.VK_ENTER);
				rt.keyPress(KeyEvent.VK_UP);
				Thread.sleep(1000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.ENTER);
//				Thread.sleep(1000);
//				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
//				Thread.sleep(1000);
				for(int i=1;i<=20;i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ENTER);
				Thread.sleep(1000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
				}
			
//				JavascriptExecutor js=(JavascriptExecutor)driver;
//				js.executeScript("windows.scrollBy(0,-3000)");
				cmp.NameInputBox().click();
				Thread.sleep(2000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
//				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);

		Thread.sleep(1000);
		//Click the Update and Publish button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Retail Item Updated successfully"))
		{
			test.log(LogStatus.PASS, "Retail Item Updated successfully for Days of Week");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Retail Item Update fail for Days of Week");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_ProductItem_RetailItem_DaysOfMonth_ProductType_Item_withVariants(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		cp=new CategoriesPage(driver, test);

	
		Thread.sleep(50000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Product_Retail_Items_Name")+"1");
		
		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Product_Retail_Items_Name"));
		
		//Check Whether the SubCategory Level Type Selected or not 
		if(pmt.Level_RetailItem().getAttribute("value").equalsIgnoreCase("Sub Category"))
		{
			test.log(LogStatus.PASS, "SubCategory Level Type Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "SubCategory Level Type not Selected");
		}
		

		//click the Item with Variants
		pmt.Click_Item_With_Variants_ProductType();
	
		
		
	
		//Select Days of Month
		at.Select_DaysOfMonth();
		
		//Select Restriction Time
		at.Enter_RestrictionTime();
		
		//Select Available Time
		at.Enter_AvailableTime();
		
		
		Thread.sleep(2000);
		cmp.Cursor_MoveToElement(cmp.Update_and_PublishButton());
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

		
		Thread.sleep(1000);
		//Click the Update and Publish button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Retail Item Updated successfully"))
		{
			test.log(LogStatus.PASS, "Retail Item Updated successfully for Days of Month");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Retail Item Update fail for Days of Month");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}

	
	
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_ProductItem_RetailItem_DateRange_ProductType_CompositeItem(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		cp=new CategoriesPage(driver, test);

	
		Thread.sleep(50000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Product_Retail_Items_Name"));
		
		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Product_Retail_Items_Name"));
		
		
		//Check Whether the Item with Variants Type Selected or not 
		if(pmt.Item_With_Variants_ProductType().isEnabled())
		{
			test.log(LogStatus.PASS, "Item with Variants Product Type Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Item with Variants Product Type not Selected");
		}
		
	
	
		
		//Check Whether the Days of Month Availability Selected or not 
		if(at.DaysOfMonth_Availabilty().isEnabled())
		{
			test.log(LogStatus.PASS, "Days of Month Availability is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Days of Month Availability is not Selected");
		}

		//Select Composite Item Product Type
		pmt.Click_Composite_Item_ProductType();
		
		//Select Days of Week
		at.Select_DateRange();
		
		Thread.sleep(2000);
		cmp.Cursor_MoveToElement(cmp.Update_and_PublishButton());
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

		Thread.sleep(1000);
		//Click the Update and Publish button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Retail Item Updated successfully"))
		{
			test.log(LogStatus.PASS, "Retail Item Updated successfully for Date Range");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Retail Item Update fail for Date Range");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_ProductItem_RetailItem_Specific_Date(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
	cp=new CategoriesPage(driver, test);
	
		Thread.sleep(50000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Product_Retail_Items_Name"));
		
		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Product_Retail_Items_Name"));
		
		
		//Check Whether the Composite Product Type Selected or not 
		if(pmt.Composite_Item_ProductType().isEnabled())
		{
			test.log(LogStatus.PASS, "Composite Item Product Type Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Composite Item Product Type not Selected");
		}
		
		
		//Check Whether the Date Range Availability Selected or not 
		if(at.DateRange_Availabilty().isEnabled())
		{
			test.log(LogStatus.PASS, "Date Range Availability is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Date Range Availability is not Selected");
		}
		for(int i=1;i<=3;i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
	
		//Select Scale Item Menu Type 
		pmt.Click_ScaleItem_MenuType();
		
		//Select Tare Group
		cp.Select_TareGroup();
		
		
		//Select Variable Cost Type
		pmt.Select_Serving_Size_For_Variable_CostType();
		
		//Select Days of Week
		at.Select_SpecificDate();
		
		Thread.sleep(2000);
		cmp.Cursor_MoveToElement(cmp.Update_and_PublishButton());
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

		Thread.sleep(1000);
		//Click the Update and Publish button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Retail Item Updated successfully"))
		{
			test.log(LogStatus.PASS, "Retail Item Updated successfully for Specific Date");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Retail Item Update fail for Specific Date");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_ProductItem_RetailItem_DateRangeWithTime(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		cp=new CategoriesPage(driver, test);

		Thread.sleep(50000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Product_Retail_Items_Name"));
		
		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Product_Retail_Items_Name"));

		//Check Whether the Scale Item Selected or not 
		if(pmt.ScaleItem_MenuType().isEnabled())
		{
			test.log(LogStatus.PASS, "Scale Item Menu Type Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Scale Item Menu Type not Selected");
		}
		

		
				
				//Check Whether the Specific Date Availability Selected or not 
				if(at.SpecificDate_Availabilty().isEnabled())
				{
					test.log(LogStatus.PASS, "Specific Date Availability is Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Specific Date Availability is not Selected");
				}
				
				//Check Whether the Variable Cost Type Selected or not 
				if(pmt.Variable_CostType().isEnabled())
				{
					test.log(LogStatus.PASS, "Variable Cost Type is Selected after Reopen");
				}
				else
				{
					test.log(LogStatus.FAIL, "Variable Cost Type is not Selected after Reopen");
				}
				
				for(int i=1;i<=3;i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}
				
				//Select Combo Item Menu Type
				pmt.Click_ComboItem_MenuType();
				
				//Add and Enter Combo Menu Items
				pmt.Enter_Combo_Item("10", "1000");
				
				//Select Fixed Cost Type
//				pmt.Click_Fixed_CostType();
				
				//Select Fixed Cost Type
				pmt.Select_Serving_Size_For_Fixed_CostType();
		
		//Select Days of Week
		at.Select_DateRangeWithTime();
		
		Thread.sleep(2000);
		cmp.Cursor_MoveToElement(cmp.Update_and_PublishButton());
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

		Thread.sleep(1000);
		//Click the Update and Publish button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Retail Item Updated successfully"))
		{
			test.log(LogStatus.PASS, "Retail Item Updated successfully for Date Range with Time");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Retail Item Update fail for Date Range with Time");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}

	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_ProductItem_RetailItem(SelfHealingDriver driver) throws Exception
	{
		Thread.sleep(1000);
		
		cmp=new Common_XPaths(driver, test);
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Product_Retail_Items_Name"));
		
		Thread.sleep(1000);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Retail Item Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Retail Item Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Retail Item not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Product_Retail_Items_Name"));
		
		Thread.sleep(1000);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Retail Item Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Retail Item Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Retail Item Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("Product_Retail_Items_Name"));
		
		Thread.sleep(1000);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		try
		{
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Retail Item Activated Successfully"))
		{
			test.log(LogStatus.FAIL, "Retail Item Activated when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Retail Item not Activated when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		Thread.holdsLock(1000);
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("Product_Retail_Items_Name"));
		
		Thread.sleep(1000);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Retail Item Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Retail Item activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Retail Item activated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Enable Active Status
		cmp.Click_InactivetoActiveButton();
				
		Thread.sleep(1000);
		//Check whether verify whether the Active page opened or not
		cmp.VerifyActive_InactiveStatus("Active");
		
	
		
	}
	
	@Test(priority = 6,enabled = false)
	public void Create_Duplicate_RetailItem(SelfHealingDriver driver) throws Exception
	{
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		cp=new CategoriesPage(driver, test);

		Thread.sleep(2000);
		//Click the New ProductItem_RetailItem_ button
		pmt.Click_New_RetailItem();
		Thread.sleep(2000);
	
		Thread.sleep(1000);
		//Enter the existing Menu Item name
		cmp.EnterName(Utility.getProperty("Product_Retail_Items_Name"));
		
		//Select Category Level Type
		pmt.Click_Category_LevelType();
		
		Thread.sleep(5000);
		//Select Category
		pmt.Select_Category_LevelType();
		
		//Click Menu Item Menu Type
		pmt.Click_Menu_Item_MenuType();
		
		//Select Fixed Cost Type
		pmt.Select_Serving_Size_For_Fixed_CostType();
		
		//Select Taxes
		cp.Select_Taxes();
	
		Thread.sleep(2000);
		//Click the Save and Publish button
		cmp.Click_Save_ButtonTwo();
		
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Retail Item Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Retail Item Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
}
