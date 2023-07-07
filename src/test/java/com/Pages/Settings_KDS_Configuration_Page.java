package com.Pages;

import java.util.List;
import java.util.Random;

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

public class Settings_KDS_Configuration_Page {
	WebDriver driver;
	ExtentTest test;
	Common_XPaths cmp;
	Utility ut=new Utility();
	
	public Settings_KDS_Configuration_Page(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='settings']/button")
	WebElement Settings;
	
	@FindBy(xpath = "//h3[contains(.,'Settings')]")
	WebElement Settings_Heading;
	
	@FindBy(xpath = "//h3[contains(.,'KDS Configuration')]")
	WebElement KDSConfiguration_Heading;
	
	@FindBy(xpath = "//mat-panel-title[contains(.,'Field Options')]")
	WebElement FieldOptions;
	
	@FindBy(xpath = "//mat-panel-title[contains(.,'Style Options')]")
	WebElement StyleOptions;
	
	@FindBy(xpath = "//mat-panel-title[contains(.,'SMS Order Notifications')]")
	WebElement SMS_Order_Notifications;
	
	@FindBy(xpath = "//h6[contains(.,'KDS Ticket Preview')]")
	WebElement KDS_Ticket_Preview;

	@FindBy(xpath = "//span[contains(.,'UPDATE')]")
	WebElement Update_Btn;
	
	@FindBy(xpath = "//div[@class='table table-border']")
	WebElement KDS_Table;
	
	@FindBy(xpath = "//label/span/span[.='Table Name']")
	WebElement Table_Name_option;
	
	@FindBy(xpath = "//label/span/span[.='Service Type']")
	WebElement Service_Type_Option;
	
	@FindBy(xpath = "//label/span/span[.='Check Number']")
	WebElement Check_Number_Option;
	
	@FindBy(xpath = "//label/span/span[.='Seat Number']")
	WebElement Seat_Number_Option;
	
	@FindBy(xpath = "//label/span/span[.='Time']")
	WebElement Time_Option;
	
	@FindBy(xpath = "//label/span/span[.='Notes']")
	WebElement Notes_Option;
	
	@FindBy(xpath = "//label/span/span[.='Server Name']")
	WebElement Server_Name_Option;
	
	@FindBy(xpath = "//label/span/span[.='KDS Done Button']")
	WebElement KDS_Done_Btn_Option;
	
	
	
	@FindBy(xpath = "//span[.='Table Name']/../../../../mat-checkbox/label/span/input[@aria-checked='false']")
	WebElement Unchecked_Table_Name;
	
	@FindBy(xpath = "//span[.='Service Type']/../../../../mat-checkbox/label/span/input[@aria-checked='false']")
	WebElement Unchecked_Service_Type;
	
	@FindBy(xpath = "//span[.='Check Number']/../../../../mat-checkbox/label/span/input[@aria-checked='false']")
	WebElement Unchecked_Check_Number;
	
	@FindBy(xpath = "//span[.='Seat Number']/../../../../mat-checkbox/label/span/input[@aria-checked='false']")
	WebElement Unchecked_Seat_Number;
	
	@FindBy(xpath = "//span[.='Time']/../../../../mat-checkbox/label/span/input[@aria-checked='false']")
	WebElement Unchecked_Time;
	
	@FindBy(xpath = "//span[.='Notes']/../../../../mat-checkbox/label/span/input[@aria-checked='false']")
	WebElement Unchecked_Notes;
	
	@FindBy(xpath = "//span[.='Server Name']/../../../../mat-checkbox/label/span/input[@aria-checked='false']")
	WebElement Unchecked_Server_Name;
	
	@FindBy(xpath = "//span[.='KDS Done Button']/../../../../mat-checkbox/label/span/input[@aria-checked='false']")
	WebElement Unchecked_KDS_Done_Btn;
	
	@FindBy(xpath = "//h6[contains(.,'Disable KDS Broadcast')]")
	WebElement Disable_KDS_Broadcast_Option;
	
	@FindBy(xpath = "//h6[contains(.,'Disable KDS Broadcast')]/../../div/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button/span[.='No']")
	WebElement Disable_KDS_Broadcast_Option_No_Btn;
	
	@FindBy(xpath = "//h6[contains(.,'Disable KDS Broadcast')]/../../div/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button/span[.='Yes']")
	WebElement Disable_KDS_Broadcast_Option_Yes_Btn;
	
	@FindBy(xpath = "//h6[.='Modifier color']")
	WebElement ModifierColor;
	
	@FindBy(xpath = "//h6[.='Addon Color']")
	WebElement AddonColor;
	
	@FindBy(xpath = "//h6[.='Modifier color']/../../../../div[2]/div[1]/div/div[1]/div")
	WebElement Modifier_Color;
	
	@FindBy(xpath = "//h6[.='Modifier color']/../../../../div[2]/div[2]/div/div[1]/div")
	WebElement Addon_Color;
	
	
	@FindBy(xpath = "//h6[.='Status 1']")
	WebElement Status1;
	
	@FindBy(xpath = "//h6[.='Status 2']")
	WebElement Status2;
	
	@FindBy(xpath = "//h6[.='Status 3']")
	WebElement Status3;
	
	@FindBy(xpath = "//h6[.='Status 1']/../../div[2]/div/div/h6")
	WebElement StatusColor1;
	
	@FindBy(xpath = "//h6[.='Status 2']/../../div[2]/div/div/h6")
	WebElement StatusColor2;
	
	@FindBy(xpath = "//h6[.='Status 3']/../../div[2]/div/div/h6")
	WebElement StatusColor3;
	
	@FindBy(xpath = "//h6[.='Status 1']/../../div[2]/div/div/div[1]/div")
	WebElement Status1Color;
	
	@FindBy(xpath = "//h6[.='Status 2']/../../div[2]/div/div/div[1]/div")
	WebElement Status2Color;
	
	@FindBy(xpath = "//h6[.='Status 3']/../../div[2]/div/div/div[1]/div")
	WebElement Status3Color;
	
	@FindBy(xpath = "//h6[.='Status 1']/../../div[2]/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Status1AfterMins;
	
	@FindBy(xpath = "//h6[.='Status 2']/../../div[2]/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Status2AfterMins;
	
	@FindBy(xpath = "//h6[.='Status 3']/../../div[2]/div[2]/app-input/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Status3AfterMins;

	@FindBy(xpath = "//h6[.='Status 1']/../../div[2]/div[2]/app-input/div/div/div/button[1]")
	WebElement Status1AfterMinsUpArrow;
	
	@FindBy(xpath = "//h6[.='Status 1']/../../div[2]/div[2]/app-input/div/div/div/button[2]")
	WebElement Status1AfterMinsDownArrow;
	
	@FindBy(xpath = "//h6[.='Status 2']/../../div[2]/div[2]/app-input/div/div/div/button[1]")
	WebElement Status2AfterMinsUpArrow;
	
	@FindBy(xpath = "//h6[.='Status 2']/../../div[2]/div[2]/app-input/div/div/div/button[2]")
	WebElement Status2AfterMinsDownArrow;
	
	@FindBy(xpath = "//h6[.='Status 3']/../../div[2]/div[2]/app-input/div/div/div/button[1]")
	WebElement Status3AfterMinsUpArrow;
	
	@FindBy(xpath = "//h6[.='Status 3']/../../div[2]/div[2]/app-input/div/div/div/button[2]")
	WebElement Status3AfterMinsDownArrow;
	
	@FindBy(xpath = "//h6[contains(.,'Customer Arrived Notification')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='No']")
	WebElement CustomerArrivedNotification_No_Toggle;
	
	@FindBy(xpath = "//h6[contains(.,'Customer Arrived Notification')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
	WebElement CustomerArrivedNotification_Yes_Toggle;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:QSR')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='No']")
	WebElement Completed_Order_QSR_No_Toggle;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:QSR')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
	WebElement Completed_Order_QSR_Yes_Toggle;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:QSR')]/../../../div[5]/div[2]/div/textarea")
	WebElement Completed_Order_QSR_TextArea;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:Table Service')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='No']")
	WebElement Completed_Order_TableService_No_Toggle;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:Table Service')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
	WebElement Completed_Order_TableService_Yes_Toggle;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:QSR')]/../../../div[7]/div[2]/div/textarea")
	WebElement Completed_Order_TableService_TextArea;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:Online Order')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='No']")
	WebElement Completed_Order_Online_No_Toggle;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:Online Order')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
	WebElement Completed_Order_Online_Yes_Toggle;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:QSR')]/../../../div[9]/div[2]/div/textarea")
	WebElement Completed_Order_Online_TextArea;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:Delivery Order')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='No']")
	WebElement Completed_Order_Delivery_No_Toggle;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:Delivery Order')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
	WebElement Completed_Order_Delivery_Yes_Toggle;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:QSR')]/../../../div[11]/div[2]/div/textarea")
	WebElement Completed_Order_Delivery_TextArea;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:To Go Order')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='No']")
	WebElement Completed_Order_ToGo_No_Toggle;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:To Go Order')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
	WebElement Completed_Order_ToGo_Yes_Toggle;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:QSR')]/../../../div[13]/div[2]/div/textarea")
	WebElement Completed_Order_ToGo_TextArea;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:For Here Order')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='No']")
	WebElement Completed_Order_ForHere_No_Toggle;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:For Here Order')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
	WebElement Completed_Order_ForHere_Yes_Toggle;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:QSR')]/../../../div[15]/div[2]/div/textarea")
	WebElement Completed_Order_ForHere_TextArea;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:Bar Tab Order')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='No']")
	WebElement Completed_Order_BarTab_No_Toggle;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:Bar Tab Order')]/../../div[2]/app-toggle/div/mat-button-toggle-group/mat-button-toggle/button[.='Yes']")
	WebElement Completed_Order_BarTab_Yes_Toggle;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:QSR')]/../../../div[17]/div[2]/div/textarea")
	WebElement Completed_Order_BarTab_TextArea;
	
	@FindBy(xpath = "//h6[contains(.,'Customer Arrived Notification')]")
	WebElement CustomerArrivedNotification;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:QSR')]")
	WebElement Completed_Order_QSR;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:Table Service')]")
	WebElement Completed_Order_TableService;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:Online Order')]")
	WebElement Completed_Order_Online;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:Delivery Order')]")
	WebElement Completed_Order_Delivery;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:To Go Order')]")
	WebElement Completed_Order_ToGo;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:For Here Order')]")
	WebElement Completed_Order_ForHere;
	
	@FindBy(xpath = "//h6[contains(.,'Completed Order:Bar Tab Order')]")
	WebElement Completed_Order_BarTab;
	
	@FindBy(xpath = "//button[.=' UPDATE ']")
	WebElement update_Btn;
	
	@FindBy(xpath = "//img[contains(@class,'coffee')]/../../div/div[@class='row'][1]/div[2]/span")
	WebElement tble_TableName;
	
	@FindBy(xpath = "//img[contains(@class,'coffee')]/../../div/div[@class='row'][1]/div[1]/span")
	WebElement tble_CheckNumber;
	
	@FindBy(xpath = "//img[contains(@class,'coffee')]/../../div/div[@class='row'][1]/div[3]/span")
	WebElement tble_Time;
	
	@FindBy(xpath = "//img[contains(@class,'coffee')]/../../div/div[@class='row'][2]/div[3]/span")
	WebElement tble_ServerName;
	
	@FindBy(xpath = "//img[contains(@class,'coffee')]/../../div/div[@class='row'][2]/div[1]/span")
	WebElement tble_ServeiceType;
	
	@FindBy(xpath = "//span[contains(.,'Seat') and @class='ng-star-inserted']")
	WebElement tble_SeatNumber;
	
	@FindBy(xpath = "//span[contains(.,'Add salt and pepper') and @class='ng-star-inserted']")
	WebElement tble_Notes;
	
	@FindBy(xpath = "//img[contains(@class,'coffee')]/../../div/div[@class='row'][2]/div[2]/span")
	WebElement tble_KDSDoneBtn;
	
	@FindBy(xpath = "//button[contains(.,'UPDATE') and @disabled='true']")
	WebElement updateBtnDisabled;
	
	
	
	
	public void verifyTheAfterMinsFunctionalities_Status1()
	{
		for(int i = 1; i <= 4; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		Status1Color.click();
		
		String selectedCol1;
		try {
			selectedCol1 = driver.findElement(By.xpath("//mat-icon[contains(@class,'mat-icon-no-color select-check')]//parent::div")).getAttribute("style");
		}catch(Exception f)
		{
			selectedCol1 = driver.findElement(By.xpath("//mat-icon[contains(@class,'select-check mat-icon-no-color')]//parent::div")).getAttribute("style");
		}
		
		String actualCol1 = Status1Color.getAttribute("style");
		
		if(actualCol1.contains(selectedCol1))
		{
			test.log(LogStatus.PASS, "The Selected color is displayed in the tile after selecting the color in Status 1");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "The Selected color is not displayed in the tile after selecting the color in Status 1");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		List<WebElement> col =driver.findElements(By.xpath("//div[contains(@class,'color-pick cursor-pointer')]"));
		
		Random r = new Random();
		
		int randomValue =  r.nextInt(col.size());
		
		col.get(randomValue).click();
		
		String u1 =  Status1AfterMins.getAttribute("value");
		
		int i1 = Integer.parseInt(u1);
		
		i1 = i1 + 1;
		
		//Click the up arrow button
		Status1AfterMinsUpArrow.click();
		
		String u1a =  Status1AfterMins.getAttribute("value");
		
		int i1a = Integer.parseInt(u1a);
				
		if(i1 == i1a)
		{
			test.log(LogStatus.PASS, "Increase the value of After Mins - Status 1 is working fine when user click the increase button");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of After Mins - Status 1 is not working fine when user click the increase");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//click the down arrow button
		Status1AfterMinsDownArrow.click();
		
		String u2 =  Status1AfterMins.getAttribute("value");
		
		int i2 = Integer.parseInt(u2);
		
		if(i2 == (i1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of After Mins - Status 1 is working fine when user click it then it is decreased by 1");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of After Mins - Status 1 is not working fine when user click it");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Status1AfterMins.sendKeys("e");
		
		String u4 =  Status1AfterMins.getAttribute("value");
		
		if(u4.contains("e"))
		{
			test.log(LogStatus.FAIL, "The After mins field accept the Alphabets in Status 1");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.PASS, "The After mins field not accept the Alphabets in Status 1");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Status1AfterMins.sendKeys(Keys.ARROW_DOWN);
		
		String u5 =  Status1AfterMins.getAttribute("value");
		
		int i5 = Integer.parseInt(u5);
		
		if(i5 == -1)
		{
			test.log(LogStatus.FAIL, "The After Mins - Status 1 field accept the negative values");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.PASS, "The After Mins - Status 1 field is not accept the negative values");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Click the up arrow button
		Status1AfterMinsUpArrow.click();
		
		//Click the up arrow button
		Status1AfterMinsUpArrow.click();
	}
	
	public void verifyTheAfterMinsFunctionalities_Status2()
	{
		for(int i = 1; i <= 4; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		Status2Color.click();
		
		String selectedCol1;
		try {
			selectedCol1 = driver.findElement(By.xpath("//mat-icon[contains(@class,'mat-icon-no-color select-check')]//parent::div")).getAttribute("style");
		}catch(Exception f)
		{
			selectedCol1 = driver.findElement(By.xpath("//mat-icon[contains(@class,'select-check mat-icon-no-color')]//parent::div")).getAttribute("style");
		}
		
		String actualCol1 = Status2Color.getAttribute("style");
		
		if(actualCol1.contains(selectedCol1))
		{
			test.log(LogStatus.PASS, "The Selected color is displayed in the tile after selecting the color in Status 2");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "The Selected color is not displayed in the tile after selecting the color in Status 2");
		ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		List<WebElement> col =driver.findElements(By.xpath("//div[contains(@class,'color-pick cursor-pointer')]"));
		
		Random r = new Random();
		
		int randomValue =  r.nextInt(col.size());
		
		col.get(randomValue).click();

		
		String u1 =  Status2AfterMins.getAttribute("value");
		
		int i1 = Integer.parseInt(u1);
		
		i1 = i1 + 1;
		
		//Click the up arrow button
		Status2AfterMinsUpArrow.click();
		
		String u1a =  Status2AfterMins.getAttribute("value");
		
		int i1a = Integer.parseInt(u1a);
				
		if(i1 == i1a)
		{
			test.log(LogStatus.PASS, "Increase the value of After Mins - Status 2 is working fine when user click the increase button");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of After Mins - Status 2 is not working fine when user click the increase");
		ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//click the down arrow button
		Status2AfterMinsDownArrow.click();
		
		String u2 =  Status2AfterMins.getAttribute("value");
		
		int i2 = Integer.parseInt(u2);
		
		if(i2 == (i1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of After Mins - Status 2 is working fine when user click it then it is decreased by 1");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of After Mins - Status 2 is not working fine when user click it");
		ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Status2AfterMins.sendKeys("e");
		
		String u4 =  Status2AfterMins.getAttribute("value");
		
		if(u4.contains("e"))
		{
			test.log(LogStatus.FAIL, "The After mins field accept the Alphabets in Status 2");
		ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.PASS, "The After mins field not accept the Alphabets in Status 2");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Status2AfterMins.sendKeys(Keys.ARROW_DOWN);
		
		String u5 =  Status2AfterMins.getAttribute("value");
		
		int i5 = Integer.parseInt(u5);
		
		if(i5 == -1)
		{
			test.log(LogStatus.FAIL, "The After Mins - Status 2 field accept the negative values");
		ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.PASS, "The After Mins - Status 2 field is not accept the negative values");
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Click the up arrow button
		Status2AfterMinsUpArrow.click();
		
		//Click the up arrow button
		Status2AfterMinsUpArrow.click();
	}
	
	public void verifyTheAfterMinsFunctionalities_Status3()
	{
		for(int i = 1; i <= 4; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		Status3Color.click();
		
		String selectedCol1;
		try {
			selectedCol1 = driver.findElement(By.xpath("//mat-icon[contains(@class,'mat-icon-no-color select-check')]//parent::div")).getAttribute("style");
		}catch(Exception f)
		{
			selectedCol1 = driver.findElement(By.xpath("//mat-icon[contains(@class,'select-check mat-icon-no-color')]//parent::div")).getAttribute("style");
		}
		
		String actualCol1 = Status3Color.getAttribute("style");
		
		if(actualCol1.contains(selectedCol1))
		{
			test.log(LogStatus.PASS, "The Selected color is displayed in the tile after selecting the color in Status 3");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "The Selected color is not displayed in the tile after selecting the color in Status 3");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		List<WebElement> col =driver.findElements(By.xpath("//div[contains(@class,'color-pick cursor-pointer')]"));
		
		Random r = new Random();
		
		int randomValue =  r.nextInt(col.size());
		
		col.get(randomValue).click();
		
		String u1 =  Status3AfterMins.getAttribute("value");
		
		int i1 = Integer.parseInt(u1);
		
		i1 = i1 + 1;
		
		//Click the up arrow button
		Status3AfterMinsUpArrow.click();
		
		String u1a =  Status3AfterMins.getAttribute("value");
		
		int i1a = Integer.parseInt(u1a);
				
		if(i1 == i1a)
		{
			test.log(LogStatus.PASS, "Increase the value of After Mins - Status 3 is working fine when user click the increase button");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Increase the value of After Mins - Status 3 is not working fine when user click the increase");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//click the down arrow button
		Status3AfterMinsDownArrow.click();
		
		String u2 =  Status3AfterMins.getAttribute("value");
		
		int i2 = Integer.parseInt(u2);
		
		if(i2 == (i1-1))
		{
			test.log(LogStatus.PASS, "Decrease the value of After Mins - Status 3 is working fine when user click it then it is decreased by 1");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Decrease the value of After Mins - Status 3 is not working fine when user click it");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Status3AfterMins.sendKeys("e");
		
		String u4 =  Status3AfterMins.getAttribute("value");
		
		if(u4.contains("e"))
		{
			test.log(LogStatus.FAIL, "The After mins field accept the Alphabets in Status 3");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.PASS, "The After mins field not accept the Alphabets in Status 3");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Status3AfterMins.sendKeys(Keys.ARROW_DOWN);
		
		String u5 =  Status3AfterMins.getAttribute("value");
		
		int i5 = Integer.parseInt(u5);
		
		if(i5 == -1)
		{
			test.log(LogStatus.FAIL, "The After Mins - Status 3 field accept the negative values");
		ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.PASS, "The After Mins - Status 3 field is not accept the negative values");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Click the up arrow button
		Status3AfterMinsUpArrow.click();
		
		//Click the up arrow button
		Status3AfterMinsUpArrow.click();
	}

	
	public void verifyTheSMSOrderNotifications() throws Exception {
		Thread.sleep(1000);
		
		//Click the SMS Order Notifications
		SMS_Order_Notifications.click();
		
		if(CustomerArrivedNotification.isDisplayed()) {
			test.log(LogStatus.PASS, "Customer Arrived Notification option is displayed when user click the SMS Order Notifications options in KDS Configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Customer Arrived Notification option is not displayed when user click the SMS Order Notifications options in KDS Configuration page");
		}
		
		if(Completed_Order_QSR.isDisplayed()) {
			test.log(LogStatus.PASS, "Completed Order QSR option is displayed when user click the SMS Order Notifications options in KDS Configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Completed Order QSR option is not displayed when user click the SMS Order Notifications options in KDS Configuration page");
		}
		
		if(Completed_Order_TableService.isDisplayed()) {
			test.log(LogStatus.PASS, "Completed Order TableService option is displayed when user click the SMS Order Notifications options in KDS Configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Completed Order TableService option is not displayed when user click the SMS Order Notifications options in KDS Configuration page");
		}
		
		if(Completed_Order_Online.isDisplayed()) {
			test.log(LogStatus.PASS, "Completed Order Online option is displayed when user click the SMS Order Notifications options in KDS Configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Completed Order Online option is not displayed when user click the SMS Order Notifications options in KDS Configuration page");
		}
		
		if(Completed_Order_Delivery.isDisplayed()) {
			test.log(LogStatus.PASS, "Completed Order Delivery option is displayed when user click the SMS Order Notifications options in KDS Configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Completed Order Delivery option is not displayed when user click the SMS Order Notifications options in KDS Configuration page");
		}
		
		if(Completed_Order_ToGo.isDisplayed()) {
			test.log(LogStatus.PASS, "Completed Order ToGo option is displayed when user click the SMS Order Notifications options in KDS Configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Completed Order ToGo option is not displayed when user click the SMS Order Notifications options in KDS Configuration page");
		}
		
		if(Completed_Order_ForHere.isDisplayed()) {
			test.log(LogStatus.PASS, "Completed Order ForHere option is displayed when user click the SMS Order Notifications options in KDS Configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Completed Order ForHere option is not displayed when user click the SMS Order Notifications options in KDS Configuration page");
		}
		
		if(Completed_Order_BarTab.isDisplayed()) {
			test.log(LogStatus.PASS, "Completed Order BarTab option is displayed when user click the SMS Order Notifications options in KDS Configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Completed Order BarTab option is not displayed when user click the SMS Order Notifications options in KDS Configuration page");
		}
		
		for(int i = 1; i <= 10; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		CustomerArrivedNotification_No_Toggle.click();
		Completed_Order_QSR_No_Toggle.click();
		Completed_Order_TableService_No_Toggle.click();
		Completed_Order_Online_No_Toggle.click();
		
		for(int i = 1; i <= 10; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		Completed_Order_Delivery_No_Toggle.click();
		Completed_Order_ToGo_No_Toggle.click();
		Completed_Order_ForHere_No_Toggle.click();
		Completed_Order_BarTab_No_Toggle.click();
		
		try {
			if(updateBtnDisabled.isDisplayed()) {
				
			}
		}catch(Exception e) {
			//Click the Update
			update_Btn.click();
			
			Thread.sleep(1500);
			if(driver.findElement(By.xpath("//div[contains(@class,'message')]/span")).getText().equalsIgnoreCase("KDS Configuration saved successfully"))
			{
				test.log(LogStatus.PASS, "KDS Configuration saved successfully message displayed successfully message is displayed when used do the changes in SMS Order Notification");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "KDS Configuration saved successfully message displayed successfully message is not displayed when used do the changes in SMS Order Notification");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(1000);
			
			//Click the SMS Order Notifications
			SMS_Order_Notifications.click();
		}

		/*
		 * for(int i = 1; i <= 10; i++) {
		 * driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		 * Thread.sleep(2000); }
		 */
	      ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);", FieldOptions);
	      Thread.sleep(800);
		
		
		Thread.sleep(2000);
		
		CustomerArrivedNotification_Yes_Toggle.click();
		
		Completed_Order_QSR_Yes_Toggle.click();
		
		Completed_Order_QSR_TextArea.clear();
		
		Completed_Order_QSR_TextArea.sendKeys(RandomStringUtils.randomAlphabetic(165));
		
		Thread.sleep(500);
		
		String s = Completed_Order_QSR_TextArea.getAttribute("value");
		
		if(s.length() == 160)
		{
			test.log(LogStatus.PASS, "Required text is available in the QSR text area and it contains 160 chars");
		}
		else
		{
			test.log(LogStatus.FAIL, "Required text is not available in the QSR text area and it contains more than 160 chars");
		}
		
		Completed_Order_TableService_Yes_Toggle.click();
		
		Completed_Order_TableService_TextArea.clear();
		
		Completed_Order_TableService_TextArea.sendKeys(RandomStringUtils.randomAlphabetic(165));
		
		Thread.sleep(500);
		
		String s1 = Completed_Order_TableService_TextArea.getAttribute("value");
		
		if(s1.length() == 160)
		{
			test.log(LogStatus.PASS, "Required text is available in the Table Service text area and it contains 160 chars");
		}
		else
		{
			test.log(LogStatus.FAIL, "Required text is not available in the Table Service text area and it contains more than 160 chars");
		}
		
		Completed_Order_Online_Yes_Toggle.click();
		
		Completed_Order_Online_TextArea.clear();
		
		Completed_Order_Online_TextArea.sendKeys(RandomStringUtils.randomAlphabetic(165));
		
		Thread.sleep(500);
		
		String s2 = Completed_Order_Online_TextArea.getAttribute("value");
		
		if(s2.length() == 160)
		{
			test.log(LogStatus.PASS, "Required text is available in the Online text area and it contains 160 chars");
		}
		else
		{
			test.log(LogStatus.FAIL, "Required text is not available in the Online text area and it contains more than 160 chars");
		}
		
		Completed_Order_Delivery_Yes_Toggle.click();
		
		Completed_Order_Delivery_TextArea.clear();
		
		Completed_Order_Delivery_TextArea.sendKeys(RandomStringUtils.randomAlphabetic(165));
		
		Thread.sleep(500);
		
		String s3 = Completed_Order_Delivery_TextArea.getAttribute("value");
		
		if(s3.length() == 160)
		{
			test.log(LogStatus.PASS, "Required text is available in the Delivery text area and it contains 160 chars");
		}
		else
		{
			test.log(LogStatus.FAIL, "Required text is not available in the Delivery text area and it contains more than 160 chars");
		}
		
		Completed_Order_ToGo_Yes_Toggle.click();
		
		Completed_Order_ToGo_TextArea.clear();
		
		Completed_Order_ToGo_TextArea.sendKeys(RandomStringUtils.randomAlphabetic(165));
		
		Thread.sleep(500);
		
		String s4 = Completed_Order_ToGo_TextArea.getAttribute("value");
		
		if(s4.length() == 160)
		{
			test.log(LogStatus.PASS, "Required text is available in the To Go text area and it contains 160 chars");
		}
		else
		{
			test.log(LogStatus.FAIL, "Required text is not available in the To Go text area and it contains more than 160 chars");
		}
		
		Completed_Order_ForHere_Yes_Toggle.click();
		
		Completed_Order_ForHere_TextArea.clear();
		
		Completed_Order_ForHere_TextArea.sendKeys(RandomStringUtils.randomAlphabetic(165));
		
		Thread.sleep(500);
		
		String s5 = Completed_Order_ForHere_TextArea.getAttribute("value");
		
		if(s5.length() == 160)
		{
			test.log(LogStatus.PASS, "Required text is available in the For Here text area and it contains 160 chars");
		}
		else
		{
			test.log(LogStatus.FAIL, "Required text is not available in the For Here text area and it contains more than 160 chars");
		}
		
		Completed_Order_BarTab_Yes_Toggle.click();		
		
		Completed_Order_BarTab_TextArea.clear();
		
		Completed_Order_BarTab_TextArea.sendKeys(RandomStringUtils.randomAlphabetic(165));
		
		Thread.sleep(500);
		
		String s6 = Completed_Order_BarTab_TextArea.getAttribute("value");
		
		if(s6.length() == 160)
		{
			test.log(LogStatus.PASS, "Required text is available in the BarTab text area and it contains 160 chars");
		}
		else
		{
			test.log(LogStatus.FAIL, "Required text is not available in the BarTab text area and it contains more than 160 chars");
		}
		
		/*
		 * WebElement ws = driver.findElement(By.xpath("//h6[.='KDS Ticket Preview']"));
		 * ((JavascriptExecutor)driver).executeScript(
		 * "arguments[0].scrollIntoView(true);", ws); Thread.sleep(800);
		 */
			for(int i = 1; i <= 50; i++)
			{
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
			}
		
		Thread.sleep(2000);
		
		//Click the SMS Order Notifications
		SMS_Order_Notifications.click();
	}
	
	public void verifyTheStyleOptions() throws Exception {
		Thread.sleep(1000);
		//Click the style options
		StyleOptions.click();
		
		if(ModifierColor.isDisplayed()) {
			test.log(LogStatus.PASS, "Modifier Color option is displayed when user click the style options in KDS Configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifier Color option is not displayed when user click the style options in KDS Configuration page");
		}
		
		if(AddonColor.isDisplayed()) {
			test.log(LogStatus.PASS, "Addon Color option is displayed when user click the style options in KDS Configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Addon Color option is not displayed when user click the style options in KDS Configuration page");
		}
		
		if(Status1Color.isDisplayed()) {
			test.log(LogStatus.PASS, "Status 1 Color option is displayed when user click the style options in KDS Configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Status 1 Color option is not displayed when user click the style options in KDS Configuration page");
		}
		
		if(Status2Color.isDisplayed()) {
			test.log(LogStatus.PASS, "Status 2 Color option is displayed when user click the style options in KDS Configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Status 2 Color option is not displayed when user click the style options in KDS Configuration page");
		}
		
		if(Status3Color.isDisplayed()) {
			test.log(LogStatus.PASS, "Status 3 Color option is displayed when user click the style options in KDS Configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Status 3 Color option is not displayed when user click the style options in KDS Configuration page");
		}
		
		if(Status1AfterMins.isDisplayed()) {
			test.log(LogStatus.PASS, "Status 1 AfterMins option is displayed when user click the style options in KDS Configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Status 1 AfterMins option is not displayed when user click the style options in KDS Configuration page");
		}
		
		if(Status2AfterMins.isDisplayed()) {
			test.log(LogStatus.PASS, "Status 2 AfterMins option is displayed when user click the style options in KDS Configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Status 2 AfterMins option is not displayed when user click the style options in KDS Configuration page");
		}
		
		if(Status3AfterMins.isDisplayed()) {
			test.log(LogStatus.PASS, "Status 3 AfterMins option is displayed when user click the style options in KDS Configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Status 3 AfterMins option is not displayed when user click the style options in KDS Configuration page");
		}
		
		//Change the modifier Color
		//Click the modifier current Color
		Modifier_Color.click();
		Thread.sleep(2000);
		
		
		for(int i = 1; i <= 5; i++) {
			
			
			List<WebElement> col =driver.findElements(By.xpath("//div[contains(@class,'color-pick cursor-pointer')]"));
			
			Random r = new Random();
			
			int randomValue =  r.nextInt(col.size());
			
			col.get(randomValue).click();
			
			String col1 = col.get(randomValue).getAttribute("style");			
			Thread.sleep(2000);
			
			col1 = col1.substring(12);
			
			String col2 = driver.findElement(By.xpath("//span[contains(.,'American Cheese Burger')]/../span[3]")).getAttribute("style");
			
			col2 = col2.substring(6);
			
			if(col1.contains(col2))
			{
				test.log(LogStatus.PASS, "The modifier text color changed successfully, while user change the color in style option");
			}
			else
			{
				test.log(LogStatus.FAIL, "The modifier text color not changing, while user change the color in style option");
			}
			
			String selectedCol = driver.findElement(By.xpath("//mat-icon[contains(@class,'mat-icon-no-color select-check')]//parent::div")).getAttribute("style");
			
			String actualCol = Modifier_Color.getAttribute("style");
			
			if(actualCol.contains(selectedCol))
			{
				test.log(LogStatus.PASS, "The Selected color is displayed in the tile after selecting the color in Modifier");
			}
			else
			{
				test.log(LogStatus.FAIL, "The Selected color is not displayed in the tile after selecting the color in Modifier");
			}
		}
		
		//Click the modifier current Color
		Addon_Color.click();	
		Thread.sleep(2000);
		
		for(int i = 1; i <= 5; i++) {
			
			String selectedCol;
			try {
				selectedCol = driver.findElement(By.xpath("//mat-icon[contains(@class,'mat-icon-no-color select-check')]//parent::div")).getAttribute("style");
			}catch(Exception f)
			{
				selectedCol = driver.findElement(By.xpath("//mat-icon[contains(@class,'select-check mat-icon-no-color')]//parent::div")).getAttribute("style");
			}
				
			String actualCol = Addon_Color.getAttribute("style");
			
			if(actualCol.contains(selectedCol))
			{
				test.log(LogStatus.PASS, "The Selected color is displayed in the tile after selecting the color in Addon");
			}
			else
			{
				test.log(LogStatus.FAIL, "The Selected color is not displayed in the tile after selecting the color in Addon");
			}
	
			List<WebElement> col =driver.findElements(By.xpath("//div[contains(@class,'color-pick cursor-pointer')]"));
			
			Random r = new Random();
			
			int randomValue =  r.nextInt(col.size());
			
			col.get(randomValue).click();
			
			String col1 = col.get(randomValue).getAttribute("style");			
			Thread.sleep(2000);
			
			col1 = col1.substring(12);
			
			String col2 = driver.findElement(By.xpath("//span[contains(.,'Boneless Wing-8')]//parent::div")).getAttribute("style");
			
			col2 = col2.substring(6);
			
			if(col1.contains(col2))
			{
				test.log(LogStatus.PASS, "The addon text color changed successfully, while user change the color in style option");
			}
			else
			{
				test.log(LogStatus.FAIL, "The addon text color not changing, while user change the color in style option");
			}
			
		}
		
		//Click the modifier current Color
		Modifier_Color.click();
		
		String selectedCol;
		try {
			selectedCol = driver.findElement(By.xpath("//mat-icon[contains(@class,'mat-icon-no-color select-check')]//parent::div")).getAttribute("style");
		}catch(Exception f)
		{
			selectedCol = driver.findElement(By.xpath("//mat-icon[contains(@class,'select-check mat-icon-no-color')]//parent::div")).getAttribute("style");
		}
		
		String actualCol = Modifier_Color.getAttribute("style");
		
		if(actualCol.contains(selectedCol))
		{
			test.log(LogStatus.PASS, "The Selected color is displayed in the tile after selecting the color in Modifier");
		}
		else
		{
			test.log(LogStatus.FAIL, "The Selected color is not displayed in the tile after selecting the color in Modifier");
		}
		
		verifyTheAfterMinsFunctionalities_Status1();
		verifyTheAfterMinsFunctionalities_Status2();
		verifyTheAfterMinsFunctionalities_Status3();
		
		for(int i = 1; i <= 15; i++)
		{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		
		/*
		 * ((JavascriptExecutor)driver).executeScript(
		 * "arguments[0].scrollIntoView(true);", FieldOptions); Thread.sleep(800);
		 */
		
		Thread.sleep(1000);
		StyleOptions.click();
	}
	
	public void verifyTheFieldOptions() throws Exception {
		Thread.sleep(1000);
		//click the field options tab
		FieldOptions.click();
		
		if(Table_Name_option.isDisplayed()) {
			test.log(LogStatus.PASS, "Table name option is displayed when user click the field options in KDS Configuration page");
			
			try
			{
				if(driver.findElement(By.xpath("//span[.='Table Name']/../../../../mat-checkbox[contains(@class,'mat-checkbox-checked')]")).isDisplayed())
				{}
			}
			catch(Exception d)
			{
				driver.findElement(By.xpath("//span[.='Table Name']/../../../../mat-checkbox")).click();
			}
			
			try {
				if(tble_TableName.isDisplayed())
				{
					test.log(LogStatus.PASS, "The table name is displayed in Table Template when user Select the Table name option in the Field Options");
				}
			}
			catch(Exception df)
			{
				test.log(LogStatus.FAIL, "The table name is not displayed in Table Template when user Select the Table name option in the Field Options");
			}
		
		}
		else
		{
			test.log(LogStatus.FAIL, "Table name option is not displayed when user click the field options in KDS Configuration page");
		}
		
		if(Service_Type_Option.isDisplayed()) {
			test.log(LogStatus.PASS, "Service Type Option is displayed when user click the field options in KDS Configuration page");
		
			try
			{
				if(driver.findElement(By.xpath("//span[.='Service Type']/../../../../mat-checkbox[contains(@class,'mat-checkbox-checked')]")).isDisplayed())
				{}
			}
			catch(Exception d)
			{
				driver.findElement(By.xpath("//span[.='Service Type']/../../../../mat-checkbox")).click();
			}
			
			try {
				if(tble_ServeiceType.isDisplayed())
				{
					test.log(LogStatus.PASS, "The Service Type is displayed in Table Template when user Select the Service Type option in the Field Options");
				}
			}
			catch(Exception df)
			{
				test.log(LogStatus.FAIL, "The Service Type is not displayed in Table Template when user Select the Service Type option in the Field Options");
			}
		
		}
		else
		{
			test.log(LogStatus.FAIL, "Service Type Option is not displayed when user click the field options in KDS Configuration page");
		}
		
		if(Check_Number_Option.isDisplayed()) {
			test.log(LogStatus.PASS, "Check Number option is displayed when user click the field options in KDS Configuration page");
		
			try
			{
				if(driver.findElement(By.xpath("//span[.='Check Number']/../../../../mat-checkbox[contains(@class,'mat-checkbox-checked')]")).isDisplayed())
				{}
			}
			catch(Exception d)
			{
				driver.findElement(By.xpath("//span[.='Check Number']/../../../../mat-checkbox")).click();
			}
			
			try {
				if(tble_CheckNumber.isDisplayed())
				{
					test.log(LogStatus.PASS, "The Check Number is displayed in Table Template when user Select the Check Number option in the Field Options");
				}
			}
			catch(Exception df)
			{
				test.log(LogStatus.FAIL, "The Check Number is not displayed in Table Template when user Select the Check Number option in the Field Options");
			}
		
		}
		else
		{
			test.log(LogStatus.FAIL, "Check Number option is not displayed when user click the field options in KDS Configuration page");
		}
		
		if(Seat_Number_Option.isDisplayed()) {
			test.log(LogStatus.PASS, "Seat Number option is displayed when user click the field options in KDS Configuration page");
			
			try
			{
				if(driver.findElement(By.xpath("//span[.='Seat Number']/../../../../mat-checkbox[contains(@class,'mat-checkbox-checked')]")).isDisplayed())
				{}
			}
			catch(Exception d)
			{
				driver.findElement(By.xpath("//span[.='Seat Number']/../../../../mat-checkbox")).click();
			}
			
			try {
				if(tble_SeatNumber.isDisplayed())
				{
					test.log(LogStatus.PASS, "The Seat Number is displayed in Table Template when user Select the Seat Number option in the Field Options");
				}
			}
			catch(Exception df)
			{
				test.log(LogStatus.FAIL, "The Seat Number is not displayed in Table Template when user Select the Seat Number option in the Field Options");
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "Seat Number option is not displayed when user click the field options in KDS Configuration page");
		}
		
		if(Time_Option.isDisplayed()) {
			test.log(LogStatus.PASS, "Time option is displayed when user click the field options in KDS Configuration page");
			
			try
			{
				if(driver.findElement(By.xpath("//span[.='Time']/../../../../mat-checkbox[contains(@class,'mat-checkbox-checked')]")).isDisplayed())
				{}
			}
			catch(Exception d)
			{
				driver.findElement(By.xpath("//span[.='Time']/../../../../mat-checkbox")).click();
			}
			
			try {
				if(tble_Time.isDisplayed())
				{
					test.log(LogStatus.PASS, "The Time is displayed in Table Template when user Select the Time option in the Field Options");
				}
			}
			catch(Exception df)
			{
				test.log(LogStatus.FAIL, "The Time is not displayed in Table Template when user Select the Time option in the Field Options");
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "Time option is not displayed when user click the field options in KDS Configuration page");
		}
		
		if(Notes_Option.isDisplayed()) {
			test.log(LogStatus.PASS, "Notes option is displayed when user click the field options in KDS Configuration page");
		
			try
			{
				if(driver.findElement(By.xpath("//span[.='Notes']/../../../../mat-checkbox[contains(@class,'mat-checkbox-checked')]")).isDisplayed())
				{}
			}
			catch(Exception d)
			{
				driver.findElement(By.xpath("//span[.='Notes']/../../../../mat-checkbox")).click();
			}
			
			try {
				if(tble_Notes.isDisplayed())
				{
					test.log(LogStatus.PASS, "The Notes is displayed in Table Template when user Select the Notes option in the Field Options");
				}
			}
			catch(Exception df)
			{
				test.log(LogStatus.FAIL, "The Notes is not displayed in Table Template when user Select the Notes option in the Field Options");
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "Notes option is not displayed when user click the field options in KDS Configuration page");
		}
		
		if(Server_Name_Option.isDisplayed()) {
			test.log(LogStatus.PASS, "Server name option is displayed when user click the field options in KDS Configuration page");
		
			try
			{
				if(driver.findElement(By.xpath("//span[.='Server Name']/../../../../mat-checkbox[contains(@class,'mat-checkbox-checked')]")).isDisplayed())
				{}
			}
			catch(Exception d)
			{
				driver.findElement(By.xpath("//span[.='Server Name']/../../../../mat-checkbox")).click();
			}
			
			try {
				if(tble_ServerName.isDisplayed())
				{
					test.log(LogStatus.PASS, "The Server Name is displayed in Table Template when user Select the Server Name option in the Field Options");
				}
			}
			catch(Exception df)
			{
				test.log(LogStatus.FAIL, "The Server Name is not displayed in Table Template when user Select the Server Name option in the Field Options");
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "Server name option is not displayed when user click the field options in KDS Configuration page");
		}
		
		if(KDS_Done_Btn_Option.isDisplayed()) {
			test.log(LogStatus.PASS, "KDS Done button option is displayed when user click the field options in KDS Configuration page");
		
			try
			{
				if(driver.findElement(By.xpath("//span[.='KDS Done Button']/../../../../mat-checkbox[contains(@class,'mat-checkbox-checked')]")).isDisplayed())
				{}
			}
			catch(Exception d)
			{
				driver.findElement(By.xpath("//span[.='KDS Done Button']/../../../../mat-checkbox")).click();
			}
			
			try {
				if(tble_KDSDoneBtn.isDisplayed())
				{
					test.log(LogStatus.PASS, "The KDS Done Button is displayed in Table Template when user Select the KDS Done Button option in the Field Options");
				}
			}
			catch(Exception df)
			{
				test.log(LogStatus.FAIL, "The KDS Done Button is not displayed in Table Template when user Select the KDS Done Button option in the Field Options");
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "KDS Done button option is not displayed when user click the field options in KDS Configuration page");
		}
		
		if(Disable_KDS_Broadcast_Option.isDisplayed()) {
			test.log(LogStatus.PASS, "Disable KDS Broadcast option is displayed when user click the field options in KDS Configuration page");
			Disable_KDS_Broadcast_Option_No_Btn.click();
		}
		else
		{
			test.log(LogStatus.FAIL, "Disable KDS Broadcast option is not displayed when user click the field options in KDS Configuration page");
		}
		Thread.sleep(1500);
		
		//click the field options tab
		//FieldOptions.click();
		
		try {
			if(updateBtnDisabled.isDisplayed()) {
				
			}
		}catch(Exception e) {
			//Click the Update
			update_Btn.click();
			
			Thread.sleep(1500);
			if(driver.findElement(By.xpath("//div[contains(@class,'message')]/span")).getText().equalsIgnoreCase("KDS Configuration saved successfully"))
			{
				test.log(LogStatus.PASS, "KDS Configuration saved successfully message displayed successfully message is displayed when used do the changes in Field options");
			}
			else
			{
				test.log(LogStatus.FAIL, "KDS Configuration saved successfully message displayed successfully message is not displayed when used do the changes in Field options");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(1000);
			//click the field options tab
			FieldOptions.click();
		}
		
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[.='Table Name']/../../../../mat-checkbox")).click();
		driver.findElement(By.xpath("//span[.='Service Type']/../../../../mat-checkbox")).click();
		driver.findElement(By.xpath("//span[.='Check Number']/../../../../mat-checkbox")).click();
		driver.findElement(By.xpath("//span[.='Seat Number']/../../../../mat-checkbox")).click();
		driver.findElement(By.xpath("//span[.='Time']/../../../../mat-checkbox")).click();
		driver.findElement(By.xpath("//span[.='Notes']/../../../../mat-checkbox")).click();
		driver.findElement(By.xpath("//span[.='Server Name']/../../../../mat-checkbox")).click();
		driver.findElement(By.xpath("//span[.='KDS Done Button']/../../../../mat-checkbox")).click();
		Disable_KDS_Broadcast_Option_Yes_Btn.click();
		
		
		if(Unchecked_Table_Name.isDisplayed())
		{
			test.log(LogStatus.INFO, "Table Name check box is unchecked");
		}
		else {
			test.log(LogStatus.FAIL, "Table Name check box is checked after user unchecked the check box");
		}
		
		if(Unchecked_Service_Type.isDisplayed())
		{
			test.log(LogStatus.INFO, "Service Type check box is unchecked");
		}
		else {
			test.log(LogStatus.FAIL, "Service Type check box is checked after user unchecked the check box");
		}
		
		if(Unchecked_Check_Number.isDisplayed())
		{
			test.log(LogStatus.INFO, "Check Number check box is unchecked");
		}
		else {
			test.log(LogStatus.FAIL, "Check Number check box is checked after user unchecked the check box");
		}
		
		if(Unchecked_Seat_Number.isDisplayed())
		{
			test.log(LogStatus.INFO, "Seat Number check box is unchecked");
		}
		else {
			test.log(LogStatus.FAIL, "Seat Number check box is checked after user unchecked the check box");
		}
		
		if(Unchecked_Time.isDisplayed())
		{
			test.log(LogStatus.INFO, "Time check box is unchecked");
		}
		else {
			test.log(LogStatus.FAIL, "Time check box is checked after user unchecked the check box");
		}
		
		if(Unchecked_Notes.isDisplayed())
		{
			test.log(LogStatus.INFO, "Notes check box is unchecked");
		}
		else {
			test.log(LogStatus.FAIL, "Notes check box is checked after user unchecked the check box");
		}
		
		if(Unchecked_Server_Name.isDisplayed())
		{
			test.log(LogStatus.INFO, "Server Name check box is unchecked");
		}
		else {
			test.log(LogStatus.FAIL, "Server Name check box is checked after user unchecked the check box");
		}
		
		if(Unchecked_KDS_Done_Btn.isDisplayed())
		{
			test.log(LogStatus.INFO, "KDS Done button check box is unchecked");
		}
		else {
			test.log(LogStatus.FAIL, "KDS Done button check box is checked after user unchecked the check box");
		}
		
		
		Thread.sleep(1500);
		
		//click the field options tab
		//FieldOptions.click();
		
		try {
			if(updateBtnDisabled.isDisplayed()) {
				
			}
		}catch(Exception e) {
			//Click the Update
			update_Btn.click();
			
			Thread.sleep(1500);
			if(driver.findElement(By.xpath("//div[contains(@class,'message')]/span")).getText().equalsIgnoreCase("KDS Configuration saved successfully"))
			{
				test.log(LogStatus.PASS, "KDS Configuration saved successfully message displayed successfully message is displayed when used do the changes in Field options");
			}
			else
			{
				test.log(LogStatus.FAIL, "KDS Configuration saved successfully message displayed successfully message is not displayed when used do the changes in Field options");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(1000);
			//click the field options tab
			FieldOptions.click();
		}
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[.='Table Name']/../../../../mat-checkbox")).click();
		driver.findElement(By.xpath("//span[.='Service Type']/../../../../mat-checkbox")).click();
		driver.findElement(By.xpath("//span[.='Check Number']/../../../../mat-checkbox")).click();
		driver.findElement(By.xpath("//span[.='Seat Number']/../../../../mat-checkbox")).click();
		driver.findElement(By.xpath("//span[.='Time']/../../../../mat-checkbox")).click();
		driver.findElement(By.xpath("//span[.='Notes']/../../../../mat-checkbox")).click();
		driver.findElement(By.xpath("//span[.='Server Name']/../../../../mat-checkbox")).click();
		driver.findElement(By.xpath("//span[.='KDS Done Button']/../../../../mat-checkbox")).click();
		
		Thread.sleep(1000);
		//click the field options tab
		FieldOptions.click();
		
	}
	
	public void verifyTheKDSPage() throws Exception {
		Thread.sleep(5000);
		
		if(KDSConfiguration_Heading.isDisplayed()) {
			test.log(LogStatus.PASS, "KDS Configuration heading is displayed when user navigate to the KDS configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "KDS Configuration heading is not displayed when user navigate to the KDS configuration page");
		}
		
		if(FieldOptions.isDisplayed()) {
			test.log(LogStatus.PASS, "Field Options is displayed when user navigate to the KDS configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Field Options is not displayed when user navigate to the KDS configuration page");
		}
		
		if(StyleOptions.isDisplayed()) {
			test.log(LogStatus.PASS, "Style Options is displayed when user navigate to the KDS configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Style Options is not displayed when user navigate to the KDS configuration page");
		}
		
		if(SMS_Order_Notifications.isDisplayed()) {
			test.log(LogStatus.PASS, "SMS Order Notifications is displayed when user navigate to the KDS configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "SMS Order Notifications is not displayed when user navigate to the KDS configuration page");
		}
		
		if(KDS_Ticket_Preview.isDisplayed()) {
			test.log(LogStatus.PASS, "KDS Ticket Preview is displayed when user navigate to the KDS configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "KDS Ticket Preview is not displayed when user navigate to the KDS configuration page");
		}
		
		if(Update_Btn.isDisplayed()) {
			test.log(LogStatus.PASS, "Update Button is displayed when user navigate to the KDS configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Update Button is not displayed when user navigate to the KDS configuration page");
		}
		
		if(KDS_Table.isDisplayed()) {
			test.log(LogStatus.PASS, "KDS Table is displayed when user navigate to the KDS configuration page");
		}
		else
		{
			test.log(LogStatus.FAIL, "KDS Table is not displayed when user navigate to the KDS configuration page");
		}
	}
}