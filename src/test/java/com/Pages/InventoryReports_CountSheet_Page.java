package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import Utility.Utility;

public class InventoryReports_CountSheet_Page 
{

	public WebDriver driver;
	public ExtentTest test;
	Utility ut=new Utility();
	Common_XPaths cmp;
	
	TaxesPage tx;
	public InventoryReports_CountSheet_Page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//input[@placeholder='Select Item Type'])[1]")
	WebElement Type;
	
	@FindBy(xpath = "(//input[@placeholder='Select Item Type'])[2]")
	WebElement Storage_Location_InputBox;
	
	public void Select_Type_All() throws Exception 
	{
		Type.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//select-option[contains(.,' ALL ')]")).click();
	}
	
	public void Select_Type_Inventory_Item() throws Exception 
	{
		Type.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//select-option[contains(.,' Inventory Item ')]")).click();
	}
	

	public void Select_Type_Retail_Item() throws Exception 
	{
		Type.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//select-option[contains(.,' Retail Item ')]")).click();
	}
	
	public void Select_Type_Sub_Recipe() throws Exception 
	{
		Type.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//select-option[contains(.,' Sub Recipe ')]")).click();
	}
	
	public void Select_Type_Menu_Item() throws Exception 
	{
		Type.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//select-option[contains(.,' Menu Item ')]")).click();
	}
	
	@FindBy(xpath = "(//input[@placeholder='Select Item Type'])[3]")
	WebElement Category_Level_InputBox;
	
	public void Select_Category_Level_As_Category() throws Exception 
	{
		Category_Level_InputBox.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[.=' Category ']")).click();
	}
	
	public void Select_Category_Level_As_SubCategory() throws Exception 
	{
		Category_Level_InputBox.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[.=' Sub Category ']")).click();
	}
	
//	@FindBy(xpath = "(//input[@placeholder='Select Item Type'])[4]")
//	WebElement Category_InpuBox;
//	
//	@FindBy(xpath = "(//input[@placeholder='Select Item Type'])[5]")
//	WebElement SubCategory_InpuBox;
//	
//	@FindBy(xpath = "(//input[@placeholder='Select Item Type'])[6]")
//	WebElement InventoryItem_InpuBox;
	
	@FindBy(xpath = "//span[.='No Count Sheet Found']")
	WebElement No_CountSheet_Found_Msg;
	
	public WebElement No_CountsheetFound_InfoMessage()
	{
		return No_CountSheet_Found_Msg;
	}
	
	public void Select_Storage_Location_All() throws Exception 
	{
		Storage_Location_InputBox.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//select-option[contains(.,' ALL ')]")).click();
		
	}
	
	public void Select_Storage_Location() throws Exception 
	{
		Storage_Location_InputBox.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='options with-height']//div/div[5]/select-option")).click();
		
	}
	
	
	
}
