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

import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AllClassCalling_Inventory
{

	
	public WebDriver driver;
	

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Retesting Suite for Inventory & Inventory Reports");

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
//			System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
//			//Open the Chrome window
//			driver = new ChromeDriver();

			System.setProperty("webdriver.chrome.driver","./Automation Driver/chromedriver.exe");
			//Open the Chrome window
			driver = new ChromeDriver();
			
//			ChromeOptions chrOpt=new ChromeOptions();
//			chrOpt.addArguments("--remote-allow-origins=*");
//			WebDriverManager.chromedriver().setup();
//			driver=new ChromeDriver(chrOpt);
			
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
		public void Inventory_Category() throws Exception
		{
			Inventory_Category a=new Inventory_Category();
			a.Open_Category_Page(driver);
	     	//a.RefreshAndPaginination_ColumnFilteration(driver);
			a.Add_New_Category_with_Enable_tax_intergration(driver);
			a.Add_New_Category_with_New_Inventory_tax_intergration(driver);
			a.Edit_Newly_Created_Category_cancel_Close(driver);
			a.Edit_Newly_Created_Category(driver);
			//a.Delete_and_Active_Inactive_Category(driver);
			a.Create_Duplicate_Category(driver);
			a.Intergration_Category_Mapped_with_SubCategory(driver);
			
					
		}
		
		
		@Test(priority = 4,enabled = true)
		public void Inventory_Sub_Category() throws Exception
		{
			Inventory_Sub_Category a=new Inventory_Sub_Category();
			a.Open_SubCategory_Page(driver);
			a.RefreshAndPaginination(driver);
			a.VerifyTheSubCategory(driver);
			a.CreateTheSubCategory(driver);
			a.editTheSubCategory(driver);
			a.deleteTheSubCategory_CAncel(driver);
			a.deleteTheSubCategory(driver);
			a.verifyTheActiveStatus(driver);
			a.verifyTheSubCAtegoryAvailablity(driver);
		}
		
		@Test(priority = 5,enabled = true)
		public void Inventory_Storage_Locations() throws Exception
		{
			Inventory_Storage_Locations a=new Inventory_Storage_Locations();
			a.Open_Inventory_Storage_Locations_Page(driver);
			a.RefreshAndPaginination(driver);
			a.Add_Inventory_Storage_Location(driver);
			a.Edit_and_Close_Cancel_Storage_Location(driver);
			a.Edit_and_Update_Storage_Location(driver);
			a.Delete_and_Active_Inactive_Storage_Location(driver);
			a.Create_Duplicate_Storage_Location(driver);
			a.Verify_Added_Storage_Location_in_InvetoryItem_Integration(driver);
			a.Verify_Added_Storage_Location_in_SubRecipe_Integration(driver);
		}
		
		@Test(priority = 6,enabled = true)
		public void Inventory_Vendors() throws Exception
		{
			Inventory_Vendors a=new Inventory_Vendors();
			a.Open_Vendor_Page(driver);
			a.RefreshAndPaginination_ColumnFilteration(driver);
			a.Add_New_Vendor(driver);
			a.Edit_and_Close_Cancel_Vendor(driver);
			a.Edit_and_Update_Vendor(driver);
			a.Delete_and_Active_Inactive_Vendor(driver);
			a.Create_DuplicateCourse(driver);
			a.Verify_Vendor_in_PurchaseOrder_Integration(driver);
		}
		
		@Test(priority = 7,enabled = true)
		public void Inventory_InHouseUnits() throws Exception
		{
			Inventory_InHouseUnits a=new Inventory_InHouseUnits();
			a.Open_InHouseUnits_Page(driver);
			a.RefreshAndPaginination_Column_Filteration(driver);
			a.Sorting_Name(driver);
			a.Add_New_InHouse_Unit(driver);
			a.Add_New_InHouse_Unit_SpecialChar(driver);
			a.Edit_Cancel_Close_InHouseUnit(driver);
			a.Edit_And_Update_InHouseUnit(driver);
			a.InActive_And_activate_InHouseUnit(driver);
			a.Creating_Duplicate_InHouseUnit(driver);
		}
		
		@Test(priority = 8,enabled = true)
		public void Inventory_Item() throws Exception
		{
			Inventory_Item a=new Inventory_Item();
			a.Open_InventoryItems_Page(driver);
	     	a.RefreshAndPaginination_ColumnFilteration(driver);
			a.Add_New_InventoryItem_Category(driver);
			a.Add_New_InventoryItem_SubCategory(driver);
		    a.Edit_Newly_Created_Inventory_Create_newStorage(driver);
		    a.Delete_and_Active_Inactive_Category(driver);
		    a.Create_Duplicate_Category(driver);
		    a.Searching_Inventory_Item_Search_box(driver);		   
		    a.RetailItem(driver);
		    a.Intergration_Category_Mapped_with_Purchase_Order(driver);
			a.Intergration_Category_Mapped_with_Product_Item(driver);			 
			a.Intergration_Category_Mapped_with_Subrecipe(driver);
			a.Intergration_Category_Mapped_with_Purchase_Order(driver);
			a.Intergration_InventoryItem_Mapped_with_CompareInventory(driver);
		}
		
		@Test(priority = 9,enabled = true)
		public void Inventory_Sub_Recipe() throws Exception
		{
			Inventory_Sub_Recipe a=new Inventory_Sub_Recipe();
			a.Open_Sub_Recipe_Page(driver);
//			a.RefreshAndPaginination_ColumnFilteration(driver);
			a.Add_Sub_Recipe_By_Inventory_Item(driver);
			a.Edit_and_Close_Cancel_Sub_Recipe(driver);
			a.Edit_and_Update_Sub_Recipe_by_Adding_SubRecipe(driver);
			a.Edit_and_Update_Sub_Recipe_by_Adding_Manual_Entry(driver);
			a.Edit_and_Update_Sub_Recipe_by_Adding_Inventory_and_SubRecipe(driver);
			a.Edit_and_Update_Sub_Recipe_by_Adding_Inventory_and_Manual_Entry(driver);
			a.Edit_and_Update_Sub_Recipe_by_Adding_SubRecipe_and_Manual_Entry(driver);
			a.Edit_and_Update_Sub_Recipe_by_Adding_InventoryItem_SubRecipe_and_Manual_Entry(driver);
			a.Delete_and_Active_Inactive_Sub_Recipe(driver);
			a.Create_Duplicate_Sub_Recipe(driver);
			a.Verify_Integration_Inv_SubRecipe_In_Adjust_Inventory_and_Adjust_Inventory_Report(driver);

		}
		
		@Test(priority = 10,enabled = true)
		public void Inventory_InventoryModifiers() throws Exception
		{
			Inventory_InventoryModifiers a=new Inventory_InventoryModifiers();
			a.Open_PurchaseOrder_Page(driver);
			a.RefreshAndPaginination(driver);
			a.VerifyTheLinkedItem(driver);
			a.LinkTheModifier(driver);
		}
		
		@Test(priority = 11,enabled = true)
		public void Inventory_Menu_Items() throws Exception
		{
			Inventory_Menu_Items a=new Inventory_Menu_Items();
			a.Open_Inventory_Menu_Item_Page(driver);
			a.RefreshAndPaginination_ColumnFilteration(driver);
			a.Verify_Unlinked_Menu_To_Link(driver);
			a.Verify_Linked_Menu_To_UnLink(driver);
			a.Edit_Linked_Type_of_Menu_Item_Inv_Item(driver);
			a.Edit_Linked_Type_of_Menu_Item_SubRecipe(driver);
			a.Edit_Linked_Type_of_Menu_Item_ManualEntry(driver);
			a.Edit_Linked_Type_of_Menu_Item_InvItem_SubRecipe(driver);
			a.Edit_Linked_Type_of_Menu_Item_InvItem_Manual_Entry(driver);
			a.Edit_Linked_Type_of_Menu_Item_SubRecipe_Manual_Entry(driver);
			a.Edit_Linked_Type_of_Menu_Item_InventoryItem_SubRecipe_Manual_Entry(driver);
			a.Verify_Active_Inactive_Inentory_Menu_Item(driver);
		}
		
		@Test(priority = 12,enabled = true)
		public void Inventory_Adjust_Inventory_Reasons() throws Exception
		{
			Inventory_Adjust_Inventory_Reasons a=new Inventory_Adjust_Inventory_Reasons();
			a.Open_Adjust_Inventory_Reason_Page(driver);
			a.RefreshAndPaginination_ColumnFilteration(driver);
			a.Add_Adjust_Inventory_Reason(driver);
			a.Edit_and_Close_Cancel_Adjust_Inventory_Reason(driver);
			a.Edit_and_Update_Adjust_Inventory_Reason_Type_As_Increase(driver);
			a.Edit_and_Update_Adjust_Inventory_Reason_Type_As_Decrease(driver);
			a.Edit_and_Update_Adjust_Inventory_Reason_Type_As_Adjustment(driver);
			a.Delete_and_Active_Inactive_Adjust_Inventory_Reason(driver);
			a.Create_Duplicate_Adjust_Inventory_Reason(driver);
			a.Verify_Integration_Adj_Inv_Reason_In_Adjust_Inventory_and_Adjust_Inventory_Report(driver);

		}
		
		@Test(priority = 13,enabled = true)
		public void Inventory_Adjust_Inventory() throws Exception
		{
			Inventory_Adjust_Inventory a=new Inventory_Adjust_Inventory();
			a.Open_PurchaseOrder_Page(driver);
			a.RefreshAndPaginination(driver);
			a.InventoryItem_Adjustment(driver);
		}
		
		@Test(priority = 14,enabled = true)
		public void Inventory_Low_Stocks() throws Exception
		{
			Inventory_Low_Stocks a=new Inventory_Low_Stocks();
			a.Open_LowStocks_Page(driver);
			a.VerifyTheLowStocks(driver);
			a.VerifyInventoryLowStocks(driver);
			a.VerifySubRecipeLowStocks(driver);
		}
		
		@Test(priority = 15,enabled = true)
		public void Inventory_Prepare_Menu_Item() throws Exception
		{
			Inventory_Prepare_Menu_Item a=new Inventory_Prepare_Menu_Item();
			a.Open_Prepare_Menu_Item_Page(driver);
			a.RefreshAndPaginination_ColumnFilteration(driver);
			a.Prepare_MenuItem(driver);
			a.Verify_Prepared_MenuItem_In_MenuItem_InventoryItem_SubRecipe(driver);
			a.Verify_Prepared_MenuItem_In_Compare_Inventory_Report(driver);
			a.Verify_Prepared_MenuItem_In_Production_Log(driver);
		}
		
		@Test(priority = 16,enabled = true)
		public void Inventory_Prepare_SubRecipe() throws Exception
		{
			Inventory_Prepare_SubRecipe a=new Inventory_Prepare_SubRecipe();
			a.Open_Transfer_Request_Page(driver);
			a.RefreshAndPaginination_ColumnFilteration(driver);
			a.Prepare_SubRecipe(driver);
			a.Verify_Prepared_SubRecipe_In_Compare_Inventory_Report(driver);
			
		}
		
		@Test(priority = 17,enabled = true)
		public void Inventory_SyncInventory() throws Exception
		{
			Inventory_SyncInventory a=new Inventory_SyncInventory();
			a.Open_PurchaseOrder_Page(driver);
		}
		
		@Test(priority = 18,enabled = true)
		public void Inventory_Purchase_Template() throws Exception
		{
			Inventory_Purchase_Template a=new Inventory_Purchase_Template();
			a.Open_PurchaseOrder_Page(driver);
			a.RefreshAndPaginination(driver);
			a.VerifyThePurchaseTemplate(driver);
			a.CreateThePurchaseTemplate(driver);
			a.editThePurchaseTemplate(driver);
			a.deleteThePurchaseTemplate_CAncel(driver);
			a.deleteThePurchaseTemplate(driver);
			a.verifyTheActiveStatus(driver);
		}
		
		@Test(priority = 19,enabled = true)
		public void Inventory_Purchase_Orders() throws Exception
		{
			Inventory_Purchase_Orders a=new Inventory_Purchase_Orders();
			a.Open_PurchaseOrder_Page(driver);
			a.RefreshAndPaginination(driver);
			a.AddPartialOrder(driver);
			a.verifyTheStatus_And_Options(driver);
		}
		
		@Test(priority = 20,enabled = true)
		public void Inventory_Purchase_Invoice() throws Exception
		{
			Inventory_Purchase_Invoice a=new Inventory_Purchase_Invoice();
			a.Open_Transfer_Request_Page(driver);
			a.RefreshAndPaginination_ColumnFilteration(driver);
			a.Verify_Purchase_Invoice_History(driver);
			a.Verify_Purchase_Invoice_by_PurchaseOrder_Integration(driver);
		}
		
		@Test(priority = 21,enabled = true)
		public void Inventory_Purchases_Received_Items_Received_Logs() throws Exception
		{
			Inventory_Purchases_Received_Items_Received_Logs a=new Inventory_Purchases_Received_Items_Received_Logs();
			a.Open_Received_Items_Page(driver);
			a.RefreshAndPaginination_ColumnFilteration(driver);
			a.Inventory_Purchase_Receive_New_Item(driver);
			a.Inventory_Purchase_Receive_Inventory_Item_in_PurchaseOrder(driver);
			a.Inventory_Purchase_Receive_SubRecipe_By_Prepare_SubRecipe(driver);
			a.Inventory_Purchase_Verify_Receive_Inventory_Item_in_Received_Logs(driver);
			a.Inventory_Purchase_Received_Logs_verify_All_All(driver);
			a.Inventory_Purchase_Received_Logs_verify_All_NotStarted(driver);
			a.Inventory_Purchase_Received_Logs_verify_All_Progress(driver);
			a.Inventory_Purchase_Received_Logs_verify_All_Finished(driver);
			a.Inventory_Purchase_Received_Logs_verify_All_Not_Finished(driver);
			a.Inventory_Purchase_Received_Logs_verify_InventoryItem_All(driver);
			a.Inventory_Purchase_Received_Logs_verify_InventoryItem_Not_Started(driver);
			a.Inventory_Purchase_Received_Logs_verify_InventoryItem_Progress(driver);
			a.Inventory_Purchase_Received_Logs_verify_InventoryItem_Finished(driver);
			a.Inventory_Purchase_Received_Logs_verify_InventoryItem_Not_Finished(driver);
			a.Inventory_Purchase_Received_Logs_verify_RetailItem_All(driver);
			a.Inventory_Purchase_Received_Logs_verify_RetailItem_Not_Started(driver);
			a.Inventory_Purchase_Received_Logs_verify_RetailItem_Progress(driver);
			a.Inventory_Purchase_Received_Logs_verify_RetailItem_Finished(driver);
			a.Inventory_Purchase_Received_Logs_verify_RetailItem_Not_Finished(driver);
			a.Inventory_Purchase_Received_Logs_verify_SubRecipe_All(driver);
			a.Inventory_Purchase_Received_Logs_verify_SubRecipe_Not_Started(driver);
			a.Inventory_Purchase_Received_Logs_verify_SubRecipe_Progress(driver);
			a.Inventory_Purchase_Received_Logs_verify_SubRecipe_Finished(driver);
			a.Inventory_Purchase_Received_Logs_verify_SubRecipe_Not_Finished(driver);
		}
		
		@Test(priority = 22,enabled = true)
		public void Inventory_ExpiredPurchaseItem() throws Exception
		{
			Inventory_ExpiredPurchaseItem a=new Inventory_ExpiredPurchaseItem();
			a.Open_Sub_Recipe_Page(driver);
			a.RefreshAndPaginination_ColumnFilteration(driver);
			a.Verify_Detected_Purchase(driver);
		}
		
		
		@Test(priority = 23,enabled = true)
		public void Inventory_Transfer() throws Exception
		{
			Inventory_Transfer a=new Inventory_Transfer();
			a.Open_Transfer_Request_Page(driver);
			a.RefreshAndPaginination_ColumnFilteration(driver);
			a.Create_Transfer_Request(driver);
			a.Cancel_Transfer_Request(driver);
			a.Verify_Transfer_Request_Requested_Store(driver);
			a.Verify_Transferred_Items_in_Request_Status(driver);
			a.Verify_Transferred_Items_in_Ttansfer_Logs_Received_Today(driver);
			a.Verify_Transferred_Items_in_Ttansfer_Logs_Transferred_Today(driver);
			a.Verify_Transferred_Items_in_Ttansfer_Logs_Received_Yesterday(driver);
			a.Verify_Transferred_Items_in_Ttansfer_Logs_Received_Last_N_Days(driver);
			a.Verify_Transferred_Items_in_Ttansfer_Logs_Received_This_week(driver);
			a.Verify_Transferred_Items_in_Ttansfer_Logs_Received_Last_week(driver);
			a.Verify_Transferred_Items_in_Ttansfer_Logs_Received_Last_7_days(driver);
			a.Verify_Transferred_Items_in_Ttansfer_Logs_Received_This_month(driver);
			a.Verify_Transferred_Items_in_Ttansfer_Logs_Received_Last_month(driver);
			a.Verify_Transferred_Items_in_Ttansfer_Logs_Received_Last_30_days(driver);
			a.Verify_Transferred_Items_in_Ttansfer_Logs_Received_Specific_Date(driver);
			a.Verify_Transferred_Items_in_Ttansfer_Logs_Received_Date_Range(driver);
		}
		
		@Test(priority = 26,enabled = true)
		public void Inventory_Reports_Master_Stock_Report() throws Exception
		{
			Inventory_Reports_Master_Stock_Report a=new Inventory_Reports_Master_Stock_Report();
			a.Open_Master_Stock_Report_Page(driver);
			a.RefreshAndPaginination(driver);
			a.Master_Stock_Report_Today(driver);
			a.Master_Stock_Report_Yesterday(driver);
			a.Master_Stock_Report_Last_N_Days(driver);
			a.Master_Stock_Report_This_Week(driver);
			a.Master_Stock_Report_Last_Week(driver);
			a.Master_Stock_Report_Last_7_Days(driver);
			a.Master_Stock_Report_This_Month(driver);
			a.Master_Stock_Report_Last_Month(driver);
			a.Master_Stock_Report_Last_30_Days(driver);
			a.Master_Stock_Report_Specific_Date(driver);
			a.Master_Stock_Report_Date_Range(driver);
		}
		
		@Test(priority = 27,enabled = true)
		public void Inventory_Reports_Purchase_Item() throws Exception
		{
			Inventory_Reports_Purchase_Item a=new Inventory_Reports_Purchase_Item();
			a.Open_Inventory_Reports_Purchase_Item_Page(driver);
			a.RefreshAndPaginination(driver);
			a.Inventory_Reports_Purchase_Item_For_All_Verify_Purchase_Item_Search(driver);
			a.Inventory_Reports_Verify_Purchase_Item_For_Inventory_Item(driver);
			a.Inventory_Reports_Verify_Purchase_Item_For_Retail_Item(driver);
			a.Inventory_Reports_Verify_Purchase_Item_For_SubREcipe(driver);
			a.Inventory_Reports_Purchase_Item_For_All_Today(driver);
			a.Inventory_Reports_Purchase_Item_For_All_Yesterday(driver);
			a.Inventory_Reports_Purchase_Item_For_All_Last_N_Days(driver);
			a.Inventory_Reports_Purchase_Item_For_All_This_Week(driver);
			a.Inventory_Reports_Purchase_Item_For_All_Last_Week(driver);
			a.Inventory_Reports_Purchase_Item_For_All_Last_7_Days(driver);
			a.Inventory_Reports_Purchase_Item_For_All_This_Month(driver);
			a.Inventory_Reports_Purchase_Item_For_All_Last_Month(driver);
			a.Inventory_Reports_Purchase_Item_For_All_Last_30_Days(driver);
			a.Inventory_Reports_Purchase_Item_For_All_Specific_Date(driver);
			a.Inventory_Reports_Purchase_Item_For_All_Date_Range(driver);
		}
		
		@Test(priority = 28,enabled = true)
		public void Inventory_Reports_Consumption_Log() throws Exception
		{
			Inventory_Reports_Consumption_Log a=new Inventory_Reports_Consumption_Log();
			a.Open_InventoryReport_Consumption_LogPage(driver);
			a.RefreshAndPaginination_ColumnFilteration(driver);
			a.ConsumptionLog_Type_As_ALL_Consuption_Type_AS_System_Date_Range_TimePeriod_Apply(driver);
			a.ConsumptionLog_Type_As_ALL_Consuption_Type_AS_Manual_Date_Range_TimePeriod_Apply(driver);				
			a.ConsumptionLog_Type_As_Inventory_Consuption_Type_AS_ALL_Date_Range_TimePeriod_Apply(driver);		
			a.ConsumptionLog_Type_As_Inventory_Consuption_Type_AS_Category_Date_Range_TimePeriod_Apply(driver);
			a.ConsumptionLog_Type_As_Inventory_Consuption_Type_AS_SubCategory_Date_Range_TimePeriod_Apply(driver);
			a.ConsumptionLog_Type_As_Retail_Consuption_Type_AS_ALL_Date_Range_TimePeriod_Apply(driver);			
			a.ConsumptionLog_Type_As_Retail_Consuption_Type_AS_Category_Date_Range_TimePeriod_Apply(driver);
			a.ConsumptionLog_Type_As_Retail_Consuption_Type_AS_SubCategory_Date_Range_TimePeriod_Apply(driver);			
			a.ConsumptionLog_Type_As_SubRecipe_Consuption_Type_AS_AnySubRecipe_Date_Range_TimePeriod_Apply(driver);
			a.ConsumptionLog_Type_As_SubRecipe_Consuption_Type_AS_ALL_Date_Range_TimePeriod_Apply(driver);
			a.ConsumptionLog_Type_As_SubRecipe_Consuption_Type_AS_ALL_Date_Range_System_TimePeriod_Apply(driver);			
			a.ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_Today_TimePeriod_Apply(driver);
			a.ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_Yesterday_TimePeriod_Apply(driver);	
			a.ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_N_No_Days_TimePeriod_Apply(driver);
			a.ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_ThisWeek_TimePeriod_Apply(driver);
			a.ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_SpecificDate_TimePeriod_Apply(driver);		
			a.ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_ThisWeek_TimePeriod_Apply(driver);
			a.ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_LastWeek_TimePeriod_Apply(driver);
			a.ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_Last7Days_TimePeriod_Apply(driver);
			a.ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_thisMonth_TimePeriod_Apply(driver);
			a.ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_LastMonth_TimePeriod_Apply(driver);
			a.ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_Last30Days_TimePeriod_Apply(driver);
			a.ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_SpecificDate_TimePeriod_Apply(driver);
		
		}
		
		@Test(priority = 29,enabled = true)
		public void Inventory_Reports_Compare_Inventory_Report() throws Exception
		{
			Inventory_Reports_Compare_Inventory_Report a=new Inventory_Reports_Compare_Inventory_Report();
			a.Open_Compare_Inventory_Report_Page(driver);
			a.RefreshAndPaginination(driver);
			a.Compare_Inventory_Report_Today(driver);
			a.Compare_Inventory_Report_Yesterday(driver);
			a.Compare_Inventory_Report_Last_N_Days(driver);
			a.Compare_Inventory_Report_This_Week(driver);
			a.Compare_Inventory_Report_Last_Week(driver);
			a.Compare_Inventory_Report_Last_7_Days(driver);
			a.Compare_Inventory_Report_This_Month(driver);
			a.Compare_Inventory_Report_Last_Month(driver);
			a.Compare_Inventory_Report_Last_30_Days(driver);
			a.Compare_Inventory_Report_Specific_Date(driver);
			a.Compare_Inventory_Report_Date_Range(driver);
		}
		
		@Test(priority = 30,enabled = true)
		public void Inventory_Reports_Count_Sheet() throws Exception
		{
			Inventory_Reports_Count_Sheet a=new Inventory_Reports_Count_Sheet();
			a.Open_CountSheet_ReportPage(driver);
			a.RefreshAndPaginination(driver);
			a.Count_Sheet_Report_Select_Type_Storage_Location_All(driver);
			a.Count_Sheet_Report_Select_Type_All_Storage_Location(driver);
			a.Count_Sheet_Report_Type_Inventory_Item(driver);
			a.Count_Sheet_Report_Type_Inventory_Item_Category_Level_Category(driver);
			a.Count_Sheet_Report_Type_Inventory_Item_Category_Level_SubCategory(driver);
			a.Count_Sheet_Report_Type_Inventory_Item_Select_Category_And_InventoryItem(driver);
			a.Count_Sheet_Report_Type_Inventory_Item_Category_Level_SubCategory_Select_Category_SubCategory_InventoryItem(driver);
			a.Count_Sheet_Report_Type_Retail_Item(driver);
			a.Count_Sheet_Report_Type_Retail_Item_Category_Level_Category(driver);
			a.Count_Sheet_Report_Type_Retail_Item_Category_Level_SubCategory(driver);
			a.Count_Sheet_Report_Type_Retail_Item_Select_Category_And_RetailItem(driver);
			a.Count_Sheet_Report_Type_Retail_Item_Category_Level_SubCategory_Select_Category_SubCategory_RetailItem(driver);
			a.Count_Sheet_Report_Type_Sub_Recipe(driver);
			a.Count_Sheet_Report_Type_MenuItem(driver);
		}
		
		@Test(priority = 31,enabled = true)
		public void Inventory_Reports_COGS_Report() throws Exception
		{
			Inventory_Reports_COGS_Report a=new Inventory_Reports_COGS_Report();
			a.Open_Inventory_Cogs_report_Page(driver);
			a.Product_Item_MenuItem_Date_Range_TimePeriod_Apply(driver);
			a.Product_Item_RetailItem_Date_Range_TimePeriod_Apply(driver);
			a.Product_Item_Modifier_Date_Range_TimePeriod_Apply(driver);
			a.Product_Item_All_Apply(driver);
			a.Product_Item_All_Yesterday_Apply(driver);
			a.Product_Item_All_N_No_of_Days_Apply(driver);
			a.Product_Item_All_This_week_Apply(driver);
			a.Product_Item_All_Last_Week_TimePeriod_Apply(driver);
			a.Product_Item_All_Last_7_Days_TimePeriod_Apply(driver);
			a.Product_Item_All_This_Month_TimePeriod_Apply(driver);
			a.Product_Item_All_Last_Month_TimePeriod_Apply(driver);
			a.Product_Item_All_Last_30_Days_TimePeriod_Apply(driver);
			a.Product_Item_All_Specific_Date_TimePeriod_Apply(driver);
			a.Product_Item_All_Date_Range_TimePeriod_Apply(driver);
			a.Inventory_Category_Date_Range_TimePeriod_Apply(driver);
			a.Inventory_SubCategory_Date_Range_TimePeriod_Apply(driver);
			a.Inventory_All_Apply(driver);
			a.Inventory_All_Yesterday_Apply(driver);
			a.Inventory_All_N_No_of_Days_Apply(driver);
			a.Inventory_All_This_week_Apply(driver);
			a.Inventory_All_Last_Week_TimePeriod_Apply(driver);
			a.Inventory_All_Last_7_Days_TimePeriod_Apply(driver);
			a.Inventory_All_This_Month_TimePeriod_Apply(driver);
			a.Inventory_All_Specific_Date_TimePeriod_Apply(driver);
			a.Inventory_All_Date_Range_TimePeriod_Apply(driver);
		}
		
		@Test(priority = 32,enabled = true)
		public void Inventory_Reports_Adjust_Inventory() throws Exception
		{
			Inventory_Reports_Adjust_Inventory a=new Inventory_Reports_Adjust_Inventory();
			a.Open_Inventory_Reports_Adjust_Inventory_Page(driver);
			a.RefreshAndPaginination(driver);
			a.Inventory_Reports_Adjust_Inventory_For_All_Verify_Adjust_Inventory_Search(driver);
			a.Inventory_Reports_Verify_Adjust_Inventory_For_Inventory_Item(driver);
			a.Inventory_Reports_Verify_Adjust_Inventory_For_Retail_Item(driver);
			a.Inventory_Reports_Verify_Adjust_Inventory_For_SubREcipe(driver);
			a.Inventory_Reports_Adjust_Inventory_For_All_ReasonType_Adjsutment(driver);
			a.Inventory_Reports_Adjust_Inventory_For_All_ReasonType_Increase(driver);
			a.Inventory_Reports_Adjust_Inventory_For_All_ReasonType_Decrease(driver);
			a.Inventory_Reports_Adjust_Inventory_For_All_Today(driver);
			a.Inventory_Reports_Adjust_Inventory_For_All_Yesterday(driver);
			a.Inventory_Reports_Adjust_Inventory_For_All_Last_N_Days(driver);
			a.Inventory_Reports_Adjust_Inventory_For_All_This_Week(driver);
			a.Inventory_Reports_Adjust_Inventory_For_All_Last_Week(driver);
			a.Inventory_Reports_Adjust_Inventory_For_All_Last_7_Days(driver);
			a.Inventory_Reports_Adjust_Inventory_For_All_This_Month(driver);
			a.Inventory_Reports_Adjust_Inventory_For_All_Last_Month(driver);
			a.Inventory_Reports_Adjust_Inventory_For_All_Last_30_Days(driver);
			a.Inventory_Reports_Adjust_Inventory_For_All_Specific_Date(driver);
			a.Inventory_Reports_Adjust_Inventory_For_All_Date_Range(driver);
		}
			
		@Test(priority = 33,enabled = true)
		public void Inventory_Reports_Inventory_Item_History() throws Exception
		{
			Inventory_Reports_Inventory_Item_History a=new Inventory_Reports_Inventory_Item_History();
			a.Open_Inventory_Item_History_Report_Page(driver);
			a.RefreshAndPaginination(driver);
			a.Inventory_Item_History_Report_Today_InventoryItem(driver);
			a.Inventory_Item_History_Report_Yesterday_InventoryItem(driver);
			a.Inventory_Item_History_Report_Last_N_Days_InventoryItem(driver);
			a.Inventory_Item_History_Report_This_Week_InventoryItem(driver);
			a.Inventory_Item_History_Report_Last_Week_InventoryItem(driver);
			a.Inventory_Item_History_Report_Last_7_Days_InventoryItem(driver);
			a.Inventory_Item_History_Report_This_Month_InventoryItem(driver);
			a.Inventory_Item_History_Report_Last_Month_InventoryItem(driver);
			a.Inventory_Item_History_Report_Last_30_Days_InventoryItem(driver);
			a.Inventory_Item_History_Report_Specific_Date_InventoryItem(driver);
			a.Inventory_Item_History_Report_Date_Range_InventoryItem(driver);
			a.Inventory_Item_History_Report_Today_RetailItem(driver);
			a.Inventory_Item_History_Report_Yesterday_RetailItem(driver);
			a.Inventory_Item_History_Report_Last_N_Days_RetailItem(driver);
			a.Inventory_Item_History_Report_This_Week_RetailItem(driver);
			a.Inventory_Item_History_Report_Last_Week_RetailItem(driver);
			a.Inventory_Item_History_Report_Last_7_Days_RetailItem(driver);
			a.Inventory_Item_History_Report_This_Month_RetailItem(driver);
			a.Inventory_Item_History_Report_Last_Month_RetailItem(driver);
			a.Inventory_Item_History_Report_Last_30_Days_RetailItem(driver);
			a.Inventory_Item_History_Report_Specific_Date_RetailItem(driver);
			a.Inventory_Item_History_Report_Date_Range_RetailItem(driver);
		}
		
		@Test(priority = 34,enabled = true)
		public void Inventory_Reports_Matrix_Report() throws Exception
		{
			Inventory_Reports_Matrix_Report a=new Inventory_Reports_Matrix_Report();
			a.Open_Matrix_Report_Page(driver);
			a.RefreshAndPaginination(driver);
			a.Matrix_Report_Today(driver);
			a.Matrix_Report_Yesterday(driver);
			a.Matrix_Report_Last_N_Days(driver);
			a.Matrix_Report_This_Week(driver);
			a.Matrix_Report_Last_Week(driver);
			a.Matrix_Report_Last_7_Days(driver);
			a.Matrix_Report_This_Month(driver);
			a.Matrix_Report_Last_Month(driver);
			a.Matrix_Report_Last_30_Days(driver);
			a.Matrix_Report_Specific_Date(driver);
			a.Matrix_Report_Date_Range(driver);
		}
			
		@Test(priority = 35,enabled = true)
		public void Inventory_Reports_Wastage_Report() throws Exception
		{
			Inventory_Reports_Wastage_Report a=new Inventory_Reports_Wastage_Report();
			a.Open_Inventory_Reports_Wastage_Report_Page(driver);
			a.RefreshAndPaginination(driver);
			a.Inventory_Reports_Wastage_Report_For_All_Verify_Wastage_Report_Search(driver);
			a.Inventory_Reports_Wastage_Report_For_Sale_Void(driver);
			a.Inventory_Reports_Wastage_Report_For_Manual(driver);
			a.Inventory_Reports_Wastage_Report_For_Purchase_Expired(driver);
			a.Inventory_Reports_Wastage_Report_For_Item_Yield(driver);
			a.Inventory_Reports_Wastage_Report_For_All_Today(driver);
			a.Inventory_Reports_Wastage_Report_For_All_Yesterday(driver);
			a.Inventory_Reports_Wastage_Report_For_All_Last_N_Days(driver);
			a.Inventory_Reports_Wastage_Report_For_All_This_Week(driver);
			a.Inventory_Reports_Wastage_Report_For_All_Last_Week(driver);
			a.Inventory_Reports_Wastage_Report_For_All_Last_7_Days(driver);
			a.Inventory_Reports_Wastage_Report_For_All_This_Month(driver);
			a.Inventory_Reports_Wastage_Report_For_All_Last_Month(driver);
			a.Inventory_Reports_Wastage_Report_For_All_Last_30_Days(driver);
			a.Inventory_Reports_Wastage_Report_For_All_Specific_Date(driver);
			a.Inventory_Reports_Wastage_Report_For_All_Date_Range(driver);
		}
}
