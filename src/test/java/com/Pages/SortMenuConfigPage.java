package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SortMenuConfigPage extends BasePage
{

//	public SelfHealingDriver driver;
//	public ExtentTest test;

	public SortMenuConfigPage(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		super(driver, test);
		PageFactory.initElements(driver, this);
	}


	@FindBy(xpath = "//span[contains(.,'Categories or Display Groups')]/../..//div[contains(@class,'sort-select-box')]")
	WebElement Cat_SortByDropBtn;

	@FindBy(xpath = "//span[contains(.,'Menu Items of')]/../..//div[contains(@class,'sort-select-box')]")
	WebElement Menu_SortByDropBtn;
	
	@FindBy(xpath = "//span[contains(.,'Sub Categories of')]/../..//div[contains(@class,'sort-select-box')]")
    WebElement SubCat_SortByDropBtn;
	
	@FindBy(xpath = "//select-option[contains(.,'A-Z')]")
	WebElement AtoZ_SortingBtn;

	@FindBy(xpath = "//select-option[contains(.,'Z-A')]")
	WebElement ZtoA_SortingBtn;

	@FindBy(xpath = "//select-option[contains(.,'CUSTOM')]")
	WebElement Custom_SortingBtn;

	@FindBy(xpath = "//button[@id='category-arrow-left']")
	WebElement Left_arrowBtn;

	@FindBy(xpath = "//button[@id='category-arrow-right']") 
	WebElement Right_arrowBtn;
	
	@FindBy(xpath="//span[contains(@class,'px-1')]")
	WebElement Save_Btn;
	
	@FindBy(xpath = "//div[contains(@class,'sort-category-config')]/div[1]/div/div")
	WebElement Cat_First;
	
	@FindBy(xpath = "//div[contains(@class,'sort-category-config')]/div[2]/div/div")
	WebElement Cat_Second;
	
	@FindBy(xpath = "//div[contains(@class,'sort-category-config')]/div[3]/div/div")
	WebElement Cat_Third;
	
	@FindBy(xpath = "//div[contains(@class,'sort-subCategory-config')]/div[1]/div/div")
	WebElement SubCat_First;
	
	@FindBy(xpath = "//div[contains(@class,'sort-subCategory-config')]/div[2]/div/div")
	WebElement SubCat_Second;
	
	@FindBy(xpath = "//div[contains(@class,'menu-example-container')]/div[1]/div/div/div")
	WebElement Menu_First;
	
	@FindBy(xpath = "//div[contains(@class,'menu-example-container')]/div[2]/div/div/div")
	WebElement Menu_Second;
	

	
	
	public void Select_AtoZSorting_Category() throws Exception
	{
		Thread.sleep(2000);
		Cat_SortByDropBtn.click();
		Thread.sleep(2000);

		AtoZ_SortingBtn.click();

	}

	public void Select_ZtoASorting_Category() throws Exception
	{
		Thread.sleep(2000);

		Cat_SortByDropBtn.click();
		Thread.sleep(2000);

		ZtoA_SortingBtn.click();
	}
	
	public void Select_AtoZSorting_SubCategory() throws Exception
	{
		try
		{
			if(SubCat_SortByDropBtn.isDisplayed())
			{
				Thread.sleep(2000);
			SubCat_SortByDropBtn.click();
			Thread.sleep(2000);
		
			AtoZ_SortingBtn.click();
			}
		}
		catch(Exception g)
		{
			test.log(LogStatus.INFO, "SubCategories not available to do Sorting");
		}
	}

	public void Select_ZtoASorting_SubCategory() throws Exception
	{
		try
		{
			if(SubCat_SortByDropBtn.isDisplayed())
			{
				Thread.sleep(2000);
			SubCat_SortByDropBtn.click();
			Thread.sleep(2000);
		
			ZtoA_SortingBtn.click();
			}
		}
		catch(Exception g)
		{
			test.log(LogStatus.INFO, "SubCategories not available to do Sorting");
		}
	}

	public WebElement Category_First()
	{
		return Cat_First;
	}
	
	public WebElement Category_Second()
	{
		return Cat_Second;
	}
	
	public WebElement Category_Third()
	{
		return Cat_Third;
	}
	
	public WebElement SubCategory_First()
	{
		return SubCat_First;
	}
	
	public WebElement SubCategory_Second()
	{
		return SubCat_Second;
	}
	
	public WebElement Menu_First()
	{
		return Menu_First;
	}
	
	public WebElement Menu_Second()
	{
		return Menu_Second;
	}
	
	
	public void Select_CustomSorting_Category() throws Exception
	{
		Thread.sleep(1000);
		Cat_SortByDropBtn.click();

		Thread.sleep(1000);
		Custom_SortingBtn.click();

//		WebElement DG1 =driver.findElement(By.xpath("//div[contains(@class,'sort-category-config')]/div[1]/div"));
		String str1=Cat_First.getText();
		
//		WebElement DG2=driver.findElement(By.xpath("//div[contains(@class,'sort-category-config')]/div[2]/div"));
		String str2=Cat_Third.getText();
		
		Actions ac=new Actions(driver);
		ac.dragAndDrop(Cat_Third, Cat_First).build().perform();
		
		
		

	}
	
	public void Select_CustomSorting_SubCategory() throws Exception
	{
		try
		{
		if(!SubCat_SortByDropBtn.isDisplayed())
		{
			
		
			test.log(LogStatus.INFO, "SubCategories not available to do Sorting");
		
		}
		}
		catch(Exception k)
		{
			
			SubCat_SortByDropBtn.click();

			Custom_SortingBtn.click();

//		WebElement DG1 =driver.findElement(By.xpath("//div[contains(@class,'sort-category-config')]/div[1]/div"));
//		String str1=Cat_First.getText();
		
//		WebElement DG2=driver.findElement(By.xpath("//div[contains(@class,'sort-category-config')]/div[2]/div"));
//		String str2=Cat_Second.getText();
		
			Actions ac=new Actions(driver);
			ac.dragAndDrop(SubCat_First, SubCat_Second).build().perform();
		}
		

	}
	
	public void Select_CustomSorting_MenuItems() throws Exception
	{
		try
		{
		if(!Menu_SortByDropBtn.isDisplayed())
		{
			test.log(LogStatus.INFO, "Menu Items Not available for Sorting");
		
		}
		}
		catch(Exception j)
		{
			
			
			Menu_SortByDropBtn.click();

			Custom_SortingBtn.click();

//			WebElement DG1 =driver.findElement(By.xpath("//div[contains(@class,'sort-category-config')]/div[1]/div"));
//			String str1=Cat_First.getText();
			
//			WebElement DG2=driver.findElement(By.xpath("//div[contains(@class,'sort-category-config')]/div[2]/div"));
//			String str2=Cat_Second.getText();
			
			Actions ac=new Actions(driver);
			ac.dragAndDrop(Menu_Second, Menu_First).build().perform();
		}
		
		

	}

	public void Select_AtoZSorting_MenuItems()
	{
		try
		{
		if(!Menu_SortByDropBtn.isDisplayed())
		{
			test.log(LogStatus.INFO, "Menu Items not available");
		}
		}
		catch(Exception l)
		{
		Menu_SortByDropBtn.click();

		AtoZ_SortingBtn.click();

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",  Menu_SortByDropBtn);
		Menu_SortByDropBtn.click();
		}
	}

	public void Select_ZtoASorting_MenuItems()
	{
		try
		{
		if(!Menu_SortByDropBtn.isDisplayed())
		{
			test.log(LogStatus.INFO, "Menu Items not available");
		}
		}
		catch(Exception l)
		{
		Menu_SortByDropBtn.click();

		ZtoA_SortingBtn.click();

		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",  Menu_SortByDropBtn);
		Menu_SortByDropBtn.click();
		}
	}

//	public void Select_CustomSorting_MenuItems()
//	{
//		Menu_SortByDropBtn.click();
//
//		Custom_SortingBtn.click();
//
//		WebElement MI1 =driver.findElement(By.xpath("//div[contains(@class,'menu-example-container')]/div[1]/div"));
//		WebElement MI2=driver.findElement(By.xpath("//div[contains(@class,'menu-example-container')]/div[2]/div"));
//		Actions ac=new Actions(driver);
//		ac.dragAndDrop(MI1, MI2).build().perform();
//
//	}

	public void Move_left()
	{
		Left_arrowBtn.click();
	}
	public void Move_right()
	{
		Right_arrowBtn.click();
	} 
	public void Save()
	{
		Save_Btn.click();
	}
}
