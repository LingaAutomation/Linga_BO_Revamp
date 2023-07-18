package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_Matrix_Report_Page 
{
	public WebDriver driver;
	public ExtentTest test;
	Common_XPaths cmp;
	Utility ut=new Utility();
	String sa = "0";
	String sa3 = "0%";

	public   Settings_Matrix_Report_Page(WebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@mattooltip='Settings']")
	WebElement Settings;
	
	@FindBy(xpath = "//span[.='Matrix Report Settings']")
	WebElement Matrix_Report;
	
	@FindBy(xpath = "//span[contains(.,'Amount')]/../input")
	WebElement Profit_Threshhold_Amount;
	
	@FindBy(xpath = "//span[contains(.,'Percentage')]/../input")
	WebElement Profit_Threshhold_Per;
	
	@FindBy(xpath = "//span[.=' UPDATE ']")
	WebElement Update_Button;
	
	@FindBy(xpath = "//span[.='keyboard_backspace']")
	WebElement Back_Space_Button;
	
	@FindBy(xpath = "//div[.=' Enter valid amount ']")
	WebElement Amount_Err;
	
	@FindBy(xpath = "//p[contains(.,'Percentage should be between (0-100)')]")
	WebElement per_Err;
	
	@FindBy(xpath = "//span[contains(.,'UPDATE')]/../../button[@disabled]")
	WebElement Update_But;
	
	public void Navigating_Settings() 
	{
		Settings.click();
	}
	
	public void Navigating_Matrix_Report()
	{
		Matrix_Report.click();
	}
	
	public void Entering_Valid_Amount() throws Exception 
	{
		Profit_Threshhold_Amount.clear();
		Thread.sleep(1000);
		Profit_Threshhold_Amount.sendKeys("450");
		test.log(LogStatus.INFO, "The Entered Threshold amount is : 450");
	}
	
	public void Entering_Valid_Percentage() throws Exception
	{
		Profit_Threshhold_Per.clear();
		Thread.sleep(1000);
		Profit_Threshhold_Per.sendKeys("25");
		test.log(LogStatus.INFO, "The Entered Threshold percentage is : 25");
	}
	public void Enter_Invalid_Percentage() throws Exception 
	{
		Thread.sleep(1000);
		Profit_Threshhold_Per.clear();
		Thread.sleep(1000);
		Profit_Threshhold_Per.sendKeys("105");
		test.log(LogStatus.INFO, "The Entered Threshold percentage is : 105");
	}
	
	public void Enter_InvalidAmount() throws Exception 
	{
		Profit_Threshhold_Amount.clear();
		Thread.sleep(500);
		//String sa = Profit_Threshhold_Amount.getAttribute("value");System.out.println("aaaaaaaaaaaaaaa"+sa);
		
		Thread.sleep(1000);
		Profit_Threshhold_Amount.sendKeys("abc");
		Thread.sleep(500);
		String sa1 = Profit_Threshhold_Amount.getAttribute("value");
		if(sa.equals(sa1))
		{
			test.log(LogStatus.INFO, "Amount Field not accept the Characters");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else {
			test.log(LogStatus.FAIL, "Amount Field accept the Characters");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	public void Enter_InvalidPer() throws Exception
	{
		Profit_Threshhold_Per.clear();
		Thread.sleep(500);
		//String sa2 = Profit_Threshhold_Per.getAttribute("value");System.out.println("aaaaaaaaaaaaaaa"+sa2);
		
		Thread.sleep(1000);
		Profit_Threshhold_Per.sendKeys("sa");
		Thread.sleep(500);
		String sa1 = Profit_Threshhold_Per.getAttribute("value");
		if(sa3.equals(sa1))
		{
			test.log(LogStatus.INFO, "Percentage Field not accept the Characters");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else {
			test.log(LogStatus.FAIL, "Percentage Field accept the Characters");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	public void Enter_Inavalid_Amountsym() throws Exception 
	{
		Profit_Threshhold_Amount.clear();
		Thread.sleep(500);
		//String sa = Profit_Threshhold_Amount.getAttribute("value");System.out.println("aaaaaaaaaaaaaaa"+sa);
		
		Thread.sleep(1000);
		Profit_Threshhold_Amount.sendKeys("@#");
		Thread.sleep(500);
		String sa1 = Profit_Threshhold_Amount.getAttribute("value");
		if(sa.equals(sa1))
		{
			test.log(LogStatus.INFO, "Amount Field not accept the symbol");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else {
			test.log(LogStatus.FAIL, "Amount Field accept the symbol");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	public void Enter_Invalid_Persym() throws Exception 
	{
		Profit_Threshhold_Per.clear();
		//String sa2 = Profit_Threshhold_Per.getAttribute("value");System.out.println("aaaaaaaaaaaaaaa"+sa2);
		
		Thread.sleep(1000);
		Profit_Threshhold_Per.sendKeys("&*");
		Thread.sleep(500);
		String sa1 = Profit_Threshhold_Per.getAttribute("value");
		if(sa3.equals(sa1))
		{
			test.log(LogStatus.INFO, "Percentage Field not accept the symbol");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else {
			test.log(LogStatus.FAIL, "Percentage Field accept the symbol");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	public void Enter_Invalid_AmountDecimal() throws Exception 
	{
		Profit_Threshhold_Amount.clear();
		Thread.sleep(500);
		//String sa = Profit_Threshhold_Amount.getAttribute("value");System.out.println("aaaaaaaaaaaaaaa"+sa);
		
		Thread.sleep(1000);
		Profit_Threshhold_Amount.sendKeys("0.35");
		Thread.sleep(500);
		String sa1 = Profit_Threshhold_Amount.getAttribute("value");
		if(sa.equals(sa1))
		{
			test.log(LogStatus.INFO, "Amount Field not accept the Decimal");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else {
			test.log(LogStatus.FAIL, "Amount Field accept the Decimal");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	public void Enter_Invalid_PerDecimal() throws Exception 
	{
		Profit_Threshhold_Per.clear();
		Thread.sleep(500);
		//String sa2 = Profit_Threshhold_Per.getAttribute("value");System.out.println("aaaaaaaaaaaaaaa"+sa2);
		
		Thread.sleep(1000);
		Profit_Threshhold_Per.sendKeys("0.50");
		Thread.sleep(500);
		String sa1 = Profit_Threshhold_Per.getAttribute("value");
		if(sa3.equals(sa1))
		{
			test.log(LogStatus.INFO, "Percentage Field not accept the Decimal");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else {
			test.log(LogStatus.FAIL, "Percentage Field accept the Decimal");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	public void Enter_Invalid_Amountalpha() throws Exception 
	{
		Profit_Threshhold_Amount.clear();
		Thread.sleep(500);
		//String sa = Profit_Threshhold_Amount.getAttribute("value");System.out.println("aaaaaaaaaaaaaaa"+sa);
		
		Thread.sleep(1000);
		Profit_Threshhold_Amount.sendKeys("abc");
		Thread.sleep(500);
		String sa1 = Profit_Threshhold_Amount.getAttribute("value");
		if(sa.equals(sa1))
		{
			test.log(LogStatus.INFO, "Amount Field not accept the Characters");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else {
			test.log(LogStatus.FAIL, "Amount Field accept the Characters");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	public void Enter_Invalid_Peralpha() throws Exception
	{
		Profit_Threshhold_Per.clear();
		Thread.sleep(500);
		//String sa2 = Profit_Threshhold_Per.getAttribute("value");System.out.println("aaaaaaaaaaaaaaa"+sa2);
		Thread.sleep(1000);
		Profit_Threshhold_Per.sendKeys("sa");
		Thread.sleep(500);
		String sa1 = Profit_Threshhold_Per.getAttribute("value");//System.out.println("aaaaaaaaaaaaaaa"+sa1);
		if(sa3.equals(sa1))
		{
			test.log(LogStatus.INFO, "Percentage Field not accept the Characters");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else {
			test.log(LogStatus.FAIL, "Percentage Field accept the Characters");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
//	public void Amount_Error_Message()
//	{
//		Utility ut = new Utility();
//		Common_XPaths cmp = new Common_XPaths(driver, test);
//		
//		if(cmp.Amount_Error_Msg().getText().equalsIgnoreCase("Enter valid amount"))
//		{
//			test.log(LogStatus.PASS, "Inavlid amount");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Matrix Report settings updation failed");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
//	}
//	public void Percentage_Error_Message()
//	{
//		Utility ut = new Utility();
//		Common_XPaths cmp = new Common_XPaths(driver, test);
//		if(cmp.Percentage_Error_Msg().getText().equalsIgnoreCase("Percentage should be between (0-100)"))
//		{
//			test.log(LogStatus.PASS, "Inavlid percentage");
//
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Matrix Report settings updation failed");
//
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}	
//	}
	public void Check_Update_Button() 
	{
//		cmp=new Common_XPaths(driver, test);
//		if(cmp.Update_ButtonTwo().isEnabled()) 
//		{
//			System.out.println("Updtae button is enabled");
//		}
//		else {
//			System.out.println("Update button is not enabled");
//		}
	}
	public WebElement Amount_Error_Msg() 
	{
		 return Amount_Err;
	}
	public WebElement Percentage_Error_Msg()
	{
		return per_Err;
	}
	
	public void Update() 
	{
		Update_Button.click();
	}
	public void Navigating_Back()
	{
		Back_Space_Button.click();
	}
	
}
