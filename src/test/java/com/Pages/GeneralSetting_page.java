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

public class GeneralSetting_page
{
    public WebDriver driver;
    public ExtentTest test;
   
    
    public  GeneralSetting_page(WebDriver driver, ExtentTest test) 
    {
    	this.driver=driver;
    	this.test=test;
    	
    	PageFactory.initElements(driver, this);
    }
    
    @FindBy(xpath = "//div[@class='settings']")
    WebElement Setting;
    
    @FindBy(xpath = "//span[contains(.,'General Settings')]")
    WebElement General_Setting;
    
    @FindBy(xpath = "//span[.='Prompt Tip Screen before Credit Card Screen ']/../..//button//span[.='No']")
    WebElement TipScreen_NoToggle;
    
    @FindBy(xpath = "//span[.='Prompt Tip Screen before Credit Card Screen ']/../..//button//span[.='Yes']")
    WebElement TipScreen_YesToggle;
    
    @FindBy(xpath = "//span[.='Enable Intranet sync ']/../..//button[.='Yes']")
    WebElement Intranetsync_YesToggle;
    
    @FindBy(xpath = "//span[.='Preferred Network ']/../..//input")
    WebElement Prferred_Network_Textbox;
    
    @FindBy(xpath = "//span[.='Enable Pre Auth ']/../..//button[.='Yes']")
    WebElement PreAuth;
    
    @FindBy(xpath = "//div[@class='mat-form-field-infix ng-tns-c79-38']")
    WebElement Pre_AuthAmount;
    
    @FindBy(xpath = "//span[.='Enable Extended Pre Auth ']/../..//button[.='Yes']")
    WebElement Extended_PreAuth;
    
    @FindBy(xpath = "//span[.='Disable Gift Card Tip ']/../..//button[.='Yes']")
    WebElement Giftcard_YesToggle;
    
    @FindBy(xpath = "//span[.='Employee Tip Out Deducted from Cash Expected on Reports ']/../..//button[.='Yes']")
    WebElement Tipout_YesToggle;
    
    @FindBy(xpath ="//span[.='Enable Gratuity Line in Credit Card Screen ']/../..//button[.='Yes']")
    WebElement Gratuity_line_YesToggle;
    
    @FindBy(xpath = "//span[.='Disable Customer Nationality ']/../..//button[.='Yes']")
    WebElement Disable_Nationality_YesToggle;
    
    @FindBy(xpath = "//span[.='Require Tax ID on Exempt Transaction ']/../..//button[.='Yes']")
    WebElement TaxExempt_YesToggle;
    
    @FindBy(xpath = "//span[.='Auto Log Off ']/../..//button[.='arrow_drop_up']")
    WebElement AutoLogOff_TimeUp;
    
    @FindBy(xpath = "//span[.='Auto Log Off ']/../..//button[.='arrow_drop_down']")
    WebElement AutoLogOff_Timedown;
    
    @FindBy(xpath = "//span[.='Table Expiration Time ']/../..//button[.='arrow_drop_up']")
    WebElement Table_expiration_timeup;
    
    @FindBy(xpath = "//span[.='Table Expiration Time ']/../..//button[.='arrow_drop_down']")
    WebElement Table_expiration_timedown;
    
    @FindBy(xpath = "//span[.='Custom Split Button Action ']/../..//mat-chip[.=' Split by Check ']")
    WebElement CustomSplit_Splitbycheck;
    
    @FindBy(xpath = "//span[.='Custom Split Button Action ']/../..//mat-chip[.=' Split by Seat ']")
    WebElement CustomSplit_Splitbyseat;
    
    @FindBy(xpath = "//span[.='Auto Generate House Account Number ']/../..//button[.='Yes']")
    WebElement HouseAccount_YesToggle;
    
    @FindBy(xpath = "//span[.='Auto Print Close Day Report']/../..//button[.='Yes']")
    WebElement AutoClose_DayReport_YesToggle;
    
    @FindBy(xpath = "//span[.='Log In/Clock In Via ']/../..//mat-chip[.=' PIN ']")
    WebElement ClockIn_Pin;
    
    @FindBy(xpath = "//span[.='Log In/Clock In Via ']/../..//mat-chip[.=' Face ID ']")
    WebElement ClockIn_Faceid;
    
    @FindBy(xpath = "//span[contains(.,'Check Closer')]/../..")
    WebElement Check_closer;
    
    @FindBy(xpath = "//span[contains(.,'Check Creator')]/../..")
    WebElement Check_Creator;
    
    @FindBy(xpath = "//span[contains(.,'Percentage')]/../..")
    WebElement Tip_Percentage;
    
    @FindBy(xpath = "//span[contains(.,'Amount')]/../..")
    WebElement Tip_Amount;
    
    @FindBy(xpath = "//span[.='Floating Tab ']/../..//input[@type='text']")
    WebElement Floating_Tab;
    
    @FindBy(xpath = "//span[.='Hide Seat number in Kitchen Print ']/../..//mat-chip[.=' TABLESERVICE ']")
    WebElement Hide_TableService;
    
    @FindBy(xpath = "//span[.='Hide Seat number in Kitchen Print ']/../..//mat-chip[.=' BarTab ']")
    WebElement Hide_BarTab;
    
    @FindBy(xpath = "//span[.='Hide Seat number in Kitchen Print ']/../..//mat-chip[.=' ToGo ']")
    WebElement Hide_Togo;
    
    @FindBy(xpath = "//span[.='Hide Seat number in Kitchen Print ']/../..//mat-chip[.=' PHONEORDER ']")
    WebElement Hide_Phoneorder;
    
    @FindBy(xpath = "//span[.='Hide Seat number in Kitchen Print ']/../..//mat-chip[.=' WEBORDER ']")
    WebElement Hide_Weborder;
    
    @FindBy(xpath = "//span[.='Membership Auto Renewal ']/../..//button[.='Yes']")
    WebElement Memship_Auto_Renewal_YesToggle;
    
    @FindBy(xpath = "//span[.='Store Level Customer ']/../..//button[.='Yes']")
    WebElement Store_Level_Custo_YesToggle;
    
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
    
    @FindBy(xpath = "//span[.='Tip Suggestion on Credit Card Receipt ']/../..//button[.='Yes']")
    WebElement Tip_Suggestion_YesToggle;
    
    @FindBy(xpath = "//button[.='UPDATE']" )
    WebElement Update_Button;
    
   
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
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",TipScreen_YesToggle );
//		TipScreen_YesToggle.click();
		for(int i=1;i<=8;i++)
		{
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		
		Thread.sleep(1500);
		if(TipScreen_YesToggle.isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			TipScreen_YesToggle.click();
		}
    
    }
    public void Enabling_Intranet_Sync() throws Exception
    {
		Thread.sleep(1000);
    	Intranetsync_YesToggle.click();
    	//Thread.sleep(5000);
    	Common_XPaths cmp = new Common_XPaths(driver, test);
        cmp.VerifySaveConfirmationAlertMessage("Do you have intranet sync device?");
        Thread.sleep(2000);
        cmp.Click_YesButton();
    	
    	
    	
    }
    
    public void preferredNetwork() throws Exception 
    {
    	Thread.sleep(1000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);",Prferred_Network_Textbox );
		for(int i=0;i<1;i++)
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);
    	Prferred_Network_Textbox.sendKeys("LAN");
    	
    }
    public void Enabling_PreAuth() throws Exception 
    {
    	Thread.sleep(1000);
//		JavascriptExecutor js=(JavascriptExecutor)driver;
//		js.executeScript("arguments[0].scrollIntoView(true);",	PreAuth );
		for(int i=1;i<=4;i++) 
		{
			Thread.sleep(500);
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
        // Thread.sleep(1000);
    	//Pre_AuthAmount.sendKeys("400");
    }
    
    public void Enable_Extended_PreAuth() throws Exception 
    {
    	for(int i=1;i<=4;i++) 
		{
			Thread.sleep(500);
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
    public void Enabling_Giftcard() throws Exception 
    {
    	Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
			Thread.sleep(500);
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
    public void Enabling_Tipout() throws Exception 
    {
    	Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
			Thread.sleep(500);
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
    public void enabling_Gratuity_Line() throws Exception 
    {
    Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
			Thread.sleep(500);
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
    public void Disable_Customer_Nationality() throws Exception 
    {
    	Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
			Thread.sleep(500);
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
    public void Enabling_TaxExempt() throws Exception
    {

    	Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);

		if(TaxExempt_YesToggle.isSelected())
		{
			
		}	
		else
		{
			Thread.sleep(1000);
			TaxExempt_YesToggle.click();
		}
    }
    public void Auto_logOff_Time() throws Exception
    {
    	Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);
		 AutoLogOff_TimeUp.click();
		 Thread.sleep(2000);
		 AutoLogOff_Timedown.click();

    }
    public void entering_Table_expiration_time() throws Exception
    {
    	Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);
		 Table_expiration_timeup.click();
		 Thread.sleep(2000);
		 Table_expiration_timedown.click();

    }
    public void Selecting_CustomSplit() throws Exception 
    {

    	Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);
		if( CustomSplit_Splitbycheck.isSelected())
		{
			
		}	
		else
		{
			Thread.sleep(1000);
			CustomSplit_Splitbyseat.click();
		}
		 
    }
    public void Enabling_Automatic_Houseaccount() throws Exception 
    {
    	 Thread.sleep(1000);
     	for(int i=1;i<=4;i++) 
 		{
 			Thread.sleep(500);
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
    public void Enabling_AutoCloseDay_Report() throws Exception
    {
    	 Thread.sleep(1000);
      	for(int i=1;i<=4;i++) 
  		{
  			Thread.sleep(500);
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
    public void Selecting_ClockIn() throws Exception 
    {
    	Thread.sleep(1000);
    	for(int i=1;i<=4;i++) 
		{
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);
		if(ClockIn_Pin.isSelected()) 
		{
			//ClockIn_Faceid.click();
		}
		else {
			ClockIn_Pin.click();
		}
	}
    public void Selecting_Checkowner() throws Exception 
    {

    	Thread.sleep(1000);
    	for(int i=1;i<=2;i++) 
		{
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(2000);
		if(Check_Creator.isSelected()) 
		{
			Check_closer.click();
		}
		else {
			Check_Creator.click();
		}
		 
    }
    public void Tip_Settings() throws Exception
    {
    	Thread.sleep(1000);
    	for(int i=1;i<=2;i++) 
		{
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(2000);
		if(Tip_Amount.isSelected()) 
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
			Thread.sleep(500);
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
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
    	if(Hide_TableService.isSelected())
    	{
    		
    	}
    	else {
    		Hide_Togo.click();
    	}
    }
    public void Enabling_Memship_AutoRenewal() throws Exception 
    {
    	 Thread.sleep(1000);
       	for(int i=1;i<=6;i++) 
   		{
   			Thread.sleep(500);
   		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
   		}
   		Thread.sleep(1500);

   		if(Memship_Auto_Renewal_YesToggle.isSelected())
   		{
   			
   		}	
   		else
   		{
   			Thread.sleep(1000);
   			Memship_Auto_Renewal_YesToggle.click();
   		}
    }
    public void Enabling_Storelevel_Customer() throws Exception 
    {
    	Thread.sleep(1000);
       	for(int i=1;i<=4;i++) 
   		{
   			Thread.sleep(500);
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
    public void Time_Format() throws Exception 
    {
    	Thread.sleep(1000);
		for(int i=1;i<=4;i++) 
		{
			Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);
		
		if( TimeFormat_24hours.isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			TimeFormat_12hours.click();
		}
    
    }
    public void Date_Format() throws Exception 
    {
    	for(int i=1;i<=4;i++) 
		{
    		Thread.sleep(500);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Thread.sleep(1500);
		DateForm_Default.click();
		Thread.sleep(1000);
		DateForm_2nd.click();	
    }
    public void enablingTipScreen() throws Exception
    {
    	for(int i=0;i<=4;i++) 
    	{
    	Thread.sleep(1000);
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
    
    
    public void update() throws Exception 
    {
    	Thread.sleep(500);
    	Update_Button.click();
    }
   
}
