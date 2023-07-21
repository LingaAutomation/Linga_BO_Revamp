package com.Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;import static org.testng.Assert.expectThrows;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
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
import com.Pages.Label_TemplatePage;
import com.Test.LoginTest;
import com.Pages.LoginPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utility.ExtentManager;
import Utility.Utility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Settings_Label_Template 
{

	public WebDriver driver;
	
	
	ExtentReports rep = ExtentManager.getInstance();
	ExtentTest test = rep.startTest("Settings - Label Template");
	
	LoginPage lgpg; 
	
	Utility ut=new Utility();
	
	Common_XPaths cmp;
	LoginTest a=new LoginTest();
	Label_TemplatePage ltp;
	
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
		Open_Label_Printer_Page(driver);
		Save_Epson_Box_Label_Template_Settings(driver);
		Save_Zebra_Label_Template_Settings(driver);
		Save_Kitchen_Label_Template_Settings(driver);

	}
	
	@Test(priority = 3,enabled = false)
	public void Open_Label_Printer_Page(WebDriver driver) throws Exception
	{
		
		cmp=new Common_XPaths(driver, test);
		ltp=new Label_TemplatePage(driver, test);
		Thread.sleep(5000);
		//Load the Label Printer page
		driver.get(Utility.getProperty("baseURL")+"settings/"+"labelTemplate");

		Thread.sleep(5000);
		//Verify the Label Template page loaded or not
		if(ltp.Label_TemplateHeader().isDisplayed())
		{
			test.log(LogStatus.PASS, "Label Template Page Loaded Successfully");
			
			ut.PassedCaptureScreenshotAsBASE64(driver, test);
		}
		else
		{
			test.log(LogStatus.FAIL, "Label Template Page Loading Failed");
			
			ut.FailedCaptureScreenshotAsBASE64(driver, test);
		}
	}
	
	
	
	@Test(priority = 4,enabled = false)
	public void Save_Epson_Box_Label_Template_Settings(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
		ltp=new Label_TemplatePage(driver, test);
		Thread.sleep(2000);
	
		//Click the Epson Box Label Template
		ltp.Click_EpsonBox_LabelTemplate();
		
		
		//Select the Template
		ltp.Select_Templates();
		
		//Get the Selected Template 
		String Bef_Temp=ltp.Selected_TemplateName();
	
		//Enter the Width
		ltp.Enter_Width("5");
		
		//Verify whether the Min and Max Error Msg Displayed or not
		ltp.Verify_Width_ErrorMsg();
				
				//Enter the Width
				ltp.Enter_Height("6");
				
				//Verify whether the Min and Max Error Msg Displayed or not
				ltp.Verify_Height_ErrorMsg();
				
				if(cmp.Save_ButtonTwo().isEnabled())
				{
				//Click the Save button
				cmp.Click_Save_ButtonTwo();
				
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Select Valid Width and Height"))
				{
					test.log(LogStatus.PASS, "Please Select Valid Width and Height is Displayed");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Delivery Label Template Saved Successfully"))
				{
					test.log(LogStatus.FAIL, "Label Template Saved with Invalid Width or Height");
			
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Please Select Valid Width and Height is not Displayed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				else
				{
					test.log(LogStatus.INFO, "Save button not Enabled when Entering Invalid Width and Height");
				}
				
				//Enter the Width
				ltp.Enter_Width("4");
				
				//Get the Width
				String Width_Bef=ltp.Width_InputBox().getAttribute("value");
			
				
				//Enter the Width
				ltp.Enter_Height("3");
				
		
		//Get the Height
				String HeightBef=ltp.Height_InputBox().getAttribute("value");
				
				
				//Un select Enable Autocut
				ltp.UnSelect_Enable_Autocut_CheckBox();
				
				for(int i=1;i<=3;i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);
				}
				
				Thread.sleep(1000);
				//Click Font Options Down Right arrow
				ltp.Open_FontOptions_Screen();
				
				Thread.sleep(1000);
				//Select the Check & Date Font
				ltp.Select_Check_Date_Option();
				
				//Get the Check & Date
				String CheckDateFontBef=ltp.Check_And_Date_Option().getAttribute("value");
				
				Thread.sleep(1000);
				//Select the Font for Business Name
				ltp.Select_Business_Name_Option();
				
				//Get the Business Name
				String Busi_NameBef=ltp.Business_Name_Option().getAttribute("value");
				
				Thread.sleep(1000);
				//Select Menu Item Name Font
				ltp.Select_MenuItem_Name_Option();
				
				//Get the Menu Item Name
				String MenuItem_NameFontBef=ltp.Menu_ItemName_Option().getAttribute("value");
				
				Thread.sleep(1000);
				//Select Modifiers Font
				ltp.Select_Modifiers_Option();
				
				//Get the Modifiers
				String Modi_FontBef=ltp.Modifiers_Option().getAttribute("value");
				
				String CustomerInfo_FontBef = null;
				
				String CustomerAddress_Phone_FontBef=null;
				
				String DeliveryNotes_FontBef=null;
				
				if(ltp.Selected_TemplateName().equalsIgnoreCase("Template 1"))
				{
				
				Thread.sleep(2000);
				//Select Customer Info Font
				ltp.Select_CustomerInfo_EpsonBox_Option();
				
				//Get the Customer Info
				CustomerInfo_FontBef=ltp.CustomerInfo_EpsonBox().getAttribute("value");
				
				}
				else
				{
					Thread.sleep(2000);
					//This field is Not available & this option***
					
//					//Select Customer Address Phone Font
//					ltp.Select_Customer_Address_Phone_Option();
//					
//					//Get the Customer Info
//					CustomerAddress_Phone_FontBef=ltp.Customer_Address_Phone_Option().getAttribute("value");
//					
					
					Thread.sleep(2000);
					//Select Customer Info Font
					ltp.Select_Delivery_Notes_Option();
					
					//Get the Customer Info
					DeliveryNotes_FontBef=ltp.Delivery_Notes_Option().getAttribute("value");
					
				}
				
				Thread.sleep(2000);
				//Click the Save button
				cmp.Click_Save_ButtonTwo();
				 
				Thread.sleep(3000);
				//Check whether the Label Template Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Delivery Label Template Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Label Template Saved Successfully");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Label Template Save Failed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				Thread.sleep(2000);
				//Click the Zebra Template
				ltp.Click_Zebra_LabelTemplate();
				
				Thread.sleep(1000);
				//Click the Epson Box
				ltp.Click_EpsonBox_LabelTemplate();
				
				Thread.sleep(2000);
				//Navigate to Back
//				driver.navigate().back();
				driver.navigate().refresh();
				Thread.sleep(5000);
				//Navigate to Forward
//				driver.navigate().forward();
				
				Thread.sleep(2000);
				//Check whether the Enable Autocut Disabeld or not
				if(ltp.Enable_Autocut_CheckBox().isSelected())
				{
					test.log(LogStatus.FAIL, "Enable Autocut Check Box Enabled while Reopening the page After Saved");					
				}
				else
				{
					test.log(LogStatus.PASS, "Enable AutocutCheck Box not Enabled while Reopening the page After Saved");
				}
				
				//Select Enable Autocut
				ltp.Select_Enable_Autocut_CheckBox();
				
				//Click the Font Option Right Arrow
				ltp.Open_FontOptions_Screen();
				
				//Get the Selected Template 
				String After_Temp=ltp.Selected_TemplateName();
				
				//Check whether the Templated Updated or not
				if(Bef_Temp.equals(After_Temp))
				{
					test.log(LogStatus.PASS, "Template Not Changed After Reopen the Page");
				}
				else
				{
					test.log(LogStatus.FAIL, "Template Changed After Reopen the Page");
				}
			
			//Get the Width
						String Width_Aft=ltp.Width_InputBox().getAttribute("value");
						
						//Check whether the Width Updated or not
						if(Width_Bef.equals(Width_Aft))
						{
							test.log(LogStatus.PASS, "Width Not Changed After Reopen the Page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Width Changed After Reopen the Page");
						}
						
			//Get the Height
						String HeightAft=ltp.Height_InputBox().getAttribute("value");
						
						//Check whether the Templated Updated or not
						if(HeightBef.equals(HeightAft))
						{
							test.log(LogStatus.PASS, "Height Not Changed After Reopen the Page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Height Changed After Reopen the Page");
						}
						
						//Get the Check & Date
						String CheckDateFont_Aft=ltp.Check_And_Date_Option().getAttribute("value");
					
						//Check whether the Templated Updated or not
						if(CheckDateFontBef.equals(CheckDateFont_Aft))
						{
							test.log(LogStatus.PASS, "Check & Date Font Not Changed After Reopen the Page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Check & Date Font Changed After Reopen the Page");
						}
						
						//Get the Business Name
						String Busi_Name_Aft=ltp.Business_Name_Option().getAttribute("value");
					
						//Check whether the Templated Updated or not
						if(Busi_NameBef.equals(Busi_Name_Aft))
						{
							test.log(LogStatus.PASS, "Business Name Font Not Changed After Reopen the Page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Business Name Font Changed After Reopen the Page");
						}
						
						//Get the Menu Item Name
						String MenuItem_NameFont_Aft=ltp.Menu_ItemName_Option().getAttribute("value");
					
						//Check whether the Templated Updated or not
						if(MenuItem_NameFontBef.equals(MenuItem_NameFont_Aft))
						{
							test.log(LogStatus.PASS, "Menu Item Name Font Not Changed After Reopen the Page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Menu Item Name Font Changed After Reopen the Page");
						}
						
						//Get the Modifiers
						String Modi_Font_Aft=ltp.Modifiers_Option().getAttribute("value");
					
						//Check whether the Templated Updated or not
						if(Modi_FontBef.equals(Modi_Font_Aft))
						{
							test.log(LogStatus.PASS, "Modifiers Font Not Changed After Reopen the Page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Modifiers Font Changed After Reopen the Page");
						}
						
						
						
						
//						if(ltp.Selected_TemplateName().equalsIgnoreCase("Template 1"))
//						{
//							
//							//Get the Customer Info
//							String CustomerInfo_Font_Aft=ltp.CustomerInfo_EpsonBox().getAttribute("value");
//							
//							
//							
//							//Check whether the Templated Updated or not
//							if(CustomerInfo_FontBef.equals(CustomerInfo_Font_Aft))
//							{
//								test.log(LogStatus.PASS, "Customer Info Font Not Changed After Reopen the Page");
//							}
//							else
//							{
//								test.log(LogStatus.FAIL, "Customer Info Changed After Reopen the Page");
//							}
//						}
//						else
//						{
//							
//							//Get the Check & Date
//							String CustomerAddress_Phone_FontAft=ltp.Customer_Address_Phone_Option().getAttribute("value");
//					
//							//Get the Check & Date
//							String DeliveryNotes_FontAft=ltp.Delivery_Notes_Option().getAttribute("value");
//					
//							
//		
//							//Check whether the Templated Updated or not
//							if(CustomerAddress_Phone_FontBef.equals(CustomerAddress_Phone_FontAft))
//							{
//								test.log(LogStatus.PASS, "Customer Address & Phone Font Not Changed After Reopen the Page");
//							}
//							else
//							{
//								test.log(LogStatus.FAIL, "Customer Address & Phone Changed After Reopen the Page");
//							}
//							
//							
//							
//							//Check whether the Templated Updated or not
//							if(DeliveryNotes_FontBef.equals(DeliveryNotes_FontAft))
//							{
//								test.log(LogStatus.PASS, "Delivery Notes Font Not Changed After Reopen the Page");
//							}
//							else
//							{
//								test.log(LogStatus.FAIL, "Delivery Notes Info Changed After Reopen the Page");
//							}
//		
//						}
		
//						if(cmp.Save_ButtonTwo().isEnabled())
//						{
//	
//						Thread.sleep(1000);
//						//Click the Save button
//						cmp.Click_Save_ButtonTwo();
//						
//						Thread.sleep(3000);
//						//Verify whether the Label Template Saved or not
//						if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Delivery Label Template Saved Successfully"))
//						{
//							test.log(LogStatus.PASS, "Label Template Saved Successfully for Epson Box Label Template");
//							
//							ut.PassedCaptureScreenshotAsBASE64(driver, test);
//						}
//						else
//						{
//							test.log(LogStatus.FAIL, "Label Template Save Failed for Epson Box Label Template");
//							
//							ut.FailedCaptureScreenshotAsBASE64(driver, test);
//						}
//						
//						}
//						else
//						{
//							
//						}
	}
		
	
	
	@Test(priority = 5,enabled = false)
	public void Save_Zebra_Label_Template_Settings(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);
	
		cmp=new Common_XPaths(driver, test);
		ltp=new Label_TemplatePage(driver, test);
		Thread.sleep(2000);
	
		//Click the Zebra Label Template
		ltp.Click_Zebra_LabelTemplate();
		
		
		//Select the Template
		ltp.Select_Templates();
		
		//Get the Selected Template 
		String Bef_Temp=ltp.Selected_TemplateName();
	
		//Enter the Width
		ltp.Enter_Width("5");
		
		//Enter the Width
		ltp.Enter_Height("6");
		
		if(Bef_Temp == "Template 1") {
			//Verify whether the Min and Max Error Msg Displayed or not
			ltp.Verify_Width_ErrorMsg();

			//Verify whether the Min and Max Error Msg Displayed or not
			ltp.Verify_Height_ErrorMsg();
		}else {
			//Verify whether the Min and Max Error Msg Displayed or not
			ltp.Verify_Width_ErrorMsg_Template2();

			//Verify whether the Min and Max Error Msg Displayed or not
			ltp.Verify_Height_ErrorMsg_Template2();
		}
		

				
				if(cmp.Save_ButtonTwo().isEnabled())
				{
					//Click the Save button
					cmp.Click_Save_ButtonTwo();
					
					if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Select Valid Width and Height"))
					{
						test.log(LogStatus.PASS, "Please Select Valid Width and Height is Displayed");
						
						ut.PassedCaptureScreenshotAsBASE64(driver, test);
					}
					else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Delivery Label Template Saved Successfully"))
					{
						test.log(LogStatus.FAIL, "Label Template Saved with Invalid Width or Height");
				
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
					else
					{
						test.log(LogStatus.FAIL, "Please Select Valid Width and Height is not Displayed");
						
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
					}
				}
				else
				{
					test.log(LogStatus.INFO, "Save button not Enabled when Entering Invalid Height and Width");
				}
				
				//Enter the Width
				ltp.Enter_Width("4");
				
				//Get the Width
				String Width_Bef=ltp.Width_InputBox().getAttribute("value");
			
				
				//Enter the Width
				ltp.Enter_Height("3");
				
		
		//Get the Height
				String HeightBef=ltp.Height_InputBox().getAttribute("value");
				
				
				Thread.sleep(2000);
				//Select Enable Autocut
				ltp.Select_Enable_Autocut_CheckBox();
				try
				{
					//Check whether the Enable Autocut Disabeld or not
					if(ltp.Enable_Autocut_CheckBox_SLD().isDisplayed())
					{
						test.log(LogStatus.PASS, "Enable Autocut Check Box Enabled while Reopening the page After Saved");					
					}
				}
				catch (Exception e) 
				{
					test.log(LogStatus.FAIL, "Enable AutocutCheck Box not Enabled while Reopening the page After Saved");
				}
				
				
				for(int i=1;i<=3;i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);
				}
				
				Thread.sleep(1000);
				//Click Font Options Down Right arrow
				ltp.Open_CheckDetails_Screen();
				
				//Thread.sleep(1000);
				//Select the Business Name Font
				try
				{
					if(ltp.Business_Name_CheckDetails_CheckBox_SLD().isDisplayed())
					{
						ltp.Business_Name_CheckDetails_CheckBox().click();
					}
				}
				catch(Exception l)
				{}
				
				//Thread.sleep(1000);
				try
				{
					//Select the Server Name Font
					if(ltp.Server_Name_CheckDetails_CheckBox_SLD().isDisplayed())
					{
						ltp.Server_Name_CheckDetails_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				//Thread.sleep(1000);
				try
				{
					//Select the Check Number Font
					if(ltp.Check_Number_CheckDetails_CheckBox_SLD().isDisplayed())
					{
						ltp.Check_Number_CheckDetails_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				
				//Thread.sleep(1000);
				try
				{
					//Select the Order Type Font
					if(ltp.Order_Type_CheckDetails_CheckBox_SLD().isDisplayed())
					{
						ltp.Order_Type_CheckDetails_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				
				//Thread.sleep(1000);
				try
				{
					//Select the Date & Time Font
					if(ltp.Date_Time_CheckDetails_CheckBox_SLD().isDisplayed())
					{
						ltp.Date_Time_CheckDetails_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				
				//Thread.sleep(1000);
				try
				{
					//Select the Pay Status Font
					if(ltp.PayStatus_CheckDetails_CheckBox_SLD().isDisplayed())
					{
						ltp.PayStatus_CheckDetails_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				try
				{
					//Thread.sleep(1000);
					//Select the Menu Item Number Font
					if(ltp.MenuItem_Number_CheckDetails_CheckBox_SLD().isDisplayed())
					{
						ltp.MenuItem_Number_CheckDetails_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				//Select Business Name
				ltp.Select_Business_Name_Option();
				
				//Get the Business Name
				String Busi_NameFontBef=ltp.Business_Name_Option().getAttribute("value");
				
				//Thread.sleep(1000);
				//Select the Font for Check Details
				ltp.Select_CheckDetails_Font_Option();
				
				//Get the Check Details Font Name
				String Check_DetailsFontBef=ltp.CheckDetails_Font_Option().getAttribute("value");
				
				//Thread.sleep(1000);
				//Select Order Type & Pay Status
				ltp.Select_OrderType_PayStatus_Font_Option();
				
				//Get the Order Type & Pay Status in Check Details
				String OrderType_PayStatusFontBef=ltp.OrderType_PayStatus_Font_Option().getAttribute("value");
				
				//Thread.sleep(1000);
				try
				{
					//Select the Check Details Check box in Check Details screen
					if(ltp.CheckDetails_CheckDetails_CheckBox_SLD().isDisplayed())
					{
						ltp.CheckDetails_CheckDetails_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				//Thread.sleep(1000);
				try
				{
					//Select the Order Type & Pay Status
					if(ltp.OrderType_PayStatus_CheckDetails_CheckBox_SLD().isDisplayed())
					{
						ltp.OrderType_PayStatus_CheckDetails_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				Thread.sleep(2000);
				//Close Check Details screen
				ltp.Close_CheckDetails_Screen();
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);
				
				Thread.sleep(2000);
				//Open Menu Info Screen
				ltp.Open_MenuItem_Info_Screen();
				
				Thread.sleep(2000);
				try
				{
					//Select the Menu Item Name Font
					if(ltp.MenuItem_Name_MenuItemInfo_CheckBox_SLD().isDisplayed())
					{
						ltp.MenuItem_Name_MenuItemInfo_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				
				//Thread.sleep(1000);
				try
				{
					//Select the Modifiers Font
					if(ltp.Modifiers_MenuItemInfo_CheckBox_SLD().isDisplayed())
					{
						ltp.Modifiers_MenuItemInfo_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				
				//Thread.sleep(1000);
				try
				{
					//Select the Menu Item Serving Size Font
					if(ltp.MenuItem_ServingSize_MenuItemInfo_CheckBox_SLD().isDisplayed())
					{
						ltp.MenuItem_ServingSize_MenuItemInfo_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				
				//Thread.sleep(1000);
				try
				{
					//Select the Item Notes Font
					if(ltp.ItemNotes_MenuItemInfo_CheckBox_SLD().isDisplayed())
					{
						ltp.ItemNotes_MenuItemInfo_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				//Select Item Name & Serving Size 
				ltp.Select_ItemName_ServingSize_MenuItemInfo_Font_Option();
				
				//Get the Business Name
				String ItemName_ServingSize_MenuInfoFontBef=ltp.ItemName_ServingSize_MenuItemInfo_Font_Option().getAttribute("value");
				
				//Select Item Name & Serving Size 
				ltp.Select_Modifiers_Notes_MenuItemInfo_Font_Option();
				
				//Get the Business Name
				String Modifiers_Notes_MenuInfoFontBef=ltp.ItemName_ServingSize_MenuItemInfo_Font_Option().getAttribute("value");
				
				Thread.sleep(1000);
				try
				{
					//Select the Bottom Divider Font
					if(ltp.BottomDivider_MenuItemInfo_CheckBox_SLD().isDisplayed())
					{
						ltp.BottomDivider_MenuItemInfo_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				Thread.sleep(2000);
				//Close Menu Info
				ltp.Close_MenuItem_Info_Screen();
				
				Thread.sleep(2000);
				//Open Customer Info screen
				ltp.Open_Customer_Info_Screen();
				
				Thread.sleep(2000);
				try
				{
					//Select the Customer Name Font
					if(ltp.CustomerName_CustomerInfo_CheckBox_SLD().isDisplayed())
					{
						ltp.CustomerName_CustomerInfo_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				
				//Thread.sleep(1000);
				try
				{
					//Select the Customer Address Font
					if(ltp.CustomerAddress_CustomerInfo_CheckBox_SLD().isDisplayed())
					{
						ltp.CustomerAddress_CustomerInfo_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				//Thread.sleep(1000);
				try
				{
					//Select the Delivery Notes Font
					if(ltp.DeliveryNotes_CustomerInfo_CheckBox_SLD().isDisplayed())
					{
						ltp.DeliveryNotes_CustomerInfo_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				//Thread.sleep(1000);
				try
				{
					//Select the Phone Number Font
					if(ltp.PhoneNumber_CustomerInfo_CheckBox_SLD().isDisplayed())
					{
						ltp.PhoneNumber_CustomerInfo_CheckBox().click();
					}
				}
				catch(Exception l) {}
					
				
				//Select Customer Name
				ltp.Select_CustomerName_CustomerInfo_Font_Option();
				
				//Get the Business Name
				String CustomerName_CustomerInfoFontBef=ltp.CustomerName_CustomerInfo_Font_Option().getAttribute("value");
				
				
				//Select Customer Details
				ltp.Select_CustomerDetails_CustomerInfo_Font_Option();
				
				//Get the Business Name
				String CustomerDetails_CustomerInfoFontBef=ltp.CustomerDetails_CustomerInfo_Font_Option().getAttribute("value");
				
				
				//Thread.sleep(1000);
				try
				{
					//Select the Phone Number Font
					if(ltp.RightDivider_CustomerInfo_CheckBox_SLD().isDisplayed())
					{
						ltp.RightDivider_CustomerInfo_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				Thread.sleep(2000);
				//Close Customer Info
				ltp.Close_Customer_Info_Screen();
				
				Thread.sleep(2000);
				//Open Order Summary
				ltp.Open_Order_Summary_Screen();
				
				
				Thread.sleep(1000);
				try
				{
					//Select the Sub Total in Order Summary
					if(ltp.SubTotal_OrderSummary_CheckBox_SLD().isDisplayed())
					{
						ltp.SubTotal_OrderSummary_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				
				//Thread.sleep(1000);
				try
				{
					//Select the Tip in Order Summary
					if(ltp.Tip_OrderSummary_CheckBox_SLD().isDisplayed())
					{
						ltp.Tip_OrderSummary_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				
				//Thread.sleep(1000);
				try
				{
					//Select the Discounts in Order Summary
					if(ltp.Discounts_OrderSummary_CheckBox_SLD().isDisplayed())
					{
						ltp.Discounts_OrderSummary_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				
				//Thread.sleep(1000);
				try
				{
					//Select the Total in Order Summary
					if(ltp.Total_OrderSummary_CheckBox_SLD().isDisplayed())
					{
						ltp.Total_OrderSummary_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				
				//Thread.sleep(1000);
				try
				{
					//Select the Delivery Fee in Order Summary
					if(ltp.DeliveryFee_OrderSummary_CheckBox_SLD().isDisplayed())
					{
						ltp.DeliveryFee_OrderSummary_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				
				//Thread.sleep(1000);
				try
				{
					//Select the Balance Due in Order Summary
					if(ltp.BalanceDue_OrderSummary_CheckBox_SLD().isDisplayed())
					{
						ltp.BalanceDue_OrderSummary_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				
				//Thread.sleep(1000);
				try
				{
					//Select the Tax in Order Summary
					if(ltp.Tax_OrderSummary_CheckBox_SLD().isDisplayed())
					{
						ltp.Tax_OrderSummary_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				
				Thread.sleep(1000);
				//Select Order Summary Font
				ltp.Select_OrderSummary_OrderSummary_Font_Option();
				
				//Get the Order Summary Font
				String OrderSummary_FontBef=ltp.OrderSummary_OrderSummary_Font_Option().getAttribute("value");
				
				
				Thread.sleep(1000);
				//Select Balance Due Font
				ltp.Select_BalanceDue_OrderSummary_Font_Option();
				
				//Get the Modifiers
				String BalanceDue_FontBef=ltp.BalanceDue_OrderSummary_Font_Option().getAttribute("value");
				
				Thread.sleep(2000);
				//Close Order Summary screen
				ltp.Close_Order_Summary_Screen();
				
				
				Thread.sleep(2000);
				//Click the Save button
				cmp.Click_Save_ButtonTwo();
				
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Zebra Label Template Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Label Template Saved Successfully for Zebra Label Template (Selecting Font & Disable All Check)");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Label Template Save Failed for Zebra Label Template (Selecting Font & Disable All Check)");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				Thread.sleep(1000);
				//Click the Epson Box
				ltp.Click_EpsonBox_LabelTemplate();
				
				Thread.sleep(1000);
				//Click the Zebra Template
				ltp.Click_Zebra_LabelTemplate();
				
				Thread.sleep(2000);
				//Navigate to Back
//				driver.navigate().back();
//				driver.navigate().refresh();
//				Thread.sleep(3000);
				//Navigate to Forward
//				driver.navigate().forward();
				
				//Click the Zebra Template
//				ltp.Click_Zebra_LabelTemplate();
				
				
				Thread.sleep(2000);
				try
				{
					//Check whether the Enable Autocut Disabeld or not
					if(ltp.Enable_Autocut_CheckBox_SLD().isDisplayed())
					{
						test.log(LogStatus.PASS, "Enable Autocut Check Box Selected while Reopening the page After Saved");					
					}
				}
				catch (Exception e)
				{
					test.log(LogStatus.FAIL, "Enable AutocutCheck Box not Selected while Reopening the page After Saved");
				}
				
				//Select Enable Autocut
				ltp.Select_Enable_Autocut_CheckBox();
				
				Thread.sleep(2000);
				//Click the Check Details
				ltp.Open_CheckDetails_Screen();
				
				Thread.sleep(2000);
				//Get the Selected Template 
				String After_Temp=ltp.Selected_TemplateName();
				
				//Check whether the Templated Updated or not
				if(Bef_Temp.equals(After_Temp))
				{
					test.log(LogStatus.PASS, "Template Not Changed After Reopen the Page");
				}
				else
				{
					test.log(LogStatus.FAIL, "Template Changed After Reopen the Page");
				}
			
				//Get the Width
						String Width_Aft=ltp.Width_InputBox().getAttribute("value");
						
						//Check whether the Width Updated or not
						if(Width_Bef.equals(Width_Aft))
						{
							test.log(LogStatus.PASS, "Width Not Changed (Zebra Template) After Reopen the Page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Width Changed (Zebra Template) After Reopen the Page");
						}
						
						//Get the Height
						String HeightAft=ltp.Height_InputBox().getAttribute("value");
						
						//Check whether the Templated Updated or not
						if(HeightBef.equals(HeightAft))
						{
							test.log(LogStatus.PASS, "Height Not Changed (Zebra Template) After Reopen the Page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Height Changed (Zebra Template) After Reopen the Page");
						}
						
						
						
						
						try
						{
							//Select the Business Name Font
							if(ltp.Business_Name_CheckDetails_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Business Name Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Business Name
								ltp.Business_Name_CheckDetails_CheckBox().click();
							}
						}
						catch(Exception p)
						{

							test.log(LogStatus.FAIL, "Business Name Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						
						}
						
						try
						{
							//Select the Server Name Font
							if(ltp.Server_Name_CheckDetails_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Server Name Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Server Name
								ltp.Server_Name_CheckDetails_CheckBox().click();
								
							
							}
						}
						catch(Exception k)
						{

							test.log(LogStatus.FAIL, "Server Name Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Check Number Font
							if(ltp.Check_Number_CheckDetails_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Check Number Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Check Number
								ltp.Check_Number_CheckDetails_CheckBox().click(); 
								
							
							}
						}
						catch (Exception e) 
						{
							test.log(LogStatus.FAIL, "Check Number Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}

						try
						{
							//Select the Order Type Font
							if(ltp.Order_Type_CheckDetails_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Order Type Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Order Type
								ltp.Order_Type_CheckDetails_CheckBox().click();
								
							
							}
						}
						catch (Exception e) 
						{
							test.log(LogStatus.FAIL, "Order Type Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Date & Time Font
							if(ltp.Date_Time_CheckDetails_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Date & Time Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Date & Time
								ltp.Date_Time_CheckDetails_CheckBox().click();
							}
						}
						catch (Exception e) 
						{

							test.log(LogStatus.FAIL, "Date & Time Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						
						}
						
						try
						{
							//Select the Pay Status Font
							if(ltp.PayStatus_CheckDetails_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Pay Status Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Pay Status
								ltp.PayStatus_CheckDetails_CheckBox().click();
								
							}
						}
						catch (Exception e) 
						{
							test.log(LogStatus.FAIL, "Pay Status Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						
						}
						
						try
						{
							//Select the Menu Item Number Font
							if(ltp.MenuItem_Number_CheckDetails_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Menu Item Number Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Menu Item Number
								ltp.MenuItem_Number_CheckDetails_CheckBox().click();
							
							}
						}
						catch (Exception e)
						{

							test.log(LogStatus.FAIL, "Menu Item Number Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}

						
						//Get the Business Name
						String Busi_NameFontAft=ltp.Business_Name_Option().getAttribute("value");


						//Check whether the Business Name Updated or not
						if(Busi_NameFontBef.equals(Busi_NameFontAft))
						{
							test.log(LogStatus.PASS, "Business Name Font in Zebra Template Not Changed After Reopen the Page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Business Name Font in Zebra Template Changed After Reopen the Page");
						}
			
						//Get the Check Details Font Name
						String Check_DetailsFontAft=ltp.CheckDetails_Font_Option().getAttribute("value");
						
						//Check whether the Check Details font Updated or not
						if(Check_DetailsFontBef.equals(Check_DetailsFontAft))
						{
							test.log(LogStatus.PASS, "Check Details Font in Zebra Template Not Changed After Reopen the Page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Check Details Font in Zebra Template Changed After Reopen the Page");
						}
			
			
						//Get the Order Type & Pay Status in Check Details
						String OrderType_PayStatusFontAft=ltp.OrderType_PayStatus_Font_Option().getAttribute("value");
					
						//Check whether the Order Type & Pay Status font Updated or not
						if(OrderType_PayStatusFontBef.equals(OrderType_PayStatusFontAft))
						{
							test.log(LogStatus.PASS, "Order Type & Pay Status Font in Zebra Template Not Changed After Reopen the Page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Order Type & Pay Status Font in Zebra Template Changed After Reopen the Page");
						}
			
						try
						{
							//Select the Check Details Check box in Check Details screen
							if(ltp.CheckDetails_CheckDetails_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Check Details Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Check Details
								ltp.CheckDetails_CheckDetails_CheckBox().click();
								
							}
						}
						catch (Exception e) 
						{
							test.log(LogStatus.FAIL, "Check Details Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Order Type & Pay Status
							if(ltp.OrderType_PayStatus_CheckDetails_CheckBox_SLD1().isDisplayed())
							{

								test.log(LogStatus.PASS, "Order Type & Pay Status Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Order Type & Pay Status

								ltp.OrderType_PayStatus_CheckDetails_CheckBox().click();
							}
						}
						catch(Exception l)
						{

							test.log(LogStatus.FAIL, "Order Type & Pay Status Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						Thread.sleep(2000);
						//Close the Close Check Details
						ltp.Close_CheckDetails_Screen();
						
						Thread.sleep(2000);
						//Open the Menu Info
						ltp.Open_MenuItem_Info_Screen();
						
						try
						{
									//Select the Menu Item Name Font
									if(ltp.MenuItem_Name_MenuItemInfo_CheckBox_SLD1().isDisplayed())
									{
										test.log(LogStatus.PASS, "Menu Item Name Check Box not Selected while Reopening the page After Saved");					
										
										//Enable Menu Item Name
										ltp.MenuItem_Name_MenuItemInfo_CheckBox().click();
										
									}
						}
						catch (Exception e) 
						{
							test.log(LogStatus.FAIL, "Menu Item Name Check Box Selected while Reopening the page After Saved");					
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
									
									try
									{
										//Select the Modifiers Font
										if(ltp.Modifiers_MenuItemInfo_CheckBox_SLD1().isDisplayed())
										{
											test.log(LogStatus.PASS, "Modifiers Check Box not Selected while Reopening the page After Saved");					
											
											
											//Enable Modifiers
											ltp.Modifiers_MenuItemInfo_CheckBox().click();
											
										}
									}
									catch (Exception e)
									{
										test.log(LogStatus.FAIL, "Modifiers Check Box Selected while Reopening the page After Saved");
										ut.FailedCaptureScreenshotAsBASE64(driver, test);
									}
						
									try
									{
										//Select the Menu Item Serving Size Font
										if(ltp.MenuItem_ServingSize_MenuItemInfo_CheckBox_SLD1().isDisplayed())
										{
											test.log(LogStatus.PASS, "Menu Item Serving Size Check Box not Selected while Reopening the page After Saved");					
											
											//Enable Menu Item Serving Size
												ltp.MenuItem_ServingSize_MenuItemInfo_CheckBox().click();
										
										}
									}
									catch(Exception l)
									{
										test.log(LogStatus.FAIL, "Menu Item Serving Size Check Box Selected while Reopening the page After Saved");
										ut.FailedCaptureScreenshotAsBASE64(driver, test);
									}
									
									try
									{
										//Select the Item Notes Font
										if(ltp.ItemNotes_MenuItemInfo_CheckBox_SLD1().isDisplayed())
										{
											test.log(LogStatus.PASS, "Item Notes Check Box not Selected while Reopening the page After Saved");					
											
											//Enable Item Notes
												ltp.ItemNotes_MenuItemInfo_CheckBox().click();
											
										}
									}
									catch(Exception l)
									{
										test.log(LogStatus.FAIL, "Item Notes Check Box Selected while Reopening the page After Saved");
										ut.FailedCaptureScreenshotAsBASE64(driver, test);
									}
						
						//Get the Business Name
						String ItemName_ServingSize_MenuInfoFontAft=ltp.ItemName_ServingSize_MenuItemInfo_Font_Option().getAttribute("value");
					
						
						//Check whether the Item Name & Serving Size font Updated or not
						if(ItemName_ServingSize_MenuInfoFontBef.equals(ItemName_ServingSize_MenuInfoFontAft))
						{
							test.log(LogStatus.PASS, "Item Name & Serving Size Font in Zebra Template Not Changed After Reopen the Page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Item Name & Serving Size Font in Zebra Template Changed After Reopen the Page");
						}
						
						
						//Get the Business Name
						String Modifiers_Notes_MenuInfoFontAft=ltp.ItemName_ServingSize_MenuItemInfo_Font_Option().getAttribute("value");
					
						//Check whether the Modifiers & Notes font Updated or not
						if(Modifiers_Notes_MenuInfoFontBef.equals(Modifiers_Notes_MenuInfoFontAft))
						{
							test.log(LogStatus.PASS, "Modifiers & Notes Font in Zebra Template Not Changed After Reopen the Page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Modifiers & Notes Font in Zebra Template Changed After Reopen the Page");
						}
						
						try
						{
							//Select the Bottom Divider Font
							if(ltp.BottomDivider_MenuItemInfo_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Bottom Divider Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Botton Divider
									ltp.BottomDivider_MenuItemInfo_CheckBox().click();
								
							}
						}
						catch(Exception l)
						{
							test.log(LogStatus.FAIL, "Bottom Divider Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						Thread.sleep(2000);
						//Close the Menu Info
						ltp.Close_MenuItem_Info_Screen();
						
						Thread.sleep(2000);
						//Open Customer Info
						ltp.Open_Customer_Info_Screen();
						
						try
						{
							//Select the Customer Name
							if(ltp.CustomerName_CustomerInfo_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Customer Name Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Customer Name
								ltp.CustomerName_CustomerInfo_CheckBox().click();	
								
							}
						}
						catch(Exception l)
						{
							test.log(LogStatus.FAIL, "Customer Name Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
							
						try
						{
							//Select the Customer Address Font
							if(ltp.CustomerAddress_CustomerInfo_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Customer Address Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Customer Address
									ltp.CustomerAddress_CustomerInfo_CheckBox().click();
							
							}
						}
						catch(Exception l)
						{
							test.log(LogStatus.FAIL, "Customer Address Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
							
						try
						{
							//Select the Delivery Notes Font
							if(ltp.DeliveryNotes_CustomerInfo_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Delivery Notes Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Delivery Notes
									ltp.DeliveryNotes_CustomerInfo_CheckBox().click();
								
							}
						}
						catch(Exception k)
						{
							test.log(LogStatus.FAIL, "Delivery Notes Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
							
						try
						{
							//Select the Phone Number Font
							if(ltp.PhoneNumber_CustomerInfo_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Phone Number Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Phone Number
									ltp.PhoneNumber_CustomerInfo_CheckBox().click();
								
							
							}
						}
						catch(Exception l)
						{
							test.log(LogStatus.FAIL, "Phone Number Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						
						//Get the Business Name
						String CustomerName_CustomerInfoFontAft=ltp.CustomerName_CustomerInfo_Font_Option().getAttribute("value");
						
						//Check whether the Customer Name font Updated or not
						if(CustomerName_CustomerInfoFontBef.equals(CustomerName_CustomerInfoFontAft))
						{
							test.log(LogStatus.PASS, "Customer Name Font in Zebra Template Not Changed After Reopen the Page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Customer Name Font in Zebra Template Changed After Reopen the Page");
						}

						//Get the Business Name
						String CustomerDetails_CustomerInfoFontAft=ltp.CustomerDetails_CustomerInfo_Font_Option().getAttribute("value");
						
						//Check whether the Customer Details font Updated or not
						if(CustomerDetails_CustomerInfoFontBef.equals(CustomerDetails_CustomerInfoFontAft))
						{
							test.log(LogStatus.PASS, "Customer Details Font in Zebra Template Not Changed After Reopen the Page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Customer Details Font in Zebra Template Changed After Reopen the Page");
						}

						try
						{
									//Select the Phone Number Font
									if(ltp.RightDivider_CustomerInfo_CheckBox_SLD1().isDisplayed())
									{
										test.log(LogStatus.PASS, "Right Divider Check Box not Selected while Reopening the page After Saved");					
										
										//Enable Right Divider
										ltp.RightDivider_CustomerInfo_CheckBox().click();

									}
						}
						catch(Exception p)
						{
									
							test.log(LogStatus.FAIL, "Right Divider Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);		
						}
						
						Thread.sleep(2000);
						//Close Customer Info screen
						ltp.Close_Customer_Info_Screen();
						
						Thread.sleep(2000);
						//Open the Order Summary screen
						ltp.Open_Order_Summary_Screen();
						
						Thread.sleep(1000);
						try
						{
							//Select the Sub Total in Order Summary
							if(ltp.SubTotal_OrderSummary_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Sub Total Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Sub Total
									ltp.SubTotal_OrderSummary_CheckBox().click();
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Sub Total Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						
						try
						{
							//Select the Tip in Order Summary
							if(ltp.Tip_OrderSummary_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Tip Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Tip
									ltp.Tip_OrderSummary_CheckBox().click();
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Tip Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						
						try
						{
							//Select the Discounts in Order Summary
							if(ltp.Discounts_OrderSummary_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Discounts Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Discounts
									ltp.Discounts_OrderSummary_CheckBox().click();
								
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Discounts Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
							
						}
						
						
						try
						{
							//Select the Total in Order Summary
							if(ltp.Total_OrderSummary_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Total Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Total
								ltp.Total_OrderSummary_CheckBox().click();
							
							}
						}
						catch(Exception l)
						{
							test.log(LogStatus.FAIL, "Total Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Delivery Fee in Order Summary
							if(ltp.DeliveryFee_OrderSummary_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Delivery Fee Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Delivery Fee
									ltp.DeliveryFee_OrderSummary_CheckBox().click();
							}
						}
						catch (Exception e)
						{

							test.log(LogStatus.FAIL, "Delivery Fee Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Balance Due in Order Summary
							if(ltp.BalanceDue_OrderSummary_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Balance Due Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Balance Due
									ltp.BalanceDue_OrderSummary_CheckBox().click();
							}
						}
						catch(Exception l)
						{
							test.log(LogStatus.FAIL, "Balance Due Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Tax in Order Summary
							if(ltp.Tax_OrderSummary_CheckBox_SLD1().isDisplayed())
							{
								test.log(LogStatus.PASS, "Tax Check Box not Selected while Reopening the page After Saved");					
								
								//Enable Tax
									ltp.Tax_OrderSummary_CheckBox().click();
								
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Tax Check Box Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}


						//Get the Order Summary Font
						String OrderSummary_FontAft=ltp.OrderSummary_OrderSummary_Font_Option().getAttribute("value");
						
						//Check whether the Order Summary font Updated or not
						if(OrderSummary_FontBef.equals(OrderSummary_FontAft))
						{
							test.log(LogStatus.PASS, "Order Summary Font in Zebra Template Not Changed After Reopen the Page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Order Summary Font in Zebra Template Changed After Reopen the Page");
						}
							
						//Get the Modifiers
						String BalanceDue_FontAft=ltp.BalanceDue_OrderSummary_Font_Option().getAttribute("value");
						
						//Check whether the Balance Due font Updated or not
						if(BalanceDue_FontBef.equals(BalanceDue_FontAft))
						{
							test.log(LogStatus.PASS, "Balance Due Font in Zebra Template Not Changed After Reopen the Page");
						}
						else
						{
							test.log(LogStatus.FAIL, "Balance Due Font in Zebra Template Changed After Reopen the Page");
						}
						
						Thread.sleep(2000);
						//Close the Order Summary screen
						ltp.Close_Order_Summary_Screen();
						
						
						
						
						Thread.sleep(2000);
						//Click the Save button
						cmp.Click_Save_ButtonTwo();
						
						Thread.sleep(2000);
						//Verify whether the Label Template Saved or not
						if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Zebra Label Template Saved Successfully"))
						{
							test.log(LogStatus.PASS, "Label Template Saved Successfully for Zebra Label Template (Enable All Checkbox)");
							
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
						}
						else
						{
							test.log(LogStatus.FAIL, "Label Template Save Failed for Zebra Label Template (Enable All Checkbox)");
							
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						Thread.sleep(2000);
						//driver.navigate().refresh();
						
						Thread.sleep(5000);
						
						
						
						Thread.sleep(2000);
						//Open Check Details
						ltp.Open_CheckDetails_Screen();
						
						Thread.sleep(1000);
						try
						{
							//Select the Business Name Font
							if(ltp.Business_Name_CheckDetails_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Business Name Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception l)
						{
							test.log(LogStatus.FAIL, "Business Name Check Box not Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
		
						try
						{
							//Select the Server Name Font
							if(ltp.Server_Name_CheckDetails_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Server Name Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Server Name Check Box not Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Check Number Font
							if(ltp.Check_Number_CheckDetails_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Check Number Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception l)
						{
							test.log(LogStatus.FAIL, "Check Number Check Box not Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Order Type Font
							if(ltp.Order_Type_CheckDetails_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Order Type Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception l)
						{
							test.log(LogStatus.FAIL, "Order Type Check Box not Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Date & Time Font
							if(ltp.Date_Time_CheckDetails_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Date & Time Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception e)
						{
							test.log(LogStatus.FAIL, "Date & Time Check Box not Selected while Reopening the page After Saved");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Pay Status Font
							if(ltp.PayStatus_CheckDetails_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Pay Status Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Pay Status Check Box not Selected while Reopening the page After Saved");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Menu Item Number Font
							if(ltp.MenuItem_Number_CheckDetails_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Menu Item Number Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Menu Item Number Check Box not Selected while Reopening the page After Saved");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}

						try
						{
							//Select the Check Details Check box in Check Details screen
							if(ltp.CheckDetails_CheckDetails_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Check Details Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Check Details Check Box not Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Order Type & Pay Status
							if(ltp.OrderType_PayStatus_CheckDetails_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Order Type & Pay Status Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Order Type & Pay Status Check Box not Selected while Reopening the page After Saved");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						Thread.sleep(2000);
						//Close the Close Check Details
						ltp.Close_CheckDetails_Screen();
						
						Thread.sleep(2000);
						//Open the Menu Info
						ltp.Open_MenuItem_Info_Screen();
						

						Thread.sleep(1000);
						try
						{
									//Select the Menu Item Name Font
									if(ltp.MenuItem_Name_MenuItemInfo_CheckBox_SLD().isDisplayed())
									{
										test.log(LogStatus.PASS, "Menu Item Name Check Box Selected while Reopening the page After Saved");					
									}
						}
						catch(Exception p)
						{
									test.log(LogStatus.FAIL, "Menu Item Name Check Box not Selected while Reopening the page After Saved");
						}
									
									try
									{
										//Select the Modifiers Font
										if(ltp.Modifiers_MenuItemInfo_CheckBox_SLD().isDisplayed())
										{
											test.log(LogStatus.PASS, "Modifiers Check Box Selected while Reopening the page After Saved");					
										}
									}
									catch(Exception p)
									{
										test.log(LogStatus.FAIL, "Modifiers Check Box not Selected while Reopening the page After Saved");
									ut.FailedCaptureScreenshotAsBASE64(driver, test);
									}
									
									try
									{
										//Select the Menu Item Serving Size Font
										if(ltp.MenuItem_ServingSize_MenuItemInfo_CheckBox_SLD().isDisplayed())
										{
											test.log(LogStatus.PASS, "Menu Item Serving Size Check Box Selected while Reopening the page After Saved");					
										}
									}
									catch(Exception p)
									{
										test.log(LogStatus.FAIL, "Menu Item Serving Size Check Box not Selected while Reopening the page After Saved");
									ut.FailedCaptureScreenshotAsBASE64(driver, test);
									}
									
									try
									{
										//Select the Item Notes Font
										if(ltp.ItemNotes_MenuItemInfo_CheckBox_SLD().isDisplayed())
										{
											test.log(LogStatus.PASS, "Item Notes Check Box Selected while Reopening the page After Saved");					
										}
									}
									catch(Exception p)
									{
										test.log(LogStatus.FAIL, "Item Notes Check Box not Selected while Reopening the page After Saved");
										ut.FailedCaptureScreenshotAsBASE64(driver, test);
									}
						
						try
						{
							//Select the Bottom Divider Font
							if(ltp.BottomDivider_MenuItemInfo_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Bottom Divider Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Bottom Divider Check Box not Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						Thread.sleep(2000);
						//Close the Menu Info
						ltp.Close_MenuItem_Info_Screen();
						
						Thread.sleep(2000);
						//Open Customer Info
						ltp.Open_Customer_Info_Screen();
						
						Thread.sleep(2000);
						try
						{
							//Select the Customer Name
							if(ltp.CustomerName_CustomerInfo_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Customer Name Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Customer Name Check Box not Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
							
						try
						{
							//Select the Customer Address Font
							if(ltp.CustomerAddress_CustomerInfo_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Customer Address Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Customer Address Check Box not Selected while Reopening the page After Saved");
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
							
						try
						{
							//Select the Delivery Notes Font
							if(ltp.DeliveryNotes_CustomerInfo_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Delivery Notes Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception l)
						{
							test.log(LogStatus.FAIL, "Delivery Notes Check Box not Selected while Reopening the page After Saved");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
							
						try
						{
							//Select the Phone Number Font
							if(ltp.PhoneNumber_CustomerInfo_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Phone Number Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Phone Number Check Box not Selected while Reopening the page After Saved");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						
		

						Thread.sleep(1000);
						try
						{
									//Select the Phone Number Font
									if(ltp.RightDivider_CustomerInfo_CheckBox_SLD().isDisplayed())
									{
										test.log(LogStatus.PASS, "Right Divider Check Box Selected while Reopening the page After Saved");					
									}
						}
						catch(Exception p)
						{
								test.log(LogStatus.FAIL, "Right Divider Check Box not Selected while Reopening the page After Saved");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						Thread.sleep(2000);
						//Close Customer Info screen
						ltp.Close_Customer_Info_Screen();
						
						Thread.sleep(2000);
						//Open the Order Summary screen
						ltp.Open_Order_Summary_Screen();
						
						Thread.sleep(1000);
						try
						{
							//Select the Sub Total in Order Summary
							if(ltp.SubTotal_OrderSummary_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Sub Total Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Sub Total Check Box not Selected while Reopening the page After Saved");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Tip in Order Summary
							if(ltp.Tip_OrderSummary_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Tip Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception l)
						{
							test.log(LogStatus.FAIL, "Tip Check Box not Selected while Reopening the page After Saved");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Discounts in Order Summary
							if(ltp.Discounts_OrderSummary_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Discounts Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception l)
						{
							test.log(LogStatus.FAIL, "Discounts Check Box not Selected while Reopening the page After Saved");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Total in Order Summary
							if(ltp.Total_OrderSummary_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Total Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Total Check Box not Selected while Reopening the page After Saved");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Delivery Fee in Order Summary
							if(ltp.DeliveryFee_OrderSummary_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Delivery Fee Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Delivery Fee Check Box not Selected while Reopening the page After Saved");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Balance Due in Order Summary
							if(ltp.BalanceDue_OrderSummary_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Balance Due Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Balance Due Check Box not Selected while Reopening the page After Saved");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}
						
						try
						{
							//Select the Tax in Order Summary
							if(ltp.Tax_OrderSummary_CheckBox_SLD().isDisplayed())
							{
								test.log(LogStatus.PASS, "Tax Check Box Selected while Reopening the page After Saved");					
							}
						}
						catch(Exception p)
						{
							test.log(LogStatus.FAIL, "Tax Check Box not Selected while Reopening the page After Saved");
						ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}


						
						Thread.sleep(2000);
						//Close the Order Summary screen
						ltp.Close_Order_Summary_Screen();
						
				
						Thread.sleep(2000);
						if(cmp.Save_ButtonTwo().isEnabled())
						{
							//Click the Save button
							cmp.Click_Save_ButtonTwo();
							
							Thread.sleep(3000);
							if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Zebra Label Template Saved Successfully"))
							{
								test.log(LogStatus.PASS, "Label Template Saved Successfully for Zebra Label Template");
								
								ut.PassedCaptureScreenshotAsBASE64(driver, test);
							}
							else
							{
								test.log(LogStatus.FAIL, "Label Template Save Failed for Zebra Label Template");
								
								ut.FailedCaptureScreenshotAsBASE64(driver, test);
							}
						}
						
	}

	@Test(priority = 5,enabled = false)
	public void Save_Kitchen_Label_Template_Settings(WebDriver driver) throws Exception
	{
		cmp=new Common_XPaths(driver, test);

		cmp=new Common_XPaths(driver, test);
		ltp=new Label_TemplatePage(driver, test);
		Thread.sleep(2000);
	
		//Click the Kitchen Label Template
		ltp.Click_Kitchen_LabelTemplate();
		
//		test.log(LogStatus.INFO, "Entering width");
	
		//Enter the Width
		ltp.Enter_Width("5");
		
		//Verify whether the Min and Max Error Msg Displayed or not
		ltp.Verify_Width_ErrorMsgTwo();
		
				
		
				//Enter the Width
				ltp.Enter_Height("8");
				
				//Verify whether the Min and Max Error Msg Displayed or not
				ltp.Verify_Height_ErrorMsgTwo();
				
				if(cmp.Save_ButtonTwo().isEnabled())
				{
				//Click the Save button
				cmp.Click_Save_ButtonTwo();
				
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Please Select Valid Width and Height"))
				{
					test.log(LogStatus.PASS, "Please Select Valid Width and Height is Displayed");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Delivery Label Template Saved Successfully"))
				{
					test.log(LogStatus.FAIL, "Label Template Saved with Invalid Width or Height");
			
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Please Select Valid Width and Height is not Displayed");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				}
				else
				{
					test.log(LogStatus.INFO, "Save button not Enabled when Entering Invalid Height and Width");
				}
				
				
				//Enter the Width
				ltp.Enter_Width("4");
				
				//Get the Width
				String Width_Bef=ltp.Width_InputBox().getAttribute("value");
			
				
				//Enter the Width
				ltp.Enter_Height("6");
				
		
		//Get the Height
				String HeightBef=ltp.Height_InputBox().getAttribute("value");
				
				
				Thread.sleep(1000);
				//Select Enable Autocut
				ltp.Select_Enable_Autocut_CheckBox();
				try
				{
					//Check whether the Enable Autocut Disabeld or not
					if(ltp.Enable_Autocut_CheckBox_SLD().isDisplayed())
					{
						test.log(LogStatus.PASS, "Enable Autocut Check Box Enabled while Reopening the page After Saved");					
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.FAIL, "Enable AutocutCheck Box not Enabled while Reopening the page After Saved");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				
				for(int i=1;i<=3;i++)
				{
					driver.findElement(By.tagName("html")).sendKeys(Keys.DOWN);
				}
				
				Thread.sleep(1000);
				//Click Font Options Down Right arrow
				ltp.Open_CheckDetails_Screen();
				
				
				try
				{
					//Select the Date & Time Font
					if(ltp.Date_Time_CheckDetails_CheckBox_SLD().isDisplayed())
					{
						ltp.Date_Time_CheckDetails_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				try
				{
					//Select the Sale Number
					if(ltp.SaleNumber_KitchenLabel_CheckBox_SLD().isDisplayed())
					{
						ltp.SaleNumber_KitchenLabel_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				try
				{
					//Select the Order Number Font
					if(ltp.OrderNumber_KitchenLabel_CheckBox_SLD().isDisplayed())
					{
						ltp.OrderNumber_KitchenLabel_CheckBox().click();
					}
				}
				catch(Exception p) {}

				try
				{
					//Select the Customer Name Font
					if(ltp.CustomerName_CustomerInfo_CheckBox_SLD().isDisplayed())
					{
						ltp.CustomerName_CustomerInfo_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				try
				{
					//Select the Order Type Font
					if(ltp.Order_Type_CheckDetails_CheckBox_SLD().isDisplayed())
					{
						ltp.Order_Type_CheckDetails_CheckBox().click();
					}
				}
				catch(Exception p) {}
				
				
			
				Thread.sleep(1000);
				//Select the Font for Check Details
				ltp.Select_CheckDetails_Font_Option();
				
				//Get the Check Details Font Name
				String Check_DetailsFont_KitcLblBef=ltp.CheckDetails_Font_Option().getAttribute("value");
				
				try
				{
					//Select the Bottom Divider Check box in Check Details screen
					if(ltp.BottomDivider_MenuItemInfo_CheckBox_SLD().isDisplayed())
					{
						ltp.BottomDivider_MenuItemInfo_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				Thread.sleep(1000);
				//Close the Check Details screen
				ltp.Close_CheckDetails_Screen();
				
				Thread.sleep(1000);
				//Open Menu Info Screen
				ltp.Open_MenuItem_Info_Screen();
				
				Thread.sleep(1000);
				//Select Body Font Size
				ltp.Select_Item_Name_FontSize_KitchenLabel_Font_Option();
				
				//Get the Business Name
				String BodyFontSize_MenuInfo_KitcLblBef=ltp.Item_Name_FontSize_KitchenLabelInputBox().getAttribute("value");
				
				//Select Title Font Size
				ltp.Select_Modifiers_FontSize_KitchenLabel_Font_Option();
				
				//Get the Business Name
				String TitleFontSize_MenuInfo_KitcLeblBef=ltp.Modifiers_FontSize_KitchenLabel_Font_Option().getAttribute("value");
				
				try
				{
					//Select the Menu Item Name Bottom Divider
					if(ltp.MenuItem_Name_BottomDivider_KitchenLabel_CheckBox_SLD().isDisplayed())
					{
						ltp.MenuItem_Name_BottomDivider_KitchenLabel_CheckBox().click();
					}
				}
				catch(Exception l) {}
				
				//Close Menu Info screen
				ltp.Close_MenuItem_Info_Screen();
				
				Thread.sleep(1000);
				//Click the Save button
				cmp.Click_Save_ButtonTwo();
				
				Thread.sleep(3000);
				//Check whether the Label Template Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Kitchen Label Template Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Label Template Saved Successfully for Kitchen Label Template (Selecting Font & Disable All Check)");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Label Template Save Failed for Kitchen Label Template (Selecting Font & Disable All Check)");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				
				
				Thread.sleep(1000);
				//Click the Epson Box
				ltp.Click_EpsonBox_LabelTemplate();
				
				//Click the Zebra Template
				ltp.Click_Zebra_LabelTemplate();
				
				
				
				Thread.sleep(2000);
				//Navigate to Back
//				driver.navigate().back();
				
				driver.navigate().refresh();
				Thread.sleep(5000);
				//Navigate to Forward
//				driver.navigate().forward();
				
				//Click Kitchen Label Template
				ltp.Click_Kitchen_LabelTemplate();
				
				
				Thread.sleep(2000);
				try
				{
					//Check whether the Enable Autocut Disabeld or not
					if(ltp.Enable_Autocut_CheckBox_SLD().isDisplayed())
					{
						test.log(LogStatus.PASS, "Enable Autocut Check Box Selected while Reopening the page After Saved");					
					}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Enable AutocutCheck Box not Selected while Reopening the page After Saved");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Get the Width
				String Width_Aft=ltp.Width_InputBox().getAttribute("value");
				
				//Check whether the Width Updated or not
				if(Width_Bef.equals(Width_Aft))
				{
					test.log(LogStatus.PASS, "Width Not Changed After Reopen the Page");
				}
				else
				{
					test.log(LogStatus.FAIL, "Width Changed After Reopen the Page");
				}
				
				//Get the Height
				String HeightAft=ltp.Height_InputBox().getAttribute("value");
				
				//Check whether the Template Updated or not
				if(HeightBef.equals(HeightAft))
				{
					test.log(LogStatus.PASS, "Height Not Changed After Reopen the Page");
				}
				else
				{
					test.log(LogStatus.FAIL, "Height Changed After Reopen the Page");
				}
				
				
				
				//Click the Check Details
				ltp.Open_CheckDetails_Screen();
				
				
				Thread.sleep(1000);
				try
				{
					//Select the Date & Time in Kitchen Label
					if(ltp.Date_Time_CheckDetails_CheckBox_SLD1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Date & Time Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Date & Time
							ltp.Date_Time_CheckDetails_CheckBox().click();
					}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Date & Time Check Box Selected while Reopening the page After Saved");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			
				try
				{
					//Select the Sale Number
					if(ltp.SaleNumber_KitchenLabel_CheckBox_SLD1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Sale Number Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Sale Number
							ltp.SaleNumber_KitchenLabel_CheckBox().click();
						
					}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Sale Number Check Box Selected while Reopening the page After Saved");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				try
				{
					//Select the Order Number in Kitchen Label
					if(ltp.OrderNumber_KitchenLabel_CheckBox_SLD1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Order Number Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Order Number
							ltp.OrderNumber_KitchenLabel_CheckBox().click();
					}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Order Number Check Box Selected while Reopening the page After Saved");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			
				try
				{
					//Select the Customer Name
					if(ltp.CustomerName_CustomerInfo_CheckBox_SLD1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Customer Name Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Customer Name
							ltp.CustomerName_CustomerInfo_CheckBox().click();
					}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Customer Name Check Box Selected while Reopening the page After Saved");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				driver.findElement(By.tagName("html")).sendKeys(Keys.ARROW_DOWN);
				try
				{
					//Select the Order Type
					if(ltp.Order_Type_CheckDetails_CheckBox_SLD1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Order Type Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Order Type
							ltp.Order_Type_CheckDetails_CheckBox().click();
					
					}
				}
				catch(Exception l)
				{

					test.log(LogStatus.FAIL, "Order Type Check Box Selected while Reopening the page After Saved");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				//Get the Check Details Font Name
				String Check_DetailsFont_KitcLblAft=ltp.CheckDetails_Font_Option().getAttribute("value");
			
				//Check whether the Check Details font Updated or not
				if(Check_DetailsFont_KitcLblBef.equals(Check_DetailsFont_KitcLblAft))
				{
					test.log(LogStatus.PASS, "Check Details Font in Kitchen Template Not Changed After Reopen the Page");
				}
				else
				{
					test.log(LogStatus.FAIL, "Check Details Font in Kitchen Template Changed After Reopen the Page");
				}
				
				Thread.sleep(1000);
				try
				{
					//Select the Bottom Divider
					if(ltp.BottomDivider_MenuItemInfo_CheckBox_SLD1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Bottom Divider Check Box not Selected while Reopening the page After Saved");					
					
						//Enable Order Type
						ltp.Order_Type_CheckDetails_CheckBox().click();
					}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Bottom Divider Check Box Selected while Reopening the page After Saved");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				Thread.sleep(1000);
				//Close Check Details screen
				ltp.Close_CheckDetails_Screen();
				
				Thread.sleep(1000);
				//Open Menu Info Screen
				ltp.Open_MenuItem_Info_Screen();
				
				//Get the Body Font Size
				String BodyFontSize_MenuInfo_KitcLblAft=ltp.Item_Name_FontSize_KitchenLabelInputBox().getAttribute("value");
				
				//Check whether the Body font size Updated or not
				if(BodyFontSize_MenuInfo_KitcLblBef.equals(BodyFontSize_MenuInfo_KitcLblAft))
				{
					test.log(LogStatus.PASS, "Body Font Size in Kitchen Template Not Changed After Reopen the Page");
				}
				else
				{
					test.log(LogStatus.FAIL, "Body Font Size in Kitchen Template Changed After Reopen the Page");
				}
				
				//Get the Business Name
				String TitleFontSize_MenuInfo_KitcLeblAft=ltp.Modifiers_FontSize_KitchenLabel_Font_Option().getAttribute("value");
				
				//Check whether the Title font Size Updated or not
				if(Check_DetailsFont_KitcLblBef.equals(Check_DetailsFont_KitcLblAft))
				{
					test.log(LogStatus.PASS, "Title Font Size in Kitchen Template Not Changed After Reopen the Page");
				}
				else
				{
					test.log(LogStatus.FAIL, "Title Font Size in Kitchen Template Changed After Reopen the Page");
				}
				
				
				
				Thread.sleep(1000);
				try
				{
					//Select the Menu Item Name Bottom Divider
					if(ltp.MenuItem_Name_BottomDivider_KitchenLabel_CheckBox_SLD1().isDisplayed())
					{
						test.log(LogStatus.PASS, "Menu Item Name Bottom Divider Check Box not Selected while Reopening the page After Saved");					
						
						//Enable Order Type
							ltp.MenuItem_Name_BottomDivider_KitchenLabel_CheckBox().click();
					}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Menu Item Name Bottom Divider Check Box Selected while Reopening the page After Saved");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				
				//Close Menu Info Screen
				ltp.Close_MenuItem_Info_Screen();
				
				
				//Click the Save button
				cmp.Click_Save_ButtonTwo();
				
				//Verify whether the Label Template Saved or not
				if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Kitchen Label Template Saved Successfully"))
				{
					test.log(LogStatus.PASS, "Label Template Saved Successfully for Kitchen Label Template (Enabled All)");
					
					ut.PassedCaptureScreenshotAsBASE64(driver, test);
				}
				else
				{
					test.log(LogStatus.FAIL, "Label Template Save Failed for Kitchen Label Template (Enabled All)");
					
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				Thread.sleep(2000);
				//driver.navigate().refresh();
				
				Thread.sleep(5000);
				
				//Open Check Details screen
				ltp.Open_CheckDetails_Screen();
				
				Thread.sleep(1000);
				try
				{
					//Select the Date & Time in Kitchen Label
					if(ltp.Date_Time_CheckDetails_CheckBox_SLD().isDisplayed())
					{
						test.log(LogStatus.PASS, "Date & Time Check Box Selected while Reopening the page After Saved");					
					}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Date & Time Check Box not Selected while Reopening the page After Saved");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			
				try
				{
					//Select the Sale Number
					if(ltp.SaleNumber_KitchenLabel_CheckBox_SLD().isDisplayed())
					{
						test.log(LogStatus.PASS, "Sale Number Check Box Selected while Reopening the page After Saved");					
	
					}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Sale Number Check Box not Selected while Reopening the page After Saved");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				try
				{
					//Select the Order Number in Kitchen Label
					if(ltp.OrderNumber_KitchenLabel_CheckBox_SLD().isDisplayed())
					{
						test.log(LogStatus.PASS, "Order Number Check Box Selected while Reopening the page After Saved");					
		
					}
				}
				catch(Exception l)
				{
					test.log(LogStatus.FAIL, "Order Number Check Box not Selected while Reopening the page After Saved");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
			
				try
				{
					//Select the Customer Name
					if(ltp.CustomerName_CustomerInfo_CheckBox_SLD().isDisplayed())
					{
						test.log(LogStatus.PASS, "Customer Name Check Box Selected while Reopening the page After Saved");					
			
					}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Customer Name Check Box not Selected while Reopening the page After Saved");
					ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				try
				{
					//Select the Order Type
					if(ltp.Order_Type_CheckDetails_CheckBox_SLD().isDisplayed())
					{
						test.log(LogStatus.PASS, "Order Type Check Box Selected while Reopening the page After Saved");					
	
					}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Order Type Check Box not Selected while Reopening the page After Saved");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				try
				{
					//Select the Bottom Divider
					if(ltp.BottomDivider_MenuItemInfo_CheckBox_SLD().isDisplayed())
					{
						test.log(LogStatus.PASS, "Bottom Divider Check Box Selected while Reopening the page After Saved");					
			
					}
				}
				catch(Exception p)
				{
					test.log(LogStatus.FAIL, "Bottom Divider Check Box not Selected while Reopening the page After Saved");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				try
				{
					//Select the Bottom Divider
					if(ltp.MenuItem_Name_BottomDivider_KitchenLabel_CheckBox_SLD().isDisplayed())
					{
						test.log(LogStatus.PASS, "Menu Item Name Bottom Divider Check Box Selected while Reopening the page After Saved");					
		
					}
				}
				catch(Exception k)
				{
					test.log(LogStatus.FAIL, "Menu Item Name Bottom Divider Check Box not Selected while Reopening the page After Saved");
				ut.FailedCaptureScreenshotAsBASE64(driver, test);
				}
				
				//Close Menu Info Screen
				ltp.Close_MenuItem_Info_Screen();
				
				Thread.sleep(2000);
				if(cmp.Save_ButtonTwo().isEnabled())
				{
						//Click the Save button
						cmp.Click_Save_ButtonTwo();
						
						Thread.sleep(3000);
						//Verify whether the Label Template Saved or not 
						if(cmp.ConfirmationAlertMsg().getText().equalsIgnoreCase("Kitchen Label Template Saved Successfully"))
						{
							test.log(LogStatus.PASS, "Label Template Saved Successfully for Kitchen Label Template");
							
							ut.PassedCaptureScreenshotAsBASE64(driver, test);
						}
						else
						{
							test.log(LogStatus.FAIL, "Label Template Save Failed for Kitchen Label Template");
							
							ut.FailedCaptureScreenshotAsBASE64(driver, test);
						}					
				}		
	}
}
