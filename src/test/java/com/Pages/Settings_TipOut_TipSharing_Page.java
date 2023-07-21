package com.Pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.maven.surefire.shared.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.Utility;

public class Settings_TipOut_TipSharing_Page {
	WebDriver driver;
	ExtentTest test;
	Common_XPaths cmp;
	Utility ut=new Utility();
	
	public Settings_TipOut_TipSharing_Page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='settings']/button")
	WebElement Settings;
	
	@FindBy(xpath = "//h3[contains(.,'Settings')]")
	WebElement Settings_Heading;
	
	@FindBy(xpath = "//span[.='Tip Out & Tip Sharing']")
	WebElement TipOutTipSharing;
	
	@FindBy(xpath = "//h3[contains(.,'Tip Out & Tip Sharing')]")
	WebElement TipOutTipSharing_Heading;
	
	@FindBy(xpath = "//h3[contains(.,'New Tip Out')]")
	WebElement NewTipOut_Heading;
	
	@FindBy(xpath = "//button[contains(.,'SAVE')]")
	WebElement TipSaveBtn;
	
	@FindBy(xpath = "//button[contains(.,'Save') and @disabled='true']")
	WebElement SaveBtnDisabled;
	
	@FindBy(xpath = "//button[contains(.,'Save')]")
	WebElement SaveBtn;
	
	@FindBy(xpath = "//div[contains(.,'TIP OUTS') and @class='mat-tab-label-content']")
	WebElement TipOutsTab;
	
	@FindBy(xpath = "//div[contains(.,'TIP SHARING') and @class='mat-tab-label-content']")
	WebElement TipSharingTab;
	
	@FindBy(xpath =  "//span[.='Tip out based on percentage of sales']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement TipOutBasedOnPercentageOfSales_NoBtn;
	
	@FindBy(xpath =  "//span[.='Tip out based on percentage of sales']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement TipOutBasedOnPercentageOfSales_YesBtn;
	
	@FindBy(xpath =  "//span[.='Tip Share Per Hour']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement TipSharePerHour_NoBtn;
	
	@FindBy(xpath =  "//span[.='Tip Share Per Hour']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement TipSharePerHour_YesBtn;
	
	@FindBy(xpath = "//button[contains(.,'TIP OUT')]")
	WebElement AddTipOutBtn;
	
	@FindBy(xpath =  "//data-grid/div/div/div[1]/div[1]/data-grid-row/div/div[6]/div/button")
	WebElement Delete_btn_FirstRow;
	
	@FindBy(xpath =  "//span[contains(.,'Rows per page:')]/../../div[2]/app-selectbox/div/mat-form-field/div")
	WebElement rowsPerPage_btn;
	
	@FindBy(xpath =  "//select-option[1]/div")
	WebElement fiveRows_Option;
	
	@FindBy(xpath =  "//select-option[2]/div")
	WebElement tenRows_Option;
	
	@FindBy(xpath =  "//select-option[3]/div")
	WebElement fifteenRows_Option;
	
	@FindBy(xpath =  "//select-option[4]/div")
	WebElement twentyRows_Option;
		
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement Search_option;
	
	@FindBy(xpath =  "//span[contains(.,'keyboard_backspace')]")
	WebElement Back_btn;
	
	@FindBy(xpath =  "//span[contains(.,'Close')]/../../button")
	WebElement Close_btn;
	
	@FindBy(xpath =  "//span[contains(.,'Cancel')]/../../button[@type]")
	WebElement Cancel_btn;
	
	@FindBy(xpath =  "//span[contains(.,'Delete')]/../../button")
	WebElement Delete_btn;
	
	@FindBy(xpath =  "//span[contains(.,'Tip Out Name')]/../input")
	WebElement TipOutNameInput;
	
	@FindBy(xpath =  "//span[contains(.,'Role From')]/../input")
	WebElement RoleFromInput;
	
	@FindBy(xpath =  "//span[contains(.,'Role To')]/../input")
	WebElement RoleToInput;
		
	@FindBy(xpath =  "//span[contains(.,'Select Departments')]/../div/div/input")
	WebElement SelectDepartments;
		
	@FindBy(xpath =  "//span[contains(.,'Percentage')]/../input")
	WebElement Percentage;
	
	@FindBy(xpath =  "//span[contains(.,'Percentage')]/../../../../../div/button[1]")
	WebElement Percentage_Up;
	
	@FindBy(xpath =  "//span[contains(.,'Percentage')]/../../../../../div/button[2]")
	WebElement Percentage_Down;
	
	@FindBy(xpath =  "//span[.='Manual Tip Sharing']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement ManualTipSharing_NoBtn;
	
	@FindBy(xpath =  "//span[.='Manual Tip Sharing']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement ManualTipSharing_YesBtn;
		
	@FindBy(xpath =  "//span[contains(.,'Choose Roles')]/../div/div/input")
	WebElement ManualTipsharing_ChooseRoles;
	
	@FindBy(xpath =  "//span[contains(.,' Manual Tip Sharing')]/../../div[3]/app-auto-complete")
	WebElement ManualTipsharing_ChooseRoless;
	
	@FindBy(xpath =  "//span[contains(.,' Automatic Tip Sharing')]/../../div[3]/app-auto-complete")
	WebElement ManualTipsharing_ChooseRolesa;
	
	@FindBy(xpath =  "//button/span/mat-icon[.='close']")
	WebElement Close_ChooseRoles;
	
	@FindBy(xpath =  "//span[contains(.,' Include Below in Tip Share')]/../div/mat-checkbox")
	WebElement IncludeBelowInTipShare;
	
	//mat-chip/div/mat-icon[.='cancel']
	
	//div/mat-icon[.='close']
	
	@FindBy(xpath =  "//span[.='Automatic Tip Sharing']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement AutomaticTipSharing_NoBtn;
	
	@FindBy(xpath =  "//span[.='Automatic Tip Sharing']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement AutomaticTipSharing_YesBtn;
	
	@FindBy(xpath =  "//span[.='Tip Charge Deduction Before Tip Share']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[1]/button")
	WebElement TipChargeDeductionBeforeTipShare_NoBtn;
	
	@FindBy(xpath =  "//span[.='Tip Charge Deduction Before Tip Share']/../..//div[2]/mat-button-toggle-group/mat-button-toggle[2]/button")
	WebElement TipChargeDeductionBeforeTipShare_YesBtn;
	
	@FindBy(xpath =  "//span[contains(.,'TIP OUT NAME') and @class='header-title']")
	WebElement TipOutName_Title;
	
	@FindBy(xpath =  "//span[contains(.,'ROLE FROM') and @class='header-title']")
	WebElement RoleFrom_Title;
	
	@FindBy(xpath =  "//span[contains(.,'ROLE TO') and @class='header-title']")
	WebElement RoleTo_Title;
	
	@FindBy(xpath =  "//span[contains(.,'DEPARTMENTS') and @class='header-title']")
	WebElement Departments_Title;
	
	@FindBy(xpath =  "//span[contains(.,'PERCENTAGE') and @class='header-title']")
	WebElement Percentage_Title;
	
	@FindBy(xpath =  "//span[contains(.,'PERCENTAGE') and @class='header-title']")
	WebElement Column_option;
	
		
	public void paginationValidation() throws Exception {
		
		//get the total number of pages
		List<WebElement> s = driver.findElements(By.xpath("//div[@class='col-auto ng-star-inserted']/button[contains(@class,'page-button mat-stroked-button')]"));
				
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
	
	public void Filter_Columns() throws Exception
	{
		Thread.sleep(3000);
		Column_option.click();
		
		//Deselect Select All
		driver.findElement(By.xpath("//div[contains(@class,'options')]/select-option[1]")).click();
		Thread.sleep(500);
		
		Thread.sleep(1000);
		List<WebElement> FilterList=driver.findElements(By.xpath("//div[contains(@class,'options')]/select-option"));
				
		for(int i = 2; i <= FilterList.size(); i++)
		{
			driver.findElement(By.xpath("//div[contains(@class,'options')]/select-option["+i+"]")).click();
			
			if(driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[1]/div/span")).getText().equalsIgnoreCase(driver.findElement(By.xpath("//div[contains(@class,'options')]/select-option["+i+"]/div")).getText()))
				
			{
				test.log(LogStatus.PASS, driver.findElement(By.xpath("//div[contains(@class,'options')]/select-option["+i+"]/div")).getText()+ " Filtered Successfully");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, driver.findElement(By.xpath("//div[contains(@class,'options')]/select-option["+i+"]/div")).getText()+ " Filter Unsuccessful. Wrongly filtered as "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div[1]/div/span")).getText());
				
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
			driver.findElement(By.xpath("//div[contains(@class,'options')]/select-option["+i+"]")).click();
		}
		
		driver.findElement(By.xpath("//div[contains(@class,'options')]/select-option[1]")).click();
		Thread.sleep(3000);
		Column_option.click();Thread.sleep(3000);
	}
		
	public void search() throws InterruptedException {
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		Thread.sleep(5000);
		
		Search_option.clear();
		Thread.sleep(5000);
		
		//Get the value from the table
		String sa = driver.findElement(By.xpath("//data-grid/div/div/div[1]/div[1]/data-grid-row/div/div[1]/span")).getText();
		
		List<WebElement> qw = driver.findElements(By.xpath("//data-grid/div/div/div[1]/div[1]/data-grid-row/div/div/span"));
															
		Search_option.sendKeys(sa);
		
		Thread.sleep(5000);
		
		List<WebElement> qw1 = driver.findElements(By.xpath("//data-grid/div/div/div[1]/div[1]/data-grid-row/div/div/span"));
		
		//Get the value from the table
		String sa1 = driver.findElement(By.xpath("//data-grid/div/div/div[1]/div[1]/data-grid-row/div/div[1]/span")).getText();
	
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
				
		TipOutTipSharing.click();
		
		Thread.sleep(5000);
	}
	
	public void delete() throws InterruptedException {
		
		Search_option.clear();
		Thread.sleep(15000);
		
		//Get the value from the table
		String sa = driver.findElement(By.xpath("//data-grid/div/div/div/div[1]/data-grid-row/div/div[1]/span")).getText();
		
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
		
		Thread.sleep(5000);
	
		Search_option.sendKeys(sa);
		
		Thread.sleep(5000);
		
		try {
			if(driver.findElement(By.xpath("//div/span[.='Tipout&Tipsharing not found']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Tipout&Tipsharing not found message is displayed, when user delete the particular Tip");
			}
			else {
				test.log(LogStatus.FAIL, "Tipout&Tipsharing is found, when user delete the particular Tip");
			}
		}catch(Exception fd)
		{
			test.log(LogStatus.FAIL, "Tipout&Tipsharing is found, when user delete the particular Tip");
		}
		
		Search_option.clear();
		
		Back_btn.click();
		
		Thread.sleep(5000);
		
		TipOutTipSharing.click();
		
		Thread.sleep(5000);
		
	}
	
	public void TipOutPage() throws InterruptedException {
		Thread.sleep(2000);
		cmp=new Common_XPaths(driver, test);
		if(TipOutTipSharing_Heading.isDisplayed()) {
			test.log(LogStatus.PASS, "Tip Out and Tip Sharing heading is displayed in Tip Out and Tip Sharing page");
		}
		else {
			test.log(LogStatus.FAIL, "Tip Out and Tip Sharing is not displayed in Tip Out and Tip Sharing page");
		}
//		cmp.VerifyCreationScreenPageHeader("Tip Out & Tip Sharing");
		
		if(TipSaveBtn.isDisplayed()) {
			test.log(LogStatus.PASS, "Save button is displayed in Tip Out and Tip Sharing page");
		}
		else {
			test.log(LogStatus.FAIL, "Save button is displayed in Tip Out and Tip Sharing page");
		}
			
		if(TipOutsTab.isDisplayed()) {
			test.log(LogStatus.PASS, "Tip Out tab is displayed in Tip Out and Tip Sharing page");
		}
		else {
			test.log(LogStatus.FAIL, "Tip Out tab is displayed in Tip Out and Tip Sharing page");
		}
		
		if(TipSharingTab.isDisplayed()) {
			test.log(LogStatus.PASS, "Tip Sharing tab is displayed in Tip Out and Tip Sharing page");
		}
		else {
			test.log(LogStatus.FAIL, "Tip Sharing tab is displayed in Tip Out and Tip Sharing page");
		}
		
		if(TipOutBasedOnPercentageOfSales_NoBtn.isDisplayed()) {
			test.log(LogStatus.PASS, "Tip Out Based On Percentage Of Sales option is displayed in Tip Out and Tip Sharing page");
		}
		else {
			test.log(LogStatus.FAIL, "Tip Out Based On Percentage Of Sales option is displayed in Tip Out and Tip Sharing page");
		}
	}
	
	public void TipOut() throws Exception {
		Thread.sleep(2000);
		
		//Click the disable button of Tip out based on percentage of sales
		TipOutBasedOnPercentageOfSales_NoBtn.click();
		
		try {
			if(TipSharePerHour_NoBtn.isDisplayed()) {
				test.log(LogStatus.FAIL, "After disabling the Tip Out Based On Percentage Of Sales button Tip Share Per Hour option is displayed");
			}
		}catch(Exception ds) {
			test.log(LogStatus.PASS, "After disabling the Tip Out Based On Percentage Of Sales button Tip Share Per Hour option is not displayed");
		}
		
		//Click the Save button
		TipSaveBtn.click();
		
		Thread.sleep(2000);
		
		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s.equals("Tip Out/Tip Sharing Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Tip Out/Tip Sharing Updated Successfully message is displayed when user update the Tip Out/Tip Sharing");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Out/Tip Sharing Updated Successfully message not displayed when user update the Tip Out/Tip Sharing");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		//Click the enable button of Tip out based on percentage of sales
		TipOutBasedOnPercentageOfSales_YesBtn.click();
		
		try {
			if(TipSharePerHour_NoBtn.isDisplayed()) {
				test.log(LogStatus.PASS, "After enabling the Tip Out Based On Percentage Of Sales button Tip Share Per Hour option is displayed");
			}
		}catch(Exception ds) {
			test.log(LogStatus.FAIL, "After enabling the Tip Out Based On Percentage Of Sales button Tip Share Per Hour option is not displayed");
		}
		
		//Click the Save button
		TipSaveBtn.click();
		
		Thread.sleep(2000);
		
		String s1 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s1.equals("Tip Out/Tip Sharing Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Tip Out/Tip Sharing Updated Successfully message is displayed when user update the Tip Out/Tip Sharing");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Out/Tip Sharing Updated Successfully message not displayed when user update the Tip Out/Tip Sharing");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);

		TipSharePerHour_NoBtn.click();
		
		//Click the Save button
		TipSaveBtn.click();
		
		Thread.sleep(2000);
		
		String s2 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s2.equals("Tip Out/Tip Sharing Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Tip Out/Tip Sharing Updated Successfully message is displayed when user update the Tip Out/Tip Sharing");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Out/Tip Sharing Updated Successfully message not displayed when user update the Tip Out/Tip Sharing");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		

		TipSharePerHour_YesBtn.click();
		
		//Click the Save button
		TipSaveBtn.click();
		
		Thread.sleep(2000);
		
		String s3 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s3.equals("Tip Out/Tip Sharing Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Tip Out/Tip Sharing Updated Successfully message is displayed when user update the Tip Out/Tip Sharing");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Out/Tip Sharing Updated Successfully message not displayed when user update the Tip Out/Tip Sharing");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		//Click the Add Tipout button
		AddTipOutBtn.click();
		
		Thread.sleep(1000);
		
		try {
			if(NewTipOut_Heading.isDisplayed()) {
				test.log(LogStatus.PASS, "New Tipout page is displayed when user click the Add Tipout button");
			}
		}catch(Exception ds) {
			test.log(LogStatus.FAIL, "New Tipout page is not displayed when user click the Add Tipout button");
		}
		
		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save(Disabled) button is displayed when user click the Add Tipout button");
			}
		}catch(Exception ds) {
			test.log(LogStatus.FAIL, "Save(Disabled) button is not displayed when user click the Add Tipout button");
		}
		
		TipOutNameInput.clear();
		
		TipOutNameInput.sendKeys(RandomStringUtils.randomAlphanumeric(26));
		
		int cnt = TipOutNameInput.getAttribute("value").length();
		
		if(cnt == 25)
		{
			test.log(LogStatus.PASS, "Tip out name field accepts only 25 characters");
		}
		else if(cnt == 26) {
			test.log(LogStatus.FAIL, "Tip out name field accepts more than 25 characters");
		}
		
		for(int i = 1; i <= 26; i++) {
			TipOutNameInput.sendKeys(Keys.BACK_SPACE);
		}
		
		
		try {
			if(driver.findElement(By.xpath("//p[.='Please Enter TipOut Name']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Please Enter TipOut Name validation message is displayed when user clear the Tipout name field");
			}
		}catch(Exception d) {
			test.log(LogStatus.FAIL, "Please Enter TipOut Name validation message is not displayed when user clear the Tipout name field");
		}
		
		String tip = RandomStringUtils.randomAlphanumeric(12);
		
		TipOutNameInput.sendKeys(tip);
		
		RoleFromInput.click();
		
		List<WebElement> menuList=driver.findElements(By.xpath("//select-option"));

		int menuSize=menuList.size();

		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);

		WebElement element = driver.findElement(By.xpath("//select-option["+randomMenu+"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();
		
		RoleToInput.click();
		
		List<WebElement> menuList1=driver.findElements(By.xpath("//select-option"));

		int menuSize1=menuList1.size();

		int randomMenu1=ThreadLocalRandom.current().nextInt(1, menuSize1);

		WebElement element1 = driver.findElement(By.xpath("//select-option["+randomMenu1+"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		Thread.sleep(500);
		element1.click();
		
		SelectDepartments.click();
		
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//select-option[1]")).click();
		
		Thread.sleep(3000);

			driver.findElement(By.xpath("(//mat-icon[.='close'])[2]")).click();

			List<WebElement> menuList21=driver.findElements(By.xpath("//select-option"));

			if(menuList21.size()!=0)
			{
			SelectDepartments.click();
			}
		Thread.sleep(2000);
		
		verifyThePercentageFunctionalities();
		
		SelectDepartments.click();
		
		List<WebElement> menuList2=driver.findElements(By.xpath("//select-option"));

		int menuSize2=menuList2.size();

		int randomMenu2=ThreadLocalRandom.current().nextInt(2, menuSize2);

		WebElement element2 = driver.findElement(By.xpath("//div["+randomMenu2+"]/select-option"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		Thread.sleep(500);
		element2.click();
		
		List<WebElement> menuList22=driver.findElements(By.xpath("//select-option"));

		if(menuList22.size()!=0)
		{
		SelectDepartments.click();
		}
		Thread.sleep(3000);
		
		//Click the Save button
		SaveBtn.click();
		
		Thread.sleep(3000);
		
		Search_option.clear();
		
		Search_option.sendKeys(tip);
		
		List<WebElement> qw = driver.findElements(By.xpath("//data-grid/div/div/div[1]/div[1]/data-grid-row/div/div/span"));
		
		Thread.sleep(5000);
		
		List<WebElement> qw1 = driver.findElements(By.xpath("//data-grid/div/div/div[1]/div[1]/data-grid-row/div/div/span"));
		
		//Get the value from the table
		String sa1 = driver.findElement(By.xpath("//data-grid/div/div/div[1]/div[1]/data-grid-row/div/div[1]/span")).getText();
	
		if(tip.equals(sa1))
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
		
		//Click the Save button
		TipSaveBtn.click();
		
		Thread.sleep(2000);
		
		String s4 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s4.equals("Tip Out/Tip Sharing Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Tip Out/Tip Sharing Updated Successfully message is displayed when user update the Tip Out/Tip Sharing");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Out/Tip Sharing Updated Successfully message not displayed when user update the Tip Out/Tip Sharing");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);

	}

	
	public void TipSharing() throws Exception {
		
		
		Thread.sleep(2000);
		
		TipSharingTab.click();
		
		Thread.sleep(2000);
		
		
		//Click the disable button of manual tip sharing
		ManualTipSharing_NoBtn.click();
		
		try {
			if(ManualTipsharing_ChooseRoless.isDisplayed()) {
				test.log(LogStatus.FAIL, "After disabling the Manual Tip Sharing then Roles option is displayed");
			}
		}catch(Exception ds) {
			test.log(LogStatus.PASS, "After disabling the Manual Tip Sharing then Roles option is not displayed");
		}
		
		
		if(TipSaveBtn.isEnabled())
		{
		//Click the Save button
		TipSaveBtn.click();
		
		Thread.sleep(2000);
		
		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s.equals("Tip Out/Tip Sharing Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Tip Out/Tip Sharing Updated Successfully message is displayed when user update the Tip Out/Tip Sharing");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Out/Tip Sharing Updated Successfully message not displayed when user update the Tip Out/Tip Sharing");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		}
		else
		{
			test.log(LogStatus.INFO, "Save button is not Enabled");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		try {
			TipSharingTab.click();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		//Click the enable button of manual tip sharing
		ManualTipSharing_YesBtn.click();
		
		try {
			if(ManualTipsharing_ChooseRoless.isDisplayed()) {
				test.log(LogStatus.PASS, "After enabling the Manual Tip Sharing then Roles option is displayed");
			}
		}catch(Exception ds) {
			test.log(LogStatus.FAIL, "After enabling the Manual Tip Sharing then Roles option is not displayed");
		}
		
		//Click the close button of Roles
		try {Close_ChooseRoles.click();
		Thread.sleep(3000);
		ManualTipsharing_ChooseRoles.click();
		Thread.sleep(3000);
		ManualTipsharing_ChooseRoles.click();	
		}catch(Exception sq) {
			ManualTipsharing_ChooseRoles.click();	
		}
				
		Thread.sleep(500);
		
		List<WebElement> menuList2=driver.findElements(By.xpath("//select-option"));

		int menuSize2=menuList2.size();

		int randomMenu2=ThreadLocalRandom.current().nextInt(2, menuSize2);

		Thread.sleep(1500);driver.findElement(By.xpath("//div["+randomMenu2+"]/select-option")).click();
		//WebElement element2 = driver.findElement(By.xpath("//div["+randomMenu2+"]/select-option"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element2);
		//Thread.sleep(1500);
		//element2.click();
			
		//Click the Save button
		TipSaveBtn.click();
		
		Thread.sleep(2000);
		
		String s1 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s1.equals("Tip Out/Tip Sharing Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Tip Out/Tip Sharing Updated Successfully message is displayed when user update the Tip Out/Tip Sharing");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Out/Tip Sharing Updated Successfully message not displayed when user update the Tip Out/Tip Sharing");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);

		try {
			TipSharingTab.click();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		//Click the disable button of automatic tip sharing
		AutomaticTipSharing_NoBtn.click();
		
		try {
			if(ManualTipsharing_ChooseRolesa.isDisplayed()) {
				test.log(LogStatus.FAIL, "After disabling the Automatic Tip Sharing then Roles option is displayed");
			}
		}catch(Exception ds) {
			test.log(LogStatus.PASS, "After disabling the Automatic Tip Sharing then Roles option is not displayed");
		}
		
		//Click the Save button
		TipSaveBtn.click();
		
		Thread.sleep(2000);
		try {
		String sa = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(sa.equals("Tip Out/Tip Sharing Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Tip Out/Tip Sharing Updated Successfully message is displayed when user update the Tip Out/Tip Sharing");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Out/Tip Sharing Updated Successfully message not displayed when user update the Tip Out/Tip Sharing");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		}catch (Exception e) {
			// TODO: handle exception
		}
		try {
			TipSharingTab.click();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		//Click the enable button of automatic tip sharing
		AutomaticTipSharing_YesBtn.click();
		
		try {
			if(ManualTipsharing_ChooseRolesa.isDisplayed()) {
				test.log(LogStatus.PASS, "After enabling the Automatic Tip Sharing then Roles option is displayed");
			}
		}catch(Exception ds) {
			test.log(LogStatus.FAIL, "After enabling the Automatic Tip Sharing then Roles option is not displayed");
		}
		
//		driver.findElement(By.xpath("//div[@class='form-card']")).click();
		for(int i=1;i<=5;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		
		//Click the close button of Roles
		try {Close_ChooseRoles.click();
		Thread.sleep(1000);
		ManualTipsharing_ChooseRoles.click();
		
		ManualTipsharing_ChooseRoles.click();	
		}catch(Exception sq) {
			ManualTipsharing_ChooseRoles.click();	
		}	
		
		Thread.sleep(500);
		
		List<WebElement> menuList=driver.findElements(By.xpath("//select-option"));

		int menuSize=menuList.size();

//		if(menuSize<=6)
//		{
		int randomMenu=ThreadLocalRandom.current().nextInt(2, menuSize);

		WebElement element = driver.findElement(By.xpath("//div["+randomMenu+"]/select-option"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1500);
//		cmp.Cursor_MoveToElement(element);
		
		
		element.click();
//		}
//		else
//		{
//			int randomMenu=ThreadLocalRandom.current().nextInt(2, 6);
//
//			WebElement element = driver.findElement(By.xpath("//select-option["+randomMenu+"]"));
//			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//			Thread.sleep(1500);
////			cmp.Cursor_MoveToElement(element);
//			element.click();
//		}
		List<WebElement> menuList1=driver.findElements(By.xpath("//select-option"));
try {
		if(menuList1.size()!=0)
		{
			Thread.sleep(3000);
			ManualTipsharing_ChooseRoles.click();
			Thread.sleep(3000);
		}
}
catch (Exception e) {
	// TODO: handle exception
	Thread.sleep(1000);
	test.log(LogStatus.FAIL, "Automatic tip sharing not closing properly");
	//JavascriptExecutor js3=(JavascriptExecutor)driver;
	//WebElement menuEle3=driver.findElement(By.xpath("//span[contains(.,' Automatic Tip Sharing')]/../div[contains(.,'Sharing the overall tip Automatic for selected roles')]"));
	//js3.executeScript("arguments[0].scrollIntoView(true);", menuEle3);
	//driver.findElement(By.xpath("//span[contains(.,' Automatic Tip Sharing')]/../div[contains(.,'Sharing the overall tip Automatic for selected roles')]")).click();
	TipSaveBtn.click();
}
		//Click the Save button
		try {
			TipSaveBtn.click();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(2000);
		
		String sa1 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(sa1.equals("Tip Out/Tip Sharing Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Tip Out/Tip Sharing Updated Successfully message is displayed when user update the Tip Out/Tip Sharing");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Out/Tip Sharing Updated Successfully message not displayed when user update the Tip Out/Tip Sharing");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		try {
			TipSharingTab.click();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		//Click the disable button of Tip charge detection before tip share
		TipChargeDeductionBeforeTipShare_NoBtn.click();
		
		//Click the Save button
		TipSaveBtn.click();
		
		Thread.sleep(2000);
		try {
		String sa2 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(sa2.equals("Tip Out/Tip Sharing Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Tip Out/Tip Sharing Updated Successfully message is displayed when user update the Tip Out/Tip Sharing");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Out/Tip Sharing Updated Successfully message not displayed when user update the Tip Out/Tip Sharing");
		}
	
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		Thread.sleep(3000);
		try {
			TipSharingTab.click();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		//Click the enable button of Tip charge detection before tip share
		TipChargeDeductionBeforeTipShare_YesBtn.click();
		
		//Click the Save button
		TipSaveBtn.click();
		
		Thread.sleep(2000);
		
		try {
		String sa3 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(sa3.equals("Tip Out/Tip Sharing Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Tip Out/Tip Sharing Updated Successfully message is displayed when user update the Tip Out/Tip Sharing");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Out/Tip Sharing Updated Successfully message not displayed when user update the Tip Out/Tip Sharing");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		try {
			TipSharingTab.click();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		
		List<WebElement> menuList11=driver.findElements(By.xpath("//span[contains(.,' Include Below in Tip Share')]/../div/mat-checkbox"));

		int menuSize1=menuList11.size();

		int randomMenu1=ThreadLocalRandom.current().nextInt(1, menuSize1);

		Thread.sleep(1500);driver.findElement(By.xpath("//span[contains(.,' Include Below in Tip Share')]/../div["+randomMenu1+"]/mat-checkbox")).click();
		//WebElement element1 = driver.findElement(By.xpath("//span[contains(.,' Include Below in Tip Share')]/../div/mat-checkbox["+randomMenu1+"]"));
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element1);
		//Thread.sleep(1500);
		//element1.click();
		
		Thread.sleep(2000);
		
		
		
		//Click the Save button
		TipSaveBtn.click();
		
		Thread.sleep(2000);
		
		try {
		String sa4 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(sa4.equals("Tip Out/Tip Sharing Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Tip Out/Tip Sharing Updated Successfully message is displayed when user update the Tip Out/Tip Sharing");
		}
		else
		{
			test.log(LogStatus.FAIL, "Tip Out/Tip Sharing Updated Successfully message not displayed when user update the Tip Out/Tip Sharing");
		}
	
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void verifyThePercentageFunctionalities() throws Exception
	{
		
		String u1 =  Percentage.getAttribute("value");
		
		u1 = u1.replace("%", "");
		
		float i1 = Float.parseFloat(u1);
		
		//int i1 = Integer.parseInt(u1);
		
		i1 = i1 + 1;
		
		Thread.sleep(1000);
		//Click the up arrow button
		Percentage_Up.click();
		
		String u1a =  Percentage.getAttribute("value");
		
		u1a = u1a.replace("%", "");
		
		float i1a = Float.parseFloat(u1a);
				
		if(i1 == i1a)
		{
			test.log(LogStatus.PASS, "Increase the value of Percentage is working fine when user click the increase button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of Percentage is not working fine when user click the increase button");
		}
		
		//click the down arrow button
		Percentage_Down.click();
		
		String u2 =  Percentage.getAttribute("value");
		
		u2 = u2.replace("%", "");
		
		float i2 = Float.parseFloat(u2);
		
		if(i2 == (i1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of Percentage is working fine when user click it then it is decreased by 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of Percentage is not working fine when user click it");
		}
		if(i2==0) {
			try {
				if(driver.findElement(By.xpath("//p[.='Please Enter Percentage']")).isDisplayed()) {
					test.log(LogStatus.PASS, "Please Enter Percentage field validation message is displayed when the percentage value is 0");
				}
			}catch(Exception d) {
				test.log(LogStatus.FAIL, "Please Enter Percentage field validation message is not displayed when the percentage value is 0");
			}
		}
		
		Percentage.sendKeys("e");
		
		String u4 =  Percentage.getAttribute("value");
		
		u4 = u4.replace("%", "");
		
		if(u4.contains("e"))
		{
			test.log(LogStatus.FAIL, "The field accept the Alphabets in Percentage");
		}
		else
		{
			test.log(LogStatus.PASS, "The field not accept the Alphabets in Percentage");
		}
		
		Percentage.sendKeys(Keys.ARROW_DOWN);
		
		Percentage.clear();
		
		Percentage_Down.click();
		
		String u5 =  Percentage.getAttribute("value");
		
		u5 = u5.replace("%", "");
		
		//int i5 = Integer.parseInt(u5);
		
		if(u5.contains("-"))
		{
			test.log(LogStatus.FAIL, "The Percentage field accept the negative values");
		}
		else
		{
			test.log(LogStatus.PASS, "The Percentage field is not accept the negative values");
		}
		
		Percentage.clear();
		
		Percentage.sendKeys("50000");
		
		try {
			if(driver.findElement(By.xpath("//p[.='Please Enter Valid Percentage']")).isDisplayed()) {
				test.log(LogStatus.PASS, "Please Enter Valid Percentage field validation message is displayed when the percentage value is more than 100");
			}
		}catch(Exception d) {
			test.log(LogStatus.FAIL, "Please Enter Valid Percentage field validation message is not displayed when the percentage value is more than 100");
		}
		
		Percentage.clear();
		
		Percentage.sendKeys("500");
	}
	
}

	
