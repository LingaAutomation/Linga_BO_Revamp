package com.Pages;

import java.util.*;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_ThirdPartyIntegrations_Page extends BasePage
{
//	SelfHealingDriver driver;
//	ExtentTest test;
	Common_XPaths cmp;
	Utility ut=new Utility();
	
	public Settings_ThirdPartyIntegrations_Page(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='settings']/button")
	WebElement Settings;
	
	@FindBy(xpath = "//h3[contains(.,'Settings')]")
	WebElement Settings_Heading;
	
	@FindBy(xpath = "//h3[contains(.,'Third Party Integrations')]")
	WebElement ThirdPartyIntegrations;

	@FindBy(xpath = "//span[.='Platform Price Level']")
	WebElement PlatformPriceLevel;
	
	@FindBy(xpath = "//span[.='Urban Piper']")
	WebElement UrbanPiper;
	
	@FindBy(xpath = "//span[.='Chowly']")
	WebElement Chowly;
	
	@FindBy(xpath = "//span[.='Deliverect']")
	WebElement Deliverect;
	
	@FindBy(xpath = "//span[.='Door']")
	WebElement Doordash;
	
	@FindBy(xpath = "//span[.='Uber Eats']")
	WebElement UberEats;
	
	@FindBy(xpath = "//span[.='Yemek Sepeti']")
	WebElement YemekSepeti;
	
	@FindBy(xpath = "//span[.='PayPal']")
	WebElement PayPal;
	
	
	
	@FindBy(xpath = "//span[.='Compeat']")
	WebElement Compeat;
	
	@FindBy(xpath = "//span[.='Restaurant 365']")
	WebElement Restaurant;
	
	
	@FindBy(xpath = "//h3[.='Platform Price Level']")
	WebElement PlatformPriceLevel_Head;
	
	@FindBy(xpath = "//h4[.='Order Platform Price Level']")
	WebElement OrderPlatformPriceLevel;
	
	@FindBy(xpath = "//span[.='Urban Piper']/../../div[2]/div/div/app-selectbox/div/mat-form-field/div/div/div[3]/input")
	WebElement UrbanPiperInput;
	
	@FindBy(xpath = "//span[.='Urban Piper']/../../div[2]/div/div/app-selectbox/div/div/option-panel/div/div/select-option")
	WebElement UrbanPiperSelctOption;
	
	@FindBy(xpath = "//span[.='Urban Piper']/../../div/app-input/div/div/mat-form-field/div/div/div/input")
	WebElement UrbanPiperPriceInput;
	
	@FindBy(xpath = "//span[.='OLO']/../../div[2]/div/div/app-selectbox/div/mat-form-field/div/div/div[3]/input")
	WebElement OLOInput;
	
	@FindBy(xpath = "//span[.='OLO']/../../div[2]/div/div/app-selectbox/div/div/option-panel/div/div/select-option")
	WebElement OLOSelctOption;
	
	@FindBy(xpath = "//span[.='OLO']/../../div/app-input/div/div/mat-form-field/div/div/div/input")
	WebElement OLOPriceInput;
	
	@FindBy(xpath = "//span[.='Chowly']/../../div[2]/div/div/app-selectbox/div/mat-form-field/div/div/div[3]/input")
	WebElement ChowlyInput;
	
	@FindBy(xpath = "//span[.='Chowly']/../../div[2]/div/div/app-selectbox/div/div/option-panel/div/div/select-option")
	WebElement ChowlyOption;
	
	@FindBy(xpath = "//span[.='Chowly']/../../div/app-input/div/div/mat-form-field/div/div/div/input")
	WebElement ChowlyPriceInput;
	
	@FindBy(xpath = "//span[.='Deliverect']/../../div[2]/div/div/app-selectbox/div/mat-form-field/div/div/div[3]/input")
	WebElement DeliverectInput;
	
	@FindBy(xpath = "//span[.='Deliverect']/../../div[2]/div/div/app-selectbox/div/div/option-panel/div/div/select-option")
	WebElement DeliverectSelctOption;
	
	@FindBy(xpath = "//span[.='Deliverect']/../../div/app-input/div/div/mat-form-field/div/div/div/input")
	WebElement DeliverectPriceInput;
	
	@FindBy(xpath = "//span[.='Uber Eats']/../../div[2]/div/div/app-selectbox/div/mat-form-field/div/div/div[3]/input")
	WebElement UrbanEatsInput;
	
	@FindBy(xpath = "//span[.='Uber Eats']/../../div[2]/div/div/app-selectbox/div/div/option-panel/div/div/select-option")
	WebElement UrbanEatsSelctOption;
	
	@FindBy(xpath = "//span[.='Uber Eats']/../../div/app-input/div/div/mat-form-field/div/div/div/input")
	WebElement UrbanEatsPriceInput;
	
	@FindBy(xpath= "//button[contains(.,'SAVE')]")
	WebElement SaveBtn;
	
	@FindBy(xpath= "//button[contains(.,'SAVE') and @disabled='true']")
	WebElement SaveBtn_Disabled;
	
	@FindBy(xpath = "//h3[.='Urban Piper']")
	WebElement UrbanPiper_Head;
	
	@FindBy(xpath = "//h3[.='Yemek Sepeti']")
	WebElement YemekSepeti_Head;
	
	@FindBy(xpath = "//h4[.='Store Action']")
	WebElement StoreAction;
	
	@FindBy(xpath = "//h4[.='Integration Action']")
	WebElement IntegrationAction;
	
	@FindBy(xpath = "//h4[.='Menu Item Action']")
	WebElement MenuItemAction;
	
	@FindBy(xpath = "//button[.='STORE ACTION']")
	WebElement StoreActionBtn;
	
	@FindBy(xpath = "//button[contains(.,'PUBLISH STORE')]")
	WebElement PublishStoreBtn;
	
	@FindBy(xpath = "//button[.='MENU ITEM ACTION']")
	WebElement MenuItemActionBtn;
	
	@FindBy(xpath = "//button[contains(.,'PUBLISH MENU ITEM')]")
	WebElement PublishMenuItemBtn;
	
	@FindBy(xpath = "//h4[.='Store Action']/../div//div/span[.='Zomato']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement StoreActionZomato_No;
	
	@FindBy(xpath = "//h4[.='Store Action']/../div//div/span[.='Zomato']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement StoreActionZomato_Yes;
	
	@FindBy(xpath = "//h4[.='Store Action']/../div//div/span[.='Swiggy']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement StoreActionSwiggy_No;
	
	@FindBy(xpath = "//h4[.='Store Action']/../div//div/span[.='Swiggy']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement StoreActionSwiggy_Yes;
	
	@FindBy(xpath = "//h4[.='Store Action']/../div//div/span[.='Uber Eats']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement StoreActionUberEats_No;
	
	@FindBy(xpath = "//h4[.='Store Action']/../div//div/span[.='Uber Eats']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement StoreActionUberEats_Yes;
	
	@FindBy(xpath = "//h4[.='Store Action']/../div//div/span[.='Enable Store']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement StoreActionEnableStore_No;
	
	@FindBy(xpath = "//h4[.='Store Action']/../div//div/span[.='Enable Store']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement StoreActionEnableStore_Yes;
	
	@FindBy(xpath = "//h4[.='Integration Action']/../div//div/span[.='Zomato']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement IntegrationActionZomato_No;
	
	@FindBy(xpath = "//h4[.='Integration Action']/../div//div/span[.='Zomato']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement IntegrationActionZomato_Yes;
	
	@FindBy(xpath = "//h4[.='Integration Action']/../div//div/span[.='Swiggy']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement IntegrationActionSwiggy_No;
	
	@FindBy(xpath = "//h4[.='Integration Action']/../div//div/span[.='Swiggy']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement IntegrationActionSwiggy_Yes;
	
	@FindBy(xpath = "//h4[.='Integration Action']/../div//div/span[.='Uber Eats']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement IntegrationActionUberEats_No;
	
	@FindBy(xpath = "//h4[.='Integration Action']/../div//div/span[.='Uber Eats']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement IntegrationActionUberEats_Yes;
	
	@FindBy(xpath = "//div[.='Enable Menu Item']/../../div/div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement EnableMenuItem_No;
	
	@FindBy(xpath = "//div[.='Enable Menu Item']/../../div/div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement EnableMenuItem_Yes;
	
	@FindBy(xpath = "//h3[.='Chowly']")
	WebElement Chowly_Head;
	
	@FindBy(xpath = "//h4[.='Store Publish']")
	WebElement StorePublish;
	
	@FindBy(xpath = "//h4[.='Menu Publish']")
	WebElement MenuPublish;
	
	@FindBy(xpath = "//button[contains(.,'PUBLISH MENU')]")
	WebElement PublishMenu;
	
	@FindBy(xpath = "//button[.='PUBLISH MENU and @disabled='true']")
	WebElement PublishMenuDisabled;
	
	@FindBy(xpath = "//button[.='PUBLISH STORE']")
	WebElement PublishStore;
	
	@FindBy(xpath = "//span[contains(.,'Chowly API Key')]/../input")
	WebElement ChowlyAPIKey;
	
	@FindBy(xpath = "//span[contains(.,'Store Delivery Time')]/../input")
	WebElement StoreDeliveryTime;
	
	@FindBy(xpath = "//button[.='PUBLISH STORE' and @disabled='true']")
	WebElement PublishStore_Disabled;
	
	@FindBy(xpath = "//div[.='Publish Menu Items To Chowly']/../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement PublishMenuItemsToChowly_No;
	
	@FindBy(xpath = "//div[.='Publish Menu Items To Chowly']/../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement PublishMenuItemsToChowly_Yes;

	@FindBy(xpath = "//h3[.='Deliverect']")
	WebElement Deliverect_Head;
	
	@FindBy(xpath = "//span[contains(.,'Account ID')]/../input")
	WebElement AccountID;
	
	@FindBy(xpath = "//span[contains(.,'Location ID')]/../input")
	WebElement LocationID;
	
	@FindBy(xpath = "//div[.='Publish MenuItems To Deliverect']/../../div/div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement PublishMenuItemsToDeliverect_No;
	
	@FindBy(xpath = "//div[.='Publish MenuItems To Deliverect']/../../div/div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement PublishMenuItemsToDeliverect_Yes;
	
	@FindBy(xpath = "//h3[.='Doordash']")
	WebElement Doordash_Head;
	
	@FindBy(xpath = "//div[.='Enable Doordash Drive']/../../div/div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement EnableDoordashDrive_No;
	
	@FindBy(xpath = "//div[.='Enable Doordash Drive']/../../div/div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement EnableDoordashDrive_Yes;
	
	@FindBy(xpath = "//h3[.='Uber Eats']")
	WebElement UberEats_Head;
	
	@FindBy(xpath = "//div[.='Activate Integration']/../../div/div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement ActivateIntegaration_No;
	
	@FindBy(xpath = "//div[.='Activate Integration']/../../div/div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement ActivateIntegaration_Yes;
	
	@FindBy(xpath = "//div[.='Publish Menu Items To Uber Eats']/../../div/div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement PublishMenuItemsToUberEats_No;
	
	@FindBy(xpath = "//div[.='Publish Menu Items To Uber Eats']/../../div/div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement PublishMenuItemsToUberEats_Yes;
	
	@FindBy(xpath = "//span[contains(.,'User Name')]/../input")
	WebElement UserName;
	
	@FindBy(xpath = "//span[contains(.,'Password')]/../input")
	WebElement Password;
	
	@FindBy(xpath = "//span[contains(.,'Catalog Name')]/../input")
	WebElement CatalogName;
	
	@FindBy(xpath = "//span[contains(.,'Category Name')]/../input")
	WebElement CategoryName;
	
	@FindBy(xpath = "//span[contains(.,'Service Time')]/../input")
	WebElement ServiceTime;
	
	@FindBy(xpath = "//div[.='Is Restaurant Open']/../../div/div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement IsRestaurantOpen_No;
	
	@FindBy(xpath = "//div[.='Is Restaurant Open']/../../div/div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement IsRestaurantOpen_Yes;

	@FindBy(xpath = "//h3[.='PayPal']")
	WebElement PayPal_Head;
	
	@FindBy(xpath = "//h3[.='Compeat']")
	WebElement Compeat_Head;
	
	@FindBy(xpath = "//h3[.='Restaurant 365']")
	WebElement Restaurant_Head;
	
	
	@FindBy(xpath = "//h4[.='NLA Merchant']")
	WebElement NLAMerchant;
	
	@FindBy(xpath = "//h4[.='Store Location']")
	WebElement StoreLocation;
	
	@FindBy(xpath = "//span[contains(.,'Owners First')]/../input")
	WebElement OwnersFirstLastName;	

	@FindBy(xpath = "(//span[contains(.,'Address Type')]/../input)[1]")
	WebElement AddressType;
		
	@FindBy(xpath = "//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div")
	WebElement AddressTypeOption;
	
	@FindBy(xpath = "//span[contains(.,'Street Address')]/../input")
	WebElement StreetAddress;
	
	@FindBy(xpath = "//span[contains(.,'City, Town')]/../input")
	WebElement CityTownVillage;
	
	@FindBy(xpath = "(//span[contains(.,'Postal Code')]/../input)[1]")
	WebElement PostalCode;
	
	@FindBy(xpath = "//span[contains(.,'International')]/../input")
	WebElement InternationalEmail;
	
	@FindBy(xpath = "//span[contains(.,'Bank Name')]/../input")
	WebElement BankName;

	@FindBy(xpath = "//span[contains(.,'Account Type')]/../input")
	WebElement AccountType;
	
	@FindBy(xpath = "//span[contains(.,'Account Number')]/../input")
	WebElement AccountNumber;

	@FindBy(xpath = "//span[contains(.,'Routing Number')]/../input")
	WebElement RoutingNumber;

	@FindBy(xpath = "//span[contains(.,'Bank Swift Code')]/../input")
	WebElement BankSwiftCode;

	@FindBy(xpath = "//span[contains(.,'Account Holder Name')]/../input")
	WebElement AccountHolderName;

	@FindBy(xpath = "//span[contains(.,'Category Code')]/../input")
	WebElement CategoryCode;

	@FindBy(xpath = "(//span[contains(.,'Entity Type')]/../input)[1]")
	WebElement BusinessEntityType;

	@FindBy(xpath = "(//span[contains(.,'Identification Number')]/../input)[1]")
	WebElement IdentificationDocumentsType;

	@FindBy(xpath = "(//span[contains(.,'Business Type')]/../input)[1]")
	WebElement BusinessType_AddressType;

	@FindBy(xpath = "(//span[contains(.,'Documents Name')]/../input)[1]")
	WebElement IdentityDocumentsName;

	@FindBy(xpath = "(//span[contains(.,'Identification Number')]/../input)[2]")
	WebElement DocumentIdentificationNumber;

	@FindBy(xpath = "(//span[contains(.,'Documents Name')]/../input)[2]")
	WebElement LegalAgreementType;

	@FindBy(xpath = "//span[contains(.,'Location Name')]/../input")
	WebElement LocationName;

	@FindBy(xpath = "//span[contains(.,'Phone Number')]/../input")
	WebElement PhoneNumber;

	@FindBy(xpath = "(//span[contains(.,'Street')]/../input)[2]")
	WebElement Street;
	
	@FindBy(xpath = "//span[contains(.,'Apt, Suite')]/../input")
	WebElement Apartment;

	@FindBy(xpath = "(//span[contains(.,'City')]/../input)[2]")
	WebElement City;

	@FindBy(xpath = "//span[contains(.,'State')]/../input")
	WebElement State;

	@FindBy(xpath = "(//span[contains(.,'Zip/Postal')]/../input)[2]")
	WebElement ZipPostalCode;

	@FindBy(xpath = "//span[contains(.,'Availability')]/../input")
	WebElement Availability;

	@FindBy(xpath = "//span[contains(.,'Gratuity Type')]/../input")
	WebElement GratuityType;
	
	@FindBy(xpath = "//mat-icon[.='keyboard_backspace']/../..")
	WebElement Back;
	
	
	
	@FindBy(xpath = "//span[contains(.,'Date')]/../..//button")
	WebElement Date;
	
	
	
	@FindBy(xpath = "//span[contains(.,'PUSH DATA')]/../..//button")
	WebElement PUSH_DATA;
	
	
	@FindBy(xpath = "//span[contains(.,'EXPORT DATA')]/../..//button")
	WebElement EXPORT_DATA;
	
	public void ThirdPartyIntegrationsPage() throws Exception {
		Thread.sleep(2500);
		
		if(ThirdPartyIntegrations.isDisplayed()) {
			test.log(LogStatus.PASS, "Third Party Integrations heading displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Third Party Integrations heading is not displayed");
		}
		
		if(PlatformPriceLevel.isDisplayed()) {
			test.log(LogStatus.PASS, "Platform Price Level option is displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Platform Price Level option is not displayed");
		}
		
		if(UrbanPiper.isDisplayed()) {
			test.log(LogStatus.PASS, "Urban Piber option is displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Urban Piber option is not displayed");
		}
		
		if(Chowly.isDisplayed()) {
			test.log(LogStatus.PASS, "Chowly option is displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Chowly option is not displayed");
		}
		
		if(Deliverect.isDisplayed()) {
			test.log(LogStatus.PASS, "Deliverect option is displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Deliverect option is not displayed");
		}
		
		if(Doordash.isDisplayed()) {
			test.log(LogStatus.PASS, "Doordash option is displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Doordash option is not displayed");
		}
		
		if(UberEats.isDisplayed()) {
			test.log(LogStatus.PASS, "Uber Eats option is displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Uber Eats Option is not displayed");
		}
		
		if(YemekSepeti.isDisplayed()) {
			test.log(LogStatus.PASS, "Yemek Sepeti option is displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Yemek Sepeti option is not displayed");
		}
		
		if(PayPal.isDisplayed()) {
			test.log(LogStatus.PASS, "Paypal option is displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Paypal option is not displayed");
		}
	}
	
	public void PlatformPriceLevelPage() throws Exception {
		Thread.sleep(2500);
		PlatformPriceLevel.click();
		Thread.sleep(1500);
		
		if(PlatformPriceLevel_Head.isDisplayed()) {
			test.log(LogStatus.PASS, "Platform Price Level heading displayed successfully In Platform Price Level Page");
		}
		else {
			test.log(LogStatus.FAIL, "Platform Price Level heading is not displayed In Platform Price Level Page");
		}
		
		if(OrderPlatformPriceLevel.isDisplayed()) {
			test.log(LogStatus.PASS, "Order Platform Price Level option is displayed successfully In Platform Price Level Page");
		}
		else {
			test.log(LogStatus.FAIL, "Order Platform Price Level option is not displayed In Platform Price Level Page");
		}
		
		//click the Urban piper
		UrbanPiperInput.click();
		
		Thread.sleep(1000);
		
		List<WebElement> menuList=driver.findElements(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div"));
		
		int menuSize=menuList.size();
		
		if(menuSize<=3)
		{
			int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);

		driver.findElement(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div["+randomMenu+"]")).click();
		}
		else if(menuSize>3)
		{
			int randomMenu=ThreadLocalRandom.current().nextInt(1, 3);

		driver.findElement(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div["+randomMenu+"]")).click();
		
		}
		UrbanPiperPriceInput.clear();
		
		UrbanPiperPriceInput.sendKeys("30000");
		
		//click the OLO
		OLOInput.click();
		
		List<WebElement> menuList1=driver.findElements(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div"));
		
		int menuSize1=menuList1.size();
		
		int randomMenu1=ThreadLocalRandom.current().nextInt(2, menuSize1);
		

		if(menuSize<=3)
		{
			int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);

		driver.findElement(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div["+randomMenu+"]")).click();
		}
		else
		{
			int randomMenu=ThreadLocalRandom.current().nextInt(1, 3);

		driver.findElement(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div["+randomMenu+"]")).click();
		
		}
		OLOPriceInput.clear();
		
		OLOPriceInput.sendKeys("30000");
		
		
		//click the Chowly
		ChowlyInput.click();
		
		List<WebElement> menuList2=driver.findElements(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div"));
		
		int menuSize2=menuList2.size();
		
		int randomMenu2=ThreadLocalRandom.current().nextInt(2, menuSize2);
		
		driver.findElement(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div["+randomMenu2+"]")).click();

		ChowlyPriceInput.clear();
		
		ChowlyPriceInput.sendKeys("30000");
		
		
		
		//click the Deliverect
		DeliverectInput.click();
		
		List<WebElement> menuList3=driver.findElements(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div"));
		
		int menuSize3=menuList3.size();
		
		int randomMenu3=ThreadLocalRandom.current().nextInt(2, menuSize3);
		
		driver.findElement(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div["+randomMenu3+"]")).click();

		DeliverectPriceInput.clear();
		
		DeliverectPriceInput.sendKeys("30000");
		
		
		//click the Urban Eats
		UrbanEatsInput.click();
		
		List<WebElement> menuList4=driver.findElements(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div"));
		
		int menuSize4=menuList4.size();
		
		int randomMenu4=ThreadLocalRandom.current().nextInt(2, menuSize4);
		
		driver.findElement(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div["+randomMenu4+"]")).click();

		UrbanEatsPriceInput.clear();
		
		UrbanEatsPriceInput.sendKeys("30000");
		
		List<WebElement> s = driver.findElements(By.xpath("//p[contains(.,'Please enter less than or equal to 100 percentage')]"));
		
		if(s.size() == 5 && SaveBtn_Disabled.isDisplayed()) {
			test.log(LogStatus.PASS, "Warning message is not displayed when user enter the invalid modifiers percentage In Platform Price Level Page");
		}
		else {
			test.log(LogStatus.FAIL, "Warning message is displayed when user enter the invalid modifiers percentage In Platform Price Level Page");
		}
		Thread.sleep(3000);
		

		UrbanPiperPriceInput.clear();
		
		UrbanPiperPriceInput.sendKeys("1000");

		OLOPriceInput.clear();
		
		OLOPriceInput.sendKeys("1000");

		ChowlyPriceInput.clear();
		
		ChowlyPriceInput.sendKeys("1000");

		DeliverectPriceInput.clear();
		
		DeliverectPriceInput.sendKeys("1000");

		UrbanEatsPriceInput.clear();
		
		UrbanEatsPriceInput.sendKeys("1000");
		
		//click the Save button
		SaveBtn.click();
		
		Thread.sleep(2500);
		
		String s1 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s1.equals("Store Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Store Updated successfully message is displayed In Platform Price Level Page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Updated successfully message is not displayed In Platform Price Level Page");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		Back.click();
		Thread.sleep(3000);
	}
	
	public void UrbanPiperPage() throws Exception {
		Thread.sleep(2500);
		UrbanPiper.click();
		Thread.sleep(1500);
		
		if(UrbanPiper_Head.isDisplayed()) {
			test.log(LogStatus.PASS, "Urban Piper heading displayed successfully In Urban Piper Page");
		}
		else {
			test.log(LogStatus.FAIL, "Urban Piper heading is not displayed In Urban Piper Page");
		}
		
		if(StoreAction.isDisplayed()) {
			test.log(LogStatus.PASS, "Store Action option is displayed successfully In Urban Piper Page");
		}
		else {
			test.log(LogStatus.FAIL, "Store Action option is not displayed In Urban Piper Page");
		}
		
		if(IntegrationAction.isDisplayed()) {
			test.log(LogStatus.PASS, "Integration Action option is displayed successfully In Urban Piper Page");
		}
		else {
			test.log(LogStatus.FAIL, "Integration Action option is not displayed In Urban Piper Page");
		}
		
		if(MenuItemAction.isDisplayed()) {
			test.log(LogStatus.PASS, "Menu Item Action option is displayed successfully In Urban Piper Page");
		}
		else {
			test.log(LogStatus.FAIL, "Menu Item Action option is not displayed In Urban Piper Page");
		}
		
		StoreActionZomato_No.click();
		
		StoreActionZomato_Yes.click();
		
		StoreActionSwiggy_No.click();
		
		StoreActionSwiggy_Yes.click();
		
		StoreActionUberEats_No.click();
		
		StoreActionUberEats_Yes.click();
		
		StoreActionEnableStore_No.click();
		
		StoreActionEnableStore_Yes.click();
		
		StoreActionBtn.click();
		
		Thread.sleep(2500);
		
		String s1 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s1.equals("Store Action Synced Successfully"))
		{
			test.log(LogStatus.PASS, "Store Action have Synced successfully message is displayed In Urban Piper Page");
		}
		else if(s1.equals("Store Action have not Synced"))
		{
			test.log(LogStatus.FAIL, "Store Action have Synced successfully message is not displayed In Urban Piper Page");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		StoreActionZomato_No.click();
		
		StoreActionSwiggy_No.click();
		
		StoreActionUberEats_No.click();
		
		StoreActionEnableStore_No.click();
		
		StoreActionBtn.click();
		
		Thread.sleep(2500);
		
		String s2 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s2.equals("Store Action Synced Successfully"))
		{
			test.log(LogStatus.PASS, "Store Action have Synced successfully message is displayed In Urban Piper Page");
		}
		else if(s2.equals("Store Action have not Synced"))
		{
			test.log(LogStatus.FAIL, "Store Action have Synced successfully message is not displayed In Urban Piper Page");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);

		IntegrationActionZomato_No.click();
		
		IntegrationActionZomato_Yes.click();
		
		IntegrationActionSwiggy_No.click();
		
		IntegrationActionSwiggy_Yes.click();
		
		IntegrationActionUberEats_No.click();
		
		IntegrationActionUberEats_Yes.click();
		
		PublishMenuItemBtn.click();
		
		Thread.sleep(2500);
		
		String s3 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s3.equals("Store Action Synced Successfully"))
		{
			test.log(LogStatus.PASS, "Integration Action have Synced successfully message is displayed In Urban Piper Page");
		}
		else if(s3.equals("Store Action have not Synced"))
		{
			test.log(LogStatus.FAIL, "Integration Action have Synced successfully message is not displayed In Urban Piper Page");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		IntegrationActionZomato_No.click();
		
		IntegrationActionSwiggy_No.click();
		
		IntegrationActionUberEats_No.click();
		
		PublishMenuItemBtn.click();
		
		Thread.sleep(2500);
		
		String s4 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s4.equals("Store Action Synced Successfully"))
		{
			test.log(LogStatus.PASS, "Integration Action have Synced successfully message is displayed In Urban Piper Page");
		}
		else if(s4.equals("Store Action have not Synced"))
		{
			test.log(LogStatus.FAIL, "Integration Action have Synced successfully message is not displayed In Urban Piper Page");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);

		EnableMenuItem_No.click();
		
		EnableMenuItem_Yes.click();
		
		MenuItemActionBtn.click();
		
		Thread.sleep(2500);
		
		String s5 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s5.equals("Menu Items Synced Successfully"))
		{
			test.log(LogStatus.PASS, "Menu Items have Synced successfully message is displayed In Urban Piper Page");
		}
		else if(s5.equals("Menu Items have not Synced"))
		{
			test.log(LogStatus.FAIL, "Menu Items have Synced successfully message is not displayed In Urban Piper Page");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		PublishMenuItemBtn.click();
		
		String s6 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s6.equals("Menu Items Synced Successfully"))
		{
			test.log(LogStatus.PASS, "Menu Items have Synced successfully message is displayed In Urban Piper Page");
		}
		else if(s6.equals("Menu Items have not Synced"))
		{
			test.log(LogStatus.FAIL, "Menu Items have Synced successfully message is not displayed In Urban Piper Page");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		EnableMenuItem_No.click();
		
		PublishMenuItemBtn.click();
		
		String s7 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s7.equals("Menu Items Synced Successfully"))
		{
			test.log(LogStatus.PASS, "Menu Items have Synced successfully message is displayed In Urban Piper Page");
		}
		else if(s7.equals("Menu Items have not Synced"))
		{
			test.log(LogStatus.FAIL, "Menu Items have Synced successfully message is not displayed In Urban Piper Page");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		Back.click();
		Thread.sleep(3000);
	}

	public void ChowlyPage() throws Exception {
		Thread.sleep(2500);
		Chowly.click();
		Thread.sleep(5000);
		
		if(Chowly_Head.isDisplayed()) {
			test.log(LogStatus.PASS, "Chowly heading displayed successfully In Chowly Page");
		}
		else {
			test.log(LogStatus.FAIL, "Chowly heading is not displayed In Chowly Page");
		}
		
		if(StorePublish.isDisplayed()) {
			test.log(LogStatus.PASS, "Store Publish option is displayed successfully In Chowly Page");
		}
		else {
			test.log(LogStatus.FAIL, "Store Publish option is not displayed In Chowly Page");
		}
		
		if(MenuPublish.isDisplayed()) {
			test.log(LogStatus.PASS, "Menu Publish option is displayed successfully In Chowly Page");
		}
		else {
			test.log(LogStatus.FAIL, "Menu Publish option is not displayed In Chowly Page");
		}		
		
		try {
			if(PublishStore_Disabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Publish Store button is disabled successfully when there is no change In Chowly Page");
			}
		}
		catch(Exception d) {
			test.log(LogStatus.FAIL, "Publish Store button is enabled when there is no change In Chowly Page");
		}

		try {
			
			ChowlyAPIKey.clear();
			
			ChowlyAPIKey.sendKeys(RandomStringUtils.randomAlphanumeric(25));
			
			ChowlyAPIKey.clear();
		}catch(Exception v) {}
		StoreDeliveryTime.clear();
		
		try {
			if(PublishStore_Disabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Publish Store button is disabled successfully when there is Chowly API Key, Store Delivery Time fields are empty In Chowly Page");
			}
		}
		catch(Exception d) {
			test.log(LogStatus.FAIL, "Publish Store button is enabled when there is Chowly API Key, Store Delivery Time fields are empty In Chowly Page");
		}
		
		try {
			ChowlyAPIKey.clear();
			
			ChowlyAPIKey.sendKeys(RandomStringUtils.randomAlphanumeric(25));
		}catch(Exception v) {}

		
		try {
			if(PublishStore_Disabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Publish Store button is disabled successfully when there is Store Delivery Time field is empty In Chowly Page");
			}
		}
		catch(Exception d) {
			test.log(LogStatus.FAIL, "Publish Store button is enabled when there is Store Delivery Time field is empty In Chowly Page");
		}
		
		String ss = "Abcdef";
				
		StoreDeliveryTime.sendKeys(ss);
		
		String sa = StoreDeliveryTime.getAttribute("value");

		if(ss.equals(sa)) {
			test.log(LogStatus.FAIL, "Store Delivery Time field accepts the text In Chowly Page");
		}
		else {
			test.log(LogStatus.PASS, "Store Delivery Time field is not accepts the text In Chowly Page");
		}
		
		StoreDeliveryTime.clear();
		
		StoreDeliveryTime.sendKeys("1:00");
		
		PublishStoreBtn.click();
		
		String s7 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s7.equals("Chowly API Key successfully configured for this store"))
		{
			test.log(LogStatus.PASS, "Chowly API Key successfully configured for this store message is displayed In Chowly Page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Chowly API Key successfully configured for this store message is not displayed In Chowly Page");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		PublishMenuItemsToChowly_No.click();
		
		PublishMenuItemsToChowly_Yes.click();
		
		PublishMenu.click();
		Thread.sleep(3000);
		
		String s6 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s6.equals("Menu Items Synced Successfully"))
		{
			test.log(LogStatus.PASS, "Menu Items Synced Successfully message is displayed In Chowly Page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Items Synced Successfully message is not displayed In Chowly Page");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		PublishMenuItemsToChowly_No.click();
		
		try {
			if(PublishMenuDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Publish Menu button is disabled successfully when there is Publish Menu Items To Chowly button is Disabled In Chowly Page");
			}
		}
		catch(Exception d) {
			test.log(LogStatus.FAIL, "Publish Menu button is enabled when there is Publish Menu Items To Chowly button is Disabled In Chowly Page");
		
			PublishMenu.click();
			Thread.sleep(3000);
			
			String s5 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s5.equals("Menu Items Synced Successfully"))
			{
				test.log(LogStatus.PASS, "Menu Items Synced Successfully message is displayed In Chowly Page");
			}
			else
			{
				test.log(LogStatus.FAIL, "Menu Items Synced Successfully message is not displayed In Chowly Page");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
			
		Back.click();
		Thread.sleep(3000);
	}

	public void DeliverectPage() throws Exception {
		Thread.sleep(2500);
		Deliverect.click();
		Thread.sleep(1500);
		
		if(Deliverect_Head.isDisplayed()) {
			test.log(LogStatus.PASS, "Deliverect heading displayed successfully In Deliverect Page");
		}
		else {
			test.log(LogStatus.FAIL, "Deliverect heading is not displayed In Deliverect Page");
		}
		
		if(StorePublish.isDisplayed()) {
			test.log(LogStatus.PASS, "Store Publish option is displayed successfully In Deliverect Page");
		}
		else {
			test.log(LogStatus.FAIL, "Store Publish option is not displayed In Deliverect Page");
		}
		
		if(MenuPublish.isDisplayed()) {
			test.log(LogStatus.PASS, "Menu Publish option is displayed successfully In Deliverect Page");
		}
		else {
			test.log(LogStatus.FAIL, "Menu Publish option is not displayed In Deliverect Page");
		}
		
		
		try {
			if(PublishStore_Disabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Publish Store button is disabled successfully when there is no change In Deliverect Page");
			}
		}
		catch(Exception d) {
			test.log(LogStatus.FAIL, "Publish Store button is enabled when there is no change In Deliverect Page");
		}
		
		AccountID.clear();
		
		AccountID.sendKeys(RandomStringUtils.randomNumeric(5));
		
		AccountID.clear();
		
		LocationID.clear();
		
		try {
			if(PublishStore_Disabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Publish Store button is disabled successfully when there is Account ID, Location ID fields are empty In Deliverect Page");
			}
		}
		catch(Exception d) {
			test.log(LogStatus.FAIL, "Publish Store button is enabled when there is Account ID, Location ID fields are empty In Deliverect Page");
		}
		
		AccountID.clear();
		
		AccountID.sendKeys(RandomStringUtils.randomAlphanumeric(25));
		
		try {
			if(PublishStore_Disabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Publish Store button is disabled successfully when there is Location ID field is empty In Deliverect Page");
			}
		}
		catch(Exception d) {
			test.log(LogStatus.FAIL, "Publish Store button is enabled when there is Location ID field is empty In Deliverect Page");
		}
		
		LocationID.clear();
		
		LocationID.sendKeys(RandomStringUtils.randomAlphanumeric(25));
		
		PublishStoreBtn.click();
		
		Thread.sleep(2500);
		
		String s7 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s7.equals("Store Published Successfully"))
		{
			test.log(LogStatus.PASS, "Store Published Successfully message is displayed In Deliverect Page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Published Successfully message is not displayed In Deliverect Page");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		PublishMenuItemsToDeliverect_No.click();
		
		PublishMenuItemsToDeliverect_Yes.click();
		
		PublishMenu.click();
		Thread.sleep(3000);
		
		String s6 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s6.equals("Menu Items Synced Successfully"))
		{
			test.log(LogStatus.PASS, "Menu Items Synced Successfully message is displayed In Deliverect Page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Items Synced Successfully message is not displayed In Deliverect Page");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		PublishMenuItemsToDeliverect_No.click();
			
		try {
			if(PublishMenuDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Publish Menu button is disabled successfully when there is Publish Menu Items To Deliverect button is Disabled In Deliverect Page");
			}
		}
		catch(Exception d) {
			test.log(LogStatus.FAIL, "Publish Menu button is enabled when there is Publish Menu Items To Deliverect button is Disabled In Deliverect Page");
		
			PublishMenu.click();
			Thread.sleep(3000);
			
			String s5 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s5.equals("Menu Items Synced Successfully"))
			{
				test.log(LogStatus.PASS, "Menu Items Synced Successfully message is displayed In Deliverect Page");
			}
			else
			{
				test.log(LogStatus.FAIL, "Menu Items Synced Successfully message is not displayed In Deliverect Page");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
	
		Back.click();
		Thread.sleep(3000);
	}
	
	public void DoordashPage() throws Exception {
		Thread.sleep(2500);
		Doordash.click();
		Thread.sleep(1500);
		
		if(Doordash_Head.isDisplayed()) {
			test.log(LogStatus.PASS, "Doordash heading displayed successfully In Doordash Page");
		}
		else {
			test.log(LogStatus.FAIL, "Doordash heading is not displayed In Doordash Page");
		}
		
		if(StoreAction.isDisplayed()) {
			test.log(LogStatus.PASS, "Store Action option is displayed successfully In Doordash Page");
		}
		else {
			test.log(LogStatus.FAIL, "Store Action option is not displayed In Doordash Page");
		}
		
		String t = driver.findElement(By.xpath("//button[@aria-pressed='true']/span")).getText();

		if(t.equals("YES")) {
			EnableDoordashDrive_No.click();
		}else {
			EnableDoordashDrive_Yes.click();
		}
		
		Thread.sleep(2500);
		
		String s7 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s7.equals("Store Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Store Updated Successfully message is displayed In Doordash Page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Updated Successfully message is not displayed In Doordash Page");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		String t1 = driver.findElement(By.xpath("//button[@aria-pressed='true']/span")).getText();

		if(t1.equals("YES")) {
			EnableDoordashDrive_No.click();
		}else {
			EnableDoordashDrive_Yes.click();
		}
		
		Thread.sleep(2500);
		
		String s6 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s6.equals("Store Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Store Updated Successfully message is displayed In Doordash Page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Updated Successfully message is not displayed In Doordash Page");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(4000);
	
		Back.click();
		Thread.sleep(3000);
	}
	
	
	public void UberEatsPage() throws Exception {
		Thread.sleep(2500);
		UberEats.click();
		Thread.sleep(1500);
		
		if(UberEats_Head.isDisplayed()) {
			test.log(LogStatus.PASS, "Uber Eats heading displayed successfully In Uber Eats Page");
		}
		else {
			test.log(LogStatus.FAIL, "Uber Eats heading is not displayed In Uber Eats Page");
		}
				
		if(StorePublish.isDisplayed()) {
			test.log(LogStatus.PASS, "Store Publish option is displayed successfully In Uber Eats Page");
		}
		else {
			test.log(LogStatus.FAIL, "Store Publish option is not displayed In Uber Eats Page");
		}
		
		if(MenuPublish.isDisplayed()) {
			test.log(LogStatus.PASS, "Menu Publish option is displayed successfully In Uber Eats Page");
		}
		else {
			test.log(LogStatus.FAIL, "Menu Publish option is not displayed In Uber Eats Page");
		}
		
		LocationID.clear();
		
		LocationID.sendKeys(RandomStringUtils.randomAlphanumeric(25));
		
		ActivateIntegaration_No.click();
		
		//ActivateIntegaration_Yes.click();
		
		PublishStoreBtn.click();
		
		Thread.sleep(2500);
		
        try
        {
    		String s7 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
    		
    		//Verify the success message
    		if(s7.equals("Store Updated Successfully"))
    		{
    			test.log(LogStatus.PASS, "Store Updated Successfully message is displayed In Uber Eats Page");
    		}
    		else
    		{
    			test.log(LogStatus.FAIL, "Store Updated Successfully message is not displayed In Uber Eats Page");
    		}
    		
    		//Click the close button of success message
    		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
    		Thread.sleep(3000);
        }catch(Exception d) {
        	
        }		/*
		 * Set<String> handlesSet = driver.getWindowHandles(); ArrayList<String>
		 * handlesList = new ArrayList<String>(handlesSet);
		 * driver.switchTo().window(handlesList.get(1));Thread.sleep(2500);
		 * driver.close(); driver.switchTo().window(handlesList.get(0));
		 */

		
		ActivateIntegaration_No.click();
		
		PublishStoreBtn.click();
		
		Thread.sleep(2000);
		
		String s6 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s6.equals("Store Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Store Updated Successfully message is displayed In Uber Eats Page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Updated Successfully message is not displayed In Uber Eats Page");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);		
		
		PublishMenuItemsToUberEats_No.click();
		
//		PublishMenuItemsToUberEats_Yes.click();
		
		PublishMenuItemBtn.click();
		Thread.sleep(1000);
//        Set<String> handlesSet1 = driver.getWindowHandles();
//        ArrayList<String> handlesList1 = new ArrayList<String>(handlesSet1);
//        driver.switchTo().window(handlesList1.get(1));
//        driver.close();
//        driver.switchTo().window(handlesList1.get(0));
		
		try {
			String s5 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s5.equals("Menu Items Synced Successfully"))
			{
				test.log(LogStatus.PASS, "Menu Items Synced Successfully message is displayed In Uber Eats Page");
			}
			else
			{
				test.log(LogStatus.FAIL, "Menu Items Synced Successfully message is not displayed In Uber Eats Page");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}catch(Exception d) {
			test.log(LogStatus.FAIL, "Menu Items Synced Successfully message is not displayed In Uber Eats Page");
		}
		
		PublishMenuItemsToUberEats_No.click();
			
		try {
			if(PublishMenuDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Publish Menu button is disabled successfully when there is Publish Menu Items To Uber Eats button is Disabled In Uber Eats Page");
			}
		}
		catch(Exception d) {
			test.log(LogStatus.FAIL, "Publish Menu button is enabled when there is Publish Menu Items To Uber Eats button is Disabled In Uber Eats Page");
		
			PublishMenuItemBtn.click();
			Thread.sleep(3000);
			
			try {
				String s4 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
				
				//Verify the success message
				if(s4.equals("Menu Items Synced Successfully"))
				{
					test.log(LogStatus.PASS, "Menu Items Synced Successfully message is displayed In Uber Eats Page");
				}
				else
				{
					test.log(LogStatus.FAIL, "Menu Items Synced Successfully message is not displayed In Uber Eats Page");
				}
				
				//Click the close button of success message
				driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
				Thread.sleep(3000);
			}catch(Exception dq) {
				test.log(LogStatus.FAIL, "Menu Items Synced Successfully message is not displayed In Uber Eats Page");
			}
		}
		
		Back.click();
		Thread.sleep(3000);
	}

	public void YemekSepetiPage() throws Exception {
		Thread.sleep(2500);
		YemekSepeti.click();
		Thread.sleep(1500);
		
		if(YemekSepeti_Head.isDisplayed()) {
			test.log(LogStatus.PASS, "Yemek Sepeti heading displayed successfully In Yemek Sepeti Page");
		}
		else {
			test.log(LogStatus.FAIL, "Yemek Sepeti heading is not displayed In Yemek Sepeti Page");
		}
		
		UserName.clear();
		
		Password.clear();
		
		CatalogName.clear();
		
		CategoryName.clear();
		
		ServiceTime.clear();
		
		try {
			if(SaveBtn_Disabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled successfully when there is no mandatory fields are filled In Yemek Sepeti Page");
			}
		}
		catch(Exception d) {
			test.log(LogStatus.FAIL, "Save button is enabled when there is no mandatory fields are filled In Yemek Sepeti Page");
		}
		
		UserName.clear();
		
		UserName.sendKeys(RandomStringUtils.randomAlphanumeric(25));
		
		Password.clear();
		
		Password.sendKeys(RandomStringUtils.randomAlphanumeric(25));
		
		CatalogName.clear();
		
		CatalogName.sendKeys(RandomStringUtils.randomAlphanumeric(25));
		
		CategoryName.clear();
		
		CategoryName.sendKeys(RandomStringUtils.randomAlphanumeric(25));
		
		String ss = "Abcdef";
				
		ServiceTime.sendKeys(ss);
		
		String sa = ServiceTime.getAttribute("value");

		if(ss.equals(sa)) {
			test.log(LogStatus.FAIL, "Service Time field accepts the text In Uber Eats Page");
		}
		else {
			test.log(LogStatus.PASS, "Service Time field is not accepts the text In Uber Eats Page");
		}
		
		ServiceTime.clear();
		
		ServiceTime.sendKeys("1:00");
			
		IsRestaurantOpen_No.click();
		
		IsRestaurantOpen_Yes.click();
		
		SaveBtn.click();
		
		Thread.sleep(2500);
		
		String s7 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s7.equals("Store Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Store Updated Successfully message is displayed In Uber Eats Page");
		}
		else if(s7.equals("Internal Server Error"))
		{
			test.log(LogStatus.FAIL, "Store Updated Successfully message is not displayed In Uber Eats Page");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
				
		IsRestaurantOpen_No.click();
		
		SaveBtn.click();
		
		Thread.sleep(2500);
		
		String s6 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s6.equals("Store Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Store Updated Successfully message is displayed In Uber Eats Page");
		}
		else if(s6.equals("Internal Server Error"))
		{
			test.log(LogStatus.FAIL, "Store Updated Successfully message is not displayed In Uber Eats Page");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		Back.click();
		Thread.sleep(3000);
	}
	
	public void PayPalPage() throws Exception {
		Thread.sleep(2500);
		PayPal.click();
		Thread.sleep(1500);
		
		if(PayPal_Head.isDisplayed()) {
			test.log(LogStatus.PASS, "PayPal heading displayed successfully In PayPal Page");
		}
		else {
			test.log(LogStatus.FAIL, "PayPal heading is not displayed In PayPal Page");
		}	
		
		if(NLAMerchant.isDisplayed()) {
			test.log(LogStatus.PASS, "NLAMerchant option displayed successfully In PayPal Page");
		}
		else {
			test.log(LogStatus.FAIL, "NLAMerchant option is not displayed In PayPal Page");
		}
		
		if(StoreLocation.isDisplayed()) {
			test.log(LogStatus.PASS, "Store Location option displayed successfully In PayPal Page");
		}
		else {
			test.log(LogStatus.FAIL, "Store Location option is not displayed In PayPal Page");
		}
		
		try {
			if(SaveBtn_Disabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled successfully when there is no changes are done In Paypal Page");
			}
		}
		catch(Exception d) {
			test.log(LogStatus.FAIL, "Save button is enabled when there is no changes are done In Paypal Page");
		}
		
		OwnersFirstLastName.clear();
			
//		try {
//			String a = driver.findElement(By.xpath("//mat-hint[.='Enter Individual Owners Name']")).getText();
//
//			if(a.equals("Enter Individual Owners Name")) {
//				test.log(LogStatus.PASS, "Enter Individual Owners Name warning message is displayed when user not entering the Owners Name");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter Individual Owners Name warning message is not displayed when user not entering the Owners Name");
//		}
		
		OwnersFirstLastName.sendKeys(RandomStringUtils.randomAlphabetic(60));
		
		int acount = OwnersFirstLastName.getAttribute("value").length();
		
		if(acount == 60) {
			test.log(LogStatus.FAIL, "Owners First Name/Last Name field accept the more than 50 characters");
		}else if(acount == 50)
		{
			test.log(LogStatus.FAIL, "Owners First Name/Last Name field accept the 50 characters only");
		}
		
		//click the Address Type
		AddressType.click();
		
		Thread.sleep(1000);
		
		List<WebElement> menuList=driver.findElements(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div"));
		
		int menuSize=menuList.size();
		
		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
		
		driver.findElement(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div["+randomMenu+"]")).click();

		StreetAddress.clear();
				
//		try {		String a1 = driver.findElement(By.xpath("//mat-hint[.='Enter Address']")).getText();
//
//			if(a1.equals("Enter Address")) {
//				test.log(LogStatus.PASS, "Enter Address warning message is displayed when user not entering the Street address");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter Address warning message is not displayed when user not entering the Street address");
//		}
		
		StreetAddress.sendKeys(RandomStringUtils.randomAlphanumeric(25));
		
		CityTownVillage.clear();
						
//		try {	String a2 = driver.findElement(By.xpath("//mat-hint[.='Enter Address']")).getText();
//
//			if(a2.equals("Enter Address")) {
//				test.log(LogStatus.PASS, "Enter Address warning message is displayed when user not entering the City, Town or Village");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter Address warning message is not displayed when user not entering the City, Town or Village");
//		}
		
		CityTownVillage.sendKeys(RandomStringUtils.randomAlphanumeric(25));
		
		PostalCode.clear();
					
//		try {
//			String a3 = driver.findElement(By.xpath("//mat-hint[.='Postal Code should be 4 to 15 characters']")).getText();
//			
//			if(a3.equals("Postal Code should be 4 to 15 characters")) {
//				test.log(LogStatus.PASS, "Postal Code should be 4 to 15 characters warning message is displayed when user not entering the Postal Code");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Postal Code should be 4 to 15 characters warning message is not displayed when user not entering the Postal Code");
//		}
		
		PostalCode.sendKeys(RandomStringUtils.randomAlphanumeric(25));
		
		int acount1 = PostalCode.getAttribute("value").length();
		
		if(acount1 == 25) {
			test.log(LogStatus.FAIL, "Zip/Postal Code field accept the more than 15 characters");
		}else if(acount1 == 15)
		{
			test.log(LogStatus.PASS, "Zip/Postal Code field accept the more than 15 characters only");
			try {
				if(driver.findElement(By.xpath("//p[.='Zip code should be 4 to 15 characters']")).isDisplayed()) {
					test.log(LogStatus.FAIL, "Zip code field validation message is displayed, even we enter the 15 characters");
				}
			}catch(Exception d) {}
		}
		
		InternationalEmail.clear();
		
//		try {
//			
//			String a4 = driver.findElement(By.xpath("//mat-hint[.='Enter valid email']")).getText();
//
//			if(a4.equals("Enter valid email")) {
//				test.log(LogStatus.PASS, "Enter valid email warning message is displayed when user not entering the International Email");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter valid email warning message is not displayed when user not entering the International Email");
//		}
		
//		InternationalEmail.sendKeys("test");
//		
//		
//		try {
//			String a5 = driver.findElement(By.xpath("//mat-hint[.='Enter valid email']")).getText();
//
//			if(a5.equals("Enter valid email")) {
//				test.log(LogStatus.PASS, "Enter valid email warning message is displayed when user entering the Invalid International Email");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter valid email warning message is not displayed when user entering the Invalid International Email");
//		}
//		
//		InternationalEmail.sendKeys("test@");
//		
//		
//		try {
//			String a6 = driver.findElement(By.xpath("//mat-hint[.='Enter valid email']")).getText();
//
//			if(a6.equals("Enter valid email")) {
//				test.log(LogStatus.PASS, "Enter valid email warning message is displayed when user entering the Invalid International Email");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter valid email warning message is not displayed when user entering the Invalid International Email");
//		}
//		
//		InternationalEmail.sendKeys("test@co");
//				
//		try {		String a7 = driver.findElement(By.xpath("//mat-hint[.='Enter valid email']")).getText();
//
//			if(a7.equals("Enter valid email")) {
//				test.log(LogStatus.PASS, "Enter valid email warning message is displayed when user entering the Invalid International Email");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter valid email warning message is not displayed when user entering the Invalid International Email");
//		}
//		
//		InternationalEmail.sendKeys("test@co.");
//		
//		
//		try {		String a8 = driver.findElement(By.xpath("//mat-hint[.='Enter valid email']")).getText();
//
//			if(a8.equals("Enter valid email")) {
//				test.log(LogStatus.PASS, "Enter valid email warning message is displayed when user entering the Invalid International Email");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter valid email warning message is not displayed when user entering the Invalid International Email");
//		}
		
		InternationalEmail.sendKeys("test@co.com");
		
		BankName.clear();
//		
//		
//		try {		String ab = driver.findElement(By.xpath("//mat-hint[.='Enter Bank Name']")).getText();
//	
//			if(ab.equals("Enter Bank Name")) {
//				test.log(LogStatus.PASS, "Enter Bank Name warning message is displayed when user not entering the Bank Name");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter Bank Name warning message is not displayed when user not entering the Bank Name");
//		}
//		
		BankName.sendKeys(RandomStringUtils.randomAlphabetic(60));
		
		int acount2 = BankName.getAttribute("value").length();
		
		if(acount2 == 60) {
			test.log(LogStatus.FAIL, "Bank Name field accept the more than 50 characters");
		}else if(acount2 == 50)
		{
			test.log(LogStatus.PASS, "Bank Name field accept the 50 characters only");
		}
		
		Thread.sleep(5000);
			
		AccountType.clear();
						
//		try {		String a9 = driver.findElement(By.xpath("//mat-hint[.='Enter Account Number Type']")).getText();
//
//			if(a9.equals("Enter Account Number Type")) {
//				test.log(LogStatus.PASS, "Enter Account Number Type warning message is displayed when user not entering the Account Number Type");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter Account Number Type warning message is not displayed when user not entering the Account Number Type");
//		}
		
		AccountType.sendKeys(RandomStringUtils.randomAlphanumeric(25));
		
		AccountNumber.clear();
		AccountNumber.sendKeys(RandomStringUtils.randomAlphabetic(60));
		
		int acounta2 = AccountNumber.getAttribute("value").length();
		
		if(acounta2 == 60) {
			test.log(LogStatus.FAIL, "Account Number field accept the more than 50 characters");
		}else if(acount2 == 50)
		{
			test.log(LogStatus.PASS, "Account Number field accept the 50 characters only");
		}
		
		RoutingNumber.clear();
			
//		try {		String ab1 = driver.findElement(By.xpath("//mat-hint[.='Enter Routing Number']")).getText();
//		
//			if(ab1.equals("Enter Routing Number")) {
//				test.log(LogStatus.PASS, "Enter Routing Number warning message is displayed when user not entering the Routing Number");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter Routing Number warning message is not displayed when user not entering the Routing Number");
//		}
		
		RoutingNumber.sendKeys(RandomStringUtils.randomAlphabetic(60));
		
		int acount3 = RoutingNumber.getAttribute("value").length();
		
		if(acount3 == 60) {
			test.log(LogStatus.FAIL, "Routing Number field accept the more than 50 characters");
		}else if(acount3 == 50)
		{
			test.log(LogStatus.FAIL, "Routing Number field accept the 50 characters only");
		}
		Thread.sleep(5000);
		BankSwiftCode.clear();	
				
//		try {		String a10 = driver.findElement(By.xpath("//mat-hint[.='Enter BIC']")).getText();
//
//			if(a10.equals("Enter BIC")) {
//				test.log(LogStatus.PASS, "Enter BIC warning message is displayed when user not entering the Bank Swift Code");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter BIC warning message is not displayed when user not entering the Bank Swift Code");
//		}
//		
		BankSwiftCode.sendKeys(RandomStringUtils.randomAlphanumeric(25));
		
		AccountHolderName.clear();
		
//		try {		
//			String ab2 = driver.findElement(By.xpath("//mat-hint[.='Enter Account Holder Name']")).getText();
//
//			if(ab2.equals("Enter Account Holder Name")) {
//				test.log(LogStatus.PASS, "Enter Account Holder Name warning message is displayed when user not entering the Account Holder Number");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter Account Holder Name warning message is not displayed when user not entering the Account Holder Number");
//		}
		
		AccountHolderName.sendKeys(RandomStringUtils.randomAlphabetic(60));
		
		int acount4 = AccountHolderName.getAttribute("value").length();
		
		if(acount4 == 60) {
			test.log(LogStatus.FAIL, "Account Holder Name field accept the more than 50 characters");
		}else if(acount4 == 50)
		{
			test.log(LogStatus.FAIL, "Account Holder Name field accept the 50 characters only");
		}
		
		
		//click the Category Code
		CategoryCode.click();
		
		Thread.sleep(1000);
		
		List<WebElement> menuList1=driver.findElements(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div"));
		
		int menuSize1=menuList1.size();
		
		int randomMenu1=ThreadLocalRandom.current().nextInt(1, menuSize1);
		
		driver.findElement(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div["+randomMenu1+"]")).click();
		Thread.sleep(5000);
		
		//click the Business Entity Type
		BusinessEntityType.click();
		
		Thread.sleep(1000);
		
		List<WebElement> menuList2=driver.findElements(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div"));
		
		int menuSize2=menuList2.size();
		
		int randomMenu2=ThreadLocalRandom.current().nextInt(1, menuSize2);
		
		driver.findElement(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div["+randomMenu2+"]")).click();

		
		//click the Identification Documents Type
		IdentificationDocumentsType.click();
		
		Thread.sleep(1000);
		
		List<WebElement> menuList3=driver.findElements(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div"));
		
		int menuSize3=menuList3.size();
		
		int randomMenu3=ThreadLocalRandom.current().nextInt(1, menuSize3);
		
		driver.findElement(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div["+randomMenu3+"]")).click();
																																																																																																													
		Thread.sleep(5000);
		//click the Address Type
		BusinessType_AddressType.click();
		
		Thread.sleep(1000);
		
		List<WebElement> menuList4=driver.findElements(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div"));
		
		int menuSize4=menuList4.size();
		
		int randomMenu4=ThreadLocalRandom.current().nextInt(1, menuSize4);
		
		driver.findElement(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div["+randomMenu4+"]")).click();

		IdentityDocumentsName.clear();
		
		IdentityDocumentsName.sendKeys(RandomStringUtils.randomAlphabetic(60));
		
		int acount5 = IdentityDocumentsName.getAttribute("value").length();
		
		if(acount5 == 60) {
			test.log(LogStatus.FAIL, "Identity Documents Name field accept the more than 50 characters");
		}else if(acount5 == 50)
		{
			test.log(LogStatus.FAIL, "Identity Documents Name field accept the 50 characters only");
		}
		Thread.sleep(5000);
		DocumentIdentificationNumber.clear();
	
		DocumentIdentificationNumber.sendKeys(RandomStringUtils.randomAlphabetic(60));
		
		int acount6 = DocumentIdentificationNumber.getAttribute("value").length();
		
		if(acount6 == 60) {
			test.log(LogStatus.FAIL, "Document Identification Number field accept the more than 50 characters");
		}else if(acount6 == 50)
		{
			test.log(LogStatus.FAIL, "Document Identification Number field accept the 50 characters only");
		}
		
		
		//////////  Store Location
		
		LocationName.clear();
				
//		try {		String ab3 = driver.findElement(By.xpath("//mat-hint[.='Enter Location Name']")).getText();
//
//			if(ab3.equals("Enter Location Name")) {
//				test.log(LogStatus.PASS, "Enter Location Name warning message is displayed when user not entering the Location Name");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter Location Name warning message is not displayed when user not entering the Location Name");
//		}
		
		LocationName.sendKeys(RandomStringUtils.randomAlphabetic(60));
		
		int acount7 = LocationName.getAttribute("value").length();
		
		if(acount7 == 60) {
			test.log(LogStatus.FAIL, "Location Name field accept the more than 50 characters");
		}else if(acount7 == 45)
		{
			test.log(LogStatus.PASS, "Location Name field accept the 50 characters only");
		try {
			if(driver.findElement(By.xpath("//p[.='Enter Location Name Below 45 characters']")).isDisplayed()) {
				test.log(LogStatus.FAIL, "Enter Location Name Below 45 characters message is displayed when the field allows only 45 characters");
			}
		}catch(Exception d) {}
		}
		
		PhoneNumber.clear();
				
//		try {		String ab4 = driver.findElement(By.xpath("//mat-hint[.='Enter valid phone number']")).getText();
//
//			if(ab4.equals("Enter valid phone number")) {
//				test.log(LogStatus.PASS, "Enter valid phone number warning message is displayed when user not entering the phone number");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter valid phone number warning message is not displayed when user not entering the phone number");
//		}
		
		PhoneNumber.sendKeys(RandomStringUtils.randomAlphabetic(4));
			
		try {		String ab5 = driver.findElement(By.xpath("//p[.='Phone number should be contain atleast 10 digits.']")).getText();

			if(ab5.equals("Phone number should be contain atleast 10 digits.")) {
				test.log(LogStatus.PASS, "Phone Number should contain atleast 10 digits warning message is displayed when user entering the invalid phone number");
			}
		}catch(Exception r) {
			test.log(LogStatus.FAIL, "Phone Number should contain atleast 10 digits warning message is not displayed when user entering the invalid phone number");
		}
		
		PhoneNumber.sendKeys(RandomStringUtils.randomAlphabetic(10));
		
		int acount8 = PhoneNumber.getAttribute("value").length();
		
		if(acount8 == 60) {
			test.log(LogStatus.FAIL, "Location Name field accept the more than 50 characters");
		}else if(acount8 == 10)
		{
			test.log(LogStatus.PASS, "Location Name field accept the 50 characters only");
		}
		
		Street.clear();
				
//		try {		String ab6 = driver.findElement(By.xpath("//mat-hint[.='Enter Address']")).getText();
//
//			if(ab6.equals("Enter Address")) {
//				test.log(LogStatus.PASS, "Enter Address warning message is displayed when user not entering the Street");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter Address warning message is not displayed when user not entering the Street");
//		}
		
		Street.sendKeys(RandomStringUtils.randomAlphabetic(60));
		
		int acount9 = Street.getAttribute("value").length();
		
		if(acount9 == 60) {
			test.log(LogStatus.FAIL, "Street field accept the more than 40 characters");
		}else if(acount9 == 40)
		{
			test.log(LogStatus.PASS, "Street field accept the 40 characters only");
			try {		String ab5 = driver.findElement(By.xpath("//p[.='Location should not be more than 40 characters']")).getText();

			if(ab5.equals("Location should not be more than 40 characters")) {
				test.log(LogStatus.FAIL, "Street name should contain atleast 40 chars warning message is displayed when user entering the street name");
			}
		}catch(Exception r) {}
		}
		
		Apartment.clear();
		
		Apartment.sendKeys(RandomStringUtils.randomAlphabetic(60));
		
		int acount10 = Street.getAttribute("value").length();
		
		if(acount10 == 60) {
			test.log(LogStatus.FAIL, "Apartment field accept the more than 40 characters");
		}else if(acount10 == 40)
		{
			test.log(LogStatus.PASS, "Apartment field accept the 40 characters only");
		}
		
		City.clear();
		
//		try {		String ab7 = driver.findElement(By.xpath("//mat-hint[.='Enter City Name']")).getText();
//		
//
//			if(ab7.equals("Enter City Name")) {
//				test.log(LogStatus.PASS, "Enter City Name warning message is displayed when user not entering the City Name");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter City Name warning message is not displayed when user not entering the City Name");
//		}
		
		City.sendKeys(RandomStringUtils.randomAlphabetic(60));
		
		int acount11 = City.getAttribute("value").length();
		
		if(acount11 == 60) {
			test.log(LogStatus.FAIL, "City field accept the more than 25 characters");
		}else if(acount11 == 25)
		{
			test.log(LogStatus.FAIL, "City field accept the 25 characters only");
		}
		
		State.clear();
		
	
//		try {		String ab8 = driver.findElement(By.xpath("//mat-hint[.='Enter City Name']")).getText();
//		
//			if(ab8.equals("Enter City Name")) {
//				test.log(LogStatus.PASS, "Enter City Name warning message is displayed when user not entering the State");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Enter City Name warning message is not displayed when user not entering the State");
//		}
		
		State.sendKeys(RandomStringUtils.randomAlphabetic(60));
		
		int acount12 = State.getAttribute("value").length();
		
		if(acount12 == 60) {
			test.log(LogStatus.FAIL, "State field accept the more than 25 characters");
		}else if(acount12 == 25)
		{
			test.log(LogStatus.FAIL, "State field accept the 25 characters only");
		}
		
		
		ZipPostalCode.clear();
		
				
//		try {		String a11 = driver.findElement(By.xpath("//mat-hint[.='Postal Code should be 4 to 10 characters']")).getText();
//
//			if(a11.equals("Postal Code should be 4 to 10 characters")) {
//				test.log(LogStatus.PASS, "Postal Code should be 4 to 10 characters warning message is displayed when user not entering the Postal Code");
//			}
//		}catch(Exception r) {
//			test.log(LogStatus.FAIL, "Postal Code should be 4 to 10 characters warning message is not displayed when user not entering the Postal Code");
//		}
		
		ZipPostalCode.sendKeys(RandomStringUtils.randomAlphanumeric(25));
		
		int acount13 = ZipPostalCode.getAttribute("value").length();
		
		if(acount13 == 25) {
			test.log(LogStatus.FAIL, "Zip/Postal Code field accept the more than 10 characters");
		}else if(acount13 == 10)
		{
			test.log(LogStatus.FAIL, "Zip/Postal Code field accept the more than 10 characters only");
		}
		
		
		//click the Availability
		Availability.click();
		
		Thread.sleep(1000);
		
		List<WebElement> menuList5=driver.findElements(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div"));
		
		int menuSize5=menuList5.size();
		
		int randomMenu5=ThreadLocalRandom.current().nextInt(1, menuSize5);
		
		driver.findElement(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div["+randomMenu5+"]")).click();

		
		
		//click the Gratuity Type
		GratuityType.click();
		
		Thread.sleep(1000);
		
		List<WebElement> menuList6=driver.findElements(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div"));
		
		int menuSize6=menuList6.size();
		
		int randomMenu6=ThreadLocalRandom.current().nextInt(1, menuSize6);
		
		driver.findElement(By.xpath("//div[contains(@class,'selectbox-component-panel')]/option-panel/div/div/cdk-virtual-scroll-viewport/div/div["+randomMenu6+"]")).click();
		
		SaveBtn.click();Thread.sleep(3000);
		
		Back.click();
		Thread.sleep(3000);
	}
	
	@FindBy(xpath = "//button[@aria-label='Choose month and year']")
	WebElement monthAndYear_Calender;
	
	public String selectDate(String day) 
	{
		if(day.equals("01")) 
		{
		day = " 1 ";
		}
		else if(day.equals("02")) 
		{
		day = " 2 ";
		}
		else if(day.equals("03")) 
		{
		day = " 3 ";
		}
		else if(day.equals("04")) 
		{
		day = " 4 ";
		}
		else if(day.equals("05")) 
		{
		day = " 5 ";
		}
		else if(day.equals("06")) 
		{
		day = " 6 ";
		}
		else if(day.equals("07")) 
		{
		day = " 7 ";
		}
		else if(day.equals("08")) 
		{
		day = " 8 ";
		}
		else if(day.equals("09")) 
		{
		day = " 9 ";
		}
		return day;
	}
		public String selectMonth(String month) 
		{
		if(month.equals("01")) 
		{
		month = "JAN";
		}
		else if(month.equals("02")) 
		{
		month = "FEB";
		}
		else if(month.equals("03")) 
		{
		month = "MAR";
		}
		else if(month.equals("04")) 
		{
		month = "APR";
		}
		else if(month.equals("05")) 
		{
		month = "MAY";
		}
		else if(month.equals("06")) 
		{
		month = "JUN";
		}
		else if(month.equals("07")) 
		{
		month = "JUL";
		}
		else if(month.equals("08")) 
		{
		month = "AUG";
		}
		else if(month.equals("09")) 
		{
		month = "SEP";
		}
		else if(month.equals("10")) 
		{
		month = "OCT";
		}
		else if(month.equals("11")) 
		{
		month = "NOV";
		}
		else if(month.equals("12")) 
		{
		month = "DEC";
		}
		return month;
		
		
	}

	
	public void Select_Date(String SpecificDate) throws Exception

	{

		


		Date.click();

		Thread.sleep(500);

		monthAndYear_Calender.click();

		String year = SpecificDate.substring(6,10);

		driver.findElement(By.xpath("//div[contains(.,'"+year+"') and contains(@class,'mat-calendar-body-today')]")).click();

		String months = SpecificDate.substring(3,5);

		String month = selectMonth(months);

		driver.findElement(By.xpath("//div[contains(.,'"+month+"') and contains(@class,'mat-calendar-body')]")).click();

		String days = SpecificDate.substring(0,2);

		String day = selectDate(days);

		driver.findElement(By.xpath("//div[contains(.,'"+day+"') and contains(@class,'mat-calendar-body')]")).click();

		//Date_inSpecificDateInputBx.clear();

		Thread.sleep(500);

		//Date_inSpecificDateInputBx.sendKeys(SpecificDate);

		

		test.log(LogStatus.INFO, "The specific date is : "+Utility.getProperty("Report_Specific_Date"));

	}
	
//	Compeat
	//Restaurant
	public void Compeat_Page(String date) throws Exception {
		Thread.sleep(2500);
		Compeat.click();
		Thread.sleep(1500);
		
		if(Compeat_Head.isDisplayed()) {
			test.log(LogStatus.PASS, "Compeat heading displayed successfully In Compeat Page");
		}
		else {
			test.log(LogStatus.FAIL, "Compeat heading is not displayed In Compeat Page");
		}	
		
	
		
		Select_Date(date);
		
		PUSH_DATA.click();
		
	
		
		Thread.sleep(2500);
		
		String s7 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s7.equals("Data pushed successfully"))
		{
			test.log(LogStatus.PASS, "Store Updated Successfully message is displayed In Uber Eats Page");
		}
		else if(s7.equals("Internal Server Error"))
		{
			test.log(LogStatus.FAIL, "Store Updated Successfully message is not displayed In Uber Eats Page");
		}
		
	Back.click();
	
}
	
	public void Restaurant_Page(String date) throws Exception {
		Thread.sleep(2500);
		Restaurant.click();
		Thread.sleep(1500);
		
		if(Restaurant_Head.isDisplayed()) {
			test.log(LogStatus.PASS, "Restaurant heading displayed successfully In Restaurant Page");
		}
		else {
			test.log(LogStatus.FAIL, "Restaurant heading is not displayed In Restaurant Page");
		}	
		
	
		
		Select_Date(date);
		
		EXPORT_DATA.click();
		
	
		
		Thread.sleep(2500);
		
		String s7 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s7.equals("Export successfully"))
		{
			test.log(LogStatus.PASS, "Export successfully message is displayed In Restaurant Page");
		}
		else if(s7.equals("Internal Server Error"))
		{
			test.log(LogStatus.FAIL, "Store Updated Successfully message is not displayed In Restaurant Page");
		}
		
		Back.click();
	
}
}
	
