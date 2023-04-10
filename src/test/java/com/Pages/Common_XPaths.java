package com.Pages;

import static org.testng.Assert.expectThrows;

import java.time.Duration;
import java.util.Collections;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Common_XPaths {

	public WebDriver driver;
	public ExtentTest test;
	
	Utility ut=new Utility();
	
	public Common_XPaths(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath = "//input[@data-placeholder='Search']")
	WebElement SearchBox;

	@FindBy(xpath = "//button[.='Save']")
	WebElement SaveBtn;
	
	@FindBy(xpath = "//button[contains(.,'SAVE')]")
	WebElement Save_ButtonTwo;
	
	@FindBy(xpath = "//button[contains(.,'UPDATE')]")
	WebElement Update_ButtonTwo;
	
	public WebElement Save_Button()
	{
		return SaveBtn;
	}
	
	public WebElement Update_Button()
	{
		return UpdateBtn;
	}
	
	public void Click_Save_ButtonTwo()
	{
		Save_ButtonTwo.click();
	}
	
	public void Click_Update_ButtonTwo()
	{
		Update_ButtonTwo.click();
	}
	
	public WebElement Save_ButtonTwo()
	{
		return Save_ButtonTwo;
	}
	
	public WebElement Update_ButtonTwo()
	{
		return Update_ButtonTwo;
	}
	
	@FindBy(xpath = "//button[.='Update']")
	WebElement UpdateBtn;
	
	@FindBy(xpath = "//button[.='Cancel']")
	WebElement CancelBtn;
	
	@FindBy(xpath = "//div[@class='action-buttons']/div/div/button[contains(.,'Cancel')]")
	WebElement CancelBtn_AlertPopup;
	
	@FindBy(xpath = "//button[contains(.,'Delete')]")
	WebElement DeleteBtn;
	
	@FindBy(xpath = "//button[contains(.,'Activate')]")
	WebElement ActivateBtn;
	
	@FindBy(xpath = "//div/span[contains(.,'Close')]")
	WebElement CloseBtn;
	
	@FindBy(xpath = "//div[@class='drawer-component']/div/div/h3")
	WebElement CreationScreenHeader;
	
	@FindBy(xpath = "//div[contains(@class,'row header-row')]/div/div/div/h3")
	WebElement CreationScreenHeaderTwo;
	
	@FindBy(xpath = "//mat-button-toggle[.='Yes']")
	WebElement YesToggleBtn;
	
	@FindBy(xpath = "//mat-button-toggle[.='No']")
	WebElement NoToggleBtn;
	
	@FindBy(xpath = "//div[contains(@class,'message')]/span")
	WebElement AlertMessageTitle;
	
	@FindBy(xpath = "//div[contains(@class,'row header-sticky')]//h3")
	WebElement MainScreenHeader;
	
	@FindBy(xpath = "//label[contains(.,'Name')]/../../input")
	WebElement NameInputBox;
	
	@FindBy(xpath = "//button[contains(.,'Active')]")
	WebElement EnableActive_InactiveBtn;
	
	@FindBy(xpath = "//button[contains(.,'Inactive')]")
	WebElement EnableInactive_ActiveBtn;
	
	@FindBy(xpath = "//button[contains(@class,'mat-button-base active-toggle')]/span/span")
	WebElement Active_InactiveStatus;
	
	@FindBy(xpath = "//pagination/div/div/div")
	WebElement PaginationIcon;
	
	@FindBy(xpath = "//div[@class='profile']/../div[4]/button")
	WebElement PublishButton;
	
	@FindBy(xpath = "//button[contains(.,'keyboard_backspace')]")
	WebElement Backspace_Icon;
	
	@FindBy(xpath = "//button[contains(.,'SAVE AND PUBLISH')]")
	WebElement SaveAndPublish_Btn;
	
	@FindBy(xpath = "//button[contains(.,'UPDATE AND PUBLISH')]")
	WebElement UpdateAndPublish_Btn;

	@FindBy(xpath = "//button[contains(.,'COLUMNS')]")
	WebElement Columns_Btn;

	@FindBy(xpath = "//input[@type='file']")
	WebElement Upload_PictureBtn;

	@FindBy(xpath = "//div[@class='alert-content']/p")
	WebElement Alert_Popup;
	
	@FindBy(xpath = "//button[contains(.,'amount')]")
	WebElement AmountBtn;

	@FindBy(xpath = "//button[contains(.,'percentage')]")
	WebElement PercentageBtn;
	
	@FindBy(xpath = "//div[@class='options']/select-option[1]")
	WebElement FirstOption_DropBtn;

	@FindBy(xpath = "//button[contains(.,'NEW TAX')]")
	WebElement New_TaxBtn;
	
	@FindBy(xpath = "//h3[contains(.,'New Tax')]/../../..//label[contains(.,'Name')]/../../input")
	WebElement New_TaxNameInput;
	
	@FindBy(xpath = "//button[contains(.,'Okay')]")
	WebElement Okay_Btn;
	
	public void Click_Okay_Button()
	{
		Okay_Btn.click();
		
	}
	
	public void Click_Amount()
	{
		AmountBtn.click();
	}
	
	public void Click_Percentage()
	{
		PercentageBtn.click();
	}
	
	public void Alert_PopupMsg(String str)
	{
		if(Alert_Popup.getText().equalsIgnoreCase(str))
		{
			test.log(LogStatus.PASS, str+ "Displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, str+ "not Displayed");
		}
	}
	
	public void Upload_Picture(String str) throws Exception
	{
	//	Upload_PictureBtn.clear();
		Thread.sleep(1000);
		Upload_PictureBtn.sendKeys(str);
	}
	
	
	public void Filter_Columns() throws Exception
	{
		Thread.sleep(1000);
		Columns_Btn.click();
		
		//Deselect Select All
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();
		Thread.sleep(500);
		
		Thread.sleep(1000);
		List<WebElement> FilterList=driver.findElements(By.xpath("//div[@class='option-list']/div/select-option"));
		
//		for(int i=1;i<=FilterList.size();i++)
//		{
//			
//		}
		
		
		for(WebElement ele:FilterList)
		{
			String FilterText=ele.getText();
			
			ele.click();
			
			if(FilterText.equalsIgnoreCase("Select All"))
			{
				test.log(LogStatus.PASS, "Select All Filtered Successfully");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else if(driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[1]/div/span")).getText().equalsIgnoreCase(FilterText))
			{
				test.log(LogStatus.PASS, FilterText+ " Filtered Successfully");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, FilterText+ " Filter Unsuccessful. Wrongly filtered as "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[1]/div/span")).getText());
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
			ele.click();
		}
		
		driver.findElement(By.xpath("//div[@class='option-list']/div/select-option[1]")).click();

	}
	
	public void Click_Save_and_PublishButton()
	{
		SaveAndPublish_Btn.click();
	}
	
	public WebElement Save_and_PublishButton()
	{
		return SaveAndPublish_Btn;
	}
	
	public void Click_Update_and_PublishButton()
	{
		UpdateAndPublish_Btn.click();
	}
	
	public WebElement Update_and_PublishButton()
	{
		return UpdateAndPublish_Btn;
	}
	
	
	public void Click_BackspaceButton() throws Exception
	{
		Thread.sleep(2000);
//		Cursor_MoveToElement(Backspace_Icon);
		Backspace_Icon.click();
	}
	
	public WebElement Enable_Active_InactiveBtn()
	{
		return EnableActive_InactiveBtn;
	}
	
	public void Click_ActivetoInactiveButton()
	{
		EnableActive_InactiveBtn.click();
	}
	
	public void Click_InactivetoActiveButton()
	{
		EnableInactive_ActiveBtn.click();
	}
	
	public void Click_YesButton()
	{
		YesToggleBtn.click();
	}
	
	public void Click_NoButton()
	{
		NoToggleBtn.click();
	}
	
	public void VerifyActive_InactiveStatus(String str)
	{
		
		if(Active_InactiveStatus.getText().equalsIgnoreCase(str))
		{
			test.log(LogStatus.PASS, str+" Page displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, str+" Page not displayed");
		}
	}
	
	public void Click_SaveButton()
	{
		SaveBtn.click();
	}
	
	public void Click_UpdateButton()
	{
		UpdateBtn.click();
	}
	
	public void Click_DeleteButton() throws Exception
	{
		Thread.sleep(1000);
		if(Alert_Popup.getText().equalsIgnoreCase("Are you sure you want to delete this item?"))
		{
			test.log(LogStatus.PASS, "Delete Pop Up Displayed");
			
			DeleteBtn.click();
		}
		else
		{
			test.log(LogStatus.FAIL, "Delete Pop Up not Displayed");
			
		}
		
	}
	
	public void Click_ActivateButton()
	{
		
		if(Alert_Popup.getText().equalsIgnoreCase("Are you sure you want to activate this item?"))
		{
			test.log(LogStatus.PASS, "Activate Pop Up Displayed");
			
			ActivateBtn.click();
		}
		else
		{
			test.log(LogStatus.FAIL, "Activate Pop Up not Displayed");
			
		}

	}
	
	
	public void Click_CancelButton()
	{
		CancelBtn.click();
	}
	
	public void Click_CancelButtonInAlert()
	{
		CancelBtn_AlertPopup.click();
	}
	
	public void Click_CloseButton()
	{
		CloseBtn.click();
	}
	
	public WebElement NameInputBox()
	{
		return NameInputBox;
	}
	
	@FindBy(xpath = "//div[contains(@class,'settings')]/button/span")
	WebElement Setting_Btn;
	
	public WebElement Setting()
	{
		return Setting_Btn;
	}
	
	public void Search(String SearchValue) throws Exception
	{
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(8000);
		
		WebElement cat = driver.findElement(By.xpath("//div[.='"+SearchValue+"']/../div[1]"));
		
		
		if(cat.getText().equals(SearchValue)) {
			test.log(LogStatus.PASS, "Search menu item same ");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else {
				test.log(LogStatus.FAIL, "Search menu item are not same");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}

	}
	
	public WebElement SearchBox()
	{
		return SearchBox;
	}
	
	
	public void EnterName(String Str) throws Exception
	{
		Thread.sleep(1000);
		NameInputBox.clear();
		Thread.sleep(1000);
		NameInputBox.sendKeys(Str);
	}
	
	public WebElement ConfirmationAlertMsg()
	{
		return AlertMessageTitle;
	}


	public void VerifyCreationScreenPageHeader(String Str)
	{
		if(CreationScreenHeader.getText().equals(Str))
		{
			test.log(LogStatus.PASS, Str+" Creation page Loaded Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, Str+" Creation Page Loaded Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	public void VerifyCreationScreenPageHeader_Two(String Str)
	{
		if(CreationScreenHeaderTwo.getText().equals(Str))
		{
			test.log(LogStatus.PASS, Str+" Creation page Loaded Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, Str+" Creation Page Loaded Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	
	public void VerifyMainScreenPageHeader(String Str)
	{
		if(MainScreenHeader.getText().equals(Str))
		{
			test.log(LogStatus.PASS, Str+" Page Loaded Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, Str+" Page Loaded Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	public void VerifyPagination_and_Refresh_Publish() throws Exception
	{
		Thread.sleep(2000);
		
		driver.navigate().refresh();
		Thread.sleep(5000);
		if(PaginationIcon.isDisplayed())
		{
			test.log(LogStatus.PASS, "Pagination Available");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		List<WebElement> pageList=driver.findElements(By.xpath("//pagination/div/div/div"));
		
		Thread.sleep(2000);
		for(int i=2;i<pageList.size();i++)
		{
			driver.findElement(By.xpath("//pagination/div/div/div["+i+"]")).click();
		}
		
		driver.findElement(By.xpath("//pagination/div/div/div[2]")).click();
		
		test.log(LogStatus.INFO, "Pagination Completed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Pagination not available");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		if(PublishButton.isDisplayed())
		{
			test.log(LogStatus.PASS, "Publish Icon Available");
		}
		else
		{
			test.log(LogStatus.FAIL, "Publish Icon not available");
		}
	}
	
	
	public void VerifySaveConfirmationAlertMessage(String Str)
	{
		if(AlertMessageTitle.getText().equals(Str))
		{
			test.log(LogStatus.PASS, Str+" Saved Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, Str+" Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	public WebElement NewCreationScreenHeader()
	{
		return CreationScreenHeader;
	}
	
	public void SearchAndVerify_SearchBox() throws Exception
	{
		
		String SearchText=driver.findElement(By.xpath("//div[contains(@id,'cdk-drop-list')]/div[1]/div/data-grid-row/div/div[1]")).getText().substring(0, 3);

		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchText);
		Thread.sleep(2000);
		
		
		
		if(driver.findElement(By.xpath("//div[contains(@id,'cdk-drop-list')]/div[1]/div/data-grid-row/div/div[1]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Searched item displayed when entering 3 Characters in Search Box");
		}
		else
		{
			test.log(LogStatus.FAIL, "Searched item not displayed when entering 3 Characters in Search box");
		}
	}
	
	public void Verify_Search(String SearchValue) throws Exception
	{
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(8000);
	}
	
	
	public void SearchAndVerify_SearchBoxTwo() throws Exception
	{
		
		String SearchText=driver.findElement(By.xpath("//div[contains(@id,'cdk-drop-list')]/div[1]/div/data-grid-row/div/div[2]")).getText().substring(0, 3);

		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchText);
		Thread.sleep(2000);
		
		
		
		if(driver.findElement(By.xpath("//div[contains(@id,'cdk-drop-list')]/div[1]/div/data-grid-row/div/div[1]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Searched item displayed when entering 3 Characters in Search Box");
		}
		else
		{
			test.log(LogStatus.FAIL, "Searched item not displayed when entering 3 Characters in Search box");
		}
	}
	
	public void SearchAndClickEdit(String SearchValue) throws Exception
	{
		
		Wait_ForElementVisibility(SearchBox, 90);
	
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(2000);
		try
		{
			Thread.sleep(2000);
		driver.findElement(By.xpath("//div[.='"+SearchValue+" ']/../div/div[1]/button")).click();
		
		}
		catch(Exception g)
		{
			
			Thread.sleep(2000);

			driver.findElement(By.xpath("//div[.='"+SearchValue+"']/../div/div[1]/button")).click();
		}
		
		}
	
	public void SearchAndClickDelete(String SearchValue) throws Exception
	{
		Wait_ForElementVisibility(SearchBox, 90);
		try
		{
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[.='"+SearchValue+" ']/../div/div[2]/button")).click();
		Thread.sleep(1000);
		}
		catch(Exception h)
		{
			Thread.sleep(1000);
			SearchBox.clear();
			Thread.sleep(2000);

			SearchBox.sendKeys(SearchValue);
			Thread.sleep(2000);

			driver.findElement(By.xpath("//div[.='"+SearchValue+"']/../div/div[2]/button")).click();
			Thread.sleep(1000);
		}
	}
	
	public void SearchAndClickDeleteCancel(String SearchValue) throws Exception
	{
		Wait_ForElementVisibility(SearchBox, 60);
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(2000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[.='"+SearchValue+" ']/../div/div[2]/button")).click();

	
	}
	
	public void SearchAndClickActivate(String SearchValue) throws Exception
	{
//		WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(300));
		Wait_ForElementVisibility(SearchBox, 60);
		Thread.sleep(1000);
		SearchBox.clear();
		Thread.sleep(1000);

		SearchBox.sendKeys(SearchValue);
		Thread.sleep(2000);

		driver.findElement(By.xpath("//div[.='"+SearchValue+" ']/../div/div/button")).click();
	}
	
	public void Create_NewTax(String str) throws Exception
	{
		TaxesPage tx=new TaxesPage(driver, test);
		New_TaxBtn.click();
		
		if(CreationScreenHeader.getText().equalsIgnoreCase("New Tax"))
		{
			test.log(LogStatus.PASS, "New Tax form loaded successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Tax form loaded Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		New_TaxNameInput.clear();
		
		New_TaxNameInput.sendKeys(str);
		
		
		tx.Select_TaxType_Percentage();
		
		tx.Enter_Percentage("2000");
		
		tx.Select_InclusiveTax();
		
		tx.Select_DefaultTax();
		
		Click_SaveButton();
		
		Thread.sleep(2000);
		if(ConfirmationAlertMsg().getText().equalsIgnoreCase("Tax Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Tax Saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tax Saved Failed");
		}
	}
	
	
	@FindBy(xpath = "//label[contains(.,'Priority')]/../../input")
	WebElement PriorityComn_InputBx;
	
	public void Enter_Priority(String str) throws Exception
	{
		Thread.sleep(1000);
		PriorityComn_InputBx.clear();
		Thread.sleep(1000);
		PriorityComn_InputBx.sendKeys(str);	
	}
	
	public WebElement Priority_Input()
	{
		return PriorityComn_InputBx;
	}
	
	@FindBy(xpath = "//label[contains(.,'Quantity')]/../../input")
	WebElement QuantityComn_InputBx;
	
	public void Enter_Quantity(String str) throws Exception
	{
		Thread.sleep(1000);
		QuantityComn_InputBx.clear();
		Thread.sleep(1000);
		QuantityComn_InputBx.sendKeys(str);	
	}
	
	public WebElement Quantity_Input()
	{
		return QuantityComn_InputBx;
	}
	
	@FindBy(xpath = "//label[contains(.,'Amount')]/../../input")
	WebElement Amount_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Percentage')]/../../input")
	WebElement Percentage_InputBx;
	
	
	public void Enter_Amount(String str) throws Exception
	{
		Thread.sleep(1000);
		Amount_InputBx.clear();
		Thread.sleep(1000);
		Amount_InputBx.sendKeys(str);	
	}
	
	public WebElement Amount_Input()
	{
		return Amount_InputBx;
	}
	
	public void Enter_Percentage(String str) throws Exception
	{
		Thread.sleep(1000);
		Percentage_InputBx.clear();
		Thread.sleep(1000);
		Percentage_InputBx.sendKeys(str);	
	}
	
	public WebElement Percentage_Input()
	{
		return Percentage_InputBx;
	}
	
	
	public void Cursor_MoveToElement(WebElement ele) throws Exception
	{
		Thread.sleep(2000);
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		Thread.sleep(2000);
		
		
	}
	
	public void Click_Wait_ForElementClickable(WebElement ele,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(ele)).click();
	}
	
	public void Wait_ForElementVisibility(WebElement ele,int time)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(ele));
	}
	
	@FindBy(xpath = "//div[.=' Enter valid amount ']")
	WebElement Amount_Err;

	@FindBy(xpath = "//mat-hint[.='Percentage should be between (0-100)']")
	WebElement per_Err;

	public WebElement Amount_Error_Msg()
	{
		return Amount_Err;
	}
	
	public WebElement Percentage_Error_Msg()
	{
		return per_Err;
	}
	
	public void Ascending_And_Descending_Order() 
	{
		List<WebElement> col = driver.findElements(By.xpath("//data-grid-row/div/div/div/span[@class='header-title']"));
		
		for(int i = 1; i <= col.size(); i++) {
			
			
			//double click the required row for descending order
			driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/span[@class='header-title']")).click();
			
			ArrayList<String> ArLst=new ArrayList<String>();
			
			if(driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/div[contains(@class,'mode-asc')]")).isDisplayed())
			{
				List<WebElement> Lst=driver.findElements(By.xpath("//div[contains(@id,'cdk-drop-list')]/div/div/data-grid-row/div/div["+i+"]"));
				
				for(WebElement ele:Lst)
				{
					ArLst.add(ele.getText());
				}
				
				ArrayList<String> sortedLst=new ArrayList<String>();
				
				for(String st:ArLst)
				{
					sortedLst.add(st);
				}
				
				Collections.sort(sortedLst);
				//Collections.reverse(sortedLst);
				//System.out.println(sortedLst);
				
				if(sortedLst.equals(ArLst))
				{
					test.log(LogStatus.PASS, "Ascending Order Sorted Correctly for "+driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/span[@class='header-title']")).getText());
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
					System.out.println("Sorted List from Table(Actual - Ascending) : "+ArLst);
					System.out.println("Sorted List from Table(Expected - Ascending) : "+sortedLst);
				}
				else
				{
					test.log(LogStatus.FAIL, "Ascending Order Sorted Incorrect for "+driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/span[@class='header-title']")).getText());
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
					
					System.out.println("Sorted List from Table(Actual - Ascending) : "+ArLst);
					System.out.println("Sorted List from Table(Expected - Ascending) : "+sortedLst);
				}
			}
		}
		
		for(int i = 1; i <= col.size(); i++) {
			
			
			//click the required row for descending order
			driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/span[@class='header-title']")).click();
			//driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/span[@class='header-title']")).click();
			
			ArrayList<String> ArLst=new ArrayList<String>();
			
			if(driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/div[contains(@class,'mode-desc')]")).isDisplayed())
			{
				List<WebElement> Lst=driver.findElements(By.xpath("//div[contains(@id,'cdk-drop-list')]/div/div/data-grid-row/div/div["+i+"]"));
				
				for(WebElement ele:Lst)
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
				//System.out.println(sortedLst);
				
				if(sortedLst.equals(ArLst))
				{
					test.log(LogStatus.PASS, "Desending Order Sorted Correctly for "+driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/span[@class='header-title']")).getText());
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
					
					System.out.println("Sorted List from Table(Actual - Descending) : "+ArLst);
					System.out.println("Sorted List from Table(Expected - Descending) : "+sortedLst);
				}
				else
				{
					test.log(LogStatus.FAIL, "Desending Order Sorted Incorrect for "+driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/span[@class='header-title']")).getText());
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
					
					System.out.println("Sorted List from Table(Actual - Descending) : "+ArLst);
					System.out.println("Sorted List from Table(Expected - Descending) : "+sortedLst);
				}
			}
		}
	}

}
