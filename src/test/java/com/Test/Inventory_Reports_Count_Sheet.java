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
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.epam.healenium.SelfHealingDriver;
import com.Pages.InventoryReports_CountSheet_Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Reports_Count_Sheet 
{
public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Invnetory-Reports-CountSheet");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();

	String st = "NA";
	
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	ReportsPage repts;
	InventoryReports_CountSheet_Page csp;
	
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
		//System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
		//Open the Chrome window
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = (SelfHealingDriver) new ChromeDriver(chromeOptions);
		//Wait for 30 seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//Maximize the Chrome window
		driver.manage().window().maximize();
		Thread.sleep(1000);
		//Launch the URL
		driver.get(Utility.getProperty("appURL"));

		Thread.sleep(30000);
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
		Open_CountSheet_ReportPage(driver);
		RefreshAndPaginination(driver);
		Count_Sheet_Report_Select_Type_Storage_Location_All(driver);
		Count_Sheet_Report_Select_Type_All_Storage_Location(driver);
		Count_Sheet_Report_Type_Inventory_Item(driver);
		Count_Sheet_Report_Type_Inventory_Item_Category_Level_Category(driver);
		Count_Sheet_Report_Type_Inventory_Item_Category_Level_SubCategory(driver);
		Count_Sheet_Report_Type_Inventory_Item_Select_Category_And_InventoryItem(driver);
		Count_Sheet_Report_Type_Inventory_Item_Category_Level_SubCategory_Select_Category_SubCategory_InventoryItem(driver);
		Count_Sheet_Report_Type_Retail_Item(driver);
		Count_Sheet_Report_Type_Retail_Item_Category_Level_Category(driver);
		Count_Sheet_Report_Type_Retail_Item_Category_Level_SubCategory(driver);
		Count_Sheet_Report_Type_Retail_Item_Select_Category_And_RetailItem(driver);
		Count_Sheet_Report_Type_Retail_Item_Category_Level_SubCategory_Select_Category_SubCategory_RetailItem(driver);
		Count_Sheet_Report_Type_Sub_Recipe(driver);
		Count_Sheet_Report_Type_MenuItem(driver);
		
	}
	
	@Test(priority=3,enabled = false )
   public void Open_CountSheet_ReportPage(SelfHealingDriver driver) throws Exception
	{
		cmp = new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Upcharge page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"inventoryReports/countSheet");

		Thread.sleep(5000);
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
		
		//Refresh and Pagination
		driver.findElement(By.xpath("(//div[@id='selectbox-component'])[3]")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//div[@class='options with-height']//select-option[2]")).click();
		
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Count_Sheet_Report_Select_Type_Storage_Location_All(SelfHealingDriver driver) throws Exception 
	{
	   
		cmp=new Common_XPaths(driver, test);
		csp = new InventoryReports_CountSheet_Page(driver, test);
	    repts = new ReportsPage(driver, test);
	    
	    csp.Select_Type_All();
	    
	    Thread.sleep(5000);
	    
	   csp.Select_Storage_Location_All();
	   
	   repts.Click_ApplyButton();
	   
	   Thread.sleep(25000);
		try
		{
			if(csp.No_CountsheetFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Count sheet not available for StorageLocation and Type all");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Count sheet available for StorageLocation and Type as all");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			System.out.println(colList.size());
			
			for(int i =1;i<=colList.size();i++) 
			{
				test.log(LogStatus.INFO, "Available data: "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+", value is available for the mentioned Types : "+driver.findElement(By.xpath("(//data-grid-row/div)["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
		
	}
	
	@Test(priority = 6,enabled = false)
	public void Count_Sheet_Report_Select_Type_All_Storage_Location(SelfHealingDriver driver) throws Exception
	{

		cmp=new Common_XPaths(driver, test);
		csp = new InventoryReports_CountSheet_Page(driver, test);
	    repts = new ReportsPage(driver, test);
	    
	    csp.Select_Type_All();
	    
	    Thread.sleep(5000);
	    
	   csp.Select_Storage_Location();
	   
	   repts.Click_ApplyButton();
	   
	   Thread.sleep(25000);
		try
		{
			if(csp.No_CountsheetFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Count sheet not available for Type all and Random Storage Location");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Count sheet available for StorageLocation and Type as all");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			System.out.println(colList.size());
			
			for(int i =1;i<=colList.size();i++) 
			{
				test.log(LogStatus.INFO, "Available Data:"+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+", value is available for the mentioned Types : "+driver.findElement(By.xpath("(//data-grid-row/div)["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
		
	}
	
	@Test(priority = 7,enabled = false)
	public void Count_Sheet_Report_Type_Inventory_Item(SelfHealingDriver driver) throws Exception 
	{
		
        cmp=new Common_XPaths(driver, test);
		csp = new InventoryReports_CountSheet_Page(driver, test);
	    repts = new ReportsPage(driver, test);
	    
	    csp.Select_Type_Inventory_Item();
	    
	    Thread.sleep(4000);
	    
	   csp.Select_Storage_Location();
	   
	   repts.Click_ApplyButton();
	   
	   Thread.sleep(25000);
		try
		{
			if(csp.No_CountsheetFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Count sheet not available for Type Inventory Item");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Count sheet available for Type Inventory Item");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			System.out.println(colList.size());
			
			for(int i =1;i<=colList.size();i++) 
			{
				test.log(LogStatus.INFO, "Available data :"+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+", value is available for the mentioned Types : "+driver.findElement(By.xpath("(//data-grid-row/div)["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	@Test(priority = 8,enabled = false)
	public void Count_Sheet_Report_Type_Inventory_Item_Category_Level_Category(SelfHealingDriver driver) throws Exception
	{

        cmp=new Common_XPaths(driver, test);
		csp = new InventoryReports_CountSheet_Page(driver, test);
	    repts = new ReportsPage(driver, test);
	    
	    csp.Select_Type_Inventory_Item();
	    
	    Thread.sleep(4000);
	    
	   csp.Select_Storage_Location();
	   
	   Thread.sleep(2000);
	   
	   csp.Select_Category_Level_As_Category();
	   
	   repts.Click_ApplyButton();
	   
	   Thread.sleep(25000);
		try
		{
			if(csp.No_CountsheetFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Count sheet not available for Type Inventory Item");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Count sheet available for Type Inventory Item and Category level as Category");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			System.out.println(colList.size());
			
			for(int i =1;i<=colList.size();i++) 
			{
				test.log(LogStatus.INFO, "Available data: "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+", value is available for the mentioned Types : "+driver.findElement(By.xpath("(//data-grid-row/div)["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
		
	}
	
	@Test(priority = 9,enabled = false)
	public void Count_Sheet_Report_Type_Inventory_Item_Category_Level_SubCategory(SelfHealingDriver driver) throws Exception
	{
		 cmp=new Common_XPaths(driver, test);
			csp = new InventoryReports_CountSheet_Page(driver, test);
		    repts = new ReportsPage(driver, test);
		    
		    csp.Select_Type_Inventory_Item();
		    
		    Thread.sleep(4000);
		    
		   csp.Select_Storage_Location();
		   
		   Thread.sleep(2000);
		   
		   csp.Select_Category_Level_As_SubCategory();
		   
		   repts.Click_ApplyButton();
		   
		   Thread.sleep(25000);
			try
			{
				if(csp.No_CountsheetFound_InfoMessage().isDisplayed())
				{
					test.log(LogStatus.INFO, "Count sheet not available for Type Inventory Item");
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
			}
			catch(Exception G)
			{
				
				test.log(LogStatus.PASS, "Count sheet available for Type Inventory Item and Category level as SubCategory");

				
				Thread.sleep(2000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.END);

				
				Thread.sleep(3000);
				//Get Sale Amount
				//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

				List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
				System.out.println(colList.size());
				
				for(int i =1;i<=colList.size();i++) 
				{
					test.log(LogStatus.INFO, "Available data: "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+", value is available for the mentioned Types : "+driver.findElement(By.xpath("(//data-grid-row/div)["+i+"]")).getText());
				}

				ut.PassedCaptureScreenshotAsBASE64(driver, test);
				Thread.sleep(3000);

			}
		
	}
	
	public void Count_Sheet_Report_Type_Inventory_Item_Select_Category_And_InventoryItem(SelfHealingDriver driver) throws Exception 
	{
		cmp=new Common_XPaths(driver, test);
		csp = new InventoryReports_CountSheet_Page(driver, test);
	    repts = new ReportsPage(driver, test);
	    
	    csp.Select_Type_Inventory_Item();
	    
	    Thread.sleep(4000);
	    
	   csp.Select_Storage_Location();
	   
	   Thread.sleep(2000);
	   
	   csp.Select_Category_Level_As_Category();
	   
	   //select Category
	   driver.findElement(By.xpath("(//input[@placeholder='Select Item Type'])[4]")).click();
	   
	   Thread.sleep(500);
	   
	   driver.findElement(By.xpath("//div[@class='options with-height']//div/div[5]/select-option")).click();
	   
	   //Select Inventory Item
	   driver.findElement(By.xpath("(//input[@placeholder='Select Item Type'])[5]")).click();
	   
	   Thread.sleep(500);
	   
	   driver.findElement(By.xpath("//div[@class='options with-height']//div/div[2]/select-option")).click();
	   
	   repts.Click_ApplyButton();
	   
	   Thread.sleep(25000);
		try
		{
			if(csp.No_CountsheetFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Count sheet not available for Type Retail Item");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Count sheet available for Type Inventory Item and Category level as SubCategory");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			System.out.println(colList.size());
			
			for(int i =1;i<=colList.size();i++) 
			{
				test.log(LogStatus.INFO, "Available data: "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+", value is available for the mentioned Types : "+driver.findElement(By.xpath("(//data-grid-row/div)["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	
	}
	
	public void Count_Sheet_Report_Type_Inventory_Item_Category_Level_SubCategory_Select_Category_SubCategory_InventoryItem(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		csp = new InventoryReports_CountSheet_Page(driver, test);
	    repts = new ReportsPage(driver, test);
	    
	    csp.Select_Type_Inventory_Item();
	    
	    Thread.sleep(4000);
	    
	   csp.Select_Storage_Location();
	   
	   Thread.sleep(2000);
	   
	   csp.Select_Category_Level_As_SubCategory();
	   
	   //select category
	   
	   driver.findElement(By.xpath("(//input[@placeholder='Select Item Type'])[4]")).click();
	   
	   Thread.sleep(500);
	   
	   driver.findElement(By.xpath("//div[@class='options with-height']//div/div[5]/select-option")).click();
	   
	   //Select SubCategory
	   driver.findElement(By.xpath("(//input[@placeholder='Select Item Type'])[5]")).click();
	   
	   Thread.sleep(500);
	   
	   driver.findElement(By.xpath("//div[@class='options with-height']//div/div[2]/select-option")).click();
	   
	   //select Inventory Item
       driver.findElement(By.xpath("(//input[@placeholder='Select Item Type'])[6]")).click();
	   
	   Thread.sleep(500);
	   
	   driver.findElement(By.xpath("//div[@class='options with-height']//div/div[1]/select-option")).click();
	   
	   repts.Click_ApplyButton();
	   
	   Thread.sleep(25000);
		try
		{
			if(csp.No_CountsheetFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Count sheet not available for Type Retail Item");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Count sheet available for Type Inventory Item and Category level as SubCategory");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			System.out.println(colList.size());
			
			for(int i =1;i<=colList.size();i++) 
			{
				test.log(LogStatus.INFO, "Available data: "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+", value is available for the mentioned Types : "+driver.findElement(By.xpath("(//data-grid-row/div)["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}

	public void Count_Sheet_Report_Type_Retail_Item(SelfHealingDriver driver) throws Exception 
	{
		cmp=new Common_XPaths(driver, test);
		csp = new InventoryReports_CountSheet_Page(driver, test);
	    repts = new ReportsPage(driver, test);
	    
	    csp.Select_Type_Retail_Item();
	    
	    Thread.sleep(4000);
	    
	   csp.Select_Storage_Location();
	   
	   repts.Click_ApplyButton();
	   
	   Thread.sleep(25000);
		try
		{
			if(csp.No_CountsheetFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Count sheet not available for Type Retail Item");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Count sheet available for Type Retail Item");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			System.out.println(colList.size());
			
			for(int i =1;i<=colList.size();i++) 
			{
				test.log(LogStatus.INFO, "Available data :"+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+", value is available for the mentioned Types : "+driver.findElement(By.xpath("(//data-grid-row/div)["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
		
	}

	public void Count_Sheet_Report_Type_Retail_Item_Category_Level_Category(SelfHealingDriver driver) throws Exception 
	{
		
		cmp=new Common_XPaths(driver, test);
		csp = new InventoryReports_CountSheet_Page(driver, test);
	    repts = new ReportsPage(driver, test);
	    
	    csp.Select_Type_Retail_Item();
	    
	    Thread.sleep(4000);
	    
	   csp.Select_Storage_Location();
	   
	   Thread.sleep(2000);
	   
	   csp.Select_Category_Level_As_Category();
	   
	   repts.Click_ApplyButton();
	   
	   Thread.sleep(25000);
		try
		{
			if(csp.No_CountsheetFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Count sheet not available for Type Retail Item");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Count sheet available for Type Retail Item and Category level as Category");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			System.out.println(colList.size());
			
			for(int i =1;i<=colList.size();i++) 
			{
				test.log(LogStatus.INFO, "Available data: "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+", value is available for the mentioned Types : "+driver.findElement(By.xpath("(//data-grid-row/div)["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	public void Count_Sheet_Report_Type_Retail_Item_Category_Level_SubCategory(SelfHealingDriver driver) throws Exception 
	{
		cmp=new Common_XPaths(driver, test);
		csp = new InventoryReports_CountSheet_Page(driver, test);
	    repts = new ReportsPage(driver, test);
	    
	    csp.Select_Type_Retail_Item();
	    
	    Thread.sleep(4000);
	    
	   csp.Select_Storage_Location();
	   
	   Thread.sleep(2000);
	   
	   csp.Select_Category_Level_As_SubCategory();
	   
	   repts.Click_ApplyButton();
	   
	   Thread.sleep(25000);
		try
		{
			if(csp.No_CountsheetFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Count sheet not available for Type Retail Item");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Count sheet available for Type Retail Item and Category level as SubCategory");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			System.out.println(colList.size());
			
			for(int i =1;i<=colList.size();i++) 
			{
				test.log(LogStatus.INFO, "Available data: "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+", value is available for the mentioned Types : "+driver.findElement(By.xpath("(//data-grid-row/div)["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
		
	}
	
	public void Count_Sheet_Report_Type_Retail_Item_Select_Category_And_RetailItem(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		csp = new InventoryReports_CountSheet_Page(driver, test);
	    repts = new ReportsPage(driver, test);
	    
	    csp.Select_Type_Retail_Item();
	    
	    Thread.sleep(4000);
	    
	   csp.Select_Storage_Location();
	   
	   Thread.sleep(2000);
	   
	   csp.Select_Category_Level_As_Category();
	   
	   //select Category
	   driver.findElement(By.xpath("(//input[@placeholder='Select Item Type'])[4]")).click();
	   
	   Thread.sleep(500);
	   
	   driver.findElement(By.xpath("//div[@class='options with-height']//div/div[5]/select-option")).click();
	   
	   //Select Retail Item
	   driver.findElement(By.xpath("(//input[@placeholder='Select Item Type'])[5]")).click();
	   
	   Thread.sleep(500);
	   
	   driver.findElement(By.xpath("//div[@class='options with-height']//div/div[2]/select-option")).click();
	   
	   repts.Click_ApplyButton();
	   
	   Thread.sleep(25000);
		try
		{
			if(csp.No_CountsheetFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Count sheet not available for Type Retail Item");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Count sheet available for Type Retail Item and Category level as SubCategory");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			System.out.println(colList.size());
			
			for(int i =1;i<=colList.size();i++) 
			{
				test.log(LogStatus.INFO, "Available data: "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+", value is available for the mentioned Types : "+driver.findElement(By.xpath("(//data-grid-row/div)["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	public void Count_Sheet_Report_Type_Retail_Item_Category_Level_SubCategory_Select_Category_SubCategory_RetailItem(SelfHealingDriver driver) throws Exception 
	{
		
		cmp=new Common_XPaths(driver, test);
		csp = new InventoryReports_CountSheet_Page(driver, test);
	    repts = new ReportsPage(driver, test);
	    
	    csp.Select_Type_Retail_Item();
	    
	    Thread.sleep(4000);
	    
	   csp.Select_Storage_Location();
	   
	   Thread.sleep(2000);
	   
	   csp.Select_Category_Level_As_SubCategory();
	   
	   //select category
	   
	   driver.findElement(By.xpath("(//input[@placeholder='Select Item Type'])[4]")).click();
	   
	   Thread.sleep(500);
	   
	   driver.findElement(By.xpath("//div[@class='options with-height']//div/div[5]/select-option")).click();
	   
	   //Select SubCategory
	   driver.findElement(By.xpath("(//input[@placeholder='Select Item Type'])[5]")).click();
	   
	   Thread.sleep(500);
	   
	   driver.findElement(By.xpath("//div[@class='options with-height']//div/div[2]/select-option")).click();
	   
	   //select Retail Item
       driver.findElement(By.xpath("(//input[@placeholder='Select Item Type'])[6]")).click();
	   
	   Thread.sleep(500);
	   
	   driver.findElement(By.xpath("//div[@class='options with-height']//div/div[2]/select-option")).click();
	   
	   repts.Click_ApplyButton();
	   
	   Thread.sleep(25000);
		try
		{
			if(csp.No_CountsheetFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Count sheet not available for Type Retail Item");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Count sheet available for Type Retail Item and Category level as SubCategory");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			System.out.println(colList.size());
			
			for(int i =1;i<=colList.size();i++) 
			{
				test.log(LogStatus.INFO, "Available data: "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+", value is available for the mentioned Types : "+driver.findElement(By.xpath("(//data-grid-row/div)["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);

		}
	}
	
	public void Count_Sheet_Report_Type_Sub_Recipe(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		csp = new InventoryReports_CountSheet_Page(driver, test);
	    repts = new ReportsPage(driver, test);
	    
	    csp.Select_Type_Retail_Item();
	    
	    Thread.sleep(4000);
	    
	   csp.Select_Storage_Location();
	   
	   Thread.sleep(2000);
	   
	 //select Sub Recipe
       driver.findElement(By.xpath("(//input[@placeholder='Select Item Type'])[3]")).click();
	   
	   Thread.sleep(500);
	   
	   driver.findElement(By.xpath("//div[@class='options with-height']//div/div[2]/select-option")).click();
	   
	   repts.Click_ApplyButton();
	   
	   Thread.sleep(25000);
		try
		{
			if(csp.No_CountsheetFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Count sheet not available for Type Sub Recipe");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Count sheet available for Type Sub Recipe");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			System.out.println(colList.size());
			
			for(int i =1;i<=colList.size();i++) 
			{
				test.log(LogStatus.INFO, "Available data: "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+", value is available for the mentioned Types : "+driver.findElement(By.xpath("(//data-grid-row/div)["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	   
	}
	
	
	public void Count_Sheet_Report_Type_MenuItem(SelfHealingDriver driver) throws Exception 
	{
		cmp=new Common_XPaths(driver, test);
		csp = new InventoryReports_CountSheet_Page(driver, test);
	    repts = new ReportsPage(driver, test);
	    
	    csp.Select_Type_Retail_Item();
	    
	    Thread.sleep(4000);
	    
	   csp.Select_Storage_Location();
	   
	   Thread.sleep(2000);
	   
 repts.Click_ApplyButton();
	   
	   Thread.sleep(25000);
		try
		{
			if(csp.No_CountsheetFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Count sheet not available for Type Menu Item");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception G)
		{
			
			test.log(LogStatus.PASS, "Count sheet available for Type Menu Item");

			
			Thread.sleep(2000);
			driver.findElement(By.tagName("html")).sendKeys(Keys.END);

			
			Thread.sleep(3000);
			//Get Sale Amount
			//List<WebElement> rowList=driver.findElements(By.xpath("//data-grid/div/div/div/div[@class='content-container']/data-grid-row"));

			List<WebElement> colList=driver.findElements(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div"));
			System.out.println(colList.size());
			
			for(int i =1;i<=colList.size();i++) 
			{
				test.log(LogStatus.INFO, "Available data: "+driver.findElement(By.xpath("//div[contains(@class,'data-grid-headers')]/div/data-grid-row/div/div["+i+"]")).getText()+", value is available for the mentioned Types : "+driver.findElement(By.xpath("(//data-grid-row/div)["+i+"]")).getText());
			}

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			Thread.sleep(3000);
		}
	   
		
	}


}
