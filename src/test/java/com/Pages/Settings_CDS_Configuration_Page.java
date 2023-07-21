package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_CDS_Configuration_Page {
	WebDriver driver;
	ExtentTest test;
	Common_XPaths cmp;
	Utility ut=new Utility();
	
	public Settings_CDS_Configuration_Page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='settings']/button")
	WebElement Settings;
	
	@FindBy(xpath = "//h3[contains(.,'Settings')]")
	WebElement Settings_Heading;
	
	@FindBy(xpath = "//span[contains(.,'Addons')]")
	WebElement Addons;	
	
	@FindBy(xpath = "//h4[contains(.,'Addons')]")
	WebElement Addons_Heading;	
	
	@FindBy(xpath = "//span[contains(.,'Customer Display System (CDS)')]")
	WebElement CDS;
	
	@FindBy(xpath = "//h3[contains(.,'Customer Display System (CDS)')]")
	WebElement CDS_Heading;
	
	@FindBy(xpath =  "//span[contains(.,'SAVE')]")
	WebElement Update;
	
	@FindBy(xpath =  "//span[contains(.,'Show Advertisements')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement No_btn_SA;
	
	@FindBy(xpath =  "//span[contains(.,'Show Advertisements')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button[@aria-pressed='true']")
	WebElement No_btn_SA_isSelected;
	
	@FindBy(xpath =  "//span[contains(.,'Show Advertisements')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Yes_btn_SA;
	
	@FindBy(xpath =  "//span[contains(.,'Show Advertisements')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button[@aria-pressed='true']")
	WebElement Yes_btn_SA_isSelected;
	
	@FindBy(xpath =  "//span[contains(.,'Customer Profile')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement No_btn_CP;
	
	@FindBy(xpath =  "//span[contains(.,'Customer Profile')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button[@aria-pressed='true']")
	WebElement No_btn_CP_isSelected;
	
	@FindBy(xpath =  "//span[contains(.,'Customer Profile')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Yes_btn_CP;
	
	@FindBy(xpath =  "//span[contains(.,'Customer Profile')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button[@aria-pressed='true']")
	WebElement Yes_btn_CP_isSelected;
	
	@FindBy(xpath =  "//span[contains(.,'Choose Theme')]/../../div[2]/div/app-selectbox/div/mat-form-field/div")
	WebElement theme_Select;
	
	@FindBy(xpath =  "//select-option/div[contains(.,'Light Theme')]")
	WebElement light_Theme;
	
	@FindBy(xpath =  "//select-option/div[contains(.,'Dark Theme')]")
	WebElement dark_Theme;
	
	@FindBy(xpath =  "//span[contains(.,'Discount Text')]/../../div[2]/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/textarea")
	WebElement textArea_Of_DiscountText;
	
	@FindBy(xpath =  "//span[contains(.,'Get Number Text')]/../../div[2]/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/textarea")
	WebElement textArea_Of_GetNumberText;
	
	@FindBy(xpath =  "//span[contains(.,'Loyalty Text')]/../../div[2]/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/textarea")
	WebElement textArea_Of_LoyaltyText;

	@FindBy(xpath =  "//div[@class='message mx-2']/span")
	WebElement successMessage;
	
	@FindBy(xpath =  "//span[contains(.,'UPDATE')]/../../button[contains(@class,'mat-button-disabled')]")
	WebElement disabled_Update_Btn;
	
	@FindBy(xpath =  "//label/mat-label[contains(.,'Theme')]")
	WebElement Theme;
	
	public void verifyTheDisabledUpdateBtn() throws InterruptedException {
		//Verify the update
		if(disabled_Update_Btn.isDisplayed())
		{
			test.log(LogStatus.PASS, "Update button is disabled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Update button is enabled");
		}
	}
	
	
	public void verifyTheSuccessMsg() throws InterruptedException {
		//Verify the success page
		if(successMessage.getText().equals("CDS settings updated successfully"))
		{
			test.log(LogStatus.PASS, "CDS page is updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "CDS page is not updated");
		}
	}
	
	public void verifyTheCDSPage() throws InterruptedException {
		Thread.sleep(3000);
		
		
		//Verify the CDS page
		if(CDS_Heading.getText().equals("Customer Display System (CDS)"))
		{
			test.log(LogStatus.PASS, "CDS page is displayed successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "CDS page is not displyed");
		}
	}
	
	public void clickUpdateBtn() {
		//Click the Update button of CDS
		Update.click();
	}
	
	public void clickNoBtnShowAd() throws InterruptedException {
		//Click the No button of Show advertisement
		No_btn_SA.click();
		
		clickUpdateBtn();
		Thread.sleep(1000);
		
		//Check whether the success message is displayed
		if(successMessage.getText().equals("CDS settings updated successfully"))
		{
			test.log(LogStatus.PASS, "Updated message displayed successfully when user select the NO toggle in Show Advertisements");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Updated message displayed faild when user select the NO toggle in Show Advertisements");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//check whether the NO toggle is enabled or not in Show Advertisement
		if(No_btn_SA_isSelected.isDisplayed())
		{
			test.log(LogStatus.PASS, "NO toggle is selected when user selects the Show Advertisements's NO toggle");
		}
		else
		{
			test.log(LogStatus.FAIL, "NO toggle is not selected when user selects the Show Advertisements's NO toggle");
		}
	}
	
	public void clickYesBtnShowAd() throws InterruptedException {

		//Click the Yes button of show advertisement
		No_btn_SA.click();
		Yes_btn_SA.click();
		
		clickUpdateBtn();
		Thread.sleep(1000);
		
		//Check whether the success message is displayed
		if(successMessage.getText().equals("CDS settings updated successfully"))
		{
			test.log(LogStatus.PASS, "Updated message displayed successfully when user select the YES toggle in Show Advertisements");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Updated message displayed faild when user select the YES toggle in Show Advertisements");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//check whether the YES toggle is enabled or not in Show Advertisement
		if(Yes_btn_SA_isSelected.isDisplayed())
		{
			test.log(LogStatus.PASS, "YES toggle is selected when user selects the Show Advertisements's YES toggle");
		}
		else
		{
			test.log(LogStatus.FAIL, "YES toggle is not selected when user selects the Show Advertisements's YES toggle");
		}
	}
	
	public void clickNoBtnCustomerProfile() throws InterruptedException {
		//Click the No button of Customer Profile
		No_btn_CP.click();
		
		
		clickUpdateBtn();
		Thread.sleep(1000);
		
		//Check whether the success message is displayed
		if(successMessage.getText().equals("CDS settings updated successfully"))
		{
			test.log(LogStatus.PASS, "Updated message displayed successfully when user select the NO toggle in Customer Profile");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Updated message displayed faild when user select the NO toggle in Customer Profile");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//check whether the NO toggle is enabled or not in Show Advertisement
		if(No_btn_CP_isSelected.isDisplayed())
		{
			test.log(LogStatus.PASS, "NO toggle is selected when user selects the Customer Profile's NO toggle");
		}
		else
		{
			test.log(LogStatus.FAIL, "NO toggle is not selected when user selects the Customer Profile's NO toggle");
		}
	}
	
	public void clickYesBtnCustomerProfile() throws InterruptedException {
		//Click the Yes button of Customer Profile
		Yes_btn_CP.click();
		
		clickUpdateBtn();
		Thread.sleep(1000);
		
		//Check whether the success message is displayed
		if(successMessage.getText().equals("CDS settings updated successfully"))
		{
			test.log(LogStatus.PASS, "Updated message displayed successfully when user select the YES toggle in Customer Profile");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Updated message displayed faild when user select the YES toggle in Customer Profile");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//check whether the YES toggle is enabled or not in Show Advertisement
		if(Yes_btn_CP_isSelected.isDisplayed())
		{
			test.log(LogStatus.PASS, "YES toggle is selected when user selects the Customer Profile's YES toggle");
		}
		else
		{
			test.log(LogStatus.FAIL, "YES toggle is not selected when user selects the Customer Profile's YES toggle");
		}
	}
	
	public void selectLightTheme() throws InterruptedException {
		//Click the theme select box
		theme_Select.click();
		
		Thread.sleep(1000);
		
		//Select the light theme
		light_Theme.click();
	}
	
	public void selectDarkTheme() throws InterruptedException {
		//Click the theme select box
		theme_Select.click();
		
		Thread.sleep(1000);
		
		//Select the dark theme
		dark_Theme.click();
	}
	
	public void enterTheDiscountText(String text) {
		//Clear the discount text
		textArea_Of_DiscountText.clear();
		
		//Enter the string
		textArea_Of_DiscountText.sendKeys(text);
	}
	
	public void enterTheGetNumberText(String text) {
		//Clear the get number text
		textArea_Of_GetNumberText.clear();
		
		//Enter the string
		textArea_Of_GetNumberText.sendKeys(text);
	}
	
	public void enterTheLoyaltyText(String text) {
		//Clear the loyalty text
		textArea_Of_LoyaltyText.clear();
		
		//Enter the string
		textArea_Of_LoyaltyText.sendKeys(text);
	}
}