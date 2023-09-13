package com.Pages;

import java.awt.Robot;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

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

public class ReportsPage 
{

	public WebDriver driver;
	public ExtentTest test;
	Utility ut=new Utility();
	Common_XPaths cmp;
	
	TaxesPage tx;
	public ReportsPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//label[contains(.,'Department')]/../../input")
	WebElement Department_ReportInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Time Period')]/../../input")
	WebElement Time_PeriodInputBx;
	
	@FindBy(xpath = "//select-option[contains(.,'Today')]")
	WebElement Today_TimePeriodBtn;
	
	@FindBy(xpath = "//select-option[contains(.,'Yesterday')]")
	WebElement Yesterday_TimePeriodBtn;
	
	@FindBy(xpath = "//select-option[contains(.,'Last N days')]")
	WebElement Last_N_days_TimePeriodBtn;
	
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
	
	@FindBy(xpath = "//td[contains(.,'No transaction for selected time period')]")
	WebElement No_TransactionFound_InfoMsg;
	
	@FindBy(xpath = "//button[contains(.,'APPLY')]")
	WebElement Apply_Btn;
	
	@FindBy(xpath = "//label[contains(.,'Level')]/../../input")
	WebElement Level_InputBx;
	
	@FindBy(xpath = "//select-option[contains(.,'Bars')]")
	WebElement Bars_ChartOption;
	
	
	@FindBy(xpath = "//select-option[contains(.,'Donut')]")
	WebElement Donut_ChartOption;
	
	
	@FindBy(xpath = "//app-combo-line-chart")
	WebElement Bars_ChartScreen;
	
	
	@FindBy(xpath = "//app-donut-chart")
	WebElement Donut_ChartScreen;
	
	
	@FindBy(xpath = "//app-line-chart")
	WebElement Sales_byHours_ChartScreen;
	
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
	
	
	
	
	
	public WebElement No_TransactionFound_InfoMessage()
	{
		return No_TransactionFound_InfoMsg;
	}
	
	@FindBy(xpath = "//span[contains(.,'No Purchased Items records for the selected time period')]")
	WebElement No_Purchase_ItemForund_InfoMsg;
	
	public WebElement No_Purchase_ItemForund_InfoMessage()
	{
		return No_Purchase_ItemForund_InfoMsg;
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
		
		WebElement Sel=driver.findElement(By.xpath("//div[@class='option-list']/div/cdk-virtual-scroll-viewport/div[1]/div[9]"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
       
        je.executeScript("arguments[0].scrollIntoView(true);",Sel);
        
        Thread.sleep(2000);
        driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
        
		Thread.sleep(2000);
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
		
		WebElement Sel=driver.findElement(By.xpath("//div[@class='option-list']/div/cdk-virtual-scroll-viewport/div[1]/div[9]"));
		JavascriptExecutor je = (JavascriptExecutor) driver;
       
        je.executeScript("arguments[0].scrollIntoView(true);",Sel);
        
        Thread.sleep(2000);
        driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		
		Thread.sleep(2000);
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
	
	
	
	public WebElement Sale_NetSales_Amount_SaleReport()
	{
		List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
		
		return driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[2]/span"));
	}
	
	
	
	
	public WebElement Quantity_SaleReport()
	{
		List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
		
		return driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[3]/span"));
	}
	
	
	public WebElement Tax_SaleReport()
	{
		List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
		
		return driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[4]/span"));
	}
	
	public WebElement Discount_SaleReport()
	{
		List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
		
		return driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[5]/span"));
	}
	
	
	public WebElement PercentageOfSale_SaleReport()
	{
		List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
		
		return driver.findElement(By.xpath("//tbody/tr["+rowList.size()+"]/td[6]/span"));
	}
	
	
	public void Verify_Bars_Chart_Screen_TopSales() throws Exception
	{
		Thread.sleep(1000);
		Level_InputBx.click();
		
		Thread.sleep(1000);
		Bars_ChartOption.click();
		
		Thread.sleep(1000);
		if(Bars_ChartScreen.isDisplayed())
		{
			test.log(LogStatus.PASS, "Here Bars Chart Screen displays & 5 Top Sales Report available for the Required Time Period");
		}
		else
		{
			test.log(LogStatus.FAIL, "Here Here Bars Chart Screen not displays & 5 Top Sales Report not available for the Required Time Period");

		}
	}
	
	public void Verify_Donut_Chart_Screen_TopSales() throws Exception
	{
		Thread.sleep(1000);
		Level_InputBx.click();
		
		Thread.sleep(1000);
		Donut_ChartOption.click();
		
		Thread.sleep(1000);
		if(Donut_ChartScreen.isDisplayed())
		{
			test.log(LogStatus.PASS, "Here Donut Chart Screen displays & 5 Top Sales Report available for the Required Time Period");
		}
		else
		{
			test.log(LogStatus.PASS, "Here Donut Chart Screen not displays & 5 Top Sales Report not available for the Required Time Period");

		}
	}

	public void Verify_Sales_byHours_Chart_Screen() throws Exception
	{
		
		Thread.sleep(1000);
		if(Sales_byHours_ChartScreen.isDisplayed())
		{
			test.log(LogStatus.PASS, "Sales By Hours Chart Screen available for the Required Time Period");
		}
		else
		{
			test.log(LogStatus.FAIL, "Sales By Hours Chart Screen not available for the Required Time Period");

		}
	}
	

	////////////// Daily Sale Report  //////////////////
	
	
	public WebElement NetSales_Amount_DailySaleReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
//		
//		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[2]/span"));
		return driver.findElement(By.xpath("//tfoot/tr/td[2]"));
	
	}
	
	
	public WebElement Tax_DailySaleReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
//		
//		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[3]/span"));
//	
		return driver.findElement(By.xpath("//tfoot/tr/td[3]"));	}
	
	
	public WebElement Discount_DailySaleReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
//		
//		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[4]/span"));

		return driver.findElement(By.xpath("//tfoot/tr/td[4]"));	
	}
	
	public WebElement GrandSales_DailySaleReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
//		
//		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[5]/span"));
	
		return driver.findElement(By.xpath("//tfoot/tr/td[5]"));
		//p[contains(.,'TOTAL')]/../../div[5]/span
	}
	
	
	
	
	/////////////// Hourly Sale Report ////////////////////////////
	
	public WebElement NetSales_Amount_HourlySaleReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
		
//		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[3]/span"));
		return driver.findElement(By.xpath("//td[contains(.,'Total')]/../td[3]"));

		
	}
	
	
	public WebElement Tax_HourlySaleReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
//		
//		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[4]/span"));
		return driver.findElement(By.xpath("//td[contains(.,'Total')]/../td[4]"));

	
	}
	
	
	public WebElement Quantity_HourlySaleReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
//		
//		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[5]/span"));
		return driver.findElement(By.xpath("//td[contains(.,'Total')]/../td[5]"));

	
	}
	
	

	public WebElement Discount_HourlySaleReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
//		
//		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[6]/span"));
		return driver.findElement(By.xpath("//td[contains(.,'Total')]/../td[6]"));

	}
	
	
	public WebElement GrandSales_HourlySaleReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
//		
//		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[7]/span"));
	
		return driver.findElement(By.xpath("//td[contains(.,'Total')]/../td[7]"));
	}
	
	
	public WebElement No_ofCustomer_HourlySaleReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
//		
//		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[8]/span"));
		return driver.findElement(By.xpath("//td[contains(.,'Total')]/../td[8]"));
	}
	
	
	
	///////////////////////// Sale Recap Report   ///////////////////
	
	@FindBy(xpath = "//label[contains(.,'Sale Recap Type')]/../../input")
	WebElement Sale_RecapType_InputBx;
	
	@FindBy(xpath = "//select-option[contains(.,'Time Period')]")
	WebElement Time_Period_OptionBtn;
	
	@FindBy(xpath = "//td[contains(.,'Gross Sales')]/../td[2]")
	WebElement Gross_Sales_SaleRecap;
	
	@FindBy(xpath = "//td[contains(.,'Net Sales')]/../td[2]")
	WebElement Net_Sales_SaleRecap;
	
	@FindBy(xpath = "//td[contains(.,'Grand Sales')]/../td[2]")
	WebElement Grand_Sales_SaleRecap;
	
	@FindBy(xpath = "//td[contains(.,'Gross Receipt')]/../td[2]")
	WebElement Gross_Receipt_SaleRecap;
	
	@FindBy(xpath = "//td[contains(.,'Total Tax Collected')]/../td[4]")
	WebElement Tax_SaleRecap;
	
	@FindBy(xpath = "//td[contains(.,'Tax Exempted')]/../td[4]")
	WebElement Tax_Exempt_SaleRecap;
	
	@FindBy(xpath = "//td[contains(.,'Discount')]/../td[2]")
	WebElement Discount_SaleRecap;
	
	@FindBy(xpath = "//td[contains(.,'Discount Tax')]/../td[2]")
	WebElement Discount_Tax_SaleRecap;
	
	@FindBy(xpath = "//td[contains(.,'Gross Void')]/../td[2]")
	WebElement Gross_Void_SaleRecap;
	
	@FindBy(xpath = "//td[contains(.,'Net Void')]/../td[2]")
	WebElement Net_Void_SaleRecap;
	
	@FindBy(xpath = "//td[contains(.,'Rounding Off')]/../td[4]")
	WebElement Rounding_Off_SaleRecap;
	
	@FindBy(xpath = "//app-custom-dynamic-table//span[contains(.,'Refund')]/../..//td[contains(.,'Total')]/../td[2]")
	WebElement Refund_SaleRecap;
	
	@FindBy(xpath = "//app-custom-dynamic-table//span[contains(.,'SALES')]" )
	WebElement Sales_Table_inSaleRecap;
	
	@FindBy(xpath = "//app-custom-dynamic-table//span[contains(.,'TAXES')]" )
	WebElement Taxes_Table_inSaleRecap;
	
	@FindBy(xpath = "//app-custom-dynamic-table//span[contains(.,'REFUND')]" )
	WebElement Refund_Table_inSaleRecap;
	
	@FindBy(xpath = "//app-custom-dynamic-table//span[contains(.,'DISCOUNT')]" )
	WebElement Discount_Table_inSaleRecap;
	
	@FindBy(xpath = "//app-custom-dynamic-table//span[contains(.,'Sales')]" )
	WebElement Sales_Table_inEnterpriseSaleRecap;
	
	@FindBy(xpath = "//app-custom-dynamic-table//span[contains(.,'Taxes')]" )
	WebElement Taxes_Table_inEnterpriseSaleRecap;
	
	@FindBy(xpath = "//app-custom-dynamic-table//span[contains(.,'Refund')]" )
	WebElement Refund_Table_inEnterpriseSaleRecap;
	
	@FindBy(xpath = "//app-custom-dynamic-table//span[contains(.,'Discount')]" )
	WebElement Discount_Table_inEnterpriseSaleRecap;
	
	public void Select_Time_Period_Sale_Recap() throws Exception
	{
		Thread.sleep(1000);
		Sale_RecapType_InputBx.click();
		
		Thread.sleep(1000);
		Time_Period_OptionBtn.click();
	}
	
	public WebElement Net_Sales_SaleRecap()
	{
		return Net_Sales_SaleRecap;
	}
	
	public WebElement Tax_SaleRecap()
	{
		return Tax_SaleRecap;
	}
	
	public WebElement Tax_Exempt_SaleRecap()
	{
		return Tax_Exempt_SaleRecap;
	}
	
	public WebElement Discount_SaleRecap()
	{
		return Discount_SaleRecap;
	}
	
	public WebElement Discount_Tax_SaleRecap()
	{
		return Discount_Tax_SaleRecap;
	}
	
	public WebElement Grand_Sales_SaleRecap()
	{
		return Grand_Sales_SaleRecap;
	}
	
	public WebElement Gross_Receipt_SaleRecap()
	{
		return Gross_Receipt_SaleRecap;
	}
	
	public WebElement Gross_Sales_SaleRecap()
	{
		return Gross_Sales_SaleRecap;
	}
	
	
	public WebElement Gross_Void_SaleRecap()
	{
		return Gross_Void_SaleRecap;
	}
	
	public WebElement Net_Void_SaleRecap()
	{
		return Net_Void_SaleRecap;
	}
	
	
	public WebElement Rounding_Off_SaleRecap()
	{
		return Rounding_Off_SaleRecap;
	}
	
	public WebElement Refund_SaleRecap()
	{
		return Refund_SaleRecap;
	}
	
	public WebElement Sales_Table_inSaleRecap()
	{
		return Sales_Table_inSaleRecap;
	}
	
	public WebElement Taxes_Table_inSaleRecap()
	{
		return Taxes_Table_inSaleRecap;
	}
	
	public WebElement Refund_Table_inSaleRecap()
	{
		return Refund_Table_inSaleRecap;
	}
	
	public WebElement Discount_Table_inSaleRecap()
	{
		return Discount_Table_inSaleRecap;
	}
	
	public WebElement Sales_Table_inEnterpriseSaleRecap()
	{
		return Sales_Table_inEnterpriseSaleRecap;
	}
	
	public WebElement Taxes_Table_inEnterpriseSaleRecap()
	{
		return Taxes_Table_inEnterpriseSaleRecap;
	}
	
	public WebElement Refund_Table_inEnterpriseSaleRecap()
	{
		return Refund_Table_inEnterpriseSaleRecap;
	}
	
	public WebElement Discount_Table_inEnterpriseSaleRecap()
	{
		return Discount_Table_inEnterpriseSaleRecap;
	}
	///////////////  Gift Card & Give X Report  /////////////////////////
	
	@FindBy(xpath = "//label[contains(.,'Card Number')]/../../input")
	WebElement Gift_Card_NumberInputBx;
	
	@FindBy(xpath = "//label[contains(.,'GiveX Number')]/../../input")
	WebElement GiveX_NumberInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Activity Type')]/../../input")
	WebElement Activity_Type_GiftCardInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Employee')]/../../input")
	WebElement Employee_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Sold In')]/../../input")
	WebElement Sold_In_GiftCardInputBx;
	
	
	public void Enter_GiftCard_Number(String GiftCardNo) throws Exception
	{
		Gift_Card_NumberInputBx.clear();
		Thread.sleep(1000);
		Gift_Card_NumberInputBx.sendKeys(GiftCardNo);
	}
	
	public void Enter_GiveX_Number(String GiveXNo) throws Exception
	{
		GiveX_NumberInputBx.clear();
		Thread.sleep(1000);
		GiveX_NumberInputBx.sendKeys(GiveXNo);
	}
	
	
	public void Select_Activity_Type(String Option)
	{
		Activity_Type_GiftCardInputBx.click();
		
		driver.findElement(By.xpath("//select-option[contains(.,'"+Option+"')]")).click();
	}
	
	public WebElement Employee_InputBox()
	{
		return Employee_InputBx;
	}
	
	public void Select_Employee(String EmployeeName) throws Exception
	{
		Employee_InputBx.click();
		
		try
		{
			new Common_XPaths(driver, test).SearchBox_DropDown.clear();
			Thread.sleep(1000);
			new Common_XPaths(driver, test).SearchBox_DropDown.sendKeys(EmployeeName);
		}
		catch(Exception l) {}
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+EmployeeName+"')]")).click();
	}
	
	public void Select_Sold_In(String SoldIn)
	{
		Sold_In_GiftCardInputBx.click();
		
		driver.findElement(By.xpath("//select-option[contains(.,'"+SoldIn+"')]")).click();
	}
	
	
	/////////////////  Driver Report  /////////////////////
	
	@FindBy(xpath = "//button[contains(.,'SEND RECEIPT')]")
	WebElement Send_ReceiptBtn;
	
	@FindBy(xpath = "//label[contains(.,'Email Address')]/../../input")
	WebElement Email_Address_InputBx;
	
	@FindBy(xpath = "//mat-icon[contains(.,'keyboard_arrow_left')]/..")
	WebElement Back_Btn;
	
	@FindBy(xpath = "//td[contains(.,'Sub Total')]/../td[4]")
	WebElement SubTotal_DriverReport;
	
	@FindBy(xpath = "//td[.=' Total ']/../td[2]")
	WebElement Total_DriverReport;
	
	@FindBy(xpath = "//td[contains(.,'Tax Total')]/../td[3]")
	WebElement TaxTotal_DriverReport;
	
	public String SubTotal_DriverReport()
	{
		return SubTotal_DriverReport.getText();
	}
	
	public String Total_DriverReport()
	{
		return Total_DriverReport.getText();
	}
	
	public String TaxTotal_DriverReport()
	{
		return TaxTotal_DriverReport.getText();
	}
	
	public void Click_Back_Button()
	{
		Back_Btn.click();
	}
	
	public void Click_Send_Receipt_Button()
	{
		Send_ReceiptBtn.click();
	}
	
	public void Enter_EmailAddress_DriverReport(String EmailID) throws Exception
	{
		Thread.sleep(1000);
		Email_Address_InputBx.clear();
		Thread.sleep(1000);
		Email_Address_InputBx.sendKeys(EmailID);
		
	}
	
	public void Verify_Valid_EmailID_ErrorMessage()
	{
		if(driver.findElement(By.xpath("//mat-hint[contains(.,'Enter Valid Email ID')]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Enter Valid Email ID is Displayed");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter Valid Email ID is not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	
	
	////////////// Batch Report //////////////////
	
	@FindBy(xpath = "//label[contains(.,'Node')]/../../input")
	WebElement Node_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Batch Type')]/../../input")
	WebElement Batch_Type_InputBx;
	
	@FindBy(xpath = "//label[contains(.,'Date Type')]/../../input")
	WebElement Date_Type_InputBx;
	
	@FindBy(xpath = "//select-option[contains(.,'No results match')]")
	WebElement No_Results_MatchInfo_InDropDown;
	
	public WebElement Node_InputBox()
	{
		return Node_InputBx;
	}
	
	
	public void Select_Node(String Node) throws Exception
	{
		Node_InputBx.click();
		
		Thread.sleep(1000);
//		if(driver.findElement(By.xpath("//select-option[contains(.,'"+Node+"')]")).isEnabled())
//		{
//			
//		}
//		else
//		{
		driver.findElement(By.xpath("//select-option[contains(.,'"+Node+"')]")).click();
//		}
	}
	
	public void Select_Batch_Type(String BatchType) throws Exception
	{
		Batch_Type_InputBx.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+BatchType+"')]")).click();
	}
	
	public void Select_Date_Type(String DateType) throws Exception
	{
		Date_Type_InputBx.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+DateType+"')]")).click();
	}
	
	
	////////////////// Employee - Attendance Report  ////////////////
	@FindBy(xpath = "//label[contains(.,'Format')]/../../input")
	WebElement Format_TypeInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Active/Inactive')]/../../input")
	WebElement Active_Inactive_InputBx;
	
	public void Select_FormatType(String format) throws Exception
	{
		Format_TypeInputBx.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+format+"')]")).click();
	
	}
	
	public void Select_Active_InactiveType(String ActiveInactive) throws Exception
	{
		Active_Inactive_InputBx.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+ActiveInactive+"')]")).click();
	
	}
	
	
	/////////////////////  Paid In / Paid Out Report  /////////////////
	
	@FindBy(xpath = "//label[contains(.,'Paid Type')]/../../input")
	WebElement Paid_TypeInputBx;
	
	@FindBy(xpath = "//span[contains(.,'No Paid In& Out Record for Selected Time Period')]")
	WebElement No_PaidIn_PaidOut_InfoMsg;
	
	public void Select_Paid_Type(String PaidType) throws Exception
	{
		Paid_TypeInputBx.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+PaidType+"')]")).click();
	
	}
	
	public WebElement No_PaidIn_PaidOut_InfoMsg()
	{
		return No_PaidIn_PaidOut_InfoMsg;
	}
	
	////////////////// Daily Summary Report  //////////////////
	
	@FindBy(xpath = "//label[contains(.,'Tax')]/../../input")
	WebElement Tax_ReportInputBx;
	
	public void Select_Department_inReport(String Department) throws Exception
	{
		Department_ReportInputBx.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+Department+"')]")).click();
	
	}
	
	public void Select_Tax_inReport(String Tax) throws Exception
	{
		Tax_ReportInputBx.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+Tax+"')]")).click();
	
	}
	
	public WebElement Department_ReportInputBox()
	{
		return Department_ReportInputBx;
	}
	
	public WebElement Tax_ReportInputBox()
	{
		return Tax_ReportInputBx;
	}
	
	public WebElement Net_Sale_DailySummaryReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
//		
//		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[8]/span"));
		return driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[8]/span"));
	}
	
	public WebElement Tax_DailySummaryReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
//		
//		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[8]/span"));
		return driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[9]/span"));
	}
	
	public WebElement Grand_Sale_DailySummaryReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
//		
//		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[8]/span"));
		return driver.findElement(By.xpath("//span[contains(.,'Total')]/../../div[10]/span"));
	}
	
	//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[8]/span

///////////// Employee - Gratuity Report  ////////////////////
	
	@FindBy(xpath = "//span[contains(.,'No Gratuity found for selected period')]")
	WebElement No_GratuityFound_InfoMsg;
	
	public WebElement No_GratuityFound_InfoMsg() 
	{
		return No_GratuityFound_InfoMsg;
	}

	//////////////// Till Report  //////////////////
	
	@FindBy(xpath = "//label[contains(.,'Till Type')]/../../input")
	WebElement Till_TypeInputBx;
	
	public void Select_Till_Type(String TillType) throws Exception
	{
		Till_TypeInputBx.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+TillType+"')]")).click();
	}
	
	///////////// Till - Cash Transaction /////////////////
	
	@FindBy(xpath = "//label[contains(.,'Transaction Type')]/../../input")
	WebElement Transaction_TypeInputBx;
	
	public void Select_Transaction_Type(String TransactionType) throws Exception
	{
		Transaction_TypeInputBx.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+TransactionType+"')]")).click();
	}
	
	
	///////////////// Tax Report  //////////////////
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tax Per ServiceType')][contains(@class,'mat-checkbox-checked')]")
	WebElement Tax_PerServiceType_ChkBx_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Tax Per ServiceType')]")
	WebElement Tax_PerServiceType_ChkBx;
	
	@FindBy(xpath = "//div[contains(.,'Total')]/../div[4]/span")
	WebElement Tax_Total_TaxReport;
	
	@FindBy(xpath = "//div[contains(.,'Total')]/../div[5]/span")
	WebElement Tax_Exempt_TaxReport;
	
	@FindBy(xpath = "//div[contains(.,'Rounding Off')]/../div[4]/span")
	WebElement Rounding_Off_TaxReport;
	
	public WebElement Tax_Total_TaxReport()
	{
		return Tax_Total_TaxReport;
	}
	
	public WebElement Tax_Exempt_TaxReport()
	{
		return Tax_Exempt_TaxReport;
	}

	public WebElement Rounding_Off_TaxReport()
	{
		return Rounding_Off_TaxReport;
	}

	

	public void Enable_Tax_Per_ServiceType()
	{
		try
		{
			if(Tax_PerServiceType_ChkBx_SLD.isDisplayed())
			{
			
			}
		}
		catch(Exception h)
		{
			Tax_PerServiceType_ChkBx.click();
		}
	}
	
	
	public void Disable_Tax_Per_ServiceType()
	{
		try
		{
			if(Tax_PerServiceType_ChkBx_SLD.isDisplayed())
			{
				Tax_PerServiceType_ChkBx.click();

			}
		}
		catch(Exception h)
		{
		}
	}
	

	/////////////////// Membership Statement ///////////////////
	
	@FindBy(xpath = "//label[contains(.,'Customer')]/../../input")
	WebElement Customer_TypeInputBx;
	
	public void Select_Customer(String Customer) throws Exception
	{
		Customer_TypeInputBx.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+Customer+"')]")).click();
	}
	
	public WebElement Customer_TypeInputBx()
	{
		return Customer_TypeInputBx;
	}
	
	
	///////////////////// Revenue Center ///////////////////
	
	@FindBy(xpath = "//label[contains(.,'Revenue Centers')]/../../input")
	WebElement Revenue_CentersInputBx;
	
	@FindBy(xpath = "//select-option[contains(.,'Select All')]//mat-checkbox[contains(@class,'mat-checkbox-checked')]")
	WebElement Select_All_ChecboxSLD;
	
	@FindBy(xpath = "//select-option[contains(.,'Select All')]")
	WebElement Select_All_Checbox;
	
	@FindBy(xpath = "//span[contains(.,'No Revenue Center Records for Selected Time Period')]")
	WebElement No_Revenue_CenterFound_InfoMsg;
	
	public WebElement No_Revenue_CenterFound_InfoMsg() 
	{
		return No_Revenue_CenterFound_InfoMsg;
	}

	
	
	public void Select_Revenue_Centers(String RevenueCenters) throws Exception
	{
		Thread.sleep(1000);
		Revenue_CentersInputBx.click();
		
		try
		{
			if(Select_All_ChecboxSLD.isDisplayed())
			{
				Thread.sleep(1000);
				Select_All_Checbox.click();
			}
		}
		catch(Exception k)
		{
			Thread.sleep(1000);
			Select_All_Checbox.click();
			
			Thread.sleep(1000);
			Select_All_Checbox.click();
		}
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+RevenueCenters+"')]")).click();
	
		Thread.sleep(1000);
		Revenue_CentersInputBx.click();
	
	}
	
	@FindBy(xpath = "//span[contains(.,'No Of Guests')]/../../../../..//div[contains(.,'Total')]/../div[3]/span")
	WebElement Revenue_Total_No_ofGuests;
	
	@FindBy(xpath = "//span[contains(.,'No Of Guests')]/../../../../..//div[contains(.,'Total')]/../div[5]/span")
	WebElement Grand_Total_No_ofGuests;
	
	@FindBy(xpath = "//span[contains(.,'No Of Checks')]/../../../../..//div[contains(.,'Total')]/../div[3]/span")
	WebElement Revenue_Total_No_ofChecks;
	
	@FindBy(xpath = "//span[contains(.,'No Of Checks')]/../../../../..//div[contains(.,'Total')]/../div[5]/span")
	WebElement Grand_Total_No_ofChecks;
	
	@FindBy(xpath = "//span[contains(.,'Net Sales by Category')]/../../../../..//div[contains(.,'Total')]/../div[3]/span")
	WebElement Revenue_Total_NetSales_byCategory;
	
	@FindBy(xpath = "//span[contains(.,'Net Sales by Category')]/../../../../..//div[contains(.,'Total')]/../div[5]/span")
	WebElement Grand_Total_NetSales_byCategory;
	
	@FindBy(xpath = "//span[contains(.,'Net Sales by Shift')]/../../../../..//div[contains(.,'Total')]/../div[3]/span")
	WebElement Revenue_Total_NetSales_byShift;
	
	@FindBy(xpath = "//span[contains(.,'Net Sales by Shift')]/../../../../..//div[contains(.,'Total')]/../div[5]/span")
	WebElement Grand_Total_NetSales_byShift;
	
	@FindBy(xpath = "//span[contains(.,'Net Sales by Revenue Center')]/../../../../..//div[contains(.,'Total')]/../div[3]/span")
	WebElement Breakfast_Total_NetSales_byRevenueCenter;
	
	@FindBy(xpath = "//span[contains(.,'Net Sales by Revenue Center')]/../../../../..//div[contains(.,'Total')]/../div[4]/span")
	WebElement Lunch_Total_NetSales_byRevenueCenter;
	
	@FindBy(xpath = "//span[contains(.,'Net Sales by Revenue Center')]/../../../../..//div[contains(.,'Total')]/../div[5]/span")
	WebElement Dinner_Total_NetSales_byRevenueCenter;
	
	@FindBy(xpath = "//span[contains(.,'Net Sales by Revenue Center')]/../../../../..//div[contains(.,'Total')]/../div[6]/span")
	WebElement Others_Total_NetSales_byRevenueCenter;
	
	
	@FindBy(xpath = "//span[contains(.,'Net Sales by Revenue Center')]/../../../../..//div[contains(.,'Total')]/../div[7]/span")
	WebElement Grand_Total_NetSales_byRevenueCenter;
	
	public void Verify_No_ofGuests_RevenueCenterTotal()
	{
		
		try
		{
			if(Revenue_Total_No_ofGuests.isDisplayed())
			{
				test.log(LogStatus.INFO, "Report available for No of Guests "+" Revenue is : "+Revenue_Total_No_ofGuests.getText()+" Grand Total is : "+Grand_Total_No_ofGuests.getText());
			}
		}
		catch(Exception k)
		{
			test.log(LogStatus.INFO, "Report not available for No of Guests");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
		}
	}
	
	public void Verify_No_ofChecks_RevenueCenterTotal()
	{
		
		try
		{
			if(Revenue_Total_No_ofChecks.isDisplayed())
			{
				test.log(LogStatus.INFO, "Report available for No of Checks "+" Revenue is : "+Revenue_Total_No_ofChecks.getText()+" Grand Total is : "+Grand_Total_No_ofChecks.getText());
			}
		}
		catch(Exception k)
		{
			test.log(LogStatus.INFO, "Report not available for No of Checks");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
		}
	}
	
	public void Verify_NetSales_byCategory_RevenueCenterTotal()
	{
		
		try
		{
			if(Revenue_Total_NetSales_byCategory.isDisplayed())
			{
				test.log(LogStatus.INFO, "Report available for Net Sales by Category "+" Revenue is : "+Revenue_Total_NetSales_byCategory.getText()+" Grand Total is : "+Grand_Total_NetSales_byCategory.getText());
			}
		}
		catch(Exception k)
		{
			test.log(LogStatus.INFO, "Report not available for Net Sales by Category");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
		}
	}
	
	public void Verify_NetSales_byShift_RevenueCenterTotal()
	{
		
		try
		{
			if(Revenue_Total_NetSales_byShift.isDisplayed())
			{
				test.log(LogStatus.INFO, "Report available for Net Sales by Shift "+" Revenue is : "+Revenue_Total_NetSales_byShift.getText()+" Grand Total is : "+Grand_Total_NetSales_byShift.getText());
			}
		}
		catch(Exception k)
		{
			test.log(LogStatus.INFO, "Report not available for Net Sales by Shift");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
		}
	}
	
	public void Verify_NetSales_byRevenue_Center_RevenueCenterTotal()
	{
		
		try
		{
			if(Grand_Total_NetSales_byRevenueCenter.isDisplayed())
			{
				test.log(LogStatus.INFO, "Report available for Net Sales by Revenue Center "+" Breakfast is : "+Breakfast_Total_NetSales_byRevenueCenter.getText()+" Lunch is : "+Lunch_Total_NetSales_byRevenueCenter.getText()+" Dinner is : "+Dinner_Total_NetSales_byRevenueCenter.getText()+" Grand Total is : "+Grand_Total_No_ofGuests.getText());
			}
		}
		catch(Exception k)
		{
			test.log(LogStatus.INFO, "Report not available for Net Sales by Revenue Center");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
		}
	}
	
	public WebElement No_Guests_RevenueTotal()
	{
		return driver.findElement(By.xpath("//span[contains(.,'No Of Guests')]/../../../../..//div[contains(.,'Total')]/../div[3]/span"));
	}
	
	///////// Employee - Role Based Payroll Report  //////////////////////////
	

	@FindBy(xpath = "//label[contains(.,'Process')]/../../input")
	WebElement Process_ReportInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Status')]/../../input")
	WebElement Status_ReportInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Sort By')]/../../input")
	WebElement Sort_By_ReportInputBx;
	
	@FindBy(xpath = "//label[contains(.,'Role')]/../../input")
	WebElement Role_inReportInputBx;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Show summary only')][contains(@class,'mat-checkbox-checked')]")
	WebElement Show_Summary_onlyCheckBx_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Show summary only')]")
	WebElement Show_Summary_onlyCheckBx;
	
	
	public void Select_Process(String Process) throws Exception
	{
		Process_ReportInputBx.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+Process+"')]")).click();
	}
	
	public void Select_Status(String Status) throws Exception
	{
		Status_ReportInputBx.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+Status+"')]")).click();
	}
	
	public void Select_Sort_By(String SortBy) throws Exception
	{
		Sort_By_ReportInputBx.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+SortBy+"')]")).click();
	}
	
	public void Select_Role(String Role) throws Exception
	{
		Role_inReportInputBx.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+Role+"')]")).click();
	}
	
	public void Enable_Show_Summary_Only()
	{
		try
		{
			if(Show_Summary_onlyCheckBx_SLD.isDisplayed())
			{
				
			}
		}
		catch(Exception l)
		{
			Show_Summary_onlyCheckBx.click();
		}
	}
	
	public void Disable_Show_Summary_Only()
	{
		try
		{
			if(Show_Summary_onlyCheckBx_SLD.isDisplayed())
			{
				Show_Summary_onlyCheckBx.click();
			}
		}
		catch(Exception l)
		{
			
		}
	}

	public void Select_LastPage_Pagination_InReport()
	{
		List<WebElement> pageList=driver.findElements(By.xpath("//pagination//div/div/button"));
		int LastPageSize=pageList.size()-1;
		
		driver.findElement(By.xpath("//pagination//div/div["+LastPageSize+"]/button")).click();
		
	}
	
	
	/////////////  Sale - Logo Sale & Logo Payment Report  ///////////////////
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Business Day')][contains(@class,'mat-checkbox-checked')]")
	WebElement Business_Day_CheckBx_SLD;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Business Day')]")
	WebElement Business_Day_CheckBx;

	@FindBy(xpath = "//label[contains(.,'Payment Type')]/../../input")
	WebElement Payment_Type_inReportInputBx;

	@FindBy(xpath = "//span[contains(.,'No logo sale for selected time period')]")
	WebElement No_LogoSaleFound_InfoMsg;
	
	@FindBy(xpath = "//span[contains(.,'No logo payment for selected time period')]")
	WebElement No_LogoPaymentFound_InfoMsg;
	
	
	public void Select_Payment_Type(String PaymentType) throws Exception
	{
		Payment_Type_inReportInputBx.click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+PaymentType+"')]")).click();
	}
	
	public void Enable_Business_Day()
	{
		try
		{
			if(Business_Day_CheckBx_SLD.isDisplayed())
			{
				
			}
		}
		catch(Exception l)
		{
			Business_Day_CheckBx.click();
		}
	}
	
	public void Disable_Business_Day()
	{
		try
		{
			if(Business_Day_CheckBx_SLD.isDisplayed())
			{
				Business_Day_CheckBx.click();
			}
		}
		catch(Exception l)
		{
			
		}
	}
	
	public WebElement No_LogoSaleFound_InfoMsg()
	{
		return No_LogoSaleFound_InfoMsg;
	}
	
	public WebElement No_LogoPaymentFound_InfoMsg()
	{
		return No_LogoPaymentFound_InfoMsg;
	}
	
	
	@FindBy(xpath = "//span[contains(.,'No Records Found')]")
	WebElement No_Records_FoundInfoMsg;
	
	public WebElement No_Records_FoundInfoMessage()
	{
		return No_Records_FoundInfoMsg;
	}
	
	/////////////////  Enterprise Report  /////////////////////////////
	
	@FindBy(xpath = "//label[contains(.,'Filter Stores By')]/../../input")
	WebElement Filter_Stores_ByInputBx;
	
	@FindBy(xpath = "//input[@aria-label='Selected Stores']")
	WebElement Selected_StoresInputBx;
	
	@FindBy(xpath = "//input[@aria-label='Selected Groups']")
	WebElement Selected_GroupsInputBx;
	
	@FindBy(xpath = "//input[@aria-label='Selected States']")
	WebElement Selected_StatesInputBx;
	
	@FindBy(xpath = "//input[@aria-label='Selected Cities']")
	WebElement Selected_CitiesInputBx;
	
	@FindBy(xpath = "//input[@aria-label='Selected Zip Codes']")
	WebElement Selected_ZipCodesInputBx;
	
	@FindBy(xpath = "//select-option[contains(.,'Stores')]")
	WebElement Stores_Option;
	
	@FindBy(xpath = "//select-option[contains(.,'Group')]")
	WebElement Group_Option;
	
	@FindBy(xpath = "//select-option[contains(.,'State')]")
	WebElement State_selection;
	
	@FindBy(xpath = "//select-option[contains(.,'City')]")
	WebElement City_selection;
	
	@FindBy(xpath = "//select-option[contains(.,'ZipCode')]")
	WebElement ZipCode_selection;
	
	@FindBy(xpath = "//button/span/mat-icon[contains(.,'close')]")
	WebElement CloseAllStoreBtn;
	
	@FindBy(xpath = "//select-option/div/mat-checkbox/label/span")
	WebElement Click_The_Enterprise_Store;
	
	@FindBy(xpath = "//mat-checkbox[contains(.,'Show Payments')]")
	WebElement Show_Payments_CheckBx;
	
	public void Select_Stores_In_Enterprise_Report(String StoreName) throws Exception
	{
		Thread.sleep(1000);
		try
		{
			Filter_Stores_ByInputBx.click();

			Thread.sleep(1000);
			Stores_Option.click();
			
		}
		catch(Exception k)
		{
			
		
				Thread.sleep(1000);
				Stores_InputBx.click();
			
		}
		
		
		Thread.sleep(3000);
		//Click the Close button of All the selected Stores
		CloseAllStoreBtn.click();

		Thread.sleep(500);
		//click the Apply button for cancel the select options for Stores
		Apply_Btn.click();
		
		Thread.sleep(3000);
		//Enter the required Store
		Selected_StoresInputBx.sendKeys(StoreName);

		Thread.sleep(3000);
		//CLick the searched store
		Click_The_Enterprise_Store.click();
	
	}
	
	

	public void Select_Groups_In_Enterprise_Report(String GroupName) throws Exception
	{
		Thread.sleep(1000);
		Filter_Stores_ByInputBx.click();
		
		Thread.sleep(1000);
		Group_Option.click();
		
		Thread.sleep(3000);
		//Click the Close button of All the selected Stores
		CloseAllStoreBtn.click();

		Thread.sleep(500);
		//click the Apply button for cancel the select options for Stores
		Apply_Btn.click();
		
		Thread.sleep(3000);
		//Enter the required Store
		Selected_GroupsInputBx.sendKeys(GroupName);

		Thread.sleep(3000);
		//CLick the searched store
		Click_The_Enterprise_Store.click();
	
	}
	
	public void Select_States_In_Enterprise_Report(String StateName) throws Exception
	{
		Thread.sleep(1000);
		Filter_Stores_ByInputBx.click();
		
		Thread.sleep(1000);
		State_selection.click();
		
		Thread.sleep(3000);
		//Click the Close button of All the selected Stores
		CloseAllStoreBtn.click();

		Thread.sleep(500);
		//click the Apply button for cancel the select options for Stores
		Apply_Btn.click();
		
		Thread.sleep(3000);
		//Enter the required Store
		Selected_GroupsInputBx.sendKeys(StateName);

		Thread.sleep(3000);
		//CLick the searched store
		Click_The_Enterprise_Store.click();
	
	}
	
	public void Select_City_In_Enterprise_Report(String CityName) throws Exception
	{
		Thread.sleep(1000);
		Filter_Stores_ByInputBx.click();
		
		Thread.sleep(1000);
		City_selection.click();
		
		Thread.sleep(3000);
		//Click the Close button of All the selected Stores
		CloseAllStoreBtn.click();

		Thread.sleep(500);
		//click the Apply button for cancel the select options for Stores
		Apply_Btn.click();
		
		Thread.sleep(3000);
		//Enter the required Store
		Selected_CitiesInputBx.sendKeys(CityName);

		Thread.sleep(3000);
		//CLick the searched store
		Click_The_Enterprise_Store.click();
	
	}
	
	public void Select_ZipCode_In_Enterprise_Report(String ZipCode) throws Exception
	{
		Thread.sleep(1000);
		Filter_Stores_ByInputBx.click();
		
		Thread.sleep(1000);
		ZipCode_selection.click();
		
		Thread.sleep(3000);
		//Click the Close button of All the selected Stores
		CloseAllStoreBtn.click();

		Thread.sleep(500);
		//click the Apply button for cancel the select options for Stores
		Apply_Btn.click();
		
		Thread.sleep(3000);
		//Enter the required Store
		Selected_ZipCodesInputBx.sendKeys(ZipCode);

		Thread.sleep(3000);
		//CLick the searched store
		Click_The_Enterprise_Store.click();
	
	}
	
	@FindBy(xpath = "//label[contains(.,'Stores')]/../../input")
	WebElement Stores_InputBx;
	
	public void Store_Selection_in_DropDown_EnterpriseReport(String StoreName) throws Exception
	{
		Thread.sleep(2000);
		Stores_InputBx.click();
		
		try
		{	
			Thread.sleep(1000);
			new Common_XPaths(driver, test).SearchBox.clear();
			Thread.sleep(1000);
			new Common_XPaths(driver, test).SearchBox.sendKeys(StoreName);

		}
		catch(Exception l) {}
		

//			if(driver.findElement(By.xpath("//select-option[contains(.,'Select All')]")).isEnabled())
//			{
//				driver.findElement(By.xpath("//select-option[contains(.,'Select All')]")).click();
//			}
//			Thread.sleep(1000);
//			Stores_InputBx.clear();
//			Thread.sleep(1000);
//			Stores_InputBx.sendKeys(StoreName);

		
	
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+StoreName+"')]")).click();
	}
	
	public WebElement Stores_InputBox_Enterprise_Reports()
	{
		return Stores_InputBx;
	}
	

	public WebElement GrossSales_Amount_SaleReport_Enterprise_Report()
	{
		return driver.findElement(By.xpath("//tfoot/tr/td[2]/div"));
	}
	
	public WebElement Void_Amount_SaleReport_Enterprise_Report()
	{
		return driver.findElement(By.xpath("//tfoot/tr/td[3]/div"));
	}
	
	public WebElement Discount_Amount_SaleReport_Enterprise_Report()
	{
		return driver.findElement(By.xpath("//tfoot/tr/td[4]/div"));
	}
	
	public WebElement Discount_TaxAmount_SaleReport_Enterprise_Report()
	{
		return driver.findElement(By.xpath("//tfoot/tr/td[5]/div"));
	}
	
	public WebElement Tax_Amount_SaleReport_Enterprise_Report()
	{
		return driver.findElement(By.xpath("//tfoot/tr/td[6]/div"));
	}
	
	public WebElement Net_SalesAmount_SaleReport_Enterprise_Report()
	{
		return driver.findElement(By.xpath("//tfoot/tr/td[7]/div"));
	}
	
	public WebElement Gift_Card_SoldAmount_SaleReport_Enterprise_Report()
	{
		return driver.findElement(By.xpath("//tfoot/tr/td[8]/div"));
	}
	
	public WebElement GiveX_SoldAmount_SaleReport_Enterprise_Report()
	{
		return driver.findElement(By.xpath("//tfoot/tr/td[9]/div"));
	}
	
	public WebElement COGS_SaleReport_Enterprise_Report()
	{
		return driver.findElement(By.xpath("//tfoot/tr/td[10]/div"));
	}
	
	@FindBy(xpath = "//label[contains(.,'Enter Email Address')]/../../textarea")
	WebElement Enter_Email_AddressInputBx;
	
	@FindBy(xpath = "//p[contains(.,'Please Enter Valid Email')]")
	WebElement Enter_Valid_Email_PopUp;
	
	@FindBy(xpath = "//button[contains(.,'EXPORT TO EMAIL')]")
	WebElement Export_To_EmailBtn;
	
	public void Enter_Email_Address(String Email) throws Exception
	{
		Enter_Email_AddressInputBx.clear();
		Thread.sleep(1000);
		Enter_Email_AddressInputBx.sendKeys(Email);
		
	}
	
	public void Click_Export_To_EmailButton()
	{
		Export_To_EmailBtn.click();
	}
	
	public void Verify_Valid_Email()
	{
		try
		{
			if(Enter_Valid_Email_PopUp.isDisplayed())
			{
				test.log(LogStatus.PASS, "Please Enter Valid Email is Displayed");
				
//				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception k)
		{
			test.log(LogStatus.FAIL, "Please Enter Valid Email is not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	public WebElement Sale_NetSales_Amount_EnterpriseSaleReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
		
		return driver.findElement(By.xpath("//tfoot/tr/td[2]"));
	}
	
	
	
	
	public WebElement Quantity_EnterpriseSaleReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
		
		return driver.findElement(By.xpath("//tfoot/tr/td[3]"));
	}
	
	
	public WebElement Tax_EnterpriseSaleReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
		
		return driver.findElement(By.xpath("//tfoot/tr/td[4]"));
	}
	
	public WebElement Discount_EnterpriseSaleReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
		
		return driver.findElement(By.xpath("//tfoot/tr/td[5]"));
	}
	
	
	public WebElement PercentageOfSale_EnterpriseSaleReport()
	{
//		List<WebElement> rowList=driver.findElements(By.xpath("//tbody/tr"));
		
		return driver.findElement(By.xpath("//tfoot/tr/td[6]"));
	}
	
	@FindBy(xpath = "//td[contains(.,'No sale for selected time period')]")
	WebElement No_SaleFound_InfoMsg;
	
	public WebElement No_SaleFound_InfoMessage()
	{
		return No_SaleFound_InfoMsg;
	}
	
	
	public void Select_Store_inEmployeeRoleBased_EnterpriseReport(String StoreName) throws Exception
	{
		Thread.sleep(1000);
	Stores_InputBox_Enterprise_Reports().click();
		Thread.sleep(1000);
		
		if(driver.findElement(By.xpath("//select-option[contains(.,'Select All')]")).isEnabled())
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath("//select-option[contains(.,'Select All')]")).click();
		}
		
		for(int i=1;i<=20;i++)
		{
			Thread.sleep(2000);
//			driver.findElement(By.tagName("cdk-virtual-scroll-viewport")).sendKeys(Keys.ARROW_DOWN);
			Robot rd=new Robot();
			
			
			
//		WebElement Sel=driver.findElement(By.xpath("//div[@class='option-list']/div/cdk-virtual-scroll-viewport/div[1]/div[9]"));
//		JavascriptExecutor je = (JavascriptExecutor) driver;
	//   
//	    je.executeScript("arguments[0].scrollIntoView(true);",Sel);
	    
	    
	    driver.findElement(By.tagName("cdk-virtual-scroll-viewport")).sendKeys(Keys.PAGE_DOWN);
//	    driver.findElement(By.tagName("cdk-virtual-scroll-viewport")).sendKeys(Keys.PAGE_DOWN);
//	    driver.findElement(By.tagName("cdk-virtual-scroll-viewport")).sendKeys(Keys.PAGE_DOWN);
//	    driver.findElement(By.tagName("cdk-virtual-scroll-viewport")).sendKeys(Keys.PAGE_DOWN);
	//    
//	    rd.mouseWheel(1000);
//	    rd.mouseMove(0, 200);
//		WheelInput.ScrollOrigin scrollOrg=WheelInput.ScrollOrigin.fromElement(Sel);
//		new Actions(driver).scrollFromOrigin(scrollOrg, 0, 200).perform();
	    
		}
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//select-option[contains(.,'"+StoreName+"')]")).click();
		
		Thread.sleep(3000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(2000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		
		
	}
	
	public WebElement Sale_NetSales_Amount_SaleReport_Enterprise()
	{

		return driver.findElement(By.xpath("//tfoot/tr/td[2]/div"));

	}

	

	public WebElement Quantity_SaleReport_Enterprise()
	{

		return driver.findElement(By.xpath("//tfoot/tr/td[3]/div"));

	}

	

	public WebElement Tax_SaleReport_Enterprise()
	{

		return driver.findElement(By.xpath("//tfoot/tr/td[4]/div"));

	}

	

	public WebElement Discount_SaleReport_Enterprise()
	{

		return driver.findElement(By.xpath("//tfoot/tr/td[5]/div"));

	}

	

	public WebElement PercentageOfSale_SaleReport_Enterprise()
	{

		return driver.findElement(By.xpath("//tfoot/tr/td[6]/div"));

	}
	
	@FindBy(xpath = "//label[contains(.,'Discounts')]/../../input")
	WebElement Discounts_InputBx;
	
	public void Select_All_Store() throws Exception
		{
			Thread.sleep(2000);
			Stores_InputBx.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//option-panel//select-option[contains(.,'Select All')]/div/mat-checkbox/label/span[2]")).click();

			Thread.sleep(2000);

		//	driver.findElement(By.xpath("//option-panel//select-option[contains(.,'Select All')]/div/mat-checkbox/label/span[2]")).click();


			Stores_InputBx.click();
		}

		public void Select_All_Discount() throws Exception
		{
			Thread.sleep(2000);
			Discounts_InputBx.click();
			Thread.sleep(2000);
			driver.findElement(By.xpath("//option-panel//select-option[contains(.,'Select All')]/div/mat-checkbox/label/span[2]")).click();

			Thread.sleep(2000);
			//driver.findElement(By.xpath("//option-panel//select-option[contains(.,'Select All')]/div/mat-checkbox/label/span[2]")).click();

			Discounts_InputBx.click();
		}
		
		@FindBy(xpath = "//app-selectbox//label[contains(.,'Credit Entry Class')]/../../input")
		WebElement Select_Credit_Entry_Class;

		public void Select_Credit_Entry_Class(String Store) throws Exception
		{
			Thread.sleep(1000);
			Select_Credit_Entry_Class.click();

			Thread.sleep(8000);
			driver.findElement(By.xpath("//select-option[contains(.,'"+Store+"')]")).click();
			//new Common_XPaths(driver, test).Click_DropDown_withSearchText(Select_Store_InputBx, Store, "Store Selected");
		}

		@FindBy(xpath = "//app-selectbox//label[contains(.,'Credit/Debit')]/../../input")
		WebElement Select_Credit_Debit;

		public void Select_Credit_Debit(String Store) throws Exception
		{
			Thread.sleep(1000);
			Select_Credit_Debit.click();

			Thread.sleep(8000);
			driver.findElement(By.xpath("//select-option[contains(.,'"+Store+"')]")).click();
			//new Common_XPaths(driver, test).Click_DropDown_withSearchText(Select_Store_InputBx, Store, "Store Selected");
		}

		@FindBy(xpath = "//app-selectbox/..//label[contains(.,'Selected Discounts')]/../..//input")
		WebElement Selected_Discounts_InputBx;

	 

		public void Selected_Discounts() throws InterruptedException 
		{
			Selected_Discounts_InputBx.click();

		List<WebElement> menuList=driver.findElements(By.xpath("//div/select-option"));

			int menuSize=menuList.size();


			int randomMenu=ThreadLocalRandom.current().nextInt(2, menuSize);

			String menu = driver.findElement(By.xpath("//div["+randomMenu+"]/select-option")).getText();

			Thread.sleep(2000);
			driver.findElement(By.xpath("//input[contains(@name,'search')]")).sendKeys(menu);

			Thread.sleep(2000);
			driver.findElement(By.xpath("//div[1]/select-option")).click();

			Selected_Discounts_InputBx.click();

		}
		
		public void Discount_Selection_in_DropDown_EnterpriseReport() throws Exception
		{

			Thread.sleep(1000);

			Discounts_InputBx.click();
			Thread.sleep(1000);


			driver.findElement(By.xpath("//option-panel//select-option[contains(.,'Select All')]/div/mat-checkbox/label/span[2]")).click();

			Thread.sleep(1000);

			List<WebElement> optList=driver.findElements(By.xpath("//option-panel//select-option/div[1]"));

			int optionSize=optList.size();

			System.out.println("Options Size "+optionSize);


				List<WebElement> optList1=driver.findElements(By.xpath("//option-panel//select-option/div[1]"));

				int optionSize1=optList1.size();


				int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize1);

				Thread.sleep(1000);
//				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
//		Search(driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).getText());

			driver.findElement(By.xpath("//div[@class='option-list']/div/cdk-virtual-scroll-viewport/div[1]/div[1]")).click();

			Thread.sleep(1000);
			Discounts_InputBx.click();
			Thread.sleep(1000);

		}
		
		public void Store_Selection_in_DropDown_EnterpriseReport() throws Exception
		{

			Thread.sleep(1000);

			Stores_InputBx.click();
			Thread.sleep(1000);


			driver.findElement(By.xpath("//option-panel//select-option[contains(.,'Select All')]/div/mat-checkbox/label/span[2]")).click();

			Thread.sleep(1000);

			List<WebElement> optList=driver.findElements(By.xpath("//option-panel//select-option/div[1]"));

			int optionSize=optList.size();

			System.out.println("Options Size "+optionSize);


				List<WebElement> optList1=driver.findElements(By.xpath("//option-panel//select-option/div[1]"));

				int optionSize1=optList1.size();


				int randomOpt=ThreadLocalRandom.current().nextInt(1, optionSize1);

				Thread.sleep(1000);
//				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).click();
//		Search(driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomOpt+"]//select-option")).getText());

			driver.findElement(By.xpath("//div[@class='option-list']/div/cdk-virtual-scroll-viewport/div[1]/div[1]")).click();

				Thread.sleep(1000);

		Stores_InputBx.click();
		Thread.sleep(1000);

		}
		
		public void Select_All_Group_in_DropDown_EnterpriseReport() throws Exception
		{

	 

			Thread.sleep(1000);

	 

			Selected_GroupsInputBx.click();
			Thread.sleep(1000);


			driver.findElement(By.xpath("//option-panel//select-option[contains(.,'Select All')]/div/mat-checkbox/label/span[2]")).click();
		}

		public void Select_All_State_in_DropDown_EnterpriseReport() throws Exception
		{

			Thread.sleep(1000);
			Selected_StatesInputBx.click();
			Thread.sleep(1000);


			driver.findElement(By.xpath("//option-panel//select-option[contains(.,'Select All')]/div/mat-checkbox/label/span[2]")).click();
		}


		public void Select_All_City_in_DropDown_EnterpriseReport() throws Exception
		{

			Thread.sleep(1000);

			Selected_CitiesInputBx.click();
			Thread.sleep(1000);


			driver.findElement(By.xpath("//option-panel//select-option[contains(.,'Select All')]/div/mat-checkbox/label/span[2]")).click();
		}

		public void Select_All_ZiP_Code_in_DropDown_EnterpriseReport() throws Exception
		{

			Thread.sleep(1000);

			Selected_ZipCodesInputBx.click();
			Thread.sleep(1000);


			driver.findElement(By.xpath("//option-panel//select-option[contains(.,'Select All')]/div/mat-checkbox/label/span[2]")).click();
		}
		
		public void Select_Store(String Store) throws Exception
		{
			Thread.sleep(1000);
			Selected_StoresInputBx.click();

			Thread.sleep(8000);
			driver.findElement(By.xpath("//select-option[contains(.,'"+Store+"')]")).click();
			//new Common_XPaths(driver, test).Click_DropDown_withSearchText(Select_Store_InputBx, Store, "Store Selected");
		}
}