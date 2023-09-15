package com.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
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

import com.Pages.ReportsPage;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Reports_Membership_Summary_Report 
{
	
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Reports - Membership Summary Report");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();

	String st = "NA";
	
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	ReportsPage repts;
	
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
		
		Thread.sleep(60000);
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
		Open_Membership_Summary_Report_Page(driver);
//		RefreshAndPaginination(driver);
		Membership_Summary_Sale_Report(driver);

	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Membership_Summary_Report_Page(WebDriver driver) throws Exception
	{
		
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(10000);
		//Load the Sale Summarys report page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"membershipReport/membershipSummary");

		Thread.sleep(5000);
		//Verify the membership Summary report page loeded or not
		repts.Verify_ReportHomePage("MEMBERSHIP SUMMARY");
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
//		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Membership_Summary_Sale_Report(WebDriver driver) throws Exception
	{
		for(int i = 1;i<=10;i++){driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);}
		Thread.sleep(1000);
		repts=new ReportsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		Thread.sleep(2000);	
		//Click the customer label
		driver.findElement(By.xpath("//span[contains(.,'Customer')]/../input")).click();
		Thread.sleep(500);	
		//Select the All option
		driver.findElement(By.xpath("//select-option[contains(.,'All')]")).click();
		
		Thread.sleep(2000);	
		//Click the membership plan label
		driver.findElement(By.xpath("//span[contains(.,'Membership Plan')]/../input")).click();
		Thread.sleep(500);	
		//Select the first option
		driver.findElement(By.xpath("//select-option")).click();
				
		Thread.sleep(1000);	
		//Click the time period label
		driver.findElement(By.xpath("//label[contains(.,'Time Period')]/../../input")).click();
		Thread.sleep(500);
		
		List<WebElement> timeList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int TimeSize=timeList.size();
		
		
		int randomMonth=ThreadLocalRandom.current().nextInt(1, TimeSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomMonth+"]/select-option")).click();

		
		
		
		
		Thread.sleep(1000);	
		//Click the year label
		driver.findElement(By.xpath("//span[contains(.,'Year')]/../input")).click();
		Thread.sleep(500);
		
		List<WebElement> yearList=driver.findElements(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div/select-option"));
		
		int yearSize=yearList.size();
		
		
		int randomYear=ThreadLocalRandom.current().nextInt(1, yearSize);
		
		
		driver.findElement(By.xpath("//div[@class='cdk-virtual-scroll-content-wrapper']/div["+randomYear+"]/select-option")).click();
		
		Thread.sleep(1000);
		//Click Apply
		repts.Click_ApplyButton();
		
		
		Thread.sleep(8000);
		try
		{
			if(repts.No_TransactionFound_InfoMessage().isDisplayed())
			{
				test.log(LogStatus.INFO, "Membership Summary report is not available for the mentioned time period");
			}
		}
		catch(Exception G)
		{	
			test.log(LogStatus.INFO, "Membership Summary report is available for the mentioned time period");				
		}
	}

}
