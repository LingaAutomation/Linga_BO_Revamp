package com.Pages;

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
	
	
}
