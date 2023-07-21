package com.Pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class PaymentMethodsPage 
{

	
	public WebDriver driver;
	public ExtentTest test;
	Utility ut=new Utility();
	Common_XPaths cmp;
	
	TaxesPage tx;
	public PaymentMethodsPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//button[contains(.,'PAYMENT METHOD')]")
	WebElement New_PaymentMethod;
	
	@FindBy(xpath = "//app-selectbox[@name='paymentMethodType']/div/mat-form-field/div/div/div[3]/input")
	WebElement PaymentType_Inputbox;
	
	public WebElement PaymentType_Inputbox()
	{
		return PaymentType_Inputbox;
	}
	
	
	@FindBy(xpath = "//app-input[@name='paymentMethodCode']/div/div/mat-form-field/div/div/div[4]/input")
	WebElement PaymentMethod_CodeInputbox;
	
	@FindBy(xpath = "//app-input[@name='paymentMethodPriority']/div/div/mat-form-field/div/div/div[4]/input")
	WebElement PaymentMethod_PriorityInputbox;
	
	public WebElement PaymentMethod_PriorityInputbox()
	{
		return PaymentMethod_PriorityInputbox;
	}
	
	@FindBy(xpath = "//span[contains(.,'Enable Multi Currency')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Enable_MultiCurrency_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Enable Multi Currency')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Enable_MultiCurrency_NoBtn;
	
	@FindBy(xpath = "//app-selectbox[@name='paymentMethodCurrencyId']/div/mat-form-field/div/div/div[3]/input")
	WebElement CurrencyID_Inputbox;
	
	@FindBy(xpath = "//app-input[@type='currency']/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Exchange_Inputbox;
	
	@FindBy(xpath = "//span[contains(.,'Open Cash Drawer')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Open_CashDrawer_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Open Cash Drawer')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Open_CashDrawer_NoBtn;
	
	@FindBy(xpath = "//app-selectbox[@name='paymentMethodModelType']/div/mat-form-field/div/div/div[3]/input")
	WebElement Model_TypeInputbox;
	
	@FindBy(xpath = "//span[contains(.,'Enable EBT')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Enable_EBT_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Enable EBT')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Enable_EBT_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Factor4 Cards')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Factor4Cards_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Factor4 Cards')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Factor4Cards_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Exempt Cash Discount Fee')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Exempt_CashDiscountFee_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Exempt Cash Discount Fee')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Exempt_CashDiscountFee_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Valutec Cards')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Valutec_Cards_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Valutec Cards')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Valutec_Cards_NoBtn;

	@FindBy(xpath = "//mat-radio-button[contains(.,'Sale')]/label/span[1]")
	WebElement Sale_DebitInMPPGCard_RadioButton;
	
	@FindBy(xpath = "//mat-radio-button[contains(.,'Authorize')]/label/span[1]")
	WebElement Authorize_DebitInMPPGCard_RadioButton;
	
	@FindBy(xpath = "//span[contains(.,'Allowance Reset Periodically')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Allowance_ResetPeriodically_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Allowance Reset Periodically')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Allowance_ResetPeriodically_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Cash')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Cash_inEvertecPayment_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Cash')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Cash_inEvertecPayment_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Manual')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Manual_inEvertecPayment_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Manual')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Manual_inEvertecPayment_NoBtn;
	
	@FindBy(xpath = "//select-option[contains(.,'Cash')]")
	WebElement Cash_PaymentType;
	
	@FindBy(xpath = "//select-option[contains(.,'Gift Card')]")
	WebElement GiftCard_PaymentType;
	
	@FindBy(xpath = "//select-option[.=' Credit Card ']")
	WebElement CreditCard_PaymentType;
	
	@FindBy(xpath = "//select-option[contains(.,'Side CC')]")
	WebElement SideCC_PaymentType;
	
	@FindBy(xpath = "//select-option[contains(.,'Bionet Meal Card')]")
	WebElement Bionet_MealCard_PaymentType;
	
	@FindBy(xpath = "//select-option[contains(.,'Castle And Go')]")
	WebElement CastleAndGo_PaymentType;
	
	@FindBy(xpath = "//select-option[contains(.,'SPPax')]")
	WebElement SPPax_PaymentType;
	
	@FindBy(xpath = "//select-option[contains(.,'Others')]")
	WebElement Others_PaymentType;
	
	@FindBy(xpath = "//select-option[contains(.,'GiveX')]")
	WebElement GiveX_PaymentType;
	
	@FindBy(xpath = "//select-option[contains(.,'NMI Tokenization')]")
	WebElement  NMI_Tokenization_PaymentType;
	
	@FindBy(xpath = "//select-option[contains(.,'Dejavoo')]")
	WebElement Dejavoo_PaymentType;
	
	@FindBy(xpath = "//select-option[contains(.,'Optomany')]")
	WebElement Optomany_PaymentType;
	
	@FindBy(xpath = "//select-option[contains(.,'MPPG Credit Card')]")
	WebElement MPPG_CreditCard_PaymentType;
	
	@FindBy(xpath = "//select-option[contains(.,'Ingenico')]")
	WebElement Ingenico_PaymentType;
	
	@FindBy(xpath = "//select-option[contains(.,'MemberShip')]")
	WebElement MemberShip_PaymentType;
	
	@FindBy(xpath = "//select-option[contains(.,'Evertec')]")
	WebElement Evertec_PaymentType;
	
	@FindBy(xpath = "//select-option[contains(.,'PayPal')]")
	WebElement PayPal_PaymentType;
	
	@FindBy(xpath = "//select-option[contains(.,'Venmo')]")
	WebElement Venmo_PaymentType;
	
	public void Click_NewPaymentMethod()
	{
		New_PaymentMethod.click();
	}
	
	public void Enter_PeymentMethod_Code(String str)
	{
		PaymentMethod_CodeInputbox.clear();
		
		PaymentMethod_CodeInputbox.sendKeys(str);
	}
	
	public void Enter_PeymentMethod_Priority(String str)
	{
		PaymentMethod_PriorityInputbox.clear();
		
		PaymentMethod_PriorityInputbox.sendKeys(str);
	}
	
	
	public void Select_CashPayment()
	{
		PaymentType_Inputbox.click();
		
		Cash_PaymentType.click();
	}
	
	
	public void Enable_Multi_Currency()
	{
		if(Enable_MultiCurrency_YesBtn.isSelected())
		{
			
		}
		else
		{
			Enable_MultiCurrency_YesBtn.click();
		}
	}
	
	public void Disable_Multi_Currency()
	{
		if(Enable_MultiCurrency_YesBtn.isSelected())
		{
			Enable_MultiCurrency_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	
	public void Select_Currency_inMultiCurrency()
	{
		CurrencyID_Inputbox.click();
		
	List<WebElement> CurrencyList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int CurrencySize=CurrencyList.size();
		
		if(CurrencySize==0)
		{
			
			CurrencyID_Inputbox.click();
			
			driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div[1]/select-option")).click();
			
		}
		else if(CurrencySize==1)
		{
			
			driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+CurrencySize+"]/select-option")).click();
			
			
			System.out.println("Selected Currency : "+driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+CurrencySize+"]/select-option")).getText());
			
			test.log(LogStatus.INFO, "Selected Currency as : "+driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+CurrencySize+"]/select-option")).getText());
			
		}
		else if(CurrencySize<=10)
		{
		int randomCurrency=ThreadLocalRandom.current().nextInt(1, CurrencySize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomCurrency+"]/select-option")).click();
	
		
		System.out.println("Selected Currency : "+driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomCurrency+"]/select-option")).getText());
		
		test.log(LogStatus.INFO, "Selected Currency as : "+driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomCurrency+"]/select-option")).getText());
		}
		else
		{
			int randomCurrency=ThreadLocalRandom.current().nextInt(1, 10);
			
			
			System.out.println("Selected Currency : "+driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomCurrency+"]/select-option")).getText());
			
			test.log(LogStatus.INFO, "Selected Currency as : "+driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomCurrency+"]/select-option")).getText());
		
			driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomCurrency+"]/select-option")).click();
		
		
		}
		
		List<WebElement> CurrencyList1=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));

		if(CurrencyList1.size()!=0)
		{
			CurrencyID_Inputbox.click();

		}
	}
	
	public void Enter_ExchangeRate(String str)
	{
		Exchange_Inputbox.clear();
		
		Exchange_Inputbox.sendKeys(str);
	}
	
	
	public void Enable_OpenCashDrawer()
	{
		if(Open_CashDrawer_YesBtn.isSelected())
		{
			
		}
		else
		{
			Open_CashDrawer_YesBtn.click();
		}
	}
	
	public WebElement Open_CashDrawer_YesBtn()
	{
		return Open_CashDrawer_YesBtn;
	}
	
	public void Disable_OpenCashDrawer()
	{
		if(Open_CashDrawer_YesBtn.isSelected())
		{
			Open_CashDrawer_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public void Select_GiftCard_Payment()
	{
		PaymentType_Inputbox.click();
		
		GiftCard_PaymentType.click();
	}
	
	public void Select_CreditCard_Payment()
	{
		PaymentType_Inputbox.click();
		
		CreditCard_PaymentType.click();
	}
	
	public void Select_SideCC_Payment()
	{
		PaymentType_Inputbox.click();
		
		SideCC_PaymentType.click();
	}
	
	public void Select_Bionet_MealCard_Payment()
	{
		PaymentType_Inputbox.click();
		
		Bionet_MealCard_PaymentType.click();
	}
	
	public void Select_CastleAndGo_Payment()
	{
		PaymentType_Inputbox.click();
		
		CastleAndGo_PaymentType.click();
	}
	
	public void Select_SPPax_Payment()
	{
		PaymentType_Inputbox.click();
		
		SPPax_PaymentType.click();
		
		
		Model_TypeInputbox.click();
		
	List<WebElement> ModelTypeList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int ModelTypeSize=ModelTypeList.size();
		
		if(ModelTypeSize==0)
		{
			Model_TypeInputbox.click();

			
			driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div[1]/select-option")).click();

		}
		else if(ModelTypeSize==1)
		{
			driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+ModelTypeSize+"]/select-option")).click();

		}
		else
		{
		int randomModelType=ThreadLocalRandom.current().nextInt(1, ModelTypeSize);
		
		System.out.println("Selected Model Type : "+driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomModelType+"]/select-option")).getText());

		test.log(LogStatus.INFO, "Selected Model Type as : "+driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomModelType+"]/select-option")).getText());

		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomModelType+"]/select-option")).click();
		}
		
		List<WebElement> ModelTypeList1=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));

		if(ModelTypeList1.size()!=0)
		{
			Model_TypeInputbox.click();

		}
	}
	
	public void Enable_EBT()
	{
		if(Enable_EBT_YesBtn.isSelected())
		{
			
		}
		else
		{
			Enable_EBT_YesBtn.click();
		}
	}
	
	public void Disable_EBT()
	{
		if(Enable_EBT_YesBtn.isSelected())
		{
			Enable_EBT_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	
	public void Enable_Factor4Cards()
	{
		if(Factor4Cards_YesBtn.isSelected())
		{
			
		}
		else
		{
			Factor4Cards_YesBtn.click();
		}
	}
	
	public void Disable_Factor4Cards()
	{
		if(Factor4Cards_YesBtn.isSelected())
		{
			Factor4Cards_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public void Enable_Exempt_CashDiscountFee()
	{
		if(Exempt_CashDiscountFee_YesBtn.isSelected())
		{
			
		}
		else
		{
			Exempt_CashDiscountFee_YesBtn.click();
		}
	}
	
	public WebElement Exempt_CashDiscountFee_YesBtn()
	{
		return Exempt_CashDiscountFee_YesBtn;
	}
	
	public void Disable_Exempt_CashDiscountFee()
	{
		if(Exempt_CashDiscountFee_YesBtn.isSelected())
		{
			Exempt_CashDiscountFee_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public void Enable_Valutec_Cards()
	{
		if(Valutec_Cards_YesBtn.isSelected())
		{
			
		}
		else
		{
			Valutec_Cards_YesBtn.click();
		}
	}
	
	public void Disable_Valutec_Cards()
	{
		if(Valutec_Cards_YesBtn.isSelected())
		{
			Valutec_Cards_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	
	public void Select_Others_Payment()
	{
		PaymentType_Inputbox.click();
		
		Others_PaymentType.click();
	}
	
	
	public void Select_GiveX_Payment()
	{
		PaymentType_Inputbox.click();
		
		GiveX_PaymentType.click();
	}
	
	
	public void Select_NMI_Tokenization_Payment()
	{
		PaymentType_Inputbox.click();
		
		NMI_Tokenization_PaymentType.click();
	}
	
	public void Select_Dejavoo_Payment()
	{
		PaymentType_Inputbox.click();
		
		Dejavoo_PaymentType.click();
	}
	
	public void Select_Optomany_Payment()
	{
		PaymentType_Inputbox.click();
		
		Optomany_PaymentType.click();
	}
	
	public void Select_MPPG_CreditCard_Payment()
	{
		PaymentType_Inputbox.click();
		
		MPPG_CreditCard_PaymentType.click();
	}
	
	public WebElement Sale_DebitInMPPGCard_RadioButton()
	{
		return Sale_DebitInMPPGCard_RadioButton;
	}
	
	public WebElement Authorize_DebitInMPPGCard_RadioButton()
	{
		return Authorize_DebitInMPPGCard_RadioButton;
	}
	
	public void Select_Ingenico_Payment()
	{
		PaymentType_Inputbox.click();
		
		Ingenico_PaymentType.click();
	}
	
	public void Select_MemberShip_Payment()
	{
		PaymentType_Inputbox.click();
		
		MemberShip_PaymentType.click();
	}
	
	public void Enable_Allowance_ResetPeriodically()
	{
		if(Allowance_ResetPeriodically_YesBtn.isSelected())
		{
			
		}
		else
		{
			Allowance_ResetPeriodically_YesBtn.click();
		}
	}
	
	public void Disable_Allowance_ResetPeriodically()
	{
		if(Allowance_ResetPeriodically_YesBtn.isSelected())
		{
			Allowance_ResetPeriodically_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public void Select_Evertec_Payment()
	{
		PaymentType_Inputbox.click();
		
		Evertec_PaymentType.click();
	}
	
	public void Enable_Cash_inEvertecPayment()
	{
		if(Cash_inEvertecPayment_YesBtn.isSelected())
		{
			
		}
		else
		{
			Cash_inEvertecPayment_YesBtn.click();
		}
	}
	
	public void Disable_Cash_inEvertecPayment()
	{
		if(Cash_inEvertecPayment_YesBtn.isSelected())
		{
			Cash_inEvertecPayment_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public void Enable_Manual_inEvertecPayment()
	{
		if(Manual_inEvertecPayment_YesBtn.isSelected())
		{
			
		}
		else
		{
			Manual_inEvertecPayment_YesBtn.click();
		}
	}
	
	public void Disable_Manual_inEvertecPayment()
	{
		if(Manual_inEvertecPayment_YesBtn.isSelected())
		{
			Manual_inEvertecPayment_NoBtn.click();
		}
		else
		{
			
		}
	}
	
//	public WebElement Cash_Evertec()
//	{
//		return Cash_inEvertecPayment_YesBtn
//	}
	
	
	public void Select_PayPal_Payment()
	{
		PaymentType_Inputbox.click();
		
		PayPal_PaymentType.click();
	}
	
	public void Select_Venmo_Payment()
	{
		PaymentType_Inputbox.click();
		
		Venmo_PaymentType.click();
	}
}
