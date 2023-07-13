package com.Pages;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_AccountBalance_Page {
	public WebDriver driver;
	public ExtentTest test;
	Utility ut=new Utility();
	Common_XPaths cmp;
	
	public Settings_AccountBalance_Page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='settings']/button")
	WebElement Settings;
	
	@FindBy(xpath = "//span[contains(.,'Account Balance')]")
	WebElement AccBalance;
	
	@FindBy(xpath = "//mat-label[contains(.,'Paid Out')]/../../../input")
	WebElement paid_out;
	
	@FindBy(xpath = "//mat-label[contains(.,'CC Tip Reduction')]/../../../input")
	WebElement cc_tip;
	
	@FindBy(xpath = "//mat-label[contains(.,'Refund')]/../../../input")
	WebElement refund;
	
	@FindBy(xpath = "//mat-label[contains(.,'Deposit')]/../../../input")
	WebElement deposite;
	
	@FindBy(xpath = "//mat-label[contains(.,'Over / Shortage')]/../../../input")
	WebElement ovr_shortage;
	
	@FindBy(xpath = "//mat-label[contains(.,'Sales Open Items')]/../../../input")
	WebElement sales_opn_itm;
	
	@FindBy(xpath = "//mat-label[contains(.,'Combo Discounts')]/../../../input")
	WebElement combo_dis;
	
	@FindBy(xpath = "//mat-label[contains(.,'Comp Discounts')]/../../../input")
	WebElement comp_dis;
	
	@FindBy(xpath = "//mat-label[contains(.,'Delivery Charge Cost')]/../../../input")
	WebElement delevry_charge;
	
	@FindBy(xpath = "//mat-label[contains(.,'HA and GC Recharge')]/../../../input")
	WebElement HA_GC;
	
	@FindBy(xpath = "//mat-label[contains(.,'Driver Tip')]/../../../input")
	WebElement Drivr_tip;
	
	@FindBy(xpath = "//mat-label[contains(.,'Tip / Gratuity')]/../../../input")
	WebElement gratiuty_tip;
	
	@FindBy(xpath = "//mat-label[contains(.,'Promo Discounts')]/../../../input")
	WebElement promo_dis;
	
	@FindBy(xpath = "//mat-label[contains(.,'Donation Discounts')]/../../../input")
	WebElement donation_dis;
	
	@FindBy(xpath = "//mat-label[contains(.,'Loyalty Discounts')]/../../../input")
	WebElement loyality_dis;
	
	@FindBy(xpath = "//button/span[.=' SAVE ']")
	WebElement update_btn;
	
	@FindBy(xpath = "//div[contains(@class,'message')]/span")
	WebElement AlertMessageTitle;
	
	public void Click_Settings() {
		Settings.click();
	}
	
	public void Click_AccBal() {
		AccBalance.click();
	}
	
	public String Str= "Account Balance Saved Successfully";
	
	public void Edit_PaidOut() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(1000);
		paid_out.clear();
		Thread.sleep(1000);
		paid_out.sendKeys(RandomStringUtils.randomAlphanumeric(10));
		Thread.sleep(1000);
		update_btn.click();Thread.sleep(1500);

			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Paid out(Alphanumeric) - Account Balance Saved Successfully when user change the paid out");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Paid out(Alphanumeric) - Account Balance Saved Successfully when user change the paid out");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			paid_out.clear();
			Thread.sleep(1000);
			paid_out.sendKeys(RandomStringUtils.randomAlphabetic(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Paid out(Alphabetic) - Account Balance Saved Successfully when user change the paid out");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Paid out(Alphabetic) - Account Balance Saved Successfully when user change the paid out");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			paid_out.clear();
			Thread.sleep(1000);
			paid_out.sendKeys(RandomStringUtils.randomNumeric(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Paid out(Numeric) - Account Balance Saved Successfully when user change the paid out");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Paid out(Numeric) - Account Balance Saved Successfully when user change the paid out");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
	}
	
	public void Edit_CCTip() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(1000);
		cc_tip.clear();
		Thread.sleep(1000);
		cc_tip.sendKeys(RandomStringUtils.randomAlphanumeric(10));
		Thread.sleep(1000);
		update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "CC Tip Reduction(Alphanumeric) - Account Balance Saved Successfully when user change the CC Tip Reduction");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "CC Tip Reduction(Alphanumeric) - Account Balance Saved Successfully when user change the CC Tip Reduction");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			cc_tip.clear();
			Thread.sleep(1000);
			cc_tip.sendKeys(RandomStringUtils.randomAlphabetic(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "CC Tip Reduction(Alphabetic) - Account Balance Saved Successfully when user change the CC Tip Reduction");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "CC Tip Reduction(Alphabetic) - Account Balance Saved Successfully when user change the CC Tip Reduction");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			cc_tip.clear();
			Thread.sleep(1000);
			cc_tip.sendKeys(RandomStringUtils.randomNumeric(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "CC Tip Reduction(Numeric) - Account Balance Saved Successfully when user change the CC Tip Reduction");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "CC Tip Reduction(Numeric) - Account Balance Saved Successfully when user change the CC Tip Reduction");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
	}
	
	public void Edit_Refund() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(1000);
		refund.clear();
		Thread.sleep(1000);
		refund.sendKeys(RandomStringUtils.randomAlphanumeric(10));
		Thread.sleep(1000);
		update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Refund(Alphanumeric) - Account Balance Saved Successfully when user change the Refund");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Refund(Alphanumeric) - Account Balance Saved Successfully when user change the Refund");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			refund.clear();
			Thread.sleep(1000);
			refund.sendKeys(RandomStringUtils.randomAlphabetic(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Refund(Alphabetic) - Account Balance Saved Successfully when user change the Refund");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Refund(Alphabetic) - Account Balance Saved Successfully when user change the Refund");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			refund.clear();
			Thread.sleep(1000);
			refund.sendKeys(RandomStringUtils.randomNumeric(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Refund(Numeric) - Account Balance Saved Successfully when user change the Refund");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Refund(Numeric) - Account Balance Saved Successfully when user change the Refund");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
	}
	
	public void Edit_deposite() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(1000);
		deposite.clear();
		Thread.sleep(1000);
		deposite.sendKeys(RandomStringUtils.randomAlphanumeric(10));
		Thread.sleep(1000);
		update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Deposit(Alphanumeric) - Account Balance Saved Successfully when user change the Deposit");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Deposit(Alphanumeric) - Account Balance Saved Successfully when user change the Deposit");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			deposite.clear();
			Thread.sleep(1000);
			deposite.sendKeys(RandomStringUtils.randomAlphabetic(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Deposit(Alphabetic) - Account Balance Saved Successfully when user change the Deposit");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Deposit(Alphabetic) - Account Balance Saved Successfully when user change the Deposit");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			deposite.clear();
			Thread.sleep(1000);
			deposite.sendKeys(RandomStringUtils.randomNumeric(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Deposit(Numeric) - Account Balance Saved Successfully when user change the Deposit");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Deposit(Numeric) - Account Balance Saved Successfully when user change the Deposit");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
	}
	
	public void Edit_ovr_shortage() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(1000);
		ovr_shortage.clear();
		Thread.sleep(1000);
		ovr_shortage.sendKeys(RandomStringUtils.randomAlphanumeric(10));
		Thread.sleep(1000);
		update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Over/Shortage(Alphanumeric) - Account Balance Saved Successfully when user change the Over/Shortage");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Over/Shortage(Alphanumeric) - Account Balance Saved Successfully when user change the Over/Shortage");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			ovr_shortage.clear();
			Thread.sleep(1000);
			ovr_shortage.sendKeys(RandomStringUtils.randomAlphabetic(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Over/Shortage(Alphabetic) - Account Balance Saved Successfully when user change the Over/Shortage");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Over/Shortage(Alphabetic) - Account Balance Saved Successfully when user change the Over/Shortage");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			ovr_shortage.clear();
			Thread.sleep(1000);
			ovr_shortage.sendKeys(RandomStringUtils.randomNumeric(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Over/Shortage(Numeric) - Account Balance Saved Successfully when user change the Over/Shortage");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Over/Shortage(Numeric) - Account Balance Saved Successfully when user change the Over/Shortage");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
	}
	
	public void Edit_sales_opn_itm() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(1000);
		sales_opn_itm.clear();
		Thread.sleep(1000);
		sales_opn_itm.sendKeys(RandomStringUtils.randomAlphanumeric(10));
		Thread.sleep(1000);
		update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Sales Open Items(Alphanumeric) - Account Balance Saved Successfully when user change the Sales Open Items");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Sales Open Items(Alphanumeric) - Account Balance Saved Successfully when user change the Sales Open Items");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			sales_opn_itm.clear();
			Thread.sleep(1000);
			sales_opn_itm.sendKeys(RandomStringUtils.randomAlphabetic(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Sales Open Items(Alphabetic) - Account Balance Saved Successfully when user change the Sales Open Items");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Sales Open Items(Alphabetic) - Account Balance Saved Successfully when user change the Sales Open Items");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			sales_opn_itm.clear();
			Thread.sleep(1000);
			sales_opn_itm.sendKeys(RandomStringUtils.randomNumeric(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Sales Open Items(Numeric) - Account Balance Saved Successfully when user change the Sales Open Items");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Sales Open Items(Numeric) - Account Balance Saved Successfully when user change the Sales Open Items");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
	}
	
	public void Edit_combo_dis() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(1000);
		combo_dis.clear();
		Thread.sleep(1000);
		combo_dis.sendKeys(RandomStringUtils.randomAlphanumeric(10));
		Thread.sleep(1000);
		update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Combo Discounts(Alphanumeric) - Account Balance Saved Successfully when user change the Combo Discounts");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Combo Discounts(Alphanumeric) - Account Balance Saved Successfully when user change the Combo Discounts");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			combo_dis.clear();
			Thread.sleep(1000);
			combo_dis.sendKeys(RandomStringUtils.randomAlphabetic(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Combo Discounts(Alphabetic) - Account Balance Saved Successfully when user change the Combo Discounts");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Combo Discounts(Alphabetic) - Account Balance Saved Successfully when user change the Combo Discounts");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			combo_dis.clear();
			Thread.sleep(1000);
			combo_dis.sendKeys(RandomStringUtils.randomNumeric(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Combo Discounts(Numeric) - Account Balance Saved Successfully when user change the Combo Discounts");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Combo Discounts(Numeric) - Account Balance Saved Successfully when user change the Combo Discounts");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
	}
	
	public void Edit_comp_dis() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(1000);
		comp_dis.clear();
		Thread.sleep(1000);
		comp_dis.sendKeys(RandomStringUtils.randomAlphanumeric(10));
		Thread.sleep(1000);
		update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Comp Discounts(Alphanumeric) - Account Balance Saved Successfully when user change the Comp Discounts");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Comp Discounts(Alphanumeric) - Account Balance Saved Successfully when user change the Comp Discounts");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			comp_dis.clear();
			Thread.sleep(1000);
			comp_dis.sendKeys(RandomStringUtils.randomAlphabetic(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Comp Discounts(Alphabetic) - Account Balance Saved Successfully when user change the Comp Discounts");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Comp Discounts(Alphabetic) - Account Balance Saved Successfully when user change the Comp Discounts");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			comp_dis.clear();
			Thread.sleep(1000);
			comp_dis.sendKeys(RandomStringUtils.randomNumeric(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Comp Discounts(Numeric) - Account Balance Saved Successfully when user change the Comp Discounts");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Comp Discounts(Numeric) - Account Balance Saved Successfully when user change the Comp Discounts");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
	}
	
	public void Edit_delevry_charge() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(1000);
		delevry_charge.clear();
		Thread.sleep(1000);
		delevry_charge.sendKeys(RandomStringUtils.randomAlphanumeric(10));
		Thread.sleep(1000);
		update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Delivery Charge Cost(Alphanumeric) - Account Balance Saved Successfully when user change the Delivery Charge Cost");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Delivery Charge Cost(Alphanumeric) - Account Balance Saved Successfully when user change the Delivery Charge Cost");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			delevry_charge.clear();
			Thread.sleep(1000);
			delevry_charge.sendKeys(RandomStringUtils.randomAlphabetic(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Delivery Charge Cost(Alphabetic) - Account Balance Saved Successfully when user change the Delivery Charge Cost");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Delivery Charge Cost(Alphabetic) - Account Balance Saved Successfully when user change the Delivery Charge Cost");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			delevry_charge.clear();
			Thread.sleep(1000);
			delevry_charge.sendKeys(RandomStringUtils.randomNumeric(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Delivery Charge Cost(Numeric) - Account Balance Saved Successfully when user change the Delivery Charge Cost");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Delivery Charge Cost(Numeric) - Account Balance Saved Successfully when user change the Delivery Charge Cost");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
	}
	
	public void Edit_HA_GC() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(1000);
		HA_GC.clear();
		Thread.sleep(1000);
		HA_GC.sendKeys(RandomStringUtils.randomAlphanumeric(10));
		Thread.sleep(1000);
		update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "HA and GC Recharge(Alphanumeric) - Account Balance Saved Successfully when user change the HA and GC Recharge");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "HA and GC Recharge(Alphanumeric) - Account Balance Saved Successfully when user change the HA and GC Recharge");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			HA_GC.clear();
			Thread.sleep(1000);
			HA_GC.sendKeys(RandomStringUtils.randomAlphabetic(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "HA and GC Recharge(Alphabetic) - Account Balance Saved Successfully when user change the HA and GC Recharge");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "HA and GC Recharge(Alphabetic) - Account Balance Saved Successfully when user change the HA and GC Recharge");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			HA_GC.clear();
			Thread.sleep(1000);
			HA_GC.sendKeys(RandomStringUtils.randomNumeric(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "HA and GC Recharge(Numeric) - Account Balance Saved Successfully when user change the HA and GC Recharge");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "HA and GC Recharge(Numeric) - Account Balance Saved Successfully when user change the HA and GC Recharge");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
	}
	
	public void Edit_Drivr_tip() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(1000);
		Drivr_tip.clear();
		Thread.sleep(1000);
		Drivr_tip.sendKeys(RandomStringUtils.randomAlphanumeric(10));
		Thread.sleep(1000);
		update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Driver Tip(Alphanumeric) - Account Balance Saved Successfully when user change the Driver Tip");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Driver Tip(Alphanumeric) - Account Balance Saved Successfully when user change the Driver Tip");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			Drivr_tip.clear();
			Thread.sleep(1000);
			Drivr_tip.sendKeys(RandomStringUtils.randomAlphabetic(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Driver Tip(Alphabetic) - Account Balance Saved Successfully when user change the Driver Tip");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Driver Tip(Alphabetic) - Account Balance Saved Successfully when user change the Driver Tip");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			Drivr_tip.clear();
			Thread.sleep(1000);
			Drivr_tip.sendKeys(RandomStringUtils.randomNumeric(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Driver Tip(Numeric) - Account Balance Saved Successfully when user change the Driver Tip");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Driver Tip(Numeric) - Account Balance Saved Successfully when user change the Driver Tip");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
	}

	public void Edit_gratiuty_tip() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(1000);
		gratiuty_tip.clear();
		Thread.sleep(1000);
		gratiuty_tip.sendKeys(RandomStringUtils.randomAlphanumeric(10));
		Thread.sleep(1000);
		update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Gratuity/Tip(Alphanumeric) - Account Balance Saved Successfully when user change the Gratuity/Tip");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Gratuity/Tip(Alphanumeric) - Account Balance Saved Successfully when user change the Gratuity/Tip");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			gratiuty_tip.clear();
			Thread.sleep(1000);
			gratiuty_tip.sendKeys(RandomStringUtils.randomAlphabetic(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Gratuity/Tip(Alphabetic) - Account Balance Saved Successfully when user change the Gratuity/Tip");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Gratuity/Tip(Alphabetic) - Account Balance Saved Successfully when user change the Gratuity/Tip");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			gratiuty_tip.clear();
			Thread.sleep(1000);
			gratiuty_tip.sendKeys(RandomStringUtils.randomNumeric(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Gratuity/Tip(Numeric) - Account Balance Saved Successfully when user change the Gratuity/Tip");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Gratuity/Tip(Numeric) - Account Balance Saved Successfully when user change the Gratuity/Tip");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
	}

	public void Edit_promo_dis() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(1000);
		promo_dis.clear();
		Thread.sleep(1000);
		promo_dis.sendKeys(RandomStringUtils.randomAlphanumeric(10));
		Thread.sleep(1000);
		update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Promo discounts(Alphanumeric) - Account Balance Saved Successfully when user change the Promo discounts");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Promo discounts(Alphanumeric) - Account Balance Saved Successfully when user change the Promo discounts");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			promo_dis.clear();
			Thread.sleep(1000);
			promo_dis.sendKeys(RandomStringUtils.randomAlphabetic(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Promo discounts(Alphabetic) - Account Balance Saved Successfully when user change the Promo discounts");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Promo discounts(Alphabetic) - Account Balance Saved Successfully when user change the Promo discounts");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			promo_dis.clear();
			Thread.sleep(1000);
			promo_dis.sendKeys(RandomStringUtils.randomNumeric(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Promo discounts(Numeric) - Account Balance Saved Successfully when user change the Promo discounts");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Promo discounts(Numeric) - Account Balance Saved Successfully when user change the Promo discounts");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
	}

	public void Edit_donation_dis() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(1000);
		donation_dis.clear();
		Thread.sleep(1000);
		donation_dis.sendKeys(RandomStringUtils.randomAlphanumeric(10));
		Thread.sleep(1000);
		update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Donation discounts(Alphanumeric) - Account Balance Saved Successfully when user change the Donation discounts");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Donation discounts(Alphanumeric) - Account Balance Saved Successfully when user change the Donation discounts");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			donation_dis.clear();
			Thread.sleep(1000);
			donation_dis.sendKeys(RandomStringUtils.randomAlphabetic(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Donation discounts(Alphabetic) - Account Balance Saved Successfully when user change the Donation discounts");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Donation discounts(Alphabetic) - Account Balance Saved Successfully when user change the Donation discounts");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			donation_dis.clear();
			Thread.sleep(1000);
			donation_dis.sendKeys(RandomStringUtils.randomNumeric(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Donation discounts(Numeric) - Account Balance Saved Successfully when user change the Donation discounts");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Donation discounts(Numeric) - Account Balance Saved Successfully when user change the Donation discounts");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
	}
	
	public void Edit_loyality_dis() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(1000);
		loyality_dis.clear();
		Thread.sleep(1000);
		loyality_dis.sendKeys(RandomStringUtils.randomAlphanumeric(10));
		Thread.sleep(1000);
		update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Loyalty Discounts(Alphanumeric) - Account Balance Saved Successfully when user change the Loyalty Discounts");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Loyalty Discounts(Alphanumeric) - Account Balance Saved Successfully when user change the Loyalty Discounts");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			loyality_dis.clear();
			Thread.sleep(1000);
			loyality_dis.sendKeys(RandomStringUtils.randomAlphabetic(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Loyalty Discounts(Alphabetic) - Account Balance Saved Successfully when user change the Loyalty Discounts");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Loyalty Discounts(Alphabetic) - Account Balance Saved Successfully when user change the Loyalty Discounts");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			Thread.sleep(1000);
			loyality_dis.clear();
			Thread.sleep(1000);
			loyality_dis.sendKeys(RandomStringUtils.randomNumeric(10));
			Thread.sleep(1000);
			update_btn.click();Thread.sleep(1500);
			if(AlertMessageTitle.getText().equals(Str))
			{
				test.log(LogStatus.PASS, "Loyalty Discounts(Numeric) - Account Balance Saved Successfully when user change the Loyalty Discounts");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Loyalty Discounts(Numeric) - Account Balance Saved Successfully when user change the Loyalty Discounts");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
	}
}
