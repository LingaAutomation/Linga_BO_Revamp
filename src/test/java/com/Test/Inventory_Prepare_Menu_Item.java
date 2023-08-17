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
import com.Pages.ReportsPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Inventory_Prepare_Menu_Item 
{
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Prepare Menu Item");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	InventoryPage air;
	BasePage bp=new BasePage(driver, test);
	
	String MenuItem_Name;
	String SubRecipe_Name;
	String Inventory_Name;
	
	
	String Bef_Inv_onHand_Quanity;
	String Bef_SubReci_onHand_Quanity;
	String Bef_Menu_onHand_Quanity;

	String Aft_Inv_onHand_Quanity;
	String Aft_SubReci_onHand_Quanity;
	String Aft_Menu_onHand_Quanity;


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
		Open_Prepare_Menu_Item_Page(driver);
		RefreshAndPaginination_ColumnFilteration(driver);
		Prepare_MenuItem(driver);
		Verify_Prepared_MenuItem_In_MenuItem_InventoryItem_SubRecipe(driver);
		Verify_Prepared_MenuItem_In_Compare_Inventory_Report(driver);
		Verify_Prepared_MenuItem_In_Production_Log(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Prepare_Menu_Item_Page(WebDriver driver) throws Exception
	{
		
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"prepareMenuItem");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Prepare Menu Item");	
		
	}
	
	@Test(priority = 4,enabled = false)
	public void RefreshAndPaginination_ColumnFilteration(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		air=new InventoryPage(driver, test);
		
		//Verify the Pagination and Refresh the page
	//	cmp.VerifyPagination_and_Refresh_Publish();
		
		//Verify Column Filtration
//		cmp.Filter_Columns();
		
		Thread.sleep(2000);
		//Verify Ascending order for name 
//		cmp.Ascending_And_Descending_Order();

	}
	
	@Test(priority = 4,enabled = false)
	public void Prepare_MenuItem(WebDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		//Click the Produce Menu Item
		air.Click_Produce_Menu_ItemButton();
		
		Thread.sleep(1000);
		//Clear the PLU Code
		air.Search_byPLU_CodeInputBox().clear();
		air.Search_byPLU_CodeInputBox().sendKeys("000");
		
		Thread.sleep(2000);
		//Get the menu item name
		String Menu_ItemNamebtPLU1=air.Menu_Item_InputBox().getAttribute("value");
		
		System.out.println("Menu_ItemNamebtPLU1 :"+Menu_ItemNamebtPLU1);
		Thread.sleep(2000);
		//Clear the PLU Code
				air.Search_byPLU_CodeInputBox().clear();
				air.Search_byPLU_CodeInputBox().sendKeys("111");
			
				Thread.sleep(2000);
				//Get the menu item name
				String Menu_ItemNamebtPLU2=air.Menu_Item_InputBox().getAttribute("value");
				
				System.out.println("Menu_ItemNamebtPLU2 :"+Menu_ItemNamebtPLU2);
				Thread.sleep(2000);
				//Check whether the Menu Item Name changes when Searching menu by PLU Code or not
				if(!Menu_ItemNamebtPLU1.equalsIgnoreCase(Menu_ItemNamebtPLU2))
				{
					test.log(LogStatus.PASS, "Menu Item searched successfully by searching by PLU Code");
				}
				else
				{
					test.log(LogStatus.FAIL, "Menu Item search is Unsuccessful by searching by PLU Code");
					test.log(LogStatus.INFO, "PLU Code 000"+Menu_ItemNamebtPLU1+ " PLU Code 111"+Menu_ItemNamebtPLU2);
	
				}
				
		
		Thread.sleep(1000);
		//Select the Menu Item
		new Common_XPaths(driver, test).Click_DropDown_withSearch(air.Menu_Item_InputBox(), "Menu Item Selected");
		
		String MenuItemName="005. Chai Cream BlasTea";	
//0.01 Menu item
		this.MenuItem_Name=MenuItemName;
		
		//Click the Cancel button
		cmp.Click_CancelButton();
		
		//Navigate to Inventory Menu Item page
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"menuItems");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Inventory Menu Item");	
		
		//Search the Sub recipe
//		cmp.Search(SubReci_Name);
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(MenuItemName);
		
		Thread.sleep(3000);
		//Click the Action button
		air.Click_Add_Link_IconInventoryMenuItemButton();
		
		Thread.sleep(2000);
		try
		{
		//Check whether the Inventory Item is added or not
		if(driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]")).isDisplayed())
		{
			
			test.log(LogStatus.INFO, "Inventory Item available");
			Thread.sleep(10000);
			List<WebElement> invList=driver.findElements(By.xpath("//span[contains(.,'Selected Inventory Items')]/../../div/div/div[4]//input"));
			
			int invSize=invList.size();
			
			if(invSize==1)
			{
				String Inv_Name=driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../../div[3]/div/div[4]//input")).getAttribute("value");
		
				this.Inventory_Name=Inv_Name;
			}
			else if(invSize>1)
			{
				List<WebElement> invBtnList=driver.findElements(By.xpath("//span[contains(.,'Selected Inventory Items')]/../../div/div/button"));
				
				
				for(int i=2;i<=invSize;i++)
				{
					Thread.sleep(1000);
					driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../../div[4]/div/button")).click();
					
					Thread.sleep(1000);
					new Common_XPaths(driver, test).Click_DeleteButton();
				}
				
				String Inv_Name=driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../../div[3]/div/div[4]//input")).getAttribute("value");
				this.Inventory_Name=Inv_Name;

			}
		}
		}
			catch(Exception p)
			{
				
				//Click the Add Inventory Item
				air.Click_Add_InventoryItem();
				
				//Select Inventory Item
				air.Add_Inventory_Items_inSubRecipe("3");
				
				String Inv_Name=driver.findElement(By.xpath("//span[contains(.,'Selected Inventory Items')]/../../div[3]/div/div[4]//input")).getAttribute("value");
				this.Inventory_Name=Inv_Name;
				
			}
			
			
		
		
		
		Thread.sleep(3000);
		try
		{
		//Check whether the Inventory Item is added or not
		if(driver.findElement(By.xpath("//span[contains(.,'Click Add Sub-Recipe to add sub-recipe into menu item recipe')]")).isDisplayed())
		{
			
			Thread.sleep(1000);
			//Click the Add Sub Recipe
			air.Click_Add_SubRecipe();
			
			//Select Sub Recipes
			Thread.sleep(1000);
			//Select Item
			driver.findElement(By.xpath("//span[contains(.,'Select Sub Recipes')]/../../div[3]/div/div[1]//input")).click();
			
			List<WebElement> itemList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));

			
			int itemSize=itemList.size();
			
			if(itemSize<=5)
			{
				Thread.sleep(1000);
				int randomitem=ThreadLocalRandom.current().nextInt(1, itemSize);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomitem+"]//select-option")).click();

			}
			else
			{
				Thread.sleep(1000);
				int randomitem=ThreadLocalRandom.current().nextInt(1, 5);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomitem+"]//select-option")).click();

			}
			
			Thread.sleep(1000);
			//Select Recipe Unit
			driver.findElement(By.xpath("//span[contains(.,'Select Sub Recipes')]/../../div[3]/div/div[2]//input")).click();
			
			List<WebElement> UnitList=driver.findElements(By.xpath("//cdk-virtual-scroll-viewport//div/div//select-option"));

			
			int UnitSize=UnitList.size();
			
			if(UnitSize==1)
			{
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+UnitSize+"]//select-option")).click();

			}
			else if(UnitSize>1&&UnitSize<=5)
			{
				Thread.sleep(1000);
				int randomUnit=ThreadLocalRandom.current().nextInt(1, UnitSize);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomUnit+"]//select-option")).click();

			}
			else
			{
				Thread.sleep(1000);
				int randomUnit=ThreadLocalRandom.current().nextInt(1, 5);
				driver.findElement(By.xpath("//cdk-virtual-scroll-viewport//div/div["+randomUnit+"]//select-option")).click();

			}
			
			Thread.sleep(1000);
			//Clear the Quantity
			driver.findElement(By.xpath("//span[contains(.,'Select Sub Recipes')]/../../div[3]/div/div[4]//input")).clear();
			//Enter the Quantity
			driver.findElement(By.xpath("//span[contains(.,'Select Sub Recipes')]/../../div[3]/div/div[4]//input")).sendKeys("3");
			
			Thread.sleep(1000);
			String subRec_Name=driver.findElement(By.xpath("//span[contains(.,'Select Sub Recipes')]/../../div[3]/div/div[1]//input")).getAttribute("value");
			this.SubRecipe_Name=subRec_Name;
			
		

		}
		}
		catch(Exception k)
			{
			test.log(LogStatus.INFO, "Sub Recipes available");
			
			Thread.sleep(10000);
			List<WebElement> subRecList=driver.findElements(By.xpath("//span[contains(.,'Select Sub Recipes')]/../../div/div/div[1]//input"));
			
			int subRecSize=subRecList.size();
			
			if(subRecSize==1)
			{
				String subRec_Name=driver.findElement(By.xpath("//span[contains(.,'Select Sub Recipes')]/../../div[3]/div/div[1]//input")).getAttribute("value");
		
				this.SubRecipe_Name=subRec_Name;
			}
			else if(subRecSize>1)
			{
				List<WebElement> invBtnList=driver.findElements(By.xpath("//span[contains(.,'Select Sub Recipes')]/../../div/div/button"));
				
				
				for(int i=2;i<=subRecSize;i++)
				{
					Thread.sleep(1000);
					driver.findElement(By.xpath("//span[contains(.,'Select Sub Recipes')]/../../div[4]/div/button")).click();
					
					Thread.sleep(1000);
					new Common_XPaths(driver, test).Click_DeleteButton();
				}
				
				String subRec_Name=driver.findElement(By.xpath("//span[contains(.,'Select Sub Recipes')]/../../div[3]/div/div[1]//input")).getAttribute("value");
				this.SubRecipe_Name=subRec_Name;

			}
						
			
		}
		
		
		Thread.sleep(1000);
		//Clear the Quantity
		driver.findElement(By.xpath("//span[contains(.,'Select Sub Recipes')]/../../div[3]/div/div[4]//input")).clear();
		//Enter the Quantity
		driver.findElement(By.xpath("//span[contains(.,'Select Sub Recipes')]/../../div[3]/div/div[4]//input")).sendKeys("2");
		
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
		
		
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"inventoryItem");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Inventory Item");	
		
		Thread.sleep(2000);
		//Search the Prepared SubRecipe
//		cmp.Search(SubReci_Name);
		
		//String invItem = driver.findElement(By.xpath("//section/table/tbody/tr[1]/td[1]/span")).getText();
		
		String Inventory_Name1=Inventory_Name;	
		//0.01 Menu item
				this.Inventory_Name=Inventory_Name1;
		Thread.sleep(2000);
		cmp.SearchBox().clear();
		Thread.sleep(2000);
		cmp.SearchBox().sendKeys(Inventory_Name);
	
		
		Thread.sleep(3000);
		//Get The On Hand Quantity after Sub Recipe Prepared
		String Before_InvItem_onHand_Qty=driver.findElement(By.xpath("//span[contains(.,'"+Inventory_Name+"')]/../../div[7]/span")).getText().replaceAll("[a-zA-Z $ ₹ , / :]", "").toString();
		double Before_InvItem_onHand_Quantity=Double.parseDouble(Before_InvItem_onHand_Qty);
		this.Bef_Inv_onHand_Quanity=String.valueOf(Before_InvItem_onHand_Quantity);
	
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"subRecipe");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		
		Thread.sleep(2000);
		//Search the Prepared SubRecipe
//		cmp.Search(SubReci_Name);
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(SubRecipe_Name);
		
		
		Thread.sleep(3000);
		//Get The On Hand Quantity after Sub Recipe Prepared
		String Before_SubReci_onHand_Qty=driver.findElement(By.xpath("//td[.=' "+SubRecipe_Name+" ']/../..//td[5]")).getText().replaceAll("[a-zA-Z $ ₹ , / :]", "").toString();
		double Before_SubReci_onHand_Quantity=Double.parseDouble(Before_SubReci_onHand_Qty);
		this.Bef_SubReci_onHand_Quanity=String.valueOf(Before_SubReci_onHand_Quantity);
				
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"prepareMenuItem");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Prepare Menu Item");	
		
		Thread.sleep(2000);
		//Search the Prepared SubRecipe
//		cmp.Search(SubReci_Name);
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(MenuItem_Name);
		
		
		Thread.sleep(3000);
		//Get The On Hand Quantity after Sub Recipe Prepared
		String Before_Menu_onHand_Qty=driver.findElement(By.xpath("//span[.='"+MenuItem_Name+" ']/../../div[3]")).getText().replaceAll("[a-zA-Z $ ₹ , / :]", "").toString();
		double Before_Menu_onHand_Quantity=Double.parseDouble(Before_Menu_onHand_Qty);
		this.Bef_Menu_onHand_Quanity=String.valueOf(Before_Menu_onHand_Qty);
		
		System.out.println("Menu Item Quanitity Before Prepartion is : "+Before_Menu_onHand_Qty);
		test.log(LogStatus.INFO, "Menu Name : "+MenuItemName+" Quantity before Preparation is : "+Before_Menu_onHand_Qty);
		
		
		Thread.sleep(1000);
		//Click the Prepare Menu Item button
		air.Click_Produce_Menu_ItemButton();
		
		//Verify the New Course creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("Produce Menu Item");
		Thread.sleep(10000);
	
		Thread.sleep(1000);
		//Select the Menu Ittem
		cmp.Click_DropDown_withSearchText(air.Menu_Item_InputBox(), MenuItemName, "Menu Item Selected");
		
		Thread.sleep(1000);
		//Enter the Quantity to Prepare
		air.Quantity_To_PrepareInputBox().clear();
		Thread.sleep(1000);
		air.Quantity_To_PrepareInputBox().sendKeys("4");
		
		driver.findElement(By.xpath("//mat-icon[contains(.,'arrow_drop_up')]")).click();
	
		Thread.sleep(4000);
		//Click the Save button
		cmp.Click_SaveButton();
		
//		Thread.sleep(2000);
		cmp.Wait_ForElementVisibility(cmp.ConfirmationAlertMsg(), 30);
		
		if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Menu Item prepared successfully"))
		{
			test.log(LogStatus.PASS, "Menu Item prepared successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Menu Item prepare Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
		
	}
	
	@Test(priority = 4,enabled = false)
	public void Verify_Prepared_MenuItem_In_MenuItem_InventoryItem_SubRecipe(WebDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		
		Thread.sleep(2000);
		//Search the Prepared SubRecipe
//		cmp.Search(SubReci_Name);
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(MenuItem_Name);
		
		Thread.sleep(3000);
		//Get The On Hand Quantity after Sub Recipe Prepared
		String After_Menu_onHand_Qty=driver.findElement(By.xpath("//span[.='"+MenuItem_Name+" ']/../../div[3]")).getText().replaceAll("[a-zA-Z $ ₹ , / :]", "").toString();
		
		double After_Menu_onHand_Quantity=Double.parseDouble(After_Menu_onHand_Qty);
		this.Aft_Menu_onHand_Quanity=String.valueOf(After_Menu_onHand_Qty);
		
		System.out.println("Menu Item Quanitity After Prepartion is : "+After_Menu_onHand_Quantity);
		test.log(LogStatus.INFO, "Menu Name : "+MenuItem_Name+" Quantity After Preparation is : "+After_Menu_onHand_Qty);
		
		//Convert Menu Item Quantity before preparation
		double Bef_Menu_onHandQty=Double.parseDouble(Bef_Menu_onHand_Quanity);
		
		//Calculate Expected Menu Item Quantity
		double Exp_MenuItem_Qty=Bef_Menu_onHandQty+5;
		
		//Verify whether the On Hand Quantity for Menu Item After Prepared Calculated correctly or not
		if(Exp_MenuItem_Qty==After_Menu_onHand_Quantity)
		{
			test.log(LogStatus.PASS, "Menu Item On Hand Quantity After Prepared Calculated Correctly");
		}
		else
		{
			double diff=Exp_MenuItem_Qty=After_Menu_onHand_Quantity;
			test.log(LogStatus.FAIL, "Menu Item On Hand Quantity After Prepared Calculated Incorrect. Value diff is : "+diff);
		
		}
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"inventoryItem");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Inventory Item");	
		Thread.sleep(5000);
		
		//String invItem = driver.findElement(By.xpath("//section/table/tbody/tr[1]/td[1]/span")).getText();
		Thread.sleep(2000);
		cmp.SearchBox().clear();
		Thread.sleep(2000);
		cmp.SearchBox().sendKeys(Inventory_Name);
	
		
		
		Thread.sleep(3000);
		//Get The On Hand Quantity after Sub Recipe Prepared
		String After_InvItem_onHand_Qty=driver.findElement(By.xpath("//span[contains(.,'"+Inventory_Name+"')]/../../div[9]")).getText().replaceAll("[a-zA-Z $ ₹ , / :]", "").toString();
		double After_InvItem_onHand_Quantity=Double.parseDouble(After_InvItem_onHand_Qty);
		this.Aft_Inv_onHand_Quanity=String.valueOf(After_InvItem_onHand_Quantity);
		
		//Convert the Inventory Item Quantity before Menu Item Preparation
		double Bef_InvItem_onHandQty=Double.parseDouble(Bef_Inv_onHand_Quanity);
		double Expected_InvItem_Qty=Bef_InvItem_onHandQty-5;
		
		//Verify the On Hand Quantity before vs after Menu Item Preparation
		if(Expected_InvItem_Qty==After_InvItem_onHand_Quantity)
		{
			test.log(LogStatus.PASS, "Inventory Item On Hand Quantity After Prepared Calculated Correctly");
		}
		else
		{
			double diff=Exp_MenuItem_Qty=After_Menu_onHand_Quantity;
			test.log(LogStatus.FAIL, "Inventory Item On Hand Quantity After Prepared Calculated Incorrect. Value diff is : "+diff);
			
		}
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"subRecipe");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Sub Recipe");	
		
		Thread.sleep(2000);
		//Search the Prepared SubRecipe
//		cmp.Search(SubReci_Name);
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(SubRecipe_Name);
		
		
		Thread.sleep(3000);
		//Get The On Hand Quantity after Sub Recipe Prepared
		String After_SubReci_onHand_Qty=driver.findElement(By.xpath("//td[.=' "+SubRecipe_Name+" ']/../..//td[5]")).getText().replaceAll("[a-zA-Z $ ₹ , / :]", "").toString();
		double After_SubReci_onHand_Quantity=Double.parseDouble(After_SubReci_onHand_Qty);
		this.Aft_SubReci_onHand_Quanity=String.valueOf(After_SubReci_onHand_Quantity);
				
		
		
		//Convert the Inventory Item Quantity before Menu Item Preparation
				double Bef_SubReci_onHandQty=Double.parseDouble(Bef_SubReci_onHand_Quanity);
				double Expected_SubReci_Qty=Bef_SubReci_onHandQty-5;
				
				//Verify the On Hand Quantity before vs after Menu Item Preparation
				if(Expected_SubReci_Qty==After_SubReci_onHand_Quantity)
				{
					test.log(LogStatus.PASS, "Sub-Recipe On Hand Quantity After Prepared Calculated Correctly");
				}
				else
				{
					double diff=Exp_MenuItem_Qty=After_Menu_onHand_Quantity;
					test.log(LogStatus.FAIL, "Sub-Recipe On Hand Quantity After Prepared Calculated Incorrect. Value diff is : "+diff);
					
				}
		
		
		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Verify_Prepared_MenuItem_In_Compare_Inventory_Report(WebDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(3000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"inventoryReports/compareInventory");

		Thread.sleep(10000);
		//Verify the Compare Inventory Report page loaded or not
		new ReportsPage(driver, test).Verify_ReportHomePage("COMPARE INVENTORY");
		
		//Select the Type
		air.Select_Type("Menu Item");

		//Select Today
		new ReportsPage(driver, test).Select_Today_TimePeriod();
		
		//Click the Apply button
		new ReportsPage(driver, test).Click_ApplyButton();
		
		Thread.sleep(5000);
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(MenuItem_Name);

		Thread.sleep(2000);
		//Get The On Hand Quantity
		String MenuItem_onHand_Qty_inRept=driver.findElement(By.xpath("//table/tbody/tr[1]/td[21]")).getText();
		double MenuItem_onHand_Qty_inReport=Double.parseDouble(MenuItem_onHand_Qty_inRept);
		
		//Menu Item On Hand Quantity in Menu After prepared
		double After_MenuItem_onHand_Qty=Double.parseDouble(Aft_Menu_onHand_Quanity);

		
		if(MenuItem_onHand_Qty_inReport==After_MenuItem_onHand_Qty)
		{
			test.log(LogStatus.PASS, "Menu Item On Hand Quantity is Equal to Prepare Menu Item Quantity After Menu Item Prepared - Compare Inventory Report");
		}
		else
		{
			double diff=MenuItem_onHand_Qty_inReport-After_MenuItem_onHand_Qty;
			test.log(LogStatus.FAIL, "Menu Item On Hand Quantity is not Equal to Prepare Menu Item Quantity After Menu Item Prepared "+"Value Diff : "+diff+"- Compare Inventory Report");
		}
		
		Thread.sleep(2000);
		//Select the Type
		air.Select_Type("Inventory Item");
				
				//Get the Inventory Item
				air.Select_InventoryItem(Inventory_Name);
				
				//Select Today
				new ReportsPage(driver, test).Select_Today_TimePeriod();
				
				//Click the Apply button
				new ReportsPage(driver, test).Click_ApplyButton();
				
				Thread.sleep(5000);
				
try {
				//Get The On Hand Quantity
				String InvItem_onHand_Qty_inRept=driver.findElement(By.xpath("//table/tbody/tr[1]/td[21]")).getText();
				double InvItem_onHand_Qty_inReport=Double.parseDouble(InvItem_onHand_Qty_inRept);
				
			

				//On Hand Quantity in Sub Recipe After
				double After_InvItem_onHand_Qty=Double.parseDouble(Aft_Inv_onHand_Quanity);

			

				
				if(InvItem_onHand_Qty_inReport==After_InvItem_onHand_Qty)
				{
					test.log(LogStatus.PASS, "Inventory Item On Hand Quantity is Equal to Prepare Menu Item Quantity After Menu Item Prepared - Compare Inventory Report");
				}
				else
				{
					double diff=InvItem_onHand_Qty_inReport-After_InvItem_onHand_Qty;
					test.log(LogStatus.FAIL, "Inventory Item On Hand Quantity is not Equal to Prepare Menu Item Quantity After Menu Item Prepared "+"Value Diff : "+diff+"- Compare Inventory Report");
				}
				
}
catch (Exception e) {
	
	if(driver.findElement(By.xpath("//div[contains(.,'No Records Found')]/span")).isDisplayed()) {
		
		test.log(LogStatus.FAIL, "Compare Inventory Report Detail not displayed");
		
	}
}
		
		//Select the Type
		air.Select_Type("Sub Recipe");
		
		//Get the Sub Recipe
		air.Select_SubRecipe(SubRecipe_Name);
		
		//Select Today
		new ReportsPage(driver, test).Select_Today_TimePeriod();
		
		//Click the Apply button
		new ReportsPage(driver, test).Click_ApplyButton();
		
		Thread.sleep(5000);
		
try {
		//Get The On Hand Quantity
		String SubRecipe_onHand_Qty_inRept=driver.findElement(By.xpath("//table/tbody/tr[1]/td[21]")).getText();
		double SubRecipe_onHand_Qty_inReport=Double.parseDouble(SubRecipe_onHand_Qty_inRept);
		
	

		//On Hand Quantity in Sub Recipe After
		double After_SubRecipe_onHand_Qty=Double.parseDouble(Aft_SubReci_onHand_Quanity);

	

		
		if(SubRecipe_onHand_Qty_inReport==After_SubRecipe_onHand_Qty)
		{
			test.log(LogStatus.PASS, "Sub-Recipe On Hand Quantity is Equal to Prepare Menu Item Quantity After Menu Item Prepared - Compare Inventory Report");
		}
		else
		{
			double diff=SubRecipe_onHand_Qty_inReport-After_SubRecipe_onHand_Qty;
			test.log(LogStatus.FAIL, "Sub-Recipe On Hand Quantity is not Equal to Prepare Menu Item Quantity After Menu Item Prepared "+"Value Diff : "+diff+" - Compare Inventory Report");
		}
}
		catch (Exception e) {
			
			if(driver.findElement(By.xpath("//div[contains(.,'No Records Found')]/span")).isDisplayed()) {
				
				test.log(LogStatus.FAIL, "Compare Inventory Report Detail not displayed");
				
			}

		}

		Thread.sleep(3000);
		//Load the Prepare Menu Item page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"prepareMenuItem");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Prepare Menu Item");	
	}
	
	@Test(priority = 4,enabled = false)
	public void Verify_Prepared_MenuItem_In_Production_Log(WebDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(1000);
		//Click the Production Log Tab
		air.Click_Production_Log();
		
		//Select Today Time Period
		new ReportsPage(driver, test).Select_Today_TimePeriod();
		
		//Click the Apply button
		air.Click_ApplyButton();
		
		Thread.sleep(5000);
		new Common_XPaths(driver, test).SearchBox().clear();
		new Common_XPaths(driver, test).SearchBox().sendKeys(MenuItem_Name);
		
		try
		{
			if(air.No_Production_Record_PrepareMenuItem_Logs().isDisplayed())
			{
				test.log(LogStatus.FAIL, "No production Record for Selected Menu Item for this Selected Time Period - Today");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
			}
		}
		catch(Exception k)
		{
			test.log(LogStatus.PASS, "Production Record for Selected Menu Item - Today");
		
			//List<WebElement> prodList=driver.findElements(By.xpath(""));
			
			
		
		}
		
		Thread.sleep(2000);
		//Click the Production Tab
		air.Click_ProductionTab();
		Thread.sleep(2000);
	}
	
}
