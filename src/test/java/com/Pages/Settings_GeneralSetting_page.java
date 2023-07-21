package com.Pages;

import java.awt.Desktop.Action;

import javax.xml.xpath.XPath;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_GeneralSetting_page
{
    public WebDriver driver;
    public ExtentTest test;
   
    
    public  Settings_GeneralSetting_page(WebDriver driver, ExtentTest test) 
    {
    	this.driver=driver;
    	this.test=test;
    	
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//button[@mattooltip='Settings']")
    WebElement Setting;
    
    @FindBy(xpath = "//span[contains(.,'General Settings')]")
    WebElement General_Setting;
    
    @FindBy(xpath = "//span[.='Prompt Tip Screen before Credit Card Screen']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No']")
    WebElement TipScreen_NoToggle;
    
    @FindBy(xpath = "//span[.='Prompt Tip Screen before Credit Card Screen']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
    WebElement TipScreen_YesToggle;
    
    @FindBy(xpath = "//span[.='Enable Intranet sync']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
    WebElement Intranetsync_YesToggle;
    
    @FindBy(xpath = "//span[.='Enable Intranet sync']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No']")
    WebElement Intranetsync_NoToggle;
    
    @FindBy(xpath = "//span[.='Preferred Network ']/../..//input")
    WebElement Prferred_Network_Textbox;
    
    @FindBy(xpath = "//span[.='Enable Pre Auth']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
    WebElement PreAuth;
    
    @FindBy(xpath = "//span[.='Enable Pre Auth']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No']")
    WebElement PreAuth_NoToggle;
    
    @FindBy(xpath = "//div[@class='mat-form-field-infix ng-tns-c79-130']")
    WebElement Pre_AuthAmount;
    
    @FindBy(xpath = "//span[.='Enable Extended Pre Auth']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
    WebElement Extended_PreAuth;
    
    @FindBy(xpath = "//span[.='Enable Extended Pre Auth']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No']")
    WebElement Extended_PreAuth_NoToggle;
    
    @FindBy(xpath = "//span[.='Disable Gift Card Tip']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
    WebElement Giftcard_YesToggle;
    
    @FindBy(xpath = "//span[.='Disable Gift Card Tip']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No']")
    WebElement Giftcard_NoToggle;
    
    @FindBy(xpath = "//span[.='Employee Tip Out Deducted from Cash Expected on Reports']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
    WebElement Tipout_YesToggle;
    
    @FindBy(xpath = "//span[.='Employee Tip Out Deducted from Cash Expected on Reports']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No']")
    WebElement Tipout_NoToggle;
    
    @FindBy(xpath ="//span[.='Enable Gratuity Line in Credit Card Screen']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
    WebElement Gratuity_line_YesToggle;
    
    @FindBy(xpath ="//span[.='Enable Gratuity Line in Credit Card Screen']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No']")
    WebElement Gratuity_line_NoToggle;
    
    @FindBy(xpath = "//span[.='Disable Customer Nationality']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
    WebElement Disable_Nationality_YesToggle;
    
    @FindBy(xpath = "//span[.='Disable Customer Nationality']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No']")
    WebElement Disable_Nationality_NoToggle;
    
    @FindBy(xpath = "//span[.='Require Tax ID on Exempt Transaction']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
    WebElement TaxExempt_YesToggle;
    
    @FindBy(xpath = "//span[.='Require Tax ID on Exempt Transaction']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No']")
    WebElement TaxExempt_NoToggle;
    
    @FindBy(xpath = "//span[.='Auto Log Off ']/../..//button[.='arrow_drop_up']")
    WebElement AutoLogOff_TimeUp;
    
    @FindBy(xpath = "//span[.='Auto Log Off ']/../..//button[.='arrow_drop_down']")
    WebElement AutoLogOff_Timedown;

    
    @FindBy(xpath = "//mat-label[contains(.,'Minutes')]/../../../../../../../div/button/span/mat-icon[.='arrow_drop_up']")
    WebElement Table_expiration_timeup;
    
    @FindBy(xpath = "//mat-label[contains(.,'Minutes')]/../../../../../../../div/button/span/mat-icon[.='arrow_drop_down']")
    WebElement Table_expiration_timedown;
    
    @FindBy(xpath = "//span[.='Custom Split Button Action ']/../..//mat-chip[.=' Split by Check ']")
    WebElement CustomSplit_Splitbycheck;
    
    @FindBy(xpath = "//span[.='Custom Split Button Action ']/../..//mat-chip[.=' Split by Seat ']")
    WebElement CustomSplit_Splitbyseat;
    
    @FindBy(xpath = "//span[.='Auto Generate House Account Number']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
    WebElement HouseAccount_YesToggle;
    
    @FindBy(xpath = "//span[.='Auto Generate House Account Number']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No']")
    WebElement HouseAccount_NoToggle;
    
    @FindBy(xpath = "//span[.='Auto Print Close Day Report']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
    WebElement AutoClose_DayReport_YesToggle;
    
    @FindBy(xpath = "//span[.='Auto Print Close Day Report']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No']")
    WebElement AutoClose_DayReport_NoToggle;
    
    @FindBy(xpath = "//span[.='Log In/Clock In Via']/../..//mat-chip[.=' PIN ']")
    WebElement ClockIn_Pin;
    
    @FindBy(xpath = "//span[.='Log In/Clock In Via']/../..//mat-chip[.=' Face ID ']")
    WebElement ClockIn_Faceid;
    
    @FindBy(xpath = "//span[contains(.,'Check Closer')]/../..")
    WebElement Check_closer;
    
    @FindBy(xpath = "//span[contains(.,'Check Creator')]/../..")
    WebElement Check_Creator;
    
    @FindBy(xpath = "//mat-radio-button[contains(.,' Percentage ')]")
    WebElement Tip_Percentage;
    
    @FindBy(xpath = "//mat-radio-button[contains(.,' Amount ')]")
    WebElement Tip_Amount;
    
    @FindBy(xpath = "//span[.='Floating Tab']/../..//input[@type='text']")
    WebElement Floating_Tab;
    
    @FindBy(xpath = "//span[.='Hide Seat Number in Kitchen Print']/../../div[3]/app-chip/div/mat-chip-list/div/mat-chip[2]")
    WebElement Hide_TableService;
    
    @FindBy(xpath = "//span[.='Hide Seat Number in Kitchen Print']/../../div[3]/app-chip/div/mat-chip-list/div/mat-chip[3]")
    WebElement Hide_BarTab;
    
    @FindBy(xpath = "//span[.='Hide Seat Number in Kitchen Print']/../../div[3]/app-chip/div/mat-chip-list/div/mat-chip[4]")
    WebElement Hide_Togo;
    
    @FindBy(xpath = "//span[.='Hide Seat Number in Kitchen Print']/../../div[3]/app-chip/div/mat-chip-list/div/mat-chip[5]")
    WebElement Hide_Phoneorder;
    
    @FindBy(xpath = "//span[.='Hide Seat Number in Kitchen Print']/../../div[3]/app-chip/div/mat-chip-list/div/mat-chip[6]")
    WebElement Hide_Weborder;
    
    @FindBy(xpath = "//span[.='Membership Auto Renewal']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
    WebElement Memship_Auto_Renewal_YesToggle;
    
    @FindBy(xpath = "//span[.='Membership Auto Renewal']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No']")
    WebElement Memship_Auto_Renewal_NoToggle;
    
    @FindBy(xpath = "//span[.='Store Level Customer']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
    WebElement Store_Level_Custo_YesToggle;
    
    @FindBy(xpath = "//span[.='Store Level Customer']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No']")
    WebElement Store_Level_Custo_NoToggle;
    
    @FindBy(xpath = "//span[contains(.,'12 Hours')]/../..")
    WebElement TimeFormat_12hours;
    
    @FindBy(xpath = "//span[contains(.,'24 Hours')]/../..")
    WebElement TimeFormat_24hours;
    
    @FindBy(xpath = "//span[contains(.,'Default')]/../..")
    WebElement DateForm_Default;
    
    @FindBy(xpath = "//span[contains(.,'MM-DD-YYYY')]/../..")
    WebElement DateForm_2nd;
    
    @FindBy(xpath = "//span[contains(.,'DD-MM-YYYY')]/../..")
    WebElement DateForm_3rd;
    
    @FindBy(xpath = "//span[.='Tip Suggestion on Credit Card Receipt ']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
    WebElement Tip_Suggestion_YesToggle;
    
    @FindBy(xpath = "//span[.='Tip Suggestion on Credit Card Receipt ']/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No']")
    WebElement Tip_Suggestion_NoToggle;
    
    @FindBy(xpath = "//button[.='UPDATE']" )
    WebElement Update_Button;
    
    @FindBy(xpath = "//button/span[.=' yes ']" )
    WebElement yes_btn_alert;
    
    @FindBy(xpath = "//div[@class='alert-header']/../div/p" )
    WebElement Alert_txt;
  
    Utility ut=new Utility();
   
    public void NavigatingSettings()
    {
    	Setting.click();
    }
    public void NavigateGeneralSetting() 
    {
    	General_Setting.click();
    }
    
    public void EnablingTipScreen() throws Exception
    {
    	
Thread.sleep(1000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView(true);",TipScreen_YesToggle );
//		TipScreen_YesToggle.click();
		for(int i=1;i<=18;i++)
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		
		Thread.sleep(2500);
		if(TipScreen_YesToggle.isSelected())
		{
			
		}
		else
		{driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
			Thread.sleep(1000);
			TipScreen_YesToggle.click();
		}
    }
		public void DisablingTipScreen() {
			
		if(TipScreen_NoToggle.isSelected())
		{
			
		}
		else {
			TipScreen_NoToggle.click();
		}
    
    }
    public void Enabling_Intranet_Sync() throws Exception
    {
    	
		Thread.sleep(2000);
    	Intranetsync_YesToggle.click();
    	//Thread.sleep(5000);
    	Common_XPaths cmp = new Common_XPaths(driver, test);
    	
		if(Alert_txt.getText().equals("Do you have intranet sync device?"))
		{
			test.log(LogStatus.PASS, "Do you have intranet sync device? alert displayed Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Do you have intranet sync device? alert is not displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
    	
        Thread.sleep(2000);
        yes_btn_alert.click();
     }
    public void Disabling_Intranet_Sync() {
    	Intranetsync_NoToggle.click();
    }
    
    public void preferredNetwork() throws Exception 
    {
    	Thread.sleep(1000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView(true);",Prferred_Network_Textbox );
		for(int i=1;i<=3;i++)
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1000);
		Prferred_Network_Textbox.clear();
    	Prferred_Network_Textbox.sendKeys("LAN");
    	
    }
    public void Enabling_PreAuth() throws Exception 
    {
    	Thread.sleep(1000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView(true);",	PreAuth );
		for(int i=1;i<=4;i++) 
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);
		if(PreAuth.isSelected())
		{
			 
		}
		else
		{
			Thread.sleep(1000);
			PreAuth.click();
		}
     }
    public void Disabling_PreAuth() throws Exception
    {
    	 Thread.sleep(1000);
         PreAuth_NoToggle.click();
    	//Pre_AuthAmount.sendKeys("400");
    }
    
    public void Enable_Extended_PreAuth() throws Exception 
    {
    	for(int i=1;i<=4;i++) 
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);
		if(Extended_PreAuth.isSelected())
		{
			 
		}
		else
		{
			Thread.sleep(1000);
			Extended_PreAuth.click();
		}
    }
    public void Disabling_Extended_Pre_Auth() throws Exception {
    	Thread.sleep(1000);
		Extended_PreAuth_NoToggle.click();
    }
    public void Enabling_Giftcard() throws Exception 
    {
    	Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);

		if(Giftcard_YesToggle.isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			Giftcard_YesToggle.click();
		}
    }
    public void Disabling_Giftcard() throws Exception
    {
    	Thread.sleep(1000);
		Giftcard_NoToggle.click();
    }
    public void Enabling_Tipout() throws Exception 
    {
    	Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);

		if(Tipout_YesToggle.isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			Tipout_YesToggle.click();
		}
    }
    public void Disabling_Tipout() throws Exception {
    	Thread.sleep(1000);
		Tipout_NoToggle.click();
    }
    public void enabling_Gratuity_Line() throws Exception 
    {
    Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);

		if(Gratuity_line_YesToggle.isSelected())
		{
			
		}	
		else
		{
			Thread.sleep(1000);
			Gratuity_line_YesToggle.click();
		}
    }
    public void Disabling_Gratuity_Line() throws Exception {
    	Thread.sleep(1000);
		Gratuity_line_NoToggle.click();
    }
    public void Disable_Customer_Nationality() throws Exception 
    {
    	Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);

		if(Disable_Nationality_YesToggle.isSelected())
		{
			
		}	
		else
		{
			Thread.sleep(1000);
			Disable_Nationality_YesToggle.click();
		}
    }
    public void Enabling_Customer_Nationality() throws Exception {
    	Thread.sleep(1500);
		Disable_Nationality_NoToggle.click();
    }
    public void Enabling_TaxExempt() throws Exception
    {

    	Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1000);

		if(TaxExempt_YesToggle.isSelected())
		{
			
		}	
		else
		{
			Thread.sleep(1000);
			TaxExempt_YesToggle.click();
		}
    }
    public void Disabling_TaxExempt() throws Exception {
    	Thread.sleep(1000);
		TaxExempt_NoToggle.click();
    }
    public void Auto_logOff_Time() throws Exception
    {
    	Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1000);
		 AutoLogOff_TimeUp.click();
		 Thread.sleep(1000);
		 AutoLogOff_Timedown.click();
		 Thread.sleep(1000);
		 AutoLogOff_TimeUp.click();

    }
    public void entering_Table_expiration_time() throws Exception
    {
    	Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);
		 Table_expiration_timeup.click();
		 Thread.sleep(2000);
		 Table_expiration_timedown.click();
		 Thread.sleep(1500);
		 Table_expiration_timeup.click();

    }
    public void Selecting_CustomSplit_Check() throws Exception 
    {

    	Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);
		if( CustomSplit_Splitbycheck.isSelected())
		{
			
		}	
		else
		{
			Thread.sleep(1000);
			CustomSplit_Splitbycheck.click();
		}
		 
    }
    public void Selecting_Custom_SplitSeat() throws Exception {
    	Thread.sleep(1000);
    	CustomSplit_Splitbyseat.click();
    }
    public void Enabling_Automatic_Houseaccount() throws Exception 
    {
    	 Thread.sleep(1000);
     	for(int i=1;i<=4;i++) 
 		{
 		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
 		}
 		Thread.sleep(1500);

 		if(HouseAccount_YesToggle.isSelected())
 		{
 			
 		}	
 		else
 		{
 			Thread.sleep(1000);
 			HouseAccount_YesToggle.click();
 		}
     }
    public void Disabling_Automatic_Houseaccount() throws Exception {
    	Thread.sleep(1000);
 		HouseAccount_NoToggle.click();
    }
    public void Enabling_AutoCloseDay_Report() throws Exception
    {
    	 Thread.sleep(1000);
      	for(int i=1;i<=4;i++) 
  		{
  		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
  		}
  		Thread.sleep(1500);

  		if(AutoClose_DayReport_YesToggle.isSelected())
  		{
  			
  		}	
  		else
  		{
  			Thread.sleep(1000);
  			AutoClose_DayReport_YesToggle.click();
  		}
    }
    public void Disabling_AutoCloseDay_Report() throws Exception {
    	Thread.sleep(1000);
  		AutoClose_DayReport_NoToggle.click();
    }
    public void Selecting_ClockIn() throws Exception 
    {
    	Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1000);
		if(ClockIn_Pin.isSelected()) 
		{
			
		}
		else {
			ClockIn_Pin.click();
		}
	}
    public void Selecting_FaceId() throws Exception {
    	Thread.sleep(1000);
    	if(ClockIn_Faceid.isSelected()) {
    		
    	}
    	else {
		ClockIn_Faceid.click();
    	}
    }
    public void Selecting_Checkowner() throws Exception 
    {

    	Thread.sleep(1000);
    	for(int i=1;i<=2;i++) 
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1000);
		if(Check_Creator.isSelected()) 
		{
			
		}
		else {
			Check_Creator.click();
		}
    }
    public void Selecting_CheckCloser() throws Exception {
    	Thread.sleep(1000);
    	if(Check_closer.isSelected()) 
		{
			
		}
		else {
			Check_closer.click();
		}
		
    }
    public void Tip_Settings_Amount() throws Exception
    {
    	Thread.sleep(1000);
    	for(int i=1;i<=2;i++) 
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1000);
		if(Tip_Amount.isSelected()) 
		{
			
		}
		else {
			Tip_Amount.click();
		}
    }
    public void Tip_Settings_Per() throws Exception {
    	Thread.sleep(1000);
    	if(Tip_Percentage.isSelected()) 
		{
			
		}
		else {
			Tip_Percentage.click();
		}
    }
    public void Entering_FloatingTab() throws Exception
    {
    	Thread.sleep(1000);
    	for(int i=1;i<=2;i++) 
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
    	Thread.sleep(1000);
    	Floating_Tab.clear();
    	Floating_Tab.sendKeys("Bar Tab");
    }
    public void Hide_SeatNumber_In_KitchenPrinter() throws Exception 
    {
    	Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
    	if(Hide_TableService.isSelected())
    	{
    		
    	}
    	else {
    		Hide_TableService.click();
    	}
    }
    public void Hide_PhoneOrder() throws Exception 
    {driver.findElement(By.xpath("//button[contains(.,'Show All')]")).click();Thread.sleep(1000);
    if(Hide_Phoneorder.isSelected()) {
    	
    }
    else {
    	Hide_Phoneorder.click();
    }
    }	
    public void Hide_Togo() throws Exception {
    	Thread.sleep(1000);
    	if(Hide_Togo.isSelected()) {
    		
    	}
    	else {
    		Hide_Togo.click();
    	}
    }
    	public void Hide_Weborder() throws Exception 
    	{
    	Thread.sleep(1000);
    	if(Hide_Weborder.isSelected()) {
    		
    	}
    	else {
    	Hide_Weborder.click();
    	}
    	Thread.sleep(500);
    }
    	public void Hide_BarTab() {
    		if(Hide_BarTab.isSelected()) {
    			
    		}
    		else {
    			Hide_BarTab.click();
    		}
    	}
    
    public void Enabling_Memship_AutoRenewal() throws Exception 
    {
    	 Thread.sleep(1000);
       	for(int i=1;i<=6;i++) 
   		{
   		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
   		}
   		Thread.sleep(1000);

   		if(Memship_Auto_Renewal_YesToggle.isSelected())
   		{
   			
   		}	
   		else
   		{
   			Thread.sleep(1000);
   			Memship_Auto_Renewal_YesToggle.click();
   		}
   	}
   public void  Disabling_Membership_Renewal() throws Exception {
	   Thread.sleep(1500);
  		Memship_Auto_Renewal_NoToggle.click();
   }
    public void Enabling_Storelevel_Customer() throws Exception 
    {
    	Thread.sleep(1000);
       	for(int i=1;i<=4;i++) 
   		{
   		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
   		}
   		Thread.sleep(1500);

   		if(Store_Level_Custo_YesToggle.isSelected())
   		{
   			
   		}	
   		else
   		{
   			Thread.sleep(1000);
   			Store_Level_Custo_YesToggle.click();
   		}
    }
    public void Disabling_Storelevel_Customer() throws Exception {
    	Thread.sleep(1500);
   		Store_Level_Custo_NoToggle.click();
    }
    public void Time_Format() throws Exception 
    {
    	Thread.sleep(1000);
		for(int i=1;i<=4;i++) 
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);
		
		if( TimeFormat_24hours.isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			TimeFormat_24hours.click();
		}
		Thread.sleep(1500);
		TimeFormat_12hours.click();
    
    }
    public void Date_Format() throws Exception 
    {
    	for(int i=1;i<=4;i++) 
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);
		DateForm_Default.click();
			
    }
    public void Date_2nd() throws Exception
    {
    	Thread.sleep(1000);
		if(DateForm_2nd.isSelected()) {
			
		}
		else {
			DateForm_2nd.click();
		}
    }
    public void Date_3rd() throws Exception
    {
    	Thread.sleep(1000);
		if(DateForm_3rd.isSelected()) {
			
		}
		else {
			DateForm_3rd.click();
		}
    }
    public void enablingTipScreen() throws Exception
    {
    	for(int i=1;i<=4;i++) 
    	{
        driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
    	}
		Thread.sleep(1500);
		if(Tip_Suggestion_YesToggle.isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			Tip_Suggestion_YesToggle.click();
		}
    }
    public void Disabling_Tipscreen() throws Exception {
    	Thread.sleep(1500);
		Tip_Suggestion_NoToggle.click();
    }
    
    
    public void update() throws Exception 
    {
    	Utility ut= new Utility();
    	Thread.sleep(5500);
    	try
    	{
   		Thread.sleep(500);
    		Update_Button.click();
    		Thread.sleep(2000);
    		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
    		
    		//Verify the success message
    		if(s.equals("Application Settings Updated Successfully"))
    		{
    			test.log(LogStatus.PASS, "Application Settings Updated Successfully");
    			ut.PassedCaptureScreenshotAsBASE64(driver, test);
    		}
    		else
    		{
    			test.log(LogStatus.FAIL, "Application Settings Updated Successfully");
    			ut.FailedCaptureScreenshotAsBASE64(driver, test);
    		}
    		
    		//Click the close button of success message
    		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
    		Thread.sleep(3000);

    	}
    	catch(Exception s) {
    		System.out.println("General settings updation failed update button is disabled");
    		test.log(LogStatus.FAIL, "General settings updation failed, update button is disabled");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
    	}
    }
   
}
