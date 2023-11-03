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

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;

import Utility.Utility;

public class InventoryCategoryPage extends BasePage
{
	
	public SelfHealingDriver driver;
	public ExtentTest test;
	
	Utility ut=new Utility();
	Common_XPaths cmp;
	WebDriverWait wait;

	public InventoryCategoryPage(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		
		super(driver,test);
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//button[contains(.,'NEW CATEGORY')]")
	WebElement New_CategoryBtn;
	
	
	
	@FindBy(xpath = "//button[contains(.,'NEW SUB-CATEGORY')]")
	WebElement New_SubCategoryBtn;
	
	
	
	@FindBy(xpath = "//app-input[contains(@name,'name')]/div/div/mat-form-field/div/div/div/input")
	WebElement Name_category;
	
	@FindBy(xpath = "//app-input[contains(@name,'code')]/div/div/mat-form-field/div/div/div/input")
	WebElement Code_category;
	
	
	@FindBy(xpath = "//app-selectbox[contains(@name,'tax')]/div/mat-form-field/div/div[1]/div[3]/input")
	WebElement Tax_category_Input;
	
	
	
	@FindBy(xpath = "//app-selectbox/div/mat-form-field/div/div[1]/div[3]/input")
	WebElement category_Input;
	
	@FindBy(xpath = "//button[contains(.,'Cancel')]")
	WebElement CancelBtn;
	
	@FindBy(xpath = "//button[contains(.,'Save')] [contains(@disabled,'true')]")
	WebElement Save_Disable_Btn;
	
	@FindBy(xpath = "//button[contains(.,'Save')]")
	WebElement Save_Btn;
	
	
	@FindBy(xpath = "//mat-icon[contains(.,'close')]/../span")
	WebElement Close_Btn;
	
	@FindBy(xpath = "//app-input[contains(@name,'description')]/div/div/mat-form-field/div/div/div/textarea")
	WebElement Description_Box;
	
	@FindBy(xpath = "//div[contains(@class,'row ')]/div/div[contains(.,'Enable Taxes')]/../div[2]/app-toggle/div/div/mat-button-toggle-group/mat-button-toggle/button[contains(.,'No')]")
	WebElement EnableTax_No;
	
	@FindBy(xpath = "//div[contains(@class,'row ')]/div/div[contains(.,'Enable Taxes')]/../div[2]/app-toggle/div/div/mat-button-toggle-group/mat-button-toggle/button[contains(.,'Yes')]")
	WebElement EnableTax_Yes;
	
	@FindBy(xpath = "//button[contains(@mattooltip,'POS')]/span[2]")
	WebElement PublishButton;
	
	
	
	@FindBy(xpath = "//div/span[contains(.,'Purchase Orders')]/..")
	WebElement Purchase_Orders;
	
	
	
	@FindBy(xpath = "//button/span[contains(.,' NEW PURCHASE ORDER ')]/..")
	WebElement New_Purchase_Orders;
	
	
	public WebElement Purchase_Orders()
	{
		return Purchase_Orders;
	}
	
	public WebElement PublishButton()
	{
		return PublishButton;
	}
	
	public WebElement EnableTax_No()
	{
		return EnableTax_No;
	}
	
	public WebElement EnableTax_Yes()
	{
		return EnableTax_Yes;
	}
	
	
	
	@FindBy(xpath = "//div[contains(@class,'ng-star-inserted')]/p")
	WebElement alert_text;
	
	
	public void Click_NewCategory()
	{
		New_CategoryBtn.click();
	}
	
	public void Click_NewSubCategory()
	{
		New_SubCategoryBtn.click();
	}
	
	
	public void Clear_Name_category()
	{
		Name_category.clear();
	
	}
	
	public WebElement alert_text()
	{
		return alert_text;
	}
	
	public void Name_category(String str) throws InterruptedException
	{
		Name_category.clear();
		Thread.sleep(2000);
		Name_category.sendKeys(str);
	}
	
	public void Code_category(String str) throws InterruptedException
	{
		Code_category.clear();
		Thread.sleep(2000);
		Code_category.sendKeys(str);
	}
	
	@FindBy(xpath = "//div[contains(@id,'option-panel')]/..//app-input[contains(@placeholder,'Search')]/div/div/mat-form-field/div//input")
	WebElement SearchBox;
	public void Verify_Search(String SearchValue) throws Exception
	{
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(8000);
	}
	
	public void Select_tax() throws Exception
	{
		Thread.sleep(1000);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(DepartmentDropBtn);
		Thread.sleep(1000);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
//		DepartmentDropBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(Tax_category_Input)).click();
		
		Thread.sleep(2000);
		//Tax_category_Input.click();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		//get text of tax 
		 List<WebElement> text = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
		
		 int tax = text.size();
		 
			int randomMenu=ThreadLocalRandom.current().nextInt(1, tax);
			
			//input text for tax
			
		
			Verify_Search(driver.findElement(By.xpath("//div["+randomMenu+"]/select-option")).getText());
		
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
	}
	
	
	public void Select_Enable_tax_inventory(String str) throws Exception
	{
		Thread.sleep(1000);
		cmp=new Common_XPaths(driver, test);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		
		
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(DepartmentDropBtn);
		Thread.sleep(1000);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
//		DepartmentDropBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(Tax_category_Input)).click();
		
		Thread.sleep(2000);
		//Tax_category_Input.click();
		
	
		
			
			//input text for tax
			
		
			Verify_Search(str);
		
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
	}
	
	
	
	public void Click_Save_Btn()
	{
		Save_Btn.click();
	}
	
	public  WebElement Save_Disable_Btn()
	{
		return Save_Disable_Btn;
	}
	
	public void Description_Box(String str)
	{
		Description_Box.sendKeys(str);
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
		driver.findElement(By.xpath("//span[.=' "+SearchValue+" ']/../../td[5]/div/div[1]/button")).click();
		
		}
		catch(Exception g)
		{
			
			Thread.sleep(2000);

			driver.findElement(By.xpath("//span[.='"+SearchValue+" ']/../../td[5]/div/div[1]/button")).click();
		}
		
		}

	
//get text for existing item 
	//table/tbody/tr["+i+"]/td[1]
	
	//edit
	//span[.=' 3434 ']/../../td[5]/div/div[1]/button
	//delete 
	//span[.=' 3434 ']/../../td[5]/div/div[2]/button
	
	
	////button/span[contains(.,' NEW SUB-CATEGORY ')]
	
	public void Select_Category(String str) throws Exception
	{
		Thread.sleep(1000);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(DepartmentDropBtn);
		Thread.sleep(1000);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
//		DepartmentDropBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(category_Input)).click();
		
		Thread.sleep(2000);
		//Tax_category_Input.click();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		//get text of tax 
		 List<WebElement> text = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
		
		 int tax = text.size();
		 
			int randomMenu=ThreadLocalRandom.current().nextInt(1, tax);
			
			//input text for tax
			
		
			Verify_Search(str);
		
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div")).click();
	}
	
	//New sub Recipe
	//button/span[contains(.,'NEW SUB RECIPE')]
	
	
	//Name 
	//app-input[contains(@name,'Name')]/div/div/mat-form-field/div/div/div/input
	
	//inventory unit
	//app-selectbox[contains(@name,'inventoryUnit')]/div/mat-form-field/div/div[1]/div[3]/input
	//parLevel
	//app-input[contains(@name,'parLevel')]/div/div/mat-form-field/div/div/div/input
	
	////app-input[contains(@name,'notes')]/div/div/mat-form-field/div/div/div/textarea
	
	//app-input[contains(@name,'receivingQuantity')]/div/div/mat-form-field/div/div[1]/div[4]/input
	
	//app-input[contains(@name,'yield')]/div/div/mat-form-field/div/div[1]/div[4]/input
	
    //app-currency-input[contains(@name,'pricePerUnitStr')]/div/app-input/div/div/mat-form-field/div/div[1]/div[4]/input
	
	//app-selectbox[contains(@name,'primaryStorageId')]/div/mat-form-field/div/div[1]/div[3]/input
	
	//app-selectbox[contains(@name,'secondaryStorageId')]/div/mat-form-field/div/div[1]/div[3]/input
	
	
}
