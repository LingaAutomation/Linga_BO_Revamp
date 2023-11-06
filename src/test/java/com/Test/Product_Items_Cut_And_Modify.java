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
import com.Pages.CutAndModifyPage;
import com.Pages.LoginPage;
import com.Pages.ServingSizeLevelsPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_Cut_And_Modify {
	
	public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Edit Cut and Modify");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	CutAndModifyPage cm;
	
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
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
//		//Open the Chrome window
//		driver = new ChromeDriver();
		
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
		Open_Cut_And_Modify_Page(driver);
		Clear_CutAndModify(driver);
		Edit_CutAndModify(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Cut_And_Modify_Page(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		cm=new CutAndModifyPage(driver, test);
		
		Thread.sleep(5000);
		//Load the Cut and modifys page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"cutAndModify");

		Thread.sleep(5000);
		//Verify the Cut and modify page loaded or not
		cmp.VerifyMainScreenPageHeader("Cut And Modify");	
	}
	
	@Test(priority = 4,enabled = false)
	public void Clear_CutAndModify(SelfHealingDriver driver) throws Exception
	{
		cm=new CutAndModifyPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
//		driver.navigate().refresh();
		
		
		Thread.sleep(3000);
		//Clear the Cut And Modifier Percentage
//		cm.Clear_ModifyPercentageForAllSlideFractions();
		Thread.sleep(500);

//		//Click the Save button
//		cm.Click_Save_Cut_and_Modify();
//		
//		Thread.sleep(2000);
//		//Check whether the New Cut and modify Saved or not
//		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Cut and modify saved successfully"))
//		{
//			test.log(LogStatus.PASS, "Cleared Cut and modify Percentage Successfully");
//		
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Cleared Cut and modify percentage Failed");
//			
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
		
		Thread.sleep(2000);
		//Verify whether the Modify percentage cleared or not after saved
		cm.Enter_ModifyPercentageForAllSlideFractions("000");
		
		//Click the Save button
				cm.Click_Save_Cut_and_Modify();
				
				Thread.sleep(2000);
				//Check whether the New Cut and modify Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Cut and modify saved successfully"))
				{
					test.log(LogStatus.PASS, "Cleared Cut and modify Percentage Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Cleared Cut and modify percentage Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				Thread.sleep(3000);
//				driver.navigate().back();
//				
//				Thread.sleep(2000);
//				driver.navigate().forward();
				driver.navigate().refresh();
				Thread.sleep(5000);
				
				String str=cm.First_SliceModify().getAttribute("value");
				
				System.out.println(str);
				
				Thread.sleep(5000);
				if(cm.First_SliceModify().getAttribute("value").equalsIgnoreCase("0.00%"))
				{
					test.log(LogStatus.PASS, "Cut and Modify Updated Correctly");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Cut and Modify Updated InCorrect");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
		
				
				
				Thread.sleep(2000);
				//Verify whether the Modify percentage cleared or not after saved
				cm.Enter_ModifyPercentageForAllSlideFractions("100000");
				
				//Click the Save button
						cm.Click_Save_Cut_and_Modify();
						
						Thread.sleep(2000);
						//Check whether the New Cut and modify Saved or not
						if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter less than 100 Percentage"))
						{
							test.log(LogStatus.PASS, "Please Enter less than 100 Percentage is Displayed");
						
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
						}
						else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Cut and modify saved successfully"))
						{
							test.log(LogStatus.FAIL, "Cut and modify saved with Above 100 Percentage");
						
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						else
						{
							test.log(LogStatus.INFO, "Cleared Cut and modify percentage Failed");
							
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Edit_CutAndModify(SelfHealingDriver driver) throws Exception
	{
		cm=new CutAndModifyPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Enter the Modify percentage for all Slice Fractions
		cm.ModifyPercentageForAllSlideFractions("50.00");
		Thread.sleep(500);
	
		//Click the Save button
		cm.Click_Save_Cut_and_Modify();
		
		Thread.sleep(2000);
		//Verify the Modify percentage updated for All Slice Fractions
		cm.Enter_ModifyPercentageForAllSlideFractions("50.00");
		
		Thread.sleep(1000);
		//Enter the First Modify Percentage
		cm.Enter_ModifyPercentage_FirstSliceFraction("40.00");
		Thread.sleep(500);

		//Enter the Second Modify Percentage	
		cm.Enter_ModifyPercentage_SecondSliceFraction("33.00");
		Thread.sleep(500);

		//Enter the Third Modify Percentage
		cm.Enter_ModifyPercentage_ThirdSliceFraction("25.00");
		Thread.sleep(500);
		ut.PassedCaptureScreenshotAsBASE64(driver, test);
		//Click the Save button
		cm.Click_Save_Cut_and_Modify();
		
		Thread.sleep(2000);
		//Check whether the New Cut and modify Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Cut and modify saved successfully"))
		{
			test.log(LogStatus.PASS, "Cut and modify Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Cut and modify Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		Thread.sleep(5000);
		if(cm.First_SliceModify().getAttribute("value").equalsIgnoreCase("40.00"))
		{
			test.log(LogStatus.PASS, "Cut and Modify Updated Correctly");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Cut and Modify Updated InCorrect");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
			
			
		}
		
		
	}
}
