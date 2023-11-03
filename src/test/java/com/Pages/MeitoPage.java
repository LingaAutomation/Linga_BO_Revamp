package com.Pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class MeitoPage extends BasePage
{

	
//	public SelfHealingDriver driver;
//	public ExtentTest test;
	Utility ut=new Utility();
	Common_XPaths cmp;
	WebDriverWait wait;
	public MeitoPage(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		super(driver,test);
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'Update Template')]")
	WebElement Update_TemplateBtn;
	
	@FindBy(xpath = "//label[contains(.,'Choose Menu')]/../../input")
	WebElement Choose_MenuInputBx;
	
	@FindBy(xpath = "//span[contains(.,'Meito Menu item not found')]")
	WebElement Meito_NotFound_ErrorMsg;
	
	public void Click_Update_Template()
	{
		Update_TemplateBtn.click();
	}
	
	public void Select_Choose_Menu() throws Exception
	{
		Choose_MenuInputBx.click();
		
		String menuName=null;
		
		Thread.sleep(1000);
		List<WebElement> menuList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		int menuSize=menuList.size();
		
		if(menuSize==0)
		{
			
		}
		else if(menuSize==1)
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+menuSize+"]")).click();
	
			String menu_Name=driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+menuSize+"]")).getText();
			menu_Name=menuName;
		}
		else
		{
			
		
		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomMenu+"]")).click();
		
		String menu_Name=driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomMenu+"]")).getText();
		menu_Name=menuName;
		}
		
		try
		{
		if(Meito_NotFound_ErrorMsg.isDisplayed())
		{
			test.log(LogStatus.FAIL, "Meito Menu item not found");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception k)
		{
			
			test.log(LogStatus.PASS, "Serving Size Levels available for this Selected Meito Menu Item");
			
		//Get Available Serving Size Levels
		List<WebElement> ssl_List=driver.findElements(By.xpath("//app-segmentation[@name='selectedSSL']/div/div/div/div/button"));
		
		for(WebElement SSL:ssl_List)
		{
			
			SSL.click();
			
			try
			{
			if(driver.findElement(By.xpath("//th[contains(.,'Modifier')]")).isDisplayed())
			{
			List<WebElement> row_modList=driver.findElements(By.xpath("//app-meito//table[1]/tbody/tr"));
			
			List<WebElement> col_modList=driver.findElements(By.xpath("//app-meito//table[1]/tbody/tr[1]/td"));
			
			for(int i=1;i<=row_modList.size();i++)
			{
				
				for(int j=2;j<=col_modList.size();j++)
				{
					Thread.sleep(500);
					driver.findElement(By.xpath("//app-meito//table[1]/tbody/tr["+i+"]/td["+j+"]/div/app-input[1]//input")).clear();
					Thread.sleep(500);
					driver.findElement(By.xpath("//app-meito//table[1]/tbody/tr["+i+"]/td["+j+"]/div/app-input[1]//input")).sendKeys("1"+i);
	
				}
			}
			
//			driver.findElement(By.xpath("//app-meito//table[1]/tbody/tr[1]/td[2]/div/app-input[1]//input")).clear();
//			driver.findElement(By.xpath("//app-meito//table[1]/tbody/tr[1]/td[2]/div/app-input[1]//input")).sendKeys("100");

			
			}
			}
			catch(Exception l)
			{
				test.log(LogStatus.INFO, "Modifiers not Available on this menu Items "+menuName);
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
				
			}
			
		}
		
		try
		{
		
		if(driver.findElement(By.xpath("//th[contains(.,'Flavored')]")).isDisplayed())
		{
			
			List<WebElement> fla_rowList=driver.findElements(By.xpath("//app-meito//table[2]/tbody/tr[1]"));
			
			for(int i=1;i<=fla_rowList.size();i++)
			{
				Thread.sleep(500);
				driver.findElement(By.xpath("//app-meito//table[2]/tbody/tr["+i+"]/td[2]/div[1]/app-input//input")).clear();
				Thread.sleep(500);
				driver.findElement(By.xpath("//app-meito//table[2]/tbody/tr["+i+"]/td[2]/div[1]/app-input//input")).sendKeys("20"+i);
				
			}
			
//			Thread.sleep(500);
//			driver.findElement(By.xpath("//app-meito//table[2]/tbody/tr[1]/td[2]/div[1]/app-input//input")).clear();
//			Thread.sleep(500);
//			driver.findElement(By.xpath("//app-meito//table[2]/tbody/tr[1]/td[2]/div[1]/app-input//input")).sendKeys("200");
		
			
		}
		}
		catch(Exception l)
		{
			test.log(LogStatus.INFO, "Flavors not Available on this menu Items "+menuName);
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		}
	}
}
