package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Enterprise_AccountLicense_Settings_Page extends BasePage
{
//	public SelfHealingDriver driver;
//	public ExtentTest test;
	Utility ut=new Utility();
	Common_XPaths cmp;

	public Enterprise_AccountLicense_Settings_Page(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		
		super(driver,test);

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[.='Enterprise']")
	WebElement Enterprise_Button;
	
	public void Click_Enterprise()
	{
		Enterprise_Button.click();
	}
	
	@FindBy(xpath = "//span[.=' UPGRADE ']")
	WebElement Upgrade;
	
	  public void click_Upgrade() 
	  {
		  Upgrade.click();
	  }
	
	@FindBy(xpath = "//button[.='SAVE']")
	WebElement save;
	
	public void Click_Save() 
	{
		Common_XPaths cmp = new Common_XPaths(driver, test);
		ut = new Utility();
		
		save.click();
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("License Settings updated successfully")) 
		{
			test.log(LogStatus.PASS,"License settings updated Successfully");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else {
			test.log(LogStatus.FAIL,"License settings not saved successfully");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	public void Managing_Plan() throws Exception 
	{
		cmp= new Common_XPaths(driver, test);
		
		driver.findElement(By.xpath("//span[.=' Manage Plan ']")).click();
		Thread.sleep(5000);
		//cmp.VerifyMainScreenPageHeader(" Manage Plan");
		//Thread.sleep(2000);
		driver.findElement(By.xpath("(//button[.=' + '])[2]")).click();
		Thread.sleep(2000);
		for(int i=1;i<=3;i++) 
		{
		driver.findElement(By.xpath("(//mat-icon[.='arrow_drop_up'])[2]")).click();
		}
		
		try {
		driver.findElement(By.xpath("//span[.=' continue to payment ']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[.=' submit changes ']")).click();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
