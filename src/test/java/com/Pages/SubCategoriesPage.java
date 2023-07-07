package com.Pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class SubCategoriesPage {

	public WebDriver driver;
	public ExtentTest test;
	WebDriverWait wait;
	
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
		
		cmp = new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
//		CategoryDropBtn.click();
		
		Thread.sleep(2000);
		wait=new WebDriverWait(driver, Duration.ofSeconds(120));
		
		wait.until(ExpectedConditions.elementToBeClickable(CategoryDropBtn)).click();
//		CoursingDropBtn.click();
		
		Thread.sleep(1000);
		List<WebElement> CategoryList=driver.findElements(By.xpath("//div/select-option"));
		
		int CategorySize=CategoryList.size();
		
		if(CategorySize<=6)
		{
		
		int randomCategory=ThreadLocalRandom.current().nextInt(1, CategorySize);
		
		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
		
		cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomCategory+"]/select-option")).getText());
		
		driver.findElement(By.xpath("//div[1]/select-option")).click();
		}
		else
		{
			int randomCategory=ThreadLocalRandom.current().nextInt(1, 6);
			
			Thread.sleep(1000);
//			driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
			
			cmp.Verify_Search(driver.findElement(By.xpath("//div["+randomCategory+"]/select-option")).getText());
			
			driver.findElement(By.xpath("//div[1]/select-option")).click();
		
		}
	
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
		
	List<WebElement> catgryList=driver.findElements(By.xpath("//div/select-option"));
		
		int catgrySize=catgryList.size();
		
		
		int randomcatgry=ThreadLocalRandom.current().nextInt(1, catgrySize);
		
		WebElement selCat=driver.findElement(By.xpath("//div/select-option["+randomcatgry+"]"));
		
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
	
	public void Click_color_option() {
		color_option.click();

	}
	@FindBy(xpath = "//div[contains(@class,'color-option')]")
	WebElement color_option;
	
	public void Random_color_option() throws InterruptedException {
		Thread.sleep(2000);

		Click_color_option();

		Thread.sleep(2000);


		List<WebElement> Random_color_List=driver.findElements(By.xpath("//div[contains(@class,'preset-color ng-star-inserted')]"));

		int Random_color=Random_color_List.size();


		int random_color=ThreadLocalRandom.current().nextInt(1, Random_color);


		driver.findElement(By.xpath("//div[contains(@class,'preset-color ng-star-inserted')]["+random_color+"]")).click();
		Thread.sleep(2000);
		ut.PassedCaptureScreenshotAsBASE64(driver, test);

	}
	
	public void SearchAndClickEdit(String SearchValue) throws Exception
	{
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(3000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(80000);
//		Thread.sleep(80000);

//		for(int i=1;i<=10;i++)
//		{
//			Thread.sleep(500);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
//		}

		driver.findElement(By.xpath("//span[.='"+SearchValue+" ']/../../td[7])[1]/div/div[1]/button")).click();

		//driver.findElement(By.xpath("//div[.='"+SearchValue+"']/../div[4]/div[1]/button")).click();
	}

	public void SearchAndClickDelete(String SearchValue) throws Exception
	{
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(80000);
//		for(int i=1;i<=10;i++)
//		{
//			Thread.sleep(500);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
//		}

		driver.findElement(By.xpath("//span[.='"+SearchValue+" ']/../../td[7])[1]/div/div[2]/button")).click();
	}
	public void SearchAndClickActivate(String SearchValue) throws Exception
	{
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(1000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(80000);

		//Displaygroup
		driver.findElement(By.xpath("//div[.='"+SearchValue+" ']/../../td[7]/div/div/button")).click();
	}
	
	@FindBy(xpath = "//input[@data-placeholder='Search']")
	WebElement SearchBox;
}
