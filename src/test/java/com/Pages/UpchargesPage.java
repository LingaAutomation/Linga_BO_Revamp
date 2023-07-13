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

public class UpchargesPage {
	public WebDriver driver;
	public ExtentTest test;
	
	public UpchargesPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'NEW UPCHARGE')]")
	WebElement New_UpchargeBtn;
	
	@FindBy(xpath = "//span[contains(.,'Include Additional Modifiers')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement IncludeAdditionalModifiers_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Include Additional Modifiers')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement IncludeAdditionalModifiers_NoBtn;
	
	@FindBy(xpath = "//app-radio-box-button/div/div/div[.='Category']")
	WebElement CategoryLevelTypeBtn;
	
	@FindBy(xpath = "//app-radio-box-button/div/div/div[.='Sub Category']")
	WebElement SubCategoryLevelTypeBtn;
	
	@FindBy(xpath = "//app-radio-box-button/div/div/div[.='Menu Item']")
	WebElement MenuItemLevelTypeBtn;

	@FindBy(xpath = "//label[contains(.,'Category')]/../../div/div/input")
	WebElement Category_InputBox;

	@FindBy(xpath = "//label[contains(.,'Sub Category')]/../../div/div/input")
	WebElement SubCategory_InputBox;

	@FindBy(xpath = "//label[contains(.,'Menu Item')]/../../div/div/input")
	WebElement MenuItem_InputBox;
	
	@FindBy(xpath = "//span[contains(.,'Restrict POS visibility by user role')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement RestrictPOSvisibility_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Restrict POS visibility by user role')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement RestrictPOSvisibility_NoBtn;
	
	@FindBy(xpath = "//app-input[@label='Upcharge Amount']//mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Amount_inUpchargeBtn;
	
	
	@FindBy(xpath = "//app-input[@label='Upcharge Amount']//mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Percentage_inUpchargeBtn;
	
	public void Click_NewUpcharge()
	{
		New_UpchargeBtn.click();
	}
	
	public WebElement Category_LevelType()
	{
		return CategoryLevelTypeBtn;
	}
	
	public WebElement SubCategory_LevelType()
	{
		return SubCategoryLevelTypeBtn;
	}
	
	public WebElement MenuItem_LevelType()
	{
		return MenuItemLevelTypeBtn;
	}
	
	public void Click_Amount_inUpcharge()
	{
		Amount_inUpchargeBtn.click();
	}
	
	public void Click_Percentage_inUpcharge()
	{
		Percentage_inUpchargeBtn.click();
	}
	
	public void Select_CategoryType() throws Exception
	{
		Thread.sleep(1000);
		CategoryLevelTypeBtn.click();
		Thread.sleep(15000);
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
		Category_InputBox.click();
		Thread.sleep(1000);
		
		
		List<WebElement> CategoryList=driver.findElements(By.xpath("//div/select-option"));
		
		int CategorySize=CategoryList.size();
		
		Thread.sleep(2000);
		if(CategorySize<=6)
		{
		int randomCategory=ThreadLocalRandom.current().nextInt(2, CategorySize);
		
		
		
		driver.findElement(By.xpath("/div["+randomCategory+"]/select-option")).click();
		}
		else
		{
			int randomCategory=ThreadLocalRandom.current().nextInt(2, 6);
			
			
			
			driver.findElement(By.xpath("/div["+randomCategory+"]/select-option")).click();
		
		}
		
		Thread.sleep(1000);
		Thread.sleep(1000);
		List<WebElement> CategoryList1=driver.findElements(By.xpath("//div/select-option"));

		if(CategoryList1.size()!=0)
		{
//			test.log(LogStatus.FAIL, "Category lists are displayed after Selecting the required Category");
			Thread.sleep(1000);
			Category_InputBox.click();
		}
//		try
//		{
//		if(driver.findElement(By.xpath("//div/select-option")).isDisplayed())
//		{
//			List<WebElement> CategoryList=driver.findElements(By.xpath("//div/select-option"));
//			
//			int CategorySize=CategoryList.size();
//		
//			if(CategorySize<=6)
//			{
//				int randomCategory=ThreadLocalRandom.current().nextInt(2, CategorySize);
//		
//		
//				driver.findElement(By.xpath("/div["+randomCategory+"]/select-option")).click();
//				
//				Thread.sleep(1000);
//			}
//			else
//			{
//				int randomCategory=ThreadLocalRandom.current().nextInt(2, CategorySize);
//			
//			
//				driver.findElement(By.xpath("/div["+randomCategory+"]/select-option")).click();
//		
//				Thread.sleep(1000);
////			}
//		}
//		}
//		catch(Exception k)
//		{
//			Thread.sleep(6000);
//			Category_InputBox.click();
//			Thread.sleep(6000);
//			
//			List<WebElement> CategoryList=driver.findElements(By.xpath("//div/select-option"));
//			
//			int CategorySize=CategoryList.size();
//			
//			int randomCategory=ThreadLocalRandom.current().nextInt(2, CategorySize);
//			
//			
//			driver.findElement(By.xpath("/div["+randomCategory+"]/select-option")).click();
//	
//			Thread.sleep(1000);
//			List<WebElement> CategoryList1=driver.findElements(By.xpath("//div/select-option"));
//
//			if(CategoryList1.size()!=0)
//			{
//				test.log(LogStatus.FAIL, "Category lists are displayed after Selecting the required category");
//				Thread.sleep(6000);
//				Category_InputBox.click();
//			}
//	
//		}
		}
	}
	
	public void Select_SubCategoryType() throws Exception
	{
		Thread.sleep(1000);
		SubCategoryLevelTypeBtn.click();
		
		Thread.sleep(15000);
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
		SubCategory_InputBox.click();
		
		Thread.sleep(1000);
		List<WebElement> SubCategoryList=driver.findElements(By.xpath("//div/select-option"));
		
		int SubCategorySize=SubCategoryList.size();
		
	
			if(SubCategorySize<=6)
			{
		
			int randomSubCategory=ThreadLocalRandom.current().nextInt(2, SubCategorySize);
			
			
			driver.findElement(By.xpath("//div["+randomSubCategory+"]/select-option")).click();
			}
			else
			{
				int randomSubCategory=ThreadLocalRandom.current().nextInt(2, 6);
				
				
				driver.findElement(By.xpath("//div["+randomSubCategory+"]/select-option")).click();
			
			}
			Thread.sleep(1000);
			List<WebElement> SubCategoryList1=driver.findElements(By.xpath("//div/select-option"));
			if(SubCategoryList1.size()!=0)
			{
//				test.log(LogStatus.FAIL, "SubCategory lists are displayed after Selecting the required SubCategory");
				Thread.sleep(1000);
				SubCategory_InputBox.click();
			}
		
		}
	}
	
	public void Select_MenuItemType() throws Exception
	{
		Thread.sleep(1000);
		MenuItemLevelTypeBtn.click();
		
		Thread.sleep(15000);
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
			MenuItem_InputBox.click();
			Thread.sleep(1000);
		
			List<WebElement> MenuItemList=driver.findElements(By.xpath("//div/select-option"));
		
			int MenuItemSize=MenuItemList.size();
		
			if(MenuItemSize<=6)
			{
				int randomMenuItem=ThreadLocalRandom.current().nextInt(2, MenuItemSize);
		
		
				driver.findElement(By.xpath("//div["+randomMenuItem+"]/select-option")).click();
				Thread.sleep(1000);
			}
			else
			{
				int randomMenuItem=ThreadLocalRandom.current().nextInt(2, 6);
				
				
				driver.findElement(By.xpath("//div["+randomMenuItem+"]/select-option")).click();
				Thread.sleep(1000);
			}
			Thread.sleep(2000);
				List<WebElement> MenuItemList1=driver.findElements(By.xpath("//div/select-option"));
				
				if(MenuItemList1.size()!=0)
				{
//					test.log(LogStatus.FAIL, "Menu Items list are displayed after Selecting the required Menu Item");
					Thread.sleep(1000);
					MenuItem_InputBox.click();
				}
		}
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
		if(IncludeAdditionalModifiers_YesBtn.isSelected()) 
		{
			IncludeAdditionalModifiers_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	public void Enable_RestrictPOSVisiblity()
	{
		if(RestrictPOSvisibility_YesBtn.isEnabled()) 
		{
			
		}
		else
		{
			RestrictPOSvisibility_YesBtn.click();
		}
	}
	
	public void Disable_RestrictPOSVisiblity()
	{
		if(RestrictPOSvisibility_YesBtn.isSelected()) 
		{
			RestrictPOSvisibility_NoBtn.click();
		}
		else
		{
		
		}
	}
}
