package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class GiftCardsPage {

	public WebDriver driver;
	public ExtentTest test;
	
	Common_XPaths cmp;
	
	public GiftCardsPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'NEW GIFT CARD')]")
	WebElement New_GiftCard;
	
	@FindBy(xpath = "//label[contains(.,'Card Number')]/../../input")
	WebElement GiftCardNumberInputBox;
	
	@FindBy(xpath = "//label[contains(.,'Balance')]/../../input")
	WebElement BalanceInputBox;
	
	@FindBy(xpath = "//app-radio-box-button/div/div/div/div[contains(.,'Cash')]")
	WebElement CashBtn;
	
	@FindBy(xpath = "//app-radio-box-button/div/div/div/div[contains(.,'Card')]")
	WebElement CardBtn;
	
	@FindBy(xpath = "//app-radio-box-button/div/div/div/div[contains(.,'Discount 100%')]")
	WebElement Discount100PerBtn;
	
	@FindBy(xpath = "//label[contains(.,'Last 4 Digits')]/../../input")
	WebElement Last4DigitsInputBox;
	
	@FindBy(xpath = "//label[contains(.,'Card Type')]/../../input")
	WebElement CardTypeInputBox;
	
	@FindBy(xpath = "//select-option[contains(.,'Visa')]")
	WebElement Visa_CardType;
	
	@FindBy(xpath = "//select-option[contains(.,'Master')]")
	WebElement Master_CardType;
	
	@FindBy(xpath = "//select-option[contains(.,'Amex')]")
	WebElement Amex_CardType;
	
	@FindBy(xpath = "//select-option[contains(.,'Diners')]")
	WebElement Diners_CardType;
	
	@FindBy(xpath = "//select-option[contains(.,'Others')]")
	WebElement Others_CardType;
	
	@FindBy(xpath = "//p[contains(.,'Edit')]")
	WebElement EditGC_Btn;
	
	@FindBy(xpath = "//p[contains(.,'Delete')]")
	WebElement DeleteGC_Btn;
	
	@FindBy(xpath = "//p[contains(.,'Recharge')]")
	WebElement RechargeGC_Btn;
	
	
	
	
	public void Click_Edit_GiftCardButton(String str) throws Exception
	{
		Thread.sleep(1000);
		cmp=new Common_XPaths(driver, test);
		cmp.SearchBox.clear();
		Thread.sleep(1000);

		cmp.SearchBox.sendKeys(str);
		
		Thread.sleep(4000);
		driver.findElement(By.xpath("//data-grid-row[contains(.,'"+str+"')]/div/div[3]/div/button")).click();
		
		Thread.sleep(1000);
		
		EditGC_Btn.click();
	}
	
	public void Click_Delete_GiftCardButton(String str) throws Exception
	{
		cmp=new Common_XPaths(driver, test);

		Thread.sleep(1000);

		cmp.SearchBox.clear();
		Thread.sleep(1000);

		cmp.SearchBox.sendKeys(str);
		
		Thread.sleep(3500);
		driver.findElement(By.xpath("//data-grid-row[contains(.,'"+str+"')]/div/div[3]/div/button")).click();
		
		Thread.sleep(1000);
		
		DeleteGC_Btn.click();
	}
	
	public void Click_Recharge_GiftCardButton(String str) throws Exception
	{
		cmp=new Common_XPaths(driver, test);

		Thread.sleep(1000);

		cmp.SearchBox.clear();
		Thread.sleep(1000);

		cmp.SearchBox.sendKeys(str);
		Thread.sleep(3500);
		driver.findElement(By.xpath("//data-grid-row[contains(.,'"+str+"')]/div/div[3]/div/button")).click();
		
		Thread.sleep(1000);
		
		RechargeGC_Btn.click();
		Thread.sleep(500);
		BalanceInputBox.clear();
		Thread.sleep(500);
		BalanceInputBox.sendKeys("20000");
		Thread.sleep(500);
		try
		{
			
		if(CashBtn.isDisplayed())
		{
		CashBtn.click();
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.INFO, "Payment Methods not Displayed");
		}
	
	
	}
	
	public void Click_NewGiftCard()
	{
		New_GiftCard.click();
	}
	
	public void Enter_GiftCardNumber(String str) throws Exception
	{
		
		Thread.sleep(500);
		GiftCardNumberInputBox.clear();
		Thread.sleep(500);
		GiftCardNumberInputBox.sendKeys(str);
	}
	
	public void Enter_GiftCardBalance(String str) throws Exception
	{
		Thread.sleep(500);
		BalanceInputBox.clear();
		Thread.sleep(500);
		BalanceInputBox.sendKeys(str);
	}
	
	public void Select_GiftCard_Cash(String str) throws Exception
	{
		Thread.sleep(1000);
		GiftCardNumberInputBox.clear();
		Thread.sleep(1000);
		GiftCardNumberInputBox.sendKeys(str);
		
		
		Thread.sleep(1000);
		BalanceInputBox.clear();
		Thread.sleep(1000);
		BalanceInputBox.sendKeys("50.00");
		
		Thread.sleep(1000);
		CashBtn.click();
	}
	
	public void Select_GiftCard_Discount(String str) throws Exception
	{
		Thread.sleep(1000);
		GiftCardNumberInputBox.clear();
		Thread.sleep(1000);
		GiftCardNumberInputBox.sendKeys(str);
		
		
		Thread.sleep(1000);
		BalanceInputBox.clear();
		Thread.sleep(1000);
		BalanceInputBox.sendKeys("50.00");
		
//		Removed this discount 100 per
		Thread.sleep(1000);
//		Discount100PerBtn.click();  
	}
	
	public void Select_VisaCard(String str) throws Exception
	{
//		Thread.sleep(1000);
//		CardBtn.click();
//		
		Thread.sleep(1000);
		GiftCardNumberInputBox.clear();
		Thread.sleep(1000);
		GiftCardNumberInputBox.sendKeys(str);
		
		
		Thread.sleep(1000);
		BalanceInputBox.clear();
		
	
		Thread.sleep(1000);
		BalanceInputBox.sendKeys("100.00");
		
		Thread.sleep(1000);
		try
		{
		if(CardBtn.isDisplayed())
		{
		CardBtn.click();
		
		
		Thread.sleep(500);
		CardTypeInputBox.click();
		
		Thread.sleep(500);
		Visa_CardType.click();
		
		Thread.sleep(500);
		Last4DigitsInputBox.clear();
		Thread.sleep(500);
		Last4DigitsInputBox.sendKeys("1234");
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.INFO, "Payment Methods not Displayed");
		}
		
	}
	
	public void Select_MasterCard(String str) throws Exception
	{
		
		Thread.sleep(1000);
		GiftCardNumberInputBox.clear();
		Thread.sleep(1000);
		GiftCardNumberInputBox.sendKeys(str);
		
		
		Thread.sleep(1000);
		BalanceInputBox.clear();

		Thread.sleep(1000);
		BalanceInputBox.sendKeys("150.00");
		
		try
		{
		Thread.sleep(1000);
		if(CardBtn.isDisplayed())
		{
		Thread.sleep(1000);
		CardBtn.click();
		
		
		Thread.sleep(500);
		CardTypeInputBox.click();
		
		Thread.sleep(500);
		Master_CardType.click();
		
		Thread.sleep(500);
		Last4DigitsInputBox.clear();
		Thread.sleep(500);
		Last4DigitsInputBox.sendKeys("1234");
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.INFO, "Payment Methods not Displayed");
		}
		
	}
	
	public void Select_AmexCard(String str) throws Exception
	{
		
		Thread.sleep(1000);
		GiftCardNumberInputBox.clear();
		Thread.sleep(1000);
		GiftCardNumberInputBox.sendKeys(str);
		
		
		Thread.sleep(1000);
		BalanceInputBox.clear();
	
		Thread.sleep(1000);
		BalanceInputBox.sendKeys("200.00");
		
		Thread.sleep(1000);
		try
		{
		if(CardBtn.isDisplayed())
		{
		Thread.sleep(1000);
		CardBtn.click();
		
		
		Thread.sleep(500);
		CardTypeInputBox.click();
		
		Thread.sleep(500);
		Amex_CardType.click();
		
		Thread.sleep(500);
		Last4DigitsInputBox.clear();
		Thread.sleep(500);
		Last4DigitsInputBox.sendKeys("1234");
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.INFO, "Payment Methods not Displayed");
		}
	}
	
	public void Select_DinersCard(String str) throws Exception
	{
		
		Thread.sleep(1000);
		GiftCardNumberInputBox.clear();
		Thread.sleep(1000);
		GiftCardNumberInputBox.sendKeys(str);
		
		
		Thread.sleep(1000);
		BalanceInputBox.clear();
		
		Thread.sleep(1000);
		BalanceInputBox.sendKeys("250.00");
		
		Thread.sleep(1000);
		try
		{
		if(CardBtn.isDisplayed())
		{
		Thread.sleep(1000);
		CardBtn.click();
		
		
		Thread.sleep(500);
		CardTypeInputBox.click();
		
		Thread.sleep(500);
		Diners_CardType.click();
		
		Thread.sleep(500);
		Last4DigitsInputBox.clear();
		Thread.sleep(500);
		Last4DigitsInputBox.sendKeys("1234");
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.INFO, "Payment Methods not Displayed");
		}
		
	}
	
	public void Select_OthersCard(String str) throws Exception
	{
		
		Thread.sleep(1000);
		GiftCardNumberInputBox.clear();
		Thread.sleep(1000);
		GiftCardNumberInputBox.sendKeys(str);
		
		
		Thread.sleep(1000);
		BalanceInputBox.clear();
		Thread.sleep(1000);
		BalanceInputBox.sendKeys("300.00");
		
		Thread.sleep(1000);
		try
		{
		if(CardBtn.isDisplayed())
		{
		Thread.sleep(1000);
		CardBtn.click();
		
		Thread.sleep(500);
		CardTypeInputBox.click();
		
		Thread.sleep(500);
		Others_CardType.click();
		
		Thread.sleep(500);
		Last4DigitsInputBox.clear();
		Thread.sleep(500);
		Last4DigitsInputBox.sendKeys("1234");
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.INFO, "Payment Methods not Displayed");
		}
		
	}
}
