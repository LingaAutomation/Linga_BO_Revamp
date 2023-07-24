package com.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import com.Pages.Common_XPaths;
import com.Pages.InventoryCategoryPage;
import com.Pages.InventoryPage;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Category {
	
	
	public WebDriver driver;
	
	
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Category");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	InventoryPage air;
	InventoryCategoryPage icp;
	
	
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
	
	@Test(priority=2)
	public void Calling() throws Exception
	{
		Open_Category_Page(driver);
     	//RefreshAndPaginination_ColumnFilteration(driver);
		Add_New_Category_with_Enable_tax_intergration(driver);
		Add_New_Category_with_New_Inventory_tax_intergration(driver);
		Edit_Newly_Created_Category_cancel_Close(driver);
		Edit_Newly_Created_Category(driver);
		Delete_and_Active_Inactive_Category(driver);
		Create_Duplicate_Category(driver);
		Intergration_Category_Mapped_with_SubCategory(driver);
		Intergration_Category_Mapped_with_Subrecipe(driver);
		Intergration_Category_Mapped_with_Inventory_item(driver);
     	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Category_Page(WebDriver driver) throws Exception
	{
		
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"category");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Category");	
		
		
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination_ColumnFilteration(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		//Verify the Pagination and Refresh the page
		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
		cmp.Filter_Columns();
		
		Thread.sleep(2000);
		//Verify Ascending order for name 
		cmp.Ascending_And_Descending_Order();
		
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Add_New_Category_with_Enable_tax_intergration(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		icp=new InventoryCategoryPage(driver, test);
		
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"taxInventory");

		Thread.sleep(5000);
		
		if(icp.EnableTax_Yes().isDisplayed()) {
			
			icp.EnableTax_Yes().click();
		}
		
		Thread.sleep(5000);
		//icp.PublishButton().click();
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"category");

		Thread.sleep(5000);

		Thread.sleep(2000);
		icp.Click_NewCategory();
		
		//Verify the New Category creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Category");
		Thread.sleep(2000);
		icp.Name_category(Utility.getProperty("Inventory_Category_Name"));
		icp.Clear_Name_category();
		Thread.sleep(3000);
		
		/*
		if(icp.alert_text().getText().equalsIgnoreCase("Please Enter Name"))
		{
			test.log(LogStatus.PASS, "Please Enter Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		*/
		icp.Name_category(Utility.getProperty("Inventory_Category_Name"));
		Thread.sleep(3000);
		icp.Code_category(RandomStringUtils.randomNumeric(4));
		Thread.sleep(3000);
		try {
		icp.Select_tax();
		}
		catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Inventory tax is enable Yes , But tax is not enabled");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		}
		Thread.sleep(3000);
		icp.Description_Box("Description");
		icp.Click_Save_Btn();
		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("category saved successfully!."))
		{
			test.log(LogStatus.PASS, "category saved successfully!.");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "category save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Add_New_Category_with_New_Inventory_tax_intergration(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		icp=new InventoryCategoryPage(driver, test);
		
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"taxInventory");

		Thread.sleep(5000);
		
		if(icp.EnableTax_Yes().isDisplayed()) {
			
			icp.EnableTax_Yes().click();
		}
		
		driver.findElement(By.xpath("//span[contains(.,'NEW TAX')]")).click();
		Thread.sleep(2000);
		
		String taxout = RandomStringUtils.randomAlphanumeric(5);
		driver.findElement(By.xpath("//app-input[contains(@label,'Tax Name')]/div/div/mat-form-field/div//input")).sendKeys(taxout);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//app-input[contains(@label,'Percentage')]/div/div/mat-form-field/div//input")).sendKeys(RandomStringUtils.randomNumeric(3));
		Thread.sleep(2000);
		icp.Click_Save_Btn();
		
		Thread.sleep(5000);
		
		//icp.PublishButton().click();
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"category");

		Thread.sleep(5000);

		Thread.sleep(2000);
		icp.Click_NewCategory();
		
		//Verify the New Category creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Category");
		Thread.sleep(2000);
		icp.Name_category(Utility.getProperty("Inventory_Category_Name")+"1");
		icp.Clear_Name_category();
		Thread.sleep(3000);
		
		/*
		if(icp.alert_text().getText().equalsIgnoreCase("Please Enter Name"))
		{
			test.log(LogStatus.PASS, "Please Enter Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		*/
		icp.Name_category(Utility.getProperty("Inventory_Category_Name")+"1");
		Thread.sleep(3000);
		icp.Code_category(RandomStringUtils.randomNumeric(4));
		Thread.sleep(3000);
		try {
		icp.Select_Enable_tax_inventory(taxout);
		}
		catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Inventory tax is enable Yes , But tax is not enabled");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		}
		Thread.sleep(3000);
		icp.Description_Box("Description");
		icp.Click_Save_Btn();
		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("category saved successfully!."))
		{
			test.log(LogStatus.PASS, "category saved successfully!.");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "category save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 5,enabled = false)
	public void Edit_Newly_Created_Category_cancel_Close(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		icp=new InventoryCategoryPage(driver, test);
		
		Thread.sleep(1000);
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_Category_Name")+"1");
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Category");
		
		
		Thread.sleep(1000);
		//Click the Close button
		cmp.Click_CloseButton();
		
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
		
		
		Thread.sleep(1000);
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_Category_Name")+"1");
		Thread.sleep(500);
		//Check whether the Update screen opened or not
		cmp.VerifyCreationScreenPageHeader("Update Category");
		
		
		Thread.sleep(1000);
		//Click the Cancel button
		cmp.Click_CancelButton();
		
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
	public void Edit_Newly_Created_Category(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		icp=new InventoryCategoryPage(driver, test);
		
		
		cmp.SearchAndClickEdit(Utility.getProperty("Inventory_Category_Name")+"1");
	
		icp.Name_category(Utility.getProperty("Inventory_Category_Name")+"2");
		Thread.sleep(3000);
		icp.Code_category(RandomStringUtils.randomNumeric(4));
		Thread.sleep(3000);
		try {
		icp.Select_tax();
		}
		catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Inventory tax is enable Yes , But tax is not enabled");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		}
		Thread.sleep(3000);
		icp.Description_Box("Description");
		Thread.sleep(3000);
		cmp.Click_UpdateButton();
		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category updated successfully!."))
		{
			test.log(LogStatus.PASS, "Category updated successfully!.");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "category Update Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 5,enabled = false)
	public void Delete_and_Active_Inactive_Category(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		icp=new InventoryCategoryPage(driver, test);
		
		
		//Search and Click Delete button
				cmp.SearchAndClickDelete(Utility.getProperty("Inventory_Category_Name")+"2");
				
				Thread.sleep(500);
				//Click the Delete button
				cmp.Alert_PopupMsg("Are you sure you want to delete this item?");
				
				//Click the Cancel button
				cmp.Click_CancelButtonInAlert();

				Thread.sleep(3000);
				try
				{
				//Check whether the New Modifier Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Inactivated Successfully"))
				{
					test.log(LogStatus.FAIL, "Category Deleted when clicking Cancel button");
				
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.PASS, "Category not Deleted when Clicking Cancel button");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				
				//Search and Click Delete button
				cmp.SearchAndClickDelete(Utility.getProperty("Inventory_Category_Name")+"2");
				
				//Click Delete button
				cmp.Click_DeleteButton();
				
				Thread.sleep(3000);
				//Check whether the New Course Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Inactivated Successfully"))
				{
					test.log(LogStatus.PASS, "Category Inactivated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Category Inactivated Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Enable the Inactive Status
				cmp.Click_ActivetoInactiveButton();
				
				//Check whether the Inactive screen opened or not
				cmp.VerifyActive_InactiveStatus("Inactive");
				
				//Search and Activate the In activated item
						cmp.SearchAndClickActivate(Utility.getProperty("Inventory_Category_Name")+"2");
						
						Thread.sleep(500);
						//Click the Delete button
						cmp.Alert_PopupMsg("Are you sure you want to activate this item?");
						
						//Click the Cancel button
						cmp.Click_CancelButtonInAlert();

						try
						{
						Thread.sleep(3000);
						//Check whether the New Modifier Saved or not
						if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Activated Successfully"))
						{
							test.log(LogStatus.FAIL, "Category Activated when clicking Cancel button");
						
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						}
						catch(Exception g)
						{
							test.log(LogStatus.PASS, "Category not Activated when Clicking Cancel button");
							
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
						}

				
				//Search and Activate the In activated item
				cmp.SearchAndClickActivate(Utility.getProperty("Inventory_Category_Name")+"2");
				
				//Click Activate button
						cmp.Click_ActivateButton();
						
				
				Thread.sleep(3000);
				//Check whether the New Course Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category Activated Successfully"))
				{
					test.log(LogStatus.PASS, "Category activated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Category activated Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				Thread.sleep(500);
				//Enable Active Status
				cmp.Click_InactivetoActiveButton();
						
				Thread.sleep(500);
				//Check whether verify whether the Active page opened or not
				cmp.VerifyActive_InactiveStatus("Active");
				
				Thread.sleep(1000);
				//Search the Category to Click Edit and Cancel
				
				Thread.sleep(1000);
				//Click Cancel button
				//cmp.Click_CancelButton();
				

	}
	
	@Test(priority = 5,enabled = false)
	public void Create_Duplicate_Category(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		icp=new InventoryCategoryPage(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"taxInventory");

		Thread.sleep(5000);
		
		if(icp.EnableTax_Yes().isDisplayed()) {
			
			icp.EnableTax_Yes().click();
		}
		
		Thread.sleep(5000);
		//icp.PublishButton().click();
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"category");

		Thread.sleep(5000);

		Thread.sleep(2000);
		icp.Click_NewCategory();
		
		//Verify the New Category creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Category");
		Thread.sleep(2000);
		icp.Name_category(Utility.getProperty("Inventory_Category_Name"));
		icp.Clear_Name_category();
		Thread.sleep(3000);
		
		
		icp.Name_category(Utility.getProperty("Inventory_Category_Name"));
		Thread.sleep(3000);
		icp.Code_category(RandomStringUtils.randomNumeric(4));
		Thread.sleep(3000);
		try {
		icp.Select_tax();
		}
		catch (Exception e) {
			
			test.log(LogStatus.FAIL, "Inventory tax is enable Yes , But tax is not enabled");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		
		}
		Thread.sleep(3000);
		icp.Description_Box("Description");
		icp.Click_Save_Btn();
		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Category name already exist"))
		{
			test.log(LogStatus.PASS, "Category name already exist");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Category name already exist pop not displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(1000);
		//Click the Cancel button
		cmp.Click_CancelButton();
		
}
	
	@Test(priority = 5,enabled = false)
	public void Intergration_Category_Mapped_with_SubCategory(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		icp=new InventoryCategoryPage(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"taxInventory");

		Thread.sleep(5000);
		
		if(icp.EnableTax_Yes().isEnabled()) {
			
			icp.EnableTax_No().click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//h4[contains(.,'Reminder')]/../../../..//button[contains(.,'Yes')]")).click();
			Thread.sleep(2000);
		}
		else {
			icp.EnableTax_No().click();
		}
		Thread.sleep(5000);
		//icp.PublishButton().click();
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"category");

		Thread.sleep(5000);

		Thread.sleep(2000);
		icp.Click_NewCategory();
		
		//Verify the New Category creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Category");
		Thread.sleep(2000);
		icp.Name_category(Utility.getProperty("Inventory_Category_Name")+"5");
		Thread.sleep(3000);
		icp.Clear_Name_category();
		Thread.sleep(3000);
		
		/*
		if(icp.alert_text().getText().equalsIgnoreCase("Please Enter Name"))
		{
			test.log(LogStatus.PASS, "Please Enter Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		*/
		
		String category = RandomStringUtils.randomAlphanumeric(5);
		icp.Name_category(category);
		Thread.sleep(3000);
		
		
		Thread.sleep(3000);
		icp.Code_category(RandomStringUtils.randomNumeric(4));
		

		Thread.sleep(3000);
		icp.Description_Box("Description");
		icp.Click_Save_Btn();
		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("category saved successfully!."))
		{
			test.log(LogStatus.PASS, "category saved successfully!.");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "category save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//Thread.sleep(5000);
		//icp.PublishButton().click();
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"subCategory");
		Thread.sleep(5000);
		
	String Subcategory = RandomStringUtils.randomAlphanumeric(5);
	    Thread.sleep(3000);
	    icp.Click_NewSubCategory();
	    Thread.sleep(3000);
		icp.Name_category(Subcategory);
		Thread.sleep(3000);
		icp.Select_Category(category);
		Thread.sleep(3000);
		icp.Code_category(RandomStringUtils.randomNumeric(4));
		
		Thread.sleep(3000);
		icp.Description_Box("Description");
		Thread.sleep(3000);
		icp.Click_Save_Btn();
		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("category saved successfully!."))
		{
			test.log(LogStatus.PASS, "category saved successfully!.");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "category save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	
	
	}
	
	@Test(priority = 5,enabled = false)
	public void Intergration_Category_Mapped_with_Subrecipe(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		icp=new InventoryCategoryPage(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"taxInventory");

		Thread.sleep(5000);
		
		if(icp.EnableTax_Yes().isEnabled()) {
			
			icp.EnableTax_No().click();
			try {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//h4[contains(.,'Reminder')]/../../../..//button[contains(.,'Yes')]")).click();
			Thread.sleep(2000);
			}
			catch (Exception e) {
				// TODO: handle exception
			}
 		}
		else {
			icp.EnableTax_No().click();
		}
		Thread.sleep(5000);
		//icp.PublishButton().click();
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"category");

		Thread.sleep(5000);

		Thread.sleep(2000);
		icp.Click_NewCategory();
		
		//Verify the New Category creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Category");
		Thread.sleep(2000);
		String cat2 = RandomStringUtils.randomAlphanumeric(6);
		icp.Name_category(cat2);
		Thread.sleep(3000);
		icp.Clear_Name_category();
		Thread.sleep(3000);
		
		/*
		if(icp.alert_text().getText().equalsIgnoreCase("Please Enter Name"))
		{
			test.log(LogStatus.PASS, "Please Enter Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		*/
		
		String category = RandomStringUtils.randomAlphanumeric(5);
		icp.Name_category(category);
		Thread.sleep(3000);
		
		
		Thread.sleep(3000);
		icp.Code_category(RandomStringUtils.randomNumeric(4));
		

		Thread.sleep(3000);
		icp.Description_Box("Description");
		icp.Click_Save_Btn();
		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("category saved successfully!."))
		{
			test.log(LogStatus.PASS, "category saved successfully!.");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "category save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		Thread.sleep(5000);
		//icp.PublishButton().click();
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"subRecipe");

		Thread.sleep(5000);

	Thread.sleep(2000);
	//Click the New Coursing
	air.Click_New_SubRecipe();
	Thread.sleep(2000);

	//Verify the New Course creation screen opened or not
	cmp.VerifyCreationScreenPageHeader("New Sub Recipe");
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
		test.log(LogStatus.INFO, "Save button not Enabled without Entering Sub Recipe Name");
	}
	
	//Verify whether the Entering Name character limits in Input
	cmp.Verify_Enter_Excess_Limit_Name(cmp.NameInputBox());
	
	
	
	
	Thread.sleep(500);
	String Inventory_SubRecipe_Name = RandomStringUtils.randomAlphanumeric(5);
	//Enter the Course Name
	cmp.EnterName(Inventory_SubRecipe_Name);
	
	if(cmp.Save_ButtonTwo().isEnabled())
	{
	//Click the Save button
	cmp.Click_Save_ButtonTwo();
	
	Thread.sleep(3000);
	test.log(LogStatus.FAIL, "Save button Enabled without Selecting Inventory Item");
	}
	else
	{
		test.log(LogStatus.PASS, "Save button not Enabled without Selecting Inventory Item");
	}
	
	//Select the Inventory Item
	air.Select_Inventory_Unit();
	
	//Enable Calculate COGS on Cost Price
	air.Calculate_COGS_onCost_Price_YesToggle().click();
	
	//Enter Preparation Notes
	air.Enter_Preparation_Notes(Inventory_SubRecipe_Name);
	
	//Enter the Quantity
	air.Enter_Quantity("100");
	
	if(cmp.Save_ButtonTwo().isEnabled())
	{
	//Click the Save button
	cmp.Click_Save_ButtonTwo();
	
	Thread.sleep(3000);
	test.log(LogStatus.FAIL, "Save button Enabled without Entering Quanity");
	}
	else
	{
		test.log(LogStatus.PASS, "Save button not Enabled without Entering Quantity");
	}
	
	//Enter the Yield %
	air.Enter_Yield_Percentage("105.00");
	
	//Verify the Enter Yield Should Not Be Greater Than 100 Warning Pop up displayed or not
	air.Verify_Yield_Warning_Above_100Percentage();
	
	//Enter the Yield %
	air.Enter_Yield_Percentage("50.00");
			
	//Enter the Price Per Unit
	air.Enter_Price_Per_Unit("10");
	
	//Create the New Storage
//	air.Create_New_Storage(ut.getProperty("Inventory_SubRecipe_Primary_Storage_Name"), "Primary Storage Saved");
	air.Select_Primary_Storage();
	
	//Add the Recipe Units
	air.Add_Receipe_Units("10");
	
	//Add the Inventory Item
	air.Click_Add_InventoryItem();
	
	if(cmp.Save_ButtonTwo().isEnabled())
	{
	//Click the Save button
	cmp.Click_Save_ButtonTwo();
	
	Thread.sleep(3000);
	test.log(LogStatus.FAIL, "Save button Enabled without Selecting Inventory/SubRecipes/Manual Entry Items");
	}
	else
	{
		test.log(LogStatus.PASS, "Save button not Enabled without Selecting Inventory/SubRecipes/Manual Entry Items");
	}
	
	//Select and Add the Inventory Items
	Thread.sleep(3000);
	cmp.Click_BackspaceButton();
	Thread.sleep(3000);
}
	
	@Test(priority = 5,enabled = false)
	public void Intergration_Category_Mapped_with_Inventory_item(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		icp=new InventoryCategoryPage(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"taxInventory");

		Thread.sleep(5000);
		
		if(icp.EnableTax_Yes().isEnabled()) {
			
			icp.EnableTax_No().click();
			Thread.sleep(2000);
			try {
			driver.findElement(By.xpath("//h4[contains(.,'Reminder')]/../../../..//button[contains(.,'Yes')]")).click();
			}
			catch (Exception e) {
				// TODO: handle exception
			}
			Thread.sleep(2000);
		}
		else {
			icp.EnableTax_No().click();
		}
		Thread.sleep(5000);
		//icp.PublishButton().click();
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"category");

		Thread.sleep(5000);

		Thread.sleep(2000);
		icp.Click_NewCategory();
		
		//Verify the New Category creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Category");
		Thread.sleep(2000);
		String cat2 = RandomStringUtils.randomAlphanumeric(6);
		icp.Name_category(cat2);
		Thread.sleep(3000);
		icp.Clear_Name_category();
		Thread.sleep(3000);
		
		/*
		if(icp.alert_text().getText().equalsIgnoreCase("Please Enter Name"))
		{
			test.log(LogStatus.PASS, "Please Enter Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		*/
		
		String category = RandomStringUtils.randomAlphanumeric(5);
		icp.Name_category(category);
		Thread.sleep(3000);
		
		
		Thread.sleep(3000);
		icp.Code_category(RandomStringUtils.randomNumeric(4));
		

		Thread.sleep(3000);
		icp.Description_Box("Description");
		icp.Click_Save_Btn();
		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("category saved successfully!."))
		{
			test.log(LogStatus.PASS, "category saved successfully!.");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "category save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	@Test(priority = 5,enabled = false)
	public void Intergration_Category_Mapped_with_PurchaseOrder(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		icp=new InventoryCategoryPage(driver, test);
		
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		icp=new InventoryCategoryPage(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id2")+"taxInventory");

		Thread.sleep(5000);
		
		if(icp.EnableTax_Yes().isEnabled()) {
			
			icp.EnableTax_No().click();
			
			Thread.sleep(2000);
			driver.findElement(By.xpath("//h4[contains(.,'Reminder')]/../../../..//button[contains(.,'Yes')]")).click();
			Thread.sleep(2000);
		}
		else {
			icp.EnableTax_No().click();
		}
		Thread.sleep(5000);
		//icp.PublishButton().click();
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"category");

		Thread.sleep(5000);

		Thread.sleep(2000);
		icp.Click_NewCategory();
		
		//Verify the New Category creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("New Category");
		Thread.sleep(2000);
		String cat2 = RandomStringUtils.randomAlphanumeric(6);
		icp.Name_category(cat2);
		Thread.sleep(3000);
		icp.Clear_Name_category();
		Thread.sleep(3000);
		
		/*
		if(icp.alert_text().getText().equalsIgnoreCase("Please Enter Name"))
		{
			test.log(LogStatus.PASS, "Please Enter Name Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Please Enter Name Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		*/
		
		String category = RandomStringUtils.randomAlphanumeric(5);
		icp.Name_category(category);
		Thread.sleep(3000);
		
		
		Thread.sleep(3000);
		icp.Code_category(RandomStringUtils.randomNumeric(4));
		

		Thread.sleep(3000);
		icp.Description_Box("Description");
		icp.Click_Save_Btn();
		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("category saved successfully!."))
		{
			test.log(LogStatus.PASS, "category saved successfully!.");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "category save Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		Thread.sleep(5000);
		//Load the Department page
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"purchases/purchaseOrders");

				Thread.sleep(5000);
				//Verify the Coursing page loaded or not
//				cmp.VerifyMainScreenPageHeader("Purchase Orders");	
				Thread.sleep(5000);
				//Verify the Front End Receipt Template page loaded or not
				if(air.Purchase_OrderHeader().isDisplayed())
				{
					test.log(LogStatus.PASS, "Inventory - Purchase Order Page Loaded Successfully");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Inventory - Purchase Order Page Loading Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				Thread.sleep(2000);
				//Click the New Purchase Order button
				air.Click_New_Purchase_Order();
				
				//Verify whether the Purchase Order Creation screen openend or not
				cmp.VerifyCreationScreenPageHeader("New Purchase Order");
				
				Thread.sleep(1000);
				//Select the Vendor
				air.Select_Vendor();
				
				//Select the Purchase Order via
				air.Select_Place_Order_Via("Email");
				
				//click the New Inventory Item
				air.Click_Add_Inventory_ItemButtonTwo();
				
				//Select the Inventory Items
				air.Select_Inventory_Items_PurchaseOrder("9");
				
				//Click the Place Order
				air.Click_Place_OrderButton();
				
				new Common_XPaths(driver, test).Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
				//Check whether the New Course Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Purchase order saved successfully!."))
				{
					test.log(LogStatus.PASS, "Purchase Order Saved successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Purchase Order Save Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}

		
	}
}