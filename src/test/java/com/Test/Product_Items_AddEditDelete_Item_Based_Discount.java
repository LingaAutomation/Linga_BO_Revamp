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
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_Item_Based_Discount {
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete - Item Based Discount");
	
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
		//System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
		//Open the Chrome window
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
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
		Open_Item_Based_Discount_Page(driver);
		RefreshAndPaginination(driver);
		Add_Item_Based_Discount(driver);
		Edit_and_Close_Cancel_Item_Based_Discount(driver);
		Edit_and_Update_Item_Based_Discount_Percentage(driver);
		Edit_and_Update_SubCategory_Item_Based_Discount(driver);
		Edit_and_Update_MenuItem_Item_Based_Discount(driver);
		Edit_and_Update_Item_Based_Discount_DaysOfWeek(driver);
		Edit_and_Update_Item_Based_Discount_DaysOfMonth(driver);
		Edit_and_Update_Item_Based_Discount_DateRange(driver);
		Edit_and_Update_Item_Based_Discount_Specific_Date(driver);
		Edit_and_Update_Item_Based_Discount_DateRangeWithTime(driver);
		Delete_and_Active_Inactive_Item_Based_Discount(driver);
		Create_Duplicate_Item_Based_Discount(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Item_Based_Discount_Page(WebDriver driver) throws Exception
	{
		
		dcp=new DiscountsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Upcharge page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"discounts");

		Thread.sleep(5000);
		//Verify the Item Based Discount page loeded or not
		cmp.VerifyMainScreenPageHeader("Discounts");	
		
		//Click the Item Based Screen
				dcp.Select_Item_Based_DiscountTab();
			 	
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
		//cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		//cmp.Filter_Columns();
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_Item_Based_Discount(WebDriver driver) throws Exception
	{
		dcp=new DiscountsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		ucp=new UpchargesPage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Item Based Discount
		dcp.Click_New_Discount();
		Thread.sleep(30000);
	
		//Verify the Item Based Discount creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("Item Based");
		Thread.sleep(5000);
		
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
				test.log(LogStatus.FAIL, "Item Based Discount Saved without Entering Name");
				
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
		cmp.EnterName(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		
		
		try
		{
		if(cmp.Save_and_PublishButton().isEnabled())
		{
			//Click Save and Publish button
			cmp.Click_Save_and_PublishButton();
			
			Thread.sleep(3000);
			//Check whether the New Department Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enter Valid Priority"))
			{
				test.log(LogStatus.PASS, "Please Enter Valid Priority Alert Displayed");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Saved Successfully"))
			{
				test.log(LogStatus.FAIL, "Item Based Discount Saved without Entering Valid Priority");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Enter Valid Priority Pop Up not Displayed");
			}
			
		}
		}
		catch(Exception e)
		{
		}
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);
				Thread.sleep(1000);
		//Click the Priority
		cmp.Enter_Priority("0");
		
		//Verify Priority Error msg
		dcp.Verify_Enter_Valid_PriorityErrorMessage();
		Thread.sleep(1000);
	
		//Click the Priority
		cmp.Enter_Priority("2");
		
		//Enter the Quantity
		cmp.Enter_Quantity("0");
		
		//Verify Quantity Error Msg
		dcp.Verify_Enter_Valid_QuantityErrorMessage();
		
		
		//Enter Quantity
		cmp.Enter_Quantity("6");
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
//				test.log(LogStatus.FAIL, "Item Based Discount Saved without Entering Valid Priority");
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
				
				//Enable Combine with Other Discount
				dcp.Enable_Combine_WithOther_Discount();
				
				Thread.sleep(1000);
				try {
					//Click Save and Publish button
					cmp.Click_Save_and_PublishButton();
					
					//Check whether the Item Based Discount Saved without Selecting Categories
					if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Saved Successfully"))
					{
						test.log(LogStatus.FAIL, "Item Based Discount Saved without Selecting Categories");
						
						//Search the Item Based Discount to Click Edit and Cancel
						cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
					
//						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Select Categories"))
					{
						test.log(LogStatus.PASS, "Please Select Categories is Displayed");
					}
					
					else
					{
						test.log(LogStatus.FAIL, "Please Select Categories Pop Up not Displayed");
					}
				}catch(Exception d) {
					test.log(LogStatus.FAIL, "Item based discount is not saved without category");
				}
				
				for(int i = 1;i <= 13;i++) {driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);}Thread.sleep(2000);
				//Select Discount Type Level
				ucp.Select_CategoryType();
			 
				//Disable All Serving Sizes in Category
				dcp.Disable_All_Serving_Size_inCategory();
				
//				try
//				{
				Thread.sleep(1000);	
				//Select Serving Size
				dcp.Select_Serving_Size();
//				}
//				catch(Exception l) {}
				Thread.sleep(1000);				//Select Promo Discount Type
				dcp.Select_Promo_DiscountType();
				
				Thread.sleep(1000);	
				//Enable Employee Discount
				dcp.Enable_Employee_Discount();
				
				Thread.sleep(1000);	
				//Select Amount Discount Rate Type 
				dcp.Click_Amount_DiscountRateType();
				
				Thread.sleep(1000);	
				//Enter the Amount values
				cmp.Enter_Amount("1000");
				Thread.sleep(1000);
				
		//Select Always
		at.Click_AlwaysButton();
		Thread.sleep(500);
	
		//Select Hide In POS
		dcp.Enable_Restrict_POS_Visiblity_ByUser();
		
		//Select Roles
		dcp.Select_Restrict_POS_VisibilityRoles();
				
				
		Thread.sleep(2000);
		//Click the Save and Publish button
		cmp.Click_Save_and_PublishButton();
		
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
		//Check whether the Item Based Discount Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Item Based Discount Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Discount Price Should not exceed MenuItem Price"))
		{
			test.log(LogStatus.INFO, "Discount Price Should not exceed MenuItem Price");
			
			
			Thread.sleep(1000);	
			//Enter the Amount values
			cmp.Enter_Amount("000");
			
			Thread.sleep(2000);
			//Click the Save and Publish button
			cmp.Click_Save_and_PublishButton();
			
			cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
			//Check whether the Item Based Discount Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Item Based Discount Saved Successfully");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Based Discount Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_Item_Based_Discount(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dcp=new DiscountsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		ucp=new UpchargesPage(driver, test);

		
		Thread.sleep(60000);
		//Search the Item Based Discount to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		
		Thread.sleep(30000);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Item Based");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_BackspaceButton();
		
		Thread.sleep(1000);
		//Check whether the Item Based Discount Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Item Based Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Based not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Item_Based_Discount_Percentage(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dcp=new DiscountsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		ucp=new UpchargesPage(driver, test);

		Thread.sleep(60000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
	
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		
		Thread.sleep(30000);	
		Thread.sleep(3000);
		//Get the Priority 
		String PriorityValue=cmp.Priority_Input().getAttribute("value");
		
		Thread.sleep(3000);
		//Get the Priority 
		String QuantityValue=cmp.Quantity_Input().getAttribute("value");
		
		
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
		}
		
		if(QuantityValue.equals("6"))
		{
			test.log(LogStatus.PASS, "Quantity value not Changed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Quantity value Changed ");
		}
		
		
		if(ApplyTax.equals("After Tax"))
		{
			test.log(LogStatus.PASS, "Apply Tax Type not Changed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Apply Tax Type Changed ");
		}
		
		
	
		//Check whether the Employee Discount Enabled or not
				if(dcp.Combine_WithOther_Discount_YesButton().isEnabled())
				{
					test.log(LogStatus.PASS, "Combine with Other Discount is Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Combine with Other Discount is not Selected");
				}
				
			
				try
				{
				//Check whether the All Serving Size in Category Enabled or not
				if(dcp.All_Serving_Size_inCategory_YesButton().isEnabled())
				{
					test.log(LogStatus.FAIL, "All Serving Size in Category is Selected");
				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.PASS, "All Serving Size in Category is not Selected");
				}
				
				//Check whether the Employee Discount Enabled or not
				if(dcp.Employee_Discount_Yes().isEnabled())
				{
					test.log(LogStatus.PASS, "Employee Discount is Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Employee Discount is not Selected");
				}
				
				
				Thread.sleep(1000);
				//Get the Apply Discount
				String AmountRate=cmp.Amount_Input().getAttribute("value");
				
				
				if(AmountRate.equals("10.00"))
				{
					test.log(LogStatus.PASS, "Amount value in Discount Rate not Changed when Promo Discount Type");
				}
				else
				{
					test.log(LogStatus.FAIL, "Amount value in Discount Rate Changed when Promo Discount Type");
				}
				
				
				//Verify Restrict POS 
				if(dcp.Restrict_POS_Visiblity_ByUser_YesToggle().isEnabled())
				{
					test.log(LogStatus.PASS, "Restrict POS visiblity by User is Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Restrict POS visiblity by User is not Selected");
				}
				
				//Enter the Name
				cmp.EnterName(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"1");
				
				//Enter the Priority
				cmp.Enter_Priority("4");
				
				//Enter the Quantity
				cmp.Enter_Quantity("10");
				
				//Select Before Tax
				dcp.Select_BeforeTax();
				
				
				//Disable Combine with other Discount
				dcp.Disable_Combine_WithOther_Discount();
				
				//Enable All Serving Size in Category
				dcp.Enable_All_Serving_Size_inCategory();
				
				//Select Comp Discount Type
				dcp.Select_Comp_DiscountType();
		
	
		
		//Disable Employee Discount
		dcp.Disable_Employee_Discount();
			
		try
		{
		//Check whether the Coupon only/Auto Discount/Attach Customer Displayed or not
		if(dcp.Coupon_Only_Yes().isDisplayed()&&dcp.Auto_Discount_YesToggle().isDisplayed()&&dcp.Attach_Customer_YesToggle().isDisplayed())
		{
			test.log(LogStatus.PASS, "Coupon Only, Auto Discount and Attach Customer Toggles Displayed when Disabling Employee Discount");
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Coupon Only, Auto Discount and Attach Customer Toggles not Displayed when Disabling Employee Discount");

		}
		
		
		//Enable Coupon Only
		dcp.Enable_Coupon_Only();
		try
		{
			if(dcp.Coupon_Code_InputBox().isDisplayed())
			{
//				test.log(LogStatus.PASS, "Coupon Code");
				//Enter the Coupon only Amount
				dcp.Enter_Coupon_Code("@***&");
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
				
				cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));

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
		dcp.Enter_Coupon_Code(Utility.getProperty("ItemBased_Discount_Code"));
		
		}
		catch(Exception C)
		{
			test.log(LogStatus.FAIL, "Coupon Code Input box Not available");
		}
	 
		//Enable Auto Discount
		dcp.Enable_Auto_Discount();
		
		//Enable Attach Customer
		dcp.Enable_Attach_Customer();
		

		
		//Select Percentage Discount Rate 
		dcp.Click_Percentage_DiscountRateType();
		
		//Enter the Percentage
		cmp.Enter_Percentage("10000");
	
	
		//Disable Restrict POS visiblity by user
		dcp.Disable_Restrict_POS_Visiblity_ByUser();
		
		
		Thread.sleep(2000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
		//Check whether the Item Based Discount Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Item Based Discount updated successfully for Percentage");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Based Discount updated fail for Percentage");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_SubCategory_Item_Based_Discount(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dcp=new DiscountsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		ucp=new UpchargesPage(driver, test);

		Thread.sleep(30000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"1");
		Thread.sleep(30000);

		Thread.sleep(3000);
		//Get the Priority 
		String PriorityValue=cmp.Priority_Input().getAttribute("value");
		
		Thread.sleep(3000);
		//Get the Priority 
		String QuantityValue=cmp.Quantity_Input().getAttribute("value");
		
		
		Thread.sleep(1000);
		//Get the Apply Discount
		String ApplyTax=dcp.Apply_DropDown().getAttribute("value");
		
		if(PriorityValue.equals("4"))
		{
			test.log(LogStatus.PASS, "Priority value not Changed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Priority value Changed ");
		}
		
		if(QuantityValue.equals("10"))
		{
			test.log(LogStatus.PASS, "Quantity value not Changed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Quantity value Changed ");
		}
		
		
		if(ApplyTax.equals("Before Tax"))
		{
			test.log(LogStatus.PASS, "Apply Tax Type not Changed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Apply Tax Type Changed ");
		}
		
		
	
		
		//Check whether the Category Level Type selected or not
		if(ucp.Category_LevelType().isEnabled())
		{
			test.log(LogStatus.PASS, "Category Level Type is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Category Level Type is not Selected");
		}
		
		//Check whether the All Serving Sizes in Sub Category Level Type selected or not
		if(dcp.All_Serving_Size_inCategory_YesButton().isEnabled())
		{
			test.log(LogStatus.PASS, "All Serving Sizes in Category is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "All Serving Sizes in Category is not Selected");
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
		String PercentageRate=cmp.Percentage_Input().getAttribute("value");
		
		//Verify Percentage
		if(PercentageRate.equals("10.000%"))
		{
			test.log(LogStatus.PASS, "Percentage value in Discount Rate not Changed when Comp Discount Type");
		}
		else
		{
			test.log(LogStatus.FAIL, "Percentage value in Discount Rate Changed when Comp Discount Type");
		}
		
		
		//Verify Coupon Only Toggle
		if(dcp.Coupon_Only_Yes().isEnabled())
		{
			test.log(LogStatus.PASS, "Coupon Only is Selected");
			
			String CouponCode=dcp.Coupon_Code_InputBox().getAttribute("value");
			
			//Verify Coupon Code
			if(CouponCode.equalsIgnoreCase(Utility.getProperty("ItemBased_Discount_Code")))
			{
				test.log(LogStatus.PASS, "Coupon Code is not Changed");
			}
			else
			{
				test.log(LogStatus.PASS, "Coupon Code is Changed. The Changed value is : "+CouponCode);
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "Coupon Only is not Selected");
		}
		
		
		//Verify Auto Discount Toggle
		if(dcp.Auto_Discount_YesToggle().isEnabled())
		{
			test.log(LogStatus.PASS, "Auto Discount is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Auto Discount is not Selected");
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
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		
		
		//Enter the Priority
		cmp.Enter_Priority("4");
		
		//Enter the Quantity
		cmp.Enter_Quantity("10");
		
		//Click After Tax
		dcp.Select_AfterTax();
		
		//Select Sub Category level
		ucp.Select_SubCategoryType();
	
		//Click the Donation Discount Type
		dcp.Select_Donation_DiscountType();
		
		//Click the Set Price
		dcp.Click_Set_Price_DiscountRateType();
		
		//Enter the Amount
		cmp.Enter_Amount("1500");
	
		Thread.sleep(1500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
		//Check whether the Item Based Discount Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Item Based Discount updated successfully to Sub Category");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Based Discount updated fail to Sub Category");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_MenuItem_Item_Based_Discount(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dcp=new DiscountsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		ucp=new UpchargesPage(driver, test);

		Thread.sleep(60000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		Thread.sleep(30000);
		
		Thread.sleep(3000);
		//Check whether the SubCategory Level Type selected or not
		if(ucp.SubCategory_LevelType().isEnabled())
		{
			test.log(LogStatus.PASS, "SubCategory Level Type is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "SubCategory Level Type is not Selected");
		}
		
		
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
		//Get the Apply Discount
		String AmountRate=cmp.Amount_Input().getAttribute("value");
		
		//Verify Percentage
		if(AmountRate.equals("15.00"))
		{
			test.log(LogStatus.PASS, "Set Price Amount value in Discount Rate not Changed when Donation Discount Type");
		}
		else
		{
			test.log(LogStatus.FAIL, "Set Price value in Discount Rate Changed when Donation Discount Type");
		}
		
		Thread.sleep(3000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"1");
		
		
		//Enter the Priority
		cmp.Enter_Priority("4");
		
		//Enter the Quantity
		cmp.Enter_Quantity("10");
		
		//Select Sub Category level
		ucp.Select_MenuItemType();
		
		Thread.sleep(1000);
		try
		{
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Serving-size level not found"))
		{
			test.log(LogStatus.PASS, "Serving-size level not found for the Menu Items");
	
			//Select Categories
			ucp.Select_CategoryType();
		}
		}
		catch(Exception l) {}
		//Select Loaylty Discount
		dcp.Select_Loyalty_Discount_DiscountType();
//		
		//Click the Free Item
//		dcp.Click_Free_Item_DiscountRateType();
//		//Select Free Item
//		dcp.Click_Add_FreeItem();
		dcp.Click_Percentage_DiscountRateType();
		
		//Enter the Percentage
		cmp.Enter_Percentage("15000");
		
		Thread.sleep(1500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
		//Check whether the Item Based Discount Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Item Based Discount updated successfully to Menu Item");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Based Discount updated fail to Menu Item");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Item_Based_Discount_DaysOfWeek(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dcp=new DiscountsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		ucp=new UpchargesPage(driver, test);

		Thread.sleep(60000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_ItemBased_AutoDiscount")+"1");
		Thread.sleep(30000);
	
		Thread.sleep(3000);
		//Check whether the Category Level Type selected or not
		if(ucp.Category_LevelType().isEnabled())
		{
			test.log(LogStatus.PASS, "Category Level Type is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Category Level Type is not Selected");
		}
		
		
		//Check whether the Comp selected or not
		if(dcp.Loyalty_Discount_DiscountType().isEnabled())
		{
			test.log(LogStatus.PASS, "Loyalty Discount Type is Selected");
		}
		else
		{
			test.log(LogStatus.FAIL, "Loyalty Discount Type is not Selected");
		}
		
		
		Thread.sleep(1000);
		//Get the Apply Discount
		String PerRate=cmp.Percentage_Input().getAttribute("value");
		
		//Verify Percentage
		if(PerRate.equals("15.000%"))
		{
			test.log(LogStatus.PASS, "Percentage value in Discount Rate not Changed when Loyalty Discount Type");
		}
		else
		{
			test.log(LogStatus.FAIL, "Percentage value in Discount Rate Changed when Loyalty Discount Type");
		}
		
		Thread.sleep(5000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		
		//Enter the Priority
		cmp.Enter_Priority("4");
		
		//Enter the Quantity
		cmp.Enter_Quantity("10");
		
		for(int i = 1;i <= 10;i++) {driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);}Thread.sleep(4000);
		//Select Category
		ucp.Select_SubCategoryType();
		Thread.sleep(500);

		//Select Days of Week
		at.Select_DaysOfWeek();
		Thread.sleep(500);

		//Select Restriction Time
		at.Enter_RestrictionTime();
		Thread.sleep(500);

		//Select Available Time
//		at.Enter_AvailableTime();
		Thread.sleep(500);

		//Disable Hide in POS
		dcp.Disable_Restrict_POS_Visiblity_ByUser();
		
		Thread.sleep(1500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
		//Check whether the Item Based Discount Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Item Based Discount updated successfully for Days of Week");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Based Discount updated fail for Days of Week");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Item_Based_Discount_DaysOfMonth(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dcp=new DiscountsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		ucp=new UpchargesPage(driver, test);

		Thread.sleep(30000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		Thread.sleep(30000);
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		
		//Enter the Priority
		cmp.Enter_Priority("4");
		
		//Enter the Quantity
		cmp.Enter_Quantity("10");
		
		for(int i = 1;i <= 10;i++) {driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);}Thread.sleep(4000);
		//Select Category
		ucp.Select_SubCategoryType();
		Thread.sleep(500);
		
		Thread.sleep(500);
		//Select Days of month
		at.Select_DaysOfMonth();
		Thread.sleep(500);

		//Select Restriction Time
		at.Enter_RestrictionTime();
		Thread.sleep(500);

		//Select Available Time
//		at.Enter_AvailableTime();
		
		Thread.sleep(1500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
		//Check whether the Item Based Discount Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Item Based Discount updated successfully for Days of Month");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Based Discount updated fail for Days of Month");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Item_Based_Discount_DateRange(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dcp=new DiscountsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		ucp=new UpchargesPage(driver, test);

		Thread.sleep(60000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		
		Thread.sleep(30000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		Thread.sleep(500);
		
		//Enter the Priority
		cmp.Enter_Priority("4");
		
		//Enter the Quantity
		cmp.Enter_Quantity("10");
		
		for(int i = 1;i <= 10;i++) {driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);}Thread.sleep(4000);
		//Select Category
		ucp.Select_SubCategoryType();
		Thread.sleep(1500);
		
		//Select Date Range
		at.Select_DateRange();
		
		Thread.sleep(1500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
		//Check whether the Item Based Discount Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Item Based Discount updated successfully for Date Range");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Based Discount updated fail for Date Range");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Item_Based_Discount_Specific_Date(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dcp=new DiscountsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		ucp=new UpchargesPage(driver, test);

		Thread.sleep(60000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		
		Thread.sleep(30000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		Thread.sleep(500);
		
		//Enter the Priority
		cmp.Enter_Priority("4");
		
		//Enter the Quantity
		cmp.Enter_Quantity("10");
		
		for(int i = 1;i <= 10;i++) {driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);}Thread.sleep(4000);
		//Select Category
		ucp.Select_SubCategoryType();
		Thread.sleep(500);
	
		Thread.sleep(1000);
		//Select Specific Date
		at.Select_SpecificDate();
		
		Thread.sleep(2000);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
		//Check whether the Item Based Discount Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Item Based Discount updated successfully for Specific Date");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Based Discount updated fail for Specific Date");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_Item_Based_Discount_DateRangeWithTime(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		dcp=new DiscountsPage(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		ucp=new UpchargesPage(driver, test);

		Thread.sleep(60000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		
		Thread.sleep(30000);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		Thread.sleep(1000);
		
		//Enter the Priority
		cmp.Enter_Priority("4");
		
		//Enter the Quantity
		cmp.Enter_Quantity("10");
		
		for(int i = 1;i <= 10;i++) {driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);}Thread.sleep(4000);
		//Select Category
		ucp.Select_SubCategoryType();
		Thread.sleep(500);
		
		//Select DateRange with Time
		at.Select_DateRangeWithTime();
		
		Thread.sleep(1500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
		//Check whether the Item Based Discount Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Item Based Discount updated successfully for Date Range with Time");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Based Discount updated fail for Date Range with Time");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}

	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Item_Based_Discount(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		dcp=new DiscountsPage(driver, test);
		Thread.sleep(60000);
		//Search and Click Delete button
				cmp.SearchAndClickDelete(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
				
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
		
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the Item Based Discount Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Discount Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Item Based Discount Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Based Discount Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		try
		{
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Discount Activated Successfully"))
		{
			test.log(LogStatus.FAIL, "Item Based Activated when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Item Based not Activated when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}



		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		
		Thread.sleep(500);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the Item Based Discount Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Discount Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Item Based Discount Activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item Based Discount activated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1500);
		//Enable Active Status
		cmp.Click_InactivetoActiveButton();
				
		Thread.sleep(1500);
		//Check whether verify whether the Active page opened or not
		cmp.VerifyActive_InactiveStatus("Active");
		
	
		
	}
	
	@Test(priority = 6,enabled = false)
	public void Create_Duplicate_Item_Based_Discount(WebDriver driver) throws Exception
	{
		dcp=new DiscountsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		at=new Availability_RestrictionTimePage(driver, test);
		ucp=new UpchargesPage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Item Based Discount
		dcp.Click_New_Discount();
		Thread.sleep(30000);
	
		//Verify the Item Based Discount creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("Item Based");
		Thread.sleep(5000);
		
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
				test.log(LogStatus.FAIL, "Item Based Discount Saved without Entering Name");
				
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
		cmp.EnterName(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
		
		
		try
		{
		if(cmp.Save_and_PublishButton().isEnabled())
		{
			//Click Save and Publish button
			cmp.Click_Save_and_PublishButton();
			
			Thread.sleep(3000);
			//Check whether the New Department Saved or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enter Valid Priority"))
			{
				test.log(LogStatus.PASS, "Please Enter Valid Priority Alert Displayed");
			
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Saved Successfully"))
			{
				test.log(LogStatus.FAIL, "Item Based Discount Saved without Entering Valid Priority");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Enter Valid Priority Pop Up not Displayed");
			}
			
		}
		}
		catch(Exception e)
		{
		}
		
				Thread.sleep(1000);
		//Click the Priority
		cmp.Enter_Priority("0");
		
		//Verify Priority Error msg
		dcp.Verify_Enter_Valid_PriorityErrorMessage();
		Thread.sleep(1000);
	
		//Click the Priority
		cmp.Enter_Priority("2");
		
		//Enter the Quantity
		cmp.Enter_Quantity("0");
		
		//Verify Quantity Error Msg
		dcp.Verify_Enter_Valid_QuantityErrorMessage();
		
		
		//Enter Quantity
		cmp.Enter_Quantity("6");
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
//				test.log(LogStatus.FAIL, "Item Based Discount Saved without Entering Valid Priority");
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
				
				//Enable Combine with Other Discount
				dcp.Enable_Combine_WithOther_Discount();
				
				Thread.sleep(1000);
				try {
					//Click Save and Publish button
					cmp.Click_Save_and_PublishButton();
					
					//Check whether the Item Based Discount Saved without Selecting Categories
					if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Saved Successfully"))
					{
						test.log(LogStatus.FAIL, "Item Based Discount Saved without Selecting Categories");
						
						//Search the Item Based Discount to Click Edit and Cancel
						cmp.SearchAndClickEdit(Utility.getProperty("DiscountName_ItemBased_AutoDiscount"));
					
//						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Select Categories"))
					{
						test.log(LogStatus.PASS, "Please Select Categories is Displayed");
					}
					
					else
					{
						test.log(LogStatus.FAIL, "Please Select Categories Pop Up not Displayed");
					}
				}catch(Exception d) {
					test.log(LogStatus.FAIL, "Item based discount is not saved without category");
				}
				
				for(int i = 1;i <= 13;i++) {driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);}Thread.sleep(15000);
				//Select Discount Type Level
				ucp.Select_CategoryType();
			 
				//Disable All Serving Sizes in Category
				dcp.Disable_All_Serving_Size_inCategory();
				
//				try
//				{
				//Select Serving Size
				dcp.Select_Serving_Size();
//				}
//				catch(Exception l) {}
				
				//Select Promo Discount Type
				dcp.Select_Promo_DiscountType();
				
				//Enable Employee Discount
				dcp.Enable_Employee_Discount();
				
				//Select Amount Discount Rate Type 
				dcp.Click_Amount_DiscountRateType();
				
				//Enter the Amount values
				cmp.Enter_Amount("1000");
				Thread.sleep(500);
				
		//Select Always
		at.Click_AlwaysButton();
		Thread.sleep(500);
	
		//Select Hide In POS
		dcp.Enable_Restrict_POS_Visiblity_ByUser();
		
		//Select Roles
		dcp.Select_Restrict_POS_VisibilityRoles();
				
				
		Thread.sleep(2000);
		//Click the Save and Publish button
		cmp.Click_Save_and_PublishButton();
		
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
		//Check whether the Item Based Discount Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exists"))
		{
			test.log(LogStatus.PASS, "Name already exists pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error(s)"))
		{
			test.log(LogStatus.PASS, "Validation Error(s) pop up displayed");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_BackspaceButton();
		}
		else
		{
			test.log(LogStatus.FAIL, "Name already exists pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			cmp.Click_BackspaceButton();
		}
		
		   Thread.sleep(3000);
	}
	
	 
}
