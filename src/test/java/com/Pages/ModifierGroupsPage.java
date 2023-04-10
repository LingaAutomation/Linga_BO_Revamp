package com.Pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class ModifierGroupsPage {

	
	public WebDriver driver;
	public ExtentTest test;
	
	Utility ut=new Utility();
	public ModifierGroupsPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'NEW MODIFIER GROUP')]")
	WebElement New_ModifierGroupBtn;
	
	@FindBy(xpath = "//span[contains(.,'Pizza Topping')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement PizzaTopping_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Pizza Topping')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement PizzaTopping_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Hide Modifier Group')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement HideModifierGroup_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Hide Modifier Group')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement HideModifierGroup_NoBtn;
	
	@FindBy(xpath = "//div[@class='modifier-group-search']/mat-form-field/div/div/div[4]/div/div/input")
	WebElement Modifiers_SearchInputBox;
	
	@FindBy(xpath = "//button[contains(.,'Add Price')]")
	WebElement Add_PriceBtn;
	
	@FindBy(xpath = "//label[contains(.,'Priority')]/../../input")
	WebElement Priority_ModifierGrpInputBox;
	
	@FindBy(xpath = "//mat-step-header[contains(.,'Proceed to Inventory Menu Items Mapping')]")
	WebElement ProceedtoInventoryMenuItemsMappingTab;
	
	@FindBy(xpath = "//div[contains(@class,'sort-select-box')]/app-selectbox/div/mat-form-field/div/div/div[3]/input")
	WebElement SortBy_Btn;
	
	@FindBy(xpath = "//select-option[contains(.,'A-Z')]")
	WebElement AtoZ_Sort;
	
	@FindBy(xpath = "//select-option[contains(.,'Z-A')]")
	WebElement ZtoA_Sort;
	
	@FindBy(xpath = "//select-option[contains(.,'CUSTOM')]")
	WebElement Custom_Sort;
	
	@FindBy(xpath = "//div[@id='new-modifier']/div[2]/div/div/div/div[4]/div[2]/div/div[2]/p")
	WebElement Number_ExceptionErrorMsg;
	
	@FindBy(xpath = "//h3[contains(.,'Inventory Menu Item')]")
	WebElement Inventory_MenuItemHeader;
	
	@FindBy(xpath = "//div[contains(@id,'cdk-drop-list')]/div[1]/data-grid-row/div/div[1]")
	WebElement FirstModifier;
	
	@FindBy(xpath = "//div[contains(@id,'cdk-drop-list')]/div[2]/data-grid-row/div/div[1]")
	WebElement SecondModifier;
	
	public void Click_NewModifierGroup()
	{
		New_ModifierGroupBtn.click();
	}
	
	public void Click_ProceedtoInventoryMenuItemsMappingTab()
	{
		ProceedtoInventoryMenuItemsMappingTab.click();
	}
	
	public WebElement ProceedtoInventoryMenuItemsMappingTab()
	{
		return ProceedtoInventoryMenuItemsMappingTab;
	}
	
	public void Enter_Priority(String str)
	{
		Priority_ModifierGrpInputBox.clear();
		
		Priority_ModifierGrpInputBox.sendKeys(str);
	}
	
	public void Verify_InvalidNumberErrorMsg(String str)
	{
		if(Number_ExceptionErrorMsg.getText().equalsIgnoreCase(str))
		{
			test.log(LogStatus.PASS, str+" is Displayed");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, str+" is not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	public void Enable_PizzaTopping()
	{
		if(PizzaTopping_YesBtn.isSelected())
		{
			
		}
		else
		{
			PizzaTopping_YesBtn.click();
		}
	}
	
	public void Disable_PizzaTopping()
	{
		if(PizzaTopping_YesBtn.isSelected())
		{
			PizzaTopping_NoBtn.click();
		}
		else
		{
			
		}
	}

	public void Enable_HideModifierGroup()
	{
		if(HideModifierGroup_YesBtn.isSelected())
		{
			
		}
		else
		{
			HideModifierGroup_YesBtn.click();
		}
	}
	
	public void Disable_HideModifierGroup()
	{
		if(HideModifierGroup_YesBtn.isSelected())
		{
			HideModifierGroup_NoBtn.click();
		}
		else
		{
			
		}
	}

	
	public void Verify_AscendingSortingforModifiers() throws Exception
	{
		
		ArrayList<String> ArLst=new ArrayList<String>();
//		if(driver.findElement(By.xpath("//span[contains(.,'Name')]/../div[contains(@class,'mode-asc')]")).isDisplayed())
//		{
		Thread.sleep(1000);

			List<WebElement> NameLst=driver.findElements(By.xpath("//div[contains(@id,'cdk-drop-list')]/div/data-grid-row/div/div[1]"));
			
			for(WebElement ele:NameLst)
			{ 
				ArLst.add(ele.getText());
			}
			
//			ArrayList<String> sortedLst=new ArrayList<String>();
//			
//			for(String st:ArLst)
//			{
//				sortedLst.add(st);
//			}
			Thread.sleep(1000);
			Collections.sort(ArLst);
			Thread.sleep(2000);
	
			WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			
			wait.until(ExpectedConditions.elementToBeClickable(SortBy_Btn)).click();
//			SortBy_Btn.click();
			Thread.sleep(1000);
	
			AtoZ_Sort.click();
			Thread.sleep(1000);

			ArrayList<String> AfterArLst=new ArrayList<String>();
		
			List<WebElement> NameAfterSort=driver.findElements(By.xpath("//div[contains(@id,'cdk-drop-list')]/div/data-grid-row/div/div[1]"));
			Thread.sleep(1000);

			for(WebElement ele:NameAfterSort)
			{ 
				AfterArLst.add(ele.getText());
			}
			
//			ArrayList<String> sortedLstAft=new ArrayList<String>();
//			
//			for(String st:AfterArLst)
//			{
//				sortedLstAft.add(st);
//			}
			Thread.sleep(1000);

			
			if(ArLst.equals(AfterArLst))
			{
				test.log(LogStatus.PASS, "Ascending Order Sorted Correctly");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				System.out.println(ArLst);
			}
			else
			{
				test.log(LogStatus.FAIL, "Ascending Order Sorted Incorrect");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
				
				System.out.println(ArLst);
			}
//		}
	}
	
	public void Verify_DescendingSortingforModifiers() throws Exception
	{
		
		
		ArrayList<String> ArLst=new ArrayList<String>();
//		if(driver.findElement(By.xpath("//span[contains(.,'Name')]/../div[contains(@class,'mode-desc')]")).isDisplayed())
//		{
		Thread.sleep(1000);

			List<WebElement> NameLst=driver.findElements(By.xpath("//div[contains(@id,'cdk-drop-list')]/div/data-grid-row/div/div[1]"));
			
			for(WebElement ele:NameLst)
			{
				ArLst.add(ele.getText());
			}
			
//			ArrayList<String> sortedLst=new ArrayList<String>();
//			
//			for(String st:ArLst)
//			{
//				sortedLst.add(st);
//			}
			Thread.sleep(1000);

			Collections.sort(ArLst);
			Thread.sleep(1000);

			Collections.reverse(ArLst);
			Thread.sleep(2000);
			
WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
			
			wait.until(ExpectedConditions.elementToBeClickable(SortBy_Btn)).click();

//			SortBy_Btn.click();
			Thread.sleep(1000);

			ZtoA_Sort.click();
			Thread.sleep(1000);

			ArrayList<String> AfterArLst=new ArrayList<String>();
			
			List<WebElement> NameAfterSort=driver.findElements(By.xpath("//div[contains(@id,'cdk-drop-list')]/div/data-grid-row/div/div[1]"));
			Thread.sleep(1000);
	
						for(WebElement ele:NameAfterSort)
						{ 
							AfterArLst.add(ele.getText());
						}
						
//						ArrayList<String> sortedLstAft=new ArrayList<String>();
//						
//						for(String st:AfterArLst)
//						{
//							sortedLstAft.add(st);
//						}
//						
						
			if(ArLst.equals(AfterArLst))
			{
				test.log(LogStatus.PASS, "Desending Order Sorted Correctly");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				System.out.println(ArLst);
			}
			else
			{
				test.log(LogStatus.FAIL, "Desending Order Sorted Incorrect");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
				
				System.out.println(ArLst);
			}
//		}
	}
	
	public void Verify_CustomSortforModifiers() throws Exception
	{
		Thread.sleep(2000);
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.elementToBeClickable(SortBy_Btn)).click();
//		SortBy_Btn.click();
		Thread.sleep(1000);

		Custom_Sort.click();
		Thread.sleep(1000);

//		WebElement First=driver.findElement(By.xpath(""));
//		WebElement Second=driver.findElement(By.xpath(""));
//		
		Actions ac=new Actions(driver);
		ac.dragAndDrop(FirstModifier, SecondModifier).build().perform();
		
	}
	
	public void Select_Modifiers() throws Exception
	{
	Common_XPaths cmp=new Common_XPaths(driver, test);
		for(int i=1;i<=6;i++)
		{
		Modifiers_SearchInputBox.click();
	
		List<WebElement> OpSizeList=driver.findElements(By.xpath("//div[@class='options']/select-option"));
		
		int OpSizeSize=OpSizeList.size();
		
		
		int randomOpSize=ThreadLocalRandom.current().nextInt(2, OpSizeSize);
		
		
		driver.findElement(By.xpath("//div[@class='options']/select-option["+randomOpSize+"]")).click();
		}
	
	for(int i=1;i<=3;i++)
	{
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[4]/data-grid-row/div/div[3]")).click();
		
		Thread.sleep(1000);
		cmp.Click_DeleteButton();
	}
	}
	
	public void Enter_SetPriceHere(String str) throws Exception
	{
		ModifiersPage mp=new ModifiersPage(driver, test);
		Common_XPaths cmp=new Common_XPaths(driver, test);
		
		mp.Enable_SetPriceHere();
		
		for(int i=1;i<=5;i++)
		{
			Add_PriceBtn.click();
		}
		
		List<WebElement> servingSizeList=driver.findElements(By.xpath("//app-input-table/div/div/div/app-selectbox/div/mat-form-field/div/div/div[3]/input"));
		
		
		
		for(int i=2;i<=servingSizeList.size();i++)
		{
			driver.findElement(By.xpath("//app-input-table/div/div["+i+"]/div/app-selectbox/div/mat-form-field/div/div/div[3]/input")).click();
			
			List<WebElement> OpSizeList=driver.findElements(By.xpath("//div[@class='options']/select-option"));
			
			int OpSizeSize=OpSizeList.size();
			
			
			int randomOpSize=ThreadLocalRandom.current().nextInt(1, OpSizeSize);
			
			
			driver.findElement(By.xpath("//div[@class='options']/select-option["+randomOpSize+"]")).click();
		
			
			driver.findElement(By.xpath("//app-input-table/div/div["+i+"]/div/app-input/div/div/mat-form-field/div/div/div[4]/input")).clear();
			
			driver.findElement(By.xpath("//app-input-table/div/div["+i+"]/div/app-input/div/div/mat-form-field/div/div/div[4]/input")).sendKeys(str);
		}
		
		Thread.sleep(1000);
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//app-input-table/div/div[4]/div[3]")).click();
			
			Thread.sleep(1000);
			cmp.Click_DeleteButton();
		}
	}
	 
	public WebElement Inventory_MenuItemHeader()
	{
		return Inventory_MenuItemHeader;
	}
}
