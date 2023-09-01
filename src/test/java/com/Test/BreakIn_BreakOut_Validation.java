package com.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
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

import com.Pages.Availability_RestrictionTimePage;
import com.Pages.Common_XPaths;
import com.Pages.DiscountsPage;
import com.Pages.LoginPage;
import com.Pages.TaxesPage;
import com.Pages.UpchargesPage;
import com.Pages.UserManagementPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.support.ui.Select;
import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BreakIn_BreakOut_Validation {

public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete - Open Check Discount (Discounts) ");
	
	LoginPage lgpg; 
	
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	
	
	UserManagementPage usm;
	String Role;
	
	TaxesPage tp;
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
	
			Thread.sleep(2000);
			//Load the Upcharge page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"discounts");

			Thread.sleep(5000);
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
		
		Thread.sleep(30000);
		a.Login(driver, test);
	}
	
	@Test(priority = 50)
	public void LogOut() throws Exception
	{
		a.LogOut(driver, test);
	}
	
	
//	@Test(priority=2)
//	public void Calling() throws Exception
//	{
//		Open_Open_Check_Discount_Page(driver);
//		RefreshAndPaginination(driver);
//		//Add_Open_Check_DiscountType_Promo(driver);
//		Edit_and_Close_Cancel_Open_Check_Discount(driver);
//		Edit_and_Update_Open_Check_DiscountType_Comp(driver);
//		Edit_and_Update_Open_Check_DiscountType_Donation(driver);
//		Edit_and_Update_MenuCheck_Open_Check_Discount(driver);
//		Delete_and_Active_Inactive_Open_Check_Discount(driver);
//		
//	}
	
	@Test(priority = 3,enabled = true)
	public void Open_Roles_Page() throws Exception
	{
		
	
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Upcharge page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id6")+"roles");

		Thread.sleep(5000);
		//Verify the Open Check Discount page loeded or not
		cmp.VerifyMainScreenPageHeader("Roles");	
		
	
	}
	
	@Test(priority = 4,enabled = true)
	public void RefreshAndPaginination() throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		
		
	}
	
	@Test(priority = 5,enabled = true)
	public void Add_Role_Enable_Time_Clock() throws Exception
	{
	
		cmp=new Common_XPaths(driver, test);
		usm=new UserManagementPage(driver, test);
		
		usm.Click_New_Role();
		
		//Verify whether the New Role 
				cmp.VerifyCreationScreenPageHeader("New Role");
				
				String Str=RandomStringUtils.randomAlphabetic(4);
				
				String RoleName="Role"+Str;
				this.Role=RoleName;
				
				System.out.println("Role Name : "+RoleName);
				//Enter Role name
				usm.Enter_FirstName(RoleName);
				
				//Enter Priority
				cmp.Enter_Priority("3");
				
				//Open the POS Operations Screen
				driver.findElement(By.xpath("//a[contains(.,'POS OPERATIONS')]/..//i")).click();
				
				//Click the Select All
				if(driver.findElement(By.xpath("//span[contains(.,'ADJUST TIME CLOCK')]/../input")).isEnabled())
				{
					
				}
				else
				{
					driver.findElement(By.xpath("//span[contains(.,'ADJUST TIME CLOCK')]/../input")).click();
				}
				
				//Close the POS Operations screen
				driver.findElement(By.xpath("//a[contains(.,'POS OPERATIONS')]/..//i")).click();
				
				//Click the Save button
				cmp.Click_SaveButton();
				
				cmp.Wait_ForElementVisibility(driver.findElement(By.xpath("//div[@role='alert']/span/span")), 30);
				
				//Verify whether the Role Saved or not
				if(driver.findElement(By.xpath("//div[@role='alert']/span/span")).getText().equalsIgnoreCase("Role Saved successfully"))
				{
					test.log(LogStatus.PASS, "Role Saved successfully");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Role Save Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
		
	}
	
	@Test(priority = 5,enabled = true)
	public void Edit_Role_Enable_Time_Clock() throws Exception
	{
	
		cmp=new Common_XPaths(driver, test);
		usm=new UserManagementPage(driver, test);
		
		//Search the Role
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@ng-model='searchText']")).sendKeys("Bartender");
		
		Thread.sleep(2000);
		//Click the Edit button
		driver.findElement(By.xpath("//td[contains(.,'Bartender')]/../td[3]//a[@title='edit']")).click();
		
		
		//Open the POS Operations Screen
		driver.findElement(By.xpath("//a[contains(.,'POS OPERATIONS')]/..//i")).click();
		
		//Click the Select All
		if(driver.findElement(By.xpath("//span[contains(.,'ADJUST TIME CLOCK')]/../input")).isEnabled())
		{
			
		}
		else
		{
			driver.findElement(By.xpath("//span[contains(.,'ADJUST TIME CLOCK')]")).click();
		}
		
		//Close the POS Operations screen
		driver.findElement(By.xpath("//a[contains(.,'POS OPERATIONS')]/..//i")).click();
		
		//Click the Save button
		driver.findElement(By.xpath("//button/span[.='Update']")).click();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
		
		//Verify whether the Role Saved or not
		if(driver.findElement(By.xpath("//div[@role='alert']/span/span")).getText().equalsIgnoreCase("Role Updated successfully"))
		{
			test.log(LogStatus.PASS, "Role Updated successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Role Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

		
		//Load the Upcharge page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id6")+"users");

		Thread.sleep(5000);
		//Verify the Open Check Discount page loeded or not
		cmp.VerifyMainScreenPageHeader("Users");	
		
//		//Get the List of rows 
//		List<WebElement> roleList=driver.findElements(By.xpath("//td[@data-title-text='First Name']/../td[@data-title-text='Roles']/div[contains(.,'Bartender')]"));
//		
		
		
//		for(WebElement role:roleList)
//		{
//			if(role.getText().equalsIgnoreCase("BarTender"))
//			{
//				String RoleName=driver
//			}
//		}
//		
//		
//		//Search the User
//		driver.findElement(By.xpath("")).clear();
//		Thread.sleep(1000);
//		driver.findElement(By.xpath("")).sendKeys("Bartender");
		
			
		//Navigating to Payroll Report Settings
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"manageBreaksSettings");

		//Click the New Break
		driver.findElement(By.xpath("//button[contains(.,'New Break')]")).click();
		
		Thread.sleep(5000);
		//Verify the Open Check Discount page loeded or not
		cmp.VerifyMainScreenPageHeader("Manage Breaks");	
		
				
		//Select Break Name
		Select sel=new Select(driver.findElement(By.name("breakName")));
		sel.selectByVisibleText("Meal Break");
		
		driver.findElement(By.xpath("//input[@name='payrollType']/../span[.='Paid']")).click();
		
		//Clear the Duration in mins
		driver.findElement(By.xpath("//input[@name='duration']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='duration']")).sendKeys("0");
		
		if(driver.findElement(By.xpath("//span[contains(.,' Duration minimum 1 mins and maximum 100 mins')]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Duration minimum 1 mins and maximum 100 mins Error is Displayed when Entering below 1");
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Duration minimum 1 mins and maximum 100 mins Error is not Displayed when Entering below 1");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Clear the Duration in mins
		driver.findElement(By.xpath("//input[@name='duration']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='duration']")).sendKeys("980");
		
		if(driver.findElement(By.xpath("//span[contains(.,' Duration minimum 1 mins and maximum 100 mins')]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Duration minimum 1 mins and maximum 100 mins Error is Displayed when Entering above 100");
			
		}
		else
		{
			test.log(LogStatus.FAIL, "Duration minimum 1 mins and maximum 100 mins Error is not Displayed when Entering above 100");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Clear the Duration in mins
		driver.findElement(By.xpath("//input[@name='duration']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@name='duration']")).sendKeys("20");
		
		
		//Select the Apply to Check Time Clock enabled role Displayed or not
		driver.findElement(By.xpath("//input[@ng-model='breakSettings.applyTo']/../span[.='Specific roles']")).click();
		
		//Click the Select Roles
		driver.findElement(By.name("roles")).click();
		
		//Check whether the Time Clock Role displayed or not in the Select Roles List
		if(driver.findElement(By.xpath("//li[.='Bartender']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Time Clock Enabled Role is Displayed in Manage Breaks Roles List");
		}
		else
		{
			test.log(LogStatus.FAIL, "Time Clock Enabled Role is not Displayed in Manage Breaks Roles List");

		}
		
		//Click the Select Roles
		driver.findElement(By.name("roles")).click();
				
		//Select Break Name
		Select sel1=new Select(driver.findElement(By.name("roles")));
		sel1.selectByVisibleText("Bartender");
		
		//Click the Add Break
		driver.findElement(By.xpath("//button[contains(.,'Add Break')]")).click();
		
		Thread.sleep(2000);
		//Verify whether the Role Saved or not
		if(driver.findElement(By.xpath("//div[@role='alert']/span/span")).getText().equalsIgnoreCase("Break Settings Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Break Settings Saved Successfully by Selecting Role");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Break Settings Saved Failed by Selecting Role");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(2000);
		//Click the New Break
				driver.findElement(By.xpath("//button[contains(.,'New Break')]")).click();
				
				Thread.sleep(5000);
				//Verify the Open Check Discount page loeded or not
				cmp.VerifyMainScreenPageHeader("Manage Breaks");	
				
						
				//Select Break Name
				Select sel11=new Select(driver.findElement(By.name("breakName")));
				sel11.selectByVisibleText("Meal Break");
				
				driver.findElement(By.xpath("//input[@name='payrollType']/../span[.='Paid']")).click();
				
				//Clear the Duration in mins
				driver.findElement(By.xpath("//input[@name='duration']")).clear();
				Thread.sleep(1000);
				driver.findElement(By.xpath("//input[@name='duration']")).sendKeys("10");
				
				
				//Select the Apply to Check Time Clock enabled role Displayed or not
				driver.findElement(By.xpath("//input[@ng-model='breakSettings.applyTo']/../span[.='Specific employees']")).click();
				
				
				//Select Break Name
				Select sel2=new Select(driver.findElement(By.name("employees")));
				sel2.selectByVisibleText("BarTender 1");
				
				driver.findElement(By.xpath("//li[.='BarTender 1']")).click();
				
				//Click the Add Break
				driver.findElement(By.xpath("//button[contains(.,'Add Break')]")).click();
				
				Thread.sleep(2000);
				//Verify whether the Role Saved or not
				if(driver.findElement(By.xpath("//div[@role='alert']/span/span")).getText().equalsIgnoreCase("Break Settings Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Break Settings Saved Successfully by Selecting Employees");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Break Settings Saved Failed by Selecting Employees");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
	}
	
}
