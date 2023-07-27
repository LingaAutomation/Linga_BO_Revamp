package com.Pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class ProductItems_Menu_RetailPage {

	public WebDriver driver;
	public ExtentTest test;
	Common_XPaths cmp;
	TaxesPage tx;
	Utility ut=new Utility();
	
	public ProductItems_Menu_RetailPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'NEW RETAIL ITEM')]")
	WebElement New_Retail_ItemBtn;
	
	@FindBy(xpath = "//button[contains(.,'NEW MENU ITEM')]")
	WebElement New_Menu_ItemBtn;
	
	@FindBy(xpath = "//label[contains(.,'Secondary Name')]/../../input")
	WebElement Secondary_NameInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Item Preparation Time')]/../../input")
	WebElement Item_Preparation_TimeInputBx;
	
	@FindBy(xpath = "//label[contains(.,'PLU Code')]/../../input")
	WebElement PLU_CodeInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Kitchen Printer Name')]/../../input")
	WebElement Kitchen_Printer_NameInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Description')]/../../textarea")
	WebElement Description_TextBx;
	
	@FindBy(xpath = "//div[@class='radio-box'][.='Category']")
	WebElement Category_RadioBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][.='Sub Category']")
	WebElement SubCategory_RadioBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][.='Menu Item']")
	WebElement MenuItem_MenuType_RadioBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][.='Menu Item With Serving Size']")
	WebElement MenuItem_With_ServingSize_MenuType_RadioBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][.='Open Item']")
	WebElement OpenItem_MenuType_RadioBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][.='Scale Item']")
	WebElement ScaleItem_MenuType_RadioBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][.='Combo Item']")
	WebElement ComboItem_MenuType_RadioBtn;
	
	@FindBy(xpath = "//input[@placeholder='Select Category']")
	WebElement Category_InputBx;
	
	@FindBy(xpath = "//input[@placeholder='Select SubCategory']")
	WebElement SubCategory_InputBx;
	
	@FindBy(xpath = "//mat-label[.=' Category ']/../../../input")
	WebElement Category_RetailInventoryInputBx;
	
	@FindBy(xpath = "//mat-label[.=' Sub Category ']/../../../input")
	WebElement SubCategory_RetailInventoryInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Evertex Tax Type')]/../../input")
	WebElement Evertex_Tax_TypeInputBx;
	
	@FindBy(xpath = "//app-toggle[contains(.,'Conversational UI at POS')]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Conversational_UI_atPOS_YesBtn;
		
	@FindBy(xpath = "//app-toggle[contains(.,'Conversational UI at POS')]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Conversational_UI_atPOS_NoBtn;
	
	@FindBy(xpath = "//app-toggle[contains(.,'Cut And Modify')]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Cut_And_Modify_YesBtn;
		
	@FindBy(xpath = "//app-toggle[contains(.,'Cut And Modify')]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Cut_And_Modify_NoBtn;
	
	@FindBy(xpath = "//mat-button-toggle[contains(.,'FIXED')]")
	WebElement Fixed_Cost_TypeRadioBtn;
	
	@FindBy(xpath = "//mat-button-toggle[contains(.,'VARIABLE')]")
	WebElement Variable_Cost_TypeRadioBtn;
	
	@FindBy(xpath = "//app-toggle[contains(.,'Price Level Settings')]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Price_Level_Settings_YesBtn;
		
	@FindBy(xpath = "//app-toggle[contains(.,'Price Level Settings')]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Price_Level_Settings_NoBtn;
	
	@FindBy(xpath = "//app-toggle[contains(.,'Hide In Kiosk')]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Hide_In_Kiosk_YesBtn;
	
	public WebElement Hide_In_Kiosk_Yes()
	{
		return Hide_In_Kiosk_YesBtn;
	}
	
		
	@FindBy(xpath = "//app-toggle[contains(.,'Hide In Kiosk')]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Hide_In_Kiosk_NoBtn;
	
	@FindBy(xpath = "//app-toggle[contains(.,'EBT Menu Item')]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement EBT_Menu_Item_YesBtn;
		

	public WebElement EBT_Menu_Item_Yes()
	{
		return EBT_Menu_Item_YesBtn;
	}
	
	@FindBy(xpath = "//app-toggle[contains(.,'EBT Menu Item')]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement EBT_Menu_Item_NoBtn;
	
	@FindBy(xpath = "//app-toggle[contains(.,'Hide In POS')]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Hide_In_POS_YesBtn;
	
	public WebElement Hide_In_POS_Yes()
	{
		return Hide_In_POS_YesBtn;
	}
	
		
	@FindBy(xpath = "//app-toggle[contains(.,'Hide In POS')]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Hide_In_POS_NoBtn;
	
	@FindBy(xpath = "//app-toggle[contains(.,'Hide In Online Order')]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Hide_In_Online_Order_YesBtn;
	
	public WebElement Hide_In_Online_Order_Yes()
	{
		return Hide_In_Online_Order_YesBtn;
	}
	
		
	@FindBy(xpath = "//app-toggle[contains(.,'Hide In Online Order')]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Hide_In_Online_Order_NoBtn;
	
	@FindBy(xpath = "//app-toggle[contains(.,'86 List')]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Eighty_Six_List_YesBtn;
	
	public WebElement Eighty_Six_List_Yes()
	{
		return Eighty_Six_List_YesBtn;
	}
		
	@FindBy(xpath = "//app-toggle[contains(.,'86 List')]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Eighty_Six_List_NoBtn;
	
	@FindBy(xpath = "//app-toggle[contains(.,'Meito MenuItem')]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Meito_MenuItem_YesBtn;
	
	public WebElement Meito_MenuItem_Yes()
	{
		return Meito_MenuItem_YesBtn;
	}
		
	@FindBy(xpath = "//app-toggle[contains(.,'Meito MenuItem')]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Meito_MenuItem_NoBtn;
	
	@FindBy(xpath = "//button[contains(.,'Add Included Modifiers')]")
	WebElement Add_Included_ModifiersBtn;
	
	@FindBy(xpath = "//button[contains(.,'Add Mandatory Modifier Group')]")
	WebElement Add_Mandatory_Modifier_GroupBtn;
	
	@FindBy(xpath = "//button[contains(.,'Add Optional Modifier Group')]")
	WebElement Add_Optional_Modifier_GroupBtn;
	
	@FindBy(xpath = "//app-toggle[contains(.,'Jump With Minimum Quantity')]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Jump_With_Minimum_Quantity_YesBtn;
		
	@FindBy(xpath = "//app-toggle[contains(.,'Jump With Minimum Quantity')]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Jump_With_Minimum_Quantity_NoBtn;
	
	@FindBy(xpath = "//h3[contains(.,'Mandatory Modifier Groups')]/../../..//span[contains(.,'Set Tiered Price')]/../../div[2]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Set_Tiered_Price_MandatoryModifier_YesBtn;
		
	@FindBy(xpath = "//h3[contains(.,'Mandatory Modifier Groups')]/../../..//span[contains(.,'Set Tiered Price')]/../../div[2]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Set_Tiered_Price_MandatoryModifier_NoBtn;
	
	@FindBy(xpath = "//h3[contains(.,'Optional Modifier Groups')]/../../..//span[contains(.,'Set Tiered Price')]/../../div[2]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Set_Tiered_Price_OptionalModifier_YesBtn;
		
	@FindBy(xpath = "//h3[contains(.,'Optional Modifier Groups')]/../../..//span[contains(.,'Set Tiered Price')]/../../div[2]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Set_Tiered_Price_OptionalModifier_NoBtn;
	
	@FindBy(xpath = "//app-toggle[contains(.,'Alternate Modifier Group')]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Alternate_Modifier_Group_YesBtn;
		
	@FindBy(xpath = "//app-toggle[contains(.,'Alternate Modifier Group')]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Alternate_Modifier_Group_NoBtn;
	
	public void Click_New_MenuItem()
	{
		New_Menu_ItemBtn.click();
	}
	
	public void Click_New_RetailItem()
	{
		New_Retail_ItemBtn.click();
	}
	
	public void Enter_Secondary_Name(String str) throws Exception
	{
		Thread.sleep(1000);
		Secondary_NameInputBx.clear();
		Thread.sleep(1000);
		Secondary_NameInputBx.sendKeys(str);
	}
	
	public void Enter_PLU_Code(String str) throws Exception
	{
		Thread.sleep(1000);
		PLU_CodeInputBx.clear();
		Thread.sleep(1000);
		PLU_CodeInputBx.sendKeys(str);
	}
	
	public void Enter_Item_Preparation_Time(String str) throws Exception
	{
		Thread.sleep(1000);
		Item_Preparation_TimeInputBx.clear();
		Thread.sleep(1000);
		Item_Preparation_TimeInputBx.sendKeys(str);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//app-input[@name='preparationTime']/div/div/div/button[2]")).click();
	}
	
	public void Enter_Kitchen_Printer_Name(String str) throws Exception
	{
		Thread.sleep(1000);
		Kitchen_Printer_NameInputBx.clear();
		Thread.sleep(1000);
		Kitchen_Printer_NameInputBx.sendKeys(str);
	}
	
	public void Enter_Description(String str) throws Exception
	{
		Thread.sleep(1000);
		Description_TextBx.clear();
		Thread.sleep(1000);
		Description_TextBx.sendKeys(str);
	}
	
	public void Click_Category_LevelType()
	{
		Category_RadioBtn.click();
	}
	
	public WebElement Category_LevelType()
	{
		return Category_RadioBtn;
	}
	
	public void Click_SubCategory_LevelType()
	{
		SubCategory_RadioBtn.click();
	}
	
	public WebElement SubCategory_LevelType()
	{
		return SubCategory_RadioBtn;
	}
	
	public void Select_Category_LevelType() throws Exception
	{
//		Category_RadioBtn.click();
		
		Thread.sleep(1000);
		cmp=new Common_XPaths(driver, test);
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(Category_InputBx);
		
		cmp.Click_Wait_ForElementClickable(Category_InputBx, 60);
		Thread.sleep(1000);
//		Category_InputBx.click();
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
		wait.until(ExpectedConditions.elementToBeClickable(Category_InputBx)).click();
//		CoursingDropBtn.click();
		
		Category_InputBx .click();
		
		Thread.sleep(1000);
		List<WebElement> CategoryList=driver.findElements(By.xpath("//div/select-option"));
		
		int CategorySize=CategoryList.size();
		
		if(CategorySize<=6)
		{
		
		int randomCategory=ThreadLocalRandom.current().nextInt(2, CategorySize);
		
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
		
		cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomCategory+"]/select-option")).getText());
		
		driver.findElement(By.xpath("//div[1]/select-option")).click();
		}
		else
		{
			int randomCategory=ThreadLocalRandom.current().nextInt(1, 6);
			
			Thread.sleep(1000);
//			driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
			
			cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomCategory+"]/select-option")).getText());
			
			driver.findElement(By.xpath("//div[1]/select-option")).click();
		
		}	
		
		List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		
		
		if(menuList1.size()!=0)
		{
			SubCategory_InputBx.click();
		}
	}
	

	public void Select_SubCategory_LevelType() throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(SubCategory_InputBx);
		Thread.sleep(1000);
//		SubCategory_RadioBtn.click();
		cmp.Click_Wait_ForElementClickable(SubCategory_InputBx, 60);
//		SubCategory_InputBx.click();
	
	
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
		wait.until(ExpectedConditions.elementToBeClickable(SubCategory_InputBx)).click();
//		CoursingDropBtn.click();
		
		SubCategory_InputBx.click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();
//		List<WebElement> SubCategoryList=driver.findElements(By.xpath("//div/select-option"));
//		
//		int SubCategorySize=SubCategoryList.size();
//		
//		if(SubCategorySize<=6)
//		{
//		
//		int randomSubCategory=ThreadLocalRandom.current().nextInt(1, SubCategorySize);
//		
//		Thread.sleep(1000);
////		driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
//		
//		cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomSubCategory+"]/select-option")).getText());
//		
//		driver.findElement(By.xpath("//div[1]/select-option")).click();
//		}
//		else
//		{
//			int randomSubCategory=ThreadLocalRandom.current().nextInt(1, 6);
//			
//			Thread.sleep(1000);
////			driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
//			
//			cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomSubCategory+"]/select-option")).getText());
//			
//			driver.findElement(By.xpath("//div[1]/select-option")).click();
//		
//		}
//			else if(menuSize==1)
//			{
//				try
//				{
//				if(driver.findElement(By.xpath("//select-option[contains(.,'No results match')]")).isDisplayed())
//				{
//					
//					test.log(LogStatus.INFO, "Sub Categories not available for Selected Category");
//					
//					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
//					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
//
//					Click_Category_LevelType();
//					Thread.sleep(1000);
//					Select_Category_LevelType();
//					
//				}
//				}
//				catch(Exception e)
//				{
//					driver.findElement(By.xpath("//select-option[1]")).click();
//				}
//			}
//			else if(menuSize>=1 && menuSize<=6)
//			{
//				int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
//		
//		
//				driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomMenu+"]")).click();
//			}
//			else
//			{
//				int randomMenu=ThreadLocalRandom.current().nextInt(1, 6);
//			
//			
//				driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomMenu+"]")).click();
//			
//			}
		
			List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));

			if(menuList1.size()!=0)
			{
				SubCategory_InputBx.click();
			}
		
	}
	
	public void Select_Category_RetailInventoryLevelType() throws Exception
	{
//		Category_RadioBtn.click();
		
		Thread.sleep(1000);
		cmp=new Common_XPaths(driver, test);
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(Category_InputBx);
		
		cmp.Click_Wait_ForElementClickable(Category_RetailInventoryInputBx, 60);
		Thread.sleep(1000);
//		Category_InputBx.click();
		
		Thread.sleep(1000);
	List<WebElement> menuList=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
		
		
		int menuSize=menuList.size();
		
		if(menuSize==0)
		{
			Category_RetailInventoryInputBx.click();
			Thread.sleep(10000);

		List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
			
			
			int menuSize1=menuList1.size();
			
			int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize1);
			
			
			driver.findElement(By.xpath("//div[@class='options with-height']']//div/div["+randomMenu+"]/select-option")).click();
			
			
		}
		else if(menuSize<=6)
		{
		
		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
		
		
		driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
		}
		else
		{
			int randomMenu=ThreadLocalRandom.current().nextInt(1, 6);
			
			
			driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
		
		}
		
		List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));

		
		if(menuList1.size()!=0)
		{
			Category_RetailInventoryInputBx.click();
		}
	}
	

	public void Select_SubCategory_RetailInventoryLevelType() throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(SubCategory_InputBx);
		Thread.sleep(1000);
//		SubCategory_RadioBtn.click();
		cmp.Click_Wait_ForElementClickable(SubCategory_RetailInventoryInputBx, 60);
//		SubCategory_InputBx.click();
	
	
		Thread.sleep(1000);
		List<WebElement> menuList=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
		
			int menuSize=menuList.size();
		
			if(menuSize==0)
			{
				SubCategory_RetailInventoryInputBx.click();
			
			Thread.sleep(1000);
			List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
			
			int menuSize1=menuList1.size();
		
			int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize1);
		
		
			driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
		
			}
			else if(menuSize==1)
			{
				try
				{
				if(driver.findElement(By.xpath("//select-option[contains(.,'No results match')]")).isDisplayed())
				{
					
					test.log(LogStatus.INFO, "Sub Categories not available for Selected Category");
					
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);

					Click_Category_LevelType();
					Thread.sleep(1000);
					Select_Category_RetailInventoryLevelType();
					
				}
				}
				catch(Exception e)
				{
					driver.findElement(By.xpath("//select-option[1]")).click();
				}
			}
			else if(menuSize>=1 && menuSize<=6)
			{
				int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
		
		
				driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
			}
			else
			{
				int randomMenu=ThreadLocalRandom.current().nextInt(1, 6);
			
			
				driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
			
			}
		
			List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));

			if(menuList1.size()!=0)
			{
				SubCategory_RetailInventoryInputBx.click();
			}
		
	}

	
	public void Select_Evertex_TaxType() throws Exception
	{
		Evertex_Tax_TypeInputBx.click();
		
		Thread.sleep(1000);
	List<WebElement> menuList=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
		
		int menuSize=menuList.size();
		
		
		int randomMenu=ThreadLocalRandom.current().nextInt(2, menuSize);
		
		
		driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
		
	}
	
	public void Click_Menu_Item_MenuType()
	{
		MenuItem_MenuType_RadioBtn.click();
	}
	
	public WebElement MenuItem_MenuType()
	{
		return MenuItem_MenuType_RadioBtn;
	}
	
	public void Click_MenuItem_With_ServingSize_MenuType()
	{
		MenuItem_With_ServingSize_MenuType_RadioBtn.click();
	}
	
	public WebElement MenuItem_With_ServingSize_MenuType()
	{
		return MenuItem_With_ServingSize_MenuType_RadioBtn;
	}
	
	public void Click_OpenItem_MenuType()
	{
		OpenItem_MenuType_RadioBtn.click();
	}
	
	public WebElement OpenItem_MenuType()
	{
		return OpenItem_MenuType_RadioBtn;
	}
	
	public void Click_ScaleItem_MenuType()
	{
		ScaleItem_MenuType_RadioBtn.click();
	}
	
	public WebElement ScaleItem_MenuType()
	{
		return ScaleItem_MenuType_RadioBtn;
	}
	
	public void Click_ComboItem_MenuType()
	{
		ComboItem_MenuType_RadioBtn.click();
	}
	
	public WebElement ComboItem_MenuType()
	{
		return ComboItem_MenuType_RadioBtn;
	}
	
	public void Click_Fixed_CostType()
	{
		Fixed_Cost_TypeRadioBtn.click();
	}
	
	public WebElement Fixed_CostType()
	{
		return Fixed_Cost_TypeRadioBtn;
	}
	
	public void Click_Variable_CostType()
	{
		Variable_Cost_TypeRadioBtn.click();
	}
	
	public WebElement Variable_CostType()
	{
		return Variable_Cost_TypeRadioBtn;
	}
	
	public void Select_Serving_Size_For_Fixed_CostType() throws Exception
	{
		Fixed_Cost_TypeRadioBtn.click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//form[@id='pricingCostForm']/div/div/div/div/app-selectbox/div/mat-form-field/div/div/div[3]/input")).click();

		Thread.sleep(1000);
	List<WebElement> menuList=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
		
		int menuSize=menuList.size();
	
		if(menuSize==0)
		{
		
			driver.findElement(By.xpath("//form[@id='pricingCostForm']/div/div/div/div/app-selectbox/div/mat-form-field/div/div/div[3]/input")).click();

			Thread.sleep(1000);
		List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
			
			int menuSize1=menuList1.size();
		
		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize1);
		
		
		driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
		}
		else if(menuSize==1)
		{
			driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();

		}
		else
		{
			int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
			
			
			driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
			
		}
		
		
	
	//Enter the cost
		driver.findElement(By.xpath("//form[@id='pricingCostForm']/div/div/div/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//form[@id='pricingCostForm']/div/div/div/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")).sendKeys("5000");
		
		
		//Enter the Price
		driver.findElement(By.xpath("//app-input[@name='priceStr']/div/div/mat-form-field/div/div/div[4]/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//app-input[@name='priceStr']/div/div/mat-form-field/div/div/div[4]/input")).sendKeys("20000");
		
		
		
	
	}
	
	public void Select_Serving_MenuItem_With_ServingSize_Fixed_CostType() throws Exception
	{
		Fixed_Cost_TypeRadioBtn.click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//form[@id='pricingCostForm']/div/div/div/div/app-selectbox/div/mat-form-field/div/div/div[3]/input")).click();

//		Thread.sleep(1000);
//	List<WebElement> menuList=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
//		
//		int menuSize=menuList.size();
//		
//		
//		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
		
		
//		driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
		
		driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//form[@id='pricingCostForm']/div/div/div/div[2]//input")).clear();
	Thread.sleep(1000);
	driver.findElement(By.xpath("//form[@id='pricingCostForm']/div/div/div/div[2]//input")).sendKeys("6");
	
	Thread.sleep(1000);
	driver.findElement(By.xpath("//form[@id='pricingCostForm']/div/div/div/div[3]//input")).clear();
	driver.findElement(By.xpath("//form[@id='pricingCostForm']/div/div/div/div[3]//input")).sendKeys("PLU0008");
	
	//Enter the cost
		driver.findElement(By.xpath("//form[@id='pricingCostForm']/div/div/div/div[4]//input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//form[@id='pricingCostForm']/div/div/div/div[4]//input")).sendKeys("5000");
		
		
		//Enter the Price
		driver.findElement(By.xpath("//app-input[@name='priceStr']/div/div/mat-form-field/div/div/div[4]/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//app-input[@name='priceStr']/div/div/mat-form-field/div/div/div[4]/input")).sendKeys("20000");
		
		
		
	
	}
	
	
	public void Select_Serving_Size_For_Variable_CostType() throws Exception
	{
		Thread.sleep(1000);
		Variable_Cost_TypeRadioBtn.click();
		
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//form[@id='pricingCostForm']/div/div/div/div/app-selectbox/div/mat-form-field/div/div/div[3]/input")).click();

		Thread.sleep(2000);
	List<WebElement> menuList=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
		
	if(menuList.size()>1)
	{
		int menuSize=menuList.size();
		
		
		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
		
		
		driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
	
	}
	else
	{
		driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();
	}
	
	//Enter the cost
		driver.findElement(By.xpath("//app-input[@name='priceStr']/div/div/mat-form-field/div/div/div[4]/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//app-input[@name='priceStr']/div/div/mat-form-field/div/div/div[4]/input")).sendKeys("15000");
		
	}
	
	public void Select_Serving_Size_MenuItem_With_ServingSize_Variable_CostType() throws Exception
	{
		Variable_Cost_TypeRadioBtn.click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//form[@id='pricingCostForm']/div/div/div/div/app-selectbox/div/mat-form-field/div/div/div[3]/input")).click();

		Thread.sleep(1000);
	List<WebElement> menuList=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
		
	if(menuList.size()>1)
	{
		int menuSize=menuList.size();
		
		
		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
		
		
		driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
	
	}
	else
	{
		driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();
	}
	//Enter the S No
		driver.findElement(By.xpath("//form[@id='pricingCostForm']/div/div/div/div[2]//input")).clear();
		driver.findElement(By.xpath("//form[@id='pricingCostForm']/div/div/div/div[2]//input")).sendKeys("2");
		
		
		//Enter the PLU Code
		driver.findElement(By.xpath("//form[@id='pricingCostForm']/div/div/div/div[3]//input")).clear();
		driver.findElement(By.xpath("//form[@id='pricingCostForm']/div/div/div/div[3]//input")).sendKeys("PLU01");
		
	
	//Enter the cost
		driver.findElement(By.xpath("//app-input[@name='priceStr']/div/div/mat-form-field/div/div/div[4]/input")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//app-input[@name='priceStr']/div/div/mat-form-field/div/div/div[4]/input")).sendKeys("15000");
		
	}
	
	
	@FindBy(xpath = "//button[contains(.,'Add Price Level')]")
	WebElement Add_Price_LevelBtn;
	
	
	public void Click_Add_Price_Level()
	{
		Add_Price_LevelBtn.click();
	}
	
	public void Enter_Add_Price_Level(String str) throws Exception
	{
		Thread.sleep(1000);
		Enable_Price_Level_Settings();
		
		Thread.sleep(1000);
		for(int i=1;i<=4;i++)
		{
			Thread.sleep(1000);
		Add_Price_LevelBtn.click();
		}
		
		Thread.sleep(1000);
		for(int i=1;i<=4;i++)
		{
			Thread.sleep(1000);

			driver.findElement(By.xpath("//form[@id='pricingCostForm']//div[contains(@class,'price-level-data')]["+i+"]/div[2]/div/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")).clear();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//form[@id='pricingCostForm']//div[contains(@class,'price-level-data')]["+i+"]/div[2]/div/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")).sendKeys(str);
		}
		
		for(int i=3;i<=4;i++)
		{
			Thread.sleep(1000);

			driver.findElement(By.xpath("//form[@id='pricingCostForm']//div[contains(@class,'price-level-data')]["+i+"]/div[2]/div/div[3]/button")).click();
		}
	}
	
	@FindBy(xpath = "//button[contains(.,'Add Menu Item')]")
	WebElement Add_Menu_ItemBtn;
	
	public void Click_Add_Menu_Item()
	{
		Add_Menu_ItemBtn.click();
	}
	
	public void Enter_Combo_Item(String st1, String st2) throws Exception
	{
		Thread.sleep(1000);
		for(int i=1;i<=4;i++)
		{
			Thread.sleep(1000);
			Add_Menu_ItemBtn.click();
		}
		
		
		
		Thread.sleep(1000);
		for(int i=1;i<=4;i++)
		{
			driver.findElement(By.xpath("//form[@id='comboForm']//div[contains(@class,'combo-config-data')]["+i+"]/div[1]/app-selectbox/div/mat-form-field/div/div/div[3]/input")).click();
			
			Thread.sleep(1000);
			List<WebElement> menuList=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
				
			if(menuList.size()>1)
			{
				int menuSize=menuList.size();
				
				
				int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
				
				try {
				driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
				}
				
				catch (Exception e) {
					driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();
				}
			}
			
			else
			{
				driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();
			}
				
				Thread.sleep(1000);
				
				driver.findElement(By.xpath("//form[@id='comboForm']//div[contains(@class,'combo-config-data')]["+i+"]/div[2]/app-selectbox/div/mat-form-field/div/div/div[3]/input")).click();
				
				Thread.sleep(1000);
				List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
					
				if(menuList.size()>1)
				{
					int menuSize=menuList.size();
					
					
					int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
					try {
					
					driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
					}
					catch (Exception e)
					{
						driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();
					}
				}
				else
				{
					driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();
				}
					
					Thread.sleep(1000);
					driver.findElement(By.xpath("//form[@id='comboForm']//div[contains(@class,'combo-config-data')]["+i+"]/div[3]/app-input/div/div/mat-form-field/div/div/div[4]/input")).clear();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//form[@id='comboForm']//div[contains(@class,'combo-config-data')]["+i+"]/div[3]/app-input/div/div/mat-form-field/div/div/div[4]/input")).sendKeys(st1);
					
					Thread.sleep(1000);
					driver.findElement(By.xpath("//form[@id='comboForm']//div[contains(@class,'combo-config-data')]["+i+"]/div[4]//app-input/div/div/mat-form-field/div/div/div[4]/input")).clear();
					Thread.sleep(1000);
					driver.findElement(By.xpath("//form[@id='comboForm']//div[contains(@class,'combo-config-data')]["+i+"]/div[4]//app-input/div/div/mat-form-field/div/div/div[4]/input")).sendKeys(st2);
		}
		
		for(int i=2;i<=4;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//form[@id='comboForm']//div[contains(@class,'combo-config-data')]["+i+"]/div[4]/div/div/button")).click();
		}
		
	}
	
	public void Enable_Price_Level_Settings()
	{
		if(Price_Level_Settings_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Price_Level_Settings_YesBtn.click();
		}
	}
	
	public void Disable_Price_Level_Settings()
	{
		if(Price_Level_Settings_YesBtn.isEnabled()) 
		{
			Price_Level_Settings_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	public WebElement Price_Level_Settings_Yes()
	{
		return Price_Level_Settings_YesBtn;
	}
	
	
	public void Enable_Hide_In_Kiosk()
	{
		if(Hide_In_Kiosk_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Hide_In_Kiosk_YesBtn.click();
		}
	}
	
	public void Disable_Hide_In_Kiosk()
	{
		if(Hide_In_Kiosk_YesBtn.isEnabled()) 
		{
			Hide_In_Kiosk_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	
	public void Enable_Hide_In_POS()
	{
		if(Hide_In_POS_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Hide_In_POS_YesBtn.click();
		}
	}
	
	public void Disable_Hide_In_POS()
	{
		if(Hide_In_POS_YesBtn.isEnabled()) 
		{
			Hide_In_POS_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	public void Enable_Eighty_Six_List()
	{
		if(Eighty_Six_List_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Eighty_Six_List_YesBtn.click();
		}
	}
	
	public void Disable_Eighty_Six_List()
	{
		if(Eighty_Six_List_YesBtn.isEnabled()) 
		{
			Eighty_Six_List_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	public void Enable_EBT_Menu_Item()
	{
		if(EBT_Menu_Item_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			EBT_Menu_Item_YesBtn.click();
		}
	}
	
	public void Disable_EBT_Menu_Item()
	{
		if(EBT_Menu_Item_YesBtn.isEnabled()) 
		{
			EBT_Menu_Item_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	
	public void Enable_Hide_In_Online_Order()
	{
		try
		{
		if(Hide_In_Online_Order_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Hide_In_Online_Order_YesBtn.click();
		}
		
		}
		catch(Exception l)
		{
			if(driver.findElement(By.xpath("//app-toggle[contains(.,'Hide in Online Order')]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")).isSelected())
			{
				
			}
			else
			{
				driver.findElement(By.xpath("//app-toggle[contains(.,'Hide in Online Order')]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")).click();
			}
		}
	}
	
	public void Disable_Hide_In_Online_Order()
	{
		try
		{
		if(Hide_In_Online_Order_YesBtn.isEnabled()) 
		{
			Hide_In_Online_Order_NoBtn.click();
		}
		else
		{
		
		}
		}
		catch(Exception l)
		{
			if(driver.findElement(By.xpath("//span[contains(.,'Hide in Online Order')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")).isEnabled())
			{
				driver.findElement(By.xpath("//span[contains(.,'Hide in Online Order')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")).click();
			}
			else
			{
				
			}
		}
	}
	
	public WebElement Hide_In_Online_Order_Yes_Retail()
	{
		return driver.findElement(By.xpath("//span[contains(.,'Hide in Online Order')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]"));
	}
	
	
	public void Enable_Meito_MenuItem()
	{
		if(Meito_MenuItem_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Meito_MenuItem_YesBtn.click();
		}
	}
	
	public void Disable_Meito_MenuItem()
	{
		if(Meito_MenuItem_YesBtn.isEnabled()) 
		{
			Meito_MenuItem_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	public void Enable_Conversational_UI_atPOS()
	{
		if(Conversational_UI_atPOS_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Conversational_UI_atPOS_YesBtn.click();
		}
	}
	
	public void Disable_Conversational_UI_atPOS()
	{
		if(Conversational_UI_atPOS_YesBtn.isEnabled()) 
		{
			Conversational_UI_atPOS_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	public WebElement Conversational_UI_atPOS_Yes()
	{
		return Conversational_UI_atPOS_YesBtn;
	}
	
	public WebElement Cut_And_Modify_Yes()
	{
		return Cut_And_Modify_YesBtn;
	}
	
	public void Enable_Cut_And_Modify()
	{
		if(Cut_And_Modify_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Cut_And_Modify_YesBtn.click();
		}
	}
	
	public void Disable_Cut_And_Modify()
	{
		if(Cut_And_Modify_YesBtn.isEnabled()) 
		{
			Cut_And_Modify_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	@FindBy(xpath = "//label[contains(.,'Slices')]/../../input")
	WebElement Slice_CutAndModify_InputBx;
	
	public void Enter_Slices_CutAndModify(String str) throws Exception
	{
		Thread.sleep(1000);
		Slice_CutAndModify_InputBx.clear();
		Thread.sleep(1000);
		Slice_CutAndModify_InputBx.sendKeys(str);
	}
	
	@FindBy(xpath = "//div[@id='new-menu-item-mandatoryModifierGroups']//button[contains(.,'Set Tiered Price')]")
	WebElement Set_Tiered_Price_MandatoryModiBtn;
	
	@FindBy(xpath = "//div[@id='new-menu-item-optModifierGroups']//button[contains(.,'Set Tiered Price')]")
	WebElement Set_Tiered_Price_OptionalModiBtn;
	
	@FindBy(xpath = "//button[contains(.,'Add Shift')]")
	WebElement Add_ShiftBtn;
	
	@FindBy(xpath = "//button[contains(.,'Add tiered price')]")
	WebElement Add_Tiered_PriceBtn;
	
	
	public void Enable_Jump_With_Minimum_Quantity()
	{
		if(Jump_With_Minimum_Quantity_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Jump_With_Minimum_Quantity_YesBtn.click();
		}
	}
	
	public void Disable_Jump_With_Minimum_Quantity()
	{
		if(Jump_With_Minimum_Quantity_YesBtn.isEnabled()) 
		{
			Jump_With_Minimum_Quantity_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	public void Enable_Set_Tiered_Price_MandatoryModifier()
	{
		if(Set_Tiered_Price_MandatoryModifier_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Set_Tiered_Price_MandatoryModifier_YesBtn.click();
		}
	}
	
	public void Disable_Set_Tiered_Price_MandatoryModifier()
	{
		if(Set_Tiered_Price_MandatoryModifier_YesBtn.isEnabled()) 
		{
			Set_Tiered_Price_MandatoryModifier_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	public void Enable_Set_Tiered_Price_OptionalModifier()
	{
		if(Set_Tiered_Price_OptionalModifier_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Set_Tiered_Price_OptionalModifier_YesBtn.click();
		}
	}
	
	public void Disable_Set_Tiered_Price_OptionalModifier()
	{
		if(Set_Tiered_Price_OptionalModifier_YesBtn.isEnabled()) 
		{
			Set_Tiered_Price_OptionalModifier_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	public void Enable_Alternate_Modifier_Group() throws Exception
	{
		if(Alternate_Modifier_Group_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Thread.sleep(1000);
			Alternate_Modifier_Group_YesBtn.click();
		}
	}
	
	public void Disable_Alternate_Modifier_Group()
	{
		if(Alternate_Modifier_Group_YesBtn.isEnabled()) 
		{
			Alternate_Modifier_Group_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	@FindBy(xpath = "//input[@placeholder='Select Alternate Modifier']")
	WebElement Alternate_Modifier_GroupInputBx;
	
	@FindBy(xpath = "//input[@placeholder='Select Modifier']")
	WebElement Modifier_IncludeModifier_InputBx;
	
	@FindBy(xpath = "//div[@id='new-menu-item-includedModifiers']//input[@placeholder='Select Modifier Group']")
	WebElement ModifierGroup_IncludeModifier_InputBx;
	
	@FindBy(xpath = "//div[@id='new-menu-item-mandatoryModifierGroups']//input[@placeholder='Select Modifier Group']")
	WebElement ModifierGroup_MandatoryModifier_InputBx;
	
	@FindBy(xpath = "//div[@id='new-menu-item-optModifierGroups']//input[@placeholder='Select Modifier Group']")
	WebElement ModifierGroup_OptionalModifier_InputBx;
	
	@FindBy(xpath = "//h3[contains(.,'Mandatory Modifier Groups')]/../../..//label[contains(.,'Display Order')]/../../input")
	WebElement Display_Order_MandatoryModifier_InputBx;
	
	@FindBy(xpath = "//h3[contains(.,'Optional Modifier Groups')]/../../..//label[contains(.,'Display Order')]/../../input")
	WebElement Display_Order_OptionalModifier_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Minimum Quantity')]/../../input")
	WebElement Minimum_Quantity_MandatoryModifierInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Maximum Quantity')]/../../input")
	WebElement Maximum_Quantity_MandatoryModifierInputBx;
	
	
	
	
	
	public void Select_ModifierGroup_Include_Modifiers() throws Exception
	{
		Thread.sleep(1000);
	//	ModifierGroup_IncludeModifier_InputBx.click();
		
		cmp.Click_Wait_ForElementClickable(ModifierGroup_IncludeModifier_InputBx, 60);
		Thread.sleep(1000);
//		Category_InputBx.click();
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
		wait.until(ExpectedConditions.elementToBeClickable(ModifierGroup_IncludeModifier_InputBx)).click();
//		CoursingDropBtn.click();
		
		ModifierGroup_IncludeModifier_InputBx .click();
		
		Thread.sleep(1000);
		List<WebElement> ModifierList=driver.findElements(By.xpath("//div/select-option"));
		
		int ModifierSize=ModifierList.size();
		
		if(ModifierSize<=6)
		{
		
		int randomModifier=ThreadLocalRandom.current().nextInt(2, ModifierSize);
		
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
		
		cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomModifier+"]/select-option")).getText());
		
		driver.findElement(By.xpath("//div[1]/select-option")).click();
		}
		else
		{
			int randomModifier=ThreadLocalRandom.current().nextInt(1, 6);
			
			Thread.sleep(1000);
//			driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
			
			cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomModifier+"]/select-option")).getText());
			
			driver.findElement(By.xpath("//div[1]/select-option")).click();
		
		}	
		
		List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		
		
		if(menuList1.size()!=0)
		{
			ModifierGroup_IncludeModifier_InputBx.click();
		}
				
	}
	
	
	public void Select_Alternate_ModifierGroup() throws Exception
	{
		Thread.sleep(1000);
		Enable_Alternate_Modifier_Group();
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
		wait.until(ExpectedConditions.elementToBeClickable(Alternate_Modifier_GroupInputBx)).click();
//		CoursingDropBtn.click();
		
		//Alternate_Modifier_GroupInputBx .click();
		
		Thread.sleep(1000);
		List<WebElement> ModifierList=driver.findElements(By.xpath("//div/select-option"));
		
		int ModifierSize=ModifierList.size();
		
		if(ModifierSize<=6)
		{
		
		int randomModifier=ThreadLocalRandom.current().nextInt(2, ModifierSize);
		
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
		
		cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomModifier+"]/select-option")).getText());
		
		driver.findElement(By.xpath("//div[1]/select-option")).click();
		}
		else
		{
			int randomModifier=ThreadLocalRandom.current().nextInt(1, 6);
			
			Thread.sleep(1000);
//			driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
			
			cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomModifier+"]/select-option")).getText());
			
			driver.findElement(By.xpath("//div[1]/select-option")).click();
		
		}	
		
		List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		
		
		if(menuList1.size()!=0)
		{
			Alternate_Modifier_GroupInputBx.click();
		}
	}
	
	public WebElement Alternate_Modifier_Group_Yes()
	{
		return Alternate_Modifier_Group_YesBtn;
	}
	
	public void Delete_Include_Modifiers()
	{
		List<WebElement> listIncludeModiGrp=driver.findElements(By.xpath("//app-segmentation[@name='includedModifierSegment']/div/div[1]/div/div/button/span/div/div"));
		
		
		if(listIncludeModiGrp.size()>=1)
		{
			for(int i=2;i<=listIncludeModiGrp.size();i++)
			{
			driver.findElement(By.xpath("//app-segmentation[@name='includedModifierSegment']/div/div[1]/div/div["+i+"]/button/span/div/div")).click();
		
			}
		}
		else
		{
			
		}
	}
	
	
	public void Select_ModifierGroup_Mandatory_Modifiers() throws Exception
	{
		Thread.sleep(1000);
	//	ModifierGroup_MandatoryModifier_InputBx.click();
		
		cmp.Click_Wait_ForElementClickable(ModifierGroup_MandatoryModifier_InputBx, 60);
		Thread.sleep(1000);
//		Category_InputBx.click();
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
		wait.until(ExpectedConditions.elementToBeClickable(ModifierGroup_MandatoryModifier_InputBx)).click();
//		CoursingDropBtn.click();
		
		ModifierGroup_MandatoryModifier_InputBx .click();
		
		Thread.sleep(1000);
		List<WebElement> ModifierList=driver.findElements(By.xpath("//div/select-option"));
		
		int ModifierSize=ModifierList.size();
		
		if(ModifierSize<=6)
		{
		
		int randomModifier=ThreadLocalRandom.current().nextInt(2, ModifierSize);
		
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
		
		cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomModifier+"]/select-option")).getText());
		
		driver.findElement(By.xpath("//div[1]/select-option")).click();
		}
		else
		{
			int randomModifier=ThreadLocalRandom.current().nextInt(1, 6);
			
			Thread.sleep(1000);
//			driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
			
			cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomModifier+"]/select-option")).getText());
			
			driver.findElement(By.xpath("//div[1]/select-option")).click();
		
		}	
		
		List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		
		
		if(menuList1.size()!=0)
		{
			ModifierGroup_MandatoryModifier_InputBx.click();
		}
		
	}
	
	public void Select_ModifierGroup_Optional_Modifiers() throws Exception
	{
		Thread.sleep(1000);
		Add_Optional_Modifier_GroupBtn.click();
		
	//	ModifierGroup_OptionalModifier_InputBx.click();
		
		cmp.Click_Wait_ForElementClickable(ModifierGroup_OptionalModifier_InputBx, 60);
		Thread.sleep(1000);
//		Category_InputBx.click();
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
		wait.until(ExpectedConditions.elementToBeClickable(ModifierGroup_OptionalModifier_InputBx)).click();
//		CoursingDropBtn.click();
		
		ModifierGroup_OptionalModifier_InputBx .click();
		
		Thread.sleep(1000);
		List<WebElement> ModifierList=driver.findElements(By.xpath("//div/select-option"));
		
		int ModifierSize=ModifierList.size();
		
		if(ModifierSize<=6)
		{
		
		int randomModifier=ThreadLocalRandom.current().nextInt(2, ModifierSize);
		
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
		
		cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomModifier+"]/select-option")).getText());
		
		driver.findElement(By.xpath("//div[1]/select-option")).click();
		}
		else
		{
			int randomModifier=ThreadLocalRandom.current().nextInt(1, 6);
			
			Thread.sleep(1000);
//			driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
			
			cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomModifier+"]/select-option")).getText());
			
			driver.findElement(By.xpath("//div[1]/select-option")).click();
		
		}	
		
		List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		
		
		if(menuList1.size()!=0)
		{
			ModifierGroup_OptionalModifier_InputBx.click();
		}
		
	}
	
	public void Enter_Display_Order_MandatoryModifier(String str) throws Exception
	{
		Thread.sleep(1000);
		Display_Order_MandatoryModifier_InputBx.clear();
		Thread.sleep(1000);
		Display_Order_MandatoryModifier_InputBx.sendKeys(str);
		
	}
	
	public void Enter_Display_Order_OptionalModifier(String str) throws Exception
	{
		Thread.sleep(1000);
		Display_Order_OptionalModifier_InputBx.clear();
		Thread.sleep(1000);
		Display_Order_OptionalModifier_InputBx.sendKeys(str);
		
	}
	
	public void Enter_Minimum_Quantity_MandatoryModifier(String str) throws Exception
	{
		Thread.sleep(1000);
		Minimum_Quantity_MandatoryModifierInputBx.clear();
		Thread.sleep(1000);
		Minimum_Quantity_MandatoryModifierInputBx.sendKeys(str);
		
		driver.findElement(By.xpath("//app-input[@name='minQuantity']/div/div/div/button[1]")).click();
		
	}
	
	public void Enter_Maximum_Quantity_MandatoryModifier(String str) throws Exception
	{
		Thread.sleep(1000);
		Maximum_Quantity_MandatoryModifierInputBx.clear();
		Thread.sleep(1000);
		Maximum_Quantity_MandatoryModifierInputBx.sendKeys(str);
		
		driver.findElement(By.xpath("//app-input[@name='maxQuantity']/div/div/div/button[1]")).click();
		
	}
	
	@FindBy(xpath = "//div[@id='new-menu-item-mandatoryModifierGroups']//app-selectbox[@label='Serving Size']/div/mat-form-field/div/div/div[3]/input")
	WebElement Serving_Size_Set_Tiered_Price_MandatoryModiInputBx;
	
	@FindBy(xpath = "//div[@id='new-menu-item-optModifierGroups']//app-selectbox[@name='servingSize']/div/mat-form-field/div/div/div[3]/input")
	WebElement Serving_Size_Set_Tiered_Price_OptionalModiInputBx;
	
	public void Select_Set_Tiered_Price_MandatoryModifier() throws Exception
	{
		Enable_Set_Tiered_Price_MandatoryModifier();
		
		Thread.sleep(1000);
		Set_Tiered_Price_MandatoryModiBtn.click();
		
		Serving_Size_Set_Tiered_Price_MandatoryModiInputBx.click();
		
		cmp.Click_Wait_ForElementClickable(Serving_Size_Set_Tiered_Price_MandatoryModiInputBx, 60);
		Thread.sleep(1000);
//		Category_InputBx.click();
		
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
		wait.until(ExpectedConditions.elementToBeClickable(Serving_Size_Set_Tiered_Price_MandatoryModiInputBx)).click();
//		CoursingDropBtn.click();
		
		Serving_Size_Set_Tiered_Price_MandatoryModiInputBx .click();
		try {
		Thread.sleep(1000);
		List<WebElement> ModifierList=driver.findElements(By.xpath("//div/select-option"));
		
		int ModifierSize=ModifierList.size();
		
		if(ModifierSize<=6)
		{
		
		int randomModifier=ThreadLocalRandom.current().nextInt(2, ModifierSize);
		
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
		
		cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomModifier+"]/select-option")).getText());
		
		driver.findElement(By.xpath("//div[1]/select-option")).click();
		}
		
		
		else
		{
			int randomModifier=ThreadLocalRandom.current().nextInt(1, 6);
			
			Thread.sleep(1000);
//			driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
			
			cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomModifier+"]/select-option")).getText());
			
			driver.findElement(By.xpath("//div[1]/select-option")).click();
		
		}	
		
		List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		
		
		if(menuList1.size()!=0)
		{
			ModifierGroup_MandatoryModifier_InputBx.click();
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	

	public void Select_Set_Tiered_Price_OptionalModifier() throws Exception
	{
		Common_XPaths cmp=new Common_XPaths(driver, test);
		Enable_Set_Tiered_Price_OptionalModifier();
		
		Thread.sleep(1000);
		try {
		Set_Tiered_Price_OptionalModiBtn.click();
		
		Serving_Size_Set_Tiered_Price_OptionalModiInputBx.click();
		
		Thread.sleep(1000);
		List<WebElement> menuList=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
			
			int menuSize=menuList.size();
			
			if(menuSize==0)
			{
				Serving_Size_Set_Tiered_Price_OptionalModiInputBx.click();
				
				Thread.sleep(1000);
				List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
					
					int menuSize1=menuList1.size();
					
					int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize1);
					
					
					driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
				
				
			}
			else if(menuSize==1)
			{
				driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+menuSize+"]/select-option")).click();
	
			}
			else
			{
			int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
			
			
			driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
			}
			
			
			
			for(int i=1;i<=3;i++)
			{
			Thread.sleep(1000);
			Add_Tiered_PriceBtn.click();
			}
			List<WebElement> shiftList=driver.findElements(By.xpath("//div[@id='new-menu-item-optModifierGroups']//div[@class='editable-data-grid']/div"));
			
			for(int i=2;i<=shiftList.size();i++)
			{
				driver.findElement(By.xpath("//div[@id='new-menu-item-optModifierGroups']//div[@class='editable-data-grid']/div["+i+"]/div[2]//input")).clear();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@id='new-menu-item-optModifierGroups']//div[@class='editable-data-grid']/div["+i+"]/div[2]//input")).sendKeys("10");
				
				
				driver.findElement(By.xpath("//div[@id='new-menu-item-optModifierGroups']//div[@class='editable-data-grid']/div["+i+"]/div[3]//input")).click();
				
				Thread.sleep(1000);
				List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
					
					int menuSize1=menuList1.size();
					
					if(menuSize1==0)
					{
						driver.findElement(By.xpath("//div[@id='new-menu-item-optModifierGroups']//div[@class='editable-data-grid']/div["+i+"]/div[3]//input")).click();
						
						Thread.sleep(1000);
						List<WebElement> menuList11=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
							
							int menuSize11=menuList11.size();
							
						int randomMenu1=ThreadLocalRandom.current().nextInt(1, menuSize11);
						
						
						driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu1+"]/select-option")).click();
					
					}
					else if(menuSize1==1)
					{
						driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+menuSize1+"]/select-option")).click();
		
					}
					else
					{
					int randomMenu1=ThreadLocalRandom.current().nextInt(1, menuSize1);
					
					
					driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomMenu1+"]")).click();
					}
				
				driver.findElement(By.xpath("//div[@id='new-menu-item-optModifierGroups']//div[@class='editable-data-grid']/div["+i+"]/div[4]//input")).clear();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@id='new-menu-item-optModifierGroups']//div[@class='editable-data-grid']/div["+i+"]/div[4]//input")).sendKeys("10000");
				
				
				
			}
			
			
			Thread.sleep(1000);
			for(int i=3;i<=shiftList.size();i++)
			{
				Thread.sleep(1000);
//				driver.findElement(By.xpath("//div[@id='new-menu-item-optModifierGroups']//div[@class='editable-data-grid']/div["+i+"]/div[5]/button")).click();
				driver.findElement(By.xpath("//div[@id='new-menu-item-optModifierGroups']//div[@class='editable-data-grid']/div[3]/div[5]/button")).click();
	
				Thread.sleep(1000);
				cmp.Click_DeleteButton();
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}

	@FindBy(xpath = "//p[contains(.,'Enter Display Order')]")
	WebElement Display_OrderErrorMsg;
	
	@FindBy(xpath = "//p[contains(.,'Enter Minimum Quantity')]")
	WebElement Minimum_QuantityErrorMsg;
	
	@FindBy(xpath = "//p[contains(.,'Enter Maximum Quantity')]")
	WebElement Maximum_QuantityErrorMsg;
	
	public void Verify_Enter_Display_OrderErrorMessage()
	{
		try
		{
			if(Display_OrderErrorMsg.isDisplayed())
			{
				test.log(LogStatus.PASS, "Enter Display Order Displayed");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.FAIL, "Enter Display Order not Displayed");
		}
	}
	
	public void Verify_Enter_Minimum_QuantityErrorMessage()
	{
		try
		{
			if(Minimum_QuantityErrorMsg.isDisplayed())
			{
				test.log(LogStatus.PASS, "Enter Minimum Quantity Displayed");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.FAIL, "Enter Minimum Quantity not Displayed");
		}
	}
	
	public void Verify_Enter_Maximum_QuantityErrorMessage()
	{
		try
		{
			if(Maximum_QuantityErrorMsg.isDisplayed())
			{
				test.log(LogStatus.PASS, "Enter Maximum Quantity Displayed");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.FAIL, "Enter Maximum Quantity not Displayed");
		}
	}
	
	
	@FindBy(xpath = "//mat-step-header[contains(.,'Basic Details')]")
	WebElement Basic_DetailsTab;
	

	@FindBy(xpath = "//mat-step-header[contains(.,'Included Modifiers')]")
	WebElement Included_ModifiersTab;
	

	@FindBy(xpath = "//mat-step-header[contains(.,'Mandatory Modifier Groups')]")
	WebElement Mandatory_ModifierGroupsTab;
	

	@FindBy(xpath = "//mat-step-header[contains(.,'Optional Modifier Groups')]")
	WebElement Optional_ModifierGroupsTab;
	

	@FindBy(xpath = "//mat-step-header[contains(.,'Inventory Details')]")
	WebElement Inventory_DetailsTab;
	
	public void Click_Basic_DetailsTab()
	{
		Basic_DetailsTab.click();
	}
	
	public void Click_Included_ModifiersTab()
	{
		Included_ModifiersTab.click();
	}
	
	public void Click_Mandatory_ModifierGroupsTab()
	{
		Mandatory_ModifierGroupsTab.click();
	}
	
	public void Click_Optional_ModifierGroupsTab()
	{
		Optional_ModifierGroupsTab.click();
	}
	
	public void Click_Inventory_DetailsTab()
	{
		Inventory_DetailsTab.click();
	}
	
	public void Click_Add_Include_Modifiers()
	{
		Add_Included_ModifiersBtn.click();
	}
	
	public void Click_Add_Mandatory_ModifierGroup()
	{
		Add_Mandatory_Modifier_GroupBtn.click();
	}
	
	public void Click_Add_Optional_ModifierGroup()
	{
		Add_Optional_Modifier_GroupBtn.click();
	}
	
	@FindBy(xpath = "//div[contains(@class,'cursor-pointer')]/span[contains(.,'Add Inventory Item')]")
	WebElement Add_Inventory_ItemBtn;
	
	@FindBy(xpath = "//div[contains(@class,'cursor-pointer')]/span[contains(.,'Add Sub-Recipe')]")
	WebElement Add_SubRecipeBtn;
	
	@FindBy(xpath = "//div[contains(@class,'cursor-pointer')]/span[contains(.,'Add Manual Entry')]")
	WebElement Add_Manual_EntryBtn;
	
	
	public void Add_Inventory_Item() throws Exception
	{
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
		Add_Inventory_ItemBtn.click();
		}
		
		
	//Level - 	//div[contains(@class,'selected-inventory-item')]/../div[3]/div/div[1]//input
	//Category - 	//div[contains(@class,'selected-inventory-item')]/../div[3]/div/div[2]//input
	//Sub-Catgeory- //div[contains(@class,'selected-inventory-item')]/../div[3]/div/div[3]//input
		//Item - 	//div[contains(@class,'selected-inventory-item')]/../div[3]/div/div[4]//input
		//Recipe Unit - //div[contains(@class,'selected-inventory-item')]/../div[3]/div/div[5]//input
		//Unit Price - //div[contains(@class,'selected-inventory-item')]/../div[3]/div/div[6]
		//Quantity -//div[contains(@class,'selected-inventory-item')]/../div[3]/div/div[7]//input
		//Cost -//div[contains(@class,'selected-inventory-item')]/../div[3]/div/div[8]/span
		
		//Delete - //div[contains(@class,'selected-inventory-item')]/../div[3]/div[2]/button
		
	}
	
	
	//////////////// Retail Item /////////////////////
	@FindBy(xpath = "//label[contains(.,'Level')]/../../input")
	WebElement Level_RetailItemInputBx;
	
	@FindBy(xpath = "(//div[.='Standard Item'])[3]")
	WebElement Standard_Item_RadioBtn;
	
	@FindBy(xpath = "(//div[.='Item With Variants'])[3]")
	WebElement Item_With_Variants_RadioBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][.='Kit/Assembly']")
	WebElement Composite_Item_RadioBtn;
	
	public void Click_Standard_Item_ProductType()
	{
		Standard_Item_RadioBtn.click();
	}
	
	public WebElement Standard_Item_ProductType()
	{
		return Standard_Item_RadioBtn;
	}
	
	public void Click_Item_With_Variants_ProductType()
	{
		Item_With_Variants_RadioBtn.click();
	}
	
	public WebElement Item_With_Variants_ProductType()
	{
		return Item_With_Variants_RadioBtn;
	}
	
	public void Click_Composite_Item_ProductType()
	{
		Composite_Item_RadioBtn.click();
	}
	
	public WebElement Composite_Item_ProductType()
	{
		return Composite_Item_RadioBtn;
	}
	
	public void Click_Category_LevelTypeOption_RetailItem() throws Exception
	{
		Thread.sleep(1000);
		Level_RetailItemInputBx.click();
		
		Thread.sleep(1000);
		//Select Category
		driver.findElement(By.xpath("//select-option[1]")).click();
	}
	
	public void Click_SubCategory_LevelTypeOption_RetailItem() throws Exception
	{
		Thread.sleep(1000);
		Level_RetailItemInputBx.click();
		
		Thread.sleep(1000);
		//Select Category
		driver.findElement(By.xpath("//div[2]/select-option")).click();
	}
	public WebElement Level_RetailItem()
	{
		return Level_RetailItemInputBx;
	}
	public void Select_Standard_Time_ProductType(String SKUCode,String SupplyPrice,String MarkupPerc) throws Exception
	{
		
		Thread.sleep(1000);
		Standard_Item_RadioBtn.click();
		
		Thread.sleep(1000);
		//Click the Serving Size
		driver.findElement(By.xpath("//app-selectbox[@name='retailServingSize']//input")).click();
		
		Thread.sleep(2000);
		List<WebElement> menuList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
			
		if(menuList.size()>1)
		{
			int menuSize=menuList.size();
			
			
			int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
			
			
			driver.findElement(By.xpath("//div[@class='options with-height']/ cdk-virtual-scroll-viewport/div/div["+randomMenu+"]/select-option")).click();
		
		}
		else
		{
			driver.findElement(By.xpath("//div[@class='options with-height']/ cdk-virtual-scroll-viewport/div/div/select-option")).click();
		}
		
		
		Thread.sleep(1000);
		//Click the SKU Type
		driver.findElement(By.xpath("//app-selectbox[@name='retailSkuType']//input")).click();
		
		Thread.sleep(2000);
		List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='options with-height']/ cdk-virtual-scroll-viewport/div/div/select-option"));
			
		if(menuList1.size()>1)
		{
			int menuSize=menuList1.size();
			
			
			int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
			
			
			driver.findElement(By.xpath("//div[@class='options with-height']/ cdk-virtual-scroll-viewport/div/div["+randomMenu+"]/select-option")).click();
		
		}
		else
		{
			driver.findElement(By.xpath("//div[@class='options with-height']/ cdk-virtual-scroll-viewport/div/div/select-option[1]")).click();
		}
		
		
		
		//Clear SKU Code
		driver.findElement(By.xpath("//app-input[@name='retailSkuCode']//input")).clear();
		//Enter SKU Code
		driver.findElement(By.xpath("//app-input[@name='retailSkuCode']//input")).sendKeys(SKUCode);
		
		try {
		//Clear Supply Price
		driver.findElement(By.xpath("//app-currency-input[@name='retailSupplyPrice']//input")).clear();
		//Enter Supply Price
		driver.findElement(By.xpath("//app-currency-input[@name='retailSupplyPrice']//input")).sendKeys(SupplyPrice);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		
		//Clear Markup Percentage
		driver.findElement(By.xpath("//app-input[@name='retailMarginPercentage']//input")).clear();
		//Enter Markup Percentage
		driver.findElement(By.xpath("//app-input[@name='retailMarginPercentage']//input")).sendKeys(MarkupPerc);
		
		double Supply_Price=Double.parseDouble(SupplyPrice);
		double MarkUp_Percentage=Double.parseDouble(MarkupPerc);
		
		double Expected_Selling_Price=Supply_Price*MarkUp_Percentage;
		try {
		String Act_SellPrice1=driver.findElement(By.xpath("//app-currency-input[@name='retailSellingPrice']//input")).getAttribute("value");
		int selling = Integer.parseInt(Act_SellPrice1);
		if(!(selling==100))
		{
			test.log(LogStatus.PASS,"By default selling price is not 100");
		}
		else {
			test.log(LogStatus.FAIL, "By default selling price is 100");
		}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		//Get the Actual Selling Price
		String Act_SellPrice=driver.findElement(By.xpath("//app-currency-input[@name='retailSellingPrice']//input")).getAttribute("value");
		double Actual_Selling_Price=Double.parseDouble(Act_SellPrice);
		
		if(Actual_Selling_Price==Expected_Selling_Price)
		{
			test.log(LogStatus.PASS, "Selling Price Calculated Correctly");
		}
		else
		{
			double diff=Expected_Selling_Price-Actual_Selling_Price;
			test.log(LogStatus.FAIL, "Selling Price Calculated Incorrcetly. The value diff is : "+diff);
		}
		
	}

	@FindBy(xpath = "//label[contains(.,'Brand')]/../../input")
	WebElement Brand_RetailItemInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Par Level')]/../../input")
	WebElement Par_Level_RetailItemInputBx;
	
	
	@FindBy(xpath = "//label[contains(.,'Inventory Unit')]/../../input")
	WebElement Inventory_Unit_RetailItemInputBx;
	
	
	@FindBy(xpath = "//label[contains(.,'Vendor')]/../../input")
	WebElement Vendor_RetailItemInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Primary Storage')]/../../input")
	WebElement Primary_Storage_RetailItemInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Secondary Storage')]/../../input")
	WebElement Secondary_Storage_RetailItemInputBx;
	
	
	public void Enter_Brand_RetailItem(String str) throws Exception
	{
		Thread.sleep(1000);
		Brand_RetailItemInputBx.clear();
		Thread.sleep(1000);
		Brand_RetailItemInputBx.sendKeys(str);
	}
	
	
	public void Enter_Par_Level_RetailItem(String str) throws Exception
	{
		Thread.sleep(1000);
		Par_Level_RetailItemInputBx.clear();
		Thread.sleep(1000);
		Par_Level_RetailItemInputBx.sendKeys(str);
	}
	
	public void Select_Inventory_Unit_RetailItem() throws Exception
	{
		Inventory_Unit_RetailItemInputBx.click();
		
		Thread.sleep(1000);
		Thread.sleep(2000);
		List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
	    try {
		if(menuList1.size()>1)
		{
			int menuSize=menuList1.size();
			
			
			int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
			
			
			driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
		
		}
		else
		{
			driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();
		}
	    }
	    catch (Exception e) {
	    	driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();
		}
		
	}
	
	public void Select_Vendor_RetailItem() throws Exception
	{
		Vendor_RetailItemInputBx.click();
		
		Thread.sleep(1000);
//		Thread.sleep(2000);
//		List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
//		try {	
//		if(menuList1.size()>1)
//		{
//			int menuSize=menuList1.size();
//			
//			
//			int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
//			
//			
//			driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
//		
//		}
//		else
//		{
//			driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();
//		}
//		}
//		catch (Exception e) {
//			driver.findElement(By.xpath("//div[@class='options with-height']//div/div[2]/select-option")).click();
//		}
		
		driver.findElement(By.xpath("//div[@class='options with-height']//div/div[2]/select-option")).click();
		
	}
	
	
	public void Select_Primary_Storage_RetailItem() throws Exception
	{
		Primary_Storage_RetailItemInputBx.click();
		
		Thread.sleep(1000);
//		Thread.sleep(2000);
//		List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
//		try {
//		if(menuList1.size()>1)
//		{
//			int menuSize=menuList1.size();
//			
//			
//			int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
//			
//			
//			driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
//		
//		}
//		else
//		{
//			driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();
//		}
//		}
//		catch (Exception e) {
//			driver.findElement(By.xpath("//div[@class='options with-height']//div/div[2]/select-option")).click();	
//			}
		driver.findElement(By.xpath("//div[@class='options with-height']//div/div[2]/select-option")).click();		
	}
	
	public void Select_Secondary_Storage_RetailItem() throws Exception
	{
		Secondary_Storage_RetailItemInputBx.click();
		
		Thread.sleep(1000);
//		Thread.sleep(2000);
//		List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='options with-height']//div/div/select-option"));
//		try {	
//		if(menuList1.size()>1)
//		{
//			int menuSize=menuList1.size();
//			
//			
//			int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
//			
//			
//			driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+randomMenu+"]/select-option")).click();
//		
//		}
//		else
//		{
//			driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();
//		}
//		}
//		catch (Exception e) {
//			driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();
//		}
		driver.findElement(By.xpath("//div[@class='options with-height']//div/div[2]/select-option")).click();
		
	}
	
	@FindBy(xpath = "//span[contains(.,'Calculate COGS On Cost Price')]/../../div[2]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Calculate_COGS_onCostPrice_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Calculate COGS On Cost Price')]/../../div[2]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Calculate_COGS_onCostPrice_NoBtn;
	
	public void Enable_Calculate_COGS_onCostPrice()
	{
		if(Calculate_COGS_onCostPrice_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Calculate_COGS_onCostPrice_YesBtn.click();
		}
	}
	
	public void Disable_Calculate_COGS_onCostPrice()
	{
		if(Calculate_COGS_onCostPrice_YesBtn.isEnabled()) 
		{
			Calculate_COGS_onCostPrice_NoBtn.click();
		}
		else
		{
		
		}
	}

	public WebElement Calculate_COGS_onCostPrice_Yes()
	{
		return Calculate_COGS_onCostPrice_YesBtn;
	}
	
	//app-input[@name='retailSkuCode']//mat-icon[contains(.,'add')]
	//app-input[@name='retailSkuCode']//mat-icon[contains(.,'minimize')]
	//button[contains(.,'Add SKU Code')]
	@FindBy(xpath = "//button[contains(.,'Add Tax')]")
	WebElement Add_TaxBtn;
	
	public void Create_RetailItem_NewTax(String str) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		tx=new TaxesPage(driver, test);
		Thread.sleep(1000);
		Add_TaxBtn.click();
		
		Thread.sleep(1000);
		if(cmp.CreationScreenHeader.getText().equalsIgnoreCase("New Tax"))
		{
			test.log(LogStatus.PASS, "New Tax form loaded successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax form loaded Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		cmp.New_TaxNameInput.clear();
		Thread.sleep(500);
		cmp.New_TaxNameInput.sendKeys(str);
	//Remove below all	
		Thread.sleep(1000);
//		tx.Select_TaxType_Percentage();
//		Thread.sleep(1000);
//		tx.Enter_Percentage("1000");
//		Thread.sleep(1000);
//		tx.Select_InclusiveTax();
//		
////		tx.Select_DefaultTax();
		Thread.sleep(1000);
		tx.Select_TaxType_Amount();
		
		Thread.sleep(1000);
		tx.Enter_AmountBox("2000");
		
//		tx.Click_ItemTax();
		
		Thread.sleep(1000);
		cmp.Click_SaveButton();
		
		Thread.sleep(2000);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Tax Saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Saved Failed");
		}
	}
	
	@FindBy(xpath = "//input[@data-placeholder='Search ']")
	WebElement SearchBox;
	
	public void SearchAndClickEdit(String SearchValue) throws Exception
	{
	
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(2000);
		try
		{
			Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.='"+SearchValue+"']/../../td[8]/div/div[1]/button")).click();
		
		}
		catch(Exception g)
		{
			try {
				driver.findElement(By.xpath("//span[.='"+SearchValue+"']/../../td[9]/div/div[1]/button")).click();
				Thread.sleep(1000);
			}
			catch (Exception e) {
				// TODO: handle exception
			
			Thread.sleep(2000);

			driver.findElement(By.xpath("//span[.='"+SearchValue+"']/../../div//div[1]/button")).click();
		}
		}
		
		}
	
	public void SearchAndClickDelete(String SearchValue) throws Exception
	{

		try
		{
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[.='"+SearchValue+"']/../../td[8]/div/div[2]/button")).click();
		Thread.sleep(1000);
		}
		catch(Exception h)
		{
			try {
				driver.findElement(By.xpath("//span[.='"+SearchValue+"']/../../td[9]/div/div[2]/button")).click();
				Thread.sleep(1000);
			}
			catch (Exception e) {
				// TODO: handle exception
		
			Thread.sleep(1000);
			SearchBox.clear();
			Thread.sleep(2000);

			SearchBox.sendKeys(SearchValue);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//span[.='"+SearchValue+"']/../../div//div[2]/button")).click();
			Thread.sleep(1000);
			}
		}
	}
	
	public void SearchAndClickDeleteCancel(String SearchValue) throws Exception
	{
		try {
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[.='"+SearchValue+"']/../../td[3]//div[1]/button")).click();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	
	}
	
	public void SearchAndClickActivate(String SearchValue) throws Exception
	{
//		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(300));
		
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(1000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(2000);
		
		try
		{
		driver.findElement(By.xpath("//span[.='"+SearchValue+"']/../../td[8]/div/div[1]/button")).click();
		}
		catch(Exception h)
		{
			try {
				driver.findElement(By.xpath("//span[.='"+SearchValue+"']/../../td[9]/div/div[1]/button")).click();
				Thread.sleep(1000);
			}
			catch (Exception e) {
				// TODO: handle exception
			
			driver.findElement(By.xpath("//span[.='"+SearchValue+"']/../../div//div/button")).click();
			}
		}
	}
	
	public void Click_RetailItem() 
	{
		driver.findElement(By.xpath("//span[.='RETAIL ITEMS']")).click();
	}
	
	@FindBy(xpath = "//app-selectbox[@placeholder='Select Modifier']")
	WebElement Modfier_Inputbox;

	public void select_Modifier() throws Exception 
	{
		Thread.sleep(2000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
		wait.until(ExpectedConditions.elementToBeClickable(Modfier_Inputbox)).click();
//		CoursingDropBtn.click();
		
//		Modfier_Inputbox .click();
		
		Thread.sleep(1000);
		List<WebElement> ModifierList=driver.findElements(By.xpath("//div/select-option"));
		
		int ModifierSize=ModifierList.size();
		
		if(ModifierSize<=6)
		{
		
		int randomModifier=ThreadLocalRandom.current().nextInt(2, ModifierSize);
		
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
		
		cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomModifier+"]/select-option")).getText());
		
		driver.findElement(By.xpath("//div[1]/select-option")).click();
		}
		else
		{
			int randomModifier=ThreadLocalRandom.current().nextInt(1, 6);
			
			Thread.sleep(1000);
//			driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
			
			cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomModifier+"]/select-option")).getText());
			
			driver.findElement(By.xpath("//div[1]/select-option")).click();
		
		}	
		
		List<WebElement> menuList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		
		
		if(menuList1.size()!=0)
		{
			Alternate_Modifier_GroupInputBx.click();
		}
		
	}
	
	@FindBy(xpath = "//label[contains(.,'Tare Group')]/../../input")
	WebElement TareGroupDropBtn;
	
	public void Select_TareGroup() throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(TareGroupDropBtn);
		Thread.sleep(1000);
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
//		TareGroupDropBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(TareGroupDropBtn)).click();
		
		driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();
		
	}
}
