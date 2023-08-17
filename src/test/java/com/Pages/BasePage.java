package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.managers.ChromeDriverManager;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
public class BasePage {

	Common_XPaths cmp;
	 private static final int TIMEOUT = 5;
	    private static final int POLLING = 100;

	    public WebDriver driver;
	    public ExtentTest test;
	    public WebDriverWait wait;

	    public BasePage(WebDriver driver,ExtentTest test) {
	        this.driver = driver;
	        this.test=test;
//	        wait = new WebDriverWait(driver, Duration.ofMinutes(TIMEOUT), Duration.ofMinutes(POLLING));
	        PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	    }
	    
	@FindBy(xpath = "//cdk-virtual-scroll-viewport//div/div[1]//select-option")
	WebElement First_Option_inDropDwon;
	
	public void Click_Button(WebElement ele, String msg)
	{
		
//		ele.click();
		cmp.Click_Wait_ForElementClickable(ele, 30);
		System.out.println(msg);
	}
	
	public void Click_DropDown(WebElement ele, String Msg) throws Exception
	{
		ele.click();
		
		List<WebElement> optList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
 
		int optionSize=optList.size();
		if(optionSize==0)
		{
			
			List<WebElement> optList1=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
			
			int optionSize1=optList1.size();
			
			
			int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize1);
			
			Thread.sleep(1000);

			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
		
		}
		else if(optionSize==1)
		{
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+optionSize+"]//select-option")).click();
		
		}
		else if(optionSize<=10)
		{
			
		int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize);
		
		Thread.sleep(1000);

		driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
		}
		else
		{
			int randomOpt=ThreadLocalRandom.current().nextInt(1, 10);
			
			Thread.sleep(1000);

			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
			
		}
		
		List<WebElement> ModifyWithList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));

		if(ModifyWithList1.size()!=0)
		{
			ele.click();
			
		}
		
		System.out.println(Msg);
	}
	
	public void Click_DropDown_withSearch(WebElement ele, String Msg) throws Exception
	{
		
		ele.click();
		
		List<WebElement> optList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
 
		int optionSize=optList.size();
		if(optionSize==0)
		{
			
			List<WebElement> optList1=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));
			
			int optionSize1=optList1.size();
			
			
			int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize1);
			
			Thread.sleep(1000);

//			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
	cmp.Search(driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).getText());
			
			First_Option_inDropDwon.click();
		}
		else if(optionSize==1)
		{
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+optionSize+"]//select-option")).click();
		
		}
		else if(optionSize<=10)
		{
			
		int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize);
		
		Thread.sleep(1000);

//		driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
		cmp.Search(driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).getText());
		
		First_Option_inDropDwon.click();
		
		}
		else
		{
			int randomOpt=ThreadLocalRandom.current().nextInt(1, 10);
			
			Thread.sleep(1000);

//			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
			cmp.Search(driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).getText());
			
			First_Option_inDropDwon.click();
		}
		
		List<WebElement> ModifyWithList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));

		if(ModifyWithList1.size()!=0)
		{
			ele.click();
			
		}
		
		System.out.println(Msg);
	}
	
	public void Enter_Text(WebElement ele,String Text, String Msg) throws Exception
	{
		Thread.sleep(1000);
		ele.clear();
		Thread.sleep(1000);
		ele.sendKeys(Text);
		
		System.out.println(Msg);
	}
}
