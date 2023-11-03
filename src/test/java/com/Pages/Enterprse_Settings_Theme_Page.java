package com.Pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Enterprse_Settings_Theme_Page extends BasePage
{
	
	public SelfHealingDriver driver;
	public ExtentTest test;
	Common_XPaths cmp;
	Utility ut=new Utility();
			
	public Enterprse_Settings_Theme_Page(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		
		super(driver,test);
		
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath = "//button[contains(@aria-label,'Theme')]")
	WebElement Theme_button;
	
	@FindBy(xpath = "//div[contains(@role,'menu')]/div/div/div[contains(.,'Choose your theme color')]")
	WebElement Verify_Choose_your_theme_color;
	
	@FindBy(xpath = "//div[contains(@role,'menu')]/div/div/div[2]/div")
	WebElement Select_color;
	
	@FindBy(xpath = "//div[contains(@role,'menu')]/div/div/div[4]")
	WebElement Verify_Choose_Your_theme;
	
	
	
	
	@FindBy(xpath = "//div[contains(@role,'menu')]/div/div/div[5]/div/div/button[contains(@aria-label,'Light Theme')]")
	WebElement Light_theme;
	
	@FindBy(xpath = "//div[contains(@role,'menu')]/div/div/div[5]/div/div/button[contains(@aria-label,'Light Theme')]/span[contains(.,'✔')]")
	WebElement Verify_Light_theme;
	
	@FindBy(xpath = "//div[contains(@role,'menu')]/div/div/div[5]/div/div/button[contains(@aria-label,'Dark Theme')]/span[contains(.,'✔')]")
	WebElement Verify_Dark_theme;
	
	
	@FindBy(xpath = "//div[contains(@role,'menu')]/div/div/div[5]/div/div/button[contains(@aria-label,'Dark Theme')]")
	WebElement Dark_theme;
	
	
	public void Theme_button() {
		Theme_button.click();
	}
	
	public WebElement Verify_Choose_your_theme_color() {
		return Verify_Choose_your_theme_color;
	}
	
	
	public WebElement Select_color() {
		return Select_color;
	}
	
	
	
	
	public WebElement Verify_Choose_Your_theme() {
		return Verify_Choose_Your_theme;
	}
	
	
	public WebElement Light_theme() {
		return Light_theme;
	}
	
	
	
	public WebElement Dark_theme() {
		return Dark_theme;
	}
	
	
	
	public WebElement Verify_Dark_theme() {
		return Verify_Dark_theme;
	}
	
	public WebElement Verify_Light_theme() {
		return Verify_Light_theme;
	}
	
	
	public void Select_random_Colour() throws InterruptedException {
		
		Select_color.click();
		
		Thread.sleep(2000);
		
		Thread.sleep(1000);
		List<WebElement> Colour_Pick=driver.findElements(By.xpath("//div[contains(@id,'color-picker')]/div[2]/div"));
		
		int ColourSize=Colour_Pick.size();
		
		int randomColour=ThreadLocalRandom.current().nextInt(1, ColourSize);
		
		driver.findElement(By.xpath("//div[contains(@id,'color-picker')]/div[2]/div["+randomColour+"]")).click();
		
		String colour_value = driver.findElement(By.xpath("//div[contains(@class,'hex-text')]//input")).getText();
		
		System.out.println(colour_value);
		Thread.sleep(1000);
		Select_color.click();
		Thread.sleep(1000);
	}
	
	
	public void Select_Light_theme() {
		
		if(Verify_Light_theme().isEnabled()) {
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			test.log(LogStatus.PASS, "Light Theme is enbled sucessfully");
			
		}
		else {
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Light_theme().click();
			test.log(LogStatus.PASS, "Light theme is selected Sucessfull");
		}
	}
	
	public void Select_Dark_theme() {
		
		if(!Verify_Dark_theme().isDisplayed()) {
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			test.log(LogStatus.PASS, "Dark is enbled sucessfully");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else {
			
			Dark_theme().click();
			test.log(LogStatus.PASS, "Dark theme is selected Sucessfull");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	
}
