package com.Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class DepartmentPage //extends BasePage 
{

	WebDriver driver;
	ExtentTest test;
	Common_XPaths cmp;
	Utility ut=new Utility();
	
	public DepartmentPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
		
//		super(driver, test);
	}
	
	@FindBy(xpath = "//h3[@class='title']")
	WebElement DepartmentPageHeader;
	
	@FindBy(xpath = "//button[contains(.,'NEW DEPARTMENT')]")
	WebElement NewDepartmentBtn;
	
	@FindBy(xpath = "//label[contains(.,'Code')]/../../input")
	WebElement CodeInputBox;
	
	@FindBy(xpath = "//label[contains(.,'Description')]/../../textarea")
	WebElement DescriptionInputBox;
	
	
	 
	
	public WebElement AddDepartment()
	{
		return NewDepartmentBtn;
	}
	
	public void Click_NewDepartment()
	{
		NewDepartmentBtn.click();
	}
	
	
	public void Enter_Department_Without_Membership(String DepName,String DepCode) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		//Clear and Enter the Department Name 
		Thread.sleep(1000);
		cmp.EnterName(DepName);
		
		Thread.sleep(1000);
		//Clear the Department Code
		CodeInputBox.clear();
		//Enter the Department Code
		CodeInputBox.sendKeys(DepCode);
		
		//Clear the Description button
		DescriptionInputBox.clear();
		//Enter the Description 
		DescriptionInputBox.sendKeys("Department is "+DepName);
		
		if(cmp.YesToggleBtn.isSelected())
		{
			cmp.NoToggleBtn.click();
		}
		else
		{
			
		}
		
	}
	
	public void Enter_Department_With_Membership(String DepName,String DepCode) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		//Clear and Enter the Department Name 
		Thread.sleep(1000);
		cmp.EnterName(DepName);
		
		Thread.sleep(1000);
		//Clear the Department Code
		CodeInputBox.clear();
		//Enter the Department Code
		CodeInputBox.sendKeys(DepCode);
		
		//Clear the Description button
		DescriptionInputBox.clear();
		//Enter the Description 
		DescriptionInputBox.sendKeys("Department is "+DepName);
		
		if(cmp.YesToggleBtn.isSelected())
		{
			
		}
		else
		{
			cmp.YesToggleBtn.click();
		}
		
	}
	
	public void Enter_DepartmentCode(String str) throws Exception
	{
		Thread.sleep(1000);
		//Clear the Dep Code
		CodeInputBox.clear();
		Thread.sleep(500);
		//Enter the Department code
		CodeInputBox.sendKeys(str);
	}
	
	public void VerifyDepartmentPageHeader()
	{
		if(DepartmentPageHeader.getText().equalsIgnoreCase("Departments"))
		{
			test.log(LogStatus.PASS, "Department page loaded Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Department page failed to load");
		}
	}
}
