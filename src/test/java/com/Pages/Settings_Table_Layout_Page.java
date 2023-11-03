package com.Pages;

import java.util.List;
import java.util.Random;

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

public class Settings_Table_Layout_Page extends BasePage
{
//	SelfHealingDriver driver;
//	ExtentTest test;
	Common_XPaths cmp;
	Utility ut=new Utility();
	
	public Settings_Table_Layout_Page(SelfHealingDriver driver,ExtentTest test)
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
	
	@FindBy(xpath = "//h3[contains(.,'Table Layout')]")
	WebElement TableLayout_Heading;

	@FindBy(xpath = "//button[contains(.,'Add Floor')]")
	WebElement AddFloor_Btn;
	
	@FindBy(xpath = "//button[contains(.,'SAVE')]")
	WebElement Save_Btn;
	
	@FindBy(xpath = "//button[.='Save']")
	WebElement NewFloorSave_Btn;
	
	@FindBy(xpath = "//h6[contains(.,'Table Display Options')]")
	WebElement TableDisplayOptions;
	
	@FindBy(xpath = "//label[contains(.,'Table Name')]")
	WebElement TableName;
	
	@FindBy(xpath = "//img[@alt='Ellipse Table']")
	WebElement EclipseTable;
	
	@FindBy(xpath = "//img[@alt='Rectangle Table']")
	WebElement RectangleTable;
	
	@FindBy(xpath = "//span[.='Edit']")
	WebElement EditTble;
	
	@FindBy(xpath = "//span[.='Delete']/..")
	WebElement DeleteTble;
	
	@FindBy(xpath = "//span[.='Duplicate']")
	WebElement DuplicateTble;
	
	@FindBy(xpath = "//mat-label[contains(.,'Name')]/../../../input")
	WebElement Name;
	
	@FindBy(xpath = "//mat-label[contains(.,'Number of seats')]/../../../input")
	WebElement EnterNumberOfSeats;
	
	@FindBy(xpath = "//mat-label[contains(.,'Number of seats')]/../../../../../../../div/button[1]")
	WebElement EnterNumberOfSeats_Up;
	
	@FindBy(xpath = "//mat-label[contains(.,'Number of seats')]/../../../../../../../div/button[2]")
	WebElement EnterNumberOfSeats_Down;
	
	@FindBy(xpath = "//span[contains(.,'Rectangle')]")
	WebElement RectangleOpt;
	
	@FindBy(xpath = "//span[contains(.,'Ellipse')]")
	WebElement EclipseOpt;
	
	@FindBy(xpath = "//span[contains(.,'Update')]")
	WebElement Update;
	
	
	@FindBy(xpath = "//label[contains(.,'Guest Count')]")
	WebElement GuestCount;
	
	@FindBy(xpath = "//label[contains(.,'Customer')]")
	WebElement Customer;
	
	@FindBy(xpath = "//label[contains(.,'Wait Time')]")
	WebElement WaitTime;
	
	@FindBy(xpath = "//button[contains(.,'Print QR Code')]")
	WebElement PrintQRCode;
	
	@FindBy(xpath = "//button[contains(.,'Floor Settings')]")
	WebElement FloorSettings;
	
	@FindBy(xpath = "//button[contains(.,'Delete Floor')]")
	WebElement DeleteFloor;
	
	@FindBy(xpath = "//h3[contains(.,'Floor Settings')]")
	WebElement FloorSettings_Head;
	
	@FindBy(xpath = "//h3[contains(.,'New Floor')]")
	WebElement NewFloor;

	@FindBy(xpath = "//mat-label[contains(.,'Floor Name')]/../../../input")
	WebElement FloorName;
	
	@FindBy(xpath = "//mat-label[contains(.,'Order Sequence')]/../../../input")
	WebElement OrderSequence;
	
	@FindBy(xpath = "//mat-label[contains(.,'Order Sequence')]/../../../../../../../div/button[1]")
	WebElement OrderSequence_Up;
	
	@FindBy(xpath = "//mat-label[contains(.,'Order Sequence')]/../../../../../../../div/button[2]")
	WebElement OrderSequence_Down;
	
	@FindBy(xpath = "//mat-label[contains(.,'Width')]/../../../input")
	WebElement Width;
	
	@FindBy(xpath = "//mat-label[contains(.,'Width')]/../../../../../../../div/button[1]")
	WebElement Width_Up;
	
	@FindBy(xpath = "//mat-label[contains(.,'Width')]/../../../../../../../div/button[2]")
	WebElement Width_Down;
	
	@FindBy(xpath = "//mat-label[contains(.,'Height')]/../../../input")
	WebElement Hieght;
	
	@FindBy(xpath = "//mat-label[contains(.,'Height')]/../../../../../../../div/button[1]")
	WebElement Hieght_Up;
	
	@FindBy(xpath = "//mat-label[contains(.,'Height')]/../../../../../../../div/button[2]")
	WebElement Hieght_Down;
	
	@FindBy(xpath = "//div[@class='row no-gutters']/div[1]")
	WebElement StandardColor;
	
	@FindBy(xpath = "//div[@class='row no-gutters']/div[2]")
	WebElement Gallery;
	
	@FindBy(xpath = "//div[@class='row no-gutters']/div[3]")
	WebElement Img_Disk;
	
	@FindBy(xpath = "//button[.='Cancel']")
	WebElement CancelBtn;
	
	
	@FindBy(xpath = "//mat-icon[.='close']")
	WebElement CloseBtn;
	
	@FindBy(xpath = "//button[.=' Delete ']")
	WebElement DeleteBtn;
	
	@FindBy(xpath = "//h4[contains(.,'Delete Floor')]")
	WebElement DeleteFloorPopup;
	
	@FindBy(xpath = "//p[contains(.,'You are about to delete this floor. Are you sure?')]")
	WebElement DeleteFloorPopuptxt;
	
	@FindBy(xpath = "//button[.=' Cancel ']")
	WebElement DeleteCancel;
	
	@FindBy(xpath = "//mat-icon[.=' close ']")
	WebElement DeleteClose;
	
	@FindBy(xpath = "//button[contains(.,'Save') and @disabled='true']")
	WebElement DisabledSave;
	
	@FindBy(xpath = "//div[@class='message mx-2']/span")
	WebElement SuccessMessage;
	
	@FindBy(xpath = "//div[@class='message mx-2']/../mat-icon[.='close']")
	WebElement CloseBtnOfSuccessMessage;
	
	@FindBy(xpath = "//mat-hint[.='Floor name should not be more than 25 characters']")
	WebElement WarningMsg_FloorName;
	
	@FindBy(xpath = "//mat-hint[.='Table name should not be more than 10 characters']")
	WebElement WarningMsg_TableName;
	
	@FindBy(xpath = "//span[.='Black_BG']/../..")
	WebElement BlackBG;
	
	
	public void FloorSettings() throws Exception {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(.,'Temp Floor')]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		Thread.sleep(3000);
		
		FloorSettings.click();
		Thread.sleep(1000);
		
		if(FloorSettings_Head.isDisplayed()) {
			test.log(LogStatus.PASS, "Floor Settings heading displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Floor Settings heading is not displayed");
		}
		
		FloorName.clear();
		
		FloorName.sendKeys("Temp Floor1");
		
		Thread.sleep(500);
		
		Gallery.click();
		
		BlackBG.click();
		
		Thread.sleep(500);
		
		Update.click();
		
		Thread.sleep(2000);
		try {
			if(SuccessMessage.getText().equals("Store layout updated successfully")) {
				test.log(LogStatus.PASS, "Store layout updated successfully is displayed when user change the Floor Settings");
			}
			else {
				test.log(LogStatus.FAIL, "Store layout updated successfully is not displayed when user change the Floor Settings");
			}
			
			CloseBtnOfSuccessMessage.click();
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Store layout updated successfully is not displayed when user change the Floor Settings");
		}
		
		Thread.sleep(3000);
		
		FloorSettings.click();
		Thread.sleep(1000);
		
		if(FloorSettings_Head.isDisplayed()) {
			test.log(LogStatus.PASS, "Floor Settings heading displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Floor Settings heading is not displayed");
		}
		
		Thread.sleep(500);
		
		Gallery.click();
		
		BlackBG.click();
		
		Thread.sleep(500);
		
		Update.click();
		
		Thread.sleep(2000);
		try {
			if(SuccessMessage.getText().equals("Store layout updated successfully")) {
				test.log(LogStatus.PASS, "Store layout updated successfully is displayed when user change the Floor Settings");
			}
			else {
				test.log(LogStatus.FAIL, "Store layout updated successfully is not displayed when user change the Floor Settings");
			}
			
			CloseBtnOfSuccessMessage.click();
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Store layout updated successfully is not displayed when user change the Floor Settings");
		}
	}
	
	public void DeleteFloor() throws Exception {
		
		Thread.sleep(3000);
		
		DeleteFloor.click();
		
		Thread.sleep(1000);
		
		if(DeleteFloorPopup.getText().equals("Delete Floor") && DeleteFloorPopuptxt.getText().equals("You are about to delete this floor. Are you sure?"))
		{
			test.log(LogStatus.PASS, "Delete confirmation popup displayed successfully with the respect text");
		}
		else
		{
			test.log(LogStatus.FAIL, "Delete confirmation popup is not displayed successfully with the respect text");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//click the Close button
		DeleteClose.click();
		
		Thread.sleep(3000);
		
		DeleteFloor.click();
		
		Thread.sleep(1000);
		
		if(DeleteFloorPopup.getText().equals("Delete Floor") && DeleteFloorPopuptxt.getText().equals("You are about to delete this floor. Are you sure?"))
		{
			test.log(LogStatus.PASS, "Delete confirmation popup displayed successfully with the respect text");
		}
		else
		{
			test.log(LogStatus.FAIL, "Delete confirmation popup is not displayed successfully with the respect text");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//click the Cancel button
		DeleteCancel.click();
		
		Thread.sleep(3000);
		
		DeleteFloor.click();
		
		Thread.sleep(1000);
		
		if(DeleteFloorPopup.getText().equals("Delete Floor") && DeleteFloorPopuptxt.getText().equals("You are about to delete this floor. Are you sure?"))
		{
			test.log(LogStatus.PASS, "Delete confirmation popup displayed successfully with the respect text");
		}
		else
		{
			test.log(LogStatus.FAIL, "Delete confirmation popup is not displayed successfully with the respect text");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//click the Delete button
		DeleteBtn.click();
		
		Thread.sleep(2000);
		try {
			if(SuccessMessage.getText().equals("Store layout updated successfully")) {
				test.log(LogStatus.PASS, "Store layout updated successfully is displayed when user click the Delete button of Delete Floor popup");
			}
			else {
				test.log(LogStatus.FAIL, "Store layout updated successfully is not displayed when user click the Delete button of Delete Floor popup");
			}
			
			CloseBtnOfSuccessMessage.click();
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "Store layout updated successfully is not displayed when user click the Delete button of Delete Floor popup");
		}
		
		try {
			if(driver.findElement(By.xpath("//span[contains(.,'Temp Floor1')]")).isDisplayed()) {
				test.log(LogStatus.FAIL, "The deleted floor is displayed");
			}
		}catch(Exception s) {
			test.log(LogStatus.PASS, "The deleted floor is not displayed");
		}
	}
	
	public void AddFloor() throws Exception {
		Thread.sleep(2500);
		//Click the Add Floor button
		AddFloor_Btn.click();Thread.sleep(2500);
		
		if(NewFloor.isDisplayed()) {
			test.log(LogStatus.PASS, "New Floor heading displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "New Floor heading is not displayed");
		}
		
		if(DisabledSave.isDisplayed()) {
			test.log(LogStatus.PASS, "Save button is disabled when user not enter the mandatory field");
		}
		else {
			test.log(LogStatus.FAIL, "Save button is enabled when user not enter the mandatory field");
		}
		
		//Click the Order Sequence increase button
		OrderSequence_Up.click();
		
		try {
			if(DisabledSave.isDisplayed()) {
				test.log(LogStatus.PASS, "Save button is disabled when user not enter the mandatory field");
			}
		}catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Save button is enabled when user not enter the mandatory field");
			
			NewFloorSave_Btn.click();
			
			if(SuccessMessage.getText().equals("Please enter floor name")) {
				test.log(LogStatus.PASS, "Please enter floor name waring message is displayed while click the save button without Floor Name");
			}
			else {
				test.log(LogStatus.FAIL, "Please enter floor name waring message is not displayed while click the save button without Floor Name");
			}
			
			CloseBtnOfSuccessMessage.click();
		}
		
		String fln = RandomStringUtils.randomAlphabetic(26);
		
		String fln1 = fln.substring(0, 24);
		
		FloorName.sendKeys(fln);
		
		try {
			if(WarningMsg_FloorName.getText().equals("Floor name should not be more than 25 characters")) {
				test.log(LogStatus.PASS, "Warning Message is displayed for floor name when user enter more than 25 charactes");
			}
			FloorName.clear();
		}
		catch(Exception d)
		{
			if(FloorName.getAttribute("value").equals(fln1)) {
				test.log(LogStatus.INFO, "Entered Floor name is displayed in the Floor name input field");
			}
			FloorName.clear();
		}
		
		FloorName.sendKeys("Temp Floor");
		
		verifyTheOrderSequenceFunctionalities();
		
		verifyTheWidthFunctionalities();
		
		verifyTheHeightFunctionalities();
		
		StandardColor.click();
		
		List<WebElement> col =driver.findElements(By.xpath("//div[contains(@class,'preset-color ng-star-inserted')]"));
		
		Random r = new Random();
		
		int randomValue =  r.nextInt(col.size());
		
		col.get(randomValue).click();
		
		String col1 = col.get(randomValue).getAttribute("style");			
		Thread.sleep(2000);
		
		String col2 = driver.findElement(By.xpath("//div[contains(@class,'image-container ng-star-inserted')]")).getAttribute("style");
		
		if(col1.contains(col2))
		{
			test.log(LogStatus.PASS, "The Floor color changed successfully, while user change the color in style option");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Floor color not changing, while user change the color in style option");
		}
		
		//click the save btn
		NewFloorSave_Btn.click();
		
		Thread.sleep(10000);
		
		driver.findElement(By.xpath("//span[contains(.,'Temp Floor')]")).click();
		
		Thread.sleep(10000);
		
		EclipseTable.click();
		
		verifyEditTable();
		
		Thread.sleep(10000);
				
		//Click the Delete table
		DeleteTble.click();
		
		RectangleTable.click();
		
		Thread.sleep(5000);
		
		DuplicateTble.click();
		
		Thread.sleep(5000);
		
		//Click the save button
		Save_Btn.click();
		
		Thread.sleep(1500);
		
		if(SuccessMessage.getText().equals("Store layout updated successfully")) {
			test.log(LogStatus.PASS, "Store layout updated successfully message is displayed while click the save button");
		}
		else {
			test.log(LogStatus.FAIL, "Store layout updated successfully message is not displayed while click the save button");
		}
		
		CloseBtnOfSuccessMessage.click();
		
		Thread.sleep(8000);
		
	}
	
	public void verifyEditTable() throws InterruptedException
	{
	
		Thread.sleep(10000);
		//span[contains(.,'Happy Floor')]
		
		EditTble.click();
		
		Thread.sleep(5000);
		
		if(Name.isDisplayed()) {
			test.log(LogStatus.PASS, "Name field is displayed when user Click the edit button");
		}
		else {
			test.log(LogStatus.FAIL, "Name field is not displayed when user Click the edit button");
		}
		
		if(EnterNumberOfSeats.isDisplayed()) {
			test.log(LogStatus.PASS, "Enter the number of seats field is displayed when user Click the edit button");
		}
		else {
			test.log(LogStatus.FAIL, "Enter the number of seats field is not displayed when user Click the edit button");
		}
		
		if(RectangleOpt.isDisplayed()) {
			test.log(LogStatus.PASS, "Rectangle option field is displayed when user Click the edit button");
		}
		else {
			test.log(LogStatus.FAIL, "Rectangle option field is not displayed when user Click the edit button");
		}
		
		if(EclipseOpt.isDisplayed()) {
			test.log(LogStatus.PASS, "Ellipse option field is displayed when user Click the edit button");
		}
		else {
			test.log(LogStatus.FAIL, "Ellipse option field is not displayed when user Click the edit button");
		}
		
		Thread.sleep(1000);
		
		CancelBtn.click();
		
		Thread.sleep(1000);
		
		EditTble.click();
		
		Thread.sleep(1000);
		
		CloseBtn.click();
		
		Thread.sleep(1000);
		
		EditTble.click();
		
		Name.clear();
		
		String fln = RandomStringUtils.randomAlphabetic(26);
		
		String fln1 = fln.substring(0, 9);
		
		Name.sendKeys(fln);
		
		try {
			if(WarningMsg_TableName.getText().equals("Table name should not be more than 10 characters")) {
				test.log(LogStatus.PASS, "Warning Message is displayed for table name when user enter more than 10 charactes");
			}
			Name.clear();
			
		}
		catch(Exception d)
		{
			if(Name.getAttribute("value").equals(fln1)) {
				test.log(LogStatus.INFO, "Entered Table name is displayed in the name input field");
			}
			Name.clear();
		}
		
		Name.sendKeys("Tble1");	
		
		String u1 =  EnterNumberOfSeats.getAttribute("value");
		
		int i1 = Integer.parseInt(u1);
		
		i1 = i1 + 1;
		
		//Click the up arrow button
		EnterNumberOfSeats_Up.click();
		
		String u1a =  EnterNumberOfSeats.getAttribute("value");
		
		int i1a = Integer.parseInt(u1a);
				
		if(i1 == i1a)
		{
			test.log(LogStatus.PASS, "Increase the value of Enter number of seats is working fine when user click the increase button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of Enter number of seats is not working fine when user click the increase");
		}
		
		//click the down arrow button
		EnterNumberOfSeats_Down.click();
		
		String u2 =  EnterNumberOfSeats.getAttribute("value");
		
		int i2 = Integer.parseInt(u2);
		
		if(i2 == (i1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of Enter number of seats is working fine when user click it then it is decreased by 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of Enter number of seays is not working fine when user click it");
		}
		
		EnterNumberOfSeats.sendKeys("e");
		
		String u4 =  EnterNumberOfSeats.getAttribute("value");
		
		if(u4.contains("e"))
		{
			test.log(LogStatus.FAIL, "The field accept the Alphabets in Enter the number of seats");
		}
		else
		{
			test.log(LogStatus.PASS, "The field not accept the Alphabets in Enter the number of seats");
		}
		
		EnterNumberOfSeats.sendKeys(Keys.ARROW_DOWN);
		
		EnterNumberOfSeats.clear();
		
		EnterNumberOfSeats_Down.click();
		
		String u5 =  EnterNumberOfSeats.getAttribute("value");
		
		//int i5 = Integer.parseInt(u5);
		
		if(u5.contains("-"))
		{
			test.log(LogStatus.FAIL, "The Enter the number of seats field accept the negative values");
		}
		else
		{
			test.log(LogStatus.PASS, "The Enter the number of seats field is not accept the negative values");
		}
		
		EnterNumberOfSeats.clear();
		
		EnterNumberOfSeats.sendKeys("50");
		
		RectangleOpt.click();
		
		CancelBtn.click();
	}

	
	public void verifyTheOrderSequenceFunctionalities()
	{
		
		String u1 =  OrderSequence.getAttribute("value");
		
		int i1 = Integer.parseInt(u1);
		
		i1 = i1 + 1;
		
		//Click the up arrow button
		OrderSequence_Up.click();
		
		String u1a =  OrderSequence.getAttribute("value");
		
		int i1a = Integer.parseInt(u1a);
				
		if(i1 == i1a)
		{
			test.log(LogStatus.PASS, "Increase the value of Order Sequence is working fine when user click the increase button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of Order Sequence is not working fine when user click the increase");
		}
		
		//click the down arrow button
		OrderSequence_Down.click();
		
		String u2 =  OrderSequence.getAttribute("value");
		
		int i2 = Integer.parseInt(u2);
		
		if(i2 == (i1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of Order Sequence is working fine when user click it then it is decreased by 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of Order Sequence is not working fine when user click it");
		}
		
		OrderSequence.sendKeys("e");
		
		String u4 =  OrderSequence.getAttribute("value");
		
		if(u4.contains("e"))
		{
			test.log(LogStatus.FAIL, "The field accept the Alphabets in Order Sequence");
		}
		else
		{
			test.log(LogStatus.PASS, "The field not accept the Alphabets in Order Sequence");
		}
		
		OrderSequence.sendKeys(Keys.ARROW_DOWN);
		
		OrderSequence.clear();
		
		OrderSequence_Down.click();
		
		String u5 =  OrderSequence.getAttribute("value");
		
		//int i5 = Integer.parseInt(u5);
		
		if(u5.contains("-"))
		{
			test.log(LogStatus.FAIL, "The Order Sequence field accept the negative values");
		}
		else
		{
			test.log(LogStatus.PASS, "The Order Sequence field is not accept the negative values");
		}
		
		OrderSequence.clear();
		
		OrderSequence.sendKeys("50");
	}
	
	public void verifyTheWidthFunctionalities()
	{
		
		String u1 =  Width.getAttribute("value");
		
		int i1 = Integer.parseInt(u1);
		
		i1 = i1 + 1;
		
		//Click the up arrow button
		Width_Up.click();
		
		String u1a =  Width.getAttribute("value");
		
		int i1a = Integer.parseInt(u1a);
				
		if(i1 == i1a)
		{
			test.log(LogStatus.PASS, "Increase the value of Width is working fine when user click the increase button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of Width is not working fine when user click the increase");
		}
		
		//click the down arrow button
		Width_Down.click();
		
		String u2 =  Width.getAttribute("value");
		
		int i2 = Integer.parseInt(u2);
		
		if(i2 == (i1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of Width is working fine when user click it then it is decreased by 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of Width is not working fine when user click it");
		}
		
		Width.sendKeys("e");
		
		String u4 =  Width.getAttribute("value");
		
		if(u4.contains("e"))
		{
			test.log(LogStatus.FAIL, "The Width field accept the Alphabets in Order Sequence");
		}
		else
		{
			test.log(LogStatus.PASS, "The Width field not accept the Alphabets in Order Sequence");
		}
		
		Width.sendKeys(Keys.ARROW_DOWN);
		
		Width.clear();
		
		Width_Down.click();
		
		String u5 =  Width.getAttribute("value");
		
		//int i5 = Integer.parseInt(u5);
		
		if(u5.contains("-"))
		{
			test.log(LogStatus.FAIL, "The Width field accept the negative values");
		}
		else
		{
			test.log(LogStatus.PASS, "The Width field is not accept the negative values");
		}
		
		Width.clear();
		
		Width.sendKeys(u1);
	}

	public void verifyTheHeightFunctionalities()
	{
		
		String u1 =  Hieght.getAttribute("value");
		
		int i1 = Integer.parseInt(u1);
		
		i1 = i1 + 1;
		
		//Click the up arrow button
		Hieght_Up.click();
		
		String u1a =  Hieght.getAttribute("value");
		
		int i1a = Integer.parseInt(u1a);
				
		if(i1 == i1a)
		{
			test.log(LogStatus.PASS, "Increase the value of Hieght is working fine when user click the increase button");
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of Hieght is not working fine when user click the increase");
		}
		
		//click the down arrow button
		Hieght_Down.click();
		
		String u2 =  Hieght.getAttribute("value");
		
		int i2 = Integer.parseInt(u2);
		
		if(i2 == (i1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of Hieght is working fine when user click it then it is decreased by 1");
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of Hieght is not working fine when user click it");
		}
		
		Hieght.sendKeys("e");
		
		String u4 =  Hieght.getAttribute("value");
		
		if(u4.contains("e"))
		{
			test.log(LogStatus.FAIL, "The Hieght field accept the Alphabets in Order Sequence");
		}
		else
		{
			test.log(LogStatus.PASS, "The Hieght field not accept the Alphabets in Order Sequence");
		}
		
		Hieght.sendKeys(Keys.ARROW_DOWN);
		
		Hieght.clear();
		
		Hieght_Down.click();
		
		String u5 =  Hieght.getAttribute("value");
		
		//int i5 = Integer.parseInt(u5);
		
		if(u5.contains("-"))
		{
			test.log(LogStatus.FAIL, "The Hieght field accept the negative values");
		}
		else
		{
			test.log(LogStatus.PASS, "The Hieght field is not accept the negative values");
		}
		
		Hieght.clear();
		
		Hieght.sendKeys(u1);
	}

	
	public void tableLayout_Page() throws Exception {
		Thread.sleep(2500);
		
		if(TableLayout_Heading.isDisplayed()) {
			test.log(LogStatus.PASS, "Table Layout heading displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Table Layout heading is not displayed");
		}
		
		if(AddFloor_Btn.isDisplayed()) {
			test.log(LogStatus.PASS, "Add Floor button displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Add Floor button is not displayed");
		}
		
		if(Save_Btn.isDisplayed()) {
			test.log(LogStatus.PASS, "Save Button displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Save Button is not displayed");
		}
		
		if(TableDisplayOptions.isDisplayed()) {
			test.log(LogStatus.PASS, "Table Display option displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Table Display option is not displayed");
		}
		
		if(TableName.isDisplayed()) {
			test.log(LogStatus.PASS, "Table Name option displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Table Name option is not displayed");
		}
		
		if(GuestCount.isDisplayed()) {
			test.log(LogStatus.PASS, "Guest Count option displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Guest Count option is not displayed");
		}
		
		if(Customer.isDisplayed()) {
			test.log(LogStatus.PASS, "Customer option displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Customer option is not displayed");
		}
		
		if(WaitTime.isDisplayed()) {
			test.log(LogStatus.PASS, "Wait Time option displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Wait Time option is not displayed");
		}
		
		try {
			if(PrintQRCode.isDisplayed()) {
				test.log(LogStatus.INFO, "Print QR Code option displayed successfully");
			}
		}
		catch(Exception d) {
			test.log(LogStatus.INFO, "Print QR Code option is not displayed");
		}
		
		if(FloorSettings.isDisplayed()) {
			test.log(LogStatus.PASS, "Floor Settings option displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Floor Settings option is not displayed");
		}

		if(DeleteFloor.isDisplayed()) {
			test.log(LogStatus.PASS, "Delete Floor option displayed successfully");
		}
		else {
			test.log(LogStatus.FAIL, "Delete Floor option is not displayed");
		}
	}
}

	
