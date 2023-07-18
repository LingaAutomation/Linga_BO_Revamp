package com.Pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_Scales_Page {
	WebDriver driver;
	ExtentTest test;
	Common_XPaths cmp;
	Utility ut=new Utility();
	
	public Settings_Scales_Page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//span[.='Addons']/div/span")
	WebElement Addons;
	
	@FindBy(xpath = "//span[.='Scales']")
	WebElement Scale;
	
	@FindBy(xpath = "//h3[.='Scales']")
	WebElement Scales;
	
	@FindBy(xpath = "//span[contains(.,'Active')]/../../button")
	WebElement Active_Btn;
	
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement Search_option;
	
	@FindBy(xpath = "//span[contains(.,'COLUMNS')]/../../button")
	WebElement Column_option;
	
	@FindBy(xpath = "//span[contains(.,'NEW SCALE BARCODE')]/../../button")
	WebElement NewScaleBarCode_Btn;
	
	@FindBy(xpath = "//div/data-grid-row/div/div/div/span[contains(.,'Name')]")
	WebElement NameColumn;
	
	@FindBy(xpath = "//div/data-grid-row/div/div/div/span[contains(.,'Prefix Variable Type')]")
	WebElement PrefixVariableTypeColumn;
	
	@FindBy(xpath = "//div/data-grid-row/div/div/div/span[contains(.,'PLU Code')]")
	WebElement PLUCodeColumn;
	
	@FindBy(xpath = "//div/data-grid-row/div/div/div/span[contains(.,'Price Details')]")
	WebElement PriceDetailsColumn;
	
	@FindBy(xpath = "//div/data-grid-row/div/div/div/span[contains(.,'Weight Details')]")
	WebElement WeightDetailsColumn;
	
	@FindBy(xpath = "//div/data-grid-row/div/div/div[contains(.,'Actions')]")
	WebElement ActionsColumn;
	
	@FindBy(xpath = "//h3[contains(.,'New Scale Barcode')]")
	WebElement NewScaleBarCode_Heading;
	
	@FindBy(xpath = "//mat-label[contains(.,'Variable Type Name')]/../../../input")
	WebElement VariableTypeName_Field;
	
	@FindBy(xpath = "//mat-label[contains(.,'Prefix/Variable Type')]/../../../input")
	WebElement PrefixVariableType_Field;
	
	@FindBy(xpath = "//mat-label[contains(.,'PLU Start Position')]/../../../input")
	WebElement PLUStartPosition_Field;
	
	@FindBy(xpath = "//mat-label[contains(.,'PLU No. of Digits')]/../../../input")
	WebElement PLUNumOfDigits_Field;
	
	@FindBy(xpath = "//span[contains(.,'Set Scale By:')]")
	WebElement SetScaleBy_Field;
	
	@FindBy(xpath = "//span[contains(.,'Price')]/../../../mat-radio-button[1]")
	WebElement Price_Field_NewBarCode;
	
	@FindBy(xpath = "//span[contains(.,'Price')]/../../../mat-radio-button[2]")
	WebElement Weight_Field_NewBarCode;
	//span[contains(.,'Weight')]/../../label/span[2]
	@FindBy(xpath = "//app-new-scale-barcode/div/div[4]/div")
	WebElement PriceORWeight_InputField_NewBarCode;
	
	@FindBy(xpath = "//span[contains(.,'Cancel')]/../../button")
	WebElement CancelBtn_NewBarCode;
	
	@FindBy(xpath = "//span[contains(.,'Save')]/../../button[@disabled='true']")
	WebElement SaveBtnDisabled_NewBarCode;
	
	@FindBy(xpath = "//mat-label[contains(.,'Price Start Position')]/../../../input")
	WebElement PriceStartPosition_Field;
	
	@FindBy(xpath = "//mat-label[contains(.,'Price No. of Digits')]/../../../input")
	WebElement PriceNumOfDigits_Field;
	
	@FindBy(xpath = "//mat-label[contains(.,'Price Start Position')]/../../../../../../../div/button[1]")
	WebElement UpArrowOfPriceStartPosition_NewBarCode;
	
	@FindBy(xpath = "//mat-label[contains(.,'Price Start Position')]/../../../../../../../div/button[2]")
	WebElement DownArrowOfPriceStartPosition_NewBarCode;
	
	@FindBy(xpath = "//mat-label[contains(.,'Price No. of Digits')]/../../../../../../../div/button[1]")
	WebElement UpArrowOfPriceNumberOfDigits_NewBarCode;
	
	@FindBy(xpath = "//mat-label[contains(.,'Price No. of Digits')]/../../../../../../../div/button[2]")
	WebElement DownArrowOfPriceNumberOfDigits_NewBarCode;
	
	@FindBy(xpath = "//mat-label[contains(.,'Weight Start Position')]/../../../input")
	WebElement WeightStartPosition_Field;
	
	@FindBy(xpath = "//mat-label[contains(.,'Weight No. of Digits')]/../../../input")
	WebElement WeightNumOfDigits_Field;
	
	@FindBy(xpath = "//mat-label[contains(.,'Weight Start Position')]/../../../../../../../div/button[1]")
	WebElement UpArrowOfWeightStartPosition_NewBarCode;
	
	@FindBy(xpath = "//mat-label[contains(.,'Weight Start Position')]/../../../../../../../div/button[2]")
	WebElement DownArrowOfWeightStartPosition_NewBarCode;
	
	@FindBy(xpath = "//mat-label[contains(.,'Weight No. of Digits')]/../../../../../../../div/button[1]")
	WebElement UpArrowOfWeightNumberOfDigits_NewBarCode;
	
	@FindBy(xpath = "//mat-label[contains(.,'Weight No. of Digits')]/../../../../../../../div/button[2]")
	WebElement DownArrowOfWeightNumberOfDigits_NewBarCode;
	
	@FindBy(xpath = "//span[contains(.,'Save')]/../../button")
	WebElement SaveBtn_NewBarCode;
	
	@FindBy(xpath =  "//div[@class='message mx-2']/span")
	WebElement successMessage;
	
	@FindBy(xpath = "//mat-label[contains(.,'PLU Start Position')]/../../../../../../../div/button[1]")
	WebElement UpArrowOfPLUStartPosition_NewBarCode;
	
	@FindBy(xpath = "//mat-label[contains(.,'PLU Start Position')]/../../../../../../../div/button[2]")
	WebElement DownArrowOfPLUStartPosition_NewBarCode;
	
	@FindBy(xpath = "//mat-label[contains(.,'PLU No. of Digits')]/../../../../../../../div/button[1]")
	WebElement UpArrowOfPLUNumberOfDigits_NewBarCode;
	
	@FindBy(xpath = "//mat-label[contains(.,'PLU No. of Digits')]/../../../../../../../div/button[2]")
	WebElement DownArrowOfPLUNumberOfDigits_NewBarCode;
		
	@FindBy(xpath =  "//span[contains(.,'keyboard_backspace')]")
	WebElement Back_btn;
	
	@FindBy(xpath =  "//data-grid/div//div[1]/div[1]/data-grid-row/div/div[6]/div[2]/button")
	WebElement Delete_btn_FirstRow;
	
	@FindBy(xpath =  "//span[contains(.,'Close')]/../../button")
	WebElement Close_btn;
	
	@FindBy(xpath =  "//span[contains(.,'Cancel')]/../../button[@type]")
	WebElement Cancel_btn;
	
	@FindBy(xpath =  "//span[contains(.,'Delete')]/../../button")
	WebElement Delete_btn;
	
	@FindBy(xpath = "(//mat-icon[.='check_circle_outline'])[1]")
	WebElement Activate_Btn;
	
	@FindBy(xpath =  "//span[contains(.,'Yes, Activate')]/../../button")
	WebElement Yes_Active_btn;
	
	
	
	public void verifyAddNewScaleBarCodeBtn() throws InterruptedException {
		Thread.sleep(3000);
		//click the add new scale bar code button
		NewScaleBarCode_Btn.click();
		
		Thread.sleep(4000);
		verifyAddNewScaleBarcode_Visibility();
		
		Thread.sleep(2000);
		//send the dummy text in variable type field name
		VariableTypeName_Field.sendKeys("s");
		
		Thread.sleep(2000);
		//clear the value
		VariableTypeName_Field.sendKeys(Keys.BACK_SPACE);
		
		try
		{
		Thread.sleep(1000);
		if(driver.findElement(By.xpath("//mat-hint[.='Please Enter Name']")).isDisplayed())
		{
		
			String s = driver.findElement(By.xpath("//mat-hint[.='Please Enter Name']")).getText();
		
			//Verify the success message
			if(s.equals("Please Enter Name"))
			{
				test.log(LogStatus.PASS, "Please Enter Name warning message is displayed when user click the Save button without Variable Type Name");
			}
			else
			{
				test.log(LogStatus.FAIL, "Please Enter Name warning message is not displayed when user click the Save button without Variable Type Name");
			}
		}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Please Enter Name warning Pop Up is not displayed when user click the Save button without Variable Type Name");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		VariableTypeName_Field.sendKeys(RandomStringUtils.randomAlphanumeric(26));
		
		Thread.sleep(2000);
		
		//get the value of entered string
		String s1 = VariableTypeName_Field.getAttribute("value");
		
		if(s1.length() == 25)
		{
			test.log(LogStatus.PASS, "Variable Type name field accept only 25 characters");
		}
		else if(s1.length() > 25)
		{
			test.log(LogStatus.FAIL, "Variable Type name field accept more than 25 characters");
			
		try
		{
			if(driver.findElement(By.xpath("//mat-hint[.='Name should not be more than 25 characters']")).isDisplayed())
			{
			
					String s2 = driver.findElement(By.xpath("//mat-hint[.='Name should not be more than 25 characters']")).getText();
			
				//Verify the field validation message
				if(s2.equals("Name should not be more than 25 characters"))
				{
					test.log(LogStatus.PASS, "Name should not be more than 25 characters warning message is displayed when user enter more than 25 chars in Variable Type Name");
				}
				else
				{
					test.log(LogStatus.FAIL, "Name should not be more than 25 characters message is not displayed when user enter more than 25 chars in Variable Type Name");
				}
			}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Name should not be more than 25 characters Pop Up is not displayed when user enter more than 25 chars in Variable Type Name");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
			
			//clear the Variable Type name field
			VariableTypeName_Field.clear();
			
			VariableTypeName_Field.sendKeys(RandomStringUtils.randomAlphanumeric(5));
			Thread.sleep(1000);
		}
		
		//clear the variable type
		PrefixVariableType_Field.clear();
		
		//send the value
		PrefixVariableType_Field.sendKeys(RandomStringUtils.randomNumeric(1));
		
		//clear the variable type
		PrefixVariableType_Field.sendKeys(Keys.BACK_SPACE);
		
		try
		{
			if(driver.findElement(By.xpath("//mat-hint[.='Enter Prefix']")).isDisplayed())
			{
			String s2 = driver.findElement(By.xpath("//mat-hint[.='Enter Prefix']")).getText();
		
			//Verify the field validation message
			if(s2.equals("Enter Prefix"))
			{
				test.log(LogStatus.PASS, "Enter Prefix field validation message is displayed when there is no Prefix value is enter");
			}
			else
			{
				test.log(LogStatus.FAIL, "Enter Prefix field validation message is not displayed when there is no Prefix value is enter");
			}
			}
		}
		catch(Exception p)
		{
			test.log(LogStatus.FAIL, "Enter Prefix field validation Pop Up is not displayed when there is no Prefix value is enter");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//send the invalid to variable type
		PrefixVariableType_Field.sendKeys(RandomStringUtils.randomAlphabetic(2));
		
		try
		{
			if(driver.findElement(By.xpath("//mat-hint[.='Enter Valid Prefix']")).isDisplayed())
			{
			String s3 = driver.findElement(By.xpath("//mat-hint[.='Enter Valid Prefix']")).getText();
		
			//Verify the field validation message
			if(s3.equals("Enter Valid Prefix"))
			{
				test.log(LogStatus.PASS, "Enter Valid Prefix field validation message is displayed when user enter invalid prefix type");
			}
			else
			{
				test.log(LogStatus.FAIL, "Enter Valid Prefix field validation message is not displayed when user enter invalid prefix type");
			}
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.FAIL, "Enter Valid Prefix field validation Pop Up is not displayed when user enter invalid prefix type");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		//clear the variable type
		PrefixVariableType_Field.clear();
		
		//send the value
		PrefixVariableType_Field.sendKeys(RandomStringUtils.randomNumeric(3));
		
		Thread.sleep(2000);
		
		//get the value of entered string
		String s4 = PrefixVariableType_Field.getAttribute("value");
		
		if(s4.length() == 2)
		{
			test.log(LogStatus.PASS, "Prefix Variable Type field accept only 2 characters");
		}
		else if(s4.length() == 3)
		{
			test.log(LogStatus.FAIL, "Prefix Variable Type field accept more than 2 characters");
			
			//clear the Variable Type name field
			PrefixVariableType_Field.clear();
			
			PrefixVariableType_Field.sendKeys(RandomStringUtils.randomNumeric(2));
			Thread.sleep(1000);
		}
		
		//Click the up arrow button of PLU start position
		UpArrowOfPLUStartPosition_NewBarCode.click();
		
		String u1 =  PLUStartPosition_Field.getAttribute("value");
		
		int i1 = Integer.parseInt(u1);
		
		if(i1 == 1)
		{
			test.log(LogStatus.PASS, "Increase the value of PLU Start Position is working fine when user click it initially then it is displayed 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of PLU Start Position is not working fine when user click it");
		}
		
		//click the down arrow button
		DownArrowOfPLUStartPosition_NewBarCode.click();
		
		String u2 =  PLUStartPosition_Field.getAttribute("value");
		
		int i2 = Integer.parseInt(u2);
		
		if(i2 == (i1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of PLU Start Position is working fine when user click it then it is decreased by 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of PLU Start Position is not working fine when user click it");
		}
		
		try
		{
			if(driver.findElement(By.xpath("//mat-hint[contains(.,'Enter PLU Start Position')]")).isDisplayed())
			{
		
				String w1 = driver.findElement(By.xpath("//mat-hint[contains(.,'Enter PLU Start Position')]")).getText();
		
				//Verify the field validation message
				if(w1.equals("Enter PLU Start Position"))
				{
					test.log(LogStatus.PASS, "Enter PLU Start Position field validation message is displayed when user enter invalid PLU start position");
				}
				else
				{
					test.log(LogStatus.FAIL, "Enter PLU Start Position field validation message is not displayed when user enter invalid PLU start position");
				}
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.FAIL, "Enter PLU Start Position field validation Pop Up is not displayed when user enter invalid PLU start position");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		//click the down arrow button
		DownArrowOfPLUStartPosition_NewBarCode.click();
		
		String u3 =  PLUStartPosition_Field.getAttribute("value");
		
		int i3 = Integer.parseInt(u3);
		
		if(i3 == (i1-1))
		{
			test.log(LogStatus.PASS, "The PLU start position is not decreasing when start position is already in 0");
		}
		else
		{
			test.log(LogStatus.FAIL, "The PLU start position is decreasing when start position is already in 0");
		}
		
		PLUStartPosition_Field.sendKeys("e");
		
		String u4 =  PLUStartPosition_Field.getAttribute("value");
		
		if(u4.equals("0e"))
		{
			test.log(LogStatus.FAIL, "The PLU start position accept the Alphabets");
		}
		else
		{
			test.log(LogStatus.PASS, "The PLU start position is not accept the Alphabets");
		}
		
		PLUStartPosition_Field.sendKeys(Keys.ARROW_DOWN);
		
		String u5 =  PLUStartPosition_Field.getAttribute("value");
		
		int i5 = Integer.parseInt(u5);
		
		if(i5 == (i1-2))
		{
			test.log(LogStatus.PASS, "The PLU start position field accept the negative values");
		}
		else
		{
			test.log(LogStatus.FAIL, "The PLU start position field is not accept the negative values");
		}
		
		//Click the up arrow button of PLU start position
		UpArrowOfPLUStartPosition_NewBarCode.click();
				
		//Click the up arrow button of PLU start position
		UpArrowOfPLUStartPosition_NewBarCode.click();
		/////////////////////////////////////////////////////////////////////////////////////////////////
		//Click the up arrow button of PLU start position
		UpArrowOfPLUNumberOfDigits_NewBarCode.click();
		
		String a1 =  PLUNumOfDigits_Field.getAttribute("value");
		
		int b1 = Integer.parseInt(a1);
		
		if(b1 == 1)
		{
			test.log(LogStatus.PASS, "Increase the value of PLU Number of Digits is working fine when user click it initially then it is displayed 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of PLU Number of Digits is not working fine when user click it");
		}
		
		//click the down arrow button
		DownArrowOfPLUNumberOfDigits_NewBarCode.click();
		
		String a2 =  PLUNumOfDigits_Field.getAttribute("value");
		
		int b2 = Integer.parseInt(a2);
		
		if(b2 == (b1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of PLU Number of Digits is working fine when user click it then it is decreased by 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of PLU Number of Digits is not working fine when user click it");
		}
		
		try
		{
			if(driver.findElement(By.xpath("//mat-hint[contains(.,'Enter PLU No Digits')]")).isDisplayed())
			{
				
		
				String c1 = driver.findElement(By.xpath("//mat-hint[contains(.,'Enter PLU No Digits')]")).getText();
		
				//Verify the field validation message
				if(c1.equals("Enter PLU No Digits"))
				{
					test.log(LogStatus.PASS, "Enter PLU Number of Digits field validation message is displayed when user enter invalid PLU Number of Digits");
				}
				else
				{
					test.log(LogStatus.FAIL, "Enter PLU Number of Digits field validation message is not displayed when user enter invalid PLU Number of Digits");
				}
			}
		}
		catch(Exception p)
		{
			test.log(LogStatus.FAIL, "Enter PLU Number of Digits field validation message is not displayed when user enter invalid PLU Number of Digits");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//click the down arrow button
		DownArrowOfPLUNumberOfDigits_NewBarCode.click();
		
		String a3 =  PLUNumOfDigits_Field.getAttribute("value");
		
		int b3 = Integer.parseInt(a3);
		
		if(b3 == (b1-1))
		{
			test.log(LogStatus.PASS, "The PLU Number of Digits is not decreasing when PLU Number of Digits is already in 0");
		}
		else
		{
			test.log(LogStatus.FAIL, "The PLU Number of Digits is decreasing when PLU Number of Digits is already in 0");
		}
		
		PLUNumOfDigits_Field.sendKeys("e");
		
		String c4 =  PLUStartPosition_Field.getAttribute("value");
		
		if(c4.equals("0e"))
		{
			test.log(LogStatus.PASS, "The PLU Number of Digits accept the Alphabets");
		}
		else
		{
			test.log(LogStatus.FAIL, "The PLU Number of Digits is not accept the Alphabets");
		}
		
		PLUNumOfDigits_Field.sendKeys(Keys.ARROW_DOWN);
		
		String a5 =  PLUStartPosition_Field.getAttribute("value");
		
		int b5 = Integer.parseInt(a5);
		
		if(b5 == (b1-2))
		{
			test.log(LogStatus.PASS, "The PLU Number of Digits field accept the negative values");
		}
		else
		{
			test.log(LogStatus.FAIL, "The PLU Number of Digits field is not accept the negative values");
		}
		
		//Click the up arrow button of PLU number of digits
		UpArrowOfPLUNumberOfDigits_NewBarCode.click();
				
		//Click the up arrow button of PLU number of digits
		UpArrowOfPLUNumberOfDigits_NewBarCode.click();
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Click the up arrow button of Price start position
		UpArrowOfPriceStartPosition_NewBarCode.click();
		
		String ua1 =  PriceStartPosition_Field.getAttribute("value");
		
		int ia1 = Integer.parseInt(ua1);
		
		if(ia1 == 1)
		{
			test.log(LogStatus.PASS, "Increase the value of Price Start Position is working fine when user click it initially then it is displayed 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of Price Start Position is not working fine when user click it");
		}
		
		//click the down arrow button
		DownArrowOfPriceStartPosition_NewBarCode.click();
		
		String ua2 =  PriceStartPosition_Field.getAttribute("value");
		
		int ia2 = Integer.parseInt(ua2);
		
		if(ia2 == (ia1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of Price Start Position is working fine when user click it then it is decreased by 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of Price Start Position is not working fine when user click it");
		}
		
		/*
		 * String wa1 = driver.findElement(By.
		 * xpath("//mat-hint[contains(.,'Enter Price Start Position')]")).getText();
		 * 
		 * //Verify the field validation message
		 * if(wa1.equals("Enter Price Start Position")) { test.log(LogStatus.PASS,
		 * "Enter Price Start Position field validation message is displayed when user enter invalid Price start position"
		 * ); } else { test.log(LogStatus.FAIL,
		 * "Enter Price Start Position field validation message is not displayed when user enter invalid Price start position"
		 * ); }
		 */
		
		//click the down arrow button
		DownArrowOfPriceStartPosition_NewBarCode.click();
		
		String ua3 =  PriceStartPosition_Field.getAttribute("value");
		
		int ia3 = Integer.parseInt(ua3);
		
		if(ia3 == (ia1-1))
		{
			test.log(LogStatus.PASS, "The Price start position is not decreasing when start position is already in 0");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Price start position is decreasing when start position is already in 0");
		}
		
		PriceStartPosition_Field.sendKeys("e");
		
		String ua4 =  PriceStartPosition_Field.getAttribute("value");
		
		if(ua4.equals("0e"))
		{
			test.log(LogStatus.PASS, "The Price start position accept the Alphabets");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Price start position is not accept the Alphabets");
		}
		
		PriceStartPosition_Field.sendKeys(Keys.ARROW_DOWN);
		
		String ua5 =  PriceStartPosition_Field.getAttribute("value");
		
		int ia5 = Integer.parseInt(ua5);
		
		if(ia5 == (ia1-2))
		{
			test.log(LogStatus.PASS, "The Price start position field accept the negative values");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Price start position field is not accept the negative values");
		}
		
		//Click the up arrow button of Price start position
		UpArrowOfPriceStartPosition_NewBarCode.click();
				
		//Click the up arrow button of Price start position
		UpArrowOfPriceStartPosition_NewBarCode.click();
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Click the up arrow button of PLU start position
		UpArrowOfPriceNumberOfDigits_NewBarCode.click();
		
		String d1 =  PriceNumOfDigits_Field.getAttribute("value");
		
		int e1 = Integer.parseInt(d1);
		
		if(e1 == 1)
		{
			test.log(LogStatus.PASS, "Increase the value of Price Number of Digits is working fine when user click it initially then it is displayed 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of Price Number of Digits is not working fine when user click it");
		}
		
		//click the down arrow button
		DownArrowOfPriceNumberOfDigits_NewBarCode.click();
		
		String d2 =  PriceNumOfDigits_Field.getAttribute("value");
		
		int e2 = Integer.parseInt(d2);
		
		if(e2 == (e1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of Price Number of Digits is working fine when user click it then it is decreased by 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of Price Number of Digits is not working fine when user click it");
		}
		
		/*
		 * String f1 =
		 * driver.findElement(By.xpath("//mat-hint[contains(.,'Enter Price No Digits')]"
		 * )).getText();
		 * 
		 * //Verify the field validation message if(f1.equals("Enter Price No Digits"))
		 * { test.log(LogStatus.PASS,
		 * "Enter Price Number of Digits field validation message is displayed when user enter invalid Price Number of Digits"
		 * ); } else { test.log(LogStatus.FAIL,
		 * "Enter Price Number of Digits field validation message is not displayed when user enter invalid Price Number of Digits"
		 * ); }
		 */
		
		//click the down arrow button
		DownArrowOfPriceNumberOfDigits_NewBarCode.click();
		
		String d3 =  PriceNumOfDigits_Field.getAttribute("value");
		
		int e3 = Integer.parseInt(d3);
		
		if(e3 == (e1-1))
		{
			test.log(LogStatus.PASS, "The Price Number of Digits is not decreasing when Price Number of Digits is already in 0");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Price Number of Digits is decreasing when Price Number of Digits is already in 0");
		}
		
		PriceNumOfDigits_Field.sendKeys("e");
		
		String f4 =  PriceStartPosition_Field.getAttribute("value");
		
		if(f4.equals("0e"))
		{
			test.log(LogStatus.PASS, "The Price Number of Digits accept the Alphabets");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Price Number of Digits is not accept the Alphabets");
		}
		
		PriceNumOfDigits_Field.sendKeys(Keys.ARROW_DOWN);
		
		String d4 =  PriceStartPosition_Field.getAttribute("value");
		
		int e5 = Integer.parseInt(d4);
		
		if(e5 == (e1-2))
		{
			test.log(LogStatus.PASS, "The Price Number of Digits field accept the negative values");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Price Number of Digits field is not accept the negative values");
		}
		
		//Click the up arrow button of Price number of digits
		UpArrowOfPriceNumberOfDigits_NewBarCode.click();
				
		//Click the up arrow button of Price number of digits
		UpArrowOfPriceNumberOfDigits_NewBarCode.click();

	}
	
	public void verifyAddNewScaleBarCodeBtn_Wieght() throws InterruptedException {
		Thread.sleep(3000);
		//click the add new scale bar code button
		NewScaleBarCode_Btn.click();
		
		Thread.sleep(4000);
		verifyAddNewScaleBarcode_Visibility();
		
		Thread.sleep(2000);
		//send the dummy text in variable type field name
		VariableTypeName_Field.sendKeys("s");
		
		Thread.sleep(2000);
		//clear the value
		VariableTypeName_Field.sendKeys(Keys.BACK_SPACE);
		
		Thread.sleep(1000);
		try
		{
			
			if(driver.findElement(By.xpath("//mat-hint[.='Please Enter Name']")).isDisplayed())
			{
				String s = driver.findElement(By.xpath("//mat-hint[.='Please Enter Name']")).getText();
		
				//Verify the success message
				if(s.equals("Please Enter Name"))
				{
					test.log(LogStatus.PASS, "Please Enter Name warning message is displayed when user click the Save button without Variable Type Name");
				}
				else
				{
					test.log(LogStatus.FAIL, "Please Enter Name warning message is not displayed when user click the Save button without Variable Type Name");
				}
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.FAIL, "Please Enter Name warning Pop Up is not displayed when user click the Save button without Variable Type Name");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		VariableTypeName_Field.sendKeys(RandomStringUtils.randomAlphanumeric(26));
		
		Thread.sleep(2000);
		
		//get the value of entered string
		String s1 = VariableTypeName_Field.getAttribute("value");
		
		if(s1.length() == 25)
		{
			test.log(LogStatus.PASS, "Variable Type name field accept only 25 characters");
		}
		else if(s1.length() > 25)
		{
			test.log(LogStatus.FAIL, "Variable Type name field accept more than 25 characters");
			
			try
			{
				
				if(driver.findElement(By.xpath("//mat-hint[.='Name should not be more than 25 characters']")).isDisplayed())
				{
					String s2 = driver.findElement(By.xpath("//mat-hint[.='Name should not be more than 25 characters']")).getText();
			
					//Verify the field validation message
					if(s2.equals("Name should not be more than 25 characters"))
					{
						test.log(LogStatus.PASS, "Name should not be more than 25 characters warning message is displayed when user enter more than 25 chars in Variable Type Name");
					}
					else
					{
						test.log(LogStatus.FAIL, "Name should not be more than 25 characters message is not displayed when user enter more than 25 chars in Variable Type Name");
					}
				}
			}
			catch(Exception p)
			{
				test.log(LogStatus.FAIL, "Name should not be more than 25 characters Pop Up is not displayed when user enter more than 25 chars in Variable Type Name");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
			//clear the Variable Type name field
			VariableTypeName_Field.clear();
			
			VariableTypeName_Field.sendKeys(RandomStringUtils.randomAlphanumeric(5));
			Thread.sleep(1000);
		}
		
		//clear the variable type
		PrefixVariableType_Field.clear();
		
		//send the value
		PrefixVariableType_Field.sendKeys(RandomStringUtils.randomNumeric(1));
		
		//clear the variable type
		PrefixVariableType_Field.sendKeys(Keys.BACK_SPACE);
		
		try
		{
			
			if(driver.findElement(By.xpath("//mat-hint[.='Enter Prefix']")).isDisplayed())
			{
				String s2 = driver.findElement(By.xpath("//mat-hint[.='Enter Prefix']")).getText();
		
				//Verify the field validation message
				if(s2.equals("Enter Prefix"))
				{
					test.log(LogStatus.PASS, "Enter Prefix field validation message is displayed when there is no Prefix value is enter");
				}
				else
				{
					test.log(LogStatus.FAIL, "Enter Prefix field validation message is not displayed when there is no Prefix value is enter");
				}
			}
		}
		catch(Exception p)
		{
			test.log(LogStatus.FAIL, "Enter Prefix field validation Pop Up is not displayed when there is no Prefix value is enter");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//send the invalid to variable type
		PrefixVariableType_Field.sendKeys(RandomStringUtils.randomAlphabetic(2));
		
		try
		{
			
			if(driver.findElement(By.xpath("//mat-hint[.='Enter Valid Prefix']")).isDisplayed())
			{
				String s3 = driver.findElement(By.xpath("//mat-hint[.='Enter Valid Prefix']")).getText();
		
				//Verify the field validation message
				if(s3.equals("Enter Valid Prefix"))
				{
					test.log(LogStatus.PASS, "Enter Valid Prefix field validation message is displayed when user enter invalid prefix type");
				}
				else
				{
					test.log(LogStatus.FAIL, "Enter Valid Prefix field validation message is not displayed when user enter invalid prefix type");
				}
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.FAIL, "Enter Valid Prefix field validation Pop Up is not displayed when user enter invalid prefix type");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//clear the variable type
		PrefixVariableType_Field.clear();
		
		//send the value
		PrefixVariableType_Field.sendKeys(RandomStringUtils.randomNumeric(3));
		
		Thread.sleep(2000);
		
		//get the value of entered string
		String s4 = PrefixVariableType_Field.getAttribute("value");
		
		if(s4.length() == 2)
		{
			test.log(LogStatus.PASS, "Prefix Variable Type field accept only 2 characters");
		}
		else if(s4.length() == 3)
		{
			test.log(LogStatus.FAIL, "Prefix Variable Type field accept more than 2 characters");
			
			//clear the Variable Type name field
			PrefixVariableType_Field.clear();
			
			PrefixVariableType_Field.sendKeys(RandomStringUtils.randomNumeric(2));
			Thread.sleep(1000);
		}
		
		//Click the up arrow button of PLU start position
		UpArrowOfPLUStartPosition_NewBarCode.click();
		
		String u1 =  PLUStartPosition_Field.getAttribute("value");
		
		int i1 = Integer.parseInt(u1);
		
		if(i1 == 1)
		{
			test.log(LogStatus.PASS, "Increase the value of PLU Start Position is working fine when user click it initially then it is displayed 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of PLU Start Position is not working fine when user click it");
		}
		
		//click the down arrow button
		DownArrowOfPLUStartPosition_NewBarCode.click();
		
		String u2 =  PLUStartPosition_Field.getAttribute("value");
		
		int i2 = Integer.parseInt(u2);
		
		if(i2 == (i1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of PLU Start Position is working fine when user click it then it is decreased by 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of PLU Start Position is not working fine when user click it");
		}
		
		try
		{
			if(driver.findElement(By.xpath("//mat-hint[contains(.,'Enter PLU Start Position')]")).isDisplayed())
			{
		
				String w1 = driver.findElement(By.xpath("//mat-hint[contains(.,'Enter PLU Start Position')]")).getText();
		
				//Verify the field validation message
				if(w1.equals("Enter PLU Start Position"))
				{
					test.log(LogStatus.PASS, "Enter PLU Start Position field validation message is displayed when user enter invalid PLU start position");
				}
				else
				{
					test.log(LogStatus.FAIL, "Enter PLU Start Position field validation message is not displayed when user enter invalid PLU start position");
				}
			}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Enter PLU Start Position field validation Pop Up is not displayed when user enter invalid PLU start position");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//click the down arrow button
		DownArrowOfPLUStartPosition_NewBarCode.click();
		
		String u3 =  PLUStartPosition_Field.getAttribute("value");
		
		int i3 = Integer.parseInt(u3);
		
		if(i3 == (i1-1))
		{
			test.log(LogStatus.PASS, "The PLU start position is not decreasing when start position is already in 0");
		}
		else
		{
			test.log(LogStatus.FAIL, "The PLU start position is decreasing when start position is already in 0");
		}
		
		PLUStartPosition_Field.sendKeys("e");
		
		String u4 =  PLUStartPosition_Field.getAttribute("value");
		
		if(u4.equals("0e"))
		{
			test.log(LogStatus.FAIL, "The PLU start position accept the Alphabets");
		}
		else
		{
			test.log(LogStatus.PASS, "The PLU start position is not accept the Alphabets");
		}
		
		PLUStartPosition_Field.sendKeys(Keys.ARROW_DOWN);
		
		String u5 =  PLUStartPosition_Field.getAttribute("value");
		
		int i5 = Integer.parseInt(u5);
		
		if(i5 == (i1-2))
		{
			test.log(LogStatus.PASS, "The PLU start position field accept the negative values");
		}
		else
		{
			test.log(LogStatus.FAIL, "The PLU start position field is not accept the negative values");
		}
		
		//Click the up arrow button of PLU start position
		UpArrowOfPLUStartPosition_NewBarCode.click();
				
		//Click the up arrow button of PLU start position
		UpArrowOfPLUStartPosition_NewBarCode.click();
		/////////////////////////////////////////////////////////////////////////////////////////////////
		//Click the up arrow button of PLU start position
		UpArrowOfPLUNumberOfDigits_NewBarCode.click();
		
		String a1 =  PLUNumOfDigits_Field.getAttribute("value");
		
		int b1 = Integer.parseInt(a1);
		
		if(b1 == 1)
		{
			test.log(LogStatus.PASS, "Increase the value of PLU Number of Digits is working fine when user click it initially then it is displayed 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of PLU Number of Digits is not working fine when user click it");
		}
		
		//click the down arrow button
		DownArrowOfPLUNumberOfDigits_NewBarCode.click();
		
		String a2 =  PLUNumOfDigits_Field.getAttribute("value");
		
		int b2 = Integer.parseInt(a2);
		
		if(b2 == (b1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of PLU Number of Digits is working fine when user click it then it is decreased by 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of PLU Number of Digits is not working fine when user click it");
		}
		
		try
		{
			if(driver.findElement(By.xpath("//mat-hint[contains(.,'Enter PLU No Digits')]")).isDisplayed())
			{
				
		
				String c1 = driver.findElement(By.xpath("//mat-hint[contains(.,'Enter PLU No Digits')]")).getText();
		
				//Verify the field validation message
				if(c1.equals("Enter PLU No Digits"))
				{
					test.log(LogStatus.PASS, "Enter PLU Number of Digits field validation message is displayed when user enter invalid PLU Number of Digits");
				}
				else
				{
					test.log(LogStatus.FAIL, "Enter PLU Number of Digits field validation message is not displayed when user enter invalid PLU Number of Digits");
				}
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.FAIL, "Enter PLU Number of Digits field validation Pop Up is not displayed when user enter invalid PLU Number of Digits");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		//click the down arrow button
		DownArrowOfPLUNumberOfDigits_NewBarCode.click();
		
		String a3 =  PLUNumOfDigits_Field.getAttribute("value");
		
		int b3 = Integer.parseInt(a3);
		
		if(b3 == (b1-1))
		{
			test.log(LogStatus.PASS, "The PLU Number of Digits is not decreasing when PLU Number of Digits is already in 0");
		}
		else
		{
			test.log(LogStatus.FAIL, "The PLU Number of Digits is decreasing when PLU Number of Digits is already in 0");
		}
		
		PLUNumOfDigits_Field.sendKeys("e");
		
		String c4 =  PLUStartPosition_Field.getAttribute("value");
		
		if(c4.equals("0e"))
		{
			test.log(LogStatus.PASS, "The PLU Number of Digits accept the Alphabets");
		}
		else
		{
			test.log(LogStatus.FAIL, "The PLU Number of Digits is not accept the Alphabets");
		}
		
		PLUNumOfDigits_Field.sendKeys(Keys.ARROW_DOWN);
		
		String a5 =  PLUStartPosition_Field.getAttribute("value");
		
		int b5 = Integer.parseInt(a5);
		
		if(b5 == (b1-2))
		{
			test.log(LogStatus.PASS, "The PLU Number of Digits field accept the negative values");
		}
		else
		{
			test.log(LogStatus.FAIL, "The PLU Number of Digits field is not accept the negative values");
		}
		
		//Click the up arrow button of PLU number of digits
		UpArrowOfPLUNumberOfDigits_NewBarCode.click();
				
		//Click the up arrow button of PLU number of digits
		UpArrowOfPLUNumberOfDigits_NewBarCode.click();
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
		//Click the weight button
		Weight_Field_NewBarCode.click();
		
		//Click the up arrow button of Price start position
		UpArrowOfWeightStartPosition_NewBarCode.click();
		
		String ua1 =  WeightStartPosition_Field.getAttribute("value");
		
		int ia1 = Integer.parseInt(ua1);
		
		if(ia1 == 1)
		{
			test.log(LogStatus.PASS, "Increase the value of Weight Start Position is working fine when user click it initially then it is displayed 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of Weight Start Position is not working fine when user click it");
		}
		
		//click the down arrow button
		DownArrowOfWeightStartPosition_NewBarCode.click();
		
		String ua2 =  WeightStartPosition_Field.getAttribute("value");
		
		int ia2 = Integer.parseInt(ua2);
		
		if(ia2 == (ia1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of Weight Start Position is working fine when user click it then it is decreased by 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of Weight Start Position is not working fine when user click it");
		}
		
		/*
		 * String wa1 = driver.findElement(By.
		 * xpath("//mat-hint[contains(.,'Enter Price Start Position')]")).getText();
		 * 
		 * //Verify the field validation message
		 * if(wa1.equals("Enter Price Start Position")) { test.log(LogStatus.PASS,
		 * "Enter Price Start Position field validation message is displayed when user enter invalid Price start position"
		 * ); } else { test.log(LogStatus.FAIL,
		 * "Enter Price Start Position field validation message is not displayed when user enter invalid Price start position"
		 * ); }
		 */
		
		//click the down arrow button
		DownArrowOfWeightStartPosition_NewBarCode.click();
		
		String ua3 =  WeightStartPosition_Field.getAttribute("value");
		
		int ia3 = Integer.parseInt(ua3);
		
		if(ia3 == (ia1-1))
		{
			test.log(LogStatus.PASS, "The Weight start position is not decreasing when start position is already in 0");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Weight start position is decreasing when start position is already in 0");
		}
		
		WeightStartPosition_Field.sendKeys("e");
		
		String ua4 =  WeightStartPosition_Field.getAttribute("value");
		
		if(ua4.equals("0e"))
		{
			test.log(LogStatus.PASS, "The Weight start position accept the Alphabets");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Weight start position is not accept the Alphabets");
		}
		
		WeightStartPosition_Field.sendKeys(Keys.ARROW_DOWN);
		
		String ua5 =  WeightStartPosition_Field.getAttribute("value");
		
		int ia5 = Integer.parseInt(ua5);
		
		if(ia5 == (ia1-2))
		{
			test.log(LogStatus.PASS, "The Weight start position field accept the negative values");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Weight start position field is not accept the negative values");
		}
		
		//Click the up arrow button of Price start position
		UpArrowOfWeightStartPosition_NewBarCode.click();
				
		//Click the up arrow button of Price start position
		UpArrowOfWeightStartPosition_NewBarCode.click();
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Click the up arrow button of PLU start position
		UpArrowOfWeightNumberOfDigits_NewBarCode.click();
		
		String d1 =  WeightNumOfDigits_Field.getAttribute("value");
		
		int e1 = Integer.parseInt(d1);
		
		if(e1 == 1)
		{
			test.log(LogStatus.PASS, "Increase the value of Weight Number of Digits is working fine when user click it initially then it is displayed 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of Weight Number of Digits is not working fine when user click it");
		}
		
		//click the down arrow button
		DownArrowOfWeightNumberOfDigits_NewBarCode.click();
		
		String d2 =  WeightNumOfDigits_Field.getAttribute("value");
		
		int e2 = Integer.parseInt(d2);
		
		if(e2 == (e1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of Weight Number of Digits is working fine when user click it then it is decreased by 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of Weight Number of Digits is not working fine when user click it");
		}
		
		/*
		 * String f1 =
		 * driver.findElement(By.xpath("//mat-hint[contains(.,'Enter Price No Digits')]"
		 * )).getText();
		 * 
		 * //Verify the field validation message if(f1.equals("Enter Price No Digits"))
		 * { test.log(LogStatus.PASS,
		 * "Enter Price Number of Digits field validation message is displayed when user enter invalid Price Number of Digits"
		 * ); } else { test.log(LogStatus.FAIL,
		 * "Enter Price Number of Digits field validation message is not displayed when user enter invalid Price Number of Digits"
		 * ); }
		 */
		
		//click the down arrow button
		DownArrowOfWeightNumberOfDigits_NewBarCode.click();
		
		String d3 =  WeightNumOfDigits_Field.getAttribute("value");
		
		int e3 = Integer.parseInt(d3);
		
		if(e3 == (e1-1))
		{
			test.log(LogStatus.PASS, "The Weight Number of Digits is not decreasing when Price Number of Digits is already in 0");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Weight Number of Digits is decreasing when Price Number of Digits is already in 0");
		}
		
		WeightNumOfDigits_Field.sendKeys("e");
		
		String f4 =  WeightStartPosition_Field.getAttribute("value");
		
		if(f4.equals("0e"))
		{
			test.log(LogStatus.PASS, "The Weight Number of Digits accept the Alphabets");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Weight Number of Digits is not accept the Alphabets");
		}
		
		WeightNumOfDigits_Field.sendKeys(Keys.ARROW_DOWN);
		
		String d4 =  WeightStartPosition_Field.getAttribute("value");
		
		int e5 = Integer.parseInt(d4);
		
		if(e5 == (e1-2))
		{
			test.log(LogStatus.PASS, "The Weight Number of Digits field accept the negative values");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Weight Number of Digits field is not accept the negative values");
		}
		
		//Click the up arrow button of Price number of digits
		UpArrowOfWeightNumberOfDigits_NewBarCode.click();
				
		//Click the up arrow button of Price number of digits
		UpArrowOfWeightNumberOfDigits_NewBarCode.click();

	}

	
	public void checkWithWeightPosition()
	{
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Click the up arrow button of Weight start position
		UpArrowOfWeightStartPosition_NewBarCode.click();
		
		String ub1 =  WeightStartPosition_Field.getAttribute("value");
		
		int ib1 = Integer.parseInt(ub1);
		
		if(ib1 == 1)
		{
			test.log(LogStatus.PASS, "Increase the value of Weight Start Position is working fine when user click it initially then it is displayed 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of Weight Start Position is not working fine when user click it");
		}
		
		//click the down arrow button
		DownArrowOfWeightStartPosition_NewBarCode.click();
		
		String ub2 =  WeightStartPosition_Field.getAttribute("value");
		
		int ib2 = Integer.parseInt(ub2);
		
		if(ib2 == (ib1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of Weight Start Position is working fine when user click it then it is decreased by 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of Weight Start Position is not working fine when user click it");
		}
		
		try
		{
			
			if(driver.findElement(By.xpath("//mat-hint[contains(.,'Enter Weight Start Position')]")).isDisplayed())
			{
			
		
				String wb1 = driver.findElement(By.xpath("//mat-hint[contains(.,'Enter Weight Start Position')]")).getText();
		
				//Verify the field validation message
				if(wb1.equals("Enter Weight Start Position"))
				{
					test.log(LogStatus.PASS, "Enter Weight Start Position field validation message is displayed when user enter invalid Weight start position");
				}
				else
				{
					test.log(LogStatus.FAIL, "Enter Weight Start Position field validation message is not displayed when user enter invalid Weight start position");
				}
			}
		}
		catch(Exception p)
		{
			test.log(LogStatus.FAIL, "Enter Weight Start Position field validation Pop Up is not displayed when user enter invalid Weight start position");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//click the down arrow button
		DownArrowOfWeightStartPosition_NewBarCode.click();
		
		String ub3 =  WeightStartPosition_Field.getAttribute("value");
		
		int ib3 = Integer.parseInt(ub3);
		
		if(ib3 == (ib1-1))
		{
			test.log(LogStatus.PASS, "The Weight start position is not decreasing when start position is already in 0");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Weight start position is decreasing when start position is already in 0");
		}
		
		WeightStartPosition_Field.sendKeys("e");
		
		String ub4 =  WeightStartPosition_Field.getAttribute("value");
		
		if(ub4.equals("0e"))
		{
			test.log(LogStatus.PASS, "The Weight start position accept the Alphabets");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Weight start position is not accept the Alphabets");
		}
		
		WeightStartPosition_Field.sendKeys(Keys.ARROW_DOWN);
		
		String ub5 =  WeightStartPosition_Field.getAttribute("value");
		
		int ib5 = Integer.parseInt(ub5);
		
		if(ib5 == (ib1-2))
		{
			test.log(LogStatus.PASS, "The Weight start position field accept the negative values");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Weight start position field is not accept the negative values");
		}
		
		//Click the up arrow button of Price start position
		UpArrowOfWeightStartPosition_NewBarCode.click();
				
		//Click the up arrow button of Price start position
		UpArrowOfWeightStartPosition_NewBarCode.click();
		
		/////////////////////////////////////////////////////////////////////////////////////////////////
		
		//Click the up arrow button of PLU start position
		UpArrowOfWeightNumberOfDigits_NewBarCode.click();
		
		String dc1 =  WeightNumOfDigits_Field.getAttribute("value");
		
		int ec1 = Integer.parseInt(dc1);
		
		if(ec1 == 1)
		{
			test.log(LogStatus.PASS, "Increase the value of Weight Number of Digits is working fine when user click it initially then it is displayed 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of Weight Number of Digits is not working fine when user click it");
		}
		
		//click the down arrow button
		DownArrowOfWeightNumberOfDigits_NewBarCode.click();
		
		String dc2 =  WeightNumOfDigits_Field.getAttribute("value");
		
		int ec2 = Integer.parseInt(dc2);
		
		if(ec2 == (ec1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of Weight Number of Digits is working fine when user click it then it is decreased by 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of Weight Number of Digits is not working fine when user click it");
		}
		
		try
		{
			if(driver.findElement(By.xpath("//mat-hint[contains(.,'Enter Weight No Digits')]")).isDisplayed())
			{
		
		
				String fc1 = driver.findElement(By.xpath("//mat-hint[contains(.,'Enter Weight No Digits')]")).getText();
		
				//Verify the field validation message
				if(fc1.equals("Enter Weight No Digits"))
				{
					test.log(LogStatus.PASS, "Enter Weight Number of Digits field validation message is displayed when user enter invalid Weight Number of Digits");
				}
				else
				{
					test.log(LogStatus.FAIL, "Enter Weight Number of Digits field validation message is not displayed when user enter invalid Weight Number of Digits");
				}
			}
		}
		catch(Exception o)
		{
			test.log(LogStatus.FAIL, "Enter Weight Number of Digits field validation message is not displayed when user enter invalid Weight Number of Digits");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		//click the down arrow button
		DownArrowOfWeightNumberOfDigits_NewBarCode.click();
		
		String dc3 =  WeightNumOfDigits_Field.getAttribute("value");
		
		int ec3 = Integer.parseInt(dc3);
		
		if(ec3 == (ec1-1))
		{
			test.log(LogStatus.PASS, "The Weight Number of Digits is not decreasing when Weight Number of Digits is already in 0");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Weight Number of Digits is decreasing when Weight Number of Digits is already in 0");
		}
		
		WeightNumOfDigits_Field.sendKeys("e");
		
		String fc4 =  WeightStartPosition_Field.getAttribute("value");
		
		if(fc4.equals("0e"))
		{
			test.log(LogStatus.PASS, "The Weight Number of Digits accept the Alphabets");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Weight Number of Digits is not accept the Alphabets");
		}
		
		WeightNumOfDigits_Field.sendKeys(Keys.ARROW_DOWN);
		
		String dc4 =  WeightStartPosition_Field.getAttribute("value");
		
		int ec5 = Integer.parseInt(dc4);
		
		if(ec5 == (ec1-2))
		{
			test.log(LogStatus.PASS, "The Weight Number of Digits field accept the negative values");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Weight Number of Digits field is not accept the negative values");
		}
		
		//Click the up arrow button of Weight number of digits
		UpArrowOfWeightNumberOfDigits_NewBarCode.click();
				
		//Click the up arrow button of Weight number of digits
		UpArrowOfWeightNumberOfDigits_NewBarCode.click();
	}
	
	public void verifyTheValidationMessage() throws InterruptedException {
		verifyUpArrowOfPLUStartPosition();
		
		//Click the Save button
		SaveBtn_NewBarCode.click();
		
		Thread.sleep(1000);
		
		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s.equals("Please Enter Name"))
		{
			test.log(LogStatus.PASS, "Please Enter Name warning message is displayed when user click the Save button without Variable Type Name");
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Name warning message is not displayed when user click the Save button without Variable Type Name");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(2000);
		
		VariableTypeName_Field.sendKeys(RandomStringUtils.randomAlphanumeric(26));
		
		Thread.sleep(2000);
		
		//get the value of entered string
		String s1 = VariableTypeName_Field.getAttribute("value");
		
		if(s1.length() <= 25)
		{
			test.log(LogStatus.PASS, "Variable Type name field accept only 25 characters");
		}
		else if(s1.length() > 25)
		{
			test.log(LogStatus.FAIL, "Variable Type name field accept more than 25 characters");
			
			//clear the Variable Type name field
			VariableTypeName_Field.clear();
			
			VariableTypeName_Field.sendKeys(RandomStringUtils.randomAlphanumeric(5));
			Thread.sleep(1000);
		}
		
		//Click the Save button
		SaveBtn_NewBarCode.click();
		
		Thread.sleep(1000);
		
		String s2 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s2.equals("Please Enter Valid Prefix"))
		{
			test.log(LogStatus.PASS, "Please Enter Valid Prefix warning message is displayed when user click the Save button without Prefix Variable Type");
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Valid Prefix warning message is not displayed when user click the Save button without Prefix Variable Type");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(2000);
		
		PrefixVariableType_Field.sendKeys(RandomStringUtils.randomNumeric(3));
		
		Thread.sleep(2000);
		
		//get the value of entered string
		String s3 = PrefixVariableType_Field.getAttribute("value");
		
		if(s3.length() <= 2)
		{
			test.log(LogStatus.PASS, "Prefix Variable Type field accept only 2 characters");
		}
		else if(s3.length() > 2)
		{
			test.log(LogStatus.FAIL, "Prefix Variable Type field accept more than 2 characters");
			
			//clear the Variable Type name field
			PrefixVariableType_Field.clear();
			
			PrefixVariableType_Field.sendKeys(RandomStringUtils.randomNumeric(2));
			Thread.sleep(1000);
		}
		
		//Click the Save button
		SaveBtn_NewBarCode.click();
		
		Thread.sleep(1000);
		
		String s4 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s4.equals("Please Enter Valid PLU No. of Digits"))
		{
			test.log(LogStatus.PASS, "Please Enter Valid PLU No. of Digits warning message is displayed when user click the Save button without PLU Number Of Digits");
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Valid PLU No. of Digits warning message is not displayed when user click the Save button without PLU Number Of Digits");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(2000);
		
	}
	
	public void verifyUpArrowOfPLUStartPosition() throws InterruptedException {
				
		String s =  UpArrowOfPLUStartPosition_NewBarCode.getAttribute("value");
		
		s = s.trim();
		
		if(s.equals("PLU Start Position"))
		{
			//Click the up arrow button of PLU start position
			UpArrowOfPLUStartPosition_NewBarCode.click();
			
			String s1 =  UpArrowOfPLUStartPosition_NewBarCode.getAttribute("value");
			
			int i1 = Integer.parseInt(s1);
			
			if(i1 == 0)
			{
				test.log(LogStatus.PASS, "Increase the value of PLU Start Position is working fine when user click it initially then it is displayed 1");
			}
			else
			{
				test.log(LogStatus.FAIL, "Increase the value of PLU Start Position is not working fine when user click it");
			}
		}
		else
		{
			int i = Integer.parseInt(s);
			
			int m = i + 1;
			
			//Click the up arrow button of PLU start position
			UpArrowOfPLUStartPosition_NewBarCode.click();
			
			String s1 =  UpArrowOfPLUStartPosition_NewBarCode.getAttribute("value");
			
			int i1 = Integer.parseInt(s1);
			
			if(i1 == m)
			{
				test.log(LogStatus.PASS, "Increase the value of PLU Start Position is working fine when user click it initially then it is decrease by 1");
			}
			else
			{
				test.log(LogStatus.FAIL, "Increase the value of PLU Start Position is not working fine when user click it");
			}
		}
	}
	
	public void verifyDownArrowOfPLUStartPosition() throws InterruptedException {
				
		String s =  DownArrowOfPLUStartPosition_NewBarCode.getAttribute("value");
		
		s = s.trim();
		
		if(s.equals("PLU Start Position"))
		{
			//Click the up arrow button of PLU start position
			DownArrowOfPLUStartPosition_NewBarCode.click();
			
			String s1 =  DownArrowOfPLUStartPosition_NewBarCode.getAttribute("value");
			
			int i1 = Integer.parseInt(s1);
			
			if(i1 == 0)
			{
				test.log(LogStatus.PASS, "Decrease the value of PLU Start Position is working fine when user click it initially then it is displayed 0");
			}
			else
			{
				test.log(LogStatus.FAIL, "Decrease the value of PLU Start Position is not working fine when user click it");
			}
		}
		else
		{
			int i = Integer.parseInt(s);
			
			int m = i - 1;
			
			//Click the up arrow button of PLU start position
			DownArrowOfPLUStartPosition_NewBarCode.click();
			
			String s1 =  DownArrowOfPLUStartPosition_NewBarCode.getAttribute("value");
			
			int i1 = Integer.parseInt(s1);
			
			if(i1 == m)
			{
				test.log(LogStatus.PASS, "Decrease the value of PLU Start Position is working fine when user click it initially then it is decrease by 1");
			}
			else
			{
				test.log(LogStatus.FAIL, "Decrease the value of PLU Start Position is not working fine when user click it");
			}
		}
		

	}
	
	public void verifyAddNewScaleBarcode_Visibility() throws InterruptedException {
		//Verify the New Scale Bar code in Add New Bar code pop-up
		if(NewScaleBarCode_Heading.isDisplayed())
		{
			test.log(LogStatus.PASS, "New Scale Barcode heading is available when user click the Add New Barcode button");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Scale Barcode heading is not available when user click the Add New Barcode button");
		}
		
		//Verify the Variable Type Name in Add New Bar code pop-up
		if(VariableTypeName_Field.isDisplayed())
		{
			test.log(LogStatus.PASS, "Variable Type field is available when user click the Add New Barcode button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Variable Type field is not available when user click the Add New Barcode button");
		}
		
		//Verify the Prefix/Variable Type in Add New Bar code pop-up
		if(PrefixVariableType_Field.isDisplayed())
		{
			test.log(LogStatus.PASS, "Prefix/Variable Type field is available when user click the Add New Barcode button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Prefix/Variable Type field is not available when user click the Add New Barcode button");
		}
		
		//Verify the PLU Start Position in Add New Bar code pop-up
		if(PLUStartPosition_Field.isDisplayed())
		{
			test.log(LogStatus.PASS, "PLU Start Position field is available when user click the Add New Barcode button");
		}
		else
		{
			test.log(LogStatus.FAIL, "PLU Start Position field is not available when user click the Add New Barcode button");
		}
		
		//Verify the PLU Number Of Digits Field in Add New Bar code pop-up
		if(PLUNumOfDigits_Field.isDisplayed())
		{
			test.log(LogStatus.PASS, "PLU Num Of Digits field is available when user click the Add New Barcode button");
		}
		else
		{
			test.log(LogStatus.FAIL, "PLU Num Of Digits field is not available when user click the Add New Barcode button");
		}
		
		//Verify the Set Scale By Field in Add New Bar code pop-up
		if(SetScaleBy_Field.isDisplayed())
		{
			test.log(LogStatus.PASS, "Set Scale By field is available when user click the Add New Barcode button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Set Scale By field is not available when user click the Add New Barcode button");
		}
		
		//Verify the Price Field in Add New Bar code pop-up
		if(Price_Field_NewBarCode.isDisplayed())
		{
			test.log(LogStatus.PASS, "Price field is available when user click the Add New Barcode button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Price field is not available when user click the Add New Barcode button");
		}
		
		//Verify the Weight Field in Add New Bar code pop-up
		if(Weight_Field_NewBarCode.isDisplayed())
		{
			test.log(LogStatus.PASS, "Weight field is available when user click the Add New Barcode button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Weight field is not available when user click the Add New Barcode button");
		}
		
		/*
		 * //Verify the Price/Weight Start Position and Price/Weight Number of Digits
		 * fields in Add New Bar code pop-up
		 * if(PriceORWeight_InputField_NewBarCode.isDisplayed()) {
		 * test.log(LogStatus.PASS,
		 * "Price/Weight Start Position and Price/Weight Number of Digits fields are available when user click the Add New Barcode button"
		 * ); } else { test.log(LogStatus.FAIL,
		 * "Price/Weight Start Position and Price/Weight Number of Digits fields are not available when user click the Add New Barcode button"
		 * ); }
		 * 
		 * //Verify the Cancel in Add New Bar code pop-up
		 * if(CancelBtn_NewBarCode.isDisplayed()) { test.log(LogStatus.PASS,
		 * "Cancel button is available when user click the Add New Barcode button"); }
		 * else { test.log(LogStatus.FAIL,
		 * "Cancel button is not available when user click the Add New Barcode button");
		 * }
		 */
		
		//Verify the Save button in Add New Bar code pop-up
		if(SaveBtnDisabled_NewBarCode.isDisplayed())
		{
			test.log(LogStatus.PASS, "Disabled Save button is available when user click the Add New Barcode button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Disabled Save button is not available when user click the Add New Barcode button");
		}
	}
	
	public void verifyTheAllColumns_Visibility() throws InterruptedException {
		//Verify the Name column
		if(NameColumn.isDisplayed())
		{
			test.log(LogStatus.PASS, "Name Column is displayed, when user reach the Scales page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Name Column is not displayed, when user reach the Scales page");
		}
		
		//Verify the Prefix Variable Type column
		if(PrefixVariableTypeColumn.isDisplayed())
		{
			test.log(LogStatus.PASS, "Prefix Variable Type Column is displayed, when user reach the Scales page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Prefix Variable Type Column is not displayed, when user reach the Scales page");
		}
		
		//Verify the PLU Code column
		if(PLUCodeColumn.isDisplayed())
		{
			test.log(LogStatus.PASS, "PLU Code Column is displayed, when user reach the Scales page");
		}
		else
		{
			test.log(LogStatus.FAIL, "PLU Code Column is not displayed, when user reach the Scales page");
		}
		
		//Verify the Price Details column
		if(PriceDetailsColumn.isDisplayed())
		{
			test.log(LogStatus.PASS, "Price Details Column is displayed, when user reach the Scales page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Price Details Column is not displayed, when user reach the Scales page");
		}
		
		//Verify the Weight Details column
		if(WeightDetailsColumn.isDisplayed())
		{
			test.log(LogStatus.PASS, "Weight Details Column is displayed, when user reach the Scales page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Weight Details Column is not displayed, when user reach the Scales page");
		}
		
		//Verify the Actions column
		if(ActionsColumn.isDisplayed())
		{
			test.log(LogStatus.PASS, "Actions Column is displayed, when user reach the Scales page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Actions Column is not displayed, when user reach the Scales page");
		}
	}
	
	public void verifyNewScaleBarCodeBtn_Visibility() throws InterruptedException {
		//Verify the new scale add btn field visibility
		if(NewScaleBarCode_Btn.isDisplayed())
		{
			test.log(LogStatus.PASS, "New Scale Barcode button is displayed, when user reach the Scales page");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Scale Barcode button is not displayed, when user reach the Scales page");
		}
	}
	
	public void verifyColumnField_Visibility() throws InterruptedException {
		//Verify the Column field visibility
		if(Column_option.isDisplayed())
		{
			test.log(LogStatus.PASS, "Column field is displayed, when user reach the Scales page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Column field is not displayed, when user reach the Scales page");
		}
	}
	
	public void verifySearchField_Visibility() throws InterruptedException {
		//Verify the search field visibility
		if(Search_option.isDisplayed())
		{
			test.log(LogStatus.PASS, "Search field is displayed, when user reach the Scales page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Search field is not displayed, when user reach the Scales page");
		}
	}
	
	public void verifyActiveBtn_Visibility() throws InterruptedException {
		//Verify the Active button visibility
		if(Active_Btn.isDisplayed())
		{
			test.log(LogStatus.PASS, "Active button is displayed, when user reach the Scales page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Active button is not displayed, when user reach the Scales page");
		}
	}
	
	public void verifyScalesHeading_Visibility() throws InterruptedException {
		
		Thread.sleep(2000);
		//Verify the Scales heading visibility
		if(Scales.isDisplayed())
		{
			test.log(LogStatus.PASS, "Scales heading is displayed, when user reach the Scales page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Scales heading is not displayed, when user reach the Scales page");
		}
	}
	
/*	public void paginationValidation() throws Exception {
		
		//get the total number of pages
		List<WebElement> s = driver.findElements(By.xpath("//div[@class='col-auto ng-star-inserted']/button"));
				
		if(s.size() == 1)
		{
			//Rows count
			List<WebElement> d = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));

			if(d.size() <= 5) {
				test.log(LogStatus.PASS, "5 rows are displayed when user select the 5 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "5 rows are not displayed when user select the 5 rows per page option");
			}
		}
		else if(s.size() == 2) {
			Thread.sleep(2000);
			//Rows count
			List<WebElement> d = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));

			if(d.size() <= 5) {
				test.log(LogStatus.PASS, "5 rows are displayed when user select the 5 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "5 rows are not displayed when user select the 5 rows per page option");
			}
			
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 10 from the option
			tenRows_Option.click();
			
			//Rows count
			List<WebElement> d1 = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));
			Thread.sleep(1000);
			
			if(d1.size() <= 10 && d1.size() > 5) {
				test.log(LogStatus.PASS, "10 rows are displayed when user select the 10 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "10 rows are not displayed when user select the 10 rows per page option");
			}
		}
		else if(s.size() == 3) {
			Thread.sleep(2000);
			//Rows count
			List<WebElement> d = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));

			if(d.size() <= 5) {
				test.log(LogStatus.PASS, "5 rows are displayed when user select the 5 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "5 rows are not displayed when user select the 5 rows per page option");
			}
			
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 10 from the option
			tenRows_Option.click();
			
			//Rows count
			List<WebElement> d1 = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));
			Thread.sleep(1000);
			
			if(d1.size() <= 10 && d1.size() > 5) {
				test.log(LogStatus.PASS, "10 rows are displayed when user select the 10 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "10 rows are not displayed when user select the 10 rows per page option");
			}
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 15 from the option
			fifteenRows_Option.click();
			
			//Rows count
			List<WebElement> d2 = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));
			Thread.sleep(1000);
			
			if(d2.size() <= 15 && d2.size() > 10) {
				test.log(LogStatus.PASS, "15 rows are displayed when user select the 15 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "15 rows are not displayed when user select the 15 rows per page option");
			}
		}	
		else{
			Thread.sleep(2000);
			//Rows count
			List<WebElement> d = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));

			if(d.size() <= 5) {
				test.log(LogStatus.PASS, "5 rows are displayed when user select the 5 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "5 rows are not displayed when user select the 5 rows per page option");
			}
			
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 10 from the option
			tenRows_Option.click();
			
			//Rows count
			List<WebElement> d1 = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));
			Thread.sleep(1000);
			
			if(d1.size() <= 10 && d1.size() > 5) {
				test.log(LogStatus.PASS, "10 rows are displayed when user select the 10 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "10 rows are not displayed when user select the 10 rows per page option");
			}
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 15 from the option
			fifteenRows_Option.click();
			
			//Rows count
			List<WebElement> d2 = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));
			Thread.sleep(1000);
			
			if(d2.size() <= 15 && d2.size() > 10) {
				test.log(LogStatus.PASS, "15 rows are displayed when user select the 15 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "15 rows are not displayed when user select the 15 rows per page option");
			}
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 20 from the option
			twentyRows_Option.click();
			
			//Rows count
			List<WebElement> d3 = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));
			Thread.sleep(1000);
			
			if(d3.size() <= 20 && d3.size() > 15) {
				test.log(LogStatus.PASS, "20 rows are displayed when user select the 20 rows per page option");
			}
			else {
				test.log(LogStatus.FAIL, "20 rows are not displayed when user select the 20 rows per page option");
			}
		}	
		
		
	}
*/
	public void Ascending_And_Descending_Order() {
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
				List<WebElement> Lst=driver.findElements(By.xpath("//div[contains(@id,'cdk-drop-list')]/div/data-grid-row/div/div["+i+"]"));
				
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
	
	
	public void Filter_Columns() throws Exception
	{
		Thread.sleep(3000);
		Column_option.click();
		
		//Deselect Select All
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div[1]/select-option")).click();
		Thread.sleep(500);
		
		Thread.sleep(1000);
		List<WebElement> FilterList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
				
		for(int i = 2; i <= FilterList.size(); i++)
		{
			driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+i+"]/select-option")).click();
			
			if(driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[1]/div/span")).getText().equalsIgnoreCase(driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+i+"]/select-option/div")).getText()))
				
			{
				test.log(LogStatus.PASS, driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+i+"]/select-option/div")).getText()+ " Filtered Successfully");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+i+"]/select-option/div")).getText()+ " Filter Unsuccessful. Wrongly filtered as "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[1]/div/span")).getText());
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
			driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+i+"]/select-option")).click();
		}
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div[1]/select-option")).click();
		Thread.sleep(3000);
		Column_option.click();Thread.sleep(3000);
	}
	
	public void search() throws InterruptedException {
		
		Search_option.clear();
		Thread.sleep(15000);
		
		//Get the value from the table
		String sa = driver.findElement(By.xpath("//data-grid/div//div[1]/div[1]/data-grid-row/div/div[1]/span")).getText();
		
		List<WebElement> qw = driver.findElements(By.xpath("//data-grid/div/div[3]/div[1]/data-grid-row/div/div/span"));
	
		Search_option.sendKeys(sa);
		
		Thread.sleep(5000);
		
		List<WebElement> qw1 = driver.findElements(By.xpath("//data-grid/div/div[3]/div[1]/data-grid-row/div/div/span"));
		
		//Get the value from the table
		String sa1 = driver.findElement(By.xpath("//data-grid/div//div[1]/div[1]/data-grid-row/div/div[1]/span")).getText();

		if(sa.equals(sa1))
		{
			test.log(LogStatus.PASS, "The searched result was displayed successfully for the respective keyword");
			if(qw.size() == qw1.size()) {
				test.log(LogStatus.PASS, "All the required field values are displayed after searching");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "All the required field values are not displayed after searching");
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		else {
			test.log(LogStatus.PASS, "The searched result was not displayed successfully for the respective keyword");
		}
		
		Search_option.clear();
		
		Back_btn.click();
		
		Thread.sleep(5000);
		
		Addons.click();
		
		Thread.sleep(5000);
		
		Scale.click();
		
		Thread.sleep(10000);
	}
	
	public void delete() throws InterruptedException {
		
		Search_option.clear();
		Thread.sleep(15000);
		
		//Get the value from the table
		String sa = driver.findElement(By.xpath("//data-grid/div//div[1]/div[1]/data-grid-row/div/div[1]/span")).getText();
		
		Delete_btn_FirstRow.click();
		
		if(driver.findElement(By.xpath("//h4[.='Delete']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Delete Confirmation popup is displayed, while click the delete button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Delete Confirmation popup is not displayed, while click the delete button");
		}
		Thread.sleep(2000);
		Close_btn.click();
		Thread.sleep(2000);
		Delete_btn_FirstRow.click();
		
		if(driver.findElement(By.xpath("//h4[.='Delete']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Delete Confirmation popup is displayed, while click the delete button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Delete Confirmation popup is not displayed, while click the delete button");
		}
		Thread.sleep(2000);
		Cancel_btn.click();
		Thread.sleep(2000);
		Delete_btn_FirstRow.click();Thread.sleep(1000);
		
		if(driver.findElement(By.xpath("//h4[.='Delete']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Delete Confirmation popup is displayed, while click the delete button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Delete Confirmation popup is not displayed, while click the delete button");
		}
		
		Delete_btn.click();
		Thread.sleep(2000);
		
		String s1 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		Thread.sleep(500);
		//Check whether the error message is displayed
		if(s1.equals("Barcode Setting Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Barcode Setting Inactivated Successfully message is displayed when user delete the scale barcode");
		}
		else
		{
			test.log(LogStatus.FAIL, "Barcode Setting Inactivated Successfully message is not displayed when user delete the scale barcode");
		}
		
		//Click the close button of warning message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		
		Thread.sleep(5000);

		Search_option.sendKeys(sa);
		
		Thread.sleep(5000);
		
		if(driver.findElement(By.xpath("//div/span[.='Scales not found']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Scales not found message is displayed, when user delete the particular scale");
		}
		else {
			test.log(LogStatus.FAIL, "Scales is found, when user delete the particular scale");
		}
		
		
		Search_option.clear();
		
		Back_btn.click();
		
		Thread.sleep(5000);
		
		Addons.click();
		
		Thread.sleep(5000);
		
		Scale.click();
		
		Thread.sleep(10000);
		
		//Click the active button
		driver.findElement(By.xpath("//span[contains(.,'Active')]")).click();
		Thread.sleep(5000);
		
		if(Activate_Btn.isDisplayed()) {
			test.log(LogStatus.PASS, "Scales(Inactive) page is displayed when user click the active button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Scales(Inactive) page is not displayed when user click the active button");
		}
		
		Search_option.sendKeys(sa);
		
		//Get the value from the table
		String sa1 = driver.findElement(By.xpath("//data-grid/div//div[1]/div[1]/data-grid-row/div/div[1]/span")).getText();

		if(sa.equals(sa1))
		{
			test.log(LogStatus.PASS, "The searched result was displayed successfully for the respective keyword in the inactive scales");
		}
		else {
			test.log(LogStatus.PASS, "The searched result was not displayed successfully for the respective keyword in the inactive scales");
		}
		
		//Click the Inactive button
		driver.findElement(By.xpath("//span[contains(.,'Inactive')]")).click();
		
		Thread.sleep(5000);
		
		Search_option.clear();
		driver.navigate().refresh();
		Thread.sleep(20000);
		
		if(Delete_btn_FirstRow.isDisplayed()) {
			test.log(LogStatus.PASS, "Scales(Active) page is displayed when user click the Inactive button");
		}
		else
		{
			test.log(LogStatus.PASS, "Scales(Active) page is not displayed when user click the Inactive button");
		}
	}

	public void active() throws InterruptedException {
		//Click the active button
		driver.findElement(By.xpath("//span[contains(.,'Active')]")).click();
		Thread.sleep(5000);
		
		try {
			if(Activate_Btn.isDisplayed()) {
				test.log(LogStatus.PASS, "Scales(Inactive) page is displayed when user click the active button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Scales(Inactive) page is not displayed when user click the active button");
			}
			
			//Get the value from the table
			String sa = driver.findElement(By.xpath("//data-grid/div//div[1]/div[1]/data-grid-row/div/div[1]/span")).getText();
			
			Activate_Btn.click();
			
			if(driver.findElement(By.xpath("//h4[.='Activate']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Activate Confirmation popup is displayed, while click the Activate button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Activate Confirmation popup is not displayed, while click the Activate button");
			}
			
			Close_btn.click();
			
			Activate_Btn.click();
			
			if(driver.findElement(By.xpath("//h4[.='Activate']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Activate Confirmation popup is displayed, while click the Activate button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Activate Confirmation popup is not displayed, while click the Activate button");
			}
			Thread.sleep(2000);
			Cancel_btn.click();
			
			Activate_Btn.click();
			Thread.sleep(2000);
			if(driver.findElement(By.xpath("//h4[.='Activate']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Activate Confirmation popup is displayed, while click the Activate button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Activate Confirmation popup is not displayed, while click the Activate button");
			}
			
			Yes_Active_btn.click();
			Thread.sleep(2000);
			
			String s1 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			Thread.sleep(500);
			//Check whether the error message is displayed
			if(s1.equals("Barcode Setting Activated Successfully"))
			{
				test.log(LogStatus.PASS, "Barcode Setting Activated Successfully message is displayed when user activate the scale barcode");
			}
			else
			{
				test.log(LogStatus.FAIL, "Barcode Setting Activated Successfully message is not displayed when user activate the scale barcode");
			}
			
			//Click the close button of warning message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			
			Thread.sleep(5000);

			Search_option.sendKeys(sa);
			
			Thread.sleep(5000);
			
			if(driver.findElement(By.xpath("//div/span[.='Scales not found']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Scales not found message is displayed, when user activate the particular scale");
			}
			else {
				test.log(LogStatus.FAIL, "Scales is found, when user activate the particular scale");
			}
		}catch(Exception d) {
			if(driver.findElement(By.xpath("//div/span[.='Scales not found']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Scales not found message is displayed");
			}
			else {
				test.log(LogStatus.FAIL, "Scales is found");
			}
		}

	}
}
