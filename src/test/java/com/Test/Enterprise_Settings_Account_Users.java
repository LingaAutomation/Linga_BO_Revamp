package com.Test;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.Pages.Common_XPaths;
import com.Pages.CoursingPage;
import com.Pages.LoginPage;
import com.Pages.Settings_StoreInformation_Page;
import com.Pages.UserManagementPage;
import com.Pages.UserMangement_Role_Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;

public class Enterprise_Settings_Account_Users 
{
	
public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise Settings - User Management - Account Users");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	UserManagementPage usm;
	CoursingPage cp;
	Settings_StoreInformation_Page sf;
	UserMangement_Role_Page umr;
//	Scheduler_Page sp;
	
	
	String Role;
	String EmailId;
	String Password;
	String PIN;
	
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
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().driverVersion("110.0.5841").setup();
//		driver=new ChromeDriver(chrOpt);

		System.setProperty("webdriver.chrome.driver", "./Automation Driver/chromedriver.exe");
		// Open the Chrome window
		driver = new ChromeDriver();
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
		Open_User_Management_Users_Page(driver);
		//RefreshAndPaginination_ColumnFilteration(driver);
		Add_User_Management_Users(driver);
		Edit_and_Close_Cancel_User_Management_Users(driver);
		Edit_and_Update_User_Management_Users(driver);
		ResetPassWord_User_Management_Users(driver);
		Delete_and_Active_Inactive_User_Management_Users(driver);
		Create_DuplicateCourse(driver);
	    
		
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_User_Management_Users_Page(WebDriver driver) throws Exception
	{
		
		usm=new UserManagementPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id7")+"home");
		
		Thread.sleep(10000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"accountUsers");

		Thread.sleep(5000);
		//Verify the User page loaded or not
		cmp.VerifyMainScreenPageHeader("Users");	
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination_ColumnFilteration(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		usm=new UserManagementPage(driver, test);
		cp=new CoursingPage(driver, test);
		
		//Verify the Pagination and Refresh the page
		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
		
		Thread.sleep(2000);
		//Verify Ascending order for name 
		cp.Verify_AscendingNameSorting();
		Thread.sleep(2000);

		//Verify Decending
		cp.Verify_DescendingNameSorting();
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_User_Management_Users(WebDriver driver) throws Exception
	{
		usm=new UserManagementPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		sf=new Settings_StoreInformation_Page(driver, test);
		


		Thread.sleep(5000);

				Thread.sleep(5000);
				//Verify the User page loaded or not
				cmp.VerifyMainScreenPageHeader("Account Users");	
				
		Thread.sleep(2000);
		//Click the New User
		usm.Click_New_Account_User();
		Thread.sleep(2000);
	
		//Verify the New Course creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Account User");
		Thread.sleep(2000);
		
		if(cmp.Save_ButtonTwo().isEnabled())
		{
		//Click the Save button
		cmp.Click_Save_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Name"))
		{
			test.log(LogStatus.PASS, "Please Enter Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.INFO, "Save button not Enabled without Entering First Name");
		}
		
		String NameExcess = "Entering Invalid Name to input"; 
		int ActualSize= NameExcess.length();
		System.out.println(ActualSize);

		//Enter the Modifier Name
		usm.Enter_FirstName(NameExcess);
		
		//To get value
		String ActualName=cmp.NameInputBox().getAttribute("value");
		int EnteredSize= ActualName.length();
		System.out.println(EnteredSize);

		if(ActualSize!=EnteredSize)
		{
			test.log(LogStatus.PASS, "Name should not be Exceeded 25 Characters");
		}
		else
		{
			test.log(LogStatus.FAIL, "Name should exceeded the size");
		}
		
		Thread.sleep(500);
		//Enter the Course Name
		usm.Enter_FirstName(Utility.getProperty("Account_User_FirstName"));
		
		if(cmp.Save_ButtonTwo().isEnabled())
		{
		//Click the Save button
		cmp.Click_Save_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enter Last Name"))
		{
			test.log(LogStatus.PASS, "Enter Last Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter Last Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.INFO, "Save button not Enabled without entering Last Name");
		}
		
		Thread.sleep(1000);

		//Enter the Last Name
		usm.Enter_LastName(Utility.getProperty("Account_User_LastName"));
		
		//Select Gender
		usm.Select_Gender("Male");
		
		//Select Date of Birth
       	usm.Select_Date_of_Birth("25-05-2023");
		
		//Verify Phone number
		new Settings_StoreInformation_Page(driver, test).VerifyPhoneNumber();
		
		//Enter Phone Number
		new Settings_StoreInformation_Page(driver, test).Enter_Phone_Number(Utility.getProperty("Account_User_PhoneNumber"));
		
		//Enter the Email
		usm.Enter_Email_ID2(Utility.getProperty("Account_Usermanagement_user_emailid"));
		
		//Select Language
		usm.Select_Language("English");
		
		//Select Date of Joining
		usm.Select_Date_of_Joining2("03-07-2023");
		
		cmp.Upload_Picture(Utility.getProperty("Settings_Store_Information_Store_Image_Path"));
		
		//Enter PIN
		usm.Enter_NewPassword("rere");
	
		try
		{
		if(cmp.Error_BelowInputBox().getText().equalsIgnoreCase("The Password Must Be In 6-12 Alphanumeric Characters"))
		{
		test.log(LogStatus.PASS, "Password msg is Displayed");	
		}
		}
		catch(Exception kl)
		{
			test.log(LogStatus.FAIL, "Password msg is not Displayed");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		usm.Enter_NewPassword(Utility.getProperty("Account_User_PassWord"));
		
		usm.Enter_ConfirmPassword(Utility.getProperty("Account_User_PassWord"));
		
		usm.Select_Store_input();
		
		usm.Enable_POS_Login();
		
		
		usm.Enter_PIN("asdfd");
		
		//Verify valid pin pop up
		try
		{
		if(cmp.Error_BelowInputBox().getText().equalsIgnoreCase("Enter valid user pin."))
		{
		test.log(LogStatus.PASS, "Enter valid user pin is Displayed");	
		}
		}
		catch(Exception kl)
		{
			test.log(LogStatus.FAIL, "Enter valid user pin is not Displayed");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enter PIN
		usm.Enter_PIN("111");
				
		//Verify valid pin pop up
		try
		{
		if(cmp.Error_BelowInputBox().getText().equalsIgnoreCase("Employee pin should be contain 4 digits."))
		{
				test.log(LogStatus.PASS, "Employee pin should be contain 4 digits is Displayed");	
		}
		}
		catch(Exception kp)
		{
				test.log(LogStatus.FAIL, "Employee pin should be contain 4 digits is not Displayed");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		String PINCode = RandomStringUtils.randomNumeric(5);
		this.PIN=PINCode;
		
		System.out.println("PIN No: "+PINCode);
		
		//Enter PIN
//		usm.Enter_PIN("9220");
		usm.Enter_PIN(PINCode);
		
		Thread.sleep(5000);
		
		//Select POS Initial Screen
		usm.Select_POS_Initial_Screen("POS Screen");
		
		
		
		
		//Enter Address Line
				new Settings_StoreInformation_Page(driver, test).Enter_Apartment("35, Radha Nagar main road, Chrompet");
				
				//Enter City
				new Settings_StoreInformation_Page(driver, test).Enter_City("Chennai");
				
				//Enter State
				new Settings_StoreInformation_Page(driver, test).Enter_ZipCode("600044");
				usm.Enabale_Central_kitchen();
				usm.Enable_all_Central_kitchen();
				usm.Enabale_Central_Warehouse();
				usm.Enable_all_Central_Warehouse();
				usm.Enabale_Customize();
				usm.Disable_Customize();
				usm.Enabale_Customize();
				usm.Enter_Rename_Sub_Recipe("kdeefc");
				usm.Enter_Rename_Sub_Prepare_Recipe("sadd");
				Thread.sleep(2000);
				//Click the Save button
				cmp.Click_Save_ButtonTwo();
				
				cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
				//Check whether the New Course Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("User Saved Successfully"))
				{
					test.log(LogStatus.PASS, "User Saved Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "User Save Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
		        
			
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_User_Management_Users(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		usm=new UserManagementPage(driver, test);
		
		Thread.sleep(500);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Account_User_FirstName"));
		
		//Click the Edit button
		usm.Click_Edit();
		
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Edit User");
		
		
		Thread.sleep(1000);
		//Click the Close button
		cmp.Click_BackspaceButton();
		
		Thread.sleep(1000);
		//Check whether the New Course Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Editing Course screen Closed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Editing Course screen not Closed");
		}
		
		
		
	}
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_User_Management_Users(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		usm=new UserManagementPage(driver, test);
	
		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		//cmp.SearchAndVerify_SearchBox();
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Account_User_FirstName"));
		
		//Click the Edit button
		
		usm.Click_Edit();
		
		Thread.sleep(500);
		//Enter the Name
		usm.Enter_FirstName("");
		
		if(cmp.Update_ButtonTwo().isEnabled())
		{
		//Click the Save button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Name"))
		{
			test.log(LogStatus.PASS, "Please Enter Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("User Updated Successfully"))
		{
			test.log(LogStatus.FAIL, "User Updated without User Name");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);

			Thread.sleep(1000);
			//Search and Click Edit button
			cmp.SearchAndClickEdit(Utility.getProperty("Account_User_FirstName"));
			
		}	
		else
		{
			test.log(LogStatus.INFO, "Please Enter Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.INFO, "Update button is not enabled without entering User Name");
		}
		
		try {
		Thread.sleep(1000);
	
		
		//Click the Edit button
		
		usm.Click_Edit();
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		
		Thread.sleep(500);
		//Enter the Name
		usm.Enter_FirstName(Utility.getProperty("Account_User_FirstName"));
	
		//Enter the Last Name
		usm.Enter_LastName("");
		/*
				if(cmp.Update_ButtonTwo().isEnabled())
				{
		//Click the Update button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Enter Last Name"))
		{
			test.log(LogStatus.PASS, "Enter Last Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Enter Last Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
				}
				else
				{
					test.log(LogStatus.INFO, "Update button is not Enabled without Entering Priority");
				}
		*/
		
		
		Thread.sleep(500);
		//Enter the Last Name
		usm.Enter_LastName(Utility.getProperty("Account_User_LastName"));
		
		
		
		Thread.sleep(500);
		//Click the Update button
		cmp.Click_Update_ButtonTwo();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("User Updated Successfully"))
		{
			test.log(LogStatus.PASS, "User Updated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "User Updated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void ResetPassWord_User_Management_Users(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		usm=new UserManagementPage(driver, test);
		umr=new UserMangement_Role_Page(driver, test);
		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		//cmp.SearchAndVerify_SearchBox();
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Account_User_FirstName"));
		Thread.sleep(1000);
		
	//	usm.Reset_Password().click();
		Thread.sleep(1000);
		//Click the Enable Sign In
		usm.Click_Reset_Password();
		Thread.sleep(1000);
		
		
		/*WebElement ele = driver.findElement(By.xpath("//button[contains(.,'RESET PASSWORD')]"));
		Thread.sleep(4000);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", ele);
		*/
		Thread.sleep(4000);
		driver.findElement(By.xpath("//button[contains(.,'RESET PASSWORD')]")).click();
		
	      umr.PassWord_input_DialogBox().clear();
				Thread.sleep(2000);
				String pass = RandomStringUtils.randomAlphanumeric(4);
				
				String PassWord = "S"+pass+"#"+123;
				
				System.out.println("Newly Created User PassWord "+PassWord);
				umr.PassWord_input_DialogBox().sendKeys(PassWord);
				Thread.sleep(2000);
				
				umr.Confirm_PassWord_input_DialogBox().clear();
				Thread.sleep(2000);
				umr.Confirm_PassWord_input_DialogBox().sendKeys(PassWord);
				
				Thread.sleep(2000);
				umr.Authenticate_button().click();
			
			Thread.sleep(5000);
			
			cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 50);
			
			if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sign in enabled successfully"))
			{
				test.log(LogStatus.PASS, "Sign in enabled successfully");
				ut.PassedCaptureScreenshotAsBASE64(driver, test);
			}
			else
			{
				test.log(LogStatus.FAIL, "Sign in enable failed");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Add_Payroll_Hourly_User_Management_Users(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		usm=new UserManagementPage(driver, test);
		
		Thread.sleep(500);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("User_FirstName"));
		
		//Click the Edit button
		usm.Click_Edit();
		
		Thread.sleep(500);
		//Enter the Name
		usm.Enter_FirstName(Utility.getProperty("User_FirstName"));
	
		
		//Click the Add Payroll button
		usm.Click_Add_Payroll();
		
		//Verify whether the New Payroll page opened or not
		cmp.VerifyCreationScreenPageHeader_Two("New Payroll");
		
		//Click Hourly
		usm.Hourly_RadioButton().click();
		
		//Click the Save button
		cmp.Click_SaveButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 5);
		//Check whether the New Payroll added or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Added Successfully"))
		{
			test.log(LogStatus.PASS, "New Payment Added Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "New Payment Adding Failed");
		}
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 15);
		//Check whether the New Payroll added or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("User Updated Successfully"))
		{
			test.log(LogStatus.PASS, "User Updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "User Updated Failed");
		}
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Add_Payroll_Monthly_User_Management_Users(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		usm=new UserManagementPage(driver, test);
		
		Thread.sleep(500);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("User_FirstName"));
		
		//Click the Edit button
		usm.Click_Edit();
		
		//Click the Add Payroll button
		usm.Click_Add_Payroll();
		
		//Click Hourly
		usm.Hourly_RadioButton().click();
		
		//Click the Save button
		cmp.Click_SaveButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 5);
		//Check whether the New Payroll added or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Added Successfully"))
		{
			test.log(LogStatus.FAIL, "New Payment Added Successfully with Same Date");
	
			//Search and Click Edit button
			cmp.SearchAndClickEdit(Utility.getProperty("User_FirstName"));
			
			//Click the Edit button
			usm.Click_Edit();
			
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Effective Date already exists"))
		{
			test.log(LogStatus.INFO, "Effective Date already exists is displayed");
		
			
		}
		else
		{
			test.log(LogStatus.FAIL, "New Payment Adding Failed");
		}
		
		
		//Click the Cancel button
		cmp.Click_CancelButton();
		
		//Click the Edit button
		driver.findElement(By.xpath("//div[@id='payroll']//div[contains(@class,'cdk-drop-list')]/div[1]/div/data-grid-row//div[4]//button")).click();
		
		//Verify whether the New Payroll page opened or not
				cmp.VerifyCreationScreenPageHeader_Two("Update Payroll");
				
				//Click Hourly
				usm.Monthly_RadioButton().click();
				
				//Enter the Price
				usm.Enter_Price("1000");
				
				//Click the Update button
				cmp.Click_UpdateButton();
				
				cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 5);
				//Check whether the New Payroll added or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Added Successfully"))
				{
					test.log(LogStatus.PASS, "Payroll Updated as Monthly Successfully");
				}
				else
				{
					test.log(LogStatus.FAIL, "Payroll Update as Monthly Failed");
				}
				
		
		
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 15);
		//Check whether the New Payroll added or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("User Updated Successfully"))
		{
			test.log(LogStatus.PASS, "User Updated Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "User Updated Failed");
		}
		
		Thread.sleep(2000);
		Thread.sleep(500);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("User_FirstName"));
		
		//Click the Edit button
		usm.Click_Edit();
		
		//Click the Edit button
				driver.findElement(By.xpath("//div[@id='payroll']//div[contains(@class,'cdk-drop-list')]/div[1]/div/data-grid-row//div[4]//button")).click();
				
		//Verify whether the Monthly selected or not
		if(usm.Monthly_RadioButton().isEnabled())
		{
			test.log(LogStatus.PASS, "Monthly is Selecetd as Payroll");
		}
		else
		{
			test.log(LogStatus.FAIL, "Monthly is not Selecetd as Payroll");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		//Click the Hourly
		usm.Hourly_RadioButton().click();
		
		//Click the Update button
		cmp.Click_UpdateButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 5);
		//Check whether the New Payroll added or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Payment Added Successfully"))
		{
			test.log(LogStatus.PASS, "Payroll Updated as Hourly Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Payroll Update as Hourly Failed");
		}
		
		
		Thread.sleep(500);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("User_FirstName"));
		
		//Click the Edit button
		usm.Click_Edit();
		
		//Click the Edit button
				driver.findElement(By.xpath("//div[@id='payroll']//div[contains(@class,'cdk-drop-list')]/div[1]/div/data-grid-row//div[4]//button")).click();
				
		//Verify whether the Monthly selected or not
		if(usm.Hourly_RadioButton().isEnabled())
		{
			test.log(LogStatus.PASS, "Hourly is Selecetd as Payroll");
		}
		else
		{
			test.log(LogStatus.FAIL, "Hourly is not Selecetd as Payroll");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		//Click the Cancel button
		cmp.Click_CancelButton();
		
		//Click the Back button
		cmp.Click_BackspaceButton();
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_User_Management_Users(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		usm=new UserManagementPage(driver, test);
		
		//Search and Click Delete button
		cmp.SearchAndClickEdit(Utility.getProperty("Account_User_FirstName"));
		
		//Click the Delete button
		usm.Click_Delete();
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		Thread.sleep(3000);
		try
		{
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("User Inactivated Successfully"))
		{
			test.log(LogStatus.FAIL, "User Deleted when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "User not Deleted when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
		
		//Search and Click Delete button
		cmp.SearchAndClickEdit(Utility.getProperty("Account_User_FirstName"));
		
		//Click the Delete button
				usm.Click_Delete();
				
		
		//Click Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("User Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "User Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "User Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		usm.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("Account_User_FirstName"));
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();

				try
				{
				Thread.sleep(3000);
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("User Activated Successfully"))
				{
					test.log(LogStatus.FAIL, "User Activated when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "User not Activated when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}

		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("Account_User_FirstName"));
		
		//Click Activate button
				cmp.Click_ActivateButton();
				
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("User Activated Successfully"))
		{
			test.log(LogStatus.PASS, "User activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "User activated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(500);
		//Enable Active Status
		usm.Click_InactivetoActiveButton();
				
		Thread.sleep(500);
		//Check whether verify whether the Active page opened or not
		cmp.VerifyActive_InactiveStatus("Active");
		
		Thread.sleep(1000);
		//Search the User to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("Account_User_FirstName"));
		
		Thread.sleep(1000);
		usm.Click_Edit();
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_BackspaceButton();
		
	}
	
	@Test(priority = 6,enabled = false)
	public void Create_DuplicateCourse(WebDriver driver) throws Exception
	{
		usm=new UserManagementPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the New User
		usm.Click_New_Account_User();
		Thread.sleep(2000);
	
		//Verify the New Course creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Account User");
		Thread.sleep(2000);
	
		Thread.sleep(500);
		//Enter the existing Course name
		usm.Enter_FirstName(Utility.getProperty("Account_User_FirstName"));
		
		Thread.sleep(1000);
		//Enter the Last Name
		usm.Enter_LastName(Utility.getProperty("Account_User_LastName"));
		
		//Select Gender
				usm.Select_Gender("Male");
				
				//Select Date of Birth
		       	usm.Select_Date_of_Birth("25-05-2023");
				
				//Verify Phone number
				new Settings_StoreInformation_Page(driver, test).VerifyPhoneNumber();
				
				//Enter Phone Number
				new Settings_StoreInformation_Page(driver, test).Enter_Phone_Number(Utility.getProperty("Account_User_PhoneNumber"));
				
				//Enter the Email
				usm.Enter_Email_ID2(Utility.getProperty("Account_Usermanagement_user_emailid"));
				
				//Select Language
				usm.Select_Language("English");
				
				//Select Date of Joining
				usm.Select_Date_of_Joining2("03-07-2023");
				
				cmp.Upload_Picture(Utility.getProperty("Settings_Store_Information_Store_Image_Path"));
				
				//Enter PIN
				usm.Enter_NewPassword("rere");
			
				try
				{
				if(cmp.Error_BelowInputBox().getText().equalsIgnoreCase("The Password Must Be In 6-12 Alphanumeric Characters"))
				{
				test.log(LogStatus.PASS, "Password msg is Displayed");	
				}
				}
				catch(Exception kl)
				{
					test.log(LogStatus.FAIL, "Password msg is not Displayed");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				usm.Enter_NewPassword(Utility.getProperty("Account_User_PassWord"));
				
				usm.Enter_ConfirmPassword(Utility.getProperty("Account_User_PassWord"));
				
				usm.Select_Store_input();
				
				usm.Enable_POS_Login();
				
				
				usm.Enter_PIN("asdfd");
				
				//Verify valid pin pop up
				try
				{
				if(cmp.Error_BelowInputBox().getText().equalsIgnoreCase("Enter valid user pin."))
				{
				test.log(LogStatus.PASS, "Enter valid user pin is Displayed");	
				}
				}
				catch(Exception kl)
				{
					test.log(LogStatus.FAIL, "Enter valid user pin is not Displayed");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Enter PIN
				usm.Enter_PIN("111");
						
				//Verify valid pin pop up
				try
				{
				if(cmp.Error_BelowInputBox().getText().equalsIgnoreCase("Employee pin should be contain 4 digits."))
				{
						test.log(LogStatus.PASS, "Employee pin should be contain 4 digits is Displayed");	
				}
				}
				catch(Exception kp)
				{
						test.log(LogStatus.FAIL, "Employee pin should be contain 4 digits is not Displayed");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				String PINCode = RandomStringUtils.randomNumeric(5);
				this.PIN=PINCode;
				
				System.out.println("PIN No: "+PINCode);
				
				//Enter PIN
//				usm.Enter_PIN("9220");
				usm.Enter_PIN(PINCode);
				
				Thread.sleep(5000);
				
				//Select POS Initial Screen
				usm.Select_POS_Initial_Screen("POS Screen");
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_Save_ButtonTwo();
		
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "User Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error(s)"))
		{
			test.log(LogStatus.PASS, "Validation Error(s) pop up displayed");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "User Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		

		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_BackspaceButton();
	}
	
	@Test(priority = 6,enabled = false)
	public void Verify_User_Login_and_User_Role_Integration(WebDriver driver) throws Exception
	{
		usm=new UserManagementPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Log Out
		new LoginTest().LogOut(driver, test);
		
		//Verify Login Page
		new LoginPage(driver, test).VerifyLoginPageHeader();
		
	
		//Enter Passowrd
		new LoginPage(driver, test).Login(EmailId, Password);
		
		//Load the Department page
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id6")+"Roles");

				Thread.sleep(5000);
				//Verify the User page loaded or not
				cmp.VerifyMainScreenPageHeader("Roles");	
				
				//Search and Edit the Role
				cmp.Search(Role);
				
				//Click the Edit button
				usm.Click_Edit();
				
				//Open the Back Office
				usm.Open_BackOffice_Screen();
				
				//Check whether the Select All Enabled in Back Office fields or not
				if(usm.Select_All_CheckBox().isEnabled())
				{
					test.log(LogStatus.PASS, "Role updated for the Added User");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Role not updated for the Added User");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Close the Back Office screen
				usm.Close_BackOffice_Screen();
				
				//Click the cancel button
				cmp.Click_CancelButton();
				
				Thread.sleep(5000);
				//Click the Logout
				new LoginTest().LogOut(driver, test);
				
				Thread.sleep(5000);
				new LoginTest().Login(driver, test);
				
				
	}
	
}
