package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class ServingSizeLevelsPage {
	public WebDriver driver;
	public ExtentTest test;
	
	public ServingSizeLevelsPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//label[contains(.,'Description')]/../../textarea")
	WebElement DescriptionInServingSizeInputBox;
	
	@FindBy(xpath = "//button[contains(.,'NEW SERVING SIZE')]")
	WebElement NewServingSizeLevelBtn;
	
	
	public void Click_NewServingSizeLevelButton()
	{
		NewServingSizeLevelBtn.click();
	}
	
	public void EnterDescription(String str) throws Exception
	{
		Thread.sleep(500);
		DescriptionInServingSizeInputBox.clear();
		
		Thread.sleep(500);
		DescriptionInServingSizeInputBox.sendKeys(str);
	}
}
