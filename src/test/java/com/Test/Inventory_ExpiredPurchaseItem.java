package com.Test;

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
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_ExpiredPurchaseItem {
	
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Expired Purchase Item");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	InventoryPage air;
	
	
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
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver(chrOpt);
		
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
		Open_Sub_Recipe_Page(driver);
     	RefreshAndPaginination_ColumnFilteration(driver);
     	Verify_Detected_Purchase(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Sub_Recipe_Page(WebDriver driver) throws Exception
	{
		
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"purchases");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Purchases");	
		
		Thread.sleep(1000);
		JavascriptExecutor js3=(JavascriptExecutor)driver;
		WebElement menuEle3=driver.findElement(By.xpath("//span[.='Expired Purchase Item']"));
		js3.executeScript("arguments[0].scrollIntoView(true);", menuEle3);

		menuEle3.click();
		
		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Expired Purchase Item");	
		
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
	public void Verify_Detected_Purchase(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		List<WebElement> web = driver.findElements(By.xpath("//div[contains(@id,'cdk-drop-list')]/div/div/data-grid-row/div/div[10]"));
		
	    int h = web.size();
	    System.out.println(h);
	for(int i=1;i<=h;i++)
	   if(driver.findElement(By.xpath("//div[contains(@id,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[10]")).getText().equals("Not Deducted")) {
	
	
      driver.findElement(By.xpath("//div[contains(@id,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[11]")).click();
      
      if(driver.findElement(By.xpath("//p[contains(.,'Are you sure you want to delete this item?')]")).isDisplayed()) {
    	  
    	  driver.findElement(By.xpath("//div[contains(@class,'row justify')]/div/button[contains(.,'Cancel')]")).click();
    	  
    	  test.log(LogStatus.PASS, "Able to click on Cancel button");
    		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
      }
      
      driver.findElement(By.xpath("//div[contains(@id,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[11]")).click();
      
      if(driver.findElement(By.xpath("//p[contains(.,'Are you sure you want to delete this item?')]")).isDisplayed()) {
    	  
    	  driver.findElement(By.xpath("//button[contains(.,'Close')]")).click();
  		    test.log(LogStatus.PASS, "Able to click on close button");
  		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
      }
      /*
      driver.findElement(By.xpath("//div[contains(@id,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[11]")).click();
      
      if(driver.findElement(By.xpath("//p[contains(.,'Are you sure you want to delete this item?')]")).isDisplayed()) {
    	  
    	  driver.findElement(By.xpath("//div[contains(@class,'row justify')]/div/button[contains(.,'Delete')]")).click();
    	  
  		//Check whether the New Course Saved or not
  		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Expired Stock Deducted!."))
  		{
  			test.log(LogStatus.PASS, "Expired Stock Deducted Displayed");
  		
  			ut.PassedCaptureScreenshotAsBASE64(driver, test);
  		}
  		else
  		{
  			test.log(LogStatus.FAIL, "Expired Stock Deducted not Displayed");
  			
  			ut.FailedCaptureScreenshotAsBASE64(driver, test);
  		}
      }
      
      */
      
	}
	
	
	}
	
}