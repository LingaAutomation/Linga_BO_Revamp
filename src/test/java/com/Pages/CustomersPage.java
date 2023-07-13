package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import Utility.Utility;

public class CustomersPage 
{
	public WebDriver driver;
	public ExtentTest test;
	
	Utility ut=new Utility();
	Common_XPaths cmp;
	ReportsPage repts;
	public CustomersPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'NEW HOUSE ACCOUNT')]")
	WebElement New_House_Account;
	
	@FindBy(xpath = "//button[contains(.,'NEW CUSTOMER')]")
	WebElement New_Customer;
	
	@FindBy(xpath = "//label[contains(.,'Select Customer')]/../../input")
	WebElement Select_Customer_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Balance')]/../../input")
	WebElement Balance_InputBx;
	
	@FindBy(xpath = "//div[contains(.,'Enable Period Limit')]/../../div[2]//mat-button-toggle[.='Yes']")
	WebElement Enable_Period_Limit_Yes_ToggleBtn;
	
	@FindBy(xpath = "//div[contains(.,'Enable Period Limit')]/../../div[2]//mat-button-toggle[.='No']")
	WebElement Enable_Period_Limit_No_ToggleBtn;
	
	@FindBy(xpath = "//label[contains(.,'Limit Period')]/../../input")
	WebElement Limit_Period_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Limit Amount')]/../../input")
	WebElement Limit_Amount_InputBx;
	
	@FindBy(xpath = "//div[contains(.,'Allow Credit')]/../../div[2]//mat-button-toggle[.='Yes']")
	WebElement Allow_Credit_Yes_ToggleBtn;
	
	@FindBy(xpath = "//div[contains(.,'Allow Credit')]/../../div[2]//mat-button-toggle[.='No']")
	WebElement Allow_Credit_No_ToggleBtn;
	
	@FindBy(xpath = "//div[contains(.,'Enable Max Limit')]/../../div[2]//mat-button-toggle[.='Yes']")
	WebElement Enable_Max_Limit_Yes_ToggleBtn;
	
	@FindBy(xpath = "//div[contains(.,'Enable Max Limit')]/../../div[2]//mat-button-toggle[.='No']")
	WebElement Enable_Max_Limit_No_ToggleBtn;
	
	@FindBy(xpath = "//label[contains(.,'Max Amount Limit')]/../../input")
	WebElement Max_Amount_Limit_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Select Day')]/../../input")
	WebElement Select_Day_InputBx;
	
	public void Click_New_House_Account()
	{
		new Common_XPaths(driver, test).Click_Button(New_House_Account, "New House Account button Clicked");
	}
	
	public void Click_New_Customer()
	{
		new Common_XPaths(driver, test).Click_Button(New_Customer, "New Customer button Clicked");
	}
	
	public void Select_Customer_withName(String CustomerName) throws Exception
	{
		new Common_XPaths(driver, test).Click_DropDown_withSearchText(Select_Customer_InputBx, CustomerName, "Customer Selected");
	}
	
	public void Select_Customer() throws Exception
	{
		new Common_XPaths(driver, test).Click_DropDown_withSearch(Select_Customer_InputBx, "Random Customer Selected");
	}
	
	
	public void Enter_Balance(String Balance) throws Exception
	{
		new Common_XPaths(driver, test).Enter_Text(Balance_InputBx, Balance, "Balance Entered");
	}
	
	public void Enable_Period_LimitToggle()
	{
		new Common_XPaths(driver, test).Enable_Toggle(Enable_Period_Limit_Yes_ToggleBtn, "Enable Period Limit Toggle Enabled");
	}
	
	public void Disable_Period_LimitToggle()
	{
		new Common_XPaths(driver, test).Disable_Toggle(Enable_Period_Limit_Yes_ToggleBtn, Enable_Period_Limit_No_ToggleBtn, "Enable Period Limit Toggle Disabled");
	}
	
	public void Select_Limit_Period(String LimitPeriod) throws Exception
	{
		new Common_XPaths(driver, test).Click_DropDown_withSelection(Limit_Period_InputBx, LimitPeriod, LimitPeriod+" Limit Period Selected");
	}
	
	public void Select_Day() throws Exception
	{
		new Common_XPaths(driver, test).Click_DropDown(Select_Customer_InputBx, "Day Selected");
	}
	
	public void Enter_Limit_Amount(String LimitAmount) throws Exception
	{
		new Common_XPaths(driver, test).Enter_Text(Limit_Amount_InputBx, LimitAmount, "Limit Amount Entered");
	}
	
	public void Enable_Allow_CreditToggle()
	{
		new Common_XPaths(driver, test).Enable_Toggle(Allow_Credit_Yes_ToggleBtn, "Allow Credit Toggle Enabled");
	}
	
	public void Disable_Allow_CreditToggle()
	{
		new Common_XPaths(driver, test).Disable_Toggle(Allow_Credit_Yes_ToggleBtn, Allow_Credit_No_ToggleBtn, "Allow Credit Toggle Disabled");
	}
	
	public void Enable_Max_LimitToggle()
	{
		new Common_XPaths(driver, test).Enable_Toggle(Enable_Max_Limit_Yes_ToggleBtn, "Enable Max Limit Toggle Enabled");
	}
	
	public void Disable_Max_LimitToggle()
	{
		new Common_XPaths(driver, test).Disable_Toggle(Enable_Max_Limit_Yes_ToggleBtn, Enable_Max_Limit_No_ToggleBtn, "Enable Max Limit Toggle Disabled");
	}
	
	public void Enter_Max_Limit_Amount(String MaxLimitAmount) throws Exception
	{
		new Common_XPaths(driver, test).Enter_Text(Max_Amount_Limit_InputBx, MaxLimitAmount, "Max Limit Amount Entered");
	}
	
	public WebElement Balance_InputBox()
	{
		return Balance_InputBx;
	}
	
	public WebElement Limit_Amount_InputBox()
	{
		return Limit_Amount_InputBx;
	}
	
	public WebElement Max_Amount_Limit_InputBox()
	{
		return Max_Amount_Limit_InputBx;
	}
	
	public WebElement Enable_Period_Limit_Yes_Toggle()
	{
		return Enable_Period_Limit_Yes_ToggleBtn;
	}
	
	public WebElement Allow_Credit_Yes_Toggle()
	{
		return Allow_Credit_Yes_ToggleBtn;
	}
	
	public WebElement Enable_Max_Limit_Yes_Toggle()
	{
		return Enable_Max_Limit_Yes_ToggleBtn;
	}
	
	public WebElement Limit_Period_InputBox()
	{
		return Limit_Period_InputBx;
	}
}
