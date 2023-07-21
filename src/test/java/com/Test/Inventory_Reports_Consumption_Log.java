package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.Common_XPaths;
import com.Pages.InventoryPage;
import com.Pages.InventoryReport_Consumption_LogPage;
import com.Pages.InventoryReport_Consumption_LogPage;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Reports_Consumption_Log {
	
public WebDriver driver;
	
	
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory Reports - ConsumptionLog_report");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	InventoryPage air;
	InventoryReport_Consumption_LogPage iclrp;

	
	@AfterClass
	public void flushTest() throws Exception
	{
		Thread.sleep(2000);
		rep.endTest(test);
		rep.flush();
	}
	
	@AfterMethod
	public void TestFail(ITestResult result) throws Exception
	{
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String scnsht=((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
			
			String s="data:image/png;base64,"+scnsht;
			
			test.log(LogStatus.FAIL, test.addScreenCapture(s));
	
		
		}
	}
	
	
	@Test(priority = 1)
	public void Login() throws Exception
	{
		
		
		Thread.sleep(2000);
		//Call the chrome driver
		ChromeOptions chrOpt=new ChromeOptions();
		chrOpt.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().driverVersion("110.0.5481").setup();
		driver=new ChromeDriver(chrOpt);
	
		//Inizialize GoogleChrome driver path
		//System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
			
		//Open the GoogleChrome window
		//driver = new ChromeDriver();
		//Wait for 30 seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Maximize the Chrome window
		driver.manage().window().maximize();
		Thread.sleep(1000);
		//Launch the URL
		driver.get(Utility.getProperty("appURL"));
		
		Thread.sleep(10000);
		a.Login(driver, test);
	}
	
	@Test(priority = 50)
	public void LogOut() throws Exception
	{
		a.LogOut(driver, test);
	}


	@Test(priority=2)
	public void Calling() throws Exception
	{
		Open_InventoryReport_Consumption_LogPage(driver);
		//RefreshAndPaginination_ColumnFilteration(driver);
		
		ConsumptionLog_Type_As_ALL_Consuption_Type_AS_System_Date_Range_TimePeriod_Apply(driver);
		ConsumptionLog_Type_As_ALL_Consuption_Type_AS_Manual_Date_Range_TimePeriod_Apply(driver);
			
		ConsumptionLog_Type_As_Inventory_Consuption_Type_AS_ALL_Date_Range_TimePeriod_Apply(driver);
	
		ConsumptionLog_Type_As_Inventory_Consuption_Type_AS_Category_Date_Range_TimePeriod_Apply(driver);
		ConsumptionLog_Type_As_Inventory_Consuption_Type_AS_SubCategory_Date_Range_TimePeriod_Apply(driver);
		ConsumptionLog_Type_As_Retail_Consuption_Type_AS_ALL_Date_Range_TimePeriod_Apply(driver);
		
		ConsumptionLog_Type_As_Retail_Consuption_Type_AS_Category_Date_Range_TimePeriod_Apply(driver);
		ConsumptionLog_Type_As_Retail_Consuption_Type_AS_SubCategory_Date_Range_TimePeriod_Apply(driver);
		/*
		ConsumptionLog_Type_As_SubRecipe_Consuption_Type_AS_AnySubRecipe_Date_Range_TimePeriod_Apply(driver);
		ConsumptionLog_Type_As_SubRecipe_Consuption_Type_AS_ALL_Date_Range_TimePeriod_Apply(driver);
		ConsumptionLog_Type_As_SubRecipe_Consuption_Type_AS_ALL_Date_Range_System_TimePeriod_Apply(driver);
		*/
		ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_Today_TimePeriod_Apply(driver);
		ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_Yesterday_TimePeriod_Apply(driver);	
		ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_N_No_Days_TimePeriod_Apply(driver);
		ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_ThisWeek_TimePeriod_Apply(driver);
		ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_SpecificDate_TimePeriod_Apply(driver);
		
		ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_ThisWeek_TimePeriod_Apply(driver);
		ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_LastWeek_TimePeriod_Apply(driver);
		ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_Last7Days_TimePeriod_Apply(driver);
		ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_thisMonth_TimePeriod_Apply(driver);
		ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_LastMonth_TimePeriod_Apply(driver);
		ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_Last30Days_TimePeriod_Apply(driver);
		ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_SpecificDate_TimePeriod_Apply(driver);
	
	
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_InventoryReport_Consumption_LogPage(WebDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		
		
		Thread.sleep(5000);
		//Load the cogsReport page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"inventoryReports/"+"consumptionLogReport");
		Thread.sleep(10000);

	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination_ColumnFilteration(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		//Verify the Pagination and Refresh the page
		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
		
		Thread.sleep(2000);
		//Verify Ascending order for name 
		cmp.Ascending_And_Descending_Order();
		
		
	}

	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_ALL_Consuption_Type_AS_System_Date_Range_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_All();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_System();
		Thread.sleep(2000);
		iclrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					for(int i=1;i<=5;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
				}
		}
		
		
	}
	
	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_ALL_Consuption_Type_AS_Manual_Date_Range_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_All();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_Manual();
		Thread.sleep(2000);
		iclrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					for(int i=1;i<=5;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
				}
		}
		
		
	}
	
	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_Inventory_Consuption_Type_AS_ALL_Date_Range_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_Inventory_Item();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_All();
		
		Thread.sleep(2000);
		iclrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					for(int i=1;i<=5;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
				
				}
		}
		
		}
		
		@Test(priority = 4,enabled = false)
		public void ConsumptionLog_Type_As_Retail_Consuption_Type_AS_ALL_Date_Range_TimePeriod_Apply(WebDriver driver) throws Exception
		{
			cmp=new Common_XPaths(driver, test);
			air=new InventoryPage(driver, test);
			iclrp= new InventoryReport_Consumption_LogPage(driver, test);
			Thread.sleep(2000);

			iclrp.Select_type_Retail_Item();
			Thread.sleep(2000);
			iclrp.Select_ConsumptionType_All();
			
			Thread.sleep(2000);
			iclrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
			Thread.sleep(2000);
			iclrp.Click_ApplyButton();
			Thread.sleep(6000);
			try
			{
			if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
			{
				test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
		
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			}
			catch(Exception G)
			{
				
				 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
					
					List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
					
					int rowSize=rowList.size();
					System.out.println("Size : "+rowSize);
					
					if(rowSize<=5)
					{
						for(int i=1;i<=rowSize;i++)
						{
						            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
			                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
			                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
			                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
			                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
			                        try {
			                        Thread.sleep(5000);
			                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
			                        Thread.sleep(5000);
			                        
			                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
			                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
			                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
			                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
			                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
			                        
			                    	Thread.sleep(3000);
			                    	
			                    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
		    						
			                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
			                        	Thread.sleep(3000);
			    					
			    						
			                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
			                        }
			                                
			                        }
			                        catch (Exception e) {
										// TODO: handle exception
									}
						}

				
					}
					else
					{
						for(int i=1;i<=5;i++)
						{
						            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
			                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
			                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
			                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
			                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
			                        try {
			                        Thread.sleep(5000);
			                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
			                        Thread.sleep(5000);
			                        
			                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
			                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
			                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
			                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
			                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
			                        
			                    	Thread.sleep(3000);
			                    	
			                    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
		    						
			                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
			                        	Thread.sleep(3000);
			    					
			    						
			                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
			                        }
			                                
			                        }
			                        catch (Exception e) {
										// TODO: handle exception
									}
						}
					}
			}
			
			

	}
	
	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_Inventory_Consuption_Type_AS_Category_Date_Range_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_Inventory_Item();
		Thread.sleep(2000);
		iclrp.Select_Category_Level_Category();
		Thread.sleep(2000);
		
		iclrp.Select_Any_category();
	
		iclrp.Select_Any_inventory_Item();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_Manual();	
		Thread.sleep(2000);
		iclrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					for(int i=1;i<=5;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
				}
		}
		
		
	}
	
	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_Retail_Consuption_Type_AS_Category_Date_Range_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_Retail_Item();
		Thread.sleep(2000);
		iclrp.Select_Category_Level_Category();
		Thread.sleep(2000);
		
		iclrp.Select_Any_category();
	
		//iclrp.Select_Any_inventory_Item();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_Manual();	
		Thread.sleep(2000);
		iclrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					for(int i=1;i<=5;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
				}
		}
		
		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_Retail_Consuption_Type_AS_SubCategory_Date_Range_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_Retail_Item();
		
		Thread.sleep(2000);
		iclrp.Select_Category_Level_SubCategory();
		Thread.sleep(2000);
		//iclrp.Select_ConsumptionType_SubCategory();
		Thread.sleep(2000);
		//iclrp.Select_Any_category();
		Thread.sleep(2000);
		//iclrp.Select_Any_Subcategory();
		Thread.sleep(2000);
		//iclrp.Select_Any_inventory_Item();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_Manual();
		
		Thread.sleep(2000);
		iclrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					for(int i=1;i<=5;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
				}
		}
		
		
	}

	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_Inventory_Consuption_Type_AS_SubCategory_Date_Range_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_Inventory_Item();
		Thread.sleep(2000);
		iclrp.Select_Category_Level_SubCategory();
		Thread.sleep(2000);
		//iclrp.Select_ConsumptionType_SubCategory();
		Thread.sleep(2000);
		iclrp.Select_Any_category();
		Thread.sleep(2000);
		iclrp.Select_Any_Subcategory();
		Thread.sleep(2000);
		iclrp.Select_Any_inventory_Item();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_Manual();
		
		Thread.sleep(2000);
		iclrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					for(int i=1;i<=5;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
				}
		}
		
		
	}

	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_SubRecipe_Consuption_Type_AS_AnySubRecipe_Date_Range_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_SubRecipe();
		Thread.sleep(2000);
		iclrp.Select_Any_SubRecipe();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_Manual();
		Thread.sleep(2000);
		iclrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					for(int i=1;i<=5;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
				}
		}
		
		

}
	
	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_SubRecipe_Consuption_Type_AS_ALL_Date_Range_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_SubRecipe();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_All();
		
		Thread.sleep(2000);
		iclrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					for(int i=1;i<=5;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
				}
		}
		
		

}
	
	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_SubRecipe_Consuption_Type_AS_ALL_Date_Range_System_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_SubRecipe();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_System();
		
		Thread.sleep(2000);
		iclrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					for(int i=1;i<=5;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
				}
		}
		
		

}
	
	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_Today_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_All();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_All();
		Thread.sleep(2000);
		iclrp.Select_Today_TimePeriod();
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					for(int i=1;i<=5;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
				}
		}
		
		
	}
	
	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_Yesterday_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_All();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_All();
		Thread.sleep(2000);
		iclrp.Select_Yesterday_TimePeriod();
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					for(int i=1;i<=5;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
				}
		}
		
		
	}
	
	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_N_No_Days_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_All();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_All();
		Thread.sleep(2000);
		iclrp.Select_Last_N_Days_TimePeriod("100");
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					for(int i=1;i<=5;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
				}
		}
		
		
	}
	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_ThisWeek_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_All();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_All();
		Thread.sleep(2000);
		iclrp.Select_This_Week_TimePeriod();
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					for(int i=1;i<=5;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
				}
		}
		
		
	}
	
	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_LastWeek_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_All();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_All();
		Thread.sleep(2000);
		iclrp.Select_Last_Week_TimePeriod();
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					for(int i=1;i<=5;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
				}
		}
		
		
	}
	
	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_Last7Days_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_All();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_All();
		Thread.sleep(2000);
		iclrp.Select_Last_7_Days_TimePeriod();
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					for(int i=1;i<=5;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
				}
		}
		
		
	}
	

	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_thisMonth_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_All();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_All();
		Thread.sleep(2000);
		iclrp.Select_This_Month_TimePeriod();
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					try {
					for(int i=1;i<=5;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                        
		                        }
		                        catch (Exception e) {
		                        	
		                        	Thread.sleep(3000);
			                    	
			                    	JavascriptExecutor js = (JavascriptExecutor) driver;
		    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
		    						
			                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
			                        	Thread.sleep(3000);
			    					
			    						
			                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
									
		                        }
					}
		                                
		                        }
					}
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
				}
		
		
		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_LastMonth_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_All();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_All();
		Thread.sleep(2000);
		iclrp.Select_Last_Month_TimePeriod();
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					try{
						for(int i=1;i<=5;i++)
					
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
					}
						catch (Exception e) {
							test.log(LogStatus.INFO, "Not Able to back detail data");
						}
					}
					
				}
		}
		
		
	
	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_Last30Days_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_All();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_All();
		Thread.sleep(2000);
		iclrp.Select_Last_30_Days_TimePeriod();
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					try{
						for(int i=1;i<=5;i++)
					
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
					}
						catch (Exception e) {
							test.log(LogStatus.INFO, "Not Able to back detail data");
						}
					}
					
				}
		}
		
		
	
	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_SpecificDate_TimePeriod_Apply(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_All();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_All();
		Thread.sleep(2000);
		iclrp.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		try
		{
		if(iclrp.No_consumption_log_for_selected_time_period_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_consumption_log for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			 test.log(LogStatus.PASS, "Consumption_log for selected time period is Displayed");
				
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
				List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row/div/div[1]"));
				
				int rowSize=rowList.size();
				System.out.println("Size : "+rowSize);
				
				if(rowSize<=5)
				{
					for(int i=1;i<=rowSize;i++)
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]/div/a")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}

			
				}
				else
				{
					try{
						for(int i=1;i<=5;i++)
					
					{
					            String Consume_Date =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Name =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Item_Type =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Quantity =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        String Unit =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date is: "+Consume_Date+" Name is : "+Name+" Item_Type is : "+Item_Type+" Quantity is : "+Quantity+" Unit By : "+Unit);
		                        try {
		                        Thread.sleep(5000);
		                        driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).click();
		                        Thread.sleep(5000);
		                        
		                        String Consume_Date1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
		                        String Quantity1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
		                        String Unit1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
		                        String Reason1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		                        String Consume_Type1 =driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		                        test.log(LogStatus.INFO, "Consume_Date1 is: "+Consume_Date1+" Quantity1 is : "+Quantity1+" Unit1 is : "+Unit1+" Reason1 is : "+Reason1+" Consume_Type1 is : "+Consume_Type1);
		                        
		                    	Thread.sleep(3000);
		                    	
		                    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")));
	    						
		                        if(driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).isDisplayed()) {
		                        	Thread.sleep(3000);
		    					
		    						
		                        	driver.findElement(By.xpath("//mat-icon[contains(.,'keyboard_arrow_left')]/../div[contains(.,'Back')]")).click();
		                        }
		                                
		                        }
		                        catch (Exception e) {
									// TODO: handle exception
								}
					}
					}
						catch (Exception e) {
							test.log(LogStatus.INFO, "Not Able to back detail data");
						}
					}
					
				}
		}
		
		

	@Test(priority = 4,enabled = false)
	public void ConsumptionLog_Type_As_ALL_Consuption_Type_AS_All_Today_EXPORT_Cancel_Clos(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		iclrp= new InventoryReport_Consumption_LogPage(driver, test);
		Thread.sleep(2000);

		iclrp.Select_type_All();
		Thread.sleep(2000);
		iclrp.Select_ConsumptionType_All();
		Thread.sleep(2000);
		iclrp.Select_Today_TimePeriod();
		Thread.sleep(2000);
		iclrp.Click_ApplyButton();
		Thread.sleep(6000);
		iclrp.Click_Export_Bx();
		
		Thread.sleep(1000);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Export");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CancelButton();
		
		Thread.sleep(1000);
		//Check whether the New Gift Card Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Gift Card screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift Card screen not Closed");
		}
		
        iclrp.Click_Export_Bx();
		
		Thread.sleep(1000);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Export");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_CloseButton();
		
		Thread.sleep(1000);
		//Check whether the New Gift Card Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Gift Card screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Gift Card screen not Closed");
		}
		
		Thread.sleep(1000);
		//Click Export button
		iclrp.Click_Export_Bx();
		
		driver.findElement(By.xpath("//span[contains(.,'Delivery Options')]/../mat-radio-group/div/mat-radio-button[2]")).click();
		
		
		driver.findElement(By.xpath("//mat-label[contains(.,'Email')]/../../../input")).sendKeys(Utility.getProperty("EmailId"));
	}
}
	



