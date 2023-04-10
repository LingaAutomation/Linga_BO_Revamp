package com.Pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class LoginPage {

	WebDriver driver;
	ExtentTest test;
	
	public LoginPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//h4[contains(.,'Log In')]")
	WebElement LoginPageHeaderText;
	
	@FindBy(xpath = "//input[@type='email']")
	WebElement Username;
	
	@FindBy(xpath = "//input[@type='password']")
	WebElement Password;
	
	@FindBy(xpath = "//button[contains(.,'LOG IN')]")
	WebElement LoginBtn;
	
	@FindBy(xpath = "//b[@class='text-primary cursor-pointer']")
	WebElement ForgotPasswordCursorBtn;
	
	@FindBy(xpath = "//span[contains(.,'Create an Account')]")
	WebElement CreateNewAccountBtn;
	
	@FindBy(xpath = "//mat-icon[contains(.,'visibility')]")
	WebElement VisibilityIconBtn;
	
	@FindBy(xpath = "//app-input[@placeholder='Search']/div/div/mat-form-field/div/div/div[4]/input")
	WebElement SearchBox_inStores;
	
	@FindBy(xpath = "//app-stores/div/div[2]/div[2]/div[1]/div")
	WebElement First_StoreInStoresList;
	
	//mat-icon[@role='img']
	public void EnterUsername(String username)
	{
		Username.sendKeys(username);
	}
	
	public void EnterPassword(String password)
	{
		Password.sendKeys(password);
	}
	
	public void ClickLoginButton()
	{
		LoginBtn.click();
	}
	
	public void VerifyLoginPageHeader()
	{
		
		if(LoginPageHeaderText.getText().equalsIgnoreCase("Log In"))
		{
			test.log(LogStatus.PASS, "Login Page Loaded Successfully");
			
			String scnsht=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			String s="data:image/png;base64,"+scnsht;
			
			test.log(LogStatus.PASS, test.addScreenCapture(s));
		}
		else
		{
			test.log(LogStatus.FAIL, "Login page loading Failed");
			
			String scnsht=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			String s="data:image/png;base64,"+scnsht;
			
			test.log(LogStatus.FAIL, test.addScreenCapture(s));
		}
	}
	
	public void Login(String username,String password) throws Exception
	{
		Thread.sleep(500);
		
		Username.sendKeys(username);
		
		Thread.sleep(500);
		Password.sendKeys(password);
		
		Thread.sleep(1000);
		LoginBtn.click();
		
		Thread.sleep(3000);
		driver.get(Utility.getProperty("Enterprise_Base_URL"));
		
		Thread.sleep(3000);
		SearchBox_inStores.clear();
		Thread.sleep(1000);
		SearchBox_inStores.sendKeys(Utility.getProperty("Store1"));
		
		Thread.sleep(2000);
		First_StoreInStoresList.click();
		Thread.sleep(2000);
		
	
	}
}
