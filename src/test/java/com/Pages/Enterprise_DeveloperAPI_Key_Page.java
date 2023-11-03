package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;

import Utility.Utility;

public class Enterprise_DeveloperAPI_Key_Page extends BasePage
{
//	public SelfHealingDriver driver;
//	public ExtentTest test;
	Utility ut=new Utility();
	Common_XPaths cmp;

	public Enterprise_DeveloperAPI_Key_Page(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[.='Enterprise']")
	WebElement Enterprise_Button;
	
	@FindBy(xpath = "//input[@placeholder='Select License Count']")
	WebElement API_Req_Count_Dropdown;
	
	@FindBy(xpath = "(//select-option)[2]")
	WebElement API_Value;
	
	@FindBy(xpath = "//app-toggle[@name='autorenew']/..//button/span[.='Yes']")
	WebElement Auto_Renew_YesToggle;
	
	@FindBy(xpath = "//app-toggle[@name='autorenew']/..//button/span[.='No']")
	WebElement Auto_Renew_NoToggle;
	
	@FindBy(xpath = "//span[.='UPDATE']")
	WebElement Update_button;
	
	public void Click_Enterprise()
	{
		Enterprise_Button.click();
	}
	
	public void Click_API_Req_Dropdown()
	{
		API_Req_Count_Dropdown.click();
	}
	
	public void Select_API_Value() 
	{
		API_Value.click();
	}
	
	public void Click_AutoRenew_YesToggle() 
	{
		Auto_Renew_YesToggle.click();
	}
	
	public void Click_AutoRenew_NoToggle() 
	{
		Auto_Renew_NoToggle.click();
	}
	
	public void Click_Update() 
	{
		Update_button.click();
	}
}
