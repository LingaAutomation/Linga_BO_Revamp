package com.Test;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import com.Pages.CategoriesPage;
import com.Pages.Common_XPaths;
import com.Pages.InventoryCategoryPage;
import com.Pages.InventoryItem_page;
import com.Pages.InventoryPage;
import com.Pages.LoginPage;
import com.Pages.ProductItems_Menu_RetailPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Item { 
	
public SelfHealingDriver driver;
	
	
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - item");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	InventoryPage air;
	InventoryCategoryPage icp;
	InventoryItem_page iip;
	ProductItems_Menu_RetailPage pmt ;
	Availability_RestrictionTimePage at ;
	CategoriesPage cp ;
	
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
		Open_InventoryItems_Page(driver);
     	/*RefreshAndPaginination_ColumnFilteration(driver);
		Add_New_InventoryItem_Category(driver);
	  //  Add_New_InventoryItem_SubCategory(driver);
	    Edit_Newly_Created_Inventory_Create_newStorage(driver);
	    Delete_and_Active_Inactive_Category(driver);
	    Create_Duplicate_Category(driver);
	    Searching_Inventory_Item_Search_box(driver);
	   
	    RetailItem(driver);
	    //Intergration_Category_Mapped_with_Purchase_Order(driver);
		Intergration_Category_Mapped_with_Product_Item(driver);
		 
		Intergration_Category_Mapped_with_Subrecipe(driver);
		Intergration_Category_Mapped_with_Purchase_Order(driver);
		*/
		Intergration_InventoryItem_Mapped_with_CompareInventory(driver);
     	}
	
	@Test(priority = 3,enabled = false)
	public void Open_InventoryItems_Page(SelfHealingDriver driver) throws Exception
	{
		
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"inventoryItem");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Inventory Item");	
		
		
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination_ColumnFilteration(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		//Verify the Pagination and Refresh the page
		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
		
		Thread.sleep(2000);
		//Verify Ascending order for name 
		cmp.Ascending_And_Descending_Order();
		
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Add_New_InventoryItem_Category(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iip=new InventoryItem_page(driver, test);
		
		iip.Click_New_InventoryItem_Btn();
		Thread.sleep(2000);
		//Verify the New Category creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Inventory Item");
		Thread.sleep(2000);
		iip.Inventory_name(Utility.getProperty("Inventory_Items_Name"));
		Thread.sleep(2000);
		iip.Select_invItemInventoryUnit("kg");
		Thread.sleep(2000);
		iip.ParLevel("2");
		iip.Enable_Calculate_COGS_On_Cost_Price();
		Thread.sleep(2000);
		//iip.Enable_Override_Tax();
		Thread.sleep(2000);
		iip.Select_Category();
		Thread.sleep(2000);
		//iip.Select_tax();
		Thread.sleep(2000);
		iip.Select_primary_storage();
		Thread.sleep(2000);
		iip.Select_Secondary_storage();
		Thread.sleep(2000);
		iip.Select_track();
		Thread.sleep(2000);
		iip.Recipe_Unit_input("Gm");
		//Thread.sleep(2000);
		//iip.Recipe_Quantity_input("4");
		//Thread.sleep(2000);
		//iip.Recipe_Price_input("2000");
		Thread.sleep(2000);
		iip.Select_Vendor();
		Thread.sleep(2000);
		iip.Brand_name("BaBa");
		Thread.sleep(2000);
		iip.SkuCode_name("432vf");
		Thread.sleep(2000);
		iip.purchaseUnit_input("Gm");
		Thread.sleep(2000);
		iip.purchase_quantity_input("2");
		Thread.sleep(2000);
		iip.vendorReceivingQuantity_input("2");
		Thread.sleep(2000);
		iip.vendorItemPriceStr_input("2");
		Thread.sleep(2000);
		//iip.vendorItemYield_input("2");
		Thread.sleep(2000);
		cmp.Click_Save_ButtonTwo();
		Thread.sleep(2000);
		try {
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Inventory Item saved successfully!."))
		{
			test.log(LogStatus.PASS, "Inventory Item  saved successfully!.");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Inventory Item  save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch (Exception e) {
			cmp.Click_BackspaceButton();
		}

	}
	@Test(priority = 5,enabled = false)
	public void Add_New_InventoryItem_SubCategory(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iip=new InventoryItem_page(driver, test);
		
		iip.Click_New_InventoryItem_Btn();
		Thread.sleep(2000);
		//Verify the New Category creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Inventory Item");
		Thread.sleep(2000);
		iip.Inventory_name(Utility.getProperty("Inventory_Items_Name")+"1");
		Thread.sleep(2000);
		iip.Select_invItemInventoryUnit("Gm");
		Thread.sleep(2000);
		iip.ParLevel("2");
		iip.Enable_Calculate_COGS_On_Cost_Price();
		Thread.sleep(2000);
		//iip.Enable_Override_Tax();
		Thread.sleep(2000);
		iip.Select_Subcategory_radio_Btn();
		Thread.sleep(2000);
		iip.Select_Category();
		Thread.sleep(2000);
		iip.Select_SubCategory();
		Thread.sleep(2000);
	//	iip.Select_tax();
		Thread.sleep(2000);
		iip.Select_primary_storage();
		Thread.sleep(2000);
		iip.Select_Secondary_storage();
		Thread.sleep(2000);
		iip.Select_track();
		Thread.sleep(2000);
		iip.Recipe_Unit_input("Kg");
		Thread.sleep(2000);
		//iip.Recipe_Quantity_input("4");
		//Thread.sleep(2000);
		//iip.Recipe_Price_input("2000");
		Thread.sleep(2000);
		iip.Select_Vendor();
		Thread.sleep(2000);
		iip.Brand_name("BaBa");
		Thread.sleep(2000);
		iip.SkuCode_name("432vf");
		Thread.sleep(2000);
		iip.purchaseUnit_input("Gm");
		Thread.sleep(2000);
		iip.purchase_quantity_input("21");
		Thread.sleep(2000);
		iip.vendorReceivingQuantity_input("22");
		
		iip.vendorItemPriceStr_input("22");
		
	//	iip.vendorItemYield_input("22");
		
		cmp.Click_Save_ButtonTwo();
		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Inventory Item saved successfully!."))
		{
			test.log(LogStatus.PASS, "Inventory Item  saved successfully!.");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Inventory Item  save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		

	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_Newly_Created_Inventory_Create_newStorage(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iip=new InventoryItem_page(driver, test);

		Thread.sleep(1000);
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_Items_Name"));
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Inventory Item");
		
		Thread.sleep(1000);
		//Click the Close button
		cmp.Click_BackspaceButton();
		
		Thread.sleep(1000);
		//Check whether the New Course Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Editing Course screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Editing Course screen not Closed");
		}
		
		Thread.sleep(3000);
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_Items_Name"));
		Thread.sleep(2000);
		iip.Inventory_name(Utility.getProperty("Inventory_Items_Name")+"2");
		Thread.sleep(2000);
		//iip.Select_invItemInventoryUnit("kg");
		Thread.sleep(2000);
		iip.ParLevel("2");
		iip.Enable_Calculate_COGS_On_Cost_Price();
		Thread.sleep(2000);
		//iip.Enable_Override_Tax();
		Thread.sleep(2000);
		iip.Select_Category();
		Thread.sleep(2000);
		//iip.Select_tax();
		Thread.sleep(2000);
		String primary = RandomStringUtils.randomAlphabetic(6);
		iip.Add_new_Primary_storage(primary);
		Thread.sleep(2000);
		String Secondary = RandomStringUtils.randomAlphabetic(6);
		iip.Add_new_Secondary_storage(Secondary);
		Thread.sleep(2000);
		//iip.Select_primary_storage();
		Thread.sleep(2000);
		//iip.Select_Secondary_storage();
		Thread.sleep(2000);
		iip.Select_track();
		Thread.sleep(2000);
		iip.Recipe_Unit_input("Gm");
		//Thread.sleep(2000);
		//iip.Recipe_Quantity_input("4");
		//Thread.sleep(2000);
		//iip.Recipe_Price_input("2000");
		Thread.sleep(2000);
		iip.Select_Vendor();
		Thread.sleep(2000);
		iip.Brand_name("BaBa");
		Thread.sleep(2000);
		iip.SkuCode_name("432vf");
		Thread.sleep(2000);
		iip.purchaseUnit_input("Gm");
		Thread.sleep(2000);
		iip.purchase_quantity_input("2");
		Thread.sleep(2000);
		iip.vendorReceivingQuantity_input("2");
		Thread.sleep(2000);
		iip.vendorItemPriceStr_input("2");
		Thread.sleep(2000);
		//iip.vendorItemYield_input("2");
		Thread.sleep(2000);
		cmp.Click_Update_ButtonTwo();
		Thread.sleep(2000);
		try {
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Inventory Item Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Inventory Item  saved successfully!.");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Inventory Item  save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch (Exception e) {
			cmp.Click_BackspaceButton();
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Category(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iip=new InventoryItem_page(driver, test);
		
		
		//Search and Click Delete button
				cmp.SearchAndClickDelete(Utility.getProperty("Inventory_Items_Name")+"2");
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();

				Thread.sleep(3000);
				try
				{
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Inactivated Successfully"))
				{
					test.log(LogStatus.FAIL, "Category Deleted when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Category not Deleted when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				
				//Search and Click Delete button
				cmp.SearchAndClickDelete(Utility.getProperty("Inventory_Items_Name")+"2");
				
				//Click Delete button
				cmp.Click_DeleteButton();
				
				Thread.sleep(3000);
				//Check whether the New Course Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Inactivated Successfully"))
				{
					test.log(LogStatus.PASS, "Category Inactivated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Category Inactivated Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Enable the Inactive Status
				iip.Click_ActivetoInactiveButton();
				
				//Check whether the Inactive screen opened or not
				cmp.VerifyActive_InactiveStatus("Inactive");
				
				//Search and Activate the In activated item
						cmp.SearchAndClickActivate(Utility.getProperty("Inventory_Items_Name")+"2");
						
						Thread.sleep(500);
						//Click the Delete button
						cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
						
						//Click the Cancel button
						cmp.Click_CancelButtonInAlert();

						try
						{
						Thread.sleep(3000);
						//Check whether the New Modifier Saved or not
						if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Activated Successfully"))
						{
							test.log(LogStatus.FAIL, "Category Activated when clicking Cancel button");
						
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						}
						catch(Exception g)
						{
							test.log(LogStatus.PASS, "Category not Activated when Clicking Cancel button");
							
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
						}

				
				//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("Inventory_Items_Name")+"2");
				
				//Click Activate button
						cmp.Click_ActivateButton();
						
				
				Thread.sleep(3000);
				//Check whether the New Course Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Activated Successfully"))
				{
					test.log(LogStatus.PASS, "Category activated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Category activated Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				Thread.sleep(500);
				//Enable Active Status
				iip.Click_InactivetoActiveButton();
						
				Thread.sleep(500);
				//Check whether verify whether the Active page opened or not
				cmp.VerifyActive_InactiveStatus("Active");
				
				Thread.sleep(1000);
				//Search the Category to Click Edit and Cancel
				cmp.SearchAndClickEdit(Utility.getProperty("Inventory_Items_Name")+"2");
				
				Thread.sleep(1000);
				//Click Cancel button
				cmp.Click_BackspaceButton();
				

	}
	
	@Test(priority = 5,enabled = false)
	public void Create_Duplicate_Category(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iip=new InventoryItem_page(driver, test);
		Thread.sleep(2000);
		iip.Click_New_InventoryItem_Btn();
		Thread.sleep(2000);
		//Verify the New Category creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Inventory Item");
		Thread.sleep(2000);
		iip.Inventory_name(Utility.getProperty("Inventory_Items_Name"));
		Thread.sleep(2000);
		iip.Select_invItemInventoryUnit("kg");
		Thread.sleep(2000);
		iip.ParLevel("2");
		iip.Enable_Calculate_COGS_On_Cost_Price();
		Thread.sleep(2000);
		//iip.Enable_Override_Tax();
		Thread.sleep(2000);
		iip.Select_Category();
		Thread.sleep(2000);
		//iip.Select_tax();
		Thread.sleep(2000);
		iip.Select_primary_storage();
		Thread.sleep(2000);
		iip.Select_Secondary_storage();
		Thread.sleep(2000);
		iip.Select_track();
		Thread.sleep(2000);
		iip.Recipe_Unit_input("Gm");
		//Thread.sleep(2000);
		//iip.Recipe_Quantity_input("4");
		//Thread.sleep(2000);
		//iip.Recipe_Price_input("2000");
		Thread.sleep(2000);
		iip.Select_Vendor();
		Thread.sleep(2000);
		iip.Brand_name("BaBa");
		Thread.sleep(2000);
		iip.SkuCode_name("432vf");
		Thread.sleep(2000);
		iip.purchaseUnit_input("Gm");
		Thread.sleep(2000);
		iip.purchase_quantity_input("2");
		Thread.sleep(2000);
		iip.vendorReceivingQuantity_input("2");
		Thread.sleep(2000);
		iip.vendorItemPriceStr_input("2");
		Thread.sleep(2000);
		//iip.vendorItemYield_input("2");
		Thread.sleep(2000);
		cmp.Click_Save_ButtonTwo();
		Thread.sleep(2000);
		try {
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Inventory Item saved successfully!."))
		{
			test.log(LogStatus.PASS, "Inventory Item  saved successfully!.");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Inventory Item  save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch (Exception e) {
			cmp.Click_BackspaceButton();
		}

		
	}
	
	@Test(priority = 5,enabled = false)
	public void RetailItem(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		 icp = new InventoryCategoryPage(driver, test);
		 
		 Thread.sleep(5000);
			//Load the Department page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"inventoryItem");

			Thread.sleep(5000);
			
			if(driver.findElement(By.xpath("//button/span[contains(.,'RETAIL ITEMS')]")).isDisplayed()) {
				
				driver.findElement(By.xpath("//button/span[contains(.,'RETAIL ITEMS')]")).click();
			}
		 
			//Verify the Pagination and Refresh the page
			cmp.VerifyPagination_and_Refresh_Publish();
			
			//Verify Column Filtration
			cmp.Filter_Columns();
			
			Thread.sleep(2000);
			//Verify Ascending order for name 
			cmp.Ascending_And_Descending_Order();
			
			String less_than_3_char = RandomStringUtils.randomAlphabetic(2);
			
			cmp.Verify_Search(less_than_3_char);
			
			/*
		    String Special = "*%&$&^&";
			
			cmp.Verify_Search(Special);
			
			
			if(driver.findElement(By.xpath("//div[contains(@class,'no-data ng-star-inserted')]/span")).getText().equalsIgnoreCase("Item not found"))
			{
				test.log(LogStatus.PASS, "Could not find inventory items Pop up displayed");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Could not find inventory items Pop up is not displayed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
			*/
			String Numeric = RandomStringUtils.randomNumeric(5);
			
			cmp.Verify_Search(Numeric);
			
			
			
			if(driver.findElement(By.xpath("//div[contains(@class,'no-data ng-star-inserted')]/span")).getText().equalsIgnoreCase("Item not found"))
			{
				test.log(LogStatus.PASS, "Item not found message is displayed");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Item not found message is not displayed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
			
			String Alphanumeric = RandomStringUtils.randomAlphanumeric(5);
			
			cmp.Verify_Search(Alphanumeric);
			
			
			
			if(driver.findElement(By.xpath("//div[contains(@class,'no-data ng-star-inserted')]/span")).getText().equalsIgnoreCase("Item not found"))
			{
				test.log(LogStatus.PASS, "Item not found message is displayed");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Item not found message is not displayed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
		
		 
	}
	@Test(priority = 5,enabled = false)
	public void Intergration_Category_Mapped_with_Product_Item(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		 icp = new InventoryCategoryPage(driver, test);
		 pmt=new ProductItems_Menu_RetailPage(driver, test);
			
			at=new Availability_RestrictionTimePage(driver, test);
			cp=new CategoriesPage(driver, test);
			
			icp=new InventoryCategoryPage(driver, test);
			iip = new InventoryItem_page(driver, test);
			Thread.sleep(5000);
			//Load the Department page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"inventoryItem");

			Thread.sleep(5000);
			
			iip.Click_New_InventoryItem_Btn();
			Thread.sleep(2000);
			//Verify the New Category creation screen opened or not
			cmp.VerifyCreationScreenPageHeader("New Inventory Item");
			Thread.sleep(2000);
			Thread.sleep(500);
			String Inventory_Items_Name = RandomStringUtils.randomAlphanumeric(5);
			iip.Inventory_name(Inventory_Items_Name);
			Thread.sleep(2000);
			iip.Select_invItemInventoryUnit("kg");
			Thread.sleep(2000);
			iip.ParLevel("2");
			iip.Enable_Calculate_COGS_On_Cost_Price();
			Thread.sleep(2000);
		//	iip.Enable_Override_Tax();
			Thread.sleep(2000);
			iip.Select_Category();
			Thread.sleep(2000);
			//iip.Select_tax();
			Thread.sleep(2000);
			iip.Select_primary_storage();
			Thread.sleep(2000);
			iip.Select_Secondary_storage();
			Thread.sleep(2000);
			iip.Select_track();
			Thread.sleep(2000);
			iip.Recipe_Unit_input("Gm");
			//Thread.sleep(2000);
			//iip.Recipe_Quantity_input("4");
			//Thread.sleep(2000);
			//iip.Recipe_Price_input("2000");
			Thread.sleep(2000);
			iip.Select_Vendor();
			Thread.sleep(2000);
			iip.Brand_name("BaBa");
			Thread.sleep(2000);
			String SkuCode_name = RandomStringUtils.randomAlphanumeric(5);
			
			iip.SkuCode_name(SkuCode_name);
			Thread.sleep(2000);
			iip.purchaseUnit_input("Gm");
			Thread.sleep(2000);
			iip.purchase_quantity_input("2");
			Thread.sleep(2000);
			iip.vendorReceivingQuantity_input("2");
			Thread.sleep(2000);
			iip.vendorItemPriceStr_input("2");
			Thread.sleep(2000);
			//iip.vendorItemYield_input("2");
			Thread.sleep(2000);
			cmp.Click_Save_ButtonTwo();
			Thread.sleep(2000);
			try {
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Inventory Item saved successfully!."))
			{
				test.log(LogStatus.PASS, "Inventory Item  saved successfully!.");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Inventory Item  save Failed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			}
			catch (Exception e) {
				cmp.Click_BackspaceButton();
			}

			
			
			
			
			Thread.sleep(5000);
			//Load the Department page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"taxInventory");

			Thread.sleep(5000);
			
			if(icp.EnableTax_Yes().isDisplayed()) {
				
				icp.EnableTax_No().click();
			}
			
			Thread.sleep(5000);
			//icp.PublishButton().click();
			Thread.sleep(5000);
			//Load the Department page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"category");

			Thread.sleep(5000);

			Thread.sleep(2000);
			icp.Click_NewCategory();
			
			//Verify the New Category creation screen opened or not
			cmp.VerifyCreationScreenPageHeader("New Category");
			Thread.sleep(2000);
			icp.Name_category(Utility.getProperty("Inventory_Category_Name"));
			icp.Clear_Name_category();
			Thread.sleep(3000);
			
			/*
			if(icp.alert_text().getText().equalsIgnoreCase("Please Enter Name"))
			{
				test.log(LogStatus.PASS, "Please Enter Name Alert Displayed");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Please Enter Name Alert not Displayed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			*/
			
			Thread.sleep(500);
			String Inventory_Category_Name = RandomStringUtils.randomAlphanumeric(5);
			icp.Name_category(Inventory_Category_Name);
			Thread.sleep(3000);
			icp.Code_category(RandomStringUtils.randomNumeric(4));
			Thread.sleep(3000);
			try {
			icp.Select_tax();
			}
			catch (Exception e) {
				
				test.log(LogStatus.FAIL, "Inventory tax is enable Yes , But tax is not enabled");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			}
			Thread.sleep(3000);
			icp.Description_Box("Description");
			icp.Click_Save_Btn();
			
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("category saved successfully!."))
			{
				test.log(LogStatus.PASS, "category saved successfully!.");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "category save Failed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(5000);
			//Load the Department page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"productItems");

			Thread.sleep(5000);
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
			
		
			Thread.sleep(500);
			String Menu_Name = RandomStringUtils.randomAlphanumeric(5);
			Thread.sleep(2000);
			//Enter the Menu Item Name
			cmp.EnterName(Menu_Name);
			
			//Enter the Secondary name
			pmt.Enter_Secondary_Name(Menu_Name);
			
			
			//Enter the PLU Code
			pmt.Enter_PLU_Code(Utility.getProperty("ProductsItems_PLU_Code"));
			
			Thread.sleep(1000);
			//Select Item Preparation Time
			pmt.Enter_Item_Preparation_Time("11");
			
			Thread.sleep(1000);
			//Enter Kitchen Printer Name
			pmt.Enter_Kitchen_Printer_Name("Kitchen Printer 01");
			
//			for(int i=1;i<=5;i++)
//			{
//				Thread.sleep(1000);
//				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
//			}
			
			Thread.sleep(1000);
			//Select Category Level Type
			pmt.Click_Category_LevelType();
			
			Thread.sleep(5000);
			//Select Category
			pmt.Select_Category_LevelType();
			
			//Enter Description
			pmt.Enter_Description("Menu Item");
			
			//Enable Evertex
//			pmt.Select_Evertex_TaxType();
			
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
			
//			for(int i=1;i<=3;i++)
//			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
//			}
			Thread.sleep(1000);
			//cp.Create_Category_NewTax(Utility.getProperty("ProductsItems_MenuItem_Tax"));
			Thread.sleep(2000);
			//Select Taxes
			cp.Select_Taxes();
			
			Thread.sleep(2000);
			
			
			Thread.sleep(1000);
			//Enable Hide in kiosk
			pmt.Enable_Hide_In_Kiosk();
			
			//Enable EBT Menu Item
//			pmt.Enable_EBT_Menu_Item();
			
			//Enable Hide In POS
			pmt.Enable_Hide_In_POS();
			
			//Enable Hide In Online Order
			pmt.Enable_Hide_In_Online_Order();
			
			//Enable 86 List
			pmt.Enable_Eighty_Six_List();
			
			//Enable Meito MenuItem
			//pmt.Enable_Meito_MenuItem();
			 
			//Select Always
			at.Click_AlwaysButton();
			
			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
			
			//Select Kitchen Printer
//			cp.Select_KitchenPrinter();
			
			//Select Label Printer
//			cp.Select_LabelPrinter();
			
			//Select Restrict Printer
//			cp.Select_RestrictPrinter();
			Thread.sleep(1000);
			for(int i=1;i<=5;i++)
			{
				Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);		
			}
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//mat-step-header/div//div[contains(.,'Inventory Details')]")).click();
			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//app-inventory-details/div/div/div/div//div[contains(.,'+ Add Inventory Item')]")).click();
			Thread.sleep(5000);
			
			iip.Add_inv_detail_categories(Inventory_Category_Name);
			
			Thread.sleep(2000);
			iip.Add_inv_Item_Detail(Inventory_Items_Name);
			
			
			Thread.sleep(1000);
			for(int i=1;i<=5;i++)
			{
				Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);		
			}
			Thread.sleep(5000);
			
			
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
	public void Intergration_Category_Mapped_with_Subrecipe(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		 icp = new InventoryCategoryPage(driver, test);
		 iip=new InventoryItem_page(driver, test);
		 
		 
		 
			Thread.sleep(5000);
			//Load the Department page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"subRecipe");

			Thread.sleep(5000);
		
		
	Thread.sleep(2000);
	//Click the New Coursing
	air.Click_New_SubRecipe();
	Thread.sleep(2000);

	//Verify the New Course creation screen opened or not
	cmp.VerifyCreationScreenPageHeader("New Sub Recipe");
	Thread.sleep(2000);
	
	if(cmp.Save_ButtonTwo().isEnabled())
	{
	//Click the Save button
	cmp.Click_Save_ButtonTwo();
	
	Thread.sleep(3000);
	//Check whether the New Course Saved or not
	if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Name"))
	{
		test.log(LogStatus.PASS, "Please Enter Name Alert Displayed");
	
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
	}
	else
	{
		test.log(LogStatus.FAIL, "Please Enter Name Alert not Displayed");
		
		ut.FailedCaptureScreenshotAsBASE64(driver, test);
	}
	}
	else
	{
		test.log(LogStatus.INFO, "Save button not Enabled without Entering Sub Recipe Name");
	}
	
	//Verify whether the Entering Name character limits in Input
	cmp.Verify_Enter_Excess_Limit_Name(cmp.NameInputBox());
	
	
	
	
	Thread.sleep(500);
	String Inventory_SubRecipe_Name = RandomStringUtils.randomAlphanumeric(5);
	//Enter the Course Name
	cmp.EnterName(Inventory_SubRecipe_Name);
	
	if(cmp.Save_ButtonTwo().isEnabled())
	{
	//Click the Save button
	cmp.Click_Save_ButtonTwo();
	
	Thread.sleep(3000);
	test.log(LogStatus.FAIL, "Save button Enabled without Selecting Inventory Item");
	}
	else
	{
		test.log(LogStatus.PASS, "Save button not Enabled without Selecting Inventory Item");
	}
	
	//Select the Inventory Item
	iip.Select_SubRecipeInventoryUnit();
	
	//Enable Calculate COGS on Cost Price
	air.Calculate_COGS_onCost_Price_YesToggle().click();
	
	//Enter Preparation Notes
	air.Enter_Preparation_Notes(Inventory_SubRecipe_Name);
	
	//Enter the Quantity
	air.Enter_Quantity("100");
	
	if(cmp.Save_ButtonTwo().isEnabled())
	{
	//Click the Save button
	cmp.Click_Save_ButtonTwo();
	
	Thread.sleep(3000);
	test.log(LogStatus.FAIL, "Save button Enabled without Entering Quanity");
	}
	else
	{
		test.log(LogStatus.PASS, "Save button not Enabled without Entering Quantity");
	}
	
	//Enter the Yield %
	air.Enter_Yield_Percentage("105.00");
	
	//Verify the Enter Yield Should Not Be Greater Than 100 Warning Pop up displayed or not
	air.Verify_Yield_Warning_Above_100Percentage();
	
	//Enter the Yield %
	air.Enter_Yield_Percentage("50.00");
			
	//Enter the Price Per Unit
	air.Enter_Price_Per_Unit("10");
	
	//Create the New Storage
//	air.Create_New_Storage(ut.getProperty("Inventory_SubRecipe_Primary_Storage_Name"), "Primary Storage Saved");
	air.Select_Primary_Storage();
	
	//Add the Recipe Units
	air.Add_Receipe_Units("10");
	
	//Add the Inventory Item
	air.Click_Add_InventoryItem();
	
	if(cmp.Save_ButtonTwo().isEnabled())
	{
	//Click the Save button
	cmp.Click_Save_ButtonTwo();
	
	Thread.sleep(3000);
	test.log(LogStatus.FAIL, "Save button Enabled without Selecting Inventory/SubRecipes/Manual Entry Items");
	}
	else
	{
		test.log(LogStatus.PASS, "Save button not Enabled without Selecting Inventory/SubRecipes/Manual Entry Items");
	}
	
	//Select and Add the Inventory Items
	air.Add_Inventory_Items_inSubRecipe("10");
	
	Thread.sleep(2000);
	//Click the Save button
	cmp.Click_Save_ButtonTwo();
	
	
	Thread.sleep(3000);
	//Check whether the New Course Saved or not
	if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub Recipe saved successfully!."))
	{
		test.log(LogStatus.PASS, "Sub Recipe Saved Successfully");
	
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
	}
	else
	{
		test.log(LogStatus.FAIL, "Sub Recipe Save Failed");
		
		ut.FailedCaptureScreenshotAsBASE64(driver, test);
	}

	
}
	
	
	@Test(priority = 5,enabled = false)
	public void Intergration_Category_Mapped_with_Purchase_Order(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		 icp = new InventoryCategoryPage(driver, test);
		 
		 
			Thread.sleep(5000);
			//Load the Department page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"purchases");

			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//div[contains(.,'Purchase Orders')]/span")).click();
			Thread.sleep(5000);
			
			
			driver.findElement(By.xpath("//span[contains(.,' NEW PURCHASE ORDER')]")).click();
			Thread.sleep(2000);
			//Verify the New Category creation screen opened or not
			cmp.VerifyCreationScreenPageHeader("NEW PURCHASE ORDER");
			Thread.sleep(2000);
			iip.Select_Vendor();
			Thread.sleep(2000);
			
			iip.Add_Inventory_Item();
	
	}
	
	@Test(priority = 5,enabled = false)
	public void Intergration_Category_Mapped_with_Recived(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		 icp = new InventoryCategoryPage(driver, test);
		 
		 
			Thread.sleep(5000);
			//Load the Department page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"purchases");

			Thread.sleep(5000);
			
			driver.findElement(By.xpath("//div[contains(.,'Received Items')]/span")).click();
			Thread.sleep(5000);
			
			
			driver.findElement(By.xpath("//span[contains(.,'RECEIVE NEW ITEM')]")).click();
			Thread.sleep(2000);
			//Verify the New Category creation screen opened or not
			cmp.VerifyCreationScreenPageHeader("Receive New Item");
			Thread.sleep(2000);
			iip.Select_Inventory_Item();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//app-input[contains(@name,'quantity')]//mat-icon[contains(.,'arrow_drop_up')]/..")).click();
			Thread.sleep(2000);
			iip.Select_primary_storage();
			Thread.sleep(2000);
			iip.Select_Secondary_storage();
			Thread.sleep(2000);
			iip.Save_btn();
			

			Thread.sleep(3000);
			//Check whether the New Course Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("purchase item saved successfully"))
			{
				test.log(LogStatus.PASS, "Sub Recipe Saved Successfully");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Sub Recipe Save Failed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}

	
	}
	@Test(priority = 5,enabled = false)
	public void Searching_Inventory_Item_Search_box(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iip=new InventoryItem_page(driver, test);
		
		String less_than_3_char = RandomStringUtils.randomAlphabetic(2);
		
		cmp.Verify_Search(less_than_3_char);
		
		/*
	    String Special = "@#$$$";
		
		cmp.Verify_Search(Special);
		
		if(driver.findElement(By.xpath("//div[contains(@class,'no-data ng-star-inserted')]/span")).getText().equalsIgnoreCase("Item not found"))
		{
			test.log(LogStatus.PASS, "Could not find inventory items Pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Could not find inventory items Pop up is not displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		*/
		
		String Numeric = RandomStringUtils.randomNumeric(5);
		
		cmp.Verify_Search(Numeric);
		
		
		
		if(driver.findElement(By.xpath("//div[contains(@class,'no-data ng-star-inserted')]/span")).getText().equalsIgnoreCase("Item not found"))
		{
			test.log(LogStatus.PASS, "Item not found message is displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item not found message is not displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		String Alphanumeric = RandomStringUtils.randomAlphanumeric(5);
		
		cmp.Verify_Search(Alphanumeric);
		
		
		
		if(driver.findElement(By.xpath("//div[contains(@class,'no-data ng-star-inserted')]/span")).getText().equalsIgnoreCase("Item not found"))
		{
			test.log(LogStatus.PASS, "Item not found message is displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item not found message is not displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Intergration_InventoryItem_Mapped_with_CompareInventory(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		 icp = new InventoryCategoryPage(driver, test);
		
			iip = new InventoryItem_page(driver, test);
			Thread.sleep(5000);
			//Load the Department page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"inventoryItem");

			Thread.sleep(5000);
			
			iip.Click_New_InventoryItem_Btn();
			Thread.sleep(2000);
			//Verify the New Category creation screen opened or not
			cmp.VerifyCreationScreenPageHeader("New Inventory Item");
			Thread.sleep(2000);
			Thread.sleep(500);
			String Inventory_Items_Name = RandomStringUtils.randomAlphanumeric(5);
			iip.Inventory_name(Inventory_Items_Name);
			Thread.sleep(2000);
			iip.Select_invItemInventoryUnit("kg");
			Thread.sleep(2000);
			iip.ParLevel("2");
			iip.Enable_Calculate_COGS_On_Cost_Price();
			Thread.sleep(2000);
		//	iip.Enable_Override_Tax();
			Thread.sleep(2000);
			iip.Select_Category();
			Thread.sleep(2000);
			//iip.Select_tax();
			Thread.sleep(2000);
			iip.Select_primary_storage();
			Thread.sleep(2000);
			iip.Select_Secondary_storage();
			Thread.sleep(2000);
			iip.Select_track();
			Thread.sleep(2000);
			iip.Recipe_Unit_input("Gm");
			//Thread.sleep(2000);
			//iip.Recipe_Quantity_input("4");
			//Thread.sleep(2000);
			//iip.Recipe_Price_input("2000");
			Thread.sleep(2000);
			iip.Select_Vendor();
			Thread.sleep(2000);
			iip.Brand_name("BaBa");
			Thread.sleep(2000);
			String SkuCode_name = RandomStringUtils.randomAlphanumeric(5);
			
			iip.SkuCode_name(SkuCode_name);
			Thread.sleep(2000);
			iip.purchaseUnit_input("Gm");
			Thread.sleep(2000);
			iip.purchase_quantity_input("2");
			Thread.sleep(2000);
			iip.vendorReceivingQuantity_input("2");
			Thread.sleep(2000);
			iip.vendorItemPriceStr_input("2");
			Thread.sleep(2000);
			//iip.vendorItemYield_input("2");
			Thread.sleep(2000);
			cmp.Click_Save_ButtonTwo();
			Thread.sleep(2000);
			try {
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Inventory Item saved successfully!."))
			{
				test.log(LogStatus.PASS, "Inventory Item  saved successfully!.");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Inventory Item  save Failed");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			}
			catch (Exception e) {
				cmp.Click_BackspaceButton();
			}
			
			Thread.sleep(5000);
			//Load the cogsReport page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"inventoryReports/"+"compareInventory");
			Thread.sleep(10000);
			
			cmp.Verify_Search(Inventory_Items_Name);
			
			try {
				if(driver.findElement(By.xpath("//div[contains(@class,'compare-inventory-report-table')]/table/tbody/tr/td[1]")).getText().equalsIgnoreCase(Inventory_Items_Name))
				{
					test.log(LogStatus.PASS, "Searched inventory item displayed when entering in Search Box of compare Inventory");
				}
				}
				catch(Exception o)
				{
					test.log(LogStatus.FAIL, "Searched inventory item  not displayed when entering Search box of compare Inventory");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
			
	
}

