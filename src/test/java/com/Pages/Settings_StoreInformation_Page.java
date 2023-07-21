package com.Pages;

import java.util.List;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_StoreInformation_Page {
	WebDriver driver;
	ExtentTest test;
	Common_XPaths cmp;
	Utility ut=new Utility();
	
	public Settings_StoreInformation_Page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='settings']/button")
	WebElement Settings;
	
	@FindBy(xpath = "//h3[contains(.,'Settings')]")
	WebElement Settings_Heading;
	
	@FindBy(xpath = "//h3[contains(.,'Store Information')]")
	WebElement StoreInformation_Heading;
	
	@FindBy(xpath =  "//span[contains(.,'SAVE')]")
	WebElement Save;
	
	@FindBy(xpath =  "//mat-label[contains(.,'Store Name')]/../../../input")
	WebElement StoreName_input;
	
	@FindBy(xpath =  "//mat-label[contains(.,'Business Type')]/../../../../div[4]")
	WebElement Business_input;
	
	@FindBy(xpath =  "//div[4]/select-option/div")
	WebElement FourthBusinessType;
	
	@FindBy(xpath =  "//mat-label[contains(.,'Phone Number')]/../../../input")
	WebElement PhoneNumber_input;
	
	@FindBy(xpath =  "//mat-label[contains(.,'Store ID')]/../../../input")
	WebElement StoreID_input;
	
	@FindBy(xpath =  "//mat-label[.=' Email ']/../../../input")
	WebElement Email_input;
	
	@FindBy(xpath =  "//mat-label[contains(.,'Gift Card Email')]/../../../input")
	WebElement GiftCardEmail_input;
	
	@FindBy(xpath =  "//div[contains(@class,'image-picker-options')]/div[2]/div")
	WebElement ImageSelector_input;
	
	@FindBy(xpath =  "//div[contains(@class,'mat-tooltip above')]")
	WebElement ToolTip;
	
	@FindBy(xpath =  "//mat-label[contains(.,'Language')]/../../../div/div/input")
	WebElement Language_input;
	
	@FindBy(xpath =  "//mat-label[contains(.,'Default Language')]/../../../input")
	WebElement DefaultLaunguage_input;
	
	@FindBy(xpath =  "//div[4]/select-option/div/mat-checkbox")
	WebElement FourthLaunguage_CheckBox;
	
	@FindBy(xpath =  "//div[1]/select-option/div")
	WebElement firstLanguage;
	
	@FindBy(xpath =  "//mat-icon[.='cancel']")
	WebElement CloseBtnOfLaunguage;
	
	@FindBy(xpath =  "//mat-label[contains(.,'Street')]/../../../input")
	WebElement Street_input;
	
	@FindBy(xpath =  "//mat-label[contains(.,'Apt,')]/../../../input")
	WebElement Apartment_input;
	
	@FindBy(xpath =  "//mat-label[contains(.,'City')]/../../../input")
	WebElement City_input;
	
	@FindBy(xpath =  "//mat-label[contains(.,'State')]/../../../input")
	WebElement State_input;
	
	@FindBy(xpath =  "//mat-label[contains(.,'Country')]/../../../input")
	WebElement Country_input;
	
	@FindBy(xpath =  "//mat-label[contains(.,'ZipCode')]/../../../input")
	WebElement ZipCode_input;
	
	@FindBy(xpath =  "//mat-label[contains(.,'Time Zone')]/../../../input")
	WebElement TimeZone_input;
	
	@FindBy(xpath =  "//input[@placeholder='Search']")
	WebElement Search_input;
	
	@FindBy(xpath =  "//mat-hint")
	WebElement FieldValidation_msg;
	
	@FindBy(xpath =  "//div[contains(@class,'image')]/span[.='Bo Revamp']")
	WebElement ThereIsNoImg;
	
	@FindBy(xpath =  "//img[contains(@class,'cursor-pointer delete-icon-size')]")
	WebElement ImageDeleteBtn;
	
	public void VerifyStoreInformationPage() throws InterruptedException {
		Thread.sleep(5000);
		
		//Verify the Store Information page
		if(StoreInformation_Heading.getText().equals("Store Information"))
		{
			test.log(LogStatus.PASS, "Store Information page is displayed successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store Information page is not displyed");
		}
	}
	
	public void VerifyStoreName_Field() throws Exception {
		//move the page to top
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		
		//clear the store name
		StoreName_input.clear();
		
		//Enter the random alpha numeric characters in store name field
		StoreName_input.sendKeys(RandomStringUtils.randomAlphanumeric(28));
		
		//get the value or string of store name field
		int s = StoreName_input.getAttribute("value").length();
		
		//verify it accepts only 25 or above
		if(s==25) {
			test.log(LogStatus.PASS, "Store Name field accept only the 25 chars");
		}
		else if(s > 25){
			test.log(LogStatus.FAIL, "Store Name field accept more than 25 chars");
		}
		
		//clear the store name
		StoreName_input.clear();
		
		//Enter the random alpha numeric characters in store name field
		StoreName_input.sendKeys(Utility.getProperty("Store1"));
	}
	
	public void VerifyBusinessType() {
		//select the business type
		Business_input.click();
		
		//select the required business type
		FourthBusinessType.click();
	}
	
	public void VerifyPhoneNumber() throws Exception {
		//Clear the phone number
		PhoneNumber_input.clear();
		
		/*
		 * String s = FieldValidation_msg.getText();
		 * 
		 * if(s.
		 * equals("Enter Valid Phone Number Phone number should be contain atleast 10 digits."
		 * )) { test.log(LogStatus.PASS,
		 * "When user clear the phone number field then the required field validation message is displayed"
		 * ); } else { test.log(LogStatus.FAIL,
		 * "Wrong field validation message is displayed, when user clear the Phone number field"
		 * ); }
		 */
		
		String s1 = RandomStringUtils.randomAlphabetic(5);
		
		//enter the alphabetic in phone number field	
		PhoneNumber_input.sendKeys(s1);
		
		if(s1.equals(PhoneNumber_input.getAttribute("value"))) {
			test.log(LogStatus.FAIL, "Entered Alphabetic characters are displayed in the Phone number field");
		}
		else if(PhoneNumber_input.getAttribute("value").equals("")) {
			test.log(LogStatus.PASS, "Entered alphabetic characters are not displayed in the Phone number field");
		}
		
		PhoneNumber_input.clear();
		
		PhoneNumber_input.sendKeys(Utility.getProperty("Settings_Store_Information_Phone"));
		
		//get the value or string of store name field
		int s2 = PhoneNumber_input.getAttribute("value").length();
		
		//verify it accepts only 25 or above
		if(s2==25) {
			test.log(LogStatus.PASS, "Phonenumber field accept only the 25 chars");
		}
		else if(s2 > 25){
			test.log(LogStatus.FAIL, "Phonenumber field accept more than 25 chars");
		}
		
		
		/*
		 * try { if(s2.
		 * equals("Enter Valid Phone Number Phone number should be contain atleast 10 digits."
		 * )) { test.log(LogStatus.FAIL,
		 * "When user enter the phone number more than 10 chars then the field warning message is displayed"
		 * ); } else { test.log(LogStatus.PASS,
		 * "When user enter the phone number more than 10 chars then the field warning message is not displayed"
		 * ); } }catch(Exception e) { test.log(LogStatus.PASS,
		 * "When user enter the phone number more than 10 chars then the field warning message is not displayed"
		 * ); }
		 */
		
		/*
		 * //Click the Save/Update button Save.click();
		 * 
		 * Thread.sleep(1000);
		 * 
		 * String s2 =
		 * driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		 * 
		 * //Verify the success message if(s2.equals("Store Updated Successfully")) {
		 * test.log(LogStatus.PASS,
		 * "Store Updated message displayed successfully when user edit the phone number"
		 * ); } else { test.log(LogStatus.FAIL,
		 * "Store Updated message is not displayed when user edit the phone number"); }
		 * 
		 * //Click the close button of success message driver.findElement(By.
		 * xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		 * Thread.sleep(3000);
		 * 
		 * try { if(driver.findElement(By.
		 * xpath("//mat-hint[contains(.,'Enter Valid Phone Number')]")).isDisplayed()) {
		 * test.log(LogStatus.FAIL,
		 * "Filed validation message is displayed after click the save button when user enter the valid phone number"
		 * ); } }catch(Exception e) { test.log(LogStatus.PASS,
		 * "Filed validation message is not displayed after click the save button when user enter the valid phone number"
		 * ); }
		 */
		
	}
	
	public void VerifyStoreID_Field() {
		//Clear the store id input
		StoreID_input.clear();
		
		StoreID_input.sendKeys(RandomStringUtils.randomAlphanumeric(15));
		
		if(StoreID_input.getAttribute("value").length() == 11)
		{
			test.log(LogStatus.PASS, "Store ID field only accepts the 11 characters, when user enter more than 11 characters");
		}
		else if(StoreID_input.getAttribute("value").length() == 15)
		{
			test.log(LogStatus.FAIL, "Store ID field accepts the 15 characters, when user enter more than 11 characters");
		}
	}
	
	public void VerifyEmailID_Field() throws Exception {
		//clear the email
		Email_input.clear();
		
		Email_input.sendKeys("abc");
		
		String s = driver.findElement(By.xpath("//p[contains(.,'Please Enter Valid Email')]")).getText();
		
		if(s.equals("Please Enter Valid Email")) {
			test.log(LogStatus.PASS, "Enter the valid email field validation is displayed, when user enter the alphabets");
		}
		else
		{
			test.log(LogStatus.FAIL, "Wrong field validation message is displayed, when user enter the alphabets only");
		}
		
		//Click the Save/Update button
		Save.click();
		
		Thread.sleep(1000);
		
		String s2 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s2.equals("Enter valid email"))
		{
			test.log(LogStatus.PASS, "Enter valid email message is displayed successfully when user click the Save button with invalid email(abc)");
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter valid email message is not displayed successfully when user click the Save button with invalid email(abc)");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		//clear the email
		Email_input.clear();
		
		Email_input.sendKeys("abc@");
		
		if(s.equals("Please Enter Valid Email")) {
			test.log(LogStatus.PASS, "Enter the valid email field validation is displayed, when user enter the alphabets with @ symbol");
		}
		else
		{
			test.log(LogStatus.FAIL, "Wrong field validation message is displayed, when user enter the alphabets and @ symbol only");
		}
		

		//Click the Save/Update button
		Save.click();
		
		Thread.sleep(1000);
		
		String s3 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s3.equals("Enter valid email"))
		{
			test.log(LogStatus.PASS, "Enter valid email message is displayed successfully when user click the Save button with invalid email(abc@)");
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter valid email message is not displayed successfully when user click the Save button with invalid email(abc@)");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		//clear the email
		Email_input.clear();
		
		Email_input.sendKeys("abc@co");
		
		if(s.equals("Please Enter Valid Email")) {
			test.log(LogStatus.PASS, "Enter the valid email field validation is displayed, when user enter the alphabets, @ symbol and co");
		}
		else
		{
			test.log(LogStatus.FAIL, "Wrong field validation message is displayed, when user enter the alphabets, @ symbol and co");
		}
		

		//Click the Save/Update button
		Save.click();
		
		Thread.sleep(1000);
		
		String s4 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s4.equals("Enter valid email"))
		{
			test.log(LogStatus.PASS, "Enter valid email message is displayed successfully when user click the Save button with invalid email(abc@co)");
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter valid email message is not displayed successfully when user click the Save button with invalid email(abc@co)");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		//clear the email
		Email_input.clear();
		
		Email_input.sendKeys("abc@co.");
		
		if(s.equals("Please Enter Valid Email")) {
			test.log(LogStatus.PASS, "Enter the valid email field validation is displayed, when user enter the alphabets, @ symbol, co and .");
		}
		else
		{
			test.log(LogStatus.FAIL, "Wrong field validation message is displayed, when user enter the alphabets, @ symbol, co and .");
		}
		

		//Click the Save/Update button
		Save.click();
		
		Thread.sleep(1000);
		
		String s5 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s5.equals("Enter valid email"))
		{
			test.log(LogStatus.PASS, "Enter valid email message is displayed successfully when user click the Save button with invalid email(abc@co)");
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter valid email message is not displayed successfully when user click the Save button with invalid email(abc@co)");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		//clear the email
		Email_input.clear();
		
		Email_input.sendKeys(Utility.getProperty("Settings_Store_Information_Email"));
		
		if(s.equals("Please Enter Valid Email")) {
			test.log(LogStatus.FAIL, "Enter the valid email field validation is displayed, when user enter the valid email");
		}
		else
		{
			test.log(LogStatus.PASS, "Field validation message is not displayed when user enter the valid email");
		}
		

		//Click the Save/Update button
		Save.click();
		
		Thread.sleep(1000);
		
		String s6 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s6.equals("Store Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Store updated successfully message is displayed when user give the valid message");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store updated successfully message is not displayed when user give the valid message");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
	}
	
	public void VerifyGiftCardEmail_Field() throws InterruptedException {
		//clear the email
		GiftCardEmail_input.clear();
		
		GiftCardEmail_input.sendKeys("abc");
		
		String s = driver.findElement(By.xpath("//p[contains(.,'Please Enter Valid Email')]")).getText();
		
		if(s.equals("Please Enter Valid Email")) {
			test.log(LogStatus.PASS, "Enter the valid email field validation is displayed, when user enter the alphabets in gift card email");
		}
		else
		{
			test.log(LogStatus.FAIL, "Wrong field validation message is displayed, when user enter the alphabets only in gift card email");
		}
		
		//Click the Save/Update button
		Save.click();
		
		Thread.sleep(1000);
		
		String s2 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s2.equals("Invalid JSON."))
		{
			test.log(LogStatus.PASS, "Enter valid email message is displayed successfully when user click the Save button with invalid email(abc) of gift card email");
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter valid email message is not displayed successfully when user click the Save button with invalid email(abc) of gift card email");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		//clear the email
		GiftCardEmail_input.clear();
		
		GiftCardEmail_input.sendKeys("abc@");
		
		if(s.equals("Please Enter Valid Email")) {
			test.log(LogStatus.PASS, "Enter the valid email field validation is displayed, when user enter the alphabets with @ symbol in gift card email");
		}
		else
		{
			test.log(LogStatus.FAIL, "Wrong field validation message is displayed, when user enter the alphabets and @ symbol only in gift card email");
		}
		

		//Click the Save/Update button
		Save.click();
		
		Thread.sleep(1000);
		
		String s3 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s3.equals("Invalid JSON."))
		{
			test.log(LogStatus.PASS, "Enter valid email message is displayed successfully when user click the Save button with invalid email(abc@) of gift card email");
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter valid email message is not displayed successfully when user click the Save button with invalid email(abc@) of gift card email");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		//clear the email
		GiftCardEmail_input.clear();
		
		GiftCardEmail_input.sendKeys("abc@co");
		
		if(s.equals("Please Enter Valid Email")) {
			test.log(LogStatus.PASS, "Enter the valid email field validation is displayed, when user enter the alphabets, @ symbol and co in gift card email");
		}
		else
		{
			test.log(LogStatus.FAIL, "Wrong field validation message is displayed, when user enter the alphabets, @ symbol and co in gift card email");
		}
		

		//Click the Save/Update button
		Save.click();
		
		Thread.sleep(1000);
		
		String s4 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s4.equals("Invalid JSON."))
		{
			test.log(LogStatus.PASS, "Enter valid email message is displayed successfully when user click the Save button with invalid email(abc@co) of gift card email");
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter valid email message is not displayed successfully when user click the Save button with invalid email(abc@co) of gift card email");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		//clear the email
		GiftCardEmail_input.clear();
		
		GiftCardEmail_input.sendKeys("abc@co.");
		
		if(s.equals("Please Enter Valid Email")) {
			test.log(LogStatus.PASS, "Enter the valid email field validation is displayed, when user enter the alphabets, @ symbol, co and . in gift card email");
		}
		else
		{
			test.log(LogStatus.FAIL, "Wrong field validation message is displayed, when user enter the alphabets, @ symbol, co and . in gift card email");
		}
		

		//Click the Save/Update button
		Save.click();
		
		Thread.sleep(1000);
		
		String s5 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s5.equals("Invalid JSON."))
		{
			test.log(LogStatus.PASS, "Enter valid email message is displayed successfully when user click the Save button with invalid email(abc@co) of gift card email");
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter valid email message is not displayed successfully when user click the Save button with invalid email(abc@co) of gift card email");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		//clear the email
		GiftCardEmail_input.clear();
		
		GiftCardEmail_input.sendKeys("abc@co.co");
		
		if(s.equals("Please Enter Valid Email")) {
			test.log(LogStatus.FAIL, "Enter the valid email field validation is displayed, when user enter the valid email in gift card email");
		}
		else
		{
			test.log(LogStatus.PASS, "Field validation message is not displayed when user enter the valid email in gift card email");
		}
		

		//Click the Save/Update button
		Save.click();
		
		Thread.sleep(1000);
		
		String s6 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s6.equals("Store Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Store updated successfully message is displayed when user give the valid email in gift card email");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store updated successfully message is not displayed when user give the valid email in gift card email");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
	}
	
	public void VerifyTheStoreImage() throws InterruptedException {

	      // Javascript executor
	      ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", StoreName_input);
	      Thread.sleep(3000);
		
		//click the upload button
	     // ImageSelector_input.click();
		ImageSelector_input.sendKeys("/Linga_BO_Revamp/target/moreThan2MB.jpg");
		
		Thread.sleep(1000);
		
		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s.equals("Image size upto 2MB can be uploaded"))
		{
			test.log(LogStatus.PASS, "Image size upto 2MB can be uploaded message is displayed when user select the image size is more than 2MB");
		}
		else
		{
			test.log(LogStatus.FAIL, "Image size upto 2MB can be uploaded message is not displayed when user select the image size is more than 2MB");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		//click the upload button
		ImageSelector_input.sendKeys("/Linga_BO_Revamp/target/Sampleimage200kb.jpg");
		
		//Click the Save/Update button
		Save.click();
		
		Thread.sleep(1000);
		
		String s1 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s1.equals("Store Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Store updated successfully message is displayed when user select the image size is below 2MB");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store updated successfully message is not displayed when user select the image size is below 2MB");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		ImageDeleteBtn.click();
		
		Thread.sleep(1000);
		
		//verify the image display
		if(ThereIsNoImg.isDisplayed())
		{
			test.log(LogStatus.PASS, "After click the delete button, there is no store image is displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, "After click the delete button, there is no store image is not displayed");
		}
		
		Thread.sleep(1000);
		
		/*
		 * //Click the Save/Update button Save.click();
		 * 
		 * String s2 =
		 * driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		 * 
		 * //Verify the success message if(s2.equals("Store Updated Successfully")) {
		 * test.log(LogStatus.PASS,
		 * "Store updated successfully message is displayed after delete the image"); }
		 * else { test.log(LogStatus.FAIL,
		 * "Store updated successfully message is not displayed after delete the image"
		 * ); }
		 * 
		 * //Click the close button of success message driver.findElement(By.
		 * xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		 * Thread.sleep(3000);
		 */
	}

	public void VerifyTheLanguage() throws Exception{
	      ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", ImageSelector_input);
	      Thread.sleep(3000);
		
		//Get the language count
		List<WebElement> s = driver.findElements(By.xpath("//div[@class='col-auto d-flex px-1 ng-star-inserted']"));
		
		if(s.size() == 2 || s.size() == 3) {
			//Click the close button of second one close button
			driver.findElement(By.xpath("//mat-icon[contains(@class,'notranslate chip-cancel')]/../../../../div[2]/mat-chip/div/mat-icon")).click();
			
			Thread.sleep(2000);
			//Click the language input
			Language_input.click();
			
			//Click the language input
			Language_input.click();
			
			//select the language
			FourthLaunguage_CheckBox.click();
		}
		else
		{
			//Click the language input
			Language_input.click();
			
			//select the language
			FourthLaunguage_CheckBox.click();
		}

		List<WebElement> s1 = driver.findElements(By.xpath("//div[@class='col-auto d-flex px-1 ng-star-inserted']"));

		Thread.sleep(1000);
		if(s1.size()!=0)
		{
			Language_input.click();
		}
	}
	
	public void VerifyTheDefaultLanguage() throws InterruptedException{
		
		Thread.sleep(1000);
		//Click the default language button
		DefaultLaunguage_input.click();
		
		String s = firstLanguage.getText().trim();
		
		//click the first language
		firstLanguage.click();
		
		//verify the language
		String sw = DefaultLaunguage_input.getAttribute("value");
		
		if(s.equals(sw)) {
			test.log(LogStatus.PASS, "The selected default language is displayed after selecting the same language");
		}
		else
		{
			test.log(LogStatus.FAIL, "The selected default language is not displayed after selecting the same language");
		}
		
		//Click the Save/Update button
		Save.click();
		
		String s2 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s2.equals("Store Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Store updated successfully message is displayed after set the language");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store updated successfully message is not displayed after set the language");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
	}
	
	public void VerifyTheLocation() throws Exception{
		//click the clear button
		Street_input.clear();
		
		//send the maximum length string to street
		Street_input.sendKeys(RandomStringUtils.randomAlphabetic(42));
		
		//get the length of the street
		int d = Street_input.getAttribute("value").length();
		
		//verify the length
		if(d == 40) {
			test.log(LogStatus.PASS, "Street field was allows only 40 characters");
		}
		else if (d == 42)
		{
			test.log(LogStatus.FAIL, "Street field was allows more than 40 characters");
		}
		
		Street_input.clear();
		
		Street_input.sendKeys("//p[.='"+Utility.getProperty("Street_Name")+" ']");
		
		//click the clear button
		Apartment_input.clear();
		
		//send the maximum length string to apartment
		Apartment_input.sendKeys(RandomStringUtils.randomAlphabetic(42));
		
		//get the length of the apartment
		int d1 = Apartment_input.getAttribute("value").length();
		
		//verify the length
		if(d1 == 40) {
			test.log(LogStatus.PASS, "Apartment field was allows only 40 characters");
		}
		else if (d1 == 42)
		{
			test.log(LogStatus.FAIL, "Apartment field was allows more than 40 characters");
		}
		
		//click the clear button
		City_input.clear();
		
		//send the maximum length string to City
		City_input.sendKeys(RandomStringUtils.randomAlphabetic(27));
		
		//get the length of the city
		int d2 = City_input.getAttribute("value").length();
		
		//verify the length
		if(d2 == 25) {
			test.log(LogStatus.PASS, "City field was allows only 25 characters");
		}
		else if (d2 == 27)
		{
			test.log(LogStatus.FAIL, "City field was allows more than 25 characters");
		}
		
		//click the clear button
		State_input.clear();
		
		//send the maximum length string to State
		State_input.sendKeys(RandomStringUtils.randomAlphabetic(27));
		
		//get the length of the state
		int d3 = State_input.getAttribute("value").length();
		
		//verify the length
		if(d3 == 25) {
			test.log(LogStatus.PASS, "State field was allows only 25 characters");
		}
		else if (d3 == 27)
		{
			test.log(LogStatus.FAIL, "State field was allows more than 25 characters");
		}
		
		//click the clear button
		ZipCode_input.clear();
		
		//send the maximum length string to State
		ZipCode_input.sendKeys(RandomStringUtils.randomAlphanumeric(3));
		
		//get the field validation message
		String sd = driver.findElement(By.xpath("//mat-hint[contains(.,'ZipCode')]")).getText();
		
		if(sd.equals("ZipCode should be 4 to 10 characters")) {
			test.log(LogStatus.PASS, "ZipCode should be 4 to 10 characters field validation message is displayed when user enter the 3 characters in zipcode");
		}
		else {
			test.log(LogStatus.FAIL, "ZipCode should be 4 to 10 characters field validation message is not displayed when user enter the 3 characters in zipcode");
		}
		
		//click the clear button
		ZipCode_input.clear();
		
		//send the maximum length string to State
		ZipCode_input.sendKeys(RandomStringUtils.randomAlphanumeric(12));
		
		//get the length of the Zipcode
		int d4 = ZipCode_input.getAttribute("value").length();
		
		//verify the length
		if(d4 == 10) {
			test.log(LogStatus.PASS, "Zipcode field was allows only 10 characters");
		}
		else if (d4 == 12)
		{
			test.log(LogStatus.FAIL, "Zipcode field was allows more than 10 characters");
		}
		
		try
		{
			//get the field validation message
			String sd1 = driver.findElement(By.xpath("//mat-hint[contains(.,'ZipCode')]")).getText();
			
			if(sd1.equals("ZipCode should be 4 to 10 characters")) {
				test.log(LogStatus.FAIL, "ZipCode should be 4 to 10 characters field validation message is displayed when user enter the valid characters in zipcode");
			}
		}catch(Exception ds) {}
		
		/*
		 * //Click the Save/Update button Save.click();
		 * 
		 * String s2 =
		 * driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		 * 
		 * //Verify the success message if(s2.equals("Store Updated Successfully")) {
		 * test.log(LogStatus.PASS,
		 * "Store updated successfully message is displayed after add the address"); }
		 * else { test.log(LogStatus.FAIL,
		 * "Store updated successfully message is not displayed after add the address");
		 * }
		 * 
		 * //Click the close button of success message driver.findElement(By.
		 * xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		 */
		Thread.sleep(3000);
	}
	
	public void VerifyTheTimeZone() throws InterruptedException {
		//click the time zone
		TimeZone_input.click();
		
		Search_input.sendKeys("GMT+05:30");
		
		firstLanguage.click();
		

	}
	
	public void VerifyTheToolTip_StoreName() {
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(StoreName_input).perform();
		
		String s = ToolTip.getText();
		
		if(s.equals("Display's Registered Business Name")) {
			test.log(LogStatus.PASS, "When user move the mouse over the particular element then the required tooltip is available for Store Name field");
		}
		else {
			test.log(LogStatus.FAIL, "Required tooltip is not displayed for Store Name field");
		}
	}
	
	public void VerifyTheToolTip_BusinessType() {
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(Business_input).perform();
		
		String s = ToolTip.getText();
		
		if(s.equals("Current store Business Type")) {
			test.log(LogStatus.PASS, "When user move the mouse over the particular element then the required tooltip is available for Business Type field");
		}
		else {
			test.log(LogStatus.FAIL, "Required tooltip is not displayed for Business Type field");
		}
	}
	
	public void VerifyTheToolTip_PhoneNumber() {
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(PhoneNumber_input).perform();
		
		String s = ToolTip.getText();
		
		if(s.equals("Displays Registered Phone Number")) {
			test.log(LogStatus.PASS, "When user move the mouse over the particular element then the required tooltip is available for Phone Number field");
		}
		else {
			test.log(LogStatus.FAIL, "Required tooltip is not displayed for Phone Number field");
		}
	}
	
	public void VerifyTheToolTip_StoreID() {
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(StoreID_input).perform();
		
		String s = ToolTip.getText();
		
		if(s.equals("Displays Store ID which is unique Numerical value for the Store")) {
			test.log(LogStatus.PASS, "When user move the mouse over the particular element then the required tooltip is available for Store ID field");
		}
		else {
			test.log(LogStatus.FAIL, "Required tooltip is not displayed for Store ID field");
		}
	}
	
	public void VerifyTheToolTip_Email() {
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(Email_input).perform();
		
		String s = ToolTip.getText();
		
		if(s.equals("Display's registered business email ID")) {
			test.log(LogStatus.PASS, "When user move the mouse over the particular element then the required tooltip is available for email id field");
		}
		else {
			test.log(LogStatus.FAIL, "Required tooltip is not displayed for Email id field");
		}
	}
	
	public void VerifyTheToolTip_GiftCardEmail() {
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(GiftCardEmail_input).perform();
		
		String s = ToolTip.getText();
		
		if(s.equals("Email confirmation for online gift card sold")) {
			test.log(LogStatus.PASS, "When user move the mouse over the particular element then the required tooltip is available for Gift card sold field");
		}
		else {
			test.log(LogStatus.FAIL, "Required tooltip is not displayed for gift card sold field");
		}
	}
	
	public void VerifyTheToolTip_StoreImage() {
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(ImageSelector_input).perform();
		
		String s = ToolTip.getText();
		
		if(s.equals("Upload New Image")) {
			test.log(LogStatus.PASS, "When user move the mouse over the particular element then the required tooltip is available for Upload new image field");
		}
		else {
			test.log(LogStatus.FAIL, "Required tooltip is not displayed for upload new image field");
		}
	}
	
	public void VerifyTheToolTip_Launguage() {
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(Language_input).perform();
		
		String s = ToolTip.getText();
		
		if(s.equals("Displays Store Preferred/Accepted Language")) {
			test.log(LogStatus.PASS, "When user move the mouse over the particular element then the required tooltip is available for Launguage field");
		}
		else {
			test.log(LogStatus.FAIL, "Required tooltip is not displayed for Launguage field");
		}
	}
	
	public void VerifyTheToolTip_DefaultLaunguage() {
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(DefaultLaunguage_input).perform();
		
		String s = ToolTip.getText();
		
		if(s.equals("Displays Store Preferred/Accepted Default Language")) {
			test.log(LogStatus.PASS, "When user move the mouse over the particular element then the required tooltip is available for Default Launguage field");
		}
		else {
			test.log(LogStatus.FAIL, "Required tooltip is not displayed for Default Launguage field");
		}
	}
	
	public void VerifyTheToolTip_Street() {
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(Street_input).perform();
		
		String s = ToolTip.getText();
		
		if(s.equals("Displays Registered Address")) {
			test.log(LogStatus.PASS, "When user move the mouse over the particular element then the required tooltip is available for Street field");
		}
		else {
			test.log(LogStatus.FAIL, "Required tooltip is not displayed for Street field");
		}
	}
	
	public void VerifyTheToolTip_Apartment() {
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(Apartment_input).perform();
		
		String s = ToolTip.getText();
		
		if(s.equals("Displays Registered Address")) {
			test.log(LogStatus.PASS, "When user move the mouse over the particular element then the required tooltip is available for Apartment field");
		}
		else {
			test.log(LogStatus.FAIL, "Required tooltip is not displayed for Apartment field");
		}
	}
	
	public void VerifyTheToolTip_City() {
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(City_input).perform();
		
		String s = ToolTip.getText();
		
		if(s.equals("Display's registered city")) {
			test.log(LogStatus.PASS, "When user move the mouse over the particular element then the required tooltip is available for City field");
		}
		else {
			test.log(LogStatus.FAIL, "Required tooltip is not displayed for City field");
		}
	}
	
	public void VerifyTheToolTip_State() {
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(State_input).perform();
		
		String s = ToolTip.getText();
		
		if(s.equals("Display's registered state")) {
			test.log(LogStatus.PASS, "When user move the mouse over the particular element then the required tooltip is available for State field");
		}
		else {
			test.log(LogStatus.FAIL, "Required tooltip is not displayed for State field");
		}
	}
	
	public void VerifyTheToolTip_Country() {
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(Country_input).perform();
		
		String s = ToolTip.getText();
		
		if(s.equals("Display's registered country")) 
		{
			test.log(LogStatus.PASS, "When user move the mouse over the particular element then the required tooltip is available for country field");
		}
		else {
			test.log(LogStatus.FAIL, "Required tooltip is not displayed for Country field");
		}
	}
	
	public void VerifyTheToolTip_ZipCode() {
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(ZipCode_input).perform();
		
		String s = ToolTip.getText();
		
		if(s.equals("Display's registered zipcode")) {
			test.log(LogStatus.PASS, "When user move the mouse over the particular element then the required tooltip is available for Zipcode field");
		}
		else {
			test.log(LogStatus.FAIL, "Required tooltip is not displayed for Zipcode field");
		}
	}
	
	public void VerifyTheToolTip_TimeZone() {
		//Creating object of an Actions class
		Actions action = new Actions(driver);

		//Performing the mouse hover action on the target element.
		action.moveToElement(TimeZone_input).perform();
		
		String s = ToolTip.getText();
		
		if(s.equals("Display's current store time zone")) {
			test.log(LogStatus.PASS, "When user move the mouse over the particular element then the required tooltip is available for Time Zone field");
		}
		else {
			test.log(LogStatus.FAIL, "Required tooltip is not displayed for Time Zone field");
		}
	}
	
	// Newly Added 
		public void Enter_Phone_Number(String Phone) throws Exception
		{
			new Common_XPaths(driver, test).Enter_Text(PhoneNumber_input, Phone, "Phone Number Entered");
		}
		
		public void Enter_Apartment(String Apt) throws Exception
		{
			new Common_XPaths(driver, test).Enter_Text(Apartment_input, Apt, "Apartment suite address Entered");
		}
		
		public void Enter_ZipCode(String Zipcode) throws Exception
		{
			new Common_XPaths(driver, test).Enter_Text(ZipCode_input, Zipcode, "Zip Code Entered");
		}
		
		public void Enter_City(String City) throws Exception
		{
			new Common_XPaths(driver, test).Enter_Text(City_input, City, "City Entered");
		}
		
		public void Enter_State(String State) throws Exception
		{
			new Common_XPaths(driver, test).Enter_Text(State_input, State, "State Entered");
		}
}