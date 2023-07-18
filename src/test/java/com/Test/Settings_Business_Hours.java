package com.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.Settings_Businesshours_Page;
import com.Pages.Settings_NotificationsPage;
import com.Pages.Common_XPaths;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Business_Hours 
{
	public WebDriver driver;


	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Business Hours");

	LoginPage lgpg; 
	Utility ut=new Utility();
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Settings_Businesshours_Page bh;


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
		Open_Business_Hours_Page(driver);
		Changing_Store_Hours(driver);
		Thread.sleep(3000);
		Update_Store_Hours(driver);
		Thread.sleep(1000);
		Changing_Shift_Hours(driver);
		
		Adding_Deleting_Shift_Hours(driver);
		Update_Shift_Hours(driver);
	}
     
	@Test(priority=3,enabled = false)
	public void Open_Business_Hours_Page(WebDriver driver) throws Exception 
	{
    	 cmp= new Common_XPaths(driver,test);
    	 bh= new Settings_Businesshours_Page(driver, test);

    		Thread.sleep(5000);
    		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("Store_Id2"));
    	 bh.Navigating_Settings();
    	 bh.NavigatingBusinessHours();
			Thread.sleep(5000);
			try {
				if(driver.findElement(By.xpath("//h3[contains(.,'Business Hours')]")).isDisplayed()) {
					test.log(LogStatus.PASS, "Business Hours page is loaded successfully");
				}
			}catch(Exception E) {
				test.log(LogStatus.FAIL, "Business Hours page is not loaded");
			}
     }
	@Test(priority = 4,enabled = false)
	public void Changing_Store_Hours(WebDriver driver) throws Exception 
	{Thread.sleep(5000);
         cmp= new Common_XPaths(driver,test);
   	     bh= new Settings_Businesshours_Page(driver, test);
   	      
		bh.Navigating_StoreHours();
        Thread.sleep(1000);
        bh.change_Open_Sunday();
        Thread.sleep(2000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated for closed sunday");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed for Closed Sunday");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(5000);
        bh.Reselect_Open_Sunday();
        Thread.sleep(2000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated for open sunday");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed for Open Sunday");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(5000);
        bh.Change_Open_Monday();
        Thread.sleep(2000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated for Closed monday");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed for Closed Monday");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(5000);
        bh.Reselect_Open_Monday();
        Thread.sleep(2000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated for open monday");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(5000);
        bh.Change_Open_Tuesday();
        Thread.sleep(2000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated for Closed Tuesday ");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed for Closed Tuesday");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(5000);
        bh.Reselect_Open_Tuesday();
        Thread.sleep(2000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated for open Tuesday ");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed for Open Tuesday");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(5000);
        bh.Change_Open_Wednesday();
        Thread.sleep(2000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated for closed Wednesday");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed for Closed Wednesday");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(5000);
        bh.Reselect_Open_Wednesday();
        Thread.sleep(2000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated for open Wednesday");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed for Open Wednesday");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(5000);
        bh.Change_Open_Thursday();
        Thread.sleep(2000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated for Closed Thursday");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed for Closed Thursday");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(5000);
        bh.Reselect_Open_Thursday();
        Thread.sleep(2000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated for open Thursday");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed for Open Thursday");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(5000);
        bh.Change_Open_Friday();
        Thread.sleep(2000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated for closed Friday");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(5000);
        bh.Reselect_Open_Friday();
        Thread.sleep(3000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated for Open Friday");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed for open Friday");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(7000);
        bh.Change_Open_Saturday();
        Thread.sleep(3000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated for Closed saturday");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed for Closed Saturday");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(5000);
        bh.Reselect_Open_Saturday();
        Thread.sleep(2000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated for open Saturday");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed for Open Saturday");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(5000);
        bh.Closing_Active_Tills();
        Thread.sleep(1000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated ");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(1000);
        bh.Closing_Active_Tills_No();
        Thread.sleep(1000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed ");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        bh.Close_Opened_Check();
        Thread.sleep(1000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed ");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(1000);
        bh.Close_Opened_Check_No();
        Thread.sleep(1000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        bh.Closing_Opened_Check();
        Thread.sleep(1000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(1000);
        bh.Close_Opened_Check_No();
        Thread.sleep(1000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation Failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        bh.Close_Active_Emp();
        Thread.sleep(1000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(1000);
        bh.Close_Active_Emp_No();
        Thread.sleep(1000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
       // bh.Closing_Opened_Check();
        bh.Conform_Before_Closing();
        Thread.sleep(1000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed ");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
        Thread.sleep(3000);
        bh.Conform_Before_Closing_No();
        Thread.sleep(1000);
        bh.Update();
        if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated ");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
	}
	@Test(priority = 5,enabled = false)
	public void Update_Store_Hours(WebDriver driver) throws Exception 
	{
		cmp= new Common_XPaths(driver,test);
  	     bh= new Settings_Businesshours_Page(driver, test);
  	     

 		//updating the data
 		bh.Update();
 		Thread.sleep(2000);
 		//Check whether Business hours are Updated  or not
 		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Store Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Store hours updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Store hours updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
		
	}
	@Test(priority = 6,enabled = false)
	public void Changing_Shift_Hours(WebDriver driver) throws Exception 
	{
		cmp= new Common_XPaths(driver,test);
  	     bh= new Settings_Businesshours_Page(driver, test);
  	     
  	     bh.Clicking_Shift();
  	     Thread.sleep(1000);
  	     bh.Shift_Hours();
  	     Thread.sleep(2000);
  	     
  	  }
	@Test(priority = 7,enabled = false)
	public void Adding_Deleting_Shift_Hours(WebDriver driver) throws Exception
	{
		cmp= new Common_XPaths(driver,test);
 	     bh= new Settings_Businesshours_Page(driver, test);
		 bh.Adding_Shift();
 	     bh.Delete();
 	    Thread.sleep(2000);
 		//Check whether Business hours are Updated  or not
 		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Shift Removed Successfully"))
 		{
 			test.log(LogStatus.PASS, "Shift Removed Successfully");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Shift Remove failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
		
	}
	
	@Test(priority = 8,enabled = false)
	public void Update_Shift_Hours(WebDriver driver) throws Exception 
	{
		cmp= new Common_XPaths(driver,test);
  	     bh= new Settings_Businesshours_Page(driver, test);
  	     
  	     driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
  	     Thread.sleep(3000);
//  	     bh.Navigating_StoreHours();
  	     Thread.sleep(1000);
 		//updating the data
 		bh.Update();
 		Thread.sleep(2000);
 		//Check whether Business hours are Updated  or not
 		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Shift Updated Successfully"))
 		{
 			test.log(LogStatus.PASS, "Shift hours updated");

 			ut.PassedCaptureScreenshotAsBASE64(driver, test);
 		}
 		else
 		{
 			test.log(LogStatus.FAIL, "Shift hours updation failed");

 			ut.FailedCaptureScreenshotAsBASE64(driver, test);
 		}	
		
	}


}
