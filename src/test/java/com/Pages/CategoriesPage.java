package com.Pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class CategoriesPage {

	public WebDriver driver;
	public ExtentTest test;
	Utility ut=new Utility();
	Common_XPaths cmp;
	WebDriverWait wait;
	TaxesPage tx;
	public CategoriesPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(.,'NEW CATEGORY')]")
	WebElement New_CategoryBtn;
	
	@FindBy(xpath = "//label[contains(.,'Department')]/../../input")
	WebElement DepartmentDropBtn;
	
	@FindBy(xpath = "//label[contains(.,'Coursing')]/../../input")
	WebElement CoursingDropBtn;
	
	@FindBy(xpath = "//label[contains(.,'Serving Size Level')]/../../div/div/input")
	WebElement ServingSizeLevelDropBtn;
	
	@FindBy(xpath = "//label[contains(.,'Tare Group')]/../../input")
	WebElement TareGroupDropBtn;
	
	@FindBy(xpath = "//button[contains(.,'New Tax')]")
	WebElement New_TaxBtn;
	
	@FindBy(xpath = "//h3[contains(.,'New Tax')]/../../..//label[contains(.,'Name')]/../../input")
	WebElement New_TaxNameInput;
	
	@FindBy(xpath = "//label[contains(.,'Item Service Charge')]/../../input")
	WebElement ItemServiceChargeDropBtn;
	
	@FindBy(xpath = "//app-toggle[contains(.,'Hide In POS')]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement HideinPOS_YesBtn;
	//span[contains(.,'Hide in POS')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]
	
	@FindBy(xpath = "//app-toggle[contains(.,'Hide In POS')]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement HideinPOS_NoBtn;
	//span[contains(.,'Hide in POS')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]
	
	@FindBy(xpath = "//app-toggle[contains(.,'Hide in Online Order')]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement HideinOnlineOrder_YesBtn;
	//span[contains(.,'Hide in Online Order')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]
		
	@FindBy(xpath = "//app-toggle[contains(.,'Hide in Online Order')]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement HideinOnlineOrder_NoBtn;
	//span[contains(.,'Hide in Online Order')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]
	
	@FindBy(xpath = "//app-toggle[contains(.,'Hide Menu Item In Kiosk')]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement HideinKiosk_YesBtn;
	//span[contains(.,'Hide in Kiosk')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]
		
	@FindBy(xpath = "//app-toggle[contains(.,'Hide Menu Item In Kiosk')]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement HideinKiosk_NoBtn;
	//span[contains(.,'Hide in Kiosk')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[contains(.,'No')]
	
	@FindBy(xpath = "//app-toggle[contains(.,'Conversational')]//mat-button-toggle-group/mat-button-toggle[contains(.,'Yes')]")
	WebElement Conversational_YesBtn;
		
	@FindBy(xpath = "//app-toggle[contains(.,'Conversational')]//mat-button-toggle-group/mat-button-toggle[contains(.,'No')]")
	WebElement Conversational_NoBtn;
	
	@FindBy(xpath="//div[contains(@id,'kitchen-printers')]//app-chip/div/mat-chip-list/div/mat-chip[1]")
	WebElement KitchenPrinter;
	
	@FindBy(xpath="//div[contains(@id,'label-printers')]//app-chip/div/mat-chip-list/div/mat-chip[1]")
	WebElement LabelPrinter;
	
	@FindBy(xpath="//div[contains(@id,'restrict-printers')]//app-chip/div/mat-chip-list/div/mat-chip[1]")
	WebElement RestrictPrinter;
	
	@FindBy(xpath="//div[contains(@id,'restrict-printers')]//app-chip/div/mat-chip-list/div/mat-chip[1]")
	WebElement Taxes;
	
	@FindBy(xpath="//span[contains(.,'Inherit Default Tax Settings')]/../../div[2]/app-switch/div/section/mat-slide-toggle")
	WebElement DefaultTaxSetting_ToggleBtn;
	
	public void Click_NewCategory()
	{
		New_CategoryBtn.click();
	}
	
	public void Enable_DefaultTaxSettings()
	{
		if(DefaultTaxSetting_ToggleBtn.isEnabled())
		{
			
		}
		else
		{
			DefaultTaxSetting_ToggleBtn.click();
		}
	}
	
	
	public void Select_HideinPOS()
	{
		if(HideinPOS_YesBtn.isSelected())
		{
			
		}
		else
		{
			HideinPOS_YesBtn.click();
		}
	}
	
	
	public void Select_HideinOnlineOrder()
	{
		if(HideinOnlineOrder_YesBtn.isSelected())
		{
			
		}
		else
		{
			HideinOnlineOrder_YesBtn.click();
		}
	}
	
	public void Select_HideinKiosk()
	{
		if(HideinKiosk_YesBtn.isSelected())
		{
			
		}
		else
		{
			HideinKiosk_YesBtn.click();
		}
	}
	
	public void Select_Conversational()
	{
		if(Conversational_YesBtn.isSelected())
		{
			
		}
		else
		{
			Conversational_YesBtn.click();
		}
	}
	
	public void DeSelect_HideinPOS()
	{
		if(HideinPOS_YesBtn.isSelected())
		{
			HideinPOS_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	
	public void DeSelect_HideinOnlineOrder()
	{
		if(HideinOnlineOrder_YesBtn.isSelected())
		{
			HideinOnlineOrder_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public void DeSelect_HideinKiosk()
	{
		if(HideinKiosk_YesBtn.isSelected())
		{
			HideinKiosk_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public void DeSelect_Conversational()
	{
		if(Conversational_YesBtn.isSelected())
		{
			Conversational_NoBtn.click();
		}
		else
		{
			
		}
	}
	
	public void Select_KitchenPrinter() throws Exception
	{
//		KitchenPrinter.click();
		Thread.sleep(1000);
List<WebElement> courseList=driver.findElements(By.xpath("//div[contains(@id,'kitchen-printers')]//app-chip/div/mat-chip-list/div/mat-chip"));
		
		int courseSize=courseList.size();
		
		
		int randomCoursing=ThreadLocalRandom.current().nextInt(1, courseSize);
		
		if(courseSize>=1)
		{
		try
		{
		if(ShowAll_Select_KitchenPrintersBtn.isDisplayed())
		{
		Thread.sleep(1000);
		ShowAll_Select_KitchenPrintersBtn.click();
		}
		}
		catch(Exception l) {}
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@id,'kitchen-printers')]//app-chip/div/mat-chip-list/div/mat-chip["+randomCoursing+"]")).click();
		}
		else
		{
			test.log(LogStatus.INFO, "Kitchen Printers Not available");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	public void Select_LabelPrinter() throws Exception
	{
//		LabelPrinter.click();
		
		Thread.sleep(1000);
	List<WebElement> courseList=driver.findElements(By.xpath("//div[contains(@id,'label-printers')]//app-chip/div/mat-chip-list/div/mat-chip"));
		
		int courseSize=courseList.size();
		
		
		int randomCoursing=ThreadLocalRandom.current().nextInt(1, courseSize);
		
		if(courseSize>=1)
		{
		try
		{
		if(ShowAll_Select_LabelPrintersBtn.isDisplayed())
		{
			Thread.sleep(1000);
			ShowAll_Select_LabelPrintersBtn.click();
		}
		}
		catch(Exception l) {}
			
			Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@id,'label-printers')]//app-chip/div/mat-chip-list/div/mat-chip["+randomCoursing+"]")).click();
		}
		else
		{
			test.log(LogStatus.INFO, "Label Printers Not available");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@FindBy(xpath = "//h5[contains(.,'Tax')]/../../..//button[contains(.,'Show All')]")
	WebElement ShowAll_Select_TaxBtn;
	
	@FindBy(xpath = "//h5[contains(.,'Kitchen Printers')]/../../..//button[contains(.,'Show All')]")
	WebElement ShowAll_Select_KitchenPrintersBtn;
	
	@FindBy(xpath = "//h5[contains(.,'Label Printers')]/../../..//button[contains(.,'Show All')]")
	WebElement ShowAll_Select_LabelPrintersBtn;
	
	@FindBy(xpath = "//h5[contains(.,'Restrict Printers')]/../../..//button[contains(.,'Show All')]")
	WebElement ShowAll_Select_RestrictPrintersBtn;
	
	
	public void Select_Taxes() throws Exception
	{
//		Taxes.click();
		
		Thread.sleep(1000);
		List<WebElement> courseList=driver.findElements(By.xpath("//div[contains(@id,'tax')]//app-chip/div/mat-chip-list/div/mat-chip"));
		
		int courseSize=courseList.size();
		
		
		int randomCoursing=ThreadLocalRandom.current().nextInt(1, courseSize);
		
		if(courseSize>=1)
		{
		try
		{
		Thread.sleep(1000);
		if(ShowAll_Select_TaxBtn.isDisplayed())
		{
			Thread.sleep(1000);
			ShowAll_Select_TaxBtn.click();
		}
		}
		catch(Exception l) {}
		
		
			Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@id,'tax')]//app-chip/div/mat-chip-list/div/mat-chip["+randomCoursing+"]")).click();
		
	}
	else
	{
		test.log(LogStatus.INFO, "Taxes Not available");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
	}
	}
	
	public void Select_RestrictPrinter() throws Exception
	{
//		RestrictPrinter.click();
		
	List<WebElement> courseList=driver.findElements(By.xpath("//div[contains(@id,'restrict-printers')]//app-chip/div/mat-chip-list/div/mat-chip"));
		
		int courseSize=courseList.size();
		
		
		int randomCoursing=ThreadLocalRandom.current().nextInt(1, courseSize);
		
		if(courseSize>=1)
		{
		try
		{
		if(ShowAll_Select_RestrictPrintersBtn.isDisplayed())
		{
			Thread.sleep(1000);
			ShowAll_Select_RestrictPrintersBtn.click();
		}
		}
		catch(Exception p) {}
		
			Thread.sleep(1000);
		driver.findElement(By.xpath("//div[contains(@id,'restrict-printers')]//app-chip/div/mat-chip-list/div/mat-chip["+randomCoursing+"]")).click();
		}
		else
		{
			test.log(LogStatus.INFO, "Restrict Printers Not available");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	public void Disable_DefaultTaxSettings()
	{
		if(DefaultTaxSetting_ToggleBtn.isSelected())
		{
			DefaultTaxSetting_ToggleBtn.click();	
		}
		else
		{
			
		}
	}
	
	public void Select_Department() throws Exception
	{
		Thread.sleep(1000);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(DepartmentDropBtn);
		Thread.sleep(1000);
		wait=new WebDriverWait(driver, Duration.ofSeconds(120));
		
		cmp.Click_DropDown_withSearch(DepartmentDropBtn, "Department selected");
		
//		DepartmentDropBtn.click();
//		wait.until(ExpectedConditions.elementToBeClickable(DepartmentDropBtn)).click();
//		
////		try
////		{
//		Thread.sleep(1000);
//		List<WebElement> departList=driver.findElements(By.xpath("//div/select-option"));
//		
//		int deptSize=departList.size();
//		
//		
//		int randomDept=ThreadLocalRandom.current().nextInt(1, deptSize);
//		
//		
//		driver.findElement(By.xpath("//div["+randomDept+"]/select-option")).click();
////		}
////		catch(Exception e)
////		{
////			cmp.FirstOption_DropBtn.click();
////		}
	
	}
	
	public void Select_Coursing() throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(CoursingDropBtn);
		Thread.sleep(2000);
		wait=new WebDriverWait(driver, Duration.ofSeconds(120));
		
		
		Thread.sleep(1000);
		cmp.Click_DropDown_withSearch(CoursingDropBtn, "Coursing selected");
		
		
//		wait.until(ExpectedConditions.elementToBeClickable(CoursingDropBtn)).click();
//		CoursingDropBtn.click();
		
//		List<WebElement> courseList=driver.findElements(By.xpath("//div/select-option"));
//		
//		int courseSize=courseList.size();
//		
//		if(courseSize<=6)
//		{
//		
//		int randomCoursing=ThreadLocalRandom.current().nextInt(1, courseSize);
//		
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
//		}
//		else
//		{
//			int randomCoursing=ThreadLocalRandom.current().nextInt(1, 6);
//			
//			Thread.sleep(1000);
//			driver.findElement(By.xpath("//div["+randomCoursing+"]/select-option")).click();
//		
//		}
	
	}
	
	public void Select_ServingSizeLevel() throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(ServingSizeLevelDropBtn);
		Thread.sleep(2000);
		wait=new WebDriverWait(driver, Duration.ofSeconds(120));
	
		wait.until(ExpectedConditions.elementToBeClickable(ServingSizeLevelDropBtn)).click();
		
//		ServingSizeLevelDropBtn.click();
		Thread.sleep(2000);
		
		List<WebElement> ServSizeLvlList=driver.findElements(By.xpath("//div/select-option"));
		
		int ServSizeLvl=ServSizeLvlList.size();
		
		
		int randomServSizeLvl=ThreadLocalRandom.current().nextInt(1, ServSizeLvl);
		
		if(ServSizeLvl<=5)
		{
			Thread.sleep(1000);
//			ServingSizeLevelDropBtn.click();
			
			if(driver.findElement(By.xpath("//div["+ServSizeLvl+"]/select-option")).isEnabled())
			{
				
			}
			else
			{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div["+ServSizeLvl+"]/select-option")).click();
			}
		}
		else if(ServSizeLvl==1)
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//div["+randomServSizeLvl+"]/select-option")).click();
		}
		else if(ServSizeLvl>5)
		{
			int randomServSizeLvl1=ThreadLocalRandom.current().nextInt(1, ServSizeLvl);
			driver.findElement(By.xpath("//div["+randomServSizeLvl1+"]/select-option")).click();

		}
	
		List<WebElement> ServSizeLvlList1=driver.findElements(By.xpath("//div/select-option"));

		if(ServSizeLvlList1.size()!=0)
		{
			ServingSizeLevelDropBtn.click();
		}
	}
	
	@FindBy(xpath = "//h5[contains(.,'Roles')]/../../..//button[contains(.,'Show All')]")
	WebElement ShowAll_Select_RolesBtn;
	
	
	public void Select_Roles() throws Exception
	{
		Thread.sleep(1000);
		List<WebElement> rolesList=driver.findElements(By.xpath("//div[@id='new-category-roles']/div[3]/div/app-chip/div/mat-chip-list/div/mat-chip"));
		
		int rolesSize=rolesList.size();
		
		
		int randomRole=ThreadLocalRandom.current().nextInt(1, rolesSize);
		
		if(rolesSize>=1)
		{
		try
		{
		if(ShowAll_Select_RolesBtn.isDisplayed())
		{
			ShowAll_Select_RolesBtn.click();
			
		}
		}
		catch(Exception l) {}
		
			Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='new-category-roles']/div[3]/div/app-chip/div/mat-chip-list/div/mat-chip["+randomRole+"]")).click();
	
		//driver.findElement(By.xpath("//div[@id='new-category-roles']/div[3]/div/app-chip/div/mat-chip-list/div/mat-chip[contains(.,'"+str+"')]")).click();
		}
		else
		{
			test.log(LogStatus.WARNING, "Roles not available");
		}
	}
	
	public void Select_TareGroup() throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(TareGroupDropBtn);
		Thread.sleep(1000);
		
		wait=new WebDriverWait(driver, Duration.ofSeconds(120));
		
		cmp.Click_DropDown_withSearch(TareGroupDropBtn, "Tare Group Selected");
		
//		TareGroupDropBtn.click();
//		wait.until(ExpectedConditions.elementToBeClickable(TareGroupDropBtn)).click();
//		
//		Thread.sleep(1000);
//		List<WebElement> tareGrpList=driver.findElements(By.xpath("//div/select-option"));
//		
//		int tareGrpSize=tareGrpList.size();
//		
//		
//		int randomTareGrp=ThreadLocalRandom.current().nextInt(1, tareGrpSize);
//		
//		
//		driver.findElement(By.xpath("//div["+randomTareGrp+"]/select-option")).click();
//		
//	
	}
	
	public void Create_Category_NewTax(String str) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		tx=new TaxesPage(driver, test);
		Thread.sleep(1000);
		New_TaxBtn.click();
		
		Thread.sleep(1000);
		if(cmp.CreationScreenHeader.getText().equalsIgnoreCase("New Tax"))
		{
			test.log(LogStatus.PASS, "New Tax form loaded successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax form loaded Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		New_TaxNameInput.clear();
		Thread.sleep(500);
		New_TaxNameInput.sendKeys(str);
	//Remove below all	
		Thread.sleep(1000);
//		tx.Select_TaxType_Percentage();
//		Thread.sleep(1000);
//		tx.Enter_Percentage("1000");
//		Thread.sleep(1000);
//		tx.Select_InclusiveTax();
//		
////		tx.Select_DefaultTax();
		Thread.sleep(1000);
		tx.Select_TaxType_Amount();
		
		Thread.sleep(1000);
		tx.Enter_AmountBox("2000");
		
//		tx.Click_ItemTax();
		
		Thread.sleep(1000);
		cmp.Click_SaveButton();
		
		Thread.sleep(2000);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Tax Saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Saved Failed");
		}
	}
	
	
	public void Select_ItemServiceCharge() throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(ItemServiceChargeDropBtn);
		Thread.sleep(1000);
		wait=new WebDriverWait(driver, Duration.ofSeconds(120));
	
//		ItemServiceChargeDropBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(ItemServiceChargeDropBtn)).click();
		
		Thread.sleep(1000);
		
		List<WebElement> itemServChargeList=driver.findElements(By.xpath("//div/select-option"));
		
		int itemServChargeSize=itemServChargeList.size();
		
		if(itemServChargeSize<=6)
		{
		int randomItemServCharge=ThreadLocalRandom.current().nextInt(1, itemServChargeSize);
		
		
		driver.findElement(By.xpath("//div["+randomItemServCharge+"]/select-option")).click();
		}
		else
		{
			int randomItemServCharge=ThreadLocalRandom.current().nextInt(1, 6);
			
			
			driver.findElement(By.xpath("//div["+randomItemServCharge+"]/select-option")).click();
		
		}
		
		
		List<WebElement> itemServChargeList1=driver.findElements(By.xpath("//div/select-option"));

		if(itemServChargeList1.size()!=0)
		{
			Thread.sleep(1000);
			ItemServiceChargeDropBtn.click();
		}
	
	}
	//app-selectbox[@label='Item Service Charge']/div/mat-form-field/div/div/div[3]/input
	
	
	@FindBy(xpath = "//button[contains(.,'New Kitchen Printer')]")
	WebElement New_Kitchen_PrinterBtn;
	
}
