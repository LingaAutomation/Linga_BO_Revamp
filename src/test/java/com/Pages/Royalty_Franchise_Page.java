package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;

public class Royalty_Franchise_Page extends BasePage 
{
//	public SelfHealingDriver driver;
//	ExtentTest test;
	
	public Royalty_Franchise_Page(SelfHealingDriver driver, ExtentTest test) {
//		super(driver, test);
//		// TODO Auto-generated constructor stub
//		this.driver=driver;
//		this.test=test;
		super(driver,test);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[contains(@data-placeholder,'Search')]")
	WebElement SearchBox;
	

	
	@FindBy(xpath = "//app-input[contains(.,'Bank Name')]//input")
	WebElement Bank_name;
	
	@FindBy(xpath = "//app-input[contains(.,'Routing Number ')]//input")
	WebElement Routing_name;
	
	@FindBy(xpath = "//app-input[contains(.,'Account Number ')]//input")
	WebElement Account_number;
	
	@FindBy(xpath = "//span[contains(.,'Add Percentage')]")
	WebElement Add_Percentage;
	
	@FindBy(xpath = "//app-input-table/div/div[2]/div[1]/app-input[1]//input")
	WebElement Percentage_name;
	
	
	@FindBy(xpath = "//app-input-table/div/div[2]/div[2]//div[contains(@class,'number')]/button[1]")
	WebElement Percentage_Increase;
	@FindBy(xpath = "//app-input-table/div/div[2]/div[2]//div[contains(@class,'number')]/button[2]")
	WebElement Percentage_Decrease;
	
	@FindBy(xpath = "//app-input-table/div/div[2]/div[2]//div[contains(@class,'number')]/button[1]")
	WebElement Percentage_Default_toggle;
	
	@FindBy(xpath = "//app-input-table/div/div[2]/div[4]/button")
	WebElement Percentage_Delete_button;
	
	
	
	
	public WebElement SearchBox()
	{
		return SearchBox;
	}
	
	public WebElement Routing_name()
	{
		return Routing_name;
	}
	
	public WebElement Account_number()
	{
		return Account_number;
	}
	
	public WebElement Bank_name()
	{
		return Bank_name;
	}
	
	public WebElement Add_Percentage()
	{
		return Add_Percentage;
	}
	


	public WebElement Percentage_name()
	{
		return Percentage_name;
	}
	
	public WebElement Percentage_Increase()
	{
		return Percentage_Increase;
	}
	
	public WebElement Percentage_Decrease()
	{
		return Percentage_Decrease;
	}
	
	
	
	public WebElement Percentage_Default_toggle()
	{
		return Percentage_Default_toggle;
	}
	
	public WebElement Percentage_Delete_button()
	{
		return Percentage_Delete_button;
	}
	
	
	public void Enter_Set_Presentage(String str, String str2) throws Exception
    {
        new Common_XPaths(driver, test);


        Thread.sleep(500);

    for(int i=1;i<=3;i++)
    {
    	Add_Percentage().click();
    }

        List<WebElement> PrefixList=driver.findElements(By.xpath("//app-input-table/div/div/div[1]/app-input//input"));

        for(int i=2;i<=PrefixList.size()+1;i++)
        {
            //Prefix name
            driver.findElement(By.xpath("//app-input-table/div/div["+i+"]/div[1]/app-input//input")).clear();

            driver.findElement(By.xpath("//app-input-table/div/div["+i+"]/div[1]/app-input//input")).sendKeys(str+i);
            Thread.sleep(500);

 

            //Prefix price
            driver.findElement(By.xpath("//app-input-table/div/div["+i+"]/div[2]/app-input//input")).clear();

            driver.findElement(By.xpath("//app-input-table/div/div["+i+"]/div[2]/app-input//input")).sendKeys(str2);

            Thread.sleep(500);

       
               
            

        }
        
        driver.findElement(By.xpath("//app-input-table/div/div[4]/div[3]//mat-slide-toggle")).click();
/*
        for(int i=1;i<=1;i++)
        {
            Thread.sleep(500);
            driver.findElement(By.xpath("//app-input-table/div/div[4]/div[4]/button")).click();
            Thread.sleep(500);

 

        cmp.Click_DeleteButton();
        }
        */
}
}