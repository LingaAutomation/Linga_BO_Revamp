package com.Pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import Utility.Utility;

public class KitchenPrinterTemplatePage 
{

	public WebDriver driver;
	public ExtentTest test;
	Utility ut=new Utility();
	Common_XPaths cmp;
	
	TaxesPage tx;
	public KitchenPrinterTemplatePage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h3[.='Kitchen Printer Template']")
	WebElement Kitchen_Printer_TemplateHeader;
	
	public WebElement Kitchen_Printer_TemplateHeader()
	{
		return Kitchen_Printer_TemplateHeader;
	}
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Small')]")
	WebElement Small_RadioBtn;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Small')][contains(@class,'mat-radio-checked')]")
	WebElement Small_RadioBtn_SLD;
	
	public WebElement Small_RadioButton_Selected()
	{
		return Small_RadioBtn_SLD;
	}
	
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Medium')]")
	WebElement Medium_RadioBtn;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Medium')][contains(@class,'mat-radio-checked')]")
	WebElement Medium_RadioBtn_SLD;
	
	public WebElement Medium_RadioButton_Selected()
	{
		return Medium_RadioBtn_SLD;
	}
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Large')]")
	WebElement Large_RadioBtn;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Large')][contains(@class,'mat-radio-checked')]")
	WebElement Large_RadioBtn_SLD;
	
	public WebElement Large_RadioButton_Selected()
	{
		return Large_RadioBtn_SLD;
	}
	
	@FindBy(xpath = "//label[contains(.,'Font Style')]/../../input")
	WebElement Font_Style_InputBox;
	
	@FindBy(xpath = "//div[.='Store & Check Details']/../../div[contains(.,'keyboard_arrow_right')]")
	WebElement Store_CheckDetails_ArrowRightBtn;
	
	@FindBy(xpath = "//div[.='Store & Check Details']/../../div[contains(.,'keyboard_arrow_down')]")
	WebElement Store_CheckDetails_ArrowDownBtn;
	
	@FindBy(xpath = "//div[.='Order & Item Summary']/../../div[contains(.,'keyboard_arrow_right')]")
	WebElement Order_ItemSummary_ArrowRightBtn;
	
	@FindBy(xpath = "//div[.='Order & Item Summary']/../../div[contains(.,'keyboard_arrow_down')]")
	WebElement Order_ItemSummary_ArrowDownBtn;
	
	@FindBy(xpath = "//div[.='Customer Info']/../../div[contains(.,'keyboard_arrow_right')]")
	WebElement Customer_Info_ArrowRightBtn;
	
	@FindBy(xpath = "//div[.='Customer Info']/../../div[contains(.,'keyboard_arrow_down')]")
	WebElement Customer_Info_ArrowDownBtn;
	
	@FindBy(xpath = "//div[.='Driver Receipt Options']/../../div[contains(.,'keyboard_arrow_right')]")
	WebElement Driver_ReceiptOptions_ArrowRightBtn;
	
	@FindBy(xpath = "//div[.='Driver Receipt Options']/../../div[contains(.,'keyboard_arrow_down')]")
	WebElement Driver_ReceiptOptions_ArrowDownBtn;
	
	@FindBy(xpath = "//div[.='Additional Details']/../../div[contains(.,'keyboard_arrow_right')]")
	WebElement Additional_Details_ArrowRightBtn;
	
	@FindBy(xpath = "//div[.='Additional Details']/../../div[contains(.,'keyboard_arrow_down')]")
	WebElement Additional_Details_ArrowDownBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Enable Driver Receipt')]/../../div[2]//div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Enable_DriverReceipt_YesBtn;
	
	@FindBy(xpath = "//h6[contains(.,'Enable Driver Receipt')]/../../div[2]//div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Enable_DriverReceipt_NoBtn;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Store Name')]")
	WebElement Store_Name_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Store Name')][contains(@class,'mat-checkbox-checked')]")
	WebElement Store_Name_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Store Name')][contains(@class,'ng-untouched')]")
	WebElement Store_Name_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Table Name')]")
	WebElement Table_Name_ChkBox;
	
	//ng-untouched
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Table Name')][contains(@class,'mat-checkbox-checked')]")
	WebElement Table_Name_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Table Name')][contains(@class,'ng-untouched')]")
	WebElement Table_Name_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Check Number')]")
	WebElement Check_Number_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Check Number')][contains(@class,'mat-checkbox-checked')]")
	WebElement Check_Number_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Check Number')][contains(@class,'ng-untouched')]")
	WebElement Check_Number_ChkBox_SLD1;
	
	@FindBy(xpath = "//app-checkbox[@name='kitchenPrinterTemplateCheckNumber']/../div[1]/div/app-radio-button/div/mat-radio-group/div/mat-radio-button[contains(.,'Inline')]")
	WebElement Inline_Position_Check_Number_RadioBtn;
	
	@FindBy(xpath = "//app-checkbox[@name='kitchenPrinterTemplateCheckNumber']/../div[1]/div/app-radio-button/div/mat-radio-group/div/mat-radio-button[contains(.,'Title')]")
	WebElement Title_Position_Check_Number_RadioBtn;
	
	@FindBy(xpath = "//app-checkbox[@name='kitchenPrinterTemplateCheckNumber']/../div[1]/div/app-radio-button/div/mat-radio-group/div/mat-radio-button[contains(.,'Inline')][contains(@class,'mat-radio-checked')]")
	WebElement Inline_Position_Check_Number_RadioBtn_SLD;
	
	@FindBy(xpath = "//app-checkbox[@name='kitchenPrinterTemplateCheckNumber']/../div[1]/div/app-radio-button/div/mat-radio-group/div/mat-radio-button[contains(.,'Title')][contains(@class,'mat-radio-checked')]")
	WebElement Title_Position_Check_Number_RadioBtn_SLD;
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Printer Name')]")
	WebElement Printer_Name_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Printer Name')][contains(@class,'mat-checkbox-checked')]")
	WebElement Printer_Name_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Printer Name')][contains(@class,'ng-untouched')]")
	WebElement Printer_Name_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Server Name')]")
	WebElement Server_Name_ChkBox;
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Server Name')][contains(@class,'mat-checkbox-checked')]")
	WebElement Server_Name_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Server Name')][contains(@class,'ng-untouched')]")
	WebElement Server_Name_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Name')]")
	WebElement Customer_Name_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Name')][contains(@class,'mat-checkbox-checked')]")
	WebElement Customer_Name_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Name')][contains(@class,'ng-untouched')]")
	WebElement Customer_Name_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Print Date & Time')]")
	WebElement Printer_DateTime_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Print Date & Time')][contains(@class,'mat-checkbox-checked')]")
	WebElement Printer_DateTime_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Print Date & Time')][contains(@class,'ng-untouched')]")
	WebElement Printer_DateTime_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'PickUp Date & Time')]")
	WebElement PickUp_DateTime_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'PickUp Date & Time')][contains(@class,'mat-checkbox-checked')]")
	WebElement PickUp_DateTime_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'PickUp Date & Time')][contains(@class,'ng-untouched')]")
	WebElement PickUp_DateTime_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Service Type')]")
	WebElement ServiceType_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Service Type')][contains(@class,'mat-checkbox-checked')]")
	WebElement ServiceType_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Service Type')][contains(@class,'ng-untouched')]")
	WebElement ServiceType_ChkBox_SLD1;
	
	@FindBy(xpath = "//app-checkbox[@name='kitchenPrinterTemplateServiceType']/../div[2]/div/app-radio-button/div/mat-radio-group/div/mat-radio-button[contains(.,'Inline')]")
	WebElement Inline_Position_Service_Type_RadioBtn;
	
	@FindBy(xpath = "//app-checkbox[@name='kitchenPrinterTemplateServiceType']/../div[2]/div/app-radio-button/div/mat-radio-group/div/mat-radio-button[contains(.,'Title')]")
	WebElement Title_Position_Service_Type_RadioBtn;
	
	@FindBy(xpath = "//app-checkbox[@name='kitchenPrinterTemplateServiceType']/../div[2]/div/app-radio-button/div/mat-radio-group/div/mat-radio-button[contains(.,'Inline')][contains(@class,'mat-radio-checked')]")
	WebElement Inline_Position_Service_Type_RadioBtn_SLD;
	
	@FindBy(xpath = "//app-checkbox[@name='kitchenPrinterTemplateServiceType']/../div[2]/div/app-radio-button/div/mat-radio-group/div/mat-radio-button[contains(.,'Title')][contains(@class,'mat-radio-checked')]")
	WebElement Title_Position_Service_Type_RadioBtn_SLD;
	
	//Order Summary
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Split By Course')]")
	WebElement SplitByCourse_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Split By Course')][contains(@class,'mat-checkbox-checked')]")
	WebElement SplitByCourse_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Split By Course')][contains(@class,'ng-untouched')]")
	WebElement SplitByCourse_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Other language Menu Name')]")
	WebElement OtherLanguage_MenuName_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Other language Menu Name')][contains(@class,'mat-checkbox-checked')]")
	WebElement OtherLanguage_MenuName_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Other language Menu Name')][contains(@class,'ng-untouched')]")
	WebElement OtherLanguage_MenuName_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Menu Price')]")
	WebElement Menu_Price_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Menu Price')][contains(@class,'mat-checkbox-checked')]")
	WebElement Menu_Price_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Menu Price')][contains(@class,'ng-untouched')]")
	WebElement Menu_Price_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Consolidate Menu In Kitchen')]")
	WebElement Consolidate_Menu_InKitchen_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Consolidate Menu In Kitchen')][contains(@class,'mat-checkbox-checked')]")
	WebElement Consolidate_Menu_InKitchen_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Consolidate Menu In Kitchen')][contains(@class,'ng-untouched')]")
	WebElement Consolidate_Menu_InKitchen_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Quantity Before Item Name')]")
	WebElement QuantityBefore_ItemName_ChkBox;
		
	@FindBy(xpath = "//mat-checkbox[contains(.,'Quantity Before Item Name')][contains(@class,'mat-checkbox-checked')]")
	WebElement QuantityBefore_ItemName_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Quantity Before Item Name')][contains(@class,'ng-untouched')]")
	WebElement QuantityBefore_ItemName_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Split Menu Quantity')]")
	WebElement Split_MenuQuantity_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Split Menu Quantity')][contains(@class,'mat-checkbox-checked')]")
	WebElement Split_MenuQuantity_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Split Menu Quantity')][contains(@class,'ng-untouched')]")
	WebElement Split_MenuQuantity_ChkBox_SLD1;
	
	public WebElement Split_MenuQuantity_CheckBox()
	{
		return Split_MenuQuantity_ChkBox;
	}
	
	
	public WebElement Split_MenuQuantity_CheckBox_Selected()
	{
		return Split_MenuQuantity_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Enable Item Summary')]")
	WebElement Enable_ItemSummary_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Enable Item Summary')][contains(@class,'mat-checkbox-checked')]")
	WebElement Enable_ItemSummary_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Enable Item Summary')][contains(@class,'ng-untouched')]")
	WebElement Enable_ItemSummary_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'All Modifiers in Modifier Print')]")
	WebElement  AllModifiers_inModifierPrint_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'All Modifiers in Modifier Print')][contains(@class,'mat-checkbox-checked')]")
	WebElement  AllModifiers_inModifierPrint_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'All Modifiers in Modifier Print')][contains(@class,'ng-untouched')]")
	WebElement  AllModifiers_inModifierPrint_ChkBox_SLD1;
	
	//Customer Info screen
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Address')]")
	WebElement Address__CustomerInfo_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Address')][contains(@class,'mat-checkbox-checked')]")
	WebElement Address__CustomerInfo_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Address')][contains(@class,'ng-untouched')]")
	WebElement Address__CustomerInfo_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Email')]")
	WebElement Email_CustomerInfo_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Email')][contains(@class,'mat-checkbox-checked')]")
	WebElement Email_CustomerInfo_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Email')][contains(@class,'ng-untouched')]")
	WebElement Email_CustomerInfo_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Phone Number')]")
	WebElement Phone_Number_CustomerInfo_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Phone Number')][contains(@class,'mat-checkbox-checked')]")
	WebElement Phone_Number_CustomerInfo_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Phone Number')][contains(@class,'ng-untouched')]")
	WebElement Phone_Number_CustomerInfo_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Notes')]")
	WebElement Customer_Notes_CustomerInfo_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Notes')][contains(@class,'mat-checkbox-checked')]")
	WebElement Customer_Notes_CustomerInfo_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Notes')][contains(@class,'ng-untouched')]")
	WebElement Customer_Notes_CustomerInfo_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'At Top of Check')]")
	WebElement Top_of_Check_RadioBtn;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'At Top of Check')][contains(@class,'mat-radio-checked')]")
	WebElement Top_of_Check_RadioBtn_SLD;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'At Bottom of Check')]")
	WebElement  Bottom_of_Check_RadioBtn;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'At Bottom of Check')][contains(@class,'mat-radio-checked')]")
	WebElement  Bottom_of_Check_RadioBtn_SLD;
	
	//Driver Receipt Options
	
	@FindBy(xpath = "//label[contains(.,'No. of Copies')]/../../input")
	WebElement No_ofCopies_InputBox;
	
	public WebElement No_ofCopies_InputBox()
	{
		return No_ofCopies_InputBox;
	}
	
	public void Enter_No_ofCopies(String str) throws Exception
	{
		Thread.sleep(1000);
		No_ofCopies_InputBox.clear();
		Thread.sleep(500);
		No_ofCopies_InputBox.sendKeys(str);
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Total')]")
	WebElement Total_DriverReceipt_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Total')][contains(@class,'mat-checkbox-checked')]")
	WebElement Total_DriverReceipt_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Total')][contains(@class,'ng-untouched')]")
	WebElement Total_DriverReceipt_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Signature')]")
	WebElement Signature_DriverReceipt_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Signature')][contains(@class,'mat-checkbox-checked')]")
	WebElement Signature_DriverReceipt_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Signature')][contains(@class,'ng-untouched')]")
	WebElement Signature_DriverReceipt_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Balance Due')]")
	WebElement Balance_Due_DriverReceipt_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Balance Due')][contains(@class,'mat-checkbox-checked')]")
	WebElement Balance_Due_DriverReceipt_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Balance Due')][contains(@class,'ng-untouched')]")
	WebElement Balance_Due_DriverReceipt_ChkBox_SLD1;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tip')]")
	WebElement Tip_DriverReceipt_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tip')][contains(@class,'mat-checkbox-checked')]")
	WebElement Tip_DriverReceipt_ChkBox_SLD;
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tip')][contains(@class,'ng-untouched')]")
	WebElement Tip_DriverReceipt_ChkBox_SLD1;
	

	
	//Additional Details
	@FindBy(xpath = "//mat-checkbox[contains(.,'Cut Paper After Each print')]")
	WebElement  CutPaper_After_EachPrint_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Cut Paper After Each print')][contains(@class,'mat-checkbox-checked')]")
	WebElement  CutPaper_After_EachPrint_ChkBox_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Cut Paper After Each print')][contains(@class,'ng-untouched')]")
	WebElement  CutPaper_After_EachPrint_ChkBox_SLD1;
	
	public WebElement Small_FontSize()
	{
		return Small_RadioBtn;
	}
	
	public WebElement Small_FontSize_Selected()
	{
		return Small_RadioBtn_SLD;
	}
	
	public void Click_Small_FontSize()
	{
		Small_RadioBtn.click();
	}
	
	public WebElement Medium_FontSize()
	{
		return Medium_RadioBtn;
	}
	
	public WebElement Medium_FontSize_Selected()
	{
		return Medium_RadioBtn_SLD;
	}
	
	
	public void Click_Medium_FontSize()
	{
		Medium_RadioBtn.click();
	}
	
	
	
	public WebElement Large_FontSize()
	{
		return Large_RadioBtn;
	}
	
	public WebElement Large_FontSize_Selected()
	{
		return Large_RadioBtn_SLD;
	}
	
	public void Click_Large_FontSize()
	{
		Large_RadioBtn.click();
	}
	
	public void Open_Store_CheckDetails_Screen() throws Exception
	{
		try
		{
		if(Store_CheckDetails_ArrowRightBtn.isDisplayed())
		{
			Store_CheckDetails_ArrowRightBtn.click();
		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	public void Close_Store_CheckDetails_Screen() throws Exception
	{
		try
		{
		if(Store_CheckDetails_ArrowDownBtn.isDisplayed())
		{
			Store_CheckDetails_ArrowDownBtn.click();

		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	
	public void Enable_Store_Name() throws Exception
	{
		Thread.sleep(1000);
		if(Store_Name_ChkBox_SLD.isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			Store_Name_ChkBox_SLD.click();
		}
	}

	public WebElement Store_Name_CheckBox()
	{
		return Store_Name_ChkBox;
	}
	
	public WebElement Store_Name_CheckBox_Selected()
	{
		return Store_Name_ChkBox_SLD;
	}
	
	public WebElement Store_Name_CheckBox_Selected1()
	{
		return Store_Name_ChkBox_SLD1;
	}
	
	public WebElement Table_Name_CheckBox()
	{
		return Table_Name_ChkBox;
	}
	
	
	public WebElement Table_Name_CheckBox_Selected()
	{
		return Table_Name_ChkBox_SLD;
	}
	
	public WebElement Table_Name_CheckBox_Selected1()
	{
		return Table_Name_ChkBox_SLD1;
	}
	
	public WebElement Check_Number_CheckBox()
	{
		return Check_Number_ChkBox;
	}
	
	public WebElement Check_Number_CheckBox_Selected()
	{
		return Check_Number_ChkBox_SLD;
	}
	
	public WebElement Check_Number_CheckBox_Selected1()
	{
		return Check_Number_ChkBox_SLD1;
	}
	
	public WebElement Inline_Position_Check_Number_RadioButton()
	{
		return Inline_Position_Check_Number_RadioBtn;
	}
	
	public WebElement Title_Position_Check_Number_RadioButton()
	{
		return Title_Position_Check_Number_RadioBtn;
	}
	
	public WebElement Inline_Position_Check_Number_RadioButton_Selected()
	{
		return Inline_Position_Check_Number_RadioBtn_SLD;
	}
	
	public WebElement Title_Position_Check_Number_RadioButton_Selected()
	{
		return Title_Position_Check_Number_RadioBtn_SLD;
	}
	
	public WebElement Printer_Name_CheckBox()
	{
		return Printer_Name_ChkBox;
	}
	
	
	public WebElement Printer_Name_CheckBox_Selected()
	{
		return Printer_Name_ChkBox_SLD;
	}
	
	public WebElement Printer_Name_CheckBox_Selected1()
	{
		return Printer_Name_ChkBox_SLD1;
	}
	
	public WebElement Server_Name_CheckBox()
	{
		return Server_Name_ChkBox;
	}
	
	public WebElement Server_Name_CheckBox_Selected()
	{
		return Server_Name_ChkBox_SLD;
	}
	
	public WebElement Server_Name_CheckBox_Selected1()
	{
		return Server_Name_ChkBox_SLD1;
	}
	
	public WebElement Printer_DateTime_CheckBox()
	{
		return Printer_DateTime_ChkBox;
	}
	
	
	public WebElement Printer_DateTime_CheckBox_Selected()
	{
		return Printer_DateTime_ChkBox_SLD;
	}
	
	public WebElement Printer_DateTime_CheckBox_Selected1()
	{
		return Printer_DateTime_ChkBox_SLD1;
	}
	
	public WebElement Customer_Name_CheckBox()
	{
		return Customer_Name_ChkBox;
	}
	
	public WebElement Customer_Name_CheckBox_Selected()
	{
		return Customer_Name_ChkBox_SLD;
	}
	
	public WebElement Customer_Name_CheckBox_Selected1()
	{
		return Customer_Name_ChkBox_SLD1;
	}
	
	public WebElement PickUp_DateTime_CheckBox()
	{
		return PickUp_DateTime_ChkBox;
	}
	
	public WebElement PickUp_DateTime_CheckBox_Selected()
	{
		return PickUp_DateTime_ChkBox_SLD;
	}
	
	public WebElement PickUp_DateTime_CheckBox_Selected1()
	{
		return PickUp_DateTime_ChkBox_SLD1;
	}
	
	public WebElement ServiceType_CheckBox()
	{
		return ServiceType_ChkBox;
	}
	
	
	public WebElement ServiceType_CheckBox_Selected()
	{
		return ServiceType_ChkBox_SLD;
	}
	
	public WebElement ServiceType_CheckBox_Selected1()
	{
		return ServiceType_ChkBox_SLD1;
	}
	
	public WebElement Inline_Position_Service_Type_RadioButton()
	{
		return Inline_Position_Service_Type_RadioBtn;
	}
	
	public WebElement Title_Position_Service_Type_RadioButton()
	{
		return Title_Position_Service_Type_RadioBtn;
	}
	
	public WebElement Inline_Position_Service_Type_RadioButton_Selected()
	{
		return Inline_Position_Service_Type_RadioBtn_SLD;
	}
	
	public WebElement Title_Position_Service_Type_RadioButton_Selected()
	{
		return Title_Position_Service_Type_RadioBtn_SLD;
	}
	
	
	public void Open_Order_and_ItemSummary_Screen() throws Exception
	{
		try
		{
		if(Order_ItemSummary_ArrowRightBtn.isDisplayed())
		{
			Order_ItemSummary_ArrowRightBtn.click();
		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	public void Close_Order_and_ItemSummary_Screen() throws Exception
	{
		try
		{
		if(Order_ItemSummary_ArrowDownBtn.isDisplayed())
		{
			Order_ItemSummary_ArrowDownBtn.click();

		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	public WebElement SplitByCourse_CheckBox()
	{
		return SplitByCourse_ChkBox;
	}
	
	public WebElement SplitByCourse_CheckBox_Selected()
	{
		return SplitByCourse_ChkBox_SLD;
	}
	
	public WebElement SplitByCourse_CheckBox_Selected1()
	{
		return SplitByCourse_ChkBox_SLD1;
	}
	
	public WebElement OtherLanguage_MenuName_CheckBox()
	{
		return OtherLanguage_MenuName_ChkBox;
	}
	
	
	public WebElement OtherLanguage_MenuName_CheckBox_Selected()
	{
		return OtherLanguage_MenuName_ChkBox_SLD;
	}
	
	public WebElement OtherLanguage_MenuName_CheckBox_Selected1()
	{
		return OtherLanguage_MenuName_ChkBox_SLD1;
	}
	
	public WebElement Menu_Price_CheckBox()
	{
		return Menu_Price_ChkBox;
	}
	
	public WebElement Menu_Price_CheckBox_Selected()
	{
		return Menu_Price_ChkBox_SLD;
	}
	
	public WebElement Menu_Price_CheckBox_Selected1()
	{
		return Menu_Price_ChkBox_SLD1;
	}
	
	public WebElement Consolidate_Menu_InKitchen_CheckBox()
	{
		return Consolidate_Menu_InKitchen_ChkBox;
	}
	
	
	public WebElement Consolidate_Menu_InKitchen_CheckBox_Selected()
	{
		return Consolidate_Menu_InKitchen_ChkBox_SLD;
	}
	
	public WebElement Consolidate_Menu_InKitchen_CheckBox_Selected1()
	{
		return Consolidate_Menu_InKitchen_ChkBox_SLD1;
	}
	
	public WebElement QuantityBefore_ItemName_CheckBox()
	{
		return QuantityBefore_ItemName_ChkBox;
	}
	
	
	public WebElement QuantityBefore_ItemName_CheckBox_Selected()
	{
		return QuantityBefore_ItemName_ChkBox_SLD;
	}
	
	public WebElement QuantityBefore_ItemName_CheckBox_Selected1()
	{
		return QuantityBefore_ItemName_ChkBox_SLD1;
	}
	
	public WebElement Enable_ItemSummary_CheckBox()
	{
		return Enable_ItemSummary_ChkBox;
	}
	
	public WebElement Enable_ItemSummary_CheckBox_Selected()
	{
		return Enable_ItemSummary_ChkBox_SLD;
	}
	
	public WebElement Enable_ItemSummary_CheckBox_Selected1()
	{
		return Enable_ItemSummary_ChkBox_SLD1;
	}
	
	public WebElement AllModifiers_inModifierPrint_CheckBox()
	{
		return AllModifiers_inModifierPrint_ChkBox;
	}
	
	
	public WebElement AllModifiers_inModifierPrint_CheckBox_Selected()
	{
		return AllModifiers_inModifierPrint_ChkBox_SLD;
	}
	
	public WebElement AllModifiers_inModifierPrint_CheckBox_Selected1()
	{
		return AllModifiers_inModifierPrint_ChkBox_SLD1;
	}
	
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
	
	public WebElement At_Top_of_Check_RadioButton()
	{
		return Top_of_Check_RadioBtn;
	}
	
	public WebElement At_Top_of_Check_RadioButton_Selected()
	{
		return Top_of_Check_RadioBtn_SLD;
	}
	
	public WebElement At_Bottom_of_Check_RadioButton()
	{
		return Bottom_of_Check_RadioBtn;
	}
	
	public WebElement At_Bottom_of_Check_RadioButton_Selected()
	{
		return Bottom_of_Check_RadioBtn_SLD;
	}
	
	public WebElement Address__CustomerInfo_CheckBox()
	{
		return Address__CustomerInfo_ChkBox;
	}
	
	public WebElement Address__CustomerInfo_CheckBox_Selected()
	{
		return Address__CustomerInfo_ChkBox_SLD;
	}
	
	public WebElement Address__CustomerInfo_CheckBox_Selected1()
	{
		return Address__CustomerInfo_ChkBox_SLD1;
	}
	
	public WebElement Email_CustomerInfo_CheckBox()
	{
		return Email_CustomerInfo_ChkBox;
	}
	
	public WebElement Email_CustomerInfo_CheckBox_Selected()
	{
		return Email_CustomerInfo_ChkBox_SLD;
	}
	
	public WebElement Email_CustomerInfo_CheckBox_Selected1()
	{
		return Email_CustomerInfo_ChkBox_SLD1;
	}
	
	public WebElement Phone_Number_CustomerInfo_CheckBox()
	{
		return Phone_Number_CustomerInfo_ChkBox;
	}
	
	public WebElement Phone_Number_CustomerInfo_CheckBox_Selected()
	{
		return Phone_Number_CustomerInfo_ChkBox_SLD;
	}
	
	public WebElement Phone_Number_CustomerInfo_CheckBox_Selected1()
	{
		return Phone_Number_CustomerInfo_ChkBox_SLD1;
	}
	
	public WebElement Customer_Notes_CustomerInfo_CheckBox()
	{
		return Customer_Notes_CustomerInfo_ChkBox;
	}
	
	public WebElement Customer_Notes_CustomerInfo_CheckBox_Selected()
	{
		return Customer_Notes_CustomerInfo_ChkBox_SLD;
	}
	
	public WebElement Customer_Notes_CustomerInfo_CheckBox_Selected1()
	{
		return Customer_Notes_CustomerInfo_ChkBox_SLD1;
	}
	
	public void Open_Driver_ReceiptOptions_Screen() throws Exception
	{
		try
		{
		if(Driver_ReceiptOptions_ArrowRightBtn.isDisplayed())
		{
			Driver_ReceiptOptions_ArrowRightBtn.click();
		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	public void Close_Driver_ReceiptOptions_Screen() throws Exception
	{
		try
		{
		if(Driver_ReceiptOptions_ArrowDownBtn.isDisplayed())
		{
			Driver_ReceiptOptions_ArrowDownBtn.click();

		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	
	//
	public void Enable_DriverReceipt()
	{
		if(Enable_DriverReceipt_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Enable_DriverReceipt_YesBtn.click();
		}
	}
	
	public void Disable_DriverReceipt()
	{
		if(Enable_DriverReceipt_YesBtn.isEnabled()) 
		{
			Enable_DriverReceipt_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	
	
	public WebElement Enable_DriverReceipt_YesBtn()
	{
		return Enable_DriverReceipt_YesBtn;
	}
	
	public void Open_Additional_Details_Screen() throws Exception
	{
		try
		{
		if(Additional_Details_ArrowRightBtn.isDisplayed())
		{
			Additional_Details_ArrowRightBtn.click();
		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	public void Close_Additional_Details_Screen() throws Exception
	{
		try
		{
		if(Additional_Details_ArrowDownBtn.isDisplayed())
		{
			Additional_Details_ArrowDownBtn.click();

		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	public WebElement CutPaper_After_EachPrint_CheckBox()
	{
		return CutPaper_After_EachPrint_ChkBox;
	}
	
	
	public WebElement CutPaper_After_EachPrint_CheckBox_Selected()
	{
		return CutPaper_After_EachPrint_ChkBox_SLD;
	}
	
	public WebElement CutPaper_After_EachPrint_CheckBox_Selected1()
	{
		return CutPaper_After_EachPrint_ChkBox_SLD1;
	}
	
	public WebElement Total_DriverReceipt_CheckBox()
	{
		return Total_DriverReceipt_ChkBox;
	}
	
	public WebElement Total_DriverReceipt_CheckBox_Selected()
	{
		return Total_DriverReceipt_ChkBox_SLD;
	}
	
	public WebElement Total_DriverReceipt_CheckBox_Selected1()
	{
		return Total_DriverReceipt_ChkBox_SLD1;
	}
	
	public WebElement Tip_DriverReceipt_CheckBox()
	{
		return Tip_DriverReceipt_ChkBox;
	}
	
	
	public WebElement Tip_DriverReceipt_CheckBox_Selected()
	{
		return Tip_DriverReceipt_ChkBox_SLD;
	}
	
	public WebElement Tip_DriverReceipt_CheckBox_Selected1()
	{
		return Tip_DriverReceipt_ChkBox_SLD1;
	}
	
	public WebElement Signature_DriverReceipt_CheckBox()
	{
		return Signature_DriverReceipt_ChkBox;
	}
	
	
	public WebElement Signature_DriverReceipt_CheckBox_Selected()
	{
		return Signature_DriverReceipt_ChkBox_SLD;
	}
	
	public WebElement Signature_DriverReceipt_CheckBox_Selected1()
	{
		return Signature_DriverReceipt_ChkBox_SLD1;
	}
	
	public WebElement Balance_Due_DriverReceipt_CheckBox()
	{
		return Balance_Due_DriverReceipt_ChkBox;
	}
	
	
	public WebElement Balance_Due_DriverReceipt_CheckBox_Selected()
	{
		return Balance_Due_DriverReceipt_ChkBox_SLD;
	}
	
	public WebElement Balance_Due_DriverReceipt_CheckBox_Selected1()
	{
		return Balance_Due_DriverReceipt_ChkBox_SLD1;
	}
	
	public void Select_Font_Style_Option() throws Exception
	{
		Thread.sleep(1000);
		Font_Style_InputBox.click();
		
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement Font_Style_Option()
	{
		return Font_Style_InputBox;
	}
	
	@FindBy(xpath = "//span[contains(.,'The value must be in range 1 to 10')]")
	WebElement No_ofCopiesErrorMsg;
	
	public WebElement No_ofCopiesErrorMsg()
	{
		return No_ofCopiesErrorMsg;
	}
}
