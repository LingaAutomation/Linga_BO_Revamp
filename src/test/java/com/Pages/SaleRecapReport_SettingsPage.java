package com.Pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;

import Utility.Utility;

public class SaleRecapReport_SettingsPage extends BasePage
{

//	public SelfHealingDriver driver;
//	public ExtentTest test;
	Common_XPaths cmp;
	Utility ut=new Utility();
	
	public SaleRecapReport_SettingsPage(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		super(driver,test);
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//span[contains(.,'Guest/Checks')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Guest_Checks_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Guest/Checks')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement Guest_Checks_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Cover')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Cover_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Cover')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement Cover_NoBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][.='Category']")
	WebElement Category_LevelTypeBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][contains(.,'Sub-Category')]")
	WebElement SubCategory_LevelTypeBtn;
	
	@FindBy(xpath = "//div[@class='radio-box'][contains(.,'Menu Items')]")
	WebElement MenuItems_LevelTypeBtn;
	
	@FindBy(xpath = "//label[.='Category *']/../../div/div/input")
	WebElement Category_LevelTypeInputBx;
	
	//app-auto-complete[@name='Category']//input
	@FindBy(xpath = "//label[.='Sub Category *']/../../div/div/input")
	WebElement SubCategory_LevelTypeInputBx;
	
	@FindBy(xpath = "//label[.='Menu Item *']/../../div/div/input")
	WebElement MenuItems_LevelTypeInputBx;
	
	@FindBy(xpath = "//span[contains(.,'Grand Sales')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Grand_Sales_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Grand Sales')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement Grand_Sales_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Gross Receipt')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Gross_Receipt_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Gross Receipt')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement Gross_Receipt_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Gross Void')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Gross_Void_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Gross Void')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement Gross_Void_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Net Void')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Net_Void_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Net Void')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement Net_Void_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'CC Split Up')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement CC_SplitUp_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'CC Split Up')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement CC_SplitUp_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Other Payments Split Up')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement OtherPayments_SplitUp_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Other Payments Split Up')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement OtherPayments_SplitUp_NoBtn;
	
	@FindBy(xpath = "//app-radio-box-button[@name='selectedBusinesBox']/div/div/div/div[contains(.,'System Defined')]")
	WebElement SystemDefined_PaymentNameBtn;
	
	@FindBy(xpath = "//app-radio-box-button[@name='selectedBusinesBox']/div/div/div/div[contains(.,'User Defined')]")
	WebElement UserDefined_PaymentNameBtn;
	
	@FindBy(xpath = "//span[contains(.,'Tax Split Up')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Tax_SplitUp_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Tax Split Up')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement Tax_SplitUp_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Tax Exempt')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Tax_Exempt_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Tax Exempt')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement Tax_Exempt_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Tax with Net sales')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Taxwith_NetSales_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Tax with Net sales')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement Taxwith_NetSales_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Opening Balance')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement OpeningBalance_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Opening Balance')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement OpeningBalance_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Paid In/Out')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement PaidIn_Out_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Paid In/Out')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement PaidIn_Out_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Cash Drop')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Cash_Drop_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Cash Drop')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement Cash_Drop_NoBtn;
	
	@FindBy(xpath = "//div[@id='summary']//span[contains(.,'Cash Expected')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Cash_Expected_Summary_YesBtn;
	
	@FindBy(xpath = "//div[@id='summary']//span[contains(.,'Cash Expected')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement Cash_Expected_Summary_NoBtn;
	
	@FindBy(xpath = "//div[@id='summary']//span[contains(.,'Over / Shortage')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Over_Shortage_Summary_YesBtn;
	
	@FindBy(xpath = "//div[@id='summary']//span[contains(.,'Over / Shortage')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement Over_Shortage_Summary_NoBtn;
	
	@FindBy(xpath = "//div[@id='formulaDefinition']//span[contains(.,'Cash Expected')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Cash_Expected_FormulaDef_YesBtn;
	
	@FindBy(xpath = "//div[@id='formulaDefinition']//span[contains(.,'Cash Expected')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement Cash_Expected_FormulaDef_NoBtn;
	
	@FindBy(xpath = "//div[@id='formulaDefinition']//span[contains(.,'Overage/Shortage')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Over_Shortage_Summary_FormulaDef_YesBtn;
	
	@FindBy(xpath = "//div[@id='formulaDefinition']//span[contains(.,'Overage/Shortage')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement Over_Shortage_Summary_FormulaDef_NoBtn;
	
	@FindBy(xpath = "//div[@id='formulaDefinition']/div[2]/div/div[2]/app-auto-complete/div/mat-form-field/div/div/div[3]/div/div/input")
	WebElement Cash_Expected_AddInputBox;
	
	public WebElement Cash_Expected_AddInputBox()
	{
		return Cash_Expected_AddInputBox;
	}
	
	@FindBy(xpath = "//div[@id='formulaDefinition']/div[2]/div/div[3]/app-auto-complete/div/mat-form-field/div/div/div[3]/div/div/input")
	WebElement Cash_Expected_SubtractInputBox;
		
	@FindBy(xpath = "//div[@id='formulaDefinition']/div[3]/div/div[2]/app-auto-complete/div/mat-form-field/div/div/div[3]/div/div/input")
	WebElement Overage_Shortage_AddInputBox;
	
	public WebElement Overage_Shortage_AddInputBox()
	{
		return Overage_Shortage_AddInputBox;
	}
	
	@FindBy(xpath = "//div[@id='formulaDefinition']/div[3]/div/div[3]/app-auto-complete/div/mat-form-field/div/div/div[3]/div/div/input")
	WebElement Overage_Shortage_SubtractInputBox;
	
	@FindBy(xpath = "//span[contains(.,'Department Summary')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Department_Summary_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Department Summary')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement Department_Summary_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Category Summary')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Category_Summary_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Category Summary')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement Category_Summary_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Hourly Summary')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Hourly_Summary_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Hourly Summary')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement Hourly_Summary_NoBtn;
	
	@FindBy(xpath = "//span[contains(.,'Include Credits in Daily Summary Report')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement IncludeCredits_in_DailySummaryReport_YesBtn;
	
	@FindBy(xpath = "//span[contains(.,'Include Credits in Daily Summary Report')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement IncludeCredits_in_DailySummaryReport_NoBtn;
	
	@FindBy(xpath = "//button[.='UPDATE']")
	WebElement UpdateBtnIn_SaleRecapSettings;
	
	public void Click_UpdateButtonSettings()
	{
		UpdateBtnIn_SaleRecapSettings.click();
	}
	
	public WebElement UpdateBtnIn_SaleRecapSettings()
	{
		return UpdateBtnIn_SaleRecapSettings;
	}
	
	public void Enable_GuestChecks()
	{
		if(Guest_Checks_YesBtn.isSelected())
		{
			
		}
		else
		{
			Guest_Checks_YesBtn.click();
		}
	}
	
	
	public void Disable_GuestChecks()
	{
		if(Guest_Checks_YesBtn.isEnabled())
		{
			Guest_Checks_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement Guest_Checks_YesBtn()
	{
		return Guest_Checks_YesBtn;
	}
	
	public void Enable_Cover()
	{
		if(Cover_YesBtn.isSelected())
		{
			
		}
		else
		{
			Cover_YesBtn.click();
		}
	}
	
	
	public void Disable_Cover()
	{
		if(Cover_YesBtn.isEnabled())
		{
			Cover_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement Cover_YesBtn()
	{
		return Cover_YesBtn;
	}
	
	public void Click_Category_LevelType()
	{
		Category_LevelTypeBtn.click();
	}
	
	public WebElement Category_LevelType()
	{
		return Category_LevelTypeBtn;
	}
	
	public void Click_SubCategory_LevelType()
	{
		SubCategory_LevelTypeBtn.click();
	}
	
	public WebElement SubCategory_LevelType()
	{
		return SubCategory_LevelTypeBtn;
	}
	
	public void Click_MenuItems_LevelType()
	{
		MenuItems_LevelTypeBtn.click();
	}
	
	public WebElement MenuItems_LevelType()
	{
		return MenuItems_LevelTypeBtn;
	}
	
	
	public void Select_Category_LevelTypeItems() throws Exception
	{
		Thread.sleep(2000);
		Category_LevelTypeInputBx.click();
//		Actions ac=new Actions(driver);
//		ac.doubleClick(Category_LevelTypeInputBx).build().perform();
		
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).isEnabled())
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();
			
		}
		
		Thread.sleep(2000);
		for(int i=1;i<=3;i++)
		{
		Thread.sleep(1000);
		Category_LevelTypeInputBx.click();
//		Actions ac=new Actions(driver);
//		ac.doubleClick(Items_LevelType_InputBox).build().perform();
		
		Thread.sleep(1000);
	
	List<WebElement> PrinterList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		int PrinterSize=PrinterList.size();
		
		if(PrinterSize==0)
		{
			Category_LevelTypeInputBx.click();
			
			driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();


		}
		else if(PrinterSize==1)
		{
			driver.findElement(By.xpath("//div[@class='options with-height']//div/div["+PrinterSize+"]/select-option")).click();

		}
		else if(PrinterSize<=10)
		{
		int randomPrinter=ThreadLocalRandom.current().nextInt(2, PrinterSize);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomPrinter+"]")).click();
		}
		else
		{
			int randomPrinter=ThreadLocalRandom.current().nextInt(2, 10);
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomPrinter+"]")).click();
		
		}
		Thread.sleep(1000);
		
		Thread.sleep(1000);
		List<WebElement> PrinterList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		Thread.sleep(1000);
		if(PrinterList1.size()!=0)
		{
			driver.findElement(By.xpath("(//span[.='General'])[1]")).click();
			for(int j=1;j<=5;j++) 
			{
				Thread.sleep(1000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}
			Thread.sleep(1000);
			Category_LevelTypeInputBx.click();
		}
		}
	}
	
	public void Select_SubCategory_LevelTypeItems() throws Exception
	{
		Thread.sleep(2000);
		SubCategory_LevelTypeInputBx.click();
		
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).isEnabled())
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();
			
		}
		
		Thread.sleep(1000);
		for(int i=1;i<=3;i++)
		{
		Thread.sleep(2000);
		SubCategory_LevelTypeInputBx.click();
//		Actions ac=new Actions(driver);
//		ac.doubleClick(Items_LevelType_InputBox).build().perform();
		
		Thread.sleep(1000);
	
	List<WebElement> PrinterList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		int PrinterSize=PrinterList.size();
		
		if(PrinterSize==0)
		{
			SubCategory_LevelTypeInputBx.click();
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();


		}
		else if(PrinterSize==1)
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+PrinterSize+"]")).click();

		}
		else if(PrinterSize<=10)
		{
		int randomPrinter=ThreadLocalRandom.current().nextInt(2, PrinterSize);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomPrinter+"]")).click();
		}
		else
		{
			int randomPrinter=ThreadLocalRandom.current().nextInt(2, 10);
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomPrinter+"]")).click();
		
		}
		Thread.sleep(1000);
		List<WebElement> PrinterList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		Thread.sleep(1000);
		if(PrinterList1.size()!=0)
		{
			
			driver.findElement(By.xpath("(//span[.='General'])[1]")).click();
			for(int j=1;j<=5;j++) 
			{
				Thread.sleep(1000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}
			Thread.sleep(1000);
			SubCategory_LevelTypeInputBx.click();
		}
		}
	}
	
	public void Select_MenuItems_LevelTypeItems() throws Exception
	{
		Thread.sleep(2000);
		MenuItems_LevelTypeInputBx.click();
		
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).isEnabled())
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();
			
		}
		
		Thread.sleep(2000);
		for(int i=1;i<=3;i++)
		{
		Thread.sleep(2000);
		MenuItems_LevelTypeInputBx.click();
//		Actions ac=new Actions(driver);
//		ac.doubleClick(Items_LevelType_InputBox).build().perform();
		
		Thread.sleep(1000);
	
	List<WebElement> PrinterList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		int PrinterSize=PrinterList.size();
		
		if(PrinterSize==0)
		{
			MenuItems_LevelTypeInputBx.click();
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();


		}
		else if(PrinterSize==1)
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+PrinterSize+"]")).click();

		}
		else if(PrinterSize<=10)
		{
		int randomPrinter=ThreadLocalRandom.current().nextInt(2, PrinterSize);
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomPrinter+"]")).click();
		}
		else
		{
			int randomPrinter=ThreadLocalRandom.current().nextInt(2, 10);
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomPrinter+"]")).click();
		
		}
		Thread.sleep(1000);
		
		Thread.sleep(1000);
		List<WebElement> PrinterList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		Thread.sleep(1000);
		if(PrinterList1.size()!=0)
		{
			driver.findElement(By.xpath("(//span[.='General'])[1]")).click();
			for(int j=1;j<=5;j++) 
			{
				Thread.sleep(1000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
			}
			Thread.sleep(1000);
			MenuItems_LevelTypeInputBx.click();
		}
		}
	}
	
	public void SelectAll_LevelTypeItems()
	{
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();
	
	}
	
	
	public void Enable_Grand_Sales()
	{
		if(Grand_Sales_YesBtn.isSelected())
		{
			
		}
		else
		{
			Grand_Sales_YesBtn.click();
		}
	}
	
	
	public void Disable_Grand_Sales()
	{
		if(Grand_Sales_YesBtn.isEnabled())
		{
			Grand_Sales_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement Grand_Sales_YesBtn()
	{
		return Grand_Sales_YesBtn;
	}
	
	
	public void Enable_Gross_Receipt()
	{
		if(Gross_Receipt_YesBtn.isSelected())
		{
			
		}
		else
		{
			Gross_Receipt_YesBtn.click();
		}
	}
	
	
	public void Disable_Gross_Receipt()
	{
		if(Gross_Receipt_YesBtn.isEnabled())
		{
			Gross_Receipt_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement Gross_Receipt_YesBtn()
	{
		return Gross_Receipt_YesBtn;
	}
	
	public void Enable_Gross_Void()
	{
		if(Gross_Void_YesBtn.isSelected())
		{
			
		}
		else
		{
			Gross_Void_YesBtn.click();
		}
	}
	
	
	public void Disable_Gross_Void()
	{
		if(Gross_Void_YesBtn.isEnabled())
		{
			Gross_Void_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement Gross_Void_YesBtn()
	{
		return Gross_Void_YesBtn;
	}
	
	public void Enable_Net_Void()
	{
		if(Net_Void_YesBtn.isSelected())
		{
			
		}
		else
		{
			Net_Void_YesBtn.click();
		}
	}
	
	
	public void Disable_Net_Void()
	{
		if(Net_Void_YesBtn.isEnabled())
		{
			Net_Void_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement Net_Void_YesBtn()
	{
		return Net_Void_YesBtn;
	}
	
	public void Enable_CC_SplitUp()
	{
		if(CC_SplitUp_YesBtn.isSelected())
		{
			
		}
		else
		{
			CC_SplitUp_YesBtn.click();
		}
	}
	
	
	public void Disable_CC_SplitUp()
	{
		if(CC_SplitUp_YesBtn.isEnabled())
		{
			CC_SplitUp_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement CC_SplitUp_YesBtn()
	{
		return CC_SplitUp_YesBtn;
	}
	
	public void Enable_OtherPayments_SplitUp()
	{
		if(OtherPayments_SplitUp_YesBtn.isSelected())
		{
			
		}
		else
		{
			OtherPayments_SplitUp_YesBtn.click();
		}
	}
	
	
	public void Disable_OtherPayments_SplitUp()
	{
		if(OtherPayments_SplitUp_YesBtn.isEnabled())
		{
			OtherPayments_SplitUp_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement OtherPayments_SplitUp_YesBtn()
	{
		return OtherPayments_SplitUp_YesBtn;
	}
	
	public void Click_SystemDefined()
	{
		SystemDefined_PaymentNameBtn.click();
	}
	
	public WebElement SystemDefined_PaymentName()
	{
		return SystemDefined_PaymentNameBtn;
	}
	
	public void Click_UserDefined()
	{
		UserDefined_PaymentNameBtn.click();
	}
	
	public WebElement UserDefined_PaymentName()
	{
		return UserDefined_PaymentNameBtn;
	}
	
	
	public void Enable_Tax_SplitUp()
	{
		if(Tax_SplitUp_YesBtn.isSelected())
		{
			
		}
		else
		{
			Tax_SplitUp_YesBtn.click();
		}
	}
	
	
	public void Disable_Tax_SplitUp()
	{
		if(Tax_SplitUp_YesBtn.isEnabled())
		{
			Tax_SplitUp_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement Tax_SplitUp_YesBtn()
	{
		return Tax_SplitUp_YesBtn;
	}
	
	public void Enable_Tax_Exempt()
	{
		if(Tax_Exempt_YesBtn.isSelected())
		{
			
		}
		else
		{
			Tax_Exempt_YesBtn.click();
		}
	}
	
	
	public void Disable_Tax_Exempt()
	{
		if(Tax_Exempt_YesBtn.isEnabled())
		{
			Tax_Exempt_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement Tax_Exempt_YesBtn()
	{
		return Tax_Exempt_YesBtn;
	}
	
	public void Enable_Taxwith_NetSales()
	{
		if(Taxwith_NetSales_YesBtn.isSelected())
		{
			
		}
		else
		{
			Taxwith_NetSales_YesBtn.click();
		}
	}
	
	
	public void Disable_Taxwith_NetSales()
	{
		if(Taxwith_NetSales_YesBtn.isEnabled())
		{
			Taxwith_NetSales_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement Taxwith_NetSales_YesBtn()
	{
		return Taxwith_NetSales_YesBtn;
	}
	
	public void Enable_OpeningBalance()
	{
		if(OpeningBalance_YesBtn.isSelected())
		{
			
		}
		else
		{
			OpeningBalance_YesBtn.click();
		}
	}
	
	
	public void Disable_OpeningBalance()
	{
		if(OpeningBalance_YesBtn.isEnabled())
		{
			OpeningBalance_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement OpeningBalance_YesBtn()
	{
		return OpeningBalance_YesBtn;
	}
	
	
	public void Enable_PaidIn_Out()
	{
		if(PaidIn_Out_YesBtn.isSelected())
		{
			
		}
		else
		{
			PaidIn_Out_YesBtn.click();
		}
	}
	
	
	public void Disable_PaidIn_Out()
	{
		if(PaidIn_Out_YesBtn.isEnabled())
		{
			PaidIn_Out_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement PaidIn_Out_YesBtn()
	{
		return PaidIn_Out_YesBtn;
	}
	
	public void Enable_Cash_Drop()
	{
		if(Cash_Drop_YesBtn.isSelected())
		{
			
		}
		else
		{
			Cash_Drop_YesBtn.click();
		}
	}
	
	
	public void Disable_Cash_Drop()
	{
		if(Cash_Drop_YesBtn.isEnabled())
		{
			Cash_Drop_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement Cash_Drop_YesBtn()
	{
		return Cash_Drop_YesBtn;
	}
	
	public void Enable_Cash_Expected_Summary()
	{
		if(Cash_Expected_Summary_YesBtn.isSelected())
		{
			
		}
		else
		{
			Cash_Expected_Summary_YesBtn.click();
		}
	}
	
	
	public void Disable_Cash_Expected_Summary()
	{
		if(Cash_Expected_Summary_YesBtn.isEnabled())
		{
			Cash_Expected_Summary_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement Cash_Expected_Summary_YesBtn()
	{
		return Cash_Expected_Summary_YesBtn;
	}
	
	public void Enable_Over_Shortage_Summary()
	{
		if(Over_Shortage_Summary_YesBtn.isSelected())
		{
			
		}
		else
		{
			Over_Shortage_Summary_YesBtn.click();
		}
	}
	
	
	public void Disable_Over_Shortage_Summary()
	{
		if(Over_Shortage_Summary_YesBtn.isEnabled())
		{
			Over_Shortage_Summary_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement Over_Shortage_Summary_YesBtn()
	{
		return Over_Shortage_Summary_YesBtn;
	}
	
	public void Enable_Cash_Expected_FormulaDef()
	{
		if(Cash_Expected_FormulaDef_YesBtn.isSelected())
		{
			
		}
		else
		{
			Cash_Expected_FormulaDef_YesBtn.click();
		}
	}
	
	
	public void Disable_Cash_Expected_FormulaDef()
	{
		if(Cash_Expected_FormulaDef_YesBtn.isEnabled())
		{
			Cash_Expected_FormulaDef_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement Cash_Expected_FormulaDef_YesBtn()
	{
		return Cash_Expected_FormulaDef_YesBtn;
	}
	
	public void Add_CashExpected_FormulaDefintion() throws Exception
	{
		Thread.sleep(1000);
		Cash_Expected_AddInputBox.click();
		
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).isEnabled())
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();
			
		}
		Thread.sleep(1000);
		Cash_Expected_AddInputBox.click();

		for(int i=1;i<=3;i++)
		{
			Thread.sleep(1000);
		Cash_Expected_AddInputBox.click();
		
//		Thread.sleep(1000);
//		if(driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).isSelected())
//		{
//			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();
//			
//		}
			
			
	
		List<WebElement> PrinterList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
	
		int PrinterSize=PrinterList.size();
		
		if(PrinterSize==0)
		{
			Thread.sleep(1000);
			Cash_Expected_AddInputBox.click();
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();

			
		}
		else if(PrinterSize==1)
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+PrinterSize+"]")).click();

		}
		else if(PrinterSize<=6)
		{
		int randomPrinter=ThreadLocalRandom.current().nextInt(2, PrinterSize);
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomPrinter+"]")).click();
		}
		else
		{
			int randomPrinter=ThreadLocalRandom.current().nextInt(2, PrinterSize);
			Thread.sleep(500);
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomPrinter+"]")).click();
		
		}
		Thread.sleep(1000);
		
		List<WebElement> PrinterList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		if(PrinterList1.size()!=0)
		{
			Thread.sleep(1000);
			Cash_Expected_AddInputBox.click();
			
		}
		
		}
		
		
		Thread.sleep(1000);
		Cash_Expected_SubtractInputBox.click();
		

//		List<WebElement> PrinterList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
//		
//		for(int i=1;i<=PrinterList1.size();i++)
//		{
//		int PrinterSize=PrinterList1.size();
//		
//		
//		int randomPrinter=ThreadLocalRandom.current().nextInt(2, PrinterSize);
//		
		
//		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomPrinter+"]")).click();
//		}
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).isEnabled())
		{
			
		}
		else
		{
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();
		}
		
	}
	
	
	public void Enable_Over_Shortage_Summary_FormulaDef()
	{
		if(Over_Shortage_Summary_FormulaDef_YesBtn.isSelected())
		{
			
		}
		else
		{
			Over_Shortage_Summary_FormulaDef_YesBtn.click();
		}
	}
	
	
	public void Disable_Over_Shortage_Summary_FormulaDef()
	{
		if(Over_Shortage_Summary_FormulaDef_YesBtn.isEnabled())
		{
			Over_Shortage_Summary_FormulaDef_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement Over_Shortage_Summary_FormulaDef_YesBtn()
	{
		return Over_Shortage_Summary_FormulaDef_YesBtn;
	}
	
	public void Add_Over_Shortage_FormulaDefintion() throws Exception
	{
		
		Thread.sleep(1000);
		Overage_Shortage_AddInputBox.click();
		
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).isSelected())
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();
			
		}
		
		Overage_Shortage_AddInputBox.click();

		
		for(int i=1;i<=4;i++)
		{
			Thread.sleep(1000);
		Overage_Shortage_AddInputBox.click();
		
//		Thread.sleep(1000);
//		if(driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).isSelected())
//		{
//			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();
//			
//		}
			
			
	
		List<WebElement> PrinterList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
	
		int PrinterSize=PrinterList.size();
		
		if(PrinterSize==0)
		{
			Thread.sleep(1000);
			Overage_Shortage_AddInputBox.click();
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();

		}
		else if(PrinterSize==1)
		{
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+PrinterSize+"]")).click();

		}
		else if(PrinterSize<=6)
		{
		int randomPrinter=ThreadLocalRandom.current().nextInt(2, PrinterSize);
		Thread.sleep(500);
		
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomPrinter+"]")).click();
		}
		else
		{
			int randomPrinter=ThreadLocalRandom.current().nextInt(2, 6);
			Thread.sleep(500);
			
			driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomPrinter+"]")).click();
			
		}
		
		List<WebElement> PrinterList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
		Thread.sleep(1000);
		
		if(PrinterList1.size()!=0) 
		{
			Thread.sleep(1000);
			Overage_Shortage_AddInputBox.click();
		
		}
			
		}
		
		
		
		
		Thread.sleep(2000);
		Overage_Shortage_SubtractInputBox.click();
		

//		List<WebElement> PrinterList1=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
//		
//		for(int i=1;i<=PrinterList1.size();i++)
//		{
//		int PrinterSize=PrinterList1.size();
//		
//		
//		int randomPrinter=ThreadLocalRandom.current().nextInt(2, PrinterSize);
//		
		
//		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option["+randomPrinter+"]")).click();
//		}
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).isEnabled())
		{
			
		}
		else
		{
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();
		}
	}
	
	public void Enable_Department_Summary()
	{
		if(Department_Summary_YesBtn.isSelected())
		{
			
		}
		else
		{
			Department_Summary_YesBtn.click();
		}
	}
	
	
	public void Disable_Department_Summary()
	{
		if(Department_Summary_YesBtn.isEnabled())
		{
			Department_Summary_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement Department_Summary_YesBtn()
	{
		return Department_Summary_YesBtn;
	}
	
	public void Enable_Category_Summary()
	{
		if(Category_Summary_YesBtn.isSelected())
		{
			
		}
		else
		{
			Category_Summary_YesBtn.click();
		}
	}
	
	
	public void Disable_Category_Summary()
	{
		if(Category_Summary_YesBtn.isEnabled())
		{
			Category_Summary_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement Category_Summary_YesBtn()
	{
		return Category_Summary_YesBtn;
	}
	
	
	public void Enable_Hourly_Summary()
	{
		if(Hourly_Summary_YesBtn.isSelected())
		{
			
		}
		else
		{
			Hourly_Summary_YesBtn.click();
		}
	}
	
	
	public void Disable_Hourly_Summary()
	{
		if(Hourly_Summary_YesBtn.isEnabled())
		{
			Hourly_Summary_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement Hourly_Summary_YesBtn()
	{
		return Hourly_Summary_YesBtn;
	}
	
	public void Enable_IncludeCredits_in_DailySummaryReport()
	{
		if(IncludeCredits_in_DailySummaryReport_YesBtn.isSelected())
		{
			
		}
		else
		{
			IncludeCredits_in_DailySummaryReport_YesBtn.click();
		}
	}
	
	
	public void Disable_IncludeCredits_in_DailySummaryReport()
	{
		if(IncludeCredits_in_DailySummaryReport_YesBtn.isEnabled())
		{
			IncludeCredits_in_DailySummaryReport_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public WebElement IncludeCredits_in_DailySummaryReport_YesBtn()
	{
		return IncludeCredits_in_DailySummaryReport_YesBtn;
	}
}
