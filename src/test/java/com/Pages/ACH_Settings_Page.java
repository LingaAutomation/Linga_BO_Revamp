package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class ACH_Settings_Page //extends BasePage 
{
	public WebDriver driver;
	ExtentTest test;
	
	
	public ACH_Settings_Page(WebDriver driver, ExtentTest test)
	{
//		super(driver, test);
//		// TODO Auto-generated constructor stub
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//app-input[contains(@label,'Destination Name')]//input")
	WebElement Destination_Name;
	
	public WebElement Destination_Name()
	{
		return Destination_Name;
	}
	
	@FindBy(xpath = "//p[contains(.,'Destination Name is required')]")
	WebElement Destination_Name_Error_msg;
	
	public WebElement Destination_Name_Error_msg()
	{
		return Destination_Name_Error_msg;
	}
	
	@FindBy(xpath = "//p[contains(.,'Destination Name should not be more than 50')]")
	WebElement Destination_Name_char_50_Error_msg;
	
	public WebElement Destination_Name_char_50_Error_msg()
	{
		return Destination_Name_char_50_Error_msg;
	}
	
	
	
	
	@FindBy(xpath = "//app-input[contains(@label,'Destination Routing Number')]//input")
	WebElement Destination_Routing_Number;
	
	public WebElement Destination_Routing_Number()
	{
		return Destination_Routing_Number;
	}
	
	@FindBy(xpath = "//p[contains(.,'Destination Routing Number is required')]")
	WebElement Destination_Routing_Number_error_message;
	
	public WebElement Destination_Routing_Number_error_message()
	{
		return Destination_Routing_Number_error_message;
	}
	
	@FindBy(xpath = "//p[contains(.,'Destination Routing Number should not be more than 9')]")
	WebElement Destination_Routing_Number_error_message2;
	
	public WebElement Destination_Routing_Number_error_message2()
	{
		return Destination_Routing_Number_error_message2;
	}
	
	
	
	@FindBy(xpath = "//app-input[contains(@label,'Immediate Origin Name')]//input")
	WebElement Immediate_Origin_Name;
	
	public WebElement Immediate_Origin_Name()
	{
		return Immediate_Origin_Name;
	}
	
	
	
	@FindBy(xpath = "//p[contains(.,'Immediate Origin Name is required')]")
	WebElement Immediate_Origin_Name_Error_message;
	
	public WebElement Immediate_Origin_Name_Error_message()
	{
		return Immediate_Origin_Name_Error_message;
	}
	
	
	@FindBy(xpath = "//p[contains(.,'Immediate Origin Name should not be more than 50')]")
	WebElement Immediate_Origin_char_50_Error_msg;
	
	public WebElement Immediate_Origin_char_50_Error_msg()
	{
		return Immediate_Origin_char_50_Error_msg;
	}
	
	
	
	@FindBy(xpath = "//app-input[contains(@label,'Immediate Origin Number')]//input")
	WebElement Immediate_Origin_Number;
	
	public WebElement Immediate_Origin_Number()
	{
		return Immediate_Origin_Number;
	}
	
	
	
	@FindBy(xpath = "//p[contains(.,'Immediate Origin Number is required')]")
	WebElement Immediate_Origin_Number_Error_message;
	
	public WebElement Immediate_Origin_Number_Error_message()
	{
		return Immediate_Origin_Number_Error_message;
	}
	
	
	@FindBy(xpath = "//p[contains(.,'Immediate Origin Number should not be more than 9')]")
	WebElement Immediate_Origin_Number_Error_msg2;
	
	public WebElement Immediate_Origin_Number_Error_msg2()
	{
		return Immediate_Origin_Number_Error_msg2;
	}
	
	

	
	@FindBy(xpath = "//app-input[contains(@label,'Company Name')]//input")
	WebElement Company_Name;
	
	public WebElement Company_Name()
	{
		return Company_Name;
	}
	
	
	
	@FindBy(xpath = "//p[contains(.,'Company Name is required')]")
	WebElement Company_Name_Error_message;
	
	public WebElement Company_Name_Error_message()
	{
		return Company_Name_Error_message;
	}
	
	
	@FindBy(xpath = "//p[contains(.,'Company Entry Description should not be more than 25')]")
	WebElement Company_Name_Error_msg2;
	
	public WebElement Company_Name_Error_msg2()
	{
		return Company_Name_Error_msg2;
	}
	
	

	
	
	
	
	@FindBy(xpath = "//app-input[contains(@label,'Company Entry Description')]//input")
	WebElement Company_Entry_Description;
	
	public WebElement Company_Entry_Description()
	{
		return Company_Entry_Description;
	}
	
	
	
	@FindBy(xpath = "//p[contains(.,'Company Name is required')]")
	WebElement Company_Entry_Description_Error_message;
	
	public WebElement Company_Entry_Description_Error_message()
	{
		return Company_Entry_Description_Error_message;
	}
	
	
	@FindBy(xpath = "//p[contains(.,'Company Entry Description should not be more than 25')]")
	WebElement Company_Entry_Description_Error_msg2;
	
	public WebElement Company_Entry_Description_Error_msg2()
	{
		return Company_Entry_Description_Error_msg2;
	}
	
	@FindBy(xpath = "//app-input[contains(@label,'Company Discretionary Data')]//input")
	WebElement Company_Discretionary_Data_Description;
	
	public WebElement Company_Discretionary_Data_Description()
	{
		return Company_Discretionary_Data_Description;
	}
	
	
	

	
	@FindBy(xpath = "//p[contains(.,'Company Discretionary Data should not be more than 100')]")
	WebElement Company_Discretionary_Data_Error_msg2;
	
	public WebElement Company_Discretionary_Data_Error_msg2()
	{
		return Company_Discretionary_Data_Error_msg2;
	}
	
	

	
	@FindBy(xpath = "//app-input[contains(@label,'Company ID Number')]//input")
	WebElement Company_ID_Number;
	
	public WebElement Company_ID_Number()
	{
		return Company_ID_Number;
	}
	
	
	
	@FindBy(xpath = "//p[contains(.,'Company Identification Number is required')]")
	WebElement Company_ID_Number_Error_message;
	
	public WebElement Company_ID_Number_Error_message()
	{
		return Company_ID_Number_Error_message;
	}
	
	
	@FindBy(xpath = "//p[contains(.,'Company Identification Number should not be more than 10')]")
	WebElement Company_ID_Number_Error_msg2;
	
	public WebElement Company_ID_Number_Error_msg2()
	{
		return Company_ID_Number_Error_msg2;
	}
	

	
	
	@FindBy(xpath = "//app-input[contains(@label,'Originating DFI Number')]//input")
	WebElement Originating_DFI_Number;
	
	public WebElement Originating_DFI_Number()
	{
		return Originating_DFI_Number;
	}
	
	
	
	@FindBy(xpath = "//p[contains(.,'Originating DFI Identification is required')]")
	WebElement Originating_DFI_Number_Error_message;
	
	public WebElement Originating_DFI_Number_Error_message()
	{
		return Company_ID_Number_Error_message;
	}
	
	
	@FindBy(xpath = "//p[contains(.,'Originating DFI Identification should not be more than 8')]")
	WebElement Originating_DFI_Number_Error_msg2;
	
	public WebElement Originating_DFI_Number_Error_msg2()
	{
		return Originating_DFI_Number_Error_msg2;
	}
	
	
	
	
	
	
}
