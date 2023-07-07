package com.Pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class DiscountsPage {
	public WebDriver driver;
	public ExtentTest test;
	Common_XPaths cmp;
	Utility ut=new Utility();
	
	public DiscountsPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button/span[contains(.,'ITEM BASED')]")
	WebElement Item_Based_ScreenTab;
	
	@FindBy(xpath = "//button/span[contains(.,'CHECK BASED')]")
	WebElement Check_Based_ScreenTab;
	
	@FindBy(xpath = "//span/div[contains(.,'OPEN ITEM')]")
	WebElement Open_Item_ScreenTab;
	
	@FindBy(xpath = "//span/div[contains(.,'OPEN CHECK')]")
	WebElement Open_Check_ScreenTab;
	
	@FindBy(xpath = "//span/div[contains(.,'MIX AND MATCH')]")
	WebElement Mix_and_Match_ScreenTab;
	
	@FindBy(xpath = "//button[contains(.,'NEW DISCOUNT')]")
	WebElement New_DiscountBtn;
	
	@FindBy(xpath = "//button[contains(.,'NEW OPEN ITEM DISCOUNT')]")
	WebElement New_Open_Item_DiscountBtn;
	
	@FindBy(xpath = "//button[contains(.,'NEW OPEN CHECK DISCOUNT')]")
	WebElement New_Open_Check_DiscountBtn;
	
	@FindBy(xpath = "//input[@placeholder='Select Apply Discount']")
	WebElement 	Apply_DropDownBtn;
	
	@FindBy(xpath = "//select-option[contains(.,'Before Tax')]")
	WebElement Before_TaxBtn;
	
	@FindBy(xpath = "//select-option[contains(.,'After Tax')]")
	WebElement After_TaxBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Include Additional Modifiers')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement IncludeAdditionalModifiers_YesBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Include Additional Modifiers')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement IncludeAdditionalModifiers_NoBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Combine With Other Discount')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Combine_WithOther_Discount_YesBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Combine With Other Discount')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Combine_WithOther_Discount_NoBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Apply For Discounted Price')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Apply_For_Discounted_Price_YesBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Apply For Discounted Price')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Apply_For_Discounted_Price_NoBtn;
	
	@FindBy(xpath = "//h6[contains(.,'All Serving Sizes in Category')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement All_Serving_Sizes_inCategory_YesBtn;
	
	@FindBy(xpath = "//h6[contains(.,'All Serving Sizes in Category')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement All_Serving_Sizes_inCategory_NoBtn;
	
	@FindBy(xpath = "//label[contains(.,'Serving Size')]/../../div/div/input")
	WebElement Serving_SizeInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Serving Size')]/../../../div[4]/div/button")
	WebElement Serving_Size_CloseBtn;
	
	@FindBy(xpath = "//h6[contains(.,'EMPLOYEE DISCOUNT')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Employee_Discount_YesBtn;
	
	@FindBy(xpath = "//h6[contains(.,'EMPLOYEE DISCOUNT')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Employee_Discount_NoBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Attach Customer')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Attach_Customer_YesBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Attach Customer')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Attach_Customer_NoBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Coupon Only')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Coupon_Only_YesBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Coupon Only')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Coupon_Only_NoBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Auto Discount')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Auto_Discount_YesBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Auto Discount')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Auto_Discount_NoBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Restrict POS visiblity by user role')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Restrict_POS_Visiblity_ByUser_YesBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Restrict POS visiblity by user role')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Restrict_POS_Visiblity_ByUser_NoBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][contains(.,'Promo')]")
	WebElement Promo_DiscountType_RadioBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][contains(.,'Comp')]")
	WebElement Comp_DiscountType_RadioBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][contains(.,'Donation')]")
	WebElement Donation_DiscountType_RadioBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][contains(.,'Loyalty Discount')]")
	WebElement Loyalty_Discount_DiscountType_RadioBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][contains(.,'Amount')]")
	WebElement Amount_DiscountRate_RadioBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][contains(.,'Percentage')]")
	WebElement Percentage_DiscountRate_RadioBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][contains(.,'Set Price')]")
	WebElement Set_Price_DiscountRate_RadioBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][contains(.,'Free Item')]")
	WebElement Free_Item_DiscountRate_RadioBtn;
	
	@FindBy(xpath = "//label[contains(.,'Coupon Code')]/../../input")
	WebElement Coupon_CodeInputBx;
	
	@FindBy(xpath = "//button[contains(.,'Add FreeItem')]")
	WebElement Add_Free_ItemBtn;
	
	@FindBy(xpath = "//mat-hint[.='Enter Valid Priority']")
	WebElement Enter_Valid_PriorityErrorMsg;
	
	@FindBy(xpath = "//mat-hint[.='Enter Valid Quantity']")
	WebElement Enter_Valid_QuantityErrorMsg;
	
	@FindBy(xpath = "//button[contains(.,'AND PUBLISH') and @disabled='true']")
	WebElement Disabled_SaveOrUpdate_Btn;
	
	
	
	public void Select_Item_Based_DiscountTab()
	{
		Item_Based_ScreenTab.click();
	}
	
	public void Select_Check_Based_DiscountTab()
	{
		Check_Based_ScreenTab.click();
	}
	
	public void Select_Open_Item_DiscountTab()
	{
		Open_Item_ScreenTab.click();
	}
	
	public void Select_Open_Check_DiscountTab()
	{
		Open_Check_ScreenTab.click();
	}
	
	public void Select_Mix_and_Match_DiscountTab()
	{
		Mix_and_Match_ScreenTab.click();
	}
	
	public void Click_New_Discount()
	{
		New_DiscountBtn.click();
	}
	
	public void Click_New_Open_Item_Discount()
	{
		New_Open_Item_DiscountBtn.click();
	}
	
	public void Click_New_Open_Check_Discount()
	{
		New_Open_Check_DiscountBtn.click();
	}
	
	public void Select_BeforeTax() throws Exception
	{
		Thread.sleep(1000);
		Apply_DropDownBtn.click();
		Thread.sleep(1000);
		Before_TaxBtn.click();
		
	}

	public void Select_AfterTax() throws Exception
	{
		Thread.sleep(1000);
		Apply_DropDownBtn.click();
		Thread.sleep(1000);
		After_TaxBtn.click();
		
	}
	
	public WebElement Apply_DropDown()
	{
		return Apply_DropDownBtn;
	}
	
	public void Enable_IncludeAdditionalModifiers()
	{
		if(IncludeAdditionalModifiers_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			IncludeAdditionalModifiers_YesBtn.click();
		}
	}
	
	public void Disable_IncludeAdditionalModifiers()
	{
		if(IncludeAdditionalModifiers_YesBtn.isEnabled()) 
		{
			IncludeAdditionalModifiers_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	public WebElement IncludeAdditionalModifiers_YesButton()
	{
		return IncludeAdditionalModifiers_YesBtn;
	}
	
	public void Enable_Combine_WithOther_Discount()
	{
		if(Combine_WithOther_Discount_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Combine_WithOther_Discount_YesBtn.click();
		}
	}
	
	public void Disable_Combine_WithOther_Discount()
	{
		if(Combine_WithOther_Discount_YesBtn.isEnabled()) 
		{
			Combine_WithOther_Discount_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	public WebElement Combine_WithOther_Discount_YesButton()
	{
		return Combine_WithOther_Discount_YesBtn;
	}
	
	public void Enable_All_Serving_Size_inCategory()
	{
		if(All_Serving_Sizes_inCategory_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			All_Serving_Sizes_inCategory_YesBtn.click();
		}
	}
	
	public void Disable_All_Serving_Size_inCategory() throws Exception
	{
		try
		{
		if(All_Serving_Sizes_inCategory_YesBtn.isEnabled()) 
		{
			All_Serving_Sizes_inCategory_NoBtn.click();
		}
		}
		catch(Exception l)
		{
		
		}
	}
	
	public void Select_Serving_Size() throws Exception
	{
		Thread.sleep(1000);
		//Click the Cancel
		Serving_Size_CloseBtn.click();
		
		Thread.sleep(1000);
		Serving_SizeInputBx.click();

//		for(int i=1;i<=3;i++)
//		{
			Thread.sleep(2000);
		Serving_SizeInputBx.click();
//		Thread.sleep(1000);
//		List<WebElement> CategoryList=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
//		
//		int CategorySize=CategoryList.size();
//		
//		
//		int randomCategory=ThreadLocalRandom.current().nextInt(2, CategorySize);
//		
//		driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomCategory+"]/select-option")).click();
		
		driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();
		
		
	
		Thread.sleep(1000);
//		}
	}
	
	public WebElement All_Serving_Size_inCategory_YesButton()
	{
		return All_Serving_Sizes_inCategory_YesBtn;
	}
	
	public void Select_Promo_DiscountType()
	{
		Promo_DiscountType_RadioBtn.click();
	}
	
	public WebElement Promo_DiscountType()
	{
		return Promo_DiscountType_RadioBtn;
	}
	
	public void Select_Comp_DiscountType()
	{
		Comp_DiscountType_RadioBtn.click();
	}
	
	public WebElement Comp_DiscountType()
	{
		return Comp_DiscountType_RadioBtn;
	}
	
	public void Select_Donation_DiscountType()
	{
		Donation_DiscountType_RadioBtn.click();
	}
	
	public WebElement Donation_DiscountType()
	{
		return Donation_DiscountType_RadioBtn;
	}
	
	public void Select_Loyalty_Discount_DiscountType()
	{
		Loyalty_Discount_DiscountType_RadioBtn.click();
	}
	
	public WebElement Loyalty_Discount_DiscountType()
	{
		return Loyalty_Discount_DiscountType_RadioBtn;
	}
	
	public void Enable_Employee_Discount()
	{
		if(Employee_Discount_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Employee_Discount_YesBtn.click();
		}
	}
	
	public void Disable_Employee_Discount() throws Exception
	{
		try
		{
		if(Employee_Discount_YesBtn.isEnabled()) 
		{
			Employee_Discount_NoBtn.click();
		}
		}
		catch(Exception l)
		{
		
		}
	}
	
	public WebElement Employee_Discount_Yes()
	{
		return Employee_Discount_YesBtn;
	}
	
	
	public void Enable_Coupon_Only()
	{
		if(Coupon_Only_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Coupon_Only_YesBtn.click();
		}
	}
	
	public void Disable_Coupon_Only() throws Exception
	{
		try
		{
		if(Coupon_Only_YesBtn.isEnabled()) 
		{
			Coupon_Only_NoBtn.click();
		}
		}
		catch(Exception l)
		{
		
		}
	}
	
	public WebElement Coupon_Only_Yes()
	{
		return Coupon_Only_YesBtn;
	}
	
	public void Enter_Coupon_Code(String str) throws Exception
	{
		Thread.sleep(1000);
		Coupon_CodeInputBx.clear();
		Thread.sleep(1000);
		Coupon_CodeInputBx.sendKeys(str);
		
	}
	
	public WebElement Coupon_Code_InputBox()
	{
		return Coupon_CodeInputBx;
	}
	
	public void Enable_Auto_Discount()
	{
		if(Auto_Discount_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Auto_Discount_YesBtn.click();
		}
	}
	
	public void Disable_Auto_Discount() throws Exception
	{
	
		if(Auto_Discount_YesBtn.isEnabled()) 
		{
			Auto_Discount_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	public WebElement Auto_Discount_YesToggle()
	{
		return Auto_Discount_YesBtn;
	}
	
	public void Enable_Attach_Customer()
	{
		if(Attach_Customer_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Attach_Customer_YesBtn.click();
		}
	}
	
	public void Disable_Attach_Customer() throws Exception
	{
		try
		{
		if(Attach_Customer_YesBtn.isEnabled()) 
		{
			Attach_Customer_NoBtn.click();
		}
		}
		catch(Exception l)
		{
		
		}
	}
	
	public WebElement Attach_Customer_YesToggle()
	{
		return Attach_Customer_YesBtn;
	}
	
	
	public void Enable_Restrict_POS_Visiblity_ByUser()
	{
		if(Restrict_POS_Visiblity_ByUser_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Restrict_POS_Visiblity_ByUser_YesBtn.click();
		}
	}
	
	public void Disable_Restrict_POS_Visiblity_ByUser() throws Exception
	{
		try
		{
		if(Restrict_POS_Visiblity_ByUser_YesBtn.isEnabled()) 
		{
			Restrict_POS_Visiblity_ByUser_NoBtn.click();
		}
		}
		catch(Exception l)
		{
		
		}
	}
	
	public WebElement Restrict_POS_Visiblity_ByUser_YesToggle()
	{
		return Restrict_POS_Visiblity_ByUser_YesBtn;
	}
	
	public void Click_Amount_DiscountRateType()
	{
		Amount_DiscountRate_RadioBtn.click();
	}
	
	public WebElement Amount_DiscountRateType()
	{
		return Amount_DiscountRate_RadioBtn;
	}
	
	public void Click_Percentage_DiscountRateType()
	{
		Percentage_DiscountRate_RadioBtn.click();
	}
	
	public WebElement Percentage_DiscountRateType()
	{
		return Percentage_DiscountRate_RadioBtn;
	}
	
	public void Click_Set_Price_DiscountRateType()
	{
		Set_Price_DiscountRate_RadioBtn.click();
	}
	
	public WebElement Set_Price_DiscountRateType()
	{
		return Set_Price_DiscountRate_RadioBtn;
	}
	
	public void Click_Free_Item_DiscountRateType()
	{
		Free_Item_DiscountRate_RadioBtn.click();
	}
	
	public WebElement Free_Item_DiscountRateType()
	{
		return Free_Item_DiscountRate_RadioBtn;
	}
	
	//Select Roles
	public void Select_Restrict_POS_VisibilityRoles() throws Exception
	{
		Thread.sleep(1000);
		
		if(Restrict_POS_Visiblity_ByUser_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Restrict_POS_Visiblity_ByUser_YesBtn.click();
		}
		Thread.sleep(1000);
		
		Thread.sleep(1000);
		List<WebElement> SubCategoryList=driver.findElements(By.xpath("//div[@id='new-discount-visibility']/div[4]/div/app-chip/div/mat-chip-list/div/mat-chip"));
		int size=SubCategoryList.size()-1;
		
		for(int i=1;i<=3;i++)
		{
		
//		int SubCategorySize=SubCategoryList.size();
//		
//		
//		int randomSubCategory=ThreadLocalRandom.current().nextInt(2, SubCategorySize);
//		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='new-discount-visibility']/div[4]/div/app-chip/div/mat-chip-list/div/mat-chip["+i+"]")).click();
		
		Thread.sleep(1000);
		}
	}
	
	public void Verify_Enter_Valid_PriorityErrorMessage()
	{
		try
		{
		if(Disabled_SaveOrUpdate_Btn.isDisplayed())
		{
			test.log(LogStatus.PASS, "Update/Save button is disabled when user enter the priority value is invalid");
		}
		}
		catch(Exception j)
		{
			test.log(LogStatus.FAIL, "Update/Save button is enabled when user enter the priority value is invalid");
		}
	}
	
	public void Verify_Enter_Valid_QuantityErrorMessage()
	{
		try
		{
		if(Enter_Valid_QuantityErrorMsg.isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter Valid Quantity is Displayed");
		}
		}
		catch(Exception j)
		{
			test.log(LogStatus.FAIL, "Enter Valid Quantity is not Displayed");
		}
	}
	
	public void Click_Add_FreeItem()
	{
		Add_Free_ItemBtn.click();
	}
	
	/////////////////////// Check Based  ///////////////////
	
	@FindBy(xpath = "//button[contains(.,'Add Offer')]")
	WebElement Add_OfferBtn;
	
	public void Delete_AddOfferBtn() throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='new-discount-offers']/div[2]/div/mat-accordion/app-accordion[2]/div/mat-expansion-panel/mat-expansion-panel-header/span/div/div[4]/div/div/button")).click();

		Thread.sleep(1000);
		cmp.Click_DeleteButton();
		
		
		try
		{
			if(Set_Price_DiscountRate_RadioBtn.isDisplayed())
			{
				
			}
		}
		catch(Exception g)
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='new-discount-offers']/div[2]/div/mat-accordion/app-accordion[1]/div/mat-expansion-panel/mat-expansion-panel-header/span")).click();
		}
	
	}
	
	
	public void Click_Add_Offer()
	{
		Add_OfferBtn.click();
	}
	
	@FindBy(xpath = "//label[contains(.,'Category')]/../../div/div/input")
	WebElement Category_InputBox;

	@FindBy(xpath = "//label[contains(.,'Menu Item')]/../../div/div/input")
	WebElement MenuItem_InputBox;
	
	@FindBy(xpath = "//label[contains(.,'Check Total')]/../../input")
	WebElement Check_TotalInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Set Price')]/../../input")
	WebElement Set_PriceInputBx;
	
	
	public void Enter_Check_Total(String str) throws Exception
	{
		Thread.sleep(1000);
		Check_TotalInputBx.clear();
		Thread.sleep(1000);
		Check_TotalInputBx.sendKeys(str);
	}
	
	public WebElement Check_Total_InpuBox()
	{
		return Check_TotalInputBx;
	}
	
	public WebElement Set_Price_InpuBox()
	{
		return Set_PriceInputBx;
	}
	
	
	public void Enter_Set_Price(String str) throws Exception
	{
		Thread.sleep(1000);
		Set_PriceInputBx.clear();
		Thread.sleep(1000);
		Set_PriceInputBx.sendKeys(str);
	}
	
	public void Select_Exclude_Category() throws Exception
	{
		
		Thread.sleep(15000);
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
		Category_InputBox.click();
		
		Thread.sleep(1000);
		List<WebElement> CategoryList=driver.findElements(By.xpath("//div/select-option"));
		
		int CategorySize=CategoryList.size();
		
	
			if(CategorySize<=6)
			{
		
			int randomCategory=ThreadLocalRandom.current().nextInt(2, CategorySize);
			
			
			driver.findElement(By.xpath("//div["+randomCategory+"]/select-option")).click();
			}
			else
			{
				int randomCategory=ThreadLocalRandom.current().nextInt(2, 6);
				
				
				driver.findElement(By.xpath("//div["+randomCategory+"]/select-option")).click();
			
			}
			Thread.sleep(1000);
			List<WebElement> CategoryList1=driver.findElements(By.xpath("//div/select-option"));
			if(CategoryList1.size()!=0)
			{
//				test.log(LogStatus.FAIL, "SubCategory lists are displayed after Selecting the required SubCategory");
				Thread.sleep(1000);
				Category_InputBox.click();
			}
		
		}

	}
	
	public void Select_Exclude_MenuItems() throws Exception
	{
		
		Thread.sleep(15000);
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
		MenuItem_InputBox.click();
		
		Thread.sleep(1000);
		List<WebElement> MenuList=driver.findElements(By.xpath("//div/select-option"));
		
		int MenuSize=MenuList.size();
		
	
			if(MenuSize<=6)
			{
		
			int randomMenu=ThreadLocalRandom.current().nextInt(2, MenuSize);
			
			
			driver.findElement(By.xpath("//div["+randomMenu+"]/select-option")).click();
			}
			else
			{
				int randomMenu=ThreadLocalRandom.current().nextInt(2, 6);
				
				
				driver.findElement(By.xpath("//div["+randomMenu+"]/select-option")).click();
			
			}
			Thread.sleep(1000);
			List<WebElement> MenuList1=driver.findElements(By.xpath("//div/select-option"));
			if(MenuList1.size()!=0)
			{
//				test.log(LogStatus.FAIL, "SubCategory lists are displayed after Selecting the required SubCategory");
				Thread.sleep(1000);
				MenuItem_InputBox.click();
			}
		
		}
	}
	
	
	///////////// Open Item Discount  /////////////////////////
	
	@FindBy(xpath = "//h6[contains(.,'Discount In Percentage')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Discount_In_Percentage_YesBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Discount In Percentage')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Discount_In_Percentage_NoBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Discount In Amount')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Discount_In_Amount_YesBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Discount In Amount')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Discount_In_Amount_NoBtn;
	
	@FindBy(xpath = "//label[contains(.,'Minimum Percentage')]/../../input")
	WebElement Min_PercentageInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Maximum Percentage')]/../../input")
	WebElement Max_PercentageInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Minimum Amount')]/../../input")
	WebElement Min_AmountInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Maximum Amount')]/../../input")
	WebElement Max_AmountInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Safety Limit Percentage')]/../../input")
	WebElement Safety_Limit_PercentageInputBx;
	
	
	public void Enable_Discount_In_Percentage()
	{
		if(Discount_In_Percentage_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Discount_In_Percentage_YesBtn.click();
		}
	}
	
	public void Disable_Discount_In_Percentage()
	{
		if(Discount_In_Percentage_YesBtn.isEnabled()) 
		{
			Discount_In_Percentage_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	
	public WebElement Discount_In_Percentage_YesToggle()
	{
		return Discount_In_Percentage_YesBtn;
	}
	
	
	
	public void Enable_Discount_In_Amount()
	{
		if(Discount_In_Amount_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Discount_In_Amount_YesBtn.click();
		}
	}
	
	public void Disable_Discount_In_Amount()
	{
		if(Discount_In_Amount_YesBtn.isEnabled()) 
		{
			Discount_In_Amount_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	public WebElement Discount_In_Amount_YesToggle()
	{
		return Discount_In_Amount_YesBtn;
	}
	
	
	public void Enter_Minimum_Percentage(String str) throws Exception
	{
		Thread.sleep(1000);
		Min_PercentageInputBx.clear();
		Thread.sleep(1000);
		Min_PercentageInputBx.sendKeys(str);
	}
	
	public WebElement Minimum_Percentage()
	{
		return Min_PercentageInputBx;
	}
	
	public void Enter_Maximum_Percentage(String str) throws Exception
	{
		Thread.sleep(1000);
		Max_PercentageInputBx.clear();
		Thread.sleep(1000);
		Max_PercentageInputBx.sendKeys(str);
	}
	
	public WebElement Maximum_Percentage()
	{
		return Max_PercentageInputBx;
	}
	
	public void Enter_Minimum_Amount(String str) throws Exception
	{
		Thread.sleep(1000);
		Min_AmountInputBx.clear();
		Thread.sleep(1000);
		Min_AmountInputBx.sendKeys(str);
	}
	
	public WebElement Minimum_Amount()
	{
		return Min_AmountInputBx;
	}
	
	public void Enter_Maximum_Amount(String str) throws Exception
	{
		Thread.sleep(1000);
		Max_AmountInputBx.clear();
		Thread.sleep(1000);
		Max_AmountInputBx.sendKeys(str);
	}
	
	public WebElement Maximum_Amount()
	{
		return Max_AmountInputBx;
	}
	
	public void Enter_Safety_Limit_Percentage(String str) throws Exception
	{
		Thread.sleep(1000);
		Safety_Limit_PercentageInputBx.clear();
		Thread.sleep(1000);
		Safety_Limit_PercentageInputBx.sendKeys(str);
	}
	
	public WebElement Safety_Limit_Percentage()
	{
		return Safety_Limit_PercentageInputBx;
	}
	
	@FindBy(xpath = "//span[contains(.,'Maximum Percentage should be Greater than Minimum percentage')]")
	WebElement Max_To_Min_PercentageErrorMsg;
	
	@FindBy(xpath = "//span[contains(.,'Maximum Amount should be Greater than Minimum Amount')]")
	WebElement Max_To_Min_AmountErrorMsg;
	
	@FindBy(xpath = "//span[contains(.,'Enter Valid Min.Percentage')]")
	WebElement Min_PercentageErrorMsg;
	
	@FindBy(xpath = "//span[contains(.,'Enter Valid Max.Percentage')]")
	WebElement Max_PercentageErrorMsg;
	
	@FindBy(xpath = "//span[contains(.,'Enter Valid Min.Amount')]")
	WebElement Min_AmountErrorMsg;
	
	@FindBy(xpath = "//span[contains(.,'Enter Valid Max.Amount')]")
	WebElement Max_AmountErrorMsg;
	
	@FindBy(xpath = "//span[contains(.,'Enter valid safety limit percentage')]")
	WebElement Safety_Limit_PercentageErrorMsg;
	
	
	public WebElement Minimum_PercentageErrorPop()
	{
		return Min_PercentageErrorMsg;
	}
	

	public WebElement Maximum_PercentageErrorPop()
	{
		return Max_PercentageErrorMsg;
	}
	
	public WebElement MaximumToMinimum_PercentageErrorPop()
	{
		return Max_To_Min_PercentageErrorMsg;
	}
	
	
	public WebElement Minimum_AmountErrorPop()
	{
		return Min_AmountErrorMsg;
	}
	

	public WebElement Maximum_AmountErrorPop()
	{
		return Max_AmountErrorMsg;
	}
	
	public WebElement MaximumToMinimum_AmountErrorPop()
	{
		return Max_To_Min_AmountErrorMsg;
	}
	
	public WebElement Safety_Limit_PercentageErrorPop()
	{
		return Safety_Limit_PercentageErrorMsg;
	}
	
	public void Verify_Minimum_PercentageErrorPop()
	{
		try
		{
		if(Min_PercentageErrorMsg.isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter Valid Minimum Percentage is Displayed");
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Enter Valid Minimum Percentage is not Displayed");
	
		}
	}
	
	
	public void Verify_Maximum_PercentageErrorPop()
	{
		try
		{
		if(Max_PercentageErrorMsg.isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter Valid Maximum Percentage is Displayed");
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Enter Valid Maximum Percentage is not Displayed");
	
		}
	}
	
	public void Verify_MaximumToMinimum_PercentageErrorPop()
	{
		try
		{
		if(Max_To_Min_PercentageErrorMsg.isDisplayed())
		{
			test.log(LogStatus.PASS, "Maximum Percentage should be Greater than Minimum percentage is Displayed");
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Maximum Percentage should be Greater than Minimum percentage is not Displayed");
	
		}
	}
	
	
	public void Verify_Minimum_AmountErrorPop()
	{
		try
		{
		if(Min_AmountErrorMsg.isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter Valid Minimum Amount is Displayed");
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Enter Valid Minimum Amount is not Displayed");
	
		}
	}
	
	
	public void Verify_Maximum_AmountErrorPop()
	{
		try
		{
		if(Max_AmountErrorMsg.isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter Valid Maximum Amount is Displayed");
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Enter Valid Maximum Amount is not Displayed");
	
		}
	}
	
	public void Verify_MaximumToMinimum_AmountErrorPop()
	{
		try
		{
		if(Max_To_Min_AmountErrorMsg.isDisplayed())
		{
			test.log(LogStatus.PASS, "Maximum Amount should be Greater than Minimum Amount is Displayed");
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Maximum Amount should be Greater than Minimum Amount is not Displayed");
	
		}
	}
	
	public void Verify_Safety_Limit_PercentageErrorPop()
	{
		try
		{
		if(Safety_Limit_PercentageErrorMsg.isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter valid safety limit percentage is Displayed");
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Enter valid safety limit percentage is not Displayed");
	
		}
	}
	
	
	
	//////////////////////  Mix and Match  ////////////////////
	
	@FindBy(xpath = "//div[@class='radio-box'][contains(.,'Set Each Item Price')]")
	WebElement Set_Each_Item_Price_RadioBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][contains(.,'Set Percentage')]")
	WebElement Set_Percentage_RadioBtn;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Most Expensive')]")
	WebElement Most_Expensive_ChkBx;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Least Expensive')]")
	WebElement Least_Expensive_ChkBx;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Most Expensive')][contains(@class,'mat-radio-checked')]")
	WebElement Most_Expensive_ChkBx_SLD;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Least Expensive')][contains(@class,'mat-radio-checked')]")
	WebElement Least_Expensive_ChkBx_SLD;
	
	public WebElement Most_Expensive_RadioButton()
	{
		return Most_Expensive_ChkBx;
	}
	
	public WebElement Most_Expensive_RadioButton_Selected()
	{
		return Most_Expensive_ChkBx_SLD;
	}
	
	public WebElement Least_Expensive_RadioButton()
	{
		return Least_Expensive_ChkBx;
	}
	
	public WebElement Least_Expensive_RadioButton_Selected()
	{
		return Least_Expensive_ChkBx_SLD;
	}
	
	public void Click_Set_Each_Item_Price_DiscountRateType()
	{
		Set_Each_Item_Price_RadioBtn.click();
	}
	
	public WebElement Set_Each_Item_Price_DiscountRateType()
	{
		return Set_Each_Item_Price_RadioBtn;
	}
	
	public void Click_Set_Percentage_DiscountRateType()
	{
		Set_Percentage_RadioBtn.click();
	}
	
	public WebElement Set_Percentage_DiscountRateType()
	{
		return Set_Percentage_RadioBtn;
	}
	
	@FindBy(xpath = "//button[contains(.,'Add Price')]")
	WebElement Add_PriceBtn;
	
	public void Click_Add_Price()
	{
		Add_PriceBtn.click();
	}
	
	public void Enter_Add_Price(String st1,String st2) throws Exception
	{
		
		for(int i=1;i<=2;i++)
		{
			Click_Add_Price();
		}
		
		Thread.sleep(3000);
		List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='editable-data-grid']/div/div[1]/app-input/div/div/mat-form-field/div/div/div[4]/input"));
		for(int i=2;i<=rowList.size()+1;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='editable-data-grid']/div["+i+"]/div[1]/app-input/div/div/mat-form-field/div/div/div[4]/input")).clear();
			
			driver.findElement(By.xpath("//div[@class='editable-data-grid']/div["+i+"]/div[1]/app-input/div/div/mat-form-field/div/div/div[4]/input")).sendKeys(st1);
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='editable-data-grid']/div["+i+"]/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")).clear();
			
			driver.findElement(By.xpath("//div[@class='editable-data-grid']/div["+i+"]/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")).sendKeys(st2);
		}
		
		
	}
	
	public void Delete_Add_Price() throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		List<WebElement> lista=driver.findElements(By.xpath("//div[@class='editable-data-grid']/div/div[3]/button"));
		
		for(int i=3;i<=lista.size()+1;i++)
		{
			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[@class='editable-data-grid']/div["+i+"]/div[3]/button")).click();
			
			Thread.sleep(1000);
			
			cmp.Click_DeleteButton();
		}
	}
	
	
	public void Enter_Add_Price_Set_Percentage(String st1,String st2,String st3) throws Exception
	{
		
		for(int i=1;i<=4;i++)
		{
			Click_Add_Price();
		}
		
		Thread.sleep(3000);
		List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='editable-data-grid']/div/div[1]/app-input/div/div/mat-form-field/div/div/div[4]/input"));
		for(int i=2;i<=rowList.size()+1;i++)
		{
			driver.findElement(By.xpath("//div[@class='editable-data-grid']/div["+i+"]/div[1]/app-input/div/div/mat-form-field/div/div/div[4]/input")).clear();
			
			driver.findElement(By.xpath("//div[@class='editable-data-grid']/div["+i+"]/div[1]/app-input/div/div/mat-form-field/div/div/div[4]/input")).sendKeys(st1);
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='editable-data-grid']/div["+i+"]/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")).clear();
			
			driver.findElement(By.xpath("//div[@class='editable-data-grid']/div["+i+"]/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")).sendKeys(st2);
	
		
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='editable-data-grid']/div["+i+"]/div[3]/app-input/div/div/mat-form-field/div/div/div[4]/input")).clear();
			
			driver.findElement(By.xpath("//div[@class='editable-data-grid']/div["+i+"]/div[3]/app-input/div/div/mat-form-field/div/div/div[4]/input")).sendKeys(st3);
	
		
		}
		
		
	}
	
	public void Delete_Add_Price_Set_Percentage() throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		List<WebElement> lista=driver.findElements(By.xpath("//div[@class='editable-data-grid']/div/div[4]/button"));
		
		for(int i=3;i<=lista.size()+1;i++)
		{
			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[@class='editable-data-grid']/div[3]/div[4]/button")).click();
			
			Thread.sleep(1000);
			
			cmp.Click_DeleteButton();
		}
	}
	
	@FindBy(xpath = "//div[@class='editable-data-grid']/div[2]/div[1]/app-input/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Quantity_FirstRow_SetPrice;
	

	@FindBy(xpath = "//div[@class='editable-data-grid']/div[2]/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Price_FirstRow_SetPrice;


	@FindBy(xpath = "//div[@class='editable-data-grid']/div[2]/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")
	WebElement DiscountQuantity_FirstRow_SetPercentage;
	

	@FindBy(xpath = "//div[@class='editable-data-grid']/div[2]/div[3]/app-input/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Percentage_FirstRow_SetPercentage;
	 
	public WebElement Quantity_FirstRow_SetPrice()
	{
		return Quantity_FirstRow_SetPrice;
	}
	
	public WebElement Price_FirstRow_SetPrice()
	{
		return Price_FirstRow_SetPrice;
	}
	
	public WebElement DiscountQuantity_FirstRow_SetPercentage()
	{
		return DiscountQuantity_FirstRow_SetPercentage;
	}
	
	public WebElement Percentage_FirstRow_SetPercentage()
	{
		return Percentage_FirstRow_SetPercentage;
	}
	
	@FindBy(xpath = "//button[.='EDIT']")
	WebElement open_Edit;
	
	public void Click_Open_Edit()
	{
		open_Edit.click();
	}
	public WebElement Open_Item() 
	{
		return New_Open_Check_DiscountBtn;
	}
	public WebElement Open_Check() 
	{
		return New_Open_Item_DiscountBtn;
	}
}
