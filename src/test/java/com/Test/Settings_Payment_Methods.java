package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import com.Pages.Common_XPaths;
import com.Pages.PaymentMethodsPage;
import com.Test.LoginTest;
import com.epam.healenium.SelfHealingDriver;
import com.Pages.LoginPage;
import com.Pages.PaymentMethodsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Payment_Methods 
{

	public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings - Payment Methods");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	PaymentMethodsPage pmpg;
	
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
		Open_Payment_Method_Page(driver);
		RefreshAndPaginination(driver);
		Add_Payment_Method(driver);
		Edit_and_Close_Cancel_Payment_Method(driver);
		Edit_and_Update_CashWithMultiCurrency(driver);
		Edit_and_Update_Changing_Payment_Types(driver);
		Add_and_GiftCard_Payment_Method(driver);
		Add_and_CreditCard_Payment_Method(driver);
		Add_and_SideCC_Payment_Method(driver);
		Add_and_BionetMealCard_Payment_Method(driver);
//		Add_and_CastleAndGo_Payment_Method(driver);//
		Add_and_SPPax_Payment_Method(driver);
		Add_and_Others_Payment_Method(driver);
		Add_and_GiveX_Payment_Method(driver);
		Add_and_NMI_Tokenization_Payment_Method(driver);
//		Add_and_Dejavoo_Payment_Method(driver);	//
//		Add_and_Optomany_Payment_Method(driver); //
		Add_and_MPPG_CreditCard_Payment_Method(driver);
		Add_and_Ingenico_Payment_Method(driver);
		Add_and_MemberShip_Payment_Method(driver);
		Add_and_Evertec_Payment_Method(driver);
		Add_and_PayPal_Payment_Method(driver);
		Add_and_Venmo_Payment_Method(driver);
		Create_DuplicatePayment_MethodGroup(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Payment_Method_Page(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Payment Method page
		driver.get(Utility.getProperty("baseURL")+"settings/"+"paymentMethods");

		Thread.sleep(5000);
		//Verify the Payment Methods page loaded or not
		cmp.VerifyMainScreenPageHeader("Payment Methods");	
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
	public void Add_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		Thread.sleep(2000);
	
		//Verify the New Payment Method creation screen opened or not 
		cmp.VerifyCreationScreenPageHeader("New Payment Method");
		Thread.sleep(2000);
		
		//Click the Save button
		try
		{
			cmp.Click_SaveButton();
			
			test.log(LogStatus.FAIL, "Allow to Click/Save Payment method without Giving Name");

		}
		catch(Exception e)
		{
			test.log(LogStatus.PASS, "Unable to Click/Save Payment method without Giving Name");
		}
				
						String NameExcess = "Entering Invalid Name to input"; 
						int ActualSize= NameExcess.length();
						System.out.println(ActualSize);
		
						//Enter the Payment Method Name
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
				//Enter the Payment Method Name
				cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
				Thread.sleep(500);
				
				try
				{
					//Click the Save button

					cmp.Click_SaveButton();
					
					test.log(LogStatus.FAIL, "Allow to Click/Save Payment method without selecting Payment Type");

				}
				catch(Exception e)
				{
					test.log(LogStatus.PASS, "Unable to Click/Save Payment method without selecting Payment Type");
				}
					
				//Enter the Priority
				pmpg.Enter_PeymentMethod_Priority("1");

				//Select Cash Payment
				pmpg.Select_CashPayment();
				
				//Enable Cash Drawer
				pmpg.Enable_OpenCashDrawer();
				
				
		Thread.sleep(1000);
				//Click the Save button
				cmp.Click_SaveButton();
		 
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Payment Method Added Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Payment Method Added Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		

	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);

		
		Thread.sleep(1000);
		//Search the Payment Methods to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
		
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Payment Method");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Payment Method Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Payment Method Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_CashWithMultiCurrency(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);

		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Cash_Payment_Name")+"1");
		
		Thread.sleep(500);
		//Enable Multi Currency
		pmpg.Enable_Multi_Currency();
		
		//Select the Currency
		pmpg.Select_Currency_inMultiCurrency();
		
		//Enter the Exchange Amount
		pmpg.Enter_ExchangeRate("200");
		
		//Check whether the Open Cash Drawer Enabled or not after update
		if(pmpg.Open_CashDrawer_YesBtn().isSelected())
		{
			test.log(LogStatus.PASS, "Open Cash Drawer is Selected Reopen after the Update");
		}
		else
		{
			test.log(LogStatus.FAIL, "Open Cash Drawer is not Selected Reopen after the Update");
		}
		
		//Disable Open Cash Drawer
		pmpg.Disable_OpenCashDrawer();
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Changing_Payment_Types(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);

		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name")+"1");
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		//Select the Gift Card Payment Type
		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("Cash"))
		{
			test.log(LogStatus.PASS, "Cash Payment Type Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Cash Payment Type Not Selected");
		}
		
		//Select the Gift Card Payment Type
		pmpg.Select_GiftCard_Payment();
		
		
		//Check whether the Priority after Update
		if(pmpg.PaymentMethod_PriorityInputbox().getText().equalsIgnoreCase("1"))
		{
			test.log(LogStatus.PASS, "Priority is not changed after Update");
		}
		else
		{
			test.log(LogStatus.FAIL, "Priority is changed after Update");
		}
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Payment Method updated successfully for Gift Card");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method updated fail for Gift Card");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		//Select the Gift Card Payment Type
		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("Gift Card"))
		{
			test.log(LogStatus.PASS, "Gift Card Payment Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift Card Payment Type Not Selected after Update");
		}
		
		//Select the Gift Card Payment Type
		pmpg.Select_CreditCard_Payment();
		
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Payment Method updated successfully for Credit Card");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method updated fail for Credit Card");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		//Select the Gift Card Payment Type
		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("Credit Card"))
		{
			test.log(LogStatus.PASS, "Credit Card Payment Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Credit Card Payment Type Not Selected after Update");
		}
		
		//Select the Gift Card Payment Type
		pmpg.Select_SideCC_Payment();
		
		//Enable Multi Currency
		pmpg.Enable_Multi_Currency();
		
		//Select Currency
		pmpg.Select_Currency_inMultiCurrency();
		
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Payment Method updated successfully for Side CC");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method updated fail for Side CC");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		//Select the Gift Card Payment Type
		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("Side CC"))
		{
			test.log(LogStatus.PASS, "Side CC Payment Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Side CC Payment Type Not Selected after Update");
		}
		
		//Select the Gift Card Payment Type
		pmpg.Select_Bionet_MealCard_Payment();
		
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Payment Method updated successfully for Bionet Meal Card");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method updated fail for Bionet Meal Card");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		//Select the Gift Card Payment Type
		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("Bionet Meal Card"))
		{
			test.log(LogStatus.PASS, "Bionet Meal Card Payment Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Bionet Meal Card Payment Type Not Selected after Update");
		}
		
//		//Select the Gift Card Payment Type
//		pmpg.Select_CastleAndGo_Payment();
//		
//		
//		Thread.sleep(500);
//		//Click the Update 
//		cmp.Click_UpdateButton();
//		
//		Thread.sleep(3000);
//		//Check whether the New Payment Method Saved or not
//		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
//		{
//			test.log(LogStatus.PASS, "Payment Method updated successfully for Castle And Go");
//		
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Payment Method updated fail for Castle And Go");
//			
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
//		
//		Thread.sleep(1000);
//		//Search and Click Edit button
//		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
//		
//		Thread.sleep(500);
//		//Enter the Name
//		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
//		
//		//Select the Gift Card Payment Type
//		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("Castle And Go"))
//		{
//			test.log(LogStatus.PASS, "Castle And Go Payment Type Selected after Updated");
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Castle And Go Payment Type Not Selected after Update");
//		}
//		* REMOVE THIS COMMENT LINES IF THE PAYMENT METHOD AVAILABLE

		//Select the Gift Card Payment Type
		pmpg.Select_SPPax_Payment();
		
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Payment Method updated successfully for SPPax");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method updated fail for SPPax");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		//Select the Gift Card Payment Type
		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("SPPax"))
		{
			test.log(LogStatus.PASS, "SPPax Payment Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "SPPax Payment Type Not Selected after Update");
		}
		
		//Select the Gift Card Payment Type
		pmpg.Select_Others_Payment();
		
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Payment Method updated successfully for Others");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method updated fail for Others");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		//Select the Gift Card Payment Type
		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("Others"))
		{
			test.log(LogStatus.PASS, "Others Payment Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Others Payment Type Not Selected after Update");
		}
		
		//Select the Gift Card Payment Type
		pmpg.Select_GiveX_Payment();
		
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Payment Method updated successfully for GiveX");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method updated fail for GiveX");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		//Select the Gift Card Payment Type
		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("GiveX"))
		{
			test.log(LogStatus.PASS, "GiveX Payment Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "GiveX Payment Type Not Selected after Update");
		}
		
		//Select the Gift Card Payment Type
		pmpg.Select_NMI_Tokenization_Payment();
		
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Payment Method updated successfully for NMI Tokenization");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method updated fail for NMI Tokenization");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		//Select the Gift Card Payment Type
		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("NMI Tokenization"))
		{
			test.log(LogStatus.PASS, "NMI Tokenization Payment Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "NMI Tokenization Payment Type Not Selected after Update");
		}
		
		
//		//Select the Gift Card Payment Type
//		pmpg.Select_Dejavoo_Payment();
//		
//		
//		Thread.sleep(500);
//		//Click the Update 
//		cmp.Click_UpdateButton();
//		
//		Thread.sleep(3000);
//		//Check whether the New Payment Method Saved or not
//		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
//		{
//			test.log(LogStatus.PASS, "Payment Method updated successfully for Dejavoo");
//		
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Payment Method updated fail for Dejavoo");
//			
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
//		
//		Thread.sleep(1000);
//		//Search and Click Edit button
//		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
//		
//		Thread.sleep(500);
//		//Enter the Name
//		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
//		
//		//Select the Gift Card Payment Type
//		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("Dejavoo"))
//		{
//			test.log(LogStatus.PASS, "Dejavoo Payment Type Selected after Updated");
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Dejavoo Payment Type Not Selected after Update");
//		}
//		
//
//		//Select the Gift Card Payment Type
//		pmpg.Select_Optomany_Payment();
//		
//		
//		Thread.sleep(500);
//		//Click the Update 
//		cmp.Click_UpdateButton();
//		
//		Thread.sleep(3000);
//		//Check whether the New Payment Method Saved or not
//		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
//		{
//			test.log(LogStatus.PASS, "Payment Method updated successfully for Optomany");
//		
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Payment Method updated fail for Optomany");
//			
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
//		
//		Thread.sleep(1000);
//		//Search and Click Edit button
//		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
//		
//		Thread.sleep(500);
//		//Enter the Name
//		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
//		
//		//Select the Gift Card Payment Type
//		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("Optomany"))
//		{
//			test.log(LogStatus.PASS, "Optomany Payment Type Selected after Updated");
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Optomany Payment Type Not Selected after Update");
//		}
//		* REMOVE THIS COMMENT LINES IF THE PAYMENT METHOD AVAILABLE

		
		//Select the Gift Card Payment Type
		pmpg.Select_MPPG_CreditCard_Payment();
		
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Payment Method updated successfully for MPPG Credit Card");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method updated fail for MPPG Credit Card");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		//Select the Gift Card Payment Type
		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("MPPG Credit Card"))
		{
			test.log(LogStatus.PASS, "MPPG Credit Card Payment Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "MPPG Credit Card Payment Type Not Selected after Update");
		}
		
		//Select the Gift Card Payment Type
		pmpg.Select_Ingenico_Payment();
		
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Payment Method updated successfully for Ingenico");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method updated fail for Ingenico");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		//Select the Gift Card Payment Type
		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("Ingenico"))
		{
			test.log(LogStatus.PASS, "Ingenico Payment Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Ingenico Payment Type Not Selected after Update");
		}
		
		//Select the Gift Card Payment Type
		pmpg.Select_MemberShip_Payment();
		
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Payment Method updated successfully for MemberShip");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method updated fail for MemberShip");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		//Select the Gift Card Payment Type
		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("MemberShip"))
		{
			test.log(LogStatus.PASS, "MemberShip Payment Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "MemberShip Payment Type Not Selected after Update");
		}
		
		//Select the Gift Card Payment Type
		pmpg.Select_Evertec_Payment();
		
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Payment Method updated successfully for Evertec");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method updated fail for Evertec");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
		
		Thread.sleep(1000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		//Select the Gift Card Payment Type
		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("Evertec"))
		{
			test.log(LogStatus.PASS, "Evertec Payment Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Evertec Payment Type Not Selected after Update");
		}
		
		//Select the Gift Card Payment Type
		pmpg.Select_PayPal_Payment();
		
		
		Thread.sleep(1000);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Payment Method updated successfully for PayPal");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method updated fail for PayPal");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(2000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit("PayPal");
		
		Thread.sleep(500);
		//Enter the Name
//		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		//Select the Gift Card Payment Type
		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("PayPal"))
		{
			test.log(LogStatus.PASS, "PayPal Payment Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "PayPal Payment Type Not Selected after Update");
		}
		
		Thread.sleep(1000);
		//Select the Gift Card Payment Type
		pmpg.Select_Venmo_Payment();
		
		Thread.sleep(1000);
		//Enter the Name
//		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Payment Method updated successfully for Venmo");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method updated fail for Venmo");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit("Venmo");
		
		Thread.sleep(500);
		//Enter the Name
//		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		//Select the Gift Card Payment Type
		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("Venmo"))
		{
			test.log(LogStatus.PASS, "Venmo Payment Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Venmo Payment Type Not Selected after Update");
		}
		
		Thread.sleep(2000);
		//Select the Cash Payment Type
		pmpg.Select_CashPayment();
		
		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		//Enter Payment Method Code
		pmpg.Enter_PeymentMethod_Code("9220");
		
		//Enter Priority
		pmpg.Enter_PeymentMethod_Priority("1");
		
		//Enable Multi Currency
		pmpg.Enable_Multi_Currency();
		
		//Select Multi currency
		pmpg.Select_Currency_inMultiCurrency();
		
		//Enter Exchange amount
		pmpg.Enter_ExchangeRate("500");
		
		Thread.sleep(500);
		//Click the Update 
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payments Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Payment Method updated successfully for Cash");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method updated fail for Cash");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Cash_Payment_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		
		//Select the Gift Card Payment Type
		if(pmpg.PaymentType_Inputbox().getAttribute("value").equalsIgnoreCase("Cash"))
		{
			test.log(LogStatus.PASS, "Venmo Payment Type Selected after Updated");
		}
		else
		{
			test.log(LogStatus.FAIL, "Venmo Payment Type Not Selected after Update");
		}
		
		
		//Click Cancel
		cmp.Click_CancelButton();
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_and_GiftCard_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Gift_Card_Payment_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Enter the Priority
		pmpg.Enter_PeymentMethod_Priority("2");
		
		//Select Gift Card 
		pmpg.Select_GiftCard_Payment();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Gift Card Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift Card Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_and_CreditCard_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Credit_Card_Payment_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Enter the Priority
		pmpg.Enter_PeymentMethod_Priority("3");
		
		//Select Gift Card 
		pmpg.Select_CreditCard_Payment();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Credit Card Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Credit Card Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_and_SideCC_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("SideCC_Payment_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Enter the Priority
		pmpg.Enter_PeymentMethod_Priority("4");
		
		//Select Gift Card 
		pmpg.Select_SideCC_Payment();
		
		//Enable Multicurrency
				pmpg.Enable_Multi_Currency();
				
				//Select Currency
				pmpg.Select_Currency_inMultiCurrency();
				
				//Enter the Exchange amount
				pmpg.Enter_ExchangeRate("200");
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Side CC Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Side CC Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_and_BionetMealCard_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Bionet_Meal_Card_Payment_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Enter the Priority
		pmpg.Enter_PeymentMethod_Priority("5");
		
		//Select Gift Card 
		pmpg.Select_Bionet_MealCard_Payment();
		
		
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Bionet Meal Card Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Bionet Meal Card Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_and_CastleAndGo_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Castle_And_Go_Payment_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Enter the Priority
		pmpg.Enter_PeymentMethod_Priority("6");
		
		//Select Gift Card 
		pmpg.Select_CastleAndGo_Payment();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Castle And Go Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Castle And Go Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_and_SPPax_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Sppax_Payment_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Enter the Priority
		pmpg.Enter_PeymentMethod_Priority("7");
		
		//Select Gift Card 
		pmpg.Select_SPPax_Payment();
		
		
		//Enable EBT
		pmpg.Enable_EBT();
		
		//Enable Factor 4 Cards
		pmpg.Enable_Factor4Cards();
		
		if(pmpg.Exempt_CashDiscountFee_YesBtn().isDisplayed())
		{
			test.log(LogStatus.PASS, "Exempt Cash Discount Free is Displayed when Enabling Enable Cash Discount Fee");
			pmpg.Enable_Exempt_CashDiscountFee();

		}
		else
		{
			test.log(LogStatus.FAIL, "Exempt Cash Discount Free is not Displayed when Enabling Enable Cash Discount Fee");
	
		}
		
		//Enable Valutec Cards
		pmpg.Enable_Valutec_Cards();
	
		try
		{
		if(pmpg.Exempt_CashDiscountFee_YesBtn().isDisplayed())
		{
			test.log(LogStatus.FAIL, "Exempt Cash Discount Free is Displayed when Enabling Valutec Cards");
			pmpg.Enable_Exempt_CashDiscountFee();

		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Exempt Cash Discount Free is not Displayed when Enabling Valutec Cards");
	
		}		
		
		//Enable Open Cash Drawer
		pmpg.Enable_OpenCashDrawer();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "SPPax Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "SPPax Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Sppax_Payment_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Sppax_Payment_Name"));
		
		//Disable EBT
		pmpg.Disable_EBT();
		
		//Disable Factor 4 Cards
		pmpg.Disable_Factor4Cards();
		
		//Disable Valutec Cards
		pmpg.Disable_Valutec_Cards();
		
		//Disable Open Cash Drawer
		pmpg.Disable_OpenCashDrawer();
		
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "SPPax Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "SPPax Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_and_Others_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Others_Payment_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Enter the Priority
		pmpg.Enter_PeymentMethod_Priority("8");
		
		//Select Gift Card 
		pmpg.Select_Others_Payment();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Others Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Others Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_and_GiveX_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("GiveX_Payment_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Enter the Priority
		pmpg.Enter_PeymentMethod_Priority("9");
		
		//Select Gift Card 
		pmpg.Select_GiveX_Payment();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "GiveX Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "GiveX Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_and_NMI_Tokenization_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("NMI_Tokenization_Payment_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Enter the Priority
		pmpg.Enter_PeymentMethod_Priority("10");
		
		//Select Gift Card 
		pmpg.Select_NMI_Tokenization_Payment();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "NMI Tokenization Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "NMI Tokenization Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_and_Dejavoo_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Dejavoo_Payment_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Enter the Priority
		pmpg.Enter_PeymentMethod_Priority("11");
		
		//Select Gift Card 
		pmpg.Select_Dejavoo_Payment();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Dejavoo Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Dejavoo Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_and_Optomany_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Optomany_Payment_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Enter the Priority
		pmpg.Enter_PeymentMethod_Priority("12");
		
		//Select Gift Card 
		pmpg.Select_Optomany_Payment();
		
		//Enable EBT
		pmpg.Enable_EBT();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Optomany Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Optomany Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_and_MPPG_CreditCard_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("MPPG_Credit_Card_Payment_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Enter the Priority
		pmpg.Enter_PeymentMethod_Priority("13");
		
		//Select Gift Card 
		pmpg.Select_MPPG_CreditCard_Payment();
		
		//Select Sale Radio button
		pmpg.Sale_DebitInMPPGCard_RadioButton().click();
		
		//Enable Open Cash Drawer
		pmpg.Enable_OpenCashDrawer();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "MPPG Credit Card Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "MPPG Credit Card Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("MPPG_Credit_Card_Payment_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("MPPG_Credit_Card_Payment_Name"));
		
		if(pmpg.Sale_DebitInMPPGCard_RadioButton().isSelected())
		{
			test.log(LogStatus.PASS, "Sale is selected in MPPG Credit Card");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sale is not selected in MPPG Credit Card");
		}
		
		//Select Authorize
		pmpg.Authorize_DebitInMPPGCard_RadioButton().click();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "MPPG Credit Card Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "MPPG Credit Card Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_and_Ingenico_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Ingenico_Payment_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Enter the Priority
		pmpg.Enter_PeymentMethod_Priority("14");
		
		//Select Gift Card 
		pmpg.Select_Ingenico_Payment();

		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Ingenico Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Ingenico Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_and_MemberShip_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("MemberShip_Payment_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Enter the Priority
		pmpg.Enter_PeymentMethod_Priority("15");
		
		//Select Gift Card 
		pmpg.Select_MemberShip_Payment();

		//Enable Allowance Reset Periodically
		pmpg.Enable_Allowance_ResetPeriodically();
		
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "MemberShip Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "MemberShip Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("MemberShip_Payment_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("MemberShip_Payment_Name"));
		
		//Disable Allowance Reset Periodically
		pmpg.Disable_Allowance_ResetPeriodically();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "MPPG Credit Card Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "MPPG Credit Card Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_and_Evertec_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Evertec_Payment_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Enter the Priority
		pmpg.Enter_PeymentMethod_Priority("16");
		
		//Select Gift Card 
		pmpg.Select_Evertec_Payment();

		//Enable Open Cash Drawer
		pmpg.Enable_OpenCashDrawer();
		
		//Enable Cash
		pmpg.Enable_Cash_inEvertecPayment();
		
		//Enable Manual
		pmpg.Enable_Manual_inEvertecPayment();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Evertec Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Evertec Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Evertec_Payment_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Evertec_Payment_Name"));
		
		//Disable open cash drawer
		pmpg.Disable_OpenCashDrawer();
		
		//Disable Cash
		pmpg.Disable_Cash_inEvertecPayment();
		
		//Disable Manual
		pmpg.Disable_Manual_inEvertecPayment();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_UpdateButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Evertec Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Evertec Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_and_PayPal_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Enter the Priority
		pmpg.Enter_PeymentMethod_Priority("17");
		
		//Select Gift Card 
		pmpg.Select_PayPal_Payment();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "PayPal Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "PayPal Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_and_Venmo_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Enter the Priority
		pmpg.Enter_PeymentMethod_Priority("18");
		
		//Select Gift Card 
		pmpg.Select_Venmo_Payment();
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Venmo Payment Method updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Venmo Payment Method updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		
		} 
	}
	
	@Test(priority = 5,enabled = false)
	public void Delete_Payment_Method(SelfHealingDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);

		//Search and Click Delete button
				cmp.SearchAndClickDelete(Utility.getProperty("Evertec_Payment_Name"));
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();
		
				Thread.sleep(3000);
				try
				{
				//Check whether the New Payment Method Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method deleted successfully"))
				{
					test.log(LogStatus.FAIL, "Payment Method Deleted when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Payment Method not Deleted when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Evertec_Payment_Name"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Method deleted successfully"))
		{
			test.log(LogStatus.PASS, "Payment Method Deleted Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method Deletion Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	

		
	@Test(priority = 6,enabled = false)
	public void Create_DuplicatePayment_MethodGroup(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		pmpg=new PaymentMethodsPage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Payment Methods
		pmpg.Click_NewPaymentMethod();
		Thread.sleep(2000);
	
		//Verify the New Payment Method creation screen opened or not 
		cmp.VerifyCreationScreenPageHeader("New Payment Method");
		Thread.sleep(2000);
		
		Thread.sleep(1000);
		//Enter the Payment Method Name
		cmp.EnterName(Utility.getProperty("Cash_Payment_Name"));
		Thread.sleep(500);
		
		//Select Cash Paymenyt Type
		pmpg.Select_CashPayment();
		
		//Enter the code
		pmpg.Enter_PeymentMethod_Code("4321");
		
		//Enter Prioriry
		pmpg.Enter_PeymentMethod_Priority("20");
		
 Thread.sleep(1000);
		//Click the Save button
		cmp.Click_SaveButton();

		
		Thread.sleep(3000);
		//Check whether the New Payment Method Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist, must be unique"))
		{
			test.log(LogStatus.PASS, "Payment Method Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			//Click the Back button
			cmp.Click_BackspaceButton();
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enter valid Payments type"))
		{
			test.log(LogStatus.INFO, "Enter valid Payments type is Displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Payment Method Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
}
