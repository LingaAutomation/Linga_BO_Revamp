package com.Pages;

import java.util.ArrayList;
import java.util.List;

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

public class Settings_WaitList_Page extends BasePage
{
	public SelfHealingDriver driver;
	public ExtentTest test;

	public Settings_WaitList_Page(SelfHealingDriver driver,ExtentTest test)
	{
//		this.driver=driver;
//		this.test=test;
		super(driver, test);

		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[@mattooltip='Settings']")
	WebElement Settings;
	
	@FindBy(xpath = "//span[.='Wait List']")
	WebElement waitlist;
	
	@FindBy(xpath = "//button[.='WAIT LIST ']")
	WebElement New_Waitlist_button;
	
	@FindBy(xpath = "//app-new-wait-list//form/div/div/div/div/div[1]/div/div/app-input/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Min_Seat;
	
	@FindBy(xpath = "//app-new-wait-list//form/div/div/div/div/div[2]/div/div/app-input/div/div/mat-form-field/div/div/div[4]/input")
	WebElement Max_Seat;
	
	@FindBy(xpath = "//p[.='Enter more than 0 value']")
	WebElement Min_Seat_Errmsg;
	
	@FindBy(xpath = "//div[.='Please Enter maxSeat']")
	WebElement Max_Seat_Errmsg;
	
	@FindBy(xpath = "//app-selectbox[@name='hours']/div/mat-form-field/div/div/div[4]")
	WebElement hours_dropdown;
	
	@FindBy(xpath = "//app-selectbox[@name='minutes']/div/mat-form-field/div/div/div[4]")
	WebElement minutes_dropdown;
	
	@FindBy(xpath = "//select-option[contains(.,'00')]")
	WebElement Time_Zero;
	
	@FindBy(xpath = "//div[contains(.,'min')]")
	WebElement minutes;
	
	@FindBy(xpath = "//select-option[contains(.,'02')]")
	WebElement Two_hours;
	
	@FindBy(xpath = "//select-option[contains(.,'01')]")
	WebElement one_hour;
	
	@FindBy(xpath = "//select-option[contains(.,'10')]")
	WebElement Ten_minutes;
	
	@FindBy(xpath = "//select-option[contains(.,'05')]")
	WebElement Five_minutes;
	
	 @FindBy(xpath = "//input[contains(@data-placeholder,'Search')]")
	 WebElement Search;
	 
     @FindBy(xpath = "//td/div/div/button")
     WebElement delete;

	 @FindBy(xpath = "//span[.=' Rows per page: ']/../../div[2]/app-selectbox/div/mat-form-field/div/div/div[3]/input")
	 WebElement Rows_Per_Page;
	 
	 @FindBy(xpath = "//div[.=' 10 ']")
	 WebElement Rows10;
	 
	 @FindBy(xpath = "//div[.=' 5 ']")
	 WebElement Rows5;
	 
	 @FindBy(xpath = "//mat-icon[.='keyboard_arrow_right']")
	 WebElement Right_Arrow;
	 
	 @FindBy(xpath = "//mat-icon[.='keyboard_arrow_left']")
	 WebElement Left_Arrow;
	 
	 @FindBy(xpath = "//span[.=' Min Seat ']")
	 WebElement Min_Seat_button;
	 
	 @FindBy(xpath = "//span[.=' Max Seat ']")
	 WebElement Max_Seat_button;
	 
	 @FindBy(xpath = "//span[.=' Occupied Time ']")
	 WebElement occupied_time;
	 
	 @FindBy(xpath = "//div[.='REASONS']")
	 WebElement reason;
	 
	 @FindBy(xpath = "//button[.=' NEW REASON ']")
	 WebElement New_Reason;
	 
	 @FindBy(xpath = "//app-input[@type='textarea']/div/div/mat-form-field/div/div/div[4]/textarea")
	 WebElement Reason_Textbox;
	 
	 @FindBy(xpath = "//p[@class='color-red']")
	 WebElement Reason_Error;
	 
	 @FindBy(xpath = "//span[.='occupied@123 ']/../../div[2]")
	 WebElement delete_Reason;
	 
	 @FindBy(xpath = "//span[.=' Reason ']")
	 WebElement Reason_button;
	 
	 @FindBy(xpath = "//span[.=' Cancel ']")
	 WebElement Cancel_button;
	 
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
		
		@FindBy(xpath =  "//p[.='Name already exist ']")
		WebElement NameAlredyExist;
	
	public void Click_Settings() 
	{
		Settings.click();
	}
	public void Click_WaitList()
	{
		waitlist.click();
	}
	public void New_WaitList() 
	{
		New_Waitlist_button.click();
	}
	public WebElement Max_Seat_Err()
	{
		return Max_Seat_Errmsg;
	}
	public WebElement Min_Seat_Err() 
	{
		return Min_Seat_Errmsg;
	}
	public WebElement Reason_ErrMsg() 
	{
		return Reason_Error;
	}
	
	public void Not_Entering_Min_seat() throws Exception
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//app-input[@name='minSeat']/div/div/div/button[2]")).click();
		
	}
	public void Not_Entering_Max_seat() throws Exception 
	{
		Thread.sleep(2000);
		driver.findElement(By.xpath("//app-input[@name='maxSeat']/div/div/div/button[2]")).click();
	}
	public void Entering_Invalid_time() throws Exception 
	{
		Min_Seat.clear();
		Thread.sleep(1000);
		Min_Seat.sendKeys("9");
		Thread.sleep(1000);
		Max_Seat.clear();
		Thread.sleep(1000);
		Max_Seat.sendKeys("11");
		Thread.sleep(1000);
		hours_dropdown.click();
		Thread.sleep(1000);
		Time_Zero.click();
		Thread.sleep(1000);
		minutes_dropdown.click();
		Thread.sleep(1000);
		Time_Zero.click();
		
	}
	public void Entering_More_Min_Time() throws Exception 
	{
		Min_Seat.clear();
		Thread.sleep(1000);
		Min_Seat.sendKeys("9");
		Thread.sleep(1000);
		Max_Seat.clear();
		Thread.sleep(1000);
		Max_Seat.sendKeys("7");
		Thread.sleep(1000);
		hours_dropdown.click();
		Thread.sleep(1000);
		Two_hours.click();
		Thread.sleep(1000);
		minutes_dropdown.click();
		Thread.sleep(1000);
		Ten_minutes.click();
	}
	public void Entering_Duplicate_Seat() throws Exception
	{

		Min_Seat.clear();
		Thread.sleep(1000);
		Min_Seat.sendKeys("5");
		Thread.sleep(1000);
		Max_Seat.clear();
		Thread.sleep(1000);
		Max_Seat.sendKeys("5");
		Thread.sleep(1000);
		hours_dropdown.click();
		Thread.sleep(1000);
		Two_hours.click();
		Thread.sleep(1000);
		minutes_dropdown.click();
		Thread.sleep(1000);
		Ten_minutes.click();
	}
	public void WaitList() throws Exception
	{
		Min_Seat.clear();
		Thread.sleep(1000);
		Min_Seat.sendKeys("3345");
		Thread.sleep(1000);
		Max_Seat.clear();
		Thread.sleep(1000);
		Max_Seat.sendKeys("3346");
		Thread.sleep(1000);
		hours_dropdown.click();
		Thread.sleep(1000);
		one_hour.click();
		Thread.sleep(1000);
		minutes_dropdown.click();
		Thread.sleep(1000);
		Five_minutes.click();
	}
	public void Search() throws Exception 
	{
		//Common_XPaths cmp = new Common_XPaths(driver, test);
		Utility ut = new Utility();
	    Search.clear();
	    Thread.sleep(1000);
	    Search.sendKeys("3345");
	    Thread.sleep(1000);
	    try {
	    if(driver.findElement(By.xpath("//span[contains(.,'3345')]")).isDisplayed())
	    {

			test.log(LogStatus.PASS, "Search done successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
	    }
	   
	    }
	    catch (Exception e) 
	    {
	    	test.log(LogStatus.FAIL, "Search not done successfully");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			System.out.println("Search option not working in wait list");
		}
	    Search.clear();
	}
	public void Delete() throws Exception 
	{
		Common_XPaths cmp = new Common_XPaths(driver, test);
		Utility ut = new Utility();
		for(int i=1;i<=4;i++)
		{
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		}
	    Search.clear();
	    Thread.sleep(1000);
	    Search.sendKeys("3345");
	    Thread.sleep(1000);
		
		/*
		 * Right_Arrow.click(); Thread.sleep(1000); for(int i=1;i<=4;i++) {
		 * driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN); }
		 */
		delete.click();
		Thread.sleep(1000);
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
	     Thread.sleep(2000);
	     Cancel_button.click();
		 Thread.sleep(1000);
		 delete.click();
		 cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
	     Thread.sleep(2000);
		 cmp.Click_DeleteButton();Thread.sleep(2000);
		 if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Wait List Removed Successfully"))
	 		{
	 			test.log(LogStatus.PASS, "Wait List Deleted successfully");

	 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
	 		}
	 		else
	 		{
	 			test.log(LogStatus.FAIL, "Wait List Deletion failed");

	 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
	 		}
		 Thread.sleep(1000);
		// Left_Arrow.click();
		
	   }

	public void paginationValidations() throws Exception {
		
		//get the total number of pages
		List<WebElement> s = driver.findElements(By.xpath("//div[@class='col-auto ng-star-inserted']/button[contains(@class,'page-button')]"));
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		Thread.sleep(3000);
		
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

	
	 public void Sorting_MinSeat() throws Exception 
	 {
		 //Common_XPaths cmp= new Common_XPaths(driver, test);
		 Utility ut = new Utility();

		 for(int i=1;i<=6;i++)
			{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
			}
		 ArrayList<String> ArLst=new ArrayList<String>();
		 List<WebElement> Before_sort = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
		
		for(WebElement Min_Seat_Beforesort : Before_sort)
		{
			ArLst.add(Min_Seat_Beforesort.getText());
		}
		System.out.println(ArLst);
		
		Min_Seat_button.click();
		Thread.sleep(2000);
		Min_Seat_button.click();
		 ArrayList<String> Sorted_List =new ArrayList<String>();
		 List<WebElement> After_Sort = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
		
		for(WebElement Min_Seat_Aftersort:After_Sort) 
		{
			Sorted_List.add(Min_Seat_Aftersort.getText());
		}
		System.out.println(Sorted_List);
		
		if(ArLst == Sorted_List)
		{
			System.out.println("Sorting is not done successfully");
			test.log(LogStatus.PASS, "Sorting done successfully for Min seat");
		}
		else 
		{
			test.log(LogStatus.FAIL, "Sorting not working for Min seat");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
	 }
	 public void Sorting_MaxSeat() throws Exception 
	 {
		 //Common_XPaths cmp= new Common_XPaths(driver, test);
		 Utility ut = new Utility();

		 for(int i=1;i<=6;i++)
			{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
			}
		 ArrayList<String> ArLst=new ArrayList<String>();
		 List<WebElement> Before_sort = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[2]"));
		
		for(WebElement Min_Seat_Beforesort : Before_sort)
		{
			ArLst.add(Min_Seat_Beforesort.getText());
		}
		System.out.println(ArLst);
		
		Max_Seat_button.click();
		Thread.sleep(2000);
		Max_Seat_button.click();
		 ArrayList<String> Sorted_List =new ArrayList<String>();
		 List<WebElement> After_Sort = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[2]"));
		
		for(WebElement Min_Seat_Aftersort:After_Sort) 
		{
			Sorted_List.add(Min_Seat_Aftersort.getText());
		}
		System.out.println(Sorted_List);
		
		if(ArLst == Sorted_List)
		{
			System.out.println("Sorting is not done successfully");
			test.log(LogStatus.PASS, "Sorting done successfully for Max seat");
		}
		else 
		{
			test.log(LogStatus.FAIL, "Sorting not working for Max seat");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
	 }
	 public void Sorting_OccupiedTime() throws Exception 
	 {
		 //Common_XPaths cmp= new Common_XPaths(driver, test);
		 Utility ut = new Utility();

		 for(int i=1;i<=6;i++)
			{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
			}
		 ArrayList<String> ArLst=new ArrayList<String>();
		 List<WebElement> Before_sort = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[3]"));
		
		for(WebElement Min_Seat_Beforesort : Before_sort)
		{
			ArLst.add(Min_Seat_Beforesort.getText());
		}
		System.out.println(ArLst);
		
		occupied_time.click();
		Thread.sleep(2000);
		occupied_time.click();
		 ArrayList<String> Sorted_List =new ArrayList<String>();
		 List<WebElement> After_Sort = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[3]"));
		
		for(WebElement Min_Seat_Aftersort:After_Sort) 
		{
			Sorted_List.add(Min_Seat_Aftersort.getText());
		}
		System.out.println(Sorted_List);
		
		if(ArLst == Sorted_List)
		{
			System.out.println("Sorting is not done successfully");
			test.log(LogStatus.PASS, "Sorting done successfully for occupied time");
		}
		else 
		{
			test.log(LogStatus.FAIL, "Sorting not working for occupied time");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
	 }
	 
	 //navigating reasons
	 public void clicking_Reason() throws Exception
	 {
		 Thread.sleep(5000);for(int i =1; i<=20;i++) {driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);}Thread.sleep(5000);
		reason.click();
	 }
	 public String sas;
	 public void New_Reason() 
	 {
		 sas = driver.findElement(By.xpath("//data-grid-row/div/div/span")).getText().trim();
		 New_Reason.click();
	 }
	 public void Entering_Existing_Reason() throws Exception 
	 {
		 Common_XPaths cmp = new Common_XPaths(driver, test);
		 Utility ut = new Utility();
		 Reason_Textbox.clear();
		 Thread.sleep(1000);
		 Reason_Textbox.sendKeys(sas);
		 Thread.sleep(1000);
		 
		 if(NameAlredyExist.isDisplayed()) {
			 test.log(LogStatus.PASS, "Name already exist field validation is available when user enter the existing name in Reason Name field");
			 ut.PassedCaptureScreenshotAsBASE64(driver, test);
		 }
		 else {
			 test.log(LogStatus.FAIL, "Name already exist field validation is not available when user enter the existing name in Reason Name field");
			 ut.FailedCaptureScreenshotAsBASE64(driver, test);
		 }
			/*
			 * 
			 * cmp.Click_SaveButton(); if(cmp.ConfirmationAlertMsg().getText().
			 * equalsIgnoreCase("waitListReason already exist")) { test.log(LogStatus.PASS,
			 * "Wait List Reason already exist");
			 * 
			 * ut.PassedCaptureScreenshotAsBASE64(driver, test); } else {
			 * test.log(LogStatus.FAIL, "Wait List Reason saving failed");
			 * 
			 * ut.FailedCaptureScreenshotAsBASE64(driver, test); } Thread.sleep(2000);
			 */
		 Thread.sleep(3000);
		 cmp.Click_CloseButton();
		 
	 }
	 public void Capturing_Reason_Error() throws Exception 
	 {
		 //System.out.println("sssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss");
		 Reason_Textbox.clear();
		 Thread.sleep(1000);
		 Reason_Textbox.sendKeys(sas + "111");
		 Reason_Textbox.clear();
	 }
	 public void Search_Delete_Reason() throws Exception 
	 {
		 Common_XPaths cmp = new Common_XPaths(driver, test);
		 Utility ut = new Utility();
		Search.clear(); 
		Thread.sleep(1000);
		Search.sendKeys("oc");
		Search.clear(); 
		Search.sendKeys("occu");Thread.sleep(3000);
		delete_Reason.click();
		Thread.sleep(3000);
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
	     Thread.sleep(2000);
	     Cancel_button.click();
		 Thread.sleep(2000);
		 delete_Reason.click();
		 cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
	     Thread.sleep(2000);
		 cmp.Click_DeleteButton();Thread.sleep(2000);
		 if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Wait List Reason Removed Successfully"))
	 		{
	 			test.log(LogStatus.PASS, "Wait List Reason Deleted successfully");

	 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
	 		}
	 		else
	 		{
	 			test.log(LogStatus.FAIL, "Wait List Reason Deletion failed");

	 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
	 		}
		 Search.clear();
	 }
	 public void Creating_New_Reason() throws Exception 
	 {
		 Reason_Textbox.clear();
		 Thread.sleep(1000);
		 Reason_Textbox.sendKeys("occupied@123");
		 Thread.sleep(1000);
	 }
	 public void Creating_New_Reason1() throws Exception 
	 {
		 Reason_Textbox.clear();
		 Thread.sleep(1000);
		 Reason_Textbox.sendKeys("occupied@123");
		 Thread.sleep(1000);
		 for(int i = 1;i <=20 ; i++) {Reason_Textbox.sendKeys(Keys.BACK_SPACE);}
		 Thread.sleep(1000);
	 }
	 public void Sorting_Reasons() throws Exception 
	 {
		 //Common_XPaths cmp= new Common_XPaths(driver, test);
		 Utility ut = new Utility();

		 for(int i=1;i<=6;i++)
			{
			driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
			}
		 ArrayList<String> ArLst=new ArrayList<String>();
		 List<WebElement> Before_sort = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div"));
		
		for(WebElement Min_Seat_Beforesort : Before_sort)
		{
			ArLst.add(Min_Seat_Beforesort.getText());
		}
		System.out.println(ArLst);
		
		Reason_button.click();
		Thread.sleep(2000);
		Reason_button.click();
		 ArrayList<String> Sorted_List =new ArrayList<String>();
		 List<WebElement> After_Sort = driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div"));
		
		for(WebElement Min_Seat_Aftersort:After_Sort) 
		{
			Sorted_List.add(Min_Seat_Aftersort.getText());
		}
		System.out.println(Sorted_List);
		
		if(ArLst == Sorted_List)
		{
			System.out.println("Sorting is not done successfully");
			test.log(LogStatus.PASS, "Sorting done successfully for wait list reasons");
		}
		else 
		{
			test.log(LogStatus.FAIL, "Sorting is not working for wait list reasons");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
	 }
}
