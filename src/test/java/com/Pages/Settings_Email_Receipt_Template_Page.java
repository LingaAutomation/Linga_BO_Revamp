package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_Email_Receipt_Template_Page 
{
	public WebDriver driver;
	public ExtentTest test;
	Utility ut = new Utility();

	public Settings_Email_Receipt_Template_Page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//div[@class='settings']")
	WebElement Settings;

	@FindBy(xpath ="//span[.='Email Receipt Template']")
	WebElement Email_Receipt_Temp;

	@FindBy(xpath = "//div/div/div[.='Store Information']")
	WebElement Store_Inform;

	@FindBy(xpath = "//div/div/div[.='Check Details']")
	WebElement Check_Details;

	@FindBy(xpath = "//div/div[1]/div[.='Order Summary']")
	WebElement Order_Summary;

	@FindBy(xpath = "//div/div/div[.='Additional Details']")
	WebElement additional_Details;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateStoreName']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Store_Name;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateEmail']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Email;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateAddress']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Address;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplatePhoneNumber']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement phone_Number;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateLogo']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Store_Logo;//mat-checkbox[contains(.,'Store Logo') and contains(@class,'checkbox-checked')]

	@FindBy(xpath ="//span[.='emailTemplateTextColor']/../../../div[2]/div[2]")
	WebElement Text_Color_Button;

	@FindBy(xpath = "//div[@class='row no-gutters preset-colors']/div[3]")
	WebElement Text_Color;

	@FindBy(xpath = "//span[.='emailTemplateBackgroundColor']/../../../div[2]/div[2]")
	WebElement Background_Color_Button;

	@FindBy(xpath = "//div[@class='row no-gutters preset-colors']/div[2]")
	WebElement Background_Color;

	@FindBy(xpath = "//div[@class='col-5 settings-area']")
	WebElement scroll;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateCheckNumber']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement check_Number;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateTableName']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Table_No;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateServerName']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Server_Name;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateDate']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Date_Time;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateCustomerName']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Customer_Name;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateSeatNumber']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Seat_Number;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateServiceType']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Service_Type;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateOrderSummary']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement order_summary_Checkbox;;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateNameAndPrice']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Roll_Out_Modifier_Price;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateexcludeZeroPriceModifier']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Exclude_Zero_Price_Modifier;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateMenuDiscount']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Menu_Item_Discount;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateisOtherLanguageMenuName']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Secondary_Menu_Name;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateModifier']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Secondary_Modifier_Name;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateExcludeZeroPriceMenu']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Exclude_Zero_Price_Menu;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateTaxSummary']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Tax_Summary;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateCheckTotal']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Check_Total;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateTip']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Tip;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateTenderDetails']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Tender_Details;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplatePayCardInfo']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Card_Details;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateSignature']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement signature;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateBarcode']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement BarCode;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateLingaPromotion']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Powered_By;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateSocialIcons']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Social_Icon;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateFb']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Facebook;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateTwitter']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Twitter;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateLinkedin']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement LinkedIn;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateCusFeedBack']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Customer_Feedback;

	@FindBy(xpath = "//app-checkbox[@name='emailTemplateNotes']/div/mat-checkbox/label/span[@class='mat-checkbox-inner-container']")
	WebElement Special_Note;

	@FindBy(xpath = "//app-input[@name='emailTemplateFreeText']/div/div/mat-form-field/div/div/div[4]/textarea")
	WebElement Special_Note_Text;

	@FindBy(xpath = "//app-input[@name='emailTemplateFbLink']/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Facebook_Text;

	@FindBy(xpath = "//app-input[@name='emailTemplateTwitterLink']/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Twitter_Text;

	@FindBy(xpath = "//app-input[@name='emailTemplateLinkedinLink']/div/div/mat-form-field/div/div/div[4]/input")
	WebElement LinkedIn_Text;

	@FindBy(xpath = "//app-input[@name='emailTemplateLogoUrl']/div/div/mat-form-field/div/div/div[4]/input")
	WebElement StoreLogo_Text;

	@FindBy(xpath = "//button[.='SAVE']")
	WebElement save;

	public void Click_Save() {
		save.click();
	}

	public void Navigate_Email_Receipt() throws Exception
	{
		Settings.click();
		Thread.sleep(2000);
		Email_Receipt_Temp.click();
	}
	//Performing actions on store information
	public void Clicking_Store_Inform()
	{
		Store_Inform.click();
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Store Name') and contains(@class,'checkbox-checked')]")
	WebElement StoreName_Enabled;
	public void Store_Name() throws Exception
	{
		Store_Name.click();
		try{
			if(StoreName_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//p[.='"+Utility.getProperty("Store1")+" ']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Store Name displayed when user enable the store name");

						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e) {
					test.log(LogStatus.FAIL, "Store name not displyed in template preview after selecting store name checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Store_Name.click();
			try {
				if(driver.findElement(By.xpath("//p[.='"+Utility.getProperty("Store1")+" ']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Store Name displayed when user enable the store name");

					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Store name not displyed in template preview after selecting store name checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Email') and contains(@class,'checkbox-checked')]")
	WebElement Email_Enabled;
	public void Email() throws Exception 
	{
		Email.click();
		try{
			if(Email_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//p[.='"+Utility.getProperty("EmailId")+" ']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Email displayed when user enable the Email");

						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Email not displyed in template preview after selecting Email checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Email.click();
			try {
				if(driver.findElement(By.xpath("//p[.='"+Utility.getProperty("EmailId")+" ']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Email displayed when user enable the Email");

					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Email not displyed in template preview after selecting Email checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
	}
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Phone Number') and contains(@class,'checkbox-checked')]")
	WebElement PhoneNumber_Enabled;
	public void Phone_Number() throws Exception 
	{
		phone_Number.click();
		try{
			if(PhoneNumber_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//p[.='"+Utility.getProperty("PhoneNum")+" ']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Phone Number displayed when user enable the Phone Number");

						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Phone Number not displyed in template preview after selecting Phone Number checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			phone_Number.click();
			try {
				if(driver.findElement(By.xpath("//p[.='"+Utility.getProperty("PhoneNum")+" ']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Phone Number displayed when user enable the Phone Number");

					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Phone Number not displyed in template preview after selecting Phone Number checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Address') and contains(@class,'checkbox-checked')]")
	WebElement Address_Enabled;
	public void Address() throws Exception 
	{
		Address.click();
		try{
			if(Address_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//p[.='"+Utility.getProperty("Street_Name")+" ']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Address displayed when user enable the Address");

						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Address not displyed in template preview after selecting Address checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Address.click();
			try {
				if(driver.findElement(By.xpath("//p[.='"+Utility.getProperty("Street_Name")+" ']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Address displayed when user enable the Address");

					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Address not displyed in template preview after selecting Address checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Store Logo') and contains(@class,'checkbox-checked')]")
	WebElement StoreLogo_Enabled;
	public void Store_Logo() throws Exception 
	{
		Store_Logo.click();
		try{
			if(StoreLogo_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//img[@class='thumbnail-image']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Store Logo displayed when user enable the Store Logo");

						WebElement StoreLogo_Textbox = driver.findElement(By.xpath("//app-input[@name='emailTemplateLogoUrl']/div/div/mat-form-field/div/div/div[4]/input"));
						StoreLogo_Textbox.clear();
						StoreLogo_Textbox.sendKeys("www.google.com");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Store Logo not displyed in template preview after selecting Store Logo checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Store_Logo.click();
			try {
				if(driver.findElement(By.xpath("//img[@class='thumbnail-image']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Store Logo displayed when user enable the Store Logo");

					WebElement StoreLogo_Textbox = driver.findElement(By.xpath("//app-input[@name='emailTemplateLogoUrl']/div/div/mat-form-field/div/div/div[4]/input"));
					StoreLogo_Textbox.clear();
					StoreLogo_Textbox.sendKeys("www.google.com");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Store Logo not displyed in template preview after selecting Store Logo checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	}
	public void Text_Color() throws Exception 
	{
		Text_Color_Button.click();
		Thread.sleep(2000);
		Text_Color.click();
	}
	public void Background_Color() throws Exception 
	{
		for(int i=1;i<=4;i++)
		{
			Thread.sleep(500);
			scroll.click();
		}

		Background_Color_Button.click();
		Thread.sleep(2000);
		Background_Color.click();
	}

	//performing actions on check details
	public void Click_CheckDetails()
	{
		Check_Details.click();
	}
	//mat-checkbox[contains(.,'Store Logo') and contains(@class,'checkbox-checked')]
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Check Number') and contains(@class,'checkbox-checked')]")
	WebElement CheckNumber_Enabled;
	public void Click_CheckNo()
	{
		check_Number.click();
		try{
			if(CheckNumber_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[.='Check No: ']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Check Number displayed when user enable the Check Number");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Check Number not displyed in template preview after selecting Check Number checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			check_Number.click();
			try {
				if(driver.findElement(By.xpath("//span[.='Check No: ']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Check Number displayed when user enable the Check Number");

					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Check Number not displyed in template preview after selecting Check Number checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	@FindBy(xpath = "//mat-checkbox[contains(.,'Table No') and contains(@class,'checkbox-checked')]")
	WebElement TableNumber_Enabled;
	public void Click_TableNo() 
	{
		Table_No.click();
		try{
			if(TableNumber_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[.='Table No: ']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Table Number displayed when user enable the Table Number");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Table Number not displyed in template preview after selecting Table Number checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Table_No.click();
			try {
				if(driver.findElement(By.xpath("//span[.='Table No: ']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Table Number displayed when user enable the Table Number");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Table Number not displyed in template preview after selecting Table Number checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	@FindBy(xpath = "//mat-checkbox[contains(.,'Server Name') and contains(@class,'checkbox-checked')]")
	WebElement ServerName_Enabled;
	public void Click_ServerName()
	{
		Server_Name.click();
		try{
			if(ServerName_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[.='Server: ']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Server Name displayed when user enable the Server Name");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Server Name not displyed in template preview after selecting Server Name checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Server_Name.click();
			try {
				if(driver.findElement(By.xpath("//span[.='Server: ']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Server Name displayed when user enable the Server Name");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Server Name not displyed in template preview after selecting Server Name checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	@FindBy(xpath = "//mat-checkbox[contains(.,'Date & Time') and contains(@class,'checkbox-checked')]")
	WebElement DateAndTime_Enabled;
	public void Click_Date_Time()
	{
		Date_Time.click();
		try{
			if(DateAndTime_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[.='Date: ']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Date and Time displayed when user enable the Date and Time");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Date and Time not displyed in template preview after selecting Date and Time checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Date_Time.click();
			try {
				if(driver.findElement(By.xpath("//span[.='Date: ']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Date and Time displayed when user enable the Date and Time");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Date and Time not displyed in template preview after selecting Date and Time checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Name') and contains(@class,'checkbox-checked')]")
	WebElement CustomerName_Enabled;
	public void Click_CustomerName() 
	{
		Customer_Name.click();
		try{
			if(CustomerName_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[.='Customer: ']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Customer Name displayed when user enable the Customer Name");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Customer Name not displyed in template preview after selecting Customer Name checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Customer_Name.click();
			try {
				if(driver.findElement(By.xpath("//span[.='Customer: ']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Customer Name displayed when user enable the Customer Name");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Customer Name not displyed in template preview after selecting Customer Name checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Seat Number') and contains(@class,'checkbox-checked')]")
	WebElement SeatNumber_Enabled;
	public void Click_SeatNo() 
	{
		Seat_Number.click();
		try{
			if(SeatNumber_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[.='Seat: ']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Seat Number displayed when user enable the Seat Number");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Seat Number not displyed in template preview after selecting Seat Number checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Seat_Number.click();
			try {
				if(driver.findElement(By.xpath("//span[.='Seat: ']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Seat Number displayed when user enable the Seat Number");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Seat Number not displyed in template preview after selecting Seat Number checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Service Type') and contains(@class,'checkbox-checked')]")
	WebElement ServiceType_Enabled;
	public void Click_Service_Type()
	{
		Service_Type.click();
		try{
			if(ServiceType_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[.='Service Type: ']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Service Type displayed when user enable the Service Type");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Service Type not displyed in template preview after selecting Service Type checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Service_Type.click();
			try {
				if(driver.findElement(By.xpath("//span[.='Service Type: ']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Service Type displayed when user enable the Service Type");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Service Type not displyed in template preview after selecting Service Type checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	//Order Summary
	public void Click_OrderSummary()
	{
		Order_Summary.click();
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Order Summary') and contains(@class,'checkbox-checked')]")
	WebElement OrderSummary_Enabled;
	public void Click_Order_Summary_Checkbox()
	{
		order_summary_Checkbox.click();
		try{
			if(OrderSummary_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//h6[.='Order Summary']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Order Summary displayed when user enable the Order Summary");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Order Summary not displyed in template preview after selecting Order Summary checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			order_summary_Checkbox.click();
			try {
				if(driver.findElement(By.xpath("//h6[.='Order Summary']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Order Summary displayed when user enable the Order Summary");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Order Summary not displyed in template preview after selecting Order Summary checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Roll Out Modifier Price To Menu') and contains(@class,'checkbox-checked')]")
	WebElement RollOutModifierPriceToMenu_Enabled;
	public void click_Roll_out_Modifier_Price() 
	{
		Roll_Out_Modifier_Price.click();
		try{
			if(RollOutModifierPriceToMenu_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[.='Mod #1']")).isDisplayed()) 
					{
						test.log(LogStatus.FAIL, "Roll Out Modifier Price To Menu displayed when user enable the Roll Out Modifier Price To Menu");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.PASS, "Roll Out Modifier Price To Menu not displyed in template preview after selecting Roll Out Modifier Price To Menu checkbox");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Roll_Out_Modifier_Price.click();
			try {
				if(driver.findElement(By.xpath("//span[.='Mod #1']")).isDisplayed()) 
				{
					test.log(LogStatus.FAIL, "Roll Out Modifier Price To Menu displayed when user enable the Roll Out Modifier Price To Menu");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.PASS, "Roll Out Modifier Price To Menu not displyed in template preview after selecting Roll Out Modifier Price To Menu checkbox");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Exclude Zero Price Modifier') and contains(@class,'checkbox-checked')]")
	WebElement ExcludeZeroPriceModifier_Enabled;
	public void Click_Exclude_Zero_Modifier() 
	{
		Exclude_Zero_Price_Modifier.click();
		try{
			if(ExcludeZeroPriceModifier_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[.='$00.00']")).isDisplayed()) 
					{
						test.log(LogStatus.FAIL, "Exclude Zero Price Modifier displayed when user enable the Exclude Zero Price Modifier");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.PASS, "Exclude Zero Price Modifier not displyed in template preview after selecting Exclude Zero Price Modifier checkbox");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Exclude_Zero_Price_Modifier.click();
			try {
				if(driver.findElement(By.xpath("//span[.='$00.00']")).isDisplayed()) 
				{
					test.log(LogStatus.FAIL, "Exclude Zero Price Modifier displayed when user enable the Exclude Zero Price Modifier");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.PASS, "Exclude Zero Price Modifier not displyed in template preview after selecting Exclude Zero Price Modifier checkbox");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Discount under the Menu Item') and contains(@class,'checkbox-checked')]")
	WebElement DiscountUderTheMenuItem_Enabled;
	public void Click_Discount_Under_MenuItem() 
	{
		Menu_Item_Discount.click();
		try{
			if(DiscountUderTheMenuItem_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//p[.='Discount']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Discount under the Menu Item displayed when user enable the Discount under the Menu Item");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Discount under the Menu Item not displyed in template preview after selecting Discount under the Menu Item checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Menu_Item_Discount.click();
			try {
				if(driver.findElement(By.xpath("//p[.='Discount']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Discount under the Menu Item displayed when user enable the Discount under the Menu Item");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Discount under the Menu Item not displyed in template preview after selecting Discount under the Menu Item checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Secondary Menu Name') and contains(@class,'checkbox-checked')]")
	WebElement SecondaryMenuName_Enabled;
	public void Click_Secondary_MenuName()
	{
		Secondary_Menu_Name.click();
		try{
			if(SecondaryMenuName_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//p[.='عنصر القائمة']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Secondary Menu Name displayed when user enable the Secondary Menu Name");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Secondary Menu Name not displyed in template preview after selecting Secondary Menu Name checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Secondary_Menu_Name.click();
			try {
				if(driver.findElement(By.xpath("//p[.='عنصر القائمة']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Secondary Menu Name displayed when user enable the Secondary Menu Name");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Secondary Menu Name not displyed in template preview after selecting Secondary Menu Name checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Secondary Modifier Name') and contains(@class,'checkbox-checked')]")
	WebElement SecndaryModifierName_Enabled;
	public void Click_Secondary_Modifier_Name() 
	{
		Secondary_Modifier_Name.click();
		try{
			if(SecndaryModifierName_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[.='$00.00']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Secondary Modifier Name displayed when user enable the Secondary Modifier Name");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Secondary Modifier Name not displyed in template preview after selecting Secondary Modifier Name checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Secondary_Modifier_Name.click();
			try {
				if(driver.findElement(By.xpath("//span[.='$00.00']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Secondary Modifier Name displayed when user enable the Secondary Modifier Name");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Secondary Modifier Name not displyed in template preview after selecting Secondary Modifier Name checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Exclude Zero Price Menu Item') and contains(@class,'checkbox-checked')]")
	WebElement ExcludeZeroPriceMenuItem_Enabled;
	public void Click_Zero_Price_Menu()
	{
		Exclude_Zero_Price_Menu.click();
		try{
			if(ExcludeZeroPriceMenuItem_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[.='$00.00']")).isDisplayed()) 
					{
						test.log(LogStatus.FAIL, "Exclude Zero Price Menu Item displayed when user enable the Exclude Zero Price Menu Item");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.PASS, "Exclude Zero Price Menu Item not displyed in template preview after selecting Exclude Zero Price Menu Item checkbox");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Exclude_Zero_Price_Menu.click();
			try {
				if(driver.findElement(By.xpath("//span[.='$00.00']")).isDisplayed()) 
				{
					test.log(LogStatus.FAIL, "Exclude Zero Price Menu Item displayed when user enable the Exclude Zero Price Menu Item");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.PASS, "Exclude Zero Price Menu Item not displyed in template preview after selecting Exclude Zero Price Menu Item checkbox");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tax Summary') and contains(@class,'checkbox-checked')]")
	WebElement TaxSummary_Enabled;
	public void Click_TaxSummary() 
	{
		Tax_Summary.click();
		try{
			if(TaxSummary_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//h6[.='Tax Summary']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Tax Summary displayed when user enable the Tax Summary");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Tax Summary not displyed in template preview after selecting Tax Summary checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Tax_Summary.click();
			try {
				if(driver.findElement(By.xpath("//h6[.='Tax Summary']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Tax Summary displayed when user enable the Tax Summary");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Tax Summary not displyed in template preview after selecting Tax Summary checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	@FindBy(xpath = "//mat-checkbox[contains(.,'Check Total') and contains(@class,'checkbox-checked')]")
	WebElement CheckTotal_Enabled;
	public void Click_CheckTotal() 
	{
		Check_Total.click();
		try{
			if(CheckTotal_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[.='Check Total']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Check Total displayed when user enable the Check Total");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Check Total not displyed in template preview after selecting Check Total checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Check_Total.click();
			try {
				if(driver.findElement(By.xpath("//span[.='Check Total']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Check Total displayed when user enable the Check Total");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Check Total not displyed in template preview after selecting Check Total checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}	
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tip') and contains(@class,'checkbox-checked')]")
	WebElement Tip_Enabled;
	public void Click_Tip() 
	{
		Tip.click();
		try{
			if(Tip_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[.='Tip']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Tip displayed when user enable the Tip");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Tip not displyed in template preview after selecting Tip checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Tip.click();
			try {
				if(driver.findElement(By.xpath("//span[.='Tip']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Tip displayed when user enable the Tip");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Tip not displyed in template preview after selecting Tip checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tender Details') and contains(@class,'checkbox-checked')]")
	WebElement TenderDetails_Enabled;
	public void Click_Tender_Details() 
	{
		Tender_Details.click();
		try{
			if(TenderDetails_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[.='Cash Tendered']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Tender Details displayed when user enable the Tender Details");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Tender Details not displyed in template preview after selecting Tender Details checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Tender_Details.click();
			try {
				if(driver.findElement(By.xpath("//span[.='Cash Tendered']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Tender Details displayed when user enable the Tender Details");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Tender Details not displyed in template preview after selecting Tender Details checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	
	//Additional Settings
	public void Click_Additional_Details()
	{
		additional_Details.click();
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Include Card Details') and contains(@class,'checkbox-checked')]")
	WebElement IncludeCardDetails_Enabled;
	public void Click_Card_Details()
	{
		Card_Details.click();
		try{
			if(IncludeCardDetails_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//h6[.='Card Details']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Card Details displayed when user enable the Card Details");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Card Details not displyed in template preview after selecting Card Details checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Card_Details.click();
			try {
				if(driver.findElement(By.xpath("//h6[.='Card Details']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Card Details displayed when user enable the Card Details");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Card Details not displyed in template preview after selecting Card Details checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Signature') and contains(@class,'checkbox-checked')]")
	WebElement Signature_Enabled;
	public void Click_Signature() throws Exception 
	{
		for(int i=1;i<=6;i++)
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		signature.click();
		try{
			if(Signature_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//div[@class='new-template']/../div/div/div/div/div/img")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Signature displayed when user enable the Signature");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Signature not displyed in template preview after selecting Signature checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			signature.click();
			try {
				if(driver.findElement(By.xpath("//div[@class='new-template']/../div/div/div/div/div/img")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Signature displayed when user enable the Signature");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Signature not displyed in template preview after selecting Signature checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Barcode') and contains(@class,'checkbox-checked')]")
	WebElement Barcode_Enabled;
	public void Click_Barcode()
	{
		BarCode.click();
		try{
			if(Barcode_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//app-new-template/div/div/div/img")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Barcode displayed when user enable the Barcode");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Barcode not displyed in template preview after selecting Barcode checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			BarCode.click();
			try {
				if(driver.findElement(By.xpath("//app-new-template/div/div/div/img")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Barcode displayed when user enable the Barcode");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Barcode not displyed in template preview after selecting Barcode checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Powered by LINGA') and contains(@class,'checkbox-checked')]")
	WebElement PoweredByLinga_Enabled;
	public void Click_PoweredBy() throws Exception
	{
		for(int i=1;i<=4;i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Powered_By.click();
		try{
			if(PoweredByLinga_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[contains(.,'Powered by Linga rOS')]")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Powered by LINGA displayed when user enable the Powered by LINGA");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Powered by LINGA not displyed in template preview after selecting Powered by LINGA checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Powered_By.click();
			try {
				if(driver.findElement(By.xpath("//span[contains(.,'Powered by Linga rOS')]")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Powered by LINGA displayed when user enable the Powered by LINGA");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Powered by LINGA not displyed in template preview after selecting Powered by LINGA checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Social Icons') and contains(@class,'checkbox-checked')]")
	WebElement SocialIcons_Enabled;
	public void Click_Social_Icon() throws Exception 
	{
		for(int i=1;i<=4;i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		Social_Icon.click();
		
		try{
			if(SocialIcons_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//img[@class='thumbnail-image']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Social Icons displayed when user enable the Social Icons");
						Click_Facebook();
						Click_Twitter();
						Click_LinkedIn();
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Social Icons not displyed in template preview after selecting Social Icons checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Social_Icon.click();
			try {
				if(driver.findElement(By.xpath("//img[@class='thumbnail-image']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Social Icons displayed when user enable the Social Icons");
					Click_Facebook();
					Click_Twitter();
					Click_LinkedIn();
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Social Icons not displyed in template preview after selecting Social Icons checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Facebook Link') and contains(@class,'checkbox-checked')]")
	WebElement FaceBookLink_Enabled;
	public void Click_Facebook() throws Exception
	{
		Facebook.click();
		try{
			if(FaceBookLink_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[@class='fa-brands fa-square-facebook']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Facebook Link displayed when user enable the Facebook Link");

						Facebook_Text.clear();
						Thread.sleep(1000);
						Facebook_Text.sendKeys("www.Facebook.com");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Facebook Link not displyed in template preview after selecting Facebook Link checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Facebook.click();
			try {
				if(driver.findElement(By.xpath("//span[@class='fa-brands fa-square-facebook']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Facebook Link displayed when user enable the Facebook Link");

					Facebook_Text.clear();
					Thread.sleep(1000);
					Facebook_Text.sendKeys("www.Facebook.com");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Facebook Link not displyed in template preview after selecting Facebook Link checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
		
	}
	public void Enter_Facebook_URL() throws Exception
	{
		Facebook_Text.clear();
		Thread.sleep(1000);
		Facebook_Text.sendKeys("www.Facebook.com");
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Twitter Link') and contains(@class,'checkbox-checked')]")
	WebElement TwitterLink_Enabled;
	public void Click_Twitter() throws Exception 
	{
		Twitter.click();
		try{
			if(TwitterLink_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[@class='fa-brands fa-square-twitter']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Twitter Link displayed when user enable the Twitter Link");
						Twitter_Text.clear();
						Twitter_Text.sendKeys("www.Twitter.com");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Twitter Link not displyed in template preview after selecting Twitter Link checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Twitter.click();
			try {
				if(driver.findElement(By.xpath("//span[@class='fa-brands fa-square-twitter']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Twitter Link displayed when user enable the Twitter Link");
					Twitter_Text.clear();
					Twitter_Text.sendKeys("www.Twitter.com");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Twitter Link not displyed in template preview after selecting Twitter Link checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
		
	}
	public void Enter_Twitter_URL() 
	{
		Twitter_Text.clear();
		Twitter_Text.sendKeys("www.Twitter.com");
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Linkedin Link') and contains(@class,'checkbox-checked')]")
	WebElement LinkedinLink_Enabled;
	public void Click_LinkedIn() throws Exception
	{
		LinkedIn.click();
		try{
			if(LinkedinLink_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//span[@class='fa-brands fa-linkedin']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Linkedin Link displayed when user enable the Linkedin Link");
						LinkedIn_Text.clear();
						LinkedIn_Text.sendKeys("www.LinkeIn.com");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Linkedin Link not displyed in template preview after selecting Linkedin Link checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			LinkedIn.click();
			try {
				if(driver.findElement(By.xpath("//span[@class='fa-brands fa-linkedin']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Linkedin Link displayed when user enable the Linkedin Link");
					LinkedIn_Text.clear();
					LinkedIn_Text.sendKeys("www.LinkeIn.com");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Linkedin Link not displyed in template preview after selecting Linkedin Link checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
		
	}
	public void Enter_LinkedIn_URL() 
	{
		LinkedIn_Text.clear();
		LinkedIn_Text.sendKeys("www.LinkeIn.com");	
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Feedback') and contains(@class,'checkbox-checked')]")
	WebElement CustomerFeedback_Enabled;
	public void Click_Customer_Feedback() 
	{
		Customer_Feedback.click();
		try{
			if(CustomerFeedback_Enabled.isDisplayed()) {
				try {
					if(driver.findElement(By.xpath("//h6[.='How was your experience']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Customer Feedback displayed when user enable the Customer Feedback");
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Customer Feedback not displyed in template preview after selecting Customer Feedback checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Customer_Feedback.click();
			try {
				if(driver.findElement(By.xpath("//h6[.='How was your experience']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Customer Feedback displayed when user enable the Customer Feedback");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Customer Feedback not displyed in template preview after selecting Customer Feedback checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Special Notes') and contains(@class,'checkbox-checked')]")
	WebElement SpecialNotes_Enabled;
	public void Special_Note() throws Exception 
	{
		Special_Note.click();
		try{
			if(SpecialNotes_Enabled.isDisplayed()) {
				Special_Note_Text.clear();
				Thread.sleep(1000);
				Special_Note_Text.sendKeys("Have a nice day, Visit us again!");
				try {
					if(driver.findElement(By.xpath("//span[.='Have a nice day, Visit us again!']")).isDisplayed()) 
					{
						test.log(LogStatus.PASS, "Special Notes displayed when user enable the Special Notes");

						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				catch(Exception e1) {
					test.log(LogStatus.FAIL, "Special Notes not displyed in template preview after selecting Special Notes checkbox");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			}
		}catch(Exception e) {
			Special_Note.click();
			Special_Note_Text.clear();
			Thread.sleep(1000);
			Special_Note_Text.sendKeys("Have a nice day, Visit us again!");
			try {
				if(driver.findElement(By.xpath("//span[.='Have a nice day, Visit us again!']")).isDisplayed()) 
				{
					test.log(LogStatus.PASS, "Special Notes displayed when user enable the Special Notes");

					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception e1) {
				test.log(LogStatus.FAIL, "Special Notes not displyed in template preview after selecting Special Notes checkbox");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		
	
	}
	public void Clear_Special_Note()
	{
		Special_Note_Text.clear();
	}
	public void Enter_Special_Note() throws Exception 
	{
		Special_Note_Text.clear();
		Thread.sleep(1000);
		Special_Note_Text.sendKeys("Have a nice day, Visit us again!");
	}
	
	public void disabledAllOptions() throws Exception {
		
		Store_Inform.click();Thread.sleep(1000);
		try {
			if(StoreName_Enabled.isDisplayed()) {
				StoreName_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(Email_Enabled.isDisplayed()) {
				Email_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(PhoneNumber_Enabled.isDisplayed()) {
				PhoneNumber_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(Address_Enabled.isDisplayed()) {
				Address_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(StoreLogo_Enabled.isDisplayed()) {
				StoreLogo_Enabled.click();
			}
		}catch(Exception e) {}
		
		for(int i = 1;i<=8;i++) {driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);}
		Thread.sleep(1000);Check_Details.click();Thread.sleep(1000);
		try {
			if(CheckNumber_Enabled.isDisplayed()) {
				CheckNumber_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(SeatNumber_Enabled.isDisplayed()) {
				SeatNumber_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(TableNumber_Enabled.isDisplayed()) {
				TableNumber_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(ServerName_Enabled.isDisplayed()) {
				ServerName_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(DateAndTime_Enabled.isDisplayed()) {
				DateAndTime_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(CustomerName_Enabled.isDisplayed()) {
				CustomerName_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(ServiceType_Enabled.isDisplayed()) {
				ServiceType_Enabled.click();
			}
		}catch(Exception e) {}
		
		for(int i = 1;i<=5;i++) {driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);}
		Thread.sleep(1000);Order_Summary.click();Thread.sleep(1000);
		for(int i = 1;i<=8;i++) {driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);}
		
		try {
			if(OrderSummary_Enabled.isDisplayed()) {
				OrderSummary_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(RollOutModifierPriceToMenu_Enabled.isDisplayed()) {
				RollOutModifierPriceToMenu_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(ExcludeZeroPriceModifier_Enabled.isDisplayed()) {
				ExcludeZeroPriceModifier_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(DiscountUderTheMenuItem_Enabled.isDisplayed()) {
				DiscountUderTheMenuItem_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(SecondaryMenuName_Enabled.isDisplayed()) {
				SecondaryMenuName_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(SecndaryModifierName_Enabled.isDisplayed()) {
				SecndaryModifierName_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(ExcludeZeroPriceMenuItem_Enabled.isDisplayed()) {
				ExcludeZeroPriceMenuItem_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(TaxSummary_Enabled.isDisplayed()) {
				TaxSummary_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(CheckTotal_Enabled.isDisplayed()) {
				CheckTotal_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(Tip_Enabled.isDisplayed()) {
				Tip_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(TenderDetails_Enabled.isDisplayed()) {
				TenderDetails_Enabled.click();
			}
		}catch(Exception e) {}
		
		additional_Details.click();Thread.sleep(1000);
		for(int i = 1;i<=8;i++) {driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);}
		try {
			if(IncludeCardDetails_Enabled.isDisplayed()) {
				IncludeCardDetails_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(Signature_Enabled.isDisplayed()) {
				Signature_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(Barcode_Enabled.isDisplayed()) {
				Barcode_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(PoweredByLinga_Enabled.isDisplayed()) {
				PoweredByLinga_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(SocialIcons_Enabled.isDisplayed()) {
				SocialIcons_Enabled.click();
			}
		}catch(Exception e) {}
		
//		try {
//			if(FaceBookLink_Enabled.isDisplayed()) {
//				FaceBookLink_Enabled.click();
//			}
//		}catch(Exception e) {}
//		
//		try {
//			if(TwitterLink_Enabled.isDisplayed()) {
//				TwitterLink_Enabled.click();
//			}
//		}catch(Exception e) {}
//		
//		try {
//			if(LinkedinLink_Enabled.isDisplayed()) {
//				LinkedinLink_Enabled.click();
//			}
//		}catch(Exception e) {}
		
		try {
			if(CustomerFeedback_Enabled.isDisplayed()) {
				CustomerFeedback_Enabled.click();
			}
		}catch(Exception e) {}
		
		try {
			if(SpecialNotes_Enabled.isDisplayed()) {
				SpecialNotes_Enabled.click();
			}
		}catch(Exception e) {}
		
//		for(int i = 1;i<=30;i++) {driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);}
//		Store_Inform.click();Thread.sleep(1000);
//		Check_Details.click();Thread.sleep(1000);
//		Order_Summary.click();Thread.sleep(1000);
//		additional_Details.click();
	}
}

