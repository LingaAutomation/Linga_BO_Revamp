package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Front_End_Receipt_TemplatePage extends BasePage
{

//	public SelfHealingDriver driver;
//	public ExtentTest test;
	Utility ut=new Utility();
	Common_XPaths cmp;
	
	TaxesPage tx;
	public Front_End_Receipt_TemplatePage(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		
		super(driver,test);
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h3[contains(.,'Front End Receipt')]")
	WebElement Front_EndReceipt_Header;
	
	public WebElement Front_EndReceipt_Header()
	{
		return Front_EndReceipt_Header;
	}
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Small')]")
	WebElement Small_RadioBtn;
	
	public WebElement Small_RadioButton()
	{
		return Small_RadioBtn;
	}
	
	public void Click_Small_FontSize()
	{
		Small_RadioBtn.click();
	}
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Small')]")
	WebElement Small_RadioBtn_SLD;
	
	public WebElement Small_RadioButton_SLD()
	{
		return Small_RadioBtn_SLD;
	}
	
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Medium')]")
	WebElement Medium_RadioBtn;
	
	public WebElement Medium_RadioButton()
	{
		return Medium_RadioBtn;
	}
	
	public void Click_Medium_FontSize()
	{
		Medium_RadioBtn.click();
	}
	
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Medium')][contains(@class,'mat-radio-checked')]")
	WebElement Medium_RadioBtn_SLD;
	
	public WebElement Medium_RadioBtn_SLD()
	{
		return Medium_RadioBtn_SLD;
	}
	
	@FindBy(xpath = "//div[.='Print Template']/../../div[contains(.,'keyboard_arrow_right')]")
	WebElement Print_Template_ArrowRightBtn;
	
	@FindBy(xpath = "//div[.='Print Template']/../../div[contains(.,'keyboard_arrow_down')]")
	WebElement Print_Template_ArrowDownBtn;
	
	
	//Store Info Screen

	@FindBy(xpath = "//div[.='Store Info']/../../div[contains(.,'keyboard_arrow_right')]")
	WebElement Store_Info_ArrowRightBtn;
	
	@FindBy(xpath = "//div[.='Store Info']/../../div[contains(.,'keyboard_arrow_down')]")
	WebElement Store_Info_ArrowDownBtn;
	
	public void Open_Print_Template_Screen() throws Exception
	{
		try
		{
		if(Print_Template_ArrowRightBtn.isDisplayed())
		{
			Print_Template_ArrowRightBtn.click();
		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	public void Close_Print_Template_Screen() throws Exception
	{
		try
		{
		if(Print_Template_ArrowDownBtn.isDisplayed())
		{
			Print_Template_ArrowDownBtn.click();

		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	
	public void Open_Store_Info_Screen() throws Exception
	{
		try
		{
		if(Store_Info_ArrowRightBtn.isDisplayed())
		{
			Store_Info_ArrowRightBtn.click();
		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	public void Close_Store_Info_Screen() throws Exception
	{
		try
		{
		if(Store_Info_ArrowDownBtn.isDisplayed())
		{
			Store_Info_ArrowDownBtn.click();

		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Store Logo')]")
	WebElement Store_Logo_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Store Logo')][contains(@class,'mat-checkbox-checked')]")
	WebElement Store_Logo_ChkBox_SLD;
	
	public WebElement Store_Logo_CheckBox()
	{
		return Store_Logo_ChkBox;
	}
	
	public WebElement Store_Logo_CheckBox_Selected()
	{
		return Store_Logo_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//div[.='Store Info']/../../..//app-checkbox/div/mat-checkbox[contains(.,'Email')]")
	WebElement Email_StoreInfo_ChkBox;
	
	@FindBy(xpath = "//div[.='Store Info']/../../..//app-checkbox/div/mat-checkbox[contains(.,'Email')][contains(@class,'mat-checkbox-checked')]")
	WebElement Email_StoreInfo_ChkBox_SLD;
	
	public WebElement Email_StoreInfo_CheckBox()
	{
		return Email_StoreInfo_ChkBox;
	}
	
	public WebElement Email_StoreInfo_CheckBox_Selected()
	{
		return Email_StoreInfo_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Store Name')]")
	WebElement Store_Name_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Store Name')][contains(@class,'mat-checkbox-checked')]")
	WebElement Store_Name_ChkBox_SLD;
	
	public WebElement Store_Name_CheckBox()
	{
		return Store_Name_ChkBox;
	}
	
	public WebElement Store_Name_CheckBox_Selected()
	{
		return Store_Name_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//div[.='Store Info']/../../..//app-checkbox/div/mat-checkbox[contains(.,'Phone Number')]")
	WebElement Phone_Number_StoreInfo_ChkBox;
	
	@FindBy(xpath = "//div[.='Store Info']/../../..//app-checkbox/div/mat-checkbox[contains(.,'Phone Number')][contains(@class,'mat-checkbox-checked')]")
	WebElement Phone_Number_StoreInfo_ChkBox_SLD;
	
	public WebElement Phone_Number_StoreInfo_CheckBox()
	{
		return Phone_Number_StoreInfo_ChkBox;
	}
	
	public WebElement Phone_Number_StoreInfo_CheckBox_Selected()
	{
		return Phone_Number_StoreInfo_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//div[.='Store Info']/../../..//app-checkbox/div/mat-checkbox[contains(.,'Address')]")
	WebElement Address_StoreInfo_ChkBox;
	
	@FindBy(xpath = "//div[.='Store Info']/../../..//app-checkbox/div/mat-checkbox[contains(.,'Address')][contains(@class,'mat-checkbox-checked')]")
	WebElement Address_StoreInfo_ChkBox_SLD;
	
	public WebElement Address_StoreInfo_CheckBox()
	{
		return Address_StoreInfo_ChkBox;
	}
	
	public WebElement Address_StoreInfo_CheckBox_Selected()
	{
		return Address_StoreInfo_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Header Notes')]")
	WebElement Header_Notes_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Header Notes')][contains(@class,'mat-checkbox-checked')]")
	WebElement Header_Notes_ChkBox_SLD;
	
	public WebElement Header_Notes_CheckBox()
	{
		return Header_Notes_ChkBox;
	}
	
	public WebElement Header_Notes_CheckBox_Selected()
	{
		return Header_Notes_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//input[@type='file']")
	WebElement Store_Logo_Upload;
	
	public WebElement Store_Logo_Upload()
	{
		return Store_Logo_Upload;
	}
	
	@FindBy(xpath = "//label[contains(.,'Header Notes')]/../../../../textarea")
	WebElement Header_Notes_TxtBox;
	
	public WebElement Header_Notes_TextBox()
	{
		return Header_Notes_TxtBox;
	}
	
	public void Enter_Header_Notes(String str) throws Exception
	{
		Thread.sleep(500);
		Header_Notes_TxtBox.clear();
		Thread.sleep(500);
		Header_Notes_TxtBox.sendKeys(str);
		
	}
	//Check Details screen
	
	@FindBy(xpath = "//div[.='Check Details']/../../div[contains(.,'keyboard_arrow_right')]")
	WebElement Check_Details_ArrowRightBtn;
	
	@FindBy(xpath = "//div[.='Check Details']/../../div[contains(.,'keyboard_arrow_down')]")
	WebElement Check_Details_ArrowDownBtn;
	
	
	public void Open_Check_Details_Screen() throws Exception
	{
		try
		{
		if(Check_Details_ArrowRightBtn.isDisplayed())
		{
			Check_Details_ArrowRightBtn.click();
		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	public void Close_Check_Details_Screen() throws Exception
	{
		try
		{
		if(Check_Details_ArrowDownBtn.isDisplayed())
		{
			Check_Details_ArrowDownBtn.click();

		}
		}
		catch(Exception g)
		{
			
		}
	}

	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Check Number')]")
	WebElement Check_Number_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Check Number')][contains(@class,'mat-checkbox-checked')]")
	WebElement Check_Number_ChkBox_SLD;
	
	public WebElement Check_Number_CheckBox()
	{
		return Check_Number_ChkBox;
	}
	
	public WebElement Check_Number_CheckBox_Selected()
	{
		return Check_Number_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Check Close Server')]")
	WebElement Check_Close_Server_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Check Close Server')][contains(@class,'mat-checkbox-checked')]")
	WebElement Check_Close_Server_ChkBox_SLD;
	
	public WebElement Check_Close_Server_CheckBox()
	{
		return Check_Close_Server_ChkBox;
	}
	
	public WebElement Check_Close_Server_CheckBox_Selected()
	{
		return Check_Close_Server_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Open date & time')]")
	WebElement Open_Date_Time_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Open date & time')][contains(@class,'mat-checkbox-checked')]")
	WebElement Open_Date_Time_ChkBox_SLD;
	
	public WebElement Open_Date_Time_CheckBox()
	{
		return Open_Date_Time_ChkBox;
	}
	
	public WebElement Open_Date_Time_CheckBox_Selected()
	{
		return Open_Date_Time_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Close date & time')]")
	WebElement Close_Date_Time_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Close date & time')][contains(@class,'mat-checkbox-checked')]")
	WebElement Close_Date_Time_SLD;
	
	public WebElement Close_Date_Time_CheckBox()
	{
		return Close_Date_Time_ChkBox;
	}
	
	public WebElement Close_Date_Time_CheckBox_Selected()
	{
		return Close_Date_Time_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Service Type')]")
	WebElement Service_Type_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Service Type')][contains(@class,'mat-checkbox-checked')]")
	WebElement Service_Type_ChkBox_SLD;
	
	public WebElement Service_Type_CheckBox()
	{
		return Service_Type_ChkBox;
	}
	
	public WebElement Service_Type_CheckBox_Selected()
	{
		return Service_Type_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Table Name')]")
	WebElement Table_Name_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Table Name')][contains(@class,'mat-checkbox-checked')]")
	WebElement Table_Name_ChkBox_SLD;
	
	public WebElement Table_Name_CheckBox()
	{
		return Table_Name_ChkBox;
	}
	
	public WebElement Table_Name_CheckBox_Selected()
	{
		return Table_Name_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Seat Number')]")
	WebElement Seat_Number_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Seat Number')][contains(@class,'mat-checkbox-checked')]")
	WebElement Seat_Number_ChkBox_SLD;
	
	public WebElement Seat_Number_CheckBox()
	{
		return Seat_Number_ChkBox;
	}
	
	public WebElement Seat_Number_CheckBox_Selected()
	{
		return Seat_Number_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Check open server')]")
	WebElement Check_Open_Server_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Check open server')][contains(@class,'mat-checkbox-checked')]")
	WebElement Check_Open_Server_ChkBox_SLD;
	
	public WebElement Check_Open_Server_CheckBox()
	{
		return Check_Open_Server_ChkBox;
	}
	
	public WebElement Check_Open_Server_CheckBox_Selected()
	{
		return Check_Open_Server_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Block 1')]")
	WebElement Block_1_RadioBtn;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Block 1')][contains(@class,'mat-radio-checked')]")
	WebElement Block_1_RadioBtn_SLD;
	
	public WebElement Block_1_RadioBtn()
	{
		return Block_1_RadioBtn;
	}
	
	public WebElement Block_1_RadioBtn_SLD()
	{
		return Block_1_RadioBtn_SLD;
	}
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Block 2')]")
	WebElement Block_2_RadioBtn;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Block 2')][contains(@class,'mat-radio-checked')]")
	WebElement Block_2_RadioBtn_SLD;
	
	public WebElement Block_2_RadioBtn()
	{
		return Block_2_RadioBtn;
	}
	
	public WebElement Block_2_RadioBtn_SLD()
	{
		return Block_2_RadioBtn_SLD;
	}
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Large')]")
	WebElement Large_RadioBtn;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Large')][contains(@class,'mat-radio-checked')]")
	WebElement Large_RadioBtn_SLD;
	
	public WebElement Large_RadioBtn()
	{
		return Large_RadioBtn;
	}
	
	public WebElement Large_RadioBtn_SLD()
	{
		return Large_RadioBtn_SLD;
	}
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Normal')]")
	WebElement Normal_RadioBtn;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Normal')][contains(@class,'mat-radio-checked')]")
	WebElement Normal_RadioBtn_SLD;
	
	public WebElement Normal_RadioBtn()
	{
		return Normal_RadioBtn;
	}
	
	public WebElement Normal_RadioBtn_SLD()
	{
		return Normal_RadioBtn_SLD;
	}
	
	//Order Summary Screen
	
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
		catch(Exception g)
		{
			
		}
	}

	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Secondary Menu Name')]")
	WebElement Secondary_MenuName_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Secondary Menu Name')][contains(@class,'mat-checkbox-checked')]")
	WebElement Secondary_MenuName_ChkBox_SLD;
	
	public WebElement Secondary_MenuName_CheckBox()
	{
		return Secondary_MenuName_ChkBox;
	}
	
	public WebElement Secondary_MenuName_CheckBox_Selected()
	{
		return Secondary_MenuName_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Roll Out Modifier Price To Menu')]")
	WebElement RollOut_ModifierPrice_To_Menu_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Roll Out Modifier Price To Menu')][contains(@class,'mat-checkbox-checked')]")
	WebElement RollOut_ModifierPrice_To_Menu_ChkBox_SLD;
	
	public WebElement RollOut_ModifierPrice_To_Menu_CheckBox()
	{
		return RollOut_ModifierPrice_To_Menu_ChkBox;
	}
	
	public WebElement RollOut_ModifierPrice_To_Menu_CheckBox_Selected()
	{
		return RollOut_ModifierPrice_To_Menu_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Roll Out Modifier To Menu')]")
	WebElement RollOut_Modifier_To_Menu_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Roll Out Modifier To Menu')][contains(@class,'mat-checkbox-checked')]")
	WebElement RollOut_Modifier_To_Menu_ChkBox_SLD;
	
	public WebElement RollOut_Modifier_To_Menu_CheckBox()
	{
		return RollOut_Modifier_To_Menu_ChkBox;
	}
	
	public WebElement RollOut_Modifier_To_Menu_CheckBox_Selected()
	{
		return RollOut_Modifier_To_Menu_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Exclude Zero Price Menu Item')]")
	WebElement Exclude_ZeroPrice_MenuItem_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Exclude Zero Price Menu Item')][contains(@class,'mat-checkbox-checked')]")
	WebElement Exclude_ZeroPrice_MenuItem_ChkBox_SLD;
	
	public WebElement Exclude_ZeroPrice_MenuItem_CheckBox()
	{
		return Exclude_ZeroPrice_MenuItem_ChkBox;
	}
	
	public WebElement Exclude_ZeroPrice_MenuItem_CheckBox_Selected()
	{
		return Exclude_ZeroPrice_MenuItem_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Exclude Zero Price Modifier')]")
	WebElement Exclude_ZeroPrice_Modifier_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Exclude Zero Price Modifier')][contains(@class,'mat-checkbox-checked')]")
	WebElement Exclude_ZeroPrice_Modifier_ChkBox_SLD;
	
	public WebElement Exclude_ZeroPrice_Modifier_CheckBox()
	{
		return Exclude_ZeroPrice_Modifier_ChkBox;
	}
	
	public WebElement Exclude_ZeroPrice_Modifier_CheckBox_Selected()
	{
		return Exclude_ZeroPrice_Modifier_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tax Total')]")
	WebElement Tax_Total_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tax Total')][contains(@class,'mat-checkbox-checked')]")
	WebElement Tax_Total_ChkBox_SLD;
	
	public WebElement Tax_Total_CheckBox()
	{
		return Tax_Total_ChkBox;
	}
	
	public WebElement Tax_Total_CheckBox_Selected()
	{
		return Tax_Total_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Hide Inclusive Tax')]")
	WebElement  Hide_Inclusive_Tax_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Hide Inclusive Tax')][contains(@class,'mat-checkbox-checked')]")
	WebElement  Hide_Inclusive_Tax_ChkBox_SLD;
	
	public WebElement Hide_Inclusive_Tax_CheckBox()
	{
		return Hide_Inclusive_Tax_ChkBox;
	}
	
	public WebElement Hide_Inclusive_Tax_CheckBox_Selected()
	{
		return Hide_Inclusive_Tax_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Gratuity')]")
	WebElement Gratuity_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Gratuity')][contains(@class,'mat-checkbox-checked')]")
	WebElement Gratuity_ChkBox_SLD;
	
	public WebElement Gratuity_CheckBox()
	{
		return Gratuity_ChkBox;
	}
	
	public WebElement Gratuity_CheckBox_Selected()
	{
		return Gratuity_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//div[.='Order Summary']/../../../../div/div/div/div/app-checkbox/div/mat-checkbox[contains(.,'Tip')]")
	WebElement Tip_ChkBox;
	
	@FindBy(xpath = "//div[.='Order Summary']/../../../../div/div/div/div/app-checkbox/div/mat-checkbox[contains(.,'Tip')][contains(@class,'mat-checkbox-checked')]")
	WebElement Tip_ChkBox_SLD;
	
	public WebElement Tip_CheckBox()
	{
		return Tip_ChkBox;
	}
	
	public WebElement Tip_CheckBox_Selected()
	{
		return Tip_ChkBox_SLD;
	}

	@FindBy(xpath = "//mat-checkbox[contains(.,'Cash Discount')]")
	WebElement Cash_Discount_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Cash Discount')][contains(@class,'mat-checkbox-checked')]")
	WebElement Cash_Discount_ChkBox_SLD;
	
	public WebElement Cash_Discount_CheckBox()
	{
		return Cash_Discount_ChkBox;
	}
	
	public WebElement Cash_Discount_CheckBox_Selected()
	{
		return Cash_Discount_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Check Total')]")
	WebElement Check_Total_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Check Total')][contains(@class,'mat-checkbox-checked')]")
	WebElement Check_Total_ChkBox_SLD;
	
	public WebElement Check_Total_CheckBox()
	{
		return Check_Total_ChkBox;
	}
	
	public WebElement Check_Total_CheckBox_Selected()
	{
		return Check_Total_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tender Details')]")
	WebElement Tender_Details_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tender Details')][contains(@class,'mat-checkbox-checked')]")
	WebElement Tender_Details_ChkBox_SLD;
	
	public WebElement Tender_Details_CheckBox()
	{
		return Tender_Details_ChkBox;
	}
	
	public WebElement Tender_Details_CheckBox_Selected()
	{
		return Tender_Details_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Show Membership Balance')]")
	WebElement Show_Membership_Balance_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Show Membership Balance')][contains(@class,'mat-checkbox-checked')]")
	WebElement Show_Membership_Balance_ChkBox_SLD;
	
	public WebElement Show_Membership_Balance_CheckBox()
	{
		return Show_Membership_Balance_ChkBox;
	}
	
	public WebElement Show_Membership_Balance_CheckBox_Selected()
	{
		return Show_Membership_Balance_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Loyalty Amount')]")
	WebElement Loyalty_Amount_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Loyalty Amount')][contains(@class,'mat-checkbox-checked')]")
	WebElement Loyalty_Amount_ChkBox_SLD;
	
	public WebElement Loyalty_Amount_CheckBox()
	{
		return Loyalty_Amount_ChkBox;
	}
	
	public WebElement Loyalty_Amount_CheckBox_Selected()
	{
		return Loyalty_Amount_ChkBox_SLD;
	}

	@FindBy(xpath = "//mat-checkbox[contains(.,'Discount under the Menu Item')]")
	WebElement Discount_Under_MenuItem_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Discount under the Menu Item')][contains(@class,'mat-checkbox-checked')]")
	WebElement Discount_Under_MenuItem_ChkBox_SLD;
	
	public WebElement Discount_Under_MenuItem_CheckBox()
	{
		return Discount_Under_MenuItem_ChkBox;
	}
	
	public WebElement Discount_Under_MenuItem_CheckBox_Selected()
	{
		return Discount_Under_MenuItem_ChkBox_SLD;
	}

	@FindBy(xpath = "//mat-checkbox[contains(.,' Print Check in Primary & Secondary Languages ')]")
	WebElement  Print_Check_inPrimary_SecondaryLanguages_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,' Print Check in Primary & Secondary Languages ')][contains(@class,'mat-checkbox-checked')]")
	WebElement  Print_Check_inPrimary_SecondaryLanguages_ChkBox_SLD;
	
	public WebElement Print_Check_inPrimary_SecondaryLanguages_CheckBox()
	{
		return Print_Check_inPrimary_SecondaryLanguages_ChkBox;
	}
	
	public WebElement Print_Check_inPrimary_SecondaryLanguages_CheckBox_Selected()
	{
		return Print_Check_inPrimary_SecondaryLanguages_ChkBox_SLD;
	}
	
	//Customer Info Screen
	
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
	
	@FindBy(xpath = "//div[.='Customer Info']/../../..//app-checkbox/div/mat-checkbox[contains(.,'Email')]")
	WebElement Email_CustomerInfo_ChkBox;
	
	@FindBy(xpath = "//div[.='Customer Info']/../../..//app-checkbox/div/mat-checkbox[contains(.,'Email')][contains(@class,'mat-checkbox-checked')]")
	WebElement Email_CustomerInfo_ChkBox_SLD;
	
	public WebElement Email_CustomerInfo_CheckBox()
	{
		return Email_CustomerInfo_ChkBox;
	}
	
	public WebElement Email_CustomerInfo_CheckBox_Selected()
	{
		return Email_CustomerInfo_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//div[.='Customer Info']/../../..//app-checkbox/div/mat-checkbox[contains(.,'Address')]")
	WebElement Address_CustomerInfo_ChkBox;
	
	@FindBy(xpath = "//div[.='Customer Info']/../../..//app-checkbox/div/mat-checkbox[contains(.,'Address')][contains(@class,'mat-checkbox-checked')]")
	WebElement Address_CustomerInfo_ChkBox_SLD;
	
	public WebElement Address_CustomerInfo_CheckBox()
	{
		return Address_CustomerInfo_ChkBox;
	}
	
	public WebElement Address_CustomerInfo_CheckBox_Selected()
	{
		return Address_CustomerInfo_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//div[.='Customer Info']/../../..//app-checkbox/div/mat-checkbox[contains(.,'Phone Number')]")
	WebElement Phone_Number_CustomerInfo_ChkBox;
	
	@FindBy(xpath = "//div[.='Customer Info']/../../..//app-checkbox/div/mat-checkbox[contains(.,'Phone Number')][contains(@class,'mat-checkbox-checked')]")
	WebElement Phone_Number_CustomerInfo_ChkBox_SLD;
	
	
	public WebElement Phone_Number_CustomerInfo_CheckBox()
	{
		return Phone_Number_CustomerInfo_ChkBox;
	}
	
	public WebElement Phone_Number_CustomerInfo_CheckBox_Selected()
	{
		return Phone_Number_CustomerInfo_ChkBox_SLD;
	}
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Name')]")
	WebElement Customer_Name_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Name')][contains(@class,'mat-checkbox-checked')]")
	WebElement Customer_Name_ChkBox_SLD;
	
	public WebElement Customer_Name_CheckBox()
	{
		return Customer_Name_ChkBox;
	}
	
	public WebElement Customer_Name_CheckBox_Selected()
	{
		return Customer_Name_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Notes')]")
	WebElement Customer_Notes_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Customer Notes')][contains(@class,'mat-checkbox-checked')]")
	WebElement Customer_Notes_ChkBox_SLD;
	
	public WebElement Customer_Notes_CheckBox()
	{
		return Customer_Notes_ChkBox;
	}
	
	public WebElement Customer_Notes_CheckBox_Selected()
	{
		return Customer_Notes_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//app-checkbox[@name='receiptPrinterTemplateCustomerNotes']/../textarea")
	WebElement Customer_Notes_TxtBx;
	
	public WebElement Customer_Notes_TextBox()
	{
		return Customer_Notes_TxtBx;
	}
	
	public void Enter_Customer_Notes(String str) throws Exception
	{
		Thread.sleep(500);
		Customer_Notes_TxtBx.clear();
		Thread.sleep(500);
		Customer_Notes_TxtBx.sendKeys(str);
		
	}
	
	//Additional Settings
	
	@FindBy(xpath = "//div[.='Additional Settings']/../../div[contains(.,'keyboard_arrow_right')]")
	WebElement Additional_Settings_ArrowRightBtn;
	
	@FindBy(xpath = "//div[.='Additional Settings']/../../div[contains(.,'keyboard_arrow_down')]")
	WebElement Additional_Settings_ArrowDownBtn;
	
	
	public void Open_Additional_Settings_Screen() throws Exception
	{
		try
		{
		if(Additional_Settings_ArrowRightBtn.isDisplayed())
		{
			Additional_Settings_ArrowRightBtn.click();
		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	public void Close_Additional_Settings_Screen() throws Exception
	{
		try
		{
		if(Additional_Settings_ArrowDownBtn.isDisplayed())
		{
			Additional_Settings_ArrowDownBtn.click();

		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tip Line')]")
	WebElement Tip_Line_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tip Line')][contains(@class,'mat-checkbox-checked')]")
	WebElement Tip_Line_ChkBox_SLD;
	
	public WebElement Tip_Line_CheckBox()
	{
		return Tip_Line_ChkBox;
	}
	
	public WebElement Tip_Line_CheckBox_Selected()
	{
		return Tip_Line_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Barcode')]")
	WebElement  Barcode_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Barcode')][contains(@class,'mat-checkbox-checked')]")
	WebElement  Barcode_ChkBox_SLD;
	
	public WebElement Barcode_CheckBox()
	{
		return Barcode_ChkBox;
	}
	
	public WebElement Barcode_CheckBox_Selected()
	{
		return Barcode_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Signature')]")
	WebElement  Signature_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Signature')][contains(@class,'mat-checkbox-checked')]")
	WebElement  Signature_ChkBox_SLD;
	
	public WebElement Signature_CheckBox()
	{
		return Signature_ChkBox;
	}
	
	public WebElement Signature_CheckBox_Selected()
	{
		return Signature_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Show E-Invoice URL')]")
	WebElement  Show_EInvoice_URL_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Show E-Invoice URL')][contains(@class,'mat-checkbox-checked')]")
	WebElement  Show_EInvoice_URL_ChkBox_SLD;
	
	public WebElement Show_EInvoice_URL_CheckBox()
	{
		return Show_EInvoice_URL_ChkBox;
	}
	
	public WebElement Show_EInvoice_URL_CheckBox_Selected()
	{
		return Show_EInvoice_URL_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Show E-Invoice QR')]")
	WebElement  Show_EInvoice_QR_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Show E-Invoice QR')][contains(@class,'mat-checkbox-checked')]")
	WebElement  Show_EInvoice_QR_ChkBox_SLD;
	
	public WebElement Show_EInvoice_QR_CheckBox()
	{
		return Show_EInvoice_QR_ChkBox;
	}
	
	public WebElement Show_EInvoice_QR_CheckBox_Selected()
	{
		return Show_EInvoice_QR_ChkBox_SLD;
	}
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tip Suggestion')]")
	WebElement  Tip_Suggestion_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tip Suggestion')][contains(@class,'mat-checkbox-checked')]")
	WebElement  Tip_Suggestion_ChkBox_SLD;
	
	public WebElement Tip_Suggestion_CheckBox()
	{
		return Tip_Suggestion_ChkBox;
	}
	
	public WebElement Tip_Suggestion_CheckBox_Selected()
	{
		return Tip_Suggestion_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Special Notes')]")
	WebElement  Special_Notes_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Special Notes')][contains(@class,'mat-checkbox-checked')]")
	WebElement  Special_Notes_ChkBox_SLD;
	
	public WebElement Special_Notes_CheckBox()
	{
		return Special_Notes_ChkBox;
	}
	
	public WebElement Special_Notes_CheckBox_Selected()
	{
		return Special_Notes_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Cut Paper After Each print')]")
	WebElement  Cut_Paper_After_Each_Print_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Cut Paper After Each print')][contains(@class,'mat-checkbox-checked')]")
	WebElement  Cut_Paper_After_Each_Print_ChkBox_SLD;
	
	public WebElement Cut_Paper_After_Each_Print_CheckBox()
	{
		return Cut_Paper_After_Each_Print_ChkBox;
	}
	
	public WebElement Cut_Paper_After_Each_Print_CheckBox_Selected()
	{
		return Cut_Paper_After_Each_Print_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Show Remaining Balance')]")
	WebElement  Show_Remaining_Balance_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Show Remaining Balance')][contains(@class,'mat-checkbox-checked')]")
	WebElement  Show_Remaining_Balance_ChkBox_SLD;
	
	public WebElement Show_Remaining_Balance_CheckBox()
	{
		return Show_Remaining_Balance_ChkBox;
	}
	
	public WebElement Show_Remaining_Balance_CheckBox_Selected()
	{
		return Show_Remaining_Balance_ChkBox_SLD;
	}
	
	//Merchant Copy Screen
	
	@FindBy(xpath = "//div[.='Merchant Copy']/../../div[contains(.,'keyboard_arrow_right')]")
	WebElement Merchant_Copy_ArrowRightBtn;
	
	@FindBy(xpath = "//div[.='Merchant Copy']/../../div[contains(.,'keyboard_arrow_down')]")
	WebElement Merchant_Copy_ArrowDownBtn;
	
	public void Open_Merchant_Copy_Screen() throws Exception
	{
		try
		{
		if(Merchant_Copy_ArrowRightBtn.isDisplayed())
		{
			Merchant_Copy_ArrowRightBtn.click();
		}
		}
		catch(Exception g)
		{
			
		}
	}
	
	public void Close_Merchant_Copy_Screen() throws Exception
	{
		try
		{
		if(Merchant_Copy_ArrowDownBtn.isDisplayed())
		{
			Merchant_Copy_ArrowDownBtn.click();

		}
		}
		catch(Exception g)
		{
			
		}
	}

	
	@FindBy(xpath = "//div[.='Merchant Copy']/../../../../div/div/div/div/div/div/div/app-checkbox/div/mat-checkbox[contains(.,'Print GC Balance')]")
	WebElement  Print_GC_Balance_MerchantCopy_ChkBox;
	
	@FindBy(xpath = "//div[.='Merchant Copy']/../../../../div/div/div/div/div/div/div/app-checkbox/div/mat-checkbox[contains(.,'Print GC Balance')][contains(@class,'mat-checkbox-checked')]")
	WebElement  Print_GC_Balance_MerchantCopy_ChkBox_SLD;
	
	public WebElement Print_GC_Balance_MerchantCopy_CheckBox()
	{
		return Print_GC_Balance_MerchantCopy_ChkBox;
	}
	
	public WebElement Print_GC_Balance_MerchantCopy_CheckBox_Selected()
	{
		return Print_GC_Balance_MerchantCopy_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//div[.='Merchant Copy']/../../../../div/div/div/div/div/div/div/app-checkbox/div/mat-checkbox[contains(.,'Print HA Balance')]")
	WebElement  Print_HA_Balance_MerchantCopy_ChkBox;
	
	@FindBy(xpath = "//div[.='Merchant Copy']/../../../../div/div/div/div/div/div/div/app-checkbox/div/mat-checkbox[contains(.,'Print HA Balance')][contains(@class,'mat-checkbox-checked')]")
	WebElement  Print_HA_Balance_MerchantCopy_ChkBox_SLD;
	
	public WebElement Print_HA_Balance_MerchantCopy_CheckBox()
	{
		return Print_HA_Balance_MerchantCopy_ChkBox;
	}
	
	public WebElement Print_HA_Balance_MerchantCopy_CheckBox_Selected()
	{
		return Print_HA_Balance_MerchantCopy_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Print Tab Name')]")
	WebElement  Print_Tab_Name_ChkBox;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Print Tab Name')][contains(@class,'mat-checkbox-checked')]")
	WebElement  Print_Tab_Name_ChkBox_SLD;
	
	public WebElement Print_Tab_Name_CheckBox()
	{
		return Print_Tab_Name_ChkBox;
	}
	
	public WebElement Print_Tab_Name_CheckBox_Selected()
	{
		return Print_Tab_Name_ChkBox_SLD;
	}
	
	@FindBy(xpath = "//div[.='Merchant Copy']/../../../../div/div/div/div/div/div/div/app-checkbox/div/mat-checkbox[contains(.,'Print Membership Balance')]")
	WebElement  Print_Membership_Balance_MerchantCopy_ChkBox;
	
	@FindBy(xpath = "//div[.='Merchant Copy']/../../../../div/div/div/div/div/div/div/app-checkbox/div/mat-checkbox[contains(.,'Print Membership Balance')][contains(@class,'mat-checkbox-checked')]")
	WebElement  Print_Membership_Balance_MerchantCopy_ChkBox_SLD;
	
	
	public WebElement Print_Membership_Balance_MerchantCopy_CheckBox()
	{
		return Print_Membership_Balance_MerchantCopy_ChkBox;
	}
	
	public WebElement Print_Membership_Balance_MerchantCopy_CheckBox_Selected()
	{
		return Print_Membership_Balance_MerchantCopy_ChkBox_SLD;
	}
	
	
	//Customer Copy Screen
	
		@FindBy(xpath = "//div[.='Customer Copy']/../../div[contains(.,'keyboard_arrow_right')]")
		WebElement Customer_Copy_ArrowRightBtn;
		
		@FindBy(xpath = "//div[.='Customer Copy']/../../div[contains(.,'keyboard_arrow_down')]")
		WebElement Customer_Copy_ArrowDownBtn;
		
		
		public void Open_Customer_Copy_Screen() throws Exception
		{
			try
			{
			if(Customer_Copy_ArrowRightBtn.isDisplayed())
			{
				Customer_Copy_ArrowRightBtn.click();
			}
			}
			catch(Exception g)
			{
				
			}
		}
		
		public void Close_Customer_Copy_Screen() throws Exception
		{
			try
			{
			if(Customer_Copy_ArrowDownBtn.isDisplayed())
			{
				Customer_Copy_ArrowDownBtn.click();

			}
			}
			catch(Exception g)
			{
				
			}
		}
		
		
		@FindBy(xpath = "//div[.='Customer Copy']/../../../../div/div/div/div/div/div/div/app-checkbox/div/mat-checkbox[contains(.,'Print GC Balance')]")
		WebElement  Print_GC_Balance_CustomerCopy_ChkBox;
		
		@FindBy(xpath = "//div[.='Customer Copy']/../../../../div/div/div/div/div/div/div/app-checkbox/div/mat-checkbox[contains(.,'Print GC Balance')][contains(@class,'mat-checkbox-checked')]")
		WebElement  Print_GC_Balance_CustomerCopy_ChkBox_SLD;
		
		public WebElement Print_GC_Balance_CustomerCopy_CheckBox()
		{
			return Print_GC_Balance_CustomerCopy_ChkBox;
		}
		
		public WebElement Print_GC_Balance_CustomerCopy_CheckBox_Selected()
		{
			return Print_GC_Balance_CustomerCopy_ChkBox_SLD;
		}
		
		@FindBy(xpath = "//div[.='Customer Copy']/../../../../div/div/div/div/div/div/div/app-checkbox/div/mat-checkbox[contains(.,'Print HA Balance')]")
		WebElement  Print_HA_Balance_CustomerCopy_ChkBox;
		
		@FindBy(xpath = "//div[.='Customer Copy']/../../../../div/div/div/div/div/div/div/app-checkbox/div/mat-checkbox[contains(.,'Print HA Balance')][contains(@class,'mat-checkbox-checked')]")
		WebElement  Print_HA_Balance_CustomerCopy_ChkBox_SLD;
		
		public WebElement Print_HA_Balance_CustomerCopy_CheckBox()
		{
			return Print_HA_Balance_CustomerCopy_ChkBox;
		}
		
		public WebElement Print_HA_Balance_CustomerCopy_CheckBox_Selected()
		{
			return Print_HA_Balance_CustomerCopy_ChkBox_SLD;
		}
		
		@FindBy(xpath = "//div[.='Customer Copy']/../../../../div/div/div/div/div/div/div/app-checkbox/div/mat-checkbox[contains(.,'Print Membership Balance')]")
		WebElement  Print_Membership_Balance_CustomerCopy_ChkBox;
		
		@FindBy(xpath = "//div[.='Customer Copy']/../../../../div/div/div/div/div/div/div/app-checkbox/div/mat-checkbox[contains(.,'Print Membership Balance')][contains(@class,'mat-checkbox-checked')]")
		WebElement  Print_Membership_Balance_CustomerCopy_ChkBox_SLD;
		
		public WebElement Print_Membership_Balance_CustomerCopy_CheckBox()
		{
			return Print_Membership_Balance_CustomerCopy_ChkBox;
		}
		
		public WebElement Print_Membership_Balance_CustomerCopy_CheckBox_Selected()
		{
			return Print_Membership_Balance_CustomerCopy_ChkBox_SLD;
		}
		
		@FindBy(xpath = "//img[@alt='Store Logo']")
		WebElement Store_LogoInTemplate;
		
		public void Verify_Store_Logo_inTemplate()
		{
			try
			{
				if(Store_LogoInTemplate.isDisplayed())
				{
					test.log(LogStatus.PASS, "Store Logo Displayed in Template");
				}
			}
			catch(Exception e)
			{
				test.log(LogStatus.FAIL, "Store Logo not Displayed in Template");
			}
		}
	
		
		@FindBy(xpath = "//div[contains(@class,'check-font-size')]/h6")
		WebElement Check_Number_Block1_InTemplate;
		
		public void Verify_Check_Number_Block1_inTemplate()
		{
			try
			{
				if(Check_Number_Block1_InTemplate.isDisplayed())
				{
					test.log(LogStatus.PASS, "Check Number is Displayed in Bloack 1 Template");
				}
			}
			catch(Exception e)
			{
				test.log(LogStatus.FAIL, "Check Number not Displayed in Block 1 Template");
			}
		}
}
