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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.Availability_RestrictionTimePage;
import com.Pages.CategoriesPage;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.Pages.SubCategoriesPage;
import com.Test.LoginTest;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AllClassCalling_Product_and_Items 
{

public WebDriver driver;
	

ExtentReports rep = ExtentManager.getInstance();
ExtentTest test = rep.startTest("Retesting Suite for Product/Items");

LoginPage lgpg; 

Utility ut=new Utility();

Common_XPaths cmp;
LoginTest a=new LoginTest();
	
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
	
			try
			{
				if(new LoginPage(driver, test).LoginPageHeaderText().isDisplayed())
				{
					test.log(LogStatus.FAIL, "Application Logged Out");
					Login();
				}
			}
			catch(Exception lp) 
			{
				
			}
			
			
		
		}
	}
	
	
	@BeforeTest
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
	
	@AfterTest
	public void LogOut() throws Exception
	{
		a.LogOut(driver, test);
	}

	
	@Test(priority = 3,enabled = true)
	public void Product_Items_AddEditDelete_Departments() throws Exception
	{
		Product_Items_AddEditDelete_Departments a=new Product_Items_AddEditDelete_Departments();
		a.Open_Departments_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_Departments(driver);
		a.Edit_and_Close_Cancel_Departments(driver);
		a.Edit_and_Update_Departments(driver);
		a.Delete_and_Active_Inactive_Departments(driver);
		a.Create_DuplicateDepartment(driver);
		
				
	}
	
	
	@Test(priority = 4,enabled = true)
	public void Product_Items_AddEditDelete_Coursing() throws Exception
	{
		Product_Items_AddEditDelete_Coursing a=new Product_Items_AddEditDelete_Coursing();
		a.Open_Coursing_Page(driver);
		a.RefreshAndPaginination_ColumnFilteration(driver);
		a.Add_Coursing(driver);
		a.Edit_and_Close_Cancel_Coursing(driver);
		a.Edit_and_Update_Coursing(driver);
		a.Delete_and_Active_Inactive_Coursing(driver);
		a.Create_DuplicateCourse(driver);
			
	}
	
	
	@Test(priority = 5,enabled = true)
	public void Product_Items_AddEditDelete_Serving_Size_Levels() throws Exception
	{
		Product_Items_AddEditDelete_Serving_Size_Levels a=new Product_Items_AddEditDelete_Serving_Size_Levels();
		a.Open_Service_Size_Levels_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_Servinge_Size_Level(driver);
		a.Edit_and_Close_Cancel_Serving_Size_Level(driver);
		a.Edit_and_Update_Serving_Size_Level(driver);
		a.Delete_and_Active_Inactive_Serving_Size_Level(driver);
		a.Create_DuplicateServing_Size_Level(driver);
			
	}
	
	@Test(priority = 6,enabled = true)
	public void Product_Items_AddEditDelete_Taxes() throws Exception
	{
		Product_Items_AddEditDelete_Taxes a=new Product_Items_AddEditDelete_Taxes();
		a.Open_Taxes_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_ItemTax_Amount(driver);
		a.Add_ItemTax_Percentage(driver);
		a.Add_CheckTax(driver);
		a.Add_TaxOnItemTax(driver);
		a.Add_TaxOnCheckTax(driver);
		a.Edit_and_Close_Cancel_Taxes(driver);
		a.Edit_and_Update_ItemTax(driver);
		a.Edit_and_Update_CheckTax(driver);
		a.Edit_and_Update_Tax_On_Item_Tax(driver);
		a.Edit_and_Update_Tax_On_Check_Tax(driver);
		a.Delete_and_Active_Inactive_Taxes(driver);
		a.Create_Duplicate_Tax(driver);
//		a.Add_Tax_For_Tax_Per_ServiceType(driver);
//		a.Edit_and_Update_Tax_Per_ServiceType(driver);
			
	}
	
	@Test(priority = 7,enabled = true)
	public void Product_Items_AddEditDelete_Categories() throws Exception
	{
		Product_Items_AddEditDelete_Categories a=new Product_Items_AddEditDelete_Categories();
		a.Open_Categories_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_Categories(driver); 
		a.Edit_and_Close_Cancel_Categories(driver);
		a.Edit_and_Update_Categories_DaysOfWeek(driver);
		a.Edit_and_Update_Categories_DaysOfMonth(driver);
		a.Edit_and_Update_Categories_DateRange(driver);
		a.Edit_and_Update_Categories_Specific_Date(driver);
		a.Edit_and_Update_Categories_DateRangeWithTime(driver);
		a.Delete_and_Active_Inactive_Categories(driver);
		a.Create_DuplicateCategory(driver);
			
	}
	
	
	@Test(priority = 8,enabled = true)
	public void Product_Items_AddEditDelete_SubCategories() throws Exception
	{
		Product_Items_AddEditDelete_SubCategories a=new Product_Items_AddEditDelete_SubCategories();
		a.Open_SubCategories_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_SubCategories(driver);
		a.Edit_and_Close_Cancel_SubCategories(driver);
		a.Edit_and_Update_SubCategories_DaysOfWeek(driver);
		a.Edit_and_Update_SubCategories_DaysOfMonth(driver);
		a.Edit_and_Update_SubCategories_DateRange(driver);
		a.Edit_and_Update_SubCategories_Specific_Date(driver);
		a.Edit_and_Update_SubCategories_DateRangeWithTime(driver);
		a.Delete_and_Active_Inactive_SubCategories(driver); 
		a.Create_DuplicateSubCategory(driver);
			
	}
	
	
	@Test(priority = 9,enabled = true)
	public void Product_Items_AddEditDelete_Modifiers() throws Exception
	{
		Product_Items_AddEditDelete_Modifiers a=new Product_Items_AddEditDelete_Modifiers();
		a.Open_Modifiers_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_Modifiers(driver);
		a.Edit_and_Close_Cancel_Modifiers(driver);
		a.Edit_and_Remove_Prefix_Update_Modifiers(driver);
		a.Edit_and_Remove_ServingSizeLevels_Update_Modifiers(driver);
		a.Edit_and_Update_Modifiers(driver);
		a.Delete_and_Active_Inactive_Modifiers(driver);
		a.Add_Modifiers_BasicDetails(driver);
		a.Create_DuplicateModifier(driver);
			
	}
	
	@Test(priority = 10,enabled = true)
	public void Product_Items_AddEditDelete_ModifierGroups() throws Exception
	{
		Product_Items_AddEditDelete_ModifierGroups a=new Product_Items_AddEditDelete_ModifierGroups();
		a.Open_ModifierGroups_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_ModifierGroups(driver);
		a.Edit_and_Close_Cancel_ModifierGroups(driver);
		a.Edit_and_Update_ModifierGroups(driver);
		a.Edit_and_Sorting_Update_ModifierGroups(driver);
		a.Delete_and_Active_Inactive_ModifierGroups(driver);
		a.Add_ModifierGroups_BasicDetails(driver);
		a.Create_DuplicateModifierGroup(driver);
			
	}
	
	@Test(priority = 11,enabled = true)
	public void Product_Items_Meito() throws Exception
	{
		Product_Items_Meito a=new Product_Items_Meito();
		a.Open_Meito_Page(driver);
		a.Update_Meito(driver);
			
	}
	
	@Test(priority = 12,enabled = true)
	public void Product_Items_AddEditDelete_MenuItem() throws Exception
	{
		
		Product_Items_AddEditDelete_MenuItem a=new Product_Items_AddEditDelete_MenuItem();
		a.Open_ProductItem_MenuItem_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_ProductItem_MenuItem_Always_MenuType_MenuItem(driver);
		a.Edit_and_Close_Cancel_ProductItem_MenuItem(driver);
		a.Edit_and_Update_ProductItem_MenuItem_DaysOfWeek_SubCategory_LevelType(driver);
		a.Edit_and_Update_ProductItem_MenuItem_DaysOfMonth_MenuType_MenuItem_With_ServingSize(driver);
		a.Edit_and_Update_ProductItem_MenuItem_DateRange_MenuType_OpenItem(driver);
		a.Edit_and_Update_ProductItem_MenuItem_Specific_Date_MenuType_ScaleItem(driver);
		a.Edit_and_Update_ProductItem_MenuItem_DateRangeWithTime_MenuType_ComboItem(driver);
		a.Delete_and_Active_Inactive_ProductItem_MenuItem(driver);
		a.Create_Duplicate_MenuItem(driver);

		
	}
	
	@Test(priority = 13,enabled = true)
	public void Product_Items_AddEditDelete_RetailItem() throws Exception
	{
		Product_Items_AddEditDelete_RetailItem a=new Product_Items_AddEditDelete_RetailItem();
		a.Open_ProductItem_RetailItem_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_ProductItem_RetailItem_Always_ProductType_StandardItem(driver);
		a.Edit_and_Close_Cancel_ProductItem_RetailItem(driver);
		a.Edit_and_Update_ProductItem_RetailItem_DaysOfWeek_SubCategory_LevelType(driver);
		a.Edit_and_Update_ProductItem_RetailItem_DaysOfMonth_ProductType_Item_withVariants(driver);
		a.Edit_and_Update_ProductItem_RetailItem_DateRange_ProductType_CompositeItem(driver);
		a.Edit_and_Update_ProductItem_RetailItem_Specific_Date(driver);
		a.Edit_and_Update_ProductItem_RetailItem_DateRangeWithTime(driver);
		a.Delete_and_Active_Inactive_ProductItem_RetailItem(driver);
		a.Create_Duplicate_RetailItem(driver);
			
	}
	
	@Test(priority = 14,enabled = true)
	public void Product_Items_Bulk_Update() throws Exception
	{
		Product_Items_Bulk_Update a=new Product_Items_Bulk_Update();
		a.Open_Bulk_Update_Page(driver);
		a.Verify_single_MenuItem_Update_Page(driver);
		a.Verify_BulkUpdate_MenuItem_Update_Page(driver);
		a.Verify_BulkUpdate_Page(driver);
	}
	
	@Test(priority = 15,enabled = true)
	public void Product_Items_AddEditDelete_DisplayGroups() throws Exception
	{
		Product_Items_AddEditDelete_DisplayGroups a=new Product_Items_AddEditDelete_DisplayGroups();
		a.Open_DisplayGroups_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_DisplayGroups(driver);
		a.Edit_and_Close_Cancel_DisplayGroups(driver);
		a.Edit_and_Update_DisplayGroups_DaysOfWeek(driver);
		a.Edit_and_Update_DisplayGroups_DaysOfMonth_AtoZ_Sorting(driver);
		a.Edit_and_Update_DisplayGroups_DateRange_ZtoA_Sorting(driver);
		a.Edit_and_Update_DisplayGroups_Specific_Date_Custom_Sorting(driver);
		a.Edit_Delete_MenuItems_and_Update_DisplayGroups_DateRangeWithTime(driver);
		a.Delete_and_Active_Inactive_DisplayGroups(driver);
		a.Create_DuplicateDisplayGroup(driver);
			
	}
	
	@Test(priority = 16,enabled = true)
	public void Product_Items_AddEditDelete_Item_Based_Discount() throws Exception
	{
		Product_Items_AddEditDelete_Item_Based_Discount a=new Product_Items_AddEditDelete_Item_Based_Discount();
		a.Open_Item_Based_Discount_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_Item_Based_Discount(driver);
		a.Edit_and_Close_Cancel_Item_Based_Discount(driver);
		a.Edit_and_Update_Item_Based_Discount_Percentage(driver);
		a.Edit_and_Update_SubCategory_Item_Based_Discount(driver);
		a.Edit_and_Update_MenuItem_Item_Based_Discount(driver);
		a.Edit_and_Update_Item_Based_Discount_DaysOfWeek(driver);
		a.Edit_and_Update_Item_Based_Discount_DaysOfMonth(driver);
		a.Edit_and_Update_Item_Based_Discount_DateRange(driver);
		a.Edit_and_Update_Item_Based_Discount_Specific_Date(driver);
		a.Edit_and_Update_Item_Based_Discount_DateRangeWithTime(driver);
		a.Delete_and_Active_Inactive_Item_Based_Discount(driver);
		a.Create_Duplicate_Item_Based_Discount(driver);
	
			
	}
	
	@Test(priority = 17,enabled = true)
	public void Product_Items_AddEditDelete_Check_Based_Discount() throws Exception
	{
		Product_Items_AddEditDelete_Check_Based_Discount a=new Product_Items_AddEditDelete_Check_Based_Discount();
		a.Open_Check_Based_Discount_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_Check_Based_Discount(driver);
		a.Edit_and_Close_Cancel_Check_Based_Discount(driver);
		a.Edit_and_Update_Check_Based_DiscountType_Comp(driver);
		a.Edit_and_Update_SubCategory_Check_Based_Discount(driver);
		a.Edit_and_Update_MenuItem_Check_Based_Discount(driver);
		a.Edit_and_Update_Check_Based_Discount_DaysOfWeek(driver);
		a.Edit_and_Update_Check_Based_Discount_DaysOfMonth(driver);
		a.Edit_and_Update_Check_Based_Discount_DateRange(driver);
		a.Edit_and_Update_Check_Based_Discount_Specific_Date(driver);
		a.Edit_and_Update_Check_Based_Discount_DateRangeWithTime(driver);
		a.Delete_and_Active_Inactive_Check_Based_Discount(driver);
		a.Create_Duplicate_Check_Based_Discount(driver);
		
	}
	
	

	@Test(priority = 18,enabled = true)
	public void Product_Items_AddEditDelete_Open_Item_Discount() throws Exception
	{
		
		Product_Items_AddEditDelete_Open_Item_Discount a=new Product_Items_AddEditDelete_Open_Item_Discount();
		a.Open_Open_Item_Discount_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_Open_Item_DiscountType_Promo(driver);
		a.Edit_and_Close_Cancel_Open_Item_Discount(driver);
		a.Edit_and_Update_Open_Item_DiscountType_Comp(driver);
		a.Edit_and_Update_Open_Item_DiscountType_Donation(driver);
		a.Edit_and_Update_MenuItem_Open_Item_Discount(driver);
		a.Delete_and_Active_Inactive_Open_Item_Discount(driver);
		
	}
	

	@Test(priority = 19,enabled = true)
	public void Product_Items_AddEditDelete_Open_Check_Discount() throws Exception
	{
		Product_Items_AddEditDelete_Open_Check_Discount a=new Product_Items_AddEditDelete_Open_Check_Discount();
		a.Open_Open_Check_Discount_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_Open_Check_DiscountType_Promo(driver);
		a.Edit_and_Close_Cancel_Open_Check_Discount(driver);
		a.Edit_and_Update_Open_Check_DiscountType_Comp(driver);
		a.Edit_and_Update_Open_Check_DiscountType_Donation(driver);
		a.Edit_and_Update_MenuItem_Open_Check_Discount(driver);
		a.Delete_and_Active_Inactive_Open_Check_Discount(driver);
		
	}
	

	@Test(priority = 20,enabled = true)
	public void Product_Items_AddEditDelete_MixAndMatch_Discount() throws Exception
	{
		Product_Items_AddEditDelete_MixAndMatch_Discount a=new Product_Items_AddEditDelete_MixAndMatch_Discount();
		a.Open_Mix_and_Match_Discount_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_Mix_and_Match_Discount(driver);
		a.Edit_and_Close_Cancel_Mix_and_Match_Discount(driver);
		a.Edit_and_Update_Mix_and_Match_DiscountType_Comp(driver);
		a.Edit_and_Update_Mix_and_Match_Discount_DiscountType_Donation(driver);
		a.Edit_and_Update_Mix_and_Match_Discount_DiscountType_Loyalty(driver);
		a.Edit_and_Update_Mix_and_Match_Discount_DaysOfWeek(driver);
		a.Edit_and_Update_Mix_and_Match_Discount_DaysOfMonth(driver);
		a.Edit_and_Update_Mix_and_Match_Discount_DateRange(driver);
		a.Edit_and_Update_Mix_and_Match_Discount_Specific_Date(driver);
		a.Edit_and_Update_Mix_and_Match_Discount_DateRangeWithTime(driver);
		a.Delete_and_Active_Inactive_Mix_and_Match_Discount(driver);
		a.Create_Duplicate_Mix_and_Match_Discount(driver);
		
	}
	
	
	@Test(priority = 21,enabled = true)
	public void Product_Items_AddEditDelete_Upcharges() throws Exception
	{
		Product_Items_AddEditDelete_Upcharges a=new Product_Items_AddEditDelete_Upcharges();
		a.Open_Upcharges_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_Upcharges(driver);
		a.Edit_and_Close_Cancel_Upcharges(driver);
		a.Edit_and_Update_Upcharges_Percentage(driver);
		a.Edit_and_Update_SubCategory_Upcharges(driver);
		a.Edit_and_Update_MenuItem_Upcharges(driver);
		a.Edit_and_Update_Upcharges_DaysOfWeek(driver);
		a.Edit_and_Update_Upcharges_DaysOfMonth(driver);
		a.Edit_and_Update_Upcharges_DateRange(driver);
		a.Edit_and_Update_Upcharges_Specific_Date(driver);
		a.Edit_and_Update_Upcharges_DateRangeWithTime(driver);
		a.Delete_and_Active_Inactive_Upcharges(driver);
		a.Create_DuplicateUpcharge(driver);
			
	}
	
	
	@Test(priority = 22,enabled = true)
	public void Product_Items_Sort_Menu_Config() throws Exception
	{
		Product_Items_Sort_Menu_Config a=new Product_Items_Sort_Menu_Config();
		a.Open_Sort_Menu_Config_Page(driver);
		a.Sort_Categories (driver);
		a.Category_Navigating(driver);
		a.Sort_MenuItem(driver);
			
	}
	
	
	
	@Test(priority = 23,enabled = true)
	public void Product_Items_AddEditDelete_Gratuities() throws Exception
	{
		Product_Items_AddEditDelete_Gratuities a=new Product_Items_AddEditDelete_Gratuities();
		a.Open_Gratuity_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_Gratuity(driver);
		a.Edit_and_Close_Cancel_Gratuity(driver); 
		a.Edit_and_Update_Gratuity(driver);
		a.Delete_and_Active_Inactive_Gratuity(driver);
		a.Create_DuplicateTareGroup(driver);
			
	}
	
	@Test(priority = 24,enabled = true)
	public void Product_Items_AddEditDelete_GiftCards() throws Exception
	{
		Product_Items_AddEditDelete_GiftCards a=new Product_Items_AddEditDelete_GiftCards();
		a.Open_GiftCards_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_GiftCards(driver);
		a.Edit_and_Close_Cancel_GiftCards(driver);
		a.Edit_and_Update_GiftCards(driver);
		a.Recharge_GiftCards(driver);
		a.Delete_and_Active_Inactive_GiftCards(driver);
		a.Create_DuplicateGiftCard(driver);
			
	}
	
	@Test(priority = 25,enabled = true)
	public void Product_Items_Cut_And_Modify() throws Exception
	{
		Product_Items_Cut_And_Modify a=new Product_Items_Cut_And_Modify();
		a.Open_Cut_And_Modify_Page(driver);
		a.Clear_CutAndModify(driver);
		a.Edit_CutAndModify(driver);
			
	}
	
	@Test(priority = 26,enabled = true)
	public void Product_Items_AddEditDelete_TareGroup() throws Exception
	{
		Product_Items_AddEditDelete_TareGroup a=new Product_Items_AddEditDelete_TareGroup();
		a.Open_TareGroups_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_TareGroups(driver);
		a.Edit_and_Close_Cancel_TareGroups(driver);
		a.Edit_and_Update_TareGroups(driver);
		a.Delete_and_Active_Inactive_TareGroups(driver);
		a.Create_DuplicateTareGroup(driver);
			
	}
	
	
	@Test(priority = 27,enabled = true)
	public void Product_Items_AddEditDelete_Reasons() throws Exception
	{
		Product_Items_AddEditDelete_Reasons a=new Product_Items_AddEditDelete_Reasons();
		a.Open_Reasons_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_Reasons(driver);
		a.Edit_and_Close_Cancel_Reasons(driver);
		a.Edit_and_Update_Reasons(driver);
		a.Delete_and_Active_Inactive_Reasons(driver);
		a.Create_DuplicateReason(driver);
			
	}
	
	@Test(priority = 28,enabled = true)
	public void Product_Items_AddEditDelete_Item_Service_Charge() throws Exception
	{
		Product_Items_AddEditDelete_Item_Service_Charge a=new Product_Items_AddEditDelete_Item_Service_Charge();
		a.Open_Item_Service_Charge_Page(driver);
		a.RefreshAndPaginination(driver);
		a.Add_Item_Service_Charge(driver);
		a.Edit_and_Close_Cancel_Item_Service_Charge(driver);
		a.Edit_and_Update_Item_Service_Charge(driver);
		a.Delete_and_Active_Inactive_Item_Service_Charge(driver);
		a.Create_Duplicate_Item_Service_Charge(driver);
			
	}
	
	
}
