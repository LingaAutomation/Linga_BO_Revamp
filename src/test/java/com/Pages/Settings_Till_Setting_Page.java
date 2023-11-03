package com.Pages;


import java.time.Duration;
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

import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_Till_Setting_Page extends BasePage
{
//	SelfHealingDriver driver;
//	ExtentTest test;
	Common_XPaths cmp;
	Utility ut=new Utility();
	
	public Settings_Till_Setting_Page(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		super(driver, test);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='settings']/button")
	WebElement Settings;
	
	@FindBy(xpath = "//h3[contains(.,'Settings')]")
	WebElement Settings_Heading;
	
	@FindBy(xpath = "//span[contains(.,'Payments')]")
	WebElement Payments;	
	
	@FindBy(xpath = "//h4[contains(.,'Payments')]")
	WebElement Payments_Heading;	
	
	@FindBy(xpath = "//span[contains(.,'Till')]")
	WebElement Till;
	
	@FindBy(xpath = "//h3[contains(.,'Till Settings')]")
	WebElement Till_Heading;
	
	@FindBy(xpath =  "//div[.='TILL SETTINGS']")
	WebElement TillSettings;
	
	@FindBy(xpath =  "//div[.='DENOMINATIONS']")
	WebElement Denominations;
	
	@FindBy(xpath =  "//div[.='CLOSE TILLS']")
	WebElement CloseTills;
	
	@FindBy(xpath =  "//span[contains(.,'SAVE')]")
	WebElement Save;
	
	@FindBy(xpath =  "//span[contains(.,'Automatic Global Till')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement No_btn_AGT;
	
	@FindBy(xpath =  "//span[contains(.,'Automatic Global Till')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Yes_btn_AGT;
	
	@FindBy(xpath =  "//span[contains(.,'Force Cash Out at Clock Out')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement No_btn_FCOCO;
	
	@FindBy(xpath =  "//span[contains(.,'Force Cash Out at Clock Out')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Yes_btn_FCOCO;
	
	@FindBy(xpath =  "//span[contains(.,'Restrict Partial Payments')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement No_btn_RPP;
	
	@FindBy(xpath =  "//span[contains(.,'Restrict Partial Payments')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement Yes_btn_RPP;
	
	@FindBy(xpath =  "//span[contains(.,'Automatic Global Till')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button[@aria-pressed='true']")
	WebElement No_btn_AGT_selected;
	
	@FindBy(xpath =  "//span[contains(.,'Automatic Global Till')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button[@aria-pressed='true']")
	WebElement Yes_btn_AGT_selected;
	
	@FindBy(xpath =  "//span[contains(.,'Force Cash Out at Clock Out')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button[@aria-pressed='true']")
	WebElement No_btn_FCOCO_selected;
	
	@FindBy(xpath =  "//span[contains(.,'Force Cash Out at Clock Out')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button[@aria-pressed='true']")
	WebElement Yes_btn_FCOCO_selected;
	
	@FindBy(xpath =  "//span[contains(.,'Restrict Partial Payments')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[1]/button[@aria-pressed='true']")
	WebElement No_btn_RPP_selected;
	
	@FindBy(xpath =  "//span[contains(.,'Restrict Partial Payments')]/../../div[2]/mat-button-toggle-group/mat-button-toggle[2]/button[@aria-pressed='true']")
	WebElement Yes_btn_RPP_selected;
	
	@FindBy(xpath =  "//span[contains(.,'BANK DEPOSIT')]")
	WebElement addBankDeposit;
	
	@FindBy(xpath =  "//mat-label[contains(.,'Deposit Amount')]/../../../input")
	WebElement depositAmount_input;
	
	@FindBy(xpath =  "//input[contains(@class,'mat-datepicker-input')]")
	WebElement datePicker_input;
	
	@FindBy(xpath =  "//button[contains(@aria-label,'Open calendar')]")
	WebElement datePicker_calenderIcon;
	
	@FindBy(xpath =  "//button[contains(@class,'mat-calendar-body-active')]")
	WebElement currentDate;
	
	@FindBy(xpath =  "//span[contains(.,'Save')]")
	WebElement SaveBtn_BankDeposit;
	
	@FindBy(xpath =  "//span[contains(.,'Cancel')]")
	WebElement CancelBtn_BankDeposit;
	
	@FindBy(xpath =  "//span[contains(.,'DENOMINATION')]")
	WebElement AddDenominationBtn;
	
	@FindBy(xpath =  "//mat-label[contains(.,'Display Name')]/../../../input")
	WebElement DisplyName_Denomination;
	
	@FindBy(xpath =  "//mat-label[contains(.,'Amount')]/../../../input")
	WebElement amount_Denomination;
	
	@FindBy(xpath =  "//span[contains(.,'Close')]")
	WebElement close_Btn;
	
	@FindBy(xpath =  "//span[contains(.,'Search')]/../input")
	WebElement search_denomination;
	
	@FindBy(xpath =  "//input[@placeholder='Search']")
	WebElement search_denomination1;
	
	@FindBy(xpath =  "//div[contains(@class,'cdk-drop-list')]/div/data-grid-row/div/div[3]/button")
	WebElement deleteButton_Denomination;
	
	@FindBy(xpath =  "//span[contains(.,'Rows per page:')]/../../div[2]/app-selectbox/div/mat-form-field/div")
	WebElement rowsPerPage_btn;
	
	@FindBy(xpath =  "//select-option[1]/div")
	WebElement fiveRows_Denomination;
	
	@FindBy(xpath =  "//select-option[2]/div")
	WebElement tenRows_Option;
	
	@FindBy(xpath =  "//select-option[3]/div")
	WebElement fifteenRows_Option;
	
	@FindBy(xpath =  "//select-option[4]/div")
	WebElement twentyRows_Option;
	
	@FindBy(xpath =  "//mat-label[contains(.,'Global Till Opening Balance')]/../../../input")
	WebElement globalOpeningBalance;
	
	@FindBy(xpath =  "//div[@class='message mx-2']/span")
	WebElement successMessage;
	
	@FindBy(xpath =  "//h3[contains(.,'New Bank Deposit')]")
	WebElement newBankDeposit;
	
	@FindBy(xpath =  "//span[.='Save']/../../button[contains(@class,'mat-button-disabled')]")
	WebElement saveBtn_Disabled;
	
	@FindBy(xpath =  "//h3[contains(.,'New Denomination')]")
	WebElement newDenomination;
	
	@FindBy(xpath =  "//span[contains(.,'Delete')]")
	WebElement deleteConfirmationBtn;
		
	@FindBy(xpath =  "//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div[1]/div/span")
	WebElement denomination_Name_First_Row;
	
	@FindBy(xpath =  "//div[@class='col-auto ng-star-inserted']/button")
	WebElement pagination;
	
	@FindBy(xpath =  "//span[contains(.,'Display Name')]")
	WebElement displayname;
	
	@FindBy(xpath =  "//span[contains(.,'Till Name')]")
	WebElement Tillname;
	
	@FindBy(xpath =  "//span[contains(.,'Till Type')]")
	WebElement TillType;
	
	@FindBy(xpath =  "//span[contains(.,'Status')]")
	WebElement Status;
	
	@FindBy(xpath =  "//span[contains(.,'Amount')]")
	WebElement amount;
	
	@FindBy(xpath =  "//span[contains(.,'Open By')]")
	WebElement OpenBy;
	
	@FindBy(xpath =  "//div[contains(.,'Actions')and contains(@class,'header d-flex')]")
	WebElement Actions;
	
	public void paginationValidations() throws Exception {
		
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

	
	public void closeTill() throws Exception {
		Thread.sleep(5000);
		
		//Click the close till
		CloseTills.click();
		
		if(Tillname.isDisplayed()) {
			test.log(LogStatus.PASS, "Till Name Colum is displayed while user click the Close Till button");
		}
		else {
			test.log(LogStatus.FAIL, "Till Name Colum is not displayed while user click the Close Till button");
		}
		
		if(TillType.isDisplayed()) {
			test.log(LogStatus.PASS, "Till Type Colum is displayed while user click the Close Till button");
		}
		else {
			test.log(LogStatus.FAIL, "Till Type Colum is not displayed while user click the Close Till button");
		}
		
		if(Status.isDisplayed()) {
			test.log(LogStatus.PASS, "Status Colum is displayed while user click the Close Till button");
		}
		else {
			test.log(LogStatus.FAIL, "Status Colum is not displayed while user click the Close Till button");
		}
		
		if(amount.isDisplayed()) {
			test.log(LogStatus.PASS, "Amount Colum is displayed while user click the Close Till button");
		}
		else {
			test.log(LogStatus.FAIL, "Amount Colum is not displayed while user click the Close Till button");
		}
		
		if(OpenBy.isDisplayed()) {
			test.log(LogStatus.PASS, "Open By Colum is displayed while user click the Close Till button");
		}
		else {
			test.log(LogStatus.FAIL, "Open By Colum is not displayed while user click the Close Till button");
		}
		
		if(search_denomination1.isDisplayed()) {
			test.log(LogStatus.PASS, "Search option is displayed while user click the Close Till button");
		}
		else {
			test.log(LogStatus.FAIL, "Search option is not displayed while user click the Close Till button");
		}
		
		if(Actions.isDisplayed()) {
			test.log(LogStatus.PASS, "Actions Column is displayed while user click the Close Till button");
		}
		else {
			test.log(LogStatus.FAIL, "Actions Column is not displayed while user click the Close Till button");
		}
	}
	
	@FindBy(xpath =  "//button[@type='button']/span[contains(.,'No')]")
	WebElement No_btn;
	
	@FindBy(xpath =  "//span[contains(.,'Yes')]")
	WebElement Yes_btn;
	
	public void CloseTheActiveTill() throws InterruptedException {
		//Get the value of first denomination name
		String s1 = denomination_Name_First_Row.getText();
		
		Thread.sleep(3000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		
		Thread.sleep(3000);
		//click the close till
		//driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div/data-grid-row/div/div/div/button")).click();
	
		//click the close button
		Close_btn.click();
		
		//click the delete button
		//driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div/data-grid-row/div/div/div/button")).click();
		
		//click the close button
		No_btn.click();
		
		//click the delete button
		//driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div/data-grid-row/div/div/div/button")).click();
		//click the close button
		Close_btn.click();
		
		//click the close button
		Yes_btn.click();
		
		if(successMessage.getText().equals("Till Closed Successfully")) {
			test.log(LogStatus.PASS, "Till Closed Successfully popup displayed after click the Close Till button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Till Closed Successfully popup is not displayed after click the Close Till button");
		}
		
		//clear the search field
		search_denomination1.clear();
		
		//enter the required text in the Search bar
		search_denomination1.sendKeys(s1);
		
		Thread.sleep(5000);
		
		List<WebElement> xs = driver.findElements(By.xpath("//span[contains(.,'Close Till not found')]"));
		
		if(xs.size() == 1) {
			test.log(LogStatus.PASS, "Close Till not found after click the close till button");
		}
		else if(xs.size() == 0)
		{
			test.log(LogStatus.FAIL, "Close Till not found after click the close till button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	public void denominationSorting() throws Exception {
		Thread.sleep(3000);
		
		//Click the display name
		displayname.click();
		
	}
	
	public void paginationValidation() throws Exception {
		
		//get the total number of pages
		List<WebElement> s = driver.findElements(By.xpath("//div[@class='col-auto ng-star-inserted']/button"));
				
		if(s.size() == 1)
		{
			//delete button count
			List<WebElement> d = driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/data-grid-row/div/div[3]/button"));

			if(d.size() <= 5) {
				test.log(LogStatus.PASS, "Number of denominations are displayed correctly when user select the 5 denominations per page");
			}
			else {
				test.log(LogStatus.FAIL, "Number of denominations are displayed wrongly when user select the 5 denominations per page");
			}
		}
		else if(s.size() == 2) {
			Thread.sleep(2000);
			//delete button count
			List<WebElement> d = driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/data-grid-row/div/div[3]/button"));

			if(d.size() <= 5) {
				test.log(LogStatus.PASS, "Number of denominations are displayed correctly when user select the 5 denominations per page");
			}
			else {
				test.log(LogStatus.FAIL, "Number of denominations are displayed wrongly when user select the 5 denominations per page");
			}
			
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 10 from the option
			tenRows_Option.click();
			
			//delete button count
			List<WebElement> d1 = driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/data-grid-row/div/div[3]/button"));
			Thread.sleep(1000);
			
			if(d1.size() <= 10 && d1.size() > 5) {
				test.log(LogStatus.PASS, "Number of denominations are displayed correctly when user select the 10 denominations per page");
			}
			else {
				test.log(LogStatus.FAIL, "Number of denominations are displayed wrongly when user select the 10 denominations per page");
			}
		}
		else if(s.size() == 3) {
			Thread.sleep(2000);
			//delete button count
			List<WebElement> d = driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/data-grid-row/div/div[3]/button"));

			if(d.size() <= 5) {
				test.log(LogStatus.PASS, "Number of denominations are displayed correctly when user select the 5 denominations per page");
			}
			else {
				test.log(LogStatus.FAIL, "Number of denominations are displayed wrongly when user select the 5 denominations per page");
			}
			
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 10 from the option
			tenRows_Option.click();
			
			//delete button count
			List<WebElement> d1 = driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/data-grid-row/div/div[3]/button"));
			Thread.sleep(1000);
			
			if(d1.size() <= 10 && d1.size() > 5) {
				test.log(LogStatus.PASS, "Number of denominations are displayed correctly when user select the 10 denominations per page");
			}
			else {
				test.log(LogStatus.FAIL, "Number of denominations are displayed wrongly when user select the 10 denominations per page");
			}
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 15 from the option
			fifteenRows_Option.click();
			
			//delete button count
			List<WebElement> d2 = driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/data-grid-row/div/div[3]/button"));
			Thread.sleep(1000);
			
			if(d2.size() <= 15 && d2.size() > 10) {
				test.log(LogStatus.PASS, "Number of denominations are displayed correctly when user select the 15 denominations per page");
			}
			else {
				test.log(LogStatus.FAIL, "Number of denominations are displayed wrongly when user select the 15 denominations per page");
			}
		}	
		else{
			Thread.sleep(2000);
			//delete button count
			List<WebElement> d = driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/data-grid-row/div/div[3]/button"));

			if(d.size() <= 5) {
				test.log(LogStatus.PASS, "Number of denominations are displayed correctly when user select the 5 denominations per page");
			}
			else {
				test.log(LogStatus.FAIL, "Number of denominations are displayed wrongly when user select the 5 denominations per page");
			}
			
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 10 from the option
			tenRows_Option.click();
			
			//delete button count
			List<WebElement> d1 = driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/data-grid-row/div/div[3]/button"));
			Thread.sleep(1000);
			
			if(d1.size() <= 10 && d1.size() > 5) {
				test.log(LogStatus.PASS, "Number of denominations are displayed correctly when user select the 10 denominations per page");
			}
			else {
				test.log(LogStatus.FAIL, "Number of denominations are displayed wrongly when user select the 10 denominations per page");
			}
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 15 from the option
			fifteenRows_Option.click();
			
			//delete button count
			List<WebElement> d2 = driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/data-grid-row/div/div[3]/button"));
			Thread.sleep(1000);
			
			if(d2.size() <= 15 && d2.size() > 10) {
				test.log(LogStatus.PASS, "Number of denominations are displayed correctly when user select the 15 denominations per page");
			}
			else {
				test.log(LogStatus.FAIL, "Number of denominations are displayed wrongly when user select the 15 denominations per page");
			}
			
			Thread.sleep(2000);
			//Click the rows per page text box
			rowsPerPage_btn.click();
			
			Thread.sleep(1000);
			//Select the 20 from the option
			twentyRows_Option.click();
			
			//delete button count
			List<WebElement> d3 = driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/data-grid-row/div/div[3]/button"));
			Thread.sleep(1000);
			
			if(d3.size() <= 20 && d3.size() > 15) {
				test.log(LogStatus.PASS, "Number of denominations are displayed correctly when user select the 20 denominations per page");
			}
			else {
				test.log(LogStatus.FAIL, "Number of denominations are displayed wrongly when user select the 20 denominations per page");
			}
		}	
		
		
	}
	
	public void denomination_Search() throws Exception {
		Thread.sleep(5000);
		//Get the value of first denomination name
		String s1 = denomination_Name_First_Row.getText();
		
		//clear the search field
		search_denomination.clear();
		
		//enter the required text in the Search bar
		search_denomination.sendKeys(s1);
		
		Thread.sleep(5000);
		
		//getting the web-element count for searched result
		List<WebElement> s = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));
		
		for(int i = 1; i <= s.size(); i++)
		{
			if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]/span")).getText().contains(s1))
			{
				test.log(LogStatus.PASS, "Required keywords are displayed when user search the result is : "+driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]/span")).getText());
			}
			else
			{
				test.log(LogStatus.FAIL, "Required keywords are not displayed when user search the result is : "+driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]/span")).getText());
			}
		}
	}
	
	public void denomination_Search1() throws Exception {
		Thread.sleep(5000);
		//Get the value of first denomination name
		String s1 = denomination_Name_First_Row.getText();
		
		//clear the search field
		search_denomination1.clear();
		
		//enter the required text in the Search bar
		search_denomination1.sendKeys(s1);
		
		Thread.sleep(5000);
		
		//getting the web-element count for searched result
		List<WebElement> s = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div"));
		
		for(int i = 1; i <= s.size(); i++)
		{
			if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]/span")).getText().contains(s1))
			{
				test.log(LogStatus.PASS, "Required keywords are displayed when user search the result is : "+driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]/span")).getText());
			}
			else
			{
				test.log(LogStatus.FAIL, "Required keywords are not displayed when user search the result is : "+driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]/span")).getText());
			}
		}
	}
	
	public void Click_Settings() {
		//Wait for 10 secs till settings text is available
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click the Settings Icon
		Settings.click();
		
		//Wait for 10 secs till settings text is available
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Check whether Settings heading is displayed or not
		if(Settings_Heading.getText().equals("Settings"))
		{
			test.log(LogStatus.PASS, "Settings page is displayed after clickng the Settings icon");
		}
		else
		{
			test.log(LogStatus.FAIL, "Settings page is not displayed after clicking the Settings icon");
		}
	}
	
	public void Click_Payments() {
		//Click the Payments button
		Payments.click();
		
		//Wait for 10 secs till payments text is available
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Check whether Payments heading is displayed or not
		if(Payments_Heading.getText().equals("Payments"))
		{
			test.log(LogStatus.PASS, "Payments tab is displayed after clickng the Payments option");
		}
		else
		{
			test.log(LogStatus.FAIL, "Payments tab is not displayed after clicking the Payments option");
		}
	}
	
	public void verify_TillSettings_Page() {
		//Click the Till Option
		//Till.click();
		
		//Wait for 10 secs till Till text is available
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Check whether Till heading is displayed or not
		if(Till_Heading.getText().equals("Till Settings"))
		{
			test.log(LogStatus.PASS, "Till heading is displayed after clickng the Till option");
		}
		else
		{
			test.log(LogStatus.FAIL, "Till heading is not displayed after clicking the Till option");
		}
		
		//Check whether Till Settings is displayed or not
		if(TillSettings.getText().equals("TILL SETTINGS"))
		{
			test.log(LogStatus.PASS, "Till Setting tab is displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Till Setting tab is not displayed");
		}
		
		//Check whether Denomination is displayed or not
		if(Denominations.getText().equals("DENOMINATIONS"))
		{
			test.log(LogStatus.PASS, "Denomination tab is displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Denomination tab is not displayed");
		}
		
		//Check whether Close Tills is displayed or not
		if(CloseTills.getText().equals("CLOSE TILLS"))
		{
			test.log(LogStatus.PASS, "Close Tills tab is displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Close Tills tab is not displayed");
		}
		
		//Check whether Save button is displayed or not
		if(Save.getText().equals("SAVE"))
		{
			test.log(LogStatus.PASS, "Save button is displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Save button is not displayed");
		}
	}
	
	public void Click_Save() {
		
		//click the save button
		Save.click();
	}
	
	public void automaticGlobalTill() throws InterruptedException {
		
		//Click the yes button of Automatic Global Till
		Yes_btn_AGT.click();
		
		//get the value of attribute text value in the Global Opening Balance
		String s = globalOpeningBalance.getAttribute("value");
		System.out.println("Initial value of Global Opening Balance is : "+s);
		
		//Enter the invalid Global Opening Balance
		globalOpeningBalance.sendKeys("AA%^$");
		
		//Get the value of attribute text value in the Global Opening Balance after entering the invalid string
		String s1 = globalOpeningBalance.getAttribute("value");
		System.out.println("After entering the value of Global Opening Balance is : "+s1);
		
		//compare the value of before and after entering the text
		if(s.equals(s1))
		{
			test.log(LogStatus.PASS, "Global Opening balance, text box not accept the invalid string");
		}
		else
		{
			test.log(LogStatus.FAIL, "Global Opening balance, text box is accecpt the invalid string");
		}
		
		//Global opening balance
		globalOpeningBalance.clear();
		
		//Enter the valid Global Opening Balance
		globalOpeningBalance.sendKeys("1000");     
		
		Click_Save();Thread.sleep(1000);
		//Check whether the success message is displayed
		if(successMessage.getText().equals("Till Settings Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Saved message displayed successfully when user select the yes toggle in Automatic Global Till");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Saved message displayed faild when user select the yes toggle in Automatic Global Till");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//check whether the yes toggle is enabled or not in Auto Global Till
		if(Yes_btn_AGT_selected.isDisplayed())
		{
			test.log(LogStatus.PASS, "YES toggle is selected when user selects the Auto Global Till's YES toggle");
		}
		else
		{
			test.log(LogStatus.FAIL, "YES toggle is not selected when user selects the Auto Global Till's YES toggle");
		}
		
		
		//Click the no button of Automatic Global Till
		No_btn_AGT.click();
		
		Click_Save();Thread.sleep(1000);
		
		//Check whether the success message is displayed
		if(successMessage.getText().equals("Till Settings Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Saved message displayed successfully when user select the NO toggle in Automatic Global Till");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Saved message displayed faild when user select the NO toggle in Automatic Global Till");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//check whether the yes toggle is enabled or not in Auto Global Till
		if(No_btn_AGT_selected.isDisplayed())
		{
			test.log(LogStatus.PASS, "NO toggle is selected when user selects the Auto Global Till's NO toggle");
		}
		else
		{
			test.log(LogStatus.FAIL, "NO toggle is not selected when user selects the Auto Global Till's NO toggle");
		}
		
	}
	
	public void forceCashOutatClockOut() throws InterruptedException {
		
		//Click the yes toggle of Force Cash Out at Clock Out
		Yes_btn_FCOCO.click();
		
		Click_Save();Thread.sleep(1000);
		
		//Check whether the success message is displayed
		if(successMessage.getText().equals("Till Settings Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Saved message displayed successfully when user select the yes toggle in Force Cash Out at Clock Out");
		}
		else
		{
			test.log(LogStatus.FAIL, "Saved message displayed faild when user select the yes toggle in Force Cash Out at Clock Out");
		}
		
		//check whether the yes toggle is enabled or not in Force Cash Out at Clock Out
		if(Yes_btn_FCOCO_selected.isDisplayed())
		{
			test.log(LogStatus.PASS, "YES toggle is selected when user selects the Force Cash Out at Clock Out's YES toggle");
		}
		else
		{
			test.log(LogStatus.FAIL, "YES toggle is not selected when user selects the Force Cash Out at Clock Out's YES toggle");
		}
		
		
		//Click the no button of Force cash out at clock out
		No_btn_FCOCO.click();
		
		Click_Save();Thread.sleep(1000);
		
		//Check whether the success message is displayed
		if(successMessage.getText().equals("Till Settings Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Saved message displayed successfully when user select the NO toggle in Force Cash Out at Clock Out");
		}
		else
		{
			test.log(LogStatus.FAIL, "Saved message displayed faild when user select the NO toggle in Force Cash Out at Clock Out");
		}
		
		//check whether the yes toggle is enabled or not in Force Cash Out at Clock Out
		if(No_btn_FCOCO_selected.isDisplayed())
		{
			test.log(LogStatus.PASS, "NO toggle is selected when user selects the Force Cash Out at Clock Out's NO toggle");
		}
		else
		{
			test.log(LogStatus.FAIL, "NO toggle is not selected when user selects the Force Cash Out at Clock Out's NO toggle");
		}
		
	}
	
	public void restrictPartialPaymnets() throws InterruptedException {
		
		//Click the yes toggle of Restrict Partial Payments
		Yes_btn_RPP.click();
		
		Click_Save();Thread.sleep(2000);
		
		//Check whether the success message is displayed
		if(successMessage.getText().equals("Till Settings Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Saved message displayed successfully when user select the yes toggle in Force Restrict Partial Payments");
		}
		else
		{
			test.log(LogStatus.FAIL, "Saved message displayed faild when user select the yes toggle in Restrict Partial Payments");
		}
		
		//check whether the yes toggle is enabled or not in Restrict Partial Payments
		if(Yes_btn_RPP_selected.isDisplayed())
		{
			test.log(LogStatus.PASS, "YES toggle is selected when user selects the Restrict Partial Payments's YES toggle");
		}
		else
		{
			test.log(LogStatus.FAIL, "YES toggle is not selected when user selects the Restrict Partial Payments's YES toggle");
		}
		
		
		//Click the no button of Restrict Partial Payments
		No_btn_RPP.click();
		
		Click_Save();Thread.sleep(1000);
		
		//Check whether the success message is displayed
		if(successMessage.getText().equals("Till Settings Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Saved message displayed successfully when user select the NO toggle in Restrict Partial Payments");
		}
		else
		{
			test.log(LogStatus.FAIL, "Saved message displayed faild when user select the NO toggle in Restrict Partial Payments");
		}
		
		//check whether the yes toggle is enabled or not in Restrict Partial Payments
		if(No_btn_RPP_selected.isDisplayed())
		{
			test.log(LogStatus.PASS, "NO toggle is selected when user selects the Restrict Partial Payments's NO toggle");
		}
		else
		{
			test.log(LogStatus.FAIL, "NO toggle is not selected when user selects the Restrict Partial Payments's NO toggle");
		}
	}
	
	public void AddBankDeposit() throws Exception {
		//Click the Add Bank deposit button
		addBankDeposit.click();
		Thread.sleep(4000);
		//verify the New Bank Deposit
		if(newBankDeposit.getText().equals("New Bank Deposit"))
		{
			test.log(LogStatus.PASS, "New Bank Deposit form is displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Bank deposit form is not displayed");
		}
		
		//Get the input value before entering any text
		String s = depositAmount_input.getAttribute("value");
		
		//verify the deposit amount field in initial
		if(s.equals("0.00"))
		{
			test.log(LogStatus.PASS, "When user click the add deposit button then the deposit amount is 0");
		}
		else
		{
			test.log(LogStatus.FAIL, "When user click the add deposit button then the deposit amount is not 0");
		}
		
		//check whether the save button is enabled or not when user open the new deposit form
		if(saveBtn_Disabled.isDisplayed())
		{
			test.log(LogStatus.PASS, "Save button is disabled when user click the add deposit button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Save button is enabled when user click the add deposit button");
		}
		
	}
	
	public void saveDisabled() {
		//check whether the save button is enabled or not when user open the new denomination form
		if(saveBtn_Disabled.isDisplayed())
		{
			test.log(LogStatus.PASS, "Save button is disabled when user click the add denomination button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Save button is enabled when user click the add denomination button");
		}
	}
	
	public void enterTheNewDepositAmount() throws InterruptedException {
		Thread.sleep(2000);
		//Enter the value Deposit amount
		depositAmount_input.clear();
		
		depositAmount_input.sendKeys("1000");

	}
	
	public void enterTheNewInvalidDepositAmount() throws InterruptedException {
		
		//Enter the value Deposit amount
		depositAmount_input.clear();
		
		//Get the input value before entering any text
		//String s = depositAmount_input.getAttribute("value");
		//System.out.println("Initial Depopsite Amount is : "+s);
		
		depositAmount_input.sendKeys("AA$$$sss");
		
		//Get the input value after entering the text
		String s1 = depositAmount_input.getAttribute("value");
		System.out.println("After Entering the invalid depopsit amount : "+s1);
		
		//Compare the value of before and after entered values
		if(s1.equals("0.00"))
		{
			test.log(LogStatus.PASS, "The entered string is not available in the Deposit amount input text box");
		}
		else
		{
			test.log(LogStatus.FAIL, "The entered string is not available in the Deposit amount input text box");
		}
		Thread.sleep(3000);
	}
	
	public void selectTheBusinessDate() throws InterruptedException {
		/*
		 * Thread.sleep(3000); //enter the invalid text in calendar area
		 * datePicker_input.sendKeys("sss##AAAAA");
		 * 
		 * //check whether the save button is enabled or not when user enter the invalid
		 * date if(saveBtn_Disabled.isDisplayed()) { test.log(LogStatus.PASS,
		 * "Save button is disabled when user enter the invalid date"); } else {
		 * test.log(LogStatus.FAIL,
		 * "Save button is enabled when user enter the invalid date"); }
		 */
		
		Thread.sleep(3000);
		
		//click the calendar button
		datePicker_calenderIcon.click();Thread.sleep(500);
		
		//Select the current date
		currentDate.click();
	}
	
	public void click_SaveBtn_Of_NewDeposite() {
		//Click the Save button
		SaveBtn_BankDeposit.click();
	}
	
	public void click_CancelBtn_Of_NewDeposite() {
		//Click the Cancel button
		CancelBtn_BankDeposit.click();
	}
	
	public void click_CloseBtn_Of_NewDeposite() {
		//Click the Close button
		close_Btn.click();
	}
	
	
	public void clickTheDenominationsBtn() throws Exception {
		Thread.sleep(1500);
		//Click the denomination 
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);Thread.sleep(1500);
		Denominations.click();Thread.sleep(1000);
		
		//check whether the application 
		if(AddDenominationBtn.isDisplayed())
		{
			test.log(LogStatus.PASS, "Application displays the Add denomination button after clicking the Dinomination tab");
		}
		else
		{
			test.log(LogStatus.PASS, "Application not displays the Add denomination button after clicking the Dinomination tab");	
		}
	}
	
	public void clickTheNewDenomination() {
		//Click the addDenominationBtn
		AddDenominationBtn.click();
		
		//Chcek whether the display name is displayed or not
		
				if(newDenomination.getText().equals("New Denomination"))
				{
					test.log(LogStatus.PASS, "New Denomination form is displayed");
				}
				else
				{
					test.log(LogStatus.FAIL, "New Denomination form is not displayed");
				}
				
				//check whether the display name is displayed or not
				if(DisplyName_Denomination.isDisplayed())
				{
					test.log(LogStatus.PASS, "Display name is displayed successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Display name is not displayed");
				}
				
				//Get the input value before entering any text
				String s = amount_Denomination.getAttribute("value");
				
				//verify the deposit amount field in initial
				if(s.equals("0.00"))
				{
					test.log(LogStatus.PASS, "When user click the add denomination button then the amount is 0");
				}
				else
				{
					test.log(LogStatus.FAIL, "When user click the add denomination button then the amount is not 0");
				}
				
				try {
					//check whether the save button is enabled or not when user open the new deposit form
					if(saveBtn_Disabled.isDisplayed())
					{
						test.log(LogStatus.PASS, "Save button is disabled when user click the add denomination button");
					}
				}
				catch(Exception w)
				{
					test.log(LogStatus.FAIL, "Save button is enabled when user click the add denomination button");
				}
	}
	
	public void emptyDisplayName() {
		DisplyName_Denomination.clear();
		//Enter the empty display name
		DisplyName_Denomination.sendKeys("");
	}
	
	public void validDisplayName() {
		DisplyName_Denomination.clear();
		//Enter the valid display name
		DisplyName_Denomination.sendKeys(RandomStringUtils.randomAlphanumeric(5));
	}
	
	public void invalidDisplayName() {
		DisplyName_Denomination.clear();
		//Enter the invalid display name
		DisplyName_Denomination.sendKeys(RandomStringUtils.randomAlphanumeric(26));
	}
	
	
	public void emptyDenominationAmount() {
		//Enter the empty denomination amount
		amount_Denomination.sendKeys("");
	}
	
	public void validDenominationAmount() {
		//Enter the valid denomination amount
		amount_Denomination.sendKeys("200");
	}
	
	public void invalidDenominationAmountNegative() {
		
		//Enter the value denomination amount
		amount_Denomination.clear();
		
		//Get the input value before entering any text
		String s = amount_Denomination.getAttribute("value");
		
		amount_Denomination.sendKeys("-200");
		
		//Get the input value after entering the text
		String s1 = amount_Denomination.getAttribute("value");
		
		//Compare the value of before and after entered values
		if(s.equals(s1))
		{
			test.log(LogStatus.PASS, "The entered string is not available");
		}
		else
		{
			test.log(LogStatus.FAIL, "The entered string is available");
		}
		
		//Enter the invalid denomination amount
		//amount_Denomination.sendKeys("-200");
	}
	
	public void invalidDenominationAmount() {
		
		//Enter the value denomination amount
		amount_Denomination.clear();
		
		//Get the input value before entering any text
		String s = amount_Denomination.getAttribute("value");
		
		amount_Denomination.sendKeys("ss$$$123");
		
		//Get the input value after entering the text
		String s1 = amount_Denomination.getAttribute("value");
		
		//Compare the value of before and after entered values
		if(s.equals(s1))
		{
			test.log(LogStatus.PASS, "The entered string is not available");
		}
		else
		{
			test.log(LogStatus.FAIL, "The entered string is available");
		}
		//Enter the invalid denomination amount
		//amount_Denomination.sendKeys("a2$$");
	}
	
	public void clickCancelBtn() {
		//Click the cancel button
		CancelBtn_BankDeposit.click();
	}
	
	public void clickArrowbtnOfRowsPerPage() {
		//Click the Arrow button of Rows per page
		rowsPerPage_btn.click();
	}
	
	public void clickFiveRowsBtn() {
		//Click the five rows per page button
		fiveRows_Denomination.click();
	}
	
	public void clickTenRowsBtn() {
		//Click the ten rows per page button
		tenRows_Option.click();
	}
	
	public void clickFifteenRowsBtn() {
		//Click the fifteen rows per page button
		fifteenRows_Option.click();
	}
	
	public void clickTwentyRowsBtn() {
		//Click the twenty rows per page button
		twentyRows_Option.click();
	}
	
	public int getRowsCount() {
		List<WebElement> s  = driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/data-grid-row/div/div[3]/button"));
		int ss = s.size();
		return ss;
	}
	
	public void clickTheDeleteBtn() {
		//Click the delete button
		deleteButton_Denomination.click();
	}
	
	public void clickTheDeleteConfirmationBtn() {
		//Click the delete confirmation button
		deleteConfirmationBtn.click();
	}
	
	public void checkThePagination() {
		//div[@class='pagination-component']/div/div[2]/button/span[1]
		//Get the text of pages
		
		List<WebElement> sa = driver.findElements(By.xpath("//div[@class='pagination-component']/div/div"));
		
		int n = sa.size() - 1;
		
		String s = driver.findElement(By.xpath("//div[@class='pagination-component']/div/div["+n+"]/button/span[1]")).getText();
		s = s.replaceAll(" ", "");
		
		int sd = Integer.parseInt(s);
		
		if(sd == 1) {
			//rows in the table
			//div[@class='data-grid']/div[3]/div
		}
		
		if (sd <= 5)
		{}
		else
		{
			for(int i = 1; sd >=  5; i++)
			{
				System.out.println("i : "+i);
			}
		}
		
	}
	
	public void Ascending_And_Descending_Order() {
		List<WebElement> col = driver.findElements(By.xpath("//data-grid-row/div/div/div/span[@class='header-title']"));
		
		for(int i = 1; i <= col.size(); i++) {
			
			
			//double click the required row for descending order
			driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/span[@class='header-title']")).click();
			
			ArrayList<String> ArLst=new ArrayList<String>();
			
			if(driver.findElement(By.xpath("//data-grid-row/div/div["+i+"]/div/div[contains(@class,'mode-asc')]")).isDisplayed())
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

	@FindBy(xpath =  "//span[contains(.,'Close') and contains(@class,'mat-button')]")
	WebElement Close_btn;
	
	@FindBy(xpath =  "//button[@type='button']/span[contains(.,'Cancel')]")
	WebElement Cancel_btn;
	
	@FindBy(xpath =  "//span[contains(.,'Delete')]")
	WebElement Delete_btn;
	
	public void Delete_Denomination() throws InterruptedException {
		
		Thread.sleep(3000);
		
		List<WebElement> col = driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list grid-rows')]/div"));
		
		String as = driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list grid-rows')]/div["+col.size()+"]/div/data-grid-row/div/div[1]/span")).getText();
				
		//click the delete button
		driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list grid-rows')]/div["+col.size()+"]/div/data-grid-row/div/div[3]/div/button")).click();
		
		//click the close button
		Close_btn.click();
		Thread.sleep(1000);
		//click the delete button
		driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list grid-rows')]/div["+col.size()+"]/div/data-grid-row/div/div[3]/div/button")).click();
		Thread.sleep(1000);
		//click the close button
		Cancel_btn.click();
		
		//click the delete button
		driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list grid-rows')]/div["+col.size()+"]/div/data-grid-row/div/div[3]/div/button")).click();
		
		//click the close button
		Delete_btn.click();
		
		if(successMessage.getText().equals("Denomination Deleted Successfully")) {
			test.log(LogStatus.PASS, "Denomination Deleted Successfully popup displayed after click the delete button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Denomination Deleted Successfully popup is not displayed after click the delete button");
		}
		
		//clear the search field
		search_denomination.clear();
		
		//enter the required text in the Search bar
		search_denomination.sendKeys(as);
		
		Thread.sleep(5000);
		
		List<WebElement> xs = driver.findElements(By.xpath("//span[contains(.,'Denominations not found')]"));
		
		if(xs.size() == 1) {
			test.log(LogStatus.PASS, "Deleted denomination not found after deleting the denomination");
		}
		else if(xs.size() == 0)
		{
			test.log(LogStatus.FAIL, "Deleted denomination found after deleting the denomination");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
}