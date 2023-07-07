package com.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

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

import com.Pages.Settings_CDS_Configuration_Page;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_CDS_Configuration {
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("CDS Settings");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp=new Common_XPaths(driver, test);
	LoginTest a=new LoginTest();
	
	Settings_CDS_Configuration_Page cds;
	
	String valid_Txt1 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
			
	String valid_Txt2 = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
			
	String invalid_Txt = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabc";
			
	
	
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
		//System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
		//Open the Chrome window
		ChromeOptions chromeOptions = new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(chromeOptions);
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
		Thread.sleep(10000);
		Open_CDS_Page(driver);
		//verifyTheThemeTaxt(driver);
		verifyShowAdvertisements_Yes(driver);
		verifyShowAdvertisements_No(driver);
		verifyCustomerProfile_Yes(driver);
		verifyCustomerProfile_No(driver);
		verifyDarkProfile(driver);
		verifyLightProfile(driver);
		verifyDiscountText_Valid(driver);
		verifyDiscountText_Valid1(driver);
		verifyDiscountText_inValid(driver);
		verifyGetNumberText_Valid(driver);
		verifyGetNumberText_Valid1(driver);
		verifyGetNumberText_inValid(driver);
		verifyLoyaltyText_Valid(driver);
		verifyLoyaltyText_Valid1(driver);
		verifyLoyaltyText_inValid(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_CDS_Page(WebDriver driver) throws Exception
	{
		cds=new Settings_CDS_Configuration_Page(driver, test);

		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"customerDisplaySystem");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(8000);
		
		cds.verifyTheCDSPage();
		//cmp.VerifyMainScreenPageHeader("Customer Display System (CDS)");
	}
	
	
	@Test(priority = 4,enabled = false)
	public void verifyTheThemeTaxt(WebDriver driver) throws Exception
	{
		cds=new Settings_CDS_Configuration_Page(driver, test);
		try {
			if(driver.findElement(By.xpath("//label/mat-label[contains(.,'Theme')]")).isDisplayed())
			{
				cds.clickYesBtnShowAd();
				cds.verifyTheDisabledUpdateBtn();
				cds.selectDarkTheme();
				cds.clickUpdateBtn();
				
				Thread.sleep(1000);
				
				String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
				
				//Verify the success message
				if(s.equals("CDS settings updated successfully"))
				{
					test.log(LogStatus.PASS, "Updated message displayed successfully when user select the Dark profile");
				}
				else
				{
					test.log(LogStatus.FAIL, "Updated message not displayed when user select the Dark profile");
				}
				
				//Click the close button of success message
				driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
				Thread.sleep(3000);
			}
		}catch(Exception a)
		{
			cds.selectDarkTheme();
			cds.clickUpdateBtn();
			
			Thread.sleep(1000);
			
			String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s.equals("CDS settings updated successfully"))
			{
				test.log(LogStatus.PASS, "Updated message displayed successfully when user select the Dark profile");
			}
			else
			{
				test.log(LogStatus.FAIL, "Updated message not displayed when user select the Dark profile");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 5,enabled = false)
	public void verifyShowAdvertisements_Yes(WebDriver driver) throws Exception
	{
		cds=new Settings_CDS_Configuration_Page(driver, test);
		cds.clickYesBtnShowAd();
	}
	
	@Test(priority = 6,enabled = false)
	public void verifyShowAdvertisements_No(WebDriver driver) throws Exception
	{
		cds=new Settings_CDS_Configuration_Page(driver, test);
		cds.clickNoBtnShowAd();
	}
	
	@Test(priority = 7,enabled = false)
	public void verifyCustomerProfile_Yes(WebDriver driver) throws Exception
	{
		cds=new Settings_CDS_Configuration_Page(driver, test);
		cds.clickYesBtnCustomerProfile();
	}
	
	@Test(priority = 8,enabled = false)
	public void verifyCustomerProfile_No(WebDriver driver) throws Exception
	{
		cds=new Settings_CDS_Configuration_Page(driver, test);
		cds.clickNoBtnCustomerProfile();
	}
	
	@Test(priority = 9,enabled = false)
	public void verifyDarkProfile(WebDriver driver) throws Exception
	{
		cds=new Settings_CDS_Configuration_Page(driver, test);
		cds.selectDarkTheme();
		cds.clickUpdateBtn();
		
		Thread.sleep(1000);
		
		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s.equals("CDS settings updated successfully"))
		{
			test.log(LogStatus.PASS, "Updated message displayed successfully when user select the Dark profile");
		}
		else
		{
			test.log(LogStatus.FAIL, "Updated message not displayed when user select the Dark profile");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 10,enabled = false)
	public void verifyLightProfile(WebDriver driver) throws Exception
	{
		cds=new Settings_CDS_Configuration_Page(driver, test);
		cds.selectLightTheme();
		cds.clickUpdateBtn();
		
		Thread.sleep(1000);
		
		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s.equals("CDS settings updated successfully"))
		{
			test.log(LogStatus.PASS, "Updated message displayed successfully when user select the Light profile");
		}
		else
		{
			test.log(LogStatus.FAIL, "Updated message not displayed when user select the Light profile");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 11,enabled = false)
	public void verifyDiscountText_Valid(WebDriver driver) throws Exception
	{
		cds=new Settings_CDS_Configuration_Page(driver, test);
		cds.enterTheDiscountText(valid_Txt1);
		cds.clickUpdateBtn();
		
		Thread.sleep(1000);
		
		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s.equals("CDS settings updated successfully"))
		{
			test.log(LogStatus.PASS, "Updated message displayed successfully when user enter the valid(159 chars) Discount Text");
		}
		else
		{
			test.log(LogStatus.FAIL, "Updated message not displayed when user enter the valid(159 chars) Discount Text");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 12,enabled = false)
	public void verifyDiscountText_Valid1(WebDriver driver) throws Exception
	{
		cds=new Settings_CDS_Configuration_Page(driver, test);
		cds.enterTheDiscountText(valid_Txt2);
		cds.clickUpdateBtn();
		
		Thread.sleep(1000);
		
		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s.equals("CDS settings updated successfully"))
		{
			test.log(LogStatus.PASS, "Updated message displayed successfully when user enter the valid(160 chars) Discount Text");
		}
		else
		{
			test.log(LogStatus.FAIL, "Updated message not displayed when user enter the valid(160 chars) Discount Text");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 13,enabled = false)
	public void verifyDiscountText_inValid(WebDriver driver) throws Exception
	{
		cds=new Settings_CDS_Configuration_Page(driver, test);
		try {
			cds.enterTheDiscountText(invalid_Txt);
			cds.verifyTheDisabledUpdateBtn();
			cds.enterTheDiscountText(valid_Txt2);
			cds.clickUpdateBtn();
			
			Thread.sleep(1000);
			
			String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s.equals("CDS settings updated successfully"))
			{
				test.log(LogStatus.PASS, "Updated message displayed successfully when user enter the valid(160 chars) Discount Text");
			}
			else
			{
				test.log(LogStatus.FAIL, "Updated message not displayed when user enter the valid(160 chars) Discount Text");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}catch(Exception e)
		{
			cds.enterTheDiscountText(valid_Txt2);
			cds.clickUpdateBtn();
			
			Thread.sleep(1000);
			
			String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s.equals("CDS settings updated successfully"))
			{
				test.log(LogStatus.PASS, "Updated message displayed successfully when user enter the valid(160 chars) Discount Text");
			}
			else
			{
				test.log(LogStatus.FAIL, "Updated message not displayed when user enter the valid(160 chars) Discount Text");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 14,enabled = false)
	public void verifyGetNumberText_Valid(WebDriver driver) throws Exception
	{
		cds=new Settings_CDS_Configuration_Page(driver, test);
		cds.enterTheGetNumberText(valid_Txt1);
		cds.clickUpdateBtn();
		
		Thread.sleep(1000);
		
		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s.equals("CDS settings updated successfully"))
		{
			test.log(LogStatus.PASS, "Updated message displayed successfully when user enter the valid(159 chars) Get Number Text");
		}
		else
		{
			test.log(LogStatus.FAIL, "Updated message not displayed when user enter the valid(159 chars) Get Number Text");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 15,enabled = false)
	public void verifyGetNumberText_Valid1(WebDriver driver) throws Exception
	{
		cds=new Settings_CDS_Configuration_Page(driver, test);
		cds.enterTheGetNumberText(valid_Txt2);
		cds.clickUpdateBtn();
		
		Thread.sleep(1000);
		
		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s.equals("CDS settings updated successfully"))
		{
			test.log(LogStatus.PASS, "Updated message displayed successfully when user enter the valid(160 chars) Get Number Text");
		}
		else
		{
			test.log(LogStatus.FAIL, "Updated message not displayed when user enter the valid(160 chars) Get Number Text");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 16,enabled = false)
	public void verifyGetNumberText_inValid(WebDriver driver) throws Exception
	{
		cds=new Settings_CDS_Configuration_Page(driver, test);
		try {
			cds.enterTheGetNumberText(invalid_Txt);
			cds.verifyTheDisabledUpdateBtn();
			cds.enterTheGetNumberText(valid_Txt2);
			cds.clickUpdateBtn();
			
			Thread.sleep(1000);
			
			String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s.equals("CDS settings updated successfully"))
			{
				test.log(LogStatus.PASS, "Updated message displayed successfully when user enter the valid(160 chars) Get Number Text");
			}
			else
			{
				test.log(LogStatus.FAIL, "Updated message not displayed when user enter the valid(160 chars) Get Number Text");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}catch(Exception e)
		{
			cds.enterTheGetNumberText(valid_Txt2);
			cds.clickUpdateBtn();
			
			Thread.sleep(1000);
			
			String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s.equals("CDS settings updated successfully"))
			{
				test.log(LogStatus.PASS, "Updated message displayed successfully when user enter the valid(160 chars) Get Number Text");
			}
			else
			{
				test.log(LogStatus.FAIL, "Updated message not displayed when user enter the valid(160 chars) Get Number Text");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
	}
	
	@Test(priority = 17,enabled = false)
	public void verifyLoyaltyText_Valid(WebDriver driver) throws Exception
	{
		cds=new Settings_CDS_Configuration_Page(driver, test);
		cds.enterTheLoyaltyText(valid_Txt1);
		cds.clickUpdateBtn();
		
		Thread.sleep(1000);
		
		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s.equals("CDS settings updated successfully"))
		{
			test.log(LogStatus.PASS, "Updated message displayed successfully when user enter the valid(159 chars) Loyalty Text");
		}
		else
		{
			test.log(LogStatus.FAIL, "Updated message not displayed when user enter the valid(159 chars) Loyalty Text");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 18,enabled = false)
	public void verifyLoyaltyText_Valid1(WebDriver driver) throws Exception
	{
		cds=new Settings_CDS_Configuration_Page(driver, test);
		cds.enterTheLoyaltyText(valid_Txt2);
		cds.clickUpdateBtn();
		
		Thread.sleep(1000);
		
		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s.equals("CDS settings updated successfully"))
		{
			test.log(LogStatus.PASS, "Updated message displayed successfully when user enter the valid(160 chars) Loyalty Text");
		}
		else
		{
			test.log(LogStatus.FAIL, "Updated message not displayed when user enter the valid(160 chars) Loyalty Text");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
	}
	
	@Test(priority = 19,enabled = false)
	public void verifyLoyaltyText_inValid(WebDriver driver) throws Exception
	{
		cds=new Settings_CDS_Configuration_Page(driver, test);
		try {
			cds.enterTheLoyaltyText(invalid_Txt);
			cds.verifyTheDisabledUpdateBtn();
			cds.enterTheLoyaltyText(valid_Txt2);
			cds.clickUpdateBtn();
			
			Thread.sleep(1000);
			
			String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s.equals("CDS settings updated successfully"))
			{
				test.log(LogStatus.PASS, "Updated message displayed successfully when user enter the valid(160 chars) Loyalty Text");
			}
			else
			{
				test.log(LogStatus.FAIL, "Updated message not displayed when user enter the valid(160 chars) Loyalty Text");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}catch(Exception e)
		{
			cds.enterTheLoyaltyText(valid_Txt2);
			cds.clickUpdateBtn();
			
			Thread.sleep(1000);
			
			String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
			
			//Verify the success message
			if(s.equals("CDS settings updated successfully"))
			{
				test.log(LogStatus.PASS, "Updated message displayed successfully when user enter the valid(160 chars) Loyalty Text");
			}
			else
			{
				test.log(LogStatus.FAIL, "Updated message not displayed when user enter the valid(160 chars) Loyalty Text");
			}
			
			//Click the close button of success message
			driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
			Thread.sleep(3000);
		}
	}
}