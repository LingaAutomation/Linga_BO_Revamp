package com.Pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Label_TemplatePage extends BasePage
{

//	public SelfHealingDriver driver;
//	public ExtentTest test;
	Utility ut=new Utility();
	Common_XPaths cmp;
	
	TaxesPage tx;
	public Label_TemplatePage(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		super(driver,test);
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//button[contains(.,'Epson Box Label Template')]")
	WebElement EpsonBox_LabelTemplateTab;
	
	public void Click_EpsonBox_LabelTemplate()
	{
		EpsonBox_LabelTemplateTab.click();
	}
	
	@FindBy(xpath = "//button[contains(.,'Zebra Box Label Template')]")
	WebElement Zebra_LabelTemplateTab;
	
	public void Click_Zebra_LabelTemplate()
	{
		Zebra_LabelTemplateTab.click();
	}
	
	@FindBy(xpath = "//button[contains(.,'Kitchen Box Label Template')]")
	WebElement Kitchen_LabelTemplateTab;
	
	public void Click_Kitchen_LabelTemplate()
	{
		Kitchen_LabelTemplateTab.click();
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Enable Autocut')]")
	WebElement Enable_Autocut_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Enable Autocut')][contains(@class,'mat-checkbox-checked')]")
	WebElement Enable_Autocut_ChkBox_SLD;
	
	public WebElement Enable_Autocut_CheckBox()
	{
		return Enable_Autocut_ChkBox;
	}
	
	public WebElement Enable_Autocut_CheckBox_SLD()
	{
		return Enable_Autocut_ChkBox_SLD;
	}
	public void Select_Enable_Autocut_CheckBox()
	{
		try
		{
			if(Enable_Autocut_ChkBox_SLD.isDisplayed())
			{
				
			}
		}
		catch(Exception l)
		{
			Enable_Autocut_ChkBox.click();
		}
	}
	
	public void UnSelect_Enable_Autocut_CheckBox()
	{
		try
		{
		if(Enable_Autocut_ChkBox_SLD.isDisplayed())
		{
			Enable_Autocut_ChkBox.click();
		}
		}
		catch(Exception l)
		{
		
		}
	}
	
	@FindBy(xpath = "//label[contains(.,'Select template')]/../../input")
	WebElement Select_TemplateInputBox;
	
	public String Selected_TemplateName()
	{
		return Select_TemplateInputBox.getAttribute("value");
	}
	
	public void Select_Templates()
	{
		Select_TemplateInputBox.click();
		
		
	List<WebElement> TemplateList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int TemplateSize=TemplateList.size();
		
		
		int randomTemplate=ThreadLocalRandom.current().nextInt(1, TemplateSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomTemplate+"]/select-option")).click();
	
	}
	
	@FindBy(xpath = "//label[contains(.,'Width')]/../../input")
	WebElement Width_InputBox;
	
	public WebElement Width_InputBox()
	{
		return Width_InputBox;
	}
	
	public void Enter_Width(String str)
	{
		Width_InputBox.clear();
		
		Width_InputBox.sendKeys(str);
	}
	
	@FindBy(xpath = "//label[contains(.,'Height')]/../../input")
	WebElement Height_InputBox;
	
	public WebElement Height_InputBox()
	{
		return Height_InputBox;
	}
	
	public void Enter_Height(String str)
	{
		Height_InputBox.clear();
		
		Height_InputBox.sendKeys(str);
	}
	
	
	@FindBy(xpath = "//div[.='Font Options']/../../div[contains(.,'keyboard_arrow_right')]")
	WebElement FontOptions_ArrowRightBtn;
	

	
	@FindBy(xpath = "//div[.='Font Options']/../../div[contains(.,'keyboard_arrow_down')]")
	WebElement FontOptions_ArrowDownBtn;
	
	public void Open_FontOptions_Screen() throws Exception
	{
		try
		{
		if(FontOptions_ArrowRightBtn.isDisplayed())
		{
			FontOptions_ArrowRightBtn.click();

		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	public void Close_FontOptions_Screen() throws Exception
	{
//		try
//		{
		if(FontOptions_ArrowDownBtn.isDisplayed())
		{
			FontOptions_ArrowDownBtn.click();
		}
		else
		{
			
		}
	}
	
	@FindBy(xpath = "//label[contains(.,'Check & Date')]/../../input")
	WebElement Check_Date_InputBox;
	
	public void Select_Check_Date_Option()
	{
		Check_Date_InputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement Check_And_Date_Option()
	{
		return Check_Date_InputBox;
	}
	
	@FindBy(xpath = "//label[contains(.,'Business Name')]/../../input")
	WebElement Business_Name_InputBox;
	
	public void Select_Business_Name_Option()
	{
		Business_Name_InputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement Business_Name_Option()
	{
		return Business_Name_InputBox;
	}
	
	@FindBy(xpath = "//label[contains(.,'Menu Item Name')]/../../input")
	WebElement Menu_ItemName_InputBox;
	
	public void Select_MenuItem_Name_Option()
	{
		Menu_ItemName_InputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement Menu_ItemName_Option()
	{
		return Menu_ItemName_InputBox;
	}
	
	@FindBy(xpath = "//label[contains(.,'Customer Address & Phone')]/../../input")
	WebElement Customer_Address_Phone_InputBox;
	
	public void Select_Customer_Address_Phone_Option()
	{
		Customer_Address_Phone_InputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement Customer_Address_Phone_Option()
	{
		return Customer_Address_Phone_InputBox;
	}
	
	@FindBy(xpath = "//label[contains(.,'Delivery Notes')]/../../input")
	WebElement Delivery_Notes_InputBox;
	
	public void Select_Delivery_Notes_Option()
	{
		Delivery_Notes_InputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement Delivery_Notes_Option()
	{
		return Delivery_Notes_InputBox;
	}
	
	@FindBy(xpath = "//label[contains(.,'Modifiers')]/../../input")
	WebElement Modifiers_InputBox;
	
	public void Select_Modifiers_Option()
	{
		Modifiers_InputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement Modifiers_Option()
	{
		return Modifiers_InputBox;
	}
	
	@FindBy(xpath = "//label[contains(.,'Customer Info')]/../../input")
	WebElement CustomerInfo_EpsonBox_InputBox;
	
	public void Select_CustomerInfo_EpsonBox_Option()
	{
		CustomerInfo_EpsonBox_InputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement CustomerInfo_EpsonBox()
	{
		return CustomerInfo_EpsonBox_InputBox;
	}
	
	@FindBy(xpath = "//div[.='Check Details']/../../div[contains(.,'keyboard_arrow_right')]")
	WebElement CheckDetails_ArrowRightBtn;
	
	@FindBy(xpath = "//div[.='Check Details']/../../div[contains(.,'keyboard_arrow_down')]")
	WebElement CheckDetails_ArrowDownBtn;
	
	public void Open_CheckDetails_Screen() throws Exception
	{
		try
		{
		if(CheckDetails_ArrowRightBtn.isDisplayed())
		{
			CheckDetails_ArrowRightBtn.click();
		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	public void Close_CheckDetails_Screen() throws Exception
	{
		try
		{
		if(CheckDetails_ArrowDownBtn.isDisplayed())
		{
			CheckDetails_ArrowDownBtn.click();

		}
		}
		catch(Exception g)
		{
			
		}
	}


	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Business Name')]")
	WebElement Business_Name_CheckDetails_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Business Name')][contains(@class,'mat-checkbox-checked')]")
	WebElement Business_Name_CheckDetails_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Business Name')][contains(@class,'ng-untouched')]")
	WebElement Business_Name_CheckDetails_ChkBox_SLD1;
	
	
	public WebElement Business_Name_CheckDetails_CheckBox()
	{
		return Business_Name_CheckDetails_ChkBox;
	}
	
	public WebElement Business_Name_CheckDetails_CheckBox_SLD()
	{
		return Business_Name_CheckDetails_ChkBox_SLD;
	}
	
	public WebElement Business_Name_CheckDetails_CheckBox_SLD1()
	{
		return Business_Name_CheckDetails_ChkBox_SLD1;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Server Name')]")
	WebElement Server_Name_CheckDetails_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Server Name')][contains(@class,'mat-checkbox-checked')]")
	WebElement Server_Name_CheckDetails_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Server Name')][contains(@class,'ng-untouched')]")
	WebElement Server_Name_CheckDetails_ChkBox_SLD1;
	
	
	public WebElement Server_Name_CheckDetails_CheckBox()
	{
		return Server_Name_CheckDetails_ChkBox;
	}

	public WebElement Server_Name_CheckDetails_CheckBox_SLD()
	{
		return Server_Name_CheckDetails_ChkBox_SLD;
	}
	
	public WebElement Server_Name_CheckDetails_CheckBox_SLD1()
	{
		return Server_Name_CheckDetails_ChkBox_SLD1;
	}

	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Check Number')]")
	WebElement Check_Number_CheckDetails_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Check Number')][contains(@class,'mat-checkbox-checked')]")
	WebElement Check_Number_CheckDetails_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Check Number')][contains(@class,'ng-untouched')]")
	WebElement Check_Number_CheckDetails_ChkBox_SLD1;
	
	
	public WebElement Check_Number_CheckDetails_CheckBox()
	{
		return Check_Number_CheckDetails_ChkBox;
	}

	public WebElement Check_Number_CheckDetails_CheckBox_SLD()
	{
		return Check_Number_CheckDetails_ChkBox_SLD;
	}
	
	public WebElement Check_Number_CheckDetails_CheckBox_SLD1()
	{
		return Check_Number_CheckDetails_ChkBox_SLD1;
	}

	
	@FindBy(xpath = "//mat-expansion-panel-header[contains(.,'Check Details')]/../div/div/div/div/div[2]/div/app-checkbox/div/mat-checkbox[contains(.,'Order Type')]")
	WebElement Order_Type_CheckDetails_ChkBox;
	
	@FindBy(xpath = "//mat-expansion-panel-header[contains(.,'Check Details')]/../div/div/div/div/div[2]/div/app-checkbox/div/mat-checkbox[contains(.,'Order Type')][contains(@class,'mat-checkbox-checked')]")
	WebElement Order_Type_CheckDetails_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-expansion-panel-header[contains(.,'Check Details')]/../div/div/div/div/div[2]/div/app-checkbox/div/mat-checkbox[contains(.,'Order Type')][contains(@class,'ng-untouched')]")
	WebElement Order_Type_CheckDetails_ChkBox_SLD1;
	
	public WebElement Order_Type_CheckDetails_CheckBox()
	{
		return Order_Type_CheckDetails_ChkBox;
	}

	public WebElement Order_Type_CheckDetails_CheckBox_SLD()
	{
		return Order_Type_CheckDetails_ChkBox_SLD;
	}
	
	public WebElement Order_Type_CheckDetails_CheckBox_SLD1()
	{
		return Order_Type_CheckDetails_ChkBox_SLD1;
	}

	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Date & Time')]")
	WebElement Date_Time_CheckDetails_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Date & Time')][contains(@class,'mat-checkbox-checked')]")
	WebElement Date_Time_CheckDetails_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Date & Time')][contains(@class,'ng-untouched')]")
	WebElement Date_Time_CheckDetails_ChkBox_SLD1;
	
	public WebElement Date_Time_CheckDetails_CheckBox()
	{
		return Date_Time_CheckDetails_ChkBox;
	}
	
	public WebElement Date_Time_CheckDetails_CheckBox_SLD()
	{
		return Date_Time_CheckDetails_ChkBox_SLD;
	}
	
	public WebElement Date_Time_CheckDetails_CheckBox_SLD1()
	{
		return Date_Time_CheckDetails_ChkBox_SLD1;
	}
	
	
	@FindBy(xpath = "//mat-expansion-panel-header[contains(.,'Check Details')]/../div/div/div/div/div[2]/div/app-checkbox/div/mat-checkbox[contains(.,'Pay Status')]")
	WebElement PayStatus_CheckDetails_ChkBox;
	
	@FindBy(xpath = "//mat-expansion-panel-header[contains(.,'Check Details')]/../div/div/div/div/div[2]/div/app-checkbox/div/mat-checkbox[contains(.,'Pay Status')][contains(@class,'mat-checkbox-checked')]")
	WebElement PayStatus_CheckDetails_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-expansion-panel-header[contains(.,'Check Details')]/../div/div/div/div/div[2]/div/app-checkbox/div/mat-checkbox[contains(.,'Pay Status')][contains(@class,'ng-untouched')]")
	WebElement PayStatus_CheckDetails_ChkBox_SLD1;
	
	public WebElement PayStatus_CheckDetails_CheckBox()
	{
		return PayStatus_CheckDetails_ChkBox;
	}

	public WebElement PayStatus_CheckDetails_CheckBox_SLD()
	{
		return PayStatus_CheckDetails_ChkBox_SLD;
	}
	
	public WebElement PayStatus_CheckDetails_CheckBox_SLD1()
	{
		return PayStatus_CheckDetails_ChkBox_SLD1;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Menu Item Number')]")
	WebElement MenuItem_Number_CheckDetails_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Menu Item Number')][contains(@class,'mat-checkbox-checked')]")
	WebElement MenuItem_Number_CheckDetails_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Menu Item Number')][contains(@class,'ng-untouched')]")
	WebElement MenuItem_Number_CheckDetails_ChkBox_SLD1;

	public WebElement MenuItem_Number_CheckDetails_CheckBox()
	{
		return MenuItem_Number_CheckDetails_ChkBox;
	}
	
	public WebElement MenuItem_Number_CheckDetails_CheckBox_SLD()
	{
		return MenuItem_Number_CheckDetails_ChkBox_SLD;
	}
	
	public WebElement MenuItem_Number_CheckDetails_CheckBox_SLD1()
	{
		return MenuItem_Number_CheckDetails_ChkBox_SLD1;
	}
	
	
	@FindBy(xpath = "//label[contains(.,'Business Name Font')]/../../input")
	WebElement BusinessName_Zebra_Font_InputBox;
	
	public void Select_BusinessName_Zebra_Font_Option()
	{
		BusinessName_Zebra_Font_InputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement BusinessName_Zebra_Font_Option()
	{
		return BusinessName_Zebra_Font_InputBox;
	}
	
	
	@FindBy(xpath = "//label[contains(.,'Check Details')]/../../input")
	WebElement CheckDetails_Font_InputBox;
	
	public void Select_CheckDetails_Font_Option()
	{
		CheckDetails_Font_InputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement CheckDetails_Font_Option()
	{
		return CheckDetails_Font_InputBox;
	}
	
	@FindBy(xpath = "//label[contains(.,'Order Type & Pay Status')]/../../input")
	WebElement OrderType_PayStatus_InputBox;
	
	public void Select_OrderType_PayStatus_Font_Option()
	{
		OrderType_PayStatus_InputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement OrderType_PayStatus_Font_Option()
	{
		return OrderType_PayStatus_InputBox;
	}
	
	@FindBy(xpath = "//div[contains(.,'Dash Dividers')]/div/div/app-checkbox/div/mat-checkbox[contains(.,'Check Details')]")
	WebElement CheckDetails_CheckDetails_ChkBox;
	
	@FindBy(xpath = "//div[contains(.,'Dash Dividers')]/div/div/app-checkbox/div/mat-checkbox[contains(.,'Check Details')][contains(@class,'mat-checkbox-checked')]")
	WebElement CheckDetails_CheckDetails_ChkBox_SLD;
	
	@FindBy(xpath = "//div[contains(.,'Dash Dividers')]/div/div/app-checkbox/div/mat-checkbox[contains(.,'Check Details')][contains(@class,'ng-untouched')]")
	WebElement CheckDetails_CheckDetails_ChkBox_SLD1;
	
	public WebElement CheckDetails_CheckDetails_CheckBox()
	{
		return CheckDetails_CheckDetails_ChkBox;
	}
	
	public WebElement CheckDetails_CheckDetails_CheckBox_SLD()
	{
		return CheckDetails_CheckDetails_ChkBox_SLD;
	}
	
	public WebElement CheckDetails_CheckDetails_CheckBox_SLD1()
	{
		return CheckDetails_CheckDetails_ChkBox_SLD1;
	}
	
	@FindBy(xpath = "//div[contains(.,'Dash Dividers')]/div/div/app-checkbox/div/mat-checkbox[contains(.,'Order Type & Pay Status')]")
	WebElement OrderType_PayStatus_CheckDetails_ChkBox;
	
	@FindBy(xpath = "//div[contains(.,'Dash Dividers')]/div/div/app-checkbox/div/mat-checkbox[contains(.,'Order Type & Pay Status')]")
	WebElement OrderType_PayStatus_CheckDetails_ChkBox_SLD;
	
	@FindBy(xpath = "//div[contains(.,'Dash Dividers')]/div/div/app-checkbox/div/mat-checkbox[contains(.,'Order Type & Pay Status')][contains(@class,'ng-untouched')]")
	WebElement OrderType_PayStatus_CheckDetails_ChkBox_SLD1;
	
	public WebElement OrderType_PayStatus_CheckDetails_CheckBox()
	{
		return OrderType_PayStatus_CheckDetails_ChkBox;
	}

	public WebElement OrderType_PayStatus_CheckDetails_CheckBox_SLD()
	{
		return OrderType_PayStatus_CheckDetails_ChkBox_SLD;
	}
	
	public WebElement OrderType_PayStatus_CheckDetails_CheckBox_SLD1()
	{
		return OrderType_PayStatus_CheckDetails_ChkBox_SLD1;
	}
	
	
	@FindBy(xpath = "//div[.='Menu Item Info']/../../div[contains(.,'keyboard_arrow_right')]")
	WebElement MenuItem_Info_ArrowRightBtn;
	
	@FindBy(xpath = "//div[.='Menu Item Info']/../../div[contains(.,'keyboard_arrow_down')]")
	WebElement MenuItem_Info_ArrowDownBtn;
	
	public void Open_MenuItem_Info_Screen() throws Exception
	{
		try
		{
		if(MenuItem_Info_ArrowRightBtn.isDisplayed())
		{
			MenuItem_Info_ArrowRightBtn.click();
		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	public void Close_MenuItem_Info_Screen() throws Exception
	{
		try
		{
		if(MenuItem_Info_ArrowDownBtn.isDisplayed())
		{
			MenuItem_Info_ArrowDownBtn.click();
		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Menu Item Name')]")
	WebElement MenuItem_Name_MenuItemInfo_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Menu Item Name')][contains(@class,'mat-checkbox-checked')]")
	WebElement MenuItem_Name_MenuItemInfo_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Menu Item Name')][contains(@class,'ng-untouched')]")
	WebElement MenuItem_Name_MenuItemInfo_ChkBox_SLD1;
	
	
	public WebElement MenuItem_Name_MenuItemInfo_CheckBox()
	{
		return MenuItem_Name_MenuItemInfo_ChkBox;
	}
	
	public WebElement MenuItem_Name_MenuItemInfo_CheckBox_SLD()
	{
		return MenuItem_Name_MenuItemInfo_ChkBox_SLD;
	}
	
	public WebElement MenuItem_Name_MenuItemInfo_CheckBox_SLD1()
	{
		return MenuItem_Name_MenuItemInfo_ChkBox_SLD1;
	}
	
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Modifiers')]")
	WebElement Modifiers_MenuItemInfo_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Modifiers')][contains(@class,'mat-checkbox-checked')]")
	WebElement Modifiers_MenuItemInfo_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Modifiers')][contains(@class,'ng-untouched')]")
	WebElement Modifiers_MenuItemInfo_ChkBox_SLD1;
	
	
	public WebElement Modifiers_MenuItemInfo_CheckBox()
	{
		return Modifiers_MenuItemInfo_ChkBox;
	}
	
	public WebElement Modifiers_MenuItemInfo_CheckBox_SLD()
	{
		return Modifiers_MenuItemInfo_ChkBox_SLD;
	}
	
	public WebElement Modifiers_MenuItemInfo_CheckBox_SLD1()
	{
		return Modifiers_MenuItemInfo_ChkBox_SLD1;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Menu Item Serving Size')]")
	WebElement MenuItem_ServingSize_MenuItemInfo_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Menu Item Serving Size')][contains(@class,'mat-checkbox-checked')]")
	WebElement MenuItem_ServingSize_MenuItemInfo_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Menu Item Serving Size')][contains(@class,'ng-untouched')]")
	WebElement MenuItem_ServingSize_MenuItemInfo_ChkBox_SLD1;
	
	
	public WebElement MenuItem_ServingSize_MenuItemInfo_CheckBox()
	{
		return MenuItem_ServingSize_MenuItemInfo_ChkBox;
	}
	
	public WebElement MenuItem_ServingSize_MenuItemInfo_CheckBox_SLD()
	{
		return MenuItem_ServingSize_MenuItemInfo_ChkBox_SLD;
	}
	
	public WebElement MenuItem_ServingSize_MenuItemInfo_CheckBox_SLD1()
	{
		return MenuItem_ServingSize_MenuItemInfo_ChkBox_SLD1;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Item Notes')]")
	WebElement ItemNotes_MenuItemInfo_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Item Notes')][contains(@class,'mat-checkbox-checked')]")
	WebElement ItemNotes_MenuItemInfo_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Item Notes')][contains(@class,'ng-untouched')]")
	WebElement ItemNotes_MenuItemInfo_ChkBox_SLD1;
	
	
	public WebElement ItemNotes_MenuItemInfo_CheckBox()
	{
		return ItemNotes_MenuItemInfo_ChkBox;
	}
	
	public WebElement ItemNotes_MenuItemInfo_CheckBox_SLD()
	{
		return ItemNotes_MenuItemInfo_ChkBox_SLD;
	}
	
	public WebElement ItemNotes_MenuItemInfo_CheckBox_SLD1()
	{
		return ItemNotes_MenuItemInfo_ChkBox_SLD1;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Bottom Divider')]")
	WebElement BottomDivider_MenuItemInfo_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Bottom Divider')][contains(@class,'mat-checkbox-checked')]")
	WebElement BottomDivider_MenuItemInfo_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Bottom Divider')][contains(@class,'ng-untouched')]")
	WebElement BottomDivider_MenuItemInfo_ChkBox_SLD1;
	
	public WebElement BottomDivider_MenuItemInfo_CheckBox()
	{
		return BottomDivider_MenuItemInfo_ChkBox;
	}
	
	public WebElement BottomDivider_MenuItemInfo_CheckBox_SLD()
	{
		return BottomDivider_MenuItemInfo_ChkBox_SLD;
	}
	
	public WebElement BottomDivider_MenuItemInfo_CheckBox_SLD1()
	{
		return BottomDivider_MenuItemInfo_ChkBox_SLD1;
	}
	
	public void Verify_Selected_Fonts_and_Text(WebElement web,String str)
	{
		String AtrTxt=web.getAttribute("value");
		
		if(AtrTxt.equalsIgnoreCase(str))
		{
			test.log(LogStatus.PASS, str+" Selected");
		} 
		else
		{
			test.log(LogStatus.PASS, str+" Not Selected. Selected is : "+AtrTxt);
		}
	}
	
	
	@FindBy(xpath = "//label[contains(.,'Item Name & Serving Size')]/../../input")
	WebElement ItemName_ServingSize_MenuItemInfoInputBox;
	

	public void Select_ItemName_ServingSize_MenuItemInfo_Font_Option()
	{
		ItemName_ServingSize_MenuItemInfoInputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement ItemName_ServingSize_MenuItemInfo_Font_Option()
	{
		return ItemName_ServingSize_MenuItemInfoInputBox;
	}
	
	@FindBy(xpath = "//label[contains(.,'Modifiers & Notes')]/../../input")
	WebElement Modifiers_Notes_MenuItemInfoInputBox;
	
	public void Select_Modifiers_Notes_MenuItemInfo_Font_Option()
	{
		Modifiers_Notes_MenuItemInfoInputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement Modifiers_Notes_MenuItemInfo_Font_Option()
	{
		return Modifiers_Notes_MenuItemInfoInputBox;
	}
	
	@FindBy(xpath = "//div[.='Customer Info']/../../div[contains(.,'keyboard_arrow_right')]")
	WebElement Customer_Info_ArrowRightBtn;
	
	@FindBy(xpath = "//div[.='Customer Info']/../../div[contains(.,'keyboard_arrow_down')]")
	WebElement Customer_Info_ArrowDownBtn;
	
	public void Open_Customer_Info_Screen() throws Exception
	{
		try
		{
		if(Customer_Info_ArrowRightBtn.isDisplayed())
		{
			Customer_Info_ArrowRightBtn.click();
		}
		}
		catch(Exception g)
		{
		
		}
	}
	
	public void Close_Customer_Info_Screen() throws Exception
	{
		try
		{
		if(Customer_Info_ArrowDownBtn.isDisplayed())
		{
			Customer_Info_ArrowDownBtn.click();
		}
		}
		catch(Exception g)
		{

		}
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Name')]")
	WebElement CustomerName_CustomerInfo_ChkBox;
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Name')][contains(@class,'mat-checkbox-checked')]")
	WebElement CustomerName_CustomerInfo_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Name')][contains(@class,'ng-untouched')]")
	WebElement CustomerName_CustomerInfo_ChkBox_SLD1;
	
	
	public WebElement CustomerName_CustomerInfo_CheckBox()
	{
		return CustomerName_CustomerInfo_ChkBox;
	}
	
	public WebElement CustomerName_CustomerInfo_CheckBox_SLD()
	{
		return CustomerName_CustomerInfo_ChkBox_SLD;
	}
	
	public WebElement CustomerName_CustomerInfo_CheckBox_SLD1()
	{
		return CustomerName_CustomerInfo_ChkBox_SLD1;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Address')]")
	WebElement CustomerAddress_CustomerInfo_ChkBox;
	

	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Address')][contains(@class,'mat-checkbox-checked')]")
	WebElement CustomerAddress_CustomerInfo_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Address')][contains(@class,'ng-untouched')]")
	WebElement CustomerAddress_CustomerInfo_ChkBox_SLD1;
	
	
	public WebElement CustomerAddress_CustomerInfo_CheckBox()
	{
		return CustomerAddress_CustomerInfo_ChkBox;
	}
	
	public WebElement CustomerAddress_CustomerInfo_CheckBox_SLD()
	{
		return CustomerAddress_CustomerInfo_ChkBox_SLD;
	}
	
	public WebElement CustomerAddress_CustomerInfo_CheckBox_SLD1()
	{
		return CustomerAddress_CustomerInfo_ChkBox_SLD1;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Delivery Notes')]")
	WebElement DeliveryNotes_CustomerInfo_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Delivery Notes')][contains(@class,'mat-checkbox-checked')]")
	WebElement DeliveryNotes_CustomerInfo_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Delivery Notes')][contains(@class,'ng-untouched')]")
	WebElement DeliveryNotes_CustomerInfo_ChkBox_SLD1;
	
	public WebElement DeliveryNotes_CustomerInfo_CheckBox()
	{
		return DeliveryNotes_CustomerInfo_ChkBox;
	}
	
	public WebElement DeliveryNotes_CustomerInfo_CheckBox_SLD()
	{
		return DeliveryNotes_CustomerInfo_ChkBox_SLD;
	}
	
	public WebElement DeliveryNotes_CustomerInfo_CheckBox_SLD1()
	{
		return DeliveryNotes_CustomerInfo_ChkBox_SLD1;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Phone Number')]")
	WebElement PhoneNumber_CustomerInfo_ChkBox;
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Phone Number')][contains(@class,'mat-checkbox-checked')]")
	WebElement PhoneNumber_CustomerInfo_ChkBox_SLD;

	@FindBy(xpath = "//mat-checkbox[contains(.,'Phone Number')][contains(@class,'ng-untouched')]")
	WebElement PhoneNumber_CustomerInfo_ChkBox_SLD1;
	
	public WebElement PhoneNumber_CustomerInfo_CheckBox()
	{
		return PhoneNumber_CustomerInfo_ChkBox;
	}
	
	public WebElement PhoneNumber_CustomerInfo_CheckBox_SLD()
	{
		return PhoneNumber_CustomerInfo_ChkBox_SLD;
	}
	
	public WebElement PhoneNumber_CustomerInfo_CheckBox_SLD1()
	{
		return PhoneNumber_CustomerInfo_ChkBox_SLD1;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Right Divider')]")
	WebElement RightDivider_CustomerInfo_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Right Divider')][contains(@class,'mat-checkbox-checked')]")
	WebElement RightDivider_CustomerInfo_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Right Divider')][contains(@class,'ng-untouched')]")
	WebElement RightDivider_CustomerInfo_ChkBox_SLD1;
	
	
	public WebElement RightDivider_CustomerInfo_CheckBox()
	{
		return RightDivider_CustomerInfo_ChkBox;
	}

	public WebElement RightDivider_CustomerInfo_CheckBox_SLD()
	{
		return RightDivider_CustomerInfo_ChkBox_SLD;
	}
	
	public WebElement RightDivider_CustomerInfo_CheckBox_SLD1()
	{
		return RightDivider_CustomerInfo_ChkBox_SLD1;
	}

	@FindBy(xpath = "//label[contains(.,'Customer Name')]/../../input")
	WebElement CustomerName_CustomerInfoInputBox;
	
	public void Select_CustomerName_CustomerInfo_Font_Option()
	{
		CustomerName_CustomerInfoInputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement CustomerName_CustomerInfo_Font_Option()
	{
		return CustomerName_CustomerInfoInputBox;
	}

	
	@FindBy(xpath = "//label[contains(.,'Customer Details')]/../../input")
	WebElement CustomerDetails_CustomerInfoInputBox;
	
	
	public void Select_CustomerDetails_CustomerInfo_Font_Option()
	{
		CustomerDetails_CustomerInfoInputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement CustomerDetails_CustomerInfo_Font_Option()
	{
		return CustomerDetails_CustomerInfoInputBox;
	}

	
	
	@FindBy(xpath = "//div[.='Order Summary']/../../div[contains(.,'keyboard_arrow_right')]")
	WebElement Order_Summary_ArrowRightBtn;
	
	@FindBy(xpath = "//div[.='Order Summary']/../../div[contains(.,'keyboard_arrow_down')]")
	WebElement Order_Summary_ArrowDownBtn;
	

	public void Open_Order_Summary_Screen() throws Exception
	{
		try
		{
		if(Order_Summary_ArrowRightBtn.isDisplayed())
		{
			Order_Summary_ArrowRightBtn.click();
		}
		}
		catch(Exception g)
		{

		}
	}
	
	public void Close_Order_Summary_Screen() throws Exception
	{
		try
		{
		if(Order_Summary_ArrowDownBtn.isDisplayed())
		{
			Order_Summary_ArrowDownBtn.click();
		}
		}
		catch(Exception l)
		{

		}
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Sub Total')]")
	WebElement SubTotal_OrderSummaryChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Sub Total')][contains(@class,'mat-checkbox-checked')]")
	WebElement SubTotal_OrderSummaryChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Sub Total')][contains(@class,'ng-untouched')]")
	WebElement SubTotal_OrderSummaryChkBox_SLD1;
	
	public WebElement SubTotal_OrderSummary_CheckBox()
	{
		return SubTotal_OrderSummaryChkBox;
	}
	
	public WebElement SubTotal_OrderSummary_CheckBox_SLD()
	{
		return SubTotal_OrderSummaryChkBox_SLD;
	}
	
	public WebElement SubTotal_OrderSummary_CheckBox_SLD1()
	{
		return SubTotal_OrderSummaryChkBox_SLD1;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tip')]")
	WebElement Tip_OrderSummaryChkBox;

	@FindBy(xpath = "//mat-checkbox[contains(.,'Tip')][contains(@class,'mat-checkbox-checked')]")
	WebElement Tip_OrderSummaryChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tip')][contains(@class,'ng-untouched')]")
	WebElement Tip_OrderSummaryChkBox_SLD1;
	
	public WebElement Tip_OrderSummary_CheckBox()
	{
		return Tip_OrderSummaryChkBox;
	}
	
	public WebElement Tip_OrderSummary_CheckBox_SLD()
	{
		return Tip_OrderSummaryChkBox_SLD;
	}
	
	public WebElement Tip_OrderSummary_CheckBox_SLD1()
	{
		return Tip_OrderSummaryChkBox_SLD1;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Discounts')]")
	WebElement Discounts_OrderSummaryChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Discounts')][contains(@class,'mat-checkbox-checked')]")
	WebElement Discounts_OrderSummaryChkBox_SLD;
	

	@FindBy(xpath = "//mat-checkbox[contains(.,'Discounts')][contains(@class,'ng-untouched')]")
	WebElement Discounts_OrderSummaryChkBox_SLD1;
	
	public WebElement Discounts_OrderSummary_CheckBox()
	{
		return Discounts_OrderSummaryChkBox;
	}
	
	public WebElement Discounts_OrderSummary_CheckBox_SLD()
	{
		return Discounts_OrderSummaryChkBox_SLD;
	}
	
	public WebElement Discounts_OrderSummary_CheckBox_SLD1()
	{
		return Discounts_OrderSummaryChkBox_SLD1;
	}
	
	@FindBy(xpath = "//mat-expansion-panel-header[contains(.,'Order Summary')]/../div/div/div/div/div[2]/div/app-checkbox[2]/div/mat-checkbox[contains(.,'Total')]")
	WebElement Total_OrderSummaryChkBox;

	@FindBy(xpath = "//mat-expansion-panel-header[contains(.,'Order Summary')]/../div/div/div/div/div[2]/div/app-checkbox[2]/div/mat-checkbox[contains(.,'Total')][contains(@class,'mat-checkbox-checked')]")
	WebElement Total_OrderSummaryChkBox_SLD;
	

	@FindBy(xpath = "//mat-expansion-panel-header[contains(.,'Order Summary')]/../div/div/div/div/div[2]/div/app-checkbox[2]/div/mat-checkbox[contains(.,'Total')][contains(@class,'ng-untouched')]")
	WebElement Total_OrderSummaryChkBox_SLD1;
	
	public WebElement Total_OrderSummary_CheckBox()
	{
		return Total_OrderSummaryChkBox;
	}
	
	public WebElement Total_OrderSummary_CheckBox_SLD()
	{
		return Total_OrderSummaryChkBox_SLD;
	}
	
	public WebElement Total_OrderSummary_CheckBox_SLD1()
	{
		return Total_OrderSummaryChkBox_SLD1;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Delivery Fee')]")
	WebElement DeliveryFee_OrderSummaryChkBox;

	@FindBy(xpath = "//mat-checkbox[contains(.,'Delivery Fee')][contains(@class,'mat-checkbox-checked')]")
	WebElement DeliveryFee_OrderSummaryChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Delivery Fee')][contains(@class,'ng-untouched')]")
	WebElement DeliveryFee_OrderSummaryChkBox_SLD1;
	
	public WebElement DeliveryFee_OrderSummary_CheckBox()
	{
		return DeliveryFee_OrderSummaryChkBox;
	}
	
	public WebElement DeliveryFee_OrderSummary_CheckBox_SLD()
	{
		return DeliveryFee_OrderSummaryChkBox_SLD;
	}
	
	
	public WebElement DeliveryFee_OrderSummary_CheckBox_SLD1()
	{
		return DeliveryFee_OrderSummaryChkBox_SLD1;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Balance Due')]")
	WebElement BalanceDue_OrderSummaryChkBox;
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Balance Due')][contains(@class,'mat-checkbox-checked')]")
	WebElement BalanceDue_OrderSummaryChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Balance Due')][contains(@class,'ng-untouched')]")
	WebElement BalanceDue_OrderSummaryChkBox_SLD1;
	
	public WebElement BalanceDue_OrderSummary_CheckBox()
	{
		return BalanceDue_OrderSummaryChkBox;
	}
	
	public WebElement BalanceDue_OrderSummary_CheckBox_SLD()
	{
		return BalanceDue_OrderSummaryChkBox_SLD;
	}
	
	public WebElement BalanceDue_OrderSummary_CheckBox_SLD1()
	{
		return BalanceDue_OrderSummaryChkBox_SLD1;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tax')]")
	WebElement Tax_OrderSummaryChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tax')][contains(@class,'mat-checkbox-checked')]")
	WebElement Tax_OrderSummaryChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tax')][contains(@class,'ng-untouched')]")
	WebElement Tax_OrderSummaryChkBox_SLD1;
	
	public WebElement Tax_OrderSummary_CheckBox()
	{
		return Tax_OrderSummaryChkBox;
	}
	
	public WebElement Tax_OrderSummary_CheckBox_SLD()
	{
		return Tax_OrderSummaryChkBox_SLD;
	}
	
	public WebElement Tax_OrderSummary_CheckBox_SLD1()
	{
		return Tax_OrderSummaryChkBox_SLD1;
	}
	
	@FindBy(xpath = "//label[contains(.,'Order Summary')]/../../input")
	WebElement OrderSummary_OrderSummaryInputBox;
	
	public void Select_OrderSummary_OrderSummary_Font_Option()
	{
		OrderSummary_OrderSummaryInputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement OrderSummary_OrderSummary_Font_Option()
	{
		return OrderSummary_OrderSummaryInputBox;
	}
	
	@FindBy(xpath = "//label[contains(.,'Balance Due')]/../../input")
	WebElement BalanceDue_OrderSummaryInputBox;
	
	public void Select_BalanceDue_OrderSummary_Font_Option()
	{
		BalanceDue_OrderSummaryInputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement BalanceDue_OrderSummary_Font_Option()
	{
		return BalanceDue_OrderSummaryInputBox;
	}
	
	
	@FindBy(xpath = "//label[contains(.,'Item Name')]/../../input")
	WebElement Item_Name_FontSize_KitchenLabelInputBox;
	
	public void Select_Item_Name_FontSize_KitchenLabel_Font_Option()
	{
		Item_Name_FontSize_KitchenLabelInputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement Item_Name_FontSize_KitchenLabelInputBox()
	{
		return Item_Name_FontSize_KitchenLabelInputBox;
	}
	
	@FindBy(xpath = "//label[contains(.,'Modifiers')]/../../input")
	WebElement Modifiers_FontSize_KitchenLabelInputBox;
	
	public void Select_Modifiers_FontSize_KitchenLabel_Font_Option()
	{
		Modifiers_FontSize_KitchenLabelInputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement Modifiers_FontSize_KitchenLabel_Font_Option()
	{
		return Modifiers_FontSize_KitchenLabelInputBox;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Menu Item Name Bottom Divider')]")
	WebElement MenuItem_Name_BottomDivider_KitchenLabelChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Menu Item Name Bottom Divider')][contains(@class,'mat-checkbox-checked')]")
	WebElement MenuItem_Name_BottomDivider_KitchenLabelChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Menu Item Name Bottom Divider')][contains(@class,'ng-untouched')]")
	WebElement MenuItem_Name_BottomDivider_KitchenLabelChkBox_SLD1;

	public WebElement MenuItem_Name_BottomDivider_KitchenLabel_CheckBox()
	{
		return MenuItem_Name_BottomDivider_KitchenLabelChkBox;
	}
	
	public WebElement MenuItem_Name_BottomDivider_KitchenLabel_CheckBox_SLD()
	{
		return MenuItem_Name_BottomDivider_KitchenLabelChkBox_SLD;
	}
	
	public WebElement MenuItem_Name_BottomDivider_KitchenLabel_CheckBox_SLD1()
	{
		return MenuItem_Name_BottomDivider_KitchenLabelChkBox_SLD1;
	}
	
	public String RandomInput()
	{
		
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(3, 12);
		
		String str=String.valueOf(randomOption);
		
		return str;
		
	}

	
	@FindBy(xpath = "//span[contains(.,'Minimum Width is 3 and Maximum Width is 4')]")
	WebElement Width_ErrorMsg;
	
	public void Verify_Width_ErrorMsg()
	{
		//Verify whether the Min and Max Error Msg Displayed or not
				if(Width_ErrorMsg.isDisplayed())
				{
					test.log(LogStatus.PASS, "Minimum Width is 3 and Maximum Width is 4 Error Displayed");
				}
				else
				{
					test.log(LogStatus.FAIL, "Minimum Width is 3 and Maximum Width is 4 Error not displayed");
				}
	}
	
	@FindBy(xpath = "//span[contains(.,'Minimum Height is 2.5 and Maximum Height is 3')]")
	WebElement Height_ErrorMsg;
	
	public void Verify_Height_ErrorMsg()
	{
		//Verify whether the Min and Max Error Msg Displayed or not
		if(Height_ErrorMsg.isDisplayed())
		{
			test.log(LogStatus.PASS, "Minimum Height is 2.5 and Maximum Height is 3 Error Displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Minimum Height is 2.5 and Maximum Height is 3 Error not displayed");
		}
		
	}
	
	@FindBy(xpath = "//span[contains(.,'Minimum Width is 2 and Maximum Width is 4')]")
	WebElement Width_ErrorMsg_Template2;
	
	public void Verify_Width_ErrorMsg_Template2()
	{
		//Verify whether the Min and Max Error Msg Displayed or not
				if(Width_ErrorMsg.isDisplayed())
				{
					test.log(LogStatus.PASS, "Minimum Width is 2 and Maximum Width is 4 Error Displayed");
				}
				else
				{
					test.log(LogStatus.FAIL, "Minimum Width is 2 and Maximum Width is 4 Error not displayed");
				}
	}
	
	@FindBy(xpath = "//span[contains(.,'Minimum Height is 1 and Maximum Height is 3')]")
	WebElement Height_ErrorMsg_Template2;
	
	public void Verify_Height_ErrorMsg_Template2()
	{
		//Verify whether the Min and Max Error Msg Displayed or not
		if(Height_ErrorMsg.isDisplayed())
		{
			test.log(LogStatus.PASS, "Minimum Height is 1 and Maximum Height is 3 Error Displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Minimum Height is 1 and Maximum Height is 3 Error not displayed");
		}
		
	}
	
	
	
	
	@FindBy(xpath = "//h3[.='Label Template']")
	WebElement Label_TemplateHeader;
	
	public WebElement Label_TemplateHeader()
	{
		return Label_TemplateHeader;
	}
	
	@FindBy(xpath = "//span[contains(.,'Minimum Width is 1 and Maximum Width is 4')]")
	WebElement Width_ErrorMsg_Two;
	
	public void Verify_Width_ErrorMsgTwo()
	{
		//Verify whether the Min and Max Error Msg Displayed or not
				if(Width_ErrorMsg_Two.isDisplayed())
				{
					test.log(LogStatus.PASS, "Minimum Width is 1 and Maximum Width is 4 Error Displayed");
				}
				else
				{
					test.log(LogStatus.FAIL, "Minimum Width is 1 and Maximum Width is 4 Error not displayed");
				}
	}
	
	@FindBy(xpath = "//span[contains(.,'Minimum Height is 1 and Maximum Height is 6')]")
	WebElement Height_ErrorMsg_Two;
	
	public void Verify_Height_ErrorMsgTwo()
	{
		//Verify whether the Min and Max Error Msg Displayed or not
		if(Height_ErrorMsg_Two.isDisplayed())
		{
			test.log(LogStatus.PASS, "Minimum Height is 1 and Maximum Height is 6 Error Displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Minimum Height is 1 and Maximum Height is 6 Error not displayed");
		}
		
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Sale Number')]")
	WebElement SaleNumber_KitchenLabelChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Sale Number')][contains(@class,'mat-checkbox-checked')]")
	WebElement SaleNumber_KitchenLabelChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Sale Number')][contains(@class,'ng-untouched')]")
	WebElement SaleNumber_KitchenLabelChkBox_SLD1;
	
	
	public WebElement SaleNumber_KitchenLabel_CheckBox()
	{
		return SaleNumber_KitchenLabelChkBox;
	}
	
	public WebElement SaleNumber_KitchenLabel_CheckBox_SLD()
	{
		return SaleNumber_KitchenLabelChkBox_SLD;
	}
	
	public WebElement SaleNumber_KitchenLabel_CheckBox_SLD1()
	{
		return SaleNumber_KitchenLabelChkBox_SLD1;
	}
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Order Number')]")
	WebElement OrderNumber_KitchenLabelChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Order Number')][contains(@class,'mat-checkbox-checked')]")
	WebElement OrderNumber_KitchenLabelChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Order Number')][contains(@class,'ng-untouched')]")
	WebElement OrderNumber_KitchenLabelChkBox_SLD1;
	
	
	public WebElement OrderNumber_KitchenLabel_CheckBox()
	{
		return OrderNumber_KitchenLabelChkBox;
	}
	
	public WebElement OrderNumber_KitchenLabel_CheckBox_SLD()
	{
		return OrderNumber_KitchenLabelChkBox_SLD;
	}
	
	public WebElement OrderNumber_KitchenLabel_CheckBox_SLD1()
	{
		return OrderNumber_KitchenLabelChkBox_SLD1;
	}
}
