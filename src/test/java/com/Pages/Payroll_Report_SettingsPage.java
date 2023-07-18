package com.Pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Payroll_Report_SettingsPage 
{

	public WebDriver driver;
	public ExtentTest test;
	Common_XPaths cmp;
	TaxesPage tx;
	Utility ut=new Utility();
	
	public Payroll_Report_SettingsPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'OVERTIME')]")
	WebElement Overtime_btn;
	
	@FindBy(xpath = "//span[contains(.,'Allow Over Tip Out')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Allow_OverTip_Out_YesBtn;
		
	@FindBy(xpath = "//span[contains(.,'Allow Over Tip Out')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Allow_OverTip_Out_NoBtn;
	
	@FindBy(xpath = "//label[contains(.,'Select Day')]/../../input")
	WebElement Payroll_Week_Start_DayInputBx;
	
	@FindBy(xpath = "//span[contains(.,'Default Payroll Process')]/../..//input")
	WebElement Default_Payroll_ProcessInputBx;
	
	@FindBy(xpath = "//select-option[contains(.,'DAILY')]")
	WebElement Daily_Payroll_ProcessBtn;
	
	@FindBy(xpath = "//select-option[contains(.,'WEEKLY')]")
	WebElement Weekly_Payroll_ProcessBtn;
	
	@FindBy(xpath = "//label[contains(.,'Age')]/../../input")
	WebElement Age_LimitInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Hours')]/../../input")
	WebElement Hours_LimitInputBx;
	
	@FindBy(xpath = "//div/span[.='SETTINGS']")
	WebElement SettingsTab;
	
	@FindBy(xpath = "//div/span[.='OVER TIME SETTINGS']")
	WebElement OverTime_SettingsTab;
	
	@FindBy(xpath = "//div[@class='radio-box'][contains(.,'Daily')]")
	WebElement Daily_Set_OverTimeRadioBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][contains(.,'Weekly')]")
	WebElement Weekly_Set_OverTimeRadioBtn;
	
	@FindBy(xpath = "//label[contains(.,'Effective Date')]/../../input")
	WebElement Effective_DateInputBx;
	
	@FindBy(xpath = "//div[contains(@class,'calendar-controls')]/button[3]")
	WebElement NextMonth_Calender_EffectiveDateBtn;
	
	@FindBy(xpath = "//span[contains(.,'Over Time 1')]/../..//label[contains(.,'Hours')]/../../input")
	WebElement Hours_OverTime_OneInputBx;
	
	@FindBy(xpath = "//span[contains(.,'Over Time 1')]/../..//label[contains(.,'Percentage')]/../../input")
	WebElement Percentage_OverTime_OneInputBx;
	
	@FindBy(xpath = "//span[contains(.,'Over Time 2')]/../..//label[contains(.,'Hours')]/../../input")
	WebElement Hours_OverTime_TwoInputBx;
	
	@FindBy(xpath = "//span[contains(.,'Over Time 2')]/../..//label[contains(.,'Percentage')]/../../input")
	WebElement Percentage_OverTime_TwoInputBx;
	
	@FindBy(xpath = "//span[contains(.,'Over Time 3')]/../..//label[contains(.,'Hours')]/../../input")
	WebElement Hours_OverTime_ThreeInputBx;
	
	@FindBy(xpath = "//span[contains(.,'Over Time 3')]/../..//label[contains(.,'Percentage')]/../../input")
	WebElement Percentage_OverTime_ThreeInputBx;
	
	@FindBy(xpath = "//mat-hint[contains(.,'Enter the minimum Age')]")
	WebElement Minimum_AgeErrorMsg;
	
	@FindBy(xpath = "//mat-hint[contains(.,'Maximum age limit is 100')]")
	WebElement Age_LimitErrorMsg;
	
	@FindBy(xpath = "//mat-hint[contains(.,'Enter valid Hours')]")
	WebElement Valid_HoursErrorMsg;
	
	@FindBy(xpath = "//mat-hint[contains(.,'Enter valid percentage should be more than 100')]")
	WebElement Valid_PercentageErrorMsg;
	
	public void Click_OverTime()
	{
		Overtime_btn.click();
	}
	
	public void Select_SettingsTab()
	{
		SettingsTab.click();
	}
	
	public void Select_OverTime_SettingsTab()
	{
		OverTime_SettingsTab.click();
	}
	
	
	public void Enable_Allow_OverTip_Out()
	{
		if(Allow_OverTip_Out_YesBtn.isSelected()) 
		{
			
		}
		else
		{
			Allow_OverTip_Out_YesBtn.click();
		}
	}
	
	public void Disable_Allow_OverTip_Out()
	{
		if(Allow_OverTip_Out_YesBtn.isEnabled()) 
		{
			Allow_OverTip_Out_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	
	
	public WebElement Allow_OverTip_Out_YesBtn()
	{
		return Allow_OverTip_Out_YesBtn;
	}
	
	public void Select_Payroll_Week_StartDay() throws Exception
	{
		Thread.sleep(1000);
		Payroll_Week_Start_DayInputBx.click();
		
		Thread.sleep(1000);
	List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int OptionSize=OptionList.size();
		
		
		int randomOption=ThreadLocalRandom.current().nextInt(1, OptionSize);
		
		Thread.sleep(1000);

		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomOption+"]/select-option")).click();
	
	}
	
	public WebElement Payroll_Week_StartDay()
	{
		return Payroll_Week_Start_DayInputBx;
	}
	
	public void Select_Daily_Default_PayrollProcess() throws Exception
	{
		Thread.sleep(1000);
		Default_Payroll_ProcessInputBx.click();
		Thread.sleep(1000);
		Daily_Payroll_ProcessBtn.click();
	}
	
	public void Select_Weekly_Default_PayrollProcess() throws Exception
	{
		Thread.sleep(1000);
		Default_Payroll_ProcessInputBx.click();
		Thread.sleep(1000);
		Weekly_Payroll_ProcessBtn.click();
	}
	
	public WebElement Default_Payroll_ProcessInputBox()
	{
		return Default_Payroll_ProcessInputBx;
	}
	
	public void Setup_Hours_Limit_byAge(String Age, String Hours) throws Exception
	{
		Thread.sleep(1000);
		Age_LimitInputBx.clear();
		Thread.sleep(500);
		Age_LimitInputBx.sendKeys(Age);
		
		Thread.sleep(1000);
		Hours_LimitInputBx.clear();
		Thread.sleep(500);
		Hours_LimitInputBx.sendKeys(Hours);
		
		
	}
	
	public WebElement Age_LimitInputBox()
	{
		return Age_LimitInputBx;
	}
	
	public WebElement Hours_LimitInputBox()
	{
		return Hours_LimitInputBx;
	}
	
	public void Verify_Minimum_Age_ErrorMessage()
	{
		try
		{
		if(Minimum_AgeErrorMsg.isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter the minimum Age Error Pop is Displayed");
		}
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Enter the minimum Age Error Pop is not Displayed");
			
		}
	}
	
	public void Verify_Age_Limit_ErrorMessage()
	{
		try
		{
		if(Age_LimitErrorMsg.isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter the minimum Age Error Pop is Displayed");
		}
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Enter the minimum Age Error Pop is not Displayed");
			
		}
	}
	
	public void Click_Daily_SetOverTime()
	{
		Daily_Set_OverTimeRadioBtn.click();
	}
	
	public WebElement Daily_Set_OverTime()
	{
		return Daily_Set_OverTimeRadioBtn;
	}
	
	public void Click_Weekly_SetOverTime()
	{
		Weekly_Set_OverTimeRadioBtn.click();
	}
	
	public WebElement Weekly_Set_OverTime()
	{
		return Weekly_Set_OverTimeRadioBtn;
	}
	
	public void Verify_Valid_Hours_ErrorMessage()
	{
		try
		{
		if(Valid_HoursErrorMsg.isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter Valid Hours Error Pop is Displayed");
		}
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Enter Valid Hours Error Pop is not Displayed");
			
		}
	}
	
	public void Verify_Valid_Percentage_ErrorMessage()
	{
		try
		{
		if(Valid_PercentageErrorMsg.isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter Valid Percentage Error Pop is Displayed");
		}
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Enter Valid Percentage Error Pop is not Displayed");
			
		}
	}
	
	//span[contains(.,'Over Time 3')]/../..//mat-hint[contains(.,'Enter valid Hours')]
	//span[contains(.,'Over Time 3')]/../..//mat-hint[contains(.,'Enter valid percentage should be more than 100')]
	
	public void Enter_Hours_OverTime_One(String str) throws Exception
	{
		Thread.sleep(1000);
		Hours_OverTime_OneInputBx.clear();
		Thread.sleep(500);
		Hours_OverTime_OneInputBx.sendKeys(str);
		
	}

	public void Enter_Percentage_OverTime_One(String str) throws Exception
	{
		Thread.sleep(1000);
		Percentage_OverTime_OneInputBx.clear();
		Thread.sleep(500);
		Percentage_OverTime_OneInputBx.sendKeys(str);
		
	}
	
	public WebElement Hours_OverTime_OneInputBox()
	{
		return Hours_OverTime_OneInputBx;
	}
	
	
	public WebElement Percentage_OverTime_OneInputBox()
	{
		return Percentage_OverTime_OneInputBx;
	}
	
	public void Enter_OverTime_One(String str, String str2) throws Exception
	{
		Thread.sleep(1000);
		Hours_OverTime_OneInputBx.clear();
		Thread.sleep(500);
		Hours_OverTime_OneInputBx.sendKeys(str);
	
		Thread.sleep(1000);
		Percentage_OverTime_OneInputBx.clear();
		Thread.sleep(500);
		Percentage_OverTime_OneInputBx.sendKeys(str2);
		
	}
	
	public void Enter_OverTime_Two(String str,String str2) throws Exception
	{
		Thread.sleep(1000);
		Hours_OverTime_TwoInputBx.clear();
		Thread.sleep(500);
		Hours_OverTime_TwoInputBx.sendKeys(str);
	
		Thread.sleep(1000);
		Percentage_OverTime_TwoInputBx.clear();
		Thread.sleep(500);
		Percentage_OverTime_TwoInputBx.sendKeys(str2);
		
	}
	
	
	public void Enter_OverTime_Three(String str,String str2) throws Exception
	{
		Thread.sleep(1000);
		Hours_OverTime_ThreeInputBx.clear();
		Thread.sleep(500);
		Hours_OverTime_ThreeInputBx.sendKeys(str);
	
		Thread.sleep(1000);
		Percentage_OverTime_ThreeInputBx.clear();
		Thread.sleep(500);
		Percentage_OverTime_ThreeInputBx.sendKeys(str2);
		
	}
	
	
	
	
	
	
	//td/button[contains(@class,'mat-calendar-body-cell')]/div[@class='mat-calendar-body-cell-content mat-focus-indicator']

	
	public void Select_SameDay_Effective_Date() throws Exception
	{
		Thread.sleep(1000);
		Effective_DateInputBx.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//table[@class='mat-calendar-table']/tbody/tr/td/button[contains(@class,'mat-calendar-body-active')]")).click();
	}
	
	public void Select_Effective_Date() throws Exception
	{
		Thread.sleep(1000);
		Effective_DateInputBx.click();
		
		Thread.sleep(1000);
		NextMonth_Calender_EffectiveDateBtn.click();
		Thread.sleep(1000);
		NextMonth_Calender_EffectiveDateBtn.click();
		Thread.sleep(1000);
		
		Thread.sleep(1000);
		List<WebElement> rowList=driver.findElements(By.xpath("//table[@class='mat-calendar-table']/tbody/tr"));
		List<WebElement> colList=driver.findElements(By.xpath("//table[@class='mat-calendar-table']/tbody/tr[2]/td"));
		
	//List<WebElement> OptionList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int rowSize=rowList.size();
		
		
		int randomRow=ThreadLocalRandom.current().nextInt(2, rowSize-1);
		
		Thread.sleep(1000);

	int colSize=colList.size();
		
		
		int randomCol=ThreadLocalRandom.current().nextInt(1, colSize);
	
		driver.findElement(By.xpath("//table[@class='mat-calendar-table']/tbody/tr["+randomRow+"]/td["+randomCol+"]/button[contains(@class,'mat-calendar-body-cell')]")).click();
	}

	
	//table[@class='mat-calendar-table']/tbody/tr
	//table[@class='mat-calendar-table']/tbody/tr[5]/td
	
	public void Edit_OverTime()
	{
		 cmp=new Common_XPaths(driver, test);
		
		List<WebElement> overTimeList=driver.findElements(By.xpath("//data-grid/div/div/div/div/data-grid-row/div/div[5]/div/button"));
		
		
		
		driver.findElement(By.xpath("//data-grid/div/div/div["+overTimeList.size()+"]/div/data-grid-row/div/div[5]/div/button")).click();
		
		
		try
		{
			if(cmp.Alert_Popup.getText().equalsIgnoreCase("The field cannot be edited since it has passed the effective date"))
			{
				
				Thread.sleep(1000);
				cmp.Click_Okay_Button();
			}
		}
		catch(Exception g)
		{
	
		}
		
	}
	
	public void Verify_Effective_CannotBeEdit_ErrorMsg()
	{
		 cmp=new Common_XPaths(driver, test);

		try
		{
			if(cmp.Alert_Popup.getText().equalsIgnoreCase("The field cannot be edited since it has passed the effective date"))
			{
				test.log(LogStatus.PASS, "The field cannot be edited since it has passed the effective date is Displayed");
				
				Thread.sleep(1000);
				cmp.Click_Okay_Button();
			}
		}
		catch(Exception g)
		{
			test.log(LogStatus.FAIL, "The field cannot be edited since it has passed the effective date is not Displayed");
	
			//Click Cancel button
//			cmp.Click_CancelButton();
		}
	}
	
	@FindBy(xpath = "//label[contains(.,'Percentage')]/../../input")
	WebElement Percentage_InputBx;
	
	
	
	public void Enter_Enter_OverTime_Weekly(String Hours,String Percentage) throws Exception
	{
		Thread.sleep(1000);
		Hours_LimitInputBx.clear();
		Thread.sleep(500);
		Hours_LimitInputBx.sendKeys(Hours);
		
		Thread.sleep(1000);
		Percentage_InputBx.clear();
		Thread.sleep(500);
		Percentage_InputBx.sendKeys(Percentage);
		
	}
	
	
}
