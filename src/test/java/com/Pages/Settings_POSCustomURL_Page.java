package com.Pages;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_POSCustomURL_Page extends BasePage
{
	
//	public SelfHealingDriver driver;
//	public ExtentTest test;
	Utility ut=new Utility();
	Common_XPaths cmp;
	
	public Settings_POSCustomURL_Page(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='settings']/button")
	WebElement Settings;
	
	@FindBy(xpath = "//span[contains(.,'POS Custom URLs')]")
	WebElement POSCustm;
	
	@FindBy(xpath = "//button[contains(@name,'toogle')]/span[.='Yes']")
	WebElement yes;
	
	@FindBy(xpath = "//button[contains(@name,'toogle')]/span[.='No']")
	WebElement no;
	
	@FindBy(xpath = "(//div[@class='row'])[5]/div/div[2]/button")
	WebElement URLLink_btn;
	
	@FindBy(xpath = "(//ul[contains(@class,'list-group')]/li[1]/div/div[2]/button[2])[1]")
	WebElement edit_btn;
	
	@FindBy(xpath = "(//ul[contains(@class,'list-group')]/li[1]/div/div[2]/button[1])[1]")
	WebElement delete_btn;
	
	@FindBy(xpath = "//div[@mattooltip='image-picker-options pl-2']/img")
	WebElement imgupload_btn;
	
	@FindBy(xpath = "//app-input[@label='URL']/div/div/mat-form-field/div/div/div[4]/input")
	WebElement url_textbox;
	
	@FindBy(xpath = "//div[@class='row justify-content-between']/div[1]/button")
	WebElement No;
	
	@FindBy(xpath = "//div[@class='row justify-content-between']/div[2]/button")
	WebElement Yes;
	
	@FindBy(xpath = "//button[contains(@class,'save-button')]")
	WebElement Save;
	
	@FindBy(xpath = "//button[.='Cancel']")
	WebElement close;
	
	@FindBy(xpath = "//app-new-pos-custom-url//div[contains(@class,'image-picker-container')]/div/div[2]/div[2]/input")
	WebElement Upload_PictureBtn;
	
	public void settings() {
		Settings.click();
	}
	
	public void pos_url_set() {
		POSCustm.click();
	}
	
	public void update_btn() {
		Save.click();
	}
	
	public void Upload_Picture(String str) throws Exception
	{
	//	Upload_PictureBtn.clear();
		Thread.sleep(1000);
		Upload_PictureBtn.sendKeys(str);
	}
	
	public void toggle_btn() throws InterruptedException {
		List<WebElement> togs=driver.findElements(By.xpath("//button[contains(@name,'toogle')]"));
		for(WebElement tog:togs) {
			tog.click();
			Thread.sleep(1000);
		}
		if(yes.equals("Yes")) {
			test.log(LogStatus.PASS, "POS access enabled");
			yes.click();
		}
		else {
			test.log(LogStatus.PASS, "POS access disabled");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	public void Click_NewURL() throws InterruptedException {
		Thread.sleep(500);
		driver.findElement(By.xpath("(//button[contains(@name,'toogle')])[2]")).click();
		WebElement add_btn=driver.findElement(By.xpath("(//div[@class='row'])[5]/div/div[2]/button/span[contains(.,'URL LINK')]"));
		URLLink_btn.click();
		if(add_btn.getText().equals("URL LINK")) {
			
			test.log(LogStatus.PASS, "New Url page displayed");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else {
			test.log(LogStatus.PASS, "New Url page not displayed");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	public void EnterURL() throws Exception {
		Thread.sleep(500);
		url_textbox.clear();
		Thread.sleep(500);
		url_textbox.sendKeys(Utility.getProperty("POS_URL"));
			test.log(LogStatus.PASS, "Enter new url");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);

	}
	
	/*public void upload_img() throws Exception {
		WebElement img=driver.findElement(By.xpath("//div[contains(@class,'drawer-content')]/div/app-new-pos-custom-url/div/div[3]/app-image-picker/div/div/div[2]/div[2]/div"));
		Thread.sleep(1000);
		img.click();
		 Thread.sleep(20000);
		 --StringSelection path= new StringSelection("website.jpg");
		 Toolkit.getDefaultToolkit().getSystemClipboard().setContents(path, null);
		 Robot r= new Robot(); r.keyPress(KeyEvent.VK_CONTROL);
		 r.keyPress(KeyEvent.VK_V); r.keyRelease(KeyEvent.VK_CONTROL);
		 r.keyRelease(KeyEvent.VK_V); Thread.sleep(500);
		 r.keyPress(KeyEvent.VK_ENTER); r.keyRelease(KeyEvent.VK_ENTER);
		 Thread.sleep(1000);--
		 
		//img.sendKeys(Utility.getProperty("image"));
		 /*Save.click(); Thread.sleep(1000);
		 close.click();
	}*/

	public void Update_POS() {
		edit_btn.click();
	}
	
	public void Delete_POS() throws InterruptedException {
		delete_btn.click();
		Thread.sleep(1000); No.click();
		Thread.sleep(1000); 
		delete_btn.click();
		Thread.sleep(1000);
		Yes.click();
		Thread.sleep(1000);
	}
}
