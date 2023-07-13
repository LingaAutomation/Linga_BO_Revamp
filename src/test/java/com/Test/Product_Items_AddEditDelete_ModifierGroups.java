package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Pages.Availability_RestrictionTimePage;
import com.Pages.Common_XPaths;
import com.Pages.KitchenPrinterPage;
import com.Pages.ModifierGroupsPage;
import com.Pages.ModifiersPage;
import com.google.inject.Key;
import com.Pages.ModifierGroupsPage;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Product_Items_AddEditDelete_ModifierGroups 
{

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("AddEditDelete Modifier Groups");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	ModifierGroupsPage mgp;
	ModifiersPage mp;
	
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
//		System.setProperty("webdriver.chrome.driver",Utility.getProperty("Chrome_Driver_Path"));
//		//Open the Chrome window
//		driver = new ChromeDriver();
		
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
	
	
	@Test(priority=2)
	public void Calling() throws Exception
	{
		Open_ModifierGroups_Page(driver);
		RefreshAndPaginination(driver);
		Add_ModifierGroups(driver);
		Edit_and_Close_Cancel_ModifierGroups(driver);
		Edit_and_Update_ModifierGroups(driver);
		Edit_and_Sorting_Update_ModifierGroups(driver);
		Delete_and_Active_Inactive_ModifierGroups(driver);
		Add_ModifierGroups_BasicDetails(driver);
		Create_DuplicateModifierGroup(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_ModifierGroups_Page(WebDriver driver) throws Exception
	{
		
		mgp=new ModifierGroupsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Modifier page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"modifierGroup");

		Thread.sleep(5000);
		//Verify the Modifier Groups page loaded or not
		cmp.VerifyMainScreenPageHeader("Modifier Groups");	
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		
		//Verify the Pagination and Refresh the page
		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_ModifierGroups(WebDriver driver) throws Exception
	{
		mgp=new ModifierGroupsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		mp=new ModifiersPage(driver, test);
		
		Thread.sleep(2000);
		//Click the New Modifier Groups
		mgp.Click_NewModifierGroup();
		Thread.sleep(2000);
	
		//Verify the New Modifier creation screen opened or not 
		cmp.VerifyCreationScreenPageHeader_Two("New Modifier Group");
		Thread.sleep(2000);
		
		try
		{
			//Click Proceed to Inventory Menu Items Mapping
				mgp.Click_ProceedtoInventoryMenuItemsMappingTab();
				
				Thread.sleep(1000);
				if(mgp.ProceedtoInventoryMenuItemsMappingTab().isSelected())
				{
					test.log(LogStatus.FAIL, "Proceed to Inventory Menu Items Mapping not selected when Clicking Proceed Without Saving");

				}
			
		
		}
		catch(Exception p)
		{
			test.log(LogStatus.PASS, "Proceed to Inventory Menu Items Mapping not selected when Clicking Proceed Without Saving");
		}
				
		
		if(cmp.Save_and_PublishButton().isEnabled())
		{
						
						Thread.sleep(1000);
						//Click the Save and Publish button
						cmp.Click_Save_and_PublishButton();
						
						Thread.sleep(1500);
						//Check whether the New Course Saved or not
						if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Name"))
						{
							test.log(LogStatus.PASS, "Enter Name Alert Displayed");
						
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
						}
						else
						{
							test.log(LogStatus.FAIL, "Enter Name Alert not Displayed");
							
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
		}
		else
		{
			test.log(LogStatus.PASS, "Save and Publish button not Enabled without Entering Mandatory Details");
		}
						
						Thread.sleep(1000);
						//Click Basic Details Tab
						mp.Click_BasicDetailsTab();
		
						String NameExcess = "Entering Invalid Name to input"; 
						int ActualSize= NameExcess.length();
						System.out.println(ActualSize);
		
						//Enter the Modifier Name
						cmp.EnterName(NameExcess);
						
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
						
		Thread.sleep(1000);
		//Enter the Modifier Name
		cmp.EnterName(Utility.getProperty("Modifier_Group_Name")+"MGP");
		Thread.sleep(1000);

		//Click the Save and Publish button
		cmp.Click_Save_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Enter Priority"))
		{
			test.log(LogStatus.PASS, "Please Enter Priority Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Priority Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}

		
		Thread.sleep(500);
		//Enter Negative Priority
		mgp.Enter_Priority("-1");
		Thread.sleep(1000);
		
		//Check whether the Number should not be less than 0 pop up displayed or not
		mgp.Verify_InvalidNumberErrorMsg("Number should not be less than 0");
		
		//Enter Negative Priority
				mgp.Enter_Priority("0");
				
				//Check whether the Number should not be less than 0 pop up displayed or not
				mgp.Verify_InvalidNumberErrorMsg("Number should not be less than 0");
				
		Thread.sleep(1000);
		//Enter Negative Priority
		mgp.Enter_Priority("1000");
		Thread.sleep(1000);
		
		//Check whether the Number should not be less than 0 pop up displayed or not
		mgp.Verify_InvalidNumberErrorMsg("Number should not be more than 999");
		Thread.sleep(1000);

		
		//Enter the Priority
		mgp.Enter_Priority("2");
		Thread.sleep(500);

		//Enable Pizza Topping
		mgp.Disable_PizzaTopping();
		Thread.sleep(500);

		//Enable Hide Modifier Group 
		mgp.Disable_HideModifierGroup();
		Thread.sleep(500);

		//Click the Save and Publish button
		cmp.Click_Save_and_PublishButton();
				
				Thread.sleep(3000);
				//Check whether the New Course Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Select Modifier"))
				{
					test.log(LogStatus.PASS, "Please Select Modifier Alert Displayed");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Group Saved Successfully"))
				{
					test.log(LogStatus.FAIL, "Modifier Group Saved without Selecting Modifiers");
			
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
					Thread.sleep(5000);
					mgp.Click_NewModifierGroup();
					
					
				}
				else 
				{
					test.log(LogStatus.FAIL, "Please Select Modifier Alert not Displayed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
		
				Thread.sleep(1000);
				//Enter the Modifier Name
				cmp.EnterName(Utility.getProperty("Modifier_Group_Name"));
				Thread.sleep(500);

				//Enter the Priority
				mgp.Enter_Priority("2");
				Thread.sleep(500);

				//Enable Pizza Topping
				mgp.Disable_PizzaTopping();
				Thread.sleep(500);

				//Enable Hide Modifier Group 
				mgp.Disable_HideModifierGroup();
					
				Thread.sleep(500);
		//Select Modifiers
		mgp.Select_Modifiers();
		
		Thread.sleep(500);
		//Enable Set Price Here button
		mp.Enable_SetPriceHere();
		
		Thread.sleep(500);
		//Select Serving size and Enter the Price
		mgp.Enter_SetPriceHere("500");
		
		Robot rt=new Robot();
		Thread.sleep(1000);
		rt.keyPress(KeyEvent.VK_UP);
		
		
		Thread.sleep(1000);

		driver.findElement(By.tagName("html")).sendKeys(Keys.HOME);
		
		Thread.sleep(1000);

		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_UP);
		Thread.sleep(1000);

		
		for(int i=1;i<=5;i++)
		{
			Thread.sleep(1000);
		driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
		}
		
		Thread.sleep(1000);
		rt.keyPress(KeyEvent.VK_UP);
		Thread.sleep(1000);
		rt.keyPress(KeyEvent.VK_UP);
		Thread.sleep(1000);
		rt.keyPress(KeyEvent.VK_PAGE_UP);

		
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true);", cmp.Save_and_PublishButton());
	
		
		Thread.sleep(2000);
				//Click the Save and Proceed button
				cmp.Click_Save_and_PublishButton();
		 
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Group Saved Successfully"))
		{
			test.log(LogStatus.PASS, "New Modifier Group Saved Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifier Group Save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
//		//Click Proceed with Inventory Menu Items Mapping
//		mgp.Click_ProceedtoInventoryMenuItemsMappingTab();
//		
//		if(mgp.Inventory_MenuItemHeader().isDisplayed())
//		{
//			test.log(LogStatus.PASS, "Inventory Menu Items Mapping page opened");
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Inventory Menu Items Mapping page not open");
//		}
//		
//		//Click Save and Publish button
//		cmp.Click_Save_and_PublishButton();
//		
//		Thread.sleep(3000);
//		//Check whether the New Modifier Saved or not
//		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Saved Successfully"))
//		{
//			test.log(LogStatus.PASS, "New Modifier Saved Successfully");
//		
//			ut.PassedCaptureScreenshotAsBASE64(driver, test);
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "New Modifier Save Failed");
//			
//			ut.FailedCaptureScreenshotAsBASE64(driver, test);
//		}
	}
		
	@Test(priority = 5,enabled = false)
	public void Edit_and_Close_Cancel_ModifierGroups(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		mgp=new ModifierGroupsPage(driver, test);
		mp=new ModifiersPage(driver, test);

		
		Thread.sleep(1000);
		//Search the Modifier Groups to Click Edit and Cancel
		cmp.SearchAndClickEdit(Utility.getProperty("Modifier_Group_Name"));
		
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader_Two("Update Modifier Group");
		
		Thread.sleep(1000);
		//Click Cancel button
		cmp.Click_BackspaceButton();
		
		Thread.sleep(1000);
		//Check whether the New Modifier Creation form Closed or not
		if(!cmp.NewCreationScreenHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Modifier Group Cancelled");
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifier Group not Cancelled");
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Update_ModifierGroups(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		mgp=new ModifierGroupsPage(driver, test);
		mp=new ModifiersPage(driver, test);

		Thread.sleep(10000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
	
		
		Thread.sleep(1000);
		//Search and Verify the Search box when Entering 3 Characters
		cmp.SearchAndVerify_SearchBox();
		
		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Modifier_Group_Name"));
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Modifier_Group_Name")+"1");
		
		Thread.sleep(500);
		//Enable Hide Modifier Group
		mgp.Enable_HideModifierGroup();
	
		//Enable the Pizza Topping
		mgp.Enable_PizzaTopping();
		
		Thread.sleep(500);
		//Click the Update and Publish button
		cmp.Click_Update_and_PublishButton();
		
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Group Updated Successfully"))
		{
			test.log(LogStatus.PASS, "New Modifier Group updated successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "New Modifier Group updated fail");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		

	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_and_Sorting_Update_ModifierGroups(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		mgp=new ModifierGroupsPage(driver, test);
		mp=new ModifiersPage(driver, test);

		Thread.sleep(1000);
		//Search and Click Edit button
		cmp.SearchAndClickEdit(Utility.getProperty("Modifier_Group_Name")+"1");
		
		Thread.sleep(500);
		//Enter the Name
		cmp.EnterName(Utility.getProperty("Modifier_Group_Name"));
		
		Thread.sleep(1000);
		
		driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
		driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

		//Ascending sort Modifiers
				mgp.Verify_AscendingSortingforModifiers();
				
				Thread.sleep(500);
				//Click the Update and Publish button
				cmp.Click_Update_and_PublishButton();
				
				Thread.sleep(3000);
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Group Updated Successfully"))
				{
					test.log(LogStatus.PASS, "Modifier Group updated successfully for Ascending Sorting");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Modifier Group updated fail for Ascending Sort");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}	
		
				Thread.sleep(1000);
				//Search and Click Edit button
				cmp.SearchAndClickEdit(Utility.getProperty("Modifier_Group_Name"));
				Thread.sleep(1000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
				driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

				//Descending Sort modifiers
				mgp.Verify_DescendingSortingforModifiers();
				
				Thread.sleep(500);
				//Click the Update and Publish button
				cmp.Click_Update_and_PublishButton();
				
				Thread.sleep(3000);
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Group Updated Successfully"))
				{
					test.log(LogStatus.PASS, "Modifier Group updated successfully for Descending Sorting");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Modifier Group updated fail for Desending Sort");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}	
		
				Thread.sleep(1000);
				//Search and Click Edit button
				cmp.SearchAndClickEdit(Utility.getProperty("Modifier_Group_Name"));
				Thread.sleep(1000);
				driver.findElement(By.tagName("html")).sendKeys(Keys.PAGE_DOWN);
				driver.findElement(By.tagName("html")).sendKeys(Keys.UP);

				//Custom Sorting
				mgp.Verify_CustomSortforModifiers();
				
				
				Thread.sleep(500);
				//Click the Update and Publish button
				cmp.Click_Update_and_PublishButton();
				
				Thread.sleep(3000);
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Group Updated Successfully"))
				{
					test.log(LogStatus.PASS, "Modifier Group updated successfully for Custom Sort");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Modifier updated fail for Custom Sort");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}	
		
		
	
		
	}
	
	
	
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_ModifierGroups(WebDriver driver) throws Exception
	{
		Thread.sleep(500);
		
		cmp=new Common_XPaths(driver, test);
		mgp=new ModifierGroupsPage(driver, test);
		mp=new ModifiersPage(driver, test);

		//Search and Click Delete button
				cmp.SearchAndClickDelete(Utility.getProperty("Modifier_Group_Name"));
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();
		
				Thread.sleep(3000);
				try
				{
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Group Inactivated Successfully"))
				{
					test.log(LogStatus.FAIL, "Modifier Group Deleted when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Modifier Group not Deleted when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				
		//Search and Click Delete button
		cmp.SearchAndClickDelete(Utility.getProperty("Modifier_Group_Name"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Click_DeleteButton();
		
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Group Inactivated Successfully"))
		{
			test.log(LogStatus.PASS, "Modifier Group Inactivated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifier Group Inactivated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(Utility.getProperty("Modifier_Group_Name"));
		
		Thread.sleep(500);
		//Click the Delete button
		cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
		
		//Click the Cancel button
		cmp.Click_CancelButtonInAlert();

		try
		{
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Group Activated Successfully"))
		{
			test.log(LogStatus.FAIL, "Modifier Group Activated when clicking Cancel button");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		catch(Exception g)
		{
			test.log(LogStatus.PASS, "Modifier Group not Activated when Clicking Cancel button");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}

		//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("Modifier_Group_Name"));
				
		
		Thread.sleep(500);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Modifier Group activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifier Group activated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(500);
		//Enable Active Status
		cmp.Click_InactivetoActiveButton();
				
		Thread.sleep(500);
		//Check whether verify whether the Active page opened or not
		cmp.VerifyActive_InactiveStatus("Active");
		
	
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Add_ModifierGroups_BasicDetails(WebDriver driver) throws Exception
	{
		mgp=new ModifierGroupsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		mp=new ModifiersPage(driver, test);

		Thread.sleep(2000);
		//Click the New Modifier Groups
		mp.Click_NewModifier();
		Thread.sleep(2000);
		
		
				Thread.sleep(1000);
				//Enter the Modifier Name
				cmp.EnterName(Utility.getProperty("Modifier_Group_Name")+"A");
				
				Thread.sleep(500);
				//Enter the Priority
				mgp.Enter_Priority("2");
				
				//Enable Pizza Topping
				mgp.Enable_PizzaTopping();
				
				//Enable Hide Modifier Group 
				mgp.Enable_HideModifierGroup();
						
				//Select Modifiers
				mgp.Select_Modifiers();
				
				//Disable Set Price Here
				mp.Disable_SetPriceHere();
		
		//Click Save and Publish button
				cmp.Click_Save_and_PublishButton();
				
				Thread.sleep(3000);
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Modifier Saved Successfully"))
				{
					test.log(LogStatus.PASS, "New Modifier Saved Successfully with Basic Details");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "New Modifier Save Failed with Basic Details");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
	}
	
	@Test(priority = 6,enabled = false)
	public void Create_DuplicateModifierGroup(WebDriver driver) throws Exception
	{
		mgp=new ModifierGroupsPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		mp=new ModifiersPage(driver, test);

		Thread.sleep(2000);
		//Click the New Modifier Groups button
		mp.Click_NewModifier();
		Thread.sleep(2000);
		
	
		Thread.sleep(500);
		//Enter the existing Modifier name
		cmp.EnterName(Utility.getProperty("Modifier_Group_Name"));
		
		Thread.sleep(500);
		Thread.sleep(500);
		//Enter the Priority
		mgp.Enter_Priority("2");
		
		//Enable Pizza Topping
		mgp.Enable_PizzaTopping();
		
		//Enable Hide Modifier Group 
		mgp.Enable_HideModifierGroup();
				
		//Select Modifiers
		mgp.Select_Modifiers();

		
		Thread.sleep(2000);
		//Click the Save and Publish button
		cmp.Click_Save_and_PublishButton();
		
		
		Thread.sleep(3000);
		//Check whether the New Modifier Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Name already exist"))
		{
			test.log(LogStatus.PASS, "Modifier Name already exist pop up displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
			
			//Click the Back button
			cmp.Click_BackspaceButton();
		}
		else
		{
			test.log(LogStatus.FAIL, "Modifier Name already exist pop up not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
}
