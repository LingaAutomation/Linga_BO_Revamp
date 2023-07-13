package com.Pages;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.collections4.functors.CatchAndRethrowClosure;
import org.openqa.selenium.By;
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

public class InventoryReport_Consumption_LogPage {
	
	public WebDriver driver;
	public ExtentTest test;
	Utility ut=new Utility();
	WebDriverWait wait;
	Common_XPaths cmp;
	
	TaxesPage tx;
	public InventoryReport_Consumption_LogPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//label[contains(.,'Type ')]/../../input)[1]")
	WebElement Type_InputBx;
	@FindBy(xpath = "//button/span[contains(.,' EXPORT')]/..")
	WebElement Export_Bx;
	
	
	
	@FindBy(xpath = "//label[contains(.,'Consumption Type ')]/../../input")
	WebElement Consumption_Type_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Category Level')]/../../input")
	WebElement Category_Level_InputBx;
	
	
	
	
			
			@FindBy(xpath = "(//label[contains(.,'Category ')]/../../input)[2]")
			WebElement Category_InputBx; 
			
			@FindBy(xpath = "(//label[contains(.,'Category ')]/../../input)[3]")
			WebElement SubCategory_InputBx; 
			
			
			
			@FindBy(xpath = "//label[contains(.,' Sub Recipe ')]/../../input")
			WebElement SubRecipe_InputBx;
			
	@FindBy(xpath = "//label[contains(.,'Sub Category')]/../../input")
	WebElement Sub_Category_Level_InputBx;
	
	
	@FindBy(xpath = "//label[contains(.,'Inventory Item')]/../../input")
	WebElement InventoryItem_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Time Period')]/../../input")
	WebElement Time_PeriodInputBx;
	
	@FindBy(xpath = "//select-option[contains(.,'Today')]")
	WebElement Today_TimePeriodBtn;
	
	@FindBy(xpath = "//select-option[contains(.,'Yesterday')]")
	WebElement Yesterday_TimePeriodBtn;
	
	@FindBy(xpath = "//select-option[contains(.,'Last N days')]")
	WebElement Last_N_days_TimePeriodBtn;
	
	
			
			@FindBy(xpath = "(//label[contains(.,'Category ')]/../../input)[2]")
			WebElement category_Input_Btn;
	
	
	
	@FindBy(xpath = "//button[contains(.,'APPLY')]")
	WebElement Apply_Btn;
	
	@FindBy(xpath = "//span[contains(@class,'no-data-title')][contains(.,'No consumption log for selected time period')]")
	WebElement No_consumption_log_for_selected_time_period_InfoMsg;
	

	
	@FindBy(xpath = "//label[contains(.,'Days')]/../../input")
	WebElement Days_NdaysInputBx;
	
	@FindBy(xpath = "//select-option[contains(.,'This week')]")
	WebElement This_Week_TimePeriodBtn;
	
	@FindBy(xpath = "//select-option[contains(.,'Last week')]")
	WebElement Last_Week_TimePeriodBtn;
	
	@FindBy(xpath = "//select-option[contains(.,'Last 7 days')]")
	WebElement Last_7_Days_TimePeriodBtn;
	
	@FindBy(xpath = "//select-option[contains(.,'This month')]")
	WebElement This_Month_TimePeriodBtn;
	
	@FindBy(xpath = "//select-option[contains(.,'Last month')]")
	WebElement Last_Month_TimePeriodBtn;
	
	@FindBy(xpath = "//select-option[contains(.,'Last 30 days')]")
	WebElement Last_30_Days_TimePeriodBtn;
	
	@FindBy(xpath = "//select-option[contains(.,'Specific date')]")
	WebElement Specific_Date_TimePeriodBtn;
	
	@FindBy(xpath = "//label[contains(.,'Date')]/../../..//mat-datepicker-toggle/button")
	WebElement Date_inSpecificDateInputBx;
	
	@FindBy(xpath = "//select-option[contains(.,'Date range')]")
	WebElement Date_Range_TimePeriodBtn;
	
	@FindBy(xpath = "//label[contains(.,'Start Date')]/../../..//mat-datepicker-toggle/button")
	WebElement Start_DateInputBx;
	
	@FindBy(xpath = "//label[contains(.,'End Date')]/../../..//mat-datepicker-toggle/button")
	WebElement End_DateInputBx;
	
	
	public void Verify_ReportHomePage(String str)
	{
		if(driver.findElement(By.xpath("//a[contains(@class,'mat-tab-label-active')][contains(.,'"+str+"')]")).isDisplayed())
		{
			test.log(LogStatus.PASS, str+" Report Page Loaded Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.PASS, str+" Report Page Loading Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	public void Click_ApplyButton()
	{
		Apply_Btn.click();
	}
	
	
	public void Click_Export_Bx()
	{
		Export_Bx.click();
	}
	
	
	
	
	public WebElement No_consumption_log_for_selected_time_period_InfoMsg()
	{
		return No_consumption_log_for_selected_time_period_InfoMsg;
	}
	
	
	


	public void Select_Today_TimePeriod() throws InterruptedException
	{
		Thread.sleep(1000);
		Time_PeriodInputBx.click();
		Thread.sleep(1000);
		Today_TimePeriodBtn.click();
	}
	
	public void Select_Yesterday_TimePeriod() throws Exception
	{
		Thread.sleep(1000);
		Time_PeriodInputBx.click();
		Thread.sleep(1500);
		Yesterday_TimePeriodBtn.click();
	}
	
	public void Select_Last_N_Days_TimePeriod(String NoOfDays) throws Exception
	{
		Thread.sleep(1000);
		Time_PeriodInputBx.click();
		Thread.sleep(1000);
		Last_N_days_TimePeriodBtn.click();
		
		Thread.sleep(1000);
		Days_NdaysInputBx.clear();
		Thread.sleep(500);
		Days_NdaysInputBx.sendKeys(NoOfDays);
		
		test.log(LogStatus.INFO, "The number days are(is) : "+Utility.getProperty("NumberOfDays"));
	}
	
	public void Select_This_Week_TimePeriod() throws Exception
	{
		Thread.sleep(1000);
		Time_PeriodInputBx.click();
		Thread.sleep(1000);
		This_Week_TimePeriodBtn.click();
	}
	
	public void Select_Last_Week_TimePeriod() throws Exception
	{
		Thread.sleep(1000);
		Time_PeriodInputBx.click();
		Thread.sleep(1000);
		Last_Week_TimePeriodBtn.click();
	}
	
	public void Select_Last_7_Days_TimePeriod() throws Exception
	{
		Thread.sleep(1000);
		Time_PeriodInputBx.click();
		Thread.sleep(1000);
		Last_7_Days_TimePeriodBtn.click();
	}
	
	public void Select_This_Month_TimePeriod() throws Exception
	{
		Thread.sleep(1000);
		Time_PeriodInputBx.click();
		Thread.sleep(1000);
		This_Month_TimePeriodBtn.click();
	}
	
	public void Select_Last_Month_TimePeriod() throws Exception
	{
		Thread.sleep(1000);
		Time_PeriodInputBx.click();
		Thread.sleep(1000);
		Last_Month_TimePeriodBtn.click();
	}
	
	public void Select_Last_30_Days_TimePeriod() throws Exception
	{
		Thread.sleep(1000);
		Time_PeriodInputBx.click();
		Thread.sleep(1000);
		Last_30_Days_TimePeriodBtn.click();
	}
	
	@FindBy(xpath = "//button[@aria-label='Choose month and year']")
	WebElement monthAndYear_Calender;
	
	public void Select_Specific_Date_TimePeriod(String SpecificDate) throws Exception
	{
		Thread.sleep(1000); 
		Time_PeriodInputBx.click();
		Thread.sleep(1000);
		Specific_Date_TimePeriodBtn.click();
		
		Thread.sleep(1000);
//		Date_inSpecificDateInputBx.clear();
		Thread.sleep(500);
//		Date_inSpecificDateInputBx.sendKeys(SpecificDate);
		
		Thread.sleep(1000);
		Date_inSpecificDateInputBx.click();
		Thread.sleep(500);
		monthAndYear_Calender.click();
		String year = SpecificDate.substring(6,10);
		driver.findElement(By.xpath("//div[contains(.,'"+year+"') and contains(@class,'mat-calendar-body-today')]")).click();
		String months = SpecificDate.substring(3,5);
		String month = selectMonth(months);
		driver.findElement(By.xpath("//div[contains(.,'"+month+"') and contains(@class,'mat-calendar-body')]")).click();
		String days = SpecificDate.substring(0,2);
		String day = selectDate(days);
		driver.findElement(By.xpath("//div[contains(.,'"+day+"') and contains(@class,'mat-calendar-body')]")).click();
		//Date_inSpecificDateInputBx.clear();
		Thread.sleep(500);
		//Date_inSpecificDateInputBx.sendKeys(SpecificDate);
		
		test.log(LogStatus.INFO, "The specific date is : "+Utility.getProperty("Report_Specific_Date"));
	}
	
	public String selectDate(String day) 
	{
		if(day.equals("01")) 
		{
		day = " 1 ";
		}
		else if(day.equals("02")) 
		{
		day = " 2 ";
		}
		else if(day.equals("03")) 
		{
		day = " 3 ";
		}
		else if(day.equals("04")) 
		{
		day = " 4 ";
		}
		else if(day.equals("05")) 
		{
		day = " 5 ";
		}
		else if(day.equals("06")) 
		{
		day = " 6 ";
		}
		else if(day.equals("07")) 
		{
		day = " 7 ";
		}
		else if(day.equals("08")) 
		{
		day = " 8 ";
		}
		else if(day.equals("09")) 
		{
		day = " 9 ";
		}
		return day;
	}
		public String selectMonth(String month) 
		{
		if(month.equals("01")) 
		{
		month = "JAN";
		}
		else if(month.equals("02")) 
		{
		month = "FEB";
		}
		else if(month.equals("03")) 
		{
		month = "MAR";
		}
		else if(month.equals("04")) 
		{
		month = "APR";
		}
		else if(month.equals("05")) 
		{
		month = "MAY";
		}
		else if(month.equals("06")) 
		{
		month = "JUN";
		}
		else if(month.equals("07")) 
		{
		month = "JUL";
		}
		else if(month.equals("08")) 
		{
		month = "AUG";
		}
		else if(month.equals("09")) 
		{
		month = "SEP";
		}
		else if(month.equals("10")) 
		{
		month = "OCT";
		}
		else if(month.equals("11")) 
		{
		month = "NOV";
		}
		else if(month.equals("12")) 
		{
		month = "DEC";
		}
		return month;
		
		
	}
	
	public void Select_Date_Range_TimePeriod(String FromDate, String ToDate) throws Exception
	{
		Thread.sleep(1000);
		Time_PeriodInputBx.click();
		Thread.sleep(1000);
		Date_Range_TimePeriodBtn.click();
		
//		Thread.sleep(1000);
//		Start_DateInputBx.clear();
//		Thread.sleep(500);
//		Start_DateInputBx.sendKeys(FromDate);
//		
//		Thread.sleep(1000);
//		End_DateInputBx.clear();
//		Thread.sleep(500);
//		End_DateInputBx.sendKeys(ToDate);
		
		
		 Thread.sleep(1000);
		 Start_DateInputBx.click();
		 Thread.sleep(500);
		 monthAndYear_Calender.click();
		 String year = FromDate.substring(6,10);
		 driver.findElement(By.xpath("//div[contains(.,'"+year+"') and contains(@class,'mat-calendar-body-today')]")).click();
		 String months = FromDate.substring(3,5);
		 String month = selectMonth(months);
		 driver.findElement(By.xpath("//div[contains(.,'"+month+"') and contains(@class,'mat-calendar-body')]")).click();
		 String days = FromDate.substring(0,2);
		 String day = selectDate(days);
		 driver.findElement(By.xpath("//div[contains(.,'"+day+"') and contains(@class,'mat-calendar-body')]")).click();
		 //Date_inSpecificDateInputBx.clear();
		 Thread.sleep(500);
		 //Start_DateInputBx.sendKeys(FromDate);
		 Thread.sleep(1000);
		 End_DateInputBx.click();
		 Thread.sleep(500);
		 monthAndYear_Calender.click();
		 String year1 = ToDate.substring(6,10);
		 driver.findElement(By.xpath("//div[contains(.,'"+year1+"') and contains(@class,'mat-calendar-body-today')]")).click();
		 String months1 = ToDate.substring(3,5);
		 String month1 = selectMonth(months1);
		 driver.findElement(By.xpath("//div[contains(.,'"+month1+"') and contains(@class,'mat-calendar-body')]")).click();
		 String days1 = ToDate.substring(0,2);
		 String day1 = selectDate(days1);
		 driver.findElement(By.xpath("//div[contains(.,'"+day1+"') and contains(@class,'mat-calendar-body')]")).click();
		 Thread.sleep(500);
		 
		 test.log(LogStatus.INFO, "The start date and end date are : "+Utility.getProperty("Report_Start_Date")+" and "+Utility.getProperty("Report_End_Date"));
		 
	}
	
	@FindBy(xpath = "//pagination/div/div/div/button")
	WebElement Pagination_btns;
	
	public void Do_Pagination()
	{
		try
		{
		if(Pagination_btns.isDisplayed())
		{
			List<WebElement> pagesList=driver.findElements(By.xpath("//pagination/div/div/div/button"));
			
			int pagesSize=pagesList.size()-1;
			
			driver.findElement(By.xpath("//pagination/div/div/div["+pagesSize+"]/button")).click();
		}
		}
		catch(Exception h) {}
	}
	
	public void Select_type_All() throws InterruptedException
	{
		Thread.sleep(1000);
		Type_InputBx.click();
		Thread.sleep(1000);
        driver.findElement(By.xpath("//select-option/div/div/div[contains(.,'ALL')]")).click();
	}
	
	public void Select_type_Inventory_Item() throws InterruptedException
	{
		Thread.sleep(1000);
		Type_InputBx.click();
		Thread.sleep(1000);
        driver.findElement(By.xpath("//select-option/div/div/div[contains(.,' Inventory Item ')]")).click();
	}

	public void Select_type_Retail_Item() throws InterruptedException
	{
		Thread.sleep(1000);
		Type_InputBx.click();
		Thread.sleep(1000);
        driver.findElement(By.xpath("//select-option/div/div/div[contains(.,' Retail Item')]")).click();
	}
	
	public void Select_type_SubRecipe () throws InterruptedException
	{
		Thread.sleep(1000);
		Type_InputBx.click();
		Thread.sleep(1000);
        driver.findElement(By.xpath("//select-option/div/div/div[contains(.,'Sub Recipe')]")).click();
	}
	
	public void Select_type_MenuItem () throws InterruptedException
	{
		Thread.sleep(1000);
		Type_InputBx.click();
		Thread.sleep(1000);
        driver.findElement(By.xpath("//select-option/div/div/div[contains(.,'Menu Item')]")).click();
	}
	
	public void Select_ConsumptionType_All() throws InterruptedException
	{
		Thread.sleep(1000);
		Consumption_Type_InputBx.click();
		Thread.sleep(1000);
        driver.findElement(By.xpath("//select-option/div/div/div[contains(.,'ALL')]")).click();
	}
	
	
	public void Select_ConsumptionType_System() throws InterruptedException
	{
		Thread.sleep(1000);
		Consumption_Type_InputBx.click();
		Thread.sleep(1000);
        driver.findElement(By.xpath("//select-option/div/div/div[contains(.,'System')]")).click();
	}

	public void Select_ConsumptionType_Manual() throws InterruptedException
	{
		Thread.sleep(1000);
		Consumption_Type_InputBx.click();
		Thread.sleep(1000);
        driver.findElement(By.xpath("//select-option/div/div/div[contains(.,'Manual')]")).click();
	}
	
	public void Select_Category_Level_All() throws InterruptedException
	{
		Thread.sleep(1000);
		Category_Level_InputBx.click();
		Thread.sleep(1000);
        driver.findElement(By.xpath("//select-option/div/div/div[contains(.,'ALL')]")).click();
	}
	
	
	public void Select_Category_Level_Category() throws InterruptedException
	{
		Thread.sleep(1000);
		Category_Level_InputBx.click();
		Thread.sleep(1000);
        driver.findElement(By.xpath("(//select-option/div/div/div[contains(.,'Category')])[1]")).click();
	}
	
	public void Select_Category_Level_SubCategory() throws InterruptedException
	{
		Thread.sleep(1000);
		Category_Level_InputBx.click();
		Thread.sleep(1000);
        driver.findElement(By.xpath("//select-option/div/div/div[contains(.,'Sub Category')]")).click();
	}

	public void Select_ConsumptionType_SubCategory() throws InterruptedException
	{
		Thread.sleep(1000);
		Consumption_Type_InputBx.click();
		Thread.sleep(1000);
        driver.findElement(By.xpath("(//select-option/div/div/div[contains(.,'Sub Category')])[1]")).click();
	}
	
	public void Select_ConsumptionType_Category() throws InterruptedException
	{
		Thread.sleep(1000);
		Consumption_Type_InputBx.click();
		Thread.sleep(1000);
        driver.findElement(By.xpath("(//select-option/div/div/div[contains(.,'Category')])[1]")).click();
	}
	
	
	public void Select_Any_category() throws Exception
	{
		Thread.sleep(1000);
	//	Category_InputBx.click();
		Thread.sleep(1000);
       // driver.findElement(By.xpath("(//select-option/div/div/div[contains(.,'Sub Category')])[1]")).click();
	
		Thread.sleep(1000);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(DepartmentDropBtn);
		Thread.sleep(1000);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
//		DepartmentDropBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(Category_InputBx)).click();
		
		Thread.sleep(2000);
		//Tax_category_Input.click();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		//get text of tax 
		 List<WebElement> text = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
		
		 int tax = text.size();
		 
			int randomMenu=ThreadLocalRandom.current().nextInt(1, tax);
			
			//input text for tax
			
			cmp.Verify_Search(driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomMenu+"]//select-option")).getText());
			
		
		
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
	}
	
	public void Select_Any_SubRecipe() throws Exception
	{
		Thread.sleep(1000);
		SubRecipe_InputBx.click();
		Thread.sleep(1000);
    //    driver.findElement(By.xpath("(//select-option/div/div/div[contains(.,'Sub Category')])[1]")).click();
	
		Thread.sleep(1000);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(DepartmentDropBtn);
		Thread.sleep(1000);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
//		DepartmentDropBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(SubRecipe_InputBx)).click();
		
		Thread.sleep(2000);
		//Tax_category_Input.click();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		
		try {
		//get text of tax 
		 List<WebElement> text = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
		
		 int tax = text.size();
		 
			int randomMenu=ThreadLocalRandom.current().nextInt(1, tax);
			
			//input text for tax
			
			cmp.Search(driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomMenu+"]//select-option")).getText());
			
		
		
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
	}
	catch (Exception e) {

		driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
	}
	}
	public void Select_Any_Subcategory() throws Exception
	{
		
	
	
		Thread.sleep(1000);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(DepartmentDropBtn);
		Thread.sleep(1000);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
//		DepartmentDropBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(SubCategory_InputBx)).click();
		
		Thread.sleep(2000);
		//Tax_category_Input.click();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		//get text of tax 
		try {
		 List<WebElement> text = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
		
		 int tax = text.size();
		 
			int randomMenu=ThreadLocalRandom.current().nextInt(1, tax);
			
			//input text for tax
			
			cmp.Search(driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomMenu+"]//select-option")).getText());
			
		
		
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
	}
		catch (Exception e) {
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
		}
	}

	public void Select_Any_inventory_Item() throws Exception
	{
		
	
	
		Thread.sleep(1000);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
//		cmp.Cursor_MoveToElement(DepartmentDropBtn);
		Thread.sleep(1000);
		 wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		
//		DepartmentDropBtn.click();
		wait.until(ExpectedConditions.elementToBeClickable(InventoryItem_InputBx)).click();
		
		Thread.sleep(2000);
		//Tax_category_Input.click();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(2000);
		try {
		//get text of tax 
		 List<WebElement> text = driver.findElements(By.xpath("//cdk-virtual-scroll-viewport/div/div/select-option/div/div"));
		
		 int tax = text.size();
		 
			int randomMenu=ThreadLocalRandom.current().nextInt(1, tax);
			
			//input text for tax
			
			cmp.Verify_Search(driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomMenu+"]//select-option")).getText());
			
		
		
			driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
	}
	catch (Exception e) {
		driver.findElement(By.xpath("//cdk-virtual-scroll-viewport/div/div[1]/select-option/div/div")).click();
	}
	}
}
