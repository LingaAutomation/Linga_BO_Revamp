package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_Web_Hooks_Page
{
	public WebDriver driver;
    public ExtentTest test;
   
    
    public Settings_Web_Hooks_Page(WebDriver driver, ExtentTest test) 
    {
    	this.driver=driver;
    	this.test=test;
    	
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//div[@class='settings']")
	WebElement Settings;
    
    @FindBy(xpath = "//span[.='Web Hooks']")
    WebElement WebHooks;
    
    @FindBy(xpath = "//span[.='Request Header']/../../div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")
    WebElement apiKeyTextbox ;
    
    @FindBy(xpath = "//span[.='Request Header']/../../div[3]/app-input/div/div/mat-form-field/div/div/div[4]/input")
    WebElement ValueTextbox;
    
    @FindBy(xpath = "//span[.='Close Order Web Hooks']/../../../div[2]/app-input/div/div/mat-form-field/div/div/div[4]/textarea")
    WebElement CloseOrderText;
    
    @FindBy(xpath = "//span[.='Close Order Web Hooks Is Active']/../..//button[.='No']")
    WebElement Close_Order_NoToggle;
    
    @FindBy(xpath = "//span[.='Close Order Web Hooks Is Active']/../..//button[.='Yes']")
    WebElement Close_Order_YesToggle;
    
    @FindBy(xpath = "//span[.='Open Order Web Hooks']/../../../div[2]/app-input/div/div/mat-form-field/div/div/div[4]/textarea")
    WebElement OpenOrderText;
    
    @FindBy(xpath = "//span[.='Open Order Web Hooks Is Active']/../..//button[.='Yes']")
    WebElement Open_Order_YesToggle;
    
    @FindBy(xpath = "//span[.='Open Order Web Hooks Is Active']/../..//button[.='No']")
    WebElement Open_Order_NoToggle;
    
    @FindBy(xpath = "//span[.='Update Order Web Hooks']/../../../div[2]/app-input/div/div/mat-form-field/div/div/div[4]/textarea")
    WebElement UpdateOrderText;
    
    @FindBy(xpath = "//span[.='Update Order Web Hooks Is Active']/../..//button[.='Yes']")
    WebElement Update_Order_YesToggle;
    
    @FindBy(xpath = "//span[.='Update Order Web Hooks Is Active']/../..//button[.='No']")
    WebElement Update_Order_NoToggle;
    
    @FindBy(xpath = "//span[.='3rd Order Web Hooks Is Active']/../..//button[.='Yes']")
    WebElement Third_Order_YesToggle;
    
    @FindBy(xpath = "//span[.='3rd Order Web Hooks Is Active']/../..//button[.='No']")
    WebElement Third_Order_NoToggle;
    
    @FindBy(xpath = "//button[.='UPDATE']")
    WebElement update;
    
    public void Navigating_Settings() 
	{
		Settings.click();
	}
    
    public void Navigating_WebHooks() {
    	WebHooks.click();
    }
    
    public void Entering_Key_value() throws Exception
    {   
    	apiKeyTextbox.click();
    	apiKeyTextbox.clear();
    	Thread.sleep(3000);
    	apiKeyTextbox.sendKeys("1");
    	ValueTextbox.clear();
    	Thread.sleep(3000);
    	ValueTextbox.sendKeys("3");
    	Thread.sleep(2000);
    }
    public void Entering_Infinity_Key_value() throws Exception 
    {
    	apiKeyTextbox.clear();
    	apiKeyTextbox.sendKeys("1234567899999999");
    	Thread.sleep(3000);
    	ValueTextbox.clear();
    	Thread.sleep(3000);
    	ValueTextbox.sendKeys("456284756773788728");
    	Thread.sleep(2000);
    }
    public void Entering_alphabets() throws Exception
    {
    	apiKeyTextbox.clear();
    	apiKeyTextbox.sendKeys("abcde");
    	Thread.sleep(3000);
    	ValueTextbox.clear();
    	Thread.sleep(3000);
    	ValueTextbox.sendKeys("pqrs");
    	Thread.sleep(2000);
    }
    public void Entering_Alphabets_Num_Key_Value() throws Exception 
    {
    	apiKeyTextbox.clear();
    	apiKeyTextbox.sendKeys("12abcde3456");
    	Thread.sleep(3000);
    	ValueTextbox.clear();
    	Thread.sleep(3000);
    	ValueTextbox.sendKeys("897pqr345sqqd");
    	Thread.sleep(2000);
    }
    public void Entering_Specialchar_Key_value() throws Exception
    {
    	apiKeyTextbox.clear();
    	apiKeyTextbox.sendKeys("@#!%$");
    	Thread.sleep(3000);
    	ValueTextbox.clear();
    	Thread.sleep(3000);
    	ValueTextbox.sendKeys("&^%*%");
    	Thread.sleep(2000);
    }
    public void Entering_SpecialChar_Alpha_Key_Value() throws Exception 
    {
    	apiKeyTextbox.clear();
    	apiKeyTextbox.sendKeys("@#!%$qwer");
    	Thread.sleep(3000);
    	ValueTextbox.clear();
    	Thread.sleep(3000);
    	ValueTextbox.sendKeys("drfg&^%*%");
    	Thread.sleep(2000);	
    }
    public void Entering_Closeorder_URL() throws Exception 
    {
    	CloseOrderText.clear();
    	Thread.sleep(2000);
    	CloseOrderText.sendKeys("https://mystore.lingaros.com");
    }
    public void Entering_CloseOrder_Numbers() throws Exception 
    {
    	CloseOrderText.clear();
    	Thread.sleep(2000);
    	CloseOrderText.sendKeys("040799");
    }
    public void Entering_Closeorder_SpecialChar() throws Exception
    {
    	CloseOrderText.clear();
    	Thread.sleep(2000);
    	CloseOrderText.sendKeys("$%^#@");
    }
    public void Entering_Closeorder_InvalidURL() throws Exception
    {
    	CloseOrderText.clear();
    	Thread.sleep(2000);
    	CloseOrderText.sendKeys("https://mystore.lingaros.com/main.html");	
    }
    public void Entering_Closeorder_NUM_ALPHA_Spechar() throws Exception 
    {
    	CloseOrderText.clear();
    	Thread.sleep(2000);
    	CloseOrderText.sendKeys("acd@#!1234");
    }
    public void Clikcing_Closeorder_WebHooks_Yes()
    {
    	Close_Order_YesToggle.click();
    }
    public void Clicking_Closeorder_WebHooks_No() 
    {
    	Close_Order_NoToggle.click();
    }
    public void Entering_Openorder_URL() throws Exception 
    {
    	OpenOrderText.clear();
    	Thread.sleep(1000);
    	OpenOrderText.sendKeys("hooks:https://mystore.lingaros.com");
    }
    public void Entering_Openorder_NUM() throws Exception
    {
    	OpenOrderText.clear();
    	Thread.sleep(1000);
    	OpenOrderText.sendKeys("34567");
    }
    public void Entering_Openorder_SpecialChar() throws Exception 
    {
    	OpenOrderText.clear();
    	Thread.sleep(1000);
    	OpenOrderText.sendKeys("%^#$&");
    }
    public void Entering_Openorder_NUM_SpecialChar_Alpha() throws Exception 
    {
    	OpenOrderText.clear();
    	Thread.sleep(1000);
    	OpenOrderText.sendKeys("%^#afdvr1234");	
    }
    public void Entering_Openorder_InvalidURL() throws Exception
    {
    	OpenOrderText.clear();
    	Thread.sleep(1000);
    	OpenOrderText.sendKeys("https://mystore.lingaros.com/main.html");	
    }
    public void Clikcing_Openorder_WebHooks_Yes()
    {
    	Open_Order_YesToggle.click();
    }
    public void Clicking_Openorder_WebHooks_No() 
    {
    	Open_Order_NoToggle.click();
    }
    public void Entering_Updateorder_URL() throws Exception 
    {
    	UpdateOrderText.clear();
    	Thread.sleep(1000);
    	UpdateOrderText.sendKeys("hooks:https://mystore.lingaros.com");
    }
    public void Entering_Updateorder_NUM() throws Exception
    {
    	UpdateOrderText.clear();
    	Thread.sleep(1000);
    	UpdateOrderText.sendKeys("34567");
    }
    public void Entering_Updateorder_SpecialChar() throws Exception 
    {
    	UpdateOrderText.clear();
    	Thread.sleep(1000);
    	UpdateOrderText.sendKeys("%^#$&");
    }
    public void Entering_Updateorder_NUM_SpecialChar_Alpha() throws Exception 
    {
    	UpdateOrderText.clear();
    	Thread.sleep(1000);
    	UpdateOrderText.sendKeys("%^#afdvr1234");	
    }
    public void Entering_Updateorder_InvalidURL() throws Exception
    {
    	UpdateOrderText.clear();
    	Thread.sleep(1000);
    	UpdateOrderText.sendKeys("https://mystore.lingaros.com/main.html");	
    }
    public void Clicking_Updateorder_WebHooks_Yes()
    {
    	Update_Order_YesToggle.click();
    }
    public void Clicking_Updateorder_WebHooks_No() 
    {
    	Update_Order_NoToggle.click();
    }
    public void Clicking_Thirdorder_WebHooks_Yes()
    {
    	Third_Order_YesToggle.click();
    }
    public void Clicking_Thirdorder_WebHooks_No() 
    {
    	Third_Order_NoToggle.click();
    }
    public void Update() 
    {
    	update.click();
     }

	
}
