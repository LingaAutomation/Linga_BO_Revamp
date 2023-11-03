package com.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

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

import com.Pages.BasePage;
import com.Pages.Common_XPaths;
import com.Pages.InventoryPage;
import com.Pages.LoginPage;
import com.Pages.ReportsPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Purchases_Received_Items_Received_Logs 
{

	public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Received Items & Received Logs");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	InventoryPage air;
	BasePage bp=new BasePage(driver, test);
	 String Inventory_Item_Name_inRecItm;
	 String Inventory_Item_Name_inPurOrder;

	 String SubRecipe_Name;
	

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
		Open_Received_Items_Page(driver);
		RefreshAndPaginination_ColumnFilteration(driver);
//		Inventory_Purchase_Receive_New_Item(driver);
//		Inventory_Purchase_Receive_Inventory_Item_in_PurchaseOrder(driver);
//		Inventory_Purchase_Receive_SubRecipe_By_Prepare_SubRecipe(driver);
//		Inventory_Purchase_Verify_Receive_Inventory_Item_in_Received_Logs(driver);
		Inventory_Purchase_Received_Logs_verify_All_All(driver);
		Inventory_Purchase_Received_Logs_verify_All_NotStarted(driver);
		Inventory_Purchase_Received_Logs_verify_All_Progress(driver);
		Inventory_Purchase_Received_Logs_verify_All_Finished(driver);
		Inventory_Purchase_Received_Logs_verify_All_Not_Finished(driver);
		Inventory_Purchase_Received_Logs_verify_InventoryItem_All(driver);
		Inventory_Purchase_Received_Logs_verify_InventoryItem_Not_Started(driver);
		Inventory_Purchase_Received_Logs_verify_InventoryItem_Progress(driver);
		Inventory_Purchase_Received_Logs_verify_InventoryItem_Finished(driver);
		Inventory_Purchase_Received_Logs_verify_InventoryItem_Not_Finished(driver);
		Inventory_Purchase_Received_Logs_verify_RetailItem_All(driver);
		Inventory_Purchase_Received_Logs_verify_RetailItem_Not_Started(driver);
		Inventory_Purchase_Received_Logs_verify_RetailItem_Progress(driver);
		Inventory_Purchase_Received_Logs_verify_RetailItem_Finished(driver);
		Inventory_Purchase_Received_Logs_verify_RetailItem_Not_Finished(driver);
		Inventory_Purchase_Received_Logs_verify_SubRecipe_All(driver);
		Inventory_Purchase_Received_Logs_verify_SubRecipe_Not_Started(driver);
		Inventory_Purchase_Received_Logs_verify_SubRecipe_Progress(driver);
		Inventory_Purchase_Received_Logs_verify_SubRecipe_Finished(driver);
		Inventory_Purchase_Received_Logs_verify_SubRecipe_Not_Finished(driver);
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Received_Items_Page(SelfHealingDriver driver) throws Exception
	{
		
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"purchases/receivedItems");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Received Items");	
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination_ColumnFilteration(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		//Verify the Pagination and Refresh the page
		cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
//		cmp.Filter_Columns();
		
		Thread.sleep(2000);
		//Verify Ascending order for name 
//		cmp.Ascending_And_Descending_Order();

	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Receive_New_Item(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Click the Receive New Item button
		air.Click_Receive_New_Item();
		
		//Verify the New Course creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("Receive New Item");
		
		if(cmp.Save_Button().isEnabled())
		{
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error!."))
		{
			test.log(LogStatus.PASS, "Validation Error Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Validation Error Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.INFO, "Save button not Enabled without Selecting Inventory Item");
		}
		
		
		Thread.sleep(30000);
		//Select the Inventory Item
		air.Select_Inventory_Item();
		
		//Get the Inventory name
		String Inv_NameReceivedItem=air.Inventory_Item_InputBox().getAttribute("value");
		this.Inventory_Item_Name_inRecItm=Inv_NameReceivedItem;
		
		//Enter the Quantity
		cmp.Enter_Quantity("0");
				
		
		if(cmp.Save_Button().isEnabled())
		{
		//Click the Save button
		cmp.Click_SaveButton();
		
		Thread.sleep(3000);
		//Check whether the New Course Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Validation Error!."))
		{
			test.log(LogStatus.PASS, "Validation Error Alert Displayed");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Validation Error Alert not Displayed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		}
		else
		{
			test.log(LogStatus.INFO, "Save button not Enabled without Entering Quantity");
		}
		
		
		
		
		//Enter the Quantity
		cmp.Enter_Quantity("8");
		
		
		
		//Select the Primary Storage
		air.Select_Primary_Storage();
		
		//Click the Save button
		cmp.Click_SaveButton();
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Purchase Item Saved Successfully"))
		{
			test.log(LogStatus.PASS, "Purchase Item Saved Successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Purchase Item Save Unsuccessful");
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Receive_Inventory_Item_in_PurchaseOrder(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
	//Load the Department page
			driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"purchases/purchaseOrders");

			Thread.sleep(5000);
			//Verify the Coursing page loaded or not
//			cmp.VerifyMainScreenPageHeader("Purchase Orders");	
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
			
			//Get the Inventory Item Name in Purchase Order
			String Inv_Name_inPurchaseOrder=driver.findElement(By.xpath("//h5[contains(.,'Items to Be Ordered')]/../..//app-input-table/div/div[2]//app-selectbox//input")).getAttribute("value");
			this.Inventory_Item_Name_inPurOrder=Inv_Name_inPurchaseOrder;
			
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
			Thread.sleep(2000);
			//Get the Purchase Order ID
			String Purchase_OrderID=driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
			
			Thread.sleep(2000);
			//Search and Receive the Purchase Order ID
			air.Receive_Purchase_Order(Purchase_OrderID);
			
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Receive_SubRecipe_By_Prepare_SubRecipe(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"prepareSubRecipe");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Prepare Sub Recipe");	
		
	Thread.sleep(1000);
	//Click the Prepare SubRecipe 
	air.Click_Prepare_SubRecipeButton();
	
	//Verify the New Course creation screen opened or not
	cmp.VerifyCreationScreenPageHeader("Prepare Sub Recipe");
	Thread.sleep(10000);

	//Select the Sub Recipe
	cmp.Click_DropDown(air.SubRecipe_InputBox(), "Sub Recipe Selected");
	
	//Get the Sub Recipe Name
	String SubReciName=air.SubRecipe_InputBox().getAttribute("value");
	this.SubRecipe_Name=SubReciName;
	
	//Enter the Quantity
	cmp.Enter_Quantity("10");
	
	//Select the Primary Storage
	air.Select_Primary_Storage();
	
	//Click the Save button
		cmp.Save_Button();
	
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
	
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Sub Recipe Prepared Successfully"))
		{
			test.log(LogStatus.PASS, "Sub Recipe Prepared Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Sub Recipe Prepare Failed");
		
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Verify_Receive_Inventory_Item_in_Received_Logs(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
	
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"purchases/receivedItems");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Received Items");
		
		//Select Type as All
		air.Select_Type("All");
		
		//Select Consumption status as All
		air.Select_Consumption_Status("All");
		
		//Select Time Period as Today
		new ReportsPage(driver, test).Select_Today_TimePeriod();
		
		//Click the Apply button
		new ReportsPage(driver, test).Click_ApplyButton();
		
		Thread.sleep(5000);
		try
		{
			if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
			{
				test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period Today");
			}
		}
		catch(Exception k)
		{
			//Search the Inventory Item from Received item
			cmp.SearchBox().clear();
			cmp.Setting().sendKeys(Inventory_Item_Name_inRecItm);
		
			try
			{
				if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
				{
					test.log(LogStatus.FAIL, "No purchase records for selected items "+Inventory_Item_Name_inRecItm);
				}
			}
			catch(Exception l)
			{
				Thread.sleep(2000);
				//Get the list of the Received items history
				List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
	
				//Get the Value of the Inventory Item from Received Item
				String Inv_ItemRecItemQty1=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+inv_List1.size()+"]/div/data-grid-row/div/div[1]")).getText().replaceAll("[a-zA-Z $ ₹ , / :]", "").toString();
		
				if(Inv_ItemRecItemQty1.equals("8"))
				{
					test.log(LogStatus.PASS, "Received Logs from Received Item is for Inventory Item Received : "+Inventory_Item_Name_inRecItm+" Received Quantity : "+Inv_ItemRecItemQty1);
				}
				else
				{
					test.log(LogStatus.FAIL, "Received Logs from Received Item is for Inventory Item is not Received : "+Inventory_Item_Name_inRecItm+" Received Quantity : "+Inv_ItemRecItemQty1);
				}
			}
		
				//Search the Inventory Item from Received item
				cmp.SearchBox().clear();
				cmp.Setting().sendKeys(Inventory_Item_Name_inPurOrder);
			
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items "+Inventory_Item_Name_inPurOrder);
					}
				}
				catch(Exception l)
				{
					Thread.sleep(2000);
					//Get the list of the Received items history
					List<WebElement> Inv_List2=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
	
					//Get the Value of the Inventory Item from Received Item
					String Inv_ItemRecItemQty2=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+Inv_List2.size()+"]/div/data-grid-row/div/div[1]")).getText().replaceAll("[a-zA-Z $ ₹ , / :]", "").toString();
		
					if(Inv_ItemRecItemQty2.equals("10"))
					{
						test.log(LogStatus.PASS, "Received Logs from Purchase Order is for Inventory Item Received : "+Inventory_Item_Name_inPurOrder+" Received Quantity : "+Inv_ItemRecItemQty2);
					}
					else
					{
						test.log(LogStatus.FAIL, "Received Logs from Purchase Order is for Inventory Item is not Received : "+Inventory_Item_Name_inPurOrder+" Received Quantity : "+Inv_ItemRecItemQty2);
					}
				}
				
				
				//Search the Inventory Item from Received item
				cmp.SearchBox().clear();
				cmp.Setting().sendKeys(SubRecipe_Name);
			
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items "+SubRecipe_Name);
					}
				}
				catch(Exception l)
				{
					Thread.sleep(2000);
					//Get the list of the Received items history
					List<WebElement> sub_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
		
					//Get the Value of the Inventory Item from Received Item
					String subQty1=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+sub_List1.size()+"]/div/data-grid-row/div/div[1]")).getText().replaceAll("[a-zA-Z $ ₹ , / :]", "").toString();
			
					if(subQty1.equals("10"))
					{
						test.log(LogStatus.PASS, "Received Logs from Prepare Sub-Recipe is for SubRecipe is Received : "+SubRecipe_Name+" Received Quantity : "+subQty1);
					}
					else
					{
						test.log(LogStatus.FAIL, "Received Logs from Prepare Sub-Recipe is for SubRecipe is not Received : "+SubRecipe_Name+" Received Quantity : "+subQty1);
					}
				}
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_All_All(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("All");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("All");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period Today (All)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period Today (All)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
					}
				
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_All_NotStarted(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("All");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("Not Started");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period Today");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period Today (Not Started)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
					}
				
	}
		
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_All_Progress(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("All");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("Progress");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Progress)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Progress)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
					}
				
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_All_Finished(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("All");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("Finished");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Finished)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Finished)");

					Thread.sleep(2000);
					//Get the list of the Received items history
					List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
					for(int i=1;i<=inv_List1.size();i++)
					{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
					}
		}
				
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_All_Not_Finished(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("All");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("Not Finished");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Progress)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Progress)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
		}			
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_InventoryItem_All(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("Inventory Item");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("All");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Inventory Item - All)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Inventory Item - All)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
		}
				
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_InventoryItem_Not_Started(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("Inventory Item");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("Not Started");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Inventory Item - Not Started)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Inventory Item - Not Started)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
		}
				
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_InventoryItem_Progress(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("Inventory Item");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("Progress");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Inventory Item - Progress)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Inventory Item - Progress)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
		}
				
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_InventoryItem_Finished(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("Inventory Item");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("Finished");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Inventory Item - Finished)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Inventory Item - Finished)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
		}		
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_InventoryItem_Not_Finished(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("Inventory Item");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("Not Finished");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Inventory Item - Not Finished)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Inventory Item - Not Finished)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
		}		
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_RetailItem_All(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("Retail Item");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("All");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Retail Item - All)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Retail Item - All)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
		}
				
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_RetailItem_Not_Started(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("Retail Item");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("Not Started");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Retail Item - Not Started)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Retail Item - Not Started)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
		}
				
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_RetailItem_Progress(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("Retail Item");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("Progress");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Retail Item - Progress)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Retail Item - Progress)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
		}
				
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_RetailItem_Finished(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("Retail Item");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("Finished");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Retail Item - Finished)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Retail Item - Finished)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
		}		
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_RetailItem_Not_Finished(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("Retail Item");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("Not Finished");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Retail Item - Not Finished)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Retail Item - Not Finished)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
		}		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_SubRecipe_All(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("Sub Recipe");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("All");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Sub Recipe - All)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Sub Recipe - All)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
		}
				
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_SubRecipe_Not_Started(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("Sub Recipe");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("Not Started");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Sub Recipe - Not Started)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Sub Recipe - Not Started)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
		}
				
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_SubRecipe_Progress(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("Sub Recipe");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("Progress");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Sub Recipe - Progress)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Sub Recipe - Progress)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
		}
				
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_SubRecipe_Finished(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("Sub Recipe");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("Finished");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Sub Recipe - Finished)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Sub Recipe - Finished)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
		}		
	}
	
	@Test(priority = 4,enabled = false)
	public void Inventory_Purchase_Received_Logs_verify_SubRecipe_Not_Finished(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Select Type as All
				air.Select_Type("Sub Recipe");
				
				//Select Consumption status as All
				air.Select_Consumption_Status("Not Finished");
				
				//Select Time Period as Today
				new ReportsPage(driver, test).Select_Date_Range_TimePeriod(Utility.getProperty("Report_Start_Date"), Utility.getProperty("Report_End_Date"));
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				try
				{
					if(air.No_Purchase_RecordsErrorMsg().isDisplayed())
					{
						test.log(LogStatus.FAIL, "No purchase records for selected items or Time Period  (Sub Recipe - Not Finished)");
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.PASS, "Received Logs for Purchase records for selected items or Time Period (Sub Recipe - Not Finished)");

						Thread.sleep(2000);
						//Get the list of the Received items history
						List<WebElement> inv_List1=driver.findElements(By.xpath("//div[contains(@class,'cdk-drop-list')]/div/div/data-grid-row/div/div[1]"));
			
						for(int i=1;i<=inv_List1.size();i++)
						{
							
							//Get the Value of the Inventory Item from Received Item
							String Item_Name=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
							//Get the Value of the Inventory Item from Received Item
							String Item_Type=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
					
						//Get the Value of the Inventory Item from Received Item
						String Item_Qty=driver.findElement(By.xpath("//div[contains(@class,'cdk-drop-list')]/div["+i+"]/div/data-grid-row/div/div[1]")).getText();
				
						test.log(LogStatus.INFO, "Received Item Name : "+Item_Name+" Type : "+Item_Type+" Received Quantity : "+Item_Qty);
						
						}
		}		
	}
}
