package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.Keys;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_NotificationsPage 
{
	public WebDriver driver;
	public ExtentTest test;
	Utility ut=new Utility();

	public Settings_NotificationsPage(WebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class='settings']")
	WebElement Settings;

	@FindBy(xpath = "//span[.='Notifications']")
	WebElement Notifications;

	@FindBy(xpath = "//span[.='Discount']/../..//button[.='Yes']")
	WebElement Discount_YesToggle;

	@FindBy(xpath = "//span[.='Discount']/../..//button[.='No']")
	WebElement Discount_NoToggle;

	@FindBy(xpath = "//span[.='Discount']/../../div/div/div/div/app-currency-input/div//input")
	WebElement Discount_Limit_Textbox;

	@FindBy(xpath = "//span[.='Discount']/../../div[3]/div/div/app-checkbox[1]/div/mat-checkbox/label/span/input[@type='checkbox']")
	WebElement Discount_TextMsg;

	@FindBy(xpath = "//span[.='Discount']/../../div[3]/div/div/app-checkbox[2]/div/mat-checkbox/label/span/input[@type='checkbox']")
	WebElement Discount_Email;
	
	@FindBy(xpath = "//span[.='Discount']/../../div[3]/div/div/app-checkbox[1]/div/mat-checkbox/label")
	WebElement Discount_TextMsgs;

	@FindBy(xpath = "//span[.='Discount']/../../div[3]/div/div/app-checkbox[2]/div/mat-checkbox/label")
	WebElement Discount_Emails;

	@FindBy(xpath = "//span[.='Discount']/../../div[3]/div/div[4]/div/div/div/app-input/div/div/mat-form-field/div/div/div[4]/span[contains(.,'Phone')]/../input")
	WebElement Phone_no;

	@FindBy(xpath = "//span[.='Discount']/../../div[3]/div/div[4]/div/div/div/app-input/div/div/mat-form-field/div/div/div[4]/span[contains(.,'Email')]/../input")
	WebElement Email;

	@FindBy(xpath = "//span[.='Void']/../..//button[.='Yes']")
	WebElement Void_YesToggle;

	@FindBy(xpath = "//span[.='Void']/../..//button[.='No']")
	WebElement Void_NoToggle;

	@FindBy(xpath = "//mat-label[.=' Void Limit ']/../../../input")
	WebElement Void_Limit;
	
	@FindBy(xpath = "//span[.='Void']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@type='checkbox']")
	WebElement Void_TextMsg;

	@FindBy(xpath = "//span[.='Void']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox/label/span/input[@type='checkbox']")
	WebElement Void_EmailMsg;

	@FindBy(xpath = "//span[.='Void']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label")
	WebElement Void_TextMsgs;

	@FindBy(xpath = "//span[.='Void']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox/label")
	WebElement Void_EmailMsgs;

	@FindBy(xpath = "//span[.='Void']/../../div[3]/div[2]/div/app-input/div/div/mat-form-field/div/div/div[4]/span[contains(.,'Phone')]/../input")
	WebElement Void_Phoneno;

	@FindBy(xpath = "//span[.='Void']/../../div[3]/div[2]/div/app-input/div/div/mat-form-field/div/div/div[4]/span[contains(.,'Email')]/../input")
	WebElement Void_Email;

	@FindBy(xpath = "//span[.='Max No Cash Drawer Accessed For No Sale']/../..//button[.='Yes']")
	WebElement CashDrawer_YesToggle;

	@FindBy(xpath = "//span[.='Max No Cash Drawer Accessed For No Sale']/../..//button[.='No']")
	WebElement CashDrawer_NoToggle;

	@FindBy(xpath = "//span[.='Max No Cash Drawer Accessed For No Sale']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@type='checkbox']")
	WebElement Cash_PhoneMsg;
	
	@FindBy(xpath = "//span[.='Max No Cash Drawer Accessed For No Sale']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label")
	WebElement Cash_PhoneMsgs;

	@FindBy(xpath = "//span[.='Max No Cash Drawer Accessed For No Sale']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox/label/span/input[@type='checkbox']")
	WebElement Cash_EmailMsg;
	
	@FindBy(xpath = "//span[.='Max No Cash Drawer Accessed For No Sale']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox/label")
	WebElement Cash_EmailMsgs;

	@FindBy(xpath = "//span[.='Max No Cash Drawer Accessed For No Sale']/../../div[3]/div[2]/div/app-input/div/div/mat-form-field/div/div/div[4]/span[contains(.,'Phone')]/../input")
	WebElement CashDrawer_Phoneno;

	@FindBy(xpath = "//span[.='Max No Cash Drawer Accessed For No Sale']/../../div[3]/div[2]/div/app-input/div/div/mat-form-field/div/div/div[4]/span[contains(.,'Email')]/../input")
	WebElement CashDrawer_Email;


	@FindBy(xpath = "//button[.='arrow_drop_up']")
	WebElement Arrow_Up;

	@FindBy(xpath = "//button[.='arrow_drop_down']")
	WebElement Arrow_down;

	@FindBy(xpath = "//span[.='Time Clock']/../..//button[.='Yes']")
	WebElement TimeClock_YesToggle;

	@FindBy(xpath = "//span[.='Time Clock']/../..//button[.='No']")
	WebElement TimeClock_NoToggle;

	@FindBy(xpath = "//span[.='Time Clock']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@type='checkbox']")
	WebElement TimeClock_PhoneMsg;

	@FindBy(xpath = "//span[.='Time Clock']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox/label/span/input[@type='checkbox']")
	WebElement TimeClock_EmailMsg;
	
	@FindBy(xpath = "//span[.='Time Clock']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label")
	WebElement TimeClock_PhoneMsgs;

	@FindBy(xpath = "//span[.='Time Clock']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox/label")
	WebElement TimeClock_EmailMsgs;

	@FindBy(xpath = "//span[.='Time Clock']/../../div[3]/div[2]/div/app-input/div/div/mat-form-field/div/div/div[4]/span[contains(.,'Phone')]/../input")
	WebElement TimeClock_Phone;

	@FindBy(xpath = "//span[.='Time Clock']/../../div[3]/div[2]/div/app-input/div/div/mat-form-field/div/div/div[4]/span[contains(.,'Email')]/../input")
	WebElement TimeClock_Email;

	@FindBy(xpath = "//span[.='Daily KPI']/../..//button[.='Yes']")
	WebElement KPI_YesToggle;

	@FindBy(xpath = "//span[.='Daily KPI']/../..//button[.='No']")
	WebElement KPI_NoToggle;

	@FindBy(xpath = "//span[.='Daily KPI']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@type='checkbox']")
	WebElement KPI_PhoneMsg;

	@FindBy(xpath = "//span[.='Daily KPI']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox/label/span/input[@type='checkbox']")
	WebElement KPI_EmailMsg;
	
	@FindBy(xpath = "//span[.='Daily KPI']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label")
	WebElement KPI_PhoneMsgs;

	@FindBy(xpath = "//span[.='Daily KPI']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox/label")
	WebElement KPI_EmailMsgs;

	@FindBy(xpath = "//span[.='Daily KPI']/../../div[3]/div[2]/div/app-input/div/div/mat-form-field/div/div/div[4]/span[contains(.,'Email')]/../input")
	WebElement KPI_Email;

	@FindBy(xpath = "//span[.='Daily KPI']/../../div[3]/div[2]/div/app-input/div/div/mat-form-field/div/div/div[4]/span[contains(.,'Phone')]/../input")
	WebElement KPI_Phone;

	@FindBy(xpath = "//span[.='End Of the Day Alert ']/../..//button[.='Yes']")
	WebElement EOD_YesToggle;

	@FindBy(xpath = "//span[.='End Of the Day Alert ']/../..//button[.='No']")
	WebElement EOD_NoToggle;

	@FindBy(xpath = "//span[.='End Of the Day Alert ']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@type='checkbox']")
	WebElement EOD_PhoneMsg;

	@FindBy(xpath = "//span[.='End Of the Day Alert ']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox/label/span/input[@type='checkbox']")
	WebElement EOD_EmailMsg;
	
	@FindBy(xpath = "//span[.='End Of the Day Alert ']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label")
	WebElement EOD_PhoneMsgs;

	@FindBy(xpath = "//span[.='End Of the Day Alert ']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox/label")
	WebElement EOD_EmailMsgs;

	@FindBy(xpath = "//span[.='End Of the Day Alert ']/../../div[3]/div[2]/div/app-input/div/div/mat-form-field/div/div/div[4]/span[contains(.,'Phone')]/../input")
	WebElement EOD_Phoneno;

	@FindBy(xpath = "//span[.='End Of the Day Alert ']/../../div[3]/div[2]/div/app-input/div/div/mat-form-field/div/div/div[4]/span[contains(.,'Email')]/../input")
	WebElement EOD_Email;

	@FindBy(xpath = "//span[.='Wait List']/../..//button[.='Yes']")
	WebElement Wait_List_YesToggle;
	
	@FindBy(xpath = "//span[.='Wait List']/../../div/div/div/div/app-input/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Wait_List_Text;

	@FindBy(xpath = "//span[.='Wait List']/../..//button[.='No']")
	WebElement Wait_List_NoToggle;

	@FindBy(xpath = "//span[.='Wait List']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@type='checkbox']")
	WebElement WaitList_PhoneMsg;
	
	@FindBy(xpath = "//span[.='Wait List']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label")
	WebElement WaitList_PhoneMsgs;
	
	@FindBy(xpath = "//span[.='Wait List']/../../div[3]/div[2]/div/app-input/div/div/mat-form-field/div/div/div[4]/span[contains(.,'Phone')]/../input")
	WebElement WaitList_Phone;
	
	@FindBy(xpath = "//span[.='Sale Recap Report ']/../..//button[.='Yes']")
	WebElement SRR_YesToggle;
	
	@FindBy(xpath = "//span[.='Sale Recap Report ']/../..//button[.='No']")
	WebElement SRR_NoToggle;
	
	@FindBy(xpath = "//span[.='Sale Recap Report ']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@type='checkbox']")
	WebElement SRR_EmailMsg;
	
	@FindBy(xpath = "//span[.='Sale Recap Report ']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label")
	WebElement SRR_EmailMsgs;
	
	@FindBy(xpath = "//span[.='Sale Recap Report ']/../../div[3]/div[2]/div/app-input/div/div/mat-form-field/div/div/div[4]/span[contains(.,'Email')]/../input")
	WebElement SRR_Email;
	
	@FindBy(xpath = "//span[.='One Page PDF']/../..//button[.='Yes']")
	WebElement OPP_YesToggle;
	
	@FindBy(xpath = "//span[.='One Page PDF']/../..//button[.='No']")
	WebElement OPP_NoToggle;
	
	@FindBy(xpath = "//span[.='One Page PDF']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@type='checkbox']")
	WebElement OPP_EmailMsg;
	
	@FindBy(xpath = "//span[.='One Page PDF']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label")
	WebElement OPP_EmailMsgs;
	
	@FindBy(xpath = "//span[.='One Page PDF']/../../div[3]/div[2]/div/app-input/div/div/mat-form-field/div/div/div[4]/span[contains(.,'Email')]/../input")
	WebElement OPP_Email;
	
	
	@FindBy(xpath = "//mat-hint[.='Enter Valid Phone Number']")
	WebElement Phoneno_Error;
	
	@FindBy(xpath = "//mat-hint[.='Enter Valid Phone Number, Phone Number should be contain atleast 6 digits']")
	WebElement Phoneno_Empty_Error;

	@FindBy(xpath = "//mat-hint[.='Enter Valid Email ID']")
	WebElement Email_Error;

	@FindBy(xpath = "//button[.='SAVE ']")
	WebElement save;

	public void No_Toggle() throws Exception
	{
		//click the no toggle of Discount
		Discount_YesToggle.click();
		Discount_NoToggle.click();
		Thread.sleep(500);
		
		//click the no toggle of Void
		Void_NoToggle.click();
		Thread.sleep(500);
		
		//click the no toggle of Max No Cash Drawer Accessed For No Sale
	      CashDrawer_NoToggle.click();
		Thread.sleep(500);
		
		for(int i = 1;i <= 9;i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		//click the no toggle of Time Clock
	      TimeClock_NoToggle.click();
		Thread.sleep(500);
		
		//click the no toggle of Daily KPI
		KPI_NoToggle.click();
		Thread.sleep(500);
		
		//click the no toggle of End Of the Day Alert
		EOD_NoToggle.click();
		Thread.sleep(500);
		
		for(int i = 1;i <= 9;i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		//click the no toggle of Wait List
		Wait_List_NoToggle.click();
		Thread.sleep(500);
		
		//click the no toggle of Sale Recap Report
		SRR_NoToggle.click();
		Thread.sleep(500);
		
		//click the no toggle of One Page PDF
	      OPP_NoToggle.click();
		Thread.sleep(500);
	}
	
	public void Yes_Toggle() throws Exception
	{			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
				Thread.sleep(1500);
	
				//click the Yes toggle of Discount
				Discount_YesToggle.click();
				Thread.sleep(500);
				
				//check whether the input boxes are displayed or not
				try {
					Discount_Limit();
					
					//check whether the text and email check boxes are checked or not
					try {
						if(driver.findElement(By.xpath("//span[.='Discount']/../../div[3]/div/div/app-checkbox[1]/div/mat-checkbox/label/span/input[@aria-checked='false']")).isDisplayed() && 
								driver.findElement(By.xpath("//span[.='Discount']/../../div[3]/div/div/app-checkbox[2]/div/mat-checkbox/label/span/input[@aria-checked='false']")).isDisplayed())
						{
							//Enable the text check box
							driver.findElement(By.xpath("//span[.='Discount']/../../div[3]/div/div/app-checkbox[1]/div/mat-checkbox")).click();
							
							//Enable the text check box
							driver.findElement(By.xpath("//span[.='Discount']/../../div[3]/div/div/app-checkbox[2]/div/mat-checkbox")).click();
							if(Phone_no.isDisplayed() && Email.isDisplayed())
							{
								Entering_Empty_number();
								
								try {
									if(driver.findElement(By.xpath("//button[@disabled='true']/span/span[.='SAVE ']")).isDisplayed())
									{
										test.log(LogStatus.PASS, "Save button is disabled when there is empty phone number in Discount");

										ut.PassedCaptureScreenshotAsBASE64(driver, test);
									}
								}
								catch(Exception sd)
								{
									test.log(LogStatus.FAIL, "Save button is enabled when there is empty phone number in Discount");

									ut.FailedCaptureScreenshotAsBASE64(driver, test);
								}
								
								Entering_PhoneNo_Discount();
								
								Entering_Invalid_Email();
								Thread.sleep(2000);
								Save_Invalid();
								Thread.sleep(1000);
								Entering_Invalid_Email1();
								Thread.sleep(2000);
								Save_Invalid();
								Thread.sleep(1000);
								Entering_Invalid_Email2();
								Thread.sleep(2000);
								Save_Invalid();
								Thread.sleep(1000);
								Entering_Invalid_Email3();
								Thread.sleep(2000);
								Save_Invalid();
								Thread.sleep(1000);
								Entering_Invalid_Email4();
								Thread.sleep(2000);
								Save_Invalid();
								Thread.sleep(1000);
								Entering_Email_Discount();
								Thread.sleep(1000);
								Save();
								Thread.sleep(3000);
							}
							else
							{
								test.log(LogStatus.FAIL, "Phone number and Email input text box is not displayed, when user select the checkbox of phone number and Email of Discount");
								
								ut.FailedCaptureScreenshotAsBASE64(driver, test);
							}
						}
					}
					catch(Exception e) {
						test.log(LogStatus.FAIL, "Text or email check box is checked after user clicking the YES toggle from No toggle of Discount");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}catch(Exception e)
				{
					test.log(LogStatus.FAIL, "Discount Limit text box is not displayed, when user click the Yes toggle");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				for(int i = 1;i <= 11;i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}
				
				//click the Yes toggle of Void
				Void_YesToggle.click();
				Thread.sleep(500);
				
				//check whether the input boxes are displayed or not
				try {
					Entering_Void_Limit();

					//check whether the text and email check boxes are checked or not
					try {
						if(driver.findElement(By.xpath("//span[.='Void']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@aria-checked='false']")).isDisplayed() &&
								driver.findElement(By.xpath("//span[.='Void']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox/label/span/input[@aria-checked='false']")).isDisplayed())
						{
							//Enable the text check box
							driver.findElement(By.xpath("//span[.='Void']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox")).click();

							//Enable the mail check box
							driver.findElement(By.xpath("//span[.='Void']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox")).click();
							if(Void_Phoneno.isDisplayed() && Void_Email.isDisplayed())
							{
								Entering_Void_Empty_number();

								try {
									if(driver.findElement(By.xpath("//button[@disabled='true']/span/span[.='SAVE ']")).isDisplayed())
									{
										test.log(LogStatus.PASS, "Save button is disabled when there is empty phone number in Void");

										ut.PassedCaptureScreenshotAsBASE64(driver, test);
									}
								}
								catch(Exception sd)
								{
									test.log(LogStatus.FAIL, "Save button is enabled when there is empty phone number in Void");

									ut.FailedCaptureScreenshotAsBASE64(driver, test);
								}

								Entering_Void_PhoneNo();

								Entering_Void_Invalid_Email();
								Thread.sleep(2000);
								Save_Invalid();
								Thread.sleep(1000);
								Entering_Void_Invalid_Email1();
								Thread.sleep(2000);
								Save_Invalid();
								Thread.sleep(1000);
								Entering_Void_Invalid_Email2();
								Thread.sleep(2000);
								Save_Invalid();
								Thread.sleep(1000);
								Entering_Void_Invalid_Email3();
								Thread.sleep(2000);
								Save_Invalid();
								Thread.sleep(1000);
								Entering_Void_Invalid_Email4();
								Thread.sleep(2000);
								Save_Invalid();
								Thread.sleep(1000);
								Entering_Void_Email();
								Thread.sleep(1000);
								Save();
                                Thread.sleep(3000);
							}
							else
							{
								test.log(LogStatus.FAIL, "Phone number and Email input text box is not displayed, when user select the checkbox of phone number and Email of Void");
								
								ut.FailedCaptureScreenshotAsBASE64(driver, test);
							}
						}
					}
					catch(Exception e) {
						test.log(LogStatus.FAIL, "Text or email check box is checked after user clicking the YES toggle from No toggle of Void");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}catch(Exception e)
				{
					test.log(LogStatus.FAIL, "Void Limit text box is not displayed, when user click the Yes toggle");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				for(int i = 1;i <= 11;i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}
				
				Thread.sleep(500);
				//click the Yes toggle of Max No Cash Drawer Accessed For No Sale
			      CashDrawer_YesToggle.click();
				Thread.sleep(500);
				
				//check whether the input boxes are displayed or not
				try {
					Add_Cash_Drawer_Limit();

					//check whether the text and email check boxes are checked or not
					try {
						if(driver.findElement(By.xpath("//span[.='Max No Cash Drawer Accessed For No Sale']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@aria-checked='false']")).isDisplayed() &&
								driver.findElement(By.xpath("//span[.='Max No Cash Drawer Accessed For No Sale']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox/label/span/input[@aria-checked='false']")).isDisplayed())
						{
							//Enable the text check box
							driver.findElement(By.xpath("//span[.='Max No Cash Drawer Accessed For No Sale']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox")).click();

							//Enable the mail check box
							driver.findElement(By.xpath("//span[.='Max No Cash Drawer Accessed For No Sale']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox")).click();
							if(CashDrawer_Phoneno.isDisplayed() && CashDrawer_Email.isDisplayed())
							{
								Entering_CashDrawer_Empty_number();

								try {
									if(driver.findElement(By.xpath("//button[@disabled='true']/span/span[.='SAVE ']")).isDisplayed())
									{
										test.log(LogStatus.PASS, "Save button is disabled when there is empty phone number in Max No Cash Drawer Accessed For No Sale");

										ut.PassedCaptureScreenshotAsBASE64(driver, test);
									}
								}
								catch(Exception sd)
								{
									test.log(LogStatus.FAIL, "Save button is enabled when there is empty phone number in Max No Cash Drawer Accessed For No Sale");

									ut.FailedCaptureScreenshotAsBASE64(driver, test);
								}

								Entering_CashDrawer_Phoneno();

								Entering_CashDrawer_Invalid_Email();
								Thread.sleep(2000);
								Save_Invalid();
								Thread.sleep(1000);
								Entering_CashDrawer_Invalid_Email1();
								Thread.sleep(2000);
								Save_Invalid();
								Thread.sleep(1000);
								Entering_CashDrawer_Invalid_Email2();
								Thread.sleep(2000);
								Save_Invalid();
								Thread.sleep(1000);
								Entering_CashDrawer_Invalid_Email3();
								Thread.sleep(2000);
								Save_Invalid();
								Thread.sleep(1000);
								Entering_CashDrawer_Invalid_Email4();
								Thread.sleep(2000);
								Save_Invalid();
								Thread.sleep(1000);
								Entering_CashDrawer_Email();
								Thread.sleep(1000);
								Save();
                                Thread.sleep(3000);
							}
							else
							{
								test.log(LogStatus.FAIL, "Phone number and Email input text box is not displayed, when user select the checkbox of phone number and Email of Max No Cash Drawer Accessed For No Sale");

								ut.FailedCaptureScreenshotAsBASE64(driver, test);
							}
						}
					}
					catch(Exception e) {
						test.log(LogStatus.FAIL, "Text or email check box is checked after user clicking the YES toggle from No toggle of Max No Cash Drawer Accessed For No Sale");

						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}catch(Exception e)
				{
					test.log(LogStatus.FAIL, "Cash Drawer Limit text box is not displayed, when user click the Yes toggle");

					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				for(int i = 1;i <= 3;i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}
				
				Thread.sleep(500);
				//click the Yes toggle of Time Clock
			      TimeClock_YesToggle.click();
				Thread.sleep(500);
				
				//check whether the text and email check boxes are checked or not
				try {
					if(driver.findElement(By.xpath("//span[.='Time Clock']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@aria-checked='false']")).isDisplayed() &&
							driver.findElement(By.xpath("//span[.='Time Clock']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox/label/span/input[@aria-checked='false']")).isDisplayed())
					{
						//Enable the text check box
						driver.findElement(By.xpath("//span[.='Time Clock']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox")).click();

						//Enable the mail check box
						driver.findElement(By.xpath("//span[.='Time Clock']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox")).click();
						if(TimeClock_Phone.isDisplayed() && TimeClock_Email.isDisplayed())
						{
							Entering_TimeClock_Empty_number();

							try {
								if(driver.findElement(By.xpath("//button[@disabled='true']/span/span[.='SAVE ']")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Save button is disabled when there is empty phone number in Time Clock");

									ut.PassedCaptureScreenshotAsBASE64(driver, test);
								}
							}
							catch(Exception sd)
							{
								test.log(LogStatus.FAIL, "Save button is enabled when there is empty phone number in Time Clock");

								ut.FailedCaptureScreenshotAsBASE64(driver, test);
							}

							Entering_TimeClock_Phoneno();

							Entering_TimeClock_Invalid_Email();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_TimeClock_Invalid_Email1();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_TimeClock_Invalid_Email2();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_TimeClock_Invalid_Email3();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_TimeClock_Invalid_Email4();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_TimeClock_Email();
							Thread.sleep(1000);
							Save();
                            Thread.sleep(3000);
						}
						else
						{
							test.log(LogStatus.FAIL, "Phone number and Email input text box is not displayed, when user select the checkbox of phone number and Email of Time Clock");

							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
					}
				}
				catch(Exception e) {
					test.log(LogStatus.FAIL, "Text or email check box is checked after user clicking the YES toggle from No toggle of Time Clock");

					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}

			for(int i = 1;i <= 4;i++)
            {
            	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
            }
				
			Thread.sleep(500);
				//click the Yes toggle of Daily KPI
				KPI_YesToggle.click();
				Thread.sleep(500);
				
				//check whether the text and email check boxes are checked or not
				try {
					if(driver.findElement(By.xpath("//span[.='Daily KPI']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@aria-checked='false']")).isDisplayed() &&
							driver.findElement(By.xpath("//span[.='Daily KPI']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox/label/span/input[@aria-checked='false']")).isDisplayed())
					{
						//Enable the text check box
						driver.findElement(By.xpath("//span[.='Daily KPI']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox")).click();

						//Enable the mail check box
						driver.findElement(By.xpath("//span[.='Daily KPI']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox")).click();
						if(KPI_Phone.isDisplayed() && KPI_Email.isDisplayed())
						{
							Entering_KPI_Empty_number();

							try {
								if(driver.findElement(By.xpath("//button[@disabled='true']/span/span[.='SAVE ']")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Save button is disabled when there is empty phone number in Daily KPI");

									ut.PassedCaptureScreenshotAsBASE64(driver, test);
								}
							}
							catch(Exception sd)
							{
								test.log(LogStatus.FAIL, "Save button is enabled when there is empty phone number in Daily KPI");

								ut.FailedCaptureScreenshotAsBASE64(driver, test);
							}

							Entering_KPI_Phoneno();

							Entering_KPI_Invalid_Email();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_KPI_Invalid_Email1();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_KPI_Invalid_Email2();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_KPI_Invalid_Email3();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_KPI_Invalid_Email4();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_KPI_Email();
							Thread.sleep(1000);
							Save();
                            Thread.sleep(3000);
						}
						else
						{
							test.log(LogStatus.FAIL, "Phone number and Email input text box is not displayed, when user select the checkbox of phone number and Email of Daily KPI");

							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
					}
				}
				catch(Exception e) {
					test.log(LogStatus.FAIL, "Text or email check box is checked after user clicking the YES toggle from No toggle of Daily KPI");

					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}

			for(int i = 1;i <= 4;i++)
            {
            	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
            }
				
			Thread.sleep(500);
				//click the Yes toggle of End Of the Day Alert
				EOD_YesToggle.click();
				Thread.sleep(500);
				
				//check whether the text and email check boxes are checked or not
				try {
					if(driver.findElement(By.xpath("//span[.='End Of the Day Alert ']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@aria-checked='false']")).isDisplayed() &&
							driver.findElement(By.xpath("//span[.='End Of the Day Alert ']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox/label/span/input[@aria-checked='false']")).isDisplayed())
					{
						//Enable the text check box
						driver.findElement(By.xpath("//span[.='End Of the Day Alert ']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox")).click();

						//Enable the mail check box
						driver.findElement(By.xpath("//span[.='End Of the Day Alert ']/../../div[3]/div/div//app-checkbox[2]/div/mat-checkbox")).click();
						if(EOD_Phoneno.isDisplayed() && EOD_Email.isDisplayed())
						{
							Entering_EOD_Empty_number();

							try {
								if(driver.findElement(By.xpath("//button[@disabled='true']/span/span[.='SAVE ']")).isDisplayed())
								{
									test.log(LogStatus.PASS, "Save button is disabled when there is empty phone number in End of the Day Alert");

									ut.PassedCaptureScreenshotAsBASE64(driver, test);
								}
							}
							catch(Exception sd)
							{
								test.log(LogStatus.FAIL, "Save button is enabled when there is empty phone number in End of the Day Alert");

								ut.FailedCaptureScreenshotAsBASE64(driver, test);
							}

							Entering_EOD_Phoneno();

							Entering_EOD_Invalid_Email();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_EOD_Invalid_Email1();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_EOD_Invalid_Email2();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_EOD_Invalid_Email3();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_EOD_Invalid_Email4();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_EOD_Email();
							Thread.sleep(1000);
							Save();
                            Thread.sleep(3000);
						}
						else
						{
							test.log(LogStatus.FAIL, "Phone number and Email input text box is not displayed, when user select the checkbox of phone number and Email of End of the Day Alert");

							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
					}
				}
				catch(Exception e) {
					test.log(LogStatus.FAIL, "Text or email check box is checked after user clicking the YES toggle from No toggle of End of the Day Alert");

					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}

			for(int i = 1;i <= 4;i++)
            {
            	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
            }
			Thread.sleep(500);
			
				//click the Yes toggle of Wait List
				Wait_List_YesToggle.click();
				Thread.sleep(500);
				
				//check whether the input boxes are displayed or not
				try {
					Entering_WaitList_Text();

					//check whether the text and email check boxes are checked or not
					try {
						if(driver.findElement(By.xpath("//span[.='Wait List']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@aria-checked='false']")).isDisplayed())
						{
							//Enable the text check box
							driver.findElement(By.xpath("//span[.='Wait List']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox")).click();

							if(WaitList_Phone.isDisplayed())
							{
								Entering_WaitList_Empty_number();

								try {
									if(driver.findElement(By.xpath("//button[@disabled='true']/span/span[.='SAVE ']")).isDisplayed())
									{
										test.log(LogStatus.PASS, "Save button is disabled when there is empty phone number in Wait List");

										ut.PassedCaptureScreenshotAsBASE64(driver, test);
									}
								}
								catch(Exception sd)
								{
									test.log(LogStatus.FAIL, "Save button is enabled when there is empty phone number in Wait List");

									ut.FailedCaptureScreenshotAsBASE64(driver, test);
								}

								Entering_WaitList_Phoneno();
								Thread.sleep(1000);
								Save();
                                Thread.sleep(3000);
							}
							else
							{
								test.log(LogStatus.FAIL, "Phone number input text box is not displayed, when user select the checkbox of phone number of Wait List");

								ut.FailedCaptureScreenshotAsBASE64(driver, test);
							}
						}
					}
					catch(Exception e) {
						test.log(LogStatus.FAIL, "Text or email check box is checked after user clicking the YES toggle from No toggle of Wait List");

						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}catch(Exception e)
				{
					test.log(LogStatus.FAIL, "Custom Text text box is not displayed, when user click the Yes toggle");

					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}

				for(int i = 1;i <= 9;i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}
				
				Thread.sleep(500);
				//click the Yes toggle of Sale Recap Report
				SRR_YesToggle.click();
				Thread.sleep(500);
				
				//check whether the text and email check boxes are checked or not
				try {
					if(driver.findElement(By.xpath("//span[.='Sale Recap Report ']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@aria-checked='false']")).isDisplayed())
					{
						//Enable the mail check box
						driver.findElement(By.xpath("//span[.='Sale Recap Report ']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox")).click();

						if(SRR_Email.isDisplayed())
						{
							Entering_SRR_Invalid_Email();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_SRR_Invalid_Email1();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_SRR_Invalid_Email2();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_SRR_Invalid_Email3();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_SRR_Invalid_Email4();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_SRR_Email();
							Thread.sleep(1000);
							Save();
                            Thread.sleep(3000);
						}
						else
						{
							test.log(LogStatus.FAIL, "Email input text box is not displayed, when user select the checkbox of email of Sale Recap Report");

							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
					}
				}
				catch(Exception e) {
					test.log(LogStatus.FAIL, "Email check box is checked after user clicking the YES toggle from No toggle of Sale Recap Report");

					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}


			for(int i = 1;i <= 4;i++)
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}
				
			Thread.sleep(500);
				//click the Yes toggle of One Page PDF
			      OPP_YesToggle.click();
				Thread.sleep(500);
				
				//check whether the text and email check boxes are checked or not
				try {
					if(driver.findElement(By.xpath("//span[.='One Page PDF']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@aria-checked='false']")).isDisplayed())
					{
						//Enable the mail check box
						driver.findElement(By.xpath("//span[.='One Page PDF']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox")).click();

						if(OPP_Email.isDisplayed())
						{
							Entering_OPP_Invalid_Email();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_OPP_Invalid_Email1();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_OPP_Invalid_Email2();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_OPP_Invalid_Email3();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_OPP_Invalid_Email4();
							Thread.sleep(2000);
							Save_Invalid();
							Thread.sleep(1000);
							Entering_OPP_Email();
							Thread.sleep(1000);
							Save();
                            Thread.sleep(3000);
						}
						else
						{
							test.log(LogStatus.FAIL, "Email input text box is not displayed, when user select the checkbox of email of One Page PDF");

							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
					}
				}
				catch(Exception e) {
					test.log(LogStatus.FAIL, "Email check box is checked after user clicking the YES toggle from No toggle of One Page PDF");

					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
	}
	
	public WebElement Phone_No_ErrMsg() 
	{
		return Phoneno_Error;
	}
	public WebElement Phone_Empty_ErrMsg()
	{
		return Phoneno_Empty_Error;
	}
	public WebElement Email_Error_Msg()
	{
		return Email_Error;
	}
	
	//Selecting store
	public void Click_store() throws InterruptedException 
	{
        driver.findElement(By.xpath("(//div[contains(@class,'menu-item-title')])[2]/span")).click();
        Thread.sleep(8000);
        driver.findElement(By.xpath("//input[@data-placeholder='Search']")).sendKeys("PART4");    Thread.sleep(5000);
        driver.findElement(By.xpath("(//div[contains(@class,'row ')])[9]/div[1]")).click();
        }

	public void Navigating_settings() 
	{
		Settings.click();
	}
	public void Navigating_Notifications()
	{
		Notifications.click();
	}
	public void Selecting_Discount_Yes() 
	{
		Discount_YesToggle.click();
	}
	public void Discount_Limit() throws Exception
	{
		
		String limit= "12.33";
		String limit1 = Discount_Limit_Textbox.getAttribute("input");
		//int s = Integer.parseInt(limit1);
		Discount_Limit_Textbox.clear();
		Thread.sleep(1000);
		Discount_Limit_Textbox.sendKeys("12.33");	
		
		System.out.println(limit1);
		if(limit1==limit) {
			System.out.println("both the value are equal");
		}
		else {
			System.out.println("both the values in Discount limit are not equal");
		}
	}
	public void Discount_Clicking_TextBox() 
	{
		if(Discount_TextMsg.isSelected()) 
		{

		}
		else 
		{
			Discount_TextMsgs.click();
		}
	}
	public void Discount_Clicking_Email() 
	{
		if(Discount_Email.isSelected())
		{

		}
		else
		{
			Discount_Emails.click();
		}
	}
	public void Entering_PhoneNo_Discount() throws Exception
	{
		Phone_no.clear();
		Thread.sleep(1000);
		Phone_no.sendKeys("97654322");
	}
	public void Entering_Email_Discount() throws Exception 
	{
		Email.clear();
		Thread.sleep(1000);
		Email.sendKeys("lingaros@mail.com");
	}
	public void Entering_Empty_number() throws Exception 
	{
		Phone_no.clear();
		Thread.sleep(1000);
		Phone_no.sendKeys("3432432443");
		for(int i = 1; i<=12;i++) {Phone_no.sendKeys(Keys.BACK_SPACE);}Thread.sleep(1000);
	}
	public void Entering_Invalid_Phoneno_ThreeNum() throws Exception
	{
		Phone_no.clear();
		Thread.sleep(1000);
		Phone_no.sendKeys("123");
	}
	public void Entering_Invalid_Phoneno_specialChar() throws Exception
	{
		Phone_no.clear();
		Thread.sleep(1000);
		Phone_no.sendKeys("@#$%^&");
	}
	public void Entering_Invalid_Phoneno_Combination() throws Exception
	{
		Phone_no.clear();
		Thread.sleep(1000);
		Phone_no.sendKeys("@#$%^&123abdvf");
	}
	public void Entering_Invalid_PhoneNo() throws Exception 
	{
		Phone_no.clear();
		Thread.sleep(1000);
		Phone_no.sendKeys("cbhegfybbhd");
	}
	public void Entering_Invalid_Email() throws Exception
	{
		Email.clear();
		Thread.sleep(1000);
		Email.sendKeys("1234569");
	}
	public void Entering_Invalid_Email1() throws Exception 
	{
		Email.clear();
		Thread.sleep(1000);
		Email.sendKeys("revamp");
	}
	public void Entering_Invalid_Email2() throws Exception 
	{
		Email.clear();
		Thread.sleep(1000);
		Email.sendKeys("$%^%%^@mail");
	}
	public void Entering_Invalid_Email3() throws Exception 
	{
		Email.clear();
		Thread.sleep(1000);
		Email.sendKeys("123.com");
	}
	public void Entering_Invalid_Email4() throws Exception 
	{
		Email.clear();
		Thread.sleep(1000);
		Email.sendKeys("123sdv%$$@com");
	}
	public void Selecting_Discount_No()
	{
		Discount_NoToggle.click();
	}
	public void Selecting_Void_Yes() throws Exception
	{
		Void_YesToggle.click();
		try {
			if(Void_Limit.isDisplayed()) {}
		}catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Void Limit input text is not displayed, when user click the Yes toggle of Void");
			Void_NoToggle.click();
			Thread.sleep(2000);
			Void_YesToggle.click();
		}
	}
	public void Entering_Void_Limit() throws Exception
	{
		String Void_limit="0.00";
		Void_Limit.clear();
		Thread.sleep(1000);
		Void_Limit.sendKeys("35.06");
		String limit2 = Void_Limit.getAttribute("value");
		if(Void_limit.equals(limit2)) {
			System.out.println("Both the values are equal");
		}
		else {
			System.out.println("Both the values in void limit are not equal");
		}
	}
	public void Void_Clicking_Text() throws InterruptedException
	{
		try {
			if(driver.findElement(By.xpath("//span[.='Void']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@aria-checked='true']/../..")).isDisplayed()) {
				try {
					if(Void_Phoneno.isDisplayed()) {}
				}catch(Exception e) {
					test.log(LogStatus.FAIL, "After Enable the Text Check box the phone number input field is missing for VOID");
				}
			}
			else
			{
				driver.findElement(By.xpath("//span[.='Void']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@type='checkbox']/../..")).click();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//span[.='Void']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@type='checkbox']/../..")).click();
			}
		}catch(Exception e)
		{
			driver.findElement(By.xpath("//span[.='Void']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@type='checkbox']/../..")).click();
			Thread.sleep(1000);
			//driver.findElement(By.xpath("//span[.='Void']/../../div[3]/div/div//app-checkbox[1]/div/mat-checkbox/label/span/input[@type='checkbox']/../..")).click();
		}
	}
	public void Void_Clicking_Email() 
	{
		if(Void_EmailMsg.isDisplayed()) {}else {Void_EmailMsgs.click();}
	}
	public void Entering_Void_PhoneNo() throws Exception
	{
		Void_Phoneno.clear();
		Thread.sleep(1000);
		Void_Phoneno.sendKeys("456788939");
	}
	public void Entering_Void_Email() throws Exception 
	{
		Void_Email.clear();
		Thread.sleep(1000);
		Void_Email.sendKeys("ros@mail.com");
	}
	public void Entering_Void_Empty_number() throws Exception 
	{
		Void_Phoneno.clear();
		Thread.sleep(1000);
		Void_Phoneno.sendKeys(" ");
	}
		public void Entering_Void_Invalid_Phoneno_ThreeNum() throws Exception
		{
			Void_Phoneno.clear();
			Thread.sleep(1000);
			Void_Phoneno.sendKeys("123");
		}
		public void Entering_Void_Invalid_Phoneno_specialChar() throws Exception
		{
			Void_Phoneno.clear();
			Thread.sleep(1000);
			Void_Phoneno.sendKeys("@#$%^&");
		}
		public void Entering_Void_Invalid_Phoneno_Combination() throws Exception
		{
			Void_Phoneno.clear();
			Thread.sleep(1000);
			Void_Phoneno.sendKeys("@#$%^&123abdvf");
		}
	
	public void Entering_Void_Invalid_PhoneNo() throws Exception 
	{
		Void_Phoneno.clear();
		Thread.sleep(1000);
		Void_Phoneno.sendKeys("cbhegfybbhd");
	}
	public void Entering_Void_Invalid_Email() throws Exception 
	{
		Void_Email.clear();
		Thread.sleep(1000);
		Void_Email.sendKeys("1234569");
	}
	public void Entering_Void_Invalid_Email1() throws Exception 
	{
		Void_Email.clear();
		Thread.sleep(1000);
		Void_Email.sendKeys("revamp");
	}
	public void Entering_Void_Invalid_Email2() throws Exception 
	{
		Void_Email.clear();
		Thread.sleep(1000);
		Void_Email.sendKeys("$%^%%^@mail");
	}
	public void Entering_Void_Invalid_Email3() throws Exception 
	{
		Void_Email.clear();
		Thread.sleep(1000);
		Void_Email.sendKeys("123.com");
	}
	public void Entering_Void_Invalid_Email4() throws Exception 
	{
		Void_Email.clear();
		Thread.sleep(1000);
		Void_Email.sendKeys("123sdv%$$@com");
	}
	public void Selecting_Void_No() 
	{
		Void_NoToggle.click();
	}
	public void Clikcing_CashDrawer_Yes() 
	{
		CashDrawer_YesToggle.click();
	}
	public void Add_Cash_Drawer_Limit() throws Exception 
	{
		String Value = driver.findElement(By.xpath("//span[.='Max No Cash Drawer Accessed For No Sale']/../../div[3]/div/div/div/app-input/div/div/mat-form-field/div/div/div[4]/input[@class]")).getAttribute("value");
		System.out.println(Value);
		Arrow_Up.click();
		Thread.sleep(1000);
		Arrow_down.click();
	}
	public void Clicking_CashDrawer_Text() 
	{		try {
		if(Cash_PhoneMsg.isSelected()) {}
	}catch(Exception e) {Cash_PhoneMsgs.click();}
	}
	public void Clicking_CashDrawer_Email() 
	{		try {
		if(Cash_EmailMsg.isSelected()) {}
	}catch(Exception e) {Cash_EmailMsgs.click();}
	}
	public void Entering_CashDrawer_Phoneno() throws Exception
	{
		CashDrawer_Phoneno.clear();
		Thread.sleep(1000);
		CashDrawer_Phoneno.sendKeys("234768910");
	}
	public void Entering_CashDrawer_Email() throws Exception 
	{
		CashDrawer_Email.clear();
		Thread.sleep(1000);
		CashDrawer_Email.sendKeys("linga@mail.com");
	}
	public void Entering_CashDrawer_Empty_number() throws Exception 
	{
		CashDrawer_Phoneno.clear();
		Thread.sleep(1000);
		CashDrawer_Phoneno.sendKeys(" ");
	}
	
		public void Entering_CashDrawer_Invalid_Phoneno_ThreeNum() throws Exception
		{
			CashDrawer_Phoneno.clear();
			Thread.sleep(1000);
			CashDrawer_Phoneno.sendKeys("123");
		}
		public void Entering_CashDrawer_Invalid_Phoneno_specialChar() throws Exception
		{
			CashDrawer_Phoneno.clear();
			Thread.sleep(1000);
			CashDrawer_Phoneno.sendKeys("@#$%^&");
		}
		public void Entering_CashDrawer_Invalid_Phoneno_Combination() throws Exception
		{
			CashDrawer_Phoneno.clear();
			Thread.sleep(1000);
			CashDrawer_Phoneno.sendKeys("@#$%^&123abdvf");
		}
	
	public void Entering_CashDrawer_Invalid_PhoneNo() throws Exception 
	{
		CashDrawer_Phoneno.clear();
		Thread.sleep(1000);
		CashDrawer_Phoneno.sendKeys("cbhegfybbhd");
	}
	public void Entering_CashDrawer_Invalid_Email() throws Exception 
	{
		CashDrawer_Email.clear();
		Thread.sleep(1000);
		CashDrawer_Email.sendKeys("1234569");
	}
	public void Entering_CashDrawer_Invalid_Email1() throws Exception 
	{
		CashDrawer_Email.clear();
		Thread.sleep(1000);
		CashDrawer_Email.sendKeys("revamp");
	}
	public void Entering_CashDrawer_Invalid_Email2() throws Exception 
	{
		CashDrawer_Email.clear();
		Thread.sleep(1000);
		CashDrawer_Email.sendKeys("$%^%%^@mail");
	}
	public void Entering_CashDrawer_Invalid_Email3() throws Exception 
	{
		CashDrawer_Email.clear();
		Thread.sleep(1000);
		CashDrawer_Email.sendKeys("123.com");
	}
	public void Entering_CashDrawer_Invalid_Email4() throws Exception 
	{
		CashDrawer_Email.clear();
		Thread.sleep(1000);
		CashDrawer_Email.sendKeys("123sdv%$$@com");
	}
	public void Clicking_CashDrawer_No()
	{
		CashDrawer_NoToggle.click();
	}
	public void Clicking_TimeClock_Yes() 
	{
		TimeClock_YesToggle.click();
	}
	public void Clicking_Timeclock_Text() 
	{		try {
		if(TimeClock_PhoneMsg.isSelected()) {}
	}catch(Exception e) {TimeClock_PhoneMsgs.click();}
	}
	public void Clicking_TimeClock_Email() 
	{		try {
		if(TimeClock_EmailMsg.isSelected()) {}
	}catch(Exception e) {TimeClock_EmailMsgs.click();}
	}
	public void Entering_TimeClock_Phoneno() throws Exception 
	{
		TimeClock_Phone.clear();
		Thread.sleep(1000);
		TimeClock_Phone.sendKeys("3456123456");
	}
	public void Entering_TimeClock_Email() throws Exception 
	{
		TimeClock_Email.clear();
		Thread.sleep(1000);
		TimeClock_Email.sendKeys("linga@mail.com");
	}
	public void Entering_TimeClock_Empty_number() throws Exception 
	{
		TimeClock_Phone.clear();
		Thread.sleep(1000);
		TimeClock_Phone.sendKeys(" ");
	}
	public void Entering_TimeClock_Invalid_Phoneno_ThreeNum() throws Exception
	{
		TimeClock_Phone.clear();
		Thread.sleep(1000);
		TimeClock_Phone.sendKeys("123");
	}
	public void Entering_TimeClock_Invalid_Phoneno_specialChar() throws Exception
	{
		TimeClock_Phone.clear();
		Thread.sleep(1000);
		TimeClock_Phone.sendKeys("@#$%^&");
	}
	public void Entering_TimeClock_Invalid_Phoneno_Combination() throws Exception
	{
		TimeClock_Phone.clear();
		Thread.sleep(1000);
		TimeClock_Phone.sendKeys("@#$%^&123abdvf");
	}

	public void Entering_TimeClock_Invalid_PhoneNo() throws Exception 
	{
		TimeClock_Phone.clear();
		Thread.sleep(1000);
		TimeClock_Phone.sendKeys("cbhegfybbhd");
	}
	public void Entering_TimeClock_Invalid_Email() throws Exception 
	{
	    TimeClock_Email.clear();
		Thread.sleep(1000);
		TimeClock_Email.sendKeys("1234569");
	}
	public void Entering_TimeClock_Invalid_Email1() throws Exception 
	{
		TimeClock_Email.clear();
		Thread.sleep(1000);
		TimeClock_Email.sendKeys("revamp");
	}
	public void Entering_TimeClock_Invalid_Email2() throws Exception 
	{
		TimeClock_Email.clear();
		Thread.sleep(1000);
		TimeClock_Email.sendKeys("$%^%%^@mail");
	}
	public void Entering_TimeClock_Invalid_Email3() throws Exception 
	{
		TimeClock_Email.clear();
		Thread.sleep(1000);
		TimeClock_Email.sendKeys("123.com");
	}
	public void Entering_TimeClock_Invalid_Email4() throws Exception 
	{
		TimeClock_Email.clear();
		Thread.sleep(1000);
		TimeClock_Email.sendKeys("123sdv%$$@com");
	}
	public void Clicking_Timeclock_No() 
	{
		TimeClock_NoToggle.click();
	}
	public void Clicking_KPI_Yes() 
	{
		KPI_YesToggle.click();
	}
	public void Clicking_KPI_Text() throws Exception
	{
		try {
			if(KPI_PhoneMsg.isSelected()) {}
		}catch(Exception e) {KPI_PhoneMsgs.click();}
	}
	public void Clicking_KPI_Email()
	{try {
		if(KPI_EmailMsg.isSelected()) {}
	}catch(Exception e) {KPI_EmailMsgs.click();}
	}
	public void Entering_KPI_Phoneno() throws Exception
	{
		KPI_Phone.clear();
		Thread.sleep(1000);
		KPI_Phone.sendKeys("45678923");
	}
	public void Entering_KPI_Email() throws Exception
	{
		KPI_Email.clear();
		Thread.sleep(1000);
		KPI_Email.sendKeys("revamp@mail.com");
	}
	public void Entering_KPI_Empty_number() throws Exception 
	{
		KPI_Phone.clear();
		Thread.sleep(1000);
		KPI_Phone.sendKeys(" ");
	}
	public void Entering_KPI_Invalid_Phoneno_ThreeNum() throws Exception
	{
		KPI_Phone.clear();
		Thread.sleep(1000);
		KPI_Phone.sendKeys("123");
	}
	public void Entering_KPI_Invalid_Phoneno_specialChar() throws Exception
	{
		KPI_Phone.clear();
		Thread.sleep(1000);
		KPI_Phone.sendKeys("@#$%^&");
	}
	public void Entering_KPI_Invalid_Phoneno_Combination() throws Exception
	{
		KPI_Phone.clear();
		Thread.sleep(1000);
		KPI_Phone.sendKeys("@#$%^&123abdvf");
	}

	public void Entering_KPI_Invalid_PhoneNo() throws Exception 
	{
		KPI_Phone.clear();
		Thread.sleep(1000);
		KPI_Phone.sendKeys("cbhegfybbhd");
	}
	public void Entering_KPI_Invalid_Email() throws Exception 
	{
		KPI_Email.clear();
		Thread.sleep(1000);
		KPI_Email.sendKeys("1234569");
	}
	public void Entering_KPI_Invalid_Email1() throws Exception 
	{
		KPI_Email.clear();
		Thread.sleep(1000);
		KPI_Email.sendKeys("revamp");
	}
	public void Entering_KPI_Invalid_Email2() throws Exception 
	{
		KPI_Email.clear();
		Thread.sleep(1000);
		KPI_Email.sendKeys("$%^%%^@mail");
	}
	public void Entering_KPI_Invalid_Email3() throws Exception 
	{
		KPI_Email.clear();
		Thread.sleep(1000);
		KPI_Email.sendKeys("123.com");
	}
	public void Entering_KPI_Invalid_Email4() throws Exception 
	{
		KPI_Email.clear();
		Thread.sleep(1000);
		KPI_Email.sendKeys("123sdv%$$@com");
	}
	public void Clicking_KPI_NO() 
	{
		KPI_NoToggle.click();
	}
	public void Clicking_EOD_Yes() 
	{
		EOD_YesToggle.click();
	}
	public void Clicking_EOD_Text() throws Exception
	{		try {
		if(EOD_PhoneMsg.isSelected()) {}
	}catch(Exception e) {EOD_PhoneMsgs.click();}
	}
	public void Clicking_EOD_Email()
	{
		try {
			if(EOD_EmailMsg.isSelected()) {}
		}catch(Exception e) {EOD_EmailMsgs.click();}
	}
	public void Entering_EOD_Phoneno() throws Exception
	{
		EOD_Phoneno.clear();
		Thread.sleep(1000);
		EOD_Phoneno.sendKeys("45678923");
	}
	public void Entering_EOD_Email() throws Exception
	{
		EOD_Email.clear();
		Thread.sleep(1000);
		EOD_Email.sendKeys("revamp@mail.com");
	}
	public void Entering_EOD_Empty_number() throws Exception 
	{
		EOD_Phoneno.clear();
		Thread.sleep(1000);
		EOD_Phoneno.sendKeys(" ");
	}
	public void Entering_EOD_Invalid_Phoneno_ThreeNum() throws Exception
	{
		EOD_Phoneno.clear();
		Thread.sleep(1000);
		EOD_Phoneno.sendKeys("123");
	}
	public void Entering_EOD_Invalid_Phoneno_specialChar() throws Exception
	{
		EOD_Phoneno.clear();
		Thread.sleep(1000);
		EOD_Phoneno.sendKeys("@#$%^&");
	}
	public void Entering_EOD_Invalid_Phoneno_Combination() throws Exception
	{
		EOD_Phoneno.clear();
		Thread.sleep(1000);
		EOD_Phoneno.sendKeys("@#$%^&123abdvf");
	}

	public void Entering_EOD_Invalid_PhoneNo() throws Exception 
	{
		EOD_Phoneno.clear();
		Thread.sleep(1000);
		EOD_Phoneno.sendKeys("cbhegfybbhd");
	}
	public void Entering_EOD_Invalid_Email() throws Exception 
	{
		EOD_Email.clear();
		Thread.sleep(1000);
		EOD_Email.sendKeys("1234569");
	}
	public void Entering_EOD_Invalid_Email1() throws Exception 
	{
		EOD_Email.clear();
		Thread.sleep(1000);
		EOD_Email.sendKeys("revamp");
	}
	public void Entering_EOD_Invalid_Email2() throws Exception 
	{
		EOD_Email.clear();
		Thread.sleep(1000);
		EOD_Email.sendKeys("$%^%%^@mail");
	}
	public void Entering_EOD_Invalid_Email3() throws Exception 
	{
		EOD_Email.clear();
		Thread.sleep(1000);
		EOD_Email.sendKeys("123.com");
	}
	public void Entering_EOD_Invalid_Email4() throws Exception 
	{
		EOD_Email.clear();
		Thread.sleep(1000);
		EOD_Email.sendKeys("123sdv%$$@com");
	}
	public void Clicking_EOD_NO() 
	{
		EOD_NoToggle.click();
	}
	public void Clicking_WaitList_Yes() 
	{
		Wait_List_YesToggle.click();
	}
	public void Clicking_WaitList_Text() throws Exception
	{
		try {
			if(WaitList_PhoneMsg.isSelected()) {}
		}catch(Exception e) {WaitList_PhoneMsgs.click();}
	}
	public void Entering_WaitList_Text() throws Exception 
	{
		Wait_List_Text.clear();
		Thread.sleep(1000);
		Wait_List_Text.sendKeys("cvdgegrje");
		Wait_List_Text.clear();
		Thread.sleep(1000);
		Wait_List_Text.sendKeys("12345678902345678912345678923456789");
	}
	
	public void Entering_WaitList_Phoneno() throws Exception
	{
		WaitList_Phone.clear();
		Thread.sleep(1000);
		WaitList_Phone.sendKeys("123456789012345678901234567890");
	}
	public void Entering_WaitList_Empty_number() throws Exception 
	{
		WaitList_Phone.clear();
		Thread.sleep(1000);
		WaitList_Phone.sendKeys(" ");
	}
	public void Entering_WaitList_Invalid_PhoneNo() throws Exception 
	{
		WaitList_Phone.clear();
		Thread.sleep(1000);
		WaitList_Phone.sendKeys("cbhegfybbhd");
	}
	public void Entering_WaitList_Invalid_Phoneno_ThreeNum() throws Exception
	{
		WaitList_Phone.clear();
		Thread.sleep(1000);
		WaitList_Phone.sendKeys("123");
	}
	public void Entering_WaitList_Invalid_Phoneno_specialChar() throws Exception
	{
		WaitList_Phone.clear();
		Thread.sleep(1000);
		WaitList_Phone.sendKeys("@#$%^&");
	}
	public void Entering_WaitList_Invalid_Phoneno_Combination() throws Exception
	{
		WaitList_Phone.clear();
		Thread.sleep(1000);
		WaitList_Phone.sendKeys("@#$%^&123abdvf");
	}

	
	public void Clicking_WaitList_No()
	{
		Wait_List_NoToggle.click();
	}
	public void Clicking_SRR_Yes() 
	{
		SRR_YesToggle.click();
	}
	
	public void Clicking_SRR_Email()
	{
		try {
			if(SRR_EmailMsg.isSelected()) {}
		}catch(Exception e) {SRR_EmailMsgs.click();}
	}
	public void Entering_SRR_Email() throws Exception
	{
		SRR_Email.clear();
		Thread.sleep(1000);
		SRR_Email.sendKeys("revamp@mail.com");
	}
	public void Entering_SRR_Invalid_Email() throws Exception 
	{
		SRR_Email.clear();
		Thread.sleep(1000);
		SRR_Email.sendKeys("1234569");
	}
	public void Entering_SRR_Invalid_Email1() throws Exception 
	{
		SRR_Email.clear();
		Thread.sleep(1000);
		SRR_Email.sendKeys("revamp");
	}
	public void Entering_SRR_Invalid_Email2() throws Exception 
	{
		SRR_Email.clear();
		Thread.sleep(1000);
		SRR_Email.sendKeys("$%^%%^@mail");
	}
	public void Entering_SRR_Invalid_Email3() throws Exception 
	{
		SRR_Email.clear();
		Thread.sleep(1000);
		SRR_Email.sendKeys("123.com");
	}
	public void Entering_SRR_Invalid_Email4() throws Exception 
	{
		SRR_Email.clear();
		Thread.sleep(1000);
		SRR_Email.sendKeys("123sdv%$$@com");
	}
	public void Clicking_SRR_No() 
	{
		SRR_NoToggle.click();
	}
	public void Clicking_OPP_Yes() 
	{
		OPP_YesToggle.click();
	}
	
	public void Clicking_OPP_Email()
	{
		try {
			if(OPP_EmailMsg.isSelected()) {}
		}catch(Exception e) {OPP_EmailMsgs.click();}
	}
	public void Entering_OPP_Email() throws Exception
	{
		OPP_Email.clear();
		Thread.sleep(1000);
		OPP_Email.sendKeys("revamp@mail.com");
	}
	public void Entering_OPP_Invalid_Email() throws Exception 
	{
		OPP_Email.clear();
		Thread.sleep(1000);
		OPP_Email.sendKeys("1234569");
	}
	public void Entering_OPP_Invalid_Email1() throws Exception 
	{
		OPP_Email.clear();
		Thread.sleep(1000);
		OPP_Email.sendKeys("revamp");
	}
	public void Entering_OPP_Invalid_Email2() throws Exception 
	{
		OPP_Email.clear();
		Thread.sleep(1000);
		OPP_Email.sendKeys("$%^%%^@mail");
	}
	public void Entering_OPP_Invalid_Email3() throws Exception 
	{
		OPP_Email.clear();
		Thread.sleep(1000);
		OPP_Email.sendKeys("123.com");
	}
	public void Entering_OPP_Invalid_Email4() throws Exception 
	{
		OPP_Email.clear();
		Thread.sleep(1000);
		OPP_Email.sendKeys("123sdv%$$@com");
	}
	public void Clicking_OPP_No() 
	{
		OPP_NoToggle.click();
	}
	public void Save() throws Exception 
	{
		save.click();
		Common_XPaths cmp = new Common_XPaths(driver, test);
		Utility ut = new Utility();
		Thread.sleep(2000);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Notification Settings Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Notification settings saved successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Notification settings Saving failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}	
	}
	public void Save_Invalid() throws Exception 
	{
		save.click();
		Common_XPaths cmp = new Common_XPaths(driver, test);
		Utility ut = new Utility();
		Thread.sleep(2000);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Error in validation"))
		{
			test.log(LogStatus.PASS, "Entering invalid phone number and Email");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Notification settings Saving failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}	
	}
	
	
}
