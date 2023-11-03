package com.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.epam.healenium.SelfHealingDriver;
import com.fasterxml.jackson.annotation.JacksonInject.Value;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExcelDataConfig;
import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Reports_Adjust_Inventory
{
public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory Reports - Adjust Inventory");
	
	LoginPage lgpg;
	public String st="NA";
	
	Utility ut=new Utility();

	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	ReportsPage repts;
	InventoryPage ip;
	
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
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Cash_Transaction_Path"));
//		//Open the Chrome window
//		driver = new ChromeDriver();
		
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
//		driver=(SelfHealingDriver) new ChromeDriver(chrOpt);

		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		
		options.setHeadless(false);
		
		WebDriver delegate=new ChromeDriver();
		
		driver=SelfHealingDriver.create(delegate);
		
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
		Open_Inventory_Reports_Adjust_Inventory_Page(driver);
		RefreshAndPaginination(driver);
		Inventory_Reports_Adjust_Inventory_For_All_Verify_Adjust_Inventory_Search(driver);
		Inventory_Reports_Verify_Adjust_Inventory_For_Inventory_Item(driver);
		Inventory_Reports_Verify_Adjust_Inventory_For_Retail_Item(driver);
		Inventory_Reports_Verify_Adjust_Inventory_For_SubREcipe(driver);
		Inventory_Reports_Adjust_Inventory_For_All_ReasonType_Adjsutment(driver);
		Inventory_Reports_Adjust_Inventory_For_All_ReasonType_Increase(driver);
		Inventory_Reports_Adjust_Inventory_For_All_ReasonType_Decrease(driver);
		Inventory_Reports_Adjust_Inventory_For_All_Today(driver);
		Inventory_Reports_Adjust_Inventory_For_All_Yesterday(driver);
		Inventory_Reports_Adjust_Inventory_For_All_Last_N_Days(driver);
		Inventory_Reports_Adjust_Inventory_For_All_This_Week(driver);
		Inventory_Reports_Adjust_Inventory_For_All_Last_Week(driver);
		Inventory_Reports_Adjust_Inventory_For_All_Last_7_Days(driver);
		Inventory_Reports_Adjust_Inventory_For_All_This_Month(driver);
		Inventory_Reports_Adjust_Inventory_For_All_Last_Month(driver);
		Inventory_Reports_Adjust_Inventory_For_All_Last_30_Days(driver);
		Inventory_Reports_Adjust_Inventory_For_All_Specific_Date(driver);
		Inventory_Reports_Adjust_Inventory_For_All_Date_Range(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Inventory_Reports_Adjust_Inventory_Page(SelfHealingDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Till Report Page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"inventoryReports/adjustInventory");

		Thread.sleep(5000);
		//Verify the Till Report Page loaded or not
		repts.Verify_ReportHomePage("ADJUST INVENTORY");
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
		
		//Ascending and Descending Sorting
//		cmp.Ascending_And_Descending_Order();
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Adjust_Inventory_For_All_Verify_Adjust_Inventory_Search(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("ALL");
	
		//Select Today
		repts.Select_Today_TimePeriod();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.PASS, "No transaction for selected time period is Displayed when Searching Invalid Driver Number");
	
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.FAIL, "No transaction for selected time period is not Displayed when Searching Invalid Driver Number");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
		}
		
		Thread.sleep(2000);
	
				//Select Type
				ip.Select_Type("Inventory Item");
			
				//Select Today
				repts.Select_Last_Month_TimePeriod();
				
				Thread.sleep(1000);
				//Click Apply
				repts.Click_ApplyButton(); 
				
				
				Thread.sleep(5000);
				try
				{
				if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
				{
					test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Selected Time Period");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception G)
				{
					
					test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Selected Time Period");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				
					
					
					
					
					String Inv_Name=driver.findElement(By.xpath("//data-grid/div/div[contains(@class,'cdk-drop-list')]/div[2]/div/data-grid-row/div/div[2]")).getText();
					
					//Select Type
					ip.Select_Type("Inventory Item");

					//Select Type
					ip.Select_InventoryItem(Inv_Name);
				
					//Select Today
					repts.Select_Last_Month_TimePeriod();
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
				
					Thread.sleep(3000);
					try
					{
					if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[2]")).getText().equalsIgnoreCase(Inv_Name))
					{
						test.log(LogStatus.PASS, "Adjust Inventory Reports is Available for Searched Inventory Item");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception l)
					{
						test.log(LogStatus.FAIL, "Adjust Inventory Reports is Not Available for Searched Inventory Item");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
					//Select Type
					ip.Select_Type("Retail Item");
				
					//Select Today
					repts.Select_Last_Month_TimePeriod();
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
					
					
					Thread.sleep(5000);
					try
					{
					if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
					{
						test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Selected Time Period");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception j)
					{
						
						test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Selected Time Period");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					
						
						
						
						
						String Retail_Name=driver.findElement(By.xpath("//data-grid/div/div[contains(@class,'cdk-drop-list')]/div[2]/div/data-grid-row/div/div[2]")).getText();
						
						//Select Type
						ip.Select_Type("Retail Item");

						//Select Type
						ip.Select_Retail_Item(Retail_Name);
					
						//Select Today
						repts.Select_Last_Month_TimePeriod();
						
						Thread.sleep(1000);
						//Click Apply
						repts.Click_ApplyButton(); 
					
						Thread.sleep(3000);
						try
						{
						if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[2]")).getText().equalsIgnoreCase(Retail_Name))
						{
							test.log(LogStatus.PASS, "Adjust Inventory Reports is Available for Searched Retail Item");
							
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
						}
						}
						catch(Exception l)
						{
							test.log(LogStatus.FAIL, "Adjust Inventory Reports is Not Available for Searched Retail Item");
							
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						
					}
				
					
					//Select Type
					ip.Select_Type("Sub Recipe");
				
					//Select Today
					repts.Select_Last_Month_TimePeriod();
					
					Thread.sleep(1000);
					//Click Apply
					repts.Click_ApplyButton(); 
					
					
					Thread.sleep(5000);
					try
					{
					if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
					{
						test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Selected Time Period");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					}
					catch(Exception G)
					{
						
						test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Selected Time Period");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					
						
						
						
						
						String SubReci_Name=driver.findElement(By.xpath("//data-grid/div/div[contains(@class,'cdk-drop-list')]/div[2]/div/data-grid-row/div/div[2]")).getText();
						
						//Select Type
						ip.Select_Type("Sub Recipe");

						//Select Type
						ip.Select_SubRecipe(SubReci_Name);
					
						//Select Today
						repts.Select_Last_Month_TimePeriod();
						
						Thread.sleep(1000);
						//Click Apply
						repts.Click_ApplyButton(); 
					
						Thread.sleep(3000);
						try
						{
						if(driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div/div[2]")).getText().equalsIgnoreCase(SubReci_Name))
						{
							test.log(LogStatus.PASS, "Adjust Inventory Reports is Available for Searched Sub Recipe");
							
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
						}
						}
						catch(Exception l)
						{
							test.log(LogStatus.FAIL, "Adjust Inventory Reports is Not Available for Searched Sub Recipe");
							
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
					}
						
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Verify_Adjust_Inventory_For_Inventory_Item(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("Inventory Item");
		
		//Select the Category Level
		ip.Select_Category_Level("ALL");
		
		//Select Inventory Item
		ip.Select_InventoryItem("ALL");
	
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
			
		//Select the Reason Type
		ip.Select_ReasonType("Select All");

		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Inventory Item");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Inventory Item");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
	
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);

			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Verify_Adjust_Inventory_For_Retail_Item(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("Retail Item");
	
		//Select the Category Level
		ip.Select_Category_Level("ALL");
				
		//Select Retail Item
		ip.Select_Retail_Item("ALL");
				
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
		
		//Select the Reason Type
		ip.Select_ReasonType("Select All");

		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Retail Item");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Retail Item");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
	
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);

			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Verify_Adjust_Inventory_For_SubREcipe(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("Sub Recipe");
		
	
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
			
		//Select the Reason Type
		ip.Select_ReasonType("Select All");

		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Sub Recipe");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Sub Recipe");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
	
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);

			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Adjust_Inventory_For_All_ReasonType_Adjsutment(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("ALL");
	
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
			
		//Select the Reason Type
		ip.Select_ReasonType("Select All");
				
		ip.Reason_Type_Adj_InvInputBox().click();
				
		//Select the Reason Type
		ip.Select_ReasonType("Select All");
				
		ip.Reason_Type_Adj_InvInputBox().click();
				
		//Select the Reason Type
		ip.Select_ReasonType("Adjustment");
				
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Reason Type - Adjustment");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Reason Type - Adjustment");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=6)
		{
			for(int i=2;i<=rowSize+1;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
	
			}
		}
		else
		{
			for(int i=2;i<=6;i++)
			{
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				


				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);

			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Adjust_Inventory_For_All_ReasonType_Increase(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("ALL");
	
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
			
		//Select the Reason Type
		ip.Select_ReasonType("Select All");
				
		ip.Reason_Type_Adj_InvInputBox().click();
		
		//Select the Reason Type
		ip.Select_ReasonType("Select All");
				
		ip.Reason_Type_Adj_InvInputBox().click();
				
		//Select the Reason Type
		ip.Select_ReasonType("Increase");
				
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Reason Type - Increase");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Reason Type - Increase");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=6)
		{
			for(int i=2;i<=rowSize+1;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
	
			}
		}
		else
		{
			for(int i=2;i<=6;i++)
			{
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				


				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);

			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Adjust_Inventory_For_All_ReasonType_Decrease(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("ALL");
	
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
			
		//Select the Reason Type
		ip.Select_ReasonType("Select All");
				
		ip.Reason_Type_Adj_InvInputBox().click();
				
		//Select the Reason Type
		ip.Select_ReasonType("Select All");
				
		ip.Reason_Type_Adj_InvInputBox().click();
				
		//Select the Reason Type
		ip.Select_ReasonType("Decrease");
				
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Reason Type - Decrease");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Reason Type - Decrease");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=6)
		{
			for(int i=2;i<=rowSize+1;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
	
			}
		}
		else
		{
			for(int i=2;i<=6;i++)
			{
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				


				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);

			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Adjust_Inventory_For_All_Today(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("ALL");

		//Select Today
		repts.Select_Today_TimePeriod();
		
		//Select the Reason Type
		ip.Select_ReasonType("Select All");
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(8000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Today");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Today");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
//			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
//			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
			
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);

			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				
		
				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
	
			}
		}
		
		}
	}

	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Adjust_Inventory_For_All_Yesterday(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("ALL");

		//Select Today
		repts.Select_Yesterday_TimePeriod();
			
		//Select the Reason Type
		ip.Select_ReasonType("Select All");
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Yesterday");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Yesterday");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);

			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				
		
				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
			
			}
		}
	
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Adjust_Inventory_For_All_Last_N_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("ALL");
	
		//Select Today
		repts.Select_Last_N_Days_TimePeriod(Utility.getProperty("NumberOfDays"));

		//Select the Reason Type
		ip.Select_ReasonType("Select All");
				
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 

		Thread.sleep(5000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Last 'N' days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Last 'N' days");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
	
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				
			
				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
		
			}
		}
	
		}
	}

	
	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Adjust_Inventory_For_All_This_Week(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("ALL");

		//Select Today
		repts.Select_This_Week_TimePeriod();

		//Select the Reason Type
		ip.Select_ReasonType("Select All");

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 

		Thread.sleep(5000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for This Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Adjust Inventory Reports Available for This Week");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
			
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
		
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				
	
				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
		
			}
		}
			
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Adjust_Inventory_For_All_Last_Week(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("ALL");

		//Select Today
		repts.Select_Last_Week_TimePeriod();

		//Select the Reason Type
		ip.Select_ReasonType("Select All");
				
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Last Week");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Last Week");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);

			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				
	
				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
		
			}
		}
	
		}
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Adjust_Inventory_For_All_Last_7_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("ALL");
	
		//Select Today
		repts.Select_Last_7_Days_TimePeriod();
	
		//Select the Reason Type
		ip.Select_ReasonType("Select All");
				
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Last 7 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Last 7 Days");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);

			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				
			
				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
	
			}
		}
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Adjust_Inventory_For_All_This_Month(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("ALL");

		//Select Today
		repts.Select_This_Month_TimePeriod();
		
		//Select the Reason Type
		ip.Select_ReasonType("Select All");
	
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for This Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Adjust Inventory Reports Available for This Month");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
	
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);

			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);

			}
		}

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Adjust_Inventory_For_All_Last_Month(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("ALL");

		//Select Today
		repts.Select_Last_Month_TimePeriod();
		
		//Select the Reason Type
		ip.Select_ReasonType("Select All");

		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Last Month");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Last Month");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				
		
				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
	
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				
	
				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);

			}
		}

		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Adjust_Inventory_For_All_Last_30_Days(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("ALL");

		//Select Today
		repts.Select_Last_30_Days_TimePeriod();
				
		//Select the Reason Type
		ip.Select_ReasonType("Select All");
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Last 30 Days");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Last 30 Days");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);

			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				
		
				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
				
				
			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Adjust_Inventory_For_All_Specific_Date(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("ALL");

		//Select Today
		repts.Select_Specific_Date_TimePeriod(Utility.getProperty("Report_Specific_Date"));
			
		//Select the Reason Type
		ip.Select_ReasonType("Select All");
				
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Specific Date");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Specific Date");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
		

				
				
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
				
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				
		
				
				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);

				
				
			}
		}
		
		
	
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Reports_Adjust_Inventory_For_All_Date_Range(SelfHealingDriver driver) throws Exception
	{
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		ip=new InventoryPage(driver, test);
		
		//Select Type
		ip.Select_Type("ALL");
	
		//Select Today
		repts.Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
			
		//Select the Reason Type
		ip.Select_ReasonType("Select All");
				
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton(); 
		
		
		Thread.sleep(5000);
		try
		{
		if(ip.No_Adjust_Inventory_ReportFoundInfoMessage().isDisplayed())
		{
			test.log(LogStatus.INFO, "Adjust Inventory Reports Not Available for Date Range");
	
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Adjust Inventory Reports Available for Date Range");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);
			
			Thread.sleep(2000);
			//Do pagination to Last
			repts.Do_Pagination();
			
			
			List<WebElement> rowList=driver.findElements(By.xpath("//div[@class='data-grid']/div[3]/div/div/data-grid-row"));
		
			int rowSize=rowList.size();
			
			
		if(rowSize<=5)
		{
			for(int i=1;i<=rowSize;i++)
			{
			
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
			
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				
				

				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);
	
			}
		}
		else
		{
			for(int i=1;i<=5;i++)
			{
				String Item_Name=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[2]")).getText();
				
				String Type=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[4]")).getText();
		
				String From_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[5]")).getText();
	
				String To_Quantity=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[6]")).getText();

				String Difference=driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div["+i+"]/div/data-grid-row/div/div[7]")).getText();
				


				test.log(LogStatus.INFO, "Adjusted Item Name is : "+Item_Name+" Type : "+Type+" From Quantity : "+From_Quantity+" To Quantity : "+To_Quantity+" Difference is : "+Difference);

			}
		}
		
		
	
		}
	}
}
