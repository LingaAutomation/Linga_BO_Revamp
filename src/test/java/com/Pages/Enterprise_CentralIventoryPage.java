package com.Pages;

import java.util.concurrent.ThreadLocalRandom;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import Utility.Utility;

public class Enterprise_CentralIventoryPage 
{
	public WebDriver driver;
	public ExtentTest test;
	
	Utility ut=new Utility();
	Common_XPaths cmp;
	
	public Enterprise_CentralIventoryPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'CENTRAL WAREHOUSE')]")
	WebElement Central_WarehouseBtn;
	
	@FindBy(xpath = "//app-selectbox[@name='timeZone']//input")
	WebElement Time_ZoneInputBx;
	
	@FindBy(xpath = "//app-toggle[contains(.,'Copy Menu From Existing Store')]//button[.='Yes']")
	WebElement Copy_Menu_ExistingStore_YesToggle;
	
	@FindBy(xpath = "//app-toggle[contains(.,'Copy Menu From Existing Store')]//button[.='No']")
	WebElement Copy_Menu_ExistingStore_NoToggle;
	
	@FindBy(xpath = "//button[contains(.,'Select Store')]")
	WebElement Select_StoreInputBx;
	
	public void Click_Add_Central_Warehouse()
	{
		Central_WarehouseBtn.click();
	}
	
	public void Enable_Copy_Menu_ExistingStore_Toggle()
	{
		new Common_XPaths(driver, test).Enable_Toggle(Copy_Menu_ExistingStore_YesToggle, "Copy Menu from Existing Store Toggle Enabled");
	}
	
	public void Disable_Copy_Menu_ExistingStore_Toggle()
	{
		new Common_XPaths(driver, test).Disable_Toggle(Copy_Menu_ExistingStore_YesToggle, Copy_Menu_ExistingStore_NoToggle, "Copy Menu from Existing Store Toggle Disabled");
	}
	
	public void Select_Store() throws Exception
	{
		Thread.sleep(1000);
		new Common_XPaths(driver, test).Click_DropDown_withSearch(Select_StoreInputBx, "Store Selected");
	}
	
	public WebElement Copy_Menu_ExistingStore_YesToggle()
	{
		return Copy_Menu_ExistingStore_YesToggle;
	}
	
	public void Search_and_Edit_CentralInventory(String Name) throws Exception
	{
		Thread.sleep(1000);
		new Common_XPaths(driver, test).SearchBox.clear();
		Thread.sleep(1000);
		new Common_XPaths(driver, test).SearchBox.sendKeys(Name);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//app-central-warehouse-item//button)[1]")).click();
		
	}
	
	@FindBy(xpath = "//mat-panel-title[contains(.,'Low Stocks')]/..//mat-icon[.='keyboard_arrow_right']")
	public WebElement Low_Stocks_RightArrow;
	
	@FindBy(xpath = "//mat-panel-title[contains(.,'Low Stocks')]/..//mat-icon[.='keyboard_arrow_down']")
	public WebElement Low_Stocks_DownArrow;
	
	
	
	
	//////////////  Central Inventory - Transfer Request  ////////////////////////////
	
	@FindBy(xpath = "//button[contains(.,'NEW TRANSFER REQUEST ')]")
	WebElement New_Transfer_Request;
	
	@FindBy(xpath = "//label[contains(.,'Source')]/../../input")
	WebElement Source_input_btn;
	
	@FindBy(xpath = "//label[contains(.,'Destination')]/../../input")
	WebElement Destination_input_btn;
	
	@FindBy(xpath = "//div[contains(@class,'drawer-footer')]/../div[3]/div[2]/button")
	WebElement Request_Btn;
	
	@FindBy(xpath = "//div[contains(@class,'drawer-footer')]/../div[3]/div[2]/button[contains(@disabled,'true')]")
	WebElement Request_Disabled_Btn;
	
	@FindBy(xpath = "//div[@class='option-list']//input[@data-placeholder='Search']")
	WebElement SearchBox_DropDown;
	
	@FindBy(xpath = "//cdk-virtual-scroll-viewport//div/div[1]//select-option/div")
	WebElement First_Option_inDropDown;
	
	
	
	@FindBy(xpath = "//span[contains(.,'Inventory Item')]/span[1]")
	WebElement Add_Inventory;
	
	public WebElement Add_Inventory() {
		return Add_Inventory;
	}
	
	public WebElement Source_input_btn() {
		return Source_input_btn;
	}
	
	public WebElement Destination_input_btn() {
		return Destination_input_btn;
	}
	
	public WebElement SearchBox_DropDown() {
		return SearchBox_DropDown;
	}
	
	public WebElement First_Option_inDropDown() {
		return First_Option_inDropDown;
	}
	
	public WebElement Request_Btn() {
		return Request_Btn;
	}
	
	
	public WebElement Request_Disabled_Btn() {
		return Request_Disabled_Btn;
	}
	
	public WebElement New_Transfer_Request() {
		return New_Transfer_Request;
	}
	
	

	public void Select_Source_Store() throws InterruptedException {
		
		Thread.sleep(1000);
		Source_input_btn.click();
		Thread.sleep(1000);

		List<WebElement> optList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
 
		int optionSize=optList.size();
		
		System.out.println("Options Size "+optionSize);
		if(optionSize==0)
		{
			
			List<WebElement> optList1=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
			
			int optionSize1=optList1.size();
			
			
			int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize1);
			Thread.sleep(1000);
			String opt=driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).getText();
			Thread.sleep(1000);
			SearchBox_DropDown.clear();
			Thread.sleep(1000);
			SearchBox_DropDown.sendKeys(opt);
			Thread.sleep(5000);
			First_Option_inDropDown.click();
			Thread.sleep(5000);
		
	}
		else //if(optionSize<=10)
		{
			
			
	List<WebElement> optList1=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
			
			int optionSize1=optList1.size();
			
		int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize1);
		
		Thread.sleep(1000);
		
		
		String opt=driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).getText();
		
		Thread.sleep(1000);
		SearchBox_DropDown.clear();
		Thread.sleep(1000);
		SearchBox_DropDown.sendKeys(opt);
		Thread.sleep(5000);
		First_Option_inDropDown.click();
		Thread.sleep(5000);
		
		}
	
}
	
	public void Select_Destination_Store() throws InterruptedException {
		
		Thread.sleep(1000);
		Destination_input_btn.click();
		Thread.sleep(1000);

		List<WebElement> optList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
 
		int optionSize=optList.size();
		
		System.out.println("Options Size "+optionSize);
		if(optionSize==0)
		{
			
			List<WebElement> optList1=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
			
			int optionSize1=optList1.size();
			
			
			int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize1);
			
			
			Thread.sleep(1000);
			
			
			String opt=driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).getText();
			
			Thread.sleep(1000);
			SearchBox_DropDown.clear();
			Thread.sleep(1000);
			SearchBox_DropDown.sendKeys(opt);
			Thread.sleep(5000);
			First_Option_inDropDown.click();
			Thread.sleep(5000);
		
		
	}
		else //if(optionSize<=10)
		{
			
			
	List<WebElement> optList1=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
			
			int optionSize1=optList1.size();
			
		int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize);
		
		Thread.sleep(1000);
		
		
	    Thread.sleep(1000);
		
		
		String opt=driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).getText();
		
		Thread.sleep(1000);
		SearchBox_DropDown.clear();
		Thread.sleep(1000);
		SearchBox_DropDown.sendKeys(opt);
		Thread.sleep(5000);
		First_Option_inDropDown.click();
		Thread.sleep(5000);
		}
	
}
	
	public void select_Destination_store(String store) throws InterruptedException {
		
		   Thread.sleep(1000);
		   Destination_input_btn().click();
		   Thread.sleep(1000);
//		   SearchBox_DropDown().clear();
		   
		   Thread.sleep(1000);
		   SearchBox_DropDown().sendKeys(store);
		   Thread.sleep(1000);
//		   SearchBox_DropDown().sendKeys(Keys.BACK_SPACE);

		   Thread.sleep(1000);
		   First_Option_inDropDown().click();
		
	}

	
}
