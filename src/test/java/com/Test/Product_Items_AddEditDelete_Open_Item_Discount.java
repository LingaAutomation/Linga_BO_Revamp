package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

import com.Pages.Availability_RestrictionTimePage;
import com.Pages.Common_XPaths;
import com.Pages.DiscountsPage;
import com.Pages.LoginPage;
import com.Pages.TaxesPage;
import com.Pages.UpchargesPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_Open_Item_Discount {
public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete - Open Item Discount (Discounts) ");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	DiscountsPage dcp;
	UpchargesPage ucp;
	Availability_RestrictionTimePage at;
	
	TaxesPage tp;
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
		//System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
		//Open the Chrome window
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver(chromeOptions);
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
		Open_Open_Item_Discount_Page(driver);
		RefreshAndPaginination(driver);
		Add_Open_Item_DiscountType_Promo(driver);
		Edit_and_Close_Cancel_Open_Item_Discount(driver);
		Edit_and_Update_Open_Item_DiscountType_Comp(driver);
		Edit_and_Update_Open_Item_DiscountType_Donation(driver);
		Edit_and_Update_MenuItem_Open_Item_Discount(driver);
		Delete_and_Active_Inactive_Open_Item_Discount(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Open_Item_Discount_Page(SelfHealingDriver driver) throws Exception
	{
		
		dcp=new DiscountsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Upcharge page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"discounts");

		Thread.sleep(5000);
		//Verify the Open Item Discount page loeded or not
		cmp.VerifyMainScreenPageHeader("Discounts");	
		

				
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dcp=new DiscountsPage(driver, test);
		
		//Click the Open Item Screen
		dcp.Select_Open_Item_DiscountTab();
		
		//Verify the Pagination and Refresh the page
		//cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		//cmp.Filter_Columns();
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_Open_Item_DiscountType_Promo(SelfHealingDriver driver) throws Exception
	{
		dcp=new DiscountsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		ucp=new UpchargesPage(driver, test);
		
		//Click the Open Item Screen
		dcp.Select_Open_Item_DiscountTab();
		
//		Thread.sleep(2000);
//		//Click the New Open Item Discount
//		dcp.Click_New_Open_Item_Discount();
//		Thread.sleep(30000);
//	
//		//Verify the Open Item Discount creation screen opened or not
//		cmp.VerifyCreationScreenPageHeader("Open Item");
//		Thread.sleep(5000);
		
		Thread.sleep(2000);
		try {
		//Click the New Open Item Discount
//		if(dcp.Open_Item().isDisplayed()) {
			dcp.Click_New_Open_Item_Discount();
//		}
		
		}
		catch (Exception e) 
		{
			dcp.Click_Open_Edit();
		}
		
		
		Thread.sleep(6000);
		
		try
		{
		if(cmp.Save_and_PublishButton().isEnabled())
		{
			//Click Save and Publish button
			cmp.Click_Save_and_PublishButton();
			
			Thread.sleep(3000);
			//Check whether the New Department Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Name"))
			{
				test.log(LogStatus.PASS, "Please Enter Name Alert Displayed");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Saved Successfully"))
			{
				test.log(LogStatus.FAIL, "Open Item Discount Saved without Entering Name");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Please Enter Name Pop Up not Displayed");
			}
			
		}
		}
		catch(Exception e)
		{
		}
		
	
		
		Thread.sleep(1000);
		//Enter the Discount Name
		cmp.EnterName(Utility.getProperty("DiscountName_OpenItemAMT"));
		
		
//		try
//		{
//		if(cmp.Save_and_PublishButton().isEnabled())
//		{
//			//Click Save and Publish button
//			cmp.Click_Save_and_PublishButton();
//			
//			Thread.sleep(3000);
//			//Check whether the New Department Saved or not
//			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enter Valid Priority"))
//			{
//				test.log(LogStatus.PASS, "Please Enter Valid Priority Alert Displayed");
//			
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//			else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Saved Successfully"))
//			{
//				test.log(LogStatus.FAIL, "Open Item Discount Saved without Entering Valid Priority");
//				
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//			else
//			{
//				test.log(LogStatus.FAIL, "Enter Valid Priority Pop Up not Displayed");
//			}
//			
//		}
//		}
//		catch(Exception e)
//		{
//		}
		
				Thread.sleep(1000);
		//Click the Priority
		cmp.Enter_Priority("0");
		
		//Verify Priority Error msg
		dcp.Verify_Enter_Valid_PriorityErrorMessage();
		Thread.sleep(1000);
	
		//Click the Priority
		cmp.Enter_Priority("2");
		
		test.log(LogStatus.INFO, "Priority Screen Before Reopen");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
	
//		try
//		{
//		if(cmp.Save_and_PublishButton().isEnabled())
//		{
//			//Click Save and Publish button
//			cmp.Click_Save_and_PublishButton();
//			
//			Thread.sleep(3000);
//			//Check whether the New Department Saved or not
//			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enter Valid Priority"))
//			{
//				test.log(LogStatus.PASS, "Please Enter Valid Priority Alert Displayed");
//			
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//			else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Saved Successfully"))
//			{
//				test.log(LogStatus.FAIL, "Open Item Discount Saved without Entering Valid Priority");
//				
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
//			else
//			{
//				test.log(LogStatus.FAIL, "Enter Valid Priority Pop Up not Displayed");
//			}
//			
//		}
//		}
//		catch(Exception e)
//		{
//		}
				
				Thread.sleep(500);
				//Select After Tax
				dcp.Select_AfterTax();
				
				//Select Promo Discount Type
				dcp.Select_Promo_DiscountType();
				
				
				//Enable Combine with Other Discount
				dcp.Enable_Combine_WithOther_Discount();
				
//				if(cmp.Save_and_PublishButton().isEnabled())
//				{
//				//Click Save and Publish button
//				cmp.Click_Save_and_PublishButton();
//				
//				//Check whether the Open Item Discount Saved without Selecting Categories
//				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Saved Successfully"))
//				{
//					test.log(LogStatus.FAIL, "Open Item Discount Saved without Selecting Categories");
//					
//					//Search the Open Item Discount to Click Edit and Cancel
//					cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_OpenItemAMT"));
//				
////					ut.FailedCaptureScreenshotAsBASE64(driver, test);
//				}
			
//				}
				
				//Disable Coupon Only
				dcp.Disable_Coupon_Only();
				
				//Disable Attach Customer
				dcp.Disable_Attach_Customer();
				
				
							
		Thread.sleep(1000);
		//Enable Discount in Percentage
		dcp.Enable_Discount_In_Percentage();
		
		if(dcp.Minimum_Percentage().isDisplayed()&&dcp.Maximum_Percentage().isDisplayed())
		{
			test.log(LogStatus.PASS, "Minimum and Maximum Percentage displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Minimum and Maximum Percentage not displayed");
		}
		
		//Enter Minium Percentage
				dcp.Enter_Minimum_Percentage("1000000");
		
				
				//Verify enter valid min percentage
				try
				{
				if(dcp.Minimum_PercentageErrorPop().isDisplayed())
				{
					test.log(LogStatus.PASS, "Enter Valid Minimum Percentage is Displayed when Entering Percentage above 100%");
				}
				}
				catch(Exception k)
				{
					test.log(LogStatus.FAIL, "Enter Valid Minimum Percentage is not Displayed when Entering Percentage above 100%");
			
				}
		
				//Enter the Maximum Percentage
				dcp.Enter_Maximum_Percentage("5000000");
				
				try
				{
				if(dcp.Maximum_PercentageErrorPop().isDisplayed())
				{
					test.log(LogStatus.PASS, "Enter Valid Maximum Percentage is Displayed when Entering Percentage above 100%");
				}
				}
				catch(Exception k)
				{
					test.log(LogStatus.FAIL, "Enter Valid Maximum Percentage is not Displayed when Entering Percentage above 100%");
			
				}
				
			
				
		//Enter Minium Percentage
		dcp.Enter_Minimum_Percentage("1000");
		
		//Verify Valid Maximum Percentage Error message
		try
		{
		if(dcp.Maximum_PercentageErrorPop().isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter Valid Maximum Percentage is Displayed");
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Enter Valid Maximum Percentage is not Displayed");
	
		}
		
		
		//Enter the Maximum Percentage
		dcp.Enter_Maximum_Percentage("500");
		
		//Verify Maximum percentage should be greater than minimum percenatage error pop up
		try
		{
		if(dcp.MaximumToMinimum_PercentageErrorPop().isDisplayed())
		{
			test.log(LogStatus.PASS, "Maximum percentage should be greater than minimum percentage is Displayed when Entering Minimum Percentage above Maximum Percentage");
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Maximum percentage should be greater than minimum percenatage is not Displayed when Entering Percentage above Maximum Percentage");
	
		}
		
		//Enter Minium Percentage
		dcp.Enter_Minimum_Percentage("10000");
	
		//Enter the Maximum Percentage
				dcp.Enter_Maximum_Percentage("50000");
				
		
		//Disable Discount in Amount
		dcp.Disable_Discount_In_Amount();
		
		
	
		//Select Hide In POS
		dcp.Enable_Restrict_POS_Visiblity_ByUser();
		
		//Select Roles
		dcp.Select_Restrict_POS_VisibilityRoles();
				
		 try {
				Thread.sleep(2000);
				//Click the Save and Publish button
				cmp.Click_Save_and_PublishButton();


				Thread.sleep(3000);
				//Check whether the Open Item Discount Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Discount Saved successfully"))
				{
					test.log(LogStatus.PASS, "Open Item Discount Saved Successfully");

					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Open Item Discount Save Failed");

					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
		         }
		         catch (Exception e) 
		         {
		      	   Thread.sleep(500);
		     		//Click the Update and Publish button
		     		cmp.Click_Update_and_PublishButton();

		    		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
		     		//Check whether the Open Item Discount Saved or not
		     		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Discoun Updated successfully"))
		     		{
		     			test.log(LogStatus.PASS, "Open Item Discount updated successfully for Donation Discount Type");

		     			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		     		}
		     		else
		     		{
		     			test.log(LogStatus.FAIL, "Open Item Discount updated fail for Donation Discount Type");

		     			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		     		}
		         }
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Open_Item_Discount(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dcp=new DiscountsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		ucp=new UpchargesPage(driver, test);

		
		//Thread.sleep(60000);
		//Search the Open Item Discount to Click Edit and Cancel
		//cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_OpenItemAMT"));
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//button[contains(.,'EDIT')]")).click();Thread.sleep(1000);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Open Item");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_BackspaceButton();
		
		Thread.sleep(1000);
		//Check whether the Open Item Discount Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Open Item Discount Screen Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Open Item Discount Screen not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Open_Item_DiscountType_Comp(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dcp=new DiscountsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		ucp=new UpchargesPage(driver, test);

		Thread.sleep(10000);
		//Search and Verify the Search box when Entering 3 Characters
		//cmp.SearchAndVerify_SearchBox();
	
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[contains(.,'EDIT')]")).click();
		//Search and Click Edit button
		//cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_OpenItemAMT"));
		
		Thread.sleep(3000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("DiscountName_OpenItemAMT")+"1");
		
		Thread.sleep(3000);
		//Get the Priority 
		String PriorityValue=cmp.Priority_Input().getAttribute("value");
		
	
		Thread.sleep(1000);
		//Get the Apply Discount
		String ApplyTax=dcp.Apply_DropDown().getAttribute("value");
		
		if(PriorityValue.equals("2"))
		{
			test.log(LogStatus.PASS, "Priority value not Changed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Priority value Changed ");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			test.log(LogStatus.INFO, "Priority Screen After Reopen");
		
		}
	
//		
//		
//		if(ApplyTax.equals("After Tax"))
//		{
//			test.log(LogStatus.PASS, "Apply Tax Type not Changed");
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Apply Tax Type Changed ");
//		}
//		
//	
//		
//		
//
//		//Check whether the Employee Discount Enabled or not
//				if(dcp.Combine_WithOther_Discount_YesButton().isEnabled())
//				{
//					test.log(LogStatus.PASS, "Combine with Other Discount is Selected");
//				}
//				else
//				{
//					test.log(LogStatus.FAIL, "Combine with Other Discount is not Selected");
//				}
//				
//				
//							
//				
//				Thread.sleep(1000);
//				//Get the Apply Discount
//				String minPerc=dcp.Minimum_Percentage().getAttribute("value");
//				
//				
//				if(minPerc.equals("10.000%"))
//				{
//					test.log(LogStatus.PASS, "Minimum Percentage not Changed when Promo Discount Type");
//				}
//				else
//				{
//					test.log(LogStatus.FAIL, "Minimum Percentage in Discount Rate Changed when Promo Discount Type");
//				}
//				
//				
//				//Get the Apply Discount
//				String maxPerc=dcp.Maximum_Percentage().getAttribute("value");
//				
//				
//				if(maxPerc.equals("50.000%"))
//				{
//					test.log(LogStatus.PASS, "Maximum Percentage not Changed when Promo Discount Type");
//				}
//				else
//				{
//					test.log(LogStatus.FAIL, "Maximum Percentage in Discount Rate Changed when Promo Discount Type");
//				}
//				
//				
//				//Verify Restrict POS 
//				if(dcp.Restrict_POS_Visiblity_ByUser_YesToggle().isEnabled())
//				{
//					test.log(LogStatus.PASS, "Restrict POS visiblity by User is Selected");
//				}
//				else
//				{
//					test.log(LogStatus.FAIL, "Restrict POS visiblity by User is not Selected");
//				}
				
				Thread.sleep(1000);
				//Click the Priority
				cmp.Enter_Priority("0");
				
				//Verify Priority Error msg
				dcp.Verify_Enter_Valid_PriorityErrorMessage();
				Thread.sleep(1000);
			
				//Click the Priority
				cmp.Enter_Priority("4");
				
				test.log(LogStatus.INFO, "Priority Before Second Reopen");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				//Enable Coupon Only
				dcp.Enable_Coupon_Only();
				
				try
				{
					if(dcp.Coupon_Code_InputBox().isDisplayed())
					{
//						test.log(LogStatus.PASS, "Coupon Code");
						//Enter the Coupon only Amount
						//dcp.Enter_Coupon_Code("@***&");
					}
				
				try
				{
				if(cmp.Save_and_PublishButton().isEnabled())
				{
					//Click Save and Publish button
					cmp.Click_Save_and_PublishButton();
					
					Thread.sleep(3000);
					//Check whether the New Department Saved or not
					if(cmp.ConfirmationAlertMsg().getTagName().equalsIgnoreCase("Saved Successfully"))
					{
						test.log(LogStatus.FAIL, "Item Based Discount Saved with Entering Special Characters");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
						
						driver.findElement(By.xpath("//button[contains(.,'EDIT')]")).click();
						//cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));

					}
					else
					{
						test.log(LogStatus.FAIL, "Item Based Discount Saved Failed with Entering Special Characters");
					}
					
				}
				}
				catch(Exception e)
				{
				}

				Thread.sleep(1000);
				//Enter the Discount Code
				//dcp.Enter_Coupon_Code(Utility.getProperty("OpenItem_Discount_Code"));
				
				}
				catch(Exception C)
				{
					test.log(LogStatus.FAIL, "Coupon Code Input box Not available");
				}
			 

			
				//Select Before Tax
				dcp.Select_BeforeTax();
				
				
				//Disable Combine with other Discount
				dcp.Disable_Combine_WithOther_Discount();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);Thread.sleep(2000);
				//Select Comp Discount Type
				dcp.Select_Comp_DiscountType();

				
				//Enable Include Additional Modifiers
				dcp.Enable_IncludeAdditionalModifiers();
				
		//Enable Attach Customer
		dcp.Enable_Attach_Customer();
		
		for(int i=1;i<=18;i++) {driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);}
		//Enter Minium Percentage
		Thread.sleep(3000);dcp.Enter_Minimum_Percentage("1000000");

		
		//Verify enter valid min percentage
		try
		{
		if(dcp.Minimum_PercentageErrorPop().isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter Valid Minimum Percentage is Displayed when Entering Percentage above 100% while Update");
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Enter Valid Minimum Percentage is not Displayed when Entering Percentage above 100% while Update");
	
		}

		//Enter the Maximum Percentage
		dcp.Enter_Maximum_Percentage("5000000");
		
		try
		{
		if(dcp.Maximum_PercentageErrorPop().isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter Valid Maximum Percentage is Displayed when Entering Percentage above 100% while Update");
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Enter Valid Maximum Percentage is not Displayed when Entering Percentage above 100% while Update");
	
		}
		
			
				
		//Enter Minium Percentage
		dcp.Enter_Minimum_Percentage("1000");
		
		//Verify Valid Maximum Percentage Error message
		try
		{
		if(dcp.Maximum_PercentageErrorPop().isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter Valid Maximum Percentage is Displayed while Update");
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Enter Valid Maximum Percentage is not Displayed while Update");
		
		}
		
		
		//Enter the Maximum Percentage
		dcp.Enter_Maximum_Percentage("500");
		
		//Verify Maximum percentage should be greater than minimum percenatage error pop up
		try
		{
		if(dcp.MaximumToMinimum_PercentageErrorPop().isDisplayed())
		{
			test.log(LogStatus.PASS, "Maximum percentage should be greater than minimum percentage is Displayed when Entering Minimum Percentage above Maximum Percentage while Update");
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Maximum percentage should be greater than minimum percenatage is not Displayed when Entering Percentage above Maximum Percentage while Update");
		
		}

		//Enter Minium Percentage
		dcp.Enter_Minimum_Percentage("15000");

		//Enter the Maximum Percentage
		dcp.Enter_Maximum_Percentage("40000");
		
		//Enable Discount In Amount
		dcp.Enable_Discount_In_Amount();
		
		
		
		if(dcp.Minimum_Amount().isDisplayed()&&dcp.Maximum_Amount().isDisplayed()&&dcp.Safety_Limit_Percentage().isDisplayed())
		{
			test.log(LogStatus.PASS, "Minimum and Maximum Amount and Safety limit Percentage displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Minimum and Maximum Amount and Safety Limit Percentage not displayed");
		}
		
		//Enter Minium Percentage
				dcp.Enter_Minimum_Amount("1000000");
		
				
				/*
				 * //Verify enter valid min Amount try {
				 * if(dcp.Minimum_AmountErrorPop().isDisplayed()) { test.log(LogStatus.PASS,
				 * "Enter Valid Minimum Amount is Displayed when Entering Percentage above 100%"
				 * ); } } catch(Exception k) { test.log(LogStatus.FAIL,
				 * "Enter Valid Minimum Amount is not Displayed when Entering Percentage above 100%"
				 * );
				 * 
				 * }
				 */
		
				//Enter the Maximum Amount
				dcp.Enter_Maximum_Amount("5000000");
				
				/*
				 * try { if(dcp.Maximum_AmountErrorPop().isDisplayed()) {
				 * test.log(LogStatus.PASS,
				 * "Enter Valid Maximum Amount is Displayed when Entering Percentage above 100%"
				 * ); } } catch(Exception k) { test.log(LogStatus.FAIL,
				 * "Enter Valid Maximum Amount is not Displayed when Entering Percentage above 100%"
				 * );
				 * 
				 * }
				 */

				/*
				 * //Enter Minium Amount dcp.Enter_Minimum_Amount("1000");
				 * 
				 * //Verify Valid Maximum Amount Error message try {
				 * if(dcp.Maximum_AmountErrorPop().isDisplayed()) { test.log(LogStatus.PASS,
				 * "Enter Valid Maximum Amount is Displayed"); } } catch(Exception k) {
				 * test.log(LogStatus.FAIL, "Enter Valid Maximum Amount is not Displayed");
				 * 
				 * }
				 */
		
		
		//Enter the Maximum Amount
		dcp.Enter_Maximum_Amount("500");
		
		//Verify Maximum percentage should be greater than minimum percenatage error pop up
		try
		{
		if(dcp.MaximumToMinimum_AmountErrorPop().isDisplayed())
		{
			test.log(LogStatus.PASS, "Maximum Amount should be greater than minimum Amount is Displayed when Entering Minimum Amount above Maximum Amount");
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Maximum Amount should be greater than minimum Amount is not Displayed when Entering Amount above Maximum Amount");
	
		}
		
		//Enter Minium Percentage
		dcp.Enter_Minimum_Amount("1200");
	
		//Enter the Maximum Percentage
				dcp.Enter_Maximum_Amount("2000");
				
		//Enter the Safety Limit Percentage
				dcp.Enter_Safety_Limit_Percentage("200000");
				
				//Verify Valid Safety Limit Percentage Error message
				try
				{
				if(dcp.Safety_Limit_PercentageErrorPop().isDisplayed())
				{
					test.log(LogStatus.PASS, "Enter valid safety limit percentage is Displayed");
				}
				}
				catch(Exception k)
				{
					test.log(LogStatus.FAIL, "Enter valid safety limit percentage is not Displayed");
			
				}
				
				
				
				//Enter the Safety Limit Percentage
						dcp.Enter_Safety_Limit_Percentage("25000");
					
	
		//Disable Restrict POS visiblity by user
		dcp.Disable_Restrict_POS_Visiblity_ByUser();
		
		
		Thread.sleep(2000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
		//Check whether the Open Item Discount Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Discount Updated & Published Successfully"))
		{
			test.log(LogStatus.PASS, "Open Item Discount updated successfully for Comp Discount Type");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Open Item Discount updated fail for Comp Discount Type");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Open_Item_DiscountType_Donation(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dcp=new DiscountsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		ucp=new UpchargesPage(driver, test);

		Thread.sleep(30000);
		driver.findElement(By.xpath("//button[contains(.,'EDIT')]")).click();
		//Search and Click Edit button
		//cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_OpenItemAMT")+"1");
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("DiscountName_OpenItemAMT"));
		
		
		Thread.sleep(3000);
		//Get the Priority 
		String PriorityValue=cmp.Priority_Input().getAttribute("value");
		
		
		
		Thread.sleep(1000);
		//Get the Apply Discount
		String ApplyTax=dcp.Apply_DropDown().getAttribute("value");
		
		test.log(LogStatus.INFO, "Priority After Second Reopen");

		if(PriorityValue.equals("4"))
		{
			test.log(LogStatus.PASS, "Priority value not Changed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Priority value Changed ");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	
		
		if(ApplyTax.equals("Before Tax"))
		{
			test.log(LogStatus.PASS, "Apply Tax Type not Changed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Apply Tax Type Changed ");
		}
		
		
	
		
	
	
		
		//Check whether the Comp selected or not
		if(dcp.Comp_DiscountType().isEnabled())
		{
			test.log(LogStatus.PASS, "Comp Discount Type is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Comp Discount Type is not Selected");
		}
		
		Thread.sleep(1000);
		//Get the Apply Discount
		String minAmt=dcp.Minimum_Amount().getAttribute("value");
		
		
		if(minAmt.equals("12.00"))
		{
			test.log(LogStatus.PASS, "Minimum Amount not Changed when Promo Discount Type");
		}
		else
		{
			test.log(LogStatus.FAIL, "Minimum Amount in Discount Rate Changed when Promo Discount Type");
		}
		
		
		//Get the Apply Discount
		String maxAmt=dcp.Maximum_Amount().getAttribute("value");
		
		
		if(maxAmt.equals("20.00"))
		{
			test.log(LogStatus.PASS, "Maximum Amount not Changed when Promo Discount Type");
		}
		else
		{
			test.log(LogStatus.FAIL, "Maximum Amount in Discount Rate Changed when Promo Discount Type");
		}
		
		//Get the Apply Discount
				String safLmtPerc=dcp.Safety_Limit_Percentage().getAttribute("value");
				
				
				if(safLmtPerc.equals("25.000%"))
				{
					test.log(LogStatus.PASS, "Safety Limit Percentage not Changed when Promo Discount Type");
				}
				else
				{
					test.log(LogStatus.FAIL, "Safety Limit Percentage in Discount Rate Changed when Promo Discount Type");
				}
				
		
		//Verify Coupon Only Toggle
		if(dcp.Coupon_Only_Yes().isEnabled())
		{
			test.log(LogStatus.PASS, "Coupon Only is Selected");
			try
			{
			String CouponCode=dcp.Coupon_Code_InputBox().getAttribute("value");
			
			//Verify Coupon Code
			if(CouponCode.equalsIgnoreCase(Utility.getProperty("OpenItem_Discount_Code")))
			{
				test.log(LogStatus.PASS, "Coupon Code is not Changed");
			}
			else
			{
				test.log(LogStatus.PASS, "Coupon Code is Changed. The Changed value is : "+CouponCode);
			}
			}
			catch(Exception l)
			{
				test.log(LogStatus.FAIL, "Coupon Code Input box not available");
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "Coupon Only is not Selected");
		}
		
		
		//Verify Auto Discount Toggle
		if(dcp.IncludeAdditionalModifiers_YesButton().isEnabled())
		{
			test.log(LogStatus.PASS, "Include Additional Modifiers is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Include Additional Modifiers is not Selected");
		}
		
		//Verify Attach Customer Toggle
		if(dcp.Attach_Customer_YesToggle().isEnabled())
		{
			test.log(LogStatus.PASS, "Attach Customer is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Attach Customer is not Selected");
		}
		Thread.sleep(1000);
		//Click the Priority
				cmp.Enter_Priority("2");
				
				Thread.sleep(1000);

		//Click After Tax
		dcp.Select_AfterTax();
		
		Thread.sleep(1000);

		//Click the Donation Discount Type
		dcp.Select_Donation_DiscountType();
		
		
		Thread.sleep(1500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
		//Check whether the Open Item Discount Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Discount Updated & Published Successfully"))
		{
			test.log(LogStatus.PASS, "Open Item Discount updated successfully for Donation Discount Type");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Open Item Discount updated fail for Donation Discount Type");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_MenuItem_Open_Item_Discount(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dcp=new DiscountsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		ucp=new UpchargesPage(driver, test);

		Thread.sleep(60000);
		driver.findElement(By.xpath("//button[contains(.,'EDIT')]")).click();
		//Search and Click Edit button
		//cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_OpenItemAMT"));
		
		Thread.sleep(3000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("DiscountName_OpenItemAMT")+"1");
		
		
		
		
		//Check whether the Comp selected or not
		if(dcp.Donation_DiscountType().isEnabled())
		{
			test.log(LogStatus.PASS, "Donation Discount Type is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Donation Discount Type is not Selected");
		}
		
		
		Thread.sleep(1000);
		//Click the Priority
				cmp.Enter_Priority("2");
				
				Thread.sleep(1000);

		
		//Select Promo
		dcp.Select_Promo_DiscountType();
		
		Thread.sleep(1000);

		//Enter Safety Limit Percentage
		dcp.Enter_Safety_Limit_Percentage("20000");
		
			
		Thread.sleep(2000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
		//Check whether the Open Item Discount Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Discount Updated & Published Successfully"))
		{
			test.log(LogStatus.PASS, "Open Item Discount updated successfully to Menu Item");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Open Item Discount updated fail to Menu Item");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Open_Item_Discount(SelfHealingDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		dcp=new DiscountsPage(driver, test);
		Thread.sleep(60000);
		//Search and Click Delete button
				//cmp.SearchAndClickDelete(Utility.getProperty("DiscountName_OpenItemAMT"));
			try {
				if(driver.findElement(By.xpath("//button[contains(.,'DEACTIVATE')]")).isDisplayed()) {
					
					//Click the deactive button
					driver.findElement(By.xpath("//button[contains(.,'DEACTIVATE')]")).click();
					
					Thread.sleep(500);
					//Click the Delete button
					cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
					
					//Click the Cancel button
					cmp.Click_CancelButtonInAlert();
					
					Thread.sleep(3000);
					try
					{
					//Check whether the New Modifier Saved or not
					if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Discount Inactivated Successfully"))
					{
						test.log(LogStatus.FAIL, "Item Based Deleted when clicking Cancel button");
					
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception g)
					{
						test.log(LogStatus.PASS, "Item Based not Deleted when Clicking Cancel button");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					
					//Click the deactive button
					driver.findElement(By.xpath("//button[contains(.,'DEACTIVATE')]")).click();
					
					Thread.sleep(500);
					//Click the delete button
					cmp.Click_DeleteButton();
					
					cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
					//Check whether the Open Item Discount Saved or not
					if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Discount Inactivated Successfully"))
					{
						test.log(LogStatus.PASS, "Open Item Discount Inactivated Successfully");
					
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					else
					{
						test.log(LogStatus.FAIL, "Open Item Discount Inactivated Failed");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					//Click the Activate button
					driver.findElement(By.xpath("//button[contains(.,'ACTIVATE')]")).click();
					
					Thread.sleep(500);
					
					if(driver.findElement(By.xpath("//div[@class='alert-content']/p")).getText().equalsIgnoreCase("Are you sure you want to activate this item?"))
					{
						test.log(LogStatus.PASS, "Activate Pop Up Displayed");
						
						driver.findElement(By.xpath("//button[contains(.,'Activate')]")).click();
					}
					else
					{
						test.log(LogStatus.FAIL, "Activate Pop Up not Displayed");
						
					}
					
					cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
					//Check whether the Open Item Discount Saved or not
					if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Discount Activated Successfully"))
					{
						test.log(LogStatus.PASS, "Open Item Discount Activated Successfully");
					
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					else
					{
						test.log(LogStatus.FAIL, "Open Item Discount activated Failed");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
			}catch(Exception d) {
				
				//Click the Activate button
				driver.findElement(By.xpath("//button[contains(.,'ACTIVATE')]")).click();
				
				Thread.sleep(500);
				
				if(driver.findElement(By.xpath("//div[@class='alert-content']/p")).getText().equalsIgnoreCase("Are you sure you want to activate this item?"))
				{
					test.log(LogStatus.PASS, "Activate Pop Up Displayed");
					
					driver.findElement(By.xpath("//button[contains(.,'Activate')]")).click();
				}
				else
				{
					test.log(LogStatus.FAIL, "Activate Pop Up not Displayed");
					
				}
				
				cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
				//Check whether the Open Item Discount Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Discount Activated Successfully"))
				{
					test.log(LogStatus.PASS, "Open Item Discount Activated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Open Item Discount activated Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}

				if(driver.findElement(By.xpath("//button[contains(.,'DEACTIVATE')]")).isDisplayed()) {
					
					//Click the deactive button
					driver.findElement(By.xpath("//button[contains(.,'DEACTIVATE')]")).click();
					
					Thread.sleep(500);
					//Click the Delete button
					cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
					
					//Click the Cancel button
					cmp.Click_CancelButtonInAlert();
					
					Thread.sleep(3000);
					try
					{
					//Check whether the New Modifier Saved or not
					if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Discount Inactivated Successfully"))
					{
						test.log(LogStatus.FAIL, "Item Based Deleted when clicking Cancel button");
					
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception g)
					{
						test.log(LogStatus.PASS, "Item Based not Deleted when Clicking Cancel button");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					
					//Click the deactive button
					driver.findElement(By.xpath("//button[contains(.,'DEACTIVATE')]")).click();
					
					Thread.sleep(500);
					//Click the delete button
					cmp.Click_DeleteButton();
					
					cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
					//Check whether the Open Item Discount Saved or not
					if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Discount Inactivated Successfully"))
					{
						test.log(LogStatus.PASS, "Open Item Discount Inactivated Successfully");
					
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					else
					{
						test.log(LogStatus.FAIL, "Open Item Discount Inactivated Failed");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					
					//Click the Activate button
					driver.findElement(By.xpath("//button[contains(.,'ACTIVATE')]")).click();
					
					Thread.sleep(500);
					
					if(driver.findElement(By.xpath("//div[@class='alert-content']/p")).getText().equalsIgnoreCase("Are you sure you want to activate this item?"))
					{
						test.log(LogStatus.PASS, "Activate Pop Up Displayed");
						
						driver.findElement(By.xpath("//button[contains(.,'Activate')]")).click();
					}
					else
					{
						test.log(LogStatus.FAIL, "Activate Pop Up not Displayed");
						
					}
					
					cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
					//Check whether the Open Item Discount Saved or not
					if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Discount Activated Successfully"))
					{
						test.log(LogStatus.PASS, "Open Item Discount Activated Successfully");
					
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					else
					{
						test.log(LogStatus.FAIL, "Open Item Discount activated Failed");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
			
			}	
			Thread.sleep(3000);
	}
}
