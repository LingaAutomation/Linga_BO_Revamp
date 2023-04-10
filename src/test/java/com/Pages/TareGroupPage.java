package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class TareGroupPage {

	public WebDriver driver;
	public ExtentTest test;
	
	Common_XPaths cmp;
	
	public TareGroupPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'NEW TARE GROUP')]")
	WebElement New_TareGroupBtn;
	
	@FindBy(xpath = "//label[contains(.,'Name')]/../../input")
	WebElement Name_TareGroupInput;
	
	@FindBy(xpath = "//button[contains(.,'Add Weight')]")
	WebElement Add_WeightBtn;
	
	@FindBy(xpath = "//app-input-table/div/div[2]/div[1]/app-input/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Sequence_No_WeightsInput;
	
	@FindBy(xpath = "//app-input-table/div/div[2]/div[1]/app-input/div/div/div/button[1]")
	WebElement Sequence_No_Weights_Up;
	
	@FindBy(xpath = "//app-input-table/div/div[2]/div[1]/app-input/div/div/div/button[2]")
	WebElement Sequence_No_Weights_Down;
	
	@FindBy(xpath = "//app-input-table/div/div[2]/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Name_WeightsInput;
	
	@FindBy(xpath = "//app-input-table/div/div[2]/div[3]/app-selectbox/div/mat-form-field/div/div/div[3]/input")
	WebElement UnitOfMeasure_WeightsInput;
	
	@FindBy(xpath = "//app-input-table/div/div[2]/div[4]/app-input/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Weight_WeightsInput;
	
	@FindBy(xpath = "//select-option[contains(.,'kg')]")
	WebElement Select_Kg;
	
	@FindBy(xpath = "//select-option[contains(.,'oz')]")
	WebElement Select_Oz;
	
	@FindBy(xpath = "//select-option[contains(.,'lb')]")
	WebElement Select_Lb;
	
	@FindBy(xpath = "//select-option[contains(.,'gm')]")
	WebElement Select_Gm;
	
	
	public void Click_NewTareGroup()
	{
		New_TareGroupBtn.click();
	}
	
	public void Enter_TareGroupName(String str) throws Exception
	{
		Thread.sleep(500);
		Name_TareGroupInput.clear();
		Thread.sleep(500);
		Name_TareGroupInput.sendKeys(str);
	}
	
	public void Enable_Yes_Default() throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		Thread.sleep(500);
		if(cmp.YesToggleBtn.isSelected()) 
		{
			
		}
		else
		{
			Thread.sleep(500);

			cmp.YesToggleBtn.click();
		}
	}
	
	public void Enable_No_Default() throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		Thread.sleep(500);
		if(cmp.NoToggleBtn.isSelected())
		{
			
		}
		else
		{
			Thread.sleep(500);

			cmp.NoToggleBtn.click();
		}
	}
	
	public void Add_Weights_All_Values() throws Exception
	{
		Thread.sleep(1000);
		Add_WeightBtn.click();
		Thread.sleep(1000);

		Sequence_No_WeightsInput.clear();
		Thread.sleep(500);
	
		Sequence_No_WeightsInput.sendKeys("3");
		Thread.sleep(500);

		
		Sequence_No_Weights_Up.click();
		
		String UpText="4";
		
		String StrUp=Sequence_No_WeightsInput.getAttribute("value");
		
		if(UpText.equals(StrUp))
		{
			test.log(LogStatus.PASS, "Sequence Number Changed as Expected while Click Up");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sequence Number not Changed as Expected while Clicking Up");	
		}
		
		
	Sequence_No_Weights_Down.click();
		
		String DownText="2";
		
		String StrDown=Sequence_No_WeightsInput.getAttribute("value");
		
		if(DownText.equals(StrDown))
		{
			test.log(LogStatus.PASS, "Sequence Number Changed as Expected while Clicking Down");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sequence Number not Changed as Expected while Clicking Down");	
		}
		
		
		Name_WeightsInput.clear();
		Thread.sleep(1000);

		Name_WeightsInput.sendKeys("Weight");
		Thread.sleep(1000);

		UnitOfMeasure_WeightsInput.click();
		Thread.sleep(1000);

		Select_Kg.click();
		Thread.sleep(1000);

		Weight_WeightsInput.clear();
		Thread.sleep(1000);

		Weight_WeightsInput.sendKeys("2000");
		Thread.sleep(1000);

		
	}
	
	public void Click_AddWeightsButton()
	{
		Add_WeightBtn.click();
	}
	
	public void Delete_AddWeights() throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		List<WebElement> al=driver.findElements(By.xpath("//app-input-table/div/div/div/button"));
		
		for(int i=2;i<=al.size();i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//app-input-table/div/div[3]/div/button")).click();
			
			Thread.sleep(500);
			cmp.Click_DeleteButton();
			
		}
		
		
	}
	
	
}
