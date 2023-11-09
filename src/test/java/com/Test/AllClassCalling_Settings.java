package com.Test;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.LoginPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AllClassCalling_Settings {
	public SelfHealingDriver driver;
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("BO Revamp Retesting Suite for Settings)");
	
	LoginPage lgpg; 
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
			String scnsht=((TakesScreenshot)driver.getDelegate()).getScreenshotAs(OutputType.BASE64);
			
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
	
	
	@Test(priority = 1)
	public void Login() throws Exception
	{
		
		Thread.sleep(2000);
//		//Call the chrome driver
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
//		//Open the Chrome window
//		driver = new ChromeDriver();
//		//Wait for 30 seconds
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		Thread.sleep(20000);
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
//		//Open the Chrome window
//		driver = new ChromeDriver();
		
		//Maximize the Chrome window
		driver.manage().window().maximize();
		Thread.sleep(1000);
		//Launch the URL
		driver.get(Utility.getProperty("appURL"));
		
		Thread.sleep(10000);
		a.Login(driver, test);
		
	}
		
	@Test(priority = 1000)
	public void Logout() throws Exception
	{		
		a.LogOut(driver, test);
	}
	
	@Test(priority=5)
	public void Start_Settings() throws InterruptedException
	{
		test.log(LogStatus.INFO, "-------********************   Settings(Starting)   ********************-------");
	}


	
	@Test(priority=319,enabled = true)
	public void Settings_Account_License() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Account_License(Starting)   ********************-------");
		
		Settings_Account_License als = new Settings_Account_License();
		Thread.sleep(30000);
		als.Open_AccountLicense_Page(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_Account_License(Ending)   ********************-------");
	}

	
	@Test(priority=14,enabled = true)
	public void Settings_Till_Setting() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Till_Setting(Starting)   ********************-------");

		Settings_Till_Settings als = new Settings_Till_Settings();
		Thread.sleep(30000);
		als.Open_TillSettings_Page(driver);
		als.verifyAutomaticGlobalTill(driver);
		als.verifyForceCashOutAtClockOut(driver);
		als.verifyRestrictPartialPayments(driver);
		als.verifyAddBankDeposit(driver);
		als.verifyTheDenominationsUI(driver);
		als.verifyTheDenominationsSearch(driver);
		als.verifyTheDenominationsPagination(driver);
		als.verifyTheDenominationsDeletion(driver);
		als.verifyTheCloseTill_UI(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_Till_Setting(Ending)   ********************-------");
	}
	

	
	@Test(priority=17,enabled = true)
	public void Settings_Scales() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Scales(Starting)   ********************-------");

		Settings_Scales als = new Settings_Scales();
		Thread.sleep(30000);
		als.Open_Scales_Page(driver);
		//als.verifyNewScaleBarCode(driver);
		als.verifyScale_Operatoins(driver);
		als.verifyScalesDeletingAndActivating(driver); 
		
		test.log(LogStatus.INFO, "-------********************   Settings_Scales(Ending)   ********************-------");

	}

	
	@Test(priority=20,enabled = true)
	public void Settings_CDS_Configuration() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_CDS_Configuration(Starting)   ********************-------");

		Settings_CDS_Configuration als = new Settings_CDS_Configuration();
		Thread.sleep(30000);
				Thread.sleep(10000);
				als.Open_CDS_Page(driver);
		//als.verifyTheThemeTaxt(driver);
				als.verifyShowAdvertisements_Yes(driver);
				als.verifyShowAdvertisements_No(driver);
				als.verifyCustomerProfile_Yes(driver);
				als.verifyCustomerProfile_No(driver);
				als.verifyDarkProfile(driver);
				als.verifyLightProfile(driver);
				als.verifyDiscountText_Valid(driver);
				als.verifyDiscountText_Valid1(driver);
				als.verifyDiscountText_inValid(driver);
				als.verifyGetNumberText_Valid(driver);
				als.verifyGetNumberText_Valid1(driver);
				als.verifyGetNumberText_inValid(driver);
				als.verifyLoyaltyText_Valid(driver);
				als.verifyLoyaltyText_Valid1(driver);
				als.verifyLoyaltyText_inValid(driver);   
				
				test.log(LogStatus.INFO, "-------********************   Settings_CDS_Configuration(Ending)   ********************-------");
	}
	
	@Test(priority=23,enabled = true)
	public void Settings_Store_Information() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Store_Information(Starting)   ********************-------");

		Settings_StoreInformation als = new Settings_StoreInformation();
		Thread.sleep(30000);
		Thread.sleep(10000);
		als.Open_SI_Page(driver);
		//als.verifyTheToolTip(driver);
		als.verifyTheGeneral(driver);  
		
		test.log(LogStatus.INFO, "-------********************   Settings_Store_Information(Ending)   ********************-------");
	}
	
	@Test(priority=26,enabled = true)
	public void Settings_Notifications() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Notifications(Starting)   ********************-------");

		Settings_Notifications als = new Settings_Notifications();
		Thread.sleep(30000);
		als.Open_Notifications_Page(driver);
		als.Clicking_No_Toggle(driver);
		/*
		 * als.Open_Notifications_Page(driver); Thread.sleep(1000);
		 * als.Clicking_Discount_Yes(driver); Thread.sleep(1000);
		 * als.Clikcing_Discount_Yes_Negative(driver); Thread.sleep(1000);
		 * als.Clciking_Discount_No(driver); Thread.sleep(1000);
		 * als.Clicking_Void_Yes(driver); Thread.sleep(1000);
		 * als.Clikcing_Void_Yes_Negative(driver); Thread.sleep(1000);
		 * als.Clicking_Void_No(driver); Thread.sleep(1000);
		 * als.Clicking_CashDrawer_Yes(driver); Thread.sleep(1000);
		 * als.Clikcing_CashDrawer_Yes_Negative(driver); Thread.sleep(1000);
		 * als.Clicking_CashDrawer_No(driver); Thread.sleep(1000);
		 * als.Clicking_TimeClock_Yes(driver); Thread.sleep(1000);
		 * als.Clikcing_TimeClock_Yes_Negative(driver); Thread.sleep(1000);
		 * als.Clicking_TimeClock_No(driver); Thread.sleep(1000);
		 * als.Clicking_KPI_Yes(driver); Thread.sleep(1000);
		 * als.Clikcing_KPI_Yes_Negative(driver); Thread.sleep(1000);
		 * als.Clicking_KPI_No(driver); Thread.sleep(1000);
		 * als.Clicking_EOD_Yes(driver); Thread.sleep(1000);
		 * als.Clikcing_EOD_Yes_Negative(driver); Thread.sleep(1000);
		 * als.Clicking_EOD_No(driver); Thread.sleep(1000);
		 * als.Clicking_WaitList_Yes(driver); Thread.sleep(1000);
		 * als.Clikcing_WaitList_Negative(driver); Thread.sleep(1000);
		 * als.Clicking_WaitList_No(driver); Thread.sleep(1000);
		 * als.Clicking_SRR_Yes(driver); Thread.sleep(1000);
		 * als.Clikcing_SRR_Negative(driver); Thread.sleep(1000);
		 * als.Clicking_SRR_No(driver); Thread.sleep(1000);
		 * als.Clicking_OPP_Yes(driver); Thread.sleep(1000);
		 * als.Clikcing_OPP_Negative(driver); als.Clicking_OPP_No(driver);
		 */ 
		
		test.log(LogStatus.INFO, "-------********************   Settings_Notifications(Ending)   ********************-------");
	}
	
	@Test(priority=29,enabled = true)
	public void Settings_Additional_Settings() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Additional_Settings(Starting)   ********************-------");

		Settings_Additional als = new Settings_Additional();
		Thread.sleep(30000);
		als.Navigating_Additional_Settings(driver);
		Thread.sleep(2000);
		als.Enable_And_Save_Additional_Settings(driver);
		Thread.sleep(2000);
		als.Disable_And_Save_Additional_Settings(driver);
		Thread.sleep(2000);
		als.Navigating_Back(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_Additional_Settings(Ending)   ********************-------");
	}

	
	@Test(priority=32,enabled = true)
	public void Settings_Batch_Settings() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Batch_Settings(Starting)   ********************-------");

		Settings_Batch als = new Settings_Batch();
		Thread.sleep(30000);
		als.Navigating_To_Settings_Batch_Settings_Page(driver);
		Thread.sleep(1000);
		als.Enable_Auto_Batch_YesToggle(driver);
		Thread.sleep(1000);
		als.Enable_Auto_Batch_NoToggle(driver);
		Thread.sleep(1000);
		als.Selecting_Auto_Batch_Submit_Device(driver);
		Thread.sleep(1000);
		als.Selecting_Batch_Payment_Device(driver);
		Thread.sleep(1000);
		als.Selecting_Rows_Per_Page(driver);
		Thread.sleep(1000);
		als.Handiling_Pagination(driver);
		Thread.sleep(1000);
		//Sorting_Columns(driver);
		Thread.sleep(1000);
		//Searching_delete_Node(driver);
	    Thread.sleep(1000);
	    als.Navigating_Back(driver);
	    
		test.log(LogStatus.INFO, "-------********************   Settings_Batch_Settings(Ending)   ********************-------");
	}
	
	@Test(priority=35,enabled = true)
	public void Settings_Business_Hours() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Batch_Settings(Starting)   ********************-------");

		Settings_Business_Hours als = new Settings_Business_Hours();
		Thread.sleep(30000);
		als.Open_Business_Hours_Page(driver);
		als.Changing_Store_Hours(driver);
		Thread.sleep(3000);
		als.Update_Store_Hours(driver);
		Thread.sleep(1000);
		als.Changing_Shift_Hours(driver);
		
		als.Adding_Deleting_Shift_Hours(driver);
		als.Update_Shift_Hours(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_Batch_Settings(Ending)   ********************-------");

	}
	
	@Test(priority=38,enabled = true)
	public void Settings_Email_Receipt_Template() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Email_Receipt_Template(Starting)   ********************-------");

		Settings_Email_Receipt_Template als = new Settings_Email_Receipt_Template();
		Thread.sleep(30000);
		als.Navigate_Email_Receipt(driver);
		Thread.sleep(2000);
		als.Store_Information_Operations_And_Save(driver);
		Thread.sleep(2000);
		als.Check_Details_Operations_And_Save(driver);
		Thread.sleep(2000);
		als.Order_Summary_Operations_And_Save(driver);
		Thread.sleep(2000);
		als.Additional_Details_Operations_And_Save(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_Email_Receipt_Template(Ending)   ********************-------");

	}
	
	@Test(priority=41,enabled = true)
	public void Settings_Integrations_WebHook() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Integrations_WebHook(Starting)   ********************-------");

		Settings_Integrations_WebHook als = new Settings_Integrations_WebHook();
		Thread.sleep(30000);
		als.Open_Settings_Web_Hooks_Page(driver);
		Thread.sleep(1000);
		als.Adding_Request_Header(driver);
		Thread.sleep(1000);
		als.Adding_CloseOrder_Web_Hooks(driver);
		Thread.sleep(1000);
		als.Clicking_Closeorder_WebHooks_Active(driver);
		Thread.sleep(1000);
		als.Adding_OpenOrder_Web_Hooks(driver);
		Thread.sleep(1000);
		als.Clicking_OpenOrder_WebHooks_Active(driver);
		Thread.sleep(1000);
		als.Adding_Updateorder_Web_Hooks(driver);
		Thread.sleep(1000);
		als.Clicking_Updateorder_WebHooks_Active(driver);
		Thread.sleep(1000);
		als.Clicking_Thirdorder_WebHooks_Active(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_Integrations_WebHook(Ending)   ********************-------");
	}
	
	@Test(priority=44,enabled = true)
	public void Settings_Report_MatrixReport() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Report_MatrixReport(Starting)   ********************-------");

		Settings_Report_MatrixReport als = new Settings_Report_MatrixReport();
		Thread.sleep(30000);
		als.Open_Settings_Matrix_Report_Page(driver);
		Thread.sleep(1000);
		als.Entering_Invalid_Amount_alpha(driver);
		Thread.sleep(1000);
		als.Entering_Invalid_Per_alpha(driver);
		Thread.sleep(1000);
		als.Entering_Invalid_Amount_Sym(driver);
		Thread.sleep(1000);
		als.Entering_Invalid_Per_Sym(driver);
		Thread.sleep(1000);
//		als.Entering_Invalid_Amount_Decimal(driver);
//		Thread.sleep(1000);
//		als.Entering_Invalid_Per_Decimal(driver);
//		Thread.sleep(1000);
		als.Entering_Invalid_AmountPer_Alphabet(driver);
		Thread.sleep(1000);
		als.Entering_Invalid_AmountPer_Symbol(driver);
		Thread.sleep(1000);
		als.Entering_Invalid_AmountPer(driver);
		Thread.sleep(1000);
		als.Entering_Invalid_AmountPercentage(driver);
		Thread.sleep(1000);
		als.Entering_Invalid_PerNum(driver);
		als.Entering_Amount_Percentage(driver);
		Thread.sleep(1000);
		als.Updating_Matrix_Report(driver);
		Thread.sleep(1000);
		als.Navigating_Back_Settings(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_Report_MatrixReport(Ending)   ********************-------");
	}

	
	@Test(priority=47,enabled = true)
	public void Settings_Revenue_Center() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Revenue_Center (Starting)   ********************-------");

		Settings_RevenueCenter als = new Settings_RevenueCenter();
		Thread.sleep(30000);
		als.Navigating_RevenueCenter(driver);
	    Thread.sleep(2000);
	    als.New_Revenue_WithoutName(driver);
	    Thread.sleep(2000);
	    als.New_Revenue_WithoutNode(driver);
	    Thread.sleep(2000);
	    als.Cancling_New_Revenue(driver);
	    Thread.sleep(2000);
	   // als.Entering_Name25(driver);
	    Thread.sleep(2000);
	    als.Entering_Duplicate_Name(driver);
	    Thread.sleep(2000);
	    //als.Entering_Specialchar_Name(driver);
	    als.Search_And_Delete(driver);
	    Thread.sleep(2000);
	    als.Creating_NewRevenue(driver);
	    Thread.sleep(3000);
	    als.Search_And_Edit(driver);
	    Thread.sleep(2000);
	    als.Handling_pagination(driver);
	    Thread.sleep(2000);
	    als.Sorting_Column(driver);
		test.log(LogStatus.INFO, "-------********************   Settings_Revenue_Center(Ending)   ********************-------");
	}
	
	@Test(priority=50,enabled = true)
	public void Settings_WaitList() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_WaitList (Starting)   ********************-------");

		Settings_WaitList als = new Settings_WaitList();
		Thread.sleep(30000);
		als.Navigate_Settings_WaitList_Page(driver);
		Thread.sleep(2000);
		als.without_Entering_Min_Max_Seat(driver);
		Thread.sleep(2000);
		als.Entering_Invalid_Time(driver);
		Thread.sleep(2000);
		als.Entering_More__MinTime(driver);
		Thread.sleep(2000);
		als.Entering_Existing_Seat(driver);
		Thread.sleep(2000);
		als.Cancling_New_WaitList(driver);
		Thread.sleep(2000);
		als.Searching_Wait_List(driver);
		Thread.sleep(2000);
		als.Deleting_Wait_List(driver);
		Thread.sleep(2000);
		als.Creating_New_Wait_List(driver);
		Thread.sleep(2000);
		als.Handling_Rows_and_Pagination(driver);
		Thread.sleep(2000);
		als.Sorting_Columns(driver);
		Thread.sleep(2000);
		als.Navigating_Reasons(driver);
		Thread.sleep(2000);
		als.Entering_Existing_Reason(driver);
		Thread.sleep(2000);
		//als.Capturing_Reason_Error(driver);
		als.Search_Delete_Reason(driver);
		Thread.sleep(2000);
		als.Creating_New_Reason(driver);
		Thread.sleep(2000);
		als.Handling_Rows_and_Pagination(driver);
		Thread.sleep(2000);
		als.Sorting_Reason_Column(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_WaitList(Ending)   ********************-------");
	}
	
	@Test(priority=53,enabled = true)	
	public void Settings_General_Settings() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_General_Settings(Starting)   ********************-------");
		
		Settings_General_Settings als = new Settings_General_Settings();
		Thread.sleep(30000);
		als.open_general_settings_page(driver);
		als.modifying_settings(driver);
		als.updating_settings(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_General_Settings(Ending)   ********************-------");
	}
	
	@Test(priority=56,enabled = true)	
	public void Settings_Store_Licenses() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Store_Licenses(Starting)   ********************-------");
		
		Settings_Store_Licenses als = new Settings_Store_Licenses();
		Thread.sleep(30000);
		als.Open_StoreLicenses_Page(driver);
		als.RefreshAndPaginination(driver);
		als.Pagination_Rows_Per_Count(driver);
		als.Revert_Licenses(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_Store_Licenses(Ending)   ********************-------");
	}
	
	@Test(priority=59,enabled = true)	
	public void Settings_Kitchen_Printers() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Kitchen_Printers(Starting)   ********************-------");
		
		Settings_Kitchen_Printers als = new Settings_Kitchen_Printers();
		Thread.sleep(30000);
		als.Open_Kitchen_Printer_Page(driver);
//		als.RefreshAndPaginination(driver);
		als.Add_Kitchen_Printer(driver);
		als.Edit_and_Close_Cancel_Kitchen_Printer(driver);
		als.Edit_and_Update_Kitchen_Printer(driver);
		als.Edit_and_KDS_Update_Kitchen_Printer(driver);
		als.Edit_and_Driver_Update_Kitchen_Printer(driver);
		als.Edit_and_Reselect_Printer_Update_Kitchen_Printer(driver);
		als.Update_Kitchen_Printer_Settings(driver);
		als.Create_DuplicateKitchen_PrinterGroup(driver);
		als.Delete_and_Active_Inactive_Kitchen_Printer(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_Kitchen_Printers(Ending)   ********************-------");
	}
	
	@Test(priority=62,enabled = true)	
	public void Settings_Receipt_Printers() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Receipt_Printers(Starting)   ********************-------");
		
		Settings_Receipt_Printers als = new Settings_Receipt_Printers();
		Thread.sleep(30000);
		als.Open_Receipt_Printer_Page(driver);
//		RefreshAndPaginination(driver);
		als.Add_Receipt_Printer(driver);
		als.Edit_and_Close_Cancel_Receipt_Printer(driver);
		als.Edit_and_Update_Receipt_Printer(driver);
		als.Create_Duplicate_Receipt_Printer(driver);
		als.Delete_and_Active_Inactive_Receipt_Printer(driver);
		als.Update_Receipt_Printer_Settings(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_Receipt_Printers(Ending)   ********************-------");
	}
	
	@Test(priority=65,enabled = true)	
	public void Settings_Label_Printers() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Label_Printers(Starting)   ********************-------");
		
		Settings_Label_Printers als = new Settings_Label_Printers();
		Thread.sleep(30000);
		als.Open_Label_Printer_Page(driver);
//		als.RefreshAndPaginination(driver);
		als.Add_Kitchen_Label_Label_Printer(driver);
		als.Edit_and_Close_Cancel_Label_Printer(driver);
		als.Edit_and_Update_Label_Printer(driver);
		als.Edit_and_Box_Level_Update_Label_Printer(driver);
		als.Edit_and_Reselect_Printer_Update_Label_Printer(driver);
		als.Create_Duplicate_Label_Printer(driver);
		als.Delete_and_Active_Inactive_Label_Printer(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_Label_Printers(Ending)   ********************-------");
	}
	
	@Test(priority=68,enabled = true)	
	public void Settings_AccountBalance() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_AccountBalance(Starting)   ********************-------");
		
		Settings_AccountBalance als = new Settings_AccountBalance();
		Thread.sleep(30000);
		als.Open_AcontBal_Page(driver);
		als.Edit_Details(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_AccountBalance(Ending)   ********************-------");
	}
	
	
	
	
	@Test(priority=71,enabled = true)	
	public void Settings_POS_Custom_URL() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_POS_Custom_URL(Starting)   ********************-------");
		
		Settings_POSCustomURL als = new Settings_POSCustomURL();
		Thread.sleep(30000);
		als.Open_POSUrl_Page(driver);
		als.Verify_PosCustomUrlPath(driver);
		als.Add_New_customer_url(driver);
		als.Edit_customer_url(driver);
		als.Delete_customer_url(driver);
		als.more_than_ten_customer_url(driver);
		als.Verify_More_than_ten_customer_url(driver);
		als.Delete_All_customer_url(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_POS_Custom_URL(Ending)   ********************-------");
	}
	
	@Test(priority=74,enabled = true)	
	public void Settings_Delivery_Settings () throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Delivery(Starting)   ********************-------");
		
		Settings_Delivery_Settings  als = new Settings_Delivery_Settings ();
		Thread.sleep(30000);
		als.Open_Delivery_Page(driver);
		als.Delivery_setting_Page(driver);
		als.Add_Delivery_Zone(driver);
		als.Edit_and_Update_Delivery_Zone(driver);
		als.Delete_Delivery_Zone(driver);
//		als.Delivery_Zone_Page(driver);
		als.Delivery_PUC_Page(driver);
		als.Delivery_Driver_Page(driver);
		als.Delivery_Save(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_Delivery(Ending)   ********************-------");
	}
	
	@Test(priority=77,enabled = true)	
	public void Settings_StoreInventory() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_StoreInventory(Starting)   ********************-------");
		
		Settings_StoreInventory als = new Settings_StoreInventory();
		Thread.sleep(30000);
		als.Open_StoreInv_Page(driver);
		als.Bussiness_Date(driver);
		als.select_toggles(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_StoreInventory(Ending)   ********************-------");
	}
	
	
	@Test(priority=80,enabled = true)	
	public void Settings_EMV_Settings() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_EMV_Settings(Starting)   ********************-------");
		
		Settings_EMV_Settings als = new Settings_EMV_Settings();
		Thread.sleep(30000);
		als.Open_EMVSettings_Page(driver);
		als.RefreshAndPaginination(driver);
		//--Row_Select_EMV(driver);
		als.Add_EMVSettings(driver);
		als.Create_DuplicateEMV(driver);
		als.Edit_and_Update_EMV(driver); 
		als.Delete_EMVSettings(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_EMV_Settings(Ending)   ********************-------");
	}
	
	@Test(priority=83,enabled = true)	
	public void Settings_Sale_Recap_Report() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Sale_Recap_Report(Starting)   ********************-------");
		
		Settings_Sale_Recap_Report als = new Settings_Sale_Recap_Report();
		Thread.sleep(30000);
		als.Open_Sales_Recap_Report_Page(driver);
//		als.Disable_And_Update_Sales_Recap_Report(driver);
		als.Enable_And_Update_Category_LevelType_Sales_Recap_Report(driver);
		als.Enable_And_Update_SubCategory_LevelType_Sales_Recap_Report(driver);
		als.Enable_And_Update_MenuItems_LevelType_Sales_Recap_Report(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_Sale_Recap_Report(Ending)   ********************-------");
	}
	
	@Test(priority=86,enabled = true)	
	public void Settings_Payment_Settings_and_Service_Charge() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Payment_Settings_and_Service_Charge(Starting)   ********************-------");
		
		Settings_Payment_Settings_and_Service_Charge als = new Settings_Payment_Settings_and_Service_Charge();
		Thread.sleep(30000);
		als.Open_Payment_Settings_Page(driver);
//		als.RefreshAndPaginination(driver);
		als.Add_Cash_Discount_Payment_Settings(driver);
		als.Change_Service_Charge_and_Add_VisaCard_Payment_Settings(driver);
		als.Edit_Cancel_and_Update_ServiceCharge(driver);
		als.Edit_and_Change_CardTypes(driver);
		als.Add_All_Cards_and_ServiceCharge(driver);
		als.Delete_ServiceCharge_Payment_Settings(driver);
		als.Change_and_Update_Instant_Cash_Reward_Payment_Settings(driver);

		
		test.log(LogStatus.INFO, "-------********************   Settings_Payment_Settings_and_Service_Charge(Ending)   ********************-------");
	}
	
	@Test(priority=89,enabled = true)	
	public void Settings_Payment_Methods() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Payment_Methods(Starting)   ********************-------");
		
		Settings_Payment_Methods als = new Settings_Payment_Methods();
		Thread.sleep(30000);
		als.Open_Payment_Method_Page(driver);Thread.sleep(2000);
//		als.RefreshAndPaginination(driver);
		als.Add_Payment_Method(driver);Thread.sleep(2000);
		als.Edit_and_Close_Cancel_Payment_Method(driver);Thread.sleep(2000);
		als.Edit_and_Update_CashWithMultiCurrency(driver);Thread.sleep(2000);
		als.Edit_and_Update_Changing_Payment_Types(driver);Thread.sleep(2000);
		als.Add_and_GiftCard_Payment_Method(driver);Thread.sleep(2000);
		als.Add_and_CreditCard_Payment_Method(driver);Thread.sleep(2000);
		als.Add_and_SideCC_Payment_Method(driver);Thread.sleep(2000);
		als.Add_and_BionetMealCard_Payment_Method(driver);Thread.sleep(2000);
//		als.Add_and_CastleAndGo_Payment_Method(driver);Thread.sleep(2000);
		als.Add_and_SPPax_Payment_Method(driver);Thread.sleep(2000);
		als.Add_and_Others_Payment_Method(driver);Thread.sleep(2000);
		als.Add_and_GiveX_Payment_Method(driver);Thread.sleep(2000);
		als.Add_and_NMI_Tokenization_Payment_Method(driver);Thread.sleep(2000);
		als.Add_and_Dejavoo_Payment_Method(driver);Thread.sleep(2000);
		als.Add_and_Optomany_Payment_Method(driver);Thread.sleep(2000);
		als.Add_and_MPPG_CreditCard_Payment_Method(driver);Thread.sleep(2000);
		als.Add_and_Ingenico_Payment_Method(driver);Thread.sleep(2000);
		als.Add_and_MemberShip_Payment_Method(driver);Thread.sleep(2000);
		als.Add_and_Evertec_Payment_Method(driver);Thread.sleep(2000);
		als.Add_and_PayPal_Payment_Method(driver);Thread.sleep(2000);
		als.Add_and_Venmo_Payment_Method(driver);Thread.sleep(2000);
		als.Create_DuplicatePayment_MethodGroup(driver);Thread.sleep(2000);
		als.Delete_Payment_Method(driver);Thread.sleep(2000);
		
		test.log(LogStatus.INFO, "-------********************   Settings_Payment_Methods(Ending)   ********************-------");
	}
	
	@Test(priority=92,enabled = true)	
	public void Settings_Label_Template() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_Label_Template(Starting)   ********************-------");
		
		Settings_Label_Template als = new Settings_Label_Template();
		Thread.sleep(30000);
		als.Open_Label_Printer_Page(driver);
		als.Save_Epson_Box_Label_Template_Settings(driver);
		als.Save_Zebra_Label_Template_Settings(driver);
		als.Save_Kitchen_Label_Template_Settings(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_Label_Template(Ending)   ********************-------");
	}
	
	@Test(priority=95,enabled = true)	
	public void Settings_KDS_Configuration() throws Exception
	{
		test.log(LogStatus.INFO, "-------********************   Settings_KDS_Configuration(Starting)   ********************-------");
		
		Settings_KDS_Configuration als = new Settings_KDS_Configuration();
		Thread.sleep(30000);
		als.Open_KDS_Page(driver);
		als.VerifyTheField_Options(driver);
		als.VerifyTheStyleOptions(driver);
		als.VerifyThe_SMS_Order_Notifications(driver);
		
		test.log(LogStatus.INFO, "-------********************   Settings_KDS_Configuration(Ending)   ********************-------");
	}
	
	@Test(priority=98,enabled = true)	
	public void Settings_Front_End_Receipt_Template() throws Exception
	{
		test.log(LogStatus.INFO, "-------*******************   Settings_Front_End_Receipt_Template(Starting)   *******************-------");
		
		Settings_Front_End_Receipt_Template als = new Settings_Front_End_Receipt_Template();
		Thread.sleep(30000);
		als.Open_Label_Printer_Page(driver);
		als.Disable_All_Front_End_Receipt_Template_Settings(driver);
		als.Verify_Disabled_and_Enable_All_Front_End_Receipt_Template_Settings(driver);
		als.Verify_Enabled_All_Front_End_Receipt_Template_Settings(driver);
		
		test.log(LogStatus.INFO, "-------*******************   Settings_Front_End_Receipt_Template(Ending)   *******************-------");
	}
	
	@Test(priority=101,enabled = true)	
	public void Settings_Kitchen_Printer_Template() throws Exception
	{
		test.log(LogStatus.INFO, "-------*******************   Settings_Kitchen_Printer_Template(Starting)   *******************-------");
		
		Settings_Kitchen_Printer_Template als = new Settings_Kitchen_Printer_Template();
		Thread.sleep(30000);
		als.Open_Kitchen_Printer_Template_Page(driver);
		als.Disable_All_Kitchen_Printer_Template_Settings(driver);
		als.Enable_All_Kitchen_Printer_Template_Settings(driver);
		
		test.log(LogStatus.INFO, "-------*******************   Settings_Kitchen_Printer_Template(Ending)   *******************-------");
	}
	
	@Test(priority=104,enabled = true)	
	public void Settings_Table_Layout() throws Exception
	{
		test.log(LogStatus.INFO, "-------*******************   Settings_Table_Layout(Starting)   *******************-------");
		
		Settings_Table_Layout als = new Settings_Table_Layout();
		Thread.sleep(30000);
		als.Open_TableLayout_Page(driver);
		
		test.log(LogStatus.INFO, "-------*******************   Settings_Table_Layout(Ending)   *******************-------");
	}
	
	
	
	@Test(priority=107,enabled = true)	
	public void Settings_ThirdPartyIntegrations() throws Exception
	{
		test.log(LogStatus.INFO, "-------*******************   Settings_ThirdPartyIntegrations(Starting)   *******************-------");
		
		Settings_ThirdPartyIntegrations als = new Settings_ThirdPartyIntegrations();
		Thread.sleep(30000);
		als.Open_ThirdPartyIntegration_Page(driver);
		
		test.log(LogStatus.INFO, "-------*******************   Settings_ThirdPartyIntegrations(Ending)   *******************-------");
	}
	
	@Test(priority=110,enabled = true)
	public void Settings_Printer_Rerouting() throws Exception
	{
		test.log(LogStatus.INFO, "-------*******************   Settings_Printer_Rerouting(Starting)   *******************-------");
		
		Settings_Printer_Rerouting als = new Settings_Printer_Rerouting();
		Thread.sleep(30000);
		als.Open_PrinterRerouting_Page(driver);
		
		test.log(LogStatus.INFO, "-------*******************   Settings_Printer_Rerouting(Ending)   *******************-------");
	}
	
	@Test(priority=113,enabled = true)	
	public void Settings_TipOut_TipSharing() throws Exception
	{
		test.log(LogStatus.INFO, "-------*******************   Settings_TipOut_TipSharing(Starting)   *******************-------");
		
		Settings_TipOut_TipSharing als = new Settings_TipOut_TipSharing();
		Thread.sleep(30000);
		als.Open_TipOutTipSharing_Page(driver);
		
		test.log(LogStatus.INFO, "-------*******************   Settings_TipOut_TipSharing(Ending)   *******************-------");
	}
	
	
	
	@Test(priority=320,enabled = true)	
	public void Settings_Payroll_Report () throws Exception
	{
		Settings_Payroll_Report a=new Settings_Payroll_Report();
		a.Open_Payroll_Report_Settings_Page(driver);
		a.Save_Payroll_Report_Settings(driver);
		a.Add_OverTime_Settings_Daily(driver);
	}
	
	@Test(priority =  321)
	public void Settings_Fiscal() throws Exception
	{
		Settings_Fiscal a=new Settings_Fiscal();
		a.Open_ForcedPunchInOut_Page(driver);
		a.RefreshAndPaginination(driver);
		a.VerifyTheAddFiscalSettings(driver);
		a.VerifyTheEditFiscalSettings(driver);
		a.VerifyTheDeleteFiscalSettings(driver);

	}
	
	@Test(priority=350)
	public void End_Settings()
	{
		test.log(LogStatus.INFO, "-------********************   Settings(Ending)   ********************-------");
	}
}