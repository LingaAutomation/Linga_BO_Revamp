package com.Pages;

import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class UserMangement_Role_Page {
	
	public WebDriver driver;
	public ExtentTest test;
	Utility ut=new Utility();
	Common_XPaths cmp;
	String UserName;
	String Password;
	
	
	public UserMangement_Role_Page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath = "//button[contains(.,' NEW ROLE ')]")
	WebElement Role_Button;
	
	
	@FindBy(xpath = "//label[contains(.,'Name')]/../..")
	WebElement UserName_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Priority')]/../../input")
	WebElement Priority_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Role Id')]/../../input")
	WebElement Role_Id_InputBx;
	
	@FindBy(xpath = "//mat-panel-title[contains(.,' BACK OFFICE ')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'No')]")
	WebElement  BACK_OFFICE_NO;
	@FindBy(xpath = "//mat-panel-title[contains(.,' BACK OFFICE ')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'Yes')]")
	WebElement  BACK_OFFICE_YES;
	
	

	@FindBy(xpath = "//button[contains(.,'arrow_drop_up')]")
	WebElement UpArow;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Select All')][contains(@class,'mat-checkbox')]")
	WebElement Select_All_BackOFFICE;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'MENU CONFIGURATION')][contains(@class,'mat-checkbox')]")
	WebElement MENU_CONFIGURATION_BackOFFICE;
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'GRATUITY')][contains(@class,'mat-checkbox')]")
	WebElement GRATUITY_BackOFFICE;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'GIFT CARD')][contains(@class,'mat-checkbox')]")
	WebElement GiftCard_BackOFFICE;
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'TAX SETTINGS')][contains(@class,'mat-checkbox')]")
	WebElement TAX_SETTINGS_BackOFFICE;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'STORE SETTINGS')][contains(@class,'mat-checkbox')]")
	WebElement STORE_SETTINGS_BackOFFICE;
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'STORE INFO')][contains(@class,'mat-checkbox')]")
	WebElement STORE_INFO_BackOFFICE;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'REPORT')][contains(@class,'mat-checkbox')]")
	WebElement Report_BackOFFICE;
	
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'DISCOUNT SETTING')][contains(@class,'mat-checkbox')]")
	WebElement DISCOUNT_SETTING_BackOFFICE;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'INVENTORY SETTING')][contains(@class,'mat-checkbox')]")
	WebElement INVENTORY_SETTING_BackOFFICE;
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'CUSTOMER')][contains(@class,'mat-checkbox')]")
	WebElement Customer_BackOFFICE;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'USER MANAGEMENT')][contains(@class,'mat-checkbox')]")
	WebElement USER_MANAGEMENT_BackOFFICE;
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'DISABLE BACK OFFICE LOGIN')][contains(@class,'mat-checkbox')]")
	WebElement DISABLE_BACK_OFFICE_LOGIN_BackOFFICE;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'BATCH')][contains(@class,'mat-checkbox')]")
	WebElement BATCH_BackOFFICE;
	
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'LOYALTY POINT ADJUSTMENT')][contains(@class,'mat-checkbox')]")
	WebElement LOYALTY_POINT_ADJUSTMENT_BackOFFICE;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'SHOW INVENTORY COUNT IN ADJUSTMENT')][contains(@class,'mat-checkbox')]")
	WebElement SHOW_INVENTORY_COUNT_IN_ADJUSTMENT_BackOFFICE;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'ROS CARD')][contains(@class,'mat-checkbox')]")
	WebElement ROS_CARD_BackOFFICE;
	
	
	@FindBy(xpath = "//button[contains(.,'Edit')]")
	WebElement Edit_Role_Btn;
	
	
	
	
	@FindBy(xpath = "//button[contains(.,'NEW USER')]")

	WebElement New_User_Btn;
	
	
	@FindBy(xpath = "//label[contains(.,'Last Name')]/../../input")
	WebElement Last_name_Input;
	
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

	@FindBy(xpath = "//app-input[@name='email']//input")
	WebElement Email_input_DialogBox;
	
	
	
	@FindBy(xpath = "//app-input[@label='E-Mail']//input")
	WebElement Email_input;

	
	@FindBy(xpath = "//app-input[@name='password']//input")
	WebElement PassWord_input_DialogBox;
	
	@FindBy(xpath = "//app-input[@name='confirmPassword']//input")
	WebElement Confirm_PassWord_input_DialogBox;
	
	
	@FindBy(xpath = "//button[contains(.,'AUTHENTICATE')]")
	WebElement Authenticate_button;

	@FindBy(xpath = "//div[contains(@id,'option-panel')]/..//app-input[contains(@placeholder,'Search')]/div/div/mat-form-field/div//input")
	WebElement SearchBox;
	
	
	
	@FindBy(xpath = "//div[contains(@classlist,'user-dropdown')]/div[contains(@class,'profile-name')]")
	WebElement DropDown_profile;
	
	
	@FindBy(xpath = "//button[contains(.,'Logout')]")
	WebElement LogOut;
	
	
	public WebElement LogOut(){
		return LogOut ;
	}
	
	public WebElement DropDown_profile(){
		return DropDown_profile ;
	}
	
	public void New_User_Btn(){
		New_User_Btn.click();
	}
	
	
	public WebElement Last_name_Input(){
		return Last_name_Input ;
	}
	
	public WebElement Email_input(){
		return Email_input ;
	}
	
	public WebElement PIN_input(){
		return PIN_input ;
	}
	
	public WebElement PassWord_input(){
		return PassWord_input ;
	}
	
	
	
	
	public WebElement Email_input_DialogBox(){
		return Email_input_DialogBox ;
	}
	
	public WebElement PassWord_input_DialogBox(){
		return PassWord_input_DialogBox ;
	}
	
	public WebElement Confirm_PassWord_input_DialogBox(){
		return Confirm_PassWord_input_DialogBox ;
	}

	public WebElement Authenticate_button(){
		return Authenticate_button ;
	}



	
	public void Verify_Search(String SearchValue) throws Exception
	{
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(8000);
	}
			
	@FindBy(xpath = "//h4[contains(.,'Log In')]")
	WebElement LoginPageHeaderText;
	public void VerifyLoginPageHeader()
	{
		
		if(LoginPageHeaderText.getText().equalsIgnoreCase("Log In"))
		{
			test.log(LogStatus.PASS, "Login Page Loaded Successfully");
			
			String scnsht=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			String s="data:image/png;base64,"+scnsht;
			
			test.log(LogStatus.PASS, test.addScreenCapture(s));
		}
		else
		{
			test.log(LogStatus.FAIL, "Login page loading Failed");
			
			String scnsht=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			String s="data:image/png;base64,"+scnsht;
			
			test.log(LogStatus.FAIL, test.addScreenCapture(s));
		}
	}
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement Username;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement Password21;
	
	@FindBy(xpath = "//button[contains(.,'LOG IN')]")
	WebElement LoginBtn;
	
	@FindBy(xpath = "//b[@class='text-primary cursor-pointer']")
	WebElement ForgotPasswordCursorBtn;
	
	@FindBy(xpath = "//span[contains(.,'Create an Account')]")
	WebElement CreateNewAccountBtn;
	
	@FindBy(xpath = "//mat-icon[contains(.,'visibility')]")
	WebElement VisibilityIconBtn;
	
	@FindBy(xpath = "//app-input[@placeholder='Search']/div/div/mat-form-field/div/div/div[4]/input")
	WebElement SearchBox_inStores;
	
	@FindBy(xpath = "//app-stores/div/div[2]/div[2]/div[1]/div")
	WebElement First_StoreInStoresList;
	
	@FindBy(xpath = "//div[@class='profile']")
	WebElement Profile_Tab;
	
	@FindBy(xpath = "//div[.='Logout']")
	WebElement Log_OutBtn;
	
	@FindBy(xpath = "//div[.='Edit Profile']")
	WebElement Edit_ProfileBtn;
	
	@FindBy(xpath = "//div[.='Change Password']")
	WebElement Change_PasswordBtn;
	
	@FindBy(xpath = "//div[.='Support']")
	WebElement Support_Btn;
	
	

	//mat-icon[@role='img']
	public void EnterUsername(String username)
	{
		Username.sendKeys(username);
	}
	
	public void EnterPassword(String password)
	{
		Password21.sendKeys(password);
	}
	
	public void ClickLoginButton()
	{
		LoginBtn.click();
	}
	
	public void Login(String username,String password) throws Exception
	{
		Thread.sleep(500);
		
		Username.sendKeys(username);
		
		Thread.sleep(500);
		Password21.sendKeys(password);
		
		Thread.sleep(1000);
		LoginBtn.click();
		
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//h3[contains(.,'Welcome to the new Back Office. Here’s what’s changed')]")).isDisplayed())
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(.,'Continue')]")).click();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//button[contains(.,'GOT IT')]")).click();
		}
		
		Thread.sleep(3000);
		driver.get(Utility.getProperty("Enterprise_Base_URL"));
		
		Thread.sleep(3000);
		SearchBox_inStores.clear();
		Thread.sleep(1000);
		SearchBox_inStores.sendKeys(Utility.getProperty("Store1"));
		
		Thread.sleep(2000);
		First_StoreInStoresList.click();
		Thread.sleep(2000);
	
	}
	
	
	public void Select_Langauage() throws InterruptedException
	{
		
		cmp=new Common_XPaths(driver, test);
		
	
		Language_input.click();
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
			
		
	}
	
	public void Select_MailAdressANDPassword(String str) throws InterruptedException
	{
		
		cmp=new Common_XPaths(driver, test);
		
		Email_input_DialogBox.clear();
		Thread.sleep(2000);
		Email_input_DialogBox.sendKeys("Sam"+str+"@mail.com");
		Thread.sleep(2000);
		
		PassWord_input_DialogBox.clear();
		Thread.sleep(2000);
		String pass = RandomStringUtils.randomAlphanumeric(4);
		
		String PassWord = "S"+pass+"#";
		PassWord_input_DialogBox.sendKeys(PassWord);
		Thread.sleep(2000);
		
		Confirm_PassWord_input_DialogBox.clear();
		Thread.sleep(2000);
		Confirm_PassWord_input_DialogBox.sendKeys(PassWord);
		
		Thread.sleep(2000);
		Authenticate_button.click();
	
		
	}
	
	public void Select_PosInitialScreen() throws InterruptedException
	{
		
		cmp=new Common_XPaths(driver, test);
		
	
		POS_Initial_Screen_input.click();
		Thread.sleep(3000);
	    driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
			
		
	}
	public void Select_Roles(String str) throws InterruptedException
	{
		
		cmp=new Common_XPaths(driver, test);		
			
		Role_input.click();
		Thread.sleep(2000);
		Role_input.sendKeys(str);
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//select-option//div[1]/div[contains(.,'"+str+"')]/div")).click();
			
	}
	
	
	
	public void Click_New_Role_Button()
	{
		Role_Button.click();
	}
	
	
	public void EnterRole_Name(String str,String Role_Id) throws InterruptedException
	{
		
		cmp=new Common_XPaths(driver, test);
		
		cmp.NameInputBox.clear();
		Thread.sleep(2000);
		cmp.NameInputBox.sendKeys(str);
		String priority = RandomStringUtils.randomNumeric(1);
		Priority_InputBx.clear();
		Thread.sleep(2000);
		Priority_InputBx.sendKeys(priority);
		Thread.sleep(2000);
		UpArow.click();
		Thread.sleep(2000);
		
		
		Role_Id_InputBx.clear();
		Thread.sleep(2000);
		Role_Id_InputBx.sendKeys(Role_Id);
		
	}
	
	public void Enable_BackOFFICE_YES() throws InterruptedException
	{
		
		if(BACK_OFFICE_NO.isEnabled()) {
			BACK_OFFICE_YES.click();
		}
		
	}
	
	
	public void Disable_BackOFFICE_YES() throws InterruptedException
	{
		
		if(BACK_OFFICE_YES.isEnabled()) {
			BACK_OFFICE_NO.click();
		}
		
	}
	
	public void Verify_Select_ALL_is_Disable_IN_BackOFFICE() throws InterruptedException
	{
		
		if(!Select_All_BackOFFICE.isEnabled()) {
			test.log(LogStatus.INFO, "Select All in back office not enbled");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	public void Verify_Select_ALL_is_Enable_IN_BackOFFICE() throws InterruptedException
	{
		Select_All_BackOFFICE.click();
		
		Thread.sleep(2000);
		if(Select_All_BackOFFICE.isEnabled()) {
			test.log(LogStatus.INFO, "Select All in back office  enbled");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}

	

	public void Enable_ALL_IN_BackOFFICE() throws InterruptedException
	{
		Select_All_BackOFFICE.click();
		
		MENU_CONFIGURATION_BackOFFICE.click();
		Thread.sleep(2000);
		GRATUITY_BackOFFICE.click();
		Thread.sleep(2000);
		GiftCard_BackOFFICE.click();
		Thread.sleep(2000);
		TAX_SETTINGS_BackOFFICE.click();
		Thread.sleep(2000);
		STORE_SETTINGS_BackOFFICE.click();
		Thread.sleep(2000);
		STORE_INFO_BackOFFICE.click();
		Thread.sleep(2000);
		Report_BackOFFICE.click();
		Thread.sleep(2000);
		DISCOUNT_SETTING_BackOFFICE.click();
		Thread.sleep(2000);
		INVENTORY_SETTING_BackOFFICE.click();
		Thread.sleep(2000);
		Customer_BackOFFICE.click();
		Thread.sleep(2000);
		USER_MANAGEMENT_BackOFFICE.click();
		Thread.sleep(2000);
		DISABLE_BACK_OFFICE_LOGIN_BackOFFICE.click();
		Thread.sleep(2000);
		BATCH_BackOFFICE.click();
		Thread.sleep(2000);
		LOYALTY_POINT_ADJUSTMENT_BackOFFICE.click();
		Thread.sleep(2000);
		SHOW_INVENTORY_COUNT_IN_ADJUSTMENT_BackOFFICE.click();
		Thread.sleep(2000);
		ROS_CARD_BackOFFICE.click();
		Thread.sleep(2000);
		
		DISABLE_BACK_OFFICE_LOGIN_BackOFFICE.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//mat-panel-title[contains(.,' BACK OFFICE ')]")).click();
		Thread.sleep(2000);
	}
	public void Disable_ALL_IN_BackOFFICE() throws InterruptedException
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//mat-panel-title[contains(.,' BACK OFFICE ')]")).click();
		Thread.sleep(2000);
		MENU_CONFIGURATION_BackOFFICE.click();
		Thread.sleep(2000);
		GRATUITY_BackOFFICE.click();
		Thread.sleep(2000);
		GiftCard_BackOFFICE.click();
		Thread.sleep(2000);
		TAX_SETTINGS_BackOFFICE.click();
		Thread.sleep(2000);
		STORE_SETTINGS_BackOFFICE.click();
		Thread.sleep(2000);
		STORE_INFO_BackOFFICE.click();
		Thread.sleep(2000);
		Report_BackOFFICE.click();
		Thread.sleep(2000);
		DISCOUNT_SETTING_BackOFFICE.click();
		Thread.sleep(2000);
		INVENTORY_SETTING_BackOFFICE.click();
		Thread.sleep(2000);
		Customer_BackOFFICE.click();
		Thread.sleep(2000);
		USER_MANAGEMENT_BackOFFICE.click();
		Thread.sleep(2000);
		DISABLE_BACK_OFFICE_LOGIN_BackOFFICE.click();
		Thread.sleep(2000);
		BATCH_BackOFFICE.click();
		Thread.sleep(2000);
		LOYALTY_POINT_ADJUSTMENT_BackOFFICE.click();
		Thread.sleep(2000);
		SHOW_INVENTORY_COUNT_IN_ADJUSTMENT_BackOFFICE.click();
		Thread.sleep(2000);
		ROS_CARD_BackOFFICE.click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//mat-panel-title[contains(.,' BACK OFFICE ')]")).click();
		Thread.sleep(2000);
	}
	
	
	@FindBy(xpath = "(//mat-panel-title[contains(.,'POS')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'No')])[1]")
	WebElement  POS_NO;
	@FindBy(xpath = "(//mat-panel-title[contains(.,'POS')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'Yes')])[1]")
	WebElement  POS_YES;
	
	public void Enable_Pos() throws InterruptedException {
		
		if(POS_NO.isEnabled()) {
			Thread.sleep(2000);
			POS_YES.click();
		}
		
		Thread.sleep(4000);
		Select_All_BackOFFICE.click();
		Thread.sleep(4000);
		
		List<WebElement> checkBoxs = driver.findElements(By.xpath("(//mat-panel-title[contains(.,'POS')])[1]/../../..//mat-checkbox[contains(@class,'mat-checkbox')]"));
		
		for(WebElement checkBox:checkBoxs) {
			
			if(!checkBox.isSelected()) {
				Thread.sleep(2000);
				checkBox.click();
			}
			
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//mat-panel-title[contains(.,'POS')])[1]")).click();
		Thread.sleep(2000);
		
	}
	
	
	@FindBy(xpath = "//mat-panel-title[contains(.,'POS OPERATION')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'No')]")
	WebElement  POS_Operation_NO;
	@FindBy(xpath = "//mat-panel-title[contains(.,'POS OPERATION')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'Yes')]")
	WebElement  POS_Operation_YES;
public void Enable_Pos_Operation() throws InterruptedException {
		
		if(POS_Operation_NO.isEnabled()) {
			Thread.sleep(2000);
			POS_Operation_YES.click();
		}
		
		Thread.sleep(4000);
		Select_All_BackOFFICE.click();
		Thread.sleep(4000);
		
		List<WebElement> checkBoxs = driver.findElements(By.xpath("//mat-panel-title[contains(.,'POS OPERATION')]/../../..//mat-checkbox[contains(@class,'mat-checkbox')]"));
		
		for(WebElement checkBox:checkBoxs) {
			
			if(!checkBox.isSelected()) {
				Thread.sleep(2000);
				checkBox.click();
			}
			
		}
		
		Thread.sleep(2000);
		driver.findElement(By.xpath("//mat-panel-title[contains(.,'POS OPERATION')]")).click();
		Thread.sleep(2000);
		
	}


@FindBy(xpath = "//mat-panel-title[contains(.,'REPORT ACCESS')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'No')]")
WebElement  REPORT_ACCESS_NO;
@FindBy(xpath = "//mat-panel-title[contains(.,'REPORT ACCESS')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'Yes')]")
WebElement  REPORT_ACCESS_YES;
public void Enable_REPORT_ACCESS() throws InterruptedException {
	
	if(REPORT_ACCESS_NO.isEnabled()) {
		Thread.sleep(2000);
		REPORT_ACCESS_YES.click();
	}
	
	Thread.sleep(5000);
	driver.findElement(By.xpath("(//mat-checkbox[contains(.,'Select All')][contains(@class,'mat-checkbox')])[2]")).click();
	Thread.sleep(5000);
	
	List<WebElement> checkBoxs = driver.findElements(By.xpath("//mat-panel-title[contains(.,'REPORT ACCESS')]/../../..//mat-checkbox[contains(@class,'mat-checkbox')]"));
	
	for(WebElement checkBox:checkBoxs) {
		
		if(!checkBox.isSelected()) {
			Thread.sleep(2000);
			checkBox.click();
		}
		
	}
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//mat-panel-title[contains(.,'REPORT ACCESS')]")).click();
	Thread.sleep(2000);
	
}

	
@FindBy(xpath = "//mat-panel-title[contains(.,'DASH BOARD')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'No')]")
WebElement  DASH_BOARD_NO;
@FindBy(xpath = "//mat-panel-title[contains(.,'DASH BOARD')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'Yes')]")
WebElement  DASH_BOARD_YES;
public void Enable_DASH_BOARD() throws InterruptedException {
	
	if(DASH_BOARD_NO.isEnabled()) {
		Thread.sleep(2000);
		DASH_BOARD_YES.click();
	}
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//mat-panel-title[contains(.,'DASH BOARD')]")).click();
	Thread.sleep(2000);
	
	Thread.sleep(2000);
//	Select_All_BackOFFICE.click();
	Thread.sleep(2000);
	
	List<WebElement> checkBoxs = driver.findElements(By.xpath("//mat-panel-title[contains(.,'DASH BOARD')]/../../..//mat-checkbox[contains(@class,'mat-checkbox')]"));
	
	for(WebElement checkBox:checkBoxs) {
		
		if(!checkBox.isSelected()) {
			Thread.sleep(2000);
			checkBox.click();
		}
		
	}
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//mat-panel-title[contains(.,'DASH BOARD')]")).click();
	Thread.sleep(2000);
	
}

public void Verify_ReportHomePage(String str)
{
	if(driver.findElement(By.xpath("//a[contains(@class,'mat-tab-label-active')][contains(.,'"+str+"')]")).isDisplayed())
	{
		test.log(LogStatus.PASS, str+" Report Page Loaded Successfully");
		
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
	}
	else
	{
		test.log(LogStatus.PASS, str+" Report Page Loading Failed");
		
		ut.FailedCaptureScreenshotAsBASE64(driver, test);
	}
}

public void Enable_Report_ACCESS() throws InterruptedException {
	
	if(DASH_BOARD_NO.isEnabled()) {
		Thread.sleep(2000);
		DASH_BOARD_YES.click();
	}
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//mat-panel-title[contains(.,'REPORT ACCESS')]")).click();
	Thread.sleep(2000);
	
	Thread.sleep(2000);
//	Select_All_BackOFFICE.click();
	Thread.sleep(2000);
	
	List<WebElement> checkBoxs = driver.findElements(By.xpath("//mat-panel-title[contains(.,'DASH BOARD')]/../../..//mat-checkbox[contains(@class,'mat-checkbox')]"));
	
	for(WebElement checkBox:checkBoxs) {
		
		if(!checkBox.isSelected()) {
			Thread.sleep(2000);
			checkBox.click();
		}
		
	}
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//mat-panel-title[contains(.,'REPORT ACCESS')]")).click();
	Thread.sleep(2000);
	
}

/*
public void Disable_DASH_BOARD() throws InterruptedException {
	

	Thread.sleep(2000);
	driver.findElement(By.xpath("//mat-panel-title[contains(.,'DASH BOARD')]")).click();
	Thread.sleep(2000);
	
	Thread.sleep(2000);
//	Select_All_BackOFFICE.click();
	Thread.sleep(2000);
	
	List<WebElement> checkBoxs = driver.findElements(By.xpath("//mat-panel-title[contains(.,'DASH BOARD')]/../../..//mat-checkbox[contains(@class,'mat-checkbox')]"));
	
	for( int i = 2 ; i <=checkBoxs.size(); i) {
		
	
		
	}
	
	Thread.sleep(2000);
	driver.findElement(By.xpath("//mat-panel-title[contains(.,'DASH BOARD')]")).click();
	Thread.sleep(2000);
	
}

*/

@FindBy(xpath = "//mat-panel-title[contains(.,'CASH DRAWER')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'No')]")
WebElement  CASH_DRAWER_NO;
@FindBy(xpath = "//mat-panel-title[contains(.,'CASH DRAWER')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'Yes')]")
WebElement  CASH_DRAWER_YES;
public void Enable_CASH_DRAWER() throws InterruptedException {

if(CASH_DRAWER_NO.isEnabled()) {
	Thread.sleep(2000);
	CASH_DRAWER_YES.click();
}

Thread.sleep(2000);
Select_All_BackOFFICE.click();
Thread.sleep(2000);

List<WebElement> checkBoxs = driver.findElements(By.xpath("//mat-panel-title[contains(.,'CASH DRAWER')]/../../..//mat-checkbox[contains(@class,'mat-checkbox')]"));

for(WebElement checkBox:checkBoxs) {
	
	if(!checkBox.isSelected()) {
		Thread.sleep(2000);
		checkBox.click();
	}
	
}

Thread.sleep(2000);
driver.findElement(By.xpath("//mat-panel-title[contains(.,'CASH DRAWER')]")).click();
Thread.sleep(2000);

}



@FindBy(xpath = "//mat-panel-title[contains(.,'CALL CENTER')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'No')]")
WebElement  CALL_CENTER_NO;
@FindBy(xpath = "//mat-panel-title[contains(.,'CASH DRAWER')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'Yes')]")
WebElement CALL_CENTER_YES;
public void Enable_CALL_CENTER() throws InterruptedException {

if(CALL_CENTER_NO.isEnabled()) {
	Thread.sleep(2000);
	CALL_CENTER_YES.click();
}

Thread.sleep(2000);
Select_All_BackOFFICE.click();
Thread.sleep(2000);

List<WebElement> checkBoxs = driver.findElements(By.xpath("//mat-panel-title[contains(.,'CALL CENTER')]/../../..//mat-checkbox[contains(@class,'mat-checkbox')]"));

for(WebElement checkBox:checkBoxs) {
	
	if(!checkBox.isSelected()) {
		Thread.sleep(2000);
		checkBox.click();
	}
	
}

Thread.sleep(2000);
driver.findElement(By.xpath("//mat-panel-title[contains(.,'CALL CENTER')]")).click();
Thread.sleep(2000);

}


public void Click_Edit_RoleButton(String str) throws Exception
{
	Thread.sleep(1000);
	cmp=new Common_XPaths(driver, test);
	cmp.SearchBox.clear();
	Thread.sleep(1000);

	cmp.SearchBox.sendKeys(str);
	
	Thread.sleep(4000);
	driver.findElement(By.xpath("//tr[contains(.,'"+str+"')]/td[3]/div/button")).click();
	
	Thread.sleep(1000);
	
	Edit_Role_Btn.click();
}

@FindBy(xpath = "//button[contains(.,'Delete')]")
WebElement Delete_Role_Btn;

public void Click_Delete_Role_Button(String str) throws Exception
{
	cmp=new Common_XPaths(driver, test);

	Thread.sleep(1000);

	cmp.SearchBox.clear();
	Thread.sleep(1000);

	cmp.SearchBox.sendKeys(str);
	
	Thread.sleep(3500);
	driver.findElement(By.xpath("//tr[contains(.,'"+str+"')]/td[3]/div/button")).click();
	
	Thread.sleep(1000);
	
	Delete_Role_Btn.click();
}

public void Enable_DashBoard_YES() throws InterruptedException
{
	
	if(DASH_BOARD_NO.isEnabled()) {
		DASH_BOARD_YES.click();
	}
	
}

public void SelectALL() throws InterruptedException
{
	
	if(Select_All_BackOFFICE.isDisplayed()) {
		Select_All_BackOFFICE.click();
	}
	
}
@FindBy(xpath = "//span[contains(.,'Enable User Sign In')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[contains(.,'No')][contains(@aria-pressed,'true')]")
WebElement Verify_Enable_User_Sign_In_IS_NO;

@FindBy(xpath = "//span[contains(.,'Enable User Sign In')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[contains(.,'Yes')][contains(@aria-pressed,'true')]")
WebElement Verify_Enable_User_Sign_In_IS_YES;

@FindBy(xpath = "//span[contains(.,'Enable User Sign In')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[contains(.,'No')]")
WebElement  Enable_User_Sign_In_NO;

@FindBy(xpath = "//span[contains(.,'Enable User Sign In')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[contains(.,'Yes')]")
WebElement Enable_User_Sign_In_YES;
public void VerifyandEnable_User_Sign_In_Toggle() throws InterruptedException
{
	
	if(Verify_Enable_User_Sign_In_IS_NO.isDisplayed()) {
		Enable_User_Sign_In_YES.click();
	}
	
}


//span[contains(.,'Enable User Sign In')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[contains(.,'No')][contains(@aria-pressed,'true')]
//span[contains(.,'Enable User Sign In')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[contains(.,'Yes')][contains(@aria-pressed,'true')]

	//mat-checkbox[contains(.,'CREATE ORDER')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'VOID ITEM')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,' DELETE UNORDERED ITEM ')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'CC PAYMENT')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'GC PAYMENT')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'HA PAYMENT')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'PAY CASH')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'TAX EXEMPT')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'OPEN ITEM')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'EMPLOYEE DISCOUNT')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'GIFT CARD ISSUE')][contains(@class,'mat-checkbox')]
	
	//(//mat-checkbox[contains(.,'DISCOUNT')][contains(@class,'mat-checkbox')])[2]
	
	//mat-checkbox[contains(.,'GRATUITY')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,' ITEM SERVICE CHARGE EXEMPT ')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'OPEN CASH DRAWER')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'RESENT TO KITCHEN')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'OPEN ALL CHECKS')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'IS DRIVER')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'TRANSFER CHECK/TABLE')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'MERGE TABLE')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'SPLIT SEAT')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'RESTRICT CHECK SUMMARY ')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'KIOSK ')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'OTHER PAYMENT')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'ACCESS FOR PAYMENT APP ')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'TRANSFER BETWEEN OWN CHECKS ')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'TRANSFER BETWEEN ALL USE')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'VIEW ALL CHECKS')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'ALLOW CHECK STATS PERMISSION ')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'LOG OFF AFTER EACH SALE')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'MEMBERSHIP ACCESSIBILITY')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'ALLOW OPEN CHECKS IN ANOTHER POS')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'VIEW OTHERS CHECK')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'RESTRICT OFFLINE MERGE AND TRANSFER')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'APPLY STORE CREDIT')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'REDEEM STORE CREDIT')][contains(@class,'mat-checkbox')]
	
	
	//mat-panel-title[contains(.,'POS OPERATIONS')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'No')]
	
	//mat-panel-title[contains(.,'POS OPERATIONS')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'Yes')]
	
	
	//mat-checkbox[contains(.,'OPEN TILL')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'HOLD TILL')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'CLOSE OWN TILL')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'VIEW/CLOSE ALL TILL')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'CASH DROP')][contains(@class,'mat-checkbox')]
	
	//mat-checkbox[contains(.,'PAY IN/OUT')][contains(@class,'mat-checkbox')]
	
	// (//mat-checkbox[contains(.,'OPEN CASH DRAWER')][contains(@class,'mat-checkbox')])[2]
		
	

	//mat-checkbox[contains(.,'PRINT CASH LOG')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'VOID CHECK')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'RE-OPEN CHECK')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'POS SETTINGS')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'CLOSE OWN CASH OUT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'CLOSE ALL CASH OUT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'CLOSE THE DAY')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'CLOSE BATCH')][contains(@class,'mat-checkbox')]

	//mat-checkbox[contains(.,'HARDWARE SETTING')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'OPERATIONAL REPORTS')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'REFUND')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'REPRINT CHECK')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'RESTRICT REPORT ON ACTIVE CHECK')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'TIP ADJUSTMENT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'TIP SHARING')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'86 LIST')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'BLIND AUDIT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'SHOW REPORT AFTER BLIND AUDIT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'ADJUST TIME CLOCK')][contains(@class,'mat-checkbox')]
	
	
 	//mat-panel-title[contains(.,'REPORT ACCESS')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'No')]
 	//mat-panel-title[contains(.,'REPORT ACCESS')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'Yes')]

	//mat-checkbox[contains(.,'SALES')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'TRANSACTION REPORT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'GIFT CARD REPORT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'DISCOUNT REPORT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'VOID REPORT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'PAID IN/OUT)][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'EMPLOYEE REPORT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'HOUSE ACCOUNT REPORT')][contains(@class,'mat-checkbox')]

	//mat-checkbox[contains(.,'DRIVER REPORT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'BATCH REPORT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'REFUND REPORT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'TILL REPORT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'COMPARISON REPORT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'CUSTOMER PRFERENCE REPORT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'DAILY TRENDER REPORT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'TAX REPORT')][contains(@class,'mat-checkbox')]

	//mat-checkbox[contains(.,'MEMBERSHIP REPORT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'ACCOUNT BALANCE REPORT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'REVENUE CENTER REPORT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'DAILY SUMMARY REPORT')][contains(@class,'mat-checkbox')]
	//mat-checkbox[contains(.,'AUDIT LOG REPORT')][contains(@class,'mat-checkbox')]


	//mat-panel-title[contains(.,'DASH BOARD')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'No')] 
	//mat-panel-title[contains(.,'DASH BOARD')]/../div/mat-button-toggle-group/mat-button-toggle/button/span[contains(.,'Yes')] 

	//mat-checkbox[contains(.,'NET SALES')][contains(@class,'mat-checkbox')]
	
	// (//mat-checkbox[contains(.,'TAX')][contains(@class,'mat-checkbox')])[2]
	
	
	// (//mat-checkbox[contains(.,'TRANSACTION')][contains(@class,'mat-checkbox')])[2]	

	//mat-checkbox[contains(.,'CUSTOMER INFO')][contains(@class,'mat-checkbox')]
	
	// (//mat-checkbox[contains(.,'DISCOUNT')][contains(@class,'mat-checkbox')])[2]
			
	
}
