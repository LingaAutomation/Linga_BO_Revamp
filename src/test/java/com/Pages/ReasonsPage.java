package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

import Utility.Utility;

public class ReasonsPage {

	public WebDriver driver;
	public ExtentTest test;
	
	Utility ut=new Utility();
	Common_XPaths cmp=new Common_XPaths(driver, test);
	
	public ReasonsPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'NEW REASON')]")
	WebElement NewReasonBtn;
	
	@FindBy(xpath = "//label[contains(.,'Tax Exempt')]/../../mat-radio-button[1]")
	WebElement TaxExemptReasonType;
	
	@FindBy(xpath = "//label[contains(.,'Paid Out')]/../../mat-radio-button[2]")
	WebElement PaidOutReasonType;
	
	@FindBy(xpath = "//label[contains(.,'Paid In')]/../../mat-radio-button[5]")
	WebElement PaidInReasonType;
	
	@FindBy(xpath = "//label[contains(.,'Void')]/../../mat-radio-button[3]")
	WebElement VoidReasonType;
	
	@FindBy(xpath = "//label[contains(.,'Over/Shortage')]/../../mat-radio-button[4]")
	WebElement OverShoratageReasonType;
	
	@FindBy(xpath = "//label[contains(.,'Attach Request')]/../../mat-radio-button[6]")
	WebElement AttachRequestReasonType;
	
	
	@FindBy(tagName = "textarea")
	WebElement ReasonInputBox;
	
	public void Click_NewReasonButton()
	{
		NewReasonBtn.click();
	}
	
	
	public WebElement TaxExemptReasonType()
	{
		return TaxExemptReasonType;
	}
	
	public WebElement PaidOutReasonType()
	{
		return PaidOutReasonType;
	}
	
	public WebElement PaidInReasonType()
	{
		return PaidInReasonType;
	}
	
	public WebElement VoidReasonType()
	{
		return VoidReasonType;
	}
	
	public WebElement OverShoratageReasonType()
	{
		return OverShoratageReasonType;
	}
	
	public WebElement AttachRequestReasonType()
	{
		return AttachRequestReasonType;
	}
	
	
	public void Select_TaxExemptReason(String str) throws Exception
	{
		Thread.sleep(1000);
		if(TaxExemptReasonType.isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			TaxExemptReasonType.click();
		}
		
		Thread.sleep(1000);
		ReasonInputBox.clear();
		Thread.sleep(1000);
		ReasonInputBox.sendKeys(str);
	}
	 
	
	public void Select_PaidOutReason(String str) throws Exception
	{
		Thread.sleep(1000);
		if(PaidOutReasonType.isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			PaidOutReasonType.click();
		}
		
		Thread.sleep(1000);
		ReasonInputBox.clear();
		Thread.sleep(1000);
		ReasonInputBox.sendKeys(str);
	}
	
	
	public void Select_PaidInReason(String str) throws Exception
	{
		Thread.sleep(1000);
		if(PaidInReasonType.isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			PaidInReasonType.click();
		}
		
		Thread.sleep(1000);
		ReasonInputBox.clear();
		Thread.sleep(1000);
		ReasonInputBox.sendKeys(str);
	}
	 
	public void Select_VoidReason(String str) throws Exception
	{
		Thread.sleep(1000);
		if(VoidReasonType.isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			VoidReasonType.click();
		}
		
		Thread.sleep(1000);
		ReasonInputBox.clear();
		Thread.sleep(1000);
		ReasonInputBox.sendKeys(str);
	}
	 
	public void Select_OverShortageReason(String str) throws Exception
	{
		Thread.sleep(1000);
		if(OverShoratageReasonType.isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			OverShoratageReasonType.click();
		}
		
		Thread.sleep(1000);
		ReasonInputBox.clear();
		Thread.sleep(1000);
		ReasonInputBox.sendKeys(str);
	}
	 
	public void Select_AttachRequestReason(String Str) throws Exception
	{
		Thread.sleep(1000);
		if(AttachRequestReasonType.isSelected())
		{
			
		}
		else
		{
			Thread.sleep(1000);
			AttachRequestReasonType.click();
		}
		
		Thread.sleep(1000);
		ReasonInputBox.clear();
		Thread.sleep(1000);
		ReasonInputBox.sendKeys(Str);
	}
	 
}
