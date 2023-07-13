package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class CutAndModifyPage {

	
	public WebDriver driver;
	public ExtentTest test;
	
	Utility ut=new Utility();
	
	public CutAndModifyPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//div[contains(@class,'cut-and-modify')]/div[2]/div[2]/div/div/input")
	WebElement FirstSliceModify;
	
	@FindBy(xpath = "//div[contains(@class,'cut-and-modify')]/div[3]/div[2]/div/div/input")
	WebElement SecondSliceModify;
	
	@FindBy(xpath = "//div[contains(@class,'cut-and-modify')]/div[4]/div[2]/div/div/input")
	WebElement ThirdSliceModify;
	
	@FindBy(xpath = "//div[@class='ml-auto']/button[contains(.,'SAVE')]")
	WebElement SaveInCutAndModify;
	
	public void Click_Save_Cut_and_Modify()
	{
		SaveInCutAndModify.click();
	}
	
	public void Enter_ModifyPercentage_FirstSliceFraction(String str) throws Exception
	{
		Thread.sleep(500);
		FirstSliceModify.clear();
		FirstSliceModify.click();

		Thread.sleep(500);
		FirstSliceModify.sendKeys(str);
	}
	
	public WebElement First_SliceModify()
	{
		return FirstSliceModify;
	}
	
	public WebElement Second_SliceModify()
	{
		return SecondSliceModify;
	}
	
	public WebElement Third_SliceModify()
	{
		return ThirdSliceModify;
	}
	
	
	public void Enter_ModifyPercentage_SecondSliceFraction(String str) throws Exception
	{
		Thread.sleep(500);
		SecondSliceModify.clear();
		Thread.sleep(500);
		SecondSliceModify.click();

		SecondSliceModify.sendKeys(str);
	}
	
	public void Enter_ModifyPercentage_ThirdSliceFraction(String str) throws Exception
	{
		Thread.sleep(500);
		ThirdSliceModify.clear();
		ThirdSliceModify.click();
		Thread.sleep(500);
		ThirdSliceModify.sendKeys(str);
	}
	
	public void ModifyPercentageForAllSlideFractions(String Str) throws Exception
	{
		List<WebElement> SliceList=driver.findElements(By.xpath("//div[contains(@class,'cut-and-modify')]/div/div[2]/div/div/input"));

		for(int i=2;i<=SliceList.size()+1;i++)
		{
			driver.findElement(By.xpath("//div[contains(@class,'cut-and-modify')]/div["+i+"]/div[2]/div/div/input")).clear();

			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(@class,'cut-and-modify')]/div["+i+"]/div[2]/div/div/input")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(@class,'cut-and-modify')]/div["+i+"]/div[2]/div/div/input")).sendKeys(Str);
		}
	}
	
	
	public void Clear_ModifyPercentageForAllSlideFractions() throws Exception
	{
		
		List<WebElement> SliceList=driver.findElements(By.xpath("//div[contains(@class,'cut-and-modify')]/div/div[2]/div/div/input"));
		Thread.sleep(1000);
		for(int i=2;i<=SliceList.size()+1;i++)
		{
			Thread.sleep(500);
			driver.findElement(By.xpath("//div[contains(@class,'cut-and-modify')]/div["+i+"]/div[2]/div/div/input")).click();
			Thread.sleep(500);
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(@class,'cut-and-modify')]/div["+i+"]/div[2]/div/div/input")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(@class,'cut-and-modify')]/div["+i+"]/div[2]/div/div/input")).clear();
		}
	}
	
	public void Enter_ModifyPercentageForAllSlideFractions(String Str) throws Exception
	{
		List<WebElement> SliceList=driver.findElements(By.xpath("//div[contains(@class,'cut-and-modify')]/div/div[2]/div/div/input"));

		
		
		for(int i=2;i<=SliceList.size()+1;i++)
		{
			
			driver.findElement(By.xpath("//div[contains(@class,'cut-and-modify')]/div["+i+"]/div[2]/div/div/input")).clear();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div[contains(@class,'cut-and-modify')]/div["+i+"]/div[2]/div/div/input")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//div[contains(@class,'cut-and-modify')]/div["+i+"]/div[2]/div/div/input")).sendKeys(Str);
//			if(driver.findElement(By.xpath("//div[contains(@class,'cut-and-modify')]/div["+i+"]/div[2]/div/div/input")).getAttribute("value").equalsIgnoreCase(Str))
//			{
//				test.log(LogStatus.PASS, "Cut and Modify Percentage Updated");
//				
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
//			}
//			else
//			{
//				test.log(LogStatus.FAIL, "Cut and Modify Percentage not Updated");
//		
//				ut.FailedCaptureScreenshotAsBASE64(driver, test);
//			}
		}
	}
}
