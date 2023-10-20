package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import java.time.Duration;
import java.util.Collections;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.LogStatus;

import Utility.ExcelDataConfig;
import Utility.Utility;

public class DashBoardPage {
	public WebDriver driver;
	public ExtentTest test;
	
	Utility ut=new Utility();
	Common_XPaths cmp;
	ReportsPage repts;
	public DashBoardPage(WebDriver driver,ExtentTest test)
	{
		this.driver=driver;
		this.test=test;
		
		PageFactory.initElements(driver, this);
	}
	
	///////////////  Dashboard - Sales  /////////////////////
	
	@FindBy(xpath = "//app-metric[contains(.,'Net Sales')]/div/div/div[1]")
	WebElement Net_SalesTile;
	
	@FindBy(xpath = "//app-metric[contains(.,'Active Checks')]/div/div/div[1]")
	WebElement Active_ChecksTile;
	
	@FindBy(xpath = "//app-metric[contains(.,'Tax')]/div/div/div[1]")
	WebElement Tax_Tile;
	
	@FindBy(xpath = "//app-metric[contains(.,'Transactions')]/div/div/div[1]")
	WebElement Transactions_Tile;
	
	@FindBy(xpath = "//app-metric[contains(.,'Discount')]/div/div/div[1]")
	WebElement Discounts_Tile;
	
	@FindBy(xpath = "//app-metric[contains(.,'Refunds')]/div/div/div[1]")
	WebElement Refunds_Tile;
	
	@FindBy(xpath = "//app-metric[contains(.,'COGS')]/div/div/div[1]")
	WebElement COGS_Tile;
	
	@FindBy(xpath = "//app-combo-line-chart[contains(.,'Net Sales By Hour')]//apx-chart")
	WebElement Net_Sales_By_Hour_Graph;
	
	@FindBy(xpath = "//app-combo-line-chart[contains(.,'Net Sales By Tender')]//apx-chart")
	WebElement Net_Sales_By_Tender_Graph;
	
	@FindBy(xpath = "//app-combo-line-chart[contains(.,'Sale By Service Type')]//apx-chart")
	WebElement Sale_By_Service_Type_Graph;
	
	@FindBy(xpath = "//div[2]/*[contains(@class,'total-text')]")
	WebElement Net_Sales_DashboardSales;
	
	@FindBy(xpath = "//div[3]/*[contains(@class,'total-text')]")
	WebElement Tax_DashboardSales;
	
	@FindBy(xpath = "//div[4]/*[contains(@class,'total-text')]")
	WebElement Discount_DashboardSales;
	
	@FindBy(xpath = "//div[5]/*[contains(@class,'total-text')]")
	WebElement Grand_Sales_DashboardSales;
	
	public void Click_Net_SalesTile()
	{
		Net_SalesTile.click();
	}
	
	public WebElement Net_Sales_TileValue()
	{
		return driver.findElement(By.xpath("//app-metric[contains(.,'Net Sales')]//div[1]/span"));
	}
	
	public WebElement Active_Checks_TileValue()
	{
		return driver.findElement(By.xpath("//app-metric[contains(.,'Active Checks')]//div[1]/span"));
	}
	
	public WebElement Tax_TileValue()
	{
		return driver.findElement(By.xpath("//app-metric[contains(.,'Tax')]//div[1]/span"));
	}
	
	public WebElement Transactions_TileValue()
	{
		return driver.findElement(By.xpath("//app-metric[contains(.,'Transactions')]//div[1]/span"));
	}
	
	public WebElement Discounts_TileValue()
	{
		return driver.findElement(By.xpath("//app-metric[contains(.,'Discount')]//div[1]/span"));
	}
	
	public WebElement Refunds_TileValue()
	{
		return driver.findElement(By.xpath("//app-metric[contains(.,'Refunds')]//div[1]/span"));
	}
	
	public WebElement COGS_TileValue()
	{
		return driver.findElement(By.xpath("//app-metric[contains(.,'COGS')]//div[1]/span"));
	}
	
	public WebElement Net_Sales_DashboardSales()
	{
		return Net_Sales_DashboardSales;
	}
	
	public WebElement Tax_DashboardSales()
	{
		return Tax_DashboardSales;
	}
	
	public WebElement Discount_DashboardSales()
	{
		return Discount_DashboardSales;
	}
	
	public WebElement Grand_Sales_DashboardSales()
	{
		return Grand_Sales_DashboardSales;
	}
	
	public void Verify_Net_Sales_InDashboard_Sales(String TimePeriod) throws Exception
	{
		ExcelDataConfig excel=new ExcelDataConfig(Utility.getProperty("Excel_Sheet_Path_Reports"));
		
		Thread.sleep(2000);
		Net_SalesTile.click();
		driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);

		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'Net sale not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Net Sales not Found on this Time Period "+TimePeriod);
			}
		}
		catch(Exception l)
		{

			try
			{
			if(driver.findElement(By.xpath("//pagination/div/div/div")).isDisplayed())
			{
				List<WebElement> paglist=driver.findElements(By.xpath("//pagination/div/div/div"));
				int size=paglist.size()-1;
				
				driver.findElement(By.xpath("//pagination/div/div/div["+size+"]/button")).click();
			}
			}catch(Exception g) {}
		test.log(LogStatus.PASS, "Net Sales Opened for "+TimePeriod);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		
		Thread.sleep(2000);
		//Get the NEt Sales from Sale Recap Report
		String Expeccted_SaleAmt=excel.getData(TimePeriod, 2, 1).toString().replace(",", "");
		double Expected_SaleAmount=Double.parseDouble(Expeccted_SaleAmt);
		
		Thread.sleep(3000);
		//Get Sale Amount
		String NetSale=Net_Sales_DashboardSales.getText().replace(",", "");
		double ActualSale_Amount=Double.parseDouble(NetSale);
		

		
		//Check whether the Sale Amount value is Equal or not
		if(Expected_SaleAmount==ActualSale_Amount)
		{
			test.log(LogStatus.PASS, "Net Sale Amount for Dashboard - Sales is equal to Sale Recap Report for "+TimePeriod);
		}
		else
		{
			double diff=Expected_SaleAmount-ActualSale_Amount;
			String diff_value=String.valueOf(diff);
			
			test.log(LogStatus.FAIL, "Net Sale Amount for Dashboard - Sales is not equal to Sale Recap Report for "+TimePeriod+".The value diff is : "+diff);
		}
		
	
		//Get the Tax from Sale Recap Report
		String Expeccted_Tx=excel.getData(TimePeriod, 3, 1).toString().replace(",", "");
		double Expected_Tax=Double.parseDouble(Expeccted_Tx);
		
		//Get the Tax
		String Tx=Tax_DashboardSales.getText().replace(",", "");
		double ActualTax=Double.parseDouble(Tx);
		
		//Check whether the Tax value is Equal or not
		if(Expected_Tax==ActualTax)
		{
			test.log(LogStatus.PASS, "Tax for Dashboard - Sales is equal to Sale Recap Report for "+TimePeriod);
	
		}
		else
		{
			double diff=Expected_Tax-ActualTax;
			test.log(LogStatus.FAIL, "Tax for Dashboard - Sales is not equal to Sale Recap Report for "+TimePeriod+".The value diff is : "+diff);
	
			String diff_value=String.valueOf(diff);
		}
		
		//Get the Discount from Sale Recap Report
		String Expeccted_Discnt=excel.getData(TimePeriod, 4, 1).toString().replace(",", "");
		double Expected_Discount=Double.parseDouble(Expeccted_Discnt);
		
		//Get the Discount
		String Discnt=Discount_DashboardSales.getText().replace(",", "");
		double ActualDiscount=Double.parseDouble(Discnt);
	
		//Check whether the Tax value is Equal or not
		if(Expected_Discount==ActualDiscount)
		{
			test.log(LogStatus.PASS, "Discount for Dashboard - Sales is equal to Sale Recap Report for "+TimePeriod);
		}
		else
		{
			double diff=Expected_Discount-ActualDiscount;
			test.log(LogStatus.FAIL, "Discount for Dashboard - Sales is not equal to Sale Recap Report for "+TimePeriod+".The value diff is : "+diff);
		}
		
		//Get the Grand Sales from Sale Recap Report
		String Expected_GrandSale=excel.getData(TimePeriod, 7, 1).toString().replace(",", "");
		double Expected_Grand_Sales=Double.parseDouble(Expected_GrandSale);
	
		
		//Get the Grand Sales
		String GrandSale=Grand_Sales_DashboardSales.getText().replace(",", "");
		double ActualGrand_Sales=Double.parseDouble(GrandSale);
		
		//Check whether the Grand_Sales value is Equal or not
		if(Expected_Grand_Sales==ActualGrand_Sales)
		{
			test.log(LogStatus.PASS, "Grand Sales for Dashboard - Sales is equal to Sale Recap Report for "+TimePeriod);
		}
		else
		{
			double diff=Expected_Grand_Sales-ActualGrand_Sales;
			test.log(LogStatus.FAIL, "Grand Sales for Dashboard - Sales is not equal to Sale Recap Report  for "+TimePeriod+".The value diff is : "+diff);
		}
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		}
	}
	
	
	
	public void Verify_Active_Checks_inDashboard_Sales() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Thread.sleep(1000);
		Active_ChecksTile.click();
		driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);

		Thread.sleep(1000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'Active Checks not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Active Checks Not Found");
			}
		}
		catch(Exception l)
		{

			try
			{
			if(driver.findElement(By.xpath("//pagination/div/div/div")).isDisplayed())
			{
				List<WebElement> paglist=driver.findElements(By.xpath("//pagination/div/div/div"));
				int size=paglist.size()-1;
				
				driver.findElement(By.xpath("//pagination/div/div/div["+size+"]/button")).click();
			}
			}catch(Exception g) {}
		test.log(LogStatus.INFO, "Active Checks availale");	
		
		String Net_Sales=driver.findElement(By.xpath("//div[4]/*[contains(@class,'total-text')]")).getText();
		
		String Tax=driver.findElement(By.xpath("//div[5]/*[contains(@class,'total-text')]")).getText();

		String Discount=driver.findElement(By.xpath("//div[6]/*[contains(@class,'total-text')]")).getText();

		String Grand_Sales=driver.findElement(By.xpath("//div[7]/*[contains(@class,'total-text')]")).getText();

		
		test.log(LogStatus.INFO, "Active Checks Total values for Net Sales : "+Net_Sales+ " Tax Total is : "+Tax+" Discount is : "+Discount+" Grand Sales : "+Grand_Sales);
		}
		
	
	}
	
	public void Verify_Tax_inDashboard_Sales() throws Exception
	{
		repts=new ReportsPage(driver, test);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1500);
		Tax_Tile.click();
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);

		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Tax is not Available for the Selected Time Period");
	
			}
		}
		catch(Exception o)
		{
			try
			{
			if(driver.findElement(By.xpath("//pagination/div/div/div")).isDisplayed())
			{
				List<WebElement> paglist=driver.findElements(By.xpath("//pagination/div/div/div"));
				int size=paglist.size()-1;
				
				driver.findElement(By.xpath("//pagination/div/div/div["+size+"]/button")).click();
			}
			}catch(Exception g) {}
		String Tax=driver.findElement(By.xpath("//div[4]/*[contains(@class,'total-text')]")).getText();
		
		String TaxExempt=driver.findElement(By.xpath("//div[5]/*[contains(@class,'total-text')]")).getText();

//		String RefundTax=driver.findElement(By.xpath("//span[contains(.,'Refund Tax')]/../../div[4]")).getText();
		
		test.log(LogStatus.INFO, "Tax Tile Total Tax is : "+Tax+" Tax Exempt is : "+TaxExempt);
		}
	}
	
	
	public void Verify_Transactions_inDashboard_Sales() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		Transactions_Tile.click();
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);

		
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'Transactions not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Transactions not Found");
			}
		}
		catch(Exception k)
		{
			test.log(LogStatus.INFO, "Transactions available");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	public void Verify_Discounts_inDashboard_Sales() throws Exception
	{			driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		
		Thread.sleep(1000);
		Discounts_Tile.click();
		
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);

		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'Discounts not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Discounts not Found");
			}
		}
		catch(Exception k)
		{
			test.log(LogStatus.INFO, "Discounts available");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	public void Verify_Refunds_inDashboard_Sales() throws Exception
	{	
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		Refunds_Tile.click();
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);

		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'Refunds not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Refunds not Found");
			}
		}
		catch(Exception k)
		{
			test.log(LogStatus.INFO, "Refunds available");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	
	public void Verify_COGS_inDashboard_Sales() throws Exception
	{		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		COGS_Tile.click();
		Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);

		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'COGS not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "COGS not Found");
			}
		}
		catch(Exception k)
		{
			test.log(LogStatus.INFO, "COGS available");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	}
	
	public void Verify_Net_Sales_By_HourGraph()
	{
		
		try
		{
			if(Net_Sales_By_Hour_Graph.isDisplayed())
			{
				test.log(LogStatus.PASS, "Net Sales By Hour Graph is Available");
				
//				if(driver.findElement(By.xpath("//app-combo-line-chart[contains(.,'Net Sales By Hour')]//apx-chart[contains(.,'No transaction for selected time period')]")).isDisplayed())
//				{
//					test.log(LogStatus.INFO, "No transaction for the Time Period - Net Sales By Hour");
//				}
			}
		}
		catch(Exception l)
		{
			
			test.log(LogStatus.FAIL, "Net Sales By Hour Graph is Not Available");
		}
	}
	
	public void Verify_Net_Sales_By_TenderGraph()
	{
		
		try
		{
			if(Net_Sales_By_Tender_Graph.isDisplayed())
			{
				test.log(LogStatus.PASS, "Net Sales By Tender Graph is Available");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.FAIL, "Net Sales By Tender Graph is Not Available");
		}
	}
	
	
	public void Verify_Sale_By_Service_TypeGraph()
	{
		
		try
		{
			if(Sale_By_Service_Type_Graph.isDisplayed())
			{
				test.log(LogStatus.PASS, "Sale By Service Type Graph is Available");
				
//				if(driver.findElement(By.xpath("//app-combo-line-chart[contains(.,'Sale By Service Type')]//apx-chart[contains(.,'No transaction for selected time period')]")).isDisplayed())
//				{
//					test.log(LogStatus.INFO, "No transaction for the Time Period - Sale By Service Type");
//				}
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.FAIL, "Sale By Service Type Graph is Not Available");
		}
	}
	
	
	//////////////////  Dashboard - Online Ordering  ////////////////////
	
	@FindBy(xpath = "//app-metric[contains(.,'Gross Sales')]/div/div/div[1]")
	WebElement Gross_SalesTile;

	@FindBy(xpath = "//app-metric[contains(.,'Total Volume')]/div/div/div[1]")
	WebElement Total_VolumeTile;
	
	@FindBy(xpath = "//app-metric[contains(.,'Net Volume')]/div/div/div[1]")
	WebElement Net_VolumeTile;
	
	@FindBy(xpath = "//app-metric[contains(.,'Available Balance')]/div/div/div[1]")
	WebElement Available_BalanceTile;
	
	@FindBy(xpath = "//app-metric[contains(.,'Pending Balance')]/div/div/div[1]")
	WebElement Pending_BalanceTile;
	
	@FindBy(xpath = "//app-combo-line-chart[contains(.,'Top Selling Categories')]//apx-chart")
	WebElement Top_Selling_Categories_Graph;
	
	@FindBy(xpath = "//app-combo-line-chart[contains(.,'Top Selling Items')]//apx-chart")
	WebElement Top_Selling_Items_Graph;
	
	public WebElement Gross_SalesTile()
	{
		return Gross_SalesTile;
	}
	
	public WebElement Total_VolumeTile()
	{
		return Total_VolumeTile;
	}
	
	public WebElement Net_VolumeTile()
	{
		return Net_VolumeTile;
	}
	
	public WebElement Available_BalanceTile()
	{
		return Available_BalanceTile;
	}
	
	public WebElement Pending_BalanceTile()
	{
		return Pending_BalanceTile;
	}
	

	public void Verify_Gross_Sales_InDashboard() throws Exception
	{
		repts=new ReportsPage(driver, test);
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		Gross_SalesTile.click();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);

		Thread.sleep(2000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Gross Sales is not Available for the Selected Time Period ");
			}
		}
		catch(Exception l)
		{
			test.log(LogStatus.PASS, "Gross Sales is Available for the Selected Time Period ");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);

		}
		Thread.sleep(2000);

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	}
	
	public void Verify_Total_Volume_inDashboard() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Total_VolumeTile.click();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		Thread.sleep(2000);

		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Total Volume is not Available for the Selected Time Period");
			}
		}
		catch(Exception k)
		{
			test.log(LogStatus.INFO, "Total Volume is not Available for the Selected Time Period");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);

		}
		Thread.sleep(2000);

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

	}
	
	
	public void Verify_Top_Selling_Categories_Graph()
	{
		
		try
		{
			if(Top_Selling_Categories_Graph.isDisplayed())
			{
				test.log(LogStatus.PASS, "Top Selling Categories Graph is Available");
				
//				if(driver.findElement(By.xpath("//app-combo-line-chart[contains(.,'Top Selling Categories')]//apx-chart[contains(.,'No transaction for selected time period')]")).isDisplayed())
//				{
//					test.log(LogStatus.INFO, "No transaction for the Time Period - Top Selling Categories");
//				}
			}
		}
		catch(Exception l)
		{
			
			test.log(LogStatus.FAIL, "Top Selling Categories Graph is Not Available");
		}
	}
	
	public void Verify_Top_Selling_Items_Graph()
	{
		
		try
		{
			if(Top_Selling_Items_Graph.isDisplayed())
			{
				test.log(LogStatus.PASS, "Top Selling Items Graph is Available");
				
//				if(driver.findElement(By.xpath("//app-combo-line-chart[contains(.,'Top Selling Items')]//apx-chart[contains(.,'No transaction for selected time period')]")).isDisplayed())
//				{
//					test.log(LogStatus.INFO, "No transaction for the Time Period - Top Selling Items");
//				}
			}
		}
		catch(Exception l)
		{
			
			test.log(LogStatus.FAIL, "Top Selling Items Graph is Not Available");
		}
	}
		
	////////////////////  Dashboard - Marketing  ///////////////////////////////
	
	@FindBy(xpath = "//app-metric[contains(.,'Campaign Sent')]/div/div/div[1]")
	WebElement Campaign_SentTile;
	
	public WebElement Campaign_Sent_TileValue()
	{
		return driver.findElement(By.xpath("//app-metric[contains(.,'Campaign Sent')]//div[1]/span"));
	}
	
	public WebElement Scheduled_TileValue()
	{
		return driver.findElement(By.xpath("//app-metric[contains(.,'Scheduled')]//div[1]/span"));
	}
	
	public WebElement Drafted_TileValue()
	{
		return driver.findElement(By.xpath("//app-metric[contains(.,'Drafted')]//div[1]/span"));
	}
	
	public WebElement Total_Visits_TileValue()
	{
		return driver.findElement(By.xpath("//app-metric[contains(.,'Total Visits')]//div[1]/span"));
	}
	
	public WebElement Visit_Conversion_Rate_TileValue()
	{
		return driver.findElement(By.xpath("//app-metric[contains(.,'Visit Conversion Rate')]//div[1]/span"));
	}
	
	public void Verify_Campaign_Reach(String TimePeriod)
	{
		String Emais_Sent=driver.findElement(By.xpath("//span[contains(.,'Emails Sent')]/../span[1]")).getText();
		
		String Deliver_Rate=driver.findElement(By.xpath("//span[contains(.,'Deliver Rate')]/../span[1]")).getText();
		
		String Open_Rate=driver.findElement(By.xpath("//span[contains(.,'Open Rate')]/../span[1]")).getText();
		
		String Bouce_Rate=driver.findElement(By.xpath("//span[contains(.,'Bouce Rate')]/../span[1]")).getText();
		
		String Unsubscribe_Rate=driver.findElement(By.xpath("//span[contains(.,'Unsubscribe Rate')]/../span[1]")).getText();
		
		if(driver.findElement(By.xpath("//apx-chart")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Campaign Reach Chart is Displayed for "+TimePeriod);
		}
		else
		{
			test.log(LogStatus.FAIL, "Campaign Reach Chart is not Displayed for "+TimePeriod);
		}
		
		test.log(LogStatus.INFO, "Emails Sent is : "+Emais_Sent);
		test.log(LogStatus.INFO, "Deliver Rate is : "+Deliver_Rate);
		test.log(LogStatus.INFO, "Open Rate is : "+Open_Rate);
		test.log(LogStatus.INFO, "Bouce Rate is : "+Bouce_Rate);
		test.log(LogStatus.INFO, "Unsubscribe Rate is : "+Unsubscribe_Rate);

		
	}
	
	public void Verify_Top_Campaings()
	{
		List<WebElement> CompaingsList=driver.findElements(By.xpath("//data-grid//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row"));
		
		for(int i=1;i<=CompaingsList.size();i++)
		{
			String Campaign_Name=driver.findElement(By.xpath("//data-grid//div[contains(@class,'cdk-drop-list')]/div/div["+i+"]/data-grid-row/div/div[1]")).getText();
			
			String Channel=driver.findElement(By.xpath("//data-grid//div[contains(@class,'cdk-drop-list')]/div/div["+i+"]/data-grid-row/div/div[3]")).getText();

			String Visit_Rate=driver.findElement(By.xpath("//data-grid//div[contains(@class,'cdk-drop-list')]/div/div["+i+"]/data-grid-row/div/div[5]")).getText();

			String Total_Visit=driver.findElement(By.xpath("//data-grid//div[contains(@class,'cdk-drop-list')]/div/div["+i+"]/data-grid-row/div/div[6]")).getText();

			test.log(LogStatus.INFO, "Top Campaings Details -  Campaign Name is : "+Campaign_Name+" Channel : "+Channel+" Visit Rate is : "+Visit_Rate+" Total Visit : "+Visit_Rate);

		}
		
	}

		//////////////// Dashboard - KDS  /////////////////////
	
	@FindBy(xpath = "//app-metric[contains(.,'Total Orders')]/div/div/div[1]")
	WebElement Total_Orders_Tile;
	
	@FindBy(xpath = "//app-metric[contains(.,'Avg. Time Per Check')]/div/div/div[1]")
	WebElement Avg_Time_perCheck_Tile;
	
	@FindBy(xpath = "//app-metric[contains(.,'Total Item Count')]/div/div/div[1]")
	WebElement Total_ItemCount_Tile;
	
	@FindBy(xpath = "//app-metric[contains(.,'Avg. Time Per Item')]/div/div/div[1]")
	WebElement Avg_Time_perItem_Tile;
	

	public WebElement Total_Orders_TileValue()
	{
		return driver.findElement(By.xpath("//app-metric[contains(.,'Total Orders')]//div[1]/span"));
	}
	
	public WebElement Avg_Time_PerCheck_TileValue()
	{
		return driver.findElement(By.xpath("//app-metric[contains(.,'Avg. Time Per Check')]//div[1]/span"));
	}
	
	public WebElement Total_Item_Count_TileValue()
	{
		return driver.findElement(By.xpath("//app-metric[contains(.,'Total Item Count')]//div[1]/span"));
	}
	
	public WebElement Avg_Time_PerItem_TileValue()
	{
		return driver.findElement(By.xpath("//app-metric[contains(.,'Avg. Time Per Item')]//div[1]/span"));
	}
	
	public void Verify_Total_Orders(String TimePeriod) throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);

		Total_Orders_Tile.click();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);

		Thread.sleep(1000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'Total Orders not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Total Orders not Found for "+TimePeriod);
			}
		}
		catch(Exception k)
		{
			
			test.log(LogStatus.INFO, "Total Orders Available for "+TimePeriod);

			List<WebElement> List=driver.findElements(By.xpath("//data-grid//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row"));
			
			for(int i=1;i<=List.size();i++)
			{
			 String Statistics= driver.findElement(By.xpath("//data-grid//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
			 
			 String TotalOrders= driver.findElement(By.xpath("//data-grid//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
 
			 String TotalOrderVoid= driver.findElement(By.xpath("//data-grid//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();

			 
			 test.log(LogStatus.INFO, "Statistics : "+ Statistics+" Total Orders is : "+TotalOrders+" Total Orders Void is : "+TotalOrderVoid);
			}
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		}
	}
	
	public void Verify_Average_Time_perCheck() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);
		Avg_Time_perCheck_Tile.click();
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);

		Thread.sleep(1000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'Avg. Time Per Check')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Avg. Time Per Check not Found");
			}
		}
		catch(Exception k)
		{
			List<WebElement> List=driver.findElements(By.xpath("//data-grid//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row"));
			
//			for(int i=1;i<=List.size();i++)
//			{
//			
//			}
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		}
	}
	
	public void Verify_Total_Item_Count() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);

		Total_ItemCount_Tile.click();
		driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);

		Thread.sleep(1000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'Total Item Count not found')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Total Item Count not Found");
			}
		}
		catch(Exception k)
		{
			List<WebElement> List=driver.findElements(By.xpath("//data-grid//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row"));
			
//			for(int i=1;i<=List.size();i++)
//			{
//			
//			}
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		}
	}
	
	public void Verify_Average_Time_perItem() throws Exception
	{
		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);

		Thread.sleep(1000);

		Avg_Time_perItem_Tile.click();
		driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);

		Thread.sleep(1000);
		try
		{
			if(driver.findElement(By.xpath("//span[contains(.,'Avg. Time Per Item')]")).isDisplayed())
			{
				test.log(LogStatus.INFO, "Avg. Time Per Item not Found");
			}
		}
		catch(Exception k)
		{
			List<WebElement> List=driver.findElements(By.xpath("//data-grid//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row"));
			
//			for(int i=1;i<=List.size();i++)
//			{
//			
//			}
//			test.log(LogStatus.PASS, "Avg. Time Per Item Found");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		}
	}
	
	
	@FindBy(xpath = "//h5[contains(.,'Food Vs Time')]/..//apx-chart")
	WebElement Food_Vs_Time_Graph;
	
	@FindBy(xpath = "//h5[contains(.,'Time Vs Kitchen Display System')]/..//apx-chart")
	WebElement Time_Vs_KDS_Graph;
	
	@FindBy(xpath = "//h5[contains(.,'Sale by Order Type')]/..//apx-chart")
	WebElement Sale_By_OrderType_Graph;
	
	@FindBy(xpath = "//h5[contains(.,'Order Vs Kitchen Display System')]/..//apx-chart")
	WebElement Order_Vs_KDS_Graph;
	
	@FindBy(xpath = "//h5[contains(.,'Module of Sale')]/..//apx-chart")
	WebElement Module_of_Sale_Graph;
	
	public void Verify_Food_Vs_Time_Graph()
	{
		
		try
		{
			if(Food_Vs_Time_Graph.isDisplayed())
			{
				test.log(LogStatus.PASS, "Food Vs Time Graph is Available");
				
//				if(driver.findElement(By.xpath("//app-combo-line-chart[contains(.,'Top Selling Items')]//apx-chart[contains(.,'No transaction for selected time period')]")).isDisplayed())
//				{
//					test.log(LogStatus.INFO, "No transaction for the Time Period - Top Selling Items");
//				}
			}
		}
		catch(Exception l)
		{
			
			test.log(LogStatus.FAIL, "Food Vs Time Graph is Not Available");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);

		}
	}
	
	public void Verify_Time_Vs_KDS_Graph()
	{
		
		try
		{
			if(Time_Vs_KDS_Graph.isDisplayed())
			{
				test.log(LogStatus.PASS, "Time Vs KDS Graph is Available");
				
//				if(driver.findElement(By.xpath("//app-combo-line-chart[contains(.,'Top Selling Items')]//apx-chart[contains(.,'No transaction for selected time period')]")).isDisplayed())
//				{
//					test.log(LogStatus.INFO, "No transaction for the Time Period - Top Selling Items");
//				}
			}
		}
		catch(Exception l)
		{
			
			test.log(LogStatus.FAIL, "Time Vs KDS Graph is Not Available");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);

		}
	}
		
	public void Verify_Sale_By_OrderType_Graph()
	{
		
		try
		{
			if(Sale_By_OrderType_Graph.isDisplayed())
			{
				test.log(LogStatus.PASS, "Sale By Order Type Graph is Available");
				
//				if(driver.findElement(By.xpath("//app-combo-line-chart[contains(.,'Top Selling Items')]//apx-chart[contains(.,'No transaction for selected time period')]")).isDisplayed())
//				{
//					test.log(LogStatus.INFO, "No transaction for the Time Period - Top Selling Items");
//				}
			}
		}
		catch(Exception l)
		{
			
			test.log(LogStatus.FAIL, "Sale By Order Type Graph is Not Available");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);

		}
	}
	
	public void Verify_Order_Vs_KDS_Graph()
	{
		
		try
		{
			if(Order_Vs_KDS_Graph.isDisplayed())
			{
				test.log(LogStatus.PASS, "Order Vs KDS Graph is Available");
				
//				if(driver.findElement(By.xpath("//app-combo-line-chart[contains(.,'Top Selling Items')]//apx-chart[contains(.,'No transaction for selected time period')]")).isDisplayed())
//				{
//					test.log(LogStatus.INFO, "No transaction for the Time Period - Top Selling Items");
//				}
			}
		}
		catch(Exception l)
		{
			
			test.log(LogStatus.FAIL, "Order Vs KDS Graph is Not Available");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);

		}
	}
	
	public void Verify_Module_of_Sale_Graph()
	{
		
		try
		{
			if(Module_of_Sale_Graph.isDisplayed())
			{
				test.log(LogStatus.PASS, "Module of Sale Graph is Available");
				
//				if(driver.findElement(By.xpath("//app-combo-line-chart[contains(.,'Top Selling Items')]//apx-chart[contains(.,'No transaction for selected time period')]")).isDisplayed())
//				{
//					test.log(LogStatus.INFO, "No transaction for the Time Period - Top Selling Items");
//				}
			}
		}
		catch(Exception l)
		{
			
			test.log(LogStatus.FAIL, "Module of Sale is Not Available");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
}
