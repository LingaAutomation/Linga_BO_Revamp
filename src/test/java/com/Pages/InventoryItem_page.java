package com.Pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class InventoryItem_page {
	
	public WebDriver driver;
	public ExtentTest test;
	
	Utility ut=new Utility();
	Common_XPaths cmp;
	WebDriverWait wait;

	public InventoryItem_page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'NEW INVENTORY ITEM')]")
	WebElement New_InventoryItem_Btn;
	
	@FindBy(xpath = "//app-input[contains(@name,'name')]/div/div/mat-form-field/div/div/div/input")
	WebElement Inventory_name;
	
	@FindBy(xpath = "//app-selectbox[contains(@name,'invItemInventoryUnit')]/div/mat-form-field/div/div[1]/div[3]/input")
	WebElement invItemInventoryUnit;
	
	

	
	@FindBy(xpath = "//app-selectbox[contains(@name,'inventoryUnit')]/div/mat-form-field/div/div[1]/div[3]/input")
	WebElement SubRecipeInventoryUnit;
	@FindBy(xpath = "//app-input[contains(@name,'parLevel')]/div/div/mat-form-field/div/div/div/input")
	WebElement ParLevel;
	
	@FindBy(xpath = "//span[contains(.,'Calculate COGS On Cost Price')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Calculate_COGS_On_Cost_Price_No;
	
	@FindBy(xpath = "//span[contains(.,'Calculate COGS On Cost Price')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Calculate_COGS_On_Cost_Price_Yes;
	
	
	@FindBy(xpath = "//span[contains(.,'Override Tax')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Override_Tax_No;
	
	
	@FindBy(xpath = "//span[contains(.,'Override Tax')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Override_Tax_Yes;
	
	
	@FindBy(xpath = "//label[contains(.,'Category')]/../../input")
	WebElement Select_Input_Category;
	@FindBy(xpath = "//app-selectbox[contains(@name,'parent')]/div/mat-form-field/div/div[1]/div[3]/input")
	WebElement Select_Input_Category2;
	
	
	
	@FindBy(xpath = "//label[contains(.,'Sub Category')]/../../input")
	WebElement Select_Input_subCategory;
	
	@FindBy(xpath = "//app-selectbox[contains(@name,'tax')]/div/mat-form-field/div/div[1]/div[3]/input")
	WebElement Select_Input_tax;
	
	@FindBy(xpath = "//app-selectbox[contains(@name,'primaryStorage')]/div/mat-form-field/div/div[1]/div[3]/input")
	WebElement Select_Input_primaryStorage;
	
	
	@FindBy(xpath = "//app-selectbox[contains(@name,'secondaryStorage')]/div/mat-form-field/div/div[1]/div[3]/input")
	WebElement Select_Input_SecondaryStorage;
	
	
	@FindBy(xpath = "//div[contains(@id,'radio-box-component')]/..//div/div[.='Category']/div/div")
	WebElement Select_category_radio_Btn;
	
	@FindBy(xpath = "//div[contains(@id,'radio-box-component')]/..//div/div[.='Sub Category']/div/div")
	WebElement Select_Subcategory_radio_Btn;
	

	@FindBy(xpath = "//button/span[contains(.,' Add Primary Storage')]")
	WebElement Add_Primary_Storage_Btn;
	
	@FindBy(xpath = "//button/span[contains(.,' Add Secondary Storage')]")
	WebElement Add_Secondary_Storage_Btn;
	
	@FindBy(xpath = "//app-new-storage-location//app-input[contains(@name,'name')]/div/div/mat-form-field/div/div/div/input")
	WebElement Add_Storage_Location_name;
	
	
	@FindBy(xpath = "//app-new-storage-location//app-input[contains(@name,'storage-description')]/div/div/mat-form-field/div/div/div/textarea")
	WebElement Add_Storage_Description_name;
	
	
	
	@FindBy(xpath = "//button/span[contains(.,'Save')]")
	WebElement Save_btn;
	
	
	@FindBy(xpath = "//app-selectbox[contains(@name,'track')]/div/mat-form-field/div/div[1]/div[3]/input")
	WebElement Select_track_input;

	
	
	
	//div[@class='card']/ul/li[2]/div[1]/div/div[2]//input
	
	@FindBy(xpath = "//button/span[contains(.,'Add Recipe Unit')]")
	WebElement Add_Recipe_Unit_Btn;
	
	@FindBy(xpath = "//button/span[contains(.,'Add Vendor')]")
	WebElement Add_Vendor_Btn;
	
	@FindBy(xpath = "//mat-icon[contains(.,'highlight_off')]")
	WebElement Remove_Vendor;

	@FindBy(xpath = "//app-selectbox[contains(@name,'vendor')]/div/mat-form-field/div/div[1]/div[3]/input")
	WebElement Select_Vendor_input;
	
	
	

	@FindBy(xpath = "//div[@class='card']/ul/li[2]/div[1]/div/div[2]//input")
	WebElement Recipe_Unit_input;
	
	@FindBy(xpath = "//div[@class='card']/ul/li[2]/div[1]/div/div[3]//input")
	WebElement Recipe_Quantity_input;
	
	@FindBy(xpath = "//div[@class='card']/ul/li[2]/div[1]/div/div[4]//input")
	WebElement Recipe_Price_input;
	
	
	
	@FindBy(xpath = "//div[@class='card']/ul/li[2]/div[1]/div/div[5]/div/button")
	WebElement Recipe_Delete_btn;
	@FindBy(xpath = "//app-input[contains(@name,'brandName')]/div/div/mat-form-field/div/div/div/input")
	WebElement BrandName_input;
	
	
	@FindBy(xpath = "//app-input[contains(@name,'barcode')]/div/div/mat-form-field/div/div/div/input")
	WebElement BrandCode_input;
	
	
	@FindBy(xpath = "//app-selectbox[contains(@name,'purchaseUnit')]/div/mat-form-field/div/div[1]/div[3]/input")
	WebElement Select_purchaseUnit_input;
	
	
	@FindBy(xpath = "//app-input[contains(@name,'purchaseUnitMultiplier')]/div/div/mat-form-field/div/div/div/input")
	WebElement purchaseUnitMultiplier_input;
	
	
	@FindBy(xpath = "//app-input[contains(@name,'vendorReceivingQuantity')]/div/div/mat-form-field/div/div/div/input")
	WebElement vendorReceivingQuantity_input;

	
	@FindBy(xpath = "//app-currency-input[contains(@name,'vendorItemPriceStr')]/div/app-input/div/div/mat-form-field/div/div/div/input")
	WebElement vendorItemPriceStr_input;
	
	
	@FindBy(xpath = "//app-input[contains(@name,'vendorItemYield')]/div/div/mat-form-field/div/div/div/input")
	WebElement vendorItemYield_input;
	
	@FindBy(xpath = "//app-currency-input[contains(@name,'vendorItemPricePerUnitStr')]/div/app-input/div/div/mat-form-field/div/div/div/input")
	WebElement vendorItemPricePerUnitStr_input;
	
	
	
	@FindBy(xpath = "//span[contains(.,'Enter At Least One Active Vendor Item')]")
	WebElement Alert_msg_removing_vendor;
	
	@FindBy(xpath =  "//mat-icon[contains(.,'check_circle_outline')]")

    WebElement ActiveBtn;

    

    @FindBy(xpath =  "//mat-icon[contains(.,'remove_circle_outline')]")

    WebElement InactiveBtn;
    
    @FindBy(xpath =  "//button/span[contains(.,'Add Inventory Item')]")

    WebElement Add_Inventory_Item;
    
    @FindBy(xpath =  "//app-selectbox[contains(@name,'inventoryItem')]/div/mat-form-field/div//input")

    WebElement Select_Inventory_Item;
    
    
	public void Save_btn()
	{
    	Save_btn.click();
	}
	
  
	public void Add_Inventory_Item()
	{
		Add_Inventory_Item.click();
	}
	
	
	public void Click_ActivetoInactiveButton()
	{
		ActiveBtn.click();
	}
	
	public void Click_InactivetoActiveButton()
	{
		InactiveBtn.click();
	}
	
	public void Click_New_InventoryItem_Btn()
	{
		New_InventoryItem_Btn.click();
	}
	

	public void Select_category_radio_Btn()
	{
		Select_category_radio_Btn.click();
	}
	

	
	
	
	public void Recipe_Unit_input(String str) throws InterruptedException
	{
		Recipe_Unit_input.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div/div[contains(.,'1 "+str+"')]")).click();
		
		
	}
	
	public void Recipe_Quantity_input(String str)
	{
		Recipe_Quantity_input.sendKeys(str);
	}
	
	public void Recipe_Price_input(String str)
	{
		Recipe_Price_input.sendKeys(str);
	}
	
	public void Recipe_Delete()
	{
		Recipe_Delete_btn.click();
	}
	public void Select_Subcategory_radio_Btn()
	{
		Select_Subcategory_radio_Btn.click();
	}
	
	
	
	public void Inventory_name(String str) throws InterruptedException
	{
		Thread.sleep(2000);
		Inventory_name.clear();
		Thread.sleep(2000);
		Inventory_name.sendKeys(str);
	}
	
	
	
	
	
	public void ParLevel(String str) throws InterruptedException
	{
		Thread.sleep(2000);
		ParLevel.clear();
		Thread.sleep(2000);
		ParLevel.sendKeys(str);
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
	
	//app-selectbox[contains(@name,'inventoryUnit')]/div/mat-form-field/div/div[1]/div[3]/input
	
	public void Select_SubRecipeInventoryUnit() throws Exception
	{

		
		Thread.sleep(1000);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(DepartmentDropBtn);
		Thread.sleep(1000);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
//		DepartmentDropBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(SubRecipeInventoryUnit)).click();
		
		Thread.sleep(2000);
		//Tax_category_Input.click();
		
		//driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		//get text of tax 
	 List<WebElement> text = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
		
		 int tax = text.size();
		 
			int randomMenu=ThreadLocalRandom.current().nextInt(1, tax);
			
		
		
			driver.findElement(By.xpath("//div["+randomMenu+"]/select-option")).click();
	
	}
	public void Select_invItemInventoryUnit(String str) throws Exception
	{

		
		Thread.sleep(1000);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(DepartmentDropBtn);
		Thread.sleep(1000);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
//		DepartmentDropBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(invItemInventoryUnit)).click();
		
		Thread.sleep(2000);
		//Tax_category_Input.click();
		
		//driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		//get text of tax 
//		 List<WebElement> text = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
		
		// int tax = text.size();
		 
		//	int randomMenu=ThreadLocalRandom.current().nextInt(1, tax);
			
			//input text for tax
			
		
			Verify_Search(str);
		
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
	
	}
	public void Select_SubCategory() throws Exception
	{

		
		Thread.sleep(1000);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		
		//Select_Subcategory_radio_Btn.click();
	/*	
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(DepartmentDropBtn);
		Thread.sleep(1000);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
//		DepartmentDropBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(Select_Input_Category)).click();
		
		Thread.sleep(2000);
		//Tax_category_Input.click();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		//get text of tax 
		 List<WebElement> text = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
		
		 int tax = text.size();
		 
			int randomMenu=ThreadLocalRandom.current().nextInt(1, tax);
		
		
		

			Verify_Search(driver.findElement(By.xpath("//div["+randomMenu+"]/select-option")).getText());
		
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
	*/	
//		cmp.Cursor_MoveToElement(DepartmentDropBtn);
		Thread.sleep(1000);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		 
		 
		
//		DepartmentDropBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(Select_Input_subCategory)).click();
		
		Thread.sleep(2000);
		//Tax_category_Input.click();
		
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		//get text of tax 
		 List<WebElement> text2 = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
		
		 int tax2 = text2.size();
		 
			int randomMenu2=ThreadLocalRandom.current().nextInt(1, tax2);
		
		
		

			Verify_Search(driver.findElement(By.xpath("//div["+randomMenu2+"]/select-option")).getText());
		
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
		
		
	}
	
	
	public void Select_Category() throws Exception
	{

		
		Thread.sleep(1000);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(DepartmentDropBtn);
		Thread.sleep(1000);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
//		DepartmentDropBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(Select_Input_Category)).click();
		
		Thread.sleep(2000);
		//Tax_category_Input.click();
		
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		//get text of tax 
		 List<WebElement> text = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
		
		 int tax = text.size();
		 
			int randomMenu=ThreadLocalRandom.current().nextInt(1, tax);
		
		
		

			Verify_Search(driver.findElement(By.xpath("//div["+randomMenu+"]/select-option")).getText());
		
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
		
		
	}
	
	public void Select_Category2() throws Exception
	{

		
		Thread.sleep(1000);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(DepartmentDropBtn);
		Thread.sleep(1000);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
//		DepartmentDropBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(Select_Input_Category2)).click();
		
		Thread.sleep(2000);
		//Tax_category_Input.click();
		
	//	driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		//get text of tax 
		 List<WebElement> text = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
		
		 int tax = text.size();
		 
			int randomMenu=ThreadLocalRandom.current().nextInt(1, tax);
		
		
		

			Verify_Search(driver.findElement(By.xpath("//div["+randomMenu+"]/select-option")).getText());
		
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
		
		
	}
	
	
	
	
	public void Enable_Calculate_COGS_On_Cost_Price() throws InterruptedException {
		if(Calculate_COGS_On_Cost_Price_No.isEnabled()) {
			Thread.sleep(2000);
			Calculate_COGS_On_Cost_Price_Yes.click();
			Thread.sleep(2000);
		}
	}
	
	
		public void Disable_Calculate_COGS_On_Cost_Price() throws InterruptedException {
			if(Calculate_COGS_On_Cost_Price_Yes.isEnabled()) {
				Thread.sleep(2000);
				Calculate_COGS_On_Cost_Price_No.click();
				Thread.sleep(2000);
		}
	

}
		
		public void Disable_Override_Tax() throws InterruptedException {
			if(Override_Tax_Yes.isEnabled()) {
				Thread.sleep(2000);
				Override_Tax_No.click();
				Thread.sleep(2000);
		}
		}
			
			public void Enable_Override_Tax() throws InterruptedException {
				if(Override_Tax_No.isEnabled()) {
					Thread.sleep(2000);
					Override_Tax_Yes.click();
					Thread.sleep(2000);
			}
	

}
			public void Select_tax() throws Exception
			{

				
				Thread.sleep(1000);
				cmp=new Common_XPaths(driver, test);
				
				Thread.sleep(1000);
//				cmp.Cursor_MoveToElement(DepartmentDropBtn);
				Thread.sleep(1000);
				 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
				
//				DepartmentDropBtn.click();
				wait.until(ExpectedConditions.elementToBeClickable(Select_Input_tax)).click();
				
				Thread.sleep(2000);
				//Tax_category_Input.click();
				
				//driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
				Thread.sleep(2000);
				//get text of tax 
				 List<WebElement> text = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
				
				 int tax = text.size();
				 
					int randomMenu=ThreadLocalRandom.current().nextInt(1, tax);
				
				
				

					Verify_Search(driver.findElement(By.xpath("//div["+randomMenu+"]/select-option")).getText());
				
					driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
				
				
			}
			
			public void Select_primary_storage() throws Exception
			{

				
				Thread.sleep(1000);
				cmp=new Common_XPaths(driver, test);
				
				Thread.sleep(1000);
//				cmp.Cursor_MoveToElement(DepartmentDropBtn);
				Thread.sleep(1000);
				 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
				
//				DepartmentDropBtn.click();
				wait.until(ExpectedConditions.elementToBeClickable(Select_Input_primaryStorage)).click();
				
				Thread.sleep(2000);
				//Tax_category_Input.click();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
				Thread.sleep(2000);
				//get text of tax 
				 List<WebElement> text = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
				
				 int tax = text.size();
				 
					int randomMenu=ThreadLocalRandom.current().nextInt(1, tax);
				
				
				

					Verify_Search(driver.findElement(By.xpath("//div["+randomMenu+"]/select-option")).getText());
				
					driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
				
				
			}
			
			public void Select_Secondary_storage() throws Exception
			{

				
				Thread.sleep(1000);
				cmp=new Common_XPaths(driver, test);
				
				Thread.sleep(1000);
//				cmp.Cursor_MoveToElement(DepartmentDropBtn);
				Thread.sleep(1000);
				 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
				
//				DepartmentDropBtn.click();
				wait.until(ExpectedConditions.elementToBeClickable(Select_Input_SecondaryStorage)).click();
				
				Thread.sleep(2000);
				//Tax_category_Input.click();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
				Thread.sleep(2000);
				//get text of tax 
				 List<WebElement> text = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
				
				 int tax = text.size();
				 
					int randomMenu=ThreadLocalRandom.current().nextInt(1, tax);
				
				
				

					Verify_Search(driver.findElement(By.xpath("//div["+randomMenu+"]/select-option")).getText());
					Thread.sleep(2000);
					driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
				
				
			}
			
		
			public void Add_new_Primary_storage(String str) throws InterruptedException {
				
				Add_Primary_Storage_Btn.click();
				
				
				cmp.VerifyCreationScreenPageHeader("New Storage Location");
				Thread.sleep(2000);
				Add_Storage_Location_name.clear();
				Add_Storage_Location_name.sendKeys(str);
				
				Thread.sleep(2000);
				Add_Storage_Description_name.clear();
				Add_Storage_Description_name.sendKeys(str);
				Thread.sleep(2000);
				Save_btn.click();
			}
			
			
	public void Add_new_Secondary_storage(String str) throws InterruptedException {
				
				Add_Secondary_Storage_Btn.click();
				
				
				cmp.VerifyCreationScreenPageHeader("New Storage Location");
				Thread.sleep(2000);
				Add_Storage_Location_name.clear();
				Add_Storage_Location_name.sendKeys(str);
				Thread.sleep(2000);
				
				Add_Storage_Description_name.clear();
				Add_Storage_Description_name.sendKeys(str);
				Thread.sleep(2000);
				Save_btn.click();
			}
			
	public void Select_track() throws InterruptedException {			
		Thread.sleep(1000);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(1000);
//	cmp.Cursor_MoveToElement(DepartmentDropBtn);
	Thread.sleep(1000);
	 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	
//	DepartmentDropBtn.click();
	wait.until(ExpectedConditions.elementToBeClickable(Select_track_input)).click();
	
	Thread.sleep(2000);
	//Tax_category_Input.click();
	
	//driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
	Thread.sleep(2000);
	//get text of tax 
	 List<WebElement> text = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
	
	 int tax = text.size();
	 
		int randomMenu=ThreadLocalRandom.current().nextInt(1, tax);
		
		driver.findElement(By.xpath("//div["+randomMenu+"]/select-option")).click();
	
		
		
		
	}
	
	public void Select_Vendor() throws InterruptedException {			
		Thread.sleep(1000);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(1000);
//	cmp.Cursor_MoveToElement(DepartmentDropBtn);
	Thread.sleep(1000);
	 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	
//	DepartmentDropBtn.click();
	wait.until(ExpectedConditions.elementToBeClickable(Select_Vendor_input)).click();
	
	Thread.sleep(2000);
	//Tax_category_Input.click();
	
	//driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
	Thread.sleep(2000);
	//get text of tax 
	 List<WebElement> text = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
	
	 int tax = text.size();
	 
		int randomMenu=ThreadLocalRandom.current().nextInt(1, tax);
		
		driver.findElement(By.xpath("//div["+randomMenu+"]/select-option")).click();
	
		
		
		
	}
	
	
	
	public void Select_Inventory_Item() throws InterruptedException {			
		Thread.sleep(1000);
	cmp=new Common_XPaths(driver, test);
	
	Thread.sleep(1000);
//	cmp.Cursor_MoveToElement(DepartmentDropBtn);
	Thread.sleep(1000);
	 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
	
//	DepartmentDropBtn.click();
	wait.until(ExpectedConditions.elementToBeClickable(Select_Inventory_Item)).click();
	
	Thread.sleep(2000);
	//Tax_category_Input.click();
	
	//driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
	Thread.sleep(2000);
	//get text of tax 
	 List<WebElement> text = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
	
	 int tax = text.size();
	 
		int randomMenu=ThreadLocalRandom.current().nextInt(1, tax);
		
		driver.findElement(By.xpath("//div["+randomMenu+"]/select-option")).click();
	
		
		
		
	}
	
	public void Brand_name(String str) throws InterruptedException
	{
		Thread.sleep(2000);
		BrandName_input.clear();
		Thread.sleep(2000);
		BrandName_input.sendKeys(str);
	}
	
	public void SkuCode_name(String str) throws InterruptedException
	{
		Thread.sleep(2000);
		BrandCode_input.clear();
		Thread.sleep(2000);
		BrandCode_input.sendKeys(str);
	}
	
	
	public void Remove_vendor() {
		
		Remove_Vendor.click();
		
	}
	
	public void Add_vendor() {
			Add_Vendor_Btn.click();
}
	
	public void Add_brandName_SKU_Code(String str) {
		
		Add_Primary_Storage_Btn.click();
		
		
		cmp.VerifyCreationScreenPageHeader("New Storage Location");
		
		BrandName_input.clear();
		BrandName_input.sendKeys(str);
		
		
		BrandCode_input.clear();
		BrandCode_input.sendKeys(str);
	}
	
	
	
	public void purchaseUnit_input(String str) throws InterruptedException
	{
		Select_purchaseUnit_input.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div/div[contains(.,'1 "+str+"')]")).click();
		
		
	}
	
	public void purchase_quantity_input(String str) throws InterruptedException
	{
		purchaseUnitMultiplier_input.clear();
		Thread.sleep(2000);
		purchaseUnitMultiplier_input.sendKeys(str);
		
		
	}
	
	public void vendorReceivingQuantity_input(String str) throws InterruptedException
	{
		vendorReceivingQuantity_input.clear();
		Thread.sleep(2000);
		//vendorReceivingQuantity_input.sendKeys(str);
driver.findElement(By.xpath("//app-input[contains(@name,'vendorReceivingQuantity')]//mat-icon[contains(.,'arrow_drop_up')]/..")).click();
		
		driver.findElement(By.xpath("//app-input[contains(@name,'vendorReceivingQuantity')]//mat-icon[contains(.,'arrow_drop_up')]/..")).click();
		
		
	}
	
	public void vendorItemPriceStr_input(String str) throws InterruptedException
	{
		vendorItemPriceStr_input.clear();
		Thread.sleep(2000);
		vendorItemPriceStr_input.sendKeys(str);
		
		
	}
	
	public void vendorItemYield_input(String str) throws InterruptedException
	{
		vendorItemYield_input.clear();
		Thread.sleep(2000);
		//vendorItemYield_input.sendKeys(str);
		
		driver.findElement(By.xpath("//app-input[contains(@name,'vendorItemYield')]//mat-icon[contains(.,'arrow_drop_up')]/..")).click();
		
		driver.findElement(By.xpath("//app-input[contains(@name,'vendorItemYield')]//mat-icon[contains(.,'arrow_drop_up')]/..")).click();
	}
	
	public void Add_inv_detail_categories(String str) throws InterruptedException
	{
		
		Thread.sleep(2000);
	driver.findElement(By.xpath("(//div[contains(@class,'selectbox-component')]/mat-form-field)[2]")).click();
		
	Thread.sleep(2000);
	
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	try {
	js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//select-option/div/div/div[contains(.,'"+str+"')]")));

	
	driver.findElement(By.xpath("//select-option/div/div/div[contains(.,'"+str+"')]")).click();
	}
	catch (Exception e) {
		test.log(LogStatus.FAIL, "category is not selected from DropDown ");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
	}
	}
	public void Add_inv_Item_Detail(String str) throws InterruptedException
	{
		
		Thread.sleep(2000);
	driver.findElement(By.xpath("(//div[contains(@class,'selectbox-component')]/mat-form-field)[4]")).click();
		
	Thread.sleep(2000);
	
	try {
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//select-option/div/div/div[contains(.,'"+str+"')]")));
	
	driver.findElement(By.xpath("//select-option/div/div/div[contains(.,'"+str+"')]")).click();
	}
	catch (Exception e) {
		test.log(LogStatus.FAIL, "Item_Detail is not selected from DropDown ");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
	}
	}
	
	public void Add_inv_RecipeUnits_Detail(String str) throws InterruptedException
	{
		
		Thread.sleep(2000);
	driver.findElement(By.xpath("(//div[contains(@class,'selectbox-component')]/mat-form-field)[5]")).click();
		
	Thread.sleep(2000);
	try {
	
	driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div/div")).click();
	}
	catch (Exception e) {
		// TODO: handle exception
	}
	}
}