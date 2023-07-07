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
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_MenuItem {
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete - Product/Item - MenuItems");
	
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
		
		Thread.sleep(60000);
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
		Open_ProductItem_MenuItem_Page(driver);
		RefreshAndPaginination(driver);
		Add_ProductItem_MenuItem_Always_MenuType_MenuItem(driver);
		Edit_and_Close_Cancel_ProductItem_MenuItem(driver);
		Edit_and_Update_ProductItem_MenuItem_DaysOfWeek_SubCategory_LevelType(driver);
		Edit_and_Update_ProductItem_MenuItem_DaysOfMonth_MenuType_MenuItem_With_ServingSize(driver);
		Edit_and_Update_ProductItem_MenuItem_DateRange_MenuType_OpenItem(driver);
		Edit_and_Update_ProductItem_MenuItem_Specific_Date_MenuType_ScaleItem(driver);
		Edit_and_Update_ProductItem_MenuItem_DateRangeWithTime_MenuType_ComboItem(driver);
		Delete_and_Active_Inactive_ProductItem_MenuItem(driver);
		Create_Duplicate_MenuItem(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_ProductItem_MenuItem_Page(WebDriver driver) throws Exception
	{
		
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Menu Item page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"productItems");

		Thread.sleep(5000);
		//Verify the ProductItem_MenuItem_ page loeded or not
		cmp.VerifyMainScreenPageHeader("Product/Items");	
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
	public void Add_ProductItem_MenuItem_Always_MenuType_MenuItem(WebDriver driver) throws Exception
	{
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		cp=new CategoriesPage(driver, test);
		
		Thread.sleep(2000);
		//Click the New ProductItem_MenuItem_
		pmt.Click_New_MenuItem();
		Thread.sleep(2000);
	
		//Verify the New Menu Item creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Menu Item");
		Thread.sleep(2000);
		
		if(cmp.Save_and_PublishButton().isEnabled())
		{
		//Click the Save button
				cmp.Click_Save_and_PublishButton();
				
				Thread.sleep(3000);
				//Check whether the New Tax Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu Item saved successfully"))
				{
					test.log(LogStatus.FAIL, "Menu Item saved successfully for Item Tax (Amount) without Name");
				
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
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Upload Image
		cmp.Upload_Picture(Utility.getProperty("DisplayGroupImage1"));
		
		Thread.sleep(2000);
		//Enter the Menu Item Name
		cmp.EnterName(Utility.getProperty("ProductsItems_MenuItemName"));
		
		//Enter the Secondary name
		pmt.Enter_Secondary_Name(Utility.getProperty("ProductsItems_SecName"));
		
		
		//Enter the PLU Code
		pmt.Enter_PLU_Code(Utility.getProperty("ProductsItems_PLU_Code"));
		
		Thread.sleep(1000);
		//Select Item Preparation Time
		pmt.Enter_Item_Preparation_Time("11");
		
		Thread.sleep(1000);
		//Enter Kitchen Printer Name
		pmt.Enter_Kitchen_Printer_Name("Kitchen Printer 01");
		
//		for(int i=1;i<=5;i++)
//		{
//			Thread.sleep(1000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
//		}
		
		Thread.sleep(1000);
		//Select Category Level Type
		pmt.Click_Category_LevelType();
		
		Thread.sleep(5000);
		//Select Category
		pmt.Select_Category_LevelType();
		
		//Enter Description
		pmt.Enter_Description("Menu Item is "+ut.getProperty("ProductsItems_MenuItemName"));
		
		//Enable Evertex
//		pmt.Select_Evertex_TaxType();
		
		Thread.sleep(1000);
		//Select Menu Item
		pmt.Click_Menu_Item_MenuType();
		
		//Enable Conversational UI at POS
		pmt.Enable_Conversational_UI_atPOS();
		
		//Enable Cut and Modify
		pmt.Enable_Cut_And_Modify();
		
		//Enter the Slices
		pmt.Enter_Slices_CutAndModify("2");
		
		//Select Variable Set Price
		pmt.Click_Variable_CostType();
		
		
		//Select Serving Size for variables
		pmt.Select_Serving_Size_For_Variable_CostType();
		
//		for(int i=1;i<=3;i++)
//		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
//		}
		Thread.sleep(1000);
		cp.Create_Category_NewTax(Utility.getProperty("ProductsItems_MenuItem_Tax"));
		Thread.sleep(2000);
		//Select Taxes
//		cp.Select_Taxes();
		
		Thread.sleep(2000);
		
		
		Thread.sleep(1000);
		//Enable Hide in kiosk
		pmt.Enable_Hide_In_Kiosk();
		
		//Enable EBT Menu Item
//		pmt.Enable_EBT_Menu_Item();
		
		//Enable Hide In POS
		pmt.Enable_Hide_In_POS();
		
		//Enable Hide In Online Order
		pmt.Enable_Hide_In_Online_Order();
		
		//Enable 86 List
		pmt.Enable_Eighty_Six_List();
		
		//Enable Meito MenuItem
		pmt.Enable_Meito_MenuItem();
		 
		//Select Always
		at.Click_AlwaysButton();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		
		//Select Kitchen Printer
//		cp.Select_KitchenPrinter();
		
		//Select Label Printer
//		cp.Select_LabelPrinter();
		
		//Select Restrict Printer
//		cp.Select_RestrictPrinter();
		Thread.sleep(1000);
		for(int i=1;i<=5;i++)
		{
			Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);		
		}
		Thread.sleep(2000);
		//Click the Save and Publish button
		cmp.Click_Save_and_PublishButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu item saved successfully"))
		{
			test.log(LogStatus.PASS, "New Menu Item Saved and Published Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item Save and Publish Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_ProductItem_MenuItem(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		cp=new CategoriesPage(driver, test);
		
		Thread.sleep(6000);
		//Search the ProductItem_MenuItem_ to Click Edit and Cancel
		pmt.SearchAndClickEdit(Utility.getProperty("ProductsItems_MenuItemName"));
		
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		Robot rd=new Robot();
//		rd.keyPress(KeyEvent.KEY_PRESSED);
//		rd.keyPress(KeyEvent.VK_KP_UP);
		Thread.sleep(1000);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Menu Item");
		
		Thread.sleep(3000);
		//Click Cancel button
		cmp.Click_BackspaceButton();
		
		Thread.sleep(1000);
		//Check whether the New Menu Item Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Menu Item Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Item not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_ProductItem_MenuItem_DaysOfWeek_SubCategory_LevelType(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
	cp=new CategoriesPage(driver, test);
	
		Thread.sleep(60000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBoxTwo();
	
		
		Thread.sleep(1000);
		//Search and Click Edit button
		pmt.SearchAndClickEdit(Utility.getProperty("ProductsItems_MenuItemName"));
		
		
		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName("");
		
		
		Thread.sleep(2000);
		if(cmp.Update_and_PublishButton().isEnabled())
		{
		//Click the Save button
				cmp.Click_Update_and_PublishButton();
				
				Thread.sleep(3000);
				//Check whether the New Tax Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu item Updated successfully"))
				{
					test.log(LogStatus.FAIL, "Menu Item Updated successfully for Item Tax (Amount) without Name");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
					
					Thread.sleep(60000);
					//Search and Click Edit button
					pmt.SearchAndClickEdit(Utility.getProperty("ProductsItems_MenuItemName"));
					
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
		cmp.EnterName(Utility.getProperty("ProductsItems_MenuItemName")+"1");
		
		//Check Whether the Category Level Type Selected or not 
		if(pmt.Category_LevelType().isEnabled())
		{
			test.log(LogStatus.PASS, "Category Level Type Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Category Level Type not Selected");
		}
		
		//Check Whether the Menu Type Selected or not 
		if(pmt.MenuItem_MenuType().isEnabled())
		{
			test.log(LogStatus.PASS, "Menu Item Menu Type Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Item Menu Type not Selected");
		}
		
		//Check Whether the Menu Type Selected or not 
		if(pmt.Variable_CostType().isEnabled())
		{
			test.log(LogStatus.PASS, "Variable Set Price Type Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Variable Set Price Type not Selected");
		}
		
		
		//Check Whether the Conversational UI at POS Selected or not 
		if(pmt.Conversational_UI_atPOS_Yes().isEnabled())
		{
			test.log(LogStatus.PASS, "Conversational UI at POS Yes Toggle is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Conversational UI at POS Yes Toggle is not Selected");
		}
		
		
		//Check Whether the Cut And Modify Selected or not 
		if(pmt.Cut_And_Modify_Yes().isEnabled())
		{
			test.log(LogStatus.PASS, "Cut And Modify Yes Toggle is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Cut And Modify Yes Toggle is not Selected");
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
		if(pmt.Hide_In_Online_Order_Yes().isEnabled())
		{
			test.log(LogStatus.PASS, "Hide In Online Order Yes Toggle is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Hide In Online Order Yes Toggle is not Selected");
		}
		
		//Check Whether the 86 List Selected or not 
		if(pmt.Eighty_Six_List_Yes().isEnabled())
		{
			test.log(LogStatus.PASS, "86 List Yes Toggle is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "86 List Yes Toggle is not Selected");
		}
		
		//Check Whether the Meito MenuItem Selected or not 
		if(pmt.Meito_MenuItem_Yes().isEnabled())
		{
			test.log(LogStatus.PASS, "Meito MenuItem Yes Toggle is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Meito MenuItem Yes Toggle is not Selected");
		}
		
//		for(int i=1;i<=5;i++)
//		{
//			Thread.sleep(1000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
//		}
		try{
		//Select SubCategory Level Type
		pmt.Click_SubCategory_LevelType();
		
		Thread.sleep(10000);
		//Select Category
		pmt.Select_Category_LevelType();
		
//		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		Thread.sleep(4000);
		//Select Sub Category Level Type
		pmt.Select_SubCategory_LevelType();
		}
		catch (Exception e)
		{
			pmt.Click_Category_LevelType();
			
			Thread.sleep(1000);
			
			pmt.Select_Category_LevelType();
		}
		
		//Disable Conversational UI at POS
		pmt.Disable_Conversational_UI_atPOS();
		
		//Disable Cut and Modify
		pmt.Disable_Cut_And_Modify();
		
		Thread.sleep(1000);
		//click the Fixed Set Price 
		pmt.Click_Fixed_CostType();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		
		Thread.sleep(1000);
		//Select the Fixed Serving Size
		pmt.Select_Serving_Size_For_Fixed_CostType();
		
		Thread.sleep(1000);
		//Select and Enable Price Level Settings
		pmt.Enter_Add_Price_Level("1000");
		
		
		Thread.sleep(1000);
		//Disable Hide in kiosk
		pmt.Disable_Hide_In_Kiosk();
		
		Thread.sleep(1000);
		//Disable EBT Menu Item
		pmt.Disable_EBT_Menu_Item();
		
		Thread.sleep(1000);
		//Disable Hide In POS
		pmt.Disable_Hide_In_POS();
		
		Thread.sleep(1000);
		//Disable Hide In Online Order
		pmt.Disable_Hide_In_Online_Order();
		
		Thread.sleep(1000);
		//Disable 86 List
		pmt.Disable_Eighty_Six_List();
		
		Thread.sleep(1000);
		//Disable Meito MenuItem
		pmt.Disable_Meito_MenuItem();
		
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		Thread.sleep(1000);
		//Add Include Modifiers
		pmt.Click_Add_Include_Modifiers();

		Thread.sleep(1000);
		//Select Include Modifiers
		pmt.Select_ModifierGroup_Include_Modifiers();
		
		pmt.select_Modifier();
		
		Thread.sleep(1000);
		//Enable Alternate modifier
		pmt.Enable_Alternate_Modifier_Group();
		
		Thread.sleep(1000);
		//Select Alternate modifier
		pmt.Select_Alternate_ModifierGroup();
		
		Thread.sleep(1000);
		//Add Mandatory Modifier Group
		pmt.Click_Add_Mandatory_ModifierGroup();
		
		Thread.sleep(1000);
		//Select Mandatory Modifier Group
		pmt.Select_ModifierGroup_Mandatory_Modifiers();
		
		//Enter Display Order in 
		pmt.Enter_Display_Order_MandatoryModifier("0");
		
		//Verify the Enter Display Order
		pmt.Verify_Enter_Display_OrderErrorMessage();
		
		
		//Enter Display Order in 
		pmt.Enter_Display_Order_MandatoryModifier("2");
		
		//Enter the Minimum Quantity
		pmt.Enter_Minimum_Quantity_MandatoryModifier("0");
		
		//Verify Minimum Quantity
		pmt.Verify_Enter_Minimum_QuantityErrorMessage();
		
		//Enter the Minimum Quantity
				pmt.Enter_Minimum_Quantity_MandatoryModifier("4");
				
				//Enter Maximum Quantity
				pmt.Enter_Maximum_Quantity_MandatoryModifier("0");
				
				
				//Verify Maximum Qunatity error
				pmt.Verify_Enter_Maximum_QuantityErrorMessage();
				
				//Enter Maximum Quantity
				pmt.Enter_Maximum_Quantity_MandatoryModifier("2");
				
				
				//Verify Maximum Qunatity error
				pmt.Verify_Enter_Maximum_QuantityErrorMessage();
				
				//Enter Maximum Quantity
				pmt.Enter_Maximum_Quantity_MandatoryModifier("9");
				
				//Enable Set Set Tiered Price in Mandatory Modifier Groups
				pmt.Enable_Set_Tiered_Price_MandatoryModifier();
				
				//Select Set Tiered Price
				pmt.Select_Set_Tiered_Price_MandatoryModifier();
			
				
		//Click Optional Modifiers
		pmt.Click_Add_Optional_ModifierGroup();
		
		//Select Optional Modifier Group
		pmt.Select_ModifierGroup_Optional_Modifiers();
		
		//Enter Display Order in 
		pmt.Enter_Display_Order_OptionalModifier("0");
		
		//Verify the Enter Display Order
		pmt.Verify_Enter_Display_OrderErrorMessage();
		
		
		//Enter Display Order in 
		pmt.Enter_Display_Order_OptionalModifier("3");
		
		
		//Enable Set Tiered Price in Optional Modifiers
		pmt.Enable_Set_Tiered_Price_OptionalModifier();
		
		//Select Set Tiered
		pmt.Select_Set_Tiered_Price_OptionalModifier();

		//Select Days of Week
		at.Select_DaysOfWeek();
		
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

		Thread.sleep(2000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu item Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Menu Item updated and Publish successfully for Days of Week");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item updated fail for Days of Week");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_BackspaceButton();
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_ProductItem_MenuItem_DaysOfMonth_MenuType_MenuItem_With_ServingSize(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		cp=new CategoriesPage(driver, test);

	
		Thread.sleep(60000);
		//Search and Click Edit button
		pmt.SearchAndClickEdit(Utility.getProperty("ProductsItems_MenuItemName"));
		
		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("ProductsItems_MenuItemName"));
		
		//Check Whether the SubCategory Level Type Selected or not 
		if(pmt.SubCategory_LevelType().isEnabled())
		{
			test.log(LogStatus.PASS, "SubCategory Level Type Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "SubCategory Level Type not Selected");
		}
		
	
		//Check Whether the Fixed Type Selected or not 
		if(pmt.Fixed_CostType().isEnabled())
		{
			test.log(LogStatus.PASS, "Fixed Set Price Type Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Fixed Set Price Type not Selected");
		}
		
		//Check Whether the Price Level Settings Selected or not 
		if(pmt.Price_Level_Settings_Yes().isEnabled())
		{
			test.log(LogStatus.PASS, "Price Level Settings Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Price Level Settings not Selected");
		}
		
		try {
		//Check Whether the Alternate Modifier Group Selected or not 
		if(pmt.Alternate_Modifier_Group_Yes().isEnabled())
		{
			test.log(LogStatus.PASS, "Alternate Modifier Group Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Alternate Modifier Group not Selected");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	
		//Disable Price Level Settings
		pmt.Disable_Price_Level_Settings();
		Thread.sleep(2000);
		for(int i=1;i<=6;i++) 
		{
			Thread.sleep(500);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		
		Thread.sleep(2000);
		//Select Menu Item with Serving Size
		pmt.Click_MenuItem_With_ServingSize_MenuType();
	
		//Select Price Level
		pmt.Select_Serving_MenuItem_With_ServingSize_Fixed_CostType();
		
		
		
		//Select Days of Month
		at.Select_DaysOfMonth();
		
		//Select Restriction Time
		at.Enter_RestrictionTime();
		
		//Select Available Time
		at.Enter_AvailableTime();
		
		
		//Disable Set Tiered Price in Mandatory Modifier Group
		pmt.Disable_Set_Tiered_Price_MandatoryModifier();
		
		
		//Disable Set Tiered Price in Optional Modifier Group
				pmt.Disable_Set_Tiered_Price_OptionalModifier();
				
				
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
				Thread.sleep(2000);

		
		Thread.sleep(1000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu item Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Menu Item updated and Publish successfully for Days of Month");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item updated fail for Days of Month");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			cmp.Click_BackspaceButton();
		}
		
	}

	
	
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_ProductItem_MenuItem_DateRange_MenuType_OpenItem(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		cp=new CategoriesPage(driver, test);

	
		Thread.sleep(60000);
		//Search and Click Edit button
		pmt.SearchAndClickEdit(Utility.getProperty("ProductsItems_MenuItemName"));
		
		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("ProductsItems_MenuItemName"));
		
		//Check Whether the Menu Item With Serving Size Type Selected or not 
		if(pmt.MenuItem_With_ServingSize_MenuType().isEnabled())
		{
			test.log(LogStatus.PASS, "Menu Item With Serving Size Type Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Item With Serving Size Type not Selected");
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

		//Select Open Item Set Price
		pmt.Click_OpenItem_MenuType();
		
		//Select the Serving Sizes
		pmt.Select_Serving_Size_For_Fixed_CostType();

		//Select Days of Week
		at.Select_DateRange();
		
		
		//click the Inventory Details
//		pmt.Click_Inventory_DetailsTab();
		
		//Add Inventory Items
//		pmt.Add_Inventory_Item();
	
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


		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu item Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Menu Item updated and Publish successfully for Date Range");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item updated fail for Date Range");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_ProductItem_MenuItem_Specific_Date_MenuType_ScaleItem(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
	cp=new CategoriesPage(driver, test);
	
		Thread.sleep(60000);
		//Search and Click Edit button
		pmt.SearchAndClickEdit(Utility.getProperty("ProductsItems_MenuItemName"));
		
		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("ProductsItems_MenuItemName"));
		
		//Check Whether the Open Item Selected or not 
		if(pmt.OpenItem_MenuType().isEnabled())
		{
			test.log(LogStatus.PASS, "Open Item Menu Type Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Open Item Menu Type not Selected");
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
		pmt.Select_TareGroup();
		
		
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
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu item Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Menu Item updated and Publish successfully for Specific Date");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item updated fail for Specific Date");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			cmp.Click_BackspaceButton();
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_ProductItem_MenuItem_DateRangeWithTime_MenuType_ComboItem(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		cp=new CategoriesPage(driver, test);

		Thread.sleep(60000);
		//Search and Click Edit button
		pmt.SearchAndClickEdit(Utility.getProperty("ProductsItems_MenuItemName"));
		
		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("ProductsItems_MenuItemName"));

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
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu item Updated successfully"))
		{
			test.log(LogStatus.PASS, "New Menu Item updated and Publish successfully for Date Range with Time");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Menu Item updated fail for Date Range with Time");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}

	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_ProductItem_MenuItem(WebDriver driver) throws Exception
	{
		Thread.sleep(1000);
		
		cmp=new Common_XPaths(driver, test);
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		
		//Search and Click Delete button
		pmt.SearchAndClickDelete(Utility.getProperty("ProductsItems_MenuItemName"));
		
		Thread.sleep(1000);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu Item Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "Menu Item Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Menu Item not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Search and Click Delete button
		pmt.SearchAndClickDelete(Utility.getProperty("ProductsItems_MenuItemName"));
		
		Thread.sleep(1000);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu Item Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Menu Item Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Item Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
		pmt.SearchAndClickActivate(Utility.getProperty("ProductsItems_MenuItemName"));
		
		Thread.sleep(1000);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		try
		{
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu Item Activated Successfully"))
		{
			test.log(LogStatus.FAIL, "Menu Item Activated when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Menu Item not Activated when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		Thread.holdsLock(1000);
		//Search and Activate the In activated item
		pmt.SearchAndClickActivate(Utility.getProperty("ProductsItems_MenuItemName"));
		
		Thread.sleep(1000);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu Item Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Menu Item activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Item activated Failed");
			
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
	public void Create_Duplicate_MenuItem(WebDriver driver) throws Exception
	{
		pmt=new ProductItems_Menu_RetailPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		cp=new CategoriesPage(driver, test);

		Thread.sleep(2000);
		//Click the New ProductItem_MenuItem_ button
		pmt.Click_New_MenuItem();
		Thread.sleep(2000);
	
		Thread.sleep(1000);
		//Enter the existing Menu Item name
		cmp.EnterName(Utility.getProperty("ProductsItems_MenuItemName"));
		
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
		cmp.Click_Save_and_PublishButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Menu Item Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Menu Item Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Item Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(3000);
	}
	
	
}
