package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.LoginPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest 
{
	public SelfHealingDriver driver;
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Login Page");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	
	@BeforeTest
	public void Open_and_Login() throws Exception
	{
		Login(driver, test);
	}
//		
//	
	public void Login(SelfHealingDriver driver,ExtentTest test) throws Exception
	{
		Thread.sleep(2000);
		//Call the chrome driver 
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
//		//Open the Chrome window
//		driver = new ChromeDriver();
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().setup();
//		driver=new ChromeDriver(chrOpt);
//		
//		//Wait for 30 seconds
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		//Maximize the Chrome window
//		driver.manage().window().maximize();
//		Thread.sleep(1000);
//		//Launch the URL
//		driver.get(Utility.getProperty("appURL"));
		LoginPage a=new LoginPage(driver,test);
		Thread.sleep(1000);
		a.VerifyLoginPageHeader();
		
		Thread.sleep(1000);
		a.Login(Utility.getProperty("userName"), Utility.getProperty("password"));
		
	}
	
	@AfterTest
	public void LogOut_and_Close() throws Exception
	{
		LogOut(driver, test);
	}
	
	public void LogOut(SelfHealingDriver driver,ExtentTest test) throws Exception
	{
		LoginPage a=new LoginPage(driver,test);
		
		a.Log_Out();
		
//		Thread.sleep(2000);
//		a.VerifyLoginPageHeader();
//		
//		Thread.sleep(1000);
//		driver.close();
		
	}
	
	public void Navigate_To_Page(String StoreID,String PageAttribute) throws Exception
	{
		driver.get(Utility.getProperty("baseURL")+StoreID+PageAttribute);

	}
	
	public WebDriver getDriver()
	{
		return driver;
	}

	
	public void Login_with_Old_BO(SelfHealingDriver driver,ExtentTest test) throws Exception
	{
		Thread.sleep(2000);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		try
		{
			if(driver.findElement(By.xpath("//div[@id='popmake-26044']/button")).isDisplayed())
			{Thread.sleep(1000);
				driver.findElement(By.xpath("//div[@id='popmake-26044']/button")).click();
			}
		}
		catch(Exception e)
		{}
		try
		{
			if(driver.findElement(By.xpath("//a[.='Accept']")).isDisplayed())
			{
				driver.findElement(By.xpath("//a[.='Accept']")).click();
			}
		}
		catch(Exception e)
		{}
		//Clear the text from the user name text box
		driver.findElement(By.xpath("//h1[contains(.,'Sign in')]/../div/div[1]/div/input")).clear();
		//Enter the user name
		driver.findElement(By.xpath("//h1[contains(.,'Sign in')]/../div/div[1]/div/input")).sendKeys(Utility.getProperty("userName"));
		//Clear the password from the password text box
		driver.findElement(By.xpath("//h1[contains(.,'Sign in')]/../div/div[2]/div/input")).clear();
		//Enter the password
		driver.findElement(By.xpath("//h1[contains(.,'Sign in')]/../div/div[2]/div/input")).sendKeys(Utility.getProperty("password"));
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);Thread.sleep(2000);
	
		//Click the login button
		driver.findElement(By.xpath("//button[contains(.,'Sign in')]")).click();
		Thread.sleep(30000);
		//Check if we logged in or not
		if(driver.findElement(By.xpath("//div[@id='navigation']/ul[1]/li/a")).getText().equalsIgnoreCase("My Stores"))
		{
			test.log(LogStatus.PASS, "User Logged in Successfully for Linga Enterprise ");
		}
		else
		{
			test.log(LogStatus.FAIL, "User Logged in Failed for Linga Enterprise ");
		}
		Thread.sleep(10000);
		//Click the refresh button 
		driver.findElement(By.cssSelector("button.btn.btn-sm.btn-primary")).click();
		
		Thread.sleep(5000);
		//Clear the search field 
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		//Enter the search field 
	     driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys(Utility.getProperty("Store1"));
		
		//Click the Entered store Dashboard page
		driver.findElement(By.xpath("//div[@id='main-container']/div[2]/div/div/div[2]/div/div/div/div[4]/div/div/div[2]/div/div[1]/a/h5")).click();
		
		//Check if we logged in or not
		try
		{
			if(driver.findElement(By.xpath("//span[.='Dashboard']")).getText().equalsIgnoreCase("Dashboard"))
			{
				test.log(LogStatus.PASS, "Linga Store level Dashboard page loaded sucessfully ");
			}
		}
		catch(Exception e)
		{
			test.log(LogStatus.FAIL, "Linga Store level Dashboard page loaded failed ");
		}
		Thread.sleep(8000);
		
		
		//Thread.sleep(15000);
		try
		{
			if(driver.findElement(By.xpath("//span[.='Do You Want to Take a look.. ']")).isDisplayed())
			{
				Thread.sleep(3000);
				//Click Not now
				driver.findElement(By.xpath("//button[.=' Not now']")).click();
			}
		}
		catch(Exception e) {}
	}
	
	
	public void LogOut_with_Old_BO(SelfHealingDriver driver,ExtentTest test) throws Exception
	{
		LoginPage a=new LoginPage(driver,test);
		
		JavascriptExecutor je = (JavascriptExecutor) driver;
		//Identify the WebElement which will appear after scrolling down
		WebElement element = driver.findElement(By.xpath("//i[contains(@class,'icon-logout')]/.."));
		//Scroll the page till the Reason option present
		je.executeScript("arguments[0].scrollIntoView(true);",element); 
		//Wait for 30 seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Click on Logout button
		driver.findElement(By.xpath("//i[contains(@class,'icon-logout')]/..")).click();
	    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(3000);
		
		//Check whether user get logged out or not
/*		if(driver.findElement(By.xpath(excel.getData(0, 10, 1))).isDisplayed())
		{
	    	test.log(LogStatus.PASS, "User Logged out Successfully LingaPOs");
		}
		else
		{
			test.log(LogStatus.FAIL, "User Logged out Failed LingaPos");
		}*/
		Thread.sleep(3000);
		//Close the Browser
		driver.close();
		
	}
}
