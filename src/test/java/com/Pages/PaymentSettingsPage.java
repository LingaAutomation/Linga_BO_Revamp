package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;

import Utility.Utility;

public class PaymentSettingsPage extends BasePage
{

//	public SelfHealingDriver driver;
//	public ExtentTest test;
	
	Utility ut=new Utility();
	
	public PaymentSettingsPage(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		super(driver,test);
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'NEW SERVICE CHARGE')]")
	WebElement New_ServiceChargeBtn;
	
	@FindBy(xpath = "//span[contains(.,'Manual Submit For Credit Card')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement ManualSubmitForCreditCard_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Manual Submit For Credit Card')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement ManualSubmitForCreditCard_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Tokenize The Credit Card')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement TokenizeTheCreditCard_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Tokenize The Credit Card')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement TokenizeTheCreditCard_NoBtn;
	
	@FindBy(xpath = "//div[contains(@class,'radio-box-button')]/div/div/div[contains(.,'Cash Discount')]")
	WebElement Cash_DiscountBtn;
	
	@FindBy(xpath = "//div[contains(@class,'radio-box-button')]/div/div/div[contains(.,'Service Charge')]")
	WebElement Service_ChargeBtn;
	
	@FindBy(xpath = "//div[contains(@class,'radio-box-button')]/div/div/div[contains(.,'Instant Cash Reward')]")
	WebElement Instant_CashRewardBtn;
		
	@FindBy(xpath = "//mat-label[contains(.,'Fee Name')]/../../../input")
	WebElement Fee_NameInputBox;
	
	@FindBy(xpath = "//mat-label[contains(.,'Cash Discount Name')]/../../../input")
	WebElement CashDiscount_NameInputBox;
	
	@FindBy(xpath = "//mat-label[contains(.,'Cash Discount Percentage')]/../../../input")
	WebElement CashDiscount_PercentageInputBox;
	
	@FindBy(xpath = "//mat-label[contains(.,'Service Charge Name')]/../../../input")
	WebElement ServiceCharge_NameInput;
	
	@FindBy(xpath = "//mat-label[contains(.,'Card Type')]/../../../input")
	WebElement Card_TypeInput;
	
	public WebElement Card_TypeInput()
	{
		return Card_TypeInput;
	}
	
	@FindBy(xpath = "(//mat-label[contains(.,'Service Charge')]/../../../input)[2]")
	WebElement Service_ChargeInputBox;
	
	public WebElement Service_ChargeInputBox()
	{
		return Service_ChargeInputBox;
	}
	
	@FindBy(xpath = "//mat-label[contains(.,'Tip Charge')]/../../../input")
	WebElement Tip_ChargeInputBox;
	
	public WebElement Tip_ChargeInputBox()
	{
		return Tip_ChargeInputBox;
	}
	
	
	@FindBy(xpath = "//mat-label[contains(.,'Gratuity Charge')]/../../../input")
	WebElement Gratuity_ChargeInputBox;
	
	public WebElement Gratuity_ChargeInputBox()
	{
		return Gratuity_ChargeInputBox;
	}
	
	
	@FindBy(xpath = "//select-option[contains(.,'Visa')]")
	WebElement Visa_CardType;
	
	@FindBy(xpath = "//select-option[contains(.,'Master')]")
	WebElement Master_CardType;
		
	@FindBy(xpath = "//select-option[contains(.,'Amex')]")
	WebElement Amex_CardType;
	
	@FindBy(xpath = "//select-option[contains(.,'Diners')]")
	WebElement Diners_CardType;
	
	@FindBy(xpath = "//select-option[contains(.,'JCB')]")
	WebElement JCB_CardType;
	
	@FindBy(xpath = "//select-option[contains(.,'Discover')]")
	WebElement Discover_CardType;
	
	@FindBy(xpath = "//select-option[contains(.,'ATH')]")
	WebElement ATH_CardType;

	@FindBy(xpath = "//select-option[contains(.,'Cash')]")
	WebElement Cash_CardType;
	
	@FindBy(xpath = "//select-option[contains(.,'Unica')]")
	WebElement Unica_CardType;
	
	@FindBy(xpath = "//select-option[.=' Ebt ']")
	WebElement Ebt_CardType;
	
	@FindBy(xpath = "//select-option[contains(.,'Fondo')]")
	WebElement Fondo_CardType;
	
	@FindBy(xpath = "//select-option[contains(.,'EbtCash')]")
	WebElement EbtCash_CardType;
	
	@FindBy(xpath = "//select-option[contains(.,'Others')]")
	WebElement Others_CardType;
	
	@FindBy(xpath = "//app-input[@label='Instant Cash Reward']/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Instant_CashRewardInputBox;
	
	@FindBy(xpath = "//span[contains(.,'Enter Valid Percentage')]")
	WebElement Valid_PercentageErrorMsg;
	
	
	
	public void Click_NewServiceCharge()
	{
		New_ServiceChargeBtn.click();
	}
	
	public void Enable_ManualSubmit_For_CreditCard()
	{
		if(ManualSubmitForCreditCard_YesBtn.isSelected())
		{
			
		}
		else
		{
			ManualSubmitForCreditCard_YesBtn.click();
		}
		
	}
	
	public void Disable_ManualSubmit_For_CreditCard()
	{
		if(ManualSubmitForCreditCard_YesBtn.isSelected())
		{
			ManualSubmitForCreditCard_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement ManualSubmitForCreditCard()
	{
		return ManualSubmitForCreditCard_YesBtn;
	}
	
	public void Enable_TokenizeThe_CreditCard()
	{
		if(TokenizeTheCreditCard_YesBtn.isSelected())
		{
			
		}
		else
		{
			TokenizeTheCreditCard_YesBtn.click();
		}
		
	}
	
	public void Disable_TokenizeThe_CreditCard()
	{
		if(TokenizeTheCreditCard_YesBtn.isSelected())
		{
			TokenizeTheCreditCard_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement TokenizeTheCreditCard()
	{
		return TokenizeTheCreditCard_YesBtn;
	}
	
	public void Select_Tokenize_CreditCard()
	{
		List<WebElement> avail_ServiceTypes=driver.findElements(By.xpath("//mat-chip-list/div/mat-chip"));
		
		for(WebElement EachType:avail_ServiceTypes)
		{
			if(EachType.isSelected())
			{
				
			}
			else
			{
				EachType.click();
			}
		}
	}
	
	public void UnSelect_Tokenize_CreditCard()
	{
		List<WebElement> avail_ServiceTypes=driver.findElements(By.xpath("//mat-chip-list/div/mat-chip"));
		
		for(WebElement EachType:avail_ServiceTypes)
		{
			if(EachType.isSelected())
			{
				EachType.click();			
			}
			else
			{
				
			}
		}
	}
	
	public void Select_Cash_Discount()
	{
		Cash_DiscountBtn.click();
	}
	
	public WebElement Cash_DiscountTab()
	{
		return Cash_DiscountBtn;
	}

	public void Select_Service_Charge() throws Exception
	{

		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Service_ChargeBtn);
		Thread.sleep(1500);

		Service_ChargeBtn.click();
	}
	
	public WebElement Service_ChargeTab()
	{
		return Service_ChargeBtn;
	}

	public void Select_Instant_Cash_Reward() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		
		for(int i = 1; i <= 5; i++) {
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}Thread.sleep(2000);
		
		Instant_CashRewardBtn.click();
	}
	
	public WebElement Instant_Cash_RewardTab()
	{
		return Instant_CashRewardBtn;
	}
	
	public WebElement Valid_PercentageErrorMsg()
	{
		return Valid_PercentageErrorMsg;
	}
	
	public void Enter_FeeName(String str)
	{
		Fee_NameInputBox.clear();
		
		Fee_NameInputBox.sendKeys(str);
	}
	
	public void Enter_CashDiscountName(String str)
	{
		CashDiscount_NameInputBox.clear();
		
		CashDiscount_NameInputBox.sendKeys(str);
	}
	
	public void Enter_CashDiscountPercentage(String str)
	{
		CashDiscount_PercentageInputBox.clear();
		
		CashDiscount_PercentageInputBox.sendKeys(str);
	}
	
	public void Enter_Service_ChargeName(String str)
	{
		ServiceCharge_NameInput.clear();
		
		ServiceCharge_NameInput.sendKeys(str);
	}
	
	public void Select_Visa_CardType()
	{
		Card_TypeInput.click();
		
		Visa_CardType.click();
	}
	
	public void Select_Master_CardType()
	{
		Card_TypeInput.click();
		
		Master_CardType.click();
	}
	
	public void Select_Amex_CardType()
	{
		Card_TypeInput.click();
		
		Amex_CardType.click();
	}
	
	public void Select_Diners_CardType()
	{
		Card_TypeInput.click();
		
		Diners_CardType.click();
	}
	
	public void Select_JCB_CardType()
	{
		Card_TypeInput.click();
		
		JCB_CardType.click();
	}
	
	public void Select_Discover_CardType()
	{
		Card_TypeInput.click();
		
		Discover_CardType.click();
	}
	
	public void Select_ATH_CardType()
	{
		Card_TypeInput.click();
		
		ATH_CardType.click();
	}
	
	public void Select_Cash_CardType()
	{
		Card_TypeInput.click();
		
		Cash_CardType.click();
	}
	
	
	public void Select_Unica_CardType()
	{
		Card_TypeInput.click();
		
		Unica_CardType.click();
	}
	
	public void Select_Ebt_CardType()
	{
		Card_TypeInput.click();
		
		Ebt_CardType.click();
	}
	
	public void Select_Fondo_CardType()
	{
		Card_TypeInput.click();
		
		Fondo_CardType.click();
	}
	
	public void Select_EbtCash_CardType()
	{
		Card_TypeInput.click();
		
		EbtCash_CardType.click();
	}
	
	public void Select_Others_CardType()
	{
		Card_TypeInput.click();
		
		Others_CardType.click();
	}
	
	public void Enter_ServiceCharge(String str)
	{
		Service_ChargeInputBox.clear();
		
		Service_ChargeInputBox.sendKeys(str);
	}
	
	
	public void Enter_TipCharge(String str)
	{
		Tip_ChargeInputBox.clear();
		
		Tip_ChargeInputBox.sendKeys(str);
	}
	
	
	public void Enter_GratuityCharge(String str)
	{
		Gratuity_ChargeInputBox.clear();
		
		Gratuity_ChargeInputBox.sendKeys(str);
	}
	
	public void Enter_InstantCashReward(String str)
	{
		Instant_CashRewardInputBox.clear();
		
		Instant_CashRewardInputBox.sendKeys(str);
	}
	
	
}
