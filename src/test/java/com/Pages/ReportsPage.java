package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	WebElement Department_InputBx;
	
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
	
	@FindBy(xpath = "//label[contains(.,'Date')]/../../input")
	WebElement Date_inSpecificDateInputBx;
	
	@FindBy(xpath = "//select-option[contains(.,'Date range')]")
	WebElement Date_Range_TimePeriodBtn;
	
	@FindBy(xpath = "//label[contains(.,'Start Date')]/../../input")
	WebElement Start_DateInputBx;
	
	@FindBy(xpath = "//label[contains(.,'End Date')]/../../input")
	WebElement End_DateInputBx;
	
	@FindBy(xpath = "//span[contains(.,'No transaction for selected time period')]")
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
		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
		
		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[2]/span"));
	}
	
	
	
	
	public WebElement Quantity_SaleReport()
	{
		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
		
		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[3]/span"));
	}
	
	
	public WebElement Tax_SaleReport()
	{
		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
		
		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[4]/span"));
	}
	
	public WebElement Discount_SaleReport()
	{
		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
		
		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[5]/span"));
	}
	
	
	public WebElement PercentageOfSale_SaleReport()
	{
		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
		
		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[6]/span"));
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
	
	
	public WebElement Tax_DailySaleReport()
	{
		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
		
		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[3]/span"));
	
		//p[contains(.,'TOTAL')]/../../div[3]/span
	}
	
	
	public WebElement Discount_DailySaleReport()
	{
		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
		
		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[4]/span"));

		//p[contains(.,'TOTAL')]/../../div[4]/span
	
	}
	
	public WebElement GrandSales_DailySaleReport()
	{
		List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));
		
		return driver.findElement(By.xpath("//data-grid/div/div/div["+rowList.size()+"]/div[@class='content-container']/data-grid-row/div/div[5]/span"));
	
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
	
	@FindBy(xpath = "//app-custom-dynamic-table//span[contains(.,'Sales')]" )
	WebElement Sales_Table_inSaleRecap;
	
	@FindBy(xpath = "//app-custom-dynamic-table//span[contains(.,'Taxes')]" )
	WebElement Taxes_Table_inSaleRecap;
	
	@FindBy(xpath = "//app-custom-dynamic-table//span[contains(.,'Refund')]" )
	WebElement Refund_Table_inSaleRecap;
	
	@FindBy(xpath = "//app-custom-dynamic-table//span[contains(.,'Discount')]" )
	WebElement Discount_Table_inSaleRecap;
	
	
	
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
}
