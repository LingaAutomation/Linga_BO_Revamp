package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import com.Pages.Common_XPaths;
import com.Pages.KitchenPrinterTemplatePage;
import com.Pages.LoginPage;
import com.epam.healenium.SelfHealingDriver;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Kitchen_Printer_Template 
{

	public SelfHealingDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings - Kitchen Printer Template");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	KitchenPrinterTemplatePage kpt;
	
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
		Open_Kitchen_Printer_Template_Page(driver);
		Disable_All_Kitchen_Printer_Template_Settings(driver);
		Enable_All_Kitchen_Printer_Template_Settings(driver);
		

	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Kitchen_Printer_Template_Page(SelfHealingDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		kpt=new KitchenPrinterTemplatePage(driver, test);
		Thread.sleep(5000);
		//Load the Kitchen Printer Template page
		driver.get(Utility.getProperty("baseURL")+"settings/"+"kitchenPrinterTemplate");

		Thread.sleep(5000);
		//Verify the Kitchen Printer Template page loaded or not
		if(kpt.Kitchen_Printer_TemplateHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Kitchen Printer Template Page Loaded Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Kitchen Printer Template Page Loading Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Disable_All_Kitchen_Printer_Template_Settings(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kpt=new KitchenPrinterTemplatePage(driver, test);
		Thread.sleep(2000);
	
		Thread.sleep(1000);	
		//Click Small Font Size
		kpt.Click_Small_FontSize();
		
		Thread.sleep(1000);
		//Open Store & Check Details Screen
		kpt.Open_Store_CheckDetails_Screen();
		
		
			
				Thread.sleep(2000);
				//Select the Store Name Font
				try
				{
				if(kpt.Store_Name_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(2000);
					kpt.Store_Name_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
			//	Thread.sleep(2000);
				try
				{
				//Select the Table Name Font
				if(kpt.Table_Name_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(2000);
					kpt.Table_Name_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				
//				Thread.sleep(1000);
				try
				{
				//Select the Check Number Font
				if(kpt.Check_Number_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(2000);
					kpt.Check_Number_CheckBox().click();
					
					try
					{
						Thread.sleep(1000);
						if(kpt.Inline_Position_Check_Number_RadioButton().isDisplayed())
						{
							test.log(LogStatus.FAIL, "Inline Position for Check Number Radio button Displayed");

						}
						
					}
					catch(Exception g)
					{
						test.log(LogStatus.PASS, "Inline Position for Check Number Radio button not Displayed");

					}
				}
				}
				catch(Exception g)
				{
					
				}
				
//				Thread.sleep(1000);
				try
				{
				//Select the Printer Name Font
				if(kpt.Printer_Name_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(2000);
					kpt.Printer_Name_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
//				Thread.sleep(1000);
				try
				{
				//Disable Server Name
				if(kpt.Server_Name_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(2000);
					kpt.Server_Name_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
//				Thread.sleep(1000);
				try
				{
				//Disable Print Date & Time
				if(kpt.Printer_DateTime_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(2000);
					kpt.Printer_DateTime_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				
//				Thread.sleep(1000);
				try
				{
				//Disable Customer Name Checkbox
				if(kpt.Customer_Name_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(2000);
					kpt.Customer_Name_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
//				Thread.sleep(1000);
				try
				{
				//Disable Pickup Date & Time Checkbox
				if(kpt.PickUp_DateTime_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(2000);
					kpt.PickUp_DateTime_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
//				Thread.sleep(1000);
				try
				{
				//Select the Check Number Font
				if(kpt.ServiceType_CheckBox_Selected().isDisplayed())
				{
					Thread.sleep(2000);
					kpt.ServiceType_CheckBox().click();
					
					try
					{
						Thread.sleep(1000);
						if(kpt.Inline_Position_Service_Type_RadioButton().isDisplayed())
						{
							test.log(LogStatus.FAIL, "Inline Position for Service Type Radio button Displayed");

						}
						
					}
					catch(Exception g)
					{
						test.log(LogStatus.PASS, "Inline Position for Service Type Radio button not Displayed");

	
					}
				}
				}
				catch(Exception g)
				{
					
				}
				
				Thread.sleep(1000);
				//Close the Store & Check Details screen
				kpt.Close_Store_CheckDetails_Screen();
				
				for(int i=1;i<=3;i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}
				
				Thread.sleep(1000);
				//Open Order & Item Summary
				kpt.Open_Order_and_ItemSummary_Screen();
				
				
				Thread.sleep(1000);
				try
				{
				//Disable Split By Course Checkbox
				if(kpt.SplitByCourse_CheckBox_Selected().isDisplayed())
				{
					kpt.SplitByCourse_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
//				Thread.sleep(1000);
				try
				{
				//Disable Other language Menu Name Checkbox
				if(kpt.OtherLanguage_MenuName_CheckBox_Selected().isDisplayed())
				{
					kpt.OtherLanguage_MenuName_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
//				Thread.sleep(1000);
				try
				{
				//Disable Menu Price Checkbox
				if(kpt.Menu_Price_CheckBox_Selected().isDisplayed())
				{
					kpt.Menu_Price_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
//				Thread.sleep(1000);
				try
				{
				//Disable Consolidate Menu In Kitchen Checkbox
				if(kpt.Consolidate_Menu_InKitchen_CheckBox_Selected().isDisplayed())
				{
					kpt.Consolidate_Menu_InKitchen_CheckBox().click();
					
					try
					{
					if(kpt.Split_MenuQuantity_CheckBox().isDisplayed())
					{
						test.log(LogStatus.PASS, "Split Menu Quantity Checkbox Displayed");
						
						
					}
					}
					catch(Exception g)
					{
						test.log(LogStatus.FAIL, "Split Menu Quantity Checkbox not Displayed");
					}
				}
				}
				catch(Exception g)
				{
					
				}
				
//				Thread.sleep(1000);
				try
				{
				//Disable Quantity Before Item Name Checkbox
				if(kpt.QuantityBefore_ItemName_CheckBox_Selected().isDisplayed())
				{
					kpt.QuantityBefore_ItemName_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
//				Thread.sleep(1000);
				try
				{
				//Disable Enable Item Summary Checkbox
				if(kpt.Enable_ItemSummary_CheckBox_Selected().isDisplayed())
				{
					kpt.Enable_ItemSummary_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
//				Thread.sleep(1000);
				try
				{
				//Disable All Modifiers in Modifier Print Checkbox
				if(kpt.AllModifiers_inModifierPrint_CheckBox_Selected().isDisplayed())
				{
					kpt.AllModifiers_inModifierPrint_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				Thread.sleep(1000);
				//Close Order & Item Summary
				kpt.Close_Order_and_ItemSummary_Screen();
				
				Thread.sleep(1000);
				//Open Customer Info Screen
				kpt.Open_Customer_Info_Screen();
				
				Thread.sleep(1000);
//				//Disable At Top of Check Checkbox
//				if(kpt.At_Top_of_Check_RadioButton().isSelected())
//				{
//					kpt.At_Top_of_Check_RadioButton().click();
//				}
				
				for(int i=1;i<=5;i++) 
				{
					Thread.sleep(500);
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
				}
				
//				Thread.sleep(1000);
				try
				{
				//Disable At Bottom of Check Checkbox
				if(kpt.At_Top_of_Check_RadioButton_Selected().isDisplayed())
				{
					
				}
				}
				catch(Exception k)
				{
					
					kpt.At_Top_of_Check_RadioButton().click();

				}
				
//				Thread.sleep(1000);
				try
				{
				//Disable Address Checkbox
				if(kpt.Address__CustomerInfo_CheckBox_Selected().isDisplayed())
				{
					kpt.Address__CustomerInfo_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
//				Thread.sleep(1000);
				try
				{
				//Disable Email Checkbox
				if(kpt.Email_CustomerInfo_CheckBox_Selected().isDisplayed())
				{
					kpt.Email_CustomerInfo_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
//				Thread.sleep(1000);
				try
				{
				//Disable Phone Number Checkbox
				if(kpt.Phone_Number_CustomerInfo_CheckBox_Selected().isDisplayed())
				{
					kpt.Phone_Number_CustomerInfo_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
//				Thread.sleep(1000);
				try
				{
				//Disable Customer Notes Checkbox
				if(kpt.Customer_Notes_CustomerInfo_CheckBox_Selected().isDisplayed())
				{
					kpt.Customer_Notes_CustomerInfo_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				Thread.sleep(1000);
				//Close Customer Info Screen
				kpt.Close_Customer_Info_Screen();
				
				
				for(int i=1;i<=4;i++) 
				{
					Thread.sleep(500);
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				}
				
				Thread.sleep(1000);
				//Open Driver Receipt Options
				kpt.Open_Driver_ReceiptOptions_Screen();
				
				Thread.sleep(1000);
				//Disable Enable Driver Receipt
				kpt.Disable_DriverReceipt();
				
				Thread.sleep(1000);
				//Close Driver Receipt screen
				kpt.Close_Driver_ReceiptOptions_Screen();
				
				Thread.sleep(1000);
				//Open Additional Details
				kpt.Open_Additional_Details_Screen();
				
				Thread.sleep(1000);
				try
				{
				//Disable Customer Notes Checkbox
				if(kpt.CutPaper_After_EachPrint_CheckBox_Selected().isDisplayed())
				{
					kpt.CutPaper_After_EachPrint_CheckBox().click();
				}
				}
				catch(Exception g)
				{
					
				}
				
				Thread.sleep(1000);
				//Close Additional Details
				kpt.Close_Additional_Details_Screen();
				
				Thread.sleep(1000);
				//Click the Update button
				cmp.Click_Update_ButtonTwo();
				
				Thread.sleep(3000);
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Kitchen Receipt Template Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Kitchen Receipt Template Saved Successfully After Disable All Checkboxes");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Kitchen Printer Template Save Failed After Disabling All Checkboxes");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				Thread.sleep(3000);
				driver.navigate().refresh();
				
	}
	@Test(priority = 4,enabled = false)
	public void Enable_All_Kitchen_Printer_Template_Settings(SelfHealingDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		kpt=new KitchenPrinterTemplatePage(driver, test);
		Thread.sleep(15000);
	
				
				Thread.sleep(5000);
			
				//Check whether the Small Font Size Selected or not
				if(kpt.Small_FontSize().isDisplayed())
				{
					test.log(LogStatus.PASS, "Small Font Size is Selected");
				}
				else
				{
					test.log(LogStatus.FAIL, "Small Font Size is not Selected");
				}
				
				//Click Medium font size
				kpt.Click_Medium_FontSize();
				
				Thread.sleep(1000);
				//Open Store & Check Details
				kpt.Open_Store_CheckDetails_Screen();
				
				Thread.sleep(1000);
				try
				{
					//Check and Enable Store Name Checkbox
					if(kpt.Store_Name_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Store Name Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Store Name
						kpt.Store_Name_CheckBox().click();
		
					
					}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Store Name Check Box Selected while Reopening the page After Saved");
				}
				
//				Thread.sleep(1000);
				try
				{
					//Check and Enable Table Name Checkbox
					if(kpt.Table_Name_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Table Name Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Table Name
						kpt.Table_Name_CheckBox().click();
					}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Table Name Check Box Selected while Reopening the page After Saved");
				}
				
//				Thread.sleep(1000);
				try
				{
					//Check and Enable Check Number Checkbox
					if(kpt.Check_Number_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Check Number Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Check Number
						kpt.Check_Number_CheckBox().click();
						
						try
						{
							Thread.sleep(1000);
							if(kpt.Inline_Position_Check_Number_RadioButton().isDisplayed())
							{
								test.log(LogStatus.PASS, "Inline Position for Check Number Radio button Displayed");
							
								Thread.sleep(1000);
								kpt.Inline_Position_Check_Number_RadioButton().click();
							}
							
						}
						catch(Exception k)
						{
							test.log(LogStatus.FAIL, "Inline Position for Check Number Radio button not Displayed");
		
						}
					}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Check Number Check Box Selected while Reopening the page After Saved");
				}			
				
	
//				Thread.sleep(1000);
				try
				{
					//Check and Enable Printer Name Checkbox
					if(kpt.Printer_Name_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Printer Name Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Printer Name
						kpt.Printer_Name_CheckBox().click();
					}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Printer Name Check Box Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
					//Check and Enable Server Name Checkbox
					if(kpt.Server_Name_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Server Name Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Server Name
						kpt.Server_Name_CheckBox().click();	
					}
				}
				catch(Exception j)
				{					
					test.log(LogStatus.FAIL, "Server Name Check Box Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
					//Check and Enable Print Date & Time Checkbox
					if(kpt.Printer_DateTime_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Print Date & Time Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Print Date & Time
						kpt.Printer_DateTime_CheckBox().click();		
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.FAIL, "Print Date & Time Check Box Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
					//Check and Enable Customer Name Checkbox
					if(kpt.Customer_Name_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Customer Name Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Customer Name
						kpt.Customer_Name_CheckBox().click();
					}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Customer Name Check Box Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
					//Check and Enable PickUp Date & Time Checkbox
					if(kpt.PickUp_DateTime_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "PickUp Date & Time Check Box not Selected while Reopening the page After Saved");					
						
						Thread.sleep(1000);
						//Enable PickUp Date & Time
						kpt.PickUp_DateTime_CheckBox().click();
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.FAIL, "PickUp Date & Time Check Box Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
					//Check and Enable Service Type Checkbox
					if(kpt.ServiceType_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Service Type Check Box not Selected while Reopening the page After Saved");					
						
						Thread.sleep(1000);
						//Enable Service Type
						kpt.ServiceType_CheckBox().click();
						
						try
						{
							if(kpt.Inline_Position_Service_Type_RadioButton().isDisplayed())
							{
								test.log(LogStatus.PASS, "Inline Position for Service Type Radio button Displayed");
							
								Thread.sleep(1000);
								kpt.Inline_Position_Service_Type_RadioButton().click();
							}
							
						}
						catch(Exception g)
						{
							test.log(LogStatus.FAIL, "Inline Position for Service Type Radio button not Displayed");
						}	
					}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Service Type Check Box Selected while Reopening the page After Saved");
				}
				
				Thread.sleep(1000);
				//Close the Store & Check Details screen
				kpt.Close_Store_CheckDetails_Screen();
				
				Thread.sleep(1000);
				//Open the Order & Item Summary Screen
				kpt.Open_Order_and_ItemSummary_Screen();
				
				
				Thread.sleep(1000);
				try
				{
					//Check and Enable Split By Course Checkbox
					if(kpt.SplitByCourse_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Split By Course Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Split By Course
						kpt.SplitByCourse_CheckBox().click();
					}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Split By Course Check Box Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
					//Check and Enable Other language Menu Name Checkbox
					if(kpt.OtherLanguage_MenuName_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Other language Menu Name Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Other language Menu Name
						kpt.OtherLanguage_MenuName_CheckBox().click();
					}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Other language Menu Name Check Box Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
					//Check and Enable Menu Price Checkbox
					if(kpt.Menu_Price_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Menu Price Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Menu Price
						kpt.Menu_Price_CheckBox().click();
					}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Menu Price Check Box Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Consolidate Menu In Kitchen Checkbox
				if(kpt.Consolidate_Menu_InKitchen_CheckBox_Selected1().isDisplayed())
				{
					test.log(LogStatus.PASS, "Consolidate Menu In Kitchen Check Box not Selected while Reopening the page After Saved");					
					
					if(kpt.Split_MenuQuantity_CheckBox_Selected().isDisplayed())
					{
						kpt.Split_MenuQuantity_CheckBox().click();
					}
					
					//Enable Consolidate Menu In Kitchen
					kpt.Consolidate_Menu_InKitchen_CheckBox().click();	
				}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Consolidate Menu In Kitchen Check Box Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
					//Check and Enable Quantity Before Item Name Checkbox
					if(kpt.QuantityBefore_ItemName_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Quantity Before Item Name Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Quantity Before Item Name
						kpt.QuantityBefore_ItemName_CheckBox().click();
					}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Quantity Before Item Name Check Box Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
					//Check and Enable Enable Item Summary Checkbox
					if(kpt.Enable_ItemSummary_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Enable Item Summary Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Enable Item Summary
						kpt.Enable_ItemSummary_CheckBox().click();		
					}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Enable Item Summary Check Box Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
					//Check and Enable All Modifiers in Modifier Print Checkbox
					if(kpt.AllModifiers_inModifierPrint_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "All Modifiers in Modifier Print Check Box not Selected while Reopening the page After Saved");					
						
						//Enable All Modifiers in Modifier Print
						kpt.AllModifiers_inModifierPrint_CheckBox().click();		
					}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "All Modifiers in Modifier Print Check Box Selected while Reopening the page After Saved");
				}
				
			
				Thread.sleep(1000);
				//Close the Order & Item Summary Screen
				kpt.Close_Order_and_ItemSummary_Screen();
				
				
//				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				
				Thread.sleep(1000);
				//Open Customer Info Screen
				kpt.Open_Customer_Info_Screen();
				
				Thread.sleep(1000);
				//Check whether the At Top of Check
				if(kpt.At_Top_of_Check_RadioButton_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "At Top of Check is Selected");
					
					//Enable At Bottom Check
					kpt.At_Bottom_of_Check_RadioButton().click();
				}
				else
				{
					test.log(LogStatus.FAIL, "At Top of Check is not Selected");
				}
				
				Thread.sleep(1000);
				try
				{
					//Check and Enable Address Checkbox
					if(kpt.Address__CustomerInfo_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Address Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Address
						kpt.Address__CustomerInfo_CheckBox().click();		
					}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Address Check Box Selected while Reopening the page After Saved");
				}
				
//				Thread.sleep(1000);
				try
				{
					//Check and Enable Email Checkbox
					if(kpt.Email_CustomerInfo_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Email Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Email
						kpt.Email_CustomerInfo_CheckBox().click();
					}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Email Check Box Selected while Reopening the page After Saved");
				}
				
//				Thread.sleep(1000);
				try
				{
					//Check and Enable Phone Number Checkbox
					if(kpt.Phone_Number_CustomerInfo_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Phone Number Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Phone Number
						kpt.Phone_Number_CustomerInfo_CheckBox().click();			
					}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Phone Number Check Box Selected while Reopening the page After Saved");
				}
				
//				Thread.sleep(1000);
				try
				{
					//Check and Enable Customer Notes Checkbox
					if(kpt.Customer_Notes_CustomerInfo_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Customer Notes Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Customer Notes
						kpt.Customer_Notes_CustomerInfo_CheckBox().click();	
					}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Customer Notes Check Box Selected while Reopening the page After Saved");
				}
				
				Thread.sleep(2000);
				//Close Customer Info Screen
				kpt.Close_Customer_Info_Screen();
				
				
				
				Thread.sleep(2000);
				//Open Driver Receipt Options Screen
				kpt.Open_Driver_ReceiptOptions_Screen();
				
				Thread.sleep(2000);
				//Enable Driver Receipt 
				kpt.Enable_DriverReceipt();
				
				Thread.sleep(1000);
				//Select No of Copies
				kpt.Enter_No_ofCopies("100");
				
				Thread.sleep(1000);
				//Check whether the No of Copies Error msg displays or not
				if(kpt.No_ofCopiesErrorMsg().isDisplayed())
				{
					test.log(LogStatus.PASS, "The value must be in range 1 to 10 Displayed when Entering above 10");
				}
				else
				{
					test.log(LogStatus.FAIL, "The value must be in range 1 to 10 not Displayed when Entering above 10");
				}
				
				Thread.sleep(1000);
				//Select No of Copies
				kpt.Enter_No_ofCopies("0");
				
				Thread.sleep(1000);
				//Check whether the No of Copies Error msg displays or not
				if(kpt.No_ofCopiesErrorMsg().isDisplayed())
				{
					test.log(LogStatus.PASS, "The value must be in range 1 to 10 Displayed when Entering 0");
				}
				else
				{
					test.log(LogStatus.FAIL, "The value must be in range 1 to 10 not Displayed when Entering 0");
				}
				try
				{
				Thread.sleep(1000);
				//Select No of Copies
				kpt.Enter_No_ofCopies("-2");
				
				Thread.sleep(1000);
				//Check whether the No of Copies Error msg displays or not
				if(kpt.No_ofCopiesErrorMsg().isDisplayed())
				{
					test.log(LogStatus.PASS, "The value must be in range 1 to 10 Displayed when Entering Negative values");
				}
				else
				{
					test.log(LogStatus.FAIL, "The value must be in range 1 to 10 not Displayed when Entering Negative values");
				}}
				catch(Exception l) {}
				
				Thread.sleep(1000);
				//Select No of Copies
				kpt.Enter_No_ofCopies("2");
				
				Thread.sleep(1000);
				//No of Copies Before
				String No_ofCopyBef=kpt.No_ofCopies_InputBox().getAttribute("value");
				
				Thread.sleep(1000);
				try
				{
					//Disable Total Checkbox
					if(kpt.Total_DriverReceipt_CheckBox_Selected1().isDisplayed())
					{
						kpt.Total_DriverReceipt_CheckBox().click();
					}
				}
				catch(Exception l)
				{
				}
				
//				Thread.sleep(1000);
				try
				{
					//Disable Tip Checkbox
					if(kpt.Tip_DriverReceipt_CheckBox_Selected1().isDisplayed())
					{
						kpt.Tip_DriverReceipt_CheckBox().click();
					}
				}
				catch(Exception l)
				{
				}
				
//				Thread.sleep(1000);
				try
				{
					//Disable Signature Checkbox
					if(kpt.Signature_DriverReceipt_CheckBox_Selected1().isDisplayed())
					{
						kpt.Signature_DriverReceipt_CheckBox().click();
					}
				}
				catch(Exception l)
				{
				}
				
//				Thread.sleep(1000);
				try
				{
					//Disable Balance Due Checkbox
					if(kpt.Balance_Due_DriverReceipt_CheckBox_Selected1().isDisplayed())
					{
						kpt.Balance_Due_DriverReceipt_CheckBox().click();
					}
				}
				catch(Exception l)
				{}
				
				
				Thread.sleep(1000);
				//Close Driver Receipt Options Screen
				kpt.Close_Driver_ReceiptOptions_Screen();
				
				Thread.sleep(1000);
				//Open Additional Details
				kpt.Open_Additional_Details_Screen();
				
				
				Thread.sleep(1000);
				try
				{
					//Check and Enable Cut Paper After Each print Checkbox
					if(kpt.CutPaper_After_EachPrint_CheckBox_Selected1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Cut Paper After Each print Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Cut Paper After Each print
						kpt.CutPaper_After_EachPrint_CheckBox().click();
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.FAIL, "Cut Paper After Each print Check Box Selected while Reopening the page After Saved");
				}
				
				Thread.sleep(1000);
				//Close Additional Details
				kpt.Close_Additional_Details_Screen();
				
				Thread.sleep(1000);
				//Click the Update button
				cmp.Click_Update_ButtonTwo();
				
				Thread.sleep(3000);
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Kitchen Receipt Template Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Kitchen Receipt Template Saved Successfully After Enabled All Checkboxes");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Kitchen Printer Template Save Failed After Enabling All Checkboxes");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				Thread.sleep(8000);
				
			
				
				//Open Store & Check Details
				kpt.Open_Store_CheckDetails_Screen();
				
				Thread.sleep(1000);
				try
				{
				//Check and Enable Store Name Checkbox
				if(kpt.Store_Name_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Store Name Check Box Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Store Name Check Box not Selected while Reopening the page After Saved");
				}
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Table Name Checkbox
				if(kpt.Table_Name_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Table Name Check Box Selected while Reopening the page After Saved");					

				
				}
				}
				catch(Exception k)
				{
					test.log(LogStatus.FAIL, "Table Name Check Box not Selected while Reopening the page After Saved");
				}
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Check Number Checkbox
				if(kpt.Check_Number_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Check Number Check Box Selected while Reopening the page After Saved");					
			
					try
					{
						if(kpt.Inline_Position_Check_Number_RadioButton_Selected().isDisplayed())
						{
							test.log(LogStatus.PASS, "Inline Position for Check Number Radio button is Selected");
						
							Thread.sleep(1000);
							kpt.Title_Position_Check_Number_RadioButton().click();
						}
						
					}
					catch(Exception g)
					{
						test.log(LogStatus.FAIL, "Inline Position for Check Number Radio button is not Selected");
	
					}
				
				}
				}
				catch(Exception k)
				{
					test.log(LogStatus.FAIL, "Table Name Check Box not Selected while Reopening the page After Saved");
				}			
				
	
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Printer Name Checkbox
				if(kpt.Printer_Name_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Printer Name Check Box Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception k)
				{
					test.log(LogStatus.FAIL, "Printer Name Check Box not Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Server Name Checkbox
				if(kpt.Server_Name_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Server Name Check Box Selected while Reopening the page After Saved");					
			
				
				}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Server Name Check Box not Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Print Date & Time Checkbox
				if(kpt.Printer_DateTime_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Print Date & Time Check Box Selected while Reopening the page After Saved");					
			
				
				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Print Date & Time Check Box not Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Customer Name Checkbox
				if(kpt.Customer_Name_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Customer Name Check Box Selected while Reopening the page After Saved");					
		
				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Customer Name Check Box not Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable PickUp Date & Time Checkbox
				if(kpt.PickUp_DateTime_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "PickUp Date & Time Check Box Selected while Reopening the page After Saved");					
	
				}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "PickUp Date & Time Check Box not Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Service Type Checkbox
				if(kpt.ServiceType_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Service Type Check Box Selected while Reopening the page After Saved");					
		
					
					try
					{
						if(kpt.Inline_Position_Service_Type_RadioButton().isSelected())
						{
							test.log(LogStatus.PASS, "Inline Position for Service Type Radio button is Selected");
						
							Thread.sleep(1000);
							kpt.Title_Position_Check_Number_RadioButton().click();
						}
						
					}
					catch(Exception g)
					{
						test.log(LogStatus.FAIL, "Inline Position for Service Type Radio button is not Selected");
	
					}
				
				}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Service Type Check Box not Selected while Reopening the page After Saved");
				}
				
				//Close the Store & Check Details screen
				kpt.Close_Store_CheckDetails_Screen();
				
				//Open the Order & Item Summary Screen
				kpt.Open_Order_and_ItemSummary_Screen();
				
				
				Thread.sleep(1000);
				try
				{
				//Check and Enable Split By Course Checkbox
				if(kpt.SplitByCourse_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Split By Course Check Box Selected while Reopening the page After Saved");					
		
				
				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Split By Course Check Box not Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Other language Menu Name Checkbox
				if(kpt.OtherLanguage_MenuName_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Other language Menu Name Check Box Selected while Reopening the page After Saved");					
		
				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Other language Menu Name Check Box not Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Menu Price Checkbox
				if(kpt.Menu_Price_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Menu Price Check Box Selected while Reopening the page After Saved");					
		
				
				}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Menu Price Check Box not Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Consolidate Menu In Kitchen Checkbox
				if(kpt.Consolidate_Menu_InKitchen_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Consolidate Menu In Kitchen Check Box Selected while Reopening the page After Saved");					
		
				}
				}
				catch(Exception u)
				{
					test.log(LogStatus.FAIL, "Consolidate Menu In Kitchen Check Box not Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Quantity Before Item Name Checkbox
				if(kpt.QuantityBefore_ItemName_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Quantity Before Item Name Check Box Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception y)
				{
					test.log(LogStatus.FAIL, "Quantity Before Item Name Check Box not Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Enable Item Summary Checkbox
				if(kpt.Enable_ItemSummary_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Enable Item Summary Check Box Selected while Reopening the page After Saved");					
	
				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Enable Item Summary Check Box not Selected while Reopening the page After Saved");
				}
				
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable All Modifiers in Modifier Print Checkbox
				if(kpt.AllModifiers_inModifierPrint_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "All Modifiers in Modifier Print Check Box Selected while Reopening the page After Saved");					
		
				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "All Modifiers in Modifier Print Check Box not Selected while Reopening the page After Saved");
				}
				
			
			
				//Close the Order & Item Summary Screen
				kpt.Close_Order_and_ItemSummary_Screen();
				
				//Open Customer Info Screen
				kpt.Open_Customer_Info_Screen();
				
				try
				{
				//Check whether the At Top of Check
				if(kpt.At_Bottom_of_Check_RadioButton_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "At Bottom of Check is Selected");
					
					//Select At the Bottom of Check button
					kpt.At_Top_of_Check_RadioButton().click();
				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "At Bottom of Check is not Selected");
				}
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Address Checkbox
				if(kpt.Address__CustomerInfo_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Address Check Box Selected while Reopening the page After Saved");					
		
				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Address Check Box not Selected while Reopening the page After Saved");
				}
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Email Checkbox
				if(kpt.Email_CustomerInfo_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Email Check Box Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Email Check Box not Selected while Reopening the page After Saved");
				}
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Phone Number Checkbox
				if(kpt.Phone_Number_CustomerInfo_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Phone Number Check Box Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Phone Number Check Box not Selected while Reopening the page After Saved");
				}
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Customer Notes Checkbox
				if(kpt.Customer_Notes_CustomerInfo_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Customer Notes Check Box Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Customer Notes Check Box not Selected while Reopening the page After Saved");
				}
				
				
				//Close Customer Info Screen
				kpt.Close_Customer_Info_Screen();
				
				//Open Driver Receipt Options Screen
				kpt.Open_Driver_ReceiptOptions_Screen();
				
				//Enable Driver Receipt 
//				kpt.Enable_DriverReceipt();
				
//				//Select No of Copies
//				kpt.Enter_No_ofCopies("100");
//				
//				//Check whether the No of Copies Error msg displays or not
//				if(kpt.No_ofCopiesErrorMsg().isDisplayed())
//				{
//					test.log(LogStatus.PASS, "The value must be in range 1 to 10 Displayed when Entering above 10");
//				}
//				else
//				{
//					test.log(LogStatus.FAIL, "The value must be in range 1 to 10 not Displayed when Entering above 10");
//				}
//				
//				
//				//Select No of Copies
//				kpt.Enter_No_ofCopies("0");
//				
//				//Check whether the No of Copies Error msg displays or not
//				if(kpt.No_ofCopiesErrorMsg().isDisplayed())
//				{
//					test.log(LogStatus.PASS, "The value must be in range 1 to 10 Displayed when Entering 0");
//				}
//				else
//				{
//					test.log(LogStatus.FAIL, "The value must be in range 1 to 10 not Displayed when Entering 0");
//				}
//				
//				//Select No of Copies
//				kpt.Enter_No_ofCopies("-2");
//				
//				//Check whether the No of Copies Error msg displays or not
//				if(kpt.No_ofCopiesErrorMsg().isDisplayed())
//				{
//					test.log(LogStatus.PASS, "The value must be in range 1 to 10 Displayed when Entering Negative values");
//				}
//				else
//				{
//					test.log(LogStatus.FAIL, "The value must be in range 1 to 10 not Displayed when Entering Negative values");
//				}
//				
			
				//No of Copies Before
				String No_ofCopyAft=kpt.No_ofCopies_InputBox().getAttribute("value");
				
				//Check whether the No of Copies value changed or not
				if(No_ofCopyAft.equalsIgnoreCase(No_ofCopyBef))
				{
					test.log(LogStatus.PASS, "No of Copies values not Changed after Reopening the page");
				}
				else
				{
					test.log(LogStatus.FAIL, "No of Copies values changed after Reopening the page");
				}
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Total Checkbox
				if(kpt.Total_DriverReceipt_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Total Check Box Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Total Check Box not Selected while Reopening the page After Saved");
				}
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Tip Checkbox
				if(kpt.Tip_DriverReceipt_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Tip Check Box Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Tip Check Box not Selected while Reopening the page After Saved");
				}
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Signature Checkbox
				if(kpt.Signature_DriverReceipt_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Signature Check Box Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Signature Check Box not Selected while Reopening the page After Saved");
				}
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Balance Due Checkbox
				if(kpt.Balance_Due_DriverReceipt_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Balance Due Check Box Selected while Reopening the page After Saved");					

				}
				}
				catch(Exception g)
				{
					test.log(LogStatus.FAIL, "Balance Due Check Box not Selected while Reopening the page After Saved");
				}
				
				
				
				//Close Driver Receipt Options Screen
				kpt.Close_Driver_ReceiptOptions_Screen();
				
				//Open Additional Details
				kpt.Open_Additional_Details_Screen();
				
				Thread.sleep(1000);
				try
				{
				//Check and Enable Cut Paper After Each print Checkbox
				if(kpt.CutPaper_After_EachPrint_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Cut Paper After Each print Check Box Selected while Reopening the page After Saved");					
			
				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Cut Paper After Each print Check Box not Selected while Reopening the page After Saved");
				}
				
				
				//Close Additional Details
				kpt.Close_Additional_Details_Screen();
				
				for(int i=1;i<=5;i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_UP);
				}
				
				Thread.sleep(2000);
				//Select Medium
				kpt.Click_Medium_FontSize();
				
				Thread.sleep(2000);
				//Select the Medium Font
				kpt.Select_Font_Style_Option();
				
				//Get the Font Style Before
				String Font_StyleBef=kpt.Font_Style_Option().getAttribute("value");
				
				Thread.sleep(2000);
				//Click the Update button
				cmp.Click_Update_ButtonTwo();
				
				Thread.sleep(2000);
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Kitchen Receipt Template Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Kitchen Receipt Template Saved Successfully (Medium Font Size)");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Kitchen Printer Template Save Failed (Medium Font Size)");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				

				Thread.sleep(3000);
				driver.navigate().refresh();
				
				Thread.sleep(8000);
				try
				{
				//Check whether the Medium Font Size Selected or not
				if(kpt.Medium_FontSize_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Medium Font Size not Changed after Reopening the page");
				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Medium Font Size Changed after Reopening the page");
			
					Thread.sleep(1000);
					kpt.Click_Medium_FontSize();
					
				}
//				
//				Thread.sleep(1000);
//				kpt.Click_Medium_FontSize();
				
				//Get the Name 
				String Font_StyleAft=kpt.Font_Style_Option().getAttribute("value");
				
				//Check whether the Font Style Changed or not
				if(Font_StyleAft.equalsIgnoreCase(Font_StyleBef))
				{
					test.log(LogStatus.PASS, "Font Style not Changed after Reopeing the Page");
				}
				else
				{
					test.log(LogStatus.FAIL, "Font Style Changed after Reopeing the page");
				}
				
				//Select the Font Style
				kpt.Click_Large_FontSize();
				
				//Click the Update button
				cmp.Click_Update_ButtonTwo();
				
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Kitchen Receipt Template Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Kitchen Receipt Template Saved Successfully (Large Font Size)");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Kitchen Printer Template Save Failed (Large Font Size)");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				Thread.sleep(3000);
				driver.navigate().refresh();
				
				Thread.sleep(8000);
				try
				{
				//Check whether the Medium Font Size Selected or not
				if(kpt.Large_FontSize_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Large Font Size not Changed after Reopening the page");
				
				
				}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Large Font Size Changed after Reopening the page");
				
					Thread.sleep(1000);
					kpt.Click_Large_FontSize();
				}
			
				
				//Select the Font Style
				kpt.Click_Small_FontSize();
				
				Thread.sleep(1000);
				//Open Store & Check Details
				kpt.Open_Store_CheckDetails_Screen();
				
				
				Thread.sleep(1000);
				try
				{
				//Check and Enable Service Type Checkbox
				if(kpt.Check_Number_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Check Number Box Selected while Reopening the page After Saved");					
		
					
					Thread.sleep(1000);
						if(kpt.Inline_Position_Check_Number_RadioButton_Selected().isDisplayed())
						{
							test.log(LogStatus.PASS, "Inline Position for Check Number Radio button is Selected");
						
							Thread.sleep(1000);
							kpt.Title_Position_Check_Number_RadioButton().click();
						}
						else
						{
							test.log(LogStatus.FAIL, "Inline Position for Check Number Radio button is not Selected");
						
						}
				
				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Check Number Check Box not Selected while Reopening the page After Saved");
				}
				
//				Thread.sleep(1000);
				try
				{
				//Check and Enable Service Type Checkbox
				if(kpt.ServiceType_CheckBox_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Service Type Check Box Selected while Reopening the page After Saved");					
		
					
					
						Thread.sleep(1000);
						if(kpt.Inline_Position_Service_Type_RadioButton_Selected().isDisplayed())
						{
							test.log(LogStatus.PASS, "Inline Position for Service Type Radio button is Selected");
						
							Thread.sleep(1000);
							kpt.Title_Position_Service_Type_RadioButton().click();
						}
						else
						{
							test.log(LogStatus.FAIL, "Inline Position for Service Type Radio button is not Selected");
	
						}
				
				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Service Type Check Box not Selected while Reopening the page After Saved");
				}
	
				Thread.sleep(1000);
				//Close Store & Check Details
				kpt.Close_Store_CheckDetails_Screen();
				
				
				
				Thread.sleep(1000);
				//Click the Update button
				cmp.Click_Update_ButtonTwo();
				
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Kitchen Receipt Template Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Kitchen Receipt Template Saved Successfully (Small Font Size)");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Kitchen Printer Template Save Failed (Small Font Size)");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				Thread.sleep(3000);
				driver.navigate().refresh();
				
				Thread.sleep(5000);
				
				try
				{
				//Check whether the Medium Font Size Selected or not
				if(kpt.Small_FontSize_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Small Font Size not Changed after Reopening the page");
				
				
				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Small Font Size Changed after Reopening the page");
			
					
				}
			
				Thread.sleep(2000);
				kpt.Click_Small_FontSize();
				
				
				Thread.sleep(1000);
				//Open Store & Check Details
				kpt.Open_Store_CheckDetails_Screen();
				
				
				Thread.sleep(1000);
				try
				{
				if(kpt.Title_Position_Check_Number_RadioButton_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Title Position for Check Number Radio button is Selected");
				
					
				}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Title Position for Check Number Radio button is not Selected");
				
				}
				
				Thread.sleep(1000);
				try
				{
				if(kpt.Title_Position_Service_Type_RadioButton_Selected().isDisplayed())
				{
					test.log(LogStatus.PASS, "Title Position for Service Type Radio button is Selected");
				
				
				}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Title Position for Service Type Radio button is not Selected");

				}
				

				Thread.sleep(1000);
				//Close Store & Check Details
				kpt.Close_Store_CheckDetails_Screen();
				
				if(cmp.Update_ButtonTwo().isEnabled())
				{
				Thread.sleep(1000);
				//Click the Update button
				cmp.Click_Update_ButtonTwo();
				
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Kitchen Receipt Template Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Kitchen Receipt Template Saved Successfully (Small Font Size)");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Kitchen Printer Template Save Failed (Small Font Size)");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				
	}

	}
