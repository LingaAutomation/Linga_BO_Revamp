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

public class Settings_Businesshours_Page 
{
	public WebDriver driver;
	public ExtentTest test;


	public  Settings_Businesshours_Page(WebDriver driver, ExtentTest test) 
	{
		this.driver=driver;
		this.test=test;

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@mattooltip='Settings']")
	WebElement Settings;

	@FindBy(xpath = "//span[.='Business Hours']")
	WebElement Business_hours;

	@FindBy(xpath = "//div[@class='radio-box']/div[.='Store Hours']")
	WebElement Store_hours;

	@FindBy(xpath = "//span[.='Require Confirmation Before Closing Day']/../..//button[.='Yes']")
	WebElement Closing_Conf_YesToggle;

	@FindBy(xpath = "//span[.='Require Confirmation Before Closing Day']/../..//button[.='No']")
	WebElement Closing_Conf_NoToggle;

	@FindBy(xpath = "//span[.='Close All Active Tills']/../..//button[.='Yes']")
	WebElement Close_Till_YesToggle;

	@FindBy(xpath = "//span[.='Close All Active Tills']/../..//button[.='No']")
	WebElement Close_Till_NoToggle;

	@FindBy(xpath = "//span[.='Close All Active Employees']/../..//button[.='Yes']")
	WebElement Close_ActiveEmp_YesToggle;

	@FindBy(xpath = "//span[.='Close All Active Employees']/../..//button[.='No']")
	WebElement Close_ActiveEmp_NoToggle;

	@FindBy(xpath = "//span[.='Close Opened Checks']/../..//button[.='Yes']")
	WebElement Close_Check_YesToggle;

	@FindBy(xpath = "//span[.='Close Opened Checks']/../..//button[.='No']")
	WebElement Close_Check_NoToggle;

	@FindBy(xpath = "//span[.='Closing Opened Checks']/../..//button[.='CASH']")
	WebElement Close_Check_CashToggle;

	@FindBy(xpath = "//span[.='Closing Opened Checks']/../..//button[.='VOID']")
	WebElement Close_Check_VoidToggle;


	@FindBy(xpath = "//div[@class='radio-box']/div[.='Shifts']")
	WebElement Shifts;

	@FindBy(xpath = "//span[contains(.,'add')]")
	WebElement Add_Shift;

	@FindBy(xpath = " //div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[5]/div[4]")
	WebElement Delete;

	@FindBy(xpath = "//button[.=' UPDATE ']")
	WebElement Update;
	
	@FindBy(xpath = "//select-option[.=' OPEN ']")
	WebElement Open;
	
	@FindBy(xpath = "//select-option[.=' CLOSED ']")
	WebElement Closed;
	
	@FindBy(xpath = "//button[contains(.,' Cancel')]")
	WebElement Cancel;
	

	public void Navigating_Settings() 
	{
		Settings.click();
	}

	public void NavigatingBusinessHours()
	{
		Business_hours.click();
	}
	public void Navigating_StoreHours() 
	{
		Store_hours.click();
	}

	
	public void change_Open_Sunday() throws Exception {
		WebElement Sunopen = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[2]/div[2]"));
		Sunopen.click();
		Thread.sleep(1000);
		Open.click();
		Thread.sleep(500);
		WebElement Openat = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[2]/div[3]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button"));
		Openat.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-270deg);']")).click();
		Availability_RestrictionTimePage a = new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(1000);
		a.AM_Btn.click();

		Thread.sleep(500);
		a.OK_TimePickerBtn.click();
	
		WebElement Closedat = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[2]/div[4]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button"));
		Closedat.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-270deg);']")).click();
		Availability_RestrictionTimePage a1 = new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(1000);
		a1.PM_Btn.click();

		Thread.sleep(500);
		a1.OK_TimePickerBtn.click();
	    
		Thread.sleep(1000);
		Update.click();
		
		 Thread.sleep(2000);
		WebElement Sunclosed = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[2]/div[2]"));
		Sunclosed.click();
		Thread.sleep(1000);
		Closed.click();
		Thread.sleep(500);
		
		try {
			if(Openat.isDisplayed()) {

			}
		}
		catch (Exception e) 
		{
			System.out.println("The store is closed Today not able to select open time for sunday");
		}
		Thread.sleep(1000);
		
        try 
		{
			if(Closedat.isDisplayed()) {

			}
		} 
		catch (Exception e) {
			System.out.println("The store is closed Today not able to select closed time for sunday");
		}
         Thread.sleep(2000);
		}

	public void Reselect_Open_Sunday() throws Exception {
		WebElement Sunopen = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[2]/div[2]"));
		Sunopen.click();
		Thread.sleep(1000);
		Open.click();
	}
	
	public void Change_Open_Monday() throws Exception {
		WebElement Monopen = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[3]/div[2]"));
		Monopen.click();
		
		Thread.sleep(1000);
		Open.click();
		Thread.sleep(500);
		
		WebElement Openat = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[3]/div[3]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button"));
		Openat.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-300deg);']")).click();
		Availability_RestrictionTimePage a = new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(1000);
		a.AM_Btn.click();

		Thread.sleep(500);
		a.OK_TimePickerBtn.click();
	
		WebElement Closedat = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[3]/div[4]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button"));
		Closedat.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-300deg);']")).click();
		Availability_RestrictionTimePage a1 = new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(1000);
		a1.PM_Btn.click();

		Thread.sleep(500);
		a1.OK_TimePickerBtn.click();
	    Thread.sleep(2000);
	    Update.click();
	    
	    Thread.sleep(3000);
		WebElement Monclosed = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[3]/div[2]"));
	    Monclosed.click();
		Thread.sleep(1000);
		Closed.click();
		Thread.sleep(500);
		
		try {
			if(Openat.isDisplayed()) {

			}
		}
		catch (Exception e) 
		{
			System.out.println("The store is closed Today not able to select open time for Monday");
		}
		Thread.sleep(1000);
		
        try 
		{
			if(Closedat.isDisplayed()) {

			}
		} 
		catch (Exception e) {
			System.out.println("The store is closed Today not able to select closed time for Monday");
		}
         Thread.sleep(2000);
		}
	public void Reselect_Open_Monday() throws Exception {
		WebElement Monopen = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[3]/div[2]"));
		Monopen.click();
		Thread.sleep(1000);
		Open.click();
	}
	public void Change_Open_Tuesday() throws Exception {
		WebElement Tueopen = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[4]/div[2]"));
		Tueopen.click();
		
		Thread.sleep(1000);
		Open.click();
		Thread.sleep(500);
		
		WebElement Openat = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[4]/div[3]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button"));
		Openat.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-240deg);']")).click();
		Availability_RestrictionTimePage a = new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(1000);
		a.AM_Btn.click();

		Thread.sleep(500);
		a.OK_TimePickerBtn.click();
	
		WebElement Closedat = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[4]/div[4]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button"));
		Closedat.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-240deg);']")).click();
		Availability_RestrictionTimePage a1 = new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(1000);
		a1.PM_Btn.click();

		Thread.sleep(500);
		a1.OK_TimePickerBtn.click();
	    Thread.sleep(2000);
	    Update.click();
	    
	    Thread.sleep(3000);
		WebElement Tueclosed = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[4]/div[2]"));
		Tueclosed.click();
		Thread.sleep(1000);
		Closed.click();
		Thread.sleep(500);
		
		try {
			if(Openat.isDisplayed()) {

			}
		}
		catch (Exception e) 
		{
			System.out.println("The store is closed Today not able to select open time for Tuesday");
		}
		Thread.sleep(1000);
		
        try 
		{
			if(Closedat.isDisplayed()) {

			}
		} 
		catch (Exception e) {
			System.out.println("The store is closed Today not able to select closed time for Tuesday");
		}
         Thread.sleep(2000);
		}
	public void Reselect_Open_Tuesday() throws Exception {
		WebElement Tueopen = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[4]/div[2]"));
		Tueopen.click();
		Thread.sleep(1000);
		Open.click();
	}
	
	public void Change_Open_Wednesday() throws Exception {
		WebElement Wedopen = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[5]/div[2]"));
		Wedopen.click();
		
		Thread.sleep(1000);
		Open.click();
		Thread.sleep(500);
		
		WebElement Openat = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[5]/div[3]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button"));
		Openat.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-330deg);']")).click();
		Availability_RestrictionTimePage a = new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(1000);
		a.AM_Btn.click();

		Thread.sleep(500);
		a.OK_TimePickerBtn.click();
	
		WebElement Closedat = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[5]/div[4]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button"));
		Closedat.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-330deg);']")).click();
		Availability_RestrictionTimePage a1 = new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(1000);
		a1.PM_Btn.click();

		Thread.sleep(500);
		a1.OK_TimePickerBtn.click();
	    Thread.sleep(2000);
	    Update.click();
        
	    Thread.sleep(3000);
		WebElement Wedclosed = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[5]/div[2]"));
		Wedclosed.click();
		Thread.sleep(1000);
		Closed.click();
		Thread.sleep(500);
		
		try {
			if(Openat.isDisplayed()) {

			}
		}
		catch (Exception e) 
		{
			System.out.println("The store is closed Today not able to select open time for Wednesday");
		}
		Thread.sleep(1000);
		
        try 
		{
			if(Closedat.isDisplayed()) {

			}
		} 
		catch (Exception e) {
			System.out.println("The store is closed Today not able to select closed time for Wednesday");
		}
         Thread.sleep(2000);
		}
	public void Reselect_Open_Wednesday() throws Exception {
		WebElement Wedopen = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[5]/div[2]"));
		Wedopen.click();
		Thread.sleep(1000);
		Open.click();
	}
     
	public void Change_Open_Thursday() throws Exception {
		WebElement Thuopen = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[6]/div[2]"));
		Thuopen.click();
		
		Thread.sleep(1000);
		Open.click();
		Thread.sleep(500);
		
		WebElement Openat = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[6]/div[3]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button"));
		Openat.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-330deg);']")).click();
		Availability_RestrictionTimePage a = new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(1000);
		a.AM_Btn.click();

		Thread.sleep(500);
		a.OK_TimePickerBtn.click();
	
		WebElement Closedat = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[6]/div[4]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button"));
		Closedat.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-330deg);']")).click();
		Availability_RestrictionTimePage a1 = new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(1000);
		a1.AM_Btn.click();

		Thread.sleep(500);
		a1.OK_TimePickerBtn.click();
	    Thread.sleep(2000);
	    Update.click();
	    
	    Thread.sleep(3000);
		WebElement Wedclosed = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[6]/div[2]"));
		Wedclosed.click();
		Thread.sleep(1000);
		Closed.click();
		Thread.sleep(500);
		
		try {
			if(Openat.isDisplayed()) {

			}
		}
		catch (Exception e) 
		{
			System.out.println("The store is closed Today not able to select open time for Thursday");
		}
		Thread.sleep(1000);
		
        try 
		{
			if(Closedat.isDisplayed()) {

			}
		} 
		catch (Exception e) {
			System.out.println("The store is closed Today not able to select closed time for Thursday");
		}
         Thread.sleep(2000);
		}
	public void Reselect_Open_Thursday() throws Exception {
		WebElement Thuopen = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[6]/div[2]"));
		Thuopen.click();
		Thread.sleep(1000);
		Open.click();
	}

	public void Change_Open_Friday() throws Exception {
		WebElement Friopen = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[7]/div[2]"));
		Friopen.click();
		
		Thread.sleep(1000);
		Open.click();
		Thread.sleep(500);
		
		WebElement Openat = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[7]/div[3]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button"));
		Openat.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-210deg);']")).click();
		Availability_RestrictionTimePage a = new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(1000);
		a.PM_Btn.click();

		Thread.sleep(500);
		a.OK_TimePickerBtn.click();
	
		WebElement Closedat = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[7]/div[4]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button"));
		Closedat.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-210deg);']")).click();
		Availability_RestrictionTimePage a1 = new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(1000);
		a1.PM_Btn.click();

		Thread.sleep(500);
		a1.OK_TimePickerBtn.click();
	    Thread.sleep(2000);
	    Update.click();
	    
        Thread.sleep(3000);
		WebElement Friclosed = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[7]/div[2]"));
		Friclosed.click();
		Thread.sleep(1000);
		Closed.click();
		Thread.sleep(500);
		
		try {
			if(Openat.isDisplayed()) {

			}
		}
		catch (Exception e) 
		{
			System.out.println("The store is closed Today not able to select open time for Friday");
		}
		Thread.sleep(1000);
		
        try 
		{
			if(Closedat.isDisplayed()) {

			}
		} 
		catch (Exception e) {
			System.out.println("The store is closed Today not able to select closed time for Friday");
		}
	}
	public void Reselect_Open_Friday() throws Exception {
		WebElement Friopen = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[7]/div[2]"));
		Friopen.click();
		Thread.sleep(1000);
		Open.click();
	}
	public void Change_Open_Saturday() throws Exception {
		WebElement Satopen = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[8]/div[2]"));
		Satopen.click();
		
		Thread.sleep(1000);
		Open.click();
		Thread.sleep(500);
		
		WebElement Openat = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[8]/div[3]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button"));
		Openat.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-180deg);']")).click();
		Availability_RestrictionTimePage a = new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(1000);
		a.PM_Btn.click();

		Thread.sleep(500);
		a.OK_TimePickerBtn.click();
	     
		WebElement Closedat = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[8]/div[4]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button"));
		Closedat.click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-180deg);']")).click();
		Availability_RestrictionTimePage a1 = new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(1000);
		a1.AM_Btn.click();

		Thread.sleep(500);
		a1.OK_TimePickerBtn.click();
	    Thread.sleep(2000);
	    Update.click();
	    
	    Thread.sleep(3000);
		WebElement Satclosed = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[8]/div[2]"));
		Satclosed.click();
		Thread.sleep(1000);
		Closed.click();
		Thread.sleep(500);
		
		try {
			if(Openat.isDisplayed()) {

			}
		}
		catch (Exception e) 
		{
			System.out.println("The store is closed Today not able to select open time for Saturday");
		}
		Thread.sleep(1000);
		
        try 
		{
			if(Closedat.isDisplayed()) {

			}
		} 
		catch (Exception e) {
			System.out.println("The store is closed Today not able to select closed time for Saturday");
		}
         Thread.sleep(2000);
		}
	public void Reselect_Open_Saturday() throws Exception {
		WebElement Satopen = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[8]/div[2]"));
		Satopen.click();
		Thread.sleep(1000);
		Open.click();
	}
	public void Conform_Before_Closing() throws Exception
	{
		if(Closing_Conf_YesToggle.isSelected())
		{

		}
		else {
			Closing_Conf_YesToggle.click();
			Common_XPaths cmp = new Common_XPaths(driver, test);
			cmp.Alert_PopupMsg("Enabling this function will stop closing your day automatically, this is only recommended for 24 hour operations, enabling this function will require you to close the day manually every day. If the day is not closed manually multiple days will merge into single day.");
			Thread.sleep(5000);
			//driver.findElement(By.xpath("//button[.=' YES, RESET ']")).click();
			Cancel.click();
		}
	}
	public void Conform_Before_Closing_No() {
	if(Closing_Conf_NoToggle.isSelected())
	{

	}
	else {
		Closing_Conf_NoToggle.click();
		
	}
	}

	public void Closing_Active_Tills() throws Exception 
	{
		if(Close_Till_YesToggle.isSelected()) 
		{

		}
		else {
			Close_Till_YesToggle.click();
		}
	}
	public void Closing_Active_Tills_No() {
		if(Close_Till_NoToggle.isSelected()) 
		{

		}
		else {
			Close_Till_NoToggle.click();
		}
	}
	public void Close_Opened_Check() throws Exception 
	{
		if(Close_Check_YesToggle.isSelected()) {

		}
		else {
			Close_Check_YesToggle.click();
		}
	}
	public void Close_Opened_Check_No() throws Exception 
	{
		if(Close_Check_NoToggle.isSelected()) {

		}
		else {
			Close_Check_NoToggle.click();
		}
	}
	public void Close_Active_Emp() 
	{
		if(Close_ActiveEmp_YesToggle.isSelected()) {

		}
		else {
			Close_ActiveEmp_YesToggle.click();
		}
	}
	public void Close_Active_Emp_No() 
	{
		if(Close_ActiveEmp_NoToggle.isSelected()) {

		}
		else {
			Close_ActiveEmp_NoToggle.click();
		}
	}
	public void Closing_Opened_Check() 
	{
		if(Close_Check_CashToggle.isSelected())
		{

		}
		else 
		{
			Close_Check_CashToggle.click();
		}
	}
	public void Closing_Void_Check() 
	{
		if(Close_Check_VoidToggle.isSelected())
		{

		}
		else 
		{
			Close_Check_VoidToggle.click();
		}
		
	}
	public void Clicking_Shift() throws Exception
	{

		for(int i=1;i<=16;i++)
		{
			Thread.sleep(1000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		Shifts.click();
	}

	public void Shift_Hours() throws Exception 
	{Thread.sleep(2000);
		for(int i=1;i<=3;i++)
		{
			Thread.sleep(500);
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
		
		try
		{
			if(driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[2]/div[2]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button")).isDisplayed())
			{
				
			}
		}
		catch (Exception e) 
		{ for(int i=1;i<=3;i++)
			{
				Add_Shift.click();
			}
		}
		
		Thread.sleep(1000);
		//Enter Shift name 3rd row
		driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[2]/div[1]//input")).clear();
		driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[2]/div[1]//input")).sendKeys("Shift");
//		
		driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[2]/div[2]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-210deg);']")).click();
		Availability_RestrictionTimePage a = new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(1000);
		a.AM_Btn.click();

		Thread.sleep(500);
		a.OK_TimePickerBtn.click();

		//Enter Shift name 3rd row
		driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[3]/div[1]//input")).clear();
		driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[3]/div[1]//input")).sendKeys("Shift2");
//		
		driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[2]/div[3]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-300deg);']")).click();
		Thread.sleep(1000);
		a.AM_Btn.click();

		Thread.sleep(500);
		a.OK_TimePickerBtn.click();

		//Enter Shift name 3rd row
		driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[4]/div[1]//input")).clear();
		driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[4]/div[1]//input")).sendKeys("Shift3");
//		
		
		driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[3]/div[2]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-330deg);']")).click();
		Thread.sleep(1000);
		a.AM_Btn.click();

		Thread.sleep(500);
		a.OK_TimePickerBtn.click();

		driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[3]/div[3]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button")).click();

		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-90deg);']")).click();
		Thread.sleep(1000);
		a.PM_Btn.click();

		Thread.sleep(500);
		a.OK_TimePickerBtn.click();

	
		
		driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[4]/div[2]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-240deg);']")).click();
		Thread.sleep(1000);
		a.PM_Btn.click();

		Thread.sleep(1000);
		a.OK_TimePickerBtn.click();

		
	
		driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[4]/div[3]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button")).click();

		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-30deg);']")).click();
		Thread.sleep(1000);
		a.PM_Btn.click();

		Thread.sleep(500);
		a.OK_TimePickerBtn.click();
	}



	public void Adding_Shift() throws Exception 
	{
		Thread.sleep(1000);
		Add_Shift.click(); 
		Thread.sleep(2000);
		WebElement ShiftName = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[5]/div/app-input/div/div/mat-form-field/div/div/div[4]/input"));
		Thread.sleep(3000);
		ShiftName.click();
		Thread.sleep(3000);
		ShiftName.sendKeys("Test1");
		WebElement OpenAt = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[5]/div[2]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button"));
		OpenAt.click();
		Availability_RestrictionTimePage a = new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-270deg);']")).click();
		Thread.sleep(1000);
		a.PM_Btn.click();

		Thread.sleep(500);
		a.OK_TimePickerBtn.click();
		Thread.sleep(1000);
		WebElement ClosedAt = driver.findElement(By.xpath("//div[@class='form-card store-hours']/div[5]/div/div[2]/div/app-input-table/div/div[4]/div[2]/app-time-picker/div/app-input/div/div/mat-form-field/div/div[1]/div[5]/div/ngx-material-timepicker-toggle/button"));
		ClosedAt.click();
		Availability_RestrictionTimePage a1 = new Availability_RestrictionTimePage(driver, test);

		Thread.sleep(500);
		driver.findElement(By.xpath("//span[@style='transform: rotateZ(-300deg);']")).click();
		Thread.sleep(1000);
		a.PM_Btn.click();

		Thread.sleep(500);
		a.OK_TimePickerBtn.click();



	}
	public void Delete() throws Exception 
	{
		Delete.click();
		Common_XPaths cmp = new Common_XPaths(driver, test);
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		Thread.sleep(2000);
		cmp.Click_DeleteButton();
		
		
	}


	public void Update() {
//		Utility ut = new Utility();
//		Common_XPaths cmp = new Common_XPaths(driver, test);
		Update.click();
//		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
// 		{
// 			test.log(LogStatus.PASS, "Store hours updated");
//
// 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
// 		}
// 		else
// 		{
// 			test.log(LogStatus.FAIL, "Store hours updation failed");
//
// 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
// 		}	
	}



}
