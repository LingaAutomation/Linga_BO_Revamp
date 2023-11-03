package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class UserManagementPage extends BasePage
{
	
	public UserManagementPage(SelfHealingDriver driver, ExtentTest test) {
//		super(driver, test);
//		// TODO Auto-generated constructor stub
//		this.driver=driver;
//		this.test=test;
//		
//		PageFactory.initElements(driver, this);
		
		super(driver, test);
	}

	@FindBy(xpath = "//button[contains(.,'NEW USER')]")
	WebElement New_User;
	
	@FindBy(xpath = "//span[contains(.,'Enable User Sign In')]/../../div[2]//mat-button-toggle[.='Yes']")
	WebElement Enable_User_SignIn_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Enable User Sign In')]/../../div[2]//mat-button-toggle[.='No']")
	WebElement Enable_User_SignIn_NoBtn;
	
	@FindBy(xpath = "//label[contains(.,'First Name')]/../../input")
	WebElement First_Name_Input;
	
	@FindBy(xpath = "//label[contains(.,'Last Name')]/../../input")
	WebElement Last_Name_Input;
	
	@FindBy(xpath = "//label[contains(.,'Language')]/../../input")
	WebElement Language_input;
	
	@FindBy(xpath = "//label[contains(.,'POS Initial Screen')]/../../input")
	WebElement POS_Initial_Screen_input;
	
	@FindBy(xpath = "//label[contains(.,' PIN ')]/../../input")
	WebElement PIN_input;
	
	@FindBy(xpath = "//label[contains(.,'Roles')]/../..//input")
	WebElement Role_input;
	
	@FindBy(xpath = "(//label[contains(.,'Password')]/../../input)[1]")
	WebElement PassWord_input;

//	@FindBy(xpath = "//app-input[@name='email']//input")
//	WebElement Email_input_DialogBox;
//
//	@FindBy(xpath = "//app-input[@name='password']//input")
//	WebElement PassWord_input_DialogBox;
//	
//	@FindBy(xpath = "//app-input[@name='confirmPassword']//input")
//	WebElement Confirm_PassWord_input_DialogBox;
	
	@FindBy(xpath = "//button[contains(.,'AUTHENTICATE')]")
	WebElement Authenticate_button;
	
	@FindBy(xpath = "//label[contains(.,'Gender')]/../..//input")
	WebElement Gender_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Date Of Birth')]/../../..//mat-datepicker-toggle/button")
	WebElement Date_Of_Birth_btn;
	
	@FindBy(xpath = "//label[contains(.,'Date Of Joining')]/../../..//mat-datepicker-toggle/button")
	WebElement Date_Of_Joining_btn;
	
	@FindBy(xpath = "//label[contains(.,'Phone Number')]/../..//input")
	WebElement Phone_NumberInputBx;
	
	@FindBy(xpath = "//label[contains(.,'E-Mail')]/../..//input")
	WebElement Email_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Employee Id')]/../../input")
	WebElement Employee_ID_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Address Line 1')]/../../input")
	WebElement Address_Line1_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Termination Date')]/../../..//mat-datepicker-toggle/button")
	WebElement Termination_Datebtn;
	
	@FindBy(xpath = "//label[contains(.,'Termination Reason')]/../../textarea")
	WebElement Termination_Reason_InputBx;
	
	@FindBy(xpath = "//span[contains(.,'Clock Required')]/../../div[2]//mat-button-toggle[.='Yes']")
	WebElement Clock_Required_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Clock Required')]/../../div[2]//mat-button-toggle[.='No']")
	WebElement Clock_Required_NoBtn;

	@FindBy(xpath = "//span[contains(.,'Do Auto Cashier Out')]/../../div[2]//mat-button-toggle[.='Yes']")
	WebElement Do_Auto_Cashier_Out_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Do Auto Cashier Out')]/../../div[2]//mat-button-toggle[.='No']")
	WebElement Do_Auto_Cashier_Out_NoBtn;

	@FindBy(xpath = "//span[contains(.,'Cash Tip')]/../../div[2]//mat-button-toggle[.='Yes']")
	WebElement Cash_Tip_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Cash Tip')]/../../div[2]//mat-button-toggle[.='No']")
	WebElement Cash_Tip_NoBtn;

	@FindBy(xpath = "//span[contains(.,'Sync To Schedule')]/../../div[2]//mat-button-toggle[.='Yes']")
	WebElement Sync_To_Schedule_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Sync To Schedule')]/../../div[2]//mat-button-toggle[.='No']")
	WebElement Sync_To_Schedule_NoBtn;
	
	@FindBy(xpath = "//label[contains(.,'Cash Tip Percent *')]/../../input")
	WebElement Cash_Tip_PercentageInputBx;
	
	@FindBy(xpath = "//button[contains(.,'Edit')]")
	WebElement Edit_Btn;
	
	@FindBy(xpath = "//button[contains(.,'Add Payroll')]")
	WebElement Add_Payroll_Btn;
	
	@FindBy(xpath = "//app-radio-box-button//div[@class='radio-box'][contains(.,'Hourly')]")
	WebElement Hourly_RadioBtn;
	
	@FindBy(xpath = "//app-radio-box-button//div[@class='radio-box'][contains(.,'Monthly')]")
	WebElement Monthly_RadioBtn;

	@FindBy(xpath = "//button[contains(.,'Enable Sign In')]")
	WebElement Enable_Sign_In_Btn;
	
	@FindBy(xpath = "//button[contains(.,'Disable Sign In')]")
	WebElement Disable_Sign_In_Btn;
	
	@FindBy(xpath = "//button[contains(.,'Reset Password')]")
	WebElement Reset_Password_Btn;
	
	@FindBy(xpath = "//button[contains(.,'Delete')]")
	WebElement Delete_Btn;
	
	
	
	public void Click_New_User()
	{
		new Common_XPaths(driver, test).Click_Button(New_User, "New User button Clicked");
	}
	
	public void Click_Edit()
	{
		new Common_XPaths(driver, test).Click_Button(Edit_Btn, "Edit button Clicked");
	}
	
	public void Click_Enable_Sign_In()
	{
		new Common_XPaths(driver, test).Click_Button(Enable_Sign_In_Btn, "Enable Sign In button Clicked");
	}
	
	public void Click_Disable_Sign_In()
	{
		new Common_XPaths(driver, test).Click_Button(Disable_Sign_In_Btn, "Disable Sign In button Clicked");
	}
	
	public void Click_Reset_Password()
	{
		new Common_XPaths(driver, test).Click_Button(Reset_Password_Btn, "Reset Password button Clicked");
	}
	
	public void Enable_User_Sign_In()
	{
		new Common_XPaths(driver, test).Enable_Toggle(Enable_User_SignIn_YesBtn, "Sign In Enabled");
	}
	

	public void Disable_Sign_In()
	{
		new Common_XPaths(driver, test).Disable_Toggle(Enable_User_SignIn_YesBtn, Enable_User_SignIn_NoBtn, "Sign In Disabled");
	}
	
	public void Enter_FirstName(String FirstName) throws Exception
	{
		new Common_XPaths(driver, test).Enter_Text(First_Name_Input, FirstName, "First Name Entered");
	}
	
	public void Enter_LastName(String LastName) throws Exception
	{
		new Common_XPaths(driver, test).Enter_Text(Last_Name_Input, LastName, "Last Name Entered");
	}
	
	public void Select_Gender(String Gender) throws Exception
	{
		new Common_XPaths(driver, test).Click_DropDown_withSelection(Gender_InputBx, Gender, "Gender Selected");
	}
	
	public void Select_Language(String Lang) throws Exception
	{
		new Common_XPaths(driver, test).Click_DropDown_withSelection(Language_input, Lang, "Language Selected");
	}
	
	
	public void Enter_Email_ID(String Email) throws Exception
	{
		new Common_XPaths(driver, test).Enter_Text(Email_InputBx, Email, "Email ID Entered");
	}
	
	public void Enter_PIN(String pin) throws Exception
	{
		new Common_XPaths(driver, test).Enter_Text(PIN_input, pin, "Pin Entered");
	}
	
	
	public void Select_POS_Initial_Screen(String POS) throws Exception
	{
		new Common_XPaths(driver, test).Click_DropDown_withSelection(POS_Initial_Screen_input, POS, "POS Initial Screen Selected");
	}
	
	
	public void Enter_Employee_ID(String EmpID) throws Exception
	{
		new Common_XPaths(driver, test).Enter_Text(Employee_ID_InputBx, EmpID, "Employee ID Entered");
	}
	
	public void Select_User_Roles(String Role) throws Exception
	{
		new Common_XPaths(driver, test).Click_DropDown_withSearchText(Role_input, Role, "User Role Selected");
	}
	
	public void Enter_Termination_Reason(String Reason) throws Exception
	{
		new Common_XPaths(driver, test).Enter_Text(Termination_Reason_InputBx, Reason, "Termination Reason Added");
	}
	
	public void Select_Date_of_Joining(String DOJ) throws Exception
	{
		Thread.sleep(1000); 
		Date_Of_Joining_btn.click();
		Thread.sleep(1000);
		
		
		Thread.sleep(1000);
//		Date_inSpecificDateInputBx.clear();
		Thread.sleep(500);
//		Date_inSpecificDateInputBx.sendKeys(SpecificDate);
		
		Thread.sleep(1000);
//		Date_inSpecificDateInputBx.click();
		Thread.sleep(500);
		new ReportsPage(driver, test).monthAndYear_Calender.click();
		String year = DOJ.substring(6,10);
		driver.findElement(By.xpath("//div[contains(.,'"+year+"') and contains(@class,'mat-calendar-body-today')]")).click();
		String months = DOJ.substring(3,5);
		String month = new ReportsPage(driver, test).selectMonth(months);
		driver.findElement(By.xpath("//div[contains(.,'"+month+"') and contains(@class,'mat-calendar-body')]")).click();
		String days = DOJ.substring(0,2);
		String day = new ReportsPage(driver, test).selectDate(days);
		driver.findElement(By.xpath("//div[contains(.,'"+day+"') and contains(@class,'mat-calendar-body')]")).click();
		//Date_inSpecificDateInputBx.clear();
		Thread.sleep(500);
		//Date_inSpecificDateInputBx.sendKeys(SpecificDate);
		
		test.log(LogStatus.INFO, "The specific date is : "+Utility.getProperty("Report_Specific_Date"));

	}
	
	public void Select_Date_of_Birth(String DOB) throws Exception
	{
		Thread.sleep(1000); 
		Date_Of_Birth_btn.click();
		Thread.sleep(1000);
		
		
		Thread.sleep(1000);
//		Date_inSpecificDateInputBx.clear();
		Thread.sleep(500);
//		Date_inSpecificDateInputBx.sendKeys(SpecificDate);
		
		Thread.sleep(1000);
//		Date_inSpecificDateInputBx.click();
		Thread.sleep(500);
		new ReportsPage(driver, test).monthAndYear_Calender.click();
		String year = DOB.substring(6,10);
		driver.findElement(By.xpath("//div[contains(.,'"+year+"') and contains(@class,'mat-calendar-body-today')]")).click();
		String months = DOB.substring(3,5);
		String month = new ReportsPage(driver, test).selectMonth(months);
		driver.findElement(By.xpath("//div[contains(.,'"+month+"') and contains(@class,'mat-calendar-body')]")).click();
		String days = DOB.substring(0,2);
		String day = new ReportsPage(driver, test).selectDate(days);
		driver.findElement(By.xpath("//div[contains(.,'"+day+"') and contains(@class,'mat-calendar-body')]")).click();
		//Date_inSpecificDateInputBx.clear();
		Thread.sleep(500);
		//Date_inSpecificDateInputBx.sendKeys(SpecificDate);
		
		test.log(LogStatus.INFO, "The specific date is : "+Utility.getProperty("Report_Specific_Date"));

	}
	
	public void Select_Termination_Date(String TOD) throws Exception
	{
		Thread.sleep(1000); 
		Termination_Datebtn.click();
		Thread.sleep(1000);
		
		
		Thread.sleep(1000);
//		Date_inSpecificDateInputBx.clear();
		Thread.sleep(500);
//		Date_inSpecificDateInputBx.sendKeys(SpecificDate);
		
		Thread.sleep(1000);
//		Date_inSpecificDateInputBx.click();
		Thread.sleep(500);
		new ReportsPage(driver, test).monthAndYear_Calender.click();
		String year = TOD.substring(6,10);
		driver.findElement(By.xpath("//div[contains(.,'"+year+"') and contains(@class,'mat-calendar-body-today')]")).click();
		String months = TOD.substring(3,5);
		String month = new ReportsPage(driver, test).selectMonth(months);
		driver.findElement(By.xpath("//div[contains(.,'"+month+"') and contains(@class,'mat-calendar-body')]")).click();
		String days = TOD.substring(0,2);
		String day = new ReportsPage(driver, test).selectDate(days);
		driver.findElement(By.xpath("//div[contains(.,'"+day+"') and contains(@class,'mat-calendar-body')]")).click();
		//Date_inSpecificDateInputBx.clear();
		Thread.sleep(500);
		//Date_inSpecificDateInputBx.sendKeys(SpecificDate);
		
		test.log(LogStatus.INFO, "The specific date is : "+Utility.getProperty("Report_Specific_Date"));

	}
	
	public void Enable_Clock_In_Required() throws Exception
	{
		new Common_XPaths(driver, test).Enable_Toggle(Clock_Required_YesBtn, "Clock In Required Toggle Enabled");
		
		
	}
	
	public void Disable_Clock_In_Required()
	{
		new Common_XPaths(driver, test).Disable_Toggle(Clock_Required_YesBtn, Clock_Required_NoBtn, "Clock In Required Toggle Disabled");
	}
	
	public WebElement Clock_Required_YesToggle()
	{
		return Clock_Required_YesBtn;
	}
	
	public void Enable_Do_Auto_CashierOut()
	{
		new Common_XPaths(driver, test).Enable_Toggle(Do_Auto_Cashier_Out_YesBtn, "Do Auto Cashier Out Toggle Enabled");
	}
	
	public void Disable_Do_Auto_CashierOut()
	{
		new Common_XPaths(driver, test).Disable_Toggle(Do_Auto_Cashier_Out_YesBtn, Do_Auto_Cashier_Out_NoBtn, "Do Auto Cashier Out Toggle Disabled");
	}
	
	public WebElement Do_Auto_Cashier_Out_YesToggle()
	{
		return Do_Auto_Cashier_Out_YesBtn;
	}
	
	public void Enable_Cash_Tip(String TipPer)
	{
		new Common_XPaths(driver, test).Enable_Toggle(Cash_Tip_YesBtn, "Cash Tip Toggle Enabled");
		
		try
		{
		if(Cash_Tip_PercentageInputBx.isDisplayed())
		{
			test.log(LogStatus.PASS, "Cash Tip Percentage Input is Displayed");
			
			Cash_Tip_PercentageInputBx.clear();
			Thread.sleep(1000);
			Cash_Tip_PercentageInputBx.sendKeys(TipPer);
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Cash Tip Percentage Input is not Displayed");
		}
	}
	
	public void Disable_Cash_Tip()
	{
		new Common_XPaths(driver, test).Disable_Toggle(Cash_Tip_YesBtn, Cash_Tip_NoBtn, "Cash Tip Toggle Disabled");
	}
	
	public WebElement Cash_Tip_YesToggle()
	{
		return Cash_Tip_YesBtn;
	}
	
	
	public WebElement Cash_Tip_PercentageInputBox()
	{
		return Cash_Tip_PercentageInputBx;
	}
	
	public void Enable_Sync_To_Schedule()
	{
		new Common_XPaths(driver, test).Enable_Toggle(Sync_To_Schedule_YesBtn, "Sync To Schedule Toggle Enabled");
	}
	
	public void Disable_Sync_To_Schedule()
	{
		new Common_XPaths(driver, test).Disable_Toggle(Sync_To_Schedule_YesBtn, Sync_To_Schedule_NoBtn, "Sync To Schedule Toggle Disabled");
	}
	
	public WebElement Sync_To_Schedule_YesToggle()
	{
		return Sync_To_Schedule_YesBtn;
	}
	
	public void Click_Add_Payroll()
	{
		new Common_XPaths(driver, test).Click_Button(Add_Payroll_Btn, "Add Payroll button Clicked");
	}
	
	public WebElement Hourly_RadioButton()
	{
		return Hourly_RadioBtn;
	}
	
	public WebElement Monthly_RadioButton()
	{
		return Monthly_RadioBtn;
	}
	
	@FindBy(xpath = "//input[@data-placeholder='Enter emailId']")
	WebElement EmailID_DialoginputBx;
	
	@FindBy(xpath = "//input[@data-placeholder='New Password']")
	WebElement New_Password_DialogInputBx;
	
	@FindBy(xpath = "//input[@data-placeholder='Confirm Password']")
	WebElement Confirm_Password_DialogInputBx;
	
	
	public void Enter_SignIn_Credentials(String EmailID,String Password) throws Exception
	{
		EmailID_DialoginputBx.clear();
		Thread.sleep(1000);
		EmailID_DialoginputBx.sendKeys(EmailID);
		
		New_Password_DialogInputBx.clear();
		Thread.sleep(1000);
		New_Password_DialogInputBx.sendKeys(Password);
		
		Confirm_Password_DialogInputBx.clear();
		Thread.sleep(1000);
		Confirm_Password_DialogInputBx.sendKeys(Password);
		
		
		Authenticate_button.click();
	
	}
	
	public void Enter_EmailID(String EmailID) throws Exception
	{
		EmailID_DialoginputBx.clear();
		Thread.sleep(1000);
		EmailID_DialoginputBx.sendKeys(EmailID);
		
	}
	
	public void Enter_New_Password(String NewPassword) throws Exception
	{
		New_Password_DialogInputBx.clear();
		Thread.sleep(1000);
		New_Password_DialogInputBx.sendKeys(NewPassword);
		
	}
	
	public void Enter_Confirm_Password(String ConfirmPassword) throws Exception
	{
		Confirm_Password_DialogInputBx.clear();
		Thread.sleep(1000);
		Confirm_Password_DialogInputBx.sendKeys(ConfirmPassword);
		
	}
	
	public void Click_Authenticate_Button()
	{
		Authenticate_button.click();
	}
	

	@FindBy(xpath = "//label[contains(.,'Price')]/../../input")
	WebElement Price_input;
	
	public void Enter_Price(String Price) throws Exception
	{
		Price_input.clear();
		Thread.sleep(1000);
		Price_input.sendKeys(Price);
		
	}
	
	public void Click_Delete()
	{
		new Common_XPaths(driver, test).Click_Button(Delete_Btn, "Delete button Clicked");
	}
	
	
	
	//////////////// Roles   ////////////////////////

	@FindBy(xpath = "//button[contains(.,'NEW ROLE')]")
	WebElement New_Role;
	
	@FindBy(xpath = "//mat-panel-title[contains(.,' BACK OFFICE ')]/..//mat-icon[.='keyboard_arrow_right']")
	WebElement BackOffice_RightArrow;
	
	@FindBy(xpath = "//mat-panel-title[contains(.,' BACK OFFICE ')]/..//mat-icon[.='keyboard_arrow_down']")
	WebElement BackOffice_DownArrow;
	
	@FindBy(xpath = "//mat-panel-title[contains(.,' POS OPERATIONS ')]/..//mat-icon[.='keyboard_arrow_right']")
	WebElement POS_Operations_RightArrow;
	
	@FindBy(xpath = "//mat-panel-title[contains(.,' POS OPERATIONS ')]/..//mat-icon[.='keyboard_arrow_down']")
	WebElement POS_Operations_DownArrow;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Select All')]")
	WebElement Select_All_Checkbx;
	
	public void Click_New_Role()
	{
		new Common_XPaths(driver, test).Click_Button(New_Role, "New Role button Clicked");
	}
	
	public void Open_BackOffice_Screen()
	{
		try
		{
			if(BackOffice_RightArrow.isDisplayed())
			{
				BackOffice_RightArrow.click();
			}
		}
		catch(Exception k) {}
	}
	
	public void Close_BackOffice_Screen()
	{
		try
		{
			if(BackOffice_DownArrow.isDisplayed())
			{
				BackOffice_DownArrow.click();
			}
		}
		catch(Exception k) {}
	}
	
	public void Open_POS_Screen()
	{
		try
		{
			if(BackOffice_RightArrow.isDisplayed())
			{
				BackOffice_RightArrow.click();
			}
		}
		catch(Exception k) {}
	}
	
	public void Close_POS_Screen()
	{
		try
		{
			if(BackOffice_DownArrow.isDisplayed())
			{
				BackOffice_DownArrow.click();
			}
		}
		catch(Exception k) {}
	}
	
	public void Open_POS_Operations_Screen()
	{
		try
		{
			if(POS_Operations_RightArrow.isDisplayed())
			{
				POS_Operations_RightArrow.click();
			}
		}
		catch(Exception k) {}
	}
	
	public void Close_POS_Operations_Screen()
	{
		try
		{
			if(POS_Operations_DownArrow.isDisplayed())
			{
				POS_Operations_DownArrow.click();
			}
		}
		catch(Exception k) {}
	}
	
	public WebElement Select_All_CheckBox()
	{
		return Select_All_Checkbx;
	}
	
	@FindBy(xpath = "//span[contains(.,'Enable POS Login')]/../../div[2]//mat-button-toggle[.='Yes']")
	WebElement Enable_POS_Login_YesBtn;

 

	public void Enable_POS_Login()
	{
		new Common_XPaths(driver, test).Enable_Toggle(Enable_POS_Login_YesBtn, "Enable POS Login Toggle Enabled");
	}
	
	@FindBy(xpath = "//label[contains(.,'Email')]/../..//input")
	WebElement Email_InputBx2;
	public void Enter_Email_ID2(String Email) throws Exception
	{
		new Common_XPaths(driver, test).Enter_Text(Email_InputBx2, Email, "Email ID Entered");
	}
	
	@FindBy(xpath = "//button[contains(.,'ACTIVE')]")
	WebElement EnableActive_InactiveBtn;

	public void Click_ActivetoInactiveButton()
	{
		EnableActive_InactiveBtn.click();
	}
	
	@FindBy(xpath = "//label[contains(.,' Rename Sub Recipe ')]/../../input")
	WebElement Rename_Sub_Recipe_input;

	@FindBy(xpath = "//label[contains(.,'Rename Prepare Sub Recipe')]/../../input")
	WebElement Rename_Sub_Prepare_Recipe_input;

 

			
	public void Enter_Rename_Sub_Recipe(String str) throws Exception
	{
		new Common_XPaths(driver, test).Enter_Text(Rename_Sub_Recipe_input, str, "Rename_Sub_Recipe Name Entered");
	}

 

	public void Enter_Rename_Sub_Prepare_Recipe(String str) throws Exception
	{
		new Common_XPaths(driver, test).Enter_Text(Rename_Sub_Prepare_Recipe_input, str, "Rename_Sub_Prepare_Recipe Name Entered");
	}
	
	@FindBy(xpath = "//span[contains(.,'Customization')]/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes'][contains(@aria-pressed,'true')]")
	WebElement Verify_Customization_Yes_button;
	
	@FindBy(xpath = "//span[contains(.,'Customization')]/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No']")
	WebElement Customization_No_button;
	
	public void Disable_Customize()
	{
		if(Verify_Customization_Yes_button.isDisplayed()) {


			Customization_No_button.click();
		}
	}
	
	@FindBy(xpath = "//span[contains(.,'Customization')]/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No'][contains(@aria-pressed,'true')]")
	WebElement Verify_Customization_No_button;
	
	@FindBy(xpath = "//span[contains(.,'Customization')]/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
	WebElement Customization_Yes_button;

	public void Enabale_Customize()
	{
		if(Verify_Customization_No_button.isDisplayed()) {


			Customization_Yes_button.click();
		}
	}
	
	@FindBy(xpath = "//p[contains(.,'Select Warehouse')]/../../div[3]/b[contains(@class,'add-button')]/button")
	WebElement Central_Warehouse_SelectAll_button;
	
	@FindBy(xpath = "//p[contains(.,'Select Warehouse')]/../../div[3]/b[contains(@class,'add-button')]/button//span/span[contains(.,'Unselect All')]")
	WebElement Central_Warehouse_UnSelectAll_button;

	public void Enable_all_Central_Warehouse() throws InterruptedException
	{
		Thread.sleep(2000);
		Central_Warehouse_SelectAll_button.click();
		Thread.sleep(2000);
		Central_Warehouse_UnSelectAll_button.click();
		Thread.sleep(2000);

 

		Central_Warehouse_SelectAll_button.click();

		 List<WebElement> Kitch = driver.findElements(By.xpath("//p[contains(.,'Select Warehouse')]/../../../div[3]/div/div"));

		 
			for(int i=1;i<=Kitch.size();i++) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//p[contains(.,'Select Warehouse')]/../../../div[3]/div/div["+i+"]/div[3]")).click();

			}

			Thread.sleep(2000);
	}
	
	@FindBy(xpath = "//span[contains(.,'Central Warehouse')]/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No'][contains(@aria-pressed,'true')]")
	WebElement Verify_Central_Warehouse_No_button;

 

	@FindBy(xpath = "//span[contains(.,'Central Warehouse')]/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
	WebElement Central_Warehouse_Yes_button;

 

	public void Enabale_Central_Warehouse()
	{
		if(Verify_Central_Warehouse_No_button.isDisplayed()) {

			Central_Warehouse_Yes_button.click();
		}
	}	
	
	@FindBy(xpath = "//p[contains(.,'Select Kitchen')]/../../div[3]/b[contains(@class,'add-button')]/button")
	WebElement Central_Kitchen_SelectAll_button;
@FindBy(xpath = "//p[contains(.,'Select Kitchen')]/../../div[3]/b[contains(@class,'add-button')]/button//span/span[contains(.,'Unselect All')]")
	WebElement Central_Kitchen_UnSelectAll_button;

 

public void Enable_all_Central_kitchen() throws InterruptedException
	{

		Central_Kitchen_SelectAll_button.click();

		Thread.sleep(2000);

		Central_Kitchen_UnSelectAll_button.click();
		Thread.sleep(2000);
		Central_Kitchen_SelectAll_button.click();
		Thread.sleep(2000);
		 List<WebElement> Kitch = driver.findElements(By.xpath("//p[contains(.,'Select Kitchen')]/../../../div[3]/div/div"));

			for(int i=1;i<=Kitch.size();i++) {
				Thread.sleep(2000);
				driver.findElement(By.xpath("//p[contains(.,'Select Kitchen')]/../../../div[3]/div/div["+i+"]/div[3]")).click();

			}

 

			Thread.sleep(2000);
	}

@FindBy(xpath = "//span[contains(.,'Central Kitchen')]/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='No'][contains(@aria-pressed,'true')]")
WebElement Verify_Central_Kitchen_No_button;



@FindBy(xpath = "//span[contains(.,'Central Kitchen')]/../../div[2]/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
WebElement Central_Kitchen_Yes_button;



public void Enabale_Central_kitchen()
{
	if(Verify_Central_Kitchen_No_button.isDisplayed()) {

		Central_Kitchen_Yes_button.click();
	}
}	

@FindBy(xpath = "//label[contains(.,'Store')]/../..//input")
WebElement Store_input;



public void Select_Store_input() throws Exception
{
	cmp=new Common_XPaths(driver, test);



	//driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
	for(int i=1;i<=1;i++)
	{
		Thread.sleep(1000);
		Store_input.click();
	Thread.sleep(1000);


	List<WebElement> CategoryList=driver.findElements(By.xpath("//div/select-option"));

	int CategorySize=CategoryList.size();

	System.out.println(CategorySize);

//	try
//	{
	Thread.sleep(1000);
	List<WebElement> departList=driver.findElements(By.xpath("//div/select-option"));

	int deptSize=departList.size();


	int randomDept=ThreadLocalRandom.current().nextInt(1, deptSize);


	Thread.sleep(10000);
	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
	driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
	Thread.sleep(2000);
	try {
	driver.findElement(By.xpath("//select-option/div/../../cdk-virtual-scroll-viewport/div/div['"+randomDept+"']")).click();

	}
	catch (Exception e) {
		driver.findElement(By.xpath("//select-option/div/../../cdk-virtual-scroll-viewport/div/div['"+randomDept+"']")).click();
	}
	Thread.sleep(5000);
	//List<WebElement> departList1=driver.findElements(By.xpath("//div/select-option"));
		Store_input.click();

//	}
//	catch(Exception e)
//	{
//		cmp.FirstOption_DropBtn.click();
//	}

		}

	}


@FindBy(xpath = "//app-input[@name='password']/..//input")
WebElement New_Password;

@FindBy(xpath = "//app-input[@name='confirmPassword']/..//input")
WebElement Confirm_Password;


public void Enter_ConfirmPassword(String ConfirmPassword) throws Exception
{
	Confirm_Password.clear();
	Thread.sleep(1000);
	Confirm_Password.sendKeys(ConfirmPassword);

}

public void Enter_NewPassword(String NewPassword) throws Exception
{
	New_Password.clear();
	Thread.sleep(1000);
	New_Password.sendKeys(NewPassword);

}

@FindBy(xpath = "//label[contains(.,'Date of joining')]/../../..//mat-datepicker-toggle/button ")
WebElement Date_Of_Joining_btn2;

public void Select_Date_of_Joining2(String DOJ) throws Exception
{
	Thread.sleep(1000); 
	Date_Of_Joining_btn2.click();
	Thread.sleep(1000);


	Thread.sleep(1000);
//	Date_inSpecificDateInputBx.clear();
	Thread.sleep(500);
//	Date_inSpecificDateInputBx.sendKeys(SpecificDate);

	Thread.sleep(1000);
//	Date_inSpecificDateInputBx.click();
	Thread.sleep(500);
	new ReportsPage(driver, test).monthAndYear_Calender.click();
	String year = DOJ.substring(6,10);
	driver.findElement(By.xpath("//div[contains(.,'"+year+"') and contains(@class,'mat-calendar-body-today')]")).click();
	String months = DOJ.substring(3,5);
	String month = new ReportsPage(driver, test).selectMonth(months);
	driver.findElement(By.xpath("//div[contains(.,'"+month+"') and contains(@class,'mat-calendar-body')]")).click();
	String days = DOJ.substring(0,2);
	String day = new ReportsPage(driver, test).selectDate(days);
	driver.findElement(By.xpath("//div[contains(.,'"+day+"') and contains(@class,'mat-calendar-body')]")).click();
	//Date_inSpecificDateInputBx.clear();
	Thread.sleep(500);
	//Date_inSpecificDateInputBx.sendKeys(SpecificDate);

	test.log(LogStatus.INFO, "The specific date is : "+Utility.getProperty("Report_Specific_Date"));

	}

	@FindBy(xpath = "//button[contains(.,'NEW ACCOUNT USER')]")
	WebElement New_Account_User;

	public void Click_New_Account_User()
	{
		new Common_XPaths(driver, test).Click_Button(New_Account_User, "New Account User button Clicked");
	}

	@FindBy(xpath = "//button[contains(.,'INACTIVE')]")
	WebElement EnableInactive_ActiveBtn;
	
	public void Click_InactivetoActiveButton()
	{
		EnableInactive_ActiveBtn.click();
	}	

}
