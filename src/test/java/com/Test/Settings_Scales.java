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
import com.Pages.Settings_Scales_Page;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Scales {
public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Scales Settings");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp=new Common_XPaths(driver, test);
	LoginTest a=new LoginTest();
	
	Settings_Scales_Page scle;
		
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
		Open_Scales_Page(driver);
		verifyNewScaleBarCode(driver);
		verifyScale_Operatoins(driver);
		verifyScalesDeletingAndActivating(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Scales_Page(SelfHealingDriver driver) throws Exception
	{
		scle=new Settings_Scales_Page(driver, test);
		//Thread.sleep(5000);
		
		Thread.sleep(5000);

		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"scales");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		Thread.sleep(5000);
		
		scle.verifyScalesHeading_Visibility();
		scle.verifyColumnField_Visibility();
		scle.verifyActiveBtn_Visibility();
		scle.verifySearchField_Visibility();
		scle.verifyNewScaleBarCodeBtn_Visibility();
		scle.verifyTheAllColumns_Visibility();
	}
	
	@Test(priority = 3,enabled = false)
	public void verifyNewScaleBarCode(SelfHealingDriver driver) throws Exception
	{
		scle=new Settings_Scales_Page(driver, test);
		
		scle.verifyAddNewScaleBarCodeBtn();
		
		driver.findElement(By.xpath("//span[contains(.,'Save')]")).click();
		
		String s = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		Thread.sleep(500);
		//Check whether the error message is displayed
		if(s.equals("Barcode Setting Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Barcode Setting Saved Successfully message is displayed when user add the new scale barcode(Scale by Price)");
		}
		else
		{
			test.log(LogStatus.FAIL, "Barcode Setting Saved Successfully message is not displayed when user add the new scale barcode(Scale by Price)");
		}
		
		Thread.sleep(1000);
		//Click the close button of warning message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();

		Thread.sleep(1000);
		scle.verifyAddNewScaleBarCodeBtn_Wieght();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(.,'Save')]")).click();
		
		String s1 = driver.findElement(By.xpath("//div[@class='message mx-2']/span")).getText();
		Thread.sleep(500);
		//Check whether the error message is displayed
		if(s1.equals("Barcode Setting Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Barcode Setting Saved Successfully message is displayed when user add the new scale barcode(Scale by Weight)");
		}
		else
		{
			test.log(LogStatus.FAIL, "Barcode Setting Saved Successfully message is not displayed when user add the new scale barcode(Scale by Weight)");
		}
		
		//Click the close button of warning message
		driver.findElement(By.xpath("//div[@class='message mx-2']/../mat-icon[.='close']")).click();
		
		

	}
	
	@Test(priority = 4,enabled = false)
	public void verifyScale_Operatoins(SelfHealingDriver driver) throws Exception
	{
		scle=new Settings_Scales_Page(driver, test);
		scle.Ascending_And_Descending_Order();
		scle.Filter_Columns();
		scle.search();
	}
	
	@Test(priority = 5,enabled = false)
	public void verifyScalesDeletingAndActivating(SelfHealingDriver driver) throws InterruptedException {
		scle=new Settings_Scales_Page(driver, test);
		Thread.sleep(2000);
		//click the delete
		scle.delete();
		scle.active();
	}
}
