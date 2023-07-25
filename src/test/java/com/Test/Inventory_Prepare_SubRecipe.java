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

public class Inventory_Prepare_SubRecipe 
{
	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Inventory - Prepare SubRecipe");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	InventoryPage air;
	BasePage bp=new BasePage();
	
	String SubRecipe_Name;
	
	String Aft_onHand_Quanity;
	
	String Aft_OnHand_Price;
	
	String Bef_onHand_Quanity;
	
	String Bef_OnHand_Price;
	
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
		Open_Transfer_Request_Page(driver);
		RefreshAndPaginination_ColumnFilteration(driver);
		Prepare_SubRecipe(driver);
		Verify_Prepared_SubRecipe_In_Compare_Inventory_Report(driver);
		
	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Transfer_Request_Page(WebDriver driver) throws Exception
	{
		
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(5000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"prepareSubRecipe");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Prepare Sub Recipe");	
		
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
//		cmp.Ascending_And_Descending_Order();

	}
	
	@Test(priority = 4,enabled = false)
	public void Prepare_SubRecipe(WebDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		Thread.sleep(2000);
		cmp.SearchAndVerify_SearchBox();
		Thread.sleep(1000);
		cmp.SearchBox().clear();
		
		driver.navigate().refresh();
		
		Thread.sleep(10000);
		//Get the List of SubRecipes
		List<WebElement> SubRec_List=driver.findElements(By.xpath("//section/table/tbody/tr/td[1]/span"));
		
		
		int SubRec_Size=SubRec_List.size();
		
		int randomOpt=ThreadLocalRandom.current().nextInt(1, SubRec_Size);
		

		//Get The Sub Recipe Name
		String SubReci_Name=driver.findElement(By.xpath("//section/table/tbody/tr["+randomOpt+"]/td[1]/span")).getText();
	
		//Search the Sub recipe
//		cmp.Search(SubReci_Name);
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(SubReci_Name);
		
		Thread.sleep(3000);
		//Get The On Hand Quantity after Sub Recipe Prepared
		String Before_onHand_Qty=driver.findElement(By.xpath("//td[contains(.,'"+SubReci_Name+"')]/span/../../td[3]/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "").toString();
		double Before_onHand_Quantity=Double.parseDouble(Before_onHand_Qty);
		this.Bef_onHand_Quanity=String.valueOf(Before_onHand_Quantity);
		
		//Get The On Hand Price after Sub Recipe Prepared
		String Before_onHand_Pric=driver.findElement(By.xpath("//td[contains(.,'"+SubReci_Name+"')]/span/../../td[2]/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "").toString();
		double Before_onHand_Price=Double.parseDouble(Before_onHand_Pric);
		this.Bef_OnHand_Price=String.valueOf(Before_onHand_Price);
		
		
		Thread.sleep(1000);
		//Click the Prepare SubRecipe 
		air.Click_Prepare_SubRecipeButton();
		
		//Verify the New Course creation screen opened or not
		cmp.VerifyCreationScreenPageHeader("Prepare Sub Recipe");
		Thread.sleep(10000);
	
		//Select the Sub Recipe
		air.Select_SubRecipe(SubReci_Name);
		
		//Enter the Quantity
		cmp.Enter_Quantity("10");
		
		//Select the Primary Storage
		air.Select_Primary_Storage();
		
		//Click the Save button
		cmp.Save_Button().click();
		
		try {
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
		catch (Exception e) {
			test.log(LogStatus.FAIL, "Not Able to save");
			
			cmp.Click_CancelButton();
		}
		//Search the Prepared SubRecipe
//		cmp.Search(SubReci_Name);
		cmp.SearchBox().clear();
		cmp.SearchBox().sendKeys(SubReci_Name);
		
		//To assign Sub Recipe name Globally
		this.SubRecipe_Name=SubReci_Name;
		
		Thread.sleep(3000);
		//Get The On Hand Quantity after Sub Recipe Prepared
		String After_onHand_Qty=driver.findElement(By.xpath("//td[contains(.,'"+SubReci_Name+"')]/span/../../td[3]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "").toString();
		double After_onHand_Quantity=Double.parseDouble(After_onHand_Qty);
		this.Aft_onHand_Quanity=String.valueOf(After_onHand_Quantity);
		
		//Get The On Hand Price after Sub Recipe Prepared
		String After_onHand_Pric=driver.findElement(By.xpath("//td[contains(.,'"+SubReci_Name+"')]/span/../../td[2]/span")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "").toString();
		double After_onHand_Price=Double.parseDouble(After_onHand_Pric);
		this.Aft_OnHand_Price=String.valueOf(After_onHand_Price);
		
		
		//Expected Quantity
		double Expected_Quantity=Before_onHand_Quantity+10;
		
		if(Expected_Quantity==After_onHand_Quantity)
		{
			test.log(LogStatus.PASS, "On Hand Quantity is Equal after SubRecipe Prepared");
		}
		else
		{
			double diff=Expected_Quantity-After_onHand_Quantity;
			test.log(LogStatus.FAIL, "On Hand Quantity is not Equal after SubRecipe Prepared. Diff is : "+diff);
		}
		
		
		
	}
	
	
	@Test(priority = 4,enabled = false)
	public void Verify_Prepared_SubRecipe_In_Compare_Inventory_Report(WebDriver driver) throws Exception
	{
		air=new InventoryPage(driver, test);
		cmp=new Common_XPaths(driver, test);
		
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id3")+"inventoryReports/compareInventory");

		Thread.sleep(5000);
		//Verify the Compare Inventory Report page loaded or not
		new ReportsPage(driver, test).Verify_ReportHomePage("COMPARE INVENTORY");
		
		//Select the Type
		air.Select_Type("Sub Recipe");
		
		//Get the Sub Recipe
		air.Select_SubRecipe(SubRecipe_Name);
		
		//Select Today
		new ReportsPage(driver, test).Select_Today_TimePeriod();
		
		//Click the Apply button
		new ReportsPage(driver, test).Click_ApplyButton();
		
		Thread.sleep(5000);
		
//		//Get The Beginning Quantity
//		String Begin_Qty_inRept=driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]")).getText();
//		double Begin_Qty_inReport=Double.parseDouble(Begin_Qty_inRept);
//		
//		//Get The Beginning Price
//		String Begin_Price_inRept=driver.findElement(By.xpath("//table/tbody/tr[1]/td[2]")).getText();
//		double Begin_Price_inReport=Double.parseDouble(Begin_Price_inRept);
		
		//Get The On Hand Quantity
		String onHand_Qty_inRept=driver.findElement(By.xpath("//table/tbody/tr[1]/td[21]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "").toString();
		double onHand_Qty_inReport=Double.parseDouble(onHand_Qty_inRept);
		
		//Get The On Hand Price
		String onHand_Price_inRept=driver.findElement(By.xpath("//table/tbody/tr[1]/td[22]")).getText().replaceAll("[a-zA-Z $ ₹ , :]", "").toString();
		double onHand_Price_inReport=Double.parseDouble(onHand_Price_inRept);
		
		//On Hand Quantity in Sub Recipe Before
//		double Before_onHand_Qty_inSubRecipe=Double.parseDouble(Bef_onHand_Quanity);
//
//		//On Hand Price in Sub Recipe Before
//		double Before_onHand_Price_inSubRecipe=Double.parseDouble(Bef_OnHand_Price);

		//On Hand Quantity in Sub Recipe After
		double After_onHand_Qty_inSubRecipe=Double.parseDouble(Aft_onHand_Quanity);

		//On Hand Price in Sub Recipe After
		double After_onHand_Price_inSubRecipe=Double.parseDouble(Aft_OnHand_Price);

//		if(Before_onHand_Qty_inSubRecipe==Begin_Qty_inReport)
//		{
//			test.log(LogStatus.PASS, "Beginning Quantity is Equal to Prepare SubRecipe Quantity Before Preparation");
//		}
//		else
//		{
//			test.log(LogStatus.PASS, "Beginning Quantity is not Equal to Prepare SubRecipe Quantity Before Preparation");
//
//		}
//		
//		if(Before_onHand_Price_inSubRecipe==Begin_Price_inReport)
//		{
//			test.log(LogStatus.PASS, "Beginning Price is Equal to Prepare SubRecipe Quantity Before Preparation");
//		}
//		else
//		{
//			test.log(LogStatus.PASS, "Beginning Price is not Equal to Prepare SubRecipe Quantity Before Preparation");
//
//		}
//		
		
		if(onHand_Qty_inReport==After_onHand_Qty_inSubRecipe)
		{
			test.log(LogStatus.PASS, "On Hand Quantity is Equal to Prepare SubRecipe Quantity After SubRecipe Prepared - Compare Inventory Report");
		}
		else
		{
			test.log(LogStatus.PASS, "On Hand Quantity is not Equal to Prepare SubRecipe Quantity After SubRecipe Prepared - Compare Inventory Report");

		}
		
		if(onHand_Price_inReport==After_onHand_Price_inSubRecipe)
		{
			test.log(LogStatus.PASS, "On Hand Price is Equal to Prepare SubRecipe Quantity After SubRecipe Prepared - Compare Inventory Report");
		}
		else
		{
			test.log(LogStatus.PASS, "On Hand Price is not Equal to Prepare SubRecipe Quantity After SubRecipe Prepared - Compare Inventory Report");

		}
		
		
		Thread.sleep(2000);
		//Load the Department page
		driver.get(Utility.getProperty("baseURL")+Utility.getProperty("store_Id5")+"prepareSubRecipe");

		Thread.sleep(5000);
		//Verify the Coursing page loaded or not
		cmp.VerifyMainScreenPageHeader("Prepare Sub Recipe");	
	}
	
	
}
