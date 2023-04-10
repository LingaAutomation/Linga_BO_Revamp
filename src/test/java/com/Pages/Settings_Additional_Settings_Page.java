package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_Additional_Settings_Page
{
	public WebDriver driver;
	public ExtentTest test;

	public Settings_Additional_Settings_Page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class='settings']")
	WebElement Settings;
	
	@FindBy(xpath = "//span[.='Additional Settings']")
	WebElement Additional_Settings;
	
	@FindBy(xpath = "//span[.='Include Credits in Daily Summary Report']/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='No']")
	WebElement include_Credit_NoToggle;
	
    @FindBy(xpath = "//span[.='Include Credits in Daily Summary Report']/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
	WebElement include_Credit_YesToggle;
    
    @FindBy(xpath = "//span[.='Employee Tip Out Deducted from Cash Expected on Reports ']/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='No']")
    WebElement Employee_Tipout_NoToggle;
    
    @FindBy(xpath = "//span[.='Employee Tip Out Deducted from Cash Expected on Reports ']/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
    WebElement Employee_Tipout_YesToggle;
    
    @FindBy(xpath = "//span[.='Auto Print Close Day Report']/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='No']")
    WebElement Auto_Close_NoToggle;
    
    @FindBy(xpath = "//span[.='Auto Print Close Day Report']/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
    WebElement Auto_Close_YesToggle;
    
    @FindBy(xpath = "//button[.='SAVE']")
    WebElement save;
    
    @FindBy(xpath = "//button[.='keyboard_backspace']")
    WebElement back_space;
	
	public void Click_Setting() 
	{
		Settings.click();
	}
	public void Click_Additional_Settings() 
	{
		Additional_Settings.click();
	}
	public void Selecting_Include_Credits_Yes() 
	{
		include_Credit_YesToggle.click();
		
	}
	public void Selecting_Include_Credits_No() 
	{
		include_Credit_NoToggle.click();
		
	}
	public void Selecting_Employee_Tipout_Yes() 
	{
		Employee_Tipout_YesToggle.click();
	}
	public void Selecting_Employee_Tipout_No() 
	{
		Employee_Tipout_NoToggle.click();
	}
	public void Selecting_Auto_Close_Yes() 
	{
		Auto_Close_YesToggle.click();
	}
	public void Selecting_Auto_Close_No() 
	{
		Auto_Close_NoToggle.click();
	}
	public void Click_Save() throws Exception 
	{
		Common_XPaths cmp = new Common_XPaths(driver, test);
		Utility ut = new Utility();
		
		
		Thread.sleep(500);
    	if(save.isEnabled())
    	{
   		Thread.sleep(500);
    	save.click();
    		System.out.println("Application settings updated");
    		test.log(LogStatus.PASS, "Application Settings Updated Successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
    	}
    	else {
    		System.out.println("Application settings updation failed save button is disabled");
    		test.log(LogStatus.FAIL, "Application settings updation failed because save button is disabled");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
    	}
    }
	public void Navigating_Back()
	{
		back_space.click();
	}
 
}
