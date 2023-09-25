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

import com.Pages.ACH_Settings_Page;
import com.Pages.Common_XPaths;
import com.Pages.CoursingPage;
import com.Pages.LoginPage;
import com.Pages.Settings_StoreInformation_Page;
import com.Pages.UserMangement_Role_Page;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;

public class Enterprise_Settings_ACH_Settings {

	public WebDriver driver;

	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Enterprise Settings - ACH_Settings");

	LoginPage lgpg;

	Utility ut = new Utility();

	Common_XPaths cmp;
	LoginTest a = new LoginTest();
	ACH_Settings_Page ACH;
	CoursingPage cp;
	Settings_StoreInformation_Page sf;
	UserMangement_Role_Page umr;
//	Scheduler_Page sp;

	String Role;
	String EmailId;
	String Password;
	String PIN;

	@AfterClass
	public void flushTest() throws Exception {
		Thread.sleep(2000);
		rep.endTest(test);
		rep.flush();
	}

	@AfterMethod
	public void TestFail(ITestResult result) throws Exception {
		if (result.getStatus() == ITestResult.FAILURE) {
			String scnsht = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64);

			String s = "data:image/png;base64," + scnsht;

			test.log(LogStatus.FAIL, test.addScreenCapture(s));

		}
	}

	@Test(priority = 1)
	public void Login() throws Exception {

		Thread.sleep(2000);
		// Call the chrome driver
//		ChromeOptions chrOpt=new ChromeOptions();
//		chrOpt.addArguments("--remote-allow-origins=*");
//		WebDriverManager.chromedriver().driverVersion("110.0.5841").setup();
//		driver=new ChromeDriver(chrOpt);

		System.setProperty("webdriver.chrome.driver", "./Automation Driver/chromedriver.exe");
		// Open the Chrome window
		driver = new ChromeDriver();
		// Wait for 30 seconds
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// Maximize the Chrome window
		driver.manage().window().maximize();
		Thread.sleep(1000);
		// Launch the URL
		driver.get(Utility.getProperty("appURL"));

		Thread.sleep(10000);
		a.Login(driver, test);
	}

	@Test(priority = 50)
	public void LogOut() throws Exception {
		a.LogOut(driver, test);
	}

	@Test(priority = 2)
	public void Calling() throws Exception {
		Open_Settings_ACH_Settings_Page(driver);
		Verify_Error_Message_ACH_Settings(driver);
		Verify_ACH_Settings_Without_saving(driver);
		

	}

	@Test(priority = 3, enabled = false)
	public void Open_Settings_ACH_Settings_Page(WebDriver driver) throws Exception {

		cmp = new Common_XPaths(driver, test);

		Thread.sleep(5000);
		// Load the Department page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id7") + "home");

		Thread.sleep(10000);
		// Load the Department page
		driver.get(Utility.getProperty("baseURL") + Utility.getProperty("store_Id2") + "ach");

		Thread.sleep(5000);
		// Verify the User page loaded or not
		cmp.VerifyCreationScreenPageHeader_Two("ACH Settings");
	}
	
	@Test(priority = 3, enabled = false)
	public void Verify_Error_Message_ACH_Settings(WebDriver driver) throws Exception {

		cmp = new Common_XPaths(driver, test);
		ACH = new ACH_Settings_Page(driver, test);
		//Destination_Name
		Thread.sleep(2000);
		ACH.Destination_Name().clear();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		ACH.Destination_Name().click();
		
		try {
		if(ACH.Destination_Name_Error_msg().isDisplayed()) {
			
			test.log(LogStatus.PASS, ACH.Destination_Name_Error_msg().getText()+"Error message is displayed");
		}
		else {
			test.log(LogStatus.FAIL,"Error message is not displayed");
		}
		}
		catch (Exception e) {
				test.log(LogStatus.FAIL,"Error message is not displayed");
			
		}
		String NameExcess = "Destination  Name should not be more than 50 enjoys";
		int ActualSize = NameExcess.length();
		System.out.println(ActualSize);

		// Enter the Modifier Name
		ACH.Destination_Name().sendKeys(NameExcess);

		// To get value
		String ActualName = cmp.NameInputBox().getAttribute("value");
		int EnteredSize = ActualName.length();
		System.out.println(EnteredSize);

		if (ActualSize != EnteredSize) {
			test.log(LogStatus.PASS, "Name should not be Exceeded 50 Characters");
		} else {
			test.log(LogStatus.FAIL, "Name should exceeded the size");
		}
		
		
		if(ACH.Destination_Name_char_50_Error_msg().isDisplayed()) {
			
			test.log(LogStatus.PASS, ACH.Destination_Name_char_50_Error_msg().getText()+" Error message is displayed");
		}
		else {
			test.log(LogStatus.FAIL,"Error message is not displayed");
		}

		ACH.Destination_Name().clear();
		
		Thread.sleep(2000);
		String Destination_Name = RandomStringUtils.randomAlphanumeric(7);
		Thread.sleep(2000);
		ACH.Destination_Name().sendKeys(Destination_Name);
		
		Thread.sleep(2000);
		ACH.Destination_Routing_Number().clear();
		Thread.sleep(2000);
		
		Thread.sleep(2000);
		ACH.Destination_Routing_Number().click();
		
		try {
		if(ACH.Destination_Routing_Number_error_message().isDisplayed()) {
			
			test.log(LogStatus.PASS, ACH.Destination_Routing_Number_error_message().getText()+"Error message is displayed");
		}
		else {
			test.log(LogStatus.FAIL,"Error message is not displayed");
		}
		}
		catch (Exception e) {
				test.log(LogStatus.FAIL,"Error message is not displayed");
			
		}
		
		//Destination_Routing_Number
		
            ACH.Destination_Routing_Number().clear();
		
		Thread.sleep(2000);
		String Destination_Routing_Number = RandomStringUtils.randomNumeric(10);
		Thread.sleep(10000);
		ACH.Destination_Routing_Number().sendKeys(Destination_Routing_Number);
		
		try {
		if(ACH.Destination_Routing_Number_error_message2().isDisplayed()) {
			
			test.log(LogStatus.PASS, ACH.Destination_Routing_Number_error_message2().getText()+"Error message is displayed");
		}
		else {
			test.log(LogStatus.FAIL,"Error message is not displayed");
		}
		}
		catch (Exception e) {
				test.log(LogStatus.FAIL,"Error message is not displayed");
			
		}
		
		   ACH.Destination_Routing_Number().clear();
			
			Thread.sleep(2000);
			String Destination_Routing_Number1 = RandomStringUtils.randomNumeric(8);
			Thread.sleep(2000);
			ACH.Destination_Routing_Number().sendKeys(Destination_Routing_Number1);
			
		//	Immediate_Origin_Name
			Thread.sleep(2000);
			ACH.Immediate_Origin_Name().clear();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			ACH.Immediate_Origin_Name().click();
			
			try {
			if(ACH.Immediate_Origin_Name_Error_message().isDisplayed()) {
				
				test.log(LogStatus.PASS, ACH.Immediate_Origin_Name_Error_message().getText()+"Error message is displayed");
			}
			else {
				test.log(LogStatus.FAIL,"Error message is not displayed");
			}
			}
			catch (Exception e) {
					test.log(LogStatus.FAIL,"Error message is not displayed");
				
			}
			String NameExcess2 = "Immediate_Origin_Name  Name should not be more than 50 enjoys";
			int ActualSize1 = NameExcess2.length();
			System.out.println(ActualSize1);

			// Enter the Modifier Name
			ACH.Immediate_Origin_Name().sendKeys(NameExcess);

			// To get value
			String ActualName1 = cmp.NameInputBox().getAttribute("value");
			int EnteredSize1 = ActualName1.length();
			System.out.println(EnteredSize1);

			if (ActualSize1 != EnteredSize1) {
				test.log(LogStatus.PASS, "Name should not be Exceeded 50 Characters");
			} else {
				test.log(LogStatus.FAIL, "Name should exceeded the size");
			}
			
			
			if(ACH.Immediate_Origin_char_50_Error_msg().isDisplayed()) {
				
				test.log(LogStatus.PASS, ACH.Immediate_Origin_char_50_Error_msg().getText()+" Error message is displayed");
			}
			else {
				test.log(LogStatus.FAIL,"Error message is not displayed");
			}

			ACH.Immediate_Origin_Name().clear();
			
			Thread.sleep(2000);
			String Immediate_Origin_Name = RandomStringUtils.randomAlphanumeric(7);
			Thread.sleep(2000);
			ACH.Immediate_Origin_Name().sendKeys(Immediate_Origin_Name);
			
			
			//Immediate_Origin_Number
			Thread.sleep(2000);
			ACH.Immediate_Origin_Number().clear();
			Thread.sleep(2000);
			
			Thread.sleep(2000);
			ACH.Immediate_Origin_Number().click();
			
			try {
			if(ACH.Immediate_Origin_Number_Error_message().isDisplayed()) {
				
				test.log(LogStatus.PASS, ACH.Immediate_Origin_Number_Error_message().getText()+"Error message is displayed");
			}
			else {
				test.log(LogStatus.FAIL,"Error message is not displayed");
			}
			}
			catch (Exception e) {
					test.log(LogStatus.FAIL,"Error message is not displayed");
				
			}
			
		
			
	            ACH.Immediate_Origin_Number().clear();
			
			Thread.sleep(2000);
			String Immediate_Origin_Number = RandomStringUtils.randomNumeric(10);
			Thread.sleep(10000);
			ACH.Immediate_Origin_Number().sendKeys(Immediate_Origin_Number);
			
			try {
			if(ACH.Immediate_Origin_Number_Error_msg2().isDisplayed()) {
				
				test.log(LogStatus.PASS, ACH.Immediate_Origin_Number_Error_msg2().getText()+"Error message is displayed");
			}
			else {
				test.log(LogStatus.FAIL,"Error message is not displayed");
			}
			}
			catch (Exception e) {
					test.log(LogStatus.FAIL,"Error message is not displayed");
				
			}
			
			   ACH.Immediate_Origin_Number().clear();
				
				Thread.sleep(2000);
				String Immediate_Origin_Number1 = RandomStringUtils.randomNumeric(8);
				Thread.sleep(2000);
				ACH.Immediate_Origin_Number().sendKeys(Immediate_Origin_Number1);
				
			
		
				Thread.sleep(2000);
				ACH.Company_Name().clear();
				Thread.sleep(2000);
				
				Thread.sleep(2000);
				ACH.Company_Name().click();
				
				try {
				if(ACH.Company_Name_Error_message().isDisplayed()) {
					
					test.log(LogStatus.PASS, ACH.Company_Name_Error_message().getText()+"Error message is displayed");
				}
				else {
					test.log(LogStatus.FAIL,"Error message is not displayed");
				}
				}
				catch (Exception e) {
						test.log(LogStatus.FAIL,"Error message is not displayed");
					
				}
				String NameExcess21 = "Immediate_Origin_Name  Name should not be more thans";
				int ActualSize11 = NameExcess21.length();
				System.out.println(ActualSize11);

				// Enter the Modifier Name
				ACH.Company_Name().sendKeys(NameExcess);

				// To get value
				String ActualName11 = cmp.NameInputBox().getAttribute("value");
				int EnteredSize11 = ActualName11.length();
				System.out.println(EnteredSize11);

				if (ActualSize11 != EnteredSize11) {
					test.log(LogStatus.PASS, "Name should not be Exceeded 25 Characters");
				} else {
					test.log(LogStatus.FAIL, "Name should exceeded the size");
				}
				
				
				if(ACH.Company_Name_Error_msg2().isDisplayed()) {
					
					test.log(LogStatus.PASS, ACH.Company_Name_Error_msg2().getText()+" Error message is displayed");
				}
				else {
					test.log(LogStatus.FAIL,"Error message is not displayed");
				}

				ACH.Company_Name().clear();
				
				Thread.sleep(2000);
				String Company_Name = RandomStringUtils.randomAlphanumeric(7);
				Thread.sleep(2000);
				ACH.Company_Name().sendKeys(Company_Name);
				
				//Company_Entry_Description
				
				Thread.sleep(2000);
				ACH.Company_Entry_Description().clear();
				Thread.sleep(2000);
				
				Thread.sleep(2000);
				ACH.Company_Entry_Description().click();
				
				try {
				if(ACH.Company_Entry_Description_Error_message().isDisplayed()) {
					
					test.log(LogStatus.PASS, ACH.Company_Entry_Description_Error_message().getText()+"Error message is displayed");
				}
				else {
					test.log(LogStatus.FAIL,"Error message is not displayed");
				}
				}
				catch (Exception e) {
						test.log(LogStatus.FAIL,"Error message is not displayed");
					
				}
				String NameExcess1 = "Destination  Name should not be more than 50 enjoys";
				int ActualSize111 = NameExcess1.length();
				System.out.println(ActualSize111);

				// Enter the Modifier Name
				ACH.Company_Entry_Description().sendKeys(NameExcess1);

				// To get value
				String ActualName111 = cmp.NameInputBox().getAttribute("value");
				int EnteredSize111 = ActualName111.length();
				System.out.println(EnteredSize111);

				if (ActualSize111 != EnteredSize111) {
					test.log(LogStatus.PASS, "Name should not be Exceeded 50 Characters");
				} else {
					test.log(LogStatus.FAIL, "Name should exceeded the size");
				}
				
				
				if(ACH.Company_Entry_Description_Error_msg2().isDisplayed()) {
					
					test.log(LogStatus.PASS, ACH.Company_Entry_Description_Error_msg2().getText()+" Error message is displayed");
				}
				else {
					test.log(LogStatus.FAIL,"Error message is not displayed");
				}

				ACH.Company_Entry_Description().clear();
				
				Thread.sleep(2000);
				String Company_Entry_Description = RandomStringUtils.randomAlphanumeric(7);
				Thread.sleep(2000);
				ACH.Company_Entry_Description().sendKeys(Company_Entry_Description);
				
				Thread.sleep(2000);
				if(driver.findElement(By.xpath("//date-picker[contains(@name,'effectiveDate')]//mat-datepicker-toggle/../../div[4]")).isDisplayed()) {
					Thread.sleep(2000);
					driver.findElement(By.xpath("//date-picker[contains(@name,'effectiveDate')]//mat-datepicker-toggle/../../div[4]")).click();
					Thread.sleep(2000);
					driver.findElement(By.xpath("//div[contains(@class,'mat-calendar-body-today')]")).click();
					Thread.sleep(2000);
					test.log(LogStatus.PASS,"Effective Entry Date is Selected");
				}
				Thread.sleep(2000);
				//Company_Discretionary_Data_Description
				Thread.sleep(2000);
				ACH.Company_Discretionary_Data_Description().clear();
				Thread.sleep(2000);
				
				Thread.sleep(2000);
				ACH.Company_Discretionary_Data_Description().click();
				
				
				String NameExcess11 = "Destination  Name should not be more than 100 enjoys DestinationName should not be more enjoys";
				int ActualSize1111 = NameExcess11.length();
				System.out.println(ActualSize1111);

				// Enter the Modifier Name
				ACH.Company_Discretionary_Data_Description().sendKeys(NameExcess11);

				// To get value
				String ActualName1111 = cmp.NameInputBox().getAttribute("value");
				int EnteredSize1111 = ActualName1111.length();
				System.out.println(EnteredSize1111);

				if (ActualSize1111 != EnteredSize1111) {
					test.log(LogStatus.PASS, "Name should not be Exceeded 100 Characters");
				} else {
					test.log(LogStatus.FAIL, "Name should exceeded the size");
				}
				
				
				try {
				if(ACH.Company_Discretionary_Data_Error_msg2().isDisplayed()) {
					
					test.log(LogStatus.PASS, ACH.Company_Discretionary_Data_Error_msg2().getText()+" Error message is displayed");
				}
				else {
					test.log(LogStatus.FAIL,"Error message is not displayed");
				}
				}
				catch (Exception e) {
					// TODO: handle exception
				}

				ACH.Company_Discretionary_Data_Description().clear();
				
				Thread.sleep(2000);
				String Company_Discretionary_Data_Description = RandomStringUtils.randomAlphanumeric(7);
				Thread.sleep(2000);
				ACH.Company_Discretionary_Data_Description().sendKeys(Company_Discretionary_Data_Description);

				//Company_ID_Number
				
				
				Thread.sleep(2000);
				ACH.Company_ID_Number().clear();
				Thread.sleep(2000);
				
				Thread.sleep(2000);
				ACH.Company_ID_Number().click();
				
				try {
				if(ACH.Company_ID_Number_Error_message().isDisplayed()) {
					
					test.log(LogStatus.PASS, ACH.Company_ID_Number_Error_message().getText()+"Error message is displayed");
				}
				else {
					test.log(LogStatus.FAIL,"Error message is not displayed");
				}
				}
				catch (Exception e) {
						test.log(LogStatus.FAIL,"Error message is not displayed");
					
				}
				String NameExcess211 = "12345678968";
				int ActualSize11111 = NameExcess211.length();
				System.out.println(ActualSize11111);

				// Enter the Modifier Name
				ACH.Company_ID_Number().sendKeys(NameExcess);

				// To get value
				String ActualName11111 = cmp.NameInputBox().getAttribute("value");
				int EnteredSize11111 = ActualName11111.length();
				System.out.println(EnteredSize11111);

				if (ActualSize11111 != EnteredSize11111) {
					test.log(LogStatus.PASS, "Name should not be Exceeded 10 Characters");
				} else {
					test.log(LogStatus.FAIL, "Name should exceeded the size");
				}
				
				
				if(ACH.Company_ID_Number_Error_msg2().isDisplayed()) {
					
					test.log(LogStatus.PASS, ACH.Company_ID_Number_Error_msg2().getText()+" Error message is displayed");
				}
				else {
					test.log(LogStatus.FAIL,"Error message is not displayed");
				}

				ACH.Company_ID_Number().clear();
				
				Thread.sleep(2000);
				String Company_ID_Number = RandomStringUtils.randomNumeric(7);
				Thread.sleep(2000);
				ACH.Company_ID_Number().sendKeys(Company_ID_Number);
				
				
//Originating_DFI_Number
				
				
				Thread.sleep(2000);
				ACH.Originating_DFI_Number().clear();
				Thread.sleep(2000);
				
				Thread.sleep(2000);
				ACH.Originating_DFI_Number().click();
				
				try {
				if(ACH.Company_ID_Number_Error_message().isDisplayed()) {
					
					test.log(LogStatus.PASS, ACH.Company_ID_Number_Error_message().getText()+"Error message is displayed");
				}
				else {
					test.log(LogStatus.FAIL,"Error message is not displayed");
				}
				}
				catch (Exception e) {
						test.log(LogStatus.FAIL,"Error message is not displayed");
					
				}
				String NameExcess2111 = "12345678968";
				int ActualSize111111 = NameExcess2111.length();
				System.out.println(ActualSize111111);

				// Enter the Modifier Name
				ACH.Originating_DFI_Number().sendKeys(NameExcess);

				// To get value
				String ActualName111111 = cmp.NameInputBox().getAttribute("value");
				int EnteredSize111111 = ActualName111111.length();
				System.out.println(EnteredSize111111);

				if (ActualSize111111 != EnteredSize111111) {
					test.log(LogStatus.PASS, "Name should not be Exceeded 10 Characters");
				} else {
					test.log(LogStatus.FAIL, "Name should exceeded the size");
				}
				
				
				if(ACH.Originating_DFI_Number_Error_msg2().isDisplayed()) {
					
					test.log(LogStatus.PASS, ACH.Originating_DFI_Number_Error_msg2().getText()+" Error message is displayed");
				}
				else {
					test.log(LogStatus.FAIL,"Error message is not displayed");
				}

				ACH.Originating_DFI_Number().clear();
				
				Thread.sleep(2000);
				String Originating_DFI_Number = RandomStringUtils.randomNumeric(7);
				Thread.sleep(2000);
				ACH.Originating_DFI_Number().sendKeys(Originating_DFI_Number);
				Thread.sleep(5000);
				cmp.Click_Save_ButtonTwo();
				Thread.sleep(5000);
				cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 40);
				// Check whether the New Course Saved or not
				if (cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Saved Successfully")) {
					test.log(LogStatus.PASS, "ACH Setting details save successfully.");

					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				} else {
					test.log(LogStatus.FAIL, "ACH Setting details save Failed");

					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
	
	
}
	
	@Test(priority = 3, enabled = false)
	public void Verify_ACH_Settings_Without_saving(WebDriver driver) throws Exception {

		cmp = new Common_XPaths(driver, test);
		ACH = new ACH_Settings_Page(driver, test);
		
		    Thread.sleep(2000);
			ACH.Destination_Name().clear();
			Thread.sleep(4000);
			String Destination_Name = RandomStringUtils.randomAlphanumeric(7);
			Thread.sleep(2000);
			ACH.Destination_Name().sendKeys(Destination_Name);
			Thread.sleep(2000);
			cmp.Click_BackspaceButton();
			Thread.sleep(2000);
			
			if(driver.findElement(By.xpath("//span[contains(.,'ACH Settings')]/..")).isDisplayed()) {
				Thread.sleep(2000);
				String ACH_Message = driver.findElement(By.xpath("//span[contains(.,'ACH Settings')]/../p")).getText();
				Thread.sleep(2000);
				System.out.println(ACH_Message+" Message is displayed");
				test.log(LogStatus.INFO, ACH_Message+" Message is displayed");
				
				Thread.sleep(2000);
				driver.findElement(By.xpath("//span[contains(.,'ACH Settings')]/..")).click();
				
			}
			
			
			Thread.sleep(2000);
			
			String Destination_Name2 = ACH.Destination_Name().getAttribute("value");
			
			if (Destination_Name.equalsIgnoreCase(Destination_Name2)) {
				test.log(LogStatus.FAIL, "Destination_Name are save with out clicking on save button");
			} else {
				test.log(LogStatus.PASS, "Destination_Name are not save with out clicking on save button");
			}
			
		
			
			
		
		
		
	}
}
