package com.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.Pages.Settings_Till_Setting_Page;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Till_Settings 
{
public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Till Settings");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp=new Common_XPaths(driver, test);
	LoginTest a=new LoginTest();
	
	Settings_Till_Setting_Page tsp;
	
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
//		ChromeOptions chromeOptions = new ChromeOptions();
//		chromeOptions.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
//		driver = new ChromeDriver(chromeOptions);
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
		Open_TillSettings_Page(driver);
		verifyAutomaticGlobalTill(driver);
		verifyForceCashOutAtClockOut(driver);
		verifyRestrictPartialPayments(driver);
		verifyAddBankDeposit(driver);
		verifyTheDenominationsUI(driver);
		verifyTheDenominationsSearch(driver);
		verifyTheDenominationsPagination(driver);
		verifyTheDenominationsDeletion(driver);
		verifyTheCloseTill_UI(driver);
	}
	
	@Test(priority = 3,enabled = false,description="Navigate the application to the Till Settings page")
	public void Open_TillSettings_Page(SelfHealingDriver driver) throws Exception
	{
		tsp = new Settings_Till_Setting_Page(driver, test);
		//Thread.sleep(5000);		
		Thread.sleep(15000);
		
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"till-Settings");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(8000);
		
		tsp.verify_TillSettings_Page();
	}
	
	@Test(priority = 4,enabled = false,description="Verify the Automatic Global Till and its field in the Till Settings page")
	public void verifyAutomaticGlobalTill(SelfHealingDriver driver) throws Exception
	{
		tsp = new Settings_Till_Setting_Page(driver, test);
		tsp.automaticGlobalTill();
	}
	
	@Test(priority = 5,enabled = false,description="Verify the Force Cash Out at Clock Out toggle in the Till Settings page")
	public void verifyForceCashOutAtClockOut(SelfHealingDriver driver) throws Exception
	{
		tsp = new Settings_Till_Setting_Page(driver, test);
		tsp.forceCashOutatClockOut();
	}
	
	@Test(priority = 6,enabled = false,description="Verify the Restrict Partial Payment toggle in the Till Settings page")
	public void verifyRestrictPartialPayments(SelfHealingDriver driver) throws Exception
	{
		tsp = new Settings_Till_Setting_Page(driver, test);
		tsp.restrictPartialPaymnets();
	}
	
	@Test(priority = 7,enabled = false,description="Verify the Bank Deposite(With valid and invalid amount) in the Till Settings page")
	public void verifyAddBankDeposit(SelfHealingDriver driver) throws Exception
	{
		Thread.sleep(15000);
		tsp = new Settings_Till_Setting_Page(driver, test);
		tsp.AddBankDeposit();
		tsp.click_CancelBtn_Of_NewDeposite();
		Thread.sleep(8000);
		tsp.AddBankDeposit();
		tsp.click_CloseBtn_Of_NewDeposite();
		Thread.sleep(15000);
		tsp.AddBankDeposit();
		tsp.enterTheNewInvalidDepositAmount();
		tsp.enterTheNewDepositAmount();
		tsp.selectTheBusinessDate();
		Thread.sleep(3000);
		tsp.click_SaveBtn_Of_NewDeposite();
		Thread.sleep(2000);
		
		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s.equals("Cash flow updated successfully"))
		{
			test.log(LogStatus.PASS, "Bank deposit added successfully");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Bank deposit added failed");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		tsp.Click_Save();
		
		String s1 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		Thread.sleep(500);
		//Check whether the success message is displayed
		if(s1.equals("Till Settings Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Saved message displayed successfully when user click the save button of Till Settings");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Saved message displayed faild when user click the save button of Till Settings");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 8,enabled = false,description="Verify the Denomination in the Till Settings page")
	public void verifyTheDenominationsUI(SelfHealingDriver driver) throws Exception
	{
		Thread.sleep(8000);
		tsp = new Settings_Till_Setting_Page(driver, test);
		tsp.clickTheDenominationsBtn();
		Thread.sleep(3000);
		tsp.clickTheNewDenomination();
		Thread.sleep(3000);
		tsp.click_CancelBtn_Of_NewDeposite();
		tsp.clickTheNewDenomination();
		Thread.sleep(3000);
		tsp.click_CloseBtn_Of_NewDeposite();
		tsp.clickTheNewDenomination();
		Thread.sleep(5000);
		tsp.click_SaveBtn_Of_NewDeposite();
		tsp.saveDisabled();
		
		tsp.validDisplayName();
		tsp.emptyDenominationAmount();
		Thread.sleep(1000);
		tsp.click_SaveBtn_Of_NewDeposite();
		
		String s2 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		Thread.sleep(500);
		//Check whether the error message is displayed
		if(s2.equals("Please Enter Amount"))
		{
			test.log(LogStatus.PASS, "Please Enter Amount warning message is displayed, when user click the save button without Amount");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Amount warning message is displayed, when user click the save button without Amount");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Click the close button of warning message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		
		tsp.validDenominationAmount();Thread.sleep(1000);
		
		tsp.click_SaveBtn_Of_NewDeposite();
		
		String s3 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		Thread.sleep(500);
		//Check whether the error message is displayed
		if(s3.equals("Denomination Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Denomination Saved Successfully message is displayed when user enter the valid name and amount");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Denomination Saved Successfully message is not displayed when user enter the valid name and amount");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Click the close button of warning message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(2000);
		
		//get the text of first row denomination
		String a1 = driver.findElement(By.xpath("//div[@class='data-grid']/div[3]/div[1]/div/data-grid-row/div[1]/div/span")).getText();
		
		tsp.clickTheNewDenomination();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//mat-label[contains(.,'Display Name')]/../../../input")).clear();
		//Enter the already existing denomination name
		driver.findElement(By.xpath("//mat-label[contains(.,'Display Name')]/../../../input")).sendKeys(a1);
		
		tsp.validDenominationAmount();Thread.sleep(1000);
		
		tsp.click_SaveBtn_Of_NewDeposite();
		
		String s5 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		Thread.sleep(500);
		//Check whether the error message is displayed
		if(s5.equals("Error in validation"))
		{
			test.log(LogStatus.PASS, "Error in validation message is displayed while user enter the existing denomination name");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Error in validation message is not displayed while user enter the existing denomination name Or wrong warning message is displayed and the message is : "+s5);
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Click the close button of warning message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		
		driver.findElement(By.xpath("//mat-label[contains(.,'Display Name')]/../../../input")).clear();
		//Enter the already existing denomination name
		driver.findElement(By.xpath("//mat-label[contains(.,'Display Name')]/../../../input")).sendKeys(RandomStringUtils.randomAlphabetic(26));

		Thread.sleep(2000);
			
		//get the value of entered string
		String s6 = driver.findElement(By.xpath("//mat-label[contains(.,'Display Name')]/../../../input")).getAttribute("value");
		
		if(s6.length() <= 25)
		{
			test.log(LogStatus.PASS, "Display name field accept only 25 characters");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(s6.length() > 25)
		{
			test.log(LogStatus.FAIL, "Display name field accept more than 25 characters");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			//clear the display name field
			driver.findElement(By.xpath("//mat-label[contains(.,'Display Name')]/../../../input")).clear();
			
			tsp.validDisplayName();Thread.sleep(1000);
		}
		
		tsp.click_SaveBtn_Of_NewDeposite();
		
		Thread.sleep(500);
		//Check whether the error message is displayed
		if(s3.equals("Denomination Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Denomination Saved Successfully message is displayed when user enter the valid name and amount");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Denomination Saved Successfully message is not displayed when user enter the valid name and amount");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		//Click the close button of warning message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
				
	}

	@Test(priority = 9,enabled = false,description="Verify the Denomination search in the Till Settings page")
	public void verifyTheDenominationsSearch(SelfHealingDriver driver) throws Exception
	{
		tsp = new Settings_Till_Setting_Page(driver, test);
		tsp.denomination_Search();
	}
	
	@Test(priority = 10,enabled = false,description="Verify the Denomination - Pagination in the Till Settings page")
	public void verifyTheDenominationsPagination(SelfHealingDriver driver) throws Exception
	{
		tsp = new Settings_Till_Setting_Page(driver, test);
		tsp.paginationValidations();
	}
	
	@Test(priority = 11,enabled = false,description="Verify the Denomination deletion in the Till Settings page")
	public void verifyTheDenominationsDeletion(SelfHealingDriver driver) throws Exception
	{
		tsp = new Settings_Till_Setting_Page(driver, test);
		tsp.clickTheDenominationsBtn();
		Thread.sleep(5000);
		tsp.Delete_Denomination();
		Thread.sleep(10000);
	}
	
	@Test(priority = 12,enabled = false,description="Verify the Close Till in the Till Settings page")
	public void verifyTheCloseTill_UI(SelfHealingDriver driver) throws Exception
	{
		tsp = new Settings_Till_Setting_Page(driver, test);
		tsp.closeTill();Thread.sleep(3000);
		try {
			if(driver.findElement(By.xpath("//span[.='Close Till not found']")).isDisplayed())
			{
				test.log(LogStatus.INFO, "There is no Close Tills are found");
			}
		}catch(Exception e) {
			tsp.denomination_Search1();
			tsp.paginationValidations();
			tsp.CloseTheActiveTill();
		}
	}
}
