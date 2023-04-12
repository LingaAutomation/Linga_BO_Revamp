package com.Pages;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.netty.util.internal.ThreadLocalRandom;

public class ItemServiceChargePage {

	
	public WebDriver driver;
	public ExtentTest test;
	
	public ItemServiceChargePage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'NEW ITEM SERVICE CHARGE')]")
	WebElement New_ItemServiceChargeBtn;
	
	@FindBy(xpath = "//label[contains(.,'Name')]/../../input")
	WebElement Name_Input_ItemServiceCharge;
	
	@FindBy(xpath = "//label[contains(.,'Percentage')]/../../input")
	WebElement Percentage_Input_ItemServiceCharge;
	
	@FindBy(xpath = "//label[contains(.,'Taxes')]/../../div/div/input")
	WebElement Taxes_Input_ItemServiceCharge;
	
	public WebElement Taxes_Input_ItemServiceCharge()
	{
		return Taxes_Input_ItemServiceCharge;
	}
	
	@FindBy(xpath = "//select-option[contains(.,'Select All')]")
	WebElement SelectAll_Tax_Input_ItemServiceCharge;
	
	@FindBy(xpath = "//select-option[contains(.,'Normal-10%')]")
	WebElement Normal_Tax_Input_ItemServiceCharge;
	
	@FindBy(xpath = "//select-option[contains(.,'Default')]")
	WebElement Default_Tax_Input_ItemServiceCharge;
	
	@FindBy(xpath = "//app-auto-complete[@label='Taxes']/div/mat-form-field/div/div/div[4]//button/span/mat-icon[contains(.,'close')]")
	WebElement Close_Taxes_ItemServiceCharge;
	
	
	
	public WebElement New_ItemServiceChargeButton()
	{
		return New_ItemServiceChargeBtn;
	}
	
	public void Click_NewItemServiceChargeButton()
	{
		New_ItemServiceChargeBtn.click();
	}
	
	public void Enter_Item_Service_Charge(String str) throws Exception
	{
		Thread.sleep(1000);
		//Clear the name
		Name_Input_ItemServiceCharge.clear();
		Thread.sleep(500);
		Name_Input_ItemServiceCharge.sendKeys(str);

		Thread.sleep(500);
		Percentage_Input_ItemServiceCharge.clear();
		Thread.sleep(500);
		Percentage_Input_ItemServiceCharge.sendKeys("5000");
			
		
	}
	
	
	public void Enter_Item_Service_Charge_Name(String str) throws Exception
	{
		Thread.sleep(1000);
		//Clear the name
		Name_Input_ItemServiceCharge.clear();
		Thread.sleep(500);
		Name_Input_ItemServiceCharge.sendKeys(str);
	}
	
	
	
	
	public void Enter_Item_Service_Charge_Percentage(String str) throws Exception
	{
		Thread.sleep(1000);
		//Clear the name
		Percentage_Input_ItemServiceCharge.clear();
		Thread.sleep(500);
		Percentage_Input_ItemServiceCharge.sendKeys(str);
	}
	
	public void Enter_Item_Service_Charge_Taxes(String str) throws Exception
	{
		Thread.sleep(1000);
		//Clear the name
		Taxes_Input_ItemServiceCharge.clear();
		Thread.sleep(500);
		Taxes_Input_ItemServiceCharge.sendKeys(str);
	}
	
	public void SelectAll_Tax() throws Exception
	{
		Thread.sleep(500);
		Taxes_Input_ItemServiceCharge.click();
		
		Thread.sleep(500);
		SelectAll_Tax_Input_ItemServiceCharge.click();
	}
	
	public void Normal_Tax() throws Exception
	{
		Thread.sleep(500);
		Taxes_Input_ItemServiceCharge.click();
		
		Thread.sleep(500);
		Normal_Tax_Input_ItemServiceCharge.click();
	}
	
	public void Default_Tax() throws Exception
	{
		Thread.sleep(500);
		Taxes_Input_ItemServiceCharge.click();
		
		Thread.sleep(500);
		Default_Tax_Input_ItemServiceCharge.click();
	}
	
	public void Close_Taxes_ItemServiceCharge()
	{
		Close_Taxes_ItemServiceCharge.click();
	}
	
	
	
	public void Select_Random_Tax() throws Exception
	{
		
		Thread.sleep(1000);
		
		for(int i=1;i<=2;i++)
		{
			Thread.sleep(1000);
		
		Taxes_Input_ItemServiceCharge.click();
		
		Thread.sleep(1000);
		List<WebElement> listOfOptions=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));

		int OptionsSize=listOfOptions.size();
		
//		Random rd=new Random();
	//	rd.nextInt(menuSize);
		if(OptionsSize==0)
		{
			Taxes_Input_ItemServiceCharge.click();
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[2]")).click();

			
		}
		else if(OptionsSize==1)
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+OptionsSize+"]")).click();
		
		}
		else
		{
		int randomOption=ThreadLocalRandom.current().nextInt(2, OptionsSize);
		 
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomOption+"]")).click();
		}
		
		List<WebElement> listOfOptions1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));

		if(listOfOptions1.size()!=0)
		{
			Taxes_Input_ItemServiceCharge.click();

		}
		
		}
		
		
	}
}
