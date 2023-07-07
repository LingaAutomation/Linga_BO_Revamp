package com.Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class CoursingPage {
	public WebDriver driver;
	public ExtentTest test;
	
	Utility ut=new Utility();
	
	public CoursingPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'NEW COURSING')]")
	WebElement NewCoursingBtn;
	
	@FindBy(xpath = "//label[contains(.,'Priority')]/../../input")
	WebElement PriorityInput;
	
	@FindBy(xpath = "//span[contains(.,'Number should not be less than 0. Enter Valid Priority')]")
	WebElement PriorityZeroPopUp;
	
	@FindBy(xpath = "//*[contains(@class,'header')]/div/*[.=' Name ']")
	WebElement Name_TableHeader;
	
	@FindBy(xpath = "//*[contains(@class,'header')]/div/*[.=' Priority ']")
	WebElement Priority_TableHeader;
	
	
	
	public WebElement PriorityZeroPopUp()
	{
		return PriorityZeroPopUp;
	}
	
	public void VerifyZeroPriorityAlertMsg()
	{
		if(PriorityZeroPopUp.isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter Valid Priority Pop up dispayed when Enter Priority 0");
		
			
		}
		else
		{
			test.log(LogStatus.PASS, "Enter Valid Priority Pop up not dispayed when Enter Priority 0");
	
		}
	}
	
	public void Verify_AscendingNameSorting()
	{
		Name_TableHeader.click();
		
		ArrayList<String> ArLst=new ArrayList<String>();
		if(driver.findElement(By.xpath("//span[contains(.,'Name')]/../div[contains(@class,'mode-asc')]")).isDisplayed())
		{
			List<WebElement> NameLst=driver.findElements(By.xpath("//div[contains(@id,'cdk-drop-list')]/div/data-grid-row/div/div[1]"));
			
			for(WebElement ele:NameLst)
			{ 
				ArLst.add(ele.getText());
			}
			
			ArrayList<String> sortedLst=new ArrayList<String>();
			
			for(String st:ArLst)
			{
				sortedLst.add(st);
			}
			
			Collections.sort(sortedLst);
			
			if(sortedLst.equals(ArLst))
			{
				test.log(LogStatus.PASS, "Ascending Order Sorted Correctly");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				System.out.println(sortedLst);
			}
			else
			{
				test.log(LogStatus.FAIL, "Ascending Order Sorted Incorrect");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
				
				System.out.println(sortedLst);
			}
		}
	}
	
	public void Verify_DescendingNameSorting()
	{
		Name_TableHeader.click();
		
		ArrayList<String> ArLst=new ArrayList<String>();
		if(driver.findElement(By.xpath("//span[contains(.,'Name')]/../div[contains(@class,'mode-desc')]")).isDisplayed())
		{
			List<WebElement> NameLst=driver.findElements(By.xpath("//div[contains(@id,'cdk-drop-list')]/div/data-grid-row/div/div[1]"));
			
			for(WebElement ele:NameLst)
			{
				ArLst.add(ele.getText());
			}
			
			ArrayList<String> sortedLst=new ArrayList<String>();
			
			for(String st:ArLst)
			{
				sortedLst.add(st);
			}
			
			Collections.sort(sortedLst);
			Collections.reverse(sortedLst);
			
			if(sortedLst.equals(ArLst))
			{
				test.log(LogStatus.PASS, "Desending Order Sorted Correctly");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				System.out.println(sortedLst);
			}
			else
			{
				test.log(LogStatus.FAIL, "Desending Order Sorted Incorrect");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
				
				System.out.println(sortedLst);
			}
		}
	}
	
	public void Verify_AscendingPriority()
	{
		//Number of rows
		List<WebElement> rowss = driver.findElements(By.xpath(""));
		int rowa = rowss.size()-1;
		ArrayList<Integer> array = new ArrayList<Integer>();
		for(int i =1; i <= rowa; i++)
		{
			String quan = driver.findElement(By.xpath("")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
			Integer dquan = Integer.parseInt(quan);
			//int quantity = quan.intValue();
			array.add(dquan);
		}
		Collections.sort(array);
		for(int i =0; i < rowa; i++)
		{	int s = i+1;
			String e = driver.findElement(By.xpath("")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "");
			double actual = Double.parseDouble(e);
			double expect = array.get(i);
			if(actual != expect)
			{
				test.log(LogStatus.PASS, "Sorted by Quantity is Fail");
			}
		}
	}
	
	public void ClickNewCoursing()
	{
		NewCoursingBtn.click();
	}
	
	public void EnterCoursingName(String Str)
	{
		
	}
	
	public void EnterPriority(String str) throws Exception
	{
		Thread.sleep(500);
		PriorityInput.clear();
		
		Thread.sleep(500);
		PriorityInput.sendKeys(str);
	}
	
	public WebElement PriorityInputBox()
	{
		return PriorityInput;
	}
}
