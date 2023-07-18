package com.Pages;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

public class Settings_Printer_Rerouting_Page {
	WebDriver driver;
	ExtentTest test;
	Common_XPaths cmp;
	Utility ut=new Utility();
	
	public Settings_Printer_Rerouting_Page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='settings']/button")
	WebElement Settings;
	
	@FindBy(xpath = "//h3[contains(.,'Settings')]")
	WebElement Settings_Heading;
	
	@FindBy(xpath = "//h3[contains(.,'Printer Rerouting')]")
	WebElement PrinterRerouting_Heading;
	
	@FindBy(xpath = "//button[contains(.,'REROUTE BY NODE ')]")
	WebElement AddRerouteBtn;
	
	@FindBy(xpath = "(//button[contains(.,'REROUTE BY NODE')])[2]")
	WebElement RerouteByNodeTab;
	
	@FindBy(xpath = "//button[contains(.,'REROUTE BY ROLE')]")
	WebElement RerouteByRoleTab;
	
	@FindBy(xpath = "(//button[contains(.,'REROUTE BY ROLE')])[1]")
	WebElement AddRerouteRoleBtn;
	
	@FindBy(xpath = "//span[contains(.,'Node') and @class='header-title']")
	WebElement Node_TableHeading;
	
	@FindBy(xpath = "//span[contains(.,'Role') and @class='header-title']")
	WebElement Role_TableHeading;
	
	@FindBy(xpath = "//span[contains(.,'From Printer') and @class='header-title']")
	WebElement FromPrinter_TableHeading;
	
	@FindBy(xpath = "//span[contains(.,'To Printer') and @class='header-title']")
	WebElement ToPrinter_TableHeading;
	
	@FindBy(xpath = "//div[contains(.,'Action') and contains(@class,'data-grid-header ')]")
	WebElement Action_TableHeading;
	
	@FindBy(xpath = "//span[contains(.,'COLUMNS')]/../../button")
	WebElement Column_option;
		
	@FindBy(xpath = "//input[@placeholder='Search']")
	WebElement Search_option;
	
	@FindBy(xpath =  "//span[contains(.,'keyboard_backspace')]")
	WebElement Back_btn;

	@FindBy(xpath =  "//data-grid/div/div/div[1]/div[1]/data-grid-row/div/div[4]/div[2]/button")
	WebElement Delete_btn_FirstRow;
	
	@FindBy(xpath =  "//data-grid/div/div/div[1]/div[1]/data-grid-row/div/div[4]/div[1]/button")
	WebElement Edit_btn_FirstRow;
	
	@FindBy(xpath =  "//span[contains(.,'Close')]/../../button")
	WebElement Close_btn;
	
	@FindBy(xpath =  "//span[contains(.,'Cancel')]/../../button[@type]")
	WebElement Cancel_btn;
	
	@FindBy(xpath =  "//span[contains(.,'Delete')]/../../button")
	WebElement Delete_btn;
		
	@FindBy(xpath =  "//div/span[.='Printer Rerouting']")
	WebElement PrinterRerouting;
	
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
	
	@FindBy(xpath =  "//data-grid/div/div/div[1]/div[1]/data-grid-row/div/div[1]/span")
	WebElement FirstRow_Node_OR_Role;
	
	@FindBy(xpath =  "//data-grid/div/div/div[1]/div[1]/data-grid-row/div/div[2]/span")
	WebElement FirstRow_FromPrinter;
	
	@FindBy(xpath =  "//data-grid/div/div/div[1]/div[1]/data-grid-row/div/div[3]/span")
	WebElement FirstRow_ToPrinter;
	
	@FindBy(xpath =  "//h3[.=' Re-Route by Node ']")
	WebElement RerouteByNode_Heading;

	@FindBy(xpath =  "//h3[.=' Re-Route by Role ']")
	WebElement RerouteByRole_Heading;
	
	@FindBy(xpath =  "//span[contains(.,'Node')]/../input")
	WebElement NodeInput;
	
	@FindBy(xpath =  "//span[contains(.,'Role')]/../input")
	WebElement RoleInput;

	@FindBy(xpath =  "//span[contains(.,'From Printer')]/../input")
	WebElement FromPrinterInput;
	
	@FindBy(xpath =  "//span[contains(.,'To Printer')]/../input")
	WebElement ToPrinterInput;
	
	@FindBy(xpath =  "(//input[@placeholder='Search'])[2]")
	WebElement SearchForReroute;
	
	@FindBy(xpath =  "//app-radio-box-button/div/div/div")
	WebElement Availability_Date_Range;
		
	@FindBy(xpath =  "//span[.='Restriction Days']/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[1]")
	WebElement RestrictionDays_NoBtn;
	
	@FindBy(xpath =  "//span[.='Restriction Days']/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[2]")
	WebElement RestrictionDays_YesBtn;
	
	@FindBy(xpath =  "//span[.='Restriction Time']/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[1]")
	WebElement RestrictionTime_NoBtn;
	
	@FindBy(xpath =  "//span[.='Restriction Time']/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[2]")
	WebElement RestrictionTime_YesBtn;
		
	@FindBy(xpath =  "//span[.='Restriction Months']/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[1]")
	WebElement RestrictionMonths_NoBtn;
	
	@FindBy(xpath =  "//span[.='Restriction Months']/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle[2]")
	WebElement RestrictionMonths_YesBtn;
		
	@FindBy(xpath =  "//span[contains(.,'Start Time')]/../input")
	WebElement StartTime;
	
	@FindBy(xpath =  "//span[contains(.,'End Time')]/../input")
	WebElement EndTime;
	
	@FindBy(xpath =  "//span[@style='transform: rotateZ(-270deg);']")
	WebElement SelectFromTime;
		
	@FindBy(xpath = "//button[contains(.,'AM')]")
	WebElement AM_Btn;
	
	@FindBy(xpath = "//button[contains(.,'PM')]")
	WebElement PM_Btn;
		
	@FindBy(xpath = "//button[contains(@class,'time-picker-button') and .='OK ']")
	WebElement OK_TimePickerBtn;
	
	@FindBy(xpath = "//button[contains(@class,'time-picker-button') and .='CANCEL ']")
	WebElement Cancel_TimePickerBtn;
	
	@FindBy(xpath = "//button[.='Save']")
	WebElement SaveBtn;
	
	@FindBy(xpath = "//button[.='Cancel']")
	WebElement CancelBtn;
	
	@FindBy(xpath = "//span[.='Close ']")
	WebElement CloseBtn;
	
	@FindBy(xpath =  "//app-radio-box-button/div/div/div[.='All Days']")
	WebElement AllDays;
	
	@FindBy(xpath =  "//app-radio-box-button/div/div/div[.='Days Of Week']")
	WebElement DaysOfWeek;
	
	@FindBy(xpath =  "//app-radio-box-button/div/div/div[.='Days Of Month']")
	WebElement DaysOfMonth;
	
	@FindBy(xpath =  "//app-radio-box-button/div/div/div[.='Date Range']")
	WebElement DateRange;
	
	@FindBy(xpath =  "//app-radio-box-button/div/div/div[.='Specific Date']")
	WebElement SpecificDate;
	
	@FindBy(xpath =  "//app-radio-box-button/div/div/div[.='Date Range with Time']")
	WebElement DateRangeWithTime;
	
	@FindBy(xpath =  "//div/mat-chip")
	WebElement ForAllDays;

	@FindBy(xpath =  "//div/mat-chip")
	WebElement ForDate;
			
	@FindBy(xpath =  "//label[contains(.,'Start Date')]/../../../div[4]/mat-datepicker-toggle/button")
	WebElement StartDate;
	
	@FindBy(xpath =  "//label[contains(.,'End Date')]/../../../div[4]/mat-datepicker-toggle/button")
	WebElement EndDate;
	
	@FindBy(xpath =  "//button/div[contains(@class,'mat-calendar-body-today')]")
	WebElement CurrentDate;
	
	@FindBy(xpath =  "//label[.='1']/..")
	WebElement SelectDate;
	
		
	@FindBy(xpath =  "//span[contains(.,'Date')]/../..//button")
	WebElement Date;
	
	@FindBy(xpath =  "//div[contains(@class,'options')]/cdk-virtual-scroll-viewport/div/div[1]")
	WebElement FirstOption;
	
	@FindBy(xpath =  "//div[contains(@class,'options')]/cdk-virtual-scroll-viewport/div/div[2]")
	WebElement SecondOption;
	
	@FindBy(xpath =  "//button[@disabled='true' and contains(.,'Save')]")
	WebElement SaveBtnDisabled;
	
	
	
	public void AddRerouteByNode_AllDays_NoRestrictionTime() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd1();
		String s1 = FirstRow_Node_OR_Role.getText();
		
		String s2 = FirstRow_FromPrinter.getText();
		
		String s3 = FirstRow_ToPrinter.getText();
		
		Thread.sleep(1000);
		
		delete();
		
		Thread.sleep(1000);
		
		//Click the Add Reroute By Node button
		AddRerouteBtn.click();
		
		Thread.sleep(2000);
		
		//Click the Cancel button
		CancelBtn.click();
		
		Thread.sleep(2000);
		//Click the Add Reroute By Node button
		AddRerouteBtn.click();
		
		Thread.sleep(2000);
		
		//Click the Close button
		CloseBtn.click();
		Thread.sleep(2000);
		
		//Click the Add Reroute By Node button
		AddRerouteBtn.click();
		
		Thread.sleep(2000);
		
		if(RerouteByNode_Heading.isDisplayed()) {
			test.log(LogStatus.PASS, "Reroute By Node heading is displayed when user click the Add Reroute By node button");
		}
		else {
			test.log(LogStatus.FAIL, "Reroute By Node heading is not displayed when user click the Add Reroute By node button");
		}
		
		NodeInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s1);
		
		Thread.sleep(500);
		
		FirstOption.click();
		Thread.sleep(500);
		
		FromPrinterInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s2);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		ToPrinterInput.click();
		Thread.sleep(500);
		
		//click the input node
		SearchForReroute.sendKeys(s2);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		if(driver.findElement(By.xpath("//div[.='From and To printers should not be same']")).isDisplayed()) {
			test.log(LogStatus.PASS, "From and To printers should not be same field validations is displayed when user choose the Same Printers");
		}
		else {
			test.log(LogStatus.FAIL, "From and To printers should not be same field validations is not displayed when user choose the Same Printers");
		}
		
		ToPrinterInput.click();
		Thread.sleep(500);
		
		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		try {
			if(driver.findElement(By.xpath("//div[.='From and To printers should not be same']")).isDisplayed()) {
				test.log(LogStatus.FAIL, "From and To printers should not be same field validations is displayed when user choose the different Printers");
			}
			else {
				test.log(LogStatus.PASS, "From and To printers should not be same field validations is not displayed when user choose the different Printers");
			}
		}catch(Exception d) {
			test.log(LogStatus.PASS, "From and To printers should not be same field validations is not displayed when user choose the different Printers");
		}
		
		//Click the Availability
		AllDays.click();
		
		//Select No Restriction Time
		RestrictionTime_NoBtn.click();
		
		//Click Save button
		SaveBtn.click();
		
		Thread.sleep(1000);
		
		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s.equals("Printer Reroute Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
	}
	
	public void AddRerouteByNode_AllDays_RestrictionTime() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd1();
		String s1 = FirstRow_Node_OR_Role.getText();
		
		String s2 = FirstRow_FromPrinter.getText();
		
		String s3 = FirstRow_ToPrinter.getText();
		
		Thread.sleep(1000);
		
		delete();
		
		Thread.sleep(1000);
		
		//Click the Add Reroute By Node button
		AddRerouteBtn.click();
		
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		
		NodeInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s1);
		
		Thread.sleep(500);
		
		FirstOption.click();
		Thread.sleep(500);
		
		FromPrinterInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s2);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		ToPrinterInput.click();
		Thread.sleep(500);
		
		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);
		
		Thread.sleep(500);
		
		FirstOption.click();

		
		//Click the Availability
		AllDays.click();
		
		//Select No Restriction Time
		RestrictionTime_YesBtn.click();Thread.sleep(1000);
		
		Thread.sleep(500);
		//click the start time
		StartTime.click();
		
		Thread.sleep(500);SelectFromTime.click();
		
		AM_Btn.click();
		
		OK_TimePickerBtn.click();
		
		Thread.sleep(500);
		//click the End time
		EndTime.click();
		
		Thread.sleep(500);SelectFromTime.click();
		
		PM_Btn.click();
		
		OK_TimePickerBtn.click();
		
		//Click Save button
		SaveBtn.click();
		
		Thread.sleep(1000);
		
		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s.equals("Printer Reroute Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
	}

	public void AddRerouteByNode_DaysOfWeek_NoRestrictionTime() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd1();
		String s1 = FirstRow_Node_OR_Role.getText();
		
		String s2 = FirstRow_FromPrinter.getText();
		
		String s3 = FirstRow_ToPrinter.getText();
		
		Thread.sleep(1000);
		
		delete();
		
		Thread.sleep(1000);
		
		//Click the Add Reroute By Node button
		AddRerouteBtn.click();
		
		Thread.sleep(4000);
		
		NodeInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s1);
		
		Thread.sleep(500);
		
		FirstOption.click();
		Thread.sleep(500);
		
		FromPrinterInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s2);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		
		ToPrinterInput.click();
		Thread.sleep(500);
		
		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		//Click the Availability
		DaysOfWeek.click();
		
		//Select No Restriction Time
		RestrictionTime_NoBtn.click();
		
		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}
		
		Thread.sleep(1000);
		
		List<WebElement> menuList=driver.findElements(By.xpath("//div/mat-chip"));
		
		int menuSize=menuList.size();
		
		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
		
		WebElement element = driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();
		
		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
	}

	public void AddRerouteByNode_DaysOfWeek_RestrictionTime() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd1();
		String s1 = FirstRow_Node_OR_Role.getText();
		
		String s2 = FirstRow_FromPrinter.getText();
		
		String s3 = FirstRow_ToPrinter.getText();
		
		Thread.sleep(1000);
		
		delete();
		
		Thread.sleep(1000);
		
		//Click the Add Reroute By Node button
		AddRerouteBtn.click();
		
		Thread.sleep(2000);
		
		NodeInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s1);
		
		Thread.sleep(500);
		
		FirstOption.click();
		Thread.sleep(500);
		
		FromPrinterInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s2);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		ToPrinterInput.click();
		Thread.sleep(500);
				
		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		//Click the Availability
		DaysOfWeek.click();

		
		Thread.sleep(1000);
		
		List<WebElement> menuList=driver.findElements(By.xpath("//div/mat-chip"));
		
		int menuSize=menuList.size();
		
		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
		
		WebElement element = driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();
		//driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]")).click();
		
		
		//Select No Restriction Time
		RestrictionTime_YesBtn.click();Thread.sleep(1000);

		Thread.sleep(1500);
		//click the start time
		StartTime.click();
		
		Thread.sleep(500);SelectFromTime.click();
		
		AM_Btn.click();
		
		OK_TimePickerBtn.click();
		
		Thread.sleep(500);
		//click the End time
		EndTime.click();
		
		Thread.sleep(500);SelectFromTime.click();
		
		PM_Btn.click();
		
		OK_TimePickerBtn.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
	}

	public void AddRerouteByNode_DaysOfMonth_NoRestrictionTime() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd1();
		String s1 = FirstRow_Node_OR_Role.getText();
		
		String s2 = FirstRow_FromPrinter.getText();
		
		String s3 = FirstRow_ToPrinter.getText();
		
		Thread.sleep(1000);
		
		delete();
		
		Thread.sleep(1000);
		
		//Click the Add Reroute By Node button
		AddRerouteBtn.click();
		
		Thread.sleep(4000);
		
		NodeInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s1);
		
		Thread.sleep(500);
		
		FirstOption.click();
		Thread.sleep(500);
		
		FromPrinterInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s2);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		ToPrinterInput.click();
		Thread.sleep(500);
				
		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		//Click the Availability
		DaysOfMonth.click();

//		//Click Save button
//		SaveBtn.click();
//		
//		Thread.sleep(1000);
//		
//		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
//		
//		//Verify the success message
//		if(s.equals("Enter days of month"))
//		{
//			test.log(LogStatus.PASS, "Enter days of month message is displayed when user click the save button with out select days of month");
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Enter days of month message is not displayed when user click the save button with out select days of month");
//		}
//		
//		//Click the close button of success message
//		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
//		Thread.sleep(3000);
		
		//Click the current date
		SelectDate.click();
		
		//Click the Yes button of Restriction months
		RestrictionMonths_YesBtn.click();
				
		Thread.sleep(1000);
		
		List<WebElement> menuList=driver.findElements(By.xpath("//div/mat-chip"));
		
		int menuSize=menuList.size();
		
		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
		
		WebElement element = driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();
		//driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]")).click();a
		
		//Select No Restriction Time
		RestrictionTime_NoBtn.click();
		
		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
		
	}

	public void AddRerouteByNode_DaysOfMonth_RestrictionTime() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd1();
		String s1 = FirstRow_Node_OR_Role.getText();
		
		String s2 = FirstRow_FromPrinter.getText();
		
		String s3 = FirstRow_ToPrinter.getText();
		
		Thread.sleep(1000);
		
		delete();
		
		Thread.sleep(1000);
		
		//Click the Add Reroute By Node button
		AddRerouteBtn.click();
		
		Thread.sleep(4000);
				
		NodeInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s1);
		
		Thread.sleep(500);
		
		FirstOption.click();
		Thread.sleep(500);
		
		FromPrinterInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s2);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		ToPrinterInput.click();
		Thread.sleep(500);
				
		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		//Click the Availability
		DaysOfMonth.click();

		Thread.sleep(3000);
		
		//Click the current date
		SelectDate.click();
		
		//Click the Yes button of Restriction months
		RestrictionMonths_YesBtn.click();
				
		Thread.sleep(1000);
		
		List<WebElement> menuList=driver.findElements(By.xpath("//div/mat-chip"));
		
		int menuSize=menuList.size();
		
		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
		
		WebElement element = driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();
		//driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]")).click();
		
		//Select No Restriction Time
		RestrictionTime_YesBtn.click();Thread.sleep(1000);

		Thread.sleep(1500);
		//click the start time
		StartTime.click();
		
		Thread.sleep(500);SelectFromTime.click();
		
		AM_Btn.click();
		
		OK_TimePickerBtn.click();
		
		Thread.sleep(500);
		//click the End time
		EndTime.click();
		
		Thread.sleep(500);SelectFromTime.click();
		
		PM_Btn.click();
		
		OK_TimePickerBtn.click();

		
		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
		
	}

	public void AddRerouteByNode_DateRange_NoRestrictionTime() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd1();
		String s1 = FirstRow_Node_OR_Role.getText();
		
		String s2 = FirstRow_FromPrinter.getText();
		
		String s3 = FirstRow_ToPrinter.getText();
		
		Thread.sleep(1000);
		
		delete();
		
		Thread.sleep(1000);
		
		//Click the Add Reroute By Node button
		AddRerouteBtn.click();
		
		Thread.sleep(4000);
		
		NodeInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s1);
		
		Thread.sleep(500);
		
		FirstOption.click();
		Thread.sleep(500);
		
		FromPrinterInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s2);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		ToPrinterInput.click();
		Thread.sleep(500);
		
		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		//Click the Availability
		DateRange.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}
		
		Thread.sleep(1000);
		JavascriptExecutor js3=(JavascriptExecutor)driver;
		WebElement menuEle3=driver.findElement(By.xpath("//span[contains(.,'Start Date')]/../input"));
		js3.executeScript("arguments[0].scrollIntoView(true);", menuEle3);
		//click the the start date
		StartDate.click();
		
		Thread.sleep(1000);
				
		//Click the current date
		CurrentDate.click();

		Thread.sleep(1000);
		
		try {
			//Verify the success message
			if(driver.findElement(By.xpath("//span[contains(.,'Please Select End Date')]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Enter end date message is displayed when user click the save button with out select End Date");
			}
		}
		catch(Exception sed)
		{
			test.log(LogStatus.FAIL, "Enter end date message is not displayed when user click the save button with out select End Date");
		}
		
		//click the the End date
		EndDate.click();
				
		//Click the current date
		CurrentDate.click();
		
		//Click the restriction days
		RestrictionDays_YesBtn.click();
		
		Thread.sleep(1000);
		
		List<WebElement> menuList=driver.findElements(By.xpath("//div/mat-chip"));
		
		int menuSize=menuList.size();
		
		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
		
		WebElement element = driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();
		//driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]")).click();
		
		//Select No Restriction Time
		RestrictionTime_NoBtn.click();
		
		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
		
	}

	public void AddRerouteByNode_DateRange_RestrictionTime() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd1();
		String s1 = FirstRow_Node_OR_Role.getText();
		
		String s2 = FirstRow_FromPrinter.getText();
		
		String s3 = FirstRow_ToPrinter.getText();
		
		Thread.sleep(1000);
		
		delete();
		
		Thread.sleep(1000);
		
		//Click the Add Reroute By Node button
		AddRerouteBtn.click();
		
		Thread.sleep(4000);
				
		NodeInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s1);
		
		Thread.sleep(500);
		
		FirstOption.click();
		Thread.sleep(500);
		
		FromPrinterInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s2);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		ToPrinterInput.click();
		Thread.sleep(500);
		
		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		try {
			if(driver.findElement(By.xpath("//div[.='From and To printers should not be same']")).isDisplayed()) {
				test.log(LogStatus.FAIL, "From and To printers should not be same field validations is displayed when user choose the different Printers");
			}
			else {
				test.log(LogStatus.PASS, "From and To printers should not be same field validations is not displayed when user choose the different Printers");
			}
		}catch(Exception d) {
			test.log(LogStatus.PASS, "From and To printers should not be same field validations is not displayed when user choose the different Printers");
		}
		
		//Click the Availability
		DateRange.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}
		
		//click the the start date
		StartDate.click();
				
		//Click the current date
		CurrentDate.click();
		

		Thread.sleep(1000);
		
		try {
			//Verify the success message
			if(driver.findElement(By.xpath("//span[contains(.,'Please Select End Date')]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Enter end date message is displayed when user click the save button with out select End Date");
			}		//Click the close button of success message
		}
		catch(Exception sed)
		{
			test.log(LogStatus.FAIL, "Enter end date message is not displayed when user click the save button with out select End Date");
		}
		
		Thread.sleep(5000);
		
		//click the the End date
		EndDate.click();
				
		//Click the current date
		CurrentDate.click();
		
		//Click the restriction days
		RestrictionDays_YesBtn.click();
		
		Thread.sleep(1000);
		
		List<WebElement> menuList=driver.findElements(By.xpath("//div/mat-chip"));
		
		int menuSize=menuList.size();
		
		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
		
		WebElement element = driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();
		//driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]")).click();
		
		//Select No Restriction Time
		RestrictionTime_YesBtn.click();Thread.sleep(1000);
		
		Thread.sleep(500);
		//click the start time
		StartTime.click();
		
		Thread.sleep(500);SelectFromTime.click();
		
		AM_Btn.click();
		
		OK_TimePickerBtn.click();
		
		Thread.sleep(500);
		//click the End time
		EndTime.click();
		
		Thread.sleep(500);SelectFromTime.click();
		
		PM_Btn.click();
		
		OK_TimePickerBtn.click();
		
		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
		
	}

	public void AddRerouteByNode_SpecificDate_NoRestrictionTime() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd1();
		String s1 = FirstRow_Node_OR_Role.getText();
		
		String s2 = FirstRow_FromPrinter.getText();
		
		String s3 = FirstRow_ToPrinter.getText();
		
		Thread.sleep(1000);
		
		delete();
		
		Thread.sleep(1000);
		
		//Click the Add Reroute By Node button
		AddRerouteBtn.click();
		
		Thread.sleep(4000);
		
		NodeInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s1);
		
		Thread.sleep(500);
		
		FirstOption.click();
		Thread.sleep(500);
		
		FromPrinterInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s2);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		ToPrinterInput.click();
		Thread.sleep(500);
		
		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		//Click the Availability
		SpecificDate.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}
		
		//click the the start date
		Date.click();
				
		//Click the current date
		CurrentDate.click();
		
		//Select No Restriction Time
		RestrictionTime_NoBtn.click();
		
		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
	}

	public void AddRerouteByNode_SpecificDate_RestrictionTime() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd1();
		String s1 = FirstRow_Node_OR_Role.getText();
		
		String s2 = FirstRow_FromPrinter.getText();
		
		String s3 = FirstRow_ToPrinter.getText();
		
		Thread.sleep(1000);
		
		delete();
		
		Thread.sleep(1000);
		
		//Click the Add Reroute By Node button
		AddRerouteBtn.click();
		
		Thread.sleep(4000);
				
		NodeInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s1);
		
		Thread.sleep(500);
		
		FirstOption.click();
		Thread.sleep(500);
		
		FromPrinterInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s2);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		ToPrinterInput.click();
		Thread.sleep(500);
				
		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		//Click the Availability
		SpecificDate.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}
		
		//click the the start date
		Date.click();
				
		//Click the current date
		CurrentDate.click();
		
		//Select No Restriction Time
		RestrictionTime_NoBtn.click();
		
		
		//Select No Restriction Time
		RestrictionTime_YesBtn.click();Thread.sleep(1000);
		
		Thread.sleep(500);
		//click the start time
		StartTime.click();
		
		Thread.sleep(500);SelectFromTime.click();
		
		AM_Btn.click();
		
		OK_TimePickerBtn.click();
		
		Thread.sleep(500);
		//click the End time
		EndTime.click();
		
		Thread.sleep(500);SelectFromTime.click();
		
		PM_Btn.click();
		
		OK_TimePickerBtn.click();
		
		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
		
	}

	public void AddRerouteByNode_DateRangeWithTime_NoRestrictionDays() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd1();
		String s1 = FirstRow_Node_OR_Role.getText();
		
		String s2 = FirstRow_FromPrinter.getText();
		
		String s3 = FirstRow_ToPrinter.getText();
		
		Thread.sleep(1000);
		
		delete();
		
		Thread.sleep(1000);
		
		//Click the Add Reroute By Node button
		AddRerouteBtn.click();
		
		Thread.sleep(4000);
				
		NodeInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s1);
		
		Thread.sleep(500);
		
		FirstOption.click();
		Thread.sleep(500);
		
		FromPrinterInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s2);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		ToPrinterInput.click();
		Thread.sleep(500);
				
		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		//Click the Availability
		DateRangeWithTime.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}
		
		//click the the start date
		StartDate.click();
				
		//Click the current date
		CurrentDate.click();
	
		Thread.sleep(6000);

		try {
			//Verify the success message
			if(driver.findElement(By.xpath("//span[contains(.,'Please Select End Date')]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Enter end date message is displayed when user click the save button with out select End Date");
			}
		}
		catch(Exception sed)
		{
			test.log(LogStatus.FAIL, "Enter end date message is not displayed when user click the save button with out select End Date");
		}
		
		Thread.sleep(6000);
		//click the the End date
		EndDate.click();
		Thread.sleep(2000);
		//Click the current date
		CurrentDate.click();
		
		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}
		
		Thread.sleep(500);
		//click the start time
		StartTime.click();
		
		Thread.sleep(500);SelectFromTime.click();
		
		AM_Btn.click();
		
		OK_TimePickerBtn.click();
	
		Thread.sleep(1000);
		
		try {
			//Verify the success message
			if(driver.findElement(By.xpath("//span[contains(.,'Start Time Should Be Less Than End Time')]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Select end time message is displayed when user click the save button with out select End Time");
			}
		}
		catch(Exception sed)
		{
			test.log(LogStatus.FAIL, "Select end time message is not displayed when user click the save button with out select End Time");
		}
		
		Thread.sleep(500);
		//click the End time
		EndTime.click();
		
		Thread.sleep(500);SelectFromTime.click();
		
		PM_Btn.click();
		
		OK_TimePickerBtn.click();	
		
		//Click the restriction days
	//	RestrictionDays_NoBtn.click();
		
		Thread.sleep(1000);
		
		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
		
	}

	public void AddRerouteByNode_DateRangeWithTime_RestrictionDays() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd1();
		String s1 = FirstRow_Node_OR_Role.getText();
		
		String s2 = FirstRow_FromPrinter.getText();
		
		String s3 = FirstRow_ToPrinter.getText();
		
		Thread.sleep(1000);
		
		delete();
		
		Thread.sleep(1000);
		
		//Click the Add Reroute By Node button
		AddRerouteBtn.click();
		
		Thread.sleep(4000);
				
		NodeInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s1);
		
		Thread.sleep(500);
		
		FirstOption.click();
		Thread.sleep(500);
		
		FromPrinterInput.click();
		
		//click the input node
		SearchForReroute.sendKeys(s2);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		ToPrinterInput.click();
		Thread.sleep(500);
				
		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);
		
		Thread.sleep(500);
		
		FirstOption.click();
		
		//Click the Availability
		DateRangeWithTime.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}
		
		//click the the start date
		StartDate.click();
				
		//Click the current date
		CurrentDate.click();
	
		Thread.sleep(1000);
	
		try {
			//Verify the success message
			if(driver.findElement(By.xpath("//span[contains(.,'Please Select End Date')]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Enter end date message is displayed when user click the save button with out select End Date");
			}
		}
		catch(Exception sed)
		{
			test.log(LogStatus.FAIL, "Enter end date message is not displayed when user click the save button with out select End Date");
		}

		
		//click the the End date
		EndDate.click();
				
		//Click the current date
		CurrentDate.click();
		
		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}
		
		Thread.sleep(500);
		//click the start time
		StartTime.click();
		
		Thread.sleep(500);SelectFromTime.click();
		
		AM_Btn.click();
		
		OK_TimePickerBtn.click();
		
		Thread.sleep(1000);

		try {
			//Verify the success message
			if(driver.findElement(By.xpath("//span[contains(.,'Start Time Should Be Less Than End Time')]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Select end time message is displayed when user click the save button with out select End Time");
			}
		}
		catch(Exception sed)
		{
			test.log(LogStatus.FAIL, "Select end time message is not displayed when user click the save button with out select End Time");
		}
		
		Thread.sleep(500);
		//click the End time
		EndTime.click();
		
		Thread.sleep(500);SelectFromTime.click();
		
		PM_Btn.click();
		
		OK_TimePickerBtn.click();	
	try {	
		//Click the restriction days
		RestrictionDays_YesBtn.click();
		
		
		Thread.sleep(1000);
		
		List<WebElement> menuList=driver.findElements(By.xpath("//div/mat-chip"));
		
		int menuSize=menuList.size();
		
		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);
		
		WebElement element = driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();
		//driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]")).click();a
	}
	catch (Exception e) {
		// TODO: handle exception
	}
		
		Thread.sleep(1000);
		
		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
		
	}
	

	public void AddRerouteByNode_AllDays_NoRestrictionTime_Role() throws Exception {
		Thread.sleep(2000);
		//Click the Reroute by role tab
		RerouteByRoleTab.click();
				Thread.sleep(5000);
				deleteAndAdd();
		String s1 = FirstRow_Node_OR_Role.getText();

		String s2 = FirstRow_FromPrinter.getText();

		String s3 = FirstRow_ToPrinter.getText();

		Thread.sleep(1000);

		delete();Thread.sleep(2000);RerouteByRoleTab.click();Thread.sleep(3000);

		Thread.sleep(1000);

		//Click the Add Reroute By Node button
		AddRerouteRoleBtn.click();

		Thread.sleep(2000);

		//Click the Cancel button
		CancelBtn.click();

		Thread.sleep(2000);
		//Click the Add Reroute By Node button
		AddRerouteRoleBtn.click();

		Thread.sleep(2000);

		//Click the Close button
		CloseBtn.click();
		Thread.sleep(2000);

		//Click the Add Reroute By Node button
		AddRerouteRoleBtn.click();

		Thread.sleep(2000);

		if(RerouteByRole_Heading.isDisplayed()) {
			test.log(LogStatus.PASS, "Reroute By Role heading is displayed when user click the Add Reroute By node button");
		}
		else {
			test.log(LogStatus.FAIL, "Reroute By Role heading is not displayed when user click the Add Reroute By node button");
		}

		RoleInput.click();

		//click the input node
		SearchForReroute.sendKeys(s1);

		Thread.sleep(500);

		FirstOption.click();
		Thread.sleep(500);

		FromPrinterInput.click();

		//click the input node
		SearchForReroute.sendKeys(s2);

		Thread.sleep(500);

		FirstOption.click();

		ToPrinterInput.click();
		Thread.sleep(500);

		//click the input node
		SearchForReroute.sendKeys(s2);

		Thread.sleep(500);

		FirstOption.click();

		if(driver.findElement(By.xpath("//div[.='From and To printers should not be same']")).isDisplayed()) {
			test.log(LogStatus.PASS, "From and To printers should not be same field validations is displayed when user choose the Same Printers");
		}
		else {
			test.log(LogStatus.FAIL, "From and To printers should not be same field validations is not displayed when user choose the Same Printers");
		}

		ToPrinterInput.click();
		Thread.sleep(500);

		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);

		Thread.sleep(500);

		FirstOption.click();

		try {
			if(driver.findElement(By.xpath("//div[.='From and To printers should not be same']")).isDisplayed()) {
				test.log(LogStatus.FAIL, "From and To printers should not be same field validations is displayed when user choose the different Printers");
			}
			else {
				test.log(LogStatus.PASS, "From and To printers should not be same field validations is not displayed when user choose the different Printers");
			}
		}catch(Exception d) {
			test.log(LogStatus.PASS, "From and To printers should not be same field validations is not displayed when user choose the different Printers");
		}

		//Click the Availability
		AllDays.click();

		//Select No Restriction Time
		RestrictionTime_NoBtn.click();

		//Click Save button
		SaveBtn.click();

		Thread.sleep(1000);

		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();

		//Verify the success message
		if(s.equals("Printer Reroute Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
		}

		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);

	}

	public void AddRerouteByNode_AllDays_RestrictionTime_Role() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd();
		String s1 = FirstRow_Node_OR_Role.getText();

		String s2 = FirstRow_FromPrinter.getText();

		String s3 = FirstRow_ToPrinter.getText();

		Thread.sleep(1000);

		delete();Thread.sleep(2000);RerouteByRoleTab.click();Thread.sleep(3000);

		Thread.sleep(1000);

		//Click the Add Reroute By Node button
		AddRerouteRoleBtn.click();

		Thread.sleep(2000);

		Thread.sleep(2000);

		RoleInput.click();

		//click the input node
		SearchForReroute.sendKeys(s1);

		Thread.sleep(500);

		FirstOption.click();
		Thread.sleep(500);

		FromPrinterInput.click();

		//click the input node
		SearchForReroute.sendKeys(s2);

		Thread.sleep(500);

		FirstOption.click();

		ToPrinterInput.click();
		Thread.sleep(500);

		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);

		Thread.sleep(500);

		FirstOption.click();


		//Click the Availability
		AllDays.click();

		//Select No Restriction Time
		RestrictionTime_YesBtn.click();Thread.sleep(1000);

		Thread.sleep(500);
		//click the start time
		StartTime.click();

		Thread.sleep(500);SelectFromTime.click();

		AM_Btn.click();

		OK_TimePickerBtn.click();

		Thread.sleep(500);
		//click the End time
		EndTime.click();

		Thread.sleep(500);SelectFromTime.click();

		PM_Btn.click();

		OK_TimePickerBtn.click();

		//Click Save button
		SaveBtn.click();

		Thread.sleep(1000);

		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();

		//Verify the success message
		if(s.equals("Printer Reroute Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
		}

		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);

	}

	public void AddRerouteByNode_DaysOfWeek_NoRestrictionTime_Role() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd();
		String s1 = FirstRow_Node_OR_Role.getText();

		String s2 = FirstRow_FromPrinter.getText();

		String s3 = FirstRow_ToPrinter.getText();

		Thread.sleep(1000);

		delete();Thread.sleep(2000);RerouteByRoleTab.click();Thread.sleep(3000);

		Thread.sleep(1000);

		//Click the Add Reroute By Node button
		AddRerouteRoleBtn.click();

		Thread.sleep(4000);

		RoleInput.click();

		//click the input node
		SearchForReroute.sendKeys(s1);

		Thread.sleep(500);

		FirstOption.click();
		Thread.sleep(500);

		FromPrinterInput.click();

		//click the input node
		SearchForReroute.sendKeys(s2);

		Thread.sleep(500);

		FirstOption.click();


		ToPrinterInput.click();
		Thread.sleep(500);

		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);

		Thread.sleep(500);

		FirstOption.click();

		//Click the Availability
		DaysOfWeek.click();

		//Select No Restriction Time
		RestrictionTime_NoBtn.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}

		Thread.sleep(1000);

		List<WebElement> menuList=driver.findElements(By.xpath("//div/mat-chip"));

		int menuSize=menuList.size();

		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);

		WebElement element = driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();
		//driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]")).click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}

	}

	public void AddRerouteByNode_DaysOfWeek_RestrictionTime_Role() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd();
		String s1 = FirstRow_Node_OR_Role.getText();

		String s2 = FirstRow_FromPrinter.getText();

		String s3 = FirstRow_ToPrinter.getText();

		Thread.sleep(1000);

		delete();Thread.sleep(2000);RerouteByRoleTab.click();Thread.sleep(3000);

		Thread.sleep(1000);

		//Click the Add Reroute By Node button
		AddRerouteRoleBtn.click();

		Thread.sleep(2000);

		RoleInput.click();

		//click the input node
		SearchForReroute.sendKeys(s1);

		Thread.sleep(500);

		FirstOption.click();
		Thread.sleep(500);

		FromPrinterInput.click();

		//click the input node
		SearchForReroute.sendKeys(s2);

		Thread.sleep(500);

		FirstOption.click();

		ToPrinterInput.click();
		Thread.sleep(500);

		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);

		Thread.sleep(500);

		FirstOption.click();

		//Click the Availability
		DaysOfWeek.click();


		Thread.sleep(1000);

		List<WebElement> menuList=driver.findElements(By.xpath("//div/mat-chip"));

		int menuSize=menuList.size();

		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);

		WebElement element = driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();
		//driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]")).click();


		//Select No Restriction Time
		RestrictionTime_YesBtn.click();Thread.sleep(1000);

		Thread.sleep(500);
		//click the start time
		StartTime.click();

		Thread.sleep(500);SelectFromTime.click();

		AM_Btn.click();

		OK_TimePickerBtn.click();

		Thread.sleep(500);
		//click the End time
		EndTime.click();

		Thread.sleep(500);SelectFromTime.click();

		PM_Btn.click();

		OK_TimePickerBtn.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}

	}

	public void AddRerouteByNode_DaysOfMonth_NoRestrictionTime_Role() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd();
		String s1 = FirstRow_Node_OR_Role.getText();

		String s2 = FirstRow_FromPrinter.getText();

		String s3 = FirstRow_ToPrinter.getText();

		Thread.sleep(1000);

		delete();Thread.sleep(2000);RerouteByRoleTab.click();Thread.sleep(3000);

		Thread.sleep(1000);

		//Click the Add Reroute By Node button
		AddRerouteRoleBtn.click();

		Thread.sleep(4000);

		RoleInput.click();

		//click the input node
		SearchForReroute.sendKeys(s1);

		Thread.sleep(500);

		FirstOption.click();
		Thread.sleep(500);

		FromPrinterInput.click();

		//click the input node
		SearchForReroute.sendKeys(s2);

		Thread.sleep(500);

		FirstOption.click();

		ToPrinterInput.click();
		Thread.sleep(500);

		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);

		Thread.sleep(500);

		FirstOption.click();

		//Click the Availability
		DaysOfMonth.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}

		//Click the current date
		SelectDate.click();

		//Click the Yes button of Restriction months
		RestrictionMonths_YesBtn.click();

		Thread.sleep(1000);

		List<WebElement> menuList=driver.findElements(By.xpath("//div/mat-chip"));

		int menuSize=menuList.size();

		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);

		WebElement element = driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();
		//driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]")).click();a

		//Select No Restriction Time
		RestrictionTime_NoBtn.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
	}

	public void AddRerouteByNode_DaysOfMonth_RestrictionTime_Role() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd();
		String s1 = FirstRow_Node_OR_Role.getText();

		String s2 = FirstRow_FromPrinter.getText();

		String s3 = FirstRow_ToPrinter.getText();

		Thread.sleep(1000);

		delete();Thread.sleep(2000);RerouteByRoleTab.click();Thread.sleep(3000);

		Thread.sleep(1000);

		//Click the Add Reroute By Node button
		AddRerouteRoleBtn.click();

		Thread.sleep(4000);

		RoleInput.click();

		//click the input node
		SearchForReroute.sendKeys(s1);

		Thread.sleep(500);

		FirstOption.click();
		Thread.sleep(500);

		FromPrinterInput.click();

		//click the input node
		SearchForReroute.sendKeys(s2);

		Thread.sleep(500);

		FirstOption.click();

		ToPrinterInput.click();
		Thread.sleep(500);

		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);

		Thread.sleep(500);

		FirstOption.click();

		//Click the Availability
		DaysOfMonth.click();

		Thread.sleep(3000);

		//Click the current date
		SelectDate.click();

		//Click the Yes button of Restriction months
		RestrictionMonths_YesBtn.click();

		Thread.sleep(1000);

		List<WebElement> menuList=driver.findElements(By.xpath("//div/mat-chip"));

		int menuSize=menuList.size();

		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);

		WebElement element = driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();
		//driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]")).click();

		//Select No Restriction Time
		RestrictionTime_YesBtn.click();Thread.sleep(1000);

		Thread.sleep(1500);
		//click the start time
		StartTime.click();

		Thread.sleep(500);SelectFromTime.click();

		AM_Btn.click();

		OK_TimePickerBtn.click();

		Thread.sleep(500);
		//click the End time
		EndTime.click();

		Thread.sleep(500);SelectFromTime.click();

		PM_Btn.click();

		OK_TimePickerBtn.click();


		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}

	}

	public void AddRerouteByNode_DateRange_NoRestrictionTime_Role() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd();
		String s1 = FirstRow_Node_OR_Role.getText();

		String s2 = FirstRow_FromPrinter.getText();

		String s3 = FirstRow_ToPrinter.getText();

		Thread.sleep(1000);

		delete();Thread.sleep(2000);RerouteByRoleTab.click();Thread.sleep(3000);

		Thread.sleep(1000);

		//Click the Add Reroute By Node button
		AddRerouteRoleBtn.click();

		Thread.sleep(4000);

		RoleInput.click();

		//click the input node
		SearchForReroute.sendKeys(s1);

		Thread.sleep(500);

		FirstOption.click();
		Thread.sleep(500);

		FromPrinterInput.click();

		//click the input node
		SearchForReroute.sendKeys(s2);

		Thread.sleep(500);

		FirstOption.click();

		ToPrinterInput.click();
		Thread.sleep(500);

		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);

		Thread.sleep(500);

		FirstOption.click();

		//Click the Availability
		DateRange.click();

		Thread.sleep(1000);

		//click the the start date
		StartDate.click();

		//Click the current date
		CurrentDate.click();

		Thread.sleep(1000);

		try {
			//Verify the success message
			if(driver.findElement(By.xpath("//span[contains(.,'Please Select End Date')]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Enter end date message is displayed when user click the save button with out select End Date");
			}
		}
		catch(Exception sed)
		{
			test.log(LogStatus.FAIL, "Enter end date message is not displayed when user click the save button with out select End Date");
		}

		//click the the End date
		EndDate.click();

		//Click the current date
		CurrentDate.click();

		//Click the restriction days
		RestrictionDays_YesBtn.click();

		Thread.sleep(1000);

		List<WebElement> menuList=driver.findElements(By.xpath("//div/mat-chip"));

		int menuSize=menuList.size();

		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);

		WebElement element = driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();
		//driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]")).click();

		//Select No Restriction Time
		RestrictionTime_NoBtn.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
	}

	public void AddRerouteByNode_DateRange_RestrictionTime_Role() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd();
		String s1 = FirstRow_Node_OR_Role.getText();

		String s2 = FirstRow_FromPrinter.getText();

		String s3 = FirstRow_ToPrinter.getText();

		Thread.sleep(1000);

		delete();Thread.sleep(2000);RerouteByRoleTab.click();Thread.sleep(3000);

		Thread.sleep(1000);

		//Click the Add Reroute By Node button
		AddRerouteRoleBtn.click();

		Thread.sleep(4000);

		RoleInput.click();

		//click the input node
		SearchForReroute.sendKeys(s1);

		Thread.sleep(500);

		FirstOption.click();
		Thread.sleep(500);

		FromPrinterInput.click();

		//click the input node
		SearchForReroute.sendKeys(s2);

		Thread.sleep(500);

		FirstOption.click();

		ToPrinterInput.click();
		Thread.sleep(500);

		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);

		Thread.sleep(500);

		FirstOption.click();

		try {
			if(driver.findElement(By.xpath("//div[.='From and To printers should not be same']")).isDisplayed()) {
				test.log(LogStatus.FAIL, "From and To printers should not be same field validations is displayed when user choose the different Printers");
			}
			else {
				test.log(LogStatus.PASS, "From and To printers should not be same field validations is not displayed when user choose the different Printers");
			}
		}catch(Exception d) {
			test.log(LogStatus.PASS, "From and To printers should not be same field validations is not displayed when user choose the different Printers");
		}

		//Click the Availability
		DateRange.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}

		//click the the start date
		StartDate.click();

		//Click the current date
		CurrentDate.click();

		Thread.sleep(1000);

		try {
			//Verify the success message
			if(driver.findElement(By.xpath("//span[contains(.,'Please Select End Date')]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Enter end date message is displayed when user click the save button with out select End Date");
			}		//Click the close button of success message
		}
		catch(Exception sed)
		{
			test.log(LogStatus.FAIL, "Enter end date message is not displayed when user click the save button with out select End Date");
		}

		Thread.sleep(5000);

		//click the the End date
		EndDate.click();

		//Click the current date
		CurrentDate.click();

		//Click the restriction days
		RestrictionDays_YesBtn.click();

		Thread.sleep(1000);

		List<WebElement> menuList=driver.findElements(By.xpath("//div/mat-chip"));

		int menuSize=menuList.size();

		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);

		WebElement element = driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();
		//driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]")).click();

		//Select No Restriction Time
		RestrictionTime_YesBtn.click();Thread.sleep(1000);

		Thread.sleep(500);
		//click the start time
		StartTime.click();

		Thread.sleep(500);SelectFromTime.click();

		AM_Btn.click();

		OK_TimePickerBtn.click();

		Thread.sleep(500);
		//click the End time
		EndTime.click();

		Thread.sleep(500);SelectFromTime.click();

		PM_Btn.click();

		OK_TimePickerBtn.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
	}

	public void AddRerouteByNode_SpecificDate_NoRestrictionTime_Role() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd();
		String s1 = FirstRow_Node_OR_Role.getText();

		String s2 = FirstRow_FromPrinter.getText();

		String s3 = FirstRow_ToPrinter.getText();

		Thread.sleep(1000);

		delete();Thread.sleep(2000);RerouteByRoleTab.click();Thread.sleep(3000);

		Thread.sleep(1000);

		//Click the Add Reroute By Node button
		AddRerouteRoleBtn.click();

		Thread.sleep(4000);

		RoleInput.click();

		//click the input node
		SearchForReroute.sendKeys(s1);

		Thread.sleep(500);

		FirstOption.click();
		Thread.sleep(500);

		FromPrinterInput.click();

		//click the input node
		SearchForReroute.sendKeys(s2);

		Thread.sleep(500);

		FirstOption.click();

		ToPrinterInput.click();
		Thread.sleep(500);

		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);

		Thread.sleep(500);

		FirstOption.click();

		//Click the Availability
		SpecificDate.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}

		//click the the start date
		Date.click();

		//Click the current date
		CurrentDate.click();

		//Select No Restriction Time
		RestrictionTime_NoBtn.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}

	}

	public void AddRerouteByNode_SpecificDate_RestrictionTime_Role() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd();
		String s1 = FirstRow_Node_OR_Role.getText();

		String s2 = FirstRow_FromPrinter.getText();

		String s3 = FirstRow_ToPrinter.getText();

		Thread.sleep(1000);

		delete();Thread.sleep(2000);RerouteByRoleTab.click();Thread.sleep(3000);

		Thread.sleep(1000);

		//Click the Add Reroute By Node button
		AddRerouteRoleBtn.click();

		Thread.sleep(4000);

		RoleInput.click();

		//click the input node
		SearchForReroute.sendKeys(s1);

		Thread.sleep(500);

		FirstOption.click();
		Thread.sleep(500);

		FromPrinterInput.click();

		//click the input node
		SearchForReroute.sendKeys(s2);

		Thread.sleep(500);

		FirstOption.click();

		ToPrinterInput.click();
		Thread.sleep(500);

		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);

		Thread.sleep(500);

		FirstOption.click();

		//Click the Availability
		SpecificDate.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}

		//click the the start date
		Date.click();

		//Click the current date
		CurrentDate.click();

		//Select No Restriction Time
		RestrictionTime_NoBtn.click();


		//Select No Restriction Time
		RestrictionTime_YesBtn.click();Thread.sleep(1000);

		Thread.sleep(500);
		//click the start time
		StartTime.click();

		Thread.sleep(500);SelectFromTime.click();

		AM_Btn.click();

		OK_TimePickerBtn.click();

		Thread.sleep(500);
		//click the End time
		EndTime.click();

		Thread.sleep(500);SelectFromTime.click();

		PM_Btn.click();

		OK_TimePickerBtn.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
	}

	public void AddRerouteByNode_DateRangeWithTime_NoRestrictionDays_Role() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd();
		String s1 = FirstRow_Node_OR_Role.getText();

		String s2 = FirstRow_FromPrinter.getText();

		String s3 = FirstRow_ToPrinter.getText();

		Thread.sleep(1000);

		delete();Thread.sleep(2000);RerouteByRoleTab.click();Thread.sleep(3000);

		Thread.sleep(1000);

		//Click the Add Reroute By Node button
		AddRerouteRoleBtn.click();

		Thread.sleep(4000);

		RoleInput.click();

		//click the input node
		SearchForReroute.sendKeys(s1);

		Thread.sleep(500);

		FirstOption.click();
		Thread.sleep(500);

		FromPrinterInput.click();

		//click the input node
		SearchForReroute.sendKeys(s2);

		Thread.sleep(500);

		FirstOption.click();

		ToPrinterInput.click();
		Thread.sleep(500);

		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);

		Thread.sleep(500);

		FirstOption.click();

		//Click the Availability
		DateRangeWithTime.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}

		//click the the start date
		StartDate.click();

		//Click the current date
		CurrentDate.click();

		Thread.sleep(1000);

		try {
			//Verify the success message
			if(driver.findElement(By.xpath("//span[contains(.,'Please Select End Date')]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Enter end date message is displayed when user click the save button with out select End Date");
			}
		}
		catch(Exception sed)
		{
			test.log(LogStatus.FAIL, "Enter end date message is not displayed when user click the save button with out select End Date");
		}
		Thread.sleep(1000);

		//click the the End date
		EndDate.click();

		//Click the current date
		CurrentDate.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}

		Thread.sleep(500);
		//click the start time
		StartTime.click();

		Thread.sleep(500);SelectFromTime.click();

		AM_Btn.click();

		OK_TimePickerBtn.click();

		Thread.sleep(1000);

		try {
			//Verify the success message
			if(driver.findElement(By.xpath("//span[contains(.,'Start Time Should Be Less Than End Time')]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Select end time message is displayed when user click the save button with out select End Time");
			}
		}
		catch(Exception sed)
		{
			test.log(LogStatus.FAIL, "Select end time message is not displayed when user click the save button with out select End Time");
		}

		Thread.sleep(500);
		//click the End time
		EndTime.click();

		Thread.sleep(500);SelectFromTime.click();

		PM_Btn.click();

		OK_TimePickerBtn.click();

		//Click the restriction days
		//RestrictionDays_NoBtn.click();

		Thread.sleep(1000);

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
	}

	public void AddRerouteByNode_DateRangeWithTime_RestrictionDays_Role() throws Exception {
		Thread.sleep(2000);
		deleteAndAdd();
		String s1 = FirstRow_Node_OR_Role.getText();

		String s2 = FirstRow_FromPrinter.getText();

		String s3 = FirstRow_ToPrinter.getText();

		Thread.sleep(1000);


		
		delete();Thread.sleep(1000);RerouteByRoleTab.click();Thread.sleep(3000);

		Thread.sleep(1000);

		//Click the Add Reroute By Node button
		AddRerouteRoleBtn.click();

		Thread.sleep(4000);

		RoleInput.click();

		//click the input node
		SearchForReroute.sendKeys(s1);

		Thread.sleep(500);

		FirstOption.click();
		Thread.sleep(500);

		FromPrinterInput.click();

		//click the input node
		SearchForReroute.sendKeys(s2);

		Thread.sleep(500);

		FirstOption.click();

		ToPrinterInput.click();
		Thread.sleep(500);

		//click the input node
		SearchForReroute.clear();
		Thread.sleep(500);
		SearchForReroute.sendKeys(s3);

		Thread.sleep(500);

		FirstOption.click();

		//Click the Availability
		DateRangeWithTime.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}

		//click the the start date
		StartDate.click();

		//Click the current date
		CurrentDate.click();

		Thread.sleep(1000);

		try {
			//Verify the success message
			if(driver.findElement(By.xpath("//span[contains(.,'Please Select End Date')]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Enter end date message is displayed when user click the save button with out select End Date");
			}
		}
		catch(Exception sed)
		{
			test.log(LogStatus.FAIL, "Enter end date message is not displayed when user click the save button with out select End Date");
		}
	Thread.sleep(3000);

		//click the the End date
		EndDate.click();

		//Click the current date
		CurrentDate.click();

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when the mandatory fields are not filled/selected");
			}
		}catch(Exception f) {
			test.log(LogStatus.FAIL, "Save button is enabled when the mandatory fields are not filled/selected");
		}

		Thread.sleep(500);
		//click the start time
		StartTime.click();

		Thread.sleep(500);
		SelectFromTime.click();

		AM_Btn.click();

		OK_TimePickerBtn.click();

		Thread.sleep(1000);

		try {
			//Verify the success message
			if(driver.findElement(By.xpath("//span[contains(.,'Start Time Should Be Less Than End Time')]")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Select end time message is displayed when user click the save button with out select End Time");
			}
		}
		catch(Exception sed)
		{
			test.log(LogStatus.FAIL, "Select end time message is not displayed when user click the save button with out select End Time");
		}
		Thread.sleep(3000);

		Thread.sleep(500);
		//click the End time
		EndTime.click();

		Thread.sleep(500);SelectFromTime.click();

		PM_Btn.click();

		OK_TimePickerBtn.click();

		//Click the restriction days
		//RestrictionDays_YesBtn.click();


		Thread.sleep(1000);

		List<WebElement> menuList=driver.findElements(By.xpath("//div/mat-chip"));

		int menuSize=menuList.size();

		int randomMenu=ThreadLocalRandom.current().nextInt(1, menuSize);

		WebElement element = driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500);
		element.click();
		//driver.findElement(By.xpath("//div/mat-chip["+randomMenu+"]")).click();a


		Thread.sleep(1000);

		try {
			if(SaveBtnDisabled.isDisplayed()) {
				test.log(LogStatus.FAIL, "Save button is disabled when the mandatory fields are filled/selected");
			
				driver.findElement(By.xpath("//button[contains(.,'Cancel')]")).click();Thread.sleep(2000);
			}
		}catch(Exception f) {
			test.log(LogStatus.PASS, "Save button is enabled when the mandatory fields are filled/selected");
			
			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}

	}

	
	public void verifyThePageReroutingOption() throws Exception {
		Thread.sleep(2000);
		
		if(PrinterRerouting_Heading.isDisplayed()) {
			test.log(LogStatus.PASS, "Printing Rerouting heading is displayed in Printing Rerouting page");
		}
		else {
			test.log(LogStatus.FAIL, "Printing Rerouting heading is not displayed in Printing Rerouting page");
		}
		
		if(AddRerouteBtn.isDisplayed()) {
			test.log(LogStatus.PASS, "Add Reroute button is displayed in Printing Rerouting page");
		}
		else {
			test.log(LogStatus.FAIL, "Add Reroute button is not displayed in Printing Rerouting page");
		}
			
		if(RerouteByNodeTab.isDisplayed()) {
			test.log(LogStatus.PASS, "Reroute By Node Tab is displayed in Printing Rerouting page");
		}
		else {
			test.log(LogStatus.FAIL, "Reroute By Node Tab is not displayed in Printing Rerouting page");
		}
		
		if(RerouteByRoleTab.isDisplayed()) {
			test.log(LogStatus.PASS, "Reroute By Role Tab is displayed in Printing Rerouting page");
		}
		else {
			test.log(LogStatus.FAIL, "Reroute By Role Tab is not displayed in Printing Rerouting page");
		}
		
		if(Node_TableHeading.isDisplayed()) {
			test.log(LogStatus.PASS, "Node Table heading is displayed in Printing Rerouting page");
		}
		else {
			test.log(LogStatus.FAIL, "Node Table heading is not displayed in Printing Rerouting page");
		}
		
		if(FromPrinter_TableHeading.isDisplayed()) {
			test.log(LogStatus.PASS, "From Printer Table heading is displayed in Printing Rerouting page");
		}
		else {
			test.log(LogStatus.FAIL, "From Printer Table heading is not displayed in Printing Rerouting page");
		}
		
		if(ToPrinter_TableHeading.isDisplayed()) {
			test.log(LogStatus.PASS, "To Printer Table heading is displayed in Printing Rerouting page");
		}
		else {
			test.log(LogStatus.FAIL, "To Printer Table heading is not displayed in Printing Rerouting page");
		}
		
		if(Action_TableHeading.isDisplayed()) {
			test.log(LogStatus.PASS, "Action Table heading is displayed in Printing Rerouting page");
		}
		else {
			test.log(LogStatus.FAIL, "Action Table heading is not displayed in Printing Rerouting page");
		}
		
		if(Search_option.isDisplayed()) {
			test.log(LogStatus.PASS, "Search option is displayed in Printing Rerouting page");
		}
		else {
			test.log(LogStatus.FAIL, "Search option is not displayed in Printing Rerouting page");
		}
		
		if(Column_option.isDisplayed()) {
			test.log(LogStatus.PASS, "Column option is displayed in account license page");
		}
		else {
			test.log(LogStatus.FAIL, "Column option is not displayed in account license page");
		}
	}
		
	public void AddRerouteByRole() {
		
	}
	
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
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
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
		Thread.sleep(3000);driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);Thread.sleep(3000);
		Column_option.click();Thread.sleep(3000);
	}
		
	public void search() throws InterruptedException {
		
		Search_option.clear();
		Thread.sleep(15000);
		
		try {
			//Get the value from the table
			String sa = driver.findElement(By.xpath("//data-grid/div/div/div[1]/div[1]/data-grid-row/div/div[1]/span")).getText();
			
			List<WebElement> qw = driver.findElements(By.xpath("//data-grid/div/div/div[1]/div[1]/data-grid-row/div/div/span"));
																
			Search_option.sendKeys(sa);
			
			Thread.sleep(5000);
			
			List<WebElement> qw1 = driver.findElements(By.xpath("//data-grid/div/div/div[1]/div[1]/data-grid-row/div/div[1]/span"));
			
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
					
			PrinterRerouting.click();
			
			Thread.sleep(5000);
		}catch(Exception s) {
			test.log(LogStatus.INFO, "No Printer reroute is available in the page");
		}
	}
	
	public void deleteAndAdd() throws InterruptedException {
		try{
			if(Delete_btn_FirstRow.isDisplayed()) {}
			}catch(Exception s)
		{
			Thread.sleep(2000);RerouteByRoleTab.click();Thread.sleep(3000);

			Thread.sleep(1000);

			//Click the Add Reroute By Node button
			//AddRerouteRoleBtn.click();

			Thread.sleep(4000);

			RoleInput.click();
			

			//click the input node
			FirstOption.click();

			Thread.sleep(500);

			FromPrinterInput.click();

			Thread.sleep(500);

			FirstOption.click();

			ToPrinterInput.click();
			Thread.sleep(500);

			SecondOption.click();

			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
	}

	
	public void deleteAndAdd1() throws InterruptedException {
		try{
			if(Delete_btn_FirstRow.isDisplayed()) {}
		}catch(Exception s)
		{

			//Click the Add Reroute By Node button
			AddRerouteBtn.click();
			
			Thread.sleep(4000);
					
			NodeInput.click();
			
			//click the input node
			FirstOption.click();

			Thread.sleep(500);

			FromPrinterInput.click();

			Thread.sleep(500);

			FirstOption.click();

			ToPrinterInput.click();
			Thread.sleep(500);

			SecondOption.click();

			//Click Save button
			SaveBtn.click();
			
			Thread.sleep(1000);
			
			String s1a = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s1a.equals("Printer Reroute Saved Successfully"))
			{
				test.log(LogStatus.PASS, "Printer Reroute Saved Successfully message is displayed when user click the save button");
			}
			else
			{
				test.log(LogStatus.FAIL, "Printer Reroute Saved Successfully message not displayed when user click the save");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
			
		}
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
		Thread.sleep(2000);
		
		String s1 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		Thread.sleep(500);
		//Check whether the error message is displayed
		if(s1.equals("Printer Reroute Deleted Successfully"))
		{
			test.log(LogStatus.PASS, "Printer Reroute Deleted Successfully message is displayed when user delete the Printer Rerouting");
		}
		else
		{
			test.log(LogStatus.FAIL, "Printer Reroute Deleted Successfully message is not displayed when user delete the Printer Rerouting");
		}
		
		//Click the close button of warning message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		
		Thread.sleep(5000);

		Search_option.sendKeys(sa);
		
		Thread.sleep(5000);
		
		try {
			if(driver.findElement(By.xpath("//div/span[.='Printer Rerouting not found']")).isDisplayed())
			{
				test.log(LogStatus.PASS, "Printer Rerouting not found message is displayed, when user delete the particular Printer Rerouting");
			}
			else {
				test.log(LogStatus.FAIL, "Printer Rerouting is found, when user delete the particular Printer Rerouting");
			}
		}catch(Exception fd)
		{
			test.log(LogStatus.FAIL, "Printer Rerouting is found, when user delete the particular Printer Rerouting");
		}
		
		Search_option.clear();
		
		Back_btn.click();
		
		Thread.sleep(5000);
		
		PrinterRerouting.click();
		
		Thread.sleep(5000);
		
	}


}

	
