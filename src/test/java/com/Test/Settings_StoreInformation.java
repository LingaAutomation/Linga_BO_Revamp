package com.Test;

import java.time.Duration;

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
import com.Pages.Settings_StoreInformation_Page;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_StoreInformation {
public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Store Information");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp=new Common_XPaths(driver, test);
	LoginTest a=new LoginTest();
	
	Settings_StoreInformation_Page sis;
	
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
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver(chrOpt);
		WebDriverManager.chromedriver().setup();
		
		ChromeOptions options=new ChromeOptions();
		
		options.setHeadless(false);
		
		WebDriver delegate=new ChromeDriver();
		
		driver=SelfHealingDriver.create(delegate);
		//Wait for 30 seconds
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
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
		Open_SI_Page(driver);
//		verifyTheToolTip(driver);
		verifyTheGeneral(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_SI_Page(SelfHealingDriver driver) throws Exception
	{
		sis=new Settings_StoreInformation_Page(driver, test);

		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"storeInformation");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		
		sis.VerifyStoreInformationPage();
	}
	
	@Test(priority = 4,enabled = false)
	public void verifyTheToolTip(SelfHealingDriver driver) throws Exception
	{
		sis=new Settings_StoreInformation_Page(driver, test);
		
		Thread.sleep(2000);
		sis.VerifyTheToolTip_StoreName();
		sis.VerifyTheToolTip_BusinessType();
		sis.VerifyTheToolTip_PhoneNumber();
		sis.VerifyTheToolTip_StoreID();
		sis.VerifyTheToolTip_Email();
		sis.VerifyTheToolTip_GiftCardEmail();
		sis.VerifyTheToolTip_StoreImage();
		sis.VerifyTheToolTip_Launguage();
		sis.VerifyTheToolTip_DefaultLaunguage();
		sis.VerifyTheToolTip_Street();
		sis.VerifyTheToolTip_Apartment();
		sis.VerifyTheToolTip_City();
		sis.VerifyTheToolTip_State();
		sis.VerifyTheToolTip_ZipCode();
		sis.VerifyTheToolTip_TimeZone();
	}
	
	@Test(priority = 4,enabled = false)
	public void verifyTheGeneral(SelfHealingDriver driver) throws Exception
	{
		sis=new Settings_StoreInformation_Page(driver, test);
		
		Thread.sleep(1000);
		sis.VerifyStoreName_Field();
		
		Thread.sleep(1000);
		sis.VerifyBusinessType();
		
		Thread.sleep(1000);
		sis.VerifyPhoneNumber();
		
		Thread.sleep(1000);
		sis.VerifyStoreID_Field();
		
		Thread.sleep(1000);
		sis.VerifyEmailID_Field();
		
		Thread.sleep(1000);
		sis.VerifyGiftCardEmail_Field();
		//sis.VerifyTheStoreImage();
		
		Thread.sleep(1000);
		sis.VerifyTheLanguage();
		
		Thread.sleep(1000);
		sis.VerifyTheDefaultLanguage();
		
		Thread.sleep(1000);
		sis.VerifyTheLocation();
		
		Thread.sleep(1000);
		sis.VerifyTheTimeZone();
		
		//Click the Save/Update button
		driver.findElement(By.xpath("//span[contains(.,'SAVE')]")).click();
		
		Thread.sleep(500);
		String s2 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		
		//Verify the success message
		if(s2.equals("Store Updated Successfully"))
		{
			test.log(LogStatus.PASS, "Store updated successfully message is displayed after update all the data");
		}
		else
		{
			test.log(LogStatus.FAIL, "Store updated successfully message is not displayed after update all the data");
		}
		
		//Click the close button of success message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		Thread.sleep(3000);
		
		try {
			//List<WebElement> w = driver.findElements(By.xpath("//mat-hint/../div/mat-form-field/div/div/div/span/label/mat-label"));
			if(driver.findElement(By.xpath("//mat-hint/../div/mat-form-field/div/div/div/span/label/mat-label")).isDisplayed())
			{
				test.log(LogStatus.FAIL, "After update the store information, still the field validation messages are displayed");
			}
		}
		catch(Exception e) {
			test.log(LogStatus.PASS, "After update the store information, there is no field validation messages are displayed");
		}
	}
}