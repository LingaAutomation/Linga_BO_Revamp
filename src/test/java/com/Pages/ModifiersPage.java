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

public class ModifiersPage {

	
	public WebDriver driver;
	public ExtentTest test;
	
	Common_XPaths cmp=new Common_XPaths(driver, test);
	Utility ut=new Utility();
	
	public ModifiersPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'NEW MODIFIER')]")
	WebElement New_ModifierBtn;
	
	@FindBy(xpath = "//label[contains(.,'Secondary Name')]/../../input")
	WebElement Secondary_NameInputBox;
	
	@FindBy(xpath = "//label[contains(.,'PLU Code')]/../../input")
	WebElement PLU_CodeInputBox;
	
	@FindBy(xpath = "//label[contains(.,'Maximum No of Times')]/../../input")
	WebElement Maximum_NoTimesInputBox;
	
	@FindBy(xpath = "//div[.=' Enter valid maximum number of times']")
	WebElement Max_TimesErrorMsg;
	
	@FindBy(xpath = "//label[contains(.,'Modify With')]/../../input")
	WebElement ModifyWith_DropBtn;
	
	@FindBy(xpath = "//button[contains(.,'Add Prefix')]")
	WebElement Add_PrefixBtn;
	
	@FindBy(xpath = "//button[contains(.,'Add Serving Size Level')]")
	WebElement Add_ServingSizeLevelBtn;
	
	@FindBy(xpath = "//span[contains(.,'Show Modifier')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement ShowModifier_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Show Modifier')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement ShowModifier_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Show MenuItem In Modifier Print')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement ShowMenuItemModiInPrint_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Show MenuItem In Modifier Print')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement ShowMenuItemModiInPrint_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Show Modifier In Menu Print')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement ShowModifierInMenuPrint_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Show Modifier In Menu Print')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement ShowModifierInMenuPrint_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Set Price Here')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement SetPriceHere_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Set Price Here')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement SetPriceHere_NoBtn;

	@FindBy(xpath = "//mat-step-header[contains(.,'Proceed to Inventory Mapping')]")
	WebElement ProceedToInventoryMappingTab;
	
	@FindBy(xpath = "//app-information-content/div/div/div/div/span")
	WebElement InfoContent;
	
	@FindBy(xpath = "//h6[contains(.,'Modifiers and Prefixes')]/../../div[2]/mat-accordion/app-accordion/div/mat-expansion-panel/div/div/div/div[2]/div/app-radio-box-button/div/div/div/div[.='Item']")
	WebElement First_ItemTypeBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Modifiers and Prefixes')]/../../div[2]/mat-accordion/app-accordion/div/mat-expansion-panel/div/div/div/div[2]/div/app-radio-box-button/div/div/div/div[.='Menu item']")
	WebElement First_MenuItemTypeBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Modifiers and Prefixes')]/../../div[2]/mat-accordion/app-accordion/div/mat-expansion-panel/div/div/div/div[2]/div/app-radio-box-button/div/div/div/div[.='Sub Recipe']")
	WebElement First_SubRecipeTypeBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Modifiers and Prefixes')]/../../div[2]/mat-accordion/app-accordion/div/mat-expansion-panel/div/div/div[2]/div/app-selectbox/div/mat-form-field/div/div/div[3]/input")
	WebElement First_SubRecipeTypeInput;
	
	@FindBy(xpath = "//h6[contains(.,'Modifiers and Prefixes')]/../../div[2]/mat-accordion/app-accordion/div/mat-expansion-panel/div/div/div[2]/div[1]/app-selectbox/div/mat-form-field/div/div/div[3]/input")
	WebElement First_CategoryInput;
	
	@FindBy(xpath = "//h6[contains(.,'Modifiers and Prefixes')]/../../div[2]/mat-accordion/app-accordion/div/mat-expansion-panel/div/div/div[2]/div[2]/app-selectbox/div/mat-form-field/div/div/div[3]/input")
	WebElement First_InventoryItemInput;
	
	@FindBy(xpath = "//h6[contains(.,'Modifiers and Prefixes')]/../../div[3]/mat-accordion/app-accordion/div/mat-expansion-panel/div/div/div/div[2]/div/app-radio-box-button/div/div/div/div[.='Item']")
	WebElement Second_ItemTypeBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Modifiers and Prefixes')]/../../div[3]/mat-accordion/app-accordion/div/mat-expansion-panel/div/div/div/div[2]/div/app-radio-box-button/div/div/div/label[.='Sub Recipe']")
	WebElement Second_SubRecipeTypeBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Modifiers and Prefixes')]/../../div[3]/mat-accordion/app-accordion/div/mat-expansion-panel/div/div/div[2]/div/app-selectbox/div/mat-form-field/div/div/div[3]/input")
	WebElement Second_SubRecipeTypeInput;
	
	@FindBy(xpath = "//h6[contains(.,'Modifiers and Prefixes')]/../../div[3]/mat-accordion/app-accordion/div/mat-expansion-panel/div/div/div[2]/div[1]/app-selectbox/div/mat-form-field/div/div/div[3]/input")
	WebElement Second_CategoryInput;
	
	@FindBy(xpath = "//h6[contains(.,'Modifiers and Prefixes')]/../../div[3]/mat-accordion/app-accordion/div/mat-expansion-panel/div/div/div[2]/div[2]/app-selectbox/div/mat-form-field/div/div/div[3]/input")
	WebElement Second_InventoryItemInput;
	
	@FindBy(xpath = "//div[@id='new-modifier-serving-sizes-prefixes']/div[3]/app-input-table[1]/div/div/div[1]/app-input/div/div/mat-form-field/div/div/div[4]/input")
	WebElement PrefixInputColumn;
	
	@FindBy(xpath = "//div[@class='serving-size-prefix-row']/div/div/div/app-selectbox[contains(@id,'servingSize')]/div/mat-form-field/div/div/div[3]/input")
	WebElement ServingSizeLevelInputColumn;
	
	public WebElement PrefixInputColumn()
	{
		return PrefixInputColumn;
	}
	
	public WebElement ServingSizeLevelInputColumn()
	{
		return ServingSizeLevelInputColumn;
	}
	
	//h6[contains(.,'Modifiers and Prefixes')]/../../div[ 3]/mat-accordion/app-accordion/div/mat-expansion-panel/div/div/div/div[2]/div/app-radio-box-button/div/div/div/label[.='Item']
	//h6[contains(.,'Modifiers and Prefixes')]/../../div[ 3]/mat-accordion/app-accordion/div/mat-expansion-panel/div/div/div/div[2]/div/app-radio-box-button/div/div/div/label[.='Sub Recipe']
	//2nd row sub recipe input
	//h6[contains(.,'Modifiers and Prefixes')]/../../div[3]/mat-accordion/app-accordion/div/mat-expansion-panel/div/div/div[2]/div/app-selectbox/div/mat-form-field/div/div/div[3]/input
	//2nd row category
	//h6[contains(.,'Modifiers and Prefixes')]/../../div[3]/mat-accordion/app-accordion/div/mat-expansion-panel/div/div/div[2]/div[1]/app-selectbox/div/mat-form-field/div/div/div[3]/input
	//2nd row inventory item
	//h6[contains(.,'Modifiers and Prefixes')]/../../div[3]/mat-accordion/app-accordion/div/mat-expansion-panel/div/div/div[2]/div[2]/app-selectbox/div/mat-form-field/div/div/div[3]/input
	
	public WebElement InfoContent()
	{
		return InfoContent;
	}
	
	
	public WebElement ProceedToInventoryMappingTab()
	{
		return ProceedToInventoryMappingTab;
	}
	
	//mat-step-header[contains(.,'Proceed to Inventory Mapping')]/div[2]
	@FindBy(xpath = "//mat-step-header[contains(.,'Basic Details')]")
	WebElement BasicDetailsTab;
	
	@FindBy(xpath = "//mat-step-header[contains(.,'Serving Size and Prefix Levels')]")
	WebElement ServingSizePrefixTab;
	
	@FindBy(xpath = "//button[contains(.,'SAVE AND PROCEED')]")
	WebElement SaveAndProceedBtn;
	
	@FindBy(xpath = "//button[contains(.,'Proceed without saving')]")
	WebElement ProceedwithoutSavingBtn;
	
	
	
	
	public void Click_NewModifier()
	{
		New_ModifierBtn.click();
	}
	
	
	public void Enter_SecondaryName(String str)
	{
		Secondary_NameInputBox.clear();
		
		Secondary_NameInputBox.sendKeys(str);
	}
	
	public void Enter_PLUCode(String str)
	{
		PLU_CodeInputBox.clear();
		
		PLU_CodeInputBox.sendKeys(str);
	}
	
	
	public void Enter_MaximumNoOfTimes(String str)
	{
		Maximum_NoTimesInputBox.clear();
		
		Maximum_NoTimesInputBox.sendKeys(str);
	}
	
	public WebElement Maximum_NoTimesInputBox()
	{
		return Maximum_NoTimesInputBox;
		
	}
	
	public WebElement Max_TimesErrorMsg()
	{
		return Max_TimesErrorMsg;
	}
	
	public void Verify_Maximum_No_ofTimesErrorMsg()
	{
		try
		{
		if(Max_TimesErrorMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter valid maximum number of times Displayed when Entering Negative values");
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Enter valid maximum number of times not diisplayed when Entering Negative values");
		}
		
	}
	
	public void Select_ModifyWith() throws Exception
	{
		Thread.sleep(1000);
		ModifyWith_DropBtn.click();
		
		
		List<WebElement> ModifyWithList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		int ModifyWithSize=ModifyWithList.size();
		
		
		if(ModifyWithSize==0)
		{
			
			List<WebElement> ModifyWithList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
			
			int ModifyWithSize1=ModifyWithList1.size();
			
			
			int randomModifyWith=ThreadLocalRandom.current().nextInt(1, ModifyWithSize1);
			
			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomModifyWith+"]")).click();
		
		}
		else if(ModifyWithSize==1)
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+ModifyWithSize+"]")).click();
		
		}
		else if(ModifyWithSize<=10)
		{
			
		int randomModifyWith=ThreadLocalRandom.current().nextInt(1, ModifyWithSize);
		
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomModifyWith+"]")).click();
		}
		else
		{
			int randomModifyWith=ThreadLocalRandom.current().nextInt(1, 10);
			
			Thread.sleep(1000);

			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomModifyWith+"]")).click();
			
		}
		
		List<WebElement> ModifyWithList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));

		if(ModifyWithList1.size()!=0)
		{
			ModifyWith_DropBtn.click();
			
		}
	}
	
	public void Select_ModifierTax()
	{
		List<WebElement> ModifTaxList=driver.findElements(By.xpath("//div[@id='new-modifier-tax']/div[4]/div/app-chip/div/mat-chip-list/div/mat-chip"));
		
		int ModifTaxSize=ModifTaxList.size();
		
		
		int randomModifTax=ThreadLocalRandom.current().nextInt(1, ModifTaxSize);
		
		if(driver.findElement(By.xpath("//div[@id='new-modifier-tax']/div[4]/div/app-chip/div/mat-chip-list/div/mat-chip["+randomModifTax+"]")).isSelected())
		{
			
		}
		else
		{
			driver.findElement(By.xpath("//div[@id='new-modifier-tax']/div[4]/div/app-chip/div/mat-chip-list/div/mat-chip["+randomModifTax+"]")).click();
		}
		
	}
	
	@FindBy(xpath = "//div[@id='new-modifier-kitchen-printers']//button[contains(.,'Show All')]")
	WebElement ShowAll_KitchenPrinterBtn;
	
	public void Select_ModifierKitchenPrinters() throws Exception
	{
		List<WebElement> KitchenPrinterList=driver.findElements(By.xpath("//div[@id='new-modifier-kitchen-printers']/div[3]/div/app-chip/div/mat-chip-list/div/mat-chip"));
		
		int KitchenPrinterSize=KitchenPrinterList.size();
		
		
		int randomModifKitchenPrinter=ThreadLocalRandom.current().nextInt(1, KitchenPrinterSize);
	
		if(ShowAll_KitchenPrinterBtn.isDisplayed())
		{
			Thread.sleep(1000);
			ShowAll_KitchenPrinterBtn.click();
			
			Thread.sleep(1000);
		if(driver.findElement(By.xpath("//div[@id='new-modifier-kitchen-printers']/div[3]/div/app-chip/div/mat-chip-list/div/mat-chip["+randomModifKitchenPrinter+"]")).isSelected())
		{
			
		}
		else
		{
		driver.findElement(By.xpath("//div[@id='new-modifier-kitchen-printers']/div[3]/div/app-chip/div/mat-chip-list/div/mat-chip["+randomModifKitchenPrinter+"]")).click();
		}
		}
		
	}
	
	public void Enable_ShowModifierInMenuPrint()
	{
		if(ShowModifierInMenuPrint_YesBtn.isSelected())
		{
			
		}
		else
		{
			ShowModifierInMenuPrint_YesBtn.click();
		}
	}
	
	public void Enable_ShowMenuItemInModifierPrint()
	{
		if(ShowMenuItemModiInPrint_YesBtn.isSelected())
		{
			
		}
		else
		{
			ShowMenuItemModiInPrint_YesBtn.click();
		}
	}
	
	public void Enable_ShowModifier()
	{
		if(ShowModifier_YesBtn.isSelected())
		{
			
		}
		else
		{
			ShowModifier_YesBtn.click();
		}
	}
	
	public void Disable_ShowModifierInMenuPrint()
	{
		if(ShowModifierInMenuPrint_YesBtn.isSelected())
		{
			ShowModifierInMenuPrint_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public void Click_ProceedToInventoryMappingTab()
	{
		ProceedToInventoryMappingTab.click();
	}
	
	public void Click_BasicDetailsTab()
	{
		BasicDetailsTab.click();
	}
	
	public void Click_ServingSizePrefixTab()
	{
		ServingSizePrefixTab.click();
	}
	
	public void Disable_ShowMenuItemInModifierPrint()
	{
		if(ShowMenuItemModiInPrint_YesBtn.isSelected())
		{
			ShowMenuItemModiInPrint_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public void Disable_ShowModifier()
	{
		if(ShowModifier_YesBtn.isSelected())
		{
			ShowModifier_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public void Click_AddPrefixbutton()
	{
		Add_PrefixBtn.click();
	}
	
	public void Click_AddServingSizeLevelbutton()
	{
		Add_ServingSizeLevelBtn.click();
	}
	
	public void Enter_Prefix(String str, String str2) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		
		Thread.sleep(500);
	
	for(int i=1;i<=3;i++)
	{
		Click_AddPrefixbutton();
	}
		
		List<WebElement> PrefixList=driver.findElements(By.xpath("//div[@id='new-modifier-serving-sizes-prefixes']/div[3]/app-input-table[1]/div/div/div[1]/app-input/div/div/mat-form-field/div/div/div[4]/input"));
	
		for(int i=2;i<=PrefixList.size()+1;i++)
		{
			//Prefix name
			driver.findElement(By.xpath("//div[@id='new-modifier-serving-sizes-prefixes']/div[3]/app-input-table[1]/div/div["+i+"]/div[1]/app-input/div/div/mat-form-field/div/div/div[4]/input")).clear();
			
			driver.findElement(By.xpath("//div[@id='new-modifier-serving-sizes-prefixes']/div[3]/app-input-table[1]/div/div["+i+"]/div[1]/app-input/div/div/mat-form-field/div/div/div[4]/input")).sendKeys(str+i);
			Thread.sleep(500);

			//Prefix price
			driver.findElement(By.xpath("//div[@id='new-modifier-serving-sizes-prefixes']/div[3]/app-input-table[1]/div/div["+i+"]/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")).clear();
			
			driver.findElement(By.xpath("//div[@id='new-modifier-serving-sizes-prefixes']/div[3]/app-input-table[1]/div/div["+i+"]/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")).sendKeys(str2);
			
			Thread.sleep(500);
	
			if(driver.findElement(By.xpath("//div[@id='new-modifier-serving-sizes-prefixes']/div[3]/app-input-table[1]/div/div["+i+"]/div/app-switch/div/section/mat-slide-toggle")).isSelected())
			{
				
			}
			else
			{
				driver.findElement(By.xpath("//div[@id='new-modifier-serving-sizes-prefixes']/div[3]/app-input-table[1]/div/div["+i+"]/div/app-switch/div/section/mat-slide-toggle")).click();
			}
			
		}
		
		for(int i=1;i<=2;i++)
		{
			Thread.sleep(500);
			driver.findElement(By.xpath("//div[@id='new-modifier-serving-sizes-prefixes']/div[3]/app-input-table[1]/div/div[3]/div/button")).click();
			Thread.sleep(500);

		cmp.Click_DeleteButton();
		}
		
	}
	
	public void Remove_Prefix() throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		Click_AddPrefixbutton();
		
		List<WebElement> PrefixList=driver.findElements(By.xpath("//div[@id='new-modifier-serving-sizes-prefixes']/div[3]/app-input-table[1]/div/div/div[1]/app-input/div/div/mat-form-field/div/div/div[4]/input"));
		
		for(int i=2;i<=PrefixList.size()+1;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@id='new-modifier-serving-sizes-prefixes']/div[3]/app-input-table[1]/div/div[2]/div/button")).click();
			Thread.sleep(1000);

		cmp.Click_DeleteButton();
		}
	}
	
	public void Remove_ServingSizeLevel() throws Exception
	{
	cmp=new Common_XPaths(driver, test);
		Click_AddServingSizeLevelbutton();
		
		
		List<WebElement> SizeList=driver.findElements(By.xpath("//div[@class='serving-size-prefix-row']/div/div/div/app-selectbox[contains(@id,'servingSize')]/div/mat-form-field/div/div/div[3]/input"));
		
		for(int i=2;i<=SizeList.size()+1;i++)
		{
			driver.findElement(By.xpath("//div[@class='serving-size-prefix-row']/div[2]/div[2]/button")).click();
			
			cmp.Click_DeleteButton();
		}
		
	}
	
	public void Enable_SetPriceHere()
	{
		if(SetPriceHere_YesBtn.isSelected())
		{
			
		}
		else
		{
			SetPriceHere_YesBtn.click();
		}
	}
	
	public void Disable_SetPriceHere()
	{
		if(SetPriceHere_YesBtn.isSelected())
		{
			SetPriceHere_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public void Enter_ServingSizeLevel(String str) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		Thread.sleep(500);
		for(int i=1;i<=3;i++)
		{
			Click_AddServingSizeLevelbutton();
		}
		Thread.sleep(500);

		Enable_SetPriceHere();
		Thread.sleep(500);

		List<WebElement> SizeList=driver.findElements(By.xpath("//div[@class='serving-size-prefix-row']/div/div/div/app-selectbox[contains(@id,'servingSize')]/div/mat-form-field/div/div/div[3]/input"));
		for(int k=2;k<=SizeList.size()+1;k++)
		{
			Thread.sleep(500);
			driver.findElement(By.xpath("//div[@class='serving-size-prefix-row']/div["+k+"]/div/div/app-selectbox[contains(@id,'servingSize')]/div/mat-form-field/div/div/div[3]/input")).click();
		
		List<WebElement> OpSizeList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		int OpSizeSize=OpSizeList.size();
		
		if(OpSizeSize==0)
		{
			
		}
		else if(OpSizeSize==1)
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+OpSizeSize+"]")).click();
	
		}
		else if(OpSizeSize<=10)
		{
			int randomOpSize=ThreadLocalRandom.current().nextInt(1, OpSizeSize);
			
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomOpSize+"]")).click();
			
		}
		else
		{
		int randomOpSize=ThreadLocalRandom.current().nextInt(1, 10);
		
		
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomOpSize+"]")).click();
		}
		List<WebElement> OpSizeList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));

		if(OpSizeList1.size()!=0)
		{
			driver.findElement(By.xpath("//div[@class='serving-size-prefix-row']/div["+k+"]/div/div/app-selectbox[contains(@id,'servingSize')]/div/mat-form-field/div/div/div[3]/input")).click();
			
		}
		//Enter the price here
		
		driver.findElement(By.xpath("//div[@class='serving-size-prefix-row']/div["+k+"]/div[1]/div/app-input/div/div/mat-form-field/div/div/div[4]/input")).clear();
		
		driver.findElement(By.xpath("//div[@class='serving-size-prefix-row']/div["+k+"]/div[1]/div/app-input/div/div/mat-form-field/div/div/div[4]/input")).sendKeys(str);
		
		}
		
	//	List<WebElement> delBtns=driver.findElements(By.xpath("//div[@class='serving-size-prefix-row']/div/div[2]/button"));
		for(int i=1;i<=2;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='serving-size-prefix-row']/div[3]/div[2]/button")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(.,'DELETE')]")).click();
		}
		
	
		//div[@class='serving-size-prefix-row']/div[3]/div[1]/div/app-input/div/div/mat-form-field/div/div/div[4]/input
	
	
	}
	
	public void Click_SaveAndProceed()
	{
		SaveAndProceedBtn.click();
	}
	
	public void Click_ProceedWithoutSaving()
	{
		ProceedwithoutSavingBtn.click();
	}
	
	public void Add_ItemInventoryModiferFirst()
	{
		
		 
		First_ItemTypeBtn.click();
		
		First_CategoryInput.click();
		
	List<WebElement> CatList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		int CatSize=CatList.size();
		
		if(CatSize==0)
		{
			First_CategoryInput.click();
			
			List<WebElement> CatList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
			
			int CatSize1=CatList1.size();
			
			int randomCat=ThreadLocalRandom.current().nextInt(1, CatSize1);
			
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomCat+"]")).click();
		
		}
		else if(CatSize==1)
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+CatSize+"]")).click();

		}
		else if(CatSize<=6)
		{
		int randomCat=ThreadLocalRandom.current().nextInt(1, CatSize);
		
		
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomCat+"]")).click();
		}
		else
		{
			int randomCat=ThreadLocalRandom.current().nextInt(1, 6);
			
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomCat+"]")).click();
		
		}
		
		First_InventoryItemInput.click();
		
	List<WebElement> ItemList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		int ItemSize=ItemList.size();
		
	if(ItemSize==0)
	{
		First_InventoryItemInput.click();
		
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();

	}
	else if(ItemSize==1)
	{
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+ItemSize+"]")).click();

	}
	else if(ItemSize<=6)
	{
		int randomItem=ThreadLocalRandom.current().nextInt(1, ItemSize);
		
		
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomItem+"]")).click();
	}
	else
	{
	int randomItem=ThreadLocalRandom.current().nextInt(1, 6);
		
		
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomItem+"]")).click();
	
	}
	}
	
	public void Add_MenuItemInventoryModiferFirst()
	{
	
		First_MenuItemTypeBtn.click();
		
		First_SubRecipeTypeInput.click();
		
	List<WebElement> MenuList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		int MenuSize=MenuList.size();
		
		if(MenuSize==0)
		{
			First_SubRecipeTypeInput.click();

			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();
		
		}
		else if(MenuSize==1)
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+MenuSize+"]")).click();
		
		}
		else if(MenuSize<=6)
		{
		int randomMenu=ThreadLocalRandom.current().nextInt(1, MenuSize);
		
		
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomMenu+"]")).click();
		}
		else 
		{
			int randomMenu=ThreadLocalRandom.current().nextInt(1, 6);
			
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomMenu+"]")).click();
		
		}
		
		
	}
	public void Add_SubRecipeInventoryModiferFirst()
	{
	
	
		First_SubRecipeTypeBtn.click();
		
		First_SubRecipeTypeInput.click();
		
	List<WebElement> SubRecList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		int SubRecSize=SubRecList.size();
		
		if(SubRecSize==0)
		{
			First_SubRecipeTypeInput.click();

			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();

		}
		else if(SubRecSize==1)
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+SubRecSize+"]")).click();

		}
		else if(SubRecSize<=6)
		{
		
		int randomSubRec=ThreadLocalRandom.current().nextInt(1, SubRecSize);
		
		
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomSubRec+"]")).click();
		}
		else
		{
			int randomSubRec=ThreadLocalRandom.current().nextInt(1, 6);
			
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomSubRec+"]")).click();
		}
			
		
	
	}
	public void Add_ItemInventoryModiferSecond()
	{
		try 
		{
			if(Second_ItemTypeBtn.isDisplayed())
			{
			Second_ItemTypeBtn.click();
		
		
		Second_CategoryInput.click();
		
		List<WebElement> CatList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		int CatSize=CatList.size();
		
		if(CatSize==0)
		{
			Second_CategoryInput.click();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();

		}
		else if(CatSize==1)
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+CatSize+"]")).click();
		
		}
		else if(CatSize<=6)
		{
		int randomCat=ThreadLocalRandom.current().nextInt(1, CatSize);
		
		
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomCat+"]")).click();
		}
		else
		{
			int randomCat=ThreadLocalRandom.current().nextInt(1, 6);
			
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomCat+"]")).click();
		
		}
		
		Second_InventoryItemInput.click();
		
	List<WebElement> ItemList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		int ItemSize=ItemList.size();
		
		if(ItemSize==0)
		{
			Second_InventoryItemInput.click();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();

		}
		else if(ItemSize==1)
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+ItemSize+"]")).click();
		
		}
		else if(ItemSize<=6)
		{
		int randomItem=ThreadLocalRandom.current().nextInt(1, ItemSize);
		
		
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomItem+"]")).click();
		}
		else
		{
			int randomItem=ThreadLocalRandom.current().nextInt(1, 6);
			
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomItem+"]")).click();
		
		}
		}
		}
		catch(Exception h)
		{
			
		}
		
	}
	
	public void Add_SubRecipeInventoryModiferSecond() throws Exception
	{
		try
		{ 
		if(Second_SubRecipeTypeBtn.isDisplayed())
		{
		Second_SubRecipeTypeBtn.click();
		
		Second_SubRecipeTypeInput.click();
		
		List<WebElement> SubRecList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		int SubRecSize=SubRecList.size();
		 
		if(SubRecSize==0)
		{
			Second_SubRecipeTypeInput.click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();

		}
		else if(SubRecSize==1)
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+SubRecSize+"]")).click();
	
		}
		else if(SubRecSize<=6)
		{
		int randomSubRec=ThreadLocalRandom.current().nextInt(1, SubRecSize);
		
		
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomSubRec+"]")).click();
		}
		else
		{
			
			int randomSubRec=ThreadLocalRandom.current().nextInt(1, 6);
			
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomSubRec+"]")).click();
		
		}
		}
		}
	
	catch(Exception p) {}
	}
}
