package com.Test;

import java.util.concurrent.TimeUnit;

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
import com.Pages.SortMenuConfigPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_Sort_Menu_Config 
{
	public SelfHealingDriver driver;


	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Sorting Menu Items");

	LoginPage lgpg; 
	Utility ut=new Utility();
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	SortMenuConfigPage smc;


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
		Open_Sort_Menu_Config_Page(driver);
		Sort_Categories (driver);
		Category_Navigating(driver);
		Sort_MenuItem(driver);
	}

	@Test(priority =3,enabled = false)
	public void Open_Sort_Menu_Config_Page(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		smc= new SortMenuConfigPage(driver,test);

		Thread.sleep(5000);
		//Load the sort menu config page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"sortMenuConfig");
		Thread.sleep(5000);

		//verify sort menu config page loaded or not
		Thread.sleep(3000);
		cmp.VerifyMainScreenPageHeader("Sort Menu Config");
	}

	@Test(priority = 4,enabled = false)
	public void Sort_Categories (SelfHealingDriver driver) throws Exception {
		cmp=new Common_XPaths(driver, test);
		smc= new SortMenuConfigPage(driver,test);


		Thread.sleep(5000);
		//sorting the order to A to Z
		smc.Select_AtoZSorting_Category();
		Thread.sleep(5000);
		//click on save button
		smc.Save();

		Thread.sleep(2000);
		//Check whether the sorting order Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Items sorted successfully"))
		{
			test.log(LogStatus.PASS, "AtoZ item sorting done Successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item sorting Failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

		smc.Select_ZtoASorting_Category();
		Thread.sleep(5000);
		//click on save button
		smc.Save();

		Thread.sleep(2000);
		//Check whether the sorting order Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Items sorted successfully"))
		{
			test.log(LogStatus.PASS, "ZtoA item sorting done Successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item sorting Failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

		Thread.sleep(3000);
		String Actual=smc.Category_First().getText();

		smc.Select_CustomSorting_Category();
		
		Thread.sleep(5000);
		//click on save button
		smc.Save();

		Thread.sleep(2000);
		//Check whether the sorting order Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Items sorted successfully"))
		{
			test.log(LogStatus.PASS, "Custom sorting done Successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item sorting Failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		Thread.sleep(5000);
		
		String Expected=smc.Category_Second().getText();
		
		
		Thread.sleep(1000);
		if(Expected.equalsIgnoreCase(Actual))
		{
			test.log(LogStatus.PASS, "Custom sorted Correctly for Category");
		}
		else
		{
			test.log(LogStatus.FAIL, "Custom Sorted Incorrect for Category");
		}
		
		

	}
	@Test(priority = 4,enabled = false)
	public void Category_Navigating(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		smc= new SortMenuConfigPage(driver,test);

		Thread.sleep(5000);
		//Navigating to right
		smc.Move_right();
		Thread.sleep(2000);
		//navigating to left
		smc.Move_left();
		Thread.sleep(2000);

	}
	@Test(priority = 5,enabled = false)
	public void Sort_MenuItem(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		smc= new SortMenuConfigPage(driver,test);

		try
		{
		if(smc.Menu_Second().isDisplayed())
		{
		Thread.sleep(5000);
		//sorting the order to A to Z
		smc.Select_AtoZSorting_MenuItems();
		Thread.sleep(5000);
		//click on save button
		smc.Save();

		Thread.sleep(2000);
		//Check whether the sorting order Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Items sorted successfully"))
		{
			test.log(LogStatus.PASS, "AtoZ  Menu item sorting done Successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item sorting Failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

		//sorting the order to Z to A
		smc.Select_ZtoASorting_MenuItems();
		Thread.sleep(5000);
		//click on save button
		smc.Save();

		Thread.sleep(2000);
		//Check whether the sorting order Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Items sorted successfully"))
		{
			test.log(LogStatus.PASS, "Z to A Menu item sorting done Successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item sorting Failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		String Actual=smc.Menu_First().getText();
		
		smc.Select_CustomSorting_MenuItems();
		Thread.sleep(5000);
		//click on save button
		smc.Save();

		Thread.sleep(2000);
		//Check whether the sorting order Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Items sorted successfully"))
		{
			test.log(LogStatus.PASS, "Custom Menu sorting done Successfully");

			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Item sorting Failed");

			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
String Expected=smc.Menu_Second().getText();
		
		
		Thread.sleep(1000);
		if(Expected.equalsIgnoreCase(Actual))
		{
			test.log(LogStatus.PASS, "Custom sorted Correctly for Menu Items");
		}
		else
		{
			test.log(LogStatus.FAIL, "Custom Sorted Incorrect for Menu Items");
		}
		}
	}
		catch(Exception H)
		{
			test.log(LogStatus.INFO, "Menu Items not available for Sorting");
		}
	}

}



