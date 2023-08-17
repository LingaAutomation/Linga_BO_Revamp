package com.Pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class InventoryPage extends BasePage
{

	public WebDriver driver;
	public ExtentTest test;
	
	Utility ut=new Utility();
	Common_XPaths cmp;
	ReportsPage repts;
	public InventoryPage(WebDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
//		
//		PageFactory.initElements(driver, this);
		
		super(driver, test);
	}
	
	@FindBy(xpath = "//button[contains(.,'Apply')]")
	WebElement Apply_Btn;
	
	public void Click_ApplyButton()
	{
		Apply_Btn.click();
	}
	
	
	@FindBy(xpath = "//button[contains(.,'NEW ADJUSTMENT REASON')]")
	WebElement New_Adjustment_ReasonBtn;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Adjustment')]")
	WebElement Adjustment_RadioBtn;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Increase')]")
	WebElement Increase_RadioBtn;

	@FindBy(xpath = "//mat-radio-button[contains(.,'Decrease')]")
	WebElement Decrease_RadioBtn;
	
	@FindBy(xpath = "//div[contains(.,'Default')]/app-toggle//mat-button-toggle[.='Yes']")
	WebElement Default_Yes_ToggleBtn;
	
	@FindBy(xpath = "//div[contains(.,'Default')]/app-toggle//mat-button-toggle[.='No']")
	WebElement Default_No_ToggleBtn;
	
	@FindBy(xpath = "//div[contains(.,'Wastage Reason')]/app-toggle//mat-button-toggle[.='Yes']")
	WebElement Wastage_Report_Yes_ToggleBtn;
	
	@FindBy(xpath = "//div[contains(.,'Wastage Reason')]/app-toggle//mat-button-toggle[.='No']")
	WebElement Wastage_Report_No_ToggleBtn;
	
	@FindBy(xpath =  "//mat-icon[contains(.,'arrow_drop_up')]")
	WebElement IncreaseItem_UpArrow;
	
	public void Click_New_Adjustment_Reason()
	{
		New_Adjustment_ReasonBtn.click();
	}
	
//	public void Click_New_Adjustment_Reason()
//	{
//		new BasePage().Click_Button(New_Adjustment_ReasonBtn,"");
//	}
//	
	public WebElement Default_Yes_ToggleBtn()
	{
		return Default_Yes_ToggleBtn;
	}
	
	public WebElement Default_No_ToggleBtn()
	{
		return Default_No_ToggleBtn;
	}
	
	public WebElement Wastage_Report_Yes_ToggleBtn()
	{
		return Wastage_Report_Yes_ToggleBtn;
	}
	
	public WebElement Wastage_Report_No_ToggleBtn()
	{
		return Wastage_Report_No_ToggleBtn;
	}
	
	public WebElement Adjustment_RadioBtn()
	{
		return Adjustment_RadioBtn;
	}
	
	public WebElement Increase_RadioBtn()
	{
		return Increase_RadioBtn;
	}
	
	public WebElement Decrease_RadioBtn()
	{
		return Decrease_RadioBtn;
	}
	
	
	
	///////////  Adjust Inventory  ///////////////////
	
	@FindBy(xpath = "//span[.='INVENTORY ITEM'][contains(@class,'segment-button')]")
	WebElement Inventory_ItemTab;
	
	@FindBy(xpath = "//span[.='RETAIL ITEM'][contains(@class,'segment-button')]")
	WebElement Retail_ItemTab;
	
	@FindBy(xpath = "//span[.='SUB-RECIPE'][contains(@class,'segment-button')]")
	WebElement Sub_RecipeTab;
	
	@FindBy(xpath = "//button[contains(@class,'action-button')]")
	WebElement Action_InventoryItemBtn;
	
	@FindBy(xpath = "//tr//button")
	WebElement Action_InventoryItemBtn_two;
	
	
	
	@FindBy(xpath = "//button[contains(@class,'action-button')]")
	WebElement Action_Inventory_PlusBtn;
	
	
	@FindBy(xpath = "//button[contains(.,'add_link')]")
	WebElement Add_Link_IconInventoryMenuItemBtn;
	
	@FindBy(xpath = "//label[contains(.,'Reason Type')]/../../input")
	WebElement Reason_Type_Adj_InvInputBx;
	
	@FindBy(xpath = "//app-input-table[@name='vendor']/div/div[2]/div[2]//input")
	WebElement Count_Adj_InvInputBx;
	
	public void Select_Inventory_Item_AdjustInventoryTab()
	{
		Inventory_ItemTab.click();
	}
	
	public void Select_Retail_Item_AdjustInventoryTab()
	{
		Retail_ItemTab.click();
	}
	
	public void Select_Sub_Recipe_AdjustInventoryTab()
	{
		Sub_RecipeTab.click();
	}
	
	public void Click_Action_InventoryItem_AdjustInventoryBtn()
	{
		Action_InventoryItemBtn_two.click();
	}
	
	
	
	
	public WebElement Reason_Type_Adj_InvInputBox()
	{
		return Reason_Type_Adj_InvInputBx;
	}
	
	public WebElement Count_Adj_InvInputBox()
	{
		return Count_Adj_InvInputBx;
	}
	
	//////////// Inventory - Sub Recipe  //////////////////////
	
	@FindBy(xpath = "//button[contains(.,'NEW SUB RECIPE')]")
	WebElement New_Sub_Recipe;
	
	@FindBy(xpath="//label[contains(.,'Inventory Unit')]/../../input")
	WebElement Inventory_Unit_InputBx;
	
	@FindBy(xpath="//label[contains(.,'Inventory Item')]/../../input")
	WebElement Inventory_Item_InputBx;
	
	@FindBy(xpath = "//div[contains(.,'Calculate COGS On Cost Price')]//mat-button-toggle[.='Yes']")
	WebElement Calculate_COGS__onCostPrice_Yes_ToggleBtn;
	
	@FindBy(xpath = "//div[contains(.,'Calculate COGS On Cost Price')]//mat-button-toggle[.='No']")
	WebElement Calculate_COGS__onCostPrice_No_ToggleBtn;
	
	@FindBy(xpath = "//app-input[@name='notes']//textarea")
	WebElement Preparation_NotesInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Quantity')]/../../input")
	WebElement Quantity_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Yield %')]/../../input")
	WebElement Yield_PercentageInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Price Per Unit')]/../../input")
	WebElement Price_per_UnitInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Primary Storage')]/../../input")
	WebElement Primary_StorageInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Secondary Storage')]/../../input")
	WebElement Secondary_StorageInputBx;
	
	@FindBy(xpath = "//button[contains(.,'Add Recipe Unit')]")
	WebElement Add_Recipe_UnitBtn;
	
	@FindBy(xpath = "//*[contains(.,'Add Inventory Item')][contains(@class,'cursor-pointer')]")
	WebElement Add_Inventory_ItemBtn;
	
	@FindBy(xpath = "//*[contains(.,'Add Sub-Recipe')][contains(@class,'cursor-pointer')]")
	WebElement Add_Sub_RecipetBtn;
	
	@FindBy(xpath = "//*[contains(.,'Add Manual Entry')][contains(@class,'cursor-pointer')]")
	WebElement Add_Manual_EntryBtn;
	
	@FindBy(xpath = "//button[contains(.,'New Storage')]")
	WebElement New_StorageBtn;
	
	@FindBy(xpath = "//cdk-virtual-scroll-viewport//div/div[1]//select-option")
	WebElement First_Option_inDropDwon;
	
	@FindBy(xpath = "//h3[contains(.,'New Storage Location')]/../../..//label[contains(.,'Name')]/../../input")
	WebElement Name_Storage_Location;
	
	@FindBy(xpath = "//mat-hint[contains(.,'Enter Yield Should Not Be Greater Than 100')]")
	WebElement Yield_Percentage_GreaterErrorMsg;
	
	public void Click_New_SubRecipe()
	{
		New_Sub_Recipe.click();
	}
	
	public void Enter_Preparation_Notes(String Notes) throws Exception
	{
		Preparation_NotesInputBx.clear();
		Thread.sleep(500);
		Preparation_NotesInputBx.sendKeys(Notes);
		
	}
	
	public WebElement Inventory_Item_InputBox()
	{
		return Inventory_Item_InputBx;
	}
	
	public void Select_Inventory_Item() throws Exception
	{
		Inventory_Item_InputBx.click();
		
		List<WebElement> optList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
 
		int optionSize=optList.size();
		if(optionSize==0)
		{
			
			List<WebElement> optList1=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
			
			int optionSize1=optList1.size();
			
			
			int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize1);
			
			Thread.sleep(1000);

			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
		
		}
		else if(optionSize==1)
		{
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+optionSize+"]//select-option")).click();
		
		}
		else if(optionSize<=10)
		{
			
		int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize);
		
		Thread.sleep(1000);

		driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
		}
		else
		{
			int randomOpt=ThreadLocalRandom.current().nextInt(1, 10);
			
			Thread.sleep(1000);

			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
			
		}
		
		List<WebElement> Optist1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));

		if(Optist1.size()!=0)
		{
			Inventory_Item_InputBx.click();
			
		}
		
		
	}
	
	public void Select_Inventory_Unit() throws Exception
	{
		Inventory_Unit_InputBx.click();
		
		List<WebElement> optList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
 
		int optionSize=optList.size();
		if(optionSize==0)
		{
			
			List<WebElement> optList1=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
			
			int optionSize1=optList1.size();
			
			
			int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize1);
			
			Thread.sleep(1000);

			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
		
		}
		else if(optionSize==1)
		{
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+optionSize+"]//select-option")).click();
		
		}
		else if(optionSize<=10)
		{
			
		int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize);
		
		Thread.sleep(1000);

		driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
		}
		else
		{
			int randomOpt=ThreadLocalRandom.current().nextInt(1, 10);
			
			Thread.sleep(1000);

			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
			
		}
		
		List<WebElement> Optist1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));

		if(Optist1.size()!=0)
		{
			Inventory_Item_InputBx.click();
			
		}
		
		
	}
	
	public WebElement Primary_StorageInputBox()
	{
		return Primary_StorageInputBx;
	}
	
	public WebElement Secondary_StorageInputBox()
	{
		return Secondary_StorageInputBx;
	}
	
	public void Select_Primary_Storage() throws Exception
	{
		
//		new BasePage().Click_DropDown_withSearch(Primary_StorageInputBx, "Primary Storage Selected");
	
		
		new Common_XPaths(driver, test).Click_DropDown_withSearch(Primary_StorageInputBx, "Primary Storage Selected");
	}
	
	public void Select_Secondary_Storage() throws Exception
	{
//		new BasePage().Click_DropDown_withSearch(Secondary_StorageInputBx, "Secondary Storage Selected");
		new Common_XPaths(driver, test).Click_DropDown_withSearch(Secondary_StorageInputBx, "Primary Storage Selected");

	}
	
//	public void Select_Primary_Storage() throws Exception
//	{
//		cmp=new Common_XPaths(driver, test);
//		Primary_StorageInputBx.click();
//		
//		List<WebElement> optList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
// 
//		int optionSize=optList.size();
//		if(optionSize==0)
//		{
//			Primary_StorageInputBx.click();
//
//			List<WebElement> optList1=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
//			
//			int optionSize1=optList1.size();
//			
//			
//			int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize1);
//			
//			Thread.sleep(1000);
//
////			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
////	cmp.Search(driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).getText());
//
//			String opt=driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).getText();
////			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
//			cmp.Search(opt);
//			
//			First_Option_inDropDwon.click();
//		}
//		else if(optionSize==1)
//		{
//			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+optionSize+"]//select-option")).click();
//		
//		}
//		else if(optionSize<=10)
//		{
//			
//		int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize);
//		
//		Thread.sleep(1000);
//
////		driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
//
//		String opt=driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).getText();
////		driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
//		cmp.Search(opt);
//		
//		First_Option_inDropDwon.click();
//		
//		}
//		else
//		{
//			int randomOpt=ThreadLocalRandom.current().nextInt(1, 10);
//			
//			Thread.sleep(1000);
//			String opt=driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).getText();
////			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
//			cmp.Search(opt);
//			
//			First_Option_inDropDwon.click();
//		}
//		
//		List<WebElement> ModifyWithList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
//
//		if(ModifyWithList1.size()!=0)
//		{
//			Primary_StorageInputBx.click();
//			
//		}
//		
//	}
//	
//	public void Select_Secondary_Storage() throws Exception
//	{
//		cmp=new Common_XPaths(driver, test);
//
//		Secondary_StorageInputBx.click();
//		
//		List<WebElement> optList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
// 
//		int optionSize=optList.size();
//		if(optionSize==0)
//		{
//			Secondary_StorageInputBx.click();
//			List<WebElement> optList1=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
//			
//			int optionSize1=optList1.size();
//			
//			
//			int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize1);
//			
//			Thread.sleep(1000);
//
////			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
//	cmp.Search(driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).getText());
//			
//			First_Option_inDropDwon.click();
//		}
//		else if(optionSize==1)
//		{
//			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+optionSize+"]//select-option")).click();
//		
//		}
//		else if(optionSize<=10)
//		{
//			
//		int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize);
//		
//		Thread.sleep(1000);
//
////		driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
//		cmp.Search(driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).getText());
//		
//		First_Option_inDropDwon.click();
//		
//		}
//		else
//		{
//			int randomOpt=ThreadLocalRandom.current().nextInt(1, 10);
//			
//			Thread.sleep(1000);
//
////			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
//			cmp.Search(driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).getText());
//			
//			First_Option_inDropDwon.click();
//		}
//		
//		List<WebElement> ModifyWithList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
//
//		if(ModifyWithList1.size()!=0)
//		{
//			Secondary_StorageInputBx.click();
//			
//		}
//		
//	}
	
	public void Enter_Quantity(String Quantity) throws Exception
	{
		new Common_XPaths(driver, test).Enter_Text(Quantity_InputBx, Quantity, "Quanity Entered");
	}
	
	public void Enter_Yield_Percentage(String Percentage) throws Exception
	{
		new Common_XPaths(driver, test).Enter_Text(Yield_PercentageInputBx, Percentage, "Percentage Entered");
	
	}
	
	public void Verify_Yield_Warning_Above_100Percentage()
	{
		try
		{
			if(Yield_Percentage_GreaterErrorMsg.isDisplayed())
			{
				test.log(LogStatus.PASS, "Enter Yield Should Not Be Greater Than 100 is Displayed");
			}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Enter Yield Should Not Be Greater Than 100 is not Displayed");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	public void Enter_Price_Per_Unit(String PriceperUnit) throws Exception
	{
		new Common_XPaths(driver, test).Enter_Text(Price_per_UnitInputBx, PriceperUnit, "Percentage Entered");
	}
	
	public WebElement Calculate_COGS_onCost_Price_YesToggle()
	{
		return Calculate_COGS__onCostPrice_Yes_ToggleBtn;
	}
	
	public WebElement Calculate_COGS_onCost_Price_NoToggle()
	{
		return Calculate_COGS__onCostPrice_No_ToggleBtn;
	}
	
	public void Create_New_Storage(String StorageName, String Msg) throws Exception
	{
		Primary_StorageInputBx.click();
		
		New_StorageBtn.click();
		
		new Common_XPaths(driver, test).VerifyCreationScreenPageHeader("New Storage Location");
		
		Name_Storage_Location.clear();
		Thread.sleep(1000);
		Name_Storage_Location.sendKeys(StorageName);
		
		new DepartmentPage(driver, test).DescriptionInputBox.clear();
		Thread.sleep(1000);
		new DepartmentPage(driver, test).DescriptionInputBox.clear();

		new Common_XPaths(driver, test).Click_SaveButton();
		
		new Common_XPaths(driver, test).VerifySaveConfirmationAlertMessage(Msg);
	}
	
	public void Add_Receipe_Units(String Quantity) throws Exception
	{
		Thread.sleep(1000);
		Add_Recipe_UnitBtn.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//app-input-table[@name='RecipeUnitOptions']/div/div[2]/div[2]//input")).click();
		
		List<WebElement> RecipeUnitList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
		
		int ReciUnitSize=RecipeUnitList.size();
		
//		int randomOpt=ThreadLocalRandom.current().nextInt(1, ReciUnitSize);
		int randomOpt=ThreadLocalRandom.current().nextInt(1, 5);

		Thread.sleep(1000);

		driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();

		Thread.sleep(1000);
		//Enter the Recipe Quantity
		driver.findElement(By.xpath("//app-input-table[@name='RecipeUnitOptions']/div/div[2]/div[3]//input")).clear();
		Thread.sleep(500);
		driver.findElement(By.xpath("//app-input-table[@name='RecipeUnitOptions']/div/div[2]/div[3]//input")).sendKeys(Quantity);
		
		//Get the Price Per Unit value
		String Actual_PriceperUnit=Price_per_UnitInputBx.getAttribute("value");
		double Price_perUnitPrice=Double.parseDouble(Actual_PriceperUnit);
		
		//Get Quantity
		int Actual_Qty=Integer.parseInt(Quantity);
		
		double Expected_RecipePrice=Price_perUnitPrice*Actual_Qty;
		
		//Get the Actual Recipe Cost
		String Actual_RecipeCost=driver.findElement(By.xpath("//app-input-table[@name='RecipeUnitOptions']/div/div[2]/div[4]//input")).getAttribute("value");
		double Actual_RecipePrice=Double.parseDouble(Actual_RecipeCost);
		
		if(Expected_RecipePrice==Actual_RecipePrice)
		{
			test.log(LogStatus.PASS, "Recipe Price Calculated Correctly");
		}
		else
		{
			double diff=Expected_RecipePrice-Actual_RecipePrice;
			test.log(LogStatus.FAIL, "Recipe Price Calculated Incorrect. Diff is : "+diff);
		}
			
		
		for(int i=1;i<=2;i++)
		{
			Add_Recipe_UnitBtn.click();
			
			Thread.sleep(1000);
			
//			for(j=1)
			
		}
		
		List<WebElement> RecList=driver.findElements(By.xpath("//app-input-table[@name='RecipeUnitOptions']/div/div/div[5]//button"));

		for(int i=2;i<=RecList.size();i++)
		{
			Thread.sleep(2000);
			driver.findElement(By.xpath("//app-input-table[@name='RecipeUnitOptions']/div/div[3]/div[5]//button")).click();
			
			new Common_XPaths(driver, test).Click_DeleteButton();
		}
		
	}
	
	public void Click_Add_InventoryItem()
	{
		Add_Inventory_ItemBtn.click();
	}
	
	public void Click_Add_SubRecipe()
	{
		Add_Sub_RecipetBtn.click();
	}
	
	public void Click_Add_ManualEntry()
	{
		Add_Manual_EntryBtn.click();
	}
	
	public void Add_Inventory_Items_inSubRecipe(String Quantity) throws Exception
	{
		Thread.sleep(2000);
		List<WebElement> invList=driver.findElements(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')]/div/div[1]//input"));
		
		for(int i=1;i<=invList.size();i++)
		{
		
		driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[1]//input")).click();
		
		List<WebElement> LevlList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));

		
		int LevSize=LevlList.size();
		
		int randomOpt=ThreadLocalRandom.current().nextInt(1, LevSize);

		Thread.sleep(1000);

		if(driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).getText().equalsIgnoreCase("Category"))
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
			
			Thread.sleep(1000);
			//Select Available Categories
			driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[2]//input")).click();
			
			List<WebElement> CatList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));

			
			int CatSize=CatList.size();
			
			
			if(CatSize<=5)
			{
				Thread.sleep(1000);
				int randomCat=ThreadLocalRandom.current().nextInt(1, CatSize);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomCat+"]//select-option")).click();

			}
			else
			{
				Thread.sleep(1000);
				int randomCat=ThreadLocalRandom.current().nextInt(1, 5);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomCat+"]//select-option")).click();

			}
			
			//Select Item
			driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[4]//input")).click();
			
			List<WebElement> itemList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));

			
			int itemSize=itemList.size();
			
			if(itemSize<=5)
			{
				Thread.sleep(1000);
				int randomitem=ThreadLocalRandom.current().nextInt(1, itemSize);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomitem+"]//select-option")).click();

			}
			else
			{
				Thread.sleep(1000);
				int randomitem=ThreadLocalRandom.current().nextInt(1, 5);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomitem+"]//select-option")).click();

			}
			
			//Select Recipe Unit
			driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[5]//input")).click();
			
			List<WebElement> UnitList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));

			
			int UnitSize=UnitList.size();
			
			if(UnitSize==1)
			{
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+UnitSize+"]//select-option")).click();

			}
			else if(UnitSize>1&&UnitSize<=5)
			{
				Thread.sleep(1000);
				int randomUnit=ThreadLocalRandom.current().nextInt(1, UnitSize);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomUnit+"]//select-option")).click();

			}
			else
			{
				Thread.sleep(1000);
				int randomUnit=ThreadLocalRandom.current().nextInt(1, 5);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomUnit+"]//select-option")).click();

			}
			
			
			//Clear the Quantity
			driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[7]//input")).clear();
			//Enter the Quantity
			driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[7]//input")).sendKeys(Quantity);
			
			
		
		}
		else
		{
driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
			
			//Select Available Categories
			driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[2]//input")).click();
			
			List<WebElement> CatList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));

			
			int CatSize=CatList.size();
			
			
			if(CatSize<=5)
			{
				Thread.sleep(1000);
				int randomCat=ThreadLocalRandom.current().nextInt(1, CatSize);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomCat+"]//select-option")).click();

			}
			else
			{
				Thread.sleep(1000);
				int randomCat=ThreadLocalRandom.current().nextInt(1, 5);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomCat+"]//select-option")).click();

			}
			
			
			//Select Available SubCategories
			driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[3]//input")).click();
			
			List<WebElement> SubCatList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));

			
			int SubCatSize=SubCatList.size();
			
			
			if(SubCatSize<=5)
			{
				Thread.sleep(1000);
				int randomSubCat=ThreadLocalRandom.current().nextInt(1, SubCatSize);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomSubCat+"]//select-option")).click();

			}
			else
			{
				Thread.sleep(1000);
				int randomSubCat=ThreadLocalRandom.current().nextInt(1, 5);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomSubCat+"]//select-option")).click();

			}
			
			
			//Select Item
			driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[4]//input")).click();
			
			List<WebElement> itemList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));

			
			int itemSize=itemList.size();
			
			if(itemSize<=5)
			{
				Thread.sleep(1000);
				int randomitem=ThreadLocalRandom.current().nextInt(1, itemSize);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomitem+"]//select-option")).click();

			}
			else
			{
				Thread.sleep(1000);
				int randomitem=ThreadLocalRandom.current().nextInt(1, 5);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomitem+"]//select-option")).click();

			}
			
			//Select Recipe Unit
			driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[5]//input")).click();
			
			List<WebElement> UnitList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));

			
			int UnitSize=UnitList.size();
			
			if(UnitSize<=5)
			{
				Thread.sleep(1000);
				int randomUnit=ThreadLocalRandom.current().nextInt(1, UnitSize);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomUnit+"]//select-option")).click();

			}
			else
			{
				Thread.sleep(1000);
				int randomUnit=ThreadLocalRandom.current().nextInt(1, 5);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomUnit+"]//select-option")).click();

			}
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[7]//input")).clear();
			//Enter the Quantity
			driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[7]//input")).sendKeys(Quantity);
			
		}

		
		}
		
	}
	
	
	
	public void Add_SubRecipes_inSubRecipe(String Quantity) throws Exception
	{
		Thread.sleep(2000);

		List<WebElement> invList=driver.findElements(By.xpath("//span[contains(.,'Selected Sub-Recipes')]/../..//div[contains(@class,'inventory-table')]/div/div[1]//input"));
		
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'Selected Sub-Recipes')]/../..//div[contains(@class,'inventory-table')][1]/div/div[1]//input")).isDisplayed())
			{
		
		for(int i=1;i<=invList.size();i++)
		{
		
			Thread.sleep(1000);
			//Select Item
			driver.findElement(By.xpath("//span[contains(.,'Selected Sub-Recipes')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[1]//input")).click();
			
			List<WebElement> itemList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));

			
			int itemSize=itemList.size();
			
			if(itemSize<=5)
			{
				Thread.sleep(1000);
				int randomitem=ThreadLocalRandom.current().nextInt(1, itemSize);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomitem+"]//select-option")).click();

			}
			else
			{
				Thread.sleep(1000);
				int randomitem=ThreadLocalRandom.current().nextInt(1, 5);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomitem+"]//select-option")).click();

			}
			
			//Select Recipe Unit
			driver.findElement(By.xpath("//span[contains(.,'Selected Sub-Recipes')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[2]//input")).click();
			
			List<WebElement> UnitList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));

			
			int UnitSize=UnitList.size();
			
			if(UnitSize==1)
			{
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+UnitSize+"]//select-option")).click();

			}
			else if(UnitSize>1&&UnitSize<=5)
			{
				Thread.sleep(1000);
				int randomUnit=ThreadLocalRandom.current().nextInt(1, UnitSize);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomUnit+"]//select-option")).click();

			}
			else
			{
				Thread.sleep(1000);
				int randomUnit=ThreadLocalRandom.current().nextInt(1, 5);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomUnit+"]//select-option")).click();

			}
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//span[contains(.,'Selected Sub-Recipes')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[4]//input")).clear();
			//Enter the Quantity
			driver.findElement(By.xpath("//span[contains(.,'Selected Sub-Recipes')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[4]//input")).sendKeys(Quantity);
			
			
		
		}
			}
		}
		catch(Exception k)
		{
			for(int i=1;i<=invList.size();i++)
			{
			
				Thread.sleep(1000);
				//Select Item
				driver.findElement(By.xpath("//span[contains(.,'Select Sub Recipes')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[1]//input")).click();
				
				List<WebElement> itemList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));

				
				int itemSize=itemList.size();
				
				if(itemSize<=5)
				{
					Thread.sleep(1000);
					int randomitem=ThreadLocalRandom.current().nextInt(1, itemSize);
					driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomitem+"]//select-option")).click();

				}
				else
				{
					Thread.sleep(1000);
					int randomitem=ThreadLocalRandom.current().nextInt(1, 5);
					driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomitem+"]//select-option")).click();

				}
				
				//Select Recipe Unit
				driver.findElement(By.xpath("//span[contains(.,'Select Sub Recipes')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[2]//input")).click();
				
				List<WebElement> UnitList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));

				
				int UnitSize=UnitList.size();
				
				if(UnitSize==1)
				{
					driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+UnitSize+"]//select-option")).click();

				}
				else if(UnitSize>1&&UnitSize<=5)
				{
					Thread.sleep(1000);
					int randomUnit=ThreadLocalRandom.current().nextInt(1, UnitSize);
					driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomUnit+"]//select-option")).click();

				}
				else
				{
					Thread.sleep(1000);
					int randomUnit=ThreadLocalRandom.current().nextInt(1, 5);
					driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomUnit+"]//select-option")).click();

				}
				
				Thread.sleep(1000);
				//Clear the Quantity
				driver.findElement(By.xpath("//span[contains(.,'Select Sub Recipes')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[4]//input")).clear();
				//Enter the Quantity
				driver.findElement(By.xpath("//span[contains(.,'Select Sub Recipes')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[4]//input")).sendKeys(Quantity);
				
				
			
			}
		}
	}
	
	public void Add_Manual_Entry_inSubRecipe(String ManualEntry, String UnitPrice, String Quantity) throws Exception
	{
		Thread.sleep(2000);

		List<WebElement> invList=driver.findElements(By.xpath("//span[contains(.,'Manual Entry')]/../..//div[contains(@class,'inventory-table')]/div/div[1]//input"));
		
		for(int i=1;i<=invList.size();i++)
		{
		
			Thread.sleep(1000);
			//Clear Manual Entry
			driver.findElement(By.xpath("//span[contains(.,'Manual Entry')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[1]//input")).clear();
			//Enter Manual Entry
			driver.findElement(By.xpath("//span[contains(.,'Manual Entry')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[1]//input")).sendKeys(ManualEntry+i);
			
			Thread.sleep(1000);
			//Clear Unit Price
			driver.findElement(By.xpath("//span[contains(.,'Manual Entry')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[2]//input")).clear();
			//Enter Unit Price
			driver.findElement(By.xpath("//span[contains(.,'Manual Entry')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[2]//input")).sendKeys(UnitPrice);
			
			Thread.sleep(1000);
			//Clear Quantity
			driver.findElement(By.xpath("//span[contains(.,'Manual Entry')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[3]//input")).clear();
			//Enter Quantity
			driver.findElement(By.xpath("//span[contains(.,'Manual Entry')]/../..//div[contains(@class,'inventory-table')]["+i+"]/div/div[3]//input")).sendKeys(Quantity);
			
			
		}
	}
	
	public void Delete_Inventory_Items_inSubRecipe(int rowNo) throws Exception
	{
		Thread.sleep(2000);

		List<WebElement> invList=driver.findElements(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')]/div/div[1]//input"));
	
	
		for(int i=rowNo;i<=invList.size();i++)
		{
			driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')][2]/div[contains(@class,'delete-button')]//button")).click();
			new Common_XPaths(driver, test).Click_DeleteButton();
		}
	}
	
	
	public void Delete_Sub_Recipes_inSubRecipe(int rowNo) throws Exception
	{
		Thread.sleep(2000);

		List<WebElement> invList=driver.findElements(By.xpath("//span[contains(.,'Selected Sub-Recipes')]/../..//div[contains(@class,'inventory-table')]/div/div[1]//input"));
	
	
		for(int i=rowNo;i<=invList.size();i++)
		{
			driver.findElement(By.xpath("//span[contains(.,'Selected Sub-Recipes')]/../..//div[contains(@class,'inventory-table')][2]/div[contains(@class,'delete-button')]//button")).click();
			new Common_XPaths(driver, test).Click_DeleteButton();
		}
	}
	
	
	public void Delete_Manual_Entry_inSubRecipe(int rowNo) throws Exception
	{
		Thread.sleep(2000);

		List<WebElement> invList=driver.findElements(By.xpath("//span[contains(.,'Manual Entry')]/../..//div[contains(@class,'inventory-table')]/div/div[1]//input"));
	
	
		for(int i=rowNo;i<=invList.size();i++)
		{
			driver.findElement(By.xpath("//span[contains(.,'Manual Entry')]/../..//div[contains(@class,'inventory-table')][2]/div[contains(@class,'delete-button')]//button")).click();
			new Common_XPaths(driver, test).Click_DeleteButton();
		}
	}
	
	
	//////////////////  Inventory Transfer  ///////////////////////
	
	@FindBy(xpath = "//span[contains(.,'TRANSFER REQUESTS')][contains(@class,'segment-button')]")
	WebElement Transfer_RequestsTab;
	
	@FindBy(xpath = "//span[contains(.,'TRANSFER LOGS')][contains(@class,'segment-button')]")
	WebElement Transfer_LogsTab;
	
	@FindBy(xpath = "//button[contains(.,'NEW TRANSFER REQUEST')]")
	WebElement New_Transfer_Request;
	
	@FindBy(xpath = "//label[contains(.,'Destination')]/../../input")
	WebElement Destination_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Source')]/../../input")
	WebElement Source_InputBx;
	
	@FindBy(xpath = "//button[.='Request']")
	WebElement RequestBtn;
	
	@FindBy(xpath = "//button/span[contains(.,'Transfer Items')]")
	WebElement Transfer_ItemsBtn;
	
	@FindBy(xpath = "//div[contains(.,'If the Requested quantity is not available in the store')][contains(@class,'error-text')]")
	WebElement Quantity_NotAvailable_ErrorMsg_TransferRequest;
	
	@FindBy(xpath = "//button[contains(.,'Add Inventory Item')]")
	WebElement Add_Inventory_ItemTwoBtn;
	
	
	public void Click_New_Transfer_Request()
	{
		New_Transfer_Request.click();
	}
	
	public void Select_Transfer_RequestsTab()
	{
		Transfer_RequestsTab.click();
	}
	
	public void Select_Transfer_LogsTab()
	{
		Transfer_LogsTab.click();
	}
	
	public void Click_RequestButton()
	{
		RequestBtn.click();
	}
	
	public void Click_Transfer_ItemsButton()
	{
		Transfer_ItemsBtn.click();
	}
	
	public WebElement RequestButton()
	{
		return RequestBtn;
	}
	
	public void Click_Add_Inventory_ItemButtonTwo()
	{
		Add_Inventory_ItemTwoBtn.click();
	}
	
	
	public void Select_Source(String StoreName) throws Exception
	{
		Source_InputBx.click();
		
		Thread.sleep(1000);
		new Common_XPaths(driver, test).Search(StoreName);
		
		new Common_XPaths(driver, test).First_Option_inDropDown.click();
		
		
	}
	
	public void Add_Inventory_Items_TransferRequest(String Quantity) throws Exception
	{
		Thread.sleep(2000);

		List<WebElement> invList=driver.findElements(By.xpath("//h5[contains(.,'Items To be Transferred')]/../..//app-input-table/div/div//app-selectbox//input"));
		
		for(int i=2;i<=invList.size()+1;i++)
		{
		
			Thread.sleep(1000);
			//Select Item
			driver.findElement(By.xpath("//h5[contains(.,'Items To be Transferred')]/../..//app-input-table/div/div["+i+"]//app-selectbox//input")).click();
			
			List<WebElement> itemList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));

			
			int itemSize=itemList.size();
			
			if(itemSize<=5)
			{
				Thread.sleep(1000);
				int randomitem=ThreadLocalRandom.current().nextInt(1, itemSize);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomitem+"]//select-option")).click();

			}
			else
			{
				Thread.sleep(1000);
				int randomitem=ThreadLocalRandom.current().nextInt(1, 5);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomitem+"]//select-option")).click();

			}
			
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//h5[contains(.,'Items To be Transferred')]/../..//div["+i+"]/div[4]/app-input/div/div//input")).clear();
			//Enter the Quantity
			driver.findElement(By.xpath("//h5[contains(.,'Items To be Transferred')]/../..//div["+i+"]/div[4]/app-input/div/div//input")).sendKeys(Quantity);
			
			
		
		}
	}
	
	public WebElement Quantity_NotAvailable_ErrorMsg_TransferRequest()
	{
		return Quantity_NotAvailable_ErrorMsg_TransferRequest;
	}
	
	public void Approve_Transfer_Request(String Quantity) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		try
		{
		if(Quantity_NotAvailable_ErrorMsg_TransferRequest().isDisplayed())
		{
			
			Click_Transfer_ItemsButton();
			
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Request Declined - You don't have sufficient items to make transfer or you don't have this item in your store!."))
			{
				test.log(LogStatus.PASS, "Request Declined - You don't have sufficient items to make transfer or you don't have this item in your store is Error Message Displayed");
			}
			else
			{
				test.log(LogStatus.FAIL, "You don't have sufficient items to make transfer or you don't have this item in your store is Error Message not Displayed");
		
			}
		}
		}
		catch(Exception k)
		{
			List<WebElement> invList=driver.findElements(By.xpath("//h5[contains(.,'Items To be Transferred')]/../..//app-input-table/div/div//app-selectbox//input"));
			
			for(int i=2;i<=invList.size()+1;i++)
			{
				
				String Req_Qty=driver.findElement(By.xpath("//h5[contains(.,'Items To be Transferred')]/../..//div["+i+"]/div[4]/app-input/div/div//input")).getAttribute("value");
				
				if(Req_Qty.equalsIgnoreCase("5"))
				{
					test.log(LogStatus.PASS, "Requested Quantity Reflected Correctly");
					
				}
				else
				{
					test.log(LogStatus.FAIL, "Requested Quantity Reflected Incorrectly");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
					
				}

				Thread.sleep(1000);
				//Clear the Quantity
				driver.findElement(By.xpath("//h5[contains(.,'Items To be Transferred')]/../..//div["+i+"]/div[4]/app-input/div/div//input")).clear();
				//Enter the Quantity
				driver.findElement(By.xpath("//h5[contains(.,'Items To be Transferred')]/../..//div["+i+"]/div[4]/app-input/div/div//input")).sendKeys(Quantity);
				
			}
			
			//Click the Transfer Items
		Click_Transfer_ItemsButton();
			
			//Verify whether the Transfer Items Transferred or not
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Items Transferred Successfully"))
			{
				test.log(LogStatus.PASS, "Items Transferred Successfully");
			}
			else
			{
				test.log(LogStatus.FAIL, "Items Transfer Failed");
				
			}
			
		}

	}
	
	
	
	//////////////////////////// Transfer Logs   ///////////////////////////////

	@FindBy(xpath = "//label[contains(.,'Type')]/../../input")
	WebElement Type_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Transfer Status')]/../../input")
	WebElement Transfer_StatusInputBx;
	
	@FindBy(xpath = "//td[contains(.,'Transfer Logs not found')]")
	WebElement No_TransferLogsErrorMsg;

	public void Select_Type(String Option)
	{
		Type_InputBx.click();
		
		driver.findElement(By.xpath("//select-option[contains(.,'"+Option+"')]")).click();
	}
	
	public WebElement Type_InputBox()
	{
		return Type_InputBx;
	}
	
	public void Select_Transfer_Status(String Option)
	{
		Transfer_StatusInputBx.click();
		
		driver.findElement(By.xpath("//select-option[contains(.,'"+Option+"')]")).click();
	}
	
	public WebElement No_TransferLogsErrorMsg()
	{
		return No_TransferLogsErrorMsg;
	}
	
	
	//////////////////// Purchase Invoice  ////////////////////////
	
	@FindBy(xpath = "//button[contains(.,'NEW PURCHASE ORDER')]")
	WebElement New_Purchase_OrderBtn;
	
	@FindBy(xpath = "//app-selectbox[@name='vendor']//input")
	WebElement Vendor_InputBx;
	
	@FindBy(xpath = "//app-selectbox[@name='placedVia']//input")
	WebElement Place_Order_ViaInputBx;
	
	@FindBy(xpath = "//button[contains(.,'PLACE ORDER')]")
	WebElement Place_Order_btn;

	@FindBy(xpath = "//button[@mattooltip='Click to see actions']")
	WebElement Actions_inPurchaseOrderBtn;
	
	@FindBy(xpath = "//button[contains(.,'Receive')]")
	WebElement Receive_PurchaseOrderBtn;
	
	@FindBy(xpath = "//button[contains(.,'Print')]")
	WebElement Print_PurchaseOrderBtn;
	
	@FindBy(xpath = "//button[contains(.,'Edit')]")
	WebElement Edit_PurchaseOrderBtn;
	
	@FindBy(xpath = "//button[contains(.,'Cancel')]")
	WebElement Cancel_PurchaseOrderBtn;
	
	@FindBy(xpath = "//button[contains(.,'Check Logs')]")
	WebElement Check_Logs_PurchaseOrderBtn;
	
	@FindBy(xpath = "//button[contains(.,'Repeat Order')]")
	WebElement Repeat_Order_PurchaseOrderBtn;
	
	@FindBy(xpath = "//button[contains(.,'Save As Template')]")
	WebElement Save_As_Template_PurchaseOrderBtn;	
	
	@FindBy(xpath = "//button[contains(.,'RECEIVE ITEMS')]")
	WebElement Receive_ItemsBtn;
	
	@FindBy(xpath = "//span[contains(.,'Purchase Invoices not found')]")
	WebElement No_Purchase_InvoiceFoundErrorMsg;
	
	@FindBy(xpath = "//label[contains(.,'Vendor Invoice No')]/../../input")
	WebElement Vendor_Invoice_NoInputBx;
	
	@FindBy(xpath = "//h3[contains(.,'Purchase Order')]")
	WebElement Purchase_OrderHeader;
	
	public WebElement Place_Order_ViaInputBx() {
		
		return Place_Order_ViaInputBx;
	}
	
	
	public void Click_New_Purchase_Order()
	{
		New_Purchase_OrderBtn.click();
	}
	
	public void Click_Place_OrderButton()
	{
		Place_Order_btn.click();
	}
	
	public void Click_Receive_ItemsButton()
	{
		Receive_ItemsBtn.click();
	}
	
	public WebElement No_Purchase_InvoiceFoundErrorMsg()
	{
		return No_Purchase_InvoiceFoundErrorMsg;
	}
	
	public WebElement Purchase_OrderHeader()
	{
		return Purchase_OrderHeader;
	}
	
	public void Enter_Vendor_Invoice_No(String InvNo) throws Exception
	{
		Thread.sleep(1000);
		Vendor_Invoice_NoInputBx.clear();
		Thread.sleep(500);
		Vendor_Invoice_NoInputBx.sendKeys(InvNo);
	}
	
	public WebElement Vendor_InputBox()
	{
		return Vendor_InputBx;
	}
	
	public void Select_Vendor() throws Exception
	{
		Thread.sleep(2000);
		new Common_XPaths(driver, test).Click_DropDown_withSearch(Vendor_InputBx, "Vendor Selected");
		
//		Vendor_InputBx.click();
//		Thread.sleep(1000);
//		List<WebElement> itemList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
//
//		
//		int itemSize=itemList.size();
//		
//		if(itemSize<=5)
//		{
//			Thread.sleep(1000);
//			int randomitem=ThreadLocalRandom.current().nextInt(1, itemSize);
//			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomitem+"]//select-option")).click();
//
//		}
//		else
//		{
//			Thread.sleep(1000);
//			int randomitem=ThreadLocalRandom.current().nextInt(1, 5);
//			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomitem+"]//select-option")).click();
//
//		}
		
	}
	
	public void Select_Place_Order_Via(String select) throws Exception
	{
		Thread.sleep(1000);
		Place_Order_ViaInputBx.click();
		
		Thread.sleep(1000);
		if(select.equalsIgnoreCase("Email"))
		{
			driver.findElement(By.xpath("//select-option[contains(.,'"+select+"')]")).click();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//app-input[@name='storePoEmails']//input")).clear();
			Thread.sleep(500);
			driver.findElement(By.xpath("//app-input[@name='storePoEmails']//input")).sendKeys("raja.s@mail.com");
		}
		else
		{
			driver.findElement(By.xpath("//select-option[contains(.,'"+select+"')]")).click();

		}
	}
	
	
	public void Select_Inventory_Items_PurchaseOrder(String Quantity) throws Exception
	{
		Thread.sleep(1000);
		List<WebElement> invList=driver.findElements(By.xpath("//h5[contains(.,'Items to Be Ordered')]/../..//app-input-table/div/div//app-selectbox//input"));
		
		for(int i=2;i<=invList.size()+1;i++)
		{
		
			Thread.sleep(1000);
			//Select Item
			driver.findElement(By.xpath("//h5[contains(.,'Items to Be Ordered')]/../..//app-input-table/div/div["+i+"]//app-selectbox//input")).click();
			
			List<WebElement> itemList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));

			
			int itemSize=itemList.size();
			
			if(itemSize<=5)
			{
				Thread.sleep(1000);
				int randomitem=ThreadLocalRandom.current().nextInt(1, itemSize);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomitem+"]//select-option")).click();

			}
			else
			{
				Thread.sleep(1000);
				int randomitem=ThreadLocalRandom.current().nextInt(1, 5);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomitem+"]//select-option")).click();

			}
			
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//h5[contains(.,'Items to Be Ordered')]/../..//div["+i+"]/div[4]/app-input/div/div//input")).clear();
			//Enter the Quantity
			driver.findElement(By.xpath("//h5[contains(.,'Items to Be Ordered')]/../..//div["+i+"]/div[4]/app-input/div/div//input")).sendKeys(Quantity);
			
			Thread.sleep(500);
			IncreaseItem_UpArrow.click();
		
		}
	}
	
	public void Receive_Purchase_Order(String PurOrderID) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		Thread.sleep(1000);
		new Common_XPaths(driver, test).SearchBox.clear();
		new Common_XPaths(driver, test).SearchBox.sendKeys(PurOrderID);
		
		new Common_XPaths(driver, test).Wait_ForElementVisibility(Actions_inPurchaseOrderBtn, 40);
		//Click the Actions button
		Actions_inPurchaseOrderBtn.click();
		
		//click the Receive button
		Receive_PurchaseOrderBtn.click();
		
		Thread.sleep(3000);
		new Common_XPaths(driver, test).VerifyCreationScreenPageHeader("Receive Purchase Order");
		
		Thread.sleep(2000);
		Receive_ItemsBtn.click();
		
		new Common_XPaths(driver, test).Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Receive information updated."))
		{
			test.log(LogStatus.PASS, "Purchase Order Received Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Purchase Order Receive Failed");
	
		}
	}
	
	//div[contains(@class,'cdk-drop-list')]/div[]/div/data-grid-row/div/div[1]

	/////////////// Prepare SubRecipe  ///////////////
	
	@FindBy(xpath = "//button[contains(.,'PREPARE SUB RECIPE')]")
	WebElement Prepare_SubRecipeBtn;
	
	@FindBy(xpath = "//label[contains(.,'Sub Recipe')]/../../input")
	WebElement SubRecipe_InputBx;
	
	public void Click_Prepare_SubRecipeButton()
	{
		Prepare_SubRecipeBtn.click();
	}
	
	public void Select_InventoryItem(String Option) throws Exception
	{
		new Common_XPaths(driver, test).Click_DropDown_withSearchText(Inventory_Item_InputBx, Option, "Inventory Item Selected");

//		Thread.sleep(1000);
//		SubRecipe_InputBx.click();
//		
//		new Common_XPaths(driver, test).SearchBox_DropDown.clear();
//		new Common_XPaths(driver, test).SearchBox_DropDown.sendKeys(Option);
//		
//		
//		Thread.sleep(2000);
//		new Common_XPaths(driver, test).First_Option_inDropDown.click();
		
	}
	
	public void Select_SubRecipe(String Option) throws Exception
	{
		new Common_XPaths(driver, test).Click_DropDown_withSearchText(SubRecipe_InputBx, Option, "Sub Recipe Selected");

//		Thread.sleep(1000);
//		SubRecipe_InputBx.click();
//		
//		new Common_XPaths(driver, test).SearchBox_DropDown.clear();
//		new Common_XPaths(driver, test).SearchBox_DropDown.sendKeys(Option);
//		
//		
//		Thread.sleep(2000);
//		new Common_XPaths(driver, test).First_Option_inDropDown.click();
		
	}
	
	public WebElement SubRecipe_InputBox()
	{
		return SubRecipe_InputBx;
	}
	
	
	////////////////// Prepare Menu Item  /////////////////
	
	@FindBy(xpath = "//button[contains(.,'Produce Menu Item')]")
	WebElement Produce_Menu_ItemBtn;
	
	@FindBy(xpath = "//div[.='PRODUCTION'][contains(@class,'mat-tab-label-content')]/..")
	WebElement Production_Tab;
	
	@FindBy(xpath = "//div[.='PRODUCTION LOG'][contains(@class,'mat-tab-label-content')]/..")
	WebElement Production_LogTab;
	
	@FindBy(xpath = "//label[contains(.,'Menu Item')]/../../input")
	WebElement Menu_Item_InputBx;
	
	@FindBy(xpath = "//input[@data-placeholder='Search by PLU Code']")
	WebElement Search_byPLU_CodeInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Quantity To Prepare')]/../../input")
	WebElement Quantity_To_PrepareInputBx;
	

	
	public void Click_Produce_Menu_ItemButton()
	{
		Produce_Menu_ItemBtn.click();
	}
	
	public void Click_ProductionTab()
	{
		new Common_XPaths(driver, test).Click_Wait_ForElementClickable(Production_Tab, 20);
	}
	
	public void Click_Production_Log()
	{
		new Common_XPaths(driver, test).Click_Wait_ForElementClickable(Production_LogTab, 20);
	
	}
	
	public WebElement Menu_Item_InputBox()
	{
		return Menu_Item_InputBx;
	}
	
	public WebElement Search_byPLU_CodeInputBox()
	{
		return Search_byPLU_CodeInputBx;
	}
	
	public WebElement Quantity_To_PrepareInputBox()
	{
		return Quantity_To_PrepareInputBx;
	}
	
	public void Click_Add_Link_IconInventoryMenuItemButton()
	{
		Add_Link_IconInventoryMenuItemBtn.click();
	}
	
	///////////// Prepare Menu Item - Production Log //////////////
	@FindBy(xpath = "//label[contains(.,'Consumption Status')]/../../input")
	WebElement Consumption_StatusInputBx;
	
	@FindBy(xpath = "//span[contains(.,'No production Record for Selected Menu Item')]")
	WebElement No_Production_Record_PrepareMenuItem_Logs;
	
	@FindBy(xpath = "//input[contains(@data-placeholder,'Search')]")
	WebElement SearchBox;
	
	public void Click_Wait_ForElementClickable(WebElement ele,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
	}
	
	public void Wait_ForElementVisibility(WebElement ele,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	
	public void SearchAndClickEdit(String SearchValue) throws Exception
	{
		
		Wait_ForElementVisibility(SearchBox, 180);
	
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(2000);
		try
		{
			Thread.sleep(2000);
		driver.findElement(By.xpath("//span[.=' "+SearchValue+" ']/../../td//div[1]/button")).click();
		
		}
		catch(Exception g)
		{
			
			Thread.sleep(2000);

			driver.findElement(By.xpath("//span[.='"+SearchValue+" ']/../../div//div[1]/button")).click();
		}
		
		}
	
	public void SearchAndClickActivate(String SearchValue) throws Exception
	{
//		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(300));
		Wait_ForElementVisibility(SearchBox, 180);
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(1000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(2000);
		
		try
		{
		driver.findElement(By.xpath("//span[.=' "+SearchValue+" ']/../../td//div/button")).click();
		}
		catch(Exception h)
		{
			driver.findElement(By.xpath("//span[.='"+SearchValue+" ']/../../div//div/button")).click();

		}
	}
	public void SearchAndClickDelete(String SearchValue) throws Exception
	{
		Wait_ForElementVisibility(SearchBox, 180);
		try
		{
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[.=' "+SearchValue+" ']/../../td//div[2]/button")).click();
		Thread.sleep(1000);
		}
		catch(Exception h)
		{
			Thread.sleep(1000);
			SearchBox.clear();
			Thread.sleep(2000);

			SearchBox.sendKeys(SearchValue);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//span[.='"+SearchValue+" ']/../../div//div[2]/button")).click();
			Thread.sleep(1000);
		}
	}
	
	public void Select_Consumption_Status(String Option) throws Exception
	{
		new Common_XPaths(driver, test).Click_DropDown_withSearchText(Consumption_StatusInputBx, Option, "Comsumption Status Selected");
	}
	
	public WebElement No_Production_Record_PrepareMenuItem_Logs()
	{
		return No_Production_Record_PrepareMenuItem_Logs;
	}
	
	public void Click_Plus_ActionBtn()
	{
		Action_Inventory_PlusBtn.click();
	}
	
	
	/////////////////// Received Logs  /////////////////////
	
	@FindBy(xpath = "//button[contains(.,'RECEIVE NEW ITEM')]")
	WebElement Receive_New_ItemBtn;
	
	@FindBy(xpath = "//span[contains(.,'No purchase records for selected items or time period')]")
	WebElement No_Purchase_RecordsErrorMsg;
	
	public void Click_Receive_New_Item()
	{
		Receive_New_ItemBtn.click();
	}
	
	public WebElement No_Purchase_RecordsErrorMsg()
	{
		return No_Purchase_RecordsErrorMsg;
	}
	
	/////////////// Vendors ////////////////////
	
	@FindBy(xpath = "//button[contains(.,'NEW VENDOR')]")
	WebElement New_VendorBtn;
	
	@FindBy(xpath = "//h6[contains(.,'General')]/../div[1]//label[contains(.,'Name')]/../../input")
	WebElement Name_VendorNameInputBx;
	
	@FindBy(xpath = "//h6[contains(.,'General')]/../div[1]//label[contains(.,'Phone Number')]/../../input")
	WebElement Phone_Number_VendorInputBx;
	
	@FindBy(xpath = "//label[contains(.,'E-Mail')]/../../input")
	WebElement Email_VendorInputBx;
	
	@FindBy(xpath = "//h6[contains(.,'Contact')]/../div[4]//label[contains(.,'Name')]/../../input")
	WebElement Contact_NameVendorInputBx;
	
	@FindBy(xpath = "//h6[contains(.,'Contact')]/../div[4]//label[contains(.,'Phone Number')]/../../input")
	WebElement Contact_Phone_Number_VendorInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Address Line')]/../../input")
	WebElement Address_Line1InputBx;
	
	@FindBy(xpath = "//label[contains(.,' Apt, Suite, etc. ')]/../../input")
	WebElement Apartment_SuiteVendorInputBx;
	
	@FindBy(xpath = "//label[contains(.,'City')]/../../input")
	WebElement City_VendorInputBx;
	
	@FindBy(xpath = "//label[contains(.,'State')]/../../input")
	WebElement State_VendorInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Zip Code')]/../../input")
	WebElement ZipCode_VendorInputBx;
	
	public void Click_New_Vendor() 
	{
		New_VendorBtn.click();
	}
	
	public WebElement Name_VendorNameInputBox()
	{
		return Name_VendorNameInputBx;
	}
	
	public void Enter_Vendor_Name(String VendorName) throws Exception
	{
		Thread.sleep(1000);
		Name_VendorNameInputBx.clear();
		
		Name_VendorNameInputBx.sendKeys(VendorName);
	}
	
	public void Enter_VendorPhone_Number(String Phone) throws Exception
	{
		Thread.sleep(1000);
		Phone_Number_VendorInputBx.clear();
		
		Phone_Number_VendorInputBx.sendKeys(Phone);
	}
	
	public void Enter_Vendor_Email(String Email) throws Exception
	{
		Thread.sleep(1000);
		Email_VendorInputBx.clear();
		
		Email_VendorInputBx.sendKeys(Email);
	}
	
	public void Enter_Vendor_ContactDetails(String ContactName,String ContactPhone) throws Exception
	{
		Thread.sleep(1000);
		Contact_NameVendorInputBx.clear();
		
		Contact_NameVendorInputBx.sendKeys(ContactName);
		
		Thread.sleep(1000);
		Contact_Phone_Number_VendorInputBx.clear();
		
		Contact_Phone_Number_VendorInputBx.sendKeys(ContactPhone);
	}
	
	public void Enter_AddressDetails(String AddressLine,String City,String State, String Zipcode) throws Exception
	{
		Thread.sleep(1000);
		Address_Line1InputBx.clear();
		Address_Line1InputBx.sendKeys(AddressLine);
		
		Thread.sleep(1000);
		City_VendorInputBx.clear();
		City_VendorInputBx.sendKeys(City);
		
		Thread.sleep(1000);
		State_VendorInputBx.clear();
		State_VendorInputBx.sendKeys(State);
		
		Thread.sleep(1000);
		ZipCode_VendorInputBx.clear();
		ZipCode_VendorInputBx.sendKeys(Zipcode);
		
	}
	
	
	////////// Inventory - Storage Location ////////////
	
	@FindBy(xpath = "//button[contains(.,'NEW STORAGE LOCATION')]")
	WebElement New_Storage_Location;
	
	public void Click_New_Storage_Location()
	{
		New_Storage_Location.click();
	}
	
	
	////////////// Inventory - Inventory Item  //////////////
	
	@FindBy(xpath = "//button[contains(.,'NEW INVENTORY ITEM')]")
	WebElement New_Inventory_Item;
	
	public void Click_New_Inventory_Item()
	{
		New_Inventory_Item.click();
	}
	
	
	////////// Inventory Menu Item /////////////////
	
	@FindBy(xpath = "//button[contains(@class,'segment-button')][.='All']")
	WebElement All_Tab;
	
	@FindBy(xpath = "//button[contains(@class,'segment-button')][.='LINKED ITEMS']")
	WebElement Linked_Tab;
	
	@FindBy(xpath = "//button[contains(@class,'segment-button')][contains(.,'UNLINKED ITEMS')]")
	WebElement Unlinked_Tab;
	
	public void Click_All_Tab()
	{
		All_Tab.click();
	}
	
	public void Click_Linked_Tab()
	{
		Linked_Tab.click();
	}
	
	public void Click_Unlinked_Tab()
	{
		Unlinked_Tab.click();
	}
	
	////////////// Inventory Reports ////////////
	
	@FindBy(xpath = "//label[contains(.,'Category Level')]/../../input")
	WebElement Category_LevelInputBx;
	
	@FindBy(xpath = "//label[.=' Category ']/../../input")
	WebElement Category_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Sub Category')]/../../input")
	WebElement Sub_CategoryInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Retail Item')]/../../input")
	WebElement Retail_ItemInputBx;
	
	public void Select_Category_Level(String Option)
	{
		Category_LevelInputBx.click();
		
		driver.findElement(By.xpath("//select-option[contains(.,'"+Option+"')]")).click();
	}
	
	public void Select_Category_inInvReports(String Option)
	{
		Category_InputBx.click();
		
		driver.findElement(By.xpath("//select-option[contains(.,'"+Option+"')]")).click();
	}
	
	public void Select_SubCategory_inInvReports(String Option)
	{
		Sub_CategoryInputBx.click();
		
		driver.findElement(By.xpath("//select-option[contains(.,'"+Option+"')]")).click();
	}
	
	public void Select_ReasonType(String Option)
	{
		Reason_Type_Adj_InvInputBx.click();
		
		driver.findElement(By.xpath("//select-option[contains(.,'"+Option+"')]")).click();
	}
	
	public void Select_Retail_Item(String Option)
	{
		Retail_ItemInputBx.click();
		
		driver.findElement(By.xpath("//select-option[contains(.,'"+Option+"')]")).click();
	}
	
	
	@FindBy(xpath = "//span[contains(.,'Adjust Inventory Report not found')]")
	WebElement No_Adjust_Inventory_ReportFoundInfoMsg;
	
	public WebElement No_Adjust_Inventory_ReportFoundInfoMessage()
	{
		return No_Adjust_Inventory_ReportFoundInfoMsg;
	}
	
	@FindBy(xpath = "//span[contains(.,'Wastage Report not found')]")
	WebElement No_Wastage_Report_FoundInfoMsg;
	
	public WebElement No_Wastage_Report_Found_InfoMessage()
	{
		return No_Wastage_Report_FoundInfoMsg;
	}
	

public void SearchAndVerify_SearchBox() throws Exception
	{
		
		try
		{
			
		if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).isDisplayed())
		{
		String SearchText=driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText().substring(0, 3);

		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchText);
		Thread.sleep(2000);
		
		
		
		if(driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Searched item displayed when entering 3 Characters in Search Box");
		}
		else
		{
			test.log(LogStatus.FAIL, "Searched item not displayed when entering 3 Characters in Search box");
		}
		}
		}
		catch(Exception k)
		{
			if(driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr/td[2]")).isDisplayed())
			{
				String SearchText=driver.findElement(By.xpath("//tbody[contains(@role,'rowgroup')]/tr/td[2]")).getText().substring(0, 3);

				Thread.sleep(1000);
				SearchBox.clear();
				Thread.sleep(2000);

				SearchBox.sendKeys(SearchText);
				Thread.sleep(2000);
				
				
				
				if(driver.findElement(By.xpath("///tbody[contains(@role,'rowgroup')]/tr/td[2]")).isDisplayed())
				{
					test.log(LogStatus.PASS, "Searched item displayed when entering 3 Characters in Search Box");
				}
				else
				{
					test.log(LogStatus.FAIL, "Searched item not displayed when entering 3 Characters in Search box");
				}
			}
		}
	}
}
