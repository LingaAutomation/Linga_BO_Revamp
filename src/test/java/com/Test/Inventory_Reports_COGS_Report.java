package com.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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
import com.Pages.InventoryReport_COGS_Page;
import com.Pages.LoginPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Reports_COGS_Report {
	
public SelfHealingDriver driver;
	
	
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory Reports - COGS");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	InventoryPage air;
	InventoryReport_COGS_Page icrp;

	
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
			String scnsht=((TakesScreenshot)driver.getDelegate()).getScreenshotAs(OutputType.BASE64);
			
			String s="data:image/png;base64,"+scnsht;
			
			test.log(LogStatus.FAIL, test.addScreenCapture(s));
	
		
		}
	}
	
	
	@Test(priority = 1)
	public void Login() throws Exception
	{
		
		
		Thread.sleep(2000);
		//Call the chrome driver
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().driverVersion("110.0.5481").setup();
//		driver=new ChromeDriver(chrOpt);

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		
		options.setHeadless(false);
		
		WebDriver delegate=new ChromeDriver();
		
		driver=SelfHealingDriver.create(delegate);
		
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
		Open_Inventory_Cogs_report_Page(driver);
		Product_Item_MenuItem_Date_Range_TimePeriod_Apply(driver);
		Product_Item_RetailItem_Date_Range_TimePeriod_Apply(driver);
		Product_Item_Modifier_Date_Range_TimePeriod_Apply(driver);
		Product_Item_All_Apply(driver);
		Product_Item_All_Yesterday_Apply(driver);
		Product_Item_All_N_No_of_Days_Apply(driver);
		Product_Item_All_This_week_Apply(driver);
		Product_Item_All_Last_Week_TimePeriod_Apply(driver);
		Product_Item_All_Last_7_Days_TimePeriod_Apply(driver);
		Product_Item_All_This_Month_TimePeriod_Apply(driver);
		Product_Item_All_Last_Month_TimePeriod_Apply(driver);
		Product_Item_All_Last_30_Days_TimePeriod_Apply(driver);
		Product_Item_All_Specific_Date_TimePeriod_Apply(driver);
		Product_Item_All_Date_Range_TimePeriod_Apply(driver);
		Inventory_Category_Date_Range_TimePeriod_Apply(driver);
		Inventory_SubCategory_Date_Range_TimePeriod_Apply(driver);
		Inventory_All_Apply(driver);
		Inventory_All_Yesterday_Apply(driver);
		Inventory_All_N_No_of_Days_Apply(driver);
		Inventory_All_This_week_Apply(driver);
		Inventory_All_Last_Week_TimePeriod_Apply(driver);
		Inventory_All_Last_7_Days_TimePeriod_Apply(driver);
		Inventory_All_This_Month_TimePeriod_Apply(driver);
		Inventory_All_Specific_Date_TimePeriod_Apply(driver);
		Inventory_All_Date_Range_TimePeriod_Apply(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Inventory_Cogs_report_Page(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
		Thread.sleep(5000);
		//Load the cogsReport page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"inventoryReports/"+"cogsReport");
		Thread.sleep(10000);

	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination_ColumnFilteration(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		//Verify the Pagination and Refresh the page
		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns_Table();
		
		Thread.sleep(2000);
		//Verify Ascending order for name 
		cmp.Ascending_And_Descending_Order();
		
		
	}
	
	
	@Test(priority = 3,enabled = false)
	public void Product_Item_MenuItem_Date_Range_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
        icrp.Select_Cogs_type_Product_Item();
        Thread.sleep(2000);
        icrp.Select_type_Menu_item();
        Thread.sleep(5000);
        
        icrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_MenuItem_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No MenuItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "MenuItem_Found for cgos report Available for Date_Range_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
			
			int rowSize=rowList.size()-1;
			
			if(rowSize<=1000)
			{
				for(int i=1;i<=rowSize;i++)
				{
				
					String Menu_name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
					String Menu_Item_type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
					
					String quantiy=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
					
					String Cost=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		
					test.log(LogStatus.INFO, "Menu name is  :   "+Menu_name+"   Menu Item type is  :   "+Menu_Item_type+"   Sku_code is  :   "+Sku_code+" Quantiy  is  :  "+quantiy+"  Cost is  :  "+Cost+" ");
					
				}
			
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(icrp.No_Department_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Department Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
	          test.log(LogStatus.PASS, "Department found for cgos report Available for Date_Range_TimePeriod");
				

		List<WebElement> rowList1=driver.findElements(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div"));
			
			int rowSize1=rowList1.size()-1;
		
			
			if(rowSize1<=1000)
			{
				for(int i=1;i<=rowSize1;i++)
				{
				
					String Department_name=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[1]")).getText();
					
					String Menu_Cost=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[2]")).getText();
					
					String Percentage=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[3]")).getText();
					

					test.log(LogStatus.INFO, "Department_name is  :  "+Department_name+"  Menu_Cost type is  :  "+Menu_Cost+"  Percentage is   :  "+Percentage+"  ");
					

					
				}
	

			}
		}
		}
	}
	
		
		
			
	
	@Test(priority = 3,enabled = false)
	public void Product_Item_RetailItem_Date_Range_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
        icrp.Select_Cogs_type_Product_Item();
        Thread.sleep(2000);
        icrp.Select_type_Retail_item();
        Thread.sleep(5000);
        
        icrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_MenuItem_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No MenuItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "MenuItem_Found for cgos report Available for Date_Range_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
			
			int rowSize=rowList.size()-1;
			
			if(rowSize<=1000)
			{
				for(int i=1;i<=rowSize;i++)
				{
				
					String Menu_name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
					String Menu_Item_type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
					
					String quantiy=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
					
					String Cost=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		
					test.log(LogStatus.INFO, "Menu name is  :   "+Menu_name+"   Menu Item type is  :   "+Menu_Item_type+"   Sku_code is  :   "+Sku_code+" Quantiy  is  :  "+quantiy+"  Cost is  :  "+Cost+" ");
					
				}
			
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(icrp.No_Department_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Department Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
	          test.log(LogStatus.PASS, "Department found for cgos report Available for Date_Range_TimePeriod");
				

		List<WebElement> rowList1=driver.findElements(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div"));
			
			int rowSize1=rowList1.size()-1;
		
			
			if(rowSize1<=1000)
			{
				for(int i=1;i<=rowSize1;i++)
				{
				
					String Department_name=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[1]")).getText();
					
					String Menu_Cost=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[2]")).getText();
					
					String Percentage=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[3]")).getText();
					

					test.log(LogStatus.INFO, "Department_name is  :  "+Department_name+"  Menu_Cost type is  :  "+Menu_Cost+"  Percentage is   :  "+Percentage+"  ");
					

					
				}
	

			}
		}
		}
	}
	
		
	@Test(priority = 3,enabled = false)
	public void Product_Item_Modifier_Date_Range_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
        cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
        icrp.Select_Cogs_type_Product_Item();
        Thread.sleep(2000);
        icrp.Select_type_Modifier();
        Thread.sleep(5000);
        
        icrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_MenuItem_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No MenuItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "MenuItem_Found for cgos report Available for Date_Range_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
			
			int rowSize=rowList.size()-1;
			
			if(rowSize<=1000)
			{
				for(int i=1;i<=rowSize;i++)
				{
				
					String Menu_name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
					String Menu_Item_type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
					
					String quantiy=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
					
					String Cost=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		
					test.log(LogStatus.INFO, "Menu name is  :   "+Menu_name+"   Menu Item type is  :   "+Menu_Item_type+"   Sku_code is  :   "+Sku_code+" Quantiy  is  :  "+quantiy+"  Cost is  :  "+Cost+" ");
					
				}
			
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(icrp.No_Department_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Department Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
	          test.log(LogStatus.PASS, "Department found for cgos report Available for Date_Range_TimePeriod");
				

		List<WebElement> rowList1=driver.findElements(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div"));
			
			int rowSize1=rowList1.size()-1;
		
			
			if(rowSize1<=1000)
			{
				for(int i=1;i<=rowSize1;i++)
				{
				
					String Department_name=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[1]")).getText();
					
					String Menu_Cost=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[2]")).getText();
					
					String Percentage=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[3]")).getText();
					

					test.log(LogStatus.INFO, "Department_name is  :  "+Department_name+"  Menu_Cost type is  :  "+Menu_Cost+"  Percentage is   :  "+Percentage+"  ");
					

					
				}
	

			}
		}
		}
	}
	
		
			
	
	
	@Test(priority = 3,enabled = false)
	public void Product_Item_All_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
        icrp.Select_Cogs_type_Product_Item();
        Thread.sleep(2000);
        icrp.Select_type_All();
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_MenuItem_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No MenuItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "MenuItem_Found for cgos report Available for Today");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
			
			int rowSize=rowList.size()-1;
			
			if(rowSize<=1000)
			{
				for(int i=1;i<=rowSize;i++)
				{
				
					String Menu_name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
					String Menu_Item_type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
					
					String quantiy=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
					
					String Cost=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		
					test.log(LogStatus.INFO, "Menu name is  :   "+Menu_name+"   Menu Item type is  :   "+Menu_Item_type+"   Sku_code is  :   "+Sku_code+" Quantiy  is  :  "+quantiy+"  Cost is  :  "+Cost+" ");
					
				}
			
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(icrp.No_Department_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_MenuItem Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			 test.log(LogStatus.PASS, "MenuItem_Found for cgos report Available for Today");
		List<WebElement> rowList1=driver.findElements(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div"));
			
			int rowSize1=rowList1.size()-1;
		
			
			if(rowSize1<=1000)
			{
				for(int i=1;i<=rowSize1;i++)
				{
				
					String Department_name=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[1]")).getText();
					
					String Menu_Cost=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[2]")).getText();
					
					String Percentage=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[3]")).getText();
					

					test.log(LogStatus.INFO, "Department_name is  :  "+Department_name+"  Menu_Cost type is  :  "+Menu_Cost+"  Percentage is   :  "+Percentage+"  ");
					

					
				}
	

			}
		}
		}
	}
	
	@Test(priority = 3,enabled = false)
	public void Product_Item_All_Yesterday_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
        icrp.Select_Cogs_type_Product_Item();
        Thread.sleep(2000);
        icrp.Select_type_All();
        Thread.sleep(5000);
        
        icrp.Select_Yesterday_TimePeriod();
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_MenuItem_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No MenuItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "MenuItem_Found for cgos report Available for Yesterday");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
			
			int rowSize=rowList.size()-1;
			
			if(rowSize<=1000)
			{
				for(int i=1;i<=rowSize;i++)
				{
				
					String Menu_name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
					String Menu_Item_type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
					
					String quantiy=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
					
					String Cost=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		
					test.log(LogStatus.INFO, "Menu name is  :   "+Menu_name+"   Menu Item type is  :   "+Menu_Item_type+"   Sku_code is  :   "+Sku_code+" Quantiy  is  :  "+quantiy+"  Cost is  :  "+Cost+" ");
					
				}
			
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(icrp.No_Department_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_MenuItem Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			

		List<WebElement> rowList1=driver.findElements(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div"));
			
			int rowSize1=rowList1.size()-1;
		
			
			if(rowSize1<=1000)
			{
				for(int i=1;i<=rowSize1;i++)
				{
				
					String Department_name=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[1]")).getText();
					
					String Menu_Cost=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[2]")).getText();
					
					String Percentage=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[3]")).getText();
					

					test.log(LogStatus.INFO, "Department_name is  :  "+Department_name+"  Menu_Cost type is  :  "+Menu_Cost+"  Percentage is   :  "+Percentage+"  ");
					

					
				}
	

			}
		}
		}
	}
	@Test(priority = 3,enabled = false)
	public void Product_Item_All_N_No_of_Days_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
        icrp.Select_Cogs_type_Product_Item();
        Thread.sleep(2000);
        icrp.Select_type_All();
        Thread.sleep(5000);
        
        icrp.Select_Last_N_Days_TimePeriod("100");
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_MenuItem_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No MenuItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "MenuItem_Found for cgos report Available for N No of Days");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
			
			int rowSize=rowList.size()-1;
			
			if(rowSize<=1000)
			{
				for(int i=1;i<=rowSize;i++)
				{
				
					String Menu_name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
					String Menu_Item_type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
					
					String quantiy=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
					
					String Cost=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		
					test.log(LogStatus.INFO, "Menu name is  :   "+Menu_name+"   Menu Item type is  :   "+Menu_Item_type+"   Sku_code is  :   "+Sku_code+" Quantiy  is  :  "+quantiy+"  Cost is  :  "+Cost+" ");
					
				}
			
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(icrp.No_Department_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Department Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
	          test.log(LogStatus.PASS, "Department found for cgos report Available for N No of Days");
				

		List<WebElement> rowList1=driver.findElements(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div"));
			
			int rowSize1=rowList1.size()-1;
		
			
			if(rowSize1<=1000)
			{
				for(int i=1;i<=rowSize1;i++)
				{
				
					String Department_name=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[1]")).getText();
					
					String Menu_Cost=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[2]")).getText();
					
					String Percentage=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[3]")).getText();
					

					test.log(LogStatus.INFO, "Department_name is  :  "+Department_name+"  Menu_Cost type is  :  "+Menu_Cost+"  Percentage is   :  "+Percentage+"  ");
					

					
				}
	

			}
		}
		}
	}
	
	@Test(priority = 3,enabled = false)
	public void Product_Item_All_This_week_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
        icrp.Select_Cogs_type_Product_Item();
        Thread.sleep(2000);
        icrp.Select_type_All();
        Thread.sleep(5000);
        
        icrp.Select_This_Week_TimePeriod();
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_MenuItem_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No MenuItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "MenuItem_Found for cgos report Available for This_Week_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
			
			int rowSize=rowList.size()-1;
			
			if(rowSize<=1000)
			{
				for(int i=1;i<=rowSize;i++)
				{
				
					String Menu_name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
					String Menu_Item_type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
					
					String quantiy=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
					
					String Cost=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		
					test.log(LogStatus.INFO, "Menu name is  :   "+Menu_name+"   Menu Item type is  :   "+Menu_Item_type+"   Sku_code is  :   "+Sku_code+" Quantiy  is  :  "+quantiy+"  Cost is  :  "+Cost+" ");
					
				}
			
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(icrp.No_Department_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Department Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
	          test.log(LogStatus.PASS, "Department found for cgos report Available for This_Week_TimePeriod");
				

		List<WebElement> rowList1=driver.findElements(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div"));
			
			int rowSize1=rowList1.size()-1;
		
			
			if(rowSize1<=1000)
			{
				for(int i=1;i<=rowSize1;i++)
				{
				
					String Department_name=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[1]")).getText();
					
					String Menu_Cost=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[2]")).getText();
					
					String Percentage=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[3]")).getText();
					

					test.log(LogStatus.INFO, "Department_name is  :  "+Department_name+"  Menu_Cost type is  :  "+Menu_Cost+"  Percentage is   :  "+Percentage+"  ");
					

					
				}
	

			}
		}
		}
	}
	
	@Test(priority = 3,enabled = false)
	public void Product_Item_All_Last_Week_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
        icrp.Select_Cogs_type_Product_Item();
        Thread.sleep(2000);
        icrp.Select_type_All();
        Thread.sleep(5000);
        
        icrp.Select_Last_Week_TimePeriod();
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_MenuItem_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No MenuItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "MenuItem_Found for cgos report Available for Last_Week_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
			
			int rowSize=rowList.size()-1;
			
			if(rowSize<=1000)
			{
				for(int i=1;i<=rowSize;i++)
				{
				
					String Menu_name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
					String Menu_Item_type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
					
					String quantiy=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
					
					String Cost=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		
					test.log(LogStatus.INFO, "Menu name is  :   "+Menu_name+"   Menu Item type is  :   "+Menu_Item_type+"   Sku_code is  :   "+Sku_code+" Quantiy  is  :  "+quantiy+"  Cost is  :  "+Cost+" ");
					
				}
			
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(icrp.No_Department_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Department Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
	          test.log(LogStatus.PASS, "Department found for cgos report Available for Last_Week_TimePeriod");
				

		List<WebElement> rowList1=driver.findElements(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div"));
			
			int rowSize1=rowList1.size()-1;
		
			
			if(rowSize1<=1000)
			{
				for(int i=1;i<=rowSize1;i++)
				{
				
					String Department_name=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[1]")).getText();
					
					String Menu_Cost=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[2]")).getText();
					
					String Percentage=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[3]")).getText();
					

					test.log(LogStatus.INFO, "Department_name is  :  "+Department_name+"  Menu_Cost type is  :  "+Menu_Cost+"  Percentage is   :  "+Percentage+"  ");
					

					
				}
	

			}
		}
		}
	}
	
	@Test(priority = 3,enabled = false)
	public void Product_Item_All_Last_7_Days_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
        icrp.Select_Cogs_type_Product_Item();
        Thread.sleep(2000);
        icrp.Select_type_All();
        Thread.sleep(5000);
        
        icrp.Select_Last_7_Days_TimePeriod();
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_MenuItem_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No MenuItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "MenuItem_Found for cgos report Available for Last_Week_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
			
			int rowSize=rowList.size()-1;
			
			if(rowSize<=1000)
			{
				for(int i=1;i<=rowSize;i++)
				{
				
					String Menu_name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
					String Menu_Item_type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
					
					String quantiy=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
					
					String Cost=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		
					test.log(LogStatus.INFO, "Menu name is  :   "+Menu_name+"   Menu Item type is  :   "+Menu_Item_type+"   Sku_code is  :   "+Sku_code+" Quantiy  is  :  "+quantiy+"  Cost is  :  "+Cost+" ");
					
				}
			
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(icrp.No_Department_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Department Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
	          test.log(LogStatus.PASS, "Department found for cgos report Available for Last_Week_TimePeriod");
				

		List<WebElement> rowList1=driver.findElements(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div"));
			
			int rowSize1=rowList1.size()-1;
		
			
			if(rowSize1<=1000)
			{
				for(int i=1;i<=rowSize1;i++)
				{
				
					String Department_name=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[1]")).getText();
					
					String Menu_Cost=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[2]")).getText();
					
					String Percentage=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[3]")).getText();
					

					test.log(LogStatus.INFO, "Department_name is  :  "+Department_name+"  Menu_Cost type is  :  "+Menu_Cost+"  Percentage is   :  "+Percentage+"  ");
					

					
				}
	

			}
		}
		}
	}
	
	@Test(priority = 3,enabled = false)
	public void Product_Item_All_This_Month_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
        icrp.Select_Cogs_type_Product_Item();
        Thread.sleep(2000);
        icrp.Select_type_All();
        Thread.sleep(5000);
        
        icrp.Select_This_Month_TimePeriod();
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_MenuItem_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No MenuItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "MenuItem_Found for cgos report Available for This_Month_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
			
			int rowSize=rowList.size()-1;
			
			if(rowSize<=1000)
			{
				for(int i=1;i<=rowSize;i++)
				{
				
					String Menu_name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
					String Menu_Item_type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
					
					String quantiy=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
					
					String Cost=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		
					test.log(LogStatus.INFO, "Menu name is  :   "+Menu_name+"   Menu Item type is  :   "+Menu_Item_type+"   Sku_code is  :   "+Sku_code+" Quantiy  is  :  "+quantiy+"  Cost is  :  "+Cost+" ");
					
				}
			
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(icrp.No_Department_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Department Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
	          test.log(LogStatus.PASS, "Department found for cgos report Available for This_Month_TimePeriod");
				

		List<WebElement> rowList1=driver.findElements(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div"));
			
			int rowSize1=rowList1.size()-1;
		
			
			if(rowSize1<=1000)
			{
				for(int i=1;i<=rowSize1;i++)
				{
				
					String Department_name=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[1]")).getText();
					
					String Menu_Cost=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[2]")).getText();
					
					String Percentage=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[3]")).getText();
					

					test.log(LogStatus.INFO, "Department_name is  :  "+Department_name+"  Menu_Cost type is  :  "+Menu_Cost+"  Percentage is   :  "+Percentage+"  ");
					

					
				}
	

			}
		}
		}
	}
	
	@Test(priority = 3,enabled = false)
	public void Product_Item_All_Last_Month_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
        icrp.Select_Cogs_type_Product_Item();
        Thread.sleep(2000);
        icrp.Select_type_All();
        Thread.sleep(5000);
        
        icrp.Select_Last_Month_TimePeriod();
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_MenuItem_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No MenuItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "MenuItem_Found for cgos report Available for Last_Month_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
			
			int rowSize=rowList.size()-1;
			
			if(rowSize<=1000)
			{
				for(int i=1;i<=rowSize;i++)
				{
				
					String Menu_name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
					String Menu_Item_type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
					
					String quantiy=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
					
					String Cost=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		
					test.log(LogStatus.INFO, "Menu name is  :   "+Menu_name+"   Menu Item type is  :   "+Menu_Item_type+"   Sku_code is  :   "+Sku_code+" Quantiy  is  :  "+quantiy+"  Cost is  :  "+Cost+" ");
					
				}
			
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(icrp.No_Department_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Department Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
	          test.log(LogStatus.PASS, "Department found for cgos report Available for Last_Month_TimePeriod");
				

		List<WebElement> rowList1=driver.findElements(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div"));
			
			int rowSize1=rowList1.size()-1;
		
			
			if(rowSize1<=1000)
			{
				for(int i=1;i<=rowSize1;i++)
				{
				
					String Department_name=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[1]")).getText();
					
					String Menu_Cost=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[2]")).getText();
					
					String Percentage=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[3]")).getText();
					

					test.log(LogStatus.INFO, "Department_name is  :  "+Department_name+"  Menu_Cost type is  :  "+Menu_Cost+"  Percentage is   :  "+Percentage+"  ");
					

					
				}
	

			}
		}
		}
	}
	@Test(priority = 3,enabled = false)
	public void Product_Item_All_Last_30_Days_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
        icrp.Select_Cogs_type_Product_Item();
        Thread.sleep(2000);
        icrp.Select_type_All();
        Thread.sleep(5000);
        
        icrp.Select_Last_30_Days_TimePeriod();
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_MenuItem_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No MenuItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "MenuItem_Found for cgos report Available for Last_30_Days_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
			
			int rowSize=rowList.size()-1;
			
			if(rowSize<=1000)
			{
				for(int i=1;i<=rowSize;i++)
				{
				
					String Menu_name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
					String Menu_Item_type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
					
					String quantiy=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
					
					String Cost=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		
					test.log(LogStatus.INFO, "Menu name is  :   "+Menu_name+"   Menu Item type is  :   "+Menu_Item_type+"   Sku_code is  :   "+Sku_code+" Quantiy  is  :  "+quantiy+"  Cost is  :  "+Cost+" ");
					
				}
			
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(icrp.No_Department_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Department Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
	          test.log(LogStatus.PASS, "Department found for cgos report Available for Last_30_Days_TimePeriod");
				

		List<WebElement> rowList1=driver.findElements(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div"));
			
			int rowSize1=rowList1.size()-1;
		
			
			if(rowSize1<=1000)
			{
				for(int i=1;i<=rowSize1;i++)
				{
				
					String Department_name=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[1]")).getText();
					
					String Menu_Cost=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[2]")).getText();
					
					String Percentage=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[3]")).getText();
					

					test.log(LogStatus.INFO, "Department_name is  :  "+Department_name+"  Menu_Cost type is  :  "+Menu_Cost+"  Percentage is   :  "+Percentage+"  ");
					

					
				}
	

			}
		}
		}
	}
	@Test(priority = 3,enabled = false)
	public void Product_Item_All_Specific_Date_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
        icrp.Select_Cogs_type_Product_Item();
        Thread.sleep(2000);
        icrp.Select_type_All();
        Thread.sleep(5000);
        
        icrp.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_MenuItem_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No MenuItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "MenuItem_Found for cgos report Available for Specific_Date_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
			
			int rowSize=rowList.size()-1;
			
			if(rowSize<=1000)
			{
				for(int i=1;i<=rowSize;i++)
				{
				
					String Menu_name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
					String Menu_Item_type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
					
					String quantiy=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
					
					String Cost=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		
					test.log(LogStatus.INFO, "Menu name is  :   "+Menu_name+"   Menu Item type is  :   "+Menu_Item_type+"   Sku_code is  :   "+Sku_code+" Quantiy  is  :  "+quantiy+"  Cost is  :  "+Cost+" ");
					
				}
			
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(icrp.No_Department_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Department Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
	          test.log(LogStatus.PASS, "Department found for cgos report Available for Specific_Date_TimePeriod");
				

		List<WebElement> rowList1=driver.findElements(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div"));
			
			int rowSize1=rowList1.size()-1;
		
			
			if(rowSize1<=1000)
			{
				for(int i=1;i<=rowSize1;i++)
				{
				
					String Department_name=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[1]")).getText();
					
					String Menu_Cost=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[2]")).getText();
					
					String Percentage=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[3]")).getText();
					

					test.log(LogStatus.INFO, "Department_name is  :  "+Department_name+"  Menu_Cost type is  :  "+Menu_Cost+"  Percentage is   :  "+Percentage+"  ");
					

					
				}
	

			}
		}
		}
	}
	@Test(priority = 3,enabled = false)
	public void Product_Item_All_Date_Range_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
        icrp.Select_Cogs_type_Product_Item();
        Thread.sleep(2000);
        icrp.Select_type_All();
        Thread.sleep(5000);
        
        icrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_MenuItem_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No MenuItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "MenuItem_Found for cgos report Available for Date_Range_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
			
			int rowSize=rowList.size()-1;
			
			if(rowSize<=1000)
			{
				for(int i=1;i<=rowSize;i++)
				{
				
					String Menu_name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
					String Menu_Item_type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
					
					String quantiy=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
					
					String Cost=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		
					test.log(LogStatus.INFO, "Menu name is  :   "+Menu_name+"   Menu Item type is  :   "+Menu_Item_type+"   Sku_code is  :   "+Sku_code+" Quantiy  is  :  "+quantiy+"  Cost is  :  "+Cost+" ");
					
				}
			
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(icrp.No_Department_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Department Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
	          test.log(LogStatus.PASS, "Department found for cgos report Available for Date_Range_TimePeriod");
				

		List<WebElement> rowList1=driver.findElements(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div"));
			
			int rowSize1=rowList1.size()-1;
		
			
			if(rowSize1<=1000)
			{
				for(int i=1;i<=rowSize1;i++)
				{
				
					String Department_name=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[1]")).getText();
					
					String Menu_Cost=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[2]")).getText();
					
					String Percentage=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[3]")).getText();
					

					test.log(LogStatus.INFO, "Department_name is  :  "+Department_name+"  Menu_Cost type is  :  "+Menu_Cost+"  Percentage is   :  "+Percentage+"  ");
					

					
				}
	

			}
		}
		}
	}
	
	@Test(priority = 3,enabled = false)
	public void Inventory_Category_Date_Range_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
        icrp.Select_Cogs_type_Inventory_Item();
        Thread.sleep(2000);
        icrp.Select_type_Category();
        Thread.sleep(5000);
        
        icrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_Inventory_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No MenuItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "MenuItem_Found for cgos report Available for Date_Range_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[contains(@class,'productItem-table cogs-report-table')]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
			
			int rowSize=rowList.size()-1;
			
			if(rowSize<=1000)
			{
				for(int i=1;i<=rowSize;i++)
				{
					String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
					
					String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
					
					String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
					
					String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
					
                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
					
					String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
					
					
                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
					
				
					test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
					
					
                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
				
                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
					
					String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
					
					String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
					
					String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
					
					String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
					
                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
					
					String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
					
					 
                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
					
					driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();

					
					test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
					
					
				}
			
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Modifier Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		     test.log(LogStatus.PASS, "Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

				List<WebElement> rowList1=driver.findElements(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
					
					int rowSize1=rowList1.size()-1;
				
					
					if(rowSize1<=1000)
					{
						for(int i=1;i<=rowSize1;i++)
						{
						
							String PreTax_PriceUnit=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String SoldQuantiy_modifier=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String Cost_Per_price_modifieer=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							
	                        String TotalCost=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String netRevanue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String TotalRevenue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							

							test.log(LogStatus.INFO, "PreTax_PriceUnit is  :  "+PreTax_PriceUnit+"  SoldQuantiy_modifier type is  :  "+SoldQuantiy_modifier+"  Cost_Per_price_modifieer is   :  "+Cost_Per_price_modifieer+"TotalCost is   :  "+TotalCost+" netRevanue is   :  "+netRevanue+"TotalRevenue is   :  "+TotalRevenue+"   ");
							

							
						}

		}
		}
		}
		catch(Exception G1)
		{
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
		    test.log(LogStatus.PASS, "no Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

		}
		}
	}
	
		
		
			
	
	@Test(priority = 3,enabled = false)
	public void Inventory_SubCategory_Date_Range_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
        icrp.Select_Cogs_type_Inventory_Item();
        Thread.sleep(2000);
        icrp.Select_type_SubCategory();
        Thread.sleep(5000);
        
        icrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_MenuItem_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No MenuItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "MenuItem_Found for cgos report Available for Date_Range_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
			
			int rowSize=rowList.size()-1;
			
			if(rowSize<=1000)
			{
				for(int i=1;i<=rowSize;i++)
				{
				
					String Menu_name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
					String Menu_Item_type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[3]")).getText();
					
					String quantiy=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
					
					String Cost=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
		
					test.log(LogStatus.INFO, "Menu name is  :   "+Menu_name+"   Menu Item type is  :   "+Menu_Item_type+"   Sku_code is  :   "+Sku_code+" Quantiy  is  :  "+quantiy+"  Cost is  :  "+Cost+" ");
					
				}
			
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(icrp.No_Department_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Department Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
	          test.log(LogStatus.PASS, "Department found for cgos report Available for Date_Range_TimePeriod");
				

		List<WebElement> rowList1=driver.findElements(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div"));
			
			int rowSize1=rowList1.size()-1;
		
			
			if(rowSize1<=1000)
			{
				for(int i=1;i<=rowSize1;i++)
				{
				
					String Department_name=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[1]")).getText();
					
					String Menu_Cost=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[2]")).getText();
					
					String Percentage=driver.findElement(By.xpath("//h3[contains(.,'Department Total')]/../../div[3]//div[contains(@class,'cdk-drop-list')]/div["+i+"]//data-grid-row/div/div[3]")).getText();
					

					test.log(LogStatus.INFO, "Department_name is  :  "+Department_name+"  Menu_Cost type is  :  "+Menu_Cost+"  Percentage is   :  "+Percentage+"  ");
					

					
				}
	

			}
		}
		}
	}
	
		
	
	
	@Test(priority = 3,enabled = false)
	public void Inventory_All_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
        icrp.Select_Cogs_type_Inventory_Item();
        Thread.sleep(2000);
      //  icrp.Select_type_All();
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_Inventory_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No MenuItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "Inventory_Found for cgos report Available for Date_Range_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[contains(@class,'productItem-table cogs-report-table')]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
			
			int rowSize=rowList.size()-1;
			
			if(rowSize<=1000)
			{
				for(int i=1;i<=rowSize;i++)
				{
					String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
					
					String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
					
					String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
					
					String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
					
                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
					
					String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
					
					
                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
					
				
					test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
					
					
                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
				
                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
					
					String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
					
					String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
					
					String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
					
					String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
					
                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
					
					String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
					
					 
                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
					
					driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();

					
					test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
					
					
				}
			
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Modifier Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		     test.log(LogStatus.PASS, "Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

				List<WebElement> rowList1=driver.findElements(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
					
					int rowSize1=rowList1.size()-1;
				
					
					if(rowSize1<=1000)
					{
						for(int i=1;i<=rowSize1;i++)
						{
						
							String PreTax_PriceUnit=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String SoldQuantiy_modifier=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String Cost_Per_price_modifieer=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							
	                        String TotalCost=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String netRevanue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String TotalRevenue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							

							test.log(LogStatus.INFO, "PreTax_PriceUnit is  :  "+PreTax_PriceUnit+"  SoldQuantiy_modifier type is  :  "+SoldQuantiy_modifier+"  Cost_Per_price_modifieer is   :  "+Cost_Per_price_modifieer+"TotalCost is   :  "+TotalCost+" netRevanue is   :  "+netRevanue+"TotalRevenue is   :  "+TotalRevenue+"   ");
							

							
						}

		}
		}
		}
		catch(Exception G1)
		{
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
		    test.log(LogStatus.PASS, "no Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

		}
		}
	}
	
	@Test(priority = 3,enabled = false)
	public void Inventory_All_Yesterday_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
		 icrp.Select_Cogs_type_Inventory_Item();
        Thread.sleep(2000);
        icrp.Select_Level_All();
        Thread.sleep(5000);
        
        icrp.Select_Yesterday_TimePeriod();
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_Inventory_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No InventoryItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "InventoryItem_Found for cgos report Available for Date_Range_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[contains(@class,'productItem-table cogs-report-table')]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
			
			int rowSize=rowList.size();
			
			try {
	
			if(rowSize<=5)
			{
				for(int i=1;i<=rowSize;i++)
				{
					String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
					
					String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
					
					String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
					
					String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
					
                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
					
					String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
					
					
                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
					
				
					test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
					
					Thread.sleep(3000);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
					
                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
				
                    Thread.sleep(3000);
                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
					
					String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
					
					String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
					
					String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
					
					String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
					
                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
					
					String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
					
					 
                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
					
					Thread.sleep(3000);
					js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
					driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
					Thread.sleep(3000);
					
					test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
					
					
				}
			}
				else {
					
					for(int i=1;i<=5;i++)
					{
						
						String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
						
						String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
						
						String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
						
						String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
						
						String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
						
						String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
						
						
	                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
						
					
						test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
						
						Thread.sleep(3000);
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
						
	                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
					
	                    Thread.sleep(3000);
	                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
						
						String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
						
						String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
						
						String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
						
						String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
						
						String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
						
						 
	                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
						
						Thread.sleep(1000);
						js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
						Thread.sleep(1000);
						driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
						Thread.sleep(1000);
						
						test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
						
						
						
					}
					
				}
			}
			catch (Exception e) {
				
			}
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Modifier Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		     test.log(LogStatus.PASS, "Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

				List<WebElement> rowList1=driver.findElements(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
					
					int rowSize1=rowList1.size()-1;
				
					
					if(rowSize1<=1000)
					{
						for(int i=1;i<=rowSize1;i++)
						{
						
							String PreTax_PriceUnit=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String SoldQuantiy_modifier=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String Cost_Per_price_modifieer=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							
	                        String TotalCost=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String netRevanue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String TotalRevenue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							

							test.log(LogStatus.INFO, "PreTax_PriceUnit is  :  "+PreTax_PriceUnit+"  SoldQuantiy_modifier type is  :  "+SoldQuantiy_modifier+"  Cost_Per_price_modifieer is   :  "+Cost_Per_price_modifieer+"TotalCost is   :  "+TotalCost+" netRevanue is   :  "+netRevanue+"TotalRevenue is   :  "+TotalRevenue+"   ");
							

							
						}

		}
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		    test.log(LogStatus.PASS, "no Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

		}
		

	}
	@Test(priority = 3,enabled = false)
	public void Inventory_All_N_No_of_Days_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		Thread.sleep(5000);
		icrp.Select_Cogs_type_Inventory_Item();
        Thread.sleep(2000);
        icrp.Select_Level_All();
        Thread.sleep(5000);
        
        icrp.Select_Last_N_Days_TimePeriod("100");
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
        driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_Inventory_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No InventoryItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "InventoryItem_Found for cgos report Available for Date_Range_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[contains(@class,'productItem-table cogs-report-table')]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
			
			int rowSize=rowList.size();
			
			try {
	
			if(rowSize<=5)
			{
				for(int i=1;i<=rowSize;i++)
				{
					String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
					
					String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
					
					String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
					
					String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
					
                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
					
					String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
					
					
                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
					
				
					test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
					
					Thread.sleep(3000);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
					
                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
				
                    Thread.sleep(3000);
                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
					
					String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
					
					String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
					
					String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
					
					String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
					
                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
					
					String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
					
					 
                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
					
					Thread.sleep(3000);
					js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
					driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
					Thread.sleep(3000);
					
					test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
					
					
				}
			}
				else {
					
					for(int i=1;i<=5;i++)
					{
						
						String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
						
						String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
						
						String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
						
						String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
						
						String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
						
						String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
						
						
	                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
						
					
						test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
						
						Thread.sleep(3000);
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
						
	                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
					
	                    Thread.sleep(3000);
	                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
						
						String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
						
						String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
						
						String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
						
						String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
						
						String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
						
						 
	                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
						
						Thread.sleep(1000);
						js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
						Thread.sleep(1000);
						driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
						Thread.sleep(1000);
						
						test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
						
						
						
					}
					
				}
			}
			catch (Exception e) {
				
			}
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Modifier Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		     test.log(LogStatus.PASS, "Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

				List<WebElement> rowList1=driver.findElements(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
					
					int rowSize1=rowList1.size()-1;
				
					
					if(rowSize1<=1000)
					{
						for(int i=1;i<=rowSize1;i++)
						{
						
							String PreTax_PriceUnit=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String SoldQuantiy_modifier=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String Cost_Per_price_modifieer=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							
	                        String TotalCost=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String netRevanue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String TotalRevenue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							

							test.log(LogStatus.INFO, "PreTax_PriceUnit is  :  "+PreTax_PriceUnit+"  SoldQuantiy_modifier type is  :  "+SoldQuantiy_modifier+"  Cost_Per_price_modifieer is   :  "+Cost_Per_price_modifieer+"TotalCost is   :  "+TotalCost+" netRevanue is   :  "+netRevanue+"TotalRevenue is   :  "+TotalRevenue+"   ");
							

							
						}

		}
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		    test.log(LogStatus.PASS, "no Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

		}
		}


	
	
	@Test(priority = 3,enabled = false)
	public void Inventory_All_This_week_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
		 icrp.Select_Cogs_type_Inventory_Item();
        Thread.sleep(2000);
        icrp.Select_Level_All();
        Thread.sleep(5000);
        
        icrp.Select_This_Week_TimePeriod();
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_Inventory_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No InventoryItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "InventoryItem_Found for cgos report Available for Date_Range_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[contains(@class,'productItem-table cogs-report-table')]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
			
			int rowSize=rowList.size();
			
			try {
	
			if(rowSize<=5)
			{
				for(int i=1;i<=rowSize;i++)
				{
					String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
					
					String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
					
					String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
					
					String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
					
                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
					
					String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
					
					
                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
					
				
					test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
					
					Thread.sleep(3000);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
					
                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
				
                    Thread.sleep(3000);
                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
					
					String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
					
					String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
					
					String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
					
					String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
					
                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
					
					String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
					
					 
                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
					
					Thread.sleep(3000);
					js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
					driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
					Thread.sleep(3000);
					
					test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
					
					
				}
			}
				else {
					
					for(int i=1;i<=5;i++)
					{
						
						String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
						
						String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
						
						String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
						
						String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
						
						String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
						
						String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
						
						
	                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
						
					
						test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
						
						Thread.sleep(3000);
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
						
	                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
					
	                    Thread.sleep(3000);
	                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
						
						String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
						
						String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
						
						String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
						
						String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
						
						String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
						
						 
	                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
						
						Thread.sleep(1000);
						js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
						Thread.sleep(1000);
						driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
						Thread.sleep(1000);
						
						test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
						
						
						
					}
					
				}
			}
			catch (Exception e) {
				
			}
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Modifier Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		     test.log(LogStatus.PASS, "Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

				List<WebElement> rowList1=driver.findElements(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
					
					int rowSize1=rowList1.size()-1;
				
					
					if(rowSize1<=1000)
					{
						for(int i=1;i<=rowSize1;i++)
						{
						
							String PreTax_PriceUnit=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String SoldQuantiy_modifier=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String Cost_Per_price_modifieer=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							
	                        String TotalCost=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String netRevanue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String TotalRevenue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							

							test.log(LogStatus.INFO, "PreTax_PriceUnit is  :  "+PreTax_PriceUnit+"  SoldQuantiy_modifier type is  :  "+SoldQuantiy_modifier+"  Cost_Per_price_modifieer is   :  "+Cost_Per_price_modifieer+"TotalCost is   :  "+TotalCost+" netRevanue is   :  "+netRevanue+"TotalRevenue is   :  "+TotalRevenue+"   ");
							

							
						}

		}
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		    test.log(LogStatus.PASS, "no Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

		}
		

	}
	
	@Test(priority = 3,enabled = false)
	public void Inventory_All_Last_Week_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
		icrp.Select_Cogs_type_Inventory_Item();
        Thread.sleep(2000);
        icrp.Select_Level_All();
        Thread.sleep(5000);
        
        icrp.Select_Last_Week_TimePeriod();
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_Inventory_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No InventoryItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "InventoryItem_Found for cgos report Available for Date_Range_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[contains(@class,'productItem-table cogs-report-table')]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
			
			int rowSize=rowList.size();
			
			try {
	
			if(rowSize<=5)
			{
				for(int i=1;i<=rowSize;i++)
				{
					String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
					
					String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
					
					String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
					
					String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
					
                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
					
					String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
					
					
                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
					
				
					test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
					
					Thread.sleep(3000);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
					
                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
				
                    Thread.sleep(3000);
                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
					
					String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
					
					String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
					
					String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
					
					String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
					
                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
					
					String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
					
					 
                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
					
					Thread.sleep(3000);
					js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
					driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
					Thread.sleep(3000);
					
					test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
					
					
				}
			}
				else {
					
					for(int i=1;i<=5;i++)
					{
						
						String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
						
						String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
						
						String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
						
						String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
						
						String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
						
						String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
						
						
	                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
						
					
						test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
						
						Thread.sleep(3000);
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
						
	                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
					
	                    Thread.sleep(3000);
	                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
						
						String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
						
						String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
						
						String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
						
						String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
						
						String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
						
						 
	                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
						
						Thread.sleep(1000);
						js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
						Thread.sleep(1000);
						driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
						Thread.sleep(1000);
						
						test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
						
						
						
					}
					
				}
			}
			catch (Exception e) {
				
			}
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Modifier Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		     test.log(LogStatus.PASS, "Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

				List<WebElement> rowList1=driver.findElements(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
					
					int rowSize1=rowList1.size()-1;
				
					
					if(rowSize1<=1000)
					{
						for(int i=1;i<=rowSize1;i++)
						{
						
							String PreTax_PriceUnit=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String SoldQuantiy_modifier=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String Cost_Per_price_modifieer=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							
	                        String TotalCost=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String netRevanue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String TotalRevenue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							

							test.log(LogStatus.INFO, "PreTax_PriceUnit is  :  "+PreTax_PriceUnit+"  SoldQuantiy_modifier type is  :  "+SoldQuantiy_modifier+"  Cost_Per_price_modifieer is   :  "+Cost_Per_price_modifieer+"TotalCost is   :  "+TotalCost+" netRevanue is   :  "+netRevanue+"TotalRevenue is   :  "+TotalRevenue+"   ");
							

							
						}

		}
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		    test.log(LogStatus.PASS, "no Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

		}
		

	}
	
	@Test(priority = 3,enabled = false)
	public void Inventory_All_Last_7_Days_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
		 icrp.Select_Cogs_type_Inventory_Item();
        Thread.sleep(2000);
        icrp.Select_Level_All();
        Thread.sleep(5000);
        
        icrp.Select_Last_7_Days_TimePeriod();
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_Inventory_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No InventoryItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "InventoryItem_Found for cgos report Available for Date_Range_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[contains(@class,'productItem-table cogs-report-table')]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
			
			int rowSize=rowList.size();
			
			try {
	
			if(rowSize<=5)
			{
				for(int i=1;i<=rowSize;i++)
				{
					String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
					
					String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
					
					String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
					
					String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
					
                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
					
					String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
					
					
                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
					
				
					test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
					
					Thread.sleep(3000);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
					
                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
				
                    Thread.sleep(3000);
                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
					
					String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
					
					String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
					
					String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
					
					String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
					
                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
					
					String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
					
					 
                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
					
					Thread.sleep(3000);
					js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
					driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
					Thread.sleep(3000);
					
					test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
					
					
				}
			}
				else {
					
					for(int i=1;i<=5;i++)
					{
						
						String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
						
						String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
						
						String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
						
						String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
						
						String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
						
						String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
						
						
	                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
						
					
						test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
						
						Thread.sleep(3000);
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
						
	                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
					
	                    Thread.sleep(3000);
	                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
						
						String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
						
						String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
						
						String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
						
						String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
						
						String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
						
						 
	                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
						
						Thread.sleep(1000);
						js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
						Thread.sleep(1000);
						driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
						Thread.sleep(1000);
						
						test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
						
						
						
					}
					
				}
			}
			catch (Exception e) {
				
			}
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Modifier Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		     test.log(LogStatus.PASS, "Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

				List<WebElement> rowList1=driver.findElements(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
					
					int rowSize1=rowList1.size()-1;
				
					
					if(rowSize1<=1000)
					{
						for(int i=1;i<=rowSize1;i++)
						{
						
							String PreTax_PriceUnit=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String SoldQuantiy_modifier=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String Cost_Per_price_modifieer=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							
	                        String TotalCost=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String netRevanue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String TotalRevenue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							

							test.log(LogStatus.INFO, "PreTax_PriceUnit is  :  "+PreTax_PriceUnit+"  SoldQuantiy_modifier type is  :  "+SoldQuantiy_modifier+"  Cost_Per_price_modifieer is   :  "+Cost_Per_price_modifieer+"TotalCost is   :  "+TotalCost+" netRevanue is   :  "+netRevanue+"TotalRevenue is   :  "+TotalRevenue+"   ");
							

							
						}

		}
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		    test.log(LogStatus.PASS, "no Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

		}
		

	}
	
	@Test(priority = 3,enabled = false)
	public void Inventory_All_This_Month_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
		 icrp.Select_Cogs_type_Inventory_Item();
        Thread.sleep(2000);
        icrp.Select_Level_All();
        Thread.sleep(5000);
        
        icrp.Select_This_Month_TimePeriod();
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_Inventory_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No InventoryItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "InventoryItem_Found for cgos report Available for Date_Range_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[contains(@class,'productItem-table cogs-report-table')]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
			
			int rowSize=rowList.size();
			
			try {
	
			if(rowSize<=5)
			{
				for(int i=1;i<=rowSize;i++)
				{
					String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
					
					String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
					
					String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
					
					String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
					
                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
					
					String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
					
					
                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
					
				
					test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
					
					Thread.sleep(3000);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
					
                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
				
                    Thread.sleep(3000);
                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
					
					String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
					
					String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
					
					String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
					
					String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
					
                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
					
					String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
					
					 
                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
					
					Thread.sleep(3000);
					js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
					driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
					Thread.sleep(3000);
					
					test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
					
					
				}
			}
				else {
					
					for(int i=1;i<=5;i++)
					{
						
						String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
						
						String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
						
						String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
						
						String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
						
						String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
						
						String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
						
						
	                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
						
					
						test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
						
						Thread.sleep(3000);
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
						
	                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
					
	                    Thread.sleep(3000);
	                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
						
						String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
						
						String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
						
						String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
						
						String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
						
						String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
						
						 
	                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
						
						Thread.sleep(1000);
						js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
						Thread.sleep(1000);
						driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
						Thread.sleep(1000);
						
						test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
						
						
						
					}
					
				}
			}
			catch (Exception e) {
				
			}
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Modifier Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		     test.log(LogStatus.PASS, "Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

				List<WebElement> rowList1=driver.findElements(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
					
					int rowSize1=rowList1.size()-1;
				
					
					if(rowSize1<=1000)
					{
						for(int i=1;i<=rowSize1;i++)
						{
						
							String PreTax_PriceUnit=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String SoldQuantiy_modifier=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String Cost_Per_price_modifieer=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							
	                        String TotalCost=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String netRevanue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String TotalRevenue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							

							test.log(LogStatus.INFO, "PreTax_PriceUnit is  :  "+PreTax_PriceUnit+"  SoldQuantiy_modifier type is  :  "+SoldQuantiy_modifier+"  Cost_Per_price_modifieer is   :  "+Cost_Per_price_modifieer+"TotalCost is   :  "+TotalCost+" netRevanue is   :  "+netRevanue+"TotalRevenue is   :  "+TotalRevenue+"   ");
							

							
						}

		}
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		    test.log(LogStatus.PASS, "no Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

		}
		

	}
	
	@Test(priority = 3,enabled = false)
	public void Inventory_All_Last_Month_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
		 icrp.Select_Cogs_type_Inventory_Item();
        Thread.sleep(2000);
        icrp.Select_Level_All();
        Thread.sleep(5000);
        
        icrp.Select_Last_Month_TimePeriod();
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_Inventory_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No InventoryItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "InventoryItem_Found for cgos report Available for Date_Range_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[contains(@class,'productItem-table cogs-report-table')]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
			
			int rowSize=rowList.size();
			
			try {
	
			if(rowSize<=5)
			{
				for(int i=1;i<=rowSize;i++)
				{
					String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
					
					String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
					
					String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
					
					String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
					
                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
					
					String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
					
					
                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
					
				
					test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
					
					Thread.sleep(3000);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
					
                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
				
                    Thread.sleep(3000);
                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
					
					String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
					
					String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
					
					String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
					
					String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
					
                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
					
					String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
					
					 
                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
					
					Thread.sleep(3000);
					js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
					driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
					Thread.sleep(3000);
					
					test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
					
					
				}
			}
				else {
					
					for(int i=1;i<=5;i++)
					{
						
						String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
						
						String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
						
						String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
						
						String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
						
						String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
						
						String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
						
						
	                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
						
					
						test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
						
						Thread.sleep(3000);
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
						
	                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
					
	                    Thread.sleep(3000);
	                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
						
						String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
						
						String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
						
						String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
						
						String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
						
						String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
						
						 
	                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
						
						Thread.sleep(1000);
						js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
						Thread.sleep(1000);
						driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
						Thread.sleep(1000);
						
						test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
						
						
						
					}
					
				}
			}
			catch (Exception e) {
				
			}
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Modifier Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		     test.log(LogStatus.PASS, "Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

				List<WebElement> rowList1=driver.findElements(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
					
					int rowSize1=rowList1.size()-1;
				
					
					if(rowSize1<=1000)
					{
						for(int i=1;i<=rowSize1;i++)
						{
						
							String PreTax_PriceUnit=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String SoldQuantiy_modifier=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String Cost_Per_price_modifieer=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							
	                        String TotalCost=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String netRevanue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String TotalRevenue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							

							test.log(LogStatus.INFO, "PreTax_PriceUnit is  :  "+PreTax_PriceUnit+"  SoldQuantiy_modifier type is  :  "+SoldQuantiy_modifier+"  Cost_Per_price_modifieer is   :  "+Cost_Per_price_modifieer+"TotalCost is   :  "+TotalCost+" netRevanue is   :  "+netRevanue+"TotalRevenue is   :  "+TotalRevenue+"   ");
							

							
						}

		}
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		    test.log(LogStatus.PASS, "no Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

		}
		

	}
	@Test(priority = 3,enabled = false)
	public void Inventory_All_Specific_Date_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
		icrp.Select_Cogs_type_Inventory_Item();
        Thread.sleep(2000);
        icrp.Select_Level_All();
        Thread.sleep(5000);
        
        icrp.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_Inventory_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No InventoryItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "InventoryItem_Found for cgos report Available for Date_Range_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[contains(@class,'productItem-table cogs-report-table')]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
			
			int rowSize=rowList.size();
			
			try {
	
			if(rowSize<=5)
			{
				for(int i=1;i<=rowSize;i++)
				{
					String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
					
					String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
					
					String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
					
					String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
					
                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
					
					String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
					
					
                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
					
				
					test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
					
					Thread.sleep(3000);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
					
                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
				
                    Thread.sleep(3000);
                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
					
					String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
					
					String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
					
					String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
					
					String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
					
                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
					
					String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
					
					 
                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
					
					Thread.sleep(3000);
					js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
					driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
					Thread.sleep(3000);
					
					test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
					
					
				}
			}
				else {
					
					for(int i=1;i<=5;i++)
					{
						
						String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
						
						String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
						
						String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
						
						String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
						
						String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
						
						String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
						
						
	                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
						
					
						test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
						
						Thread.sleep(3000);
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
						
	                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
					
	                    Thread.sleep(3000);
	                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
						
						String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
						
						String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
						
						String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
						
						String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
						
						String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
						
						 
	                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
						
						Thread.sleep(1000);
						js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
						Thread.sleep(1000);
						driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
						Thread.sleep(1000);
						
						test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
						
						
						
					}
					
				}
			}
			catch (Exception e) {
				
			}
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Modifier Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		     test.log(LogStatus.PASS, "Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

				List<WebElement> rowList1=driver.findElements(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
					
					int rowSize1=rowList1.size()-1;
				
					
					if(rowSize1<=1000)
					{
						for(int i=1;i<=rowSize1;i++)
						{
						
							String PreTax_PriceUnit=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String SoldQuantiy_modifier=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String Cost_Per_price_modifieer=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							
	                        String TotalCost=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String netRevanue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String TotalRevenue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							

							test.log(LogStatus.INFO, "PreTax_PriceUnit is  :  "+PreTax_PriceUnit+"  SoldQuantiy_modifier type is  :  "+SoldQuantiy_modifier+"  Cost_Per_price_modifieer is   :  "+Cost_Per_price_modifieer+"TotalCost is   :  "+TotalCost+" netRevanue is   :  "+netRevanue+"TotalRevenue is   :  "+TotalRevenue+"   ");
							

							
						}

		}
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		    test.log(LogStatus.PASS, "no Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

		}
		

	}
	@Test(priority = 3,enabled = false)
	public void Inventory_All_Date_Range_TimePeriod_Apply(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		
		icrp= new InventoryReport_COGS_Page(driver, test);
		
		
		icrp.Select_Cogs_type_Inventory_Item();
        Thread.sleep(2000);
        icrp.Select_Level_All();
        Thread.sleep(5000);
        
        icrp.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
        Thread.sleep(5000);
        icrp.Click_ApplyButton();
        Thread.sleep(5000);
        
		Thread.sleep(5000);
		try
		{
		if(icrp.No_Inventory_Found_InfoMsg().isDisplayed())
		{
			test.log(LogStatus.PASS, "No InventoryItem_Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
          test.log(LogStatus.PASS, "InventoryItem_Found for cgos report Available for Date_Range_TimePeriod");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[contains(@class,'productItem-table cogs-report-table')]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
			
			int rowSize=rowList.size();
			
			try {
	
			if(rowSize<=5)
			{
				for(int i=1;i<=rowSize;i++)
				{
					String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
					
					String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
					
					String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
					
					String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
					
					String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
					
                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
					
					String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
					
					
                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
					
				
					test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
					
					Thread.sleep(3000);
					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
					
                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
				
                    Thread.sleep(3000);
                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
					
					String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
					
					String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
					
					String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
					
					
                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
					
					String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
					
					String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
					
                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
					
					String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
					
					String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
					
					 
                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
					
					String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
					
					Thread.sleep(3000);
					js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
					driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
					Thread.sleep(3000);
					
					test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
					
					
				}
			}
				else {
					
					for(int i=1;i<=5;i++)
					{
						
						String item_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div")).getText();
						
						String type_name=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[2]")).getText();
						
						String Unit_price=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[3]")).getText();
						
						String Sku_code=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[5]")).getText();
						
						String Total_Income=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[9]")).getText();
						
						String Discount=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[10]")).getText();
						
						
	                	String Net_revenue=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[12]")).getText();
						
					
						test.log(LogStatus.INFO, "item_name is  :   "+item_name+"   Menu Item type is  :   "+type_name+"   Unit_price  is  :   "+Unit_price+" Sku_code is  :   "+Sku_code+" Sold_Quantity  is  :  "+Sold_Quantity+"  Total_Income is  :  "+Total_Income+"  Cost_per_Unit is  :  "+Cost_per_Unit+" Total_cost is  :  "+Total_cost+" Cost_Percentage is  :  "+Cost_Percentage+" Discount is  :  "+Discount+"Net_revenue is  :  "+Net_revenue+"revenu_Percetage is  :  "+revenu_Percetage+"");
						
						Thread.sleep(3000);
						JavascriptExecutor js = (JavascriptExecutor) driver;
						js.executeScript("arguments[0].scrollIntoView();",  driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")));
						
	                    driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/div//i[contains(@class,'plus-square')]")).click();
					
	                    Thread.sleep(3000);
	                   String item_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[1]/div")).getText();
						
						String type_name1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[2]")).getText();
						
						String Unit_price1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[3]")).getText();
						
						String Sku_code1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[4]")).getText();
						
						
	                	String Sold_Quantity1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[5]")).getText();
						
						String Total_Income1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[6]")).getText();
						
						String Cost_per_Unit1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[7]")).getText();
						
	                     String Total_cost1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[8]")).getText();
						
						String Cost_Percentage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[9]")).getText();
						
						String Discount1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[10]")).getText();
						
						 
	                	String Net_revenue1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[11]")).getText();
						
						String revenu_Percetage1=driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom ng-star-inserted')]["+i+"]/td[12]")).getText();
						
						Thread.sleep(1000);
						js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")));
						Thread.sleep(1000);
						driver.findElement(By.xpath("//tbody/tr[contains(@class,'border-bottom cogs-category')]["+i+"]/td[1]/a//i[contains(@class,'minus-square')]")).click();
						Thread.sleep(1000);
						
						test.log(LogStatus.INFO, "item_name1 is  :   "+item_name1+"   Menu Item type is  :   "+type_name1+"   Unit_price1  is  :   "+Unit_price1+" Sku_code1 is  :   "+Sku_code1+" Sold_Quantity1  is  :  "+Sold_Quantity1+"  Total_Income1 is  :  "+Total_Income1+"  Cost_per_Unit1 is  :  "+Cost_per_Unit1+" Total_cost1 is  :  "+Total_cost1+" Cost_Percentage1 is  :  "+Cost_Percentage1+" Discount1 is  :  "+Discount1+"Net_revenue1 is  :  "+Net_revenue1+"revenu_Percetage1 is  :  "+revenu_Percetage1+"");
						
						
						
					}
					
				}
			}
			catch (Exception e) {
				
			}
			
		}
        
		driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		
		try
		{
		if(driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "No_Modifier Found for selected time period is Displayed");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		     test.log(LogStatus.PASS, "Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

				List<WebElement> rowList1=driver.findElements(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]"));
					
					int rowSize1=rowList1.size()-1;
				
					
					if(rowSize1<=1000)
					{
						for(int i=1;i<=rowSize1;i++)
						{
						
							String PreTax_PriceUnit=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String SoldQuantiy_modifier=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String Cost_Per_price_modifieer=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							
	                        String TotalCost=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[1]")).getText();
							
							String netRevanue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[2]")).getText();
							
							String TotalRevenue=driver.findElement(By.xpath("//div/h3[contains(.,'Modifiers')]/../../div[4]/table/tbody/tr[contains(@class,'border-bottom cogs-category-background ng-star-inserted')]["+i+"]/td[3]")).getText();
							

							test.log(LogStatus.INFO, "PreTax_PriceUnit is  :  "+PreTax_PriceUnit+"  SoldQuantiy_modifier type is  :  "+SoldQuantiy_modifier+"  Cost_Per_price_modifieer is   :  "+Cost_Per_price_modifieer+"TotalCost is   :  "+TotalCost+" netRevanue is   :  "+netRevanue+"TotalRevenue is   :  "+TotalRevenue+"   ");
							

							
						}

		}
		}
		}
		catch(Exception G1)
		{
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
		    test.log(LogStatus.PASS, "no Modifier  found for cgos report Available for Date_Range_TimePeriod");
				

		}
		}

}