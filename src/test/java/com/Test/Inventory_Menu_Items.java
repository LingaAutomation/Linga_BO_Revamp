package com.Test;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
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
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Menu_Items 
{
public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Prepare Menu Item");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	InventoryPage air;
	BasePage bp=new BasePage(driver, test);
	
	String MenuItem_Name;
	


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
		Open_Inventory_Menu_Item_Page(driver);
		RefreshAndPaginination_ColumnFilteration(driver);
		Verify_Unlinked_Menu_To_Link(driver);
		Verify_Linked_Menu_To_UnLink(driver);
		Edit_Linked_Type_of_Menu_Item_Inv_Item(driver);
		Edit_Linked_Type_of_Menu_Item_SubRecipe(driver);
		Edit_Linked_Type_of_Menu_Item_ManualEntry(driver);
		Edit_Linked_Type_of_Menu_Item_InvItem_SubRecipe(driver);
		Edit_Linked_Type_of_Menu_Item_InvItem_Manual_Entry(driver);
		Edit_Linked_Type_of_Menu_Item_SubRecipe_Manual_Entry(driver);
		Edit_Linked_Type_of_Menu_Item_InventoryItem_SubRecipe_Manual_Entry(driver);
		Verify_Active_Inactive_Inentory_Menu_Item(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Inventory_Menu_Item_Page(SelfHealingDriver driver) throws Exception
	{
		
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"menuItems");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Inventory Menu Items");	
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination_ColumnFilteration(SelfHealingDriver driver) throws Exception
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
		
		//Verify Search text at 3 characters
		cmp.SearchAndVerify_SearchBox();
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Verify_Unlinked_Menu_To_Link(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Click the Unlinked List
		air.Click_Unlinked_Tab();
		
		Thread.sleep(3000);
		List<WebElement> menu_UnlinkList=driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		int UnLinkSize=menu_UnlinkList.size();
		
		
		int randomOpt=ThreadLocalRandom.current().nextInt(1, UnLinkSize);
		
		System.out.println("Size "+UnLinkSize);
		
		String UnLink_menuName=driver.findElement(By.xpath("//table/tbody/tr["+randomOpt+"]/td[1]")).getText();
		
		Thread.sleep(2000);
//		String MenuItemName="0.01 Menu item";	

//		this.MenuItem_Name=MenuItemName;
		//Search the Sub recipe
//		cmp.Search(SubReci_Name);
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(UnLink_menuName);
		System.out.println("Menu Name "+UnLink_menuName);
		
		Thread.sleep(3000);
		//Click the Action button
		air.Click_Add_Link_IconInventoryMenuItemButton();
		
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//span[contains(.,'Click below options to start creating recipe')]")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Click below options to start creating recipe is Displayed");
		}
		else
		{
			test.log(LogStatus.FAIL, "Click below options to start creating recipe is not Displayed");
		}
		
		//Click the Add Inventory Item
		air.Click_Add_InventoryItem();
		
		//Select Inventory Item
		air.Add_Inventory_Items_inSubRecipe("3");
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu item updated successfully"))
		{
			test.log(LogStatus.PASS, "Menu item updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu item update Failed");
		}
		
		Thread.sleep(2000);
		//Click the Linked Tab
		air.Click_All_Tab();
		
		Thread.sleep(1000);
		//
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(UnLink_menuName);
		
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//td[.=' "+UnLink_menuName+" ']/../td[3]")).getText().equalsIgnoreCase("Linked"))
		{
			test.log(LogStatus.PASS, "Unlinked Menu Item Linked Successfully");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Unlinked Menu Item Linked Unsuccessful");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Verify_Linked_Menu_To_UnLink(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Click the Linked List
		air.Click_Linked_Tab();
		
		Thread.sleep(3000);
		List<WebElement> menu_linkList=driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		int LinkSize=menu_linkList.size();
		
		
		int randomOpt=ThreadLocalRandom.current().nextInt(1, LinkSize);
		
		System.out.println("Size "+LinkSize);
		
		String Link_menuName=driver.findElement(By.xpath("//table/tbody/tr["+randomOpt+"]/td[1]")).getText();
		
		Thread.sleep(2000);
//		String MenuItemName="0.01 Menu item";	

//		this.MenuItem_Name=MenuItemName;
		//Search the Sub recipe
//		cmp.Search(SubReci_Name);
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(Link_menuName);
		System.out.println("Menu Name "+Link_menuName);
		
		Thread.sleep(3000);
		//Click the Action button
		air.Click_Add_Link_IconInventoryMenuItemButton();
		
		Thread.sleep(2000);
		Thread.sleep(2000);
		try
		{
		//Check whether the Inventory Item is added or not
		if(driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]")).isDisplayed())
		{
		}
		}
		catch(Exception h)
		{
						
			air.Delete_Inventory_Items_inSubRecipe(1);
		}
			
			
		
		try
		{
		//Check whether the SubRecipe is added or not
		if(driver.findElement(By.xpath("//span[contains(.,'Click Add Sub-Recipe to add sub-recipe into menu item recipe')]")).isDisplayed())
		{
			
		}
		}
		catch(Exception h)
		{
			air.Delete_Sub_Recipes_inSubRecipe(1);
		}
		
		try
		{
		//Check whether the Manual Entry is added or not
		if(driver.findElement(By.xpath("//span[contains(.,'Click Add Manual Entry to add non-inventory item into menu item recipe')]")).isDisplayed())
		{
			
		}
		}
		catch(Exception h)
		{
			air.Delete_Manual_Entry_inSubRecipe(1);
		}
		
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu item updated successfully"))
		{
			test.log(LogStatus.PASS, "Menu item updated successfully");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu item update Failed");
		}
		
		Thread.sleep(2000);
		//Click the Linked Tab
		air.Click_All_Tab();
		
		Thread.sleep(1000);
		//
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(Link_menuName);
		
		Thread.sleep(2000);
		if(driver.findElement(By.xpath("//td[.=' "+Link_menuName+" ']/../td[3]")).getText().equalsIgnoreCase("Not Linked"))
		{
			test.log(LogStatus.PASS, "Linked Menu Item Unlinked Successfully");
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Linked Menu Item Unlinked Unsuccessful");
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Edit_Linked_Type_of_Menu_Item_Inv_Item(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		
		List<WebElement> menu_linkList=driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		int LinkSize=menu_linkList.size();
		
		
		int randomOpt=ThreadLocalRandom.current().nextInt(1, LinkSize);
		
		String Link_menuName=driver.findElement(By.xpath("//table/tbody/tr["+randomOpt+"]/td[1]")).getText();
		
		
//		String Link_menuName="0.01 Menu item";	

		this.MenuItem_Name=Link_menuName;
		//Search the Sub recipe
//		cmp.Search(SubReci_Name);
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(MenuItem_Name);
		
		
		Thread.sleep(3000);
		//Click the Action button
		air.Click_Add_Link_IconInventoryMenuItemButton();
		
		Thread.sleep(2000);
		try
		{
		//Check whether the Inventory Item is added or not
		if(driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]")).isDisplayed())
		{
		}
		}
		catch(Exception h)
		{
						
			air.Delete_Inventory_Items_inSubRecipe(1);
		}
			
			
		
		try
		{
		//Check whether the Inventory Item is added or not
		if(driver.findElement(By.xpath("//span[contains(.,'Click Add Sub-Recipe to add sub-recipe into menu item recipe')]")).isDisplayed())
		{
			
		}
		}
		catch(Exception h)
		{
			air.Delete_Sub_Recipes_inSubRecipe(1);
		}
		
		//Click the Add Inventory Item
		air.Click_Add_InventoryItem();
		
		//Select Inventory Item
		air.Add_Inventory_Items_inSubRecipe("3");
		

		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu item updated successfully"))
		{
			test.log(LogStatus.PASS, "Menu item updated successfully with Inventory Item");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu item update Failed with Inventory Item");
		}
		

	}
	
	@Test(priority = 4,enabled = false)
	public void Edit_Linked_Type_of_Menu_Item_SubRecipe(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
	
	

		//Search the Sub recipe
//		cmp.Search(SubReci_Name);
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(MenuItem_Name);
		
		
		Thread.sleep(3000);
		//Click the Action button
		air.Click_Add_Link_IconInventoryMenuItemButton();
		
		
		//Delete the Inventory Item
		air.Delete_Inventory_Items_inSubRecipe(1);
		
					
			Thread.sleep(1000);
			//Click the Add Sub Recipe
			air.Click_Add_SubRecipe();
			
			//Select the sub recipes
			air.Add_SubRecipes_inSubRecipe("4");
			
					
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu item updated successfully"))
		{
			test.log(LogStatus.PASS, "Menu item updated successfully with SubRecipe");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu item update Failed with SubRecipe");
		}
		
	}
	
	public void Edit_Linked_Type_of_Menu_Item_ManualEntry(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
	
	

		//Search the Sub recipe
//		cmp.Search(SubReci_Name);
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(MenuItem_Name);
		
		
		Thread.sleep(3000);
		//Click the Action button
		air.Click_Add_Link_IconInventoryMenuItemButton();
		
		Thread.sleep(2000);
		air.Delete_Sub_Recipes_inSubRecipe(1);
		
		//Click the Manual Entry
		air.Click_Add_ManualEntry();
		
		//Add the Manual Entry
		air.Add_Manual_Entry_inSubRecipe("Applye", "200", "2");
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu item updated successfully"))
		{
			test.log(LogStatus.PASS, "Menu item updated successfully with Manual Entry");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu item update Failed with Manual Entry");
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Edit_Linked_Type_of_Menu_Item_InvItem_SubRecipe(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Search the Sub recipe
//		cmp.Search(SubReci_Name);
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(MenuItem_Name);
		
		
		Thread.sleep(3000);
		//Click the Action button
		air.Click_Add_Link_IconInventoryMenuItemButton();
		
		//Delete SubRecipe
		air.Delete_Manual_Entry_inSubRecipe(1);
		
		Thread.sleep(1000);
		//Click the Add Inventory Item
		air.Click_Add_InventoryItem();
		
		//Select Inventory Item
		air.Add_Inventory_Items_inSubRecipe("3");
		
		
		Thread.sleep(1000);
		//Click the Add Sub Recipe
		air.Click_Add_SubRecipe();
		
		//Select the sub recipes
		air.Add_SubRecipes_inSubRecipe("4");
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu item updated successfully"))
		{
			test.log(LogStatus.PASS, "Menu item updated successfully with Inventory Item & SubRecipe");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu item update Failed with Inventory Item & SubRecipe");
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Edit_Linked_Type_of_Menu_Item_InvItem_Manual_Entry(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Search the Sub recipe
//		cmp.Search(SubReci_Name);
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(MenuItem_Name);
		
		
		Thread.sleep(3000);
		//Click the Action button
		air.Click_Add_Link_IconInventoryMenuItemButton();
		
		
		//Delete SubRecipe
		air.Delete_Sub_Recipes_inSubRecipe(1);
		
		//Click the Manual Entry
		air.Click_Add_ManualEntry();
		
		//Add the Manual Entry
		air.Add_Manual_Entry_inSubRecipe("Maida", "250", "11");
		
		
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu item updated successfully"))
		{
			test.log(LogStatus.PASS, "Menu item updated successfully with Inventory Item & Manual Entry");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu item update Failed with Inventory Item & Manual Entry");
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Edit_Linked_Type_of_Menu_Item_SubRecipe_Manual_Entry(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Search the Sub recipe
//		cmp.Search(SubReci_Name);
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(MenuItem_Name);
		
		
		Thread.sleep(3000);
		//Click the Action button
		air.Click_Add_Link_IconInventoryMenuItemButton();
		
		
		//Delete Inventory Item
		air.Delete_Inventory_Items_inSubRecipe(1);
		
		Thread.sleep(1000);
		//Click the Add Sub Recipe
		air.Click_Add_SubRecipe();
		
		//Select the sub recipes
		air.Add_SubRecipes_inSubRecipe("8");
		
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu item updated successfully"))
		{
			test.log(LogStatus.PASS, "Menu item updated successfully with SubRecipe & Manual Entry");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu item update Failed with SubRecipe & Manual Entry");
		}
	}
	
	@Test(priority = 4,enabled = false)
	public void Edit_Linked_Type_of_Menu_Item_InventoryItem_SubRecipe_Manual_Entry(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Search the Sub recipe
//		cmp.Search(SubReci_Name);
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(MenuItem_Name);
		
		
		Thread.sleep(3000);
		//Click the Action button
		air.Click_Add_Link_IconInventoryMenuItemButton();
		
		
		//Delete Inventory Item
		air.Delete_Sub_Recipes_inSubRecipe(1);
		
		//Delete Manual Entry
		air.Delete_Manual_Entry_inSubRecipe(1);
				
		//Click the Add Inventory Item
		air.Click_Add_InventoryItem();
				
		//Select Inventory Item
		air.Add_Inventory_Items_inSubRecipe("3");
				
		
		Thread.sleep(1000);
		//Click the Add Sub Recipe
		air.Click_Add_SubRecipe();
		
		//Select the sub recipes
		air.Add_SubRecipes_inSubRecipe("8");
		
		//Click the Manual Entry
		air.Click_Add_ManualEntry();
				
		//Add the Manual Entry
		air.Add_Manual_Entry_inSubRecipe("Atta", "1200", "10");
				
		//Get the Inventory Name
		String InvName=driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')][1]/div/div[4]//input")).getAttribute("value");
		
		//Get the Inventory Quantity
		String Inv_Qty=driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')][1]/div/div[7]//input")).getAttribute("value");
		
		//Get the Inventory Price
		String Inv_Price=driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../..//div[contains(@class,'inventory-table')][1]/div/div[8]//span")).getAttribute("value");
		
		//Get the Sub Recipe Name
		String SubReci_Name=driver.findElement(By.xpath("//span[contains(.,'Select Sub Recipes')]/../..//div[contains(@class,'inventory-table')][1]/div/div[1]//input")).getAttribute("value");
		
		//Get the SubRecipe Quantity
		String SubReci_Qty=driver.findElement(By.xpath("//span[contains(.,'Select Sub Recipes')]/../..//div[contains(@class,'inventory-table')][1]/div/div[4]//input")).getAttribute("value");
		
		//Get the SubRecipe Cost
		String SubRecip_Price=driver.findElement(By.xpath("//span[contains(.,'Select Sub Recipes')]/../..//div[contains(@class,'inventory-table')][1]/div/div[5]//span")).getText();
		
		
		
		Thread.sleep(2000);
		//Click the Save button
		cmp.Click_SaveButton();
		
		
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu item updated successfully"))
		{
			test.log(LogStatus.PASS, "Menu item updated successfully with Inventory Item, SubRecipe & Manual Entry");
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu item update Failed with Inventory Item, SubRecipe & Manual Entry");
		}
		
		
		Thread.sleep(3000);
		//Navigating to Prepare Menu Item
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"prepareMenuItem");

				Thread.sleep(5000);
				//Verify the Coursing page loaded or not
				cmp.VerifyMainScreenPageHeader("Prepare Menu Item");	
				
				Thread.sleep(2000);
				//Search the Prepared SubRecipe
//				cmp.Search(SubReci_Name);
				cmp.SearchBox().clear();
				cmp.SearchBox().sendKeys(MenuItem_Name);
				
				Thread.sleep(2000);
				//Click the action button
				air.Click_Plus_ActionBtn();
				
				Thread.sleep(2000);
				//Get the Inventory Items name in Prepare menu item 
				String InvItem_NamePreMenu=driver.findElement(By.xpath("//h5[contains(.,'Inventory Items')]/../..//app-input-table/div/div[2]/div[1]")).getText();
				
				//Get the Inventory Items Quantity in Prepare Menu Item
				String InvItem_QtyPreMenu=driver.findElement(By.xpath("//h5[contains(.,'Inventory Items')]/../..//app-input-table/div/div[2]/div[3]//input")).getAttribute("value");
				
				//Get the Inventory Items Price in Prepare menu item
				String InvItem_PricePreMenu=driver.findElement(By.xpath("//h5[contains(.,'Inventory Items')]/../..//app-input-table/div/div[2]/div[4]")).getText();
				
				//Get the SubRecipe name in Prepare menu item 
				String SubReci_NamePreMenu=driver.findElement(By.xpath("//h5[contains(.,'Sub Recipes')]/../..//app-input-table/div/div[2]/div[1]")).getText();
				
				//Get the Sub Recipe Quantity in Prepare Menu Item
				String SubReci_QtyPreMenu=driver.findElement(By.xpath("//h5[contains(.,'Sub Recipes')]/../..//app-input-table/div/div[2]/div[3]//input")).getAttribute("value");
				
				//Get the SubRecipe Price in Prepare menu item
				String SubReci_PricePreMenu=driver.findElement(By.xpath("//h5[contains(.,'Sub Recipes')]/../..//app-input-table/div/div[2]/div[4]")).getText();
				
				//Verify whether theInventory Item name
				if(InvName.equals(InvItem_NamePreMenu))
				{
					test.log(LogStatus.PASS, "Inventory Item Name is Displayed as Expected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Inventory Item Name is not Displayed as Expected");
				}
				
				//Verify whether theInventory Item Quantity
				if(Inv_Qty.equals(InvItem_QtyPreMenu))
				{
					test.log(LogStatus.PASS, "Inventory Item Quantity is Displayed as Expected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Inventory Item Quantity is not Displayed as Expected"+" Quantity in Inventory Menu Item is "+Inv_Qty+" Displayed Quantity in Prepare Menu Item "+InvItem_QtyPreMenu);
				}
				
				//Verify whether theInventory Item Price
				if(Inv_Price.equals(InvItem_PricePreMenu))
				{
					test.log(LogStatus.PASS, "Inventory Item Price is Displayed as Expected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Inventory Item Price is not Displayed as Expected"+" Price in Inventory Menu Item is "+Inv_Price+" Displayed Price in Prepare Menu Item "+InvItem_PricePreMenu);
				}
				
				
				//Verify whether the Sub Recipe name
				if(SubReci_Name.equals(SubReci_NamePreMenu))
				{
					test.log(LogStatus.PASS, "Sub Recipe Name is Displayed as Expected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Sub Recipe Name is not Displayed as Expected");
				}
				
				//Verify whether the Sub Recipe Quantity
				if(SubReci_Qty.equals(SubReci_QtyPreMenu))
				{
					test.log(LogStatus.PASS, "Sub Recipe Quantity is Displayed as Expected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Sub Recipe Quantity is not Displayed as Expected"+" Quantity in Inventory Menu Item is "+Inv_Qty+" Displayed Quantity in Prepare Menu Item "+InvItem_QtyPreMenu);
				}
				
				//Verify whether the Sub Recipe Price
				if(SubRecip_Price.equals(SubReci_PricePreMenu))
				{
					test.log(LogStatus.PASS, "Sub Recipe Price is Displayed as Expected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Sub Recipe Price is not Displayed as Expected"+" Price in Inventory Menu Item is "+Inv_Price+" Displayed Price in Prepare Menu Item "+InvItem_PricePreMenu);
				}
				
				//Click the Cancel button
				cmp.Click_CancelButton();
				
				Thread.sleep(3000);
				//Load the Department page
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"menuItems");

				Thread.sleep(5000);
				//Verify the Coursing page loaded or not
				cmp.VerifyMainScreenPageHeader("Inventory Menu Items");	
				Thread.sleep(3000);
	}
	
	@Test(priority = 4,enabled = false)
	public void Verify_Active_Inactive_Inentory_Menu_Item(SelfHealingDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"productItems");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Products/Items");	
		
		Thread.sleep(1000);
		//Enable the Inactive Status
		cmp.Click_ActivetoInactiveButton();
		
		//Check whether the Inactive screen opened or not
		cmp.VerifyActive_InactiveStatus("Inactive");
		
		Thread.sleep(3000);
		List<WebElement> menu_UnlinkList=driver.findElements(By.xpath("//table/tbody/tr/td[1]"));
		int UnLinkSize=menu_UnlinkList.size();
		
		
		int randomOpt=ThreadLocalRandom.current().nextInt(1, UnLinkSize);
		
		System.out.println("Size "+UnLinkSize);
		
		String UnLink_menuName=driver.findElement(By.xpath("//table/tbody/tr["+randomOpt+"]/td[1]")).getText();
		
		
		Thread.holdsLock(1000);
		//Search and Activate the In activated item
		cmp.SearchAndClickActivate(UnLink_menuName);
		
		Thread.sleep(1000);
		//Click the Activate button
		cmp.Click_ActivateButton();
		
		Thread.sleep(3000);
		//Check whether the New Category Saved or not
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu Item Activated Successfully"))
		{
			test.log(LogStatus.PASS, "Menu Item activated Successfully");
		
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Item activated Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
		//
		//Navigate to Inventory Menu Item
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"menuItems");

		Thread.sleep(5000);
		//Verify the Menu Item page loaded or not
		cmp.VerifyMainScreenPageHeader("Inventory Menu Items");	
		
		Thread.sleep(1000);
		//Clear the Search
		cmp.SearchBox().clear();
		Thread.sleep(500);
		cmp.SearchBox().sendKeys(UnLink_menuName);
		
		if(driver.findElement(By.xpath("//td[.=' "+UnLink_menuName+" ']")).isDisplayed())
		{
			test.log(LogStatus.PASS, "Activated Menu Item in Active Stats of Inventory Menu Item Page");
		}
		else
		{
			test.log(LogStatus.FAIL, "Activated Menu Item is not in Active Stats of Inventory Menu Item Page");	
		}
		
		Thread.sleep(2000);
		//Again navigate to Product/Items Menu Items page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id1")+"productItems");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Products/Items");	
		
		Thread.sleep(1000);
		//Search and Click Delete button
				cmp.SearchAndClickDelete(UnLink_menuName);
				
				Thread.sleep(1000);
				//Click the Delete button
				cmp.Click_DeleteButton();
				
				Thread.sleep(3000);
				//Check whether the New Category Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu Item Inactivated Successfully"))
				{
					test.log(LogStatus.PASS, "Menu Item Inactivated Successfully");
				
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Menu Item Inactivated Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
		
				//Navigate to Inventory Menu Item
				driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"menuItems");

				Thread.sleep(5000);
				//Verify the Menu Item page loaded or not
				cmp.VerifyMainScreenPageHeader("Inventory Menu Items");	
				
				Thread.sleep(1000);
				//Enable the Active to Inactive
				//Enable the Inactive Status
				cmp.Click_ActivetoInactiveButton();
				
				//Check whether the Inactive screen opened or not
				cmp.VerifyActive_InactiveStatus("Inactive");
				
				Thread.sleep(1000);
				//Clear the Search
				cmp.SearchBox().clear();
				Thread.sleep(500);
				cmp.SearchBox().sendKeys(UnLink_menuName);
				
				if(driver.findElement(By.xpath("//td[.=' "+UnLink_menuName+" ']")).isDisplayed())
				{
					test.log(LogStatus.PASS, "InActivated Menu Item is in InActive Stats of Inventory Menu Item Page");
				}
				else
				{
					test.log(LogStatus.FAIL, "InActivated Menu Item is not in InActive Stats of Inventory Menu Item Page");	
				}
				
				
				Thread.sleep(1000);
				//Enable Active Status
				cmp.Click_InactivetoActiveButton();
						
				Thread.sleep(1000);
				//Check whether verify whether the Active page opened or not
				cmp.VerifyActive_InactiveStatus("Active");
				
				
	}
}
