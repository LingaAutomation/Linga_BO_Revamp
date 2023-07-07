package com.Pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class POSCustomURL_Page {
	
	public WebDriver driver;
	public ExtentTest test;
	Utility ut=new Utility();
	Common_XPaths cmp;
	
	public POSCustomURL_Page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='settings']/button")
	WebElement Settings;
	
	@FindBy(xpath = "//span[contains(.,'POS Custom URLs')]")
	WebElement POSCustm;
	
	@FindBy(xpath = "//h5[contains(.,'POS Access URL')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[contains(.,'Yes')]")
	WebElement yes;
	
	public void POS_Access_URL_Yes() {
		
		yes.click();
	}
	
	@FindBy(xpath = "//h5[contains(.,'POS Access URL')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[contains(.,'No')]")
	WebElement no;
	
	public void POS_Access_URL_No() {
		
		no.click();
	}
	
	@FindBy(xpath = "//h5[contains(.,'POS Access URL')]/../../../../div[1]/div[2]/p")
	WebElement Custom_txt;
	
	public WebElement Custom_txt() {
		
		return Custom_txt;
	}
	
	
	@FindBy(xpath = "//h5[contains(.,'URL Links')]/../../div[2]/button[1]")
	WebElement URLLink_btn;
	
	
	
	@FindBy(xpath = "//h3[contains(.,'New POS Custom URL ')]/../../..//input[@type='file']")
	WebElement Upload_PictureBtn;
	
	
	public void Upload_Picture(String str) throws Exception
	{
	//	Upload_PictureBtn.clear();
		Thread.sleep(1000);
		Upload_PictureBtn.sendKeys(str);
	}
	
public void Click_URLLink_btn() {
		
	URLLink_btn.click();
	}
	
	@FindBy(xpath = "//p[contains(.,'URL 1')]/../../../../div[2]/button[1]")
	WebElement edit_btn;
	
	public void Click_edit_btn() {
		
		edit_btn.click();
		}
	
	@FindBy(xpath = "//p[contains(.,'URL 1')]/../../../../div[2]/button[2]")
	WebElement delete_btn;
	
	public void Click_delete_btn() {
		
		delete_btn.click();
		}
	
	@FindBy(xpath = "//div[@mattooltip='image-picker-options pl-2']/img")
	WebElement imgupload_btn;
	
	
	@FindBy(xpath = " //span[contains(.,'Name')]/../../../div[1]/div[4]/input")
	WebElement url_Name;
	
	public void Enter_Name(String str) throws InterruptedException {
		
		Thread.sleep(2000);
		url_Name.clear();
		Thread.sleep(2000);
		url_Name.sendKeys(str);
		
		}
	
	
	@FindBy(xpath = "//label[contains(.,'URL')]/../../input")
	WebElement url_textbox;
	

	public void Enter_Url(String str) throws InterruptedException {
		
		Thread.sleep(2000);
		url_textbox.clear();
		Thread.sleep(2000);
		url_textbox.sendKeys(str);
		
		}
	
	
	@FindBy(xpath = "//button[contains(@class,'save-button')]")
	WebElement Save;
	public void Click_Save() {
		Save.click();
	}
	
	
	@FindBy(xpath = "//div[contains(@class,'drawer-footer')]/div/button[contains(.,'Cancel')]")
	WebElement close;
	
	public void close() {
		close.click();
	}
	
	

	
	public void settings() {
		Settings.click();
	}
	
	public void pos_url_set() {
		POSCustm.click();
	}
	
	@FindBy(xpath = "//p[contains(.,'Are you sure you want to delete this item?')]")
	WebElement verify_Delete;
	
	
	@FindBy(xpath = "//p[contains(.,'Are you sure you want to activate this item?')]")
	WebElement verify_Active;
	
	@FindBy(xpath = "//mat-dialog-container/alert-dialog/div/div[3]/div/div[1]/button")
	WebElement Delete_No;
	
	
	
	@FindBy(xpath = "//mat-dialog-container/alert-dialog/div/div[3]/div/div[2]/button")
	WebElement Delete_Yes;
	
	public void Verify_Delete_Cancel() throws Exception
	{
		if(verify_Delete.isDisplayed()) {
			
			
			Delete_No.click();
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			test.log(LogStatus.FAIL, "Able to click on cancel");
		}
		
	}
	
	public void Verify_Delete_yes() throws Exception
	{
		if(verify_Delete.isDisplayed()) {
			
			
			Delete_Yes.click();
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			test.log(LogStatus.PASS, "Able to click on Yes");
		}
		
	}
	
	public void Verify_Activate_Cancel() throws Exception
	{
		if(verify_Active.isDisplayed()) {
			
			Delete_No.click();
			test.log(LogStatus.FAIL, "Able to click on cancel");
		}
		
	}

	
	@FindBy(xpath = "//div[contains(@class,'breadcrumb-component')]/ol/li[1]")
	WebElement Home;
	
	@FindBy(xpath = "//div[contains(@class,'breadcrumb-component')]/ol/li[2]")
	WebElement Products_Items;
	
	@FindBy(xpath = "//div[contains(@class,'breadcrumb-component')]/ol/li[3]")
	WebElement path1;
	@FindBy(xpath = "//div[contains(@class,'breadcrumb-component')]/ol/li[4]")
	WebElement path2;
	
	
public WebElement Home() {
		
		return Home;
	}

public WebElement Products_Items() {
	
	return Products_Items;
}
public WebElement path1() {
	
	return path1;
}
public WebElement path2() {
	
	return path2;
}
	

@FindBy(xpath = "(//div[contains(@class,'image-container')])[2]")
WebElement Image_Selection;
public void Mouse_hover_Image_Delete() throws InterruptedException {
	Thread.sleep(2000);

	
	
	//Creating object of an Actions class
	Actions action = new Actions(driver);
	Thread.sleep(2000);
	//Performing the mouse hover action on the target element.
	action.moveToElement(Image_Selection).perform();
	
	Thread.sleep(4000);
	
	driver.findElement(By.xpath("//div[contains(@class,'delete-action')]/img")).click();
	ut.PassedCaptureScreenshotAsBASE64(driver, test);
}
}
