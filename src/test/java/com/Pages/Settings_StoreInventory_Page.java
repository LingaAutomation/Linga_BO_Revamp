package com.Pages;



import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_StoreInventory_Page extends BasePage
{
//	public SelfHealingDriver driver;
//	public ExtentTest test;
	Utility ut=new Utility();
	Common_XPaths cmp;
	
	public Settings_StoreInventory_Page(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='settings']/button")
	WebElement Settings;
	
	@FindBy(xpath = "//span[contains(.,'Store Inventory')]")
	WebElement StrInv;
	
	@FindBy(xpath = "//div[@class='d-block justify-content-end']/app-input/div/div/mat-form-field/div/div/div[5]/div/mat-datepicker-toggle/button")
	WebElement date;
	
	@FindBy(xpath = "//*[@id=\'mat-input-2\']")
	WebElement date_input;
	
	@FindBy(xpath = "//span[.=' UPDATE ']")
	WebElement update_btn;
	
	@FindBy(xpath = "//div[contains(@class,'message')]/span")
	WebElement AlertMessageTitle;
	
	public void settings() {
		Settings.click();
	}
	
	public void storeInv_set() {
		StrInv.click();
	}
	
	public void update() {
		update_btn.click();
		//Wait for 30 seconds
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		String Str= "Settings updated successfully";
		if(AlertMessageTitle.getText().equals(Str))
		{
			test.log(LogStatus.PASS, Str+" displayed when user update the Store Inventory");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, Str+" is not displayed when user update the Store Inventory");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	public void Dates() throws Exception {
		date.click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//button[contains(@class,'mat-calendar-body-active')]")).click();
		Thread.sleep(500);
	}
	
	public void SummaryAlert_toggle() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//mat-button-toggle-group[@class='mat-button-toggle-group'])[2]/mat-button-toggle[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//mat-button-toggle-group[@class='mat-button-toggle-group'])[2]/mat-button-toggle[2]")).click();
		driver.findElement(By.xpath("(//input[contains(@type,'email')])[1]")).clear();
		driver.findElement(By.xpath("(//input[contains(@type,'email')])[1]")).sendKeys(Utility.getProperty("Central_emailId"));
		Thread.sleep(500);
		//span[.='Summary Alert']/../../div[3]/div/div/div/div/div/app-input/div/div/mat-form-field/div/div/div/input
	}
	
	public void VendorCC_toggle() throws Exception {
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//div[@id='toggle-component'])[2]//mat-button-toggle-group/mat-button-toggle[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//div[@id='toggle-component'])[2]//mat-button-toggle-group/mat-button-toggle[2]")).click();
		driver.findElement(By.xpath("(//input[contains(@type,'email')])[2]")).clear();
		driver.findElement(By.xpath("(//input[contains(@type,'email')])[2]")).sendKeys(Utility.getProperty("userName"));
		Thread.sleep(1000);
	}
	
	public void StockExpiredAlert_toggle() throws Exception {
		driver.findElement(By.xpath("(//mat-button-toggle-group[@class='mat-button-toggle-group'])[3]/mat-button-toggle[1]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("(//mat-button-toggle-group[@class='mat-button-toggle-group'])[3]/mat-button-toggle[2]")).click();
		Thread.sleep(1000);
	}
	
	public void AutoRemoveExpiredStock_toggle() throws Exception {
		driver.findElement(By.xpath("//*[@id='mat-button-toggle-10-button']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='mat-button-toggle-11-button']")).click();
		Thread.sleep(1000);
	}
	
	public void All_toggle() throws Exception {
	List<WebElement> togs=	driver.findElements(By.xpath("//button[contains(@id,'mat-button-toggle')]"));
	for(WebElement tog: togs) {
		tog.click();
		Thread.sleep(2000);
	}
	}
}
