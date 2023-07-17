package com.Pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class SubCategoriesPage {

	public WebDriver driver;
	public ExtentTest test;
	
	Common_XPaths cmp=new Common_XPaths(driver, test);
	Utility ut=new Utility();
	public SubCategoriesPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//button[contains(.,'NEW SUB-CATEGORY')]")
	WebElement New_SubCategoryBtn;
	
	
	@FindBy(xpath = "//input[@data-placeholder='Select Category']")
	WebElement CategoryDropBtn;
	
	@FindBy(xpath = "//span[contains(.,'Apply default serving size levels')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement ApplyDefaultServingSize_YesBtn;
		
	@FindBy(xpath = "//span[contains(.,'Apply default serving size levels')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement ApplyDefaultServingSize_NoBtn;
	
	@FindBy(xpath = "//button[contains(.,'APPLY')]")
	WebElement ApplyBtn;
	
	//span[contains(.,'Category')]/../../div[contains(@class,'data-grid-header')]
	public void Click_NewSubCategory() 
	{
		New_SubCategoryBtn.click();	
	}
	
	public void Click_ApplyButton()
	{
		ApplyBtn.click();
	}
	
	public void Select_Category() throws Exception
	{
		Thread.sleep(1000);
		
		new Common_XPaths(driver, test).Click_DropDown_withSearch(CategoryDropBtn, "Category Selected");
//		CategoryDropBtn.click();
//		
//		List<WebElement> catgryList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
//		
//		int catgrySize=catgryList.size();
//		
//		if(catgrySize<=6)
//		{
//		
//		int randomcatgry=ThreadLocalRandom.current().nextInt(1, catgrySize);
//		
//		
//		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomcatgry+"]")).click();
//		}
//		else
//		{
//			int randomcatgry=ThreadLocalRandom.current().nextInt(1, 6);
//			
//			
//			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomcatgry+"]")).click();
//		
//		}
	
	}
	
	public void Select_DefaultServingSize()
	{
		if(ApplyDefaultServingSize_YesBtn.isSelected())
		{
			
		}
		else
		{
			ApplyDefaultServingSize_YesBtn.click();
		}
	}
	
	public void DeSelect_DefaultServingSize()
	{
		if(ApplyDefaultServingSize_YesBtn.isEnabled())
		{
			ApplyDefaultServingSize_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	public void Verify_CategoryFilter() throws Exception
	{
		Thread.sleep(1000);
		CategoryDropBtn.click();
		
	List<WebElement> catgryList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		int catgrySize=catgryList.size();
		
		
		int randomcatgry=ThreadLocalRandom.current().nextInt(1, catgrySize);
		
		WebElement selCat=driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomcatgry+"]"));
		
		String randomCategoryName=selCat.getText();
	
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		js.executeScript("arguments[0].scrollIntoView(true);", selCat);
		
		selCat.click();
		
		
		List<WebElement> ListOfCats=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/data-grid-row/div/div[3]/p"));
		
		for(WebElement cat:ListOfCats)
		{
			if(cat.getText().equalsIgnoreCase(randomCategoryName))
			{
				test.log(LogStatus.PASS, "Category Filtered Correctly");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			} 
			else
			{
				test.log(LogStatus.FAIL, "Category Filtered Incorrectly. Wrong Category name is : "+cat.getText());
			
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
	}
}
