package com.Test;

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

import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.Pages.Settings_Matrix_Report_Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Report_MatrixReport 
{
	public WebDriver driver;


	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Matrix Report");

	LoginPage lgpg; 
	Utility ut=new Utility();
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Settings_Matrix_Report_Page mr;


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
	@Test(priority = 2)
	public void Calling() throws Exception 
	{
		Open_Settings_Matrix_Report_Page(driver);
		Thread.sleep(1000);
		Entering_Invalid_Amount_alpha(driver);
		Thread.sleep(1000);
		Entering_Invalid_Per_alpha(driver);
		Thread.sleep(1000);
		Entering_Invalid_Amount_Sym(driver);
		Thread.sleep(1000);
		Entering_Invalid_Per_Sym(driver);
		Thread.sleep(1000);
//		Entering_Invalid_Amount_Decimal(driver);
//		Thread.sleep(1000);
//		Entering_Invalid_Per_Decimal(driver);
//		Thread.sleep(1000);
		Entering_Invalid_AmountPer_Alphabet(driver);
		Thread.sleep(1000);
		Entering_Invalid_AmountPer_Symbol(driver);
		Thread.sleep(1000);
		Entering_Invalid_AmountPer(driver);
		Thread.sleep(1000);
		Entering_Invalid_AmountPercentage(driver);
		Thread.sleep(1000);
		Entering_Invalid_PerNum(driver);
		Entering_Amount_Percentage(driver);
		Thread.sleep(1000);
		Updating_Matrix_Report(driver);
		Thread.sleep(1000);
		Navigating_Back_Settings(driver);
	}
	@Test(priority = 3,enabled = false)
	public void Open_Settings_Matrix_Report_Page(WebDriver driver) throws Exception
	{
		cmp= new Common_XPaths(driver,test);
		mr= new Settings_Matrix_Report_Page(driver, test);
   	 
		Thread.sleep(8000);
		//load the Notifications page
		Thread.sleep(2000);
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("Store_Id2"));
//		driver.get(Utility.getProperty("baseURL")+"settings/"+"storeMatrix");

		Thread.sleep(2000);
		Thread.sleep(2000);
		mr.Navigating_Settings();
		mr.Navigating_Matrix_Report();
		Thread.sleep(5000);
		try {
			if(driver.findElement(By.xpath("//h3[contains(.,'Matrix Report')]")).isDisplayed()) {
				test.log(LogStatus.PASS, "Matrix Report page is loaded successfully");
			}
		}catch(Exception E) {
			test.log(LogStatus.FAIL, "Matrix Report page is not loaded");
		}
	}
	@Test(priority = 4,enabled = false)
	public void Entering_Amount_Percentage(WebDriver driver) throws Exception 
	{
		cmp= new Common_XPaths(driver,test);
		mr= new Settings_Matrix_Report_Page(driver, test);
		mr.Entering_Valid_Amount();
		Thread.sleep(1000);
		mr.Entering_Valid_Percentage();
		Thread.sleep(2000);

	}
	@Test(priority = 5,enabled = false)
	public void Entering_Invalid_Amount_alpha(WebDriver driver) throws Exception 
	{
		cmp= new Common_XPaths(driver,test);
		mr= new Settings_Matrix_Report_Page(driver, test);
		
		mr.Enter_InvalidAmount();
		Thread.sleep(3000);
		mr.Entering_Valid_Percentage();
		Thread.sleep(2000);
        //System.out.println("Entering Invalid amount in alphabets so ----");
		mr.Check_Update_Button();
    }	
	
	@Test(priority = 6, enabled = false)
	public void Entering_Invalid_Per_alpha(WebDriver driver) throws Exception 
	{
		cmp= new Common_XPaths(driver,test);
		mr= new Settings_Matrix_Report_Page(driver, test);
		Thread.sleep(3000);
		mr.Entering_Valid_Amount();
		mr.Enter_InvalidPer();
		mr.Update();
		
     }	
	
	@Test(priority = 7,enabled = false)
	public void Entering_Invalid_Amount_Sym(WebDriver driver) throws Exception 
	{
		cmp= new Common_XPaths(driver,test);
		mr= new Settings_Matrix_Report_Page(driver, test);
		//Fixed this issue so, Symbols not allowed & entered in Enter Amount

		Thread.sleep(3000);
		mr.Enter_Inavalid_Amountsym();
		Thread.sleep(1000);
        
        mr.Entering_Valid_Percentage();
        Thread.sleep(2000);
        //System.out.println("Entering Invalid amount in symbols so ----");
        mr.Check_Update_Button();
	}
	@Test(priority = 8,enabled = false)
	public void Entering_Invalid_Per_Sym(WebDriver driver) throws Exception 
	{
		cmp= new Common_XPaths(driver,test);
		mr= new Settings_Matrix_Report_Page(driver, test);
		Thread.sleep(3000);
		mr.Entering_Valid_Amount();
		//Fixed this issue so, Symbols not allowed & entered in Enter Percentage
		mr.Enter_Invalid_Persym();
		mr.Update();
       
	}
	
	@Test(priority = 9,enabled = false)
	public void Entering_Invalid_AmountPer_Alphabet(WebDriver driver) throws Exception 
	{
		cmp= new Common_XPaths(driver,test);
		mr= new Settings_Matrix_Report_Page(driver, test);
		mr.Enter_Invalid_Amountalpha();
		mr.Enter_Invalid_Peralpha();
		//Fixed this issue so, Alphabetics not allowed & entered in Enter Amount & Percentage
		mr.Check_Update_Button();
	}
	@Test(priority = 10,enabled = false)
	public void Entering_Invalid_AmountPer_Symbol(WebDriver driver) throws Exception 
	{
		cmp= new Common_XPaths(driver,test);
		mr= new Settings_Matrix_Report_Page(driver, test);
		
		Thread.sleep(3000);
		mr.Enter_Inavalid_Amountsym();
		Thread.sleep(1000);
		mr.Enter_Invalid_Persym();
		Thread.sleep(1000);
		mr.Check_Update_Button();
		
	 }
	@Test(priority = 11,enabled = false)
	public void Entering_Invalid_AmountPer(WebDriver driver) throws Exception 
	{
		cmp= new Common_XPaths(driver,test);
		mr= new Settings_Matrix_Report_Page(driver, test);
		Thread.sleep(3000);
		mr.Enter_Invalid_Amountalpha();
		Thread.sleep(3000);
		mr.Enter_Invalid_Persym();

		mr.Check_Update_Button();
		
	}
	@Test(priority = 12,enabled = false)
	public void Entering_Invalid_AmountPercentage(WebDriver driver) throws Exception 
	{
		cmp= new Common_XPaths(driver,test);
		mr= new Settings_Matrix_Report_Page(driver, test);
		Thread.sleep(3000);
		mr.Enter_Inavalid_Amountsym();		Thread.sleep(3000);
		mr.Enter_Invalid_Peralpha();
		//System.out.println("Entering invalid amount in symbols and percentage in alphabets so---");
		mr.Check_Update_Button();
		
	}
	@Test(priority = 13,enabled = false)
	public void Entering_Invalid_PerNum(WebDriver driver) throws Exception 
	{
		cmp= new Common_XPaths(driver,test);
		mr= new Settings_Matrix_Report_Page(driver, test);
		Thread.sleep(3000);
		mr.Entering_Valid_Amount();
		Thread.sleep(3000);
		mr.Enter_Invalid_Percentage();
		if(cmp.Percentage_Error_Msg().getText().trim().equalsIgnoreCase("Percentage should be between (0-100)"))
		{
			test.log(LogStatus.PASS, "Added invalid percentage More than 100");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Matrix Report settings updation failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}	
		//System.out.println("Entering invalid percentage more than 100 so----");
		mr.Check_Update_Button();
		
	}

	@Test(priority = 14,enabled = false)
	public void Updating_Matrix_Report(WebDriver driver) throws Exception 
	{
		//updating the data
		mr.Update();
		Thread.sleep(2000);
		//Check whether settings are Updated  or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Matrix Report Settings updated successfully!."))
		{
			test.log(LogStatus.PASS, "Matrix Report Setting updated");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Matrix Report settings updation failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}	

	}
	@Test(priority = 6,enabled = false)
	public void Navigating_Back_Settings(WebDriver driver) throws Exception
	{
		mr.Navigating_Back();
		Thread.sleep(1000);

	}


}
