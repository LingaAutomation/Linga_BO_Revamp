package com.Pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.poi.ss.formula.ptg.AddPtg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class TaxesPage {
	public WebDriver driver;
	public ExtentTest test;
	Common_XPaths cmp;
	
	public TaxesPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'NEW TAX')]")
	WebElement New_TaxBtn;
	
	@FindBy(xpath = "//label[contains(.,'Code')]/../../input")
	WebElement TaxCode_InputBox;
	
	@FindBy(xpath = "//label[contains(.,'Percentage')]/../../input")
	WebElement Percentage_InputBox;
	
	@FindBy(xpath = "//label[contains(.,'Amount')]/../../input")
	WebElement Amount_InputBox;
	
	@FindBy(xpath = "//mat-button-toggle[contains(.,'Amount')]")
	WebElement Amount_TaxTypeBtn;
	
	@FindBy(xpath = "//mat-button-toggle[contains(.,'Percentage')]")
	WebElement Percentage_TaxTypeBtn;
	
	@FindBy(xpath = "//div[contains(@class,'col radio-box-button')]/div/div[.='Item']")
	WebElement Item_TaxBtn;
	
	@FindBy(xpath = "//div[contains(@class,'col radio-box-button')]/div/div[.='Check']")
	WebElement Check_TaxBtn;
	
	@FindBy(xpath = "//div[contains(@class,'col radio-box-button')]/div/div[.='Tax On Item Tax']")
	WebElement TaxOnItem_TaxBtn;
	
	@FindBy(xpath = "//div[contains(@class,'col radio-box-button')]/div/div[.='Tax On Check Tax']")
	WebElement TaxOnCheck_TaxBtn;
	
	@FindBy(xpath = "//h5[contains(.,'Include In Daily Summary Report')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement IncludeDailySummaryReport_YesBtn;
	
	@FindBy(xpath = "//h5[contains(.,'Include In Daily Summary Report')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement IncludeDailySummaryReport_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Apply On Subtotal')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement ApplySubtotal_YesBtn;
	 
	@FindBy(xpath = "//span[contains(.,'Apply On Subtotal')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement ApplySubtotal_NoBtn;
	 
	@FindBy(xpath = "//span[contains(.,'Inclusive')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Inclusive_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Inclusive')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Inclusive_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Quantity Based')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement QuantityBased_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Quantity Based')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement QuantityBased_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Default Tax')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement DefaultTax_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Default Tax')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement DefaultTax_NoBtn;
	
	@FindBy(xpath = "//div[@class='editable-data-grid']/div/div[1]/app-input/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Quantity_QuantityBasedInputBox;
	
	@FindBy(xpath = "//div[@class='editable-data-grid']/div/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Percentage_QuantityBasedInputBox;
	
	@FindBy(xpath = "//button[contains(.,'Add Percentage')]")
	WebElement Add_PercentageBtn;
	
	@FindBy(xpath = "//span[contains(.,'Tax Per ServiceType')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement TaxPerServiceType_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Tax Per ServiceType')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement TaxPerServiceType_YesBtn;
	
	@FindBy(xpath = "//p[contains(.,'Would you like to set the Percentage/Value for all the services?')]")
	WebElement AllServiceCofirmation;
	
	@FindBy(xpath = "//button[contains(.,'Yes,Confirm')]")
	WebElement Yes_CofirmBtn;
	
	
	//Deleting Quantity based
	//div/app-input-table/div[@class='editable-data-grid']/div[3]/div[3]/button
	
	public void Click_NewTaxButton()
	{
		New_TaxBtn.click();
	}
	
	public void Enter_TaxName(String str) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(500);
		cmp.EnterName(str);
	}
	
	public void Enter_TaxCode(String str) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(500);
		TaxCode_InputBox.clear();
		Thread.sleep(500);
		TaxCode_InputBox.sendKeys(str);
	}
	
	
	public void Enter_Percentage(String str) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(500);
		Percentage_InputBox.clear();
		Thread.sleep(500);
		Percentage_InputBox.sendKeys(str);
	}
	
	
	public void Select_TaxPerServiceType_Tax() throws Exception
	{
		if(TaxPerServiceType_YesBtn.isSelected())
		{
			
		}
		else
		{
			TaxPerServiceType_YesBtn.click();
			
			Thread.sleep(2000);
			if(AllServiceCofirmation.isDisplayed())
			{
				Yes_CofirmBtn.click();
			}
			
		}
	}
	
	public void DeSelect_TaxPerServiceType_Tax()
	{
//		if(TaxPerServiceType_YesBtn.isSelected())
//		{
			TaxPerServiceType_NoBtn.click();
//		}
//		else
//		{
//			
//		}
	}
	
	public void Select_TaxType_Amount()
	{
		if(Amount_TaxTypeBtn.isSelected())
		{
			
		}
		else
		{
			Amount_TaxTypeBtn.click();
		}
		
	}
	
	public void Select_TaxType_Percentage()
	{
		if(Percentage_TaxTypeBtn.isSelected())
		{
			
		}
		else
		{
			Percentage_TaxTypeBtn.click();
		}
		
	}
	
	public void Select_InclusiveTax()
	{
		if(Inclusive_YesBtn.isSelected())
		{
			
		}
		else
		{
			Inclusive_YesBtn.click();
		}
	}
	
	public void DeSelect_InclusiveTax()
	{
		if(Inclusive_YesBtn.isSelected())
		{
			Inclusive_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public void Select_QuantityBasedTax() throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		Thread.sleep(1000);
		if(QuantityBased_YesBtn.isSelected())
		{
			
		}
		else
		{
			QuantityBased_YesBtn.click();
		}
		
		Thread.sleep(500);
		Quantity_QuantityBasedInputBox.clear();
		Thread.sleep(500);
		Quantity_QuantityBasedInputBox.sendKeys("10");
		
		Thread.sleep(500);
		Percentage_QuantityBasedInputBox.clear();
		Thread.sleep(500);
		Percentage_QuantityBasedInputBox.sendKeys("2000");
		
	
		Thread.sleep(500);
		for(int i=1;i<=3;i++)
		{
		Add_PercentageBtn.click();
		}
		
		Thread.sleep(1000);
		List<WebElement> listDe=driver.findElements(By.xpath("//div/app-input-table/div[@class='editable-data-grid']/div/div[3]/button"));
		for(int i=1;i<=2;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div/app-input-table/div[@class='editable-data-grid']/div[3]/div[3]/button")).click();
		
			Thread.sleep(1000);
			cmp.Click_DeleteButton();
		}
		
		Thread.sleep(1000);
		cmp.Click_Save_and_PublishButton();
		
		Thread.sleep(2000);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Quantity should be greater than 10"))
		{
			test.log(LogStatus.PASS, "Quantity should be Enter on empty input box Warning pop up displayed while clicking Save button");
		}
		else
		{
			test.log(LogStatus.PASS, "Quantity should be Enter on empty input box Warning pop up not displayed while clicking Save button");
		}
		
		driver.findElement(By.xpath("//div/app-input-table/div[@class='editable-data-grid']/div[3]/div[3]/button")).click();

		Thread.sleep(1000);
		cmp.Click_DeleteButton();

	}
	
	public void DeSelect_QuantityBasedTax() throws Exception
	{
		
		Thread.sleep(1000);
		if(QuantityBased_YesBtn.isSelected())
		{
			QuantityBased_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public void Select_DefaultTax()
	{
		if(DefaultTax_YesBtn.isSelected())
		{
			
		}
		else
		{
			DefaultTax_YesBtn.click();
		}
	}
	
	
	public void DeSelect_DefaultTax()
	{
		if(DefaultTax_YesBtn.isSelected())
		{
			DefaultTax_NoBtn.click();
		}
		else
		{
		
		}
	}
	
	
	public void Enter_ItemTax_Percentage(String str) throws Exception
	{
		Enter_TaxName(str);
		
		Enter_TaxCode("1234");
		
		Thread.sleep(500);
		Select_TaxType_Percentage();
		
		Thread.sleep(500);
		if(IncludeDailySummaryReport_YesBtn.isSelected())
		{
			IncludeDailySummaryReport_NoBtn.click();
		}
		else
		{
			
		}
		
		Thread.sleep(1000);
		Percentage_InputBox.clear();
		Thread.sleep(500);
		Percentage_InputBox.sendKeys("1000");
		
		Thread.sleep(500);
		Item_TaxBtn.click();
		
	}
	
	
	public void Enter_ItemTax_Amount(String str) throws Exception
	{
		Thread.sleep(1000);
		Enter_TaxName(str);
		
		Thread.sleep(1000);
		Enter_TaxCode("1234");
		
		Thread.sleep(1000);
		Select_TaxType_Amount();
		
		Thread.sleep(1000);
		if(IncludeDailySummaryReport_YesBtn.isSelected())
		{
			Thread.sleep(1000);
			IncludeDailySummaryReport_NoBtn.click();
		}
		else
		{
			
		}
		
		Thread.sleep(1000);
		Amount_InputBox.clear();
		Thread.sleep(1000);
		Amount_InputBox.sendKeys("100");
		
		Thread.sleep(1000);
		Item_TaxBtn.click();
		
	}
	
	public void Click_Yes_IncludeDailySummaryReport() throws Exception
	{
		Thread.sleep(500);
		if(IncludeDailySummaryReport_YesBtn.isSelected())
		{
		}
		else
		{
			IncludeDailySummaryReport_YesBtn.click();
		}
	}
	
	public void Click_No_IncludeDailySummaryReport() throws Exception
	{
		Thread.sleep(500);
		if(IncludeDailySummaryReport_YesBtn.isSelected())
		{
			IncludeDailySummaryReport_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	
	public void Click_Yes_ApplyOnSubtotal() throws Exception
	{
		Thread.sleep(500);
		if(ApplySubtotal_YesBtn.isSelected())
		{
		}
		else
		{
			ApplySubtotal_YesBtn.click();
		}
	}
	
	public void Click_No_ApplyOnSubtotal() throws Exception
	{
		Thread.sleep(500);
		if(ApplySubtotal_YesBtn.isSelected())
		{
			ApplySubtotal_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public void Enter_AmountBox(String str) throws Exception
	{
		Thread.sleep(500);
		Amount_InputBox.clear();
		Thread.sleep(500);
		Amount_InputBox.sendKeys(str);
	}
	
	@FindBy(xpath = "//label[contains(.,'Evertec Tax Type')]/../../input")
	WebElement Evertec_TaxType_InputBx;
	
	public void Select_Evertec_TaxType() throws Exception
	{
		Thread.sleep(1000);
		Evertec_TaxType_InputBx.click();
		
		Thread.sleep(500);
		driver.findElement(By.xpath("//select-option[contains(.,'None')]")).click();
	}
	
	public void Enter_CheckTax(String str) throws Exception
	{
		Enter_TaxName(str);
		
		Select_TaxType_Percentage();
		
		Enter_TaxCode("2222");
		
		Click_No_IncludeDailySummaryReport();
		
		Enter_Percentage("10000");
		
		Click_CheckTax();
		
		Thread.sleep(500);
		Amount_InputBox.clear();
		Thread.sleep(500);
		Amount_InputBox.sendKeys("200000");
		
		Thread.sleep(1000);
		ApplySubtotal_YesBtn.click();
		
		
		Select_Evertec_TaxType();
		Thread.sleep(1000);
		
		
	}
	
	public void Enter_TaxOnItemTax(String str) throws Exception
	{
		Enter_TaxName(str);
		
		Select_TaxType_Percentage();
		
		Enter_TaxCode("2222");
		
		Click_No_IncludeDailySummaryReport();
		
		Enter_Percentage("1000");
		
		Click_TaxOnItemTax();
		
		Thread.sleep(500);
		if(driver.findElement(By.xpath("//mat-chip-list[@class='mat-chip-list']/div/mat-chip")).isDisplayed()) 
		{
			List<WebElement> ItemList=driver.findElements(By.xpath("//mat-chip-list[@class='mat-chip-list']/div/mat-chip"));
			
			
			int ItemTaxSize=ItemList.size();
			
			
			int randomItemTax=ThreadLocalRandom.current().nextInt(1, ItemTaxSize);
			
			if(ShowAll_TaxOn_ItemTaxBtn.isDisplayed())
			{
				Thread.sleep(1000);
				ShowAll_TaxOn_ItemTaxBtn.click();
				Thread.sleep(1000);

			driver.findElement(By.xpath("//mat-chip-list[@class='mat-chip-list']/div/mat-chip["+randomItemTax+"]")).click();
			}
			else
			{
				Thread.sleep(1000);

				driver.findElement(By.xpath("//mat-chip-list[@class='mat-chip-list']/div/mat-chip["+randomItemTax+"]")).click();
		
			}
		}
		else
		{
			
		}
	}
	
	@FindBy(xpath = "//p[contains(.,'Apply For Item Taxes')]/../../..//button[contains(.,'Show All')]")
	WebElement ShowAll_TaxOn_ItemTaxBtn;
	
	
	@FindBy(xpath = "//p[contains(.,'Apply For Check Taxes')]/../../..//button[contains(.,'Show All')]")
	WebElement ShowAll_TaxOn_CheckTaxBtn;
	
	public void Enter_TaxOnCheckTax(String str) throws Exception
	{
		Enter_TaxName(str);
		
		Select_TaxType_Percentage();
		
		Enter_TaxCode("2222");
		
		Click_No_IncludeDailySummaryReport();
		
		Enter_Percentage("1000");
		
		Click_TaxOnCheckTax();
		
		Thread.sleep(500);
		if(driver.findElement(By.xpath("//mat-chip-list[@class='mat-chip-list']/div/mat-chip")).isDisplayed()) 
		{
			List<WebElement> ItemList=driver.findElements(By.xpath("//mat-chip-list[@class='mat-chip-list']/div/mat-chip"));
			
			
			int ItemTaxSize=ItemList.size();
			
			
			int randomItemTax=ThreadLocalRandom.current().nextInt(1, ItemTaxSize);
			
			if(ShowAll_TaxOn_CheckTaxBtn.isDisplayed())
			{
				Thread.sleep(1000);
				ShowAll_TaxOn_CheckTaxBtn.click();
				Thread.sleep(1000);

			driver.findElement(By.xpath("//mat-chip-list[@class='mat-chip-list']/div/mat-chip["+randomItemTax+"]")).click();
			}
			else
			{
				Thread.sleep(1000);

				driver.findElement(By.xpath("//mat-chip-list[@class='mat-chip-list']/div/mat-chip["+randomItemTax+"]")).click();
		
			}
		}
		else
		{
			
		}
	}
	
	public void Tax_Per_Service_Type(String str) throws Exception
	{
		
		List<WebElement> SerTypes=driver.findElements(By.xpath("//div[contains(@class,'p-relative inputs-rows')]/div/app-input/div/div/mat-form-field/div/div/div[4]/input"));
		
		for(int i=1;i<=SerTypes.size();i++)
		{
			double conv=Double.parseDouble(str);
			conv=conv+1;
			String scr=String.valueOf(conv);
			
			Thread.sleep(500);
			driver.findElement(By.xpath("//div[contains(@class,'p-relative inputs-rows')]/div["+i+"]/app-input/div/div/mat-form-field/div/div/div[4]/input")).clear();
			Thread.sleep(500);
			
			driver.findElement(By.xpath("//div[contains(@class,'p-relative inputs-rows')]/div["+i+"]/app-input/div/div/mat-form-field/div/div/div[4]/input")).sendKeys(scr);
		}
	}
	
	public void Click_ItemTax()
	{
		Item_TaxBtn.click();
	}
	
	public void Click_CheckTax()
	{
		Check_TaxBtn.click();
	}
	
	public void Click_TaxOnItemTax()
	{
		TaxOnItem_TaxBtn.click();
	}
	
	public void Click_TaxOnCheckTax()
	{
		TaxOnCheck_TaxBtn.click();
	}
	
}
